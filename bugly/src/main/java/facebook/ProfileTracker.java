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
/*     */ public abstract class ProfileTracker
/*     */ {
/*     */   private final BroadcastReceiver receiver;
/*     */   private final LocalBroadcastManager broadcastManager;
/*  40 */   private boolean isTracking = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected abstract void onCurrentProfileChanged(Profile paramProfile1, Profile paramProfile2);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ProfileTracker()
/*     */   {
/*  55 */     Validate.sdkInitialized();
/*  56 */     this.receiver = new ProfileBroadcastReceiver(null);
/*  57 */     this.broadcastManager = LocalBroadcastManager.getInstance(
/*  58 */       FacebookSdk.getApplicationContext());
/*  59 */     startTracking();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void startTracking()
/*     */   {
/*  66 */     if (this.isTracking) {
/*  67 */       return;
/*     */     }
/*     */     
/*  70 */     addBroadcastReceiver();
/*     */     
/*  72 */     this.isTracking = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void stopTracking()
/*     */   {
/*  79 */     if (!this.isTracking) {
/*  80 */       return;
/*     */     }
/*     */     
/*  83 */     this.broadcastManager.unregisterReceiver(this.receiver);
/*  84 */     this.isTracking = false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  92 */   public boolean isTracking() { return this.isTracking; }
/*     */   
/*     */   private class ProfileBroadcastReceiver extends BroadcastReceiver {
/*     */     private ProfileBroadcastReceiver() {}
/*     */     
/*     */     public void onReceive(Context context, Intent intent) {
/*  98 */       if ("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED".equals(intent.getAction()))
/*     */       {
/*     */ 
/* 101 */         Profile oldProfile = (Profile)intent.getParcelableExtra("com.facebook.sdk.EXTRA_OLD_PROFILE");
/*     */         
/* 103 */         Profile newProfile = (Profile)intent.getParcelableExtra("com.facebook.sdk.EXTRA_NEW_PROFILE");
/*     */         
/* 105 */         ProfileTracker.this.onCurrentProfileChanged(oldProfile, newProfile);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void addBroadcastReceiver() {
/* 111 */     IntentFilter filter = new IntentFilter();
/* 112 */     filter.addAction("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED");
/*     */     
/* 114 */     this.broadcastManager.registerReceiver(this.receiver, filter);
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/ProfileTracker.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */