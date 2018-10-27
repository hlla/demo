/*     */ package com.facebook.login;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.content.ComponentName;
/*     */ import android.content.Intent;
/*     */ import android.os.Bundle;
/*     */ import android.support.annotation.Nullable;
/*     */ import android.support.v4.app.Fragment;
/*     */ import android.support.v4.app.FragmentActivity;
/*     */ import android.util.Log;
/*     */ import android.view.LayoutInflater;
/*     */ import android.view.View;
/*     */ import android.view.ViewGroup;
/*     */ import com.facebook.R.id;
/*     */ import com.facebook.R.layout;
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
/*     */ public class LoginFragment
/*     */   extends Fragment
/*     */ {
/*     */   static final String RESULT_KEY = "com.facebook.LoginFragment:Result";
/*     */   static final String REQUEST_KEY = "com.facebook.LoginFragment:Request";
/*     */   static final String EXTRA_REQUEST = "request";
/*     */   private static final String TAG = "LoginFragment";
/*     */   private static final String NULL_CALLING_PKG_ERROR_MSG = "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.";
/*     */   private static final String SAVED_LOGIN_CLIENT = "loginClient";
/*     */   private String callingPackage;
/*     */   private LoginClient loginClient;
/*     */   private LoginClient.Request request;
/*     */   
/*     */   public void onCreate(Bundle savedInstanceState)
/*     */   {
/*  60 */     super.onCreate(savedInstanceState);
/*  61 */     if (savedInstanceState != null) {
/*  62 */       this.loginClient = ((LoginClient)savedInstanceState.getParcelable("loginClient"));
/*  63 */       this.loginClient.setFragment(this);
/*     */     } else {
/*  65 */       this.loginClient = createLoginClient();
/*     */     }
/*     */     
/*  68 */     this.loginClient.setOnCompletedListener(new LoginClient.OnCompletedListener()
/*     */     {
/*     */       public void onCompleted(LoginClient.Result outcome) {
/*  71 */         LoginFragment.this.onLoginClientCompleted(outcome);
/*     */       }
/*     */       
/*  74 */     });
/*  75 */     Activity activity = getActivity();
/*  76 */     if (activity == null) {
/*  77 */       return;
/*     */     }
/*     */     
/*  80 */     initializeCallingPackage(activity);
/*  81 */     if (activity.getIntent() != null) {
/*  82 */       Intent intent = activity.getIntent();
/*  83 */       Bundle bundle = intent.getBundleExtra("com.facebook.LoginFragment:Request");
/*  84 */       this.request = ((LoginClient.Request)bundle.getParcelable("request"));
/*     */     }
/*     */   }
/*     */   
/*     */   protected LoginClient createLoginClient() {
/*  89 */     return new LoginClient(this);
/*     */   }
/*     */   
/*     */   public void onDestroy()
/*     */   {
/*  94 */     this.loginClient.cancelCurrentHandler();
/*  95 */     super.onDestroy();
/*     */   }
/*     */   
/*     */ 
/*     */   public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
/*     */   {
/* 101 */     final View view = inflater.inflate(R.layout.com_facebook_login_fragment, container, false);
/*     */     
/* 103 */     this.loginClient.setBackgroundProcessingListener(new LoginClient.BackgroundProcessingListener()
/*     */     {
/*     */ 
/*     */       public void onBackgroundProcessingStarted()
/*     */       {
/* 108 */         view.findViewById(R.id.com_facebook_login_activity_progress_bar).setVisibility(0);
/*     */       }
/*     */       
/*     */ 
/*     */       public void onBackgroundProcessingStopped()
/*     */       {
/* 114 */         view.findViewById(R.id.com_facebook_login_activity_progress_bar).setVisibility(8);
/*     */       }
/*     */       
/* 117 */     });
/* 118 */     return view;
/*     */   }
/*     */   
/*     */   private void onLoginClientCompleted(LoginClient.Result outcome) {
/* 122 */     this.request = null;
/*     */     
/* 124 */     int resultCode = outcome.code == LoginClient.Result.Code.CANCEL ? 0 : -1;
/*     */     
/*     */ 
/* 127 */     Bundle bundle = new Bundle();
/* 128 */     bundle.putParcelable("com.facebook.LoginFragment:Result", outcome);
/*     */     
/* 130 */     Intent resultIntent = new Intent();
/* 131 */     resultIntent.putExtras(bundle);
/*     */     
/*     */ 
/* 134 */     if (isAdded()) {
/* 135 */       getActivity().setResult(resultCode, resultIntent);
/* 136 */       getActivity().finish();
/*     */     }
/*     */   }
/*     */   
/*     */   public void onResume()
/*     */   {
/* 142 */     super.onResume();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 147 */     if (this.callingPackage == null) {
/* 148 */       Log.e("LoginFragment", "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.");
/* 149 */       getActivity().finish();
/* 150 */       return;
/*     */     }
/*     */     
/* 153 */     this.loginClient.startOrContinueAuth(this.request);
/*     */   }
/*     */   
/*     */   public void onPause()
/*     */   {
/* 158 */     super.onPause();
/*     */     
/* 160 */     getActivity().findViewById(R.id.com_facebook_login_activity_progress_bar).setVisibility(8);
/*     */   }
/*     */   
/*     */ 
/*     */   public void onActivityResult(int requestCode, int resultCode, Intent data)
/*     */   {
/* 166 */     super.onActivityResult(requestCode, resultCode, data);
/* 167 */     this.loginClient.onActivityResult(requestCode, resultCode, data);
/*     */   }
/*     */   
/*     */   public void onSaveInstanceState(Bundle outState)
/*     */   {
/* 172 */     super.onSaveInstanceState(outState);
/*     */     
/* 174 */     outState.putParcelable("loginClient", this.loginClient);
/*     */   }
/*     */   
/*     */   private void initializeCallingPackage(Activity activity) {
/* 178 */     ComponentName componentName = activity.getCallingActivity();
/* 179 */     if (componentName == null) {
/* 180 */       return;
/*     */     }
/* 182 */     this.callingPackage = componentName.getPackageName();
/*     */   }
/*     */   
/*     */   LoginClient getLoginClient() {
/* 186 */     return this.loginClient;
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/login/LoginFragment.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */