package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;

public final class lh
  extends b
{
  private static volatile lh[] e;
  public String a = "";
  public int b = 0;
  public bu c = null;
  public bu d = null;
  private int f = 0;
  
  public lh()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final lh b(a parama)
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
        if (this.d == null) {
          this.d = new bu();
        }
        parama.a(this.d);
        break;
      case 26: 
        if (this.c == null) {
          this.c = new bu();
        }
        parama.a(this.c);
        break;
      case 18: 
        this.a = parama.c();
        this.f |= 0x2;
        break;
      case 8: 
        this.f |= 0x1;
        int j = parama.j();
        try
        {
          this.b = li.a(parama.e());
          this.f |= 0x1;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          parama.e(j);
          a(parama, i);
        }
      }
    }
  }
  
  public static lh[] b()
  {
    if (e == null) {}
    synchronized (f.a)
    {
      if (e == null) {
        e = new lh[0];
      }
      return e;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.f & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.d(1, this.b);
    }
    j = i;
    if ((this.f & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.a);
    }
    bu localbu = this.c;
    i = j;
    if (localbu != null) {
      i = j + CodedOutputByteBufferNano.d(3, localbu);
    }
    localbu = this.d;
    j = i;
    if (localbu != null) {
      j = i + CodedOutputByteBufferNano.d(4, localbu);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.f & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.b);
    }
    if ((this.f & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.a);
    }
    bu localbu = this.c;
    if (localbu != null) {
      paramCodedOutputByteBufferNano.b(3, localbu);
    }
    localbu = this.d;
    if (localbu != null) {
      paramCodedOutputByteBufferNano.b(4, localbu);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof lh))
      {
        paramObject = (lh)paramObject;
        int i = this.f;
        int j = ((lh)paramObject).f;
        if (((i & 0x1) == (j & 0x1)) && (this.b == ((lh)paramObject).b) && ((i & 0x2) == (j & 0x2)) && (this.a.equals(((lh)paramObject).a)))
        {
          localObject = this.c;
          if (localObject != null) {
            break label171;
          }
          if (((lh)paramObject).c != null) {}
        }
      }
      label171:
      while (((bu)localObject).equals(((lh)paramObject).c))
      {
        localObject = this.d;
        if (localObject == null) {
          if (((lh)paramObject).d != null) {}
        }
        while (((bu)localObject).equals(((lh)paramObject).d))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a()))
          {
            paramObject = ((lh)paramObject).unknownFieldData;
            return (paramObject == null) || (((d)paramObject).a());
          }
          return this.unknownFieldData.equals(((lh)paramObject).unknownFieldData);
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
    int i1 = this.b;
    int i2 = this.a.hashCode();
    Object localObject = this.c;
    if (localObject != null) {}
    for (int i = ((bu)localObject).hashCode();; i = 0)
    {
      localObject = this.d;
      if (localObject != null) {}
      for (int j = ((bu)localObject).hashCode();; j = 0)
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
        return (j + (i + (((n + 527) * 31 + i1) * 31 + i2) * 31) * 31) * 31 + k;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/lh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */