package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class em
  extends b
{
  private int a = 0;
  private int b = 0;
  private int c = 0;
  
  public em()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.b & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.e(1, this.a);
    }
    j = i;
    if ((this.b & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.e(2, this.c);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.b & 0x1) != 0) {
      paramCodedOutputByteBufferNano.c(1, this.a);
    }
    if ((this.b & 0x2) != 0) {
      paramCodedOutputByteBufferNano.c(2, this.c);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof em))
      {
        paramObject = (em)paramObject;
        int i = this.b;
        int j = ((em)paramObject).b;
        if (((i & 0x1) == (j & 0x1)) && (this.a == ((em)paramObject).a) && ((i & 0x2) == (j & 0x2)) && (this.c == ((em)paramObject).c))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label106;
          }
          paramObject = ((em)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label106:
      return this.unknownFieldData.equals(((em)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = this.a;
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/em.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */