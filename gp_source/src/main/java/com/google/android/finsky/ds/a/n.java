package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;

public final class n
  extends b
{
  private static volatile n[] d;
  public int a = 0;
  public String b = "";
  public int c = 0;
  
  public n()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static n[] b()
  {
    if (d == null) {}
    synchronized (f.a)
    {
      if (d == null) {
        d = new n[0];
      }
      return d;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.a & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.b);
    }
    j = i;
    if ((this.a & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.d(2, this.c);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.b);
    }
    if ((this.a & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.c);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof n))
      {
        paramObject = (n)paramObject;
        if (((this.a & 0x1) == (((n)paramObject).a & 0x1)) && (this.b.equals(((n)paramObject).b)) && ((this.a & 0x2) == (((n)paramObject).a & 0x2)) && (this.c == ((n)paramObject).c))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label108;
          }
          paramObject = ((n)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label108:
      return this.unknownFieldData.equals(((n)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = this.b.hashCode();
    int n = this.c;
    d locald = this.unknownFieldData;
    int i = j;
    if (locald != null)
    {
      i = j;
      if (!locald.a()) {
        i = this.unknownFieldData.hashCode();
      }
    }
    return i + (((k + 527) * 31 + m) * 31 + n) * 31;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */