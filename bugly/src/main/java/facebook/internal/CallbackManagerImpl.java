/*     */ package com.facebook.internal;
/*     */ 
/*     */ import android.content.Intent;
/*     */ import com.facebook.CallbackManager;
/*     */ import com.facebook.FacebookSdk;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class CallbackManagerImpl
/*     */   implements CallbackManager
/*     */ {
/*  37 */   private static Map<Integer, Callback> staticCallbacks = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static synchronized void registerStaticCallback(int requestCode, Callback callback)
/*     */   {
/*  49 */     Validate.notNull(callback, "callback");
/*  50 */     if (staticCallbacks.containsKey(Integer.valueOf(requestCode))) {
/*  51 */       return;
/*     */     }
/*  53 */     staticCallbacks.put(Integer.valueOf(requestCode), callback);
/*     */   }
/*     */   
/*     */   private static synchronized Callback getStaticCallback(Integer requestCode) {
/*  57 */     return (Callback)staticCallbacks.get(requestCode);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static boolean runStaticCallback(int requestCode, int resultCode, Intent data)
/*     */   {
/*  64 */     Callback callback = getStaticCallback(Integer.valueOf(requestCode));
/*  65 */     if (callback != null) {
/*  66 */       return callback.onActivityResult(resultCode, data);
/*     */     }
/*  68 */     return false;
/*     */   }
/*     */   
/*  71 */   private Map<Integer, Callback> callbacks = new HashMap();
/*     */   
/*     */   public void registerCallback(int requestCode, Callback callback) {
/*  74 */     Validate.notNull(callback, "callback");
/*  75 */     this.callbacks.put(Integer.valueOf(requestCode), callback);
/*     */   }
/*     */   
/*     */   public boolean onActivityResult(int requestCode, int resultCode, Intent data)
/*     */   {
/*  80 */     Callback callback = (Callback)this.callbacks.get(Integer.valueOf(requestCode));
/*  81 */     if (callback != null) {
/*  82 */       return callback.onActivityResult(resultCode, data);
/*     */     }
/*  84 */     return runStaticCallback(requestCode, resultCode, data);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static enum RequestCodeOffset
/*     */   {
/*  92 */     Login(0), 
/*  93 */     Share(1), 
/*  94 */     Message(2), 
/*  95 */     Like(3), 
/*  96 */     GameRequest(4), 
/*  97 */     AppGroupCreate(5), 
/*  98 */     AppGroupJoin(6), 
/*  99 */     AppInvite(7), 
/* 100 */     DeviceShare(8);
/*     */     
/*     */     private final int offset;
/*     */     
/*     */     private RequestCodeOffset(int offset)
/*     */     {
/* 106 */       this.offset = offset;
/*     */     }
/*     */     
/*     */     public int toRequestCode() {
/* 110 */       return FacebookSdk.getCallbackRequestCodeOffset() + this.offset;
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract interface Callback
/*     */   {
/*     */     public abstract boolean onActivityResult(int paramInt, Intent paramIntent);
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/CallbackManagerImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */