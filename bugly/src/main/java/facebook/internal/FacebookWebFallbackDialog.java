/*     */ package com.facebook.internal;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.net.Uri;
/*     */ import android.os.Bundle;
/*     */ import android.os.Handler;
/*     */ import android.os.Looper;
/*     */ import android.webkit.WebView;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FacebookWebFallbackDialog
/*     */   extends WebDialog
/*     */ {
/*  43 */   private static final String TAG = FacebookWebFallbackDialog.class.getName();
/*     */   private static final int OS_BACK_BUTTON_RESPONSE_TIMEOUT_MILLISECONDS = 1500;
/*     */   private boolean waitingForDialogToClose;
/*     */   
/*     */   public FacebookWebFallbackDialog(Context context, String url, String expectedRedirectUrl)
/*     */   {
/*  49 */     super(context, url);
/*     */     
/*  51 */     setExpectedRedirectUrl(expectedRedirectUrl);
/*     */   }
/*     */   
/*     */   protected Bundle parseResponseUri(String url)
/*     */   {
/*  56 */     Uri responseUri = Uri.parse(url);
/*  57 */     Bundle queryParams = Utility.parseUrlQueryString(responseUri.getQuery());
/*     */     
/*     */ 
/*     */ 
/*  61 */     String bridgeArgsJSONString = queryParams.getString("bridge_args");
/*  62 */     queryParams.remove("bridge_args");
/*     */     
/*  64 */     if (!Utility.isNullOrEmpty(bridgeArgsJSONString)) {
/*     */       try
/*     */       {
/*  67 */         JSONObject bridgeArgsJSON = new JSONObject(bridgeArgsJSONString);
/*  68 */         Bundle bridgeArgs = BundleJSONConverter.convertToBundle(bridgeArgsJSON);
/*  69 */         queryParams.putBundle("com.facebook.platform.protocol.BRIDGE_ARGS", bridgeArgs);
/*     */       } catch (JSONException je) {
/*  71 */         Utility.logd(TAG, "Unable to parse bridge_args JSON", je);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  77 */     String methodResultsJSONString = queryParams.getString("method_results");
/*  78 */     queryParams.remove("method_results");
/*     */     
/*  80 */     if (!Utility.isNullOrEmpty(methodResultsJSONString))
/*     */     {
/*  82 */       methodResultsJSONString = Utility.isNullOrEmpty(methodResultsJSONString) ? "{}" : methodResultsJSONString;
/*     */       try
/*     */       {
/*  85 */         JSONObject methodArgsJSON = new JSONObject(methodResultsJSONString);
/*  86 */         Bundle methodResults = BundleJSONConverter.convertToBundle(methodArgsJSON);
/*  87 */         queryParams.putBundle("com.facebook.platform.protocol.RESULT_ARGS", methodResults);
/*     */       } catch (JSONException je) {
/*  89 */         Utility.logd(TAG, "Unable to parse bridge_args JSON", je);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  95 */     queryParams.remove("version");
/*  96 */     queryParams.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", 
/*  97 */       NativeProtocol.getLatestKnownVersion());
/*     */     
/*  99 */     return queryParams;
/*     */   }
/*     */   
/*     */   public void cancel()
/*     */   {
/* 104 */     WebView webView = getWebView();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 110 */     if ((!isPageFinished()) || 
/* 111 */       (isListenerCalled()) || (webView == null) || 
/*     */       
/* 113 */       (!webView.isShown())) {
/* 114 */       super.cancel();
/* 115 */       return;
/*     */     }
/*     */     
/*     */ 
/* 119 */     if (this.waitingForDialogToClose) {
/* 120 */       return;
/*     */     }
/*     */     
/* 123 */     this.waitingForDialogToClose = true;
/*     */     
/*     */ 
/* 126 */     String eventJS = "(function() {  var event = document.createEvent('Event');  event.initEvent('fbPlatformDialogMustClose',true,true);  document.dispatchEvent(event);})();";
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 132 */     webView.loadUrl("javascript:" + eventJS);
/*     */     
/*     */ 
/*     */ 
/* 136 */     Handler handler = new Handler(Looper.getMainLooper());
/* 137 */     handler.postDelayed(new Runnable()
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       public void run() {
/* 144 */         FacebookWebFallbackDialog.this.cancel(); } }, 1500L);
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/FacebookWebFallbackDialog.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */