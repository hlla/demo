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
/*     */ import com.facebook.share.internal.WebDialogParameters;
/*     */ import com.facebook.share.model.AppGroupCreationContent;
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
/*     */ public class CreateAppGroupDialog
/*     */   extends FacebookDialogBase<AppGroupCreationContent, Result>
/*     */ {
/*     */   private static final String GAME_GROUP_CREATION_DIALOG = "game_group_create";
/*  53 */   private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.AppGroupCreate
/*  54 */     .toRequestCode();
/*     */   
/*     */ 
/*     */ 
/*     */   @Deprecated
/*     */   public static final class Result
/*     */   {
/*     */     private final String id;
/*     */     
/*     */ 
/*     */     private Result(String id)
/*     */     {
/*  66 */       this.id = id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public String getId()
/*     */     {
/*  74 */       return this.id;
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
/*  85 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Deprecated
/*     */   public static void show(Activity activity, AppGroupCreationContent appGroupCreationContent)
/*     */   {
/*  97 */     new CreateAppGroupDialog(activity).show(appGroupCreationContent);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Deprecated
/*     */   public static void show(android.support.v4.app.Fragment fragment, AppGroupCreationContent appGroupCreationContent)
/*     */   {
/* 109 */     show(new FragmentWrapper(fragment), appGroupCreationContent);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Deprecated
/*     */   public static void show(android.app.Fragment fragment, AppGroupCreationContent appGroupCreationContent)
/*     */   {
/* 121 */     show(new FragmentWrapper(fragment), appGroupCreationContent);
/*     */   }
/*     */   
/*     */ 
/*     */   private static void show(FragmentWrapper fragmentWrapper, AppGroupCreationContent appGroupCreationContent)
/*     */   {
/* 127 */     new CreateAppGroupDialog(fragmentWrapper).show(appGroupCreationContent);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Deprecated
/*     */   public CreateAppGroupDialog(Activity activity)
/*     */   {
/* 137 */     super(activity, DEFAULT_REQUEST_CODE);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Deprecated
/*     */   public CreateAppGroupDialog(android.support.v4.app.Fragment fragment)
/*     */   {
/* 147 */     this(new FragmentWrapper(fragment));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Deprecated
/*     */   public CreateAppGroupDialog(android.app.Fragment fragment)
/*     */   {
/* 157 */     this(new FragmentWrapper(fragment));
/*     */   }
/*     */   
/*     */   private CreateAppGroupDialog(FragmentWrapper fragmentWrapper) {
/* 161 */     super(fragmentWrapper, DEFAULT_REQUEST_CODE);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void registerCallbackImpl(CallbackManagerImpl callbackManager, final FacebookCallback<Result> callback)
/*     */   {
/* 168 */     final ResultProcessor resultProcessor = callback == null ? null : new ResultProcessor(callback)
/*     */     {
/*     */ 
/*     */       public void onSuccess(AppCall appCall, Bundle results)
/*     */       {
/* 173 */         callback.onSuccess(new Result(results.getString("id"), null));
/*     */       }
/*     */       
/* 176 */     };
/* 177 */     CallbackManagerImpl.Callback callbackManagerCallback = new CallbackManagerImpl.Callback()
/*     */     {
/*     */       public boolean onActivityResult(int resultCode, Intent data) {
/* 180 */         return ShareInternalUtility.handleActivityResult(CreateAppGroupDialog.this
/* 181 */           .getRequestCode(), resultCode, data, resultProcessor);
/*     */ 
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 187 */     };
/* 188 */     callbackManager.registerCallback(getRequestCode(), callbackManagerCallback);
/*     */   }
/*     */   
/*     */   protected AppCall createBaseAppCall()
/*     */   {
/* 193 */     return new AppCall(getRequestCode());
/*     */   }
/*     */   
/*     */   protected List<FacebookDialogBase<AppGroupCreationContent, Result>.ModeHandler> getOrderedModeHandlers()
/*     */   {
/* 198 */     ArrayList<FacebookDialogBase<AppGroupCreationContent, Result>.ModeHandler> handlers = new ArrayList();
/* 199 */     handlers.add(new WebHandler(null));
/*     */     
/* 201 */     return handlers;
/*     */   }
/*     */   
/* 204 */   private class WebHandler extends FacebookDialogBase<AppGroupCreationContent, Result>.ModeHandler { private WebHandler() { super(); }
/*     */     
/*     */     public boolean canShow(AppGroupCreationContent content, boolean isBestEffort) {
/* 207 */       return true;
/*     */     }
/*     */     
/*     */     public AppCall createAppCall(AppGroupCreationContent content)
/*     */     {
/* 212 */       AppCall appCall = CreateAppGroupDialog.this.createBaseAppCall();
/* 213 */       DialogPresenter.setupAppCallForWebDialog(appCall, "game_group_create", 
/*     */       
/*     */ 
/* 216 */         WebDialogParameters.create(content));
/*     */       
/* 218 */       return appCall;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/widget/CreateAppGroupDialog.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */