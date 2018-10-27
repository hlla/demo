/*     */ package com.facebook;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.support.v4.content.LocalBroadcastManager;
/*     */ import com.facebook.internal.Utility;
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
/*     */ final class ProfileManager
/*     */ {
/*     */   static final String ACTION_CURRENT_PROFILE_CHANGED = "com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED";
/*     */   static final String EXTRA_OLD_PROFILE = "com.facebook.sdk.EXTRA_OLD_PROFILE";
/*     */   static final String EXTRA_NEW_PROFILE = "com.facebook.sdk.EXTRA_NEW_PROFILE";
/*     */   private static volatile ProfileManager instance;
/*     */   private final LocalBroadcastManager localBroadcastManager;
/*     */   private final ProfileCache profileCache;
/*     */   private Profile currentProfile;
/*     */   
/*     */   ProfileManager(LocalBroadcastManager localBroadcastManager, ProfileCache profileCache)
/*     */   {
/*  48 */     Validate.notNull(localBroadcastManager, "localBroadcastManager");
/*  49 */     Validate.notNull(profileCache, "profileCache");
/*  50 */     this.localBroadcastManager = localBroadcastManager;
/*  51 */     this.profileCache = profileCache;
/*     */   }
/*     */   
/*     */   static ProfileManager getInstance() {
/*  55 */     if (instance == null) {
/*  56 */       synchronized (ProfileManager.class) {
/*  57 */         if (instance == null) {
/*  58 */           Context applicationContext = FacebookSdk.getApplicationContext();
/*  59 */           LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(applicationContext);
/*     */           
/*     */ 
/*  62 */           instance = new ProfileManager(localBroadcastManager, new ProfileCache());
/*     */         }
/*     */       }
/*     */     }
/*  66 */     return instance;
/*     */   }
/*     */   
/*     */   Profile getCurrentProfile() {
/*  70 */     return this.currentProfile;
/*     */   }
/*     */   
/*     */   boolean loadCurrentProfile() {
/*  74 */     Profile profile = this.profileCache.load();
/*     */     
/*  76 */     if (profile != null) {
/*  77 */       setCurrentProfile(profile, false);
/*  78 */       return true;
/*     */     }
/*     */     
/*  81 */     return false;
/*     */   }
/*     */   
/*     */   void setCurrentProfile(Profile currentProfile) {
/*  85 */     setCurrentProfile(currentProfile, true);
/*     */   }
/*     */   
/*     */   private void setCurrentProfile(Profile currentProfile, boolean writeToCache) {
/*  89 */     Profile oldProfile = this.currentProfile;
/*  90 */     this.currentProfile = currentProfile;
/*     */     
/*  92 */     if (writeToCache) {
/*  93 */       if (currentProfile != null) {
/*  94 */         this.profileCache.save(currentProfile);
/*     */       } else {
/*  96 */         this.profileCache.clear();
/*     */       }
/*     */     }
/*     */     
/* 100 */     if (!Utility.areObjectsEqual(oldProfile, currentProfile)) {
/* 101 */       sendCurrentProfileChangedBroadcast(oldProfile, currentProfile);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void sendCurrentProfileChangedBroadcast(Profile oldProfile, Profile currentProfile)
/*     */   {
/* 108 */     Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED");
/*     */     
/* 110 */     intent.putExtra("com.facebook.sdk.EXTRA_OLD_PROFILE", oldProfile);
/* 111 */     intent.putExtra("com.facebook.sdk.EXTRA_NEW_PROFILE", currentProfile);
/*     */     
/* 113 */     this.localBroadcastManager.sendBroadcast(intent);
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/ProfileManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */