/*     */ package com.facebook.appevents;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.util.Log;
/*     */ import com.facebook.FacebookSdk;
/*     */ import com.facebook.appevents.internal.AppEventUtility;
/*     */ import com.facebook.internal.Utility;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.ObjectStreamClass;
/*     */ import java.util.List;
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
/*     */ class AppEventStore
/*     */ {
/*  40 */   private static final String TAG = AppEventStore.class.getName();
/*     */   
/*     */   private static final String PERSISTED_EVENTS_FILENAME = "AppEventsLogger.persistedevents";
/*     */   
/*     */   public static synchronized void persistEvents(AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState appEvents)
/*     */   {
/*  46 */     AppEventUtility.assertIsNotMainThread();
/*  47 */     PersistedEvents persistedEvents = readAndClearStore();
/*     */     
/*  49 */     if (persistedEvents.containsKey(accessTokenAppIdPair))
/*     */     {
/*     */ 
/*  52 */       persistedEvents.get(accessTokenAppIdPair).addAll(appEvents.getEventsToPersist());
/*     */     } else {
/*  54 */       persistedEvents.addEvents(accessTokenAppIdPair, appEvents.getEventsToPersist());
/*     */     }
/*     */     
/*  57 */     saveEventsToDisk(persistedEvents);
/*     */   }
/*     */   
/*     */   public static synchronized void persistEvents(AppEventCollection eventsToPersist)
/*     */   {
/*  62 */     AppEventUtility.assertIsNotMainThread();
/*  63 */     PersistedEvents persistedEvents = readAndClearStore();
/*  64 */     for (AccessTokenAppIdPair accessTokenAppIdPair : eventsToPersist.keySet()) {
/*  65 */       SessionEventsState sessionEventsState = eventsToPersist.get(accessTokenAppIdPair);
/*     */       
/*  67 */       persistedEvents.addEvents(accessTokenAppIdPair, sessionEventsState
/*     */       
/*  69 */         .getEventsToPersist());
/*     */     }
/*     */     
/*  72 */     saveEventsToDisk(persistedEvents);
/*     */   }
/*     */   
/*     */   public static synchronized PersistedEvents readAndClearStore()
/*     */   {
/*  77 */     AppEventUtility.assertIsNotMainThread();
/*     */     
/*  79 */     MovedClassObjectInputStream ois = null;
/*  80 */     PersistedEvents persistedEvents = null;
/*  81 */     Context context = FacebookSdk.getApplicationContext();
/*     */     try {
/*  83 */       InputStream is = context.openFileInput("AppEventsLogger.persistedevents");
/*  84 */       ois = new MovedClassObjectInputStream(new BufferedInputStream(is));
/*     */       
/*  86 */       persistedEvents = (PersistedEvents)ois.readObject();
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  92 */       Utility.closeQuietly(ois);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       try
/*     */       {
/* 101 */         context.getFileStreamPath("AppEventsLogger.persistedevents").delete();
/*     */       } catch (Exception ex) {
/* 103 */         Log.w(TAG, "Got unexpected exception when removing events file: ", ex);
/*     */       }
/*     */       
/*     */ 
/* 107 */       if (persistedEvents != null) {
/*     */         return persistedEvents;
/*     */       }
/*     */     }
/*     */     catch (FileNotFoundException localFileNotFoundException) {}catch (Exception e)
/*     */     {
/*  90 */       Log.w(TAG, "Got unexpected exception while reading events: ", e);
/*     */     } finally {
/*  92 */       Utility.closeQuietly(ois);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       try
/*     */       {
/* 101 */         context.getFileStreamPath("AppEventsLogger.persistedevents").delete();
/*     */       } catch (Exception ex) {
/* 103 */         Log.w(TAG, "Got unexpected exception when removing events file: ", ex);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 108 */     persistedEvents = new PersistedEvents();
/*     */     
/*     */ 
/* 111 */     return persistedEvents;
/*     */   }
/*     */   
/*     */ 
/*     */   private static void saveEventsToDisk(PersistedEvents eventsToPersist)
/*     */   {
/* 117 */     ObjectOutputStream oos = null;
/* 118 */     Context context = FacebookSdk.getApplicationContext();
/*     */     
/*     */     try
/*     */     {
/* 122 */       oos = new ObjectOutputStream(new BufferedOutputStream(context.openFileOutput("AppEventsLogger.persistedevents", 0)));
/* 123 */       oos.writeObject(eventsToPersist);
/*     */     } catch (Exception e) {
/* 125 */       Log.w(TAG, "Got unexpected exception while persisting events: ", e);
/*     */       try {
/* 127 */         context.getFileStreamPath("AppEventsLogger.persistedevents").delete();
/*     */       }
/*     */       catch (Exception localException1) {}
/*     */     }
/*     */     finally {
/* 132 */       Utility.closeQuietly(oos);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class MovedClassObjectInputStream extends ObjectInputStream
/*     */   {
/*     */     private static final String ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1";
/*     */     private static final String APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV1";
/*     */     
/*     */     public MovedClassObjectInputStream(InputStream in) throws IOException
/*     */     {
/* 143 */       super();
/*     */     }
/*     */     
/*     */     protected ObjectStreamClass readClassDescriptor()
/*     */       throws IOException, ClassNotFoundException
/*     */     {
/* 149 */       ObjectStreamClass resultClassDescriptor = super.readClassDescriptor();
/*     */       
/* 151 */       if (resultClassDescriptor.getName().equals("com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1"))
/*     */       {
/* 153 */         resultClassDescriptor = ObjectStreamClass.lookup(AccessTokenAppIdPair.SerializationProxyV1.class);
/*     */       }
/* 155 */       else if (resultClassDescriptor.getName().equals("com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV1"))
/*     */       {
/* 157 */         resultClassDescriptor = ObjectStreamClass.lookup(AppEvent.SerializationProxyV1.class);
/*     */       }
/*     */       
/*     */ 
/* 161 */       return resultClassDescriptor;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/appevents/AppEventStore.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */