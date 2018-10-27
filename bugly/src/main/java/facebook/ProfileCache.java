/*    */ package com.facebook;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.content.SharedPreferences;
/*    */ import android.content.SharedPreferences.Editor;
/*    */ import com.facebook.internal.Validate;
/*    */ import org.json.JSONException;
/*    */ import org.json.JSONObject;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class ProfileCache
/*    */ {
/*    */   static final String CACHED_PROFILE_KEY = "com.facebook.ProfileManager.CachedProfile";
/*    */   static final String SHARED_PREFERENCES_NAME = "com.facebook.AccessTokenManager.SharedPreferences";
/*    */   private final SharedPreferences sharedPreferences;
/*    */   
/*    */   ProfileCache()
/*    */   {
/* 39 */     this.sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);
/*    */   }
/*    */   
/*    */ 
/*    */   Profile load()
/*    */   {
/* 45 */     String jsonString = this.sharedPreferences.getString("com.facebook.ProfileManager.CachedProfile", null);
/* 46 */     if (jsonString != null) {
/*    */       try {
/* 48 */         JSONObject jsonObject = new JSONObject(jsonString);
/* 49 */         return new Profile(jsonObject);
/*    */       }
/*    */       catch (JSONException localJSONException) {}
/*    */     }
/*    */     
/* 54 */     return null;
/*    */   }
/*    */   
/*    */   void save(Profile profile) {
/* 58 */     Validate.notNull(profile, "profile");
/* 59 */     JSONObject jsonObject = profile.toJSONObject();
/* 60 */     if (jsonObject != null)
/*    */     {
/*    */ 
/*    */ 
/* 64 */       this.sharedPreferences.edit().putString("com.facebook.ProfileManager.CachedProfile", jsonObject.toString()).apply();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   void clear()
/*    */   {
/* 72 */     this.sharedPreferences.edit().remove("com.facebook.ProfileManager.CachedProfile").apply();
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/ProfileCache.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */