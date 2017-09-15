package ct;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ca
  extends BroadcastReceiver
{
  private final bk a;
  private boolean b;
  private ExecutorService c;
  private a d;
  
  public ca(bk parambk)
  {
    this.a = parambk;
  }
  
  public final void a()
  {
    if (this.b) {
      return;
    }
    this.b = true;
    IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    try
    {
      this.c = Executors.newFixedThreadPool(1);
      this.d = new a(this.a.a);
      this.a.a.registerReceiver(this, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      b.a.a("TxNetworkStateMonitor", "listenNetworkState: failed", localException);
    }
  }
  
  public final void b()
  {
    if (!this.b) {
      return;
    }
    this.b = false;
    try
    {
      this.a.a.unregisterReceiver(this);
      this.c.shutdown();
      return;
    }
    catch (Exception localException) {}
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    try
    {
      this.d.a(paramIntent);
      this.c.execute(this.d);
      return;
    }
    catch (Exception paramContext)
    {
      b.a.a("TxNetworkStateMonitor", "listenNetworkState: Exception", paramContext);
    }
  }
  
  final class a
    implements Runnable
  {
    private Context a;
    private Intent b;
    
    public a(Context paramContext)
    {
      this.a = paramContext;
    }
    
    public final void a(Intent paramIntent)
    {
      this.b = paramIntent;
    }
    
    public final void run()
    {
      boolean bool = this.b.getBooleanExtra("noConnectivity", false);
      b.a.b("TxNetworkStateMonitor", "listenNetworkState: call is running");
      if (bool)
      {
        ca.a(ca.this).c(Integer.valueOf(-1));
        return;
      }
      if (b.a.b(this.a))
      {
        ca.a(ca.this).c(Integer.valueOf(1));
        return;
      }
      ca.a(ca.this).c(Integer.valueOf(0));
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */