/*     */ package com.facebook.internal;
/*     */ 
/*     */ import android.net.Uri;
/*     */ import java.util.EnumSet;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class FetchedAppSettings
/*     */ {
/*     */   private boolean supportsImplicitLogging;
/*     */   private String nuxContent;
/*     */   private boolean nuxEnabled;
/*     */   private boolean customTabsEnabled;
/*     */   private int sessionTimeoutInSeconds;
/*     */   private EnumSet<SmartLoginOption> smartLoginOptions;
/*     */   private Map<String, Map<String, DialogFeatureConfig>> dialogConfigMap;
/*     */   private boolean automaticLoggingEnabled;
/*     */   private FacebookRequestErrorClassification errorClassification;
/*     */   private String smartLoginBookmarkIconURL;
/*     */   private String smartLoginMenuIconURL;
/*     */   
/*     */   public FetchedAppSettings(boolean supportsImplicitLogging, String nuxContent, boolean nuxEnabled, boolean customTabsEnabled, int sessionTimeoutInSeconds, EnumSet<SmartLoginOption> smartLoginOptions, Map<String, Map<String, DialogFeatureConfig>> dialogConfigMap, boolean automaticLoggingEnabled, FacebookRequestErrorClassification errorClassification, String smartLoginBookmarkIconURL, String smartLoginMenuIconURL)
/*     */   {
/*  61 */     this.supportsImplicitLogging = supportsImplicitLogging;
/*  62 */     this.nuxContent = nuxContent;
/*  63 */     this.nuxEnabled = nuxEnabled;
/*  64 */     this.customTabsEnabled = customTabsEnabled;
/*  65 */     this.dialogConfigMap = dialogConfigMap;
/*  66 */     this.errorClassification = errorClassification;
/*  67 */     this.sessionTimeoutInSeconds = sessionTimeoutInSeconds;
/*  68 */     this.automaticLoggingEnabled = automaticLoggingEnabled;
/*  69 */     this.smartLoginOptions = smartLoginOptions;
/*  70 */     this.smartLoginBookmarkIconURL = smartLoginBookmarkIconURL;
/*  71 */     this.smartLoginMenuIconURL = smartLoginMenuIconURL;
/*     */   }
/*     */   
/*     */   public boolean supportsImplicitLogging() {
/*  75 */     return this.supportsImplicitLogging;
/*     */   }
/*     */   
/*     */   public String getNuxContent() {
/*  79 */     return this.nuxContent;
/*     */   }
/*     */   
/*     */   public boolean getNuxEnabled() {
/*  83 */     return this.nuxEnabled;
/*     */   }
/*     */   
/*     */   public boolean getCustomTabsEnabled() {
/*  87 */     return this.customTabsEnabled;
/*     */   }
/*     */   
/*     */   public int getSessionTimeoutInSeconds() {
/*  91 */     return this.sessionTimeoutInSeconds;
/*     */   }
/*     */   
/*     */   public boolean getAutomaticLoggingEnabled() {
/*  95 */     return this.automaticLoggingEnabled;
/*     */   }
/*     */   
/*     */   public EnumSet<SmartLoginOption> getSmartLoginOptions() {
/*  99 */     return this.smartLoginOptions;
/*     */   }
/*     */   
/*     */   public Map<String, Map<String, DialogFeatureConfig>> getDialogConfigurations() {
/* 103 */     return this.dialogConfigMap;
/*     */   }
/*     */   
/*     */   public FacebookRequestErrorClassification getErrorClassification() {
/* 107 */     return this.errorClassification;
/*     */   }
/*     */   
/* 110 */   public String getSmartLoginBookmarkIconURL() { return this.smartLoginBookmarkIconURL; }
/* 111 */   public String getSmartLoginMenuIconURL() { return this.smartLoginMenuIconURL; }
/*     */   
/*     */   public static class DialogFeatureConfig
/*     */   {
/*     */     private static final String DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR = "\\|";
/*     */     private static final String DIALOG_CONFIG_NAME_KEY = "name";
/*     */     private static final String DIALOG_CONFIG_VERSIONS_KEY = "versions";
/*     */     private static final String DIALOG_CONFIG_URL_KEY = "url";
/*     */     
/*     */     public static DialogFeatureConfig parseDialogConfig(JSONObject dialogConfigJSON) {
/* 121 */       String dialogNameWithFeature = dialogConfigJSON.optString("name");
/* 122 */       if (Utility.isNullOrEmpty(dialogNameWithFeature)) {
/* 123 */         return null;
/*     */       }
/*     */       
/* 126 */       String[] components = dialogNameWithFeature.split("\\|");
/*     */       
/* 128 */       if (components.length != 2)
/*     */       {
/*     */ 
/* 131 */         return null;
/*     */       }
/*     */       
/* 134 */       String dialogName = components[0];
/* 135 */       String featureName = components[1];
/* 136 */       if ((Utility.isNullOrEmpty(dialogName)) || (Utility.isNullOrEmpty(featureName))) {
/* 137 */         return null;
/*     */       }
/*     */       
/* 140 */       String urlString = dialogConfigJSON.optString("url");
/* 141 */       Uri fallbackUri = null;
/* 142 */       if (!Utility.isNullOrEmpty(urlString)) {
/* 143 */         fallbackUri = Uri.parse(urlString);
/*     */       }
/*     */       
/* 146 */       JSONArray versionsJSON = dialogConfigJSON.optJSONArray("versions");
/*     */       
/* 148 */       int[] featureVersionSpec = parseVersionSpec(versionsJSON);
/*     */       
/* 150 */       return new DialogFeatureConfig(dialogName, featureName, fallbackUri, featureVersionSpec);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     private static int[] parseVersionSpec(JSONArray versionsJSON)
/*     */     {
/* 158 */       int[] versionSpec = null;
/* 159 */       if (versionsJSON != null) {
/* 160 */         int numVersions = versionsJSON.length();
/* 161 */         versionSpec = new int[numVersions];
/* 162 */         for (int i = 0; i < numVersions; i++)
/*     */         {
/* 164 */           int version = versionsJSON.optInt(i, -1);
/* 165 */           if (version == -1)
/*     */           {
/*     */ 
/* 168 */             String versionString = versionsJSON.optString(i);
/* 169 */             if (!Utility.isNullOrEmpty(versionString)) {
/*     */               try {
/* 171 */                 version = Integer.parseInt(versionString);
/*     */               } catch (NumberFormatException nfe) {
/* 173 */                 Utility.logd("FacebookSDK", nfe);
/* 174 */                 version = -1;
/*     */               }
/*     */             }
/*     */           }
/*     */           
/* 179 */           versionSpec[i] = version;
/*     */         }
/*     */       }
/*     */       
/* 183 */       return versionSpec;
/*     */     }
/*     */     
/*     */ 
/*     */     private String dialogName;
/*     */     
/*     */     private String featureName;
/*     */     
/*     */     private Uri fallbackUrl;
/*     */     
/*     */     private int[] featureVersionSpec;
/*     */     private DialogFeatureConfig(String dialogName, String featureName, Uri fallbackUrl, int[] featureVersionSpec)
/*     */     {
/* 196 */       this.dialogName = dialogName;
/* 197 */       this.featureName = featureName;
/* 198 */       this.fallbackUrl = fallbackUrl;
/* 199 */       this.featureVersionSpec = featureVersionSpec;
/*     */     }
/*     */     
/*     */     public String getDialogName() {
/* 203 */       return this.dialogName;
/*     */     }
/*     */     
/*     */     public String getFeatureName() {
/* 207 */       return this.featureName;
/*     */     }
/*     */     
/*     */     public Uri getFallbackUrl() {
/* 211 */       return this.fallbackUrl;
/*     */     }
/*     */     
/*     */     public int[] getVersionSpec() {
/* 215 */       return this.featureVersionSpec;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static DialogFeatureConfig getDialogFeatureConfig(String applicationId, String actionName, String featureName)
/*     */   {
/* 223 */     if ((Utility.isNullOrEmpty(actionName)) || (Utility.isNullOrEmpty(featureName))) {
/* 224 */       return null;
/*     */     }
/*     */     
/*     */ 
/* 228 */     FetchedAppSettings settings = FetchedAppSettingsManager.getAppSettingsWithoutQuery(applicationId);
/* 229 */     if (settings != null)
/*     */     {
/* 231 */       Map<String, DialogFeatureConfig> featureMap = (Map)settings.getDialogConfigurations().get(actionName);
/* 232 */       if (featureMap != null) {
/* 233 */         return (DialogFeatureConfig)featureMap.get(featureName);
/*     */       }
/*     */     }
/* 236 */     return null;
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/FetchedAppSettings.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */