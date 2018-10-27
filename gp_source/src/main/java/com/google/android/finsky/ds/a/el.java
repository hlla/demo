package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.j;
import java.util.Arrays;

public final class el
  extends b
{
  private static volatile el[] e;
  public String a = "";
  public boolean b = false;
  public byte[] c = j.b;
  public String d = "";
  private int f = 0;
  
  public el()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static el[] b()
  {
    if (e == null) {}
    synchronized (f.a)
    {
      if (e == null) {
        e = new el[0];
      }
      return e;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.f & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.d);
    }
    j = i;
    if ((this.f & 0x2) != 0) {
      j = i + (CodedOutputByteBufferNano.d(16) + 1);
    }
    i = j;
    if ((this.f & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.a);
    }
    j = i;
    if ((this.f & 0x8) != 0) {
      j = i + CodedOutputByteBufferNano.b(4, this.c);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.f & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.d);
    }
    if ((this.f & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.b);
    }
    if ((this.f & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.a);
    }
    if ((this.f & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.c);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof el))
      {
        paramObject = (el)paramObject;
        if (((this.f & 0x1) == (((el)paramObject).f & 0x1)) && (this.d.equals(((el)paramObject).d)))
        {
          int i = this.f;
          int j = ((el)paramObject).f;
          if (((i & 0x2) == (j & 0x2)) && (this.b == ((el)paramObject).b) && ((i & 0x4) == (j & 0x4)) && (this.a.equals(((el)paramObject).a)) && ((this.f & 0x8) == (((el)paramObject).f & 0x8)) && (Arrays.equals(this.c, ((el)paramObject).c)))
          {
            d locald = this.unknownFieldData;
            if ((locald != null) && (!locald.a())) {
              break label169;
            }
            paramObject = ((el)paramObject).unknownFieldData;
          }
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label169:
      return this.unknownFieldData.equals(((el)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = getClass().getName().hashCode();
    int m = this.d.hashCode();
    if (!this.b) {}
    for (int j = 1237;; j = 1231)
    {
      int n = this.a.hashCode();
      int i1 = Arrays.hashCode(this.c);
      d locald = this.unknownFieldData;
      int i;
      if (locald != null) {
        if (!locald.a()) {
          i = this.unknownFieldData.hashCode();
        }
      }
      for (;;)
      {
        return i + (((j + ((k + 527) * 31 + m) * 31) * 31 + n) * 31 + i1) * 31;
        i = 0;
        continue;
        i = 0;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/el.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */