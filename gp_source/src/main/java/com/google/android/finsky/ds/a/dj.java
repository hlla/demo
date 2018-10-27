package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;

public final class dj
  extends b
{
  public String a = "";
  private int b = 0;
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  private ne[] g = ne.b();
  
  public dj()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.b & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.f);
    }
    j = i;
    if ((this.b & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.e);
    }
    i = j;
    if ((this.b & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.d);
    }
    j = i;
    if ((this.b & 0x8) != 0) {
      j = i + CodedOutputByteBufferNano.b(4, this.c);
    }
    i = j;
    if ((this.b & 0x10) != 0) {
      i = j + CodedOutputByteBufferNano.b(5, this.a);
    }
    Object localObject = this.g;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.g;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          int k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.d(6, (g)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.b & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.f);
    }
    if ((this.b & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.e);
    }
    if ((this.b & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.d);
    }
    if ((this.b & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.c);
    }
    if ((this.b & 0x10) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.a);
    }
    Object localObject = this.g;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
      localObject = this.g;
      if (i < localObject.length)
      {
        localObject = localObject[i];
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          paramCodedOutputByteBufferNano.b(6, (g)localObject);
        }
      }
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof dj))
      {
        paramObject = (dj)paramObject;
        if (((this.b & 0x1) == (((dj)paramObject).b & 0x1)) && (this.f.equals(((dj)paramObject).f)) && ((this.b & 0x2) == (((dj)paramObject).b & 0x2)) && (this.e.equals(((dj)paramObject).e)) && ((this.b & 0x4) == (((dj)paramObject).b & 0x4)) && (this.d.equals(((dj)paramObject).d)) && ((this.b & 0x8) == (((dj)paramObject).b & 0x8)) && (this.c.equals(((dj)paramObject).c)) && ((this.b & 0x10) == (((dj)paramObject).b & 0x10)) && (this.a.equals(((dj)paramObject).a)) && (f.a(this.g, ((dj)paramObject).g)))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label216;
          }
          paramObject = ((dj)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label216:
      return this.unknownFieldData.equals(((dj)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = this.f.hashCode();
    int n = this.e.hashCode();
    int i1 = this.d.hashCode();
    int i2 = this.c.hashCode();
    int i3 = this.a.hashCode();
    int i4 = f.a(this.g);
    d locald = this.unknownFieldData;
    int i = j;
    if (locald != null)
    {
      i = j;
      if (!locald.a()) {
        i = this.unknownFieldData.hashCode();
      }
    }
    return i + (((((((k + 527) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/dj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */