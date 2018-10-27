/*     */ package com.facebook.login;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.content.pm.PackageInfo;
/*     */ import android.content.pm.PackageManager;
/*     */ import android.content.pm.PackageManager.NameNotFoundException;
/*     */ import android.os.Bundle;
/*     */ import android.text.TextUtils;
/*     */ import com.facebook.appevents.AppEventsLogger;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
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
/*     */ class LoginLogger
/*     */ {
/*     */   static final String EVENT_NAME_LOGIN_METHOD_START = "fb_mobile_login_method_start";
/*     */   static final String EVENT_NAME_LOGIN_METHOD_COMPLETE = "fb_mobile_login_method_complete";
/*     */   static final String EVENT_NAME_LOGIN_METHOD_NOT_TRIED = "fb_mobile_login_method_not_tried";
/*     */   static final String EVENT_PARAM_METHOD_RESULT_SKIPPED = "skipped";
/*     */   static final String EVENT_NAME_LOGIN_START = "fb_mobile_login_start";
/*     */   static final String EVENT_NAME_LOGIN_COMPLETE = "fb_mobile_login_complete";
/*     */   static final String EVENT_PARAM_AUTH_LOGGER_ID = "0_auth_logger_id";
/*     */   static final String EVENT_PARAM_TIMESTAMP = "1_timestamp_ms";
/*     */   static final String EVENT_PARAM_LOGIN_RESULT = "2_result";
/*     */   static final String EVENT_PARAM_METHOD = "3_method";
/*     */   static final String EVENT_PARAM_ERROR_CODE = "4_error_code";
/*     */   static final String EVENT_PARAM_ERROR_MESSAGE = "5_error_message";
/*     */   static final String EVENT_PARAM_EXTRAS = "6_extras";
/*     */   static final String EVENT_PARAM_CHALLENGE = "7_challenge";
/*     */   static final String EVENT_EXTRAS_TRY_LOGIN_ACTIVITY = "try_login_activity";
/*     */   static final String EVENT_EXTRAS_MISSING_INTERNET_PERMISSION = "no_internet_permission";
/*     */   static final String EVENT_EXTRAS_NOT_TRIED = "not_tried";
/*     */   static final String EVENT_EXTRAS_NEW_PERMISSIONS = "new_permissions";
/*     */   static final String EVENT_EXTRAS_LOGIN_BEHAVIOR = "login_behavior";
/*     */   static final String EVENT_EXTRAS_REQUEST_CODE = "request_code";
/*     */   static final String EVENT_EXTRAS_PERMISSIONS = "permissions";
/*     */   static final String EVENT_EXTRAS_DEFAULT_AUDIENCE = "default_audience";
/*     */   static final String EVENT_EXTRAS_IS_REAUTHORIZE = "isReauthorize";
/*     */   static final String EVENT_EXTRAS_FACEBOOK_VERSION = "facebookVersion";
/*     */   static final String FACEBOOK_PACKAGE_NAME = "com.facebook.katana";
/*     */   private final AppEventsLogger appEventsLogger;
/*     */   private String applicationId;
/*     */   private String facebookVersion;
/*     */   
/*     */   LoginLogger(Context context, String applicationId)
/*     */   {
/*  73 */     this.applicationId = applicationId;
/*     */     
/*  75 */     this.appEventsLogger = AppEventsLogger.newLogger(context, applicationId);
/*     */     
/*     */     try
/*     */     {
/*  79 */       PackageManager packageManager = context.getPackageManager();
/*  80 */       if (packageManager != null) {
/*  81 */         PackageInfo facebookInfo = packageManager.getPackageInfo("com.facebook.katana", 0);
/*  82 */         if (facebookInfo != null) {
/*  83 */           this.facebookVersion = facebookInfo.versionName;
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (NameNotFoundException localNameNotFoundException) {}
/*     */   }
/*     */   
/*     */   public String getApplicationId()
/*     */   {
/*  92 */     return this.applicationId;
/*     */   }
/*     */   
/*     */ 
/*     */   static Bundle newAuthorizationLoggingBundle(String authLoggerId)
/*     */   {
/*  98 */     Bundle bundle = new Bundle();
/*  99 */     bundle.putLong("1_timestamp_ms", System.currentTimeMillis());
/* 100 */     bundle.putString("0_auth_logger_id", authLoggerId);
/* 101 */     bundle.putString("3_method", "");
/* 102 */     bundle.putString("2_result", "");
/* 103 */     bundle.putString("5_error_message", "");
/* 104 */     bundle.putString("4_error_code", "");
/* 105 */     bundle.putString("6_extras", "");
/* 106 */     return bundle;
/*     */   }
/*     */   
/*     */   public void logStartLogin(LoginClient.Request pendingLoginRequest) {
/* 110 */     Bundle bundle = newAuthorizationLoggingBundle(pendingLoginRequest.getAuthId());
/*     */     
/*     */     try
/*     */     {
/* 114 */       JSONObject extras = new JSONObject();
/* 115 */       extras.put("login_behavior", pendingLoginRequest
/* 116 */         .getLoginBehavior().toString());
/* 117 */       extras.put("request_code", LoginClient.getLoginRequestCode());
/* 118 */       extras.put("permissions", 
/* 119 */         TextUtils.join(",", pendingLoginRequest.getPermissions()));
/* 120 */       extras.put("default_audience", pendingLoginRequest
/* 121 */         .getDefaultAudience().toString());
/* 122 */       extras.put("isReauthorize", pendingLoginRequest.isRerequest());
/* 123 */       if (this.facebookVersion != null) {
/* 124 */         extras.put("facebookVersion", this.facebookVersion);
/*     */       }
/* 126 */       bundle.putString("6_extras", extras.toString());
/*     */     }
/*     */     catch (JSONException localJSONException) {}
/*     */     
/* 130 */     this.appEventsLogger.logSdkEvent("fb_mobile_login_start", null, bundle);
/*     */   }
/*     */   
/*     */ 
/*     */   public void logCompleteLogin(String loginRequestId, Map<String, String> loggingExtras, LoginClient.Result.Code result, Map<String, String> resultExtras, Exception exception)
/*     */   {
/* 136 */     Bundle bundle = newAuthorizationLoggingBundle(loginRequestId);
/* 137 */     if (result != null) {
/* 138 */       bundle.putString("2_result", result.getLoggingValue());
/*     */     }
/* 140 */     if ((exception != null) && (exception.getMessage() != null)) {
/* 141 */       bundle.putString("5_error_message", exception.getMessage());
/*     */     }
/*     */     
/*     */ 
/* 145 */     JSONObject jsonObject = null;
/* 146 */     if (!loggingExtras.isEmpty()) {
/* 147 */       jsonObject = new JSONObject(loggingExtras);
/*     */     }
/* 149 */     if (resultExtras != null) {
/* 150 */       if (jsonObject == null) {
/* 151 */         jsonObject = new JSONObject();
/*     */       }
/*     */       try {
/* 154 */         for (Entry<String, String> entry : resultExtras.entrySet()) {
/* 155 */           jsonObject.put((String)entry.getKey(), entry.getValue());
/*     */         }
/*     */       }
/*     */       catch (JSONException localJSONException1) {}
/*     */     }
/* 160 */     if (jsonObject != null) {
/* 161 */       bundle.putString("6_extras", jsonObject.toString());
/*     */     }
/*     */     
/* 164 */     this.appEventsLogger.logSdkEvent("fb_mobile_login_complete", null, bundle);
/*     */   }
/*     */   
/*     */   public void logAuthorizationMethodStart(String authId, String method) {
/* 168 */     Bundle bundle = newAuthorizationLoggingBundle(authId);
/* 169 */     bundle.putString("3_method", method);
/*     */     
/* 171 */     this.appEventsLogger.logSdkEvent("fb_mobile_login_method_start", null, bundle);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void logAuthorizationMethodComplete(String authId, String method, String result, String errorMessage, String errorCode, Map<String, String> loggingExtras)
/*     */   {
/* 178 */     Bundle bundle = newAuthorizationLoggingBundle(authId);
/* 179 */     if (result != null) {
/* 180 */       bundle.putString("2_result", result);
/*     */     }
/* 182 */     if (errorMessage != null) {
/* 183 */       bundle.putString("5_error_message", errorMessage);
/*     */     }
/* 185 */     if (errorCode != null) {
/* 186 */       bundle.putString("4_error_code", errorCode);
/*     */     }
/* 188 */     if ((loggingExtras != null) && (!loggingExtras.isEmpty())) {
/* 189 */       JSONObject jsonObject = new JSONObject(loggingExtras);
/* 190 */       bundle.putString("6_extras", jsonObject.toString());
/*     */     }
/* 192 */     bundle.putString("3_method", method);
/*     */     
/* 194 */     this.appEventsLogger.logSdkEvent("fb_mobile_login_method_complete", null, bundle);
/*     */   }
/*     */   
/*     */   public void logAuthorizationMethodNotTried(String authId, String method) {
/* 198 */     Bundle bundle = newAuthorizationLoggingBundle(authId);
/* 199 */     bundle.putString("3_method", method);
/*     */     
/* 201 */     this.appEventsLogger.logSdkEvent("fb_mobile_login_method_not_tried", null, bundle);
/*     */   }
/*     */   
/*     */   public void logUnexpectedError(String eventName, String errorMessage) {
/* 205 */     logUnexpectedError(eventName, errorMessage, "");
/*     */   }
/*     */   
/*     */   public void logUnexpectedError(String eventName, String errorMessage, String method) {
/* 209 */     Bundle bundle = newAuthorizationLoggingBundle("");
/* 210 */     bundle.putString("2_result", LoginClient.Result.Code.ERROR
/* 211 */       .getLoggingValue());
/* 212 */     bundle.putString("5_error_message", errorMessage);
/* 213 */     bundle.putString("3_method", method);
/*     */     
/* 215 */     this.appEventsLogger.logSdkEvent(eventName, null, bundle);
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/login/LoginLogger.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */