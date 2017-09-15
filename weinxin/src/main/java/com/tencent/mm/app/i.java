package com.tencent.mm.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.a.a;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.SplashWelcomeView.a;
import com.tencent.mm.ui.chatting.en;
import java.util.HashSet;
import java.util.Iterator;

public final class i
{
  private static i fvZ;
  public FrameLayout fwa;
  public WindowManager fwb;
  public WindowManager.LayoutParams fwc;
  public ViewGroup.LayoutParams fwd;
  public boolean fwe;
  public boolean fwf;
  public boolean fwg;
  public BitmapDrawable fwh;
  @Deprecated
  public Boolean fwi;
  public HashSet<a> fwj;
  private final int fwk;
  protected Object mLock;
  public View mView;
  
  public i()
  {
    GMTrace.i(12997107908608L, 96836);
    this.mLock = new Object();
    this.fwh = null;
    this.fwi = Boolean.valueOf(false);
    this.fwj = new HashSet();
    this.fwk = 5;
    GMTrace.o(12997107908608L, 96836);
  }
  
  public static i oj()
  {
    GMTrace.i(12997242126336L, 96837);
    if (fvZ == null) {
      fvZ = new i();
    }
    i locali = fvZ;
    GMTrace.o(12997242126336L, 96837);
    return locali;
  }
  
  public final void ok()
  {
    try
    {
      GMTrace.i(17857802928128L, 133051);
      Iterator localIterator = this.fwj.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.oo();
        }
      }
      this.fwj.clear();
    }
    finally {}
    v.i("MicroMsg.INIT", "start time check notifyALLinit  hascreate: " + (System.currentTimeMillis() - LauncherUI.uPW));
    try
    {
      aa.getContext().getSharedPreferences("system_config_prefs", 0).edit().putInt("launch_last_status", 2).commit();
      GMTrace.o(17857802928128L, 133051);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.INIT", localException, "%s", new Object[] { localException.getMessage() });
        GMTrace.o(17857802928128L, 133051);
      }
    }
  }
  
  /* Error */
  public final void ol()
  {
    // Byte code:
    //   0: ldc2_w 189
    //   3: ldc -65
    //   5: invokestatic 56	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   8: aload_0
    //   9: getfield 58	com/tencent/mm/app/i:mLock	Ljava/lang/Object;
    //   12: astore_1
    //   13: aload_1
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 193	com/tencent/mm/app/i:fwb	Landroid/view/WindowManager;
    //   19: ifnull +28 -> 47
    //   22: aload_0
    //   23: getfield 195	com/tencent/mm/app/i:fwa	Landroid/widget/FrameLayout;
    //   26: ifnull +16 -> 42
    //   29: aload_0
    //   30: getfield 193	com/tencent/mm/app/i:fwb	Landroid/view/WindowManager;
    //   33: aload_0
    //   34: getfield 195	com/tencent/mm/app/i:fwa	Landroid/widget/FrameLayout;
    //   37: invokeinterface 201 2 0
    //   42: aload_0
    //   43: aconst_null
    //   44: putfield 193	com/tencent/mm/app/i:fwb	Landroid/view/WindowManager;
    //   47: aload_0
    //   48: getfield 195	com/tencent/mm/app/i:fwa	Landroid/widget/FrameLayout;
    //   51: ifnull +15 -> 66
    //   54: aload_0
    //   55: getfield 195	com/tencent/mm/app/i:fwa	Landroid/widget/FrameLayout;
    //   58: invokevirtual 206	android/widget/FrameLayout:removeAllViews	()V
    //   61: aload_0
    //   62: aconst_null
    //   63: putfield 195	com/tencent/mm/app/i:fwa	Landroid/widget/FrameLayout;
    //   66: aload_0
    //   67: aconst_null
    //   68: putfield 208	com/tencent/mm/app/i:mView	Landroid/view/View;
    //   71: aload_0
    //   72: iconst_0
    //   73: putfield 210	com/tencent/mm/app/i:fwe	Z
    //   76: aload_1
    //   77: monitorexit
    //   78: aload_0
    //   79: iconst_0
    //   80: putfield 210	com/tencent/mm/app/i:fwe	Z
    //   83: ldc2_w 189
    //   86: ldc -65
    //   88: invokestatic 78	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   91: return
    //   92: astore_2
    //   93: aload_1
    //   94: monitorexit
    //   95: aload_2
    //   96: athrow
    //   97: astore_1
    //   98: goto -20 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	i
    //   97	1	1	localException	Exception
    //   92	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   15	42	92	finally
    //   42	47	92	finally
    //   47	66	92	finally
    //   66	78	92	finally
    //   93	95	92	finally
    //   8	15	97	java/lang/Exception
    //   95	97	97	java/lang/Exception
  }
  
  public static abstract interface a
  {
    public abstract void oo();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/app/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */