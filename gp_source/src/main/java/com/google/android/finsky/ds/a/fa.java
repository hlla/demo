package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;
import com.google.protobuf.nano.j;

public final class fa
  extends b
{
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public cq[] d = cq.b();
  public int e = 0;
  public long f = 0L;
  public int g = 0;
  public String[] h = j.h;
  public String[] i = j.h;
  public int j = 0;
  public int k = 0;
  public long l = 0L;
  
  public fa()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static fa a(byte[] paramArrayOfByte)
  {
    return (fa)g.a(new fa(), paramArrayOfByte);
  }
  
  private final fa b(a parama)
  {
    for (;;)
    {
      int m = parama.a();
      int n;
      Object localObject2;
      Object localObject1;
      switch (m)
      {
      default: 
        if (super.a(parama, m)) {}
        break;
      case 0: 
        return this;
      case 90: 
        n = j.a(parama, 90);
        String[] arrayOfString = this.i;
        if (arrayOfString != null) {}
        for (m = arrayOfString.length;; m = 0)
        {
          localObject2 = new String[n + m];
          n = m;
          if (m != 0)
          {
            System.arraycopy(arrayOfString, 0, localObject2, 0, m);
            n = m;
          }
          while (n < localObject2.length - 1)
          {
            localObject2[n] = parama.c();
            parama.a();
            n += 1;
          }
          localObject2[n] = parama.c();
          this.i = ((String[])localObject2);
          break;
        }
      case 80: 
        this.f = parama.f();
        this.c |= 0x10;
        break;
      case 72: 
        this.c |= 0x80;
        n = parama.j();
        try
        {
          this.b = i.a(parama.e());
          this.c |= 0x80;
        }
        catch (IllegalArgumentException localIllegalArgumentException1)
        {
          parama.e(n);
          a(parama, m);
        }
        break;
      case 64: 
        this.j = parama.e();
        this.c |= 0x40;
        break;
      case 56: 
        this.c |= 0x20;
        n = parama.j();
        int i1;
        do
        {
          try
          {
            i1 = parama.e();
            if (i1 >= 0) {
              continue;
            }
            StringBuilder localStringBuilder = new StringBuilder(47);
            localStringBuilder.append(i1);
            localStringBuilder.append(" is not a valid enum AndroidCategory");
            throw new IllegalArgumentException(localStringBuilder.toString());
          }
          catch (IllegalArgumentException localIllegalArgumentException2)
          {
            parama.e(n);
            a(parama, m);
          }
          break;
        } while (i1 > 8);
        this.a = i1;
        this.c |= 0x20;
        break;
      case 50: 
        n = j.a(parama, 50);
        localObject1 = this.h;
        if (localObject1 != null) {}
        for (m = localObject1.length;; m = 0)
        {
          localObject2 = new String[n + m];
          n = m;
          if (m != 0)
          {
            System.arraycopy(localObject1, 0, localObject2, 0, m);
            n = m;
          }
          while (n < localObject2.length - 1)
          {
            localObject2[n] = parama.c();
            parama.a();
            n += 1;
          }
          localObject2[n] = parama.c();
          this.h = ((String[])localObject2);
          break;
        }
      case 40: 
        this.e = parama.e();
        this.c |= 0x8;
        break;
      case 32: 
        this.k = parama.e();
        this.c |= 0x4;
        break;
      case 26: 
        n = j.a(parama, 26);
        localObject1 = this.d;
        if (localObject1 != null) {}
        for (m = localObject1.length;; m = 0)
        {
          localObject2 = new cq[n + m];
          n = m;
          if (m != 0)
          {
            System.arraycopy(localObject1, 0, localObject2, 0, m);
            n = m;
          }
          while (n < localObject2.length - 1)
          {
            localObject2[n] = new cq();
            parama.a(localObject2[n]);
            parama.a();
            n += 1;
          }
          localObject2[n] = new cq();
          parama.a(localObject2[n]);
          this.d = ((cq[])localObject2);
          break;
        }
      case 16: 
        this.l = parama.f();
        this.c |= 0x2;
        break;
      case 8: 
        this.c |= 0x1;
        n = parama.j();
        try
        {
          this.g = kz.d(parama.e());
          this.c |= 0x1;
        }
        catch (IllegalArgumentException localIllegalArgumentException3)
        {
          parama.e(n);
          a(parama, m);
        }
      }
    }
  }
  
  protected final int a()
  {
    int i5 = 0;
    int m = super.a();
    int n = m;
    if ((this.c & 0x1) != 0) {
      n = m + CodedOutputByteBufferNano.d(1, this.g);
    }
    m = n;
    if ((this.c & 0x2) != 0) {
      m = n + CodedOutputByteBufferNano.f(2, this.l);
    }
    Object localObject = this.d;
    n = m;
    int i1;
    if (localObject != null)
    {
      n = m;
      if (localObject.length > 0)
      {
        n = 0;
        for (;;)
        {
          localObject = this.d;
          if (n >= localObject.length) {
            break;
          }
          localObject = localObject[n];
          i1 = m;
          if (localObject != null) {
            i1 = m + CodedOutputByteBufferNano.d(3, (g)localObject);
          }
          n += 1;
          m = i1;
        }
        n = m;
      }
    }
    m = n;
    if ((this.c & 0x4) != 0) {
      m = n + CodedOutputByteBufferNano.d(4, this.k);
    }
    if ((this.c & 0x8) != 0) {
      m += CodedOutputByteBufferNano.d(5, this.e);
    }
    for (;;)
    {
      localObject = this.h;
      int i2;
      if (localObject != null) {
        if (localObject.length > 0)
        {
          n = 0;
          i1 = 0;
          i2 = 0;
          localObject = this.h;
          if (n >= localObject.length) {
            m = m + i1 + i2;
          }
        }
      }
      for (;;)
      {
        n = m;
        if ((this.c & 0x20) != 0) {
          n = m + CodedOutputByteBufferNano.d(7, this.a);
        }
        m = n;
        if ((this.c & 0x40) != 0) {
          m = n + CodedOutputByteBufferNano.d(8, this.j);
        }
        n = m;
        if ((this.c & 0x80) != 0) {
          n = m + CodedOutputByteBufferNano.d(9, this.b);
        }
        if ((this.c & 0x10) != 0) {}
        for (m = n + CodedOutputByteBufferNano.f(10, this.f);; m = n)
        {
          localObject = this.i;
          n = m;
          if (localObject != null)
          {
            n = m;
            if (localObject.length > 0)
            {
              n = 0;
              i1 = 0;
            }
          }
          for (i2 = i5;; i2 = i3)
          {
            localObject = this.i;
            if (n >= localObject.length)
            {
              n = i1 + m + i2;
              return n;
            }
            localObject = localObject[n];
            i4 = i1;
            i3 = i2;
            if (localObject != null)
            {
              i3 = i2 + 1;
              i4 = i1 + CodedOutputByteBufferNano.a((String)localObject);
            }
            n += 1;
            i1 = i4;
          }
        }
        localObject = localObject[n];
        int i4 = i1;
        int i3 = i2;
        if (localObject != null)
        {
          i3 = i2 + 1;
          i4 = i1 + CodedOutputByteBufferNano.a((String)localObject);
        }
        n += 1;
        i1 = i4;
        i2 = i3;
        break;
      }
    }
  }
  
  public final fa a(int paramInt)
  {
    this.c |= 0x8;
    this.e = paramInt;
    return this;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int n = 0;
    if ((this.c & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.g);
    }
    if ((this.c & 0x2) != 0) {
      paramCodedOutputByteBufferNano.b(2, this.l);
    }
    Object localObject = this.d;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int m;
    do
    {
      if ((this.c & 0x4) != 0) {
        paramCodedOutputByteBufferNano.a(4, this.k);
      }
      if ((this.c & 0x8) != 0) {
        paramCodedOutputByteBufferNano.a(5, this.e);
      }
      localObject = this.h;
      if ((localObject == null) || (localObject.length <= 0)) {}
      do
      {
        if ((this.c & 0x20) != 0) {
          paramCodedOutputByteBufferNano.a(7, this.a);
        }
        if ((this.c & 0x40) != 0) {
          paramCodedOutputByteBufferNano.a(8, this.j);
        }
        if ((this.c & 0x80) != 0) {
          paramCodedOutputByteBufferNano.a(9, this.b);
        }
        if ((this.c & 0x10) != 0) {
          paramCodedOutputByteBufferNano.b(10, this.f);
        }
        localObject = this.i;
        if ((localObject != null) && (localObject.length > 0))
        {
          m = n;
          localObject = this.i;
          if (m < localObject.length)
          {
            localObject = localObject[m];
            if (localObject == null) {}
            for (;;)
            {
              m += 1;
              break;
              paramCodedOutputByteBufferNano.a(11, (String)localObject);
            }
          }
        }
        super.a(paramCodedOutputByteBufferNano);
        return;
        m = 0;
        localObject = this.h;
      } while (m >= localObject.length);
      localObject = localObject[m];
      if (localObject == null) {}
      for (;;)
      {
        m += 1;
        break;
        paramCodedOutputByteBufferNano.a(6, (String)localObject);
      }
      m = 0;
      localObject = this.d;
    } while (m >= localObject.length);
    localObject = localObject[m];
    if (localObject == null) {}
    for (;;)
    {
      m += 1;
      break;
      paramCodedOutputByteBufferNano.b(3, (g)localObject);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof fa))
      {
        paramObject = (fa)paramObject;
        int m = this.c;
        int n = ((fa)paramObject).c;
        if (((m & 0x1) == (n & 0x1)) && (this.g == ((fa)paramObject).g) && ((m & 0x2) == (n & 0x2)) && (this.l == ((fa)paramObject).l) && (f.a(this.d, ((fa)paramObject).d)))
        {
          m = this.c;
          n = ((fa)paramObject).c;
          if (((m & 0x4) == (n & 0x4)) && (this.k == ((fa)paramObject).k) && ((m & 0x8) == (n & 0x8)) && (this.e == ((fa)paramObject).e) && ((m & 0x10) == (n & 0x10)) && (this.f == ((fa)paramObject).f) && (f.a(this.h, ((fa)paramObject).h)))
          {
            m = this.c;
            n = ((fa)paramObject).c;
            if (((m & 0x20) == (n & 0x20)) && (this.a == ((fa)paramObject).a) && ((m & 0x40) == (n & 0x40)) && (this.j == ((fa)paramObject).j) && ((m & 0x80) == (n & 0x80)) && (this.b == ((fa)paramObject).b) && (f.a(this.i, ((fa)paramObject).i)))
            {
              d locald = this.unknownFieldData;
              if ((locald != null) && (!locald.a())) {
                break label302;
              }
              paramObject = ((fa)paramObject).unknownFieldData;
            }
          }
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label302:
      return this.unknownFieldData.equals(((fa)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int n = 0;
    int i1 = getClass().getName().hashCode();
    int i2 = this.g;
    long l1 = this.l;
    int i3 = f.a(this.d);
    int i4 = this.k;
    int i5 = this.e;
    long l2 = this.f;
    int i6 = (int)(l1 ^ l1 >>> 32);
    int i7 = (int)(l2 >>> 32 ^ l2);
    int i8 = f.a(this.h);
    int i9 = this.a;
    int i10 = this.j;
    int i11 = this.b;
    int i12 = f.a(this.i);
    d locald = this.unknownFieldData;
    int m = n;
    if (locald != null)
    {
      m = n;
      if (!locald.a()) {
        m = this.unknownFieldData.hashCode();
      }
    }
    return m + ((((((((((((i1 + 527) * 31 + i2) * 31 + i6) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/fa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */