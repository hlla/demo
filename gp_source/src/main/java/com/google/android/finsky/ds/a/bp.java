package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;

public final class bp
  extends b
{
  private static volatile bp[] d;
  public int a = 0;
  public String b = "";
  public int c = 1;
  
  public bp()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final bp b(a parama)
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
      case 24: 
        j = parama.j();
        try
        {
          this.a = bn.a(parama.e());
        }
        catch (IllegalArgumentException localIllegalArgumentException1)
        {
          parama.e(j);
          a(parama, i);
        }
        break;
      case 16: 
        j = parama.j();
        try
        {
          this.c = bq.a(parama.e());
        }
        catch (IllegalArgumentException localIllegalArgumentException2)
        {
          parama.e(j);
          a(parama, i);
        }
        break;
      case 10: 
        this.b = parama.c();
      }
    }
  }
  
  public static bp[] b()
  {
    if (d == null) {}
    synchronized (f.a)
    {
      if (d == null) {
        d = new bp[0];
      }
      return d;
    }
  }
  
  protected final int a()
  {
    return super.a() + CodedOutputByteBufferNano.b(1, this.b) + CodedOutputByteBufferNano.d(2, this.c) + CodedOutputByteBufferNano.d(3, this.a);
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.a(1, this.b);
    paramCodedOutputByteBufferNano.a(2, this.c);
    paramCodedOutputByteBufferNano.a(3, this.a);
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof bp))
      {
        paramObject = (bp)paramObject;
        localObject = this.b;
        if (localObject != null) {
          break label103;
        }
        if (((bp)paramObject).b != null) {}
      }
      label103:
      while (((String)localObject).equals(((bp)paramObject).b))
      {
        if ((this.c == ((bp)paramObject).c) && (this.a == ((bp)paramObject).a))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((bp)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((bp)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    Object localObject = this.b;
    if (localObject != null) {}
    for (int i = ((String)localObject).hashCode();; i = 0)
    {
      int n = this.c;
      int i1 = this.a;
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */