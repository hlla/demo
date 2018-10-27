/*    */ package com.facebook.share.internal;
/*    */ 
/*    */ import android.os.Bundle;
/*    */ import com.facebook.FacebookCallback;
/*    */ import com.facebook.FacebookException;
/*    */ import com.facebook.internal.AppCall;
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
/*    */ public abstract class ResultProcessor
/*    */ {
/*    */   private FacebookCallback appCallback;
/*    */   
/*    */   public ResultProcessor(FacebookCallback callback)
/*    */   {
/* 40 */     this.appCallback = callback;
/*    */   }
/*    */   
/*    */ 
/*    */   public abstract void onSuccess(AppCall paramAppCall, Bundle paramBundle);
/*    */   
/*    */ 
/*    */   public void onCancel(AppCall appCall)
/*    */   {
/* 49 */     if (this.appCallback != null) {
/* 50 */       this.appCallback.onCancel();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void onError(AppCall appCall, FacebookException error)
/*    */   {
/* 58 */     if (this.appCallback != null) {
/* 59 */       this.appCallback.onError(error);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/internal/ResultProcessor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */