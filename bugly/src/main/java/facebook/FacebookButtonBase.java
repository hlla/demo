/*     */ package com.facebook;
/*     */ 
/*     */ import android.annotation.SuppressLint;
/*     */ import android.app.Activity;
/*     */ import android.content.Context;
/*     */ import android.content.ContextWrapper;
/*     */ import android.content.res.Resources.Theme;
/*     */ import android.content.res.TypedArray;
/*     */ import android.graphics.Canvas;
/*     */ import android.graphics.Typeface;
/*     */ import android.support.v4.content.ContextCompat;
/*     */ import android.text.TextPaint;
/*     */ import android.util.AttributeSet;
/*     */ import android.view.View;
/*     */ import android.view.View.OnClickListener;
/*     */ import android.widget.Button;
/*     */ import com.facebook.appevents.AppEventsLogger;
/*     */ import com.facebook.internal.FragmentWrapper;
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
/*     */ public abstract class FacebookButtonBase
/*     */   extends Button
/*     */ {
/*     */   private String analyticsButtonCreatedEventName;
/*     */   private String analyticsButtonTappedEventName;
/*     */   private OnClickListener externalOnClickListener;
/*     */   private OnClickListener internalOnClickListener;
/*     */   private boolean overrideCompoundPadding;
/*     */   private int overrideCompoundPaddingLeft;
/*     */   private int overrideCompoundPaddingRight;
/*     */   private FragmentWrapper parentFragment;
/*     */   
/*     */   protected FacebookButtonBase(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes, String analyticsButtonCreatedEventName, String analyticsButtonTappedEventName)
/*     */   {
/*  61 */     super(context, attrs, 0);
/*  62 */     defStyleRes = defStyleRes == 0 ? getDefaultStyleResource() : defStyleRes;
/*  63 */     defStyleRes = defStyleRes == 0 ? R.style.com_facebook_button : defStyleRes;
/*  64 */     configureButton(context, attrs, defStyleAttr, defStyleRes);
/*  65 */     this.analyticsButtonCreatedEventName = analyticsButtonCreatedEventName;
/*  66 */     this.analyticsButtonTappedEventName = analyticsButtonTappedEventName;
/*  67 */     setClickable(true);
/*  68 */     setFocusable(true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected abstract int getDefaultRequestCode();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFragment(android.support.v4.app.Fragment fragment)
/*     */   {
/*  82 */     this.parentFragment = new FragmentWrapper(fragment);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFragment(android.app.Fragment fragment)
/*     */   {
/*  94 */     this.parentFragment = new FragmentWrapper(fragment);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public android.support.v4.app.Fragment getFragment()
/*     */   {
/* 102 */     return this.parentFragment != null ? this.parentFragment.getSupportFragment() : null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public android.app.Fragment getNativeFragment()
/*     */   {
/* 110 */     return this.parentFragment != null ? this.parentFragment.getNativeFragment() : null;
/*     */   }
/*     */   
/*     */   public void setOnClickListener(OnClickListener l)
/*     */   {
/* 115 */     this.externalOnClickListener = l;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getRequestCode()
/*     */   {
/* 124 */     return getDefaultRequestCode();
/*     */   }
/*     */   
/*     */   protected void onAttachedToWindow()
/*     */   {
/* 129 */     super.onAttachedToWindow();
/* 130 */     if (!isInEditMode()) {
/* 131 */       logButtonCreated(getContext());
/*     */     }
/*     */   }
/*     */   
/*     */   protected void onDraw(Canvas canvas)
/*     */   {
/* 137 */     boolean centered = (getGravity() & 0x1) != 0;
/* 138 */     if (centered)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 146 */       int compoundPaddingLeft = getCompoundPaddingLeft();
/* 147 */       int compoundPaddingRight = getCompoundPaddingRight();
/* 148 */       int compoundDrawablePadding = getCompoundDrawablePadding();
/* 149 */       int textX = compoundPaddingLeft + compoundDrawablePadding;
/* 150 */       int textContentWidth = getWidth() - textX - compoundPaddingRight;
/* 151 */       int textWidth = measureTextWidth(getText().toString());
/* 152 */       int textPaddingWidth = (textContentWidth - textWidth) / 2;
/* 153 */       int imagePaddingWidth = (compoundPaddingLeft - getPaddingLeft()) / 2;
/* 154 */       int inset = Math.min(textPaddingWidth, imagePaddingWidth);
/* 155 */       this.overrideCompoundPaddingLeft = (compoundPaddingLeft - inset);
/* 156 */       this.overrideCompoundPaddingRight = (compoundPaddingRight + inset);
/* 157 */       this.overrideCompoundPadding = true;
/*     */     }
/* 159 */     super.onDraw(canvas);
/* 160 */     this.overrideCompoundPadding = false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getCompoundPaddingLeft()
/*     */   {
/* 167 */     return this.overrideCompoundPadding ? this.overrideCompoundPaddingLeft : super.getCompoundPaddingLeft();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getCompoundPaddingRight()
/*     */   {
/* 174 */     return this.overrideCompoundPadding ? this.overrideCompoundPaddingRight : super.getCompoundPaddingRight();
/*     */   }
/*     */   
/*     */   protected Activity getActivity() {
/* 178 */     Context context = getContext();
/* 179 */     while ((!(context instanceof Activity)) && ((context instanceof ContextWrapper))) {
/* 180 */       context = ((ContextWrapper)context).getBaseContext();
/*     */     }
/*     */     
/* 183 */     if ((context instanceof Activity)) {
/* 184 */       return (Activity)context;
/*     */     }
/* 186 */     throw new FacebookException("Unable to get Activity.");
/*     */   }
/*     */   
/*     */   protected int getDefaultStyleResource() {
/* 190 */     return 0;
/*     */   }
/*     */   
/*     */   protected int measureTextWidth(String text) {
/* 194 */     return (int)Math.ceil(getPaint().measureText(text));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void configureButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
/*     */   {
/* 202 */     parseBackgroundAttributes(context, attrs, defStyleAttr, defStyleRes);
/* 203 */     parseCompoundDrawableAttributes(context, attrs, defStyleAttr, defStyleRes);
/* 204 */     parseContentAttributes(context, attrs, defStyleAttr, defStyleRes);
/* 205 */     parseTextAttributes(context, attrs, defStyleAttr, defStyleRes);
/* 206 */     setupOnClickListener();
/*     */   }
/*     */   
/*     */   protected void callExternalOnClickListener(View v) {
/* 210 */     if (this.externalOnClickListener != null) {
/* 211 */       this.externalOnClickListener.onClick(v);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void setInternalOnClickListener(OnClickListener l) {
/* 216 */     this.internalOnClickListener = l;
/*     */   }
/*     */   
/*     */   private void logButtonCreated(Context context) {
/* 220 */     AppEventsLogger logger = AppEventsLogger.newLogger(context);
/* 221 */     logger.logSdkEvent(this.analyticsButtonCreatedEventName, null, null);
/*     */   }
/*     */   
/*     */   private void logButtonTapped(Context context) {
/* 225 */     AppEventsLogger logger = AppEventsLogger.newLogger(context);
/* 226 */     logger.logSdkEvent(this.analyticsButtonTappedEventName, null, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void parseBackgroundAttributes(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
/*     */   {
/* 235 */     if (isInEditMode()) {
/* 236 */       return;
/*     */     }
/*     */     
/* 239 */     int[] attrsResources = { 16842964 };
/*     */     
/*     */ 
/* 242 */     TypedArray a = context.getTheme().obtainStyledAttributes(attrs, attrsResources, defStyleAttr, defStyleRes);
/*     */     
/*     */ 
/*     */ 
/*     */     try
/*     */     {
/* 248 */       if (a.hasValue(0)) {
/* 249 */         int backgroundResource = a.getResourceId(0, 0);
/* 250 */         if (backgroundResource != 0) {
/* 251 */           setBackgroundResource(backgroundResource);
/*     */         } else {
/* 253 */           setBackgroundColor(a.getColor(0, 0));
/*     */         }
/*     */       }
/*     */       else {
/* 257 */         setBackgroundColor(ContextCompat.getColor(context, R.color.com_facebook_blue));
/*     */       }
/*     */     } finally {
/* 260 */       a.recycle();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @SuppressLint({"ResourceType"})
/*     */   private void parseCompoundDrawableAttributes(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
/*     */   {
/* 270 */     int[] attrsResources = { 16843119, 16843117, 16843120, 16843118, 16843121 };
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 277 */     TypedArray a = context.getTheme().obtainStyledAttributes(attrs, attrsResources, defStyleAttr, defStyleRes);
/*     */     
/*     */ 
/*     */ 
/*     */     try
/*     */     {
/* 283 */       setCompoundDrawablesWithIntrinsicBounds(a
/* 284 */         .getResourceId(0, 0), a
/* 285 */         .getResourceId(1, 0), a
/* 286 */         .getResourceId(2, 0), a
/* 287 */         .getResourceId(3, 0));
/* 288 */       setCompoundDrawablePadding(a.getDimensionPixelSize(4, 0));
/*     */     }
/*     */     finally {
/* 291 */       a.recycle();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void parseContentAttributes(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
/*     */   {
/* 301 */     int[] attrsResources = { 16842966, 16842967, 16842968, 16842969 };
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 307 */     TypedArray a = context.getTheme().obtainStyledAttributes(attrs, attrsResources, defStyleAttr, defStyleRes);
/*     */     
/*     */ 
/*     */ 
/*     */     try
/*     */     {
/* 313 */       setPadding(a
/* 314 */         .getDimensionPixelSize(0, 0), a
/* 315 */         .getDimensionPixelSize(1, 0), a
/* 316 */         .getDimensionPixelSize(2, 0), a
/* 317 */         .getDimensionPixelSize(3, 0));
/*     */     } finally {
/* 319 */       a.recycle();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void parseTextAttributes(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
/*     */   {
/* 329 */     int[] colorResources = { 16842904 };
/*     */     
/*     */ 
/* 332 */     TypedArray colorAttrs = context.getTheme().obtainStyledAttributes(attrs, colorResources, defStyleAttr, defStyleRes);
/*     */     
/*     */ 
/*     */ 
/*     */     try
/*     */     {
/* 338 */       setTextColor(colorAttrs.getColorStateList(0));
/*     */     } finally {
/* 340 */       colorAttrs.recycle();
/*     */     }
/* 342 */     int[] gravityResources = { 16842927 };
/*     */     
/*     */ 
/* 345 */     TypedArray gravityAttrs = context.getTheme().obtainStyledAttributes(attrs, gravityResources, defStyleAttr, defStyleRes);
/*     */     
/*     */ 
/*     */ 
/*     */     try
/*     */     {
/* 351 */       setGravity(gravityAttrs.getInt(0, 17));
/*     */     } finally {
/* 353 */       gravityAttrs.recycle();
/*     */     }
/* 355 */     int[] attrsResources = { 16842901, 16842903, 16843087 };
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 360 */     TypedArray a = context.getTheme().obtainStyledAttributes(attrs, attrsResources, defStyleAttr, defStyleRes);
/*     */     
/*     */ 
/*     */ 
/*     */     try
/*     */     {
/* 366 */       setTextSize(0, a.getDimensionPixelSize(0, 0));
/* 367 */       setTypeface(Typeface.defaultFromStyle(a.getInt(1, 1)));
/* 368 */       setText(a.getString(2));
/*     */     } finally {
/* 370 */       a.recycle();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void setupOnClickListener()
/*     */   {
/* 377 */     super.setOnClickListener(new OnClickListener()
/*     */     {
/*     */       public void onClick(View v) {
/* 380 */         FacebookButtonBase.this.logButtonTapped(FacebookButtonBase.this.getContext());
/* 381 */         if (FacebookButtonBase.this.internalOnClickListener != null) {
/* 382 */           FacebookButtonBase.this.internalOnClickListener.onClick(v);
/* 383 */         } else if (FacebookButtonBase.this.externalOnClickListener != null) {
/* 384 */           FacebookButtonBase.this.externalOnClickListener.onClick(v);
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/FacebookButtonBase.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */