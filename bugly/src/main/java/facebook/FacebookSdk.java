/*     */ package com.facebook;
/*     */ 
/*     */

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;

import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AppEventsLoggerUtility;
import com.facebook.internal.AppEventsLoggerUtility.GraphAPIActivityType;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.BoltsMeasurementEventListener;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.LockOnGetVariable;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import example.com.testlib.R;

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
/*     */ public final class FacebookSdk
/*     */ {
/*  63 */   private static final String TAG = FacebookSdk.class.getCanonicalName();
/*  64 */   private static final HashSet<LoggingBehavior> loggingBehaviors = new HashSet(
/*  65 */     Arrays.asList(new LoggingBehavior[] { LoggingBehavior.DEVELOPER_ERRORS }));
/*     */   private static volatile Executor executor;
/*     */   private static volatile String applicationId;
/*     */   private static volatile String applicationName;
/*     */   private static volatile String appClientToken;
/*     */   private static volatile int webDialogTheme;
/*     */   private static final String FACEBOOK_COM = "facebook.com";
/*  72 */   private static volatile String facebookDomain = "facebook.com";
/*  73 */   private static AtomicLong onProgressThreshold = new AtomicLong(65536L);
/*  74 */   private static volatile boolean isDebugEnabled = false;
/*  75 */   private static boolean isLegacyTokenUpgradeSupported = false;
/*     */   private static LockOnGetVariable<File> cacheDir;
/*     */   private static Context applicationContext;
/*     */   private static final int DEFAULT_CORE_POOL_SIZE = 5;
/*     */   private static final int DEFAULT_MAXIMUM_POOL_SIZE = 128;
/*     */   private static final int DEFAULT_KEEP_ALIVE = 1;
/*  81 */   private static int callbackRequestCodeOffset = 64206;
/*  82 */   private static final Object LOCK = new Object();
/*  83 */   private static final int DEFAULT_THEME = R.style.com_facebook_activity_theme;
/*  84 */   private static String graphApiVersion = ServerProtocol.getDefaultAPIVersion();
/*     */   
/*     */   private static final int MAX_REQUEST_CODE_RANGE = 100;
/*     */   
/*     */   private static final String ATTRIBUTION_PREFERENCES = "com.facebook.sdk.attributionTracking";
/*     */   
/*     */   private static final String PUBLISH_ACTIVITY_PATH = "%s/activities";
/*  91 */   private static final BlockingQueue<Runnable> DEFAULT_WORK_QUEUE = new LinkedBlockingQueue(10);
/*     */   
/*     */ 
/*  94 */   private static final ThreadFactory DEFAULT_THREAD_FACTORY = new ThreadFactory() {
/*  95 */     private final AtomicInteger counter = new AtomicInteger(0);
/*     */     
/*     */     public Thread newThread(Runnable runnable) {
/*  98 */       return new Thread(runnable, "FacebookSdk #" + this.counter.incrementAndGet());
/*     */     }
/*     */   };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static final String CALLBACK_OFFSET_CHANGED_AFTER_INIT = "The callback request code offset can't be updated once the SDK is initialized.";
/*     */   
/*     */ 
/*     */ 
/*     */   static final String CALLBACK_OFFSET_NEGATIVE = "The callback request code offset can't be negative.";
/*     */   
/*     */ 
/*     */ 
/*     */   public static final String APPLICATION_ID_PROPERTY = "com.facebook.sdk.ApplicationId";
/*     */   
/*     */ 
/*     */ 
/*     */   public static final String APPLICATION_NAME_PROPERTY = "com.facebook.sdk.ApplicationName";
/*     */   
/*     */ 
/*     */ 
/*     */   public static final String CLIENT_TOKEN_PROPERTY = "com.facebook.sdk.ClientToken";
/*     */   
/*     */ 
/*     */ 
/*     */   public static final String WEB_DIALOG_THEME = "com.facebook.sdk.WebDialogTheme";
/*     */   
/*     */ 
/*     */ 
/* 129 */   private static Boolean sdkInitialized = Boolean.valueOf(false);
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
/*     */   public static synchronized void sdkInitialize(Context applicationContext, int callbackRequestCodeOffset)
/*     */   {
/* 143 */     sdkInitialize(applicationContext, callbackRequestCodeOffset, null);
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
/*     */   public static synchronized void sdkInitialize(Context applicationContext, int callbackRequestCodeOffset, InitializeCallback callback)
/*     */   {
/* 161 */     if ((sdkInitialized.booleanValue()) && (callbackRequestCodeOffset != callbackRequestCodeOffset)) {
/* 162 */       throw new FacebookException("The callback request code offset can't be updated once the SDK is initialized.");
/*     */     }
/* 164 */     if (callbackRequestCodeOffset < 0) {
/* 165 */       throw new FacebookException("The callback request code offset can't be negative.");
/*     */     }
/* 167 */     callbackRequestCodeOffset = callbackRequestCodeOffset;
/* 168 */     sdkInitialize(applicationContext, callback);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static synchronized void sdkInitialize(Context applicationContext)
/*     */   {
/* 177 */     sdkInitialize(applicationContext, null);
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
/*     */   public static synchronized void sdkInitialize(final Context applicationContext, InitializeCallback callback)
/*     */   {
/* 190 */     if (sdkInitialized.booleanValue()) {
/* 191 */       if (callback != null) {
/* 192 */         callback.onInitialized();
/*     */       }
/* 194 */       return;
/*     */     }
/*     */     
/* 197 */     Validate.notNull(applicationContext, "applicationContext");
/*     */     
/*     */ 
/*     */ 
/* 201 */     Validate.hasFacebookActivity(applicationContext, false);
/* 202 */     Validate.hasInternetPermissions(applicationContext, false);
/*     */     
/* 204 */     applicationContext = applicationContext.getApplicationContext();
/*     */     
/*     */ 
/* 207 */     loadDefaultsFromMetadata(applicationContext);
/*     */     
/*     */ 
/*     */ 
/* 211 */     sdkInitialized = Boolean.valueOf(true);
/*     */     
/*     */ 
/* 214 */     FetchedAppSettingsManager.loadAppSettingsAsync(applicationContext, applicationId);
/*     */     
/* 216 */     NativeProtocol.updateAllAvailableProtocolVersionsAsync();
/*     */     
/* 218 */     BoltsMeasurementEventListener.getInstance(applicationContext);
/*     */     
/* 220 */     cacheDir = new LockOnGetVariable(new Callable()
/*     */     {
/*     */       public File call() throws Exception
/*     */       {
/* 224 */         return FacebookSdk.applicationContext.getCacheDir();
/*     */       }
/*     */       
/* 227 */     });
/* 228 */     FutureTask<Void> futureTask = new FutureTask(new Callable()
/*     */     {
/*     */       public Void call() throws Exception
/*     */       {
/* 232 */         AccessTokenManager.getInstance().loadCurrentAccessToken();
/* 233 */         ProfileManager.getInstance().loadCurrentProfile();
/* 234 */         if ((AccessToken.getCurrentAccessToken() != null) && 
/* 235 */           (Profile.getCurrentProfile() == null))
/*     */         {
/*     */ 
/* 238 */           Profile.fetchProfileForCurrentAccessToken();
/*     */         }
/*     */         
/* 241 */         if (this.val$callback != null) {
/* 242 */           this.val$callback.onInitialized();
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 247 */         AppEventsLogger.newLogger(applicationContext.getApplicationContext()).flush();
/*     */         
/* 249 */         return null;
/*     */       }
/* 251 */     });
/* 252 */     getExecutor().execute(futureTask);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static synchronized boolean isInitialized()
/*     */   {
/* 260 */     return sdkInitialized.booleanValue();
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public static java.util.Set<LoggingBehavior> getLoggingBehaviors()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: getstatic 37	com/facebook/FacebookSdk:loggingBehaviors	Ljava/util/HashSet;
/*     */     //   3: dup
/*     */     //   4: astore_0
/*     */     //   5: monitorenter
/*     */     //   6: new 38	java/util/HashSet
/*     */     //   9: dup
/*     */     //   10: getstatic 37	com/facebook/FacebookSdk:loggingBehaviors	Ljava/util/HashSet;
/*     */     //   13: invokespecial 39	java/util/HashSet:<init>	(Ljava/util/Collection;)V
/*     */     //   16: invokestatic 40	java/util/Collections:unmodifiableSet	(Ljava/util/Set;)Ljava/util/Set;
/*     */     //   19: aload_0
/*     */     //   20: monitorexit
/*     */     //   21: areturn
/*     */     //   22: astore_1
/*     */     //   23: aload_0
/*     */     //   24: monitorexit
/*     */     //   25: aload_1
/*     */     //   26: athrow
/*     */     // Line number table:
/*     */     //   Java source line #272	-> byte code offset #0
/*     */     //   Java source line #273	-> byte code offset #6
/*     */     //   Java source line #274	-> byte code offset #22
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   4	20	0	Ljava/lang/Object;	Object
/*     */     //   22	4	1	localObject1	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   6	21	22	finally
/*     */     //   22	25	22	finally
/*     */   }
/*     */   
/*     */   public static void addLoggingBehavior(LoggingBehavior behavior)
/*     */   {
/* 287 */     synchronized (loggingBehaviors) {
/* 288 */       loggingBehaviors.add(behavior);
/* 289 */       updateGraphDebugBehavior();
/*     */     }
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
/*     */   public static void removeLoggingBehavior(LoggingBehavior behavior)
/*     */   {
/* 303 */     synchronized (loggingBehaviors) {
/* 304 */       loggingBehaviors.remove(behavior);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void clearLoggingBehaviors()
/*     */   {
/* 315 */     synchronized (loggingBehaviors) {
/* 316 */       loggingBehaviors.clear();
/*     */     }
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
/*     */   public static boolean isLoggingBehaviorEnabled(LoggingBehavior behavior)
/*     */   {
/* 331 */     synchronized (loggingBehaviors) {
/* 332 */       return (isDebugEnabled()) && (loggingBehaviors.contains(behavior));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static boolean isDebugEnabled()
/*     */   {
/* 340 */     return isDebugEnabled;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setIsDebugEnabled(boolean enabled)
/*     */   {
/* 348 */     isDebugEnabled = enabled;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isLegacyTokenUpgradeSupported()
/*     */   {
/* 357 */     return isLegacyTokenUpgradeSupported;
/*     */   }
/*     */   
/*     */   private static void updateGraphDebugBehavior() {
/* 361 */     if ((loggingBehaviors.contains(LoggingBehavior.GRAPH_API_DEBUG_INFO)) && 
/* 362 */       (!loggingBehaviors.contains(LoggingBehavior.GRAPH_API_DEBUG_WARNING))) {
/* 363 */       loggingBehaviors.add(LoggingBehavior.GRAPH_API_DEBUG_WARNING);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setLegacyTokenUpgradeSupported(boolean supported)
/*     */   {
/* 372 */     isLegacyTokenUpgradeSupported = supported;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Executor getExecutor()
/*     */   {
/* 384 */     synchronized (LOCK) {
/* 385 */       if (executor == null) {
/* 386 */         executor = AsyncTask.THREAD_POOL_EXECUTOR;
/*     */       }
/*     */     }
/* 389 */     return executor;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setExecutor(Executor executor)
/*     */   {
/* 399 */     Validate.notNull(executor, "executor");
/* 400 */     synchronized (LOCK) {
/* 401 */       executor = executor;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getFacebookDomain()
/*     */   {
/* 412 */     return facebookDomain;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setFacebookDomain(String facebookDomain)
/*     */   {
/* 424 */     Log.w(TAG, "WARNING: Calling setFacebookDomain from non-DEBUG code.");
/*     */     
/*     */ 
/* 427 */     facebookDomain = facebookDomain;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Context getApplicationContext()
/*     */   {
/* 435 */     Validate.sdkInitialized();
/* 436 */     return applicationContext;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setGraphApiVersion(String graphApiVersion)
/*     */   {
/* 446 */     if ((!Utility.isNullOrEmpty(graphApiVersion)) && 
/* 447 */       (!graphApiVersion.equals(graphApiVersion))) {
/* 448 */       graphApiVersion = graphApiVersion;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getGraphApiVersion()
/*     */   {
/* 459 */     return graphApiVersion;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void publishInstallAsync(Context context, final String applicationId)
/*     */   {
/* 470 */     Context applicationContext = context.getApplicationContext();
/* 471 */     getExecutor().execute(new Runnable()
/*     */     {
/*     */       public void run() {
/* 474 */         FacebookSdk.publishInstallAndWaitForResponse(this.val$applicationContext, applicationId);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   static GraphResponse publishInstallAndWaitForResponse(Context context, String applicationId)
/*     */   {
/*     */     try
/*     */     {
/* 483 */       if ((context == null) || (applicationId == null)) {
/* 484 */         throw new IllegalArgumentException("Both context and applicationId must be non-null");
/*     */       }
/* 486 */       AttributionIdentifiers identifiers = AttributionIdentifiers.getAttributionIdentifiers(context);
/* 487 */       SharedPreferences preferences = context.getSharedPreferences("com.facebook.sdk.attributionTracking", 0);
/* 488 */       String pingKey = applicationId + "ping";
/* 489 */       String jsonKey = applicationId + "json";
/* 490 */       long lastPing = preferences.getLong(pingKey, 0L);
/* 491 */       String lastResponseJSON = preferences.getString(jsonKey, null);
/*     */       
/*     */       try
/*     */       {
/* 495 */         publishParams = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(GraphAPIActivityType.MOBILE_INSTALL_EVENT, identifiers,
/*     */         
/*     */ 
/* 498 */           AppEventsLogger.getAnonymousAppDeviceGUID(context), 
/* 499 */           getLimitEventAndDataUsage(context), context);
/*     */       } catch (JSONException e) {
/*     */         JSONObject publishParams;
/* 502 */         throw new FacebookException("An error occurred while publishing install.", e);
/*     */       }
/*     */       JSONObject publishParams;
/* 505 */       String publishUrl = String.format("%s/activities", new Object[] { applicationId });
/* 506 */       GraphRequest publishRequest = GraphRequest.newPostRequest(null, publishUrl, publishParams, null);
/*     */       
/* 508 */       if (lastPing != 0L) {
/* 509 */         JSONObject graphObject = null;
/*     */         try {
/* 511 */           if (lastResponseJSON != null) {
/* 512 */             graphObject = new JSONObject(lastResponseJSON);
/*     */           }
/*     */         }
/*     */         catch (JSONException localJSONException1) {}
/*     */         
/*     */ 
/* 518 */         if (graphObject == null)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 523 */           return (GraphResponse)GraphResponse.createResponsesFromString("true", null, new GraphRequestBatch(new GraphRequest[] { publishRequest })).get(0);
/*     */         }
/* 525 */         return new GraphResponse(null, null, null, graphObject);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 530 */       GraphResponse publishResponse = publishRequest.executeAndWait();
/*     */       
/*     */ 
/* 533 */       Editor editor = preferences.edit();
/* 534 */       lastPing = System.currentTimeMillis();
/* 535 */       editor.putLong(pingKey, lastPing);
/*     */       
/*     */ 
/* 538 */       if (publishResponse.getJSONObject() != null) {
/* 539 */         editor.putString(jsonKey, publishResponse.getJSONObject().toString());
/*     */       }
/* 541 */       editor.apply();
/*     */       
/* 543 */       return publishResponse;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 547 */       Utility.logd("Facebook-publish", e);
/* 548 */       return new GraphResponse(null, null, new FacebookRequestError(null, e));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getSdkVersion()
/*     */   {
/* 558 */     return "4.17.0";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean getLimitEventAndDataUsage(Context context)
/*     */   {
/* 570 */     Validate.sdkInitialized();
/* 571 */     SharedPreferences preferences = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0);
/*     */     
/* 573 */     return preferences.getBoolean("limitEventUsage", false);
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
/*     */   public static void setLimitEventAndDataUsage(Context context, boolean limitEventUsage)
/*     */   {
/* 589 */     context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putBoolean("limitEventUsage", limitEventUsage).apply();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static long getOnProgressThreshold()
/*     */   {
/* 596 */     Validate.sdkInitialized();
/* 597 */     return onProgressThreshold.get();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setOnProgressThreshold(long threshold)
/*     */   {
/* 607 */     onProgressThreshold.set(threshold);
/*     */   }
/*     */   
/*     */   static void loadDefaultsFromMetadata(Context context)
/*     */   {
/* 612 */     if (context == null) {
/* 613 */       return;
/*     */     }
/*     */     
/* 616 */     ApplicationInfo ai = null;
/*     */     try {
/* 618 */       ai = context.getPackageManager().getApplicationInfo(context
/* 619 */         .getPackageName(), 128);
/*     */     } catch (NameNotFoundException e) {
/* 621 */       return;
/*     */     }
/*     */     
/* 624 */     if ((ai == null) || (ai.metaData == null)) {
/* 625 */       return;
/*     */     }
/*     */     
/* 628 */     if (applicationId == null) {
/* 629 */       Object appId = ai.metaData.get("com.facebook.sdk.ApplicationId");
/* 630 */       if ((appId instanceof String)) {
/* 631 */         String appIdString = (String)appId;
/* 632 */         if (appIdString.toLowerCase(Locale.ROOT).startsWith("fb")) {
/* 633 */           applicationId = appIdString.substring(2);
/*     */         } else {
/* 635 */           applicationId = appIdString;
/*     */         }
/* 637 */       } else if ((appId instanceof Integer)) {
/* 638 */         throw new FacebookException("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 644 */     if (applicationName == null) {
/* 645 */       applicationName = ai.metaData.getString("com.facebook.sdk.ApplicationName");
/*     */     }
/*     */     
/* 648 */     if (appClientToken == null) {
/* 649 */       appClientToken = ai.metaData.getString("com.facebook.sdk.ClientToken");
/*     */     }
/*     */     
/* 652 */     if (webDialogTheme == 0) {
/* 653 */       setWebDialogTheme(ai.metaData.getInt("com.facebook.sdk.WebDialogTheme"));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static String getApplicationSignature(Context context)
/*     */   {
/*     */     
/*     */     
/*     */ 
/* 664 */     if (context == null) {
/* 665 */       return null;
/*     */     }
/* 667 */     PackageManager packageManager = context.getPackageManager();
/* 668 */     if (packageManager == null) {
/* 669 */       return null;
/*     */     }
/*     */     
/* 672 */     String packageName = context.getPackageName();
/*     */     try
/*     */     {
/* 675 */       pInfo = packageManager.getPackageInfo(packageName, 64);
/*     */     } catch (NameNotFoundException e) { PackageInfo pInfo;
/* 677 */       return null;
/*     */     }
/*     */     PackageInfo pInfo;
/* 680 */     Signature[] signatures = pInfo.signatures;
/* 681 */     if ((signatures == null) || (signatures.length == 0)) {
/* 682 */       return null;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 687 */       md = MessageDigest.getInstance("SHA-1");
/*     */     } catch (NoSuchAlgorithmException e) { MessageDigest md;
/* 689 */       return null;
/*     */     }
/*     */     MessageDigest md;
/* 692 */     md.update(pInfo.signatures[0].toByteArray());
/* 693 */     return Base64.encodeToString(md.digest(), 9);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getApplicationId()
/*     */   {
/* 703 */     Validate.sdkInitialized();
/* 704 */     return applicationId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setApplicationId(String applicationId)
/*     */   {
/* 712 */     applicationId = applicationId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getApplicationName()
/*     */   {
/* 722 */     Validate.sdkInitialized();
/* 723 */     return applicationName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setApplicationName(String applicationName)
/*     */   {
/* 731 */     applicationName = applicationName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getClientToken()
/*     */   {
/* 740 */     Validate.sdkInitialized();
/* 741 */     return appClientToken;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setClientToken(String clientToken)
/*     */   {
/* 749 */     appClientToken = clientToken;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getWebDialogTheme()
/*     */   {
/* 757 */     Validate.sdkInitialized();
/* 758 */     return webDialogTheme;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setWebDialogTheme(int theme)
/*     */   {
/* 766 */     webDialogTheme = theme != 0 ? theme : DEFAULT_THEME;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static File getCacheDir()
/*     */   {
/* 776 */     Validate.sdkInitialized();
/* 777 */     return (File)cacheDir.getValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setCacheDir(File cacheDir)
/*     */   {
/* 785 */     cacheDir = new LockOnGetVariable(cacheDir);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getCallbackRequestCodeOffset()
/*     */   {
/* 795 */     Validate.sdkInitialized();
/* 796 */     return callbackRequestCodeOffset;
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
/*     */   public static boolean isFacebookRequestCode(int requestCode)
/*     */   {
/* 809 */     return (requestCode >= callbackRequestCodeOffset) && (requestCode < callbackRequestCodeOffset + 100);
/*     */   }
/*     */   
/*     */   public static abstract interface InitializeCallback
/*     */   {
/*     */     public abstract void onInitialized();
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/FacebookSdk.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */