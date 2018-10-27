/*     */ package com.facebook.login;
/*     */ 
/*     */ import android.app.AlertDialog;
/*     */ import android.app.AlertDialog.Builder;
/*     */ import android.app.Dialog;
/*     */ import android.content.DialogInterface;
/*     */ import android.content.DialogInterface.OnClickListener;
/*     */ import android.content.res.Resources;
/*     */ import android.graphics.Bitmap;
/*     */ import android.graphics.drawable.BitmapDrawable;
/*     */ import android.net.Uri;
/*     */ import android.os.Bundle;
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
/*     */ import android.os.Parcelable.Creator;
/*     */ import android.support.annotation.NonNull;
/*     */ import android.support.annotation.Nullable;
/*     */ import android.support.v4.app.DialogFragment;
/*     */ import android.support.v4.app.FragmentActivity;
/*     */ import android.text.Html;
/*     */ import android.text.TextUtils;
/*     */ import android.view.LayoutInflater;
/*     */ import android.view.View;
/*     */ import android.view.View.OnClickListener;
/*     */ import android.view.ViewGroup;
/*     */ import android.widget.Button;
/*     */ import android.widget.ProgressBar;
/*     */ import android.widget.TextView;
/*     */ import com.facebook.AccessToken;
/*     */ import com.facebook.AccessTokenSource;
/*     */ import com.facebook.FacebookActivity;
/*     */ import com.facebook.FacebookException;
/*     */ import com.facebook.FacebookRequestError;
/*     */ import com.facebook.FacebookSdk;
/*     */ import com.facebook.GraphRequest;
/*     */ import com.facebook.GraphRequest.Callback;
/*     */ import com.facebook.GraphRequestAsyncTask;
/*     */ import com.facebook.GraphResponse;
/*     */ import com.facebook.HttpMethod;
/*     */ import com.facebook.R.id;
/*     */ import com.facebook.R.layout;
/*     */ import com.facebook.R.string;
/*     */ import com.facebook.R.style;
/*     */ import com.facebook.appevents.AppEventsLogger;
/*     */ import com.facebook.devicerequests.internal.DeviceRequestsHelper;
/*     */ import com.facebook.internal.FetchedAppSettings;
/*     */ import com.facebook.internal.FetchedAppSettingsManager;
/*     */ import com.facebook.internal.ImageDownloader;
/*     */ import com.facebook.internal.ImageRequest;
/*     */ import com.facebook.internal.ImageRequest.Builder;
/*     */ import com.facebook.internal.ImageRequest.Callback;
/*     */ import com.facebook.internal.ImageResponse;
/*     */ import com.facebook.internal.SmartLoginOption;
/*     */ import com.facebook.internal.Utility;
/*     */ import com.facebook.internal.Utility.PermissionsPair;
/*     */ import com.facebook.internal.Validate;
/*     */ import java.util.Date;
/*     */ import java.util.EnumSet;
/*     */ import java.util.concurrent.ScheduledFuture;
/*     */ import java.util.concurrent.ScheduledThreadPoolExecutor;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
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
/*     */ public class DeviceAuthDialog
/*     */   extends DialogFragment
/*     */ {
/*     */   private static final String DEVICE_LOGIN_ENDPOINT = "device/login";
/*     */   private static final String DEVICE_LOGIN_STATUS_ENDPOINT = "device/login_status";
/*     */   private static final String REQUEST_STATE_KEY = "request_state";
/*     */   private static final int LOGIN_ERROR_SUBCODE_EXCESSIVE_POLLING = 1349172;
/*     */   private static final int LOGIN_ERROR_SUBCODE_AUTHORIZATION_DECLINED = 1349173;
/*     */   private static final int LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING = 1349174;
/*     */   private static final int LOGIN_ERROR_SUBCODE_CODE_EXPIRED = 1349152;
/*     */   private ProgressBar progressBar;
/*     */   private TextView confirmationCode;
/*     */   private DeviceAuthMethodHandler deviceAuthMethodHandler;
/*  88 */   private AtomicBoolean completed = new AtomicBoolean();
/*     */   
/*     */   private volatile GraphRequestAsyncTask currentGraphRequestPoll;
/*     */   
/*     */   private volatile ScheduledFuture scheduledPoll;
/*     */   
/*     */   private volatile RequestState currentRequestState;
/*     */   private Dialog dialog;
/*  96 */   private boolean isBeingDestroyed = false;
/*  97 */   private boolean isRetry = false;
/*  98 */   private LoginClient.Request mRequest = null;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
/*     */   {
/* 106 */     View view = super.onCreateView(inflater, container, savedInstanceState);
/* 107 */     FacebookActivity facebookActivity = (FacebookActivity)getActivity();
/* 108 */     LoginFragment fragment = (LoginFragment)facebookActivity.getCurrentFragment();
/*     */     
/*     */ 
/* 111 */     this.deviceAuthMethodHandler = ((DeviceAuthMethodHandler)fragment.getLoginClient().getCurrentHandler());
/*     */     
/* 113 */     if (savedInstanceState != null) {
/* 114 */       RequestState requestState = (RequestState)savedInstanceState.getParcelable("request_state");
/* 115 */       if (requestState != null) {
/* 116 */         setCurrentRequestState(requestState);
/*     */       }
/*     */     }
/*     */     
/* 120 */     return view;
/*     */   }
/*     */   
/*     */   @NonNull
/*     */   public Dialog onCreateDialog(Bundle savedInstanceState)
/*     */   {
/* 126 */     this.dialog = new Dialog(getActivity(), R.style.com_facebook_auth_dialog);
/* 127 */     LayoutInflater inflater = getActivity().getLayoutInflater();
/*     */     
/* 129 */     View view = initializeContentView((DeviceRequestsHelper.isAvailable()) && (!this.isRetry));
/*     */     
/* 131 */     this.dialog.setContentView(view);
/* 132 */     return this.dialog;
/*     */   }
/*     */   
/*     */   public void onDismiss(DialogInterface dialog)
/*     */   {
/* 137 */     super.onDismiss(dialog);
/* 138 */     if (!this.isBeingDestroyed) {
/* 139 */       onCancel();
/*     */     }
/*     */   }
/*     */   
/*     */   public void onSaveInstanceState(Bundle outState)
/*     */   {
/* 145 */     super.onSaveInstanceState(outState);
/* 146 */     if (this.currentRequestState != null) {
/* 147 */       outState.putParcelable("request_state", this.currentRequestState);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onDestroy()
/*     */   {
/* 156 */     this.isBeingDestroyed = true;
/* 157 */     this.completed.set(true);
/* 158 */     super.onDestroy();
/* 159 */     if (this.currentGraphRequestPoll != null) {
/* 160 */       this.currentGraphRequestPoll.cancel(true);
/*     */     }
/*     */     
/* 163 */     if (this.scheduledPoll != null) {
/* 164 */       this.scheduledPoll.cancel(true);
/*     */     }
/*     */   }
/*     */   
/*     */   public void startLogin(LoginClient.Request request) {
/* 169 */     this.mRequest = request;
/* 170 */     Bundle parameters = new Bundle();
/* 171 */     parameters.putString("scope", TextUtils.join(",", request.getPermissions()));
/*     */     
/* 173 */     String redirectUriString = request.getDeviceRedirectUriString();
/* 174 */     if (redirectUriString != null) {
/* 175 */       parameters.putString("redirect_uri", redirectUriString);
/*     */     }
/*     */     
/* 178 */     String accessToken = Validate.hasAppID() + "|" + Validate.hasClientToken();
/* 179 */     parameters.putString("access_token", accessToken);
/* 180 */     parameters.putString("device_info", 
/* 181 */       DeviceRequestsHelper.getDeviceInfo());
/*     */     
/* 183 */     GraphRequest graphRequest = new GraphRequest(null, "device/login", parameters, HttpMethod.POST, new GraphRequest.Callback()
/*     */     {
/*     */ 
/*     */ 
/*     */       public void onCompleted(GraphResponse response)
/*     */       {
/*     */ 
/*     */ 
/* 191 */         if (response.getError() != null) {
/* 192 */           DeviceAuthDialog.this.onError(response.getError().getException());
/* 193 */           return;
/*     */         }
/*     */         
/* 196 */         JSONObject jsonObject = response.getJSONObject();
/* 197 */         RequestState requestState = new RequestState();
/*     */         try {
/* 199 */           requestState.setUserCode(jsonObject.getString("user_code"));
/* 200 */           requestState.setRequestCode(jsonObject.getString("code"));
/* 201 */           requestState.setInterval(jsonObject.getLong("interval"));
/*     */         } catch (JSONException ex) {
/* 203 */           DeviceAuthDialog.this.onError(new FacebookException(ex));
/* 204 */           return;
/*     */         }
/*     */         
/* 207 */         DeviceAuthDialog.this.setCurrentRequestState(requestState);
/*     */       }
/* 209 */     });
/* 210 */     graphRequest.executeAsync();
/*     */   }
/*     */   
/*     */   private void setCurrentRequestState(RequestState currentRequestState) {
/* 214 */     this.currentRequestState = currentRequestState;
/* 215 */     this.confirmationCode.setText(currentRequestState.getUserCode());
/* 216 */     this.confirmationCode.setVisibility(0);
/* 217 */     this.progressBar.setVisibility(8);
/*     */     
/* 219 */     if ((!this.isRetry) && 
/* 220 */       (DeviceRequestsHelper.startAdvertisementService(currentRequestState.getUserCode()))) {
/* 221 */       AppEventsLogger logger = AppEventsLogger.newLogger(getContext());
/* 222 */       logger.logSdkEvent("fb_smart_login_service", null, null);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 227 */     if (currentRequestState.withinLastRefreshWindow()) {
/* 228 */       schedulePoll();
/*     */     } else {
/* 230 */       poll();
/*     */     }
/*     */   }
/*     */   
/*     */   private void appendIconToTextView(final TextView textView, String iconUriString) {
/* 235 */     int iconSize = 24;
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
/* 252 */     ImageRequest request = new ImageRequest.Builder(getContext(), Uri.parse(iconUriString)).setCallback(new ImageRequest.Callback()
/*     */     {
/*     */       public void onCompleted(ImageResponse response)
/*     */       {
/* 242 */         if (response.getBitmap() != null) {
/* 243 */           Bitmap bitmap = Bitmap.createScaledBitmap(response.getBitmap(), 24, 24, false);
/*     */           
/* 245 */           BitmapDrawable drawable = new BitmapDrawable(DeviceAuthDialog.this.getResources(), bitmap);
/*     */           
/* 247 */           textView.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
/*     */         }
/*     */         
/*     */       }
/*     */       
/* 252 */     }).build();
/* 253 */     ImageDownloader.downloadAsync(request);
/*     */   }
/*     */   
/*     */   private View initializeContentView(boolean isSmartLogin)
/*     */   {
/* 258 */     LayoutInflater inflater = getActivity().getLayoutInflater();
/* 259 */     View view; if (isSmartLogin) {
/* 260 */       View view = inflater.inflate(R.layout.com_facebook_smart_device_dialog_fragment, null);
/*     */       
/*     */ 
/* 263 */       FetchedAppSettings settings = FetchedAppSettingsManager.getAppSettingsWithoutQuery(
/* 264 */         FacebookSdk.getApplicationId());
/* 265 */       if (settings.getSmartLoginBookmarkIconURL() != null) {
/* 266 */         TextView instructions2 = (TextView)view.findViewById(R.id.com_facebook_smart_instructions_2);
/*     */         
/* 268 */         appendIconToTextView(instructions2, settings.getSmartLoginBookmarkIconURL());
/*     */       }
/* 270 */       if (settings.getSmartLoginMenuIconURL() != null) {
/* 271 */         TextView instructions1 = (TextView)view.findViewById(R.id.com_facebook_smart_instructions_1);
/*     */         
/* 273 */         appendIconToTextView(instructions1, settings.getSmartLoginMenuIconURL());
/*     */       }
/*     */     } else {
/* 276 */       view = inflater.inflate(R.layout.com_facebook_device_auth_dialog_fragment, null);
/*     */     }
/* 278 */     this.progressBar = ((ProgressBar)view.findViewById(R.id.progress_bar));
/* 279 */     this.confirmationCode = ((TextView)view.findViewById(R.id.confirmation_code));
/*     */     
/* 281 */     Button cancelButton = (Button)view.findViewById(R.id.cancel_button);
/* 282 */     cancelButton.setOnClickListener(new View.OnClickListener()
/*     */     {
/*     */       public void onClick(View v) {
/* 285 */         DeviceAuthDialog.this.onCancel();
/*     */       }
/*     */       
/* 288 */     });
/* 289 */     TextView instructions = (TextView)view.findViewById(R.id.com_facebook_device_auth_instructions);
/*     */     
/* 291 */     instructions.setText(
/* 292 */       Html.fromHtml(getString(R.string.com_facebook_device_auth_instructions)));
/* 293 */     return view;
/*     */   }
/*     */   
/*     */   private void poll() {
/* 297 */     this.currentRequestState.setLastPoll(new Date().getTime());
/* 298 */     this.currentGraphRequestPoll = getPollRequest().executeAsync();
/*     */   }
/*     */   
/*     */   private void schedulePoll() {
/* 302 */     this.scheduledPoll = DeviceAuthMethodHandler.getBackgroundExecutor().schedule(new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/* 306 */         DeviceAuthDialog.this.poll();
/*     */       }
/*     */       
/* 309 */     }, this.currentRequestState.getInterval(), TimeUnit.SECONDS);
/*     */   }
/*     */   
/*     */   private GraphRequest getPollRequest()
/*     */   {
/* 314 */     Bundle parameters = new Bundle();
/* 315 */     parameters.putString("code", this.currentRequestState.getRequestCode());
/* 316 */     new GraphRequest(null, "device/login_status", parameters, HttpMethod.POST, new GraphRequest.Callback()
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */       public void onCompleted(GraphResponse response)
/*     */       {
/*     */ 
/*     */ 
/* 325 */         if (DeviceAuthDialog.this.completed.get()) {
/* 326 */           return;
/*     */         }
/*     */         
/* 329 */         FacebookRequestError error = response.getError();
/* 330 */         if (error != null)
/*     */         {
/*     */ 
/* 333 */           switch (error.getSubErrorCode())
/*     */           {
/*     */           case 1349172: 
/*     */           case 1349174: 
/* 337 */             DeviceAuthDialog.this.schedulePoll();
/* 338 */             break;
/*     */           case 1349152: 
/*     */           case 1349173: 
/* 341 */             DeviceAuthDialog.this.onCancel();
/* 342 */             break;
/*     */           default: 
/* 344 */             DeviceAuthDialog.this.onError(response.getError().getException());
/*     */           }
/*     */           
/*     */           
/* 348 */           return;
/*     */         }
/*     */         try
/*     */         {
/* 352 */           JSONObject resultObject = response.getJSONObject();
/* 353 */           DeviceAuthDialog.this.onSuccess(resultObject.getString("access_token"));
/*     */         } catch (JSONException ex) {
/* 355 */           DeviceAuthDialog.this.onError(new FacebookException(ex));
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void presentConfirmation(final String userId, final Utility.PermissionsPair permissions, final String accessToken, String name)
/*     */   {
/* 365 */     String message = getResources().getString(R.string.com_facebook_smart_login_confirmation_title);
/*     */     
/* 367 */     String continueFormat = getResources().getString(R.string.com_facebook_smart_login_confirmation_continue_as);
/*     */     
/* 369 */     String cancel = getResources().getString(R.string.com_facebook_smart_login_confirmation_cancel);
/*     */     
/* 371 */     String continueText = String.format(continueFormat, new Object[] { name });
/* 372 */     Builder builder = new Builder(getContext());
/* 373 */     builder.setMessage(message)
/* 374 */       .setCancelable(true)
/* 375 */       .setNegativeButton(continueText, new DialogInterface.OnClickListener()
/*     */       {
/*     */ 
/* 377 */         public void onClick(DialogInterface alertDialog, int which) { DeviceAuthDialog.this.completeLogin(userId, permissions, accessToken); } })
/*     */       
/*     */ 
/* 380 */       .setPositiveButton(cancel, new DialogInterface.OnClickListener()
/*     */       {
/*     */ 
/*     */         public void onClick(DialogInterface alertDialog, int which)
/*     */         {
/* 382 */           View view = DeviceAuthDialog.this.initializeContentView(false);
/* 383 */           DeviceAuthDialog.this.dialog.setContentView(view);
/* 384 */           DeviceAuthDialog.this.startLogin(DeviceAuthDialog.this.mRequest);
/*     */         }
/* 386 */       });
/* 387 */     builder.create().show();
/*     */   }
/*     */   
/* 390 */   private void onSuccess(final String accessToken) { Bundle parameters = new Bundle();
/* 391 */     parameters.putString("fields", "id,permissions,name");
/*     */     
/*     */ 
/* 394 */     AccessToken temporaryToken = new AccessToken(accessToken, FacebookSdk.getApplicationId(), "0", null, null, null, null, null);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 402 */     GraphRequest request = new GraphRequest(temporaryToken, "me", parameters, HttpMethod.GET, new GraphRequest.Callback()
/*     */     {
/*     */ 
/*     */ 
/*     */       public void onCompleted(GraphResponse response)
/*     */       {
/*     */ 
/*     */ 
/* 410 */         if (DeviceAuthDialog.this.completed.get()) {
/* 411 */           return;
/*     */         }
/*     */         
/* 414 */         if (response.getError() != null) {
/* 415 */           DeviceAuthDialog.this.onError(response.getError().getException());
/* 416 */           return;
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */         try
/*     */         {
/* 423 */           JSONObject jsonObject = response.getJSONObject();
/* 424 */           String userId = jsonObject.getString("id");
/* 425 */           Utility.PermissionsPair permissions = Utility.handlePermissionResponse(jsonObject);
/* 426 */           name = jsonObject.getString("name");
/*     */         } catch (JSONException ex) { String name;
/* 428 */           DeviceAuthDialog.this.onError(new FacebookException(ex)); return; }
/*     */         String name;
/*     */         Utility.PermissionsPair permissions;
/* 431 */         String userId; DeviceRequestsHelper.cleanUpAdvertisementService(
/* 432 */           DeviceAuthDialog.this.currentRequestState.getUserCode());
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 437 */         boolean requireConfirm = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId()).getSmartLoginOptions().contains(SmartLoginOption.RequireConfirm);
/* 438 */         if ((requireConfirm) && (!DeviceAuthDialog.this.isRetry)) {
/* 439 */           DeviceAuthDialog.this.isRetry = true;
/* 440 */           DeviceAuthDialog.this.presentConfirmation(userId, permissions, accessToken, name);
/* 441 */           return;
/*     */         }
/*     */         
/* 444 */         DeviceAuthDialog.this.completeLogin(userId, permissions, accessToken);
/*     */       }
/* 446 */     });
/* 447 */     request.executeAsync();
/*     */   }
/*     */   
/*     */ 
/*     */   private void completeLogin(String userId, Utility.PermissionsPair permissions, String accessToken)
/*     */   {
/* 453 */     this.deviceAuthMethodHandler.onSuccess(accessToken, 
/*     */     
/* 455 */       FacebookSdk.getApplicationId(), userId, permissions
/*     */       
/* 457 */       .getGrantedPermissions(), permissions
/* 458 */       .getDeclinedPermissions(), AccessTokenSource.DEVICE_AUTH, null, null);
/*     */     
/*     */ 
/*     */ 
/* 462 */     this.dialog.dismiss();
/*     */   }
/*     */   
/*     */   private void onError(FacebookException ex) {
/* 466 */     if (!this.completed.compareAndSet(false, true)) {
/* 467 */       return;
/*     */     }
/*     */     
/* 470 */     if (this.currentRequestState != null) {
/* 471 */       DeviceRequestsHelper.cleanUpAdvertisementService(this.currentRequestState.getUserCode());
/*     */     }
/* 473 */     this.deviceAuthMethodHandler.onError(ex);
/* 474 */     this.dialog.dismiss();
/*     */   }
/*     */   
/*     */   private void onCancel() {
/* 478 */     if (!this.completed.compareAndSet(false, true))
/*     */     {
/* 480 */       return;
/*     */     }
/*     */     
/* 483 */     DeviceRequestsHelper.cleanUpAdvertisementService(this.currentRequestState.getUserCode());
/*     */     
/* 485 */     if (this.deviceAuthMethodHandler != null)
/*     */     {
/* 487 */       this.deviceAuthMethodHandler.onCancel();
/*     */     }
/*     */     
/* 490 */     this.dialog.dismiss();
/*     */   }
/*     */   
/*     */   private static class RequestState implements Parcelable {
/*     */     private String userCode;
/*     */     private String requestCode;
/*     */     private long interval;
/*     */     private long lastPoll;
/*     */     
/*     */     RequestState() {}
/*     */     
/*     */     public String getUserCode() {
/* 502 */       return this.userCode;
/*     */     }
/*     */     
/*     */     public void setUserCode(String userCode) {
/* 506 */       this.userCode = userCode;
/*     */     }
/*     */     
/*     */     public String getRequestCode() {
/* 510 */       return this.requestCode;
/*     */     }
/*     */     
/*     */     public void setRequestCode(String requestCode) {
/* 514 */       this.requestCode = requestCode;
/*     */     }
/*     */     
/*     */     public long getInterval() {
/* 518 */       return this.interval;
/*     */     }
/*     */     
/*     */     public void setInterval(long interval) {
/* 522 */       this.interval = interval;
/*     */     }
/*     */     
/*     */     public void setLastPoll(long lastPoll) {
/* 526 */       this.lastPoll = lastPoll;
/*     */     }
/*     */     
/*     */     protected RequestState(Parcel in) {
/* 530 */       this.userCode = in.readString();
/* 531 */       this.requestCode = in.readString();
/* 532 */       this.interval = in.readLong();
/* 533 */       this.lastPoll = in.readLong();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public boolean withinLastRefreshWindow()
/*     */     {
/* 541 */       if (this.lastPoll == 0L) {
/* 542 */         return false;
/*     */       }
/*     */       
/* 545 */       long diff = new Date().getTime() - this.lastPoll - this.interval * 1000L;
/* 546 */       return diff < 0L;
/*     */     }
/*     */     
/*     */     public int describeContents()
/*     */     {
/* 551 */       return 0;
/*     */     }
/*     */     
/*     */     public void writeToParcel(Parcel dest, int flags)
/*     */     {
/* 556 */       dest.writeString(this.userCode);
/* 557 */       dest.writeString(this.requestCode);
/* 558 */       dest.writeLong(this.interval);
/* 559 */       dest.writeLong(this.lastPoll);
/*     */     }
/*     */     
/*     */ 
/* 563 */     public static final Creator<RequestState> CREATOR = new Creator()
/*     */     {
/*     */       public RequestState createFromParcel(Parcel in)
/*     */       {
/* 567 */         return new RequestState(in);
/*     */       }
/*     */       
/*     */       public RequestState[] newArray(int size)
/*     */       {
/* 572 */         return new RequestState[size];
/*     */       }
/*     */     };
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/login/DeviceAuthDialog.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */