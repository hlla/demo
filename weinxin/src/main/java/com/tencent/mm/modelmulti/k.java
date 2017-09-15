package com.tencent.mm.modelmulti;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.protocal.aa.a;
import com.tencent.mm.protocal.aa.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.y.i;

public final class k
  extends com.tencent.mm.y.k
  implements j
{
  private WakerLock gJw;
  private com.tencent.mm.y.e gUt;
  private final p htc;
  
  public k()
  {
    GMTrace.i(13433583960064L, 100088);
    this.gJw = new WakerLock(aa.getContext());
    this.gJw.lock(3000L, "NetSceneSynCheck");
    this.htc = new a();
    h.vJ();
    if (h.vI() != null)
    {
      h.vJ();
      if (h.vI().vr() != null)
      {
        h.vJ();
        Object localObject = (String)h.vI().vr().get(8195, null);
        ((aa.a)this.htc.BG()).hKl = bf.PS((String)localObject);
        localObject = (aa.a)this.htc.BG();
        h.vJ();
        h.vG();
        ((aa.a)localObject).uin = com.tencent.mm.kernel.a.uH();
        ((aa.a)this.htc.BG()).netType = com.tencent.mm.protocal.a.getNetType(aa.getContext());
        ((aa.a)this.htc.BG()).sXY = com.tencent.mm.protocal.a.bGQ();
        v.d("MicroMsg.MMSyncCheck", "NetSceneSynCheck");
        GMTrace.o(13433583960064L, 100088);
        return;
      }
    }
    v.e("MicroMsg.NetSceneSynCheck", "[arthurdan.NetSceneSynCheckCrash] Notice!!! MMCore.getAccStg() is null");
    GMTrace.o(13433583960064L, 100088);
  }
  
  public final boolean BI()
  {
    GMTrace.i(13433852395520L, 100090);
    GMTrace.o(13433852395520L, 100090);
    return true;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(13433718177792L, 100089);
    this.gUt = parame1;
    int i = a(parame, this.htc, this);
    if ((i == -1) && (this.gJw.isLocking())) {
      this.gJw.unLock();
    }
    GMTrace.o(13433718177792L, 100089);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(13434120830976L, 100092);
    paramArrayOfByte = (aa.b)paramp.zg();
    v.i("MicroMsg.NetSceneSynCheck", "new syncCheck complete, selector=" + paramArrayOfByte.sYC);
    if ((h.vG().uV()) && (!com.tencent.mm.kernel.a.uP()))
    {
      paramp = ((aa.a)paramp.BG()).gXz;
      if (bf.bm(paramp)) {
        v.e("MicroMsg.NetSceneSynCheck", "onGYNetEnd md5 is null");
      }
      paramArrayOfByte.gXz = paramp;
      ((b)h.h(b.class)).Hz().a(paramArrayOfByte.sYC, 2, paramArrayOfByte.bHh());
    }
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    this.gJw.unLock();
    GMTrace.o(13434120830976L, 100092);
  }
  
  public final int getType()
  {
    GMTrace.i(13433986613248L, 100091);
    GMTrace.o(13433986613248L, 100091);
    return 39;
  }
  
  public static final class a
    extends i
  {
    private final aa.a hKy;
    private final aa.b hKz;
    
    public a()
    {
      GMTrace.i(13428215250944L, 100048);
      this.hKy = new aa.a();
      this.hKz = new aa.b();
      GMTrace.o(13428215250944L, 100048);
    }
    
    public final int BD()
    {
      GMTrace.i(13428886339584L, 100053);
      GMTrace.o(13428886339584L, 100053);
      return 1;
    }
    
    public final int getType()
    {
      GMTrace.i(13428617904128L, 100051);
      GMTrace.o(13428617904128L, 100051);
      return 39;
    }
    
    public final String getUri()
    {
      GMTrace.i(13428752121856L, 100052);
      GMTrace.o(13428752121856L, 100052);
      return null;
    }
    
    protected final k.d zf()
    {
      GMTrace.i(13428349468672L, 100049);
      aa.a locala = this.hKy;
      GMTrace.o(13428349468672L, 100049);
      return locala;
    }
    
    public final k.e zg()
    {
      GMTrace.i(13428483686400L, 100050);
      aa.b localb = this.hKz;
      GMTrace.o(13428483686400L, 100050);
      return localb;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelmulti/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */