package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class eq
  extends b
{
  public String a = "";
  public bu b = null;
  public String c = "";
  public String d = "";
  private int e = 0;
  
  public eq()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.e & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.c);
    }
    j = i;
    if ((this.e & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.a);
    }
    i = j;
    if ((this.e & 0x4) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.d);
    }
    bu localbu = this.b;
    j = i;
    if (localbu != null) {
      j = i + CodedOutputByteBufferNano.d(4, localbu);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.e & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.c);
    }
    if ((this.e & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.a);
    }
    if ((this.e & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.d);
    }
    bu localbu = this.b;
    if (localbu != null) {
      paramCodedOutputByteBufferNano.b(4, localbu);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof eq))
      {
        paramObject = (eq)paramObject;
        if (((this.e & 0x1) == (((eq)paramObject).e & 0x1)) && (this.c.equals(((eq)paramObject).c)) && ((this.e & 0x2) == (((eq)paramObject).e & 0x2)) && (this.a.equals(((eq)paramObject).a)) && ((this.e & 0x4) == (((eq)paramObject).e & 0x4)) && (this.d.equals(((eq)paramObject).d)))
        {
          localObject = this.b;
          if (localObject != null) {
            break label168;
          }
          if (((eq)paramObject).b != null) {}
        }
      }
      label168:
      while (((bu)localObject).equals(((eq)paramObject).b))
      {
        localObject = this.unknownFieldData;
        if ((localObject == null) || (((d)localObject).a()))
        {
          paramObject = ((eq)paramObject).unknownFieldData;
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((eq)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int n = this.c.hashCode();
    int i1 = this.a.hashCode();
    int i2 = this.d.hashCode();
    Object localObject = this.b;
    if (localObject != null) {}
    for (int i = ((bu)localObject).hashCode();; i = 0)
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
      return (i + ((((m + 527) * 31 + n) * 31 + i1) * 31 + i2) * 31) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/eq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */