package android.support.v7.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build.VERSION;
import android.support.v4.a.a.c;
import android.support.v7.c.a.l;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class bw
{
  public static final Rect a = new Rect();
  private static Class b;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 18) {}
    try
    {
      b = Class.forName("android.graphics.Insets");
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
  }
  
  public static PorterDuff.Mode a(int paramInt, PorterDuff.Mode paramMode)
  {
    switch (paramInt)
    {
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    default: 
      return paramMode;
    case 16: 
      return PorterDuff.Mode.ADD;
    case 15: 
      return PorterDuff.Mode.SCREEN;
    case 14: 
      return PorterDuff.Mode.MULTIPLY;
    case 9: 
      return PorterDuff.Mode.SRC_ATOP;
    case 5: 
      return PorterDuff.Mode.SRC_IN;
    }
    return PorterDuff.Mode.SRC_OVER;
  }
  
  public static Rect a(Drawable paramDrawable)
  {
    Object localObject1;
    Object localObject2;
    int j;
    String str;
    if (b != null)
    {
      localObject1 = paramDrawable;
      if ((paramDrawable instanceof c)) {}
      try
      {
        localObject1 = ((c)paramDrawable).a();
        localObject2 = localObject1.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(localObject1, new Object[0]);
        if (localObject2 != null)
        {
          localObject1 = new Rect();
          Field[] arrayOfField = b.getFields();
          int k = arrayOfField.length;
          j = 0;
          paramDrawable = (Drawable)localObject1;
          if (j >= k) {
            break label175;
          }
          paramDrawable = arrayOfField[j];
          str = paramDrawable.getName();
          switch (str.hashCode())
          {
          case -1383228885: 
            ((Rect)localObject1).bottom = paramDrawable.getInt(localObject2);
          }
        }
      }
      catch (Exception paramDrawable)
      {
        Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
      }
    }
    paramDrawable = a;
    label175:
    return paramDrawable;
    ((Rect)localObject1).right = paramDrawable.getInt(localObject2);
    break label320;
    ((Rect)localObject1).top = paramDrawable.getInt(localObject2);
    break label320;
    ((Rect)localObject1).left = paramDrawable.getInt(localObject2);
    break label320;
    int i;
    if (str.equals("bottom"))
    {
      i = 3;
      break label290;
      if (!str.equals("right")) {
        break label332;
      }
      i = 2;
      break label290;
      if (!str.equals("left")) {
        break label337;
      }
      i = 0;
      break label290;
      boolean bool = str.equals("top");
      if (bool)
      {
        i = 1;
      }
      else
      {
        i = -1;
        break label290;
        i = -1;
      }
    }
    for (;;)
    {
      label290:
      switch (i)
      {
      }
      label320:
      j += 1;
      break;
      i = -1;
      continue;
      label332:
      i = -1;
      continue;
      label337:
      i = -1;
    }
  }
  
  static void b(Drawable paramDrawable)
  {
    int[] arrayOfInt;
    if ((Build.VERSION.SDK_INT == 21) && ("android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName())))
    {
      arrayOfInt = paramDrawable.getState();
      if ((arrayOfInt != null) && (arrayOfInt.length != 0)) {
        break label52;
      }
      paramDrawable.setState(ha.a);
    }
    for (;;)
    {
      paramDrawable.setState(arrayOfInt);
      return;
      label52:
      paramDrawable.setState(ha.c);
    }
  }
  
  public static boolean c(Drawable paramDrawable)
  {
    while ((Build.VERSION.SDK_INT >= 17) || (!(paramDrawable instanceof LayerDrawable)))
    {
      if ((paramDrawable instanceof DrawableContainer))
      {
        paramDrawable = paramDrawable.getConstantState();
        if ((paramDrawable instanceof DrawableContainer.DrawableContainerState))
        {
          paramDrawable = ((DrawableContainer.DrawableContainerState)paramDrawable).getChildren();
          int j = paramDrawable.length;
          int i = 0;
          while (i < j) {
            if (c(paramDrawable[i])) {
              i += 1;
            } else {
              return false;
            }
          }
        }
      }
      do
      {
        return true;
        if ((paramDrawable instanceof c))
        {
          paramDrawable = ((c)paramDrawable).a();
          break;
        }
        if ((paramDrawable instanceof l))
        {
          paramDrawable = ((l)paramDrawable).d;
          break;
        }
      } while (!(paramDrawable instanceof ScaleDrawable));
      paramDrawable = ((ScaleDrawable)paramDrawable).getDrawable();
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */