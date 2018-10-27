package com.google.android.finsky.be;

import com.android.volley.VolleyError;
import com.google.android.finsky.e.af;
import com.google.android.finsky.e.aq;
import com.google.android.finsky.e.d;
import com.google.android.finsky.e.f;
import com.google.android.finsky.e.y;
import com.google.android.finsky.e.z;
import com.google.android.play.b.a.p;
import com.google.wireless.android.finsky.dfe.e.a.dn;
import com.google.wireless.android.finsky.dfe.e.a.dr;
import com.google.wireless.android.finsky.dfe.e.a.en;
import com.google.wireless.android.finsky.dfe.e.a.fn;

public abstract class q
{
  public static final aq a = new y(603);
  private static final aq i = new y(213);
  public boolean b;
  public aq c;
  public aq d;
  public final af e;
  public aq f;
  public int g;
  public final int h;
  
  private q(af paramaf, int paramInt, boolean paramBoolean)
  {
    this.e = paramaf;
    this.g = paramInt;
    if (!paramBoolean) {}
    for (paramInt = 600;; paramInt = 605)
    {
      this.h = paramInt;
      return;
    }
  }
  
  public q(af paramaf, int paramInt, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    this(paramaf, paramInt, paramBoolean);
    if (paramArrayOfByte != null)
    {
      b(null);
      ((y)this.f).a(paramArrayOfByte);
    }
  }
  
  public static p b(dr paramdr)
  {
    Object localObject = paramdr.h;
    if ((localObject != null) && (localObject.length != 0))
    {
      localObject = com.google.android.play.b.q.a().b();
      ((p)localObject).d = paramdr.h;
      return (p)localObject;
    }
    return null;
  }
  
  public final aq a(dn paramdn)
  {
    if (this.f == null) {
      this.f = b(paramdn);
    }
    return this.f;
  }
  
  public final aq a(dr paramdr, en paramen)
  {
    if ((!this.b) && (paramdr != null) && ((paramdr.b & 0x1) != 0))
    {
      paramdr = new y(paramdr.f, paramdr.g, null);
      if ((paramen == null) || (paramen.D.length == 0))
      {
        this.c.a(paramdr);
        g();
      }
      return paramdr;
    }
    return null;
  }
  
  public final void a(int paramInt, VolleyError paramVolleyError, long paramLong1, long paramLong2)
  {
    paramVolleyError = d(paramInt).a(paramVolleyError).a(paramLong1).b(paramLong2);
    this.e.a(paramVolleyError.a, null);
  }
  
  public final void a(int paramInt, fn paramfn, long paramLong1, long paramLong2)
  {
    paramfn = d(paramInt).a(paramfn.b).a(paramfn.c).a(paramLong1).b(paramLong2);
    this.e.a(paramfn.a, null);
  }
  
  public final void a(aq paramaq)
  {
    if ((!this.b) && (paramaq != null))
    {
      this.c.a(paramaq);
      g();
    }
  }
  
  public abstract void a(aq paramaq, dn paramdn);
  
  public final void a(dr paramdr)
  {
    if ((paramdr.b & 0x1) != 0) {
      if (!paramdr.e) {
        break label61;
      }
    }
    label61:
    for (Object localObject = this.f;; localObject = this.c)
    {
      localObject = new f((aq)localObject).a(paramdr.f).a(paramdr.g);
      this.e.a(((f)localObject).a(), b(paramdr));
      return;
    }
  }
  
  public final aq b(dn paramdn)
  {
    this.f = new y(this.g);
    a(this.f, paramdn);
    return this.f;
  }
  
  public abstract d d(int paramInt);
  
  public final void e(int paramInt)
  {
    this.e.a(d(paramInt).a, null);
  }
  
  public final void g()
  {
    if (!this.b)
    {
      aq localaq2 = this.c.getParentNode();
      aq localaq1 = localaq2;
      if (localaq2 == null) {
        localaq1 = this.c;
      }
      this.e.a(new z().a(localaq1).a(), null);
      this.c = this.d;
    }
  }
  
  public final void h()
  {
    y localy = new y(this.g);
    localy.a(i);
    this.e.a(new z().a(localy).a(), null);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/be/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */