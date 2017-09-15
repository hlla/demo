package com.tencent.mm.av;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.ig;
import com.tencent.mm.e.a.ll;
import com.tencent.mm.e.b.af;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ag.a;
import com.tencent.mm.u.ag.b;
import com.tencent.mm.u.ag.b.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.x.h;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.d.b;

public final class n
  implements d
{
  public n()
  {
    GMTrace.i(1412910022656L, 10527);
    GMTrace.o(1412910022656L, 10527);
  }
  
  public final d.b b(final d.a parama)
  {
    GMTrace.i(1413044240384L, 10528);
    Object localObject2 = parama.hsc;
    String str = com.tencent.mm.platformtools.n.a(((bu)localObject2).tdx);
    if ((!"fmessage".equals(str)) && (((bu)localObject2).mrC != 37))
    {
      GMTrace.o(1413044240384L, 10528);
      return null;
    }
    Object localObject1 = com.tencent.mm.platformtools.n.a(((bu)localObject2).tdz);
    parama = au.d.RH((String)localObject1);
    Object localObject3 = m.xL();
    if ((parama.rTh != null) && (parama.rTh.equals(localObject3)))
    {
      v.d("MicroMsg.VerifyMessageExtension", "onPreAddMessage, verify scene:%d, content:%s", new Object[] { Integer.valueOf(parama.scene), localObject1 });
      v.e("MicroMsg.VerifyMessageExtension", "fromUserName is self, simply drop this msg");
      GMTrace.o(1413044240384L, 10528);
      return null;
    }
    localObject3 = new h();
    ((h)localObject3).username = parama.rTh;
    ((h)localObject3).gkg = 3;
    ((h)localObject3).aV(true);
    ((h)localObject3).fRM = -1;
    ((h)localObject3).hrk = parama.uIk;
    ((h)localObject3).hrj = parama.uIl;
    v.d("MicroMsg.VerifyMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[] { parama.rTh, ((h)localObject3).Bs(), ((h)localObject3).Bt() });
    com.tencent.mm.x.n.Bm().a((h)localObject3);
    if (!bf.mA(parama.rTh))
    {
      if (parama.scene == 18)
      {
        l.KA().a((bu)localObject2, parama);
        ap.yY();
        com.tencent.mm.u.c.vr().set(73729, Integer.valueOf(1));
        ap.yY();
        localObject1 = com.tencent.mm.u.c.wR().Rb(parama.uIu);
        if ((localObject1 == null) || ((int)((com.tencent.mm.j.a)localObject1).gTG <= 0)) {
          ag.a.hlA.a(parama.uIu, null, new ag.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              GMTrace.i(1416265465856L, 10552);
              ap.yY();
              v.d("MicroMsg.VerifyMessageExtension", String.valueOf(com.tencent.mm.u.c.wR().Rb(parama.uIu)));
              paramAnonymousString = new ig();
              paramAnonymousString.fNG.fNH = parama.uIu;
              paramAnonymousString.fNG.type = 1;
              com.tencent.mm.sdk.b.a.uql.m(paramAnonymousString);
              GMTrace.o(1416265465856L, 10552);
            }
          });
        }
        for (;;)
        {
          GMTrace.o(1413044240384L, 10528);
          return null;
          localObject2 = ((af)localObject1).field_username;
          if ((localObject2 != null) && (!o.eT((String)localObject2)))
          {
            ((x)localObject1).setUsername(parama.uIu);
            ((x)localObject1).bX(null);
            ap.yY();
            com.tencent.mm.u.c.wR().a((String)localObject2, (x)localObject1);
          }
          localObject1 = new ig();
          ((ig)localObject1).fNG.fNH = parama.uIu;
          ((ig)localObject1).fNG.type = 1;
          com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
        }
      }
      if (ay.fc(parama.scene))
      {
        l.KB().a((bu)localObject2, parama);
        ap.yY();
        com.tencent.mm.u.c.vr().set(73730, Integer.valueOf(1));
        GMTrace.o(1413044240384L, 10528);
        return null;
      }
      if (parama.scene == 48)
      {
        localObject3 = new ll();
        ((ll)localObject3).fSg.fSi = ((String)localObject1);
        ((ll)localObject3).fSg.fJC = parama.rTh;
        com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject3);
      }
    }
    localObject1 = new f();
    ((f)localObject1).field_createTime = e.i(str, ((bu)localObject2).ofk);
    int i;
    if (((bu)localObject2).jLP == 4)
    {
      i = 2;
      ((f)localObject1).field_isSend = (i + 0);
      ((f)localObject1).field_msgContent = com.tencent.mm.platformtools.n.a(((bu)localObject2).tdz);
      ((f)localObject1).field_svrId = ((bu)localObject2).tdE;
      ((f)localObject1).field_talker = parama.rTh;
      ap.yY();
      localObject2 = com.tencent.mm.u.c.wR().Rb(parama.chatroomName);
      if ((localObject2 != null) && ((int)((com.tencent.mm.j.a)localObject2).gTG != -1)) {
        ((f)localObject1).field_chatroomName = parama.chatroomName;
      }
      switch (parama.fJB)
      {
      case 3: 
      case 4: 
      default: 
        ((f)localObject1).field_type = 1;
        label677:
        if (!bf.mA(parama.uIu))
        {
          ((f)localObject1).field_encryptTalker = parama.uIu;
          if (l.Kz().kY(parama.uIu) != null)
          {
            parama = l.Ky();
            localObject2 = ((f)localObject1).field_encryptTalker;
            str = ((f)localObject1).field_talker;
            localObject2 = "update fmessage_msginfo set talker = '" + bf.my(str) + "'  where talker = '" + bf.my((String)localObject2) + "'";
            parama.gUp.eE("fmessage_msginfo", (String)localObject2);
            l.Kz().c(0L, ((f)localObject1).field_encryptTalker);
          }
          l.Ky().a((f)localObject1);
        }
        break;
      }
    }
    for (;;)
    {
      GMTrace.o(1413044240384L, 10528);
      return null;
      i = 0;
      break;
      ((f)localObject1).field_type = 1;
      break label677;
      ((f)localObject1).field_type = 2;
      break label677;
      ((f)localObject1).field_type = 3;
      break label677;
      v.e("MicroMsg.VerifyMessageExtension", "it should not go in here");
      parama = l.Kz().kZ(((f)localObject1).field_talker);
      if (parama != null)
      {
        ((f)localObject1).field_encryptTalker = parama.field_talker;
        ((f)localObject1).field_talker = parama.field_talker;
      }
      l.Ky().a((f)localObject1);
    }
  }
  
  public final void h(au paramau)
  {
    GMTrace.i(1413178458112L, 10529);
    GMTrace.o(1413178458112L, 10529);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/av/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */