package com.google.android.finsky.ds.a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.bb;
import com.google.protobuf.bh;
import com.google.protobuf.cl;
import com.google.protobuf.cw;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;
import com.google.wireless.android.finsky.d.aa;
import com.google.wireless.android.finsky.d.ah;
import com.google.wireless.android.finsky.d.c;
import java.nio.ByteBuffer;

public final class bu
  extends b
{
  private static volatile bu[] j;
  public String a = "";
  public String b = "";
  public int c = 0;
  public bv d = null;
  public String e = "";
  public int f = 0;
  public String g = "";
  public boolean h = false;
  public String i = "";
  private String k = "";
  private c l = null;
  private boolean m = false;
  private aa n = null;
  private int o = 0;
  private int p = 0;
  private ah q = null;
  private int r = 0;
  private String s = "";
  private boolean t = false;
  
  public bu()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final bu b(a parama)
  {
    int i1;
    for (;;)
    {
      i1 = parama.a();
      switch (i1)
      {
      default: 
        if (super.a(parama, i1)) {}
        break;
      case 0: 
        return this;
      case 194: 
        this.a = parama.c();
        this.c |= 0x1000;
        break;
      case 186: 
        this.i = parama.c();
        this.c |= 0x400;
        break;
      case 176: 
        this.t = parama.b();
        this.c |= 0x20;
        break;
      case 168: 
        this.c |= 0x800;
        i2 = parama.j();
        try
        {
          this.o = bo.a(parama.e());
          this.c |= 0x800;
        }
        catch (IllegalArgumentException localIllegalArgumentException1)
        {
          parama.e(i2);
          a(parama, i1);
        }
        break;
      case 162: 
        this.q = ((ah)parama.a((cw)ah.a.a(bh.d, null)));
        break;
      case 154: 
        this.b = parama.c();
        this.c |= 0x200;
        break;
      case 138: 
        this.l = ((c)parama.a((cw)c.a.a(bh.d, null)));
        break;
      case 128: 
        this.m = parama.b();
        this.c |= 0x100;
        break;
      case 122: 
        this.e = parama.c();
        this.c |= 0x80;
        break;
      case 112: 
        this.p = parama.e();
        this.c |= 0x40;
        break;
      case 83: 
        this.n = ((aa)parama.b((cw)aa.a.a(bh.d, null)));
        break;
      case 72: 
        this.h = parama.b();
        this.c |= 0x10;
        break;
      case 64: 
        this.r = parama.e();
        this.c |= 0x2;
        break;
      case 58: 
        this.s = parama.c();
        this.c |= 0x4;
        break;
      case 50: 
        this.k = parama.c();
        this.c |= 0x8;
        break;
      case 42: 
        this.g = parama.c();
        break;
      case 19: 
        if (this.d == null) {
          this.d = new bv();
        }
        parama.a(this.d, 2);
      }
    }
    this.c |= 0x1;
    int i2 = parama.j();
    int i3;
    for (;;)
    {
      try
      {
        i3 = parama.e();
        if (i3 >= 0) {
          break label718;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        label634:
        StringBuilder localStringBuilder;
        parama.e(i2);
        a(parama, i1);
      }
      localStringBuilder = new StringBuilder(41);
      localStringBuilder.append(i3);
      localStringBuilder.append(" is not a valid enum ImageType");
      throw new IllegalArgumentException(localStringBuilder.toString());
      break;
      if (i3 <= 22)
      {
        label718:
        while (i3 <= 9)
        {
          this.f = i3;
          this.c |= 0x1;
          break;
        }
        if (i3 >= 13) {
          break label634;
        }
      }
    }
  }
  
  public static bu[] b()
  {
    if (j == null) {}
    synchronized (f.a)
    {
      if (j == null) {
        j = new bu[0];
      }
      return j;
    }
  }
  
  protected final int a()
  {
    int i2 = super.a();
    int i1 = i2;
    if ((this.c & 0x1) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.d(1, this.f);
    }
    Object localObject = this.d;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.c(2, (g)localObject);
    }
    i2 += CodedOutputByteBufferNano.b(5, this.g);
    i1 = i2;
    if ((this.c & 0x8) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(6, this.k);
    }
    i2 = i1;
    if ((this.c & 0x4) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(7, this.s);
    }
    i1 = i2;
    if ((this.c & 0x2) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.d(8, this.r);
    }
    i2 = i1;
    if ((this.c & 0x10) != 0) {
      i2 = i1 + (CodedOutputByteBufferNano.d(72) + 1);
    }
    localObject = this.n;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputStream.f(10, (cl)localObject);
    }
    i2 = i1;
    if ((this.c & 0x40) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.d(14, this.p);
    }
    i1 = i2;
    if ((this.c & 0x80) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(15, this.e);
    }
    i2 = i1;
    if ((this.c & 0x100) != 0) {
      i2 = i1 + (CodedOutputByteBufferNano.d(128) + 1);
    }
    localObject = this.l;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputStream.c(17, (cl)localObject);
    }
    i2 = i1;
    if ((this.c & 0x200) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(19, this.b);
    }
    localObject = this.q;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputStream.c(20, (cl)localObject);
    }
    i2 = i1;
    if ((this.c & 0x800) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.d(21, this.o);
    }
    i1 = i2;
    if ((this.c & 0x20) != 0) {
      i1 = i2 + (CodedOutputByteBufferNano.d(176) + 1);
    }
    i2 = i1;
    if ((this.c & 0x400) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(23, this.i);
    }
    i1 = i2;
    if ((this.c & 0x1000) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(24, this.a);
    }
    return i1;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.c & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.f);
    }
    Object localObject = this.d;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.a(2, (g)localObject);
    }
    paramCodedOutputByteBufferNano.a(5, this.g);
    if ((this.c & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(6, this.k);
    }
    if ((this.c & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(7, this.s);
    }
    if ((this.c & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(8, this.r);
    }
    if ((this.c & 0x10) != 0) {
      paramCodedOutputByteBufferNano.a(9, this.h);
    }
    localObject = this.n;
    if (localObject == null) {}
    for (;;)
    {
      if ((this.c & 0x40) != 0) {
        paramCodedOutputByteBufferNano.a(14, this.p);
      }
      if ((this.c & 0x80) != 0) {
        paramCodedOutputByteBufferNano.a(15, this.e);
      }
      if ((this.c & 0x100) != 0) {
        paramCodedOutputByteBufferNano.a(16, this.m);
      }
      localObject = this.l;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.a(17, (cl)localObject);
      }
      if ((this.c & 0x200) != 0) {
        paramCodedOutputByteBufferNano.a(19, this.b);
      }
      localObject = this.q;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.a(20, (cl)localObject);
      }
      if ((this.c & 0x800) != 0) {
        paramCodedOutputByteBufferNano.a(21, this.o);
      }
      if ((this.c & 0x20) != 0) {
        paramCodedOutputByteBufferNano.a(22, this.t);
      }
      if ((this.c & 0x400) != 0) {
        paramCodedOutputByteBufferNano.a(23, this.i);
      }
      if ((this.c & 0x1000) != 0) {
        paramCodedOutputByteBufferNano.a(24, this.a);
      }
      super.a(paramCodedOutputByteBufferNano);
      return;
      CodedOutputStream localCodedOutputStream = paramCodedOutputByteBufferNano.a();
      localCodedOutputStream.e(10, (cl)localObject);
      localCodedOutputStream.h();
      paramCodedOutputByteBufferNano.b = paramCodedOutputByteBufferNano.a.position();
    }
  }
  
  public final boolean c()
  {
    return (this.c & 0x400) != 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      int i1;
      int i2;
      Object localObject;
      if ((paramObject instanceof bu))
      {
        paramObject = (bu)paramObject;
        i1 = this.c;
        i2 = ((bu)paramObject).c;
        if (((i1 & 0x1) == (i2 & 0x1)) && (this.f == ((bu)paramObject).f) && ((i1 & 0x2) == (i2 & 0x2)) && (this.r == ((bu)paramObject).r))
        {
          localObject = this.d;
          if (localObject != null) {
            break label584;
          }
          if (((bu)paramObject).d != null) {}
        }
      }
      label528:
      label542:
      label556:
      label584:
      while (((bv)localObject).equals(((bu)paramObject).d))
      {
        localObject = this.g;
        if (localObject == null) {
          if (((bu)paramObject).g != null) {}
        }
        while (((String)localObject).equals(((bu)paramObject).g))
        {
          if (((this.c & 0x4) == (((bu)paramObject).c & 0x4)) && (this.s.equals(((bu)paramObject).s)) && ((this.c & 0x8) == (((bu)paramObject).c & 0x8)) && (this.k.equals(((bu)paramObject).k)))
          {
            i1 = this.c;
            i2 = ((bu)paramObject).c;
            if (((i1 & 0x10) == (i2 & 0x10)) && (this.h == ((bu)paramObject).h) && ((i1 & 0x20) == (i2 & 0x20)) && (this.t == ((bu)paramObject).t) && ((i1 & 0x40) == (i2 & 0x40)) && (this.p == ((bu)paramObject).p) && ((i1 & 0x80) == (i2 & 0x80)) && (this.e.equals(((bu)paramObject).e)) && ((this.c & 0x100) == (((bu)paramObject).c & 0x100)) && (this.m == ((bu)paramObject).m))
            {
              localObject = this.l;
              if (localObject != null) {
                break label556;
              }
              if (((bu)paramObject).l != null) {}
            }
          }
          while (((bb)localObject).equals(((bu)paramObject).l))
          {
            if (((this.c & 0x200) == (((bu)paramObject).c & 0x200)) && (this.b.equals(((bu)paramObject).b)))
            {
              localObject = this.q;
              if (localObject != null) {
                break label542;
              }
              if (((bu)paramObject).q != null) {}
            }
            while (((bb)localObject).equals(((bu)paramObject).q))
            {
              if (((this.c & 0x400) == (((bu)paramObject).c & 0x400)) && (this.i.equals(((bu)paramObject).i)))
              {
                localObject = this.n;
                if (localObject != null) {
                  break label528;
                }
                if (((bu)paramObject).n != null) {}
              }
              while (((bb)localObject).equals(((bu)paramObject).n))
              {
                i1 = this.c;
                i2 = ((bu)paramObject).c;
                if (((i1 & 0x800) == (i2 & 0x800)) && (this.o == ((bu)paramObject).o) && ((i1 & 0x1000) == (i2 & 0x1000)) && (this.a.equals(((bu)paramObject).a)))
                {
                  localObject = this.unknownFieldData;
                  if ((localObject == null) || (((d)localObject).a())) {
                    paramObject = ((bu)paramObject).unknownFieldData;
                  }
                }
                else
                {
                  return (paramObject == null) || (((d)paramObject).a());
                }
                return this.unknownFieldData.equals(((bu)paramObject).unknownFieldData);
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
    int i5 = 1237;
    int i10 = 0;
    int i11 = getClass().getName().hashCode();
    int i12 = this.f;
    int i13 = this.r;
    Object localObject = this.d;
    if (localObject != null) {}
    for (int i1 = ((bv)localObject).hashCode();; i1 = 0)
    {
      localObject = this.g;
      if (localObject != null) {}
      for (int i2 = ((String)localObject).hashCode();; i2 = 0)
      {
        int i14 = this.s.hashCode();
        int i15 = this.k.hashCode();
        if (!this.h) {}
        for (int i3 = 1237;; i3 = 1231)
        {
          if (!this.t) {}
          for (int i4 = 1237;; i4 = 1231)
          {
            int i16 = this.p;
            int i17 = this.e.hashCode();
            if (!this.m) {}
            for (;;)
            {
              localObject = this.l;
              if (localObject != null) {}
              for (int i6 = ((bb)localObject).hashCode();; i6 = 0)
              {
                int i18 = this.b.hashCode();
                localObject = this.q;
                if (localObject != null) {}
                for (int i7 = ((bb)localObject).hashCode();; i7 = 0)
                {
                  int i19 = this.i.hashCode();
                  localObject = this.n;
                  if (localObject != null) {}
                  for (int i8 = ((bb)localObject).hashCode();; i8 = 0)
                  {
                    int i20 = this.o;
                    int i21 = this.a.hashCode();
                    localObject = this.unknownFieldData;
                    int i9 = i10;
                    if (localObject != null)
                    {
                      i9 = i10;
                      if (!((d)localObject).a()) {
                        i9 = this.unknownFieldData.hashCode();
                      }
                    }
                    return (((i8 + ((i7 + ((i6 + ((((i4 + (i3 + (((i2 + (i1 + (((i11 + 527) * 31 + i12) * 31 + i13) * 31) * 31) * 31 + i14) * 31 + i15) * 31) * 31) * 31 + i16) * 31 + i17) * 31 + i5) * 31) * 31 + i18) * 31) * 31 + i19) * 31) * 31 + i20) * 31 + i21) * 31 + i9;
                  }
                }
              }
              i5 = 1231;
            }
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */