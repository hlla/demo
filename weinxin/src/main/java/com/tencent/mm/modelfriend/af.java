package com.tencent.mm.modelfriend;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.a.as;
import com.tencent.mm.e.a.gw;
import com.tencent.mm.e.a.hg;
import com.tencent.mm.e.a.j;
import com.tencent.mm.e.a.nz;
import com.tencent.mm.kernel.h;
import com.tencent.mm.o.b;
import com.tencent.mm.protocal.c.ajj;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bn;
import com.tencent.mm.y.d.c;
import java.util.HashMap;
import java.util.LinkedList;

public class af
  implements am
{
  private static HashMap<Integer, g.c> gJh;
  private c hBU;
  private i hBV;
  private l hBW;
  private ac hBX;
  private ae hBY;
  private r hBZ;
  private p hCa;
  private e hCb;
  private LinkedList<ajj> hCc;
  private d hCd;
  private f hCe;
  private g hCf;
  private com.tencent.mm.sdk.b.c hCg;
  private com.tencent.mm.sdk.b.c hCh;
  private com.tencent.mm.sdk.b.c hCi;
  private com.tencent.mm.sdk.b.c hCj;
  private com.tencent.mm.sdk.b.c hCk;
  
  static
  {
    GMTrace.i(4415629033472L, 32899);
    HashMap localHashMap = new HashMap();
    gJh = localHashMap;
    localHashMap.put(Integer.valueOf("ADDR_UPLOAD_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(4437774958592L, 33064);
        String[] arrayOfString = c.gUn;
        GMTrace.o(4437774958592L, 33064);
        return arrayOfString;
      }
    });
    gJh.put(Integer.valueOf("FACE_BOOK_FIREND_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(4442875232256L, 33102);
        String[] arrayOfString = i.gUn;
        GMTrace.o(4442875232256L, 33102);
        return arrayOfString;
      }
    });
    gJh.put(Integer.valueOf("FRIEND_EXT_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(4439519789056L, 33077);
        String[] arrayOfString = l.gUn;
        GMTrace.o(4439519789056L, 33077);
        return arrayOfString;
      }
    });
    gJh.put(Integer.valueOf("QQ_GROUP_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(4434151079936L, 33037);
        String[] arrayOfString = ac.gUn;
        GMTrace.o(4434151079936L, 33037);
        return arrayOfString;
      }
    });
    gJh.put(Integer.valueOf("QQ_LIST_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(4427977064448L, 32991);
        String[] arrayOfString = ae.gUn;
        GMTrace.o(4427977064448L, 32991);
        return arrayOfString;
      }
    });
    gJh.put(Integer.valueOf("INVITEFRIENDOPEN_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(4425695363072L, 32974);
        String[] arrayOfString = r.gUn;
        GMTrace.o(4425695363072L, 32974);
        return arrayOfString;
      }
    });
    gJh.put(Integer.valueOf("GOOGLE_FRIEND_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(4433882644480L, 33035);
        String[] arrayOfString = p.gUn;
        GMTrace.o(4433882644480L, 33035);
        return arrayOfString;
      }
    });
    GMTrace.o(4415629033472L, 32899);
  }
  
  public af()
  {
    GMTrace.i(4413347332096L, 32882);
    this.hCb = new e();
    this.hCc = null;
    this.hCd = new d();
    this.hCe = new f();
    this.hCf = new g();
    this.hCg = new com.tencent.mm.sdk.b.c() {};
    this.hCh = new com.tencent.mm.sdk.b.c() {};
    this.hCi = new com.tencent.mm.sdk.b.c() {};
    this.hCj = new com.tencent.mm.sdk.b.c() {};
    this.hCk = new com.tencent.mm.sdk.b.c() {};
    GMTrace.o(4413347332096L, 32882);
  }
  
  private static af FY()
  {
    GMTrace.i(4413481549824L, 32883);
    af localaf2 = (af)ap.yR().gs(af.class.getName());
    af localaf1 = localaf2;
    if (localaf2 == null)
    {
      localaf1 = new af();
      ap.yR().a(af.class.getName(), localaf1);
    }
    GMTrace.o(4413481549824L, 32883);
    return localaf1;
  }
  
  public static c FZ()
  {
    GMTrace.i(4413615767552L, 32884);
    h.vG().uQ();
    if (FY().hBU == null)
    {
      localObject = FY();
      ap.yY();
      ((af)localObject).hBU = new c(com.tencent.mm.u.c.wO());
    }
    Object localObject = FY().hBU;
    GMTrace.o(4413615767552L, 32884);
    return (c)localObject;
  }
  
  public static i Ga()
  {
    GMTrace.i(4413749985280L, 32885);
    h.vG().uQ();
    if (FY().hBV == null)
    {
      localObject = FY();
      ap.yY();
      ((af)localObject).hBV = new i(com.tencent.mm.u.c.wO());
    }
    Object localObject = FY().hBV;
    GMTrace.o(4413749985280L, 32885);
    return (i)localObject;
  }
  
  public static l Gb()
  {
    GMTrace.i(4413884203008L, 32886);
    h.vG().uQ();
    if (FY().hBW == null)
    {
      localObject = FY();
      ap.yY();
      ((af)localObject).hBW = new l(com.tencent.mm.u.c.wO());
    }
    Object localObject = FY().hBW;
    GMTrace.o(4413884203008L, 32886);
    return (l)localObject;
  }
  
  public static ac Gc()
  {
    GMTrace.i(4414018420736L, 32887);
    h.vG().uQ();
    if (FY().hBX == null)
    {
      localObject = FY();
      ap.yY();
      ((af)localObject).hBX = new ac(com.tencent.mm.u.c.wO());
    }
    Object localObject = FY().hBX;
    GMTrace.o(4414018420736L, 32887);
    return (ac)localObject;
  }
  
  public static r Gd()
  {
    GMTrace.i(4414152638464L, 32888);
    h.vG().uQ();
    if (FY().hBZ == null)
    {
      localObject = FY();
      ap.yY();
      ((af)localObject).hBZ = new r(com.tencent.mm.u.c.wO());
    }
    Object localObject = FY().hBZ;
    GMTrace.o(4414152638464L, 32888);
    return (r)localObject;
  }
  
  public static ae Ge()
  {
    GMTrace.i(4414286856192L, 32889);
    h.vG().uQ();
    if (FY().hBY == null)
    {
      localObject = FY();
      ap.yY();
      ((af)localObject).hBY = new ae(com.tencent.mm.u.c.wO());
    }
    Object localObject = FY().hBY;
    GMTrace.o(4414286856192L, 32889);
    return (ae)localObject;
  }
  
  public static LinkedList<ajj> Gf()
  {
    GMTrace.i(4414555291648L, 32891);
    h.vG().uQ();
    LinkedList localLinkedList = FY().hCc;
    GMTrace.o(4414555291648L, 32891);
    return localLinkedList;
  }
  
  public static void Gg()
  {
    GMTrace.i(4414689509376L, 32892);
    h.vG().uQ();
    FY().hCc = null;
    GMTrace.o(4414689509376L, 32892);
  }
  
  public static p Gh()
  {
    GMTrace.i(4415494815744L, 32898);
    h.vG().uQ();
    if (FY().hCa == null)
    {
      localObject = FY();
      ap.yY();
      ((af)localObject).hCa = new p(com.tencent.mm.u.c.wO());
    }
    Object localObject = FY().hCa;
    GMTrace.o(4415494815744L, 32898);
    return (p)localObject;
  }
  
  public static void f(LinkedList<ajj> paramLinkedList)
  {
    GMTrace.i(4414421073920L, 32890);
    h.vG().uQ();
    FY().hCc = paramLinkedList;
    GMTrace.o(4414421073920L, 32890);
  }
  
  public final void aM(boolean paramBoolean)
  {
    GMTrace.i(4415226380288L, 32896);
    d.c.a(Integer.valueOf(42), this.hCb);
    com.tencent.mm.sdk.b.a.uql.b(this.hCj);
    com.tencent.mm.sdk.b.a.uql.b(this.hCk);
    com.tencent.mm.sdk.b.a.uql.b(this.hCi);
    com.tencent.mm.sdk.b.a.uql.b(this.hCd);
    com.tencent.mm.sdk.b.a.uql.b(this.hCe);
    com.tencent.mm.sdk.b.a.uql.b(this.hCf);
    com.tencent.mm.sdk.b.a.uql.b(this.hCg);
    com.tencent.mm.sdk.b.a.uql.b(this.hCh);
    com.tencent.mm.pluginsdk.l.a.szX = FZ();
    Object localObject = new com.tencent.mm.o.a();
    ((com.tencent.mm.plugin.fts.a.l)h.j(com.tencent.mm.plugin.fts.a.l.class)).registerIndexStorage((com.tencent.mm.plugin.fts.a.g)localObject);
    localObject = new b();
    ((com.tencent.mm.plugin.fts.a.l)h.j(com.tencent.mm.plugin.fts.a.l.class)).registerNativeLogic(9, (com.tencent.mm.plugin.fts.a.i)localObject);
    GMTrace.o(4415226380288L, 32896);
  }
  
  public final void aN(boolean paramBoolean)
  {
    GMTrace.i(4415360598016L, 32897);
    GMTrace.o(4415360598016L, 32897);
  }
  
  public final void eD(int paramInt)
  {
    GMTrace.i(4414957944832L, 32894);
    GMTrace.o(4414957944832L, 32894);
  }
  
  public final void onAccountRelease()
  {
    GMTrace.i(4414823727104L, 32893);
    com.tencent.mm.sdk.b.a.uql.c(this.hCj);
    com.tencent.mm.sdk.b.a.uql.c(this.hCk);
    com.tencent.mm.sdk.b.a.uql.c(this.hCi);
    com.tencent.mm.sdk.b.a.uql.c(this.hCd);
    com.tencent.mm.sdk.b.a.uql.c(this.hCe);
    com.tencent.mm.sdk.b.a.uql.c(this.hCf);
    com.tencent.mm.sdk.b.a.uql.c(this.hCg);
    com.tencent.mm.sdk.b.a.uql.c(this.hCh);
    d.c.aA(Integer.valueOf(42));
    this.hCc = null;
    com.tencent.mm.pluginsdk.l.a.szX = null;
    GMTrace.o(4414823727104L, 32893);
  }
  
  public final HashMap<Integer, g.c> uh()
  {
    GMTrace.i(4415092162560L, 32895);
    HashMap localHashMap = gJh;
    GMTrace.o(4415092162560L, 32895);
    return localHashMap;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelfriend/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */