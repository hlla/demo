package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.a.b;

final class t
{
  private static final int[] lk = { a.b.colorPrimary };
  
  static void g(Context paramContext)
  {
    int i = 0;
    paramContext = paramContext.obtainStyledAttributes(lk);
    if (!paramContext.hasValue(0)) {
      i = 1;
    }
    if (paramContext != null) {
      paramContext.recycle();
    }
    if (i != 0) {
      throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/design/widget/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */