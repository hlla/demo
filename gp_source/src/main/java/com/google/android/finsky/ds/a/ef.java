package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.g;

public final class ef
  extends b
{
  public af a = null;
  public ag b = null;
  public ah c = null;
  public mf d = null;
  public String e = "";
  public String f = "";
  private int g = 0;
  
  public ef()
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
    i = j;
    if ((this.g & 0x2) != 0) {
      i = j + CodedOutputByteBufferNano.b(3, this.e);
    }
    localObject = this.c;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.d(4, (g)localObject);
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
    if ((this.g & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.e);
    }
    localObject = this.c;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(4, (g)localObject);
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
      if ((paramObject instanceof ef))
      {
        paramObject = (ef)paramObject;
        localObject = this.a;
        if (localObject != null) {
          break label226;
        }
        if (((ef)paramObject).a != null) {}
      }
      label213:
      label226:
      while (((af)localObject).equals(((ef)paramObject).a))
      {
        if (((this.g & 0x1) == (((ef)paramObject).g & 0x1)) && (this.f.equals(((ef)paramObject).f)) && ((this.g & 0x2) == (((ef)paramObject).g & 0x2)) && (this.e.equals(((ef)paramObject).e)))
        {
          localObject = this.c;
          if (localObject != null) {
            break label213;
          }
          if (((ef)paramObject).c != null) {}
        }
        while (((ah)localObject).equals(((ef)paramObject).c))
        {
          localObject = this.b;
          if (localObject == null) {
            if (((ef)paramObject).b != null) {}
          }
          while (((ag)localObject).equals(((ef)paramObject).b))
          {
            localObject = this.d;
            if (localObject == null) {
              if (((ef)paramObject).d != null) {}
            }
            while (((mf)localObject).equals(((ef)paramObject).d))
            {
              localObject = this.unknownFieldData;
              if ((localObject == null) || (((d)localObject).a()))
              {
                paramObject = ((ef)paramObject).unknownFieldData;
                return (paramObject == null) || (((d)paramObject).a());
              }
              return this.unknownFieldData.equals(((ef)paramObject).unknownFieldData);
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
      int i4 = this.e.hashCode();
      localObject = this.c;
      if (localObject != null) {}
      for (int j = ((ah)localObject).hashCode();; j = 0)
      {
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
            return (m + (k + (j + (((i + (i2 + 527) * 31) * 31 + i3) * 31 + i4) * 31) * 31) * 31) * 31 + n;
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */