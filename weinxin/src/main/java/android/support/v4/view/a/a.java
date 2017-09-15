package android.support.v4.view.a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

public final class a
{
  private static final d zJ = new c();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      zJ = new b();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      zJ = new a();
      return;
    }
  }
  
  public static f a(AccessibilityEvent paramAccessibilityEvent)
  {
    return new f(paramAccessibilityEvent);
  }
  
  public static void a(AccessibilityEvent paramAccessibilityEvent, int paramInt)
  {
    zJ.a(paramAccessibilityEvent, paramInt);
  }
  
  public static int b(AccessibilityEvent paramAccessibilityEvent)
  {
    return zJ.b(paramAccessibilityEvent);
  }
  
  static class a
    extends a.c
  {}
  
  static final class b
    extends a.a
  {
    public final void a(AccessibilityEvent paramAccessibilityEvent, int paramInt)
    {
      paramAccessibilityEvent.setContentChangeTypes(paramInt);
    }
    
    public final int b(AccessibilityEvent paramAccessibilityEvent)
    {
      return paramAccessibilityEvent.getContentChangeTypes();
    }
  }
  
  static class c
    implements a.d
  {
    public void a(AccessibilityEvent paramAccessibilityEvent, int paramInt) {}
    
    public int b(AccessibilityEvent paramAccessibilityEvent)
    {
      return 0;
    }
  }
  
  static abstract interface d
  {
    public abstract void a(AccessibilityEvent paramAccessibilityEvent, int paramInt);
    
    public abstract int b(AccessibilityEvent paramAccessibilityEvent);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/view/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */