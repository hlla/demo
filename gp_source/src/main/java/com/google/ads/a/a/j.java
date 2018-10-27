package com.google.ads.a.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;

public final class j
  extends b
{
  public byte[] a = null;
  public byte[] b = null;
  
  public j()
  {
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    byte[] arrayOfByte = this.b;
    int i = j;
    if (arrayOfByte != null) {
      i = j + CodedOutputByteBufferNano.b(1, arrayOfByte);
    }
    arrayOfByte = this.a;
    j = i;
    if (arrayOfByte != null) {
      j = i + CodedOutputByteBufferNano.b(2, arrayOfByte);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    byte[] arrayOfByte = this.b;
    if (arrayOfByte != null) {
      paramCodedOutputByteBufferNano.a(1, arrayOfByte);
    }
    arrayOfByte = this.a;
    if (arrayOfByte != null) {
      paramCodedOutputByteBufferNano.a(2, arrayOfByte);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/ads/a/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */