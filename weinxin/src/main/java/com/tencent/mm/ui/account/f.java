package com.tencent.mm.ui.account;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.y.n;

public final class f
  extends SecurityImage.b
{
  private static f uXj;
  public String hRY;
  public String uXd;
  public String uXe;
  public String uXf;
  public String uXg;
  public byte[] uXh;
  public int uXi;
  
  static
  {
    GMTrace.i(2661940199424L, 19833);
    uXj = null;
    GMTrace.o(2661940199424L, 19833);
  }
  
  public f()
  {
    GMTrace.i(2661269110784L, 19828);
    this.hRY = null;
    this.uXd = null;
    this.uXe = null;
    this.uXf = null;
    this.uXg = null;
    this.uXh = null;
    this.uXi = 0;
    GMTrace.o(2661269110784L, 19828);
  }
  
  public static void a(f paramf)
  {
    GMTrace.i(2661537546240L, 19830);
    uXj = paramf;
    GMTrace.o(2661537546240L, 19830);
  }
  
  public static String bQG()
  {
    GMTrace.i(2661671763968L, 19831);
    if (uXj != null)
    {
      String str = uXj.hRY;
      GMTrace.o(2661671763968L, 19831);
      return str;
    }
    GMTrace.o(2661671763968L, 19831);
    return null;
  }
  
  public static String bQH()
  {
    GMTrace.i(2661805981696L, 19832);
    if (uXj != null)
    {
      String str = uXj.uXd;
      GMTrace.o(2661805981696L, 19832);
      return str;
    }
    GMTrace.o(2661805981696L, 19832);
    return null;
  }
  
  public final void bQy()
  {
    GMTrace.i(2661403328512L, 19829);
    if (!bf.mA(this.uXe))
    {
      localu = new u(this.hRY, this.uXe, this.vdE.uXi, "", "", "", 0, "", false, true);
      ap.vd().a(localu, 0);
      GMTrace.o(2661403328512L, 19829);
      return;
    }
    u localu = new u(this.hRY, this.uXd, this.vdE.uXi, "", "", "", 0, "", false, false);
    ap.vd().a(localu, 0);
    GMTrace.o(2661403328512L, 19829);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */