/*     */ package com.facebook.login;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.content.pm.PackageManager;
/*     */ import android.content.pm.ResolveInfo;
/*     */ import android.content.pm.ServiceInfo;
/*     */ import android.net.Uri;
/*     */ import android.os.Bundle;
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable.Creator;
/*     */ import android.support.v4.app.Fragment;
/*     */ import com.facebook.AccessTokenSource;
/*     */ import com.facebook.CustomTabMainActivity;
/*     */ import com.facebook.FacebookException;
/*     */ import com.facebook.FacebookOperationCanceledException;
/*     */ import com.facebook.FacebookRequestError;
/*     */ import com.facebook.FacebookSdk;
/*     */ import com.facebook.FacebookServiceException;
/*     */ import com.facebook.internal.FetchedAppSettings;
/*     */ import com.facebook.internal.FetchedAppSettingsManager;
/*     */ import com.facebook.internal.Utility;
/*     */ import com.facebook.internal.Validate;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
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
/*     */ 
/*     */ 
/*     */ public class CustomTabLoginMethodHandler
/*     */   extends WebLoginMethodHandler
/*     */ {
/*     */   private static final int CUSTOM_TAB_REQUEST_CODE = 1;
/*     */   private static final int CHALLENGE_LENGTH = 20;
/*     */   private static final int API_EC_DIALOG_CANCEL = 4201;
/*     */   private static final String CUSTOM_TABS_SERVICE_ACTION = "android.support.customtabs.action.CustomTabsService";
/*  60 */   private static final String[] CHROME_PACKAGES = { "com.android.chrome", "com.chrome.beta", "com.chrome.dev" };
/*     */   
/*     */ 
/*     */   private String currentPackage;
/*     */   
/*     */   private String expectedChallenge;
/*     */   
/*     */ 
/*     */   CustomTabLoginMethodHandler(LoginClient loginClient)
/*     */   {
/*  70 */     super(loginClient);
/*  71 */     this.expectedChallenge = Utility.generateRandomString(20);
/*     */   }
/*     */   
/*     */   String getNameForLogging()
/*     */   {
/*  76 */     return "custom_tab";
/*     */   }
/*     */   
/*     */   AccessTokenSource getTokenSource()
/*     */   {
/*  81 */     return AccessTokenSource.CHROME_CUSTOM_TAB;
/*     */   }
/*     */   
/*     */   protected String getSSODevice()
/*     */   {
/*  86 */     return "chrome_custom_tab";
/*     */   }
/*     */   
/*     */   boolean tryAuthorize(LoginClient.Request request)
/*     */   {
/*  91 */     if (!isCustomTabsAllowed()) {
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     Bundle parameters = getParameters(request);
/*  96 */     parameters = addExtraParameters(parameters, request);
/*  97 */     Activity activity = this.loginClient.getActivity();
/*     */     
/*  99 */     Intent intent = new Intent(activity, CustomTabMainActivity.class);
/* 100 */     intent.putExtra(CustomTabMainActivity.EXTRA_PARAMS, parameters);
/* 101 */     intent.putExtra(CustomTabMainActivity.EXTRA_CHROME_PACKAGE, getChromePackage());
/* 102 */     this.loginClient.getFragment().startActivityForResult(intent, 1);
/*     */     
/* 104 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean isCustomTabsAllowed()
/*     */   {
/* 110 */     return (isCustomTabsEnabled()) && (getChromePackage() != null) && (Validate.hasCustomTabRedirectActivity(FacebookSdk.getApplicationContext()));
/*     */   }
/*     */   
/*     */   private boolean isCustomTabsEnabled() {
/* 114 */     String appId = Utility.getMetadataApplicationId(this.loginClient.getActivity());
/* 115 */     FetchedAppSettings settings = FetchedAppSettingsManager.getAppSettingsWithoutQuery(appId);
/* 116 */     return (settings != null) && (settings.getCustomTabsEnabled());
/*     */   }
/*     */   
/*     */   private String getChromePackage() {
/* 120 */     if (this.currentPackage != null) {
/* 121 */       return this.currentPackage;
/*     */     }
/* 123 */     Context context = this.loginClient.getActivity();
/* 124 */     Intent serviceIntent = new Intent("android.support.customtabs.action.CustomTabsService");
/*     */     
/* 126 */     List<ResolveInfo> resolveInfos = context.getPackageManager().queryIntentServices(serviceIntent, 0);
/* 127 */     Set<String> chromePackages; if (resolveInfos != null) {
/* 128 */       chromePackages = new HashSet(Arrays.asList(CHROME_PACKAGES));
/* 129 */       for (ResolveInfo resolveInfo : resolveInfos) {
/* 130 */         ServiceInfo serviceInfo = resolveInfo.serviceInfo;
/* 131 */         if ((serviceInfo != null) && (chromePackages.contains(serviceInfo.packageName))) {
/* 132 */           this.currentPackage = serviceInfo.packageName;
/* 133 */           return this.currentPackage;
/*     */         }
/*     */       }
/*     */     }
/* 137 */     return null;
/*     */   }
/*     */   
/*     */   boolean onActivityResult(int requestCode, int resultCode, Intent data)
/*     */   {
/* 142 */     if (requestCode != 1) {
/* 143 */       return super.onActivityResult(requestCode, resultCode, data);
/*     */     }
/* 145 */     LoginClient.Request request = this.loginClient.getPendingRequest();
/* 146 */     if (resultCode == -1) {
/* 147 */       onCustomTabComplete(data.getStringExtra(CustomTabMainActivity.EXTRA_URL), request);
/* 148 */       return true;
/*     */     }
/* 150 */     super.onComplete(request, null, new FacebookOperationCanceledException());
/* 151 */     return false;
/*     */   }
/*     */   
/*     */   private void onCustomTabComplete(String url, LoginClient.Request request) {
/* 155 */     if ((url != null) && (url.startsWith(CustomTabMainActivity.getRedirectUrl()))) {
/* 156 */       Uri uri = Uri.parse(url);
/* 157 */       Bundle values = Utility.parseUrlQueryString(uri.getQuery());
/* 158 */       values.putAll(Utility.parseUrlQueryString(uri.getFragment()));
/*     */       
/* 160 */       if (!validateChallengeParam(values)) {
/* 161 */         super.onComplete(request, null, new FacebookException("Invalid state parameter"));
/* 162 */         return;
/*     */       }
/*     */       
/* 165 */       String error = values.getString("error");
/* 166 */       if (error == null) {
/* 167 */         error = values.getString("error_type");
/*     */       }
/*     */       
/* 170 */       String errorMessage = values.getString("error_msg");
/* 171 */       if (errorMessage == null) {
/* 172 */         errorMessage = values.getString("error_message");
/*     */       }
/* 174 */       if (errorMessage == null) {
/* 175 */         errorMessage = values.getString("error_description");
/*     */       }
/* 177 */       String errorCodeString = values.getString("error_code");
/* 178 */       int errorCode = -1;
/* 179 */       if (!Utility.isNullOrEmpty(errorCodeString)) {
/*     */         try {
/* 181 */           errorCode = Integer.parseInt(errorCodeString);
/*     */         } catch (NumberFormatException ex) {
/* 183 */           errorCode = -1;
/*     */         }
/*     */       }
/*     */       
/* 187 */       if ((Utility.isNullOrEmpty(error)) && (Utility.isNullOrEmpty(errorMessage)) && (errorCode == -1))
/*     */       {
/* 189 */         super.onComplete(request, values, null);
/* 190 */       } else if ((error != null) && ((error.equals("access_denied")) || 
/* 191 */         (error.equals("OAuthAccessDeniedException")))) {
/* 192 */         super.onComplete(request, null, new FacebookOperationCanceledException());
/* 193 */       } else if (errorCode == 4201) {
/* 194 */         super.onComplete(request, null, new FacebookOperationCanceledException());
/*     */       } else {
/* 196 */         FacebookRequestError requestError = new FacebookRequestError(errorCode, error, errorMessage);
/*     */         
/* 198 */         super.onComplete(request, null, new FacebookServiceException(requestError, errorMessage));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void putChallengeParam(JSONObject param)
/*     */     throws JSONException
/*     */   {
/* 208 */     param.put("7_challenge", this.expectedChallenge);
/*     */   }
/*     */   
/*     */   private boolean validateChallengeParam(Bundle values) {
/*     */     try {
/* 213 */       String stateString = values.getString("state");
/* 214 */       if (stateString == null) {
/* 215 */         return false;
/*     */       }
/* 217 */       JSONObject state = new JSONObject(stateString);
/* 218 */       String challenge = state.getString("7_challenge");
/* 219 */       return challenge.equals(this.expectedChallenge);
/*     */     } catch (JSONException e) {}
/* 221 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public int describeContents()
/*     */   {
/* 227 */     return 0;
/*     */   }
/*     */   
/*     */   CustomTabLoginMethodHandler(Parcel source) {
/* 231 */     super(source);
/* 232 */     this.expectedChallenge = source.readString();
/*     */   }
/*     */   
/*     */   public void writeToParcel(Parcel dest, int flags)
/*     */   {
/* 237 */     super.writeToParcel(dest, flags);
/* 238 */     dest.writeString(this.expectedChallenge);
/*     */   }
/*     */   
/* 241 */   public static final Parcelable.Creator<CustomTabLoginMethodHandler> CREATOR = new Parcelable.Creator()
/*     */   {
/*     */ 
/*     */     public CustomTabLoginMethodHandler createFromParcel(Parcel source)
/*     */     {
/* 246 */       return new CustomTabLoginMethodHandler(source);
/*     */     }
/*     */     
/*     */     public CustomTabLoginMethodHandler[] newArray(int size)
/*     */     {
/* 251 */       return new CustomTabLoginMethodHandler[size];
/*     */     }
/*     */   };
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/login/CustomTabLoginMethodHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */