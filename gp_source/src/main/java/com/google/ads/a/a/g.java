package com.google.ads.a.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.f;

public final class g
  extends b
{
  private static volatile g[] t;
  public Long a = null;
  public Long b = null;
  public Integer c;
  public Integer d;
  public Long e = null;
  public Long f = null;
  public Long g = null;
  public Long h = null;
  public Long i = null;
  public Long j = null;
  public Long k = null;
  public Long l = null;
  public Long m = null;
  public Long n = null;
  public Long o = null;
  public Long p = null;
  public Long q = null;
  public Long r = null;
  public Long s = null;
  private Long u = null;
  private Long v = null;
  
  public g()
  {
    this.cachedSize = -1;
  }
  
  private final g b(a parama)
  {
    for (;;)
    {
      int i1 = parama.a();
      int i2;
      switch (i1)
      {
      default: 
        if (super.a(parama, i1)) {}
        break;
      case 0: 
        return this;
      case 168: 
        this.v = Long.valueOf(parama.f());
        break;
      case 160: 
        this.u = Long.valueOf(parama.f());
        break;
      case 152: 
        this.m = Long.valueOf(parama.f());
        break;
      case 144: 
        this.k = Long.valueOf(parama.f());
        break;
      case 136: 
        this.q = Long.valueOf(parama.f());
        break;
      case 128: 
        this.p = Long.valueOf(parama.f());
        break;
      case 120: 
        this.s = Long.valueOf(parama.f());
        break;
      case 112: 
        this.r = Long.valueOf(parama.f());
        break;
      case 104: 
        this.e = Long.valueOf(parama.f());
        break;
      case 96: 
        this.g = Long.valueOf(parama.f());
        break;
      case 88: 
        i2 = parama.j();
        try
        {
          this.c = Integer.valueOf(e.a(parama.e()));
        }
        catch (IllegalArgumentException localIllegalArgumentException1)
        {
          parama.e(i2);
          a(parama, i1);
        }
        break;
      case 80: 
        this.f = Long.valueOf(parama.f());
        break;
      case 72: 
        this.o = Long.valueOf(parama.f());
        break;
      case 64: 
        this.j = Long.valueOf(parama.f());
        break;
      case 56: 
        i2 = parama.j();
        try
        {
          this.d = Integer.valueOf(e.a(parama.e()));
        }
        catch (IllegalArgumentException localIllegalArgumentException2)
        {
          parama.e(i2);
          a(parama, i1);
        }
        break;
      case 48: 
        this.b = Long.valueOf(parama.f());
        break;
      case 40: 
        this.i = Long.valueOf(parama.f());
        break;
      case 32: 
        this.a = Long.valueOf(parama.f());
        break;
      case 24: 
        this.h = Long.valueOf(parama.f());
        break;
      case 16: 
        this.n = Long.valueOf(parama.f());
        break;
      case 8: 
        this.l = Long.valueOf(parama.f());
      }
    }
  }
  
  public static g[] k_()
  {
    if (t == null) {}
    synchronized (f.a)
    {
      if (t == null) {
        t = new g[0];
      }
      return t;
    }
  }
  
  protected final int a()
  {
    int i2 = super.a();
    Object localObject = this.l;
    int i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.f(1, ((Long)localObject).longValue());
    }
    localObject = this.n;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.f(2, ((Long)localObject).longValue());
    }
    localObject = this.h;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.f(3, ((Long)localObject).longValue());
    }
    localObject = this.a;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.f(4, ((Long)localObject).longValue());
    }
    localObject = this.i;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.f(5, ((Long)localObject).longValue());
    }
    localObject = this.b;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.f(6, ((Long)localObject).longValue());
    }
    localObject = this.d;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(7, ((Integer)localObject).intValue());
    }
    localObject = this.j;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.f(8, ((Long)localObject).longValue());
    }
    localObject = this.o;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.f(9, ((Long)localObject).longValue());
    }
    localObject = this.f;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.f(10, ((Long)localObject).longValue());
    }
    localObject = this.c;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(11, ((Integer)localObject).intValue());
    }
    localObject = this.g;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.f(12, ((Long)localObject).longValue());
    }
    localObject = this.e;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.f(13, ((Long)localObject).longValue());
    }
    localObject = this.r;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.f(14, ((Long)localObject).longValue());
    }
    localObject = this.s;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.f(15, ((Long)localObject).longValue());
    }
    localObject = this.p;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.f(16, ((Long)localObject).longValue());
    }
    localObject = this.q;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.f(17, ((Long)localObject).longValue());
    }
    localObject = this.k;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.f(18, ((Long)localObject).longValue());
    }
    localObject = this.m;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.f(19, ((Long)localObject).longValue());
    }
    localObject = this.u;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.f(20, ((Long)localObject).longValue());
    }
    localObject = this.v;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.f(21, ((Long)localObject).longValue());
    }
    return i1;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.l;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(1, ((Long)localObject).longValue());
    }
    localObject = this.n;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(2, ((Long)localObject).longValue());
    }
    localObject = this.h;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(3, ((Long)localObject).longValue());
    }
    localObject = this.a;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(4, ((Long)localObject).longValue());
    }
    localObject = this.i;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(5, ((Long)localObject).longValue());
    }
    localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(6, ((Long)localObject).longValue());
    }
    localObject = this.d;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.a(7, ((Integer)localObject).intValue());
    }
    localObject = this.j;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(8, ((Long)localObject).longValue());
    }
    localObject = this.o;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(9, ((Long)localObject).longValue());
    }
    localObject = this.f;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(10, ((Long)localObject).longValue());
    }
    localObject = this.c;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.a(11, ((Integer)localObject).intValue());
    }
    localObject = this.g;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(12, ((Long)localObject).longValue());
    }
    localObject = this.e;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(13, ((Long)localObject).longValue());
    }
    localObject = this.r;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(14, ((Long)localObject).longValue());
    }
    localObject = this.s;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(15, ((Long)localObject).longValue());
    }
    localObject = this.p;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(16, ((Long)localObject).longValue());
    }
    localObject = this.q;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(17, ((Long)localObject).longValue());
    }
    localObject = this.k;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(18, ((Long)localObject).longValue());
    }
    localObject = this.m;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(19, ((Long)localObject).longValue());
    }
    localObject = this.u;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(20, ((Long)localObject).longValue());
    }
    localObject = this.v;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(21, ((Long)localObject).longValue());
    }
    super.a(paramCodedOutputByteBufferNano);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/ads/a/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */