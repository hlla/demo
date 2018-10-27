/*     */ package com.facebook.internal;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.content.SharedPreferences;
/*     */ import android.content.SharedPreferences.Editor;
/*     */ import android.os.Bundle;
/*     */ import android.text.TextUtils;
/*     */ import com.facebook.FacebookSdk;
/*     */ import com.facebook.GraphRequest;
/*     */ import com.facebook.GraphResponse;
/*     */ import com.facebook.appevents.internal.Constants;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.Executor;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class FetchedAppSettingsManager
/*     */ {
/*     */   private static final String APP_SETTINGS_PREFS_STORE = "com.facebook.internal.preferences.APP_SETTINGS";
/*     */   private static final String APP_SETTINGS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_SETTINGS.%s";
/*     */   private static final String APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING = "supports_implicit_sdk_logging";
/*     */   private static final String APP_SETTING_NUX_CONTENT = "gdpv4_nux_content";
/*     */   private static final String APP_SETTING_NUX_ENABLED = "gdpv4_nux_enabled";
/*     */   private static final String APP_SETTING_CUSTOM_TABS_ENABLED = "gdpv4_chrome_custom_tabs_enabled";
/*     */   private static final String APP_SETTING_DIALOG_CONFIGS = "android_dialog_configs";
/*     */   private static final String APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES = "android_sdk_error_categories";
/*     */   private static final String APP_SETTING_APP_EVENTS_SESSION_TIMEOUT = "app_events_session_timeout";
/*     */   private static final String APP_SETTING_APP_EVENTS_FEATURE_BITMASK = "app_events_feature_bitmask";
/*     */   private static final int AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD = 8;
/*     */   private static final String APP_SETTING_SMART_LOGIN_OPTIONS = "seamless_login";
/*     */   private static final String SMART_LOGIN_BOOKMARK_ICON_URL = "smart_login_bookmark_icon_url";
/*     */   private static final String SMART_LOGIN_MENU_ICON_URL = "smart_login_menu_icon_url";
/*  70 */   private static final String[] APP_SETTING_FIELDS = { "supports_implicit_sdk_logging", "gdpv4_nux_content", "gdpv4_nux_enabled", "gdpv4_chrome_custom_tabs_enabled", "android_dialog_configs", "android_sdk_error_categories", "app_events_session_timeout", "app_events_feature_bitmask", "seamless_login", "smart_login_bookmark_icon_url", "smart_login_menu_icon_url" };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static final String APPLICATION_FIELDS = "fields";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  85 */   private static Map<String, FetchedAppSettings> fetchedAppSettings = new ConcurrentHashMap();
/*     */   
/*  87 */   private static AtomicBoolean loadingSettings = new AtomicBoolean(false);
/*     */   
/*     */ 
/*     */ 
/*     */   public static void loadAppSettingsAsync(Context context, final String applicationId)
/*     */   {
/*  93 */     boolean canStartLoading = loadingSettings.compareAndSet(false, true);
/*  94 */     if ((Utility.isNullOrEmpty(applicationId)) || 
/*  95 */       (fetchedAppSettings.containsKey(applicationId)) || (!canStartLoading))
/*     */     {
/*  97 */       return;
/*     */     }
/*     */     
/* 100 */     final String settingsKey = String.format("com.facebook.internal.APP_SETTINGS.%s", new Object[] { applicationId });
/*     */     
/* 102 */     FacebookSdk.getExecutor().execute(new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/* 106 */         SharedPreferences sharedPrefs = this.val$context.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0);
/*     */         
/*     */ 
/* 109 */         String settingsJSONString = sharedPrefs.getString(settingsKey, null);
/* 110 */         if (!Utility.isNullOrEmpty(settingsJSONString)) {
/* 111 */           JSONObject settingsJSON = null;
/*     */           try {
/* 113 */             settingsJSON = new JSONObject(settingsJSONString);
/*     */           } catch (JSONException je) {
/* 115 */             Utility.logd("FacebookSDK", je);
/*     */           }
/* 117 */           if (settingsJSON != null) {
/* 118 */             FetchedAppSettingsManager.parseAppSettingsFromJSON(applicationId, settingsJSON);
/*     */           }
/*     */         }
/*     */         
/* 122 */         JSONObject resultJSON = FetchedAppSettingsManager.getAppSettingsQueryResponse(applicationId);
/* 123 */         if (resultJSON != null) {
/* 124 */           FetchedAppSettingsManager.parseAppSettingsFromJSON(applicationId, resultJSON);
/*     */           
/* 126 */           sharedPrefs.edit()
/* 127 */             .putString(settingsKey, resultJSON.toString())
/* 128 */             .apply();
/*     */         }
/*     */         
/* 131 */         FetchedAppSettingsManager.loadingSettings.set(false);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static FetchedAppSettings getAppSettingsWithoutQuery(String applicationId)
/*     */   {
/* 138 */     return applicationId != null ? (FetchedAppSettings)fetchedAppSettings.get(applicationId) : null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static FetchedAppSettings queryAppSettings(String applicationId, boolean forceRequery)
/*     */   {
/* 147 */     if ((!forceRequery) && (fetchedAppSettings.containsKey(applicationId))) {
/* 148 */       return (FetchedAppSettings)fetchedAppSettings.get(applicationId);
/*     */     }
/*     */     
/* 151 */     JSONObject response = getAppSettingsQueryResponse(applicationId);
/* 152 */     if (response == null) {
/* 153 */       return null;
/*     */     }
/*     */     
/* 156 */     return parseAppSettingsFromJSON(applicationId, response);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static FetchedAppSettings parseAppSettingsFromJSON(String applicationId, JSONObject settingsJSON)
/*     */   {
/* 163 */     JSONArray errorClassificationJSON = settingsJSON.optJSONArray("android_sdk_error_categories");
/*     */     
/*     */ 
/*     */ 
/* 167 */     FacebookRequestErrorClassification errorClassification = errorClassificationJSON == null ? FacebookRequestErrorClassification.getDefaultErrorClassification() : FacebookRequestErrorClassification.createFromJSON(errorClassificationJSON);
/*     */     
/*     */ 
/* 170 */     int featureBitmask = settingsJSON.optInt("app_events_feature_bitmask", 0);
/* 171 */     boolean automaticLoggingEnabled = (featureBitmask & 0x8) != 0;
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
/* 186 */     FetchedAppSettings result = new FetchedAppSettings(settingsJSON.optBoolean("supports_implicit_sdk_logging", false), settingsJSON.optString("gdpv4_nux_content", ""), settingsJSON.optBoolean("gdpv4_nux_enabled", false), settingsJSON.optBoolean("gdpv4_chrome_custom_tabs_enabled", false), settingsJSON.optInt("app_events_session_timeout", Constants.getDefaultAppEventsSessionTimeoutInSeconds()), SmartLoginOption.parseOptions(settingsJSON.optLong("seamless_login")), parseDialogConfigurations(settingsJSON.optJSONObject("android_dialog_configs")), automaticLoggingEnabled, errorClassification, settingsJSON.optString("smart_login_bookmark_icon_url"), settingsJSON.optString("smart_login_menu_icon_url"));
/*     */     
/*     */ 
/* 189 */     fetchedAppSettings.put(applicationId, result);
/*     */     
/* 191 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   private static JSONObject getAppSettingsQueryResponse(String applicationId)
/*     */   {
/* 197 */     Bundle appSettingsParams = new Bundle();
/* 198 */     appSettingsParams.putString("fields", TextUtils.join(",", APP_SETTING_FIELDS));
/*     */     
/* 200 */     GraphRequest request = GraphRequest.newGraphPathRequest(null, applicationId, null);
/* 201 */     request.setSkipClientToken(true);
/* 202 */     request.setParameters(appSettingsParams);
/*     */     
/* 204 */     return request.executeAndWait().getJSONObject();
/*     */   }
/*     */   
/*     */   private static Map<String, Map<String, FetchedAppSettings.DialogFeatureConfig>> parseDialogConfigurations(JSONObject dialogConfigResponse)
/*     */   {
/* 209 */     HashMap<String, Map<String, FetchedAppSettings.DialogFeatureConfig>> dialogConfigMap = new HashMap();
/*     */     
/*     */ 
/* 212 */     if (dialogConfigResponse != null) {
/* 213 */       JSONArray dialogConfigData = dialogConfigResponse.optJSONArray("data");
/* 214 */       if (dialogConfigData != null) {
/* 215 */         for (int i = 0; i < dialogConfigData.length(); i++)
/*     */         {
/* 217 */           FetchedAppSettings.DialogFeatureConfig dialogConfig = FetchedAppSettings.DialogFeatureConfig.parseDialogConfig(dialogConfigData
/* 218 */             .optJSONObject(i));
/* 219 */           if (dialogConfig != null)
/*     */           {
/*     */ 
/*     */ 
/* 223 */             String dialogName = dialogConfig.getDialogName();
/*     */             
/* 225 */             Map<String, FetchedAppSettings.DialogFeatureConfig> featureMap = (Map)dialogConfigMap.get(dialogName);
/* 226 */             if (featureMap == null) {
/* 227 */               featureMap = new HashMap();
/* 228 */               dialogConfigMap.put(dialogName, featureMap);
/*     */             }
/* 230 */             featureMap.put(dialogConfig.getFeatureName(), dialogConfig);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 235 */     return dialogConfigMap;
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/FetchedAppSettingsManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */