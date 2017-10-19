/*     */ package com.tencent.bugly.crashreport.crash.anr;
/*     */ 
/*     */ import com.tencent.bugly.proguard.x;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
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
/*     */ public class TraceFileHelper
/*     */ {
/*     */   public static a readTargetDumpInfo(String paramString1, String paramString2, final boolean paramBoolean)
/*     */   {
/*  70 */     if ((paramString1 == null) || (paramString2 == null)) {
/*  71 */       return null;
/*     */     }
/*  73 */     paramString1 = new a();
/*  74 */     readTraceFile(paramString2, new b()
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */       public final boolean a(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  84 */         x.c("new thread %s", new Object[] { paramAnonymousString1 });
/*     */         
/*  86 */         if ((this.a.a <= 0L) || (this.a.c <= 0L) || (this.a.b == null))
/*     */         {
/*  88 */           return true;
/*     */         }
/*     */         
/*  91 */         if (this.a.d == null) {
/*  92 */           this.a.d = new HashMap();
/*     */         }
/*  94 */         this.a.d.put(paramAnonymousString1, new String[] { paramAnonymousString2, paramAnonymousString3, paramAnonymousInt });
/*  95 */         return true;
/*     */       }
/*     */       
/*     */       public final boolean a(long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString)
/*     */       {
/* 100 */         x.c("new process %s", new Object[] { paramAnonymousString });
/* 101 */         if (!paramAnonymousString.equals(paramAnonymousString))
/*     */         {
/* 103 */           return true;
/*     */         }
/* 105 */         this.a.a = paramAnonymousLong1;
/* 106 */         this.a.b = paramAnonymousString;
/* 107 */         this.a.c = paramAnonymousLong2;
/* 108 */         if (!paramBoolean)
/*     */         {
/* 110 */           return false;
/*     */         }
/* 112 */         return true;
/*     */       }
/*     */       
/*     */       public final boolean a(long paramAnonymousLong)
/*     */       {
/* 117 */         x.c("process end %d", new Object[] { Long.valueOf(paramAnonymousLong) });
/*     */         
/* 119 */         if ((this.a.a <= 0L) || (this.a.c <= 0L) || (this.a.b == null))
/*     */         {
/* 121 */           return true;
/*     */         }
/*     */         
/*     */ 
/* 125 */         return false;
/*     */       }
/*     */     });
/*     */     
/* 129 */     if ((paramString1.a > 0L) && (paramString1.c > 0L) && (paramString1.b != null)) {
/* 130 */       return paramString1;
/*     */     }
/*     */     
/* 133 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static a readFirstDumpInfo(String paramString, final boolean paramBoolean)
/*     */   {
/* 144 */     if (paramString == null) {
/* 145 */       x.e("path:%s", new Object[] { paramString });
/* 146 */       return null;
/*     */     }
/* 148 */     a locala = new a();
/* 149 */     readTraceFile(paramString, new b()
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */       public final boolean a(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 159 */         x.c("new thread %s", new Object[] { paramAnonymousString1 });
/* 160 */         if (this.a.d == null) {
/* 161 */           this.a.d = new HashMap();
/*     */         }
/* 163 */         this.a.d.put(paramAnonymousString1, new String[] { paramAnonymousString2, paramAnonymousString3, paramAnonymousInt });
/* 164 */         return true;
/*     */       }
/*     */       
/*     */       public final boolean a(long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString)
/*     */       {
/* 169 */         x.c("new process %s", new Object[] { paramAnonymousString });
/* 170 */         this.a.a = paramAnonymousLong1;
/* 171 */         this.a.b = paramAnonymousString;
/* 172 */         this.a.c = paramAnonymousLong2;
/* 173 */         if (!paramBoolean)
/*     */         {
/* 175 */           return false;
/*     */         }
/* 177 */         return true;
/*     */       }
/*     */       
/*     */       public final boolean a(long paramAnonymousLong)
/*     */       {
/* 182 */         x.c("process end %d", new Object[] { Long.valueOf(paramAnonymousLong) });
/*     */         
/* 184 */         return false;
/*     */       }
/*     */     });
/*     */     
/* 188 */     if ((locala.a > 0L) && (locala.c > 0L) && (locala.b != null)) {
/* 189 */       return locala;
/*     */     }
/*     */     
/* 192 */     x.e("first dump error %s", new Object[] { locala.a + " " + locala.c + " " + locala.b });
/*     */     
/* 194 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void readTraceFile(String paramString, b paramb)
/*     */   {
/* 203 */     if ((paramString == null) || (paramb == null)) {
/* 204 */       return;
/*     */     }
/*     */     
/*     */ 
/* 208 */     if (!(paramString = new File(paramString)).exists()) {
/* 209 */       return;
/*     */     }
/*     */     
/*     */ 
/* 213 */     paramString.lastModified();paramString.length();
/*     */     
/* 215 */     BufferedReader localBufferedReader = null;
/*     */     
/*     */ 
/*     */     try
/*     */     {
/* 220 */       localBufferedReader = new BufferedReader(new FileReader(paramString));
/* 221 */       paramString = null;
/*     */       
/* 223 */       Pattern localPattern1 = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
/* 224 */       Pattern localPattern2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
/* 225 */       Pattern localPattern3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
/* 226 */       Pattern localPattern4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
/* 227 */       SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
/* 228 */       while ((paramString = a(localBufferedReader, new Pattern[] { localPattern1 })) != null)
/*     */       {
/*     */ 
/* 231 */         long l1 = Long.parseLong((paramString = paramString[1].toString().split("\\s"))[2]);
/* 232 */         paramString = paramString[4] + " " + paramString[5];
/*     */         
/* 234 */         long l2 = (paramString = localSimpleDateFormat.parse(paramString)).getTime();
/*     */         
/* 236 */         if ((paramString = a(localBufferedReader, new Pattern[] { localPattern3 })) == null)
/*     */         {
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
/*     */           try
/*     */           {
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
/* 298 */             localBufferedReader.close(); return;
/*     */           }
/*     */           catch (IOException localIOException1)
/*     */           {
/* 302 */             if (!x.a(paramString = 
/*     */             
/*     */ 
/* 305 */               localIOException1)) {
/* 303 */               paramString.printStackTrace();
/*     */             }
/*     */             return;
/*     */           }
/*     */         }
/* 242 */         (paramString = localPattern3.matcher(paramString[1].toString())).find();
/* 243 */         paramString.group(1);
/* 244 */         paramString = paramString.group(1);
/*     */         
/*     */ 
/* 247 */         if (!paramb.a(l1, l2, paramString))
/*     */         {
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
/*     */           try
/*     */           {
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
/* 298 */             localBufferedReader.close(); return;
/*     */           }
/*     */           catch (IOException localIOException2)
/*     */           {
/* 302 */             if (!x.a(paramString = 
/*     */             
/*     */ 
/* 305 */               localIOException2)) {
/* 303 */               paramString.printStackTrace();
/*     */             }
/*     */             return;
/*     */           }
/*     */         }
/* 253 */         while ((paramString = a(localBufferedReader, new Pattern[] { localPattern4, localPattern2 })) != null) {
/* 254 */           if (paramString[0] == localPattern4)
/*     */           {
/* 256 */             paramString = paramString[1].toString();
/*     */             
/*     */ 
/* 259 */             (
/* 260 */               localObject1 = (localObject1 = Pattern.compile("\".+\"")).matcher(paramString)).find();
/*     */             
/* 262 */             Object localObject1 = (localObject1 = ((Matcher)localObject1).group()).substring(1, ((String)localObject1).length() - 1);
/*     */             
/* 264 */             paramString.contains("NATIVE");
/*     */             
/*     */ 
/* 267 */             (
/* 268 */               paramString = (localObject2 = Pattern.compile("tid=\\d+")).matcher(paramString)).find();
/*     */             
/*     */ 
/* 271 */             paramString = Integer.parseInt(paramString = (paramString = paramString.group()).substring(paramString.indexOf("=") + 1));
/*     */             
/* 273 */             Object localObject2 = a(localBufferedReader);
/* 274 */             String str = b(localBufferedReader);
/*     */             
/* 276 */             paramb.a((String)localObject1, paramString, (String)localObject2, str);
/*     */ 
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/*     */ 
/* 283 */             l1 = Long.parseLong((paramString = paramString[1].toString().split("\\s"))[2]);
/* 284 */             if (!paramb.a(l1))
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               try
/*     */               {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 298 */                 localBufferedReader.close(); return;
/*     */               }
/*     */               catch (IOException localIOException3)
/*     */               {
/* 302 */                 if (!x.a(paramString = 
/*     */                 
/*     */ 
/* 305 */                   localIOException3)) {
/* 303 */                   paramString.printStackTrace();
/*     */                 }
/*     */                 return;
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       try
/*     */       {
/* 298 */         localBufferedReader.close();
/*     */       }
/*     */       catch (IOException localIOException4)
/*     */       {
/* 302 */         if (!x.a(paramString = 
/*     */         
/*     */ 
/* 305 */           localIOException4)) {
/* 303 */           paramString.printStackTrace();
/*     */         }
/*     */       }
/*     */       return;
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/* 294 */       paramString.printStackTrace();
/*     */       
/* 296 */       x.d("trace open fail:%s : %s", new Object[] { paramString.getClass().getName(), paramString.getMessage() });
/*     */       
/* 298 */       if (localBufferedReader != null) {
/*     */         try {
/* 300 */           localBufferedReader.close();
/*     */         } catch (IOException localIOException5) {
/* 302 */           if (!x.a(paramString = 
/*     */           
/*     */ 
/* 305 */             localIOException5)) {
/* 303 */             paramString.printStackTrace();
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 298 */       if (localBufferedReader != null) {
/*     */         try {
/* 300 */           localBufferedReader.close();
/*     */         } catch (IOException localIOException6) {
/* 302 */           if (!x.a(paramb = 
/*     */           
/*     */ 
/* 305 */             localIOException6)) {
/* 303 */             paramb.printStackTrace();
/*     */           }
/*     */         }
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
/*     */   private static Object[] a(BufferedReader paramBufferedReader, Pattern... paramVarArgs)
/*     */     throws IOException
/*     */   {
/* 319 */     if ((paramBufferedReader == null) || (paramVarArgs == null)) {
/* 320 */       return null;
/*     */     }
/* 322 */     String str = null;
/* 323 */     while ((str = paramBufferedReader.readLine()) != null) { Pattern[] arrayOfPattern;
/* 324 */       int i = (arrayOfPattern = paramVarArgs).length; for (int j = 0; j < i; j++) { Pattern localPattern;
/*     */         Matcher localMatcher;
/* 326 */         if ((localMatcher = (localPattern = arrayOfPattern[j]).matcher(str)).matches())
/*     */         {
/* 328 */           return paramBufferedReader = new Object[] { localPattern, str };
/*     */         }
/*     */       }
/*     */     }
/* 332 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   private static String a(BufferedReader paramBufferedReader)
/*     */     throws IOException
/*     */   {
/* 339 */     StringBuffer localStringBuffer = new StringBuffer();
/* 340 */     String str = null;
/* 341 */     for (int i = 0; i < 3; i++)
/*     */     {
/* 343 */       if ((str = paramBufferedReader.readLine()) == null) {
/* 344 */         return null;
/*     */       }
/* 346 */       localStringBuffer.append(str + "\n");
/*     */     }
/*     */     
/* 349 */     return localStringBuffer.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   private static String b(BufferedReader paramBufferedReader)
/*     */     throws IOException
/*     */   {
/* 356 */     StringBuffer localStringBuffer = new StringBuffer();
/* 357 */     String str = null;
/* 358 */     while (((str = paramBufferedReader.readLine()) != null) && 
/* 359 */       (str.trim().length() > 0)) {
/* 360 */       localStringBuffer.append(str + "\n");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 366 */     return localStringBuffer.toString();
/*     */   }
/*     */   
/*     */   public static class a
/*     */   {
/*     */     public long a;
/*     */     public String b;
/*     */     public long c;
/*     */     public Map<String, String[]> d;
/*     */   }
/*     */   
/*     */   public static abstract interface b
/*     */   {
/*     */     public abstract boolean a(long paramLong1, long paramLong2, String paramString);
/*     */     
/*     */     public abstract boolean a(long paramLong);
/*     */     
/*     */     public abstract boolean a(String paramString1, int paramInt, String paramString2, String paramString3);
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/crashreport/crash/anr/TraceFileHelper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */