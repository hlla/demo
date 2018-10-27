package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.j;
import java.util.Arrays;

public final class et
  extends b
{
  public int a = 0;
  public int b = 0;
  public byte[] c = j.b;
  public bp d = null;
  public String e = "";
  public int f = 1;
  
  public et()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final et b(a parama)
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
        this.c = parama.d();
        this.a |= 0x8;
        break;
      case 32: 
        this.a |= 0x4;
        j = parama.j();
        try
        {
          this.b = bj.a(parama.e());
          this.a |= 0x4;
        }
        catch (IllegalArgumentException localIllegalArgumentException1)
        {
          parama.e(j);
          a(parama, i);
        }
        break;
      case 26: 
        this.e = parama.c();
        this.a |= 0x2;
        break;
      case 16: 
        this.a |= 0x1;
        j = parama.j();
        try
        {
          this.f = cb.a(parama.e());
          this.a |= 0x1;
        }
        catch (IllegalArgumentException localIllegalArgumentException2)
        {
          parama.e(j);
          a(parama, i);
        }
        break;
      case 10: 
        if (this.d == null) {
          this.d = new bp();
        }
        parama.a(this.d);
      }
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    bp localbp = this.d;
    int i = j;
    if (localbp != null) {
      i = j + CodedOutputByteBufferNano.d(1, localbp);
    }
    j = i;
    if ((this.a & 0x1) != 0) {
      j = i + CodedOutputByteBufferNano.d(2, this.f);
    }
    i = j;
    if ((this.a & 0x2) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.e);
    }
    j = i;
    if ((this.a & 0x4) != 0) {
      j = i + CodedOutputByteBufferNano.d(4, this.b);
    }
    i = j;
    if ((this.a & 0x8) != 0) {
      i = j + CodedOutputByteBufferNano.b(5, this.c);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    bp localbp = this.d;
    if (localbp != null) {
      paramCodedOutputByteBufferNano.b(1, localbp);
    }
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.f);
    }
    if ((this.a & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.e);
    }
    if ((this.a & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.b);
    }
    if ((this.a & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.c);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof et))
      {
        paramObject = (et)paramObject;
        localObject = this.d;
        if (localObject != null) {
          break label194;
        }
        if (((et)paramObject).d != null) {}
      }
      label182:
      label194:
      while (((bp)localObject).equals(((et)paramObject).d))
      {
        int i = this.a;
        int j = ((et)paramObject).a;
        if (((i & 0x1) == (j & 0x1)) && (this.f == ((et)paramObject).f) && ((i & 0x2) == (j & 0x2)) && (this.e.equals(((et)paramObject).e)))
        {
          i = this.a;
          j = ((et)paramObject).a;
          if (((i & 0x4) == (j & 0x4)) && (this.b == ((et)paramObject).b) && ((i & 0x8) == (j & 0x8)) && (Arrays.equals(this.c, ((et)paramObject).c)))
          {
            localObject = this.unknownFieldData;
            if ((localObject != null) && (!((d)localObject).a())) {
              break label182;
            }
            paramObject = ((et)paramObject).unknownFieldData;
          }
        }
        return (paramObject == null) || (((d)paramObject).a());
        return this.unknownFieldData.equals(((et)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    Object localObject = this.d;
    if (localObject != null) {}
    for (int i = ((bp)localObject).hashCode();; i = 0)
    {
      int n = this.f;
      int i1 = this.e.hashCode();
      int i2 = this.b;
      int i3 = Arrays.hashCode(this.c);
      localObject = this.unknownFieldData;
      int j = k;
      if (localObject != null)
      {
        j = k;
        if (!((d)localObject).a()) {
          j = this.unknownFieldData.hashCode();
        }
      }
      return (((((i + (m + 527) * 31) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/et.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */