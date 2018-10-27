package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.g;

public final class er
  extends b
{
  public String a = "";
  public String b = "";
  public String c = "";
  public bu d = null;
  public fb e = null;
  private int f = 0;
  
  public er()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    Object localObject = this.d;
    int i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(1, (g)localObject);
    }
    j = i;
    if ((this.f & 0x1) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.a);
    }
    i = j;
    if ((this.f & 0x2) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.c);
    }
    j = i;
    if ((this.f & 0x4) != 0) {
      j = i + CodedOutputByteBufferNano.b(4, this.b);
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
    Object localObject = this.d;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(1, (g)localObject);
    }
    if ((this.f & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.a);
    }
    if ((this.f & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.c);
    }
    if ((this.f & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.b);
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
      if ((paramObject instanceof er))
      {
        paramObject = (er)paramObject;
        localObject = this.d;
        if (localObject != null) {
          break label197;
        }
        if (((er)paramObject).d != null) {}
      }
      label184:
      label197:
      while (((bu)localObject).equals(((er)paramObject).d))
      {
        if (((this.f & 0x1) == (((er)paramObject).f & 0x1)) && (this.a.equals(((er)paramObject).a)) && ((this.f & 0x2) == (((er)paramObject).f & 0x2)) && (this.c.equals(((er)paramObject).c)) && ((this.f & 0x4) == (((er)paramObject).f & 0x4)) && (this.b.equals(((er)paramObject).b)))
        {
          localObject = this.e;
          if (localObject != null) {
            break label184;
          }
          if (((er)paramObject).e != null) {}
        }
        while (((fb)localObject).equals(((er)paramObject).e))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a()))
          {
            paramObject = ((er)paramObject).unknownFieldData;
            return (paramObject == null) || (((d)paramObject).a());
          }
          return this.unknownFieldData.equals(((er)paramObject).unknownFieldData);
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
    Object localObject = this.d;
    if (localObject != null) {}
    for (int i = ((bu)localObject).hashCode();; i = 0)
    {
      int i1 = this.a.hashCode();
      int i2 = this.c.hashCode();
      int i3 = this.b.hashCode();
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
        return (j + ((((i + (n + 527) * 31) * 31 + i1) * 31 + i2) * 31 + i3) * 31) * 31 + k;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/er.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */