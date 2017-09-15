package com.tencent.mm.h;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.storage.au;

public abstract interface a
{
  public abstract void b(au paramau);
  
  public abstract String c(au paramau);
  
  public abstract boolean dr(String paramString);
  
  public abstract String p(String paramString, int paramInt);
  
  public static final class a
  {
    private static a gMQ;
    
    static
    {
      GMTrace.i(14605438943232L, 108819);
      gMQ = null;
      GMTrace.o(14605438943232L, 108819);
    }
    
    public static void a(a parama)
    {
      GMTrace.i(14605170507776L, 108817);
      gMQ = parama;
      GMTrace.o(14605170507776L, 108817);
    }
    
    public static a qB()
    {
      GMTrace.i(14605304725504L, 108818);
      a locala = gMQ;
      GMTrace.o(14605304725504L, 108818);
      return locala;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/h/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */