/*     */ package com.facebook;
/*     */ 
/*     */ import android.annotation.SuppressLint;
/*     */ import android.content.Intent;
/*     */ import android.os.Bundle;
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
/*     */ import android.os.Parcelable.Creator;
/*     */ import android.support.annotation.Nullable;
/*     */ import android.text.TextUtils;
/*     */ import com.facebook.internal.Utility;
/*     */ import com.facebook.internal.Utility.GraphMeRequestWithCacheCallback;
/*     */ import com.facebook.internal.Validate;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.json.JSONArray;
/*     */ import org.json.JSONException;
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
/*     */ public final class AccessToken
/*     */   implements Parcelable
/*     */ {
/*     */   public static final String ACCESS_TOKEN_KEY = "access_token";
/*     */   public static final String EXPIRES_IN_KEY = "expires_in";
/*     */   public static final String USER_ID_KEY = "user_id";
/*  58 */   private static final Date MAX_DATE = new Date(Long.MAX_VALUE);
/*  59 */   private static final Date DEFAULT_EXPIRATION_TIME = MAX_DATE;
/*  60 */   private static final Date DEFAULT_LAST_REFRESH_TIME = new Date();
/*  61 */   private static final AccessTokenSource DEFAULT_ACCESS_TOKEN_SOURCE = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
/*     */   
/*     */ 
/*     */ 
/*     */   private static final int CURRENT_JSON_FORMAT = 1;
/*     */   
/*     */ 
/*     */ 
/*     */   private static final String VERSION_KEY = "version";
/*     */   
/*     */ 
/*     */ 
/*     */   private static final String EXPIRES_AT_KEY = "expires_at";
/*     */   
/*     */ 
/*     */ 
/*     */   private static final String PERMISSIONS_KEY = "permissions";
/*     */   
/*     */ 
/*     */ 
/*     */   private static final String DECLINED_PERMISSIONS_KEY = "declined_permissions";
/*     */   
/*     */ 
/*     */ 
/*     */   private static final String TOKEN_KEY = "token";
/*     */   
/*     */ 
/*     */   private static final String SOURCE_KEY = "source";
/*     */   
/*     */ 
/*     */   private static final String LAST_REFRESH_KEY = "last_refresh";
/*     */   
/*     */ 
/*     */   private static final String APPLICATION_ID_KEY = "application_id";
/*     */   
/*     */ 
/*     */   private final Date expires;
/*     */   
/*     */ 
/*     */   private final Set<String> permissions;
/*     */   
/*     */ 
/*     */   private final Set<String> declinedPermissions;
/*     */   
/*     */ 
/*     */   private final String token;
/*     */   
/*     */ 
/*     */   private final AccessTokenSource source;
/*     */   
/*     */ 
/*     */   private final Date lastRefresh;
/*     */   
/*     */ 
/*     */   private final String applicationId;
/*     */   
/*     */ 
/*     */   private final String userId;
/*     */   
/*     */ 
/*     */ 
/*     */   public AccessToken(String accessToken, String applicationId, String userId, @Nullable Collection<String> permissions, @Nullable Collection<String> declinedPermissions, @Nullable AccessTokenSource accessTokenSource, @Nullable Date expirationTime, @Nullable Date lastRefreshTime)
/*     */   {
/* 124 */     Validate.notNullOrEmpty(accessToken, "accessToken");
/* 125 */     Validate.notNullOrEmpty(applicationId, "applicationId");
/* 126 */     Validate.notNullOrEmpty(userId, "userId");
/*     */     
/* 128 */     this.expires = (expirationTime != null ? expirationTime : DEFAULT_EXPIRATION_TIME);
/* 129 */     this.permissions = Collections.unmodifiableSet(permissions != null ? new HashSet(permissions) : new HashSet());
/*     */     
/* 131 */     this.declinedPermissions = Collections.unmodifiableSet(declinedPermissions != null ? new HashSet(declinedPermissions) : new HashSet());
/*     */     
/*     */ 
/*     */ 
/* 135 */     this.token = accessToken;
/* 136 */     this.source = (accessTokenSource != null ? accessTokenSource : DEFAULT_ACCESS_TOKEN_SOURCE);
/* 137 */     this.lastRefresh = (lastRefreshTime != null ? lastRefreshTime : DEFAULT_LAST_REFRESH_TIME);
/* 138 */     this.applicationId = applicationId;
/* 139 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static AccessToken getCurrentAccessToken()
/*     */   {
/* 148 */     return AccessTokenManager.getInstance().getCurrentAccessToken();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setCurrentAccessToken(AccessToken accessToken)
/*     */   {
/* 157 */     AccessTokenManager.getInstance().setCurrentAccessToken(accessToken);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void refreshCurrentAccessTokenAsync()
/*     */   {
/* 165 */     AccessTokenManager.getInstance().refreshCurrentAccessToken(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void refreshCurrentAccessTokenAsync(AccessTokenRefreshCallback callback)
/*     */   {
/* 174 */     AccessTokenManager.getInstance().refreshCurrentAccessToken(callback);
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
/*     */   public String getToken()
/*     */   {
/* 188 */     return this.token;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getExpires()
/*     */   {
/* 197 */     return this.expires;
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
/*     */   public Set<String> getPermissions()
/*     */   {
/* 211 */     return this.permissions;
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
/*     */   public Set<String> getDeclinedPermissions()
/*     */   {
/* 224 */     return this.declinedPermissions;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public AccessTokenSource getSource()
/*     */   {
/* 233 */     return this.source;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getLastRefresh()
/*     */   {
/* 243 */     return this.lastRefresh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getApplicationId()
/*     */   {
/* 252 */     return this.applicationId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUserId()
/*     */   {
/* 261 */     return this.userId;
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
/*     */   public static void createFromNativeLinkingIntent(Intent intent, final String applicationId, final AccessTokenCreationCallback accessTokenCallback)
/*     */   {
/* 290 */     Validate.notNull(intent, "intent");
/* 291 */     if (intent.getExtras() == null) {
/* 292 */       accessTokenCallback.onError(new FacebookException("No extras found on intent"));
/*     */       
/* 294 */       return;
/*     */     }
/* 296 */     Bundle extras = new Bundle(intent.getExtras());
/*     */     
/* 298 */     String accessToken = extras.getString("access_token");
/* 299 */     if ((accessToken == null) || (accessToken.isEmpty())) {
/* 300 */       accessTokenCallback.onError(new FacebookException("No access token found on intent"));
/* 301 */       return;
/*     */     }
/*     */     
/* 304 */     String userId = extras.getString("user_id");
/*     */     
/* 306 */     if ((userId == null) || (userId.isEmpty())) {
/* 307 */       Utility.getGraphMeRequestWithCacheAsync(accessToken, new GraphMeRequestWithCacheCallback()
/*     */       {
/*     */         public void onSuccess(JSONObject userInfo)
/*     */         {
/*     */           try {
/* 312 */             String userId = userInfo.getString("id");
/* 313 */             this.val$extras.putString("user_id", userId);
/* 314 */             accessTokenCallback.onSuccess(AccessToken.createFromBundle(null, this.val$extras, AccessTokenSource.FACEBOOK_APPLICATION_WEB, new Date(), applicationId));
/*     */ 
/*     */ 
/*     */           }
/*     */           catch (JSONException ex)
/*     */           {
/*     */ 
/* 321 */             accessTokenCallback.onError(new FacebookException("Unable to generate access token due to missing user id"));
/*     */           }
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */         public void onFailure(FacebookException error)
/*     */         {
/* 330 */           accessTokenCallback.onError(error);
/*     */         }
/*     */       });
/*     */     } else {
/* 334 */       accessTokenCallback.onSuccess(createFromBundle(null, extras, AccessTokenSource.FACEBOOK_APPLICATION_WEB, new Date(), applicationId));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String toString()
/*     */   {
/* 345 */     StringBuilder builder = new StringBuilder();
/*     */     
/* 347 */     builder.append("{AccessToken");
/* 348 */     builder.append(" token:").append(tokenToString());
/* 349 */     appendPermissions(builder);
/* 350 */     builder.append("}");
/*     */     
/* 352 */     return builder.toString();
/*     */   }
/*     */   
/*     */   public boolean equals(Object other)
/*     */   {
/* 357 */     if (this == other) {
/* 358 */       return true;
/*     */     }
/*     */     
/* 361 */     if (!(other instanceof AccessToken)) {
/* 362 */       return false;
/*     */     }
/*     */     
/* 365 */     AccessToken o = (AccessToken)other;
/*     */     
/* 367 */     if ((this.expires.equals(o.expires)) && 
/* 368 */       (this.permissions.equals(o.permissions)) && 
/* 369 */       (this.declinedPermissions.equals(o.declinedPermissions)) && 
/* 370 */       (this.token.equals(o.token)) && (this.source == o.source)) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 376 */     return (this.lastRefresh.equals(o.lastRefresh)) && (this.applicationId == null ? o.applicationId == null : this.applicationId.equals(o.applicationId)) && (this.userId.equals(o.userId));
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 381 */     int result = 17;
/*     */     
/* 383 */     result = result * 31 + this.expires.hashCode();
/* 384 */     result = result * 31 + this.permissions.hashCode();
/* 385 */     result = result * 31 + this.declinedPermissions.hashCode();
/* 386 */     result = result * 31 + this.token.hashCode();
/* 387 */     result = result * 31 + this.source.hashCode();
/* 388 */     result = result * 31 + this.lastRefresh.hashCode();
/* 389 */     result = result * 31 + (this.applicationId == null ? 0 : this.applicationId.hashCode());
/* 390 */     result = result * 31 + this.userId.hashCode();
/*     */     
/* 392 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   @SuppressLint({"FieldGetter"})
/*     */   static AccessToken createFromRefresh(AccessToken current, Bundle bundle)
/*     */   {
/* 399 */     if ((current.source != AccessTokenSource.FACEBOOK_APPLICATION_WEB) && (current.source != AccessTokenSource.FACEBOOK_APPLICATION_NATIVE) && (current.source != AccessTokenSource.FACEBOOK_APPLICATION_SERVICE))
/*     */     {
/*     */ 
/* 402 */       throw new FacebookException("Invalid token source: " + current.source);
/*     */     }
/*     */     
/* 405 */     Date expires = Utility.getBundleLongAsDate(bundle, "expires_in", new Date(0L));
/* 406 */     String token = bundle.getString("access_token");
/*     */     
/* 408 */     if (Utility.isNullOrEmpty(token)) {
/* 409 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 416 */     return new AccessToken(token, current.applicationId, current.getUserId(), current.getPermissions(), current.getDeclinedPermissions(), current.source, expires, new Date());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static AccessToken createFromLegacyCache(Bundle bundle)
/*     */   {
/* 423 */     List<String> permissions = getPermissionsFromBundle(bundle, "com.facebook.TokenCachingStrategy.Permissions");
/*     */     
/*     */ 
/* 426 */     List<String> declinedPermissions = getPermissionsFromBundle(bundle, "com.facebook.TokenCachingStrategy.DeclinedPermissions");
/*     */     
/*     */ 
/*     */ 
/* 430 */     String applicationId = LegacyTokenHelper.getApplicationId(bundle);
/* 431 */     if (Utility.isNullOrEmpty(applicationId)) {
/* 432 */       applicationId = FacebookSdk.getApplicationId();
/*     */     }
/*     */     
/* 435 */     String tokenString = LegacyTokenHelper.getToken(bundle);
/*     */     
/* 437 */     JSONObject userInfo = Utility.awaitGetGraphMeRequestWithCache(tokenString);
/*     */     try {
/* 439 */       userId = userInfo.getString("id");
/*     */     }
/*     */     catch (JSONException ex) {
/*     */       String userId;
/* 443 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     String userId;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 456 */     return new AccessToken(tokenString, applicationId, userId, permissions, declinedPermissions, LegacyTokenHelper.getSource(bundle), LegacyTokenHelper.getDate(bundle, "com.facebook.TokenCachingStrategy.ExpirationDate"), LegacyTokenHelper.getDate(bundle, "com.facebook.TokenCachingStrategy.LastRefreshDate"));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static List<String> getPermissionsFromBundle(Bundle bundle, String key)
/*     */   {
/* 464 */     List<String> originalPermissions = bundle.getStringArrayList(key);
/*     */     List<String> permissions;
/* 466 */     List<String> permissions; if (originalPermissions == null) {
/* 467 */       permissions = Collections.emptyList();
/*     */     } else {
/* 469 */       permissions = Collections.unmodifiableList(new ArrayList(originalPermissions));
/*     */     }
/* 471 */     return permissions;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isExpired()
/*     */   {
/* 480 */     return new Date().after(this.expires);
/*     */   }
/*     */   
/*     */   JSONObject toJSONObject() throws JSONException {
/* 484 */     JSONObject jsonObject = new JSONObject();
/*     */     
/* 486 */     jsonObject.put("version", 1);
/* 487 */     jsonObject.put("token", this.token);
/* 488 */     jsonObject.put("expires_at", this.expires.getTime());
/* 489 */     JSONArray permissionsArray = new JSONArray(this.permissions);
/* 490 */     jsonObject.put("permissions", permissionsArray);
/* 491 */     JSONArray declinedPermissionsArray = new JSONArray(this.declinedPermissions);
/* 492 */     jsonObject.put("declined_permissions", declinedPermissionsArray);
/* 493 */     jsonObject.put("last_refresh", this.lastRefresh.getTime());
/* 494 */     jsonObject.put("source", this.source.name());
/* 495 */     jsonObject.put("application_id", this.applicationId);
/* 496 */     jsonObject.put("user_id", this.userId);
/*     */     
/* 498 */     return jsonObject;
/*     */   }
/*     */   
/*     */   static AccessToken createFromJSONObject(JSONObject jsonObject) throws JSONException {
/* 502 */     int version = jsonObject.getInt("version");
/* 503 */     if (version > 1) {
/* 504 */       throw new FacebookException("Unknown AccessToken serialization format.");
/*     */     }
/*     */     
/* 507 */     String token = jsonObject.getString("token");
/* 508 */     Date expiresAt = new Date(jsonObject.getLong("expires_at"));
/* 509 */     JSONArray permissionsArray = jsonObject.getJSONArray("permissions");
/* 510 */     JSONArray declinedPermissionsArray = jsonObject.getJSONArray("declined_permissions");
/* 511 */     Date lastRefresh = new Date(jsonObject.getLong("last_refresh"));
/* 512 */     AccessTokenSource source = AccessTokenSource.valueOf(jsonObject.getString("source"));
/* 513 */     String applicationId = jsonObject.getString("application_id");
/* 514 */     String userId = jsonObject.getString("user_id");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 521 */     return new AccessToken(token, applicationId, userId, Utility.jsonArrayToStringList(permissionsArray), Utility.jsonArrayToStringList(declinedPermissionsArray), source, expiresAt, lastRefresh);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static AccessToken createFromBundle(List<String> requestedPermissions, Bundle bundle, AccessTokenSource source, Date expirationBase, String applicationId)
/*     */   {
/* 533 */     String token = bundle.getString("access_token");
/* 534 */     Date expires = Utility.getBundleLongAsDate(bundle, "expires_in", expirationBase);
/* 535 */     String userId = bundle.getString("user_id");
/*     */     
/* 537 */     if ((Utility.isNullOrEmpty(token)) || (expires == null)) {
/* 538 */       return null;
/*     */     }
/*     */     
/* 541 */     return new AccessToken(token, applicationId, userId, requestedPermissions, null, source, expires, new Date());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String tokenToString()
/*     */   {
/* 553 */     if (this.token == null)
/* 554 */       return "null";
/* 555 */     if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
/* 556 */       return this.token;
/*     */     }
/* 558 */     return "ACCESS_TOKEN_REMOVED";
/*     */   }
/*     */   
/*     */   private void appendPermissions(StringBuilder builder)
/*     */   {
/* 563 */     builder.append(" permissions:");
/* 564 */     if (this.permissions == null) {
/* 565 */       builder.append("null");
/*     */     } else {
/* 567 */       builder.append("[");
/* 568 */       builder.append(TextUtils.join(", ", this.permissions));
/* 569 */       builder.append("]");
/*     */     }
/*     */   }
/*     */   
/*     */   AccessToken(Parcel parcel) {
/* 574 */     this.expires = new Date(parcel.readLong());
/* 575 */     ArrayList<String> permissionsList = new ArrayList();
/* 576 */     parcel.readStringList(permissionsList);
/* 577 */     this.permissions = Collections.unmodifiableSet(new HashSet(permissionsList));
/* 578 */     permissionsList.clear();
/* 579 */     parcel.readStringList(permissionsList);
/* 580 */     this.declinedPermissions = Collections.unmodifiableSet(new HashSet(permissionsList));
/*     */     
/* 582 */     this.token = parcel.readString();
/* 583 */     this.source = AccessTokenSource.valueOf(parcel.readString());
/* 584 */     this.lastRefresh = new Date(parcel.readLong());
/* 585 */     this.applicationId = parcel.readString();
/* 586 */     this.userId = parcel.readString();
/*     */   }
/*     */   
/*     */   public int describeContents()
/*     */   {
/* 591 */     return 0;
/*     */   }
/*     */   
/*     */   public void writeToParcel(Parcel dest, int flags)
/*     */   {
/* 596 */     dest.writeLong(this.expires.getTime());
/* 597 */     dest.writeStringList(new ArrayList(this.permissions));
/* 598 */     dest.writeStringList(new ArrayList(this.declinedPermissions));
/* 599 */     dest.writeString(this.token);
/* 600 */     dest.writeString(this.source.name());
/* 601 */     dest.writeLong(this.lastRefresh.getTime());
/* 602 */     dest.writeString(this.applicationId);
/* 603 */     dest.writeString(this.userId);
/*     */   }
/*     */   
/* 606 */   public static final Creator<AccessToken> CREATOR = new Creator()
/*     */   {
/*     */     public AccessToken createFromParcel(Parcel source)
/*     */     {
/* 610 */       return new AccessToken(source);
/*     */     }
/*     */     
/*     */     public AccessToken[] newArray(int size)
/*     */     {
/* 615 */       return new AccessToken[size];
/*     */     }
/*     */   };
/*     */   
/*     */   public static abstract interface AccessTokenCreationCallback
/*     */   {
/*     */     public abstract void onSuccess(AccessToken paramAccessToken);
/*     */     
/*     */     public abstract void onError(FacebookException paramFacebookException);
/*     */   }
/*     */   
/*     */   public static abstract interface AccessTokenRefreshCallback
/*     */   {
/*     */     public abstract void OnTokenRefreshed(AccessToken paramAccessToken);
/*     */     
/*     */     public abstract void OnTokenRefreshFailed(FacebookException paramFacebookException);
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/AccessToken.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */