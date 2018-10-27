package com.google.android.finsky.d;

import android.os.Handler;
import android.view.View;
import com.google.android.finsky.e.af;
import java.util.TimerTask;

final class c
  implements g
{
  private static final long d = ((Long)com.google.android.finsky.ag.d.e.b()).longValue();
  private static final float e = ((Float)com.google.android.finsky.ag.d.f.b()).floatValue();
  public final a a;
  public final af b;
  public final byte[] c;
  private final Handler f;
  private TimerTask g;
  
  public c(a parama, af paramaf, byte[] paramArrayOfByte, Handler paramHandler)
  {
    this.a = parama;
    this.b = paramaf;
    this.c = paramArrayOfByte;
    this.f = paramHandler;
  }
  
  public final void a(double paramDouble, View paramView)
  {
    if (paramDouble >= e) {
      if (this.g == null)
      {
        this.g = new d(this, paramView);
        this.f.postDelayed(this.g, d);
      }
    }
    do
    {
      return;
      paramView = this.g;
    } while (paramView == null);
    this.f.removeCallbacks(paramView);
    this.g = null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */