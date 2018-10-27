/*     */ package com.facebook.internal;
/*     */ 
/*     */ import android.annotation.SuppressLint;
/*     */ import android.app.Dialog;
/*     */ import android.app.ProgressDialog;
/*     */ import android.content.ActivityNotFoundException;
/*     */ import android.content.Context;
/*     */ import android.content.DialogInterface;
/*     */ import android.content.DialogInterface.OnCancelListener;
/*     */ import android.content.Intent;
/*     */ import android.content.res.Resources;
/*     */ import android.graphics.Bitmap;
/*     */ import android.graphics.drawable.Drawable;
/*     */ import android.net.Uri;
/*     */ import android.net.http.SslError;
/*     */ import android.os.AsyncTask;
/*     */ import android.os.AsyncTask.Status;
/*     */ import android.os.Bundle;
/*     */ import android.util.DisplayMetrics;
/*     */ import android.view.Display;
/*     */ import android.view.KeyEvent;
/*     */ import android.view.MotionEvent;
/*     */ import android.view.View;
/*     */ import android.view.View.OnClickListener;
/*     */ import android.view.View.OnTouchListener;
/*     */ import android.view.ViewGroup.LayoutParams;
/*     */ import android.view.Window;
/*     */ import android.view.WindowManager;
/*     */ import android.webkit.SslErrorHandler;
/*     */ import android.webkit.WebSettings;
/*     */ import android.webkit.WebView;
/*     */ import android.webkit.WebViewClient;
/*     */ import android.widget.FrameLayout;
/*     */ import android.widget.FrameLayout.LayoutParams;
/*     */ import android.widget.ImageView;
/*     */ import android.widget.LinearLayout;
/*     */ import com.facebook.AccessToken;
/*     */ import com.facebook.FacebookDialogException;
/*     */ import com.facebook.FacebookException;
/*     */ import com.facebook.FacebookGraphResponseException;
/*     */ import com.facebook.FacebookOperationCanceledException;
/*     */ import com.facebook.FacebookRequestError;
/*     */ import com.facebook.FacebookSdk;
/*     */ import com.facebook.FacebookServiceException;
/*     */ import com.facebook.GraphRequest;
/*     */ import com.facebook.GraphRequest.Callback;
/*     */ import com.facebook.GraphRequestAsyncTask;
/*     */ import com.facebook.GraphResponse;
/*     */ import com.facebook.R.drawable;
/*     */ import com.facebook.R.string;
/*     */ import com.facebook.share.internal.ShareInternalUtility;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.concurrent.ConcurrentLinkedQueue;
/*     */ import java.util.concurrent.CountDownLatch;
/*     */ import org.json.JSONArray;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WebDialog
/*     */   extends Dialog
/*     */ {
/*     */   private static final String LOG_TAG = "FacebookSDK.WebDialog";
/*     */   private static final String DISPLAY_TOUCH = "touch";
/*     */   private static final int API_EC_DIALOG_CANCEL = 4201;
/*     */   static final String REDIRECT_URI = "fbconnect://success";
/*     */   static final String CANCEL_URI = "fbconnect://cancel";
/*     */   static final boolean DISABLE_SSL_CHECK_FOR_TESTING = false;
/*     */   private static final int NO_PADDING_SCREEN_WIDTH = 480;
/*     */   private static final int MAX_PADDING_SCREEN_WIDTH = 800;
/*     */   private static final int NO_PADDING_SCREEN_HEIGHT = 800;
/*     */   private static final int MAX_PADDING_SCREEN_HEIGHT = 1280;
/*     */   private static final double MIN_SCALE_FACTOR = 0.5D;
/*     */   private static final int BACKGROUND_GRAY = -872415232;
/*     */   private String url;
/* 110 */   private String expectedRedirectUrl = "fbconnect://success";
/*     */   private OnCompleteListener onCompleteListener;
/*     */   private WebView webView;
/*     */   private ProgressDialog spinner;
/*     */   private ImageView crossImageView;
/*     */   private FrameLayout contentFrameLayout;
/*     */   private UploadStagingResourcesTask uploadTask;
/* 117 */   private boolean listenerCalled = false;
/* 118 */   private boolean isDetached = false;
/* 119 */   private boolean isPageFinished = false;
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
/*     */   public WebDialog(Context context, String url)
/*     */   {
/* 144 */     this(context, url, FacebookSdk.getWebDialogTheme());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public WebDialog(Context context, String url, int theme)
/*     */   {
/* 156 */     super(context, theme == 0 ? FacebookSdk.getWebDialogTheme() : theme);
/* 157 */     this.url = url;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public WebDialog(Context context, String action, Bundle parameters, int theme, OnCompleteListener listener)
/*     */   {
/* 170 */     super(context, theme == 0 ? FacebookSdk.getWebDialogTheme() : theme);
/*     */     
/* 172 */     if (parameters == null) {
/* 173 */       parameters = new Bundle();
/*     */     }
/*     */     
/*     */ 
/* 177 */     parameters.putString("redirect_uri", "fbconnect://success");
/*     */     
/* 179 */     parameters.putString("display", "touch");
/*     */     
/* 181 */     parameters.putString("sdk", 
/*     */     
/* 183 */       String.format(Locale.ROOT, "android-%s", new Object[] {FacebookSdk.getSdkVersion() }));
/*     */     
/* 185 */     this.onCompleteListener = listener;
/*     */     
/* 187 */     if ((action.equals("share")) && 
/* 188 */       (parameters.containsKey("media"))) {
/* 189 */       this.uploadTask = new UploadStagingResourcesTask(action, parameters);
/*     */     } else {
/* 191 */       Uri uri = Utility.buildUri(
/* 192 */         ServerProtocol.getDialogAuthority(), 
/* 193 */         FacebookSdk.getGraphApiVersion() + "/" + "dialog/" + action, parameters);
/*     */       
/* 195 */       this.url = uri.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOnCompleteListener(OnCompleteListener listener)
/*     */   {
/* 205 */     this.onCompleteListener = listener;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public OnCompleteListener getOnCompleteListener()
/*     */   {
/* 214 */     return this.onCompleteListener;
/*     */   }
/*     */   
/*     */   public boolean onKeyDown(int keyCode, KeyEvent event)
/*     */   {
/* 219 */     if (keyCode == 4) {
/* 220 */       cancel();
/*     */     }
/*     */     
/* 223 */     return super.onKeyDown(keyCode, event);
/*     */   }
/*     */   
/*     */   public void dismiss()
/*     */   {
/* 228 */     if (this.webView != null) {
/* 229 */       this.webView.stopLoading();
/*     */     }
/* 231 */     if ((!this.isDetached) && 
/* 232 */       (this.spinner != null) && (this.spinner.isShowing())) {
/* 233 */       this.spinner.dismiss();
/*     */     }
/*     */     
/* 236 */     super.dismiss();
/*     */   }
/*     */   
/*     */   protected void onStart()
/*     */   {
/* 241 */     super.onStart();
/* 242 */     if ((this.uploadTask != null) && (this.uploadTask.getStatus() == Status.PENDING)) {
/* 243 */       this.uploadTask.execute(new Void[0]);
/* 244 */       this.spinner.show();
/*     */     } else {
/* 246 */       resize();
/*     */     }
/*     */   }
/*     */   
/*     */   protected void onStop()
/*     */   {
/* 252 */     if (this.uploadTask != null) {
/* 253 */       this.uploadTask.cancel(true);
/* 254 */       this.spinner.dismiss();
/*     */     }
/* 256 */     super.onStop();
/*     */   }
/*     */   
/*     */   public void onDetachedFromWindow()
/*     */   {
/* 261 */     this.isDetached = true;
/* 262 */     super.onDetachedFromWindow();
/*     */   }
/*     */   
/*     */   public void onAttachedToWindow()
/*     */   {
/* 267 */     this.isDetached = false;
/* 268 */     super.onAttachedToWindow();
/*     */   }
/*     */   
/*     */   protected void onCreate(Bundle savedInstanceState)
/*     */   {
/* 273 */     super.onCreate(savedInstanceState);
/*     */     
/* 275 */     this.spinner = new ProgressDialog(getContext());
/* 276 */     this.spinner.requestWindowFeature(1);
/* 277 */     this.spinner.setMessage(getContext().getString(R.string.com_facebook_loading));
/*     */     
/* 279 */     this.spinner.setCanceledOnTouchOutside(false);
/* 280 */     this.spinner.setOnCancelListener(new OnCancelListener()
/*     */     {
/*     */       public void onCancel(DialogInterface dialogInterface) {
/* 283 */         WebDialog.this.cancel();
/*     */       }
/*     */       
/* 286 */     });
/* 287 */     requestWindowFeature(1);
/* 288 */     this.contentFrameLayout = new FrameLayout(getContext());
/*     */     
/*     */ 
/* 291 */     resize();
/* 292 */     getWindow().setGravity(17);
/*     */     
/*     */ 
/* 295 */     getWindow().setSoftInputMode(16);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 301 */     createCrossImage();
/*     */     
/* 303 */     if (this.url != null)
/*     */     {
/*     */ 
/*     */ 
/* 307 */       int crossWidth = this.crossImageView.getDrawable().getIntrinsicWidth();
/* 308 */       setUpWebView(crossWidth / 2 + 1);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 314 */     this.contentFrameLayout.addView(this.crossImageView, new ViewGroup.LayoutParams(-2, -2));
/*     */     
/*     */ 
/* 317 */     setContentView(this.contentFrameLayout);
/*     */   }
/*     */   
/*     */   protected void setExpectedRedirectUrl(String expectedRedirectUrl) {
/* 321 */     this.expectedRedirectUrl = expectedRedirectUrl;
/*     */   }
/*     */   
/*     */   protected Bundle parseResponseUri(String urlString) {
/* 325 */     Uri u = Uri.parse(urlString);
/*     */     
/* 327 */     Bundle b = Utility.parseUrlQueryString(u.getQuery());
/* 328 */     b.putAll(Utility.parseUrlQueryString(u.getFragment()));
/*     */     
/* 330 */     return b;
/*     */   }
/*     */   
/*     */   protected boolean isListenerCalled() {
/* 334 */     return this.listenerCalled;
/*     */   }
/*     */   
/*     */   protected boolean isPageFinished() {
/* 338 */     return this.isPageFinished;
/*     */   }
/*     */   
/*     */   protected WebView getWebView() {
/* 342 */     return this.webView;
/*     */   }
/*     */   
/*     */   public void resize() {
/* 346 */     WindowManager wm = (WindowManager)getContext().getSystemService("window");
/* 347 */     Display display = wm.getDefaultDisplay();
/* 348 */     DisplayMetrics metrics = new DisplayMetrics();
/* 349 */     display.getMetrics(metrics);
/*     */     
/*     */ 
/* 352 */     int width = metrics.widthPixels < metrics.heightPixels ? metrics.widthPixels : metrics.heightPixels;
/* 353 */     int height = metrics.widthPixels < metrics.heightPixels ? metrics.heightPixels : metrics.widthPixels;
/*     */     
/* 355 */     int dialogWidth = Math.min(
/* 356 */       getScaledSize(width, metrics.density, 480, 800), metrics.widthPixels);
/*     */     
/* 358 */     int dialogHeight = Math.min(
/* 359 */       getScaledSize(height, metrics.density, 800, 1280), metrics.heightPixels);
/*     */     
/*     */ 
/* 362 */     getWindow().setLayout(dialogWidth, dialogHeight);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getScaledSize(int screenSize, float density, int noPaddingSize, int maxPaddingSize)
/*     */   {
/* 374 */     int scaledSize = (int)(screenSize / density);
/*     */     double scaleFactor;
/* 376 */     double scaleFactor; if (scaledSize <= noPaddingSize) {
/* 377 */       scaleFactor = 1.0D; } else { double scaleFactor;
/* 378 */       if (scaledSize >= maxPaddingSize) {
/* 379 */         scaleFactor = 0.5D;
/*     */       }
/*     */       else
/*     */       {
/* 383 */         scaleFactor = 0.5D + (maxPaddingSize - scaledSize) / (maxPaddingSize - noPaddingSize) * 0.5D;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 388 */     return (int)(screenSize * scaleFactor);
/*     */   }
/*     */   
/*     */   protected void sendSuccessToListener(Bundle values) {
/* 392 */     if ((this.onCompleteListener != null) && (!this.listenerCalled)) {
/* 393 */       this.listenerCalled = true;
/* 394 */       this.onCompleteListener.onComplete(values, null);
/* 395 */       dismiss();
/*     */     }
/*     */   }
/*     */   
/*     */   protected void sendErrorToListener(Throwable error) {
/* 400 */     if ((this.onCompleteListener != null) && (!this.listenerCalled)) {
/* 401 */       this.listenerCalled = true;
/*     */       FacebookException facebookException;
/* 403 */       FacebookException facebookException; if ((error instanceof FacebookException)) {
/* 404 */         facebookException = (FacebookException)error;
/*     */       } else {
/* 406 */         facebookException = new FacebookException(error);
/*     */       }
/* 408 */       this.onCompleteListener.onComplete(null, facebookException);
/* 409 */       dismiss();
/*     */     }
/*     */   }
/*     */   
/*     */   public void cancel() {
/* 414 */     if ((this.onCompleteListener != null) && (!this.listenerCalled)) {
/* 415 */       sendErrorToListener(new FacebookOperationCanceledException());
/*     */     }
/*     */   }
/*     */   
/*     */   private void createCrossImage() {
/* 420 */     this.crossImageView = new ImageView(getContext());
/*     */     
/* 422 */     this.crossImageView.setOnClickListener(new View.OnClickListener()
/*     */     {
/*     */       public void onClick(View v) {
/* 425 */         WebDialog.this.cancel();
/*     */       }
/* 427 */     });
/* 428 */     Drawable crossDrawable = getContext().getResources().getDrawable(R.drawable.com_facebook_close);
/* 429 */     this.crossImageView.setImageDrawable(crossDrawable);
/*     */     
/*     */ 
/*     */ 
/* 433 */     this.crossImageView.setVisibility(4);
/*     */   }
/*     */   
/*     */   @SuppressLint({"SetJavaScriptEnabled"})
/*     */   private void setUpWebView(int margin) {
/* 438 */     LinearLayout webViewContainer = new LinearLayout(getContext());
/* 439 */     this.webView = new WebView(getContext().getApplicationContext())
/*     */     {
/*     */ 
/*     */       public void onWindowFocusChanged(boolean hasWindowFocus)
/*     */       {
/*     */         try
/*     */         {
/* 446 */           super.onWindowFocusChanged(hasWindowFocus);
/*     */         }
/*     */         catch (NullPointerException localNullPointerException) {}
/*     */       }
/* 450 */     };
/* 451 */     this.webView.setVerticalScrollBarEnabled(false);
/* 452 */     this.webView.setHorizontalScrollBarEnabled(false);
/* 453 */     this.webView.setWebViewClient(new DialogWebViewClient(null));
/* 454 */     this.webView.getSettings().setJavaScriptEnabled(true);
/* 455 */     this.webView.loadUrl(this.url);
/* 456 */     this.webView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
/*     */     
/* 458 */     this.webView.setVisibility(4);
/* 459 */     this.webView.getSettings().setSavePassword(false);
/* 460 */     this.webView.getSettings().setSaveFormData(false);
/* 461 */     this.webView.setFocusable(true);
/* 462 */     this.webView.setFocusableInTouchMode(true);
/* 463 */     this.webView.setOnTouchListener(new OnTouchListener()
/*     */     {
/*     */       public boolean onTouch(View v, MotionEvent event) {
/* 466 */         if (!v.hasFocus())
/*     */         {
/* 468 */           v.requestFocus();
/*     */         }
/* 470 */         return false;
/*     */       }
/*     */       
/* 473 */     });
/* 474 */     webViewContainer.setPadding(margin, margin, margin, margin);
/* 475 */     webViewContainer.addView(this.webView);
/* 476 */     webViewContainer.setBackgroundColor(-872415232);
/* 477 */     this.contentFrameLayout.addView(webViewContainer); }
/*     */   
/*     */   public static abstract interface OnCompleteListener { public abstract void onComplete(Bundle paramBundle, FacebookException paramFacebookException); }
/*     */   
/*     */   private class DialogWebViewClient extends WebViewClient { private DialogWebViewClient() {}
/*     */     
/* 483 */     public boolean shouldOverrideUrlLoading(WebView view, String url) { Utility.logd("FacebookSDK.WebDialog", "Redirect URL: " + url);
/* 484 */       if (url.startsWith(WebDialog.this.expectedRedirectUrl)) {
/* 485 */         Bundle values = WebDialog.this.parseResponseUri(url);
/*     */         
/* 487 */         String error = values.getString("error");
/* 488 */         if (error == null) {
/* 489 */           error = values.getString("error_type");
/*     */         }
/*     */         
/* 492 */         String errorMessage = values.getString("error_msg");
/* 493 */         if (errorMessage == null) {
/* 494 */           errorMessage = values.getString("error_message");
/*     */         }
/* 496 */         if (errorMessage == null) {
/* 497 */           errorMessage = values.getString("error_description");
/*     */         }
/* 499 */         String errorCodeString = values.getString("error_code");
/* 500 */         int errorCode = -1;
/* 501 */         if (!Utility.isNullOrEmpty(errorCodeString)) {
/*     */           try {
/* 503 */             errorCode = Integer.parseInt(errorCodeString);
/*     */           } catch (NumberFormatException ex) {
/* 505 */             errorCode = -1;
/*     */           }
/*     */         }
/*     */         
/* 509 */         if ((Utility.isNullOrEmpty(error)) && 
/* 510 */           (Utility.isNullOrEmpty(errorMessage)) && (errorCode == -1)) {
/* 511 */           WebDialog.this.sendSuccessToListener(values);
/* 512 */         } else if ((error != null) && ((error.equals("access_denied")) || 
/* 513 */           (error.equals("OAuthAccessDeniedException")))) {
/* 514 */           WebDialog.this.cancel();
/* 515 */         } else if (errorCode == 4201) {
/* 516 */           WebDialog.this.cancel();
/*     */         } else {
/* 518 */           FacebookRequestError requestError = new FacebookRequestError(errorCode, error, errorMessage);
/* 519 */           WebDialog.this.sendErrorToListener(new FacebookServiceException(requestError, errorMessage));
/*     */         }
/* 521 */         return true; }
/* 522 */       if (url.startsWith("fbconnect://cancel")) {
/* 523 */         WebDialog.this.cancel();
/* 524 */         return true; }
/* 525 */       if (url.contains("touch")) {
/* 526 */         return false;
/*     */       }
/*     */       try
/*     */       {
/* 530 */         WebDialog.this.getContext().startActivity(new Intent("android.intent.action.VIEW", 
/* 531 */           Uri.parse(url)));
/* 532 */         return true;
/*     */       } catch (ActivityNotFoundException e) {}
/* 534 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void onReceivedError(WebView view, int errorCode, String description, String failingUrl)
/*     */     {
/* 541 */       super.onReceivedError(view, errorCode, description, failingUrl);
/* 542 */       WebDialog.this.sendErrorToListener(new FacebookDialogException(description, errorCode, failingUrl));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error)
/*     */     {
/* 550 */       super.onReceivedSslError(view, handler, error);
/*     */       
/* 552 */       handler.cancel();
/* 553 */       WebDialog.this.sendErrorToListener(new FacebookDialogException(null, -11, null));
/*     */     }
/*     */     
/*     */ 
/*     */     public void onPageStarted(WebView view, String url, Bitmap favicon)
/*     */     {
/* 559 */       Utility.logd("FacebookSDK.WebDialog", "Webview loading URL: " + url);
/* 560 */       super.onPageStarted(view, url, favicon);
/* 561 */       if (!WebDialog.this.isDetached) {
/* 562 */         WebDialog.this.spinner.show();
/*     */       }
/*     */     }
/*     */     
/*     */     public void onPageFinished(WebView view, String url)
/*     */     {
/* 568 */       super.onPageFinished(view, url);
/* 569 */       if (!WebDialog.this.isDetached) {
/* 570 */         WebDialog.this.spinner.dismiss();
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 576 */       WebDialog.this.contentFrameLayout.setBackgroundColor(0);
/* 577 */       WebDialog.this.webView.setVisibility(0);
/* 578 */       WebDialog.this.crossImageView.setVisibility(0);
/* 579 */       WebDialog.this.isPageFinished = true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static class Builder
/*     */   {
/*     */     private Context context;
/*     */     
/*     */     private String applicationId;
/*     */     
/*     */     private String action;
/*     */     
/*     */     private int theme;
/*     */     
/*     */     private OnCompleteListener listener;
/*     */     
/*     */     private Bundle parameters;
/*     */     
/*     */     private AccessToken accessToken;
/*     */     
/*     */     public Builder(Context context, String action, Bundle parameters)
/*     */     {
/* 602 */       this.accessToken = AccessToken.getCurrentAccessToken();
/* 603 */       if (this.accessToken == null) {
/* 604 */         String applicationId = Utility.getMetadataApplicationId(context);
/* 605 */         if (applicationId != null) {
/* 606 */           this.applicationId = applicationId;
/*     */         } else {
/* 608 */           throw new FacebookException("Attempted to create a builder without a valid access token or a valid default Application ID.");
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 613 */       finishInit(context, action, parameters);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Builder(Context context, String applicationId, String action, Bundle parameters)
/*     */     {
/* 626 */       if (applicationId == null) {
/* 627 */         applicationId = Utility.getMetadataApplicationId(context);
/*     */       }
/* 629 */       Validate.notNullOrEmpty(applicationId, "applicationId");
/* 630 */       this.applicationId = applicationId;
/*     */       
/* 632 */       finishInit(context, action, parameters);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Builder setTheme(int theme)
/*     */     {
/* 642 */       this.theme = theme;
/* 643 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Builder setOnCompleteListener(OnCompleteListener listener)
/*     */     {
/* 653 */       this.listener = listener;
/* 654 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public WebDialog build()
/*     */     {
/* 664 */       if (this.accessToken != null) {
/* 665 */         this.parameters.putString("app_id", this.accessToken
/*     */         
/* 667 */           .getApplicationId());
/* 668 */         this.parameters.putString("access_token", this.accessToken
/*     */         
/* 670 */           .getToken());
/*     */       } else {
/* 672 */         this.parameters.putString("app_id", this.applicationId);
/*     */       }
/*     */       
/* 675 */       return new WebDialog(this.context, this.action, this.parameters, this.theme, this.listener);
/*     */     }
/*     */     
/*     */     public String getApplicationId() {
/* 679 */       return this.applicationId;
/*     */     }
/*     */     
/*     */     public Context getContext() {
/* 683 */       return this.context;
/*     */     }
/*     */     
/*     */     public int getTheme() {
/* 687 */       return this.theme;
/*     */     }
/*     */     
/*     */     public Bundle getParameters() {
/* 691 */       return this.parameters;
/*     */     }
/*     */     
/*     */     public OnCompleteListener getListener() {
/* 695 */       return this.listener;
/*     */     }
/*     */     
/*     */     private void finishInit(Context context, String action, Bundle parameters) {
/* 699 */       this.context = context;
/* 700 */       this.action = action;
/* 701 */       if (parameters != null) {
/* 702 */         this.parameters = parameters;
/*     */       } else {
/* 704 */         this.parameters = new Bundle();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private class UploadStagingResourcesTask extends AsyncTask<Void, Void, String[]> {
/*     */     private String action;
/*     */     private Bundle parameters;
/*     */     private Exception[] exceptions;
/*     */     
/*     */     UploadStagingResourcesTask(String action, Bundle parameters) {
/* 715 */       this.action = action;
/* 716 */       this.parameters = parameters;
/*     */     }
/*     */     
/*     */ 
/*     */     protected String[] doInBackground(Void... args)
/*     */     {
/* 722 */       String[] params = this.parameters.getStringArray("media");
/* 723 */       final String[] results = new String[params.length];
/* 724 */       this.exceptions = new Exception[params.length];
/*     */       
/* 726 */       final CountDownLatch latch = new CountDownLatch(params.length);
/* 727 */       ConcurrentLinkedQueue<GraphRequestAsyncTask> tasks = new ConcurrentLinkedQueue();
/*     */       
/*     */ 
/* 730 */       AccessToken accessToken = AccessToken.getCurrentAccessToken();
/*     */       try {
/* 732 */         for (int i = 0; i < params.length; i++) {
/* 733 */           if (isCancelled()) {
/* 734 */             for (AsyncTask task : tasks) {
/* 735 */               task.cancel(true);
/*     */             }
/* 737 */             return null;
/*     */           }
/* 739 */           uri = Uri.parse(params[i]);
/* 740 */           final int writeIndex = i;
/* 741 */           if (Utility.isWebUri((Uri)uri)) {
/* 742 */             results[writeIndex] = ((Uri)uri).toString();
/* 743 */             latch.countDown();
/*     */           }
/*     */           else {
/* 746 */             GraphRequest.Callback callback = new GraphRequest.Callback()
/*     */             {
/*     */               public void onCompleted(GraphResponse response) {
/*     */                 try {
/* 750 */                   FacebookRequestError error = response.getError();
/* 751 */                   if (error != null) {
/* 752 */                     String message = error.getErrorMessage();
/* 753 */                     if (message == null) {
/* 754 */                       message = "Error staging photo.";
/*     */                     }
/* 756 */                     throw new FacebookGraphResponseException(response, message);
/*     */                   }
/* 758 */                   JSONObject data = response.getJSONObject();
/* 759 */                   if (data == null) {
/* 760 */                     throw new FacebookException("Error staging photo.");
/*     */                   }
/* 762 */                   String stagedImageUri = data.optString("uri");
/* 763 */                   if (stagedImageUri == null) {
/* 764 */                     throw new FacebookException("Error staging photo.");
/*     */                   }
/* 766 */                   results[writeIndex] = stagedImageUri;
/*     */                 } catch (Exception e) {
/* 768 */                   UploadStagingResourcesTask.this.exceptions[writeIndex] = e;
/*     */                 }
/* 770 */                 latch.countDown();
/*     */ 
/*     */ 
/*     */               }
/*     */               
/*     */ 
/*     */ 
/* 777 */             };
/* 778 */             GraphRequestAsyncTask task = ShareInternalUtility.newUploadStagingResourceWithImageRequest(accessToken, (Uri)uri, callback).executeAsync();
/* 779 */             tasks.add(task);
/*     */           } }
/* 781 */         latch.await();
/*     */       } catch (Exception e) {
/* 783 */         for (Object uri = tasks.iterator(); ((Iterator)uri).hasNext();) { AsyncTask task = (AsyncTask)((Iterator)uri).next();
/* 784 */           task.cancel(true);
/*     */         }
/* 786 */         return null;
/*     */       }
/*     */       
/* 789 */       return results;
/*     */     }
/*     */     
/*     */     protected void onPostExecute(String[] results)
/*     */     {
/* 794 */       WebDialog.this.spinner.dismiss();
/*     */       
/* 796 */       for (Exception e : this.exceptions) {
/* 797 */         if (e != null) {
/* 798 */           WebDialog.this.sendErrorToListener(e);
/* 799 */           return;
/*     */         }
/*     */       }
/*     */       
/* 803 */       if (results == null) {
/* 804 */         WebDialog.this.sendErrorToListener(new FacebookException("Failed to stage photos for web dialog"));
/* 805 */         return;
/*     */       }
/*     */       
/* 808 */       Object resultList = Arrays.asList(results);
/* 809 */       if (((List)resultList).contains(null)) {
/* 810 */         WebDialog.this.sendErrorToListener(new FacebookException("Failed to stage photos for web dialog"));
/* 811 */         return;
/*     */       }
/*     */       
/* 814 */       Utility.putJSONValueInBundle(this.parameters, "media", new JSONArray((Collection)resultList));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 819 */       Uri uri = Utility.buildUri(
/* 820 */         ServerProtocol.getDialogAuthority(), 
/* 821 */         FacebookSdk.getGraphApiVersion() + "/" + "dialog/" + this.action, this.parameters);
/*     */       
/*     */ 
/* 824 */       WebDialog.this.url = uri.toString();
/* 825 */       int crossWidth = WebDialog.this.crossImageView.getDrawable().getIntrinsicWidth();
/* 826 */       WebDialog.this.setUpWebView(crossWidth / 2 + 1);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/WebDialog.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */