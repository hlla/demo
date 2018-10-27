package com.google.android.finsky.dg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.finsky.dh.a;
import com.google.android.finsky.utils.FinskyLog;

final class k
  extends BroadcastReceiver
{
  k(f paramf, String paramString, int paramInt, e parame) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    this.a.b.unregisterReceiver(this);
    paramContext = this.a;
    String str1 = this.c;
    int i = this.d;
    e locale = this.b;
    String str2 = paramIntent.getStringExtra("android.content.pm.extra.STATUS_MESSAGE");
    int j = paramIntent.getIntExtra("android.content.pm.extra.STATUS", Integer.MIN_VALUE);
    if (j == 0)
    {
      paramContext.g.d(str1);
      paramContext.a(str1, i);
      paramContext.a(new m(locale));
      return;
    }
    if (j == -1)
    {
      paramContext.a(str1, i);
      paramContext.a(new n(locale));
      return;
    }
    paramContext.a(str1, i);
    if (j != Integer.MIN_VALUE) {}
    for (i = 65036 - j;; i = 977)
    {
      FinskyLog.d("Error %d while installing %s: %s", new Object[] { Integer.valueOf(i), str1, str2 });
      paramContext.a(new o(locale, i));
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dg/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */