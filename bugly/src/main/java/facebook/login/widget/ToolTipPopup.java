/*     */ package com.facebook.login.widget;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.content.Context;
/*     */ import android.view.LayoutInflater;
/*     */ import android.view.View;
/*     */ import android.view.View.MeasureSpec;
/*     */ import android.view.View.OnClickListener;
/*     */ import android.view.ViewTreeObserver;
/*     */ import android.view.ViewTreeObserver.OnScrollChangedListener;
/*     */ import android.view.Window;
/*     */ import android.widget.FrameLayout;
/*     */ import android.widget.ImageView;
/*     */ import android.widget.PopupWindow;
/*     */ import android.widget.TextView;
/*     */ import com.facebook.R.drawable;
/*     */ import com.facebook.R.id;
/*     */ import com.facebook.R.layout;
/*     */ import java.lang.ref.WeakReference;
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
/*     */ public class ToolTipPopup
/*     */ {
/*     */   public static final long DEFAULT_POPUP_DISPLAY_TIME = 6000L;
/*     */   private final String mText;
/*     */   private final WeakReference<View> mAnchorViewRef;
/*     */   private final Context mContext;
/*     */   private PopupContentView mPopupContent;
/*     */   private PopupWindow mPopupWindow;
/*     */   
/*     */   public static enum Style
/*     */   {
/*  50 */     BLUE, 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  56 */     BLACK;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private Style() {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  69 */   private Style mStyle = Style.BLUE;
/*  70 */   private long mNuxDisplayTime = 6000L;
/*     */   
/*  72 */   private final OnScrollChangedListener mScrollListener = new OnScrollChangedListener()
/*     */   {
/*     */     public void onScrollChanged()
/*     */     {
/*  76 */       if ((ToolTipPopup.this.mAnchorViewRef.get() != null) && 
/*  77 */         (ToolTipPopup.this.mPopupWindow != null) && 
/*  78 */         (ToolTipPopup.this.mPopupWindow.isShowing())) {
/*  79 */         if (ToolTipPopup.this.mPopupWindow.isAboveAnchor()) {
/*  80 */           ToolTipPopup.this.mPopupContent.showBottomArrow();
/*     */         } else {
/*  82 */           ToolTipPopup.this.mPopupContent.showTopArrow();
/*     */         }
/*     */       }
/*     */     }
/*     */   };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ToolTipPopup(String text, View anchor)
/*     */   {
/*  94 */     this.mText = text;
/*  95 */     this.mAnchorViewRef = new WeakReference(anchor);
/*  96 */     this.mContext = anchor.getContext();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setStyle(Style mStyle)
/*     */   {
/* 104 */     this.mStyle = mStyle;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void show()
/*     */   {
/* 111 */     if (this.mAnchorViewRef.get() != null) {
/* 112 */       this.mPopupContent = new PopupContentView(this.mContext);
/* 113 */       TextView body = (TextView)this.mPopupContent.findViewById(R.id.com_facebook_tooltip_bubble_view_text_body);
/*     */       
/* 115 */       body.setText(this.mText);
/* 116 */       if (this.mStyle == Style.BLUE) {
/* 117 */         this.mPopupContent.bodyFrame.setBackgroundResource(R.drawable.com_facebook_tooltip_blue_background);
/*     */         
/* 119 */         this.mPopupContent.bottomArrow.setImageResource(R.drawable.com_facebook_tooltip_blue_bottomnub);
/*     */         
/* 121 */         this.mPopupContent.topArrow.setImageResource(R.drawable.com_facebook_tooltip_blue_topnub);
/*     */         
/* 123 */         this.mPopupContent.xOut.setImageResource(R.drawable.com_facebook_tooltip_blue_xout);
/*     */       } else {
/* 125 */         this.mPopupContent.bodyFrame.setBackgroundResource(R.drawable.com_facebook_tooltip_black_background);
/*     */         
/* 127 */         this.mPopupContent.bottomArrow.setImageResource(R.drawable.com_facebook_tooltip_black_bottomnub);
/*     */         
/* 129 */         this.mPopupContent.topArrow.setImageResource(R.drawable.com_facebook_tooltip_black_topnub);
/*     */         
/* 131 */         this.mPopupContent.xOut.setImageResource(R.drawable.com_facebook_tooltip_black_xout);
/*     */       }
/*     */       
/* 134 */       Window window = ((Activity)this.mContext).getWindow();
/* 135 */       View decorView = window.getDecorView();
/* 136 */       int decorWidth = decorView.getWidth();
/* 137 */       int decorHeight = decorView.getHeight();
/* 138 */       registerObserver();
/* 139 */       this.mPopupContent.measure(
/* 140 */         MeasureSpec.makeMeasureSpec(decorWidth, Integer.MIN_VALUE),
/* 141 */         MeasureSpec.makeMeasureSpec(decorHeight, Integer.MIN_VALUE));
/*     */       
/*     */ 
/*     */ 
/* 145 */       this.mPopupWindow = new PopupWindow(this.mPopupContent, this.mPopupContent.getMeasuredWidth(), this.mPopupContent.getMeasuredHeight());
/* 146 */       this.mPopupWindow.showAsDropDown((View)this.mAnchorViewRef.get());
/* 147 */       updateArrows();
/* 148 */       if (this.mNuxDisplayTime > 0L) {
/* 149 */         this.mPopupContent.postDelayed(new Runnable()
/*     */         {
/*     */ 
/* 152 */           public void run() { ToolTipPopup.this.dismiss(); } }, this.mNuxDisplayTime);
/*     */       }
/*     */       
/*     */ 
/* 156 */       this.mPopupWindow.setTouchable(true);
/* 157 */       this.mPopupContent.setOnClickListener(new OnClickListener()
/*     */       {
/*     */         public void onClick(View v) {
/* 160 */           ToolTipPopup.this.dismiss();
/*     */         }
/*     */       });
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNuxDisplayTime(long displayTime)
/*     */   {
/* 172 */     this.mNuxDisplayTime = displayTime;
/*     */   }
/*     */   
/*     */   private void updateArrows() {
/* 176 */     if ((this.mPopupWindow != null) && (this.mPopupWindow.isShowing())) {
/* 177 */       if (this.mPopupWindow.isAboveAnchor()) {
/* 178 */         this.mPopupContent.showBottomArrow();
/*     */       } else {
/* 180 */         this.mPopupContent.showTopArrow();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void dismiss()
/*     */   {
/* 189 */     unregisterObserver();
/* 190 */     if (this.mPopupWindow != null) {
/* 191 */       this.mPopupWindow.dismiss();
/*     */     }
/*     */   }
/*     */   
/*     */   private void registerObserver() {
/* 196 */     unregisterObserver();
/* 197 */     if (this.mAnchorViewRef.get() != null) {
/* 198 */       ((View)this.mAnchorViewRef.get()).getViewTreeObserver().addOnScrollChangedListener(this.mScrollListener);
/*     */     }
/*     */   }
/*     */   
/*     */   private void unregisterObserver() {
/* 203 */     if (this.mAnchorViewRef.get() != null) {
/* 204 */       ((View)this.mAnchorViewRef.get()).getViewTreeObserver().removeOnScrollChangedListener(this.mScrollListener);
/*     */     }
/*     */   }
/*     */   
/*     */   private class PopupContentView extends FrameLayout
/*     */   {
/*     */     private ImageView topArrow;
/*     */     private ImageView bottomArrow;
/*     */     private View bodyFrame;
/*     */     private ImageView xOut;
/*     */     
/*     */     public PopupContentView(Context context) {
/* 216 */       super();
/* 217 */       init();
/*     */     }
/*     */     
/*     */     private void init() {
/* 221 */       LayoutInflater inflater = LayoutInflater.from(getContext());
/* 222 */       inflater.inflate(R.layout.com_facebook_tooltip_bubble, this);
/* 223 */       this.topArrow = ((ImageView)findViewById(R.id.com_facebook_tooltip_bubble_view_top_pointer));
/* 224 */       this.bottomArrow = ((ImageView)findViewById(R.id.com_facebook_tooltip_bubble_view_bottom_pointer));
/*     */       
/* 226 */       this.bodyFrame = findViewById(R.id.com_facebook_body_frame);
/* 227 */       this.xOut = ((ImageView)findViewById(R.id.com_facebook_button_xout));
/*     */     }
/*     */     
/*     */     public void showTopArrow() {
/* 231 */       this.topArrow.setVisibility(0);
/* 232 */       this.bottomArrow.setVisibility(4);
/*     */     }
/*     */     
/*     */     public void showBottomArrow() {
/* 236 */       this.topArrow.setVisibility(4);
/* 237 */       this.bottomArrow.setVisibility(0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/login/widget/ToolTipPopup.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */