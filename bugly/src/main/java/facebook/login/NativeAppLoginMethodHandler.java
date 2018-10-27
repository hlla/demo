/*     */ package com.facebook.login;
/*     */ 
/*     */ import android.content.ActivityNotFoundException;
/*     */ import android.content.Intent;
/*     */ import android.os.Bundle;
/*     */ import android.os.Parcel;
/*     */ import android.support.v4.app.Fragment;
/*     */ import com.facebook.AccessToken;
/*     */ import com.facebook.AccessTokenSource;
/*     */ import com.facebook.FacebookException;
/*     */ import com.facebook.internal.ServerProtocol;
/*     */ import com.facebook.internal.Utility;
/*     */ import java.util.Collection;
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
/*     */ abstract class NativeAppLoginMethodHandler
/*     */   extends LoginMethodHandler
/*     */ {
/*     */   NativeAppLoginMethodHandler(LoginClient loginClient)
/*     */   {
/*  39 */     super(loginClient);
/*     */   }
/*     */   
/*     */   NativeAppLoginMethodHandler(Parcel source) {
/*  43 */     super(source);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   abstract boolean tryAuthorize(LoginClient.Request paramRequest);
/*     */   
/*     */ 
/*     */   boolean onActivityResult(int requestCode, int resultCode, Intent data)
/*     */   {
/*  53 */     LoginClient.Request request = this.loginClient.getPendingRequest();
/*     */     LoginClient.Result outcome;
/*  55 */     LoginClient.Result outcome; if (data == null)
/*     */     {
/*  57 */       outcome = LoginClient.Result.createCancelResult(request, "Operation canceled"); } else { LoginClient.Result outcome;
/*  58 */       if (resultCode == 0) {
/*  59 */         outcome = handleResultCancel(request, data); } else { LoginClient.Result outcome;
/*  60 */         if (resultCode != -1) {
/*  61 */           outcome = LoginClient.Result.createErrorResult(request, "Unexpected resultCode from authorization.", null);
/*     */         }
/*     */         else
/*  64 */           outcome = handleResultOk(request, data);
/*     */       }
/*     */     }
/*  67 */     if (outcome != null) {
/*  68 */       this.loginClient.completeAndValidate(outcome);
/*     */     } else {
/*  70 */       this.loginClient.tryNextHandler();
/*     */     }
/*  72 */     return true;
/*     */   }
/*     */   
/*     */   private LoginClient.Result handleResultOk(LoginClient.Request request, Intent data) {
/*  76 */     Bundle extras = data.getExtras();
/*  77 */     String error = getError(extras);
/*  78 */     String errorCode = extras.getString("error_code");
/*  79 */     String errorMessage = getErrorMessage(extras);
/*     */     
/*  81 */     String e2e = extras.getString("e2e");
/*  82 */     if (!Utility.isNullOrEmpty(e2e)) {
/*  83 */       logWebLoginCompleted(e2e);
/*     */     }
/*     */     
/*  86 */     if ((error == null) && (errorCode == null) && (errorMessage == null))
/*     */       try {
/*  88 */         AccessToken token = createAccessTokenFromWebBundle(request.getPermissions(), extras, AccessTokenSource.FACEBOOK_APPLICATION_WEB, request
/*     */         
/*  90 */           .getApplicationId());
/*  91 */         return LoginClient.Result.createTokenResult(request, token);
/*     */       } catch (FacebookException ex) {
/*  93 */         return LoginClient.Result.createErrorResult(request, null, ex.getMessage());
/*     */       }
/*  95 */     if (ServerProtocol.errorsProxyAuthDisabled.contains(error))
/*  96 */       return null;
/*  97 */     if (ServerProtocol.errorsUserCanceled.contains(error)) {
/*  98 */       return LoginClient.Result.createCancelResult(request, null);
/*     */     }
/* 100 */     return LoginClient.Result.createErrorResult(request, error, errorMessage, errorCode);
/*     */   }
/*     */   
/*     */   private LoginClient.Result handleResultCancel(LoginClient.Request request, Intent data)
/*     */   {
/* 105 */     Bundle extras = data.getExtras();
/* 106 */     String error = getError(extras);
/* 107 */     String errorCode = extras.getString("error_code");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 112 */     if ("CONNECTION_FAILURE".equals(errorCode)) {
/* 113 */       String errorMessage = getErrorMessage(extras);
/*     */       
/* 115 */       return LoginClient.Result.createErrorResult(request, error, errorMessage, errorCode);
/*     */     }
/*     */     
/* 118 */     return LoginClient.Result.createCancelResult(request, error);
/*     */   }
/*     */   
/*     */   private String getError(Bundle extras) {
/* 122 */     String error = extras.getString("error");
/* 123 */     if (error == null) {
/* 124 */       error = extras.getString("error_type");
/*     */     }
/* 126 */     return error;
/*     */   }
/*     */   
/*     */   private String getErrorMessage(Bundle extras) {
/* 130 */     String errorMessage = extras.getString("error_message");
/* 131 */     if (errorMessage == null) {
/* 132 */       errorMessage = extras.getString("error_description");
/*     */     }
/* 134 */     return errorMessage;
/*     */   }
/*     */   
/*     */   protected boolean tryIntent(Intent intent, int requestCode) {
/* 138 */     if (intent == null) {
/* 139 */       return false;
/*     */     }
/*     */     try
/*     */     {
/* 143 */       this.loginClient.getFragment().startActivityForResult(intent, requestCode);
/*     */     }
/*     */     catch (ActivityNotFoundException e)
/*     */     {
/* 147 */       return false;
/*     */     }
/*     */     
/* 150 */     return true;
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/login/NativeAppLoginMethodHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */