package com.google.android.finsky.ds.a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.bb;
import com.google.protobuf.cl;
import com.google.protobuf.dx;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.g;

public final class fe
  extends b
{
  public String a = "";
  public String b = "";
  public dx c = null;
  public dx d = null;
  public bu e = null;
  public String f = "";
  private int g = 0;
  
  public fe()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    Object localObject = this.e;
    int i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(1, (g)localObject);
    }
    j = i;
    if ((this.g & 0x1) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.f);
    }
    i = j;
    if ((this.g & 0x2) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.a);
    }
    localObject = this.d;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputStream.c(4, (cl)localObject);
    }
    localObject = this.c;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputStream.c(5, (cl)localObject);
    }
    j = i;
    if ((this.g & 0x4) != 0) {
      j = i + CodedOutputByteBufferNano.b(6, this.b);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.e;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(1, (g)localObject);
    }
    if ((this.g & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.f);
    }
    if ((this.g & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.a);
    }
    localObject = this.d;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.a(4, (cl)localObject);
    }
    localObject = this.c;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.a(5, (cl)localObject);
    }
    if ((this.g & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(6, this.b);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof fe))
      {
        paramObject = (fe)paramObject;
        localObject = this.e;
        if (localObject != null) {
          break label226;
        }
        if (((fe)paramObject).e != null) {}
      }
      label213:
      label226:
      while (((bu)localObject).equals(((fe)paramObject).e))
      {
        if (((this.g & 0x1) == (((fe)paramObject).g & 0x1)) && (this.f.equals(((fe)paramObject).f)) && ((this.g & 0x2) == (((fe)paramObject).g & 0x2)) && (this.a.equals(((fe)paramObject).a)))
        {
          localObject = this.d;
          if (localObject != null) {
            break label213;
          }
          if (((fe)paramObject).d != null) {}
        }
        while (((bb)localObject).equals(((fe)paramObject).d))
        {
          localObject = this.c;
          if (localObject == null) {
            if (((fe)paramObject).c != null) {}
          }
          while (((bb)localObject).equals(((fe)paramObject).c))
          {
            if (((this.g & 0x4) == (((fe)paramObject).g & 0x4)) && (this.b.equals(((fe)paramObject).b)))
            {
              localObject = this.unknownFieldData;
              if ((localObject == null) || (((d)localObject).a())) {
                paramObject = ((fe)paramObject).unknownFieldData;
              }
            }
            else
            {
              return (paramObject == null) || (((d)paramObject).a());
            }
            return this.unknownFieldData.equals(((fe)paramObject).unknownFieldData);
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
    Object localObject = this.e;
    if (localObject != null) {}
    for (int i = ((bu)localObject).hashCode();; i = 0)
    {
      int i2 = this.f.hashCode();
      int i3 = this.a.hashCode();
      localObject = this.d;
      if (localObject != null) {}
      for (int j = ((bb)localObject).hashCode();; j = 0)
      {
        localObject = this.c;
        if (localObject != null) {}
        for (int k = ((bb)localObject).hashCode();; k = 0)
        {
          int i4 = this.b.hashCode();
          localObject = this.unknownFieldData;
          int m = n;
          if (localObject != null)
          {
            m = n;
            if (!((d)localObject).a()) {
              m = this.unknownFieldData.hashCode();
            }
          }
          return ((k + (j + (((i + (i1 + 527) * 31) * 31 + i2) * 31 + i3) * 31) * 31) * 31 + i4) * 31 + m;
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/fe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */