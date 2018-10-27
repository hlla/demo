package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class ct
  extends b
{
  public String a = "";
  public String b = "";
  private int c = 0;
  
  public ct()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.c & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.b);
    }
    j = i;
    if ((this.c & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.a);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.c & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.b);
    }
    if ((this.c & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.a);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof ct))
      {
        paramObject = (ct)paramObject;
        if (((this.c & 0x1) == (((ct)paramObject).c & 0x1)) && (this.b.equals(((ct)paramObject).b)) && ((this.c & 0x2) == (((ct)paramObject).c & 0x2)) && (this.a.equals(((ct)paramObject).a)))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label111;
          }
          paramObject = ((ct)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label111:
      return this.unknownFieldData.equals(((ct)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = this.b.hashCode();
    int n = this.a.hashCode();
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */