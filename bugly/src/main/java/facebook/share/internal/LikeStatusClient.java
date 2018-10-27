/*    */ package com.facebook.share.internal;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.os.Bundle;
/*    */ import com.facebook.internal.PlatformServiceClient;
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
/*    */ 
/*    */ final class LikeStatusClient
/*    */   extends PlatformServiceClient
/*    */ {
/*    */   private String objectId;
/*    */   
/*    */   LikeStatusClient(Context context, String applicationId, String objectId)
/*    */   {
/* 43 */     super(context, 65542, 65543, 20141001, applicationId);
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 49 */     this.objectId = objectId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void populateRequestBundle(Bundle data)
/*    */   {
/* 55 */     data.putString("com.facebook.platform.extra.OBJECT_ID", this.objectId);
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/internal/LikeStatusClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */