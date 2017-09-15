package com.tencent.mm.vending.h;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.vending.c.a;

public final class f
{
  private volatile d wAI;
  public volatile a wAT;
  
  public f(d paramd, a parama)
  {
    GMTrace.i(293936824320L, 2190);
    b(paramd);
    this.wAT = parama;
    GMTrace.o(293936824320L, 2190);
  }
  
  private void a(final a parama, final Object paramObject, long paramLong, boolean paramBoolean)
  {
    label186:
    label207:
    for (;;)
    {
      d locald;
      try
      {
        GMTrace.i(294339477504L, 2193);
        locald = this.wAI;
        if (!(parama instanceof e)) {
          break label207;
        }
        e locale = (e)parama;
        if ("Vending.ANY".equals(locale.NO())) {
          break label207;
        }
        locald = g.Uz(locale.NO());
        if (locald == null)
        {
          if (this.wAT != null) {
            this.wAT.interrupt();
          }
          GMTrace.o(294339477504L, 2193);
          return;
        }
        parama = new Runnable()
        {
          public final void run()
          {
            GMTrace.i(293399953408L, 2186);
            if (f.this.wAT != null) {
              f.this.wAT.cbw();
            }
            try
            {
              Object localObject = parama.call(paramObject);
              if (f.this.wAT != null) {
                f.this.wAT.bM(localObject);
              }
              GMTrace.o(293399953408L, 2186);
              return;
            }
            catch (ClassCastException localClassCastException)
            {
              this.wBe.initCause(localClassCastException);
              throw this.wBe;
            }
          }
        };
        if (-1L >= 0L) {
          break label186;
        }
        if ((paramBoolean) && (g.cbB() == locald))
        {
          parama.run();
          GMTrace.o(294339477504L, 2193);
          continue;
        }
        locald.ab(parama);
      }
      finally {}
      GMTrace.o(294339477504L, 2193);
      continue;
      locald.h(parama, -1L);
      GMTrace.o(294339477504L, 2193);
    }
  }
  
  private void c(d paramd)
  {
    try
    {
      GMTrace.i(294205259776L, 2192);
      this.wAI = paramd;
      GMTrace.o(294205259776L, 2192);
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  public final void a(a parama, Object paramObject, boolean paramBoolean)
  {
    GMTrace.i(294473695232L, 2194);
    a(parama, paramObject, -1L, paramBoolean);
    GMTrace.o(294473695232L, 2194);
  }
  
  public final void b(d paramd)
  {
    try
    {
      GMTrace.i(294071042048L, 2191);
      c(paramd);
      GMTrace.o(294071042048L, 2191);
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  public static abstract interface a
  {
    public abstract void bM(Object paramObject);
    
    public abstract void cbw();
    
    public abstract void interrupt();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/vending/h/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */