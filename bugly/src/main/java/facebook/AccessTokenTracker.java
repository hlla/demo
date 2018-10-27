/*     */ package com.facebook;
/*     */ 
/*     */ import android.content.BroadcastReceiver;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.content.IntentFilter;
/*     */ import android.support.v4.content.LocalBroadcastManager;
/*     */ import com.facebook.internal.Validate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AccessTokenTracker
/*     */ {
/*     */   private final BroadcastReceiver receiver;
/*     */   private final LocalBroadcastManager broadcastManager;
/*  41 */   private boolean isTracking = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected abstract void onCurrentAccessTokenChanged(AccessToken paramAccessToken1, AccessToken paramAccessToken2);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public AccessTokenTracker()
/*     */   {
/*  55 */     Validate.sdkInitialized();
/*     */     
/*  57 */     this.receiver = new CurrentAccessTokenBroadcastReceiver(null);
/*  58 */     this.broadcastManager = LocalBroadcastManager.getInstance(
/*  59 */       FacebookSdk.getApplicationContext());
/*     */     
/*  61 */     startTracking();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void startTracking()
/*     */   {
/*  68 */     if (this.isTracking) {
/*  69 */       return;
/*     */     }
/*     */     
/*  72 */     addBroadcastReceiver();
/*     */     
/*  74 */     this.isTracking = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void stopTracking()
/*     */   {
/*  81 */     if (!this.isTracking) {
/*  82 */       return;
/*     */     }
/*     */     
/*  85 */     this.broadcastManager.unregisterReceiver(this.receiver);
/*  86 */     this.isTracking = false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  94 */   public boolean isTracking() { return this.isTracking; }
/*     */   
/*     */   private class CurrentAccessTokenBroadcastReceiver extends BroadcastReceiver {
/*     */     private CurrentAccessTokenBroadcastReceiver() {}
/*     */     
/*     */     public void onReceive(Context context, Intent intent) {
/* 100 */       if ("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED".equals(intent.getAction()))
/*     */       {
/*     */ 
/* 103 */         AccessToken oldAccessToken = (AccessToken)intent.getParcelableExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN");
/*     */         
/* 105 */         AccessToken newAccessToken = (AccessToken)intent.getParcelableExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN");
/*     */         
/* 107 */         AccessTokenTracker.this.onCurrentAccessTokenChanged(oldAccessToken, newAccessToken);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void addBroadcastReceiver() {
/* 113 */     IntentFilter filter = new IntentFilter();
/* 114 */     filter.addAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
/*     */     
/* 116 */     this.broadcastManager.registerReceiver(this.receiver, filter);
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/AccessTokenTracker.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */