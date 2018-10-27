/*     */ package com.facebook.appevents;
/*     */ 
/*     */ import android.os.Bundle;
/*     */ import android.support.annotation.Nullable;
/*     */ import com.facebook.FacebookException;
/*     */ import com.facebook.LoggingBehavior;
/*     */ import com.facebook.internal.Logger;
/*     */ import com.facebook.internal.Utility;
/*     */ import java.io.Serializable;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.util.HashSet;
/*     */ import java.util.Locale;
/*     */ import java.util.UUID;
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
/*     */ class AppEvent
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  46 */   private static final HashSet<String> validatedIdentifiers = new HashSet();
/*     */   
/*     */ 
/*     */   private final JSONObject jsonObject;
/*     */   
/*     */   private final boolean isImplicit;
/*     */   
/*     */   private final String name;
/*     */   
/*     */   private final String checksum;
/*     */   
/*     */ 
/*     */   public AppEvent(String contextName, String eventName, Double valueToSum, Bundle parameters, boolean isImplicitlyLogged, @Nullable UUID currentSessionId)
/*     */     throws JSONException, FacebookException
/*     */   {
/*  61 */     this.jsonObject = getJSONObjectForAppEvent(contextName, eventName, valueToSum, parameters, isImplicitlyLogged, currentSessionId);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  68 */     this.isImplicit = isImplicitlyLogged;
/*  69 */     this.name = eventName;
/*  70 */     this.checksum = calculateChecksum();
/*     */   }
/*     */   
/*     */   public String getName() {
/*  74 */     return this.name;
/*     */   }
/*     */   
/*     */ 
/*     */   private AppEvent(String jsonString, boolean isImplicit, String checksum)
/*     */     throws JSONException
/*     */   {
/*  81 */     this.jsonObject = new JSONObject(jsonString);
/*  82 */     this.isImplicit = isImplicit;
/*  83 */     this.name = this.jsonObject.optString("_eventName");
/*  84 */     this.checksum = checksum;
/*     */   }
/*     */   
/*     */   public boolean getIsImplicit() {
/*  88 */     return this.isImplicit;
/*     */   }
/*     */   
/*     */   public JSONObject getJSONObject() {
/*  92 */     return this.jsonObject;
/*     */   }
/*     */   
/*     */   public boolean isChecksumValid() {
/*  96 */     if (this.checksum == null)
/*     */     {
/*  98 */       return true;
/*     */     }
/*     */     
/* 101 */     return calculateChecksum().equals(this.checksum);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static void validateIdentifier(String identifier)
/*     */     throws FacebookException
/*     */   {
/* 109 */     String regex = "^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$";
/*     */     
/* 111 */     int MAX_IDENTIFIER_LENGTH = 40;
/* 112 */     if ((identifier == null) || 
/* 113 */       (identifier.length() == 0) || 
/* 114 */       (identifier.length() > 40)) {
/* 115 */       if (identifier == null) {
/* 116 */         identifier = "<None Provided>";
/*     */       }
/*     */       
/* 119 */       throw new FacebookException(String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", new Object[] { identifier, 
/*     */       
/*     */ 
/*     */ 
/* 123 */         Integer.valueOf(40) }));
/*     */     }
/*     */     
/*     */     boolean alreadyValidated;
/*     */     
/* 128 */     synchronized (validatedIdentifiers) {
/* 129 */       alreadyValidated = validatedIdentifiers.contains(identifier);
/*     */     }
/*     */     boolean alreadyValidated;
/* 132 */     if (!alreadyValidated) {
/* 133 */       if (identifier.matches("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$")) {
/* 134 */         synchronized (validatedIdentifiers) {
/* 135 */           validatedIdentifiers.add(identifier);
/*     */         }
/*     */         
/*     */       } else {
/* 139 */         throw new FacebookException(String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", new Object[] { identifier }));
/*     */       }
/*     */     }
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
/*     */   private static JSONObject getJSONObjectForAppEvent(String contextName, String eventName, Double valueToSum, Bundle parameters, boolean isImplicitlyLogged, @Nullable UUID currentSessionId)
/*     */     throws FacebookException, JSONException
/*     */   {
/* 158 */     validateIdentifier(eventName);
/*     */     
/* 160 */     JSONObject eventObject = new JSONObject();
/*     */     
/* 162 */     eventObject.put("_eventName", eventName);
/* 163 */     eventObject.put("_logTime", System.currentTimeMillis() / 1000L);
/* 164 */     eventObject.put("_ui", contextName);
/* 165 */     if (currentSessionId != null) {
/* 166 */       eventObject.put("_session_id", currentSessionId);
/*     */     }
/*     */     
/* 169 */     if (valueToSum != null) {
/* 170 */       eventObject.put("_valueToSum", valueToSum.doubleValue());
/*     */     }
/*     */     
/* 173 */     if (isImplicitlyLogged) {
/* 174 */       eventObject.put("_implicitlyLogged", "1");
/*     */     }
/*     */     
/* 177 */     String externalAnalyticsUserId = AppEventsLogger.getUserID();
/* 178 */     if (externalAnalyticsUserId != null) {
/* 179 */       eventObject.put("_app_user_id", externalAnalyticsUserId);
/*     */     }
/*     */     
/* 182 */     if (parameters != null) {
/* 183 */       for (String key : parameters.keySet())
/*     */       {
/* 185 */         validateIdentifier(key);
/*     */         
/* 187 */         Object value = parameters.get(key);
/* 188 */         if ((!(value instanceof String)) && (!(value instanceof Number)))
/*     */         {
/* 190 */           throw new FacebookException(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", new Object[] { value, key }));
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 198 */         eventObject.put(key, value.toString());
/*     */       }
/*     */     }
/*     */     
/* 202 */     if (!isImplicitlyLogged) {
/* 203 */       Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Created app event '%s'", new Object[] {eventObject
/* 204 */         .toString() });
/*     */     }
/*     */     
/* 207 */     return eventObject;
/*     */   }
/*     */   
/*     */   static class SerializationProxyV1 implements Serializable
/*     */   {
/*     */     private static final long serialVersionUID = -2488473066578201069L;
/*     */     private final String jsonString;
/*     */     private final boolean isImplicit;
/*     */     
/*     */     private SerializationProxyV1(String jsonString, boolean isImplicit) {
/* 217 */       this.jsonString = jsonString;
/* 218 */       this.isImplicit = isImplicit;
/*     */     }
/*     */     
/*     */     private Object readResolve() throws JSONException {
/* 222 */       return new AppEvent(this.jsonString, this.isImplicit, null, null);
/*     */     }
/*     */   }
/*     */   
/*     */   static class SerializationProxyV2 implements Serializable {
/*     */     private static final long serialVersionUID = 20160803001L;
/*     */     private final String jsonString;
/*     */     private final boolean isImplicit;
/*     */     private final String checksum;
/*     */     
/*     */     private SerializationProxyV2(String jsonString, boolean isImplicit, String checksum) {
/* 233 */       this.jsonString = jsonString;
/* 234 */       this.isImplicit = isImplicit;
/* 235 */       this.checksum = checksum;
/*     */     }
/*     */     
/*     */     private Object readResolve() throws JSONException {
/* 239 */       return new AppEvent(this.jsonString, this.isImplicit, this.checksum, null);
/*     */     }
/*     */   }
/*     */   
/*     */   private Object writeReplace() {
/* 244 */     return new SerializationProxyV2(this.jsonObject.toString(), this.isImplicit, this.checksum, null);
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 249 */     return String.format("\"%s\", implicit: %b, json: %s", new Object[] {this.jsonObject
/*     */     
/* 251 */       .optString("_eventName"), 
/* 252 */       Boolean.valueOf(this.isImplicit), this.jsonObject
/* 253 */       .toString() });
/*     */   }
/*     */   
/*     */   private String calculateChecksum() {
/* 257 */     return md5Checksum(this.jsonObject.toString());
/*     */   }
/*     */   
/*     */ 
/*     */   private static String md5Checksum(String toHash)
/*     */   {
/*     */     try
/*     */     {
/* 265 */       MessageDigest digest = MessageDigest.getInstance("MD5");
/* 266 */       byte[] bytes = toHash.getBytes("UTF-8");
/* 267 */       digest.update(bytes, 0, bytes.length);
/* 268 */       bytes = digest.digest();
/* 269 */       hash = bytesToHex(bytes);
/*     */     }
/*     */     catch (NoSuchAlgorithmException e) {
/*     */       String hash;
/* 273 */       Utility.logd("Failed to generate checksum: ", e);
/* 274 */       return "0";
/*     */     }
/*     */     catch (UnsupportedEncodingException e)
/*     */     {
/* 278 */       Utility.logd("Failed to generate checksum: ", e);
/* 279 */       return "1"; }
/*     */     String hash;
/* 281 */     return hash;
/*     */   }
/*     */   
/*     */   private static String bytesToHex(byte[] bytes) {
/* 285 */     StringBuffer sb = new StringBuffer();
/* 286 */     for (byte b : bytes) {
/* 287 */       sb.append(String.format("%02x", new Object[] { Byte.valueOf(b) }));
/*     */     }
/* 289 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/appevents/AppEvent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */