/*     */ package com.facebook.share.widget;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.content.BroadcastReceiver;
/*     */ import android.content.Context;
/*     */ import android.content.ContextWrapper;
/*     */ import android.content.Intent;
/*     */ import android.content.IntentFilter;
/*     */ import android.content.res.Resources;
/*     */ import android.content.res.TypedArray;
/*     */ import android.os.Bundle;
/*     */ import android.support.v4.content.LocalBroadcastManager;
/*     */ import android.util.AttributeSet;
/*     */ import android.view.View;
/*     */ import android.view.View.OnClickListener;
/*     */ import android.widget.FrameLayout;
/*     */ import android.widget.FrameLayout.LayoutParams;
/*     */ import android.widget.LinearLayout;
/*     */ import android.widget.LinearLayout.LayoutParams;
/*     */ import android.widget.TextView;
/*     */ import com.facebook.FacebookException;
/*     */ import com.facebook.R.color;
/*     */ import com.facebook.R.dimen;
/*     */ import com.facebook.R.styleable;
/*     */ import com.facebook.internal.FragmentWrapper;
/*     */ import com.facebook.internal.NativeProtocol;
/*     */ import com.facebook.internal.Utility;
/*     */ import com.facebook.share.internal.LikeActionController;
/*     */ import com.facebook.share.internal.LikeActionController.CreationCallback;
/*     */ import com.facebook.share.internal.LikeBoxCountView;
/*     */ import com.facebook.share.internal.LikeBoxCountView.LikeBoxCountViewCaretPosition;
/*     */ import com.facebook.share.internal.LikeButton;
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
/*     */ public class LikeView
/*     */   extends FrameLayout
/*     */ {
/*     */   private static final int NO_FOREGROUND_COLOR = -1;
/*     */   private String objectId;
/*     */   private ObjectType objectType;
/*     */   private LinearLayout containerView;
/*     */   private LikeButton likeButton;
/*     */   private LikeBoxCountView likeBoxCountView;
/*     */   private TextView socialSentenceView;
/*     */   private LikeActionController likeActionController;
/*     */   private OnErrorListener onErrorListener;
/*     */   private BroadcastReceiver broadcastReceiver;
/*     */   private LikeActionControllerCreationCallback creationCallback;
/*     */   
/*     */   public static enum ObjectType
/*     */   {
/*  65 */     UNKNOWN("unknown", 0), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  70 */     OPEN_GRAPH("open_graph", 1), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  75 */     PAGE("page", 2);
/*     */     
/*  77 */     public static ObjectType DEFAULT = UNKNOWN;
/*     */     private String stringValue;
/*     */     
/*  80 */     public static ObjectType fromInt(int enumValue) { for (ObjectType objectType : ) {
/*  81 */         if (objectType.getValue() == enumValue) {
/*  82 */           return objectType;
/*     */         }
/*     */       }
/*     */       
/*  86 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */     private ObjectType(String stringValue, int value)
/*     */     {
/*  92 */       this.stringValue = stringValue;
/*  93 */       this.intValue = value;
/*     */     }
/*     */     
/*     */     public String toString()
/*     */     {
/*  98 */       return this.stringValue;
/*     */     }
/*     */     
/*     */     public int getValue() {
/* 102 */       return this.intValue;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     private int intValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static enum Style
/*     */   {
/* 116 */     STANDARD("standard", 0), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 122 */     BUTTON("button", 1), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 128 */     BOX_COUNT("box_count", 2);
/*     */     
/* 130 */     static Style DEFAULT = STANDARD;
/*     */     private String stringValue;
/*     */     
/* 133 */     static Style fromInt(int enumValue) { for (Style style : ) {
/* 134 */         if (style.getValue() == enumValue) {
/* 135 */           return style;
/*     */         }
/*     */       }
/*     */       
/* 139 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */     private Style(String stringValue, int value)
/*     */     {
/* 145 */       this.stringValue = stringValue;
/* 146 */       this.intValue = value;
/*     */     }
/*     */     
/*     */     public String toString()
/*     */     {
/* 151 */       return this.stringValue;
/*     */     }
/*     */     
/*     */     private int getValue() {
/* 155 */       return this.intValue;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     private int intValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static enum HorizontalAlignment
/*     */   {
/* 169 */     CENTER("center", 0), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 175 */     LEFT("left", 1), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 182 */     RIGHT("right", 2);
/*     */     
/* 184 */     static HorizontalAlignment DEFAULT = CENTER;
/*     */     private String stringValue;
/*     */     
/* 187 */     static HorizontalAlignment fromInt(int enumValue) { for (HorizontalAlignment horizontalAlignment : ) {
/* 188 */         if (horizontalAlignment.getValue() == enumValue) {
/* 189 */           return horizontalAlignment;
/*     */         }
/*     */       }
/*     */       
/* 193 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */     private HorizontalAlignment(String stringValue, int value)
/*     */     {
/* 199 */       this.stringValue = stringValue;
/* 200 */       this.intValue = value;
/*     */     }
/*     */     
/*     */     public String toString()
/*     */     {
/* 205 */       return this.stringValue;
/*     */     }
/*     */     
/*     */     private int getValue() {
/* 209 */       return this.intValue;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private int intValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static enum AuxiliaryViewPosition
/*     */   {
/* 224 */     BOTTOM("bottom", 0), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 232 */     INLINE("inline", 1), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 238 */     TOP("top", 2);
/*     */     
/* 240 */     static AuxiliaryViewPosition DEFAULT = BOTTOM;
/*     */     private String stringValue;
/*     */     
/* 243 */     static AuxiliaryViewPosition fromInt(int enumValue) { for (AuxiliaryViewPosition auxViewPosition : ) {
/* 244 */         if (auxViewPosition.getValue() == enumValue) {
/* 245 */           return auxViewPosition;
/*     */         }
/*     */       }
/*     */       
/* 249 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */     private AuxiliaryViewPosition(String stringValue, int value)
/*     */     {
/* 255 */       this.stringValue = stringValue;
/* 256 */       this.intValue = value;
/*     */     }
/*     */     
/*     */     public String toString()
/*     */     {
/* 261 */       return this.stringValue;
/*     */     }
/*     */     
/*     */     private int getValue() {
/* 265 */       return this.intValue;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private int intValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 282 */   private Style likeViewStyle = Style.DEFAULT;
/* 283 */   private HorizontalAlignment horizontalAlignment = HorizontalAlignment.DEFAULT;
/* 284 */   private AuxiliaryViewPosition auxiliaryViewPosition = AuxiliaryViewPosition.DEFAULT;
/* 285 */   private int foregroundColor = -1;
/*     */   
/*     */ 
/*     */   private int edgePadding;
/*     */   
/*     */ 
/*     */   private int internalPadding;
/*     */   
/*     */   private FragmentWrapper parentFragment;
/*     */   
/*     */   private boolean explicitlyDisabled;
/*     */   
/*     */ 
/*     */   public LikeView(Context context)
/*     */   {
/* 300 */     super(context);
/* 301 */     initialize(context);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public LikeView(Context context, AttributeSet attrs)
/*     */   {
/* 311 */     super(context, attrs);
/* 312 */     parseAttributes(attrs);
/* 313 */     initialize(context);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setObjectIdAndType(String objectId, ObjectType objectType)
/*     */   {
/* 321 */     objectId = Utility.coerceValueIfNullOrEmpty(objectId, null);
/* 322 */     objectType = objectType != null ? objectType : ObjectType.DEFAULT;
/*     */     
/* 324 */     if ((!Utility.areObjectsEqual(objectId, this.objectId)) || (objectType != this.objectType)) {
/* 325 */       setObjectIdAndTypeForced(objectId, objectType);
/*     */       
/* 327 */       updateLikeStateAndLayout();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLikeViewStyle(Style likeViewStyle)
/*     */   {
/* 338 */     likeViewStyle = likeViewStyle != null ? likeViewStyle : Style.DEFAULT;
/* 339 */     if (this.likeViewStyle != likeViewStyle) {
/* 340 */       this.likeViewStyle = likeViewStyle;
/*     */       
/* 342 */       updateLayout();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAuxiliaryViewPosition(AuxiliaryViewPosition auxiliaryViewPosition)
/*     */   {
/* 353 */     auxiliaryViewPosition = auxiliaryViewPosition != null ? auxiliaryViewPosition : AuxiliaryViewPosition.DEFAULT;
/*     */     
/* 355 */     if (this.auxiliaryViewPosition != auxiliaryViewPosition) {
/* 356 */       this.auxiliaryViewPosition = auxiliaryViewPosition;
/*     */       
/* 358 */       updateLayout();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setHorizontalAlignment(HorizontalAlignment horizontalAlignment)
/*     */   {
/* 368 */     horizontalAlignment = horizontalAlignment != null ? horizontalAlignment : HorizontalAlignment.DEFAULT;
/*     */     
/* 370 */     if (this.horizontalAlignment != horizontalAlignment) {
/* 371 */       this.horizontalAlignment = horizontalAlignment;
/*     */       
/* 373 */       updateLayout();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setForegroundColor(int foregroundColor)
/*     */   {
/* 384 */     if (this.foregroundColor != foregroundColor) {
/* 385 */       this.socialSentenceView.setTextColor(foregroundColor);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOnErrorListener(OnErrorListener onErrorListener)
/*     */   {
/* 396 */     this.onErrorListener = onErrorListener;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public OnErrorListener getOnErrorListener()
/*     */   {
/* 405 */     return this.onErrorListener;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFragment(android.support.v4.app.Fragment fragment)
/*     */   {
/* 417 */     this.parentFragment = new FragmentWrapper(fragment);
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
/* 429 */     this.parentFragment = new FragmentWrapper(fragment);
/*     */   }
/*     */   
/*     */   public void setEnabled(boolean enabled)
/*     */   {
/* 434 */     this.explicitlyDisabled = (!enabled);
/*     */     
/* 436 */     updateLikeStateAndLayout();
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onDetachedFromWindow()
/*     */   {
/* 442 */     setObjectIdAndType(null, ObjectType.UNKNOWN);
/*     */     
/* 444 */     super.onDetachedFromWindow();
/*     */   }
/*     */   
/*     */   private void parseAttributes(AttributeSet attrs) {
/* 448 */     if ((attrs == null) || (getContext() == null)) {
/* 449 */       return;
/*     */     }
/*     */     
/* 452 */     TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.com_facebook_like_view);
/*     */     
/* 454 */     if (a == null) {
/* 455 */       return;
/*     */     }
/*     */     
/* 458 */     this.objectId = Utility.coerceValueIfNullOrEmpty(a
/* 459 */       .getString(R.styleable.com_facebook_like_view_com_facebook_object_id), null);
/* 460 */     this.objectType = ObjectType.fromInt(a
/* 461 */       .getInt(R.styleable.com_facebook_like_view_com_facebook_object_type, ObjectType.DEFAULT
/* 462 */       .getValue()));
/* 463 */     this.likeViewStyle = Style.fromInt(a
/* 464 */       .getInt(R.styleable.com_facebook_like_view_com_facebook_style, Style.DEFAULT
/* 465 */       .getValue()));
/* 466 */     if (this.likeViewStyle == null) {
/* 467 */       throw new IllegalArgumentException("Unsupported value for LikeView 'style'");
/*     */     }
/*     */     
/* 470 */     this.auxiliaryViewPosition = AuxiliaryViewPosition.fromInt(a
/* 471 */       .getInt(R.styleable.com_facebook_like_view_com_facebook_auxiliary_view_position, AuxiliaryViewPosition.DEFAULT
/* 472 */       .getValue()));
/* 473 */     if (this.auxiliaryViewPosition == null) {
/* 474 */       throw new IllegalArgumentException("Unsupported value for LikeView 'auxiliary_view_position'");
/*     */     }
/*     */     
/*     */ 
/* 478 */     this.horizontalAlignment = HorizontalAlignment.fromInt(a
/* 479 */       .getInt(R.styleable.com_facebook_like_view_com_facebook_horizontal_alignment, HorizontalAlignment.DEFAULT
/* 480 */       .getValue()));
/* 481 */     if (this.horizontalAlignment == null) {
/* 482 */       throw new IllegalArgumentException("Unsupported value for LikeView 'horizontal_alignment'");
/*     */     }
/*     */     
/*     */ 
/* 486 */     this.foregroundColor = a.getColor(R.styleable.com_facebook_like_view_com_facebook_foreground_color, -1);
/*     */     
/*     */ 
/* 489 */     a.recycle();
/*     */   }
/*     */   
/*     */ 
/*     */   private void initialize(Context context)
/*     */   {
/* 495 */     this.edgePadding = getResources().getDimensionPixelSize(R.dimen.com_facebook_likeview_edge_padding);
/* 496 */     this.internalPadding = getResources().getDimensionPixelSize(R.dimen.com_facebook_likeview_internal_padding);
/* 497 */     if (this.foregroundColor == -1) {
/* 498 */       this.foregroundColor = getResources().getColor(R.color.com_facebook_likeview_text_color);
/*     */     }
/*     */     
/* 501 */     setBackgroundColor(0);
/*     */     
/* 503 */     this.containerView = new LinearLayout(context);
/* 504 */     LayoutParams containerViewLayoutParams = new LayoutParams(-2, -2);
/*     */     
/*     */ 
/* 507 */     this.containerView.setLayoutParams(containerViewLayoutParams);
/*     */     
/* 509 */     initializeLikeButton(context);
/* 510 */     initializeSocialSentenceView(context);
/* 511 */     initializeLikeCountView(context);
/*     */     
/* 513 */     this.containerView.addView(this.likeButton);
/* 514 */     this.containerView.addView(this.socialSentenceView);
/* 515 */     this.containerView.addView(this.likeBoxCountView);
/*     */     
/* 517 */     addView(this.containerView);
/*     */     
/* 519 */     setObjectIdAndTypeForced(this.objectId, this.objectType);
/* 520 */     updateLikeStateAndLayout();
/*     */   }
/*     */   
/*     */   private void initializeLikeButton(Context context) {
/* 524 */     if (this.likeActionController != null) {}
/*     */     
/* 526 */     this.likeButton = new LikeButton(context, this.likeActionController.isObjectLiked());
/* 527 */     this.likeButton.setOnClickListener(new OnClickListener()
/*     */     {
/*     */       public void onClick(View v) {
/* 530 */         LikeView.this.toggleLike();
/*     */       }
/*     */       
/* 533 */     });
/* 534 */     LinearLayout.LayoutParams buttonLayout = new LinearLayout.LayoutParams(-2, -2);
/*     */     
/*     */ 
/*     */ 
/* 538 */     this.likeButton.setLayoutParams(buttonLayout);
/*     */   }
/*     */   
/*     */   private void initializeSocialSentenceView(Context context) {
/* 542 */     this.socialSentenceView = new TextView(context);
/* 543 */     this.socialSentenceView.setTextSize(0, 
/*     */     
/* 545 */       getResources().getDimension(R.dimen.com_facebook_likeview_text_size));
/* 546 */     this.socialSentenceView.setMaxLines(2);
/* 547 */     this.socialSentenceView.setTextColor(this.foregroundColor);
/* 548 */     this.socialSentenceView.setGravity(17);
/*     */     
/* 550 */     LinearLayout.LayoutParams socialSentenceViewLayout = new LinearLayout.LayoutParams(-2, -1);
/*     */     
/*     */ 
/* 553 */     this.socialSentenceView.setLayoutParams(socialSentenceViewLayout);
/*     */   }
/*     */   
/*     */   private void initializeLikeCountView(Context context) {
/* 557 */     this.likeBoxCountView = new LikeBoxCountView(context);
/*     */     
/* 559 */     LinearLayout.LayoutParams likeCountViewLayout = new LinearLayout.LayoutParams(-1, -1);
/*     */     
/*     */ 
/* 562 */     this.likeBoxCountView.setLayoutParams(likeCountViewLayout);
/*     */   }
/*     */   
/*     */   private void toggleLike() {
/* 566 */     if (this.likeActionController != null) {
/* 567 */       Activity activity = null;
/* 568 */       if (this.parentFragment == null) {
/* 569 */         activity = getActivity();
/*     */       }
/*     */       
/* 572 */       this.likeActionController.toggleLike(activity, this.parentFragment, 
/*     */       
/*     */ 
/* 575 */         getAnalyticsParameters());
/*     */     }
/*     */   }
/*     */   
/*     */   private Activity getActivity() {
/* 580 */     Context context = getContext();
/* 581 */     while ((!(context instanceof Activity)) && ((context instanceof ContextWrapper))) {
/* 582 */       context = ((ContextWrapper)context).getBaseContext();
/*     */     }
/*     */     
/* 585 */     if ((context instanceof Activity)) {
/* 586 */       return (Activity)context;
/*     */     }
/* 588 */     throw new FacebookException("Unable to get Activity.");
/*     */   }
/*     */   
/*     */   private Bundle getAnalyticsParameters() {
/* 592 */     Bundle params = new Bundle();
/* 593 */     params.putString("style", this.likeViewStyle.toString());
/* 594 */     params.putString("auxiliary_position", this.auxiliaryViewPosition
/*     */     
/* 596 */       .toString());
/* 597 */     params.putString("horizontal_alignment", this.horizontalAlignment
/*     */     
/* 599 */       .toString());
/* 600 */     params.putString("object_id", 
/*     */     
/* 602 */       Utility.coerceValueIfNullOrEmpty(this.objectId, ""));
/* 603 */     params.putString("object_type", this.objectType
/*     */     
/* 605 */       .toString());
/*     */     
/* 607 */     return params;
/*     */   }
/*     */   
/*     */   private void setObjectIdAndTypeForced(String newObjectId, ObjectType newObjectType) {
/* 611 */     tearDownObjectAssociations();
/*     */     
/* 613 */     this.objectId = newObjectId;
/* 614 */     this.objectType = newObjectType;
/*     */     
/* 616 */     if (Utility.isNullOrEmpty(newObjectId)) {
/* 617 */       return;
/*     */     }
/*     */     
/* 620 */     this.creationCallback = new LikeActionControllerCreationCallback(null);
/* 621 */     if (!isInEditMode()) {
/* 622 */       LikeActionController.getControllerForObjectId(newObjectId, newObjectType, this.creationCallback);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void associateWithLikeActionController(LikeActionController likeActionController)
/*     */   {
/* 630 */     this.likeActionController = likeActionController;
/*     */     
/* 632 */     this.broadcastReceiver = new LikeControllerBroadcastReceiver(null);
/*     */     
/* 634 */     LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(getContext());
/*     */     
/*     */ 
/* 637 */     IntentFilter filter = new IntentFilter();
/* 638 */     filter.addAction("com.facebook.sdk.LikeActionController.UPDATED");
/* 639 */     filter.addAction("com.facebook.sdk.LikeActionController.DID_ERROR");
/* 640 */     filter.addAction("com.facebook.sdk.LikeActionController.DID_RESET");
/*     */     
/* 642 */     localBroadcastManager.registerReceiver(this.broadcastReceiver, filter);
/*     */   }
/*     */   
/*     */   private void tearDownObjectAssociations() {
/* 646 */     if (this.broadcastReceiver != null)
/*     */     {
/* 648 */       LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(getContext());
/* 649 */       localBroadcastManager.unregisterReceiver(this.broadcastReceiver);
/*     */       
/* 651 */       this.broadcastReceiver = null;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 657 */     if (this.creationCallback != null) {
/* 658 */       this.creationCallback.cancel();
/*     */       
/* 660 */       this.creationCallback = null;
/*     */     }
/*     */     
/* 663 */     this.likeActionController = null;
/*     */   }
/*     */   
/*     */   private void updateLikeStateAndLayout() {
/* 667 */     boolean enabled = !this.explicitlyDisabled;
/*     */     
/* 669 */     if (this.likeActionController == null) {
/* 670 */       this.likeButton.setSelected(false);
/* 671 */       this.socialSentenceView.setText(null);
/* 672 */       this.likeBoxCountView.setText(null);
/*     */     } else {
/* 674 */       this.likeButton.setSelected(this.likeActionController.isObjectLiked());
/* 675 */       this.socialSentenceView.setText(this.likeActionController.getSocialSentence());
/* 676 */       this.likeBoxCountView.setText(this.likeActionController.getLikeCountString());
/*     */       
/* 678 */       enabled &= this.likeActionController.shouldEnableView();
/*     */     }
/*     */     
/* 681 */     super.setEnabled(enabled);
/* 682 */     this.likeButton.setEnabled(enabled);
/*     */     
/* 684 */     updateLayout();
/*     */   }
/*     */   
/*     */   private void updateLayout()
/*     */   {
/* 689 */     LayoutParams containerViewLayoutParams = (LayoutParams)this.containerView.getLayoutParams();
/*     */     
/* 691 */     LinearLayout.LayoutParams buttonLayoutParams = (LinearLayout.LayoutParams)this.likeButton.getLayoutParams();
/* 692 */     int viewGravity = this.horizontalAlignment == HorizontalAlignment.CENTER ? 1 : this.horizontalAlignment == HorizontalAlignment.LEFT ? 3 : 5;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 697 */     containerViewLayoutParams.gravity = (viewGravity | 0x30);
/* 698 */     buttonLayoutParams.gravity = viewGravity;
/*     */     
/*     */ 
/* 701 */     this.socialSentenceView.setVisibility(8);
/* 702 */     this.likeBoxCountView.setVisibility(8);
/*     */     
/*     */ 
/* 705 */     if ((this.likeViewStyle == Style.STANDARD) && (this.likeActionController != null))
/*     */     {
/* 707 */       if (!Utility.isNullOrEmpty(this.likeActionController.getSocialSentence())) {
/* 708 */         View auxView = this.socialSentenceView;
/* 709 */         break label166; } } if ((this.likeViewStyle == Style.BOX_COUNT) && (this.likeActionController != null))
/*     */     {
/* 711 */       if (!Utility.isNullOrEmpty(this.likeActionController.getLikeCountString())) {
/* 712 */         updateBoxCountCaretPosition();
/* 713 */         View auxView = this.likeBoxCountView;
/*     */         break label166; } }
/*     */     return;
/*     */     label166:
/*     */     View auxView;
/* 718 */     auxView.setVisibility(0);
/*     */     
/*     */ 
/*     */ 
/* 722 */     LinearLayout.LayoutParams auxViewLayoutParams = (LinearLayout.LayoutParams)auxView.getLayoutParams();
/* 723 */     auxViewLayoutParams.gravity = viewGravity;
/*     */     
/* 725 */     this.containerView.setOrientation(this.auxiliaryViewPosition == AuxiliaryViewPosition.INLINE ? 0 : 1);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 730 */     if ((this.auxiliaryViewPosition == AuxiliaryViewPosition.TOP) || ((this.auxiliaryViewPosition == AuxiliaryViewPosition.INLINE) && (this.horizontalAlignment == HorizontalAlignment.RIGHT)))
/*     */     {
/*     */ 
/*     */ 
/* 734 */       this.containerView.removeView(this.likeButton);
/* 735 */       this.containerView.addView(this.likeButton);
/*     */     }
/*     */     else {
/* 738 */       this.containerView.removeView(auxView);
/* 739 */       this.containerView.addView(auxView);
/*     */     }
/*     */     
/* 742 */     switch (this.auxiliaryViewPosition) {
/*     */     case TOP: 
/* 744 */       auxView.setPadding(this.edgePadding, this.edgePadding, this.edgePadding, this.internalPadding);
/* 745 */       break;
/*     */     case BOTTOM: 
/* 747 */       auxView.setPadding(this.edgePadding, this.internalPadding, this.edgePadding, this.edgePadding);
/* 748 */       break;
/*     */     case INLINE: 
/* 750 */       if (this.horizontalAlignment == HorizontalAlignment.RIGHT) {
/* 751 */         auxView.setPadding(this.edgePadding, this.edgePadding, this.internalPadding, this.edgePadding);
/*     */       } else {
/* 753 */         auxView.setPadding(this.internalPadding, this.edgePadding, this.edgePadding, this.edgePadding);
/*     */       }
/*     */       break;
/*     */     }
/*     */   }
/*     */   
/*     */   private void updateBoxCountCaretPosition() {
/* 760 */     switch (this.auxiliaryViewPosition) {
/*     */     case TOP: 
/* 762 */       this.likeBoxCountView.setCaretPosition(LikeBoxCountView.LikeBoxCountViewCaretPosition.BOTTOM);
/*     */       
/* 764 */       break;
/*     */     case BOTTOM: 
/* 766 */       this.likeBoxCountView.setCaretPosition(LikeBoxCountView.LikeBoxCountViewCaretPosition.TOP);
/*     */       
/* 768 */       break;
/*     */     case INLINE: 
/* 770 */       this.likeBoxCountView.setCaretPosition(this.horizontalAlignment == HorizontalAlignment.RIGHT ? LikeBoxCountView.LikeBoxCountViewCaretPosition.RIGHT : LikeBoxCountView.LikeBoxCountViewCaretPosition.LEFT);
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static abstract interface OnErrorListener
/*     */   {
/*     */     public abstract void onError(FacebookException paramFacebookException);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private class LikeControllerBroadcastReceiver
/*     */     extends BroadcastReceiver
/*     */   {
/*     */     private LikeControllerBroadcastReceiver() {}
/*     */     
/*     */ 
/*     */ 
/*     */     public void onReceive(Context context, Intent intent)
/*     */     {
/* 793 */       String intentAction = intent.getAction();
/* 794 */       Bundle extras = intent.getExtras();
/* 795 */       boolean shouldRespond = true;
/* 796 */       if (extras != null)
/*     */       {
/* 798 */         String broadcastObjectId = extras.getString("com.facebook.sdk.LikeActionController.OBJECT_ID");
/*     */         
/*     */ 
/* 801 */         shouldRespond = (Utility.isNullOrEmpty(broadcastObjectId)) || (Utility.areObjectsEqual(LikeView.this.objectId, broadcastObjectId));
/*     */       }
/*     */       
/* 804 */       if (!shouldRespond) {
/* 805 */         return;
/*     */       }
/*     */       
/* 808 */       if ("com.facebook.sdk.LikeActionController.UPDATED".equals(intentAction)) {
/* 809 */         LikeView.this.updateLikeStateAndLayout();
/* 810 */       } else if ("com.facebook.sdk.LikeActionController.DID_ERROR".equals(intentAction))
/*     */       {
/* 812 */         if (LikeView.this.onErrorListener != null) {
/* 813 */           LikeView.this.onErrorListener.onError(NativeProtocol.getExceptionFromErrorData(extras));
/*     */         }
/* 815 */       } else if ("com.facebook.sdk.LikeActionController.DID_RESET".equals(intentAction))
/*     */       {
/*     */ 
/* 818 */         LikeView.this.setObjectIdAndTypeForced(LikeView.this.objectId, LikeView.this.objectType);
/* 819 */         LikeView.this.updateLikeStateAndLayout();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private class LikeActionControllerCreationCallback implements LikeActionController.CreationCallback {
/*     */     private boolean isCancelled;
/*     */     
/*     */     private LikeActionControllerCreationCallback() {}
/*     */     
/* 829 */     public void cancel() { this.isCancelled = true; }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public void onComplete(LikeActionController likeActionController, FacebookException error)
/*     */     {
/* 836 */       if (this.isCancelled) {
/* 837 */         return;
/*     */       }
/*     */       
/* 840 */       if (likeActionController != null) {
/* 841 */         if (!likeActionController.shouldEnableView()) {
/* 842 */           error = new FacebookException("Cannot use LikeView. The device may not be supported.");
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 848 */         LikeView.this.associateWithLikeActionController(likeActionController);
/* 849 */         LikeView.this.updateLikeStateAndLayout();
/*     */       }
/*     */       
/* 852 */       if ((error != null) && 
/* 853 */         (LikeView.this.onErrorListener != null)) {
/* 854 */         LikeView.this.onErrorListener.onError(error);
/*     */       }
/*     */       
/*     */ 
/* 858 */       LikeView.this.creationCallback = null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/widget/LikeView.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */