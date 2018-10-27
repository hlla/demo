package com.google.android.finsky.i.a;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import com.google.android.finsky.ag.d;
import com.google.android.finsky.e.i;
import com.google.android.finsky.e.u;

final class c
  implements Application.ActivityLifecycleCallbacks
{
  c(a parama) {}
  
  private final void a()
  {
    a locala = this.a;
    if ((locala.e) && (!locala.a) && (!locala.g))
    {
      locala.c.cV().h();
      this.a.b.b();
      this.a.a = true;
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    int i = paramActivity.getResources().getConfiguration().orientation;
    paramActivity = this.a;
    if (paramActivity.f != 0) {}
    for (;;)
    {
      if (paramActivity.f != i) {}
      for (boolean bool = true;; bool = false)
      {
        paramActivity.g = bool;
        paramActivity.f = i;
        a();
        return;
      }
      paramActivity.f = i;
    }
  }
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity)
  {
    paramActivity = this.a;
    paramActivity.i -= 1;
    paramActivity.d.removeCallbacks(paramActivity.j);
    paramActivity.d.postDelayed(paramActivity.j, ((Long)d.E.b()).longValue());
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    paramActivity = this.a;
    paramActivity.i += 1;
    paramActivity.c();
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity)
  {
    a();
    paramActivity = this.a;
    if (paramActivity.e) {
      paramActivity.c.cV().i();
    }
    paramActivity = this.a;
    paramActivity.h += 1;
    paramActivity.g = false;
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    paramActivity = this.a;
    paramActivity.h -= 1;
    if (paramActivity.h == 0) {
      paramActivity.a = false;
    }
    paramActivity.b.c();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/i/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */