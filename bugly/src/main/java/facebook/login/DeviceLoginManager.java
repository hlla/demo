/*    */ package com.facebook.login;
/*    */ 
/*    */ import android.net.Uri;
/*    */ import java.util.Collection;
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
/*    */ public class DeviceLoginManager
/*    */   extends LoginManager
/*    */ {
/*    */   private Uri deviceRedirectUri;
/*    */   private static volatile DeviceLoginManager instance;
/*    */   
/*    */   public static DeviceLoginManager getInstance()
/*    */   {
/* 40 */     if (instance == null) {
/* 41 */       synchronized (DeviceLoginManager.class) {
/* 42 */         if (instance == null) {
/* 43 */           instance = new DeviceLoginManager();
/*    */         }
/*    */       }
/*    */     }
/* 47 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setDeviceRedirectUri(Uri uri)
/*    */   {
/* 59 */     this.deviceRedirectUri = uri;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Uri getDeviceRedirectUri()
/*    */   {
/* 71 */     return this.deviceRedirectUri;
/*    */   }
/*    */   
/*    */   protected LoginClient.Request createLoginRequest(Collection<String> permissions)
/*    */   {
/* 76 */     LoginClient.Request request = super.createLoginRequest(permissions);
/* 77 */     Uri redirectUri = getDeviceRedirectUri();
/* 78 */     if (redirectUri != null) {
/* 79 */       request.setDeviceRedirectUriString(redirectUri.toString());
/*    */     }
/* 81 */     return request;
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/login/DeviceLoginManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */