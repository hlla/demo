package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.g;

public final class ec
  extends b
{
  public af a = null;
  public ag b = null;
  public String c = "";
  public mf d = null;
  public ah e = null;
  public String f = "";
  private int g = 0;
  
  public ec()
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
    j = i;
    if ((this.g & 0x1) != 0) {
      j = i + CodedOutputByteBufferNano.b(2, this.f);
    }
    localObject = this.e;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(3, (g)localObject);
    }
    j = i;
    if ((this.g & 0x2) != 0) {
      j = i + CodedOutputByteBufferNano.b(4, this.c);
    }
    localObject = this.b;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(5, (g)localObject);
    }
    localObject = this.d;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.d(6, (g)localObject);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.a;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(1, (g)localObject);
    }
    if ((this.g & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.f);
    }
    localObject = this.e;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(3, (g)localObject);
    }
    if ((this.g & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.c);
    }
    localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(5, (g)localObject);
    }
    localObject = this.d;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(6, (g)localObject);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof ec))
      {
        paramObject = (ec)paramObject;
        localObject = this.a;
        if (localObject != null) {
          break label226;
        }
        if (((ec)paramObject).a != null) {}
      }
      label200:
      label213:
      label226:
      while (((af)localObject).equals(((ec)paramObject).a))
      {
        if (((this.g & 0x1) == (((ec)paramObject).g & 0x1)) && (this.f.equals(((ec)paramObject).f)))
        {
          localObject = this.e;
          if (localObject != null) {
            break label213;
          }
          if (((ec)paramObject).e != null) {}
        }
        while (((ah)localObject).equals(((ec)paramObject).e))
        {
          if (((this.g & 0x2) == (((ec)paramObject).g & 0x2)) && (this.c.equals(((ec)paramObject).c)))
          {
            localObject = this.b;
            if (localObject != null) {
              break label200;
            }
            if (((ec)paramObject).b != null) {}
          }
          while (((ag)localObject).equals(((ec)paramObject).b))
          {
            localObject = this.d;
            if (localObject == null) {
              if (((ec)paramObject).d != null) {}
            }
            while (((mf)localObject).equals(((ec)paramObject).d))
            {
              localObject = this.unknownFieldData;
              if ((localObject == null) || (((d)localObject).a()))
              {
                paramObject = ((ec)paramObject).unknownFieldData;
                return (paramObject == null) || (((d)paramObject).a());
              }
              return this.unknownFieldData.equals(((ec)paramObject).unknownFieldData);
            }
            return false;
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
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = ((af)localObject).hashCode();; i = 0)
    {
      int i3 = this.f.hashCode();
      localObject = this.e;
      if (localObject != null) {}
      for (int j = ((ah)localObject).hashCode();; j = 0)
      {
        int i4 = this.c.hashCode();
        localObject = this.b;
        if (localObject != null) {}
        for (int k = ((ag)localObject).hashCode();; k = 0)
        {
          localObject = this.d;
          if (localObject != null) {}
          for (int m = ((mf)localObject).hashCode();; m = 0)
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
            return (m + (k + ((j + ((i + (i2 + 527) * 31) * 31 + i3) * 31) * 31 + i4) * 31) * 31) * 31 + n;
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */