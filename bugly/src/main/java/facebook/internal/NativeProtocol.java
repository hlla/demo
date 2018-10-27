/*     */ package com.facebook.internal;
/*     */ 
/*     */ import android.content.ContentResolver;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.content.pm.ActivityInfo;
/*     */ import android.content.pm.ApplicationInfo;
/*     */ import android.content.pm.PackageInfo;
/*     */ import android.content.pm.PackageManager;
/*     */ import android.content.pm.PackageManager.NameNotFoundException;
/*     */ import android.content.pm.ProviderInfo;
/*     */ import android.content.pm.ResolveInfo;
/*     */ import android.content.pm.ServiceInfo;
/*     */ import android.content.pm.Signature;
/*     */ import android.database.Cursor;
/*     */ import android.net.Uri;
/*     */ import android.os.Build;
/*     */ import android.os.Bundle;
/*     */ import android.text.TextUtils;
/*     */ import android.util.Log;
/*     */ import com.facebook.FacebookException;
/*     */ import com.facebook.FacebookOperationCanceledException;
/*     */ import com.facebook.FacebookSdk;
/*     */ import com.facebook.login.DefaultAudience;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.TreeSet;
/*     */ import java.util.UUID;
/*     */ import java.util.concurrent.Executor;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
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
/*     */ public final class NativeProtocol
/*     */ {
/*     */   public static final int NO_PROTOCOL_AVAILABLE = -1;
/*  65 */   private static final String TAG = NativeProtocol.class.getName();
/*     */   
/*     */   private static final String FACEBOOK_PROXY_AUTH_ACTIVITY = "com.facebook.katana.ProxyAuth";
/*     */   
/*     */   private static final String FACEBOOK_TOKEN_REFRESH_ACTIVITY = "com.facebook.katana.platform.TokenRefreshService";
/*     */   
/*     */   public static final String FACEBOOK_PROXY_AUTH_PERMISSIONS_KEY = "scope";
/*     */   
/*     */   public static final String FACEBOOK_PROXY_AUTH_APP_ID_KEY = "client_id";
/*     */   
/*     */   public static final String FACEBOOK_PROXY_AUTH_E2E_KEY = "e2e";
/*     */   
/*     */   static final String INTENT_ACTION_PLATFORM_ACTIVITY = "com.facebook.platform.PLATFORM_ACTIVITY";
/*     */   
/*     */   static final String INTENT_ACTION_PLATFORM_SERVICE = "com.facebook.platform.PLATFORM_SERVICE";
/*     */   
/*     */   public static final int PROTOCOL_VERSION_20121101 = 20121101;
/*     */   
/*     */   public static final int PROTOCOL_VERSION_20130502 = 20130502;
/*     */   
/*     */   public static final int PROTOCOL_VERSION_20130618 = 20130618;
/*     */   
/*     */   public static final int PROTOCOL_VERSION_20131107 = 20131107;
/*     */   
/*     */   public static final int PROTOCOL_VERSION_20140204 = 20140204;
/*     */   
/*     */   public static final int PROTOCOL_VERSION_20140324 = 20140324;
/*     */   
/*     */   public static final int PROTOCOL_VERSION_20140701 = 20140701;
/*     */   
/*     */   public static final int PROTOCOL_VERSION_20141001 = 20141001;
/*     */   
/*     */   public static final int PROTOCOL_VERSION_20141028 = 20141028;
/*     */   
/*     */   public static final int PROTOCOL_VERSION_20141107 = 20141107;
/*     */   
/*     */   public static final int PROTOCOL_VERSION_20141218 = 20141218;
/*     */   
/*     */   public static final int PROTOCOL_VERSION_20160327 = 20160327;
/*     */   
/*     */   public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.platform.protocol.PROTOCOL_VERSION";
/*     */   
/*     */   public static final String EXTRA_PROTOCOL_ACTION = "com.facebook.platform.protocol.PROTOCOL_ACTION";
/*     */   
/*     */   public static final String EXTRA_PROTOCOL_CALL_ID = "com.facebook.platform.protocol.CALL_ID";
/*     */   
/*     */   public static final String EXTRA_GET_INSTALL_DATA_PACKAGE = "com.facebook.platform.extra.INSTALLDATA_PACKAGE";
/*     */   
/*     */   public static final String EXTRA_PROTOCOL_BRIDGE_ARGS = "com.facebook.platform.protocol.BRIDGE_ARGS";
/*     */   
/*     */   public static final String EXTRA_PROTOCOL_METHOD_ARGS = "com.facebook.platform.protocol.METHOD_ARGS";
/*     */   
/*     */   public static final String EXTRA_PROTOCOL_METHOD_RESULTS = "com.facebook.platform.protocol.RESULT_ARGS";
/*     */   
/*     */   public static final String BRIDGE_ARG_APP_NAME_STRING = "app_name";
/*     */   
/*     */   public static final String BRIDGE_ARG_ACTION_ID_STRING = "action_id";
/*     */   
/*     */   public static final String BRIDGE_ARG_ERROR_BUNDLE = "error";
/*     */   
/*     */   public static final String EXTRA_DIALOG_COMPLETE_KEY = "com.facebook.platform.extra.DID_COMPLETE";
/*     */   
/*     */   public static final String EXTRA_DIALOG_COMPLETION_GESTURE_KEY = "com.facebook.platform.extra.COMPLETION_GESTURE";
/*     */   
/*     */   public static final String RESULT_ARGS_DIALOG_COMPLETE_KEY = "didComplete";
/*     */   
/*     */   public static final String RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY = "completionGesture";
/*     */   
/*     */   public static final int MESSAGE_GET_ACCESS_TOKEN_REQUEST = 65536;
/*     */   
/*     */   public static final int MESSAGE_GET_ACCESS_TOKEN_REPLY = 65537;
/*     */   
/*     */   static final int MESSAGE_GET_PROTOCOL_VERSIONS_REQUEST = 65538;
/*     */   
/*     */   static final int MESSAGE_GET_PROTOCOL_VERSIONS_REPLY = 65539;
/*     */   
/*     */   public static final int MESSAGE_GET_INSTALL_DATA_REQUEST = 65540;
/*     */   
/*     */   public static final int MESSAGE_GET_INSTALL_DATA_REPLY = 65541;
/*     */   
/*     */   public static final int MESSAGE_GET_LIKE_STATUS_REQUEST = 65542;
/*     */   
/*     */   public static final int MESSAGE_GET_LIKE_STATUS_REPLY = 65543;
/*     */   
/*     */   static final String EXTRA_PROTOCOL_VERSIONS = "com.facebook.platform.extra.PROTOCOL_VERSIONS";
/*     */   
/*     */   public static final String ACTION_FEED_DIALOG = "com.facebook.platform.action.request.FEED_DIALOG";
/*     */   
/*     */   public static final String ACTION_MESSAGE_DIALOG = "com.facebook.platform.action.request.MESSAGE_DIALOG";
/*     */   
/*     */   public static final String ACTION_OGACTIONPUBLISH_DIALOG = "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
/*     */   
/*     */   public static final String ACTION_OGMESSAGEPUBLISH_DIALOG = "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";
/*     */   
/*     */   public static final String ACTION_LIKE_DIALOG = "com.facebook.platform.action.request.LIKE_DIALOG";
/*     */   
/*     */   public static final String ACTION_APPINVITE_DIALOG = "com.facebook.platform.action.request.APPINVITES_DIALOG";
/*     */   
/*     */   public static final String EXTRA_PERMISSIONS = "com.facebook.platform.extra.PERMISSIONS";
/*     */   
/*     */   public static final String EXTRA_APPLICATION_ID = "com.facebook.platform.extra.APPLICATION_ID";
/*     */   
/*     */   public static final String EXTRA_APPLICATION_NAME = "com.facebook.platform.extra.APPLICATION_NAME";
/*     */   
/*     */   public static final String EXTRA_USER_ID = "com.facebook.platform.extra.USER_ID";
/*     */   
/*     */   public static final String EXTRA_ACCESS_TOKEN = "com.facebook.platform.extra.ACCESS_TOKEN";
/*     */   
/*     */   public static final String EXTRA_EXPIRES_SECONDS_SINCE_EPOCH = "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH";
/*     */   
/*     */   public static final String RESULT_ARGS_ACCESS_TOKEN = "access_token";
/*     */   
/*     */   public static final String RESULT_ARGS_EXPIRES_SECONDS_SINCE_EPOCH = "expires_seconds_since_epoch";
/*     */   
/*     */   public static final String RESULT_ARGS_PERMISSIONS = "permissions";
/*     */   
/*     */   public static final String OPEN_GRAPH_CREATE_OBJECT_KEY = "fbsdk:create_object";
/*     */   
/*     */   public static final String IMAGE_USER_GENERATED_KEY = "user_generated";
/*     */   
/*     */   public static final String IMAGE_URL_KEY = "url";
/*     */   
/*     */   public static final String STATUS_ERROR_TYPE = "com.facebook.platform.status.ERROR_TYPE";
/*     */   
/*     */   public static final String STATUS_ERROR_DESCRIPTION = "com.facebook.platform.status.ERROR_DESCRIPTION";
/*     */   
/*     */   public static final String STATUS_ERROR_CODE = "com.facebook.platform.status.ERROR_CODE";
/*     */   
/*     */   public static final String STATUS_ERROR_SUBCODE = "com.facebook.platform.status.ERROR_SUBCODE";
/*     */   
/*     */   public static final String STATUS_ERROR_JSON = "com.facebook.platform.status.ERROR_JSON";
/*     */   
/*     */   public static final String BRIDGE_ARG_ERROR_TYPE = "error_type";
/*     */   
/*     */   public static final String BRIDGE_ARG_ERROR_DESCRIPTION = "error_description";
/*     */   
/*     */   public static final String BRIDGE_ARG_ERROR_CODE = "error_code";
/*     */   
/*     */   public static final String BRIDGE_ARG_ERROR_SUBCODE = "error_subcode";
/*     */   
/*     */   public static final String BRIDGE_ARG_ERROR_JSON = "error_json";
/*     */   
/*     */   public static final String ERROR_UNKNOWN_ERROR = "UnknownError";
/*     */   
/*     */   public static final String ERROR_PROTOCOL_ERROR = "ProtocolError";
/*     */   
/*     */   public static final String ERROR_USER_CANCELED = "UserCanceled";
/*     */   
/*     */   public static final String ERROR_APPLICATION_ERROR = "ApplicationError";
/*     */   
/*     */   public static final String ERROR_NETWORK_ERROR = "NetworkError";
/*     */   
/*     */   public static final String ERROR_PERMISSION_DENIED = "PermissionDenied";
/*     */   
/*     */   public static final String ERROR_SERVICE_DISABLED = "ServiceDisabled";
/*     */   
/*     */   public static final String WEB_DIALOG_URL = "url";
/*     */   
/*     */   public static final String WEB_DIALOG_ACTION = "action";
/*     */   
/*     */   public static final String WEB_DIALOG_PARAMS = "params";
/*     */   
/*     */   public static final String WEB_DIALOG_IS_FALLBACK = "is_fallback";
/*     */   
/*     */   public static final String AUDIENCE_ME = "only_me";
/*     */   
/*     */   public static final String AUDIENCE_FRIENDS = "friends";
/*     */   
/*     */   public static final String AUDIENCE_EVERYONE = "everyone";
/*     */   
/*     */   private static final String CONTENT_SCHEME = "content://";
/*     */   
/*     */   private static final String PLATFORM_PROVIDER = ".provider.PlatformProvider";
/*     */   private static final String PLATFORM_PROVIDER_VERSIONS = ".provider.PlatformProvider/versions";
/*     */   private static final String PLATFORM_PROVIDER_VERSION_COLUMN = "version";
/*     */   
/*     */   private static abstract class NativeAppInfo
/*     */   {
/*     */     private static final String FBI_HASH = "a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc";
/*     */     private static final String FBL_HASH = "5e8f16062ea3cd2c4a0d547876baa6f38cabf625";
/*     */     private static final String FBR_HASH = "8a3c4b262d721acd49a4bf97d5213199c86fa2b9";
/*     */     
/*     */     protected abstract String getPackage();
/*     */     
/* 249 */     private static final HashSet<String> validAppSignatureHashes = ;
/*     */     
/*     */     protected abstract String getLoginActivity();
/*     */     
/*     */     private static HashSet<String> buildAppSignatureHashes() {
/* 254 */       HashSet<String> set = new HashSet();
/* 255 */       set.add("8a3c4b262d721acd49a4bf97d5213199c86fa2b9");
/* 256 */       set.add("a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc");
/* 257 */       set.add("5e8f16062ea3cd2c4a0d547876baa6f38cabf625");
/* 258 */       return set;
/*     */     }
/*     */     
/*     */     private TreeSet<Integer> availableVersions;
/* 262 */     public boolean validateSignature(Context context, String packageName) { String brand = Build.BRAND;
/* 263 */       int applicationFlags = context.getApplicationInfo().flags;
/* 264 */       if ((brand.startsWith("generic")) && ((applicationFlags & 0x2) != 0))
/*     */       {
/*     */ 
/* 267 */         return true;
/*     */       }
/*     */       
/*     */       try
/*     */       {
/* 272 */         packageInfo = context.getPackageManager().getPackageInfo(packageName, 64);
/*     */       } catch (NameNotFoundException e) {
/*     */         PackageInfo packageInfo;
/* 275 */         return false;
/*     */       }
/*     */       
/*     */       PackageInfo packageInfo;
/* 279 */       if ((packageInfo.signatures == null) || (packageInfo.signatures.length <= 0)) {
/* 280 */         return false;
/*     */       }
/*     */       
/* 283 */       for (Signature signature : packageInfo.signatures) {
/* 284 */         String hashedSignature = Utility.sha1hash(signature.toByteArray());
/* 285 */         if (!validAppSignatureHashes.contains(hashedSignature)) {
/* 286 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 290 */       return true;
/*     */     }
/*     */     
/*     */     public TreeSet<Integer> getAvailableVersions() {
/* 294 */       if (this.availableVersions == null) {
/* 295 */         fetchAvailableVersions(false);
/*     */       }
/* 297 */       return this.availableVersions;
/*     */     }
/*     */     
/*     */     private synchronized void fetchAvailableVersions(boolean force) {
/* 301 */       if ((force) || (this.availableVersions == null))
/* 302 */         this.availableVersions = NativeProtocol.fetchAllAvailableProtocolVersionsForAppInfo(this);
/*     */     } }
/*     */   
/*     */   private static class KatanaAppInfo extends NativeAppInfo { static final String KATANA_PACKAGE = "com.facebook.katana";
/*     */     
/* 307 */     private KatanaAppInfo() { super(); }
/*     */     
/*     */ 
/*     */     protected String getPackage()
/*     */     {
/* 312 */       return "com.facebook.katana";
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 317 */     protected String getLoginActivity() { return "com.facebook.katana.ProxyAuth"; } }
/*     */   
/*     */   private static class MessengerAppInfo extends NativeAppInfo { static final String MESSENGER_PACKAGE = "com.facebook.orca";
/*     */     
/* 321 */     private MessengerAppInfo() { super(); }
/*     */     
/*     */ 
/*     */     protected String getPackage()
/*     */     {
/* 326 */       return "com.facebook.orca";
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 331 */     protected String getLoginActivity() { return null; } }
/*     */   
/*     */   private static class WakizashiAppInfo extends NativeAppInfo { static final String WAKIZASHI_PACKAGE = "com.facebook.wakizashi";
/*     */     
/* 335 */     private WakizashiAppInfo() { super(); }
/*     */     
/*     */ 
/*     */     protected String getPackage()
/*     */     {
/* 340 */       return "com.facebook.wakizashi";
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 345 */     protected String getLoginActivity() { return "com.facebook.katana.ProxyAuth"; } }
/*     */   
/*     */   private static class FBLiteAppInfo extends NativeAppInfo { static final String FBLITE_PACKAGE = "com.facebook.lite";
/*     */     
/* 349 */     private FBLiteAppInfo() { super(); }
/*     */     
/*     */ 
/*     */     static final String FACEBOOK_LITE_ACTIVITY = "com.facebook.lite.platform.LoginGDPDialogActivity";
/*     */     
/*     */     protected String getPackage()
/*     */     {
/* 356 */       return "com.facebook.lite";
/*     */     }
/*     */     
/*     */     protected String getLoginActivity()
/*     */     {
/* 361 */       return "com.facebook.lite.platform.LoginGDPDialogActivity";
/*     */     }
/*     */   }
/*     */   
/* 365 */   private static List<NativeAppInfo> facebookAppInfoList = buildFacebookAppList();
/* 366 */   private static Map<String, List<NativeAppInfo>> actionToAppInfoMap = buildActionToAppInfoMap();
/* 367 */   private static AtomicBoolean protocolVersionsAsyncUpdating = new AtomicBoolean(false);
/*     */   
/*     */   private static List<NativeAppInfo> buildFacebookAppList() {
/* 370 */     List<NativeAppInfo> list = new ArrayList();
/*     */     
/*     */ 
/*     */ 
/* 374 */     list.add(new KatanaAppInfo(null));
/* 375 */     list.add(new WakizashiAppInfo(null));
/*     */     
/* 377 */     return list;
/*     */   }
/*     */   
/*     */   private static Map<String, List<NativeAppInfo>> buildActionToAppInfoMap() {
/* 381 */     Map<String, List<NativeAppInfo>> map = new HashMap();
/*     */     
/* 383 */     ArrayList<NativeAppInfo> messengerAppInfoList = new ArrayList();
/* 384 */     messengerAppInfoList.add(new MessengerAppInfo(null));
/*     */     
/*     */ 
/* 387 */     map.put("com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG", facebookAppInfoList);
/* 388 */     map.put("com.facebook.platform.action.request.FEED_DIALOG", facebookAppInfoList);
/* 389 */     map.put("com.facebook.platform.action.request.LIKE_DIALOG", facebookAppInfoList);
/* 390 */     map.put("com.facebook.platform.action.request.APPINVITES_DIALOG", facebookAppInfoList);
/* 391 */     map.put("com.facebook.platform.action.request.MESSAGE_DIALOG", messengerAppInfoList);
/* 392 */     map.put("com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG", messengerAppInfoList);
/*     */     
/* 394 */     return map;
/*     */   }
/*     */   
/*     */   static Intent validateActivityIntent(Context context, Intent intent, NativeAppInfo appInfo) {
/* 398 */     if (intent == null) {
/* 399 */       return null;
/*     */     }
/*     */     
/* 402 */     ResolveInfo resolveInfo = context.getPackageManager().resolveActivity(intent, 0);
/* 403 */     if (resolveInfo == null) {
/* 404 */       return null;
/*     */     }
/*     */     
/* 407 */     if (!appInfo.validateSignature(context, resolveInfo.activityInfo.packageName)) {
/* 408 */       return null;
/*     */     }
/*     */     
/* 411 */     return intent;
/*     */   }
/*     */   
/*     */   static Intent validateServiceIntent(Context context, Intent intent, NativeAppInfo appInfo) {
/* 415 */     if (intent == null) {
/* 416 */       return null;
/*     */     }
/*     */     
/* 419 */     ResolveInfo resolveInfo = context.getPackageManager().resolveService(intent, 0);
/* 420 */     if (resolveInfo == null) {
/* 421 */       return null;
/*     */     }
/*     */     
/* 424 */     if (!appInfo.validateSignature(context, resolveInfo.serviceInfo.packageName)) {
/* 425 */       return null;
/*     */     }
/*     */     
/* 428 */     return intent;
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
/*     */   public static Intent createFacebookLiteIntent(Context context, String applicationId, Collection<String> permissions, String e2e, boolean isRerequest, boolean isForPublish, DefaultAudience defaultAudience, String clientState)
/*     */   {
/* 441 */     NativeAppInfo appInfo = new FBLiteAppInfo(null);
/* 442 */     Intent intent = createNativeAppIntent(appInfo, applicationId, permissions, e2e, isRerequest, isForPublish, defaultAudience, clientState);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 451 */     intent = validateActivityIntent(context, intent, appInfo);
/*     */     
/* 453 */     return intent;
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
/*     */   private static Intent createNativeAppIntent(NativeAppInfo appInfo, String applicationId, Collection<String> permissions, String e2e, boolean isRerequest, boolean isForPublish, DefaultAudience defaultAudience, String clientState)
/*     */   {
/* 466 */     String activityName = appInfo.getLoginActivity();
/*     */     
/* 468 */     if (activityName == null) {
/* 469 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 474 */     Intent intent = new Intent().setClassName(appInfo.getPackage(), activityName).putExtra("client_id", applicationId);
/*     */     
/* 476 */     if (!Utility.isNullOrEmpty(permissions)) {
/* 477 */       intent.putExtra("scope", 
/* 478 */         TextUtils.join(",", permissions));
/*     */     }
/* 480 */     if (!Utility.isNullOrEmpty(e2e)) {
/* 481 */       intent.putExtra("e2e", e2e);
/*     */     }
/*     */     
/* 484 */     intent.putExtra("state", clientState);
/* 485 */     intent.putExtra("response_type", "token,signed_request");
/*     */     
/*     */ 
/* 488 */     intent.putExtra("return_scopes", "true");
/*     */     
/*     */ 
/* 491 */     if (isForPublish) {
/* 492 */       intent.putExtra("default_audience", defaultAudience
/*     */       
/* 494 */         .getNativeProtocolAudience());
/*     */     }
/*     */     
/*     */ 
/* 498 */     intent.putExtra("legacy_override", 
/*     */     
/* 500 */       FacebookSdk.getGraphApiVersion());
/*     */     
/* 502 */     intent.putExtra("auth_type", "rerequest");
/*     */     
/*     */ 
/* 505 */     return intent;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Intent createProxyAuthIntent(Context context, String applicationId, Collection<String> permissions, String e2e, boolean isRerequest, boolean isForPublish, DefaultAudience defaultAudience, String clientState)
/*     */   {
/* 517 */     for (NativeAppInfo appInfo : facebookAppInfoList) {
/* 518 */       Intent intent = createNativeAppIntent(appInfo, applicationId, permissions, e2e, isRerequest, isForPublish, defaultAudience, clientState);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 527 */       intent = validateActivityIntent(context, intent, appInfo);
/*     */       
/* 529 */       if (intent != null) {
/* 530 */         return intent;
/*     */       }
/*     */     }
/* 533 */     return null;
/*     */   }
/*     */   
/*     */   public static Intent createTokenRefreshIntent(Context context) {
/* 537 */     for (NativeAppInfo appInfo : facebookAppInfoList)
/*     */     {
/* 539 */       Intent intent = new Intent().setClassName(appInfo.getPackage(), "com.facebook.katana.platform.TokenRefreshService");
/*     */       
/* 541 */       intent = validateServiceIntent(context, intent, appInfo);
/*     */       
/* 543 */       if (intent != null) {
/* 544 */         return intent;
/*     */       }
/*     */     }
/* 547 */     return null;
/*     */   }
/*     */   
/*     */   public static final int getLatestKnownVersion() {
/* 551 */     return ((Integer)KNOWN_PROTOCOL_VERSIONS.get(0)).intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/* 556 */   private static final List<Integer> KNOWN_PROTOCOL_VERSIONS = Arrays.asList(new Integer[] {
/* 557 */     Integer.valueOf(20160327), 
/* 558 */     Integer.valueOf(20141218), 
/* 559 */     Integer.valueOf(20141107), 
/* 560 */     Integer.valueOf(20141028), 
/* 561 */     Integer.valueOf(20141001), 
/* 562 */     Integer.valueOf(20140701), 
/* 563 */     Integer.valueOf(20140324), 
/* 564 */     Integer.valueOf(20140204), 
/* 565 */     Integer.valueOf(20131107), 
/* 566 */     Integer.valueOf(20130618), 
/* 567 */     Integer.valueOf(20130502), 
/* 568 */     Integer.valueOf(20121101) });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static Intent findActivityIntent(Context context, String activityAction, String internalAction)
/*     */   {
/* 575 */     List<NativeAppInfo> list = (List)actionToAppInfoMap.get(internalAction);
/* 576 */     if (list == null) {
/* 577 */       return null;
/*     */     }
/*     */     
/* 580 */     Intent intent = null;
/* 581 */     for (NativeAppInfo appInfo : list)
/*     */     {
/*     */ 
/*     */ 
/* 585 */       intent = new Intent().setAction(activityAction).setPackage(appInfo.getPackage()).addCategory("android.intent.category.DEFAULT");
/* 586 */       intent = validateActivityIntent(context, intent, appInfo);
/* 587 */       if (intent != null) {
/* 588 */         return intent;
/*     */       }
/*     */     }
/*     */     
/* 592 */     return intent;
/*     */   }
/*     */   
/*     */   public static boolean isVersionCompatibleWithBucketedIntent(int version) {
/* 596 */     return (KNOWN_PROTOCOL_VERSIONS.contains(Integer.valueOf(version))) && (version >= 20140701);
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
/*     */   public static Intent createPlatformActivityIntent(Context context, String callId, String action, int version, Bundle extras)
/*     */   {
/* 609 */     Intent intent = findActivityIntent(context, "com.facebook.platform.PLATFORM_ACTIVITY", action);
/* 610 */     if (intent == null) {
/* 611 */       return null;
/*     */     }
/*     */     
/* 614 */     setupProtocolRequestIntent(intent, callId, action, version, extras);
/*     */     
/* 616 */     return intent;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setupProtocolRequestIntent(Intent intent, String callId, String action, int version, Bundle params)
/*     */   {
/* 628 */     String applicationId = FacebookSdk.getApplicationId();
/* 629 */     String applicationName = FacebookSdk.getApplicationName();
/*     */     
/* 631 */     intent.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", version)
/* 632 */       .putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", action)
/* 633 */       .putExtra("com.facebook.platform.extra.APPLICATION_ID", applicationId);
/*     */     
/* 635 */     if (isVersionCompatibleWithBucketedIntent(version))
/*     */     {
/* 637 */       Bundle bridgeArguments = new Bundle();
/* 638 */       bridgeArguments.putString("action_id", callId);
/* 639 */       Utility.putNonEmptyString(bridgeArguments, "app_name", applicationName);
/*     */       
/* 641 */       intent.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", bridgeArguments);
/*     */       
/* 643 */       Bundle methodArguments = params == null ? new Bundle() : params;
/* 644 */       intent.putExtra("com.facebook.platform.protocol.METHOD_ARGS", methodArguments);
/*     */     }
/*     */     else {
/* 647 */       intent.putExtra("com.facebook.platform.protocol.CALL_ID", callId);
/* 648 */       if (!Utility.isNullOrEmpty(applicationName)) {
/* 649 */         intent.putExtra("com.facebook.platform.extra.APPLICATION_NAME", applicationName);
/*     */       }
/* 651 */       intent.putExtras(params);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Intent createProtocolResultIntent(Intent requestIntent, Bundle results, FacebookException error)
/*     */   {
/* 663 */     UUID callId = getCallIdFromIntent(requestIntent);
/* 664 */     if (callId == null) {
/* 665 */       return null;
/*     */     }
/*     */     
/* 668 */     Intent resultIntent = new Intent();
/* 669 */     resultIntent.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", getProtocolVersionFromIntent(requestIntent));
/*     */     
/* 671 */     Bundle bridgeArguments = new Bundle();
/* 672 */     bridgeArguments.putString("action_id", callId.toString());
/* 673 */     if (error != null) {
/* 674 */       bridgeArguments.putBundle("error", 
/* 675 */         createBundleForException(error));
/*     */     }
/* 677 */     resultIntent.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", bridgeArguments);
/*     */     
/* 679 */     if (results != null) {
/* 680 */       resultIntent.putExtra("com.facebook.platform.protocol.RESULT_ARGS", results);
/*     */     }
/*     */     
/* 683 */     return resultIntent;
/*     */   }
/*     */   
/*     */   public static Intent createPlatformServiceIntent(Context context) {
/* 687 */     for (NativeAppInfo appInfo : facebookAppInfoList)
/*     */     {
/*     */ 
/* 690 */       Intent intent = new Intent("com.facebook.platform.PLATFORM_SERVICE").setPackage(appInfo.getPackage()).addCategory("android.intent.category.DEFAULT");
/* 691 */       intent = validateServiceIntent(context, intent, appInfo);
/* 692 */       if (intent != null) {
/* 693 */         return intent;
/*     */       }
/*     */     }
/* 696 */     return null;
/*     */   }
/*     */   
/*     */   public static int getProtocolVersionFromIntent(Intent intent) {
/* 700 */     return intent.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0);
/*     */   }
/*     */   
/*     */   public static UUID getCallIdFromIntent(Intent intent) {
/* 704 */     if (intent == null) {
/* 705 */       return null;
/*     */     }
/* 707 */     int version = getProtocolVersionFromIntent(intent);
/* 708 */     String callIdString = null;
/* 709 */     if (isVersionCompatibleWithBucketedIntent(version)) {
/* 710 */       Bundle bridgeArgs = intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
/* 711 */       if (bridgeArgs != null) {
/* 712 */         callIdString = bridgeArgs.getString("action_id");
/*     */       }
/*     */     } else {
/* 715 */       callIdString = intent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
/*     */     }
/*     */     
/* 718 */     UUID callId = null;
/* 719 */     if (callIdString != null) {
/*     */       try {
/* 721 */         callId = UUID.fromString(callIdString);
/*     */       }
/*     */       catch (IllegalArgumentException localIllegalArgumentException) {}
/*     */     }
/* 725 */     return callId;
/*     */   }
/*     */   
/*     */   public static Bundle getBridgeArgumentsFromIntent(Intent intent) {
/* 729 */     int version = getProtocolVersionFromIntent(intent);
/* 730 */     if (!isVersionCompatibleWithBucketedIntent(version)) {
/* 731 */       return null;
/*     */     }
/*     */     
/* 734 */     return intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
/*     */   }
/*     */   
/*     */   public static Bundle getMethodArgumentsFromIntent(Intent intent) {
/* 738 */     int version = getProtocolVersionFromIntent(intent);
/* 739 */     if (!isVersionCompatibleWithBucketedIntent(version)) {
/* 740 */       return intent.getExtras();
/*     */     }
/*     */     
/* 743 */     return intent.getBundleExtra("com.facebook.platform.protocol.METHOD_ARGS");
/*     */   }
/*     */   
/*     */   public static Bundle getSuccessResultsFromIntent(Intent resultIntent) {
/* 747 */     int version = getProtocolVersionFromIntent(resultIntent);
/* 748 */     Bundle extras = resultIntent.getExtras();
/* 749 */     if ((!isVersionCompatibleWithBucketedIntent(version)) || (extras == null)) {
/* 750 */       return extras;
/*     */     }
/*     */     
/* 753 */     return extras.getBundle("com.facebook.platform.protocol.RESULT_ARGS");
/*     */   }
/*     */   
/*     */   public static boolean isErrorResult(Intent resultIntent) {
/* 757 */     Bundle bridgeArgs = getBridgeArgumentsFromIntent(resultIntent);
/* 758 */     if (bridgeArgs != null) {
/* 759 */       return bridgeArgs.containsKey("error");
/*     */     }
/* 761 */     return resultIntent.hasExtra("com.facebook.platform.status.ERROR_TYPE");
/*     */   }
/*     */   
/*     */   public static Bundle getErrorDataFromResultIntent(Intent resultIntent)
/*     */   {
/* 766 */     if (!isErrorResult(resultIntent)) {
/* 767 */       return null;
/*     */     }
/*     */     
/* 770 */     Bundle bridgeArgs = getBridgeArgumentsFromIntent(resultIntent);
/* 771 */     if (bridgeArgs != null) {
/* 772 */       return bridgeArgs.getBundle("error");
/*     */     }
/*     */     
/* 775 */     return resultIntent.getExtras();
/*     */   }
/*     */   
/*     */   public static FacebookException getExceptionFromErrorData(Bundle errorData) {
/* 779 */     if (errorData == null) {
/* 780 */       return null;
/*     */     }
/*     */     
/* 783 */     String type = errorData.getString("error_type");
/* 784 */     if (type == null) {
/* 785 */       type = errorData.getString("com.facebook.platform.status.ERROR_TYPE");
/*     */     }
/*     */     
/* 788 */     String description = errorData.getString("error_description");
/* 789 */     if (description == null) {
/* 790 */       description = errorData.getString("com.facebook.platform.status.ERROR_DESCRIPTION");
/*     */     }
/*     */     
/* 793 */     if ((type != null) && (type.equalsIgnoreCase("UserCanceled"))) {
/* 794 */       return new FacebookOperationCanceledException(description);
/*     */     }
/*     */     
/*     */ 
/* 798 */     return new FacebookException(description);
/*     */   }
/*     */   
/*     */   public static Bundle createBundleForException(FacebookException e) {
/* 802 */     if (e == null) {
/* 803 */       return null;
/*     */     }
/*     */     
/* 806 */     Bundle errorBundle = new Bundle();
/* 807 */     errorBundle.putString("error_description", e.toString());
/* 808 */     if ((e instanceof FacebookOperationCanceledException)) {
/* 809 */       errorBundle.putString("error_type", "UserCanceled");
/*     */     }
/*     */     
/* 812 */     return errorBundle;
/*     */   }
/*     */   
/*     */   public static int getLatestAvailableProtocolVersionForService(int minimumVersion)
/*     */   {
/* 817 */     return getLatestAvailableProtocolVersionForAppInfoList(facebookAppInfoList, new int[] { minimumVersion });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static int getLatestAvailableProtocolVersionForAction(String action, int[] versionSpec)
/*     */   {
/* 824 */     List<NativeAppInfo> appInfoList = (List)actionToAppInfoMap.get(action);
/* 825 */     return getLatestAvailableProtocolVersionForAppInfoList(appInfoList, versionSpec);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static int getLatestAvailableProtocolVersionForAppInfoList(List<NativeAppInfo> appInfoList, int[] versionSpec)
/*     */   {
/*     */     
/*     */     
/* 834 */     if (appInfoList == null) {
/* 835 */       return -1;
/*     */     }
/*     */     
/*     */ 
/* 839 */     for (NativeAppInfo appInfo : appInfoList)
/*     */     {
/* 841 */       int protocolVersion = computeLatestAvailableVersionFromVersionSpec(appInfo
/* 842 */         .getAvailableVersions(), 
/* 843 */         getLatestKnownVersion(), versionSpec);
/*     */       
/*     */ 
/* 846 */       if (protocolVersion != -1) {
/* 847 */         return protocolVersion;
/*     */       }
/*     */     }
/*     */     
/* 851 */     return -1;
/*     */   }
/*     */   
/*     */   public static void updateAllAvailableProtocolVersionsAsync() {
/* 855 */     if (!protocolVersionsAsyncUpdating.compareAndSet(false, true)) {
/* 856 */       return;
/*     */     }
/*     */     
/* 859 */     FacebookSdk.getExecutor().execute(new Runnable()
/*     */     {
/*     */       /* Error */
/*     */       public void run()
/*     */       {
/*     */         // Byte code:
/*     */         //   0: invokestatic 2	com/facebook/internal/NativeProtocol:access$600	()Ljava/util/List;
/*     */         //   3: invokeinterface 3 1 0
/*     */         //   8: astore_1
/*     */         //   9: aload_1
/*     */         //   10: invokeinterface 4 1 0
/*     */         //   15: ifeq +21 -> 36
/*     */         //   18: aload_1
/*     */         //   19: invokeinterface 5 1 0
/*     */         //   24: checkcast 6	com/facebook/internal/NativeProtocol$NativeAppInfo
/*     */         //   27: astore_2
/*     */         //   28: aload_2
/*     */         //   29: iconst_1
/*     */         //   30: invokestatic 7	com/facebook/internal/NativeProtocol$NativeAppInfo:access$700	(Lcom/facebook/internal/NativeProtocol$NativeAppInfo;Z)V
/*     */         //   33: goto -24 -> 9
/*     */         //   36: invokestatic 8	com/facebook/internal/NativeProtocol:access$800	()Ljava/util/concurrent/atomic/AtomicBoolean;
/*     */         //   39: iconst_0
/*     */         //   40: invokevirtual 9	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
/*     */         //   43: goto +13 -> 56
/*     */         //   46: astore_3
/*     */         //   47: invokestatic 8	com/facebook/internal/NativeProtocol:access$800	()Ljava/util/concurrent/atomic/AtomicBoolean;
/*     */         //   50: iconst_0
/*     */         //   51: invokevirtual 9	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
/*     */         //   54: aload_3
/*     */         //   55: athrow
/*     */         //   56: return
/*     */         // Line number table:
/*     */         //   Java source line #863	-> byte code offset #0
/*     */         //   Java source line #864	-> byte code offset #28
/*     */         //   Java source line #865	-> byte code offset #33
/*     */         //   Java source line #867	-> byte code offset #36
/*     */         //   Java source line #868	-> byte code offset #43
/*     */         //   Java source line #867	-> byte code offset #46
/*     */         //   Java source line #869	-> byte code offset #56
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	signature
/*     */         //   0	57	0	this	1
/*     */         //   8	11	1	localIterator	Iterator
/*     */         //   27	2	2	appInfo	NativeProtocol.NativeAppInfo
/*     */         //   46	9	3	localObject	Object
/*     */         // Exception table:
/*     */         //   from	to	target	type
/*     */         //   0	36	46	finally
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   private static TreeSet<Integer> fetchAllAvailableProtocolVersionsForAppInfo(NativeAppInfo appInfo)
/*     */   {
/* 875 */     TreeSet<Integer> allAvailableVersions = new TreeSet();
/*     */     
/* 877 */     Context appContext = FacebookSdk.getApplicationContext();
/* 878 */     ContentResolver contentResolver = appContext.getContentResolver();
/*     */     
/* 880 */     String[] projection = { "version" };
/* 881 */     Uri uri = buildPlatformProviderVersionURI(appInfo);
/* 882 */     Cursor c = null;
/*     */     
/*     */ 
/*     */     try
/*     */     {
/* 887 */       PackageManager pm = FacebookSdk.getApplicationContext().getPackageManager();
/* 888 */       String contentProviderName = appInfo.getPackage() + ".provider.PlatformProvider";
/* 889 */       ProviderInfo pInfo = null;
/*     */       try {
/* 891 */         pInfo = pm.resolveContentProvider(contentProviderName, 0);
/*     */ 
/*     */       }
/*     */       catch (RuntimeException e)
/*     */       {
/*     */ 
/* 897 */         Log.e(TAG, "Failed to query content resolver.", e);
/*     */       }
/* 899 */       if (pInfo != null) {
/*     */         try {
/* 901 */           c = contentResolver.query(uri, projection, null, null, null);
/*     */         } catch (NullPointerException|SecurityException ex) {
/* 903 */           Log.e(TAG, "Failed to query content resolver.");
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 909 */           c = null;
/*     */         }
/*     */         
/* 912 */         if (c != null) {
/* 913 */           while (c.moveToNext()) {
/* 914 */             int version = c.getInt(c.getColumnIndex("version"));
/* 915 */             allAvailableVersions.add(Integer.valueOf(version));
/*     */           }
/*     */         }
/*     */       }
/*     */     } finally {
/* 920 */       if (c != null) {
/* 921 */         c.close();
/*     */       }
/*     */     }
/*     */     
/* 925 */     return allAvailableVersions;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int computeLatestAvailableVersionFromVersionSpec(TreeSet<Integer> allAvailableFacebookAppVersions, int latestSdkVersion, int[] versionSpec)
/*     */   {
/* 935 */     int versionSpecIndex = versionSpec.length - 1;
/*     */     
/* 937 */     Iterator<Integer> fbAppVersionsIterator = allAvailableFacebookAppVersions.descendingIterator();
/* 938 */     int latestFacebookAppVersion = -1;
/*     */     
/* 940 */     while (fbAppVersionsIterator.hasNext()) {
/* 941 */       int fbAppVersion = ((Integer)fbAppVersionsIterator.next()).intValue();
/*     */       
/*     */ 
/* 944 */       latestFacebookAppVersion = Math.max(latestFacebookAppVersion, fbAppVersion);
/*     */       
/*     */ 
/* 947 */       while ((versionSpecIndex >= 0) && (versionSpec[versionSpecIndex] > fbAppVersion)) {
/* 948 */         versionSpecIndex--;
/*     */       }
/*     */       
/* 951 */       if (versionSpecIndex < 0)
/*     */       {
/*     */ 
/* 954 */         return -1;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 960 */       if (versionSpec[versionSpecIndex] == fbAppVersion)
/*     */       {
/*     */ 
/*     */ 
/* 964 */         return versionSpecIndex % 2 == 0 ? Math.min(latestFacebookAppVersion, latestSdkVersion) : -1;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 970 */     return -1;
/*     */   }
/*     */   
/*     */   private static Uri buildPlatformProviderVersionURI(NativeAppInfo appInfo) {
/* 974 */     return Uri.parse("content://" + appInfo.getPackage() + ".provider.PlatformProvider/versions");
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/NativeProtocol.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */