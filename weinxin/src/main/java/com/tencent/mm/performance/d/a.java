package com.tencent.mm.performance.d;

import com.tencent.gmtrace.GMTrace;

public abstract class a
{
  protected long igp;
  public long igq;
  
  public a()
  {
    GMTrace.i(13141257748480L, 97910);
    this.igp = -1L;
    this.igq = -1L;
    GMTrace.o(13141257748480L, 97910);
  }
  
  public abstract String Nc();
  
  public abstract void Nd();
  
  public final boolean Ne()
  {
    GMTrace.i(13141391966208L, 97911);
    if (this.igq == -1L)
    {
      GMTrace.o(13141391966208L, 97911);
      return true;
    }
    if (this.igp == -1L)
    {
      this.igp = System.currentTimeMillis();
      GMTrace.o(13141391966208L, 97911);
      return true;
    }
    long l = System.currentTimeMillis();
    if (l - this.igp >= this.igq)
    {
      this.igp = l;
      GMTrace.o(13141391966208L, 97911);
      return true;
    }
    GMTrace.o(13141391966208L, 97911);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/performance/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */