package com.tencent.mm.ui.chatting;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.lz;
import com.tencent.mm.e.a.mx;
import com.tencent.mm.e.a.my;
import com.tencent.mm.e.a.nu;
import com.tencent.mm.e.a.nw;
import com.tencent.mm.e.a.rj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.pluginsdk.model.app.am.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

public final class ed
{
  public static void V(au paramau)
  {
    GMTrace.i(2382364672000L, 17750);
    v.i("MicroMsg.ResendMsgLogic", "resendAppMsg, msgId:%d", new Object[] { Long.valueOf(paramau.field_msgId) });
    long l2 = ay.gk(paramau.field_talker);
    long l1 = l2;
    if (l2 == paramau.field_createTime) {
      l1 = l2 + 1L;
    }
    paramau.z(l1);
    ap.yY();
    com.tencent.mm.u.c.wT().a(paramau.field_msgId, paramau);
    String str = paramau.field_content;
    int j = paramau.field_isSend;
    Object localObject = paramau.field_talker;
    int i;
    if ((o.eQ((String)localObject)) || (com.tencent.mm.u.j.eu((String)localObject)))
    {
      i = 1;
      localObject = str;
      if (i != 0)
      {
        localObject = str;
        if (str != null)
        {
          localObject = str;
          if (j == 0) {
            localObject = ay.gj(str);
          }
        }
      }
      localObject = f.a.ek((String)localObject);
      if (((localObject == null) || (19 != ((f.a)localObject).type)) && ((localObject == null) || (24 != ((f.a)localObject).type))) {
        break label254;
      }
      localObject = new lz();
      ((lz)localObject).fSV.type = 4;
      ((lz)localObject).fSV.fTa = paramau;
      ((lz)localObject).fSV.toUser = paramau.field_talker;
      a.uql.m((com.tencent.mm.sdk.b.b)localObject);
    }
    for (;;)
    {
      ay.L(paramau.field_msgId);
      GMTrace.o(2382364672000L, 17750);
      return;
      i = 0;
      break;
      label254:
      l.V(paramau);
    }
  }
  
  public static void aB(au paramau)
  {
    GMTrace.i(2382096236544L, 17748);
    v.i("MicroMsg.ResendMsgLogic", "resendEmoji, msgId:%d", new Object[] { Long.valueOf(paramau.field_msgId) });
    rj localrj = new rj();
    localrj.fYk.fCQ = paramau;
    a.uql.m(localrj);
    GMTrace.o(2382096236544L, 17748);
  }
  
  public static void aC(au paramau)
  {
    GMTrace.i(2382498889728L, 17751);
    v.i("MicroMsg.ResendMsgLogic", "resendTextMsg, msgId:%d", new Object[] { Long.valueOf(paramau.field_msgId) });
    aP(paramau);
    GMTrace.o(2382498889728L, 17751);
  }
  
  public static void aD(au paramau)
  {
    GMTrace.i(2382767325184L, 17753);
    v.i("MicroMsg.ResendMsgLogic", "resendCardMsg, msgId:%d", new Object[] { Long.valueOf(paramau.field_msgId) });
    aP(paramau);
    GMTrace.o(2382767325184L, 17753);
  }
  
  public static void aE(au paramau)
  {
    GMTrace.i(2382230454272L, 17749);
    v.i("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, msgId:%d", new Object[] { Long.valueOf(paramau.field_msgId) });
    long l2 = ay.gk(paramau.field_talker);
    long l1 = l2;
    if (l2 == paramau.field_createTime) {
      l1 = l2 + 1L;
    }
    paramau.z(l1);
    ap.yY();
    com.tencent.mm.u.c.wT().a(paramau.field_msgId, paramau);
    com.tencent.mm.pluginsdk.model.app.b localb = an.abF().eb(paramau.field_msgId);
    if ((localb != null) && (localb.field_msgInfoId == paramau.field_msgId))
    {
      v.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, upload app attach first");
      localb.field_status = 101L;
      localb.field_offset = 0L;
      localb.field_lastModifyTime = (System.currentTimeMillis() / 1000L);
      an.abF().c(localb, new String[0]);
      an.bDe().run();
      GMTrace.o(2382230454272L, 17749);
      return;
    }
    v.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, directly send app mag");
    an.bDe();
    am.a.eg(paramau.field_msgId);
    GMTrace.o(2382230454272L, 17749);
  }
  
  public static void aM(au paramau)
  {
    GMTrace.i(2381827801088L, 17746);
    v.i("MicroMsg.ResendMsgLogic", "resendVoiceMsg, msgId:%d", new Object[] { Long.valueOf(paramau.field_msgId) });
    if (o.fq(paramau.field_talker))
    {
      localObject = new my();
      ((my)localObject).fTX.fCQ = paramau;
      a.uql.m((com.tencent.mm.sdk.b.b)localObject);
      GMTrace.o(2381827801088L, 17746);
      return;
    }
    Object localObject = new mx();
    ((mx)localObject).fTW.fCQ = paramau;
    a.uql.m((com.tencent.mm.sdk.b.b)localObject);
    GMTrace.o(2381827801088L, 17746);
  }
  
  public static void aN(au paramau)
  {
    GMTrace.i(2381962018816L, 17747);
    nu localnu = new nu();
    long l2 = ay.gk(paramau.field_talker);
    v.i("MicroMsg.ResendMsgLogic", "resendMsgImage, msgId:%d, time[%d - > %d]", new Object[] { Long.valueOf(paramau.field_msgId), Long.valueOf(paramau.field_createTime), Long.valueOf(l2) });
    long l1 = l2;
    if (l2 == paramau.field_createTime) {
      l1 = l2 + 1L;
    }
    paramau.z(l1);
    ap.yY();
    com.tencent.mm.u.c.wT().a(paramau.field_msgId, paramau);
    localnu.fUP.fCQ = paramau;
    a.uql.m(localnu);
    GMTrace.o(2381962018816L, 17747);
  }
  
  public static void aO(au paramau)
  {
    GMTrace.i(2382633107456L, 17752);
    v.i("MicroMsg.ResendMsgLogic", "resendLocation, msgId:%d", new Object[] { Long.valueOf(paramau.field_msgId) });
    aP(paramau);
    GMTrace.o(2382633107456L, 17752);
  }
  
  private static void aP(au paramau)
  {
    GMTrace.i(2382901542912L, 17754);
    long l = paramau.field_msgId;
    if (l == -1L)
    {
      v.e("MicroMsg.ResendMsgLogic", "sendMsgInternal failed msgId " + l);
      GMTrace.o(2382901542912L, 17754);
      return;
    }
    if ((paramau.field_talker.equals("medianote")) && ((m.xP() & 0x4000) == 0))
    {
      GMTrace.o(2382901542912L, 17754);
      return;
    }
    v.d("MicroMsg.ResendMsgLogic", "sendMsgInternal, start send msgId: %d", new Object[] { Long.valueOf(l) });
    Object localObject = new com.tencent.mm.modelmulti.j(l);
    if (!ap.vd().a((k)localObject, 0))
    {
      v.e("MicroMsg.ResendMsgLogic", "sendMsgInternal, doScene return false, directly mark msg to failed");
      paramau.dv(5);
      ap.yY();
      com.tencent.mm.u.c.wT().a(paramau.field_msgId, paramau);
      localObject = new nw();
      ((nw)localObject).fUS.fCQ = paramau;
      a.uql.m((com.tencent.mm.sdk.b.b)localObject);
    }
    GMTrace.o(2382901542912L, 17754);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */