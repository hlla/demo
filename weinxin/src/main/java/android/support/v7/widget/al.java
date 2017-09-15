package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.b.b;
import android.util.TypedValue;

final class al
{
  static final int[] EMPTY_STATE_SET = new int[0];
  static final int[] FOCUSED_STATE_SET;
  static final int[] PRESSED_STATE_SET;
  static final int[] SELECTED_STATE_SET;
  private static final int[] aeA = new int[1];
  private static final ThreadLocal<TypedValue> aex = new ThreadLocal();
  static final int[] aey;
  static final int[] aez;
  static final int[] dN;
  static final int[] iK = { -16842910 };
  
  static
  {
    FOCUSED_STATE_SET = new int[] { 16842908 };
    aey = new int[] { 16843518 };
    PRESSED_STATE_SET = new int[] { 16842919 };
    dN = new int[] { 16842912 };
    SELECTED_STATE_SET = new int[] { 16842913 };
    aez = new int[] { -16842919, -16842908 };
  }
  
  static int a(Context paramContext, int paramInt, float paramFloat)
  {
    paramInt = h(paramContext, paramInt);
    return b.j(paramInt, Math.round(Color.alpha(paramInt) * paramFloat));
  }
  
  public static int h(Context paramContext, int paramInt)
  {
    aeA[0] = paramInt;
    paramContext = paramContext.obtainStyledAttributes(null, aeA);
    try
    {
      paramInt = paramContext.getColor(0, 0);
      return paramInt;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  public static ColorStateList i(Context paramContext, int paramInt)
  {
    aeA[0] = paramInt;
    paramContext = paramContext.obtainStyledAttributes(null, aeA);
    try
    {
      ColorStateList localColorStateList = paramContext.getColorStateList(0);
      return localColorStateList;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  public static int j(Context paramContext, int paramInt)
  {
    Object localObject = i(paramContext, paramInt);
    if ((localObject != null) && (((ColorStateList)localObject).isStateful())) {
      return ((ColorStateList)localObject).getColorForState(iK, ((ColorStateList)localObject).getDefaultColor());
    }
    TypedValue localTypedValue = (TypedValue)aex.get();
    localObject = localTypedValue;
    if (localTypedValue == null)
    {
      localObject = new TypedValue();
      aex.set(localObject);
    }
    paramContext.getTheme().resolveAttribute(16842803, (TypedValue)localObject, true);
    return a(paramContext, paramInt, ((TypedValue)localObject).getFloat());
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */