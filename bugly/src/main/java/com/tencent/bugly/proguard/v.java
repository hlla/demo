/*     */ package com.tencent.bugly.proguard;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.os.Process;
/*     */ import com.tencent.bugly.crashreport.common.info.b;
/*     */ import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.UUID;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class v
/*     */   implements Runnable
/*     */ {
/*  42 */   private int a = 2;
/*     */   
/*  44 */   private int b = 30000;
/*     */   
/*     */   private final Context c;
/*     */   
/*     */   private final int d;
/*     */   private final byte[] e;
/*     */   private final com.tencent.bugly.crashreport.common.info.a f;
/*     */   private final com.tencent.bugly.crashreport.common.strategy.a g;
/*     */   private final s h;
/*     */   private final u i;
/*     */   private final int j;
/*     */   private final t k;
/*     */   private final t l;
/*  57 */   private String m = null;
/*     */   
/*     */   private final String n;
/*     */   private final Map<String, String> o;
/*  61 */   private int p = 0;
/*  62 */   private long q = 0L;
/*  63 */   private long r = 0L;
/*     */   
/*     */ 
/*  66 */   private boolean s = true;
/*  67 */   private boolean t = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public v(Context paramContext, int paramInt1, int paramInt2, byte[] paramArrayOfByte, String paramString1, String paramString2, t paramt, boolean paramBoolean1, boolean paramBoolean2)
/*     */   {
/*  85 */     this(paramContext, paramInt1, paramInt2, paramArrayOfByte, paramString1, paramString2, paramt, paramBoolean1, 2, 30000, paramBoolean2, null);
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
/*     */   public v(Context paramContext, int paramInt1, int paramInt2, byte[] paramArrayOfByte, String paramString1, String paramString2, t paramt, boolean paramBoolean1, int paramInt3, int paramInt4, boolean paramBoolean2, Map<String, String> paramMap)
/*     */   {
/* 106 */     this.c = paramContext;
/* 107 */     this.f = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
/* 108 */     this.e = paramArrayOfByte;
/* 109 */     this.g = com.tencent.bugly.crashreport.common.strategy.a.a();
/* 110 */     this.h = s.a(paramContext);
/* 111 */     this.i = u.a();
/* 112 */     this.j = paramInt1;
/* 113 */     this.m = paramString1;
/* 114 */     this.n = paramString2;
/* 115 */     this.k = paramt;
/* 116 */     this.l = null;
/*     */     
/* 118 */     this.s = paramBoolean1;
/* 119 */     this.d = paramInt2;
/* 120 */     if (paramInt3 > 0) {
/* 121 */       this.a = paramInt3;
/*     */     }
/* 123 */     if (paramInt4 > 0) {
/* 124 */       this.b = paramInt4;
/*     */     }
/*     */     
/* 127 */     this.t = paramBoolean2;
/* 128 */     this.o = paramMap;
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
/*     */   private void a(an paraman, boolean paramBoolean, int paramInt1, String paramString, int paramInt2)
/*     */   {
/* 160 */     switch (this.d) {
/*     */     case 630: 
/*     */     case 830: 
/* 163 */       paraman = "crash";
/* 164 */       break;
/*     */     case 640: 
/*     */     case 840: 
/* 167 */       paraman = "userinfo";
/* 168 */       break;
/*     */     default: 
/* 170 */       paraman = String.valueOf(this.d);
/*     */     }
/* 172 */     if (paramBoolean) {
/* 173 */       x.a("[Upload] Success: %s", new Object[] { paraman });
/*     */     } else {
/* 175 */       x.e("[Upload] Failed to upload(%d) %s: %s", new Object[] { Integer.valueOf(paramInt1), paraman, paramString });
/* 176 */       if (this.s) {
/* 177 */         this.i.a(paramInt2, null);
/*     */       }
/*     */     }
/*     */     
/* 181 */     if (this.q + this.r > 0L) {
/* 182 */       long l1 = this.i.a(this.t) + this.q + this.r;
/*     */       
/* 184 */       this.i.a(l1, this.t);
/*     */     }
/*     */     
/* 187 */     if (this.k != null) {
/* 188 */       this.k.a(paramBoolean);
/*     */     }
/* 190 */     if (this.l != null) {
/* 191 */       this.l.a(paramBoolean);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean a(an paraman, com.tencent.bugly.crashreport.common.info.a parama, com.tencent.bugly.crashreport.common.strategy.a parama1)
/*     */   {
/* 200 */     if (paraman == null) {
/* 201 */       x.d("resp == null!", new Object[0]);
/* 202 */       return false;
/*     */     }
/*     */     
/* 205 */     if (paraman.a != 0) {
/* 206 */       x.e("resp result error %d", new Object[] { Byte.valueOf(paraman.a) });
/* 207 */       return false;
/*     */     }
/*     */     Object localObject;
/* 210 */     try { if ((!z.a(paraman.d)) && (!com.tencent.bugly.crashreport.common.info.a.b().i().equals(paraman.d)))
/*     */       {
/* 212 */         p.a().a(com.tencent.bugly.crashreport.common.strategy.a.a, "key_ip", paraman.d.getBytes("UTF-8"), null, true);
/*     */         
/*     */ 
/* 215 */         parama.d(paraman.d);
/*     */       }
/* 217 */       if ((!z.a(paraman.f)) && (!com.tencent.bugly.crashreport.common.info.a.b().j().equals(paraman.f)))
/*     */       {
/* 219 */         p.a().a(com.tencent.bugly.crashreport.common.strategy.a.a, "key_imei", paraman.f.getBytes("UTF-8"), null, true);
/*     */         
/* 221 */         parama.e(paraman.f);
/*     */       }
/*     */     } catch (Throwable localThrowable) {
/* 224 */       x.a(localObject = 
/* 225 */         localThrowable); }
/* 226 */     parama.i = paraman.e;
/*     */     
/*     */ 
/* 229 */     if (paraman.b == 510) {
/* 230 */       if (paraman.c == null) {
/* 231 */         x.e("[Upload] Strategy data is null. Response cmd: %d", new Object[] { Integer.valueOf(paraman.b) });
/* 232 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 237 */       if ((localObject = (ap)a.a(paraman.c, ap.class)) == null) {
/* 238 */         x.e("[Upload] Failed to decode strategy from server. Response cmd: %d", new Object[] { Integer.valueOf(paraman.b) });
/*     */         
/* 240 */         return false;
/*     */       }
/* 242 */       parama1.a((ap)localObject);
/*     */     }
/*     */     
/* 245 */     return true;
/*     */   }
/*     */   
/*     */   public final void run()
/*     */   {
/*     */     try {
/* 251 */       this.p = 0;
/* 252 */       this.q = 0L;
/* 253 */       this.r = 0L;
/* 254 */       localObject1 = this.e;
/*     */       
/*     */ 
/* 257 */       if (b.e(this.c) == null) {
/* 258 */         a(null, false, 0, "network is not available", 0);
/* 259 */         return;
/*     */       }
/* 261 */       if ((localObject1 == null) || (localObject1.length == 0)) {
/* 262 */         a(null, false, 0, "request package is empty!", 0); return;
/*     */       }
/*     */       
/*     */       long l1;
/* 266 */       if ((l1 = this.i.a(this.t)) + localObject1.length >= 2097152L)
/*     */       {
/* 268 */         x.e("[Upload] Upload too much data, try next time: %d/%d", new Object[] { Long.valueOf(l1), Long.valueOf(2097152L) });
/*     */         
/* 270 */         a(null, false, 0, "over net consume: " + 2048L + "K", 0);
/*     */         
/* 272 */         return;
/*     */       }
/*     */       
/* 275 */       x.c("[Upload] Run upload task with cmd: %d", new Object[] { Integer.valueOf(this.d) });
/*     */       
/* 277 */       if ((this.c == null) || (this.f == null) || (this.g == null) || (this.h == null))
/*     */       {
/* 279 */         a(null, false, 0, "illegal access error", 0);
/* 280 */         return;
/*     */       }
/*     */       
/*     */ 
/* 284 */       if ((localObject2 = this.g.c()) == null) {
/* 285 */         a(null, false, 0, "illegal local strategy", 0);
/* 286 */         return;
/*     */       }
/*     */       
/* 289 */       int i1 = 0;
/*     */       
/*     */       HashMap localHashMap;
/* 292 */       (localHashMap = new HashMap()).put("prodId", this.f.f());
/* 293 */       localHashMap.put("bundleId", this.f.c);
/* 294 */       localHashMap.put("appVer", this.f.j);
/*     */       
/*     */ 
/* 297 */       if (this.o != null) {
/* 298 */         localHashMap.putAll(this.o);
/*     */       }
/*     */       
/*     */ 
/* 302 */       if (this.s)
/*     */       {
/* 304 */         localHashMap.put("cmd", Integer.toString(this.d));
/* 305 */         localHashMap.put("platformId", Byte.toString((byte)1));
/*     */         
/* 307 */         this.f.getClass();localHashMap.put("sdkVer", "2.6.5");
/* 308 */         localHashMap.put("strategylastUpdateTime", Long.toString(((StrategyBean)localObject2).p));
/*     */         
/*     */ 
/* 311 */         if (!this.i.a(localHashMap)) {
/* 312 */           a(null, false, 0, "failed to add security info to HTTP headers", 0);
/*     */           
/* 314 */           return;
/*     */         }
/*     */         
/*     */ 
/* 318 */         if ((localObject1 = z.a((byte[])localObject1, 2)) == null) {
/* 319 */           a(null, false, 0, "failed to zip request body", 0);
/* 320 */           return;
/*     */         }
/*     */         
/*     */ 
/* 324 */         if ((localObject1 = this.i.a((byte[])localObject1)) == null) {
/* 325 */           a(null, false, 0, "failed to encrypt request body", 0);
/*     */           
/* 327 */           return;
/*     */         }
/*     */       }
/*     */       
/* 331 */       Object localObject3 = this;this.i.a(((v)localObject3).j, System.currentTimeMillis()); if ((((v)localObject3).k == null) || (((v)localObject3).l != null)) {}
/*     */       
/* 333 */       Object localObject2 = this.m;
/* 334 */       int i3 = -1;
/* 335 */       int i4 = 0;
/* 336 */       byte[] arrayOfByte2; while (i4++ < this.a) {
/* 337 */         if (i4 > 1) {
/* 338 */           x.d("[Upload] Failed to upload last time, wait and try(%d) again.", new Object[] { Integer.valueOf(i4) });
/*     */           
/* 340 */           z.b(this.b);
/* 341 */           if (i4 == this.a) {
/* 342 */             x.d("[Upload] Use the back-up url at the last time: %s", new Object[] { this.n });
/*     */             
/*     */ 
/* 345 */             localObject2 = this.n;
/*     */           }
/*     */         }
/*     */         
/* 349 */         x.c("[Upload] Send %d bytes", new Object[] { Integer.valueOf(localObject1.length) });
/* 350 */         if (this.s) {
/* 351 */           localObject2 = a((String)localObject2);
/*     */         }
/* 353 */         x.c("[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).", new Object[] { localObject2, Integer.valueOf(this.d), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
/*     */         byte[] arrayOfByte1;
/*     */         int i2;
/* 356 */         if ((arrayOfByte1 = this.h.a((String)localObject2, (byte[])localObject1, this, localHashMap)) == null) {
/* 357 */           localObject3 = "Failed to upload for no response!";i2 = 1;x.e("[Upload] Failed to upload(%d): %s", new Object[] { Integer.valueOf(1), localObject3 });
/*     */           
/* 359 */           i2 = 1;
/*     */         }
/*     */         else
/*     */         {
/* 363 */           Map localMap = this.h.a;
/* 364 */           Map.Entry localEntry; if (this.s) {
/* 365 */             x.d("[Upload] Headers is empty.", new Object[0]);x.d("[Upload] Headers does not contain %s", new Object[] { "status" });x.d("[Upload] Headers does not contain %s", new Object[] { "Bugly-Version" });x.d("[Upload] Bugly version is not valid: %s", new Object[] { localObject3 });x.c("[Upload] Bugly version from headers is: %s", new Object[] { localObject3 }); if ((!(localObject3 = (String)((Map)localObject3).get("Bugly-Version")).contains("bugly") ? 0 : !((Map)localObject3).containsKey("Bugly-Version") ? 0 : !((Map)localObject3).containsKey("status") ? 0 : ((localObject3 = localMap) == null) || (((Map)localObject3).size() == 0) ? 0 : 1) == 0) {
/* 366 */               x.c("[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d).", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
/*     */               
/*     */ 
/* 369 */               localObject3 = "[Upload] Failed to upload for no status header.";i2 = 1;x.e("[Upload] Failed to upload(%d): %s", new Object[] { Integer.valueOf(1), localObject3 });
/*     */               Iterator localIterator;
/* 371 */               if (localMap != null) {
/* 372 */                 for (localIterator = localMap.entrySet().iterator(); localIterator.hasNext();) { localEntry = (Map.Entry)localIterator.next();
/* 373 */                   x.c(String.format("[key]: %s, [value]: %s", new Object[] { localEntry.getKey(), localEntry.getValue() }), new Object[0]);
/*     */                 }
/*     */               }
/*     */               
/* 377 */               x.c("[Upload] Failed to upload for no status header.", new Object[0]);
/* 378 */               i2 = 1;
/* 379 */               continue;
/*     */             }
/*     */             try
/*     */             {
/* 383 */               i3 = Integer.parseInt((String)localMap.get("status"));
/*     */               
/* 385 */               x.c("[Upload] Status from server is %d (pid=%d | tid=%d).", new Object[] { Integer.valueOf(i3), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
/*     */ 
/*     */             }
/*     */             catch (Throwable localThrowable1)
/*     */             {
/* 390 */               localObject3 = "[Upload] Failed to upload for format of status header is invalid: " + Integer.toString(i3);i2 = 1;x.e("[Upload] Failed to upload(%d): %s", new Object[] { Integer.valueOf(1), localObject3 });
/*     */               
/*     */ 
/* 393 */               i2 = 1; }
/* 394 */             continue;
/*     */             
/*     */ 
/* 397 */             if (i3 != 0)
/*     */             {
/* 399 */               if (i3 == 2)
/*     */               {
/* 401 */                 if (this.q + this.r > 0L) {
/* 402 */                   long l2 = this.i.a(this.t) + this.q + this.r;
/*     */                   
/* 404 */                   this.i.a(l2, this.t);
/*     */                 }
/*     */                 
/* 407 */                 this.i.a(i3, null);
/*     */                 
/* 409 */                 x.a("[Upload] Session ID is invalid, will try again immediately (pid=%d | tid=%d).", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
/*     */                 
/*     */ 
/* 412 */                 this.i.a(this.j, this.d, this.e, this.m, this.n, this.k, this.a, this.b, true, this.o);return;
/*     */               }
/*     */               
/*     */ 
/* 416 */               a(null, false, 1, "status of server is " + i3, i3);
/*     */               
/*     */ 
/*     */ 
/*     */ 
/* 421 */               return;
/*     */             }
/*     */           }
/*     */           
/* 425 */           x.c("[Upload] Received %d bytes", new Object[] { Integer.valueOf(i2.length) });
/*     */           Object localObject4;
/* 427 */           if (this.s) {
/* 428 */             if (i2.length == 0)
/*     */             {
/* 430 */               for (localObject4 = localMap.entrySet().iterator(); ((Iterator)localObject4).hasNext();) { localEntry = (Map.Entry)((Iterator)localObject4).next();
/* 431 */                 x.c("[Upload] HTTP headers from server: key = %s, value = %s", new Object[] { localEntry.getKey(), localEntry.getValue() });
/*     */               }
/*     */               
/* 434 */               a(null, false, 1, "response data from server is empty", 0);
/*     */               
/*     */ 
/* 437 */               return;
/*     */             }
/*     */             
/*     */ 
/* 441 */             if ((arrayOfByte2 = this.i.b(i2)) == null) {
/* 442 */               a(null, false, 1, "failed to decrypt response from server", 0);
/*     */               
/*     */ 
/* 445 */               return;
/*     */             }
/*     */             
/*     */ 
/* 449 */             if ((arrayOfByte2 = z.b(arrayOfByte2, 2)) == null) {
/* 450 */               a(null, false, 1, "failed unzip(Gzip) response from server", 0);
/*     */               
/*     */ 
/* 453 */               return;
/*     */             }
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 460 */           if ((localObject4 = a.a(arrayOfByte2, this.s)) == null) {
/* 461 */             a(null, false, 1, "failed to decode response package", 0);
/*     */             
/*     */ 
/* 464 */             return;
/*     */           }
/*     */           
/* 467 */           if (this.s)
/*     */           {
/* 469 */             this.i.a(i3, (an)localObject4);
/*     */           }
/*     */           
/* 472 */           x.c("[Upload] Response cmd is: %d, length of sBuffer is: %d", new Object[] { Integer.valueOf(((an)localObject4).b), Integer.valueOf(((an)localObject4).c == null ? 0 : ((an)localObject4).c.length) });
/*     */           
/*     */ 
/* 475 */           if (!a((an)localObject4, this.f, this.g)) {
/* 476 */             a((an)localObject4, false, 2, "failed to process response package", 0);
/*     */             
/* 478 */             return;
/*     */           }
/*     */           
/*     */ 
/* 482 */           a((an)localObject4, true, 2, "successfully uploaded", 0);
/* 483 */           return;
/*     */         }
/*     */       }
/* 486 */       a(null, false, arrayOfByte2, "failed after many attempts", 0); return;
/*     */     } catch (Throwable localThrowable2) { Object localObject1;
/* 488 */       if (!x.a(localObject1 = 
/*     */       
/*     */ 
/* 491 */         localThrowable2)) {
/* 489 */         ((Throwable)localObject1).printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public final void a(long paramLong) {
/* 495 */     this.p += 1;
/* 496 */     this.q += paramLong;
/*     */   }
/*     */   
/*     */   public final void b(long paramLong) {
/* 500 */     this.r += paramLong;
/*     */   }
/*     */   
/*     */   private static String a(String paramString) {
/* 504 */     if (z.a(paramString)) {
/* 505 */       return paramString;
/*     */     }
/*     */     try {
/* 508 */       return String.format("%s?aid=%s", new Object[] { paramString, UUID.randomUUID().toString() });
/*     */     } catch (Throwable localThrowable2) { Throwable localThrowable1;
/* 510 */       x.a(localThrowable1 = localThrowable2); }
/* 511 */     return paramString;
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/v.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */