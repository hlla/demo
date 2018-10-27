package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class jx
  extends b
{
  public int a = 0;
  public bp b = null;
  public int c = 0;
  public String d = "";
  
  public jx()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    bp localbp = this.b;
    int i = j;
    if (localbp != null) {
      i = j + CodedOutputByteBufferNano.d(1, localbp);
    }
    j = i;
    if ((this.a & 0x1) != 0) {
      j = i + CodedOutputByteBufferNano.d(2, this.c);
    }
    i = j;
    if ((this.a & 0x2) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.d);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    bp localbp = this.b;
    if (localbp != null) {
      paramCodedOutputByteBufferNano.b(1, localbp);
    }
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.c);
    }
    if ((this.a & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.d);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof jx))
      {
        paramObject = (jx)paramObject;
        localObject = this.b;
        if (localObject != null) {
          break label139;
        }
        if (((jx)paramObject).b != null) {}
      }
      label139:
      while (((bp)localObject).equals(((jx)paramObject).b))
      {
        int i = this.a;
        int j = ((jx)paramObject).a;
        if (((i & 0x1) == (j & 0x1)) && (this.c == ((jx)paramObject).c) && ((i & 0x2) == (j & 0x2)) && (this.d.equals(((jx)paramObject).d)))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((jx)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((jx)paramObject).unknownFieldData);
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
    for (int i = ((bp)localObject).hashCode();; i = 0)
    {
      int n = this.c;
      int i1 = this.d.hashCode();
      localObject = this.unknownFieldData;
      int j = k;
      if (localObject != null)
      {
        j = k;
        if (!((d)localObject).a()) {
          j = this.unknownFieldData.hashCode();
        }
      }
      return (((i + (m + 527) * 31) * 31 + n) * 31 + i1) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/jx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */