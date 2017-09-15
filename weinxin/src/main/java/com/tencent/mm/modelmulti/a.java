package com.tencent.mm.modelmulti;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.jh;
import com.tencent.mm.e.a.lh;
import com.tencent.mm.e.a.nf;
import com.tencent.mm.e.a.qh;
import com.tencent.mm.e.a.qz;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.agc;
import com.tencent.mm.protocal.c.ajg;
import com.tencent.mm.protocal.c.alt;
import com.tencent.mm.protocal.c.alw;
import com.tencent.mm.protocal.c.amb;
import com.tencent.mm.protocal.c.aml;
import com.tencent.mm.protocal.c.ams;
import com.tencent.mm.protocal.c.anh;
import com.tencent.mm.protocal.c.apa;
import com.tencent.mm.protocal.c.asd;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.bcl;
import com.tencent.mm.protocal.c.bei;
import com.tencent.mm.protocal.c.bih;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.protocal.c.bv;
import com.tencent.mm.protocal.c.lt;
import com.tencent.mm.protocal.c.mx;
import com.tencent.mm.protocal.c.st;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.as.b;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.aa;
import com.tencent.mm.u.ag.a;
import com.tencent.mm.u.ag.b;
import com.tencent.mm.u.ag.b.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.o;
import com.tencent.mm.x.e.b;
import com.tencent.mm.x.h;
import com.tencent.mm.x.i;
import java.util.Map;
import junit.framework.Assert;

public final class a
  implements p
{
  public a()
  {
    GMTrace.i(407619239936L, 3037);
    GMTrace.o(407619239936L, 3037);
  }
  
  public static boolean a(x paramx)
  {
    GMTrace.i(407887675392L, 3039);
    if ((paramx == null) || (bf.mA(paramx.field_username)))
    {
      if (paramx == null) {}
      for (paramx = "-1";; paramx = paramx.field_username)
      {
        v.w("MicroMsg.BigBallOfMudSyncExtension", "dealModContactExtInfo username:%s ", new Object[] { paramx });
        GMTrace.o(407887675392L, 3039);
        return false;
      }
    }
    ap.yY();
    Object localObject = com.tencent.mm.u.c.wR().Rf(paramx.field_username);
    if (bf.bm((byte[])localObject))
    {
      paramx = paramx.field_username;
      if (localObject == null) {}
      for (int i = -1;; i = localObject.length)
      {
        v.w("MicroMsg.BigBallOfMudSyncExtension", "dealModContactExtInfo username:%s  buf:%d", new Object[] { paramx, Integer.valueOf(i) });
        GMTrace.o(407887675392L, 3039);
        return false;
      }
    }
    try
    {
      localObject = (amb)new amb().aD((byte[])localObject);
      ap.yY();
      com.tencent.mm.u.c.wR().Rg(paramx.field_username);
      if (localObject == null)
      {
        v.e("MicroMsg.BigBallOfMudSyncExtension", "dkinit dealModContactExtInfo failed parse buf failed.");
        GMTrace.o(407887675392L, 3039);
        return false;
      }
    }
    catch (Exception localException)
    {
      amb localamb;
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", localException, "", new Object[0]);
        localamb = null;
      }
      boolean bool = com.tencent.mm.plugin.bbom.c.a(paramx, localamb, false);
      GMTrace.o(407887675392L, 3039);
      return bool;
    }
  }
  
  public final void a(bv parambv, com.tencent.mm.plugin.messenger.foundation.a.r paramr)
  {
    GMTrace.i(408021893120L, 3040);
    final String str = com.tencent.mm.platformtools.n.a(parambv.tdG);
    long l = parambv.tdE;
    int i = parambv.ofk;
    int m = parambv.tdJ;
    int n = parambv.tdF;
    int j = parambv.mrC;
    int k = parambv.tdH;
    Object localObject2 = com.tencent.mm.platformtools.n.a(parambv.tdI);
    v.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList chatRoomId[%s], newMsgId[%d], createTime[%d], isActed[%d], msgseq[%d], msgType[%d], unDeliverCount[%d], content[%s]", new Object[] { str, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(k), bf.Qi((String)localObject2) });
    if (bf.mA(str)) {
      v.e("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList chatRoomId is null and ret");
    }
    if (k == 0)
    {
      com.tencent.mm.plugin.report.c.oRz.a(403L, 24L, 1L, false);
      if (bf.ap(ay.gi((String)localObject2), "").equals(com.tencent.mm.u.m.xL()))
      {
        ap.yY();
        localObject1 = com.tencent.mm.u.c.wT().x(str, l);
        if ((((ce)localObject1).field_msgId > 0L) && (((ce)localObject1).field_isSend == 1))
        {
          v.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList self send msg[%d] createtime[%d, %d] svrid[%d, %d] seq[%d, %d]", new Object[] { Long.valueOf(((ce)localObject1).field_msgId), Long.valueOf(((ce)localObject1).field_createTime), Integer.valueOf(i), Long.valueOf(((ce)localObject1).field_msgSvrId), Long.valueOf(l), Long.valueOf(((ce)localObject1).field_msgSeq), Integer.valueOf(n) });
          if (((ce)localObject1).field_msgSeq == 0L)
          {
            com.tencent.mm.plugin.report.c.oRz.a(403L, 25L, 1L, false);
            ((au)localObject1).B(n);
            ap.yY();
            com.tencent.mm.u.c.wT().a(((ce)localObject1).field_msgId, (au)localObject1);
          }
          GMTrace.o(408021893120L, 3040);
          return;
        }
      }
    }
    ap.yY();
    final Object localObject1 = com.tencent.mm.u.c.wW().Rl(str);
    au localau;
    Object localObject3;
    label575:
    Object localObject4;
    if (localObject1 == null)
    {
      com.tencent.mm.plugin.report.c.oRz.a(403L, 22L, 1L, false);
      localObject1 = new ae(str);
      ((ae)localObject1).s(i * 1000L);
      ((ae)localObject1).u(n);
      ((ae)localObject1).dt(k);
      ((ae)localObject1).dB(k);
      if (k < 2)
      {
        ((ae)localObject1).v(n);
        i = 1;
        if (m > 0) {
          ((ae)localObject1).dz(((aj)localObject1).field_atCount + m);
        }
        localau = new au();
        localau.dw(0);
        localau.cH(str);
        localau.setType(j);
        localau.setContent((String)localObject2);
        if (j != 49) {
          break label1649;
        }
        localObject3 = f.a.ek(j.el(str, (String)localObject2));
        localau.setType(l.d((f.a)localObject3));
        if ((localau.bLN()) || (localau.bLO())) {
          localObject2 = ((f.a)localObject3).content;
        }
        localau.setContent((String)localObject2);
        ((ae)localObject1).dw(0);
        ((ae)localObject1).setContent(localau.field_content);
        ((ae)localObject1).ct(Integer.toString(localau.field_type));
        ap.yY();
        localObject2 = com.tencent.mm.u.c.wW().oG();
        if (localObject2 == null) {
          break label1981;
        }
        localObject3 = new PString();
        localObject4 = new PString();
        PInt localPInt = new PInt();
        ((as.b)localObject2).a(localau, (PString)localObject3, (PString)localObject4, localPInt, false);
        ((ae)localObject1).cu(((PString)localObject3).value);
        ((ae)localObject1).cv(((PString)localObject4).value);
        ((ae)localObject1).dx(localPInt.value);
        if (localau.field_type == 49)
        {
          localObject2 = (String)bg.q(((aj)localObject1).field_content, "msg").get(".msg.appmsg.title");
          localObject3 = bf.mz(((aj)localObject1).field_digest);
          if (!bf.mA((String)localObject2)) {
            break label1955;
          }
          localObject2 = "";
          label752:
          ((ae)localObject1).cu(((String)localObject3).concat((String)localObject2));
        }
        label764:
        if (i == 0) {
          break label1994;
        }
        ap.yY();
        v.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr, processAddMsgDigestList insert username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", new Object[] { str, Long.valueOf(com.tencent.mm.u.c.wW().d((ae)localObject1)), Long.valueOf(((aj)localObject1).field_firstUnDeliverSeq), Long.valueOf(((aj)localObject1).field_lastSeq), Integer.valueOf(((aj)localObject1).field_UnDeliverCount) });
      }
    }
    for (;;)
    {
      ap.yY();
      localObject1 = com.tencent.mm.u.c.xa().fW(str);
      ap.yY();
      localObject2 = com.tencent.mm.u.c.wR().Rb(str);
      if ((localObject2 == null) || ((int)((com.tencent.mm.j.a)localObject2).gTG <= 0))
      {
        v.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList chatRoomId[%s], contact is null need get", new Object[] { str });
        ag.a.hlA.a(str, null, new ag.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            GMTrace.i(413122166784L, 3078);
            if ((localObject1 != null) && (localObject1.bKJ()))
            {
              paramAnonymousString = new jh();
              paramAnonymousString.fPs.chatroomName = str;
              paramAnonymousString.fPs.fPt = localObject1.bKI();
              com.tencent.mm.sdk.b.a.uql.m(paramAnonymousString);
            }
            GMTrace.o(413122166784L, 3078);
          }
        });
      }
      if ((com.tencent.mm.sdk.a.b.foreground) && (j != 10002) && (k > 0))
      {
        localObject1 = new bu();
        ((bu)localObject1).tdx = parambv.tdG;
        ((bu)localObject1).tdy = com.tencent.mm.platformtools.n.mw(com.tencent.mm.u.m.xL());
        ((bu)localObject1).ofk = parambv.ofk;
        ((bu)localObject1).tdz = parambv.tdI;
        ((bu)localObject1).mrC = parambv.mrC;
        ((bu)localObject1).tdE = parambv.tdE;
        ((bu)localObject1).tdF = parambv.tdF;
        if (paramr != null) {
          paramr.a(localau, (bu)localObject1);
        }
      }
      GMTrace.o(408021893120L, 3040);
      return;
      ap.yY();
      l = com.tencent.mm.u.c.xC().Ab(str);
      ((ae)localObject1).v(l);
      v.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList new conv lastDeleteSeq(FirstUnDeliverSeq)[%d], msgSeq[%d]", new Object[] { Long.valueOf(l), Integer.valueOf(n) });
      i = 1;
      break;
      int i1 = (int)((aj)localObject1).field_lastSeq;
      com.tencent.mm.plugin.report.c.oRz.a(403L, 23L, 1L, false);
      if (k < ((aj)localObject1).field_UnDeliverCount) {
        com.tencent.mm.plugin.report.c.oRz.a(403L, 26L, ((aj)localObject1).field_UnDeliverCount, false);
      }
      if (n > i1)
      {
        ((ae)localObject1).u(n);
        ((ae)localObject1).dB(k);
        ((ae)localObject1).s(ay.i(str, i));
        if (k > ((aj)localObject1).field_unReadCount) {
          ((ae)localObject1).dt(k);
        }
        l = ((aj)localObject1).field_firstUnDeliverSeq;
        v.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList  msgSeq[%d], firstSeq[%d], lastseq[%d]", new Object[] { Integer.valueOf(n), Long.valueOf(l), Integer.valueOf(i1) });
        if (l > 0L)
        {
          ap.yY();
          if (com.tencent.mm.u.c.wT().y(str, i1).field_msgId > 0L)
          {
            if (k > 1)
            {
              v.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList unDeliverCount:%d keep firstSeq:%d", new Object[] { Integer.valueOf(k), Long.valueOf(l) });
              com.tencent.mm.plugin.report.c.oRz.a(403L, 27L, 1L, false);
              i = 0;
              break;
            }
            ((ae)localObject1).v(n);
            com.tencent.mm.plugin.report.c.oRz.a(403L, 28L, 1L, false);
            i = 0;
            break;
          }
          com.tencent.mm.plugin.report.c.oRz.a(403L, 29L, 1L, false);
          v.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList unDeliverCount:%d lastSeq:%d not existed", new Object[] { Integer.valueOf(k), Integer.valueOf(i1) });
          i = 0;
          break;
        }
        ap.yY();
        l = com.tencent.mm.u.c.xC().Ab(str);
        if (l > 0L)
        {
          com.tencent.mm.plugin.report.c.oRz.a(403L, 30L, 1L, false);
          if ((k == 0) && (n == l))
          {
            v.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList[%d, %d] deleted ret", new Object[] { Integer.valueOf(n), Long.valueOf(l) });
            GMTrace.o(408021893120L, 3040);
            return;
          }
          ((ae)localObject1).v(n);
          i = 0;
          break;
        }
        ap.yY();
        l = com.tencent.mm.u.c.wT().AC(str);
        if (l > 0L)
        {
          ((ae)localObject1).v(l);
          com.tencent.mm.plugin.report.c.oRz.a(403L, 31L, 1L, false);
          i = 0;
          break;
        }
        com.tencent.mm.plugin.report.c.oRz.a(403L, 32L, 1L, false);
        i = 0;
        break;
      }
      if ((n == i1) && (k == 0) && (((aj)localObject1).field_unReadCount > 0))
      {
        com.tencent.mm.plugin.report.c.oRz.a(403L, 33L, 1L, false);
        ((ae)localObject1).dt(0);
      }
      v.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList msgSeq <= lastSeq, do nothing [%d, %d]", new Object[] { Integer.valueOf(n), Integer.valueOf(i1) });
      GMTrace.o(408021893120L, 3040);
      return;
      label1649:
      if (j != 10002) {
        break label575;
      }
      ap.getSysCmdMsgExtension();
      if ((localau.field_type != 10002) || (bf.mA((String)localObject2))) {
        break label575;
      }
      if (bf.mA((String)localObject2))
      {
        v.e("MicroMsg.SysCmdMsgExtension", "null msg content");
        break label575;
      }
      if (((String)localObject2).startsWith("~SEMI_XML~"))
      {
        localObject3 = av.PE((String)localObject2);
        if (localObject3 == null)
        {
          v.e("MicroMsg.SysCmdMsgExtension", "SemiXml values is null, msgContent %s", new Object[] { localObject2 });
          break label575;
        }
        localObject4 = "brand_service";
        localObject2 = localObject3;
        localObject3 = localObject4;
      }
      for (;;)
      {
        if ((localObject3 == null) || (!((String)localObject3).equals("revokemsg"))) {
          break label1953;
        }
        v.i("MicroMsg.SysCmdMsgExtension", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
        ((Map)localObject2).get(".sysmsg.revokemsg.session");
        localObject3 = (String)((Map)localObject2).get(".sysmsg.revokemsg.newmsgid");
        localObject2 = (String)((Map)localObject2).get(".sysmsg.revokemsg.replacemsg");
        v.i("MicroMsg.SysCmdMsgExtension", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", new Object[] { localObject3, localObject2 });
        localau.setContent((String)localObject2);
        localau.setType(10000);
        break;
        m = ((String)localObject2).indexOf("<sysmsg");
        if (m == -1)
        {
          v.e("MicroMsg.SysCmdMsgExtension", "msgContent not start with <sysmsg");
          break;
        }
        localObject4 = bg.q(((String)localObject2).substring(m), "sysmsg");
        if (localObject4 == null)
        {
          v.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", new Object[] { localObject2 });
          break;
        }
        localObject3 = (String)((Map)localObject4).get(".sysmsg.$type");
        localObject2 = localObject4;
      }
      label1953:
      break label575;
      label1955:
      localObject2 = " " + bf.mz((String)localObject2);
      break label752;
      label1981:
      ((ae)localObject1).cu(((aj)localObject1).field_content);
      break label764;
      label1994:
      ((ae)localObject1).dy(((aj)localObject1).field_attrflag & 0xFFEFFFFF);
      ap.yY();
      v.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr, processAddMsgDigestList update username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", new Object[] { str, Long.valueOf(com.tencent.mm.u.c.wW().a((ae)localObject1, str, true)), Long.valueOf(((aj)localObject1).field_firstUnDeliverSeq), Long.valueOf(((aj)localObject1).field_lastSeq), Integer.valueOf(((aj)localObject1).field_UnDeliverCount) });
    }
  }
  
  public final void a(lt paramlt, byte[] paramArrayOfByte, boolean paramBoolean, com.tencent.mm.plugin.messenger.foundation.a.r paramr)
  {
    GMTrace.i(407753457664L, 3038);
    label307:
    label762:
    label1039:
    label1044:
    label1420:
    label1425:
    label1709:
    label1897:
    label1974:
    label1979:
    label1984:
    int j;
    label2123:
    int i;
    switch (paramlt.tqs)
    {
    default: 
      v.e("MicroMsg.BigBallOfMudSyncExtension", "doCmd: no processing method, cmd id=" + paramlt.tqs);
      GMTrace.o(407753457664L, 3038);
      return;
    case 22: 
      paramlt = (agc)new agc().aD(paramArrayOfByte);
      paramArrayOfByte = new com.tencent.mm.modelfriend.q();
      paramArrayOfByte.username = paramlt.jLx;
      paramArrayOfByte.hBf = paramlt.tJz;
      paramArrayOfByte.huN = ((int)bf.Nz());
      com.tencent.mm.modelfriend.af.Gd().a(paramArrayOfByte);
      GMTrace.o(407753457664L, 3038);
      return;
    case 13: 
      paramlt = (aml)new aml().aD(paramArrayOfByte);
      if (1 == paramlt.tPy)
      {
        ap.yY();
        paramArrayOfByte = com.tencent.mm.u.c.wZ();
        paramr = com.tencent.mm.platformtools.n.a(paramlt.trH);
        if (paramlt.tPi == 1)
        {
          paramBoolean = true;
          if (paramlt.tPz != 1) {
            break label307;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          paramArrayOfByte.c(paramr, paramBoolean, bool);
          GMTrace.o(407753457664L, 3038);
          return;
          paramBoolean = false;
          break;
        }
      }
      v.e("MicroMsg.BigBallOfMudSyncExtension", "unknown micro blog type:" + paramlt.tPy);
      GMTrace.o(407753457664L, 3038);
      return;
    case 15: 
      paramlt = (alw)new alw().aD(paramArrayOfByte);
      if (paramlt != null)
      {
        v.d("MicroMsg.BigBallOfMudSyncExtension", "processModChatRoomMember username:" + paramlt.trH + " nickname:" + paramlt.tJy);
        paramr = com.tencent.mm.platformtools.n.a(paramlt.trH);
        ap.yY();
        paramArrayOfByte = com.tencent.mm.u.c.wR().Rb(paramr);
        paramArrayOfByte.setUsername(paramr);
        paramArrayOfByte.bR(com.tencent.mm.platformtools.n.a(paramlt.tJy));
        paramArrayOfByte.bS(com.tencent.mm.platformtools.n.a(paramlt.trx));
        paramArrayOfByte.bT(com.tencent.mm.platformtools.n.a(paramlt.jdField_try));
        paramArrayOfByte.di(paramlt.hAl);
        paramArrayOfByte.bP(com.tencent.mm.platformtools.n.a(paramlt.tOz));
        paramArrayOfByte.bV(com.tencent.mm.platformtools.n.a(paramlt.tOB));
        paramArrayOfByte.bW(com.tencent.mm.platformtools.n.a(paramlt.tOA));
        paramArrayOfByte.dl(paramlt.tqV);
        paramr = new h();
        paramr.fRM = -1;
        paramr.username = paramArrayOfByte.field_username;
        paramr.hrj = paramlt.tow;
        paramr.hrk = paramlt.tov;
        v.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl chatmember %s b[%s] s[%s]", new Object[] { paramr.getUsername(), paramr.Bs(), paramr.Bt() });
        paramr.aV(true);
        if ((paramlt.tOP != 3) && (paramlt.tOP != 4)) {
          break label762;
        }
        paramArrayOfByte.dh(paramlt.tOP);
        paramr.gkg = paramlt.tOP;
      }
      for (;;)
      {
        com.tencent.mm.x.n.Bm().a(paramr);
        ap.yY();
        com.tencent.mm.u.c.wR().Q(paramArrayOfByte);
        paramr = w.DH().hO(paramArrayOfByte.field_username);
        paramr.field_username = paramArrayOfByte.field_username;
        paramr.field_brandList = paramlt.hAv;
        paramlt = paramlt.tLk;
        if (paramlt != null)
        {
          paramr.field_brandFlag = paramlt.hAz;
          paramr.field_brandInfo = paramlt.hAB;
          paramr.field_brandIconURL = paramlt.hAC;
          paramr.field_extInfo = paramlt.hAA;
        }
        if (!w.DH().e(paramr)) {
          w.DH().d(paramr);
        }
        GMTrace.o(407753457664L, 3038);
        return;
        if (paramlt.tOP == 2)
        {
          paramArrayOfByte.dh(3);
          paramr.gkg = 3;
          paramArrayOfByte.dh(3);
          if (!com.tencent.mm.u.m.xL().equals(paramArrayOfByte.field_username))
          {
            com.tencent.mm.x.n.Bl();
            com.tencent.mm.x.d.s(paramArrayOfByte.field_username, false);
            com.tencent.mm.x.n.Bl();
            com.tencent.mm.x.d.s(paramArrayOfByte.field_username, true);
            com.tencent.mm.x.n.Bz().hf(paramArrayOfByte.field_username);
          }
        }
      }
    case 23: 
      paramlt = (st)new st().aD(paramArrayOfByte);
      switch (paramlt.tyY)
      {
      case 2: 
      case 3: 
      default: 
        v.e("MicroMsg.BigBallOfMudSyncExtension", "unknown function switch id:" + paramlt.tyY);
        GMTrace.o(407753457664L, 3038);
        return;
      case 1: 
        ap.yY();
        com.tencent.mm.u.c.vr().set(17, Integer.valueOf(paramlt.tyZ));
        GMTrace.o(407753457664L, 3038);
        return;
      }
      GMTrace.o(407753457664L, 3038);
      return;
    case 25: 
      paramlt = (bei)new bei().aD(paramArrayOfByte);
      if (paramlt != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        if (bf.mz(paramlt.jLx).length() <= 0) {
          break label1039;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        Assert.assertTrue(paramBoolean);
        if (x.QL(paramlt.jLx)) {
          break label1044;
        }
        v.w("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: tcontact should ends with @t.qq.com");
        GMTrace.o(407753457664L, 3038);
        return;
        paramBoolean = false;
        break;
      }
      ap.yY();
      paramArrayOfByte = com.tencent.mm.u.c.wR().Rb(paramlt.jLx);
      if ((paramArrayOfByte == null) || ((int)paramArrayOfByte.gTG == 0))
      {
        paramArrayOfByte = new x(paramlt.jLx);
        paramArrayOfByte.bP(paramlt.tou);
        paramArrayOfByte.dl(1);
        paramArrayOfByte.ti();
        ap.yY();
        if (com.tencent.mm.u.c.wR().S(paramArrayOfByte) == -1)
        {
          v.e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: insert contact failed");
          GMTrace.o(407753457664L, 3038);
          return;
        }
        paramArrayOfByte = paramArrayOfByte.field_username;
        if (paramArrayOfByte == null) {
          v.w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
        }
      }
      for (;;)
      {
        paramArrayOfByte = new qh();
        paramArrayOfByte.fXd.opType = 1;
        paramArrayOfByte.fXd.fRV = paramlt.jLx;
        paramArrayOfByte.fXd.fRW = paramlt.tUT;
        paramArrayOfByte.fXd.fRX = paramlt.trc;
        com.tencent.mm.sdk.b.a.uql.m(paramArrayOfByte);
        GMTrace.o(407753457664L, 3038);
        return;
        if (!paramArrayOfByte.endsWith("@t.qq.com"))
        {
          v.w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
        }
        else
        {
          paramr = new h();
          paramr.username = paramArrayOfByte;
          paramr.gkg = 3;
          paramr.fRM = 3;
          com.tencent.mm.x.n.Bm().a(paramr);
          continue;
          if (!bf.mz(paramlt.tou).equals(bf.mz(paramArrayOfByte.field_username)))
          {
            paramArrayOfByte.bP(paramlt.tou);
            ap.yY();
            if (com.tencent.mm.u.c.wR().a(paramArrayOfByte.field_username, paramArrayOfByte) == -1) {
              v.e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: update contact failed");
            }
          }
        }
      }
    case 24: 
      paramlt = (asd)new asd().aD(paramArrayOfByte);
      if (paramlt != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        if (bf.mz(paramlt.jLx).length() <= 0) {
          break label1420;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        Assert.assertTrue(paramBoolean);
        if (x.QN(paramlt.jLx)) {
          break label1425;
        }
        v.w("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: qcontact should ends with @t.qq.com");
        GMTrace.o(407753457664L, 3038);
        return;
        paramBoolean = false;
        break;
      }
      ap.yY();
      paramArrayOfByte = com.tencent.mm.u.c.wR().Rb(paramlt.jLx);
      if ((paramArrayOfByte == null) || ((int)paramArrayOfByte.gTG == 0))
      {
        paramArrayOfByte = new x(paramlt.jLx);
        paramArrayOfByte.ti();
        paramArrayOfByte.bR(paramlt.tou);
        paramArrayOfByte.bP(paramlt.tou);
        paramArrayOfByte.dl(4);
        ap.yY();
        if (com.tencent.mm.u.c.wR().S(paramArrayOfByte) == -1)
        {
          v.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: insert contact failed");
          GMTrace.o(407753457664L, 3038);
          return;
        }
        com.tencent.mm.x.b.hc(paramArrayOfByte.field_username);
      }
      for (;;)
      {
        paramArrayOfByte = new lh();
        paramArrayOfByte.fRR.opType = 1;
        paramArrayOfByte.fRR.fRV = paramlt.jLx;
        paramArrayOfByte.fRR.fRW = paramlt.tUT;
        paramArrayOfByte.fRR.fRX = paramlt.trc;
        com.tencent.mm.sdk.b.a.uql.m(paramArrayOfByte);
        GMTrace.o(407753457664L, 3038);
        return;
        if (!bf.mz(paramlt.tou).equals(bf.mz(paramArrayOfByte.field_username)))
        {
          paramArrayOfByte.bR(paramlt.tou);
          paramArrayOfByte.bP(paramlt.tou);
          ap.yY();
          if (com.tencent.mm.u.c.wR().a(paramArrayOfByte.field_username, paramArrayOfByte) == -1) {
            v.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: update contact failed");
          }
        }
      }
    case 33: 
      paramlt = (alt)new alt().aD(paramArrayOfByte);
      if (paramlt != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        if (bf.mz(paramlt.jLx).length() <= 0) {
          break label1974;
        }
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        paramArrayOfByte = new x();
        paramArrayOfByte.setUsername(paramlt.jLx);
        paramArrayOfByte.setType(paramlt.jMq);
        paramArrayOfByte.di(paramlt.hAl);
        paramArrayOfByte.ck(RegionCodeDecoder.ab(paramlt.hAu, paramlt.hAm, paramlt.hAn));
        paramArrayOfByte.ce(paramlt.hAo);
        paramr = new h();
        paramr.fRM = -1;
        paramr.username = paramlt.jLx;
        paramr.hrj = paramlt.tow;
        paramr.hrk = paramlt.tov;
        v.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl bottle %s b[%s] s[%s]", new Object[] { paramr.getUsername(), paramr.Bs(), paramr.Bt() });
        v.d("MicroMsg.BigBallOfMudSyncExtension", "bottlecontact imgflag:" + paramlt.tOP + " hd:" + paramlt.tOQ);
        if (paramlt.tOQ == 0) {
          break label1979;
        }
        paramBoolean = true;
        paramr.aV(paramBoolean);
        if ((paramlt.tOP != 3) && (paramlt.tOP != 4)) {
          break label1984;
        }
        paramArrayOfByte.dh(paramlt.tOP);
        paramr.gkg = paramlt.tOP;
      }
      for (;;)
      {
        com.tencent.mm.x.n.Bm().a(paramr);
        ap.yY();
        com.tencent.mm.u.c.wR().P(paramArrayOfByte);
        GMTrace.o(407753457664L, 3038);
        return;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label1709;
        paramBoolean = false;
        break label1897;
        if (paramlt.tOP == 2)
        {
          paramArrayOfByte.dh(3);
          paramr.gkg = 3;
          com.tencent.mm.x.n.Bl();
          com.tencent.mm.x.d.s(paramlt.jLx, false);
          com.tencent.mm.x.n.Bl();
          com.tencent.mm.x.d.s(paramlt.jLx, true);
          com.tencent.mm.x.n.Bz().hf(paramlt.jLx);
        }
        else
        {
          paramArrayOfByte.dh(3);
          paramr.gkg = 3;
        }
      }
    case 35: 
      paramr = (ams)new ams().aD(paramArrayOfByte);
      if (paramr != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        paramlt = com.tencent.mm.u.m.xL();
        j = paramr.tjL;
        if (j != 2) {
          break label2371;
        }
        paramlt = x.QQ(paramlt);
        ap.yY();
        paramArrayOfByte = (String)com.tencent.mm.u.c.vr().get(12553, null);
        paramBoolean = false;
        if ((paramArrayOfByte == null) || (!paramArrayOfByte.equals(paramr.tPE)))
        {
          com.tencent.mm.x.n.Bl();
          com.tencent.mm.x.d.s(paramlt, true);
          ap.yY();
          paramArrayOfByte = com.tencent.mm.u.c.vr();
          if (j != 2) {
            break label2392;
          }
          i = 12553;
          paramArrayOfByte.set(i, paramr.tPE);
          paramBoolean = true;
        }
        v.d("MicroMsg.BigBallOfMudSyncExtension", "ModUserImg beRemove:%b imgtype:%d md5:%s big:%s sm:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(j), paramr.tPE, paramr.tov, paramr.tow });
        paramArrayOfByte = new h();
        paramArrayOfByte.username = paramlt;
        paramArrayOfByte.hrk = paramr.tov;
        paramArrayOfByte.hrj = paramr.tow;
        if (!bf.mA(paramArrayOfByte.Bt()))
        {
          if (j != 1) {
            break label2400;
          }
          ap.yY();
          com.tencent.mm.u.c.vr().set(59, Boolean.valueOf(true));
        }
      }
      for (;;)
      {
        paramArrayOfByte.aV(false);
        paramArrayOfByte.fRM = 56;
        if (!bf.mA(paramr.tPE)) {
          paramArrayOfByte.aV(true);
        }
        com.tencent.mm.x.n.Bm().a(paramArrayOfByte);
        if (paramBoolean) {
          new com.tencent.mm.x.e().a(paramlt, new e.b()
          {
            public final int aM(int paramAnonymousInt1, int paramAnonymousInt2)
            {
              GMTrace.i(401847877632L, 2994);
              GMTrace.o(401847877632L, 2994);
              return 0;
            }
          });
        }
        GMTrace.o(407753457664L, 3038);
        return;
        paramBoolean = false;
        break;
        ap.yY();
        paramArrayOfByte = (String)com.tencent.mm.u.c.vr().get(12297, null);
        break label2123;
        i = 12297;
        break label2170;
        ap.yY();
        com.tencent.mm.u.c.vr().set(60, Boolean.valueOf(true));
      }
    case 44: 
      paramr = (bih)new bih().aD(paramArrayOfByte);
      v.d("MicroMsg.BigBallOfMudSyncExtension", "snsExtFlag " + paramr.tLj.hAw);
      ap.yY();
      String str = (String)com.tencent.mm.u.c.vr().get(2, null);
      if ((str == null) || (str.length() <= 0))
      {
        GMTrace.o(407753457664L, 3038);
        return;
      }
      if (com.tencent.mm.plugin.sns.b.m.pOZ != null) {
        com.tencent.mm.plugin.sns.b.m.pOZ.a(str, paramr.tLj);
      }
      paramArrayOfByte = com.tencent.mm.modelbiz.e.hW(com.tencent.mm.u.m.xL());
      paramlt = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        paramlt = new BizInfo();
      }
      paramlt.field_username = str;
      paramlt.field_brandList = paramr.hAv;
      if ((paramlt.CI()) && (paramlt.bd(false) != null) && (paramlt.bd(false).Di() != null) && (!bf.mA(paramlt.CO())))
      {
        paramlt.field_enterpriseFather = paramlt.CO();
        v.d("MicroMsg.BigBallOfMudSyncExtension", "processModUserInfoExt, %s set enterpriseFather %s", new Object[] { str, paramlt.field_enterpriseFather });
      }
      if (!w.DH().e(paramlt)) {
        w.DH().d(paramlt);
      }
      i = paramr.ugm;
      j = paramr.ugn;
      int k = paramr.ugo;
      v.d("MicroMsg.BigBallOfMudSyncExtension", "roomSize :" + i + " rommquota: " + j + " invite: " + k);
      ap.yY();
      com.tencent.mm.u.c.vr().set(135175, Integer.valueOf(i));
      ap.yY();
      com.tencent.mm.u.c.vr().set(135176, Integer.valueOf(j));
      ap.yY();
      com.tencent.mm.u.c.vr().set(135177, Integer.valueOf(k));
      ap.yY();
      com.tencent.mm.u.c.vr().set(144385, Integer.valueOf(paramr.ugs));
      ap.yY();
      com.tencent.mm.u.c.vr().a(w.a.uCm, Integer.valueOf(paramr.ugB));
      ap.yY();
      com.tencent.mm.u.c.vr().set(339975, Integer.valueOf(paramr.ugA));
      v.i("MicroMsg.BigBallOfMudSyncExtension", "hy: sync do cmd pay wallet type: %d %d", new Object[] { Integer.valueOf(paramr.ugA), Integer.valueOf(paramr.ugB) });
      ap.yY();
      com.tencent.mm.u.c.vr().a(w.a.uAu, bf.ap(paramr.gkF, ""));
      v.d("MicroMsg.BigBallOfMudSyncExtension", "weidianinfo:%s", new Object[] { paramr.gkF });
      ap.yY();
      com.tencent.mm.u.c.vr().set(147457, Long.valueOf(paramr.ugC));
      ap.yY();
      com.tencent.mm.u.c.vr().a(w.a.uEh, paramr.ugD);
      paramlt = new h();
      paramlt.fRM = -1;
      paramlt.username = str;
      paramlt.hrk = paramr.tov;
      paramlt.hrj = paramr.tow;
      paramlt.aV(true);
      paramlt.gkg = 3;
      v.d("MicroMsg.BigBallOfMudSyncExtension", "dkavatar user:[%s] big:[%s] sm:[%s]", new Object[] { paramlt.getUsername(), paramlt.Bs(), paramlt.Bt() });
      com.tencent.mm.x.n.Bm().a(paramlt);
      paramlt = paramr.tPa;
      paramArrayOfByte = paramr.tPb;
      ap.yY();
      com.tencent.mm.u.c.vr().set(274433, paramArrayOfByte);
      ap.yY();
      com.tencent.mm.u.c.vr().set(274434, paramlt);
      if (paramr.tdL != null)
      {
        ap.yY();
        com.tencent.mm.u.c.vr().set(286721, paramr.tdL.thK);
        ap.yY();
        com.tencent.mm.u.c.vr().set(286722, paramr.tdL.thL);
        ap.yY();
        com.tencent.mm.u.c.vr().set(286723, paramr.tdL.thM);
      }
      if ((paramr.ugy != null) && (paramr.ugy.tSu != null) && (paramr.ugy.tSu.tXB > 0))
      {
        v.i("MicroMsg.BigBallOfMudSyncExtension", "tomgest PatternLockInfo %d", new Object[] { Integer.valueOf(paramr.ugy.tSu.tXB) });
        paramlt = new qz();
        paramlt.fXO.fXP = paramr.ugy;
        com.tencent.mm.sdk.b.a.uql.m(paramlt);
      }
      GMTrace.o(407753457664L, 3038);
      return;
    case 999999: 
      try
      {
        i = com.tencent.mm.a.n.c(paramArrayOfByte, 0);
        v.d("MicroMsg.BigBallOfMudSyncExtension", "local test synccmd, sleep %d", new Object[] { Integer.valueOf(i) });
        if (i > 0) {
          Thread.sleep(i);
        }
        GMTrace.o(407753457664L, 3038);
        return;
      }
      catch (InterruptedException paramlt)
      {
        v.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", paramlt, "", new Object[0]);
        GMTrace.o(407753457664L, 3038);
        return;
      }
    case 53: 
      label2170:
      label2371:
      label2392:
      label2400:
      paramlt = (anh)new anh().aD(paramArrayOfByte);
      v.d("MicroMsg.BigBallOfMudSyncExtension", "rollback, msgtype is %d, msgid is %d", new Object[] { Integer.valueOf(paramlt.mrC), Long.valueOf(paramlt.tdE) });
      if (o.fl(paramlt.muu))
      {
        paramArrayOfByte = new nf();
        paramArrayOfByte.fUh.fGD = paramlt.tdE;
        com.tencent.mm.sdk.b.a.uql.m(paramArrayOfByte);
      }
      GMTrace.o(407753457664L, 3038);
      return;
    }
    a((bv)new bv().aD(paramArrayOfByte), paramr);
    GMTrace.o(407753457664L, 3038);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelmulti/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */