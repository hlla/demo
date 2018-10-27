/*    */ package com.facebook.internal;
/*    */ 
/*    */ import android.app.Activity;
/*    */ import android.content.Intent;
/*    */ import android.net.Uri;
/*    */ import android.os.Bundle;
/*    */ import android.support.customtabs.CustomTabsIntent;
/*    */ import android.support.customtabs.CustomTabsIntent.Builder;
/*    */ import com.facebook.FacebookSdk;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CustomTab
/*    */ {
/*    */   private Uri uri;
/*    */   
/*    */   public CustomTab(String action, Bundle parameters)
/*    */   {
/* 37 */     if (parameters == null) {
/* 38 */       parameters = new Bundle();
/*    */     }
/* 40 */     this.uri = Utility.buildUri(
/* 41 */       ServerProtocol.getDialogAuthority(), 
/* 42 */       FacebookSdk.getGraphApiVersion() + "/" + "dialog/" + action, parameters);
/*    */   }
/*    */   
/*    */   public void openCustomTab(Activity activity, String packageName)
/*    */   {
/* 47 */     CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder().build();
/* 48 */     customTabsIntent.intent.setPackage(packageName);
/* 49 */     customTabsIntent.intent.addFlags(1073741824);
/* 50 */     customTabsIntent.launchUrl(activity, this.uri);
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/CustomTab.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */