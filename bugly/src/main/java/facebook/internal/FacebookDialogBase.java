/*     */ package com.facebook.internal;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.content.Intent;
/*     */ import android.util.Log;
/*     */ import com.facebook.CallbackManager;
/*     */ import com.facebook.FacebookCallback;
/*     */ import com.facebook.FacebookDialog;
/*     */ import com.facebook.FacebookException;
/*     */ import com.facebook.FacebookSdk;
/*     */ import com.facebook.LoggingBehavior;
/*     */ import java.util.List;
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
/*     */ public abstract class FacebookDialogBase<CONTENT, RESULT>
/*     */   implements FacebookDialog<CONTENT, RESULT>
/*     */ {
/*     */   private static final String TAG = "FacebookDialog";
/*  46 */   protected static final Object BASE_AUTOMATIC_MODE = new Object();
/*     */   private final Activity activity;
/*     */   private final FragmentWrapper fragmentWrapper;
/*     */   private List<ModeHandler> modeHandlers;
/*     */   private int requestCode;
/*     */   
/*     */   protected FacebookDialogBase(Activity activity, int requestCode)
/*     */   {
/*  54 */     Validate.notNull(activity, "activity");
/*  55 */     this.activity = activity;
/*  56 */     this.fragmentWrapper = null;
/*  57 */     this.requestCode = requestCode;
/*     */   }
/*     */   
/*     */   protected FacebookDialogBase(FragmentWrapper fragmentWrapper, int requestCode) {
/*  61 */     Validate.notNull(fragmentWrapper, "fragmentWrapper");
/*  62 */     this.fragmentWrapper = fragmentWrapper;
/*  63 */     this.activity = null;
/*  64 */     this.requestCode = requestCode;
/*     */     
/*  66 */     if (fragmentWrapper.getActivity() == null) {
/*  67 */       throw new IllegalArgumentException("Cannot use a fragment that is not attached to an activity");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void registerCallback(CallbackManager callbackManager, FacebookCallback<RESULT> callback)
/*     */   {
/*  76 */     if (!(callbackManager instanceof CallbackManagerImpl)) {
/*  77 */       throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
/*     */     }
/*     */     
/*  80 */     registerCallbackImpl((CallbackManagerImpl)callbackManager, callback);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void registerCallback(CallbackManager callbackManager, FacebookCallback<RESULT> callback, int requestCode)
/*     */   {
/*  88 */     setRequestCode(requestCode);
/*  89 */     registerCallback(callbackManager, callback);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected abstract void registerCallbackImpl(CallbackManagerImpl paramCallbackManagerImpl, FacebookCallback<RESULT> paramFacebookCallback);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void setRequestCode(int requestCode)
/*     */   {
/* 104 */     if (FacebookSdk.isFacebookRequestCode(requestCode)) {
/* 105 */       throw new IllegalArgumentException("Request code " + requestCode + " cannot be within the range reserved by the Facebook SDK.");
/*     */     }
/*     */     
/* 108 */     this.requestCode = requestCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getRequestCode()
/*     */   {
/* 117 */     return this.requestCode;
/*     */   }
/*     */   
/*     */   public boolean canShow(CONTENT content)
/*     */   {
/* 122 */     return canShowImpl(content, BASE_AUTOMATIC_MODE);
/*     */   }
/*     */   
/*     */   protected boolean canShowImpl(CONTENT content, Object mode)
/*     */   {
/* 127 */     boolean anyModeAllowed = mode == BASE_AUTOMATIC_MODE;
/*     */     
/* 129 */     for (ModeHandler handler : cachedModeHandlers()) {
/* 130 */       if ((anyModeAllowed) || (Utility.areObjectsEqual(handler.getMode(), mode)))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 135 */         if (handler.canShow(content, false)) {
/* 136 */           return true;
/*     */         }
/*     */       }
/*     */     }
/* 140 */     return false;
/*     */   }
/*     */   
/*     */   public void show(CONTENT content)
/*     */   {
/* 145 */     showImpl(content, BASE_AUTOMATIC_MODE);
/*     */   }
/*     */   
/*     */   protected void showImpl(CONTENT content, Object mode)
/*     */   {
/* 150 */     AppCall appCall = createAppCallForMode(content, mode);
/* 151 */     if (appCall != null) {
/* 152 */       if (this.fragmentWrapper != null) {
/* 153 */         DialogPresenter.present(appCall, this.fragmentWrapper);
/*     */       } else {
/* 155 */         DialogPresenter.present(appCall, this.activity);
/*     */       }
/*     */     }
/*     */     else {
/* 159 */       String errorMessage = "No code path should ever result in a null appCall";
/* 160 */       Log.e("FacebookDialog", errorMessage);
/* 161 */       if (FacebookSdk.isDebugEnabled()) {
/* 162 */         throw new IllegalStateException(errorMessage);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   protected Activity getActivityContext() {
/* 168 */     if (this.activity != null) {
/* 169 */       return this.activity;
/*     */     }
/*     */     
/* 172 */     if (this.fragmentWrapper != null) {
/* 173 */       return this.fragmentWrapper.getActivity();
/*     */     }
/*     */     
/* 176 */     return null;
/*     */   }
/*     */   
/*     */   protected void startActivityForResult(Intent intent, int requestCode) {
/* 180 */     String error = null;
/* 181 */     if (this.activity != null) {
/* 182 */       this.activity.startActivityForResult(intent, requestCode);
/* 183 */     } else if (this.fragmentWrapper != null) {
/* 184 */       if (this.fragmentWrapper.getNativeFragment() != null) {
/* 185 */         this.fragmentWrapper.getNativeFragment().startActivityForResult(intent, requestCode);
/* 186 */       } else if (this.fragmentWrapper.getSupportFragment() != null) {
/* 187 */         this.fragmentWrapper.getSupportFragment().startActivityForResult(intent, requestCode);
/*     */       } else {
/* 189 */         error = "Failed to find Activity or Fragment to startActivityForResult ";
/*     */       }
/*     */     } else {
/* 192 */       error = "Failed to find Activity or Fragment to startActivityForResult ";
/*     */     }
/* 194 */     if (error != null) {
/* 195 */       Logger.log(LoggingBehavior.DEVELOPER_ERRORS, 6, 
/*     */       
/* 197 */         getClass().getName(), error);
/*     */     }
/*     */   }
/*     */   
/*     */   private AppCall createAppCallForMode(CONTENT content, Object mode)
/*     */   {
/* 203 */     boolean anyModeAllowed = mode == BASE_AUTOMATIC_MODE;
/*     */     
/* 205 */     AppCall appCall = null;
/* 206 */     for (ModeHandler handler : cachedModeHandlers()) {
/* 207 */       if (((anyModeAllowed) || (Utility.areObjectsEqual(handler.getMode(), mode))) && 
/*     */       
/*     */ 
/* 210 */         (handler.canShow(content, true)))
/*     */       {
/*     */         try
/*     */         {
/*     */ 
/* 215 */           appCall = handler.createAppCall(content);
/*     */         } catch (FacebookException e) {
/* 217 */           appCall = createBaseAppCall();
/* 218 */           DialogPresenter.setupAppCallForValidationError(appCall, e);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 223 */     if (appCall == null) {
/* 224 */       appCall = createBaseAppCall();
/* 225 */       DialogPresenter.setupAppCallForCannotShowError(appCall);
/*     */     }
/*     */     
/* 228 */     return appCall;
/*     */   }
/*     */   
/*     */   private List<ModeHandler> cachedModeHandlers() {
/* 232 */     if (this.modeHandlers == null) {
/* 233 */       this.modeHandlers = getOrderedModeHandlers();
/*     */     }
/*     */     
/* 236 */     return this.modeHandlers;
/*     */   }
/*     */   
/*     */   protected abstract List<ModeHandler> getOrderedModeHandlers();
/*     */   
/*     */   protected abstract AppCall createBaseAppCall();
/*     */   
/*     */   protected abstract class ModeHandler
/*     */   {
/*     */     protected ModeHandler() {}
/*     */     
/*     */     public Object getMode() {
/* 248 */       return FacebookDialogBase.BASE_AUTOMATIC_MODE;
/*     */     }
/*     */     
/*     */     public abstract boolean canShow(CONTENT paramCONTENT, boolean paramBoolean);
/*     */     
/*     */     public abstract AppCall createAppCall(CONTENT paramCONTENT);
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/FacebookDialogBase.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */