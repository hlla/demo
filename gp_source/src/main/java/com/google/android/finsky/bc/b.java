package com.google.android.finsky.bc;

import android.accounts.Account;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;
import com.google.android.finsky.be.c;
import com.google.android.finsky.be.g;
import com.google.android.finsky.be.h;
import com.google.android.finsky.be.l;
import com.google.android.finsky.be.w;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.cx;
import com.google.android.finsky.ds.a.de;
import com.google.android.finsky.ds.a.o;
import com.google.android.finsky.e.af;
import com.google.android.finsky.e.aq;
import com.google.android.finsky.e.z;
import com.google.android.finsky.installer.p;
import com.google.android.finsky.installqueue.InstallConstraint;
import com.google.android.finsky.installqueue.InstallRequest;
import com.google.android.finsky.utils.FinskyLog;
import com.google.common.base.u;
import com.google.wireless.android.a.b.a.a.bu;
import com.google.wireless.android.finsky.dfe.e.a.bx;
import com.google.wireless.android.finsky.dfe.e.a.cg;
import com.google.wireless.android.finsky.dfe.e.a.ci;
import com.google.wireless.android.finsky.dfe.e.a.cl;
import com.google.wireless.android.finsky.dfe.e.a.cn;
import com.google.wireless.android.finsky.dfe.e.a.dh;
import com.google.wireless.android.finsky.dfe.e.a.di;
import com.google.wireless.android.finsky.dfe.e.a.dj;
import com.google.wireless.android.finsky.dfe.e.a.dn;
import com.google.wireless.android.finsky.dfe.e.a.dq;
import com.google.wireless.android.finsky.dfe.e.a.dr;
import com.google.wireless.android.finsky.dfe.e.a.dx;
import com.google.wireless.android.finsky.dfe.e.a.dy;
import com.google.wireless.android.finsky.dfe.e.a.ea;
import com.google.wireless.android.finsky.dfe.e.a.ej;
import com.google.wireless.android.finsky.dfe.e.a.ek;
import com.google.wireless.android.finsky.dfe.e.a.eo;
import com.google.wireless.android.finsky.dfe.e.a.ez;

public final class b
  implements e, com.google.android.finsky.be.d
{
  private final c a;
  private final a b;
  private final Context c;
  private dy d;
  private final l e;
  private final com.google.android.finsky.be.q f;
  private final f g;
  private final com.google.android.finsky.bo.f h;
  private final com.google.android.finsky.be.f i;
  private final w j;
  private final d k;
  private final com.google.android.finsky.be.y l;
  
  public b(Context paramContext, c paramc, a parama, l paraml, com.google.android.finsky.be.f paramf, com.google.android.finsky.be.q paramq, d paramd, f paramf1, w paramw, com.google.android.finsky.be.y paramy, com.google.android.finsky.bo.f paramf2)
  {
    this.c = paramContext;
    this.a = paramc;
    this.b = parama;
    this.e = paraml;
    this.i = paramf;
    this.f = paramq;
    this.k = paramd;
    this.g = paramf1;
    this.j = paramw;
    this.l = paramy;
    this.h = paramf2;
    paramContext = this.b;
    if (paramContext != null) {
      paramContext.a(this);
    }
    this.e.a = this;
    this.g.a(this);
    this.d = this.g.b();
  }
  
  private final void a(dx paramdx, boolean paramBoolean)
  {
    int n = 0;
    int m = n;
    if (paramdx != null)
    {
      m = n;
      if (paramdx.b != null) {
        m = 1;
      }
    }
    if (m != 0) {}
    for (;;)
    {
      this.g.a(paramdx);
      if (m != 0) {
        a(paramdx.b);
      }
      return;
      if (!paramBoolean) {
        this.k.c();
      }
    }
  }
  
  private final void a(dy paramdy, ea paramea)
  {
    boolean bool = false;
    Object localObject1;
    if ((!this.k.d()) || (this.h.a(12660245L)))
    {
      localObject1 = this.f;
      ((com.google.android.finsky.be.q)localObject1).b = paramea.d;
      if ((paramdy.b & 0x1) == 0) {
        break label373;
      }
    }
    label373:
    for (int m = paramdy.f;; m = 0)
    {
      Object localObject2 = paramdy.d;
      Object localObject3;
      if (m == ((com.google.android.finsky.be.q)localObject1).g)
      {
        localObject3 = ((com.google.android.finsky.be.q)localObject1).f;
        if (localObject3 != null) {
          ((com.google.android.finsky.be.q)localObject1).a((aq)localObject3, (dn)localObject2);
        }
      }
      for (;;)
      {
        localObject2 = paramdy.c;
        if (localObject2 == null)
        {
          localObject2 = ((com.google.android.finsky.be.q)localObject1).f;
          ((com.google.android.finsky.be.q)localObject1).c = ((aq)localObject2);
          ((com.google.android.finsky.be.q)localObject1).d = ((aq)localObject2);
        }
        for (;;)
        {
          this.f.g();
          localObject1 = paramdy.g;
          if (localObject1 != null)
          {
            a((bx)localObject1);
            return;
          }
          if (paramdy != this.d) {
            bool = true;
          }
          this.d = paramdy;
          localObject1 = paramea.i;
          if (!bool) {
            paramea = new ci().a(2);
          }
          for (;;)
          {
            this.k.a(this, paramdy, paramea, bool);
            return;
            localObject2 = paramdy.e;
            paramea = (ea)localObject1;
            if (localObject2 != null)
            {
              a((bx)localObject2);
              paramea = (ea)localObject1;
            }
          }
          if ((((dr)localObject2).b & 0x1) == 0) {
            break;
          }
          localObject3 = ((com.google.android.finsky.be.q)localObject1).a(paramdy.d);
          localObject3 = new com.google.android.finsky.e.y(((dr)localObject2).f, ((dr)localObject2).g, (aq)localObject3);
          ((com.google.android.finsky.e.y)localObject3).a();
          if ((((dr)localObject2).b & 0x4) != 0)
          {
            com.google.wireless.android.a.b.a.a.n localn = new com.google.wireless.android.a.b.a.a.n();
            localn.a(((dr)localObject2).d);
            localObject2 = new bu();
            ((bu)localObject2).a = localn;
            ((com.google.android.finsky.e.y)localObject3).getPlayStoreUiElement().c = ((bu)localObject2);
          }
          ((com.google.android.finsky.be.q)localObject1).d = ((aq)localObject3);
          ((com.google.android.finsky.be.q)localObject1).c = ((aq)localObject3);
        }
        ((com.google.android.finsky.be.q)localObject1).g = m;
        ((com.google.android.finsky.be.q)localObject1).f = ((com.google.android.finsky.be.q)localObject1).b((dn)localObject2);
      }
    }
  }
  
  public final void a()
  {
    switch (this.g.a())
    {
    default: 
      throw new RuntimeException("Developer error");
    case 0: 
      a(null, false);
    case 2: 
      do
      {
        return;
        dy localdy = this.g.b();
        if (localdy != null)
        {
          a(localdy, this.g.d());
          return;
        }
      } while (this.g.e() == null);
      a(this.g.e());
      return;
    }
    this.k.c();
  }
  
  public final void a(bx parambx)
  {
    for (;;)
    {
      if (parambx == null)
      {
        FinskyLog.e("Empty action", new Object[0]);
        if (this.h.a(12658587L)) {
          a();
        }
      }
      label32:
      int m;
      Object localObject3;
      label297:
      label356:
      do
      {
        do
        {
          return;
          this.e.a();
          localObject1 = parambx.i;
          if (localObject1 != null) {
            this.f.a((dr)localObject1);
          }
          if ((parambx.b & 0x1) != 0) {
            this.a.a(parambx.a);
          }
          localObject1 = parambx.c;
          if (localObject1 != null)
          {
            this.g.a((cg)localObject1);
            return;
          }
          localObject1 = parambx.p;
          if (localObject1 != null)
          {
            this.l.a(((eo)localObject1).a);
            return;
          }
          localObject1 = parambx.l;
          if (localObject1 != null) {
            break label1679;
          }
          localObject1 = parambx.k;
          if (localObject1 != null) {
            break label1668;
          }
          localObject1 = parambx.g;
          if (localObject1 != null)
          {
            parambx = ((dh)localObject1).d;
            int n = parambx.length;
            m = 0;
            for (;;)
            {
              if (m >= n) {
                break label297;
              }
              localObject2 = parambx[m];
              if (!this.j.c((String)localObject2)) {
                break;
              }
              m += 1;
            }
            for (m = 0;; m = 1)
            {
              parambx = ((dh)localObject1).b;
              int i1 = parambx.length;
              n = 0;
              if (n < i1)
              {
                localObject2 = parambx[n];
                localObject3 = this.j.b(((di)localObject2).a);
                if (localObject3 == null) {}
                while (((String)localObject3).matches(((di)localObject2).b))
                {
                  n += 1;
                  break;
                }
              }
              for (n = 0;; n = 1)
              {
                if (m == 0) {}
                while (n == 0)
                {
                  parambx = ((dh)localObject1).a;
                  break;
                }
                parambx = ((dh)localObject1).c;
                break;
              }
            }
          }
          localObject1 = parambx.n;
          if (localObject1 != null) {
            break label1620;
          }
          localObject1 = parambx.o;
          if (localObject1 == null) {
            break label356;
          }
          this.j.a(((ek)localObject1).a, ((ek)localObject1).c);
          parambx = parambx.o.b;
        } while (parambx == null);
        break;
        localObject2 = parambx.j;
        if (localObject2 != null) {
          break label1384;
        }
        localObject1 = parambx.f;
        if (localObject1 != null) {
          break label1325;
        }
        localObject1 = parambx.e;
        if (localObject1 == null) {
          break label431;
        }
        parambx = this.e;
      } while (((cl)localObject1).a == null);
      parambx.a();
      parambx.b = ((cl)localObject1);
      parambx.d.postDelayed(parambx.c, ((cl)localObject1).b);
      return;
      label431:
      if (!this.b.a(parambx)) {}
      label478:
      label504:
      label579:
      label686:
      label771:
      while (parambx.m)
      {
        localObject1 = parambx.h;
        if (localObject1 == null) {
          break label32;
        }
        localObject3 = this.i;
        if (localObject3 == null) {
          break label32;
        }
        ez localez = ((dj)localObject1).a;
        String str;
        if (localez != null)
        {
          localObject2 = u.c(localez);
          localObject1 = ((com.google.android.finsky.be.f)localObject3).g;
          if (localObject1 != null)
          {
            localObject1 = ((com.google.android.finsky.be.n)localObject1).a();
            str = (String)((u)localObject2).a(g.a).a(((u)localObject1).a(h.a)).a("");
            switch (((com.google.android.finsky.be.f)localObject3).e.b)
            {
            default: 
              FinskyLog.a("Will queue %s to be downloaded over any network", new Object[] { str });
              if ((((com.google.android.finsky.be.f)localObject3).f.a(12623705L)) || (((com.google.android.finsky.be.f)localObject3).f.a(12643667L))) {
                if (((u)localObject2).a())
                {
                  localObject1 = new com.google.android.finsky.installqueue.k(((com.google.android.finsky.be.f)localObject3).i.c(), ((ez)((u)localObject2).b()).d, ((ez)((u)localObject2).b()).f, ((ez)((u)localObject2).b()).c).b(((com.google.android.finsky.be.f)localObject3).a.name).a("single_install");
                  if (((com.google.android.finsky.be.f)localObject3).a()) {
                    ((com.google.android.finsky.installqueue.k)localObject1).a(new InstallConstraint[] { new com.google.android.finsky.installqueue.d().a(2).b() });
                  }
                  if (((com.google.android.finsky.be.f)localObject3).c.a(str)) {
                    ((com.google.android.finsky.installqueue.k)localObject1).a(new InstallConstraint[] { new com.google.android.finsky.installqueue.d().b(true).b() });
                  }
                  localObject1 = u.b(((com.google.android.finsky.installqueue.k)localObject1).a());
                  if (((u)localObject1).a())
                  {
                    ((com.google.android.finsky.be.f)localObject3).d = ((InstallRequest)((u)localObject1).c());
                    if (((u)localObject1).a()) {
                      ((com.google.android.finsky.be.f)localObject3).a((InstallRequest)((u)localObject1).b());
                    }
                  }
                }
              }
              break;
            }
          }
        }
        for (;;)
        {
          parambx = parambx.h.b;
          if (parambx == null) {
            break label32;
          }
          break;
          if (localez != null)
          {
            localObject1 = new de();
            ((de)localObject1).a(localez.d);
            ((de)localObject1).c(localez.c);
            ((de)localObject1).o = new cx();
            ((de)localObject1).o.b = new o();
            ((de)localObject1).o.b.a(localez.d);
            ((de)localObject1).o.b.a(localez.f);
          }
          for (localObject1 = new Document((de)localObject1);; localObject1 = (Document)((com.google.android.finsky.be.f)localObject3).g.a().b())
          {
            ((com.google.android.finsky.be.f)localObject3).h.a(((Document)localObject1).a.s, false);
            ((com.google.android.finsky.be.f)localObject3).h.a(((Document)localObject1).a.s, ((Document)localObject1).i(), ((com.google.android.finsky.be.f)localObject3).a.name, ((Document)localObject1).a.I, 2, ((Document)localObject1).E(), ((com.google.android.finsky.be.f)localObject3).i.a("single_install"));
            break;
          }
          if (localez == null) {}
          for (localObject2 = ((Document)((com.google.android.finsky.be.f)localObject3).g.a().b()).a.s;; localObject2 = localez.d)
          {
            if (((com.google.android.finsky.be.f)localObject3).a())
            {
              ((com.google.android.finsky.be.f)localObject3).h.c((String)localObject2);
              break;
            }
            ((com.google.android.finsky.be.f)localObject3).h.a((String)localObject2);
            break;
          }
          localObject1 = new com.google.android.finsky.installqueue.k(((com.google.android.finsky.be.f)localObject3).i.c(), (Document)((u)localObject1).b()).b(((com.google.android.finsky.be.f)localObject3).a.name).a("single_install");
          break label686;
          localObject1 = com.google.common.base.a.a;
          break label771;
          FinskyLog.a("Will queue %s to be downloaded on offpeak or wifi", new Object[] { str });
          com.google.wireless.android.finsky.dfe.r.a.a locala = com.google.android.finsky.de.a.a();
          if (locala == null)
          {
            FinskyLog.a("Persistent download network preference no longer available. Will queue %s to be downloaded over any network", new Object[] { str });
            com.google.android.finsky.billing.common.e.a.a(Integer.valueOf(1));
            break label579;
          }
          if (!((u)localObject1).a()) {
            break label579;
          }
          localObject1 = u.b(com.google.android.finsky.de.a.a(((com.google.android.finsky.be.f)localObject3).i, ((com.google.android.finsky.be.f)localObject3).a.name, (Document)((u)localObject1).b(), locala));
          break label771;
          FinskyLog.a("Will queue %s to be downloaded on wifi only", new Object[] { str });
          break label579;
          localObject1 = com.google.common.base.a.a;
          break label504;
          localObject1 = ((com.google.android.finsky.be.f)localObject3).g;
          if (localObject1 != null) {
            if (((com.google.android.finsky.be.n)localObject1).a().a()) {
              break label478;
            }
          }
        }
      }
      this.k.c();
      return;
      label1325:
      if (((cn)localObject1).a == 1) {
        Toast.makeText(this.c, ((cn)localObject1).c, 1).show();
      }
      for (;;)
      {
        parambx = parambx.f.b;
        if (parambx == null) {
          break label32;
        }
        break;
        Toast.makeText(this.c, ((cn)localObject1).c, 0).show();
      }
      label1384:
      Object localObject1 = this.f;
      Object localObject2 = ((dq)localObject2).a;
      if (localObject2 != null)
      {
        m = ((dr)localObject2).b;
        if ((m & 0x10) != 0) {
          break label1430;
        }
      }
      for (;;)
      {
        parambx = parambx.j.b;
        if (parambx == null) {
          break label32;
        }
        break;
        label1430:
        if ((m & 0x1) != 0) {
          switch (((dr)localObject2).c)
          {
          default: 
            break;
          case 1: 
            localObject3 = ((com.google.android.finsky.be.q)localObject1).d(((dr)localObject2).f);
            if ((((dr)localObject2).b & 0x2) != 0) {
              ((com.google.android.finsky.e.d)localObject3).a(((dr)localObject2).g);
            }
            if (((dr)localObject2).d()) {
              ((com.google.android.finsky.e.d)localObject3).d(((dr)localObject2).a);
            }
            ((com.google.android.finsky.be.q)localObject1).e.a(((com.google.android.finsky.e.d)localObject3).a, com.google.android.finsky.be.q.b((dr)localObject2));
            break;
          case 3: 
            ((com.google.android.finsky.be.q)localObject1).a((dr)localObject2);
            break;
          case 2: 
            localObject3 = new com.google.android.finsky.e.y(((com.google.android.finsky.be.q)localObject1).g);
            ((aq)localObject3).a(new com.google.android.finsky.e.y(((dr)localObject2).f));
            ((com.google.android.finsky.be.q)localObject1).e.a(new z().a((aq)localObject3).a(), com.google.android.finsky.be.q.b((dr)localObject2));
          }
        }
      }
      label1620:
      localObject1 = Uri.parse(((ej)localObject1).a);
      localObject2 = new Intent("android.intent.action.VIEW", (Uri)localObject1);
      try
      {
        this.c.startActivity((Intent)localObject2);
        parambx = parambx.n.b;
        if (parambx == null) {
          break label32;
        }
        continue;
        label1668:
        a((dx)localObject1, parambx.m);
        return;
        label1679:
        if (((ea)localObject1).e)
        {
          localObject1 = this.f;
          localObject2 = new com.google.android.finsky.e.y(((com.google.android.finsky.be.q)localObject1).g);
          ((aq)localObject2).a(com.google.android.finsky.be.q.a);
          ((com.google.android.finsky.be.q)localObject1).e.a(new z().a((aq)localObject2).a(), null);
        }
        localObject1 = this.g.a(parambx.l);
        if (localObject1 != null)
        {
          a((dy)localObject1, parambx.l);
          localObject1 = parambx.l;
          if ((((ea)localObject1).a & 0x2) == 0) {}
          for (;;)
          {
            parambx = parambx.l.f;
            if (parambx == null) {
              break label32;
            }
            break;
            com.google.android.finsky.bw.a.a(this.c, ((ea)localObject1).b, null, false);
          }
        }
        localObject1 = parambx.l.h;
        parambx = (bx)localObject1;
        if (localObject1 != null) {
          continue;
        }
        if (TextUtils.isEmpty(this.g.c())) {
          break label32;
        }
        parambx = String.valueOf(this.g.c());
        if (parambx.length() == 0)
        {
          parambx = new String("Not handling screen not found. Screen is not found because: ");
          throw new RuntimeException(parambx);
        }
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        for (;;)
        {
          FinskyLog.c("No view handler for url %s", new Object[] { localObject1 });
          Toast.makeText(this.c, 2131952758, 0).show();
          continue;
          parambx = "Not handling screen not found. Screen is not found because: ".concat(parambx);
        }
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    Object localObject1 = this.f;
    Object localObject2 = ((com.google.android.finsky.be.q)localObject1).a(null);
    if (!paramBoolean) {}
    for (int m = ((com.google.android.finsky.be.q)localObject1).h;; m = 601)
    {
      localObject2 = new com.google.android.finsky.e.f((aq)localObject2).a(m);
      ((com.google.android.finsky.be.q)localObject1).e.a(((com.google.android.finsky.e.f)localObject2).a(), null);
      localObject1 = this.g.a(paramBoolean);
      if (localObject1 != null)
      {
        if (!((bx)localObject1).d) {
          this.g.f();
        }
        a((bx)localObject1);
      }
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */