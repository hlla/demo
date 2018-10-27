/*     */ package com.facebook.login;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.content.ActivityNotFoundException;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.content.pm.PackageManager;
/*     */ import android.content.pm.ResolveInfo;
/*     */ import android.os.Bundle;
/*     */ import com.facebook.AccessToken;
/*     */ import com.facebook.CallbackManager;
/*     */ import com.facebook.FacebookActivity;
/*     */ import com.facebook.FacebookAuthorizationException;
/*     */ import com.facebook.FacebookCallback;
/*     */ import com.facebook.FacebookException;
/*     */ import com.facebook.FacebookSdk;
/*     */ import com.facebook.GraphRequest;
/*     */ import com.facebook.GraphResponse;
/*     */ import com.facebook.Profile;
/*     */ import com.facebook.internal.CallbackManagerImpl;
/*     */ import com.facebook.internal.CallbackManagerImpl.Callback;
/*     */ import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
/*     */ import com.facebook.internal.FragmentWrapper;
/*     */ import com.facebook.internal.Validate;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.UUID;
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
/*     */ public class LoginManager
/*     */ {
/*     */   private static final String PUBLISH_PERMISSION_PREFIX = "publish";
/*     */   private static final String MANAGE_PERMISSION_PREFIX = "manage";
/*  59 */   private static final Set<String> OTHER_PUBLISH_PERMISSIONS = ;
/*     */   
/*     */   private static volatile LoginManager instance;
/*     */   
/*  63 */   private LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
/*  64 */   private DefaultAudience defaultAudience = DefaultAudience.FRIENDS;
/*     */   
/*     */   LoginManager() {
/*  67 */     Validate.sdkInitialized();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static LoginManager getInstance()
/*     */   {
/*  75 */     if (instance == null) {
/*  76 */       synchronized (LoginManager.class) {
/*  77 */         if (instance == null) {
/*  78 */           instance = new LoginManager();
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  83 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void resolveError(Activity activity, GraphResponse response)
/*     */   {
/*  94 */     startLogin(new ActivityStartActivityDelegate(activity), 
/*     */     
/*  96 */       createLoginRequestFromResponse(response));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void resolveError(android.support.v4.app.Fragment fragment, GraphResponse response)
/*     */   {
/* 108 */     resolveError(new FragmentWrapper(fragment), response);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void resolveError(android.app.Fragment fragment, GraphResponse response)
/*     */   {
/* 119 */     resolveError(new FragmentWrapper(fragment), response);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void resolveError(FragmentWrapper fragment, GraphResponse response)
/*     */   {
/* 130 */     startLogin(new FragmentStartActivityDelegate(fragment), 
/*     */     
/* 132 */       createLoginRequestFromResponse(response));
/*     */   }
/*     */   
/*     */   private LoginClient.Request createLoginRequestFromResponse(GraphResponse response)
/*     */   {
/* 137 */     Validate.notNull(response, "response");
/* 138 */     AccessToken failedToken = response.getRequest().getAccessToken();
/* 139 */     return createLoginRequest(failedToken != null ? failedToken.getPermissions() : null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void registerCallback(CallbackManager callbackManager, final FacebookCallback<LoginResult> callback)
/*     */   {
/* 150 */     if (!(callbackManager instanceof CallbackManagerImpl)) {
/* 151 */       throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
/*     */     }
/*     */     
/* 154 */     ((CallbackManagerImpl)callbackManager).registerCallback(CallbackManagerImpl.RequestCodeOffset.Login
/* 155 */       .toRequestCode(), new CallbackManagerImpl.Callback()
/*     */       {
/*     */         public boolean onActivityResult(int resultCode, Intent data)
/*     */         {
/* 159 */           return LoginManager.this.onActivityResult(resultCode, data, callback);
/*     */         }
/*     */       });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean onActivityResult(int resultCode, Intent data)
/*     */   {
/* 169 */     return onActivityResult(resultCode, data, null);
/*     */   }
/*     */   
/*     */   boolean onActivityResult(int resultCode, Intent data, FacebookCallback<LoginResult> callback) {
/* 173 */     FacebookException exception = null;
/* 174 */     AccessToken newToken = null;
/* 175 */     LoginClient.Result.Code code = LoginClient.Result.Code.ERROR;
/* 176 */     Map<String, String> loggingExtras = null;
/* 177 */     LoginClient.Request originalRequest = null;
/*     */     
/* 179 */     boolean isCanceled = false;
/* 180 */     if (data != null)
/*     */     {
/* 182 */       LoginClient.Result result = (LoginClient.Result)data.getParcelableExtra("com.facebook.LoginFragment:Result");
/* 183 */       if (result != null) {
/* 184 */         originalRequest = result.request;
/* 185 */         code = result.code;
/* 186 */         if (resultCode == -1) {
/* 187 */           if (result.code == LoginClient.Result.Code.SUCCESS) {
/* 188 */             newToken = result.token;
/*     */           } else {
/* 190 */             exception = new FacebookAuthorizationException(result.errorMessage);
/*     */           }
/* 192 */         } else if (resultCode == 0) {
/* 193 */           isCanceled = true;
/*     */         }
/* 195 */         loggingExtras = result.loggingExtras;
/*     */       }
/* 197 */     } else if (resultCode == 0) {
/* 198 */       isCanceled = true;
/* 199 */       code = LoginClient.Result.Code.CANCEL;
/*     */     }
/*     */     
/* 202 */     if ((exception == null) && (newToken == null) && (!isCanceled)) {
/* 203 */       exception = new FacebookException("Unexpected call to LoginManager.onActivityResult");
/*     */     }
/*     */     
/* 206 */     boolean wasLoginActivityTried = true;
/* 207 */     Context context = null;
/* 208 */     logCompleteLogin(context, code, loggingExtras, exception, wasLoginActivityTried, originalRequest);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 216 */     finishLogin(newToken, originalRequest, exception, isCanceled, callback);
/*     */     
/* 218 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public LoginBehavior getLoginBehavior()
/*     */   {
/* 226 */     return this.loginBehavior;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public LoginManager setLoginBehavior(LoginBehavior loginBehavior)
/*     */   {
/* 235 */     this.loginBehavior = loginBehavior;
/* 236 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public DefaultAudience getDefaultAudience()
/*     */   {
/* 244 */     return this.defaultAudience;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public LoginManager setDefaultAudience(DefaultAudience defaultAudience)
/*     */   {
/* 253 */     this.defaultAudience = defaultAudience;
/* 254 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void logOut()
/*     */   {
/* 261 */     AccessToken.setCurrentAccessToken(null);
/* 262 */     Profile.setCurrentProfile(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void logInWithReadPermissions(android.support.v4.app.Fragment fragment, Collection<String> permissions)
/*     */   {
/* 273 */     logInWithReadPermissions(new FragmentWrapper(fragment), permissions);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void logInWithReadPermissions(android.app.Fragment fragment, Collection<String> permissions)
/*     */   {
/* 284 */     logInWithReadPermissions(new FragmentWrapper(fragment), permissions);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void logInWithReadPermissions(FragmentWrapper fragment, Collection<String> permissions)
/*     */   {
/* 295 */     validateReadPermissions(permissions);
/*     */     
/* 297 */     LoginClient.Request loginRequest = createLoginRequest(permissions);
/* 298 */     startLogin(new FragmentStartActivityDelegate(fragment), loginRequest);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void logInWithReadPermissions(Activity activity, Collection<String> permissions)
/*     */   {
/* 307 */     validateReadPermissions(permissions);
/*     */     
/* 309 */     LoginClient.Request loginRequest = createLoginRequest(permissions);
/* 310 */     startLogin(new ActivityStartActivityDelegate(activity), loginRequest);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void logInWithPublishPermissions(android.support.v4.app.Fragment fragment, Collection<String> permissions)
/*     */   {
/* 321 */     logInWithPublishPermissions(new FragmentWrapper(fragment), permissions);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void logInWithPublishPermissions(android.app.Fragment fragment, Collection<String> permissions)
/*     */   {
/* 332 */     logInWithPublishPermissions(new FragmentWrapper(fragment), permissions);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void logInWithPublishPermissions(FragmentWrapper fragment, Collection<String> permissions)
/*     */   {
/* 343 */     validatePublishPermissions(permissions);
/*     */     
/* 345 */     LoginClient.Request loginRequest = createLoginRequest(permissions);
/* 346 */     startLogin(new FragmentStartActivityDelegate(fragment), loginRequest);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void logInWithPublishPermissions(Activity activity, Collection<String> permissions)
/*     */   {
/* 355 */     validatePublishPermissions(permissions);
/*     */     
/* 357 */     LoginClient.Request loginRequest = createLoginRequest(permissions);
/* 358 */     startLogin(new ActivityStartActivityDelegate(activity), loginRequest);
/*     */   }
/*     */   
/*     */   private void validateReadPermissions(Collection<String> permissions) {
/* 362 */     if (permissions == null) {
/* 363 */       return;
/*     */     }
/* 365 */     for (String permission : permissions) {
/* 366 */       if (isPublishPermission(permission))
/*     */       {
/* 368 */         throw new FacebookException(String.format("Cannot pass a publish or manage permission (%s) to a request for read authorization", new Object[] { permission }));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void validatePublishPermissions(Collection<String> permissions)
/*     */   {
/* 377 */     if (permissions == null) {
/* 378 */       return;
/*     */     }
/* 380 */     for (String permission : permissions) {
/* 381 */       if (!isPublishPermission(permission))
/*     */       {
/* 383 */         throw new FacebookException(String.format("Cannot pass a read permission (%s) to a request for publish authorization", new Object[] { permission }));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isPublishPermission(String permission)
/*     */   {
/* 394 */     return (permission != null) && ((permission.startsWith("publish")) || (permission.startsWith("manage")) || (OTHER_PUBLISH_PERMISSIONS.contains(permission)));
/*     */   }
/*     */   
/*     */   private static Set<String> getOtherPublishPermissions() {
/* 398 */     HashSet<String> set = new HashSet() {};
/* 403 */     return Collections.unmodifiableSet(set);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected LoginClient.Request createLoginRequest(Collection<String> permissions)
/*     */   {
/* 413 */     LoginClient.Request request = new LoginClient.Request(this.loginBehavior, Collections.unmodifiableSet(permissions != null ? new HashSet(permissions) : new HashSet()), this.defaultAudience, FacebookSdk.getApplicationId(), UUID.randomUUID().toString());
/*     */     
/* 415 */     request.setRerequest(AccessToken.getCurrentAccessToken() != null);
/* 416 */     return request;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void startLogin(StartActivityDelegate startActivityDelegate, LoginClient.Request request)
/*     */     throws FacebookException
/*     */   {
/* 424 */     logStartLogin(startActivityDelegate.getActivityContext(), request);
/*     */     
/*     */ 
/* 427 */     CallbackManagerImpl.registerStaticCallback(CallbackManagerImpl.RequestCodeOffset.Login
/* 428 */       .toRequestCode(), new CallbackManagerImpl.Callback()
/*     */       {
/*     */         public boolean onActivityResult(int resultCode, Intent data)
/*     */         {
/* 432 */           return LoginManager.this.onActivityResult(resultCode, data);
/*     */         }
/*     */         
/*     */ 
/* 436 */       });
/* 437 */     boolean started = tryFacebookActivity(startActivityDelegate, request);
/*     */     
/* 439 */     if (!started) {
/* 440 */       FacebookException exception = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
/*     */       
/*     */ 
/* 443 */       boolean wasLoginActivityTried = false;
/* 444 */       logCompleteLogin(startActivityDelegate
/* 445 */         .getActivityContext(), LoginClient.Result.Code.ERROR, null, exception, wasLoginActivityTried, request);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 451 */       throw exception;
/*     */     }
/*     */   }
/*     */   
/*     */   private void logStartLogin(Context context, LoginClient.Request loginRequest) {
/* 456 */     LoginLogger loginLogger = LoginLoggerHolder.getLogger(context);
/* 457 */     if ((loginLogger != null) && (loginRequest != null)) {
/* 458 */       loginLogger.logStartLogin(loginRequest);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void logCompleteLogin(Context context, LoginClient.Result.Code result, Map<String, String> resultExtras, Exception exception, boolean wasLoginActivityTried, LoginClient.Request request)
/*     */   {
/* 469 */     LoginLogger loginLogger = LoginLoggerHolder.getLogger(context);
/* 470 */     if (loginLogger == null) {
/* 471 */       return;
/*     */     }
/* 473 */     if (request == null)
/*     */     {
/* 475 */       loginLogger.logUnexpectedError("fb_mobile_login_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.");
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 480 */       HashMap<String, String> pendingLoggingExtras = new HashMap();
/* 481 */       pendingLoggingExtras.put("try_login_activity", wasLoginActivityTried ? "1" : "0");
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 487 */       loginLogger.logCompleteLogin(request
/* 488 */         .getAuthId(), pendingLoggingExtras, result, resultExtras, exception);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean tryFacebookActivity(StartActivityDelegate startActivityDelegate, LoginClient.Request request)
/*     */   {
/* 500 */     Intent intent = getFacebookActivityIntent(request);
/*     */     
/* 502 */     if (!resolveIntent(intent)) {
/* 503 */       return false;
/*     */     }
/*     */     try
/*     */     {
/* 507 */       startActivityDelegate.startActivityForResult(intent, 
/*     */       
/* 509 */         LoginClient.getLoginRequestCode());
/*     */     } catch (ActivityNotFoundException e) {
/* 511 */       return false;
/*     */     }
/*     */     
/* 514 */     return true;
/*     */   }
/*     */   
/*     */   private boolean resolveIntent(Intent intent)
/*     */   {
/* 519 */     ResolveInfo resolveInfo = FacebookSdk.getApplicationContext().getPackageManager().resolveActivity(intent, 0);
/* 520 */     return resolveInfo != null;
/*     */   }
/*     */   
/*     */   protected Intent getFacebookActivityIntent(LoginClient.Request request) {
/* 524 */     Intent intent = new Intent();
/* 525 */     intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
/* 526 */     intent.setAction(request.getLoginBehavior().toString());
/*     */     
/*     */ 
/* 529 */     Bundle extras = new Bundle();
/* 530 */     extras.putParcelable("request", request);
/* 531 */     intent.putExtra("com.facebook.LoginFragment:Request", extras);
/*     */     
/* 533 */     return intent;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static LoginResult computeLoginResult(LoginClient.Request request, AccessToken newToken)
/*     */   {
/* 540 */     Set<String> requestedPermissions = request.getPermissions();
/* 541 */     Set<String> grantedPermissions = new HashSet(newToken.getPermissions());
/*     */     
/*     */ 
/*     */ 
/* 545 */     if (request.isRerequest()) {
/* 546 */       grantedPermissions.retainAll(requestedPermissions);
/*     */     }
/*     */     
/* 549 */     Set<String> deniedPermissions = new HashSet(requestedPermissions);
/* 550 */     deniedPermissions.removeAll(grantedPermissions);
/* 551 */     return new LoginResult(newToken, grantedPermissions, deniedPermissions);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void finishLogin(AccessToken newToken, LoginClient.Request origRequest, FacebookException exception, boolean isCanceled, FacebookCallback<LoginResult> callback)
/*     */   {
/* 560 */     if (newToken != null) {
/* 561 */       AccessToken.setCurrentAccessToken(newToken);
/* 562 */       Profile.fetchProfileForCurrentAccessToken();
/*     */     }
/*     */     
/* 565 */     if (callback != null)
/*     */     {
/* 567 */       LoginResult loginResult = newToken != null ? computeLoginResult(origRequest, newToken) : null;
/*     */       
/*     */ 
/* 570 */       if (!isCanceled) { if (loginResult != null)
/*     */         {
/* 572 */           if (loginResult.getRecentlyGrantedPermissions().size() != 0) {} }
/* 573 */       } else { callback.onCancel(); return; }
/* 574 */       if (exception != null) {
/* 575 */         callback.onError(exception);
/* 576 */       } else if (newToken != null) {
/* 577 */         callback.onSuccess(loginResult);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static class ActivityStartActivityDelegate implements StartActivityDelegate {
/*     */     private final Activity activity;
/*     */     
/*     */     ActivityStartActivityDelegate(Activity activity) {
/* 586 */       Validate.notNull(activity, "activity");
/* 587 */       this.activity = activity;
/*     */     }
/*     */     
/*     */     public void startActivityForResult(Intent intent, int requestCode)
/*     */     {
/* 592 */       this.activity.startActivityForResult(intent, requestCode);
/*     */     }
/*     */     
/*     */     public Activity getActivityContext()
/*     */     {
/* 597 */       return this.activity;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class FragmentStartActivityDelegate implements StartActivityDelegate {
/*     */     private final FragmentWrapper fragment;
/*     */     
/*     */     FragmentStartActivityDelegate(FragmentWrapper fragment) {
/* 605 */       Validate.notNull(fragment, "fragment");
/* 606 */       this.fragment = fragment;
/*     */     }
/*     */     
/*     */     public void startActivityForResult(Intent intent, int requestCode)
/*     */     {
/* 611 */       this.fragment.startActivityForResult(intent, requestCode);
/*     */     }
/*     */     
/*     */     public Activity getActivityContext()
/*     */     {
/* 616 */       return this.fragment.getActivity();
/*     */     }
/*     */   }
/*     */   
/*     */   private static class LoginLoggerHolder {
/*     */     private static volatile LoginLogger logger;
/*     */     
/*     */     private static synchronized LoginLogger getLogger(Context context) {
/* 624 */       context = context != null ? context : FacebookSdk.getApplicationContext();
/* 625 */       if (context == null) {
/* 626 */         return null;
/*     */       }
/* 628 */       if (logger == null) {
/* 629 */         logger = new LoginLogger(context, FacebookSdk.getApplicationId());
/*     */       }
/* 631 */       return logger;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/login/LoginManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */