package com.tencent.mm.modelmulti;

import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bd.a;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.g;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.protocal.c.wq;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.bp;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public final class b
  implements j.a
{
  public Queue<b> hDp;
  public ai hDt;
  public final ai hDu;
  public Map<String, LinkedList<a>> hJr;
  LinkedBlockingQueue<a> hJs;
  public c hJt;
  public Map<Long, ao> hJu;
  long hqC;
  public boolean hqr;
  
  b()
  {
    GMTrace.i(408692981760L, 3045);
    this.hqr = false;
    this.hqC = 0L;
    this.hJr = new HashMap();
    this.hJs = new LinkedBlockingQueue();
    this.hDp = new LinkedList();
    this.hJu = new HashMap();
    this.hDt = new ai(com.tencent.mm.u.ap.vL().nIe.getLooper(), new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(405740191744L, 3023);
        v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr pusherTry onTimerExpired tryStartNetscene");
        b localb = b.this;
        long l1 = com.tencent.mm.platformtools.u.NA();
        if ((localb.hqr) && (l1 - localb.hqC > 300000L))
        {
          v.w("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene Not Callback too long:%d . Force Run Now", new Object[] { Long.valueOf(l1 - localb.hqC) });
          localb.hqr = false;
        }
        if (localb.hqr) {
          v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene netSceneRunning: " + localb.hqr + " ret");
        }
        for (;;)
        {
          GMTrace.o(405740191744L, 3023);
          return false;
          ??? = null;
          b.a locala = null;
          if (!localb.hJs.isEmpty())
          {
            locala = (b.a)localb.hJs.poll();
            ??? = locala.hJx;
          }
          if (locala != null) {
            break label1430;
          }
          synchronized (localb.hJr)
          {
            v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene needGetInfosMap size[%d], content[%s]", new Object[] { Integer.valueOf(localb.hJr.size()), localb.hJr });
            if ((localb.hJt == null) || (com.tencent.mm.platformtools.u.mA(localb.hJt.Hr())))
            {
              localb.hJr.clear();
              localb.hJt = null;
              v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene currentListener is or its chatroomid is null ret");
            }
          }
        }
        String str = localb.hJt.Hr();
        Object localObject5 = (LinkedList)localb.hJr.get(str);
        int i;
        label362:
        Object localObject3;
        au localau;
        if ((localObject5 == null) || (((LinkedList)localObject5).size() == 0))
        {
          if (localObject5 == null) {}
          for (i = -1;; i = ((LinkedList)localObject5).size())
          {
            v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene current talker[%s] no infos and ret infos size:%d", new Object[] { str, Integer.valueOf(i) });
            break;
          }
          v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in map in db but not fault: " + localObject3 + " flag:" + localau.field_flag + " seq:" + localau.field_msgSeq);
        }
        Object localObject2;
        if (!((LinkedList)localObject5).isEmpty())
        {
          localObject3 = (b.a)((LinkedList)localObject5).poll();
          com.tencent.mm.u.ap.yY();
          localau = com.tencent.mm.u.c.wT().y(str, ((b.a)localObject3).hJz);
          if (localau.field_msgId == 0L)
          {
            v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in map not in db:" + localObject3);
            localObject2 = localObject3;
            label486:
            localObject3 = localObject2;
            ??? = str;
            if (localObject2 == null)
            {
              localObject3 = localObject2;
              ??? = str;
              if (!com.tencent.mm.platformtools.u.mA(str))
              {
                com.tencent.mm.u.ap.yY();
                localObject5 = com.tencent.mm.u.c.wW().Rl(str);
                localObject3 = localObject2;
                ??? = str;
                if (localObject5 != null)
                {
                  long l2 = ((aj)localObject5).field_lastSeq;
                  long l3 = ((aj)localObject5).field_firstUnDeliverSeq;
                  i = ((aj)localObject5).field_UnDeliverCount;
                  v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene filterSeq[%d], lastSeq[%d], undeliverCount[%d]", new Object[] { Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(i) });
                  localObject3 = localObject2;
                  ??? = str;
                  if (l2 != 0L)
                  {
                    com.tencent.mm.u.ap.yY();
                    localObject3 = com.tencent.mm.u.c.wT().y(str, l2);
                    if (((ce)localObject3).field_msgId != 0L) {
                      break label798;
                    }
                    localObject3 = new b.a(str, (int)l3, (int)l2, i, 1);
                    v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in db:" + localObject3);
                    ??? = str;
                  }
                }
              }
            }
          }
        }
        for (;;)
        {
          v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene nextInfo:" + localObject3);
          if (localObject3 == null)
          {
            localb.hDt.v(500L, 500L);
            break;
            if ((localau.field_flag & 0x1) == 0) {
              break label362;
            }
            v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in map in db but fault: " + localObject3 + " flag:" + localau.field_flag + " seq:" + localau.field_msgSeq);
            localObject2 = localObject3;
            break label486;
            label798:
            if (i > 0)
            {
              ((com.tencent.mm.storage.ae)localObject5).dt(0);
              com.tencent.mm.u.ap.yY();
              com.tencent.mm.u.c.wW().a((com.tencent.mm.storage.ae)localObject5, str);
            }
            v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in db but has get msg id:%d, svrId:%d, undeliverCount[%d]", new Object[] { Long.valueOf(((ce)localObject3).field_msgId), Long.valueOf(((ce)localObject3).field_msgSvrId), Integer.valueOf(((aj)localObject5).field_UnDeliverCount) });
            localObject3 = localObject2;
            ??? = str;
            continue;
          }
          localb.hqr = true;
          localb.hqC = l1;
          localObject2 = new wq();
          ((wq)localObject2).tBH = com.tencent.mm.platformtools.n.mw((String)???);
          ((wq)localObject2).tdF = ((b.a)localObject3).hJz;
          if (((b.a)localObject3).hJz == 0)
          {
            ((wq)localObject2).tBI = 0;
            if (((b.a)localObject3).hJA != 0) {
              v.w("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene msgSeq is 0 but needCount[%d], stack[%s]!", new Object[] { Integer.valueOf(((b.a)localObject3).hJA), com.tencent.mm.platformtools.u.ND() });
            }
            label973:
            ((wq)localObject2).tBJ = ((b.a)localObject3).hJB;
            ((wq)localObject2).tBL = ((b.a)localObject3).hJy;
            if (((((wq)localObject2).tBJ != 0) && (((wq)localObject2).tBL > ((wq)localObject2).tdF)) || ((((wq)localObject2).tBJ == 0) && (((wq)localObject2).tBL < ((wq)localObject2).tdF)))
            {
              v.w("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene FilterSeq msgSeq UpDownFlag not match[%d][%d][%d], stack[%s]!", new Object[] { Integer.valueOf(((wq)localObject2).tBL), Integer.valueOf(((wq)localObject2).tdF), Integer.valueOf(((wq)localObject2).tBJ), com.tencent.mm.platformtools.u.ND() });
              ??? = com.tencent.mm.plugin.report.c.oRz;
              if (((wq)localObject2).tBJ != 0) {
                break label1392;
              }
              l1 = 0L;
              label1101:
              ((com.tencent.mm.plugin.report.c)???).a(403L, l1, 1L, false);
              if (localb.hJt != null) {
                localb.hJt.gd(1);
              }
            }
            if ((((wq)localObject2).tBJ != 0) && (((wq)localObject2).tBL == 0) && (((b.a)localObject3).hJA < 18))
            {
              if (((b.a)localObject3).hJA <= 0) {
                break label1397;
              }
              ((wq)localObject2).tBI = ((b.a)localObject3).hJA;
              label1175:
              v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene UpDownFlag FilterSeq 0 fix need nextInfo: %d req: %d", new Object[] { Integer.valueOf(((b.a)localObject3).hJA), Integer.valueOf(((wq)localObject2).tBI) });
            }
            v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene FilterSeq[%d], MsgSeq[%d], NeedCount[%d], UpDownFlag[%d], ClearFlag[%d]", new Object[] { Integer.valueOf(((wq)localObject2).tBL), Integer.valueOf(((wq)localObject2).tdF), Integer.valueOf(((wq)localObject2).tBI), Integer.valueOf(((wq)localObject2).tBJ), Integer.valueOf(((wq)localObject2).tBK) });
            localObject3 = new com.tencent.mm.y.b.a();
            ((com.tencent.mm.y.b.a)localObject3).hrV = ((a)localObject2);
            ((com.tencent.mm.y.b.a)localObject3).hrW = new wr();
            ((com.tencent.mm.y.b.a)localObject3).uri = "/cgi-bin/micromsg-bin/getcrmsg";
            ((com.tencent.mm.y.b.a)localObject3).hrU = 805;
            ((com.tencent.mm.y.b.a)localObject3).hrX = 0;
            ((com.tencent.mm.y.b.a)localObject3).hrY = 0;
            ??? = com.tencent.mm.plugin.report.c.oRz;
            if (((wq)localObject2).tdF != 0) {
              break label1420;
            }
          }
          label1392:
          label1397:
          label1420:
          for (l1 = 9L;; l1 = 8L)
          {
            ((com.tencent.mm.plugin.report.c)???).a(403L, l1, 1L, false);
            com.tencent.mm.y.u.a(((com.tencent.mm.y.b.a)localObject3).BE(), new b.3(localb), true);
            break;
            ((wq)localObject2).tBI = 18;
            break label973;
            l1 = 1L;
            break label1101;
            ((wq)localObject2).tBI = 1;
            com.tencent.mm.plugin.report.c.oRz.a(403L, 3L, 1L, false);
            break label1175;
          }
          break label486;
          label1430:
          localObject3 = localObject2;
        }
      }
    }, false);
    this.hDu = new ai(com.tencent.mm.u.ap.vL().nIe.getLooper(), new ai.a()
    {
      private g hJw;
      
      public final boolean oQ()
      {
        GMTrace.i(411243118592L, 3064);
        com.tencent.mm.u.ap.yY();
        com.tencent.mm.u.c.wT().Ac("MicroMsg.GetChatRoomMsgService" + b.this.hashCode());
        if (b.this.hDp.isEmpty())
        {
          v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler queue maybe this time is null and return!");
          com.tencent.mm.u.ap.yY();
          com.tencent.mm.u.c.wT().Ad("MicroMsg.GetChatRoomMsgService" + b.this.hashCode());
          GMTrace.o(411243118592L, 3064);
          return false;
        }
        long l1 = com.tencent.mm.platformtools.u.NA();
        int i;
        int m;
        int j;
        label154:
        Object localObject1;
        boolean bool1;
        if (b.this.hqr)
        {
          i = 9;
          m = i + 1;
          v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler start maxCnt[%d]", new Object[] { Integer.valueOf(m) });
          j = 0;
          if (j >= m) {
            break label1414;
          }
          localObject1 = (b.b)b.this.hDp.peek();
          if (localObject1 != null) {
            break label359;
          }
          v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler queue maybe this time is null and break! currentListener[%s]", new Object[] { b.this.hJt });
          com.tencent.mm.u.ap.yY();
          com.tencent.mm.u.c.wT().Ad("MicroMsg.GetChatRoomMsgService" + b.this.hashCode());
          bool1 = false;
          if (b.this.hJt != null) {
            b.this.hJt.gd(0);
          }
          b.this.hDt.v(0L, 0L);
        }
        for (;;)
        {
          v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler onTimerExpired netSceneRunning:" + b.this.hqr + " ret:" + bool1 + " maxCnt:" + m + " take:" + (com.tencent.mm.platformtools.u.NA() - l1) + "ms");
          GMTrace.o(411243118592L, 3064);
          return bool1;
          i = 18;
          break;
          label359:
          Object localObject2 = ((b.b)localObject1).hJC;
          int n = ((LinkedList)localObject2).size();
          int i1 = n - 1;
          int i2 = ((b.b)localObject1).hDC;
          if (n <= i2)
          {
            b.this.hDp.poll();
            if (b.this.hDp.isEmpty())
            {
              b.d(new HashMap(b.this.hJu), ((b.b)localObject1).hJx);
              com.tencent.mm.u.ap.yY();
              com.tencent.mm.u.c.wT().Ad("MicroMsg.GetChatRoomMsgService" + b.this.hashCode());
              localObject1 = b.this.hJt;
              if (b.this.hJt == null) {}
              for (bool1 = false;; bool1 = b.this.hJt.Hs())
              {
                v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler resp proc fin gr.curIdx:%d size:%d and retList is empty break currentListener[%s], needCallBack[%b]", new Object[] { Integer.valueOf(i2), Integer.valueOf(n), localObject1, Boolean.valueOf(bool1) });
                bool1 = false;
                if (b.this.hJt != null) {
                  b.this.hJt.gd(0);
                }
                b.this.hDt.v(0L, 0L);
                break;
              }
            }
            v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler resp proc fin gr.curIdx:%d size:%d and retList is not empty continue next", new Object[] { Integer.valueOf(i2), Integer.valueOf(n) });
            j += 1;
            break label154;
          }
          localObject2 = (bu)((LinkedList)localObject2).get(i2);
          v.d("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process curIdx[%d] last[%d] dealFault[%b] MsgSeq[%d], CreateTime[%d], MsgType[%d]", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1), Boolean.valueOf(((b.b)localObject1).hJD), Integer.valueOf(((bu)localObject2).tdF), Integer.valueOf(((bu)localObject2).ofk), Integer.valueOf(((bu)localObject2).mrC) });
          boolean bool2 = false;
          int k = -1;
          Object localObject3;
          label799:
          label892:
          au localau;
          if ((((b.b)localObject1).hJD) && (i2 == i1))
          {
            com.tencent.mm.u.ap.yY();
            localObject3 = com.tencent.mm.u.c.wT().y(((b.b)localObject1).hJx, ((bu)localObject2).tdF);
            if (((ce)localObject3).field_msgId == 0L)
            {
              com.tencent.mm.u.ap.yY();
              localObject3 = com.tencent.mm.u.c.wW().Rl(((b.b)localObject1).hJx);
              if (localObject3 == null)
              {
                bool1 = true;
                i = -1;
                v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process fault[%b] curIdx[%d] last[%d], upFlag[%d]，MsgSeq[%d]", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i2), Integer.valueOf(i1), Integer.valueOf(((b.b)localObject1).hJB), Integer.valueOf(((bu)localObject2).tdF) });
                if (this.hJw == null) {
                  this.hJw = ((g)h.h(g.class));
                }
                localObject3 = this.hJw;
                if (((b.b)localObject1).hJB == 0) {
                  break label1364;
                }
                bool2 = true;
                ((g)localObject3).a(new d.a((bu)localObject2, true, bool1, bool2), new com.tencent.mm.plugin.bbom.n(true));
                if ((bool1) && (i == 0) && (n > 1) && (((b.b)localObject1).hJB == 0))
                {
                  com.tencent.mm.u.ap.yY();
                  localObject3 = com.tencent.mm.u.c.wT().y(((b.b)localObject1).hJx, ((bu)localObject2).tdF);
                  i = ((ce)localObject3).field_flag;
                  long l2 = ((ce)localObject3).field_createTime;
                  v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process check fault meet size[%d], seq[%d], flag[%d], creatTime[%d]", new Object[] { Integer.valueOf(n), Integer.valueOf(((bu)localObject2).tdF), Integer.valueOf(i), Long.valueOf(l2) });
                  if ((i & 0x4) == 0)
                  {
                    com.tencent.mm.u.ap.yY();
                    localau = com.tencent.mm.u.c.wT().y(((b.b)localObject1).hJx, ((bu)localObject2).tdF + 1);
                    if ((localau.field_msgId == 0L) || (localau.field_msgSeq != ((bu)localObject2).tdF + 1)) {
                      break label1370;
                    }
                    v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process check fault meet seq[%d], creatTime[%d], flag[%d]", new Object[] { Long.valueOf(localau.field_msgSeq), Long.valueOf(localau.field_createTime), Integer.valueOf(localau.field_flag) });
                    if ((localau.field_flag & 0x4) != 0)
                    {
                      ((au)localObject3).dF(((ce)localObject3).field_flag & 0xFFFFFFFE);
                      com.tencent.mm.u.ap.yY();
                      com.tencent.mm.u.c.wT().a(((ce)localObject3).field_msgId, (au)localObject3);
                      localau.dF(localau.field_flag & 0xFFFFFFFE);
                      com.tencent.mm.u.ap.yY();
                      com.tencent.mm.u.c.wT().a(localau.field_msgId, localau);
                      v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process check fault meet update succ!");
                      com.tencent.mm.plugin.report.c.oRz.a(403L, 34L, 1L, false);
                    }
                  }
                }
              }
            }
          }
          for (;;)
          {
            ((b.b)localObject1).hDC += 1;
            break;
            if ((((b.b)localObject1).hJB == 0) || (((aj)localObject3).field_firstUnDeliverSeq == ((bu)localObject2).tdF))
            {
              i = k;
              bool1 = bool2;
              if (((b.b)localObject1).hJB == 0)
              {
                i = k;
                bool1 = bool2;
                if (((aj)localObject3).field_lastSeq == ((bu)localObject2).tdF) {}
              }
            }
            else
            {
              bool1 = true;
              i = ((aj)localObject3).field_UnDeliverCount;
            }
            break label799;
            v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process existed curIdx == last[%d], MsgSeq[%d], flag[%d]", new Object[] { Integer.valueOf(i2), Long.valueOf(((ce)localObject3).field_msgSeq), Integer.valueOf(((ce)localObject3).field_flag) });
            bool1 = false;
            i = -1;
            break label799;
            label1364:
            bool2 = false;
            break label892;
            label1370:
            v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process check fault meet nextinfo is null[%b], id[%d], seq[%d]", new Object[] { Boolean.valueOf(false), Long.valueOf(localau.field_msgId), Long.valueOf(localau.field_msgSeq) });
          }
          label1414:
          bool1 = true;
        }
      }
    }, true);
    GMTrace.o(408692981760L, 3045);
  }
  
  private boolean b(a parama, c paramc)
  {
    GMTrace.i(409229852672L, 3049);
    if ((parama == null) || (paramc == null) || (com.tencent.mm.platformtools.u.mA(parama.hJx)) || (!parama.hJx.equals(paramc.Hr())))
    {
      GMTrace.o(409229852672L, 3049);
      return false;
    }
    v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr addChatRoomMsg info:%s", new Object[] { parama });
    synchronized (this.hJr)
    {
      LinkedList localLinkedList = (LinkedList)this.hJr.get(parama.hJx);
      if (localLinkedList == null)
      {
        localLinkedList = new LinkedList();
        v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr addChatRoomMsg new infos and add ret:%b, infos[%d], needGetInfosMap[%s]", new Object[] { Boolean.valueOf(localLinkedList.add(parama)), Integer.valueOf(localLinkedList.hashCode()), this.hJr });
        this.hJr.put(parama.hJx, localLinkedList);
        this.hJt = paramc;
        GMTrace.o(409229852672L, 3049);
        return true;
      }
      localLinkedList.addLast(parama);
      v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr addChatRoomMsg to infos first:%b, infos[%d], needGetInfosMap[%s]", new Object[] { Boolean.valueOf(false), Integer.valueOf(localLinkedList.hashCode()), this.hJr });
    }
  }
  
  public static void d(Map<Long, ao> paramMap, String paramString)
  {
    GMTrace.i(16009356378112L, 119279);
    if ((paramMap.size() == 0) || (com.tencent.mm.platformtools.u.mA(paramString)))
    {
      GMTrace.o(16009356378112L, 119279);
      return;
    }
    paramMap = paramMap.values().iterator();
    if (paramMap != null) {
      while (paramMap.hasNext())
      {
        Object localObject1 = (ao)paramMap.next();
        if ((localObject1 != null) && (paramString.equals(((ao)localObject1).field_fromUserName)))
        {
          com.tencent.mm.u.ap.yY();
          Object localObject2 = com.tencent.mm.u.c.wT().x(paramString, ((ao)localObject1).field_originSvrId);
          if (((ce)localObject2).field_msgId != 0L)
          {
            v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr dealSysCmdMsg msg id[%d], originsvrid[%d]", new Object[] { Long.valueOf(((ce)localObject2).field_msgId), Long.valueOf(((ce)localObject2).field_msgSvrId) });
            localObject2 = new bu();
            ((bu)localObject2).tdE = ((ao)localObject1).field_newMsgId;
            ((bu)localObject2).tdx = com.tencent.mm.platformtools.n.mw(((ao)localObject1).field_fromUserName);
            ((bu)localObject2).tdy = com.tencent.mm.platformtools.n.mw(((ao)localObject1).field_toUserName);
            ((bu)localObject2).ofk = ((int)((ao)localObject1).field_createTime);
            ((bu)localObject2).tdz = com.tencent.mm.platformtools.n.mw(((ao)localObject1).field_content);
            ((bu)localObject2).tdC = ((ao)localObject1).field_msgSource;
            ((bu)localObject2).tdF = ((ao)localObject1).field_msgSeq;
            int i = ((ao)localObject1).field_flag;
            ((bu)localObject2).mrC = 10002;
            com.tencent.mm.plugin.report.c.oRz.a(403L, 35L, 1L, false);
            localObject1 = com.tencent.mm.u.ap.getSysCmdMsgExtension();
            boolean bool1;
            label279:
            boolean bool2;
            if ((i & 0x2) != 0)
            {
              bool1 = true;
              if ((i & 0x1) == 0) {
                break label325;
              }
              bool2 = true;
              label288:
              if ((i & 0x4) == 0) {
                break label331;
              }
            }
            label325:
            label331:
            for (boolean bool3 = true;; bool3 = false)
            {
              ((bp)localObject1).b(new d.a((bu)localObject2, bool1, bool2, bool3));
              break;
              bool1 = false;
              break label279;
              bool2 = false;
              break label288;
            }
          }
        }
      }
    }
    GMTrace.o(16009356378112L, 119279);
  }
  
  public final void a(String paramString, l paraml)
  {
    GMTrace.i(408827199488L, 3046);
    if (!com.tencent.mm.platformtools.u.mA(paramString)) {
      try
      {
        long l = Long.valueOf(paramString).longValue();
        paramString = new ao();
        paramString.field_originSvrId = l;
        if (com.tencent.mm.u.ap.yY().xD().b(paramString, new String[0]))
        {
          this.hJu.put(Long.valueOf(l), paramString);
          v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr onNotifyChange put info systemRowid[%d], svrId[%d]", new Object[] { Long.valueOf(paramString.uvp), Long.valueOf(l) });
          GMTrace.o(408827199488L, 3046);
          return;
        }
        this.hJu.remove(Long.valueOf(l));
        v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr onNotifyChange remove info svrId[%d]", new Object[] { Long.valueOf(l) });
        GMTrace.o(408827199488L, 3046);
        return;
      }
      catch (Exception paramString)
      {
        v.printErrStackTrace("MicroMsg.GetChatRoomMsgService", paramString, "summerbadcr onNotifyChange:", new Object[0]);
      }
    }
    GMTrace.o(408827199488L, 3046);
  }
  
  public final boolean a(a parama)
  {
    GMTrace.i(409095634944L, 3048);
    if (parama.hJz != 0)
    {
      GMTrace.o(409095634944L, 3048);
      return false;
    }
    v.i("MicroMsg.GetChatRoomMsgService", "summerbadcr clearChatRoomMsg info:%s, stack[%s]", new Object[] { parama, com.tencent.mm.platformtools.u.ND() });
    if (this.hJs.add(parama))
    {
      this.hDt.v(0L, 0L);
      GMTrace.o(409095634944L, 3048);
      return true;
    }
    GMTrace.o(409095634944L, 3048);
    return false;
  }
  
  public final boolean a(a parama, c paramc)
  {
    GMTrace.i(408961417216L, 3047);
    if (b(parama, paramc))
    {
      this.hDt.v(0L, 0L);
      GMTrace.o(408961417216L, 3047);
      return true;
    }
    GMTrace.o(408961417216L, 3047);
    return false;
  }
  
  public static final class a
  {
    final int hJA;
    final int hJB;
    final String hJx;
    final int hJy;
    final int hJz;
    
    public a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      GMTrace.i(410840465408L, 3061);
      this.hJx = paramString;
      this.hJy = paramInt1;
      this.hJz = paramInt2;
      this.hJA = paramInt3;
      this.hJB = paramInt4;
      GMTrace.o(410840465408L, 3061);
    }
    
    public final String toString()
    {
      GMTrace.i(410974683136L, 3062);
      String str = "GetChatRoomMsgInfo hash[" + hashCode() + "], chatroomId[" + this.hJx + "], filterSeq[" + this.hJy + "], msgSeq[" + this.hJz + "], needCount[" + this.hJA + "], upDownFlag[" + this.hJB + "]";
      GMTrace.o(410974683136L, 3062);
      return str;
    }
  }
  
  final class b
  {
    int hDC;
    int hJB;
    LinkedList<bu> hJC;
    boolean hJD;
    String hJx;
    
    b()
    {
      GMTrace.i(412316860416L, 3072);
      this.hJC = new LinkedList();
      this.hDC = 0;
      this.hJB = 0;
      this.hJD = true;
      GMTrace.o(412316860416L, 3072);
    }
  }
  
  public static abstract interface c
  {
    public abstract String Hr();
    
    public abstract boolean Hs();
    
    public abstract void gd(int paramInt);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelmulti/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */