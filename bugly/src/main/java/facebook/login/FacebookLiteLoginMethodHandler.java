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
/*    */ 
/*    */ class FacebookLiteLoginMethodHandler
/*    */   extends NativeAppLoginMethodHandler
/*    */ {
/*    */   FacebookLiteLoginMethodHandler(LoginClient loginClient)
/*    */   {
/* 34 */     super(loginClient);
/*    */   }
/*    */   
/*    */   String getNameForLogging()
/*    */   {
/* 39 */     return "fb_lite_login";
/*    */   }
/*    */   
/*    */   boolean tryAuthorize(LoginClient.Request request)
/*    */   {
/* 44 */     String e2e = LoginClient.getE2E();
/* 45 */     Intent intent = NativeProtocol.createFacebookLiteIntent(this.loginClient
/* 46 */       .getActivity(), request
/* 47 */       .getApplicationId(), request
/* 48 */       .getPermissions(), e2e, request
/*    */       
/* 50 */       .isRerequest(), request
/* 51 */       .hasPublishPermission(), request
/* 52 */       .getDefaultAudience(), 
/* 53 */       getClientState(request.getAuthId()));
/*    */     
/* 55 */     addLoggingExtra("e2e", e2e);
/*    */     
/* 57 */     return tryIntent(intent, LoginClient.getLoginRequestCode());
/*    */   }
/*    */   
/*    */   FacebookLiteLoginMethodHandler(Parcel source) {
/* 61 */     super(source);
/*    */   }
/*    */   
/*    */   public int describeContents()
/*    */   {
/* 66 */     return 0;
/*    */   }
/*    */   
/*    */   public void writeToParcel(Parcel dest, int flags)
/*    */   {
/* 71 */     super.writeToParcel(dest, flags);
/*    */   }
/*    */   
/* 74 */   public static final Parcelable.Creator<FacebookLiteLoginMethodHandler> CREATOR = new Parcelable.Creator()
/*    */   {
/*    */ 
/*    */     public FacebookLiteLoginMethodHandler createFromParcel(Parcel source)
/*    */     {
/* 79 */       return new FacebookLiteLoginMethodHandler(source);
/*    */     }
/*    */     
/*    */     public FacebookLiteLoginMethodHandler[] newArray(int size)
/*    */     {
/* 84 */       return new FacebookLiteLoginMethodHandler[size];
/*    */     }
/*    */   };
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/login/FacebookLiteLoginMethodHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */