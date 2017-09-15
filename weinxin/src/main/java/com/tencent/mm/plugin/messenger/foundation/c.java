package com.tencent.mm.plugin.messenger.foundation;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ai.b;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.protocal.c.lt;
import com.tencent.mm.protocal.c.ng;
import com.tencent.mm.protocal.c.nm;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.d.b;
import com.tencent.mm.y.d.c;
import java.util.List;

public final class c
  implements p
{
  public c()
  {
    GMTrace.i(13236954988544L, 98623);
    GMTrace.o(13236954988544L, 98623);
  }
  
  public static void a(d.a parama, com.tencent.mm.plugin.messenger.foundation.a.r paramr)
  {
    GMTrace.i(13237223424000L, 98625);
    bu localbu = parama.hsc;
    if ((10008 == com.tencent.mm.platformtools.r.iiC) && (com.tencent.mm.platformtools.r.iiD != 0))
    {
      v.i("MicroMsg.MessageSyncExtension", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(localbu.tdE), Integer.valueOf(com.tencent.mm.platformtools.r.iiD) });
      localbu.tdE = Long.valueOf(com.tencent.mm.platformtools.r.iiD).longValue();
      com.tencent.mm.platformtools.r.iiD = 0;
    }
    if (((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cC(localbu.tdE))
    {
      v.i("MicroMsg.MessageSyncExtension", "ignore, because reSync the deleted msg perhaps the IDC has change has swtiched");
      GMTrace.o(13237223424000L, 98625);
      return;
    }
    String str1 = n.a(localbu.tdx);
    Object localObject2 = n.a(localbu.tdy);
    if ((str1.equals(m.xL())) && (((String)localObject2).equals("newsapp")) && (localbu.mrC != 51))
    {
      v.w("MicroMsg.MessageSyncExtension", "msgid:%d type:%d this fucking msg from mac weixin ,someone send msg to newsapp at mac weixin ,givp up.", new Object[] { Long.valueOf(localbu.tdE), Integer.valueOf(localbu.mrC) });
      GMTrace.o(13237223424000L, 98625);
      return;
    }
    long l1 = localbu.tdE;
    int i = localbu.tdw;
    int j = localbu.jLP;
    int k = localbu.mrC;
    int m = localbu.ofk;
    String str2 = bf.ev(localbu.ofk);
    long l2 = bf.Nz();
    long l3 = localbu.ofk;
    int n = localbu.tdA;
    int i1 = n.a(localbu.tdB, new byte[0]).length;
    int i2 = bf.mz(localbu.tdC).length();
    int i3 = bf.mz(localbu.tdD).length();
    avu localavu = localbu.tdz;
    Object localObject1 = "";
    if (localavu == null)
    {
      v.i("MicroMsg.MessageSyncExtension", "dkAddMsg from:%s to:%s id:[%d,%d] status:%d type:%d time:[%d %s] diff:%d imgstatus:%d imgbuf:%d src:%d push:%d content:%s", new Object[] { str1, localObject2, Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), str2, Long.valueOf(l2 - l3), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), bf.Qi((String)localObject1) });
      v.i("MicroMsg.MessageSyncExtension", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", new Object[] { localbu.tdC, "" });
      s.d(localbu);
      if (str1.equals("readerapp"))
      {
        localbu.tdx = n.mw("newsapp");
        localbu.mrC = 12399999;
      }
      if (((str1.equals("blogapp")) || (str1.equals("newsapp"))) && (localbu.mrC != 10002)) {
        localbu.mrC = 12399999;
      }
      if (localbu.mrC == 52) {
        localbu.mrC = 1000052;
      }
      if (localbu.mrC == 53) {
        localbu.mrC = 1000053;
      }
      if ((parama != null) && (parama.hsc != null)) {
        break label932;
      }
      label597:
      i = 0;
      localObject2 = d.c.aB(Integer.valueOf(localbu.mrC));
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = d.c.aB(str1);
      }
      if (localObject1 != null)
      {
        localObject2 = ((d)localObject1).b(parama);
        if (localObject2 != null) {
          break label1149;
        }
        localObject1 = null;
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        v.w("MicroMsg.MessageSyncExtension", "summerbadcr extension declared but skipped msg, type=%d, svrId=%d, MsgSeq=%d, createTime=%d, addMsgInfo=%s", new Object[] { Integer.valueOf(localbu.mrC), Long.valueOf(localbu.tdE), Integer.valueOf(localbu.tdF), Integer.valueOf(localbu.ofk), parama });
        if ((parama.hsd) && (parama.hse))
        {
          parama = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().I(str1, localbu.tdF);
          if ((parama != null) && (parama.field_msgId != 0L))
          {
            i = parama.field_flag;
            v.i("MicroMsg.MessageSyncExtension", "summerbadcr extension declared but skipped msg and must revised fault id[%d], flag[%d], svrId[%d], msgseq[%d], createtime[%d], type[%d]", new Object[] { Long.valueOf(parama.field_msgId), Integer.valueOf(parama.field_flag), Long.valueOf(parama.field_msgSvrId), Long.valueOf(parama.field_msgSeq), Long.valueOf(parama.field_createTime), Integer.valueOf(parama.field_type) });
            parama.dF(i | 0x2 | 0x1);
            ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().a(parama.field_msgId, parama);
          }
        }
        else
        {
          i = 1;
          s.a(5, localbu);
          if (i == 0) {
            v.f("MicroMsg.MessageSyncExtension", "unknown add msg request, type=%d. drop now !!!", new Object[] { Integer.valueOf(localbu.mrC) });
          }
          GMTrace.o(13237223424000L, 98625);
          return;
          localObject1 = localavu.tXF;
          break;
          label932:
          localObject1 = parama.hsc;
          localObject2 = n.a(((bu)localObject1).tdx);
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().x((String)localObject2, ((bu)localObject1).tdE);
          if ((((ce)localObject2).field_msgId == 0L) || ((((ce)localObject2).field_isSend != 0) && (((bu)localObject1).tdF == 0))) {
            break label597;
          }
          i = ((ce)localObject2).field_flag;
          if (parama.hsd)
          {
            i |= 0x2;
            label1018:
            if (!parama.hse) {
              break label1133;
            }
            i |= 0x1;
            label1029:
            if (!parama.hsf) {
              break label1141;
            }
            i |= 0x4;
          }
          for (;;)
          {
            if (i == ((ce)localObject2).field_flag) {
              break label1147;
            }
            v.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr updateMsgFlagByAddMsgInfo msgType[%d], flag new[%d], old[%d]", new Object[] { Integer.valueOf(((bu)localObject1).mrC), Integer.valueOf(i), Integer.valueOf(((ce)localObject2).field_flag) });
            ((au)localObject2).dF(i);
            ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().b(((ce)localObject2).field_msgSvrId, (au)localObject2);
            break;
            i &= 0xFFFFFFFD;
            break label1018;
            label1133:
            i &= 0xFFFFFFFE;
            break label1029;
            label1141:
            i &= 0xFFFFFFFB;
          }
          label1147:
          break label597;
          label1149:
          localObject1 = ((d.b)localObject2).fCQ;
          continue;
        }
        if (parama != null) {}
        for (l1 = parama.field_msgId;; l1 = -1L)
        {
          v.i("MicroMsg.MessageSyncExtension", "summerbadcr extension declared but skipped msg and must revised fault id failed[%d]", new Object[] { Long.valueOf(l1) });
          break;
        }
      }
    }
    if ((o.eZ(str1)) && (!b.Hq())) {}
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        v.d("MicroMsg.MessageSyncExtension", " msg , id =" + ((ce)localObject1).field_msgId + "  " + paramr);
        if ((((ce)localObject1).field_msgId > 0L) && (paramr != null) && (((d.b)localObject2).hsg)) {
          paramr.a((au)localObject1, localbu);
        }
      }
      i = 1;
      break;
    }
  }
  
  public final void a(lt paramlt, byte[] paramArrayOfByte, boolean paramBoolean, com.tencent.mm.plugin.messenger.foundation.a.r paramr)
  {
    GMTrace.i(13237089206272L, 98624);
    switch (paramlt.tqs)
    {
    }
    for (;;)
    {
      GMTrace.o(13237089206272L, 98624);
      return;
      paramlt = (bu)new bu().aD(paramArrayOfByte);
      if (paramlt != null) {
        a(new d.a(paramlt, false, false, false), paramr);
      }
      GMTrace.o(13237089206272L, 98624);
      return;
      paramArrayOfByte = (ng)new ng().aD(paramArrayOfByte);
      paramlt = n.a(paramArrayOfByte.trH);
      int i = paramArrayOfByte.trL;
      paramArrayOfByte = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().bi(paramlt, i);
      if (paramArrayOfByte.moveToFirst()) {
        while (!paramArrayOfByte.isAfterLast())
        {
          paramr = new au();
          paramr.b(paramArrayOfByte);
          ay.j(paramr);
          paramArrayOfByte.moveToNext();
        }
      }
      paramArrayOfByte.close();
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().bh(paramlt, i);
      GMTrace.o(13237089206272L, 98624);
      return;
      paramlt = (nm)new nm().aD(paramArrayOfByte);
      paramArrayOfByte = paramlt.trO;
      i = 0;
      while (i < paramArrayOfByte.size())
      {
        ay.j(n.a(paramlt.trH), ((Integer)paramArrayOfByte.get(i)).intValue());
        i += 1;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/messenger/foundation/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */