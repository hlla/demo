package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.a.b;
import android.support.v4.view.a.b.e;
import android.support.v4.view.a.b.k;
import android.support.v4.view.z;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public final class ac
  extends a
{
  final RecyclerView aak;
  final a abu = new a()
  {
    public final void a(View paramAnonymousView, b paramAnonymousb)
    {
      super.a(paramAnonymousView, paramAnonymousb);
      if ((!ac.this.gd()) && (ac.this.aak.Zf != null)) {
        ac.this.aak.Zf.b(paramAnonymousView, paramAnonymousb);
      }
    }
    
    public final boolean performAccessibilityAction(View paramAnonymousView, int paramAnonymousInt, Bundle paramAnonymousBundle)
    {
      boolean bool2 = false;
      boolean bool1;
      if (super.performAccessibilityAction(paramAnonymousView, paramAnonymousInt, paramAnonymousBundle)) {
        bool1 = true;
      }
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (ac.this.gd());
        bool1 = bool2;
      } while (ac.this.aak.Zf == null);
      paramAnonymousView = ac.this.aak.Zf;
      paramAnonymousBundle = paramAnonymousView.aak.YX;
      paramAnonymousView = paramAnonymousView.aak.ZL;
      return false;
    }
  };
  
  public ac(RecyclerView paramRecyclerView)
  {
    this.aak = paramRecyclerView;
  }
  
  public final void a(View paramView, b paramb)
  {
    super.a(paramView, paramb);
    paramb.setClassName(RecyclerView.class.getName());
    if ((!gd()) && (this.aak.Zf != null))
    {
      paramView = this.aak.Zf;
      RecyclerView.m localm = paramView.aak.YX;
      RecyclerView.q localq = paramView.aak.ZL;
      if ((z.h(paramView.aak, -1)) || (z.g(paramView.aak, -1)))
      {
        paramb.addAction(8192);
        paramb.setScrollable(true);
      }
      if ((z.h(paramView.aak, 1)) || (z.g(paramView.aak, 1)))
      {
        paramb.addAction(4096);
        paramb.setScrollable(true);
      }
      int i = paramView.a(localm, localq);
      int j = paramView.b(localm, localq);
      paramView = new b.k(b.zK.a(i, j, false, 0));
      b.zK.f(paramb.zL, ((b.k)paramView).zL);
    }
  }
  
  public final boolean gd()
  {
    RecyclerView localRecyclerView = this.aak;
    return (!localRecyclerView.Zm) || (localRecyclerView.Zv) || (localRecyclerView.YZ.et());
  }
  
  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(RecyclerView.class.getName());
    if (((paramView instanceof RecyclerView)) && (!gd()))
    {
      paramView = (RecyclerView)paramView;
      if (paramView.Zf != null) {
        paramView.Zf.onInitializeAccessibilityEvent(paramAccessibilityEvent);
      }
    }
  }
  
  public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool1;
    if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
      bool1 = true;
    }
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (gd());
          bool1 = bool2;
        } while (this.aak.Zf == null);
        paramView = this.aak.Zf;
        paramBundle = paramView.aak.YX;
        paramBundle = paramView.aak.ZL;
        bool1 = bool2;
      } while (paramView.aak == null);
      switch (paramInt)
      {
      default: 
        paramInt = 0;
        i = 0;
        if (i != 0) {
          break label126;
        }
        bool1 = bool2;
      }
    } while (paramInt == 0);
    label126:
    paramView.aak.scrollBy(paramInt, i);
    return true;
    if (z.h(paramView.aak, -1)) {}
    for (paramInt = -(paramView.RQ - paramView.getPaddingTop() - paramView.getPaddingBottom());; paramInt = 0)
    {
      i = paramInt;
      int j;
      if (z.g(paramView.aak, -1))
      {
        j = -(paramView.aar - paramView.getPaddingLeft() - paramView.getPaddingRight());
        i = paramInt;
        paramInt = j;
        break;
        if (!z.h(paramView.aak, 1)) {
          break label283;
        }
      }
      label283:
      for (paramInt = paramView.RQ - paramView.getPaddingTop() - paramView.getPaddingBottom();; paramInt = 0)
      {
        i = paramInt;
        if (z.g(paramView.aak, 1))
        {
          j = paramView.aar;
          int k = paramView.getPaddingLeft();
          int m = paramView.getPaddingRight();
          i = paramInt;
          paramInt = j - k - m;
          break;
        }
        paramInt = 0;
        break;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */