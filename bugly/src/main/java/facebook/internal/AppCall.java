/*     */ package com.facebook.internal;
/*     */ 
/*     */ import android.content.Intent;
/*     */ import java.util.UUID;
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
/*     */ public class AppCall
/*     */ {
/*     */   private static AppCall currentPendingCall;
/*     */   private UUID callId;
/*     */   private Intent requestIntent;
/*     */   private int requestCode;
/*     */   
/*     */   public static AppCall getCurrentPendingCall()
/*     */   {
/*  36 */     return currentPendingCall;
/*     */   }
/*     */   
/*     */ 
/*     */   public static synchronized AppCall finishPendingCall(UUID callId, int requestCode)
/*     */   {
/*  42 */     AppCall pendingCall = getCurrentPendingCall();
/*  43 */     if ((pendingCall == null) || 
/*  44 */       (!pendingCall.getCallId().equals(callId)) || 
/*  45 */       (pendingCall.getRequestCode() != requestCode)) {
/*  46 */       return null;
/*     */     }
/*     */     
/*  49 */     setCurrentPendingCall(null);
/*     */     
/*  51 */     return pendingCall;
/*     */   }
/*     */   
/*     */   private static synchronized boolean setCurrentPendingCall(AppCall appCall)
/*     */   {
/*  56 */     AppCall oldAppCall = getCurrentPendingCall();
/*  57 */     currentPendingCall = appCall;
/*     */     
/*  59 */     return oldAppCall != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public AppCall(int requestCode)
/*     */   {
/*  72 */     this(requestCode, UUID.randomUUID());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public AppCall(int requestCode, UUID callId)
/*     */   {
/*  82 */     this.callId = callId;
/*  83 */     this.requestCode = requestCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Intent getRequestIntent()
/*     */   {
/*  93 */     return this.requestIntent;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public UUID getCallId()
/*     */   {
/* 102 */     return this.callId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getRequestCode()
/*     */   {
/* 112 */     return this.requestCode;
/*     */   }
/*     */   
/*     */   public void setRequestCode(int requestCode) {
/* 116 */     this.requestCode = requestCode;
/*     */   }
/*     */   
/*     */   public void setRequestIntent(Intent requestIntent) {
/* 120 */     this.requestIntent = requestIntent;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean setPending()
/*     */   {
/* 129 */     return setCurrentPendingCall(this);
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/AppCall.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */