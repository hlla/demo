package com.tencent.mm.ui.bindqq;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.jd;
import com.tencent.mm.e.a.jd.a;
import com.tencent.mm.sdk.b.c;

public final class a
  extends c<jd>
  implements b.a
{
  private jd vsW;
  
  public a()
  {
    GMTrace.i(1888980303872L, 14074);
    this.uqt = jd.class.getName().hashCode();
    GMTrace.o(1888980303872L, 14074);
  }
  
  public final void bTb()
  {
    GMTrace.i(1889248739328L, 14076);
    if ((this.vsW != null) && (this.vsW.fOX.fPa != null))
    {
      this.vsW.fOY.fFa = false;
      this.vsW.fOX.fPa.run();
      this.vsW = null;
    }
    GMTrace.o(1889248739328L, 14076);
  }
  
  public final boolean t(int paramInt1, int paramInt2, String paramString)
  {
    GMTrace.i(1889114521600L, 14075);
    if (this.vsW == null)
    {
      GMTrace.o(1889114521600L, 14075);
      return false;
    }
    if (this.vsW.fOX.fPa == null)
    {
      this.vsW = null;
      GMTrace.o(1889114521600L, 14075);
      return false;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.vsW.fOY.fFa = true;
      this.vsW.fOX.fPa.run();
      this.vsW = null;
      GMTrace.o(1889114521600L, 14075);
      return true;
    }
    this.vsW.fOY.fFa = false;
    this.vsW.fOX.fPa.run();
    this.vsW = null;
    GMTrace.o(1889114521600L, 14075);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/bindqq/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */