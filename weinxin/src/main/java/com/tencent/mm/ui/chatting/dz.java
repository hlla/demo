package com.tencent.mm.ui.chatting;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnHoverListener;
import com.tencent.gmtrace.GMTrace;

public final class dz
{
  private static dz vMa;
  Object vLZ;
  
  public dz()
  {
    GMTrace.i(2310423969792L, 17214);
    GMTrace.o(2310423969792L, 17214);
  }
  
  public static dz bWe()
  {
    try
    {
      GMTrace.i(2310558187520L, 17215);
      if (vMa == null) {
        vMa = new dz();
      }
      dz localdz = vMa;
      GMTrace.o(2310558187520L, 17215);
      return localdz;
    }
    finally {}
  }
  
  @TargetApi(14)
  public static final class a
    implements View.OnHoverListener
  {
    private dz.b vMb;
    
    public a(dz.b paramb)
    {
      GMTrace.i(2526246076416L, 18822);
      this.vMb = paramb;
      GMTrace.o(2526246076416L, 18822);
    }
    
    public final boolean onHover(View paramView, MotionEvent paramMotionEvent)
    {
      GMTrace.i(2526380294144L, 18823);
      if (this.vMb != null)
      {
        boolean bool = this.vMb.e(paramView, paramMotionEvent);
        GMTrace.o(2526380294144L, 18823);
        return bool;
      }
      GMTrace.o(2526380294144L, 18823);
      return false;
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean e(View paramView, MotionEvent paramMotionEvent);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/dz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */