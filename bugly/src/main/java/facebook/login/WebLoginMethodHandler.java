/*     */ package com.facebook.login;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.content.SharedPreferences;
/*     */ import android.content.SharedPreferences.Editor;
/*     */ import android.os.Bundle;
/*     */ import android.os.Parcel;
/*     */ import android.text.TextUtils;
/*     */ import android.webkit.CookieSyncManager;
/*     */ import com.facebook.AccessToken;
/*     */ import com.facebook.AccessTokenSource;
/*     */ import com.facebook.FacebookException;
/*     */ import com.facebook.FacebookOperationCanceledException;
/*     */ import com.facebook.FacebookRequestError;
/*     */ import com.facebook.FacebookSdk;
/*     */ import com.facebook.FacebookServiceException;
/*     */ import com.facebook.internal.Utility;
/*     */ import java.util.Locale;
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
/*     */ abstract class WebLoginMethodHandler
/*     */   extends LoginMethodHandler
/*     */ {
/*     */   private static final String WEB_VIEW_AUTH_HANDLER_STORE = "com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY";
/*     */   private static final String WEB_VIEW_AUTH_HANDLER_TOKEN_KEY = "TOKEN";
/*     */   private String e2e;
/*     */   
/*     */   private static final String getRedirectUri()
/*     */   {
/*  49 */     return "fb" + FacebookSdk.getApplicationId() + "://authorize";
/*     */   }
/*     */   
/*     */ 
/*     */   WebLoginMethodHandler(LoginClient loginClient)
/*     */   {
/*  55 */     super(loginClient);
/*     */   }
/*     */   
/*     */   WebLoginMethodHandler(Parcel source) {
/*  59 */     super(source);
/*     */   }
/*     */   
/*     */   abstract AccessTokenSource getTokenSource();
/*     */   
/*     */   protected String getSSODevice() {
/*  65 */     return null;
/*     */   }
/*     */   
/*     */   protected Bundle getParameters(LoginClient.Request request) {
/*  69 */     Bundle parameters = new Bundle();
/*  70 */     if (!Utility.isNullOrEmpty(request.getPermissions())) {
/*  71 */       String scope = TextUtils.join(",", request.getPermissions());
/*  72 */       parameters.putString("scope", scope);
/*  73 */       addLoggingExtra("scope", scope);
/*     */     }
/*     */     
/*  76 */     DefaultAudience audience = request.getDefaultAudience();
/*  77 */     parameters.putString("default_audience", audience
/*  78 */       .getNativeProtocolAudience());
/*  79 */     parameters.putString("state", 
/*  80 */       getClientState(request.getAuthId()));
/*     */     
/*  82 */     AccessToken previousToken = AccessToken.getCurrentAccessToken();
/*  83 */     String previousTokenString = previousToken != null ? previousToken.getToken() : null;
/*  84 */     if ((previousTokenString != null) && 
/*  85 */       (previousTokenString.equals(loadCookieToken()))) {
/*  86 */       parameters.putString("access_token", previousTokenString);
/*     */       
/*     */ 
/*     */ 
/*  90 */       addLoggingExtra("access_token", "1");
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/*  96 */       Utility.clearFacebookCookies(this.loginClient.getActivity());
/*  97 */       addLoggingExtra("access_token", "0");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 102 */     return parameters;
/*     */   }
/*     */   
/*     */   protected Bundle addExtraParameters(Bundle parameters, LoginClient.Request request) {
/* 106 */     parameters.putString("redirect_uri", getRedirectUri());
/* 107 */     parameters.putString("client_id", request.getApplicationId());
/* 108 */     parameters.putString("e2e", LoginClient.getE2E());
/* 109 */     parameters.putString("response_type", "token,signed_request");
/*     */     
/*     */ 
/* 112 */     parameters.putString("return_scopes", "true");
/*     */     
/*     */ 
/* 115 */     parameters.putString("auth_type", "rerequest");
/*     */     
/*     */ 
/* 118 */     if (getSSODevice() != null) {
/* 119 */       parameters.putString("sso", getSSODevice());
/*     */     }
/*     */     
/* 122 */     return parameters;
/*     */   }
/*     */   
/*     */   protected void onComplete(LoginClient.Request request, Bundle values, FacebookException error)
/*     */   {
/* 127 */     this.e2e = null;
/* 128 */     LoginClient.Result outcome; if (values != null)
/*     */     {
/* 130 */       if (values.containsKey("e2e")) {
/* 131 */         this.e2e = values.getString("e2e");
/*     */       }
/*     */       LoginClient.Result outcome;
/*     */       try {
/* 135 */         AccessToken token = createAccessTokenFromWebBundle(request
/* 136 */           .getPermissions(), values, 
/*     */           
/* 138 */           getTokenSource(), request
/* 139 */           .getApplicationId());
/* 140 */         LoginClient.Result outcome = LoginClient.Result.createTokenResult(this.loginClient
/* 141 */           .getPendingRequest(), token);
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 148 */         CookieSyncManager syncManager = CookieSyncManager.createInstance(this.loginClient.getActivity());
/* 149 */         syncManager.sync();
/* 150 */         saveCookieToken(token.getToken());
/*     */       } catch (FacebookException ex) {
/* 152 */         outcome = LoginClient.Result.createErrorResult(this.loginClient
/* 153 */           .getPendingRequest(), null, ex
/*     */           
/* 155 */           .getMessage());
/*     */       }
/*     */     } else { LoginClient.Result outcome;
/* 158 */       if ((error instanceof FacebookOperationCanceledException)) {
/* 159 */         outcome = LoginClient.Result.createCancelResult(this.loginClient.getPendingRequest(), "User canceled log in.");
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 164 */         this.e2e = null;
/*     */         
/* 166 */         String errorCode = null;
/* 167 */         String errorMessage = error.getMessage();
/* 168 */         if ((error instanceof FacebookServiceException))
/*     */         {
/* 170 */           FacebookRequestError requestError = ((FacebookServiceException)error).getRequestError();
/* 171 */           errorCode = String.format(Locale.ROOT, "%d", new Object[] { Integer.valueOf(requestError.getErrorCode()) });
/* 172 */           errorMessage = requestError.toString();
/*     */         }
/* 174 */         outcome = LoginClient.Result.createErrorResult(this.loginClient.getPendingRequest(), null, errorMessage, errorCode);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 179 */     if (!Utility.isNullOrEmpty(this.e2e)) {
/* 180 */       logWebLoginCompleted(this.e2e);
/*     */     }
/*     */     
/* 183 */     this.loginClient.completeAndValidate(outcome);
/*     */   }
/*     */   
/*     */   private String loadCookieToken() {
/* 187 */     Context context = this.loginClient.getActivity();
/* 188 */     SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0);
/*     */     
/*     */ 
/* 191 */     return sharedPreferences.getString("TOKEN", "");
/*     */   }
/*     */   
/*     */   private void saveCookieToken(String token) {
/* 195 */     Context context = this.loginClient.getActivity();
/* 196 */     context.getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0)
/*     */     
/*     */ 
/* 199 */       .edit()
/* 200 */       .putString("TOKEN", token)
/* 201 */       .apply();
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/login/WebLoginMethodHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */