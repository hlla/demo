package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;

public final class kl
  extends b
{
  private static volatile kl[] e;
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  private int f = 0;
  
  public kl()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static kl[] b()
  {
    if (e == null) {}
    synchronized (f.a)
    {
      if (e == null) {
        e = new kl[0];
      }
      return e;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.f & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.c);
    }
    j = i;
    if ((this.f & 0x4) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.d);
    }
    i = j;
    if ((this.f & 0x8) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.a);
    }
    j = i;
    if ((this.f & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(4, this.b);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.f & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.c);
    }
    if ((this.f & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.d);
    }
    if ((this.f & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.a);
    }
    if ((this.f & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.b);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean c()
  {
    return (this.f & 0x4) != 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof kl))
      {
        paramObject = (kl)paramObject;
        if (((this.f & 0x1) == (((kl)paramObject).f & 0x1)) && (this.c.equals(((kl)paramObject).c)) && ((this.f & 0x2) == (((kl)paramObject).f & 0x2)) && (this.b.equals(((kl)paramObject).b)) && ((this.f & 0x4) == (((kl)paramObject).f & 0x4)) && (this.d.equals(((kl)paramObject).d)) && ((this.f & 0x8) == (((kl)paramObject).f & 0x8)) && (this.a.equals(((kl)paramObject).a)))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label171;
          }
          paramObject = ((kl)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label171:
      return this.unknownFieldData.equals(((kl)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = this.c.hashCode();
    int n = this.b.hashCode();
    int i1 = this.d.hashCode();
    int i2 = this.a.hashCode();
    d locald = this.unknownFieldData;
    int i = j;
    if (locald != null)
    {
      i = j;
      if (!locald.a()) {
        i = this.unknownFieldData.hashCode();
      }
    }
    return i + (((((k + 527) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/kl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */