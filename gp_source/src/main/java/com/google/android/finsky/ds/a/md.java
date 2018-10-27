package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class md
  extends b
{
  public String a = "";
  public boolean b = false;
  public boolean c = false;
  public boolean d = false;
  public bu e = null;
  private int f = 0;
  private String g = "";
  
  public md()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((this.f & 0x1) != 0) {
      i = j + (CodedOutputByteBufferNano.d(8) + 1);
    }
    j = i;
    if ((this.f & 0x2) != 0) {
      j = i + (CodedOutputByteBufferNano.d(16) + 1);
    }
    i = j;
    if ((this.f & 0x4) != 0) {
      i = j + (CodedOutputByteBufferNano.d(24) + 1);
    }
    j = i;
    if ((this.f & 0x8) != 0) {
      j = i + CodedOutputByteBufferNano.b(4, this.a);
    }
    i = j;
    if ((this.f & 0x10) != 0) {
      i = j + CodedOutputByteBufferNano.b(5, this.g);
    }
    bu localbu = this.e;
    j = i;
    if (localbu != null) {
      j = i + CodedOutputByteBufferNano.d(6, localbu);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.f & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.d);
    }
    if ((this.f & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.c);
    }
    if ((this.f & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.b);
    }
    if ((this.f & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.a);
    }
    if ((this.f & 0x10) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.g);
    }
    bu localbu = this.e;
    if (localbu != null) {
      paramCodedOutputByteBufferNano.b(6, localbu);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof md))
      {
        paramObject = (md)paramObject;
        int i = this.f;
        int j = ((md)paramObject).f;
        if (((i & 0x1) == (j & 0x1)) && (this.d == ((md)paramObject).d) && ((i & 0x2) == (j & 0x2)) && (this.c == ((md)paramObject).c) && ((i & 0x4) == (j & 0x4)) && (this.b == ((md)paramObject).b) && ((i & 0x8) == (j & 0x8)) && (this.a.equals(((md)paramObject).a)) && ((this.f & 0x10) == (((md)paramObject).f & 0x10)) && (this.g.equals(((md)paramObject).g)))
        {
          localObject = this.e;
          if (localObject != null) {
            break label212;
          }
          if (((md)paramObject).e != null) {}
        }
      }
      label212:
      while (((bu)localObject).equals(((md)paramObject).e))
      {
        localObject = this.unknownFieldData;
        if ((localObject == null) || (((d)localObject).a()))
        {
          paramObject = ((md)paramObject).unknownFieldData;
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((md)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 1237;
    int i1 = 0;
    int i2 = getClass().getName().hashCode();
    if (!this.d) {}
    for (int i = 1237;; i = 1231)
    {
      if (!this.c) {}
      for (int j = 1237;; j = 1231)
      {
        if (!this.b) {}
        for (;;)
        {
          int i3 = this.a.hashCode();
          int i4 = this.g.hashCode();
          Object localObject = this.e;
          if (localObject != null) {}
          for (int m = ((bu)localObject).hashCode();; m = 0)
          {
            localObject = this.unknownFieldData;
            int n = i1;
            if (localObject != null)
            {
              n = i1;
              if (!((d)localObject).a()) {
                n = this.unknownFieldData.hashCode();
              }
            }
            return (m + ((((j + (i + (i2 + 527) * 31) * 31) * 31 + k) * 31 + i3) * 31 + i4) * 31) * 31 + n;
          }
          k = 1231;
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/md.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */