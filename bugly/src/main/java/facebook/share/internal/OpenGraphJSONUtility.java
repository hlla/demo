/*     */ package com.facebook.share.internal;
/*     */ 
/*     */ import android.support.annotation.Nullable;
/*     */ import com.facebook.share.model.ShareOpenGraphAction;
/*     */ import com.facebook.share.model.ShareOpenGraphObject;
/*     */ import com.facebook.share.model.SharePhoto;
/*     */ import java.util.List;
/*     */ import java.util.Set;
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
/*     */ public final class OpenGraphJSONUtility
/*     */ {
/*     */   public static JSONObject toJSONObject(ShareOpenGraphAction action, PhotoJSONProcessor photoJSONProcessor)
/*     */     throws JSONException
/*     */   {
/*  56 */     JSONObject result = new JSONObject();
/*  57 */     Set<String> keys = action.keySet();
/*  58 */     for (String key : keys) {
/*  59 */       result.put(key, toJSONValue(action.get(key), photoJSONProcessor));
/*     */     }
/*  61 */     return result;
/*     */   }
/*     */   
/*     */   private static JSONObject toJSONObject(ShareOpenGraphObject object, PhotoJSONProcessor photoJSONProcessor)
/*     */     throws JSONException
/*     */   {
/*  67 */     JSONObject result = new JSONObject();
/*  68 */     Set<String> keys = object.keySet();
/*  69 */     for (String key : keys) {
/*  70 */       result.put(key, toJSONValue(object.get(key), photoJSONProcessor));
/*     */     }
/*  72 */     return result;
/*     */   }
/*     */   
/*     */   private static JSONArray toJSONArray(List list, PhotoJSONProcessor photoJSONProcessor)
/*     */     throws JSONException
/*     */   {
/*  78 */     JSONArray result = new JSONArray();
/*  79 */     for (Object item : list) {
/*  80 */       result.put(toJSONValue(item, photoJSONProcessor));
/*     */     }
/*  82 */     return result;
/*     */   }
/*     */   
/*     */   public static Object toJSONValue(@Nullable Object object, PhotoJSONProcessor photoJSONProcessor)
/*     */     throws JSONException
/*     */   {
/*  88 */     if (object == null) {
/*  89 */       return JSONObject.NULL;
/*     */     }
/*  91 */     if (((object instanceof String)) || ((object instanceof Boolean)) || ((object instanceof Double)) || ((object instanceof Float)) || ((object instanceof Integer)) || ((object instanceof Long)))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  97 */       return object;
/*     */     }
/*  99 */     if ((object instanceof SharePhoto)) {
/* 100 */       if (photoJSONProcessor != null) {
/* 101 */         return photoJSONProcessor.toJSONObject((SharePhoto)object);
/*     */       }
/* 103 */       return null;
/*     */     }
/* 105 */     if ((object instanceof ShareOpenGraphObject)) {
/* 106 */       return toJSONObject((ShareOpenGraphObject)object, photoJSONProcessor);
/*     */     }
/* 108 */     if ((object instanceof List)) {
/* 109 */       return toJSONArray((List)object, photoJSONProcessor);
/*     */     }
/*     */     
/* 112 */     throw new IllegalArgumentException("Invalid object found for JSON serialization: " + object.toString());
/*     */   }
/*     */   
/*     */   public static abstract interface PhotoJSONProcessor
/*     */   {
/*     */     public abstract JSONObject toJSONObject(SharePhoto paramSharePhoto);
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/internal/OpenGraphJSONUtility.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */