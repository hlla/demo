package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;
import com.google.wireless.android.finsky.dfe.q.dk;

public final class ip
  extends b
{
  private static volatile ip[] f;
  public iq a = null;
  public String b = "";
  public bu c = null;
  public String d = "";
  public String e = "";
  private int g = 0;
  private Integer h;
  
  public ip()
  {
    if (dk.b != null) {}
    for (Integer localInteger = Integer.valueOf(dk.b.c);; localInteger = null)
    {
      this.h = localInteger;
      this.unknownFieldData = null;
      this.cachedSize = -1;
      return;
    }
  }
  
  public static ip[] b()
  {
    if (f == null) {}
    synchronized (f.a)
    {
      if (f == null) {
        f = new ip[0];
      }
      return f;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.g & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.e);
    }
    j = i;
    if ((this.g & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.d);
    }
    i = j;
    if ((this.g & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.b);
    }
    Object localObject = this.c;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.d(4, (g)localObject);
    }
    localObject = this.a;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(6, (g)localObject);
    }
    j = i;
    if ((this.g & 0x8) != 0)
    {
      localObject = this.h;
      j = i;
      if (localObject != null) {
        j = i + CodedOutputByteBufferNano.d(7, ((Integer)localObject).intValue());
      }
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.g & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.e);
    }
    if ((this.g & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.d);
    }
    if ((this.g & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.b);
    }
    Object localObject = this.c;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(4, (g)localObject);
    }
    localObject = this.a;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(6, (g)localObject);
    }
    if ((this.g & 0x8) != 0)
    {
      localObject = this.h;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.a(7, ((Integer)localObject).intValue());
      }
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final dk c()
  {
    Integer localInteger = this.h;
    if (localInteger == null) {
      return dk.b;
    }
    return dk.a(localInteger.intValue());
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof ip))
      {
        paramObject = (ip)paramObject;
        if (((this.g & 0x1) == (((ip)paramObject).g & 0x1)) && (this.e.equals(((ip)paramObject).e)) && ((this.g & 0x2) == (((ip)paramObject).g & 0x2)) && (this.d.equals(((ip)paramObject).d)) && ((this.g & 0x4) == (((ip)paramObject).g & 0x4)) && (this.b.equals(((ip)paramObject).b)))
        {
          localObject = this.c;
          if (localObject != null) {
            break label225;
          }
          if (((ip)paramObject).c != null) {}
        }
      }
      label225:
      while (((bu)localObject).equals(((ip)paramObject).c))
      {
        localObject = this.a;
        if (localObject == null) {
          if (((ip)paramObject).a != null) {}
        }
        while (((iq)localObject).equals(((ip)paramObject).a))
        {
          if (((this.g & 0x8) == (((ip)paramObject).g & 0x8)) && (this.h == ((ip)paramObject).h))
          {
            localObject = this.unknownFieldData;
            if ((localObject == null) || (((d)localObject).a())) {
              paramObject = ((ip)paramObject).unknownFieldData;
            }
          }
          else
          {
            return (paramObject == null) || (((d)paramObject).a());
          }
          return this.unknownFieldData.equals(((ip)paramObject).unknownFieldData);
        }
        return false;
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int n = this.e.hashCode();
    int i1 = this.d.hashCode();
    int i2 = this.b.hashCode();
    Object localObject = this.c;
    if (localObject != null) {}
    for (int i = ((bu)localObject).hashCode();; i = 0)
    {
      localObject = this.a;
      if (localObject != null) {}
      for (int j = ((iq)localObject).hashCode();; j = 0)
      {
        j += (i + ((((m + 527) * 31 + n) * 31 + i1) * 31 + i2) * 31) * 31;
        localObject = this.h;
        i = j;
        if (localObject != null) {
          i = j * 31 + ((Integer)localObject).intValue();
        }
        localObject = this.unknownFieldData;
        j = k;
        if (localObject != null)
        {
          j = k;
          if (!((d)localObject).a()) {
            j = this.unknownFieldData.hashCode();
          }
        }
        return i * 31 + j;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */