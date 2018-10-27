package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.j;
import java.util.Arrays;

public final class cn
  extends b
{
  private static volatile cn[] d;
  public String a = "";
  public boolean b = false;
  public String c = "";
  private int e = 0;
  private byte[] f = j.b;
  
  public cn()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static cn[] b()
  {
    if (d == null) {}
    synchronized (f.a)
    {
      if (d == null) {
        d = new cn[0];
      }
      return d;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.e & 0x1) != 0) {
      i = j + (CodedOutputByteBufferNano.d(8) + 1);
    }
    j = i;
    if ((this.e & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.c);
    }
    i = j;
    if ((this.e & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.a);
    }
    j = i;
    if ((this.e & 0x8) != 0) {
      j = i + CodedOutputByteBufferNano.b(4, this.f);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.e & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.b);
    }
    if ((this.e & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.c);
    }
    if ((this.e & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.a);
    }
    if ((this.e & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.f);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof cn))
      {
        paramObject = (cn)paramObject;
        int i = this.e;
        int j = ((cn)paramObject).e;
        if (((i & 0x1) == (j & 0x1)) && (this.b == ((cn)paramObject).b) && ((i & 0x2) == (j & 0x2)) && (this.c.equals(((cn)paramObject).c)) && ((this.e & 0x4) == (((cn)paramObject).e & 0x4)) && (this.a.equals(((cn)paramObject).a)) && ((this.e & 0x8) == (((cn)paramObject).e & 0x8)) && (Arrays.equals(this.f, ((cn)paramObject).f)))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label169;
          }
          paramObject = ((cn)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label169:
      return this.unknownFieldData.equals(((cn)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = getClass().getName().hashCode();
    if (!this.b) {}
    for (int j = 1237;; j = 1231)
    {
      int m = this.c.hashCode();
      int n = this.a.hashCode();
      int i1 = Arrays.hashCode(this.f);
      d locald = this.unknownFieldData;
      int i;
      if (locald != null) {
        if (!locald.a()) {
          i = this.unknownFieldData.hashCode();
        }
      }
      for (;;)
      {
        return i + ((((j + (k + 527) * 31) * 31 + m) * 31 + n) * 31 + i1) * 31;
        i = 0;
        continue;
        i = 0;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */