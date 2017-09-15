package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.af;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.c.amt;
import com.tencent.mm.protocal.c.lt;
import com.tencent.mm.protocal.c.od;
import com.tencent.mm.protocal.c.oe;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.bg;

public final class g
  implements p
{
  public g()
  {
    GMTrace.i(13236686553088L, 98621);
    GMTrace.o(13236686553088L, 98621);
  }
  
  public final void a(lt paramlt, byte[] paramArrayOfByte, boolean paramBoolean, r paramr)
  {
    GMTrace.i(13236820770816L, 98622);
    switch (paramlt.tqs)
    {
    default: 
      GMTrace.o(13236820770816L, 98622);
      return;
    }
    paramr = (amt)new amt().aD(paramArrayOfByte);
    int i = paramr.tPF;
    com.tencent.mm.kernel.h.vI().vr().get(2, null);
    t localt = com.tencent.mm.kernel.h.vI().vr();
    v.i("MicroMsg.UserInfoSyncExtension", "processModUserInfo bitFlag:%d status:%d PluginFlag:%d PluginSwitch:%d", new Object[] { Integer.valueOf(paramr.tPF), Integer.valueOf(paramr.jLP), Integer.valueOf(paramr.tbV), Integer.valueOf(paramr.tPM) });
    paramArrayOfByte = n.a(paramr.trH);
    Object localObject = n.a(paramr.tJy);
    String str1 = n.a(paramr.tPG);
    String str2 = n.a(paramr.tPH);
    i = paramr.tbS;
    paramlt = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramArrayOfByte);
    if ((paramlt == null) || (paramlt.field_username == null) || (!paramlt.field_username.equals(paramArrayOfByte))) {
      paramlt = new x(paramArrayOfByte);
    }
    for (;;)
    {
      paramlt.bO(paramr.hAq);
      paramlt.bR((String)localObject);
      paramlt.ck(RegionCodeDecoder.ab(paramr.hAu, paramr.hAm, paramr.hAn));
      paramlt.di(paramr.hAl);
      paramlt.ce(paramr.hAo);
      paramlt.dd(paramr.tLh);
      paramlt.ci(paramr.tLf);
      paramlt.bU(paramr.tLg);
      paramlt.dj(i);
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Q(paramlt);
      localt.set(2, paramArrayOfByte);
      localt.set(4, localObject);
      localt.set(5, str1);
      localt.set(6, str2);
      localt.set(9, Integer.valueOf(i));
      localObject = new StringBuilder("doCmd : status ");
      i = paramr.jLP;
      paramArrayOfByte = "code=" + Integer.toHexString(i) + ", status = " + i;
      paramlt = paramArrayOfByte;
      if ((i & 0x1) != 0) {
        paramlt = paramArrayOfByte + ", open";
      }
      paramArrayOfByte = paramlt;
      if ((i & 0x2) != 0) {
        paramArrayOfByte = paramlt + ", email-verified";
      }
      paramlt = paramArrayOfByte;
      if ((i & 0x4) != 0) {
        paramlt = paramArrayOfByte + ", mobile-verified";
      }
      paramArrayOfByte = paramlt;
      if ((i & 0x8) != 0) {
        paramArrayOfByte = paramlt + ", hide-qq-search";
      }
      paramlt = paramArrayOfByte;
      if ((i & 0x10) != 0) {
        paramlt = paramArrayOfByte + ", hide-qq-promote";
      }
      paramArrayOfByte = paramlt;
      if ((i & 0x20) != 0) {
        paramArrayOfByte = paramlt + ", need-verify";
      }
      paramlt = paramArrayOfByte;
      if ((i & 0x40) != 0) {
        paramlt = paramArrayOfByte + ", has-qq-msg";
      }
      paramArrayOfByte = paramlt;
      if ((i & 0x80) != 0) {
        paramArrayOfByte = paramlt + ", no-qq-promote";
      }
      paramlt = paramArrayOfByte;
      if ((i & 0x100) != 0) {
        paramlt = paramArrayOfByte + ", no-mobile-promote";
      }
      paramArrayOfByte = paramlt;
      if ((i & 0x200) != 0) {
        paramArrayOfByte = paramlt + ", hide-mobile_search";
      }
      paramlt = paramArrayOfByte;
      if ((i & 0x1000) != 0) {
        paramlt = paramArrayOfByte + ", open-float-bottle";
      }
      paramArrayOfByte = paramlt;
      if ((i & 0x20000) != 0) {
        paramArrayOfByte = paramlt + ", bind but not upload";
      }
      v.d("MicroMsg.UserInfoSyncExtension", paramArrayOfByte);
      localt.set(7, Integer.valueOf(paramr.jLP));
      if (paramr.hAp != 0)
      {
        paramlt = new bg();
        paramlt.gkq = 1;
        paramlt.gkh = paramr.hAl;
        paramlt.signature = paramr.hAo;
        paramlt.countryCode = paramr.hAu;
        paramlt.hnx = paramr.hAm;
        paramlt.hnw = paramr.hAn;
        paramlt.gkv = paramr.tLf;
        v.d("MicroMsg.UserInfoSyncExtension", " getPersonalCard weibo url : " + paramlt.gkv + " nickName :" + paramr.tLg);
        bg.a(paramlt);
      }
      paramArrayOfByte = new StringBuilder("userinfo Plugstate: ");
      i = paramr.tbV;
      paramlt = "code=" + Integer.toHexString(i) + ", pluginFlag = " + i;
      if ((i & 0x1) != 0)
      {
        paramlt = paramlt + ", QQMAIL_UNINSTALL";
        label1027:
        if ((i & 0x2) == 0) {
          break label1956;
        }
        paramlt = paramlt + ", PM_UNINSTALL";
        label1055:
        if ((i & 0x4) == 0) {
          break label1980;
        }
        paramlt = paramlt + ", FM_UNINSTALL";
        label1083:
        if ((i & 0x8) == 0) {
          break label2004;
        }
        paramlt = paramlt + ", WEIBO_UNINSTALL";
        label1112:
        if ((i & 0x10) == 0) {
          break label2028;
        }
        paramlt = paramlt + ", MEDIANOTE_UNINSTALL";
        label1141:
        if ((i & 0x20) == 0) {
          break label2052;
        }
        paramlt = paramlt + ", QMSG_UNINSTALL";
        label1170:
        if ((i & 0x40) == 0) {
          break label2076;
        }
        paramlt = paramlt + ", BOTTLE_UNINSTALL";
        label1199:
        if ((i & 0x80) == 0) {
          break label2100;
        }
        paramlt = paramlt + ", QSYNC_UNISTALL";
        label1229:
        if ((i & 0x100) == 0) {
          break label2124;
        }
        paramlt = paramlt + ", SHAKE_UNISTALL";
        label1259:
        if ((i & 0x200) == 0) {
          break label2148;
        }
        paramlt = paramlt + ", LBS_UNISTALL";
        label1289:
        if ((i & 0x400) == 0) {
          break label2172;
        }
        paramlt = paramlt + ", BOTTLE_CHART_INSTALL";
        label1319:
        if ((i & 0x1000) == 0) {
          break label2196;
        }
        paramlt = paramlt + ",CHECKQQF_UNINSTALL";
        label1349:
        if ((i & 0x8000) == 0) {
          break label2220;
        }
        paramlt = paramlt + ",MM_FEEDSAPP_UNINSTALL";
        label1379:
        v.i("MicroMsg.UserInfoSyncExtension", paramlt);
        localt.set(34, Integer.valueOf(paramr.tbV));
        if (1 != paramr.tPp.tsd) {
          break label2244;
        }
      }
      label1956:
      label1980:
      label2004:
      label2028:
      label2052:
      label2076:
      label2100:
      label2124:
      label2148:
      label2172:
      label2196:
      label2220:
      label2244:
      for (paramBoolean = true;; paramBoolean = false)
      {
        localt.set(8200, Boolean.valueOf(bf.b(Boolean.valueOf(paramBoolean), false)));
        localt.set(8201, Integer.valueOf(bf.a(Integer.valueOf(paramr.tPp.tse.tsh), 22)));
        localt.set(8208, Integer.valueOf(bf.a(Integer.valueOf(paramr.tPp.tse.tsi), 8)));
        localt.set(66049, Integer.valueOf(paramr.tLd));
        localt.set(66050, paramr.tLe);
        localt.set(40, Integer.valueOf(paramr.tPM));
        ao.hlE.L("last_login_use_voice", paramr.tPM);
        localt.set(41, Integer.valueOf(paramr.tLh));
        localt.set(43, paramr.tLg);
        v.d("MicroMsg.UserInfoSyncExtension", "doCmd PluginSwitch:" + paramr.tPM + " WeiboFlag:" + paramr.tLh);
        localt.set(868518889, Integer.valueOf(paramr.tPB));
        v.d("MicroMsg.UserInfoSyncExtension", "doCmd USERINFO_TXNEWSCATEGORY:" + paramr.tPB);
        localt.set(42, paramr.hAq);
        v.d("MicroMsg.UserInfoSyncExtension", "userid:" + paramr.tuV + " username:" + paramr.tuW);
        localt.set(65825, paramr.tuV);
        localt.set(65826, paramr.tuW);
        v.d("MicroMsg.UserInfoSyncExtension", "getiAlbumFlag " + paramr.hAr);
        v.d("MicroMsg.UserInfoSyncExtension", "getiAlbumStyle " + paramr.hAs);
        v.d("MicroMsg.UserInfoSyncExtension", "getPcAlbumBGImgID " + paramr.hAt);
        paramlt = bf.mz((String)com.tencent.mm.kernel.h.vI().vr().get(65830, null));
        if ((paramlt == null) || (paramlt.length() == 0))
        {
          paramlt = paramr.tPP;
          if ((paramlt != null) && (paramlt.length() > 0)) {
            com.tencent.mm.kernel.h.vI().vr().set(65830, paramlt);
          }
        }
        s.a(1, paramr);
        break;
        paramlt = paramlt + ", QQMAIL_INSTALL";
        break label1027;
        paramlt = paramlt + ", PM_INSTALL";
        break label1055;
        paramlt = paramlt + ", FM_INSTALL";
        break label1083;
        paramlt = paramlt + ", WEIBO_INSTALL";
        break label1112;
        paramlt = paramlt + ", MEDIANOTE_INSTALL";
        break label1141;
        paramlt = paramlt + ", QMSG_INSTALL";
        break label1170;
        paramlt = paramlt + ", BOTTLE_INSTALL";
        break label1199;
        paramlt = paramlt + ", QSYNC_INSTALL";
        break label1229;
        paramlt = paramlt + ", SHAKE_INSTALL";
        break label1259;
        paramlt = paramlt + ", LBS_INSTALL";
        break label1289;
        paramlt = paramlt + ", BOTTLE_CHART_INSTALL";
        break label1319;
        paramlt = paramlt + ",CHECKQQF_INSTALL";
        break label1349;
        paramlt = paramlt + ",MM_FEEDSAPP_INSTALL";
        break label1379;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/messenger/foundation/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */