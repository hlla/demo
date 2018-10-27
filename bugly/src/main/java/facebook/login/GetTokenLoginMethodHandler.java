/*     */ package com.facebook.login;
/*     */ 
/*     */ import android.os.Bundle;
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable.Creator;
/*     */ import android.text.TextUtils;
/*     */ import com.facebook.AccessToken;
/*     */ import com.facebook.AccessTokenSource;
/*     */ import com.facebook.FacebookException;
/*     */ import com.facebook.internal.PlatformServiceClient.CompletedListener;
/*     */ import com.facebook.internal.Utility;
/*     */ import com.facebook.internal.Utility.GraphMeRequestWithCacheCallback;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
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
/*     */ class GetTokenLoginMethodHandler
/*     */   extends LoginMethodHandler
/*     */ {
/*     */   private GetTokenClient getTokenClient;
/*     */   
/*     */   GetTokenLoginMethodHandler(LoginClient loginClient)
/*     */   {
/*  45 */     super(loginClient);
/*     */   }
/*     */   
/*     */   String getNameForLogging()
/*     */   {
/*  50 */     return "get_token";
/*     */   }
/*     */   
/*     */   void cancel()
/*     */   {
/*  55 */     if (this.getTokenClient != null) {
/*  56 */       this.getTokenClient.cancel();
/*  57 */       this.getTokenClient.setCompletedListener(null);
/*  58 */       this.getTokenClient = null;
/*     */     }
/*     */   }
/*     */   
/*     */   boolean tryAuthorize(final LoginClient.Request request)
/*     */   {
/*  64 */     this.getTokenClient = new GetTokenClient(this.loginClient.getActivity(), request.getApplicationId());
/*  65 */     if (!this.getTokenClient.start()) {
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     this.loginClient.notifyBackgroundProcessingStart();
/*     */     
/*  71 */     PlatformServiceClient.CompletedListener callback = new PlatformServiceClient.CompletedListener()
/*     */     {
/*     */       public void completed(Bundle result) {
/*  74 */         GetTokenLoginMethodHandler.this.getTokenCompleted(request, result);
/*     */       }
/*     */       
/*  77 */     };
/*  78 */     this.getTokenClient.setCompletedListener(callback);
/*  79 */     return true;
/*     */   }
/*     */   
/*     */   void getTokenCompleted(LoginClient.Request request, Bundle result) {
/*  83 */     if (this.getTokenClient != null) {
/*  84 */       this.getTokenClient.setCompletedListener(null);
/*     */     }
/*  86 */     this.getTokenClient = null;
/*     */     
/*  88 */     this.loginClient.notifyBackgroundProcessingStop();
/*     */     
/*  90 */     if (result != null)
/*     */     {
/*  92 */       ArrayList<String> currentPermissions = result.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
/*  93 */       Set<String> permissions = request.getPermissions();
/*  94 */       if ((currentPermissions != null) && ((permissions == null) || 
/*  95 */         (currentPermissions.containsAll(permissions))))
/*     */       {
/*  97 */         complete(request, result);
/*  98 */         return;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 103 */       Set<String> newPermissions = new HashSet();
/* 104 */       for (String permission : permissions) {
/* 105 */         if (!currentPermissions.contains(permission)) {
/* 106 */           newPermissions.add(permission);
/*     */         }
/*     */       }
/* 109 */       if (!newPermissions.isEmpty()) {
/* 110 */         addLoggingExtra("new_permissions", 
/*     */         
/* 112 */           TextUtils.join(",", newPermissions));
/*     */       }
/*     */       
/*     */ 
/* 116 */       request.setPermissions(newPermissions);
/*     */     }
/*     */     
/* 119 */     this.loginClient.tryNextHandler();
/*     */   }
/*     */   
/*     */   void onComplete(LoginClient.Request request, Bundle result) {
/* 123 */     AccessToken token = createAccessTokenFromNativeLogin(result, AccessTokenSource.FACEBOOK_APPLICATION_SERVICE, request
/*     */     
/*     */ 
/* 126 */       .getApplicationId());
/*     */     
/* 128 */     LoginClient.Result outcome = LoginClient.Result.createTokenResult(this.loginClient.getPendingRequest(), token);
/* 129 */     this.loginClient.completeAndValidate(outcome);
/*     */   }
/*     */   
/*     */   void complete(final LoginClient.Request request, final Bundle result)
/*     */   {
/* 134 */     String userId = result.getString("com.facebook.platform.extra.USER_ID");
/*     */     
/* 136 */     if ((userId == null) || (userId.isEmpty())) {
/* 137 */       this.loginClient.notifyBackgroundProcessingStart();
/*     */       
/* 139 */       String accessToken = result.getString("com.facebook.platform.extra.ACCESS_TOKEN");
/* 140 */       Utility.getGraphMeRequestWithCacheAsync(accessToken, new Utility.GraphMeRequestWithCacheCallback()
/*     */       {
/*     */         public void onSuccess(JSONObject userInfo)
/*     */         {
/*     */           try
/*     */           {
/* 146 */             String userId = userInfo.getString("id");
/* 147 */             result.putString("com.facebook.platform.extra.USER_ID", userId);
/* 148 */             GetTokenLoginMethodHandler.this.onComplete(request, result);
/*     */           } catch (JSONException ex) {
/* 150 */             GetTokenLoginMethodHandler.this.loginClient.complete(LoginClient.Result.createErrorResult(GetTokenLoginMethodHandler.this.loginClient
/* 151 */               .getPendingRequest(), "Caught exception", ex
/*     */               
/* 153 */               .getMessage()));
/*     */           }
/*     */         }
/*     */         
/*     */         public void onFailure(FacebookException error)
/*     */         {
/* 159 */           GetTokenLoginMethodHandler.this.loginClient.complete(LoginClient.Result.createErrorResult(GetTokenLoginMethodHandler.this.loginClient
/* 160 */             .getPendingRequest(), "Caught exception", error
/*     */             
/* 162 */             .getMessage()));
/*     */         }
/*     */       });
/*     */     } else {
/* 166 */       onComplete(request, result);
/*     */     }
/*     */   }
/*     */   
/*     */   GetTokenLoginMethodHandler(Parcel source)
/*     */   {
/* 172 */     super(source);
/*     */   }
/*     */   
/*     */   public int describeContents()
/*     */   {
/* 177 */     return 0;
/*     */   }
/*     */   
/*     */   public void writeToParcel(Parcel dest, int flags)
/*     */   {
/* 182 */     super.writeToParcel(dest, flags);
/*     */   }
/*     */   
/* 185 */   public static final Parcelable.Creator<GetTokenLoginMethodHandler> CREATOR = new Parcelable.Creator()
/*     */   {
/*     */ 
/*     */     public GetTokenLoginMethodHandler createFromParcel(Parcel source)
/*     */     {
/* 190 */       return new GetTokenLoginMethodHandler(source);
/*     */     }
/*     */     
/*     */     public GetTokenLoginMethodHandler[] newArray(int size)
/*     */     {
/* 195 */       return new GetTokenLoginMethodHandler[size];
/*     */     }
/*     */   };
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/login/GetTokenLoginMethodHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */