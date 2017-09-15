package com.tencent.mm.ah;

import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.cache.a.a;
import com.tencent.mm.e.a.nu;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.am;
import com.tencent.mm.u.l;
import com.tencent.mm.y.d.c;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class n
  implements am
{
  private static HashMap<Integer, g.c> gJh;
  private SFSContext hHA;
  private SFSContext hHB;
  private f hHq;
  private h hHr;
  private b hHs;
  private i hHt;
  private c hHu;
  private g hHv;
  private a hHw;
  private o hHx;
  private com.tencent.mm.sdk.b.c hHy;
  private com.tencent.mm.ah.a.a hHz;
  
  static
  {
    GMTrace.i(3510867329024L, 26158);
    HashMap localHashMap = new HashMap();
    gJh = localHashMap;
    localHashMap.put(Integer.valueOf("IMGINFO_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(3541737406464L, 26388);
        String[] arrayOfString = f.gUn;
        GMTrace.o(3541737406464L, 26388);
        return arrayOfString;
      }
    });
    GMTrace.o(3510867329024L, 26158);
  }
  
  public n()
  {
    GMTrace.i(3508719845376L, 26142);
    this.hHt = new i();
    this.hHu = null;
    this.hHv = new g();
    this.hHw = null;
    this.hHx = null;
    this.hHy = new com.tencent.mm.sdk.b.c() {};
    this.hHz = null;
    this.hHA = null;
    this.hHB = null;
    GMTrace.o(3508719845376L, 26142);
  }
  
  private static n GQ()
  {
    try
    {
      GMTrace.i(3508854063104L, 26143);
      n localn = (n)l.o(n.class);
      GMTrace.o(3508854063104L, 26143);
      return localn;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static h GR()
  {
    GMTrace.i(3508988280832L, 26144);
    if (GQ().hHr == null) {
      GQ().hHr = new h();
    }
    h localh = GQ().hHr;
    GMTrace.o(3508988280832L, 26144);
    return localh;
  }
  
  public static b GS()
  {
    GMTrace.i(3509122498560L, 26145);
    com.tencent.mm.kernel.h.vG().uQ();
    if (GQ().hHs == null) {
      GQ().hHs = new b();
    }
    b localb = GQ().hHs;
    GMTrace.o(3509122498560L, 26145);
    return localb;
  }
  
  public static f GT()
  {
    GMTrace.i(3509256716288L, 26146);
    com.tencent.mm.kernel.h.vG().uQ();
    if (GQ().hHq == null) {
      GQ().hHq = new f(com.tencent.mm.kernel.h.vI().gXW);
    }
    f localf = GQ().hHq;
    GMTrace.o(3509256716288L, 26146);
    return localf;
  }
  
  public static c GU()
  {
    GMTrace.i(3509390934016L, 26147);
    com.tencent.mm.kernel.h.vG().uQ();
    if (GQ().hHu == null) {
      GQ().hHu = new c();
    }
    c localc = GQ().hHu;
    GMTrace.o(3509390934016L, 26147);
    return localc;
  }
  
  public static a GV()
  {
    GMTrace.i(3509525151744L, 26148);
    com.tencent.mm.kernel.h.vG().uQ();
    if (GQ().hHw == null) {
      GQ().hHw = new a(Looper.getMainLooper());
    }
    a locala = GQ().hHw;
    GMTrace.o(3509525151744L, 26148);
    return locala;
  }
  
  public static o GW()
  {
    GMTrace.i(3509659369472L, 26149);
    com.tencent.mm.kernel.h.vG().uQ();
    if (GQ().hHx == null) {
      GQ().hHx = new o();
    }
    o localo = GQ().hHx;
    GMTrace.o(3509659369472L, 26149);
    return localo;
  }
  
  public static com.tencent.mm.ah.a.a GX()
  {
    GMTrace.i(3509793587200L, 26150);
    com.tencent.mm.kernel.h.vG().uQ();
    if (GQ().hHz == null) {
      GQ().hHz = com.tencent.mm.ah.a.a.He();
    }
    com.tencent.mm.ah.a.a locala = GQ().hHz;
    GMTrace.o(3509793587200L, 26150);
    return locala;
  }
  
  public static SFSContext GY()
  {
    GMTrace.i(3509927804928L, 26151);
    GMTrace.o(3509927804928L, 26151);
    return null;
  }
  
  public static void GZ()
  {
    GMTrace.i(3510196240384L, 26153);
    Object localObject = GQ().hHq;
    if (localObject != null)
    {
      v.i("MicroMsg.ImgInfoStorage", "clearCacheMap stack:%s", new Object[] { bf.bJP() });
      ((f)localObject).hFn.a(new f.3((f)localObject));
    }
    localObject = GQ().hHz;
    if (localObject != null) {
      ((com.tencent.mm.ah.a.a)localObject).detach();
    }
    GMTrace.o(3510196240384L, 26153);
  }
  
  public final void aM(boolean paramBoolean)
  {
    GMTrace.i(3510598893568L, 26156);
    d.c.a(Integer.valueOf(3), this.hHv);
    d.c.a(Integer.valueOf(23), this.hHv);
    a.a.a("local_cdn_img_cache", this.hHt);
    com.tencent.mm.sdk.b.a.uql.b(this.hHy);
    GMTrace.o(3510598893568L, 26156);
  }
  
  public final void aN(boolean paramBoolean)
  {
    GMTrace.i(3510733111296L, 26157);
    GMTrace.o(3510733111296L, 26157);
  }
  
  public final void eD(int paramInt)
  {
    GMTrace.i(3510464675840L, 26155);
    GMTrace.o(3510464675840L, 26155);
  }
  
  public final void onAccountRelease()
  {
    GMTrace.i(3510062022656L, 26152);
    n localn = GQ();
    if (localn.hHr != null)
    {
      ??? = localn.hHr;
      ((h)???).fBf = 0;
      com.tencent.mm.kernel.h.vH().gXs.b(110, (com.tencent.mm.y.e)???);
    }
    a locala;
    if (localn.hHw != null) {
      locala = localn.hHw;
    }
    synchronized (locala.hEb)
    {
      locala.hEb.clear();
      locala.hEc = 0L;
      GU().a(locala);
      com.tencent.mm.sdk.b.a.uql.c(locala.hEn);
      com.tencent.mm.sdk.b.a.uql.c(locala.hEo);
      if (localn.hHu == null) {
        break label202;
      }
      ??? = localn.hHu;
      v.i("ModelImage.DownloadImgService", "on detach");
      v.i("ModelImage.DownloadImgService", "cancel all net scene");
      ((c)???).hEx = true;
      ((c)???).b(((c)???).hEv);
      if (((c)???).hEt.size() > 0) {
        ((c)???).b((c.b)((c)???).hEt.get(0));
      }
    }
    ((c)???).Gx();
    com.tencent.mm.kernel.h.vH().gXs.b(109, (com.tencent.mm.y.e)???);
    label202:
    if (((n)localObject1).hHx != null)
    {
      ??? = ((n)localObject1).hHx;
      v.i("MicroMsg.UrlImageCacheService", "detach");
      ((o)???).hHD.clear();
      ((o)???).hHF = true;
    }
    GZ();
    d.c.aA(Integer.valueOf(3));
    d.c.aA(Integer.valueOf(23));
    a.a.a("local_cdn_img_cache", null);
    com.tencent.mm.sdk.b.a.uql.c(this.hHy);
    if (((n)localObject1).hHz != null)
    {
      ((n)localObject1).hHz.detach();
      ((n)localObject1).hHz = null;
    }
    if (((n)localObject1).hHA != null)
    {
      ((n)localObject1).hHA.release();
      ((n)localObject1).hHA = null;
    }
    if (((n)localObject1).hHB != null)
    {
      ((n)localObject1).hHB.release();
      ((n)localObject1).hHB = null;
    }
    GMTrace.o(3510062022656L, 26152);
  }
  
  public final HashMap<Integer, g.c> uh()
  {
    GMTrace.i(3510330458112L, 26154);
    HashMap localHashMap = gJh;
    GMTrace.o(3510330458112L, 26154);
    return localHashMap;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ah/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */