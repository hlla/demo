package com.tencent.mm.pluginsdk.model;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.w.a.a.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.pluginsdk.model.app.w;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import java.util.Map;

public final class i
  implements t
{
  public static boolean sAF;
  private static i sAG;
  public a sAH;
  
  static
  {
    GMTrace.i(757524856832L, 5644);
    sAF = false;
    GMTrace.o(757524856832L, 5644);
  }
  
  private i()
  {
    GMTrace.i(756853768192L, 5639);
    GMTrace.o(756853768192L, 5639);
  }
  
  public static b LQ(String paramString)
  {
    GMTrace.i(757390639104L, 5643);
    if (paramString == null)
    {
      GMTrace.o(757390639104L, 5643);
      return null;
    }
    paramString = bg.q(paramString, "PersonalAppSetting");
    if (paramString == null)
    {
      GMTrace.o(757390639104L, 5643);
      return null;
    }
    paramString = (String)paramString.get(".PersonalAppSetting.OpenID");
    if (bf.mA(paramString))
    {
      GMTrace.o(757390639104L, 5643);
      return null;
    }
    b localb = new b();
    localb.sAI = paramString;
    GMTrace.o(757390639104L, 5643);
    return localb;
  }
  
  public static i bCv()
  {
    GMTrace.i(756987985920L, 5640);
    if (sAG == null) {
      sAG = new i();
    }
    i locali = sAG;
    GMTrace.o(756987985920L, 5640);
    return locali;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, w paramw)
  {
    GMTrace.i(757256421376L, 5642);
    if (!ap.zb())
    {
      GMTrace.o(757256421376L, 5642);
      return;
    }
    v.d("MicroMsg.GetUserInfoInAppLogic", "onSceneEnd errType=%s errCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramw == null)
    {
      v.e("MicroMsg.GetUserInfoInAppLogic", "scene == null");
      GMTrace.o(757256421376L, 5642);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      switch (paramw.getType())
      {
      }
    }
    for (;;)
    {
      GMTrace.o(757256421376L, 5642);
      return;
      if ((aa.getContext() == null) || (a.a.aRo() == null))
      {
        v.e("MicroMsg.GetUserInfoInAppLogic", "wrong environment");
        GMTrace.o(757256421376L, 5642);
        return;
      }
      v.e("MicroMsg.GetUserInfoInAppLogic", "NetSceneGetUserInfoInApp come back", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = (l)paramw;
      if (this.sAH != null) {
        this.sAH.a(paramString);
      }
    }
  }
  
  public final void bCw()
  {
    GMTrace.i(757122203648L, 5641);
    if (!ap.zb())
    {
      GMTrace.o(757122203648L, 5641);
      return;
    }
    an.aBz().a(14, this);
    sAF = true;
    GMTrace.o(757122203648L, 5641);
  }
  
  public static abstract interface a
  {
    public abstract void a(l paraml);
  }
  
  public static final class b
  {
    public String sAI;
    
    public b()
    {
      GMTrace.i(768128057344L, 5723);
      GMTrace.o(768128057344L, 5723);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */