package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class bl
  extends b
{
  private bk a = null;
  
  public bl()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    bk localbk = this.a;
    int i = j;
    if (localbk != null) {
      i = j + CodedOutputByteBufferNano.d(1, localbk);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    bk localbk = this.a;
    if (localbk != null) {
      paramCodedOutputByteBufferNano.b(1, localbk);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof bl))
      {
        paramObject = (bl)paramObject;
        localObject = this.a;
        if (localObject != null) {
          break label81;
        }
        if (((bl)paramObject).a != null) {}
      }
      label81:
      while (((bk)localObject).equals(((bl)paramObject).a))
      {
        localObject = this.unknownFieldData;
        if ((localObject == null) || (((d)localObject).a()))
        {
          paramObject = ((bl)paramObject).unknownFieldData;
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((bl)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = ((bk)localObject).hashCode();; i = 0)
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
      return (i + (m + 527) * 31) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */