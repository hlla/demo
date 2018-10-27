/*    */ package com.facebook.internal;
/*    */ 
/*    */ import android.content.BroadcastReceiver;
/*    */ import android.content.Context;
/*    */ import android.content.Intent;
/*    */ import android.content.IntentFilter;
/*    */ import android.os.Bundle;
/*    */ import android.support.v4.content.LocalBroadcastManager;
/*    */ import com.facebook.appevents.AppEventsLogger;
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
/*    */ public class BoltsMeasurementEventListener
/*    */   extends BroadcastReceiver
/*    */ {
/*    */   private static BoltsMeasurementEventListener _instance;
/*    */   private static final String MEASUREMENT_EVENT_NOTIFICATION_NAME = "com.parse.bolts.measurement_event";
/*    */   private static final String MEASUREMENT_EVENT_NAME_KEY = "event_name";
/*    */   private static final String MEASUREMENT_EVENT_ARGS_KEY = "event_args";
/*    */   private static final String BOLTS_MEASUREMENT_EVENT_PREFIX = "bf_";
/*    */   private Context applicationContext;
/*    */   
/*    */   private BoltsMeasurementEventListener(Context context)
/*    */   {
/* 49 */     this.applicationContext = context.getApplicationContext();
/*    */   }
/*    */   
/*    */   private void open()
/*    */   {
/* 54 */     LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(this.applicationContext);
/* 55 */     broadcastManager.registerReceiver(this, new IntentFilter("com.parse.bolts.measurement_event"));
/*    */   }
/*    */   
/*    */ 
/*    */   private void close()
/*    */   {
/* 61 */     LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(this.applicationContext);
/* 62 */     broadcastManager.unregisterReceiver(this);
/*    */   }
/*    */   
/*    */   public static BoltsMeasurementEventListener getInstance(Context context) {
/* 66 */     if (_instance != null) {
/* 67 */       return _instance;
/*    */     }
/* 69 */     _instance = new BoltsMeasurementEventListener(context);
/* 70 */     _instance.open();
/* 71 */     return _instance;
/*    */   }
/*    */   
/*    */   /* Error */
/*    */   protected void finalize()
/*    */     throws Throwable
/*    */   {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: invokespecial 14	com/facebook/internal/BoltsMeasurementEventListener:close	()V
/*    */     //   4: aload_0
/*    */     //   5: invokespecial 15	java/lang/Object:finalize	()V
/*    */     //   8: goto +10 -> 18
/*    */     //   11: astore_1
/*    */     //   12: aload_0
/*    */     //   13: invokespecial 15	java/lang/Object:finalize	()V
/*    */     //   16: aload_1
/*    */     //   17: athrow
/*    */     //   18: return
/*    */     // Line number table:
/*    */     //   Java source line #76	-> byte code offset #0
/*    */     //   Java source line #78	-> byte code offset #4
/*    */     //   Java source line #79	-> byte code offset #8
/*    */     //   Java source line #78	-> byte code offset #11
/*    */     //   Java source line #80	-> byte code offset #18
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	19	0	this	BoltsMeasurementEventListener
/*    */     //   11	6	1	localObject	Object
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   0	4	11	finally
/*    */   }
/*    */   
/*    */   public void onReceive(Context context, Intent intent)
/*    */   {
/* 84 */     AppEventsLogger appEventsLogger = AppEventsLogger.newLogger(context);
/*    */     
/* 86 */     String eventName = "bf_" + intent.getStringExtra("event_name");
/* 87 */     Bundle eventArgs = intent.getBundleExtra("event_args");
/* 88 */     Bundle logData = new Bundle();
/* 89 */     for (String key : eventArgs.keySet())
/*    */     {
/* 91 */       String safeKey = key.replaceAll("[^0-9a-zA-Z _-]", "-").replaceAll("^[ -]*", "").replaceAll("[ -]*$", "");
/* 92 */       logData.putString(safeKey, (String)eventArgs.get(key));
/*    */     }
/* 94 */     appEventsLogger.logEvent(eventName, logData);
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/BoltsMeasurementEventListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */