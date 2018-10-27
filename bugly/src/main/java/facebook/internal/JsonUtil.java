/*     */ package com.facebook.internal;
/*     */ 
/*     */ import android.annotation.SuppressLint;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
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
/*     */ class JsonUtil
/*     */ {
/*     */   static void jsonObjectClear(JSONObject jsonObject)
/*     */   {
/*  37 */     Iterator<String> keys = jsonObject.keys();
/*  38 */     while (keys.hasNext()) {
/*  39 */       keys.next();
/*  40 */       keys.remove();
/*     */     }
/*     */   }
/*     */   
/*     */   static boolean jsonObjectContainsValue(JSONObject jsonObject, Object value)
/*     */   {
/*  46 */     Iterator<String> keys = jsonObject.keys();
/*  47 */     while (keys.hasNext()) {
/*  48 */       Object thisValue = jsonObject.opt((String)keys.next());
/*  49 */       if ((thisValue != null) && (thisValue.equals(value))) {
/*  50 */         return true;
/*     */       }
/*     */     }
/*  53 */     return false;
/*     */   }
/*     */   
/*     */   private static final class JSONObjectEntry implements Entry<String, Object> {
/*     */     private final String key;
/*     */     private final Object value;
/*     */     
/*     */     JSONObjectEntry(String key, Object value) {
/*  61 */       this.key = key;
/*  62 */       this.value = value;
/*     */     }
/*     */     
/*     */     @SuppressLint({"FieldGetter"})
/*     */     public String getKey()
/*     */     {
/*  68 */       return this.key;
/*     */     }
/*     */     
/*     */     public Object getValue()
/*     */     {
/*  73 */       return this.value;
/*     */     }
/*     */     
/*     */     public Object setValue(Object object)
/*     */     {
/*  78 */       throw new UnsupportedOperationException("JSONObjectEntry is immutable");
/*     */     }
/*     */   }
/*     */   
/*     */   static Set<Entry<String, Object>> jsonObjectEntrySet(JSONObject jsonObject)
/*     */   {
/*  84 */     HashSet<Entry<String, Object>> result = new HashSet();
/*     */     
/*     */ 
/*  87 */     Iterator<String> keys = jsonObject.keys();
/*  88 */     while (keys.hasNext()) {
/*  89 */       String key = (String)keys.next();
/*  90 */       Object value = jsonObject.opt(key);
/*  91 */       result.add(new JSONObjectEntry(key, value));
/*     */     }
/*     */     
/*  94 */     return result;
/*     */   }
/*     */   
/*     */   static Set<String> jsonObjectKeySet(JSONObject jsonObject) {
/*  98 */     HashSet<String> result = new HashSet();
/*     */     
/*     */ 
/* 101 */     Iterator<String> keys = jsonObject.keys();
/* 102 */     while (keys.hasNext()) {
/* 103 */       result.add(keys.next());
/*     */     }
/*     */     
/* 106 */     return result;
/*     */   }
/*     */   
/*     */   static void jsonObjectPutAll(JSONObject jsonObject, Map<String, Object> map) {
/* 110 */     Set<Entry<String, Object>> entrySet = map.entrySet();
/* 111 */     for (Entry<String, Object> entry : entrySet) {
/*     */       try {
/* 113 */         jsonObject.putOpt((String)entry.getKey(), entry.getValue());
/*     */       } catch (JSONException e) {
/* 115 */         throw new IllegalArgumentException(e);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static Collection<Object> jsonObjectValues(JSONObject jsonObject) {
/* 121 */     ArrayList<Object> result = new ArrayList();
/*     */     
/*     */ 
/* 124 */     Iterator<String> keys = jsonObject.keys();
/* 125 */     while (keys.hasNext()) {
/* 126 */       result.add(jsonObject.opt((String)keys.next()));
/*     */     }
/*     */     
/* 129 */     return result;
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/JsonUtil.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */