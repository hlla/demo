package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;
import com.google.wireless.android.finsky.dfe.s.a.l;

public final class nl
  extends b
{
  private static volatile nl[] h;
  public String a = "";
  public long b;
  public String c;
  public String d;
  public bu e;
  public fb f;
  public String g;
  private int i = 0;
  private bu j;
  private Integer k;
  private String l = "";
  
  public nl()
  {
    if (l.a != null) {}
    for (Integer localInteger = Integer.valueOf(l.a.b);; localInteger = null)
    {
      this.k = localInteger;
      this.b = 0L;
      this.f = null;
      this.e = null;
      this.j = null;
      this.d = "";
      this.c = "";
      this.g = "";
      this.unknownFieldData = null;
      this.cachedSize = -1;
      return;
    }
  }
  
  public static nl[] b()
  {
    if (h == null) {}
    synchronized (f.a)
    {
      if (h == null) {
        h = new nl[0];
      }
      return h;
    }
  }
  
  protected final int a()
  {
    int n = super.a();
    int m = n;
    if ((this.i & 0x1) != 0) {
      m = n + CodedOutputByteBufferNano.b(1, this.a);
    }
    n = m;
    if ((this.i & 0x2) != 0) {
      n = m + CodedOutputByteBufferNano.b(2, this.l);
    }
    m = n;
    if ((this.i & 0x4) != 0)
    {
      localObject = this.k;
      m = n;
      if (localObject != null) {
        m = n + CodedOutputByteBufferNano.d(3, ((Integer)localObject).intValue());
      }
    }
    n = m;
    if ((this.i & 0x8) != 0) {
      n = m + CodedOutputByteBufferNano.f(4, this.b);
    }
    Object localObject = this.f;
    m = n;
    if (localObject != null) {
      m = n + CodedOutputByteBufferNano.d(5, (g)localObject);
    }
    localObject = this.e;
    n = m;
    if (localObject != null) {
      n = m + CodedOutputByteBufferNano.d(6, (g)localObject);
    }
    localObject = this.j;
    m = n;
    if (localObject != null) {
      m = n + CodedOutputByteBufferNano.d(7, (g)localObject);
    }
    n = m;
    if ((this.i & 0x10) != 0) {
      n = m + CodedOutputByteBufferNano.b(8, this.d);
    }
    m = n;
    if ((this.i & 0x20) != 0) {
      m = n + CodedOutputByteBufferNano.b(9, this.c);
    }
    n = m;
    if ((this.i & 0x40) != 0) {
      n = m + CodedOutputByteBufferNano.b(10, this.g);
    }
    return n;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.i & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.a);
    }
    if ((this.i & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.l);
    }
    if ((this.i & 0x4) != 0)
    {
      localObject = this.k;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.a(3, ((Integer)localObject).intValue());
      }
    }
    if ((this.i & 0x8) != 0) {
      paramCodedOutputByteBufferNano.b(4, this.b);
    }
    Object localObject = this.f;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(5, (g)localObject);
    }
    localObject = this.e;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(6, (g)localObject);
    }
    localObject = this.j;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(7, (g)localObject);
    }
    if ((this.i & 0x10) != 0) {
      paramCodedOutputByteBufferNano.a(8, this.d);
    }
    if ((this.i & 0x20) != 0) {
      paramCodedOutputByteBufferNano.a(9, this.c);
    }
    if ((this.i & 0x40) != 0) {
      paramCodedOutputByteBufferNano.a(10, this.g);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean c()
  {
    return (this.i & 0x8) != 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof nl))
      {
        paramObject = (nl)paramObject;
        if (((this.i & 0x1) == (((nl)paramObject).i & 0x1)) && (this.a.equals(((nl)paramObject).a)) && ((this.i & 0x2) == (((nl)paramObject).i & 0x2)) && (this.l.equals(((nl)paramObject).l)))
        {
          int m = this.i;
          int n = ((nl)paramObject).i;
          if (((m & 0x4) == (n & 0x4)) && (this.k == ((nl)paramObject).k) && ((m & 0x8) == (n & 0x8)) && (this.b == ((nl)paramObject).b))
          {
            localObject = this.f;
            if (localObject != null) {
              break label354;
            }
            if (((nl)paramObject).f != null) {}
          }
        }
      }
      label354:
      while (((fb)localObject).equals(((nl)paramObject).f))
      {
        localObject = this.e;
        if (localObject == null) {
          if (((nl)paramObject).e != null) {}
        }
        while (((bu)localObject).equals(((nl)paramObject).e))
        {
          localObject = this.j;
          if (localObject == null) {
            if (((nl)paramObject).j != null) {}
          }
          while (((bu)localObject).equals(((nl)paramObject).j))
          {
            if (((this.i & 0x10) == (((nl)paramObject).i & 0x10)) && (this.d.equals(((nl)paramObject).d)) && ((this.i & 0x20) == (((nl)paramObject).i & 0x20)) && (this.c.equals(((nl)paramObject).c)) && ((this.i & 0x40) == (((nl)paramObject).i & 0x40)) && (this.g.equals(((nl)paramObject).g)))
            {
              localObject = this.unknownFieldData;
              if ((localObject == null) || (((d)localObject).a())) {
                paramObject = ((nl)paramObject).unknownFieldData;
              }
            }
            else
            {
              return (paramObject == null) || (((d)paramObject).a());
            }
            return this.unknownFieldData.equals(((nl)paramObject).unknownFieldData);
          }
          return false;
        }
        return false;
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int i4 = 0;
    int n = ((getClass().getName().hashCode() + 527) * 31 + this.a.hashCode()) * 31 + this.l.hashCode();
    Object localObject = this.k;
    int m = n;
    if (localObject != null) {
      m = n * 31 + ((Integer)localObject).intValue();
    }
    long l1 = this.b;
    localObject = this.f;
    int i5 = (int)(l1 ^ l1 >>> 32);
    if (localObject != null) {}
    for (n = ((fb)localObject).hashCode();; n = 0)
    {
      localObject = this.e;
      if (localObject != null) {}
      for (int i1 = ((bu)localObject).hashCode();; i1 = 0)
      {
        localObject = this.j;
        if (localObject != null) {}
        for (int i2 = ((bu)localObject).hashCode();; i2 = 0)
        {
          int i6 = this.d.hashCode();
          int i7 = this.c.hashCode();
          int i8 = this.g.hashCode();
          localObject = this.unknownFieldData;
          int i3 = i4;
          if (localObject != null)
          {
            i3 = i4;
            if (!((d)localObject).a()) {
              i3 = this.unknownFieldData.hashCode();
            }
          }
          return ((((i2 + (i1 + (n + (m * 31 + i5) * 31) * 31) * 31) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i3;
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/nl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */