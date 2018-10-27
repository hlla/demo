package android.support.v4.view;

import android.graphics.Rect;
import android.view.View;

final class al
  implements y
{
  private final Rect a = new Rect();
  
  al(ViewPager paramViewPager) {}
  
  public final bf a(View paramView, bf parambf)
  {
    parambf = ac.a(paramView, parambf);
    paramView = parambf;
    if (!parambf.e())
    {
      paramView = this.a;
      paramView.left = parambf.a();
      paramView.top = parambf.b();
      paramView.right = parambf.c();
      paramView.bottom = parambf.d();
      int j = this.b.getChildCount();
      int i = 0;
      while (i < j)
      {
        bf localbf = ac.b(this.b.getChildAt(i), parambf);
        paramView.left = Math.min(localbf.a(), paramView.left);
        paramView.top = Math.min(localbf.b(), paramView.top);
        paramView.right = Math.min(localbf.c(), paramView.right);
        paramView.bottom = Math.min(localbf.d(), paramView.bottom);
        i += 1;
      }
      paramView = parambf.a(paramView.left, paramView.top, paramView.right, paramView.bottom);
    }
    return paramView;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */