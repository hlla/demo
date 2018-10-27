package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.g;

public final class ll
  extends b
{
  public ln a = null;
  public String b = "";
  public lq c = null;
  public String d = "";
  private int e = 0;
  
  public ll()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    Object localObject = this.c;
    int i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(1, (g)localObject);
    }
    j = i;
    if ((this.e & 0x1) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.d);
    }
    i = j;
    if ((this.e & 0x2) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.b);
    }
    localObject = this.a;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.d(4, (g)localObject);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.c;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(1, (g)localObject);
    }
    if ((this.e & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.d);
    }
    if ((this.e & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.b);
    }
    localObject = this.a;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(4, (g)localObject);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof ll))
      {
        paramObject = (ll)paramObject;
        localObject = this.c;
        if (localObject != null) {
          break label168;
        }
        if (((ll)paramObject).c != null) {}
      }
      label155:
      label168:
      while (((lq)localObject).equals(((ll)paramObject).c))
      {
        if (((this.e & 0x1) == (((ll)paramObject).e & 0x1)) && (this.d.equals(((ll)paramObject).d)) && ((this.e & 0x2) == (((ll)paramObject).e & 0x2)) && (this.b.equals(((ll)paramObject).b)))
        {
          localObject = this.a;
          if (localObject != null) {
            break label155;
          }
          if (((ll)paramObject).a != null) {}
        }
        while (((ln)localObject).equals(((ll)paramObject).a))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a()))
          {
            paramObject = ((ll)paramObject).unknownFieldData;
            return (paramObject == null) || (((d)paramObject).a());
          }
          return this.unknownFieldData.equals(((ll)paramObject).unknownFieldData);
        }
        return false;
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int m = 0;
    int n = getClass().getName().hashCode();
    Object localObject = this.c;
    if (localObject != null) {}
    for (int i = ((lq)localObject).hashCode();; i = 0)
    {
      int i1 = this.d.hashCode();
      int i2 = this.b.hashCode();
      localObject = this.a;
      if (localObject != null) {}
      for (int j = ((ln)localObject).hashCode();; j = 0)
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
        return (j + (((i + (n + 527) * 31) * 31 + i1) * 31 + i2) * 31) * 31 + k;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */