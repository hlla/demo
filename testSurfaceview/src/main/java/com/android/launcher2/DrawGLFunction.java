package com.android.launcher2;

import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.Method;

public class DrawGLFunction
{
  private static Method mCallDrawGLFunction;
  static boolean sICSCompat;
  
  static
  {
    System.loadLibrary("drawglfunction");
    if ((Build.VERSION.SDK_INT < 16) && (!Build.VERSION.RELEASE.startsWith("4.0.9"))) {}
    for (boolean bool = true;; bool = false)
    {
      sICSCompat = bool;
      return;
    }
  }
  
  public static void call(Canvas paramCanvas, Callback paramCallback)
  {
    if (paramCallback.functor == 0L)
    {
      if (!sICSCompat) {
        break label83;
      }
      Callback.access$002(paramCallback, createICS(paramCallback));
    }
    for (;;)
    {
      try
      {
        if (mCallDrawGLFunction == null)
        {
          mCallDrawGLFunction = Class.forName("android.view.HardwareCanvas").getDeclaredMethod("callDrawGLFunction", new Class[] { Long.TYPE });
          mCallDrawGLFunction.setAccessible(true);
        }
        mCallDrawGLFunction.invoke(paramCanvas, new Object[] { Long.valueOf(paramCallback.functor) });
        return;
      }
      catch (Throwable paramCanvas)
      {
        label83:
        Log.e("DrawGLFunction", "" + paramCanvas);
      }
      Callback.access$002(paramCallback, createJB(paramCallback));
    }
  }
  
  private static native long createICS(Callback paramCallback);
  
  private static native long createJB(Callback paramCallback);
  
  public static void destroy(Callback paramCallback)
  {
    if (paramCallback.functor != 0L)
    {
      if (!sICSCompat) {
        break label29;
      }
      destroyICS(paramCallback.functor);
    }
    for (;;)
    {
      Callback.access$002(paramCallback, 0L);
      return;
      label29:
      destroyJB(paramCallback.functor);
    }
  }
  
  private static native void destroyICS(long paramLong);
  
  private static native void destroyJB(long paramLong);
  
  public static abstract class Callback
  {
    private long functor = 0L;
    
    public abstract void drawGL(float[] paramArrayOfFloat);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/DrawGLFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */