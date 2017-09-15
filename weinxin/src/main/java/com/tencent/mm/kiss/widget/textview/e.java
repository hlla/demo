package com.tencent.mm.kiss.widget.textview;

import android.text.Layout.Alignment;
import android.text.TextPaint;
import com.tencent.gmtrace.GMTrace;

public final class e
{
  private final d[] hax;
  private final Object mLock;
  private int wg;
  
  public e()
  {
    GMTrace.i(428691423232L, 3194);
    this.mLock = new Object();
    this.hax = new d[3];
    GMTrace.o(428691423232L, 3194);
  }
  
  public final boolean a(d paramd)
  {
    GMTrace.i(428959858688L, 3196);
    Object localObject = this.mLock;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= this.wg) {
          break label64;
        }
        if (this.hax[i] == paramd)
        {
          i = 1;
          if (i == 0) {
            break;
          }
          throw new IllegalStateException("Already in the pool!");
        }
      }
      finally {}
      i += 1;
      continue;
      label64:
      i = 0;
    }
    paramd.hak = null;
    paramd.hal = null;
    paramd.ham = 0;
    paramd.han = 0;
    paramd.hao = new TextPaint();
    paramd.width = 0;
    paramd.hap = Layout.Alignment.ALIGN_NORMAL;
    paramd.gravity = 51;
    paramd.haq = null;
    paramd.har = 0;
    paramd.maxLines = Integer.MAX_VALUE;
    paramd.has = null;
    paramd.hat = 0.0F;
    paramd.hau = 1.0F;
    paramd.hav = false;
    paramd.maxLength = 0;
    paramd.haw = null;
    if (this.wg < this.hax.length)
    {
      this.hax[this.wg] = paramd;
      this.wg += 1;
      GMTrace.o(428959858688L, 3196);
      return true;
    }
    GMTrace.o(428959858688L, 3196);
    return false;
  }
  
  public final d vX()
  {
    GMTrace.i(428825640960L, 3195);
    synchronized (this.mLock)
    {
      if (this.wg > 0)
      {
        int i = this.wg - 1;
        d locald = this.hax[i];
        this.hax[i] = null;
        this.wg -= 1;
        GMTrace.o(428825640960L, 3195);
        return locald;
      }
      GMTrace.o(428825640960L, 3195);
      return null;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/kiss/widget/textview/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */