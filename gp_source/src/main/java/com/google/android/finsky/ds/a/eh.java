package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.g;

public final class eh
  extends b
{
  public af a = null;
  public ag b = null;
  public int c = 0;
  public String d = "";
  public String e = "";
  public String f = "";
  public mf g = null;
  public String h = "";
  public String i = "";
  private int j = 0;
  
  public eh()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int m = super.a();
    Object localObject = this.a;
    int k = m;
    if (localObject != null) {
      k = m + CodedOutputByteBufferNano.d(1, (g)localObject);
    }
    m = k;
    if ((this.j & 0x1) != 0) {
      m = k + CodedOutputByteBufferNano.b(2, this.i);
    }
    k = m;
    if ((this.j & 0x2) != 0) {
      k = m + CodedOutputByteBufferNano.b(3, this.h);
    }
    m = k;
    if ((this.j & 0x4) != 0) {
      m = k + CodedOutputByteBufferNano.d(4, this.c);
    }
    k = m;
    if ((this.j & 0x8) != 0) {
      k = m + CodedOutputByteBufferNano.b(5, this.d);
    }
    m = k;
    if ((this.j & 0x10) != 0) {
      m = k + CodedOutputByteBufferNano.b(6, this.e);
    }
    localObject = this.b;
    k = m;
    if (localObject != null) {
      k = m + CodedOutputByteBufferNano.d(7, (g)localObject);
    }
    m = k;
    if ((this.j & 0x20) != 0) {
      m = k + CodedOutputByteBufferNano.b(8, this.f);
    }
    localObject = this.g;
    k = m;
    if (localObject != null) {
      k = m + CodedOutputByteBufferNano.d(9, (g)localObject);
    }
    return k;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.a;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(1, (g)localObject);
    }
    if ((this.j & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.i);
    }
    if ((this.j & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.h);
    }
    if ((this.j & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.c);
    }
    if ((this.j & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.d);
    }
    if ((this.j & 0x10) != 0) {
      paramCodedOutputByteBufferNano.a(6, this.e);
    }
    localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(7, (g)localObject);
    }
    if ((this.j & 0x20) != 0) {
      paramCodedOutputByteBufferNano.a(8, this.f);
    }
    localObject = this.g;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(9, (g)localObject);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof eh))
      {
        paramObject = (eh)paramObject;
        localObject = this.a;
        if (localObject != null) {
          break label325;
        }
        if (((eh)paramObject).a != null) {}
      }
      label297:
      label311:
      label325:
      while (((af)localObject).equals(((eh)paramObject).a))
      {
        if (((this.j & 0x1) == (((eh)paramObject).j & 0x1)) && (this.i.equals(((eh)paramObject).i)) && ((this.j & 0x2) == (((eh)paramObject).j & 0x2)) && (this.h.equals(((eh)paramObject).h)))
        {
          int k = this.j;
          int m = ((eh)paramObject).j;
          if (((k & 0x4) == (m & 0x4)) && (this.c == ((eh)paramObject).c) && ((k & 0x8) == (m & 0x8)) && (this.d.equals(((eh)paramObject).d)) && ((this.j & 0x10) == (((eh)paramObject).j & 0x10)) && (this.e.equals(((eh)paramObject).e)))
          {
            localObject = this.b;
            if (localObject != null) {
              break label311;
            }
            if (((eh)paramObject).b != null) {}
          }
        }
        while (((ag)localObject).equals(((eh)paramObject).b))
        {
          if (((this.j & 0x20) == (((eh)paramObject).j & 0x20)) && (this.f.equals(((eh)paramObject).f)))
          {
            localObject = this.g;
            if (localObject != null) {
              break label297;
            }
            if (((eh)paramObject).g != null) {}
          }
          while (((mf)localObject).equals(((eh)paramObject).g))
          {
            localObject = this.unknownFieldData;
            if ((localObject == null) || (((d)localObject).a()))
            {
              paramObject = ((eh)paramObject).unknownFieldData;
              return (paramObject == null) || (((d)paramObject).a());
            }
            return this.unknownFieldData.equals(((eh)paramObject).unknownFieldData);
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
    Object localObject = this.a;
    if (localObject != null) {}
    for (int k = ((af)localObject).hashCode();; k = 0)
    {
      int i4 = this.i.hashCode();
      int i5 = this.h.hashCode();
      int i6 = this.c;
      int i7 = this.d.hashCode();
      int i8 = this.e.hashCode();
      localObject = this.b;
      if (localObject != null) {}
      for (int m = ((ag)localObject).hashCode();; m = 0)
      {
        int i9 = this.f.hashCode();
        localObject = this.g;
        if (localObject != null) {}
        for (int n = ((mf)localObject).hashCode();; n = 0)
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
          return (n + ((m + ((((((k + (i3 + 527) * 31) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31) * 31 + i9) * 31) * 31 + i1;
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/eh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */