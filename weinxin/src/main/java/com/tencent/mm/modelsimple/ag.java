package com.tencent.mm.modelsimple;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bdg;
import com.tencent.mm.protocal.c.bdh;
import com.tencent.mm.protocal.c.bdi;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

public final class ag
  extends k
  implements j
{
  private final com.tencent.mm.y.b gUq;
  private com.tencent.mm.y.e gUt;
  private final String toUserName;
  
  public ag(String paramString, int paramInt)
  {
    GMTrace.i(1360430891008L, 10136);
    this.toUserName = paramString;
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new bdh();
    ((b.a)localObject).hrW = new bdi();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/statusnotify";
    ((b.a)localObject).hrU = 251;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    localObject = (bdh)this.gUq.hrS.hsa;
    ((bdh)localObject).muu = m.xL();
    ((bdh)localObject).ucV = paramInt;
    ((bdh)localObject).mut = paramString;
    ((bdh)localObject).teo = System.currentTimeMillis();
    v.d("MicroMsg.NetSceneStatusNotify", "toUserName = " + paramString);
    GMTrace.o(1360430891008L, 10136);
  }
  
  private ag(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    GMTrace.i(1360565108736L, 10137);
    this.toUserName = paramString1;
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new bdh();
    ((b.a)localObject).hrW = new bdi();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/statusnotify";
    ((b.a)localObject).hrU = 251;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    localObject = (bdh)this.gUq.hrS.hsa;
    ((bdh)localObject).muu = m.xL();
    ((bdh)localObject).ucV = paramInt;
    ((bdh)localObject).mut = paramString1;
    ((bdh)localObject).teo = System.currentTimeMillis();
    ((bdh)localObject).ucY = new bdg();
    ((bdh)localObject).ucY.mqI = paramString2;
    ((bdh)localObject).ucY.ucU = paramString3;
    GMTrace.o(1360565108736L, 10137);
  }
  
  public static void C(String paramString, int paramInt)
  {
    GMTrace.i(1360162455552L, 10134);
    if (bf.mA(paramString))
    {
      GMTrace.o(1360162455552L, 10134);
      return;
    }
    if ((!h.vG().uV()) || ((o.fE(paramString)) && (!o.eZ(paramString))))
    {
      GMTrace.o(1360162455552L, 10134);
      return;
    }
    paramString = new ag(paramString, paramInt);
    h.vH().gXs.a(paramString, 0);
    GMTrace.o(1360162455552L, 10134);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    GMTrace.i(1360296673280L, 10135);
    if ((bf.mA(paramString1)) || (o.fE(paramString1)))
    {
      GMTrace.o(1360296673280L, 10135);
      return;
    }
    if (!h.vG().uV())
    {
      GMTrace.o(1360296673280L, 10135);
      return;
    }
    paramString1 = new ag(paramString1, paramInt, paramString2, paramString3);
    h.vH().gXs.a(paramString1, 0);
    GMTrace.o(1360296673280L, 10135);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(1360833544192L, 10139);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(1360833544192L, 10139);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(1360967761920L, 10140);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      v.d("MicroMsg.NetSceneStatusNotify", "StatusNotify Error. userName=" + this.toUserName);
    }
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(1360967761920L, 10140);
  }
  
  public final int getType()
  {
    GMTrace.i(1360699326464L, 10138);
    GMTrace.o(1360699326464L, 10138);
    return 251;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsimple/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */