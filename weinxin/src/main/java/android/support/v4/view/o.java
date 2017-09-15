package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.MotionEvent;

public final class o
{
  static final e xi = new a();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 12)
    {
      xi = new d();
      return;
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      xi = new c();
      return;
    }
    if (Build.VERSION.SDK_INT >= 5)
    {
      xi = new b();
      return;
    }
  }
  
  public static int b(MotionEvent paramMotionEvent, int paramInt)
  {
    return xi.b(paramMotionEvent, paramInt);
  }
  
  public static int c(MotionEvent paramMotionEvent, int paramInt)
  {
    return xi.c(paramMotionEvent, paramInt);
  }
  
  public static float d(MotionEvent paramMotionEvent, int paramInt)
  {
    return xi.d(paramMotionEvent, paramInt);
  }
  
  public static int d(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getAction() & 0xFF;
  }
  
  public static float e(MotionEvent paramMotionEvent, int paramInt)
  {
    return xi.e(paramMotionEvent, paramInt);
  }
  
  public static int e(MotionEvent paramMotionEvent)
  {
    return (paramMotionEvent.getAction() & 0xFF00) >> 8;
  }
  
  public static float f(MotionEvent paramMotionEvent, int paramInt)
  {
    return xi.f(paramMotionEvent, paramInt);
  }
  
  public static int f(MotionEvent paramMotionEvent)
  {
    return xi.f(paramMotionEvent);
  }
  
  public static int g(MotionEvent paramMotionEvent)
  {
    return xi.g(paramMotionEvent);
  }
  
  static class a
    implements o.e
  {
    public int b(MotionEvent paramMotionEvent, int paramInt)
    {
      if (paramInt == 0) {
        return 0;
      }
      return -1;
    }
    
    public int c(MotionEvent paramMotionEvent, int paramInt)
    {
      if (paramInt == 0) {
        return 0;
      }
      throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }
    
    public float d(MotionEvent paramMotionEvent, int paramInt)
    {
      if (paramInt == 0) {
        return paramMotionEvent.getX();
      }
      throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }
    
    public float e(MotionEvent paramMotionEvent, int paramInt)
    {
      if (paramInt == 0) {
        return paramMotionEvent.getY();
      }
      throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }
    
    public float f(MotionEvent paramMotionEvent, int paramInt)
    {
      return 0.0F;
    }
    
    public int f(MotionEvent paramMotionEvent)
    {
      return 1;
    }
    
    public int g(MotionEvent paramMotionEvent)
    {
      return 0;
    }
  }
  
  static class b
    extends o.a
  {
    public final int b(MotionEvent paramMotionEvent, int paramInt)
    {
      return paramMotionEvent.findPointerIndex(paramInt);
    }
    
    public final int c(MotionEvent paramMotionEvent, int paramInt)
    {
      return paramMotionEvent.getPointerId(paramInt);
    }
    
    public final float d(MotionEvent paramMotionEvent, int paramInt)
    {
      return paramMotionEvent.getX(paramInt);
    }
    
    public final float e(MotionEvent paramMotionEvent, int paramInt)
    {
      return paramMotionEvent.getY(paramInt);
    }
    
    public final int f(MotionEvent paramMotionEvent)
    {
      return paramMotionEvent.getPointerCount();
    }
  }
  
  static class c
    extends o.b
  {
    public final int g(MotionEvent paramMotionEvent)
    {
      return paramMotionEvent.getSource();
    }
  }
  
  static final class d
    extends o.c
  {
    public final float f(MotionEvent paramMotionEvent, int paramInt)
    {
      return paramMotionEvent.getAxisValue(paramInt);
    }
  }
  
  static abstract interface e
  {
    public abstract int b(MotionEvent paramMotionEvent, int paramInt);
    
    public abstract int c(MotionEvent paramMotionEvent, int paramInt);
    
    public abstract float d(MotionEvent paramMotionEvent, int paramInt);
    
    public abstract float e(MotionEvent paramMotionEvent, int paramInt);
    
    public abstract float f(MotionEvent paramMotionEvent, int paramInt);
    
    public abstract int f(MotionEvent paramMotionEvent);
    
    public abstract int g(MotionEvent paramMotionEvent);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/view/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */