package android.support.v7.widget;

import android.view.View;

public final class dl
{
  public int a;
  public boolean b;
  public eh c;
  public int d;
  public boolean e;
  
  dl()
  {
    a();
  }
  
  final void a()
  {
    this.d = -1;
    this.a = Integer.MIN_VALUE;
    this.b = false;
    this.e = false;
  }
  
  public final void a(View paramView, int paramInt)
  {
    int i = this.c.a();
    if (i >= 0) {
      b(paramView, paramInt);
    }
    do
    {
      int j;
      do
      {
        do
        {
          do
          {
            return;
            this.d = paramInt;
            if (!this.b) {
              break;
            }
            paramInt = this.c.c() - i - this.c.b(paramView);
            this.a = (this.c.c() - paramInt);
          } while (paramInt <= 0);
          i = this.c.e(paramView);
          j = this.a;
          k = this.c.b();
          i = j - i - (Math.min(this.c.a(paramView) - k, 0) + k);
        } while (i >= 0);
        j = this.a;
        this.a = (Math.min(paramInt, -i) + j);
        return;
        j = this.c.a(paramView);
        paramInt = j - this.c.b();
        this.a = j;
      } while (paramInt <= 0);
      int k = this.c.e(paramView);
      int m = this.c.c();
      int n = this.c.b(paramView);
      i = this.c.c() - Math.min(0, m - i - n) - (j + k);
    } while (i >= 0);
    this.a -= Math.min(paramInt, -i);
  }
  
  final void b()
  {
    if (this.b) {}
    for (int i = this.c.c();; i = this.c.b())
    {
      this.a = i;
      return;
    }
  }
  
  public final void b(View paramView, int paramInt)
  {
    if (this.b) {}
    for (this.a = (this.c.b(paramView) + this.c.a());; this.a = this.c.a(paramView))
    {
      this.d = paramInt;
      return;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AnchorInfo{mPosition=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mCoordinate=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mLayoutFromEnd=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mValid=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/dl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */