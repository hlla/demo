package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;

public final class ad
  extends b
{
  private static volatile ad[] d;
  public ae a = null;
  public boolean b = false;
  public String c = "";
  private int e = 0;
  private String f = "";
  
  public ad()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static ad[] b()
  {
    if (d == null) {}
    synchronized (f.a)
    {
      if (d == null) {
        d = new ad[0];
      }
      return d;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.e & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.f);
    }
    j = i;
    if ((this.e & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.c);
    }
    ae localae = this.a;
    i = j;
    if (localae != null) {
      i = j + CodedOutputByteBufferNano.d(3, localae);
    }
    j = i;
    if ((this.e & 0x4) != 0) {
      j = i + (CodedOutputByteBufferNano.d(32) + 1);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.e & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.f);
    }
    if ((this.e & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.c);
    }
    ae localae = this.a;
    if (localae != null) {
      paramCodedOutputByteBufferNano.b(3, localae);
    }
    if ((this.e & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.b);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof ad))
      {
        paramObject = (ad)paramObject;
        if (((this.e & 0x1) == (((ad)paramObject).e & 0x1)) && (this.f.equals(((ad)paramObject).f)) && ((this.e & 0x2) == (((ad)paramObject).e & 0x2)) && (this.c.equals(((ad)paramObject).c)))
        {
          localObject = this.a;
          if (localObject != null) {
            break label165;
          }
          if (((ad)paramObject).a != null) {}
        }
      }
      label165:
      while (((ae)localObject).equals(((ad)paramObject).a))
      {
        if (((this.e & 0x4) == (((ad)paramObject).e & 0x4)) && (this.b == ((ad)paramObject).b))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((ad)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((ad)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int m = 0;
    int n = getClass().getName().hashCode();
    int i1 = this.f.hashCode();
    int i2 = this.c.hashCode();
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = ((ae)localObject).hashCode();; i = 0)
    {
      if (!this.b) {}
      for (int j = 1237;; j = 1231)
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
        return (j + (i + (((n + 527) * 31 + i1) * 31 + i2) * 31) * 31) * 31 + k;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */