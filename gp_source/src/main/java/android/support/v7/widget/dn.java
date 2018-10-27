package android.support.v7.widget;

import android.view.View;
import java.util.List;

public final class dn
{
  public int a;
  public int b;
  public int c = 0;
  public boolean d;
  public int e;
  public int f;
  public int g;
  public int h;
  public boolean i = true;
  public List j = null;
  public int k;
  
  final View a(fp paramfp)
  {
    Object localObject = this.j;
    if (localObject != null)
    {
      int n = ((List)localObject).size();
      int m = 0;
      if (m < n)
      {
        paramfp = ((fz)this.j.get(m)).c;
        localObject = (fj)paramfp.getLayoutParams();
        if (((fj)localObject).d.l()) {}
        while (this.b != ((fj)localObject).d.c())
        {
          m += 1;
          break;
        }
        a(paramfp);
        return paramfp;
      }
      return null;
    }
    paramfp = paramfp.a(this.b, Long.MAX_VALUE).c;
    this.b += this.e;
    return paramfp;
  }
  
  public final void a(View paramView)
  {
    int i2 = this.j.size();
    Object localObject = null;
    int m = Integer.MAX_VALUE;
    int n = 0;
    View localView;
    int i1;
    if (n < i2)
    {
      localView = ((fz)this.j.get(n)).c;
      fj localfj = (fj)localView.getLayoutParams();
      if (localView == paramView) {
        break label163;
      }
      if (localfj.d.l()) {
        break label160;
      }
      i1 = (localfj.d.c() - this.b) * this.e;
      if (i1 >= 0) {}
    }
    label160:
    label163:
    for (;;)
    {
      n += 1;
      break;
      if (i1 < m)
      {
        localObject = localView;
        if (i1 != 0)
        {
          localObject = localView;
          m = i1;
        }
        else
        {
          if (localObject != null)
          {
            this.b = ((fj)((View)localObject).getLayoutParams()).d.c();
            return;
          }
          this.b = -1;
          return;
        }
      }
    }
  }
  
  public final boolean a(fw paramfw)
  {
    int m = this.b;
    return (m >= 0) && (m < paramfw.a());
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/dn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */