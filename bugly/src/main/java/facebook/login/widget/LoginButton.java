/*     */ package com.facebook.login.widget;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.app.AlertDialog;
/*     */ import android.app.AlertDialog.Builder;
/*     */ import android.content.Context;
/*     */ import android.content.DialogInterface;
/*     */ import android.content.DialogInterface.OnClickListener;
/*     */ import android.content.res.Resources;
/*     */ import android.content.res.Resources.Theme;
/*     */ import android.content.res.TypedArray;
/*     */ import android.graphics.Canvas;
/*     */ import android.graphics.Paint.FontMetrics;
/*     */ import android.os.Bundle;
/*     */ import android.text.TextPaint;
/*     */ import android.util.AttributeSet;
/*     */ import android.view.View;
/*     */ import android.view.View.OnClickListener;
/*     */ import com.facebook.AccessToken;
/*     */ import com.facebook.AccessTokenTracker;
/*     */ import com.facebook.CallbackManager;
/*     */ import com.facebook.FacebookButtonBase;
/*     */ import com.facebook.FacebookCallback;
/*     */ import com.facebook.FacebookSdk;
/*     */ import com.facebook.Profile;
/*     */ import com.facebook.R.color;
/*     */ import com.facebook.R.string;
/*     */ import com.facebook.R.style;
/*     */ import com.facebook.R.styleable;
/*     */ import com.facebook.appevents.AppEventsLogger;
/*     */ import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
/*     */ import com.facebook.internal.FetchedAppSettings;
/*     */ import com.facebook.internal.FetchedAppSettingsManager;
/*     */ import com.facebook.internal.LoginAuthorizationType;
/*     */ import com.facebook.internal.Utility;
/*     */ import com.facebook.login.DefaultAudience;
/*     */ import com.facebook.login.LoginBehavior;
/*     */ import com.facebook.login.LoginManager;
/*     */ import com.facebook.login.LoginResult;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.Executor;
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
/*     */ public class LoginButton
/*     */   extends FacebookButtonBase
/*     */ {
/*     */   public static enum ToolTipMode
/*     */   {
/*  77 */     AUTOMATIC("automatic", 0), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  82 */     DISPLAY_ALWAYS("display_always", 1), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  87 */     NEVER_DISPLAY("never_display", 2);
/*     */     
/*  89 */     public static ToolTipMode DEFAULT = AUTOMATIC;
/*     */     private String stringValue;
/*     */     
/*  92 */     public static ToolTipMode fromInt(int enumValue) { for (ToolTipMode mode : ) {
/*  93 */         if (mode.getValue() == enumValue) {
/*  94 */           return mode;
/*     */         }
/*     */       }
/*     */       
/*  98 */       return null;
/*     */     }
/*     */     
/*     */     private int intValue;
/*     */     private ToolTipMode(String stringValue, int value)
/*     */     {
/* 104 */       this.stringValue = stringValue;
/* 105 */       this.intValue = value;
/*     */     }
/*     */     
/*     */     public String toString()
/*     */     {
/* 110 */       return this.stringValue;
/*     */     }
/*     */     
/*     */     public int getValue() {
/* 114 */       return this.intValue;
/*     */     }
/*     */   }
/*     */   
/* 118 */   private static final String TAG = LoginButton.class.getName();
/*     */   private boolean confirmLogout;
/*     */   private String loginText;
/*     */   private String logoutText;
/* 122 */   private LoginButtonProperties properties = new LoginButtonProperties();
/* 123 */   private String loginLogoutEventName = "fb_login_view_usage";
/*     */   private boolean toolTipChecked;
/* 125 */   private ToolTipPopup.Style toolTipStyle = ToolTipPopup.Style.BLUE;
/*     */   private ToolTipMode toolTipMode;
/* 127 */   private long toolTipDisplayTime = 6000L;
/*     */   private ToolTipPopup toolTipPopup;
/*     */   private AccessTokenTracker accessTokenTracker;
/*     */   private LoginManager loginManager;
/*     */   
/*     */   static class LoginButtonProperties {
/* 133 */     private DefaultAudience defaultAudience = DefaultAudience.FRIENDS;
/* 134 */     private List<String> permissions = Collections.emptyList();
/* 135 */     private LoginAuthorizationType authorizationType = null;
/* 136 */     private LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
/*     */     
/*     */     public void setDefaultAudience(DefaultAudience defaultAudience) {
/* 139 */       this.defaultAudience = defaultAudience;
/*     */     }
/*     */     
/*     */     public DefaultAudience getDefaultAudience() {
/* 143 */       return this.defaultAudience;
/*     */     }
/*     */     
/*     */     public void setReadPermissions(List<String> permissions)
/*     */     {
/* 148 */       if (LoginAuthorizationType.PUBLISH.equals(this.authorizationType)) {
/* 149 */         throw new UnsupportedOperationException("Cannot call setReadPermissions after setPublishPermissions has been called.");
/*     */       }
/*     */       
/* 152 */       this.permissions = permissions;
/* 153 */       this.authorizationType = LoginAuthorizationType.READ;
/*     */     }
/*     */     
/*     */     public void setPublishPermissions(List<String> permissions)
/*     */     {
/* 158 */       if (LoginAuthorizationType.READ.equals(this.authorizationType)) {
/* 159 */         throw new UnsupportedOperationException("Cannot call setPublishPermissions after setReadPermissions has been called.");
/*     */       }
/*     */       
/* 162 */       if (Utility.isNullOrEmpty(permissions)) {
/* 163 */         throw new IllegalArgumentException("Permissions for publish actions cannot be null or empty.");
/*     */       }
/*     */       
/* 166 */       this.permissions = permissions;
/* 167 */       this.authorizationType = LoginAuthorizationType.PUBLISH;
/*     */     }
/*     */     
/*     */     List<String> getPermissions() {
/* 171 */       return this.permissions;
/*     */     }
/*     */     
/*     */     public void clearPermissions() {
/* 175 */       this.permissions = null;
/* 176 */       this.authorizationType = null;
/*     */     }
/*     */     
/*     */     public void setLoginBehavior(LoginBehavior loginBehavior) {
/* 180 */       this.loginBehavior = loginBehavior;
/*     */     }
/*     */     
/*     */     public LoginBehavior getLoginBehavior() {
/* 184 */       return this.loginBehavior;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public LoginButton(Context context)
/*     */   {
/* 194 */     super(context, null, 0, 0, "fb_login_button_create", "fb_login_button_did_tap");
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
/*     */ 
/*     */ 
/*     */   public LoginButton(Context context, AttributeSet attrs)
/*     */   {
/* 209 */     super(context, attrs, 0, 0, "fb_login_button_create", "fb_login_button_did_tap");
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
/*     */ 
/*     */ 
/*     */   public LoginButton(Context context, AttributeSet attrs, int defStyle)
/*     */   {
/* 224 */     super(context, attrs, defStyle, 0, "fb_login_button_create", "fb_login_button_did_tap");
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDefaultAudience(DefaultAudience defaultAudience)
/*     */   {
/* 241 */     this.properties.setDefaultAudience(defaultAudience);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public DefaultAudience getDefaultAudience()
/*     */   {
/* 252 */     return this.properties.getDefaultAudience();
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
/*     */   public void setReadPermissions(List<String> permissions)
/*     */   {
/* 275 */     this.properties.setReadPermissions(permissions);
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
/*     */   public void setReadPermissions(String... permissions)
/*     */   {
/* 298 */     this.properties.setReadPermissions(Arrays.asList(permissions));
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
/*     */   public void setPublishPermissions(List<String> permissions)
/*     */   {
/* 323 */     this.properties.setPublishPermissions(permissions);
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
/*     */   public void setPublishPermissions(String... permissions)
/*     */   {
/* 347 */     this.properties.setPublishPermissions(Arrays.asList(permissions));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void clearPermissions()
/*     */   {
/* 355 */     this.properties.clearPermissions();
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
/*     */   public void setLoginBehavior(LoginBehavior loginBehavior)
/*     */   {
/* 368 */     this.properties.setLoginBehavior(loginBehavior);
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
/*     */   public LoginBehavior getLoginBehavior()
/*     */   {
/* 381 */     return this.properties.getLoginBehavior();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setToolTipStyle(ToolTipPopup.Style toolTipStyle)
/*     */   {
/* 391 */     this.toolTipStyle = toolTipStyle;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setToolTipMode(ToolTipMode toolTipMode)
/*     */   {
/* 402 */     this.toolTipMode = toolTipMode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ToolTipMode getToolTipMode()
/*     */   {
/* 411 */     return this.toolTipMode;
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
/*     */   public void setToolTipDisplayTime(long displayTime)
/*     */   {
/* 424 */     this.toolTipDisplayTime = displayTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getToolTipDisplayTime()
/*     */   {
/* 433 */     return this.toolTipDisplayTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void dismissToolTip()
/*     */   {
/* 440 */     if (this.toolTipPopup != null) {
/* 441 */       this.toolTipPopup.dismiss();
/* 442 */       this.toolTipPopup = null;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void registerCallback(CallbackManager callbackManager, FacebookCallback<LoginResult> callback)
/*     */   {
/* 455 */     getLoginManager().registerCallback(callbackManager, callback);
/*     */   }
/*     */   
/*     */   protected void onAttachedToWindow()
/*     */   {
/* 460 */     super.onAttachedToWindow();
/* 461 */     if ((this.accessTokenTracker != null) && (!this.accessTokenTracker.isTracking())) {
/* 462 */       this.accessTokenTracker.startTracking();
/* 463 */       setButtonText();
/*     */     }
/*     */   }
/*     */   
/*     */   protected void onDraw(Canvas canvas)
/*     */   {
/* 469 */     super.onDraw(canvas);
/*     */     
/* 471 */     if ((!this.toolTipChecked) && (!isInEditMode())) {
/* 472 */       this.toolTipChecked = true;
/* 473 */       checkToolTipSettings();
/*     */     }
/*     */   }
/*     */   
/*     */   private void showToolTipPerSettings(FetchedAppSettings settings) {
/* 478 */     if ((settings != null) && (settings.getNuxEnabled()) && (getVisibility() == 0)) {
/* 479 */       String toolTipString = settings.getNuxContent();
/* 480 */       displayToolTip(toolTipString);
/*     */     }
/*     */   }
/*     */   
/*     */   private void displayToolTip(String toolTipString) {
/* 485 */     this.toolTipPopup = new ToolTipPopup(toolTipString, this);
/* 486 */     this.toolTipPopup.setStyle(this.toolTipStyle);
/* 487 */     this.toolTipPopup.setNuxDisplayTime(this.toolTipDisplayTime);
/* 488 */     this.toolTipPopup.show();
/*     */   }
/*     */   
/*     */   private void checkToolTipSettings() {
/* 492 */     switch (this.toolTipMode)
/*     */     {
/*     */     case AUTOMATIC: 
/* 495 */       final String appId = Utility.getMetadataApplicationId(getContext());
/* 496 */       FacebookSdk.getExecutor().execute(new Runnable()
/*     */       {
/*     */         public void run() {
/* 499 */           final FetchedAppSettings settings = FetchedAppSettingsManager.queryAppSettings(appId, false);
/* 500 */           LoginButton.this.getActivity().runOnUiThread(new Runnable()
/*     */           {
/*     */             public void run() {
/* 503 */               LoginButton.this.showToolTipPerSettings(settings);
/*     */             }
/*     */           });
/*     */         }
/* 507 */       });
/* 508 */       break;
/*     */     case DISPLAY_ALWAYS: 
/* 510 */       String toolTipString = getResources().getString(R.string.com_facebook_tooltip_default);
/*     */       
/* 512 */       displayToolTip(toolTipString);
/* 513 */       break;
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onLayout(boolean changed, int left, int top, int right, int bottom)
/*     */   {
/* 521 */     super.onLayout(changed, left, top, right, bottom);
/* 522 */     setButtonText();
/*     */   }
/*     */   
/*     */   protected void onDetachedFromWindow()
/*     */   {
/* 527 */     super.onDetachedFromWindow();
/* 528 */     if (this.accessTokenTracker != null) {
/* 529 */       this.accessTokenTracker.stopTracking();
/*     */     }
/* 531 */     dismissToolTip();
/*     */   }
/*     */   
/*     */   protected void onVisibilityChanged(View changedView, int visibility)
/*     */   {
/* 536 */     super.onVisibilityChanged(changedView, visibility);
/*     */     
/* 538 */     if (visibility != 0) {
/* 539 */       dismissToolTip();
/*     */     }
/*     */   }
/*     */   
/*     */   List<String> getPermissions()
/*     */   {
/* 545 */     return this.properties.getPermissions();
/*     */   }
/*     */   
/*     */   void setProperties(LoginButtonProperties properties) {
/* 549 */     this.properties = properties;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void configureButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
/*     */   {
/* 558 */     super.configureButton(context, attrs, defStyleAttr, defStyleRes);
/* 559 */     setInternalOnClickListener(getNewLoginClickListener());
/*     */     
/* 561 */     parseLoginButtonAttributes(context, attrs, defStyleAttr, defStyleRes);
/*     */     
/* 563 */     if (isInEditMode())
/*     */     {
/*     */ 
/* 566 */       setBackgroundColor(getResources().getColor(R.color.com_facebook_blue));
/*     */       
/*     */ 
/* 569 */       this.loginText = "Log in with Facebook";
/*     */     } else {
/* 571 */       this.accessTokenTracker = new AccessTokenTracker()
/*     */       {
/*     */ 
/*     */         protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken)
/*     */         {
/* 576 */           LoginButton.this.setButtonText();
/*     */         }
/*     */       };
/*     */     }
/*     */     
/* 581 */     setButtonText();
/*     */   }
/*     */   
/*     */   protected LoginClickListener getNewLoginClickListener() {
/* 585 */     return new LoginClickListener();
/*     */   }
/*     */   
/*     */   protected int getDefaultStyleResource()
/*     */   {
/* 590 */     return R.style.com_facebook_loginview_default_style;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void parseLoginButtonAttributes(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
/*     */   {
/* 598 */     this.toolTipMode = ToolTipMode.DEFAULT;
/* 599 */     TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.com_facebook_login_view, defStyleAttr, defStyleRes);
/*     */     
/*     */ 
/*     */ 
/*     */     try
/*     */     {
/* 605 */       this.confirmLogout = a.getBoolean(R.styleable.com_facebook_login_view_com_facebook_confirm_logout, true);
/* 606 */       this.loginText = a.getString(R.styleable.com_facebook_login_view_com_facebook_login_text);
/* 607 */       this.logoutText = a.getString(R.styleable.com_facebook_login_view_com_facebook_logout_text);
/* 608 */       this.toolTipMode = ToolTipMode.fromInt(a.getInt(R.styleable.com_facebook_login_view_com_facebook_tooltip_mode, ToolTipMode.DEFAULT
/*     */       
/* 610 */         .getValue()));
/*     */     } finally {
/* 612 */       a.recycle();
/*     */     }
/*     */   }
/*     */   
/*     */   protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
/*     */   {
/* 618 */     Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
/*     */     
/*     */ 
/* 621 */     int height = getCompoundPaddingTop() + (int)Math.ceil(Math.abs(fontMetrics.top) + Math.abs(fontMetrics.bottom)) + getCompoundPaddingBottom();
/*     */     
/* 623 */     Resources resources = getResources();
/* 624 */     String text = this.loginText;
/*     */     
/*     */ 
/* 627 */     if (text == null) {
/* 628 */       text = resources.getString(R.string.com_facebook_loginview_log_in_button_long);
/* 629 */       int logInWidth = measureButtonWidth(text);
/* 630 */       int width = resolveSize(logInWidth, widthMeasureSpec);
/* 631 */       if (width < logInWidth) {
/* 632 */         text = resources.getString(R.string.com_facebook_loginview_log_in_button);
/*     */       }
/*     */     }
/* 635 */     int logInWidth = measureButtonWidth(text);
/*     */     
/* 637 */     text = this.logoutText;
/* 638 */     if (text == null) {
/* 639 */       text = resources.getString(R.string.com_facebook_loginview_log_out_button);
/*     */     }
/* 641 */     int logOutWidth = measureButtonWidth(text);
/*     */     
/* 643 */     int width = resolveSize(Math.max(logInWidth, logOutWidth), widthMeasureSpec);
/* 644 */     setMeasuredDimension(width, height);
/*     */   }
/*     */   
/*     */   private int measureButtonWidth(String text) {
/* 648 */     int textWidth = measureTextWidth(text);
/*     */     
/*     */ 
/*     */ 
/* 652 */     return getCompoundPaddingLeft() + getCompoundDrawablePadding() + textWidth + getCompoundPaddingRight();
/*     */   }
/*     */   
/*     */   private void setButtonText() {
/* 656 */     Resources resources = getResources();
/* 657 */     if ((!isInEditMode()) && (AccessToken.getCurrentAccessToken() != null)) {
/* 658 */       setText(this.logoutText != null ? this.logoutText : resources
/*     */       
/* 660 */         .getString(R.string.com_facebook_loginview_log_out_button));
/*     */     }
/* 662 */     else if (this.loginText != null) {
/* 663 */       setText(this.loginText);
/*     */     } else {
/* 665 */       String text = resources.getString(R.string.com_facebook_loginview_log_in_button_long);
/*     */       
/* 667 */       int width = getWidth();
/*     */       
/* 669 */       if (width != 0)
/*     */       {
/* 671 */         int measuredWidth = measureButtonWidth(text);
/* 672 */         if (measuredWidth > width)
/*     */         {
/* 674 */           text = resources.getString(R.string.com_facebook_loginview_log_in_button);
/*     */         }
/*     */       }
/* 677 */       setText(text);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   protected int getDefaultRequestCode()
/*     */   {
/* 684 */     return CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
/*     */   }
/*     */   
/*     */   LoginManager getLoginManager() {
/* 688 */     if (this.loginManager == null) {
/* 689 */       this.loginManager = LoginManager.getInstance();
/*     */     }
/* 691 */     return this.loginManager;
/*     */   }
/*     */   
/*     */ 
/* 695 */   void setLoginManager(LoginManager loginManager) { this.loginManager = loginManager; }
/*     */   
/*     */   protected class LoginClickListener implements View.OnClickListener {
/*     */     protected LoginClickListener() {}
/*     */     
/*     */     public void onClick(View v) {
/* 701 */       LoginButton.this.callExternalOnClickListener(v);
/*     */       
/* 703 */       AccessToken accessToken = AccessToken.getCurrentAccessToken();
/* 704 */       if (accessToken != null)
/*     */       {
/* 706 */         performLogout(LoginButton.this.getContext());
/*     */       } else {
/* 708 */         performLogin();
/*     */       }
/*     */       
/* 711 */       AppEventsLogger logger = AppEventsLogger.newLogger(LoginButton.this.getContext());
/*     */       
/* 713 */       Bundle parameters = new Bundle();
/* 714 */       parameters.putInt("logging_in", accessToken != null ? 0 : 1);
/*     */       
/* 716 */       logger.logSdkEvent(LoginButton.this.loginLogoutEventName, null, parameters);
/*     */     }
/*     */     
/*     */     protected void performLogin() {
/* 720 */       LoginManager loginManager = getLoginManager();
/* 721 */       if (LoginAuthorizationType.PUBLISH.equals(LoginButtonProperties.access$600(LoginButton.this.properties))) {
/* 722 */         if (LoginButton.this.getFragment() != null) {
/* 723 */           loginManager.logInWithPublishPermissions(LoginButton.this
/* 724 */             .getFragment(), 
/* 725 */             LoginButtonProperties.access$700(LoginButton.this.properties));
/* 726 */         } else if (LoginButton.this.getNativeFragment() != null) {
/* 727 */           loginManager.logInWithPublishPermissions(LoginButton.this
/* 728 */             .getNativeFragment(), 
/* 729 */             LoginButtonProperties.access$700(LoginButton.this.properties));
/*     */         } else {
/* 731 */           loginManager.logInWithPublishPermissions(LoginButton.this
/* 732 */             .getActivity(), 
/* 733 */             LoginButtonProperties.access$700(LoginButton.this.properties));
/*     */         }
/*     */       }
/* 736 */       else if (LoginButton.this.getFragment() != null) {
/* 737 */         loginManager.logInWithReadPermissions(LoginButton.this
/* 738 */           .getFragment(), 
/* 739 */           LoginButtonProperties.access$700(LoginButton.this.properties));
/* 740 */       } else if (LoginButton.this.getNativeFragment() != null) {
/* 741 */         loginManager.logInWithReadPermissions(LoginButton.this
/* 742 */           .getNativeFragment(), 
/* 743 */           LoginButtonProperties.access$700(LoginButton.this.properties));
/*     */       } else {
/* 745 */         loginManager.logInWithReadPermissions(LoginButton.this
/* 746 */           .getActivity(), 
/* 747 */           LoginButtonProperties.access$700(LoginButton.this.properties));
/*     */       }
/*     */     }
/*     */     
/*     */     protected void performLogout(Context context)
/*     */     {
/* 753 */       final LoginManager loginManager = getLoginManager();
/* 754 */       if (LoginButton.this.confirmLogout)
/*     */       {
/* 756 */         String logout = LoginButton.this.getResources().getString(R.string.com_facebook_loginview_log_out_action);
/*     */         
/* 758 */         String cancel = LoginButton.this.getResources().getString(R.string.com_facebook_loginview_cancel_action);
/*     */         
/*     */ 
/* 761 */         Profile profile = Profile.getCurrentProfile();
/* 762 */         String message; String message; if ((profile != null) && (profile.getName() != null)) {
/* 763 */           message = String.format(LoginButton.this
/* 764 */             .getResources().getString(R.string.com_facebook_loginview_logged_in_as), new Object[] {profile
/*     */             
/* 766 */             .getName() });
/*     */         } else {
/* 768 */           message = LoginButton.this.getResources().getString(R.string.com_facebook_loginview_logged_in_using_facebook);
/*     */         }
/*     */         
/* 771 */         Builder builder = new Builder(context);
/* 772 */         builder.setMessage(message)
/* 773 */           .setCancelable(true)
/* 774 */           .setPositiveButton(logout, new DialogInterface.OnClickListener()
/*     */           {
/*     */ 
/* 776 */             public void onClick(DialogInterface dialog, int which) { loginManager.logOut(); } })
/*     */           
/*     */ 
/* 779 */           .setNegativeButton(cancel, null);
/* 780 */         builder.create().show();
/*     */       } else {
/* 782 */         loginManager.logOut();
/*     */       }
/*     */     }
/*     */     
/*     */     protected LoginManager getLoginManager() {
/* 787 */       LoginManager manager = LoginManager.getInstance();
/* 788 */       manager.setDefaultAudience(LoginButton.this.getDefaultAudience());
/* 789 */       manager.setLoginBehavior(LoginButton.this.getLoginBehavior());
/* 790 */       return manager;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/login/widget/LoginButton.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */