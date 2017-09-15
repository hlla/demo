package com.tencent.mm.modelfriend;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.j.a;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ajt;
import com.tencent.mm.protocal.c.aju;
import com.tencent.mm.protocal.c.alr;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.bcl;
import com.tencent.mm.protocal.c.en;
import com.tencent.mm.protocal.c.mx;
import com.tencent.mm.protocal.c.qp;
import com.tencent.mm.protocal.c.zi;
import com.tencent.mm.protocal.c.zj;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.x.n;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class v
  extends com.tencent.mm.y.k
  implements j
{
  com.tencent.mm.y.b gUq;
  private com.tencent.mm.y.e gUt;
  private List<String> hAI;
  private List<String> hBp;
  
  public v()
  {
    GMTrace.i(4440056659968L, 33081);
    this.gUt = null;
    FH();
    zi localzi = (zi)this.gUq.hrS.hsa;
    localzi.tsQ = "";
    localzi.tEf = null;
    localzi.tEe = 0;
    localzi.tEd = null;
    localzi.tEc = 0;
    localzi.mse = 0;
    localzi.tcg = 1;
    GMTrace.o(4440056659968L, 33081);
  }
  
  public v(List<String> paramList1, List<String> paramList2)
  {
    GMTrace.i(4440190877696L, 33082);
    this.gUt = null;
    FH();
    if (((paramList1 == null) || (paramList1.size() == 0)) && ((paramList2 == null) || (paramList2.size() == 0)))
    {
      GMTrace.o(4440190877696L, 33082);
      return;
    }
    this.hAI = paramList1;
    this.hBp = paramList2;
    paramList1 = (zi)this.gUq.hrS.hsa;
    paramList1.tsQ = "";
    paramList1.mse = 2;
    paramList1.tcg = 1;
    GMTrace.o(4440190877696L, 33082);
  }
  
  private void FH()
  {
    GMTrace.i(4440325095424L, 33083);
    b.a locala = new b.a();
    locala.hrV = new zi();
    locala.hrW = new zj();
    locala.uri = "/cgi-bin/micromsg-bin/getmfriend";
    locala.hrU = 142;
    locala.hrX = 0;
    locala.hrY = 0;
    this.gUq = locala.BE();
    GMTrace.o(4440325095424L, 33083);
  }
  
  private static void a(b paramb, aju paramaju)
  {
    GMTrace.i(4440996184064L, 33088);
    paramb.hAk = paramaju.hAk;
    paramb.hAl = paramaju.hAl;
    paramb.hAm = paramaju.hAm;
    paramb.hAn = paramaju.hAn;
    paramb.hAo = paramaju.hAo;
    paramb.hAp = paramaju.hAp;
    paramb.hAq = paramaju.hAq;
    paramb.hAr = paramaju.hAr;
    paramb.hAt = paramaju.hAt;
    paramb.hAs = paramaju.hAs;
    paramb.hAu = paramaju.hAu;
    paramb.hAv = paramaju.hAv;
    bcl localbcl = paramaju.tLj;
    if (localbcl != null)
    {
      paramb.hAw = localbcl.hAw;
      paramb.hAx = localbcl.hAx;
      paramb.hAy = localbcl.hAy;
    }
    paramaju = paramaju.tLk;
    if (paramaju != null)
    {
      paramb.hAz = paramaju.hAz;
      paramb.hAA = paramaju.hAA;
      paramb.hAB = paramaju.hAB;
      paramb.hAC = paramaju.hAC;
    }
    GMTrace.o(4440996184064L, 33088);
  }
  
  public final void FI()
  {
    GMTrace.i(4440459313152L, 33084);
    zi localzi = (zi)this.gUq.hrS.hsa;
    ap.yY();
    localzi.tsQ = ((String)com.tencent.mm.u.c.vr().get(65828, null));
    localzi.mse = 1;
    GMTrace.o(4440459313152L, 33084);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4440593530880L, 33085);
    this.gUt = parame1;
    parame1 = (zi)this.gUq.hrS.hsa;
    if (parame1.mse == 2)
    {
      if (((this.hAI == null) || (this.hAI.size() == 0)) && ((this.hBp == null) || (this.hBp.size() == 0)))
      {
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.NetSceneGetMFriend", "doScene failed, mobile list and email list empty.");
        GMTrace.o(4440593530880L, 33085);
        return -1;
      }
      LinkedList localLinkedList;
      Iterator localIterator;
      String str;
      Object localObject;
      if ((this.hAI != null) && (this.hAI.size() > 0))
      {
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneGetMFriend", "doScene get mobile list size:%d", new Object[] { Integer.valueOf(this.hAI.size()) });
        localLinkedList = new LinkedList();
        localIterator = this.hAI.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localObject = new alr();
          ((alr)localObject).v = str;
          localLinkedList.add(localObject);
        }
        parame1.tEd = localLinkedList;
        parame1.tEc = localLinkedList.size();
      }
      if ((this.hBp != null) && (this.hBp.size() > 0))
      {
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneGetMFriend", "doScene get email list size:%d", new Object[] { Integer.valueOf(this.hBp.size()) });
        localLinkedList = new LinkedList();
        localIterator = this.hBp.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localObject = new ajt();
          ((ajt)localObject).v = str;
          localLinkedList.add(localObject);
        }
        parame1.tEf = localLinkedList;
        parame1.tEe = localLinkedList.size();
      }
    }
    int i = a(parame, this.gUq, this);
    GMTrace.o(4440593530880L, 33085);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4440861966336L, 33087);
    zj localzj = (zj)this.gUq.hrT.hsa;
    zi localzi = (zi)this.gUq.hrS.hsa;
    if ((paramInt2 == 4) && (paramInt3 == -68))
    {
      this.gUt.a(paramInt2, paramInt3, localzj.tXs.tgX.tXF, this);
      GMTrace.o(4440861966336L, 33087);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.sdk.platformtools.v.e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(4440861966336L, 33087);
      return;
    }
    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    ap.yY();
    paramp = bf.mz((String)com.tencent.mm.u.c.vr().get(65828, null));
    if ((localzi.mse == 1) && (!bf.mA(localzj.tsQ)) && (!localzj.tsQ.equals(paramp)))
    {
      ap.yY();
      com.tencent.mm.u.c.vr().set(65828, localzj.tsQ);
      af.Ga().Ff();
    }
    if (localzj.mrh == null)
    {
      com.tencent.mm.sdk.platformtools.v.e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  friendlist null");
      GMTrace.o(4440861966336L, 33087);
      return;
    }
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneGetMFriend", "onGYNetEnd friend list size:%d", new Object[] { Integer.valueOf(localzj.mrh.size()) });
    ap.yY();
    long l = com.tencent.mm.u.c.wO().cs(Thread.currentThread().getId());
    paramInt1 = 0;
    if (paramInt1 < localzj.mrh.size())
    {
      aju localaju = (aju)localzj.mrh.get(paramInt1);
      if (localaju == null) {
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.NetSceneGetMFriend", "Err getFriendList null");
      }
      b localb;
      h localh;
      for (;;)
      {
        paramInt1 += 1;
        break;
        localb = af.FZ().jb(localaju.hAk);
        if ((localb == null) && (localzi.mse != 1))
        {
          com.tencent.mm.sdk.platformtools.v.e("MicroMsg.NetSceneGetMFriend", "Err MD5 not found is AddrUploadStg, nickName: " + localaju.tLN + " md5: " + localaju.hAk);
        }
        else
        {
          ap.yY();
          com.tencent.mm.u.c.xB().eI(localaju.tfa, localaju.tAe);
          localh = new h();
          if (localzi.mse != 1) {
            break label944;
          }
          if (localaju.tLO != null) {
            break label509;
          }
          com.tencent.mm.sdk.platformtools.v.e("MicroMsg.NetSceneGetMFriend", "ERR: facebook friend return null info");
        }
      }
      label509:
      localh.gkj = localaju.tLO.oST;
      localh.hAF = localaju.tLO.tuK;
      com.tencent.mm.x.b.gY(localaju.tLO.oST);
      localh.hAE = localaju.tLO.mqI;
      localh.gtH = localaju.hAq;
      localh.gks = localaju.hAn;
      localh.gkr = localaju.hAm;
      localh.signature = localaju.hAo;
      localh.gkq = localaju.hAp;
      localh.gkh = localaju.hAl;
      localh.aIO = localaju.tLN;
      localh.hAe = com.tencent.mm.platformtools.c.mr(localaju.tLO.mqI);
      localh.hAf = com.tencent.mm.platformtools.c.mq(localaju.tLO.mqI);
      localh.username = localaju.tfa;
      label684:
      k localk = new k();
      localk.username = localaju.tfa;
      localk.gkr = localaju.hAm;
      localk.gks = localaju.hAn;
      localk.signature = localaju.hAo;
      localk.gkh = localaju.hAl;
      localk.gkq = localaju.hAp;
      paramp = null;
      if (!bf.mA(localaju.tfa))
      {
        ap.yY();
        paramArrayOfByte = com.tencent.mm.u.c.wR().Rb(localaju.tfa);
        if ((paramArrayOfByte == null) || (!localaju.tfa.equals(paramArrayOfByte.field_username))) {
          break label967;
        }
        paramp = paramArrayOfByte;
        if (!bf.mA(localaju.hAq))
        {
          paramp = paramArrayOfByte;
          if (!localaju.hAq.equals(paramArrayOfByte.pA()))
          {
            paramArrayOfByte.bO(localaju.hAq);
            ap.yY();
            com.tencent.mm.u.c.wR().a(paramArrayOfByte.field_username, paramArrayOfByte);
            paramp = paramArrayOfByte;
          }
        }
      }
      label876:
      boolean bool;
      if (bf.mA(localaju.tfa)) {
        if (localzi.mse == 1)
        {
          bool = true;
          label899:
          Assert.assertTrue("mobile friend never go here", bool);
          localh.status = 102;
        }
      }
      for (;;)
      {
        if (localzi.mse == 1) {
          af.Ga().a(localh);
        }
        af.Gb().a(localk);
        break;
        label944:
        if (!bf.mA(localaju.tfa)) {
          break label684;
        }
        com.tencent.mm.sdk.platformtools.v.w("MicroMsg.NetSceneGetMFriend", "username null for mobile");
        break;
        label967:
        paramp = null;
        break label876;
        bool = false;
        break label899;
        if ((paramp == null) || (!a.ez(paramp.field_type)))
        {
          localh.status = 100;
          if (localb != null)
          {
            com.tencent.mm.sdk.platformtools.v.v("MicroMsg.NetSceneGetMFriend", "onGYNetEnd update status on, nick:" + localaju.tLN + " realName:" + localb.ES() + "  MFriend:" + localaju.toString());
            localb.status = 1;
            localb.username = localaju.tfa;
            localb.aIO = localaju.tLN;
            localb.hAe = com.tencent.mm.platformtools.c.mr(localaju.tLO.mqI);
            localb.hAf = com.tencent.mm.platformtools.c.mq(localaju.tLO.mqI);
            localb.hAj = localb.sZ();
            a(localb, localaju);
            localb.fRM = -1;
            af.FZ().a(localb.EQ(), localb);
            paramp = new com.tencent.mm.x.h();
            paramp.username = localaju.tfa;
            paramp.hrk = localaju.tov;
            paramp.hrj = localaju.tow;
            paramp.aV(true);
            paramp.gkg = 3;
            n.Bm().a(paramp);
          }
        }
        else
        {
          localh.status = 101;
          if (localb != null)
          {
            com.tencent.mm.sdk.platformtools.v.v("MicroMsg.NetSceneGetMFriend", "onGYNetEnd update status friend, nick:" + localaju.tLN + "  md5:" + localaju.hAk);
            localb.status = 2;
            localb.username = localaju.tfa;
            localb.aIO = localaju.tLN;
            localb.hAj = localb.sZ();
            a(localb, localaju);
            localb.fRM = -1;
            af.FZ().a(localb.EQ(), localb);
            com.tencent.mm.x.b.u(localaju.tfa, 3);
          }
        }
      }
    }
    ap.yY();
    com.tencent.mm.u.c.wO().aD(l);
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(4440861966336L, 33087);
  }
  
  public final int getType()
  {
    GMTrace.i(4440727748608L, 33086);
    GMTrace.o(4440727748608L, 33086);
    return 32;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelfriend/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */