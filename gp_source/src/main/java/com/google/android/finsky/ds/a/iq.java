package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class iq
  extends b
{
  public fb a = null;
  public String b = "";
  private int c = 0;
  
  public iq()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.c & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.b);
    }
    fb localfb = this.a;
    j = i;
    if (localfb != null) {
      j = i + CodedOutputByteBufferNano.d(2, localfb);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.c & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.b);
    }
    fb localfb = this.a;
    if (localfb != null) {
      paramCodedOutputByteBufferNano.b(2, localfb);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof iq))
      {
        paramObject = (iq)paramObject;
        if (((this.c & 0x1) == (((iq)paramObject).c & 0x1)) && (this.b.equals(((iq)paramObject).b)))
        {
          localObject = this.a;
          if (localObject != null) {
            break label110;
          }
          if (((iq)paramObject).a != null) {}
        }
      }
      label110:
      while (((fb)localObject).equals(((iq)paramObject).a))
      {
        localObject = this.unknownFieldData;
        if ((localObject == null) || (((d)localObject).a()))
        {
          paramObject = ((iq)paramObject).unknownFieldData;
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((iq)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int n = this.b.hashCode();
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = ((fb)localObject).hashCode();; i = 0)
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/iq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */