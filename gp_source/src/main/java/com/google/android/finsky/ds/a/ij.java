package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;

public final class ij
  extends b
{
  private static volatile ij[] a;
  private int b = 0;
  private String c = "";
  private String d = "";
  private bu[] e = bu.b();
  private String f = "";
  private String g = "";
  
  public ij()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static ij[] b()
  {
    if (a == null) {}
    synchronized (f.a)
    {
      if (a == null) {
        a = new ij[0];
      }
      return a;
    }
  }
  
  protected final int a()
  {
    int i = super.a();
    int j = i;
    if ((this.b & 0x1) != 0) {
      j = i + CodedOutputByteBufferNano.b(1, this.g);
    }
    i = j;
    if ((this.b & 0x2) != 0) {
      i = j + CodedOutputByteBufferNano.b(2, this.f);
    }
    Object localObject = this.e;
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
          int k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.d(3, (g)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if ((this.b & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.b(4, this.c);
    }
    j = i;
    if ((this.b & 0x8) != 0) {
      j = i + CodedOutputByteBufferNano.b(5, this.d);
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
    Object localObject = this.e;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int i;
    do
    {
      if ((this.b & 0x4) != 0) {
        paramCodedOutputByteBufferNano.a(4, this.c);
      }
      if ((this.b & 0x8) != 0) {
        paramCodedOutputByteBufferNano.a(5, this.d);
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
      paramCodedOutputByteBufferNano.b(3, (g)localObject);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof ij))
      {
        paramObject = (ij)paramObject;
        if (((this.b & 0x1) == (((ij)paramObject).b & 0x1)) && (this.g.equals(((ij)paramObject).g)) && ((this.b & 0x2) == (((ij)paramObject).b & 0x2)) && (this.f.equals(((ij)paramObject).f)) && (f.a(this.e, ((ij)paramObject).e)) && ((this.b & 0x4) == (((ij)paramObject).b & 0x4)) && (this.c.equals(((ij)paramObject).c)) && ((this.b & 0x8) == (((ij)paramObject).b & 0x8)) && (this.d.equals(((ij)paramObject).d)))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label185;
          }
          paramObject = ((ij)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label185:
      return this.unknownFieldData.equals(((ij)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = this.g.hashCode();
    int n = this.f.hashCode();
    int i1 = f.a(this.e);
    int i2 = this.c.hashCode();
    int i3 = this.d.hashCode();
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ij.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */