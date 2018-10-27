package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.d;

public final class b
  extends com.google.protobuf.nano.b
{
  public a a = null;
  public ar b = null;
  public cu c = null;
  public fb d = null;
  public int e = -1;
  public hl f = null;
  private dn g = null;
  private jf h = null;
  
  public b()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if (this.e == 0) {
      i = j + CodedOutputByteBufferNano.d(1, this.d);
    }
    cu localcu = this.c;
    j = i;
    if (localcu != null) {
      j = i + CodedOutputByteBufferNano.d(2, localcu);
    }
    i = j;
    if (this.e == 1) {
      i = j + CodedOutputByteBufferNano.d(3, this.g);
    }
    j = i;
    if (this.e == 2) {
      j = i + CodedOutputByteBufferNano.d(4, this.f);
    }
    i = j;
    if (this.e == 3) {
      i = j + CodedOutputByteBufferNano.d(5, this.h);
    }
    j = i;
    if (this.e == 4) {
      j = i + CodedOutputByteBufferNano.d(6, this.b);
    }
    i = j;
    if (this.e == 5) {
      i = j + CodedOutputByteBufferNano.d(7, this.a);
    }
    return i;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.e == 0) {
      paramCodedOutputByteBufferNano.b(1, this.d);
    }
    cu localcu = this.c;
    if (localcu != null) {
      paramCodedOutputByteBufferNano.b(2, localcu);
    }
    if (this.e == 1) {
      paramCodedOutputByteBufferNano.b(3, this.g);
    }
    if (this.e == 2) {
      paramCodedOutputByteBufferNano.b(4, this.f);
    }
    if (this.e == 3) {
      paramCodedOutputByteBufferNano.b(5, this.h);
    }
    if (this.e == 4) {
      paramCodedOutputByteBufferNano.b(6, this.b);
    }
    if (this.e == 5) {
      paramCodedOutputByteBufferNano.b(7, this.a);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean b()
  {
    return this.e == 2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        localObject = this.d;
        if (localObject != null) {
          break label255;
        }
        if (((b)paramObject).d != null) {}
      }
      label255:
      while (((fb)localObject).equals(((b)paramObject).d))
      {
        localObject = this.g;
        if (localObject == null) {
          if (((b)paramObject).g != null) {}
        }
        while (((dn)localObject).equals(((b)paramObject).g))
        {
          localObject = this.f;
          if (localObject == null) {
            if (((b)paramObject).f != null) {}
          }
          while (((hl)localObject).equals(((b)paramObject).f))
          {
            localObject = this.h;
            if (localObject == null) {
              if (((b)paramObject).h != null) {}
            }
            while (((jf)localObject).equals(((b)paramObject).h))
            {
              localObject = this.b;
              if (localObject == null) {
                if (((b)paramObject).b != null) {}
              }
              while (((ar)localObject).equals(((b)paramObject).b))
              {
                localObject = this.a;
                if (localObject == null) {
                  if (((b)paramObject).a != null) {}
                }
                while (((a)localObject).equals(((b)paramObject).a))
                {
                  localObject = this.c;
                  if (localObject == null) {
                    if (((b)paramObject).c != null) {}
                  }
                  while (((cu)localObject).equals(((b)paramObject).c))
                  {
                    localObject = this.unknownFieldData;
                    if ((localObject == null) || (((d)localObject).a()))
                    {
                      paramObject = ((b)paramObject).unknownFieldData;
                      return (paramObject == null) || (((d)paramObject).a());
                    }
                    return this.unknownFieldData.equals(((b)paramObject).unknownFieldData);
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
        return false;
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    Object localObject2 = null;
    int i4 = 0;
    int i5 = getClass().getName().hashCode();
    Object localObject1 = this.d;
    if (this.e != 0) {
      localObject1 = null;
    }
    if (localObject1 != null) {}
    for (int i = ((fb)localObject1).hashCode();; i = 0)
    {
      localObject1 = this.g;
      if (this.e != 1) {
        localObject1 = null;
      }
      if (localObject1 != null) {}
      for (int j = ((dn)localObject1).hashCode();; j = 0)
      {
        localObject1 = this.f;
        if (this.e != 2) {
          localObject1 = null;
        }
        if (localObject1 != null) {}
        for (int k = ((hl)localObject1).hashCode();; k = 0)
        {
          localObject1 = this.h;
          if (this.e != 3) {
            localObject1 = null;
          }
          if (localObject1 != null) {}
          for (int m = ((jf)localObject1).hashCode();; m = 0)
          {
            localObject1 = this.b;
            if (this.e != 4) {
              localObject1 = null;
            }
            if (localObject1 != null) {}
            for (int n = ((ar)localObject1).hashCode();; n = 0)
            {
              localObject1 = this.a;
              if (this.e != 5) {
                localObject1 = localObject2;
              }
              for (;;)
              {
                if (localObject1 != null) {}
                for (int i1 = ((a)localObject1).hashCode();; i1 = 0)
                {
                  localObject1 = this.c;
                  if (localObject1 != null) {}
                  for (int i2 = ((cu)localObject1).hashCode();; i2 = 0)
                  {
                    localObject1 = this.unknownFieldData;
                    int i3 = i4;
                    if (localObject1 != null)
                    {
                      i3 = i4;
                      if (!((d)localObject1).a()) {
                        i3 = this.unknownFieldData.hashCode();
                      }
                    }
                    return (i2 + (i1 + ((((((i5 + 527) * 31 + i) * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31) * 31) * 31 + i3;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */