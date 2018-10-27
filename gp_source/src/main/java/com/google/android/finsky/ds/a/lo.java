package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;

public final class lo
  extends b
{
  private static volatile lo[] f;
  public String a = "";
  public ln b = null;
  public String c = "";
  public String d = "";
  public String e = "";
  private int g = 0;
  
  public lo()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static lo[] b()
  {
    if (f == null) {}
    synchronized (f.a)
    {
      if (f == null) {
        f = new lo[0];
      }
      return f;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.g & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.e);
    }
    j = i;
    if ((this.g & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.c);
    }
    i = j;
    if ((this.g & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.a);
    }
    ln localln = this.b;
    j = i;
    if (localln != null) {
      j = i + CodedOutputByteBufferNano.d(4, localln);
    }
    i = j;
    if ((this.g & 0x8) != 0) {
      i = j + CodedOutputByteBufferNano.b(5, this.d);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.g & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.e);
    }
    if ((this.g & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.c);
    }
    if ((this.g & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.a);
    }
    ln localln = this.b;
    if (localln != null) {
      paramCodedOutputByteBufferNano.b(4, localln);
    }
    if ((this.g & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.d);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof lo))
      {
        paramObject = (lo)paramObject;
        if (((this.g & 0x1) == (((lo)paramObject).g & 0x1)) && (this.e.equals(((lo)paramObject).e)) && ((this.g & 0x2) == (((lo)paramObject).g & 0x2)) && (this.c.equals(((lo)paramObject).c)) && ((this.g & 0x4) == (((lo)paramObject).g & 0x4)) && (this.a.equals(((lo)paramObject).a)))
        {
          localObject = this.b;
          if (localObject != null) {
            break label199;
          }
          if (((lo)paramObject).b != null) {}
        }
      }
      label199:
      while (((ln)localObject).equals(((lo)paramObject).b))
      {
        if (((this.g & 0x8) == (((lo)paramObject).g & 0x8)) && (this.d.equals(((lo)paramObject).d)))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((lo)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((lo)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int n = this.e.hashCode();
    int i1 = this.c.hashCode();
    int i2 = this.a.hashCode();
    Object localObject = this.b;
    if (localObject != null) {}
    for (int i = ((ln)localObject).hashCode();; i = 0)
    {
      int i3 = this.d.hashCode();
      localObject = this.unknownFieldData;
      int j = k;
      if (localObject != null)
      {
        j = k;
        if (!((d)localObject).a()) {
          j = this.unknownFieldData.hashCode();
        }
      }
      return ((i + ((((m + 527) * 31 + n) * 31 + i1) * 31 + i2) * 31) * 31 + i3) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/lo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */