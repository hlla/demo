package android.support.v7.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public final class n
  extends BaseAdapter
{
  private int a = -1;
  
  public n(m paramm)
  {
    a();
  }
  
  private final void a()
  {
    Object localObject = this.b.e;
    t localt = ((p)localObject).e;
    if (localt != null)
    {
      localObject = ((p)localObject).k();
      int j = ((ArrayList)localObject).size();
      int i = 0;
      while (i < j) {
        if ((t)((ArrayList)localObject).get(i) != localt)
        {
          i += 1;
        }
        else
        {
          this.a = i;
          return;
        }
      }
    }
    this.a = -1;
  }
  
  public final int getCount()
  {
    int j = this.b.e.k().size();
    int i = j;
    if (this.a >= 0) {
      i = j - 1;
    }
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.b;
      paramView = paramView.c.inflate(paramView.d, paramViewGroup, false);
    }
    for (;;)
    {
      ((ai)paramView).a((t)getItem(paramInt));
      return paramView;
    }
  }
  
  public final void notifyDataSetChanged()
  {
    a();
    super.notifyDataSetChanged();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */