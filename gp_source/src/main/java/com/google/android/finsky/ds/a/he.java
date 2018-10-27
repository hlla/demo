package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class he
  extends b
{
  public hf a = null;
  public String b = "";
  private int c = 0;
  
  public he()
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
    hf localhf = this.a;
    j = i;
    if (localhf != null) {
      j = i + CodedOutputByteBufferNano.d(2, localhf);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.c & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.b);
    }
    hf localhf = this.a;
    if (localhf != null) {
      paramCodedOutputByteBufferNano.b(2, localhf);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof he))
      {
        paramObject = (he)paramObject;
        if (((this.c & 0x1) == (((he)paramObject).c & 0x1)) && (this.b.equals(((he)paramObject).b)))
        {
          localObject = this.a;
          if (localObject != null) {
            break label110;
          }
          if (((he)paramObject).a != null) {}
        }
      }
      label110:
      while (((hf)localObject).equals(((he)paramObject).a))
      {
        localObject = this.unknownFieldData;
        if ((localObject == null) || (((d)localObject).a()))
        {
          paramObject = ((he)paramObject).unknownFieldData;
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((he)paramObject).unknownFieldData);
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
    for (int i = ((hf)localObject).hashCode();; i = 0)
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/he.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */