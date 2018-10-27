package android.support.design.internal;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.support.v7.view.e;
import android.support.v7.widget.hf;
import android.util.AttributeSet;
import android.util.TypedValue;

public final class n
{
  private static final int[] a = { 2130968792 };
  private static final int[] b = { 2130968794 };
  
  public static Context a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16842752 });
    int i = paramAttributeSet.getResourceId(0, 0);
    paramAttributeSet.recycle();
    paramAttributeSet = paramContext;
    if (i == 0)
    {
      paramAttributeSet = paramContext.getTheme().obtainStyledAttributes(new int[] { paramInt });
      paramInt = paramAttributeSet.getResourceId(0, 0);
      paramAttributeSet.recycle();
      paramAttributeSet = paramContext;
      if (paramInt != 0)
      {
        paramAttributeSet = paramContext.obtainStyledAttributes(paramInt, new int[] { 16842752 });
        paramInt = paramAttributeSet.getResourceId(0, 0);
        paramAttributeSet.recycle();
        paramAttributeSet = paramContext;
        if (paramInt != 0) {
          if ((paramContext instanceof e))
          {
            paramAttributeSet = paramContext;
            if (((e)paramContext).a == paramInt) {}
          }
          else
          {
            paramAttributeSet = new e(paramContext, paramInt);
          }
        }
      }
    }
    return paramAttributeSet;
  }
  
  public static TypedArray a(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int... paramVarArgs)
  {
    a(paramContext, paramAttributeSet, paramInt1, paramInt2);
    b(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2, paramVarArgs);
    return paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
  }
  
  public static hf a(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt, int... paramVarArgs)
  {
    a(paramContext, paramAttributeSet, paramInt, 2132018433);
    b(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt, 2132018433, paramVarArgs);
    return hf.a(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt, 2132018433);
  }
  
  public static void a(Context paramContext)
  {
    a(paramContext, a, "Theme.AppCompat");
  }
  
  private static void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, j.e, paramInt1, paramInt2);
    boolean bool = paramAttributeSet.getBoolean(1, false);
    paramAttributeSet.recycle();
    if (bool)
    {
      paramAttributeSet = new TypedValue();
      if ((!paramContext.getTheme().resolveAttribute(2130969195, paramAttributeSet, true)) || ((paramAttributeSet.type == 18) && (paramAttributeSet.data == 0))) {
        a(paramContext, b, "Theme.MaterialComponents");
      }
    }
    a(paramContext);
  }
  
  private static void a(Context paramContext, int[] paramArrayOfInt, String paramString)
  {
    if (!a(paramContext, paramArrayOfInt))
    {
      paramContext = new StringBuilder(String.valueOf(paramString).length() + 77);
      paramContext.append("The style on this component requires your app theme to be ");
      paramContext.append(paramString);
      paramContext.append(" (or a descendant).");
      throw new IllegalArgumentException(paramContext.toString());
    }
  }
  
  private static boolean a(Context paramContext, int[] paramArrayOfInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramArrayOfInt);
    int i = 0;
    while (i < paramArrayOfInt.length) {
      if (paramContext.hasValue(i))
      {
        i += 1;
      }
      else
      {
        paramContext.recycle();
        return false;
      }
    }
    paramContext.recycle();
    return true;
  }
  
  private static void b(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int... paramVarArgs)
  {
    int i = 1;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, j.e, paramInt1, paramInt2);
    if (localTypedArray.getBoolean(j.g, false))
    {
      if (paramVarArgs == null) {
        if (localTypedArray.getResourceId(j.f, -1) != -1) {
          paramInt1 = i;
        }
      }
      for (;;)
      {
        localTypedArray.recycle();
        if (paramInt1 != 0) {
          return;
        }
        throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        paramInt1 = 0;
        continue;
        int j = paramVarArgs.length;
        if (j == 0) {
          break;
        }
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
        paramInt1 = 0;
        for (;;)
        {
          if (paramInt1 < j) {
            if (paramContext.getResourceId(paramVarArgs[paramInt1], -1) != -1)
            {
              paramInt1 += 1;
            }
            else
            {
              paramContext.recycle();
              paramInt1 = 0;
              break;
            }
          }
        }
        paramContext.recycle();
        paramInt1 = i;
      }
    }
    localTypedArray.recycle();
  }
  
  public static boolean b(Context paramContext)
  {
    return a(paramContext, b);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/internal/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */