package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.d;

public final class ag
  extends com.google.protobuf.nano.b
{
  public b a = null;
  public String b = "";
  public String c = "";
  private int d = 0;
  
  public ag()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    b localb = this.a;
    int i = j;
    if (localb != null) {
      i = j + CodedOutputByteBufferNano.d(1, localb);
    }
    j = i;
    if ((this.d & 0x1) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.c);
    }
    i = j;
    if ((this.d & 0x2) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.b);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    b localb = this.a;
    if (localb != null) {
      paramCodedOutputByteBufferNano.b(1, localb);
    }
    if ((this.d & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.c);
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
      if ((paramObject instanceof ag))
      {
        paramObject = (ag)paramObject;
        localObject = this.a;
        if (localObject != null) {
          break label139;
        }
        if (((ag)paramObject).a != null) {}
      }
      label139:
      while (((b)localObject).equals(((ag)paramObject).a))
      {
        if (((this.d & 0x1) == (((ag)paramObject).d & 0x1)) && (this.c.equals(((ag)paramObject).c)) && ((this.d & 0x2) == (((ag)paramObject).d & 0x2)) && (this.b.equals(((ag)paramObject).b)))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((ag)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((ag)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = ((b)localObject).hashCode();; i = 0)
    {
      int n = this.c.hashCode();
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
      return (((i + (m + 527) * 31) * 31 + n) * 31 + i1) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */