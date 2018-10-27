package android.support.design.d;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

public final class a
{
  public static ColorStateList a(Context paramContext, TypedArray paramTypedArray, int paramInt)
  {
    if (paramTypedArray.hasValue(paramInt))
    {
      int i = paramTypedArray.getResourceId(paramInt, 0);
      if (i != 0)
      {
        ColorStateList localColorStateList = android.support.v7.b.a.a.a(paramContext, i);
        paramContext = localColorStateList;
        if (localColorStateList != null) {
          return paramContext;
        }
      }
    }
    paramContext = paramTypedArray.getColorStateList(paramInt);
    return paramContext;
  }
  
  public static Drawable b(Context paramContext, TypedArray paramTypedArray, int paramInt)
  {
    if (paramTypedArray.hasValue(paramInt))
    {
      int i = paramTypedArray.getResourceId(paramInt, 0);
      if (i != 0)
      {
        Drawable localDrawable = android.support.v7.b.a.a.b(paramContext, i);
        paramContext = localDrawable;
        if (localDrawable != null) {
          return paramContext;
        }
      }
    }
    paramContext = paramTypedArray.getDrawable(paramInt);
    return paramContext;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */