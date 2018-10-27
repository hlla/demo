/*     */ package com.facebook;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.content.SharedPreferences;
/*     */ import android.content.SharedPreferences.Editor;
/*     */ import android.os.Bundle;
/*     */ import com.facebook.internal.Validate;
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
/*     */ class AccessTokenCache
/*     */ {
/*     */   static final String CACHED_ACCESS_TOKEN_KEY = "com.facebook.AccessTokenManager.CachedAccessToken";
/*     */   private final SharedPreferences sharedPreferences;
/*     */   private final SharedPreferencesTokenCachingStrategyFactory tokenCachingStrategyFactory;
/*     */   private LegacyTokenHelper tokenCachingStrategy;
/*     */   
/*     */   AccessTokenCache(SharedPreferences sharedPreferences, SharedPreferencesTokenCachingStrategyFactory tokenCachingStrategyFactory)
/*     */   {
/*  42 */     this.sharedPreferences = sharedPreferences;
/*  43 */     this.tokenCachingStrategyFactory = tokenCachingStrategyFactory;
/*     */   }
/*     */   
/*     */   public AccessTokenCache() {
/*  47 */     this(
/*  48 */       FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0), new SharedPreferencesTokenCachingStrategyFactory());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public AccessToken load()
/*     */   {
/*  56 */     AccessToken accessToken = null;
/*  57 */     if (hasCachedAccessToken())
/*     */     {
/*     */ 
/*  60 */       accessToken = getCachedAccessToken();
/*  61 */     } else if (shouldCheckLegacyToken()) {
/*  62 */       accessToken = getLegacyAccessToken();
/*     */       
/*  64 */       if (accessToken != null) {
/*  65 */         save(accessToken);
/*  66 */         getTokenCachingStrategy().clear();
/*     */       }
/*     */     }
/*     */     
/*  70 */     return accessToken;
/*     */   }
/*     */   
/*     */   public void save(AccessToken accessToken) {
/*  74 */     Validate.notNull(accessToken, "accessToken");
/*     */     
/*  76 */     JSONObject jsonObject = null;
/*     */     try {
/*  78 */       jsonObject = accessToken.toJSONObject();
/*  79 */       this.sharedPreferences.edit().putString("com.facebook.AccessTokenManager.CachedAccessToken", jsonObject.toString())
/*  80 */         .apply();
/*     */     }
/*     */     catch (JSONException localJSONException) {}
/*     */   }
/*     */   
/*     */   public void clear()
/*     */   {
/*  87 */     this.sharedPreferences.edit().remove("com.facebook.AccessTokenManager.CachedAccessToken").apply();
/*  88 */     if (shouldCheckLegacyToken()) {
/*  89 */       getTokenCachingStrategy().clear();
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean hasCachedAccessToken() {
/*  94 */     return this.sharedPreferences.contains("com.facebook.AccessTokenManager.CachedAccessToken");
/*     */   }
/*     */   
/*     */   private AccessToken getCachedAccessToken() {
/*  98 */     String jsonString = this.sharedPreferences.getString("com.facebook.AccessTokenManager.CachedAccessToken", null);
/*  99 */     if (jsonString != null) {
/*     */       try {
/* 101 */         JSONObject jsonObject = new JSONObject(jsonString);
/* 102 */         return AccessToken.createFromJSONObject(jsonObject);
/*     */       } catch (JSONException e) {
/* 104 */         return null;
/*     */       }
/*     */     }
/* 107 */     return null;
/*     */   }
/*     */   
/*     */   private boolean shouldCheckLegacyToken() {
/* 111 */     return FacebookSdk.isLegacyTokenUpgradeSupported();
/*     */   }
/*     */   
/*     */   private AccessToken getLegacyAccessToken() {
/* 115 */     AccessToken accessToken = null;
/* 116 */     Bundle bundle = getTokenCachingStrategy().load();
/*     */     
/* 118 */     if ((bundle != null) && (LegacyTokenHelper.hasTokenInformation(bundle))) {
/* 119 */       accessToken = AccessToken.createFromLegacyCache(bundle);
/*     */     }
/* 121 */     return accessToken;
/*     */   }
/*     */   
/*     */   private LegacyTokenHelper getTokenCachingStrategy() {
/* 125 */     if (this.tokenCachingStrategy == null) {
/* 126 */       synchronized (this) {
/* 127 */         if (this.tokenCachingStrategy == null) {
/* 128 */           this.tokenCachingStrategy = this.tokenCachingStrategyFactory.create();
/*     */         }
/*     */       }
/*     */     }
/* 132 */     return this.tokenCachingStrategy;
/*     */   }
/*     */   
/*     */   static class SharedPreferencesTokenCachingStrategyFactory {
/*     */     public LegacyTokenHelper create() {
/* 137 */       return new LegacyTokenHelper(FacebookSdk.getApplicationContext());
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/AccessTokenCache.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */