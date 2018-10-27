package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;

public final class hd
  extends b
{
  private static volatile hd[] d;
  public hg a = null;
  public long b = 0L;
  public int c = 0;
  private int e = 0;
  
  public hd()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final hd b(a parama)
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
      case 24: 
        this.e |= 0x2;
        int j = parama.j();
        try
        {
          this.c = hh.a(parama.e());
          this.e |= 0x2;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          parama.e(j);
          a(parama, i);
        }
        break;
      case 16: 
        this.b = parama.f();
        this.e |= 0x1;
        break;
      case 10: 
        if (this.a == null) {
          this.a = new hg();
        }
        parama.a(this.a);
      }
    }
  }
  
  public static hd[] b()
  {
    if (d == null) {}
    synchronized (f.a)
    {
      if (d == null) {
        d = new hd[0];
      }
      return d;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    hg localhg = this.a;
    int i = j;
    if (localhg != null) {
      i = j + CodedOutputByteBufferNano.d(1, localhg);
    }
    j = i;
    if ((this.e & 0x1) != 0) {
      j = i + CodedOutputByteBufferNano.f(2, this.b);
    }
    i = j;
    if ((this.e & 0x2) != 0) {
      i = j + CodedOutputByteBufferNano.d(3, this.c);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    hg localhg = this.a;
    if (localhg != null) {
      paramCodedOutputByteBufferNano.b(1, localhg);
    }
    if ((this.e & 0x1) != 0) {
      paramCodedOutputByteBufferNano.b(2, this.b);
    }
    if ((this.e & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.c);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof hd))
      {
        paramObject = (hd)paramObject;
        localObject = this.a;
        if (localObject != null) {
          break label137;
        }
        if (((hd)paramObject).a != null) {}
      }
      label137:
      while (((hg)localObject).equals(((hd)paramObject).a))
      {
        int i = this.e;
        int j = ((hd)paramObject).e;
        if (((i & 0x1) == (j & 0x1)) && (this.b == ((hd)paramObject).b) && ((i & 0x2) == (j & 0x2)) && (this.c == ((hd)paramObject).c))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((hd)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((hd)paramObject).unknownFieldData);
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
    for (int i = ((hg)localObject).hashCode();; i = 0)
    {
      long l = this.b;
      int n = (int)(l >>> 32 ^ l);
      int i1 = this.c;
      localObject = this.unknownFieldData;
      int j = k;
      if (localObject != null)
      {
        j = k;
        if (!((d)localObject).a()) {
          j = this.unknownFieldData.hashCode();
        }
      }
      return (((i + (m + 527) * 31) * 31 + n) * 31 + i1) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/hd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */