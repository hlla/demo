package ct;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;

public final class bt
  extends PhoneStateListener
{
  volatile boolean a;
  private final bk b;
  private CellLocation c = null;
  private SignalStrength d = null;
  private ServiceState e = null;
  private long f;
  private HandlerThread g;
  private Handler h;
  
  public bt(bk parambk)
  {
    this.b = parambk;
  }
  
  private void a(int paramInt)
  {
    TelephonyManager localTelephonyManager = this.b.a();
    try
    {
      localTelephonyManager.listen(this, paramInt);
      return;
    }
    catch (Exception localException)
    {
      b.a.a("TxCellProvider", "listenCellState: failed! flags=" + paramInt, localException);
    }
  }
  
  private boolean a(CellLocation paramCellLocation)
  {
    if (paramCellLocation == null) {
      return false;
    }
    try
    {
      GsmCellLocation localGsmCellLocation = (GsmCellLocation)paramCellLocation;
      if (localGsmCellLocation.getCid() == 0)
      {
        int i = localGsmCellLocation.getLac();
        if (i == 0) {
          return false;
        }
      }
    }
    catch (ClassCastException localClassCastException)
    {
      if (ct.a(paramCellLocation) < 0) {
        return false;
      }
      if (ct.a(this.c, paramCellLocation)) {
        return false;
      }
      paramCellLocation = cg.a(this.b, paramCellLocation, null);
      if (paramCellLocation == null) {}
      for (boolean bool = true; bool; bool = ct.a(paramCellLocation)) {
        return true;
      }
    }
    return false;
  }
  
  private void c()
  {
    if (!this.a) {}
    for (;;)
    {
      return;
      if (this.c != null)
      {
        long l = System.currentTimeMillis();
        if (l - this.f > 2000L) {}
        for (int i = 1; i != 0; i = 0)
        {
          this.f = l;
          cg localcg = cg.a(this.b, this.c, this.d);
          try
          {
            if ((this.h != null) && (localcg != null))
            {
              b localb = new b(this.b);
              localb.a(localcg);
              this.h.post(localb);
            }
            return;
          }
          finally {}
        }
      }
    }
  }
  
  public final void a()
  {
    if (this.a) {
      return;
    }
    this.a = true;
    this.g = new HandlerThread("CellProvider");
    this.g.start();
    this.h = new a(this.g.getLooper(), (byte)0);
    this.h.sendEmptyMessageDelayed(0, 3000L);
    CellLocation localCellLocation = ct.b(this.b);
    if (a(localCellLocation))
    {
      cg localcg = cg.a(this.b, localCellLocation, null);
      if (localcg != null)
      {
        this.c = localCellLocation;
        this.b.c(localcg);
      }
    }
    a(273);
    b.a.a("TxCellProvider", "startup: state=[start]");
  }
  
  public final void b()
  {
    if (!this.a) {
      return;
    }
    this.a = false;
    a(0);
    try
    {
      if (this.h != null)
      {
        this.h.removeCallbacksAndMessages(null);
        this.h = null;
      }
      this.g.quit();
      this.g = null;
      this.c = null;
      this.d = null;
      this.e = null;
      this.f = 0L;
      b.a.a("TxCellProvider", "shutdown: state=[shutdown]");
      return;
    }
    finally {}
  }
  
  public final void onCellLocationChanged(CellLocation paramCellLocation)
  {
    super.onCellLocationChanged(paramCellLocation);
    if (a(paramCellLocation))
    {
      this.c = paramCellLocation;
      c();
      return;
    }
    b.a.b("TxCellProvider", "onCellLocationChanged: illegal cell or same cell " + paramCellLocation);
  }
  
  public final void onServiceStateChanged(ServiceState paramServiceState)
  {
    int j = 1;
    super.onServiceStateChanged(paramServiceState);
    if (paramServiceState == null) {}
    do
    {
      ServiceState localServiceState;
      do
      {
        return;
        localServiceState = this.e;
      } while ((localServiceState != null) && (localServiceState.getState() == paramServiceState.getState()));
      this.e = paramServiceState;
    } while (!this.a);
    int i;
    boolean bool;
    if (this.e != null) {
      if (this.e.getState() == 0)
      {
        i = 1;
        paramServiceState = this.b.a();
        bool = ct.a(this.b.a);
        if (paramServiceState == null) {
          break label171;
        }
        if (paramServiceState.getSimState() != 5) {
          break label166;
        }
      }
    }
    for (;;)
    {
      if ((bool) || (j == 0)) {
        i = 0;
      }
      paramServiceState = new Message();
      paramServiceState.what = 12999;
      paramServiceState.arg1 = 12003;
      paramServiceState.arg2 = i;
      this.b.c(paramServiceState);
      return;
      if (this.e.getState() == 1)
      {
        i = 0;
        break;
      }
      i = -1;
      break;
      label166:
      j = 0;
      continue;
      label171:
      j = 0;
    }
  }
  
  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    super.onSignalStrengthsChanged(paramSignalStrength);
    if (paramSignalStrength == null) {}
    for (;;)
    {
      return;
      try
      {
        SignalStrength localSignalStrength = this.d;
        int i = this.b.g().b;
        if ((localSignalStrength == null) || (ct.a(i, localSignalStrength, paramSignalStrength)))
        {
          this.d = paramSignalStrength;
          c();
          return;
        }
      }
      catch (Exception paramSignalStrength)
      {
        b.a.b("TxCellProvider", paramSignalStrength.toString());
      }
    }
  }
  
  final class a
    extends Handler
  {
    private a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      if (!bt.this.a) {
        return;
      }
      sendEmptyMessageDelayed(0, 20000L);
      paramMessage = ct.b(bt.a(bt.this));
      bt.a(bt.this, paramMessage);
    }
  }
  
  static final class b
    implements Runnable
  {
    private bk a;
    private cg b;
    
    public b(bk parambk)
    {
      this.a = parambk;
    }
    
    public final void a(cg paramcg)
    {
      this.b = paramcg;
    }
    
    public final void run()
    {
      bk localbk = this.a;
      cg localcg = this.b;
      if (localcg != null)
      {
        localcg.a(ct.c(localbk));
        localbk.c(localcg);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */