package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class bk
  extends b
{
  private int a = 0;
  private String b = "";
  private bu c = null;
  
  public bk()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    bu localbu = this.c;
    int i = j;
    if (localbu != null) {
      i = j + CodedOutputByteBufferNano.d(1, localbu);
    }
    j = i;
    if ((this.a & 0x1) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.b);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    bu localbu = this.c;
    if (localbu != null) {
      paramCodedOutputByteBufferNano.b(1, localbu);
    }
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.b);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof bk))
      {
        paramObject = (bk)paramObject;
        localObject = this.c;
        if (localObject != null) {
          break label110;
        }
        if (((bk)paramObject).c != null) {}
      }
      label110:
      while (((bu)localObject).equals(((bk)paramObject).c))
      {
        if (((this.a & 0x1) == (((bk)paramObject).a & 0x1)) && (this.b.equals(((bk)paramObject).b)))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((bk)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((bk)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    Object localObject = this.c;
    if (localObject != null) {}
    for (int i = ((bu)localObject).hashCode();; i = 0)
    {
      int n = this.b.hashCode();
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */