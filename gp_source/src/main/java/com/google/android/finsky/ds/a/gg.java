package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class gg
  extends b
{
  public kp a = null;
  public String b = "";
  public int c = 0;
  private int d = 0;
  
  public gg()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.d & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.b);
    }
    j = i;
    if ((this.d & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.d(2, this.c);
    }
    kp localkp = this.a;
    i = j;
    if (localkp != null) {
      i = j + CodedOutputByteBufferNano.d(3, localkp);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.d & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.b);
    }
    if ((this.d & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.c);
    }
    kp localkp = this.a;
    if (localkp != null) {
      paramCodedOutputByteBufferNano.b(3, localkp);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof gg))
      {
        paramObject = (gg)paramObject;
        if (((this.d & 0x1) == (((gg)paramObject).d & 0x1)) && (this.b.equals(((gg)paramObject).b)) && ((this.d & 0x2) == (((gg)paramObject).d & 0x2)) && (this.c == ((gg)paramObject).c))
        {
          localObject = this.a;
          if (localObject != null) {
            break label136;
          }
          if (((gg)paramObject).a != null) {}
        }
      }
      label136:
      while (((kp)localObject).equals(((gg)paramObject).a))
      {
        localObject = this.unknownFieldData;
        if ((localObject == null) || (((d)localObject).a()))
        {
          paramObject = ((gg)paramObject).unknownFieldData;
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((gg)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int n = this.b.hashCode();
    int i1 = this.c;
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = ((kp)localObject).hashCode();; i = 0)
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/gg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */