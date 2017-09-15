package com.tencent.mm.plugin.subapp.jdbiz;

import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.a.hf;
import com.tencent.mm.e.a.ia;
import com.tencent.mm.i.e;
import com.tencent.mm.i.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.pluginsdk.l.aa;
import com.tencent.mm.pluginsdk.l.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bp;
import java.util.HashMap;
import java.util.Map;

public class c
  implements l.l, am
{
  private com.tencent.mm.sdk.b.c gKh;
  private a qRj;
  private b qRk;
  Map<String, Integer> qRl;
  
  public c()
  {
    GMTrace.i(5854174642176L, 43617);
    this.qRj = null;
    this.qRk = null;
    this.qRl = new HashMap();
    this.gKh = new com.tencent.mm.sdk.b.c() {};
    v.i("MicroMsg.SubCoreJdIP6", "new SubCoreJDBiz this: " + hashCode() + " stack: " + bf.bJP());
    GMTrace.o(5854174642176L, 43617);
  }
  
  public static void b(b paramb)
  {
    GMTrace.i(5855785254912L, 43629);
    h.vG().uQ();
    c localc = bmE();
    if (localc.qRk == null) {
      localc.qRk = b.bmw();
    }
    v.i("MicroMsg.SubCoreJdIP6", "updatejdMsgContent old: %s new: %s", new Object[] { localc.qRk.bmy(), paramb.bmy() });
    if (!paramb.a(localc.qRk))
    {
      v.i("MicroMsg.SubCoreJdIP6", "fo zu baoyou! the activityid is same");
      GMTrace.o(5855785254912L, 43629);
      return;
    }
    if ((!bf.mA(paramb.qQZ)) || (paramb.qQY))
    {
      ap.yY();
      com.tencent.mm.u.c.vr().set(327939, "1");
    }
    if (paramb.qQX)
    {
      ap.yY();
      com.tencent.mm.u.c.vr().set(327938, "1");
    }
    for (;;)
    {
      localc.qRk = paramb;
      ap.yY();
      com.tencent.mm.u.c.vr().set(327942, paramb.fSi);
      localc.bmK();
      GMTrace.o(5855785254912L, 43629);
      return;
      ap.yY();
      com.tencent.mm.u.c.vr().set(327938, "");
    }
  }
  
  public static String bQ(String paramString, int paramInt)
  {
    GMTrace.i(5856187908096L, 43632);
    String str = paramString;
    if (-1 == paramString.indexOf('#')) {
      if (-1 != paramString.indexOf('?')) {
        break label64;
      }
    }
    label64:
    for (str = paramString + "?wc_scene=" + paramInt;; str = paramString + "&wc_scene=" + paramInt)
    {
      GMTrace.o(5856187908096L, 43632);
      return str;
    }
  }
  
  public static c bmE()
  {
    GMTrace.i(5854308859904L, 43618);
    c localc2 = (c)l.aa.sAa;
    c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = new c();
      l.aa.sAa = localc1;
    }
    GMTrace.o(5854308859904L, 43618);
    return localc1;
  }
  
  private void bmK()
  {
    GMTrace.i(5855919472640L, 43630);
    new ad(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(5851356069888L, 43596);
        ia localia = new ia();
        com.tencent.mm.sdk.b.a.uql.m(localia);
        GMTrace.o(5851356069888L, 43596);
      }
    });
    GMTrace.o(5855919472640L, 43630);
  }
  
  public static boolean bmM()
  {
    GMTrace.i(5856322125824L, 43633);
    String str1 = g.sV().getValue("JDEntranceConfigName");
    String str2 = g.sV().getValue("JDEntranceConfigIconUrl");
    String str3 = g.sV().getValue("JDEntranceConfigJumpUrl");
    if ((!bf.mA(str1)) && (!bf.mA(str2)) && (!bf.mA(str3)))
    {
      GMTrace.o(5856322125824L, 43633);
      return true;
    }
    GMTrace.o(5856322125824L, 43633);
    return false;
  }
  
  public final void aM(boolean paramBoolean)
  {
    GMTrace.i(5854711513088L, 43621);
    v.i("MicroMsg.SubCoreJdIP6", "onAccountPostReset");
    if (this.qRj == null) {
      this.qRj = new a();
    }
    ap.getSysCmdMsgExtension().a("jd", this.qRj, true);
    com.tencent.mm.sdk.b.a.uql.b(this.gKh);
    GMTrace.o(5854711513088L, 43621);
  }
  
  public final void aN(boolean paramBoolean)
  {
    GMTrace.i(5854845730816L, 43622);
    GMTrace.o(5854845730816L, 43622);
  }
  
  public final boolean bmF()
  {
    GMTrace.i(5855114166272L, 43624);
    ap.yY();
    boolean bool = "1".equals((String)com.tencent.mm.u.c.vr().get(327939, ""));
    GMTrace.o(5855114166272L, 43624);
    return bool;
  }
  
  public final boolean bmG()
  {
    GMTrace.i(5855248384000L, 43625);
    ap.yY();
    boolean bool = "1".equals((String)com.tencent.mm.u.c.vr().get(327938, ""));
    GMTrace.o(5855248384000L, 43625);
    return bool;
  }
  
  public final void bmH()
  {
    GMTrace.i(5855382601728L, 43626);
    ap.yY();
    com.tencent.mm.u.c.vr().set(327938, "");
    GMTrace.o(5855382601728L, 43626);
  }
  
  public final void bmI()
  {
    GMTrace.i(5855516819456L, 43627);
    ap.yY();
    com.tencent.mm.u.c.vr().set(327939, "");
    GMTrace.o(5855516819456L, 43627);
  }
  
  public final b bmJ()
  {
    GMTrace.i(5855651037184L, 43628);
    if (this.qRk == null) {
      this.qRk = b.bmw();
    }
    b localb = this.qRk;
    GMTrace.o(5855651037184L, 43628);
    return localb;
  }
  
  public final void bmL()
  {
    GMTrace.i(5856053690368L, 43631);
    if ((ap.zb()) && ((bmE().bmF()) || (bmE().bmG())))
    {
      b localb = bmE().bmJ();
      if (((!bf.mA(localb.qQZ)) || (localb.qQY)) && (localb.bmx()))
      {
        v.i("MicroMsg.SubCoreJdIP6", "clear red dot/friend dot");
        bmE().bmH();
        bmE().bmI();
        bmE().bmK();
      }
    }
    GMTrace.o(5856053690368L, 43631);
  }
  
  public final String bmN()
  {
    GMTrace.i(5856456343552L, 43634);
    Object localObject2 = g.sV().getValue("JDEntranceConfigJumpUrl");
    if (bf.mA((String)localObject2))
    {
      GMTrace.o(5856456343552L, 43634);
      return null;
    }
    b localb = bmJ();
    int j = 1;
    int i = j;
    Object localObject1 = localObject2;
    if (bmF())
    {
      if ((!localb.bmx()) && ("3".equals(localb.qQV)) && (!bf.mA(localb.jumpUrl)))
      {
        v.i("MicroMsg.SubCoreJdIP6", "jumpUrl update %s", new Object[] { localb.jumpUrl });
        localObject1 = localb.jumpUrl;
        i = 6;
      }
    }
    else
    {
      j = i;
      localObject2 = localObject1;
      if ("2".equals(localb.qQV))
      {
        j = i;
        localObject2 = localObject1;
        if (!bf.mA(localb.jumpUrl))
        {
          if (localb.qRb >= System.currentTimeMillis() / 1000L) {
            break label277;
          }
          k = 1;
          label177:
          j = i;
          localObject2 = localObject1;
          if (k != 0) {
            if ((localb.qRc == 0L) || (localb.qRc >= System.currentTimeMillis() / 1000L)) {
              break label282;
            }
          }
        }
      }
    }
    label277:
    label282:
    for (int k = 1;; k = 0)
    {
      j = i;
      localObject2 = localObject1;
      if (k == 0)
      {
        localObject2 = localb.jumpUrl;
        j = 3;
      }
      localObject1 = bQ((String)localObject2, j);
      GMTrace.o(5856456343552L, 43634);
      return (String)localObject1;
      i = j;
      localObject1 = localObject2;
      if (!localb.qQY) {
        break;
      }
      i = 2;
      localObject1 = localObject2;
      break;
      k = 0;
      break label177;
    }
  }
  
  public final void eD(int paramInt)
  {
    GMTrace.i(5854577295360L, 43620);
    GMTrace.o(5854577295360L, 43620);
  }
  
  public final void onAccountRelease()
  {
    GMTrace.i(5854979948544L, 43623);
    v.i("MicroMsg.SubCoreJdIP6", "onAccountRelease");
    if (this.qRj != null)
    {
      a locala = this.qRj;
      com.tencent.mm.sdk.b.a.uql.c(locala.qQS);
      ap.getSysCmdMsgExtension().b("jd", this.qRj, true);
    }
    this.qRl.clear();
    this.qRj = null;
    com.tencent.mm.sdk.b.a.uql.c(this.gKh);
    GMTrace.o(5854979948544L, 43623);
  }
  
  public final HashMap<Integer, g.c> uh()
  {
    GMTrace.i(5854443077632L, 43619);
    GMTrace.o(5854443077632L, 43619);
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/subapp/jdbiz/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */