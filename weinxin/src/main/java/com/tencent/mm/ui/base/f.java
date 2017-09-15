package com.tencent.mm.ui.base;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import com.tencent.gmtrace.GMTrace;

public final class f
{
  private static boolean C(MotionEvent paramMotionEvent)
  {
    GMTrace.i(3285918416896L, 24482);
    if (bmU())
    {
      if (paramMotionEvent.getPointerCount() >= 2)
      {
        GMTrace.o(3285918416896L, 24482);
        return true;
      }
      GMTrace.o(3285918416896L, 24482);
      return false;
    }
    GMTrace.o(3285918416896L, 24482);
    return false;
  }
  
  public static float D(MotionEvent paramMotionEvent)
  {
    GMTrace.i(3286052634624L, 24483);
    float f1 = i(paramMotionEvent, 0) - i(paramMotionEvent, 1);
    float f2 = j(paramMotionEvent, 0) - j(paramMotionEvent, 1);
    f1 = (float)Math.sqrt(f1 * f1 + f2 * f2);
    GMTrace.o(3286052634624L, 24483);
    return f1;
  }
  
  public static int G(MotionEvent paramMotionEvent)
  {
    GMTrace.i(3286723723264L, 24488);
    if (bmU())
    {
      new e();
      int i = paramMotionEvent.getPointerCount();
      GMTrace.o(3286723723264L, 24488);
      return i;
    }
    GMTrace.o(3286723723264L, 24488);
    return 1;
  }
  
  public static void a(PointF paramPointF, Bitmap paramBitmap)
  {
    GMTrace.i(3286321070080L, 24485);
    if ((paramPointF == null) || (paramBitmap == null))
    {
      GMTrace.o(3286321070080L, 24485);
      return;
    }
    paramPointF.set(paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
    GMTrace.o(3286321070080L, 24485);
  }
  
  public static void a(PointF paramPointF, MotionEvent paramMotionEvent)
  {
    GMTrace.i(3286186852352L, 24484);
    if ((paramPointF == null) || (paramMotionEvent == null))
    {
      GMTrace.o(3286186852352L, 24484);
      return;
    }
    float f1 = i(paramMotionEvent, 0);
    float f2 = i(paramMotionEvent, 1);
    float f3 = j(paramMotionEvent, 0);
    float f4 = j(paramMotionEvent, 1);
    paramPointF.set((f1 + f2) / 2.0F, (f3 + f4) / 2.0F);
    GMTrace.o(3286186852352L, 24484);
  }
  
  public static boolean bmU()
  {
    GMTrace.i(3285784199168L, 24481);
    if (Build.VERSION.SDK_INT >= 5)
    {
      GMTrace.o(3285784199168L, 24481);
      return true;
    }
    GMTrace.o(3285784199168L, 24481);
    return false;
  }
  
  public static float i(MotionEvent paramMotionEvent, int paramInt)
  {
    GMTrace.i(3286455287808L, 24486);
    if (C(paramMotionEvent))
    {
      new e();
      f = paramMotionEvent.getX(paramInt);
      GMTrace.o(3286455287808L, 24486);
      return f;
    }
    float f = paramMotionEvent.getX();
    GMTrace.o(3286455287808L, 24486);
    return f;
  }
  
  public static float j(MotionEvent paramMotionEvent, int paramInt)
  {
    GMTrace.i(3286589505536L, 24487);
    if (C(paramMotionEvent))
    {
      new e();
      f = paramMotionEvent.getY(paramInt);
      GMTrace.o(3286589505536L, 24487);
      return f;
    }
    float f = paramMotionEvent.getY();
    GMTrace.o(3286589505536L, 24487);
    return f;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */