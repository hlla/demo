package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class gj
  extends b
{
  public int a = 0;
  public String b = "";
  public bu c = null;
  public long d = 0L;
  public String e = "";
  private String f = "";
  
  public gj()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    bu localbu = this.c;
    int i = j;
    if (localbu != null) {
      i = j + CodedOutputByteBufferNano.d(1, localbu);
    }
    j = i;
    if ((this.a & 0x1) != 0) {
      j = i + CodedOutputByteBufferNano.e(2, this.d);
    }
    i = j;
    if ((this.a & 0x2) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.f);
    }
    j = i;
    if ((this.a & 0x4) != 0) {
      j = i + CodedOutputByteBufferNano.b(4, this.b);
    }
    i = j;
    if ((this.a & 0x8) != 0) {
      i = j + CodedOutputByteBufferNano.b(5, this.e);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    bu localbu = this.c;
    if (localbu != null) {
      paramCodedOutputByteBufferNano.b(1, localbu);
    }
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.d);
    }
    if ((this.a & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.f);
    }
    if ((this.a & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.b);
    }
    if ((this.a & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.e);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof gj))
      {
        paramObject = (gj)paramObject;
        localObject = this.c;
        if (localObject != null) {
          break label200;
        }
        if (((gj)paramObject).c != null) {}
      }
      label200:
      while (((bu)localObject).equals(((gj)paramObject).c))
      {
        int i = this.a;
        int j = ((gj)paramObject).a;
        if (((i & 0x1) == (j & 0x1)) && (this.d == ((gj)paramObject).d) && ((i & 0x2) == (j & 0x2)) && (this.f.equals(((gj)paramObject).f)) && ((this.a & 0x4) == (((gj)paramObject).a & 0x4)) && (this.b.equals(((gj)paramObject).b)) && ((this.a & 0x8) == (((gj)paramObject).a & 0x8)) && (this.e.equals(((gj)paramObject).e)))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((gj)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((gj)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    Object localObject = this.c;
    if (localObject != null) {}
    for (int i = ((bu)localObject).hashCode();; i = 0)
    {
      long l = this.d;
      int n = (int)(l >>> 32 ^ l);
      int i1 = this.f.hashCode();
      int i2 = this.b.hashCode();
      int i3 = this.e.hashCode();
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/gj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */