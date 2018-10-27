/*     */ package com.facebook.share.internal;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.content.res.Resources;
/*     */ import android.graphics.Canvas;
/*     */ import android.graphics.Paint;
/*     */ import android.graphics.Paint.Style;
/*     */ import android.graphics.Path;
/*     */ import android.graphics.RectF;
/*     */ import android.widget.FrameLayout;
/*     */ import android.widget.FrameLayout.LayoutParams;
/*     */ import android.widget.TextView;
/*     */ import com.facebook.R.color;
/*     */ import com.facebook.R.dimen;
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
/*     */ public class LikeBoxCountView
/*     */   extends FrameLayout
/*     */ {
/*     */   private TextView likeCountLabel;
/*     */   
/*     */   public static enum LikeBoxCountViewCaretPosition
/*     */   {
/*  40 */     LEFT, 
/*  41 */     TOP, 
/*  42 */     RIGHT, 
/*  43 */     BOTTOM;
/*     */     
/*     */     private LikeBoxCountViewCaretPosition() {} }
/*     */   
/*  47 */   private LikeBoxCountViewCaretPosition caretPosition = LikeBoxCountViewCaretPosition.LEFT;
/*     */   
/*     */   private float caretHeight;
/*     */   
/*     */   private float caretWidth;
/*     */   
/*     */   private float borderRadius;
/*     */   
/*     */   private Paint borderPaint;
/*     */   
/*     */   private int textPadding;
/*     */   private int additionalTextPadding;
/*     */   
/*     */   public LikeBoxCountView(Context context)
/*     */   {
/*  62 */     super(context);
/*  63 */     initialize(context);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setText(String text)
/*     */   {
/*  71 */     this.likeCountLabel.setText(text);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCaretPosition(LikeBoxCountViewCaretPosition caretPosition)
/*     */   {
/*  79 */     this.caretPosition = caretPosition;
/*     */     
/*     */ 
/*     */ 
/*  83 */     switch (caretPosition) {
/*     */     case LEFT: 
/*  85 */       setAdditionalTextPadding(this.additionalTextPadding, 0, 0, 0);
/*  86 */       break;
/*     */     case TOP: 
/*  88 */       setAdditionalTextPadding(0, this.additionalTextPadding, 0, 0);
/*  89 */       break;
/*     */     case RIGHT: 
/*  91 */       setAdditionalTextPadding(0, 0, this.additionalTextPadding, 0);
/*  92 */       break;
/*     */     case BOTTOM: 
/*  94 */       setAdditionalTextPadding(0, 0, 0, this.additionalTextPadding);
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onDraw(Canvas canvas)
/*     */   {
/* 102 */     super.onDraw(canvas);
/*     */     
/* 104 */     int top = getPaddingTop();int left = getPaddingLeft();
/* 105 */     int right = getWidth() - getPaddingRight();int bottom = getHeight() - getPaddingBottom();
/*     */     
/* 107 */     switch (this.caretPosition) {
/*     */     case BOTTOM: 
/* 109 */       bottom = (int)(bottom - this.caretHeight);
/* 110 */       break;
/*     */     case LEFT: 
/* 112 */       left = (int)(left + this.caretHeight);
/* 113 */       break;
/*     */     case TOP: 
/* 115 */       top = (int)(top + this.caretHeight);
/* 116 */       break;
/*     */     case RIGHT: 
/* 118 */       right = (int)(right - this.caretHeight);
/*     */     }
/*     */     
/*     */     
/* 122 */     drawBorder(canvas, left, top, right, bottom);
/*     */   }
/*     */   
/*     */   private void initialize(Context context) {
/* 126 */     setWillNotDraw(false);
/* 127 */     this.caretHeight = getResources().getDimension(R.dimen.com_facebook_likeboxcountview_caret_height);
/* 128 */     this.caretWidth = getResources().getDimension(R.dimen.com_facebook_likeboxcountview_caret_width);
/* 129 */     this.borderRadius = getResources().getDimension(R.dimen.com_facebook_likeboxcountview_border_radius);
/*     */     
/* 131 */     this.borderPaint = new Paint();
/* 132 */     this.borderPaint.setColor(
/* 133 */       getResources().getColor(R.color.com_facebook_likeboxcountview_border_color));
/* 134 */     this.borderPaint.setStrokeWidth(getResources().getDimension(R.dimen.com_facebook_likeboxcountview_border_width));
/* 135 */     this.borderPaint.setStyle(Style.STROKE);
/*     */     
/* 137 */     initializeLikeCountLabel(context);
/*     */     
/* 139 */     addView(this.likeCountLabel);
/*     */     
/* 141 */     setCaretPosition(this.caretPosition);
/*     */   }
/*     */   
/*     */   private void initializeLikeCountLabel(Context context) {
/* 145 */     this.likeCountLabel = new TextView(context);
/* 146 */     LayoutParams likeCountLabelLayoutParams = new LayoutParams(-1, -1);
/*     */     
/*     */ 
/* 149 */     this.likeCountLabel.setLayoutParams(likeCountLabelLayoutParams);
/* 150 */     this.likeCountLabel.setGravity(17);
/* 151 */     this.likeCountLabel.setTextSize(0, 
/*     */     
/* 153 */       getResources().getDimension(R.dimen.com_facebook_likeboxcountview_text_size));
/* 154 */     this.likeCountLabel.setTextColor(
/* 155 */       getResources().getColor(R.color.com_facebook_likeboxcountview_text_color));
/* 156 */     this.textPadding = getResources().getDimensionPixelSize(R.dimen.com_facebook_likeboxcountview_text_padding);
/*     */     
/*     */ 
/* 159 */     this.additionalTextPadding = getResources().getDimensionPixelSize(R.dimen.com_facebook_likeboxcountview_caret_height);
/*     */   }
/*     */   
/*     */   private void setAdditionalTextPadding(int left, int top, int right, int bottom) {
/* 163 */     this.likeCountLabel.setPadding(this.textPadding + left, this.textPadding + top, this.textPadding + right, this.textPadding + bottom);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void drawBorder(Canvas canvas, float left, float top, float right, float bottom)
/*     */   {
/* 171 */     Path borderPath = new Path();
/*     */     
/* 173 */     float ovalSize = 2.0F * this.borderRadius;
/*     */     
/*     */ 
/* 176 */     borderPath.addArc(new RectF(left, top, left + ovalSize, top + ovalSize), -180.0F, 90.0F);
/*     */     
/*     */ 
/* 179 */     if (this.caretPosition == LikeBoxCountViewCaretPosition.TOP) {
/* 180 */       borderPath.lineTo(left + (right - left - this.caretWidth) / 2.0F, top);
/* 181 */       borderPath.lineTo(left + (right - left) / 2.0F, top - this.caretHeight);
/* 182 */       borderPath.lineTo(left + (right - left + this.caretWidth) / 2.0F, top);
/*     */     }
/*     */     
/*     */ 
/* 186 */     borderPath.lineTo(right - this.borderRadius, top);
/*     */     
/*     */ 
/* 189 */     borderPath.addArc(new RectF(right - ovalSize, top, right, top + ovalSize), -90.0F, 90.0F);
/*     */     
/*     */ 
/* 192 */     if (this.caretPosition == LikeBoxCountViewCaretPosition.RIGHT) {
/* 193 */       borderPath.lineTo(right, top + (bottom - top - this.caretWidth) / 2.0F);
/* 194 */       borderPath.lineTo(right + this.caretHeight, top + (bottom - top) / 2.0F);
/* 195 */       borderPath.lineTo(right, top + (bottom - top + this.caretWidth) / 2.0F);
/*     */     }
/*     */     
/*     */ 
/* 199 */     borderPath.lineTo(right, bottom - this.borderRadius);
/*     */     
/*     */ 
/* 202 */     borderPath.addArc(new RectF(right - ovalSize, bottom - ovalSize, right, bottom), 0.0F, 90.0F);
/*     */     
/*     */ 
/* 205 */     if (this.caretPosition == LikeBoxCountViewCaretPosition.BOTTOM) {
/* 206 */       borderPath.lineTo(left + (right - left + this.caretWidth) / 2.0F, bottom);
/* 207 */       borderPath.lineTo(left + (right - left) / 2.0F, bottom + this.caretHeight);
/* 208 */       borderPath.lineTo(left + (right - left - this.caretWidth) / 2.0F, bottom);
/*     */     }
/*     */     
/*     */ 
/* 212 */     borderPath.lineTo(left + this.borderRadius, bottom);
/*     */     
/*     */ 
/* 215 */     borderPath.addArc(new RectF(left, bottom - ovalSize, left + ovalSize, bottom), 90.0F, 90.0F);
/*     */     
/*     */ 
/* 218 */     if (this.caretPosition == LikeBoxCountViewCaretPosition.LEFT) {
/* 219 */       borderPath.lineTo(left, top + (bottom - top + this.caretWidth) / 2.0F);
/* 220 */       borderPath.lineTo(left - this.caretHeight, top + (bottom - top) / 2.0F);
/* 221 */       borderPath.lineTo(left, top + (bottom - top - this.caretWidth) / 2.0F);
/*     */     }
/*     */     
/*     */ 
/* 225 */     borderPath.lineTo(left, top + this.borderRadius);
/*     */     
/* 227 */     canvas.drawPath(borderPath, this.borderPaint);
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/internal/LikeBoxCountView.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */