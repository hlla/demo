package com.google.android.finsky.cv;

import com.google.android.finsky.ds.a.bu;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;

public final class d
  extends b
{
  public int a = 0;
  public bu b = null;
  public String c = "";
  public int d = -1;
  
  public d()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if (this.d == 0) {
      i = j + CodedOutputByteBufferNano.d(1, this.a);
    }
    j = i;
    if (this.d == 1) {
      j = i + CodedOutputByteBufferNano.d(2, this.b);
    }
    i = j;
    if (this.d == 2) {
      i = j + CodedOutputByteBufferNano.b(3, this.c);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.d == 0) {
      paramCodedOutputByteBufferNano.a(1, this.a);
    }
    if (this.d == 1) {
      paramCodedOutputByteBufferNano.b(2, this.b);
    }
    if (this.d == 2) {
      paramCodedOutputByteBufferNano.a(3, this.c);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cv/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */