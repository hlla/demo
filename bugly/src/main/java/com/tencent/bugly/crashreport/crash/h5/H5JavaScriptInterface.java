/*     */ package com.tencent.bugly.crashreport.crash.h5;
/*     */ 
/*     */ import android.webkit.JavascriptInterface;
/*     */ import com.tencent.bugly.crashreport.inner.InnerApi;
/*     */ import com.tencent.bugly.proguard.x;
/*     */ import com.tencent.bugly.proguard.z;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
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
/*     */ public class H5JavaScriptInterface
/*     */ {
/*  25 */   private static HashSet<Integer> a = new HashSet();
/*     */   
/*  27 */   private String b = null;
/*  28 */   private Thread c = null;
/*  29 */   private String d = null;
/*  30 */   private Map<String, String> e = null;
/*     */   
/*     */   /* Error */
/*     */   public static H5JavaScriptInterface getInstance(com.tencent.bugly.crashreport.CrashReport.WebViewInterface arg0)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: ifnull +19 -> 20
/*     */     //   4: getstatic 61	com/tencent/bugly/crashreport/crash/h5/H5JavaScriptInterface:a	Ljava/util/HashSet;
/*     */     //   7: aload_0
/*     */     //   8: invokevirtual 88	java/lang/Object:hashCode	()I
/*     */     //   11: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   14: invokevirtual 109	java/util/HashSet:contains	(Ljava/lang/Object;)Z
/*     */     //   17: ifeq +5 -> 22
/*     */     //   20: aconst_null
/*     */     //   21: areturn
/*     */     //   22: new 43	com/tencent/bugly/crashreport/crash/h5/H5JavaScriptInterface
/*     */     //   25: dup
/*     */     //   26: invokespecial 77	com/tencent/bugly/crashreport/crash/h5/H5JavaScriptInterface:<init>	()V
/*     */     //   29: astore_1
/*     */     //   30: getstatic 61	com/tencent/bugly/crashreport/crash/h5/H5JavaScriptInterface:a	Ljava/util/HashSet;
/*     */     //   33: aload_0
/*     */     //   34: invokevirtual 88	java/lang/Object:hashCode	()I
/*     */     //   37: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   40: invokevirtual 108	java/util/HashSet:add	(Ljava/lang/Object;)Z
/*     */     //   43: pop
/*     */     //   44: aload_1
/*     */     //   45: invokestatic 103	java/lang/Thread:currentThread	()Ljava/lang/Thread;
/*     */     //   48: putfield 63	com/tencent/bugly/crashreport/crash/h5/H5JavaScriptInterface:c	Ljava/lang/Thread;
/*     */     //   51: aload_1
/*     */     //   52: aload_1
/*     */     //   53: getfield 63	com/tencent/bugly/crashreport/crash/h5/H5JavaScriptInterface:c	Ljava/lang/Thread;
/*     */     //   56: dup
/*     */     //   57: astore_2
/*     */     //   58: ifnonnull +7 -> 65
/*     */     //   61: aconst_null
/*     */     //   62: goto +77 -> 139
/*     */     //   65: new 53	java/lang/StringBuilder
/*     */     //   68: dup
/*     */     //   69: invokespecial 97	java/lang/StringBuilder:<init>	()V
/*     */     //   72: dup
/*     */     //   73: astore_3
/*     */     //   74: ldc 1
/*     */     //   76: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   79: pop
/*     */     //   80: iconst_2
/*     */     //   81: istore 4
/*     */     //   83: iload 4
/*     */     //   85: aload_2
/*     */     //   86: invokevirtual 104	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
/*     */     //   89: arraylength
/*     */     //   90: if_icmpge +45 -> 135
/*     */     //   93: aload_2
/*     */     //   94: invokevirtual 104	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
/*     */     //   97: iload 4
/*     */     //   99: aaload
/*     */     //   100: dup
/*     */     //   101: astore 5
/*     */     //   103: invokevirtual 89	java/lang/StackTraceElement:toString	()Ljava/lang/String;
/*     */     //   106: ldc 31
/*     */     //   108: invokevirtual 90	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
/*     */     //   111: ifne +18 -> 129
/*     */     //   114: aload_3
/*     */     //   115: aload 5
/*     */     //   117: invokevirtual 89	java/lang/StackTraceElement:toString	()Ljava/lang/String;
/*     */     //   120: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   123: ldc 1
/*     */     //   125: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   128: pop
/*     */     //   129: iinc 4 1
/*     */     //   132: goto -49 -> 83
/*     */     //   135: aload_3
/*     */     //   136: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */     //   139: putfield 64	com/tencent/bugly/crashreport/crash/h5/H5JavaScriptInterface:d	Ljava/lang/String;
/*     */     //   142: aload_1
/*     */     //   143: aload_0
/*     */     //   144: astore_2
/*     */     //   145: new 56	java/util/HashMap
/*     */     //   148: dup
/*     */     //   149: invokespecial 106	java/util/HashMap:<init>	()V
/*     */     //   152: dup
/*     */     //   153: astore_3
/*     */     //   154: ldc 17
/*     */     //   156: new 53	java/lang/StringBuilder
/*     */     //   159: dup
/*     */     //   160: invokespecial 97	java/lang/StringBuilder:<init>	()V
/*     */     //   163: aload_2
/*     */     //   164: invokeinterface 114 1 0
/*     */     //   169: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   172: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */     //   175: invokeinterface 115 3 0
/*     */     //   180: pop
/*     */     //   181: aload_3
/*     */     //   182: putfield 65	com/tencent/bugly/crashreport/crash/h5/H5JavaScriptInterface:e	Ljava/util/Map;
/*     */     //   185: aload_1
/*     */     //   186: areturn
/*     */     // Line number table:
/*     */     //   Java source line #41	-> byte code offset #0
/*     */     //   Java source line #42	-> byte code offset #20
/*     */     //   Java source line #44	-> byte code offset #22
/*     */     //   Java source line #45	-> byte code offset #30
/*     */     //   Java source line #46	-> byte code offset #44
/*     */     //   Java source line #47	-> byte code offset #51
/*     */     //   Java source line #48	-> byte code offset #142
/*     */     //   Java source line #49	-> byte code offset #185
/*     */   }
/*     */   
/*     */   private static a a(String paramString)
/*     */   {
/*  76 */     if ((paramString == null) || (paramString.length() <= 0)) {
/*  77 */       return null;
/*     */     }
/*     */     try {
/*  80 */       paramString = new JSONObject(paramString);
/*     */       
/*     */       a locala;
/*  83 */       (locala = new a()).a = paramString.getString("projectRoot");
/*  84 */       if (locala.a == null) {
/*  85 */         return null;
/*     */       }
/*  87 */       locala.b = paramString.getString("context");
/*  88 */       if (locala.b == null) {
/*  89 */         return null;
/*     */       }
/*  91 */       locala.c = paramString.getString("url");
/*  92 */       if (locala.c == null) {
/*  93 */         return null;
/*     */       }
/*  95 */       locala.d = paramString.getString("userAgent");
/*  96 */       if (locala.d == null) {
/*  97 */         return null;
/*     */       }
/*  99 */       locala.e = paramString.getString("language");
/* 100 */       if (locala.e == null) {
/* 101 */         return null;
/*     */       }
/* 103 */       locala.f = paramString.getString("name");
/* 104 */       if ((locala.f == null) || (locala.f.equals("null"))) {
/* 105 */         return null;
/*     */       }
/*     */       String str;
/* 108 */       if ((str = paramString.getString("stacktrace")) == null) {
/* 109 */         return null;
/*     */       }
/*     */       int i;
/* 112 */       if ((i = str.indexOf("\n")) < 0) {
/* 113 */         x.d("H5 crash stack's format is wrong!", new Object[0]);
/* 114 */         return null;
/*     */       }
/* 116 */       locala.h = str.substring(i + 1);
/* 117 */       locala.g = str.substring(0, i);
/*     */       
/* 119 */       if ((i = locala.g.indexOf(":")) > 0) {
/* 120 */         locala.g = locala.g.substring(i + 1);
/*     */       }
/* 122 */       locala.i = paramString.getString("file");
/* 123 */       if (locala.f == null) {
/* 124 */         return null;
/*     */       }
/* 126 */       locala.j = paramString.getLong("lineNumber");
/* 127 */       if (locala.j < 0L) {
/* 128 */         return null;
/*     */       }
/* 130 */       locala.k = paramString.getLong("columnNumber");
/* 131 */       if (locala.k < 0L) {
/* 132 */         return null;
/*     */       }
/* 134 */       x.a("H5 crash information is following: ", new Object[0]);
/* 135 */       x.a("[projectRoot]: " + locala.a, new Object[0]);
/* 136 */       x.a("[context]: " + locala.b, new Object[0]);
/* 137 */       x.a("[url]: " + locala.c, new Object[0]);
/* 138 */       x.a("[userAgent]: " + locala.d, new Object[0]);
/* 139 */       x.a("[language]: " + locala.e, new Object[0]);
/* 140 */       x.a("[name]: " + locala.f, new Object[0]);
/* 141 */       x.a("[message]: " + locala.g, new Object[0]);
/* 142 */       x.a("[stacktrace]: \n" + locala.h, new Object[0]);
/* 143 */       x.a("[file]: " + locala.i, new Object[0]);
/* 144 */       x.a("[lineNumber]: " + locala.j, new Object[0]);
/* 145 */       x.a("[columnNumber]: " + locala.k, new Object[0]);
/* 146 */       return locala;
/*     */     } catch (Throwable localThrowable) {
/* 148 */       if (!x.a(paramString = localThrowable))
/* 149 */         paramString.printStackTrace();
/*     */     }
/* 151 */     return null;
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
/*     */   @JavascriptInterface
/*     */   public void printLog(String paramString)
/*     */   {
/* 172 */     x.d("Log from js: %s", new Object[] { paramString });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @JavascriptInterface
/*     */   public void reportJSException(String paramString)
/*     */   {
/* 182 */     if (paramString == null) {
/* 183 */       x.d("Payload from JS is null.", new Object[0]);
/* 184 */       return;
/*     */     }
/* 186 */     Object localObject1 = z.b(paramString.getBytes());
/* 187 */     if ((this.b != null) && (this.b.equals(localObject1))) {
/* 188 */       x.d("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
/*     */       
/* 190 */       return;
/*     */     }
/* 192 */     this.b = ((String)localObject1);
/* 193 */     x.d("Handling JS exception ...", new Object[0]);
/*     */     
/* 195 */     if ((paramString = a(paramString)) == null) {
/* 196 */       x.d("Failed to parse payload.", new Object[0]);
/* 197 */       return;
/*     */     }
/*     */     
/* 200 */     String str1 = paramString;Object localObject2 = new LinkedHashMap(); if (str1.a != null) ((Map)localObject2).put("[JS] projectRoot", str1.a); if (str1.b != null) ((Map)localObject2).put("[JS] context", str1.b); if (str1.c != null) ((Map)localObject2).put("[JS] url", str1.c); if (str1.d != null) ((Map)localObject2).put("[JS] userAgent", str1.d); if (str1.i != null) ((Map)localObject2).put("[JS] file", str1.i); if (str1.j != 0L) ((Map)localObject2).put("[JS] lineNumber", Long.toString(str1.j)); (localObject1 = new LinkedHashMap()).putAll((Map)localObject2);
/* 201 */     ((Map)localObject1).putAll(this.e);
/* 202 */     ((Map)localObject1).put("Java Stack", this.d);
/* 203 */     paramString = (String)localObject1;localObject2 = this.c; if ((str1 = paramString) != null) { localObject1 = str1.f;String str2 = str1.g;str1 = str1.h;InnerApi.postH5CrashAsync((Thread)localObject2, (String)localObject1, str2, str1, paramString);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/crashreport/crash/h5/H5JavaScriptInterface.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */