package com.google.android.finsky.d;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.finsky.e.af;
import com.google.android.finsky.utils.FinskyLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private final Handler a;
  private final h b;
  private final Map c = new ConcurrentHashMap();
  
  public a(h paramh)
  {
    this.b = paramh;
    this.a = new Handler(Looper.getMainLooper());
  }
  
  public final void a(View paramView)
  {
    if ((paramView != null) && (this.c.containsKey(paramView)))
    {
      e locale = (e)this.c.get(paramView);
      locale.a(locale.c);
      locale.b = null;
      locale.c = null;
      this.c.remove(paramView);
    }
  }
  
  public final void a(af paramaf, View paramView, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    a(paramView);
    h localh = this.b;
    paramaf = new c(this, paramaf, paramArrayOfByte, this.a);
    paramaf = new e(paramView.getContext(), paramaf, localh.a, new l(), paramBoolean);
    if (paramaf.c != null)
    {
      FinskyLog.e("PositionWatcher shouldn't be already tracking", new Object[0]);
      paramaf.a(paramaf.c);
    }
    paramaf.c = paramView;
    if (paramView != null)
    {
      paramaf.d = paramView.getViewTreeObserver();
      paramArrayOfByte = paramaf.d;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.isAlive()))
      {
        paramaf.d.addOnScrollChangedListener(paramaf);
        paramaf.d.addOnGlobalLayoutListener(paramaf);
      }
      paramArrayOfByte = paramaf.a;
      if (paramArrayOfByte == null) {}
    }
    try
    {
      paramArrayOfByte.registerActivityLifecycleCallbacks(paramaf);
      this.c.put(paramView, paramaf);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        FinskyLog.a(paramArrayOfByte, "Error registering activity lifecycle callbacks.", new Object[0]);
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */