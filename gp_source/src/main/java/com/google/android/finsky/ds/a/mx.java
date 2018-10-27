package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.j;
import com.google.wireless.android.finsky.dfe.b.b.i;
import java.util.Arrays;

public final class mx
  extends b
{
  private static volatile mx[] d;
  public String a = "";
  public String b = "";
  public double c = 0.0D;
  private Integer e;
  private int f = 0;
  private byte[] g = j.b;
  
  public mx()
  {
    if (i.a != null) {}
    for (Integer localInteger = Integer.valueOf(i.a.b);; localInteger = null)
    {
      this.e = localInteger;
      this.unknownFieldData = null;
      this.cachedSize = -1;
      return;
    }
  }
  
  public static mx[] b()
  {
    if (d == null) {}
    synchronized (f.a)
    {
      if (d == null) {
        d = new mx[0];
      }
      return d;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.f & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.a);
    }
    j = i;
    if ((this.f & 0x10) != 0)
    {
      Integer localInteger = this.e;
      j = i;
      if (localInteger != null) {
        j = i + CodedOutputByteBufferNano.d(2, localInteger.intValue());
      }
    }
    i = j;
    if ((this.f & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.b);
    }
    j = i;
    if ((this.f & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(4, this.g);
    }
    i = j;
    if ((this.f & 0x8) != 0) {
      i = j + (CodedOutputByteBufferNano.d(40) + 8);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.f & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.a);
    }
    if ((this.f & 0x10) != 0)
    {
      Integer localInteger = this.e;
      if (localInteger != null) {
        paramCodedOutputByteBufferNano.a(2, localInteger.intValue());
      }
    }
    if ((this.f & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.b);
    }
    if ((this.f & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.g);
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
      if ((paramObject instanceof mx))
      {
        paramObject = (mx)paramObject;
        if (((this.f & 0x1) == (((mx)paramObject).f & 0x1)) && (this.a.equals(((mx)paramObject).a)) && ((this.f & 0x2) == (((mx)paramObject).f & 0x2)) && (Arrays.equals(this.g, ((mx)paramObject).g)) && ((this.f & 0x4) == (((mx)paramObject).f & 0x4)) && (this.b.equals(((mx)paramObject).b)) && ((this.f & 0x8) == (((mx)paramObject).f & 0x8)) && (Double.doubleToLongBits(this.c) == Double.doubleToLongBits(((mx)paramObject).c)) && ((this.f & 0x10) == (((mx)paramObject).f & 0x10)) && (this.e == ((mx)paramObject).e))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label203;
          }
          paramObject = ((mx)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label203:
      return this.unknownFieldData.equals(((mx)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int i = getClass().getName().hashCode();
    int j = this.a.hashCode();
    int k = Arrays.hashCode(this.g);
    int m = this.b.hashCode();
    long l = Double.doubleToLongBits(this.c);
    i = ((((i + 527) * 31 + j) * 31 + k) * 31 + m) * 31 + (int)(l >>> 32 ^ l);
    Object localObject = this.e;
    j = i;
    if (localObject != null) {
      j = i * 31 + ((Integer)localObject).intValue();
    }
    localObject = this.unknownFieldData;
    if (localObject != null) {
      if (!((d)localObject).a()) {
        i = this.unknownFieldData.hashCode();
      }
    }
    for (;;)
    {
      return i + j * 31;
      i = 0;
      continue;
      i = 0;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/mx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */