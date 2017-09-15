package com.tencent.mm.kiss.widget.textview.b;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class a
{
  private static boolean haW;
  private static boolean haX;
  private static Constructor<StaticLayout> haY;
  private static Object haZ;
  
  public a()
  {
    GMTrace.i(431778430976L, 3217);
    GMTrace.o(431778430976L, 3217);
  }
  
  public static StaticLayout a(CharSequence paramCharSequence, int paramInt1, int paramInt2, TextPaint paramTextPaint, int paramInt3, Layout.Alignment paramAlignment, float paramFloat1, float paramFloat2, boolean paramBoolean, TextUtils.TruncateAt paramTruncateAt, int paramInt4, int paramInt5)
  {
    try
    {
      GMTrace.i(432046866432L, 3219);
      wf();
      if (haX) {
        throw new IllegalStateException("initialize error, cannot create StaticLayout");
      }
    }
    finally {}
    try
    {
      Object localObject = haZ;
      paramCharSequence = (StaticLayout)haY.newInstance(new Object[] { paramCharSequence, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramTextPaint, Integer.valueOf(paramInt3), paramAlignment, localObject, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Boolean.valueOf(paramBoolean), paramTruncateAt, Integer.valueOf(paramInt4), Integer.valueOf(paramInt5) });
      GMTrace.o(432046866432L, 3219);
      return paramCharSequence;
    }
    catch (Exception paramCharSequence)
    {
      throw new IllegalStateException("Error creating StaticLayout with max lines: " + paramCharSequence.getCause());
    }
  }
  
  public static StaticLayout a(CharSequence paramCharSequence, int paramInt1, int paramInt2, TextPaint paramTextPaint, int paramInt3, Layout.Alignment paramAlignment, TextDirectionHeuristic paramTextDirectionHeuristic, float paramFloat1, float paramFloat2, boolean paramBoolean, TextUtils.TruncateAt paramTruncateAt, int paramInt4, int paramInt5)
  {
    try
    {
      GMTrace.i(432181084160L, 3220);
      wf();
      if (haX) {
        throw new IllegalStateException("initialize error, cannot create StaticLayout");
      }
    }
    finally {}
    try
    {
      paramCharSequence = (StaticLayout)haY.newInstance(new Object[] { paramCharSequence, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramTextPaint, Integer.valueOf(paramInt3), paramAlignment, paramTextDirectionHeuristic, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Boolean.valueOf(paramBoolean), paramTruncateAt, Integer.valueOf(paramInt4), Integer.valueOf(paramInt5) });
      GMTrace.o(432181084160L, 3220);
      return paramCharSequence;
    }
    catch (Exception paramCharSequence)
    {
      throw new IllegalStateException("Error creating StaticLayout with max lines: " + paramCharSequence.getCause());
    }
  }
  
  @TargetApi(18)
  private static void wf()
  {
    for (;;)
    {
      Object localObject1;
      try
      {
        GMTrace.i(431912648704L, 3218);
        if (haW)
        {
          GMTrace.o(431912648704L, 3218);
          return;
        }
      }
      finally {}
      try
      {
        if (Build.VERSION.SDK_INT < 18) {
          break label192;
        }
        localObject1 = TextDirectionHeuristic.class;
        haZ = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        localObject1 = StaticLayout.class.getDeclaredConstructor(new Class[] { CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, localObject1, Float.TYPE, Float.TYPE, Boolean.TYPE, TextUtils.TruncateAt.class, Integer.TYPE, Integer.TYPE });
        haY = (Constructor)localObject1;
        ((Constructor)localObject1).setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Object localObject4;
        Class localClass;
        v.e("StaticTextView.StaticLayoutWithMaxLines", "StaticLayout constructor with max lines not found.", new Object[] { localNoSuchMethodException });
        haX = true;
        haW = true;
        continue;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        v.e("StaticTextView.StaticLayoutWithMaxLines", "TextDirectionHeuristic class not found.", new Object[] { localClassNotFoundException });
        haX = true;
        haW = true;
        continue;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        v.e("StaticTextView.StaticLayoutWithMaxLines", "TextDirectionHeuristics.FIRSTSTRONG_LTR not found.", new Object[] { localNoSuchFieldException });
        haX = true;
        haW = true;
        continue;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        v.e("StaticTextView.StaticLayoutWithMaxLines", "TextDirectionHeuristics.FIRSTSTRONG_LTR not accessible.", new Object[] { localIllegalAccessException });
        haX = true;
        haW = true;
        continue;
      }
      catch (Exception localException)
      {
        v.e("StaticTextView.StaticLayoutWithMaxLines", "Other error.", new Object[] { localException });
        haX = true;
        haW = true;
        continue;
      }
      finally
      {
        haW = true;
      }
      v.i("StaticTextView.StaticLayoutWithMaxLines", "ensureInitialized finish, sInitialError: " + haX);
      GMTrace.o(431912648704L, 3218);
      continue;
      label192:
      localObject4 = a.class.getClassLoader();
      localClass = ((ClassLoader)localObject4).loadClass("android.text.TextDirectionHeuristic");
      localObject4 = ((ClassLoader)localObject4).loadClass("android.text.TextDirectionHeuristics");
      haZ = ((Class)localObject4).getField("FIRSTSTRONG_LTR").get(localObject4);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/kiss/widget/textview/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */