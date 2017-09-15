package com.tencent.mm.modelfriend;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ajj;
import com.tencent.mm.protocal.c.ajk;
import com.tencent.mm.protocal.c.ajl;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ae.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.g;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.x.h;
import com.tencent.mm.x.i;
import com.tencent.mm.x.n;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class y
  extends k
  implements j
{
  private final b gUq;
  private com.tencent.mm.y.e gUt;
  
  public y(String paramString, List<String[]> paramList)
  {
    GMTrace.i(4455760134144L, 33198);
    this.gUt = null;
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new ajk();
    ((b.a)localObject).hrW = new ajl();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/listmfriend";
    ((b.a)localObject).hrU = 431;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    localObject = (ajk)this.gUq.hrS.hsa;
    ((ajk)localObject).tsG = paramString;
    ((ajk)localObject).tLA = 0;
    if (paramList == null) {}
    for (;;)
    {
      ((ajk)localObject).tLy = i;
      ((ajk)localObject).tLB = new LinkedList();
      ((ajk)localObject).tLz = new LinkedList();
      if (paramList == null) {
        break;
      }
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (String[])paramString.next();
        if (!bf.mA(paramList[2])) {
          ((ajk)localObject).tLz.add(new avu().OU(paramList[2]));
        }
      }
      i = paramList.size();
    }
    GMTrace.o(4455760134144L, 33198);
  }
  
  public final LinkedList<ajj> FL()
  {
    GMTrace.i(4456028569600L, 33200);
    Object localObject = ((ajl)this.gUq.hrT.hsa).tLC;
    if (localObject != null)
    {
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ajj localajj = (ajj)((Iterator)localObject).next();
        ap.yY();
        c.xB().eI(localajj.jLx, localajj.tAe);
      }
    }
    localObject = ((ajl)this.gUq.hrT.hsa).tLC;
    GMTrace.o(4456028569600L, 33200);
    return (LinkedList<ajj>)localObject;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4455894351872L, 33199);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(4455894351872L, 33199);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, final p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4456297005056L, 33202);
    paramp = (ajl)this.gUq.hrT.hsa;
    ap.vL().a(new ae.a()
    {
      public final boolean Bn()
      {
        GMTrace.i(4447304417280L, 33135);
        if ((paramp != null) && (paramp.tLC.size() > 0))
        {
          Iterator localIterator = paramp.tLC.iterator();
          while (localIterator.hasNext())
          {
            ajj localajj = (ajj)localIterator.next();
            if (localajj.jLP == 1)
            {
              h localh = new h();
              localh.username = localajj.jLx;
              localh.hrk = localajj.tov;
              localh.hrj = localajj.tow;
              localh.fRM = -1;
              v.d("MicroMsg.NetSceneListMFriend", "getmlist  %s b[%s] s[%s]", new Object[] { localh.getUsername(), localh.Bs(), localh.Bt() });
              localh.gkg = 3;
              localh.aV(true);
              n.Bm().a(localh);
            }
          }
        }
        GMTrace.o(4447304417280L, 33135);
        return true;
      }
      
      public final boolean Bo()
      {
        GMTrace.i(4447170199552L, 33134);
        GMTrace.o(4447170199552L, 33134);
        return false;
      }
      
      public final String toString()
      {
        GMTrace.i(4447438635008L, 33136);
        String str = super.toString() + "|onGYNetEnd";
        GMTrace.o(4447438635008L, 33136);
        return str;
      }
    });
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(4456297005056L, 33202);
  }
  
  public final int getType()
  {
    GMTrace.i(4456162787328L, 33201);
    GMTrace.o(4456162787328L, 33201);
    return 431;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelfriend/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */