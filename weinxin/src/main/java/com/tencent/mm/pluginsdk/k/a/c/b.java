package com.tencent.mm.pluginsdk.k.a.c;

import com.tencent.gmtrace.GMTrace;
import java.io.IOException;

public final class b
  extends IOException
{
  private final long gad;
  private final long sEI;
  
  public b()
  {
    this(0L, 0L);
    GMTrace.i(885568569344L, 6598);
    GMTrace.o(885568569344L, 6598);
  }
  
  public b(long paramLong1, long paramLong2)
  {
    super(String.format("contentLength: %d, requestRange:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    GMTrace.i(885702787072L, 6599);
    this.gad = paramLong1;
    this.sEI = paramLong2;
    GMTrace.o(885702787072L, 6599);
  }
  
  public final String toString()
  {
    GMTrace.i(885837004800L, 6600);
    String str = "FileSizeOutOfRangeException{contentLength=" + this.gad + ", requestRange=" + this.sEI + '}';
    GMTrace.o(885837004800L, 6600);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/k/a/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */