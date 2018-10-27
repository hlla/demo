package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.g;
import com.google.wireless.android.finsky.d.bc;

public final class dc
  extends b
{
  public dd a = null;
  private int b = 0;
  private Integer c;
  
  public dc()
  {
    if (bc.a != null) {}
    for (Integer localInteger = Integer.valueOf(bc.a.b);; localInteger = null)
    {
      this.c = localInteger;
      this.unknownFieldData = null;
      this.cachedSize = -1;
      return;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    Object localObject = this.a;
    int i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(1, (g)localObject);
    }
    j = i;
    if ((this.b & 0x1) != 0)
    {
      localObject = this.c;
      j = i;
      if (localObject != null) {
        j = i + CodedOutputByteBufferNano.d(2, ((Integer)localObject).intValue());
      }
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.a;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(1, (g)localObject);
    }
    if ((this.b & 0x1) != 0)
    {
      localObject = this.c;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.a(2, ((Integer)localObject).intValue());
      }
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof dc))
      {
        paramObject = (dc)paramObject;
        localObject = this.a;
        if (localObject != null) {
          break label107;
        }
        if (((dc)paramObject).a != null) {}
      }
      label107:
      while (((dd)localObject).equals(((dc)paramObject).a))
      {
        if (((this.b & 0x1) == (((dc)paramObject).b & 0x1)) && (this.c == ((dc)paramObject).c))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((dc)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((dc)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int j = getClass().getName().hashCode();
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = ((dd)localObject).hashCode();; i = 0)
    {
      j = i + (j + 527) * 31;
      localObject = this.c;
      i = j;
      if (localObject != null) {
        i = j * 31 + ((Integer)localObject).intValue();
      }
      localObject = this.unknownFieldData;
      j = k;
      if (localObject != null)
      {
        j = k;
        if (!((d)localObject).a()) {
          j = this.unknownFieldData.hashCode();
        }
      }
      return i * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/dc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */