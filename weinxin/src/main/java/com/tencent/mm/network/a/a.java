package com.tencent.mm.network.a;

import com.tencent.gmtrace.GMTrace;

public abstract interface a
{
  public static final class a
  {
    public long beginTime;
    public String clientIp;
    public long endTime;
    public int errCode;
    public int errType;
    public long expand1;
    public long expand2;
    public long hVP;
    public c ifD;
    public boolean ifE;
    public long ifF;
    public long ifG;
    public long ifH;
    public int ifI;
    public int ifJ;
    public long ifK;
    public long ifL;
    public long ifM;
    public long netSignal;
    public int netType;
    public int retryCount;
    public long rtType;
    
    public a()
    {
      GMTrace.i(13661083009024L, 101783);
      this.rtType = 0L;
      this.beginTime = 0L;
      this.endTime = 0L;
      this.hVP = 0L;
      this.ifE = false;
      this.netType = 0;
      this.errType = 0;
      this.errCode = 0;
      this.ifF = 0L;
      this.ifG = 0L;
      this.ifH = 0L;
      this.ifI = 0;
      this.retryCount = 0;
      this.ifJ = 0;
      this.ifK = 0L;
      this.ifL = 0L;
      this.ifM = 0L;
      this.netSignal = 0L;
      this.expand1 = 0L;
      this.clientIp = "";
      this.expand2 = 0L;
      GMTrace.o(13661083009024L, 101783);
    }
    
    public final String toString()
    {
      GMTrace.i(13661217226752L, 101784);
      long l1 = this.rtType;
      long l2 = this.beginTime;
      long l3 = this.endTime;
      long l4 = this.endTime;
      long l5 = this.beginTime;
      long l6 = this.hVP;
      long l7 = this.ifH;
      if (this.ifD == null) {}
      for (String str = "null";; str = this.ifD.toString())
      {
        str = String.format("rtType:%d begin:%d, end:%d time:%d cost:%d count:%d ipInfo:%s socket:%b netType:%d err:(%d,%d) tx:%d rx:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4 - l5), Long.valueOf(l6), Long.valueOf(l7), str, Boolean.valueOf(this.ifE), Integer.valueOf(this.netType), Integer.valueOf(this.errType), Integer.valueOf(this.errCode), Long.valueOf(this.ifF), Long.valueOf(this.ifG) });
        GMTrace.o(13661217226752L, 101784);
        return str;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/network/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */