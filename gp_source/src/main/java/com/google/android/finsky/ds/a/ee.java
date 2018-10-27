package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.g;

public final class ee
  extends b
{
  public mf a = null;
  public af b = null;
  public ag c = null;
  public ah d = null;
  public String e = "";
  public mf f = null;
  public String g = "";
  public String h = "";
  private int i = 0;
  
  public ee()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int k = super.a();
    Object localObject = this.b;
    int j = k;
    if (localObject != null) {
      j = k + CodedOutputByteBufferNano.d(1, (g)localObject);
    }
    k = j;
    if ((this.i & 0x1) != 0) {
      k = j + CodedOutputByteBufferNano.b(2, this.h);
    }
    j = k;
    if ((this.i & 0x2) != 0) {
      j = k + CodedOutputByteBufferNano.b(3, this.g);
    }
    localObject = this.d;
    k = j;
    if (localObject != null) {
      k = j + CodedOutputByteBufferNano.d(4, (g)localObject);
    }
    j = k;
    if ((this.i & 0x4) != 0) {
      j = k + CodedOutputByteBufferNano.b(5, this.e);
    }
    localObject = this.c;
    k = j;
    if (localObject != null) {
      k = j + CodedOutputByteBufferNano.d(6, (g)localObject);
    }
    localObject = this.f;
    j = k;
    if (localObject != null) {
      j = k + CodedOutputByteBufferNano.d(7, (g)localObject);
    }
    localObject = this.a;
    k = j;
    if (localObject != null) {
      k = j + CodedOutputByteBufferNano.d(8, (g)localObject);
    }
    return k;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(1, (g)localObject);
    }
    if ((this.i & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.h);
    }
    if ((this.i & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.g);
    }
    localObject = this.d;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(4, (g)localObject);
    }
    if ((this.i & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.e);
    }
    localObject = this.c;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(6, (g)localObject);
    }
    localObject = this.f;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(7, (g)localObject);
    }
    localObject = this.a;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(8, (g)localObject);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof ee))
      {
        paramObject = (ee)paramObject;
        localObject = this.b;
        if (localObject != null) {
          break label284;
        }
        if (((ee)paramObject).b != null) {}
      }
      label258:
      label271:
      label284:
      while (((af)localObject).equals(((ee)paramObject).b))
      {
        if (((this.i & 0x1) == (((ee)paramObject).i & 0x1)) && (this.h.equals(((ee)paramObject).h)) && ((this.i & 0x2) == (((ee)paramObject).i & 0x2)) && (this.g.equals(((ee)paramObject).g)))
        {
          localObject = this.d;
          if (localObject != null) {
            break label271;
          }
          if (((ee)paramObject).d != null) {}
        }
        while (((ah)localObject).equals(((ee)paramObject).d))
        {
          if (((this.i & 0x4) == (((ee)paramObject).i & 0x4)) && (this.e.equals(((ee)paramObject).e)))
          {
            localObject = this.c;
            if (localObject != null) {
              break label258;
            }
            if (((ee)paramObject).c != null) {}
          }
          while (((ag)localObject).equals(((ee)paramObject).c))
          {
            localObject = this.f;
            if (localObject == null) {
              if (((ee)paramObject).f != null) {}
            }
            while (((mf)localObject).equals(((ee)paramObject).f))
            {
              localObject = this.a;
              if (localObject == null) {
                if (((ee)paramObject).a != null) {}
              }
              while (((mf)localObject).equals(((ee)paramObject).a))
              {
                localObject = this.unknownFieldData;
                if ((localObject == null) || (((d)localObject).a()))
                {
                  paramObject = ((ee)paramObject).unknownFieldData;
                  return (paramObject == null) || (((d)paramObject).a());
                }
                return this.unknownFieldData.equals(((ee)paramObject).unknownFieldData);
              }
              return false;
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
    int i3 = 0;
    int i4 = getClass().getName().hashCode();
    Object localObject = this.b;
    if (localObject != null) {}
    for (int j = ((af)localObject).hashCode();; j = 0)
    {
      int i5 = this.h.hashCode();
      int i6 = this.g.hashCode();
      localObject = this.d;
      if (localObject != null) {}
      for (int k = ((ah)localObject).hashCode();; k = 0)
      {
        int i7 = this.e.hashCode();
        localObject = this.c;
        if (localObject != null) {}
        for (int m = ((ag)localObject).hashCode();; m = 0)
        {
          localObject = this.f;
          if (localObject != null) {}
          for (int n = ((mf)localObject).hashCode();; n = 0)
          {
            localObject = this.a;
            if (localObject != null) {}
            for (int i1 = ((mf)localObject).hashCode();; i1 = 0)
            {
              localObject = this.unknownFieldData;
              int i2 = i3;
              if (localObject != null)
              {
                i2 = i3;
                if (!((d)localObject).a()) {
                  i2 = this.unknownFieldData.hashCode();
                }
              }
              return (i1 + (n + (m + ((k + (((j + (i4 + 527) * 31) * 31 + i5) * 31 + i6) * 31) * 31 + i7) * 31) * 31) * 31) * 31 + i2;
            }
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */