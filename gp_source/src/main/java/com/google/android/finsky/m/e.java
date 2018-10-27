package com.google.android.finsky.m;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.finsky.e.af;
import java.util.Map;

final class e
  extends AsyncTask
{
  private final Context a;
  private final af b;
  
  e(c paramc, Context paramContext, af paramaf)
  {
    this.a = paramContext;
    this.b = paramaf;
  }
  
  private final Map a()
  {
    synchronized (this.c.a)
    {
      Map localMap = f.a(this.a, this.b);
      return localMap;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/m/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */