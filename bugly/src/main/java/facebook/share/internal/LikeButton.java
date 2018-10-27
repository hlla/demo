/*    */ package com.facebook.share.internal;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.content.res.Resources;
/*    */ import android.util.AttributeSet;
/*    */ import com.facebook.FacebookButtonBase;
/*    */ import com.facebook.R.drawable;
/*    */ import com.facebook.R.string;
/*    */ import com.facebook.R.style;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LikeButton
/*    */   extends FacebookButtonBase
/*    */ {
/*    */   public LikeButton(Context context, boolean isLiked)
/*    */   {
/* 36 */     super(context, null, 0, 0, "fb_like_button_create", "fb_like_button_did_tap");
/*    */     
/* 38 */     setSelected(isLiked);
/*    */   }
/*    */   
/*    */   public void setSelected(boolean selected)
/*    */   {
/* 43 */     super.setSelected(selected);
/* 44 */     updateForLikeStatus();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void configureButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
/*    */   {
/* 53 */     super.configureButton(context, attrs, defStyleAttr, defStyleRes);
/* 54 */     updateForLikeStatus();
/*    */   }
/*    */   
/*    */   protected int getDefaultRequestCode()
/*    */   {
/* 59 */     return 0;
/*    */   }
/*    */   
/*    */   protected int getDefaultStyleResource()
/*    */   {
/* 64 */     return R.style.com_facebook_button_like;
/*    */   }
/*    */   
/*    */   private void updateForLikeStatus()
/*    */   {
/* 69 */     if (isSelected()) {
/* 70 */       setCompoundDrawablesWithIntrinsicBounds(R.drawable.com_facebook_button_like_icon_selected, 0, 0, 0);
/*    */       
/* 72 */       setText(getResources().getString(R.string.com_facebook_like_button_liked));
/*    */     } else {
/* 74 */       setCompoundDrawablesWithIntrinsicBounds(R.drawable.com_facebook_button_icon, 0, 0, 0);
/*    */       
/* 76 */       setText(getResources().getString(R.string.com_facebook_like_button_not_liked));
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/internal/LikeButton.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */