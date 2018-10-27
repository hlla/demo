package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class aq
  extends b
{
  public String a = "";
  public String b = "";
  private int c = 0;
  private String d = "";
  
  public aq()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.c & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.a);
    }
    j = i;
    if ((this.c & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.b);
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
      paramCodedOutputByteBufferNano.a(1, this.a);
    }
    if ((this.c & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.b);
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
      if ((paramObject instanceof aq))
      {
        paramObject = (aq)paramObject;
        if (((this.c & 0x1) == (((aq)paramObject).c & 0x1)) && (this.a.equals(((aq)paramObject).a)) && ((this.c & 0x2) == (((aq)paramObject).c & 0x2)) && (this.b.equals(((aq)paramObject).b)) && ((this.c & 0x4) == (((aq)paramObject).c & 0x4)) && (this.d.equals(((aq)paramObject).d)))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label140;
          }
          paramObject = ((aq)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label140:
      return this.unknownFieldData.equals(((aq)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = this.a.hashCode();
    int n = this.b.hashCode();
    int i1 = this.d.hashCode();
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */