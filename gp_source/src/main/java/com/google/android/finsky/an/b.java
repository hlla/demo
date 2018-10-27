package com.google.android.finsky.an;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class b
  extends BroadcastReceiver
{
  b(a parama) {}
  
  public final void onReceive(Context arg1, Intent paramIntent)
  {
    synchronized (this.a)
    {
      this.a.a = null;
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/an/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */