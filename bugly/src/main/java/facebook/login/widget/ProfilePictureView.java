/*     */ package com.facebook.login.widget;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.content.res.Resources;
/*     */ import android.content.res.TypedArray;
/*     */ import android.graphics.Bitmap;
/*     */ import android.graphics.BitmapFactory;
/*     */ import android.os.Bundle;
/*     */ import android.os.Parcelable;
/*     */ import android.util.AttributeSet;
/*     */ import android.view.View.MeasureSpec;
/*     */ import android.view.ViewGroup.LayoutParams;
/*     */ import android.widget.FrameLayout;
/*     */ import android.widget.FrameLayout.LayoutParams;
/*     */ import android.widget.ImageView;
/*     */ import android.widget.ImageView.ScaleType;
/*     */ import com.facebook.FacebookException;
/*     */ import com.facebook.LoggingBehavior;
/*     */ import com.facebook.R.dimen;
/*     */ import com.facebook.R.drawable;
/*     */ import com.facebook.R.styleable;
/*     */ import com.facebook.internal.ImageDownloader;
/*     */ import com.facebook.internal.ImageRequest;
/*     */ import com.facebook.internal.ImageRequest.Builder;
/*     */ import com.facebook.internal.ImageRequest.Callback;
/*     */ import com.facebook.internal.ImageResponse;
/*     */ import com.facebook.internal.Logger;
/*     */ import com.facebook.internal.Utility;
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
/*     */ public class ProfilePictureView
/*     */   extends FrameLayout
/*     */ {
/*  60 */   public static final String TAG = ProfilePictureView.class.getSimpleName();
/*     */   
/*     */ 
/*     */   public static final int CUSTOM = -1;
/*     */   
/*     */ 
/*     */   public static final int SMALL = -2;
/*     */   
/*     */ 
/*     */   public static final int NORMAL = -3;
/*     */   
/*     */ 
/*     */   public static final int LARGE = -4;
/*     */   
/*     */ 
/*     */   private static final int MIN_SIZE = 1;
/*     */   
/*     */ 
/*     */   private static final boolean IS_CROPPED_DEFAULT_VALUE = true;
/*     */   
/*     */ 
/*     */   private static final String SUPER_STATE_KEY = "ProfilePictureView_superState";
/*     */   
/*     */ 
/*     */   private static final String PROFILE_ID_KEY = "ProfilePictureView_profileId";
/*     */   
/*     */ 
/*     */   private static final String PRESET_SIZE_KEY = "ProfilePictureView_presetSize";
/*     */   
/*     */ 
/*     */   private static final String IS_CROPPED_KEY = "ProfilePictureView_isCropped";
/*     */   
/*     */ 
/*     */   private static final String BITMAP_KEY = "ProfilePictureView_bitmap";
/*     */   
/*     */ 
/*     */   private static final String BITMAP_WIDTH_KEY = "ProfilePictureView_width";
/*     */   
/*     */ 
/*     */   private static final String BITMAP_HEIGHT_KEY = "ProfilePictureView_height";
/*     */   
/*     */ 
/*     */   private static final String PENDING_REFRESH_KEY = "ProfilePictureView_refresh";
/*     */   
/*     */ 
/*     */   private String profileId;
/*     */   
/* 107 */   private int queryHeight = 0;
/* 108 */   private int queryWidth = 0;
/* 109 */   private boolean isCropped = true;
/*     */   private Bitmap imageContents;
/*     */   private ImageView image;
/* 112 */   private int presetSizeType = -1;
/*     */   private ImageRequest lastRequest;
/*     */   private OnErrorListener onErrorListener;
/* 115 */   private Bitmap customizedDefaultProfilePicture = null;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ProfilePictureView(Context context)
/*     */   {
/* 123 */     super(context);
/* 124 */     initialize(context);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ProfilePictureView(Context context, AttributeSet attrs)
/*     */   {
/* 135 */     super(context, attrs);
/* 136 */     initialize(context);
/* 137 */     parseAttributes(attrs);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ProfilePictureView(Context context, AttributeSet attrs, int defStyle)
/*     */   {
/* 149 */     super(context, attrs, defStyle);
/* 150 */     initialize(context);
/* 151 */     parseAttributes(attrs);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getPresetSize()
/*     */   {
/* 160 */     return this.presetSizeType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void setPresetSize(int sizeType)
/*     */   {
/* 169 */     switch (sizeType) {
/*     */     case -4: 
/*     */     case -3: 
/*     */     case -2: 
/*     */     case -1: 
/* 174 */       this.presetSizeType = sizeType;
/* 175 */       break;
/*     */     
/*     */     default: 
/* 178 */       throw new IllegalArgumentException("Must use a predefined preset size");
/*     */     }
/*     */     
/* 181 */     requestLayout();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean isCropped()
/*     */   {
/* 190 */     return this.isCropped;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void setCropped(boolean showCroppedVersion)
/*     */   {
/* 200 */     this.isCropped = showCroppedVersion;
/*     */     
/* 202 */     refreshImage(false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final String getProfileId()
/*     */   {
/* 211 */     return this.profileId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void setProfileId(String profileId)
/*     */   {
/* 221 */     boolean force = false;
/* 222 */     if ((Utility.isNullOrEmpty(this.profileId)) || (!this.profileId.equalsIgnoreCase(profileId)))
/*     */     {
/* 224 */       setBlankProfilePicture();
/* 225 */       force = true;
/*     */     }
/*     */     
/* 228 */     this.profileId = profileId;
/* 229 */     refreshImage(force);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final OnErrorListener getOnErrorListener()
/*     */   {
/* 238 */     return this.onErrorListener;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void setOnErrorListener(OnErrorListener onErrorListener)
/*     */   {
/* 248 */     this.onErrorListener = onErrorListener;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void setDefaultProfilePicture(Bitmap inputBitmap)
/*     */   {
/* 258 */     this.customizedDefaultProfilePicture = inputBitmap;
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
/*     */   protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
/*     */   {
/* 271 */     ViewGroup.LayoutParams params = getLayoutParams();
/* 272 */     boolean customMeasure = false;
/* 273 */     int newHeight = View.MeasureSpec.getSize(heightMeasureSpec);
/* 274 */     int newWidth = View.MeasureSpec.getSize(widthMeasureSpec);
/* 275 */     if ((View.MeasureSpec.getMode(heightMeasureSpec) != 1073741824) && (params.height == -2))
/*     */     {
/* 277 */       newHeight = getPresetSizeInPixels(true);
/* 278 */       heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(newHeight, 1073741824);
/* 279 */       customMeasure = true;
/*     */     }
/*     */     
/* 282 */     if ((View.MeasureSpec.getMode(widthMeasureSpec) != 1073741824) && (params.width == -2))
/*     */     {
/* 284 */       newWidth = getPresetSizeInPixels(true);
/* 285 */       widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(newWidth, 1073741824);
/* 286 */       customMeasure = true;
/*     */     }
/*     */     
/* 289 */     if (customMeasure)
/*     */     {
/*     */ 
/* 292 */       setMeasuredDimension(newWidth, newHeight);
/* 293 */       measureChildren(widthMeasureSpec, heightMeasureSpec);
/*     */     }
/*     */     else {
/* 296 */       super.onMeasure(widthMeasureSpec, heightMeasureSpec);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void onLayout(boolean changed, int left, int top, int right, int bottom)
/*     */   {
/* 306 */     super.onLayout(changed, left, top, right, bottom);
/*     */     
/*     */ 
/* 309 */     refreshImage(false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected Parcelable onSaveInstanceState()
/*     */   {
/* 319 */     Parcelable superState = super.onSaveInstanceState();
/* 320 */     Bundle instanceState = new Bundle();
/* 321 */     instanceState.putParcelable("ProfilePictureView_superState", superState);
/* 322 */     instanceState.putString("ProfilePictureView_profileId", this.profileId);
/* 323 */     instanceState.putInt("ProfilePictureView_presetSize", this.presetSizeType);
/* 324 */     instanceState.putBoolean("ProfilePictureView_isCropped", this.isCropped);
/* 325 */     instanceState.putParcelable("ProfilePictureView_bitmap", this.imageContents);
/* 326 */     instanceState.putInt("ProfilePictureView_width", this.queryWidth);
/* 327 */     instanceState.putInt("ProfilePictureView_height", this.queryHeight);
/* 328 */     instanceState.putBoolean("ProfilePictureView_refresh", this.lastRequest != null);
/*     */     
/* 330 */     return instanceState;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void onRestoreInstanceState(Parcelable state)
/*     */   {
/* 339 */     if (state.getClass() != Bundle.class) {
/* 340 */       super.onRestoreInstanceState(state);
/*     */     } else {
/* 342 */       Bundle instanceState = (Bundle)state;
/* 343 */       super.onRestoreInstanceState(instanceState.getParcelable("ProfilePictureView_superState"));
/*     */       
/* 345 */       this.profileId = instanceState.getString("ProfilePictureView_profileId");
/* 346 */       this.presetSizeType = instanceState.getInt("ProfilePictureView_presetSize");
/* 347 */       this.isCropped = instanceState.getBoolean("ProfilePictureView_isCropped");
/* 348 */       this.queryWidth = instanceState.getInt("ProfilePictureView_width");
/* 349 */       this.queryHeight = instanceState.getInt("ProfilePictureView_height");
/*     */       
/* 351 */       setImageBitmap((Bitmap)instanceState.getParcelable("ProfilePictureView_bitmap"));
/*     */       
/* 353 */       if (instanceState.getBoolean("ProfilePictureView_refresh")) {
/* 354 */         refreshImage(true);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   protected void onDetachedFromWindow()
/*     */   {
/* 361 */     super.onDetachedFromWindow();
/*     */     
/*     */ 
/*     */ 
/* 365 */     this.lastRequest = null;
/*     */   }
/*     */   
/*     */   private void initialize(Context context)
/*     */   {
/* 370 */     removeAllViews();
/*     */     
/* 372 */     this.image = new ImageView(context);
/*     */     
/* 374 */     LayoutParams imageLayout = new LayoutParams(-1, -1);
/*     */     
/*     */ 
/*     */ 
/* 378 */     this.image.setLayoutParams(imageLayout);
/*     */     
/*     */ 
/*     */ 
/* 382 */     this.image.setScaleType(ScaleType.CENTER_INSIDE);
/* 383 */     addView(this.image);
/*     */   }
/*     */   
/*     */   private void parseAttributes(AttributeSet attrs) {
/* 387 */     TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.com_facebook_profile_picture_view);
/*     */     
/* 389 */     setPresetSize(a.getInt(R.styleable.com_facebook_profile_picture_view_com_facebook_preset_size, -1));
/* 390 */     this.isCropped = a.getBoolean(R.styleable.com_facebook_profile_picture_view_com_facebook_is_cropped, true);
/*     */     
/* 392 */     a.recycle();
/*     */   }
/*     */   
/*     */   private void refreshImage(boolean force) {
/* 396 */     boolean changed = updateImageQueryParameters();
/*     */     
/*     */ 
/* 399 */     if ((this.profileId == null) || (this.profileId.length() == 0) || ((this.queryWidth == 0) && (this.queryHeight == 0)))
/*     */     {
/*     */ 
/* 402 */       setBlankProfilePicture();
/* 403 */     } else if ((changed) || (force)) {
/* 404 */       sendImageRequest(true);
/*     */     }
/*     */   }
/*     */   
/*     */   private void setBlankProfilePicture()
/*     */   {
/* 410 */     if (this.lastRequest != null) {
/* 411 */       ImageDownloader.cancelRequest(this.lastRequest);
/*     */     }
/*     */     
/* 414 */     if (this.customizedDefaultProfilePicture == null) {
/* 415 */       int blankImageResource = isCropped() ? R.drawable.com_facebook_profile_picture_blank_square : R.drawable.com_facebook_profile_picture_blank_portrait;
/*     */       
/*     */ 
/* 418 */       setImageBitmap(BitmapFactory.decodeResource(getResources(), blankImageResource));
/*     */     }
/*     */     else {
/* 421 */       updateImageQueryParameters();
/*     */       
/* 423 */       Bitmap scaledBitmap = Bitmap.createScaledBitmap(this.customizedDefaultProfilePicture, this.queryWidth, this.queryHeight, false);
/*     */       
/* 425 */       setImageBitmap(scaledBitmap);
/*     */     }
/*     */   }
/*     */   
/*     */   private void setImageBitmap(Bitmap imageBitmap) {
/* 430 */     if ((this.image != null) && (imageBitmap != null)) {
/* 431 */       this.imageContents = imageBitmap;
/* 432 */       this.image.setImageBitmap(imageBitmap);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void sendImageRequest(boolean allowCachedResponse)
/*     */   {
/* 439 */     ImageRequest.Builder requestBuilder = new ImageRequest.Builder(getContext(), ImageRequest.getProfilePictureUri(this.profileId, this.queryWidth, this.queryHeight));
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
/* 450 */     ImageRequest request = requestBuilder.setAllowCachedRedirects(allowCachedResponse).setCallerTag(this).setCallback(new ImageRequest.Callback()
/*     */     {
/*     */ 
/*     */       public void onCompleted(ImageResponse response)
/*     */       {
/* 447 */         ProfilePictureView.this.processResponse(response);
/*     */       }
/*     */     })
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 450 */       .build();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 455 */     if (this.lastRequest != null) {
/* 456 */       ImageDownloader.cancelRequest(this.lastRequest);
/*     */     }
/* 458 */     this.lastRequest = request;
/*     */     
/* 460 */     ImageDownloader.downloadAsync(request);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void processResponse(ImageResponse response)
/*     */   {
/* 467 */     if (response.getRequest() == this.lastRequest) {
/* 468 */       this.lastRequest = null;
/* 469 */       Bitmap responseImage = response.getBitmap();
/* 470 */       Exception error = response.getError();
/* 471 */       if (error != null) {
/* 472 */         OnErrorListener listener = this.onErrorListener;
/* 473 */         if (listener != null) {
/* 474 */           listener.onError(new FacebookException("Error in downloading profile picture for profileId: " + 
/*     */           
/* 476 */             getProfileId(), error));
/*     */         } else {
/* 478 */           Logger.log(LoggingBehavior.REQUESTS, 6, TAG, error.toString());
/*     */         }
/* 480 */       } else if (responseImage != null) {
/* 481 */         setImageBitmap(responseImage);
/*     */         
/* 483 */         if (response.isCachedRedirect()) {
/* 484 */           sendImageRequest(false);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean updateImageQueryParameters() {
/* 491 */     int newHeightPx = getHeight();
/* 492 */     int newWidthPx = getWidth();
/* 493 */     if ((newWidthPx < 1) || (newHeightPx < 1))
/*     */     {
/* 495 */       return false;
/*     */     }
/*     */     
/* 498 */     int presetSize = getPresetSizeInPixels(false);
/* 499 */     if (presetSize != 0) {
/* 500 */       newWidthPx = presetSize;
/* 501 */       newHeightPx = presetSize;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 506 */     if (newWidthPx <= newHeightPx) {
/* 507 */       newHeightPx = isCropped() ? newWidthPx : 0;
/*     */     } else {
/* 509 */       newWidthPx = isCropped() ? newHeightPx : 0;
/*     */     }
/*     */     
/* 512 */     boolean changed = (newWidthPx != this.queryWidth) || (newHeightPx != this.queryHeight);
/*     */     
/* 514 */     this.queryWidth = newWidthPx;
/* 515 */     this.queryHeight = newHeightPx;
/*     */     
/* 517 */     return changed; }
/*     */   
/*     */   private int getPresetSizeInPixels(boolean forcePreset) { int dimensionId;
/*     */     int dimensionId;
/*     */     int dimensionId;
/* 522 */     int dimensionId; switch (this.presetSizeType) {
/*     */     case -2: 
/* 524 */       dimensionId = R.dimen.com_facebook_profilepictureview_preset_size_small;
/* 525 */       break;
/*     */     case -3: 
/* 527 */       dimensionId = R.dimen.com_facebook_profilepictureview_preset_size_normal;
/* 528 */       break;
/*     */     case -4: 
/* 530 */       dimensionId = R.dimen.com_facebook_profilepictureview_preset_size_large;
/* 531 */       break;
/*     */     case -1: 
/* 533 */       if (!forcePreset) {
/* 534 */         return 0;
/*     */       }
/* 536 */       dimensionId = R.dimen.com_facebook_profilepictureview_preset_size_normal;
/* 537 */       break;
/*     */     
/*     */     default: 
/* 540 */       return 0;
/*     */     }
/*     */     int dimensionId;
/* 543 */     return getResources().getDimensionPixelSize(dimensionId);
/*     */   }
/*     */   
/*     */   public static abstract interface OnErrorListener
/*     */   {
/*     */     public abstract void onError(FacebookException paramFacebookException);
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/login/widget/ProfilePictureView.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */