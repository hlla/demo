package com.tencent.mm.storage;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.u.ay.b;

public abstract class e
{
  public static j uxf;
  protected c uxe;
  
  public e(c paramc)
  {
    GMTrace.i(13304198070272L, 99124);
    this.uxe = paramc;
    GMTrace.o(13304198070272L, 99124);
  }
  
  protected final String Az(String paramString)
  {
    GMTrace.i(13304869158912L, 99129);
    paramString = this.uxe.Az(paramString);
    GMTrace.o(13304869158912L, 99129);
    return paramString;
  }
  
  public abstract String QD(String paramString);
  
  protected final void a(g paramg, String paramString)
  {
    GMTrace.i(13304600723456L, 99127);
    this.uxe.a(paramg, paramString);
    GMTrace.o(13304600723456L, 99127);
  }
  
  protected final void a(c.b paramb)
  {
    GMTrace.i(13304734941184L, 99128);
    this.uxe.a(paramb);
    GMTrace.o(13304734941184L, 99128);
  }
  
  protected final void a(c.c paramc)
  {
    GMTrace.i(13305003376640L, 99130);
    this.uxe.a(paramc);
    GMTrace.o(13305003376640L, 99130);
  }
  
  protected boolean a(au paramau, ay.b paramb)
  {
    GMTrace.i(13304063852544L, 99123);
    GMTrace.o(13304063852544L, 99123);
    return true;
  }
  
  public final g aJS()
  {
    GMTrace.i(13304332288000L, 99125);
    g localg = this.uxe.aJS();
    GMTrace.o(13304332288000L, 99125);
    return localg;
  }
  
  protected final void eH(String paramString1, String paramString2)
  {
    GMTrace.i(13305137594368L, 99131);
    this.uxe.b(paramString1, paramString2, null);
    GMTrace.o(13305137594368L, 99131);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */