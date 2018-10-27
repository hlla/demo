package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.g;

public final class af
  extends com.google.protobuf.nano.b
{
  public b a = null;
  public String b = "";
  public cv c = null;
  public nf d = null;
  private int e = 0;
  
  public af()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    Object localObject = this.d;
    int i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(1, (g)localObject);
    }
    localObject = this.c;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.d(2, (g)localObject);
    }
    localObject = this.a;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(3, (g)localObject);
    }
    j = i;
    if ((this.e & 0x1) != 0) {
      j = i + CodedOutputByteBufferNano.b(4, this.b);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.d;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(1, (g)localObject);
    }
    localObject = this.c;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(2, (g)localObject);
    }
    localObject = this.a;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(3, (g)localObject);
    }
    if ((this.e & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.b);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof af))
      {
        paramObject = (af)paramObject;
        localObject = this.d;
        if (localObject != null) {
          break label168;
        }
        if (((af)paramObject).d != null) {}
      }
      label168:
      while (((nf)localObject).equals(((af)paramObject).d))
      {
        localObject = this.c;
        if (localObject == null) {
          if (((af)paramObject).c != null) {}
        }
        while (((cv)localObject).equals(((af)paramObject).c))
        {
          localObject = this.a;
          if (localObject == null) {
            if (((af)paramObject).a != null) {}
          }
          while (((b)localObject).equals(((af)paramObject).a))
          {
            if (((this.e & 0x1) == (((af)paramObject).e & 0x1)) && (this.b.equals(((af)paramObject).b)))
            {
              localObject = this.unknownFieldData;
              if ((localObject == null) || (((d)localObject).a())) {
                paramObject = ((af)paramObject).unknownFieldData;
              }
            }
            else
            {
              return (paramObject == null) || (((d)paramObject).a());
            }
            return this.unknownFieldData.equals(((af)paramObject).unknownFieldData);
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
    Object localObject = this.d;
    if (localObject != null) {}
    for (int i = ((nf)localObject).hashCode();; i = 0)
    {
      localObject = this.c;
      if (localObject != null) {}
      for (int j = ((cv)localObject).hashCode();; j = 0)
      {
        localObject = this.a;
        if (localObject != null) {}
        for (int k = ((b)localObject).hashCode();; k = 0)
        {
          int i2 = this.b.hashCode();
          localObject = this.unknownFieldData;
          int m = n;
          if (localObject != null)
          {
            m = n;
            if (!((d)localObject).a()) {
              m = this.unknownFieldData.hashCode();
            }
          }
          return ((k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31 + i2) * 31 + m;
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */