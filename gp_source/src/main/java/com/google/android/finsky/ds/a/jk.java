package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class jk
  extends b
{
  public String a = "";
  public int b = 1;
  public String c = "";
  private int d = 0;
  private String e = "";
  private String f = "";
  
  public jk()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final jk b(a parama)
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
        this.e = parama.c();
        this.d |= 0x10;
        break;
      case 32: 
        this.d |= 0x8;
        int j = parama.j();
        try
        {
          this.b = cb.a(parama.e());
          this.d |= 0x8;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          parama.e(j);
          a(parama, i);
        }
        break;
      case 26: 
        this.f = parama.c();
        this.d |= 0x4;
        break;
      case 18: 
        this.c = parama.c();
        this.d |= 0x2;
        break;
      case 10: 
        this.a = parama.c();
        this.d |= 0x1;
      }
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.d & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.a);
    }
    j = i;
    if ((this.d & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.c);
    }
    i = j;
    if ((this.d & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.f);
    }
    j = i;
    if ((this.d & 0x8) != 0) {
      j = i + CodedOutputByteBufferNano.d(4, this.b);
    }
    i = j;
    if ((this.d & 0x10) != 0) {
      i = j + CodedOutputByteBufferNano.b(5, this.e);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.d & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.a);
    }
    if ((this.d & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.c);
    }
    if ((this.d & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.f);
    }
    if ((this.d & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.b);
    }
    if ((this.d & 0x10) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.e);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof jk))
      {
        paramObject = (jk)paramObject;
        if (((this.d & 0x1) == (((jk)paramObject).d & 0x1)) && (this.a.equals(((jk)paramObject).a)) && ((this.d & 0x2) == (((jk)paramObject).d & 0x2)) && (this.c.equals(((jk)paramObject).c)) && ((this.d & 0x4) == (((jk)paramObject).d & 0x4)) && (this.f.equals(((jk)paramObject).f)))
        {
          int i = this.d;
          int j = ((jk)paramObject).d;
          if (((i & 0x8) == (j & 0x8)) && (this.b == ((jk)paramObject).b) && ((i & 0x10) == (j & 0x10)) && (this.e.equals(((jk)paramObject).e)))
          {
            d locald = this.unknownFieldData;
            if ((locald != null) && (!locald.a())) {
              break label200;
            }
            paramObject = ((jk)paramObject).unknownFieldData;
          }
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label200:
      return this.unknownFieldData.equals(((jk)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = this.a.hashCode();
    int n = this.c.hashCode();
    int i1 = this.f.hashCode();
    int i2 = this.b;
    int i3 = this.e.hashCode();
    d locald = this.unknownFieldData;
    int i = j;
    if (locald != null)
    {
      i = j;
      if (!locald.a()) {
        i = this.unknownFieldData.hashCode();
      }
    }
    return i + ((((((k + 527) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/jk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */