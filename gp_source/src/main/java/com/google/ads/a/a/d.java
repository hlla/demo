package com.google.ads.a.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;

public final class d
  extends b
{
  public String a = null;
  public String b = null;
  private String c = null;
  private String d = null;
  private String e = null;
  private String f = null;
  
  public d()
  {
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    String str = this.a;
    int i = j;
    if (str != null) {
      i = j + CodedOutputByteBufferNano.b(1, str);
    }
    str = this.e;
    j = i;
    if (str != null) {
      j = i + CodedOutputByteBufferNano.b(2, str);
    }
    str = this.f;
    i = j;
    if (str != null) {
      i = j + CodedOutputByteBufferNano.b(3, str);
    }
    str = this.c;
    j = i;
    if (str != null) {
      j = i + CodedOutputByteBufferNano.b(4, str);
    }
    str = this.d;
    i = j;
    if (str != null) {
      i = j + CodedOutputByteBufferNano.b(5, str);
    }
    str = this.b;
    j = i;
    if (str != null) {
      j = i + CodedOutputByteBufferNano.b(6, str);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    String str = this.a;
    if (str != null) {
      paramCodedOutputByteBufferNano.a(1, str);
    }
    str = this.e;
    if (str != null) {
      paramCodedOutputByteBufferNano.a(2, str);
    }
    str = this.f;
    if (str != null) {
      paramCodedOutputByteBufferNano.a(3, str);
    }
    str = this.c;
    if (str != null) {
      paramCodedOutputByteBufferNano.a(4, str);
    }
    str = this.d;
    if (str != null) {
      paramCodedOutputByteBufferNano.a(5, str);
    }
    str = this.b;
    if (str != null) {
      paramCodedOutputByteBufferNano.a(6, str);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/ads/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */