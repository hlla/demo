package com.tencent.mm.sdk.e;

import android.content.ContentValues;
import android.database.Cursor;

public abstract interface e
{
  public abstract Cursor a(String paramString, String[] paramArrayOfString, int paramInt);
  
  public abstract Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, int paramInt);
  
  public abstract boolean bKd();
  
  public abstract int delete(String paramString1, String paramString2, String[] paramArrayOfString);
  
  public abstract boolean eE(String paramString1, String paramString2);
  
  public abstract long insert(String paramString1, String paramString2, ContentValues paramContentValues);
  
  public abstract Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5);
  
  public abstract Cursor rawQuery(String paramString, String[] paramArrayOfString);
  
  public abstract long replace(String paramString1, String paramString2, ContentValues paramContentValues);
  
  public abstract int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString);
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/e/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */