package com.tencent.mm.u;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.z;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.e.f;
import com.tencent.mm.kernel.h.a;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.aav;
import com.tencent.mm.protocal.c.abk;
import com.tencent.mm.protocal.c.ack;
import com.tencent.mm.protocal.c.acn;
import com.tencent.mm.protocal.c.acr;
import com.tencent.mm.protocal.c.aia;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.bjf;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.protocal.c.ll;
import com.tencent.mm.protocal.c.os;
import com.tencent.mm.protocal.c.po;
import com.tencent.mm.protocal.c.pp;
import com.tencent.mm.protocal.c.ww;
import com.tencent.mm.protocal.j.a;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.m.a;
import com.tencent.mm.protocal.p.a;
import com.tencent.mm.protocal.q.a;
import com.tencent.mm.protocal.s.a;
import com.tencent.mm.protocal.t.a;
import com.tencent.mm.protocal.u.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.as.a;
import com.tencent.mm.storage.as.b;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.j;
import com.tencent.mm.storage.l;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.x;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.d.c;
import com.tencent.mm.y.n.a;
import java.util.List;
import junit.framework.Assert;

public final class ap
{
  private static ap hlG;
  public final ae hlF;
  private com.tencent.mm.compatible.b.e hlH;
  public bn hlI;
  private final int hlJ;
  final c.a hlK;
  bq hlL;
  bj hlM;
  e hlN;
  bs hlO;
  r hlP;
  ar.a hlQ;
  as.a hlR;
  as.a hlS;
  f hlT;
  public final c hlx;
  
  static
  {
    GMTrace.i(663304011776L, 4942);
    hlG = null;
    GMTrace.o(663304011776L, 4942);
  }
  
  private ap(ae paramae, n.a parama)
  {
    GMTrace.i(659948568576L, 4917);
    this.hlH = null;
    this.hlI = null;
    this.hlJ = 1;
    this.hlL = new bq();
    this.hlM = new bj();
    this.hlN = new e();
    this.hlO = new bs();
    this.hlP = new r();
    this.hlQ = new ar.a()
    {
      public final void a(ar paramAnonymousar, x paramAnonymousx)
      {
        GMTrace.i(647600537600L, 4825);
        String str = paramAnonymousx.field_username;
        if (x.eO(paramAnonymousx.field_username)) {
          paramAnonymousx.setUsername(x.QQ(paramAnonymousx.field_username));
        }
        if (bf.mA(paramAnonymousx.pB())) {
          paramAnonymousx.bS(com.tencent.mm.platformtools.c.mr(paramAnonymousx.field_nickname));
        }
        if (bf.mA(paramAnonymousx.pC())) {
          paramAnonymousx.bT(com.tencent.mm.platformtools.c.mq(paramAnonymousx.field_nickname));
        }
        if (bf.mA(paramAnonymousx.field_conRemarkPYShort)) {
          paramAnonymousx.bW(com.tencent.mm.platformtools.c.mr(paramAnonymousx.field_conRemark));
        }
        if (bf.mA(paramAnonymousx.field_conRemarkPYFull)) {
          paramAnonymousx.bV(com.tencent.mm.platformtools.c.mq(paramAnonymousx.field_conRemark));
        }
        if (o.d(paramAnonymousx))
        {
          paramAnonymousx.dc(43);
          paramAnonymousx.bS(com.tencent.mm.platformtools.c.mr(paramAnonymousx.tK()));
          paramAnonymousx.bT(com.tencent.mm.platformtools.c.mq(paramAnonymousx.tK()));
          paramAnonymousx.bV(com.tencent.mm.platformtools.c.mq(paramAnonymousx.tL()));
          paramAnonymousx.bW(paramAnonymousx.tL());
          GMTrace.o(647600537600L, 4825);
          return;
        }
        if (o.fE(str))
        {
          paramAnonymousx.tc();
          paramAnonymousx.dh(4);
          paramAnonymousx.dc(33);
          if (paramAnonymousx != null) {
            break label345;
          }
        }
        label345:
        for (paramAnonymousar = new x();; paramAnonymousar = paramAnonymousx)
        {
          paramAnonymousar.setUsername(str);
          paramAnonymousar.tc();
          v.x(paramAnonymousar);
          paramAnonymousar.tl();
          if (paramAnonymousx.tC()) {
            paramAnonymousx.dc(paramAnonymousx.sZ());
          }
          if (o.fu(str))
          {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MMCore", "update official account helper showhead %d", new Object[] { Integer.valueOf(31) });
            paramAnonymousx.dc(31);
          }
          if (paramAnonymousx.tA())
          {
            ap.yY();
            c.wW().e(new String[] { str }, "@blacklist");
          }
          com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MMCore", "onPreInsertContact2: %s, %s", new Object[] { paramAnonymousx.field_username, paramAnonymousx.pB() });
          GMTrace.o(647600537600L, 4825);
          return;
        }
      }
    };
    this.hlR = new as.a()
    {
      public final void a(com.tencent.mm.storage.ae paramAnonymousae, as paramAnonymousas)
      {
        GMTrace.i(629615362048L, 4691);
        if (paramAnonymousae == null)
        {
          GMTrace.o(629615362048L, 4691);
          return;
        }
        if ((!x.QL(paramAnonymousae.field_username)) && (!x.QN(paramAnonymousae.field_username)) && (!x.eO(paramAnonymousae.field_username)) && (!o.eV(paramAnonymousae.field_username)))
        {
          GMTrace.o(629615362048L, 4691);
          return;
        }
        if (x.eO(paramAnonymousae.field_username))
        {
          paramAnonymousae = paramAnonymousas.Rl("floatbottle");
          if (paramAnonymousae != null) {
            break label932;
          }
          paramAnonymousae = new com.tencent.mm.storage.ae("floatbottle");
        }
        label887:
        label927:
        label932:
        for (int i = 1;; i = 0)
        {
          paramAnonymousae.du(1);
          paramAnonymousae.dt(h.xI());
          ap.yY();
          Object localObject1 = c.wT().Ai(" and not ( type = 10000 and isSend != 2 ) ");
          Object localObject2;
          Object localObject3;
          PString localPString;
          Object localObject4;
          if ((localObject1 != null) && (((ce)localObject1).field_msgId > 0L))
          {
            paramAnonymousae.W((au)localObject1);
            paramAnonymousae.setContent(x.QQ(((ce)localObject1).field_talker) + ":" + ((ce)localObject1).field_content);
            paramAnonymousae.ct(Integer.toString(((ce)localObject1).field_type));
            localObject2 = paramAnonymousas.oG();
            if (localObject2 != null)
            {
              localObject3 = new PString();
              localPString = new PString();
              localObject4 = new PInt();
              ((au)localObject1).cH("floatbottle");
              ((au)localObject1).setContent(paramAnonymousae.field_content);
              ((as.b)localObject2).a((au)localObject1, (PString)localObject3, localPString, (PInt)localObject4, false);
              paramAnonymousae.cu(((PString)localObject3).value);
              paramAnonymousae.cv(localPString.value);
              paramAnonymousae.dx(((PInt)localObject4).value);
            }
          }
          while (i != 0)
          {
            paramAnonymousas.d(paramAnonymousae);
            GMTrace.o(629615362048L, 4691);
            return;
            paramAnonymousae.bLr();
          }
          paramAnonymousas.a(paramAnonymousae, paramAnonymousae.field_username);
          GMTrace.o(629615362048L, 4691);
          return;
          if ((x.QL(paramAnonymousae.field_username)) || (x.QN(paramAnonymousae.field_username)))
          {
            GMTrace.o(629615362048L, 4691);
            return;
          }
          if ((o.eV(paramAnonymousae.field_username)) && (!bf.mA(paramAnonymousae.field_parentRef)))
          {
            localObject1 = paramAnonymousas.Rl(paramAnonymousae.field_parentRef);
            com.tencent.mm.sdk.platformtools.v.v("MicroMsg.MMCore", "postConvExt, username = %s, parentRef = %s", new Object[] { paramAnonymousae.field_username, paramAnonymousae.field_parentRef });
            if (paramAnonymousae.field_parentRef.equals("officialaccounts")) {
              break label927;
            }
          }
          for (i = 1;; i = 0)
          {
            if (localObject1 == null)
            {
              localObject1 = new com.tencent.mm.storage.ae(paramAnonymousae.field_parentRef);
              if (i != 0) {
                ((com.tencent.mm.storage.ae)localObject1).eB(2097152);
              }
            }
            for (int j = 1;; j = 0)
            {
              com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MMCore", "enterprise cvs count is %d", new Object[] { Integer.valueOf(((aj)localObject1).field_unReadCount) });
              ap.yY();
              localObject3 = c.wW().Rw(paramAnonymousae.field_parentRef);
              ap.yY();
              localObject2 = c.wT().Ag((String)localObject3);
              if ((localObject2 != null) && (((ce)localObject2).field_msgId > 0L))
              {
                ((com.tencent.mm.storage.ae)localObject1).W((au)localObject2);
                ((com.tencent.mm.storage.ae)localObject1).setContent(((ce)localObject2).field_talker + ":" + ((ce)localObject2).field_content);
                ((com.tencent.mm.storage.ae)localObject1).ct(Integer.toString(((ce)localObject2).field_type));
                localObject3 = paramAnonymousas.oG();
                if (localObject3 != null)
                {
                  localPString = new PString();
                  localObject4 = new PString();
                  PInt localPInt = new PInt();
                  ((au)localObject2).cH(paramAnonymousae.field_parentRef);
                  ((au)localObject2).setContent(((aj)localObject1).field_content);
                  ((as.b)localObject3).a((au)localObject2, localPString, (PString)localObject4, localPInt, true);
                  ((com.tencent.mm.storage.ae)localObject1).cu(localPString.value);
                  ((com.tencent.mm.storage.ae)localObject1).cv(((PString)localObject4).value);
                  ((com.tencent.mm.storage.ae)localObject1).dx(localPInt.value);
                }
                int m = 0;
                int k = m;
                if (i != 0)
                {
                  ap.yY();
                  k = m;
                  if (c.wW().Rv(((aj)localObject1).field_username) <= 0) {
                    k = 1;
                  }
                }
                if (k == 0) {
                  break label887;
                }
                paramAnonymousas.Rk(((aj)localObject1).field_username);
              }
              for (;;)
              {
                if ("@blacklist".equals(paramAnonymousae.field_parentRef))
                {
                  ap.yY();
                  paramAnonymousas = c.wR().Rb(paramAnonymousae.field_username);
                  if ((paramAnonymousas != null) && (!bf.mA(paramAnonymousas.field_username)) && (!paramAnonymousas.tA()))
                  {
                    ap.yY();
                    c.wW().e(new String[] { paramAnonymousae.field_username }, "");
                  }
                }
                GMTrace.o(629615362048L, 4691);
                return;
                ((com.tencent.mm.storage.ae)localObject1).bLr();
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MMCore", "lastOfMsg is null or MsgId <= 0, lastConvBiz is %s", new Object[] { localObject3 });
                break;
                if (j != 0) {
                  paramAnonymousas.d((com.tencent.mm.storage.ae)localObject1);
                } else {
                  paramAnonymousas.a((com.tencent.mm.storage.ae)localObject1, ((aj)localObject1).field_username);
                }
              }
            }
          }
        }
      }
    };
    this.hlS = new as.a()
    {
      public final void a(com.tencent.mm.storage.ae paramAnonymousae, as paramAnonymousas)
      {
        GMTrace.i(693637218304L, 5168);
        if (paramAnonymousae == null)
        {
          GMTrace.o(693637218304L, 5168);
          return;
        }
        GMTrace.o(693637218304L, 5168);
      }
    };
    this.hlT = new f();
    this.hlF = paramae;
    this.hlI = new bn();
    this.hlK = new c.a()
    {
      public final void a(c paramAnonymousc, boolean paramAnonymousBoolean)
      {
        GMTrace.i(638742167552L, 4759);
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MMCore", "summeranrt2 onAccountPostReset tid:%d stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), bf.bJP() });
        paramAnonymousc = ap.this;
        c.wR().a(paramAnonymousc.hlQ);
        c.wW().b(paramAnonymousc.hlS);
        c.wW().a(paramAnonymousc.hlR, null);
        d.c.a(Integer.valueOf(9999), paramAnonymousc.hlL);
        d.c.a(Integer.valueOf(41), paramAnonymousc.hlM);
        d.c.a(Integer.valueOf(21), paramAnonymousc.hlN);
        d.c.a(Integer.valueOf(35), paramAnonymousc.hlN);
        d.c.a(Integer.valueOf(-1879048175), paramAnonymousc.hlO);
        d.c.a(Integer.valueOf(-1879048174), paramAnonymousc.hlP);
        Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension();
        ((bp)localObject).a("addcontact", paramAnonymousc.hlT);
        ((bp)localObject).a("dynacfg", paramAnonymousc.hlT);
        ((bp)localObject).a("dynacfg_split", paramAnonymousc.hlT);
        ((bp)localObject).a("banner", paramAnonymousc.hlT);
        ((bp)localObject).a("midinfo", paramAnonymousc.hlT);
        ((bp)localObject).a("revokemsg", paramAnonymousc.hlT);
        ((bp)localObject).a("clouddelmsg", paramAnonymousc.hlT);
        ((bp)localObject).a("updatepackage", paramAnonymousc.hlT);
        ((bp)localObject).a("deletepackage", paramAnonymousc.hlT);
        ((bp)localObject).a("delchatroommember", paramAnonymousc.hlT);
        ((bp)localObject).a("WakenPush", paramAnonymousc.hlT);
        ((bp)localObject).a("DisasterNotice", paramAnonymousc.hlT);
        ((bp)localObject).a("EmotionKv", paramAnonymousc.hlT);
        ((bp)localObject).a("globalalert", paramAnonymousc.hlT);
        ((bp)localObject).a("yybsigcheck", paramAnonymousc.hlT);
        ((bp)localObject).a("qy_status_notify", paramAnonymousc.hlT);
        ((bp)localObject).a("qy_chat_update", paramAnonymousc.hlT);
        ((bp)localObject).a("bindmobiletip", paramAnonymousc.hlT);
        ((bp)localObject).a("ClientCheckConsistency", paramAnonymousc.hlT);
        ((bp)localObject).a("ClientCheckHook", paramAnonymousc.hlT);
        ((bp)localObject).a("ClientCheckGetAppList", paramAnonymousc.hlT);
        ((bp)localObject).a("ClientCheckGetExtInfo", paramAnonymousc.hlT);
        ((bp)localObject).a("functionmsg", paramAnonymousc.hlT);
        ((bp)localObject).a("paymsg", paramAnonymousc.hlT);
        ap.this.hlI.aM(paramAnonymousBoolean);
        long l1 = System.currentTimeMillis();
        ap.yY();
        long l2 = c.wO().cs(Thread.currentThread().getId());
        if (paramAnonymousBoolean)
        {
          c.wR().Rh("readerapp");
          c.vr().set(256, Boolean.valueOf(true));
          w.yF();
          w.yF();
          paramAnonymousc = c.wR().bLj();
          if (paramAnonymousc.moveToFirst()) {
            do
            {
              localObject = new x();
              ((x)localObject).b(paramAnonymousc);
              ((x)localObject).to();
              c.wR().a(((com.tencent.mm.e.b.af)localObject).field_username, (x)localObject);
            } while (paramAnonymousc.moveToNext());
          }
          paramAnonymousc.close();
          ba.gp("ver" + com.tencent.mm.protocal.d.sXh);
        }
        new v(ap.this.hlx);
        if (paramAnonymousBoolean)
        {
          v.w(c.wR().Rb("filehelper"));
          paramAnonymousc = m.xL();
          if (!bf.mA(paramAnonymousc))
          {
            localObject = c.wR().Rb(paramAnonymousc);
            if ((int)((com.tencent.mm.j.a)localObject).gTG != 0) {
              break label1490;
            }
            ((x)localObject).setUsername(paramAnonymousc);
            ((x)localObject).tc();
            ap.yY();
            c.wR().R((x)localObject);
          }
          v.a(paramAnonymousBoolean, "qqmail", false);
          v.a(paramAnonymousBoolean, "floatbottle", false);
          v.a(paramAnonymousBoolean, "shakeapp", false);
          v.a(paramAnonymousBoolean, "lbsapp", false);
          v.a(paramAnonymousBoolean, "medianote", false);
          v.a(paramAnonymousBoolean, "newsapp", true);
          c.wW().Rk("blogapp");
          c.wT().Am("blogapp");
          c.wR().Rh("blogapp");
          v.a(paramAnonymousBoolean, "facebookapp", true);
          v.a(paramAnonymousBoolean, "qqfriend", false);
          v.a(paramAnonymousBoolean, "masssendapp", true);
          v.a(paramAnonymousBoolean, "feedsapp", true);
          c.wW().Rk("tmessage");
          c.wR().Rh("tmessage");
          x localx = c.wR().Rb("voip");
          localObject = c.wR().Rb("voipapp");
          paramAnonymousc = (c)localObject;
          if (localObject == null) {
            paramAnonymousc = new x();
          }
          if ((localx != null) && ((int)localx.gTG != 0)) {
            c.wR().Rh("voip");
          }
          if ((int)paramAnonymousc.gTG != 0) {
            break label1525;
          }
          paramAnonymousc.setUsername("voipapp");
          paramAnonymousc.tc();
          v.x(paramAnonymousc);
          paramAnonymousc.dh(4);
          paramAnonymousc.tl();
          c.wR().S(paramAnonymousc);
          label938:
          localObject = c.wR().Rb("officialaccounts");
          paramAnonymousc = (c)localObject;
          if (localObject == null) {
            paramAnonymousc = new x();
          }
          com.tencent.mm.sdk.platformtools.v.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)paramAnonymousc.gTG) });
          if ((int)paramAnonymousc.gTG != 0) {
            break label1549;
          }
          paramAnonymousc.setUsername("officialaccounts");
          paramAnonymousc.td();
          v.x(paramAnonymousc);
          paramAnonymousc.dh(3);
          c.wR().S(paramAnonymousc);
          label1036:
          localx = c.wR().Rb("voipaudio");
          localObject = c.wR().Rb("voicevoipapp");
          paramAnonymousc = (c)localObject;
          if (localObject == null) {
            paramAnonymousc = new x();
          }
          if ((localx != null) && ((int)localx.gTG != 0)) {
            c.wR().Rh("voipaudio");
          }
          if ((int)paramAnonymousc.gTG != 0) {
            break label1582;
          }
          paramAnonymousc.setUsername("voicevoipapp");
          paramAnonymousc.tc();
          v.x(paramAnonymousc);
          paramAnonymousc.dh(4);
          paramAnonymousc.tl();
          c.wR().S(paramAnonymousc);
          label1146:
          v.a(paramAnonymousBoolean, "voiceinputapp", false);
          v.a(paramAnonymousBoolean, "linkedinplugin", false);
          localObject = c.wR().Rb("notifymessage");
          paramAnonymousc = (c)localObject;
          if (localObject == null) {
            paramAnonymousc = new x();
          }
          com.tencent.mm.sdk.platformtools.v.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)paramAnonymousc.gTG) });
          if ((int)paramAnonymousc.gTG != 0) {
            break label1606;
          }
          paramAnonymousc.setUsername("notifymessage");
          paramAnonymousc.td();
          v.x(paramAnonymousc);
          paramAnonymousc.dh(3);
          c.wR().S(paramAnonymousc);
          label1262:
          localObject = c.wR().Rb("appbrandcustomerservicemsg");
          paramAnonymousc = (c)localObject;
          if (localObject == null) {
            paramAnonymousc = new x();
          }
          com.tencent.mm.sdk.platformtools.v.i("MicroMsg.HardCodeHelper", "hardcodeAppBrandServiceMessage:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)paramAnonymousc.gTG) });
          if ((int)paramAnonymousc.gTG != 0) {
            break label1639;
          }
          paramAnonymousc.setUsername("appbrandcustomerservicemsg");
          paramAnonymousc.td();
          v.x(paramAnonymousc);
          paramAnonymousc.setType(0);
          paramAnonymousc.dh(3);
          c.wR().S(paramAnonymousc);
        }
        for (;;)
        {
          if (paramAnonymousBoolean)
          {
            ap.yY();
            c.wW().Rk("Weixin");
            ap.yY();
            c.wR().Rh("Weixin");
          }
          ap.yY();
          c.wO().aD(l2);
          com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MMCore", "summeranrt dkwt set forceManual :%b, tid[%d], take[%s]ms, stack[%s]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - l1), bf.bJP() });
          c.wW().a(ap.yU().hlF.oG());
          GMTrace.o(638742167552L, 4759);
          return;
          label1490:
          if (com.tencent.mm.j.a.ez(((com.tencent.mm.e.b.af)localObject).field_type)) {
            break;
          }
          ((x)localObject).tc();
          ap.yY();
          c.wR().a(paramAnonymousc, (x)localObject);
          break;
          label1525:
          if (!paramAnonymousBoolean) {
            break label938;
          }
          paramAnonymousc.tl();
          c.wR().a("voipapp", paramAnonymousc);
          break label938;
          label1549:
          if (!paramAnonymousBoolean) {
            break label1036;
          }
          com.tencent.mm.sdk.platformtools.v.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
          paramAnonymousc.td();
          c.wR().a("officialaccounts", paramAnonymousc);
          break label1036;
          label1582:
          if (!paramAnonymousBoolean) {
            break label1146;
          }
          paramAnonymousc.tl();
          c.wR().a("voicevoipapp", paramAnonymousc);
          break label1146;
          label1606:
          if (!paramAnonymousBoolean) {
            break label1262;
          }
          com.tencent.mm.sdk.platformtools.v.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
          paramAnonymousc.td();
          c.wR().a("notifymessage", paramAnonymousc);
          break label1262;
          label1639:
          if (paramAnonymousBoolean)
          {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.HardCodeHelper", "do update app brand service message accunt");
            paramAnonymousc.td();
            c.wR().a("appbrandcustomerservicemsg", paramAnonymousc);
          }
        }
      }
      
      public final void aN(boolean paramAnonymousBoolean)
      {
        GMTrace.i(638876385280L, 4760);
        ap.this.hlI.aN(paramAnonymousBoolean);
        GMTrace.o(638876385280L, 4760);
      }
      
      public final void xH()
      {
        GMTrace.i(638607949824L, 4758);
        d.c.aA(Integer.valueOf(9999));
        d.c.aA(Integer.valueOf(41));
        d.c.aA(Integer.valueOf(21));
        d.c.aA(Integer.valueOf(35));
        d.c.aA(Integer.valueOf(-1879048175));
        d.c.aA(Integer.valueOf(-1879048174));
        ap.this.hlI.zQ();
        GMTrace.o(638607949824L, 4758);
      }
    };
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vI().a(new com.tencent.mm.kernel.api.e()
    {
      public final void onDataBaseClosed(com.tencent.mm.bj.g paramAnonymousg1, com.tencent.mm.bj.g paramAnonymousg2)
      {
        GMTrace.i(639681691648L, 4766);
        GMTrace.o(639681691648L, 4766);
      }
      
      public final void onDataBaseOpened(com.tencent.mm.bj.g paramAnonymousg1, com.tencent.mm.bj.g paramAnonymousg2)
      {
        GMTrace.i(639279038464L, 4763);
        ap.this.hlK.xH();
        GMTrace.o(639279038464L, 4763);
      }
    });
    paramae = com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.api.c local3 = new com.tencent.mm.kernel.api.c()
    {
      public final void onAccountInitialized(e.f paramAnonymousf)
      {
        GMTrace.i(595926712320L, 4440);
        com.tencent.mm.plugin.report.service.g.oSF.a(598L, 13L, 1L, false);
        long l = System.currentTimeMillis();
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized start tid[%d]", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
        c localc = ap.this.hlx;
        com.tencent.mm.bj.g localg = com.tencent.mm.kernel.h.vI().gXW;
        Object localObject = com.tencent.mm.kernel.h.vI().gXX;
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ();
        ((com.tencent.mm.plugin.messenger.foundation.a.a.c)localObject).a(new am((com.tencent.mm.plugin.messenger.foundation.a.a.c)localObject));
        com.tencent.mm.storage.h localh = new com.tencent.mm.storage.h((com.tencent.mm.plugin.messenger.foundation.a.a.c)localObject);
        localc.hku = localh;
        ((com.tencent.mm.plugin.messenger.foundation.a.a.c)localObject).a(localh);
        localc.hks = new bi(localg, ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW());
        localc.hkt = new bh(localg, ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR());
        localc.hkv = new com.tencent.mm.u.b.c();
        localc.hkw = new com.tencent.mm.u.b.d();
        localc.hkB = new com.tencent.mm.u.b.b();
        localc.hkx = new com.tencent.mm.storage.ap(localg);
        localc.hky = new j(localg);
        localc.hkz = new com.tencent.mm.storage.n(localg);
        localc.hkA = new l(localg);
        com.tencent.mm.plugin.report.service.g.oSF.a(598L, 14L, 1L, false);
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done initDB take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        ap.this.hlK.a(ap.this.hlx, paramAnonymousf.gYp);
        com.tencent.mm.plugin.report.service.g.oSF.a(598L, 15L, 1L, false);
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done onAccountPostReset take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        ap.this.hlK.aN(com.tencent.mm.compatible.util.f.rZ());
        com.tencent.mm.plugin.report.service.g.oSF.a(598L, 16L, 1L, false);
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done all take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        GMTrace.o(595926712320L, 4440);
      }
      
      public final void onAccountRelease()
      {
        GMTrace.i(596060930048L, 4441);
        ap.yR().zR();
        GMTrace.o(596060930048L, 4441);
      }
    };
    paramae.gYF.bI(local3);
    com.tencent.mm.kernel.h.vJ().gYG.bI(parama);
    this.hlx = new c();
    com.tencent.mm.plugin.report.service.g.oSF.a(99L, 142L, 1L, false);
    com.tencent.mm.y.r.a(new com.tencent.mm.plugin.zero.a.e()
    {
      public final byte[] a(k.d paramAnonymousd, int paramAnonymousInt)
      {
        GMTrace.i(599147937792L, 4464);
        switch (paramAnonymousInt)
        {
        default: 
          GMTrace.o(599147937792L, 4464);
          return null;
        case 722: 
          paramAnonymousd = ((q.a)paramAnonymousd).sYk.tua.thY.tXD.toByteArray();
          GMTrace.o(599147937792L, 4464);
          return paramAnonymousd;
        case 145: 
          paramAnonymousd = ((m.a)paramAnonymousd).sYa.thY.tXD.toByteArray();
          GMTrace.o(599147937792L, 4464);
          return paramAnonymousd;
        case 107: 
          paramAnonymousd = ((u.a)paramAnonymousd).sYt.thY.tXD.toByteArray();
          GMTrace.o(599147937792L, 4464);
          return paramAnonymousd;
        case 429: 
          paramAnonymousd = ((t.a)paramAnonymousd).sYr.thY.tXD.toByteArray();
          GMTrace.o(599147937792L, 4464);
          return paramAnonymousd;
        case 499: 
          paramAnonymousd = ((com.tencent.mm.plugin.report.b.c.a)paramAnonymousd).oRL.thY.tXD.toByteArray();
          GMTrace.o(599147937792L, 4464);
          return paramAnonymousd;
        case 694: 
          paramAnonymousd = ((com.tencent.mm.plugin.report.b.b.a)paramAnonymousd).oRL.thY.tXD.toByteArray();
          GMTrace.o(599147937792L, 4464);
          return paramAnonymousd;
        case 989: 
          paramAnonymousd = ((ww)((b.b)paramAnonymousd).hsa).tqc.toByteArray();
          GMTrace.o(599147937792L, 4464);
          return paramAnonymousd;
        case 987: 
        case 997: 
          paramAnonymousd = ((ll)((b.b)paramAnonymousd).hsa).tqc.toByteArray();
          GMTrace.o(599147937792L, 4464);
          return paramAnonymousd;
        case 481: 
          paramAnonymousd = ((p.a)paramAnonymousd).sYi.thY.tXD.toByteArray();
          GMTrace.o(599147937792L, 4464);
          return paramAnonymousd;
        case 572: 
          paramAnonymousd = ((s.a)paramAnonymousd).sYq.thY.tXD.toByteArray();
          GMTrace.o(599147937792L, 4464);
          return paramAnonymousd;
        case 616: 
          paramAnonymousd = ((at.a)paramAnonymousd).hmb.thY.tXD.toByteArray();
          GMTrace.o(599147937792L, 4464);
          return paramAnonymousd;
        case 617: 
          paramAnonymousd = ((av.a)paramAnonymousd).hmf.thY.tXD.toByteArray();
          GMTrace.o(599147937792L, 4464);
          return paramAnonymousd;
        case 618: 
          paramAnonymousd = ((au.a)paramAnonymousd).hmd.thY.tXD.toByteArray();
          GMTrace.o(599147937792L, 4464);
          return paramAnonymousd;
        }
        paramAnonymousd = ((j.a)paramAnonymousd).sXK;
        GMTrace.o(599147937792L, 4464);
        return paramAnonymousd;
      }
    });
    com.tencent.mm.kernel.h.vJ();
    paramae = com.tencent.mm.kernel.h.vH();
    parama = new com.tencent.mm.kernel.api.d()
    {
      public final void b(com.tencent.mm.network.e paramAnonymouse)
      {
        GMTrace.i(617133113344L, 4598);
        p.e(paramAnonymouse);
        p.f(paramAnonymouse);
        GMTrace.o(617133113344L, 4598);
      }
    };
    paramae.gXr.bI(parama);
    GMTrace.o(659948568576L, 4917);
  }
  
  public static void a(com.tencent.mm.network.m paramm)
  {
    GMTrace.i(658069520384L, 4903);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vH().a(paramm);
    GMTrace.o(658069520384L, 4903);
  }
  
  public static void a(ac paramac)
  {
    GMTrace.i(658874826752L, 4909);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.h.vI();
    synchronized (locale.gXT)
    {
      locale.gXT.add(paramac);
      GMTrace.o(658874826752L, 4909);
      return;
    }
  }
  
  public static void a(ad paramad)
  {
    GMTrace.i(658337955840L, 4905);
    com.tencent.mm.kernel.b.a(paramad);
    GMTrace.o(658337955840L, 4905);
  }
  
  public static void a(ae paramae, n.a parama)
  {
    GMTrace.i(659411697664L, 4913);
    hlG = new ap(paramae, parama);
    com.tencent.mm.modelstat.n.bl(aa.getContext());
    GMTrace.o(659411697664L, 4913);
  }
  
  public static void aT(boolean paramBoolean)
  {
    GMTrace.i(659143262208L, 4911);
    com.tencent.mm.kernel.a.aQ(paramBoolean);
    GMTrace.o(659143262208L, 4911);
  }
  
  public static void b(com.tencent.mm.network.m paramm)
  {
    GMTrace.i(658203738112L, 4904);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vH().b(paramm);
    GMTrace.o(658203738112L, 4904);
  }
  
  public static void eb(String paramString)
  {
    GMTrace.i(658472173568L, 4906);
    com.tencent.mm.kernel.a.eb(paramString);
    GMTrace.o(658472173568L, 4906);
  }
  
  public static int ec(String paramString)
  {
    GMTrace.i(661022310400L, 4925);
    int i = com.tencent.mm.kernel.a.ec(paramString);
    GMTrace.o(661022310400L, 4925);
    return i;
  }
  
  public static af getNotification()
  {
    GMTrace.i(659545915392L, 4914);
    af localaf = yU().hlF.getNotification();
    GMTrace.o(659545915392L, 4914);
    return localaf;
  }
  
  public static bp getSysCmdMsgExtension()
  {
    GMTrace.i(660619657216L, 4922);
    bp localbp = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension();
    GMTrace.o(660619657216L, 4922);
    return localbp;
  }
  
  public static void hold()
  {
    GMTrace.i(662096052224L, 4933);
    com.tencent.mm.kernel.a.hold();
    GMTrace.o(662096052224L, 4933);
  }
  
  public static y oH()
  {
    GMTrace.i(659680133120L, 4915);
    y localy = yU().hlF.oH();
    GMTrace.o(659680133120L, 4915);
    return localy;
  }
  
  public static String uI()
  {
    GMTrace.i(662364487680L, 4935);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vG();
    String str = com.tencent.mm.kernel.a.uI();
    GMTrace.o(662364487680L, 4935);
    return str;
  }
  
  public static boolean uP()
  {
    GMTrace.i(661961834496L, 4932);
    boolean bool = com.tencent.mm.kernel.a.uP();
    GMTrace.o(661961834496L, 4932);
    return bool;
  }
  
  public static String uY()
  {
    GMTrace.i(660753874944L, 4923);
    String str = com.tencent.mm.kernel.a.uY();
    GMTrace.o(660753874944L, 4923);
    return str;
  }
  
  public static void uZ()
  {
    GMTrace.i(660888092672L, 4924);
    com.tencent.mm.kernel.a.uZ();
    GMTrace.o(660888092672L, 4924);
  }
  
  public static void unhold()
  {
    GMTrace.i(662230269952L, 4934);
    com.tencent.mm.kernel.a.unhold();
    GMTrace.o(662230269952L, 4934);
  }
  
  public static br vK()
  {
    GMTrace.i(658740609024L, 4908);
    yU();
    br localbr = com.tencent.mm.kernel.h.vK();
    GMTrace.o(658740609024L, 4908);
    return localbr;
  }
  
  public static com.tencent.mm.sdk.platformtools.ae vL()
  {
    GMTrace.i(660485439488L, 4921);
    com.tencent.mm.sdk.platformtools.ae localae = com.tencent.mm.kernel.h.vL();
    GMTrace.o(660485439488L, 4921);
    return localae;
  }
  
  public static byte[] vc()
  {
    GMTrace.i(659277479936L, 4912);
    try
    {
      com.tencent.mm.kernel.h.vJ();
      byte[] arrayOfByte = com.tencent.mm.kernel.h.vH().vc();
      GMTrace.o(659277479936L, 4912);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.v.w("MicroMsg.MMCore", "get session key error, %s", new Object[] { localException.getMessage() });
      com.tencent.mm.sdk.platformtools.v.e("MicroMsg.MMCore", "exception:%s", new Object[] { bf.g(localException) });
      GMTrace.o(659277479936L, 4912);
    }
    return null;
  }
  
  public static com.tencent.mm.y.n vd()
  {
    GMTrace.i(661424963584L, 4928);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.y.n localn = com.tencent.mm.kernel.h.vH().gXs;
    GMTrace.o(661424963584L, 4928);
    return localn;
  }
  
  public static boolean yQ()
  {
    GMTrace.i(657666867200L, 4900);
    if (hlG == null)
    {
      GMTrace.o(657666867200L, 4900);
      return true;
    }
    GMTrace.o(657666867200L, 4900);
    return false;
  }
  
  public static bn yR()
  {
    GMTrace.i(658606391296L, 4907);
    bn localbn = yU().hlI;
    GMTrace.o(658606391296L, 4907);
    return localbn;
  }
  
  public static boolean yS()
  {
    GMTrace.i(659009044480L, 4910);
    boolean bool = com.tencent.mm.kernel.a.uO();
    GMTrace.o(659009044480L, 4910);
    return bool;
  }
  
  public static c.a yT()
  {
    GMTrace.i(659814350848L, 4916);
    c.a locala = yU().hlK;
    GMTrace.o(659814350848L, 4916);
    return locala;
  }
  
  public static ap yU()
  {
    GMTrace.i(660082786304L, 4918);
    Assert.assertNotNull("MMCore not initialized by MMApplication", hlG);
    ap localap = hlG;
    GMTrace.o(660082786304L, 4918);
    return localap;
  }
  
  public static com.tencent.mm.y.v yV()
  {
    GMTrace.i(660217004032L, 4919);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.y.v localv = com.tencent.mm.kernel.h.vG().gWS;
    GMTrace.o(660217004032L, 4919);
    return localv;
  }
  
  public static s yW()
  {
    GMTrace.i(660351221760L, 4920);
    com.tencent.mm.kernel.h.vJ();
    s locals = com.tencent.mm.kernel.h.vI().gXM;
    GMTrace.o(660351221760L, 4920);
    return locals;
  }
  
  public static void yX()
  {
    GMTrace.i(661156528128L, 4926);
    z localz = new z();
    com.tencent.mm.sdk.b.a.uql.m(localz);
    GMTrace.o(661156528128L, 4926);
  }
  
  public static c yY()
  {
    GMTrace.i(661290745856L, 4927);
    c localc = yU().hlx;
    if (localc != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("MMCore has not been initialize ?", bool);
      GMTrace.o(661290745856L, 4927);
      return localc;
    }
  }
  
  public static com.tencent.mm.compatible.b.e yZ()
  {
    GMTrace.i(661559181312L, 4929);
    com.tencent.mm.compatible.b.e locale = com.tencent.mm.compatible.b.e.qE();
    GMTrace.o(661559181312L, 4929);
    return locale;
  }
  
  public static boolean za()
  {
    GMTrace.i(661693399040L, 4930);
    com.tencent.mm.kernel.h.vG();
    boolean bool = com.tencent.mm.kernel.a.uU();
    GMTrace.o(661693399040L, 4930);
    return bool;
  }
  
  public static boolean zb()
  {
    GMTrace.i(661827616768L, 4931);
    if (!aa.bIR())
    {
      GMTrace.o(661827616768L, 4931);
      return false;
    }
    boolean bool = com.tencent.mm.kernel.h.vG().uV();
    GMTrace.o(661827616768L, 4931);
    return bool;
  }
  
  public static f zc()
  {
    GMTrace.i(14456859918336L, 107712);
    f localf = yU().hlT;
    GMTrace.o(14456859918336L, 107712);
    return localf;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */