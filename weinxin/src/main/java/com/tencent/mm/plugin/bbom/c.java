package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.av.f;
import com.tencent.mm.av.l;
import com.tencent.mm.e.a.el;
import com.tencent.mm.e.a.gv;
import com.tencent.mm.e.a.ig;
import com.tencent.mm.e.a.ig.a;
import com.tencent.mm.e.a.iw;
import com.tencent.mm.e.a.jh;
import com.tencent.mm.e.a.qj;
import com.tencent.mm.e.a.qk;
import com.tencent.mm.e.a.qk.b;
import com.tencent.mm.e.a.qo;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.pluginsdk.l.a;
import com.tencent.mm.pluginsdk.l.h;
import com.tencent.mm.pluginsdk.l.n;
import com.tencent.mm.pluginsdk.l.q;
import com.tencent.mm.pluginsdk.l.s;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.amb;
import com.tencent.mm.protocal.c.amc;
import com.tencent.mm.protocal.c.amo;
import com.tencent.mm.protocal.c.aqh;
import com.tencent.mm.protocal.c.aqi;
import com.tencent.mm.protocal.c.bcl;
import com.tencent.mm.protocal.c.jy;
import com.tencent.mm.protocal.c.jz;
import com.tencent.mm.protocal.c.mx;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.as.b;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ag.a;
import com.tencent.mm.u.ag.b;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;
import org.json.JSONObject;

public final class c
  implements com.tencent.mm.plugin.messenger.foundation.a.b, com.tencent.mm.y.e
{
  public c()
  {
    GMTrace.i(8028099182592L, 59814);
    GMTrace.o(8028099182592L, 59814);
  }
  
  private static void a(amb paramamb, String paramString, x paramx, boolean paramBoolean)
  {
    GMTrace.i(8028501835776L, 59817);
    Object localObject = com.tencent.mm.u.m.xL();
    if ((localObject != null) && (!((String)localObject).equals(paramString)))
    {
      localObject = w.DH().hO(paramString);
      ((BizInfo)localObject).field_username = paramString;
      ((BizInfo)localObject).field_brandList = paramamb.hAv;
      paramamb = paramamb.tLk;
      if (paramamb != null)
      {
        ((BizInfo)localObject).field_brandFlag = paramamb.hAz;
        ((BizInfo)localObject).field_brandInfo = paramamb.hAB;
        ((BizInfo)localObject).field_brandIconURL = paramamb.hAC;
        ((BizInfo)localObject).field_extInfo = paramamb.hAA;
        if (paramBoolean)
        {
          ((BizInfo)localObject).field_attrSyncVersion = null;
          ((BizInfo)localObject).field_incrementUpdateTime = 0L;
          v.i("MicroMsg.BigBallContactAssemblerImpl", "Reset biz(%s) Attribute syncVersion and incUpdateTime.", new Object[] { paramString });
        }
        if (!bf.mA(((BizInfo)localObject).field_extInfo)) {
          ((BizInfo)localObject).bd(true);
        }
      }
      if ((((BizInfo)localObject).bd(false) != null) && (((BizInfo)localObject).bd(false).De() == 3) && (((BizInfo)localObject).bd(false).Di() != null) && (!bf.mA(((BizInfo)localObject).CO())))
      {
        ((BizInfo)localObject).field_enterpriseFather = ((BizInfo)localObject).CO();
        v.d("MicroMsg.BigBallContactAssemblerImpl", "saveBizInfo, %s set enterpriseFather %s", new Object[] { paramString, ((BizInfo)localObject).field_enterpriseFather });
      }
      if (!w.DH().e((BizInfo)localObject)) {
        w.DH().d((BizInfo)localObject);
      }
      paramx.dq(((BizInfo)localObject).field_type);
    }
    GMTrace.o(8028501835776L, 59817);
  }
  
  public static boolean a(x paramx, amb paramamb, boolean paramBoolean)
  {
    GMTrace.i(8028636053504L, 59818);
    if ((paramx == null) || (bf.mA(paramx.field_username)))
    {
      v.e("MicroMsg.BigBallContactAssemblerImpl", "dkinit dealModContactExtInfo failed invalid contact");
      GMTrace.o(8028636053504L, 59818);
      return false;
    }
    String str1 = paramx.field_username;
    Object localObject1 = paramx.field_encryptUsername;
    Object localObject2 = com.tencent.mm.x.b.a(str1, paramamb);
    com.tencent.mm.x.n.Bm().a((com.tencent.mm.x.h)localObject2);
    localObject2 = paramamb.tLj;
    if ((!paramx.field_username.endsWith("@chatroom")) && (localObject2 != null))
    {
      v.i("MicroMsg.BigBallContactAssemblerImpl", "SnsFlag modcontact " + ((bcl)localObject2).hAw + " " + paramamb.trH);
      v.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBg modcontact " + ((bcl)localObject2).hAx);
      v.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ((bcl)localObject2).hAy);
      v.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ((bcl)localObject2).ubT);
      if (com.tencent.mm.plugin.sns.b.m.pOZ != null) {
        com.tencent.mm.plugin.sns.b.m.pOZ.a(paramx.field_username, (bcl)localObject2);
      }
    }
    boolean bool;
    if (com.tencent.mm.j.a.ez(paramx.field_type))
    {
      bool = l.Kz().D(str1, 1);
      if (bool)
      {
        v.d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, user = " + str1);
        v.i("MicroMsg.BigBallContactAssemblerImpl", "processModContact, update state(ADDED) FMessageConversation, ret = " + bool);
      }
    }
    else if ((com.tencent.mm.j.a.ez(paramx.field_type)) && ((paramx.getSource() == 10) || (paramx.getSource() == 13)))
    {
      localObject1 = aa.getContext();
      localObject2 = paramx.field_username;
      String str2 = paramx.field_encryptUsername;
      if (!com.tencent.mm.modelsimple.d.bf((Context)localObject1)) {
        break label504;
      }
      com.tencent.mm.sdk.f.e.b(new com.tencent.mm.modelsimple.b((Context)localObject1, com.tencent.mm.modelsimple.d.bh((Context)localObject1), (String)localObject2, str2), "MMAccountManager_updateSpecifiedContact").start();
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.modelfriend.af.FZ().ja(paramx.field_encryptUsername);
      if ((localObject1 != null) && (!bf.mA(((com.tencent.mm.modelfriend.b)localObject1).hAk)))
      {
        ((com.tencent.mm.modelfriend.b)localObject1).username = paramx.field_username;
        int i = com.tencent.mm.modelfriend.af.FZ().a(((com.tencent.mm.modelfriend.b)localObject1).hAk, (com.tencent.mm.modelfriend.b)localObject1);
        v.d("MicroMsg.BigBallContactAssemblerImpl", "account sync: update addr " + i);
      }
      a(paramamb, str1, paramx, paramBoolean);
      GMTrace.o(8028636053504L, 59818);
      return true;
      bool = l.Kz().D((String)localObject1, 1);
      v.d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, encryptUser = " + (String)localObject1);
      break;
      label504:
      com.tencent.mm.modelsimple.d.A((Context)localObject1, null);
      v.d("MicroMsg.MMAccountManager", "no account added or not current account");
    }
  }
  
  private static boolean a(x paramx, bb parambb)
  {
    GMTrace.i(8028770271232L, 59819);
    boolean bool2 = false;
    if (!bf.mA(parambb.field_conDescription)) {
      paramx.cl(parambb.field_conDescription);
    }
    boolean bool1 = bool2;
    if (!o.eT(paramx.field_username))
    {
      bool1 = bool2;
      if (com.tencent.mm.j.a.ez(paramx.field_type))
      {
        bool2 = true;
        bool1 = bool2;
        if (!bf.mA(parambb.field_conDescription))
        {
          amc localamc = new amc();
          localamc.tPo = paramx.field_username;
          localamc.mqJ = parambb.field_conDescription;
          ap.yY();
          com.tencent.mm.u.c.wQ().b(new e.a(54, localamc));
          bool1 = bool2;
        }
      }
    }
    GMTrace.o(8028770271232L, 59819);
    return bool1;
  }
  
  private static void ay(String paramString, int paramInt)
  {
    GMTrace.i(8029038706688L, 59821);
    com.tencent.mm.av.j[] arrayOfj;
    Object localObject1;
    f[] arrayOff;
    com.tencent.mm.av.h[] arrayOfh;
    if ((paramInt == 26) || (paramInt == 27) || (paramInt == 28) || (paramInt == 29))
    {
      v.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is shake");
      arrayOfj = l.KB().lk(paramString);
      localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a(aa.getContext(), arrayOfj);
      arrayOff = null;
      arrayOfh = null;
    }
    while (localObject1 == null)
    {
      GMTrace.o(8029038706688L, 59821);
      return;
      if (paramInt == 18)
      {
        v.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is lbs");
        arrayOfh = l.KA().lf(paramString);
        localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a(aa.getContext(), arrayOfh);
        arrayOfj = null;
        arrayOff = null;
      }
      else
      {
        arrayOff = l.Ky().la(paramString);
        localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a(aa.getContext(), arrayOff);
        arrayOfj = null;
        arrayOfh = null;
      }
    }
    paramInt = 0;
    int k = localObject1.length;
    int i = 0;
    Object localObject2;
    au localau;
    int m;
    int j;
    if (i < k)
    {
      localObject2 = localObject1[i];
      localau = new au();
      localau.setContent(((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).hkk);
      m = o.fG(((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).username);
      if (arrayOff != null)
      {
        j = paramInt + 1;
        localau.z(arrayOff[paramInt].field_createTime);
        paramInt = j;
      }
    }
    label224:
    label261:
    label400:
    label564:
    for (;;)
    {
      localau.cH(((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).username);
      localau.setType(m);
      long l;
      if (((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).fZA)
      {
        localau.dv(2);
        localau.dw(1);
        ap.yY();
        l = com.tencent.mm.u.c.wT().L(localau);
        if (l == -1L) {
          break label400;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        v.i("MicroMsg.BigBallContactAssemblerImpl", "new msg inserted to db , local id = " + l);
        i += 1;
        break;
        if (arrayOfh != null)
        {
          j = paramInt + 1;
          localau.z(arrayOfh[paramInt].field_createtime * 1000L);
          paramInt = j;
          break label224;
        }
        if (arrayOfj == null) {
          break label564;
        }
        j = paramInt + 1;
        localau.z(arrayOfj[paramInt].field_createtime * 1000L);
        paramInt = j;
        break label224;
        localau.dv(6);
        localau.dw(0);
        break label261;
      }
      localObject1 = new au();
      if (arrayOff != null) {
        ((au)localObject1).z(arrayOff[(arrayOff.length - 1)].field_createTime + 1L);
      }
      for (;;)
      {
        ((au)localObject1).cH(paramString);
        ((au)localObject1).setContent(aa.getContext().getString(R.l.eYq));
        ((au)localObject1).setType(10000);
        ((au)localObject1).dv(6);
        ((au)localObject1).dw(0);
        ap.yY();
        com.tencent.mm.u.c.wT().L((au)localObject1);
        GMTrace.o(8029038706688L, 59821);
        return;
        if (arrayOfh != null) {
          ((au)localObject1).z(arrayOfh[(arrayOfh.length - 1)].field_createtime * 1000L + 1L);
        } else if (arrayOfj != null) {
          ((au)localObject1).z(arrayOfj[(arrayOfj.length - 1)].field_createtime * 1000L + 1L);
        }
      }
    }
  }
  
  private static void z(x paramx)
  {
    GMTrace.i(8028904488960L, 59820);
    if ((paramx != null) && (com.tencent.mm.modelbiz.e.ia(paramx.field_username)) && (!com.tencent.mm.modelbiz.e.dr(paramx.field_username)))
    {
      ap.yY();
      ae localae = com.tencent.mm.u.c.wW().Rl(paramx.field_username);
      paramx = w.DH().hO(paramx.field_username);
      if (!com.tencent.mm.modelbiz.e.ie(paramx.field_username))
      {
        GMTrace.o(8028904488960L, 59820);
        return;
      }
      if (localae == null)
      {
        localae = new ae(paramx.field_username);
        v.i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", new Object[] { paramx.CO(), paramx.field_username });
        localae.cw(bf.mz(paramx.CO()));
        localae.bLr();
        ap.yY();
        com.tencent.mm.u.c.wW().d(localae);
      }
    }
    GMTrace.o(8028904488960L, 59820);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.y.k paramk)
  {
    GMTrace.i(16877342425088L, 125746);
    v.i("MicroMsg.BigBallContactAssemblerImpl", "onsceneEnd errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramk.getType() != 681)
    {
      GMTrace.o(16877342425088L, 125746);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      GMTrace.o(16877342425088L, 125746);
      return;
    }
    if (!com.tencent.mm.kernel.h.vG().gXf)
    {
      v.w("MicroMsg.BigBallContactAssemblerImpl", "initialize notify is not done.");
      GMTrace.o(16877342425088L, 125746);
      return;
    }
    paramk = ((com.tencent.mm.ao.a)paramk).hMX;
    paramString = new HashSet();
    try
    {
      paramk = paramk.iterator();
      while (paramk.hasNext())
      {
        localb = (e.b)paramk.next();
        if (localb.getCmdId() != 2) {
          break label263;
        }
        paramString.add(com.tencent.mm.platformtools.n.a(((amb)new amb().aD(localb.getBuffer())).trH));
      }
    }
    catch (Exception paramk)
    {
      for (;;)
      {
        e.b localb;
        v.printErrStackTrace("MicroMsg.BigBallContactAssemblerImpl", paramk, "BaseProtoBuf parseFrom error!", new Object[0]);
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          paramk = (String)paramString.next();
          if (!bf.mA(paramk)) {
            ag.a.hlA.a(paramk, null, null);
          }
        }
        label263:
        if (localb.getCmdId() == 54) {
          paramString.add(((amc)new amc().aD(localb.getBuffer())).tPo);
        } else if (localb.getCmdId() == 60) {
          paramString.add(((amo)new amo().aD(localb.getBuffer())).tPo);
        }
      }
      GMTrace.o(16877342425088L, 125746);
    }
  }
  
  public final void a(x paramx1, x paramx2, amb paramamb, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    GMTrace.i(8028233400320L, 59815);
    String str1 = paramx1.field_username;
    Object localObject1 = paramx1.field_encryptUsername;
    if ((paramx2 != null) && (!bf.mz(paramx2.gkB).equals(bf.mz(paramamb.tPj))))
    {
      com.tencent.mm.ar.c.Ii();
      com.tencent.mm.ar.c.jX(str1);
    }
    if (!bf.bm(paramArrayOfByte))
    {
      if (x.yx(paramx1.field_verifyFlag)) {
        a(paramamb, str1, paramx1, true);
      }
      if ((paramx2 == null) || (com.tencent.mm.j.a.ez(paramx2.field_type)) || (!com.tencent.mm.j.a.ez(paramx1.field_type))) {
        break label1684;
      }
    }
    label283:
    label784:
    label1143:
    label1149:
    label1414:
    label1639:
    label1684:
    for (int j = 1;; j = 0)
    {
      Object localObject2 = paramx1.field_username;
      if (paramamb.tPk == null) {}
      Object localObject3;
      for (paramArrayOfByte = "";; paramArrayOfByte = Integer.valueOf(bf.f(Integer.valueOf(paramamb.tPk.tTt.size()))))
      {
        v.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s PhoneNumList size:%s", new Object[] { localObject2, paramArrayOfByte });
        localObject2 = new StringBuffer();
        if ((paramamb.tPk == null) || (paramamb.tPk.tTt == null)) {
          break label283;
        }
        paramArrayOfByte = paramamb.tPk.tTt.iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject3 = (aqh)paramArrayOfByte.next();
          if (((aqh)localObject3).tTs != null) {
            ((StringBuffer)localObject2).append(((aqh)localObject3).tTs + ",");
          }
        }
        a(paramx1, paramamb, true);
        break;
      }
      v.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", new Object[] { paramx1.field_username, ((StringBuffer)localObject2).toString() });
      paramArrayOfByte = null;
      if (paramx2 != null) {
        paramArrayOfByte = paramx2.gkG;
      }
      if (paramArrayOfByte != null)
      {
        paramx2 = paramArrayOfByte;
        if (!paramArrayOfByte.equals("")) {}
      }
      else
      {
        ap.yY();
        localObject3 = com.tencent.mm.u.c.wS().AG((String)localObject1);
        paramx2 = paramArrayOfByte;
        if (localObject3 != null) {
          paramx2 = ((bb)localObject3).field_conPhone;
        }
      }
      v.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, oldPhoneList %s", new Object[] { paramx1.field_username, bf.mz(paramx2) });
      int i;
      if (!bf.mA(paramx2))
      {
        paramx2 = paramx2.split(",");
        int i2 = paramx2.length;
        int k = 0;
        i = 0;
        int i1;
        for (int m = 0; k < i2; m = i1)
        {
          paramArrayOfByte = paramx2[k];
          int n = i;
          i1 = m;
          if (!bf.mA(((StringBuffer)localObject2).toString()))
          {
            localObject3 = ((StringBuffer)localObject2).toString().split(",");
            i1 = localObject3.length;
            n = 0;
            while (n < i1) {
              if (!paramArrayOfByte.equals(localObject3[n]))
              {
                n += 1;
                i = 1;
              }
              else
              {
                i = 0;
              }
            }
            n = i;
            i1 = m;
            if (i != 0)
            {
              ((StringBuffer)localObject2).append(paramArrayOfByte);
              i1 = 1;
              n = i;
            }
          }
          k += 1;
          i = n;
        }
        if (m != 0)
        {
          paramx2 = new amo();
          paramx2.tPo = paramx1.field_username;
          paramArrayOfByte = new aqi();
          if (!bf.mA(((StringBuffer)localObject2).toString()))
          {
            localObject3 = ((StringBuffer)localObject2).toString().split(",");
            paramArrayOfByte.jLr = localObject3.length;
            paramArrayOfByte.tTt = new LinkedList();
            k = localObject3.length;
            i = 0;
            while (i < k)
            {
              String str2 = localObject3[i];
              aqh localaqh = new aqh();
              localaqh.tTs = str2;
              paramArrayOfByte.tTt.add(localaqh);
              i += 1;
            }
            paramx2.tPk = paramArrayOfByte;
            ap.yY();
            com.tencent.mm.u.c.wQ().b(new e.a(60, paramx2));
          }
        }
        if ((j != 0) && (15 == paramamb.teq))
        {
          paramx2 = com.tencent.mm.plugin.report.service.g.oSF;
          paramArrayOfByte = paramx1.field_username;
          if (!bf.mA(com.tencent.mm.modelfriend.af.FZ().ja(paramx1.field_username).EQ())) {
            break label1143;
          }
          i = 0;
          if (((StringBuffer)localObject2).toString().split(",").length < 5) {
            break label1149;
          }
          j = 5;
          paramx2.i(12040, new Object[] { paramArrayOfByte, Integer.valueOf(3), Integer.valueOf(i), Integer.valueOf(j) });
        }
      }
      v.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", new Object[] { paramx1.field_username, ((StringBuffer)localObject2).toString() });
      paramx2 = ((StringBuffer)localObject2).toString();
      if (!bf.mA(paramx2))
      {
        v.i("MicroMsg.BigBallContactAssemblerImpl", paramx2);
        paramx1.cr(paramx2);
      }
      if ((!o.dH(str1)) && (paramamb.tBU != null)) {
        com.tencent.mm.u.j.a(str1, paramamb.tBU);
      }
      boolean bool1 = false;
      ap.yY();
      paramArrayOfByte = com.tencent.mm.u.c.wS().AG(paramx1.field_username);
      if (!bf.mA(paramx1.field_conRemark)) {
        if ((paramArrayOfByte != null) && (!bf.mA(paramx1.gkA)) && (!paramx1.gkA.equals(paramArrayOfByte.field_conDescription))) {
          a(paramx1, paramArrayOfByte);
        }
      }
      for (bool1 = false;; bool1 = paramBoolean)
      {
        v.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s needModContact %s encryptUser:%s", new Object[] { paramx1.field_username, Boolean.valueOf(bool1), localObject1 });
        if (bool1) {
          o.u(paramx1);
        }
        paramx2 = null;
        ap.yY();
        paramArrayOfByte = com.tencent.mm.u.c.wS().AG(paramx1.field_encryptUsername);
        if (paramArrayOfByte != null) {
          paramx2 = paramArrayOfByte.field_contactLabels;
        }
        paramamb = paramx2;
        if (bf.mA(paramx2))
        {
          ap.yY();
          localObject1 = com.tencent.mm.u.c.wS().AG(paramx1.field_username);
          paramamb = paramx2;
          paramArrayOfByte = (byte[])localObject1;
          if (localObject1 != null)
          {
            paramamb = ((bb)localObject1).field_contactLabels;
            paramArrayOfByte = (byte[])localObject1;
          }
        }
        if (!bf.mA(paramamb))
        {
          com.tencent.mm.plugin.label.a.a.aFz().cE(paramx1.field_username, paramamb);
          paramArrayOfByte.field_contactLabels = "";
          ap.yY();
          com.tencent.mm.u.c.wS().a(paramArrayOfByte);
        }
        GMTrace.o(8028233400320L, 59815);
        return;
        i = 1;
        break;
        j = ((StringBuffer)localObject2).toString().split(",").length;
        break label784;
        if (paramArrayOfByte != null)
        {
          paramx2 = paramArrayOfByte;
          if (!bf.mA(paramArrayOfByte.field_encryptUsername)) {}
        }
        else
        {
          paramx2 = paramArrayOfByte;
          if (!bf.mA((String)localObject1))
          {
            ap.yY();
            paramx2 = com.tencent.mm.u.c.wS().AG((String)localObject1);
          }
        }
        paramBoolean = bool1;
        if (paramx2 != null)
        {
          paramBoolean = bool1;
          if (!bf.mA(paramx2.field_encryptUsername))
          {
            v.i("MicroMsg.BigBallContactAssemblerImpl", "mod stranger remark : " + paramx2.field_encryptUsername);
            paramx1.bP(paramx2.field_conRemark);
            paramx1.bV(com.tencent.mm.platformtools.c.mq(paramx2.field_conRemark));
            paramx1.bW(com.tencent.mm.platformtools.c.mr(paramx2.field_conRemark));
            paramBoolean = a(paramx1, paramx2);
          }
        }
        switch (paramx1.getSource())
        {
        }
      }
      paramx2 = null;
      if ((paramamb != null) && (!bf.mA(paramamb.tPc)))
      {
        v.i("MicroMsg.BigBallContactAssemblerImpl", "MobileHash[%s],MobileFullHash[%s]", new Object[] { paramamb.tPc, paramamb.tPd });
        paramArrayOfByte = com.tencent.mm.modelfriend.af.FZ();
        paramx2 = paramamb.tPc;
        str1 = paramamb.tPd;
        paramamb = paramArrayOfByte.jb(paramx2);
        paramx2 = paramamb;
        if (paramamb == null) {
          paramx2 = paramArrayOfByte.jb(str1);
        }
        if (paramx2 != null) {
          break label1639;
        }
        v.i("MicroMsg.BigBallContactAssemblerImpl", "dealWithRemark-> addr == null");
      }
      for (;;)
      {
        bool1 = paramBoolean;
        if (paramx2 == null) {
          break;
        }
        bool1 = paramBoolean;
        if (bf.mA(paramx2.ES())) {
          break;
        }
        bool1 = paramBoolean;
        if (!paramx2.Fb()) {
          break;
        }
        v.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], remarkChange[%s]", new Object[] { paramx2.ES(), paramx2.getUsername(), Boolean.valueOf(paramBoolean) });
        paramx2.username = paramx1.field_username;
        paramx2.status = 2;
        paramx2.Fa();
        boolean bool2 = paramBoolean;
        if (!paramBoolean)
        {
          paramx1.bP(paramx2.ES());
          paramx1.bV(com.tencent.mm.platformtools.c.mq(paramx2.ES()));
          paramx1.bW(com.tencent.mm.platformtools.c.mr(paramx2.ES()));
          bool2 = true;
        }
        bool1 = bool2;
        if (!com.tencent.mm.j.a.ez(paramx1.field_type)) {
          break;
        }
        v.i("MicroMsg.BigBallContactAssemblerImpl", "updateAddrUp RealName[%s], User[%s], remarkChange[%s]", new Object[] { paramx2.ES(), paramx2.getUsername(), Boolean.valueOf(bool2) });
        com.tencent.mm.modelfriend.af.FZ().a(paramx2.EQ(), paramx2);
        bool1 = bool2;
        break;
        if (bf.mA((String)localObject1)) {
          break label1414;
        }
        paramx2 = com.tencent.mm.modelfriend.af.FZ().ja((String)localObject1);
        break label1414;
        v.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], needSetRemark[%s]", new Object[] { bf.mz(paramx2.ES()), bf.mz(paramx2.getUsername()), Boolean.valueOf(paramx2.Fb()) });
      }
    }
  }
  
  public final void b(x paramx1, x paramx2, amb paramamb, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    GMTrace.i(8028367618048L, 59816);
    paramArrayOfByte = paramx1.field_username;
    Object localObject2 = paramx1.field_encryptUsername;
    Object localObject1;
    Object localObject3;
    label141:
    label218:
    label249:
    Object localObject4;
    int j;
    if (o.dH(paramArrayOfByte))
    {
      if (paramamb.tBU != null)
      {
        localObject1 = paramamb.tBU.tor;
        if (l.a.szR != null) {
          break label1678;
        }
        i = 0;
        if (i == 0)
        {
          localObject1 = paramamb.tBU.tor;
          localObject3 = new qk();
          ((qk)localObject3).fXk.fXm = true;
          com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject3);
          if ((!bf.mA(paramArrayOfByte)) && (o.dH(paramArrayOfByte)) && (!bf.mA(((qk)localObject3).fXl.fXo)) && (paramArrayOfByte.equals(((qk)localObject3).fXl.fXo))) {
            break label1948;
          }
        }
        localObject1 = paramamb.tBU.tor;
        if ((l.a.szT != null) && (localObject1 != null))
        {
          localObject1 = ((LinkedList)localObject1).iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject3 = (jz)((Iterator)localObject1).next();
          } while ((bf.mA(((jz)localObject3).jLx)) || (!((jz)localObject3).jLx.equals(com.tencent.mm.u.m.xL())));
        }
        i = 0;
        if ((i != 0) && (l.a.szT != null)) {
          l.a.szT.AW(paramArrayOfByte);
        }
      }
      if (paramamb.tBU != null) {
        break label2097;
      }
      i = 0;
      localObject1 = paramamb.tOX;
      localObject3 = paramamb.tOW;
      int k = paramamb.tPh;
      int m = paramamb.tPg;
      localObject4 = paramamb.muy;
      int n = paramamb.tPf;
      if (paramamb.tBU != null) {
        break label2109;
      }
      j = -1;
      label295:
      v.i("MicroMsg.BigBallContactAssemblerImpl", "processModContact chatroom:%s count:%d ChatRoomData:%s owner:%s type:%d max:%d upgrader:%s ver:%d infomask:%d ", new Object[] { paramArrayOfByte, Integer.valueOf(i), localObject1, localObject3, Integer.valueOf(k), Integer.valueOf(m), localObject4, Integer.valueOf(n), Integer.valueOf(j) });
      if ((paramamb.tBU != null) && (paramamb.tBU.krk != 0))
      {
        localObject1 = new com.tencent.mm.g.a.a.a();
        ((com.tencent.mm.g.a.a.a)localObject1).type = paramamb.tPh;
        ((com.tencent.mm.g.a.a.a)localObject1).gMK = paramamb.tPg;
        ((com.tencent.mm.g.a.a.a)localObject1).gML = paramamb.muy;
        ((com.tencent.mm.g.a.a.a)localObject1).gMM = paramamb.tPf;
        if (paramamb.tBU.tos == 0) {
          ((com.tencent.mm.g.a.a.a)localObject1).fPt = paramamb.tPf;
        }
        if (com.tencent.mm.u.j.q(paramArrayOfByte, paramamb.tPf))
        {
          localObject3 = new gv();
          com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject3);
          com.tencent.mm.u.j.r(paramArrayOfByte, paramamb.tPh);
        }
        localObject3 = new jh();
        ((jh)localObject3).fPs.chatroomName = paramArrayOfByte;
        ((jh)localObject3).fPs.fPt = ((com.tencent.mm.g.a.a.a)localObject1).fPt;
        com.tencent.mm.u.j.a(paramArrayOfByte, paramamb.tOW, paramamb.tBU, com.tencent.mm.u.m.xL(), (com.tencent.mm.g.a.a.a)localObject1, (com.tencent.mm.sdk.b.b)localObject3);
      }
    }
    if (!com.tencent.mm.j.a.ez(paramx1.field_type))
    {
      if ((paramx1.field_type & 0x2) == 0) {
        break label2121;
      }
      i = 1;
      label566:
      if ((i == 0) && (!x.eO(paramx1.field_username)) && (!o.dH(paramx1.field_username)))
      {
        v.w("MicroMsg.BigBallContactAssemblerImpl", "processModContact delChatContact now user:%s ,type:%d", new Object[] { paramx1.field_username, Integer.valueOf(paramx1.field_type) });
        ap.yY();
        com.tencent.mm.u.c.wW().Rk(paramx1.field_username);
      }
    }
    if ((paramx1.field_type & 0x800) != 0) {
      if ((paramx2 == null) || ((paramx2.field_type & 0x800) != (paramx1.field_type & 0x800)))
      {
        if ((com.tencent.mm.modelbiz.e.ia(paramx1.field_username)) && (!com.tencent.mm.modelbiz.e.dr(paramx1.field_username))) {
          z(paramx1);
        }
      }
      else {
        label694:
        if ((paramx2 == null) || (com.tencent.mm.j.a.ez(paramx2.field_type)) || (!com.tencent.mm.j.a.ez(paramx1.field_type))) {
          break label2560;
        }
      }
    }
    label884:
    label944:
    label1055:
    label1678:
    label1948:
    label2010:
    label2097:
    label2109:
    label2121:
    label2363:
    label2503:
    label2553:
    label2560:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ap.yY();
        localObject1 = com.tencent.mm.u.c.wS().AG(paramArrayOfByte);
        if (localObject1 != null)
        {
          paramArrayOfByte = (byte[])localObject1;
          if (!bf.mA(((bb)localObject1).field_encryptUsername)) {}
        }
        else
        {
          paramArrayOfByte = (byte[])localObject1;
          if (!bf.mA((String)localObject2))
          {
            ap.yY();
            paramArrayOfByte = com.tencent.mm.u.c.wS().AG((String)localObject2);
          }
        }
        if ((paramArrayOfByte != null) && (!bf.mA(paramArrayOfByte.field_encryptUsername)))
        {
          ap.yY();
          com.tencent.mm.u.c.wS().AH(paramArrayOfByte.field_encryptUsername);
        }
      }
      if (com.tencent.mm.modelbiz.e.hZ(paramx1.field_username))
      {
        w.DO();
        com.tencent.mm.modelbiz.c.a(paramx1.field_username, null);
        if ((i != 0) && (com.tencent.mm.modelbiz.e.ia(paramx1.field_username)))
        {
          if (!com.tencent.mm.modelbiz.e.dr(paramx1.field_username)) {
            break label2363;
          }
          w.DN();
          com.tencent.mm.modelbiz.a.h.a(paramx1.field_username, null);
        }
      }
      paramArrayOfByte = com.tencent.mm.modelbiz.e.hW(paramx1.field_username);
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte = paramArrayOfByte.bd(false);
        if (paramArrayOfByte != null)
        {
          j = 0;
          if (paramArrayOfByte.hug != null) {
            j = paramArrayOfByte.hug.optInt("WXAppType", 0);
          }
          if (j != 0)
          {
            j = 1;
            if (j != 0)
            {
              w.DR();
              paramArrayOfByte = paramx1.field_username;
              if (!bf.mA(paramArrayOfByte))
              {
                paramArrayOfByte = w.DH().hO(paramArrayOfByte);
                paramArrayOfByte.field_attrSyncVersion = null;
                paramArrayOfByte.field_incrementUpdateTime = 0L;
                w.DH().e(paramArrayOfByte);
              }
            }
            if ((paramx1.field_type & 0x8) == 0) {
              break label2503;
            }
            if ((paramx2 == null) || ((paramx2.field_type & 0x8) != (paramx1.field_type & 0x8)))
            {
              ap.yY();
              com.tencent.mm.u.c.wW().e(new String[] { paramx1.field_username }, "@blacklist");
            }
            if (!paramBoolean)
            {
              if ((paramx1 != null) && (paramx1.bKU()) && (com.tencent.mm.j.a.ez(paramx1.field_type)))
              {
                long l = System.currentTimeMillis();
                ap.yY();
                paramArrayOfByte = com.tencent.mm.u.c.wW().Rl(paramx1.field_username);
                if ((paramArrayOfByte != null) && (paramArrayOfByte.eC(4194304)))
                {
                  ap.yY();
                  paramBoolean = com.tencent.mm.u.c.wW().b(paramx1.field_username, 4194304, false, paramArrayOfByte.field_attrflag);
                  v.i("MicroMsg.BigBallContactAssemblerImpl", "Reset temp session attr flag.(talker %s, updateSucc %s, cost %s)", new Object[] { paramx1.field_username, Boolean.valueOf(paramBoolean), Long.valueOf(System.currentTimeMillis() - l) });
                }
              }
              if ((paramx2 != null) && ((int)paramx2.gTG > 0) && (paramx2.gky != 0) && (paramx2.gkz == 0) && (paramx1.gkz == 1))
              {
                v.d("MicroMsg.BigBallContactAssemblerImpl", "hakon removeParentRefAndUnread user = %s", new Object[] { paramx1.field_username });
                ap.yY();
                com.tencent.mm.u.c.wW().Rz(paramx1.field_username);
                ap.yY();
                paramx2 = com.tencent.mm.u.c.wW().Rl("officialaccounts");
                if (paramx2 != null)
                {
                  ap.yY();
                  paramx2.dt(com.tencent.mm.u.c.wW().bLA());
                  v.d("MicroMsg.BigBallContactAssemblerImpl", "unread count is %d", new Object[] { Integer.valueOf(paramx2.field_unReadCount) });
                  ap.yY();
                  paramArrayOfByte = com.tencent.mm.u.c.wW().Rw("officialaccounts");
                  ap.yY();
                  paramArrayOfByte = com.tencent.mm.u.c.wT().Ag(paramArrayOfByte);
                  if ((paramArrayOfByte == null) || (paramArrayOfByte.field_msgId <= 0L)) {
                    break label2553;
                  }
                  paramx2.W(paramArrayOfByte);
                  paramx2.setContent(paramArrayOfByte.field_talker + ":" + paramArrayOfByte.field_content);
                  paramx2.ct(Integer.toString(paramArrayOfByte.field_type));
                  ap.yY();
                  localObject1 = com.tencent.mm.u.c.wW().oG();
                  if (localObject1 != null)
                  {
                    localObject2 = new PString();
                    localObject3 = new PString();
                    localObject4 = new PInt();
                    paramArrayOfByte.cH("officialaccounts");
                    paramArrayOfByte.setContent(paramx2.field_content);
                    ((as.b)localObject1).a(paramArrayOfByte, (PString)localObject2, (PString)localObject3, (PInt)localObject4, true);
                    paramx2.cu(((PString)localObject2).value);
                    paramx2.cv(((PString)localObject3).value);
                    paramx2.dx(((PInt)localObject4).value);
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        ap.yY();
        com.tencent.mm.u.c.wW().a(paramx2, paramx2.field_username);
        if (i != 0)
        {
          paramx2 = new iw();
          paramx2.fOy.username = paramx1.field_username;
          paramx2.fOy.fOz = paramx1.fOz;
          com.tencent.mm.sdk.b.a.uql.m(paramx2);
        }
        if ((i != 0) && (paramamb.teq == 18))
        {
          paramx2 = new ig();
          paramx2.fNG.fNH = paramx1.field_encryptUsername;
          paramx2.fNG.type = 2;
          l.KA().le(paramx2.fNG.fNH);
          com.tencent.mm.sdk.b.a.uql.m(paramx2);
        }
        if (i != 0) {
          ay(paramx1.field_username, paramamb.teq);
        }
        com.tencent.mm.plugin.label.a.a.aFz().aFt();
        GMTrace.o(8028367618048L, 59816);
        return;
        localObject3 = l.a.szR.aGe();
        if ((bf.mA((String)localObject3)) || (!((String)localObject3).equals(paramArrayOfByte)) || (!o.dH(paramArrayOfByte)))
        {
          i = 0;
          break;
        }
        if (localObject1 != null)
        {
          localObject1 = ((LinkedList)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              localObject3 = (jz)((Iterator)localObject1).next();
              if ((!bf.mA(((jz)localObject3).jLx)) && (((jz)localObject3).jLx.equals(com.tencent.mm.u.m.xL())))
              {
                i = 0;
                break;
              }
            }
          }
        }
        if (l.a.szS != null)
        {
          if (l.a.szS.cH(paramArrayOfByte, com.tencent.mm.u.m.xL()))
          {
            v.i("MicroMsg.BigBallContactAssemblerImpl", "kicked self shareing");
            localObject1 = new qo();
            ((qo)localObject1).fXw.userName = paramArrayOfByte;
            com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
          }
          l.a.szS.a(paramArrayOfByte, null, 0.0D, 0.0D, "", "", "");
        }
        if ((l.a.szR != null) && (!bf.mA(l.a.szS.aGo())))
        {
          v.i("MicroMsg.BigBallContactAssemblerImpl", "sync remove chatroom end track %s", new Object[] { l.a.szR.aGe() });
          localObject1 = new el();
          ((el)localObject1).fIe.username = l.a.szR.aGe();
          com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
        }
        i = 1;
        break;
        if (localObject1 != null)
        {
          localObject1 = ((LinkedList)localObject1).iterator();
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label2010;
            }
            localObject3 = (jz)((Iterator)localObject1).next();
            if (!bf.mA(((jz)localObject3).jLx)) {
              if (((jz)localObject3).jLx.equals(com.tencent.mm.u.m.xL())) {
                break;
              }
            }
          }
        }
        if (l.a.szL != null) {
          l.a.szL.a(paramArrayOfByte, null, "", "", 0);
        }
        localObject1 = new qk();
        ((qk)localObject1).fXk.fXn = true;
        com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
        localObject1 = new qj();
        ((qj)localObject1).fXi.fXj = true;
        com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
        break label141;
        i = 1;
        break label218;
        i = paramamb.tBU.krk;
        break label249;
        j = paramamb.tBU.tos;
        break label295;
        i = 0;
        break label566;
        if ((!paramx1.bKU()) || (!com.tencent.mm.modelbiz.e.hY(paramx1.field_username)) || (paramx1 == null) || (!paramx1.bKU()) || (!com.tencent.mm.modelbiz.e.hY(paramx1.field_username))) {
          break label694;
        }
        v.i("MicroMsg.BigBallContactAssemblerImpl", "dealPlaceSubscribeBizToTop uct : " + paramx1.field_username);
        ap.yY();
        localObject1 = com.tencent.mm.u.c.wW().Rl(paramx1.field_username);
        w.DH().hO(paramx1.field_username);
        if (localObject1 != null) {
          break label694;
        }
        ap.yY();
        if (com.tencent.mm.u.c.wW().Rl("officialaccounts") == null)
        {
          localObject1 = new ae("officialaccounts");
          ((ae)localObject1).bLr();
          ap.yY();
          com.tencent.mm.u.c.wW().d((ae)localObject1);
        }
        localObject1 = new ae(paramx1.field_username);
        ((ae)localObject1).cw("officialaccounts");
        ap.yY();
        com.tencent.mm.u.c.wW().d((ae)localObject1);
        break label694;
        if (((paramx2 != null) && ((paramx2.field_type & 0x800) == (paramx1.field_type & 0x800))) || (!com.tencent.mm.modelbiz.e.ia(paramx1.field_username)) || (com.tencent.mm.modelbiz.e.dr(paramx1.field_username))) {
          break label694;
        }
        z(paramx1);
        break label694;
        if (!com.tencent.mm.modelbiz.e.ie(paramx1.field_username)) {
          break label884;
        }
        ap.yY();
        if (com.tencent.mm.u.c.wW().Rl(paramx1.field_username) != null) {
          break label884;
        }
        paramArrayOfByte = w.DH().hO(paramx1.field_username);
        localObject1 = new ae(paramx1.field_username);
        if (!paramArrayOfByte.CJ())
        {
          v.i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", new Object[] { paramArrayOfByte.CO(), paramx1.field_username });
          ((ae)localObject1).cw(bf.mz(paramArrayOfByte.CO()));
        }
        for (;;)
        {
          ((ae)localObject1).bLr();
          ap.yY();
          com.tencent.mm.u.c.wW().d((ae)localObject1);
          break;
          ((ae)localObject1).cw(null);
        }
        j = 0;
        break label944;
        if ((paramx2 != null) && ((paramx2.field_type & 0x8) == (paramx1.field_type & 0x8))) {
          break label1055;
        }
        ap.yY();
        com.tencent.mm.u.c.wW().e(new String[] { paramx1.field_username }, "");
        break label1055;
        paramx2.bLr();
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/bbom/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */