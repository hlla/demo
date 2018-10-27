package android.support.design.appbar;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.h;
import android.util.AttributeSet;
import android.view.View;

public class i
  extends h
{
  private int a = 0;
  private j b;
  
  public i() {}
  
  public i(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    b(paramCoordinatorLayout, paramView, paramInt);
    if (this.b == null) {
      this.b = new j(paramView);
    }
    paramCoordinatorLayout = this.b;
    paramCoordinatorLayout.b = paramCoordinatorLayout.d.getTop();
    paramCoordinatorLayout.a = paramCoordinatorLayout.d.getLeft();
    paramCoordinatorLayout.a();
    paramInt = this.a;
    if (paramInt != 0)
    {
      this.b.a(paramInt);
      this.a = 0;
    }
    return true;
  }
  
  public final boolean a_(int paramInt)
  {
    j localj = this.b;
    if (localj != null) {
      return localj.a(paramInt);
    }
    this.a = paramInt;
    return false;
  }
  
  protected void b(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    paramCoordinatorLayout.a(paramView, paramInt);
  }
  
  public final int c()
  {
    j localj = this.b;
    if (localj != null) {
      return localj.c;
    }
    return 0;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/appbar/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */