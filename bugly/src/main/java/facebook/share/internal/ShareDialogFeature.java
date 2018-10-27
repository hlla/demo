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
/*    */ public enum ShareDialogFeature
/*    */   implements DialogFeature
/*    */ {
/* 36 */   SHARE_DIALOG(20130618), 
/*    */   
/*    */ 
/*    */ 
/* 40 */   PHOTOS(20140204), 
/*    */   
/*    */ 
/*    */ 
/* 44 */   VIDEO(20141028), 
/*    */   
/*    */ 
/*    */ 
/* 48 */   MULTIMEDIA(20160327), 
/*    */   
/*    */ 
/*    */ 
/* 52 */   HASHTAG(20160327), 
/*    */   
/*    */ 
/*    */ 
/* 56 */   LINK_SHARE_QUOTES(20160327);
/*    */   
/*    */   private int minVersion;
/*    */   
/*    */   private ShareDialogFeature(int minVersion)
/*    */   {
/* 62 */     this.minVersion = minVersion;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public String getAction()
/*    */   {
/* 69 */     return "com.facebook.platform.action.request.FEED_DIALOG";
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int getMinVersion()
/*    */   {
/* 76 */     return this.minVersion;
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/internal/ShareDialogFeature.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */