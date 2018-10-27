package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;

public final class ep
  extends b
{
  private static volatile ep[] a;
  private int b = 0;
  private boolean c = false;
  private de d = null;
  
  public ep()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static ep[] b()
  {
    if (a == null) {}
    synchronized (f.a)
    {
      if (a == null) {
        a = new ep[0];
      }
      return a;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    de localde = this.d;
    int i = j;
    if (localde != null) {
      i = j + CodedOutputByteBufferNano.d(1, localde);
    }
    j = i;
    if ((this.b & 0x1) != 0) {
      j = i + (CodedOutputByteBufferNano.d(16) + 1);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    de localde = this.d;
    if (localde != null) {
      paramCodedOutputByteBufferNano.b(1, localde);
    }
    if ((this.b & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.c);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof ep))
      {
        paramObject = (ep)paramObject;
        localObject = this.d;
        if (localObject != null) {
          break label107;
        }
        if (((ep)paramObject).d != null) {}
      }
      label107:
      while (((de)localObject).equals(((ep)paramObject).d))
      {
        if (((this.b & 0x1) == (((ep)paramObject).b & 0x1)) && (this.c == ((ep)paramObject).c))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((ep)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((ep)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int m = 0;
    int n = getClass().getName().hashCode();
    Object localObject = this.d;
    if (localObject != null) {}
    for (int i = ((de)localObject).hashCode();; i = 0)
    {
      if (!this.c) {}
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
        return (j + (i + (n + 527) * 31) * 31) * 31 + k;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */