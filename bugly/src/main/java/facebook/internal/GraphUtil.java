/*     */ package com.facebook.internal;
/*     */ 
/*     */ import com.facebook.FacebookException;
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
/*     */ 
/*     */ 
/*     */ public class GraphUtil
/*     */ {
/*  38 */   private static final String[] dateFormats = { "yyyy-MM-dd'T'HH:mm:ssZ", "yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd" };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static JSONObject createOpenGraphActionForPost(String type)
/*     */   {
/*  50 */     JSONObject action = new JSONObject();
/*  51 */     if (type != null) {
/*     */       try {
/*  53 */         action.put("type", type);
/*     */       } catch (JSONException e) {
/*  55 */         throw new FacebookException("An error occurred while setting up the open graph action", e);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  60 */     return action;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static JSONObject createOpenGraphObjectForPost(String type)
/*     */   {
/*  70 */     return createOpenGraphObjectForPost(type, null, null, null, null, null, null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static JSONObject createOpenGraphObjectForPost(String type, String title, String imageUrl, String url, String description, JSONObject objectProperties, String id)
/*     */   {
/*  92 */     JSONObject openGraphObject = new JSONObject();
/*     */     try {
/*  94 */       if (type != null) {
/*  95 */         openGraphObject.put("type", type);
/*     */       }
/*  97 */       openGraphObject.put("title", title);
/*     */       
/*  99 */       if (imageUrl != null) {
/* 100 */         JSONObject imageUrlObject = new JSONObject();
/* 101 */         imageUrlObject.put("url", imageUrl);
/* 102 */         JSONArray imageUrls = new JSONArray();
/* 103 */         imageUrls.put(imageUrlObject);
/* 104 */         openGraphObject.put("image", imageUrls);
/*     */       }
/*     */       
/* 107 */       openGraphObject.put("url", url);
/* 108 */       openGraphObject.put("description", description);
/* 109 */       openGraphObject.put("fbsdk:create_object", true);
/*     */       
/* 111 */       if (objectProperties != null) {
/* 112 */         openGraphObject.put("data", objectProperties);
/*     */       }
/*     */       
/* 115 */       if (id != null) {
/* 116 */         openGraphObject.put("id", id);
/*     */       }
/*     */     } catch (JSONException e) {
/* 119 */       throw new FacebookException("An error occurred while setting up the graph object", e);
/*     */     }
/* 121 */     return openGraphObject;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isOpenGraphObjectForPost(JSONObject object)
/*     */   {
/* 131 */     return object != null ? object.optBoolean("fbsdk:create_object") : false;
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/GraphUtil.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */