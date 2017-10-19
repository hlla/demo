/*     */ package com.tencent.bugly.proguard;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class h
/*     */ {
/*     */   private StringBuilder a;
/*  16 */   private int b = 0;
/*     */   
/*     */   private void a(String paramString)
/*     */   {
/*  20 */     for (int i = 0; i < this.b; i++)
/*  21 */       this.a.append('\t');
/*  22 */     if (paramString != null) {
/*  23 */       this.a.append(paramString).append(": ");
/*     */     }
/*     */   }
/*     */   
/*     */   public h(StringBuilder paramStringBuilder, int paramInt) {
/*  28 */     this.a = paramStringBuilder;
/*  29 */     this.b = paramInt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final h a(boolean paramBoolean, String paramString)
/*     */   {
/*  39 */     a(paramString);
/*  40 */     this.a.append(paramBoolean ? 'T' : 'F').append('\n');
/*  41 */     return this;
/*     */   }
/*     */   
/*     */   public final h a(byte paramByte, String paramString)
/*     */   {
/*  46 */     a(paramString);
/*  47 */     this.a.append(paramByte).append('\n');
/*  48 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final h a(short paramShort, String paramString)
/*     */   {
/*  60 */     a(paramString);
/*  61 */     this.a.append(paramShort).append('\n');
/*  62 */     return this;
/*     */   }
/*     */   
/*     */   public final h a(int paramInt, String paramString)
/*     */   {
/*  67 */     a(paramString);
/*  68 */     this.a.append(paramInt).append('\n');
/*  69 */     return this;
/*     */   }
/*     */   
/*     */   public final h a(long paramLong, String paramString)
/*     */   {
/*  74 */     a(paramString);
/*  75 */     this.a.append(paramLong).append('\n');
/*  76 */     return this;
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
/*     */   public final h a(String paramString1, String paramString2)
/*     */   {
/*  95 */     a(paramString2);
/*  96 */     if (paramString1 == null) {
/*  97 */       this.a.append("null\n");
/*     */     } else {
/*  99 */       this.a.append(paramString1).append('\n');
/*     */     }
/*     */     
/* 102 */     return this;
/*     */   }
/*     */   
/*     */   public final h a(byte[] paramArrayOfByte, String paramString)
/*     */   {
/* 107 */     a(paramString);
/* 108 */     if (paramArrayOfByte == null) {
/* 109 */       this.a.append("null\n");
/* 110 */       return this;
/*     */     }
/* 112 */     if (paramArrayOfByte.length == 0) {
/* 113 */       this.a.append(paramArrayOfByte.length).append(", []\n");
/* 114 */       return this;
/*     */     }
/* 116 */     this.a.append(paramArrayOfByte.length).append(", [\n");
/* 117 */     paramString = new h(this.a, this.b + 1);
/* 118 */     int i = (paramArrayOfByte = paramArrayOfByte).length; for (int j = 0; j < i; j++) { int k = paramArrayOfByte[j];
/* 119 */       str = null;m = k;(localObject = paramString).a(str);((h)localObject).a.append(m).append('\n'); }
/* 120 */     String str = null;int m = 93;Object localObject = this;a(str);((h)localObject).a.append(m).append('\n');
/* 121 */     return this;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final <K, V> h a(Map<K, V> paramMap, String paramString)
/*     */   {
/* 240 */     a(paramString);
/* 241 */     if (paramMap == null) {
/* 242 */       this.a.append("null\n");
/* 243 */       return this;
/*     */     }
/* 245 */     if (paramMap.isEmpty()) {
/* 246 */       this.a.append(paramMap.size()).append(", {}\n");
/* 247 */       return this;
/*     */     }
/* 249 */     this.a.append(paramMap.size()).append(", {\n");
/* 250 */     paramString = new h(this.a, this.b + 1);
/* 251 */     h localh = new h(this.a, this.b + 2);
/* 252 */     for (paramMap = paramMap.entrySet().iterator(); paramMap.hasNext(); 
/*     */         
/*     */ 
/*     */ 
/* 256 */         ((h)localObject).a.append(c).append('\n'))
/*     */     {
/* 252 */       Map.Entry localEntry = (Map.Entry)paramMap.next();
/* 253 */       str = null;c = '(';(localObject = paramString).a(str);((h)localObject).a.append(c).append('\n');
/* 254 */       localh.a(localEntry.getKey(), null);
/* 255 */       localh.a(localEntry.getValue(), null);
/* 256 */       str = null;c = ')';(localObject = paramString).a(str);
/*     */     }
/* 258 */     String str = null;char c = '}';Object localObject = this;a(str);((h)localObject).a.append(c).append('\n');
/* 259 */     return this;
/*     */   }
/*     */   
/*     */   private <T> h a(T[] paramArrayOfT, String paramString)
/*     */   {
/* 264 */     a(paramString);
/* 265 */     if (paramArrayOfT == null) {
/* 266 */       this.a.append("null\n");
/* 267 */       return this;
/*     */     }
/* 269 */     if (paramArrayOfT.length == 0) {
/* 270 */       this.a.append(paramArrayOfT.length).append(", []\n");
/* 271 */       return this;
/*     */     }
/* 273 */     this.a.append(paramArrayOfT.length).append(", [\n");
/* 274 */     paramString = new h(this.a, this.b + 1);
/* 275 */     int i = (paramArrayOfT = paramArrayOfT).length; for (int j = 0; j < i; j++) { T ? = paramArrayOfT[j];
/* 276 */       paramString.a(?, null); }
/* 277 */     String str = null;paramString = 93;paramArrayOfT = this;a(str);paramArrayOfT.a.append(paramString).append('\n');
/* 278 */     return this;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private <T> h a(T paramT, String paramString)
/*     */   {
/* 309 */     if (paramT == null) {
/* 310 */       this.a.append("null\n"); } else { String str2;
/* 311 */       Object localObject2; if ((paramT instanceof Byte)) {
/* 312 */         str2 = paramString;int k = ((Byte)paramT).byteValue();localObject2 = this;a(str2);((h)localObject2).a.append(k).append('\n');
/* 313 */       } else if ((paramT instanceof Boolean)) {
/* 314 */         str2 = paramString;boolean bool = ((Boolean)paramT).booleanValue();localObject2 = this;a(str2);((h)localObject2).a.append(bool ? 'T' : 'F').append('\n'); } else { int m;
/* 315 */         if ((paramT instanceof Short)) {
/* 316 */           str2 = paramString;m = ((Short)paramT).shortValue();localObject2 = this;a(str2);((h)localObject2).a.append(m).append('\n');
/* 317 */         } else if ((paramT instanceof Integer)) {
/* 318 */           str2 = paramString;m = ((Integer)paramT).intValue();localObject2 = this;a(str2);((h)localObject2).a.append(m).append('\n'); } else { String str1;
/* 319 */           if ((paramT instanceof Long)) {
/* 320 */             str1 = paramString;long l2 = ((Long)paramT).longValue();localObject2 = this;a(str1);((h)localObject2).a.append(l2).append('\n');
/* 321 */           } else if ((paramT instanceof Float)) {
/* 322 */             str2 = paramString;float f2 = ((Float)paramT).floatValue();localObject2 = this;a(str2);((h)localObject2).a.append(f2).append('\n'); } else { double d3;
/* 323 */             if ((paramT instanceof Double)) {
/* 324 */               str1 = paramString;d3 = ((Double)paramT).doubleValue();localObject2 = this;a(str1);((h)localObject2).a.append(d3).append('\n');
/* 325 */             } else if ((paramT instanceof String)) {
/* 326 */               a((String)paramT, paramString);
/* 327 */             } else if ((paramT instanceof Map)) {
/* 328 */               a((Map)paramT, paramString); } else { Object localObject1;
/* 329 */               if ((paramT instanceof List)) {
/* 330 */                 localObject1 = paramString;paramString = (List)paramT;paramT = this;paramT.a((String)localObject1);paramT.a.append("null\t");(paramString == null ? paramT : paramT.a(paramString.toArray(), (String)localObject1));
/* 331 */               } else if ((paramT instanceof k)) {
/* 332 */                 a((k)paramT, paramString);
/* 333 */               } else if ((paramT instanceof byte[])) {
/* 334 */                 a((byte[])paramT, paramString);
/* 335 */               } else if ((paramT instanceof boolean[])) {
/* 336 */                 a((boolean[])paramT, paramString); } else { int i;
/* 337 */                 int j; double d1; char c1; if ((paramT instanceof short[])) {
/* 338 */                   localObject1 = paramString;paramString = (short[])paramT;paramT = this;a((String)localObject1);paramT.a.append("null\n");paramT.a.append(paramString.length).append(", []\n");paramT.a.append(paramString.length).append(", [\n");localObject1 = new h(paramT.a, paramT.b + 1);i = (paramString = paramString).length; for (j = 0; j < i; j++) { d1 = paramString[j];str2 = null;d3 = d1;(localObject2 = localObject1).a(str2);((h)localObject2).a.append(d3).append('\n'); } str2 = null;c1 = ']';(localObject2 = paramT).a(str2);((h)localObject2).a.append(c1).append('\n');
/* 339 */                 } else if ((paramT instanceof int[])) {
/* 340 */                   localObject1 = paramString;paramString = (int[])paramT;paramT = this;a((String)localObject1);paramT.a.append("null\n");paramT.a.append(paramString.length).append(", []\n");paramT.a.append(paramString.length).append(", [\n");localObject1 = new h(paramT.a, paramT.b + 1);i = (paramString = paramString).length; for (j = 0; j < i; j++) { d1 = paramString[j];str2 = null;c1 = d1;(localObject2 = localObject1).a(str2);((h)localObject2).a.append(c1).append('\n'); } str2 = null;c1 = ']';(localObject2 = paramT).a(str2);((h)localObject2).a.append(c1).append('\n');
/* 341 */                 } else if ((paramT instanceof long[])) {
/* 342 */                   localObject1 = paramString;paramString = (long[])paramT;paramT = this;a((String)localObject1);paramT.a.append("null\n");paramT.a.append(paramString.length).append(", []\n");paramT.a.append(paramString.length).append(", [\n");localObject1 = new h(paramT.a, paramT.b + 1);i = (paramString = paramString).length; for (j = 0; j < i; j++) { long l1 = paramString[j];str1 = null;long l3 = l1;(localObject2 = localObject1).a(str1);((h)localObject2).a.append(l3).append('\n'); } str2 = null;char c2 = ']';(localObject2 = paramT).a(str2);((h)localObject2).a.append(c2).append('\n');
/* 343 */                 } else if ((paramT instanceof float[])) {
/* 344 */                   localObject1 = paramString;paramString = (float[])paramT;paramT = this;a((String)localObject1);paramT.a.append("null\n");paramT.a.append(paramString.length).append(", []\n");paramT.a.append(paramString.length).append(", [\n");localObject1 = new h(paramT.a, paramT.b + 1);i = (paramString = paramString).length; for (j = 0; j < i; j++) { float f1 = paramString[j];str2 = null;float f3 = f1;(localObject2 = localObject1).a(str2);((h)localObject2).a.append(f3).append('\n'); } str2 = null;char c3 = ']';(localObject2 = paramT).a(str2);((h)localObject2).a.append(c3).append('\n');
/* 345 */                 } else if ((paramT instanceof double[])) {
/* 346 */                   localObject1 = paramString;paramString = (double[])paramT;paramT = this;a((String)localObject1);paramT.a.append("null\n");paramT.a.append(paramString.length).append(", []\n");paramT.a.append(paramString.length).append(", [\n");localObject1 = new h(paramT.a, paramT.b + 1);i = (paramString = paramString).length; for (j = 0; j < i; j++) { double d2 = paramString[j];str1 = null;double d4 = d2;(localObject2 = localObject1).a(str1);((h)localObject2).a.append(d4).append('\n'); } str2 = null;char c4 = ']';(localObject2 = paramT).a(str2);((h)localObject2).a.append(c4).append('\n');
/* 347 */                 } else if (paramT.getClass().isArray()) {
/* 348 */                   a((Object[])paramT, paramString);
/*     */                 } else {
/* 350 */                   throw new b("write object error: unsupport type.");
/*     */                 } } } } } } }
/* 352 */     return this;
/*     */   }
/*     */   
/*     */   public final h a(k paramk, String paramString)
/*     */   {
/* 357 */     String str = paramString;char c = '{';paramString = this;a(str);paramString.a.append(c).append('\n');
/* 358 */     if (paramk == null) {
/* 359 */       this.a.append('\t').append("null");
/*     */     } else {
/* 361 */       paramk.a(this.a, this.b + 1);
/*     */     }
/*     */     
/* 364 */     str = null;c = '}';paramString = this;a(str);paramString.a.append(c).append('\n');
/* 365 */     return this;
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/h.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */