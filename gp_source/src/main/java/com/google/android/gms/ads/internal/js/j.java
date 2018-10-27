package com.google.android.gms.ads.internal.js;

import android.content.Context;
import com.google.android.gms.ads.internal.q.a.a;

@a
public final class j
{
  private Context a;
  
  public final void a(Context paramContext)
  {
    if (this.a == null)
    {
      Context localContext = paramContext;
      if (paramContext.getApplicationContext() != null) {
        localContext = paramContext.getApplicationContext();
      }
      this.a = localContext;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/js/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */