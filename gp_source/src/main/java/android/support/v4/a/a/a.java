package android.support.v4.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

public final class a
{
  private static Method a;
  private static boolean b;
  private static Method c;
  private static boolean d;
  
  public static void a(Drawable paramDrawable, float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.setHotspot(paramFloat1, paramFloat2);
    }
  }
  
  public static void a(Drawable paramDrawable, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.setTint(paramInt);
    }
    while (!(paramDrawable instanceof b)) {
      return;
    }
    ((b)paramDrawable).setTint(paramInt);
  }
  
  public static void a(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public static void a(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.setTintList(paramColorStateList);
    }
    while (!(paramDrawable instanceof b)) {
      return;
    }
    ((b)paramDrawable).setTintList(paramColorStateList);
  }
  
  public static void a(Drawable paramDrawable, Resources.Theme paramTheme)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.applyTheme(paramTheme);
    }
  }
  
  public static void a(Drawable paramDrawable, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    paramDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
  }
  
  public static void a(Drawable paramDrawable, PorterDuff.Mode paramMode)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.setTintMode(paramMode);
    }
    while (!(paramDrawable instanceof b)) {
      return;
    }
    ((b)paramDrawable).setTintMode(paramMode);
  }
  
  public static void a(Drawable paramDrawable, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      paramDrawable.setAutoMirrored(paramBoolean);
    }
  }
  
  public static boolean a(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT < 19) {
      return false;
    }
    return paramDrawable.isAutoMirrored();
  }
  
  public static int b(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT < 19) {
      return 0;
    }
    return paramDrawable.getAlpha();
  }
  
  public static boolean b(Drawable paramDrawable, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramDrawable.setLayoutDirection(paramInt);
    }
    if ((Build.VERSION.SDK_INT < 17) || (!d)) {}
    try
    {
      Method localMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[] { Integer.TYPE });
      c = localMethod;
      localMethod.setAccessible(true);
      d = true;
      if (c != null) {
        try
        {
          c.invoke(paramDrawable, new Object[] { Integer.valueOf(paramInt) });
          return true;
        }
        catch (Exception paramDrawable)
        {
          Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", paramDrawable);
          c = null;
        }
      }
      return false;
      return false;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", localNoSuchMethodException);
      }
    }
  }
  
  public static boolean c(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return false;
    }
    return paramDrawable.canApplyTheme();
  }
  
  public static ColorFilter d(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return null;
    }
    return paramDrawable.getColorFilter();
  }
  
  public static void e(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      paramDrawable.clearColorFilter();
    }
    do
    {
      do
      {
        return;
        if (Build.VERSION.SDK_INT < 21) {
          break label121;
        }
        paramDrawable.clearColorFilter();
        if ((paramDrawable instanceof InsetDrawable))
        {
          paramDrawable = ((InsetDrawable)paramDrawable).getDrawable();
          break;
        }
        if ((paramDrawable instanceof c))
        {
          paramDrawable = ((c)paramDrawable).a();
          break;
        }
      } while (!(paramDrawable instanceof DrawableContainer));
      paramDrawable = (DrawableContainer.DrawableContainerState)((DrawableContainer)paramDrawable).getConstantState();
    } while (paramDrawable == null);
    int j = paramDrawable.getChildCount();
    int i = 0;
    label92:
    Drawable localDrawable;
    if (i < j)
    {
      localDrawable = paramDrawable.getChild(i);
      if (localDrawable != null) {
        break label114;
      }
    }
    for (;;)
    {
      i += 1;
      break label92;
      break;
      label114:
      e(localDrawable);
    }
    label121:
    paramDrawable.clearColorFilter();
  }
  
  public static Drawable f(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if (Build.VERSION.SDK_INT < 23)
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label38;
      }
      localObject = paramDrawable;
      if (!(paramDrawable instanceof b)) {
        localObject = new g(paramDrawable);
      }
    }
    label38:
    do
    {
      return (Drawable)localObject;
      localObject = paramDrawable;
    } while ((paramDrawable instanceof b));
    return new d(paramDrawable);
  }
  
  public static int g(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramDrawable.getLayoutDirection();
    }
    if ((Build.VERSION.SDK_INT < 17) || (!b)) {}
    try
    {
      Method localMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
      a = localMethod;
      localMethod.setAccessible(true);
      b = true;
      if (a != null) {
        try
        {
          int i = ((Integer)a.invoke(paramDrawable, new Object[0])).intValue();
          return i;
        }
        catch (Exception paramDrawable)
        {
          Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", paramDrawable);
          a = null;
        }
      }
      return 0;
      return 0;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", localNoSuchMethodException);
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */