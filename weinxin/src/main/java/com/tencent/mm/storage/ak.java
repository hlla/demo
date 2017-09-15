package com.tencent.mm.storage;

import com.tencent.gmtrace.GMTrace;

public final class ak
{
  public String fFR;
  public String kRg;
  public int uHC;
  private boolean uHD;
  public int uHE;
  public int uHF;
  public String uHG;
  
  public ak()
  {
    GMTrace.i(1567931498496L, 11682);
    this.uHD = false;
    this.uHC = -1;
    GMTrace.o(1567931498496L, 11682);
  }
  
  public ak(String paramString)
  {
    GMTrace.i(1568065716224L, 11683);
    this.uHD = false;
    this.fFR = paramString;
    this.uHC = -1;
    GMTrace.o(1568065716224L, 11683);
  }
  
  public final void yy(int paramInt)
  {
    GMTrace.i(1568199933952L, 11684);
    if ((this.uHC != -1) && (this.uHC != paramInt) && (paramInt == 7)) {
      this.uHD = true;
    }
    this.uHC = paramInt;
    GMTrace.o(1568199933952L, 11684);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */