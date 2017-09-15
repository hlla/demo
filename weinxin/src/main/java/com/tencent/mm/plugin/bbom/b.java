package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.av.h;
import com.tencent.mm.av.i;
import com.tencent.mm.av.l;
import com.tencent.mm.e.a.ig;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ag.a;
import com.tencent.mm.u.ag.b;
import com.tencent.mm.u.ag.b.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.ay.b;
import com.tencent.mm.u.o;
import com.tencent.mm.y.d.a;
import java.util.Stack;

public final class b
  implements com.tencent.mm.plugin.messenger.foundation.a.a
{
  public b()
  {
    GMTrace.i(8020180336640L, 59755);
    GMTrace.o(8020180336640L, 59755);
  }
  
  public static void a(bu parambu, ay.b paramb, x paramx)
  {
    GMTrace.i(8020448772096L, 59757);
    String str1 = com.tencent.mm.platformtools.n.a(parambu.tdx);
    ap.yY();
    com.tencent.mm.u.c.vr().set(73729, Integer.valueOf(1));
    String str2 = paramx.field_nickname;
    h localh = new h();
    localh.field_content = com.tencent.mm.platformtools.n.a(parambu.tdz);
    localh.field_createtime = bf.Nz();
    localh.field_imgpath = "";
    if (parambu.mrC == 3)
    {
      paramx = aa.getContext().getString(R.l.eDb);
      localh.field_sayhicontent = paramx;
      localh.field_sayhiuser = str1;
      localh.field_scene = 18;
      if (parambu.jLP <= 3) {
        break label233;
      }
    }
    label233:
    for (int i = parambu.jLP;; i = 3)
    {
      localh.field_status = i;
      localh.field_svrid = parambu.tdE;
      localh.field_talker = str2;
      localh.field_type = parambu.mrC;
      localh.field_isSend = 0;
      localh.field_sayhiencryptuser = str1;
      localh.field_ticket = paramb.hmz;
      l.KA().a(localh);
      parambu = new ig();
      parambu.fNG.fNH = str1;
      com.tencent.mm.sdk.b.a.uql.m(parambu);
      GMTrace.o(8020448772096L, 59757);
      return;
      paramx = com.tencent.mm.platformtools.n.a(parambu.tdz);
      break;
    }
  }
  
  public final void a(final d.a parama, au arg2, final String paramString1, final String paramString2, boolean paramBoolean)
  {
    GMTrace.i(8020314554368L, 59756);
    parama = parama.hsc;
    paramString2 = ay.gm(parama.tdC);
    x localx;
    if (paramString2 != null)
    {
      ???.cO(paramString2.hmy);
      ???.cL(paramString2.hmx);
      v.i("MicroMsg.BaseMsgCallbackImpl", "bizClientMsgId = %s", new Object[] { paramString2.hmx });
      if ((paramString2.hmz != null) && (paramString2.scene == 1) && (parama.mrC != 10000))
      {
        ap.yY();
        localx = com.tencent.mm.u.c.wR().Rb(paramString1);
        if ((localx != null) && ((int)localx.gTG > 0)) {
          break label292;
        }
        ag.a.hlA.a(paramString1, null, new ag.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            GMTrace.i(8020046118912L, 59754);
            ap.yY();
            paramAnonymousString = com.tencent.mm.u.c.wR().Rb(paramString1);
            b.a(parama, paramString2, paramAnonymousString);
            GMTrace.o(8020046118912L, 59754);
          }
        });
      }
    }
    for (;;)
    {
      int i;
      label159:
      int j;
      long l;
      if ((o.eU(paramString1)) && (o.fJ(paramString1)))
      {
        i = 1;
        if ((!o.dH(paramString1)) || (o.fI(paramString1))) {
          break label309;
        }
        j = 1;
        if ((!paramBoolean) && (???.bLX()) && (i == 0) && (j == 0))
        {
          com.tencent.mm.modelcontrol.c.Es();
          if (com.tencent.mm.modelcontrol.c.l(???))
          {
            parama = com.tencent.mm.ah.n.GV();
            l = ???.field_msgId;
            com.tencent.mm.modelcontrol.c.Es();
            if (!com.tencent.mm.modelcontrol.c.Et()) {}
          }
        }
      }
      synchronized (parama.hEb)
      {
        if (parama.hEb.size() >= 100) {
          parama.hEb.remove(0);
        }
        parama.hEb.push(Long.valueOf(l));
        parama.hEf = System.currentTimeMillis();
        parama.start();
        GMTrace.o(8020314554368L, 59756);
        return;
        label292:
        a(parama, paramString2, localx);
        continue;
        i = 0;
        break label159;
        label309:
        j = 0;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/bbom/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */