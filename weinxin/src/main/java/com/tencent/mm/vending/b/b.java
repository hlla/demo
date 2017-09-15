package com.tencent.mm.vending.b;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.vending.h.d;
import junit.framework.Assert;

public final class b<_Callback>
  implements com.tencent.mm.vending.e.a
{
  public d fwq;
  private int mPriority;
  private a wAs;
  public _Callback wAt;
  private int wAu;
  
  public b(_Callback param_Callback, a parama)
  {
    GMTrace.i(273133076480L, 2035);
    this.mPriority = -1;
    Assert.assertNotNull("Callback should not be null!", param_Callback);
    this.wAu = param_Callback.hashCode();
    this.wAt = param_Callback;
    this.wAs = parama;
    GMTrace.o(273133076480L, 2035);
  }
  
  public final b<_Callback> a(com.tencent.mm.vending.e.b paramb)
  {
    GMTrace.i(272998858752L, 2034);
    Assert.assertNotNull(paramb);
    paramb.a(this);
    GMTrace.o(272998858752L, 2034);
    return this;
  }
  
  public final void dead()
  {
    GMTrace.i(273535729664L, 2038);
    Assert.assertNotNull(this.wAs);
    this.wAs.b(this);
    GMTrace.o(273535729664L, 2038);
  }
  
  public final boolean equals(Object paramObject)
  {
    GMTrace.i(273401511936L, 2037);
    if ((paramObject != null) && (paramObject.hashCode() == this.wAu))
    {
      GMTrace.o(273401511936L, 2037);
      return true;
    }
    GMTrace.o(273401511936L, 2037);
    return false;
  }
  
  public final int hashCode()
  {
    GMTrace.i(273267294208L, 2036);
    int i = this.wAu;
    GMTrace.o(273267294208L, 2036);
    return i;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/vending/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */