package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class ky
  extends b
{
  public int a = 0;
  public bp b = null;
  public long c = 0L;
  
  public ky()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.a & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.f(1, this.c);
    }
    bp localbp = this.b;
    j = i;
    if (localbp != null) {
      j = i + CodedOutputByteBufferNano.d(2, localbp);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.b(1, this.c);
    }
    bp localbp = this.b;
    if (localbp != null) {
      paramCodedOutputByteBufferNano.b(2, localbp);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof ky))
      {
        paramObject = (ky)paramObject;
        if (((this.a & 0x1) == (((ky)paramObject).a & 0x1)) && (this.c == ((ky)paramObject).c))
        {
          localObject = this.b;
          if (localObject != null) {
            break label108;
          }
          if (((ky)paramObject).b != null) {}
        }
      }
      label108:
      while (((bp)localObject).equals(((ky)paramObject).b))
      {
        localObject = this.unknownFieldData;
        if ((localObject == null) || (((d)localObject).a()))
        {
          paramObject = ((ky)paramObject).unknownFieldData;
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((ky)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    long l = this.c;
    Object localObject = this.b;
    int n = (int)(l ^ l >>> 32);
    if (localObject != null) {}
    for (int i = ((bp)localObject).hashCode();; i = 0)
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ky.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */