package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;

public final class fu
  extends b
{
  public int a = 0;
  public String b = "";
  public ft[] c = ft.b();
  public String d = "";
  public String e = "";
  
  public fu()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int i = super.a();
    int j = i;
    if ((this.a & 0x1) != 0) {
      j = i + CodedOutputByteBufferNano.b(1, this.e);
    }
    i = j;
    if ((this.a & 0x2) != 0) {
      i = j + CodedOutputByteBufferNano.b(2, this.d);
    }
    Object localObject = this.c;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.c;
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
    if ((this.a & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.b(4, this.b);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.e);
    }
    if ((this.a & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.d);
    }
    Object localObject = this.c;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int i;
    do
    {
      if ((this.a & 0x4) != 0) {
        paramCodedOutputByteBufferNano.a(4, this.b);
      }
      super.a(paramCodedOutputByteBufferNano);
      return;
      i = 0;
      localObject = this.c;
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
      if ((paramObject instanceof fu))
      {
        paramObject = (fu)paramObject;
        if (((this.a & 0x1) == (((fu)paramObject).a & 0x1)) && (this.e.equals(((fu)paramObject).e)) && ((this.a & 0x2) == (((fu)paramObject).a & 0x2)) && (this.d.equals(((fu)paramObject).d)) && ((this.a & 0x4) == (((fu)paramObject).a & 0x4)) && (this.b.equals(((fu)paramObject).b)) && (f.a(this.c, ((fu)paramObject).c)))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label154;
          }
          paramObject = ((fu)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label154:
      return this.unknownFieldData.equals(((fu)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int m = this.e.hashCode();
    int n = this.d.hashCode();
    int i1 = this.b.hashCode();
    int i2 = f.a(this.c);
    d locald = this.unknownFieldData;
    int i = j;
    if (locald != null)
    {
      i = j;
      if (!locald.a()) {
        i = this.unknownFieldData.hashCode();
      }
    }
    return i + (((((k + 527) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/fu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */