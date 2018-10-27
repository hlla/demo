/*     */ package com.facebook.share.widget;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.content.Intent;
/*     */ import android.os.Bundle;
/*     */ import android.text.TextUtils;
/*     */ import android.util.Log;
/*     */ import com.facebook.FacebookCallback;
/*     */ import com.facebook.internal.AppCall;
/*     */ import com.facebook.internal.CallbackManagerImpl;
/*     */ import com.facebook.internal.CallbackManagerImpl.Callback;
/*     */ import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
/*     */ import com.facebook.internal.DialogFeature;
/*     */ import com.facebook.internal.DialogPresenter;
/*     */ import com.facebook.internal.DialogPresenter.ParameterProvider;
/*     */ import com.facebook.internal.FacebookDialogBase;
/*     */ import com.facebook.internal.FacebookDialogBase.ModeHandler;
/*     */ import com.facebook.internal.FragmentWrapper;
/*     */ import com.facebook.share.internal.AppInviteDialogFeature;
/*     */ import com.facebook.share.internal.ResultProcessor;
/*     */ import com.facebook.share.internal.ShareInternalUtility;
/*     */ import com.facebook.share.model.AppInviteContent;
/*     */ import com.facebook.share.model.AppInviteContent.Builder.Destination;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.json.JSONException;
/*     */ import org.json.JSONObject;
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
/*     */ public class AppInviteDialog
/*     */   extends FacebookDialogBase<AppInviteContent, Result>
/*     */ {
/*     */   private static final String TAG = "AppInviteDialog";
/*     */   
/*     */   public static final class Result
/*     */   {
/*     */     private final Bundle bundle;
/*     */     
/*     */     public Result(Bundle bundle)
/*     */     {
/*  59 */       this.bundle = bundle;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Bundle getData()
/*     */     {
/*  68 */       return this.bundle;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*  74 */   private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.AppInvite
/*  75 */     .toRequestCode();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean canShow()
/*     */   {
/*  83 */     return (canShowNativeDialog()) || (canShowWebFallback());
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
/*     */   public static void show(Activity activity, AppInviteContent appInviteContent)
/*     */   {
/*  97 */     new AppInviteDialog(activity).show(appInviteContent);
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
/*     */   public static void show(android.support.v4.app.Fragment fragment, AppInviteContent appInviteContent)
/*     */   {
/* 110 */     show(new FragmentWrapper(fragment), appInviteContent);
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
/*     */   public static void show(android.app.Fragment fragment, AppInviteContent appInviteContent)
/*     */   {
/* 123 */     show(new FragmentWrapper(fragment), appInviteContent);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static void show(FragmentWrapper fragmentWrapper, AppInviteContent appInviteContent)
/*     */   {
/* 130 */     new AppInviteDialog(fragmentWrapper).show(appInviteContent);
/*     */   }
/*     */   
/*     */   private static boolean canShowNativeDialog() {
/* 134 */     return DialogPresenter.canPresentNativeDialogWithFeature(getFeature());
/*     */   }
/*     */   
/*     */   private static boolean canShowWebFallback() {
/* 138 */     return DialogPresenter.canPresentWebFallbackDialogWithFeature(getFeature());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public AppInviteDialog(Activity activity)
/*     */   {
/* 147 */     super(activity, DEFAULT_REQUEST_CODE);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public AppInviteDialog(android.support.v4.app.Fragment fragment)
/*     */   {
/* 156 */     this(new FragmentWrapper(fragment));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public AppInviteDialog(android.app.Fragment fragment)
/*     */   {
/* 165 */     this(new FragmentWrapper(fragment));
/*     */   }
/*     */   
/*     */   private AppInviteDialog(FragmentWrapper fragment) {
/* 169 */     super(fragment, DEFAULT_REQUEST_CODE);
/*     */   }
/*     */   
/*     */ 
/*     */   protected void registerCallbackImpl(CallbackManagerImpl callbackManager, final FacebookCallback<Result> callback)
/*     */   {
/* 175 */     final ResultProcessor resultProcessor = callback == null ? null : new ResultProcessor(callback)
/*     */     {
/*     */ 
/*     */       public void onSuccess(AppCall appCall, Bundle results)
/*     */       {
/* 180 */         String gesture = ShareInternalUtility.getNativeDialogCompletionGesture(results);
/* 181 */         if ("cancel".equalsIgnoreCase(gesture)) {
/* 182 */           callback.onCancel();
/*     */         } else {
/* 184 */           callback.onSuccess(new Result(results));
/*     */         }
/*     */         
/*     */       }
/* 188 */     };
/* 189 */     CallbackManagerImpl.Callback callbackManagerCallback = new CallbackManagerImpl.Callback()
/*     */     {
/*     */       public boolean onActivityResult(int resultCode, Intent data) {
/* 192 */         return ShareInternalUtility.handleActivityResult(AppInviteDialog.this
/* 193 */           .getRequestCode(), resultCode, data, resultProcessor);
/*     */ 
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 199 */     };
/* 200 */     callbackManager.registerCallback(
/* 201 */       getRequestCode(), callbackManagerCallback);
/*     */   }
/*     */   
/*     */ 
/*     */   protected AppCall createBaseAppCall()
/*     */   {
/* 207 */     return new AppCall(getRequestCode());
/*     */   }
/*     */   
/*     */   protected List<FacebookDialogBase<AppInviteContent, Result>.ModeHandler> getOrderedModeHandlers()
/*     */   {
/* 212 */     ArrayList<FacebookDialogBase<AppInviteContent, Result>.ModeHandler> handlers = new ArrayList();
/* 213 */     handlers.add(new NativeHandler(null));
/* 214 */     handlers.add(new WebFallbackHandler(null));
/*     */     
/* 216 */     return handlers;
/*     */   }
/*     */   
/* 219 */   private class NativeHandler extends FacebookDialogBase<AppInviteContent, Result>.ModeHandler { private NativeHandler() { super(); }
/*     */     
/*     */     public boolean canShow(AppInviteContent content, boolean isBestEffort) {
/* 222 */       return AppInviteDialog.access$200();
/*     */     }
/*     */     
/*     */     public AppCall createAppCall(final AppInviteContent content)
/*     */     {
/* 227 */       AppCall appCall = AppInviteDialog.this.createBaseAppCall();
/*     */       
/* 229 */       DialogPresenter.setupAppCallForNativeDialog(appCall, new DialogPresenter.ParameterProvider()
/*     */       {
/*     */ 
/*     */         public Bundle getParameters()
/*     */         {
/* 234 */           return AppInviteDialog.createParameters(content);
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */         public Bundle getLegacyParameters()
/*     */         {
/* 241 */           Log.e("AppInviteDialog", "Attempting to present the AppInviteDialog with an outdated Facebook app on the device");
/*     */           
/* 243 */           return new Bundle();
/*     */         }
/*     */         
/* 246 */       }, AppInviteDialog.access$400());
/*     */       
/* 248 */       return appCall;
/*     */     }
/*     */   }
/*     */   
/* 252 */   private class WebFallbackHandler extends FacebookDialogBase<AppInviteContent, Result>.ModeHandler { private WebFallbackHandler() { super(); }
/*     */     
/*     */     public boolean canShow(AppInviteContent content, boolean isBestEffort) {
/* 255 */       return AppInviteDialog.access$500();
/*     */     }
/*     */     
/*     */     public AppCall createAppCall(AppInviteContent content)
/*     */     {
/* 260 */       AppCall appCall = AppInviteDialog.this.createBaseAppCall();
/*     */       
/* 262 */       DialogPresenter.setupAppCallForWebFallbackDialog(appCall, 
/*     */       
/* 264 */         AppInviteDialog.createParameters(content), 
/* 265 */         AppInviteDialog.access$400());
/*     */       
/* 267 */       return appCall;
/*     */     }
/*     */   }
/*     */   
/*     */   private static DialogFeature getFeature() {
/* 272 */     return AppInviteDialogFeature.APP_INVITES_DIALOG;
/*     */   }
/*     */   
/*     */   private static Bundle createParameters(AppInviteContent content) {
/* 276 */     Bundle params = new Bundle();
/* 277 */     params.putString("app_link_url", content.getApplinkUrl());
/* 278 */     params.putString("preview_image_url", content.getPreviewImageUrl());
/* 279 */     params.putString("destination", content
/*     */     
/* 281 */       .getDestination().toString());
/*     */     
/*     */ 
/* 284 */     String promoCode = content.getPromotionCode();
/* 285 */     promoCode = promoCode != null ? promoCode : "";
/* 286 */     String promoText = content.getPromotionText();
/*     */     
/* 288 */     if (!TextUtils.isEmpty(promoText)) {
/*     */       try
/*     */       {
/* 291 */         JSONObject deeplinkContent = new JSONObject();
/* 292 */         deeplinkContent.put("promo_code", promoCode);
/* 293 */         deeplinkContent.put("promo_text", promoText);
/*     */         
/* 295 */         params.putString("deeplink_context", deeplinkContent.toString());
/* 296 */         params.putString("promo_code", promoCode);
/* 297 */         params.putString("promo_text", promoText);
/*     */       } catch (JSONException e) {
/* 299 */         Log.e("AppInviteDialog", "Json Exception in creating deeplink context");
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 304 */     return params;
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/widget/AppInviteDialog.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */