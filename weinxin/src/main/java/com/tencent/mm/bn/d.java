package com.tencent.mm.bn;

import com.tencent.gmtrace.GMTrace;

public final class d
  extends com.tencent.mm.vending.h.d
{
  public d()
  {
    GMTrace.i(13615851634688L, 101446);
    GMTrace.o(13615851634688L, 101446);
  }
  
  public final void ab(Runnable paramRunnable)
  {
    GMTrace.i(13615985852416L, 101447);
    paramRunnable.run();
    GMTrace.o(13615985852416L, 101447);
  }
  
  public final void cancel()
  {
    GMTrace.i(13616388505600L, 101450);
    GMTrace.o(13616388505600L, 101450);
  }
  
  public final String getType()
  {
    GMTrace.i(13616254287872L, 101449);
    GMTrace.o(13616254287872L, 101449);
    return "WxNoLooperScheduler";
  }
  
  public final void h(Runnable paramRunnable, long paramLong)
  {
    GMTrace.i(13616120070144L, 101448);
    paramRunnable.run();
    GMTrace.o(13616120070144L, 101448);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/bn/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */