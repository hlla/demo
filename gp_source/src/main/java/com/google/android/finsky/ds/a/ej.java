package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class ej
  extends b
{
  private int a = 0;
  private long b = 0L;
  private bt c = null;
  private int d = 1;
  
  public ej()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final ej b(a parama)
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
      case 26: 
        if (this.c == null) {
          this.c = new bt();
        }
        parama.a(this.c);
        break;
      case 17: 
        this.b = parama.h();
        this.a |= 0x2;
        break;
      case 8: 
        this.a |= 0x1;
        int j = parama.j();
        try
        {
          this.d = cb.a(parama.e());
          this.a |= 0x1;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          parama.e(j);
          a(parama, i);
        }
      }
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.a & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.d(1, this.d);
    }
    j = i;
    if ((this.a & 0x2) != 0) {
      j = i + (CodedOutputByteBufferNano.d(16) + 8);
    }
    bt localbt = this.c;
    i = j;
    if (localbt != null) {
      i = j + CodedOutputByteBufferNano.d(3, localbt);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.d);
    }
    if ((this.a & 0x2) != 0) {
      paramCodedOutputByteBufferNano.c(2, this.b);
    }
    bt localbt = this.c;
    if (localbt != null) {
      paramCodedOutputByteBufferNano.b(3, localbt);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof ej))
      {
        paramObject = (ej)paramObject;
        int i = this.a;
        int j = ((ej)paramObject).a;
        if (((i & 0x1) == (j & 0x1)) && (this.d == ((ej)paramObject).d) && ((i & 0x2) == (j & 0x2)) && (this.b == ((ej)paramObject).b))
        {
          localObject = this.c;
          if (localObject != null) {
            break label137;
          }
          if (((ej)paramObject).c != null) {}
        }
      }
      label137:
      while (((bt)localObject).equals(((ej)paramObject).c))
      {
        localObject = this.unknownFieldData;
        if ((localObject == null) || (((d)localObject).a()))
        {
          paramObject = ((ej)paramObject).unknownFieldData;
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((ej)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int n = this.d;
    long l = this.b;
    Object localObject = this.c;
    int i1 = (int)(l ^ l >>> 32);
    if (localObject != null) {}
    for (int i = ((bt)localObject).hashCode();; i = 0)
    {
      localObject = this.unknownFieldData;
      int j = k;
      if (localObject != null)
      {
        j = k;
        if (!((d)localObject).a()) {
          j = this.unknownFieldData.hashCode();
        }
      }
      return (i + (((m + 527) * 31 + n) * 31 + i1) * 31) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */