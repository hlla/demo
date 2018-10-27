package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;
import com.google.protobuf.nano.j;
import java.util.Arrays;

public final class kj
  extends b
{
  private static volatile kj[] k;
  public int a = 0;
  public String b = "";
  public de c = null;
  public boolean d = false;
  public bu e = null;
  public fb f = null;
  public int g = 0;
  public byte[] h = j.b;
  public String i = "";
  public int j = 1;
  private kh l = null;
  private String m = "";
  
  public kj()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final kj b(a parama)
  {
    for (;;)
    {
      int n = parama.a();
      int i1;
      switch (n)
      {
      default: 
        if (super.a(parama, n)) {}
        break;
      case 0: 
        return this;
      case 90: 
        this.i = parama.c();
        this.a |= 0x40;
        break;
      case 80: 
        this.d = parama.b();
        this.a |= 0x20;
        break;
      case 72: 
        this.a |= 0x8;
        i1 = parama.j();
        try
        {
          this.g = bn.a(parama.e());
          this.a |= 0x8;
        }
        catch (IllegalArgumentException localIllegalArgumentException1)
        {
          parama.e(i1);
          a(parama, n);
        }
        break;
      case 66: 
        if (this.c == null) {
          this.c = new de();
        }
        parama.a(this.c);
        break;
      case 58: 
        if (this.f == null) {
          this.f = new fb();
        }
        parama.a(this.f);
        break;
      case 50: 
        this.b = parama.c();
        this.a |= 0x2;
        break;
      case 42: 
        if (this.e == null) {
          this.e = new bu();
        }
        parama.a(this.e);
        break;
      case 34: 
        this.h = parama.d();
        this.a |= 0x4;
        break;
      case 26: 
        if (this.l == null) {
          this.l = new kh();
        }
        parama.a(this.l);
        break;
      case 18: 
        this.m = parama.c();
        this.a |= 0x10;
        break;
      case 8: 
        this.a |= 0x1;
        i1 = parama.j();
        int i2;
        do
        {
          try
          {
            i2 = parama.e();
            if (i2 > 0) {
              continue;
            }
            StringBuilder localStringBuilder = new StringBuilder(34);
            localStringBuilder.append(i2);
            localStringBuilder.append(" is not a valid enum Id");
            throw new IllegalArgumentException(localStringBuilder.toString());
          }
          catch (IllegalArgumentException localIllegalArgumentException2)
          {
            parama.e(i1);
            a(parama, n);
          }
          break;
        } while (i2 > 4);
        this.j = i2;
        this.a |= 0x1;
      }
    }
  }
  
  public static kj[] b()
  {
    if (k == null) {}
    synchronized (f.a)
    {
      if (k == null) {
        k = new kj[0];
      }
      return k;
    }
  }
  
  protected final int a()
  {
    int i1 = super.a();
    int n = i1;
    if ((this.a & 0x1) != 0) {
      n = i1 + CodedOutputByteBufferNano.d(1, this.j);
    }
    i1 = n;
    if ((this.a & 0x10) != 0) {
      i1 = n + CodedOutputByteBufferNano.b(2, this.m);
    }
    Object localObject = this.l;
    n = i1;
    if (localObject != null) {
      n = i1 + CodedOutputByteBufferNano.d(3, (g)localObject);
    }
    i1 = n;
    if ((this.a & 0x4) != 0) {
      i1 = n + CodedOutputByteBufferNano.b(4, this.h);
    }
    localObject = this.e;
    n = i1;
    if (localObject != null) {
      n = i1 + CodedOutputByteBufferNano.d(5, (g)localObject);
    }
    i1 = n;
    if ((this.a & 0x2) != 0) {
      i1 = n + CodedOutputByteBufferNano.b(6, this.b);
    }
    localObject = this.f;
    n = i1;
    if (localObject != null) {
      n = i1 + CodedOutputByteBufferNano.d(7, (g)localObject);
    }
    localObject = this.c;
    i1 = n;
    if (localObject != null) {
      i1 = n + CodedOutputByteBufferNano.d(8, (g)localObject);
    }
    n = i1;
    if ((this.a & 0x8) != 0) {
      n = i1 + CodedOutputByteBufferNano.d(9, this.g);
    }
    i1 = n;
    if ((this.a & 0x20) != 0) {
      i1 = n + (CodedOutputByteBufferNano.d(80) + 1);
    }
    n = i1;
    if ((this.a & 0x40) != 0) {
      n = i1 + CodedOutputByteBufferNano.b(11, this.i);
    }
    return n;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.j);
    }
    if ((this.a & 0x10) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.m);
    }
    Object localObject = this.l;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(3, (g)localObject);
    }
    if ((this.a & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.h);
    }
    localObject = this.e;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(5, (g)localObject);
    }
    if ((this.a & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(6, this.b);
    }
    localObject = this.f;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(7, (g)localObject);
    }
    localObject = this.c;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(8, (g)localObject);
    }
    if ((this.a & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(9, this.g);
    }
    if ((this.a & 0x20) != 0) {
      paramCodedOutputByteBufferNano.a(10, this.d);
    }
    if ((this.a & 0x40) != 0) {
      paramCodedOutputByteBufferNano.a(11, this.i);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      int n;
      int i1;
      Object localObject;
      if ((paramObject instanceof kj))
      {
        paramObject = (kj)paramObject;
        n = this.a;
        i1 = ((kj)paramObject).a;
        if (((n & 0x1) == (i1 & 0x1)) && (this.j == ((kj)paramObject).j) && ((n & 0x2) == (i1 & 0x2)) && (this.b.equals(((kj)paramObject).b)))
        {
          localObject = this.e;
          if (localObject != null) {
            break label378;
          }
          if (((kj)paramObject).e != null) {}
        }
      }
      label336:
      label350:
      label378:
      while (((bu)localObject).equals(((kj)paramObject).e))
      {
        localObject = this.f;
        if (localObject == null) {
          if (((kj)paramObject).f != null) {}
        }
        while (((fb)localObject).equals(((kj)paramObject).f))
        {
          if (((this.a & 0x4) == (((kj)paramObject).a & 0x4)) && (Arrays.equals(this.h, ((kj)paramObject).h)))
          {
            localObject = this.c;
            if (localObject != null) {
              break label350;
            }
            if (((kj)paramObject).c != null) {}
          }
          while (((de)localObject).equals(((kj)paramObject).c))
          {
            n = this.a;
            i1 = ((kj)paramObject).a;
            if (((n & 0x8) == (i1 & 0x8)) && (this.g == ((kj)paramObject).g) && ((n & 0x10) == (i1 & 0x10)) && (this.m.equals(((kj)paramObject).m)))
            {
              localObject = this.l;
              if (localObject != null) {
                break label336;
              }
              if (((kj)paramObject).l != null) {}
            }
            while (((kh)localObject).equals(((kj)paramObject).l))
            {
              n = this.a;
              i1 = ((kj)paramObject).a;
              if (((n & 0x20) == (i1 & 0x20)) && (this.d == ((kj)paramObject).d) && ((n & 0x40) == (i1 & 0x40)) && (this.i.equals(((kj)paramObject).i)))
              {
                localObject = this.unknownFieldData;
                if ((localObject == null) || (((d)localObject).a())) {
                  paramObject = ((kj)paramObject).unknownFieldData;
                }
              }
              else
              {
                return (paramObject == null) || (((d)paramObject).a());
              }
              return this.unknownFieldData.equals(((kj)paramObject).unknownFieldData);
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
    int i6 = 0;
    int i7 = getClass().getName().hashCode();
    int i8 = this.j;
    int i9 = this.b.hashCode();
    Object localObject = this.e;
    if (localObject != null) {}
    for (int n = ((bu)localObject).hashCode();; n = 0)
    {
      localObject = this.f;
      if (localObject != null) {}
      for (int i1 = ((fb)localObject).hashCode();; i1 = 0)
      {
        int i10 = Arrays.hashCode(this.h);
        localObject = this.c;
        if (localObject != null) {}
        for (int i2 = ((de)localObject).hashCode();; i2 = 0)
        {
          int i11 = this.g;
          int i12 = this.m.hashCode();
          localObject = this.l;
          if (localObject != null) {}
          for (int i3 = ((kh)localObject).hashCode();; i3 = 0)
          {
            if (!this.d) {}
            for (int i4 = 1237;; i4 = 1231)
            {
              int i13 = this.i.hashCode();
              localObject = this.unknownFieldData;
              int i5 = i6;
              if (localObject != null)
              {
                i5 = i6;
                if (!((d)localObject).a()) {
                  i5 = this.unknownFieldData.hashCode();
                }
              }
              return ((i4 + (i3 + (((i2 + ((i1 + (n + (((i7 + 527) * 31 + i8) * 31 + i9) * 31) * 31) * 31 + i10) * 31) * 31 + i11) * 31 + i12) * 31) * 31) * 31 + i13) * 31 + i5;
            }
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/kj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */