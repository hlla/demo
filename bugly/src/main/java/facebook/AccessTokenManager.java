/*     */ package com.facebook;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.os.Bundle;
/*     */ import android.os.Handler;
/*     */ import android.os.Looper;
/*     */ import android.support.v4.content.LocalBroadcastManager;
/*     */ import android.util.Log;
/*     */ import com.facebook.internal.Utility;
/*     */ import com.facebook.internal.Validate;
/*     */ import java.util.Date;
/*     */ import java.util.HashSet;
/*     */ import java.util.Locale;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import org.json.JSONArray;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class AccessTokenManager
/*     */ {
/*     */   static final String TAG = "AccessTokenManager";
/*     */   static final String ACTION_CURRENT_ACCESS_TOKEN_CHANGED = "com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED";
/*     */   static final String EXTRA_OLD_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN";
/*     */   static final String EXTRA_NEW_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN";
/*     */   static final String SHARED_PREFERENCES_NAME = "com.facebook.AccessTokenManager.SharedPreferences";
/*     */   private static final int TOKEN_EXTEND_THRESHOLD_SECONDS = 86400;
/*     */   private static final int TOKEN_EXTEND_RETRY_SECONDS = 3600;
/*     */   private static final String TOKEN_EXTEND_GRAPH_PATH = "oauth/access_token";
/*     */   private static final String ME_PERMISSIONS_GRAPH_PATH = "me/permissions";
/*     */   private static volatile AccessTokenManager instance;
/*     */   private final LocalBroadcastManager localBroadcastManager;
/*     */   private final AccessTokenCache accessTokenCache;
/*     */   private AccessToken currentAccessToken;
/*  67 */   private AtomicBoolean tokenRefreshInProgress = new AtomicBoolean(false);
/*  68 */   private Date lastAttemptedTokenExtendDate = new Date(0L);
/*     */   
/*     */ 
/*     */   AccessTokenManager(LocalBroadcastManager localBroadcastManager, AccessTokenCache accessTokenCache)
/*     */   {
/*  73 */     Validate.notNull(localBroadcastManager, "localBroadcastManager");
/*  74 */     Validate.notNull(accessTokenCache, "accessTokenCache");
/*     */     
/*  76 */     this.localBroadcastManager = localBroadcastManager;
/*  77 */     this.accessTokenCache = accessTokenCache;
/*     */   }
/*     */   
/*     */   static AccessTokenManager getInstance() {
/*  81 */     if (instance == null) {
/*  82 */       synchronized (AccessTokenManager.class) {
/*  83 */         if (instance == null) {
/*  84 */           Context applicationContext = FacebookSdk.getApplicationContext();
/*  85 */           LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(applicationContext);
/*     */           
/*  87 */           AccessTokenCache accessTokenCache = new AccessTokenCache();
/*     */           
/*  89 */           instance = new AccessTokenManager(localBroadcastManager, accessTokenCache);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  94 */     return instance;
/*     */   }
/*     */   
/*     */   AccessToken getCurrentAccessToken() {
/*  98 */     return this.currentAccessToken;
/*     */   }
/*     */   
/*     */   boolean loadCurrentAccessToken() {
/* 102 */     AccessToken accessToken = this.accessTokenCache.load();
/*     */     
/* 104 */     if (accessToken != null) {
/* 105 */       setCurrentAccessToken(accessToken, false);
/* 106 */       return true;
/*     */     }
/*     */     
/* 109 */     return false;
/*     */   }
/*     */   
/*     */   void setCurrentAccessToken(AccessToken currentAccessToken) {
/* 113 */     setCurrentAccessToken(currentAccessToken, true);
/*     */   }
/*     */   
/*     */   private void setCurrentAccessToken(AccessToken currentAccessToken, boolean saveToCache) {
/* 117 */     AccessToken oldAccessToken = this.currentAccessToken;
/* 118 */     this.currentAccessToken = currentAccessToken;
/* 119 */     this.tokenRefreshInProgress.set(false);
/* 120 */     this.lastAttemptedTokenExtendDate = new Date(0L);
/*     */     
/* 122 */     if (saveToCache) {
/* 123 */       if (currentAccessToken != null) {
/* 124 */         this.accessTokenCache.save(currentAccessToken);
/*     */       } else {
/* 126 */         this.accessTokenCache.clear();
/* 127 */         Utility.clearFacebookCookies(FacebookSdk.getApplicationContext());
/*     */       }
/*     */     }
/*     */     
/* 131 */     if (!Utility.areObjectsEqual(oldAccessToken, currentAccessToken)) {
/* 132 */       sendCurrentAccessTokenChangedBroadcast(oldAccessToken, currentAccessToken);
/*     */     }
/*     */   }
/*     */   
/*     */   private void sendCurrentAccessTokenChangedBroadcast(AccessToken oldAccessToken, AccessToken currentAccessToken)
/*     */   {
/* 138 */     Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
/*     */     
/* 140 */     intent.putExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN", oldAccessToken);
/* 141 */     intent.putExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN", currentAccessToken);
/*     */     
/* 143 */     this.localBroadcastManager.sendBroadcast(intent);
/*     */   }
/*     */   
/*     */   void extendAccessTokenIfNeeded() {
/* 147 */     if (!shouldExtendAccessToken()) {
/* 148 */       return;
/*     */     }
/* 150 */     refreshCurrentAccessToken(null);
/*     */   }
/*     */   
/*     */   private boolean shouldExtendAccessToken() {
/* 154 */     if (this.currentAccessToken == null) {
/* 155 */       return false;
/*     */     }
/* 157 */     Long now = Long.valueOf(new Date().getTime());
/*     */     
/*     */ 
/*     */ 
/* 161 */     return (this.currentAccessToken.getSource().canExtendToken()) && (now.longValue() - this.lastAttemptedTokenExtendDate.getTime() > 3600000L) && (now.longValue() - this.currentAccessToken.getLastRefresh().getTime() > 86400000L);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static GraphRequest createGrantedPermissionsRequest(AccessToken accessToken, GraphRequest.Callback callback)
/*     */   {
/* 169 */     Bundle parameters = new Bundle();
/* 170 */     return new GraphRequest(accessToken, "me/permissions", parameters, HttpMethod.GET, callback);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static GraphRequest createExtendAccessTokenRequest(AccessToken accessToken, GraphRequest.Callback callback)
/*     */   {
/* 182 */     Bundle parameters = new Bundle();
/* 183 */     parameters.putString("grant_type", "fb_extend_sso_token");
/* 184 */     return new GraphRequest(accessToken, "oauth/access_token", parameters, HttpMethod.GET, callback);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void refreshCurrentAccessToken(final AccessToken.AccessTokenRefreshCallback callback)
/*     */   {
/* 198 */     if (Looper.getMainLooper().equals(Looper.myLooper())) {
/* 199 */       refreshCurrentAccessTokenImpl(callback);
/*     */     } else {
/* 201 */       Handler mainHandler = new Handler(Looper.getMainLooper());
/* 202 */       mainHandler.post(new Runnable()
/*     */       {
/*     */         public void run() {
/* 205 */           AccessTokenManager.this.refreshCurrentAccessTokenImpl(callback);
/*     */         }
/*     */       });
/*     */     }
/*     */   }
/*     */   
/*     */   private void refreshCurrentAccessTokenImpl(final AccessToken.AccessTokenRefreshCallback callback)
/*     */   {
/* 213 */     final AccessToken accessToken = this.currentAccessToken;
/* 214 */     if (accessToken == null) {
/* 215 */       if (callback != null) {
/* 216 */         callback.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
/*     */       }
/*     */       
/* 219 */       return;
/*     */     }
/* 221 */     if (!this.tokenRefreshInProgress.compareAndSet(false, true)) {
/* 222 */       if (callback != null) {
/* 223 */         callback.OnTokenRefreshFailed(new FacebookException("Refresh already in progress"));
/*     */       }
/*     */       
/* 226 */       return;
/*     */     }
/*     */     
/* 229 */     this.lastAttemptedTokenExtendDate = new Date();
/*     */     
/* 231 */     final Set<String> permissions = new HashSet();
/* 232 */     final Set<String> declinedPermissions = new HashSet();
/* 233 */     final AtomicBoolean permissionsCallSucceeded = new AtomicBoolean(false);
/* 234 */     final RefreshResult refreshResult = new RefreshResult(null);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 270 */     GraphRequestBatch batch = new GraphRequestBatch(new GraphRequest[] {createGrantedPermissionsRequest(accessToken, new GraphRequest.Callback()
/*     */     {
/*     */       public void onCompleted(GraphResponse response)
/*     */       {
/* 240 */         JSONObject result = response.getJSONObject();
/* 241 */         if (result == null) {
/* 242 */           return;
/*     */         }
/* 244 */         JSONArray permissionsArray = result.optJSONArray("data");
/* 245 */         if (permissionsArray == null) {
/* 246 */           return;
/*     */         }
/* 248 */         permissionsCallSucceeded.set(true);
/* 249 */         for (int i = 0; i < permissionsArray.length(); i++) {
/* 250 */           JSONObject permissionEntry = permissionsArray.optJSONObject(i);
/* 251 */           if (permissionEntry != null)
/*     */           {
/*     */ 
/* 254 */             String permission = permissionEntry.optString("permission");
/* 255 */             String status = permissionEntry.optString("status");
/* 256 */             if ((!Utility.isNullOrEmpty(permission)) && 
/* 257 */               (!Utility.isNullOrEmpty(status))) {
/* 258 */               status = status.toLowerCase(Locale.US);
/* 259 */               if (status.equals("granted")) {
/* 260 */                 permissions.add(permission);
/* 261 */               } else if (status.equals("declined")) {
/* 262 */                 declinedPermissions.add(permission);
/*     */               } else {
/* 264 */                 Log.w("AccessTokenManager", "Unexpected status: " + status);
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/* 270 */     }), createExtendAccessTokenRequest(accessToken, new GraphRequest.Callback()
/*     */     {
/*     */       public void onCompleted(GraphResponse response) {
/* 273 */         JSONObject data = response.getJSONObject();
/* 274 */         if (data == null) {
/* 275 */           return;
/*     */         }
/* 277 */         refreshResult.accessToken = data.optString("access_token");
/* 278 */         refreshResult.expiresAt = data.optInt("expires_at");
/*     */       }
/*     */       
/*     */ 
/* 282 */     }) });
/* 283 */     batch.addCallback(new GraphRequestBatch.Callback()
/*     */     {
/*     */       public void onBatchCompleted(GraphRequestBatch batch) {
/* 286 */         AccessToken newAccessToken = null;
/*     */         try {
/* 288 */           if ((AccessTokenManager.getInstance().getCurrentAccessToken() == null) || 
/*     */           
/* 290 */             (AccessTokenManager.getInstance().getCurrentAccessToken().getUserId() != accessToken.getUserId())) {
/* 291 */             if (callback != null) {
/* 292 */               callback.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
/*     */             }
/*     */             
/* 295 */             return;
/*     */           }
/* 297 */           if ((!permissionsCallSucceeded.get()) && (refreshResult.accessToken == null) && (refreshResult.expiresAt == 0))
/*     */           {
/*     */ 
/* 300 */             if (callback != null) {
/* 301 */               callback.OnTokenRefreshFailed(new FacebookException("Failed to refresh access token"));
/*     */             }
/*     */             
/* 304 */             return;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 318 */           newAccessToken = new AccessToken(refreshResult.accessToken != null ? refreshResult.accessToken : accessToken.getToken(), accessToken.getApplicationId(), accessToken.getUserId(), permissionsCallSucceeded.get() ? permissions : accessToken.getPermissions(), permissionsCallSucceeded.get() ? declinedPermissions : accessToken.getDeclinedPermissions(), accessToken.getSource(), refreshResult.expiresAt != 0 ? new Date(refreshResult.expiresAt * 1000L) : accessToken.getExpires(), new Date());
/*     */           
/*     */ 
/* 321 */           AccessTokenManager.getInstance().setCurrentAccessToken(newAccessToken);
/*     */         } finally {
/* 323 */           AccessTokenManager.this.tokenRefreshInProgress.set(false);
/* 324 */           if ((callback != null) && (newAccessToken != null)) {
/* 325 */             callback.OnTokenRefreshed(newAccessToken);
/*     */           }
/*     */         }
/*     */       }
/* 329 */     });
/* 330 */     batch.executeAsync();
/*     */   }
/*     */   
/*     */   private static class RefreshResult
/*     */   {
/*     */     public String accessToken;
/*     */     public int expiresAt;
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/AccessTokenManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */