package com.tencent.mm.sandbox.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.b.i;
import com.tencent.mm.modelsimple.ak;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sandbox.SubCoreSandBox;
import com.tencent.mm.pluginsdk.l.u;
import com.tencent.mm.protocal.c.abw;
import com.tencent.mm.protocal.c.abx;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.LinkedList;

public final class a
  extends k
  implements j, l.u
{
  public final b gUq;
  private com.tencent.mm.y.e gUt;
  
  public a(int paramInt)
  {
    GMTrace.i(3557172445184L, 26503);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new abw();
    ((b.a)localObject).hrW = new abx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getupdateinfo";
    ((b.a)localObject).hrU = 113;
    ((b.a)localObject).hrX = 35;
    ((b.a)localObject).hrY = 1000000035;
    this.gUq = ((b.a)localObject).BE();
    localObject = (abw)this.gUq.hrS.hsa;
    ((abw)localObject).tFN = paramInt;
    ((abw)localObject).taA = f.fuN;
    if ((10012 == r.iiC) && (r.iiD > 0)) {
      ((abw)localObject).taA = r.iiD;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      v.i("MicroMsg.NetSceneGetUpdateInfo", "summerupdate dkchan NetSceneGetUpdateInfo updateType:%d channel:%d release:%d, stack[%s]", new Object[] { Integer.valueOf(((abw)localObject).tFN), Integer.valueOf(((abw)localObject).taA), Integer.valueOf(f.fuN), bf.bJP() });
      GMTrace.o(3557172445184L, 26503);
      return;
      g.oSF.a(405L, 3L, 1L, true);
      continue;
      g.oSF.a(405L, 4L, 1L, true);
      continue;
      g.oSF.a(405L, 5L, 1L, true);
      continue;
      g.oSF.a(405L, 6L, 1L, true);
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(3557306662912L, 26504);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(3557306662912L, 26504);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(3557575098368L, 26506);
    v.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken GetUpdateInfo onGYNetEnd errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      g.oSF.a(405L, 7L, 1L, true);
    }
    for (;;)
    {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      paramString = bHA();
      if (paramString == null) {
        break;
      }
      paramInt1 = i.bc(paramString).versionCode;
      v.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchVersionCode[%d]", new Object[] { Integer.valueOf(paramInt1) });
      ap.vd().a(new ak(aa.getPackageName(), paramInt1), 0);
      g.oSF.a(405L, 13L, 1L, true);
      GMTrace.o(3557575098368L, 26506);
      return;
      g.oSF.a(405L, 8L, 1L, true);
      if (paramInt2 == 4)
      {
        g.oSF.a(405L, 9L, 1L, true);
        if (paramInt3 == -16) {
          g.oSF.a(405L, 10L, 1L, true);
        } else if (paramInt3 == -17) {
          g.oSF.a(405L, 11L, 1L, true);
        } else if (paramInt3 == -18) {
          g.oSF.a(405L, 12L, 1L, true);
        }
      }
    }
    v.w("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchXml is null!");
    g.oSF.a(405L, 14L, 1L, true);
    GMTrace.o(3557575098368L, 26506);
  }
  
  public final int bCh()
  {
    GMTrace.i(3557977751552L, 26509);
    int i = ((abx)this.gUq.hrT.hsa).tFO;
    GMTrace.o(3557977751552L, 26509);
    return i;
  }
  
  public final String[] bCi()
  {
    GMTrace.i(3558111969280L, 26510);
    abx localabx = (abx)this.gUq.hrT.hsa;
    String[] arrayOfString = new String[localabx.tFT.size()];
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      arrayOfString[i] = ((avu)localabx.tFT.get(i)).tXF;
      i += 1;
    }
    GMTrace.o(3558111969280L, 26510);
    return arrayOfString;
  }
  
  public final abx bCj()
  {
    int i = 1;
    GMTrace.i(3558380404736L, 26512);
    abx localabx;
    if (SubCoreSandBox.oTV)
    {
      localabx = (abx)this.gUq.hrT.hsa;
      localabx.tFV = 1;
      localabx.tFW = "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";
      if (!SubCoreSandBox.oTW) {
        break label79;
      }
    }
    for (;;)
    {
      localabx.tFX = i;
      localabx = (abx)this.gUq.hrT.hsa;
      GMTrace.o(3558380404736L, 26512);
      return localabx;
      label79:
      i = 0;
    }
  }
  
  public final String bHA()
  {
    GMTrace.i(3558246187008L, 26511);
    Object localObject = (abx)this.gUq.hrT.hsa;
    v.d("MicroMsg.NetSceneGetUpdateInfo", "summertoken getPatchInfo[%s], stack[%s]", new Object[] { ((abx)localObject).tFU, bf.bJP() });
    localObject = ((abx)localObject).tFU;
    GMTrace.o(3558246187008L, 26511);
    return (String)localObject;
  }
  
  public final int bHy()
  {
    GMTrace.i(3557709316096L, 26507);
    int i = ((abx)this.gUq.hrT.hsa).tFQ;
    GMTrace.o(3557709316096L, 26507);
    return i;
  }
  
  public final String bHz()
  {
    GMTrace.i(3557843533824L, 26508);
    String str = ((abx)this.gUq.hrT.hsa).tFP;
    GMTrace.o(3557843533824L, 26508);
    return str;
  }
  
  public final int getType()
  {
    GMTrace.i(3557440880640L, 26505);
    GMTrace.o(3557440880640L, 26505);
    return 11;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sandbox/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */