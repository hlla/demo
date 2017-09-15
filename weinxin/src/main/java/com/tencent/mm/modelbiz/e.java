package com.tencent.mm.modelbiz;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.af;
import com.tencent.mm.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.a;
import com.tencent.mm.protocal.c.alu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.ay.3;
import java.util.List;

public final class e
{
  public static boolean Dn()
  {
    GMTrace.i(4554812817408L, 33936);
    if (w.DH().fx(1) > 0)
    {
      GMTrace.o(4554812817408L, 33936);
      return true;
    }
    GMTrace.o(4554812817408L, 33936);
    return false;
  }
  
  public static List<String> Do()
  {
    GMTrace.i(4554947035136L, 33937);
    List localList = w.DH().fw(2);
    GMTrace.o(4554947035136L, 33937);
    return localList;
  }
  
  public static boolean Dp()
  {
    GMTrace.i(4555081252864L, 33938);
    if (w.DH().fx(4) > 0)
    {
      GMTrace.o(4555081252864L, 33938);
      return true;
    }
    GMTrace.o(4555081252864L, 33938);
    return false;
  }
  
  public static boolean Dq()
  {
    GMTrace.i(4555215470592L, 33939);
    if (w.DH().fx(8) > 0)
    {
      GMTrace.o(4555215470592L, 33939);
      return true;
    }
    GMTrace.o(4555215470592L, 33939);
    return false;
  }
  
  public static List<String> Dr()
  {
    GMTrace.i(4555349688320L, 33940);
    List localList = w.DH().fw(16);
    GMTrace.o(4555349688320L, 33940);
    return localList;
  }
  
  public static boolean Ds()
  {
    GMTrace.i(4555483906048L, 33941);
    if (w.DH().fx(16) > 0)
    {
      GMTrace.o(4555483906048L, 33941);
      return true;
    }
    GMTrace.o(4555483906048L, 33941);
    return false;
  }
  
  public static List<String> Dt()
  {
    GMTrace.i(4555618123776L, 33942);
    List localList = w.DH().fw(32);
    GMTrace.o(4555618123776L, 33942);
    return localList;
  }
  
  public static boolean Du()
  {
    GMTrace.i(4555752341504L, 33943);
    if (w.DH().fx(64) > 0)
    {
      GMTrace.o(4555752341504L, 33943);
      return true;
    }
    GMTrace.o(4555752341504L, 33943);
    return false;
  }
  
  public static List<String> Dv()
  {
    GMTrace.i(4555886559232L, 33944);
    List localList = w.DH().fw(128);
    GMTrace.o(4555886559232L, 33944);
    return localList;
  }
  
  public static boolean Dw()
  {
    GMTrace.i(4556020776960L, 33945);
    if (w.DH().fx(128) > 0)
    {
      GMTrace.o(4556020776960L, 33945);
      return true;
    }
    GMTrace.o(4556020776960L, 33945);
    return false;
  }
  
  public static boolean Dx()
  {
    GMTrace.i(4556154994688L, 33946);
    if (w.DH().fx(256) > 0)
    {
      GMTrace.o(4556154994688L, 33946);
      return true;
    }
    GMTrace.o(4556154994688L, 33946);
    return false;
  }
  
  public static boolean Dy()
  {
    GMTrace.i(4556289212416L, 33947);
    if (w.DH().fx(512) > 0)
    {
      GMTrace.o(4556289212416L, 33947);
      return true;
    }
    GMTrace.o(4556289212416L, 33947);
    return false;
  }
  
  public static boolean dr(String paramString)
  {
    GMTrace.i(4554141728768L, 33931);
    paramString = hW(paramString);
    if (paramString == null)
    {
      GMTrace.o(4554141728768L, 33931);
      return false;
    }
    if (paramString.CJ())
    {
      GMTrace.o(4554141728768L, 33931);
      return true;
    }
    GMTrace.o(4554141728768L, 33931);
    return false;
  }
  
  public static void f(BizInfo paramBizInfo)
  {
    GMTrace.i(4554544381952L, 33934);
    if (paramBizInfo == null)
    {
      v.e("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession bizInfo is Null");
      GMTrace.o(4554544381952L, 33934);
      return;
    }
    alu localalu = new alu();
    localalu.hAz = paramBizInfo.field_brandFlag;
    localalu.jLx = paramBizInfo.field_username;
    x localx = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Ra(paramBizInfo.field_username);
    if ((localx != null) && (a.ez(localx.field_type))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wQ().b(new e.a(47, localalu));
    }
    for (;;)
    {
      v.i("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession ret = %b, BrandFlag = %b", new Object[] { Boolean.valueOf(w.DH().c(paramBizInfo, new String[0])), Integer.valueOf(paramBizInfo.field_brandFlag) });
      GMTrace.o(4554544381952L, 33934);
      return;
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wQ().b(new e.a(58, localalu));
    }
  }
  
  public static void g(BizInfo paramBizInfo)
  {
    GMTrace.i(4554678599680L, 33935);
    if (paramBizInfo != null)
    {
      alu localalu = new alu();
      localalu.hAz = paramBizInfo.field_brandFlag;
      localalu.jLx = paramBizInfo.field_username;
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wQ().b(new e.a(47, localalu));
      w.DH().c(paramBizInfo, new String[0]);
    }
    GMTrace.o(4554678599680L, 33935);
  }
  
  public static BizInfo hW(String paramString)
  {
    GMTrace.i(4553336422400L, 33925);
    paramString = w.DH().hO(paramString);
    if (paramString.field_updateTime > 0L)
    {
      GMTrace.o(4553336422400L, 33925);
      return paramString;
    }
    GMTrace.o(4553336422400L, 33925);
    return null;
  }
  
  public static boolean hX(String paramString)
  {
    GMTrace.i(4553470640128L, 33926);
    paramString = hW(paramString);
    if (paramString == null)
    {
      GMTrace.o(4553470640128L, 33926);
      return false;
    }
    if (paramString.CE())
    {
      GMTrace.o(4553470640128L, 33926);
      return true;
    }
    GMTrace.o(4553470640128L, 33926);
    return false;
  }
  
  public static boolean hY(String paramString)
  {
    GMTrace.i(4553604857856L, 33927);
    paramString = hW(paramString);
    if (paramString == null)
    {
      GMTrace.o(4553604857856L, 33927);
      return false;
    }
    boolean bool = paramString.CF();
    GMTrace.o(4553604857856L, 33927);
    return bool;
  }
  
  public static boolean hZ(String paramString)
  {
    GMTrace.i(4553739075584L, 33928);
    paramString = hW(paramString);
    if (paramString == null)
    {
      GMTrace.o(4553739075584L, 33928);
      return false;
    }
    if (paramString.CG())
    {
      GMTrace.o(4553739075584L, 33928);
      return true;
    }
    GMTrace.o(4553739075584L, 33928);
    return false;
  }
  
  public static boolean ia(String paramString)
  {
    GMTrace.i(4553873293312L, 33929);
    paramString = hW(paramString);
    if (paramString == null)
    {
      GMTrace.o(4553873293312L, 33929);
      return false;
    }
    if (paramString.CI())
    {
      GMTrace.o(4553873293312L, 33929);
      return true;
    }
    GMTrace.o(4553873293312L, 33929);
    return false;
  }
  
  public static boolean ib(String paramString)
  {
    GMTrace.i(4554007511040L, 33930);
    if (paramString == null)
    {
      GMTrace.o(4554007511040L, 33930);
      return false;
    }
    paramString = hW(paramString);
    if (paramString == null)
    {
      GMTrace.o(4554007511040L, 33930);
      return false;
    }
    if (paramString.CH())
    {
      GMTrace.o(4554007511040L, 33930);
      return true;
    }
    GMTrace.o(4554007511040L, 33930);
    return false;
  }
  
  public static boolean ic(String paramString)
  {
    GMTrace.i(4554275946496L, 33932);
    paramString = hW(paramString);
    if (paramString == null)
    {
      GMTrace.o(4554275946496L, 33932);
      return false;
    }
    if (paramString.CK())
    {
      GMTrace.o(4554275946496L, 33932);
      return true;
    }
    GMTrace.o(4554275946496L, 33932);
    return false;
  }
  
  public static boolean ie(String paramString)
  {
    GMTrace.i(4554410164224L, 33933);
    paramString = hW(paramString);
    if (paramString == null)
    {
      GMTrace.o(4554410164224L, 33933);
      return false;
    }
    boolean bool = paramString.Cz();
    GMTrace.o(4554410164224L, 33933);
    return bool;
  }
  
  public static void jdMethod_if(String paramString)
  {
    GMTrace.i(4556423430144L, 33948);
    ay.a(paramString, null);
    ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rk(paramString);
    BizInfo localBizInfo = hW(paramString);
    if (localBizInfo == null)
    {
      w.DO().gR(paramString);
      GMTrace.o(4556423430144L, 33948);
      return;
    }
    if (localBizInfo.CH())
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().RA(paramString);
      w.DH();
      List localList = d.hR(paramString);
      if ((localList == null) || (localList.size() <= 0)) {
        v.d("MicroMsg.MsgInfoStorageLogic", "deleteMsgByTalkers, empty talkers");
      }
      for (;;)
      {
        int i = 0;
        while (i < localList.size())
        {
          String str = (String)localList.get(i);
          if (dr(str)) {
            com.tencent.mm.modelbiz.a.e.u(str, true);
          }
          w.DH().hP(str);
          i += 1;
        }
        v.d("MicroMsg.MsgInfoStorageLogic", "deleteMsgByTalkers");
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vL().D(new ay.3(localList, null));
      }
    }
    if (localBizInfo.CJ()) {
      com.tencent.mm.modelbiz.a.e.u(paramString, true);
    }
    w.DH().c(localBizInfo);
    w.DO().gR(paramString);
    GMTrace.o(4556423430144L, 33948);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */