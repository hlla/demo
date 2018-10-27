package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;

public final class kc
  extends b
{
  private static volatile kc[] d;
  public bu a = null;
  public String b = "";
  public String c = "";
  private int e = 0;
  
  public kc()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static kc[] b()
  {
    if (d == null) {}
    synchronized (f.a)
    {
      if (d == null) {
        d = new kc[0];
      }
      return d;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.e & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.c);
    }
    j = i;
    if ((this.e & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.b);
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
      paramCodedOutputByteBufferNano.a(1, this.c);
    }
    if ((this.e & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.b);
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
      if ((paramObject instanceof kc))
      {
        paramObject = (kc)paramObject;
        if (((this.e & 0x1) == (((kc)paramObject).e & 0x1)) && (this.c.equals(((kc)paramObject).c)) && ((this.e & 0x2) == (((kc)paramObject).e & 0x2)) && (this.b.equals(((kc)paramObject).b)))
        {
          localObject = this.a;
          if (localObject != null) {
            break label139;
          }
          if (((kc)paramObject).a != null) {}
        }
      }
      label139:
      while (((bu)localObject).equals(((kc)paramObject).a))
      {
        localObject = this.unknownFieldData;
        if ((localObject == null) || (((d)localObject).a()))
        {
          paramObject = ((kc)paramObject).unknownFieldData;
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((kc)paramObject).unknownFieldData);
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
    int i1 = this.b.hashCode();
    Object localObject = this.a;
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/kc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */