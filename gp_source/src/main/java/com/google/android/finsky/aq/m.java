package com.google.android.finsky.aq;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.finsky.utils.FinskyLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

final class m
  implements Callable
{
  m(j paramj, s params, String paramString) {}
  
  private final Integer a()
  {
    this.a.a.c.getWritableDatabase().beginTransaction();
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = this.a.d(this.c);
        if (((List)localObject1).isEmpty()) {
          break;
        }
        i = this.a.a.c.getWritableDatabase().delete(this.a.e, this.c.a.toString(), this.c.a());
        if (i == ((List)localObject1).size())
        {
          localObject1 = ((List)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext())
          {
            this.a.a.c.getWritableDatabase().setTransactionSuccessful();
            return Integer.valueOf(i);
          }
          Object localObject3 = ((Iterator)localObject1).next();
          j.a(this.a, localObject3, null, "delete", this.b);
          continue;
        }
      }
      finally
      {
        this.a.a.c.getWritableDatabase().endTransaction();
      }
      tmp191_188[0] = Integer.valueOf(i);
      Object[] tmp198_191 = tmp191_188;
      tmp198_191[1] = Integer.valueOf(((List)localObject2).size());
      Object[] tmp210_198 = tmp198_191;
      tmp210_198[2] = this.a.e;
      FinskyLog.e("Only deleted some records. %d out of %d in %s", tmp210_198);
    }
    this.a.a.c.getWritableDatabase().endTransaction();
    return Integer.valueOf(0);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/aq/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */