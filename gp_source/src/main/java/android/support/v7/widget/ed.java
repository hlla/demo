package android.support.v7.widget;

import android.content.Context;
import android.support.v7.view.menu.p;
import android.util.Log;
import android.view.MenuItem;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

public final class ed
  extends du
  implements ec
{
  public static Method b;
  public ec a;
  
  static
  {
    try
    {
      b = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[] { Boolean.TYPE });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
    }
  }
  
  public ed(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext, null, paramInt1, paramInt2);
  }
  
  final bx a(Context paramContext, boolean paramBoolean)
  {
    paramContext = new ee(paramContext, paramBoolean);
    paramContext.setHoverListener(this);
    return paramContext;
  }
  
  public final void a(p paramp, MenuItem paramMenuItem)
  {
    ec localec = this.a;
    if (localec != null) {
      localec.a(paramp, paramMenuItem);
    }
  }
  
  public final void b(p paramp, MenuItem paramMenuItem)
  {
    ec localec = this.a;
    if (localec != null) {
      localec.b(paramp, paramMenuItem);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */