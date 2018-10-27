package com.google.android.finsky.ds.a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.bb;
import com.google.protobuf.bh;
import com.google.protobuf.cl;
import com.google.protobuf.cw;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;
import com.google.protobuf.nano.j;

public final class o
  extends b
{
  public md A = null;
  public String B = "";
  public boolean C = true;
  public int D = 0;
  public String E = "";
  private String F = "";
  private String G = "";
  private String[] H = j.h;
  private String[] I = j.h;
  private int J = 0;
  private boolean K = false;
  private int L = 0;
  private String M = "";
  private com.google.wireless.android.finsky.dfe.b.b.d N = null;
  public u a = null;
  public int b = 0;
  public n[] c = n.b();
  public bf[] d = bf.b();
  public boolean e = false;
  public String f = "";
  public String g = "";
  public String h = "";
  public fb i = null;
  public String j = "";
  public dg k = null;
  public boolean l = false;
  public boolean m = false;
  public ds[] n = ds.b();
  public fa o = null;
  public String p = "";
  public long q = 0L;
  public String r = "";
  public String s = "";
  public String t = "";
  public String[] u = j.h;
  public if v = null;
  public String w = "";
  public String x = "";
  public int[] y = j.f;
  public int z = 0;
  
  public o()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static o a(byte[] paramArrayOfByte)
  {
    return (o)g.a(new o(), paramArrayOfByte);
  }
  
  private final o b(a parama)
  {
    Object localObject1;
    Object localObject3;
    for (;;)
    {
      i3 = parama.a();
      switch (i3)
      {
      default: 
        if (super.a(parama, i3)) {}
        break;
      case 0: 
        return this;
      case 394: 
        this.w = parama.c();
        this.b |= 0x1000000;
        break;
      case 386: 
        this.F = parama.c();
        this.b |= 0x2000;
        break;
      case 378: 
        i2 = j.a(parama, 378);
        localObject1 = this.c;
        if (localObject1 != null) {}
        for (i1 = localObject1.length;; i1 = 0)
        {
          localObject3 = new n[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(localObject1, 0, localObject3, 0, i1);
            i2 = i1;
          }
          while (i2 < localObject3.length - 1)
          {
            localObject3[i2] = new n();
            parama.a(localObject3[i2]);
            parama.a();
            i2 += 1;
          }
          localObject3[i2] = new n();
          parama.a(localObject3[i2]);
          this.c = ((n[])localObject3);
          break;
        }
      case 370: 
        if (this.i == null) {
          this.i = new fb();
        }
        parama.a(this.i);
        break;
      case 362: 
        this.f = parama.c();
        this.b |= 0x80;
        break;
      case 346: 
        this.r = parama.c();
        this.b |= 0x800000;
        break;
      case 330: 
        if (this.a == null) {
          this.a = new u();
        }
        parama.a(this.a);
        break;
      case 322: 
        if (this.v == null) {
          this.v = new if();
        }
        parama.a(this.v);
      }
    }
    int i3 = parama.c(parama.e());
    int i1 = parama.j();
    int i2 = 0;
    label722:
    label792:
    int i5;
    for (;;)
    {
      if (parama.i() > 0) {}
      try
      {
        kz.c(parama.e());
        i2 += 1;
      }
      catch (IllegalArgumentException localIllegalArgumentException2) {}
      if (i2 != 0)
      {
        parama.e(i1);
        localObject3 = this.y;
        if (localObject3 == null) {
          break label792;
        }
        i1 = localObject3.length;
        localObject1 = new int[i2 + i1];
        i2 = i1;
        if (i1 != 0)
        {
          System.arraycopy(localObject3, 0, localObject1, 0, i1);
          i2 = i1;
        }
      }
      for (;;)
      {
        if (parama.i() > 0) {
          i1 = parama.j();
        }
        try
        {
          localObject1[i2] = kz.c(parama.e());
          i2 += 1;
        }
        catch (IllegalArgumentException localIllegalArgumentException3)
        {
          int i4;
          parama.e(i1);
          a(parama, 304);
        }
        this.y = ((int[])localObject1);
        parama.d(i3);
        break;
        i1 = 0;
        break label722;
        i4 = j.a(parama, 304);
        localObject1 = new int[i4];
        i2 = 0;
        i1 = 0;
        if (i2 >= i4)
        {
          if (i1 == 0) {
            break;
          }
          localObject3 = this.y;
          if (localObject3 != null) {}
          for (i2 = localObject3.length;; i2 = 0)
          {
            if (i2 != 0) {}
            while (i1 != localObject1.length)
            {
              int[] arrayOfInt = new int[i2 + i1];
              if (i2 != 0) {
                System.arraycopy(localObject3, 0, arrayOfInt, 0, i2);
              }
              System.arraycopy(localObject1, 0, arrayOfInt, i2, i1);
              this.y = arrayOfInt;
              break;
            }
            this.y = ((int[])localObject1);
            break;
          }
        }
        if (i2 == 0) {}
        for (;;)
        {
          i5 = parama.j();
          try
          {
            localObject1[i1] = kz.c(parama.e());
            i1 += 1;
          }
          catch (IllegalArgumentException localIllegalArgumentException4)
          {
            for (;;)
            {
              Object localObject2;
              parama.e(i5);
              a(parama, i3);
            }
          }
          i2 += 1;
          break;
          parama.a();
        }
        this.N = ((com.google.wireless.android.finsky.dfe.b.b.d)parama.a((cw)com.google.wireless.android.finsky.dfe.b.b.d.a.a(bh.d, null)));
        break;
        if (this.k == null) {
          this.k = new dg();
        }
        parama.a(this.k);
        break;
        if (this.A == null) {
          this.A = new md();
        }
        parama.a(this.A);
        break;
        if (this.o == null) {
          this.o = new fa();
        }
        parama.a(this.o);
        break;
        this.M = parama.c();
        this.b |= 0x400000;
        break;
        this.z = parama.e();
        this.b |= 0x200000;
        break;
        this.b |= 0x100000;
        i1 = parama.j();
        try
        {
          this.L = kz.d(parama.e());
          this.b |= 0x100000;
        }
        catch (IllegalArgumentException localIllegalArgumentException1)
        {
          parama.e(i1);
          a(parama, i3);
        }
        break;
        this.p = parama.c();
        this.b |= 0x80000;
        break;
        this.l = parama.b();
        this.b |= 0x40000;
        break;
        this.m = parama.b();
        this.b |= 0x20000;
        break;
        this.K = parama.b();
        this.b |= 0x10000;
        break;
        this.e = parama.b();
        this.b |= 0x8000;
        break;
        i2 = j.a(parama, 186);
        localObject2 = this.H;
        if (localObject2 != null) {}
        for (i1 = localObject2.length;; i1 = 0)
        {
          localObject3 = new String[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(localObject2, 0, localObject3, 0, i1);
            i2 = i1;
          }
          while (i2 < localObject3.length - 1)
          {
            localObject3[i2] = parama.c();
            parama.a();
            i2 += 1;
          }
          localObject3[i2] = parama.c();
          this.H = ((String[])localObject3);
          break;
        }
        i2 = j.a(parama, 178);
        localObject2 = this.d;
        if (localObject2 != null) {}
        for (i1 = localObject2.length;; i1 = 0)
        {
          localObject3 = new bf[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(localObject2, 0, localObject3, 0, i1);
            i2 = i1;
          }
          while (i2 < localObject3.length - 1)
          {
            localObject3[i2] = new bf();
            parama.a(localObject3[i2]);
            parama.a();
            i2 += 1;
          }
          localObject3[i2] = new bf();
          parama.a(localObject3[i2]);
          this.d = ((bf[])localObject3);
          break;
        }
        this.C = parama.b();
        this.b |= 0x4000;
        break;
        i2 = j.a(parama, 154);
        localObject2 = this.I;
        if (localObject2 != null) {}
        for (i1 = localObject2.length;; i1 = 0)
        {
          localObject3 = new String[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(localObject2, 0, localObject3, 0, i1);
            i2 = i1;
          }
          while (i2 < localObject3.length - 1)
          {
            localObject3[i2] = parama.c();
            parama.a();
            i2 += 1;
          }
          localObject3[i2] = parama.c();
          this.I = ((String[])localObject3);
          break;
        }
        this.G = parama.c();
        this.b |= 0x1000;
        break;
        i2 = j.a(parama, 138);
        localObject2 = this.n;
        if (localObject2 != null) {}
        for (i1 = localObject2.length;; i1 = 0)
        {
          localObject3 = new ds[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(localObject2, 0, localObject3, 0, i1);
            i2 = i1;
          }
          while (i2 < localObject3.length - 1)
          {
            localObject3[i2] = new ds();
            parama.a(localObject3[i2]);
            parama.a();
            i2 += 1;
          }
          localObject3[i2] = new ds();
          parama.a(localObject3[i2]);
          this.n = ((ds[])localObject3);
          break;
        }
        this.B = parama.c();
        this.b |= 0x800;
        break;
        this.x = parama.c();
        this.b |= 0x400;
        break;
        this.t = parama.c();
        this.b |= 0x200;
        break;
        this.s = parama.c();
        this.b |= 0x100;
        break;
        this.j = parama.c();
        this.b |= 0x40;
        break;
        this.g = parama.c();
        this.b |= 0x20;
        break;
        i2 = j.a(parama, 82);
        localObject2 = this.u;
        if (localObject2 != null) {}
        for (i1 = localObject2.length;; i1 = 0)
        {
          localObject3 = new String[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(localObject2, 0, localObject3, 0, i1);
            i2 = i1;
          }
          while (i2 < localObject3.length - 1)
          {
            localObject3[i2] = parama.c();
            parama.a();
            i2 += 1;
          }
          localObject3[i2] = parama.c();
          this.u = ((String[])localObject3);
          break;
        }
        this.q = parama.f();
        this.b |= 0x10;
        break;
        this.J = parama.e();
        this.b |= 0x8;
        break;
        this.E = parama.c();
        this.b |= 0x4;
        break;
        this.D = parama.e();
        this.b |= 0x2;
        break;
        this.h = parama.c();
        this.b |= 0x1;
        break;
      }
    }
  }
  
  protected final int a()
  {
    int i7 = 0;
    int i2 = super.a();
    int i1 = i2;
    if ((this.b & 0x1) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(1, this.h);
    }
    i2 = i1;
    if ((this.b & 0x2) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.d(3, this.D);
    }
    i1 = i2;
    if ((this.b & 0x4) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(4, this.E);
    }
    i2 = i1;
    if ((this.b & 0x8) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.d(8, this.J);
    }
    i1 = i2;
    if ((this.b & 0x10) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.f(9, this.q);
    }
    Object localObject = this.u;
    i2 = i1;
    int i3;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i2 = 0;
        i3 = 0;
      }
    }
    int i5;
    for (int i4 = 0;; i4 = i5)
    {
      localObject = this.u;
      if (i2 >= localObject.length)
      {
        i2 = i1 + i3 + i4;
        i1 = i2;
        if ((this.b & 0x20) != 0) {
          i1 = i2 + CodedOutputByteBufferNano.b(11, this.g);
        }
        i2 = i1;
        if ((this.b & 0x40) != 0) {
          i2 = i1 + CodedOutputByteBufferNano.b(12, this.j);
        }
        i1 = i2;
        if ((this.b & 0x100) != 0) {
          i1 = i2 + CodedOutputByteBufferNano.b(13, this.s);
        }
        i2 = i1;
        if ((this.b & 0x200) != 0) {
          i2 = i1 + CodedOutputByteBufferNano.b(14, this.t);
        }
        i3 = i2;
        if ((this.b & 0x400) != 0) {
          i3 = i2 + CodedOutputByteBufferNano.b(15, this.x);
        }
        i1 = i3;
        if ((this.b & 0x800) != 0) {
          i1 = i3 + CodedOutputByteBufferNano.b(16, this.B);
        }
        localObject = this.n;
        i2 = i1;
        if (localObject != null)
        {
          i2 = i1;
          if (localObject.length > 0)
          {
            i2 = 0;
            for (;;)
            {
              localObject = this.n;
              if (i2 >= localObject.length) {
                break;
              }
              localObject = localObject[i2];
              i3 = i1;
              if (localObject != null) {
                i3 = i1 + CodedOutputByteBufferNano.d(17, (g)localObject);
              }
              i2 += 1;
              i1 = i3;
            }
            i2 = i1;
          }
        }
        if ((this.b & 0x1000) != 0) {}
        for (i1 = i2 + CodedOutputByteBufferNano.b(18, this.G);; i1 = i2)
        {
          localObject = this.I;
          i2 = i1;
          if (localObject != null)
          {
            i2 = i1;
            if (localObject.length > 0)
            {
              i2 = 0;
              i3 = 0;
            }
          }
          for (i4 = 0;; i4 = i5)
          {
            localObject = this.I;
            if (i2 >= localObject.length)
            {
              i2 = i3 + i1 + (i4 + i4);
              i1 = i2;
              if ((this.b & 0x4000) != 0) {
                i1 = i2 + (CodedOutputByteBufferNano.d(168) + 1);
              }
              localObject = this.d;
              i2 = i1;
              if (localObject != null)
              {
                i2 = i1;
                if (localObject.length > 0)
                {
                  i3 = 0;
                  for (;;)
                  {
                    localObject = this.d;
                    i2 = i1;
                    if (i3 >= localObject.length) {
                      break;
                    }
                    localObject = localObject[i3];
                    i2 = i1;
                    if (localObject != null) {
                      i2 = i1 + CodedOutputByteBufferNano.d(22, (g)localObject);
                    }
                    i3 += 1;
                    i1 = i2;
                  }
                }
              }
              localObject = this.H;
              i1 = i2;
              if (localObject != null)
              {
                i1 = i2;
                if (localObject.length > 0)
                {
                  i1 = 0;
                  i3 = 0;
                }
              }
              for (i4 = 0;; i4 = i5)
              {
                localObject = this.H;
                if (i1 >= localObject.length)
                {
                  i1 = i3 + i2 + (i4 + i4);
                  i2 = i1;
                  if ((this.b & 0x8000) != 0) {
                    i2 = i1 + (CodedOutputByteBufferNano.d(192) + 1);
                  }
                  i1 = i2;
                  if ((this.b & 0x10000) != 0) {
                    i1 = i2 + (CodedOutputByteBufferNano.d(208) + 1);
                  }
                  i2 = i1;
                  if ((this.b & 0x20000) != 0) {
                    i2 = i1 + (CodedOutputByteBufferNano.d(216) + 1);
                  }
                  i1 = i2;
                  if ((this.b & 0x40000) != 0) {
                    i1 = i2 + (CodedOutputByteBufferNano.d(224) + 1);
                  }
                  i2 = i1;
                  if ((this.b & 0x80000) != 0) {
                    i2 = i1 + CodedOutputByteBufferNano.b(30, this.p);
                  }
                  i1 = i2;
                  if ((this.b & 0x100000) != 0) {
                    i1 = i2 + CodedOutputByteBufferNano.d(31, this.L);
                  }
                  i2 = i1;
                  if ((this.b & 0x200000) != 0) {
                    i2 = i1 + CodedOutputByteBufferNano.d(32, this.z);
                  }
                  i1 = i2;
                  if ((this.b & 0x400000) != 0) {
                    i1 = i2 + CodedOutputByteBufferNano.b(33, this.M);
                  }
                  localObject = this.o;
                  i2 = i1;
                  if (localObject != null) {
                    i2 = i1 + CodedOutputByteBufferNano.d(34, (g)localObject);
                  }
                  localObject = this.A;
                  i1 = i2;
                  if (localObject != null) {
                    i1 = i2 + CodedOutputByteBufferNano.d(35, (g)localObject);
                  }
                  localObject = this.k;
                  i2 = i1;
                  if (localObject != null) {
                    i2 = i1 + CodedOutputByteBufferNano.d(36, (g)localObject);
                  }
                  localObject = this.N;
                  if (localObject != null) {}
                  for (i1 = i2 + CodedOutputStream.c(37, (cl)localObject);; i1 = i2)
                  {
                    localObject = this.y;
                    if (localObject != null) {
                      if (localObject.length > 0)
                      {
                        i2 = 0;
                        i3 = 0;
                        for (;;)
                        {
                          localObject = this.y;
                          i4 = localObject.length;
                          if (i2 >= i4) {
                            break;
                          }
                          i3 += CodedOutputByteBufferNano.b(localObject[i2]);
                          i2 += 1;
                        }
                        i1 = i1 + i3 + (i4 + i4);
                      }
                    }
                    for (;;)
                    {
                      localObject = this.v;
                      i2 = i1;
                      if (localObject != null) {
                        i2 = i1 + CodedOutputByteBufferNano.d(40, (g)localObject);
                      }
                      localObject = this.a;
                      i1 = i2;
                      if (localObject != null) {
                        i1 = i2 + CodedOutputByteBufferNano.d(41, (g)localObject);
                      }
                      i2 = i1;
                      if ((this.b & 0x800000) != 0) {
                        i2 = i1 + CodedOutputByteBufferNano.b(43, this.r);
                      }
                      i3 = i2;
                      if ((this.b & 0x80) != 0) {
                        i3 = i2 + CodedOutputByteBufferNano.b(45, this.f);
                      }
                      localObject = this.i;
                      i1 = i3;
                      if (localObject != null) {
                        i1 = i3 + CodedOutputByteBufferNano.d(46, (g)localObject);
                      }
                      localObject = this.c;
                      i2 = i1;
                      if (localObject != null)
                      {
                        i2 = i1;
                        if (localObject.length > 0)
                        {
                          i3 = i7;
                          for (;;)
                          {
                            localObject = this.c;
                            i2 = i1;
                            if (i3 >= localObject.length) {
                              break;
                            }
                            localObject = localObject[i3];
                            i2 = i1;
                            if (localObject != null) {
                              i2 = i1 + CodedOutputByteBufferNano.d(47, (g)localObject);
                            }
                            i3 += 1;
                            i1 = i2;
                          }
                        }
                      }
                      i1 = i2;
                      if ((this.b & 0x2000) != 0) {
                        i1 = i2 + CodedOutputByteBufferNano.b(48, this.F);
                      }
                      i2 = i1;
                      if ((this.b & 0x1000000) != 0) {
                        i2 = i1 + CodedOutputByteBufferNano.b(49, this.w);
                      }
                      return i2;
                    }
                  }
                }
                localObject = localObject[i1];
                i6 = i3;
                i5 = i4;
                if (localObject != null)
                {
                  i5 = i4 + 1;
                  i6 = i3 + CodedOutputByteBufferNano.a((String)localObject);
                }
                i1 += 1;
                i3 = i6;
              }
            }
            localObject = localObject[i2];
            i6 = i3;
            i5 = i4;
            if (localObject != null)
            {
              i5 = i4 + 1;
              i6 = i3 + CodedOutputByteBufferNano.a((String)localObject);
            }
            i2 += 1;
            i3 = i6;
          }
        }
      }
      localObject = localObject[i2];
      int i6 = i3;
      i5 = i4;
      if (localObject != null)
      {
        i5 = i4 + 1;
        i6 = i3 + CodedOutputByteBufferNano.a((String)localObject);
      }
      i2 += 1;
      i3 = i6;
    }
  }
  
  public final o a(int paramInt)
  {
    this.b |= 0x2;
    this.D = paramInt;
    return this;
  }
  
  public final o a(String paramString)
  {
    if (paramString != null)
    {
      this.b |= 0x200;
      this.t = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i2 = 0;
    if ((this.b & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.h);
    }
    if ((this.b & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.D);
    }
    if ((this.b & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.E);
    }
    if ((this.b & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(8, this.J);
    }
    if ((this.b & 0x10) != 0) {
      paramCodedOutputByteBufferNano.b(9, this.q);
    }
    Object localObject = this.u;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int i1;
    label772:
    do
    {
      if ((this.b & 0x20) != 0) {
        paramCodedOutputByteBufferNano.a(11, this.g);
      }
      if ((this.b & 0x40) != 0) {
        paramCodedOutputByteBufferNano.a(12, this.j);
      }
      if ((this.b & 0x100) != 0) {
        paramCodedOutputByteBufferNano.a(13, this.s);
      }
      if ((this.b & 0x200) != 0) {
        paramCodedOutputByteBufferNano.a(14, this.t);
      }
      if ((this.b & 0x400) != 0) {
        paramCodedOutputByteBufferNano.a(15, this.x);
      }
      if ((this.b & 0x800) != 0) {
        paramCodedOutputByteBufferNano.a(16, this.B);
      }
      localObject = this.n;
      if ((localObject == null) || (localObject.length <= 0)) {}
      do
      {
        if ((this.b & 0x1000) != 0) {
          paramCodedOutputByteBufferNano.a(18, this.G);
        }
        localObject = this.I;
        if ((localObject == null) || (localObject.length <= 0)) {}
        do
        {
          if ((this.b & 0x4000) != 0) {
            paramCodedOutputByteBufferNano.a(21, this.C);
          }
          localObject = this.d;
          if ((localObject == null) || (localObject.length <= 0)) {}
          do
          {
            localObject = this.H;
            if ((localObject == null) || (localObject.length <= 0)) {}
            do
            {
              if ((this.b & 0x8000) != 0) {
                paramCodedOutputByteBufferNano.a(24, this.e);
              }
              if ((this.b & 0x10000) != 0) {
                paramCodedOutputByteBufferNano.a(26, this.K);
              }
              if ((this.b & 0x20000) != 0) {
                paramCodedOutputByteBufferNano.a(27, this.m);
              }
              if ((this.b & 0x40000) != 0) {
                paramCodedOutputByteBufferNano.a(28, this.l);
              }
              if ((this.b & 0x80000) != 0) {
                paramCodedOutputByteBufferNano.a(30, this.p);
              }
              if ((this.b & 0x100000) != 0) {
                paramCodedOutputByteBufferNano.a(31, this.L);
              }
              if ((this.b & 0x200000) != 0) {
                paramCodedOutputByteBufferNano.a(32, this.z);
              }
              if ((this.b & 0x400000) != 0) {
                paramCodedOutputByteBufferNano.a(33, this.M);
              }
              localObject = this.o;
              if (localObject != null) {
                paramCodedOutputByteBufferNano.b(34, (g)localObject);
              }
              localObject = this.A;
              if (localObject != null) {
                paramCodedOutputByteBufferNano.b(35, (g)localObject);
              }
              localObject = this.k;
              if (localObject != null) {
                paramCodedOutputByteBufferNano.b(36, (g)localObject);
              }
              localObject = this.N;
              if (localObject != null) {
                paramCodedOutputByteBufferNano.a(37, (cl)localObject);
              }
              localObject = this.y;
              if ((localObject == null) || (localObject.length <= 0))
              {
                localObject = this.v;
                if (localObject != null) {
                  paramCodedOutputByteBufferNano.b(40, (g)localObject);
                }
                localObject = this.a;
                if (localObject != null) {
                  paramCodedOutputByteBufferNano.b(41, (g)localObject);
                }
                if ((this.b & 0x800000) != 0) {
                  paramCodedOutputByteBufferNano.a(43, this.r);
                }
                if ((this.b & 0x80) != 0) {
                  paramCodedOutputByteBufferNano.a(45, this.f);
                }
                localObject = this.i;
                if (localObject != null) {
                  paramCodedOutputByteBufferNano.b(46, (g)localObject);
                }
                localObject = this.c;
                if (localObject != null)
                {
                  i1 = i2;
                  if (localObject.length > 0) {
                    break label772;
                  }
                }
                do
                {
                  if ((this.b & 0x2000) != 0) {
                    paramCodedOutputByteBufferNano.a(48, this.F);
                  }
                  if ((this.b & 0x1000000) != 0) {
                    paramCodedOutputByteBufferNano.a(49, this.w);
                  }
                  super.a(paramCodedOutputByteBufferNano);
                  return;
                  localObject = this.c;
                } while (i1 >= localObject.length);
                localObject = localObject[i1];
                if (localObject == null) {}
                for (;;)
                {
                  i1 += 1;
                  break;
                  paramCodedOutputByteBufferNano.b(47, (g)localObject);
                }
              }
              i1 = 0;
              for (;;)
              {
                localObject = this.y;
                if (i1 >= localObject.length) {
                  break;
                }
                paramCodedOutputByteBufferNano.a(38, localObject[i1]);
                i1 += 1;
              }
              i1 = 0;
              localObject = this.H;
            } while (i1 >= localObject.length);
            localObject = localObject[i1];
            if (localObject == null) {}
            for (;;)
            {
              i1 += 1;
              break;
              paramCodedOutputByteBufferNano.a(23, (String)localObject);
            }
            i1 = 0;
            localObject = this.d;
          } while (i1 >= localObject.length);
          localObject = localObject[i1];
          if (localObject == null) {}
          for (;;)
          {
            i1 += 1;
            break;
            paramCodedOutputByteBufferNano.b(22, (g)localObject);
          }
          i1 = 0;
          localObject = this.I;
        } while (i1 >= localObject.length);
        localObject = localObject[i1];
        if (localObject == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          paramCodedOutputByteBufferNano.a(19, (String)localObject);
        }
        i1 = 0;
        localObject = this.n;
      } while (i1 >= localObject.length);
      localObject = localObject[i1];
      if (localObject == null) {}
      for (;;)
      {
        i1 += 1;
        break;
        paramCodedOutputByteBufferNano.b(17, (g)localObject);
      }
      i1 = 0;
      localObject = this.u;
    } while (i1 >= localObject.length);
    localObject = localObject[i1];
    if (localObject == null) {}
    for (;;)
    {
      i1 += 1;
      break;
      paramCodedOutputByteBufferNano.a(10, (String)localObject);
    }
  }
  
  public final boolean b()
  {
    return (this.b & 0x4) != 0;
  }
  
  public final boolean c()
  {
    return (this.b & 0x200) != 0;
  }
  
  public final boolean d()
  {
    return (this.b & 0x40000) != 0;
  }
  
  public final boolean e()
  {
    return (this.b & 0x80000) != 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      int i1;
      int i2;
      Object localObject;
      if ((paramObject instanceof o))
      {
        paramObject = (o)paramObject;
        if (((this.b & 0x1) == (((o)paramObject).b & 0x1)) && (this.h.equals(((o)paramObject).h)))
        {
          i1 = this.b;
          i2 = ((o)paramObject).b;
          if (((i1 & 0x2) == (i2 & 0x2)) && (this.D == ((o)paramObject).D) && ((i1 & 0x4) == (i2 & 0x4)) && (this.E.equals(((o)paramObject).E)))
          {
            i1 = this.b;
            i2 = ((o)paramObject).b;
            if (((i1 & 0x8) == (i2 & 0x8)) && (this.J == ((o)paramObject).J) && ((i1 & 0x10) == (i2 & 0x10)) && (this.q == ((o)paramObject).q) && (f.a(this.u, ((o)paramObject).u)) && ((this.b & 0x20) == (((o)paramObject).b & 0x20)) && (this.g.equals(((o)paramObject).g)) && ((this.b & 0x40) == (((o)paramObject).b & 0x40)) && (this.j.equals(((o)paramObject).j)) && ((this.b & 0x80) == (((o)paramObject).b & 0x80)) && (this.f.equals(((o)paramObject).f)))
            {
              localObject = this.i;
              if (localObject != null) {
                break label1116;
              }
              if (((o)paramObject).i != null) {}
            }
          }
        }
      }
      label1102:
      label1116:
      while (((fb)localObject).equals(((o)paramObject).i))
      {
        if (((this.b & 0x100) == (((o)paramObject).b & 0x100)) && (this.s.equals(((o)paramObject).s)) && ((this.b & 0x200) == (((o)paramObject).b & 0x200)) && (this.t.equals(((o)paramObject).t)) && ((this.b & 0x400) == (((o)paramObject).b & 0x400)) && (this.x.equals(((o)paramObject).x)) && ((this.b & 0x800) == (((o)paramObject).b & 0x800)) && (this.B.equals(((o)paramObject).B)) && (f.a(this.n, ((o)paramObject).n)) && ((this.b & 0x1000) == (((o)paramObject).b & 0x1000)) && (this.G.equals(((o)paramObject).G)) && ((this.b & 0x2000) == (((o)paramObject).b & 0x2000)) && (this.F.equals(((o)paramObject).F)) && (f.a(this.d, ((o)paramObject).d)) && (f.a(this.I, ((o)paramObject).I)) && ((this.b & 0x4000) == (((o)paramObject).b & 0x4000)) && (this.C == ((o)paramObject).C) && (f.a(this.H, ((o)paramObject).H)))
        {
          i1 = this.b;
          i2 = ((o)paramObject).b;
          if (((i1 & 0x8000) == (i2 & 0x8000)) && (this.e == ((o)paramObject).e) && ((i1 & 0x10000) == (i2 & 0x10000)) && (this.K == ((o)paramObject).K) && ((i1 & 0x20000) == (i2 & 0x20000)) && (this.m == ((o)paramObject).m) && ((0x40000 & i1) == (0x40000 & i2)) && (this.l == ((o)paramObject).l) && ((i1 & 0x80000) == (i2 & 0x80000)) && (this.p.equals(((o)paramObject).p)))
          {
            i1 = this.b;
            i2 = ((o)paramObject).b;
            if (((0x100000 & i1) == (0x100000 & i2)) && (this.L == ((o)paramObject).L) && ((0x200000 & i1) == (0x200000 & i2)) && (this.z == ((o)paramObject).z) && ((i1 & 0x400000) == (i2 & 0x400000)) && (this.M.equals(((o)paramObject).M)))
            {
              localObject = this.o;
              if (localObject != null) {
                break label1102;
              }
              if (((o)paramObject).o != null) {}
            }
          }
        }
        while (((fa)localObject).equals(((o)paramObject).o))
        {
          localObject = this.A;
          if (localObject == null) {
            if (((o)paramObject).A != null) {}
          }
          while (((md)localObject).equals(((o)paramObject).A))
          {
            localObject = this.k;
            if (localObject == null) {
              if (((o)paramObject).k != null) {}
            }
            while (((dg)localObject).equals(((o)paramObject).k))
            {
              localObject = this.N;
              if (localObject == null) {
                if (((o)paramObject).N != null) {}
              }
              while (((bb)localObject).equals(((o)paramObject).N))
              {
                localObject = this.v;
                if (localObject == null) {
                  if (((o)paramObject).v != null) {}
                }
                while (((if)localObject).equals(((o)paramObject).v))
                {
                  localObject = this.a;
                  if (localObject == null) {
                    if (((o)paramObject).a != null) {}
                  }
                  while (((u)localObject).equals(((o)paramObject).a))
                  {
                    if (((this.b & 0x800000) == (((o)paramObject).b & 0x800000)) && (this.r.equals(((o)paramObject).r)) && (f.a(this.y, ((o)paramObject).y)) && (f.a(this.c, ((o)paramObject).c)) && ((this.b & 0x1000000) == (((o)paramObject).b & 0x1000000)) && (this.w.equals(((o)paramObject).w)))
                    {
                      localObject = this.unknownFieldData;
                      if ((localObject == null) || (((com.google.protobuf.nano.d)localObject).a())) {
                        paramObject = ((o)paramObject).unknownFieldData;
                      }
                    }
                    else
                    {
                      return (paramObject == null) || (((com.google.protobuf.nano.d)paramObject).a());
                    }
                    return this.unknownFieldData.equals(((o)paramObject).unknownFieldData);
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
    int i6 = 1237;
    int i14 = 0;
    int i15 = getClass().getName().hashCode();
    int i16 = this.h.hashCode();
    int i17 = this.D;
    int i18 = this.E.hashCode();
    int i19 = this.J;
    long l1 = this.q;
    int i20 = f.a(this.u);
    int i21 = this.g.hashCode();
    int i22 = this.j.hashCode();
    int i23 = this.f.hashCode();
    Object localObject = this.i;
    int i24 = (int)(l1 >>> 32 ^ l1);
    if (localObject != null) {}
    for (int i1 = ((fb)localObject).hashCode();; i1 = 0)
    {
      int i25 = this.s.hashCode();
      int i26 = this.t.hashCode();
      int i27 = this.x.hashCode();
      int i28 = this.B.hashCode();
      int i29 = f.a(this.n);
      int i30 = this.G.hashCode();
      int i31 = this.F.hashCode();
      int i32 = f.a(this.d);
      int i33 = f.a(this.I);
      if (!this.C) {}
      for (int i2 = 1237;; i2 = 1231)
      {
        int i34 = f.a(this.H);
        if (!this.e) {}
        for (int i3 = 1237;; i3 = 1231)
        {
          if (!this.K) {}
          for (int i4 = 1237;; i4 = 1231)
          {
            if (!this.m) {}
            for (int i5 = 1237;; i5 = 1231)
            {
              if (!this.l) {}
              for (;;)
              {
                int i35 = this.p.hashCode();
                int i36 = this.L;
                int i37 = this.z;
                int i38 = this.M.hashCode();
                localObject = this.o;
                if (localObject != null) {}
                for (int i7 = ((fa)localObject).hashCode();; i7 = 0)
                {
                  localObject = this.A;
                  if (localObject != null) {}
                  for (int i8 = ((md)localObject).hashCode();; i8 = 0)
                  {
                    localObject = this.k;
                    if (localObject != null) {}
                    for (int i9 = ((dg)localObject).hashCode();; i9 = 0)
                    {
                      localObject = this.N;
                      if (localObject != null) {}
                      for (int i10 = ((bb)localObject).hashCode();; i10 = 0)
                      {
                        localObject = this.v;
                        if (localObject != null) {}
                        for (int i11 = ((if)localObject).hashCode();; i11 = 0)
                        {
                          localObject = this.a;
                          if (localObject != null) {}
                          for (int i12 = ((u)localObject).hashCode();; i12 = 0)
                          {
                            int i39 = this.r.hashCode();
                            int i40 = f.a(this.y);
                            int i41 = f.a(this.c);
                            int i42 = this.w.hashCode();
                            localObject = this.unknownFieldData;
                            int i13 = i14;
                            if (localObject != null)
                            {
                              i13 = i14;
                              if (!((com.google.protobuf.nano.d)localObject).a()) {
                                i13 = this.unknownFieldData.hashCode();
                              }
                            }
                            return (((((i12 + (i11 + (i10 + (i9 + (i8 + (i7 + ((((((i5 + (i4 + (i3 + ((i2 + ((((((((((i1 + ((((((((((i15 + 527) * 31 + i16) * 31 + i17) * 31 + i18) * 31 + i19) * 31 + i24) * 31 + i20) * 31 + i21) * 31 + i22) * 31 + i23) * 31) * 31 + i25) * 31 + i26) * 31 + i27) * 31 + i28) * 31 + i29) * 31 + i30) * 31 + i31) * 31 + i32) * 31 + i33) * 31) * 31 + i34) * 31) * 31) * 31) * 31 + i6) * 31 + i35) * 31 + i36) * 31 + i37) * 31 + i38) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i39) * 31 + i40) * 31 + i41) * 31 + i42) * 31 + i13;
                          }
                        }
                      }
                    }
                  }
                }
                i6 = 1231;
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */