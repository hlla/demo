package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class ha
  extends b
{
  private as a = null;
  private int b = 0;
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  private String g = "";
  
  public ha()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.b & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.g);
    }
    j = i;
    if ((this.b & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.f);
    }
    as localas = this.a;
    i = j;
    if (localas != null) {
      i = j + CodedOutputByteBufferNano.d(3, localas);
    }
    j = i;
    if ((this.b & 0x4) != 0) {
      j = i + CodedOutputByteBufferNano.b(4, this.e);
    }
    i = j;
    if ((this.b & 0x8) != 0) {
      i = j + CodedOutputByteBufferNano.b(5, this.d);
    }
    j = i;
    if ((this.b & 0x10) != 0) {
      j = i + CodedOutputByteBufferNano.b(6, this.c);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.b & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.g);
    }
    if ((this.b & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.f);
    }
    as localas = this.a;
    if (localas != null) {
      paramCodedOutputByteBufferNano.b(3, localas);
    }
    if ((this.b & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.e);
    }
    if ((this.b & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.d);
    }
    if ((this.b & 0x10) != 0) {
      paramCodedOutputByteBufferNano.a(6, this.c);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof ha))
      {
        paramObject = (ha)paramObject;
        if (((this.b & 0x1) == (((ha)paramObject).b & 0x1)) && (this.g.equals(((ha)paramObject).g)) && ((this.b & 0x2) == (((ha)paramObject).b & 0x2)) && (this.f.equals(((ha)paramObject).f)))
        {
          localObject = this.a;
          if (localObject != null) {
            break label230;
          }
          if (((ha)paramObject).a != null) {}
        }
      }
      label230:
      while (((as)localObject).equals(((ha)paramObject).a))
      {
        if (((this.b & 0x4) == (((ha)paramObject).b & 0x4)) && (this.e.equals(((ha)paramObject).e)) && ((this.b & 0x8) == (((ha)paramObject).b & 0x8)) && (this.d.equals(((ha)paramObject).d)) && ((this.b & 0x10) == (((ha)paramObject).b & 0x10)) && (this.c.equals(((ha)paramObject).c)))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((ha)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((ha)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int n = this.g.hashCode();
    int i1 = this.f.hashCode();
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = ((as)localObject).hashCode();; i = 0)
    {
      int i2 = this.e.hashCode();
      int i3 = this.d.hashCode();
      int i4 = this.c.hashCode();
      localObject = this.unknownFieldData;
      int j = k;
      if (localObject != null)
      {
        j = k;
        if (!((d)localObject).a()) {
          j = this.unknownFieldData.hashCode();
        }
      }
      return ((((i + (((m + 527) * 31 + n) * 31 + i1) * 31) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */