package com.tencent.mm.plugin.fts.a.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.wcdb.support.OperationCanceledException;
import java.util.List;
import java.util.regex.Pattern;

public abstract class e
  extends a
{
  public f lYj;
  public int lYk;
  
  public e(f paramf)
  {
    GMTrace.i(18632641871872L, 138824);
    this.lYj = paramf;
    GMTrace.o(18632641871872L, 138824);
  }
  
  public abstract List<i> a(String[] paramArrayOfString, f paramf);
  
  public final boolean execute()
  {
    GMTrace.i(18632910307328L, 138826);
    final g localg = new g(this.lYj);
    try
    {
      localg.lYt = this;
      localg.lYu = wX(this.lYj.fRC);
      localg.lYv = a(localg.lYu, this.lYj);
      this.lYk = localg.lYv.size();
      if (!Thread.interrupted()) {
        break label124;
      }
      throw new InterruptedException();
    }
    catch (Exception localException)
    {
      if (!(localException instanceof InterruptedException)) {
        break label185;
      }
      localg.aMA = 1;
      throw localException;
    }
    finally
    {
      if (this.lYj.handler != null) {
        break label220;
      }
    }
    this.lYj.lYs.a(localg);
    for (;;)
    {
      throw ((Throwable)localObject);
      label124:
      localg.aMA = 0;
      if (this.lYj.handler == null) {
        this.lYj.lYs.a(localg);
      }
      for (;;)
      {
        GMTrace.o(18632910307328L, 138826);
        return true;
        this.lYj.handler.post(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(18633715613696L, 138832);
            e.this.lYj.lYs.a(localg);
            GMTrace.o(18633715613696L, 138832);
          }
        });
      }
      label185:
      if ((localObject instanceof OperationCanceledException))
      {
        InterruptedException localInterruptedException = new InterruptedException(((Exception)localObject).getMessage());
        localg.aMA = 1;
        break;
      }
      localg.aMA = -1;
      break;
      label220:
      this.lYj.handler.post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(18633715613696L, 138832);
          e.this.lYj.lYs.a(localg);
          GMTrace.o(18633715613696L, 138832);
        }
      });
    }
  }
  
  public String toString()
  {
    GMTrace.i(18633178742784L, 138828);
    String str = String.format("%s[%s]: %d", new Object[] { super.toString(), this.lYj.fRC, Integer.valueOf(this.lYk) });
    GMTrace.o(18633178742784L, 138828);
    return str;
  }
  
  public String[] wX(String paramString)
  {
    GMTrace.i(18633044525056L, 138827);
    paramString = c.a.lXQ.split(SpellMap.mx(paramString));
    GMTrace.o(18633044525056L, 138827);
    return paramString;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/fts/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */