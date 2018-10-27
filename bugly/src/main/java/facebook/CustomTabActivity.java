/*    */ package com.facebook;
/*    */ 
/*    */ import android.app.Activity;
/*    */ import android.content.BroadcastReceiver;
/*    */ import android.content.Context;
/*    */ import android.content.Intent;
/*    */ import android.content.IntentFilter;
/*    */ import android.os.Bundle;
/*    */ import android.support.v4.content.LocalBroadcastManager;
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
/*    */ 
/*    */ 
/*    */ public class CustomTabActivity
/*    */   extends Activity
/*    */ {
/*    */   private static final int CUSTOM_TAB_REDIRECT_REQUEST_CODE = 2;
/* 37 */   public static final String CUSTOM_TAB_REDIRECT_ACTION = CustomTabActivity.class
/* 38 */     .getSimpleName() + ".action_customTabRedirect";
/* 39 */   public static final String DESTROY_ACTION = CustomTabActivity.class
/* 40 */     .getSimpleName() + ".action_destroy";
/*    */   
/*    */   private BroadcastReceiver closeReceiver;
/*    */   
/*    */   protected void onCreate(Bundle savedInstanceState)
/*    */   {
/* 46 */     super.onCreate(savedInstanceState);
/* 47 */     Intent intent = new Intent(this, CustomTabMainActivity.class);
/* 48 */     intent.setAction(CUSTOM_TAB_REDIRECT_ACTION);
/* 49 */     intent.putExtra(CustomTabMainActivity.EXTRA_URL, getIntent().getDataString());
/*    */     
/*    */ 
/*    */ 
/* 53 */     intent.addFlags(603979776);
/*    */     
/* 55 */     startActivityForResult(intent, 2);
/*    */   }
/*    */   
/*    */   protected void onActivityResult(int requestCode, int resultCode, Intent data)
/*    */   {
/* 60 */     super.onActivityResult(requestCode, resultCode, data);
/*    */     
/* 62 */     if (resultCode == 0)
/*    */     {
/*    */ 
/* 65 */       Intent broadcast = new Intent(CUSTOM_TAB_REDIRECT_ACTION);
/* 66 */       broadcast.putExtra(CustomTabMainActivity.EXTRA_URL, getIntent().getDataString());
/* 67 */       LocalBroadcastManager.getInstance(this).sendBroadcast(broadcast);
/*    */       
/*    */ 
/* 70 */       this.closeReceiver = new BroadcastReceiver()
/*    */       {
/*    */         public void onReceive(Context context, Intent intent) {
/* 73 */           CustomTabActivity.this.finish();
/*    */         }
/* 75 */       };
/* 76 */       LocalBroadcastManager.getInstance(this).registerReceiver(this.closeReceiver, new IntentFilter(DESTROY_ACTION));
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDestroy()
/*    */   {
/* 85 */     LocalBroadcastManager.getInstance(this).unregisterReceiver(this.closeReceiver);
/* 86 */     super.onDestroy();
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/CustomTabActivity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */