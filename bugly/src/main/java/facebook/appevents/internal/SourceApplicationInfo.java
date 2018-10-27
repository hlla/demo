/*     */ package com.facebook.appevents.internal;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.content.ComponentName;
/*     */ import android.content.Intent;
/*     */ import android.content.SharedPreferences;
/*     */ import android.content.SharedPreferences.Editor;
/*     */ import android.os.Bundle;
/*     */ import android.preference.PreferenceManager;
/*     */ import bolts.AppLinks;
/*     */ import com.facebook.FacebookSdk;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class SourceApplicationInfo
/*     */ {
/*     */   private static final String SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT = "_fbSourceApplicationHasBeenSet";
/*     */   private static final String CALL_APPLICATION_PACKAGE_KEY = "com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage";
/*     */   private static final String OPENED_BY_APP_LINK_KEY = "com.facebook.appevents.SourceApplicationInfo.openedByApplink";
/*     */   private String callingApplicationPackage;
/*     */   private boolean openedByApplink;
/*     */   
/*     */   private SourceApplicationInfo(String callingApplicationPackage, boolean openedByApplink)
/*     */   {
/*  46 */     this.callingApplicationPackage = callingApplicationPackage;
/*  47 */     this.openedByApplink = openedByApplink;
/*     */   }
/*     */   
/*     */   public static SourceApplicationInfo getStoredSourceApplicatioInfo()
/*     */   {
/*  52 */     SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(
/*  53 */       FacebookSdk.getApplicationContext());
/*     */     
/*  55 */     if (!sharedPreferences.contains("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage")) {
/*  56 */       return null;
/*     */     }
/*     */     
/*  59 */     String callingApplicationPackage = sharedPreferences.getString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", null);
/*     */     
/*     */ 
/*  62 */     boolean openedByApplink = sharedPreferences.getBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", false);
/*     */     
/*  64 */     return new SourceApplicationInfo(callingApplicationPackage, openedByApplink);
/*     */   }
/*     */   
/*     */   public static void clearSavedSourceApplicationInfoFromDisk()
/*     */   {
/*  69 */     SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(
/*  70 */       FacebookSdk.getApplicationContext());
/*  71 */     Editor editor = sharedPreferences.edit();
/*  72 */     editor.remove("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage");
/*  73 */     editor.remove("com.facebook.appevents.SourceApplicationInfo.openedByApplink");
/*  74 */     editor.apply();
/*     */   }
/*     */   
/*     */   public String getCallingApplicationPackage() {
/*  78 */     return this.callingApplicationPackage;
/*     */   }
/*     */   
/*     */   public boolean isOpenedByApplink() {
/*  82 */     return this.openedByApplink;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/*  87 */     String openType = "Unclassified";
/*  88 */     if (this.openedByApplink) {
/*  89 */       openType = "Applink";
/*     */     }
/*     */     
/*  92 */     if (this.callingApplicationPackage != null) {
/*  93 */       return openType + "(" + this.callingApplicationPackage + ")";
/*     */     }
/*  95 */     return openType;
/*     */   }
/*     */   
/*     */   public void writeSourceApplicationInfoToDisk()
/*     */   {
/* 100 */     SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(
/* 101 */       FacebookSdk.getApplicationContext());
/* 102 */     Editor editor = sharedPreferences.edit();
/* 103 */     editor.putString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", this.callingApplicationPackage);
/* 104 */     editor.putBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", this.openedByApplink);
/* 105 */     editor.apply();
/*     */   }
/*     */   
/*     */   public static class Factory {
/*     */     public static SourceApplicationInfo create(Activity activity) {
/* 110 */       boolean openedByApplink = false;
/*     */       
/* 112 */       ComponentName callingApplication = activity.getCallingActivity();
/* 113 */       if (callingApplication == null) {
/* 114 */         return null;
/*     */       }
/*     */       
/* 117 */       String callingApplicationPackage = callingApplication.getPackageName();
/* 118 */       if (callingApplicationPackage.equals(activity.getPackageName()))
/*     */       {
/* 120 */         return null;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 126 */       Intent openIntent = activity.getIntent();
/* 127 */       if ((openIntent != null) && 
/* 128 */         (!openIntent.getBooleanExtra("_fbSourceApplicationHasBeenSet", false)))
/*     */       {
/*     */ 
/* 131 */         openIntent.putExtra("_fbSourceApplicationHasBeenSet", true);
/* 132 */         Bundle applinkData = AppLinks.getAppLinkData(openIntent);
/* 133 */         if (applinkData != null) {
/* 134 */           openedByApplink = true;
/* 135 */           Bundle applinkReferrerData = applinkData.getBundle("referer_app_link");
/* 136 */           if (applinkReferrerData != null) {
/* 137 */             String applinkReferrerPackage = applinkReferrerData.getString("package");
/* 138 */             callingApplicationPackage = applinkReferrerPackage;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 144 */       openIntent.putExtra("_fbSourceApplicationHasBeenSet", true);
/* 145 */       return new SourceApplicationInfo(callingApplicationPackage, openedByApplink, null);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/appevents/internal/SourceApplicationInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */