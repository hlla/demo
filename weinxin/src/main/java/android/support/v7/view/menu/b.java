package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.z;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class b
  implements l
{
  protected LayoutInflater Du;
  public Context PR;
  protected LayoutInflater PS;
  private int PT;
  private int PU;
  public m PV;
  public l.a dV;
  public f dW;
  public int dX;
  public Context mContext;
  
  public b(Context paramContext, int paramInt1, int paramInt2)
  {
    this.PR = paramContext;
    this.PS = LayoutInflater.from(paramContext);
    this.PT = paramInt1;
    this.PU = paramInt2;
  }
  
  public boolean B()
  {
    return false;
  }
  
  public View a(h paramh, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView instanceof m.a)) {}
    for (paramView = (m.a)paramView;; paramView = (m.a)this.PS.inflate(this.PU, paramViewGroup, false))
    {
      a(paramh, paramView);
      return (View)paramView;
    }
  }
  
  public void a(Context paramContext, f paramf)
  {
    this.mContext = paramContext;
    this.Du = LayoutInflater.from(this.mContext);
    this.dW = paramf;
  }
  
  public void a(f paramf, boolean paramBoolean)
  {
    if (this.dV != null) {
      this.dV.a(paramf, paramBoolean);
    }
  }
  
  public abstract void a(h paramh, m.a parama);
  
  public boolean a(p paramp)
  {
    if (this.dV != null) {
      return this.dV.d(paramp);
    }
    return false;
  }
  
  public final boolean b(h paramh)
  {
    return false;
  }
  
  public m c(ViewGroup paramViewGroup)
  {
    if (this.PV == null)
    {
      this.PV = ((m)this.PS.inflate(this.PT, paramViewGroup, false));
      this.PV.a(this.dW);
      f(true);
    }
    return this.PV;
  }
  
  public final boolean c(h paramh)
  {
    return false;
  }
  
  public boolean c(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.removeViewAt(paramInt);
    return true;
  }
  
  public boolean e(h paramh)
  {
    return true;
  }
  
  public void f(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)this.PV;
    if (localViewGroup == null) {}
    label225:
    label231:
    for (;;)
    {
      return;
      int j;
      if (this.dW != null)
      {
        this.dW.dA();
        ArrayList localArrayList = this.dW.dz();
        int m = localArrayList.size();
        int k = 0;
        int i = 0;
        j = i;
        if (k < m)
        {
          h localh = (h)localArrayList.get(k);
          if (!e(localh)) {
            break label225;
          }
          View localView1 = localViewGroup.getChildAt(i);
          if ((localView1 instanceof m.a)) {}
          for (Object localObject = ((m.a)localView1).z();; localObject = null)
          {
            View localView2 = a(localh, localView1, localViewGroup);
            if (localh != localObject)
            {
              localView2.setPressed(false);
              z.ab(localView2);
            }
            if (localView2 != localView1)
            {
              localObject = (ViewGroup)localView2.getParent();
              if (localObject != null) {
                ((ViewGroup)localObject).removeView(localView2);
              }
              ((ViewGroup)this.PV).addView(localView2, i);
            }
            i += 1;
            k += 1;
            break;
          }
        }
      }
      for (;;)
      {
        if (j >= localViewGroup.getChildCount()) {
          break label231;
        }
        if (!c(localViewGroup, j))
        {
          j += 1;
          continue;
          break;
          j = 0;
        }
      }
    }
  }
  
  public final int getId()
  {
    return this.dX;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/view/menu/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */