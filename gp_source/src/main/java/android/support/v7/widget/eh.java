package android.support.v7.widget;

import android.graphics.Rect;
import android.view.View;

public abstract class eh
{
  public int a = Integer.MIN_VALUE;
  public final ff b;
  public final Rect c = new Rect();
  
  private eh(ff paramff)
  {
    this.b = paramff;
  }
  
  public final int a()
  {
    if (this.a != Integer.MIN_VALUE) {
      return e() - this.a;
    }
    return 0;
  }
  
  public abstract int a(View paramView);
  
  public abstract void a(int paramInt);
  
  public abstract int b();
  
  public abstract int b(View paramView);
  
  public abstract int c();
  
  public abstract int c(View paramView);
  
  public abstract int d();
  
  public abstract int d(View paramView);
  
  public abstract int e();
  
  public abstract int e(View paramView);
  
  public abstract int f();
  
  public abstract int f(View paramView);
  
  public abstract int g();
  
  public abstract int h();
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/eh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */