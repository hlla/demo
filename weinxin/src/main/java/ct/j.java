package ct;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;

final class j
{
  private static j a = null;
  private n b;
  private final BroadcastReceiver c = new k(this);
  private final BroadcastReceiver d = new m(this);
  
  public static j a()
  {
    try
    {
      if (a == null) {
        a = new j();
      }
      j localj = a;
      return localj;
    }
    finally {}
  }
  
  public final void a(NetworkInfo paramNetworkInfo)
  {
    String str;
    if (paramNetworkInfo != null)
    {
      paramNetworkInfo = bc.b;
      bc.b();
      str = bc.b;
      if (!paramNetworkInfo.equals(str))
      {
        if ((!paramNetworkInfo.equals(bc.a)) || (!bc.e())) {
          break label63;
        }
        bd.b();
        if (this.b == null) {
          break label59;
        }
        this.b.b();
      }
    }
    return;
    label59:
    bd.c();
    return;
    label63:
    if ((str.equals(bc.a)) || (!bc.e()))
    {
      bd.b();
      return;
    }
    new StringBuilder("onTrigger：  apn1：").append(paramNetworkInfo).append(" ,apn2：").append(str);
    bd.b();
    if (this.b != null)
    {
      this.b.b();
      return;
    }
    bd.c();
  }
  
  public final void a(n paramn)
  {
    this.b = paramn;
    paramn = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    p.a.registerReceiver(this.c, paramn);
    bd.b();
    bd.b();
    paramn = new IntentFilter("action.scheduler.access.trigger.timer");
    p.a.registerReceiver(this.d, paramn);
    paramn = (AlarmManager)p.a.getSystemService("alarm");
    if (paramn != null)
    {
      long l = System.currentTimeMillis();
      Intent localIntent = new Intent("action.scheduler.access.trigger.timer");
      paramn.setRepeating(3, l + 1200000L, 1200000L, PendingIntent.getBroadcast(p.a, 0, localIntent, 0));
      bd.a();
    }
  }
  
  public final void b()
  {
    if (this.b != null)
    {
      this.b.b();
      return;
    }
    bd.c();
  }
  
  final class a
    implements Runnable
  {
    public a() {}
    
    public final void run()
    {
      try
      {
        j.this.b();
        bd.b();
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  final class b
    implements Runnable
  {
    private Intent a;
    
    b(Intent paramIntent)
    {
      this.a = paramIntent;
    }
    
    public final void run()
    {
      try
      {
        NetworkInfo localNetworkInfo = (NetworkInfo)this.a.getParcelableExtra("networkInfo");
        j.this.a(localNetworkInfo);
        return;
      }
      catch (Throwable localThrowable) {}
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */