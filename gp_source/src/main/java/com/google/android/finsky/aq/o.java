package com.google.android.finsky.aq;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.finsky.utils.FinskyLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

final class o
  implements Callable
{
  o(j paramj, s params, String paramString) {}
  
  private final List a()
  {
    this.a.a.c.getWritableDatabase().beginTransaction();
    for (;;)
    {
      try
      {
        List localList = this.a.b(this.c, null, null);
        boolean bool = localList.isEmpty();
        if (bool) {
          return localList;
        }
        if (this.a.a.c.getWritableDatabase().delete(this.a.e, this.c.a.toString(), this.c.a()) == localList.size())
        {
          Iterator localIterator = localList.iterator();
          if (!localIterator.hasNext())
          {
            this.a.a.c.getWritableDatabase().setTransactionSuccessful();
            return localList;
          }
          Object localObject2 = localIterator.next();
          j localj = this.a;
          j.a(localj, localj.c.a(localObject2), null, "delete", this.b);
          continue;
        }
        FinskyLog.e("Only deleted some records", new Object[0]);
      }
      finally
      {
        this.a.a.c.getWritableDatabase().endTransaction();
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/aq/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */