package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;
import com.google.wireless.android.finsky.dfe.q.fm;

public final class lk
  extends b
{
  private static volatile lk[] a;
  private String b;
  private int c = 0;
  private aw d;
  private fb e;
  private fu f;
  private ig g;
  private iz h;
  private Integer i;
  
  public lk()
  {
    if (fm.a != null) {}
    for (Integer localInteger = Integer.valueOf(fm.a.b);; localInteger = null)
    {
      this.i = localInteger;
      this.b = "";
      this.e = null;
      this.d = null;
      this.h = null;
      this.f = null;
      this.g = null;
      this.unknownFieldData = null;
      this.cachedSize = -1;
      return;
    }
  }
  
  public static lk[] b()
  {
    if (a == null) {}
    synchronized (f.a)
    {
      if (a == null) {
        a = new lk[0];
      }
      return a;
    }
  }
  
  protected final int a()
  {
    int k = super.a();
    int j = k;
    if ((this.c & 0x1) != 0)
    {
      localObject = this.i;
      j = k;
      if (localObject != null) {
        j = k + CodedOutputByteBufferNano.d(1, ((Integer)localObject).intValue());
      }
    }
    k = j;
    if ((this.c & 0x2) != 0) {
      k = j + CodedOutputByteBufferNano.b(2, this.b);
    }
    Object localObject = this.e;
    j = k;
    if (localObject != null) {
      j = k + CodedOutputByteBufferNano.d(3, (g)localObject);
    }
    localObject = this.d;
    k = j;
    if (localObject != null) {
      k = j + CodedOutputByteBufferNano.d(4, (g)localObject);
    }
    localObject = this.h;
    j = k;
    if (localObject != null) {
      j = k + CodedOutputByteBufferNano.d(5, (g)localObject);
    }
    localObject = this.f;
    k = j;
    if (localObject != null) {
      k = j + CodedOutputByteBufferNano.d(6, (g)localObject);
    }
    localObject = this.g;
    j = k;
    if (localObject != null) {
      j = k + CodedOutputByteBufferNano.d(7, (g)localObject);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.c & 0x1) != 0)
    {
      localObject = this.i;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.a(1, ((Integer)localObject).intValue());
      }
    }
    if ((this.c & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.b);
    }
    Object localObject = this.e;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(3, (g)localObject);
    }
    localObject = this.d;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(4, (g)localObject);
    }
    localObject = this.h;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(5, (g)localObject);
    }
    localObject = this.f;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(6, (g)localObject);
    }
    localObject = this.g;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(7, (g)localObject);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof lk))
      {
        paramObject = (lk)paramObject;
        int j = this.c;
        int k = ((lk)paramObject).c;
        if (((j & 0x1) == (k & 0x1)) && (this.i == ((lk)paramObject).i) && ((j & 0x2) == (k & 0x2)) && (this.b.equals(((lk)paramObject).b)))
        {
          localObject = this.e;
          if (localObject != null) {
            break label267;
          }
          if (((lk)paramObject).e != null) {}
        }
      }
      label267:
      while (((fb)localObject).equals(((lk)paramObject).e))
      {
        localObject = this.d;
        if (localObject == null) {
          if (((lk)paramObject).d != null) {}
        }
        while (((aw)localObject).equals(((lk)paramObject).d))
        {
          localObject = this.h;
          if (localObject == null) {
            if (((lk)paramObject).h != null) {}
          }
          while (((iz)localObject).equals(((lk)paramObject).h))
          {
            localObject = this.f;
            if (localObject == null) {
              if (((lk)paramObject).f != null) {}
            }
            while (((fu)localObject).equals(((lk)paramObject).f))
            {
              localObject = this.g;
              if (localObject == null) {
                if (((lk)paramObject).g != null) {}
              }
              while (((ig)localObject).equals(((lk)paramObject).g))
              {
                localObject = this.unknownFieldData;
                if ((localObject == null) || (((d)localObject).a()))
                {
                  paramObject = ((lk)paramObject).unknownFieldData;
                  return (paramObject == null) || (((d)paramObject).a());
                }
                return this.unknownFieldData.equals(((lk)paramObject).unknownFieldData);
              }
              return false;
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
    int k = getClass().getName().hashCode() + 527;
    Object localObject = this.i;
    int j = k;
    if (localObject != null) {
      j = k * 31 + ((Integer)localObject).intValue();
    }
    int i5 = this.b.hashCode();
    localObject = this.e;
    if (localObject != null) {}
    for (k = ((fb)localObject).hashCode();; k = 0)
    {
      localObject = this.d;
      if (localObject != null) {}
      for (int m = ((aw)localObject).hashCode();; m = 0)
      {
        localObject = this.h;
        if (localObject != null) {}
        for (int n = ((iz)localObject).hashCode();; n = 0)
        {
          localObject = this.f;
          if (localObject != null) {}
          for (int i1 = ((fu)localObject).hashCode();; i1 = 0)
          {
            localObject = this.g;
            if (localObject != null) {}
            for (int i2 = ((ig)localObject).hashCode();; i2 = 0)
            {
              localObject = this.unknownFieldData;
              int i3 = i4;
              if (localObject != null)
              {
                i3 = i4;
                if (!((d)localObject).a()) {
                  i3 = this.unknownFieldData.hashCode();
                }
              }
              return (i2 + (i1 + (n + (m + (k + (j * 31 + i5) * 31) * 31) * 31) * 31) * 31) * 31 + i3;
            }
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/lk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */