package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;

abstract class ac
  implements af, al, AdapterView.OnItemClickListener
{
  public Rect g;
  
  protected static int a(ListAdapter paramListAdapter, ViewGroup paramViewGroup, Context paramContext, int paramInt)
  {
    int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i3 = paramListAdapter.getCount();
    int m = 0;
    int k = 0;
    View localView = null;
    int i = 0;
    if (m < i3)
    {
      int n = paramListAdapter.getItemViewType(m);
      if (n != k) {}
      for (int j = n;; j = k)
      {
        if (n != k) {
          localView = null;
        }
        for (;;)
        {
          if (paramViewGroup == null) {
            paramViewGroup = new FrameLayout(paramContext);
          }
          for (;;)
          {
            localView = paramListAdapter.getView(m, localView, paramViewGroup);
            localView.measure(i1, i2);
            n = localView.getMeasuredWidth();
            k = paramInt;
            if (n >= paramInt) {
              break label167;
            }
            if (n > i) {
              i = n;
            }
            for (;;)
            {
              m += 1;
              k = j;
              break;
            }
          }
        }
      }
    }
    k = i;
    label167:
    return k;
  }
  
  protected static o a(ListAdapter paramListAdapter)
  {
    if ((paramListAdapter instanceof HeaderViewListAdapter)) {
      return (o)((HeaderViewListAdapter)paramListAdapter).getWrappedAdapter();
    }
    return (o)paramListAdapter;
  }
  
  protected static boolean b(p paramp)
  {
    boolean bool2 = false;
    int j = paramp.size();
    int i = 0;
    boolean bool1 = bool2;
    if (i < j)
    {
      MenuItem localMenuItem = paramp.getItem(i);
      if (!localMenuItem.isVisible()) {}
      while (localMenuItem.getIcon() == null)
      {
        i += 1;
        break;
      }
      bool1 = true;
    }
    return bool1;
  }
  
  public abstract void a(int paramInt);
  
  public final void a(Context paramContext, p paramp) {}
  
  public abstract void a(p paramp);
  
  public abstract void a(View paramView);
  
  public abstract void a(PopupWindow.OnDismissListener paramOnDismissListener);
  
  public abstract void b(int paramInt);
  
  public abstract void b(boolean paramBoolean);
  
  public final boolean b(t paramt)
  {
    return false;
  }
  
  public abstract void c(int paramInt);
  
  public abstract void c(boolean paramBoolean);
  
  public final boolean c(t paramt)
  {
    return false;
  }
  
  protected boolean f()
  {
    return true;
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = (ListAdapter)paramAdapterView.getAdapter();
    paramAdapterView = a(paramView).a;
    paramView = (MenuItem)paramView.getItem(paramInt);
    if (!f()) {}
    for (paramInt = 4;; paramInt = 0)
    {
      paramAdapterView.a(paramView, this, paramInt);
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */