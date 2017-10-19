/*     */ package com.tencent.bugly.proguard;
/*     */ 
/*     */ import android.annotation.TargetApi;
/*     */ import android.content.Context;
/*     */ import android.database.sqlite.SQLiteDatabase;
/*     */ import android.database.sqlite.SQLiteOpenHelper;
/*     */ import com.tencent.bugly.a;
/*     */ import com.tencent.bugly.crashreport.common.info.b;
/*     */ import java.io.File;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class q
/*     */   extends SQLiteOpenHelper
/*     */ {
/*  52 */   public static String a = "bugly_db";
/*  53 */   private static int b = 13;
/*     */   
/*     */ 
/*     */ 
/*     */   private Context c;
/*     */   
/*     */ 
/*     */ 
/*     */   private List<a> d;
/*     */   
/*     */ 
/*     */ 
/*     */   public q(Context paramContext, List<a> paramList)
/*     */   {
/*  67 */     super(paramContext, a + "_", null, b);
/*     */     
/*  69 */     this.c = paramContext;
/*  70 */     this.d = paramList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final synchronized void onCreate(SQLiteDatabase paramSQLiteDatabase)
/*     */   {
/*     */     try
/*     */     {
/*  81 */       (localObject1 = new StringBuilder()).setLength(0);
/*  82 */       ((StringBuilder)localObject1).append(" CREATE TABLE IF NOT EXISTS t_ui").append(" ( _id").append(" INTEGER PRIMARY KEY").append(" , _tm").append(" int").append(" , _ut").append(" int").append(" , _tp").append(" int").append(" , _dt").append(" blob").append(" , _pc").append(" text").append(" ) ");
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  88 */       x.c(((StringBuilder)localObject1).toString(), new Object[0]);
/*  89 */       paramSQLiteDatabase.execSQL(((StringBuilder)localObject1).toString(), new String[0]);
/*     */       
/*     */ 
/*  92 */       ((StringBuilder)localObject1).setLength(0);
/*  93 */       ((StringBuilder)localObject1).append(" CREATE TABLE IF NOT EXISTS t_lr").append(" ( _id").append(" INTEGER PRIMARY KEY").append(" , _tp").append(" int").append(" , _tm").append(" int").append(" , _pc").append(" text").append(" , _th").append(" text").append(" , _dt").append(" blob").append(" ) ");
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  99 */       x.c(((StringBuilder)localObject1).toString(), new Object[0]);
/* 100 */       paramSQLiteDatabase.execSQL(((StringBuilder)localObject1).toString(), new String[0]);
/*     */       
/*     */ 
/* 103 */       ((StringBuilder)localObject1).setLength(0);
/* 104 */       ((StringBuilder)localObject1).append(" CREATE TABLE IF NOT EXISTS t_pf").append(" ( _id").append(" integer").append(" , _tp").append(" text").append(" , _tm").append(" int").append(" , _dt").append(" blob").append(",primary key(_id").append(",_tp").append(" )) ");
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 109 */       x.c(((StringBuilder)localObject1).toString(), new Object[0]);
/* 110 */       paramSQLiteDatabase.execSQL(((StringBuilder)localObject1).toString(), new String[0]);
/*     */       
/*     */ 
/* 113 */       ((StringBuilder)localObject1).setLength(0);
/* 114 */       ((StringBuilder)localObject1).append(" CREATE TABLE IF NOT EXISTS t_cr").append(" ( _id").append(" INTEGER PRIMARY KEY").append(" , _tm").append(" int").append(" , _s1").append(" text").append(" , _up").append(" int").append(" , _me").append(" int").append(" , _uc").append(" int").append(" , _dt").append(" blob").append(" ) ");
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 121 */       x.c(((StringBuilder)localObject1).toString(), new Object[0]);
/* 122 */       paramSQLiteDatabase.execSQL(((StringBuilder)localObject1).toString(), new String[0]);
/*     */       
/*     */ 
/*     */ 
/* 126 */       ((StringBuilder)localObject1).setLength(0);
/* 127 */       ((StringBuilder)localObject1).append(" CREATE TABLE IF NOT EXISTS dl_1002").append(" (_id").append(" integer primary key autoincrement, _dUrl").append(" varchar(100), _sFile").append(" varchar(100), _sLen").append(" INTEGER, _tLen").append(" INTEGER, _MD5").append(" varchar(100), _DLTIME").append(" INTEGER)");
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 132 */       x.c(((StringBuilder)localObject1).toString(), new Object[0]);
/* 133 */       paramSQLiteDatabase.execSQL(((StringBuilder)localObject1).toString(), new String[0]);
/*     */       
/*     */ 
/* 136 */       ((StringBuilder)localObject1).setLength(0);
/* 137 */       ((StringBuilder)localObject1).append("CREATE TABLE IF NOT EXISTS ge_1002").append(" (_id").append(" integer primary key autoincrement, _time").append(" INTEGER, _datas").append(" blob)");
/*     */       
/*     */ 
/* 140 */       x.c(((StringBuilder)localObject1).toString(), new Object[0]);
/* 141 */       paramSQLiteDatabase.execSQL(((StringBuilder)localObject1).toString(), new String[0]);
/*     */       
/*     */ 
/* 144 */       ((StringBuilder)localObject1).setLength(0);
/* 145 */       ((StringBuilder)localObject1).append(" CREATE TABLE IF NOT EXISTS st_1002").append(" ( _id").append(" integer").append(" , _tp").append(" text").append(" , _tm").append(" int").append(" , _dt").append(" blob").append(",primary key(_id").append(",_tp").append(" )) ");
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 150 */       x.c(((StringBuilder)localObject1).toString(), new Object[0]);
/* 151 */       paramSQLiteDatabase.execSQL(((StringBuilder)localObject1).toString(), new String[0]);
/*     */     }
/*     */     catch (Throwable localThrowable1) {
/* 154 */       if (!x.b(localObject1 = 
/*     */       
/*     */ 
/* 157 */         localThrowable1)) {
/* 155 */         ((Throwable)localObject1).printStackTrace();
/*     */       }
/*     */     }
/*     */     
/* 159 */     if (this.d == null) {
/* 160 */       return;
/*     */     }
/* 162 */     for (Object localObject1 = this.d.iterator(); ((Iterator)localObject1).hasNext();) { Object localObject2 = (a)((Iterator)localObject1).next();
/*     */       try {
/* 164 */         ((a)localObject2).onDbCreate(paramSQLiteDatabase);
/*     */       } catch (Throwable localThrowable2) {
/* 166 */         if (!x.b(localObject2 = 
/*     */         
/*     */ 
/* 169 */           localThrowable2)) {
/* 167 */           ((Throwable)localObject2).printStackTrace();
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
/*     */ 
/*     */   private synchronized boolean a(SQLiteDatabase paramSQLiteDatabase)
/*     */   {
/*     */     try
/*     */     {
/* 184 */       int i = (localObject = localObject = new String[] { "t_lr", "t_ui", "t_pf" }).length; for (int j = 0; j < i; j++) { String str = localObject[j];
/* 185 */         paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str, new String[0]);
/*     */       }
/* 187 */       return true;
/*     */     } catch (Throwable localThrowable) { Object localObject;
/* 189 */       if (!x.b(localObject = localThrowable))
/* 190 */         ((Throwable)localObject).printStackTrace();
/*     */     }
/* 192 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public final synchronized void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
/*     */   {
/* 198 */     x.d("[Database] Upgrade %d to %d , drop tables!", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
/* 199 */     Object localObject1; if (this.d != null) {
/* 200 */       for (localObject1 = this.d.iterator(); ((Iterator)localObject1).hasNext();) { Object localObject2 = (a)((Iterator)localObject1).next();
/*     */         try {
/* 202 */           ((a)localObject2).onDbUpgrade(paramSQLiteDatabase, paramInt1, paramInt2);
/*     */         } catch (Throwable localThrowable) {
/* 204 */           if (!x.b(localObject2 = 
/*     */           
/*     */ 
/* 207 */             localThrowable)) {
/* 205 */             ((Throwable)localObject2).printStackTrace();
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 210 */     if (a(paramSQLiteDatabase)) {
/* 211 */       onCreate(paramSQLiteDatabase);return;
/*     */     }
/* 213 */     x.d("[Database] Failed to drop, delete db.", new Object[0]);
/*     */     
/* 215 */     if (((localObject1 = this.c.getDatabasePath(a)) != null) && (((File)localObject1).canWrite())) {
/* 216 */       ((File)localObject1).delete();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   @TargetApi(11)
/*     */   public final synchronized void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
/*     */   {
/* 224 */     if (b.c() >= 11) {
/* 225 */       x.d("[Database] Downgrade %d to %d drop tables.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
/* 226 */       Object localObject1; if (this.d != null) {
/* 227 */         for (localObject1 = this.d.iterator(); ((Iterator)localObject1).hasNext();) { Object localObject2 = (a)((Iterator)localObject1).next();
/*     */           try {
/* 229 */             ((a)localObject2).onDbDowngrade(paramSQLiteDatabase, paramInt1, paramInt2);
/*     */           } catch (Throwable localThrowable) {
/* 231 */             if (!x.b(localObject2 = 
/*     */             
/*     */ 
/* 234 */               localThrowable)) {
/* 232 */               ((Throwable)localObject2).printStackTrace();
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/* 237 */       if (a(paramSQLiteDatabase)) {
/* 238 */         onCreate(paramSQLiteDatabase);return;
/*     */       }
/* 240 */       x.d("[Database] Failed to drop, delete db.", new Object[0]);
/*     */       
/* 242 */       if (((localObject1 = this.c.getDatabasePath(a)) != null) && (((File)localObject1).canWrite())) {
/* 243 */         ((File)localObject1).delete();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public final synchronized SQLiteDatabase getReadableDatabase()
/*     */   {
/* 251 */     SQLiteDatabase localSQLiteDatabase = null;
/* 252 */     int i = 0;
/* 253 */     while ((localSQLiteDatabase == null) && (i < 5)) {
/* 254 */       i++;
/*     */       try {
/* 256 */         localSQLiteDatabase = super.getReadableDatabase();
/*     */       } catch (Throwable localThrowable) {
/* 258 */         x.d("[Database] Try to get db(count: %d).", new Object[] { Integer.valueOf(i) });
/* 259 */         if (i == 5) {
/* 260 */           x.e("[Database] Failed to get db.", new Object[0]);
/*     */         }
/*     */         try {
/* 263 */           Thread.sleep(200L);
/*     */         } catch (InterruptedException localInterruptedException2) { InterruptedException localInterruptedException1;
/* 265 */           (localInterruptedException1 = 
/* 266 */             localInterruptedException2).printStackTrace();
/*     */         }
/*     */       }
/*     */     }
/* 269 */     return localSQLiteDatabase;
/*     */   }
/*     */   
/*     */   public final synchronized SQLiteDatabase getWritableDatabase()
/*     */   {
/* 274 */     SQLiteDatabase localSQLiteDatabase = null;
/* 275 */     int i = 0;
/* 276 */     while ((localSQLiteDatabase == null) && (i < 5)) {
/* 277 */       i++;
/*     */       try
/*     */       {
/* 280 */         localSQLiteDatabase = super.getWritableDatabase();
/*     */       } catch (Throwable localThrowable) {
/* 282 */         x.d("[Database] Try to get db(count: %d).", new Object[] { Integer.valueOf(i) });
/* 283 */         if (i == 5) {
/* 284 */           x.e("[Database] Failed to get db.", new Object[0]);
/*     */         }
/*     */         try
/*     */         {
/* 288 */           Thread.sleep(200L);
/*     */         } catch (InterruptedException localInterruptedException2) { InterruptedException localInterruptedException1;
/* 290 */           (localInterruptedException1 = 
/* 291 */             localInterruptedException2).printStackTrace();
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 295 */     if (localSQLiteDatabase == null) {
/* 296 */       x.d("[Database] db error delay error record 1min.", new Object[0]);
/*     */     }
/* 298 */     return localSQLiteDatabase;
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/q.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */