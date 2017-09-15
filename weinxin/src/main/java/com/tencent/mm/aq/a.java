package com.tencent.mm.aq;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.aap;
import com.tencent.mm.protocal.c.aaq;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.m;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;

public final class a
  extends k
  implements j
{
  private final b gUq;
  private com.tencent.mm.y.e gUt;
  public String hOj;
  public String hOk;
  public byte[] hOl;
  
  public a()
  {
    this(m.xL(), bf.f((Integer)h.vI().vr().get(66561, null)), 0);
    GMTrace.i(12953621364736L, 96512);
    GMTrace.o(12953621364736L, 96512);
  }
  
  public a(String paramString, int paramInt)
  {
    this(paramString, paramInt, 0);
    GMTrace.i(12953755582464L, 96513);
    GMTrace.o(12953755582464L, 96513);
  }
  
  public a(String paramString, int paramInt1, int paramInt2)
  {
    GMTrace.i(16867007660032L, 125669);
    this.gUt = null;
    this.hOj = null;
    this.hOk = null;
    this.hOl = null;
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new aap();
    ((b.a)localObject).hrW = new aaq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getqrcode";
    ((b.a)localObject).hrU = 168;
    ((b.a)localObject).hrX = 67;
    ((b.a)localObject).hrY = 1000000067;
    this.gUq = ((b.a)localObject).BE();
    localObject = (aap)this.gUq.hrS.hsa;
    ((aap)localObject).trH = n.mw(paramString);
    ((aap)localObject).tES = paramInt1;
    ((aap)localObject).tay = paramInt2;
    v.i("MicroMsg.NetSceneGetQRCode", "username:%s, style:%d, opcode:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    GMTrace.o(16867007660032L, 125669);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(12953889800192L, 96514);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(12953889800192L, 96514);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(12954158235648L, 96516);
    v.d("MicroMsg.NetSceneGetQRCode", "onGYNetEnd errType:" + paramInt2 + " errCode" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = (aap)this.gUq.hrS.hsa;
      paramp = (aaq)this.gUq.hrT.hsa;
      paramArrayOfByte = n.a(paramArrayOfByte.trH);
      this.hOl = n.a(paramp.tET, new byte[0]);
      this.hOj = paramp.tEU;
      v.i("MicroMsg.NetSceneGetQRCode", "expiredWording:%s, revokeId:%s, revokeWording:%s", new Object[] { this.hOj, paramp.tEV, paramp.tEW });
      if (m.xL().equals(paramArrayOfByte))
      {
        paramArrayOfByte = paramp.tEV;
        String str = (String)h.vI().vr().get(66563, "");
        if ((paramArrayOfByte != null) && (!str.equals(paramArrayOfByte)))
        {
          h.vI().vr().set(66563, paramArrayOfByte);
          this.hOk = paramp.tEW;
        }
        h.vI().vr().set(66561, Integer.valueOf(paramp.tES));
      }
    }
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(12954158235648L, 96516);
  }
  
  public final int getType()
  {
    GMTrace.i(12954024017920L, 96515);
    GMTrace.o(12954024017920L, 96515);
    return 168;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/aq/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */