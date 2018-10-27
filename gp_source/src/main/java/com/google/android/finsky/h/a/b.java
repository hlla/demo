package com.google.android.finsky.h.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;

public final class b
  extends com.google.protobuf.nano.b
{
  public int a = 0;
  public long b = 0L;
  public long c = 0L;
  public long d = 0L;
  public String e = "";
  public long f = 0L;
  
  public b()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.a & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.e);
    }
    j = i;
    if ((this.a & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.f(2, this.b);
    }
    i = j;
    if ((this.a & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.f(3, this.c);
    }
    j = i;
    if ((this.a & 0x8) != 0) {
      j = i + CodedOutputByteBufferNano.f(4, this.d);
    }
    i = j;
    if ((this.a & 0x10) != 0) {
      i = j + CodedOutputByteBufferNano.f(5, this.f);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.e);
    }
    if ((this.a & 0x2) != 0) {
      paramCodedOutputByteBufferNano.b(2, this.b);
    }
    if ((this.a & 0x4) != 0) {
      paramCodedOutputByteBufferNano.b(3, this.c);
    }
    if ((this.a & 0x8) != 0) {
      paramCodedOutputByteBufferNano.b(4, this.d);
    }
    if ((this.a & 0x10) != 0) {
      paramCodedOutputByteBufferNano.b(5, this.f);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/h/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */