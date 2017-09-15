package com.tencent.mm.network;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class ab
  extends h.a
{
  private ai hqz;
  private int ifk;
  private long ifl;
  private int ifm;
  private final RemoteCallbackList<m> ifn;
  
  public ab()
  {
    GMTrace.i(13705374859264L, 102113);
    this.ifk = 4;
    this.ifm = 0;
    this.ifn = new RemoteCallbackList();
    this.hqz = new ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(13702153633792L, 102089);
        int i = ab.b(ab.this).beginBroadcast();
        v.i("MicroMsg.NetworkEvent", "listeners ct : %d", new Object[] { Integer.valueOf(i) });
        i -= 1;
        for (;;)
        {
          if (i >= 0)
          {
            m localm = (m)ab.b(ab.this).getBroadcastItem(i);
            try
            {
              localm.cU(ab.c(ab.this));
              i -= 1;
            }
            catch (RemoteException localRemoteException)
            {
              for (;;)
              {
                v.e("MicroMsg.NetworkEvent", "exception:%s", new Object[] { bf.g(localRemoteException) });
              }
            }
          }
        }
        ab.b(ab.this).finishBroadcast();
        GMTrace.o(13702153633792L, 102089);
        return false;
      }
    }, false);
    GMTrace.o(13705374859264L, 102113);
  }
  
  public final int Mt()
  {
    GMTrace.i(13705509076992L, 102114);
    if (0L > bf.az(this.ifl)) {}
    for (int i = 5;; i = this.ifk)
    {
      v.i("MicroMsg.NetworkEvent", "getNowStatus = %d", new Object[] { Integer.valueOf(i) });
      GMTrace.o(13705509076992L, 102114);
      return i;
    }
  }
  
  public final void Mu()
  {
    GMTrace.i(13705911730176L, 102117);
    this.ifn.kill();
    GMTrace.o(13705911730176L, 102117);
  }
  
  public final long Mv()
  {
    GMTrace.i(13706180165632L, 102119);
    long l = this.ifl;
    GMTrace.o(13706180165632L, 102119);
    return l;
  }
  
  public final boolean c(m paramm)
  {
    GMTrace.i(13705643294720L, 102115);
    try
    {
      this.ifn.register(paramm);
      GMTrace.o(13705643294720L, 102115);
      return true;
    }
    catch (Exception paramm)
    {
      for (;;)
      {
        v.e("MicroMsg.NetworkEvent", "addListener %s", new Object[] { paramm });
        v.e("MicroMsg.NetworkEvent", "exception:%s", new Object[] { bf.g(paramm) });
      }
    }
  }
  
  public final boolean d(m paramm)
  {
    boolean bool1 = false;
    GMTrace.i(13705777512448L, 102116);
    try
    {
      boolean bool2 = this.ifn.unregister(paramm);
      bool1 = bool2;
    }
    catch (Exception paramm)
    {
      for (;;)
      {
        v.e("MicroMsg.NetworkEvent", "removeListener %s", new Object[] { paramm });
        v.e("MicroMsg.NetworkEvent", "exception:%s", new Object[] { bf.g(paramm) });
      }
    }
    GMTrace.o(13705777512448L, 102116);
    return bool1;
  }
  
  public final void gX(int paramInt)
  {
    int j = 0;
    GMTrace.i(13706045947904L, 102118);
    v.i("MicroMsg.NetworkEvent", "networkChange : %d", new Object[] { Integer.valueOf(paramInt) });
    int i;
    if (paramInt == this.ifk) {
      i = j;
    }
    while (i == 0)
    {
      GMTrace.o(13706045947904L, 102118);
      return;
      if (3 == paramInt)
      {
        i = j;
        if (this.ifk == 2)
        {
          this.ifk = paramInt;
          i = 1;
        }
      }
      else
      {
        if (2 == paramInt)
        {
          i = j;
          if (this.ifk == 0) {
            continue;
          }
          i = j;
          if (this.ifk == 1) {
            continue;
          }
          this.ifm += 1;
          if (this.ifm > 0)
          {
            this.ifk = 2;
            i = 1;
          }
        }
        else if (4 == paramInt)
        {
          this.ifm = 0;
          this.ifk = 4;
          i = 1;
          continue;
        }
        this.ifk = paramInt;
        i = 1;
      }
    }
    if ((paramInt != 0) && (paramInt != 6))
    {
      GMTrace.o(13706045947904L, 102118);
      return;
    }
    this.hqz.v(1000L, 1000L);
    GMTrace.o(13706045947904L, 102118);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/network/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */