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
/*    */ public enum AppInviteDialogFeature
/*    */   implements DialogFeature
/*    */ {
/* 34 */   APP_INVITES_DIALOG(20140701);
/*    */   
/*    */   private int minVersion;
/*    */   
/*    */   private AppInviteDialogFeature(int minVersion) {
/* 39 */     this.minVersion = minVersion;
/*    */   }
/*    */   
/*    */   public String getAction() {
/* 43 */     return "com.facebook.platform.action.request.APPINVITES_DIALOG";
/*    */   }
/*    */   
/*    */   public int getMinVersion() {
/* 47 */     return this.minVersion;
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/internal/AppInviteDialogFeature.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */