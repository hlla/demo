package com.google.android.finsky.s.a;

import android.content.Context;
import com.google.android.finsky.av.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a
  implements com.google.android.finsky.s.c
{
  private final com.google.android.finsky.accounts.c a;
  private final com.google.android.finsky.f.c b;
  private final com.google.android.finsky.t.a c;
  private final Context d;
  private final m e;
  private final com.google.android.finsky.devicemanagement.a f;
  private final com.google.android.finsky.bo.c g;
  private final b.a h;
  private final com.google.android.finsky.tos.c i;
  
  public a(com.google.android.finsky.bo.c paramc, com.google.android.finsky.tos.c paramc1, com.google.android.finsky.devicemanagement.a parama, Context paramContext, com.google.android.finsky.accounts.c paramc2, b.a parama1, com.google.android.finsky.t.a parama2, m paramm, com.google.android.finsky.f.c paramc3)
  {
    this.g = paramc;
    this.i = paramc1;
    this.f = parama;
    this.d = paramContext;
    this.a = paramc2;
    this.h = parama1;
    this.c = parama2;
    this.e = paramm;
    this.b = paramc3;
  }
  
  public final List a()
  {
    ArrayList localArrayList = new ArrayList();
    Collections.addAll(localArrayList, new com.google.android.finsky.s.b[] { new b(this.g, this.c), new e(this.g, this.i), new c(this.c, this.d, this.g), new com.google.android.finsky.cm.a(this.g, this.c) });
    localArrayList.add(new com.google.android.finsky.maintenancewindow.a(this.f, this.g));
    localArrayList.add(new g(this.g, this.a, this.h, this.e));
    localArrayList.add(new d(this.b, this.g));
    return localArrayList;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/s/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */