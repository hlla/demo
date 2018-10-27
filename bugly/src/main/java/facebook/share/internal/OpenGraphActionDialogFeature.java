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
/*    */ public enum OpenGraphActionDialogFeature
/*    */   implements DialogFeature
/*    */ {
/* 36 */   OG_ACTION_DIALOG(20130618);
/*    */   
/*    */   private int minVersion;
/*    */   
/*    */   private OpenGraphActionDialogFeature(int minVersion) {
/* 41 */     this.minVersion = minVersion;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public String getAction()
/*    */   {
/* 48 */     return "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int getMinVersion()
/*    */   {
/* 55 */     return this.minVersion;
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/internal/OpenGraphActionDialogFeature.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */