package com.google.android.finsky.ct;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.google.android.finsky.bo.c;
import com.google.android.finsky.bo.f;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.play.image.x;

public final class a
  implements ComponentCallbacks2
{
  private final b.a a;
  private final b.a b;
  
  public a(b.a parama1, b.a parama2)
  {
    this.a = parama1;
    this.b = parama2;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onLowMemory() {}
  
  public final void onTrimMemory(int paramInt)
  {
    FinskyLog.a("Memory trim requested to level %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 20) && (((c)this.b.a()).cY().a(12606496L)))
    {
      FinskyLog.a("Flushing in-memory image cache", new Object[0]);
      ((x)this.a.a()).b();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ct/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */