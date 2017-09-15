package com.tencent.mm.performance.b;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashSet;
import java.util.Iterator;

public final class a
  extends com.tencent.mm.performance.d.a
{
  public static String TYPE;
  public long ifT;
  public long ifU;
  public long ifV;
  public long ifW;
  public boolean ifX;
  public HashSet<a> ifY;
  
  static
  {
    GMTrace.i(13132399378432L, 97844);
    TYPE = "MemoryAlarmController";
    GMTrace.o(13132399378432L, 97844);
  }
  
  public a()
  {
    GMTrace.i(13131862507520L, 97840);
    this.ifT = -1L;
    this.ifU = -1L;
    this.ifV = -1L;
    this.ifW = -1L;
    this.ifX = false;
    this.ifT = Runtime.getRuntime().maxMemory();
    GMTrace.o(13131862507520L, 97840);
  }
  
  private void a(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    GMTrace.i(13131996725248L, 97841);
    for (;;)
    {
      a locala;
      synchronized (this.ifY)
      {
        Iterator localIterator = this.ifY.iterator();
        if (!localIterator.hasNext()) {
          break label129;
        }
        locala = (a)localIterator.next();
        switch (paramInt)
        {
        case 0: 
          locala.a(paramLong1, paramLong2, paramLong3);
        }
      }
      locala.b(paramLong1, paramLong2, paramLong3);
      continue;
      locala.c(paramLong1, paramLong2, paramLong3);
      continue;
      label129:
      GMTrace.o(13131996725248L, 97841);
      return;
    }
  }
  
  public final String Nc()
  {
    GMTrace.i(13132130942976L, 97842);
    String str = TYPE;
    GMTrace.o(13132130942976L, 97842);
    return str;
  }
  
  public final void Nd()
  {
    GMTrace.i(13132265160704L, 97843);
    if (!this.ifX)
    {
      GMTrace.o(13132265160704L, 97843);
      return;
    }
    long l1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long l2 = l1 / this.ifT;
    v.d("MicroMsg.WxPerformace", "memoryalarm memory use %d, total %d", new Object[] { Long.valueOf(l1), Long.valueOf(this.ifT) });
    if (l2 >= this.ifW)
    {
      a(2, l2, this.ifT, l1);
      GMTrace.o(13132265160704L, 97843);
      return;
    }
    if (l2 >= this.ifV)
    {
      a(1, l2, this.ifT, l1);
      GMTrace.o(13132265160704L, 97843);
      return;
    }
    if (l2 >= this.ifU) {
      a(0, l2, this.ifT, l1);
    }
    GMTrace.o(13132265160704L, 97843);
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong1, long paramLong2, long paramLong3);
    
    public abstract void b(long paramLong1, long paramLong2, long paramLong3);
    
    public abstract void c(long paramLong1, long paramLong2, long paramLong3);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/performance/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */