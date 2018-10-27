package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.wireless.android.finsky.d.ag;

public final class bv
  extends b
{
  public int a = 0;
  public int b = 0;
  private Integer c;
  private int d = 0;
  
  public bv()
  {
    if (ag.a != null) {}
    for (Integer localInteger = Integer.valueOf(ag.a.b);; localInteger = null)
    {
      this.c = localInteger;
      this.unknownFieldData = null;
      this.cachedSize = -1;
      return;
    }
  }
  
  protected final int a()
  {
    int j = super.a() + CodedOutputByteBufferNano.d(3, this.b) + CodedOutputByteBufferNano.d(4, this.a);
    int i = j;
    if ((this.d & 0x1) != 0)
    {
      Integer localInteger = this.c;
      i = j;
      if (localInteger != null) {
        i = j + CodedOutputByteBufferNano.d(18, localInteger.intValue());
      }
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.a(3, this.b);
    paramCodedOutputByteBufferNano.a(4, this.a);
    if ((this.d & 0x1) != 0)
    {
      Integer localInteger = this.c;
      if (localInteger != null) {
        paramCodedOutputByteBufferNano.a(18, localInteger.intValue());
      }
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof bv))
      {
        paramObject = (bv)paramObject;
        if ((this.b == ((bv)paramObject).b) && (this.a == ((bv)paramObject).a) && ((this.d & 0x1) == (((bv)paramObject).d & 0x1)) && (this.c == ((bv)paramObject).c))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label101;
          }
          paramObject = ((bv)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label101:
      return this.unknownFieldData.equals(((bv)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int i = ((getClass().getName().hashCode() + 527) * 31 + this.b) * 31 + this.a;
    Object localObject = this.c;
    int j = i;
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */