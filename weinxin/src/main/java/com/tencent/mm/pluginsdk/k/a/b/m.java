package com.tencent.mm.pluginsdk.k.a.b;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avl;
import com.tencent.mm.protocal.c.kw;
import com.tencent.mm.protocal.c.kx;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.c;
import java.util.LinkedList;
import java.util.List;

public final class m
  extends n
{
  public m()
  {
    GMTrace.i(851477266432L, 6344);
    GMTrace.o(851477266432L, 6344);
  }
  
  public m(int paramInt)
  {
    GMTrace.i(851611484160L, 6345);
    avl localavl = new avl();
    localavl.jMq = paramInt;
    this.sEC.clear();
    this.sEC.add(localavl);
    GMTrace.o(851611484160L, 6345);
  }
  
  protected final p bDs()
  {
    GMTrace.i(851745701888L, 6346);
    Object localObject = new b.a();
    kw localkw = new kw();
    localkw.tpF.addAll(this.sEC);
    ((b.a)localObject).hrV = localkw;
    ((b.a)localObject).hrW = new kx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkresupdate";
    ((b.a)localObject).hrU = 721;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    localObject = ((b.a)localObject).BE();
    GMTrace.o(851745701888L, 6346);
    return (p)localObject;
  }
  
  protected final String getTag()
  {
    GMTrace.i(851208830976L, 6342);
    GMTrace.o(851208830976L, 6342);
    return "MicroMsg.ResDownloader.CheckResUpdate.NetSceneCheckResUpdate";
  }
  
  public final int getType()
  {
    GMTrace.i(851879919616L, 6347);
    GMTrace.o(851879919616L, 6347);
    return 721;
  }
  
  protected final kx h(p paramp)
  {
    GMTrace.i(851343048704L, 6343);
    paramp = (kx)((b)paramp).hrT.hsa;
    GMTrace.o(851343048704L, 6343);
    return paramp;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/k/a/b/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */