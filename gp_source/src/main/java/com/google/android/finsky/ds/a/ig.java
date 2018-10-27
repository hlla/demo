package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class ig
  extends b
{
  public String a = "";
  public String b = "";
  public bu c = null;
  public String d = "";
  public String e = "";
  public String f = "";
  private int g = 0;
  
  public ig()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.g & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.f);
    }
    bu localbu = this.c;
    j = i;
    if (localbu != null) {
      j = i + CodedOutputByteBufferNano.d(2, localbu);
    }
    i = j;
    if ((this.g & 0x2) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.e);
    }
    j = i;
    if ((this.g & 0x4) != 0) {
      j = i + CodedOutputByteBufferNano.b(4, this.d);
    }
    i = j;
    if ((this.g & 0x8) != 0) {
      i = j + CodedOutputByteBufferNano.b(5, this.a);
    }
    j = i;
    if ((this.g & 0x10) != 0) {
      j = i + CodedOutputByteBufferNano.b(6, this.b);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.g & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.f);
    }
    bu localbu = this.c;
    if (localbu != null) {
      paramCodedOutputByteBufferNano.b(2, localbu);
    }
    if ((this.g & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.e);
    }
    if ((this.g & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.d);
    }
    if ((this.g & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.a);
    }
    if ((this.g & 0x10) != 0) {
      paramCodedOutputByteBufferNano.a(6, this.b);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof ig))
      {
        paramObject = (ig)paramObject;
        if (((this.g & 0x1) == (((ig)paramObject).g & 0x1)) && (this.f.equals(((ig)paramObject).f)))
        {
          localObject = this.c;
          if (localObject != null) {
            break label230;
          }
          if (((ig)paramObject).c != null) {}
        }
      }
      label230:
      while (((bu)localObject).equals(((ig)paramObject).c))
      {
        if (((this.g & 0x2) == (((ig)paramObject).g & 0x2)) && (this.e.equals(((ig)paramObject).e)) && ((this.g & 0x4) == (((ig)paramObject).g & 0x4)) && (this.d.equals(((ig)paramObject).d)) && ((this.g & 0x8) == (((ig)paramObject).g & 0x8)) && (this.a.equals(((ig)paramObject).a)) && ((this.g & 0x10) == (((ig)paramObject).g & 0x10)) && (this.b.equals(((ig)paramObject).b)))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((ig)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((ig)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int n = this.f.hashCode();
    Object localObject = this.c;
    if (localObject != null) {}
    for (int i = ((bu)localObject).hashCode();; i = 0)
    {
      int i1 = this.e.hashCode();
      int i2 = this.d.hashCode();
      int i3 = this.a.hashCode();
      int i4 = this.b.hashCode();
      localObject = this.unknownFieldData;
      int j = k;
      if (localObject != null)
      {
        j = k;
        if (!((d)localObject).a()) {
          j = this.unknownFieldData.hashCode();
        }
      }
      return (((((i + ((m + 527) * 31 + n) * 31) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */