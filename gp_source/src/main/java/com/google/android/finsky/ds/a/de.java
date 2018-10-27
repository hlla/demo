package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;
import com.google.protobuf.nano.j;
import java.util.Arrays;

public final class de
  extends b
{
  private static volatile de[] L;
  public String A = "";
  public String B = "";
  public int C = 0;
  public byte[] D = j.b;
  public String E = "";
  public String F = "";
  public String G = "";
  public kb[] H = kb.b();
  public String I = "";
  public String J = "";
  public boolean K = false;
  private String M = "";
  public iv a = null;
  public k b = null;
  public s[] c = s.b();
  public dt d = null;
  public boolean e = false;
  public String f = "";
  public int g = 0;
  public String h = "";
  public int i = 0;
  public de[] j = b();
  public cm k = null;
  public String l = "";
  public String m = "";
  public String n = "";
  public cx o = null;
  public boolean p = false;
  public String q = "";
  public int r = 1;
  public String s = "";
  public boolean t = false;
  public bu[] u = bu.b();
  public boolean v = false;
  public by[] w = by.b();
  public cz x = null;
  public String y = "";
  public String z = "";
  
  public de()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final de b(a parama)
  {
    for (;;)
    {
      int i1 = parama.a();
      int i2;
      Object localObject2;
      Object localObject1;
      switch (i1)
      {
      default: 
        if (super.a(parama, i1)) {}
        break;
      case 0: 
        return this;
      case 314: 
        this.A = parama.c();
        this.i |= 0x2000000;
        break;
      case 306: 
        i2 = j.a(parama, 306);
        s[] arrayOfs = this.c;
        if (arrayOfs != null) {}
        for (i1 = arrayOfs.length;; i1 = 0)
        {
          localObject2 = new s[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(arrayOfs, 0, localObject2, 0, i1);
            i2 = i1;
          }
          while (i2 < localObject2.length - 1)
          {
            localObject2[i2] = new s();
            parama.a(localObject2[i2]);
            parama.a();
            i2 += 1;
          }
          localObject2[i2] = new s();
          parama.a(localObject2[i2]);
          this.c = ((s[])localObject2);
          break;
        }
      case 296: 
        this.i |= 0x1000000;
        i2 = parama.j();
        try
        {
          this.C = kf.a(parama.e());
          this.i |= 0x1000000;
        }
        catch (IllegalArgumentException localIllegalArgumentException1)
        {
          parama.e(i2);
          a(parama, i1);
        }
        break;
      case 290: 
        this.M = parama.c();
        this.i |= 0x400;
        break;
      case 282: 
        this.m = parama.c();
        this.i |= 0x800000;
        break;
      case 274: 
        this.z = parama.c();
        this.i |= 0x4000;
        break;
      case 264: 
        this.K = parama.b();
        this.i |= 0x400000;
        break;
      case 256: 
        this.t = parama.b();
        this.i |= 0x200000;
        break;
      case 250: 
        this.F = parama.c();
        this.i |= 0x8000;
        break;
      case 242: 
        i2 = j.a(parama, 242);
        localObject1 = this.H;
        if (localObject1 != null) {}
        for (i1 = localObject1.length;; i1 = 0)
        {
          localObject2 = new kb[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(localObject1, 0, localObject2, 0, i1);
            i2 = i1;
          }
          while (i2 < localObject2.length - 1)
          {
            localObject2[i2] = new kb();
            parama.a(localObject2[i2]);
            parama.a();
            i2 += 1;
          }
          localObject2[i2] = new kb();
          parama.a(localObject2[i2]);
          this.H = ((kb[])localObject2);
          break;
        }
      case 232: 
        this.e = parama.b();
        this.i |= 0x100000;
        break;
      case 218: 
        this.y = parama.c();
        this.i |= 0x200;
        break;
      case 208: 
        this.v = parama.b();
        this.i |= 0x80000;
        break;
      case 202: 
        if (this.x == null) {
          this.x = new cz();
        }
        parama.a(this.x);
        break;
      case 194: 
        this.D = parama.d();
        this.i |= 0x40000;
        break;
      case 186: 
        this.J = parama.c();
        this.i |= 0x100;
        break;
      case 178: 
        this.G = parama.c();
        this.i |= 0x20;
        break;
      case 168: 
        this.p = parama.b();
        this.i |= 0x20000;
        break;
      case 154: 
        this.h = parama.c();
        this.i |= 0x10000;
        break;
      case 146: 
        this.B = parama.c();
        this.i |= 0x2000;
        break;
      case 138: 
        this.E = parama.c();
        this.i |= 0x1000;
        break;
      case 130: 
        this.q = parama.c();
        this.i |= 0x800;
        break;
      case 122: 
        if (this.b == null) {
          this.b = new k();
        }
        parama.a(this.b);
        break;
      case 114: 
        if (this.a == null) {
          this.a = new iv();
        }
        parama.a(this.a);
        break;
      case 106: 
        if (this.o == null) {
          this.o = new cx();
        }
        parama.a(this.o);
        break;
      case 98: 
        if (this.k == null) {
          this.k = new cm();
        }
        parama.a(this.k);
        break;
      case 90: 
        i2 = j.a(parama, 90);
        localObject1 = this.j;
        if (localObject1 != null) {}
        for (i1 = localObject1.length;; i1 = 0)
        {
          localObject2 = new de[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(localObject1, 0, localObject2, 0, i1);
            i2 = i1;
          }
          while (i2 < localObject2.length - 1)
          {
            localObject2[i2] = new de();
            parama.a(localObject2[i2]);
            parama.a();
            i2 += 1;
          }
          localObject2[i2] = new de();
          parama.a(localObject2[i2]);
          this.j = ((de[])localObject2);
          break;
        }
      case 82: 
        i2 = j.a(parama, 82);
        localObject1 = this.u;
        if (localObject1 != null) {}
        for (i1 = localObject1.length;; i1 = 0)
        {
          localObject2 = new bu[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(localObject1, 0, localObject2, 0, i1);
            i2 = i1;
          }
          while (i2 < localObject2.length - 1)
          {
            localObject2[i2] = new bu();
            parama.a(localObject2[i2]);
            parama.a();
            i2 += 1;
          }
          localObject2[i2] = new bu();
          parama.a(localObject2[i2]);
          this.u = ((bu[])localObject2);
          break;
        }
      case 74: 
        if (this.d == null) {
          this.d = new dt();
        }
        parama.a(this.d);
        break;
      case 66: 
        i2 = j.a(parama, 66);
        localObject1 = this.w;
        if (localObject1 != null) {}
        for (i1 = localObject1.length;; i1 = 0)
        {
          localObject2 = new by[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(localObject1, 0, localObject2, 0, i1);
            i2 = i1;
          }
          while (i2 < localObject2.length - 1)
          {
            localObject2[i2] = new by();
            parama.a(localObject2[i2]);
            parama.a();
            i2 += 1;
          }
          localObject2[i2] = new by();
          parama.a(localObject2[i2]);
          this.w = ((by[])localObject2);
          break;
        }
      case 58: 
        this.n = parama.c();
        this.i |= 0x80;
        break;
      case 50: 
        this.l = parama.c();
        this.i |= 0x40;
        break;
      case 42: 
        this.I = parama.c();
        this.i |= 0x10;
        break;
      case 32: 
        this.i |= 0x8;
        i2 = parama.j();
        try
        {
          this.g = bn.a(parama.e());
          this.i |= 0x8;
        }
        catch (IllegalArgumentException localIllegalArgumentException2)
        {
          parama.e(i2);
          a(parama, i1);
        }
        break;
      case 24: 
        this.i |= 0x4;
        i2 = parama.j();
        try
        {
          this.r = bq.a(parama.e());
          this.i |= 0x4;
        }
        catch (IllegalArgumentException localIllegalArgumentException3)
        {
          parama.e(i2);
          a(parama, i1);
        }
        break;
      case 18: 
        this.f = parama.c();
        this.i |= 0x2;
        break;
      case 10: 
        this.s = parama.c();
        this.i |= 0x1;
      }
    }
  }
  
  public static de b(byte[] paramArrayOfByte)
  {
    return (de)g.a(new de(), paramArrayOfByte);
  }
  
  public static de[] b()
  {
    if (L == null) {}
    synchronized (f.a)
    {
      if (L == null) {
        L = new de[0];
      }
      return L;
    }
  }
  
  protected final int a()
  {
    int i4 = 0;
    int i2 = super.a();
    int i1 = i2;
    if ((this.i & 0x1) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(1, this.s);
    }
    i2 = i1;
    if ((this.i & 0x2) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(2, this.f);
    }
    i1 = i2;
    if ((this.i & 0x4) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.d(3, this.r);
    }
    i2 = i1;
    if ((this.i & 0x8) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.d(4, this.g);
    }
    i1 = i2;
    if ((this.i & 0x10) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(5, this.I);
    }
    i2 = i1;
    if ((this.i & 0x40) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(6, this.l);
    }
    i1 = i2;
    if ((this.i & 0x80) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(7, this.n);
    }
    Object localObject = this.w;
    int i3 = i1;
    if (localObject != null)
    {
      i3 = i1;
      if (localObject.length > 0)
      {
        i2 = 0;
        for (;;)
        {
          localObject = this.w;
          if (i2 >= localObject.length) {
            break;
          }
          localObject = localObject[i2];
          i3 = i1;
          if (localObject != null) {
            i3 = i1 + CodedOutputByteBufferNano.d(8, (g)localObject);
          }
          i2 += 1;
          i1 = i3;
        }
        i3 = i1;
      }
    }
    localObject = this.d;
    i2 = i3;
    if (localObject != null) {
      i2 = i3 + CodedOutputByteBufferNano.d(9, (g)localObject);
    }
    localObject = this.u;
    i1 = i2;
    if (localObject != null)
    {
      i1 = i2;
      if (localObject.length > 0)
      {
        i3 = 0;
        for (;;)
        {
          localObject = this.u;
          i1 = i2;
          if (i3 >= localObject.length) {
            break;
          }
          localObject = localObject[i3];
          i1 = i2;
          if (localObject != null) {
            i1 = i2 + CodedOutputByteBufferNano.d(10, (g)localObject);
          }
          i3 += 1;
          i2 = i1;
        }
      }
    }
    localObject = this.j;
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i3 = 0;
        for (;;)
        {
          localObject = this.j;
          i2 = i1;
          if (i3 >= localObject.length) {
            break;
          }
          localObject = localObject[i3];
          i2 = i1;
          if (localObject != null) {
            i2 = i1 + CodedOutputByteBufferNano.d(11, (g)localObject);
          }
          i3 += 1;
          i1 = i2;
        }
      }
    }
    localObject = this.k;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(12, (g)localObject);
    }
    localObject = this.o;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(13, (g)localObject);
    }
    localObject = this.a;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(14, (g)localObject);
    }
    localObject = this.b;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(15, (g)localObject);
    }
    i1 = i2;
    if ((this.i & 0x800) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(16, this.q);
    }
    i2 = i1;
    if ((this.i & 0x1000) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(17, this.E);
    }
    i1 = i2;
    if ((this.i & 0x2000) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(18, this.B);
    }
    i2 = i1;
    if ((this.i & 0x10000) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(19, this.h);
    }
    i1 = i2;
    if ((this.i & 0x20000) != 0) {
      i1 = i2 + (CodedOutputByteBufferNano.d(168) + 1);
    }
    i2 = i1;
    if ((this.i & 0x20) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(22, this.G);
    }
    i1 = i2;
    if ((this.i & 0x100) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(23, this.J);
    }
    i2 = i1;
    if ((this.i & 0x40000) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(24, this.D);
    }
    localObject = this.x;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(25, (g)localObject);
    }
    i2 = i1;
    if ((this.i & 0x80000) != 0) {
      i2 = i1 + (CodedOutputByteBufferNano.d(208) + 1);
    }
    i3 = i2;
    if ((this.i & 0x200) != 0) {
      i3 = i2 + CodedOutputByteBufferNano.b(27, this.y);
    }
    i1 = i3;
    if ((this.i & 0x100000) != 0) {
      i1 = i3 + (CodedOutputByteBufferNano.d(232) + 1);
    }
    localObject = this.H;
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i3 = 0;
        for (;;)
        {
          localObject = this.H;
          i2 = i1;
          if (i3 >= localObject.length) {
            break;
          }
          localObject = localObject[i3];
          i2 = i1;
          if (localObject != null) {
            i2 = i1 + CodedOutputByteBufferNano.d(30, (g)localObject);
          }
          i3 += 1;
          i1 = i2;
        }
      }
    }
    i1 = i2;
    if ((this.i & 0x8000) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(31, this.F);
    }
    i2 = i1;
    if ((this.i & 0x200000) != 0) {
      i2 = i1 + (CodedOutputByteBufferNano.d(256) + 1);
    }
    i1 = i2;
    if ((this.i & 0x400000) != 0) {
      i1 = i2 + (CodedOutputByteBufferNano.d(264) + 1);
    }
    i2 = i1;
    if ((this.i & 0x4000) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(34, this.z);
    }
    i1 = i2;
    if ((this.i & 0x800000) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(35, this.m);
    }
    i2 = i1;
    if ((this.i & 0x400) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(36, this.M);
    }
    i1 = i2;
    if ((this.i & 0x1000000) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.d(37, this.C);
    }
    localObject = this.c;
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i3 = i4;
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
            i2 = i1 + CodedOutputByteBufferNano.d(38, (g)localObject);
          }
          i3 += 1;
          i1 = i2;
        }
      }
    }
    i1 = i2;
    if ((this.i & 0x2000000) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(39, this.A);
    }
    return i1;
  }
  
  public final de a(int paramInt)
  {
    this.r = paramInt;
    this.i |= 0x4;
    return this;
  }
  
  public final de a(String paramString)
  {
    if (paramString != null)
    {
      this.i |= 0x1;
      this.s = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public final de a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      this.i |= 0x40000;
      this.D = paramArrayOfByte;
      return this;
    }
    throw new NullPointerException();
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i2 = 0;
    if ((this.i & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.s);
    }
    if ((this.i & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.f);
    }
    if ((this.i & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.r);
    }
    if ((this.i & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.g);
    }
    if ((this.i & 0x10) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.I);
    }
    if ((this.i & 0x40) != 0) {
      paramCodedOutputByteBufferNano.a(6, this.l);
    }
    if ((this.i & 0x80) != 0) {
      paramCodedOutputByteBufferNano.a(7, this.n);
    }
    Object localObject = this.w;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int i1;
    label729:
    do
    {
      localObject = this.d;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.b(9, (g)localObject);
      }
      localObject = this.u;
      if ((localObject == null) || (localObject.length <= 0)) {}
      do
      {
        localObject = this.j;
        if ((localObject == null) || (localObject.length <= 0)) {}
        do
        {
          localObject = this.k;
          if (localObject != null) {
            paramCodedOutputByteBufferNano.b(12, (g)localObject);
          }
          localObject = this.o;
          if (localObject != null) {
            paramCodedOutputByteBufferNano.b(13, (g)localObject);
          }
          localObject = this.a;
          if (localObject != null) {
            paramCodedOutputByteBufferNano.b(14, (g)localObject);
          }
          localObject = this.b;
          if (localObject != null) {
            paramCodedOutputByteBufferNano.b(15, (g)localObject);
          }
          if ((this.i & 0x800) != 0) {
            paramCodedOutputByteBufferNano.a(16, this.q);
          }
          if ((this.i & 0x1000) != 0) {
            paramCodedOutputByteBufferNano.a(17, this.E);
          }
          if ((this.i & 0x2000) != 0) {
            paramCodedOutputByteBufferNano.a(18, this.B);
          }
          if ((this.i & 0x10000) != 0) {
            paramCodedOutputByteBufferNano.a(19, this.h);
          }
          if ((this.i & 0x20000) != 0) {
            paramCodedOutputByteBufferNano.a(21, this.p);
          }
          if ((this.i & 0x20) != 0) {
            paramCodedOutputByteBufferNano.a(22, this.G);
          }
          if ((this.i & 0x100) != 0) {
            paramCodedOutputByteBufferNano.a(23, this.J);
          }
          if ((this.i & 0x40000) != 0) {
            paramCodedOutputByteBufferNano.a(24, this.D);
          }
          localObject = this.x;
          if (localObject != null) {
            paramCodedOutputByteBufferNano.b(25, (g)localObject);
          }
          if ((this.i & 0x80000) != 0) {
            paramCodedOutputByteBufferNano.a(26, this.v);
          }
          if ((this.i & 0x200) != 0) {
            paramCodedOutputByteBufferNano.a(27, this.y);
          }
          if ((this.i & 0x100000) != 0) {
            paramCodedOutputByteBufferNano.a(29, this.e);
          }
          localObject = this.H;
          if ((localObject == null) || (localObject.length <= 0)) {}
          do
          {
            if ((this.i & 0x8000) != 0) {
              paramCodedOutputByteBufferNano.a(31, this.F);
            }
            if ((this.i & 0x200000) != 0) {
              paramCodedOutputByteBufferNano.a(32, this.t);
            }
            if ((this.i & 0x400000) != 0) {
              paramCodedOutputByteBufferNano.a(33, this.K);
            }
            if ((this.i & 0x4000) != 0) {
              paramCodedOutputByteBufferNano.a(34, this.z);
            }
            if ((this.i & 0x800000) != 0) {
              paramCodedOutputByteBufferNano.a(35, this.m);
            }
            if ((this.i & 0x400) != 0) {
              paramCodedOutputByteBufferNano.a(36, this.M);
            }
            if ((this.i & 0x1000000) != 0) {
              paramCodedOutputByteBufferNano.a(37, this.C);
            }
            localObject = this.c;
            if (localObject != null)
            {
              i1 = i2;
              if (localObject.length > 0) {
                break label729;
              }
            }
            do
            {
              if ((this.i & 0x2000000) != 0) {
                paramCodedOutputByteBufferNano.a(39, this.A);
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
              paramCodedOutputByteBufferNano.b(38, (g)localObject);
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
            paramCodedOutputByteBufferNano.b(30, (g)localObject);
          }
          i1 = 0;
          localObject = this.j;
        } while (i1 >= localObject.length);
        localObject = localObject[i1];
        if (localObject == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          paramCodedOutputByteBufferNano.b(11, (g)localObject);
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
        paramCodedOutputByteBufferNano.b(10, (g)localObject);
      }
      i1 = 0;
      localObject = this.w;
    } while (i1 >= localObject.length);
    localObject = localObject[i1];
    if (localObject == null) {}
    for (;;)
    {
      i1 += 1;
      break;
      paramCodedOutputByteBufferNano.b(8, (g)localObject);
    }
  }
  
  public final de b(int paramInt)
  {
    this.g = paramInt;
    this.i |= 0x8;
    return this;
  }
  
  public final de b(String paramString)
  {
    if (paramString != null)
    {
      this.i |= 0x2;
      this.f = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public final de c(String paramString)
  {
    if (paramString != null)
    {
      this.i |= 0x10;
      this.I = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      int i1;
      int i2;
      Object localObject;
      if ((paramObject instanceof de))
      {
        paramObject = (de)paramObject;
        if (((this.i & 0x1) == (((de)paramObject).i & 0x1)) && (this.s.equals(((de)paramObject).s)) && ((this.i & 0x2) == (((de)paramObject).i & 0x2)) && (this.f.equals(((de)paramObject).f)))
        {
          i1 = this.i;
          i2 = ((de)paramObject).i;
          if (((i1 & 0x4) == (i2 & 0x4)) && (this.r == ((de)paramObject).r) && ((i1 & 0x8) == (i2 & 0x8)) && (this.g == ((de)paramObject).g) && ((i1 & 0x10) == (i2 & 0x10)) && (this.I.equals(((de)paramObject).I)) && ((this.i & 0x20) == (((de)paramObject).i & 0x20)) && (this.G.equals(((de)paramObject).G)) && ((this.i & 0x40) == (((de)paramObject).i & 0x40)) && (this.l.equals(((de)paramObject).l)) && ((this.i & 0x80) == (((de)paramObject).i & 0x80)) && (this.n.equals(((de)paramObject).n)) && ((this.i & 0x100) == (((de)paramObject).i & 0x100)) && (this.J.equals(((de)paramObject).J)) && ((this.i & 0x200) == (((de)paramObject).i & 0x200)) && (this.y.equals(((de)paramObject).y)) && ((this.i & 0x400) == (((de)paramObject).i & 0x400)) && (this.M.equals(((de)paramObject).M)) && (f.a(this.w, ((de)paramObject).w)))
          {
            localObject = this.d;
            if (localObject != null) {
              break label1088;
            }
            if (((de)paramObject).d != null) {}
          }
        }
      }
      label1006:
      label1074:
      label1088:
      while (((dt)localObject).equals(((de)paramObject).d))
      {
        if ((f.a(this.u, ((de)paramObject).u)) && (f.a(this.j, ((de)paramObject).j)))
        {
          localObject = this.k;
          if (localObject != null) {
            break label1074;
          }
          if (((de)paramObject).k != null) {}
        }
        while (((cm)localObject).equals(((de)paramObject).k))
        {
          localObject = this.o;
          if (localObject == null) {
            if (((de)paramObject).o != null) {}
          }
          while (((cx)localObject).equals(((de)paramObject).o))
          {
            localObject = this.x;
            if (localObject == null) {
              if (((de)paramObject).x != null) {}
            }
            while (((cz)localObject).equals(((de)paramObject).x))
            {
              localObject = this.a;
              if (localObject == null) {
                if (((de)paramObject).a != null) {}
              }
              while (((iv)localObject).equals(((de)paramObject).a))
              {
                localObject = this.b;
                if (localObject == null) {
                  if (((de)paramObject).b != null) {}
                }
                while (((k)localObject).equals(((de)paramObject).b))
                {
                  if (((this.i & 0x800) == (((de)paramObject).i & 0x800)) && (this.q.equals(((de)paramObject).q)) && ((this.i & 0x1000) == (((de)paramObject).i & 0x1000)) && (this.E.equals(((de)paramObject).E)) && ((this.i & 0x2000) == (((de)paramObject).i & 0x2000)) && (this.B.equals(((de)paramObject).B)) && ((this.i & 0x4000) == (((de)paramObject).i & 0x4000)) && (this.z.equals(((de)paramObject).z)) && ((this.i & 0x8000) == (((de)paramObject).i & 0x8000)) && (this.F.equals(((de)paramObject).F)) && ((this.i & 0x10000) == (((de)paramObject).i & 0x10000)) && (this.h.equals(((de)paramObject).h)))
                  {
                    i1 = this.i;
                    i2 = ((de)paramObject).i;
                    if (((i1 & 0x20000) == (i2 & 0x20000)) && (this.p == ((de)paramObject).p) && ((i1 & 0x40000) == (i2 & 0x40000)) && (Arrays.equals(this.D, ((de)paramObject).D)))
                    {
                      i1 = this.i;
                      i2 = ((de)paramObject).i;
                      if (((0x80000 & i1) == (0x80000 & i2)) && (this.v == ((de)paramObject).v) && ((i1 & 0x100000) == (i2 & 0x100000)) && (this.e == ((de)paramObject).e) && (f.a(this.H, ((de)paramObject).H)))
                      {
                        i1 = this.i;
                        i2 = ((de)paramObject).i;
                        if (((0x200000 & i1) == (0x200000 & i2)) && (this.t == ((de)paramObject).t) && ((0x400000 & i1) == (0x400000 & i2)) && (this.K == ((de)paramObject).K) && ((i1 & 0x800000) == (i2 & 0x800000)) && (this.m.equals(((de)paramObject).m)) && ((this.i & 0x1000000) == (((de)paramObject).i & 0x1000000)) && (this.C == ((de)paramObject).C) && (f.a(this.c, ((de)paramObject).c)) && ((this.i & 0x2000000) == (((de)paramObject).i & 0x2000000)) && (this.A.equals(((de)paramObject).A)))
                        {
                          localObject = this.unknownFieldData;
                          if ((localObject != null) && (!((d)localObject).a())) {
                            break label1006;
                          }
                          paramObject = ((de)paramObject).unknownFieldData;
                        }
                      }
                    }
                  }
                  return (paramObject == null) || (((d)paramObject).a());
                  return this.unknownFieldData.equals(((de)paramObject).unknownFieldData);
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
    int i13 = getClass().getName().hashCode();
    int i14 = this.s.hashCode();
    int i15 = this.f.hashCode();
    int i16 = this.r;
    int i17 = this.g;
    int i18 = this.I.hashCode();
    int i19 = this.G.hashCode();
    int i20 = this.l.hashCode();
    int i21 = this.n.hashCode();
    int i22 = this.J.hashCode();
    int i23 = this.y.hashCode();
    int i24 = this.M.hashCode();
    int i25 = f.a(this.w);
    Object localObject = this.d;
    if (localObject != null) {}
    for (int i2 = ((dt)localObject).hashCode();; i2 = 0)
    {
      int i26 = f.a(this.u);
      int i27 = f.a(this.j);
      localObject = this.k;
      if (localObject != null) {}
      for (int i3 = ((cm)localObject).hashCode();; i3 = 0)
      {
        localObject = this.o;
        if (localObject != null) {}
        for (int i4 = ((cx)localObject).hashCode();; i4 = 0)
        {
          localObject = this.x;
          if (localObject != null) {}
          for (int i5 = ((cz)localObject).hashCode();; i5 = 0)
          {
            localObject = this.a;
            if (localObject != null) {}
            for (int i6 = ((iv)localObject).hashCode();; i6 = 0)
            {
              localObject = this.b;
              if (localObject != null) {}
              for (int i7 = ((k)localObject).hashCode();; i7 = 0)
              {
                int i28 = this.q.hashCode();
                int i29 = this.E.hashCode();
                int i30 = this.B.hashCode();
                int i31 = this.z.hashCode();
                int i32 = this.F.hashCode();
                int i33 = this.h.hashCode();
                if (!this.p) {}
                for (int i8 = 1237;; i8 = 1231)
                {
                  int i34 = Arrays.hashCode(this.D);
                  if (!this.v) {}
                  for (int i9 = 1237;; i9 = 1231)
                  {
                    if (!this.e) {}
                    for (int i10 = 1237;; i10 = 1231)
                    {
                      int i35 = f.a(this.H);
                      if (!this.t) {}
                      for (int i11 = 1237;; i11 = 1231)
                      {
                        if (!this.K) {}
                        for (int i12 = 1237;; i12 = 1231)
                        {
                          int i36 = this.m.hashCode();
                          int i37 = this.C;
                          int i38 = f.a(this.c);
                          int i39 = this.A.hashCode();
                          localObject = this.unknownFieldData;
                          int i1;
                          if (localObject != null) {
                            if (!((d)localObject).a()) {
                              i1 = this.unknownFieldData.hashCode();
                            }
                          }
                          for (;;)
                          {
                            return i1 + (((((i12 + (i11 + ((i10 + (i9 + ((i8 + (((((((i7 + (i6 + (i5 + (i4 + (i3 + (((i2 + (((((((((((((i13 + 527) * 31 + i14) * 31 + i15) * 31 + i16) * 31 + i17) * 31 + i18) * 31 + i19) * 31 + i20) * 31 + i21) * 31 + i22) * 31 + i23) * 31 + i24) * 31 + i25) * 31) * 31 + i26) * 31 + i27) * 31) * 31) * 31) * 31) * 31) * 31 + i28) * 31 + i29) * 31 + i30) * 31 + i31) * 31 + i32) * 31 + i33) * 31) * 31 + i34) * 31) * 31) * 31 + i35) * 31) * 31) * 31 + i36) * 31 + i37) * 31 + i38) * 31 + i39) * 31;
                            i1 = 0;
                            continue;
                            i1 = 0;
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
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */