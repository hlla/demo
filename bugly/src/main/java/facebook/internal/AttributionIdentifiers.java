/*     */ package com.facebook.internal;
/*     */ 
/*     */ import android.content.ComponentName;
/*     */ import android.content.ContentResolver;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.content.ServiceConnection;
/*     */ import android.content.pm.PackageManager;
/*     */ import android.database.Cursor;
/*     */ import android.net.Uri;
/*     */ import android.os.IBinder;
/*     */ import android.os.IInterface;
/*     */ import android.os.Looper;
/*     */ import android.os.Parcel;
/*     */ import android.os.RemoteException;
/*     */ import android.support.annotation.Nullable;
/*     */ import android.util.Log;
/*     */ import com.facebook.FacebookException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.concurrent.BlockingQueue;
/*     */ import java.util.concurrent.LinkedBlockingDeque;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
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
/*     */ 
/*     */ public class AttributionIdentifiers
/*     */ {
/*  52 */   private static final String TAG = AttributionIdentifiers.class.getCanonicalName();
/*     */   
/*     */   private static final String ATTRIBUTION_ID_CONTENT_PROVIDER = "com.facebook.katana.provider.AttributionIdProvider";
/*     */   
/*     */   private static final String ATTRIBUTION_ID_CONTENT_PROVIDER_WAKIZASHI = "com.facebook.wakizashi.provider.AttributionIdProvider";
/*     */   
/*     */   private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
/*     */   
/*     */   private static final String ANDROID_ID_COLUMN_NAME = "androidid";
/*     */   
/*     */   private static final String LIMIT_TRACKING_COLUMN_NAME = "limit_tracking";
/*     */   
/*     */   private static final int CONNECTION_RESULT_SUCCESS = 0;
/*     */   private static final long IDENTIFIER_REFRESH_INTERVAL_MILLIS = 3600000L;
/*     */   private String attributionId;
/*     */   private String androidAdvertiserId;
/*     */   private String androidInstallerPackage;
/*     */   private boolean limitTracking;
/*     */   private long fetchTime;
/*     */   private static AttributionIdentifiers recentlyFetchedIdentifiers;
/*     */   
/*     */   private static AttributionIdentifiers getAndroidId(Context context)
/*     */   {
/*  75 */     AttributionIdentifiers identifiers = getAndroidIdViaReflection(context);
/*  76 */     if (identifiers == null) {
/*  77 */       identifiers = getAndroidIdViaService(context);
/*  78 */       if (identifiers == null) {
/*  79 */         identifiers = new AttributionIdentifiers();
/*     */       }
/*     */     }
/*  82 */     return identifiers;
/*     */   }
/*     */   
/*     */   private static AttributionIdentifiers getAndroidIdViaReflection(Context context)
/*     */   {
/*     */     try
/*     */     {
/*  89 */       if (Looper.myLooper() == Looper.getMainLooper()) {
/*  90 */         throw new FacebookException("getAndroidId cannot be called on the main thread.");
/*     */       }
/*  92 */       Method isGooglePlayServicesAvailable = Utility.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", new Class[] { Context.class });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  98 */       if (isGooglePlayServicesAvailable == null) {
/*  99 */         return null;
/*     */       }
/*     */       
/* 102 */       Object connectionResult = Utility.invokeMethodQuietly(null, isGooglePlayServicesAvailable, new Object[] { context });
/*     */       
/* 104 */       if ((!(connectionResult instanceof Integer)) || 
/* 105 */         (((Integer)connectionResult).intValue() != 0)) {
/* 106 */         return null;
/*     */       }
/*     */       
/* 109 */       Method getAdvertisingIdInfo = Utility.getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[] { Context.class });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 114 */       if (getAdvertisingIdInfo == null) {
/* 115 */         return null;
/*     */       }
/* 117 */       Object advertisingInfo = Utility.invokeMethodQuietly(null, getAdvertisingIdInfo, new Object[] { context });
/*     */       
/* 119 */       if (advertisingInfo == null) {
/* 120 */         return null;
/*     */       }
/*     */       
/* 123 */       Method getId = Utility.getMethodQuietly(advertisingInfo.getClass(), "getId", new Class[0]);
/* 124 */       Method isLimitAdTrackingEnabled = Utility.getMethodQuietly(advertisingInfo
/* 125 */         .getClass(), "isLimitAdTrackingEnabled", new Class[0]);
/*     */       
/* 127 */       if ((getId == null) || (isLimitAdTrackingEnabled == null)) {
/* 128 */         return null;
/*     */       }
/*     */       
/* 131 */       AttributionIdentifiers identifiers = new AttributionIdentifiers();
/*     */       
/* 133 */       identifiers.androidAdvertiserId = ((String)Utility.invokeMethodQuietly(advertisingInfo, getId, new Object[0]));
/* 134 */       identifiers.limitTracking = ((Boolean)Utility.invokeMethodQuietly(advertisingInfo, isLimitAdTrackingEnabled, new Object[0])).booleanValue();
/*     */       
/*     */ 
/* 137 */       return identifiers;
/*     */     } catch (Exception e) {
/* 139 */       Utility.logd("android_id", e);
/*     */     }
/* 141 */     return null;
/*     */   }
/*     */   
/*     */   private static AttributionIdentifiers getAndroidIdViaService(Context context) {
/* 145 */     GoogleAdServiceConnection connection = new GoogleAdServiceConnection(null);
/* 146 */     Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
/* 147 */     intent.setPackage("com.google.android.gms");
/* 148 */     if (context.bindService(intent, connection, 1)) {
/*     */       try {
/* 150 */         GoogleAdInfo adInfo = new GoogleAdInfo(connection.getBinder());
/* 151 */         AttributionIdentifiers identifiers = new AttributionIdentifiers();
/* 152 */         identifiers.androidAdvertiserId = adInfo.getAdvertiserId();
/* 153 */         identifiers.limitTracking = adInfo.isTrackingLimited();
/* 154 */         return identifiers;
/*     */       } catch (Exception exception) {
/* 156 */         Utility.logd("android_id", exception);
/*     */       } finally {
/* 158 */         context.unbindService(connection);
/*     */       }
/*     */     }
/* 161 */     return null;
/*     */   }
/*     */   
/*     */   public static AttributionIdentifiers getAttributionIdentifiers(Context context) {
/* 165 */     if (Looper.myLooper() == Looper.getMainLooper())
/*     */     {
/* 167 */       Log.e(TAG, "getAttributionIdentifiers should not be called from the main thread");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 172 */     if ((recentlyFetchedIdentifiers != null) && 
/* 173 */       (System.currentTimeMillis() - recentlyFetchedIdentifiers.fetchTime < 3600000L))
/*     */     {
/* 175 */       return recentlyFetchedIdentifiers;
/*     */     }
/*     */     
/* 178 */     AttributionIdentifiers identifiers = getAndroidId(context);
/* 179 */     Cursor c = null;
/*     */     try {
/* 181 */       String[] projection = { "aid", "androidid", "limit_tracking" };
/*     */       
/*     */ 
/*     */ 
/* 185 */       providerUri = null;
/* 186 */       if (context.getPackageManager().resolveContentProvider("com.facebook.katana.provider.AttributionIdProvider", 0) != null)
/*     */       {
/* 188 */         providerUri = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
/* 189 */       } else if (context.getPackageManager().resolveContentProvider("com.facebook.wakizashi.provider.AttributionIdProvider", 0) != null)
/*     */       {
/* 191 */         providerUri = Uri.parse("content://com.facebook.wakizashi.provider.AttributionIdProvider");
/*     */       }
/* 193 */       String installerPackageName = getInstallerPackageName(context);
/* 194 */       if (installerPackageName != null)
/* 195 */         identifiers.androidInstallerPackage = installerPackageName;
/*     */       AttributionIdentifiers localAttributionIdentifiers1;
/* 197 */       if (providerUri == null) {
/* 198 */         return cacheAndReturnIdentifiers(identifiers);
/*     */       }
/* 200 */       c = context.getContentResolver().query(providerUri, projection, null, null, null);
/* 201 */       if ((c == null) || (!c.moveToFirst())) {
/* 202 */         return cacheAndReturnIdentifiers(identifiers);
/*     */       }
/* 204 */       int attributionColumnIndex = c.getColumnIndex("aid");
/* 205 */       int androidIdColumnIndex = c.getColumnIndex("androidid");
/* 206 */       int limitTrackingColumnIndex = c.getColumnIndex("limit_tracking");
/*     */       
/* 208 */       identifiers.attributionId = c.getString(attributionColumnIndex);
/*     */       
/*     */ 
/*     */ 
/* 212 */       if ((androidIdColumnIndex > 0) && (limitTrackingColumnIndex > 0) && 
/* 213 */         (identifiers.getAndroidAdvertiserId() == null)) {
/* 214 */         identifiers.androidAdvertiserId = c.getString(androidIdColumnIndex);
/*     */         
/* 216 */         identifiers.limitTracking = Boolean.parseBoolean(c.getString(limitTrackingColumnIndex));
/*     */       }
/*     */     } catch (Exception e) { Uri providerUri;
/* 219 */       Log.d(TAG, "Caught unexpected exception in getAttributionId(): " + e.toString());
/* 220 */       return null;
/*     */     } finally {
/* 222 */       if (c != null) {
/* 223 */         c.close();
/*     */       }
/*     */     }
/* 226 */     return cacheAndReturnIdentifiers(identifiers);
/*     */   }
/*     */   
/*     */   private static AttributionIdentifiers cacheAndReturnIdentifiers(AttributionIdentifiers identifiers)
/*     */   {
/* 231 */     identifiers.fetchTime = System.currentTimeMillis();
/* 232 */     recentlyFetchedIdentifiers = identifiers;
/* 233 */     return identifiers;
/*     */   }
/*     */   
/*     */   public String getAttributionId() {
/* 237 */     return this.attributionId;
/*     */   }
/*     */   
/*     */   public String getAndroidAdvertiserId() {
/* 241 */     return this.androidAdvertiserId;
/*     */   }
/*     */   
/*     */   public String getAndroidInstallerPackage() {
/* 245 */     return this.androidInstallerPackage;
/*     */   }
/*     */   
/*     */   public boolean isTrackingLimited() {
/* 249 */     return this.limitTracking;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   private static String getInstallerPackageName(Context context) {
/* 254 */     PackageManager packageManager = context.getPackageManager();
/* 255 */     if (packageManager != null) {
/* 256 */       return packageManager.getInstallerPackageName(context.getPackageName());
/*     */     }
/* 258 */     return null;
/*     */   }
/*     */   
/*     */   private static final class GoogleAdServiceConnection implements ServiceConnection {
/* 262 */     private AtomicBoolean consumed = new AtomicBoolean(false);
/* 263 */     private final BlockingQueue<IBinder> queue = new LinkedBlockingDeque();
/*     */     
/*     */     public void onServiceConnected(ComponentName name, IBinder service)
/*     */     {
/*     */       try {
/* 268 */         this.queue.put(service);
/*     */       }
/*     */       catch (InterruptedException localInterruptedException) {}
/*     */     }
/*     */     
/*     */     public void onServiceDisconnected(ComponentName name) {}
/*     */     
/*     */     public IBinder getBinder()
/*     */       throws InterruptedException
/*     */     {
/* 278 */       if (this.consumed.compareAndSet(true, true)) {
/* 279 */         throw new IllegalStateException("Binder already consumed");
/*     */       }
/* 281 */       return (IBinder)this.queue.take();
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class GoogleAdInfo implements IInterface
/*     */   {
/*     */     private static final int FIRST_TRANSACTION_CODE = 1;
/*     */     private static final int SECOND_TRANSACTION_CODE = 2;
/*     */     private IBinder binder;
/*     */     
/*     */     GoogleAdInfo(IBinder binder) {
/* 292 */       this.binder = binder;
/*     */     }
/*     */     
/*     */     public IBinder asBinder()
/*     */     {
/* 297 */       return this.binder;
/*     */     }
/*     */     
/*     */     public String getAdvertiserId() throws RemoteException {
/* 301 */       Parcel data = Parcel.obtain();
/* 302 */       Parcel reply = Parcel.obtain();
/*     */       try
/*     */       {
/* 305 */         data.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
/*     */         
/* 307 */         this.binder.transact(1, data, reply, 0);
/* 308 */         reply.readException();
/* 309 */         id = reply.readString();
/*     */       } finally { String id;
/* 311 */         reply.recycle();
/* 312 */         data.recycle(); }
/*     */       String id;
/* 314 */       return id;
/*     */     }
/*     */     
/*     */     public boolean isTrackingLimited() throws RemoteException {
/* 318 */       Parcel data = Parcel.obtain();
/* 319 */       Parcel reply = Parcel.obtain();
/*     */       try
/*     */       {
/* 322 */         data.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
/*     */         
/* 324 */         data.writeInt(1);
/* 325 */         this.binder.transact(2, data, reply, 0);
/* 326 */         reply.readException();
/* 327 */         limitAdTracking = 0 != reply.readInt();
/*     */       } finally { boolean limitAdTracking;
/* 329 */         reply.recycle();
/* 330 */         data.recycle(); }
/*     */       boolean limitAdTracking;
/* 332 */       return limitAdTracking;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/AttributionIdentifiers.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */