package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.j;
import com.google.wireless.android.finsky.dfe.s.a.g;

public final class nc
  extends b
{
  private static volatile nc[] c;
  public String a = "";
  public String[] b = j.h;
  private g d = g.a;
  
  public nc()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static nc[] b()
  {
    if (c == null) {}
    synchronized (f.a)
    {
      if (c == null) {
        c = new nc[0];
      }
      return c;
    }
  }
  
  protected final int a()
  {
    int j = 0;
    int k = super.a();
    Object localObject = this.d;
    int i = k;
    if (localObject != null) {
      i = k + CodedOutputByteBufferNano.d(1, ((g)localObject).b);
    }
    int i1 = i + CodedOutputByteBufferNano.b(2, this.a);
    localObject = this.b;
    if (localObject != null)
    {
      if (localObject.length > 0)
      {
        i = 0;
        int m;
        for (k = 0;; k = m)
        {
          localObject = this.b;
          if (i >= localObject.length) {
            return i1 + j + k;
          }
          localObject = localObject[i];
          int n = j;
          m = k;
          if (localObject != null)
          {
            m = k + 1;
            n = j + CodedOutputByteBufferNano.a((String)localObject);
          }
          i += 1;
          j = n;
        }
      }
      return i1;
    }
    return i1;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.d;
    if (localObject == null) {}
    for (;;)
    {
      paramCodedOutputByteBufferNano.a(2, this.a);
      localObject = this.b;
      if ((localObject != null) && (localObject.length > 0))
      {
        int i = 0;
        localObject = this.b;
        if (i < localObject.length)
        {
          localObject = localObject[i];
          if (localObject == null) {}
          for (;;)
          {
            i += 1;
            break;
            paramCodedOutputByteBufferNano.a(3, (String)localObject);
          }
        }
      }
      super.a(paramCodedOutputByteBufferNano);
      return;
      paramCodedOutputByteBufferNano.a(1, ((g)localObject).b);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof nc))
      {
        paramObject = (nc)paramObject;
        if (this.d == ((nc)paramObject).d)
        {
          localObject = this.a;
          if (localObject != null) {
            break label106;
          }
          if (((nc)paramObject).a != null) {}
        }
      }
      label106:
      while (((String)localObject).equals(((nc)paramObject).a))
      {
        if (f.a(this.b, ((nc)paramObject).b))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((nc)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((nc)paramObject).unknownFieldData);
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
    for (int i = ((g)localObject).hashCode();; i = 0)
    {
      localObject = this.a;
      if (localObject != null) {}
      for (int j = ((String)localObject).hashCode();; j = 0)
      {
        int i1 = f.a(this.b);
        localObject = this.unknownFieldData;
        int k = m;
        if (localObject != null)
        {
          k = m;
          if (!((d)localObject).a()) {
            k = this.unknownFieldData.hashCode();
          }
        }
        return ((j + (i + (n + 527) * 31) * 31) * 31 + i1) * 31 + k;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/nc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */