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
/*     */ import com.facebook.share.internal.ResultProcessor;
/*     */ import com.facebook.share.internal.ShareInternalUtility;
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
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public class JoinAppGroupDialog
/*     */   extends FacebookDialogBase<String, Result>
/*     */ {
/*     */   private static final String JOIN_GAME_GROUP_DIALOG = "game_group_join";
/*  51 */   private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.AppGroupJoin
/*  52 */     .toRequestCode();
/*     */   
/*     */ 
/*     */ 
/*     */   @Deprecated
/*     */   public static final class Result
/*     */   {
/*     */     private final Bundle data;
/*     */     
/*     */ 
/*     */     private Result(Bundle bundle)
/*     */     {
/*  64 */       this.data = bundle;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public Bundle getData()
/*     */     {
/*  72 */       return this.data;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Deprecated
/*     */   public static boolean canShow()
/*     */   {
/*  83 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Deprecated
/*     */   public static void show(Activity activity, String groupId)
/*     */   {
/*  95 */     new JoinAppGroupDialog(activity).show(groupId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Deprecated
/*     */   public static void show(android.support.v4.app.Fragment fragment, String groupId)
/*     */   {
/* 107 */     show(new FragmentWrapper(fragment), groupId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Deprecated
/*     */   public static void show(android.app.Fragment fragment, String groupId)
/*     */   {
/* 119 */     show(new FragmentWrapper(fragment), groupId);
/*     */   }
/*     */   
/*     */ 
/*     */   private static void show(FragmentWrapper fragmentWrapper, String groupId)
/*     */   {
/* 125 */     new JoinAppGroupDialog(fragmentWrapper).show(groupId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Deprecated
/*     */   public JoinAppGroupDialog(Activity activity)
/*     */   {
/* 135 */     super(activity, DEFAULT_REQUEST_CODE);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Deprecated
/*     */   public JoinAppGroupDialog(android.support.v4.app.Fragment fragment)
/*     */   {
/* 145 */     this(new FragmentWrapper(fragment));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Deprecated
/*     */   public JoinAppGroupDialog(android.app.Fragment fragment)
/*     */   {
/* 155 */     this(new FragmentWrapper(fragment));
/*     */   }
/*     */   
/*     */   private JoinAppGroupDialog(FragmentWrapper fragmentWrapper) {
/* 159 */     super(fragmentWrapper, DEFAULT_REQUEST_CODE);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void registerCallbackImpl(CallbackManagerImpl callbackManager, final FacebookCallback<Result> callback)
/*     */   {
/* 166 */     final ResultProcessor resultProcessor = callback == null ? null : new ResultProcessor(callback)
/*     */     {
/*     */ 
/*     */       public void onSuccess(AppCall appCall, Bundle results)
/*     */       {
/* 171 */         callback.onSuccess(new Result(results, null));
/*     */       }
/*     */       
/* 174 */     };
/* 175 */     CallbackManagerImpl.Callback callbackManagerCallback = new CallbackManagerImpl.Callback()
/*     */     {
/*     */       public boolean onActivityResult(int resultCode, Intent data) {
/* 178 */         return ShareInternalUtility.handleActivityResult(JoinAppGroupDialog.this
/* 179 */           .getRequestCode(), resultCode, data, resultProcessor);
/*     */ 
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 185 */     };
/* 186 */     callbackManager.registerCallback(getRequestCode(), callbackManagerCallback);
/*     */   }
/*     */   
/*     */   protected AppCall createBaseAppCall()
/*     */   {
/* 191 */     return new AppCall(getRequestCode());
/*     */   }
/*     */   
/*     */   protected List<FacebookDialogBase<String, Result>.ModeHandler> getOrderedModeHandlers()
/*     */   {
/* 196 */     ArrayList<FacebookDialogBase<String, Result>.ModeHandler> handlers = new ArrayList();
/* 197 */     handlers.add(new WebHandler(null));
/*     */     
/* 199 */     return handlers;
/*     */   }
/*     */   
/* 202 */   private class WebHandler extends FacebookDialogBase<String, Result>.ModeHandler { private WebHandler() { super(); }
/*     */     
/*     */     public boolean canShow(String content, boolean isBestEffort) {
/* 205 */       return true;
/*     */     }
/*     */     
/*     */     public AppCall createAppCall(String content)
/*     */     {
/* 210 */       AppCall appCall = JoinAppGroupDialog.this.createBaseAppCall();
/* 211 */       Bundle params = new Bundle();
/* 212 */       params.putString("id", content);
/*     */       
/* 214 */       DialogPresenter.setupAppCallForWebDialog(appCall, "game_group_join", params);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 219 */       return appCall;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/widget/JoinAppGroupDialog.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */