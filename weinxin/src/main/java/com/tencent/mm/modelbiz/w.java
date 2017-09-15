package com.tencent.mm.modelbiz;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelbiz.a.i;
import com.tencent.mm.modelbiz.a.k;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.as.a;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.am;
import com.tencent.mm.u.bp;
import com.tencent.mm.u.bp.a;
import com.tencent.mm.u.l;
import com.tencent.mm.u.o;
import com.tencent.mm.y.d.c;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class w
  implements am
{
  private static HashMap<Integer, g.c> gJh;
  private static long hvQ;
  private com.tencent.mm.u.e hlN;
  private d hvR;
  private l.a hvS;
  private j hvT;
  private h hvU;
  private g hvV;
  private com.tencent.mm.modelbiz.a.d hvW;
  private com.tencent.mm.modelbiz.a.b hvX;
  private k hvY;
  private com.tencent.mm.modelbiz.a.g hvZ;
  private i hwa;
  private com.tencent.mm.modelbiz.a.h hwb;
  private c hwc;
  private a hwd;
  private bp.a hwe;
  private as.a hwf;
  private d.a hwg;
  
  static
  {
    GMTrace.i(4527163965440L, 33730);
    hvQ = 0L;
    HashMap localHashMap = new HashMap();
    gJh = localHashMap;
    localHashMap.put(Integer.valueOf("BIZINFO_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(4548638801920L, 33890);
        String[] arrayOfString = d.gUn;
        GMTrace.o(4548638801920L, 33890);
        return arrayOfString;
      }
    });
    gJh.put(Integer.valueOf("BIZKF_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(4527432400896L, 33732);
        String[] arrayOfString = h.gUn;
        GMTrace.o(4527432400896L, 33732);
        return arrayOfString;
      }
    });
    gJh.put(Integer.valueOf("BIZCHAT_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(4537632948224L, 33808);
        String[] arrayOfString = com.tencent.mm.modelbiz.a.d.gUn;
        GMTrace.o(4537632948224L, 33808);
        return arrayOfString;
      }
    });
    gJh.put(Integer.valueOf("BIZCHATUSER_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(4551591591936L, 33912);
        String[] arrayOfString = k.gUn;
        GMTrace.o(4551591591936L, 33912);
        return arrayOfString;
      }
    });
    gJh.put(Integer.valueOf("BIZCONVERSATION_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(4556691865600L, 33950);
        String[] arrayOfString = com.tencent.mm.modelbiz.a.b.gUn;
        GMTrace.o(4556691865600L, 33950);
        return arrayOfString;
      }
    });
    gJh.put(Integer.valueOf("BIZCHAMYUSERINFO_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(4585146023936L, 34162);
        String[] arrayOfString = com.tencent.mm.modelbiz.a.g.gUn;
        GMTrace.o(4585146023936L, 34162);
        return arrayOfString;
      }
    });
    gJh.put(Integer.valueOf("BIZENTERPRISE_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(4584877588480L, 34160);
        String[] arrayOfString = c.gUn;
        GMTrace.o(4584877588480L, 34160);
        return arrayOfString;
      }
    });
    GMTrace.o(4527163965440L, 33730);
  }
  
  public w()
  {
    GMTrace.i(4524076957696L, 33707);
    this.hvS = null;
    this.hvT = null;
    this.hvV = null;
    this.hvW = null;
    this.hvX = null;
    this.hvY = null;
    this.hvZ = null;
    this.hwa = null;
    this.hwb = null;
    this.hwc = null;
    this.hlN = new com.tencent.mm.u.e();
    this.hwe = new bp.a()
    {
      public final void a(com.tencent.mm.y.d.a paramAnonymousa)
      {
        GMTrace.i(4539780431872L, 33824);
        paramAnonymousa = paramAnonymousa.hsc;
        if (paramAnonymousa == null)
        {
          v.e("MicroMsg.SubCoreBiz", "AddMsg is null.");
          GMTrace.o(4539780431872L, 33824);
          return;
        }
        paramAnonymousa = com.tencent.mm.platformtools.n.a(paramAnonymousa.tdz);
        if (bf.mA(paramAnonymousa))
        {
          v.e("MicroMsg.SubCoreBiz", "msg content is null");
          GMTrace.o(4539780431872L, 33824);
          return;
        }
        paramAnonymousa = bg.q(paramAnonymousa, "sysmsg");
        if ((paramAnonymousa == null) || (paramAnonymousa.size() <= 0))
        {
          v.e("MicroMsg.SubCoreBiz", "receiveMessage, no sysmsg");
          GMTrace.o(4539780431872L, 33824);
          return;
        }
        if (!"mmbizattrappsvr_BizAttrSync".equalsIgnoreCase((String)paramAnonymousa.get(".sysmsg.$type")))
        {
          v.e("MicroMsg.SubCoreBiz", "receiveMessage, type not BizAttrSync.");
          GMTrace.o(4539780431872L, 33824);
          return;
        }
        int i = bf.getInt((String)paramAnonymousa.get(".sysmsg.mmbizattrappsvr_BizAttrSync.openflag"), 0);
        v.i("MicroMsg.SubCoreBiz", "BizAttrSync openFlag : %d.", new Object[] { Integer.valueOf(i) });
        com.tencent.mm.kernel.h.vI().vr().a(w.a.uzF, Integer.valueOf(i));
        com.tencent.mm.kernel.h.vI().vr().jV(true);
        GMTrace.o(4539780431872L, 33824);
      }
    };
    this.hwf = new as.a()
    {
      public final void a(ae paramAnonymousae, as paramAnonymousas)
      {
        GMTrace.i(4544880705536L, 33862);
        if ((paramAnonymousae != null) && (!bf.mA(paramAnonymousae.field_username)))
        {
          paramAnonymousas = paramAnonymousae.field_username;
          Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramAnonymousas);
          if (localObject == null)
          {
            GMTrace.o(4544880705536L, 33862);
            return;
          }
          if ((((x)localObject).bKU()) && (!o.fh(paramAnonymousas)))
          {
            localObject = w.DH().hO(paramAnonymousas);
            if (((BizInfo)localObject).uvp == -1L)
            {
              v.i("MicroMsg.SubCoreBiz", "onMsgChangeNotify: no bizInfo");
              GMTrace.o(4544880705536L, 33862);
              return;
            }
            if (((BizInfo)localObject).CI())
            {
              if (((BizInfo)localObject).bd(false) == null)
              {
                paramAnonymousae.cw(null);
                v.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
                GMTrace.o(4544880705536L, 33862);
                return;
              }
              if (((BizInfo)localObject).bd(false).Di() == null)
              {
                paramAnonymousae.cw(null);
                v.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
                GMTrace.o(4544880705536L, 33862);
                return;
              }
              if (!((BizInfo)localObject).CJ())
              {
                paramAnonymousae.cw(bf.mz(((BizInfo)localObject).CO()));
                if (bf.mA(((BizInfo)localObject).CO()))
                {
                  v.w("MicroMsg.SubCoreBiz", "Enterprise belong is null:%s", new Object[] { paramAnonymousae.field_username });
                  GMTrace.o(4544880705536L, 33862);
                }
              }
              else
              {
                paramAnonymousae.cw(null);
              }
              GMTrace.o(4544880705536L, 33862);
              return;
            }
            if ((((BizInfo)localObject).CE()) || (((BizInfo)localObject).CH()) || (o.fC(paramAnonymousas)))
            {
              paramAnonymousae.cw(null);
              GMTrace.o(4544880705536L, 33862);
              return;
            }
            paramAnonymousae.cw("officialaccounts");
          }
        }
        GMTrace.o(4544880705536L, 33862);
      }
    };
    this.hwg = new d.a()
    {
      public final void a(d.a.b paramAnonymousb)
      {
        GMTrace.i(4590112079872L, 34199);
        Object localObject;
        ae localae;
        int i;
        if ((paramAnonymousb.hvn == d.a.a.hvj) || (paramAnonymousb.hvn == d.a.a.hvl))
        {
          if (paramAnonymousb.hvo == null)
          {
            GMTrace.o(4590112079872L, 34199);
            return;
          }
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramAnonymousb.htS);
          if (localObject == null)
          {
            GMTrace.o(4590112079872L, 34199);
            return;
          }
          if (!((x)localObject).bKU())
          {
            w.h(paramAnonymousb.hvo);
            GMTrace.o(4590112079872L, 34199);
            return;
          }
          if (o.fh(((af)localObject).field_username))
          {
            GMTrace.o(4590112079872L, 34199);
            return;
          }
          localae = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rl(paramAnonymousb.htS);
          v.v("MicroMsg.SubCoreBiz", "hakon onEvent bizName = %s", new Object[] { paramAnonymousb.htS });
          if ((paramAnonymousb.hvo.CI()) && (paramAnonymousb.hvo.bd(false) != null) && (paramAnonymousb.hvo.bd(false).Di() != null) && (!bf.mA(paramAnonymousb.hvo.CO())) && (bf.mA(paramAnonymousb.hvo.field_enterpriseFather)))
          {
            paramAnonymousb.hvo.field_enterpriseFather = paramAnonymousb.hvo.CO();
            w.DH().e(paramAnonymousb.hvo);
            v.i("MicroMsg.SubCoreBiz", "hakon bizStgExt, %s set enterpriseFather %s", new Object[] { paramAnonymousb.htS, paramAnonymousb.hvo.field_enterpriseFather });
          }
          if (localae == null)
          {
            GMTrace.o(4590112079872L, 34199);
            return;
          }
          if (paramAnonymousb.hvo.CI())
          {
            if (paramAnonymousb.hvo.bd(false) == null)
            {
              v.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
              GMTrace.o(4590112079872L, 34199);
              return;
            }
            if (paramAnonymousb.hvo.bd(false).Di() == null)
            {
              v.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
              GMTrace.o(4590112079872L, 34199);
              return;
            }
            localObject = localae.field_parentRef;
            if (!paramAnonymousb.hvo.CJ())
            {
              v.i("MicroMsg.SubCoreBiz", "Enterprise belong %s, userName: %s", new Object[] { paramAnonymousb.hvo.CO(), paramAnonymousb.htS });
              localae.cw(bf.mz(paramAnonymousb.hvo.CO()));
              if ((localObject == null) || (localae.field_parentRef == null) || (((String)localObject).equals(localae.field_parentRef))) {
                break label525;
              }
              i = 1;
            }
          }
        }
        for (;;)
        {
          label445:
          v.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseChildType, %s, %s", new Object[] { paramAnonymousb.htS, localae.field_parentRef });
          for (;;)
          {
            if (i != 0)
            {
              ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().a(localae, localae.field_username);
              if (bf.mA(localae.field_parentRef))
              {
                GMTrace.o(4590112079872L, 34199);
                return;
                localae.cw(null);
                break;
                label525:
                if ((localObject == null) && (localae.field_parentRef != null))
                {
                  i = 1;
                  break label445;
                }
                if ((localObject == null) || (localae.field_parentRef != null)) {
                  break label1088;
                }
                i = 1;
                break label445;
                if (paramAnonymousb.hvo.CH())
                {
                  v.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseFatherType, %s", new Object[] { paramAnonymousb.htS });
                  i = 1;
                  continue;
                }
                if ((!paramAnonymousb.hvo.CE()) && (!o.fC(((af)localObject).field_username)) && (!"officialaccounts".equals(localae.field_parentRef)))
                {
                  localae.cw("officialaccounts");
                  i = 1;
                  continue;
                }
                if ((!paramAnonymousb.hvo.CE()) || (localae.field_parentRef == null)) {
                  break label1083;
                }
                localae.cw(null);
                i = 1;
                continue;
              }
              if ("officialaccounts".equals(localae.field_parentRef))
              {
                localae = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rl("officialaccounts");
                paramAnonymousb = localae;
                if (localae == null)
                {
                  paramAnonymousb = new ae("officialaccounts");
                  paramAnonymousb.bLr();
                  ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().d(paramAnonymousb);
                }
                if (bf.mA(paramAnonymousb.field_content))
                {
                  v.i("MicroMsg.SubCoreBiz", "conv content is null");
                  paramAnonymousb = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().bLB();
                  if (bf.mA(paramAnonymousb))
                  {
                    v.w("MicroMsg.SubCoreBiz", "last convBiz is null");
                    GMTrace.o(4590112079872L, 34199);
                    return;
                  }
                  paramAnonymousb = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Ag(paramAnonymousb);
                  if ((paramAnonymousb == null) || (paramAnonymousb.field_msgId == 0L))
                  {
                    v.w("MicroMsg.SubCoreBiz", "last biz msg is error");
                    GMTrace.o(4590112079872L, 34199);
                    return;
                  }
                  ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().a(paramAnonymousb.field_msgId, paramAnonymousb);
                }
                GMTrace.o(4590112079872L, 34199);
                return;
              }
              v.i("MicroMsg.SubCoreBiz", "hakon username = %s, parentRef = %s", new Object[] { paramAnonymousb.htS, localae.field_parentRef });
              paramAnonymousb = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rl(localae.field_parentRef);
              if (paramAnonymousb == null)
              {
                GMTrace.o(4590112079872L, 34199);
                return;
              }
              if (bf.mA(paramAnonymousb.field_content))
              {
                v.i("MicroMsg.SubCoreBiz", "conv content is null");
                paramAnonymousb = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rw(localae.field_parentRef);
                if (bf.mA(paramAnonymousb))
                {
                  v.w("MicroMsg.SubCoreBiz", "last enterprise convBiz is null");
                  GMTrace.o(4590112079872L, 34199);
                  return;
                }
                paramAnonymousb = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Ag(paramAnonymousb);
                if ((paramAnonymousb == null) || (paramAnonymousb.field_msgId == 0L))
                {
                  v.w("MicroMsg.SubCoreBiz", "last enterprise biz msg is error");
                  GMTrace.o(4590112079872L, 34199);
                  return;
                }
                ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().a(paramAnonymousb.field_msgId, paramAnonymousb);
              }
            }
            GMTrace.o(4590112079872L, 34199);
            return;
            label1083:
            i = 0;
          }
          label1088:
          i = 0;
        }
      }
    };
    GMTrace.o(4524076957696L, 33707);
  }
  
  private static w DF()
  {
    try
    {
      GMTrace.i(4524211175424L, 33708);
      w localw = (w)l.o(w.class);
      GMTrace.o(4524211175424L, 33708);
      return localw;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static h DG()
  {
    GMTrace.i(4524345393152L, 33709);
    com.tencent.mm.kernel.h.vG().uQ();
    if (DF().hvU == null) {
      DF().hvU = new h(com.tencent.mm.kernel.h.vI().gXW);
    }
    h localh = DF().hvU;
    GMTrace.o(4524345393152L, 33709);
    return localh;
  }
  
  public static d DH()
  {
    GMTrace.i(4524479610880L, 33710);
    com.tencent.mm.kernel.h.vG().uQ();
    if (DF().hvR == null) {
      DF().hvR = new d(com.tencent.mm.kernel.h.vI().gXW);
    }
    d locald = DF().hvR;
    GMTrace.o(4524479610880L, 33710);
    return locald;
  }
  
  public static g DI()
  {
    GMTrace.i(4524613828608L, 33711);
    com.tencent.mm.kernel.h.vG().uQ();
    g localg;
    if (DF().hvV == null)
    {
      DF().hvV = new g();
      localg = DF().hvV;
      com.tencent.mm.kernel.h.vH().gXs.a(675, localg);
      com.tencent.mm.kernel.h.vH().gXs.a(672, localg);
      com.tencent.mm.kernel.h.vH().gXs.a(674, localg);
    }
    synchronized (localg.hvp)
    {
      localg.hvr.clear();
      ??? = DF().hvV;
      GMTrace.o(4524613828608L, 33711);
      return (g)???;
    }
  }
  
  public static com.tencent.mm.modelbiz.a.d DJ()
  {
    GMTrace.i(4524748046336L, 33712);
    com.tencent.mm.kernel.h.vG().uQ();
    if (DF().hvW == null) {
      DF().hvW = new com.tencent.mm.modelbiz.a.d(com.tencent.mm.kernel.h.vI().gXW);
    }
    com.tencent.mm.modelbiz.a.d locald = DF().hvW;
    GMTrace.o(4524748046336L, 33712);
    return locald;
  }
  
  public static com.tencent.mm.modelbiz.a.b DK()
  {
    GMTrace.i(4524882264064L, 33713);
    com.tencent.mm.kernel.h.vG().uQ();
    if (DF().hvX == null) {
      DF().hvX = new com.tencent.mm.modelbiz.a.b(com.tencent.mm.kernel.h.vI().gXW);
    }
    com.tencent.mm.modelbiz.a.b localb = DF().hvX;
    GMTrace.o(4524882264064L, 33713);
    return localb;
  }
  
  public static k DL()
  {
    GMTrace.i(4525016481792L, 33714);
    com.tencent.mm.kernel.h.vG().uQ();
    if (DF().hvY == null) {
      DF().hvY = new k(com.tencent.mm.kernel.h.vI().gXW);
    }
    k localk = DF().hvY;
    GMTrace.o(4525016481792L, 33714);
    return localk;
  }
  
  public static com.tencent.mm.modelbiz.a.g DM()
  {
    GMTrace.i(4525150699520L, 33715);
    com.tencent.mm.kernel.h.vG().uQ();
    if (DF().hvZ == null) {
      DF().hvZ = new com.tencent.mm.modelbiz.a.g(com.tencent.mm.kernel.h.vI().gXW);
    }
    com.tencent.mm.modelbiz.a.g localg = DF().hvZ;
    GMTrace.o(4525150699520L, 33715);
    return localg;
  }
  
  public static com.tencent.mm.modelbiz.a.h DN()
  {
    GMTrace.i(4525284917248L, 33716);
    com.tencent.mm.kernel.h.vG().uQ();
    if (DF().hwb == null) {
      DF().hwb = new com.tencent.mm.modelbiz.a.h();
    }
    com.tencent.mm.modelbiz.a.h localh = DF().hwb;
    GMTrace.o(4525284917248L, 33716);
    return localh;
  }
  
  public static c DO()
  {
    GMTrace.i(4525419134976L, 33717);
    com.tencent.mm.kernel.h.vG().uQ();
    if (DF().hwc == null) {
      DF().hwc = new c(com.tencent.mm.kernel.h.vI().gXW);
    }
    c localc = DF().hwc;
    GMTrace.o(4525419134976L, 33717);
    return localc;
  }
  
  public static l.a DP()
  {
    GMTrace.i(4525553352704L, 33718);
    com.tencent.mm.kernel.h.vG().uQ();
    if (DF().hvS == null) {
      DF().hvS = new l.a();
    }
    l.a locala = DF().hvS;
    GMTrace.o(4525553352704L, 33718);
    return locala;
  }
  
  public static j DQ()
  {
    GMTrace.i(4525687570432L, 33719);
    com.tencent.mm.kernel.h.vG().uQ();
    if (DF().hvT == null) {
      DF().hvT = new j();
    }
    j localj = DF().hvT;
    GMTrace.o(4525687570432L, 33719);
    return localj;
  }
  
  public static a DR()
  {
    GMTrace.i(4525821788160L, 33720);
    if (DF().hwd == null) {
      DF().hwd = new a();
    }
    a locala = DF().hwd;
    GMTrace.o(4525821788160L, 33720);
    return locala;
  }
  
  public static i DS()
  {
    GMTrace.i(4525956005888L, 33721);
    com.tencent.mm.kernel.h.vG().uQ();
    if (DF().hwa == null) {
      DF().hwa = new i();
    }
    i locali = DF().hwa;
    GMTrace.o(4525956005888L, 33721);
    return locali;
  }
  
  public static long DT()
  {
    GMTrace.i(4526090223616L, 33722);
    if (hvQ == 0L)
    {
      Object localObject = com.tencent.mm.kernel.h.vI().vr().get(w.a.uyB, null);
      if ((localObject != null) && ((localObject instanceof Long)))
      {
        hvQ = ((Long)localObject).longValue();
        v.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime : %d.(get from ConfigStorage)", new Object[] { Long.valueOf(hvQ) });
      }
    }
    if (hvQ == 0L)
    {
      hvQ = System.currentTimeMillis();
      com.tencent.mm.kernel.h.vI().vr().a(w.a.uyB, Long.valueOf(hvQ));
      v.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime is 0, so get current time : %d.", new Object[] { Long.valueOf(hvQ) });
    }
    long l = hvQ;
    GMTrace.o(4526090223616L, 33722);
    return l;
  }
  
  public static void h(BizInfo paramBizInfo)
  {
    GMTrace.i(16085189394432L, 119844);
    if ((paramBizInfo.CI()) && (!paramBizInfo.CJ()) && (paramBizInfo.bd(false) != null) && (paramBizInfo.bd(false).Di() != null) && (!bf.mA(paramBizInfo.CO())))
    {
      if (((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rl(paramBizInfo.CO()) == null) {
        v.d("MicroMsg.SubCoreBiz", "father conv is null");
      }
      if (((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rl(paramBizInfo.field_username) == null)
      {
        v.v("MicroMsg.SubCoreBiz", "add empty conv for enterprise child %s", new Object[] { paramBizInfo.field_username });
        ae localae = new ae(paramBizInfo.field_username);
        if (!paramBizInfo.CJ())
        {
          v.i("MicroMsg.SubCoreBiz", "Enterprise belong %s, userName: %s", new Object[] { paramBizInfo.CO(), paramBizInfo.field_username });
          localae.cw(bf.mz(paramBizInfo.CO()));
          localae.bLr();
          ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().d(localae);
        }
      }
    }
    GMTrace.o(16085189394432L, 119844);
  }
  
  public final void aM(boolean paramBoolean)
  {
    GMTrace.i(4526627094528L, 33726);
    d.c.a(Integer.valueOf(55), this.hlN);
    d.c.a(Integer.valueOf(57), this.hlN);
    ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().b(this.hwf);
    DH().a(this.hwg, null);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("mmbizattrappsvr_BizAttrSync", this.hwe, true);
    GMTrace.o(4526627094528L, 33726);
  }
  
  public final void aN(boolean paramBoolean)
  {
    GMTrace.i(4526895529984L, 33728);
    GMTrace.o(4526895529984L, 33728);
  }
  
  public final void eD(int paramInt)
  {
    GMTrace.i(4526358659072L, 33724);
    GMTrace.o(4526358659072L, 33724);
  }
  
  public final void onAccountRelease()
  {
    GMTrace.i(4526761312256L, 33727);
    d.c.aA(Integer.valueOf(55));
    d.c.aA(Integer.valueOf(57));
    g localg;
    if (DF().hvV != null)
    {
      localg = DF().hvV;
      com.tencent.mm.kernel.h.vH().gXs.b(675, localg);
      com.tencent.mm.kernel.h.vH().gXs.b(672, localg);
      com.tencent.mm.kernel.h.vH().gXs.b(674, localg);
    }
    synchronized (localg.hvp)
    {
      localg.hvr.clear();
      localg.hvq.clear();
      if (com.tencent.mm.kernel.h.vG().uV())
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().c(this.hwf);
        DH().a(this.hwg);
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("mmbizattrappsvr_BizAttrSync", this.hwe, true);
      GMTrace.o(4526761312256L, 33727);
      return;
    }
  }
  
  public final HashMap<Integer, g.c> uh()
  {
    GMTrace.i(4526224441344L, 33723);
    HashMap localHashMap = gJh;
    GMTrace.o(4526224441344L, 33723);
    return localHashMap;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */