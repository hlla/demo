package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;
import com.google.protobuf.nano.j;

public final class am
  extends b
{
  private static volatile am[] j;
  public String a = "";
  public int[] b = j.f;
  public int c = 0;
  public String d = "";
  public String e = "";
  public bu f = null;
  public bu[] g = bu.b();
  public String h = "";
  public String i = "";
  
  public am()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final am b(a parama)
  {
    do
    {
      n = parama.a();
      switch (n)
      {
      }
    } while (super.a(parama, n));
    return this;
    int n = parama.c(parama.e());
    int k = parama.j();
    int m = 0;
    label175:
    label245:
    int i2;
    for (;;)
    {
      if (parama.i() > 0) {}
      Object localObject2;
      Object localObject1;
      try
      {
        ao.a(parama.e());
        m += 1;
      }
      catch (IllegalArgumentException localIllegalArgumentException1) {}
      if (m != 0)
      {
        parama.e(k);
        localObject2 = this.b;
        if (localObject2 == null) {
          break label245;
        }
        k = localObject2.length;
        localObject1 = new int[m + k];
        m = k;
        if (k != 0)
        {
          System.arraycopy(localObject2, 0, localObject1, 0, k);
          m = k;
        }
      }
      for (;;)
      {
        if (parama.i() > 0) {
          k = parama.j();
        }
        try
        {
          localObject1[m] = ao.a(parama.e());
          m += 1;
        }
        catch (IllegalArgumentException localIllegalArgumentException2)
        {
          int i1;
          parama.e(k);
          a(parama, 72);
        }
        this.b = ((int[])localObject1);
        parama.d(n);
        break;
        k = 0;
        break label175;
        i1 = j.a(parama, 72);
        localObject1 = new int[i1];
        m = 0;
        k = 0;
        if (m >= i1)
        {
          if (k == 0) {
            break;
          }
          localObject2 = this.b;
          if (localObject2 != null) {}
          for (m = localObject2.length;; m = 0)
          {
            if (m != 0) {}
            while (k != localObject1.length)
            {
              int[] arrayOfInt = new int[m + k];
              if (m != 0) {
                System.arraycopy(localObject2, 0, arrayOfInt, 0, m);
              }
              System.arraycopy(localObject1, 0, arrayOfInt, m, k);
              this.b = arrayOfInt;
              break;
            }
            this.b = ((int[])localObject1);
            break;
          }
        }
        if (m == 0) {}
        for (;;)
        {
          i2 = parama.j();
          try
          {
            localObject1[k] = ao.a(parama.e());
            k += 1;
          }
          catch (IllegalArgumentException localIllegalArgumentException3)
          {
            for (;;)
            {
              parama.e(i2);
              a(parama, n);
            }
          }
          m += 1;
          break;
          parama.a();
        }
        this.a = parama.c();
        this.c |= 0x10;
        break;
        if (this.f == null) {
          this.f = new bu();
        }
        parama.a(this.f);
        break;
        this.h = parama.c();
        this.c |= 0x8;
        break;
        this.e = parama.c();
        this.c |= 0x2;
        break;
        this.d = parama.c();
        this.c |= 0x4;
        break;
        m = j.a(parama, 18);
        localObject1 = this.g;
        if (localObject1 != null) {}
        for (k = localObject1.length;; k = 0)
        {
          localObject2 = new bu[m + k];
          m = k;
          if (k != 0)
          {
            System.arraycopy(localObject1, 0, localObject2, 0, k);
            m = k;
          }
          while (m < localObject2.length - 1)
          {
            localObject2[m] = new bu();
            parama.a(localObject2[m]);
            parama.a();
            m += 1;
          }
          localObject2[m] = new bu();
          parama.a(localObject2[m]);
          this.g = ((bu[])localObject2);
          break;
        }
        this.i = parama.c();
        this.c |= 0x1;
        break;
      }
    }
  }
  
  public static am[] b()
  {
    if (j == null) {}
    synchronized (f.a)
    {
      if (j == null) {
        j = new am[0];
      }
      return j;
    }
  }
  
  protected final int a()
  {
    int i1 = 0;
    int m = super.a();
    int k = m;
    if ((this.c & 0x1) != 0) {
      k = m + CodedOutputByteBufferNano.b(1, this.i);
    }
    Object localObject = this.g;
    m = k;
    int n;
    if (localObject != null)
    {
      m = k;
      if (localObject.length > 0)
      {
        m = 0;
        for (;;)
        {
          localObject = this.g;
          if (m >= localObject.length) {
            break;
          }
          localObject = localObject[m];
          n = k;
          if (localObject != null) {
            n = k + CodedOutputByteBufferNano.d(2, (g)localObject);
          }
          m += 1;
          k = n;
        }
        m = k;
      }
    }
    k = m;
    if ((this.c & 0x4) != 0) {
      k = m + CodedOutputByteBufferNano.b(3, this.d);
    }
    m = k;
    if ((this.c & 0x2) != 0) {
      m = k + CodedOutputByteBufferNano.b(4, this.e);
    }
    k = m;
    if ((this.c & 0x8) != 0) {
      k = m + CodedOutputByteBufferNano.b(5, this.h);
    }
    localObject = this.f;
    m = k;
    if (localObject != null) {
      m = k + CodedOutputByteBufferNano.d(6, (g)localObject);
    }
    if ((this.c & 0x10) != 0) {}
    for (k = CodedOutputByteBufferNano.b(8, this.a) + m;; k = m)
    {
      localObject = this.b;
      if (localObject != null)
      {
        if (localObject.length > 0)
        {
          n = 0;
          m = i1;
          for (;;)
          {
            localObject = this.b;
            i1 = localObject.length;
            if (m >= i1) {
              break;
            }
            n += CodedOutputByteBufferNano.b(localObject[m]);
            m += 1;
          }
          return n + k + i1;
        }
        return k;
      }
      return k;
    }
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int m = 0;
    if ((this.c & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.i);
    }
    Object localObject = this.g;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int k;
    do
    {
      if ((this.c & 0x4) != 0) {
        paramCodedOutputByteBufferNano.a(3, this.d);
      }
      if ((this.c & 0x2) != 0) {
        paramCodedOutputByteBufferNano.a(4, this.e);
      }
      if ((this.c & 0x8) != 0) {
        paramCodedOutputByteBufferNano.a(5, this.h);
      }
      localObject = this.f;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.b(6, (g)localObject);
      }
      if ((this.c & 0x10) != 0) {
        paramCodedOutputByteBufferNano.a(8, this.a);
      }
      localObject = this.b;
      if ((localObject != null) && (localObject.length > 0))
      {
        k = m;
        for (;;)
        {
          localObject = this.b;
          if (k >= localObject.length) {
            break;
          }
          paramCodedOutputByteBufferNano.a(9, localObject[k]);
          k += 1;
        }
      }
      super.a(paramCodedOutputByteBufferNano);
      return;
      k = 0;
      localObject = this.g;
    } while (k >= localObject.length);
    localObject = localObject[k];
    if (localObject == null) {}
    for (;;)
    {
      k += 1;
      break;
      paramCodedOutputByteBufferNano.b(2, (g)localObject);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof am))
      {
        paramObject = (am)paramObject;
        if (((this.c & 0x1) == (((am)paramObject).c & 0x1)) && (this.i.equals(((am)paramObject).i)) && ((this.c & 0x2) == (((am)paramObject).c & 0x2)) && (this.e.equals(((am)paramObject).e)) && (f.a(this.g, ((am)paramObject).g)))
        {
          localObject = this.f;
          if (localObject != null) {
            break label258;
          }
          if (((am)paramObject).f != null) {}
        }
      }
      label258:
      while (((bu)localObject).equals(((am)paramObject).f))
      {
        if (((this.c & 0x4) == (((am)paramObject).c & 0x4)) && (this.d.equals(((am)paramObject).d)) && ((this.c & 0x8) == (((am)paramObject).c & 0x8)) && (this.h.equals(((am)paramObject).h)) && ((this.c & 0x10) == (((am)paramObject).c & 0x10)) && (this.a.equals(((am)paramObject).a)) && (f.a(this.b, ((am)paramObject).b)))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((am)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((am)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int n = 0;
    int i1 = getClass().getName().hashCode();
    int i2 = this.i.hashCode();
    int i3 = this.e.hashCode();
    int i4 = f.a(this.g);
    Object localObject = this.f;
    if (localObject != null) {}
    for (int k = ((bu)localObject).hashCode();; k = 0)
    {
      int i5 = this.d.hashCode();
      int i6 = this.h.hashCode();
      int i7 = this.a.hashCode();
      int i8 = f.a(this.b);
      localObject = this.unknownFieldData;
      int m = n;
      if (localObject != null)
      {
        m = n;
        if (!((d)localObject).a()) {
          m = this.unknownFieldData.hashCode();
        }
      }
      return (((((k + ((((i1 + 527) * 31 + i2) * 31 + i3) * 31 + i4) * 31) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + m;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */