package com.google.ads.a.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;

public final class c
  extends b
{
  public Integer a;
  
  public c()
  {
    this.cachedSize = -1;
  }
  
  private final c b(a parama)
  {
    for (;;)
    {
      int i = parama.a();
      switch (i)
      {
      default: 
        if (super.a(parama, i)) {}
        break;
      case 0: 
        return this;
      case 216: 
        int j = parama.j();
        int k;
        do
        {
          try
          {
            k = parama.e();
            if (k >= 0) {
              continue;
            }
            StringBuilder localStringBuilder = new StringBuilder(48);
            localStringBuilder.append(k);
            localStringBuilder.append(" is not a valid enum EnumSignalSource");
            throw new IllegalArgumentException(localStringBuilder.toString());
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            parama.e(j);
            a(parama, i);
          }
          break;
        } while (k > 4);
        this.a = Integer.valueOf(k);
      }
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    Integer localInteger = this.a;
    int i = j;
    if (localInteger != null) {
      i = j + CodedOutputByteBufferNano.d(27, localInteger.intValue());
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Integer localInteger = this.a;
    if (localInteger != null) {
      paramCodedOutputByteBufferNano.a(27, localInteger.intValue());
    }
    super.a(paramCodedOutputByteBufferNano);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/ads/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */