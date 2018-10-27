/*     */ package com.facebook;
/*     */ 
/*     */ import android.content.Intent;
/*     */ import android.content.res.Configuration;
/*     */ import android.os.Bundle;
/*     */ import android.support.v4.app.Fragment;
/*     */ import android.support.v4.app.FragmentActivity;
/*     */ import android.support.v4.app.FragmentManager;
/*     */ import android.support.v4.app.FragmentTransaction;
/*     */ import android.util.Log;
/*     */ import com.facebook.internal.FacebookDialogFragment;
/*     */ import com.facebook.internal.NativeProtocol;
/*     */ import com.facebook.login.LoginFragment;
/*     */ import com.facebook.share.internal.DeviceShareDialogFragment;
/*     */ import com.facebook.share.model.ShareContent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FacebookActivity
/*     */   extends FragmentActivity
/*     */ {
/*  53 */   public static String PASS_THROUGH_CANCEL_ACTION = "PassThrough";
/*  54 */   private static String FRAGMENT_TAG = "SingleFragment";
/*  55 */   private static final String TAG = FacebookActivity.class.getName();
/*     */   
/*     */   private Fragment singleFragment;
/*     */   
/*     */   public void onCreate(Bundle savedInstanceState)
/*     */   {
/*  61 */     super.onCreate(savedInstanceState);
/*  62 */     Intent intent = getIntent();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  68 */     if (!FacebookSdk.isInitialized()) {
/*  69 */       Log.d(TAG, "Facebook SDK not initialized. Make sure you call sdkInitialize inside your Application's onCreate method.");
/*     */       
/*     */ 
/*     */ 
/*  73 */       FacebookSdk.sdkInitialize(getApplicationContext());
/*     */     }
/*     */     
/*  76 */     setContentView(R.layout.com_facebook_activity_layout);
/*     */     
/*  78 */     if (PASS_THROUGH_CANCEL_ACTION.equals(intent.getAction())) {
/*  79 */       handlePassThroughError();
/*  80 */       return;
/*     */     }
/*     */     
/*  83 */     this.singleFragment = getFragment();
/*     */   }
/*     */   
/*     */   protected Fragment getFragment() {
/*  87 */     Intent intent = getIntent();
/*  88 */     FragmentManager manager = getSupportFragmentManager();
/*  89 */     Fragment fragment = manager.findFragmentByTag(FRAGMENT_TAG);
/*     */     
/*  91 */     if (fragment == null) {
/*  92 */       if ("FacebookDialogFragment".equals(intent.getAction())) {
/*  93 */         FacebookDialogFragment dialogFragment = new FacebookDialogFragment();
/*  94 */         dialogFragment.setRetainInstance(true);
/*  95 */         dialogFragment.show(manager, FRAGMENT_TAG);
/*     */         
/*  97 */         fragment = dialogFragment;
/*  98 */       } else if ("DeviceShareDialogFragment".equals(intent.getAction())) {
/*  99 */         DeviceShareDialogFragment dialogFragment = new DeviceShareDialogFragment();
/* 100 */         dialogFragment.setRetainInstance(true);
/* 101 */         dialogFragment.setShareContent((ShareContent)intent.getParcelableExtra("content"));
/* 102 */         dialogFragment.show(manager, FRAGMENT_TAG);
/* 103 */         fragment = dialogFragment;
/*     */       } else {
/* 105 */         fragment = new LoginFragment();
/* 106 */         fragment.setRetainInstance(true);
/* 107 */         manager.beginTransaction()
/* 108 */           .add(R.id.com_facebook_fragment_container, fragment, FRAGMENT_TAG)
/* 109 */           .commit();
/*     */       }
/*     */     }
/* 112 */     return fragment;
/*     */   }
/*     */   
/*     */   public void onConfigurationChanged(Configuration newConfig)
/*     */   {
/* 117 */     super.onConfigurationChanged(newConfig);
/*     */     
/* 119 */     if (this.singleFragment != null) {
/* 120 */       this.singleFragment.onConfigurationChanged(newConfig);
/*     */     }
/*     */   }
/*     */   
/*     */   public Fragment getCurrentFragment() {
/* 125 */     return this.singleFragment;
/*     */   }
/*     */   
/*     */   private void handlePassThroughError() {
/* 129 */     Intent requestIntent = getIntent();
/*     */     
/*     */ 
/* 132 */     Bundle errorResults = NativeProtocol.getMethodArgumentsFromIntent(requestIntent);
/* 133 */     FacebookException exception = NativeProtocol.getExceptionFromErrorData(errorResults);
/*     */     
/* 135 */     Intent resultIntent = NativeProtocol.createProtocolResultIntent(
/* 136 */       getIntent(), null, exception);
/*     */     
/*     */ 
/* 139 */     setResult(0, resultIntent);
/* 140 */     finish();
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/FacebookActivity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */