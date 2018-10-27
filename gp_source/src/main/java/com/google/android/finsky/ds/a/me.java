package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;

public final class me
  extends b
{
  private static volatile me[] c;
  public fb a = null;
  public String b = "";
  private int d = 0;
  
  public me()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static me[] b()
  {
    if (c == null) {}
    synchronized (f.a)
    {
      if (c == null) {
        c = new me[0];
      }
      return c;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.d & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.b);
    }
    fb localfb = this.a;
    j = i;
    if (localfb != null) {
      j = i + CodedOutputByteBufferNano.d(2, localfb);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.d & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.b);
    }
    fb localfb = this.a;
    if (localfb != null) {
      paramCodedOutputByteBufferNano.b(2, localfb);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof me))
      {
        paramObject = (me)paramObject;
        if (((this.d & 0x1) == (((me)paramObject).d & 0x1)) && (this.b.equals(((me)paramObject).b)))
        {
          localObject = this.a;
          if (localObject != null) {
            break label110;
          }
          if (((me)paramObject).a != null) {}
        }
      }
      label110:
      while (((fb)localObject).equals(((me)paramObject).a))
      {
        localObject = this.unknownFieldData;
        if ((localObject == null) || (((d)localObject).a()))
        {
          paramObject = ((me)paramObject).unknownFieldData;
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((me)paramObject).unknownFieldData);
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
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = ((fb)localObject).hashCode();; i = 0)
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
      return (i + ((m + 527) * 31 + n) * 31) * 31 + j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/me.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */