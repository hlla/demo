/*    */ package com.facebook.share.widget;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.util.AttributeSet;
/*    */ import com.facebook.R.style;
/*    */ import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
/*    */ import com.facebook.internal.FacebookDialogBase;
/*    */ import com.facebook.share.Sharer.Result;
/*    */ import com.facebook.share.model.ShareContent;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class ShareButton
/*    */   extends ShareButtonBase
/*    */ {
/*    */   public ShareButton(Context context)
/*    */   {
/* 40 */     super(context, null, 0, "fb_share_button_create", "fb_share_button_did_tap");
/*    */   }
/*    */   
/*    */   public ShareButton(Context context, AttributeSet attrs)
/*    */   {
/* 45 */     super(context, attrs, 0, "fb_share_button_create", "fb_share_button_did_tap");
/*    */   }
/*    */   
/*    */   public ShareButton(Context context, AttributeSet attrs, int defStyleAttr)
/*    */   {
/* 50 */     super(context, attrs, defStyleAttr, "fb_share_button_create", "fb_share_button_did_tap");
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected int getDefaultStyleResource()
/*    */   {
/* 60 */     return R.style.com_facebook_button_share;
/*    */   }
/*    */   
/*    */   protected int getDefaultRequestCode()
/*    */   {
/* 65 */     return CallbackManagerImpl.RequestCodeOffset.Share.toRequestCode();
/*    */   }
/*    */   
/*    */   protected FacebookDialogBase<ShareContent, Sharer.Result> getDialog() {
/*    */     ShareDialog dialog;
/*    */     ShareDialog dialog;
/* 71 */     if (getFragment() != null) {
/* 72 */       dialog = new ShareDialog(getFragment(), getRequestCode()); } else { ShareDialog dialog;
/* 73 */       if (getNativeFragment() != null) {
/* 74 */         dialog = new ShareDialog(getNativeFragment(), getRequestCode());
/*    */       } else
/* 76 */         dialog = new ShareDialog(getActivity(), getRequestCode());
/*    */     }
/* 78 */     return dialog;
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/widget/ShareButton.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */