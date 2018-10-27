package android.support.v7.widget;

import android.support.v4.view.ah;
import android.view.View;

class dc
{
  public int a;
  private int b;
  private int c;
  
  dc()
  {
    a();
  }
  
  protected int a(GridLayout paramGridLayout, View paramView, cx paramcx, int paramInt, boolean paramBoolean)
  {
    return this.c - paramcx.a(paramView, paramInt, ah.a(paramGridLayout));
  }
  
  protected int a(boolean paramBoolean)
  {
    if ((paramBoolean) || (!GridLayout.b(this.a))) {
      return this.c + this.b;
    }
    return 100000;
  }
  
  protected void a()
  {
    this.c = Integer.MIN_VALUE;
    this.b = Integer.MIN_VALUE;
    this.a = 2;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    this.c = Math.max(this.c, paramInt1);
    this.b = Math.max(this.b, paramInt2);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bounds{before=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", after=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/dc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */