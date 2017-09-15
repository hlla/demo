package com.tencent.mm.u;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.o;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.protocal.c.ang;
import com.tencent.mm.protocal.c.ap;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.bgb;
import com.tencent.mm.protocal.c.bme;
import com.tencent.mm.protocal.c.dr;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;

public final class u
{
  public static void a(bgb parambgb, boolean paramBoolean)
  {
    GMTrace.i(13156155916288L, 98021);
    int j = parambgb.ueL;
    int i;
    label92:
    t localt;
    Object localObject1;
    long l;
    label240:
    label252:
    label647:
    boolean bool1;
    String str1;
    String str2;
    int k;
    Object localObject2;
    label803:
    label968:
    boolean bool2;
    if (parambgb.ueM == null)
    {
      i = -1;
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile succ update:%d unifyFlag:%d, auth:%s, acct:%s, network:%s autoauth:%b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), parambgb.ueM, parambgb.ueN, parambgb.ueO, Boolean.valueOf(paramBoolean) });
      i = 0;
      if ((j & 0x1) == 0) {
        break label1302;
      }
      i = parambgb.ueM.lcP;
      h.vJ();
      h.eO(i);
      localt = h.vI().vr();
      localt.set(256, Boolean.valueOf(false));
      if ((j & 0x1) != 0)
      {
        if (parambgb.ueM.tfM <= 0) {
          break label1365;
        }
        localt.a(w.a.uxx, Long.valueOf(parambgb.ueM.tfM));
        localt.a(w.a.uxz, Long.valueOf(bf.Nz()));
        localt.a(w.a.uxy, Long.valueOf(com.tencent.mm.protocal.d.sXh));
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile need update flag[%d], autoauth[%b]", new Object[] { Integer.valueOf(parambgb.ueM.tfM), Boolean.valueOf(paramBoolean) });
        if (!paramBoolean) {
          break label1321;
        }
        localObject1 = c.oRz;
        if (parambgb.ueM.tfM != 2) {
          break label1313;
        }
        l = 19L;
        ((c)localObject1).a(148L, l, 1L, true);
      }
      if ((j & 0x2) == 0) {
        break label1413;
      }
      localObject1 = parambgb.ueN;
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile acctsect BindUin:%s, Status:%d, UserName:%s, NickName:%s, BindEmail:%s, BindMobile:%s, Alias:%s, PluginFlag:%d, RegType:%d, DeviceInfoXml:%s, SafeDevice:%d, OfficialUserName:%s, OfficialUserName:%s PushMailStatus:%d, FSURL:%s", new Object[] { o.getString(((ap)localObject1).tbS), Integer.valueOf(((ap)localObject1).jLP), ((ap)localObject1).jLx, ((ap)localObject1).jMD, ((ap)localObject1).tbT, ((ap)localObject1).tbU, ((ap)localObject1).hAq, Integer.valueOf(((ap)localObject1).tbV), Integer.valueOf(((ap)localObject1).tbW), ((ap)localObject1).tbX, Integer.valueOf(((ap)localObject1).tbY), ((ap)localObject1).tbZ, ((ap)localObject1).tbZ, Integer.valueOf(((ap)localObject1).tcb), ((ap)localObject1).tcc });
      if (!paramBoolean) {
        localt.set(52, Integer.valueOf(((ap)localObject1).tbW));
      }
      localt.set(9, Integer.valueOf(((ap)localObject1).tbS));
      localt.set(7, Integer.valueOf(((ap)localObject1).jLP));
      localt.set(2, ((ap)localObject1).jLx);
      localt.set(4, ((ap)localObject1).jMD);
      localt.set(5, ((ap)localObject1).tbT);
      localt.set(6, ((ap)localObject1).tbU);
      localt.set(42, ((ap)localObject1).hAq);
      localt.set(34, Integer.valueOf(((ap)localObject1).tbV));
      h.vI().vs().RV(((ap)localObject1).tbX);
      localt.set(64, Integer.valueOf(((ap)localObject1).tbY));
      localt.set(21, ((ap)localObject1).tbZ);
      localt.set(22, ((ap)localObject1).tbZ);
      localt.set(17, Integer.valueOf(((ap)localObject1).tcb));
      ao.hlE.L("login_weixin_username", ((ap)localObject1).jLx);
      ao.hlE.c(((ap)localObject1).tbU, ((ap)localObject1).tbS, ((ap)localObject1).tbT);
      bool1 = false;
      if ((j & 0x1) == 0) {
        break label1567;
      }
      localObject1 = parambgb.ueM;
      str1 = ((dr)localObject1).tfG;
      str2 = bf.bo(com.tencent.mm.platformtools.n.a(((dr)localObject1).tfH));
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile AuthTicket:%s, NewVersion:%d, UpdateFlag:%d, AuthResultFlag:%d, authKey:%s a2Key:%s fsurl:%s", new Object[] { ((dr)localObject1).tfK, Integer.valueOf(((dr)localObject1).tfL), Integer.valueOf(((dr)localObject1).tfM), Integer.valueOf(((dr)localObject1).tfN), bf.Qi(str1), bf.Qi(str2), ((dr)localObject1).tcc });
      k = ((dr)localObject1).tfA;
      localObject2 = new o(bf.f((Integer)localt.get(9, Integer.valueOf(0))));
      if (((dr)localObject1).tfB != null) {
        break label1424;
      }
      i = -1;
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile wtBuffFlag:%d, bindQQ:%s buff len:%d", new Object[] { Integer.valueOf(k), localObject2, Integer.valueOf(i) });
      if (k == 0) {
        break label1555;
      }
      if (k != 1) {
        break label1436;
      }
      c.oRz.a(148L, 20L, 1L, false);
      byte[] arrayOfByte = com.tencent.mm.platformtools.n.a(((dr)localObject1).tfB);
      bool1 = h.vG().gWS.a(((o)localObject2).longValue(), arrayOfByte);
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.HandleAuthResponse", "WTLoginRspBuff len %s", new Object[] { Integer.valueOf(arrayOfByte.length) });
      localObject2 = bf.bo(h.vG().gWS.S(((o)localObject2).longValue()));
      localt.set(-1535680990, str1);
      localt.set(46, str2);
      localt.set(72, localObject2);
      localt.set(29, ((dr)localObject1).tcc);
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.HandleAuthResponse", "wtBuffFlag %s", new Object[] { Integer.valueOf(k) });
      if (((dr)localObject1).tfC != null)
      {
        str1 = bf.bo(com.tencent.mm.platformtools.n.a(((dr)localObject1).tfC.tit));
        if ((str1 != null) && (str1.length() > 0))
        {
          localt.set(47, str1);
          h.vI().gXM.set(18, str1);
        }
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.HandleAuthResponse", "updateProfile ksid:%s", new Object[] { bf.Qi(str1) });
      }
      i = ((dr)localObject1).tfO;
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.HandleAuthResponse", "summerauth mmtls:%d", new Object[] { Integer.valueOf(i) });
      h.vI().gXM.set(47, Integer.valueOf(i));
      localObject1 = h.vH().gXs.hsI;
      if (localObject1 != null)
      {
        if ((i & 0x1) != 0) {
          break label1561;
        }
        bool2 = true;
        label1132:
        ((com.tencent.mm.network.e)localObject1).bc(bool2);
      }
      label1141:
      if ((j & 0x4) == 0) {
        break label1592;
      }
      c.oRz.a(148L, 23L, 1L, false);
      parambgb = parambgb.ueO;
      aq.a(false, parambgb.tig, parambgb.tih, parambgb.tif);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        i = 4;
        parambgb = m.xL();
        if (bool1)
        {
          i = 1;
          parambgb = m.xK();
        }
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.HandleAuthResponse", "loginType %s", new Object[] { Integer.valueOf(i) });
        com.tencent.mm.plugin.report.b.d.o(1, i, parambgb);
      }
      localt.set(3, "");
      localt.set(19, "");
      localt.jV(true);
      h.vI().gXM.setInt(46, 0);
      a.wJ();
      GMTrace.o(13156155916288L, 98021);
      return;
      i = parambgb.ueM.tfM;
      break;
      label1302:
      com.tencent.mm.sdk.platformtools.v.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile authsect not set and new uin is 0!");
      break label92;
      label1313:
      l = 41L;
      break label240;
      label1321:
      localObject1 = c.oRz;
      if (parambgb.ueM.tfM == 2) {}
      for (l = 10L;; l = 11L)
      {
        ((c)localObject1).a(148L, l, 1L, true);
        break;
      }
      label1365:
      localt.a(w.a.uxx, Long.valueOf(parambgb.ueM.tfM));
      localt.a(w.a.uxz, Long.valueOf(bf.Nz()));
      localt.a(w.a.uxy, Long.valueOf(0L));
      break label252;
      label1413:
      com.tencent.mm.sdk.platformtools.v.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile acctsect not set!");
      break label647;
      label1424:
      i = ((dr)localObject1).tfB.tXB;
      break label803;
      label1436:
      if (k == 2)
      {
        c.oRz.a(148L, 21L, 1L, false);
        h.vG().gWS.T(((o)localObject2).longValue());
        localObject2 = bf.bo(h.vG().gWS.S(((o)localObject2).longValue()));
        localt.set(-1535680990, str1);
        localt.set(46, str2);
        localt.set(72, localObject2);
        localt.set(29, ((dr)localObject1).tcc);
        bool1 = false;
        break label968;
      }
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.HandleAuthResponse", "summerauth undefined wrBuffFlag[%d]", new Object[] { Integer.valueOf(k) });
      label1555:
      bool1 = false;
      break label968;
      label1561:
      bool2 = false;
      break label1132;
      label1567:
      com.tencent.mm.sdk.platformtools.v.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile authsect not set!");
      c.oRz.a(148L, 22L, 1L, false);
      break label1141;
      label1592:
      com.tencent.mm.sdk.platformtools.v.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile networksect not set!");
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */