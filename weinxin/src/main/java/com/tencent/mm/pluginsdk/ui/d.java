package com.tencent.mm.pluginsdk.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.gmtrace.GMTrace;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class d
  implements AbsListView.OnScrollListener
{
  private AbsListView.OnScrollListener sGF;
  private ArrayList<WeakReference<a>> sGG;
  
  public d()
  {
    this(null);
    GMTrace.i(1151856541696L, 8582);
    GMTrace.o(1151856541696L, 8582);
  }
  
  public d(AbsListView.OnScrollListener paramOnScrollListener)
  {
    GMTrace.i(1151990759424L, 8583);
    this.sGG = new ArrayList();
    this.sGF = paramOnScrollListener;
    GMTrace.o(1151990759424L, 8583);
  }
  
  private void ji(boolean paramBoolean)
  {
    GMTrace.i(1152527630336L, 8587);
    int i = 0;
    if (i < this.sGG.size())
    {
      Object localObject = (WeakReference)this.sGG.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).onScrollStateChanged(paramBoolean);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        this.sGG.remove(i);
        continue;
        this.sGG.remove(i);
      }
    }
    GMTrace.o(1152527630336L, 8587);
  }
  
  public final void a(a parama)
  {
    GMTrace.i(1152393412608L, 8586);
    this.sGG.add(new WeakReference(parama));
    GMTrace.o(1152393412608L, 8586);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    GMTrace.i(1152124977152L, 8584);
    if (this.sGF != null) {
      this.sGF.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    GMTrace.o(1152124977152L, 8584);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    GMTrace.i(1152259194880L, 8585);
    if (paramInt == 2) {
      ji(true);
    }
    for (;;)
    {
      if (this.sGF != null) {
        this.sGF.onScrollStateChanged(paramAbsListView, paramInt);
      }
      GMTrace.o(1152259194880L, 8585);
      return;
      ji(false);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onScrollStateChanged(boolean paramBoolean);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */