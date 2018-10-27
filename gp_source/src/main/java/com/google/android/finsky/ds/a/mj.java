package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class mj
  extends b
{
  public kp a = null;
  public int b = 1;
  private int c = 0;
  
  public mj()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final mj b(a parama)
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
      case 16: 
        this.c |= 0x1;
        int j = parama.j();
        try
        {
          this.b = bg.a(parama.e());
          this.c |= 0x1;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          parama.e(j);
          a(parama, i);
        }
        break;
      case 10: 
        if (this.a == null) {
          this.a = new kp();
        }
        parama.a(this.a);
      }
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    kp localkp = this.a;
    int i = j;
    if (localkp != null) {
      i = j + CodedOutputByteBufferNano.d(1, localkp);
    }
    j = i;
    if ((this.c & 0x1) != 0) {
      j = i + CodedOutputByteBufferNano.d(2, this.b);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    kp localkp = this.a;
    if (localkp != null) {
      paramCodedOutputByteBufferNano.b(1, localkp);
    }
    if ((this.c & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.b);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof mj))
      {
        paramObject = (mj)paramObject;
        localObject = this.a;
        if (localObject != null) {
          break label107;
        }
        if (((mj)paramObject).a != null) {}
      }
      label107:
      while (((kp)localObject).equals(((mj)paramObject).a))
      {
        if (((this.c & 0x1) == (((mj)paramObject).c & 0x1)) && (this.b == ((mj)paramObject).b))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((mj)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((mj)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = ((kp)localObject).hashCode();; i = 0)
    {
      int n = this.b;
      localObject = this.unknownFieldData;
      int j = k;
      if (localObject != null)
      {
        j = k;
        if (!((d)localObject).a()) {
          j = this.unknownFieldData.hashCode();
        }
      }
      return ((i + (m + 527) * 31) * 31 + n) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/mj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */