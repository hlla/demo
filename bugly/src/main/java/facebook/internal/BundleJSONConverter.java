/*     */ package com.facebook.internal;
/*     */ 
/*     */ import android.os.Bundle;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
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
/*     */ public class BundleJSONConverter
/*     */ {
/*  40 */   private static final Map<Class<?>, Setter> SETTERS = new HashMap();
/*     */   
/*     */   static {
/*  43 */     SETTERS.put(Boolean.class, new Setter() {
/*     */       public void setOnBundle(Bundle bundle, String key, Object value) throws JSONException {
/*  45 */         bundle.putBoolean(key, ((Boolean)value).booleanValue());
/*     */       }
/*     */       
/*     */       public void setOnJSON(JSONObject json, String key, Object value) throws JSONException {
/*  49 */         json.put(key, value);
/*     */       }
/*  51 */     });
/*  52 */     SETTERS.put(Integer.class, new Setter() {
/*     */       public void setOnBundle(Bundle bundle, String key, Object value) throws JSONException {
/*  54 */         bundle.putInt(key, ((Integer)value).intValue());
/*     */       }
/*     */       
/*     */       public void setOnJSON(JSONObject json, String key, Object value) throws JSONException {
/*  58 */         json.put(key, value);
/*     */       }
/*  60 */     });
/*  61 */     SETTERS.put(Long.class, new Setter() {
/*     */       public void setOnBundle(Bundle bundle, String key, Object value) throws JSONException {
/*  63 */         bundle.putLong(key, ((Long)value).longValue());
/*     */       }
/*     */       
/*     */       public void setOnJSON(JSONObject json, String key, Object value) throws JSONException {
/*  67 */         json.put(key, value);
/*     */       }
/*  69 */     });
/*  70 */     SETTERS.put(Double.class, new Setter() {
/*     */       public void setOnBundle(Bundle bundle, String key, Object value) throws JSONException {
/*  72 */         bundle.putDouble(key, ((Double)value).doubleValue());
/*     */       }
/*     */       
/*     */       public void setOnJSON(JSONObject json, String key, Object value) throws JSONException {
/*  76 */         json.put(key, value);
/*     */       }
/*  78 */     });
/*  79 */     SETTERS.put(String.class, new Setter() {
/*     */       public void setOnBundle(Bundle bundle, String key, Object value) throws JSONException {
/*  81 */         bundle.putString(key, (String)value);
/*     */       }
/*     */       
/*     */       public void setOnJSON(JSONObject json, String key, Object value) throws JSONException {
/*  85 */         json.put(key, value);
/*     */       }
/*  87 */     });
/*  88 */     SETTERS.put(String[].class, new Setter() {
/*     */       public void setOnBundle(Bundle bundle, String key, Object value) throws JSONException {
/*  90 */         throw new IllegalArgumentException("Unexpected type from JSON");
/*     */       }
/*     */       
/*     */       public void setOnJSON(JSONObject json, String key, Object value) throws JSONException {
/*  94 */         JSONArray jsonArray = new JSONArray();
/*  95 */         for (String stringValue : (String[])value) {
/*  96 */           jsonArray.put(stringValue);
/*     */         }
/*  98 */         json.put(key, jsonArray);
/*     */       }
/*     */       
/* 101 */     });
/* 102 */     SETTERS.put(JSONArray.class, new Setter() {
/*     */       public void setOnBundle(Bundle bundle, String key, Object value) throws JSONException {
/* 104 */         JSONArray jsonArray = (JSONArray)value;
/* 105 */         ArrayList<String> stringArrayList = new ArrayList();
/*     */         
/* 107 */         if (jsonArray.length() == 0) {
/* 108 */           bundle.putStringArrayList(key, stringArrayList);
/* 109 */           return;
/*     */         }
/*     */         
/*     */ 
/* 113 */         for (int i = 0; i < jsonArray.length(); i++) {
/* 114 */           Object current = jsonArray.get(i);
/* 115 */           if ((current instanceof String)) {
/* 116 */             stringArrayList.add((String)current);
/*     */           } else {
/* 118 */             throw new IllegalArgumentException("Unexpected type in an array: " + current.getClass());
/*     */           }
/*     */         }
/* 121 */         bundle.putStringArrayList(key, stringArrayList);
/*     */       }
/*     */       
/*     */       public void setOnJSON(JSONObject json, String key, Object value) throws JSONException
/*     */       {
/* 126 */         throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static JSONObject convertToJSON(Bundle bundle)
/*     */     throws JSONException
/*     */   {
/* 137 */     JSONObject json = new JSONObject();
/*     */     
/* 139 */     for (String key : bundle.keySet()) {
/* 140 */       Object value = bundle.get(key);
/* 141 */       if (value != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 147 */         if ((value instanceof List)) {
/* 148 */           JSONArray jsonArray = new JSONArray();
/*     */           
/* 150 */           List<String> listValue = (List)value;
/* 151 */           for (String stringValue : listValue) {
/* 152 */             jsonArray.put(stringValue);
/*     */           }
/* 154 */           json.put(key, jsonArray);
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/* 159 */         else if ((value instanceof Bundle)) {
/* 160 */           json.put(key, convertToJSON((Bundle)value));
/*     */         }
/*     */         else
/*     */         {
/* 164 */           Setter setter = (Setter)SETTERS.get(value.getClass());
/* 165 */           if (setter == null) {
/* 166 */             throw new IllegalArgumentException("Unsupported type: " + value.getClass());
/*     */           }
/* 168 */           setter.setOnJSON(json, key, value);
/*     */         } }
/*     */     }
/* 171 */     return json;
/*     */   }
/*     */   
/*     */   public static Bundle convertToBundle(JSONObject jsonObject) throws JSONException {
/* 175 */     Bundle bundle = new Bundle();
/*     */     
/* 177 */     Iterator<String> jsonIterator = jsonObject.keys();
/* 178 */     while (jsonIterator.hasNext()) {
/* 179 */       String key = (String)jsonIterator.next();
/* 180 */       Object value = jsonObject.get(key);
/* 181 */       if ((value != null) && (value != JSONObject.NULL))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 187 */         if ((value instanceof JSONObject)) {
/* 188 */           bundle.putBundle(key, convertToBundle((JSONObject)value));
/*     */         }
/*     */         else
/*     */         {
/* 192 */           Setter setter = (Setter)SETTERS.get(value.getClass());
/* 193 */           if (setter == null) {
/* 194 */             throw new IllegalArgumentException("Unsupported type: " + value.getClass());
/*     */           }
/* 196 */           setter.setOnBundle(bundle, key, value);
/*     */         } }
/*     */     }
/* 199 */     return bundle;
/*     */   }
/*     */   
/*     */   public static abstract interface Setter
/*     */   {
/*     */     public abstract void setOnBundle(Bundle paramBundle, String paramString, Object
        paramObject)
/*     */       throws JSONException;
/*     */     
/*     */     public abstract void setOnJSON(JSONObject paramJSONObject, String paramString,
                                             Object paramObject)
/*     */       throws JSONException;
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/BundleJSONConverter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */