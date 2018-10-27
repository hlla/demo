package com.google.android.finsky.cv;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;

public final class a
  extends b
{
  public int a = 0;
  public int b = 0;
  public e c = null;
  public String d = "";
  
  public a()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.a & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.d);
    }
    j = i;
    if ((this.a & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.d(2, this.b);
    }
    e locale = this.c;
    i = j;
    if (locale != null) {
      i = j + CodedOutputByteBufferNano.d(3, locale);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.d);
    }
    if ((this.a & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.b);
    }
    e locale = this.c;
    if (locale != null) {
      paramCodedOutputByteBufferNano.b(3, locale);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cv/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */