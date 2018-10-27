/*     */ package com.facebook.devicerequests.internal;
/*     */ 
/*     */ import android.annotation.TargetApi;
/*     */ import android.content.Context;
/*     */ import android.net.nsd.NsdManager;
/*     */ import android.net.nsd.NsdManager.RegistrationListener;
/*     */ import android.net.nsd.NsdServiceInfo;
/*     */ import android.os.Build;
/*     */ import android.os.Build.VERSION;
/*     */ import com.facebook.FacebookSdk;
/*     */ import com.facebook.internal.FetchedAppSettings;
/*     */ import com.facebook.internal.FetchedAppSettingsManager;
/*     */ import com.facebook.internal.SmartLoginOption;
/*     */ import java.util.EnumSet;
/*     */ import java.util.HashMap;
/*     */ import org.json.JSONException;
/*     */ import org.json.JSONObject;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DeviceRequestsHelper
/*     */ {
/*     */   public static final String DEVICE_INFO_PARAM = "device_info";
/*     */   static final String DEVICE_INFO_DEVICE = "device";
/*     */   static final String DEVICE_INFO_MODEL = "model";
/*     */   static final String SDK_HEADER = "fbsdk";
/*     */   static final String SDK_FLAVOR = "android";
/*     */   static final String SERVICE_TYPE = "_fb._tcp.";
/*  56 */   private static HashMap<String, RegistrationListener> deviceRequestsListeners = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getDeviceInfo()
/*     */   {
/*  64 */     JSONObject deviceInfo = new JSONObject();
/*     */     try {
/*  66 */       deviceInfo.put("device", Build.DEVICE);
/*  67 */       deviceInfo.put("model", Build.MODEL);
/*     */     }
/*     */     catch (JSONException localJSONException) {}
/*     */     
/*  71 */     return deviceInfo.toString();
/*     */   }
/*     */   
/*     */   public static boolean startAdvertisementService(String userCode) {
/*  75 */     if (isAvailable()) {
/*  76 */       return startAdvertisementServiceImpl(userCode);
/*     */     }
/*     */     
/*  79 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static boolean isAvailable()
/*     */   {
/*  86 */     if (VERSION.SDK_INT >= 16) {}
/*     */     
/*  88 */     return FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId()).getSmartLoginOptions().contains(SmartLoginOption.Enabled);
/*     */   }
/*     */   
/*     */   public static void cleanUpAdvertisementService(String userCode) {
/*  92 */     cleanUpAdvertisementServiceImpl(userCode);
/*     */   }
/*     */   
/*     */   @TargetApi(16)
/*     */   private static boolean startAdvertisementServiceImpl(final String userCode) {
/*  97 */     if (deviceRequestsListeners.containsKey(userCode)) {
/*  98 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 102 */     String sdkVersion = FacebookSdk.getSdkVersion().replace('.', '|');
/*     */     
/*     */ 
/* 105 */     String nsdServiceName = String.format("%s_%s_%s", new Object[] { "fbsdk", 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 110 */       String.format("%s-%s", new Object[] { "android", sdkVersion }), userCode });
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
/* 121 */     NsdServiceInfo nsdLoginAdvertisementService = new NsdServiceInfo();
/* 122 */     nsdLoginAdvertisementService.setServiceType("_fb._tcp.");
/* 123 */     nsdLoginAdvertisementService.setServiceName(nsdServiceName);
/* 124 */     nsdLoginAdvertisementService.setPort(80);
/*     */     
/*     */ 
/*     */ 
/* 128 */     NsdManager nsdManager = (NsdManager)FacebookSdk.getApplicationContext().getSystemService("servicediscovery");
/*     */     
/* 130 */     RegistrationListener nsdRegistrationListener = new RegistrationListener()
/*     */     {
/*     */ 
/*     */       public void onServiceRegistered(NsdServiceInfo NsdServiceInfo)
/*     */       {
/* 135 */         if (!this.val$nsdServiceName.equals(NsdServiceInfo.getServiceName())) {
/* 136 */           DeviceRequestsHelper.cleanUpAdvertisementService(userCode);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */       public void onServiceUnregistered(NsdServiceInfo serviceInfo) {}
/*     */       
/*     */ 
/*     */       public void onRegistrationFailed(NsdServiceInfo serviceInfo, int errorCode)
/*     */       {
/* 146 */         DeviceRequestsHelper.cleanUpAdvertisementService(userCode);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */       public void onUnregistrationFailed(NsdServiceInfo serviceInfo, int errorCode) {}
/* 153 */     };
/* 154 */     deviceRequestsListeners.put(userCode, nsdRegistrationListener);
/*     */     
/* 156 */     nsdManager.registerService(nsdLoginAdvertisementService, 1, nsdRegistrationListener);
/*     */     
/*     */ 
/*     */ 
/* 160 */     return true;
/*     */   }
/*     */   
/*     */   @TargetApi(16)
/*     */   private static void cleanUpAdvertisementServiceImpl(String userCode)
/*     */   {
/* 166 */     RegistrationListener nsdRegistrationListener = (RegistrationListener)deviceRequestsListeners.get(userCode);
/* 167 */     if (nsdRegistrationListener != null)
/*     */     {
/*     */ 
/* 170 */       NsdManager nsdManager = (NsdManager)FacebookSdk.getApplicationContext().getSystemService("servicediscovery");
/*     */       
/* 172 */       nsdManager.unregisterService(nsdRegistrationListener);
/*     */       
/* 174 */       deviceRequestsListeners.remove(userCode);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/devicerequests/internal/DeviceRequestsHelper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */