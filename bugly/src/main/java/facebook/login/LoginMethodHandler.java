/*     */ package com.facebook.login;
/*     */ 
/*     */ import android.content.Intent;
/*     */ import android.os.Bundle;
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
/*     */ import android.util.Base64;
/*     */ import android.util.Log;
/*     */ import com.facebook.AccessToken;
/*     */ import com.facebook.AccessTokenSource;
/*     */ import com.facebook.FacebookException;
/*     */ import com.facebook.appevents.AppEventsLogger;
/*     */ import com.facebook.internal.Utility;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ abstract class LoginMethodHandler
/*     */   implements Parcelable
/*     */ {
/*     */   Map<String, String> methodLoggingExtras;
/*     */   protected LoginClient loginClient;
/*     */   
/*     */   LoginMethodHandler(LoginClient loginClient)
/*     */   {
/*  55 */     this.loginClient = loginClient;
/*     */   }
/*     */   
/*     */   LoginMethodHandler(Parcel source) {
/*  59 */     this.methodLoggingExtras = Utility.readStringMapFromParcel(source);
/*     */   }
/*     */   
/*     */   void setLoginClient(LoginClient loginClient)
/*     */   {
/*  64 */     if (this.loginClient != null) {
/*  65 */       throw new FacebookException("Can't set LoginClient if it is already set.");
/*     */     }
/*  67 */     this.loginClient = loginClient;
/*     */   }
/*     */   
/*     */   abstract boolean tryAuthorize(LoginClient.Request paramRequest);
/*     */   
/*     */   abstract String getNameForLogging();
/*     */   
/*     */   boolean onActivityResult(int requestCode, int resultCode, Intent data) {
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   boolean needsInternetPermission() {
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   void cancel() {}
/*     */   
/*     */   void putChallengeParam(JSONObject param) throws JSONException
/*     */   {}
/*     */   
/*     */   protected String getClientState(String authId)
/*     */   {
/*  89 */     JSONObject param = new JSONObject();
/*     */     try {
/*  91 */       param.put("0_auth_logger_id", authId);
/*  92 */       param.put("3_method", getNameForLogging());
/*  93 */       putChallengeParam(param);
/*     */     } catch (JSONException e) {
/*  95 */       Log.w("LoginMethodHandler", "Error creating client state json: " + e.getMessage());
/*     */     }
/*  97 */     return param.toString();
/*     */   }
/*     */   
/*     */   protected void addLoggingExtra(String key, Object value) {
/* 101 */     if (this.methodLoggingExtras == null) {
/* 102 */       this.methodLoggingExtras = new HashMap();
/*     */     }
/* 104 */     this.methodLoggingExtras.put(key, value == null ? null : value.toString());
/*     */   }
/*     */   
/*     */   protected void logWebLoginCompleted(String e2e) {
/* 108 */     String applicationId = this.loginClient.getPendingRequest().getApplicationId();
/*     */     
/* 110 */     AppEventsLogger appEventsLogger = AppEventsLogger.newLogger(this.loginClient.getActivity(), applicationId);
/*     */     
/* 112 */     Bundle parameters = new Bundle();
/* 113 */     parameters.putString("fb_web_login_e2e", e2e);
/* 114 */     parameters.putLong("fb_web_login_switchback_time", 
/* 115 */       System.currentTimeMillis());
/* 116 */     parameters.putString("app_id", applicationId);
/*     */     
/* 118 */     appEventsLogger.logSdkEvent("fb_dialogs_web_login_dialog_complete", null, parameters);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static AccessToken createAccessTokenFromNativeLogin(Bundle bundle, AccessTokenSource source, String applicationId)
/*     */   {
/* 125 */     Date expires = Utility.getBundleLongAsDate(bundle, "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH", new Date(0L));
/*     */     
/* 127 */     ArrayList<String> permissions = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
/* 128 */     String token = bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN");
/*     */     
/* 130 */     if (Utility.isNullOrEmpty(token)) {
/* 131 */       return null;
/*     */     }
/*     */     
/* 134 */     String userId = bundle.getString("com.facebook.platform.extra.USER_ID");
/*     */     
/* 136 */     return new AccessToken(token, applicationId, userId, permissions, null, source, expires, new Date());
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
/*     */   public static AccessToken createAccessTokenFromWebBundle(Collection<String> requestedPermissions, Bundle bundle, AccessTokenSource source, String applicationId)
/*     */     throws FacebookException
/*     */   {
/* 152 */     Date expires = Utility.getBundleLongAsDate(bundle, "expires_in", new Date());
/* 153 */     String token = bundle.getString("access_token");
/*     */     
/*     */ 
/*     */ 
/* 157 */     String grantedPermissions = bundle.getString("granted_scopes");
/* 158 */     if (!Utility.isNullOrEmpty(grantedPermissions))
/*     */     {
/* 160 */       requestedPermissions = new ArrayList(Arrays.asList(grantedPermissions.split(",")));
/*     */     }
/* 162 */     String deniedPermissions = bundle.getString("denied_scopes");
/* 163 */     List<String> declinedPermissions = null;
/* 164 */     if (!Utility.isNullOrEmpty(deniedPermissions))
/*     */     {
/* 166 */       declinedPermissions = new ArrayList(Arrays.asList(deniedPermissions.split(",")));
/*     */     }
/*     */     
/* 169 */     if (Utility.isNullOrEmpty(token)) {
/* 170 */       return null;
/*     */     }
/*     */     
/* 173 */     String signed_request = bundle.getString("signed_request");
/* 174 */     String userId = getUserIDFromSignedRequest(signed_request);
/*     */     
/* 176 */     return new AccessToken(token, applicationId, userId, requestedPermissions, declinedPermissions, source, expires, new Date());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static String getUserIDFromSignedRequest(String signedRequest)
/*     */     throws FacebookException
/*     */   {
/* 189 */     if ((signedRequest == null) || (signedRequest.isEmpty())) {
/* 190 */       throw new FacebookException("Authorization response does not contain the signed_request");
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 195 */       String[] signatureAndPayload = signedRequest.split("\\.");
/* 196 */       if (signatureAndPayload.length == 2) {
/* 197 */         byte[] data = Base64.decode(signatureAndPayload[1], 0);
/* 198 */         String dataStr = new String(data, "UTF-8");
/* 199 */         JSONObject jsonObject = new JSONObject(dataStr);
/* 200 */         return jsonObject.getString("user_id");
/*     */       }
/*     */     }
/*     */     catch (UnsupportedEncodingException localUnsupportedEncodingException) {}catch (JSONException localJSONException) {}
/*     */     
/* 205 */     throw new FacebookException("Failed to retrieve user_id from signed_request");
/*     */   }
/*     */   
/*     */   public void writeToParcel(Parcel dest, int flags)
/*     */   {
/* 210 */     Utility.writeStringMapToParcel(dest, this.methodLoggingExtras);
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/login/LoginMethodHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */