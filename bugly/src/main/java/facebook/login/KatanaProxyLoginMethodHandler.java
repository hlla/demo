/*    */ package com.facebook.login;
/*    */ 
/*    */ import android.content.Intent;
/*    */ import android.os.Parcel;
/*    */ import android.os.Parcelable.Creator;
/*    */ import com.facebook.internal.NativeProtocol;
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
/*    */ class KatanaProxyLoginMethodHandler
/*    */   extends NativeAppLoginMethodHandler
/*    */ {
/*    */   KatanaProxyLoginMethodHandler(LoginClient loginClient)
/*    */   {
/* 33 */     super(loginClient);
/*    */   }
/*    */   
/*    */   String getNameForLogging()
/*    */   {
/* 38 */     return "katana_proxy_auth";
/*    */   }
/*    */   
/*    */   boolean tryAuthorize(LoginClient.Request request)
/*    */   {
/* 43 */     String e2e = LoginClient.getE2E();
/* 44 */     Intent intent = NativeProtocol.createProxyAuthIntent(this.loginClient
/* 45 */       .getActivity(), request
/* 46 */       .getApplicationId(), request
/* 47 */       .getPermissions(), e2e, request
/*    */       
/* 49 */       .isRerequest(), request
/* 50 */       .hasPublishPermission(), request
/* 51 */       .getDefaultAudience(), 
/* 52 */       getClientState(request.getAuthId()));
/*    */     
/* 54 */     addLoggingExtra("e2e", e2e);
/*    */     
/* 56 */     return tryIntent(intent, LoginClient.getLoginRequestCode());
/*    */   }
/*    */   
/*    */   KatanaProxyLoginMethodHandler(Parcel source) {
/* 60 */     super(source);
/*    */   }
/*    */   
/*    */   public int describeContents()
/*    */   {
/* 65 */     return 0;
/*    */   }
/*    */   
/*    */   public void writeToParcel(Parcel dest, int flags)
/*    */   {
/* 70 */     super.writeToParcel(dest, flags);
/*    */   }
/*    */   
/* 73 */   public static final Parcelable.Creator<KatanaProxyLoginMethodHandler> CREATOR = new Parcelable.Creator()
/*    */   {
/*    */ 
/*    */     public KatanaProxyLoginMethodHandler createFromParcel(Parcel source)
/*    */     {
/* 78 */       return new KatanaProxyLoginMethodHandler(source);
/*    */     }
/*    */     
/*    */     public KatanaProxyLoginMethodHandler[] newArray(int size)
/*    */     {
/* 83 */       return new KatanaProxyLoginMethodHandler[size];
/*    */     }
/*    */   };
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/login/KatanaProxyLoginMethodHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */