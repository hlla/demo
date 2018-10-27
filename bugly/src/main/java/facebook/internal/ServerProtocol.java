/*     */ package com.facebook.internal;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.os.Bundle;
/*     */ import com.facebook.FacebookSdk;
/*     */ import com.facebook.LoggingBehavior;
/*     */ import java.util.Collection;
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
/*     */ 
/*     */ public final class ServerProtocol
/*     */ {
/*  41 */   private static final String TAG = ServerProtocol.class.getName();
/*     */   
/*     */   private static final String DIALOG_AUTHORITY_FORMAT = "m.%s";
/*     */   
/*     */   public static final String DIALOG_PATH = "dialog/";
/*     */   
/*     */   public static final String DIALOG_PARAM_ACCESS_TOKEN = "access_token";
/*     */   
/*     */   public static final String DIALOG_PARAM_APP_ID = "app_id";
/*     */   
/*     */   public static final String DIALOG_PARAM_AUTH_TYPE = "auth_type";
/*     */   
/*     */   public static final String DIALOG_PARAM_CLIENT_ID = "client_id";
/*     */   
/*     */   public static final String DIALOG_PARAM_DISPLAY = "display";
/*     */   public static final String DIALOG_PARAM_DISPLAY_TOUCH = "touch";
/*     */   public static final String DIALOG_PARAM_E2E = "e2e";
/*     */   public static final String DIALOG_PARAM_LEGACY_OVERRIDE = "legacy_override";
/*     */   public static final String DIALOG_PARAM_REDIRECT_URI = "redirect_uri";
/*     */   public static final String DIALOG_PARAM_RESPONSE_TYPE = "response_type";
/*     */   public static final String DIALOG_PARAM_RETURN_SCOPES = "return_scopes";
/*     */   public static final String DIALOG_PARAM_SCOPE = "scope";
/*     */   public static final String DIALOG_PARAM_SSO_DEVICE = "sso";
/*     */   public static final String DIALOG_PARAM_DEFAULT_AUDIENCE = "default_audience";
/*     */   public static final String DIALOG_PARAM_SDK_VERSION = "sdk";
/*     */   public static final String DIALOG_PARAM_STATE = "state";
/*     */   public static final String DIALOG_REREQUEST_AUTH_TYPE = "rerequest";
/*     */   public static final String DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST = "token,signed_request";
/*     */   public static final String DIALOG_RETURN_SCOPES_TRUE = "true";
/*     */   public static final String DIALOG_REDIRECT_URI = "fbconnect://success";
/*     */   public static final String DIALOG_CANCEL_URI = "fbconnect://cancel";
/*     */   public static final String FALLBACK_DIALOG_PARAM_APP_ID = "app_id";
/*     */   public static final String FALLBACK_DIALOG_PARAM_BRIDGE_ARGS = "bridge_args";
/*     */   public static final String FALLBACK_DIALOG_PARAM_KEY_HASH = "android_key_hash";
/*     */   public static final String FALLBACK_DIALOG_PARAM_METHOD_ARGS = "method_args";
/*     */   public static final String FALLBACK_DIALOG_PARAM_METHOD_RESULTS = "method_results";
/*     */   public static final String FALLBACK_DIALOG_PARAM_VERSION = "version";
/*     */   public static final String FALLBACK_DIALOG_DISPLAY_VALUE_TOUCH = "touch";
/*     */   private static final String GRAPH_VIDEO_URL_FORMAT = "https://graph-video.%s";
/*     */   private static final String GRAPH_URL_FORMAT = "https://graph.%s";
/*     */   private static final String GRAPH_API_VERSION = "v2.8";
/*  82 */   public static final Collection<String> errorsProxyAuthDisabled = Utility.unmodifiableCollection(new String[] { "service_disabled", "AndroidAuthKillSwitchException" });
/*     */   
/*  84 */   public static final Collection<String> errorsUserCanceled = Utility.unmodifiableCollection(new String[] { "access_denied", "OAuthAccessDeniedException" });
/*     */   public static final String errorConnectionFailure = "CONNECTION_FAILURE";
/*     */   
/*     */   public static final String getDialogAuthority() {
/*  88 */     return String.format("m.%s", new Object[] { FacebookSdk.getFacebookDomain() });
/*     */   }
/*     */   
/*     */   public static final String getGraphUrlBase() {
/*  92 */     return String.format("https://graph.%s", new Object[] { FacebookSdk.getFacebookDomain() });
/*     */   }
/*     */   
/*     */   public static final String getGraphVideoUrlBase() {
/*  96 */     return String.format("https://graph-video.%s", new Object[] { FacebookSdk.getFacebookDomain() });
/*     */   }
/*     */   
/*     */   public static final String getDefaultAPIVersion() {
/* 100 */     return "v2.8";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Bundle getQueryParamsForPlatformActivityIntentWebFallback(String callId, int version, Bundle methodArgs)
/*     */   {
/* 108 */     Context context = FacebookSdk.getApplicationContext();
/* 109 */     String keyHash = FacebookSdk.getApplicationSignature(context);
/* 110 */     if (Utility.isNullOrEmpty(keyHash)) {
/* 111 */       return null;
/*     */     }
/*     */     
/* 114 */     Bundle webParams = new Bundle();
/*     */     
/* 116 */     webParams.putString("android_key_hash", keyHash);
/* 117 */     webParams.putString("app_id", FacebookSdk.getApplicationId());
/* 118 */     webParams.putInt("version", version);
/* 119 */     webParams.putString("display", "touch");
/*     */     
/* 121 */     Bundle bridgeArguments = new Bundle();
/* 122 */     bridgeArguments.putString("action_id", callId);
/*     */     
/* 124 */     methodArgs = methodArgs == null ? new Bundle() : methodArgs;
/*     */     try
/*     */     {
/* 127 */       JSONObject bridgeArgsJSON = BundleJSONConverter.convertToJSON(bridgeArguments);
/* 128 */       JSONObject methodArgsJSON = BundleJSONConverter.convertToJSON(methodArgs);
/*     */       
/* 130 */       if ((bridgeArgsJSON == null) || (methodArgsJSON == null)) {
/* 131 */         return null;
/*     */       }
/*     */       
/* 134 */       webParams.putString("bridge_args", bridgeArgsJSON.toString());
/* 135 */       webParams.putString("method_args", methodArgsJSON.toString());
/*     */     } catch (JSONException je) {
/* 137 */       webParams = null;
/* 138 */       Logger.log(LoggingBehavior.DEVELOPER_ERRORS, 6, TAG, "Error creating Url -- " + je);
/*     */     }
/*     */     
/*     */ 
/* 142 */     return webParams;
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/ServerProtocol.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */