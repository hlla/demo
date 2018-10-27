/*     */ package com.facebook.applinks;
/*     */ 
/*     */ import android.net.Uri;
/*     */ import android.os.Bundle;
/*     */ import bolts.AppLink;
/*     */ import bolts.AppLink.Target;
/*     */ import bolts.AppLinkResolver;
/*     */ import bolts.Continuation;
/*     */ import bolts.Task;
/*     */ import bolts.Task.TaskCompletionSource;
/*     */ import com.facebook.AccessToken;
/*     */ import com.facebook.FacebookRequestError;
/*     */ import com.facebook.GraphRequest;
/*     */ import com.facebook.GraphRequest.Callback;
/*     */ import com.facebook.GraphResponse;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.json.JSONArray;
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
/*     */ public class FacebookAppLinkResolver
/*     */   implements AppLinkResolver
/*     */ {
/*     */   private static final String APP_LINK_KEY = "app_links";
/*     */   private static final String APP_LINK_ANDROID_TARGET_KEY = "android";
/*     */   private static final String APP_LINK_WEB_TARGET_KEY = "web";
/*     */   private static final String APP_LINK_TARGET_PACKAGE_KEY = "package";
/*     */   private static final String APP_LINK_TARGET_CLASS_KEY = "class";
/*     */   private static final String APP_LINK_TARGET_APP_NAME_KEY = "app_name";
/*     */   private static final String APP_LINK_TARGET_URL_KEY = "url";
/*     */   private static final String APP_LINK_TARGET_SHOULD_FALLBACK_KEY = "should_fallback";
/*  62 */   private final HashMap<Uri, AppLink> cachedAppLinks = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Task<AppLink> getAppLinkFromUrlInBackground(final Uri uri)
/*     */   {
/*  73 */     ArrayList<Uri> uris = new ArrayList();
/*  74 */     uris.add(uri);
/*     */     
/*  76 */     Task<Map<Uri, AppLink>> resolveTask = getAppLinkFromUrlsInBackground(uris);
/*     */     
/*  78 */     resolveTask.onSuccess(new Continuation()
/*     */     {
/*     */       public AppLink then(Task<Map<Uri, AppLink>> resolveUrisTask) throws Exception {
/*  81 */         return (AppLink)((Map)resolveUrisTask.getResult()).get(uri);
/*     */       }
/*     */     });
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
/*     */   public Task<Map<Uri, AppLink>> getAppLinkFromUrlsInBackground(List<Uri> uris)
/*     */   {
/*  96 */     final Map<Uri, AppLink> appLinkResults = new HashMap();
/*  97 */     final HashSet<Uri> urisToRequest = new HashSet();
/*  98 */     StringBuilder graphRequestFields = new StringBuilder();
/*     */     
/* 100 */     for (Uri uri : uris) {
/*     */       AppLink appLink;
/* 102 */       synchronized (this.cachedAppLinks) {
/* 103 */         appLink = (AppLink)this.cachedAppLinks.get(uri);
/*     */       }
/*     */       AppLink appLink;
/* 106 */       if (appLink != null) {
/* 107 */         appLinkResults.put(uri, appLink);
/*     */       } else {
/* 109 */         if (!urisToRequest.isEmpty()) {
/* 110 */           graphRequestFields.append(',');
/*     */         }
/* 112 */         graphRequestFields.append(uri.toString());
/* 113 */         urisToRequest.add(uri);
/*     */       }
/*     */     }
/*     */     
/* 117 */     if (urisToRequest.isEmpty()) {
/* 118 */       return Task.forResult(appLinkResults);
/*     */     }
/*     */     
/* 121 */     final Object taskCompletionSource = Task.create();
/*     */     
/* 123 */     Bundle appLinkRequestParameters = new Bundle();
/*     */     
/* 125 */     appLinkRequestParameters.putString("ids", graphRequestFields.toString());
/* 126 */     appLinkRequestParameters.putString("fields", 
/*     */     
/* 128 */       String.format("%s.fields(%s,%s)", new Object[] { "app_links", "android", "web" }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 136 */     GraphRequest appLinkRequest = new GraphRequest(AccessToken.getCurrentAccessToken(), "", appLinkRequestParameters, null, new GraphRequest.Callback()
/*     */     {
/*     */ 
/*     */ 
/*     */       public void onCompleted(GraphResponse response)
/*     */       {
/*     */ 
/* 143 */         FacebookRequestError error = response.getError();
/* 144 */         if (error != null) {
/* 145 */           taskCompletionSource.setError(error.getException());
/* 146 */           return;
/*     */         }
/*     */         
/* 149 */         JSONObject responseJson = response.getJSONObject();
/* 150 */         if (responseJson == null) {
/* 151 */           taskCompletionSource.setResult(appLinkResults);
/* 152 */           return;
/*     */         }
/*     */         
/* 155 */         for (Uri uri : urisToRequest) {
/* 156 */           String uriString = uri.toString();
/* 157 */           if (responseJson.has(uriString))
/*     */           {
/*     */ 
/*     */             try
/*     */             {
/*     */ 
/* 163 */               JSONObject urlData = responseJson.getJSONObject(uri.toString());
/* 164 */               JSONObject appLinkData = urlData.getJSONObject("app_links");
/*     */               
/*     */ 
/* 167 */               JSONArray rawTargets = appLinkData.getJSONArray("android");
/*     */               
/* 169 */               int targetsCount = rawTargets.length();
/* 170 */               List<AppLink.Target> targets = new ArrayList(targetsCount);
/*     */               
/* 172 */               for (int i = 0; i < targetsCount; i++)
/*     */               {
/* 174 */                 AppLink.Target target = FacebookAppLinkResolver.getAndroidTargetFromJson(rawTargets.getJSONObject(i));
/* 175 */                 if (target != null) {
/* 176 */                   targets.add(target);
/*     */                 }
/*     */               }
/*     */               
/* 180 */               Uri webFallbackUrl = FacebookAppLinkResolver.getWebFallbackUriFromJson(uri, appLinkData);
/* 181 */               AppLink appLink = new AppLink(uri, targets, webFallbackUrl);
/*     */               
/* 183 */               appLinkResults.put(uri, appLink);
/* 184 */               synchronized (FacebookAppLinkResolver.this.cachedAppLinks) {
/* 185 */                 FacebookAppLinkResolver.this.cachedAppLinks.put(uri, appLink);
/*     */               }
/*     */             }
/*     */             catch (JSONException e) {}
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 193 */         taskCompletionSource.setResult(appLinkResults);
/*     */       }
/*     */       
/* 196 */     });
/* 197 */     appLinkRequest.executeAsync();
/*     */     
/* 199 */     return ((Task.TaskCompletionSource)taskCompletionSource).getTask();
/*     */   }
/*     */   
/*     */   private static AppLink.Target getAndroidTargetFromJson(JSONObject targetJson) {
/* 203 */     String packageName = tryGetStringFromJson(targetJson, "package", null);
/* 204 */     if (packageName == null)
/*     */     {
/* 206 */       return null;
/*     */     }
/* 208 */     String className = tryGetStringFromJson(targetJson, "class", null);
/* 209 */     String appName = tryGetStringFromJson(targetJson, "app_name", null);
/* 210 */     String targetUrlString = tryGetStringFromJson(targetJson, "url", null);
/* 211 */     Uri targetUri = null;
/* 212 */     if (targetUrlString != null) {
/* 213 */       targetUri = Uri.parse(targetUrlString);
/*     */     }
/*     */     
/* 216 */     return new AppLink.Target(packageName, className, targetUri, appName);
/*     */   }
/*     */   
/*     */   private static Uri getWebFallbackUriFromJson(Uri sourceUrl, JSONObject urlData)
/*     */   {
/*     */     try
/*     */     {
/* 223 */       JSONObject webTarget = urlData.getJSONObject("web");
/* 224 */       boolean shouldFallback = tryGetBooleanFromJson(webTarget, "should_fallback", true);
/*     */       
/* 226 */       if (!shouldFallback)
/*     */       {
/* 228 */         return null;
/*     */       }
/*     */       
/*     */ 
/* 232 */       String webTargetUrlString = tryGetStringFromJson(webTarget, "url", null);
/* 233 */       Uri webUri = null;
/* 234 */       if (webTargetUrlString != null) {
/* 235 */         webUri = Uri.parse(webTargetUrlString);
/*     */       }
/*     */       
/*     */ 
/* 239 */       return webUri != null ? webUri : sourceUrl;
/*     */     }
/*     */     catch (JSONException e) {}
/* 242 */     return sourceUrl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static String tryGetStringFromJson(JSONObject json, String propertyName, String defaultValue)
/*     */   {
/*     */     try
/*     */     {
/* 251 */       return json.getString(propertyName);
/*     */     } catch (JSONException e) {}
/* 253 */     return defaultValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static boolean tryGetBooleanFromJson(JSONObject json, String propertyName, boolean defaultValue)
/*     */   {
/*     */     try
/*     */     {
/* 262 */       return json.getBoolean(propertyName);
/*     */     } catch (JSONException e) {}
/* 264 */     return defaultValue;
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/applinks/FacebookAppLinkResolver.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */