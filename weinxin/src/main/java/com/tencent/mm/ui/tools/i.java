package com.tencent.mm.ui.tools;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.y.n;

final class i
  extends SecurityImage.b
{
  protected String uXf;
  protected String uXg;
  protected byte[] uXh;
  protected int uXi;
  
  i()
  {
    GMTrace.i(1932735283200L, 14400);
    this.uXf = "";
    this.uXg = "";
    this.uXh = null;
    this.uXi = 0;
    GMTrace.o(1932735283200L, 14400);
  }
  
  public final void bQy()
  {
    GMTrace.i(1932869500928L, 14401);
    u localu = new u(this.uXi, "", this.uXf, this.uXg);
    ap.vd().a(localu, 0);
    GMTrace.o(1932869500928L, 14401);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/tools/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */