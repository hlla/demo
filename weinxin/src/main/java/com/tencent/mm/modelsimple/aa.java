package com.tencent.mm.modelsimple;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.awm;
import com.tencent.mm.protocal.c.awn;
import com.tencent.mm.protocal.c.awo;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.g;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.x.h;
import com.tencent.mm.x.i;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import java.util.Iterator;
import java.util.LinkedList;

public final class aa
  extends k
  implements j
{
  private final b gUq;
  private com.tencent.mm.y.e gUt;
  public final boolean hSF;
  
  public aa(String paramString)
  {
    this(paramString, 0);
    GMTrace.i(1338419183616L, 9972);
    GMTrace.o(1338419183616L, 9972);
  }
  
  public aa(String paramString, int paramInt)
  {
    this(paramString, paramInt, (byte)0);
    GMTrace.i(1338553401344L, 9973);
    GMTrace.o(1338553401344L, 9973);
  }
  
  private aa(String paramString, int paramInt, byte paramByte)
  {
    this(paramString, 1, paramInt, false);
    GMTrace.i(1338687619072L, 9974);
    GMTrace.o(1338687619072L, 9974);
  }
  
  public aa(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    GMTrace.i(1338821836800L, 9975);
    this.hSF = paramBoolean;
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new awn();
    ((b.a)localObject).hrW = new awo();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/searchcontact";
    ((b.a)localObject).hrU = 106;
    ((b.a)localObject).hrX = 34;
    ((b.a)localObject).hrY = 1000000034;
    this.gUq = ((b.a)localObject).BE();
    v.d("MicroMsg.NetSceneSearchContact", "search username [%s]", new Object[] { paramString });
    localObject = (awn)this.gUq.hrS.hsa;
    ((awn)localObject).trH = new avu().OU(paramString);
    ((awn)localObject).tTO = paramInt1;
    ((awn)localObject).tXT = paramInt2;
    GMTrace.o(1338821836800L, 9975);
  }
  
  public final awo Jy()
  {
    GMTrace.i(1339358707712L, 9979);
    awo localawo = (awo)this.gUq.hrT.hsa;
    if (localawo != null)
    {
      Iterator localIterator = localawo.tCk.iterator();
      while (localIterator.hasNext())
      {
        awm localawm = (awm)localIterator.next();
        ap.yY();
        c.xB().eI(localawm.trH.tXF, localawm.tAe);
      }
    }
    GMTrace.o(1339358707712L, 9979);
    return localawo;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(1338956054528L, 9976);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(1338956054528L, 9976);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(1339224489984L, 9978);
    paramp = (awo)this.gUq.hrT.hsa;
    if ((paramp != null) && (paramp.tCj > 0)) {
      paramp = paramp.tCk.iterator();
    }
    while (paramp.hasNext())
    {
      paramArrayOfByte = (awm)paramp.next();
      v.d("MicroMsg.NetSceneSearchContact", "search RES username [%s]", new Object[] { paramArrayOfByte.trH });
      h localh = new h();
      localh.username = com.tencent.mm.platformtools.n.a(paramArrayOfByte.trH);
      localh.hrk = paramArrayOfByte.tov;
      localh.hrj = paramArrayOfByte.tow;
      localh.fRM = -1;
      v.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[] { localh.getUsername(), localh.Bs(), localh.Bt() });
      localh.gkg = 3;
      localh.aV(true);
      com.tencent.mm.x.n.Bm().a(localh);
      continue;
      if ((paramp != null) && (!bf.mA(com.tencent.mm.platformtools.n.a(paramp.trH))))
      {
        paramArrayOfByte = com.tencent.mm.platformtools.n.a(paramp.trH);
        localh = new h();
        localh.username = paramArrayOfByte;
        localh.hrk = paramp.tov;
        localh.hrj = paramp.tow;
        localh.fRM = -1;
        v.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[] { localh.getUsername(), localh.Bs(), localh.Bt() });
        localh.gkg = 3;
        localh.aV(true);
        com.tencent.mm.x.n.Bm().a(localh);
      }
    }
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(1339224489984L, 9978);
  }
  
  public final int getType()
  {
    GMTrace.i(1339090272256L, 9977);
    GMTrace.o(1339090272256L, 9977);
    return 106;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsimple/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */