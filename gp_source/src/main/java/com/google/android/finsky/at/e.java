package com.google.android.finsky.at;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class e
  extends BroadcastReceiver
{
  e(d paramd) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    this.a.g();
    paramContext = this.a;
    if (paramContext.a)
    {
      paramContext.f();
      return;
    }
    paramContext.d();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/at/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */