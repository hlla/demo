package com.google.android.finsky.de;

import android.content.Context;
import android.content.Intent;
import com.google.android.finsky.ag.q;
import com.google.android.finsky.installqueue.InstallRequest;
import com.google.android.finsky.installqueue.t;
import com.google.android.finsky.notification.u;
import com.google.android.finsky.utils.i;
import java.util.concurrent.TimeUnit;

public final class c
  implements t
{
  private final Context a;
  private final b.a b;
  private final com.google.android.finsky.af.d c;
  private final b.a d;
  private final b.a e;
  
  public c(Context paramContext, b.a parama1, b.a parama2, b.a parama3, com.google.android.finsky.af.d paramd)
  {
    this.a = paramContext;
    this.e = parama1;
    this.d = parama2;
    this.b = parama3;
    this.c = paramd;
  }
  
  private final void a(InstallRequest paramInstallRequest, String paramString1, String paramString2)
  {
    Object localObject = (com.google.android.finsky.cl.a)this.b.a();
    String str = paramInstallRequest.b.m;
    localObject = ((com.google.android.finsky.cl.a)localObject).b(str, com.google.android.finsky.api.n.a(str));
    ((u)this.d.a()).a(paramInstallRequest.b.m, paramString1, (Intent)localObject, paramString2);
  }
  
  public final com.google.android.finsky.af.e a(com.google.android.finsky.installqueue.n paramn)
  {
    long l = TimeUnit.MILLISECONDS.toSeconds(i.a());
    l = TimeUnit.MINUTES.toSeconds(((Integer)com.google.android.finsky.ag.d.gj.b()).intValue()) + l;
    this.e.a();
    com.google.wireless.android.finsky.dfe.r.a.a locala = a.a();
    if (locala == null)
    {
      if (((Integer)com.google.android.finsky.billing.common.e.a.a()).intValue() == 4) {
        com.google.android.finsky.billing.common.e.a.a(Integer.valueOf(1));
      }
      paramn = paramn.g;
      a(paramn, this.a.getString(2131952810, new Object[] { paramn.b.u }), "err");
      return this.c.a(null);
    }
    if (locala.c >= l) {}
    for (;;)
    {
      if (locala.c - TimeUnit.MILLISECONDS.toSeconds(i.a()) > TimeUnit.MINUTES.toSeconds(((Integer)com.google.android.finsky.ag.d.gi.b()).intValue()))
      {
        localObject = paramn.g;
        a((InstallRequest)localObject, this.a.getString(2131952811, new Object[] { ((InstallRequest)localObject).b.u }), "progress");
      }
      Object localObject = this.c;
      this.e.a();
      return ((com.google.android.finsky.af.d)localObject).a(a.a(paramn.g, locala));
      locala.a |= 0x4;
      locala.c = l;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/de/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */