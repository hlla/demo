package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;

public final class ft
  extends b
{
  private static volatile ft[] e;
  public aw a = null;
  public bu b = null;
  public String c = "";
  public int d = 0;
  private int f = 0;
  
  public ft()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final ft b(a parama)
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
        if (this.a == null) {
          this.a = new aw();
        }
        parama.a(this.a);
        break;
      case 26: 
        this.c = parama.c();
        this.f |= 0x2;
        break;
      case 18: 
        if (this.b == null) {
          this.b = new bu();
        }
        parama.a(this.b);
        break;
      case 8: 
        this.f |= 0x1;
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
            StringBuilder localStringBuilder = new StringBuilder(36);
            localStringBuilder.append(k);
            localStringBuilder.append(" is not a valid enum Type");
            throw new IllegalArgumentException(localStringBuilder.toString());
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            parama.e(j);
            a(parama, i);
          }
          break;
        } while (k > 3);
        this.d = k;
        this.f |= 0x1;
      }
    }
  }
  
  public static ft[] b()
  {
    if (e == null) {}
    synchronized (f.a)
    {
      if (e == null) {
        e = new ft[0];
      }
      return e;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.f & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.d(1, this.d);
    }
    Object localObject = this.b;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.d(2, (g)localObject);
    }
    i = j;
    if ((this.f & 0x2) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.c);
    }
    localObject = this.a;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.d(4, (g)localObject);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.f & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.d);
    }
    Object localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(2, (g)localObject);
    }
    if ((this.f & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.c);
    }
    localObject = this.a;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(4, (g)localObject);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof ft))
      {
        paramObject = (ft)paramObject;
        if (((this.f & 0x1) == (((ft)paramObject).f & 0x1)) && (this.d == ((ft)paramObject).d))
        {
          localObject = this.b;
          if (localObject != null) {
            break label165;
          }
          if (((ft)paramObject).b != null) {}
        }
      }
      label152:
      label165:
      while (((bu)localObject).equals(((ft)paramObject).b))
      {
        if (((this.f & 0x2) == (((ft)paramObject).f & 0x2)) && (this.c.equals(((ft)paramObject).c)))
        {
          localObject = this.a;
          if (localObject != null) {
            break label152;
          }
          if (((ft)paramObject).a != null) {}
        }
        while (((aw)localObject).equals(((ft)paramObject).a))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a()))
          {
            paramObject = ((ft)paramObject).unknownFieldData;
            return (paramObject == null) || (((d)paramObject).a());
          }
          return this.unknownFieldData.equals(((ft)paramObject).unknownFieldData);
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
    int i1 = this.d;
    Object localObject = this.b;
    if (localObject != null) {}
    for (int i = ((bu)localObject).hashCode();; i = 0)
    {
      int i2 = this.c.hashCode();
      localObject = this.a;
      if (localObject != null) {}
      for (int j = ((aw)localObject).hashCode();; j = 0)
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */