/*     */ package com.tencent.bugly.proguard;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.nio.ByteBuffer;
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
/*     */ 
/*     */ public final class j
/*     */ {
/*     */   private ByteBuffer a;
/*     */   
/*     */   public j(int paramInt)
/*     */   {
/*  22 */     this.a = ByteBuffer.allocate(paramInt);
/*     */   }
/*     */   
/*     */   public j()
/*     */   {
/*  27 */     this(128);
/*     */   }
/*     */   
/*     */   public final ByteBuffer a()
/*     */   {
/*  32 */     return this.a;
/*     */   }
/*     */   
/*     */   public final byte[] b() {
/*  36 */     byte[] arrayOfByte = new byte[this.a.position()];
/*  37 */     System.arraycopy(this.a.array(), 0, arrayOfByte, 0, this.a.position());
/*  38 */     return arrayOfByte;
/*     */   }
/*     */   
/*     */   private void a(int paramInt)
/*     */   {
/*  43 */     if (this.a.remaining() < paramInt)
/*     */     {
/*     */ 
/*  46 */       (paramInt = ByteBuffer.allocate(paramInt = this.a.capacity() + paramInt << 1)).put(this.a.array(), 0, this.a.position());
/*  47 */       this.a = paramInt;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void b(byte paramByte, int paramInt)
/*     */   {
/*  55 */     if (paramInt < 15) {
/*  56 */       paramByte = (byte)(paramInt << 4 | paramByte);
/*  57 */       this.a.put(paramByte);
/*  58 */       return; } if (paramInt < 256) {
/*  59 */       paramByte = (byte)(0xF0 | paramByte);
/*  60 */       this.a.put(paramByte);
/*  61 */       this.a.put((byte)paramInt);
/*  62 */       return; }
/*  63 */     throw new b("tag is too large: " + paramInt);
/*     */   }
/*     */   
/*     */ 
/*     */   public final void a(boolean paramBoolean, int paramInt)
/*     */   {
/*  69 */     paramBoolean = (byte)(paramBoolean ? 1 : 0);
/*  70 */     a(paramBoolean, paramInt);
/*     */   }
/*     */   
/*     */   public final void a(byte paramByte, int paramInt)
/*     */   {
/*  75 */     a(3);
/*  76 */     if (paramByte == 0) {
/*  77 */       b((byte)12, paramInt);return;
/*     */     }
/*  79 */     b((byte)0, paramInt);
/*  80 */     this.a.put(paramByte);
/*     */   }
/*     */   
/*     */ 
/*     */   public final void a(short paramShort, int paramInt)
/*     */   {
/*  86 */     a(4);
/*  87 */     if ((paramShort >= -128) && (paramShort <= 127)) {
/*  88 */       a((byte)paramShort, paramInt);return;
/*     */     }
/*  90 */     b((byte)1, paramInt);
/*  91 */     this.a.putShort(paramShort);
/*     */   }
/*     */   
/*     */ 
/*     */   public final void a(int paramInt1, int paramInt2)
/*     */   {
/*  97 */     a(6);
/*  98 */     if ((paramInt1 >= 32768) && (paramInt1 <= 32767)) {
/*  99 */       a((short)paramInt1, paramInt2);return;
/*     */     }
/* 101 */     b((byte)2, paramInt2);
/* 102 */     this.a.putInt(paramInt1);
/*     */   }
/*     */   
/*     */ 
/*     */   public final void a(long paramLong, int paramInt)
/*     */   {
/* 108 */     a(10);
/* 109 */     if ((paramLong >= -2147483648L) && (paramLong <= 2147483647L)) {
/* 110 */       a((int)paramLong, paramInt);return;
/*     */     }
/* 112 */     b((byte)3, paramInt);
/* 113 */     this.a.putLong(paramLong);
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
/*     */   public final void a(String paramString, int paramInt)
/*     */   {
/*     */     byte[] arrayOfByte;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     try
/*     */     {
/* 168 */       arrayOfByte = paramString.getBytes(this.b);
/*     */     }
/*     */     catch (UnsupportedEncodingException localUnsupportedEncodingException)
/*     */     {
/* 172 */       arrayOfByte = paramString.getBytes();
/*     */     }
/* 174 */     a(10 + arrayOfByte.length);
/* 175 */     if (arrayOfByte.length > 255) {
/* 176 */       b((byte)7, paramInt);
/* 177 */       this.a.putInt(arrayOfByte.length);
/* 178 */       this.a.put(arrayOfByte);return;
/*     */     }
/* 180 */     b((byte)6, paramInt);
/* 181 */     this.a.put((byte)arrayOfByte.length);
/* 182 */     this.a.put(arrayOfByte);
/*     */   }
/*     */   
/*     */ 
/*     */   public final <K, V> void a(Map<K, V> paramMap, int paramInt)
/*     */   {
/* 188 */     a(8);
/* 189 */     b((byte)8, paramInt);
/* 190 */     a(paramMap == null ? 0 : paramMap.size(), 0);
/* 191 */     if (paramMap != null) {
/* 192 */       for (paramMap = paramMap.entrySet().iterator(); paramMap.hasNext();) { paramInt = (Map.Entry)paramMap.next();
/* 193 */         a(paramInt.getKey(), 0);
/* 194 */         a(paramInt.getValue(), 1);
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
/*     */   public final void a(byte[] paramArrayOfByte, int paramInt)
/*     */   {
/* 210 */     a(8 + paramArrayOfByte.length);
/* 211 */     b((byte)13, paramInt);
/* 212 */     b((byte)0, 0);
/* 213 */     a(paramArrayOfByte.length, 0);
/* 214 */     this.a.put(paramArrayOfByte);
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
/*     */   public final <T> void a(Collection<T> paramCollection, int paramInt)
/*     */   {
/* 278 */     a(8);
/* 279 */     b((byte)9, paramInt);
/* 280 */     a(paramCollection == null ? 0 : paramCollection.size(), 0);
/* 281 */     if (paramCollection != null) {
/* 282 */       for (paramCollection = paramCollection.iterator(); paramCollection.hasNext();) { paramInt = paramCollection.next();
/* 283 */         a(paramInt, 0);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public final void a(k paramk, int paramInt) {
/* 289 */     a(2);
/* 290 */     b((byte)10, paramInt);
/* 291 */     paramk.a(this);
/* 292 */     a(2);
/* 293 */     b((byte)11, 0);
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
/*     */   public final void a(Object paramObject, int paramInt)
/*     */   {
/* 333 */     if ((paramObject instanceof Byte)) {
/* 334 */       a(((Byte)paramObject).byteValue(), paramInt); return; }
/* 335 */     int i1; Object localObject1; if ((paramObject instanceof Boolean)) {
/* 336 */       i1 = paramInt;boolean bool = ((Boolean)paramObject).booleanValue();localObject1 = this;byte b1 = (byte)(bool ? 1 : 0);((j)localObject1).a(b1, i1);return; }
/* 337 */     if ((paramObject instanceof Short)) {
/* 338 */       a(((Short)paramObject).shortValue(), paramInt);return; }
/* 339 */     if ((paramObject instanceof Integer)) {
/* 340 */       a(((Integer)paramObject).intValue(), paramInt);return; }
/* 341 */     if ((paramObject instanceof Long)) {
/* 342 */       a(((Long)paramObject).longValue(), paramInt);return; }
/* 343 */     if ((paramObject instanceof Float)) {
/* 344 */       i1 = paramInt;float f2 = ((Float)paramObject).floatValue();localObject1 = this;a(6);((j)localObject1).b((byte)4, i1);((j)localObject1).a.putFloat(f2); return; }
/* 345 */     int k; if ((paramObject instanceof Double)) {
/* 346 */       k = paramInt;double d2 = ((Double)paramObject).doubleValue();localObject1 = this;a(10);((j)localObject1).b((byte)5, k);((j)localObject1).a.putDouble(d2);return; }
/* 347 */     if ((paramObject instanceof String)) {
/* 348 */       a((String)paramObject, paramInt);return; }
/* 349 */     if ((paramObject instanceof Map)) {
/* 350 */       a((Map)paramObject, paramInt);return; }
/* 351 */     if ((paramObject instanceof List)) {
/* 352 */       a((List)paramObject, paramInt); return; }
/* 353 */     k localk2; if ((paramObject instanceof k)) {
/* 354 */       i1 = paramInt;localk2 = (k)paramObject;localObject1 = this;a(2);((j)localObject1).b((byte)10, i1);localk2.a((j)localObject1);((j)localObject1).a(2);((j)localObject1).b((byte)11, 0);return; }
/* 355 */     if ((paramObject instanceof byte[])) {
/* 356 */       a((byte[])paramObject, paramInt); return; }
/* 357 */     int i; int j; k localk1; if ((paramObject instanceof boolean[])) {
/* 358 */       i = paramInt;paramInt = (boolean[])paramObject;paramObject = this;a(8);((j)paramObject).b((byte)9, i);((j)paramObject).a(paramInt.length, 0);i = (paramInt = paramInt).length; for (j = 0; j < i; j++) { localk1 = paramInt[j];i1 = 0;localk2 = localk1;localObject1 = paramObject;k = (byte)(localk2 != 0 ? 1 : 0);((j)localObject1).a(k, i1); } return; }
/* 359 */     if ((paramObject instanceof short[])) {
/* 360 */       i = paramInt;paramInt = (short[])paramObject;paramObject = this;a(8);((j)paramObject).b((byte)9, i);((j)paramObject).a(paramInt.length, 0);i = (paramInt = paramInt).length; for (j = 0; j < i; j++) { localk1 = paramInt[j];((j)paramObject).a(localk1, 0); } return; }
/* 361 */     if ((paramObject instanceof int[])) {
/* 362 */       i = paramInt;paramInt = (int[])paramObject;paramObject = this;a(8);((j)paramObject).b((byte)9, i);((j)paramObject).a(paramInt.length, 0);i = (paramInt = paramInt).length; for (j = 0; j < i; j++) { int n = paramInt[j];((j)paramObject).a(n, 0); } return; }
/* 363 */     if ((paramObject instanceof long[])) {
/* 364 */       i = paramInt;paramInt = (long[])paramObject;paramObject = this;a(8);((j)paramObject).b((byte)9, i);((j)paramObject).a(paramInt.length, 0);i = (paramInt = paramInt).length; for (j = 0; j < i; j++) { long l = paramInt[j];((j)paramObject).a(l, 0); } return; }
/* 365 */     if ((paramObject instanceof float[])) {
/* 366 */       i = paramInt;paramInt = (float[])paramObject;paramObject = this;a(8);((j)paramObject).b((byte)9, i);((j)paramObject).a(paramInt.length, 0);i = (paramInt = paramInt).length; for (j = 0; j < i; j++) { float f1 = paramInt[j];i1 = 0;float f3 = f1;(localObject1 = paramObject).a(6);((j)localObject1).b((byte)4, i1);((j)localObject1).a.putFloat(f3); } return; }
/* 367 */     if ((paramObject instanceof double[])) {
/* 368 */       i = paramInt;paramInt = (double[])paramObject;paramObject = this;a(8);((j)paramObject).b((byte)9, i);((j)paramObject).a(paramInt.length, 0);i = (paramInt = paramInt).length; for (j = 0; j < i; j++) { double d1 = paramInt[j];int m = 0;double d3 = d1;(localObject1 = paramObject).a(10);((j)localObject1).b((byte)5, m);((j)localObject1).a.putDouble(d3); } return; }
/* 369 */     if (paramObject.getClass().isArray()) {
/* 370 */       i = paramInt;paramInt = (Object[])paramObject;paramObject = this;a(8);((j)paramObject).b((byte)9, i);((j)paramObject).a(paramInt.length, 0);i = (paramInt = paramInt).length; for (j = 0; j < i; j++) { Object localObject2 = paramInt[j];((j)paramObject).a(localObject2, 0); } return; }
/* 371 */     if ((paramObject instanceof Collection)) {
/* 372 */       a((Collection)paramObject, paramInt);return;
/*     */     }
/* 374 */     throw new b("write object error: unsupport type. " + paramObject.getClass());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/* 379 */   private String b = "GBK";
/*     */   
/* 381 */   public final int a(String paramString) { this.b = paramString;
/* 382 */     return 0;
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/j.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */