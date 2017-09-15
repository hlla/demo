package com.tencent.mm.z;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.o;
import com.tencent.mm.e.a.rb;
import com.tencent.mm.e.a.rc;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.gf;
import com.tencent.mm.protocal.c.gg;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;

public final class a
  extends k
  implements j
{
  private String fMB;
  private String fMD;
  public final com.tencent.mm.y.b gUq;
  private com.tencent.mm.y.e gUt;
  public long htM;
  
  public a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, boolean paramBoolean)
  {
    GMTrace.i(4495891234816L, 33497);
    this.htM = 0L;
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new gf();
    ((b.a)localObject).hrW = new gg();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bindqq";
    ((b.a)localObject).hrU = 144;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    this.htM = paramLong;
    localObject = (gf)this.gUq.hrS.hsa;
    ((gf)localObject).tin = new o(paramLong).intValue();
    ((gf)localObject).tie = "";
    ((gf)localObject).tio = "";
    ((gf)localObject).tip = "";
    ((gf)localObject).tiq = "";
    ((gf)localObject).tis = new avu().OU("");
    ((gf)localObject).tir = 1;
    if (paramBoolean == true) {}
    for (paramString1 = ap.yV().b(paramLong, paramString3);; paramString1 = ap.yV().a(paramLong, bf.PR(paramString1), true))
    {
      ((gf)localObject).tgM = new avt().bb(paramString1);
      ap.yY();
      String str = bf.mz((String)c.vr().get(47, null));
      ((gf)localObject).tit = new avt().bb(bf.PS(str));
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneBindQQ", "init opcode:%d qq:%d  wtbuf:%d img[%s,%s,%s] ksid:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(bf.bn(paramString1)), paramString3, paramString2, paramString4, str });
      GMTrace.o(4495891234816L, 33497);
      return;
    }
  }
  
  public a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean)
  {
    this(paramLong, paramString1, paramString2, paramString3, paramString4, 1, paramBoolean);
    GMTrace.i(4496025452544L, 33498);
    this.fMB = paramString5;
    this.fMD = paramString6;
    paramString1 = (gf)this.gUq.hrS.hsa;
    paramString1.thW = paramString5;
    paramString1.thX = paramString6;
    GMTrace.o(4496025452544L, 33498);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4496159670272L, 33499);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(4496159670272L, 33499);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4496428105728L, 33501);
    paramp = (gf)this.gUq.hrS.hsa;
    paramArrayOfByte = (gg)this.gUq.hrT.hsa;
    Object localObject = n.a(paramArrayOfByte.tfB);
    boolean bool1 = false;
    if (!bf.bm((byte[])localObject)) {
      bool1 = ap.yV().a(new o(paramp.tin).longValue(), (byte[])localObject);
    }
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd[%d,%d] wtret:%b wtRespBuf:%d imgsid:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(bool1), Integer.valueOf(bf.bn((byte[])localObject)), paramArrayOfByte.tip });
    boolean bool2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ap.yY();
      c.vr().set(9, Integer.valueOf(paramp.tin));
      if (paramp.tir == 1)
      {
        ap.yY();
        c.vr().set(17, Integer.valueOf(paramArrayOfByte.tcb));
      }
      ap.yY();
      localObject = c.wZ();
      String str = paramArrayOfByte.tiw;
      if (paramArrayOfByte.tiv == 1)
      {
        bool2 = true;
        ((f)localObject).ab(str, bool2);
        paramInt1 = paramp.tin;
        if (paramInt1 != 0)
        {
          ap.yY();
          c.wZ().bo(new o(paramInt1) + "@qqim", 3);
        }
        com.tencent.mm.x.b.d(paramInt1, 3);
        ap.yY();
        c.vr().set(32, paramp.tie);
        ap.yY();
        c.vr().set(33, paramp.tio);
        localObject = bf.bo(ap.yV().S(new o(paramp.tin).longValue()));
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd wtret:%b newa2key:%s ", new Object[] { Boolean.valueOf(bool1), bf.Qi((String)localObject) });
        ap.yY();
        c.vr().set(72, localObject);
        ap.yY();
        c.vr().set(46, bf.bo(n.a(paramArrayOfByte.tfH)));
        localObject = bf.bo(n.a(paramp.tit));
        ap.yY();
        c.vr().set(47, localObject);
        ap.yW().set(18, localObject);
        ap.yY();
        c.vr().set(-1535680990, paramArrayOfByte.tix);
        if ((!bf.mA(this.fMB)) && (!bf.mA(this.fMD)))
        {
          ap.yY();
          c.vr().set(64, Integer.valueOf(paramArrayOfByte.tbY));
          localObject = new rb();
          ((rb)localObject).fXQ.fXR = paramArrayOfByte;
          com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
          paramArrayOfByte = new rc();
          paramArrayOfByte.fXS.fXT = true;
          paramArrayOfByte.fXS.fXU = true;
          com.tencent.mm.sdk.b.a.uql.m(paramArrayOfByte);
        }
      }
    }
    for (;;)
    {
      paramInt1 = paramInt3;
      if (paramp.tir == 3)
      {
        paramInt1 = paramInt3;
        if (paramInt3 == -3)
        {
          paramInt1 = 10000;
          com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneBindQQ", "onGYNetEnd : retCode = 10000");
        }
      }
      this.gUt.a(paramInt2, paramInt1, paramString, this);
      GMTrace.o(4496428105728L, 33501);
      return;
      bool2 = false;
      break;
      if (paramInt2 == 4)
      {
        ap.yY();
        c.vr().set(32, "");
        ap.yY();
        c.vr().set(33, "");
      }
    }
  }
  
  public final int getType()
  {
    GMTrace.i(4496293888000L, 33500);
    GMTrace.o(4496293888000L, 33500);
    return 144;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/z/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */