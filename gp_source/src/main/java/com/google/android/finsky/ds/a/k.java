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
import com.google.protobuf.nano.j;
import com.google.wireless.android.finsky.dfe.q.be;
import com.google.wireless.android.finsky.dfe.q.cy;
import com.google.wireless.android.finsky.dfe.q.p;

public final class k
  extends b
{
  public fj A = null;
  public fg B = null;
  public String C = "";
  public String D = "";
  public gj E = null;
  public gx F = null;
  public gy G = null;
  public String H = "";
  public nk I = null;
  public ho[] J = ho.b();
  public ex K = null;
  public String L = "";
  public String M = "";
  public is N = null;
  public iy O = null;
  public ke P = null;
  public kl Q = null;
  public kl R = null;
  public kl S = null;
  public kq T = null;
  public boolean U = false;
  public la V = null;
  public de[] W = de.b();
  public lt X = null;
  public lz Y = null;
  public mc Z = null;
  public String a = "";
  public mi aa = null;
  public mz ab = null;
  public ng[] ac = ng.b();
  public nk[] ad = nk.b();
  private p ae = null;
  private am[] af = am.b();
  private String ag = "";
  private be ah = null;
  private eo ai = null;
  private fq aj = null;
  private fx ak = null;
  private gz al = null;
  private cy am = null;
  private String an = "";
  private hy ao = null;
  private ib ap = null;
  private ij[] aq = ij.b();
  public w b = null;
  public aa c = null;
  public String d = "";
  public am[] e = am.b();
  public am f = null;
  public am[] g = am.b();
  public int h = 0;
  public ay i = null;
  public ck j = null;
  public de k = null;
  public cp[] l = cp.b();
  public kl[] m = kl.b();
  public cs[] n = cs.b();
  public String o = "";
  public int p = 1;
  public an[] q = an.b();
  public dh r = null;
  public dk s = null;
  public fb t = null;
  public dp u = null;
  public am[] v = am.b();
  public dy w = null;
  public eb x = null;
  public ez y = null;
  public fb z = null;
  
  public k()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final k b(a parama)
  {
    for (;;)
    {
      int i1 = parama.a();
      int i2;
      Object localObject1;
      Object localObject3;
      Object localObject2;
      switch (i1)
      {
      default: 
        if (super.a(parama, i1)) {}
        break;
      case 0: 
        return this;
      case 656: 
        this.U = parama.b();
        this.h |= 0x800;
        break;
      case 650: 
        if (this.c == null) {
          this.c = new aa();
        }
        parama.a(this.c);
        break;
      case 642: 
        this.C = parama.c();
        this.h |= 0x400;
        break;
      case 634: 
        if (this.A == null) {
          this.A = new fj();
        }
        parama.a(this.A);
        break;
      case 626: 
        if (this.aj == null) {
          this.aj = new fq();
        }
        parama.a(this.aj);
        break;
      case 618: 
        if (this.y == null) {
          this.y = new ez();
        }
        parama.a(this.y);
        break;
      case 610: 
        if (this.u == null) {
          this.u = new dp();
        }
        parama.a(this.u);
        break;
      case 602: 
        if (this.t == null) {
          this.t = new fb();
        }
        parama.a(this.t);
        break;
      case 594: 
        if (this.ap == null) {
          this.ap = new ib();
        }
        parama.a(this.ap);
        break;
      case 586: 
        if (this.ak == null) {
          this.ak = new fx();
        }
        parama.a(this.ak);
        break;
      case 578: 
        i2 = j.a(parama, 578);
        localObject1 = this.l;
        if (localObject1 != null) {}
        for (i1 = localObject1.length;; i1 = 0)
        {
          localObject3 = new cp[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(localObject1, 0, localObject3, 0, i1);
            i2 = i1;
          }
          while (i2 < localObject3.length - 1)
          {
            localObject3[i2] = new cp();
            parama.a(localObject3[i2]);
            parama.a();
            i2 += 1;
          }
          localObject3[i2] = new cp();
          parama.a(localObject3[i2]);
          this.l = ((cp[])localObject3);
          break;
        }
      case 570: 
        i2 = j.a(parama, 570);
        localObject1 = this.n;
        if (localObject1 != null) {}
        for (i1 = localObject1.length;; i1 = 0)
        {
          localObject3 = new cs[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(localObject1, 0, localObject3, 0, i1);
            i2 = i1;
          }
          while (i2 < localObject3.length - 1)
          {
            localObject3[i2] = new cs();
            parama.a(localObject3[i2]);
            parama.a();
            i2 += 1;
          }
          localObject3[i2] = new cs();
          parama.a(localObject3[i2]);
          this.n = ((cs[])localObject3);
          break;
        }
      case 562: 
        if (this.j == null) {
          this.j = new ck();
        }
        parama.a(this.j);
        break;
      case 546: 
        if (this.w == null) {
          this.w = new dy();
        }
        parama.a(this.w);
        break;
      case 538: 
        if (this.O == null) {
          this.O = new iy();
        }
        parama.a(this.O);
        break;
      case 530: 
        this.D = parama.c();
        this.h |= 0x80;
        break;
      case 522: 
        if (this.aa == null) {
          this.aa = new mi();
        }
        parama.a(this.aa);
        break;
      case 514: 
        if (this.K == null) {
          this.K = new ex();
        }
        parama.a(this.K);
        break;
      case 506: 
        if (this.P == null) {
          this.P = new ke();
        }
        parama.a(this.P);
        break;
      case 498: 
        if (this.s == null) {
          this.s = new dk();
        }
        parama.a(this.s);
        break;
      case 490: 
        if (this.B == null) {
          this.B = new fg();
        }
        parama.a(this.B);
        break;
      case 482: 
        if (this.r == null) {
          this.r = new dh();
        }
        parama.a(this.r);
        break;
      case 474: 
        this.o = parama.c();
        this.h |= 0x20;
        break;
      case 458: 
        this.M = parama.c();
        this.h |= 0x40;
        break;
      case 450: 
        if (this.Y == null) {
          this.Y = new lz();
        }
        parama.a(this.Y);
        break;
      case 442: 
        if (this.ai == null) {
          this.ai = new eo();
        }
        parama.a(this.ai);
        break;
      case 434: 
        i2 = j.a(parama, 434);
        localObject1 = this.e;
        if (localObject1 != null) {}
        for (i1 = localObject1.length;; i1 = 0)
        {
          localObject3 = new am[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(localObject1, 0, localObject3, 0, i1);
            i2 = i1;
          }
          while (i2 < localObject3.length - 1)
          {
            localObject3[i2] = new am();
            parama.a(localObject3[i2]);
            parama.a();
            i2 += 1;
          }
          localObject3[i2] = new am();
          parama.a(localObject3[i2]);
          this.e = ((am[])localObject3);
          break;
        }
      case 426: 
        if (this.x == null) {
          this.x = new eb();
        }
        parama.a(this.x);
        break;
      case 418: 
        this.am = ((cy)parama.a((cw)cy.a.a(bh.d, null)));
        break;
      case 410: 
        this.ah = ((be)parama.a((cw)be.a.a(bh.d, null)));
        break;
      case 402: 
        this.ae = ((p)parama.a((cw)p.a.a(bh.d, null)));
        break;
      case 394: 
        this.an = parama.c();
        this.h |= 0x200;
        break;
      case 386: 
        if (this.b == null) {
          this.b = new w();
        }
        parama.a(this.b);
        break;
      case 378: 
        if (this.i == null) {
          this.i = new ay();
        }
        parama.a(this.i);
        break;
      case 370: 
        if (this.E == null) {
          this.E = new gj();
        }
        parama.a(this.E);
        break;
      case 362: 
        this.ag = parama.c();
        this.h |= 0x100;
        break;
      case 352: 
        this.h |= 0x10;
        i2 = parama.j();
        try
        {
          this.p = cb.a(parama.e());
          this.h |= 0x10;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          parama.e(i2);
          a(parama, i1);
        }
        break;
      case 346: 
        if (this.F == null) {
          this.F = new gx();
        }
        parama.a(this.F);
        break;
      case 338: 
        if (this.V == null) {
          this.V = new la();
        }
        parama.a(this.V);
        break;
      case 322: 
        if (this.T == null) {
          this.T = new kq();
        }
        parama.a(this.T);
        break;
      case 314: 
        i2 = j.a(parama, 314);
        localObject2 = this.v;
        if (localObject2 != null) {}
        for (i1 = localObject2.length;; i1 = 0)
        {
          localObject3 = new am[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(localObject2, 0, localObject3, 0, i1);
            i2 = i1;
          }
          while (i2 < localObject3.length - 1)
          {
            localObject3[i2] = new am();
            parama.a(localObject3[i2]);
            parama.a();
            i2 += 1;
          }
          localObject3[i2] = new am();
          parama.a(localObject3[i2]);
          this.v = ((am[])localObject3);
          break;
        }
      case 306: 
        if (this.G == null) {
          this.G = new gy();
        }
        parama.a(this.G);
        break;
      case 298: 
        if (this.al == null) {
          this.al = new gz();
        }
        parama.a(this.al);
        break;
      case 282: 
        if (this.ab == null) {
          this.ab = new mz();
        }
        parama.a(this.ab);
        break;
      case 274: 
        i2 = j.a(parama, 274);
        localObject2 = this.m;
        if (localObject2 != null) {}
        for (i1 = localObject2.length;; i1 = 0)
        {
          localObject3 = new kl[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(localObject2, 0, localObject3, 0, i1);
            i2 = i1;
          }
          while (i2 < localObject3.length - 1)
          {
            localObject3[i2] = new kl();
            parama.a(localObject3[i2]);
            parama.a();
            i2 += 1;
          }
          localObject3[i2] = new kl();
          parama.a(localObject3[i2]);
          this.m = ((kl[])localObject3);
          break;
        }
      case 266: 
        this.a = parama.c();
        this.h |= 0x8;
        break;
      case 242: 
        i2 = j.a(parama, 242);
        localObject2 = this.ac;
        if (localObject2 != null) {}
        for (i1 = localObject2.length;; i1 = 0)
        {
          localObject3 = new ng[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(localObject2, 0, localObject3, 0, i1);
            i2 = i1;
          }
          while (i2 < localObject3.length - 1)
          {
            localObject3[i2] = new ng();
            parama.a(localObject3[i2]);
            parama.a();
            i2 += 1;
          }
          localObject3[i2] = new ng();
          parama.a(localObject3[i2]);
          this.ac = ((ng[])localObject3);
          break;
        }
      case 234: 
        if (this.f == null) {
          this.f = new am();
        }
        parama.a(this.f);
        break;
      case 226: 
        if (this.N == null) {
          this.N = new is();
        }
        parama.a(this.N);
        break;
      case 218: 
        this.d = parama.c();
        this.h |= 0x4;
        break;
      case 210: 
        if (this.k == null) {
          this.k = new de();
        }
        parama.a(this.k);
        break;
      case 202: 
        i2 = j.a(parama, 202);
        localObject2 = this.J;
        if (localObject2 != null) {}
        for (i1 = localObject2.length;; i1 = 0)
        {
          localObject3 = new ho[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(localObject2, 0, localObject3, 0, i1);
            i2 = i1;
          }
          while (i2 < localObject3.length - 1)
          {
            localObject3[i2] = new ho();
            parama.a(localObject3[i2]);
            parama.a();
            i2 += 1;
          }
          localObject3[i2] = new ho();
          parama.a(localObject3[i2]);
          this.J = ((ho[])localObject3);
          break;
        }
      case 194: 
        if (this.R == null) {
          this.R = new kl();
        }
        parama.a(this.R);
        break;
      case 178: 
        if (this.S == null) {
          this.S = new kl();
        }
        parama.a(this.S);
        break;
      case 170: 
        i2 = j.a(parama, 170);
        localObject2 = this.q;
        if (localObject2 != null) {}
        for (i1 = localObject2.length;; i1 = 0)
        {
          localObject3 = new an[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(localObject2, 0, localObject3, 0, i1);
            i2 = i1;
          }
          while (i2 < localObject3.length - 1)
          {
            localObject3[i2] = new an();
            parama.a(localObject3[i2]);
            parama.a();
            i2 += 1;
          }
          localObject3[i2] = new an();
          parama.a(localObject3[i2]);
          this.q = ((an[])localObject3);
          break;
        }
      case 162: 
        if (this.I == null) {
          this.I = new nk();
        }
        parama.a(this.I);
        break;
      case 154: 
        if (this.X == null) {
          this.X = new lt();
        }
        parama.a(this.X);
        break;
      case 146: 
        this.L = parama.c();
        this.h |= 0x2;
        break;
      case 130: 
        i2 = j.a(parama, 130);
        localObject2 = this.W;
        if (localObject2 != null) {}
        for (i1 = localObject2.length;; i1 = 0)
        {
          localObject3 = new de[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(localObject2, 0, localObject3, 0, i1);
            i2 = i1;
          }
          while (i2 < localObject3.length - 1)
          {
            localObject3[i2] = new de();
            parama.a(localObject3[i2]);
            parama.a();
            i2 += 1;
          }
          localObject3[i2] = new de();
          parama.a(localObject3[i2]);
          this.W = ((de[])localObject3);
          break;
        }
      case 114: 
        this.H = parama.c();
        this.h |= 0x1;
        break;
      case 106: 
        i2 = j.a(parama, 106);
        localObject2 = this.aq;
        if (localObject2 != null) {}
        for (i1 = localObject2.length;; i1 = 0)
        {
          localObject3 = new ij[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(localObject2, 0, localObject3, 0, i1);
            i2 = i1;
          }
          while (i2 < localObject3.length - 1)
          {
            localObject3[i2] = new ij();
            parama.a(localObject3[i2]);
            parama.a();
            i2 += 1;
          }
          localObject3[i2] = new ij();
          parama.a(localObject3[i2]);
          this.aq = ((ij[])localObject3);
          break;
        }
      case 82: 
        if (this.z == null) {
          this.z = new fb();
        }
        parama.a(this.z);
        break;
      case 74: 
        i2 = j.a(parama, 74);
        localObject2 = this.g;
        if (localObject2 != null) {}
        for (i1 = localObject2.length;; i1 = 0)
        {
          localObject3 = new am[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(localObject2, 0, localObject3, 0, i1);
            i2 = i1;
          }
          while (i2 < localObject3.length - 1)
          {
            localObject3[i2] = new am();
            parama.a(localObject3[i2]);
            parama.a();
            i2 += 1;
          }
          localObject3[i2] = new am();
          parama.a(localObject3[i2]);
          this.g = ((am[])localObject3);
          break;
        }
      case 66: 
        i2 = j.a(parama, 66);
        localObject2 = this.af;
        if (localObject2 != null) {}
        for (i1 = localObject2.length;; i1 = 0)
        {
          localObject3 = new am[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(localObject2, 0, localObject3, 0, i1);
            i2 = i1;
          }
          while (i2 < localObject3.length - 1)
          {
            localObject3[i2] = new am();
            parama.a(localObject3[i2]);
            parama.a();
            i2 += 1;
          }
          localObject3[i2] = new am();
          parama.a(localObject3[i2]);
          this.af = ((am[])localObject3);
          break;
        }
      case 58: 
        if (this.Z == null) {
          this.Z = new mc();
        }
        parama.a(this.Z);
        break;
      case 50: 
        if (this.Q == null) {
          this.Q = new kl();
        }
        parama.a(this.Q);
        break;
      case 34: 
        i2 = j.a(parama, 34);
        localObject2 = this.ad;
        if (localObject2 != null) {}
        for (i1 = localObject2.length;; i1 = 0)
        {
          localObject3 = new nk[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(localObject2, 0, localObject3, 0, i1);
            i2 = i1;
          }
          while (i2 < localObject3.length - 1)
          {
            localObject3[i2] = new nk();
            parama.a(localObject3[i2]);
            parama.a();
            i2 += 1;
          }
          localObject3[i2] = new nk();
          parama.a(localObject3[i2]);
          this.ad = ((nk[])localObject3);
          break;
        }
      case 26: 
        if (this.ao == null) {
          this.ao = new hy();
        }
        parama.a(this.ao);
      }
    }
  }
  
  protected final int a()
  {
    int i4 = 0;
    int i2 = super.a();
    Object localObject = this.ao;
    int i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(3, (g)localObject);
    }
    localObject = this.ad;
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i2 = 0;
        for (;;)
        {
          localObject = this.ad;
          if (i2 >= localObject.length) {
            break;
          }
          localObject = localObject[i2];
          i3 = i1;
          if (localObject != null) {
            i3 = i1 + CodedOutputByteBufferNano.d(4, (g)localObject);
          }
          i2 += 1;
          i1 = i3;
        }
        i2 = i1;
      }
    }
    localObject = this.Q;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(6, (g)localObject);
    }
    localObject = this.Z;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(7, (g)localObject);
    }
    localObject = this.af;
    i1 = i2;
    if (localObject != null)
    {
      i1 = i2;
      if (localObject.length > 0)
      {
        i3 = 0;
        for (;;)
        {
          localObject = this.af;
          i1 = i2;
          if (i3 >= localObject.length) {
            break;
          }
          localObject = localObject[i3];
          i1 = i2;
          if (localObject != null) {
            i1 = i2 + CodedOutputByteBufferNano.d(8, (g)localObject);
          }
          i3 += 1;
          i2 = i1;
        }
      }
    }
    localObject = this.g;
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i3 = 0;
        for (;;)
        {
          localObject = this.g;
          i2 = i1;
          if (i3 >= localObject.length) {
            break;
          }
          localObject = localObject[i3];
          i2 = i1;
          if (localObject != null) {
            i2 = i1 + CodedOutputByteBufferNano.d(9, (g)localObject);
          }
          i3 += 1;
          i1 = i2;
        }
      }
    }
    localObject = this.z;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(10, (g)localObject);
    }
    localObject = this.aq;
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i3 = 0;
        for (;;)
        {
          localObject = this.aq;
          i2 = i1;
          if (i3 >= localObject.length) {
            break;
          }
          localObject = localObject[i3];
          i2 = i1;
          if (localObject != null) {
            i2 = i1 + CodedOutputByteBufferNano.d(13, (g)localObject);
          }
          i3 += 1;
          i1 = i2;
        }
      }
    }
    i1 = i2;
    if ((this.h & 0x1) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(14, this.H);
    }
    localObject = this.W;
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i3 = 0;
        for (;;)
        {
          localObject = this.W;
          i2 = i1;
          if (i3 >= localObject.length) {
            break;
          }
          localObject = localObject[i3];
          i2 = i1;
          if (localObject != null) {
            i2 = i1 + CodedOutputByteBufferNano.d(16, (g)localObject);
          }
          i3 += 1;
          i1 = i2;
        }
      }
    }
    i1 = i2;
    if ((this.h & 0x2) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(18, this.L);
    }
    localObject = this.X;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(19, (g)localObject);
    }
    localObject = this.I;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(20, (g)localObject);
    }
    localObject = this.q;
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i3 = 0;
        for (;;)
        {
          localObject = this.q;
          i2 = i1;
          if (i3 >= localObject.length) {
            break;
          }
          localObject = localObject[i3];
          i2 = i1;
          if (localObject != null) {
            i2 = i1 + CodedOutputByteBufferNano.d(21, (g)localObject);
          }
          i3 += 1;
          i1 = i2;
        }
      }
    }
    localObject = this.S;
    int i3 = i2;
    if (localObject != null) {
      i3 = i2 + CodedOutputByteBufferNano.d(22, (g)localObject);
    }
    localObject = this.R;
    i1 = i3;
    if (localObject != null) {
      i1 = i3 + CodedOutputByteBufferNano.d(24, (g)localObject);
    }
    localObject = this.J;
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i3 = 0;
        for (;;)
        {
          localObject = this.J;
          i2 = i1;
          if (i3 >= localObject.length) {
            break;
          }
          localObject = localObject[i3];
          i2 = i1;
          if (localObject != null) {
            i2 = i1 + CodedOutputByteBufferNano.d(25, (g)localObject);
          }
          i3 += 1;
          i1 = i2;
        }
      }
    }
    localObject = this.k;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(26, (g)localObject);
    }
    i2 = i1;
    if ((this.h & 0x4) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(27, this.d);
    }
    localObject = this.N;
    i3 = i2;
    if (localObject != null) {
      i3 = i2 + CodedOutputByteBufferNano.d(28, (g)localObject);
    }
    localObject = this.f;
    i1 = i3;
    if (localObject != null) {
      i1 = i3 + CodedOutputByteBufferNano.d(29, (g)localObject);
    }
    localObject = this.ac;
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i3 = 0;
        for (;;)
        {
          localObject = this.ac;
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
    if ((this.h & 0x8) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(33, this.a);
    }
    localObject = this.m;
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i3 = 0;
        for (;;)
        {
          localObject = this.m;
          i2 = i1;
          if (i3 >= localObject.length) {
            break;
          }
          localObject = localObject[i3];
          i2 = i1;
          if (localObject != null) {
            i2 = i1 + CodedOutputByteBufferNano.d(34, (g)localObject);
          }
          i3 += 1;
          i1 = i2;
        }
      }
    }
    localObject = this.ab;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(35, (g)localObject);
    }
    localObject = this.al;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(37, (g)localObject);
    }
    localObject = this.G;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(38, (g)localObject);
    }
    localObject = this.v;
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i3 = 0;
        for (;;)
        {
          localObject = this.v;
          i2 = i1;
          if (i3 >= localObject.length) {
            break;
          }
          localObject = localObject[i3];
          i2 = i1;
          if (localObject != null) {
            i2 = i1 + CodedOutputByteBufferNano.d(39, (g)localObject);
          }
          i3 += 1;
          i1 = i2;
        }
      }
    }
    localObject = this.T;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(40, (g)localObject);
    }
    localObject = this.V;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(42, (g)localObject);
    }
    localObject = this.F;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(43, (g)localObject);
    }
    i2 = i1;
    if ((this.h & 0x10) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.d(44, this.p);
    }
    i1 = i2;
    if ((this.h & 0x100) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(45, this.ag);
    }
    localObject = this.E;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(46, (g)localObject);
    }
    localObject = this.i;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(47, (g)localObject);
    }
    localObject = this.b;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(48, (g)localObject);
    }
    i1 = i2;
    if ((this.h & 0x200) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(49, this.an);
    }
    localObject = this.ae;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputStream.c(50, (cl)localObject);
    }
    localObject = this.ah;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputStream.c(51, (cl)localObject);
    }
    localObject = this.am;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputStream.c(52, (cl)localObject);
    }
    localObject = this.x;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(53, (g)localObject);
    }
    localObject = this.e;
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i3 = 0;
        for (;;)
        {
          localObject = this.e;
          i2 = i1;
          if (i3 >= localObject.length) {
            break;
          }
          localObject = localObject[i3];
          i2 = i1;
          if (localObject != null) {
            i2 = i1 + CodedOutputByteBufferNano.d(54, (g)localObject);
          }
          i3 += 1;
          i1 = i2;
        }
      }
    }
    localObject = this.ai;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(55, (g)localObject);
    }
    localObject = this.Y;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(56, (g)localObject);
    }
    i1 = i2;
    if ((this.h & 0x40) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(57, this.M);
    }
    i2 = i1;
    if ((this.h & 0x20) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(59, this.o);
    }
    localObject = this.r;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(60, (g)localObject);
    }
    localObject = this.B;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(61, (g)localObject);
    }
    localObject = this.s;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(62, (g)localObject);
    }
    localObject = this.P;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(63, (g)localObject);
    }
    localObject = this.K;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(64, (g)localObject);
    }
    localObject = this.aa;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(65, (g)localObject);
    }
    i1 = i2;
    if ((this.h & 0x80) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.b(66, this.D);
    }
    localObject = this.O;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(67, (g)localObject);
    }
    localObject = this.w;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(68, (g)localObject);
    }
    localObject = this.j;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(70, (g)localObject);
    }
    localObject = this.n;
    i1 = i2;
    if (localObject != null)
    {
      i1 = i2;
      if (localObject.length > 0)
      {
        i3 = 0;
        for (;;)
        {
          localObject = this.n;
          i1 = i2;
          if (i3 >= localObject.length) {
            break;
          }
          localObject = localObject[i3];
          i1 = i2;
          if (localObject != null) {
            i1 = i2 + CodedOutputByteBufferNano.d(71, (g)localObject);
          }
          i3 += 1;
          i2 = i1;
        }
      }
    }
    localObject = this.l;
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i3 = i4;
        for (;;)
        {
          localObject = this.l;
          i2 = i1;
          if (i3 >= localObject.length) {
            break;
          }
          localObject = localObject[i3];
          i2 = i1;
          if (localObject != null) {
            i2 = i1 + CodedOutputByteBufferNano.d(72, (g)localObject);
          }
          i3 += 1;
          i1 = i2;
        }
      }
    }
    localObject = this.ak;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(73, (g)localObject);
    }
    localObject = this.ap;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(74, (g)localObject);
    }
    localObject = this.t;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(75, (g)localObject);
    }
    localObject = this.u;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(76, (g)localObject);
    }
    localObject = this.y;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(77, (g)localObject);
    }
    localObject = this.aj;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(78, (g)localObject);
    }
    localObject = this.A;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(79, (g)localObject);
    }
    i2 = i1;
    if ((this.h & 0x400) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.b(80, this.C);
    }
    localObject = this.c;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(81, (g)localObject);
    }
    i2 = i1;
    if ((this.h & 0x800) != 0) {
      i2 = i1 + (CodedOutputByteBufferNano.d(656) + 1);
    }
    return i2;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i2 = 0;
    Object localObject = this.ao;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(3, (g)localObject);
    }
    localObject = this.ad;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int i1;
    label1289:
    do
    {
      localObject = this.Q;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.b(6, (g)localObject);
      }
      localObject = this.Z;
      if (localObject != null) {
        paramCodedOutputByteBufferNano.b(7, (g)localObject);
      }
      localObject = this.af;
      if ((localObject == null) || (localObject.length <= 0)) {}
      do
      {
        localObject = this.g;
        if ((localObject == null) || (localObject.length <= 0)) {}
        do
        {
          localObject = this.z;
          if (localObject != null) {
            paramCodedOutputByteBufferNano.b(10, (g)localObject);
          }
          localObject = this.aq;
          if ((localObject == null) || (localObject.length <= 0)) {}
          do
          {
            if ((this.h & 0x1) != 0) {
              paramCodedOutputByteBufferNano.a(14, this.H);
            }
            localObject = this.W;
            if ((localObject == null) || (localObject.length <= 0)) {}
            do
            {
              if ((this.h & 0x2) != 0) {
                paramCodedOutputByteBufferNano.a(18, this.L);
              }
              localObject = this.X;
              if (localObject != null) {
                paramCodedOutputByteBufferNano.b(19, (g)localObject);
              }
              localObject = this.I;
              if (localObject != null) {
                paramCodedOutputByteBufferNano.b(20, (g)localObject);
              }
              localObject = this.q;
              if ((localObject == null) || (localObject.length <= 0)) {}
              do
              {
                localObject = this.S;
                if (localObject != null) {
                  paramCodedOutputByteBufferNano.b(22, (g)localObject);
                }
                localObject = this.R;
                if (localObject != null) {
                  paramCodedOutputByteBufferNano.b(24, (g)localObject);
                }
                localObject = this.J;
                if ((localObject == null) || (localObject.length <= 0)) {}
                do
                {
                  localObject = this.k;
                  if (localObject != null) {
                    paramCodedOutputByteBufferNano.b(26, (g)localObject);
                  }
                  if ((this.h & 0x4) != 0) {
                    paramCodedOutputByteBufferNano.a(27, this.d);
                  }
                  localObject = this.N;
                  if (localObject != null) {
                    paramCodedOutputByteBufferNano.b(28, (g)localObject);
                  }
                  localObject = this.f;
                  if (localObject != null) {
                    paramCodedOutputByteBufferNano.b(29, (g)localObject);
                  }
                  localObject = this.ac;
                  if ((localObject == null) || (localObject.length <= 0)) {}
                  do
                  {
                    if ((this.h & 0x8) != 0) {
                      paramCodedOutputByteBufferNano.a(33, this.a);
                    }
                    localObject = this.m;
                    if ((localObject == null) || (localObject.length <= 0)) {}
                    do
                    {
                      localObject = this.ab;
                      if (localObject != null) {
                        paramCodedOutputByteBufferNano.b(35, (g)localObject);
                      }
                      localObject = this.al;
                      if (localObject != null) {
                        paramCodedOutputByteBufferNano.b(37, (g)localObject);
                      }
                      localObject = this.G;
                      if (localObject != null) {
                        paramCodedOutputByteBufferNano.b(38, (g)localObject);
                      }
                      localObject = this.v;
                      if ((localObject == null) || (localObject.length <= 0)) {}
                      do
                      {
                        localObject = this.T;
                        if (localObject != null) {
                          paramCodedOutputByteBufferNano.b(40, (g)localObject);
                        }
                        localObject = this.V;
                        if (localObject != null) {
                          paramCodedOutputByteBufferNano.b(42, (g)localObject);
                        }
                        localObject = this.F;
                        if (localObject != null) {
                          paramCodedOutputByteBufferNano.b(43, (g)localObject);
                        }
                        if ((this.h & 0x10) != 0) {
                          paramCodedOutputByteBufferNano.a(44, this.p);
                        }
                        if ((this.h & 0x100) != 0) {
                          paramCodedOutputByteBufferNano.a(45, this.ag);
                        }
                        localObject = this.E;
                        if (localObject != null) {
                          paramCodedOutputByteBufferNano.b(46, (g)localObject);
                        }
                        localObject = this.i;
                        if (localObject != null) {
                          paramCodedOutputByteBufferNano.b(47, (g)localObject);
                        }
                        localObject = this.b;
                        if (localObject != null) {
                          paramCodedOutputByteBufferNano.b(48, (g)localObject);
                        }
                        if ((this.h & 0x200) != 0) {
                          paramCodedOutputByteBufferNano.a(49, this.an);
                        }
                        localObject = this.ae;
                        if (localObject != null) {
                          paramCodedOutputByteBufferNano.a(50, (cl)localObject);
                        }
                        localObject = this.ah;
                        if (localObject != null) {
                          paramCodedOutputByteBufferNano.a(51, (cl)localObject);
                        }
                        localObject = this.am;
                        if (localObject != null) {
                          paramCodedOutputByteBufferNano.a(52, (cl)localObject);
                        }
                        localObject = this.x;
                        if (localObject != null) {
                          paramCodedOutputByteBufferNano.b(53, (g)localObject);
                        }
                        localObject = this.e;
                        if ((localObject == null) || (localObject.length <= 0)) {}
                        do
                        {
                          localObject = this.ai;
                          if (localObject != null) {
                            paramCodedOutputByteBufferNano.b(55, (g)localObject);
                          }
                          localObject = this.Y;
                          if (localObject != null) {
                            paramCodedOutputByteBufferNano.b(56, (g)localObject);
                          }
                          if ((this.h & 0x40) != 0) {
                            paramCodedOutputByteBufferNano.a(57, this.M);
                          }
                          if ((this.h & 0x20) != 0) {
                            paramCodedOutputByteBufferNano.a(59, this.o);
                          }
                          localObject = this.r;
                          if (localObject != null) {
                            paramCodedOutputByteBufferNano.b(60, (g)localObject);
                          }
                          localObject = this.B;
                          if (localObject != null) {
                            paramCodedOutputByteBufferNano.b(61, (g)localObject);
                          }
                          localObject = this.s;
                          if (localObject != null) {
                            paramCodedOutputByteBufferNano.b(62, (g)localObject);
                          }
                          localObject = this.P;
                          if (localObject != null) {
                            paramCodedOutputByteBufferNano.b(63, (g)localObject);
                          }
                          localObject = this.K;
                          if (localObject != null) {
                            paramCodedOutputByteBufferNano.b(64, (g)localObject);
                          }
                          localObject = this.aa;
                          if (localObject != null) {
                            paramCodedOutputByteBufferNano.b(65, (g)localObject);
                          }
                          if ((this.h & 0x80) != 0) {
                            paramCodedOutputByteBufferNano.a(66, this.D);
                          }
                          localObject = this.O;
                          if (localObject != null) {
                            paramCodedOutputByteBufferNano.b(67, (g)localObject);
                          }
                          localObject = this.w;
                          if (localObject != null) {
                            paramCodedOutputByteBufferNano.b(68, (g)localObject);
                          }
                          localObject = this.j;
                          if (localObject != null) {
                            paramCodedOutputByteBufferNano.b(70, (g)localObject);
                          }
                          localObject = this.n;
                          if ((localObject == null) || (localObject.length <= 0)) {}
                          do
                          {
                            localObject = this.l;
                            if (localObject != null)
                            {
                              i1 = i2;
                              if (localObject.length > 0) {
                                break label1289;
                              }
                            }
                            do
                            {
                              localObject = this.ak;
                              if (localObject != null) {
                                paramCodedOutputByteBufferNano.b(73, (g)localObject);
                              }
                              localObject = this.ap;
                              if (localObject != null) {
                                paramCodedOutputByteBufferNano.b(74, (g)localObject);
                              }
                              localObject = this.t;
                              if (localObject != null) {
                                paramCodedOutputByteBufferNano.b(75, (g)localObject);
                              }
                              localObject = this.u;
                              if (localObject != null) {
                                paramCodedOutputByteBufferNano.b(76, (g)localObject);
                              }
                              localObject = this.y;
                              if (localObject != null) {
                                paramCodedOutputByteBufferNano.b(77, (g)localObject);
                              }
                              localObject = this.aj;
                              if (localObject != null) {
                                paramCodedOutputByteBufferNano.b(78, (g)localObject);
                              }
                              localObject = this.A;
                              if (localObject != null) {
                                paramCodedOutputByteBufferNano.b(79, (g)localObject);
                              }
                              if ((this.h & 0x400) != 0) {
                                paramCodedOutputByteBufferNano.a(80, this.C);
                              }
                              localObject = this.c;
                              if (localObject != null) {
                                paramCodedOutputByteBufferNano.b(81, (g)localObject);
                              }
                              if ((this.h & 0x800) != 0) {
                                paramCodedOutputByteBufferNano.a(82, this.U);
                              }
                              super.a(paramCodedOutputByteBufferNano);
                              return;
                              localObject = this.l;
                            } while (i1 >= localObject.length);
                            localObject = localObject[i1];
                            if (localObject == null) {}
                            for (;;)
                            {
                              i1 += 1;
                              break;
                              paramCodedOutputByteBufferNano.b(72, (g)localObject);
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
                            paramCodedOutputByteBufferNano.b(71, (g)localObject);
                          }
                          i1 = 0;
                          localObject = this.e;
                        } while (i1 >= localObject.length);
                        localObject = localObject[i1];
                        if (localObject == null) {}
                        for (;;)
                        {
                          i1 += 1;
                          break;
                          paramCodedOutputByteBufferNano.b(54, (g)localObject);
                        }
                        i1 = 0;
                        localObject = this.v;
                      } while (i1 >= localObject.length);
                      localObject = localObject[i1];
                      if (localObject == null) {}
                      for (;;)
                      {
                        i1 += 1;
                        break;
                        paramCodedOutputByteBufferNano.b(39, (g)localObject);
                      }
                      i1 = 0;
                      localObject = this.m;
                    } while (i1 >= localObject.length);
                    localObject = localObject[i1];
                    if (localObject == null) {}
                    for (;;)
                    {
                      i1 += 1;
                      break;
                      paramCodedOutputByteBufferNano.b(34, (g)localObject);
                    }
                    i1 = 0;
                    localObject = this.ac;
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
                  localObject = this.J;
                } while (i1 >= localObject.length);
                localObject = localObject[i1];
                if (localObject == null) {}
                for (;;)
                {
                  i1 += 1;
                  break;
                  paramCodedOutputByteBufferNano.b(25, (g)localObject);
                }
                i1 = 0;
                localObject = this.q;
              } while (i1 >= localObject.length);
              localObject = localObject[i1];
              if (localObject == null) {}
              for (;;)
              {
                i1 += 1;
                break;
                paramCodedOutputByteBufferNano.b(21, (g)localObject);
              }
              i1 = 0;
              localObject = this.W;
            } while (i1 >= localObject.length);
            localObject = localObject[i1];
            if (localObject == null) {}
            for (;;)
            {
              i1 += 1;
              break;
              paramCodedOutputByteBufferNano.b(16, (g)localObject);
            }
            i1 = 0;
            localObject = this.aq;
          } while (i1 >= localObject.length);
          localObject = localObject[i1];
          if (localObject == null) {}
          for (;;)
          {
            i1 += 1;
            break;
            paramCodedOutputByteBufferNano.b(13, (g)localObject);
          }
          i1 = 0;
          localObject = this.g;
        } while (i1 >= localObject.length);
        localObject = localObject[i1];
        if (localObject == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          paramCodedOutputByteBufferNano.b(9, (g)localObject);
        }
        i1 = 0;
        localObject = this.af;
      } while (i1 >= localObject.length);
      localObject = localObject[i1];
      if (localObject == null) {}
      for (;;)
      {
        i1 += 1;
        break;
        paramCodedOutputByteBufferNano.b(8, (g)localObject);
      }
      i1 = 0;
      localObject = this.ad;
    } while (i1 >= localObject.length);
    localObject = localObject[i1];
    if (localObject == null) {}
    for (;;)
    {
      i1 += 1;
      break;
      paramCodedOutputByteBufferNano.b(4, (g)localObject);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof k))
      {
        paramObject = (k)paramObject;
        if (f.a(this.m, ((k)paramObject).m))
        {
          localObject = this.Q;
          if (localObject != null) {
            break label1980;
          }
          if (((k)paramObject).Q != null) {}
        }
      }
      label1392:
      label1504:
      label1588:
      label1714:
      label1756:
      label1812:
      label1826:
      label1840:
      label1854:
      label1882:
      label1924:
      label1980:
      while (((kl)localObject).equals(((k)paramObject).Q))
      {
        localObject = this.S;
        if (localObject == null) {
          if (((k)paramObject).S != null) {}
        }
        while (((kl)localObject).equals(((k)paramObject).S))
        {
          localObject = this.R;
          if (localObject == null) {
            if (((k)paramObject).R != null) {}
          }
          while (((kl)localObject).equals(((k)paramObject).R))
          {
            localObject = this.ao;
            if (localObject == null) {
              if (((k)paramObject).ao != null) {}
            }
            while (((hy)localObject).equals(((k)paramObject).ao))
            {
              if (f.a(this.ad, ((k)paramObject).ad))
              {
                localObject = this.I;
                if (localObject != null) {
                  break label1924;
                }
                if (((k)paramObject).I != null) {}
              }
              while (((nk)localObject).equals(((k)paramObject).I))
              {
                localObject = this.z;
                if (localObject == null) {
                  if (((k)paramObject).z != null) {}
                }
                while (((fb)localObject).equals(((k)paramObject).z))
                {
                  localObject = this.Z;
                  if (localObject == null) {
                    if (((k)paramObject).Z != null) {}
                  }
                  while (((mc)localObject).equals(((k)paramObject).Z))
                  {
                    if ((f.a(this.e, ((k)paramObject).e)) && (f.a(this.n, ((k)paramObject).n)) && (f.a(this.l, ((k)paramObject).l)))
                    {
                      localObject = this.t;
                      if (localObject != null) {
                        break label1882;
                      }
                      if (((k)paramObject).t != null) {}
                    }
                    while (((fb)localObject).equals(((k)paramObject).t))
                    {
                      localObject = this.u;
                      if (localObject == null) {
                        if (((k)paramObject).u != null) {}
                      }
                      while (((dp)localObject).equals(((k)paramObject).u))
                      {
                        if ((f.a(this.af, ((k)paramObject).af)) && (f.a(this.g, ((k)paramObject).g)) && (f.a(this.v, ((k)paramObject).v)))
                        {
                          localObject = this.f;
                          if (localObject != null) {
                            break label1854;
                          }
                          if (((k)paramObject).f != null) {}
                        }
                        while (((am)localObject).equals(((k)paramObject).f))
                        {
                          if ((f.a(this.q, ((k)paramObject).q)) && (f.a(this.aq, ((k)paramObject).aq)) && ((this.h & 0x1) == (((k)paramObject).h & 0x1)) && (this.H.equals(((k)paramObject).H)) && (f.a(this.W, ((k)paramObject).W)))
                          {
                            localObject = this.X;
                            if (localObject != null) {
                              break label1840;
                            }
                            if (((k)paramObject).X != null) {}
                          }
                          while (((lt)localObject).equals(((k)paramObject).X))
                          {
                            if (((this.h & 0x2) == (((k)paramObject).h & 0x2)) && (this.L.equals(((k)paramObject).L)) && (f.a(this.J, ((k)paramObject).J)))
                            {
                              localObject = this.k;
                              if (localObject != null) {
                                break label1826;
                              }
                              if (((k)paramObject).k != null) {}
                            }
                            while (((de)localObject).equals(((k)paramObject).k))
                            {
                              if (((this.h & 0x4) == (((k)paramObject).h & 0x4)) && (this.d.equals(((k)paramObject).d)))
                              {
                                localObject = this.N;
                                if (localObject != null) {
                                  break label1812;
                                }
                                if (((k)paramObject).N != null) {}
                              }
                              while (((is)localObject).equals(((k)paramObject).N))
                              {
                                localObject = this.al;
                                if (localObject == null) {
                                  if (((k)paramObject).al != null) {}
                                }
                                while (((gz)localObject).equals(((k)paramObject).al))
                                {
                                  localObject = this.G;
                                  if (localObject == null) {
                                    if (((k)paramObject).G != null) {}
                                  }
                                  while (((gy)localObject).equals(((k)paramObject).G))
                                  {
                                    localObject = this.F;
                                    if (localObject == null) {
                                      if (((k)paramObject).F != null) {}
                                    }
                                    while (((gx)localObject).equals(((k)paramObject).F))
                                    {
                                      if ((f.a(this.ac, ((k)paramObject).ac)) && ((this.h & 0x8) == (((k)paramObject).h & 0x8)) && (this.a.equals(((k)paramObject).a)))
                                      {
                                        localObject = this.ab;
                                        if (localObject != null) {
                                          break label1756;
                                        }
                                        if (((k)paramObject).ab != null) {}
                                      }
                                      while (((mz)localObject).equals(((k)paramObject).ab))
                                      {
                                        localObject = this.T;
                                        if (localObject == null) {
                                          if (((k)paramObject).T != null) {}
                                        }
                                        while (((kq)localObject).equals(((k)paramObject).T))
                                        {
                                          localObject = this.V;
                                          if (localObject == null) {
                                            if (((k)paramObject).V != null) {}
                                          }
                                          while (((la)localObject).equals(((k)paramObject).V))
                                          {
                                            int i1 = this.h;
                                            int i2 = ((k)paramObject).h;
                                            if (((i1 & 0x10) == (i2 & 0x10)) && (this.p == ((k)paramObject).p) && ((i1 & 0x20) == (i2 & 0x20)) && (this.o.equals(((k)paramObject).o)))
                                            {
                                              localObject = this.i;
                                              if (localObject != null) {
                                                break label1714;
                                              }
                                              if (((k)paramObject).i != null) {}
                                            }
                                            while (((ay)localObject).equals(((k)paramObject).i))
                                            {
                                              localObject = this.E;
                                              if (localObject == null) {
                                                if (((k)paramObject).E != null) {}
                                              }
                                              while (((gj)localObject).equals(((k)paramObject).E))
                                              {
                                                localObject = this.b;
                                                if (localObject == null) {
                                                  if (((k)paramObject).b != null) {}
                                                }
                                                while (((w)localObject).equals(((k)paramObject).b))
                                                {
                                                  localObject = this.ae;
                                                  if (localObject == null) {
                                                    if (((k)paramObject).ae != null) {}
                                                  }
                                                  while (((bb)localObject).equals(((k)paramObject).ae))
                                                  {
                                                    localObject = this.ah;
                                                    if (localObject == null) {
                                                      if (((k)paramObject).ah != null) {}
                                                    }
                                                    while (((bb)localObject).equals(((k)paramObject).ah))
                                                    {
                                                      localObject = this.am;
                                                      if (localObject == null) {
                                                        if (((k)paramObject).am != null) {}
                                                      }
                                                      while (((bb)localObject).equals(((k)paramObject).am))
                                                      {
                                                        localObject = this.x;
                                                        if (localObject == null) {
                                                          if (((k)paramObject).x != null) {}
                                                        }
                                                        while (((eb)localObject).equals(((k)paramObject).x))
                                                        {
                                                          localObject = this.ai;
                                                          if (localObject == null) {
                                                            if (((k)paramObject).ai != null) {}
                                                          }
                                                          while (((eo)localObject).equals(((k)paramObject).ai))
                                                          {
                                                            localObject = this.Y;
                                                            if (localObject == null) {
                                                              if (((k)paramObject).Y != null) {}
                                                            }
                                                            while (((lz)localObject).equals(((k)paramObject).Y))
                                                            {
                                                              if (((this.h & 0x40) == (((k)paramObject).h & 0x40)) && (this.M.equals(((k)paramObject).M)))
                                                              {
                                                                localObject = this.r;
                                                                if (localObject != null) {
                                                                  break label1588;
                                                                }
                                                                if (((k)paramObject).r != null) {}
                                                              }
                                                              while (((dh)localObject).equals(((k)paramObject).r))
                                                              {
                                                                localObject = this.B;
                                                                if (localObject == null) {
                                                                  if (((k)paramObject).B != null) {}
                                                                }
                                                                while (((fg)localObject).equals(((k)paramObject).B))
                                                                {
                                                                  localObject = this.s;
                                                                  if (localObject == null) {
                                                                    if (((k)paramObject).s != null) {}
                                                                  }
                                                                  while (((dk)localObject).equals(((k)paramObject).s))
                                                                  {
                                                                    localObject = this.P;
                                                                    if (localObject == null) {
                                                                      if (((k)paramObject).P != null) {}
                                                                    }
                                                                    while (((ke)localObject).equals(((k)paramObject).P))
                                                                    {
                                                                      localObject = this.K;
                                                                      if (localObject == null) {
                                                                        if (((k)paramObject).K != null) {}
                                                                      }
                                                                      while (((ex)localObject).equals(((k)paramObject).K))
                                                                      {
                                                                        localObject = this.aa;
                                                                        if (localObject == null) {
                                                                          if (((k)paramObject).aa != null) {}
                                                                        }
                                                                        while (((mi)localObject).equals(((k)paramObject).aa))
                                                                        {
                                                                          if (((this.h & 0x80) == (((k)paramObject).h & 0x80)) && (this.D.equals(((k)paramObject).D)))
                                                                          {
                                                                            localObject = this.O;
                                                                            if (localObject != null) {
                                                                              break label1504;
                                                                            }
                                                                            if (((k)paramObject).O != null) {}
                                                                          }
                                                                          while (((iy)localObject).equals(((k)paramObject).O))
                                                                          {
                                                                            localObject = this.w;
                                                                            if (localObject == null) {
                                                                              if (((k)paramObject).w != null) {}
                                                                            }
                                                                            while (((dy)localObject).equals(((k)paramObject).w))
                                                                            {
                                                                              localObject = this.j;
                                                                              if (localObject == null) {
                                                                                if (((k)paramObject).j != null) {}
                                                                              }
                                                                              while (((ck)localObject).equals(((k)paramObject).j))
                                                                              {
                                                                                localObject = this.ak;
                                                                                if (localObject == null) {
                                                                                  if (((k)paramObject).ak != null) {}
                                                                                }
                                                                                while (((fx)localObject).equals(((k)paramObject).ak))
                                                                                {
                                                                                  localObject = this.ap;
                                                                                  if (localObject == null) {
                                                                                    if (((k)paramObject).ap != null) {}
                                                                                  }
                                                                                  while (((ib)localObject).equals(((k)paramObject).ap))
                                                                                  {
                                                                                    localObject = this.y;
                                                                                    if (localObject == null) {
                                                                                      if (((k)paramObject).y != null) {}
                                                                                    }
                                                                                    while (((ez)localObject).equals(((k)paramObject).y))
                                                                                    {
                                                                                      localObject = this.aj;
                                                                                      if (localObject == null) {
                                                                                        if (((k)paramObject).aj != null) {}
                                                                                      }
                                                                                      while (((fq)localObject).equals(((k)paramObject).aj))
                                                                                      {
                                                                                        localObject = this.A;
                                                                                        if (localObject == null) {
                                                                                          if (((k)paramObject).A != null) {}
                                                                                        }
                                                                                        while (((fj)localObject).equals(((k)paramObject).A))
                                                                                        {
                                                                                          if (((this.h & 0x100) == (((k)paramObject).h & 0x100)) && (this.ag.equals(((k)paramObject).ag)) && ((this.h & 0x200) == (((k)paramObject).h & 0x200)) && (this.an.equals(((k)paramObject).an)) && ((this.h & 0x400) == (((k)paramObject).h & 0x400)) && (this.C.equals(((k)paramObject).C)))
                                                                                          {
                                                                                            localObject = this.c;
                                                                                            if (localObject != null) {
                                                                                              break label1392;
                                                                                            }
                                                                                            if (((k)paramObject).c != null) {}
                                                                                          }
                                                                                          while (((aa)localObject).equals(((k)paramObject).c))
                                                                                          {
                                                                                            if (((this.h & 0x800) == (((k)paramObject).h & 0x800)) && (this.U == ((k)paramObject).U))
                                                                                            {
                                                                                              localObject = this.unknownFieldData;
                                                                                              if ((localObject == null) || (((d)localObject).a())) {
                                                                                                paramObject = ((k)paramObject).unknownFieldData;
                                                                                              }
                                                                                            }
                                                                                            else
                                                                                            {
                                                                                              return (paramObject == null) || (((d)paramObject).a());
                                                                                            }
                                                                                            return this.unknownFieldData.equals(((k)paramObject).unknownFieldData);
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
    int i46 = 0;
    int i47 = getClass().getName().hashCode();
    int i48 = f.a(this.m);
    Object localObject = this.Q;
    if (localObject != null) {}
    for (int i1 = ((kl)localObject).hashCode();; i1 = 0)
    {
      localObject = this.S;
      if (localObject != null) {}
      for (int i2 = ((kl)localObject).hashCode();; i2 = 0)
      {
        localObject = this.R;
        if (localObject != null) {}
        for (int i3 = ((kl)localObject).hashCode();; i3 = 0)
        {
          localObject = this.ao;
          if (localObject != null) {}
          for (int i4 = ((hy)localObject).hashCode();; i4 = 0)
          {
            int i49 = f.a(this.ad);
            localObject = this.I;
            if (localObject != null) {}
            for (int i5 = ((nk)localObject).hashCode();; i5 = 0)
            {
              localObject = this.z;
              if (localObject != null) {}
              for (int i6 = ((fb)localObject).hashCode();; i6 = 0)
              {
                localObject = this.Z;
                if (localObject != null) {}
                for (int i7 = ((mc)localObject).hashCode();; i7 = 0)
                {
                  int i50 = f.a(this.e);
                  int i51 = f.a(this.n);
                  int i52 = f.a(this.l);
                  localObject = this.t;
                  if (localObject != null) {}
                  for (int i8 = ((fb)localObject).hashCode();; i8 = 0)
                  {
                    localObject = this.u;
                    if (localObject != null) {}
                    for (int i9 = ((dp)localObject).hashCode();; i9 = 0)
                    {
                      int i53 = f.a(this.af);
                      int i54 = f.a(this.g);
                      int i55 = f.a(this.v);
                      localObject = this.f;
                      if (localObject != null) {}
                      for (int i10 = ((am)localObject).hashCode();; i10 = 0)
                      {
                        int i56 = f.a(this.q);
                        int i57 = f.a(this.aq);
                        int i58 = this.H.hashCode();
                        int i59 = f.a(this.W);
                        localObject = this.X;
                        if (localObject != null) {}
                        for (int i11 = ((lt)localObject).hashCode();; i11 = 0)
                        {
                          int i60 = this.L.hashCode();
                          int i61 = f.a(this.J);
                          localObject = this.k;
                          if (localObject != null) {}
                          for (int i12 = ((de)localObject).hashCode();; i12 = 0)
                          {
                            int i62 = this.d.hashCode();
                            localObject = this.N;
                            if (localObject != null) {}
                            for (int i13 = ((is)localObject).hashCode();; i13 = 0)
                            {
                              localObject = this.al;
                              if (localObject != null) {}
                              for (int i14 = ((gz)localObject).hashCode();; i14 = 0)
                              {
                                localObject = this.G;
                                if (localObject != null) {}
                                for (int i15 = ((gy)localObject).hashCode();; i15 = 0)
                                {
                                  localObject = this.F;
                                  if (localObject != null) {}
                                  for (int i16 = ((gx)localObject).hashCode();; i16 = 0)
                                  {
                                    int i63 = f.a(this.ac);
                                    int i64 = this.a.hashCode();
                                    localObject = this.ab;
                                    if (localObject != null) {}
                                    for (int i17 = ((mz)localObject).hashCode();; i17 = 0)
                                    {
                                      localObject = this.T;
                                      if (localObject != null) {}
                                      for (int i18 = ((kq)localObject).hashCode();; i18 = 0)
                                      {
                                        localObject = this.V;
                                        if (localObject != null) {}
                                        for (int i19 = ((la)localObject).hashCode();; i19 = 0)
                                        {
                                          int i65 = this.p;
                                          int i66 = this.o.hashCode();
                                          localObject = this.i;
                                          if (localObject != null) {}
                                          for (int i20 = ((ay)localObject).hashCode();; i20 = 0)
                                          {
                                            localObject = this.E;
                                            if (localObject != null) {}
                                            for (int i21 = ((gj)localObject).hashCode();; i21 = 0)
                                            {
                                              localObject = this.b;
                                              if (localObject != null) {}
                                              for (int i22 = ((w)localObject).hashCode();; i22 = 0)
                                              {
                                                localObject = this.ae;
                                                if (localObject != null) {}
                                                for (int i23 = ((bb)localObject).hashCode();; i23 = 0)
                                                {
                                                  localObject = this.ah;
                                                  if (localObject != null) {}
                                                  for (int i24 = ((bb)localObject).hashCode();; i24 = 0)
                                                  {
                                                    localObject = this.am;
                                                    if (localObject != null) {}
                                                    for (int i25 = ((bb)localObject).hashCode();; i25 = 0)
                                                    {
                                                      localObject = this.x;
                                                      if (localObject != null) {}
                                                      for (int i26 = ((eb)localObject).hashCode();; i26 = 0)
                                                      {
                                                        localObject = this.ai;
                                                        if (localObject != null) {}
                                                        for (int i27 = ((eo)localObject).hashCode();; i27 = 0)
                                                        {
                                                          localObject = this.Y;
                                                          if (localObject != null) {}
                                                          for (int i28 = ((lz)localObject).hashCode();; i28 = 0)
                                                          {
                                                            int i67 = this.M.hashCode();
                                                            localObject = this.r;
                                                            if (localObject != null) {}
                                                            for (int i29 = ((dh)localObject).hashCode();; i29 = 0)
                                                            {
                                                              localObject = this.B;
                                                              if (localObject != null) {}
                                                              for (int i30 = ((fg)localObject).hashCode();; i30 = 0)
                                                              {
                                                                localObject = this.s;
                                                                if (localObject != null) {}
                                                                for (int i31 = ((dk)localObject).hashCode();; i31 = 0)
                                                                {
                                                                  localObject = this.P;
                                                                  if (localObject != null) {}
                                                                  for (int i32 = ((ke)localObject).hashCode();; i32 = 0)
                                                                  {
                                                                    localObject = this.K;
                                                                    if (localObject != null) {}
                                                                    for (int i33 = ((ex)localObject).hashCode();; i33 = 0)
                                                                    {
                                                                      localObject = this.aa;
                                                                      if (localObject != null) {}
                                                                      for (int i34 = ((mi)localObject).hashCode();; i34 = 0)
                                                                      {
                                                                        int i68 = this.D.hashCode();
                                                                        localObject = this.O;
                                                                        if (localObject != null) {}
                                                                        for (int i35 = ((iy)localObject).hashCode();; i35 = 0)
                                                                        {
                                                                          localObject = this.w;
                                                                          if (localObject != null) {}
                                                                          for (int i36 = ((dy)localObject).hashCode();; i36 = 0)
                                                                          {
                                                                            localObject = this.j;
                                                                            if (localObject != null) {}
                                                                            for (int i37 = ((ck)localObject).hashCode();; i37 = 0)
                                                                            {
                                                                              localObject = this.ak;
                                                                              if (localObject != null) {}
                                                                              for (int i38 = ((fx)localObject).hashCode();; i38 = 0)
                                                                              {
                                                                                localObject = this.ap;
                                                                                if (localObject != null) {}
                                                                                for (int i39 = ((ib)localObject).hashCode();; i39 = 0)
                                                                                {
                                                                                  localObject = this.y;
                                                                                  if (localObject != null) {}
                                                                                  for (int i40 = ((ez)localObject).hashCode();; i40 = 0)
                                                                                  {
                                                                                    localObject = this.aj;
                                                                                    if (localObject != null) {}
                                                                                    for (int i41 = ((fq)localObject).hashCode();; i41 = 0)
                                                                                    {
                                                                                      localObject = this.A;
                                                                                      if (localObject != null) {}
                                                                                      for (int i42 = ((fj)localObject).hashCode();; i42 = 0)
                                                                                      {
                                                                                        int i69 = this.ag.hashCode();
                                                                                        int i70 = this.an.hashCode();
                                                                                        int i71 = this.C.hashCode();
                                                                                        localObject = this.c;
                                                                                        if (localObject != null) {}
                                                                                        for (int i43 = ((aa)localObject).hashCode();; i43 = 0)
                                                                                        {
                                                                                          if (!this.U) {}
                                                                                          for (int i44 = 1237;; i44 = 1231)
                                                                                          {
                                                                                            localObject = this.unknownFieldData;
                                                                                            int i45 = i46;
                                                                                            if (localObject != null)
                                                                                            {
                                                                                              i45 = i46;
                                                                                              if (!((d)localObject).a()) {
                                                                                                i45 = this.unknownFieldData.hashCode();
                                                                                              }
                                                                                            }
                                                                                            return (i44 + (i43 + ((((i42 + (i41 + (i40 + (i39 + (i38 + (i37 + (i36 + (i35 + ((i34 + (i33 + (i32 + (i31 + (i30 + (i29 + ((i28 + (i27 + (i26 + (i25 + (i24 + (i23 + (i22 + (i21 + (i20 + (((i19 + (i18 + (i17 + (((i16 + (i15 + (i14 + (i13 + ((i12 + (((i11 + (((((i10 + ((((i9 + (i8 + ((((i7 + (i6 + (i5 + ((i4 + (i3 + (i2 + (i1 + ((i47 + 527) * 31 + i48) * 31) * 31) * 31) * 31) * 31 + i49) * 31) * 31) * 31) * 31 + i50) * 31 + i51) * 31 + i52) * 31) * 31) * 31 + i53) * 31 + i54) * 31 + i55) * 31) * 31 + i56) * 31 + i57) * 31 + i58) * 31 + i59) * 31) * 31 + i60) * 31 + i61) * 31) * 31 + i62) * 31) * 31) * 31) * 31) * 31 + i63) * 31 + i64) * 31) * 31) * 31) * 31 + i65) * 31 + i66) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i67) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i68) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i69) * 31 + i70) * 31 + i71) * 31) * 31) * 31 + i45;
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */