package com.tencent.mm.compatible.b;

import com.tencent.gmtrace.GMTrace;
import java.util.concurrent.locks.Lock;

public final class a
{
  public int gMR;
  public int gMS;
  public byte[] gMT;
  public int gMU;
  public int gMV;
  public boolean gMW;
  public Lock gMX;
  
  public a()
  {
    GMTrace.i(13822546935808L, 102986);
    this.gMR = 0;
    this.gMS = 0;
    this.gMT = null;
    this.gMU = 0;
    this.gMV = 0;
    this.gMW = false;
    this.gMX = null;
    GMTrace.o(13822546935808L, 102986);
  }
  
  public final int qC()
  {
    GMTrace.i(13822681153536L, 102987);
    if (this.gMW) {
      this.gMX.lock();
    }
    if (this.gMU == this.gMV)
    {
      GMTrace.o(13822681153536L, 102987);
      return 0;
    }
    if (this.gMU < this.gMV) {
      this.gMS = (this.gMV - this.gMU);
    }
    for (;;)
    {
      if (this.gMW) {
        this.gMX.unlock();
      }
      int i = this.gMS;
      GMTrace.o(13822681153536L, 102987);
      return i;
      if (this.gMU > this.gMV) {
        this.gMS = (this.gMV + this.gMR - this.gMU);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/compatible/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */