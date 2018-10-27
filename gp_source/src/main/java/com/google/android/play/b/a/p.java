package com.google.android.play.b.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.j;

public final class p
  extends b
{
  public String a;
  public int b;
  public boolean c;
  public int[] d;
  private int e;
  private boolean f;
  private boolean g;
  
  public p()
  {
    b();
  }
  
  private final p b(a parama)
  {
    for (;;)
    {
      int i = parama.a();
      int k;
      int j;
      Object localObject;
      int[] arrayOfInt;
      switch (i)
      {
      default: 
        if (super.a(parama, i)) {}
        break;
      case 0: 
        return this;
      case 48: 
        this.c = parama.b();
        this.b |= 0x10;
        break;
      case 42: 
        this.a = parama.c();
        this.b |= 0x8;
        break;
      case 34: 
        k = parama.c(parama.e());
        i = parama.j();
        j = 0;
        for (;;)
        {
          if (parama.i() <= 0)
          {
            parama.e(i);
            localObject = this.d;
            if (localObject != null) {}
            for (i = localObject.length;; i = 0)
            {
              arrayOfInt = new int[j + i];
              j = i;
              if (i != 0)
              {
                System.arraycopy(localObject, 0, arrayOfInt, 0, i);
                j = i;
              }
              for (;;)
              {
                if (j >= arrayOfInt.length)
                {
                  this.d = arrayOfInt;
                  parama.d(k);
                  break;
                }
                arrayOfInt[j] = parama.e();
                j += 1;
              }
            }
          }
          parama.e();
          j += 1;
        }
      case 32: 
        j = j.a(parama, 32);
        localObject = this.d;
        if (localObject != null) {}
        for (i = localObject.length;; i = 0)
        {
          arrayOfInt = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(localObject, 0, arrayOfInt, 0, i);
            j = i;
          }
          while (j < arrayOfInt.length - 1)
          {
            arrayOfInt[j] = parama.e();
            parama.a();
            j += 1;
          }
          arrayOfInt[j] = parama.e();
          this.d = arrayOfInt;
          break;
        }
      case 24: 
        this.f = parama.b();
        this.b |= 0x4;
        break;
      case 16: 
        this.g = parama.b();
        this.b |= 0x2;
        break;
      case 8: 
        this.b |= 0x1;
        j = parama.j();
        do
        {
          try
          {
            k = parama.e();
            if (k >= 0) {
              continue;
            }
            localObject = new StringBuilder(34);
            ((StringBuilder)localObject).append(k);
            ((StringBuilder)localObject).append(" is not a valid enum Id");
            throw new IllegalArgumentException(((StringBuilder)localObject).toString());
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            parama.e(j);
            a(parama, i);
          }
          break;
        } while (k > 2);
        this.e = k;
        this.b |= 0x1;
      }
    }
  }
  
  protected final int a()
  {
    int m = 0;
    int j = super.a();
    int i = j;
    if ((this.b & 0x1) != 0) {
      i = j + CodedOutputByteBufferNano.d(1, this.e);
    }
    j = i;
    if ((this.b & 0x2) != 0) {
      j = i + (CodedOutputByteBufferNano.d(16) + 1);
    }
    i = j;
    if ((this.b & 0x4) != 0) {
      i = j + (CodedOutputByteBufferNano.d(24) + 1);
    }
    int[] arrayOfInt = this.d;
    j = i;
    if (arrayOfInt != null)
    {
      j = i;
      if (arrayOfInt.length > 0)
      {
        int k = 0;
        j = m;
        for (;;)
        {
          arrayOfInt = this.d;
          m = arrayOfInt.length;
          if (j >= m) {
            break;
          }
          k += CodedOutputByteBufferNano.b(arrayOfInt[j]);
          j += 1;
        }
        j = i + k + m;
      }
    }
    i = j;
    if ((this.b & 0x8) != 0) {
      i = j + CodedOutputByteBufferNano.b(5, this.a);
    }
    j = i;
    if ((this.b & 0x10) != 0) {
      j = i + (CodedOutputByteBufferNano.d(48) + 1);
    }
    return j;
  }
  
  public final p a(int paramInt)
  {
    this.e = paramInt;
    this.b |= 0x1;
    return this;
  }
  
  public final p a(boolean paramBoolean)
  {
    this.b |= 0x2;
    this.g = paramBoolean;
    return this;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.b & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.e);
    }
    if ((this.b & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.g);
    }
    if ((this.b & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.f);
    }
    int[] arrayOfInt = this.d;
    if ((arrayOfInt == null) || (arrayOfInt.length <= 0))
    {
      if ((this.b & 0x8) != 0) {
        paramCodedOutputByteBufferNano.a(5, this.a);
      }
      if ((this.b & 0x10) != 0) {
        paramCodedOutputByteBufferNano.a(6, this.c);
      }
      super.a(paramCodedOutputByteBufferNano);
      return;
    }
    int i = 0;
    for (;;)
    {
      arrayOfInt = this.d;
      if (i >= arrayOfInt.length) {
        break;
      }
      paramCodedOutputByteBufferNano.a(4, arrayOfInt[i]);
      i += 1;
    }
  }
  
  public final p b()
  {
    this.b = 0;
    this.e = 0;
    this.g = false;
    this.f = false;
    this.d = j.f;
    this.a = "";
    this.c = false;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public final p b(boolean paramBoolean)
  {
    this.b |= 0x4;
    this.f = paramBoolean;
    return this;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof p))
      {
        paramObject = (p)paramObject;
        int i = this.b;
        int j = ((p)paramObject).b;
        if (((i & 0x1) == (j & 0x1)) && (this.e == ((p)paramObject).e) && ((i & 0x2) == (j & 0x2)) && (this.g == ((p)paramObject).g) && ((i & 0x4) == (j & 0x4)) && (this.f == ((p)paramObject).f) && (f.a(this.d, ((p)paramObject).d)) && ((this.b & 0x8) == (((p)paramObject).b & 0x8)) && (this.a.equals(((p)paramObject).a)) && ((this.b & 0x10) == (((p)paramObject).b & 0x10)) && (this.c == ((p)paramObject).c))
        {
          d locald = this.unknownFieldData;
          if ((locald != null) && (!locald.a())) {
            break label199;
          }
          paramObject = ((p)paramObject).unknownFieldData;
        }
      }
      return (paramObject == null) || (((d)paramObject).a());
      label199:
      return this.unknownFieldData.equals(((p)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int m = 1237;
    int n = getClass().getName().hashCode();
    int i1 = this.e;
    if (!this.g) {}
    for (int j = 1237;; j = 1231)
    {
      if (!this.f) {}
      for (int k = 1237;; k = 1231)
      {
        int i2 = f.a(this.d);
        int i3 = this.a.hashCode();
        if (!this.c) {}
        for (;;)
        {
          d locald = this.unknownFieldData;
          int i;
          if (locald != null) {
            if (!locald.a()) {
              i = this.unknownFieldData.hashCode();
            }
          }
          for (;;)
          {
            return i + ((((k + (j + ((n + 527) * 31 + i1) * 31) * 31) * 31 + i2) * 31 + i3) * 31 + m) * 31;
            i = 0;
            continue;
            i = 0;
          }
          m = 1231;
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/play/b/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */