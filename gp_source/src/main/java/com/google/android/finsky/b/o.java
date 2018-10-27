package com.google.android.finsky.b;

import android.content.Context;
import android.support.v7.widget.eu;
import android.support.v7.widget.ev;
import com.android.volley.VolleyError;
import com.google.android.finsky.accounts.c;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.dfemodel.l;
import com.google.android.finsky.dfemodel.v;
import com.google.android.finsky.ds.a.de;
import com.google.android.finsky.ds.a.ka;
import com.google.android.finsky.e.af;
import com.google.android.finsky.e.aq;
import com.google.android.finsky.ratereview.s;
import com.google.android.finsky.ratereview.z;
import com.google.android.finsky.utils.FinskyLog;
import java.util.ArrayList;
import java.util.List;

public final class o
  extends com.google.android.finsky.recyclerview.g
  implements com.android.volley.w, v
{
  public final l c;
  public final r d;
  private final Document e;
  private final List f = new ArrayList();
  private final af g;
  private final aq h;
  private final int k;
  private final s l;
  private final boolean m;
  
  public o(Context paramContext, Document paramDocument, l paraml, boolean paramBoolean, aq paramaq, r paramr, af paramaf, c paramc, z paramz)
  {
    super(paramContext, paraml.n(), paraml.j);
    this.e = paramDocument;
    this.c = paraml;
    this.c.a(this);
    this.c.a(this);
    this.m = paramBoolean;
    this.k = Integer.MAX_VALUE;
    this.h = paramaq;
    this.d = paramr;
    this.g = paramaf;
    this.l = paramz.f(paramc.cS());
    i();
  }
  
  private final boolean a(ka paramka, com.google.android.finsky.ratereview.o paramo)
  {
    return this.l.c(this.e.a.s, paramka.d, paramo);
  }
  
  private final void i()
  {
    this.f.clear();
    Object localObject;
    int i;
    if (this.c.a())
    {
      if (this.m) {
        this.f.add(new q(2131624230));
      }
      if (this.c.e != null) {
        this.f.add(new q(2131624965));
      }
      if (this.c.j() != 0) {
        break label319;
      }
      localObject = this.f;
      if (this.c.j) {
        break label313;
      }
      i = 2131624954;
      ((List)localObject).add(new q(i));
      i = 0;
    }
    for (;;)
    {
      if (i < this.c.j())
      {
        localObject = (ka)this.c.a(i, false);
        if (a((ka)localObject, com.google.android.finsky.ratereview.o.d)) {}
        for (;;)
        {
          i += 1;
          break;
          if (!a((ka)localObject, com.google.android.finsky.ratereview.o.b)) {
            this.f.add(new q(2131624934, i));
          }
        }
      }
      i = this.j;
      if (i != 0)
      {
        if (i != 1) {
          break label255;
        }
        this.f.add(new q(2131624592));
      }
      for (;;)
      {
        this.f.add(new q(2131624229));
        this.b.b();
        return;
        label255:
        if (i != 2)
        {
          FinskyLog.d("No footer or item in last row", new Object[0]);
          this.f.add(new q(2131624258));
        }
        else
        {
          this.f.add(new q(2131624258));
        }
      }
      label313:
      i = 2131624592;
      break;
      label319:
      i = 0;
    }
  }
  
  protected final String a()
  {
    return com.google.android.finsky.api.o.a(this.i, this.c.m());
  }
  
  public final void a(VolleyError paramVolleyError)
  {
    a(2);
  }
  
  protected final boolean b()
  {
    return this.c.j;
  }
  
  public final int c()
  {
    return this.f.size();
  }
  
  public final int c(int paramInt)
  {
    return ((q)this.f.get(paramInt)).b;
  }
  
  public final void e()
  {
    if (b()) {
      a(1);
    }
    for (;;)
    {
      i();
      return;
      a(0);
    }
  }
  
  protected final void f()
  {
    this.c.v();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/b/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */