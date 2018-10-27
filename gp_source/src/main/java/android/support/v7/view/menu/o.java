package android.support.v7.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public final class o
  extends BaseAdapter
{
  public p a;
  public boolean b;
  private int c = -1;
  private final LayoutInflater d;
  private final int e;
  private final boolean f;
  
  public o(p paramp, LayoutInflater paramLayoutInflater, boolean paramBoolean, int paramInt)
  {
    this.f = paramBoolean;
    this.d = paramLayoutInflater;
    this.a = paramp;
    this.e = paramInt;
    a();
  }
  
  private final void a()
  {
    Object localObject = this.a;
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
          this.c = i;
          return;
        }
      }
    }
    this.c = -1;
  }
  
  public final int getCount()
  {
    if (this.f) {}
    for (ArrayList localArrayList = this.a.k();; localArrayList = this.a.i())
    {
      if (this.c < 0) {
        return localArrayList.size();
      }
      return localArrayList.size() - 1;
    }
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = this.d.inflate(this.e, paramViewGroup, false);
    }
    for (;;)
    {
      int j = ((t)getItem(paramInt)).getGroupId();
      int i = paramInt - 1;
      if (i >= 0) {}
      for (i = ((t)getItem(i)).getGroupId();; i = j)
      {
        paramViewGroup = (ListMenuItemView)paramView;
        boolean bool;
        if (!this.a.b()) {
          bool = false;
        }
        for (;;)
        {
          paramViewGroup.setGroupDividerEnabled(bool);
          ai localai = (ai)paramView;
          if (this.b) {
            paramViewGroup.setForceShowIcon(true);
          }
          localai.a((t)getItem(paramInt));
          return paramView;
          if (j != i) {
            bool = true;
          } else {
            bool = false;
          }
        }
      }
    }
  }
  
  public final void notifyDataSetChanged()
  {
    a();
    super.notifyDataSetChanged();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */