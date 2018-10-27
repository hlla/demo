package com.google.android.finsky.e;

import android.text.TextUtils;
import com.google.wireless.android.a.b.a.a.ac;
import com.google.wireless.android.a.b.a.a.ad;
import com.google.wireless.android.a.b.a.a.ag;
import com.google.wireless.android.a.b.a.a.ak;
import com.google.wireless.android.a.b.a.a.ap;
import com.google.wireless.android.a.b.a.a.at;
import com.google.wireless.android.a.b.a.a.ax;
import com.google.wireless.android.a.b.a.a.bc;
import com.google.wireless.android.a.b.a.a.bg;
import com.google.wireless.android.a.b.a.a.bq;
import com.google.wireless.android.a.b.a.a.bs;
import com.google.wireless.android.a.b.a.a.bz;
import com.google.wireless.android.a.b.a.a.cc;
import com.google.wireless.android.a.b.a.a.ce;
import com.google.wireless.android.a.b.a.a.ci;
import com.google.wireless.android.a.b.a.a.f;
import com.google.wireless.android.a.b.a.a.g;
import com.google.wireless.android.a.b.a.a.n;
import com.google.wireless.android.a.b.a.a.o;
import com.google.wireless.android.a.b.a.a.p;
import com.google.wireless.android.a.b.a.a.r;
import com.google.wireless.android.a.b.a.a.s;
import com.google.wireless.android.a.b.a.a.v;
import com.google.wireless.android.a.b.a.a.y;
import com.google.wireless.android.a.b.a.a.z;
import java.io.PrintWriter;
import java.io.StringWriter;

public final class d
{
  public final bg a = u.c();
  
  public d(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  @Deprecated
  public final d a(int paramInt)
  {
    if (paramInt != 0) {
      this.a.b(paramInt);
    }
    return this;
  }
  
  public final d a(int paramInt1, int paramInt2)
  {
    g(paramInt1);
    if ((!((Boolean)com.google.android.finsky.ag.d.ji.b()).booleanValue()) && (paramInt2 != 0))
    {
      bg localbg = this.a;
      localbg.l |= 0x2000000;
      localbg.I = paramInt2;
    }
    return this;
  }
  
  public final d a(long paramLong)
  {
    if (paramLong >= 0L)
    {
      bg localbg = this.a;
      localbg.l |= 0x200;
      localbg.at = paramLong;
    }
    return this;
  }
  
  public final d a(long paramLong1, long paramLong2)
  {
    ak localak = new ak();
    localak.b |= 0x1;
    localak.c = paramLong1;
    localak.b |= 0x2;
    localak.a = paramLong2;
    this.a.R = localak;
    return this;
  }
  
  public final d a(com.google.android.finsky.ds.a.bp parambp)
  {
    this.a.z = parambp;
    return this;
  }
  
  public final d a(ac paramac)
  {
    this.a.B = paramac;
    return this;
  }
  
  public final d a(ad paramad)
  {
    this.a.C = paramad;
    return this;
  }
  
  public final d a(ag paramag)
  {
    this.a.K = paramag;
    return this;
  }
  
  public final d a(ap paramap)
  {
    this.a.W = paramap;
    return this;
  }
  
  public final d a(at paramat)
  {
    if (paramat != null) {
      this.a.ad = paramat;
    }
    return this;
  }
  
  public final d a(ax paramax)
  {
    this.a.ag = paramax;
    return this;
  }
  
  public final d a(bc parambc)
  {
    this.a.N = parambc;
    return this;
  }
  
  public final d a(com.google.wireless.android.a.b.a.a.bp parambp)
  {
    this.a.ao = parambp;
    return this;
  }
  
  public final d a(bs parambs)
  {
    this.a.av = parambs;
    return this;
  }
  
  public final d a(bz parambz)
  {
    this.a.am = parambz;
    return this;
  }
  
  public final d a(cc paramcc)
  {
    this.a.as = paramcc;
    return this;
  }
  
  public final d a(ce paramce)
  {
    this.a.ay = paramce;
    return this;
  }
  
  public final d a(ci paramci)
  {
    this.a.aG = paramci;
    return this;
  }
  
  public final d a(f paramf)
  {
    this.a.b = paramf;
    return this;
  }
  
  public final d a(g paramg)
  {
    this.a.d = paramg;
    return this;
  }
  
  public final d a(n paramn)
  {
    this.a.i = paramn;
    return this;
  }
  
  public final d a(o paramo)
  {
    this.a.j = paramo;
    return this;
  }
  
  public final d a(r paramr)
  {
    this.a.n = paramr;
    return this;
  }
  
  public final d a(s params)
  {
    this.a.o = params;
    return this;
  }
  
  public final d a(v paramv)
  {
    this.a.v = paramv;
    return this;
  }
  
  public final d a(y paramy)
  {
    this.a.x = paramy;
    return this;
  }
  
  public final d a(z paramz)
  {
    this.a.y = paramz;
    return this;
  }
  
  public final d a(Integer paramInteger)
  {
    if (paramInteger != null)
    {
      bg localbg = this.a;
      int i = paramInteger.intValue();
      localbg.l |= 0x80;
      localbg.L = i;
    }
    return this;
  }
  
  public final d a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.a(paramString);
    }
    return this;
  }
  
  public final d a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    bq localbq = new bq();
    if (paramString1 != null)
    {
      localbq.a |= 0x1;
      localbq.d = paramString1;
      if (paramString2 != null)
      {
        if (paramString2 != null)
        {
          localbq.a |= 0x2;
          localbq.c = paramString2;
        }
      }
      else
      {
        localbq.e = paramInt1;
        localbq.a |= 0x8;
        localbq.a |= 0x10;
        localbq.b = paramInt2;
        this.a.ar = localbq;
        return this;
      }
    }
    else
    {
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public final d a(Throwable paramThrowable)
  {
    if (paramThrowable != null) {
      this.a.c(paramThrowable.getClass().getSimpleName());
    }
    return this;
  }
  
  @Deprecated
  public final d a(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
    return this;
  }
  
  public final d a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      bg localbg = this.a;
      if (paramArrayOfByte != null)
      {
        localbg.l |= 0x20;
        localbg.au = paramArrayOfByte;
      }
    }
    else
    {
      return this;
    }
    throw new NullPointerException();
  }
  
  public final d b(int paramInt)
  {
    if (paramInt != 0)
    {
      bg localbg = this.a;
      localbg.l |= 0x40;
      localbg.ac = paramInt;
    }
    return this;
  }
  
  public final d b(long paramLong)
  {
    if (paramLong >= 0L) {
      this.a.a(paramLong);
    }
    return this;
  }
  
  public final d b(Integer paramInteger)
  {
    if (paramInteger != null)
    {
      bg localbg = this.a;
      int i = paramInteger.intValue();
      localbg.l |= 0x100;
      localbg.aD = i;
    }
    return this;
  }
  
  @Deprecated
  public final d b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.b(paramString);
    }
    return this;
  }
  
  public final d b(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    com.google.e.a.a.a.a.a.a(paramThrowable, new PrintWriter(localStringWriter));
    return f(localStringWriter.getBuffer().toString());
  }
  
  public final d b(boolean paramBoolean)
  {
    bg localbg = this.a;
    localbg.l |= 0x4000;
    localbg.ab = paramBoolean;
    return this;
  }
  
  public final d c(int paramInt)
  {
    if (paramInt >= 0)
    {
      bg localbg = this.a;
      localbg.l |= 0x2000;
      localbg.g = paramInt;
    }
    return this;
  }
  
  public final d c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      bg localbg = this.a;
      if (paramString != null)
      {
        localbg.l |= 0x8000;
        localbg.p = paramString;
      }
    }
    else
    {
      return this;
    }
    throw new NullPointerException();
  }
  
  public final d d(int paramInt)
  {
    Object localObject = this.a;
    if (((bg)localObject).k == null) {
      ((bg)localObject).k = new p();
    }
    localObject = this.a.k;
    ((p)localObject).a |= 0x1;
    ((p)localObject).b = paramInt;
    return this;
  }
  
  public final d d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      bg localbg = this.a;
      if (paramString != null)
      {
        localbg.l |= 0x10000;
        localbg.V = paramString;
      }
    }
    else
    {
      return this;
    }
    throw new NullPointerException();
  }
  
  public final d e(int paramInt)
  {
    bg localbg = this.a;
    localbg.ae = paramInt;
    localbg.l |= 0x80000;
    return this;
  }
  
  public final d e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      bg localbg = this.a;
      if (paramString != null)
      {
        localbg.l |= 0x20000;
        localbg.H = paramString;
      }
    }
    else
    {
      return this;
    }
    throw new NullPointerException();
  }
  
  public final d f(int paramInt)
  {
    bg localbg = this.a;
    localbg.t = paramInt;
    localbg.l |= 0x200000;
    return this;
  }
  
  public final d f(String paramString)
  {
    bg localbg = this.a;
    paramString = paramString.substring(0, Math.min(paramString.length(), ((Integer)com.google.android.finsky.ag.d.aZ.b()).intValue()));
    if (paramString == null) {
      throw new NullPointerException();
    }
    localbg.l |= 0x100000;
    localbg.E = paramString;
    return this;
  }
  
  public final d g(int paramInt)
  {
    if ((!((Boolean)com.google.android.finsky.ag.d.ji.b()).booleanValue()) && (paramInt != 0))
    {
      bg localbg = this.a;
      localbg.ax = paramInt;
      localbg.l |= 0x1000000;
    }
    return this;
  }
  
  public final d h(int paramInt)
  {
    bg localbg = this.a;
    localbg.P = paramInt;
    localbg.l |= 0x8000000;
    return this;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */