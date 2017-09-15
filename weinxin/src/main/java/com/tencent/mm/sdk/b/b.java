package com.tencent.mm.sdk.b;

import com.tencent.gmtrace.GMTrace;

public abstract class b
{
  public Runnable nDP;
  public boolean uqr;
  private int uqs;
  
  public b()
  {
    GMTrace.i(13957704187904L, 103993);
    this.nDP = null;
    this.uqs = 0;
    GMTrace.o(13957704187904L, 103993);
  }
  
  final int bIn()
  {
    GMTrace.i(13957838405632L, 103994);
    if (this.uqs == 0) {
      this.uqs = getClass().getName().hashCode();
    }
    int i = this.uqs;
    GMTrace.o(13957838405632L, 103994);
    return i;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */