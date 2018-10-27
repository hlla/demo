package com.google.android.finsky.at;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.finsky.e.af;
import com.google.android.finsky.e.ag;

final class f
  extends BroadcastReceiver
{
  f(d paramd) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    d locald = this.a;
    paramIntent = locald.b;
    paramContext = paramIntent;
    if (paramIntent == null) {
      paramContext = locald.c.cW();
    }
    paramContext.a(new com.google.android.finsky.e.f(this.a.d));
    this.a.c();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/at/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */