/*    */ package com.tencent.bugly;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.database.sqlite.SQLiteDatabase;
/*    */ import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
/*    */ import com.tencent.bugly.proguard.x;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class a
/*    */ {
/*    */   public int id;
/*    */   public String moduleName;
/*    */   public String versionKey;
/*    */   public String version;
/*    */   
/*    */   public abstract void init(Context paramContext, boolean paramBoolean, BuglyStrategy paramBuglyStrategy);
/*    */   
/*    */   public void onDbCreate(SQLiteDatabase paramSQLiteDatabase) {}
/*    */   
/*    */   public void onDbUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
/*    */   {
/*    */     try
/*    */     {
/* 46 */       if (getTables() == null) {
/* 47 */         return;
/*    */       }
/* 49 */       paramInt2 = (paramInt1 = getTables()).length; for (int i = 0; i < paramInt2; i++) { String str = paramInt1[i];
/* 50 */         paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
/*    */       }
/* 52 */       onDbCreate(paramSQLiteDatabase); return;
/*    */     } catch (Throwable localThrowable) {
/* 54 */       if (!x.b(paramInt1 = 
/*    */       
/*    */ 
/* 57 */         localThrowable)) {
/* 55 */         paramInt1.printStackTrace();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onDbDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
/*    */   {
/*    */     try
/*    */     {
/* 68 */       if (getTables() == null) {
/* 69 */         return;
/*    */       }
/* 71 */       paramInt2 = (paramInt1 = getTables()).length; for (int i = 0; i < paramInt2; i++) { String str = paramInt1[i];
/* 72 */         paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
/*    */       }
/* 74 */       onDbCreate(paramSQLiteDatabase); return;
/*    */     } catch (Throwable localThrowable) {
/* 76 */       if (!x.b(paramInt1 = 
/*    */       
/*    */ 
/* 79 */         localThrowable)) {
/* 77 */         paramInt1.printStackTrace();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public abstract String[] getTables();
/*    */   
/*    */   public void onServerStrategyChanged(StrategyBean paramStrategyBean) {}
/*    */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/a.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */