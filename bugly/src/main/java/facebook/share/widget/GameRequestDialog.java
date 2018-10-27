/*     */ package com.facebook.share.widget;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.content.Intent;
/*     */ import android.os.Bundle;
/*     */ import com.facebook.FacebookCallback;
/*     */ import com.facebook.internal.AppCall;
/*     */ import com.facebook.internal.CallbackManagerImpl;
/*     */ import com.facebook.internal.CallbackManagerImpl.Callback;
/*     */ import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
/*     */ import com.facebook.internal.DialogPresenter;
/*     */ import com.facebook.internal.FacebookDialogBase;
/*     */ import com.facebook.internal.FacebookDialogBase.ModeHandler;
/*     */ import com.facebook.internal.FragmentWrapper;
/*     */ import com.facebook.share.internal.GameRequestValidation;
/*     */ import com.facebook.share.internal.ResultProcessor;
/*     */ import com.facebook.share.internal.ShareInternalUtility;
/*     */ import com.facebook.share.internal.WebDialogParameters;
/*     */ import com.facebook.share.model.GameRequestContent;
/*     */ import java.util.ArrayList;
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
/*     */ public class GameRequestDialog
/*     */   extends FacebookDialogBase<GameRequestContent, Result>
/*     */ {
/*     */   private static final String GAME_REQUEST_DIALOG = "apprequests";
/*     */   
/*     */   public static final class Result
/*     */   {
/*     */     String requestId;
/*     */     List<String> to;
/*     */     
/*     */     private Result(Bundle results)
/*     */     {
/*  59 */       this.requestId = results.getString("request");
/*  60 */       this.to = new ArrayList();
/*  61 */       while (results.containsKey(String.format("to[%d]", new Object[] {
/*  62 */         Integer.valueOf(this.to.size()) }))) {
/*  63 */         this.to.add(results.getString(String.format("to[%d]", new Object[] {
/*  64 */           Integer.valueOf(this.to.size()) })));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public String getRequestId()
/*     */     {
/*  73 */       return this.requestId;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public List<String> getRequestRecipients()
/*     */     {
/*  81 */       return this.to;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  89 */   private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.GameRequest
/*  90 */     .toRequestCode();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean canShow()
/*     */   {
/*  98 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void show(Activity activity, GameRequestContent gameRequestContent)
/*     */   {
/* 109 */     new GameRequestDialog(activity).show(gameRequestContent);
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
/*     */   public static void show(android.support.v4.app.Fragment fragment, GameRequestContent gameRequestContent)
/*     */   {
/* 122 */     show(new FragmentWrapper(fragment), gameRequestContent);
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
/*     */   public static void show(android.app.Fragment fragment, GameRequestContent gameRequestContent)
/*     */   {
/* 135 */     show(new FragmentWrapper(fragment), gameRequestContent);
/*     */   }
/*     */   
/*     */ 
/*     */   private static void show(FragmentWrapper fragmentWrapper, GameRequestContent gameRequestContent)
/*     */   {
/* 141 */     new GameRequestDialog(fragmentWrapper).show(gameRequestContent);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public GameRequestDialog(Activity activity)
/*     */   {
/* 149 */     super(activity, DEFAULT_REQUEST_CODE);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public GameRequestDialog(android.support.v4.app.Fragment fragment)
/*     */   {
/* 157 */     this(new FragmentWrapper(fragment));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public GameRequestDialog(android.app.Fragment fragment)
/*     */   {
/* 165 */     this(new FragmentWrapper(fragment));
/*     */   }
/*     */   
/*     */   private GameRequestDialog(FragmentWrapper fragmentWrapper) {
/* 169 */     super(fragmentWrapper, DEFAULT_REQUEST_CODE);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void registerCallbackImpl(CallbackManagerImpl callbackManager, final FacebookCallback<Result> callback)
/*     */   {
/* 176 */     final ResultProcessor resultProcessor = callback == null ? null : new ResultProcessor(callback)
/*     */     {
/*     */ 
/*     */       public void onSuccess(AppCall appCall, Bundle results)
/*     */       {
/* 181 */         if (results != null) {
/* 182 */           callback.onSuccess(new Result(results, null));
/*     */         } else {
/* 184 */           onCancel(appCall);
/*     */         }
/*     */         
/*     */       }
/* 188 */     };
/* 189 */     callbackManager.registerCallback(
/* 190 */       getRequestCode(), new CallbackManagerImpl.Callback()
/*     */       {
/*     */         public boolean onActivityResult(int resultCode, Intent data)
/*     */         {
/* 194 */           return ShareInternalUtility.handleActivityResult(GameRequestDialog.this
/* 195 */             .getRequestCode(), resultCode, data, resultProcessor);
/*     */         }
/*     */       });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected AppCall createBaseAppCall()
/*     */   {
/* 205 */     return new AppCall(getRequestCode());
/*     */   }
/*     */   
/*     */   protected List<FacebookDialogBase<GameRequestContent, Result>.ModeHandler> getOrderedModeHandlers()
/*     */   {
/* 210 */     ArrayList<FacebookDialogBase<GameRequestContent, Result>.ModeHandler> handlers = new ArrayList();
/* 211 */     handlers.add(new WebHandler(null));
/*     */     
/* 213 */     return handlers;
/*     */   }
/*     */   
/* 216 */   private class WebHandler extends FacebookDialogBase<GameRequestContent, Result>.ModeHandler { private WebHandler() { super(); }
/*     */     
/*     */     public boolean canShow(GameRequestContent content, boolean isBestEffort) {
/* 219 */       return true;
/*     */     }
/*     */     
/*     */     public AppCall createAppCall(GameRequestContent content)
/*     */     {
/* 224 */       GameRequestValidation.validate(content);
/* 225 */       AppCall appCall = GameRequestDialog.this.createBaseAppCall();
/* 226 */       DialogPresenter.setupAppCallForWebDialog(appCall, "apprequests", 
/*     */       
/*     */ 
/* 229 */         WebDialogParameters.create(content));
/*     */       
/* 231 */       return appCall;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/widget/GameRequestDialog.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */