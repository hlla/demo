package com.tencent.mm.modelvoice;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.o;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.d.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class r
  implements d
{
  private static Set<c> ibV;
  
  static
  {
    GMTrace.i(572572827648L, 4266);
    ibV = new HashSet();
    GMTrace.o(572572827648L, 4266);
  }
  
  public r()
  {
    GMTrace.i(571901739008L, 4261);
    GMTrace.o(571901739008L, 4261);
  }
  
  public static void b(c paramc)
  {
    GMTrace.i(572170174464L, 4263);
    ibV.remove(paramc);
    GMTrace.o(572170174464L, 4263);
  }
  
  public static void c(c paramc)
  {
    GMTrace.i(572035956736L, 4262);
    if (!ibV.contains(paramc)) {
      ibV.add(paramc);
    }
    GMTrace.o(572035956736L, 4262);
  }
  
  public final d.b b(d.a parama)
  {
    GMTrace.i(572304392192L, 4264);
    bu localbu = parama.hsc;
    if (localbu == null)
    {
      v.e("MicroMsg.VoiceMsgExtension", "onPreAddMessage cmdAM is null , give up.");
      GMTrace.o(572304392192L, 4264);
      return null;
    }
    v.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg srvId:" + localbu.tdE);
    Object localObject2 = n.a(localbu.tdx);
    if (((String)localObject2).equals(com.tencent.mm.u.m.xL())) {}
    for (Object localObject1 = n.a(localbu.tdy);; localObject1 = localObject2)
    {
      Object localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().x((String)localObject1, localbu.tdE);
      if ((((ce)localObject3).field_msgId != 0L) && (((ce)localObject3).field_createTime + 604800000L < ay.i((String)localObject1, localbu.ofk)))
      {
        v.w("MicroMsg.VoiceMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d", new Object[] { Long.valueOf(localbu.tdE) });
        ay.j((String)localObject1, localbu.tdE);
        localObject3 = m.Lz().ax(localbu.tdE);
        if ((localObject3 != null) && (!bf.mA(((p)localObject3).fyw))) {
          q.mc(((p)localObject3).fyw);
        }
      }
      final p localp = new p();
      localp.fRV = ((String)localObject1);
      localp.hZS = localbu.ofk;
      localp.fTG = localbu.tdE;
      localp.gxv = localbu.tdC;
      v.d("MicroMsg.VoiceMsgExtension", "voiceMsgExtension, onPreAddMessage.(MsgSource : %s)", new Object[] { localbu.tdC });
      localObject3 = n.a(localbu.tdz);
      localObject1 = localObject3;
      if (o.dH((String)localObject2))
      {
        localObject1 = ay.gj((String)localObject3);
        v.i("MicroMsg.VoiceMsgExtension", "chatroom voicemsg, new content=" + (String)localObject1);
      }
      localObject2 = bg.q((String)localObject1, "msg");
      if (localObject2 == null)
      {
        g.oSF.a(111L, 227L, 1L, false);
        GMTrace.o(572304392192L, 4264);
        return null;
      }
      try
      {
        localp.hYB = Integer.valueOf((String)((Map)localObject2).get(".msg.voicemsg.$length")).intValue();
        localp.clientId = ((String)((Map)localObject2).get(".msg.voicemsg.$clientmsgid"));
        i = Integer.valueOf((String)((Map)localObject2).get(".msg.voicemsg.$endflag")).intValue();
        int j = Integer.valueOf((String)((Map)localObject2).get(".msg.voicemsg.$cancelflag")).intValue();
        localp.ibS = Integer.valueOf((String)((Map)localObject2).get(".msg.voicemsg.$voicelength")).intValue();
        localp.hZN = ((String)((Map)localObject2).get(".msg.voicemsg.$fromusername"));
        localObject1 = (String)((Map)localObject2).get(".msg.commenturl");
        localp.iaR = Integer.valueOf(bf.ap((String)((Map)localObject2).get(".msg.voicemsg.$forwardflag"), "0")).intValue();
        localp.iaK = ((String)((Map)localObject2).get(".msg.voicemsg.$voiceformat"));
        localp.ibT = bf.getLong((String)((Map)localObject2).get(".msg.voicemsg.$bufid"), 0L);
        if (j == 1)
        {
          v.v("MicroMsg.VoiceMsgExtension", "cancelFlag = 1 srvId:" + localbu.tdE);
          parama = m.Lz().ax(localp.fTG);
          if (parama != null) {
            q.ma(parama.fyw);
          }
          GMTrace.o(572304392192L, 4264);
          return null;
        }
      }
      catch (Exception parama)
      {
        g.oSF.a(111L, 227L, 1L, false);
        v.e("MicroMsg.VoiceMsgExtension", "parsing voice msg xml failed");
        v.e("MicroMsg.VoiceMsgExtension", "exception:%s", new Object[] { bf.g(parama) });
        GMTrace.o(572304392192L, 4264);
        return null;
      }
      if (i == 1)
      {
        v.v("MicroMsg.VoiceMsgExtension", "endFlag = 1 srvId:" + localbu.tdE);
        localp.hrb = localp.hYB;
      }
      localp.fRM = 284334;
      localObject2 = n.a(localbu.tdB);
      if (localObject2 != null) {
        v.d("MicroMsg.VoiceMsgExtension", "Voice Buf Len:" + localObject2.length + " srvId:" + localbu.tdE);
      }
      int i = q.a(localp, (byte[])localObject2, localbu.jLP, (String)localObject1, localbu.tdC, parama);
      if (i > 0)
      {
        v.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(localbu.tdE), Integer.valueOf(localbu.tdF) });
        g.oSF.a(111L, 228L, 1L, false);
        parama = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().x(localp.fRV, localp.fTG);
        parama.yA(0);
        localObject1 = ibV.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ae.v(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(564653981696L, 4207);
              this.iaP.A(((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().x(localp.fRV, localp.fTG));
              GMTrace.o(564653981696L, 4207);
            }
          });
        }
        if ((parama == null) || (parama.field_msgId <= 0L)) {
          break label1062;
        }
      }
      label1062:
      for (boolean bool = true;; bool = false)
      {
        parama = new d.b(parama, bool);
        GMTrace.o(572304392192L, 4264);
        return parama;
        v.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d], stack[%s]", new Object[] { Integer.valueOf(i), Long.valueOf(localbu.tdE), Integer.valueOf(localbu.tdF), bf.bJP() });
        parama = null;
        break;
      }
    }
  }
  
  public final void h(au paramau)
  {
    GMTrace.i(572438609920L, 4265);
    v.d("MicroMsg.VoiceMsgExtension", "onPreDelMessage " + paramau.field_imgPath + " " + paramau.field_talker);
    if (!o.fq(paramau.field_talker)) {
      q.mc(paramau.field_imgPath);
    }
    GMTrace.o(572438609920L, 4265);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelvoice/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */