/*     */ package com.facebook.login;
/*     */ 
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable.Creator;
/*     */ import android.support.v4.app.FragmentActivity;
/*     */ import com.facebook.AccessToken;
/*     */ import com.facebook.AccessTokenSource;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.concurrent.ScheduledThreadPoolExecutor;
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
/*     */ class DeviceAuthMethodHandler
/*     */   extends LoginMethodHandler
/*     */ {
/*     */   private static ScheduledThreadPoolExecutor backgroundExecutor;
/*     */   
/*     */   DeviceAuthMethodHandler(LoginClient loginClient)
/*     */   {
/*  37 */     super(loginClient);
/*     */   }
/*     */   
/*     */   boolean tryAuthorize(LoginClient.Request request)
/*     */   {
/*  42 */     showDialog(request);
/*  43 */     return true;
/*     */   }
/*     */   
/*     */   private void showDialog(LoginClient.Request request) {
/*  47 */     DeviceAuthDialog dialog = new DeviceAuthDialog();
/*  48 */     dialog.show(this.loginClient
/*  49 */       .getActivity().getSupportFragmentManager(), "login_with_facebook");
/*     */     
/*  51 */     dialog.startLogin(request);
/*     */   }
/*     */   
/*     */   public void onCancel() {
/*  55 */     LoginClient.Result outcome = LoginClient.Result.createCancelResult(this.loginClient
/*  56 */       .getPendingRequest(), "User canceled log in.");
/*     */     
/*  58 */     this.loginClient.completeAndValidate(outcome);
/*     */   }
/*     */   
/*     */   public void onError(Exception ex) {
/*  62 */     LoginClient.Result outcome = LoginClient.Result.createErrorResult(this.loginClient
/*  63 */       .getPendingRequest(), null, ex
/*     */       
/*  65 */       .getMessage());
/*  66 */     this.loginClient.completeAndValidate(outcome);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onSuccess(String accessToken, String applicationId, String userId, Collection<String> permissions, Collection<String> declinedPermissions, AccessTokenSource accessTokenSource, Date expirationTime, Date lastRefreshTime)
/*     */   {
/*  78 */     AccessToken token = new AccessToken(accessToken, applicationId, userId, permissions, declinedPermissions, accessTokenSource, expirationTime, lastRefreshTime);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  88 */     LoginClient.Result outcome = LoginClient.Result.createTokenResult(this.loginClient
/*  89 */       .getPendingRequest(), token);
/*     */     
/*  91 */     this.loginClient.completeAndValidate(outcome);
/*     */   }
/*     */   
/*     */   public static synchronized ScheduledThreadPoolExecutor getBackgroundExecutor() {
/*  95 */     if (backgroundExecutor == null) {
/*  96 */       backgroundExecutor = new ScheduledThreadPoolExecutor(1);
/*     */     }
/*     */     
/*  99 */     return backgroundExecutor;
/*     */   }
/*     */   
/*     */   protected DeviceAuthMethodHandler(Parcel parcel) {
/* 103 */     super(parcel);
/*     */   }
/*     */   
/*     */   String getNameForLogging()
/*     */   {
/* 108 */     return "device_auth";
/*     */   }
/*     */   
/*     */   public int describeContents()
/*     */   {
/* 113 */     return 0;
/*     */   }
/*     */   
/*     */   public void writeToParcel(Parcel dest, int flags)
/*     */   {
/* 118 */     super.writeToParcel(dest, flags);
/*     */   }
/*     */   
/* 121 */   public static final Parcelable.Creator<DeviceAuthMethodHandler> CREATOR = new Parcelable.Creator()
/*     */   {
/*     */ 
/*     */     public DeviceAuthMethodHandler createFromParcel(Parcel source)
/*     */     {
/* 126 */       return new DeviceAuthMethodHandler(source);
/*     */     }
/*     */     
/*     */     public DeviceAuthMethodHandler[] newArray(int size)
/*     */     {
/* 131 */       return new DeviceAuthMethodHandler[size];
/*     */     }
/*     */   };
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/login/DeviceAuthMethodHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */