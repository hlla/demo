package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class ks
  extends b
{
  public String a = "";
  public String b = "";
  public String c = "";
  private int d = 0;
  
  public ks()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.d & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.b);
    }
    j = i;
    if ((this.d & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.c);
    }
    i = j;
    if ((this.d & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.a);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.d & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.b);
    }
    if ((this.d & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.c);
    }
    if ((this.d & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.a);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof ks))
      {
        paramObject = (ks)paramObject;
        if (((this.d & 0x1) == (((ks)paramObject).d & 0x1)) && (this.b.equals(((ks)paramObject).b)) && ((this.d & 0x2) == (((ks)paramObject).d & 0x2)) && (this.c.equals(((ks)paramObject).c)) && ((this.d & 0x4) == (((ks)paramObject).d & 0x4)) && (this.a.equals(((ks)paramObject).a)))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label140;
          }
          paramObject = ((ks)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label140:
      return this.unknownFieldData.equals(((ks)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = this.b.hashCode();
    int n = this.c.hashCode();
    int i1 = this.a.hashCode();
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */