package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;

public final class o
  implements Runnable
{
  public int mMode;
  public ListView ogg;
  public long wlM;
  public int wlN;
  public int wlO;
  public int wlP;
  private final int wlQ;
  public int wlR;
  
  public o(ListView paramListView)
  {
    GMTrace.i(1912602624000L, 14250);
    this.wlM = System.currentTimeMillis();
    this.ogg = paramListView;
    this.wlQ = ViewConfiguration.get(this.ogg.getContext()).getScaledFadingEdgeLength();
    v.d("ScrollerRunnable", "mExtraScroll: %d", new Object[] { Integer.valueOf(this.wlQ) });
    GMTrace.o(1912602624000L, 14250);
  }
  
  public final void run()
  {
    GMTrace.i(1912736841728L, 14251);
    if (System.currentTimeMillis() - this.wlM > 10000L)
    {
      GMTrace.o(1912736841728L, 14251);
      return;
    }
    int j = this.ogg.getHeight();
    int k = this.ogg.getFirstVisiblePosition();
    View localView;
    switch (this.mMode)
    {
    default: 
      GMTrace.o(1912736841728L, 14251);
      return;
    case 1: 
      i = this.ogg.getChildCount() - 1;
      k += i;
      if (i < 0)
      {
        GMTrace.o(1912736841728L, 14251);
        return;
      }
      int m;
      int n;
      if (k == this.wlO)
      {
        if (this.wlR > 20)
        {
          this.ogg.setSelection(this.wlN);
          v.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
        }
      }
      else
      {
        this.wlR = 0;
        localView = this.ogg.getChildAt(i);
        m = localView.getHeight();
        n = localView.getTop();
        if (k >= this.ogg.getCount() - 1) {
          break label295;
        }
      }
      label295:
      for (i = this.wlQ;; i = this.ogg.getPaddingBottom())
      {
        this.ogg.smoothScrollBy(i + (m - (j - n)), this.wlP);
        this.wlO = k;
        if (k >= this.wlN) {
          break;
        }
        this.ogg.post(this);
        GMTrace.o(1912736841728L, 14251);
        return;
        this.ogg.post(this);
        this.wlR += 1;
        v.d("ScrollerRunnable", "dz:try scroll lastpos = %d", new Object[] { Integer.valueOf(k) });
        GMTrace.o(1912736841728L, 14251);
        return;
      }
    }
    if (k == this.wlO)
    {
      if (this.wlR > 20)
      {
        this.ogg.setSelection(this.wlN);
        v.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
      }
    }
    else
    {
      this.wlR = 0;
      localView = this.ogg.getChildAt(0);
      if (localView != null) {
        break label418;
      }
      GMTrace.o(1912736841728L, 14251);
      return;
    }
    this.ogg.post(this);
    this.wlR += 1;
    v.d("ScrollerRunnable", "dz:try scroll firstPos = %d", new Object[] { Integer.valueOf(k) });
    GMTrace.o(1912736841728L, 14251);
    return;
    label418:
    j = localView.getTop();
    if (k > 0) {}
    for (int i = this.wlQ;; i = this.ogg.getPaddingTop())
    {
      this.ogg.smoothScrollBy(j - i, this.wlP);
      this.wlO = k;
      if (k <= this.wlN) {
        break;
      }
      this.ogg.post(this);
      break;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/tools/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */