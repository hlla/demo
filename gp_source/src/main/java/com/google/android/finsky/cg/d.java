package com.google.android.finsky.cg;

import com.google.android.finsky.ds.a.o;
import com.google.android.finsky.utils.FinskyLog;
import com.google.wireless.android.finsky.b.a;

@Deprecated
public final class d
{
  public final c a;
  
  public d(String paramString)
  {
    this.a = new c(paramString);
  }
  
  public static d a(c paramc, String paramString)
  {
    d locald = new d(paramString);
    if (paramc != null)
    {
      if (!paramString.equals(paramc.F)) {
        FinskyLog.e("Package name mismatch,  %s != %s", new Object[] { paramString, paramc.F });
      }
      locald.a(paramc.f);
      locald.b(paramc.n);
      locald.c(paramc.m);
      locald.d(paramc.A);
      locald.a(paramc.i, paramc.j);
      locald.e(paramc.y);
      locald.a(paramc.o);
      locald.a(paramc.r);
      locald.b(paramc.p);
      locald.e(paramc.h);
      locald.c(paramc.b);
      locald.d(paramc.L);
      locald.f(paramc.s);
      long l = paramc.B;
      locald.a.B = l;
      locald.f(paramc.a);
      locald.b(paramc.q);
      locald.g(paramc.H);
      locald.h(paramc.G);
      locald.g(paramc.k);
      locald.a(paramc.a());
      locald.h(paramc.d);
      locald.i(paramc.I);
      locald.a(paramc.D);
      locald.c(paramc.M);
      locald.a(paramc.e);
      locald.d(paramc.t);
      locald.e(paramc.z);
      locald.j(paramc.K);
      l = paramc.N;
      locald.a.N = l;
      paramString = paramc.d();
      locald.a.u = paramString;
      paramString = paramc.e();
      locald.a.C = paramString;
      locald.f(paramc.x);
      locald.k(paramc.v);
      locald.i(paramc.l);
      paramString = paramc.E;
      locald.a.E = paramString;
      locald.b(paramc.J);
      locald.a(paramc.w);
      locald.j(paramc.c);
    }
    return locald;
  }
  
  public final d a(int paramInt)
  {
    this.a.f = paramInt;
    return this;
  }
  
  public final d a(long paramLong)
  {
    this.a.r = paramLong;
    return this;
  }
  
  public final d a(o paramo)
  {
    this.a.e = paramo;
    return this;
  }
  
  public final d a(com.google.android.finsky.installer.b.a.d paramd)
  {
    this.a.w = paramd;
    return this;
  }
  
  public final d a(a parama, long paramLong)
  {
    c localc = this.a;
    localc.i = parama;
    localc.j = paramLong;
    return this;
  }
  
  public final d a(String paramString)
  {
    this.a.o = paramString;
    return this;
  }
  
  public final d a(byte[] paramArrayOfByte)
  {
    this.a.D = paramArrayOfByte;
    return this;
  }
  
  public final d a(String[] paramArrayOfString)
  {
    this.a.g = paramArrayOfString;
    return this;
  }
  
  public final d b(int paramInt)
  {
    this.a.n = paramInt;
    return this;
  }
  
  public final d b(long paramLong)
  {
    this.a.q = paramLong;
    return this;
  }
  
  public final d b(String paramString)
  {
    this.a.p = paramString;
    return this;
  }
  
  public final d b(String[] paramArrayOfString)
  {
    this.a.J = paramArrayOfString;
    return this;
  }
  
  public final d c(int paramInt)
  {
    this.a.m = paramInt;
    return this;
  }
  
  public final d c(long paramLong)
  {
    this.a.M = paramLong;
    return this;
  }
  
  public final d c(String paramString)
  {
    this.a.b = paramString;
    return this;
  }
  
  public final d d(int paramInt)
  {
    this.a.A = paramInt;
    return this;
  }
  
  public final d d(long paramLong)
  {
    this.a.t = paramLong;
    return this;
  }
  
  public final d d(String paramString)
  {
    this.a.L = paramString;
    return this;
  }
  
  public final d e(int paramInt)
  {
    this.a.y = paramInt;
    return this;
  }
  
  public final d e(long paramLong)
  {
    this.a.z = paramLong;
    return this;
  }
  
  public final d e(String paramString)
  {
    this.a.h = paramString;
    return this;
  }
  
  public final d f(int paramInt)
  {
    this.a.s = paramInt;
    return this;
  }
  
  public final d f(long paramLong)
  {
    this.a.x = paramLong;
    return this;
  }
  
  public final d f(String paramString)
  {
    this.a.a = paramString;
    return this;
  }
  
  public final d g(int paramInt)
  {
    this.a.H = paramInt;
    return this;
  }
  
  public final d g(String paramString)
  {
    this.a.k = paramString;
    return this;
  }
  
  public final d h(int paramInt)
  {
    this.a.G = paramInt;
    return this;
  }
  
  public final d h(String paramString)
  {
    this.a.d = paramString;
    return this;
  }
  
  public final d i(int paramInt)
  {
    this.a.l = paramInt;
    return this;
  }
  
  public final d i(String paramString)
  {
    this.a.I = paramString;
    return this;
  }
  
  public final d j(int paramInt)
  {
    this.a.c = paramInt;
    return this;
  }
  
  public final d j(String paramString)
  {
    this.a.K = paramString;
    return this;
  }
  
  public final d k(String paramString)
  {
    this.a.v = paramString;
    return this;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cg/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */