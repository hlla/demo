package com.tencent.mm.protocal;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.akq;
import com.tencent.mm.protocal.c.akr;
import com.tencent.mm.protocal.c.aks;
import com.tencent.mm.protocal.c.ave;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.bgb;
import com.tencent.mm.protocal.c.dr;
import com.tencent.mm.protocal.c.du;
import com.tencent.mm.protocal.c.dw;
import com.tencent.mm.protocal.c.dx;
import com.tencent.mm.protocal.c.ek;
import com.tencent.mm.protocal.c.en;
import com.tencent.mm.protocal.c.or;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.s;
import java.io.IOException;

public final class i
{
  public static final class a
    extends i.f
    implements k.b
  {
    public dw sXB;
    public String username;
    
    public a()
    {
      GMTrace.i(13571559784448L, 101116);
      this.sXB = new dw();
      GMTrace.o(13571559784448L, 101116);
    }
    
    public final String getUri()
    {
      GMTrace.i(13571962437632L, 101119);
      GMTrace.o(13571962437632L, 101119);
      return "/cgi-bin/micromsg-bin/autoauth";
    }
    
    public final byte[] zh()
    {
      GMTrace.i(13571694002176L, 101117);
      a.ea("");
      int j = this.sXQ;
      int i;
      Object localObject1;
      Object localObject2;
      Object localObject4;
      Object localObject3;
      int k;
      int m;
      if (j == 12)
      {
        i = 1;
        v.d("MicroMsg.AutoReq", "summerstatus[%d] clientUpgrade[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        this.sXU = ac.bHi();
        if ((10002 == r.iiC) && (r.iiD > 0))
        {
          r.iiD = 0;
          ac.G("", "", 0);
        }
        localObject1 = this.sXB.tgb;
        ((ave)localObject1).tXb = k.a(this);
        v.i("MicroMsg.AutoReq", "summerauth autoauth toProtoBuf[%d]", new Object[] { Integer.valueOf(this.sXM) });
        ((du)localObject1).tfT = com.tencent.mm.compatible.d.p.rA();
        ((du)localObject1).tfU = com.tencent.mm.plugin.normsg.a.d.nYa.qt(i);
        ((du)localObject1).tfV = 0;
        ((du)localObject1).tfW = a.uY();
        ((du)localObject1).hAo = bf.ep(aa.getContext());
        ((du)localObject1).jLB = d.sXf;
        ((du)localObject1).tfX = ba.bMM();
        ((du)localObject1).lda = u.bID();
        ((du)localObject1).lcZ = bf.bJI();
        h.vJ();
        localObject2 = (String)h.vI().gXM.get(18);
        v.d("MicroMsg.AutoReq", "summerecdh ksid:%s, flag:%d", new Object[] { localObject2, Integer.valueOf(((du)localObject1).tfS.tgP) });
        ((du)localObject1).tfS.tgN.tit = new avt().bb(bf.PS((String)localObject2));
        localObject1 = this.sXB.tga;
        localObject2 = new or();
        ((or)localObject2).tsC = 713;
        localObject4 = new PByteArray();
        localObject3 = new PByteArray();
        k = MMProtocalJni.generateECKey(((or)localObject2).tsC, (PByteArray)localObject4, (PByteArray)localObject3);
        localObject4 = ((PByteArray)localObject4).value;
        localObject3 = ((PByteArray)localObject3).value;
        aV((byte[])localObject3);
        m = ((or)localObject2).tsC;
        if (localObject4 != null) {
          break label510;
        }
        i = -1;
        label382:
        if (localObject3 != null) {
          break label517;
        }
      }
      label510:
      label517:
      for (j = -1;; j = localObject3.length)
      {
        v.d("MicroMsg.AutoReq", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), bf.bl((byte[])localObject4), bf.bl((byte[])localObject3) });
        ((or)localObject2).tfZ = new avt().bb((byte[])localObject4);
        ((dx)localObject1).tgd = ((or)localObject2);
        try
        {
          localObject1 = this.sXB.toByteArray();
          GMTrace.o(13571694002176L, 101117);
          return (byte[])localObject1;
        }
        catch (IOException localIOException)
        {
          v.e("MicroMsg.AutoReq", "summerauth toProtoBuf :%s", new Object[] { bf.g(localIOException) });
          GMTrace.o(13571694002176L, 101117);
        }
        h.vJ();
        i = h.vI().gXM.yv(46);
        break;
        i = localObject4.length;
        break label382;
      }
      return null;
    }
    
    public final int zi()
    {
      GMTrace.i(13571828219904L, 101118);
      GMTrace.o(13571828219904L, 101118);
      return 702;
    }
  }
  
  public static final class b
    extends i.g
    implements k.c
  {
    public b()
    {
      GMTrace.i(13590618701824L, 101258);
      GMTrace.o(13590618701824L, 101258);
    }
    
    public final int y(byte[] paramArrayOfByte)
    {
      GMTrace.i(13590752919552L, 101259);
      try
      {
        this.sXG = ((bgb)this.sXG.aD(paramArrayOfByte));
        k.a(this, this.sXG.tXs);
        this.sXI = 0;
        if ((this.sXG.tXs.tgr == 0) && ((this.sXG.ueM == null) || (this.sXG.ueM.lcP == 0) || (bf.bm(n.a(this.sXG.ueM.tfy)))))
        {
          v.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
          this.sXG.tXs.tgr = -1;
        }
        paramArrayOfByte = this.sXX;
        v.i("MicroMsg.MMAuth", "summerauthkick auto errmsg[%s]", new Object[] { paramArrayOfByte });
        a.ea(paramArrayOfByte);
        int i = this.sXG.tXs.tgr;
        GMTrace.o(13590752919552L, 101259);
        return i;
      }
      catch (IOException paramArrayOfByte)
      {
        v.e("MicroMsg.MMAuth", "toProtoBuf :%s", new Object[] { bf.g(paramArrayOfByte) });
        this.sXG.tXs.tgr = -1;
        GMTrace.o(13590752919552L, 101259);
      }
      return -1;
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(i.f paramf, i.g paramg, int paramInt1, int paramInt2, String paramString);
    
    public abstract com.tencent.mm.network.p aI(int paramInt1, int paramInt2);
    
    public abstract int zd();
    
    public static final class a
    {
      public static i.c sXC;
    }
  }
  
  public static final class d
    extends i.f
    implements k.b
  {
    public akr sXD;
    public boolean sXE;
    
    public d()
    {
      GMTrace.i(13599611289600L, 101325);
      this.sXD = new akr();
      this.sXE = false;
      GMTrace.o(13599611289600L, 101325);
    }
    
    public final String getUri()
    {
      GMTrace.i(13600013942784L, 101328);
      GMTrace.o(13600013942784L, 101328);
      return "/cgi-bin/micromsg-bin/manualauth";
    }
    
    public final byte[] zh()
    {
      GMTrace.i(13599745507328L, 101326);
      a.ea("");
      int j = this.sXQ;
      int i;
      Object localObject1;
      Object localObject2;
      or localor;
      Object localObject4;
      Object localObject3;
      int k;
      int m;
      if (j == 16)
      {
        i = 1;
        v.d("MicroMsg.ManualReq", "summerstatus[%d] clientUpgrade[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        if ((10002 == r.iiC) && (r.iiD > 0))
        {
          r.iiD = 0;
          ac.G("", "", 0);
        }
        this.sXU = ac.bHi();
        localObject1 = this.sXD.tMQ;
        ((ave)localObject1).tXb = k.a(this);
        ((akq)localObject1).tfT = com.tencent.mm.compatible.d.p.rA();
        ((akq)localObject1).tfU = com.tencent.mm.plugin.normsg.a.d.nYa.qt(i);
        ((akq)localObject1).tfV = 0;
        ((akq)localObject1).tfW = a.uY();
        ((akq)localObject1).hAo = bf.ep(aa.getContext());
        ((akq)localObject1).jLB = d.sXf;
        ((akq)localObject1).tfX = ba.bMM();
        ((akq)localObject1).lda = u.bID();
        ((akq)localObject1).lcZ = bf.bJI();
        ((akq)localObject1).taA = f.uqD;
        if ((10012 == r.iiC) && (r.iiD > 0)) {
          ((akq)localObject1).taA = r.iiD;
        }
        ((akq)localObject1).tjP = d.sXa;
        ((akq)localObject1).tjO = d.sXb;
        ((akq)localObject1).tML = d.sXc;
        ((akq)localObject1).tsE = com.tencent.mm.compatible.d.p.getSimCountryIso();
        h.vJ();
        localObject2 = (String)h.vI().gXM.get(18);
        v.d("MicroMsg.ManualReq", "summerauth ksid:%s authreq flag:%d", new Object[] { localObject2, Integer.valueOf(((akq)localObject1).tfS.tgP) });
        ((akq)localObject1).tfS.tgN.tit = new avt().bb(bf.PS((String)localObject2));
        localObject2 = this.sXD.tMP;
        ((aks)localObject2).thY = new avt().bb(bf.bJG());
        localor = new or();
        localor.tsC = 713;
        localObject4 = new PByteArray();
        localObject3 = new PByteArray();
        k = MMProtocalJni.generateECKey(localor.tsC, (PByteArray)localObject4, (PByteArray)localObject3);
        localObject4 = ((PByteArray)localObject4).value;
        localObject3 = ((PByteArray)localObject3).value;
        aV((byte[])localObject3);
        m = localor.tsC;
        if (localObject4 != null) {
          break label720;
        }
        i = -1;
        label443:
        if (localObject3 != null) {
          break label727;
        }
      }
      label720:
      label727:
      for (j = -1;; j = localObject3.length)
      {
        v.d("MicroMsg.ManualReq", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), bf.bl((byte[])localObject4), bf.bl((byte[])localObject3) });
        localor.tfZ = new avt().bb((byte[])localObject4);
        ((aks)localObject2).tgd = localor;
        v.i("MicroMsg.ManualReq", "summerauth IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d] DeviceBrand:%s DeviceModel:%s OSType:%s RealCountry:%s", new Object[] { ((akq)localObject1).tfT, ((akq)localObject1).tfU, ((akq)localObject1).tfW, ((akq)localObject1).hAo, ((akq)localObject1).jLB, ((akq)localObject1).tfX, ((akq)localObject1).lda, ((akq)localObject1).lcZ, Integer.valueOf(((akq)localObject1).taA), Integer.valueOf(f.fuN), ((akq)localObject1).tjP, ((akq)localObject1).tjO, ((akq)localObject1).tML, ((akq)localObject1).tsE });
        try
        {
          localObject1 = this.sXD.toByteArray();
          GMTrace.o(13599745507328L, 101326);
          return (byte[])localObject1;
        }
        catch (IOException localIOException)
        {
          v.e("MicroMsg.ManualReq", "summerauth toProtoBuf :%s", new Object[] { bf.g(localIOException) });
          GMTrace.o(13599745507328L, 101326);
        }
        if (this.sXE)
        {
          i = 3;
          break;
        }
        h.vJ();
        i = h.vI().gXM.yv(46);
        break;
        i = localObject4.length;
        break label443;
      }
      return null;
    }
    
    public final int zi()
    {
      GMTrace.i(13599879725056L, 101327);
      GMTrace.o(13599879725056L, 101327);
      return 701;
    }
  }
  
  public static final class e
    extends i.g
    implements k.c
  {
    public e()
    {
      GMTrace.i(13586592169984L, 101228);
      GMTrace.o(13586592169984L, 101228);
    }
    
    public final int y(byte[] paramArrayOfByte)
    {
      GMTrace.i(13586726387712L, 101229);
      try
      {
        this.sXG = ((bgb)this.sXG.aD(paramArrayOfByte));
        k.a(this, this.sXG.tXs);
        this.sXI = 0;
        if ((this.sXG.tXs.tgr == 0) && ((this.sXG.ueM == null) || (this.sXG.ueM.lcP == 0) || (bf.bm(n.a(this.sXG.ueM.tfy)))))
        {
          v.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
          this.sXG.tXs.tgr = -1;
        }
        paramArrayOfByte = this.sXX;
        v.i("MicroMsg.MMAuth", "summerauthkick manual errmsg[%s]", new Object[] { paramArrayOfByte });
        a.ea(paramArrayOfByte);
        int i = this.sXG.tXs.tgr;
        GMTrace.o(13586726387712L, 101229);
        return i;
      }
      catch (IOException paramArrayOfByte)
      {
        v.e("MicroMsg.MMAuth", "toProtoBuf :%s", new Object[] { bf.g(paramArrayOfByte) });
        this.sXG.tXs.tgr = -1;
        GMTrace.o(13586726387712L, 101229);
      }
      return -1;
    }
  }
  
  public static abstract class f
    extends k.d
    implements k.b
  {
    public byte[] sXF;
    
    public f()
    {
      GMTrace.i(13603235168256L, 101352);
      GMTrace.o(13603235168256L, 101352);
    }
    
    public final void aV(byte[] paramArrayOfByte)
    {
      GMTrace.i(13603369385984L, 101353);
      if (paramArrayOfByte != null) {}
      for (;;)
      {
        this.sXF = paramArrayOfByte;
        GMTrace.o(13603369385984L, 101353);
        return;
        paramArrayOfByte = new byte[0];
      }
    }
    
    public abstract String getUri();
  }
  
  public static abstract class g
    extends k.e
    implements k.c
  {
    public byte[] idE;
    public String idH;
    public bgb sXG;
    public byte[] sXH;
    public int sXI;
    
    public g()
    {
      GMTrace.i(13602966732800L, 101350);
      this.sXG = new bgb();
      this.sXI = 0;
      GMTrace.o(13602966732800L, 101350);
    }
    
    public final void aW(byte[] paramArrayOfByte)
    {
      GMTrace.i(13603100950528L, 101351);
      if (paramArrayOfByte != null) {}
      for (;;)
      {
        this.idE = paramArrayOfByte;
        GMTrace.o(13603100950528L, 101351);
        return;
        paramArrayOfByte = new byte[0];
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */