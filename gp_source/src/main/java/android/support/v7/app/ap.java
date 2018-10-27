package android.support.v7.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class ap
  extends BroadcastReceiver
{
  ap(ao paramao) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = this.a;
    boolean bool = paramContext.d.a();
    if (bool != paramContext.c)
    {
      paramContext.c = bool;
      paramContext.e.l();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */