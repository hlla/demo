package com.tencent.mm.modelbiz.a;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.c.afx;
import com.tencent.mm.protocal.c.asy;
import com.tencent.mm.protocal.c.bgc;
import com.tencent.mm.protocal.c.bgd;
import com.tencent.mm.protocal.c.bge;
import com.tencent.mm.protocal.c.bgf;
import com.tencent.mm.protocal.c.gq;
import com.tencent.mm.protocal.c.gr;
import com.tencent.mm.protocal.c.gs;
import com.tencent.mm.protocal.c.gt;
import com.tencent.mm.protocal.c.gx;
import com.tencent.mm.protocal.c.hp;
import com.tencent.mm.protocal.c.mn;
import com.tencent.mm.protocal.c.mr;
import com.tencent.mm.protocal.c.ms;
import com.tencent.mm.protocal.c.sr;
import com.tencent.mm.protocal.c.vc;
import com.tencent.mm.protocal.c.vd;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vf;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.protocal.c.vi;
import com.tencent.mm.protocal.c.yc;
import com.tencent.mm.protocal.c.yd;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class h
  implements com.tencent.mm.y.e
{
  private HashSet<a> hwN;
  private HashSet<a> hwO;
  private final Object hwP;
  private com.tencent.mm.a.f<String, Long> hwQ;
  private HashSet<a> hwR;
  private HashSet<a> hwS;
  private final Object hwT;
  private com.tencent.mm.a.f<String, Long> hwU;
  
  public h()
  {
    GMTrace.i(4559913091072L, 33974);
    this.hwN = new HashSet();
    this.hwO = new HashSet();
    this.hwP = new Object();
    this.hwQ = new com.tencent.mm.a.f(64);
    this.hwR = new HashSet();
    this.hwS = new HashSet();
    this.hwT = new Object();
    this.hwU = new com.tencent.mm.a.f(64);
    com.tencent.mm.kernel.h.vH().gXs.a(1352, this);
    com.tencent.mm.kernel.h.vH().gXs.a(1365, this);
    com.tencent.mm.kernel.h.vH().gXs.a(1353, this);
    com.tencent.mm.kernel.h.vH().gXs.a(1354, this);
    com.tencent.mm.kernel.h.vH().gXs.a(1357, this);
    com.tencent.mm.kernel.h.vH().gXs.a(1356, this);
    com.tencent.mm.kernel.h.vH().gXs.a(1355, this);
    com.tencent.mm.kernel.h.vH().gXs.a(1358, this);
    com.tencent.mm.kernel.h.vH().gXs.a(1367, this);
    com.tencent.mm.kernel.h.vH().gXs.a(1361, this);
    com.tencent.mm.kernel.h.vH().gXs.a(1389, this);
    com.tencent.mm.kernel.h.vH().gXs.a(1315, this);
    GMTrace.o(4559913091072L, 33974);
  }
  
  private void DY()
  {
    GMTrace.i(4560584179712L, 33979);
    LinkedList localLinkedList1 = new LinkedList();
    synchronized (this.hwP)
    {
      if (!this.hwO.isEmpty())
      {
        GMTrace.o(4560584179712L, 33979);
        return;
      }
      if (this.hwN.isEmpty())
      {
        GMTrace.o(4560584179712L, 33979);
        return;
      }
      Iterator localIterator = this.hwN.iterator();
      if (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        gr localgr = new gr();
        localgr.tjf = locala.fQc;
        localgr.tiZ = locala.id;
        localLinkedList1.add(localgr);
      }
    }
    if (localLinkedList2.isEmpty())
    {
      GMTrace.o(4560584179712L, 33979);
      return;
    }
    this.hwO.addAll(this.hwN);
    this.hwN.clear();
    ??? = new p(localLinkedList2);
    com.tencent.mm.kernel.h.vH().gXs.a((com.tencent.mm.y.k)???, 0);
    GMTrace.o(4560584179712L, 33979);
  }
  
  private void DZ()
  {
    GMTrace.i(4561121050624L, 33983);
    LinkedList localLinkedList = new LinkedList();
    HashMap localHashMap;
    Object localObject6;
    Object localObject7;
    Object localObject4;
    synchronized (this.hwT)
    {
      if (!this.hwS.isEmpty())
      {
        GMTrace.o(4561121050624L, 33983);
        return;
      }
      if (this.hwR.isEmpty())
      {
        GMTrace.o(4561121050624L, 33983);
        return;
      }
      localHashMap = new HashMap();
      localObject6 = this.hwR.iterator();
      if (((Iterator)localObject6).hasNext())
      {
        localObject7 = (a)((Iterator)localObject6).next();
        localObject4 = (LinkedList)localHashMap.get(((a)localObject7).fQc);
        Object localObject1 = localObject4;
        if (localObject4 == null)
        {
          localObject1 = new LinkedList();
          localHashMap.put(((a)localObject7).fQc, localObject1);
        }
        ((LinkedList)localObject1).add(((a)localObject7).id);
      }
    }
    Object localObject3 = localHashMap.keySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (String)((Iterator)localObject3).next();
      localObject6 = (LinkedList)localHashMap.get(localObject4);
      if ((localObject6 != null) && (!((LinkedList)localObject6).isEmpty()))
      {
        localObject7 = new hp();
        ((hp)localObject7).tjf = ((String)localObject4);
        ((hp)localObject7).tkf = ((LinkedList)localObject6);
        localLinkedList.add(localObject7);
      }
    }
    this.hwS.addAll(this.hwR);
    this.hwR.clear();
    localObject3 = new r(localLinkedList, null);
    com.tencent.mm.kernel.h.vH().gXs.a((com.tencent.mm.y.k)localObject3, 0);
    GMTrace.o(4561121050624L, 33983);
  }
  
  public static void Z(String paramString1, String paramString2)
  {
    GMTrace.i(4561255268352L, 33984);
    paramString1 = new o(paramString1, paramString2);
    com.tencent.mm.kernel.h.vH().gXs.a(paramString1, 0);
    GMTrace.o(4561255268352L, 33984);
  }
  
  public static n a(String paramString, sr paramsr, com.tencent.mm.modelbiz.m paramm)
  {
    GMTrace.i(4561657921536L, 33987);
    paramString = new n(paramString, paramsr, paramm);
    com.tencent.mm.kernel.h.vH().gXs.a(paramString, 0);
    GMTrace.o(4561657921536L, 33987);
    return paramString;
  }
  
  public static w a(String paramString, gq paramgq, com.tencent.mm.modelbiz.m paramm)
  {
    GMTrace.i(4561926356992L, 33989);
    paramString = new w(paramString, paramgq, paramm);
    com.tencent.mm.kernel.h.vH().gXs.a(paramString, 0);
    GMTrace.o(4561926356992L, 33989);
    return paramString;
  }
  
  public static x a(String paramString1, String paramString2, gt paramgt1, gt paramgt2, com.tencent.mm.modelbiz.m paramm)
  {
    GMTrace.i(4561792139264L, 33988);
    paramString1 = new x(paramString1, paramString2, paramgt1, paramgt2, paramm);
    com.tencent.mm.kernel.h.vH().gXs.a(paramString1, 0);
    GMTrace.o(4561792139264L, 33988);
    return paramString1;
  }
  
  public static void a(String paramString, com.tencent.mm.modelbiz.m paramm)
  {
    GMTrace.i(4561523703808L, 33986);
    paramString = new q(paramString, paramm);
    com.tencent.mm.kernel.h.vH().gXs.a(paramString, 0);
    GMTrace.o(4561523703808L, 33986);
  }
  
  public static void a(String paramString1, String paramString2, com.tencent.mm.modelbiz.m paramm)
  {
    GMTrace.i(4561389486080L, 33985);
    if (paramm == null)
    {
      GMTrace.o(4561389486080L, 33985);
      return;
    }
    Object localObject = e.iw(paramString2);
    if ((localObject == null) || (((j)localObject).field_userId.equals(paramString1)))
    {
      a(paramString2, paramm);
      GMTrace.o(4561389486080L, 33985);
      return;
    }
    localObject = new LinkedList();
    ((LinkedList)localObject).add(paramString1);
    paramString1 = new hp();
    paramString1.tjf = paramString2;
    paramString1.tkf = ((LinkedList)localObject);
    paramString2 = new LinkedList();
    paramString2.add(paramString1);
    paramString1 = new r(paramString2, paramm);
    com.tencent.mm.kernel.h.vH().gXs.a(paramString1, 0);
    GMTrace.o(4561389486080L, 33985);
  }
  
  private static boolean a(gx paramgx, String paramString)
  {
    GMTrace.i(4562060574720L, 33990);
    if ((bf.mA(paramString)) || (bf.mA(paramgx.tjg)))
    {
      GMTrace.o(4562060574720L, 33990);
      return false;
    }
    j localj = new j();
    localj.field_userId = paramgx.tjg;
    localj.field_userName = paramgx.kfF;
    localj.field_brandUserName = paramString;
    localj.field_headImageUrl = paramgx.tja;
    localj.field_profileUrl = paramgx.tjo;
    localj.field_UserVersion = paramgx.ver;
    localj.field_addMemberUrl = paramgx.tje;
    if (!com.tencent.mm.modelbiz.w.DL().b(localj)) {
      com.tencent.mm.modelbiz.w.DL().a(localj);
    }
    paramgx = new c();
    paramgx.field_bizChatServId = localj.field_userId;
    paramgx.field_brandUserName = localj.field_brandUserName;
    paramgx.field_chatName = localj.field_userName;
    paramgx.field_chatType = 1;
    if (e.e(paramgx) == null)
    {
      GMTrace.o(4562060574720L, 33990);
      return false;
    }
    GMTrace.o(4562060574720L, 33990);
    return true;
  }
  
  private static boolean a(sr paramsr, String paramString, boolean paramBoolean)
  {
    GMTrace.i(4562194792448L, 33991);
    v.d("MicroMsg.BizChatNetworkMgr", "handleGetBizChatInfoSceneEnd");
    if ((paramsr == null) || (paramsr.tyW == null) || (bf.mA(paramString)))
    {
      v.w("MicroMsg.BizChatNetworkMgr", "fullBizChat or fullBizChat.chat or brandUserName == null");
      GMTrace.o(4562194792448L, 33991);
      return false;
    }
    Object localObject1 = com.tencent.mm.modelbiz.w.DJ().ir(paramsr.tyW.tiZ);
    if (localObject1 == null)
    {
      paramBoolean = true;
      v.w("MicroMsg.BizChatNetworkMgr", "bizChatInfo == null");
      localObject1 = new c();
      ((c)localObject1).field_bizChatServId = paramsr.tyW.tiZ;
      ((c)localObject1).field_brandUserName = paramString;
    }
    for (int i = 1;; i = 0)
    {
      if (paramsr.tjh == null)
      {
        v.w("MicroMsg.BizChatNetworkMgr", "members==null");
        GMTrace.o(4562194792448L, 33991);
        return false;
      }
      Object localObject2;
      label390:
      Object localObject3;
      String str;
      if ((((c)localObject1).DW()) || (paramsr.tyW.ver > ((c)localObject1).field_chatVersion))
      {
        ((c)localObject1).field_chatType = paramsr.tyW.type;
        ((c)localObject1).field_headImageUrl = paramsr.tyW.tja;
        ((c)localObject1).field_chatName = paramsr.tyW.name;
        ((c)localObject1).field_chatVersion = paramsr.tyW.ver;
        ((c)localObject1).field_needToUpdate = false;
        ((c)localObject1).field_bitFlag = paramsr.tyW.tjb;
        ((c)localObject1).field_maxMemberCnt = paramsr.tyW.tjc;
        ((c)localObject1).field_ownerUserId = paramsr.tyW.tjd;
        ((c)localObject1).field_addMemberUrl = paramsr.tyW.tje;
        ((c)localObject1).field_brandUserName = paramString;
        paramString = new LinkedList();
        localObject2 = paramsr.tjh.iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramString.add(((gs)((Iterator)localObject2).next()).tjg);
        }
        ((c)localObject1).field_userList = bf.c(paramString, ";");
        if (i != 0) {
          com.tencent.mm.modelbiz.w.DJ().a((c)localObject1);
        }
      }
      else
      {
        e.h((c)localObject1);
        if (!paramBoolean) {
          break label581;
        }
        paramString = new hp();
        paramString.tjf = ((c)localObject1).field_brandUserName;
        localObject1 = new LinkedList();
        paramsr = paramsr.tjh.iterator();
        if (!paramsr.hasNext()) {
          break label520;
        }
        localObject2 = (gs)paramsr.next();
        localObject3 = com.tencent.mm.modelbiz.w.DL();
        str = ((gs)localObject2).tjg;
        if (!bf.mA(str)) {
          break label483;
        }
        v.w("MicroMsg.BizChatUserInfoStorage", "getBizChatVersion wrong argument");
        i = -1;
      }
      long l;
      for (;;)
      {
        l = i;
        if (((gs)localObject2).ver <= l) {
          break label390;
        }
        ((LinkedList)localObject1).add(((gs)localObject2).tjg);
        break label390;
        com.tencent.mm.modelbiz.w.DJ().b((c)localObject1);
        break;
        label483:
        localObject3 = ((k)localObject3).iE(str);
        if (localObject3 != null)
        {
          i = ((j)localObject3).field_UserVersion;
        }
        else
        {
          v.w("MicroMsg.BizChatUserInfoStorage", "getBizChatVersion item == null");
          i = -1;
        }
      }
      label520:
      if (((LinkedList)localObject1).size() > 0)
      {
        paramString.tkf = ((LinkedList)localObject1);
        paramsr = new LinkedList();
        paramsr.add(paramString);
        paramsr = new r(paramsr, null);
        com.tencent.mm.kernel.h.vH().gXs.a(paramsr, 0);
      }
      for (;;)
      {
        GMTrace.o(4562194792448L, 33991);
        return true;
        label581:
        paramString = com.tencent.mm.modelbiz.w.DL().gUp;
        l = 0L;
        if ((paramString instanceof com.tencent.mm.bj.g)) {
          l = ((com.tencent.mm.bj.g)paramString).cs(Thread.currentThread().getId());
        }
        paramsr = paramsr.tjh.iterator();
        while (paramsr.hasNext())
        {
          localObject2 = (gs)paramsr.next();
          localObject3 = com.tencent.mm.modelbiz.w.DL().iE(((gs)localObject2).tjg);
          if (localObject3 == null)
          {
            localObject3 = new j();
            ((j)localObject3).field_userId = ((gs)localObject2).tjg;
            ((j)localObject3).field_userName = ((gs)localObject2).kfF;
            ((j)localObject3).field_brandUserName = ((c)localObject1).field_brandUserName;
            ((j)localObject3).field_needToUpdate = true;
            com.tencent.mm.modelbiz.w.DL().a((j)localObject3);
          }
          else if (((gs)localObject2).ver > ((j)localObject3).field_UserVersion)
          {
            ((j)localObject3).field_needToUpdate = true;
            com.tencent.mm.modelbiz.w.DL().b((j)localObject3);
          }
        }
        if ((paramString instanceof com.tencent.mm.bj.g)) {
          com.tencent.mm.kernel.h.vI().gXW.aD(l);
        }
      }
    }
  }
  
  public static void f(com.tencent.mm.y.k paramk)
  {
    GMTrace.i(14588527509504L, 108693);
    com.tencent.mm.kernel.h.vH().gXs.c(paramk);
    GMTrace.o(14588527509504L, 108693);
  }
  
  public final void W(String paramString1, String paramString2)
  {
    GMTrace.i(4560315744256L, 33977);
    ??? = (Long)this.hwQ.get(paramString1);
    if ((??? == null) || (((Long)???).longValue() + 5000L < System.currentTimeMillis()))
    {
      long l = System.currentTimeMillis();
      synchronized (this.hwP)
      {
        paramString2 = new a(paramString2, paramString1);
        if (this.hwO.contains(paramString2))
        {
          GMTrace.o(4560315744256L, 33977);
          return;
        }
        this.hwN.add(paramString2);
        this.hwQ.put(paramString1, new Long(l));
        DY();
        GMTrace.o(4560315744256L, 33977);
        return;
      }
    }
    GMTrace.o(4560315744256L, 33977);
  }
  
  public final void X(String paramString1, String paramString2)
  {
    GMTrace.i(4560718397440L, 33980);
    Long localLong = (Long)this.hwU.get(paramString1);
    if ((localLong == null) || (localLong.longValue() + 5000L < System.currentTimeMillis())) {
      Y(paramString1, paramString2);
    }
    GMTrace.o(4560718397440L, 33980);
  }
  
  public final void Y(String paramString1, String paramString2)
  {
    GMTrace.i(4560852615168L, 33981);
    long l = System.currentTimeMillis();
    synchronized (this.hwT)
    {
      paramString2 = new a(paramString2, paramString1);
      if (this.hwS.contains(paramString2))
      {
        GMTrace.o(4560852615168L, 33981);
        return;
      }
      this.hwR.add(paramString2);
      this.hwU.put(paramString1, new Long(l));
      DZ();
      GMTrace.o(4560852615168L, 33981);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String arg3, com.tencent.mm.y.k paramk)
  {
    GMTrace.i(4560181526528L, 33976);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:Network not ok");
      if ((paramk.getType() != 1365) && (paramk.getType() != 1353))
      {
        GMTrace.o(4560181526528L, 33976);
        return;
      }
    }
    Object localObject1;
    boolean bool1;
    label332:
    label338:
    label357:
    Object localObject2;
    switch (paramk.getType())
    {
    default: 
      GMTrace.o(4560181526528L, 33976);
      return;
    case 1352: 
      localObject1 = (o)paramk;
      if ((((o)localObject1).gUq != null) && (((o)localObject1).gUq.hrT.hsa != null))
      {
        ??? = (ve)((o)localObject1).gUq.hrT.hsa;
        if ((((o)localObject1).gUq == null) || (((o)localObject1).gUq.hrS.hsa == null)) {
          break label332;
        }
      }
      for (paramk = (vd)((o)localObject1).gUq.hrS.hsa;; paramk = null)
      {
        bool1 = ((o)localObject1).hxd;
        if ((??? != null) && (???.tjl != null) && (???.tjl.ret == 0)) {
          break label357;
        }
        if ((??? == null) || (???.tjl == null)) {
          break label338;
        }
        v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.tjl.ret) });
        GMTrace.o(4560181526528L, 33976);
        return;
        ??? = null;
        break;
      }
      v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
      GMTrace.o(4560181526528L, 33976);
      return;
      a(???.tru, paramk.tjf, bool1);
      GMTrace.o(4560181526528L, 33976);
      return;
    case 1365: 
      synchronized (this.hwP)
      {
        this.hwO.clear();
        DY();
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          GMTrace.o(4560181526528L, 33976);
          return;
        }
      }
      paramk = (p)paramk;
      if ((paramk.gUq != null) && (paramk.gUq.hrT.hsa != null)) {
        ??? = (vc)paramk.gUq.hrT.hsa;
      }
      while ((??? == null) || (???.tjl == null) || (???.tjl.ret != 0)) {
        if ((??? != null) && (???.tjl != null))
        {
          v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.tjl.ret) });
          GMTrace.o(4560181526528L, 33976);
          return;
          ??? = null;
        }
        else
        {
          v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
          GMTrace.o(4560181526528L, 33976);
          return;
        }
      }
      ??? = ???.tBc;
      if ((??? == null) || (???.size() == 0))
      {
        v.w("MicroMsg.BizChatNetworkMgr", "fullBizChats is empty");
        GMTrace.o(4560181526528L, 33976);
        return;
      }
      localObject1 = ???.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (sr)((Iterator)localObject1).next();
        ??? = ((sr)localObject2).tyW.tiZ;
        if ((??? == null) || (paramk.hxe == null)) {}
        for (??? = null;; ??? = (String)paramk.hxe.get(???))
        {
          a((sr)localObject2, ???, false);
          break;
        }
      }
      GMTrace.o(4560181526528L, 33976);
      return;
    case 1353: 
      localObject1 = (r)paramk;
      localObject2 = (com.tencent.mm.modelbiz.m)((r)localObject1).data;
      if (localObject2 == null) {}
      synchronized (this.hwT)
      {
        this.hwS.clear();
        DZ();
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          GMTrace.o(4560181526528L, 33976);
          return;
        }
      }
      if ((((r)localObject1).gUq != null) && (((r)localObject1).gUq.hrT.hsa != null))
      {
        ??? = (vi)((r)localObject1).gUq.hrT.hsa;
        paramInt1 = 0;
        if ((??? == null) || (???.tjl == null) || (???.tjl.ret != 0))
        {
          if ((??? == null) || (???.tjl == null)) {
            break label1248;
          }
          v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.tjl.ret) });
          label852:
          paramInt1 = -1;
        }
        if ((paramInt1 < 0) || (???.tjm != null)) {
          break label3806;
        }
        v.w("MicroMsg.BizChatNetworkMgr", "resp.user==null");
        paramInt1 = -1;
      }
      break;
    }
    label917:
    label1028:
    label1166:
    label1189:
    label1248:
    label1280:
    label1292:
    label1304:
    label1418:
    label1429:
    label1487:
    label1568:
    label1587:
    label1924:
    label1994:
    label2077:
    label2159:
    label2211:
    label2336:
    label2418:
    label2470:
    label2681:
    label2805:
    label2843:
    label2910:
    label2944:
    label2954:
    label3185:
    label3191:
    label3203:
    label3209:
    label3215:
    label3385:
    label3785:
    label3788:
    label3793:
    label3798:
    label3801:
    label3806:
    for (;;)
    {
      Object localObject3;
      Object localObject4;
      boolean bool2;
      if (paramInt1 >= 0)
      {
        localObject3 = com.tencent.mm.modelbiz.w.DL().gUp;
        long l = 0L;
        if ((localObject3 instanceof com.tencent.mm.bj.g)) {
          l = ((com.tencent.mm.bj.g)localObject3).cs(Thread.currentThread().getId());
        }
        paramInt2 = 0;
        if (paramInt2 < ???.tjm.size())
        {
          v.d("MicroMsg.BizChatNetworkMgr", "GetBizChatUserInfoList %s", new Object[] { ((gx)???.tjm.get(paramInt2)).kfF });
          localObject4 = new j();
          ((j)localObject4).field_userId = ((gx)???.tjm.get(paramInt2)).tjg;
          ((j)localObject4).field_userName = ((gx)???.tjm.get(paramInt2)).kfF;
          paramk = ((j)localObject4).field_userId;
          if ((paramk == null) || (((r)localObject1).hxf == null))
          {
            paramk = null;
            ((j)localObject4).field_brandUserName = paramk;
            ((j)localObject4).field_UserVersion = ((gx)???.tjm.get(paramInt2)).ver;
            ((j)localObject4).field_headImageUrl = ((gx)???.tjm.get(paramInt2)).tja;
            ((j)localObject4).field_profileUrl = ((gx)???.tjm.get(paramInt2)).tjo;
            ((j)localObject4).field_bitFlag = ((gx)???.tjm.get(paramInt2)).tjb;
            ((j)localObject4).field_addMemberUrl = ((gx)???.tjm.get(paramInt2)).tje;
            ((j)localObject4).field_needToUpdate = false;
            paramk = com.tencent.mm.modelbiz.w.DL().iE(((gx)???.tjm.get(paramInt2)).tjg);
            if (paramk != null) {
              break label1280;
            }
            bool1 = false;
            bool2 = ((j)localObject4).fu(16);
            if (paramk != null) {
              break label1292;
            }
            com.tencent.mm.modelbiz.w.DL().a((j)localObject4);
            if (bool1 != bool2)
            {
              paramk = com.tencent.mm.modelbiz.w.DJ().ir(((j)localObject4).field_userId);
              if (paramk != null)
              {
                if ((!bool1) || (bool2)) {
                  break label1304;
                }
                com.tencent.mm.modelbiz.w.DK().Z(paramk.field_bizChatLocalId);
              }
            }
          }
          for (;;)
          {
            paramInt2 += 1;
            break label917;
            ??? = null;
            break;
            v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
            break label852;
            paramk = (String)((r)localObject1).hxf.get(paramk);
            break label1028;
            bool1 = paramk.fu(16);
            break label1166;
            com.tencent.mm.modelbiz.w.DL().b((j)localObject4);
            break label1189;
            if ((!bool1) && (bool2)) {
              com.tencent.mm.modelbiz.w.DK().Y(paramk.field_bizChatLocalId);
            }
          }
        }
        if ((localObject3 instanceof com.tencent.mm.bj.g)) {
          com.tencent.mm.kernel.h.vI().gXW.aD(l);
        }
      }
      if (localObject2 != null) {
        ((com.tencent.mm.modelbiz.m)localObject2).a(paramInt1, (com.tencent.mm.y.k)localObject1);
      }
      GMTrace.o(4560181526528L, 33976);
      return;
      localObject1 = (q)paramk;
      if ((((q)localObject1).gUq != null) && (((q)localObject1).gUq.hrT.hsa != null))
      {
        ??? = (vg)((q)localObject1).gUq.hrT.hsa;
        if (((q)localObject1).gUq != null) {
          break label1568;
        }
        paramk = null;
        if ((??? != null) && (???.tjl != null) && (???.tjl.ret == 0)) {
          break label3801;
        }
        if ((??? == null) || (???.tjl == null)) {
          break label1587;
        }
        v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.tjl.ret) });
      }
      for (paramInt1 = -1;; paramInt1 = 0)
      {
        if (paramInt1 >= 0)
        {
          localObject2 = com.tencent.mm.modelbiz.w.DL();
          paramk = paramk.tjf;
          ??? = ???.tji;
          if ((??? == null) || (bf.mA(paramk))) {
            v.w("MicroMsg.BizChatUserInfoStorage", "setMyUserId: wrong argument");
          }
        }
        else
        {
          ??? = (com.tencent.mm.modelbiz.m)((q)localObject1).data;
          if (??? != null) {
            ???.a(paramInt1, (com.tencent.mm.y.k)localObject1);
          }
          GMTrace.o(4560181526528L, 33976);
          return;
          ??? = null;
          break label1418;
          paramk = (vf)((q)localObject1).gUq.hrS.hsa;
          break label1429;
          v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
          break label1487;
        }
        v.i("MicroMsg.BizChatUserInfoStorage", "setMyUserId:%s,%s,%s", new Object[] { paramk, ???.tjg, Boolean.valueOf(bf.mA(???.tje)) });
        localObject3 = com.tencent.mm.modelbiz.w.DM().iC(paramk);
        if (localObject3 == null)
        {
          localObject3 = new f();
          ((f)localObject3).field_brandUserName = paramk;
          ((f)localObject3).field_userId = ???.tjg;
          com.tencent.mm.modelbiz.w.DM().a((f)localObject3);
        }
        for (;;)
        {
          localObject3 = new j();
          ((j)localObject3).field_userId = ???.tjg;
          ((j)localObject3).field_userName = ???.kfF;
          ((j)localObject3).field_brandUserName = paramk;
          ((j)localObject3).field_UserVersion = ???.ver;
          ((j)localObject3).field_headImageUrl = ???.tja;
          ((j)localObject3).field_profileUrl = ???.tjo;
          ((j)localObject3).field_bitFlag = ???.tjb;
          ((j)localObject3).field_needToUpdate = false;
          ((j)localObject3).field_addMemberUrl = ???.tje;
          if (!((k)localObject2).b((j)localObject3)) {
            ((k)localObject2).a((j)localObject3);
          }
          ((k)localObject2).hwq.put(paramk, ((j)localObject3).field_userId);
          break;
          ((f)localObject3).field_userId = ???.tjg;
          com.tencent.mm.modelbiz.w.DM().b((f)localObject3);
          v.i("MicroMsg.BizChatUserInfoStorage", "setMyUserId: MyUserId seted");
        }
        ??? = (n)paramk;
        paramk = ???.Eb();
        localObject1 = ???.Ec();
        paramInt1 = 0;
        if ((paramk == null) || (paramk.tjl == null) || (paramk.tjl.ret != 0))
        {
          if ((paramk != null) && (paramk.tjl != null))
          {
            v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramk.tjl.ret) });
            paramInt1 = -1;
          }
        }
        else
        {
          if (paramInt1 < 0) {
            break label3798;
          }
          if (!a(paramk.tru, ((mr)localObject1).tjf, true)) {
            break label1994;
          }
          paramInt1 = 0;
        }
        for (;;)
        {
          paramk = (com.tencent.mm.modelbiz.m)???.data;
          if (paramk != null) {
            paramk.a(paramInt1, ???);
          }
          GMTrace.o(4560181526528L, 33976);
          return;
          v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
          break label1924;
          paramInt1 = -1;
          continue;
          ??? = (t)paramk;
          paramk = ???.Ed();
          paramInt1 = 0;
          if ((paramk == null) || (paramk.tjl == null) || (paramk.tjl.ret != 0))
          {
            if ((paramk != null) && (paramk.tjl != null))
            {
              v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramk.tjl.ret) });
              paramInt1 = -1;
            }
          }
          else
          {
            paramInt2 = paramInt1;
            if (paramInt1 >= 0)
            {
              paramInt2 = paramInt1;
              if (paramk.trp == null)
              {
                paramInt2 = paramInt1;
                if (paramk.tro == null) {
                  paramInt2 = -1;
                }
              }
            }
            if (paramInt2 < 0) {
              break label3793;
            }
            if (paramk.trp == null) {
              break label2211;
            }
            bool2 = a(paramk.trp, paramk.tjf);
            bool1 = bool2;
            if (bool2)
            {
              ???.hxc = paramk.trp.tjg;
              bool1 = bool2;
            }
            if (bool1) {
              break label3793;
            }
          }
          for (paramInt1 = -1;; paramInt1 = paramInt2)
          {
            paramk = (com.tencent.mm.modelbiz.m)???.data;
            if (paramk != null) {
              paramk.a(paramInt1, ???);
            }
            GMTrace.o(4560181526528L, 33976);
            return;
            v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
            break label2077;
            bool2 = a(paramk.tro, paramk.tjf, true);
            bool1 = bool2;
            if (!bool2) {
              break label2159;
            }
            ???.hxc = paramk.tro.tyW.tiZ;
            bool1 = bool2;
            break label2159;
            ??? = (m)paramk;
            paramk = ???.Ea();
            paramInt1 = 0;
            if ((paramk == null) || (paramk.tjl == null) || (paramk.tjl.ret != 0))
            {
              if ((paramk != null) && (paramk.tjl != null))
              {
                v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(paramk.tjl.ret) });
                paramInt1 = -1;
              }
            }
            else
            {
              paramInt2 = paramInt1;
              if (paramInt1 >= 0)
              {
                paramInt2 = paramInt1;
                if (paramk.trp == null)
                {
                  paramInt2 = paramInt1;
                  if (paramk.tro == null) {
                    paramInt2 = -1;
                  }
                }
              }
              if (paramInt2 < 0) {
                break label3788;
              }
              if (paramk.trp == null) {
                break label2470;
              }
              bool2 = a(paramk.trp, paramk.tjf);
              bool1 = bool2;
              if (bool2)
              {
                ???.hxc = paramk.trp.tjg;
                bool1 = bool2;
              }
              if (bool1) {
                break label3788;
              }
            }
            for (paramInt1 = -1;; paramInt1 = paramInt2)
            {
              paramk = (com.tencent.mm.modelbiz.m)???.data;
              if (paramk != null) {
                paramk.a(paramInt1, ???);
              }
              GMTrace.o(4560181526528L, 33976);
              return;
              v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
              break label2336;
              bool2 = a(paramk.tro, paramk.tjf, true);
              bool1 = bool2;
              if (!bool2) {
                break label2418;
              }
              ???.hxc = paramk.tro.tyW.tiZ;
              bool1 = bool2;
              break label2418;
              v.d("MicroMsg.BizChatNetworkMgr", "handleUpdateBizChatMemberListSceneEnd");
              localObject1 = (x)paramk;
              if ((((x)localObject1).gUq != null) && (((x)localObject1).gUq.hrT.hsa != null))
              {
                ??? = (bgd)((x)localObject1).gUq.hrT.hsa;
                if ((((x)localObject1).gUq == null) || (((x)localObject1).gUq.hrS.hsa == null)) {
                  break label2681;
                }
                paramk = (bgc)((x)localObject1).gUq.hrS.hsa;
              }
              for (;;)
              {
                if ((??? == null) || (???.tjl == null) || (???.tjl.ret != 0))
                {
                  if ((??? != null) && (???.tjl != null))
                  {
                    v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.tjl.ret) });
                    GMTrace.o(4560181526528L, 33976);
                    return;
                    ??? = null;
                    break;
                    paramk = null;
                    continue;
                  }
                  v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                  GMTrace.o(4560181526528L, 33976);
                  return;
                }
              }
              if (a(???.tru, paramk.tjf, false)) {}
              for (paramInt1 = 0;; paramInt1 = -1)
              {
                ??? = (com.tencent.mm.modelbiz.m)((x)localObject1).data;
                if (??? != null) {
                  ???.a(paramInt1, (com.tencent.mm.y.k)localObject1);
                }
                GMTrace.o(4560181526528L, 33976);
                return;
              }
              localObject1 = (w)paramk;
              if ((((w)localObject1).gUq != null) && (((w)localObject1).gUq.hrT.hsa != null))
              {
                ??? = (bgf)((w)localObject1).gUq.hrT.hsa;
                if ((((w)localObject1).gUq == null) || (((w)localObject1).gUq.hrS.hsa == null)) {
                  break label3185;
                }
                paramk = (bge)((w)localObject1).gUq.hrS.hsa;
                paramInt1 = 0;
                if ((??? == null) || (???.tjl == null) || (???.tjl.ret != 0) || (???.tyW == null))
                {
                  if ((??? == null) || (???.tjl == null)) {
                    break label3191;
                  }
                  v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.tjl.ret) });
                  paramInt1 = -1;
                }
                if (paramInt1 < 0) {
                  break label3785;
                }
                localObject2 = com.tencent.mm.modelbiz.w.DJ().ir(???.tyW.tiZ);
                if (localObject2 == null)
                {
                  if (localObject2 != null) {
                    break label3203;
                  }
                  bool1 = true;
                  if (???.tyW != null) {
                    break label3209;
                  }
                  bool2 = true;
                  v.w("MicroMsg.BizChatNetworkMgr", "bizChatInfo == null:%s, resp.chat == null:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                  paramInt1 = -1;
                }
                if ((paramInt1 < 0) || (((((c)localObject2).field_bitFlag == ???.tyW.tjb) || (!((c)localObject2).DW())) && (???.tyW.ver <= ((c)localObject2).field_chatVersion))) {
                  break label3215;
                }
                ((c)localObject2).field_chatType = ???.tyW.type;
                ((c)localObject2).field_headImageUrl = ???.tyW.tja;
                ((c)localObject2).field_chatName = ???.tyW.name;
                ((c)localObject2).field_chatVersion = ???.tyW.ver;
                ((c)localObject2).field_needToUpdate = false;
                ((c)localObject2).field_bitFlag = ???.tyW.tjb;
                ((c)localObject2).field_maxMemberCnt = ???.tyW.tjc;
                ((c)localObject2).field_ownerUserId = ???.tyW.tjd;
                ((c)localObject2).field_addMemberUrl = ???.tyW.tje;
                ((c)localObject2).field_brandUserName = paramk.tjf;
                com.tencent.mm.modelbiz.w.DJ().b((c)localObject2);
              }
              for (;;)
              {
                ??? = (com.tencent.mm.modelbiz.m)((w)localObject1).data;
                if (??? != null) {
                  ???.a(paramInt1, (com.tencent.mm.y.k)localObject1);
                }
                GMTrace.o(4560181526528L, 33976);
                return;
                ??? = null;
                break label2805;
                paramk = null;
                break label2843;
                v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                break label2910;
                bool1 = false;
                break label2944;
                bool2 = false;
                break label2954;
                paramInt1 = -1;
                continue;
                GMTrace.o(4560181526528L, 33976);
                return;
                paramk = (s)paramk;
                if ((paramk.gUq != null) && (paramk.gUq.hrT.hsa != null))
                {
                  ??? = (yd)paramk.gUq.hrT.hsa;
                  if ((paramk.gUq == null) || (paramk.gUq.hrS.hsa == null)) {
                    break label3385;
                  }
                  paramk = (yc)paramk.gUq.hrS.hsa;
                }
                for (;;)
                {
                  if ((??? == null) || (???.tjl == null) || (???.tjl.ret != 0))
                  {
                    if ((??? != null) && (???.tjl != null))
                    {
                      v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[] { Integer.valueOf(???.tjl.ret) });
                      GMTrace.o(4560181526528L, 33976);
                      return;
                      ??? = null;
                      break;
                      paramk = null;
                      continue;
                    }
                    v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    GMTrace.o(4560181526528L, 33976);
                    return;
                  }
                }
                localObject2 = ???.tCY;
                localObject3 = com.tencent.mm.modelbiz.w.DJ();
                localObject4 = paramk.tjf;
                localObject1 = new ArrayList();
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("select bizChatServId from BizChatInfo");
                localStringBuilder.append(" where brandUserName = '").append((String)localObject4).append("'");
                localStringBuilder.append(" and (bitFlag & 8").append(") != 0 ");
                localObject3 = ((d)localObject3).rawQuery(localStringBuilder.toString(), new String[0]);
                if (localObject3 != null)
                {
                  if (((Cursor)localObject3).moveToFirst()) {
                    do
                    {
                      ((ArrayList)localObject1).add(((Cursor)localObject3).getString(0));
                    } while (((Cursor)localObject3).moveToNext());
                  }
                  ((Cursor)localObject3).close();
                }
                localObject3 = ((List)localObject1).iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  localObject4 = (String)((Iterator)localObject3).next();
                  if (!((List)localObject2).contains(localObject4))
                  {
                    localObject4 = com.tencent.mm.modelbiz.w.DJ().ir((String)localObject4);
                    if (localObject4 != null)
                    {
                      ((c)localObject4).field_bitFlag &= 0xFFFFFFF7;
                      com.tencent.mm.modelbiz.w.DJ().b((c)localObject4);
                    }
                  }
                }
                localObject2 = ((List)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject3 = (String)((Iterator)localObject2).next();
                  if (!((List)localObject1).contains(localObject3))
                  {
                    localObject4 = com.tencent.mm.modelbiz.w.DJ().ir((String)localObject3);
                    if (localObject4 == null)
                    {
                      localObject4 = new c();
                      ((c)localObject4).field_bizChatServId = ((String)localObject3);
                      ((c)localObject4).field_brandUserName = paramk.tjf;
                      ((c)localObject4).field_bitFlag |= 0x8;
                      com.tencent.mm.modelbiz.w.DJ().a((c)localObject4);
                    }
                    else
                    {
                      ((c)localObject4).field_bitFlag |= 0x8;
                      com.tencent.mm.modelbiz.w.DJ().b((c)localObject4);
                    }
                  }
                }
                a(???.tCY, paramk.tjf);
                break;
              }
            }
          }
        }
      }
    }
  }
  
  public final void a(LinkedList<String> paramLinkedList, String paramString)
  {
    GMTrace.i(4560449961984L, 33978);
    long l = System.currentTimeMillis();
    synchronized (this.hwP)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        String str = (String)paramLinkedList.next();
        a locala = new a(paramString, str);
        if (!this.hwO.contains(locala))
        {
          this.hwN.add(locala);
          this.hwQ.put(str, new Long(l));
        }
      }
    }
    DY();
    GMTrace.o(4560449961984L, 33978);
  }
  
  public final void b(LinkedList<String> paramLinkedList, String paramString)
  {
    GMTrace.i(4560986832896L, 33982);
    long l = System.currentTimeMillis();
    synchronized (this.hwT)
    {
      paramLinkedList = paramLinkedList.iterator();
      if (paramLinkedList.hasNext())
      {
        String str = (String)paramLinkedList.next();
        a locala = new a(paramString, str);
        if (this.hwS.contains(locala))
        {
          GMTrace.o(4560986832896L, 33982);
          return;
        }
        this.hwR.add(locala);
        this.hwU.put(str, new Long(l));
      }
    }
    DZ();
    GMTrace.o(4560986832896L, 33982);
  }
  
  protected final void finalize()
  {
    GMTrace.i(4560047308800L, 33975);
    com.tencent.mm.kernel.h.vH().gXs.b(1352, this);
    com.tencent.mm.kernel.h.vH().gXs.b(1365, this);
    com.tencent.mm.kernel.h.vH().gXs.b(1353, this);
    com.tencent.mm.kernel.h.vH().gXs.b(1354, this);
    com.tencent.mm.kernel.h.vH().gXs.b(1357, this);
    com.tencent.mm.kernel.h.vH().gXs.b(1356, this);
    com.tencent.mm.kernel.h.vH().gXs.b(1355, this);
    com.tencent.mm.kernel.h.vH().gXs.b(1358, this);
    com.tencent.mm.kernel.h.vH().gXs.b(1367, this);
    com.tencent.mm.kernel.h.vH().gXs.b(1361, this);
    com.tencent.mm.kernel.h.vH().gXs.b(1389, this);
    com.tencent.mm.kernel.h.vH().gXs.b(1315, this);
    super.finalize();
    GMTrace.o(4560047308800L, 33975);
  }
  
  public static class a
  {
    public String fQc;
    public String id;
    
    public a(String paramString1, String paramString2)
    {
      GMTrace.i(4583132758016L, 34147);
      this.fQc = paramString1;
      this.id = paramString2;
      GMTrace.o(4583132758016L, 34147);
    }
    
    public boolean equals(Object paramObject)
    {
      GMTrace.i(4583266975744L, 34148);
      if (paramObject.getClass() != a.class)
      {
        GMTrace.o(4583266975744L, 34148);
        return false;
      }
      paramObject = (a)paramObject;
      if (((this.fQc == null) && (((a)paramObject).fQc == null)) || ((this.fQc != null) && (this.fQc.equals(((a)paramObject).fQc)) && (((this.id == null) && (((a)paramObject).id == null)) || ((this.id != null) && (this.id.equals(((a)paramObject).id))))))
      {
        GMTrace.o(4583266975744L, 34148);
        return true;
      }
      GMTrace.o(4583266975744L, 34148);
      return false;
    }
    
    public int hashCode()
    {
      GMTrace.i(4583401193472L, 34149);
      int i = this.fQc.hashCode();
      int j = this.id.hashCode();
      GMTrace.o(4583401193472L, 34149);
      return i + j;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */