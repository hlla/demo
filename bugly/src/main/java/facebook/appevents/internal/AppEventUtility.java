/*    */ package com.facebook.appevents.internal;
/*    */ 
/*    */ import android.os.Looper;
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
/*    */ public class AppEventUtility
/*    */ {
/*    */   public static void assertIsNotMainThread() {}
/*    */   
/*    */   public static void assertIsMainThread() {}
/*    */   
/*    */   private static boolean isMainThread()
/*    */   {
/* 46 */     return Looper.myLooper() == Looper.getMainLooper();
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/appevents/internal/AppEventUtility.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */