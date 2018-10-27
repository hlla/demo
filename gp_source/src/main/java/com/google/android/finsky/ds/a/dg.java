package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class dg
  extends b
{
  public String a = "";
  public boolean b = false;
  private int c = 0;
  private String d = "";
  
  public dg()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.c & 0x1) != 0) {
      i = j + (CodedOutputByteBufferNano.d(8) + 1);
    }
    j = i;
    if ((this.c & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.a);
    }
    i = j;
    if ((this.c & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.d);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.c & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.b);
    }
    if ((this.c & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.a);
    }
    if ((this.c & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.d);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof dg))
      {
        paramObject = (dg)paramObject;
        int i = this.c;
        int j = ((dg)paramObject).c;
        if (((i & 0x1) == (j & 0x1)) && (this.b == ((dg)paramObject).b) && ((i & 0x2) == (j & 0x2)) && (this.a.equals(((dg)paramObject).a)) && ((this.c & 0x4) == (((dg)paramObject).c & 0x4)) && (this.d.equals(((dg)paramObject).d)))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label138;
          }
          paramObject = ((dg)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label138:
      return this.unknownFieldData.equals(((dg)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = getClass().getName().hashCode();
    if (!this.b) {}
    for (int j = 1237;; j = 1231)
    {
      int m = this.a.hashCode();
      int n = this.d.hashCode();
      d locald = this.unknownFieldData;
      int i;
      if (locald != null) {
        if (!locald.a()) {
          i = this.unknownFieldData.hashCode();
        }
      }
      for (;;)
      {
        return i + (((j + (k + 527) * 31) * 31 + m) * 31 + n) * 31;
        i = 0;
        continue;
        i = 0;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/dg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */