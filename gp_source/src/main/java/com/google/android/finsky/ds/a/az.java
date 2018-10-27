package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.j;
import java.util.Arrays;

public final class az
  extends b
{
  public byte[] a = j.b;
  public byte[] b = j.b;
  public String c = "";
  private int d = 0;
  
  public az()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.d & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.a);
    }
    j = i;
    if ((this.d & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.b);
    }
    i = j;
    if ((this.d & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.c);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.d & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.a);
    }
    if ((this.d & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.b);
    }
    if ((this.d & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.c);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof az))
      {
        paramObject = (az)paramObject;
        if (((this.d & 0x1) == (((az)paramObject).d & 0x1)) && (Arrays.equals(this.a, ((az)paramObject).a)) && ((this.d & 0x2) == (((az)paramObject).d & 0x2)) && (Arrays.equals(this.b, ((az)paramObject).b)) && ((this.d & 0x4) == (((az)paramObject).d & 0x4)) && (this.c.equals(((az)paramObject).c)))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label140;
          }
          paramObject = ((az)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label140:
      return this.unknownFieldData.equals(((az)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = Arrays.hashCode(this.a);
    int n = Arrays.hashCode(this.b);
    int i1 = this.c.hashCode();
    d locald = this.unknownFieldData;
    int i = j;
    if (locald != null)
    {
      i = j;
      if (!locald.a()) {
        i = this.unknownFieldData.hashCode();
      }
    }
    return i + ((((k + 527) * 31 + m) * 31 + n) * 31 + i1) * 31;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */