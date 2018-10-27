package com.google.ads.a.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.j;

public final class i
  extends b
{
  private Long a = null;
  private int[] b = j.f;
  private Integer c = null;
  private Boolean d = null;
  private Long e = null;
  
  public i()
  {
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int m = 0;
    int j = super.a();
    Object localObject = this.e;
    int i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.f(1, ((Long)localObject).longValue());
    }
    localObject = this.c;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.d(2, ((Integer)localObject).intValue());
    }
    localObject = this.d;
    i = j;
    if (localObject != null)
    {
      ((Boolean)localObject).booleanValue();
      i = j + (CodedOutputByteBufferNano.d(24) + 1);
    }
    localObject = this.b;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        int k = 0;
        j = m;
        for (;;)
        {
          localObject = this.b;
          m = localObject.length;
          if (j >= m) {
            break;
          }
          k += CodedOutputByteBufferNano.b(localObject[j]);
          j += 1;
        }
        j = i + k + m;
      }
    }
    localObject = this.a;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.e(5, ((Long)localObject).longValue());
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.e;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(1, ((Long)localObject).longValue());
    }
    localObject = this.c;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.a(2, ((Integer)localObject).intValue());
    }
    localObject = this.d;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.a(3, ((Boolean)localObject).booleanValue());
    }
    localObject = this.b;
    if ((localObject == null) || (localObject.length <= 0))
    {
      localObject = this.a;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.a(5, ((Long)localObject).longValue());
      }
      super.a(paramCodedOutputByteBufferNano);
      return;
    }
    int i = 0;
    for (;;)
    {
      localObject = this.b;
      if (i >= localObject.length) {
        break;
      }
      paramCodedOutputByteBufferNano.a(4, localObject[i]);
      i += 1;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/ads/a/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */