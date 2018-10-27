/*    */ package com.facebook.share.internal;
/*    */ 
/*    */ import com.facebook.internal.DialogFeature;
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
/*    */ 
/*    */ public enum MessageDialogFeature
/*    */   implements DialogFeature
/*    */ {
/* 36 */   MESSAGE_DIALOG(20140204), 
/*    */   
/*    */ 
/*    */ 
/* 40 */   PHOTOS(20140324), 
/*    */   
/*    */ 
/*    */ 
/* 44 */   VIDEO(20141218);
/*    */   
/*    */   private int minVersion;
/*    */   
/*    */   private MessageDialogFeature(int minVersion)
/*    */   {
/* 50 */     this.minVersion = minVersion;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public String getAction()
/*    */   {
/* 57 */     return "com.facebook.platform.action.request.MESSAGE_DIALOG";
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int getMinVersion()
/*    */   {
/* 64 */     return this.minVersion;
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/internal/MessageDialogFeature.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */