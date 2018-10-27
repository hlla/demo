package com.google.android.finsky.cs.a.a;

import android.content.Context;
import com.google.android.finsky.activities.cp;
import com.google.android.finsky.activities.cq;
import com.google.android.finsky.activities.cr;
import com.google.android.finsky.activities.cs;
import com.google.android.finsky.activities.ct;
import com.google.android.finsky.utils.FinskyLog;

public final class a
  implements com.google.android.finsky.ab.a.b.a, com.google.android.finsky.accountfragment.a.b.a, com.google.android.finsky.androidchurnpromotionpage.a.b.a, com.google.android.finsky.ax.a.b.a, com.google.android.finsky.billing.l.a.b.a, com.google.android.finsky.ce.b, com.google.android.finsky.cu.a.b.a, com.google.android.finsky.db.c, com.google.android.finsky.df.a.b.a, com.google.android.finsky.ec.a.b.a, com.google.android.finsky.fi.a.b.a, com.google.android.finsky.notificationsettings.a, com.google.android.finsky.protect.a.b.a, com.google.android.finsky.settings.a.b.a, com.google.android.finsky.singleappliveopsfragment.a.b.a
{
  private y A;
  private z B;
  private aa C;
  private ab D;
  private ac E;
  private ad F;
  private ae G;
  private af H;
  private ag I;
  private ah J;
  private ai K;
  private aj L;
  private ak M;
  private al N;
  private am O;
  private an P;
  private ao Q;
  private ap R;
  private aq S;
  private ar T;
  private as U;
  private at V;
  private au W;
  private av X;
  private aw Y;
  private ax Z;
  private e.a.a a;
  private e.a.a aA;
  private com.google.android.finsky.cs.a.b.a aB;
  private e.a.a aC;
  private com.google.android.finsky.navigationmanager.a.p aD;
  private com.google.android.finsky.navigationmanager.a.t aE;
  private com.google.android.finsky.protect.impl.k aF;
  private e.a.a aG;
  private e.a.a aH;
  private e.a.a aI;
  private e.a.a aJ;
  private e.a.a aK;
  private cp aL;
  private e.a.a aM;
  private e.a.a aN;
  private e.a.a aO;
  private e.a.a aP;
  private e.a.a aQ;
  private e.a.a aR;
  private e.a.a aS;
  private e.a.a aT;
  private ay aa;
  private az ab;
  private ba ac;
  private bb ad;
  private bc ae;
  private bd af;
  private be ag;
  private bf ah;
  private bg ai;
  private bh aj;
  private bi ak;
  private bj al;
  private bk am;
  private bl an;
  private bm ao;
  private bn ap;
  private bo aq;
  private bp ar;
  private bq as;
  private br at;
  private bs au;
  private bt av;
  private bu aw;
  private e.a.a ax;
  private e.a.a ay;
  private e.a.a az;
  private e.a.a b;
  private e.a.a c;
  private com.google.android.finsky.navigationmanager.a.c d;
  private c e;
  private d f;
  private e g;
  private f h;
  private g i;
  private h j;
  private i k;
  private j l;
  private k m;
  private l n;
  private m o;
  private n p;
  private o q;
  private p r;
  private q s;
  private r t;
  private s u;
  private t v;
  private u w;
  private v x;
  private w y;
  private x z;
  
  a(b paramb)
  {
    this.i = new g(paramb.b);
    this.ar = new bp(paramb.b);
    this.e = new c(paramb.b);
    this.g = new e(paramb.b);
    this.z = new x(paramb.b);
    this.D = new ab(paramb.b);
    this.G = new ae(paramb.b);
    this.R = new ap(paramb.b);
    this.af = new bd(paramb.b);
    this.ag = new be(paramb.b);
    this.ao = new bm(paramb.b);
    this.ap = new bn(paramb.b);
    this.at = new br(paramb.b);
    this.l = new j(paramb.b);
    this.k = new i(paramb.b);
    this.n = new l(paramb.b);
    this.u = new s(paramb.b);
    this.v = new t(paramb.b);
    this.E = new ac(paramb.b);
    this.F = new ad(paramb.b);
    this.H = new af(paramb.b);
    this.J = new ah(paramb.b);
    this.K = new ai(paramb.b);
    this.S = new aq(paramb.b);
    this.U = new as(paramb.b);
    this.V = new at(paramb.b);
    this.W = new au(paramb.b);
    this.ai = new bg(paramb.b);
    this.aj = new bh(paramb.b);
    this.al = new bj(paramb.b);
    this.am = new bk(paramb.b);
    this.an = new bl(paramb.b);
    this.x = new v(paramb.b);
    this.av = new bt(paramb.b);
    this.as = new bq(paramb.b);
    this.f = new d(paramb.b);
    this.p = new n(paramb.b);
    this.Y = new aw(paramb.b);
    this.q = new o(paramb.b);
    this.B = new z(paramb.b);
    this.C = new aa(paramb.b);
    this.I = new ag(paramb.b);
    this.T = new ar(paramb.b);
    this.X = new av(paramb.b);
    this.Z = new ax(paramb.b);
    this.aa = new ay(paramb.b);
    this.ab = new az(paramb.b);
    this.ac = new ba(paramb.b);
    this.ad = new bb(paramb.b);
    this.ae = new bc(paramb.b);
    this.ah = new bf(paramb.b);
    this.ak = new bi(paramb.b);
    this.au = new bs(paramb.b);
    this.b = b.a.e.a(paramb.a);
    this.aK = b.a.c.a(this.b);
    this.s = new q(paramb.b);
    this.d = com.google.android.finsky.navigationmanager.a.c.a(this.s, this.ao, com.google.android.finsky.protect.impl.f.a);
    this.aS = b.a.c.a(this.b);
    this.aO = b.a.c.a(this.b);
    this.h = new f(paramb.b);
    this.t = new r(paramb.b);
    this.w = new u(paramb.b);
    this.N = new al(paramb.b);
    this.r = new p(paramb.b);
    this.M = new ak(paramb.b);
    this.O = new am(paramb.b);
    this.aE = com.google.android.finsky.navigationmanager.a.t.a(this.G);
    this.aD = com.google.android.finsky.navigationmanager.a.p.a(this.G, com.google.android.finsky.navigationmanager.a.r.a, this.aE);
    this.aF = com.google.android.finsky.protect.impl.k.a(this.s, this.al, this.E);
    this.aC = b.a.c.a(new com.google.android.finsky.navigationmanager.a.n(this.aK, this.d, this.g, this.aS, this.aO, this.h, this.i, this.t, this.w, this.z, this.N, this.S, this.r, this.G, this.E, this.D, this.M, this.O, this.ao, this.ak, this.aD, this.T, this.I, this.U, this.aF));
    this.o = new m(paramb.b);
    this.Q = new ao(paramb.b);
    this.aw = new bu(paramb.b);
    this.m = new k(paramb.b);
    this.j = new h(paramb.b);
    this.y = new w(paramb.b);
    this.aI = b.a.c.a(this.b);
    this.aJ = b.a.c.a(this.b);
    this.a = b.a.c.a(new com.google.android.finsky.layout.actionbar.g(this.r, this.z, this.ao, this.o, this.t, this.D, this.G, this.U, this.l, this.Q, this.g, this.aw, this.m, this.j, this.aC, this.y, this.aI, this.aJ));
    this.aP = b.a.c.a(this.b);
    this.c = b.a.c.a(new com.google.android.finsky.activities.bd(this.aP, this.aC));
    this.aq = new bo(paramb.b);
    this.aH = b.a.c.a(this.b);
    this.aN = b.a.c.a(this.b);
    this.aM = b.a.c.a(new cq(this.b));
    this.P = new an(paramb.b);
    this.ay = b.a.c.a(new com.google.android.finsky.inlinevideo.e(this.aM));
    this.aT = b.a.c.a(new ct(this.b));
    this.aA = b.a.c.a(new com.google.android.finsky.inlinevideo.o(this.aT));
    this.aR = b.a.c.a(new cs(this.b));
    this.aL = new cp(this.aR);
    this.ax = b.a.c.a(new com.google.android.finsky.inlinevideo.c(this.aL));
    this.az = b.a.c.a(new com.google.android.finsky.inlinevideo.g(this.aH, this.aN, cr.a, this.aM, this.P, this.ay, this.aA, this.ax));
    this.A = new y(paramb.b);
    this.aG = b.a.c.a(this.b);
    this.aB = paramb.b;
    this.L = new aj(paramb.b);
    this.aQ = b.a.c.a(this.b);
  }
  
  public final com.google.android.finsky.dn.e A()
  {
    return (com.google.android.finsky.dn.e)b.a.i.a(this.aB.A(), "Cannot return null from a non-@Nullable component method");
  }
  
  public final com.google.android.finsky.actionbar.f a()
  {
    return (com.google.android.finsky.actionbar.f)this.aG.a();
  }
  
  public final void a(com.google.android.finsky.db.a parama)
  {
    parama.d = ((com.google.android.finsky.api.i)b.a.i.a(this.aB.l(), "Cannot return null from a non-@Nullable component method"));
    parama.bc = ((com.google.android.finsky.dn.e)b.a.i.a(this.aB.A(), "Cannot return null from a non-@Nullable component method"));
    parama.ab = ((com.google.android.finsky.bo.c)b.a.i.a(this.aB.v(), "Cannot return null from a non-@Nullable component method"));
    parama.al = ((com.google.android.finsky.e.ac)b.a.i.a(this.aB.g(), "Cannot return null from a non-@Nullable component method"));
    parama.o_ = ((com.google.android.finsky.e.a)b.a.i.a(this.aB.h(), "Cannot return null from a non-@Nullable component method"));
    parama.h_ = ((com.google.android.finsky.layoutswitcher.j)b.a.i.a(this.aB.y(), "Cannot return null from a non-@Nullable component method"));
    parama.bb = ((com.google.android.finsky.bm.a)b.a.i.a(this.aB.u(), "Cannot return null from a non-@Nullable component method"));
    parama.bd += 1;
    if (parama.bd > 1) {
      FinskyLog.e("%s has been injected %d times, please create a custom injector for the classand make sure one injection per instance.", new Object[] { parama.getClass().getSimpleName(), Integer.valueOf(parama.bd) });
    }
    parama.ac = ((com.google.android.finsky.stream.a.f)b.a.i.a(this.aB.C(), "Cannot return null from a non-@Nullable component method"));
    parama.ae = b.a.c.b(this.L);
    parama.ag = ((com.google.android.finsky.da.g)b.a.i.a(this.aB.aT(), "Cannot return null from a non-@Nullable component method"));
    parama.ah = ((com.google.android.finsky.notification.c)b.a.i.a(this.aB.ax(), "Cannot return null from a non-@Nullable component method"));
    parama.a = ((com.google.android.finsky.accounts.c)b.a.i.a(this.aB.d(), "Cannot return null from a non-@Nullable component method"));
    parama.ad = ((com.google.android.finsky.dfemodel.h)b.a.i.a(this.aB.o(), "Cannot return null from a non-@Nullable component method"));
    parama.ai = ((com.google.android.finsky.stream.a.w)b.a.i.a(this.aB.D(), "Cannot return null from a non-@Nullable component method"));
    parama.af = b.a.c.b(this.aC);
    parama.c = b.a.c.b(this.aG);
  }
  
  public final void a(com.google.android.finsky.notificationsettings.e parame)
  {
    parame.d = ((com.google.android.finsky.e.a)b.a.i.a(this.aB.h(), "Cannot return null from a non-@Nullable component method"));
    parame.ac = ((com.google.android.finsky.w.d)b.a.i.a(this.aB.aM(), "Cannot return null from a non-@Nullable component method"));
    parame.ab = ((com.google.android.finsky.navigationmanager.c)this.aC.a());
    parame.ae = ((com.google.android.finsky.accounts.c)b.a.i.a(this.aB.d(), "Cannot return null from a non-@Nullable component method"));
    parame.ag = ((com.google.android.finsky.fd.a)b.a.i.a(this.aB.E(), "Cannot return null from a non-@Nullable component method"));
    parame.af = ((com.google.android.finsky.recoverymode.a)b.a.i.a(this.aB.aj(), "Cannot return null from a non-@Nullable component method"));
  }
  
  public final com.google.android.finsky.navigationmanager.c aa_()
  {
    return (com.google.android.finsky.navigationmanager.c)this.aC.a();
  }
  
  public final Context ab()
  {
    return (Context)b.a.i.a(this.aB.ab(), "Cannot return null from a non-@Nullable component method");
  }
  
  public final com.google.android.play.dfe.api.g ac()
  {
    return (com.google.android.play.dfe.api.g)b.a.i.a(this.aB.ac(), "Cannot return null from a non-@Nullable component method");
  }
  
  public final com.google.android.finsky.dj.a b()
  {
    return (com.google.android.finsky.dj.a)this.aP.a();
  }
  
  public final com.google.android.finsky.pagesystem.g c()
  {
    return (com.google.android.finsky.pagesystem.g)this.aQ.a();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cs/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */