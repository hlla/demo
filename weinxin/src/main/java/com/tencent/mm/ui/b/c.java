package com.tencent.mm.ui.b;

import android.app.Activity;
import android.support.v7.view.i;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Window.Callback;
import com.tencent.gmtrace.GMTrace;

public final class c
  extends i
{
  private Activity qb;
  
  public c(Window.Callback paramCallback, Activity paramActivity)
  {
    super(paramCallback);
    GMTrace.i(3066472431616L, 22847);
    this.qb = paramActivity;
    GMTrace.o(3066472431616L, 22847);
  }
  
  public final ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
  {
    GMTrace.i(3066606649344L, 22848);
    paramCallback = this.qb.onWindowStartingActionMode(paramCallback);
    GMTrace.o(3066606649344L, 22848);
    return paramCallback;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */