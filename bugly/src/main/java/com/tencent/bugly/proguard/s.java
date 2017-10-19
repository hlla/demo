/*     */ package com.tencent.bugly.proguard;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.os.Process;
/*     */ import android.os.SystemClock;
/*     */ import com.tencent.bugly.crashreport.common.info.b;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.net.Proxy;
/*     */ import java.net.Proxy.Type;
/*     */ import java.net.URL;
/*     */ import java.net.URLEncoder;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
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
/*     */ public final class s
/*     */ {
/*     */   private static s b;
/*     */   private Context c;
/*  48 */   public Map<String, String> a = null;
/*     */   
/*     */   private s(Context paramContext) {
/*  51 */     this.c = paramContext;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static s a(Context paramContext)
/*     */   {
/*  61 */     if (b == null) {
/*  62 */       b = new s(paramContext);
/*     */     }
/*  64 */     return b;
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
/*     */   public final byte[] a(String paramString, byte[] paramArrayOfByte, v paramv, Map<String, String> paramMap)
/*     */   {
/*  77 */     if (paramString == null) {
/*  78 */       x.e("Failed for no URL.", new Object[0]);
/*  79 */       return null;
/*     */     }
/*  81 */     int i = 0;
/*  82 */     int j = 0;
/*  83 */     long l1 = paramArrayOfByte == null ? 0L : paramArrayOfByte.length;
/*     */     
/*  85 */     x.c("request: %s, send: %d (pid=%d | tid=%d)", new Object[] { paramString, Long.valueOf(l1), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
/*     */     
/*     */ 
/*     */ 
/*  89 */     int k = 0;
/*  90 */     while ((i <= 0) && (j <= 0))
/*     */     {
/*  92 */       if (k != 0) {
/*  93 */         k = 0;
/*     */       } else {
/*  95 */         i++;
/*  96 */         if (i > 1) {
/*  97 */           x.c("try time: " + i, new Object[0]);
/*     */           
/*     */ 
/*     */           long l2;
/*     */           
/* 102 */           SystemClock.sleep(l2 = new Random(System.currentTimeMillis()).nextInt(10000) + 10000L);
/*     */         }
/*     */       }
/*     */       
/*     */       String str;
/* 107 */       if ((str = b.e(this.c)) == null) {
/* 108 */         x.d("Failed to request for network not avail", new Object[0]);
/*     */       }
/*     */       else
/*     */       {
/* 112 */         paramv.a(l1);
/*     */         
/*     */         HttpURLConnection localHttpURLConnection;
/*     */         
/* 116 */         if ((localHttpURLConnection = a(paramString, paramArrayOfByte, str, paramMap)) != null) {
/*     */           try { int m;
/*     */             Object localObject2;
/* 119 */             if ((m = localHttpURLConnection.getResponseCode()) == 200)
/*     */             {
/* 121 */               this.a = a(localHttpURLConnection);
/*     */               
/* 123 */               localObject2 = b(localHttpURLConnection);
/* 124 */               paramv.b(localObject2 == null ? 0L : localObject2.length);
/* 125 */               return (byte[])localObject2; }
/* 126 */             int n; if ((((n = m) == 301) || (n == 302) || (n == 303) || (n == 307) ? 1 : 0) != 0) {
/* 127 */               k = 1;
/*     */               
/* 129 */               if ((localObject2 = localHttpURLConnection.getHeaderField("Location")) == null)
/*     */               {
/* 131 */                 x.e("Failed to redirect: %d" + m, new Object[0]);
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
/* 157 */                 return null;
/*     */               }
/* 135 */               j++;
/* 136 */               i = 0;
/* 137 */               paramString = (String)localObject2;
/* 138 */               x.c("redirect code: %d ,to:%s", new Object[] { Integer.valueOf(m), paramString });
/*     */             }
/*     */             
/* 141 */             x.d("response code " + m, new Object[0]);
/*     */             
/*     */ 
/* 144 */             long l3 = (l3 = localHttpURLConnection.getContentLength()) < 0L ? 0L : l3;
/* 145 */             paramv.b(l3);
/*     */             
/*     */ 
/*     */             Object localObject1;
/*     */             
/*     */             try
/*     */             {
/* 152 */               localHttpURLConnection.disconnect();
/*     */             } catch (Throwable localThrowable3) {
/* 154 */               if (!x.a(localObject1 = 
/*     */               
/*     */ 
/* 157 */                 localThrowable3)) {
/* 155 */                 ((Throwable)localObject1).printStackTrace();
/*     */               }
/*     */             }
/*     */             
/*     */ 
/* 160 */             x.c("Failed to execute post.", new Object[0]);
/*     */           }
/*     */           catch (IOException localIOException)
/*     */           {
/* 148 */             ((IOException)localObject1).printStackTrace();
/*     */             
/*     */             try
/*     */             {
/* 152 */               localHttpURLConnection.disconnect();
/*     */             } catch (Throwable localThrowable4) {
/* 154 */               if (!x.a(localObject1 = 
/*     */               
/*     */ 
/* 157 */                 localThrowable4)) {
/* 155 */                 ((Throwable)localObject1).printStackTrace();
/*     */               }
/*     */             }
/*     */           }
/*     */           finally
/*     */           {
/*     */             try
/*     */             {
/* 152 */               localHttpURLConnection.disconnect();
/*     */             } catch (Throwable localThrowable5) {
/* 154 */               if (!x.a(paramArrayOfByte = 
/*     */               
/*     */ 
/* 157 */                 localThrowable5)) {
/* 155 */                 paramArrayOfByte.printStackTrace();
/*     */               }
/*     */               
/*     */             }
/*     */             
/*     */           }
/*     */         } else {
/* 162 */           paramv.b(0L);
/*     */         }
/*     */       }
/*     */     }
/* 166 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static Map<String, String> a(HttpURLConnection paramHttpURLConnection)
/*     */   {
/* 175 */     HashMap localHashMap = new HashMap();
/*     */     
/* 177 */     if (((paramHttpURLConnection = paramHttpURLConnection.getHeaderFields()) == null) || (paramHttpURLConnection.size() == 0)) {
/* 178 */       return null;
/*     */     }
/* 180 */     for (String str : paramHttpURLConnection.keySet())
/*     */     {
/*     */       List localList;
/* 183 */       if ((localList = (List)paramHttpURLConnection.get(str)).size() > 0)
/*     */       {
/* 185 */         localHashMap.put(str, localList.get(0));
/*     */       }
/*     */     }
/* 188 */     return localHashMap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static byte[] b(HttpURLConnection paramHttpURLConnection)
/*     */   {
/* 198 */     if (paramHttpURLConnection == null) {
/* 199 */       return null;
/*     */     }
/* 201 */     Object localObject = null;
/*     */     try {
/* 203 */       localObject = new BufferedInputStream(paramHttpURLConnection.getInputStream());
/* 204 */       paramHttpURLConnection = new ByteArrayOutputStream();
/* 205 */       byte[] arrayOfByte = new byte['Ѐ'];
/*     */       int i;
/* 207 */       while ((i = ((BufferedInputStream)localObject).read(arrayOfByte)) > 0) {
/* 208 */         paramHttpURLConnection.write(arrayOfByte, 0, i);
/*     */       }
/* 210 */       paramHttpURLConnection.flush();
/* 211 */       paramHttpURLConnection = paramHttpURLConnection.toByteArray();
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */       try
/*     */       {
/* 218 */         ((BufferedInputStream)localObject).close();
/*     */       }
/*     */       catch (Throwable localThrowable1)
/*     */       {
/* 222 */         (localObject = 
/* 223 */           localThrowable1).printStackTrace(); }
/* 223 */       return paramHttpURLConnection;
/*     */     }
/*     */     catch (Throwable localThrowable2)
/*     */     {
/* 214 */       paramHttpURLConnection.printStackTrace();
/*     */     }
/*     */     finally {
/*     */       try {
/* 218 */         if (localObject != null) {
/* 219 */           ((BufferedInputStream)localObject).close();
/*     */         }
/*     */       } catch (Throwable localThrowable4) {
/* 222 */         (localObject = 
/* 223 */           localThrowable4).printStackTrace();
/*     */       }
/*     */     }
/* 225 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private HttpURLConnection a(String paramString1, byte[] paramArrayOfByte, String paramString2, Map<String, String> paramMap)
/*     */   {
/* 237 */     if (paramString1 == null) {
/* 238 */       x.e("destUrl is null.", new Object[0]);
/* 239 */       return null;
/*     */     }
/*     */     
/*     */ 
/* 243 */     if ((paramString1 = a(paramString2, paramString1)) == null) {
/* 244 */       x.e("Failed to get HttpURLConnection object.", new Object[0]);
/* 245 */       return null;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 250 */       paramString1.setRequestProperty("wup_version", "3.0");
/* 251 */       if ((paramMap != null) && (paramMap.size() > 0)) {
/* 252 */         for (Map.Entry localEntry : paramMap.entrySet())
/*     */         {
/* 254 */           paramString1.setRequestProperty((String)localEntry.getKey(), URLEncoder.encode((String)localEntry.getValue(), "utf-8"));
/*     */         }
/*     */       }
/*     */       
/* 258 */       paramString1.setRequestProperty("A37", URLEncoder.encode(paramString2, "utf-8"));
/*     */       
/* 260 */       paramString1.setRequestProperty("A38", URLEncoder.encode(paramString2, "utf-8"));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 265 */       paramMap = paramString1.getOutputStream();
/* 266 */       if (paramArrayOfByte == null) {
/* 267 */         paramMap.write(0);
/*     */       } else {
/* 269 */         paramMap.write(paramArrayOfByte);
/*     */       }
/* 271 */       return paramString1;
/*     */     } catch (Throwable localThrowable) {
/* 273 */       if (!x.a(paramMap = localThrowable)) {
/* 274 */         paramMap.printStackTrace();
/*     */       }
/* 276 */       x.e("Failed to upload, please check your network.", new Object[0]);
/*     */     }
/* 278 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static HttpURLConnection a(String paramString1, String paramString2)
/*     */   {
/*     */     try
/*     */     {
/* 290 */       paramString2 = new URL(paramString2);
/*     */       
/*     */ 
/* 293 */       if ((paramString1 != null) && (paramString1.toLowerCase(Locale.US).contains("wap"))) {
/* 294 */         paramString1 = System.getProperty("http.proxyHost");
/* 295 */         String str = System.getProperty("http.proxyPort");
/* 296 */         paramString1 = new InetSocketAddress(paramString1, Integer.parseInt(str));
/*     */         
/* 298 */         paramString1 = new Proxy(Proxy.Type.HTTP, paramString1);
/* 299 */         paramString1 = (HttpURLConnection)paramString2.openConnection(paramString1);
/*     */       } else {
/* 301 */         paramString1 = (HttpURLConnection)paramString2.openConnection();
/*     */       }
/* 303 */       paramString1.setConnectTimeout(30000);
/* 304 */       paramString1.setReadTimeout(10000);
/* 305 */       paramString1.setDoOutput(true);
/* 306 */       paramString1.setDoInput(true);
/* 307 */       paramString1.setRequestMethod("POST");
/* 308 */       paramString1.setUseCaches(false);
/*     */       
/* 310 */       paramString1.setInstanceFollowRedirects(false);
/*     */       
/* 312 */       return paramString1;
/*     */     } catch (Throwable localThrowable) {
/* 314 */       if (!x.a(paramString2 = localThrowable)) {
/* 315 */         paramString2.printStackTrace();
/*     */       }
/*     */     }
/* 318 */     return null;
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/s.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */