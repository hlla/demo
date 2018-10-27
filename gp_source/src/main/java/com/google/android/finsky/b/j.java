package com.google.android.finsky.b;

import android.content.Context;
import android.support.v7.widget.eu;
import android.support.v7.widget.ev;
import com.android.volley.VolleyError;
import com.google.android.finsky.dfemodel.DfeToc;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.dfemodel.l;
import com.google.android.finsky.dfemodel.v;
import com.google.android.finsky.ds.a.de;
import com.google.android.finsky.ds.a.ka;
import com.google.android.finsky.e.af;
import com.google.android.finsky.e.aq;
import com.google.android.finsky.frameworkviews.aj;
import com.google.android.finsky.layout.ReviewItemLayout;
import com.google.android.finsky.ratereview.s;
import com.google.android.finsky.ratereview.z;
import com.google.android.finsky.utils.FinskyLog;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public final class j
  extends com.google.android.finsky.recyclerview.g
  implements com.android.volley.w, v
{
  public final l c;
  public final Document d;
  public final List e = new ArrayList();
  public final af f;
  public final com.google.android.finsky.navigationmanager.c g;
  public final s h;
  private aj k;
  private final boolean l;
  private final m m;
  private final NumberFormat n;
  private final aq o;
  private final com.google.android.finsky.ratereview.n p;
  private final int q;
  private final com.google.android.finsky.ba.g r;
  private final DfeToc s;
  
  public j(Context paramContext, Document paramDocument, l paraml, boolean paramBoolean, DfeToc paramDfeToc, m paramm, com.google.android.finsky.navigationmanager.c paramc, com.google.android.finsky.ratereview.n paramn, aq paramaq, af paramaf, z paramz, com.google.android.finsky.accounts.c paramc1, com.google.android.finsky.ba.g paramg)
  {
    super(paramContext, paraml.n(), paraml.j);
    this.d = paramDocument;
    this.c = paraml;
    this.l = paramBoolean;
    this.c.a(this);
    this.c.a(this);
    this.q = Integer.MAX_VALUE;
    this.m = paramm;
    this.g = paramc;
    this.o = paramaq;
    this.f = paramaf;
    this.p = paramn;
    this.h = paramz.f(paramc1.cS());
    this.n = NumberFormat.getIntegerInstance();
    this.s = paramDfeToc;
    this.r = paramg;
    i();
  }
  
  private final boolean a(ka paramka, com.google.android.finsky.ratereview.o paramo)
  {
    return this.h.c(this.d.a.s, paramka.d, paramo);
  }
  
  private final void i()
  {
    this.e.clear();
    Object localObject;
    if (this.c.a()) {
      if (!j())
      {
        localObject = this.d;
        if ((localObject != null) && (((Document)localObject).bH()) && (!this.l)) {
          break label511;
        }
      }
    }
    for (;;)
    {
      if (!j())
      {
        localObject = this.d;
        if (localObject != null) {
          break label461;
        }
      }
      for (;;)
      {
        if ((!j()) && (this.l) && (this.c.c != null)) {
          this.e.add(new n(2131624972));
        }
        if (this.c.j() != 0)
        {
          localObject = this.d;
          if ((localObject != null) && (((Document)localObject).a.r != 1)) {
            break label422;
          }
        }
        for (;;)
        {
          if (j()) {
            this.e.add(new n(2131624965));
          }
          int i;
          if (this.c.j() == 0)
          {
            localObject = this.e;
            if (!this.c.j)
            {
              i = 2131624954;
              ((List)localObject).add(new n(i));
              i = 0;
            }
          }
          for (;;)
          {
            if (i < this.c.j())
            {
              localObject = (ka)this.c.a(i, false);
              if (this.l) {
                this.e.add(new n(2131624971, i));
              }
              for (;;)
              {
                i += 1;
                break;
                if ((!a((ka)localObject, com.google.android.finsky.ratereview.o.d)) && (!a((ka)localObject, com.google.android.finsky.ratereview.o.b))) {
                  this.e.add(new n(2131624934, i));
                }
              }
            }
            i = this.j;
            if (i != 0)
            {
              if (i != 1) {
                break label353;
              }
              this.e.add(new n(2131624592));
            }
            for (;;)
            {
              this.b.b();
              return;
              label353:
              if (i != 2)
              {
                FinskyLog.d("No footer or item in last row", new Object[0]);
                this.e.add(new n(2131624258));
              }
              else
              {
                this.e.add(new n(2131624258));
              }
            }
            i = 2131624592;
            break;
            i = 0;
          }
          label422:
          if ((!this.l) && (!this.r.b())) {
            this.e.add(new n(2131624608));
          }
        }
        label461:
        if ((((Document)localObject).a.r == 1) && (!this.l) && (!this.r.b())) {
          this.e.add(new n(2131624953));
        }
      }
      label511:
      this.e.add(new n(2131624959));
    }
  }
  
  private final boolean j()
  {
    return this.c.e != null;
  }
  
  protected final String a()
  {
    return com.google.android.finsky.api.o.a(this.i, this.c.m());
  }
  
  public final void a(VolleyError paramVolleyError)
  {
    a(2);
  }
  
  final void a(ReviewItemLayout paramReviewItemLayout, com.google.android.finsky.ratereview.o paramo, ka paramka)
  {
    com.google.android.finsky.ratereview.n localn = this.p;
    if (localn != null) {
      localn.a(this.d.a.s, paramka.d, paramo);
    }
    if (this.h.c(this.d.a.s, paramka.d, paramo)) {
      this.h.b(this.d.a.s, paramka.d, paramo);
    }
    for (;;)
    {
      paramReviewItemLayout.a(this.d, paramka, this.q, false, true, true, a(paramka, com.google.android.finsky.ratereview.o.a), a(paramka, com.google.android.finsky.ratereview.o.d), a(paramka, com.google.android.finsky.ratereview.o.c), a(paramka, com.google.android.finsky.ratereview.o.b), this.o, this.f);
      return;
      this.h.a(this.d.a.s, paramka.d, paramo);
    }
  }
  
  protected final boolean b()
  {
    return this.c.j;
  }
  
  public final int c()
  {
    return this.e.size();
  }
  
  public final int c(int paramInt)
  {
    return ((n)this.e.get(paramInt)).b;
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */