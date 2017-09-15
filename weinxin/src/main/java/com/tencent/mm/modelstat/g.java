package com.tencent.mm.modelstat;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class g
{
  long beginTime;
  long endTime;
  boolean fZA;
  long hVN;
  long hVO;
  long hVP;
  int rtType;
  
  public g()
  {
    GMTrace.i(1392911581184L, 10378);
    GMTrace.o(1392911581184L, 10378);
  }
  
  public g(int paramInt, boolean paramBoolean, long paramLong)
  {
    GMTrace.i(1393045798912L, 10379);
    this.rtType = paramInt;
    this.fZA = paramBoolean;
    this.hVN = paramLong;
    this.hVO = 0L;
    GMTrace.o(1393045798912L, 10379);
  }
  
  public final void Kb()
  {
    GMTrace.i(1393180016640L, 10380);
    if (this.hVO == 0L)
    {
      this.beginTime = bf.NA();
      this.hVP = bf.NB();
    }
    this.hVO += 1L;
    GMTrace.o(1393180016640L, 10380);
  }
  
  public final void ar(long paramLong)
  {
    GMTrace.i(1393314234368L, 10381);
    if (this.hVN == 0L) {
      this.hVN = paramLong;
    }
    this.hVP = (bf.NB() - this.hVP);
    this.endTime = bf.NA();
    v.d("MicroMsg.MultiSceneStat", "FIN: TIME:" + (this.endTime - this.beginTime) + " datalen:" + this.hVN + " Count:" + this.hVO + " type:" + this.rtType);
    WatchDogPushReceiver.a(this);
    GMTrace.o(1393314234368L, 10381);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelstat/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */