package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.j;
import java.util.Arrays;

public final class cp
  extends b
{
  private static volatile cp[] i;
  public String a = "";
  public f b = null;
  public l c = null;
  public bu d = null;
  public int e = -1;
  public byte[] f = j.b;
  public String g = "";
  public String h = "";
  private int j = 0;
  private er k = null;
  
  public cp()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static cp[] b()
  {
    if (i == null) {}
    synchronized (com.google.protobuf.nano.f.a)
    {
      if (i == null) {
        i = new cp[0];
      }
      return i;
    }
  }
  
  protected final int a()
  {
    int n = super.a();
    int m = n;
    if ((this.j & 0x1) != 0) {
      m = n + CodedOutputByteBufferNano.b(1, this.h);
    }
    bu localbu = this.d;
    n = m;
    if (localbu != null) {
      n = m + CodedOutputByteBufferNano.d(2, localbu);
    }
    m = n;
    if ((this.j & 0x2) != 0) {
      m = n + CodedOutputByteBufferNano.b(3, this.g);
    }
    n = m;
    if ((this.j & 0x8) != 0) {
      n = m + CodedOutputByteBufferNano.b(4, this.f);
    }
    m = n;
    if (this.e == 0) {
      m = n + CodedOutputByteBufferNano.d(5, this.c);
    }
    n = m;
    if (this.e == 1) {
      n = m + CodedOutputByteBufferNano.d(6, this.k);
    }
    m = n;
    if (this.e == 2) {
      m = n + CodedOutputByteBufferNano.d(7, this.b);
    }
    n = m;
    if ((this.j & 0x4) != 0) {
      n = m + CodedOutputByteBufferNano.b(8, this.a);
    }
    return n;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.j & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.h);
    }
    bu localbu = this.d;
    if (localbu != null) {
      paramCodedOutputByteBufferNano.b(2, localbu);
    }
    if ((this.j & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.g);
    }
    if ((this.j & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.f);
    }
    if (this.e == 0) {
      paramCodedOutputByteBufferNano.b(5, this.c);
    }
    if (this.e == 1) {
      paramCodedOutputByteBufferNano.b(6, this.k);
    }
    if (this.e == 2) {
      paramCodedOutputByteBufferNano.b(7, this.b);
    }
    if ((this.j & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(8, this.a);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final er c()
  {
    if (this.e != 1) {
      return null;
    }
    return this.k;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof cp))
      {
        paramObject = (cp)paramObject;
        if (((this.j & 0x1) == (((cp)paramObject).j & 0x1)) && (this.h.equals(((cp)paramObject).h)))
        {
          localObject = this.d;
          if (localObject != null) {
            break label286;
          }
          if (((cp)paramObject).d != null) {}
        }
      }
      label273:
      label286:
      while (((bu)localObject).equals(((cp)paramObject).d))
      {
        if (((this.j & 0x2) == (((cp)paramObject).j & 0x2)) && (this.g.equals(((cp)paramObject).g)) && ((this.j & 0x4) == (((cp)paramObject).j & 0x4)) && (this.a.equals(((cp)paramObject).a)) && ((this.j & 0x8) == (((cp)paramObject).j & 0x8)) && (Arrays.equals(this.f, ((cp)paramObject).f)))
        {
          localObject = this.c;
          if (localObject != null) {
            break label273;
          }
          if (((cp)paramObject).c != null) {}
        }
        while (((l)localObject).equals(((cp)paramObject).c))
        {
          localObject = this.k;
          if (localObject == null) {
            if (((cp)paramObject).k != null) {}
          }
          while (((er)localObject).equals(((cp)paramObject).k))
          {
            localObject = this.b;
            if (localObject == null) {
              if (((cp)paramObject).b != null) {}
            }
            while (((f)localObject).equals(((cp)paramObject).b))
            {
              localObject = this.unknownFieldData;
              if ((localObject == null) || (((d)localObject).a()))
              {
                paramObject = ((cp)paramObject).unknownFieldData;
                return (paramObject == null) || (((d)paramObject).a());
              }
              return this.unknownFieldData.equals(((cp)paramObject).unknownFieldData);
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
    int i6 = this.h.hashCode();
    Object localObject1 = this.d;
    if (localObject1 != null) {}
    for (int m = ((bu)localObject1).hashCode();; m = 0)
    {
      int i7 = this.g.hashCode();
      int i8 = this.a.hashCode();
      int i9 = Arrays.hashCode(this.f);
      localObject1 = this.c;
      if (this.e != 0) {
        localObject1 = null;
      }
      if (localObject1 != null) {}
      for (int n = ((l)localObject1).hashCode();; n = 0)
      {
        localObject1 = this.k;
        if (this.e != 1) {
          localObject1 = null;
        }
        if (localObject1 != null) {}
        for (int i1 = ((er)localObject1).hashCode();; i1 = 0)
        {
          localObject1 = this.b;
          if (this.e != 2) {
            localObject1 = localObject2;
          }
          for (;;)
          {
            if (localObject1 != null) {}
            for (int i2 = ((f)localObject1).hashCode();; i2 = 0)
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
              return (i2 + (((i9 + (((m + ((i5 + 527) * 31 + i6) * 31) * 31 + i7) * 31 + i8) * 31) * 31 + n) * 31 + i1) * 31) * 31 + i3;
            }
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/cp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */