/*     */ package com.facebook.messenger;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.content.ActivityNotFoundException;
/*     */ import android.content.ContentResolver;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.content.pm.PackageManager;
/*     */ import android.content.pm.PackageManager.NameNotFoundException;
/*     */ import android.database.Cursor;
/*     */ import android.net.Uri;
/*     */ import android.os.Bundle;
/*     */ import bolts.AppLinks;
/*     */ import com.facebook.FacebookSdk;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
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
/*     */ public class MessengerUtils
/*     */ {
/*     */   private static final String TAG = "MessengerUtils";
/*     */   public static final String PACKAGE_NAME = "com.facebook.orca";
/*     */   public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.orca.extra.PROTOCOL_VERSION";
/*     */   public static final String EXTRA_APP_ID = "com.facebook.orca.extra.APPLICATION_ID";
/*     */   public static final String EXTRA_REPLY_TOKEN_KEY = "com.facebook.orca.extra.REPLY_TOKEN";
/*     */   public static final String EXTRA_THREAD_TOKEN_KEY = "com.facebook.orca.extra.THREAD_TOKEN";
/*     */   public static final String EXTRA_METADATA = "com.facebook.orca.extra.METADATA";
/*     */   public static final String EXTRA_EXTERNAL_URI = "com.facebook.orca.extra.EXTERNAL_URI";
/*     */   public static final String EXTRA_PARTICIPANTS = "com.facebook.orca.extra.PARTICIPANTS";
/*     */   public static final String EXTRA_IS_REPLY = "com.facebook.orca.extra.IS_REPLY";
/*     */   public static final String EXTRA_IS_COMPOSE = "com.facebook.orca.extra.IS_COMPOSE";
/*     */   public static final int PROTOCOL_VERSION_20150314 = 20150314;
/*     */   public static final String ORCA_THREAD_CATEGORY_20150314 = "com.facebook.orca.category.PLATFORM_THREAD_20150314";
/*     */   
/*     */   public static void shareToMessenger(Activity activity, int requestCode, ShareToMessengerParams shareToMessengerParams)
/*     */   {
/* 114 */     if (!hasMessengerInstalled(activity)) {
/* 115 */       openMessengerInPlayStore(activity);
/* 116 */       return;
/*     */     }
/*     */     
/* 119 */     Set<Integer> allAvailableVersions = getAllAvailableProtocolVersions(activity);
/* 120 */     if (allAvailableVersions.contains(Integer.valueOf(20150314))) {
/* 121 */       shareToMessenger20150314(activity, requestCode, shareToMessengerParams);
/*     */     }
/*     */     else {
/* 124 */       openMessengerInPlayStore(activity);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static void shareToMessenger20150314(Activity activity, int requestCode, ShareToMessengerParams shareToMessengerParams)
/*     */   {
/*     */     try
/*     */     {
/* 133 */       Intent shareIntent = new Intent("android.intent.action.SEND");
/* 134 */       shareIntent.setFlags(1);
/* 135 */       shareIntent.setPackage("com.facebook.orca");
/* 136 */       shareIntent.putExtra("android.intent.extra.STREAM", shareToMessengerParams.uri);
/* 137 */       shareIntent.setType(shareToMessengerParams.mimeType);
/* 138 */       String appId = FacebookSdk.getApplicationId();
/* 139 */       if (appId != null) {
/* 140 */         shareIntent.putExtra("com.facebook.orca.extra.PROTOCOL_VERSION", 20150314);
/* 141 */         shareIntent.putExtra("com.facebook.orca.extra.APPLICATION_ID", appId);
/* 142 */         shareIntent.putExtra("com.facebook.orca.extra.METADATA", shareToMessengerParams.metaData);
/* 143 */         shareIntent.putExtra("com.facebook.orca.extra.EXTERNAL_URI", shareToMessengerParams.externalUri);
/*     */       }
/*     */       
/* 146 */       activity.startActivityForResult(shareIntent, requestCode);
/*     */     } catch (ActivityNotFoundException e) {
/* 148 */       Intent openMessenger = activity.getPackageManager().getLaunchIntentForPackage("com.facebook.orca");
/* 149 */       activity.startActivity(openMessenger);
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
/*     */   public static MessengerThreadParams getMessengerThreadParamsForIntent(Intent intent)
/*     */   {
/* 162 */     Set<String> categories = intent.getCategories();
/* 163 */     if (categories == null) {
/* 164 */       return null;
/*     */     }
/* 166 */     if (categories.contains("com.facebook.orca.category.PLATFORM_THREAD_20150314")) {
/* 167 */       Bundle appLinkExtras = AppLinks.getAppLinkExtras(intent);
/* 168 */       String threadToken = appLinkExtras.getString("com.facebook.orca.extra.THREAD_TOKEN");
/* 169 */       String metadata = appLinkExtras.getString("com.facebook.orca.extra.METADATA");
/* 170 */       String participants = appLinkExtras.getString("com.facebook.orca.extra.PARTICIPANTS");
/* 171 */       boolean isReply = appLinkExtras.getBoolean("com.facebook.orca.extra.IS_REPLY");
/* 172 */       boolean isCompose = appLinkExtras.getBoolean("com.facebook.orca.extra.IS_COMPOSE");
/* 173 */       MessengerThreadParams.Origin origin = MessengerThreadParams.Origin.UNKNOWN;
/* 174 */       if (isReply) {
/* 175 */         origin = MessengerThreadParams.Origin.REPLY_FLOW;
/* 176 */       } else if (isCompose) {
/* 177 */         origin = MessengerThreadParams.Origin.COMPOSE_FLOW;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 184 */       return new MessengerThreadParams(origin, threadToken, metadata, parseParticipants(participants));
/*     */     }
/* 186 */     return null;
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
/*     */   public static void finishShareToMessenger(Activity activity, ShareToMessengerParams shareToMessengerParams)
/*     */   {
/* 199 */     Intent originalIntent = activity.getIntent();
/* 200 */     Set<String> categories = originalIntent.getCategories();
/* 201 */     if (categories == null)
/*     */     {
/* 203 */       activity.setResult(0, null);
/* 204 */       activity.finish();
/* 205 */       return;
/*     */     }
/*     */     
/* 208 */     if (categories.contains("com.facebook.orca.category.PLATFORM_THREAD_20150314")) {
/* 209 */       Bundle appLinkExtras = AppLinks.getAppLinkExtras(originalIntent);
/*     */       
/* 211 */       Intent resultIntent = new Intent();
/* 212 */       if (categories.contains("com.facebook.orca.category.PLATFORM_THREAD_20150314")) {
/* 213 */         resultIntent.putExtra("com.facebook.orca.extra.PROTOCOL_VERSION", 20150314);
/* 214 */         String threadToken = appLinkExtras.getString("com.facebook.orca.extra.THREAD_TOKEN");
/* 215 */         resultIntent.putExtra("com.facebook.orca.extra.THREAD_TOKEN", threadToken);
/*     */       } else {
/* 217 */         throw new RuntimeException();
/*     */       }
/* 219 */       resultIntent.setDataAndType(shareToMessengerParams.uri, shareToMessengerParams.mimeType);
/* 220 */       resultIntent.setFlags(1);
/* 221 */       resultIntent.putExtra("com.facebook.orca.extra.APPLICATION_ID", FacebookSdk.getApplicationId());
/* 222 */       resultIntent.putExtra("com.facebook.orca.extra.METADATA", shareToMessengerParams.metaData);
/* 223 */       resultIntent.putExtra("com.facebook.orca.extra.EXTERNAL_URI", shareToMessengerParams.externalUri);
/* 224 */       activity.setResult(-1, resultIntent);
/* 225 */       activity.finish();
/*     */     }
/*     */     else {
/* 228 */       activity.setResult(0, null);
/* 229 */       activity.finish();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean hasMessengerInstalled(Context context)
/*     */   {
/*     */     try
/*     */     {
/* 241 */       context.getPackageManager().getPackageInfo("com.facebook.orca", 0);
/* 242 */       return true;
/*     */     } catch (NameNotFoundException e) {}
/* 244 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void openMessengerInPlayStore(Context context)
/*     */   {
/*     */     try
/*     */     {
/* 255 */       startViewUri(context, "market://details?id=com.facebook.orca");
/*     */     } catch (ActivityNotFoundException anfe) {
/* 257 */       startViewUri(context, "http://play.google.com/store/apps/details?id=com.facebook.orca");
/*     */     }
/*     */   }
/*     */   
/*     */   private static Set<Integer> getAllAvailableProtocolVersions(Context context) {
/* 262 */     ContentResolver contentResolver = context.getContentResolver();
/* 263 */     Set<Integer> allAvailableVersions = new HashSet();
/* 264 */     Uri uri = Uri.parse("content://com.facebook.orca.provider.MessengerPlatformProvider/versions");
/* 265 */     String[] projection = { "version" };
/* 266 */     Cursor c = contentResolver.query(uri, projection, null, null, null);
/* 267 */     if (c != null) {
/*     */       try {
/* 269 */         int versionColumnIndex = c.getColumnIndex("version");
/* 270 */         while (c.moveToNext()) {
/* 271 */           int version = c.getInt(versionColumnIndex);
/* 272 */           allAvailableVersions.add(Integer.valueOf(version));
/*     */         }
/*     */       } finally {
/* 275 */         c.close();
/*     */       }
/*     */     }
/* 278 */     return allAvailableVersions;
/*     */   }
/*     */   
/*     */   private static void startViewUri(Context context, String uri) {
/* 282 */     context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(uri)));
/*     */   }
/*     */   
/*     */   private static List<String> parseParticipants(String s) {
/* 286 */     if ((s == null) || (s.length() == 0)) {
/* 287 */       return Collections.emptyList();
/*     */     }
/* 289 */     String[] parts = s.split(",");
/* 290 */     List<String> ret = new ArrayList();
/* 291 */     for (String part : parts) {
/* 292 */       ret.add(part.trim());
/*     */     }
/* 294 */     return ret;
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/messenger/MessengerUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */