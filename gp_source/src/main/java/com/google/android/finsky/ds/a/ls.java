package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.g;

public final class ls
  extends b
{
  public String a = "";
  public ln b = null;
  public String c = "";
  public lq d = null;
  public lr e = null;
  public fb f = null;
  public String g = "";
  public String h = "";
  private int i = 0;
  
  public ls()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int k = super.a();
    Object localObject = this.d;
    int j = k;
    if (localObject != null) {
      j = k + CodedOutputByteBufferNano.d(1, (g)localObject);
    }
    k = j;
    if ((this.i & 0x1) != 0) {
      k = j + CodedOutputByteBufferNano.b(2, this.g);
    }
    j = k;
    if ((this.i & 0x2) != 0) {
      j = k + CodedOutputByteBufferNano.b(3, this.c);
    }
    k = j;
    if ((this.i & 0x4) != 0) {
      k = j + CodedOutputByteBufferNano.b(4, this.a);
    }
    localObject = this.b;
    j = k;
    if (localObject != null) {
      j = k + CodedOutputByteBufferNano.d(5, (g)localObject);
    }
    localObject = this.f;
    k = j;
    if (localObject != null) {
      k = j + CodedOutputByteBufferNano.d(6, (g)localObject);
    }
    j = k;
    if ((this.i & 0x8) != 0) {
      j = k + CodedOutputByteBufferNano.b(7, this.h);
    }
    localObject = this.e;
    k = j;
    if (localObject != null) {
      k = j + CodedOutputByteBufferNano.d(8, (g)localObject);
    }
    return k;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.d;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(1, (g)localObject);
    }
    if ((this.i & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.g);
    }
    if ((this.i & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.c);
    }
    if ((this.i & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.a);
    }
    localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(5, (g)localObject);
    }
    localObject = this.f;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(6, (g)localObject);
    }
    if ((this.i & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(7, this.h);
    }
    localObject = this.e;
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
      if ((paramObject instanceof ls))
      {
        paramObject = (ls)paramObject;
        localObject = this.d;
        if (localObject != null) {
          break label286;
        }
        if (((ls)paramObject).d != null) {}
      }
      label260:
      label273:
      label286:
      while (((lq)localObject).equals(((ls)paramObject).d))
      {
        if (((this.i & 0x1) == (((ls)paramObject).i & 0x1)) && (this.g.equals(((ls)paramObject).g)) && ((this.i & 0x2) == (((ls)paramObject).i & 0x2)) && (this.c.equals(((ls)paramObject).c)))
        {
          localObject = this.e;
          if (localObject != null) {
            break label273;
          }
          if (((ls)paramObject).e != null) {}
        }
        while (((lr)localObject).equals(((ls)paramObject).e))
        {
          if (((this.i & 0x4) == (((ls)paramObject).i & 0x4)) && (this.a.equals(((ls)paramObject).a)))
          {
            localObject = this.b;
            if (localObject != null) {
              break label260;
            }
            if (((ls)paramObject).b != null) {}
          }
          while (((ln)localObject).equals(((ls)paramObject).b))
          {
            localObject = this.f;
            if (localObject == null) {
              if (((ls)paramObject).f != null) {}
            }
            while (((fb)localObject).equals(((ls)paramObject).f))
            {
              if (((this.i & 0x8) == (((ls)paramObject).i & 0x8)) && (this.h.equals(((ls)paramObject).h)))
              {
                localObject = this.unknownFieldData;
                if ((localObject == null) || (((d)localObject).a())) {
                  paramObject = ((ls)paramObject).unknownFieldData;
                }
              }
              else
              {
                return (paramObject == null) || (((d)paramObject).a());
              }
              return this.unknownFieldData.equals(((ls)paramObject).unknownFieldData);
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
    int i2 = 0;
    int i3 = getClass().getName().hashCode();
    Object localObject = this.d;
    if (localObject != null) {}
    for (int j = ((lq)localObject).hashCode();; j = 0)
    {
      int i4 = this.g.hashCode();
      int i5 = this.c.hashCode();
      localObject = this.e;
      if (localObject != null) {}
      for (int k = ((lr)localObject).hashCode();; k = 0)
      {
        int i6 = this.a.hashCode();
        localObject = this.b;
        if (localObject != null) {}
        for (int m = ((ln)localObject).hashCode();; m = 0)
        {
          localObject = this.f;
          if (localObject != null) {}
          for (int n = ((fb)localObject).hashCode();; n = 0)
          {
            int i7 = this.h.hashCode();
            localObject = this.unknownFieldData;
            int i1 = i2;
            if (localObject != null)
            {
              i1 = i2;
              if (!((d)localObject).a()) {
                i1 = this.unknownFieldData.hashCode();
              }
            }
            return ((n + (m + ((k + (((j + (i3 + 527) * 31) * 31 + i4) * 31 + i5) * 31) * 31 + i6) * 31) * 31) * 31 + i7) * 31 + i1;
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/ls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */