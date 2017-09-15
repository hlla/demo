package com.tencent.mm.modelfriend;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.g;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.pluginsdk.a;
import com.tencent.mm.protocal.c.ajt;
import com.tencent.mm.protocal.c.alr;
import com.tencent.mm.protocal.c.bhn;
import com.tencent.mm.protocal.c.bho;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aa
  extends k
  implements j
{
  private int fJB;
  private com.tencent.mm.y.e gUt;
  private int hBA;
  public final List<String> hBw;
  public final List<String> hBx;
  private final String hBy;
  private int hBz;
  
  public aa(List<String> paramList1, List<String> paramList2)
  {
    GMTrace.i(4434553733120L, 33040);
    ap.yY();
    this.hBy = ((String)c.vr().get(6, null));
    this.hBA = 0;
    this.hBz = 0;
    this.hBw = paramList1;
    this.hBx = paramList2;
    this.fJB = 1;
    GMTrace.o(4434553733120L, 33040);
  }
  
  private static List<String> G(List<ajt> paramList)
  {
    GMTrace.i(4435359039488L, 33046);
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0))
    {
      v.i("MicroMsg.NetSceneUploadMContact", "the req emai list is empty");
      GMTrace.o(4435359039488L, 33046);
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((ajt)paramList.next()).v);
    }
    GMTrace.o(4435359039488L, 33046);
    return localArrayList;
  }
  
  private static List<String> H(List<alr> paramList)
  {
    GMTrace.i(4435493257216L, 33047);
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0))
    {
      v.i("MicroMsg.NetSceneUploadMContact", "the req mobile list is empty");
      GMTrace.o(4435493257216L, 33047);
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(g.n(a.Dg(((alr)paramList.next()).v).getBytes()));
    }
    GMTrace.o(4435493257216L, 33047);
    return localArrayList;
  }
  
  public final boolean BI()
  {
    GMTrace.i(4434822168576L, 33042);
    GMTrace.o(4434822168576L, 33042);
    return true;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    int m = 0;
    GMTrace.i(4434687950848L, 33041);
    this.gUt = parame1;
    if (((this.hBw == null) || (this.hBw.size() == 0)) && ((this.hBx == null) || (this.hBx.size() == 0)))
    {
      v.i("MicroMsg.NetSceneUploadMContact", "listMobile or listEmile is null or zero");
      GMTrace.o(4434687950848L, 33041);
      return -1;
    }
    parame1 = new b.a();
    parame1.hrV = new bhn();
    parame1.hrW = new bho();
    parame1.uri = "/cgi-bin/micromsg-bin/uploadmcontact";
    parame1.hrU = 133;
    parame1.hrX = 0;
    parame1.hrY = 0;
    parame1 = parame1.BE();
    bhn localbhn = (bhn)parame1.hrS.hsa;
    localbhn.thR = this.hBy;
    localbhn.jLx = com.tencent.mm.u.m.xL();
    localbhn.tgi = this.fJB;
    int i = 200;
    Object localObject1 = new LinkedList();
    LinkedList localLinkedList = new LinkedList();
    do
    {
      int k;
      do
      {
        if (i <= 0) {
          break label444;
        }
        int j = i;
        Object localObject2;
        if (this.hBw != null)
        {
          j = i;
          if (this.hBz < this.hBw.size())
          {
            if (this.hBw.get(this.hBz) != null)
            {
              localObject2 = new alr();
              ((alr)localObject2).v = ((String)this.hBw.get(this.hBz));
              ((LinkedList)localObject1).add(localObject2);
            }
            this.hBz += 1;
            j = i - 1;
          }
        }
        k = j;
        if (this.hBx != null)
        {
          k = j;
          if (this.hBA < this.hBx.size())
          {
            if (this.hBx.get(this.hBA) != null)
            {
              localObject2 = new ajt();
              ((ajt)localObject2).v = ((String)this.hBx.get(this.hBA));
              localLinkedList.add(localObject2);
            }
            this.hBA += 1;
            k = j - 1;
          }
        }
        if (this.hBx == null) {
          break;
        }
        i = k;
      } while (this.hBA < this.hBx.size());
      if (this.hBw == null) {
        break;
      }
      i = k;
    } while (this.hBz < this.hBw.size());
    label444:
    localbhn.tLz = ((LinkedList)localObject1);
    localbhn.ufq = ((LinkedList)localObject1).size();
    localbhn.ufs = localLinkedList;
    localbhn.ufr = localLinkedList.size();
    localObject1 = new StringBuilder("doscene in:[");
    if (this.hBx == null)
    {
      i = 0;
      localObject1 = ((StringBuilder)localObject1).append(i).append(",");
      if (this.hBw != null) {
        break label630;
      }
    }
    label630:
    for (i = m;; i = this.hBw.size())
    {
      v.v("MicroMsg.NetSceneUploadMContact", i + "] index:[" + this.hBA + "," + this.hBz + "] req:[" + localbhn.ufs.size() + "," + localbhn.tLz.size() + "]");
      i = a(parame, parame1, this);
      GMTrace.o(4434687950848L, 33041);
      return i;
      i = this.hBx.size();
      break;
    }
  }
  
  protected final int a(p paramp)
  {
    GMTrace.i(4434956386304L, 33043);
    paramp = (bhn)((b)paramp).hrS.hsa;
    int i = paramp.ufs.size() + paramp.tLz.size();
    if ((i == 0) || (i > 200))
    {
      v.e("MicroMsg.NetSceneUploadMContact", "security checked failed : exceed max send count");
      i = k.b.hsD;
      GMTrace.o(4434956386304L, 33043);
      return i;
    }
    if ((paramp.thR == null) || (paramp.thR.length() <= 0))
    {
      v.e("MicroMsg.NetSceneUploadMContact", "security checked failed : moblie null");
      i = k.b.hsD;
      GMTrace.o(4434956386304L, 33043);
      return i;
    }
    if ((paramp.jLx == null) || (paramp.jLx.length() <= 0))
    {
      v.e("MicroMsg.NetSceneUploadMContact", "security checked failed : username null");
      i = k.b.hsD;
      GMTrace.o(4434956386304L, 33043);
      return i;
    }
    i = k.b.hsC;
    GMTrace.o(4434956386304L, 33043);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4435224821760L, 33045);
    v.i("MicroMsg.NetSceneUploadMContact", "onSceneEnd: errType = " + paramInt2 + " errCode = " + paramInt3 + " errMsg = " + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      v.e("MicroMsg.NetSceneUploadMContact", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(4435224821760L, 33045);
      return;
    }
    paramp = (bhn)((b)paramp).hrS.hsa;
    m.E(G(paramp.ufs));
    m.E(H(paramp.tLz));
    if (((this.hBx == null) || (this.hBA >= this.hBx.size())) && ((this.hBw == null) || (this.hBz >= this.hBw.size())))
    {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(4435224821760L, 33045);
      return;
    }
    if (a(this.hsm, this.gUt) < 0) {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
    }
    GMTrace.o(4435224821760L, 33045);
  }
  
  public final int getType()
  {
    GMTrace.i(4435627474944L, 33048);
    GMTrace.o(4435627474944L, 33048);
    return 133;
  }
  
  protected final int ub()
  {
    GMTrace.i(4435090604032L, 33044);
    GMTrace.o(4435090604032L, 33044);
    return 10;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelfriend/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */