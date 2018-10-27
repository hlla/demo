package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class ew
  extends b
{
  public kp a = null;
  public String b = "";
  public boolean c = false;
  public boolean d = false;
  public int e = 0;
  private int f = 0;
  
  public ew()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.f & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.b);
    }
    j = i;
    if ((this.f & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.d(2, this.e);
    }
    kp localkp = this.a;
    i = j;
    if (localkp != null) {
      i = j + CodedOutputByteBufferNano.d(3, localkp);
    }
    j = i;
    if ((this.f & 0x4) != 0) {
      j = i + (CodedOutputByteBufferNano.d(32) + 1);
    }
    i = j;
    if ((this.f & 0x8) != 0) {
      i = j + (CodedOutputByteBufferNano.d(40) + 1);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.f & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.b);
    }
    if ((this.f & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.e);
    }
    kp localkp = this.a;
    if (localkp != null) {
      paramCodedOutputByteBufferNano.b(3, localkp);
    }
    if ((this.f & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.d);
    }
    if ((this.f & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.c);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof ew))
      {
        paramObject = (ew)paramObject;
        if (((this.f & 0x1) == (((ew)paramObject).f & 0x1)) && (this.b.equals(((ew)paramObject).b)) && ((this.f & 0x2) == (((ew)paramObject).f & 0x2)) && (this.e == ((ew)paramObject).e))
        {
          localObject = this.a;
          if (localObject != null) {
            break label193;
          }
          if (((ew)paramObject).a != null) {}
        }
      }
      label193:
      while (((kp)localObject).equals(((ew)paramObject).a))
      {
        int i = this.f;
        int j = ((ew)paramObject).f;
        if (((i & 0x4) == (j & 0x4)) && (this.d == ((ew)paramObject).d) && ((i & 0x8) == (j & 0x8)) && (this.c == ((ew)paramObject).c))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((ew)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((ew)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 1237;
    int n = 0;
    int i1 = getClass().getName().hashCode();
    int i2 = this.b.hashCode();
    int i3 = this.e;
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = ((kp)localObject).hashCode();; i = 0)
    {
      if (!this.d) {}
      for (int j = 1237;; j = 1231)
      {
        if (!this.c) {}
        for (;;)
        {
          localObject = this.unknownFieldData;
          int m = n;
          if (localObject != null)
          {
            m = n;
            if (!((d)localObject).a()) {
              m = this.unknownFieldData.hashCode();
            }
          }
          return ((j + (i + (((i1 + 527) * 31 + i2) * 31 + i3) * 31) * 31) * 31 + k) * 31 + m;
          k = 1231;
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */