package com.tencent.mm.pluginsdk.j;

import android.app.Activity;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.n;
import java.util.Iterator;
import java.util.Set;

public final class a
{
  private j sDc;
  private k sDd;
  private l sDe;
  private h sDf;
  private i sDg;
  private g sDh;
  
  public a()
  {
    GMTrace.i(698334838784L, 5203);
    GMTrace.o(698334838784L, 5203);
  }
  
  private static void a(b paramb)
  {
    GMTrace.i(698603274240L, 5205);
    if (paramb != null)
    {
      Iterator localIterator = paramb.sDi.iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        ap.vd().b(localInteger.intValue(), paramb);
      }
      paramb.activity = null;
    }
    GMTrace.o(698603274240L, 5205);
  }
  
  public final boolean a(Activity paramActivity, p paramp)
  {
    GMTrace.i(698469056512L, 5204);
    if ((paramp.type == 0) || (paramp.action == 0))
    {
      GMTrace.o(698469056512L, 5204);
      return false;
    }
    if (this.sDh == null) {
      this.sDh = new g(paramActivity);
    }
    if (this.sDh.a(paramp))
    {
      GMTrace.o(698469056512L, 5204);
      return true;
    }
    switch (paramp.type)
    {
    default: 
      v.e("MicroMsg.BaseErrorHelper", "Unkown error type");
    }
    for (;;)
    {
      GMTrace.o(698469056512L, 5204);
      return false;
      if (this.sDc == null) {
        this.sDc = new j(paramActivity);
      }
      this.sDc.a(paramp);
      continue;
      if (this.sDd == null) {
        this.sDd = new k(paramActivity);
      }
      this.sDd.a(paramp);
      continue;
      if (this.sDe == null) {
        this.sDe = new l(paramActivity);
      }
      this.sDe.a(paramp);
      continue;
      if (this.sDf == null) {
        this.sDf = new h(paramActivity);
      }
      this.sDf.a(paramp);
      continue;
      if (this.sDg == null) {
        this.sDg = new i(paramActivity);
      }
      this.sDg.a(paramp);
      continue;
      if (this.sDh == null) {
        this.sDh = new g(paramActivity);
      }
      this.sDh.a(paramp);
    }
  }
  
  public final void close()
  {
    GMTrace.i(698737491968L, 5206);
    a(this.sDc);
    a(this.sDd);
    a(this.sDe);
    a(this.sDf);
    a(this.sDg);
    a(this.sDh);
    GMTrace.o(698737491968L, 5206);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/j/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */