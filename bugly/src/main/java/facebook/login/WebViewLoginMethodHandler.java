/*     */ package com.facebook.login;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.os.Bundle;
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable.Creator;
/*     */ import android.support.v4.app.FragmentActivity;
/*     */ import com.facebook.AccessTokenSource;
/*     */ import com.facebook.FacebookException;
/*     */ import com.facebook.internal.FacebookDialogFragment;
/*     */ import com.facebook.internal.WebDialog;
/*     */ import com.facebook.internal.WebDialog.Builder;
/*     */ import com.facebook.internal.WebDialog.OnCompleteListener;
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
/*     */ class WebViewLoginMethodHandler
/*     */   extends WebLoginMethodHandler
/*     */ {
/*     */   private WebDialog loginDialog;
/*     */   private String e2e;
/*     */   
/*     */   WebViewLoginMethodHandler(LoginClient loginClient)
/*     */   {
/*  41 */     super(loginClient);
/*     */   }
/*     */   
/*     */   String getNameForLogging()
/*     */   {
/*  46 */     return "web_view";
/*     */   }
/*     */   
/*     */   AccessTokenSource getTokenSource()
/*     */   {
/*  51 */     return AccessTokenSource.WEB_VIEW;
/*     */   }
/*     */   
/*     */   boolean needsInternetPermission()
/*     */   {
/*  56 */     return true;
/*     */   }
/*     */   
/*     */   void cancel()
/*     */   {
/*  61 */     if (this.loginDialog != null) {
/*  62 */       this.loginDialog.cancel();
/*  63 */       this.loginDialog = null;
/*     */     }
/*     */   }
/*     */   
/*     */   boolean tryAuthorize(final LoginClient.Request request)
/*     */   {
/*  69 */     Bundle parameters = getParameters(request);
/*     */     
/*  71 */     WebDialog.OnCompleteListener listener = new WebDialog.OnCompleteListener()
/*     */     {
/*     */       public void onComplete(Bundle values, FacebookException error) {
/*  74 */         WebViewLoginMethodHandler.this.onWebDialogComplete(request, values, error);
/*     */       }
/*     */       
/*  77 */     };
/*  78 */     this.e2e = LoginClient.getE2E();
/*  79 */     addLoggingExtra("e2e", this.e2e);
/*     */     
/*  81 */     FragmentActivity fragmentActivity = this.loginClient.getActivity();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  88 */     WebDialog.Builder builder = new AuthDialogBuilder(fragmentActivity, request.getApplicationId(), parameters).setE2E(this.e2e).setIsRerequest(request.isRerequest()).setOnCompleteListener(listener);
/*  89 */     this.loginDialog = builder.build();
/*     */     
/*  91 */     FacebookDialogFragment dialogFragment = new FacebookDialogFragment();
/*  92 */     dialogFragment.setRetainInstance(true);
/*  93 */     dialogFragment.setDialog(this.loginDialog);
/*  94 */     dialogFragment.show(fragmentActivity.getSupportFragmentManager(), "FacebookDialogFragment");
/*     */     
/*     */ 
/*  97 */     return true;
/*     */   }
/*     */   
/*     */   void onWebDialogComplete(LoginClient.Request request, Bundle values, FacebookException error)
/*     */   {
/* 102 */     super.onComplete(request, values, error);
/*     */   }
/*     */   
/*     */   static class AuthDialogBuilder extends WebDialog.Builder {
/*     */     private static final String OAUTH_DIALOG = "oauth";
/*     */     static final String REDIRECT_URI = "fbconnect://success";
/*     */     private String e2e;
/*     */     private boolean isRerequest;
/*     */     
/*     */     public AuthDialogBuilder(Context context, String applicationId, Bundle parameters) {
/* 112 */       super(applicationId, "oauth", parameters);
/*     */     }
/*     */     
/*     */     public AuthDialogBuilder setE2E(String e2e) {
/* 116 */       this.e2e = e2e;
/* 117 */       return this;
/*     */     }
/*     */     
/*     */     public AuthDialogBuilder setIsRerequest(boolean isRerequest) {
/* 121 */       this.isRerequest = isRerequest;
/* 122 */       return this;
/*     */     }
/*     */     
/*     */     public WebDialog build()
/*     */     {
/* 127 */       Bundle parameters = getParameters();
/* 128 */       parameters.putString("redirect_uri", "fbconnect://success");
/* 129 */       parameters.putString("client_id", getApplicationId());
/* 130 */       parameters.putString("e2e", this.e2e);
/* 131 */       parameters.putString("response_type", "token,signed_request");
/*     */       
/*     */ 
/* 134 */       parameters.putString("return_scopes", "true");
/*     */       
/*     */ 
/* 137 */       parameters.putString("auth_type", "rerequest");
/*     */       
/*     */ 
/*     */ 
/* 141 */       return new WebDialog(getContext(), "oauth", parameters, getTheme(), getListener());
/*     */     }
/*     */   }
/*     */   
/*     */   WebViewLoginMethodHandler(Parcel source) {
/* 146 */     super(source);
/* 147 */     this.e2e = source.readString();
/*     */   }
/*     */   
/*     */   public int describeContents()
/*     */   {
/* 152 */     return 0;
/*     */   }
/*     */   
/*     */   public void writeToParcel(Parcel dest, int flags)
/*     */   {
/* 157 */     super.writeToParcel(dest, flags);
/* 158 */     dest.writeString(this.e2e);
/*     */   }
/*     */   
/* 161 */   public static final Parcelable.Creator<WebViewLoginMethodHandler> CREATOR = new Parcelable.Creator()
/*     */   {
/*     */ 
/*     */     public WebViewLoginMethodHandler createFromParcel(Parcel source)
/*     */     {
/* 166 */       return new WebViewLoginMethodHandler(source);
/*     */     }
/*     */     
/*     */     public WebViewLoginMethodHandler[] newArray(int size)
/*     */     {
/* 171 */       return new WebViewLoginMethodHandler[size];
/*     */     }
/*     */   };
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/login/WebViewLoginMethodHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */