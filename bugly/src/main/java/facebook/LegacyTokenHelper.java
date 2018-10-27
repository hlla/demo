/*     */ package com.facebook;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.content.SharedPreferences;
/*     */ import android.content.SharedPreferences.Editor;
/*     */ import android.os.Bundle;
/*     */ import com.facebook.internal.Logger;
/*     */ import com.facebook.internal.Utility;
/*     */ import com.facebook.internal.Validate;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ final class LegacyTokenHelper
/*     */ {
/*     */   public static final String TOKEN_KEY = "com.facebook.TokenCachingStrategy.Token";
/*     */   public static final String EXPIRATION_DATE_KEY = "com.facebook.TokenCachingStrategy.ExpirationDate";
/*     */   public static final String LAST_REFRESH_DATE_KEY = "com.facebook.TokenCachingStrategy.LastRefreshDate";
/*     */   public static final String TOKEN_SOURCE_KEY = "com.facebook.TokenCachingStrategy.AccessTokenSource";
/*     */   public static final String PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.Permissions";
/*     */   public static final String DECLINED_PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.DeclinedPermissions";
/*     */   public static final String APPLICATION_ID_KEY = "com.facebook.TokenCachingStrategy.ApplicationId";
/*     */   private static final long INVALID_BUNDLE_MILLISECONDS = Long.MIN_VALUE;
/*     */   private static final String IS_SSO_KEY = "com.facebook.TokenCachingStrategy.IsSSO";
/*     */   public static final String DEFAULT_CACHE_KEY = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY";
/*  91 */   private static final String TAG = LegacyTokenHelper.class.getSimpleName();
/*     */   
/*     */   private static final String JSON_VALUE_TYPE = "valueType";
/*     */   
/*     */   private static final String JSON_VALUE = "value";
/*     */   private static final String JSON_VALUE_ENUM_TYPE = "enumType";
/*     */   private static final String TYPE_BOOLEAN = "bool";
/*     */   private static final String TYPE_BOOLEAN_ARRAY = "bool[]";
/*     */   private static final String TYPE_BYTE = "byte";
/*     */   private static final String TYPE_BYTE_ARRAY = "byte[]";
/*     */   private static final String TYPE_SHORT = "short";
/*     */   private static final String TYPE_SHORT_ARRAY = "short[]";
/*     */   private static final String TYPE_INTEGER = "int";
/*     */   private static final String TYPE_INTEGER_ARRAY = "int[]";
/*     */   private static final String TYPE_LONG = "long";
/*     */   private static final String TYPE_LONG_ARRAY = "long[]";
/*     */   private static final String TYPE_FLOAT = "float";
/*     */   private static final String TYPE_FLOAT_ARRAY = "float[]";
/*     */   private static final String TYPE_DOUBLE = "double";
/*     */   private static final String TYPE_DOUBLE_ARRAY = "double[]";
/*     */   private static final String TYPE_CHAR = "char";
/*     */   private static final String TYPE_CHAR_ARRAY = "char[]";
/*     */   private static final String TYPE_STRING = "string";
/*     */   private static final String TYPE_STRING_LIST = "stringList";
/*     */   private static final String TYPE_ENUM = "enum";
/*     */   private String cacheKey;
/*     */   private SharedPreferences cache;
/*     */   
/*     */   public LegacyTokenHelper(Context context)
/*     */   {
/* 121 */     this(context, null);
/*     */   }
/*     */   
/*     */   public LegacyTokenHelper(Context context, String cacheKey) {
/* 125 */     Validate.notNull(context, "context");
/*     */     
/* 127 */     this.cacheKey = (Utility.isNullOrEmpty(cacheKey) ? "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY" : cacheKey);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 132 */     Context applicationContext = context.getApplicationContext();
/* 133 */     context = applicationContext != null ? applicationContext : context;
/*     */     
/* 135 */     this.cache = context.getSharedPreferences(this.cacheKey, 0);
/*     */   }
/*     */   
/*     */ 
/*     */   public Bundle load()
/*     */   {
/* 141 */     Bundle settings = new Bundle();
/*     */     
/* 143 */     Map<String, ?> allCachedEntries = this.cache.getAll();
/*     */     
/* 145 */     for (String key : allCachedEntries.keySet()) {
/*     */       try {
/* 147 */         deserializeKey(key, settings);
/*     */       }
/*     */       catch (JSONException e) {
/* 150 */         Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error reading cached value for key: '" + key + "' -- " + e);
/*     */         
/* 152 */         return null;
/*     */       }
/*     */     }
/*     */     
/* 156 */     return settings;
/*     */   }
/*     */   
/*     */   public void save(Bundle bundle) {
/* 160 */     Validate.notNull(bundle, "bundle");
/*     */     
/* 162 */     Editor editor = this.cache.edit();
/*     */     
/* 164 */     for (String key : bundle.keySet()) {
/*     */       try {
/* 166 */         serializeKey(key, bundle, editor);
/*     */       }
/*     */       catch (JSONException e) {
/* 169 */         Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error processing value for key: '" + key + "' -- " + e);
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 176 */         return;
/*     */       }
/*     */     }
/* 179 */     editor.apply();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void clear()
/*     */   {
/* 186 */     this.cache.edit().clear().apply();
/*     */   }
/*     */   
/*     */   public static boolean hasTokenInformation(Bundle bundle) {
/* 190 */     if (bundle == null) {
/* 191 */       return false;
/*     */     }
/*     */     
/* 194 */     String token = bundle.getString("com.facebook.TokenCachingStrategy.Token");
/* 195 */     if ((token == null) || (token.length() == 0)) {
/* 196 */       return false;
/*     */     }
/*     */     
/* 199 */     long expiresMilliseconds = bundle.getLong("com.facebook.TokenCachingStrategy.ExpirationDate", 0L);
/* 200 */     if (expiresMilliseconds == 0L) {
/* 201 */       return false;
/*     */     }
/*     */     
/* 204 */     return true;
/*     */   }
/*     */   
/*     */   public static String getToken(Bundle bundle) {
/* 208 */     Validate.notNull(bundle, "bundle");
/* 209 */     return bundle.getString("com.facebook.TokenCachingStrategy.Token");
/*     */   }
/*     */   
/*     */   public static void putToken(Bundle bundle, String value) {
/* 213 */     Validate.notNull(bundle, "bundle");
/* 214 */     Validate.notNull(value, "value");
/* 215 */     bundle.putString("com.facebook.TokenCachingStrategy.Token", value);
/*     */   }
/*     */   
/*     */   public static Date getExpirationDate(Bundle bundle) {
/* 219 */     Validate.notNull(bundle, "bundle");
/* 220 */     return getDate(bundle, "com.facebook.TokenCachingStrategy.ExpirationDate");
/*     */   }
/*     */   
/*     */   public static void putExpirationDate(Bundle bundle, Date value) {
/* 224 */     Validate.notNull(bundle, "bundle");
/* 225 */     Validate.notNull(value, "value");
/* 226 */     putDate(bundle, "com.facebook.TokenCachingStrategy.ExpirationDate", value);
/*     */   }
/*     */   
/*     */   public static long getExpirationMilliseconds(Bundle bundle) {
/* 230 */     Validate.notNull(bundle, "bundle");
/* 231 */     return bundle.getLong("com.facebook.TokenCachingStrategy.ExpirationDate");
/*     */   }
/*     */   
/*     */   public static void putExpirationMilliseconds(Bundle bundle, long value) {
/* 235 */     Validate.notNull(bundle, "bundle");
/* 236 */     bundle.putLong("com.facebook.TokenCachingStrategy.ExpirationDate", value);
/*     */   }
/*     */   
/*     */   public static Set<String> getPermissions(Bundle bundle) {
/* 240 */     Validate.notNull(bundle, "bundle");
/* 241 */     ArrayList<String> arrayList = bundle.getStringArrayList("com.facebook.TokenCachingStrategy.Permissions");
/* 242 */     if (arrayList == null) {
/* 243 */       return null;
/*     */     }
/* 245 */     return new HashSet(arrayList);
/*     */   }
/*     */   
/*     */   public static void putPermissions(Bundle bundle, Collection<String> value) {
/* 249 */     Validate.notNull(bundle, "bundle");
/* 250 */     Validate.notNull(value, "value");
/*     */     
/* 252 */     bundle.putStringArrayList("com.facebook.TokenCachingStrategy.Permissions", new ArrayList(value));
/*     */   }
/*     */   
/*     */   public static void putDeclinedPermissions(Bundle bundle, Collection<String> value) {
/* 256 */     Validate.notNull(bundle, "bundle");
/* 257 */     Validate.notNull(value, "value");
/*     */     
/* 259 */     bundle.putStringArrayList("com.facebook.TokenCachingStrategy.DeclinedPermissions", new ArrayList(value));
/*     */   }
/*     */   
/*     */   public static AccessTokenSource getSource(Bundle bundle) {
/* 263 */     Validate.notNull(bundle, "bundle");
/* 264 */     if (bundle.containsKey("com.facebook.TokenCachingStrategy.AccessTokenSource")) {
/* 265 */       return (AccessTokenSource)bundle.getSerializable("com.facebook.TokenCachingStrategy.AccessTokenSource");
/*     */     }
/* 267 */     boolean isSSO = bundle.getBoolean("com.facebook.TokenCachingStrategy.IsSSO");
/* 268 */     return isSSO ? AccessTokenSource.FACEBOOK_APPLICATION_WEB : AccessTokenSource.WEB_VIEW;
/*     */   }
/*     */   
/*     */   public static void putSource(Bundle bundle, AccessTokenSource value)
/*     */   {
/* 273 */     Validate.notNull(bundle, "bundle");
/* 274 */     bundle.putSerializable("com.facebook.TokenCachingStrategy.AccessTokenSource", value);
/*     */   }
/*     */   
/*     */   public static Date getLastRefreshDate(Bundle bundle) {
/* 278 */     Validate.notNull(bundle, "bundle");
/* 279 */     return getDate(bundle, "com.facebook.TokenCachingStrategy.LastRefreshDate");
/*     */   }
/*     */   
/*     */   public static void putLastRefreshDate(Bundle bundle, Date value) {
/* 283 */     Validate.notNull(bundle, "bundle");
/* 284 */     Validate.notNull(value, "value");
/* 285 */     putDate(bundle, "com.facebook.TokenCachingStrategy.LastRefreshDate", value);
/*     */   }
/*     */   
/*     */   public static long getLastRefreshMilliseconds(Bundle bundle) {
/* 289 */     Validate.notNull(bundle, "bundle");
/* 290 */     return bundle.getLong("com.facebook.TokenCachingStrategy.LastRefreshDate");
/*     */   }
/*     */   
/*     */   public static void putLastRefreshMilliseconds(Bundle bundle, long value) {
/* 294 */     Validate.notNull(bundle, "bundle");
/* 295 */     bundle.putLong("com.facebook.TokenCachingStrategy.LastRefreshDate", value);
/*     */   }
/*     */   
/*     */   public static String getApplicationId(Bundle bundle) {
/* 299 */     Validate.notNull(bundle, "bundle");
/* 300 */     return bundle.getString("com.facebook.TokenCachingStrategy.ApplicationId");
/*     */   }
/*     */   
/*     */   public static void putApplicationId(Bundle bundle, String value) {
/* 304 */     Validate.notNull(bundle, "bundle");
/* 305 */     bundle.putString("com.facebook.TokenCachingStrategy.ApplicationId", value);
/*     */   }
/*     */   
/*     */   static Date getDate(Bundle bundle, String key) {
/* 309 */     if (bundle == null) {
/* 310 */       return null;
/*     */     }
/*     */     
/* 313 */     long n = bundle.getLong(key, Long.MIN_VALUE);
/* 314 */     if (n == Long.MIN_VALUE) {
/* 315 */       return null;
/*     */     }
/*     */     
/* 318 */     return new Date(n);
/*     */   }
/*     */   
/*     */   static void putDate(Bundle bundle, String key, Date date) {
/* 322 */     bundle.putLong(key, date.getTime());
/*     */   }
/*     */   
/*     */   private void serializeKey(String key, Bundle bundle, Editor editor) throws JSONException
/*     */   {
/* 327 */     Object value = bundle.get(key);
/* 328 */     if (value == null)
/*     */     {
/* 330 */       return;
/*     */     }
/*     */     
/* 333 */     String supportedType = null;
/* 334 */     JSONArray jsonArray = null;
/* 335 */     JSONObject json = new JSONObject();
/*     */     
/* 337 */     if ((value instanceof Byte)) {
/* 338 */       supportedType = "byte";
/* 339 */       json.put("value", ((Byte)value).intValue());
/* 340 */     } else if ((value instanceof Short)) {
/* 341 */       supportedType = "short";
/* 342 */       json.put("value", ((Short)value).intValue());
/* 343 */     } else if ((value instanceof Integer)) {
/* 344 */       supportedType = "int";
/* 345 */       json.put("value", ((Integer)value).intValue());
/* 346 */     } else if ((value instanceof Long)) {
/* 347 */       supportedType = "long";
/* 348 */       json.put("value", ((Long)value).longValue());
/* 349 */     } else if ((value instanceof Float)) {
/* 350 */       supportedType = "float";
/* 351 */       json.put("value", ((Float)value).doubleValue());
/* 352 */     } else if ((value instanceof Double)) {
/* 353 */       supportedType = "double";
/* 354 */       json.put("value", ((Double)value).doubleValue());
/* 355 */     } else if ((value instanceof Boolean)) {
/* 356 */       supportedType = "bool";
/* 357 */       json.put("value", ((Boolean)value).booleanValue());
/* 358 */     } else if ((value instanceof Character)) {
/* 359 */       supportedType = "char";
/* 360 */       json.put("value", value.toString());
/* 361 */     } else if ((value instanceof String)) {
/* 362 */       supportedType = "string";
/* 363 */       json.put("value", (String)value);
/* 364 */     } else if ((value instanceof Enum)) {
/* 365 */       supportedType = "enum";
/* 366 */       json.put("value", value.toString());
/* 367 */       json.put("enumType", value.getClass().getName());
/*     */     }
/*     */     else
/*     */     {
/* 371 */       jsonArray = new JSONArray();
/* 372 */       if ((value instanceof byte[])) {
/* 373 */         supportedType = "byte[]";
/* 374 */         for (byte v : (byte[])value) {
/* 375 */           jsonArray.put(v);
/*     */         }
/* 377 */       } else if ((value instanceof short[])) {
/* 378 */         supportedType = "short[]";
/* 379 */         for (short v : (short[])value) {
/* 380 */           jsonArray.put(v);
/*     */         }
/* 382 */       } else if ((value instanceof int[])) {
/* 383 */         supportedType = "int[]";
/* 384 */         for (int v : (int[])value) {
/* 385 */           jsonArray.put(v);
/*     */         }
/* 387 */       } else if ((value instanceof long[])) {
/* 388 */         supportedType = "long[]";
/* 389 */         for (long v : (long[])value) {
/* 390 */           jsonArray.put(v);
/*     */         }
/* 392 */       } else if ((value instanceof float[])) {
/* 393 */         supportedType = "float[]";
/* 394 */         for (float v : (float[])value) {
/* 395 */           jsonArray.put(v);
/*     */         }
/* 397 */       } else if ((value instanceof double[])) {
/* 398 */         supportedType = "double[]";
/* 399 */         for (double v : (double[])value) {
/* 400 */           jsonArray.put(v);
/*     */         }
/* 402 */       } else if ((value instanceof boolean[])) {
/* 403 */         supportedType = "bool[]";
/* 404 */         for (boolean v : (boolean[])value) {
/* 405 */           jsonArray.put(v);
/*     */         }
/* 407 */       } else if ((value instanceof char[])) {
/* 408 */         supportedType = "char[]";
/* 409 */         for (char v : (char[])value) {
/* 410 */           jsonArray.put(String.valueOf(v));
/*     */         }
/* 412 */       } else if ((value instanceof List)) {
/* 413 */         supportedType = "stringList";
/*     */         
/* 415 */         Object stringList = (List)value;
/* 416 */         for (String v : (List)stringList) {
/* 417 */           jsonArray.put(v == null ? JSONObject.NULL : v);
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 422 */         jsonArray = null;
/*     */       }
/*     */     }
/*     */     
/* 426 */     if (supportedType != null) {
/* 427 */       json.put("valueType", supportedType);
/* 428 */       if (jsonArray != null)
/*     */       {
/*     */ 
/* 431 */         json.putOpt("value", jsonArray);
/*     */       }
/*     */       
/* 434 */       String jsonString = json.toString();
/* 435 */       editor.putString(key, jsonString);
/*     */     }
/*     */   }
/*     */   
/*     */   private void deserializeKey(String key, Bundle bundle) throws JSONException
/*     */   {
/* 441 */     String jsonString = this.cache.getString(key, "{}");
/* 442 */     JSONObject json = new JSONObject(jsonString);
/*     */     
/* 444 */     String valueType = json.getString("valueType");
/*     */     
/* 446 */     if (valueType.equals("bool")) {
/* 447 */       bundle.putBoolean(key, json.getBoolean("value"));
/* 448 */     } else if (valueType.equals("bool[]")) {
/* 449 */       JSONArray jsonArray = json.getJSONArray("value");
/* 450 */       boolean[] array = new boolean[jsonArray.length()];
/* 451 */       for (int i = 0; i < array.length; i++) {
/* 452 */         array[i] = jsonArray.getBoolean(i);
/*     */       }
/* 454 */       bundle.putBooleanArray(key, array);
/* 455 */     } else if (valueType.equals("byte")) {
/* 456 */       bundle.putByte(key, (byte)json.getInt("value"));
/* 457 */     } else if (valueType.equals("byte[]")) {
/* 458 */       JSONArray jsonArray = json.getJSONArray("value");
/* 459 */       byte[] array = new byte[jsonArray.length()];
/* 460 */       for (int i = 0; i < array.length; i++) {
/* 461 */         array[i] = ((byte)jsonArray.getInt(i));
/*     */       }
/* 463 */       bundle.putByteArray(key, array);
/* 464 */     } else if (valueType.equals("short")) {
/* 465 */       bundle.putShort(key, (short)json.getInt("value"));
/* 466 */     } else if (valueType.equals("short[]")) {
/* 467 */       JSONArray jsonArray = json.getJSONArray("value");
/* 468 */       short[] array = new short[jsonArray.length()];
/* 469 */       for (int i = 0; i < array.length; i++) {
/* 470 */         array[i] = ((short)jsonArray.getInt(i));
/*     */       }
/* 472 */       bundle.putShortArray(key, array);
/* 473 */     } else if (valueType.equals("int")) {
/* 474 */       bundle.putInt(key, json.getInt("value"));
/* 475 */     } else if (valueType.equals("int[]")) {
/* 476 */       JSONArray jsonArray = json.getJSONArray("value");
/* 477 */       int[] array = new int[jsonArray.length()];
/* 478 */       for (int i = 0; i < array.length; i++) {
/* 479 */         array[i] = jsonArray.getInt(i);
/*     */       }
/* 481 */       bundle.putIntArray(key, array);
/* 482 */     } else if (valueType.equals("long")) {
/* 483 */       bundle.putLong(key, json.getLong("value"));
/* 484 */     } else if (valueType.equals("long[]")) {
/* 485 */       JSONArray jsonArray = json.getJSONArray("value");
/* 486 */       long[] array = new long[jsonArray.length()];
/* 487 */       for (int i = 0; i < array.length; i++) {
/* 488 */         array[i] = jsonArray.getLong(i);
/*     */       }
/* 490 */       bundle.putLongArray(key, array);
/* 491 */     } else if (valueType.equals("float")) {
/* 492 */       bundle.putFloat(key, (float)json.getDouble("value"));
/* 493 */     } else if (valueType.equals("float[]")) {
/* 494 */       JSONArray jsonArray = json.getJSONArray("value");
/* 495 */       float[] array = new float[jsonArray.length()];
/* 496 */       for (int i = 0; i < array.length; i++) {
/* 497 */         array[i] = ((float)jsonArray.getDouble(i));
/*     */       }
/* 499 */       bundle.putFloatArray(key, array);
/* 500 */     } else if (valueType.equals("double")) {
/* 501 */       bundle.putDouble(key, json.getDouble("value"));
/* 502 */     } else if (valueType.equals("double[]")) {
/* 503 */       JSONArray jsonArray = json.getJSONArray("value");
/* 504 */       double[] array = new double[jsonArray.length()];
/* 505 */       for (int i = 0; i < array.length; i++) {
/* 506 */         array[i] = jsonArray.getDouble(i);
/*     */       }
/* 508 */       bundle.putDoubleArray(key, array);
/* 509 */     } else if (valueType.equals("char")) {
/* 510 */       String charString = json.getString("value");
/* 511 */       if ((charString != null) && (charString.length() == 1)) {
/* 512 */         bundle.putChar(key, charString.charAt(0));
/*     */       }
/* 514 */     } else if (valueType.equals("char[]")) {
/* 515 */       JSONArray jsonArray = json.getJSONArray("value");
/* 516 */       char[] array = new char[jsonArray.length()];
/* 517 */       for (int i = 0; i < array.length; i++) {
/* 518 */         String charString = jsonArray.getString(i);
/* 519 */         if ((charString != null) && (charString.length() == 1)) {
/* 520 */           array[i] = charString.charAt(0);
/*     */         }
/*     */       }
/* 523 */       bundle.putCharArray(key, array);
/* 524 */     } else if (valueType.equals("string")) {
/* 525 */       bundle.putString(key, json.getString("value"));
/* 526 */     } else if (valueType.equals("stringList")) {
/* 527 */       JSONArray jsonArray = json.getJSONArray("value");
/* 528 */       int numStrings = jsonArray.length();
/* 529 */       ArrayList<String> stringList = new ArrayList(numStrings);
/* 530 */       for (int i = 0; i < numStrings; i++) {
/* 531 */         Object jsonStringValue = jsonArray.get(i);
/* 532 */         stringList.add(i, jsonStringValue == JSONObject.NULL ? null : (String)jsonStringValue);
/*     */       }
/*     */       
/*     */ 
/* 536 */       bundle.putStringArrayList(key, stringList);
/* 537 */     } else if (valueType.equals("enum")) {
/*     */       try {
/* 539 */         String enumType = json.getString("enumType");
/*     */         
/* 541 */         Class<? extends Enum> enumClass = Class.forName(enumType);
/*     */         
/* 543 */         Enum<?> enumValue = Enum.valueOf(enumClass, json.getString("value"));
/* 544 */         bundle.putSerializable(key, enumValue);
/*     */       }
/*     */       catch (ClassNotFoundException localClassNotFoundException) {}catch (IllegalArgumentException localIllegalArgumentException) {}
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/LegacyTokenHelper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */