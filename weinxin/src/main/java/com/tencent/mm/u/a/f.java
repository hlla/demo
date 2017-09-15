package com.tencent.mm.u.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public final class f
{
  public static void a(e parame)
  {
    GMTrace.i(692966129664L, 5163);
    if ((parame != null) && (g.Ae().Ac()))
    {
      String str1 = g.Ae().hoh.hod;
      String str2 = parame.id;
      String str3 = parame.id;
      String str4 = parame.endTime - parame.startTime;
      String str5 = parame.result;
      String str6 = parame.hoj;
      long l = parame.hom;
      v.i("MicroMsg.abtest.AbTestReportHelper", "TestCaseID:%s TestPointsID:%s TestReportID：%s TetsCheckID:%s TestDurationTime:%s TestActionResult:%s, TestActionScene:%d", new Object[] { str1, str2, str6, str3, str4, str5, Long.valueOf(l) });
      com.tencent.mm.plugin.report.service.g.oSF.i(11394, new Object[] { str1, str2, str6, str3, str4, str5, Long.valueOf(l) });
    }
    GMTrace.o(692966129664L, 5163);
  }
  
  private static void a(e parame, boolean paramBoolean)
  {
    GMTrace.i(692831911936L, 5162);
    if ((parame == null) || (!g.Ae().Ac()))
    {
      v.w("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast abtest faild. abTestPoint or testcase is null.");
      GMTrace.o(692831911936L, 5162);
      return;
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    if (paramBoolean) {}
    for (StringBuilder localStringBuilder1 = localStringBuilder2.append("TestPointStart:");; localStringBuilder1 = localStringBuilder2.append("TestPointEnd:"))
    {
      localStringBuilder2.append(localStringBuilder1);
      localStringBuilder2.append(g.Ae().hoh.hod);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.id);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.hoj);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.hoj);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.hok);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.result);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.hom);
      gw(localStringBuilder2.toString());
      GMTrace.o(692831911936L, 5162);
      return;
    }
  }
  
  private static void gw(String paramString)
  {
    GMTrace.i(692697694208L, 5161);
    v.i("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast:%s", new Object[] { paramString });
    if (g.Ae().Ac())
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.mm.ui.ACTION_ABTEST");
      localIntent.putExtra("content", paramString);
      aa.getContext().sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
      GMTrace.o(692697694208L, 5161);
      return;
    }
    v.i("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast abtest faild. no test case.");
    GMTrace.o(692697694208L, 5161);
  }
  
  public static void gx(String paramString)
  {
    GMTrace.i(693100347392L, 5164);
    v.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestCase: start abtest click stream");
    gw("TestCaseID:" + paramString);
    GMTrace.o(693100347392L, 5164);
  }
  
  public static void gy(String paramString)
  {
    GMTrace.i(693234565120L, 5165);
    if (g.Ae().gu(paramString) != null)
    {
      v.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestPoint:%s", new Object[] { paramString });
      g.Ae().gu(paramString).hok = System.currentTimeMillis();
      g.Ae().gu(paramString).startTime = System.currentTimeMillis();
      g.Ae().gu(paramString).hol = false;
      g.Ae().gu(paramString).result = "0";
      a(g.Ae().gu(paramString), true);
    }
    GMTrace.o(693234565120L, 5165);
  }
  
  public static void gz(String paramString)
  {
    GMTrace.i(693368782848L, 5166);
    if ((g.Ae().gu(paramString) != null) && (!g.Ae().gu(paramString).hol))
    {
      v.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] endAbTestPoint:%s", new Object[] { paramString });
      g.Ae().gu(paramString).hok = System.currentTimeMillis();
      g.Ae().gu(paramString).endTime = System.currentTimeMillis();
      g.Ae().gu(paramString).hol = true;
      a(g.Ae().gu(paramString));
      a(g.Ae().gu(paramString), false);
    }
    GMTrace.o(693368782848L, 5166);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */