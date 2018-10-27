package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;

public final class ht
  extends b
{
  private int a = 0;
  private String b = "";
  private bp c = null;
  private String d = "";
  private bu[] e = bu.b();
  private String f = "";
  private String g = "";
  
  public ht()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    Object localObject = this.c;
    int i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(1, (g)localObject);
    }
    j = i;
    if ((this.a & 0x1) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.d);
    }
    int k = j;
    if ((this.a & 0x2) != 0) {
      k = j + CodedOutputByteBufferNano.b(3, this.g);
    }
    i = k;
    if ((this.a & 0x4) != 0) {
      i = k + CodedOutputByteBufferNano.b(4, this.f);
    }
    localObject = this.e;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.e;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.d(5, (g)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if ((this.a & 0x8) != 0) {
      i = j + CodedOutputByteBufferNano.b(6, this.b);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.c;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(1, (g)localObject);
    }
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.d);
    }
    if ((this.a & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.g);
    }
    if ((this.a & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.f);
    }
    localObject = this.e;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int i;
    do
    {
      if ((this.a & 0x8) != 0) {
        paramCodedOutputByteBufferNano.a(6, this.b);
      }
      super.a(paramCodedOutputByteBufferNano);
      return;
      i = 0;
      localObject = this.e;
    } while (i >= localObject.length);
    localObject = localObject[i];
    if (localObject == null) {}
    for (;;)
    {
      i += 1;
      break;
      paramCodedOutputByteBufferNano.b(5, (g)localObject);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof ht))
      {
        paramObject = (ht)paramObject;
        localObject = this.c;
        if (localObject != null) {
          break label213;
        }
        if (((ht)paramObject).c != null) {}
      }
      label213:
      while (((bp)localObject).equals(((ht)paramObject).c))
      {
        if (((this.a & 0x1) == (((ht)paramObject).a & 0x1)) && (this.d.equals(((ht)paramObject).d)) && ((this.a & 0x2) == (((ht)paramObject).a & 0x2)) && (this.g.equals(((ht)paramObject).g)) && ((this.a & 0x4) == (((ht)paramObject).a & 0x4)) && (this.f.equals(((ht)paramObject).f)) && (f.a(this.e, ((ht)paramObject).e)) && ((this.a & 0x8) == (((ht)paramObject).a & 0x8)) && (this.b.equals(((ht)paramObject).b)))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((ht)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((ht)paramObject).unknownFieldData);
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
    for (int i = ((bp)localObject).hashCode();; i = 0)
    {
      int n = this.d.hashCode();
      int i1 = this.g.hashCode();
      int i2 = this.f.hashCode();
      int i3 = f.a(this.e);
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
      return ((((((i + (m + 527) * 31) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ht.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */