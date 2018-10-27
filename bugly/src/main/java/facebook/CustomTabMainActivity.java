/*     */ package com.facebook;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.content.BroadcastReceiver;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.content.IntentFilter;
/*     */ import android.os.Bundle;
/*     */ import android.support.v4.content.LocalBroadcastManager;
/*     */ import com.facebook.internal.CustomTab;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CustomTabMainActivity
/*     */   extends Activity
/*     */ {
/*  35 */   public static final String EXTRA_PARAMS = CustomTabMainActivity.class
/*  36 */     .getSimpleName() + ".extra_params";
/*  37 */   public static final String EXTRA_CHROME_PACKAGE = CustomTabMainActivity.class
/*  38 */     .getSimpleName() + ".extra_chromePackage";
/*  39 */   public static final String EXTRA_URL = CustomTabMainActivity.class
/*  40 */     .getSimpleName() + ".extra_url";
/*  41 */   public static final String REFRESH_ACTION = CustomTabMainActivity.class
/*  42 */     .getSimpleName() + ".action_refresh";
/*     */   
/*  44 */   public static final String getRedirectUrl() { return "fb" + FacebookSdk.getApplicationId() + "://authorize"; }
/*     */   
/*     */ 
/*     */   private static final String OAUTH_DIALOG = "oauth";
/*  48 */   private boolean shouldCloseCustomTab = true;
/*     */   private BroadcastReceiver redirectReceiver;
/*     */   
/*     */   protected void onCreate(Bundle savedInstanceState)
/*     */   {
/*  53 */     super.onCreate(savedInstanceState);
/*     */     
/*     */ 
/*  56 */     if (CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION.equals(getIntent().getAction())) {
/*  57 */       setResult(0);
/*  58 */       finish();
/*  59 */       return;
/*     */     }
/*     */     
/*  62 */     if (savedInstanceState == null) {
/*  63 */       Bundle parameters = getIntent().getBundleExtra(EXTRA_PARAMS);
/*  64 */       String chromePackage = getIntent().getStringExtra(EXTRA_CHROME_PACKAGE);
/*     */       
/*  66 */       CustomTab customTab = new CustomTab("oauth", parameters);
/*  67 */       customTab.openCustomTab(this, chromePackage);
/*     */       
/*  69 */       this.shouldCloseCustomTab = false;
/*     */       
/*     */ 
/*  72 */       this.redirectReceiver = new BroadcastReceiver()
/*     */       {
/*     */         public void onReceive(Context context, Intent intent)
/*     */         {
/*  76 */           Intent newIntent = new Intent(CustomTabMainActivity.this, CustomTabMainActivity.class);
/*     */           
/*  78 */           newIntent.setAction(CustomTabMainActivity.REFRESH_ACTION);
/*  79 */           newIntent.putExtra(CustomTabMainActivity.EXTRA_URL, intent.getStringExtra(CustomTabMainActivity.EXTRA_URL));
/*  80 */           newIntent.addFlags(603979776);
/*     */           
/*     */ 
/*  83 */           CustomTabMainActivity.this.startActivity(newIntent);
/*     */         }
/*  85 */       };
/*  86 */       LocalBroadcastManager.getInstance(this).registerReceiver(this.redirectReceiver, new IntentFilter(CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void onNewIntent(Intent intent)
/*     */   {
/*  95 */     super.onNewIntent(intent);
/*  96 */     if (REFRESH_ACTION.equals(intent.getAction()))
/*     */     {
/*  98 */       Intent broadcast = new Intent(CustomTabActivity.DESTROY_ACTION);
/*  99 */       LocalBroadcastManager.getInstance(this).sendBroadcast(broadcast);
/* 100 */       sendResult(-1, intent);
/* 101 */     } else if (CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION.equals(intent.getAction()))
/*     */     {
/* 103 */       sendResult(-1, intent);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void onResume()
/*     */   {
/* 109 */     super.onResume();
/* 110 */     if (this.shouldCloseCustomTab)
/*     */     {
/* 112 */       sendResult(0, null);
/*     */     }
/* 114 */     this.shouldCloseCustomTab = true;
/*     */   }
/*     */   
/*     */   private void sendResult(int resultCode, Intent resultIntent) {
/* 118 */     LocalBroadcastManager.getInstance(this).unregisterReceiver(this.redirectReceiver);
/* 119 */     if (resultIntent != null) {
/* 120 */       setResult(resultCode, resultIntent);
/*     */     } else {
/* 122 */       setResult(resultCode);
/*     */     }
/* 124 */     finish();
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/CustomTabMainActivity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */