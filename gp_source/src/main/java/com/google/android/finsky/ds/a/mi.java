package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class mi
  extends b
{
  public fb a = null;
  public String b = "";
  public String c = "";
  private int d = 0;
  
  public mi()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.d & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.c);
    }
    fb localfb = this.a;
    j = i;
    if (localfb != null) {
      j = i + CodedOutputByteBufferNano.d(2, localfb);
    }
    i = j;
    if ((this.d & 0x2) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.b);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.d & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.c);
    }
    fb localfb = this.a;
    if (localfb != null) {
      paramCodedOutputByteBufferNano.b(2, localfb);
    }
    if ((this.d & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.b);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof mi))
      {
        paramObject = (mi)paramObject;
        if (((this.d & 0x1) == (((mi)paramObject).d & 0x1)) && (this.c.equals(((mi)paramObject).c)))
        {
          localObject = this.a;
          if (localObject != null) {
            break label139;
          }
          if (((mi)paramObject).a != null) {}
        }
      }
      label139:
      while (((fb)localObject).equals(((mi)paramObject).a))
      {
        if (((this.d & 0x2) == (((mi)paramObject).d & 0x2)) && (this.b.equals(((mi)paramObject).b)))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((mi)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((mi)paramObject).unknownFieldData);
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
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = ((fb)localObject).hashCode();; i = 0)
    {
      int i1 = this.b.hashCode();
      localObject = this.unknownFieldData;
      int j = k;
      if (localObject != null)
      {
        j = k;
        if (!((d)localObject).a()) {
          j = this.unknownFieldData.hashCode();
        }
      }
      return ((i + ((m + 527) * 31 + n) * 31) * 31 + i1) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/mi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */