package com.tencent.mm.modelappbrand;

import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.e.a.pr.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.t.f.a;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private static void a(pr parampr, f.a parama)
  {
    GMTrace.i(15217203347456L, 113377);
    parampr.fWr.appId = parama.hjD;
    parampr.fWr.userName = parama.hjC;
    parampr.fWr.fWt = parama.hjB;
    parampr.fWr.fWu = parama.hjJ;
    parampr.fWr.fWw = parama.hjF;
    parampr.fWr.fWv = parama.hjK;
    parampr = parampr.fWr;
    if (parama.hjJ != 0) {}
    for (boolean bool = true;; bool = false)
    {
      parampr.fWx = bool;
      GMTrace.o(15217203347456L, 113377);
      return;
    }
  }
  
  public static void a(String paramString, int paramInt, f.a parama, Bundle paramBundle)
  {
    GMTrace.i(18658680111104L, 139018);
    pr localpr = new pr();
    a(localpr, parama);
    localpr.fWr.scene = paramInt;
    if (paramInt == 1074) {
      localpr.fWr.fCE = paramString;
    }
    localpr.fWr.fFl = paramBundle;
    com.tencent.mm.sdk.b.a.uql.m(localpr);
    GMTrace.o(18658680111104L, 139018);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, f.a parama, Bundle paramBundle)
  {
    GMTrace.i(16173370441728L, 120501);
    pr localpr = new pr();
    a(localpr, parama);
    localpr.fWr.scene = 1036;
    localpr.fWr.fCE = (bf.mz(parama.appId) + ":" + bf.mz(p.encode(parama.url)));
    parama = localpr.fWr;
    int i;
    if (paramBoolean)
    {
      i = 2;
      parama.fWB = i;
      parama = localpr.fWr;
      if (!paramBoolean) {
        break label148;
      }
    }
    for (;;)
    {
      parama.fWC = paramString1;
      localpr.fWr.fFl = paramBundle;
      com.tencent.mm.sdk.b.a.uql.m(localpr);
      GMTrace.o(16173370441728L, 120501);
      return;
      i = 1;
      break;
      label148:
      paramString1 = paramString2;
    }
  }
  
  public static void b(String paramString1, String paramString2, boolean paramBoolean, f.a parama, Bundle paramBundle)
  {
    GMTrace.i(18658545893376L, 139017);
    pr localpr = new pr();
    a(localpr, parama);
    localpr.fWr.scene = 1036;
    localpr.fWr.fCE = parama.hjH;
    pr.a locala = localpr.fWr;
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      locala.fWB = i;
      locala = localpr.fWr;
      if (paramBoolean) {
        paramString2 = paramString1;
      }
      locala.fWC = paramString2;
      localpr.fWr.fWz.hpB = paramString1;
      localpr.fWr.fWz.hpC = parama.hjI;
      localpr.fWr.fFl = paramBundle;
      com.tencent.mm.sdk.b.a.uql.m(localpr);
      GMTrace.o(18658545893376L, 139017);
      return;
    }
  }
  
  public static void c(String paramString1, String paramString2, boolean paramBoolean, f.a parama, Bundle paramBundle)
  {
    GMTrace.i(16173504659456L, 120502);
    pr localpr = new pr();
    a(localpr, parama);
    pr.a locala = localpr.fWr;
    int i;
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      i = 1008;
      locala.scene = i;
      locala = localpr.fWr;
      localStringBuilder = new StringBuilder().append(paramString1);
      if (!paramBoolean) {
        break label149;
      }
    }
    label149:
    for (paramString1 = ":" + paramString2;; paramString1 = "")
    {
      locala.fCE = (paramString1 + ":" + parama.hjH);
      localpr.fWr.fFl = paramBundle;
      com.tencent.mm.sdk.b.a.uql.m(localpr);
      GMTrace.o(16173504659456L, 120502);
      return;
      i = 1007;
      break;
    }
  }
  
  public static void d(String paramString1, String paramString2, boolean paramBoolean, f.a parama, Bundle paramBundle)
  {
    GMTrace.i(16173638877184L, 120503);
    pr localpr = new pr();
    a(localpr, parama);
    localpr.fWr.scene = 1044;
    localpr.fWr.fCE = parama.hjH;
    pr.a locala = localpr.fWr;
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      locala.fWB = i;
      locala = localpr.fWr;
      if (paramBoolean) {
        paramString2 = paramString1;
      }
      locala.fWC = paramString2;
      localpr.fWr.fWz.hpB = paramString1;
      localpr.fWr.fWz.hpC = parama.hjI;
      localpr.fWr.fFl = paramBundle;
      com.tencent.mm.sdk.b.a.uql.m(localpr);
      GMTrace.o(16173638877184L, 120503);
      return;
    }
  }
  
  public static boolean gH(String paramString)
  {
    GMTrace.i(15217069129728L, 113376);
    if (bf.mA(paramString))
    {
      GMTrace.o(15217069129728L, 113376);
      return false;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONObject("BindWxaInfo");
      if (paramString != null)
      {
        if (paramString.optInt("openWxaByBizQRCode", 0) > 0)
        {
          GMTrace.o(15217069129728L, 113376);
          return true;
        }
        GMTrace.o(15217069129728L, 113376);
        return false;
      }
    }
    catch (JSONException paramString)
    {
      GMTrace.o(15217069129728L, 113376);
    }
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelappbrand/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */