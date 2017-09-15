package com.tencent.mm.ao;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.aos;
import com.tencent.mm.protocal.c.aot;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.lt;
import com.tencent.mm.protocal.c.lu;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.i;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends k
  implements j
{
  private com.tencent.mm.y.e gUt;
  public a hMW;
  public final List<e.b> hMX;
  
  public a(List<e.b> paramList)
  {
    GMTrace.i(13185012727808L, 98236);
    this.hMX = new ArrayList();
    this.hMX.addAll(paramList);
    this.hMW = new a();
    ((b)this.hMW.BG()).hNa.tRg = J(paramList);
    GMTrace.o(13185012727808L, 98236);
  }
  
  private static lu J(List<e.b> paramList)
  {
    GMTrace.i(13185146945536L, 98237);
    lu locallu = new lu();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      e.b localb = (e.b)localIterator.next();
      byte[] arrayOfByte = localb.getBuffer();
      lt locallt = new lt();
      locallt.tqs = localb.getCmdId();
      locallt.tqt = new avt().bb(arrayOfByte);
      locallu.jLs.add(locallt);
    }
    locallu.jLr = paramList.size();
    v.d("MicroMsg.NetSceneOplog", "summeroplog oplogs size=" + paramList.size());
    GMTrace.o(13185146945536L, 98237);
    return locallu;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(13185281163264L, 98238);
    this.gUt = parame1;
    int i = a(parame, this.hMW, this);
    GMTrace.o(13185281163264L, 98238);
    return i;
  }
  
  protected final int a(p paramp)
  {
    GMTrace.i(13185415380992L, 98239);
    int i = com.tencent.mm.y.k.b.hsC;
    GMTrace.o(13185415380992L, 98239);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(13185683816448L, 98241);
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(13185683816448L, 98241);
  }
  
  public final int getType()
  {
    GMTrace.i(13185818034176L, 98242);
    GMTrace.o(13185818034176L, 98242);
    return 681;
  }
  
  protected final int ub()
  {
    GMTrace.i(13185549598720L, 98240);
    GMTrace.o(13185549598720L, 98240);
    return 5;
  }
  
  static final class a
    extends i
  {
    private final a.b hMY;
    final a.c hMZ;
    
    public a()
    {
      GMTrace.i(13186489122816L, 98247);
      this.hMY = new a.b();
      this.hMZ = new a.c();
      GMTrace.o(13186489122816L, 98247);
    }
    
    public final int getType()
    {
      GMTrace.i(13186891776000L, 98250);
      GMTrace.o(13186891776000L, 98250);
      return 681;
    }
    
    public final String getUri()
    {
      GMTrace.i(13187025993728L, 98251);
      GMTrace.o(13187025993728L, 98251);
      return "/cgi-bin/micromsg-bin/oplog";
    }
    
    public final k.d zf()
    {
      GMTrace.i(13186623340544L, 98248);
      a.b localb = this.hMY;
      GMTrace.o(13186623340544L, 98248);
      return localb;
    }
    
    public final k.e zg()
    {
      GMTrace.i(13186757558272L, 98249);
      a.c localc = this.hMZ;
      GMTrace.o(13186757558272L, 98249);
      return localc;
    }
  }
  
  static final class b
    extends k.d
    implements com.tencent.mm.protocal.k.b
  {
    public aos hNa;
    
    b()
    {
      GMTrace.i(13182999461888L, 98221);
      this.hNa = new aos();
      GMTrace.o(13182999461888L, 98221);
    }
    
    public final byte[] zh()
    {
      GMTrace.i(13183133679616L, 98222);
      byte[] arrayOfByte = this.hNa.toByteArray();
      GMTrace.o(13183133679616L, 98222);
      return arrayOfByte;
    }
    
    public final int zi()
    {
      GMTrace.i(13183267897344L, 98223);
      GMTrace.o(13183267897344L, 98223);
      return 681;
    }
  }
  
  static final class c
    extends k.e
    implements k.c
  {
    public aot hNb;
    
    c()
    {
      GMTrace.i(13184744292352L, 98234);
      this.hNb = new aot();
      GMTrace.o(13184744292352L, 98234);
    }
    
    public final int y(byte[] paramArrayOfByte)
    {
      GMTrace.i(13184878510080L, 98235);
      this.hNb = ((aot)new aot().aD(paramArrayOfByte));
      int i = this.hNb.tgr;
      GMTrace.o(13184878510080L, 98235);
      return i;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ao/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */