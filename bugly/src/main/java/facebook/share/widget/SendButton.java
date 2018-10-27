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
/*    */ public final class SendButton
/*    */   extends ShareButtonBase
/*    */ {
/*    */   public SendButton(Context context)
/*    */   {
/* 39 */     super(context, null, 0, "fb_send_button_create", "fb_send_button_did_tap");
/*    */   }
/*    */   
/*    */   public SendButton(Context context, AttributeSet attrs)
/*    */   {
/* 44 */     super(context, attrs, 0, "fb_send_button_create", "fb_send_button_did_tap");
/*    */   }
/*    */   
/*    */   public SendButton(Context context, AttributeSet attrs, int defStyleAttr)
/*    */   {
/* 49 */     super(context, attrs, defStyleAttr, "fb_send_button_create", "fb_send_button_did_tap");
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected int getDefaultStyleResource()
/*    */   {
/* 59 */     return R.style.com_facebook_button_send;
/*    */   }
/*    */   
/*    */   protected int getDefaultRequestCode()
/*    */   {
/* 64 */     return CallbackManagerImpl.RequestCodeOffset.Message.toRequestCode();
/*    */   }
/*    */   
/*    */   protected FacebookDialogBase<ShareContent, Sharer.Result> getDialog() {
/*    */     MessageDialog dialog;
/*    */     MessageDialog dialog;
/* 70 */     if (getFragment() != null) {
/* 71 */       dialog = new MessageDialog(getFragment(), getRequestCode()); } else { MessageDialog dialog;
/* 72 */       if (getNativeFragment() != null) {
/* 73 */         dialog = new MessageDialog(getNativeFragment(), getRequestCode());
/*    */       } else
/* 75 */         dialog = new MessageDialog(getActivity(), getRequestCode());
/*    */     }
/* 77 */     return dialog;
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/widget/SendButton.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */