package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class lb
  extends b
{
  public String a = "";
  public boolean b = false;
  public String c = "";
  public String d = "";
  public nm e = null;
  private int f = 0;
  private int g = 0;
  
  public lb()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.g & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.a);
    }
    j = i;
    if ((this.g & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.d);
    }
    i = j;
    if ((this.g & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.c);
    }
    j = i;
    if ((this.g & 0x8) != 0) {
      j = i + CodedOutputByteBufferNano.d(4, this.f);
    }
    i = j;
    if ((this.g & 0x10) != 0) {
      i = j + (CodedOutputByteBufferNano.d(40) + 1);
    }
    nm localnm = this.e;
    j = i;
    if (localnm != null) {
      j = i + CodedOutputByteBufferNano.d(6, localnm);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.g & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.a);
    }
    if ((this.g & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.d);
    }
    if ((this.g & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.c);
    }
    if ((this.g & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.f);
    }
    if ((this.g & 0x10) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.b);
    }
    nm localnm = this.e;
    if (localnm != null) {
      paramCodedOutputByteBufferNano.b(6, localnm);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof lb))
      {
        paramObject = (lb)paramObject;
        if (((this.g & 0x1) == (((lb)paramObject).g & 0x1)) && (this.a.equals(((lb)paramObject).a)) && ((this.g & 0x2) == (((lb)paramObject).g & 0x2)) && (this.d.equals(((lb)paramObject).d)) && ((this.g & 0x4) == (((lb)paramObject).g & 0x4)) && (this.c.equals(((lb)paramObject).c)))
        {
          int i = this.g;
          int j = ((lb)paramObject).g;
          if (((i & 0x8) == (j & 0x8)) && (this.f == ((lb)paramObject).f) && ((i & 0x10) == (j & 0x10)) && (this.b == ((lb)paramObject).b))
          {
            localObject = this.e;
            if (localObject != null) {
              break label227;
            }
            if (((lb)paramObject).e != null) {}
          }
        }
      }
      label227:
      while (((nm)localObject).equals(((lb)paramObject).e))
      {
        localObject = this.unknownFieldData;
        if ((localObject == null) || (((d)localObject).a()))
        {
          paramObject = ((lb)paramObject).unknownFieldData;
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((lb)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int m = 0;
    int n = getClass().getName().hashCode();
    int i1 = this.a.hashCode();
    int i2 = this.d.hashCode();
    int i3 = this.c.hashCode();
    int i4 = this.f;
    if (!this.b) {}
    for (int i = 1237;; i = 1231)
    {
      Object localObject = this.e;
      if (localObject != null) {}
      for (int j = ((nm)localObject).hashCode();; j = 0)
      {
        localObject = this.unknownFieldData;
        int k = m;
        if (localObject != null)
        {
          k = m;
          if (!((d)localObject).a()) {
            k = this.unknownFieldData.hashCode();
          }
        }
        return (j + (i + (((((n + 527) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31) * 31) * 31 + k;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/lb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */