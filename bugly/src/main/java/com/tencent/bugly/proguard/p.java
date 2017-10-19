/*     */ package com.tencent.bugly.proguard;
/*     */ 
/*     */ import android.content.ContentValues;
/*     */ import android.content.Context;
/*     */ import android.database.Cursor;
/*     */ import android.database.sqlite.SQLiteDatabase;
/*     */ import com.tencent.bugly.a;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class p
/*     */ {
/*  29 */   private static p a = null;
/*  30 */   private static q b = null;
/*     */   
/*  32 */   private static boolean c = false;
/*     */   
/*     */   private p(Context paramContext, List<a> paramList) {
/*  35 */     b = new q(paramContext, paramList);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static synchronized p a(Context paramContext, List<a> paramList)
/*     */   {
/*  47 */     if (a == null) {
/*  48 */       a = new p(paramContext, paramList);
/*     */     }
/*  50 */     return a;
/*     */   }
/*     */   
/*     */   public static synchronized p a() {
/*  54 */     return a;
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
/*     */   public final long a(String paramString, ContentValues paramContentValues, o paramo, boolean paramBoolean)
/*     */   {
/*  68 */     return a(paramString, paramContentValues, null);
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
/*     */   public final Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, o paramo, boolean paramBoolean)
/*     */   {
/*  91 */     int i = 1;paramBoolean = null;paramString1 = null;paramString1 = null;paramString1 = null;paramString1 = null;paramo = null;paramArrayOfString2 = paramString2;paramString2 = paramArrayOfString1;paramArrayOfString1 = paramString1;paramString1 = 0;paramString1 = this; if (i == 0) { (paramString1 = new a(paramString1, 3, paramBoolean)).a(false, paramArrayOfString1, paramString2, paramArrayOfString2, paramo, null, null, null, null);w.a().a(paramString1);return null; } return paramString1.a(false, paramArrayOfString1, paramString2, paramArrayOfString2, paramo, null, null, null, null, paramBoolean);
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
/*     */   public final int a(String paramString1, String paramString2, String[] paramArrayOfString, o paramo, boolean paramBoolean)
/*     */   {
/* 139 */     return a(paramString1, paramString2, null, null);
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
/*     */   private synchronized long a(String paramString, ContentValues paramContentValues, o paramo)
/*     */   {
/* 157 */     long l1 = 0L;
/* 158 */     SQLiteDatabase localSQLiteDatabase = null;
/*     */     try
/*     */     {
/* 161 */       if (((localSQLiteDatabase = b.getWritableDatabase()) != null) && (paramContentValues != null)) {
/*     */         long l2;
/* 163 */         if ((l2 = localSQLiteDatabase.replace(paramString, "_id", paramContentValues)) >= 0L) {
/* 164 */           x.c("[Database] insert %s success.", new Object[] { paramString });
/*     */         } else {
/* 166 */           x.d("[Database] replace %s error.", new Object[] { paramString });
/*     */         }
/* 168 */         l1 = l2;
/*     */       }
/*     */     } catch (Throwable localThrowable2) {
/*     */       Throwable localThrowable1;
/* 172 */       localThrowable1.printStackTrace();
/*     */ 
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/*     */ 
/* 179 */       if (paramo != null) {
/* 176 */         Long.valueOf(0L);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 182 */     return l1;
/*     */   }
/*     */   
/*     */ 
/*     */   private synchronized Cursor a(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6, o paramo)
/*     */   {
/* 188 */     localCursor = null;
/* 189 */     SQLiteDatabase localSQLiteDatabase = null;
/*     */     try
/*     */     {
/* 192 */       if ((localSQLiteDatabase = b.getWritableDatabase()) != null) {
/* 193 */         localCursor = localSQLiteDatabase.query(paramBoolean, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 202 */       if (paramo == null) {}
/*     */       
/*     */ 
/*     */ 
/* 206 */       return localCursor;
/*     */     }
/*     */     catch (Throwable localThrowable)
/*     */     {
/* 198 */       if (!x.a(paramBoolean = 
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 203 */         localThrowable)) {
/* 199 */         paramBoolean.printStackTrace();
/*     */       }
/*     */       
/* 202 */       if (paramo != null) {
/*     */         break label71;
/*     */       }
/*     */     }
/*     */     finally {}
/*     */   }
/*     */   
/*     */ 
/*     */   private synchronized int a(String paramString1, String paramString2, String[] paramArrayOfString, o paramo)
/*     */   {
/* 212 */     int i = 0;
/* 213 */     SQLiteDatabase localSQLiteDatabase = null;
/*     */     try
/*     */     {
/* 216 */       if ((localSQLiteDatabase = b.getWritableDatabase()) != null) {
/* 217 */         i = localSQLiteDatabase.delete(paramString1, paramString2, paramArrayOfString);
/*     */       }
/*     */     }
/*     */     catch (Throwable localThrowable) {
/* 221 */       paramString1.printStackTrace();
/*     */ 
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/*     */ 
/* 228 */       if (paramo != null) {
/* 225 */         Integer.valueOf(0);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 231 */     return i;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean a(int paramInt, String paramString, byte[] paramArrayOfByte, o paramo, boolean paramBoolean)
/*     */   {
/* 243 */     if (!paramBoolean)
/*     */     {
/* 245 */       (paramo = new a(4, null)).a(paramInt, paramString, paramArrayOfByte);
/* 246 */       w.a().a(paramo);
/* 247 */       return true;
/*     */     }
/* 249 */     return a(paramInt, paramString, paramArrayOfByte, null);
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
/*     */   public final Map<String, byte[]> a(int paramInt, o paramo, boolean paramBoolean)
/*     */   {
/* 264 */     return a(paramInt, null);
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
/*     */   public final boolean a(int paramInt, String paramString, o paramo, boolean paramBoolean)
/*     */   {
/* 285 */     return a(555, paramString, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean a(int paramInt, String paramString, byte[] paramArrayOfByte, o paramo)
/*     */   {
/* 296 */     boolean bool = false;
/*     */     try
/*     */     {
/* 299 */       (localObject = new r()).a = paramInt;
/* 300 */       ((r)localObject).f = paramString;
/* 301 */       ((r)localObject).e = System.currentTimeMillis();
/* 302 */       ((r)localObject).g = paramArrayOfByte;
/* 303 */       bool = b((r)localObject);
/*     */     } catch (Throwable localThrowable) {
/*     */       Object localObject;
/* 306 */       ((Throwable)localObject).printStackTrace();
/*     */     }
/*     */     finally {
/* 309 */       if (paramo != null) {
/* 310 */         Boolean.valueOf(false);
/*     */       }
/*     */     }
/* 313 */     return bool;
/*     */   }
/*     */   
/*     */   private Map<String, byte[]> a(int paramInt, o paramo) {
/* 317 */     localHashMap = null;
/*     */     try
/*     */     {
/* 320 */       if ((paramInt = c(paramInt)) != null) {
/* 321 */         localHashMap = new HashMap();
/* 322 */         for (paramInt = paramInt.iterator(); paramInt.hasNext();) { r localr;
/*     */           byte[] arrayOfByte;
/* 324 */           if ((arrayOfByte = (localr = (r)paramInt.next()).g) != null) {
/* 325 */             localHashMap.put(localr.f, arrayOfByte);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 334 */       if (paramo == null) {}
/*     */       
/*     */ 
/*     */ 
/* 338 */       return localHashMap;
/*     */     }
/*     */     catch (Throwable localThrowable)
/*     */     {
/* 330 */       if (!x.a(paramInt = 
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 335 */         localThrowable)) {
/* 331 */         paramInt.printStackTrace();
/*     */       }
/*     */       
/* 334 */       if (paramo != null) {
/*     */         return localHashMap;
/*     */       }
/*     */     }
/*     */     finally {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final synchronized boolean a(r paramr)
/*     */   {
/* 347 */     if (paramr == null) {
/* 348 */       return false;
/*     */     }
/* 350 */     SQLiteDatabase localSQLiteDatabase = null;
/*     */     try
/*     */     {
/* 353 */       if ((localSQLiteDatabase = b.getWritableDatabase()) != null)
/*     */       {
/* 355 */         if ((localObject = c(paramr)) != null) {
/*     */           long l;
/* 357 */           if ((l = localSQLiteDatabase.replace("t_lr", "_id", (ContentValues)localObject)) >= 0L) {
/* 358 */             x.c("[Database] insert %s success.", new Object[] { "t_lr" });
/* 359 */             paramr.a = l;
/* 360 */             return true;
/*     */           }
/* 362 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 366 */       return false;
/*     */     } catch (Throwable localThrowable) { Object localObject;
/* 368 */       if (!x.a(localObject = localThrowable)) {
/* 369 */         ((Throwable)localObject).printStackTrace();
/*     */       }
/* 371 */       return false;
/*     */     }
/*     */     finally {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private synchronized boolean b(r paramr)
/*     */   {
/* 385 */     if (paramr == null) {
/* 386 */       return false;
/*     */     }
/* 388 */     SQLiteDatabase localSQLiteDatabase = null;
/*     */     try
/*     */     {
/* 391 */       if ((localSQLiteDatabase = b.getWritableDatabase()) != null)
/*     */       {
/* 393 */         if ((localObject = d(paramr)) != null) {
/*     */           long l;
/* 395 */           if ((l = localSQLiteDatabase.replace("t_pf", "_id", (ContentValues)localObject)) >= 0L) {
/* 396 */             x.c("[Database] insert %s success.", new Object[] { "t_pf" });
/* 397 */             paramr.a = l;
/* 398 */             return true;
/*     */           }
/* 400 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 404 */       return false;
/*     */     } catch (Throwable localThrowable) { Object localObject;
/* 406 */       if (!x.a(localObject = localThrowable)) {
/* 407 */         ((Throwable)localObject).printStackTrace();
/*     */       }
/* 409 */       return false;
/*     */     }
/*     */     finally {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final synchronized List<r> a(int paramInt)
/*     */   {
/*     */     SQLiteDatabase localSQLiteDatabase;
/*     */     
/*     */ 
/*     */ 
/* 424 */     if ((localSQLiteDatabase = b.getWritableDatabase()) != null) {
/* 425 */       Cursor localCursor = null;
/*     */       try {
/* 427 */         paramInt = paramInt >= 0 ? "_tp = " + paramInt : null;
/*     */         
/*     */ 
/*     */ 
/* 431 */         if ((localCursor = localSQLiteDatabase.query("t_lr", null, paramInt, null, null, null, null)) == null)
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 469 */           return null;
/*     */         }
/* 435 */         paramInt = new StringBuilder();
/* 436 */         ArrayList localArrayList1 = new ArrayList();
/* 437 */         while (localCursor.moveToNext()) {
/*     */           r localr;
/* 439 */           if ((localr = a(localCursor)) != null) {
/* 440 */             localArrayList1.add(localr);
/*     */           } else {
/*     */             try
/*     */             {
/* 444 */               long l = localCursor.getLong(localCursor.getColumnIndex("_id"));
/* 445 */               paramInt.append(" or _id").append(" = ").append(l);
/*     */             }
/*     */             catch (Throwable localThrowable1) {
/* 448 */               x.d("[Database] unknown id.", new Object[0]);
/*     */             }
/*     */           }
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 455 */         if ((paramInt = paramInt.toString()).length() > 0) {
/* 456 */           paramInt = paramInt.substring(4);
/* 457 */           int i = localSQLiteDatabase.delete("t_lr", paramInt, null);
/* 458 */           x.d("[Database] deleted %s illegal data %d", new Object[] { "t_lr", Integer.valueOf(i) });
/*     */         }
/* 460 */         ArrayList localArrayList2 = localArrayList1;
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 469 */         return localArrayList2;
/*     */       }
/*     */       catch (Throwable localThrowable2)
/*     */       {
/* 463 */         paramInt.printStackTrace();
/*     */ 
/*     */ 
/*     */       }
/*     */       finally
/*     */       {
/*     */ 
/* 470 */         if (localCursor != null) {
/* 467 */           localCursor.close();
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 475 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public final synchronized void a(List<r> paramList)
/*     */   {
/* 483 */     if ((paramList == null) || (paramList.size() == 0)) {
/*     */       return;
/*     */     }
/*     */     SQLiteDatabase localSQLiteDatabase;
/* 487 */     if ((localSQLiteDatabase = b.getWritableDatabase()) != null) {
/* 488 */       StringBuilder localStringBuilder = new StringBuilder();
/* 489 */       for (r localr : paramList) {
/* 490 */         localStringBuilder.append(" or _id").append(" = ").append(localr.a);
/*     */       }
/*     */       
/*     */ 
/* 494 */       if ((paramList = localStringBuilder.toString()).length() > 0) {
/* 495 */         paramList = paramList.substring(4);
/*     */       }
/* 497 */       localStringBuilder.setLength(0);
/*     */       try {
/* 499 */         int i = localSQLiteDatabase.delete("t_lr", paramList, null);
/* 500 */         x.c("[Database] deleted %s data %d", new Object[] { "t_lr", Integer.valueOf(i) }); return;
/*     */       } catch (Throwable localThrowable2) { Throwable localThrowable1;
/* 502 */         if (!x.a(localThrowable1
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 507 */            = localThrowable2)) {
/* 503 */           localThrowable1.printStackTrace();
/*     */         }
/*     */         
/* 506 */         return;
/*     */       }
/*     */       finally {}
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public final synchronized void b(int paramInt)
/*     */   {
/*     */     SQLiteDatabase localSQLiteDatabase;
/*     */     
/*     */ 
/* 520 */     if ((localSQLiteDatabase = b.getWritableDatabase()) != null) {
/*     */       try {
/* 522 */         paramInt = paramInt >= 0 ? "_tp = " + paramInt : null;
/* 523 */         paramInt = localSQLiteDatabase.delete("t_lr", paramInt, null);
/* 524 */         x.c("[Database] deleted %s data %d", new Object[] { "t_lr", Integer.valueOf(paramInt) }); return;
/*     */       } catch (Throwable localThrowable) {
/* 526 */         if (!x.a(paramInt
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 531 */            = localThrowable)) {
/* 527 */           paramInt.printStackTrace();
/*     */         }
/*     */         
/* 530 */         return;
/*     */       }
/*     */       finally {}
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static ContentValues c(r paramr)
/*     */   {
/* 542 */     if (paramr == null) {
/* 543 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 547 */       localObject = new ContentValues();
/* 548 */       if (paramr.a > 0L) {
/* 549 */         ((ContentValues)localObject).put("_id", Long.valueOf(paramr.a));
/*     */       }
/* 551 */       ((ContentValues)localObject).put("_tp", Integer.valueOf(paramr.b));
/* 552 */       ((ContentValues)localObject).put("_pc", paramr.c);
/* 553 */       ((ContentValues)localObject).put("_th", paramr.d);
/* 554 */       ((ContentValues)localObject).put("_tm", Long.valueOf(paramr.e));
/* 555 */       if (paramr.g != null) {
/* 556 */         ((ContentValues)localObject).put("_dt", paramr.g);
/*     */       }
/* 558 */       return (ContentValues)localObject;
/*     */     } catch (Throwable localThrowable) { Object localObject;
/* 560 */       if (!x.a(localObject = localThrowable)) {
/* 561 */         ((Throwable)localObject).printStackTrace();
/*     */       }
/*     */     }
/* 564 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static r a(Cursor paramCursor)
/*     */   {
/* 571 */     if (paramCursor == null) {
/* 572 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 576 */       (localObject = new r()).a = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
/* 577 */       ((r)localObject).b = paramCursor.getInt(paramCursor.getColumnIndex("_tp"));
/* 578 */       ((r)localObject).c = paramCursor.getString(paramCursor.getColumnIndex("_pc"));
/* 579 */       ((r)localObject).d = paramCursor.getString(paramCursor.getColumnIndex("_th"));
/* 580 */       ((r)localObject).e = paramCursor.getLong(paramCursor.getColumnIndex("_tm"));
/* 581 */       ((r)localObject).g = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"));
/* 582 */       return (r)localObject;
/*     */     } catch (Throwable localThrowable) { Object localObject;
/* 584 */       if (!x.a(localObject = localThrowable)) {
/* 585 */         ((Throwable)localObject).printStackTrace();
/*     */       }
/*     */     }
/* 588 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private synchronized List<r> c(int paramInt)
/*     */   {
/* 598 */     Cursor localCursor = null;
/* 599 */     SQLiteDatabase localSQLiteDatabase = null;
/*     */     try
/*     */     {
/* 602 */       if ((localSQLiteDatabase = b.getWritableDatabase()) != null) {
/* 603 */         localObject1 = "_id = " + paramInt;
/*     */         
/*     */ 
/* 606 */         if ((localCursor = localSQLiteDatabase.query("t_pf", null, (String)localObject1, null, null, null, null)) == null)
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 644 */           return null;
/*     */         }
/* 610 */         StringBuilder localStringBuilder = new StringBuilder();
/* 611 */         ArrayList localArrayList1 = new ArrayList();
/* 612 */         while (localCursor.moveToNext()) {
/*     */           Object localObject2;
/* 614 */           if ((localObject2 = b(localCursor)) != null) {
/* 615 */             localArrayList1.add(localObject2);
/*     */           } else {
/*     */             try
/*     */             {
/* 619 */               localObject2 = localCursor.getString(localCursor.getColumnIndex("_tp"));
/* 620 */               localStringBuilder.append(" or _tp").append(" = ").append((String)localObject2);
/*     */             } catch (Throwable localThrowable1) {
/* 622 */               x.d("[Database] unknown id.", new Object[0]);
/*     */             }
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 628 */         if (localStringBuilder.length() > 0) {
/* 629 */           localStringBuilder.append(" and _id").append(" = ").append(paramInt);
/* 630 */           localObject1 = ((String)localObject1).substring(4);
/* 631 */           int i = localSQLiteDatabase.delete("t_pf", (String)localObject1, null);
/* 632 */           x.d("[Database] deleted %s illegal data %d.", new Object[] { "t_pf", Integer.valueOf(i) });
/*     */         }
/* 634 */         ArrayList localArrayList2 = localArrayList1;
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 644 */         return localArrayList2;
/*     */       }
/*     */     }
/*     */     catch (Throwable localThrowable2)
/*     */     {
/*     */       Object localObject1;
/* 638 */       ((Throwable)localObject1).printStackTrace();
/*     */ 
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/*     */ 
/* 645 */       if (localCursor != null) {
/* 642 */         localCursor.close();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 648 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private synchronized boolean a(int paramInt, String paramString, o paramo)
/*     */   {
/* 658 */     boolean bool = false;
/* 659 */     SQLiteDatabase localSQLiteDatabase = null;
/*     */     try
/*     */     {
/* 662 */       if ((localSQLiteDatabase = b.getWritableDatabase()) != null)
/*     */       {
/* 664 */         if (z.a(paramString)) {
/* 665 */           paramInt = "_id = " + paramInt;
/*     */         } else {
/* 667 */           paramInt = "_id = " + paramInt + " and _tp" + " = \"" + paramString + "\"";
/*     */         }
/*     */         
/*     */ 
/* 671 */         paramInt = localSQLiteDatabase.delete("t_pf", paramInt, null);
/* 672 */         x.c("[Database] deleted %s data %d", new Object[] { "t_pf", Integer.valueOf(paramInt) });
/* 673 */         bool = paramInt > 0;
/*     */       }
/*     */     }
/*     */     catch (Throwable localThrowable) {
/* 677 */       paramInt.printStackTrace();
/*     */ 
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/*     */ 
/* 684 */       if (paramo != null) {
/* 681 */         Boolean.valueOf(false);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 687 */     return bool;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static ContentValues d(r paramr)
/*     */   {
/* 694 */     if ((paramr == null) || (z.a(paramr.f))) {
/* 695 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 699 */       localObject = new ContentValues();
/* 700 */       if (paramr.a > 0L) {
/* 701 */         ((ContentValues)localObject).put("_id", Long.valueOf(paramr.a));
/*     */       }
/* 703 */       ((ContentValues)localObject).put("_tp", paramr.f);
/* 704 */       ((ContentValues)localObject).put("_tm", Long.valueOf(paramr.e));
/* 705 */       if (paramr.g != null) {
/* 706 */         ((ContentValues)localObject).put("_dt", paramr.g);
/*     */       }
/* 708 */       return (ContentValues)localObject;
/*     */     } catch (Throwable localThrowable) { Object localObject;
/* 710 */       if (!x.a(localObject = localThrowable)) {
/* 711 */         ((Throwable)localObject).printStackTrace();
/*     */       }
/*     */     }
/* 714 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static r b(Cursor paramCursor)
/*     */   {
/* 721 */     if (paramCursor == null) {
/* 722 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 726 */       (localObject = new r()).a = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
/* 727 */       ((r)localObject).e = paramCursor.getLong(paramCursor.getColumnIndex("_tm"));
/* 728 */       ((r)localObject).f = paramCursor.getString(paramCursor.getColumnIndex("_tp"));
/* 729 */       ((r)localObject).g = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"));
/* 730 */       return (r)localObject;
/*     */     } catch (Throwable localThrowable) { Object localObject;
/* 732 */       if (!x.a(localObject = localThrowable)) {
/* 733 */         ((Throwable)localObject).printStackTrace();
/*     */       }
/*     */     }
/* 736 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   class a
/*     */     extends Thread
/*     */   {
/*     */     private int a;
/*     */     
/*     */     private o b;
/*     */     
/*     */     private String c;
/*     */     private ContentValues d;
/*     */     private boolean e;
/*     */     private String[] f;
/*     */     private String g;
/*     */     private String[] h;
/*     */     private String i;
/*     */     private String j;
/*     */     private String k;
/*     */     private String l;
/*     */     private String m;
/*     */     private String[] n;
/*     */     private int o;
/*     */     private String p;
/*     */     private byte[] q;
/*     */     
/*     */     public a(int paramInt, o paramo)
/*     */     {
/* 765 */       this.a = paramInt;
/* 766 */       this.b = paramo;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public final void a(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
/*     */     {
/* 777 */       this.e = paramBoolean;
/* 778 */       this.c = paramString1;
/* 779 */       this.f = paramArrayOfString1;
/* 780 */       this.g = paramString2;
/* 781 */       this.h = paramArrayOfString2;
/* 782 */       this.i = paramString3;
/* 783 */       this.j = paramString4;
/* 784 */       this.k = paramString5;
/* 785 */       this.l = paramString6;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public final void a(int paramInt, String paramString, byte[] paramArrayOfByte)
/*     */     {
/* 795 */       this.o = paramInt;
/* 796 */       this.p = paramString;
/* 797 */       this.q = paramArrayOfByte;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public final void run()
/*     */     {
/* 811 */       switch (this.a) {
/*     */       case 1: 
/* 813 */         p.a(p.this, this.c, this.d, this.b);
/* 814 */         return;
/*     */       case 2: 
/* 816 */         p.a(p.this, this.c, this.m, this.n, this.b);
/* 817 */         return;
/*     */       case 3: 
/* 819 */         p.a(p.this, this.e, this.c, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.b);
/*     */         
/* 821 */         return;
/*     */       case 4: 
/* 823 */         p.a(p.this, this.o, this.p, this.q, this.b);
/* 824 */         return;
/*     */       case 5: 
/* 826 */         p.a(p.this, this.o, this.b);
/* 827 */         return;
/*     */       case 6: 
/* 829 */         p.a(p.this, this.o, this.p, this.b);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/p.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */