package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.g;

public final class fx
  extends b
{
  private p a = null;
  private int b = 0;
  private String c = "";
  private fz d = null;
  private es e = null;
  private int f = -1;
  private ia g = null;
  private bu h = null;
  private String i = "";
  private String j = "";
  private String k = "";
  
  public fx()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int n = super.a();
    int m = n;
    if ((this.b & 0x1) != 0) {
      m = n + CodedOutputByteBufferNano.b(1, this.k);
    }
    n = m;
    if ((this.b & 0x2) != 0) {
      n = m + CodedOutputByteBufferNano.b(2, this.j);
    }
    m = n;
    if ((this.b & 0x4) != 0) {
      m = n + CodedOutputByteBufferNano.b(3, this.c);
    }
    n = m;
    if ((this.b & 0x8) != 0) {
      n = m + CodedOutputByteBufferNano.b(4, this.i);
    }
    Object localObject = this.h;
    m = n;
    if (localObject != null) {
      m = n + CodedOutputByteBufferNano.d(5, (g)localObject);
    }
    n = m;
    if (this.f == 0) {
      n = m + CodedOutputByteBufferNano.d(6, this.e);
    }
    m = n;
    if (this.f == 1) {
      m = n + CodedOutputByteBufferNano.d(8, this.g);
    }
    n = m;
    if (this.f == 2) {
      n = m + CodedOutputByteBufferNano.d(9, this.a);
    }
    localObject = this.d;
    m = n;
    if (localObject != null) {
      m = n + CodedOutputByteBufferNano.d(10, (g)localObject);
    }
    return m;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.b & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.k);
    }
    if ((this.b & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.j);
    }
    if ((this.b & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.c);
    }
    if ((this.b & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.i);
    }
    Object localObject = this.h;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(5, (g)localObject);
    }
    if (this.f == 0) {
      paramCodedOutputByteBufferNano.b(6, this.e);
    }
    if (this.f == 1) {
      paramCodedOutputByteBufferNano.b(8, this.g);
    }
    if (this.f == 2) {
      paramCodedOutputByteBufferNano.b(9, this.a);
    }
    localObject = this.d;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(10, (g)localObject);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof fx))
      {
        paramObject = (fx)paramObject;
        if (((this.b & 0x1) == (((fx)paramObject).b & 0x1)) && (this.k.equals(((fx)paramObject).k)) && ((this.b & 0x2) == (((fx)paramObject).b & 0x2)) && (this.j.equals(((fx)paramObject).j)) && ((this.b & 0x4) == (((fx)paramObject).b & 0x4)) && (this.c.equals(((fx)paramObject).c)) && ((this.b & 0x8) == (((fx)paramObject).b & 0x8)) && (this.i.equals(((fx)paramObject).i)))
        {
          localObject = this.h;
          if (localObject != null) {
            break label315;
          }
          if (((fx)paramObject).h != null) {}
        }
      }
      label315:
      while (((bu)localObject).equals(((fx)paramObject).h))
      {
        localObject = this.e;
        if (localObject == null) {
          if (((fx)paramObject).e != null) {}
        }
        while (((es)localObject).equals(((fx)paramObject).e))
        {
          localObject = this.g;
          if (localObject == null) {
            if (((fx)paramObject).g != null) {}
          }
          while (((ia)localObject).equals(((fx)paramObject).g))
          {
            localObject = this.a;
            if (localObject == null) {
              if (((fx)paramObject).a != null) {}
            }
            while (((p)localObject).equals(((fx)paramObject).a))
            {
              localObject = this.d;
              if (localObject == null) {
                if (((fx)paramObject).d != null) {}
              }
              while (((fz)localObject).equals(((fx)paramObject).d))
              {
                localObject = this.unknownFieldData;
                if ((localObject == null) || (((d)localObject).a()))
                {
                  paramObject = ((fx)paramObject).unknownFieldData;
                  return (paramObject == null) || (((d)paramObject).a());
                }
                return this.unknownFieldData.equals(((fx)paramObject).unknownFieldData);
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
    Object localObject2 = null;
    int i5 = 0;
    int i6 = getClass().getName().hashCode();
    int i7 = this.k.hashCode();
    int i8 = this.j.hashCode();
    int i9 = this.c.hashCode();
    int i10 = this.i.hashCode();
    Object localObject1 = this.h;
    if (localObject1 != null) {}
    for (int m = ((bu)localObject1).hashCode();; m = 0)
    {
      localObject1 = this.e;
      if (this.f != 0) {
        localObject1 = null;
      }
      if (localObject1 != null) {}
      for (int n = ((es)localObject1).hashCode();; n = 0)
      {
        localObject1 = this.g;
        if (this.f != 1) {
          localObject1 = null;
        }
        if (localObject1 != null) {}
        for (int i1 = ((ia)localObject1).hashCode();; i1 = 0)
        {
          localObject1 = this.a;
          if (this.f != 2) {
            localObject1 = localObject2;
          }
          for (;;)
          {
            if (localObject1 != null) {}
            for (int i2 = ((p)localObject1).hashCode();; i2 = 0)
            {
              localObject1 = this.d;
              if (localObject1 != null) {}
              for (int i3 = ((fz)localObject1).hashCode();; i3 = 0)
              {
                localObject1 = this.unknownFieldData;
                int i4 = i5;
                if (localObject1 != null)
                {
                  i4 = i5;
                  if (!((d)localObject1).a()) {
                    i4 = this.unknownFieldData.hashCode();
                  }
                }
                return (i3 + (i2 + ((((((((i6 + 527) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + m) * 31 + n) * 31 + i1) * 31) * 31) * 31 + i4;
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/fx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */