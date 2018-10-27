package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;

public final class as
  extends b
{
  private static volatile as[] g;
  public int a = 0;
  public bu b = null;
  public String c = "";
  public String d = "";
  public fb e = null;
  public int f = 1;
  
  public as()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final as b(a parama)
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
      case 42: 
        if (this.e == null) {
          this.e = new fb();
        }
        parama.a(this.e);
        break;
      case 34: 
        this.d = parama.c();
        this.a |= 0x4;
        break;
      case 26: 
        if (this.b == null) {
          this.b = new bu();
        }
        parama.a(this.b);
        break;
      case 18: 
        this.c = parama.c();
        this.a |= 0x2;
        break;
      case 8: 
        this.a |= 0x1;
        int j = parama.j();
        int k;
        do
        {
          try
          {
            k = parama.e();
            if (k > 0) {
              continue;
            }
            StringBuilder localStringBuilder = new StringBuilder(34);
            localStringBuilder.append(k);
            localStringBuilder.append(" is not a valid enum Id");
            throw new IllegalArgumentException(localStringBuilder.toString());
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            parama.e(j);
            a(parama, i);
          }
          break;
        } while (k > 3);
        this.f = k;
        this.a |= 0x1;
      }
    }
  }
  
  public static as[] b()
  {
    if (g == null) {}
    synchronized (f.a)
    {
      if (g == null) {
        g = new as[0];
      }
      return g;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.a & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.d(1, this.f);
    }
    j = i;
    if ((this.a & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.c);
    }
    Object localObject = this.b;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(3, (g)localObject);
    }
    j = i;
    if ((this.a & 0x4) != 0) {
      j = i + CodedOutputByteBufferNano.b(4, this.d);
    }
    localObject = this.e;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(5, (g)localObject);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.f);
    }
    if ((this.a & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.c);
    }
    Object localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(3, (g)localObject);
    }
    if ((this.a & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.d);
    }
    localObject = this.e;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(5, (g)localObject);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof as))
      {
        paramObject = (as)paramObject;
        int i = this.a;
        int j = ((as)paramObject).a;
        if (((i & 0x1) == (j & 0x1)) && (this.f == ((as)paramObject).f) && ((i & 0x2) == (j & 0x2)) && (this.c.equals(((as)paramObject).c)))
        {
          localObject = this.b;
          if (localObject != null) {
            break label200;
          }
          if (((as)paramObject).b != null) {}
        }
      }
      label186:
      label200:
      while (((bu)localObject).equals(((as)paramObject).b))
      {
        if (((this.a & 0x4) == (((as)paramObject).a & 0x4)) && (this.d.equals(((as)paramObject).d)))
        {
          localObject = this.e;
          if (localObject != null) {
            break label186;
          }
          if (((as)paramObject).e != null) {}
        }
        while (((fb)localObject).equals(((as)paramObject).e))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a()))
          {
            paramObject = ((as)paramObject).unknownFieldData;
            return (paramObject == null) || (((d)paramObject).a());
          }
          return this.unknownFieldData.equals(((as)paramObject).unknownFieldData);
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
    int i1 = this.f;
    int i2 = this.c.hashCode();
    Object localObject = this.b;
    if (localObject != null) {}
    for (int i = ((bu)localObject).hashCode();; i = 0)
    {
      int i3 = this.d.hashCode();
      localObject = this.e;
      if (localObject != null) {}
      for (int j = ((fb)localObject).hashCode();; j = 0)
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
        return (j + ((i + (((n + 527) * 31 + i1) * 31 + i2) * 31) * 31 + i3) * 31) * 31 + k;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */