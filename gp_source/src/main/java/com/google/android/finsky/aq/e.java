package com.google.android.finsky.aq;

import android.database.sqlite.SQLiteDatabase;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class e
{
  public final Map a;
  public final String b;
  private final String c;
  
  public e(String paramString1, String paramString2, Map paramMap)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.a = paramMap;
    paramString1 = this.a.entrySet().iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (Entry)paramString1.next();
      if (("pk".equals(paramString2.getKey())) || ("data".equals(paramString2.getKey()))) {
        throw new IllegalArgumentException("Column names cannot contain 'pk' or 'data'");
      }
    }
  }
  
  final void a(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("pk", String.valueOf(this.c).concat(" PRIMARY KEY"));
    ((Map)localObject).put("data", "BLOB");
    ((Map)localObject).putAll(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" (");
    localObject = ((Map)localObject).entrySet().iterator();
    for (int i = 0; ((Iterator)localObject).hasNext(); i = 1)
    {
      Entry localEntry = (Entry)((Iterator)localObject).next();
      if (i != 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append(" ");
      localStringBuilder.append((String)localEntry.getValue());
    }
    localStringBuilder.append(")");
    paramSQLiteDatabase.execSQL(localStringBuilder.toString());
    paramSQLiteDatabase.execSQL(String.format(Locale.US, "CREATE TABLE %s_audit(data_table_pk %s,data BLOB,timestamp INTEGER,reason TEXT,trace TEXT)", new Object[] { this.b, this.c }));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/aq/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */