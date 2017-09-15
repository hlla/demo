package com.tencent.mm.modelsimple;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.o;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.biv;
import com.tencent.mm.protocal.c.biw;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.m;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;

public final class ai
  extends k
  implements j
{
  public com.tencent.mm.y.b gUq;
  private com.tencent.mm.y.e gUt;
  public long htM;
  
  public ai(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt2)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramString4, paramBoolean, paramInt2, true);
    GMTrace.i(13292521127936L, 99037);
    GMTrace.o(13292521127936L, 99037);
  }
  
  public ai(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    GMTrace.i(13292655345664L, 99038);
    this.htM = 0L;
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new biv();
    ((b.a)localObject).hrW = new biw();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/newverifypasswd";
    ((b.a)localObject).hrU = 384;
    ((b.a)localObject).hrX = 182;
    ((b.a)localObject).hrY = 1000000182;
    this.gUq = ((b.a)localObject).BE();
    localObject = (biv)this.gUq.hrS.hsa;
    ((biv)localObject).tay = paramInt1;
    ((biv)localObject).tYY = paramInt2;
    ((biv)localObject).ugO = bf.PR(paramString1);
    ((biv)localObject).tio = bf.PQ(paramString1);
    ((biv)localObject).tGC = new avu().OU(paramString2);
    ((biv)localObject).ugP = new avu().OU(paramString3);
    ((biv)localObject).tis = new avu().OU(paramString4);
    if ((paramInt1 == 5) || (paramInt1 == 2))
    {
      this.htM = new o(m.xK()).longValue();
      if (paramBoolean1)
      {
        paramString1 = h.vG().gWS.b(this.htM, paramString3);
        ((biv)localObject).tgM = new avt().bb(paramString1);
      }
    }
    else
    {
      paramString1 = bf.mz((String)h.vI().vr().get(47, null));
      ((biv)localObject).tit = new avt().bb(bf.PS(paramString1));
      paramInt2 = ((biv)localObject).tay;
      if (((biv)localObject).tgM != null) {
        break label393;
      }
      paramInt1 = -1;
      label304:
      if (((biv)localObject).tgM != null) {
        break label405;
      }
    }
    label393:
    label405:
    for (paramString1 = "null";; paramString1 = bf.Qi(bf.bl(((biv)localObject).tgM.tXD.sWU)))
    {
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneVerifyPswd", "summerauth opCode[%d], hasSecCode[%b], isManualAuth[%b], len:%d, content:[%s]", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt1), paramString1 });
      GMTrace.o(13292655345664L, 99038);
      return;
      paramString1 = h.vG().gWS.a(this.htM, bf.PR(paramString1), paramBoolean2);
      break;
      paramInt1 = ((biv)localObject).tgM.tXB;
      break label304;
    }
  }
  
  public ai(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(1, paramString1, paramString2, paramString3, paramString4, false, 0);
    GMTrace.i(13292386910208L, 99036);
    GMTrace.o(13292386910208L, 99036);
  }
  
  public final String Fv()
  {
    GMTrace.i(13293057998848L, 99041);
    try
    {
      String str = ((biw)this.gUq.hrT.hsa).tsG;
      GMTrace.o(13293057998848L, 99041);
      return str;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.v.printErrStackTrace("MicroMsg.NetSceneVerifyPswd", localException, "", new Object[0]);
      GMTrace.o(13293057998848L, 99041);
    }
    return null;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(13292789563392L, 99039);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(13292789563392L, 99039);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(13293192216576L, 99042);
    paramArrayOfByte = (biv)this.gUq.hrS.hsa;
    paramp = (biw)this.gUq.hrT.hsa;
    if ((paramp.tfB != null) && (paramp.tfB.tXB > 0)) {
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneVerifyPswd", "summerauth parseRet[%b], len[%d]", new Object[] { Boolean.valueOf(h.vG().gWS.a(this.htM, n.a(paramp.tfB))), Integer.valueOf(paramp.tfB.tXB) });
    }
    int i;
    label267:
    int j;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      h.vI().vr().set(77830, paramp.tsG);
      h.vI().vr().set(32, paramArrayOfByte.ugO);
      h.vI().vr().set(33, paramArrayOfByte.tio);
      h.vI().vr().set(46, bf.bo(n.a(paramp.tfH)));
      paramArrayOfByte = bf.bo(n.a(paramArrayOfByte.tit));
      h.vI().vr().set(47, paramArrayOfByte);
      h.vI().gXM.set(18, paramArrayOfByte);
      h.vI().vr().set(-1535680990, paramp.tfG);
      if (paramp.tfH == null)
      {
        paramInt1 = 0;
        if (paramp.tfG != null) {
          break label349;
        }
        i = 0;
        if (paramp.tsG != null) {
          break label362;
        }
        j = 0;
        label278:
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneVerifyPswd", "A2Key.len %d, authKey.len: %d, ticketLen:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(j) });
      }
    }
    for (;;)
    {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(13293192216576L, 99042);
      return;
      paramInt1 = paramp.tfH.tXB;
      break;
      label349:
      i = paramp.tfG.length();
      break label267;
      label362:
      j = paramp.tsG.length();
      break label278;
      if (paramInt2 == 4)
      {
        h.vI().vr().set(32, "");
        h.vI().vr().set(33, "");
      }
    }
  }
  
  public final int getType()
  {
    GMTrace.i(13292923781120L, 99040);
    GMTrace.o(13292923781120L, 99040);
    return 384;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsimple/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */