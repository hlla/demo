package com.google.android.finsky.a;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import com.google.android.finsky.navigationmanager.d;
import com.google.android.finsky.utils.FinskyLog;

final class e
  implements d
{
  e(a parama) {}
  
  public final void a() {}
  
  public final void b()
  {
    a locala = this.a;
    if (locala.k == 3) {}
    try
    {
      locala.i.a.send();
      this.a.a(4054);
      this.a.b();
      return;
    }
    catch (CanceledException localCanceledException)
    {
      for (;;)
      {
        FinskyLog.a(localCanceledException, "Account mismatch corrected intent canceled", new Object[0]);
      }
    }
  }
  
  public final void c() {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */