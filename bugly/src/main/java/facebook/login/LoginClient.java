/*     */ package com.facebook.login;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.content.Intent;
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
/*     */ import android.os.Parcelable.Creator;
/*     */ import android.support.v4.app.Fragment;
/*     */ import android.support.v4.app.FragmentActivity;
/*     */ import android.text.TextUtils;
/*     */ import com.facebook.AccessToken;
/*     */ import com.facebook.FacebookException;
/*     */ import com.facebook.R.string;
/*     */ import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
/*     */ import com.facebook.internal.Utility;
/*     */ import com.facebook.internal.Validate;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ class LoginClient
/*     */   implements Parcelable
/*     */ {
/*     */   LoginMethodHandler[] handlersToTry;
/*  53 */   int currentHandler = -1;
/*     */   
/*     */ 
/*     */   Fragment fragment;
/*     */   
/*     */   OnCompletedListener onCompletedListener;
/*     */   
/*     */   BackgroundProcessingListener backgroundProcessingListener;
/*     */   
/*     */   boolean checkedInternetPermission;
/*     */   
/*     */   Request pendingRequest;
/*     */   
/*     */   Map<String, String> loggingExtras;
/*     */   
/*     */   private LoginLogger loginLogger;
/*     */   
/*     */ 
/*     */   public LoginClient(Fragment fragment)
/*     */   {
/*  73 */     this.fragment = fragment;
/*     */   }
/*     */   
/*     */   public Fragment getFragment() {
/*  77 */     return this.fragment;
/*     */   }
/*     */   
/*     */   void setFragment(Fragment fragment) {
/*  81 */     if (this.fragment != null) {
/*  82 */       throw new FacebookException("Can't set fragment once it is already set.");
/*     */     }
/*  84 */     this.fragment = fragment;
/*     */   }
/*     */   
/*     */   FragmentActivity getActivity() {
/*  88 */     return this.fragment.getActivity();
/*     */   }
/*     */   
/*     */   public Request getPendingRequest()
/*     */   {
/*  93 */     return this.pendingRequest;
/*     */   }
/*     */   
/*     */   public static int getLoginRequestCode() {
/*  97 */     return CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
/*     */   }
/*     */   
/*     */   void startOrContinueAuth(Request request) {
/* 101 */     if (!getInProgress()) {
/* 102 */       authorize(request);
/*     */     }
/*     */   }
/*     */   
/*     */   void authorize(Request request) {
/* 107 */     if (request == null) {
/* 108 */       return;
/*     */     }
/*     */     
/* 111 */     if (this.pendingRequest != null) {
/* 112 */       throw new FacebookException("Attempted to authorize while a request is pending.");
/*     */     }
/*     */     
/* 115 */     if ((AccessToken.getCurrentAccessToken() != null) && (!checkInternetPermission()))
/*     */     {
/* 117 */       return;
/*     */     }
/* 119 */     this.pendingRequest = request;
/* 120 */     this.handlersToTry = getHandlersToTry(request);
/* 121 */     tryNextHandler();
/*     */   }
/*     */   
/*     */   boolean getInProgress() {
/* 125 */     return (this.pendingRequest != null) && (this.currentHandler >= 0);
/*     */   }
/*     */   
/*     */   void cancelCurrentHandler() {
/* 129 */     if (this.currentHandler >= 0) {
/* 130 */       getCurrentHandler().cancel();
/*     */     }
/*     */   }
/*     */   
/*     */   LoginMethodHandler getCurrentHandler() {
/* 135 */     if (this.currentHandler >= 0) {
/* 136 */       return this.handlersToTry[this.currentHandler];
/*     */     }
/* 138 */     return null;
/*     */   }
/*     */   
/*     */   public boolean onActivityResult(int requestCode, int resultCode, Intent data)
/*     */   {
/* 143 */     if (this.pendingRequest != null)
/*     */     {
/* 145 */       return getCurrentHandler().onActivityResult(requestCode, resultCode, data);
/*     */     }
/* 147 */     return false;
/*     */   }
/*     */   
/*     */   protected LoginMethodHandler[] getHandlersToTry(Request request) {
/* 151 */     ArrayList<LoginMethodHandler> handlers = new ArrayList();
/*     */     
/* 153 */     LoginBehavior behavior = request.getLoginBehavior();
/*     */     
/* 155 */     if (behavior.allowsGetTokenAuth()) {
/* 156 */       handlers.add(new GetTokenLoginMethodHandler(this));
/*     */     }
/*     */     
/* 159 */     if (behavior.allowsKatanaAuth()) {
/* 160 */       handlers.add(new KatanaProxyLoginMethodHandler(this));
/*     */     }
/*     */     
/* 163 */     if (behavior.allowsFacebookLiteAuth()) {
/* 164 */       handlers.add(new FacebookLiteLoginMethodHandler(this));
/*     */     }
/*     */     
/* 167 */     if (behavior.allowsCustomTabAuth()) {
/* 168 */       handlers.add(new CustomTabLoginMethodHandler(this));
/*     */     }
/*     */     
/* 171 */     if (behavior.allowsWebViewAuth()) {
/* 172 */       handlers.add(new WebViewLoginMethodHandler(this));
/*     */     }
/*     */     
/* 175 */     if (behavior.allowsDeviceAuth()) {
/* 176 */       handlers.add(new DeviceAuthMethodHandler(this));
/*     */     }
/*     */     
/* 179 */     LoginMethodHandler[] result = new LoginMethodHandler[handlers.size()];
/* 180 */     handlers.toArray(result);
/* 181 */     return result;
/*     */   }
/*     */   
/*     */   boolean checkInternetPermission() {
/* 185 */     if (this.checkedInternetPermission) {
/* 186 */       return true;
/*     */     }
/*     */     
/* 189 */     int permissionCheck = checkPermission("android.permission.INTERNET");
/* 190 */     if (permissionCheck != 0) {
/* 191 */       Activity activity = getActivity();
/* 192 */       String errorType = activity.getString(R.string.com_facebook_internet_permission_error_title);
/* 193 */       String errorDescription = activity.getString(R.string.com_facebook_internet_permission_error_message);
/* 194 */       complete(Result.createErrorResult(this.pendingRequest, errorType, errorDescription));
/*     */       
/* 196 */       return false;
/*     */     }
/*     */     
/* 199 */     this.checkedInternetPermission = true;
/* 200 */     return true;
/*     */   }
/*     */   
/*     */   void tryNextHandler() {
/* 204 */     if (this.currentHandler >= 0) {
/* 205 */       logAuthorizationMethodComplete(
/* 206 */         getCurrentHandler().getNameForLogging(), "skipped", null, null, 
/*     */         
/*     */ 
/*     */ 
/* 210 */         getCurrentHandler().methodLoggingExtras);
/*     */     }
/*     */     
/* 213 */     while ((this.handlersToTry != null) && (this.currentHandler < this.handlersToTry.length - 1)) {
/* 214 */       this.currentHandler += 1;
/*     */       
/* 216 */       boolean started = tryCurrentHandler();
/*     */       
/* 218 */       if (started) {
/* 219 */         return;
/*     */       }
/*     */     }
/*     */     
/* 223 */     if (this.pendingRequest != null)
/*     */     {
/* 225 */       completeWithFailure();
/*     */     }
/*     */   }
/*     */   
/*     */   private void completeWithFailure() {
/* 230 */     complete(Result.createErrorResult(this.pendingRequest, "Login attempt failed.", null));
/*     */   }
/*     */   
/*     */   private void addLoggingExtra(String key, String value, boolean accumulate) {
/* 234 */     if (this.loggingExtras == null) {
/* 235 */       this.loggingExtras = new HashMap();
/*     */     }
/* 237 */     if ((this.loggingExtras.containsKey(key)) && (accumulate)) {
/* 238 */       value = (String)this.loggingExtras.get(key) + "," + value;
/*     */     }
/* 240 */     this.loggingExtras.put(key, value);
/*     */   }
/*     */   
/*     */   boolean tryCurrentHandler() {
/* 244 */     LoginMethodHandler handler = getCurrentHandler();
/* 245 */     if ((handler.needsInternetPermission()) && (!checkInternetPermission())) {
/* 246 */       addLoggingExtra("no_internet_permission", "1", false);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 251 */       return false;
/*     */     }
/*     */     
/* 254 */     boolean tried = handler.tryAuthorize(this.pendingRequest);
/* 255 */     if (tried) {
/* 256 */       getLogger().logAuthorizationMethodStart(this.pendingRequest.getAuthId(), handler
/* 257 */         .getNameForLogging());
/*     */     }
/*     */     else
/*     */     {
/* 261 */       getLogger().logAuthorizationMethodNotTried(this.pendingRequest.getAuthId(), handler
/* 262 */         .getNameForLogging());
/* 263 */       addLoggingExtra("not_tried", handler
/*     */       
/* 265 */         .getNameForLogging(), true);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 270 */     return tried;
/*     */   }
/*     */   
/*     */   void completeAndValidate(Result outcome)
/*     */   {
/* 275 */     if ((outcome.token != null) && (AccessToken.getCurrentAccessToken() != null)) {
/* 276 */       validateSameFbidAndFinish(outcome);
/*     */     }
/*     */     else {
/* 279 */       complete(outcome);
/*     */     }
/*     */   }
/*     */   
/*     */   void complete(Result outcome) {
/* 284 */     LoginMethodHandler handler = getCurrentHandler();
/*     */     
/*     */ 
/*     */ 
/* 288 */     if (handler != null) {
/* 289 */       logAuthorizationMethodComplete(handler.getNameForLogging(), outcome, handler.methodLoggingExtras);
/*     */     }
/*     */     
/*     */ 
/* 293 */     if (this.loggingExtras != null)
/*     */     {
/* 295 */       outcome.loggingExtras = this.loggingExtras;
/*     */     }
/*     */     
/* 298 */     this.handlersToTry = null;
/* 299 */     this.currentHandler = -1;
/* 300 */     this.pendingRequest = null;
/* 301 */     this.loggingExtras = null;
/*     */     
/* 303 */     notifyOnCompleteListener(outcome);
/*     */   }
/*     */   
/*     */   OnCompletedListener getOnCompletedListener() {
/* 307 */     return this.onCompletedListener;
/*     */   }
/*     */   
/*     */   void setOnCompletedListener(OnCompletedListener onCompletedListener) {
/* 311 */     this.onCompletedListener = onCompletedListener;
/*     */   }
/*     */   
/*     */   BackgroundProcessingListener getBackgroundProcessingListener() {
/* 315 */     return this.backgroundProcessingListener;
/*     */   }
/*     */   
/*     */ 
/*     */   void setBackgroundProcessingListener(BackgroundProcessingListener backgroundProcessingListener)
/*     */   {
/* 321 */     this.backgroundProcessingListener = backgroundProcessingListener;
/*     */   }
/*     */   
/*     */   int checkPermission(String permission) {
/* 325 */     return getActivity().checkCallingOrSelfPermission(permission);
/*     */   }
/*     */   
/*     */   void validateSameFbidAndFinish(Result pendingResult) {
/* 329 */     if (pendingResult.token == null) {
/* 330 */       throw new FacebookException("Can't validate without a token");
/*     */     }
/*     */     
/* 333 */     AccessToken previousToken = AccessToken.getCurrentAccessToken();
/* 334 */     AccessToken newToken = pendingResult.token;
/*     */     try {
/*     */       Result result;
/*     */       Result result;
/* 338 */       if ((previousToken != null) && (newToken != null) && 
/* 339 */         (previousToken.getUserId().equals(newToken.getUserId()))) {
/* 340 */         result = Result.createTokenResult(this.pendingRequest, pendingResult.token);
/*     */       }
/*     */       else {
/* 343 */         result = Result.createErrorResult(this.pendingRequest, "User logged in as different Facebook user.", null);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 348 */       complete(result);
/*     */     } catch (Exception ex) {
/* 350 */       complete(Result.createErrorResult(this.pendingRequest, "Caught exception", ex
/*     */       
/*     */ 
/* 353 */         .getMessage()));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static abstract interface OnCompletedListener
/*     */   {
/*     */     public abstract void onCompleted(Result paramResult);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static AccessToken createFromTokenWithRefreshedPermissions(AccessToken token, Collection<String> grantedPermissions, Collection<String> declinedPermissions)
/*     */   {
/* 369 */     return new AccessToken(token.getToken(), token.getApplicationId(), token.getUserId(), grantedPermissions, declinedPermissions, token.getSource(), token.getExpires(), token.getLastRefresh());
/*     */   }
/*     */   
/*     */   private LoginLogger getLogger() {
/* 373 */     if ((this.loginLogger == null) || 
/* 374 */       (!this.loginLogger.getApplicationId().equals(this.pendingRequest.getApplicationId())))
/*     */     {
/* 376 */       this.loginLogger = new LoginLogger(getActivity(), this.pendingRequest.getApplicationId());
/*     */     }
/* 378 */     return this.loginLogger;
/*     */   }
/*     */   
/*     */   private void notifyOnCompleteListener(Result outcome) {
/* 382 */     if (this.onCompletedListener != null) {
/* 383 */       this.onCompletedListener.onCompleted(outcome);
/*     */     }
/*     */   }
/*     */   
/*     */   void notifyBackgroundProcessingStart() {
/* 388 */     if (this.backgroundProcessingListener != null) {
/* 389 */       this.backgroundProcessingListener.onBackgroundProcessingStarted();
/*     */     }
/*     */   }
/*     */   
/*     */   void notifyBackgroundProcessingStop() {
/* 394 */     if (this.backgroundProcessingListener != null) {
/* 395 */       this.backgroundProcessingListener.onBackgroundProcessingStopped();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void logAuthorizationMethodComplete(String method, Result result, Map<String, String> loggingExtras)
/*     */   {
/* 403 */     logAuthorizationMethodComplete(method, result.code
/* 404 */       .getLoggingValue(), result.errorMessage, result.errorCode, loggingExtras);
/*     */   }
/*     */   
/*     */   static abstract interface BackgroundProcessingListener
/*     */   {
/*     */     public abstract void onBackgroundProcessingStarted();
/*     */     
/*     */     public abstract void onBackgroundProcessingStopped();
/*     */   }
/*     */   
/*     */   private void logAuthorizationMethodComplete(String method, String result, String errorMessage, String errorCode, Map<String, String> loggingExtras)
/*     */   {
/* 416 */     if (this.pendingRequest == null)
/*     */     {
/* 418 */       getLogger().logUnexpectedError("fb_mobile_login_method_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", method);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 424 */       getLogger().logAuthorizationMethodComplete(this.pendingRequest.getAuthId(), method, result, errorMessage, errorCode, loggingExtras);
/*     */     }
/*     */   }
/*     */   
/*     */   static String getE2E()
/*     */   {
/* 430 */     JSONObject e2e = new JSONObject();
/*     */     try {
/* 432 */       e2e.put("init", System.currentTimeMillis());
/*     */     }
/*     */     catch (JSONException localJSONException) {}
/* 435 */     return e2e.toString();
/*     */   }
/*     */   
/*     */   public static class Request implements Parcelable {
/*     */     private final LoginBehavior loginBehavior;
/*     */     private Set<String> permissions;
/*     */     private final DefaultAudience defaultAudience;
/*     */     private final String applicationId;
/*     */     private final String authId;
/* 444 */     private boolean isRerequest = false;
/*     */     
/*     */ 
/*     */     private String deviceRedirectUriString;
/*     */     
/*     */ 
/*     */ 
/*     */     Request(LoginBehavior loginBehavior, Set<String> permissions, DefaultAudience defaultAudience, String applicationId, String authId)
/*     */     {
/* 453 */       this.loginBehavior = loginBehavior;
/* 454 */       this.permissions = (permissions != null ? permissions : new HashSet());
/* 455 */       this.defaultAudience = defaultAudience;
/* 456 */       this.applicationId = applicationId;
/* 457 */       this.authId = authId;
/*     */     }
/*     */     
/*     */     Set<String> getPermissions() {
/* 461 */       return this.permissions;
/*     */     }
/*     */     
/*     */     void setPermissions(Set<String> permissions) {
/* 465 */       Validate.notNull(permissions, "permissions");
/* 466 */       this.permissions = permissions;
/*     */     }
/*     */     
/*     */     LoginBehavior getLoginBehavior() {
/* 470 */       return this.loginBehavior;
/*     */     }
/*     */     
/*     */     DefaultAudience getDefaultAudience() {
/* 474 */       return this.defaultAudience;
/*     */     }
/*     */     
/*     */     String getApplicationId() {
/* 478 */       return this.applicationId;
/*     */     }
/*     */     
/*     */     String getAuthId() {
/* 482 */       return this.authId;
/*     */     }
/*     */     
/*     */     boolean isRerequest() {
/* 486 */       return this.isRerequest;
/*     */     }
/*     */     
/*     */     void setRerequest(boolean isRerequest) {
/* 490 */       this.isRerequest = isRerequest;
/*     */     }
/*     */     
/*     */     String getDeviceRedirectUriString() {
/* 494 */       return this.deviceRedirectUriString;
/*     */     }
/*     */     
/*     */     void setDeviceRedirectUriString(String deviceRedirectUriString) {
/* 498 */       this.deviceRedirectUriString = deviceRedirectUriString;
/*     */     }
/*     */     
/*     */     boolean hasPublishPermission() {
/* 502 */       for (String permission : this.permissions) {
/* 503 */         if (LoginManager.isPublishPermission(permission)) {
/* 504 */           return true;
/*     */         }
/*     */       }
/* 507 */       return false;
/*     */     }
/*     */     
/*     */     private Request(Parcel parcel) {
/* 511 */       String enumValue = parcel.readString();
/* 512 */       this.loginBehavior = (enumValue != null ? LoginBehavior.valueOf(enumValue) : null);
/* 513 */       ArrayList<String> permissionsList = new ArrayList();
/* 514 */       parcel.readStringList(permissionsList);
/* 515 */       this.permissions = new HashSet(permissionsList);
/* 516 */       enumValue = parcel.readString();
/* 517 */       this.defaultAudience = (enumValue != null ? DefaultAudience.valueOf(enumValue) : null);
/* 518 */       this.applicationId = parcel.readString();
/* 519 */       this.authId = parcel.readString();
/* 520 */       this.isRerequest = (parcel.readByte() != 0);
/* 521 */       this.deviceRedirectUriString = parcel.readString();
/*     */     }
/*     */     
/*     */     public int describeContents()
/*     */     {
/* 526 */       return 0;
/*     */     }
/*     */     
/*     */     public void writeToParcel(Parcel dest, int flags)
/*     */     {
/* 531 */       dest.writeString(this.loginBehavior != null ? this.loginBehavior.name() : null);
/* 532 */       dest.writeStringList(new ArrayList(this.permissions));
/* 533 */       dest.writeString(this.defaultAudience != null ? this.defaultAudience.name() : null);
/* 534 */       dest.writeString(this.applicationId);
/* 535 */       dest.writeString(this.authId);
/* 536 */       dest.writeByte((byte)(this.isRerequest ? 1 : 0));
/* 537 */       dest.writeString(this.deviceRedirectUriString);
/*     */     }
/*     */     
/* 540 */     public static final Creator<Request> CREATOR = new Creator()
/*     */     {
/*     */       public Request createFromParcel(Parcel source) {
/* 543 */         return new Request(source, null);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 548 */       public Request[] newArray(int size) { return new Request[size]; }
/*     */     }; }
/*     */   
/*     */   public static class Result implements Parcelable { final Code code;
/*     */     final AccessToken token;
/*     */     final String errorMessage;
/*     */     
/* 555 */     static enum Code { SUCCESS("success"), 
/* 556 */       CANCEL("cancel"), 
/* 557 */       ERROR("error");
/*     */       
/*     */       private final String loggingValue;
/*     */       
/*     */       private Code(String loggingValue) {
/* 562 */         this.loggingValue = loggingValue;
/*     */       }
/*     */       
/*     */ 
/*     */       String getLoggingValue()
/*     */       {
/* 568 */         return this.loggingValue;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     final String errorCode;
/*     */     
/*     */ 
/*     */     final Request request;
/*     */     
/*     */ 
/*     */     public Map<String, String> loggingExtras;
/*     */     
/*     */ 
/*     */     Result(Request request, Code code, AccessToken token, String errorMessage, String errorCode)
/*     */     {
/* 585 */       Validate.notNull(code, "code");
/* 586 */       this.request = request;
/* 587 */       this.token = token;
/* 588 */       this.errorMessage = errorMessage;
/* 589 */       this.code = code;
/* 590 */       this.errorCode = errorCode;
/*     */     }
/*     */     
/*     */     static Result createTokenResult(Request request, AccessToken token) {
/* 594 */       return new Result(request, Code.SUCCESS, token, null, null);
/*     */     }
/*     */     
/*     */     static Result createCancelResult(Request request, String message) {
/* 598 */       return new Result(request, Code.CANCEL, null, message, null);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     static Result createErrorResult(Request request, String errorType, String errorDescription)
/*     */     {
/* 605 */       return createErrorResult(request, errorType, errorDescription, null);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     static Result createErrorResult(Request request, String errorType, String errorDescription, String errorCode)
/*     */     {
/* 613 */       String message = TextUtils.join(": ", 
/*     */       
/* 615 */         Utility.asListNoNulls(new String[] { errorType, errorDescription }));
/* 616 */       return new Result(request, Code.ERROR, null, message, errorCode);
/*     */     }
/*     */     
/*     */     private Result(Parcel parcel) {
/* 620 */       this.code = Code.valueOf(parcel.readString());
/* 621 */       this.token = ((AccessToken)parcel.readParcelable(AccessToken.class.getClassLoader()));
/* 622 */       this.errorMessage = parcel.readString();
/* 623 */       this.errorCode = parcel.readString();
/* 624 */       this.request = ((Request)parcel.readParcelable(Request.class.getClassLoader()));
/* 625 */       this.loggingExtras = Utility.readStringMapFromParcel(parcel);
/*     */     }
/*     */     
/*     */     public int describeContents()
/*     */     {
/* 630 */       return 0;
/*     */     }
/*     */     
/*     */     public void writeToParcel(Parcel dest, int flags)
/*     */     {
/* 635 */       dest.writeString(this.code.name());
/* 636 */       dest.writeParcelable(this.token, flags);
/* 637 */       dest.writeString(this.errorMessage);
/* 638 */       dest.writeString(this.errorCode);
/* 639 */       dest.writeParcelable(this.request, flags);
/* 640 */       Utility.writeStringMapToParcel(dest, this.loggingExtras);
/*     */     }
/*     */     
/* 643 */     public static final Creator<Result> CREATOR = new Creator()
/*     */     {
/*     */       public Result createFromParcel(Parcel source) {
/* 646 */         return new Result(source, null);
/*     */       }
/*     */       
/*     */       public Result[] newArray(int size)
/*     */       {
/* 651 */         return new Result[size];
/*     */       }
/*     */     };
/*     */   }
/*     */   
/*     */ 
/*     */   public LoginClient(Parcel source)
/*     */   {
/* 659 */     Object[] o = source.readParcelableArray(LoginMethodHandler.class.getClassLoader());
/* 660 */     this.handlersToTry = new LoginMethodHandler[o.length];
/* 661 */     for (int i = 0; i < o.length; i++) {
/* 662 */       this.handlersToTry[i] = ((LoginMethodHandler)o[i]);
/* 663 */       this.handlersToTry[i].setLoginClient(this);
/*     */     }
/* 665 */     this.currentHandler = source.readInt();
/* 666 */     this.pendingRequest = ((Request)source.readParcelable(Request.class.getClassLoader()));
/* 667 */     this.loggingExtras = Utility.readStringMapFromParcel(source);
/*     */   }
/*     */   
/*     */   public int describeContents()
/*     */   {
/* 672 */     return 0;
/*     */   }
/*     */   
/*     */   public void writeToParcel(Parcel dest, int flags)
/*     */   {
/* 677 */     dest.writeParcelableArray(this.handlersToTry, flags);
/* 678 */     dest.writeInt(this.currentHandler);
/* 679 */     dest.writeParcelable(this.pendingRequest, flags);
/* 680 */     Utility.writeStringMapToParcel(dest, this.loggingExtras);
/*     */   }
/*     */   
/* 683 */   public static final Creator<LoginClient> CREATOR = new Creator()
/*     */   {
/*     */     public LoginClient createFromParcel(Parcel source) {
/* 686 */       return new LoginClient(source);
/*     */     }
/*     */     
/*     */     public LoginClient[] newArray(int size)
/*     */     {
/* 691 */       return new LoginClient[size];
/*     */     }
/*     */   };
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/login/LoginClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */