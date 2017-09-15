package com.tencent.mm.ui.applet;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.gmtrace.GMTrace;

public final class a
  implements AbsListView.OnScrollListener
{
  private AbsListView.OnScrollListener sGF;
  
  public a()
  {
    this((byte)0);
    GMTrace.i(1847104372736L, 13762);
    GMTrace.o(1847104372736L, 13762);
  }
  
  private a(byte paramByte)
  {
    GMTrace.i(1847238590464L, 13763);
    this.sGF = null;
    GMTrace.o(1847238590464L, 13763);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    GMTrace.i(1847372808192L, 13764);
    if (this.sGF != null) {
      this.sGF.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    GMTrace.o(1847372808192L, 13764);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    GMTrace.i(1847507025920L, 13765);
    if (this.sGF != null) {
      this.sGF.onScrollStateChanged(paramAbsListView, paramInt);
    }
    GMTrace.o(1847507025920L, 13765);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/applet/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */