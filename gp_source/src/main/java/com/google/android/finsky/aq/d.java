package com.google.android.finsky.aq;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

final class d
  extends SQLiteOpenHelper
{
  d(a parama, Context paramContext, String paramString, int paramInt)
  {
    super(paramContext, paramString, null, paramInt);
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject1 = this.a;
    paramSQLiteDatabase.beginTransaction();
    try
    {
      localObject1 = ((a)localObject1).d;
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        localObject1[i].a(paramSQLiteDatabase);
        i += 1;
      }
      paramSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.beginTransaction();
    try
    {
      paramSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    this.a.a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/aq/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */