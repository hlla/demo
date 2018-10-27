/*    */ package com.facebook.internal;
/*    */ 
/*    */ import android.app.Activity;
/*    */ import android.content.Intent;
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
/*    */ public class FragmentWrapper
/*    */ {
/*    */   private android.support.v4.app.Fragment supportFragment;
/*    */   private android.app.Fragment nativeFragment;
/*    */   
/*    */   public FragmentWrapper(android.support.v4.app.Fragment fragment)
/*    */   {
/* 34 */     Validate.notNull(fragment, "fragment");
/* 35 */     this.supportFragment = fragment;
/*    */   }
/*    */   
/*    */   public FragmentWrapper(android.app.Fragment fragment) {
/* 39 */     Validate.notNull(fragment, "fragment");
/* 40 */     this.nativeFragment = fragment;
/*    */   }
/*    */   
/*    */   public android.app.Fragment getNativeFragment() {
/* 44 */     return this.nativeFragment;
/*    */   }
/*    */   
/*    */   public android.support.v4.app.Fragment getSupportFragment() {
/* 48 */     return this.supportFragment;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void startActivityForResult(Intent intent, int requestCode)
/*    */   {
/* 56 */     if (this.supportFragment != null) {
/* 57 */       this.supportFragment.startActivityForResult(intent, requestCode);
/*    */     } else {
/* 59 */       this.nativeFragment.startActivityForResult(intent, requestCode);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final Activity getActivity()
/*    */   {
/* 69 */     if (this.supportFragment != null) {
/* 70 */       return this.supportFragment.getActivity();
/*    */     }
/* 72 */     return this.nativeFragment.getActivity();
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/FragmentWrapper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */