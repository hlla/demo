package com.google.android.finsky.bb;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v4.app.at;
import android.support.v4.app.j;
import android.support.v4.app.v;
import com.google.android.finsky.e.af;
import com.google.android.finsky.utils.FinskyLog;

public final class f
  extends i
{
  private boolean af = false;
  
  public f()
  {
    b(true);
  }
  
  public static f a(v paramv, Fragment paramFragment, String paramString1, String paramString2, af paramaf, int paramInt)
  {
    b(paramv);
    paramFragment = (f)((g)((g)((g)((g)((g)new g().c(paramString1)).b(paramString2)).d(17039370)).a(paramFragment, paramInt, null)).a(323, null, 2903, -1, paramaf)).a();
    paramFragment.a(paramv, "error_dialog");
    return paramFragment;
  }
  
  private static void b(v paramv)
  {
    paramv.b();
    f localf = (f)paramv.a("error_dialog");
    if (localf != null) {
      paramv = paramv.a();
    }
    try
    {
      localf.af = true;
      paramv.a(localf).a(null).a();
      return;
    }
    catch (IllegalStateException paramv)
    {
      FinskyLog.c("Double remove of error dialog fragment: %s", new Object[] { localf });
    }
  }
  
  public final void a(v paramv)
  {
    b(paramv);
    super.a(paramv, "error_dialog");
  }
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!this.af)
    {
      q localq = X();
      if (localq != null)
      {
        int i = T();
        S();
        localq.q_(i);
      }
    }
    super.onDismiss(paramDialogInterface);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bb/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */