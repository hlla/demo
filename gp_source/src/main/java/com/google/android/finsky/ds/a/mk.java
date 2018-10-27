package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class mk
  extends b
{
  private as a = null;
  private int b = 0;
  private String c = "";
  
  public mk()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.b & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.c);
    }
    as localas = this.a;
    j = i;
    if (localas != null) {
      j = i + CodedOutputByteBufferNano.d(2, localas);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.b & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.c);
    }
    as localas = this.a;
    if (localas != null) {
      paramCodedOutputByteBufferNano.b(2, localas);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof mk))
      {
        paramObject = (mk)paramObject;
        if (((this.b & 0x1) == (((mk)paramObject).b & 0x1)) && (this.c.equals(((mk)paramObject).c)))
        {
          localObject = this.a;
          if (localObject != null) {
            break label110;
          }
          if (((mk)paramObject).a != null) {}
        }
      }
      label110:
      while (((as)localObject).equals(((mk)paramObject).a))
      {
        localObject = this.unknownFieldData;
        if ((localObject == null) || (((d)localObject).a()))
        {
          paramObject = ((mk)paramObject).unknownFieldData;
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((mk)paramObject).unknownFieldData);
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
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = ((as)localObject).hashCode();; i = 0)
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
      return (i + ((m + 527) * 31 + n) * 31) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/mk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */