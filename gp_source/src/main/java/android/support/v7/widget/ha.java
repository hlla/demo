package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.a.a;
import android.util.TypedValue;

final class ha
{
  public static final int[] a = { 16842912 };
  public static final int[] b;
  public static final int[] c = new int[0];
  public static final int[] d;
  public static final int[] e;
  private static final int[] f = new int[1];
  private static final ThreadLocal g = new ThreadLocal();
  
  static
  {
    b = new int[] { -16842910 };
    d = new int[] { 16842908 };
    e = new int[] { 16842919 };
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    f[0] = paramInt;
    paramContext = hf.a(paramContext, null, f);
    try
    {
      paramInt = paramContext.b(0, 0);
      return paramInt;
    }
    finally
    {
      paramContext.c.recycle();
    }
  }
  
  public static ColorStateList b(Context paramContext, int paramInt)
  {
    f[0] = paramInt;
    paramContext = hf.a(paramContext, null, f);
    try
    {
      ColorStateList localColorStateList = paramContext.e(0);
      return localColorStateList;
    }
    finally
    {
      paramContext.c.recycle();
    }
  }
  
  public static int c(Context paramContext, int paramInt)
  {
    Object localObject = b(paramContext, paramInt);
    if ((localObject != null) && (((ColorStateList)localObject).isStateful())) {
      return ((ColorStateList)localObject).getColorForState(b, ((ColorStateList)localObject).getDefaultColor());
    }
    TypedValue localTypedValue = (TypedValue)g.get();
    localObject = localTypedValue;
    if (localTypedValue == null)
    {
      localObject = new TypedValue();
      g.set(localObject);
    }
    paramContext.getTheme().resolveAttribute(16842803, (TypedValue)localObject, true);
    float f1 = ((TypedValue)localObject).getFloat();
    paramInt = a(paramContext, paramInt);
    return a.b(paramInt, Math.round(f1 * Color.alpha(paramInt)));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */