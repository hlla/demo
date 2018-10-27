package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class ba
  extends b
{
  public String a = "";
  public int b = -1;
  private az c = null;
  
  public ba()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if (this.b == 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.a);
    }
    j = i;
    if (this.b == 1) {
      j = i + CodedOutputByteBufferNano.d(2, this.c);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.b == 0) {
      paramCodedOutputByteBufferNano.a(1, this.a);
    }
    if (this.b == 1) {
      paramCodedOutputByteBufferNano.b(2, this.c);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final az b()
  {
    if (this.b != 1) {
      return null;
    }
    return this.c;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof ba))
      {
        paramObject = (ba)paramObject;
        int i = this.b;
        if ((i == ((ba)paramObject).b) && ((i != 0) || (this.a.equals(((ba)paramObject).a))))
        {
          localObject = this.c;
          if (localObject != null) {
            break label112;
          }
          if (((ba)paramObject).c != null) {}
        }
      }
      label112:
      while (((az)localObject).equals(((ba)paramObject).c))
      {
        localObject = this.unknownFieldData;
        if ((localObject == null) || (((d)localObject).a()))
        {
          paramObject = ((ba)paramObject).unknownFieldData;
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((ba)paramObject).unknownFieldData);
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
    if (this.b != 0) {
      localObject = "";
    }
    int n = ((String)localObject).hashCode();
    localObject = this.c;
    if (this.b != 1) {
      localObject = null;
    }
    if (localObject != null) {}
    for (int i = ((az)localObject).hashCode();; i = 0)
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */