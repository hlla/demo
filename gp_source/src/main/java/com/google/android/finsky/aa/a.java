package com.google.android.finsky.aa;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public abstract class a
  extends BroadcastReceiver
{
  private boolean a;
  
  public abstract void a();
  
  public abstract void a(Context paramContext, Intent paramIntent);
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!this.a)
    {
      this.a = true;
      a();
    }
    a(paramContext, paramIntent);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/aa/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */