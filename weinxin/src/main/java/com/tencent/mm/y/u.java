package com.tencent.mm.y;

import android.os.HandlerThread;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class u
{
  public static b htz;
  
  static
  {
    GMTrace.i(13398150479872L, 99824);
    htz = null;
    GMTrace.o(13398150479872L, 99824);
  }
  
  public static boolean Cx()
  {
    GMTrace.i(13397479391232L, 99819);
    if (htz == null)
    {
      v.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
      GMTrace.o(13397479391232L, 99819);
      return false;
    }
    if (htz.ve() == null)
    {
      v.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
      GMTrace.o(13397479391232L, 99819);
      return false;
    }
    GMTrace.o(13397479391232L, 99819);
    return true;
  }
  
  public static int a(boolean paramBoolean, a parama, final int paramInt1, final int paramInt2, final String paramString, final b paramb, final k paramk)
  {
    GMTrace.i(16089215926272L, 119874);
    if (parama == null)
    {
      GMTrace.o(16089215926272L, 119874);
      return 0;
    }
    if (paramBoolean) {
      htz.ve().hsJ.D(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(13403921842176L, 99867);
          this.htG.a(paramInt1, paramInt2, paramString, paramb, paramk);
          GMTrace.o(13403921842176L, 99867);
        }
        
        public final String toString()
        {
          GMTrace.i(13404056059904L, 99868);
          String str = super.toString() + "|tryCallback";
          GMTrace.o(13404056059904L, 99868);
          return str;
        }
      });
    }
    for (;;)
    {
      GMTrace.o(16089215926272L, 119874);
      return 0;
      ae.v(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(13396539867136L, 99812);
          this.htG.a(paramInt1, paramInt2, paramString, paramb, paramk);
          GMTrace.o(13396539867136L, 99812);
        }
      });
    }
  }
  
  public static b a(b paramb)
  {
    GMTrace.i(13397613608960L, 99820);
    a(paramb, null, false);
    GMTrace.o(13397613608960L, 99820);
    return paramb;
  }
  
  public static b a(b paramb, a parama)
  {
    GMTrace.i(13397747826688L, 99821);
    a(paramb, parama, false);
    GMTrace.o(13397747826688L, 99821);
    return paramb;
  }
  
  public static k a(b paramb, final a parama, final boolean paramBoolean)
  {
    GMTrace.i(13397882044416L, 99822);
    if (htz == null)
    {
      v.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
      GMTrace.o(13397882044416L, 99822);
      return null;
    }
    if (htz.ve() == null)
    {
      v.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
      GMTrace.o(13397882044416L, 99822);
      return null;
    }
    if (paramb == null)
    {
      v.e("MicroMsg.RunCgi", "ERROR: Param CommReqResp is null");
      GMTrace.o(13397882044416L, 99822);
      return null;
    }
    paramb = new k()
    {
      private j hrQ;
      public e htA;
      public final k htB;
      int htC;
      ai htD;
      public final long startTime;
      
      public final int a(com.tencent.mm.network.e paramAnonymouse, e paramAnonymouse1)
      {
        GMTrace.i(13391842246656L, 99777);
        this.htA = paramAnonymouse1;
        int i = a(paramAnonymouse, this.htE, this.hrQ);
        v.i("MicroMsg.RunCgi", "Start doScene:%d func:%d netid:%d time:%d", new Object[] { Integer.valueOf(this.htB.hashCode()), Integer.valueOf(this.htE.hrU), Integer.valueOf(i), Long.valueOf(bf.NA() - this.startTime) });
        if (parama != null)
        {
          if (i >= 0) {
            break label130;
          }
          u.a(paramBoolean, parama, 3, -1, "", this.htE, this.htB);
        }
        for (;;)
        {
          GMTrace.o(13391842246656L, 99777);
          return i;
          label130:
          this.htD.v(60000L, 60000L);
        }
      }
      
      public final int getType()
      {
        GMTrace.i(13391708028928L, 99776);
        int i = this.htE.hrU;
        GMTrace.o(13391708028928L, 99776);
        return i;
      }
    };
    if (htz.ve().a(paramb, 0))
    {
      GMTrace.o(13397882044416L, 99822);
      return paramb;
    }
    GMTrace.o(13397882044416L, 99822);
    return null;
  }
  
  public static abstract interface a
  {
    public abstract int a(int paramInt1, int paramInt2, String paramString, b paramb, k paramk);
  }
  
  public static abstract interface b
  {
    public abstract n ve();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/y/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */