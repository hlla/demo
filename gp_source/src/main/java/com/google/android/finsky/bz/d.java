package com.google.android.finsky.bz;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.googlehelp.GoogleHelp;
import com.google.android.gms.googlehelp.b;

final class d
  implements Runnable
{
  d(c paramc, String paramString, Activity paramActivity) {}
  
  public final void run()
  {
    Object localObject = new GoogleHelp(this.c);
    ((GoogleHelp)localObject).f = this.a.b.cR();
    ((GoogleHelp)localObject).g = c.a;
    localObject = ((GoogleHelp)localObject).a(c.a(this.b), this.b.getCacheDir()).a();
    new b(this.b).a((Intent)localObject);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bz/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */