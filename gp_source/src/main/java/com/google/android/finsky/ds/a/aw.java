package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class aw
  extends b
{
  public String a = "";
  public ax b = null;
  public String c = "";
  public String d = "";
  public String e = "";
  private int f = 0;
  
  public aw()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.f & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.e);
    }
    j = i;
    if ((this.f & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.a);
    }
    i = j;
    if ((this.f & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.d);
    }
    j = i;
    if ((this.f & 0x8) != 0) {
      j = i + CodedOutputByteBufferNano.b(4, this.c);
    }
    ax localax = this.b;
    i = j;
    if (localax != null) {
      i = j + CodedOutputByteBufferNano.d(5, localax);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.f & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.e);
    }
    if ((this.f & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.a);
    }
    if ((this.f & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.d);
    }
    if ((this.f & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.c);
    }
    ax localax = this.b;
    if (localax != null) {
      paramCodedOutputByteBufferNano.b(5, localax);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean b()
  {
    return (this.f & 0x2) != 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof aw))
      {
        paramObject = (aw)paramObject;
        if (((this.f & 0x1) == (((aw)paramObject).f & 0x1)) && (this.e.equals(((aw)paramObject).e)) && ((this.f & 0x2) == (((aw)paramObject).f & 0x2)) && (this.a.equals(((aw)paramObject).a)) && ((this.f & 0x4) == (((aw)paramObject).f & 0x4)) && (this.d.equals(((aw)paramObject).d)) && ((this.f & 0x8) == (((aw)paramObject).f & 0x8)) && (this.c.equals(((aw)paramObject).c)))
        {
          localObject = this.b;
          if (localObject != null) {
            break label199;
          }
          if (((aw)paramObject).b != null) {}
        }
      }
      label199:
      while (((ax)localObject).equals(((aw)paramObject).b))
      {
        localObject = this.unknownFieldData;
        if ((localObject == null) || (((d)localObject).a()))
        {
          paramObject = ((aw)paramObject).unknownFieldData;
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((aw)paramObject).unknownFieldData);
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
    int i1 = this.a.hashCode();
    int i2 = this.d.hashCode();
    int i3 = this.c.hashCode();
    Object localObject = this.b;
    if (localObject != null) {}
    for (int i = ((ax)localObject).hashCode();; i = 0)
    {
      localObject = this.unknownFieldData;
      int j = k;
      if (localObject != null)
      {
        j = k;
        if (!((d)localObject).a()) {
          j = this.unknownFieldData.hashCode();
        }
      }
      return (i + (((((m + 527) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */