/*     */ package com.facebook.internal;
/*     */ 
/*     */ import android.app.Dialog;
/*     */ import android.content.Intent;
/*     */ import android.content.res.Configuration;
/*     */ import android.os.Bundle;
/*     */ import android.support.annotation.NonNull;
/*     */ import android.support.v4.app.DialogFragment;
/*     */ import android.support.v4.app.FragmentActivity;
/*     */ import com.facebook.FacebookException;
/*     */ import com.facebook.FacebookSdk;
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
/*     */ public class FacebookDialogFragment
/*     */   extends DialogFragment
/*     */ {
/*     */   private Dialog dialog;
/*     */   public static final String TAG = "FacebookDialogFragment";
/*     */   
/*     */   public void setDialog(Dialog dialog)
/*     */   {
/*  50 */     this.dialog = dialog;
/*     */   }
/*     */   
/*     */   public void onCreate(Bundle savedInstanceState)
/*     */   {
/*  55 */     super.onCreate(savedInstanceState);
/*     */     
/*  57 */     if (this.dialog == null) {
/*  58 */       FragmentActivity activity = getActivity();
/*  59 */       Intent intent = activity.getIntent();
/*  60 */       Bundle params = NativeProtocol.getMethodArgumentsFromIntent(intent);
/*     */       
/*  62 */       boolean isWebFallback = params.getBoolean("is_fallback", false);
/*     */       WebDialog webDialog;
/*  64 */       WebDialog webDialog; if (!isWebFallback) {
/*  65 */         String actionName = params.getString("action");
/*  66 */         Bundle webParams = params.getBundle("params");
/*  67 */         if (Utility.isNullOrEmpty(actionName)) {
/*  68 */           Utility.logd("FacebookDialogFragment", "Cannot start a WebDialog with an empty/missing 'actionName'");
/*     */           
/*     */ 
/*  71 */           activity.finish();
/*  72 */           return;
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  82 */         webDialog = new WebDialog.Builder(activity, actionName, webParams).setOnCompleteListener(new WebDialog.OnCompleteListener()
/*     */         {
/*     */           public void onComplete(Bundle values, FacebookException error)
/*     */           {
/*  79 */             FacebookDialogFragment.this.onCompleteWebDialog(values, error);
/*     */           }
/*     */         }).build();
/*     */       }
/*     */       else {
/*  84 */         String url = params.getString("url");
/*  85 */         if (Utility.isNullOrEmpty(url)) {
/*  86 */           Utility.logd("FacebookDialogFragment", "Cannot start a fallback WebDialog with an empty/missing 'url'");
/*     */           
/*     */ 
/*  89 */           activity.finish();
/*  90 */           return;
/*     */         }
/*     */         
/*     */ 
/*  94 */         String redirectUrl = String.format("fb%s://bridge/", new Object[] { FacebookSdk.getApplicationId() });
/*  95 */         webDialog = new FacebookWebFallbackDialog(activity, url, redirectUrl);
/*  96 */         webDialog.setOnCompleteListener(new WebDialog.OnCompleteListener()
/*     */         {
/*     */ 
/*     */           public void onComplete(Bundle values, FacebookException error)
/*     */           {
/* 101 */             FacebookDialogFragment.this.onCompleteWebFallbackDialog(values);
/*     */           }
/*     */         });
/*     */       }
/*     */       
/* 106 */       this.dialog = webDialog;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   @NonNull
/*     */   public Dialog onCreateDialog(Bundle savedInstanceState)
/*     */   {
/* 114 */     if (this.dialog == null) {
/* 115 */       onCompleteWebDialog(null, null);
/* 116 */       setShowsDialog(false);
/*     */     }
/* 118 */     return this.dialog;
/*     */   }
/*     */   
/*     */   public void onResume()
/*     */   {
/* 123 */     super.onResume();
/* 124 */     if ((this.dialog instanceof WebDialog)) {
/* 125 */       ((WebDialog)this.dialog).resize();
/*     */     }
/*     */   }
/*     */   
/*     */   public void onConfigurationChanged(Configuration newConfig)
/*     */   {
/* 131 */     super.onConfigurationChanged(newConfig);
/* 132 */     if (((this.dialog instanceof WebDialog)) && (isResumed())) {
/* 133 */       ((WebDialog)this.dialog).resize();
/*     */     }
/*     */   }
/*     */   
/*     */   public void onDestroyView()
/*     */   {
/* 139 */     if ((getDialog() != null) && (getRetainInstance())) {
/* 140 */       getDialog().setDismissMessage(null);
/*     */     }
/* 142 */     super.onDestroyView();
/*     */   }
/*     */   
/*     */   private void onCompleteWebDialog(Bundle values, FacebookException error) {
/* 146 */     FragmentActivity fragmentActivity = getActivity();
/*     */     
/* 148 */     Intent resultIntent = NativeProtocol.createProtocolResultIntent(fragmentActivity
/* 149 */       .getIntent(), values, error);
/*     */     
/*     */ 
/*     */ 
/* 153 */     int resultCode = error == null ? -1 : 0;
/*     */     
/* 155 */     fragmentActivity.setResult(resultCode, resultIntent);
/* 156 */     fragmentActivity.finish();
/*     */   }
/*     */   
/*     */   private void onCompleteWebFallbackDialog(Bundle values) {
/* 160 */     FragmentActivity fragmentActivity = getActivity();
/*     */     
/* 162 */     Intent resultIntent = new Intent();
/* 163 */     resultIntent.putExtras(values == null ? new Bundle() : values);
/*     */     
/* 165 */     fragmentActivity.setResult(-1, resultIntent);
/* 166 */     fragmentActivity.finish();
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/FacebookDialogFragment.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */