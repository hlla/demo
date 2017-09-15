package com.tencent.mm.sdk.platformtools;

import com.tencent.gmtrace.GMTrace;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.nio.channels.FileChannel;

public final class i
  extends FilterInputStream
{
  private long hQL;
  
  public i(FileInputStream paramFileInputStream)
  {
    super(paramFileInputStream);
    GMTrace.i(13933813432320L, 103815);
    this.hQL = 0L;
    GMTrace.o(13933813432320L, 103815);
  }
  
  public final void mark(int paramInt)
  {
    GMTrace.i(13934081867776L, 103817);
    try
    {
      this.hQL = ((FileInputStream)this.in).getChannel().position();
      GMTrace.o(13934081867776L, 103817);
      return;
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.FileSeekingInputStream", localException, "Failed seeking FileChannel.", new Object[0]);
      GMTrace.o(13934081867776L, 103817);
    }
  }
  
  public final boolean markSupported()
  {
    GMTrace.i(13933947650048L, 103816);
    GMTrace.o(13933947650048L, 103816);
    return true;
  }
  
  public final void reset()
  {
    GMTrace.i(13934216085504L, 103818);
    ((FileInputStream)this.in).getChannel().position(this.hQL);
    GMTrace.o(13934216085504L, 103818);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/platformtools/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */