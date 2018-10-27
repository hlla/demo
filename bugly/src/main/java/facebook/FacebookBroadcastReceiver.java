/*    */ package com.facebook;
/*    */ 
/*    */ import android.content.BroadcastReceiver;
/*    */ import android.content.Context;
/*    */ import android.content.Intent;
/*    */ import android.os.Bundle;
/*    */ import com.facebook.internal.NativeProtocol;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FacebookBroadcastReceiver
/*    */   extends BroadcastReceiver
/*    */ {
/*    */   public void onReceive(Context context, Intent intent)
/*    */   {
/* 41 */     String appCallId = intent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
/* 42 */     String action = intent.getStringExtra("com.facebook.platform.protocol.PROTOCOL_ACTION");
/* 43 */     if ((appCallId != null) && (action != null)) {
/* 44 */       Bundle extras = intent.getExtras();
/*    */       
/* 46 */       if (NativeProtocol.isErrorResult(intent)) {
/* 47 */         onFailedAppCall(appCallId, action, extras);
/*    */       } else {
/* 49 */         onSuccessfulAppCall(appCallId, action, extras);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   protected void onSuccessfulAppCall(String appCallId, String action, Bundle extras) {}
/*    */   
/*    */   protected void onFailedAppCall(String appCallId, String action, Bundle extras) {}
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/FacebookBroadcastReceiver.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */