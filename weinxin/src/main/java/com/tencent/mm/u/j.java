package com.tencent.mm.u;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.f;
import com.tencent.mm.e.a.ao;
import com.tencent.mm.e.a.ap;
import com.tencent.mm.e.a.ap.a;
import com.tencent.mm.e.a.jh;
import com.tencent.mm.e.b.af;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.chatroom.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.a;
import com.tencent.mm.protocal.c.alj;
import com.tencent.mm.protocal.c.aly;
import com.tencent.mm.protocal.c.bk;
import com.tencent.mm.protocal.c.jy;
import com.tencent.mm.protocal.c.jz;
import com.tencent.mm.protocal.c.nc;
import com.tencent.mm.protocal.c.nl;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.x;
import com.tencent.mm.x.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class j
{
  public static f<String, String> hkV;
  
  static
  {
    GMTrace.i(17485214515200L, 130275);
    hkV = new f(100);
    GMTrace.o(17485214515200L, 130275);
  }
  
  public static String C(String paramString1, String paramString2)
  {
    GMTrace.i(17484006555648L, 130266);
    paramString1 = paramString2 + "#" + paramString1;
    if (hkV.bu(paramString1))
    {
      paramString1 = (String)hkV.get(paramString1);
      GMTrace.o(17484006555648L, 130266);
      return paramString1;
    }
    GMTrace.o(17484006555648L, 130266);
    return "";
  }
  
  public static String D(String paramString1, String paramString2)
  {
    GMTrace.i(17484543426560L, 130270);
    paramString2 = ((com.tencent.mm.plugin.chatroom.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa().fV(paramString2);
    if (paramString2 == null)
    {
      GMTrace.o(17484543426560L, 130270);
      return null;
    }
    paramString1 = paramString2.eK(paramString1);
    GMTrace.o(17484543426560L, 130270);
    return paramString1;
  }
  
  public static x a(x paramx, alj paramalj)
  {
    GMTrace.i(667598979072L, 4974);
    paramx.setUsername(com.tencent.mm.platformtools.n.a(paramalj.trN));
    paramx.bR(com.tencent.mm.platformtools.n.a(paramalj.trN));
    paramx.bS(com.tencent.mm.platformtools.n.a(paramalj.trN));
    paramx.bT(com.tencent.mm.platformtools.n.a(paramalj.jdField_try));
    paramx.di(paramalj.hAl);
    paramx.bP(com.tencent.mm.platformtools.n.a(paramalj.tOz));
    paramx.bW(com.tencent.mm.platformtools.n.a(paramalj.tOA));
    paramx.bV(com.tencent.mm.platformtools.n.a(paramalj.jdField_try));
    paramx.dl(paramalj.tqV);
    paramx.dn(paramalj.hAp);
    paramx.ck(RegionCodeDecoder.ab(paramalj.hAu, paramalj.hAm, paramalj.hAn));
    paramx.ce(paramalj.hAo);
    GMTrace.o(667598979072L, 4974);
    return paramx;
  }
  
  public static void a(String paramString, q paramq, boolean paramBoolean)
  {
    GMTrace.i(665585713152L, 4959);
    paramq.jU(paramBoolean);
    ((com.tencent.mm.plugin.chatroom.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa().c(paramq, new String[0]);
    paramq = m.xL();
    aly localaly = new aly();
    localaly.trI = paramString;
    localaly.jLx = paramq;
    localaly.tOR = 1;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localaly.oSc = i;
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wQ().b(new e.a(49, localaly));
      GMTrace.o(665585713152L, 4959);
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt)
  {
    GMTrace.i(17484946079744L, 130273);
    aa localaa = ((com.tencent.mm.plugin.chatroom.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa();
    paramString1 = localaa.fV(paramString1);
    if (paramString1 == null)
    {
      GMTrace.o(17484946079744L, 130273);
      return;
    }
    paramString1.field_chatroomVersion = paramInt;
    paramString1.field_chatroomnoticePublishTime = paramLong;
    paramString1.field_chatroomnoticeEditor = paramString3;
    paramString1.field_chatroomnotice = paramString2;
    localaa.a(paramString1);
    GMTrace.o(17484946079744L, 130273);
  }
  
  public static boolean a(q paramq)
  {
    GMTrace.i(666391019520L, 4965);
    if (paramq == null)
    {
      v.e("MicroMsg.ChatroomMembersLogic", "updateChatroomMember error! member is null");
      GMTrace.o(666391019520L, 4965);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.chatroom.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa().a(paramq);
    String str;
    ar localar;
    x localx;
    if (bool)
    {
      str = paramq.field_chatroomname;
      paramq = paramq.field_roomowner;
      v.d("MicroMsg.ChatroomMembersLogic", "update contact chatroom type to %d", new Object[] { Integer.valueOf(1) });
      localar = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR();
      localx = localar.Rb(str);
      if (((int)localx.gTG != 0) && (!bf.mA(paramq)) && (!bf.mA(m.xL())))
      {
        if (!paramq.equals(m.xL())) {
          break label170;
        }
        localx.eA(1);
      }
    }
    for (;;)
    {
      localar.a(str, localx);
      GMTrace.o(666391019520L, 4965);
      return bool;
      label170:
      localx.eA(0);
    }
  }
  
  public static boolean a(String paramString, bk parambk)
  {
    GMTrace.i(666659454976L, 4967);
    if ((!paramString.toLowerCase().endsWith("@chatroom")) || (parambk.krk == 0))
    {
      v.e("MicroMsg.ChatroomMembersLogic", "AddChatroomMember: room:[" + paramString + "] listCnt:" + parambk.krk);
      GMTrace.o(666659454976L, 4967);
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    ar localar = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR();
    int i = 0;
    while (i < parambk.krk)
    {
      Object localObject = com.tencent.mm.platformtools.n.a(((alj)parambk.tde.get(i)).trN);
      if (((alj)parambk.tde.get(i)).tOy == 0)
      {
        if (bf.mA((String)localObject)) {
          v.e("MicroMsg.ChatroomMembersLogic", "this member name is null! chatRoomName : %s", new Object[] { paramString });
        }
      }
      else
      {
        i += 1;
        continue;
      }
      localObject = localar.Rb((String)localObject);
      if ((int)((com.tencent.mm.j.a)localObject).gTG != 0)
      {
        ((x)localObject).tb();
        localar.a(((af)localObject).field_username, (x)localObject);
      }
      for (;;)
      {
        localArrayList.add(((af)localObject).field_username);
        break;
        localObject = a((x)localObject, (alj)parambk.tde.get(i));
        localar.R((x)localObject);
      }
    }
    if (!localArrayList.isEmpty())
    {
      boolean bool = a(paramString, localArrayList, null);
      GMTrace.o(666659454976L, 4967);
      return bool;
    }
    GMTrace.o(666659454976L, 4967);
    return false;
  }
  
  public static boolean a(String paramString, jy paramjy)
  {
    GMTrace.i(17483872337920L, 130265);
    if (paramjy == null)
    {
      v.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] memberData is null!");
      GMTrace.o(17483872337920L, 130265);
      return false;
    }
    if (bf.mA(paramString))
    {
      v.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] username is null!");
      GMTrace.o(17483872337920L, 130265);
      return false;
    }
    if (o.dH(paramString))
    {
      v.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] username is not personal! :%s", new Object[] { paramString });
      GMTrace.o(17483872337920L, 130265);
      return false;
    }
    String str = com.tencent.mm.platformtools.n.a(paramjy.tot);
    if (bf.mA(str))
    {
      v.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] chatroomId is null!");
      GMTrace.o(17483872337920L, 130265);
      return false;
    }
    v.i("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] chatroomId:%s size:%s", new Object[] { str, Integer.valueOf(paramjy.tor.size()) });
    paramString = ((com.tencent.mm.plugin.chatroom.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa().fV(str);
    if ((paramString != null) && (paramjy.tor.size() > 0) && (paramString.DU().contains(((jz)paramjy.tor.get(0)).jLx)))
    {
      str = ((jz)paramjy.tor.get(0)).jLx;
      com.tencent.mm.g.a.a.b localb = paramString.QH(str);
      if (localb != null)
      {
        v.i("MicroMsg.ChatroomMembersLogic", "oldMember contains:%s displayName:%s", new Object[] { str, localb.gMN });
        localb.gMP = ((jz)paramjy.tor.get(0)).toy;
        a(paramString);
      }
      for (;;)
      {
        GMTrace.o(17483872337920L, 130265);
        return true;
        v.e("MicroMsg.ChatroomMembersLogic", "talker:%s oldMemberData is null!", new Object[] { str });
      }
    }
    if ((paramString != null) && (paramjy.tor.size() > 0))
    {
      paramString = new ap();
      paramString.fDO.username = ((jz)paramjy.tor.get(0)).jLx;
      paramString.fDO.fDP = ((jz)paramjy.tor.get(0)).toy;
      hkV.put(str + "#" + paramString.fDO.username, paramString.fDO.fDP);
      com.tencent.mm.sdk.b.a.uql.m(paramString);
      GMTrace.o(17483872337920L, 130265);
      return false;
    }
    if (paramjy.tor.size() <= 0) {
      v.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] memberData.ChatRoomMember.size() <= 0");
    }
    if (paramString != null) {
      v.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] oldMember is null!");
    }
    GMTrace.o(17483872337920L, 130265);
    return false;
  }
  
  public static boolean a(String paramString, nc paramnc)
  {
    GMTrace.i(666525237248L, 4966);
    if ((!paramString.toLowerCase().endsWith("@chatroom")) || (paramnc.krk == 0))
    {
      v.e("MicroMsg.ChatroomMembersLogic", "DelChatroomMember: room:[" + paramString + "] listCnt:" + paramnc.krk);
      GMTrace.o(666525237248L, 4966);
      return false;
    }
    aa localaa = ((com.tencent.mm.plugin.chatroom.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa();
    paramString = localaa.fV(paramString);
    List localList = q.QJ(paramString.field_memberlist);
    v.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember before " + localList.size());
    paramnc = paramnc.tde.iterator();
    while (paramnc.hasNext()) {
      localList.remove(com.tencent.mm.platformtools.n.a(((nl)paramnc.next()).trN));
    }
    v.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember after " + localList.size());
    paramString.bX(localList).field_displayname = s(localList);
    boolean bool = localaa.a(paramString);
    v.d("MicroMsg.ChatroomMembersLogic", "delChatroomMember " + bool);
    GMTrace.o(666525237248L, 4966);
    return bool;
  }
  
  public static boolean a(String paramString1, String paramString2, jy paramjy, String paramString3, com.tencent.mm.g.a.a.a parama, com.tencent.mm.sdk.b.b paramb)
  {
    GMTrace.i(17483738120192L, 130264);
    if (((!paramString1.toLowerCase().endsWith("@chatroom")) && (!paramString1.toLowerCase().endsWith("@groupcard")) && (!paramString1.toLowerCase().endsWith("@talkroom"))) || (paramjy.krk == 0))
    {
      v.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + paramString1 + "] listCnt:" + paramjy.krk);
      GMTrace.o(17483738120192L, 130264);
      return false;
    }
    ar localar = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR();
    q localq = ((com.tencent.mm.plugin.chatroom.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa().fV(paramString1);
    if (localq != null) {
      parama.fPt = localq.bKI();
    }
    ArrayList localArrayList = new ArrayList();
    v.i("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + paramString1 + "] memCnt:" + paramjy.krk);
    long l = System.currentTimeMillis();
    boolean bool1 = false;
    int i = 0;
    Object localObject;
    while (i < paramjy.krk)
    {
      jz localjz = (jz)paramjy.tor.get(i);
      x localx = localar.Rb(localjz.jLx);
      if (localx == null)
      {
        v.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember memberlist username is null");
        i += 1;
      }
      else
      {
        com.tencent.mm.g.a.a.b localb = new com.tencent.mm.g.a.a.b();
        localb.userName = localjz.jLx;
        localb.gMP = localjz.toy;
        if (paramjy.tos == 0)
        {
          localb.gMN = localjz.tou;
          localb.gMO = localjz.tox;
          if (!bf.mA(localjz.tow))
          {
            com.tencent.mm.x.h localh = com.tencent.mm.x.n.Bm().hs(localjz.jLx);
            localObject = localh;
            if (localh == null)
            {
              localObject = new com.tencent.mm.x.h();
              ((com.tencent.mm.x.h)localObject).username = localjz.jLx;
            }
            ((com.tencent.mm.x.h)localObject).hrk = localjz.tov;
            ((com.tencent.mm.x.h)localObject).hrj = localjz.tow;
            ((com.tencent.mm.x.h)localObject).gkg = 3;
            if (bf.mA(localjz.tov)) {
              break label562;
            }
          }
        }
        label562:
        for (boolean bool2 = true;; bool2 = false)
        {
          ((com.tencent.mm.x.h)localObject).aV(bool2);
          com.tencent.mm.x.n.Bm().a((com.tencent.mm.x.h)localObject);
          if (localq != null)
          {
            localObject = localq.QH(localjz.jLx);
            if (localObject != null)
            {
              localb.gMN = ((com.tencent.mm.g.a.a.b)localObject).gMN;
              localb.gMO = ((com.tencent.mm.g.a.a.b)localObject).gMO;
              localb.gMP = ((com.tencent.mm.g.a.a.b)localObject).gMP;
            }
          }
          parama.gMJ.add(localb);
          if ((int)localx.gTG == 0)
          {
            localx.setUsername(localjz.jLx);
            if (localjz.jMD != null) {
              localx.bR(localjz.jMD);
            }
            localx.tb();
            localar.R(localx);
            bool1 = true;
          }
          localArrayList.add(localx.field_username);
          break;
        }
      }
    }
    v.i("MicroMsg.ChatroomMembersLogic", "summertt SyncAddChatroomMember listUsernames size: " + localArrayList.size() + " event: " + paramb + " publish: " + bool1 + " take[" + (System.currentTimeMillis() - l) + "]ms");
    if (bool1)
    {
      com.tencent.mm.sdk.b.a.uql.m(paramb);
      localObject = ((com.tencent.mm.plugin.chatroom.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa().fV(paramString1);
      paramb = (com.tencent.mm.sdk.b.b)localObject;
      if (localObject == null) {
        paramb = new q();
      }
      l = System.currentTimeMillis();
      paramb.field_chatroomname = paramString1;
      paramb.field_roomowner = paramString2;
      paramString2 = paramb.bX(localArrayList);
      paramString2.field_displayname = s(localArrayList);
      if (paramjy.tos == 0) {
        break label902;
      }
    }
    label902:
    for (bool1 = true;; bool1 = false)
    {
      paramString2.a(paramString3, parama, bool1);
      bool1 = a(paramb);
      v.i("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember replaceChatroomMember ret : %s , during : %s", new Object[] { Boolean.valueOf(bool1), Long.valueOf(System.currentTimeMillis() - l) });
      if (paramb.bKJ())
      {
        v.i("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember OldVer:%d", new Object[] { Integer.valueOf(paramb.bKI()) });
        paramString2 = new ao();
        paramString2.fDN.username = paramString1;
        com.tencent.mm.sdk.b.a.uql.m(paramString2);
      }
      GMTrace.o(17483738120192L, 130264);
      return bool1;
      if (localq != null)
      {
        q.bKK();
        break;
      }
      v.i("MicroMsg.ChatroomMembersLogic", "ChatroomId:%s is Need Update All InviteerInfo ", new Object[] { paramString1 });
      ((jh)paramb).fPs.fPt = 0;
      com.tencent.mm.sdk.b.a.uql.m(paramb);
      break;
    }
  }
  
  public static boolean a(String paramString1, ArrayList<String> paramArrayList, String paramString2)
  {
    int i = 0;
    int k = 0;
    GMTrace.i(666793672704L, 4968);
    aa localaa = ((com.tencent.mm.plugin.chatroom.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa();
    q localq = localaa.fW(paramString1);
    if (paramString1.endsWith("@chatroom")) {}
    LinkedList localLinkedList;
    int j;
    for (paramString1 = eA(paramString1);; paramString1 = new LinkedList())
    {
      localLinkedList = new LinkedList();
      if (paramString1 == null) {
        break label214;
      }
      i = 0;
      for (;;)
      {
        j = k;
        if (i >= paramString1.size()) {
          break;
        }
        localLinkedList.add(paramString1.get(i));
        i += 1;
      }
    }
    while (j < paramArrayList.size())
    {
      if (!paramString1.contains(paramArrayList.get(j))) {
        localLinkedList.add(paramArrayList.get(j));
      }
      j += 1;
    }
    if (!bf.mA(paramString2)) {
      localq.field_roomowner = paramString2;
    }
    localq.bX(localLinkedList).field_displayname = s(localLinkedList);
    boolean bool = localaa.a(localq);
    GMTrace.o(666793672704L, 4968);
    return bool;
    label214:
    while (i < paramArrayList.size())
    {
      localLinkedList.add(paramArrayList.get(i));
      i += 1;
    }
    if (!bf.mA(paramString2)) {
      localq.field_roomowner = paramString2;
    }
    localq.bX(localLinkedList).field_displayname = s(localLinkedList);
    localq.field_roomowner = paramString2;
    bool = localaa.a(localq);
    v.d("MicroMsg.ChatroomMembersLogic", "insertMembersByChatRoomName " + bool);
    GMTrace.o(666793672704L, 4968);
    return bool;
  }
  
  public static boolean a(String paramString, Map<String, String> paramMap)
  {
    GMTrace.i(665317277696L, 4957);
    paramString = ((com.tencent.mm.plugin.chatroom.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa().fV(paramString);
    if (paramString == null)
    {
      GMTrace.o(665317277696L, 4957);
      return false;
    }
    Iterator localIterator = paramString.DU().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramMap.put(str, paramString.eK(str));
    }
    GMTrace.o(665317277696L, 4957);
    return true;
  }
  
  public static String b(List<String> paramList, int paramInt)
  {
    GMTrace.i(665854148608L, 4961);
    if ((paramList == null) || (paramList.size() == 0))
    {
      GMTrace.o(665854148608L, 4961);
      return "";
    }
    Object localObject1 = "";
    int i = 0;
    Object localObject2 = localObject1;
    if (i < paramList.size())
    {
      localObject2 = (String)paramList.get(i);
      if (((String)localObject2).length() <= 0) {
        break label220;
      }
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb((String)localObject2);
      localObject2 = (String)localObject1 + ((x)localObject2).tL();
      if ((i == paramInt - 1) && (i < paramList.size())) {
        localObject2 = (String)localObject2 + "...";
      }
    }
    else
    {
      GMTrace.o(665854148608L, 4961);
      return (String)localObject2;
    }
    localObject1 = localObject2;
    if (i < paramList.size() - 1) {
      localObject1 = (String)localObject2 + com.tencent.mm.sdk.platformtools.aa.getContext().getString(c.a.dSU);
    }
    label220:
    for (;;)
    {
      i += 1;
      break;
    }
  }
  
  public static List<String> eA(String paramString)
  {
    GMTrace.i(667062108160L, 4970);
    if (paramString == null)
    {
      v.e("MicroMsg.ChatroomMembersLogic", "chatroomName is null");
      GMTrace.o(667062108160L, 4970);
      return null;
    }
    if (!paramString.toLowerCase().endsWith("@chatroom"))
    {
      v.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: this is not room:[" + paramString + "]");
      GMTrace.o(667062108160L, 4970);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.chatroom.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa().fZ(paramString);
    GMTrace.o(667062108160L, 4970);
    return paramString;
  }
  
  public static List<String> eB(String paramString)
  {
    GMTrace.i(667196325888L, 4971);
    if (!paramString.toLowerCase().endsWith("@chatroom"))
    {
      v.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: room:[" + paramString + "]");
      GMTrace.o(667196325888L, 4971);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.chatroom.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa().fZ(paramString);
    GMTrace.o(667196325888L, 4971);
    return paramString;
  }
  
  public static int eC(String paramString)
  {
    GMTrace.i(667330543616L, 4972);
    List localList = eA(paramString);
    if (localList == null)
    {
      v.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: get room:[" + paramString + "] members count fail");
      GMTrace.o(667330543616L, 4972);
      return 0;
    }
    int i = localList.size();
    GMTrace.o(667330543616L, 4972);
    return i;
  }
  
  public static List<String> eD(String paramString)
  {
    int i = 0;
    GMTrace.i(667464761344L, 4973);
    if (!paramString.toLowerCase().endsWith("@chatroom"))
    {
      v.e("MicroMsg.ChatroomMembersLogic", "getOtherMembersByChatRoomName: room:[" + paramString + "]");
      GMTrace.o(667464761344L, 4973);
      return null;
    }
    paramString = eA(paramString);
    if ((paramString == null) || (paramString.size() <= 0))
    {
      GMTrace.o(667464761344L, 4973);
      return null;
    }
    String str = (String)com.tencent.mm.kernel.h.vI().vr().get(2, null);
    boolean bool;
    if ((str != null) && (str.length() > 0))
    {
      bool = true;
      Assert.assertTrue(bool);
    }
    for (;;)
    {
      if (i < paramString.size())
      {
        if (((String)paramString.get(i)).equals(str)) {
          paramString.remove(i);
        }
      }
      else
      {
        if (paramString.size() > 0) {
          break label191;
        }
        GMTrace.o(667464761344L, 4973);
        return null;
        bool = false;
        break;
      }
      i += 1;
    }
    label191:
    GMTrace.o(667464761344L, 4973);
    return paramString;
  }
  
  public static String eE(String paramString)
  {
    GMTrace.i(667733196800L, 4975);
    paramString = ((com.tencent.mm.plugin.chatroom.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa().fV(paramString);
    if (paramString == null)
    {
      GMTrace.o(667733196800L, 4975);
      return null;
    }
    paramString = paramString.field_chatroomnotice;
    GMTrace.o(667733196800L, 4975);
    return paramString;
  }
  
  public static String eF(String paramString)
  {
    GMTrace.i(17484677644288L, 130271);
    paramString = ((com.tencent.mm.plugin.chatroom.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa().fV(paramString);
    if (paramString == null)
    {
      GMTrace.o(17484677644288L, 130271);
      return null;
    }
    paramString = paramString.field_chatroomnoticeEditor;
    GMTrace.o(17484677644288L, 130271);
    return paramString;
  }
  
  public static long eG(String paramString)
  {
    GMTrace.i(17484811862016L, 130272);
    paramString = ((com.tencent.mm.plugin.chatroom.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa().fV(paramString);
    if (paramString == null)
    {
      GMTrace.o(17484811862016L, 130272);
      return -1L;
    }
    long l = paramString.field_chatroomnoticePublishTime;
    GMTrace.o(17484811862016L, 130272);
    return l;
  }
  
  public static boolean es(String paramString)
  {
    GMTrace.i(17483603902464L, 130263);
    paramString = ((com.tencent.mm.plugin.chatroom.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa().fV(paramString);
    if (paramString == null)
    {
      GMTrace.o(17483603902464L, 130263);
      return false;
    }
    boolean bool = paramString.bKN();
    GMTrace.o(17483603902464L, 130263);
    return bool;
  }
  
  public static boolean et(String paramString)
  {
    GMTrace.i(665451495424L, 4958);
    paramString = ((com.tencent.mm.plugin.chatroom.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa().fX(paramString);
    String str = m.xL();
    if ((!bf.mA(paramString)) && (!bf.mA(str)) && (paramString.equals(str)))
    {
      GMTrace.o(665451495424L, 4958);
      return true;
    }
    GMTrace.o(665451495424L, 4958);
    return false;
  }
  
  public static boolean eu(String paramString)
  {
    GMTrace.i(665988366336L, 4962);
    String str = (String)com.tencent.mm.kernel.h.vI().vr().get(2, null);
    paramString = eA(paramString);
    if (paramString == null)
    {
      v.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is null ");
      GMTrace.o(665988366336L, 4962);
      return false;
    }
    if ((paramString.size() == 0) || (!paramString.contains(str)))
    {
      v.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is list is zero or no contains user  " + paramString.size() + " ");
      GMTrace.o(665988366336L, 4962);
      return false;
    }
    GMTrace.o(665988366336L, 4962);
    return true;
  }
  
  public static boolean ev(String paramString)
  {
    GMTrace.i(666122584064L, 4963);
    if ((paramString == null) || (!paramString.toLowerCase().endsWith("@chatroom")))
    {
      GMTrace.o(666122584064L, 4963);
      return false;
    }
    if (!((com.tencent.mm.plugin.chatroom.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa().ga(paramString))
    {
      v.d("MicroMsg.ChatroomMembersLogic", "state is die");
      GMTrace.o(666122584064L, 4963);
      return true;
    }
    paramString = ((com.tencent.mm.plugin.chatroom.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa().fZ(paramString);
    if ((paramString == null) || (paramString.size() == 0))
    {
      GMTrace.o(666122584064L, 4963);
      return true;
    }
    GMTrace.o(666122584064L, 4963);
    return false;
  }
  
  public static boolean ew(String paramString)
  {
    GMTrace.i(666256801792L, 4964);
    if ((paramString == null) || (!paramString.toLowerCase().endsWith("@chatroom")))
    {
      GMTrace.o(666256801792L, 4964);
      return false;
    }
    v.d("MicroMsg.ChatroomMembersLogic", "updateFailState chatRoomName %s", new Object[] { paramString });
    aa localaa = ((com.tencent.mm.plugin.chatroom.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa();
    paramString = localaa.fV(paramString);
    if (paramString == null)
    {
      GMTrace.o(666256801792L, 4964);
      return false;
    }
    paramString.field_roomflag = 1;
    boolean bool = localaa.a(paramString);
    GMTrace.o(666256801792L, 4964);
    return bool;
  }
  
  public static boolean ex(String paramString)
  {
    GMTrace.i(17484140773376L, 130267);
    if (!paramString.toLowerCase().endsWith("@groupcard"))
    {
      v.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard: room:[" + paramString + "]");
      GMTrace.o(17484140773376L, 130267);
      return false;
    }
    ar localar = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR();
    if (localar.Rd(paramString)) {
      localar.Rh(paramString);
    }
    for (;;)
    {
      boolean bool = ez(paramString);
      GMTrace.o(17484140773376L, 130267);
      return bool;
      v.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard RoomName not exist:[" + paramString + "]");
    }
  }
  
  public static boolean ey(String paramString)
  {
    GMTrace.i(17484274991104L, 130268);
    if (!paramString.toLowerCase().endsWith("@chatroom"))
    {
      v.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom: room:[" + paramString + "]");
      GMTrace.o(17484274991104L, 130268);
      return false;
    }
    ar localar = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR();
    if (localar.Rd(paramString)) {
      localar.Rh(paramString);
    }
    for (;;)
    {
      boolean bool = ez(paramString);
      GMTrace.o(17484274991104L, 130268);
      return bool;
      v.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom RoomName not exist:[" + paramString + "]");
    }
  }
  
  private static boolean ez(String paramString)
  {
    GMTrace.i(666927890432L, 4969);
    boolean bool = ((com.tencent.mm.plugin.chatroom.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa().gb(paramString);
    GMTrace.o(666927890432L, 4969);
    return bool;
  }
  
  public static boolean q(String paramString, int paramInt)
  {
    GMTrace.i(667867414528L, 4976);
    paramString = ((com.tencent.mm.plugin.chatroom.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa().fV(paramString);
    if (paramString == null)
    {
      GMTrace.o(667867414528L, 4976);
      return false;
    }
    if (paramString.field_chatroomVersion < paramInt)
    {
      GMTrace.o(667867414528L, 4976);
      return true;
    }
    GMTrace.o(667867414528L, 4976);
    return false;
  }
  
  public static void r(String paramString, int paramInt)
  {
    GMTrace.i(17485080297472L, 130274);
    aa localaa = ((com.tencent.mm.plugin.chatroom.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa();
    q localq = localaa.fV(paramString);
    if (localq == null)
    {
      GMTrace.o(17485080297472L, 130274);
      return;
    }
    com.tencent.mm.g.a.a.a locala = localq.bKO();
    locala.type = paramInt;
    localq.a(paramString, locala, false);
    localaa.a(localq);
    GMTrace.o(17485080297472L, 130274);
  }
  
  public static String s(List<String> paramList)
  {
    GMTrace.i(665719930880L, 4960);
    paramList = b(paramList, -1);
    GMTrace.o(665719930880L, 4960);
    return paramList;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */