package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public final class be
{
  public final bf a;
  public final bg b;
  public final List c;
  
  be(bg parambg)
  {
    this.b = parambg;
    this.a = new bf();
    this.c = new ArrayList();
  }
  
  public final int a()
  {
    return this.b.a() - this.c.size();
  }
  
  final int a(int paramInt)
  {
    if (paramInt >= 0)
    {
      int k = this.b.a();
      int j = paramInt;
      while (j < k)
      {
        int m = paramInt - (j - this.a.e(j));
        int i = j;
        if (m != 0) {
          j += m;
        } else {
          for (;;)
          {
            paramInt = i;
            if (!this.a.c(i)) {
              break;
            }
            i += 1;
          }
        }
      }
      paramInt = -1;
      return paramInt;
    }
    return -1;
  }
  
  final void a(View paramView)
  {
    this.c.add(paramView);
    this.b.c(paramView);
  }
  
  final void a(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if (paramInt < 0) {}
    for (paramInt = this.b.a();; paramInt = a(paramInt))
    {
      this.a.a(paramInt, paramBoolean);
      if (paramBoolean) {
        a(paramView);
      }
      this.b.a(paramView, paramInt, paramLayoutParams);
      return;
    }
  }
  
  final void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 0) {}
    for (paramInt = this.b.a();; paramInt = a(paramInt))
    {
      this.a.a(paramInt, paramBoolean);
      if (paramBoolean) {
        a(paramView);
      }
      this.b.a(paramView, paramInt);
      return;
    }
  }
  
  final int b()
  {
    return this.b.a();
  }
  
  public final View b(int paramInt)
  {
    paramInt = a(paramInt);
    return this.b.b(paramInt);
  }
  
  final boolean b(View paramView)
  {
    if (this.c.remove(paramView))
    {
      this.b.d(paramView);
      return true;
    }
    return false;
  }
  
  final int c(View paramView)
  {
    int j = -1;
    int k = this.b.a(paramView);
    int i = j;
    if (k != -1)
    {
      i = j;
      if (!this.a.c(k)) {
        i = k - this.a.e(k);
      }
    }
    return i;
  }
  
  final View c(int paramInt)
  {
    return this.b.b(paramInt);
  }
  
  final void d(int paramInt)
  {
    paramInt = a(paramInt);
    this.a.d(paramInt);
    this.b.c(paramInt);
  }
  
  final boolean d(View paramView)
  {
    return this.c.contains(paramView);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.toString());
    localStringBuilder.append(", hidden list:");
    localStringBuilder.append(this.c.size());
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */