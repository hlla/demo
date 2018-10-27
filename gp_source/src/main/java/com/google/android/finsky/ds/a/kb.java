package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.wireless.android.finsky.d.ar;

public final class kb
  extends b
{
  private static volatile kb[] d;
  public int a = 0;
  public long b;
  public String c = "";
  private Integer e;
  private String f = "";
  
  public kb()
  {
    if (ar.a != null) {}
    for (Integer localInteger = Integer.valueOf(ar.a.b);; localInteger = null)
    {
      this.e = localInteger;
      this.b = 0L;
      this.unknownFieldData = null;
      this.cachedSize = -1;
      return;
    }
  }
  
  public static kb[] b()
  {
    if (d == null) {}
    synchronized (f.a)
    {
      if (d == null) {
        d = new kb[0];
      }
      return d;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.a & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.f);
    }
    j = i;
    if ((this.a & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.c);
    }
    i = j;
    if ((this.a & 0x4) != 0)
    {
      Integer localInteger = this.e;
      i = j;
      if (localInteger != null) {
        i = j + CodedOutputByteBufferNano.d(3, localInteger.intValue());
      }
    }
    j = i;
    if ((this.a & 0x8) != 0) {
      j = i + CodedOutputByteBufferNano.f(4, this.b);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.f);
    }
    if ((this.a & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.c);
    }
    if ((this.a & 0x4) != 0)
    {
      Integer localInteger = this.e;
      if (localInteger != null) {
        paramCodedOutputByteBufferNano.a(3, localInteger.intValue());
      }
    }
    if ((this.a & 0x8) != 0) {
      paramCodedOutputByteBufferNano.b(4, this.b);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof kb))
      {
        paramObject = (kb)paramObject;
        if (((this.a & 0x1) == (((kb)paramObject).a & 0x1)) && (this.f.equals(((kb)paramObject).f)) && ((this.a & 0x2) == (((kb)paramObject).a & 0x2)) && (this.c.equals(((kb)paramObject).c)))
        {
          int i = this.a;
          int j = ((kb)paramObject).a;
          if (((i & 0x4) == (j & 0x4)) && (this.e == ((kb)paramObject).e) && ((i & 0x8) == (j & 0x8)) && (this.b == ((kb)paramObject).b))
          {
            d locald = this.unknownFieldData;
            if ((locald != null) && (!locald.a())) {
              break label167;
            }
            paramObject = ((kb)paramObject).unknownFieldData;
          }
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label167:
      return this.unknownFieldData.equals(((kb)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int i = ((getClass().getName().hashCode() + 527) * 31 + this.f.hashCode()) * 31 + this.c.hashCode();
    Object localObject = this.e;
    int j = i;
    if (localObject != null) {
      j = i * 31 + ((Integer)localObject).intValue();
    }
    long l = this.b;
    int k = (int)(l ^ l >>> 32);
    localObject = this.unknownFieldData;
    if (localObject != null) {
      if (!((d)localObject).a()) {
        i = this.unknownFieldData.hashCode();
      }
    }
    for (;;)
    {
      return i + (j * 31 + k) * 31;
      i = 0;
      continue;
      i = 0;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/kb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */