package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.g;

public final class lc
  extends b
{
  public am a = null;
  public gl b = null;
  public String c = "";
  public int d = 0;
  private String e = "";
  private int f = 0;
  private ad g = null;
  private boolean h = false;
  private String i = "";
  
  public lc()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int k = super.a();
    int j = k;
    if ((this.f & 0x1) != 0) {
      j = k + CodedOutputByteBufferNano.b(1, this.i);
    }
    Object localObject = this.b;
    k = j;
    if (localObject != null) {
      k = j + CodedOutputByteBufferNano.d(2, (g)localObject);
    }
    j = k;
    if ((this.f & 0x2) != 0) {
      j = k + CodedOutputByteBufferNano.b(3, this.e);
    }
    k = j;
    if ((this.f & 0x4) != 0) {
      k = j + CodedOutputByteBufferNano.d(4, this.d);
    }
    j = k;
    if ((this.f & 0x8) != 0) {
      j = k + CodedOutputByteBufferNano.b(5, this.c);
    }
    localObject = this.g;
    k = j;
    if (localObject != null) {
      k = j + CodedOutputByteBufferNano.d(6, (g)localObject);
    }
    localObject = this.a;
    j = k;
    if (localObject != null) {
      j = k + CodedOutputByteBufferNano.d(7, (g)localObject);
    }
    k = j;
    if ((this.f & 0x10) != 0) {
      k = j + (CodedOutputByteBufferNano.d(64) + 1);
    }
    return k;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.f & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.i);
    }
    Object localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(2, (g)localObject);
    }
    if ((this.f & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.e);
    }
    if ((this.f & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.d);
    }
    if ((this.f & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.c);
    }
    localObject = this.g;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(6, (g)localObject);
    }
    localObject = this.a;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(7, (g)localObject);
    }
    if ((this.f & 0x10) != 0) {
      paramCodedOutputByteBufferNano.a(8, this.h);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean b()
  {
    return (this.f & 0x8) != 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof lc))
      {
        paramObject = (lc)paramObject;
        if (((this.f & 0x1) == (((lc)paramObject).f & 0x1)) && (this.i.equals(((lc)paramObject).i)))
        {
          localObject = this.b;
          if (localObject != null) {
            break label291;
          }
          if (((lc)paramObject).b != null) {}
        }
      }
      label277:
      label291:
      while (((gl)localObject).equals(((lc)paramObject).b))
      {
        if (((this.f & 0x2) == (((lc)paramObject).f & 0x2)) && (this.e.equals(((lc)paramObject).e)))
        {
          int j = this.f;
          int k = ((lc)paramObject).f;
          if (((j & 0x4) == (k & 0x4)) && (this.d == ((lc)paramObject).d) && ((j & 0x8) == (k & 0x8)) && (this.c.equals(((lc)paramObject).c)))
          {
            localObject = this.g;
            if (localObject != null) {
              break label277;
            }
            if (((lc)paramObject).g != null) {}
          }
        }
        while (((ad)localObject).equals(((lc)paramObject).g))
        {
          localObject = this.a;
          if (localObject == null) {
            if (((lc)paramObject).a != null) {}
          }
          while (((am)localObject).equals(((lc)paramObject).a))
          {
            if (((this.f & 0x10) == (((lc)paramObject).f & 0x10)) && (this.h == ((lc)paramObject).h))
            {
              localObject = this.unknownFieldData;
              if ((localObject == null) || (((d)localObject).a())) {
                paramObject = ((lc)paramObject).unknownFieldData;
              }
            }
            else
            {
              return (paramObject == null) || (((d)paramObject).a());
            }
            return this.unknownFieldData.equals(((lc)paramObject).unknownFieldData);
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
    int i2 = 0;
    int i3 = getClass().getName().hashCode();
    int i4 = this.i.hashCode();
    Object localObject = this.b;
    if (localObject != null) {}
    for (int j = ((gl)localObject).hashCode();; j = 0)
    {
      int i5 = this.e.hashCode();
      int i6 = this.d;
      int i7 = this.c.hashCode();
      localObject = this.g;
      if (localObject != null) {}
      for (int k = ((ad)localObject).hashCode();; k = 0)
      {
        localObject = this.a;
        if (localObject != null) {}
        for (int m = ((am)localObject).hashCode();; m = 0)
        {
          if (!this.h) {}
          for (int n = 1237;; n = 1231)
          {
            localObject = this.unknownFieldData;
            int i1 = i2;
            if (localObject != null)
            {
              i1 = i2;
              if (!((d)localObject).a()) {
                i1 = this.unknownFieldData.hashCode();
              }
            }
            return (n + (m + (k + ((((j + ((i3 + 527) * 31 + i4) * 31) * 31 + i5) * 31 + i6) * 31 + i7) * 31) * 31) * 31) * 31 + i1;
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/lc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */