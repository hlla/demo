package com.google.android.finsky.cb;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import com.google.android.finsky.utils.FinskyLog;
import com.google.f.a.s;

final class e
  extends AsyncTask
{
  e(a parama, com.google.android.finsky.heterodyne.a parama1, String paramString) {}
  
  private final Void a()
  {
    this.c.a(s.h, this.a.d.getPackageName(), this.b);
    try
    {
      this.a.j.a(this.b, new f(this));
      return null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        FinskyLog.a(localException, "Unable to update experiment flags.", new Object[0]);
        a locala = this.a;
        if (locala.t) {
          locala.s.removeCallbacks(locala.c);
        }
        this.a.d();
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cb/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */