package com.google.android.finsky.aq;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

final class q
  implements Callable
{
  q(j paramj, List paramList, String paramString) {}
  
  private final List a()
  {
    this.a.a.c.getWritableDatabase().beginTransaction();
    for (;;)
    {
      try
      {
        ArrayList localArrayList = new ArrayList(this.c.size());
        Iterator localIterator = this.c.iterator();
        if (!localIterator.hasNext())
        {
          this.a.a.c.getWritableDatabase().setTransactionSuccessful();
          return localArrayList;
        }
        Object localObject4 = localIterator.next();
        Object localObject1 = new ContentValues();
        Object localObject3 = this.a.c.a(localObject4);
        if (localObject3 == null)
        {
          Object localObject5 = this.a.b;
          if (localObject5 != null) {
            ((ContentValues)localObject1).putAll((ContentValues)((com.google.android.finsky.utils.a.a)localObject5).a(localObject4));
          }
          localObject4 = (byte[])this.a.d.a(localObject4);
          ((ContentValues)localObject1).put("data", (byte[])localObject4);
          long l = this.a.a.c.getWritableDatabase().replaceOrThrow(this.a.e, null, (ContentValues)localObject1);
          localObject5 = this.a;
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = Long.valueOf(l);
          }
          j.a((j)localObject5, localObject1, (byte[])localObject4, "upsert", this.b);
          localArrayList.add(Long.valueOf(l));
        }
        else
        {
          ((ContentValues)localObject2).put("pk", localObject3.toString());
        }
      }
      finally
      {
        this.a.a.c.getWritableDatabase().endTransaction();
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/aq/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */