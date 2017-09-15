package com.tencent.mm.modelstat;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class m
{
  static
  {
    GMTrace.i(1403246346240L, 10455);
    be.reset();
    GMTrace.o(1403246346240L, 10455);
  }
  
  private static void a(j paramj, int paramInt)
  {
    GMTrace.i(1403112128512L, 10454);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(1403112128512L, 10454);
      return;
      paramj.hWf = (paramj.hWm + paramj.hWn);
      paramj.fRM |= 0x8000;
      GMTrace.o(1403112128512L, 10454);
      return;
      paramj.hVT = (paramj.hWa + paramj.hWb);
      paramj.fRM |= 0x8;
      GMTrace.o(1403112128512L, 10454);
      return;
      paramj.hWh = (paramj.hWm + paramj.hWn);
      paramj.fRM |= 0x20000;
      GMTrace.o(1403112128512L, 10454);
      return;
      paramj.hVV = (paramj.hWa + paramj.hWb);
      paramj.fRM |= 0x20;
      GMTrace.o(1403112128512L, 10454);
      return;
      paramj.hWj = (paramj.hWm + paramj.hWn);
      paramj.fRM |= 0x80000;
      GMTrace.o(1403112128512L, 10454);
      return;
      paramj.hVX = (paramj.hWa + paramj.hWb);
      paramj.fRM |= 0x80;
      GMTrace.o(1403112128512L, 10454);
      return;
      paramj.hWl = (paramj.hWm + paramj.hWn);
      paramj.fRM |= 0x200000;
      GMTrace.o(1403112128512L, 10454);
      return;
      paramj.hVZ = (paramj.hWa + paramj.hWb);
      paramj.fRM |= 0x200;
    }
  }
  
  private static void c(j paramj)
  {
    GMTrace.i(1402977910784L, 10453);
    be.update();
    paramj.hWc = ((int)be.bJB());
    paramj.hWo = ((int)be.bJA());
    paramj.hWd = ((int)be.bJz());
    paramj.hWp = ((int)be.bJy());
    paramj.hWq = ((int)be.bJF());
    paramj.hWs = ((int)be.bJE());
    paramj.hWr = ((int)be.bJD());
    paramj.hWt = ((int)be.bJC());
    paramj.fRM = (paramj.fRM | 0x2000 | 0x2000000 | 0x1000 | 0x1000000 | 0x8000000 | 0x20000000 | 0x4000000 | 0x10000000);
    GMTrace.o(1402977910784L, 10453);
  }
  
  public static void r(int paramInt1, int paramInt2, int paramInt3)
  {
    GMTrace.i(1402575257600L, 10450);
    if (com.tencent.mm.network.aa.bn(com.tencent.mm.sdk.platformtools.aa.getContext()))
    {
      v.i("MicroMsg.NetStatStorageLogic", "dknetflow wifi recv:%d send:%d type:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0) });
      s(paramInt1, paramInt2, 0);
      GMTrace.o(1402575257600L, 10450);
      return;
    }
    v.i("MicroMsg.NetStatStorageLogic", "dknetflow mobile recv:%d send:%d type:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0) });
    t(paramInt1, paramInt2, 0);
    GMTrace.o(1402575257600L, 10450);
  }
  
  public static void s(int paramInt1, int paramInt2, int paramInt3)
  {
    GMTrace.i(1402709475328L, 10451);
    j localj = new j();
    localj.hWb = paramInt1;
    localj.hWn = paramInt2;
    localj.fRM = 8390656;
    c(localj);
    a(localj, paramInt3);
    p.Ki().a(localj);
    GMTrace.o(1402709475328L, 10451);
  }
  
  public static void t(int paramInt1, int paramInt2, int paramInt3)
  {
    GMTrace.i(1402843693056L, 10452);
    j localj = new j();
    localj.hWa = paramInt1;
    localj.hWm = paramInt2;
    localj.fRM = 4195328;
    c(localj);
    a(localj, paramInt3);
    p.Ki().a(localj);
    GMTrace.o(1402843693056L, 10452);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelstat/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */