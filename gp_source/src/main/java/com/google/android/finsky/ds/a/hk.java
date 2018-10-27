package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;

public final class hk
  extends b
{
  private static volatile hk[] a;
  private int b = 0;
  private String c = "";
  private bu d = null;
  private String e = "";
  
  public hk()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static hk[] b()
  {
    if (a == null) {}
    synchronized (f.a)
    {
      if (a == null) {
        a = new hk[0];
      }
      return a;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.b & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(2, this.c);
    }
    j = i;
    if ((this.b & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(4, this.e);
    }
    bu localbu = this.d;
    i = j;
    if (localbu != null) {
      i = j + CodedOutputByteBufferNano.d(5, localbu);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.b & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.c);
    }
    if ((this.b & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.e);
    }
    bu localbu = this.d;
    if (localbu != null) {
      paramCodedOutputByteBufferNano.b(5, localbu);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof hk))
      {
        paramObject = (hk)paramObject;
        if (((this.b & 0x1) == (((hk)paramObject).b & 0x1)) && (this.c.equals(((hk)paramObject).c)) && ((this.b & 0x2) == (((hk)paramObject).b & 0x2)) && (this.e.equals(((hk)paramObject).e)))
        {
          localObject = this.d;
          if (localObject != null) {
            break label139;
          }
          if (((hk)paramObject).d != null) {}
        }
      }
      label139:
      while (((bu)localObject).equals(((hk)paramObject).d))
      {
        localObject = this.unknownFieldData;
        if ((localObject == null) || (((d)localObject).a()))
        {
          paramObject = ((hk)paramObject).unknownFieldData;
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((hk)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int n = this.c.hashCode();
    int i1 = this.e.hashCode();
    Object localObject = this.d;
    if (localObject != null) {}
    for (int i = ((bu)localObject).hashCode();; i = 0)
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
      return (i + (((m + 527) * 31 + n) * 31 + i1) * 31) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/hk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */