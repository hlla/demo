package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.b.a.a;
import android.util.AttributeSet;
import android.util.TypedValue;

public final class hf
{
  public final Context a;
  public TypedValue b;
  public final TypedArray c;
  
  private hf(Context paramContext, TypedArray paramTypedArray)
  {
    this.a = paramContext;
    this.c = paramTypedArray;
  }
  
  public static hf a(Context paramContext, int paramInt, int[] paramArrayOfInt)
  {
    return new hf(paramContext, paramContext.obtainStyledAttributes(paramInt, paramArrayOfInt));
  }
  
  public static hf a(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    return new hf(paramContext, paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt));
  }
  
  public static hf a(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    return new hf(paramContext, paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, paramInt1, paramInt2));
  }
  
  public final float a(int paramInt, float paramFloat)
  {
    return this.c.getFloat(paramInt, paramFloat);
  }
  
  public final int a(int paramInt1, int paramInt2)
  {
    return this.c.getInt(paramInt1, paramInt2);
  }
  
  public final Drawable a(int paramInt)
  {
    if (this.c.hasValue(paramInt))
    {
      int i = this.c.getResourceId(paramInt, 0);
      if (i != 0) {
        return a.b(this.a, i);
      }
    }
    return this.c.getDrawable(paramInt);
  }
  
  public final boolean a(int paramInt, boolean paramBoolean)
  {
    return this.c.getBoolean(paramInt, paramBoolean);
  }
  
  public final int b(int paramInt1, int paramInt2)
  {
    return this.c.getColor(paramInt1, paramInt2);
  }
  
  public final Drawable b(int paramInt)
  {
    if (this.c.hasValue(paramInt))
    {
      paramInt = this.c.getResourceId(paramInt, 0);
      if (paramInt != 0) {
        return ae.a().a(this.a, paramInt, true);
      }
    }
    return null;
  }
  
  public final int c(int paramInt1, int paramInt2)
  {
    return this.c.getInteger(paramInt1, paramInt2);
  }
  
  public final CharSequence c(int paramInt)
  {
    return this.c.getText(paramInt);
  }
  
  public final int d(int paramInt1, int paramInt2)
  {
    return this.c.getDimensionPixelOffset(paramInt1, paramInt2);
  }
  
  public final String d(int paramInt)
  {
    return this.c.getString(paramInt);
  }
  
  public final int e(int paramInt1, int paramInt2)
  {
    return this.c.getDimensionPixelSize(paramInt1, paramInt2);
  }
  
  public final ColorStateList e(int paramInt)
  {
    if (this.c.hasValue(paramInt))
    {
      int i = this.c.getResourceId(paramInt, 0);
      if (i != 0)
      {
        ColorStateList localColorStateList2 = a.a(this.a, i);
        localColorStateList1 = localColorStateList2;
        if (localColorStateList2 != null) {
          return localColorStateList1;
        }
      }
    }
    ColorStateList localColorStateList1 = this.c.getColorStateList(paramInt);
    return localColorStateList1;
  }
  
  public final float f(int paramInt)
  {
    return this.c.getDimension(paramInt, 0.0F);
  }
  
  public final int f(int paramInt1, int paramInt2)
  {
    return this.c.getLayoutDimension(paramInt1, paramInt2);
  }
  
  public final int g(int paramInt1, int paramInt2)
  {
    return this.c.getResourceId(paramInt1, paramInt2);
  }
  
  public final boolean g(int paramInt)
  {
    return this.c.hasValue(paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/hf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */