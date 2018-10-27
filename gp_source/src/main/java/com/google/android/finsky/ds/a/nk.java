package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;

public final class nk
  extends b
{
  private static volatile nk[] d;
  public bu a = null;
  public String b = "";
  public boolean c = true;
  private int e = 0;
  
  public nk()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static nk[] b()
  {
    if (d == null) {}
    synchronized (f.a)
    {
      if (d == null) {
        d = new nk[0];
      }
      return d;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.e & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.b);
    }
    j = i;
    if ((this.e & 0x2) != 0) {
      j = i + (CodedOutputByteBufferNano.d(16) + 1);
    }
    bu localbu = this.a;
    i = j;
    if (localbu != null) {
      i = j + CodedOutputByteBufferNano.d(3, localbu);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.e & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.b);
    }
    if ((this.e & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.c);
    }
    bu localbu = this.a;
    if (localbu != null) {
      paramCodedOutputByteBufferNano.b(3, localbu);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof nk))
      {
        paramObject = (nk)paramObject;
        if (((this.e & 0x1) == (((nk)paramObject).e & 0x1)) && (this.b.equals(((nk)paramObject).b)) && ((this.e & 0x2) == (((nk)paramObject).e & 0x2)) && (this.c == ((nk)paramObject).c))
        {
          localObject = this.a;
          if (localObject != null) {
            break label136;
          }
          if (((nk)paramObject).a != null) {}
        }
      }
      label136:
      while (((bu)localObject).equals(((nk)paramObject).a))
      {
        localObject = this.unknownFieldData;
        if ((localObject == null) || (((d)localObject).a()))
        {
          paramObject = ((nk)paramObject).unknownFieldData;
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((nk)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int m = 0;
    int n = getClass().getName().hashCode();
    int i1 = this.b.hashCode();
    if (!this.c) {}
    for (int i = 1237;; i = 1231)
    {
      Object localObject = this.a;
      if (localObject != null) {}
      for (int j = ((bu)localObject).hashCode();; j = 0)
      {
        localObject = this.unknownFieldData;
        int k = m;
        if (localObject != null)
        {
          k = m;
          if (!((d)localObject).a()) {
            k = this.unknownFieldData.hashCode();
          }
        }
        return (j + (i + ((n + 527) * 31 + i1) * 31) * 31) * 31 + k;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/nk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */