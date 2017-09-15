package com.tencent.mm.modelsimple;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bqu;
import com.tencent.mm.protocal.c.bqv;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;

public final class ak
  extends k
  implements j
{
  private com.tencent.mm.y.e gUt;
  private final b hRy;
  private int retryCount;
  
  public ak(String paramString, int paramInt)
  {
    GMTrace.i(1350096125952L, 10059);
    this.retryCount = 3;
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new bqu();
    ((b.a)localObject).hrW = new bqv();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/yybgetpkgsig";
    ((b.a)localObject).hrU = 729;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.hRy = ((b.a)localObject).BE();
    localObject = (bqu)this.hRy.hrS.hsa;
    ((bqu)localObject).lda = u.bID();
    ((bqu)localObject).tfU = d.nYa.qt(0);
    ((bqu)localObject).unk = paramString;
    ((bqu)localObject).mqM = paramInt;
    v.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig Language[%s], PkgName[%s], versionCode[%d], stack[%s]", new Object[] { ((bqu)localObject).lda, paramString, Integer.valueOf(paramInt), bf.bJP() });
    GMTrace.o(1350096125952L, 10059);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(1350364561408L, 10061);
    this.gUt = parame1;
    int i = a(parame, this.hRy, this);
    GMTrace.o(1350364561408L, 10061);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(1350498779136L, 10062);
    paramp = (bqu)this.hRy.hrS.hsa;
    paramArrayOfByte = (bqv)this.hRy.hrT.hsa;
    v.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s], ret[%d], sig[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(paramArrayOfByte.unl), paramArrayOfByte.unm });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      v.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig err and return!");
      g.oSF.a(322L, 1L, 1L, false);
      g.oSF.i(11098, new Object[] { Integer.valueOf(4001), String.format("%s,%d,%d,%d", new Object[] { paramp.unk, Integer.valueOf(paramp.mqM), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }) });
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(1350498779136L, 10062);
      return;
    }
    if ((paramArrayOfByte.unl == 2) || (paramArrayOfByte.unl == 3))
    {
      this.retryCount -= 1;
      if (this.retryCount <= 0)
      {
        v.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken err and return with no try!");
        g.oSF.a(322L, 2L, 1L, false);
        g.oSF.i(11098, new Object[] { Integer.valueOf(4002), String.format("%s,%d", new Object[] { paramp.unk, Integer.valueOf(paramp.mqM) }) });
        this.gUt.a(3, -1, "", this);
        GMTrace.o(1350498779136L, 10062);
        return;
      }
      v.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken do scene again retryCount:%d", new Object[] { Integer.valueOf(this.retryCount) });
      a(this.hsm, this.gUt);
    }
    for (;;)
    {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(1350498779136L, 10062);
      return;
      if (paramArrayOfByte.unl == 1)
      {
        MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "yyb_pkg_sig_prefs", 4).edit().remove(paramp.unk).commit();
        g.oSF.a(322L, 5L, 1L, false);
        g.oSF.i(11098, new Object[] { Integer.valueOf(4005), String.format("%s,%d", new Object[] { paramp.unk, Integer.valueOf(paramp.mqM) }) });
        v.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no sig[%s] and remove", new Object[] { paramArrayOfByte.unm });
      }
      else if (paramArrayOfByte.unl == 4)
      {
        v.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no need try and revise");
        g.oSF.a(322L, 4L, 1L, false);
        g.oSF.i(11098, new Object[] { Integer.valueOf(4004), String.format("%s,%d", new Object[] { paramp.unk, Integer.valueOf(paramp.mqM) }) });
      }
      else
      {
        v.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret sig[%s]", new Object[] { paramArrayOfByte.unm });
        MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "yyb_pkg_sig_prefs", 4).edit().putString(paramp.unk, paramArrayOfByte.unm).commit();
        g.oSF.a(322L, 3L, 1L, false);
        g.oSF.i(11098, new Object[] { Integer.valueOf(4003), String.format("%s,%d,%s", new Object[] { paramp.unk, Integer.valueOf(paramp.mqM), paramArrayOfByte.unm }) });
      }
    }
  }
  
  public final int getType()
  {
    GMTrace.i(1350230343680L, 10060);
    GMTrace.o(1350230343680L, 10060);
    return 729;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsimple/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */