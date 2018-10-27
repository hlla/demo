package android.support.v7.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;

final class ao
{
  public BroadcastReceiver a;
  public IntentFilter b;
  public boolean c;
  public be d;
  
  ao(aa paramaa, be parambe)
  {
    this.d = parambe;
    this.c = parambe.a();
  }
  
  final void a()
  {
    BroadcastReceiver localBroadcastReceiver = this.a;
    if (localBroadcastReceiver != null)
    {
      this.e.f.unregisterReceiver(localBroadcastReceiver);
      this.a = null;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */