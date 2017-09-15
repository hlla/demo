package com.tencent.mm.storage;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelbiz.a.b;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.a.k;
import com.tencent.mm.modelbiz.n;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.plugin.biz.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ba;
import java.util.ArrayList;
import java.util.Iterator;

public final class p
  implements com.tencent.mm.plugin.messenger.foundation.a.d, com.tencent.mm.plugin.messenger.foundation.a.e
{
  private as uxi;
  
  public p(as paramas)
  {
    GMTrace.i(1566186668032L, 11669);
    w.DT();
    this.uxi = paramas;
    this.uxi.a(this);
    this.uxi.a(this);
    GMTrace.o(1566186668032L, 11669);
  }
  
  private void a(String paramString, ae paramae, int paramInt1, int paramInt2, c.c paramc)
  {
    GMTrace.i(1566723538944L, 11673);
    au localau;
    com.tencent.mm.modelbiz.a.a locala;
    com.tencent.mm.modelbiz.a.c localc;
    Object localObject1;
    Object localObject2;
    label393:
    Object localObject3;
    if ((paramae != null) && (paramc != null) && (paramc.jZq != -1L) && (paramae.eC(8388608)))
    {
      localau = ((n)com.tencent.mm.kernel.h.h(n.class)).wU().ac(paramString, paramc.jZq);
      locala = w.DK().U(paramc.jZq);
      localc = w.DJ().aa(paramc.jZq);
      if (localc.field_bizChatServId == null)
      {
        v.w("MicroMsg.BizConversationStorage", "willen updateBizChatConversation bizChatInfo == null");
        GMTrace.o(1566723538944L, 11673);
        return;
      }
      if ((localau == null) || (localau.field_msgId == 0L))
      {
        v.i("MicroMsg.BizConversationStorage", "update null BizChatConversation with talker " + paramString);
        locala.field_status = 0;
        locala.field_isSend = 0;
        locala.field_content = "";
        locala.field_msgType = "0";
        locala.field_unReadCount = 0;
        locala.field_digest = "";
        locala.field_digestUser = "";
        w.DK();
        b.a(locala, paramInt2, paramInt1);
        w.DK().b(locala);
        GMTrace.o(1566723538944L, 11673);
        return;
      }
      boolean bool = localc.DV();
      locala.field_brandUserName = paramString;
      if (localau.bLW())
      {
        locala.field_content = localau.bMs();
        localObject1 = new PString();
        this.uxi.oG().a(localau, (PString)localObject1, new PString(), new PInt(), false);
        localObject1 = ((PString)localObject1).value;
        localObject2 = w.DL().iE(localau.field_bizChatUserId);
        if (!bool) {
          break label938;
        }
        if ((localau.field_isSend != 1) || (localObject2 == null)) {
          break label866;
        }
        locala.field_digest = (aa.getContext().getString(b.b.dHu) + ":" + (String)localObject1);
        ((j)localObject2).field_userName = aa.getContext().getString(b.b.dHu);
        localObject1 = null;
        localObject2 = this.uxi.az(localau.field_type, localau.field_content);
        localObject3 = bf.mz(locala.field_digest);
        if (!bf.mA((String)localObject2)) {
          break label951;
        }
        localObject2 = "";
        label436:
        locala.field_digest = ((String)localObject3).concat((String)localObject2);
        locala.field_digestUser = "";
        locala.field_chatType = localc.field_chatType;
        locala.field_lastMsgID = localau.field_msgId;
        if (!localau.bMc()) {
          break label977;
        }
      }
    }
    label490:
    label686:
    label771:
    label866:
    label938:
    label951:
    label977:
    label994:
    label1116:
    label1119:
    for (;;)
    {
      long l = localau.field_createTime;
      locala.field_lastMsgTime = l;
      locala.field_status = localau.field_status;
      locala.field_isSend = localau.field_isSend;
      locala.field_msgType = Integer.toString(localau.field_type);
      locala.field_flag = b.a(locala, 1, localau.field_createTime);
      int j = 0;
      int i;
      if ((!paramc.nxn.equals("insert")) || (paramc.nxp <= 0))
      {
        i = j;
        if (paramc.nxn.equals("update"))
        {
          i = j;
          if (locala.field_unReadCount + paramc.nxp < 0) {}
        }
      }
      else
      {
        locala.field_unReadCount += paramc.nxp;
        locala.field_newUnReadCount += paramc.nxp;
        i = j;
        if (paramc.nxp > 0)
        {
          i = j;
          if (localc.fu(1))
          {
            i = paramae.field_unReadCount - paramc.nxp;
            if (i > 0) {
              break label994;
            }
            paramae.dt(0);
            paramae.dA(paramae.field_unReadMuteCount + paramc.nxp);
            i = 1;
          }
        }
      }
      j = i;
      if (paramc.nxn.equals("insert"))
      {
        j = i;
        if (paramc.nxo.size() > 0)
        {
          j = i;
          if (localc.DV())
          {
            localObject2 = w.DL().iG(localau.field_talker);
            paramc = paramc.nxo.iterator();
            if (paramc.hasNext())
            {
              localObject3 = (au)paramc.next();
              if ((localObject2 == null) || (((ce)localObject3).field_isSend == 1) || (!((au)localObject3).bMa()) || (!((au)localObject3).RD((String)localObject2))) {
                break label1116;
              }
              locala.field_atCount += 1;
              paramae.dz(paramae.field_atCount + 1);
              i = 1;
            }
          }
        }
      }
      for (;;)
      {
        break label771;
        locala.field_content = localau.field_content;
        break;
        if ((localObject2 != null) && (!bf.mA(((j)localObject2).field_userName)))
        {
          locala.field_digest = (((j)localObject2).field_userName + ":" + (String)localObject1);
          localObject1 = ((j)localObject2).field_userName;
          break label393;
        }
        locala.field_digest = ((String)localObject1);
        localObject1 = null;
        break label393;
        locala.field_digest = ((String)localObject1);
        localObject1 = null;
        break label393;
        localObject2 = " " + bf.mz((String)localObject2);
        break label436;
        if (localau.field_status != 1) {
          break label1119;
        }
        l = Long.MAX_VALUE;
        break label490;
        paramae.dt(i);
        break label686;
        j = i;
        w.DK();
        b.a(locala, paramInt2, paramInt1);
        paramc = (c.c)localObject1;
        if (bf.mA((String)localObject1)) {
          paramc = localc.eK(localau.field_bizChatUserId);
        }
        v.i("MicroMsg.BizConversationStorage", "updateBizChatConversation brandUserName:%s, bizChatId:%s, userId:%s, displayName:%s", new Object[] { paramString, localc.field_bizChatServId, localau.field_bizChatUserId, paramc });
        w.DK().b(locala);
        if (j != 0) {
          this.uxi.a(paramae, paramString);
        }
        GMTrace.o(1566723538944L, 11673);
        return;
      }
    }
  }
  
  public final void QG(String paramString)
  {
    GMTrace.i(1566857756672L, 11674);
    if ((paramString == null) || (!com.tencent.mm.u.o.eV(paramString)) || (!com.tencent.mm.modelbiz.e.ib(paramString)))
    {
      GMTrace.o(1566857756672L, 11674);
      return;
    }
    ae localae = this.uxi.Rl(paramString);
    if (localae == null)
    {
      GMTrace.o(1566857756672L, 11674);
      return;
    }
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rw(paramString);
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Ag((String)localObject);
    if ((localObject != null) && (((ce)localObject).field_msgId > 0L))
    {
      localae.W((au)localObject);
      localae.setContent(((ce)localObject).field_talker + ":" + ((ce)localObject).field_content);
      localae.ct(Integer.toString(((ce)localObject).field_type));
      as.b localb = this.uxi.oG();
      if (localb == null) {
        break label289;
      }
      PString localPString1 = new PString();
      PString localPString2 = new PString();
      PInt localPInt = new PInt();
      ((au)localObject).cH(paramString);
      ((au)localObject).setContent(localae.field_content);
      localb.a((au)localObject, localPString1, localPString2, localPInt, true);
      localae.cu(localPString1.value);
      localae.cv(localPString2.value);
      localae.dx(localPInt.value);
    }
    for (;;)
    {
      this.uxi.a(localae, localae.field_username);
      GMTrace.o(1566857756672L, 11674);
      return;
      label289:
      localae.bLr();
    }
  }
  
  public final void a(au paramau, ae paramae)
  {
    Object localObject = null;
    GMTrace.i(1566320885760L, 11670);
    if ((paramae != null) && (paramau != null) && (paramau.field_bizChatId != -1L) && (paramae.eC(8388608)))
    {
      com.tencent.mm.modelbiz.a.c localc = w.DJ().aa(paramau.field_bizChatId);
      String str2 = paramae.field_digest;
      if (!bf.mA(paramau.field_bizChatUserId))
      {
        j localj = w.DL().iE(paramau.field_bizChatUserId);
        String str1;
        boolean bool;
        if (localj != null)
        {
          str1 = localj.field_userName;
          bool = paramau.field_bizChatUserId.equals(w.DL().iG(paramau.field_talker));
          if ((localj == null) || (!bool)) {
            break label225;
          }
          paramae.cu(aa.getContext().getString(b.b.dHu) + ":" + str2);
        }
        for (;;)
        {
          if (!localc.DV())
          {
            if ((!bool) && (str1 != null) && (str1.length() > 0) && (!str1.equals(localc.field_chatName)))
            {
              localc.field_chatName = str1;
              w.DJ().b(localc);
              GMTrace.o(1566320885760L, 11670);
              return;
              str1 = null;
              break;
              label225:
              if ((localj == null) || (bf.mA(localj.field_userName))) {
                continue;
              }
              paramae.cu(localj.field_userName + ":" + str2);
              continue;
            }
            paramae = w.DL().iE(localc.field_bizChatServId);
            paramau = (au)localObject;
            if (paramae != null) {
              paramau = paramae.field_userName;
            }
            if ((paramau != null) && (paramau.length() > 0) && (!paramau.equals(localc.field_chatName)))
            {
              localc.field_chatName = paramau;
              w.DJ().b(localc);
            }
          }
        }
        GMTrace.o(1566320885760L, 11670);
        return;
      }
      v.w("MicroMsg.BizConversationStorage", "BizChatUserId is null:%s %s", new Object[] { localc.field_bizChatServId, localc.field_chatName });
    }
    GMTrace.o(1566320885760L, 11670);
  }
  
  public final void a(au paramau, ae paramae, boolean paramBoolean, c.c paramc)
  {
    GMTrace.i(1566455103488L, 11671);
    if (paramc == null)
    {
      v.e("MicroMsg.BizConversationStorage", "compose notifyInfo is null");
      GMTrace.o(1566455103488L, 11671);
      return;
    }
    String str = paramc.fJC;
    if (paramBoolean)
    {
      if ((paramau != null) && (paramau.field_isSend != 1) && ((ba.k(paramau) & 0x1) != 0))
      {
        v.i("MicroMsg.BizConversationStorage", "create a temp session conversation.");
        paramae.eB(4194304);
      }
      if ((paramau != null) && (com.tencent.mm.modelbiz.e.dr(str)))
      {
        v.i("MicroMsg.BizConversationStorage", "create a bitChat conversation.");
        paramae.eB(8388608);
      }
    }
    for (;;)
    {
      if ((paramc != null) && (!paramc.nxo.isEmpty()) && (paramc.nxo.get(0) != null))
      {
        paramae.dw(((au)paramc.nxo.get(0)).field_isSend);
        if (paramc.nxn.equals("insert")) {
          paramae.uHf = ((au)paramc.nxo.get(paramc.nxo.size() - 1));
        }
      }
      GMTrace.o(1566455103488L, 11671);
      return;
      x localx = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(str);
      if ((localx != null) && (localx.bKU()) && (!com.tencent.mm.j.a.ez(localx.field_type)) && (paramau != null) && (paramau.field_isSend != 1) && (!paramae.eC(4194304)) && ((paramae.field_conversationTime < w.DT()) || ((ba.k(paramau) & 0x1) != 0)))
      {
        paramae.eB(4194304);
        v.i("MicroMsg.BizConversationStorage", "onNotifyChange is old temp session, %s", new Object[] { str });
      }
      if ((paramau != null) && (com.tencent.mm.modelbiz.e.dr(str)))
      {
        v.i("MicroMsg.BizConversationStorage", "onNotifyChange a bitChat conversation, %s", new Object[] { str });
        paramae.eB(8388608);
      }
    }
  }
  
  public final void b(au paramau, ae paramae, boolean paramBoolean, c.c paramc)
  {
    GMTrace.i(1566589321216L, 11672);
    as localas = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW();
    String str1 = paramc.fJC;
    if ((paramc != null) && (paramc.nxn.equals("delete")) && (paramc.nxr > 0)) {}
    for (int i = paramc.nxr;; i = 0)
    {
      if ((paramc != null) && (paramc.nxn.equals("insert")) && (paramc.nxq > 0)) {}
      for (int j = paramc.nxq;; j = 0)
      {
        ae localae;
        String str2;
        if (!bf.mA(paramae.field_parentRef))
        {
          localae = localas.Rl(paramae.field_parentRef);
          if ((localae == null) || (!localae.eC(2097152))) {
            break label652;
          }
          if (j > 0)
          {
            if (((paramc.nxn.equals("insert")) && (paramc.nxp > 0)) || ((paramc.nxn.equals("update")) && (localae.field_unReadCount + paramc.nxp >= 0)))
            {
              paramau = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(str1);
              if ((paramau == null) || (!paramau.tD())) {
                break label603;
              }
              localae.dA(localae.field_unReadMuteCount + j);
            }
            localas.a(paramae, i, j);
          }
          paramau = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rw(paramae.field_parentRef);
          Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Ag(paramau);
          if ((localObject == null) || (((ce)localObject).field_msgId <= 0L)) {
            break label644;
          }
          localae.W((au)localObject);
          localae.setContent(((ce)localObject).field_talker + ":" + ((ce)localObject).field_content);
          localae.ct(Integer.toString(((ce)localObject).field_type));
          if (localas.oG() != null)
          {
            paramau = new PString();
            PString localPString = new PString();
            PInt localPInt = new PInt();
            ((au)localObject).cH(paramae.field_parentRef);
            ((au)localObject).setContent(localae.field_content);
            localas.oG().a((au)localObject, paramau, localPString, localPInt, true);
            str2 = localas.az(((ce)localObject).field_type, ((ce)localObject).field_content);
            localObject = bf.mz(paramau.value);
            if (!bf.mA(str2)) {
              break label619;
            }
            paramau = "";
            label483:
            localae.cu(((String)localObject).concat(paramau));
            localae.cv(localPString.value);
            localae.dx(localPInt.value);
          }
          label514:
          if (localas.a(localae, paramae.field_parentRef) > 0)
          {
            v.d("MicroMsg.BizConversationStorage", "hakon update parent conversation's unread %s, %d", new Object[] { paramae.field_parentRef, Integer.valueOf(localae.field_unReadCount + j) });
            localas.b(3, (m)localas, paramae.field_parentRef);
          }
        }
        for (;;)
        {
          a(str1, paramae, j, i, paramc);
          GMTrace.o(1566589321216L, 11672);
          return;
          label603:
          localae.dt(localae.field_unReadCount + j);
          break;
          label619:
          paramau = " " + bf.mz(str2);
          break label483;
          label644:
          localae.bLr();
          break label514;
          label652:
          if ((localae != null) && ("officialaccounts".equals(localae.field_username)))
          {
            if ((j > 0) && (((paramc.nxn.equals("insert")) && (paramc.nxp > 0)) || ((paramc.nxn.equals("update")) && (localae.field_unReadCount + paramc.nxp >= 0))))
            {
              localae.dt(localae.field_unReadCount + j);
              localas.a(localae, paramae.field_parentRef);
            }
          }
          else if ((localae != null) && ("appbrandcustomerservicemsg".equals(localae.field_username)) && (j > 0))
          {
            if (((paramc.nxn.equals("insert")) && (paramc.nxp > 0)) || ((paramc.nxn.equals("update")) && (localae.field_unReadCount + paramc.nxp >= 0))) {
              localae.dt(localae.field_unReadCount + j);
            }
            localas.a(paramae, i, j);
            localas.a(localae, paramae.field_parentRef);
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */