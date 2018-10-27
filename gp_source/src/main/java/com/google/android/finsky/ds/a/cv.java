package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class cv
  extends b
{
  public String a = "";
  public cu b = null;
  private int c = 0;
  
  public cv()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    cu localcu = this.b;
    int i = j;
    if (localcu != null) {
      i = j + CodedOutputByteBufferNano.d(1, localcu);
    }
    j = i;
    if ((this.c & 0x1) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.a);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    cu localcu = this.b;
    if (localcu != null) {
      paramCodedOutputByteBufferNano.b(1, localcu);
    }
    if ((this.c & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.a);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof cv))
      {
        paramObject = (cv)paramObject;
        localObject = this.b;
        if (localObject != null) {
          break label110;
        }
        if (((cv)paramObject).b != null) {}
      }
      label110:
      while (((cu)localObject).equals(((cv)paramObject).b))
      {
        if (((this.c & 0x1) == (((cv)paramObject).c & 0x1)) && (this.a.equals(((cv)paramObject).a)))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((cv)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((cv)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    Object localObject = this.b;
    if (localObject != null) {}
    for (int i = ((cu)localObject).hashCode();; i = 0)
    {
      int n = this.a.hashCode();
      localObject = this.unknownFieldData;
      int j = k;
      if (localObject != null)
      {
        j = k;
        if (!((d)localObject).a()) {
          j = this.unknownFieldData.hashCode();
        }
      }
      return ((i + (m + 527) * 31) * 31 + n) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/cv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */