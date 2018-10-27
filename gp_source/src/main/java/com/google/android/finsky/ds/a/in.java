package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;

public final class in
  extends b
{
  public String a = "";
  public fb b = null;
  public String c = "";
  public boolean d = false;
  public il e = null;
  public io[] f = io.b();
  public il g = null;
  public String h = "";
  private r i = null;
  private int j = 0;
  
  public in()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int m = super.a();
    int k = m;
    if ((this.j & 0x4) != 0) {
      k = m + CodedOutputByteBufferNano.b(1, this.c);
    }
    Object localObject = this.b;
    m = k;
    if (localObject != null) {
      m = k + CodedOutputByteBufferNano.d(2, (g)localObject);
    }
    k = m;
    if ((this.j & 0x8) != 0) {
      k = m + CodedOutputByteBufferNano.b(3, this.a);
    }
    localObject = this.f;
    m = k;
    if (localObject != null)
    {
      m = k;
      if (localObject.length > 0)
      {
        m = 0;
        for (;;)
        {
          localObject = this.f;
          if (m >= localObject.length) {
            break;
          }
          localObject = localObject[m];
          int n = k;
          if (localObject != null) {
            n = k + CodedOutputByteBufferNano.d(4, (g)localObject);
          }
          m += 1;
          k = n;
        }
        m = k;
      }
    }
    k = m;
    if ((this.j & 0x1) != 0) {
      k = m + CodedOutputByteBufferNano.b(5, this.h);
    }
    localObject = this.e;
    m = k;
    if (localObject != null) {
      m = k + CodedOutputByteBufferNano.d(6, (g)localObject);
    }
    localObject = this.g;
    k = m;
    if (localObject != null) {
      k = m + CodedOutputByteBufferNano.d(7, (g)localObject);
    }
    m = k;
    if ((this.j & 0x2) != 0) {
      m = k + (CodedOutputByteBufferNano.d(64) + 1);
    }
    localObject = this.i;
    k = m;
    if (localObject != null) {
      k = m + CodedOutputByteBufferNano.d(9, (g)localObject);
    }
    return k;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.j & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.c);
    }
    Object localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(2, (g)localObject);
    }
    if ((this.j & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.a);
    }
    localObject = this.f;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int k;
    do
    {
      if ((this.j & 0x1) != 0) {
        paramCodedOutputByteBufferNano.a(5, this.h);
      }
      localObject = this.e;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.b(6, (g)localObject);
      }
      localObject = this.g;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.b(7, (g)localObject);
      }
      if ((this.j & 0x2) != 0) {
        paramCodedOutputByteBufferNano.a(8, this.d);
      }
      localObject = this.i;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.b(9, (g)localObject);
      }
      super.a(paramCodedOutputByteBufferNano);
      return;
      k = 0;
      localObject = this.f;
    } while (k >= localObject.length);
    localObject = localObject[k];
    if (localObject == null) {}
    for (;;)
    {
      k += 1;
      break;
      paramCodedOutputByteBufferNano.b(4, (g)localObject);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof in))
      {
        paramObject = (in)paramObject;
        if ((f.a(this.f, ((in)paramObject).f)) && ((this.j & 0x1) == (((in)paramObject).j & 0x1)) && (this.h.equals(((in)paramObject).h)))
        {
          localObject = this.e;
          if (localObject != null) {
            break label297;
          }
          if (((in)paramObject).e != null) {}
        }
      }
      label258:
      label271:
      label297:
      while (((il)localObject).equals(((in)paramObject).e))
      {
        localObject = this.g;
        if (localObject == null) {
          if (((in)paramObject).g != null) {}
        }
        while (((il)localObject).equals(((in)paramObject).g))
        {
          if (((this.j & 0x2) == (((in)paramObject).j & 0x2)) && (this.d == ((in)paramObject).d))
          {
            localObject = this.i;
            if (localObject != null) {
              break label271;
            }
            if (((in)paramObject).i != null) {}
          }
          while (((r)localObject).equals(((in)paramObject).i))
          {
            if (((this.j & 0x4) == (((in)paramObject).j & 0x4)) && (this.c.equals(((in)paramObject).c)))
            {
              localObject = this.b;
              if (localObject != null) {
                break label258;
              }
              if (((in)paramObject).b != null) {}
            }
            while (((fb)localObject).equals(((in)paramObject).b))
            {
              if (((this.j & 0x8) == (((in)paramObject).j & 0x8)) && (this.a.equals(((in)paramObject).a)))
              {
                localObject = this.unknownFieldData;
                if ((localObject == null) || (((d)localObject).a())) {
                  paramObject = ((in)paramObject).unknownFieldData;
                }
              }
              else
              {
                return (paramObject == null) || (((d)paramObject).a());
              }
              return this.unknownFieldData.equals(((in)paramObject).unknownFieldData);
            }
            return false;
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
    int i5 = getClass().getName().hashCode();
    int i6 = f.a(this.f);
    int i7 = this.h.hashCode();
    Object localObject = this.e;
    if (localObject != null) {}
    for (int k = ((il)localObject).hashCode();; k = 0)
    {
      localObject = this.g;
      if (localObject != null) {}
      for (int m = ((il)localObject).hashCode();; m = 0)
      {
        if (!this.d) {}
        for (int n = 1237;; n = 1231)
        {
          localObject = this.i;
          if (localObject != null) {}
          for (int i1 = ((r)localObject).hashCode();; i1 = 0)
          {
            int i8 = this.c.hashCode();
            localObject = this.b;
            if (localObject != null) {}
            for (int i2 = ((fb)localObject).hashCode();; i2 = 0)
            {
              int i9 = this.a.hashCode();
              localObject = this.unknownFieldData;
              int i3 = i4;
              if (localObject != null)
              {
                i3 = i4;
                if (!((d)localObject).a()) {
                  i3 = this.unknownFieldData.hashCode();
                }
              }
              return ((i2 + ((i1 + (n + (m + (k + (((i5 + 527) * 31 + i6) * 31 + i7) * 31) * 31) * 31) * 31) * 31 + i8) * 31) * 31 + i9) * 31 + i3;
            }
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/in.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */