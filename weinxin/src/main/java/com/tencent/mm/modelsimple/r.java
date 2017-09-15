package com.tencent.mm.modelsimple;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.qz;
import com.tencent.mm.e.a.rb;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aaj;
import com.tencent.mm.protocal.c.aak;
import com.tencent.mm.protocal.c.amt;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.bih;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.m;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;

public final class r
  extends k
  implements j
{
  private b gUq;
  private com.tencent.mm.y.e gUt;
  private String hRY;
  
  public r(String paramString)
  {
    GMTrace.i(13160450883584L, 98053);
    this.hRY = paramString;
    b.a locala = new b.a();
    locala.hrV = new aaj();
    locala.hrW = new aak();
    locala.uri = "/cgi-bin/micromsg-bin/getprofile";
    locala.hrU = 302;
    locala.hrX = 0;
    locala.hrY = 0;
    this.gUq = locala.BE();
    ((aaj)this.gUq.hrS.hsa).jLx = paramString;
    GMTrace.o(13160450883584L, 98053);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(13160719319040L, 98055);
    if (bf.mA(this.hRY))
    {
      v.e("MicroMsg.NetSceneGetProfile", "null or empty username");
      GMTrace.o(13160719319040L, 98055);
      return -1;
    }
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(13160719319040L, 98055);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(13160853536768L, 98056);
    v.d("MicroMsg.NetSceneGetProfile", "get profile ret: errType=" + paramInt2 + " errCode=" + paramInt3 + " errMsg=" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramp = (aak)this.gUq.hrT.hsa;
      paramArrayOfByte = new rb();
      paramArrayOfByte.fXQ.fXR = paramp;
      a.uql.m(paramArrayOfByte);
      paramArrayOfByte = new qz();
      paramArrayOfByte.fXO.fXP = paramp.tEH.ugy;
      a.uql.m(paramArrayOfByte);
      if ((m.xL().equals(paramp.tEG.trH.toString())) && (!bf.mA(paramp.tEH.tow))) {
        h.vI().vr().a(w.a.uyw, paramp.tEH.tow);
      }
      v.d("MicroMsg.NetSceneGetProfile", "summersafecdn resp.UserInfo.PluginSwitch[%d], GrayscaleFlag[%d]", new Object[] { Integer.valueOf(paramp.tEG.tPM), Integer.valueOf(paramp.tEH.ugs) });
      h.vI().vr().set(64, Integer.valueOf(paramp.tEH.tbY));
      h.vI().vr().set(144385, Integer.valueOf(paramp.tEH.ugs));
      h.vI().vr().set(40, Integer.valueOf(paramp.tEG.tPM));
      h.vI().vr().set(339975, Integer.valueOf(paramp.tEH.ugA));
      v.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d", new Object[] { Integer.valueOf(paramp.tEH.ugA) });
      h.vI().vr().a(w.a.uCm, Integer.valueOf(paramp.tEH.ugB));
      v.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d %d", new Object[] { Integer.valueOf(paramp.tEH.ugA), Integer.valueOf(paramp.tEH.ugB) });
      h.vI().vr().set(208903, paramp.tEH.thE);
      h.vI().vr().set(274433, paramp.tEH.tPb);
      h.vI().vr().set(274434, paramp.tEH.tPa);
      h.vI().vr().set(274436, paramp.tEH.ugt);
      h.vI().vr().a(w.a.uAu, bf.ap(paramp.tEH.gkF, ""));
      h.vI().vr().a(w.a.uEh, paramp.tEH.ugD);
      v.d("MicroMsg.NetSceneGetProfile", "weidianInfo:%s", new Object[] { paramp.tEH.gkF });
      ao.hlE.L("last_login_use_voice", paramp.tEG.tPM);
      if (Build.VERSION.SDK_INT < 23) {
        Settings.System.putString(aa.getContext().getContentResolver(), "89884a87498ef44f", paramp.tEH.ugz);
      }
    }
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(13160853536768L, 98056);
  }
  
  public final int getType()
  {
    GMTrace.i(13160585101312L, 98054);
    GMTrace.o(13160585101312L, 98054);
    return 302;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsimple/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */