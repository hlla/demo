package com.google.ads.a.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;

public final class h
  extends b
{
  public Long a = null;
  public Long b = null;
  public Long c = null;
  private Long d = null;
  private Long e = null;
  
  public h()
  {
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    Long localLong = this.d;
    int i = j;
    if (localLong != null) {
      i = j + CodedOutputByteBufferNano.f(1, localLong.longValue());
    }
    localLong = this.e;
    j = i;
    if (localLong != null) {
      j = i + CodedOutputByteBufferNano.f(2, localLong.longValue());
    }
    localLong = this.a;
    i = j;
    if (localLong != null) {
      i = j + CodedOutputByteBufferNano.f(3, localLong.longValue());
    }
    localLong = this.b;
    j = i;
    if (localLong != null) {
      j = i + CodedOutputByteBufferNano.f(4, localLong.longValue());
    }
    localLong = this.c;
    i = j;
    if (localLong != null) {
      i = j + CodedOutputByteBufferNano.f(5, localLong.longValue());
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Long localLong = this.d;
    if (localLong != null) {
      paramCodedOutputByteBufferNano.b(1, localLong.longValue());
    }
    localLong = this.e;
    if (localLong != null) {
      paramCodedOutputByteBufferNano.b(2, localLong.longValue());
    }
    localLong = this.a;
    if (localLong != null) {
      paramCodedOutputByteBufferNano.b(3, localLong.longValue());
    }
    localLong = this.b;
    if (localLong != null) {
      paramCodedOutputByteBufferNano.b(4, localLong.longValue());
    }
    localLong = this.c;
    if (localLong != null) {
      paramCodedOutputByteBufferNano.b(5, localLong.longValue());
    }
    super.a(paramCodedOutputByteBufferNano);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/ads/a/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */