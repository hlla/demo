package com.google.android.finsky.aq;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.finsky.af.e;
import com.google.android.finsky.utils.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

final class j
  implements f
{
  public final a a;
  public final com.google.android.finsky.utils.a.a b;
  public final com.google.android.finsky.utils.a.a c;
  public final com.google.android.finsky.utils.a.a d;
  public final String e;
  private final int f;
  private final com.google.android.finsky.utils.a.a g;
  private final com.google.android.finsky.bo.c h;
  private final long i;
  private final com.google.android.finsky.af.c j;
  
  j(com.google.android.finsky.bo.c paramc, com.google.android.finsky.af.c paramc1, a parama, String paramString, com.google.android.finsky.utils.a.a parama1, com.google.android.finsky.utils.a.a parama2, com.google.android.finsky.utils.a.a parama3, int paramInt, long paramLong, com.google.android.finsky.utils.a.a parama4)
  {
    this.h = paramc;
    this.j = paramc1;
    this.a = parama;
    this.e = paramString;
    this.d = parama1;
    this.g = parama2;
    this.c = parama3;
    this.f = paramInt;
    this.i = paramLong;
    this.b = parama4;
  }
  
  private final void a(Object paramObject, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    Object localObject1 = this.h;
    if ((localObject1 != null) && (((com.google.android.finsky.bo.c)localObject1).cY().a(12632999L))) {}
    try
    {
      localSQLiteDatabase = this.a.c.getReadableDatabase();
      localObject1 = String.valueOf(this.e);
      localObject2 = String.valueOf("_audit");
      if (((String)localObject2).length() == 0)
      {
        localObject1 = new String((String)localObject1);
        localObject1 = localSQLiteDatabase.query((String)localObject1, null, null, null, null, null, null, null);
        if (localObject1 == null) {}
      }
    }
    finally
    {
      try
      {
        for (;;)
        {
          SQLiteDatabase localSQLiteDatabase;
          Object localObject2;
          long l = ((Cursor)localObject1).getCount();
          if (l >= this.i)
          {
            localSQLiteDatabase = this.a.c.getWritableDatabase();
            localObject2 = Locale.US;
            String str = this.e;
            localSQLiteDatabase.execSQL(String.format((Locale)localObject2, "DELETE FROM %s_audit WHERE rowid in (SELECT rowid FROM %s_audit ORDER BY %s LIMIT %d)", new Object[] { str, str, "timestamp", Long.valueOf(l - this.i + 1L) }));
          }
          com.google.android.finsky.utils.m.a((Cursor)localObject1);
          for (;;)
          {
            localObject1 = new ContentValues(5);
            ((ContentValues)localObject1).put("data_table_pk", String.valueOf(paramObject));
            ((ContentValues)localObject1).put("data", paramArrayOfByte);
            ((ContentValues)localObject1).put("timestamp", Long.valueOf(i.a()));
            ((ContentValues)localObject1).put("reason", paramString1);
            ((ContentValues)localObject1).put("trace", paramString2);
            paramArrayOfByte = this.a.c.getWritableDatabase();
            paramObject = String.valueOf(this.e);
            paramString1 = String.valueOf("_audit");
            if (paramString1.length() == 0) {}
            for (paramObject = new String((String)paramObject);; paramObject = ((String)paramObject).concat(paramString1))
            {
              paramArrayOfByte.insertOrThrow((String)paramObject, null, (ContentValues)localObject1);
              return;
            }
            com.google.android.finsky.utils.m.a((Cursor)localObject1);
          }
          localObject1 = ((String)localObject1).concat((String)localObject2);
        }
      }
      finally {}
      paramObject = finally;
      localObject1 = null;
    }
    com.google.android.finsky.utils.m.a((Cursor)localObject1);
    throw ((Throwable)paramObject);
  }
  
  public final e a(s params)
  {
    return a(params, null, null);
  }
  
  public final e a(s params, String paramString1, String paramString2)
  {
    return this.j.a(new k(this, params, paramString1, paramString2));
  }
  
  public final e a(Object paramObject)
  {
    return a(new s(paramObject), null, null).a(new l(paramObject));
  }
  
  public final e a(List paramList)
  {
    String str = r.a(this.f);
    return this.j.a(new q(this, paramList, str));
  }
  
  public final e b(s params)
  {
    String str = r.a(this.f);
    return this.j.a(new m(this, params, str));
  }
  
  public final e b(Object paramObject)
  {
    return a(Collections.singletonList(paramObject)).a(new p());
  }
  
  final List b(s params, String paramString1, String paramString2)
  {
    SQLiteDatabase localSQLiteDatabase = this.a.c.getReadableDatabase();
    String str1 = this.e;
    String str2 = params.a.toString();
    params = params.a();
    params = localSQLiteDatabase.query(str1, new String[] { "data" }, str2, params, null, null, paramString1, paramString2);
    paramString1 = new ArrayList(params.getCount());
    try
    {
      int k = params.getColumnIndex("data");
      while (params.moveToNext())
      {
        paramString2 = params.getBlob(k);
        paramString1.add(this.g.a(paramString2));
      }
    }
    finally
    {
      params.close();
    }
    return paramString1;
  }
  
  public final e c(s params)
  {
    String str = r.a(this.f);
    return this.j.a(new o(this, params, str));
  }
  
  public final e c(Object paramObject)
  {
    return d(this.c.a(paramObject));
  }
  
  public final e d(Object paramObject)
  {
    return b(new s(paramObject)).a(new n());
  }
  
  final List d(s params)
  {
    Object localObject = this.a.c.getReadableDatabase();
    String str1 = this.e;
    String str2 = params.a.toString();
    params = params.a();
    params = ((SQLiteDatabase)localObject).query(str1, new String[] { "pk" }, str2, params, null, null, null);
    localObject = new ArrayList();
    try
    {
      int k = params.getColumnIndex("pk");
      while (params.moveToNext()) {
        ((List)localObject).add(params.getString(k));
      }
    }
    finally
    {
      params.close();
    }
    return localList;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/aq/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */