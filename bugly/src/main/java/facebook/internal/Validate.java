/*     */ package com.facebook.internal;
/*     */ 
/*     */ import android.content.ComponentName;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.content.pm.ActivityInfo;
/*     */ import android.content.pm.PackageManager;
/*     */ import android.content.pm.PackageManager.NameNotFoundException;
/*     */ import android.content.pm.ResolveInfo;
/*     */ import android.net.Uri;
/*     */ import android.os.Looper;
/*     */ import android.util.Log;
/*     */ import com.facebook.CustomTabActivity;
/*     */ import com.facebook.FacebookActivity;
/*     */ import com.facebook.FacebookException;
/*     */ import com.facebook.FacebookSdk;
/*     */ import com.facebook.FacebookSdkNotInitializedException;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Validate
/*     */ {
/*  50 */   private static final String TAG = Validate.class.getName();
/*     */   
/*     */ 
/*     */ 
/*     */   private static final String NO_INTERNET_PERMISSION_REASON = "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.";
/*     */   
/*     */ 
/*     */ 
/*     */   private static final String FACEBOOK_ACTIVITY_NOT_FOUND_REASON = "FacebookActivity is not declared in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.";
/*     */   
/*     */ 
/*     */ 
/*     */   private static final String CUSTOM_TAB_REDIRECT_ACTIVITY_NOT_FOUND_REASON = "FacebookActivity is declared incorrectly in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.";
/*     */   
/*     */ 
/*     */ 
/*     */   private static final String CONTENT_PROVIDER_NOT_FOUND_REASON = "A ContentProvider for this app was not set up in the AndroidManifest.xml, please add %s as a provider to your AndroidManifest.xml file. See https://developers.facebook.com/docs/sharing/android for more info.";
/*     */   
/*     */ 
/*     */   private static final String CONTENT_PROVIDER_BASE = "com.facebook.app.FacebookContentProvider";
/*     */   
/*     */ 
/*     */ 
/*     */   public static void notNull(Object arg, String name)
/*     */   {
/*  75 */     if (arg == null) {
/*  76 */       throw new NullPointerException("Argument '" + name + "' cannot be null");
/*     */     }
/*     */   }
/*     */   
/*     */   public static <T> void notEmpty(Collection<T> container, String name) {
/*  81 */     if (container.isEmpty()) {
/*  82 */       throw new IllegalArgumentException("Container '" + name + "' cannot be empty");
/*     */     }
/*     */   }
/*     */   
/*     */   public static <T> void containsNoNulls(Collection<T> container, String name) {
/*  87 */     notNull(container, name);
/*  88 */     for (T item : container) {
/*  89 */       if (item == null) {
/*  90 */         throw new NullPointerException("Container '" + name + "' cannot contain null values");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static void containsNoNullOrEmpty(Collection<String> container, String name)
/*     */   {
/*  97 */     notNull(container, name);
/*  98 */     for (String item : container) {
/*  99 */       if (item == null) {
/* 100 */         throw new NullPointerException("Container '" + name + "' cannot contain null values");
/*     */       }
/*     */       
/* 103 */       if (item.length() == 0) {
/* 104 */         throw new IllegalArgumentException("Container '" + name + "' cannot contain empty values");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static <T> void notEmptyAndContainsNoNulls(Collection<T> container, String name)
/*     */   {
/* 111 */     containsNoNulls(container, name);
/* 112 */     notEmpty(container, name);
/*     */   }
/*     */   
/*     */   public static void runningOnUiThread() {
/* 116 */     if (!Looper.getMainLooper().equals(Looper.myLooper())) {
/* 117 */       throw new FacebookException("This method should be called from the UI thread");
/*     */     }
/*     */   }
/*     */   
/*     */   public static void notNullOrEmpty(String arg, String name) {
/* 122 */     if (Utility.isNullOrEmpty(arg)) {
/* 123 */       throw new IllegalArgumentException("Argument '" + name + "' cannot be null or empty");
/*     */     }
/*     */   }
/*     */   
/*     */   public static void oneOf(Object arg, String name, Object... values) {
/* 128 */     for (Object value : values) {
/* 129 */       if (value != null) {
/* 130 */         if (!value.equals(arg)) {}
/*     */ 
/*     */ 
/*     */       }
/* 134 */       else if (arg == null) {
/* 135 */         return;
/*     */       }
/*     */     }
/*     */     
/* 139 */     throw new IllegalArgumentException("Argument '" + name + "' was not one of the allowed values");
/*     */   }
/*     */   
/*     */   public static void sdkInitialized()
/*     */   {
/* 144 */     if (!FacebookSdk.isInitialized()) {
/* 145 */       throw new FacebookSdkNotInitializedException("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static String hasAppID()
/*     */   {
/* 152 */     String id = FacebookSdk.getApplicationId();
/* 153 */     if (id == null) {
/* 154 */       throw new IllegalStateException("No App ID found, please set the App ID.");
/*     */     }
/* 156 */     return id;
/*     */   }
/*     */   
/*     */   public static String hasClientToken() {
/* 160 */     String token = FacebookSdk.getClientToken();
/* 161 */     if (token == null) {
/* 162 */       throw new IllegalStateException("No Client Token found, please set the Client Token.");
/*     */     }
/* 164 */     return token;
/*     */   }
/*     */   
/*     */   public static void hasInternetPermissions(Context context) {
/* 168 */     hasInternetPermissions(context, true);
/*     */   }
/*     */   
/*     */   public static void hasInternetPermissions(Context context, boolean shouldThrow) {
/* 172 */     notNull(context, "context");
/* 173 */     if (context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1)
/*     */     {
/* 175 */       if (shouldThrow) {
/* 176 */         throw new IllegalStateException("No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.");
/*     */       }
/* 178 */       Log.w(TAG, "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.");
/*     */     }
/*     */   }
/*     */   
/*     */   public static void hasFacebookActivity(Context context)
/*     */   {
/* 184 */     hasFacebookActivity(context, true);
/*     */   }
/*     */   
/*     */   public static void hasFacebookActivity(Context context, boolean shouldThrow)
/*     */   {
/* 189 */     notNull(context, "context");
/* 190 */     PackageManager pm = context.getPackageManager();
/* 191 */     ActivityInfo activityInfo = null;
/* 192 */     if (pm != null) {
/* 193 */       ComponentName componentName = new ComponentName(context, FacebookActivity.class);
/*     */       try
/*     */       {
/* 196 */         activityInfo = pm.getActivityInfo(componentName, 1);
/*     */       }
/*     */       catch (NameNotFoundException localNameNotFoundException) {}
/*     */     }
/* 200 */     if (activityInfo == null) {
/* 201 */       if (shouldThrow) {
/* 202 */         throw new IllegalStateException("FacebookActivity is not declared in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.");
/*     */       }
/* 204 */       Log.w(TAG, "FacebookActivity is not declared in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.");
/*     */     }
/*     */   }
/*     */   
/*     */   public static void checkCustomTabRedirectActivity(Context context)
/*     */   {
/* 210 */     checkCustomTabRedirectActivity(context, true);
/*     */   }
/*     */   
/*     */   public static void checkCustomTabRedirectActivity(Context context, boolean shouldThrow) {
/* 214 */     if (!hasCustomTabRedirectActivity(context)) {
/* 215 */       if (shouldThrow) {
/* 216 */         throw new IllegalStateException("FacebookActivity is declared incorrectly in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.");
/*     */       }
/* 218 */       Log.w(TAG, "FacebookActivity is declared incorrectly in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.");
/*     */     }
/*     */   }
/*     */   
/*     */   public static boolean hasCustomTabRedirectActivity(Context context)
/*     */   {
/* 224 */     notNull(context, "context");
/* 225 */     PackageManager pm = context.getPackageManager();
/* 226 */     List<ResolveInfo> infos = null;
/* 227 */     if (pm != null) {
/* 228 */       Intent intent = new Intent();
/* 229 */       intent.setAction("android.intent.action.VIEW");
/* 230 */       intent.addCategory("android.intent.category.DEFAULT");
/* 231 */       intent.addCategory("android.intent.category.BROWSABLE");
/* 232 */       intent.setData(Uri.parse("fb" + FacebookSdk.getApplicationId() + "://authorize"));
/* 233 */       infos = pm.queryIntentActivities(intent, 64);
/*     */     }
/* 235 */     boolean hasActivity = false;
/* 236 */     if (infos != null) {
/* 237 */       for (ResolveInfo info : infos) {
/* 238 */         ActivityInfo activityInfo = info.activityInfo;
/* 239 */         if (activityInfo.name.equals(CustomTabActivity.class.getName())) {
/* 240 */           hasActivity = true;
/*     */         }
/*     */         else
/*     */         {
/* 244 */           return false;
/*     */         }
/*     */       }
/*     */     }
/* 248 */     return hasActivity;
/*     */   }
/*     */   
/*     */   public static void hasContentProvider(Context context) {
/* 252 */     notNull(context, "context");
/* 253 */     String appId = hasAppID();
/* 254 */     PackageManager pm = context.getPackageManager();
/* 255 */     if (pm != null) {
/* 256 */       String providerName = "com.facebook.app.FacebookContentProvider" + appId;
/* 257 */       if (pm.resolveContentProvider(providerName, 0) == null)
/*     */       {
/* 259 */         throw new IllegalStateException(String.format("A ContentProvider for this app was not set up in the AndroidManifest.xml, please add %s as a provider to your AndroidManifest.xml file. See https://developers.facebook.com/docs/sharing/android for more info.", new Object[] { providerName }));
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/Validate.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */