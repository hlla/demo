package com.tencent.mm.performance.wxperformancetool;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.performance.a.a.a;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public final class a
  extends a.a
{
  private HashMap<Integer, Long> igs;
  private HashMap<Integer, Long> igt;
  private HashMap<Integer, Long> igu;
  private HashMap<Integer, Long> igv;
  private HashMap<Integer, Long> igw;
  private HashMap<Integer, Long> igx;
  private HashMap<Integer, Long> igy;
  
  public a()
  {
    GMTrace.i(13134546862080L, 97860);
    this.igs = new HashMap();
    this.igt = new HashMap();
    this.igu = new HashMap();
    this.igv = new HashMap();
    this.igw = new HashMap();
    this.igx = new HashMap();
    this.igy = new HashMap();
    GMTrace.o(13134546862080L, 97860);
  }
  
  private static void a(HashMap<Integer, Long> paramHashMap, Activity paramActivity)
  {
    GMTrace.i(13134681079808L, 97861);
    if (paramActivity == null)
    {
      GMTrace.o(13134681079808L, 97861);
      return;
    }
    paramHashMap.put(Integer.valueOf(paramActivity.hashCode()), Long.valueOf(System.currentTimeMillis()));
    GMTrace.o(13134681079808L, 97861);
  }
  
  private static void a(HashMap<Integer, Long> paramHashMap, Activity paramActivity, String paramString)
  {
    GMTrace.i(13134815297536L, 97862);
    if (paramActivity == null)
    {
      GMTrace.o(13134815297536L, 97862);
      return;
    }
    int i = paramActivity.hashCode();
    paramHashMap = (Long)paramHashMap.get(Integer.valueOf(i));
    if (paramHashMap != null) {
      v.i("MicroMsg.WxPerformace", paramString + "  activity: " + i + " classname:" + paramActivity.getComponentName().getShortClassName() + " use time: " + (System.currentTimeMillis() - paramHashMap.longValue()) + " taskid:" + paramActivity.getTaskId());
    }
    GMTrace.o(13134815297536L, 97862);
  }
  
  public final void a(Activity paramActivity, Bundle paramBundle)
  {
    GMTrace.i(13134949515264L, 97863);
    super.a(paramActivity, paramBundle);
    a(this.igs, paramActivity);
    GMTrace.o(13134949515264L, 97863);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    GMTrace.i(13135083732992L, 97864);
    super.b(paramActivity, paramBundle);
    a(this.igs, paramActivity, "onActivityCreate");
    GMTrace.o(13135083732992L, 97864);
  }
  
  public final void c(Activity paramActivity, Intent paramIntent)
  {
    GMTrace.i(13135486386176L, 97867);
    super.c(paramActivity, paramIntent);
    a(this.igu, paramActivity);
    GMTrace.o(13135486386176L, 97867);
  }
  
  public final void d(Activity paramActivity, Intent paramIntent)
  {
    GMTrace.i(13135620603904L, 97868);
    super.d(paramActivity, paramIntent);
    a(this.igu, paramActivity, "onActivityNewIntent");
    GMTrace.o(13135620603904L, 97868);
  }
  
  public final void h(Activity paramActivity)
  {
    GMTrace.i(13136023257088L, 97871);
    super.h(paramActivity);
    a(this.igw, paramActivity);
    GMTrace.o(13136023257088L, 97871);
  }
  
  public final void i(Activity paramActivity)
  {
    GMTrace.i(13136157474816L, 97872);
    super.i(paramActivity);
    a(this.igw, paramActivity, "onActivityResume");
    GMTrace.o(13136157474816L, 97872);
  }
  
  public final void j(Activity paramActivity)
  {
    GMTrace.i(13135754821632L, 97869);
    super.j(paramActivity);
    a(this.igv, paramActivity);
    GMTrace.o(13135754821632L, 97869);
  }
  
  public final void k(Activity paramActivity)
  {
    GMTrace.i(13135889039360L, 97870);
    super.k(paramActivity);
    a(this.igv, paramActivity, "onActivityPause");
    GMTrace.o(13135889039360L, 97870);
  }
  
  public final void l(Activity paramActivity)
  {
    GMTrace.i(13136291692544L, 97873);
    super.l(paramActivity);
    a(this.igx, paramActivity);
    GMTrace.o(13136291692544L, 97873);
  }
  
  public final void m(Activity paramActivity)
  {
    GMTrace.i(13136425910272L, 97874);
    super.m(paramActivity);
    a(this.igx, paramActivity, "onActivityStart");
    GMTrace.o(13136425910272L, 97874);
  }
  
  public final void n(Activity paramActivity)
  {
    GMTrace.i(13136560128000L, 97875);
    super.n(paramActivity);
    a(this.igy, paramActivity);
    GMTrace.o(13136560128000L, 97875);
  }
  
  public final void o(Activity paramActivity)
  {
    GMTrace.i(13136694345728L, 97876);
    super.o(paramActivity);
    a(this.igy, paramActivity, "onActivityStop");
    GMTrace.o(13136694345728L, 97876);
  }
  
  public final void p(Activity paramActivity)
  {
    GMTrace.i(13135217950720L, 97865);
    super.p(paramActivity);
    a(this.igt, paramActivity);
    GMTrace.o(13135217950720L, 97865);
  }
  
  public final void q(Activity paramActivity)
  {
    GMTrace.i(13135352168448L, 97866);
    super.q(paramActivity);
    a(this.igt, paramActivity, "onActivityDestroy");
    GMTrace.o(13135352168448L, 97866);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/performance/wxperformancetool/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */