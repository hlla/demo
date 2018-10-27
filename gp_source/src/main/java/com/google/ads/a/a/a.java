package com.google.ads.a.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;

public final class a
  extends b
{
  public String a = null;
  public Long b = null;
  private String c = null;
  private Long d = null;
  private String e = null;
  private String f = null;
  private String g = null;
  private Long h = null;
  private Long i = null;
  private String j = null;
  
  public a()
  {
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int m = super.a();
    Object localObject = this.a;
    int k = m;
    if (localObject != null) {
      k = m + CodedOutputByteBufferNano.b(1, (String)localObject);
    }
    localObject = this.b;
    m = k;
    if (localObject != null) {
      m = k + CodedOutputByteBufferNano.f(2, ((Long)localObject).longValue());
    }
    localObject = this.j;
    k = m;
    if (localObject != null) {
      k = m + CodedOutputByteBufferNano.b(3, (String)localObject);
    }
    localObject = this.g;
    m = k;
    if (localObject != null) {
      m = k + CodedOutputByteBufferNano.b(4, (String)localObject);
    }
    localObject = this.f;
    k = m;
    if (localObject != null) {
      k = m + CodedOutputByteBufferNano.b(5, (String)localObject);
    }
    localObject = this.i;
    m = k;
    if (localObject != null) {
      m = k + CodedOutputByteBufferNano.f(6, ((Long)localObject).longValue());
    }
    localObject = this.h;
    k = m;
    if (localObject != null) {
      k = m + CodedOutputByteBufferNano.f(7, ((Long)localObject).longValue());
    }
    localObject = this.e;
    m = k;
    if (localObject != null) {
      m = k + CodedOutputByteBufferNano.b(8, (String)localObject);
    }
    localObject = this.d;
    k = m;
    if (localObject != null) {
      k = m + CodedOutputByteBufferNano.f(9, ((Long)localObject).longValue());
    }
    localObject = this.c;
    m = k;
    if (localObject != null) {
      m = k + CodedOutputByteBufferNano.b(10, (String)localObject);
    }
    return m;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.a;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.a(1, (String)localObject);
    }
    localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(2, ((Long)localObject).longValue());
    }
    localObject = this.j;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.a(3, (String)localObject);
    }
    localObject = this.g;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.a(4, (String)localObject);
    }
    localObject = this.f;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.a(5, (String)localObject);
    }
    localObject = this.i;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(6, ((Long)localObject).longValue());
    }
    localObject = this.h;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(7, ((Long)localObject).longValue());
    }
    localObject = this.e;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.a(8, (String)localObject);
    }
    localObject = this.d;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(9, ((Long)localObject).longValue());
    }
    localObject = this.c;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.a(10, (String)localObject);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/ads/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */