package com.google.android.finsky.bq.a;

import android.text.TextUtils;
import com.google.android.finsky.ag.p;
import com.google.android.finsky.ag.q;
import com.google.android.finsky.bo.f;
import com.google.android.finsky.ds.a.cx;
import com.google.android.finsky.ds.a.cy;
import com.google.android.finsky.ds.a.de;
import com.google.android.finsky.ds.a.mv;
import com.google.android.finsky.fd.a;
import com.google.android.finsky.utils.FinskyLog;
import com.google.wireless.android.finsky.dfe.k.a.g;
import com.google.wireless.android.finsky.dfe.k.a.j;
import com.google.wireless.android.finsky.dfe.k.a.o;
import com.google.wireless.android.finsky.dfe.nano.cq;
import com.google.wireless.android.finsky.dfe.nano.gw;

public final class d
  implements com.google.android.finsky.bq.d
{
  private final String a;
  private final com.google.android.finsky.bo.c b;
  private final j c;
  private final o d;
  private final a e;
  
  public d(a parama, com.google.android.finsky.bo.c paramc, String paramString)
  {
    this.e = parama;
    this.b = paramc;
    this.a = paramString;
    parama = this.a;
    if (parama != null)
    {
      parama = this.e.b(parama);
      if (parama != null) {
        parama = parama.e;
      }
    }
    for (;;)
    {
      this.c = parama;
      paramc = this.c;
      parama = (a)localObject;
      if (paramc != null)
      {
        paramc = paramc.a;
        parama = (a)localObject;
        if (paramc != null)
        {
          paramc = paramc.a;
          parama = (a)localObject;
          if (paramc != null)
          {
            int j = paramc.length;
            int i = 0;
            parama = (a)localObject;
            if (i < j)
            {
              parama = paramc[i];
              paramString = parama.a;
              if (paramString == null) {}
              do
              {
                do
                {
                  i += 1;
                  break;
                  paramString = paramString.o;
                } while (paramString == null);
                paramString = paramString.h;
              } while ((paramString == null) || (!paramString.a));
            }
          }
        }
      }
      this.d = parama;
      return;
      parama = null;
      continue;
      parama = null;
    }
  }
  
  public final o a(String paramString)
  {
    if (d())
    {
      o[] arrayOfo = this.c.a.a;
      int j = arrayOfo.length;
      int i = 0;
      while (i < j)
      {
        o localo2 = arrayOfo[i];
        localo1 = localo2;
        if (paramString.equals(localo2.a.f)) {
          break label65;
        }
        i += 1;
      }
    }
    o localo1 = null;
    label65:
    return localo1;
  }
  
  public final String a()
  {
    return this.a;
  }
  
  public final boolean a(int paramInt)
  {
    f localf = this.b.h(this.a);
    switch (paramInt)
    {
    case 2: 
    default: 
      return false;
    case 4: 
      return localf.a(12604246L);
    case 3: 
      return localf.a(12604244L);
    }
    return localf.a(12604245L);
  }
  
  public final j b()
  {
    return this.c;
  }
  
  public final void b(String paramString)
  {
    if (TextUtils.isEmpty(this.a)) {
      FinskyLog.e("AccountName should never be null to save consistency token.", new Object[0]);
    }
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    mv localmv = new mv();
    localmv.a |= 0x1;
    localmv.c = "X-DFE-Family-Consistency-Token";
    localmv.a(paramString);
    a.a(this.a, localmv);
  }
  
  public final o c()
  {
    return this.d;
  }
  
  public final boolean d()
  {
    return this.d != null;
  }
  
  public final boolean e()
  {
    o localo = this.d;
    if ((localo == null) || (localo.b != 5))
    {
      if (localo == null) {}
    }
    else {
      return localo.c;
    }
    return false;
  }
  
  public final boolean f()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (d())
    {
      o[] arrayOfo = this.c.a.a;
      int j = arrayOfo.length;
      int i = 0;
      for (;;)
      {
        bool1 = bool2;
        if (i >= j) {
          return bool1;
        }
        o localo = arrayOfo[i];
        if ((localo.b == 5) || (localo.c)) {
          break;
        }
        i += 1;
      }
      bool1 = true;
    }
    return bool1;
  }
  
  public final boolean g()
  {
    Object localObject = this.e.b(this.a);
    if (localObject != null)
    {
      localObject = ((gw)localObject).f;
      if (localObject != null) {
        return "1".equals(((cq)localObject).b);
      }
    }
    return false;
  }
  
  public final boolean h()
  {
    boolean bool = true;
    o localo = this.d;
    if ((localo == null) || (localo.b != 1)) {
      bool = false;
    }
    return bool;
  }
  
  public final boolean i()
  {
    boolean bool2 = false;
    boolean bool3 = true;
    o localo = this.d;
    boolean bool1 = bool2;
    if (localo != null)
    {
      int i = localo.b;
      if (i == 1) {
        break label41;
      }
      bool1 = bool3;
      if (i == 4) {}
    }
    label41:
    for (bool1 = bool2;; bool1 = true) {
      return bool1;
    }
  }
  
  public final boolean j()
  {
    return this.b.h(this.a).a(12603772L);
  }
  
  public final boolean k()
  {
    return this.b.h(this.a).a(12613100L);
  }
  
  public final boolean l()
  {
    boolean bool = true;
    j localj = this.c;
    if ((localj == null) || (localj.b != 2) || (localj.c != 1)) {
      bool = false;
    }
    return bool;
  }
  
  public final boolean m()
  {
    if (this.c != null) {
      return ((Long)com.google.android.finsky.ag.c.am.b(this.a).a()).longValue() >= this.c.d;
    }
    return true;
  }
  
  public final boolean n()
  {
    return (this.c != null) && (l()) && (!m());
  }
  
  public final void o()
  {
    if (this.c == null)
    {
      FinskyLog.e("No family info while dismissing paused edu card.", new Object[0]);
      return;
    }
    com.google.android.finsky.ag.c.am.b(this.a).a(Long.valueOf(this.c.d));
  }
  
  public final String p()
  {
    Object localObject = this.c;
    if (localObject == null) {}
    for (localObject = "Null familyInfo";; localObject = ((StringBuilder)localObject).toString())
    {
      boolean bool1 = g();
      boolean bool2 = j();
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject).length() + 49);
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("\nTos Accepted: ");
      localStringBuilder.append(bool1);
      localStringBuilder.append("\nOnboarding Experiment: ");
      localStringBuilder.append(bool2);
      return localStringBuilder.toString();
      int i = ((j)localObject).b;
      int j = ((j)localObject).c;
      localObject = new StringBuilder(55);
      ((StringBuilder)localObject).append("Family status: ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("\nInactive Reason: ");
      ((StringBuilder)localObject).append(j);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bq/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */