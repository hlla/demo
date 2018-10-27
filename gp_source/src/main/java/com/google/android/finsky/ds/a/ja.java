package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;

public final class ja
  extends b
{
  private static volatile ja[] b;
  public String a = "";
  private int c = 0;
  private ct d = null;
  
  public ja()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static ja[] b()
  {
    if (b == null) {}
    synchronized (f.a)
    {
      if (b == null) {
        b = new ja[0];
      }
      return b;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.c & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.a);
    }
    ct localct = this.d;
    j = i;
    if (localct != null) {
      j = i + CodedOutputByteBufferNano.d(7, localct);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.c & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.a);
    }
    ct localct = this.d;
    if (localct != null) {
      paramCodedOutputByteBufferNano.b(7, localct);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof ja))
      {
        paramObject = (ja)paramObject;
        localObject = this.d;
        if (localObject != null) {
          break label110;
        }
        if (((ja)paramObject).d != null) {}
      }
      label110:
      while (((ct)localObject).equals(((ja)paramObject).d))
      {
        if (((this.c & 0x1) == (((ja)paramObject).c & 0x1)) && (this.a.equals(((ja)paramObject).a)))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((ja)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((ja)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    Object localObject = this.d;
    if (localObject != null) {}
    for (int i = ((ct)localObject).hashCode();; i = 0)
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ja.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */