package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.g;
import com.google.protobuf.nano.j;
import java.util.Arrays;

public final class bb
  extends b
{
  public String a = "";
  public bu b = null;
  public String c = "";
  public ba d = null;
  public String e = "";
  public ba f = null;
  public String g = "";
  public byte[] h = j.b;
  public int i = 0;
  public String j = "";
  private int k = 0;
  
  public bb()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int n = super.a();
    int m = n;
    if ((this.k & 0x1) != 0) {
      m = n + CodedOutputByteBufferNano.b(1, this.j);
    }
    n = m;
    if ((this.k & 0x2) != 0) {
      n = m + CodedOutputByteBufferNano.b(2, this.a);
    }
    m = n;
    if ((this.k & 0x4) != 0) {
      m = n + CodedOutputByteBufferNano.b(3, this.e);
    }
    n = m;
    if ((this.k & 0x8) != 0) {
      n = m + CodedOutputByteBufferNano.b(4, this.g);
    }
    Object localObject = this.d;
    m = n;
    if (localObject != null) {
      m = n + CodedOutputByteBufferNano.d(5, (g)localObject);
    }
    localObject = this.f;
    n = m;
    if (localObject != null) {
      n = m + CodedOutputByteBufferNano.d(6, (g)localObject);
    }
    localObject = this.b;
    m = n;
    if (localObject != null) {
      m = n + CodedOutputByteBufferNano.d(7, (g)localObject);
    }
    n = m;
    if ((this.k & 0x10) != 0) {
      n = m + CodedOutputByteBufferNano.b(8, this.c);
    }
    m = n;
    if ((this.k & 0x20) != 0) {
      m = n + CodedOutputByteBufferNano.b(9, this.h);
    }
    n = m;
    if ((this.k & 0x40) != 0) {
      n = m + CodedOutputByteBufferNano.d(10, this.i);
    }
    return n;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.k & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.j);
    }
    if ((this.k & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.a);
    }
    if ((this.k & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.e);
    }
    if ((this.k & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.g);
    }
    Object localObject = this.d;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(5, (g)localObject);
    }
    localObject = this.f;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(6, (g)localObject);
    }
    localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(7, (g)localObject);
    }
    if ((this.k & 0x10) != 0) {
      paramCodedOutputByteBufferNano.a(8, this.c);
    }
    if ((this.k & 0x20) != 0) {
      paramCodedOutputByteBufferNano.a(9, this.h);
    }
    if ((this.k & 0x40) != 0) {
      paramCodedOutputByteBufferNano.a(10, this.i);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof bb))
      {
        paramObject = (bb)paramObject;
        if (((this.k & 0x1) == (((bb)paramObject).k & 0x1)) && (this.j.equals(((bb)paramObject).j)) && ((this.k & 0x2) == (((bb)paramObject).k & 0x2)) && (this.a.equals(((bb)paramObject).a)) && ((this.k & 0x4) == (((bb)paramObject).k & 0x4)) && (this.e.equals(((bb)paramObject).e)) && ((this.k & 0x8) == (((bb)paramObject).k & 0x8)) && (this.g.equals(((bb)paramObject).g)))
        {
          localObject = this.d;
          if (localObject != null) {
            break label347;
          }
          if (((bb)paramObject).d != null) {}
        }
      }
      label347:
      while (((ba)localObject).equals(((bb)paramObject).d))
      {
        localObject = this.f;
        if (localObject == null) {
          if (((bb)paramObject).f != null) {}
        }
        while (((ba)localObject).equals(((bb)paramObject).f))
        {
          localObject = this.b;
          if (localObject == null) {
            if (((bb)paramObject).b != null) {}
          }
          while (((bu)localObject).equals(((bb)paramObject).b))
          {
            if (((this.k & 0x10) == (((bb)paramObject).k & 0x10)) && (this.c.equals(((bb)paramObject).c)) && ((this.k & 0x20) == (((bb)paramObject).k & 0x20)) && (Arrays.equals(this.h, ((bb)paramObject).h)) && ((this.k & 0x40) == (((bb)paramObject).k & 0x40)) && (this.i == ((bb)paramObject).i))
            {
              localObject = this.unknownFieldData;
              if ((localObject == null) || (((d)localObject).a())) {
                paramObject = ((bb)paramObject).unknownFieldData;
              }
            }
            else
            {
              return (paramObject == null) || (((d)paramObject).a());
            }
            return this.unknownFieldData.equals(((bb)paramObject).unknownFieldData);
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
    int i3 = 0;
    int i4 = getClass().getName().hashCode();
    int i5 = this.j.hashCode();
    int i6 = this.a.hashCode();
    int i7 = this.e.hashCode();
    int i8 = this.g.hashCode();
    Object localObject = this.d;
    if (localObject != null) {}
    for (int m = ((ba)localObject).hashCode();; m = 0)
    {
      localObject = this.f;
      if (localObject != null) {}
      for (int n = ((ba)localObject).hashCode();; n = 0)
      {
        localObject = this.b;
        if (localObject != null) {}
        for (int i1 = ((bu)localObject).hashCode();; i1 = 0)
        {
          int i9 = this.c.hashCode();
          int i10 = Arrays.hashCode(this.h);
          int i11 = this.i;
          localObject = this.unknownFieldData;
          int i2 = i3;
          if (localObject != null)
          {
            i2 = i3;
            if (!((d)localObject).a()) {
              i2 = this.unknownFieldData.hashCode();
            }
          }
          return ((((i1 + (n + (m + (((((i4 + 527) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31) * 31) * 31) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i2;
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */