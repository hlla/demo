package android.support.v7.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class d
  implements af
{
  public ag a;
  public Context b;
  public p c;
  public ah d;
  public Context e;
  private int f;
  private int g;
  private LayoutInflater h;
  
  public d(Context paramContext)
  {
    this.e = paramContext;
    this.h = LayoutInflater.from(paramContext);
    this.g = 2131623939;
    this.f = 2131623938;
  }
  
  public ah a(ViewGroup paramViewGroup)
  {
    if (this.d == null)
    {
      this.d = ((ah)this.h.inflate(this.g, paramViewGroup, false));
      this.d.a(this.c);
      a(true);
    }
    return this.d;
  }
  
  public View a(t paramt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView instanceof ai)) {}
    for (paramView = (ai)paramView;; paramView = (ai)this.h.inflate(this.f, paramViewGroup, false))
    {
      a(paramt, paramView);
      return (View)paramView;
    }
  }
  
  public void a(Context paramContext, p paramp)
  {
    this.b = paramContext;
    LayoutInflater.from(this.b);
    this.c = paramp;
  }
  
  public final void a(ag paramag)
  {
    this.a = paramag;
  }
  
  public void a(p paramp, boolean paramBoolean)
  {
    ag localag = this.a;
    if (localag != null) {
      localag.a(paramp, paramBoolean);
    }
  }
  
  public abstract void a(t paramt, ai paramai);
  
  public void a(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)this.d;
    if (localViewGroup != null)
    {
      Object localObject = this.c;
      int j;
      if (localObject != null)
      {
        ((p)localObject).j();
        ArrayList localArrayList = this.c.i();
        int m = localArrayList.size();
        int k = 0;
        int i = 0;
        j = i;
        if (k < m)
        {
          t localt = (t)localArrayList.get(k);
          if (a(localt))
          {
            View localView1 = localViewGroup.getChildAt(i);
            if ((localView1 instanceof ai))
            {
              localObject = ((ai)localView1).getItemData();
              label109:
              View localView2 = a(localt, localView1, localViewGroup);
              if (localt != localObject)
              {
                localView2.setPressed(false);
                localView2.jumpDrawablesToCurrentState();
              }
              if (localView2 != localView1)
              {
                localObject = (ViewGroup)localView2.getParent();
                if (localObject != null) {
                  ((ViewGroup)localObject).removeView(localView2);
                }
                ((ViewGroup)this.d).addView(localView2, i);
              }
              i += 1;
            }
          }
          for (;;)
          {
            k += 1;
            break;
            localObject = null;
            break label109;
          }
        }
      }
      while (j < localViewGroup.getChildCount()) {
        if (!a(localViewGroup, j))
        {
          j += 1;
          continue;
          j = 0;
        }
      }
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(ap paramap)
  {
    ag localag = this.a;
    if (localag == null) {
      return false;
    }
    return localag.a(paramap);
  }
  
  public boolean a(t paramt)
  {
    return true;
  }
  
  public boolean a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.removeViewAt(paramInt);
    return true;
  }
  
  public final boolean b(t paramt)
  {
    return false;
  }
  
  public final boolean c(t paramt)
  {
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */