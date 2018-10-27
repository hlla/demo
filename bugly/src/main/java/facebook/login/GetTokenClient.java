/*    */ package com.facebook.login;
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
/*    */ final class GetTokenClient
/*    */   extends PlatformServiceClient
/*    */ {
/*    */   GetTokenClient(Context context, String applicationId)
/*    */   {
/* 32 */     super(context, 65536, 65537, 20121101, applicationId);
/*    */   }
/*    */   
/*    */   protected void populateRequestBundle(Bundle data) {}
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/login/GetTokenClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */