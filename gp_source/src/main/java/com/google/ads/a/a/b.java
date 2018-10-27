package com.google.ads.a.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.g;

public final class b
  extends com.google.protobuf.nano.b
{
  public c a = null;
  public d b = null;
  
  public b()
  {
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    Object localObject = this.a;
    int i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(1, (g)localObject);
    }
    localObject = this.b;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.d(2, (g)localObject);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.a;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(1, (g)localObject);
    }
    localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(2, (g)localObject);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/ads/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */