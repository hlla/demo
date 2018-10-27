package com.google.android.finsky.da.a;

import android.accounts.Account;
import com.google.android.finsky.accounts.a;
import com.google.android.finsky.accounts.b;
import com.google.android.finsky.ag.p;
import com.google.android.finsky.ag.q;
import com.google.android.finsky.da.f;
import java.util.HashSet;
import java.util.Set;

public final class ad
  implements b, com.google.android.finsky.da.e, com.google.android.finsky.notification.c
{
  private final Set a = new HashSet();
  private String b;
  
  public ad(com.google.android.finsky.accounts.c paramc, a parama)
  {
    this.b = paramc.cS();
    parama.a(this);
  }
  
  private final void b()
  {
    int j = a();
    Object localObject = this.a;
    localObject = (f[])((Set)localObject).toArray(new f[((Set)localObject).size()]);
    int k = localObject.length;
    int i = 0;
    while (i < k)
    {
      localObject[i].a(j);
      i += 1;
    }
  }
  
  public final int a()
  {
    String str = this.b;
    return ((Integer)com.google.android.finsky.ag.c.w.b(str).a()).intValue();
  }
  
  public final void a(Account paramAccount)
  {
    if (paramAccount != null)
    {
      int i = a();
      this.b = paramAccount.name;
      if (i != a()) {
        b();
      }
    }
  }
  
  public final void a(f paramf)
  {
    this.a.add(paramf);
  }
  
  public final boolean a(com.google.wireless.android.finsky.dfe.n.a.e parame, String paramString)
  {
    if ((parame.a & 0x1) != 0)
    {
      int i = ((Integer)com.google.android.finsky.ag.c.w.b(paramString).a()).intValue();
      int j = parame.b;
      if (i != j)
      {
        com.google.android.finsky.ag.c.w.b(paramString).a(Integer.valueOf(j));
        if (paramString.equals(this.b)) {
          b();
        }
      }
      return true;
    }
    return false;
  }
  
  public final void b(f paramf)
  {
    this.a.remove(paramf);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/da/a/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */