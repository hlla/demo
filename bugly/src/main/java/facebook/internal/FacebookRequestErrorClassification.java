/*     */ package com.facebook.internal;
/*     */ 
/*     */ import com.facebook.FacebookRequestError.Category;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.json.JSONArray;
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
/*     */ public final class FacebookRequestErrorClassification
/*     */ {
/*     */   public static final int EC_SERVICE_UNAVAILABLE = 2;
/*     */   public static final int EC_APP_TOO_MANY_CALLS = 4;
/*     */   public static final int EC_RATE = 9;
/*     */   public static final int EC_USER_TOO_MANY_CALLS = 17;
/*     */   public static final int EC_INVALID_SESSION = 102;
/*     */   public static final int EC_INVALID_TOKEN = 190;
/*     */   public static final int EC_TOO_MANY_USER_ACTION_CALLS = 341;
/*     */   public static final String KEY_RECOVERY_MESSAGE = "recovery_message";
/*     */   public static final String KEY_NAME = "name";
/*     */   public static final String KEY_OTHER = "other";
/*     */   public static final String KEY_TRANSIENT = "transient";
/*     */   public static final String KEY_LOGIN_RECOVERABLE = "login_recoverable";
/*     */   private final Map<Integer, Set<Integer>> otherErrors;
/*     */   private final Map<Integer, Set<Integer>> transientErrors;
/*     */   private final Map<Integer, Set<Integer>> loginRecoverableErrors;
/*     */   private final String otherRecoveryMessage;
/*     */   private final String transientRecoveryMessage;
/*     */   private final String loginRecoverableRecoveryMessage;
/*     */   private static FacebookRequestErrorClassification defaultInstance;
/*     */   
/*     */   FacebookRequestErrorClassification(Map<Integer, Set<Integer>> otherErrors, Map<Integer, Set<Integer>> transientErrors, Map<Integer, Set<Integer>> loginRecoverableErrors, String otherRecoveryMessage, String transientRecoveryMessage, String loginRecoverableRecoveryMessage)
/*     */   {
/*  69 */     this.otherErrors = otherErrors;
/*  70 */     this.transientErrors = transientErrors;
/*  71 */     this.loginRecoverableErrors = loginRecoverableErrors;
/*  72 */     this.otherRecoveryMessage = otherRecoveryMessage;
/*  73 */     this.transientRecoveryMessage = transientRecoveryMessage;
/*  74 */     this.loginRecoverableRecoveryMessage = loginRecoverableRecoveryMessage;
/*     */   }
/*     */   
/*     */   public Map<Integer, Set<Integer>> getOtherErrors() {
/*  78 */     return this.otherErrors;
/*     */   }
/*     */   
/*     */   public Map<Integer, Set<Integer>> getTransientErrors() {
/*  82 */     return this.transientErrors;
/*     */   }
/*     */   
/*     */   public Map<Integer, Set<Integer>> getLoginRecoverableErrors() {
/*  86 */     return this.loginRecoverableErrors;
/*     */   }
/*     */   
/*     */   public String getRecoveryMessage(FacebookRequestError.Category category) {
/*  90 */     switch (category) {
/*     */     case OTHER: 
/*  92 */       return this.otherRecoveryMessage;
/*     */     case LOGIN_RECOVERABLE: 
/*  94 */       return this.loginRecoverableRecoveryMessage;
/*     */     case TRANSIENT: 
/*  96 */       return this.transientRecoveryMessage;
/*     */     }
/*  98 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public FacebookRequestError.Category classify(int errorCode, int errorSubCode, boolean isTransient)
/*     */   {
/* 106 */     if (isTransient) {
/* 107 */       return FacebookRequestError.Category.TRANSIENT;
/*     */     }
/*     */     
/* 110 */     if ((this.otherErrors != null) && (this.otherErrors.containsKey(Integer.valueOf(errorCode)))) {
/* 111 */       Set<Integer> subCodes = (Set)this.otherErrors.get(Integer.valueOf(errorCode));
/* 112 */       if ((subCodes == null) || (subCodes.contains(Integer.valueOf(errorSubCode)))) {
/* 113 */         return FacebookRequestError.Category.OTHER;
/*     */       }
/*     */     }
/*     */     
/* 117 */     if ((this.loginRecoverableErrors != null) && (this.loginRecoverableErrors.containsKey(Integer.valueOf(errorCode)))) {
/* 118 */       Set<Integer> subCodes = (Set)this.loginRecoverableErrors.get(Integer.valueOf(errorCode));
/* 119 */       if ((subCodes == null) || (subCodes.contains(Integer.valueOf(errorSubCode)))) {
/* 120 */         return FacebookRequestError.Category.LOGIN_RECOVERABLE;
/*     */       }
/*     */     }
/*     */     
/* 124 */     if ((this.transientErrors != null) && (this.transientErrors.containsKey(Integer.valueOf(errorCode)))) {
/* 125 */       Set<Integer> subCodes = (Set)this.transientErrors.get(Integer.valueOf(errorCode));
/* 126 */       if ((subCodes == null) || (subCodes.contains(Integer.valueOf(errorSubCode)))) {
/* 127 */         return FacebookRequestError.Category.TRANSIENT;
/*     */       }
/*     */     }
/* 130 */     return FacebookRequestError.Category.OTHER;
/*     */   }
/*     */   
/*     */   public static synchronized FacebookRequestErrorClassification getDefaultErrorClassification() {
/* 134 */     if (defaultInstance == null) {
/* 135 */       defaultInstance = getDefaultErrorClassificationImpl();
/*     */     }
/* 137 */     return defaultInstance;
/*     */   }
/*     */   
/*     */   private static FacebookRequestErrorClassification getDefaultErrorClassificationImpl() {
/* 141 */     Map<Integer, Set<Integer>> transientErrors = new HashMap() {};
/* 149 */     Map<Integer, Set<Integer>> loginRecoverableErrors = new HashMap() {};
/* 154 */     return new FacebookRequestErrorClassification(null, transientErrors, loginRecoverableErrors, null, null, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static Map<Integer, Set<Integer>> parseJSONDefinition(JSONObject definition)
/*     */   {
/* 164 */     JSONArray itemsArray = definition.optJSONArray("items");
/* 165 */     if (itemsArray.length() == 0) {
/* 166 */       return null;
/*     */     }
/*     */     
/* 169 */     Map<Integer, Set<Integer>> items = new HashMap();
/* 170 */     for (int i = 0; i < itemsArray.length(); i++) {
/* 171 */       JSONObject item = itemsArray.optJSONObject(i);
/* 172 */       if (item != null)
/*     */       {
/*     */ 
/* 175 */         int code = item.optInt("code");
/* 176 */         if (code != 0)
/*     */         {
/*     */ 
/* 179 */           Set<Integer> subcodes = null;
/* 180 */           JSONArray subcodesArray = item.optJSONArray("subcodes");
/* 181 */           if ((subcodesArray != null) && (subcodesArray.length() > 0)) {
/* 182 */             subcodes = new HashSet();
/* 183 */             for (int j = 0; j < subcodesArray.length(); j++) {
/* 184 */               int subCode = subcodesArray.optInt(j);
/* 185 */               if (subCode != 0) {
/* 186 */                 subcodes.add(Integer.valueOf(subCode));
/*     */               }
/*     */             }
/*     */           }
/* 190 */           items.put(Integer.valueOf(code), subcodes);
/*     */         } } }
/* 192 */     return items;
/*     */   }
/*     */   
/*     */   public static FacebookRequestErrorClassification createFromJSON(JSONArray jsonArray) {
/* 196 */     if (jsonArray == null) {
/* 197 */       return null;
/*     */     }
/* 199 */     Map<Integer, Set<Integer>> otherErrors = null;
/* 200 */     Map<Integer, Set<Integer>> transientErrors = null;
/* 201 */     Map<Integer, Set<Integer>> loginRecoverableErrors = null;
/* 202 */     String otherRecoveryMessage = null;
/* 203 */     String transientRecoveryMessage = null;
/* 204 */     String loginRecoverableRecoveryMessage = null;
/*     */     
/* 206 */     for (int i = 0; i < jsonArray.length(); i++) {
/* 207 */       JSONObject definition = jsonArray.optJSONObject(i);
/* 208 */       if (definition != null)
/*     */       {
/*     */ 
/* 211 */         String name = definition.optString("name");
/* 212 */         if (name != null)
/*     */         {
/*     */ 
/* 215 */           if (name.equalsIgnoreCase("other")) {
/* 216 */             otherRecoveryMessage = definition.optString("recovery_message", null);
/* 217 */             otherErrors = parseJSONDefinition(definition);
/* 218 */           } else if (name.equalsIgnoreCase("transient")) {
/* 219 */             transientRecoveryMessage = definition.optString("recovery_message", null);
/* 220 */             transientErrors = parseJSONDefinition(definition);
/* 221 */           } else if (name.equalsIgnoreCase("login_recoverable")) {
/* 222 */             loginRecoverableRecoveryMessage = definition.optString("recovery_message", null);
/* 223 */             loginRecoverableErrors = parseJSONDefinition(definition);
/*     */           } }
/*     */       } }
/* 226 */     return new FacebookRequestErrorClassification(otherErrors, transientErrors, loginRecoverableErrors, otherRecoveryMessage, transientRecoveryMessage, loginRecoverableRecoveryMessage);
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/FacebookRequestErrorClassification.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */