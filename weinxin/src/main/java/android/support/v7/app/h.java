package android.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Window;
import android.view.Window.Callback;

final class h
  extends g
{
  private final UiModeManager GK;
  
  h(Context paramContext, Window paramWindow, c paramc)
  {
    super(paramContext, paramWindow, paramc);
    this.GK = ((UiModeManager)paramContext.getSystemService("uimode"));
  }
  
  final Window.Callback a(Window.Callback paramCallback)
  {
    return new a(paramCallback);
  }
  
  final int at(int paramInt)
  {
    if ((paramInt == 0) && (this.GK.getNightMode() == 0)) {
      return -1;
    }
    return super.at(paramInt);
  }
  
  final class a
    extends g.a
  {
    a(Window.Callback paramCallback)
    {
      super(paramCallback);
    }
    
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
    {
      return null;
    }
    
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
    {
      if (h.this.GI) {}
      switch (paramInt)
      {
      default: 
        return super.onWindowStartingActionMode(paramCallback, paramInt);
      }
      return a(paramCallback);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/app/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */