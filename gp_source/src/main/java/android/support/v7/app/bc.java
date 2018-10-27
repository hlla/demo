package android.support.v7.app;

import android.support.v7.view.n;
import android.support.v7.widget.bj;
import android.view.Menu;
import android.view.View;
import android.view.Window.Callback;

final class bc
  extends n
{
  public bc(ax paramax, Window.Callback paramCallback)
  {
    super(paramCallback);
  }
  
  public final View onCreatePanelView(int paramInt)
  {
    if (paramInt == 0) {
      return new View(this.a.a.b());
    }
    return super.onCreatePanelView(paramInt);
  }
  
  public final boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    boolean bool = super.onPreparePanel(paramInt, paramView, paramMenu);
    if (bool)
    {
      paramView = this.a;
      if (!paramView.b)
      {
        paramView.a.m();
        this.a.b = true;
      }
    }
    return bool;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */