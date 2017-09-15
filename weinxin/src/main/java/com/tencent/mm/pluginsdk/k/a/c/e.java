package com.tencent.mm.pluginsdk.k.a.c;

import com.tencent.gmtrace.GMTrace;
import java.io.IOException;

public final class e
  extends IOException
{
  public final int httpStatusCode;
  public final IOException sEJ;
  
  public e(int paramInt, IOException paramIOException)
  {
    GMTrace.i(885300133888L, 6596);
    this.httpStatusCode = paramInt;
    this.sEJ = paramIOException;
    GMTrace.o(885300133888L, 6596);
  }
  
  public final String toString()
  {
    GMTrace.i(885434351616L, 6597);
    String str = "UnknownConnectionError{httpStatusCode=" + this.httpStatusCode + ", realException=" + this.sEJ + '}';
    GMTrace.o(885434351616L, 6597);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/k/a/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */