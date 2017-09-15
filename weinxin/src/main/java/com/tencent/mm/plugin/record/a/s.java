package com.tencent.mm.plugin.record.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.a.lk;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bn;
import com.tencent.mm.y.n;
import java.io.File;
import java.util.HashMap;

public final class s
  implements am
{
  private static HashMap<Integer, g.c> gJh;
  private l oNg;
  private i oNh;
  private p oNi;
  private h oNj;
  private e oNk;
  private q oNl;
  private com.tencent.mm.sdk.b.c oNm;
  
  static
  {
    GMTrace.i(7503978954752L, 55909);
    HashMap localHashMap = new HashMap();
    gJh = localHashMap;
    localHashMap.put(Integer.valueOf("RECORD_MSG_INFO_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(7513776848896L, 55982);
        String[] arrayOfString = l.gUn;
        GMTrace.o(7513776848896L, 55982);
        return arrayOfString;
      }
    });
    gJh.put(Integer.valueOf("RECORD_MSG_CDN_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(7495120584704L, 55843);
        String[] arrayOfString = i.gUn;
        GMTrace.o(7495120584704L, 55843);
        return arrayOfString;
      }
    });
    GMTrace.o(7503978954752L, 55909);
  }
  
  public s()
  {
    GMTrace.i(7502502559744L, 55898);
    this.oNg = null;
    this.oNh = null;
    this.oNi = null;
    this.oNj = null;
    this.oNk = null;
    this.oNl = new q();
    this.oNm = new com.tencent.mm.sdk.b.c() {};
    GMTrace.o(7502502559744L, 55898);
  }
  
  public static h aWA()
  {
    GMTrace.i(7503173648384L, 55903);
    com.tencent.mm.kernel.h.vG().uQ();
    if (aWw().oNj == null) {
      aWw().oNj = new h();
    }
    h localh = aWw().oNj;
    GMTrace.o(7503173648384L, 55903);
    return localh;
  }
  
  private static s aWw()
  {
    GMTrace.i(7502636777472L, 55899);
    s locals2 = (s)ap.yR().gs("plugin.record");
    s locals1 = locals2;
    if (locals2 == null)
    {
      locals1 = new s();
      ap.yR().a("plugin.record", locals1);
    }
    GMTrace.o(7502636777472L, 55899);
    return locals1;
  }
  
  public static l aWx()
  {
    GMTrace.i(7502770995200L, 55900);
    com.tencent.mm.kernel.h.vG().uQ();
    if (aWw().oNg == null)
    {
      localObject = aWw();
      ap.yY();
      ((s)localObject).oNg = new l(com.tencent.mm.u.c.wO());
    }
    Object localObject = aWw().oNg;
    GMTrace.o(7502770995200L, 55900);
    return (l)localObject;
  }
  
  public static i aWy()
  {
    GMTrace.i(7502905212928L, 55901);
    com.tencent.mm.kernel.h.vG().uQ();
    if (aWw().oNh == null)
    {
      localObject = aWw();
      ap.yY();
      ((s)localObject).oNh = new i(com.tencent.mm.u.c.wO());
    }
    Object localObject = aWw().oNh;
    GMTrace.o(7502905212928L, 55901);
    return (i)localObject;
  }
  
  public static p aWz()
  {
    GMTrace.i(7503039430656L, 55902);
    com.tencent.mm.kernel.h.vG().uQ();
    if (aWw().oNi == null) {
      aWw().oNi = new p();
    }
    p localp = aWw().oNi;
    GMTrace.o(7503039430656L, 55902);
    return localp;
  }
  
  public final void aM(boolean paramBoolean)
  {
    GMTrace.i(7503576301568L, 55906);
    v.d("MicroMsg.SubCoreRecordMsg", "on account post reset");
    com.tencent.mm.sdk.b.a.uql.b(this.oNl);
    com.tencent.mm.sdk.b.a.uql.b(this.oNm);
    this.oNk = new e();
    aWy().a(this.oNk);
    ap.yY();
    File localFile = new File(com.tencent.mm.u.c.xp());
    if ((!localFile.exists()) || (!localFile.isDirectory()))
    {
      v.d("MicroMsg.SubCoreRecordMsg", "record stg dir[%s] not exsit, create it");
      localFile.mkdirs();
    }
    GMTrace.o(7503576301568L, 55906);
  }
  
  public final void aN(boolean paramBoolean)
  {
    GMTrace.i(7503710519296L, 55907);
    GMTrace.o(7503710519296L, 55907);
  }
  
  public final void eD(int paramInt)
  {
    GMTrace.i(7503442083840L, 55905);
    GMTrace.o(7503442083840L, 55905);
  }
  
  public final void onAccountRelease()
  {
    GMTrace.i(7503844737024L, 55908);
    v.d("MicroMsg.SubCoreRecordMsg", "on account post release");
    com.tencent.mm.sdk.b.a.uql.c(this.oNl);
    com.tencent.mm.sdk.b.a.uql.c(this.oNm);
    aWy().b(this.oNk);
    this.oNk = null;
    Object localObject = aWw().oNi;
    if (localObject != null)
    {
      ((p)localObject).finish();
      ap.vd().b(632, (com.tencent.mm.y.e)localObject);
      aWy().b((i.a)localObject);
    }
    localObject = aWw().oNj;
    if (localObject != null) {
      ((f)localObject).finish();
    }
    GMTrace.o(7503844737024L, 55908);
  }
  
  public final HashMap<Integer, g.c> uh()
  {
    GMTrace.i(7503307866112L, 55904);
    HashMap localHashMap = gJh;
    GMTrace.o(7503307866112L, 55904);
    return localHashMap;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/record/a/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */