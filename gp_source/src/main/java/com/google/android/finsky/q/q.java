package com.google.android.finsky.q;

import android.app.Activity;
import android.support.v4.app.j;
import android.support.v4.app.v;
import com.google.android.finsky.ag.d;
import com.google.android.finsky.bb.i;
import com.google.android.finsky.bb.o;
import com.google.android.finsky.e.af;
import com.google.android.play.utils.b.a;

public final class q
  extends i
{
  private r af;
  
  public static void a(v paramv)
  {
    paramv = paramv.a("bg_data_dialog");
    if (paramv != null) {
      ((j)paramv).a(false);
    }
  }
  
  public static void a(v paramv, Activity paramActivity, af paramaf)
  {
    if (paramv.a("bg_data_dialog") == null)
    {
      q localq = new q();
      if ((paramActivity instanceof r)) {
        localq.af = ((r)paramActivity);
      }
      new o().c(2131951809).e(2131951808).b(paramActivity.getString(2131951807, new Object[] { d.ed.b() })).a(false).a(320, null, -1, -1, paramaf).a(localq);
      localq.a(paramv, "bg_data_dialog");
    }
  }
  
  protected final void R()
  {
    super.R();
    r localr = this.af;
    if (localr != null) {
      localr.G();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/q/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */