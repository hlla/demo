package com.tencent.mm.ipcinvoker.extension;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ipcinvoker.e.b;
import junit.framework.Assert;

public final class e<T>
{
  private T gWc;
  private Class<T> gWd;
  
  public e(Class<T> paramClass)
  {
    GMTrace.i(18715588427776L, 139442);
    Assert.assertNotNull(paramClass);
    this.gWd = paramClass;
    GMTrace.o(18715588427776L, 139442);
  }
  
  public final T get()
  {
    GMTrace.i(18715722645504L, 139443);
    if (this.gWc == null) {}
    try
    {
      if (this.gWc == null) {
        this.gWc = b.e(this.gWd);
      }
      Object localObject1 = this.gWc;
      GMTrace.o(18715722645504L, 139443);
      return (T)localObject1;
    }
    finally {}
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ipcinvoker/extension/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */