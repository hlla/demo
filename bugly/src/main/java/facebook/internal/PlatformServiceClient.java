/*     */ package com.facebook.internal;
/*     */ 
/*     */ import android.content.ComponentName;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.content.ServiceConnection;
/*     */ import android.os.Bundle;
/*     */ import android.os.Handler;
/*     */ import android.os.IBinder;
/*     */ import android.os.Message;
/*     */ import android.os.Messenger;
/*     */ import android.os.RemoteException;
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
/*     */ public abstract class PlatformServiceClient
/*     */   implements ServiceConnection
/*     */ {
/*     */   private final Context context;
/*     */   private final Handler handler;
/*     */   private CompletedListener listener;
/*     */   private boolean running;
/*     */   private Messenger sender;
/*     */   private int requestMessage;
/*     */   private int replyMessage;
/*     */   private final String applicationId;
/*     */   private final int protocolVersion;
/*     */   
/*     */   public PlatformServiceClient(Context context, int requestMessage, int replyMessage, int protocolVersion, String applicationId)
/*     */   {
/*  51 */     Context applicationContext = context.getApplicationContext();
/*     */     
/*  53 */     this.context = (applicationContext != null ? applicationContext : context);
/*  54 */     this.requestMessage = requestMessage;
/*  55 */     this.replyMessage = replyMessage;
/*  56 */     this.applicationId = applicationId;
/*  57 */     this.protocolVersion = protocolVersion;
/*     */     
/*  59 */     this.handler = new Handler()
/*     */     {
/*     */       public void handleMessage(Message message) {
/*  62 */         PlatformServiceClient.this.handleMessage(message);
/*     */       }
/*     */     };
/*     */   }
/*     */   
/*     */   public void setCompletedListener(CompletedListener listener) {
/*  68 */     this.listener = listener;
/*     */   }
/*     */   
/*     */   protected Context getContext() {
/*  72 */     return this.context;
/*     */   }
/*     */   
/*     */   public boolean start() {
/*  76 */     if (this.running) {
/*  77 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  81 */     int availableVersion = NativeProtocol.getLatestAvailableProtocolVersionForService(this.protocolVersion);
/*     */     
/*  83 */     if (availableVersion == -1) {
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     Intent intent = NativeProtocol.createPlatformServiceIntent(this.context);
/*  88 */     if (intent == null) {
/*  89 */       return false;
/*     */     }
/*  91 */     this.running = true;
/*  92 */     this.context.bindService(intent, this, 1);
/*  93 */     return true;
/*     */   }
/*     */   
/*     */   public void cancel()
/*     */   {
/*  98 */     this.running = false;
/*     */   }
/*     */   
/*     */   public void onServiceConnected(ComponentName name, IBinder service) {
/* 102 */     this.sender = new Messenger(service);
/* 103 */     sendMessage();
/*     */   }
/*     */   
/*     */   public void onServiceDisconnected(ComponentName name) {
/* 107 */     this.sender = null;
/*     */     try {
/* 109 */       this.context.unbindService(this);
/*     */     }
/*     */     catch (IllegalArgumentException localIllegalArgumentException) {}
/*     */     
/* 113 */     callback(null);
/*     */   }
/*     */   
/*     */   private void sendMessage() {
/* 117 */     Bundle data = new Bundle();
/* 118 */     data.putString("com.facebook.platform.extra.APPLICATION_ID", this.applicationId);
/*     */     
/* 120 */     populateRequestBundle(data);
/*     */     
/* 122 */     Message request = Message.obtain(null, this.requestMessage);
/* 123 */     request.arg1 = this.protocolVersion;
/* 124 */     request.setData(data);
/* 125 */     request.replyTo = new Messenger(this.handler);
/*     */     try
/*     */     {
/* 128 */       this.sender.send(request);
/*     */     } catch (RemoteException e) {
/* 130 */       callback(null);
/*     */     }
/*     */   }
/*     */   
/*     */   protected abstract void populateRequestBundle(Bundle paramBundle);
/*     */   
/*     */   protected void handleMessage(Message message) {
/* 137 */     if (message.what == this.replyMessage) {
/* 138 */       Bundle extras = message.getData();
/* 139 */       String errorType = extras.getString("com.facebook.platform.status.ERROR_TYPE");
/* 140 */       if (errorType != null) {
/* 141 */         callback(null);
/*     */       } else {
/* 143 */         callback(extras);
/*     */       }
/*     */       try {
/* 146 */         this.context.unbindService(this);
/*     */       }
/*     */       catch (IllegalArgumentException localIllegalArgumentException) {}
/*     */     }
/*     */   }
/*     */   
/*     */   private void callback(Bundle result)
/*     */   {
/* 154 */     if (!this.running) {
/* 155 */       return;
/*     */     }
/* 157 */     this.running = false;
/*     */     
/* 159 */     CompletedListener callback = this.listener;
/* 160 */     if (callback != null) {
/* 161 */       callback.completed(result);
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract interface CompletedListener
/*     */   {
/*     */     public abstract void completed(Bundle paramBundle);
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/PlatformServiceClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */