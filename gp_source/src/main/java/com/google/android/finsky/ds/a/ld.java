package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;

public final class ld
  extends b
{
  private static volatile ld[] d;
  public String a = "";
  public int b = 0;
  public int c = 0;
  private int e = 0;
  
  public ld()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final ld b(a parama)
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
        this.b = parama.e();
        this.e |= 0x4;
        break;
      case 16: 
        this.e |= 0x2;
        int j = parama.j();
        try
        {
          this.c = li.a(parama.e());
          this.e |= 0x2;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          parama.e(j);
          a(parama, i);
        }
        break;
      case 10: 
        this.a = parama.c();
        this.e |= 0x1;
      }
    }
  }
  
  public static ld[] b()
  {
    if (d == null) {}
    synchronized (f.a)
    {
      if (d == null) {
        d = new ld[0];
      }
      return d;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.e & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.a);
    }
    j = i;
    if ((this.e & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.d(2, this.c);
    }
    i = j;
    if ((this.e & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.d(3, this.b);
    }
    return i;
  }
  
  public final ld a(int paramInt)
  {
    this.c = paramInt;
    this.e |= 0x2;
    return this;
  }
  
  public final ld a(String paramString)
  {
    if (paramString != null)
    {
      this.e |= 0x1;
      this.a = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.e & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.a);
    }
    if ((this.e & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.c);
    }
    if ((this.e & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.b);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final ld b(int paramInt)
  {
    this.e |= 0x4;
    this.b = paramInt;
    return this;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof ld))
      {
        paramObject = (ld)paramObject;
        if (((this.e & 0x1) == (((ld)paramObject).e & 0x1)) && (this.a.equals(((ld)paramObject).a)))
        {
          int i = this.e;
          int j = ((ld)paramObject).e;
          if (((i & 0x2) == (j & 0x2)) && (this.c == ((ld)paramObject).c) && ((i & 0x4) == (j & 0x4)) && (this.b == ((ld)paramObject).b))
          {
            d locald = this.unknownFieldData;
            if ((locald != null) && (!locald.a())) {
              break label135;
            }
            paramObject = ((ld)paramObject).unknownFieldData;
          }
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label135:
      return this.unknownFieldData.equals(((ld)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = this.a.hashCode();
    int n = this.c;
    int i1 = this.b;
    d locald = this.unknownFieldData;
    int i = j;
    if (locald != null)
    {
      i = j;
      if (!locald.a()) {
        i = this.unknownFieldData.hashCode();
      }
    }
    return i + ((((k + 527) * 31 + m) * 31 + n) * 31 + i1) * 31;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */