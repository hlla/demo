package com.google.ads.a.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.j;

public final class n
  extends b
{
  public byte[][] a = j.c;
  public Integer b;
  public byte[] c = null;
  private Integer d;
  
  public n()
  {
    this.cachedSize = -1;
  }
  
  private final n b(a parama)
  {
    for (;;)
    {
      i = parama.a();
      switch (i)
      {
      default: 
        if (super.a(parama, i)) {}
        break;
      case 0: 
        return this;
      case 32: 
        j = parama.j();
        try
        {
          this.b = Integer.valueOf(e.c(parama.e()));
        }
        catch (IllegalArgumentException localIllegalArgumentException1)
        {
          parama.e(j);
          a(parama, i);
        }
        break;
      case 24: 
        j = parama.j();
        try
        {
          this.d = Integer.valueOf(e.b(parama.e()));
        }
        catch (IllegalArgumentException localIllegalArgumentException2)
        {
          parama.e(j);
          a(parama, i);
        }
        break;
      case 18: 
        this.c = parama.d();
      }
    }
    int j = j.a(parama, 10);
    byte[][] arrayOfByte1 = this.a;
    if (arrayOfByte1 != null) {}
    for (int i = arrayOfByte1.length;; i = 0)
    {
      byte[][] arrayOfByte2 = new byte[j + i][];
      j = i;
      if (i != 0)
      {
        System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
        j = i;
      }
      while (j < arrayOfByte2.length - 1)
      {
        arrayOfByte2[j] = parama.d();
        parama.a();
        j += 1;
      }
      arrayOfByte2[j] = parama.d();
      this.a = arrayOfByte2;
      break;
    }
  }
  
  protected final int a()
  {
    int j = 0;
    int i = super.a();
    Object localObject = this.a;
    int k;
    int m;
    if (localObject != null) {
      if (localObject.length > 0)
      {
        k = 0;
        m = 0;
        localObject = this.a;
        if (j >= localObject.length) {
          i = i + k + m;
        }
      }
    }
    for (;;)
    {
      localObject = this.c;
      j = i;
      if (localObject != null) {
        j = i + CodedOutputByteBufferNano.b(2, (byte[])localObject);
      }
      localObject = this.d;
      i = j;
      if (localObject != null) {
        i = j + CodedOutputByteBufferNano.d(3, ((Integer)localObject).intValue());
      }
      localObject = this.b;
      j = i;
      if (localObject != null) {
        j = i + CodedOutputByteBufferNano.d(4, ((Integer)localObject).intValue());
      }
      return j;
      localObject = localObject[j];
      int i1 = k;
      int n = m;
      if (localObject != null)
      {
        n = m + 1;
        i1 = k + CodedOutputByteBufferNano.a((byte[])localObject);
      }
      j += 1;
      k = i1;
      m = n;
      break;
    }
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.a;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int i;
    do
    {
      localObject = this.c;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.a(2, (byte[])localObject);
      }
      localObject = this.d;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.a(3, ((Integer)localObject).intValue());
      }
      localObject = this.b;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.a(4, ((Integer)localObject).intValue());
      }
      super.a(paramCodedOutputByteBufferNano);
      return;
      i = 0;
      localObject = this.a;
    } while (i >= localObject.length);
    localObject = localObject[i];
    if (localObject == null) {}
    for (;;)
    {
      i += 1;
      break;
      paramCodedOutputByteBufferNano.a(1, (byte[])localObject);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/ads/a/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */