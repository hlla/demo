package com.google.android.finsky.bq.a;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.google.android.finsky.ag.p;
import com.google.android.finsky.ag.q;
import com.google.android.finsky.api.i;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.de;
import com.google.android.finsky.e.af;
import com.google.android.finsky.fd.h;
import com.google.android.finsky.library.g;
import com.google.android.finsky.library.n;
import com.google.android.finsky.library.r;
import com.google.wireless.android.finsky.dfe.k.a.j;
import com.google.wireless.android.finsky.dfe.k.a.o;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a
  implements com.google.android.finsky.bq.b, h
{
  public final com.google.android.finsky.ev.a a;
  private final com.google.android.finsky.accounts.c b;
  private final Context c;
  private final i d;
  private final com.google.android.finsky.bo.c e;
  private final Map f = new HashMap();
  private e g;
  private final com.google.android.finsky.library.c h;
  private final n i;
  private final r j;
  private final com.google.android.finsky.fd.a k;
  
  public a(Context paramContext, com.google.android.finsky.fd.a parama, com.google.android.finsky.bo.c paramc, com.google.android.finsky.ev.a parama1, com.google.android.finsky.accounts.c paramc1, com.google.android.finsky.library.c paramc2, i parami, n paramn, c paramc3, r paramr)
  {
    this.c = paramContext;
    this.k = parama;
    this.e = paramc;
    this.a = parama1;
    this.b = paramc1;
    this.h = paramc2;
    this.d = parami;
    this.i = paramn;
    this.j = paramr;
    this.k.a(this);
  }
  
  private final e e()
  {
    if (this.g == null) {
      this.g = new e(this.h, this.d, this.b, this, this.i, this.j);
    }
    return this.g;
  }
  
  public final com.google.android.finsky.bq.a a(Context paramContext, Document paramDocument)
  {
    Object localObject2 = e();
    Object localObject4 = ((e)localObject2).a.cR();
    if (localObject4 != null)
    {
      Object localObject3 = ((e)localObject2).c.a(((Account)localObject4).name);
      Object localObject1 = ((e)localObject2).d.a((Account)localObject4);
      localObject1 = ((e)localObject2).f.b(paramDocument.c(), (com.google.android.finsky.library.e)localObject1);
      boolean bool1 = ((com.google.android.finsky.bq.d)localObject3).a(paramDocument.a.g);
      boolean bool2 = ((com.google.android.finsky.bq.d)localObject3).g();
      localObject4 = ((Account)localObject4).name;
      localObject3 = ((com.google.android.finsky.bq.d)localObject3).b();
      if ((localObject3 != null) && (bool1) && (localObject1 != null))
      {
        int m = ((j)localObject3).b;
        localObject4 = ((e)localObject2).c.a((String)localObject4);
        boolean bool3 = ((com.google.android.finsky.bq.d)localObject4).l();
        if (m == 1) {}
        while (bool3)
        {
          String str = ((g)localObject1).p;
          if (!TextUtils.isEmpty(str))
          {
            localObject2 = ((e)localObject2).c.a().a(str);
            if (localObject2 == null) {}
            for (paramContext = paramContext.getString(2131952288);; paramContext = paramContext.getString(2131952289, new Object[] { ((o)localObject2).a.I })) {
              return new com.google.android.finsky.bq.a(paramDocument, (g)localObject1, paramContext, 0, true, false);
            }
          }
          if ((((g)localObject1).n == 1) || (paramDocument.a.t))
          {
            bool1 = ((e)localObject2).c.a(com.google.android.finsky.ag.c.ao);
            long l = ((j)localObject3).d;
            if (bool3) {
              if (((g)localObject1).m > l) {
                if (!((com.google.android.finsky.bq.d)localObject4).m())
                {
                  m = 2;
                  bool1 = false;
                }
              }
            }
            for (;;)
            {
              if ((m == 1) && (!bool2)) {
                return null;
              }
              return new com.google.android.finsky.bq.a(paramDocument, (g)localObject1, paramContext.getString(2131952290), m, ((g)localObject1).o, bool1);
              return null;
              m = 1;
              continue;
              m = 1;
            }
          }
          return null;
        }
      }
      return null;
    }
    return null;
  }
  
  public final com.google.android.finsky.bq.d a()
  {
    return a(this.b.cS());
  }
  
  public final com.google.android.finsky.bq.d a(String paramString)
  {
    if (!this.f.containsKey(paramString)) {
      this.f.put(paramString, new d(this.k, this.e, paramString));
    }
    return (com.google.android.finsky.bq.d)this.f.get(paramString);
  }
  
  public final void a(Intent paramIntent, com.google.android.finsky.navigationmanager.c paramc, af paramaf)
  {
    new Handler().post(new b(this, paramIntent, paramc, paramaf));
  }
  
  public final void a(Fragment paramFragment, com.google.android.finsky.bq.a parama, boolean paramBoolean)
  {
    e locale = e();
    Account localAccount = locale.a.cR();
    if (localAccount != null)
    {
      com.google.android.finsky.api.d locald = locale.b.a(localAccount.name);
      parama.b = paramBoolean;
      paramFragment = new f(locale, paramFragment, localAccount, parama);
      locald.a(parama.a.a.s, parama.c.k, paramBoolean, paramFragment, paramFragment);
    }
  }
  
  public final void a(com.google.android.finsky.bq.e parame)
  {
    e().g.add(parame);
  }
  
  public final boolean a(q paramq)
  {
    Integer localInteger = (Integer)paramq.a();
    if (localInteger.intValue() < 3)
    {
      paramq.a(Integer.valueOf(localInteger.intValue() + 1));
      return true;
    }
    return false;
  }
  
  public final void b(q paramq)
  {
    paramq.a(Integer.valueOf(3));
  }
  
  public final void b(com.google.android.finsky.bq.e parame)
  {
    e().g.remove(parame);
  }
  
  public final boolean b()
  {
    return c().isEmpty() ^ true;
  }
  
  public final List c()
  {
    return c.a(this.c, a());
  }
  
  public final boolean d()
  {
    Object localObject = this.c;
    com.google.android.finsky.bq.d locald = a();
    p localp = com.google.android.finsky.ag.c.al;
    boolean bool = c.a((Context)localObject, locald).contains(Integer.valueOf(3));
    localObject = locald.b();
    if ((localObject == null) || (locald.c() == null)) {}
    for (;;)
    {
      if (locald.k()) {}
      do
      {
        return (bool) && (((Integer)localp.b(locald.a()).a()).intValue() < ((Integer)com.google.android.finsky.ag.d.fi.b()).intValue());
      } while (((j)localObject).b == 1);
    }
  }
  
  public final void l_()
  {
    this.f.clear();
  }
  
  public final void m_() {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bq/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */