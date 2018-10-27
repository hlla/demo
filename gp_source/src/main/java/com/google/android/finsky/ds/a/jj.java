package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.g;
import com.google.protobuf.nano.j;
import java.util.Arrays;

public final class jj
  extends b
{
  public ig a = null;
  public bp b = null;
  public String c = "";
  public byte[] d = j.b;
  public bu e = null;
  private int f = 0;
  
  public jj()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    Object localObject = this.a;
    int i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(1, (g)localObject);
    }
    localObject = this.b;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.d(2, (g)localObject);
    }
    localObject = this.e;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(3, (g)localObject);
    }
    j = i;
    if ((this.f & 0x1) != 0) {
      j = i + CodedOutputByteBufferNano.b(4, this.d);
    }
    i = j;
    if ((this.f & 0x2) != 0) {
      i = j + CodedOutputByteBufferNano.b(5, this.c);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.a;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(1, (g)localObject);
    }
    localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(2, (g)localObject);
    }
    localObject = this.e;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(3, (g)localObject);
    }
    if ((this.f & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.d);
    }
    if ((this.f & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.c);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof jj))
      {
        paramObject = (jj)paramObject;
        localObject = this.a;
        if (localObject != null) {
          break label197;
        }
        if (((jj)paramObject).a != null) {}
      }
      label197:
      while (((ig)localObject).equals(((jj)paramObject).a))
      {
        localObject = this.b;
        if (localObject == null) {
          if (((jj)paramObject).b != null) {}
        }
        while (((bp)localObject).equals(((jj)paramObject).b))
        {
          localObject = this.e;
          if (localObject == null) {
            if (((jj)paramObject).e != null) {}
          }
          while (((bu)localObject).equals(((jj)paramObject).e))
          {
            if (((this.f & 0x1) == (((jj)paramObject).f & 0x1)) && (Arrays.equals(this.d, ((jj)paramObject).d)) && ((this.f & 0x2) == (((jj)paramObject).f & 0x2)) && (this.c.equals(((jj)paramObject).c)))
            {
              localObject = this.unknownFieldData;
              if ((localObject == null) || (((d)localObject).a())) {
                paramObject = ((jj)paramObject).unknownFieldData;
              }
            }
            else
            {
              return (paramObject == null) || (((d)paramObject).a());
            }
            return this.unknownFieldData.equals(((jj)paramObject).unknownFieldData);
          }
          return false;
        }
        return false;
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int n = 0;
    int i1 = getClass().getName().hashCode();
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = ((ig)localObject).hashCode();; i = 0)
    {
      localObject = this.b;
      if (localObject != null) {}
      for (int j = ((bp)localObject).hashCode();; j = 0)
      {
        localObject = this.e;
        if (localObject != null) {}
        for (int k = ((bu)localObject).hashCode();; k = 0)
        {
          int i2 = Arrays.hashCode(this.d);
          int i3 = this.c.hashCode();
          localObject = this.unknownFieldData;
          int m = n;
          if (localObject != null)
          {
            m = n;
            if (!((d)localObject).a()) {
              m = this.unknownFieldData.hashCode();
            }
          }
          return (((k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31 + i2) * 31 + i3) * 31 + m;
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/jj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */