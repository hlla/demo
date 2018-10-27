package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.j;
import java.util.Arrays;

public final class av
  extends b
{
  public int a = 0;
  public byte[] b = j.b;
  public String c = "";
  
  public av()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
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
      j = i + CodedOutputByteBufferNano.b(2, this.c);
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
      if ((paramObject instanceof av))
      {
        paramObject = (av)paramObject;
        if (((this.a & 0x1) == (((av)paramObject).a & 0x1)) && (Arrays.equals(this.b, ((av)paramObject).b)) && ((this.a & 0x2) == (((av)paramObject).a & 0x2)) && (this.c.equals(((av)paramObject).c)))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label111;
          }
          paramObject = ((av)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label111:
      return this.unknownFieldData.equals(((av)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = Arrays.hashCode(this.b);
    int n = this.c.hashCode();
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */