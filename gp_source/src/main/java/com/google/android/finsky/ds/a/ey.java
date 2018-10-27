package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class ey
  extends b
{
  public kp a = null;
  public kp b = null;
  public String c = "";
  private int d = 0;
  private int e = 1;
  
  public ey()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final ey b(a parama)
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
      case 34: 
        if (this.b == null) {
          this.b = new kp();
        }
        parama.a(this.b);
        break;
      case 24: 
        this.d |= 0x2;
        int j = parama.j();
        try
        {
          this.e = bg.a(parama.e());
          this.d |= 0x2;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          parama.e(j);
          a(parama, i);
        }
        break;
      case 18: 
        if (this.a == null) {
          this.a = new kp();
        }
        parama.a(this.a);
        break;
      case 10: 
        this.c = parama.c();
        this.d |= 0x1;
      }
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.d & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.c);
    }
    kp localkp = this.a;
    j = i;
    if (localkp != null) {
      j = i + CodedOutputByteBufferNano.d(2, localkp);
    }
    i = j;
    if ((this.d & 0x2) != 0) {
      i = j + CodedOutputByteBufferNano.d(3, this.e);
    }
    localkp = this.b;
    j = i;
    if (localkp != null) {
      j = i + CodedOutputByteBufferNano.d(4, localkp);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.d & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.c);
    }
    kp localkp = this.a;
    if (localkp != null) {
      paramCodedOutputByteBufferNano.b(2, localkp);
    }
    if ((this.d & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.e);
    }
    localkp = this.b;
    if (localkp != null) {
      paramCodedOutputByteBufferNano.b(4, localkp);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof ey))
      {
        paramObject = (ey)paramObject;
        if (((this.d & 0x1) == (((ey)paramObject).d & 0x1)) && (this.c.equals(((ey)paramObject).c)))
        {
          localObject = this.a;
          if (localObject != null) {
            break label165;
          }
          if (((ey)paramObject).a != null) {}
        }
      }
      label152:
      label165:
      while (((kp)localObject).equals(((ey)paramObject).a))
      {
        if (((this.d & 0x2) == (((ey)paramObject).d & 0x2)) && (this.e == ((ey)paramObject).e))
        {
          localObject = this.b;
          if (localObject != null) {
            break label152;
          }
          if (((ey)paramObject).b != null) {}
        }
        while (((kp)localObject).equals(((ey)paramObject).b))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a()))
          {
            paramObject = ((ey)paramObject).unknownFieldData;
            return (paramObject == null) || (((d)paramObject).a());
          }
          return this.unknownFieldData.equals(((ey)paramObject).unknownFieldData);
        }
        return false;
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int m = 0;
    int n = getClass().getName().hashCode();
    int i1 = this.c.hashCode();
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = ((kp)localObject).hashCode();; i = 0)
    {
      int i2 = this.e;
      localObject = this.b;
      if (localObject != null) {}
      for (int j = ((kp)localObject).hashCode();; j = 0)
      {
        localObject = this.unknownFieldData;
        int k = m;
        if (localObject != null)
        {
          k = m;
          if (!((d)localObject).a()) {
            k = this.unknownFieldData.hashCode();
          }
        }
        return (j + ((i + ((n + 527) * 31 + i1) * 31) * 31 + i2) * 31) * 31 + k;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */