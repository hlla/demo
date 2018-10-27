package android.support.v7.preference;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.fe;
import android.support.v7.widget.fw;
import android.support.v7.widget.fz;
import android.view.View;

final class w
  extends fe
{
  public boolean a = true;
  public Drawable b;
  public int c;
  
  w(s params) {}
  
  private final boolean a(View paramView, RecyclerView paramRecyclerView)
  {
    fz localfz = paramRecyclerView.a(paramView);
    if (((localfz instanceof ao)) && (((ao)localfz).b))
    {
      boolean bool = this.a;
      int i = paramRecyclerView.indexOfChild(paramView);
      if (i < paramRecyclerView.getChildCount() - 1)
      {
        paramView = paramRecyclerView.a(paramRecyclerView.getChildAt(i + 1));
        if (!(paramView instanceof ao)) {
          break label85;
        }
        if (!((ao)paramView).a) {
          bool = false;
        }
      }
      else
      {
        return bool;
      }
      return true;
      label85:
      return false;
    }
    return false;
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, fw paramfw)
  {
    if (this.b != null)
    {
      int j = paramRecyclerView.getChildCount();
      int k = paramRecyclerView.getWidth();
      int i = 0;
      while (i < j)
      {
        paramfw = paramRecyclerView.getChildAt(i);
        if (a(paramfw, paramRecyclerView))
        {
          int m = (int)paramfw.getY();
          m = paramfw.getHeight() + m;
          this.b.setBounds(0, m, k, this.c + m);
          this.b.draw(paramCanvas);
        }
        i += 1;
      }
    }
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, fw paramfw)
  {
    if (a(paramView, paramRecyclerView)) {
      paramRect.bottom = this.c;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */