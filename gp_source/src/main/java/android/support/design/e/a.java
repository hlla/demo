package android.support.design.e;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.util.StateSet;

public final class a
{
  private static final int[] a;
  private static final int[] b;
  private static final int[] c;
  private static final int[] d;
  private static final int[] e;
  private static final int[] f;
  private static final int[] g;
  private static final int[] h;
  private static final int[] i;
  private static final boolean j;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (boolean bool = true;; bool = false)
    {
      j = bool;
      d = new int[] { 16842919 };
      b = new int[] { 16843623, 16842908 };
      a = new int[] { 16842908 };
      c = new int[] { 16843623 };
      h = new int[] { 16842913, 16842919 };
      f = new int[] { 16842913, 16843623, 16842908 };
      e = new int[] { 16842913, 16842908 };
      g = new int[] { 16842913, 16843623 };
      i = new int[] { 16842913 };
      return;
    }
  }
  
  private static int a(ColorStateList paramColorStateList, int[] paramArrayOfInt)
  {
    if (paramColorStateList != null) {}
    for (int k = paramColorStateList.getColorForState(paramArrayOfInt, paramColorStateList.getDefaultColor());; k = 0)
    {
      int m = k;
      if (j)
      {
        m = Color.alpha(k);
        m = android.support.v4.a.a.b(k, Math.min(m + m, 255));
      }
      return m;
    }
  }
  
  public static ColorStateList a(ColorStateList paramColorStateList)
  {
    if (j)
    {
      arrayOfInt1 = i;
      k = a(paramColorStateList, h);
      arrayOfInt2 = StateSet.NOTHING;
      m = a(paramColorStateList, d);
      return new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2 }, new int[] { k, m });
    }
    int[] arrayOfInt1 = h;
    int k = a(paramColorStateList, h);
    int[] arrayOfInt2 = f;
    int m = a(paramColorStateList, f);
    int[] arrayOfInt3 = e;
    int n = a(paramColorStateList, e);
    int[] arrayOfInt4 = g;
    int i1 = a(paramColorStateList, g);
    int[] arrayOfInt5 = i;
    int[] arrayOfInt6 = d;
    int i2 = a(paramColorStateList, d);
    int[] arrayOfInt7 = b;
    int i3 = a(paramColorStateList, b);
    int[] arrayOfInt8 = a;
    int i4 = a(paramColorStateList, a);
    int[] arrayOfInt9 = c;
    int i5 = a(paramColorStateList, c);
    return new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6, arrayOfInt7, arrayOfInt8, arrayOfInt9, StateSet.NOTHING }, new int[] { k, m, n, i1, 0, i2, i3, i4, i5, 0 });
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */