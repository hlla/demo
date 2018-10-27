package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;

public final class mv
  extends b
{
  private static volatile mv[] d;
  public int a = 0;
  public String b = "";
  public String c = "";
  
  public mv()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static mv[] b()
  {
    if (d == null) {}
    synchronized (f.a)
    {
      if (d == null) {
        d = new mv[0];
      }
      return d;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.a & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.c);
    }
    j = i;
    if ((this.a & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.b);
    }
    return j;
  }
  
  public final mv a(String paramString)
  {
    if (paramString != null)
    {
      this.a |= 0x2;
      this.b = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.c);
    }
    if ((this.a & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.b);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof mv))
      {
        paramObject = (mv)paramObject;
        if (((this.a & 0x1) == (((mv)paramObject).a & 0x1)) && (this.c.equals(((mv)paramObject).c)) && ((this.a & 0x2) == (((mv)paramObject).a & 0x2)) && (this.b.equals(((mv)paramObject).b)))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label111;
          }
          paramObject = ((mv)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label111:
      return this.unknownFieldData.equals(((mv)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = this.c.hashCode();
    int n = this.b.hashCode();
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/mv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */