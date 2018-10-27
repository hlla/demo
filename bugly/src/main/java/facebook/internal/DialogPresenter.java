/*     */ package com.facebook.internal;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.net.Uri;
/*     */ import android.os.Bundle;
/*     */ import com.facebook.FacebookActivity;
/*     */ import com.facebook.FacebookException;
/*     */ import com.facebook.FacebookSdk;
/*     */ import com.facebook.appevents.AppEventsLogger;
/*     */ import java.util.UUID;
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
/*     */ public class DialogPresenter
/*     */ {
/*     */   public static void setupAppCallForCannotShowError(AppCall appCall)
/*     */   {
/*  42 */     FacebookException e = new FacebookException("Unable to show the provided content via the web or the installed version of the Facebook app. Some dialogs are only supported starting API 14.");
/*     */     
/*     */ 
/*  45 */     setupAppCallForValidationError(appCall, e);
/*     */   }
/*     */   
/*     */   public static void setupAppCallForValidationError(AppCall appCall, FacebookException validationError)
/*     */   {
/*  50 */     setupAppCallForErrorResult(appCall, validationError);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void present(AppCall appCall, Activity activity)
/*     */   {
/*  59 */     activity.startActivityForResult(appCall.getRequestIntent(), appCall.getRequestCode());
/*     */     
/*  61 */     appCall.setPending();
/*     */   }
/*     */   
/*     */   public static void present(AppCall appCall, FragmentWrapper fragmentWrapper) {
/*  65 */     fragmentWrapper.startActivityForResult(appCall
/*  66 */       .getRequestIntent(), appCall
/*  67 */       .getRequestCode());
/*     */     
/*  69 */     appCall.setPending();
/*     */   }
/*     */   
/*     */   public static boolean canPresentNativeDialogWithFeature(DialogFeature feature)
/*     */   {
/*  74 */     return getProtocolVersionForNativeDialog(feature) != -1;
/*     */   }
/*     */   
/*     */   public static boolean canPresentWebFallbackDialogWithFeature(DialogFeature feature)
/*     */   {
/*  79 */     return getDialogWebFallbackUri(feature) != null;
/*     */   }
/*     */   
/*     */   public static void setupAppCallForErrorResult(AppCall appCall, FacebookException exception) {
/*  83 */     if (exception == null) {
/*  84 */       return;
/*     */     }
/*  86 */     Validate.hasFacebookActivity(FacebookSdk.getApplicationContext());
/*     */     
/*  88 */     Intent errorResultIntent = new Intent();
/*  89 */     errorResultIntent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
/*  90 */     errorResultIntent.setAction(FacebookActivity.PASS_THROUGH_CANCEL_ACTION);
/*     */     
/*  92 */     NativeProtocol.setupProtocolRequestIntent(errorResultIntent, appCall
/*     */     
/*  94 */       .getCallId().toString(), null, 
/*     */       
/*  96 */       NativeProtocol.getLatestKnownVersion(), 
/*  97 */       NativeProtocol.createBundleForException(exception));
/*     */     
/*  99 */     appCall.setRequestIntent(errorResultIntent);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void setupAppCallForWebDialog(AppCall appCall, String actionName, Bundle parameters)
/*     */   {
/* 106 */     Validate.hasFacebookActivity(FacebookSdk.getApplicationContext());
/* 107 */     Validate.hasInternetPermissions(FacebookSdk.getApplicationContext());
/*     */     
/* 109 */     Bundle intentParameters = new Bundle();
/* 110 */     intentParameters.putString("action", actionName);
/* 111 */     intentParameters.putBundle("params", parameters);
/*     */     
/* 113 */     Intent webDialogIntent = new Intent();
/* 114 */     NativeProtocol.setupProtocolRequestIntent(webDialogIntent, appCall
/*     */     
/* 116 */       .getCallId().toString(), actionName, 
/*     */       
/* 118 */       NativeProtocol.getLatestKnownVersion(), intentParameters);
/*     */     
/* 120 */     webDialogIntent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
/* 121 */     webDialogIntent.setAction("FacebookDialogFragment");
/*     */     
/* 123 */     appCall.setRequestIntent(webDialogIntent);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void setupAppCallForWebFallbackDialog(AppCall appCall, Bundle parameters, DialogFeature feature)
/*     */   {
/* 130 */     Validate.hasFacebookActivity(FacebookSdk.getApplicationContext());
/* 131 */     Validate.hasInternetPermissions(FacebookSdk.getApplicationContext());
/*     */     
/* 133 */     String featureName = feature.name();
/* 134 */     Uri fallbackUrl = getDialogWebFallbackUri(feature);
/* 135 */     if (fallbackUrl == null) {
/* 136 */       throw new FacebookException("Unable to fetch the Url for the DialogFeature : '" + featureName + "'");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 142 */     int protocolVersion = NativeProtocol.getLatestKnownVersion();
/* 143 */     Bundle webParams = ServerProtocol.getQueryParamsForPlatformActivityIntentWebFallback(appCall
/* 144 */       .getCallId().toString(), protocolVersion, parameters);
/*     */     
/*     */ 
/* 147 */     if (webParams == null) {
/* 148 */       throw new FacebookException("Unable to fetch the app's key-hash");
/*     */     }
/*     */     
/*     */ 
/* 152 */     if (fallbackUrl.isRelative()) {
/* 153 */       fallbackUrl = Utility.buildUri(
/* 154 */         ServerProtocol.getDialogAuthority(), fallbackUrl
/* 155 */         .toString(), webParams);
/*     */     }
/*     */     else {
/* 158 */       fallbackUrl = Utility.buildUri(fallbackUrl
/* 159 */         .getAuthority(), fallbackUrl
/* 160 */         .getPath(), webParams);
/*     */     }
/*     */     
/*     */ 
/* 164 */     Bundle intentParameters = new Bundle();
/* 165 */     intentParameters.putString("url", fallbackUrl.toString());
/* 166 */     intentParameters.putBoolean("is_fallback", true);
/*     */     
/* 168 */     Intent webDialogIntent = new Intent();
/* 169 */     NativeProtocol.setupProtocolRequestIntent(webDialogIntent, appCall
/*     */     
/* 171 */       .getCallId().toString(), feature
/* 172 */       .getAction(), 
/* 173 */       NativeProtocol.getLatestKnownVersion(), intentParameters);
/*     */     
/* 175 */     webDialogIntent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
/* 176 */     webDialogIntent.setAction("FacebookDialogFragment");
/*     */     
/* 178 */     appCall.setRequestIntent(webDialogIntent);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void setupAppCallForNativeDialog(AppCall appCall, ParameterProvider parameterProvider, DialogFeature feature)
/*     */   {
/* 185 */     Context context = FacebookSdk.getApplicationContext();
/* 186 */     String action = feature.getAction();
/* 187 */     int protocolVersion = getProtocolVersionForNativeDialog(feature);
/* 188 */     if (protocolVersion == -1) {
/* 189 */       throw new FacebookException("Cannot present this dialog. This likely means that the Facebook app is not installed.");
/*     */     }
/*     */     
/*     */     Bundle params;
/*     */     
/*     */     Bundle params;
/* 195 */     if (NativeProtocol.isVersionCompatibleWithBucketedIntent(protocolVersion))
/*     */     {
/* 197 */       params = parameterProvider.getParameters();
/*     */     }
/*     */     else {
/* 200 */       params = parameterProvider.getLegacyParameters();
/*     */     }
/* 202 */     if (params == null) {
/* 203 */       params = new Bundle();
/*     */     }
/*     */     
/* 206 */     Intent intent = NativeProtocol.createPlatformActivityIntent(context, appCall
/*     */     
/* 208 */       .getCallId().toString(), action, protocolVersion, params);
/*     */     
/*     */ 
/*     */ 
/* 212 */     if (intent == null) {
/* 213 */       throw new FacebookException("Unable to create Intent; this likely means theFacebook app is not installed.");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 218 */     appCall.setRequestIntent(intent);
/*     */   }
/*     */   
/*     */   private static Uri getDialogWebFallbackUri(DialogFeature feature) {
/* 222 */     String featureName = feature.name();
/* 223 */     String action = feature.getAction();
/* 224 */     String applicationId = FacebookSdk.getApplicationId();
/*     */     
/*     */ 
/* 227 */     FetchedAppSettings.DialogFeatureConfig config = FetchedAppSettings.getDialogFeatureConfig(applicationId, action, featureName);
/* 228 */     Uri fallbackUrl = null;
/* 229 */     if (config != null) {
/* 230 */       fallbackUrl = config.getFallbackUrl();
/*     */     }
/*     */     
/* 233 */     return fallbackUrl;
/*     */   }
/*     */   
/*     */   public static int getProtocolVersionForNativeDialog(DialogFeature feature)
/*     */   {
/* 238 */     String applicationId = FacebookSdk.getApplicationId();
/* 239 */     String action = feature.getAction();
/* 240 */     int[] featureVersionSpec = getVersionSpecForFeature(applicationId, action, feature);
/*     */     
/* 242 */     return NativeProtocol.getLatestAvailableProtocolVersionForAction(action, featureVersionSpec);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int[] getVersionSpecForFeature(String applicationId, String actionName, DialogFeature feature)
/*     */   {
/* 254 */     FetchedAppSettings.DialogFeatureConfig config = FetchedAppSettings.getDialogFeatureConfig(applicationId, actionName, feature.name());
/* 255 */     if (config != null) {
/* 256 */       return config.getVersionSpec();
/*     */     }
/* 258 */     return new int[] { feature.getMinVersion() };
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void logDialogActivity(Context context, String eventName, String outcome)
/*     */   {
/* 266 */     AppEventsLogger logger = AppEventsLogger.newLogger(context);
/* 267 */     Bundle parameters = new Bundle();
/* 268 */     parameters.putString("fb_dialog_outcome", outcome);
/* 269 */     logger.logSdkEvent(eventName, null, parameters);
/*     */   }
/*     */   
/*     */   public static abstract interface ParameterProvider
/*     */   {
/*     */     public abstract Bundle getParameters();
/*     */     
/*     */     public abstract Bundle getLegacyParameters();
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/DialogPresenter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */