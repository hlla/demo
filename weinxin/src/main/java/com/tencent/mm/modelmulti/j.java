package com.tencent.mm.modelmulti;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.nw;
import com.tencent.mm.e.a.ny;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelsimple.ai;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.protocal.c.aln;
import com.tencent.mm.protocal.c.alo;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.axt;
import com.tencent.mm.protocal.c.axu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.aj;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k.b;
import com.tencent.wcdb.database.SQLiteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public final class j
  extends com.tencent.mm.y.k
  implements com.tencent.mm.network.j
{
  private static final List<aj> hKo;
  public long fGD;
  private b gUq;
  public com.tencent.mm.y.e gUt;
  private final List<au> hKp;
  public int hKq;
  public boolean hKr;
  public final List<au> hKs;
  private au hKt;
  public com.tencent.mm.plugin.messenger.foundation.a.k hKu;
  
  static
  {
    GMTrace.i(13249034584064L, 98713);
    hKo = new ArrayList();
    GMTrace.o(13249034584064L, 98713);
  }
  
  public j()
  {
    GMTrace.i(13245813358592L, 98689);
    this.hKp = new LinkedList();
    this.hKq = 3;
    this.hKr = false;
    this.hKs = new ArrayList();
    this.hKt = null;
    this.hKu = null;
    v.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[] { bf.bJP() });
    v.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
    GMTrace.o(13245813358592L, 98689);
  }
  
  public j(long paramLong)
  {
    GMTrace.i(13245679140864L, 98688);
    this.hKp = new LinkedList();
    this.hKq = 3;
    this.hKr = false;
    this.hKs = new ArrayList();
    this.hKt = null;
    this.hKu = null;
    v.i("MicroMsg.NetSceneSendMsg", "resend msg , local id = " + paramLong);
    this.fGD = paramLong;
    this.hKt = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cA(paramLong);
    if (this.hKt == null) {
      v.e("MicroMsg.NetSceneSendMsg", "resend msg , msg is null localid:%d", new Object[] { Long.valueOf(paramLong) });
    }
    GMTrace.o(13245679140864L, 98688);
  }
  
  public j(String paramString1, String paramString2, int paramInt)
  {
    GMTrace.i(13245544923136L, 98687);
    this.hKp = new LinkedList();
    this.hKq = 3;
    this.hKr = false;
    this.hKs = new ArrayList();
    this.hKt = null;
    this.hKu = null;
    v.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[] { bf.bJP() });
    au localau;
    if (!bf.mA(paramString1))
    {
      localau = new au();
      localau.dv(1);
      localau.cH(paramString1);
      localau.z(ay.gk(paramString1));
      localau.dw(1);
      localau.setContent(paramString2);
      localau.setType(paramInt);
      paramString1 = ((o)com.tencent.mm.kernel.h.h(o.class)).s(localau);
      if (!bf.mA(paramString1))
      {
        localau.cN(paramString1);
        v.d("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", new Object[] { localau.gxv });
      }
    }
    for (;;)
    {
      try
      {
        this.fGD = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().b(localau, true);
        if (this.fGD == -1L) {
          com.tencent.mm.plugin.report.c.oRz.a(111L, 255L, 1L, false);
        }
        if (this.fGD != -1L)
        {
          bool = true;
          Assert.assertTrue(bool);
          v.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.fGD);
          GMTrace.o(13245544923136L, 98687);
          return;
        }
      }
      catch (SQLiteException paramString1)
      {
        com.tencent.mm.plugin.report.c.oRz.a(111L, 255L, 1L, false);
        throw paramString1;
      }
      boolean bool = false;
    }
  }
  
  public j(String paramString1, String paramString2, int paramInt1, int paramInt2, Object paramObject)
  {
    GMTrace.i(14607452209152L, 108834);
    this.hKp = new LinkedList();
    this.hKq = 3;
    this.hKr = false;
    this.hKs = new ArrayList();
    this.hKt = null;
    this.hKu = null;
    v.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[] { bf.bJP() });
    au localau;
    if (!bf.mA(paramString1))
    {
      localau = new au();
      localau.dv(1);
      localau.cH(paramString1);
      localau.z(ay.gk(paramString1));
      localau.dw(1);
      localau.setContent(paramString2);
      localau.setType(paramInt1);
      paramString1 = a(((o)com.tencent.mm.kernel.h.h(o.class)).s(localau), paramObject, paramInt2);
      if (!bf.mA(paramString1))
      {
        localau.cN(paramString1);
        v.d("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", new Object[] { localau.gxv });
      }
    }
    for (;;)
    {
      try
      {
        this.fGD = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().b(localau, true);
        if (this.fGD == -1L) {
          com.tencent.mm.plugin.report.c.oRz.a(111L, 255L, 1L, false);
        }
        if (this.fGD != -1L)
        {
          bool = true;
          Assert.assertTrue(bool);
          v.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.fGD);
          GMTrace.o(14607452209152L, 108834);
          return;
        }
      }
      catch (SQLiteException paramString1)
      {
        com.tencent.mm.plugin.report.c.oRz.a(111L, 255L, 1L, false);
        throw paramString1;
      }
      boolean bool = false;
    }
  }
  
  private void Ht()
  {
    GMTrace.i(13247423971328L, 98701);
    int i = 0;
    while (i < this.hKp.size())
    {
      gf(i);
      i += 1;
    }
    GMTrace.o(13247423971328L, 98701);
  }
  
  private static String a(String paramString, Object paramObject, int paramInt)
  {
    GMTrace.i(14607586426880L, 108835);
    if (paramObject == null) {}
    for (boolean bool = true;; bool = false)
    {
      v.i("MicroMsg.NetSceneSendMsg", "[mergeMsgSource] rawSource:%s args is null:%s flag:%s", new Object[] { paramString, Boolean.valueOf(bool), Integer.valueOf(paramInt) });
      if ((bf.mA(paramString)) || (paramString.startsWith("<msgsource>"))) {
        break;
      }
      v.w("MicroMsg.NetSceneSendMsg", "[mergeMsgSource] WTF the msgsource is right? %s", new Object[] { paramString });
      GMTrace.o(14607586426880L, 108835);
      return paramString;
    }
    if ((paramInt == 291) && ((paramObject instanceof HashMap)))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      if (bf.mA(paramString)) {
        localStringBuffer.append("<msgsource>");
      }
      paramObject = ((HashMap)paramObject).entrySet().iterator();
      while (((Iterator)paramObject).hasNext())
      {
        Object localObject = (Map.Entry)((Iterator)paramObject).next();
        String str = (String)((Map.Entry)localObject).getValue();
        localObject = (String)((Map.Entry)localObject).getKey();
        if ((bf.mA(str)) || (bf.mA((String)localObject)))
        {
          v.w("MicroMsg.NetSceneSendMsg", "%s %s", new Object[] { localObject, str });
        }
        else
        {
          localStringBuffer.append("<").append((String)localObject).append(">");
          localStringBuffer.append(str);
          localStringBuffer.append("</").append((String)localObject).append(">");
        }
      }
      if (bf.mA(paramString))
      {
        localStringBuffer.append("</msgsource>");
        paramString = localStringBuffer.toString();
        GMTrace.o(14607586426880L, 108835);
        return paramString;
      }
      paramString = paramString.replace("<msgsource>", "<msgsource>" + localStringBuffer.toString());
      GMTrace.o(14607586426880L, 108835);
      return paramString;
    }
    GMTrace.o(14607586426880L, 108835);
    return paramString;
  }
  
  public static void a(aj paramaj)
  {
    GMTrace.i(13247289753600L, 98700);
    hKo.remove(paramaj);
    GMTrace.o(13247289753600L, 98700);
  }
  
  private void ge(int paramInt)
  {
    GMTrace.i(13246752882688L, 98696);
    if (this.hKp == null)
    {
      v.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, sendingList is null");
      GMTrace.o(13246752882688L, 98696);
      return;
    }
    if ((paramInt >= this.hKp.size()) || (paramInt < 0))
    {
      v.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, index:%d, sendingList.size:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.hKp.size()) });
      GMTrace.o(13246752882688L, 98696);
      return;
    }
    q((au)this.hKp.get(paramInt));
    GMTrace.o(13246752882688L, 98696);
  }
  
  private void gf(int paramInt)
  {
    GMTrace.i(13247558189056L, 98702);
    au localau = (au)this.hKp.get(paramInt);
    v.d("MicroMsg.NetSceneSendMsg", "markMsgFailed for id:%d", new Object[] { Long.valueOf(localau.field_msgId) });
    r(localau);
    GMTrace.o(13247558189056L, 98702);
  }
  
  static void q(au paramau)
  {
    GMTrace.i(13246887100416L, 98697);
    nw localnw = new nw();
    localnw.fUS.fCQ = paramau;
    a.uql.m(localnw);
    v.d("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent for msgId:%d", new Object[] { Long.valueOf(paramau.field_msgId) });
    GMTrace.o(13246887100416L, 98697);
  }
  
  static void r(au paramau)
  {
    GMTrace.i(13247692406784L, 98703);
    paramau.dv(5);
    com.tencent.mm.plugin.report.c.oRz.a(111L, 30L, 1L, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().a(paramau.field_msgId, paramau);
    Iterator localIterator = hKo.iterator();
    while (localIterator.hasNext())
    {
      aj localaj = (aj)localIterator.next();
      String str1 = paramau.field_talker;
      String str2 = paramau.field_content;
      localaj.ge(str1);
    }
    GMTrace.o(13247692406784L, 98703);
  }
  
  public final boolean BI()
  {
    GMTrace.i(13245947576320L, 98690);
    GMTrace.o(13245947576320L, 98690);
    return true;
  }
  
  public final boolean BJ()
  {
    GMTrace.i(13246216011776L, 98692);
    boolean bool = super.BJ();
    if (bool) {
      com.tencent.mm.plugin.report.c.oRz.a(111L, 254L, 1L, false);
    }
    GMTrace.o(13246216011776L, 98692);
    return bool;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(13246484447232L, 98694);
    this.gUt = parame1;
    parame1 = new b.a();
    parame1.hrV = new axt();
    parame1.hrW = new axu();
    parame1.uri = "/cgi-bin/micromsg-bin/newsendmsg";
    parame1.hrU = 522;
    parame1.hrX = 237;
    parame1.hrY = 1000000237;
    this.gUq = parame1.BE();
    axt localaxt = (axt)this.gUq.hrS.hsa;
    if (this.hKt == null) {
      parame1 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().aJX();
    }
    while (parame1.size() == 0)
    {
      v.w("MicroMsg.NetSceneSendMsg", "no sending message");
      GMTrace.o(13246484447232L, 98694);
      return -2;
      if (this.hKt.field_status != 5) {
        v.w("MicroMsg.NetSceneSendMsg", "msg:%d status:%d should not be resend !", new Object[] { Long.valueOf(this.hKt.field_msgId), Integer.valueOf(this.hKt.field_status) });
      }
      this.hKt.dv(1);
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().a(this.fGD, this.hKt);
      parame1 = new ArrayList();
      parame1.add(this.hKt);
      this.hKt = null;
    }
    this.hKp.clear();
    int i = 0;
    while (i < parame1.size())
    {
      au localau = (au)parame1.get(i);
      if (localau.field_isSend == 1)
      {
        aln localaln = new aln();
        localaln.tdy = new avu().OU(localau.field_talker);
        localaln.ofk = ((int)(localau.field_createTime / 1000L));
        localaln.jMq = localau.field_type;
        localaln.oog = localau.field_content;
        localaln.tOK = com.tencent.mm.u.k.f(m.xL(), localau.field_createTime).hashCode();
        if (this.hKu == null) {
          this.hKu = ((o)com.tencent.mm.kernel.h.h(o.class)).Hx();
        }
        v.i("MicroMsg.NetSceneSendMsg", "using message source assembler %s", new Object[] { this.hKu });
        this.hKu.a(localaln, localau);
        v.i("MicroMsg.NetSceneSendMsg", "reqCmd.MsgSource:%s", new Object[] { localaln.tdC });
        localaxt.jLs.add(localaln);
        localaxt.jLr = localaxt.jLs.size();
        this.hKp.add(localau);
      }
      i += 1;
    }
    i = a(parame, this.gUq, this);
    if (i < 0)
    {
      v.i("MicroMsg.NetSceneSendMsg", "mark all failed. do scene %d", new Object[] { Integer.valueOf(i) });
      Ht();
    }
    GMTrace.o(13246484447232L, 98694);
    return i;
  }
  
  protected final int a(p paramp)
  {
    GMTrace.i(13246350229504L, 98693);
    if (this.hKp.size() > 0)
    {
      i = k.b.hsC;
      GMTrace.o(13246350229504L, 98693);
      return i;
    }
    int i = k.b.hsD;
    GMTrace.o(13246350229504L, 98693);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, final String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(13247021318144L, 98698);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.c.oRz.a(111L, paramInt2 + 40, 1L, true);
      com.tencent.mm.plugin.report.c.oRz.a(111L, 253L, 1L, false);
      v.i("MicroMsg.NetSceneSendMsg", "mark all failed. onGYNetEnd. errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      Ht();
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      paramInt1 = 0;
      while (paramInt1 < this.hKp.size())
      {
        ge(paramInt1);
        paramInt1 += 1;
      }
      v.d("MicroMsg.NetSceneSendMsg", "send fail, continue send SENDING msg");
      jQ(paramString);
      GMTrace.o(13247021318144L, 98698);
      return;
    }
    paramp = ((axu)this.gUq.hrT.hsa).jLs;
    paramArrayOfByte = new ArrayList();
    if (this.hKp.size() == paramp.size())
    {
      paramInt1 = 0;
      if (paramInt1 < paramp.size())
      {
        Object localObject = (alo)paramp.get(paramInt1);
        if ((((alo)localObject).tgr != 0) || (r.ijj))
        {
          com.tencent.mm.plugin.report.c.oRz.a(111L, 252L, 1L, false);
          if ((((alo)localObject).tgr == -49) || (r.ijj))
          {
            v.i("MicroMsg.NetSceneSendMsg", "summerdktext send msg failed: item ret code[%d], index[%d], testVerifyPsw[%b], retryVerifyCount[%d]", new Object[] { Integer.valueOf(((alo)localObject).tgr), Integer.valueOf(paramInt1), Boolean.valueOf(r.ijj), Integer.valueOf(this.hKq) });
            if (this.hKr)
            {
              localObject = (au)this.hKp.get(paramInt1);
              this.hKs.add(localObject);
            }
            for (;;)
            {
              paramInt1 += 1;
              break;
              if (this.hKq < 0)
              {
                gf(paramInt1);
                this.gUt.a(4, ((alo)localObject).tgr, paramString, this);
                ge(paramInt1);
                GMTrace.o(13247021318144L, 98698);
                return;
              }
              this.hKr = true;
              this.hKq -= 1;
              localObject = (au)this.hKp.get(paramInt1);
              this.hKs.add(localObject);
              com.tencent.mm.kernel.h.vL().D(new Runnable()
              {
                public final void run()
                {
                  GMTrace.i(13245410705408L, 98686);
                  new ai(5, "", "", "", "", false, 1, false).a(j.a(j.this), new com.tencent.mm.y.e()
                  {
                    public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.y.k paramAnonymous2k)
                    {
                      GMTrace.i(13245142269952L, 98684);
                      paramAnonymous2k.hss = true;
                      v.i("MicroMsg.NetSceneSendMsg", "summerdktext verifypsw onSceneEnd[%d, %d] needVerifyPswList size[%d] errMsg[%s] verifyingPsw[%b], retryVerifyCount[%d]", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(j.this.hKs.size()), paramAnonymous2String, Boolean.valueOf(j.this.hKr), Integer.valueOf(j.this.hKq) });
                      if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
                      {
                        j.this.hKs.clear();
                        j.this.jQ(paramAnonymous2String);
                      }
                      for (;;)
                      {
                        j.this.hKr = false;
                        r.ijj = false;
                        GMTrace.o(13245142269952L, 98684);
                        return;
                        paramAnonymous2String = j.this.hKs;
                        paramAnonymous2Int1 = 0;
                        while (paramAnonymous2Int1 < paramAnonymous2String.size())
                        {
                          j.r((au)paramAnonymous2String.get(paramAnonymous2Int1));
                          paramAnonymous2Int1 += 1;
                        }
                        j.this.gUt.a(4, -49, j.1.this.hKv, j.this);
                        paramAnonymous2String = j.this.hKs;
                        paramAnonymous2Int1 = 0;
                        while (paramAnonymous2Int1 < paramAnonymous2String.size())
                        {
                          j.q((au)paramAnonymous2String.get(paramAnonymous2Int1));
                          paramAnonymous2Int1 += 1;
                        }
                        j.this.hKs.clear();
                      }
                    }
                  });
                  GMTrace.o(13245410705408L, 98686);
                }
              });
            }
          }
          gf(paramInt1);
          this.gUt.a(4, ((alo)localObject).tgr, paramString, this);
          ge(paramInt1);
          GMTrace.o(13247021318144L, 98698);
          return;
        }
        long l = ((au)this.hKp.get(paramInt1)).field_msgId;
        v.i("MicroMsg.NetSceneSendMsg", "msg local id = " + l + ", SvrId = " + ((alo)localObject).tdE + " sent successfully!");
        au localau = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cA(l);
        localau.y(((alo)localObject).tdE);
        v.d("MicroMsg.NetSceneSendMsg", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(((alo)localObject).tdE), Integer.valueOf(r.iiD) });
        if ((10007 == r.iiC) && (r.iiD != 0))
        {
          localau.y(r.iiD);
          r.iiD = 0;
        }
        localau.dv(2);
        ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().a(l, localau);
        if (this.hKp == null) {
          v.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, sendingList is null");
        }
        for (;;)
        {
          paramArrayOfByte.add(Integer.valueOf(paramInt1));
          if (1 != ((alo)localObject).jMq) {
            break;
          }
          com.tencent.mm.plugin.report.c.oRz.a(11942, true, false, new Object[] { Long.valueOf(((alo)localObject).tdE) });
          com.tencent.mm.plugin.report.c.oRz.a(11945, false, true, new Object[] { Long.valueOf(((alo)localObject).tdE) });
          com.tencent.mm.plugin.report.c.oRz.a(11946, false, false, new Object[] { Long.valueOf(((alo)localObject).tdE) });
          com.tencent.mm.plugin.report.c.oRz.a(90L, 0L, 1L, false);
          com.tencent.mm.plugin.report.c.oRz.a(90L, 1L, 1L, true);
          break;
          if ((paramInt1 >= this.hKp.size()) || (paramInt1 < 0))
          {
            v.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, index:%d, sendingList.size:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.hKp.size()) });
          }
          else
          {
            l = ((au)this.hKp.get(paramInt1)).field_msgId;
            v.d("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent for msgId:%d", new Object[] { Long.valueOf(l) });
            localau = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cA(l);
            ny localny = new ny();
            localny.fUU.fCQ = localau;
            a.uql.m(localny);
          }
        }
      }
      v.i("MicroMsg.NetSceneSendMsg", "summerdktext total  [%d]msgs sent successfully, [%d]msgs need verifypsw", new Object[] { Integer.valueOf(paramInt1 - this.hKs.size()), Integer.valueOf(this.hKs.size()) });
    }
    v.d("MicroMsg.NetSceneSendMsg", "summerdktext send finish, continue send SENDING msg verifyingPsw[%b]", new Object[] { Boolean.valueOf(this.hKr) });
    if (this.hKr)
    {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(13247021318144L, 98698);
      return;
    }
    jQ(paramString);
    GMTrace.o(13247021318144L, 98698);
  }
  
  public final int getType()
  {
    GMTrace.i(13246618664960L, 98695);
    GMTrace.o(13246618664960L, 98695);
    return 522;
  }
  
  public final void jQ(String paramString)
  {
    GMTrace.i(13247155535872L, 98699);
    v.d("MicroMsg.NetSceneSendMsg", "continue send msg in list");
    int i = a(this.hsm, this.gUt);
    if (i == -2)
    {
      this.gUt.a(0, 0, paramString, this);
      GMTrace.o(13247155535872L, 98699);
      return;
    }
    if (i < 0) {
      this.gUt.a(3, -1, paramString, this);
    }
    GMTrace.o(13247155535872L, 98699);
  }
  
  protected final int ub()
  {
    GMTrace.i(13246081794048L, 98691);
    GMTrace.o(13246081794048L, 98691);
    return 10;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelmulti/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */