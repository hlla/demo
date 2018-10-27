package com.google.android.finsky.bk;

import com.google.android.finsky.utils.FinskyLog;
import java.util.Map;

final class b
  implements Runnable
{
  b(a parama, String paramString) {}
  
  public final void run()
  {
    FinskyLog.a("Request cache cleared.", new Object[0]);
    synchronized (this.a)
    {
      this.a.a.put(this.b, Boolean.valueOf(true));
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bk/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */