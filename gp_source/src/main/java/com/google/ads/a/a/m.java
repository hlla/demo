package com.google.ads.a.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;

public final class m
  extends b
{
  public String a = null;
  
  public m()
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
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    String str = this.a;
    if (str != null) {
      paramCodedOutputByteBufferNano.a(1, str);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/ads/a/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */