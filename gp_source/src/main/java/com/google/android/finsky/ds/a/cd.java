package com.google.android.finsky.ds.a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.bb;
import com.google.protobuf.cl;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.g;
import com.google.wireless.android.finsky.d.al;

public final class cd
  extends b
{
  private int a = 0;
  private al b = null;
  private al c = null;
  private ce d = null;
  private boolean e = false;
  
  public cd()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    Object localObject = this.c;
    int i = j;
    if (localObject != null) {
      i = j + CodedOutputStream.c(1, (cl)localObject);
    }
    localObject = this.b;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputStream.c(2, (cl)localObject);
    }
    i = j;
    if ((this.a & 0x1) != 0) {
      i = j + (CodedOutputByteBufferNano.d(32) + 1);
    }
    localObject = this.d;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.d(5, (g)localObject);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.c;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.a(1, (cl)localObject);
    }
    localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.a(2, (cl)localObject);
    }
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.e);
    }
    localObject = this.d;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(5, (g)localObject);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof cd))
      {
        paramObject = (cd)paramObject;
        localObject = this.c;
        if (localObject != null) {
          break label165;
        }
        if (((cd)paramObject).c != null) {}
      }
      label139:
      label165:
      while (((bb)localObject).equals(((cd)paramObject).c))
      {
        localObject = this.b;
        if (localObject == null) {
          if (((cd)paramObject).b != null) {}
        }
        while (((bb)localObject).equals(((cd)paramObject).b))
        {
          if (((this.a & 0x1) == (((cd)paramObject).a & 0x1)) && (this.e == ((cd)paramObject).e))
          {
            localObject = this.d;
            if (localObject != null) {
              break label139;
            }
            if (((cd)paramObject).d != null) {}
          }
          while (((ce)localObject).equals(((cd)paramObject).d))
          {
            localObject = this.unknownFieldData;
            if ((localObject == null) || (((d)localObject).a()))
            {
              paramObject = ((cd)paramObject).unknownFieldData;
              return (paramObject == null) || (((d)paramObject).a());
            }
            return this.unknownFieldData.equals(((cd)paramObject).unknownFieldData);
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
    int i1 = 0;
    int i2 = getClass().getName().hashCode();
    Object localObject = this.c;
    if (localObject != null) {}
    for (int i = ((bb)localObject).hashCode();; i = 0)
    {
      localObject = this.b;
      if (localObject != null) {}
      for (int j = ((bb)localObject).hashCode();; j = 0)
      {
        if (!this.e) {}
        for (int k = 1237;; k = 1231)
        {
          localObject = this.d;
          if (localObject != null) {}
          for (int m = ((ce)localObject).hashCode();; m = 0)
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
            return (m + (k + (j + (i + (i2 + 527) * 31) * 31) * 31) * 31) * 31 + n;
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */