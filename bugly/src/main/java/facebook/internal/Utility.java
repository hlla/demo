/*      */ package com.facebook.internal;
/*      */ 
/*      */ import android.content.ContentResolver;
/*      */ import android.content.Context;
/*      */ import android.content.pm.PackageInfo;
/*      */ import android.content.pm.PackageManager;
/*      */ import android.content.pm.PackageManager.NameNotFoundException;
/*      */ import android.content.res.Configuration;
/*      */ import android.content.res.Resources;
/*      */ import android.database.Cursor;
/*      */ import android.net.Uri;
/*      */ import android.net.Uri.Builder;
/*      */ import android.os.Build;
/*      */ import android.os.Build.VERSION;
/*      */ import android.os.Bundle;
/*      */ import android.os.Environment;
/*      */ import android.os.Parcel;
/*      */ import android.os.StatFs;
/*      */ import android.telephony.TelephonyManager;
/*      */ import android.text.TextUtils;
/*      */ import android.util.DisplayMetrics;
/*      */ import android.util.Log;
/*      */ import android.view.Display;
/*      */ import android.view.WindowManager;
/*      */ import android.webkit.CookieManager;
/*      */ import android.webkit.CookieSyncManager;
/*      */ import com.facebook.AccessToken;
/*      */ import com.facebook.FacebookException;
/*      */ import com.facebook.FacebookRequestError;
/*      */ import com.facebook.FacebookSdk;
/*      */ import com.facebook.GraphRequest;
/*      */ import com.facebook.GraphRequest.Callback;
/*      */ import com.facebook.GraphResponse;
/*      */ import com.facebook.HttpMethod;
/*      */ import java.io.BufferedInputStream;
/*      */ import java.io.Closeable;
/*      */ import java.io.File;
/*      */ import java.io.FilenameFilter;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.InputStreamReader;
/*      */ import java.io.OutputStream;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.lang.reflect.InvocationTargetException;
/*      */ import java.lang.reflect.Method;
/*      */ import java.math.BigInteger;
/*      */ import java.net.HttpURLConnection;
/*      */ import java.net.URLConnection;
/*      */ import java.net.URLDecoder;
/*      */ import java.security.MessageDigest;
/*      */ import java.security.NoSuchAlgorithmException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.List;
/*      */ import java.util.Locale;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import java.util.TimeZone;
/*      */ import java.util.regex.Pattern;
/*      */ import org.json.JSONArray;
/*      */ import org.json.JSONException;
/*      */ import org.json.JSONObject;
/*      */ import org.json.JSONTokener;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class Utility
/*      */ {
/*      */   static final String LOG_TAG = "FacebookSDK";
/*      */   private static final String HASH_ALGORITHM_MD5 = "MD5";
/*      */   private static final String HASH_ALGORITHM_SHA1 = "SHA-1";
/*      */   private static final String URL_SCHEME = "https";
/*      */   private static final String EXTRA_APP_EVENTS_INFO_FORMAT_VERSION = "a2";
/*      */   private static final String UTF8 = "UTF-8";
/*      */   public static final int DEFAULT_STREAM_BUFFER_SIZE = 8192;
/*      */   private static final int REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS = 1800000;
/*      */   private static final String noCarrierConstant = "NoCarrier";
/*      */   private static final int GINGERBREAD_MR1 = 10;
/*  114 */   private static int numCPUCores = 0;
/*      */   
/*  116 */   private static long timestampOfLastCheck = -1L;
/*  117 */   private static long totalExternalStorageGB = -1L;
/*  118 */   private static long availableExternalStorageGB = -1L;
/*  119 */   private static String deviceTimezoneAbbreviation = "";
/*  120 */   private static String deviceTimeZoneName = "";
/*  121 */   private static String carrierName = "NoCarrier";
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int[] intersectRanges(int[] range1, int[] range2)
/*      */   {
/*  138 */     if (range1 == null)
/*  139 */       return range2;
/*  140 */     if (range2 == null) {
/*  141 */       return range1;
/*      */     }
/*      */     
/*  144 */     int[] outputRange = new int[range1.length + range2.length];
/*  145 */     int outputIndex = 0;
/*  146 */     int index1 = 0;
/*  147 */     int index2 = 0;
/*  148 */     while ((index1 < range1.length) && (index2 < range2.length)) {
/*  149 */       int newRangeLower = Integer.MIN_VALUE;int newRangeUpper = Integer.MAX_VALUE;
/*  150 */       int lower1 = range1[index1];
/*  151 */       int upper1 = Integer.MAX_VALUE;
/*      */       
/*  153 */       int lower2 = range2[index2];
/*  154 */       int upper2 = Integer.MAX_VALUE;
/*      */       
/*  156 */       if (index1 < range1.length - 1) {
/*  157 */         upper1 = range1[(index1 + 1)];
/*      */       }
/*  159 */       if (index2 < range2.length - 1) {
/*  160 */         upper2 = range2[(index2 + 1)];
/*      */       }
/*      */       
/*  163 */       if (lower1 < lower2) {
/*  164 */         if (upper1 > lower2) {
/*  165 */           newRangeLower = lower2;
/*  166 */           if (upper1 > upper2) {
/*  167 */             newRangeUpper = upper2;
/*  168 */             index2 += 2;
/*      */           } else {
/*  170 */             newRangeUpper = upper1;
/*  171 */             index1 += 2;
/*      */           }
/*      */         } else {
/*  174 */           index1 += 2;
/*      */         }
/*      */       }
/*  177 */       else if (upper2 > lower1) {
/*  178 */         newRangeLower = lower1;
/*  179 */         if (upper2 > upper1) {
/*  180 */           newRangeUpper = upper1;
/*  181 */           index1 += 2;
/*      */         } else {
/*  183 */           newRangeUpper = upper2;
/*  184 */           index2 += 2;
/*      */         }
/*      */       } else {
/*  187 */         index2 += 2;
/*      */       }
/*      */       
/*      */ 
/*  191 */       if (newRangeLower != Integer.MIN_VALUE) {
/*  192 */         outputRange[(outputIndex++)] = newRangeLower;
/*  193 */         if (newRangeUpper == Integer.MAX_VALUE) break;
/*  194 */         outputRange[(outputIndex++)] = newRangeUpper;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  202 */     return Arrays.copyOf(outputRange, outputIndex);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static <T> boolean isSubset(Collection<T> subset, Collection<T> superset)
/*      */   {
/*  209 */     if ((superset == null) || (superset.size() == 0)) {
/*  210 */       return (subset == null) || (subset.size() == 0);
/*      */     }
/*      */     
/*  213 */     HashSet<T> hash = new HashSet(superset);
/*  214 */     for (T t : subset) {
/*  215 */       if (!hash.contains(t)) {
/*  216 */         return false;
/*      */       }
/*      */     }
/*  219 */     return true;
/*      */   }
/*      */   
/*      */   public static <T> boolean isNullOrEmpty(Collection<T> c) {
/*  223 */     return (c == null) || (c.size() == 0);
/*      */   }
/*      */   
/*      */   public static boolean isNullOrEmpty(String s) {
/*  227 */     return (s == null) || (s.length() == 0);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String coerceValueIfNullOrEmpty(String s, String valueIfNullOrEmpty)
/*      */   {
/*  240 */     if (isNullOrEmpty(s)) {
/*  241 */       return valueIfNullOrEmpty;
/*      */     }
/*      */     
/*  244 */     return s;
/*      */   }
/*      */   
/*      */   public static <T> Collection<T> unmodifiableCollection(T... ts) {
/*  248 */     return Collections.unmodifiableCollection(Arrays.asList(ts));
/*      */   }
/*      */   
/*      */   public static <T> ArrayList<T> arrayList(T... ts) {
/*  252 */     ArrayList<T> arrayList = new ArrayList(ts.length);
/*  253 */     for (T t : ts) {
/*  254 */       arrayList.add(t);
/*      */     }
/*  256 */     return arrayList;
/*      */   }
/*      */   
/*      */   public static <T> HashSet<T> hashSet(T... ts) {
/*  260 */     HashSet<T> hashSet = new HashSet(ts.length);
/*  261 */     for (T t : ts) {
/*  262 */       hashSet.add(t);
/*      */     }
/*  264 */     return hashSet;
/*      */   }
/*      */   
/*      */   public static String md5hash(String key) {
/*  268 */     return hashWithAlgorithm("MD5", key);
/*      */   }
/*      */   
/*      */   public static String sha1hash(String key) {
/*  272 */     return hashWithAlgorithm("SHA-1", key);
/*      */   }
/*      */   
/*      */   public static String sha1hash(byte[] bytes) {
/*  276 */     return hashWithAlgorithm("SHA-1", bytes);
/*      */   }
/*      */   
/*      */   private static String hashWithAlgorithm(String algorithm, String key) {
/*  280 */     return hashWithAlgorithm(algorithm, key.getBytes());
/*      */   }
/*      */   
/*      */   private static String hashWithAlgorithm(String algorithm, byte[] bytes)
/*      */   {
/*      */     try {
/*  286 */       hash = MessageDigest.getInstance(algorithm);
/*      */     } catch (NoSuchAlgorithmException e) { MessageDigest hash;
/*  288 */       return null; }
/*      */     MessageDigest hash;
/*  290 */     return hashBytes(hash, bytes);
/*      */   }
/*      */   
/*      */   private static String hashBytes(MessageDigest hash, byte[] bytes) {
/*  294 */     hash.update(bytes);
/*  295 */     byte[] digest = hash.digest();
/*  296 */     StringBuilder builder = new StringBuilder();
/*  297 */     for (int b : digest) {
/*  298 */       builder.append(Integer.toHexString(b >> 4 & 0xF));
/*  299 */       builder.append(Integer.toHexString(b >> 0 & 0xF));
/*      */     }
/*  301 */     return builder.toString();
/*      */   }
/*      */   
/*      */   public static Uri buildUri(String authority, String path, Bundle parameters) {
/*  305 */     Builder builder = new Builder();
/*  306 */     builder.scheme("https");
/*  307 */     builder.authority(authority);
/*  308 */     builder.path(path);
/*  309 */     if (parameters != null) {
/*  310 */       for (String key : parameters.keySet()) {
/*  311 */         Object parameter = parameters.get(key);
/*  312 */         if ((parameter instanceof String)) {
/*  313 */           builder.appendQueryParameter(key, (String)parameter);
/*      */         }
/*      */       }
/*      */     }
/*  317 */     return builder.build();
/*      */   }
/*      */   
/*      */   public static Bundle parseUrlQueryString(String queryString) {
/*  321 */     Bundle params = new Bundle();
/*  322 */     if (!isNullOrEmpty(queryString)) {
/*  323 */       String[] array = queryString.split("&");
/*  324 */       for (String parameter : array) {
/*  325 */         String[] keyValuePair = parameter.split("=");
/*      */         try
/*      */         {
/*  328 */           if (keyValuePair.length == 2) {
/*  329 */             params.putString(
/*  330 */               URLDecoder.decode(keyValuePair[0], "UTF-8"), 
/*  331 */               URLDecoder.decode(keyValuePair[1], "UTF-8"));
/*  332 */           } else if (keyValuePair.length == 1) {
/*  333 */             params.putString(
/*  334 */               URLDecoder.decode(keyValuePair[0], "UTF-8"), "");
/*      */           }
/*      */         }
/*      */         catch (UnsupportedEncodingException e)
/*      */         {
/*  339 */           logd("FacebookSDK", e);
/*      */         }
/*      */       }
/*      */     }
/*  343 */     return params;
/*      */   }
/*      */   
/*      */   public static void putNonEmptyString(Bundle b, String key, String value) {
/*  347 */     if (!isNullOrEmpty(value)) {
/*  348 */       b.putString(key, value);
/*      */     }
/*      */   }
/*      */   
/*      */   public static void putCommaSeparatedStringList(Bundle b, String key, List<String> list) {
/*  353 */     if (list != null) {
/*  354 */       StringBuilder builder = new StringBuilder();
/*  355 */       for (String string : list) {
/*  356 */         builder.append(string);
/*  357 */         builder.append(",");
/*      */       }
/*  359 */       String commaSeparated = "";
/*  360 */       if (builder.length() > 0) {
/*  361 */         commaSeparated = builder.substring(0, builder.length() - 1);
/*      */       }
/*  363 */       b.putString(key, commaSeparated);
/*      */     }
/*      */   }
/*      */   
/*      */   public static void putUri(Bundle b, String key, Uri uri) {
/*  368 */     if (uri != null) {
/*  369 */       putNonEmptyString(b, key, uri.toString());
/*      */     }
/*      */   }
/*      */   
/*      */   public static boolean putJSONValueInBundle(Bundle bundle, String key, Object value) {
/*  374 */     if (value == null) {
/*  375 */       bundle.remove(key);
/*  376 */     } else if ((value instanceof Boolean)) {
/*  377 */       bundle.putBoolean(key, ((Boolean)value).booleanValue());
/*  378 */     } else if ((value instanceof boolean[])) {
/*  379 */       bundle.putBooleanArray(key, (boolean[])value);
/*  380 */     } else if ((value instanceof Double)) {
/*  381 */       bundle.putDouble(key, ((Double)value).doubleValue());
/*  382 */     } else if ((value instanceof double[])) {
/*  383 */       bundle.putDoubleArray(key, (double[])value);
/*  384 */     } else if ((value instanceof Integer)) {
/*  385 */       bundle.putInt(key, ((Integer)value).intValue());
/*  386 */     } else if ((value instanceof int[])) {
/*  387 */       bundle.putIntArray(key, (int[])value);
/*  388 */     } else if ((value instanceof Long)) {
/*  389 */       bundle.putLong(key, ((Long)value).longValue());
/*  390 */     } else if ((value instanceof long[])) {
/*  391 */       bundle.putLongArray(key, (long[])value);
/*  392 */     } else if ((value instanceof String)) {
/*  393 */       bundle.putString(key, (String)value);
/*  394 */     } else if ((value instanceof JSONArray)) {
/*  395 */       bundle.putString(key, value.toString());
/*  396 */     } else if ((value instanceof JSONObject)) {
/*  397 */       bundle.putString(key, value.toString());
/*      */     } else {
/*  399 */       return false;
/*      */     }
/*  401 */     return true;
/*      */   }
/*      */   
/*      */   public static void closeQuietly(Closeable closeable) {
/*      */     try {
/*  406 */       if (closeable != null) {
/*  407 */         closeable.close();
/*      */       }
/*      */     }
/*      */     catch (IOException localIOException) {}
/*      */   }
/*      */   
/*      */   public static void disconnectQuietly(URLConnection connection)
/*      */   {
/*  415 */     if ((connection != null) && ((connection instanceof HttpURLConnection))) {
/*  416 */       ((HttpURLConnection)connection).disconnect();
/*      */     }
/*      */   }
/*      */   
/*      */   public static String getMetadataApplicationId(Context context) {
/*  421 */     Validate.notNull(context, "context");
/*      */     
/*  423 */     FacebookSdk.sdkInitialize(context);
/*      */     
/*  425 */     return FacebookSdk.getApplicationId();
/*      */   }
/*      */   
/*      */   static Map<String, Object> convertJSONObjectToHashMap(JSONObject jsonObject) {
/*  429 */     HashMap<String, Object> map = new HashMap();
/*  430 */     JSONArray keys = jsonObject.names();
/*  431 */     for (int i = 0; i < keys.length(); i++) {
/*      */       try
/*      */       {
/*  434 */         String key = keys.getString(i);
/*  435 */         Object value = jsonObject.get(key);
/*  436 */         if ((value instanceof JSONObject)) {
/*  437 */           value = convertJSONObjectToHashMap((JSONObject)value);
/*      */         }
/*  439 */         map.put(key, value);
/*      */       }
/*      */       catch (JSONException localJSONException) {}
/*      */     }
/*  443 */     return map;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Object getStringPropertyAsJSON(JSONObject jsonObject, String key, String nonJSONPropertyKey)
/*      */     throws JSONException
/*      */   {
/*  453 */     Object value = jsonObject.opt(key);
/*  454 */     if ((value != null) && ((value instanceof String))) {
/*  455 */       JSONTokener tokener = new JSONTokener((String)value);
/*  456 */       value = tokener.nextValue();
/*      */     }
/*      */     
/*  459 */     if ((value != null) && (!(value instanceof JSONObject)) && (!(value instanceof JSONArray))) {
/*  460 */       if (nonJSONPropertyKey != null)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  465 */         jsonObject = new JSONObject();
/*  466 */         jsonObject.putOpt(nonJSONPropertyKey, value);
/*  467 */         return jsonObject;
/*      */       }
/*  469 */       throw new FacebookException("Got an unexpected non-JSON object.");
/*      */     }
/*      */     
/*      */ 
/*  473 */     return value;
/*      */   }
/*      */   
/*      */   public static String readStreamToString(InputStream inputStream) throws IOException
/*      */   {
/*  478 */     BufferedInputStream bufferedInputStream = null;
/*  479 */     InputStreamReader reader = null;
/*      */     try {
/*  481 */       bufferedInputStream = new BufferedInputStream(inputStream);
/*  482 */       reader = new InputStreamReader(bufferedInputStream);
/*  483 */       StringBuilder stringBuilder = new StringBuilder();
/*      */       
/*  485 */       int bufferSize = 2048;
/*  486 */       char[] buffer = new char['ࠀ'];
/*  487 */       int n = 0;
/*  488 */       while ((n = reader.read(buffer)) != -1) {
/*  489 */         stringBuilder.append(buffer, 0, n);
/*      */       }
/*      */       
/*  492 */       return stringBuilder.toString();
/*      */     } finally {
/*  494 */       closeQuietly(bufferedInputStream);
/*  495 */       closeQuietly(reader);
/*      */     }
/*      */   }
/*      */   
/*      */   public static int copyAndCloseInputStream(InputStream inputStream, OutputStream outputStream) throws IOException
/*      */   {
/*  501 */     BufferedInputStream bufferedInputStream = null;
/*  502 */     int totalBytes = 0;
/*      */     try {
/*  504 */       bufferedInputStream = new BufferedInputStream(inputStream);
/*      */       
/*  506 */       byte[] buffer = new byte[' '];
/*      */       int bytesRead;
/*  508 */       while ((bytesRead = bufferedInputStream.read(buffer)) != -1) {
/*  509 */         outputStream.write(buffer, 0, bytesRead);
/*  510 */         totalBytes += bytesRead;
/*      */       }
/*      */     } finally {
/*  513 */       if (bufferedInputStream != null) {
/*  514 */         bufferedInputStream.close();
/*      */       }
/*  516 */       if (inputStream != null) {
/*  517 */         inputStream.close();
/*      */       }
/*      */     }
/*      */     
/*  521 */     return totalBytes;
/*      */   }
/*      */   
/*      */   public static boolean stringsEqualOrEmpty(String a, String b) {
/*  525 */     boolean aEmpty = TextUtils.isEmpty(a);
/*  526 */     boolean bEmpty = TextUtils.isEmpty(b);
/*      */     
/*  528 */     if ((aEmpty) && (bEmpty))
/*      */     {
/*  530 */       return true;
/*      */     }
/*  532 */     if ((!aEmpty) && (!bEmpty))
/*      */     {
/*  534 */       return a.equals(b);
/*      */     }
/*      */     
/*  537 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   private static void clearCookiesForDomain(Context context, String domain)
/*      */   {
/*  543 */     CookieSyncManager syncManager = CookieSyncManager.createInstance(context);
/*  544 */     syncManager.sync();
/*      */     
/*  546 */     CookieManager cookieManager = CookieManager.getInstance();
/*      */     
/*  548 */     String cookies = cookieManager.getCookie(domain);
/*  549 */     if (cookies == null) {
/*  550 */       return;
/*      */     }
/*      */     
/*  553 */     String[] splitCookies = cookies.split(";");
/*  554 */     for (String cookie : splitCookies) {
/*  555 */       String[] cookieParts = cookie.split("=");
/*  556 */       if (cookieParts.length > 0) {
/*  557 */         String newCookie = cookieParts[0].trim() + "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;";
/*      */         
/*  559 */         cookieManager.setCookie(domain, newCookie);
/*      */       }
/*      */     }
/*  562 */     cookieManager.removeExpiredCookie();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static void clearFacebookCookies(Context context)
/*      */   {
/*  569 */     clearCookiesForDomain(context, "facebook.com");
/*  570 */     clearCookiesForDomain(context, ".facebook.com");
/*  571 */     clearCookiesForDomain(context, "https://facebook.com");
/*  572 */     clearCookiesForDomain(context, "https://.facebook.com");
/*      */   }
/*      */   
/*      */   public static void logd(String tag, Exception e) {
/*  576 */     if ((FacebookSdk.isDebugEnabled()) && (tag != null) && (e != null)) {
/*  577 */       Log.d(tag, e.getClass().getSimpleName() + ": " + e.getMessage());
/*      */     }
/*      */   }
/*      */   
/*      */   public static void logd(String tag, String msg) {
/*  582 */     if ((FacebookSdk.isDebugEnabled()) && (tag != null) && (msg != null)) {
/*  583 */       Log.d(tag, msg);
/*      */     }
/*      */   }
/*      */   
/*      */   public static void logd(String tag, String msg, Throwable t) {
/*  588 */     if ((FacebookSdk.isDebugEnabled()) && (!isNullOrEmpty(tag))) {
/*  589 */       Log.d(tag, msg, t);
/*      */     }
/*      */   }
/*      */   
/*      */   public static <T> boolean areObjectsEqual(T a, T b) {
/*  594 */     if (a == null) {
/*  595 */       return b == null;
/*      */     }
/*  597 */     return a.equals(b);
/*      */   }
/*      */   
/*      */   public static boolean hasSameId(JSONObject a, JSONObject b) {
/*  601 */     if ((a == null) || (b == null) || (!a.has("id")) || (!b.has("id"))) {
/*  602 */       return false;
/*      */     }
/*  604 */     if (a.equals(b)) {
/*  605 */       return true;
/*      */     }
/*  607 */     String idA = a.optString("id");
/*  608 */     String idB = b.optString("id");
/*  609 */     if ((idA == null) || (idB == null)) {
/*  610 */       return false;
/*      */     }
/*  612 */     return idA.equals(idB);
/*      */   }
/*      */   
/*      */   public static String safeGetStringFromResponse(JSONObject response, String propertyName) {
/*  616 */     return response != null ? response.optString(propertyName, "") : "";
/*      */   }
/*      */   
/*      */   public static JSONObject tryGetJSONObjectFromResponse(JSONObject response, String propertyKey) {
/*  620 */     return response != null ? response.optJSONObject(propertyKey) : null;
/*      */   }
/*      */   
/*      */   public static JSONArray tryGetJSONArrayFromResponse(JSONObject response, String propertyKey) {
/*  624 */     return response != null ? response.optJSONArray(propertyKey) : null;
/*      */   }
/*      */   
/*      */   public static void clearCaches(Context context) {
/*  628 */     ImageDownloader.clearCache(context);
/*      */   }
/*      */   
/*      */   public static void deleteDirectory(File directoryOrFile) {
/*  632 */     if (!directoryOrFile.exists()) {
/*  633 */       return;
/*      */     }
/*      */     
/*  636 */     if (directoryOrFile.isDirectory()) {
/*  637 */       File[] children = directoryOrFile.listFiles();
/*  638 */       if (children != null) {
/*  639 */         for (File child : children) {
/*  640 */           deleteDirectory(child);
/*      */         }
/*      */       }
/*      */     }
/*  644 */     directoryOrFile.delete();
/*      */   }
/*      */   
/*      */   public static <T> List<T> asListNoNulls(T... array) {
/*  648 */     ArrayList<T> result = new ArrayList();
/*  649 */     for (T t : array) {
/*  650 */       if (t != null) {
/*  651 */         result.add(t);
/*      */       }
/*      */     }
/*  654 */     return result;
/*      */   }
/*      */   
/*      */   public static List<String> jsonArrayToStringList(JSONArray jsonArray) throws JSONException {
/*  658 */     ArrayList<String> result = new ArrayList();
/*      */     
/*  660 */     for (int i = 0; i < jsonArray.length(); i++) {
/*  661 */       result.add(jsonArray.getString(i));
/*      */     }
/*      */     
/*  664 */     return result;
/*      */   }
/*      */   
/*      */   public static Set<String> jsonArrayToSet(JSONArray jsonArray) throws JSONException {
/*  668 */     Set<String> result = new HashSet();
/*  669 */     for (int i = 0; i < jsonArray.length(); i++) {
/*  670 */       result.add(jsonArray.getString(i));
/*      */     }
/*      */     
/*  673 */     return result;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static void setAppEventAttributionParameters(JSONObject params, AttributionIdentifiers attributionIdentifiers, String anonymousAppDeviceGUID, boolean limitEventUsage)
/*      */     throws JSONException
/*      */   {
/*  681 */     if ((attributionIdentifiers != null) && (attributionIdentifiers.getAttributionId() != null)) {
/*  682 */       params.put("attribution", attributionIdentifiers.getAttributionId());
/*      */     }
/*      */     
/*  685 */     if ((attributionIdentifiers != null) && 
/*  686 */       (attributionIdentifiers.getAndroidAdvertiserId() != null)) {
/*  687 */       params.put("advertiser_id", attributionIdentifiers.getAndroidAdvertiserId());
/*  688 */       params.put("advertiser_tracking_enabled", !attributionIdentifiers.isTrackingLimited());
/*      */     }
/*      */     
/*  691 */     if ((attributionIdentifiers != null) && 
/*  692 */       (attributionIdentifiers.getAndroidInstallerPackage() != null)) {
/*  693 */       params.put("installer_package", attributionIdentifiers.getAndroidInstallerPackage());
/*      */     }
/*      */     
/*  696 */     params.put("anon_id", anonymousAppDeviceGUID);
/*  697 */     params.put("application_tracking_enabled", !limitEventUsage);
/*      */   }
/*      */   
/*      */ 
/*      */   public static void setAppEventExtendedDeviceInfoParameters(JSONObject params, Context appContext)
/*      */     throws JSONException
/*      */   {
/*  704 */     JSONArray extraInfoArray = new JSONArray();
/*  705 */     extraInfoArray.put("a2");
/*      */     
/*  707 */     refreshPeriodicExtendedDeviceInfo(appContext);
/*      */     
/*      */ 
/*  710 */     String pkgName = appContext.getPackageName();
/*  711 */     int versionCode = -1;
/*  712 */     String versionName = "";
/*      */     try
/*      */     {
/*  715 */       PackageInfo pi = appContext.getPackageManager().getPackageInfo(pkgName, 0);
/*  716 */       versionCode = pi.versionCode;
/*  717 */       versionName = pi.versionName;
/*      */     }
/*      */     catch (NameNotFoundException localNameNotFoundException) {}
/*      */     
/*      */ 
/*      */ 
/*  723 */     extraInfoArray.put(pkgName);
/*  724 */     extraInfoArray.put(versionCode);
/*  725 */     extraInfoArray.put(versionName);
/*      */     
/*      */ 
/*  728 */     extraInfoArray.put(VERSION.RELEASE);
/*  729 */     extraInfoArray.put(Build.MODEL);
/*      */     
/*      */     Locale locale;
/*      */     try
/*      */     {
/*  734 */       locale = appContext.getResources().getConfiguration().locale;
/*      */     } catch (Exception e) { Locale locale;
/*  736 */       locale = Locale.getDefault();
/*      */     }
/*  738 */     extraInfoArray.put(locale.getLanguage() + "_" + locale.getCountry());
/*      */     
/*      */ 
/*  741 */     extraInfoArray.put(deviceTimezoneAbbreviation);
/*      */     
/*      */ 
/*  744 */     extraInfoArray.put(carrierName);
/*      */     
/*      */ 
/*  747 */     int width = 0;
/*  748 */     int height = 0;
/*  749 */     double density = 0.0D;
/*      */     try {
/*  751 */       WindowManager wm = (WindowManager)appContext.getSystemService("window");
/*  752 */       if (wm != null) {
/*  753 */         Display display = wm.getDefaultDisplay();
/*  754 */         DisplayMetrics displayMetrics = new DisplayMetrics();
/*  755 */         display.getMetrics(displayMetrics);
/*  756 */         width = displayMetrics.widthPixels;
/*  757 */         height = displayMetrics.heightPixels;
/*  758 */         density = displayMetrics.density;
/*      */       }
/*      */     }
/*      */     catch (Exception localException1) {}
/*      */     
/*  763 */     extraInfoArray.put(width);
/*  764 */     extraInfoArray.put(height);
/*  765 */     extraInfoArray.put(String.format("%.2f", new Object[] { Double.valueOf(density) }));
/*      */     
/*      */ 
/*  768 */     extraInfoArray.put(refreshBestGuessNumberOfCPUCores());
/*      */     
/*      */ 
/*  771 */     extraInfoArray.put(totalExternalStorageGB);
/*  772 */     extraInfoArray.put(availableExternalStorageGB);
/*      */     
/*  774 */     extraInfoArray.put(deviceTimeZoneName);
/*      */     
/*  776 */     params.put("extinfo", extraInfoArray.toString());
/*      */   }
/*      */   
/*      */ 
/*      */   public static Method getMethodQuietly(Class<?> clazz, String methodName, Class<?>... parameterTypes)
/*      */   {
/*      */     try
/*      */     {
/*  784 */       return clazz.getMethod(methodName, parameterTypes);
/*      */     } catch (NoSuchMethodException ex) {}
/*  786 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static Method getMethodQuietly(String className, String methodName, Class<?>... parameterTypes)
/*      */   {
/*      */     try
/*      */     {
/*  795 */       Class<?> clazz = Class.forName(className);
/*  796 */       return getMethodQuietly(clazz, methodName, parameterTypes);
/*      */     } catch (ClassNotFoundException ex) {}
/*  798 */     return null;
/*      */   }
/*      */   
/*      */   public static Object invokeMethodQuietly(Object receiver, Method method, Object... args)
/*      */   {
/*      */     try {
/*  804 */       return method.invoke(receiver, args);
/*      */     } catch (IllegalAccessException ex) {
/*  806 */       return null;
/*      */     } catch (InvocationTargetException ex) {}
/*  808 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String getActivityName(Context context)
/*      */   {
/*  817 */     if (context == null)
/*  818 */       return "null";
/*  819 */     if (context == context.getApplicationContext()) {
/*  820 */       return "unknown";
/*      */     }
/*  822 */     return context.getClass().getSimpleName();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static <T> List<T> filter(List<T> target, Predicate<T> predicate)
/*      */   {
/*  831 */     if (target == null) {
/*  832 */       return null;
/*      */     }
/*  834 */     List<T> list = new ArrayList();
/*  835 */     for (T item : target) {
/*  836 */       if (predicate.apply(item)) {
/*  837 */         list.add(item);
/*      */       }
/*      */     }
/*  840 */     return list.size() == 0 ? null : list;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static <T, K> List<K> map(List<T> target, Mapper<T, K> mapper)
/*      */   {
/*  848 */     if (target == null) {
/*  849 */       return null;
/*      */     }
/*  851 */     List<K> list = new ArrayList();
/*  852 */     for (T item : target) {
/*  853 */       K mappedItem = mapper.apply(item);
/*  854 */       if (mappedItem != null) {
/*  855 */         list.add(mappedItem);
/*      */       }
/*      */     }
/*  858 */     return list.size() == 0 ? null : list;
/*      */   }
/*      */   
/*      */   public static String getUriString(Uri uri) {
/*  862 */     return uri == null ? null : uri.toString();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static boolean isWebUri(Uri uri)
/*      */   {
/*  869 */     return (uri != null) && (("http".equalsIgnoreCase(uri.getScheme())) || ("https".equalsIgnoreCase(uri.getScheme())) || ("fbstaging".equalsIgnoreCase(uri.getScheme())));
/*      */   }
/*      */   
/*      */   public static boolean isContentUri(Uri uri) {
/*  873 */     return (uri != null) && ("content".equalsIgnoreCase(uri.getScheme()));
/*      */   }
/*      */   
/*      */   public static boolean isFileUri(Uri uri) {
/*  877 */     return (uri != null) && ("file".equalsIgnoreCase(uri.getScheme()));
/*      */   }
/*      */   
/*      */   public static long getContentSize(Uri contentUri) {
/*  881 */     Cursor cursor = null;
/*      */     
/*      */ 
/*      */     try
/*      */     {
/*  886 */       cursor = FacebookSdk.getApplicationContext().getContentResolver().query(contentUri, null, null, null, null);
/*  887 */       int sizeIndex = cursor.getColumnIndex("_size");
/*      */       
/*  889 */       cursor.moveToFirst();
/*  890 */       return cursor.getLong(sizeIndex);
/*      */     } finally {
/*  892 */       if (cursor != null) {
/*  893 */         cursor.close();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public static Date getBundleLongAsDate(Bundle bundle, String key, Date dateBase) {
/*  899 */     if (bundle == null) {
/*  900 */       return null;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  905 */     Object secondsObject = bundle.get(key);
/*  906 */     long secondsFromBase; if ((secondsObject instanceof Long)) {
/*  907 */       secondsFromBase = ((Long)secondsObject).longValue();
/*  908 */     } else if ((secondsObject instanceof String)) {
/*      */       try {
/*  910 */         secondsFromBase = Long.parseLong((String)secondsObject);
/*      */       } catch (NumberFormatException e) { long secondsFromBase;
/*  912 */         return null;
/*      */       }
/*      */     } else {
/*  915 */       return null;
/*      */     }
/*      */     long secondsFromBase;
/*  918 */     if (secondsFromBase == 0L) {
/*  919 */       return new Date(Long.MAX_VALUE);
/*      */     }
/*  921 */     return new Date(dateBase.getTime() + secondsFromBase * 1000L);
/*      */   }
/*      */   
/*      */   public static void writeStringMapToParcel(Parcel parcel, Map<String, String> map)
/*      */   {
/*  926 */     if (map == null)
/*      */     {
/*  928 */       parcel.writeInt(-1);
/*      */     } else {
/*  930 */       parcel.writeInt(map.size());
/*  931 */       for (Entry<String, String> entry : map.entrySet()) {
/*  932 */         parcel.writeString((String)entry.getKey());
/*  933 */         parcel.writeString((String)entry.getValue());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public static Map<String, String> readStringMapFromParcel(Parcel parcel) {
/*  939 */     int size = parcel.readInt();
/*  940 */     if (size < 0) {
/*  941 */       return null;
/*      */     }
/*  943 */     Map<String, String> map = new HashMap();
/*  944 */     for (int i = 0; i < size; i++) {
/*  945 */       map.put(parcel.readString(), parcel.readString());
/*      */     }
/*  947 */     return map;
/*      */   }
/*      */   
/*      */   public static boolean isCurrentAccessToken(AccessToken token) {
/*  951 */     return token != null ? token.equals(AccessToken.getCurrentAccessToken()) : false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void getGraphMeRequestWithCacheAsync(final String accessToken, GraphMeRequestWithCacheCallback callback)
/*      */   {
/*  963 */     JSONObject cachedValue = ProfileInformationCache.getProfileInformation(accessToken);
/*  964 */     if (cachedValue != null) {
/*  965 */       callback.onSuccess(cachedValue);
/*  966 */       return;
/*      */     }
/*      */     
/*  969 */     GraphRequest.Callback graphCallback = new GraphRequest.Callback()
/*      */     {
/*      */       public void onCompleted(GraphResponse response) {
/*  972 */         if (response.getError() != null) {
/*  973 */           this.val$callback.onFailure(response.getError().getException());
/*      */         } else {
/*  975 */           ProfileInformationCache.putProfileInformation(accessToken, response
/*      */           
/*  977 */             .getJSONObject());
/*  978 */           this.val$callback.onSuccess(response.getJSONObject());
/*      */         }
/*      */       }
/*  981 */     };
/*  982 */     GraphRequest graphRequest = getGraphMeRequestWithCache(accessToken);
/*  983 */     graphRequest.setCallback(graphCallback);
/*  984 */     graphRequest.executeAsync();
/*      */   }
/*      */   
/*      */   public static JSONObject awaitGetGraphMeRequestWithCache(String accessToken)
/*      */   {
/*  989 */     JSONObject cachedValue = ProfileInformationCache.getProfileInformation(accessToken);
/*  990 */     if (cachedValue != null) {
/*  991 */       return cachedValue;
/*      */     }
/*      */     
/*  994 */     GraphRequest graphRequest = getGraphMeRequestWithCache(accessToken);
/*  995 */     GraphResponse response = graphRequest.executeAndWait();
/*  996 */     if (response.getError() != null) {
/*  997 */       return null;
/*      */     }
/*      */     
/* 1000 */     return response.getJSONObject();
/*      */   }
/*      */   
/*      */   private static GraphRequest getGraphMeRequestWithCache(String accessToken)
/*      */   {
/* 1005 */     Bundle parameters = new Bundle();
/* 1006 */     parameters.putString("fields", "id,name,first_name,middle_name,last_name,link");
/* 1007 */     parameters.putString("access_token", accessToken);
/* 1008 */     GraphRequest graphRequest = new GraphRequest(null, "me", parameters, HttpMethod.GET, null);
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1014 */     return graphRequest;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static int refreshBestGuessNumberOfCPUCores()
/*      */   {
/* 1023 */     if (numCPUCores > 0) {
/* 1024 */       return numCPUCores;
/*      */     }
/*      */     
/*      */     try
/*      */     {
/* 1029 */       File cpuDir = new File("/sys/devices/system/cpu/");
/* 1030 */       File[] cpuFiles = cpuDir.listFiles(new FilenameFilter()
/*      */       {
/*      */         public boolean accept(File dir, String fileName) {
/* 1033 */           return Pattern.matches("cpu[0-9]+", fileName);
/*      */         }
/*      */       });
/*      */       
/* 1037 */       if (cpuFiles != null) {
/* 1038 */         numCPUCores = cpuFiles.length;
/*      */       }
/*      */     }
/*      */     catch (Exception localException) {}
/*      */     
/*      */ 
/*      */ 
/* 1045 */     if (numCPUCores <= 0) {
/* 1046 */       numCPUCores = Math.max(Runtime.getRuntime().availableProcessors(), 1);
/*      */     }
/* 1048 */     return numCPUCores;
/*      */   }
/*      */   
/*      */   private static void refreshPeriodicExtendedDeviceInfo(Context appContext) {
/* 1052 */     if ((timestampOfLastCheck == -1L) || 
/* 1053 */       (System.currentTimeMillis() - timestampOfLastCheck >= 1800000L))
/*      */     {
/* 1055 */       timestampOfLastCheck = System.currentTimeMillis();
/* 1056 */       refreshTimezone();
/* 1057 */       refreshCarrierName(appContext);
/* 1058 */       refreshTotalExternalStorage();
/* 1059 */       refreshAvailableExternalStorage();
/*      */     }
/*      */   }
/*      */   
/*      */   private static void refreshTimezone() {
/*      */     try {
/* 1065 */       TimeZone tz = TimeZone.getDefault();
/* 1066 */       deviceTimezoneAbbreviation = tz.getDisplayName(tz
/* 1067 */         .inDaylightTime(new Date()), 0);
/*      */       
/*      */ 
/* 1070 */       deviceTimeZoneName = tz.getID();
/*      */     }
/*      */     catch (Exception localException) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void refreshCarrierName(Context appContext)
/*      */   {
/* 1080 */     if (carrierName.equals("NoCarrier")) {
/*      */       try
/*      */       {
/* 1083 */         TelephonyManager telephonyManager = (TelephonyManager)appContext.getSystemService("phone");
/* 1084 */         carrierName = telephonyManager.getNetworkOperatorName();
/*      */       }
/*      */       catch (Exception localException) {}
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static boolean externalStorageExists()
/*      */   {
/* 1094 */     return "mounted".equals(Environment.getExternalStorageState());
/*      */   }
/*      */   
/*      */   private static void refreshAvailableExternalStorage()
/*      */   {
/*      */     try
/*      */     {
/* 1101 */       if (externalStorageExists()) {
/* 1102 */         File path = Environment.getExternalStorageDirectory();
/* 1103 */         StatFs stat = new StatFs(path.getPath());
/*      */         
/* 1105 */         availableExternalStorageGB = stat.getAvailableBlocks() * stat.getBlockSize();
/*      */       }
/*      */       
/* 1108 */       availableExternalStorageGB = convertBytesToGB(availableExternalStorageGB);
/*      */     }
/*      */     catch (Exception localException) {}
/*      */   }
/*      */   
/*      */ 
/*      */   private static void refreshTotalExternalStorage()
/*      */   {
/*      */     try
/*      */     {
/* 1118 */       if (externalStorageExists()) {
/* 1119 */         File path = Environment.getExternalStorageDirectory();
/* 1120 */         StatFs stat = new StatFs(path.getPath());
/* 1121 */         totalExternalStorageGB = stat.getBlockCount() * stat.getBlockSize();
/*      */       }
/* 1123 */       totalExternalStorageGB = convertBytesToGB(totalExternalStorageGB);
/*      */     }
/*      */     catch (Exception localException) {}
/*      */   }
/*      */   
/*      */   private static long convertBytesToGB(double bytes)
/*      */   {
/* 1130 */     return Math.round(bytes / 1.073741824E9D);
/*      */   }
/*      */   
/*      */ 
/*      */   public static class PermissionsPair
/*      */   {
/*      */     List<String> grantedPermissions;
/*      */     
/*      */     List<String> declinedPermissions;
/*      */     
/*      */     public PermissionsPair(List<String> grantedPermissions, List<String> declinedPermissions)
/*      */     {
/* 1142 */       this.grantedPermissions = grantedPermissions;
/* 1143 */       this.declinedPermissions = declinedPermissions;
/*      */     }
/*      */     
/*      */     public List<String> getGrantedPermissions() {
/* 1147 */       return this.grantedPermissions;
/*      */     }
/*      */     
/*      */     public List<String> getDeclinedPermissions() {
/* 1151 */       return this.declinedPermissions;
/*      */     }
/*      */   }
/*      */   
/*      */   public static PermissionsPair handlePermissionResponse(JSONObject result)
/*      */     throws JSONException
/*      */   {
/* 1158 */     JSONObject permissions = result.getJSONObject("permissions");
/*      */     
/* 1160 */     JSONArray data = permissions.getJSONArray("data");
/* 1161 */     List<String> grantedPermissions = new ArrayList(data.length());
/* 1162 */     List<String> declinedPermissions = new ArrayList(data.length());
/*      */     
/* 1164 */     for (int i = 0; i < data.length(); i++) {
/* 1165 */       JSONObject object = data.optJSONObject(i);
/* 1166 */       String permission = object.optString("permission");
/* 1167 */       if ((permission != null) && (!permission.equals("installed")))
/*      */       {
/*      */ 
/* 1170 */         String status = object.optString("status");
/* 1171 */         if (status != null)
/*      */         {
/*      */ 
/*      */ 
/* 1175 */           if (status.equals("granted")) {
/* 1176 */             grantedPermissions.add(permission);
/* 1177 */           } else if (status.equals("declined"))
/* 1178 */             declinedPermissions.add(permission);
/*      */         }
/*      */       }
/*      */     }
/* 1182 */     return new PermissionsPair(grantedPermissions, declinedPermissions);
/*      */   }
/*      */   
/*      */   public static String generateRandomString(int length) {
/* 1186 */     Random r = new Random();
/* 1187 */     return new BigInteger(length * 5, r).toString(32);
/*      */   }
/*      */   
/*      */   public static abstract interface GraphMeRequestWithCacheCallback
/*      */   {
/*      */     public abstract void onSuccess(JSONObject paramJSONObject);
/*      */     
/*      */     public abstract void onFailure(FacebookException paramFacebookException);
/*      */   }
/*      */   
/*      */   public static abstract interface Mapper<T, K>
/*      */   {
/*      */     public abstract K apply(T paramT);
/*      */   }
/*      */   
/*      */   public static abstract interface Predicate<T>
/*      */   {
/*      */     public abstract boolean apply(T paramT);
/*      */   }
/*      */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/Utility.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */