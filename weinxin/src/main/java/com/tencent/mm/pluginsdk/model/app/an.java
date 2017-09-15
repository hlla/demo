package com.tencent.mm.pluginsdk.model.app;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.a.cg;
import com.tencent.mm.e.a.gy;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.k.a.d.p;
import com.tencent.mm.pluginsdk.k.a.d.s;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bn;
import com.tencent.mm.y.d.c;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class an
  implements am
{
  private static HashMap<Integer, g.c> gJh;
  private k sCF;
  private o sCG;
  private am.a sCH;
  private j sCI;
  private com.tencent.mm.pluginsdk.model.b sCJ;
  private final s sCK;
  private com.tencent.mm.sdk.b.c sCL;
  private com.tencent.mm.sdk.b.c sCM;
  
  static
  {
    GMTrace.i(787186974720L, 5865);
    HashMap localHashMap = new HashMap();
    gJh = localHashMap;
    localHashMap.put(Integer.valueOf("APPMESSAGE_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(17956050305024L, 133783);
        String[] arrayOfString = k.gUn;
        GMTrace.o(17956050305024L, 133783);
        return arrayOfString;
      }
    });
    gJh.put(Integer.valueOf("APPSORT_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(796582215680L, 5935);
        String[] arrayOfString = o.gUn;
        GMTrace.o(796582215680L, 5935);
        return arrayOfString;
      }
    });
    GMTrace.o(787186974720L, 5865);
  }
  
  public an()
  {
    GMTrace.i(784905273344L, 5848);
    this.sCH = null;
    this.sCI = new j();
    this.sCJ = new com.tencent.mm.pluginsdk.model.b();
    this.sCL = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(gy paramAnonymousgy)
      {
        GMTrace.i(17956452958208L, 133786);
        for (;;)
        {
          try
          {
            com.tencent.mm.i.e locale = com.tencent.mm.i.g.sV();
            if (locale != null) {
              continue;
            }
            i = 0;
          }
          catch (Exception localException)
          {
            int i = 0;
            continue;
          }
          paramAnonymousgy.fMe.fFP = i;
          GMTrace.o(17956452958208L, 133786);
          return false;
          i = bf.getInt(com.tencent.mm.i.g.sV().getValue("AndroidUseUnicodeEmoji"), 0);
        }
      }
    };
    this.sCM = new com.tencent.mm.sdk.b.c() {};
    this.sCK = new s();
    GMTrace.o(784905273344L, 5848);
  }
  
  public static d aBz()
  {
    GMTrace.i(786381668352L, 5859);
    d locald = com.tencent.mm.plugin.w.a.aBz();
    GMTrace.o(786381668352L, 5859);
    return locald;
  }
  
  public static e aRi()
  {
    GMTrace.i(785442144256L, 5852);
    e locale = com.tencent.mm.plugin.w.a.aRi();
    GMTrace.o(785442144256L, 5852);
    return locale;
  }
  
  public static h aRj()
  {
    GMTrace.i(785576361984L, 5853);
    h localh = com.tencent.mm.plugin.w.a.aRj();
    GMTrace.o(785576361984L, 5853);
    return localh;
  }
  
  public static i aRk()
  {
    GMTrace.i(785710579712L, 5854);
    i locali = com.tencent.mm.plugin.w.a.aRk();
    GMTrace.o(785710579712L, 5854);
    return locali;
  }
  
  public static m aRl()
  {
    GMTrace.i(786247450624L, 5858);
    m localm = com.tencent.mm.plugin.w.a.aRl();
    GMTrace.o(786247450624L, 5858);
    return localm;
  }
  
  public static c abF()
  {
    GMTrace.i(785307926528L, 5851);
    c localc = com.tencent.mm.plugin.w.a.abF();
    GMTrace.o(785307926528L, 5851);
    return localc;
  }
  
  private static an bDa()
  {
    GMTrace.i(785039491072L, 5849);
    an localan2 = (an)ap.yR().gs(an.class.getName());
    an localan1 = localan2;
    if (localan2 == null) {
      localan1 = new an();
    }
    GMTrace.o(785039491072L, 5849);
    return localan1;
  }
  
  public static j bDb()
  {
    GMTrace.i(785173708800L, 5850);
    j localj = bDa().sCI;
    GMTrace.o(785173708800L, 5850);
    return localj;
  }
  
  public static k bDc()
  {
    GMTrace.i(785844797440L, 5855);
    com.tencent.mm.kernel.h.vG().uQ();
    if (bDa().sCF == null)
    {
      localObject = bDa();
      ap.yY();
      ((an)localObject).sCF = new k(com.tencent.mm.u.c.wO());
    }
    Object localObject = bDa().sCF;
    GMTrace.o(785844797440L, 5855);
    return (k)localObject;
  }
  
  public static o bDd()
  {
    GMTrace.i(785979015168L, 5856);
    com.tencent.mm.kernel.h.vG().uQ();
    if (bDa().sCG == null)
    {
      localObject = bDa();
      ap.yY();
      ((an)localObject).sCG = new o(com.tencent.mm.u.c.wO());
    }
    Object localObject = bDa().sCG;
    GMTrace.o(785979015168L, 5856);
    return (o)localObject;
  }
  
  public static am.a bDe()
  {
    GMTrace.i(786113232896L, 5857);
    com.tencent.mm.kernel.h.vG().uQ();
    if (bDa().sCH == null) {
      bDa().sCH = new am.a();
    }
    am.a locala = bDa().sCH;
    GMTrace.o(786113232896L, 5857);
    return locala;
  }
  
  public final void aM(boolean paramBoolean)
  {
    GMTrace.i(786918539264L, 5863);
    com.tencent.mm.u.x.a.hly = com.tencent.mm.plugin.w.a.aRj();
    d.c.a(Integer.valueOf(47), this.sCJ);
    d.c.a(Integer.valueOf(49), this.sCI);
    com.tencent.mm.sdk.b.a.uql.b(this.sCL);
    com.tencent.mm.sdk.b.a.uql.b(this.sCM);
    SightVideoJNI.registerALL();
    s locals = this.sCK;
    Iterator localIterator = p.bDz().iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.pluginsdk.k.a.d.g)localIterator.next()).bwG();
    }
    com.tencent.mm.kernel.h.vH().a(locals.sFq);
    com.tencent.mm.sdk.b.a.uql.b(locals.sFr);
    GMTrace.o(786918539264L, 5863);
  }
  
  public final void aN(boolean paramBoolean)
  {
    GMTrace.i(787052756992L, 5864);
    GMTrace.o(787052756992L, 5864);
  }
  
  public final void eD(int paramInt)
  {
    GMTrace.i(786784321536L, 5862);
    GMTrace.o(786784321536L, 5862);
  }
  
  public final void onAccountRelease()
  {
    GMTrace.i(786515886080L, 5860);
    Object localObject = bDa().sCH;
    if (localObject != null) {
      ((am.a)localObject).fBf = 0;
    }
    d.c.aA(Integer.valueOf(47));
    d.c.aA(Integer.valueOf(49));
    com.tencent.mm.sdk.b.a.uql.c(this.sCL);
    com.tencent.mm.sdk.b.a.uql.c(this.sCM);
    com.tencent.mm.pluginsdk.model.j.bCy();
    localObject = this.sCK;
    com.tencent.mm.kernel.h.vH().b(((s)localObject).sFq);
    com.tencent.mm.sdk.b.a.uql.c(((s)localObject).sFr);
    localObject = p.bDz().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.pluginsdk.k.a.d.g)((Iterator)localObject).next()).onAccountRelease();
    }
    GMTrace.o(786515886080L, 5860);
  }
  
  public final HashMap<Integer, g.c> uh()
  {
    GMTrace.i(786650103808L, 5861);
    HashMap localHashMap = gJh;
    GMTrace.o(786650103808L, 5861);
    return localHashMap;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */