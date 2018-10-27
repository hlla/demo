package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;
import com.google.protobuf.nano.j;

public final class gl
  extends b
{
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public String[] d = j.h;
  public String e = "";
  public String f = "";
  public String g = "";
  public int[] h = j.f;
  private ad[] i = ad.b();
  
  public gl()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final gl b(a parama)
  {
    do
    {
      m = parama.a();
      switch (m)
      {
      }
    } while (super.a(parama, m));
    return this;
    int m = parama.c(parama.e());
    int j = parama.j();
    int k = 0;
    label175:
    label245:
    int i1;
    for (;;)
    {
      if (parama.i() > 0) {}
      Object localObject2;
      Object localObject1;
      try
      {
        jd.a(parama.e());
        k += 1;
      }
      catch (IllegalArgumentException localIllegalArgumentException2) {}
      if (k != 0)
      {
        parama.e(j);
        localObject2 = this.h;
        if (localObject2 == null) {
          break label245;
        }
        j = localObject2.length;
        localObject1 = new int[k + j];
        k = j;
        if (j != 0)
        {
          System.arraycopy(localObject2, 0, localObject1, 0, j);
          k = j;
        }
      }
      for (;;)
      {
        if (parama.i() > 0) {
          j = parama.j();
        }
        try
        {
          localObject1[k] = jd.a(parama.e());
          k += 1;
        }
        catch (IllegalArgumentException localIllegalArgumentException3)
        {
          int n;
          parama.e(j);
          a(parama, 64);
        }
        this.h = ((int[])localObject1);
        parama.d(m);
        break;
        j = 0;
        break label175;
        n = j.a(parama, 64);
        localObject1 = new int[n];
        k = 0;
        j = 0;
        if (k >= n)
        {
          if (j == 0) {
            break;
          }
          localObject2 = this.h;
          if (localObject2 != null) {}
          for (k = localObject2.length;; k = 0)
          {
            if (k != 0) {}
            while (j != localObject1.length)
            {
              int[] arrayOfInt = new int[k + j];
              if (k != 0) {
                System.arraycopy(localObject2, 0, arrayOfInt, 0, k);
              }
              System.arraycopy(localObject1, 0, arrayOfInt, k, j);
              this.h = arrayOfInt;
              break;
            }
            this.h = ((int[])localObject1);
            break;
          }
        }
        if (k == 0) {}
        for (;;)
        {
          i1 = parama.j();
          try
          {
            localObject1[j] = jd.a(parama.e());
            j += 1;
          }
          catch (IllegalArgumentException localIllegalArgumentException4)
          {
            for (;;)
            {
              parama.e(i1);
              a(parama, m);
            }
          }
          k += 1;
          break;
          parama.a();
        }
        this.g = parama.c();
        this.a |= 0x8;
        break;
        k = j.a(parama, 50);
        localObject1 = this.d;
        if (localObject1 != null) {}
        for (j = localObject1.length;; j = 0)
        {
          localObject2 = new String[k + j];
          k = j;
          if (j != 0)
          {
            System.arraycopy(localObject1, 0, localObject2, 0, j);
            k = j;
          }
          while (k < localObject2.length - 1)
          {
            localObject2[k] = parama.c();
            parama.a();
            k += 1;
          }
          localObject2[k] = parama.c();
          this.d = ((String[])localObject2);
          break;
        }
        k = j.a(parama, 42);
        localObject1 = this.i;
        if (localObject1 != null) {}
        for (j = localObject1.length;; j = 0)
        {
          localObject2 = new ad[k + j];
          k = j;
          if (j != 0)
          {
            System.arraycopy(localObject1, 0, localObject2, 0, j);
            k = j;
          }
          while (k < localObject2.length - 1)
          {
            localObject2[k] = new ad();
            parama.a(localObject2[k]);
            parama.a();
            k += 1;
          }
          localObject2[k] = new ad();
          parama.a(localObject2[k]);
          this.i = ((ad[])localObject2);
          break;
        }
        this.e = parama.c();
        this.a |= 0x10;
        break;
        this.f = parama.c();
        this.a |= 0x4;
        break;
        this.c = parama.e();
        this.a |= 0x2;
        break;
        this.a |= 0x1;
        j = parama.j();
        do
        {
          try
          {
            k = parama.e();
            if (k >= 0) {
              continue;
            }
            localObject1 = new StringBuilder(34);
            ((StringBuilder)localObject1).append(k);
            ((StringBuilder)localObject1).append(" is not a valid enum Id");
            throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
          }
          catch (IllegalArgumentException localIllegalArgumentException1)
          {
            parama.e(j);
            a(parama, m);
          }
          break;
        } while (k > 2);
        this.b = k;
        this.a |= 0x1;
        break;
      }
    }
  }
  
  protected final int a()
  {
    int i3 = 0;
    int k = super.a();
    int j = k;
    if ((this.a & 0x1) != 0) {
      j = k + CodedOutputByteBufferNano.d(1, this.b);
    }
    k = j;
    if ((this.a & 0x2) != 0) {
      k = j + CodedOutputByteBufferNano.d(2, this.c);
    }
    int m = k;
    if ((this.a & 0x4) != 0) {
      m = k + CodedOutputByteBufferNano.b(3, this.f);
    }
    j = m;
    if ((this.a & 0x10) != 0) {
      j = m + CodedOutputByteBufferNano.b(4, this.e);
    }
    Object localObject = this.i;
    if (localObject != null) {
      if (localObject.length > 0)
      {
        k = 0;
        for (;;)
        {
          localObject = this.i;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          m = j;
          if (localObject != null) {
            m = j + CodedOutputByteBufferNano.d(5, (g)localObject);
          }
          k += 1;
          j = m;
        }
      }
    }
    for (;;)
    {
      localObject = this.d;
      int n;
      if (localObject != null) {
        if (localObject.length > 0)
        {
          k = 0;
          m = 0;
          n = 0;
          localObject = this.d;
          if (k >= localObject.length) {
            j = j + m + n;
          }
        }
      }
      for (;;)
      {
        if ((this.a & 0x8) != 0) {
          j += CodedOutputByteBufferNano.b(7, this.g);
        }
        for (;;)
        {
          localObject = this.h;
          k = j;
          if (localObject != null)
          {
            k = j;
            if (localObject.length > 0)
            {
              m = 0;
              k = i3;
              for (;;)
              {
                localObject = this.h;
                n = localObject.length;
                if (k >= n) {
                  break;
                }
                m += CodedOutputByteBufferNano.b(localObject[k]);
                k += 1;
              }
              k = m + j + n;
            }
          }
          return k;
        }
        localObject = localObject[k];
        int i2 = m;
        int i1 = n;
        if (localObject != null)
        {
          i1 = n + 1;
          i2 = m + CodedOutputByteBufferNano.a((String)localObject);
        }
        k += 1;
        m = i2;
        n = i1;
        break;
      }
    }
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int k = 0;
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.b);
    }
    if ((this.a & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.c);
    }
    if ((this.a & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.f);
    }
    if ((this.a & 0x10) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.e);
    }
    Object localObject = this.i;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int j;
    do
    {
      localObject = this.d;
      if ((localObject == null) || (localObject.length <= 0)) {}
      do
      {
        if ((this.a & 0x8) != 0) {
          paramCodedOutputByteBufferNano.a(7, this.g);
        }
        localObject = this.h;
        if ((localObject != null) && (localObject.length > 0))
        {
          j = k;
          for (;;)
          {
            localObject = this.h;
            if (j >= localObject.length) {
              break;
            }
            paramCodedOutputByteBufferNano.a(8, localObject[j]);
            j += 1;
          }
        }
        super.a(paramCodedOutputByteBufferNano);
        return;
        j = 0;
        localObject = this.d;
      } while (j >= localObject.length);
      localObject = localObject[j];
      if (localObject == null) {}
      for (;;)
      {
        j += 1;
        break;
        paramCodedOutputByteBufferNano.a(6, (String)localObject);
      }
      j = 0;
      localObject = this.i;
    } while (j >= localObject.length);
    localObject = localObject[j];
    if (localObject == null) {}
    for (;;)
    {
      j += 1;
      break;
      paramCodedOutputByteBufferNano.b(5, (g)localObject);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof gl))
      {
        paramObject = (gl)paramObject;
        if (((this.a & 0x1) == (((gl)paramObject).a & 0x1)) && (this.b == ((gl)paramObject).b) && (f.a(this.h, ((gl)paramObject).h)))
        {
          int j = this.a;
          int k = ((gl)paramObject).a;
          if (((j & 0x2) == (k & 0x2)) && (this.c == ((gl)paramObject).c) && ((j & 0x4) == (k & 0x4)) && (this.f.equals(((gl)paramObject).f)) && ((this.a & 0x8) == (((gl)paramObject).a & 0x8)) && (this.g.equals(((gl)paramObject).g)) && ((this.a & 0x10) == (((gl)paramObject).a & 0x10)) && (this.e.equals(((gl)paramObject).e)) && (f.a(this.i, ((gl)paramObject).i)) && (f.a(this.d, ((gl)paramObject).d)))
          {
            d locald = this.unknownFieldData;
            if ((locald != null) && (!locald.a())) {
              break label239;
            }
            paramObject = ((gl)paramObject).unknownFieldData;
          }
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label239:
      return this.unknownFieldData.equals(((gl)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int n = this.b;
    int i1 = f.a(this.h);
    int i2 = this.c;
    int i3 = this.f.hashCode();
    int i4 = this.g.hashCode();
    int i5 = this.e.hashCode();
    int i6 = f.a(this.i);
    int i7 = f.a(this.d);
    d locald = this.unknownFieldData;
    int j = k;
    if (locald != null)
    {
      j = k;
      if (!locald.a()) {
        j = this.unknownFieldData.hashCode();
      }
    }
    return j + (((((((((m + 527) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/gl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */