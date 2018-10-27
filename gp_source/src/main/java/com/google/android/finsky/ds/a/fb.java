package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;

public final class fb
  extends b
{
  private static volatile fb[] e;
  public int a = 0;
  public jt b = null;
  public int c = 0;
  public String d = "";
  private String f = "";
  private int g = -1;
  private int h;
  
  public fb()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final fb b(a parama)
  {
    for (;;)
    {
      int i = parama.a();
      int j;
      switch (i)
      {
      default: 
        if (super.a(parama, i)) {}
        break;
      case 0: 
        return this;
      case 42: 
        this.f = parama.c();
        this.g = 1;
        break;
      case 32: 
        this.g = 0;
        j = parama.j();
        int k;
        do
        {
          try
          {
            k = parama.e();
            if (k >= 0) {
              continue;
            }
            StringBuilder localStringBuilder = new StringBuilder(34);
            localStringBuilder.append(k);
            localStringBuilder.append(" is not a valid enum Id");
            throw new IllegalArgumentException(localStringBuilder.toString());
          }
          catch (IllegalArgumentException localIllegalArgumentException1)
          {
            parama.e(j);
            a(parama, i);
          }
          break;
        } while (k > 5);
        this.h = k;
        this.a |= 0x4;
        break;
      case 24: 
        this.a |= 0x2;
        j = parama.j();
        try
        {
          this.c = bn.a(parama.e());
          this.a |= 0x2;
        }
        catch (IllegalArgumentException localIllegalArgumentException2)
        {
          parama.e(j);
          a(parama, i);
        }
        break;
      case 18: 
        if (this.b == null) {
          this.b = new jt();
        }
        parama.a(this.b);
        break;
      case 10: 
        this.d = parama.c();
        this.a |= 0x1;
      }
    }
  }
  
  public static fb[] b()
  {
    if (e == null) {}
    synchronized (f.a)
    {
      if (e == null) {
        e = new fb[0];
      }
      return e;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.a & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.d);
    }
    jt localjt = this.b;
    j = i;
    if (localjt != null) {
      j = i + CodedOutputByteBufferNano.d(2, localjt);
    }
    i = j;
    if ((this.a & 0x2) != 0) {
      i = j + CodedOutputByteBufferNano.d(3, this.c);
    }
    j = i;
    if (this.g == 0) {
      j = i + CodedOutputByteBufferNano.d(4, this.h);
    }
    i = j;
    if (this.g == 1) {
      i = j + CodedOutputByteBufferNano.b(5, this.f);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.d);
    }
    jt localjt = this.b;
    if (localjt != null) {
      paramCodedOutputByteBufferNano.b(2, localjt);
    }
    if ((this.a & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.c);
    }
    if (this.g == 0) {
      paramCodedOutputByteBufferNano.a(4, this.h);
    }
    if (this.g == 1) {
      paramCodedOutputByteBufferNano.a(5, this.f);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final int c()
  {
    if (this.g == 0) {
      return this.h;
    }
    return 0;
  }
  
  public final String d()
  {
    if (this.g != 1) {
      return "";
    }
    return this.f;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof fb))
      {
        paramObject = (fb)paramObject;
        if (((this.a & 0x1) == (((fb)paramObject).a & 0x1)) && (this.d.equals(((fb)paramObject).d)))
        {
          localObject = this.b;
          if (localObject != null) {
            break label195;
          }
          if (((fb)paramObject).b != null) {}
        }
      }
      label183:
      label195:
      while (((jt)localObject).equals(((fb)paramObject).b))
      {
        if (((this.a & 0x2) == (((fb)paramObject).a & 0x2)) && (this.c == ((fb)paramObject).c))
        {
          int i = this.g;
          int j = ((fb)paramObject).g;
          if ((i == j) && ((i != 0) || (this.h == ((fb)paramObject).h)) && (i == j) && ((i != 1) || (this.f.equals(((fb)paramObject).f))))
          {
            localObject = this.unknownFieldData;
            if ((localObject != null) && (!((d)localObject).a())) {
              break label183;
            }
            paramObject = ((fb)paramObject).unknownFieldData;
          }
        }
        return (paramObject == null) || (((d)paramObject).a());
        return this.unknownFieldData.equals(((fb)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int m = 0;
    int n = getClass().getName().hashCode();
    int i1 = this.d.hashCode();
    Object localObject = this.b;
    if (localObject != null) {}
    for (int i = ((jt)localObject).hashCode();; i = 0)
    {
      int i2 = this.c;
      int j = this.h;
      int k = this.g;
      if (k != 0) {
        j = 0;
      }
      localObject = this.f;
      if (k != 1) {
        localObject = "";
      }
      int i3 = ((String)localObject).hashCode();
      localObject = this.unknownFieldData;
      k = m;
      if (localObject != null)
      {
        k = m;
        if (!((d)localObject).a()) {
          k = this.unknownFieldData.hashCode();
        }
      }
      return (i3 + ((i2 + (i + ((n + 527) * 31 + i1) * 31) * 31) * 31 + j) * 31) * 31 + k;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/fb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */