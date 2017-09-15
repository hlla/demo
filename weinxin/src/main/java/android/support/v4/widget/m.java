package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

public final class m
{
  static final f Do = new c();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23)
    {
      Do = new b();
      return;
    }
    if (i >= 21)
    {
      Do = new a();
      return;
    }
    if (i >= 19)
    {
      Do = new e();
      return;
    }
    if (i >= 9)
    {
      Do = new d();
      return;
    }
  }
  
  public static void a(PopupWindow paramPopupWindow, int paramInt)
  {
    Do.a(paramPopupWindow, paramInt);
  }
  
  public static void a(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    Do.a(paramPopupWindow, paramView, paramInt1, paramInt2, paramInt3);
  }
  
  public static void a(PopupWindow paramPopupWindow, boolean paramBoolean)
  {
    Do.a(paramPopupWindow, paramBoolean);
  }
  
  static class a
    extends m.e
  {
    public void a(PopupWindow paramPopupWindow, boolean paramBoolean)
    {
      n.a(paramPopupWindow, paramBoolean);
    }
  }
  
  static final class b
    extends m.a
  {
    public final void a(PopupWindow paramPopupWindow, int paramInt)
    {
      paramPopupWindow.setWindowLayoutType(paramInt);
    }
    
    public final void a(PopupWindow paramPopupWindow, boolean paramBoolean)
    {
      paramPopupWindow.setOverlapAnchor(paramBoolean);
    }
  }
  
  static class c
    implements m.f
  {
    public void a(PopupWindow paramPopupWindow, int paramInt) {}
    
    public void a(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3)
    {
      paramPopupWindow.showAsDropDown(paramView, paramInt1, paramInt2);
    }
    
    public void a(PopupWindow paramPopupWindow, boolean paramBoolean) {}
  }
  
  static class d
    extends m.c
  {
    public void a(PopupWindow paramPopupWindow, int paramInt)
    {
      if (!o.Dr) {}
      try
      {
        Method localMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[] { Integer.TYPE });
        o.Dq = localMethod;
        localMethod.setAccessible(true);
        o.Dr = true;
        if (o.Dq != null) {}
        try
        {
          o.Dq.invoke(paramPopupWindow, new Object[] { Integer.valueOf(paramInt) });
          return;
        }
        catch (Exception paramPopupWindow) {}
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  static class e
    extends m.d
  {
    public final void a(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3)
    {
      paramPopupWindow.showAsDropDown(paramView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  static abstract interface f
  {
    public abstract void a(PopupWindow paramPopupWindow, int paramInt);
    
    public abstract void a(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void a(PopupWindow paramPopupWindow, boolean paramBoolean);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/widget/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */