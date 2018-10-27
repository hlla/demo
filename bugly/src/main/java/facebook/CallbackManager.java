/*    */ package com.facebook;
/*    */ 
/*    */ import android.content.Intent;
/*    */ import com.facebook.internal.CallbackManagerImpl;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract interface CallbackManager
/*    */ {
/*    */   public abstract boolean onActivityResult(int paramInt1, int paramInt2, Intent
        paramIntent);
/*    */   
/*    */   public static class Factory
/*    */   {
/*    */     public static CallbackManager create()
/*    */     {
/* 51 */       return new CallbackManagerImpl();
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/CallbackManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */