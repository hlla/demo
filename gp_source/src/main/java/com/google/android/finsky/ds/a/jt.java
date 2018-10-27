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
import com.google.protobuf.nano.g;
import com.google.protobuf.nano.j;
import com.google.wireless.android.finsky.dfe.q.ep;
import com.google.wireless.android.finsky.dfe.q.er;
import java.util.Arrays;

public final class jt
  extends b
{
  public String A = "";
  public jr B = null;
  public js C = null;
  public String D = "";
  public int E = 0;
  public String F = "";
  public byte[] G = j.b;
  public ju H = null;
  public String I = "";
  public jv J = null;
  public jw K = null;
  public jx L = null;
  public String M = "";
  private jt N = null;
  private String O = "";
  private eu P = null;
  private jp Q = null;
  private jq R = null;
  private String S = "";
  private ep T = null;
  private er U = null;
  private String V = "";
  private String W = "";
  private String X = "";
  public jg a = null;
  public jh b = null;
  public int c = 0;
  public int d = 0;
  public String e = "";
  public ji f = null;
  public jj g = null;
  public String h = "";
  public String i = "";
  public jk j = null;
  public bp k = null;
  public jl l = null;
  public String m = "";
  public jm n = null;
  public jn o = null;
  public String p = "";
  public jo q = null;
  public String r = "";
  public et s = null;
  public String t = "";
  public String u = "";
  public String v = "";
  public String w = "";
  public String x = "";
  public String y = "";
  public String z = "";
  
  public jt()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final jt b(a parama)
  {
    for (;;)
    {
      int i1 = parama.a();
      int i2;
      switch (i1)
      {
      default: 
        if (super.a(parama, i1)) {}
        break;
      case 0: 
        return this;
      case 402: 
        if (this.R == null) {
          this.R = new jq();
        }
        parama.a(this.R);
        break;
      case 394: 
        if (this.b == null) {
          this.b = new jh();
        }
        parama.a(this.b);
        break;
      case 386: 
        if (this.P == null) {
          this.P = new eu();
        }
        parama.a(this.P);
        break;
      case 378: 
        if (this.s == null) {
          this.s = new et();
        }
        parama.a(this.s);
        break;
      case 370: 
        this.S = parama.c();
        this.d |= 0x200000;
        break;
      case 362: 
        if (this.Q == null) {
          this.Q = new jp();
        }
        parama.a(this.Q);
        break;
      case 354: 
        if (this.H == null) {
          this.H = new ju();
        }
        parama.a(this.H);
        break;
      case 346: 
        this.u = parama.c();
        this.d |= 0x100000;
        break;
      case 338: 
        if (this.L == null) {
          this.L = new jx();
        }
        parama.a(this.L);
        break;
      case 330: 
        this.i = parama.c();
        this.d |= 0x80000;
        break;
      case 322: 
        if (this.g == null) {
          this.g = new jj();
        }
        parama.a(this.g);
        break;
      case 314: 
        if (this.f == null) {
          this.f = new ji();
        }
        parama.a(this.f);
        break;
      case 306: 
        if (this.B == null) {
          this.B = new jr();
        }
        parama.a(this.B);
        break;
      case 298: 
        this.I = parama.c();
        this.d |= 0x40000;
        break;
      case 290: 
        this.w = parama.c();
        this.d |= 0x20000;
        break;
      case 282: 
        this.T = ((ep)parama.a((cw)ep.a.a(bh.d, null)));
        break;
      case 274: 
        this.V = parama.c();
        this.d |= 0x800;
        break;
      case 266: 
        if (this.J == null) {
          this.J = new jv();
        }
        parama.a(this.J);
        break;
      case 258: 
        if (this.N == null) {
          this.N = new jt();
        }
        parama.a(this.N);
        break;
      case 248: 
        this.d |= 0x2000000;
        i2 = parama.j();
        try
        {
          this.E = kf.a(parama.e());
          this.d |= 0x2000000;
        }
        catch (IllegalArgumentException localIllegalArgumentException1)
        {
          parama.e(i2);
          a(parama, i1);
        }
        break;
      case 242: 
        this.z = parama.c();
        this.d |= 0x10000;
        break;
      case 234: 
        this.m = parama.c();
        this.d |= 0x8000;
        break;
      case 226: 
        if (this.K == null) {
          this.K = new jw();
        }
        parama.a(this.K);
        break;
      case 210: 
        this.U = ((er)parama.a((cw)er.a.a(bh.d, null)));
        break;
      case 202: 
        if (this.a == null) {
          this.a = new jg();
        }
        parama.a(this.a);
        break;
      case 194: 
        if (this.o == null) {
          this.o = new jn();
        }
        parama.a(this.o);
        break;
      case 186: 
        if (this.n == null) {
          this.n = new jm();
        }
        parama.a(this.n);
        break;
      case 178: 
        if (this.l == null) {
          this.l = new jl();
        }
        parama.a(this.l);
        break;
      case 170: 
        this.O = parama.c();
        this.d |= 0x4000;
        break;
      case 162: 
        this.X = parama.c();
        this.d |= 0x400;
        break;
      case 154: 
        this.W = parama.c();
        this.d |= 0x200;
        break;
      case 146: 
        this.D = parama.c();
        this.d |= 0x100;
        break;
      case 138: 
        this.x = parama.c();
        this.d |= 0x80;
        break;
      case 130: 
        this.y = parama.c();
        this.d |= 0x40;
        break;
      case 122: 
        this.t = parama.c();
        this.d |= 0x2;
        break;
      case 114: 
        this.p = parama.c();
        this.d |= 0x2000;
        break;
      case 106: 
        if (this.q == null) {
          this.q = new jo();
        }
        parama.a(this.q);
        break;
      case 98: 
        this.v = parama.c();
        this.d |= 0x20;
        break;
      case 90: 
        this.A = parama.c();
        this.d |= 0x1000000;
        break;
      case 80: 
        this.d |= 0x800000;
        i2 = parama.j();
        try
        {
          this.c = bn.a(parama.e());
          this.d |= 0x800000;
        }
        catch (IllegalArgumentException localIllegalArgumentException2)
        {
          parama.e(i2);
          a(parama, i1);
        }
        break;
      case 74: 
        this.M = parama.c();
        this.d |= 0x10;
        break;
      case 66: 
        if (this.k == null) {
          this.k = new bp();
        }
        parama.a(this.k);
        break;
      case 58: 
        this.G = parama.d();
        this.d |= 0x400000;
        break;
      case 50: 
        if (this.C == null) {
          this.C = new js();
        }
        parama.a(this.C);
        break;
      case 42: 
        this.r = parama.c();
        this.d |= 0x1000;
        break;
      case 34: 
        if (this.j == null) {
          this.j = new jk();
        }
        parama.a(this.j);
        break;
      case 26: 
        this.F = parama.c();
        this.d |= 0x8;
        break;
      case 18: 
        this.e = parama.c();
        this.d |= 0x4;
        break;
      case 10: 
        this.h = parama.c();
        this.d |= 0x1;
      }
    }
  }
  
  protected final int a()
  {
    int i2 = super.a();
    int i1 = i2;
    if ((this.d & 0x1) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(1, this.h);
    }
    i2 = i1;
    if ((this.d & 0x4) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(2, this.e);
    }
    i1 = i2;
    if ((this.d & 0x8) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(3, this.F);
    }
    Object localObject = this.j;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(4, (g)localObject);
    }
    i1 = i2;
    if ((this.d & 0x1000) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(5, this.r);
    }
    localObject = this.C;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(6, (g)localObject);
    }
    i1 = i2;
    if ((this.d & 0x400000) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(7, this.G);
    }
    localObject = this.k;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(8, (g)localObject);
    }
    i1 = i2;
    if ((this.d & 0x10) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(9, this.M);
    }
    i2 = i1;
    if ((this.d & 0x800000) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.d(10, this.c);
    }
    i1 = i2;
    if ((this.d & 0x1000000) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(11, this.A);
    }
    i2 = i1;
    if ((this.d & 0x20) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(12, this.v);
    }
    localObject = this.q;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(13, (g)localObject);
    }
    i2 = i1;
    if ((this.d & 0x2000) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(14, this.p);
    }
    i1 = i2;
    if ((this.d & 0x2) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(15, this.t);
    }
    i2 = i1;
    if ((this.d & 0x40) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(16, this.y);
    }
    i1 = i2;
    if ((this.d & 0x80) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(17, this.x);
    }
    i2 = i1;
    if ((this.d & 0x100) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(18, this.D);
    }
    i1 = i2;
    if ((this.d & 0x200) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(19, this.W);
    }
    i2 = i1;
    if ((this.d & 0x400) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(20, this.X);
    }
    i1 = i2;
    if ((this.d & 0x4000) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(21, this.O);
    }
    localObject = this.l;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(22, (g)localObject);
    }
    localObject = this.n;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(23, (g)localObject);
    }
    localObject = this.o;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(24, (g)localObject);
    }
    localObject = this.a;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(25, (g)localObject);
    }
    localObject = this.U;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputStream.c(26, (cl)localObject);
    }
    localObject = this.K;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(28, (g)localObject);
    }
    i2 = i1;
    if ((this.d & 0x8000) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(29, this.m);
    }
    i1 = i2;
    if ((this.d & 0x10000) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(30, this.z);
    }
    i2 = i1;
    if ((this.d & 0x2000000) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.d(31, this.E);
    }
    localObject = this.N;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(32, (g)localObject);
    }
    localObject = this.J;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(33, (g)localObject);
    }
    i1 = i2;
    if ((this.d & 0x800) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(34, this.V);
    }
    localObject = this.T;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputStream.c(35, (cl)localObject);
    }
    i1 = i2;
    if ((this.d & 0x20000) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(36, this.w);
    }
    i2 = i1;
    if ((this.d & 0x40000) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(37, this.I);
    }
    localObject = this.B;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(38, (g)localObject);
    }
    localObject = this.f;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(39, (g)localObject);
    }
    localObject = this.g;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(40, (g)localObject);
    }
    i2 = i1;
    if ((this.d & 0x80000) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(41, this.i);
    }
    localObject = this.L;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(42, (g)localObject);
    }
    i2 = i1;
    if ((this.d & 0x100000) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(43, this.u);
    }
    localObject = this.H;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(44, (g)localObject);
    }
    localObject = this.Q;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(45, (g)localObject);
    }
    i1 = i2;
    if ((this.d & 0x200000) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(46, this.S);
    }
    localObject = this.s;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(47, (g)localObject);
    }
    localObject = this.P;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(48, (g)localObject);
    }
    localObject = this.b;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(49, (g)localObject);
    }
    localObject = this.R;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(50, (g)localObject);
    }
    return i1;
  }
  
  public final jt a(String paramString)
  {
    if (paramString != null)
    {
      this.d |= 0x1;
      this.h = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.d & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.h);
    }
    if ((this.d & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.e);
    }
    if ((this.d & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(3, this.F);
    }
    Object localObject = this.j;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(4, (g)localObject);
    }
    if ((this.d & 0x1000) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.r);
    }
    localObject = this.C;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(6, (g)localObject);
    }
    if ((this.d & 0x400000) != 0) {
      paramCodedOutputByteBufferNano.a(7, this.G);
    }
    localObject = this.k;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(8, (g)localObject);
    }
    if ((this.d & 0x10) != 0) {
      paramCodedOutputByteBufferNano.a(9, this.M);
    }
    if ((this.d & 0x800000) != 0) {
      paramCodedOutputByteBufferNano.a(10, this.c);
    }
    if ((this.d & 0x1000000) != 0) {
      paramCodedOutputByteBufferNano.a(11, this.A);
    }
    if ((this.d & 0x20) != 0) {
      paramCodedOutputByteBufferNano.a(12, this.v);
    }
    localObject = this.q;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(13, (g)localObject);
    }
    if ((this.d & 0x2000) != 0) {
      paramCodedOutputByteBufferNano.a(14, this.p);
    }
    if ((this.d & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(15, this.t);
    }
    if ((this.d & 0x40) != 0) {
      paramCodedOutputByteBufferNano.a(16, this.y);
    }
    if ((this.d & 0x80) != 0) {
      paramCodedOutputByteBufferNano.a(17, this.x);
    }
    if ((this.d & 0x100) != 0) {
      paramCodedOutputByteBufferNano.a(18, this.D);
    }
    if ((this.d & 0x200) != 0) {
      paramCodedOutputByteBufferNano.a(19, this.W);
    }
    if ((this.d & 0x400) != 0) {
      paramCodedOutputByteBufferNano.a(20, this.X);
    }
    if ((this.d & 0x4000) != 0) {
      paramCodedOutputByteBufferNano.a(21, this.O);
    }
    localObject = this.l;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(22, (g)localObject);
    }
    localObject = this.n;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(23, (g)localObject);
    }
    localObject = this.o;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(24, (g)localObject);
    }
    localObject = this.a;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(25, (g)localObject);
    }
    localObject = this.U;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.a(26, (cl)localObject);
    }
    localObject = this.K;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(28, (g)localObject);
    }
    if ((this.d & 0x8000) != 0) {
      paramCodedOutputByteBufferNano.a(29, this.m);
    }
    if ((this.d & 0x10000) != 0) {
      paramCodedOutputByteBufferNano.a(30, this.z);
    }
    if ((this.d & 0x2000000) != 0) {
      paramCodedOutputByteBufferNano.a(31, this.E);
    }
    localObject = this.N;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(32, (g)localObject);
    }
    localObject = this.J;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(33, (g)localObject);
    }
    if ((this.d & 0x800) != 0) {
      paramCodedOutputByteBufferNano.a(34, this.V);
    }
    localObject = this.T;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.a(35, (cl)localObject);
    }
    if ((this.d & 0x20000) != 0) {
      paramCodedOutputByteBufferNano.a(36, this.w);
    }
    if ((this.d & 0x40000) != 0) {
      paramCodedOutputByteBufferNano.a(37, this.I);
    }
    localObject = this.B;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(38, (g)localObject);
    }
    localObject = this.f;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(39, (g)localObject);
    }
    localObject = this.g;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(40, (g)localObject);
    }
    if ((this.d & 0x80000) != 0) {
      paramCodedOutputByteBufferNano.a(41, this.i);
    }
    localObject = this.L;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(42, (g)localObject);
    }
    if ((this.d & 0x100000) != 0) {
      paramCodedOutputByteBufferNano.a(43, this.u);
    }
    localObject = this.H;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(44, (g)localObject);
    }
    localObject = this.Q;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(45, (g)localObject);
    }
    if ((this.d & 0x200000) != 0) {
      paramCodedOutputByteBufferNano.a(46, this.S);
    }
    localObject = this.s;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(47, (g)localObject);
    }
    localObject = this.P;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(48, (g)localObject);
    }
    localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(49, (g)localObject);
    }
    localObject = this.R;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(50, (g)localObject);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean b()
  {
    return (this.d & 0x20000) != 0;
  }
  
  public final boolean c()
  {
    return (this.d & 0x1000000) != 0;
  }
  
  public final boolean d()
  {
    return (this.d & 0x2000000) != 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof jt))
      {
        paramObject = (jt)paramObject;
        if (((this.d & 0x1) == (((jt)paramObject).d & 0x1)) && (this.h.equals(((jt)paramObject).h)) && ((this.d & 0x2) == (((jt)paramObject).d & 0x2)) && (this.t.equals(((jt)paramObject).t)) && ((this.d & 0x4) == (((jt)paramObject).d & 0x4)) && (this.e.equals(((jt)paramObject).e)) && ((this.d & 0x8) == (((jt)paramObject).d & 0x8)) && (this.F.equals(((jt)paramObject).F)) && ((this.d & 0x10) == (((jt)paramObject).d & 0x10)) && (this.M.equals(((jt)paramObject).M)) && ((this.d & 0x20) == (((jt)paramObject).d & 0x20)) && (this.v.equals(((jt)paramObject).v)) && ((this.d & 0x40) == (((jt)paramObject).d & 0x40)) && (this.y.equals(((jt)paramObject).y)) && ((this.d & 0x80) == (((jt)paramObject).d & 0x80)) && (this.x.equals(((jt)paramObject).x)) && ((this.d & 0x100) == (((jt)paramObject).d & 0x100)) && (this.D.equals(((jt)paramObject).D)) && ((this.d & 0x200) == (((jt)paramObject).d & 0x200)) && (this.W.equals(((jt)paramObject).W)) && ((this.d & 0x400) == (((jt)paramObject).d & 0x400)) && (this.X.equals(((jt)paramObject).X)) && ((this.d & 0x800) == (((jt)paramObject).d & 0x800)) && (this.V.equals(((jt)paramObject).V)))
        {
          localObject = this.j;
          if (localObject != null) {
            break label1610;
          }
          if (((jt)paramObject).j != null) {}
        }
      }
      label1290:
      label1358:
      label1386:
      label1400:
      label1442:
      label1484:
      label1554:
      label1568:
      label1582:
      label1610:
      while (((jk)localObject).equals(((jt)paramObject).j))
      {
        localObject = this.a;
        if (localObject == null) {
          if (((jt)paramObject).a != null) {}
        }
        while (((jg)localObject).equals(((jt)paramObject).a))
        {
          if (((this.d & 0x1000) == (((jt)paramObject).d & 0x1000)) && (this.r.equals(((jt)paramObject).r)))
          {
            localObject = this.C;
            if (localObject != null) {
              break label1582;
            }
            if (((jt)paramObject).C != null) {}
          }
          while (((js)localObject).equals(((jt)paramObject).C))
          {
            if (((this.d & 0x2000) == (((jt)paramObject).d & 0x2000)) && (this.p.equals(((jt)paramObject).p)))
            {
              localObject = this.q;
              if (localObject != null) {
                break label1568;
              }
              if (((jt)paramObject).q != null) {}
            }
            while (((jo)localObject).equals(((jt)paramObject).q))
            {
              if (((this.d & 0x4000) == (((jt)paramObject).d & 0x4000)) && (this.O.equals(((jt)paramObject).O)))
              {
                localObject = this.l;
                if (localObject != null) {
                  break label1554;
                }
                if (((jt)paramObject).l != null) {}
              }
              while (((jl)localObject).equals(((jt)paramObject).l))
              {
                localObject = this.n;
                if (localObject == null) {
                  if (((jt)paramObject).n != null) {}
                }
                while (((jm)localObject).equals(((jt)paramObject).n))
                {
                  localObject = this.o;
                  if (localObject == null) {
                    if (((jt)paramObject).o != null) {}
                  }
                  while (((jn)localObject).equals(((jt)paramObject).o))
                  {
                    localObject = this.U;
                    if (localObject == null) {
                      if (((jt)paramObject).U != null) {}
                    }
                    while (((bb)localObject).equals(((jt)paramObject).U))
                    {
                      localObject = this.K;
                      if (localObject == null) {
                        if (((jt)paramObject).K != null) {}
                      }
                      while (((jw)localObject).equals(((jt)paramObject).K))
                      {
                        if (((this.d & 0x8000) == (((jt)paramObject).d & 0x8000)) && (this.m.equals(((jt)paramObject).m)) && ((this.d & 0x10000) == (((jt)paramObject).d & 0x10000)) && (this.z.equals(((jt)paramObject).z)))
                        {
                          localObject = this.N;
                          if (localObject != null) {
                            break label1484;
                          }
                          if (((jt)paramObject).N != null) {}
                        }
                        while (((jt)localObject).equals(((jt)paramObject).N))
                        {
                          localObject = this.J;
                          if (localObject == null) {
                            if (((jt)paramObject).J != null) {}
                          }
                          while (((jv)localObject).equals(((jt)paramObject).J))
                          {
                            localObject = this.T;
                            if (localObject == null) {
                              if (((jt)paramObject).T != null) {}
                            }
                            while (((bb)localObject).equals(((jt)paramObject).T))
                            {
                              if (((this.d & 0x20000) == (((jt)paramObject).d & 0x20000)) && (this.w.equals(((jt)paramObject).w)) && ((this.d & 0x40000) == (((jt)paramObject).d & 0x40000)) && (this.I.equals(((jt)paramObject).I)))
                              {
                                localObject = this.B;
                                if (localObject != null) {
                                  break label1442;
                                }
                                if (((jt)paramObject).B != null) {}
                              }
                              while (((jr)localObject).equals(((jt)paramObject).B))
                              {
                                localObject = this.f;
                                if (localObject == null) {
                                  if (((jt)paramObject).f != null) {}
                                }
                                while (((ji)localObject).equals(((jt)paramObject).f))
                                {
                                  localObject = this.g;
                                  if (localObject == null) {
                                    if (((jt)paramObject).g != null) {}
                                  }
                                  while (((jj)localObject).equals(((jt)paramObject).g))
                                  {
                                    if (((this.d & 0x80000) == (((jt)paramObject).d & 0x80000)) && (this.i.equals(((jt)paramObject).i)))
                                    {
                                      localObject = this.L;
                                      if (localObject != null) {
                                        break label1400;
                                      }
                                      if (((jt)paramObject).L != null) {}
                                    }
                                    while (((jx)localObject).equals(((jt)paramObject).L))
                                    {
                                      if (((this.d & 0x100000) == (((jt)paramObject).d & 0x100000)) && (this.u.equals(((jt)paramObject).u)))
                                      {
                                        localObject = this.H;
                                        if (localObject != null) {
                                          break label1386;
                                        }
                                        if (((jt)paramObject).H != null) {}
                                      }
                                      while (((ju)localObject).equals(((jt)paramObject).H))
                                      {
                                        localObject = this.Q;
                                        if (localObject == null) {
                                          if (((jt)paramObject).Q != null) {}
                                        }
                                        while (((jp)localObject).equals(((jt)paramObject).Q))
                                        {
                                          if (((this.d & 0x200000) == (((jt)paramObject).d & 0x200000)) && (this.S.equals(((jt)paramObject).S)))
                                          {
                                            localObject = this.s;
                                            if (localObject != null) {
                                              break label1358;
                                            }
                                            if (((jt)paramObject).s != null) {}
                                          }
                                          while (((et)localObject).equals(((jt)paramObject).s))
                                          {
                                            localObject = this.P;
                                            if (localObject == null) {
                                              if (((jt)paramObject).P != null) {}
                                            }
                                            while (((eu)localObject).equals(((jt)paramObject).P))
                                            {
                                              localObject = this.b;
                                              if (localObject == null) {
                                                if (((jt)paramObject).b != null) {}
                                              }
                                              while (((jh)localObject).equals(((jt)paramObject).b))
                                              {
                                                localObject = this.R;
                                                if (localObject == null) {
                                                  if (((jt)paramObject).R != null) {}
                                                }
                                                while (((jq)localObject).equals(((jt)paramObject).R))
                                                {
                                                  localObject = this.k;
                                                  if (localObject == null) {
                                                    if (((jt)paramObject).k != null) {}
                                                  }
                                                  while (((bp)localObject).equals(((jt)paramObject).k))
                                                  {
                                                    if (((this.d & 0x400000) == (((jt)paramObject).d & 0x400000)) && (Arrays.equals(this.G, ((jt)paramObject).G)))
                                                    {
                                                      int i1 = this.d;
                                                      int i2 = ((jt)paramObject).d;
                                                      if (((0x800000 & i1) == (0x800000 & i2)) && (this.c == ((jt)paramObject).c) && ((i1 & 0x1000000) == (i2 & 0x1000000)) && (this.A.equals(((jt)paramObject).A)) && ((this.d & 0x2000000) == (((jt)paramObject).d & 0x2000000)) && (this.E == ((jt)paramObject).E))
                                                      {
                                                        localObject = this.unknownFieldData;
                                                        if ((localObject != null) && (!((d)localObject).a())) {
                                                          break label1290;
                                                        }
                                                        paramObject = ((jt)paramObject).unknownFieldData;
                                                      }
                                                    }
                                                    return (paramObject == null) || (((d)paramObject).a());
                                                    return this.unknownFieldData.equals(((jt)paramObject).unknownFieldData);
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
        return false;
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int i25 = 0;
    int i26 = getClass().getName().hashCode();
    int i27 = this.h.hashCode();
    int i28 = this.t.hashCode();
    int i29 = this.e.hashCode();
    int i30 = this.F.hashCode();
    int i31 = this.M.hashCode();
    int i32 = this.v.hashCode();
    int i33 = this.y.hashCode();
    int i34 = this.x.hashCode();
    int i35 = this.D.hashCode();
    int i36 = this.W.hashCode();
    int i37 = this.X.hashCode();
    int i38 = this.V.hashCode();
    Object localObject = this.j;
    if (localObject != null) {}
    for (int i1 = ((jk)localObject).hashCode();; i1 = 0)
    {
      localObject = this.a;
      if (localObject != null) {}
      for (int i2 = ((jg)localObject).hashCode();; i2 = 0)
      {
        int i39 = this.r.hashCode();
        localObject = this.C;
        if (localObject != null) {}
        for (int i3 = ((js)localObject).hashCode();; i3 = 0)
        {
          int i40 = this.p.hashCode();
          localObject = this.q;
          if (localObject != null) {}
          for (int i4 = ((jo)localObject).hashCode();; i4 = 0)
          {
            int i41 = this.O.hashCode();
            localObject = this.l;
            if (localObject != null) {}
            for (int i5 = ((jl)localObject).hashCode();; i5 = 0)
            {
              localObject = this.n;
              if (localObject != null) {}
              for (int i6 = ((jm)localObject).hashCode();; i6 = 0)
              {
                localObject = this.o;
                if (localObject != null) {}
                for (int i7 = ((jn)localObject).hashCode();; i7 = 0)
                {
                  localObject = this.U;
                  if (localObject != null) {}
                  for (int i8 = ((bb)localObject).hashCode();; i8 = 0)
                  {
                    localObject = this.K;
                    if (localObject != null) {}
                    for (int i9 = ((jw)localObject).hashCode();; i9 = 0)
                    {
                      int i42 = this.m.hashCode();
                      int i43 = this.z.hashCode();
                      localObject = this.N;
                      if (localObject != null) {}
                      for (int i10 = ((jt)localObject).hashCode();; i10 = 0)
                      {
                        localObject = this.J;
                        if (localObject != null) {}
                        for (int i11 = ((jv)localObject).hashCode();; i11 = 0)
                        {
                          localObject = this.T;
                          if (localObject != null) {}
                          for (int i12 = ((bb)localObject).hashCode();; i12 = 0)
                          {
                            int i44 = this.w.hashCode();
                            int i45 = this.I.hashCode();
                            localObject = this.B;
                            if (localObject != null) {}
                            for (int i13 = ((jr)localObject).hashCode();; i13 = 0)
                            {
                              localObject = this.f;
                              if (localObject != null) {}
                              for (int i14 = ((ji)localObject).hashCode();; i14 = 0)
                              {
                                localObject = this.g;
                                if (localObject != null) {}
                                for (int i15 = ((jj)localObject).hashCode();; i15 = 0)
                                {
                                  int i46 = this.i.hashCode();
                                  localObject = this.L;
                                  if (localObject != null) {}
                                  for (int i16 = ((jx)localObject).hashCode();; i16 = 0)
                                  {
                                    int i47 = this.u.hashCode();
                                    localObject = this.H;
                                    if (localObject != null) {}
                                    for (int i17 = ((ju)localObject).hashCode();; i17 = 0)
                                    {
                                      localObject = this.Q;
                                      if (localObject != null) {}
                                      for (int i18 = ((jp)localObject).hashCode();; i18 = 0)
                                      {
                                        int i48 = this.S.hashCode();
                                        localObject = this.s;
                                        if (localObject != null) {}
                                        for (int i19 = ((et)localObject).hashCode();; i19 = 0)
                                        {
                                          localObject = this.P;
                                          if (localObject != null) {}
                                          for (int i20 = ((eu)localObject).hashCode();; i20 = 0)
                                          {
                                            localObject = this.b;
                                            if (localObject != null) {}
                                            for (int i21 = ((jh)localObject).hashCode();; i21 = 0)
                                            {
                                              localObject = this.R;
                                              if (localObject != null) {}
                                              for (int i22 = ((jq)localObject).hashCode();; i22 = 0)
                                              {
                                                localObject = this.k;
                                                if (localObject != null) {}
                                                for (int i23 = ((bp)localObject).hashCode();; i23 = 0)
                                                {
                                                  int i49 = Arrays.hashCode(this.G);
                                                  int i50 = this.c;
                                                  int i51 = this.A.hashCode();
                                                  int i52 = this.E;
                                                  localObject = this.unknownFieldData;
                                                  int i24 = i25;
                                                  if (localObject != null)
                                                  {
                                                    i24 = i25;
                                                    if (!((d)localObject).a()) {
                                                      i24 = this.unknownFieldData.hashCode();
                                                    }
                                                  }
                                                  return (((((i23 + (i22 + (i21 + (i20 + (i19 + ((i18 + (i17 + ((i16 + ((i15 + (i14 + (i13 + (((i12 + (i11 + (i10 + (((i9 + (i8 + (i7 + (i6 + (i5 + ((i4 + ((i3 + ((i2 + (i1 + (((((((((((((i26 + 527) * 31 + i27) * 31 + i28) * 31 + i29) * 31 + i30) * 31 + i31) * 31 + i32) * 31 + i33) * 31 + i34) * 31 + i35) * 31 + i36) * 31 + i37) * 31 + i38) * 31) * 31) * 31 + i39) * 31) * 31 + i40) * 31) * 31 + i41) * 31) * 31) * 31) * 31) * 31) * 31 + i42) * 31 + i43) * 31) * 31) * 31) * 31 + i44) * 31 + i45) * 31) * 31) * 31) * 31 + i46) * 31) * 31 + i47) * 31) * 31) * 31 + i48) * 31) * 31) * 31) * 31) * 31) * 31 + i49) * 31 + i50) * 31 + i51) * 31 + i52) * 31 + i24;
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/jt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */