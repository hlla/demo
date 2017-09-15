package ct;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class m
  extends BroadcastReceiver
{
  m(j paramj) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    new StringBuilder("onAccessSchedulerTriggered by timer, curTime:").append(System.currentTimeMillis());
    bd.a();
    o.a().a(new j.a(this.a));
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */