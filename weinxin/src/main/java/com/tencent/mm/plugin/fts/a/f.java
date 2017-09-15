package com.tencent.mm.plugin.fts.a;

import android.database.Cursor;
import com.tencent.wcdb.database.SQLiteStatement;
import com.tencent.wcdb.support.CancellationSignal;

public abstract interface f
{
  public abstract Cursor a(String paramString, String[] paramArrayOfString, CancellationSignal paramCancellationSignal);
  
  public abstract void beginTransaction();
  
  public abstract boolean cb(int paramInt1, int paramInt2);
  
  public abstract void commit();
  
  public abstract SQLiteStatement compileStatement(String paramString);
  
  public abstract void execSQL(String paramString);
  
  public abstract void execSQL(String paramString, Object[] paramArrayOfObject);
  
  public abstract long h(long paramLong1, long paramLong2);
  
  public abstract void i(long paramLong1, long paramLong2);
  
  public abstract boolean inTransaction();
  
  public abstract Cursor rawQuery(String paramString, String[] paramArrayOfString);
  
  public abstract boolean wP(String paramString);
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/fts/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */