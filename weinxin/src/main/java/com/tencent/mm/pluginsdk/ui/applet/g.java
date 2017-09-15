package com.tencent.mm.pluginsdk.ui.applet;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.gmtrace.GMTrace;

public final class g
{
  private int background;
  int index;
  boolean krC;
  View.OnClickListener oOv;
  int row;
  f sKQ;
  public a sKW;
  private final View.OnTouchListener sLB;
  int sLG;
  public b sLH;
  
  public g()
  {
    GMTrace.i(946100764672L, 7049);
    this.background = -1;
    this.sLB = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(962743762944L, 7173);
        GMTrace.o(962743762944L, 7173);
        return true;
      }
    };
    this.oOv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(949858861056L, 7077);
        GMTrace.o(949858861056L, 7077);
      }
    };
    GMTrace.o(946100764672L, 7049);
  }
  
  public static abstract interface a
  {
    public abstract void xm(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract boolean kF(int paramInt);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/applet/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */