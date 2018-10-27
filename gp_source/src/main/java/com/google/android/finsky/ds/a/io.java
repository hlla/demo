package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;

public final class io
  extends b
{
  private static volatile io[] c;
  public bu a = null;
  public String b = "";
  private int d = 0;
  
  public io()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static io[] b()
  {
    if (c == null) {}
    synchronized (f.a)
    {
      if (c == null) {
        c = new io[0];
      }
      return c;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    bu localbu = this.a;
    int i = j;
    if (localbu != null) {
      i = j + CodedOutputByteBufferNano.d(1, localbu);
    }
    j = i;
    if ((this.d & 0x1) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.b);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    bu localbu = this.a;
    if (localbu != null) {
      paramCodedOutputByteBufferNano.b(1, localbu);
    }
    if ((this.d & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.b);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof io))
      {
        paramObject = (io)paramObject;
        localObject = this.a;
        if (localObject != null) {
          break label110;
        }
        if (((io)paramObject).a != null) {}
      }
      label110:
      while (((bu)localObject).equals(((io)paramObject).a))
      {
        if (((this.d & 0x1) == (((io)paramObject).d & 0x1)) && (this.b.equals(((io)paramObject).b)))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((io)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((io)paramObject).unknownFieldData);
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/io.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */