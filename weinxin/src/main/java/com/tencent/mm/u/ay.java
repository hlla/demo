package com.tencent.mm.u;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.ix;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.d.c;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class ay
{
  public static int L(long paramLong)
  {
    GMTrace.i(13288628813824L, 99008);
    au localau = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cA(paramLong);
    if (localau.field_msgId != paramLong)
    {
      GMTrace.o(13288628813824L, 99008);
      return 0;
    }
    j(localau);
    int i = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cB(paramLong);
    GMTrace.o(13288628813824L, 99008);
    return i;
  }
  
  public static String M(String paramString1, String paramString2)
  {
    GMTrace.i(13287286636544L, 98998);
    if (bf.mA(paramString1))
    {
      GMTrace.o(13287286636544L, 98998);
      return null;
    }
    if (bf.mA(paramString2))
    {
      GMTrace.o(13287286636544L, 98998);
      return paramString1;
    }
    paramString1 = paramString2 + ": " + paramString1;
    GMTrace.o(13287286636544L, 98998);
    return paramString1;
  }
  
  public static int a(String paramString, final a parama)
  {
    GMTrace.i(13289031467008L, 99011);
    v.d("MicroMsg.MsgInfoStorageLogic", "deleteMsgByTalker %s", new Object[] { paramString });
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vL().D(new Runnable()
    {
      final int hmo;
      final int hmp;
      final int hmq;
      int hmr;
      
      public final void run()
      {
        GMTrace.i(13264335405056L, 98827);
        long l5 = bf.NA();
        Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Ag(this.gTs);
        long l1;
        long l3;
        if (localObject1 == null)
        {
          l1 = Long.MAX_VALUE;
          l3 = 0L;
          i = 0;
          if ((this.hmr < 200) && (this.hmr > 30)) {
            if (l3 <= 500L) {
              break label225;
            }
          }
        }
        long l6;
        long l2;
        label225:
        for (int j = this.hmr - 5;; j = this.hmr + 5)
        {
          this.hmr = j;
          l6 = bf.NA();
          localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().f(this.gTs, this.hmr, l1);
          l3 = 0L;
          l2 = 0L;
          while ((((Cursor)localObject1).moveToNext()) && ((parama == null) || (!parama.zs())))
          {
            localObject2 = new au();
            ((au)localObject2).b((Cursor)localObject1);
            l4 = l3;
            if (l3 < ((ce)localObject2).field_createTime) {
              l4 = ((ce)localObject2).field_createTime;
            }
            ay.j((au)localObject2);
            l2 = 1L + l2;
            l3 = l4;
          }
          l1 = ((ce)localObject1).field_createTime;
          break;
        }
        ((Cursor)localObject1).close();
        long l7 = bf.NA();
        if ((l3 > 0L) && (l2 > 0L)) {
          ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().F(this.gTs, l3);
        }
        int i = (int)(i + l2);
        long l8 = bf.NA();
        long l4 = l8 - l6;
        Object localObject2 = bf.Qi(this.gTs);
        if (parama == null) {}
        for (localObject1 = "null";; localObject1 = Boolean.valueOf(parama.zs()))
        {
          v.i("MicroMsg.MsgInfoStorageLogic", "deleteMsgByTalker:%s iDelMsg:%s delCnt:%d curCnt:%d msgTimeDiff:%d(%d) run:[%d,%d,%d](%d)", new Object[] { localObject2, localObject1, Integer.valueOf(i), Long.valueOf(l2), Long.valueOf(l1 - l3), Long.valueOf(l1), Long.valueOf(l8 - l7), Long.valueOf(l8 - l6), Long.valueOf(l8 - l5), Integer.valueOf(this.hmr) });
          l3 = l4;
          if (l2 > 0L) {
            break;
          }
          ae.v(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(13266751324160L, 98845);
              if (ay.1.this.hkT != null) {
                ay.1.this.hkT.zr();
              }
              GMTrace.o(13266751324160L, 98845);
            }
          });
          GMTrace.o(13264335405056L, 98827);
          return;
        }
      }
      
      public final String toString()
      {
        GMTrace.i(13264469622784L, 98828);
        String str = super.toString() + "|deleteMsgByTalker";
        GMTrace.o(13264469622784L, 98828);
        return str;
      }
    });
    GMTrace.o(13289031467008L, 99011);
    return 0;
  }
  
  public static long a(String paramString, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    GMTrace.i(13290239426560L, 99020);
    long l3 = paramLong1 * 1000L;
    paramLong1 = 0L;
    long l1 = -1L;
    au localau = null;
    long l2 = paramLong1;
    if (paramString != null)
    {
      localau = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Ag(paramString);
      if (localau != null) {
        paramLong1 = localau.field_createTime;
      }
      l1 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().AA(paramString);
      l2 = paramLong1;
    }
    if (l1 == l2)
    {
      if (l3 == l2)
      {
        GMTrace.o(13290239426560L, 99020);
        return l3 + 1L;
      }
      GMTrace.o(13290239426560L, 99020);
      return l3;
    }
    if (l1 < l2)
    {
      if (l3 == l1)
      {
        GMTrace.o(13290239426560L, 99020);
        return l3 - 1L;
      }
      if (l3 == l2)
      {
        GMTrace.o(13290239426560L, 99020);
        return l3 + 1L;
      }
      if ((paramBoolean) || (paramLong2 == 0L) || (l3 > l2))
      {
        GMTrace.o(13290239426560L, 99020);
        return l3;
      }
      paramString = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().z(paramString, l3);
      if ((paramString.field_msgSeq == 0L) || (paramString.field_msgSeq == paramLong2)) {
        break label460;
      }
      if (paramString.field_msgSeq < paramLong2)
      {
        paramLong1 = 1L + l3;
        v.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime 1 seq[%d, %d] need fix serverMillTime[%d]", new Object[] { Long.valueOf(paramString.field_msgSeq), Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
        l1 = paramLong1;
        if (paramLong1 == l2)
        {
          l1 = paramLong1;
          if (localau != null)
          {
            l1 = paramLong1;
            if (localau.field_msgSeq != 0L)
            {
              if (localau.field_msgSeq >= paramLong2) {
                break label405;
              }
              l1 = 1L + l2;
              label348:
              v.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime 2 seq[%d, %d] need fix serverMillTime[%d]", new Object[] { Long.valueOf(localau.field_msgSeq), Long.valueOf(paramLong2), Long.valueOf(l1) });
            }
          }
        }
      }
    }
    for (;;)
    {
      GMTrace.o(13290239426560L, 99020);
      return l1;
      paramLong1 = l3 - 1L;
      break;
      label405:
      l1 = l2 - 1L;
      break label348;
      v.w("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvMsgCreateTime first > last [%d > %d], ret serverMillTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
      GMTrace.o(13290239426560L, 99020);
      return l3;
      label460:
      l1 = l3;
    }
  }
  
  public static void a(au paramau, d.a parama)
  {
    GMTrace.i(13289970991104L, 99018);
    if ((paramau == null) || (parama == null) || (parama.hsc == null))
    {
      v.e("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvMsgWithAddMsgInfo error input is null, stack[%s]", new Object[] { bf.bJP() });
      GMTrace.o(13289970991104L, 99018);
      return;
    }
    if (paramau.field_msgSvrId != parama.hsc.tdE)
    {
      GMTrace.o(13289970991104L, 99018);
      return;
    }
    bu localbu = parama.hsc;
    if ((paramau.field_isSend != 0) && (localbu.tdF == 0))
    {
      GMTrace.o(13289970991104L, 99018);
      return;
    }
    if ((paramau.field_msgSeq == 0L) && (localbu.tdF != 0)) {
      paramau.B(localbu.tdF);
    }
    int i = paramau.field_flag;
    if (parama.hsd)
    {
      i |= 0x2;
      if (!parama.hse) {
        break label233;
      }
      i |= 0x1;
      label153:
      if (!parama.hsf) {
        break label241;
      }
      i |= 0x4;
    }
    for (;;)
    {
      paramau.dF(i);
      if ((paramau.field_msgId == 0L) && (parama.hsd)) {
        paramau.z(a(paramau.field_talker, parama.hsc.ofk, parama.hsf, parama.hsc.tdF));
      }
      GMTrace.o(13289970991104L, 99018);
      return;
      i &= 0xFFFFFFFD;
      break;
      label233:
      i &= 0xFFFFFFFE;
      break label153;
      label241:
      i &= 0xFFFFFFFB;
    }
  }
  
  public static void a(a parama)
  {
    GMTrace.i(13289165684736L, 99012);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(13267019759616L, 98847);
        if ((this.hkT == null) || (!this.hkT.zs()))
        {
          ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().bLs();
          if ((this.hkT == null) || (!this.hkT.zs()))
          {
            ay.zp();
            if ((this.hkT == null) || (!this.hkT.zs()))
            {
              ay.zq();
              if ((this.hkT == null) || (!this.hkT.zs()))
              {
                ay.zo();
                if ((this.hkT == null) || (!this.hkT.zs()))
                {
                  List localList = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Aj("message");
                  if (localList != null)
                  {
                    int i = 0;
                    while (i < localList.size())
                    {
                      ay.j((au)localList.get(i));
                      i += 1;
                    }
                  }
                  ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Al("message");
                }
              }
            }
          }
        }
        if (this.hkT != null) {
          ae.v(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(13287018201088L, 98996);
              ay.2.this.hkT.zr();
              GMTrace.o(13287018201088L, 98996);
            }
          });
        }
        GMTrace.o(13267019759616L, 98847);
      }
      
      public final String toString()
      {
        GMTrace.i(13267153977344L, 98848);
        String str = super.toString() + "|deleteAllMsg";
        GMTrace.o(13267153977344L, 98848);
        return str;
      }
    });
    GMTrace.o(13289165684736L, 99012);
  }
  
  public static int c(d.a parama)
  {
    GMTrace.i(13290105208832L, 99019);
    int j = 0;
    if (parama.hsd) {
      j = 2;
    }
    int i = j;
    if (parama.hse) {
      i = j | 0x1;
    }
    j = i;
    if (parama.hsf) {
      j = i | 0x4;
    }
    GMTrace.o(13290105208832L, 99019);
    return j;
  }
  
  public static boolean fc(int paramInt)
  {
    GMTrace.i(13287957725184L, 99003);
    switch (paramInt)
    {
    case 25: 
    default: 
      GMTrace.o(13287957725184L, 99003);
      return false;
    }
    GMTrace.o(13287957725184L, 99003);
    return true;
  }
  
  public static int gh(String paramString)
  {
    GMTrace.i(13287420854272L, 98999);
    if (paramString == null)
    {
      v.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos text is null]");
      GMTrace.o(13287420854272L, 98999);
      return -1;
    }
    if (paramString.length() <= 0)
    {
      v.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos length < 0]");
      GMTrace.o(13287420854272L, 98999);
      return -1;
    }
    if (paramString.startsWith("~SEMI_XML~"))
    {
      v.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos startsWith(SemiXml.MAGIC_HEAD)]");
      GMTrace.o(13287420854272L, 98999);
      return -1;
    }
    int i = paramString.indexOf(':');
    if ((i != -1) && (paramString.substring(0, i).contains("<")))
    {
      v.e("MicroMsg.MsgInfoStorageLogic", "dz[reject illegal character]");
      GMTrace.o(13287420854272L, 98999);
      return -1;
    }
    GMTrace.o(13287420854272L, 98999);
    return i;
  }
  
  public static String gi(String paramString)
  {
    GMTrace.i(13287555072000L, 99000);
    int i = gh(paramString);
    if (i == -1)
    {
      GMTrace.o(13287555072000L, 99000);
      return null;
    }
    paramString = paramString.substring(0, i);
    GMTrace.o(13287555072000L, 99000);
    return paramString;
  }
  
  public static String gj(String paramString)
  {
    GMTrace.i(13287689289728L, 99001);
    int i = gh(paramString);
    if (i == -1)
    {
      GMTrace.o(13287689289728L, 99001);
      return paramString;
    }
    if (i + 2 >= paramString.length())
    {
      GMTrace.o(13287689289728L, 99001);
      return paramString;
    }
    paramString = paramString.substring(i + 2);
    GMTrace.o(13287689289728L, 99001);
    return paramString;
  }
  
  public static long gk(String paramString)
  {
    GMTrace.i(13288091942912L, 99004);
    long l = zn();
    v.i("MicroMsg.MsgInfoStorageLogic", "[oneliang] fix send msg create time, after fix, now is :%s", new Object[] { Long.valueOf(l) });
    if (paramString != null)
    {
      paramString = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Ag(paramString);
      if (paramString != null)
      {
        v.i("MicroMsg.MsgInfoStorageLogic", "[oneliang] fix send msg create time, before return, msg id:%s, now is :%s", new Object[] { Long.valueOf(paramString.field_msgId), Long.valueOf(l) });
        if (paramString.field_createTime + 1L > l)
        {
          l = paramString.field_createTime;
          GMTrace.o(13288091942912L, 99004);
          return l + 1L;
        }
      }
    }
    GMTrace.o(13288091942912L, 99004);
    return l;
  }
  
  public static int gl(String paramString)
  {
    GMTrace.i(13288897249280L, 99010);
    int i = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Am(paramString);
    GMTrace.o(13288897249280L, 99010);
    return i;
  }
  
  public static b gm(String paramString)
  {
    GMTrace.i(13289702555648L, 99016);
    if (bf.mA(paramString))
    {
      GMTrace.o(13289702555648L, 99016);
      return null;
    }
    try
    {
      paramString = bg.q(paramString, "msgsource");
      if (paramString != null)
      {
        boolean bool = paramString.isEmpty();
        if (!bool) {}
      }
      else
      {
        GMTrace.o(13289702555648L, 99016);
        return null;
      }
      b localb = new b();
      localb.hmw = ((String)paramString.get(".msgsource.bizmsg.msgcluster"));
      localb.hmy = ((String)paramString.get(".msgsource.kf.kf_worker"));
      localb.hmx = bf.mz((String)paramString.get(".msgsource.bizmsg.bizclientmsgid"));
      localb.hmA = bf.mz((String)paramString.get(".msgsource.enterprise_info.qy_msg_type"));
      localb.hmB = bf.mz((String)paramString.get(".msgsource.enterprise_info.bizchat_id"));
      localb.hmC = bf.mz((String)paramString.get(".msgsource.enterprise_info.bizchat_ver"));
      localb.userId = bf.mz((String)paramString.get(".msgsource.enterprise_info.user_id"));
      localb.hmD = bf.mz((String)paramString.get(".msgsource.enterprise_info.user_nickname"));
      localb.hmE = bf.mz((String)paramString.get(".msgsource.enterprise_info.sync_from_qy_im"));
      localb.hmz = ((String)paramString.get(".msgsource.strangerantispamticket.$ticket"));
      localb.scene = bf.getInt((String)paramString.get(".msgsource.strangerantispamticket.$scene"), 0);
      localb.hmF = ((String)paramString.get(".msgsource.NotAutoDownloadRange"));
      localb.hmG = bf.getInt((String)paramString.get(".msgsource.DownloadLimitKbps"), 0);
      localb.hmH = bf.getInt((String)paramString.get(".msgsource.videopreloadlen"), 0);
      localb.hmI = bf.getInt((String)paramString.get(".msgsource.PreDownload"), 0);
      localb.hmJ = bf.getInt((String)paramString.get(".msgsource.PreDownloadNetType"), 0);
      localb.hmK = ((String)paramString.get(".msgsource.NoPreDownloadRange"));
      GMTrace.o(13289702555648L, 99016);
      return localb;
    }
    catch (Exception paramString)
    {
      v.e("MicroMsg.MsgInfoStorageLogic", "exception:%s", new Object[] { bf.g(paramString) });
      v.e("MicroMsg.MsgInfoStorageLogic", "Exception in getMsgSourceValue, %s", new Object[] { paramString.getMessage() });
      GMTrace.o(13289702555648L, 99016);
    }
    return null;
  }
  
  public static String gn(String paramString)
  {
    GMTrace.i(13289836773376L, 99017);
    paramString = gm(paramString);
    if (paramString == null)
    {
      GMTrace.o(13289836773376L, 99017);
      return null;
    }
    paramString = paramString.hmy;
    GMTrace.o(13289836773376L, 99017);
    return paramString;
  }
  
  public static long i(au paramau)
  {
    GMTrace.i(13287823507456L, 99002);
    x localx = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramau.field_talker);
    if ((localx == null) || ((int)localx.gTG == 0))
    {
      localx = new x(paramau.field_talker);
      localx.setType(2);
      ix localix = new ix();
      localix.fOA.fOB = localx;
      com.tencent.mm.sdk.b.a.uql.m(localix);
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().R(localx);
    }
    long l = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().L(paramau);
    GMTrace.o(13287823507456L, 99002);
    return l;
  }
  
  public static long i(String paramString, long paramLong)
  {
    GMTrace.i(13288226160640L, 99005);
    if (paramString != null)
    {
      paramString = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Ag(paramString);
      if (paramString == null) {}
    }
    for (long l = paramString.field_createTime + 1L;; l = 0L)
    {
      if (l > paramLong * 1000L)
      {
        GMTrace.o(13288226160640L, 99005);
        return l;
      }
      GMTrace.o(13288226160640L, 99005);
      return paramLong * 1000L;
    }
  }
  
  public static int j(String paramString, long paramLong)
  {
    GMTrace.i(13288763031552L, 99009);
    au localau = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().x(paramString, paramLong);
    if (localau.field_msgSvrId != paramLong)
    {
      GMTrace.o(13288763031552L, 99009);
      return 0;
    }
    j(localau);
    int i = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().E(paramString, paramLong);
    GMTrace.o(13288763031552L, 99009);
    return i;
  }
  
  public static void j(au paramau)
  {
    GMTrace.i(13288360378368L, 99006);
    if (paramau == null)
    {
      GMTrace.o(13288360378368L, 99006);
      return;
    }
    int i = paramau.field_type;
    switch (i)
    {
    }
    for (;;)
    {
      d locald = d.c.aB(Integer.valueOf(i));
      if (locald != null) {
        locald.h(paramau);
      }
      GMTrace.o(13288360378368L, 99006);
      return;
      i = 49;
    }
  }
  
  public static void v(List<Long> paramList)
  {
    GMTrace.i(13288494596096L, 99007);
    if (paramList.size() == 0)
    {
      GMTrace.o(13288494596096L, 99007);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      L(((Long)paramList.next()).longValue());
    }
    GMTrace.o(13288494596096L, 99007);
  }
  
  public static long zn()
  {
    GMTrace.i(15229954031616L, 113472);
    long l1 = System.currentTimeMillis();
    v.i("MicroMsg.MsgInfoStorageLogic", "[oneliang] fix send msg create time, before fix, now is :%s", new Object[] { Long.valueOf(l1) });
    Object localObject = aa.getContext().getSharedPreferences("system_config_prefs", 4);
    int i = ((SharedPreferences)localObject).getInt("client_server_diff_time_enable", 0);
    int j = ((SharedPreferences)localObject).getInt("client_server_diff_time_interval", 0);
    if ((i <= 0) || (j <= 0))
    {
      GMTrace.o(15229954031616L, 113472);
      return l1;
    }
    com.tencent.mm.kernel.h.vJ();
    localObject = com.tencent.mm.kernel.h.vI().vr().get(w.a.uFA, null);
    if (localObject == null)
    {
      GMTrace.o(15229954031616L, 113472);
      return l1;
    }
    long l2 = bf.getLong(localObject.toString(), 0L);
    if (Math.abs(l2 / 1000L) > j)
    {
      GMTrace.o(15229954031616L, 113472);
      return l1 - l2;
    }
    GMTrace.o(15229954031616L, 113472);
    return l1;
  }
  
  public static void zo()
  {
    GMTrace.i(13289299902464L, 99013);
    List localList = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Aj("bottlemessage");
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        j((au)localList.get(i));
        i += 1;
      }
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Al("bottlemessage");
    GMTrace.o(13289299902464L, 99013);
  }
  
  public static void zp()
  {
    GMTrace.i(13289434120192L, 99014);
    List localList = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Aj("qmessage");
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        j((au)localList.get(i));
        i += 1;
      }
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Al("qmessage");
    GMTrace.o(13289434120192L, 99014);
  }
  
  public static void zq()
  {
    GMTrace.i(13289568337920L, 99015);
    List localList = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Aj("tmessage");
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        j((au)localList.get(i));
        i += 1;
      }
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Al("tmessage");
    GMTrace.o(13289568337920L, 99015);
  }
  
  public static abstract interface a
  {
    public abstract void zr();
    
    public abstract boolean zs();
  }
  
  public static final class b
  {
    public String hmA;
    public String hmB;
    public String hmC;
    public String hmD;
    public String hmE;
    public String hmF;
    public int hmG;
    public int hmH;
    public int hmI;
    public int hmJ;
    public String hmK;
    public String hmw;
    public String hmx;
    public String hmy;
    public String hmz;
    public int scene;
    public String userId;
    
    public b()
    {
      GMTrace.i(13266482888704L, 98843);
      this.scene = 0;
      GMTrace.o(13266482888704L, 98843);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */