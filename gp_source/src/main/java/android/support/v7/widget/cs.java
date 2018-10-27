package android.support.v7.widget;

import android.support.v4.view.ac;
import android.view.View;

final class cs
  extends cx
{
  cs(cx paramcx1, cx paramcx2) {}
  
  final int a(View paramView, int paramInt)
  {
    if (ac.h(paramView) == 1) {}
    for (cx localcx = this.b;; localcx = this.a) {
      return localcx.a(paramView, paramInt);
    }
  }
  
  public final int a(View paramView, int paramInt1, int paramInt2)
  {
    if (ac.h(paramView) == 1) {}
    for (cx localcx = this.b;; localcx = this.a) {
      return localcx.a(paramView, paramInt1, paramInt2);
    }
  }
  
  final String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SWITCHING[L:");
    localStringBuilder.append(this.a.a());
    localStringBuilder.append(", R:");
    localStringBuilder.append(this.b.a());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */