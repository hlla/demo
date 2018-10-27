package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;

public final class jz
  extends b
{
  private static volatile jz[] e;
  public int a = 0;
  public String b = "";
  public int c = -1;
  public int d = 0;
  private boolean f = false;
  private long g = 0L;
  private String h = "";
  
  public jz()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static jz[] b()
  {
    if (e == null) {}
    synchronized (f.a)
    {
      if (e == null) {
        e = new jz[0];
      }
      return e;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.a & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.b(1, this.b);
    }
    j = i;
    if (this.c == 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.h);
    }
    i = j;
    if (this.c == 1) {
      i = j + (CodedOutputByteBufferNano.d(24) + 1);
    }
    j = i;
    if (this.c == 2) {
      j = i + CodedOutputByteBufferNano.f(4, this.g);
    }
    i = j;
    if (this.c == 3) {
      i = j + CodedOutputByteBufferNano.d(5, this.d);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.b);
    }
    if (this.c == 0) {
      paramCodedOutputByteBufferNano.a(2, this.h);
    }
    if (this.c == 1) {
      paramCodedOutputByteBufferNano.a(3, this.f);
    }
    if (this.c == 2) {
      paramCodedOutputByteBufferNano.b(4, this.g);
    }
    if (this.c == 3) {
      paramCodedOutputByteBufferNano.a(5, this.d);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final String c()
  {
    if (this.c != 0) {
      return "";
    }
    return this.h;
  }
  
  public final boolean d()
  {
    return this.c == 0;
  }
  
  public final boolean e()
  {
    if (this.c != 1) {
      return false;
    }
    return this.f;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      int i;
      if ((paramObject instanceof jz))
      {
        paramObject = (jz)paramObject;
        if (((this.a & 0x1) == (((jz)paramObject).a & 0x1)) && (this.b.equals(((jz)paramObject).b)))
        {
          i = this.c;
          if (i == ((jz)paramObject).c) {
            if (i == 0) {
              break label190;
            }
          }
        }
      }
      label177:
      label190:
      while (this.h.equals(((jz)paramObject).h))
      {
        i = this.c;
        int j = ((jz)paramObject).c;
        if ((i == j) && ((i != 1) || (this.f == ((jz)paramObject).f)) && (i == j) && ((i != 2) || (this.g == ((jz)paramObject).g)) && (i == j)) {
          if (i == 3) {
            break label177;
          }
        }
        while (this.d == ((jz)paramObject).d)
        {
          d locald = this.unknownFieldData;
          if ((locald == null) || (locald.a()))
          {
            paramObject = ((jz)paramObject).unknownFieldData;
            return (paramObject == null) || (((d)paramObject).a());
          }
          return this.unknownFieldData.equals(((jz)paramObject).unknownFieldData);
        }
        return false;
      }
      return false;
    }
    return true;
  }
  
  public final boolean f()
  {
    boolean bool = true;
    if (this.c != 1) {
      bool = false;
    }
    return bool;
  }
  
  public final long g()
  {
    if (this.c != 2) {
      return 0L;
    }
    return this.g;
  }
  
  public final boolean h()
  {
    return this.c == 2;
  }
  
  public final int hashCode()
  {
    int m = 0;
    int n = getClass().getName().hashCode();
    int i1 = this.b.hashCode();
    Object localObject = this.h;
    if (this.c != 0) {
      localObject = "";
    }
    int i2 = ((String)localObject).hashCode();
    boolean bool = this.f;
    int k = this.c;
    if (k != 1) {
      bool = false;
    }
    if (!bool) {}
    for (int i = 1237;; i = 1231)
    {
      long l = this.g;
      if (k != 2) {
        l = 0L;
      }
      int i3 = (int)(l ^ l >>> 32);
      int j = this.d;
      if (k != 3) {
        j = 0;
      }
      localObject = this.unknownFieldData;
      k = m;
      if (localObject != null)
      {
        k = m;
        if (!((d)localObject).a()) {
          k = this.unknownFieldData.hashCode();
        }
      }
      return (j + ((((i1 + (n + 527) * 31) * 31 + i2) * 31 + i) * 31 + i3) * 31) * 31 + k;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/jz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */