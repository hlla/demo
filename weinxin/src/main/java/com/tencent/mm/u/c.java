package com.tencent.mm.u;

import android.content.SharedPreferences;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g.a;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.kernel.e.a;
import com.tencent.mm.kernel.e.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.u;
import com.tencent.mm.storage.w;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class c
{
  public static HashMap<Integer, g.c> gJh;
  com.tencent.mm.storage.l hkA;
  com.tencent.mm.u.b.b hkB;
  public bi hks;
  public bh hkt;
  com.tencent.mm.storage.h hku;
  com.tencent.mm.u.b.c hkv;
  com.tencent.mm.u.b.d hkw;
  com.tencent.mm.storage.ap hkx;
  com.tencent.mm.storage.j hky;
  com.tencent.mm.storage.n hkz;
  
  static
  {
    GMTrace.i(679947010048L, 5066);
    HashMap localHashMap = new HashMap();
    gJh = localHashMap;
    localHashMap.put(Integer.valueOf("BOTTLE_MESSAGE_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(617535766528L, 4601);
        String[] arrayOfString = am.gUn;
        GMTrace.o(617535766528L, 4601);
        return arrayOfString;
      }
    });
    gJh.put(Integer.valueOf("APPBRAND_MESSAGE_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(628004749312L, 4679);
        String[] arrayOfString = com.tencent.mm.storage.h.gUn;
        GMTrace.o(628004749312L, 4679);
        return arrayOfString;
      }
    });
    gJh.put(Integer.valueOf("AddContactAntispamTicket".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(647332102144L, 4823);
        String[] arrayOfString = com.tencent.mm.storage.g.gUn;
        GMTrace.o(647332102144L, 4823);
        return arrayOfString;
      }
    });
    gJh.put(Integer.valueOf("GetSysCmdMsgInfo".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(680215445504L, 5068);
        String[] arrayOfString = com.tencent.mm.storage.ap.gUn;
        GMTrace.o(680215445504L, 5068);
        return arrayOfString;
      }
    });
    gJh.put(Integer.valueOf("BackupMoveTime".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(670283333632L, 4994);
        String[] arrayOfString = com.tencent.mm.storage.j.gUn;
        GMTrace.o(670283333632L, 4994);
        return arrayOfString;
      }
    });
    gJh.put(Integer.valueOf("BackupTempMoveTime".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(622770257920L, 4640);
        String[] arrayOfString = com.tencent.mm.storage.n.gUn;
        GMTrace.o(622770257920L, 4640);
        return arrayOfString;
      }
    });
    gJh.put(Integer.valueOf("BackupRecoverMsgListDataId".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(625320394752L, 4659);
        String[] arrayOfString = com.tencent.mm.storage.l.gUn;
        GMTrace.o(625320394752L, 4659);
        return arrayOfString;
      }
    });
    GMTrace.o(679947010048L, 5066);
  }
  
  public c()
  {
    GMTrace.i(670820204544L, 4998);
    com.tencent.mm.kernel.h.vJ();
    ??? = com.tencent.mm.kernel.h.vI();
    Object localObject2 = new g.a()
    {
      public final void vA()
      {
        GMTrace.i(686523678720L, 5115);
        GMTrace.o(686523678720L, 5115);
      }
      
      public final void vy()
      {
        GMTrace.i(686255243264L, 5113);
        com.tencent.mm.kernel.h.vJ();
        if (com.tencent.mm.kernel.h.vG().uV())
        {
          com.tencent.mm.modelstat.l locall = com.tencent.mm.modelstat.p.Ki();
          if (locall != null)
          {
            v.i("MicroMsg.AccountStorage", "summer preCloseCallback netStatStg: " + locall);
            long l = System.currentTimeMillis();
            locall.hWF.jS(true);
            v.i("MicroMsg.NetStat", "summer net appendAllToDisk end takes: " + (System.currentTimeMillis() - l) + " ms");
          }
        }
        GMTrace.o(686255243264L, 5113);
      }
      
      public final void vz()
      {
        GMTrace.i(686389460992L, 5114);
        GMTrace.o(686389460992L, 5114);
      }
    };
    ((com.tencent.mm.kernel.e)???).gXQ.bI(localObject2);
    com.tencent.mm.kernel.h.vJ();
    ??? = com.tencent.mm.kernel.h.vI();
    localObject2 = new com.tencent.mm.kernel.api.b()
    {
      public final List<String> collectStoragePaths()
      {
        GMTrace.i(644916183040L, 4805);
        LinkedList localLinkedList = new LinkedList();
        Collections.addAll(localLinkedList, new String[] { "image/shakeTranImg/", "emoji/", "locallog", "mailapp/", "mailapp/", "voice2/", "video/", "attachment/" });
        GMTrace.o(644916183040L, 4805);
        return localLinkedList;
      }
    };
    ((com.tencent.mm.kernel.e)???).gXP.bI(localObject2);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vI().a(new com.tencent.mm.kernel.api.g()
    {
      public final void aR(boolean paramAnonymousBoolean)
      {
        GMTrace.i(641963393024L, 4783);
        if (paramAnonymousBoolean) {
          com.tencent.mm.q.c.uk().s(262145, false);
        }
        GMTrace.o(641963393024L, 4783);
      }
      
      public final void eg(String paramAnonymousString)
      {
        GMTrace.i(642366046208L, 4786);
        if (com.tencent.mm.compatible.util.f.rZ())
        {
          com.tencent.mm.kernel.h.vJ();
          if (com.tencent.mm.kernel.h.vI().gXU.equals(com.tencent.mm.compatible.util.e.hgk))
          {
            com.tencent.mm.kernel.h.vJ();
            com.tencent.mm.sdk.f.e.post(new c.b(com.tencent.mm.kernel.h.vI().cachePath, paramAnonymousString), "AccountStorage_moveDataFiles");
          }
        }
        GMTrace.o(642366046208L, 4786);
      }
      
      public final void onDataBaseClosed(com.tencent.mm.bj.g paramAnonymousg1, com.tencent.mm.bj.g paramAnonymousg2)
      {
        GMTrace.i(642500263936L, 4787);
        GMTrace.o(642500263936L, 4787);
      }
      
      public final void onDataBaseOpened(com.tencent.mm.bj.g paramAnonymousg1, com.tencent.mm.bj.g paramAnonymousg2)
      {
        GMTrace.i(642097610752L, 4784);
        GMTrace.o(642097610752L, 4784);
      }
      
      public final void vB()
      {
        GMTrace.i(642231828480L, 4785);
        ap.yR().aN(com.tencent.mm.compatible.util.f.rZ());
        ap.yX();
        GMTrace.o(642231828480L, 4785);
      }
    });
    com.tencent.mm.kernel.h.vJ();
    localObject2 = com.tencent.mm.kernel.h.vI();
    com.tencent.mm.kernel.api.a local7 = new com.tencent.mm.kernel.api.a()
    {
      public final HashMap<Integer, g.c> collectDatabaseFactory()
      {
        GMTrace.i(629078491136L, 4687);
        v.i("MicroMsg.AccountStorage", "Carl WTF --- collectDatabaseFactory ");
        HashMap localHashMap = new HashMap();
        localHashMap.putAll(c.gJh);
        localHashMap.putAll(ap.yR().zS());
        GMTrace.o(629078491136L, 4687);
        return localHashMap;
      }
    };
    synchronized (((com.tencent.mm.kernel.e)localObject2).gXS)
    {
      ((com.tencent.mm.kernel.e)localObject2).gXS.add(local7);
      GMTrace.o(670820204544L, 4998);
      return;
    }
  }
  
  public static void a(al paramal)
  {
    GMTrace.i(671893946368L, 5006);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.a locala = com.tencent.mm.kernel.h.vG();
    v.i("MMKernel.CoreAccount", "UserStatusChange: add %s", new Object[] { paramal });
    synchronized (locala.gXc)
    {
      if (!locala.gXc.contains(paramal)) {
        locala.gXc.add(paramal);
      }
      GMTrace.o(671893946368L, 5006);
      return;
    }
  }
  
  public static void b(al paramal)
  {
    GMTrace.i(672028164096L, 5007);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.a locala = com.tencent.mm.kernel.h.vG();
    v.i("MMKernel.CoreAccount", "UserStatusChange: remove %s", new Object[] { paramal });
    synchronized (locala.gXc)
    {
      locala.gXc.remove(paramal);
      GMTrace.o(672028164096L, 5007);
      return;
    }
  }
  
  public static void eD(int paramInt)
  {
    GMTrace.i(678604832768L, 5056);
    ap.yR().fl(paramInt);
    if ((paramInt & 0x10) != 0)
    {
      ay.a("medianote", null);
      ap.yY();
      wW().Rk("medianote");
    }
    GMTrace.o(678604832768L, 5056);
  }
  
  public static boolean eN(int paramInt)
  {
    GMTrace.i(672430817280L, 5010);
    boolean bool = com.tencent.mm.kernel.a.eN(paramInt);
    GMTrace.o(672430817280L, 5010);
    return bool;
  }
  
  public static SharedPreferences ef(String paramString)
  {
    GMTrace.i(672967688192L, 5014);
    com.tencent.mm.kernel.h.vJ();
    paramString = com.tencent.mm.kernel.h.vI().ef(paramString);
    GMTrace.o(672967688192L, 5014);
    return paramString;
  }
  
  public static String getAccSnsPath()
  {
    GMTrace.i(677128437760L, 5045);
    String str = ((com.tencent.mm.plugin.sns.b.b)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsPath();
    GMTrace.o(677128437760L, 5045);
    return str;
  }
  
  public static String getAccSnsTmpPath()
  {
    GMTrace.i(677262655488L, 5046);
    String str = ((com.tencent.mm.plugin.sns.b.b)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsTmpPath();
    GMTrace.o(677262655488L, 5046);
    return str;
  }
  
  public static String getAccVideoPath()
  {
    GMTrace.i(676054695936L, 5037);
    com.tencent.mm.modelvideo.o.KV();
    String str = com.tencent.mm.modelvideo.o.getAccVideoPath();
    GMTrace.o(676054695936L, 5037);
    return str;
  }
  
  public static boolean isSDCardAvailable()
  {
    GMTrace.i(671491293184L, 5003);
    com.tencent.mm.kernel.h.vJ();
    boolean bool = com.tencent.mm.kernel.h.vI().isSDCardAvailable();
    GMTrace.o(671491293184L, 5003);
    return bool;
  }
  
  public static int uH()
  {
    GMTrace.i(670954422272L, 4999);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vG();
    int i = com.tencent.mm.kernel.a.uH();
    GMTrace.o(670954422272L, 4999);
    return i;
  }
  
  public static void uR()
  {
    GMTrace.i(672162381824L, 5008);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vG().uR();
    GMTrace.o(672162381824L, 5008);
  }
  
  public static String vn()
  {
    GMTrace.i(671625510912L, 5004);
    com.tencent.mm.kernel.h.vJ();
    String str = com.tencent.mm.kernel.h.vI().vn();
    GMTrace.o(671625510912L, 5004);
    return str;
  }
  
  public static String vo()
  {
    GMTrace.i(677799526400L, 5050);
    com.tencent.mm.kernel.h.vJ();
    String str = com.tencent.mm.kernel.h.vI().vo();
    GMTrace.o(677799526400L, 5050);
    return str;
  }
  
  public static String vp()
  {
    GMTrace.i(677933744128L, 5051);
    com.tencent.mm.kernel.h.vJ();
    String str = com.tencent.mm.kernel.h.vI().vp();
    GMTrace.o(677933744128L, 5051);
    return str;
  }
  
  public static t vr()
  {
    GMTrace.i(673101905920L, 5015);
    com.tencent.mm.kernel.h.vJ();
    t localt = com.tencent.mm.kernel.h.vI().vr();
    GMTrace.o(673101905920L, 5015);
    return localt;
  }
  
  public static ba vs()
  {
    GMTrace.i(673236123648L, 5016);
    com.tencent.mm.kernel.h.vJ();
    ba localba = com.tencent.mm.kernel.h.vI().vs();
    GMTrace.o(673236123648L, 5016);
    return localba;
  }
  
  public static void vt()
  {
    GMTrace.i(671222857728L, 5001);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vI().vt();
    GMTrace.o(671222857728L, 5001);
  }
  
  public static String wK()
  {
    GMTrace.i(671088640000L, 5000);
    com.tencent.mm.kernel.h.vJ();
    String str = com.tencent.mm.kernel.h.vI().gXU;
    GMTrace.o(671088640000L, 5000);
    return str;
  }
  
  public static void wL()
  {
    GMTrace.i(671759728640L, 5005);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vI().cQ(null);
    GMTrace.o(671759728640L, 5005);
  }
  
  public static boolean wM()
  {
    GMTrace.i(672296599552L, 5009);
    com.tencent.mm.kernel.h.vJ();
    boolean bool = com.tencent.mm.kernel.a.eN(com.tencent.mm.kernel.h.vG().gXa);
    GMTrace.o(672296599552L, 5009);
    return bool;
  }
  
  public static int wN()
  {
    GMTrace.i(672565035008L, 5011);
    com.tencent.mm.kernel.h.vJ();
    int i = com.tencent.mm.kernel.h.vG().gXb;
    GMTrace.o(672565035008L, 5011);
    return i;
  }
  
  public static com.tencent.mm.bj.g wO()
  {
    GMTrace.i(672699252736L, 5012);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.bj.g localg = com.tencent.mm.kernel.h.vI().gXW;
    GMTrace.o(672699252736L, 5012);
    return localg;
  }
  
  public static com.tencent.mm.bj.g wP()
  {
    GMTrace.i(672833470464L, 5013);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.bj.g localg = com.tencent.mm.kernel.h.vI().gXX;
    GMTrace.o(672833470464L, 5013);
    return localg;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.d wQ()
  {
    GMTrace.i(673370341376L, 5017);
    com.tencent.mm.plugin.messenger.foundation.a.a.d locald = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wQ();
    GMTrace.o(673370341376L, 5017);
    return locald;
  }
  
  public static ar wR()
  {
    GMTrace.i(673504559104L, 5018);
    ar localar = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR();
    GMTrace.o(673504559104L, 5018);
    return localar;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.g wS()
  {
    GMTrace.i(673638776832L, 5019);
    com.tencent.mm.plugin.messenger.foundation.a.a.g localg = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wS();
    GMTrace.o(673638776832L, 5019);
    return localg;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.c wT()
  {
    GMTrace.i(673772994560L, 5020);
    com.tencent.mm.plugin.messenger.foundation.a.a.c localc = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ();
    GMTrace.o(673772994560L, 5020);
    return localc;
  }
  
  public static com.tencent.mm.storage.o wU()
  {
    GMTrace.i(14456994136064L, 107713);
    com.tencent.mm.storage.o localo = ((com.tencent.mm.modelbiz.n)com.tencent.mm.kernel.h.h(com.tencent.mm.modelbiz.n.class)).wU();
    GMTrace.o(14456994136064L, 107713);
    return localo;
  }
  
  public static com.tencent.mm.storage.p wV()
  {
    GMTrace.i(14457128353792L, 107714);
    com.tencent.mm.storage.p localp = ((com.tencent.mm.modelbiz.n)com.tencent.mm.kernel.h.h(com.tencent.mm.modelbiz.n.class)).wV();
    GMTrace.o(14457128353792L, 107714);
    return localp;
  }
  
  public static com.tencent.mm.storage.as wW()
  {
    GMTrace.i(673907212288L, 5021);
    com.tencent.mm.storage.as localas = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW();
    GMTrace.o(673907212288L, 5021);
    return localas;
  }
  
  public static com.tencent.mm.plugin.downloader.b.b wX()
  {
    GMTrace.i(17957795135488L, 133796);
    com.tencent.mm.plugin.downloader.b.b localb = ((com.tencent.mm.plugin.downloader.a.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.downloader.a.a.class)).wX();
    GMTrace.o(17957795135488L, 133796);
    return localb;
  }
  
  public static at wY()
  {
    GMTrace.i(17443741237248L, 129966);
    at localat = ((com.tencent.mm.plugin.r.a.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.r.a.a.class)).wY();
    GMTrace.o(17443741237248L, 129966);
    return localat;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.f wZ()
  {
    GMTrace.i(674309865472L, 5024);
    com.tencent.mm.plugin.messenger.foundation.a.a.f localf = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wZ();
    GMTrace.o(674309865472L, 5024);
    return localf;
  }
  
  public static com.tencent.mm.storage.g xB()
  {
    GMTrace.i(679007485952L, 5059);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vG().uQ();
    com.tencent.mm.storage.g localg = com.tencent.mm.plugin.d.a.Pk().xB();
    GMTrace.o(679007485952L, 5059);
    return localg;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.b xC()
  {
    GMTrace.i(679141703680L, 5060);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vG().uQ();
    com.tencent.mm.plugin.messenger.foundation.a.a.b localb = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).xC();
    GMTrace.o(679141703680L, 5060);
    return localb;
  }
  
  public static aa xa()
  {
    GMTrace.i(17957929353216L, 133797);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vG().uQ();
    aa localaa = ((com.tencent.mm.plugin.chatroom.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa();
    GMTrace.o(17957929353216L, 133797);
    return localaa;
  }
  
  public static String xb()
  {
    GMTrace.i(674578300928L, 5026);
    String str = com.tencent.mm.plugin.n.b.xb();
    GMTrace.o(674578300928L, 5026);
    return str;
  }
  
  public static String xc()
  {
    GMTrace.i(674712518656L, 5027);
    String str = com.tencent.mm.plugin.n.b.xc();
    GMTrace.o(674712518656L, 5027);
    return str;
  }
  
  public static String xd()
  {
    GMTrace.i(674980954112L, 5029);
    String str = com.tencent.mm.plugin.ab.a.xd();
    GMTrace.o(674980954112L, 5029);
    return str;
  }
  
  public static String xe()
  {
    GMTrace.i(675115171840L, 5030);
    String str = q.xe();
    GMTrace.o(675115171840L, 5030);
    return str;
  }
  
  public static String xf()
  {
    GMTrace.i(675249389568L, 5031);
    String str = q.xf();
    GMTrace.o(675249389568L, 5031);
    return str;
  }
  
  public static String xg()
  {
    GMTrace.i(675383607296L, 5032);
    String str = com.tencent.mm.plugin.record.b.xg();
    GMTrace.o(675383607296L, 5032);
    return str;
  }
  
  public static String xh()
  {
    GMTrace.i(675517825024L, 5033);
    String str = u.xh();
    GMTrace.o(675517825024L, 5033);
    return str;
  }
  
  public static String xi()
  {
    GMTrace.i(675786260480L, 5035);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.vJ();
    localObject = com.tencent.mm.kernel.h.vI().gXV + "emoji/";
    GMTrace.o(675786260480L, 5035);
    return (String)localObject;
  }
  
  public static String xj()
  {
    GMTrace.i(675920478208L, 5036);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.vJ();
    localObject = com.tencent.mm.kernel.h.vI().gXV + "mailapp/";
    GMTrace.o(675920478208L, 5036);
    return (String)localObject;
  }
  
  public static String xk()
  {
    GMTrace.i(676188913664L, 5038);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.vJ();
    localObject = com.tencent.mm.kernel.h.vI().gXV + "image/shakeTranImg/";
    GMTrace.o(676188913664L, 5038);
    return (String)localObject;
  }
  
  public static String xl()
  {
    GMTrace.i(676323131392L, 5039);
    String str = com.tencent.mm.plugin.l.a.xl();
    GMTrace.o(676323131392L, 5039);
    return str;
  }
  
  public static String xm()
  {
    GMTrace.i(676457349120L, 5040);
    String str = com.tencent.mm.plugin.w.a.xm();
    GMTrace.o(676457349120L, 5040);
    return str;
  }
  
  public static String xn()
  {
    GMTrace.i(676591566848L, 5041);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.vJ();
    localObject = com.tencent.mm.kernel.h.vI().gXV + "attachment/";
    GMTrace.o(676591566848L, 5041);
    return (String)localObject;
  }
  
  public static String xo()
  {
    GMTrace.i(676725784576L, 5042);
    String str = ((com.tencent.mm.modelbiz.n)com.tencent.mm.kernel.h.h(com.tencent.mm.modelbiz.n.class)).xo();
    GMTrace.o(676725784576L, 5042);
    return str;
  }
  
  public static String xp()
  {
    GMTrace.i(676860002304L, 5043);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.vJ();
    localObject = com.tencent.mm.kernel.h.vI().gXV + "record/";
    GMTrace.o(676860002304L, 5043);
    return (String)localObject;
  }
  
  public static String xq()
  {
    GMTrace.i(676994220032L, 5044);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.vJ();
    localObject = com.tencent.mm.kernel.h.vI().gXV + "draft/";
    GMTrace.o(676994220032L, 5044);
    return (String)localObject;
  }
  
  public static String xr()
  {
    GMTrace.i(677396873216L, 5047);
    String str = com.tencent.mm.plugin.n.b.xr();
    GMTrace.o(677396873216L, 5047);
    return str;
  }
  
  public static String xs()
  {
    GMTrace.i(677531090944L, 5048);
    Object localObject = new StringBuilder();
    ap.yY();
    localObject = xv() + "voiceremind/";
    GMTrace.o(677531090944L, 5048);
    return (String)localObject;
  }
  
  public static String xt()
  {
    GMTrace.i(677665308672L, 5049);
    Object localObject = new StringBuilder();
    ap.yY();
    localObject = xv() + "wenote/";
    GMTrace.o(677665308672L, 5049);
    return (String)localObject;
  }
  
  public static String xu()
  {
    GMTrace.i(678067961856L, 5052);
    com.tencent.mm.kernel.h.vJ();
    String str = com.tencent.mm.kernel.h.vI().cachePath;
    GMTrace.o(678067961856L, 5052);
    return str;
  }
  
  public static String xv()
  {
    GMTrace.i(678202179584L, 5053);
    com.tencent.mm.kernel.h.vJ();
    String str = com.tencent.mm.kernel.h.vI().gXV;
    GMTrace.o(678202179584L, 5053);
    return str;
  }
  
  public static void xx()
  {
    GMTrace.i(678470615040L, 5055);
    GMTrace.o(678470615040L, 5055);
  }
  
  public final com.tencent.mm.u.b.b xA()
  {
    GMTrace.i(16260209311744L, 121148);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vG().uQ();
    com.tencent.mm.u.b.b localb = this.hkB;
    GMTrace.o(16260209311744L, 121148);
    return localb;
  }
  
  public final com.tencent.mm.storage.ap xD()
  {
    GMTrace.i(679275921408L, 5061);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vG().uQ();
    com.tencent.mm.storage.ap localap = this.hkx;
    GMTrace.o(679275921408L, 5061);
    return localap;
  }
  
  public final com.tencent.mm.storage.j xE()
  {
    GMTrace.i(17958063570944L, 133798);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vG().uQ();
    com.tencent.mm.storage.j localj = this.hky;
    GMTrace.o(17958063570944L, 133798);
    return localj;
  }
  
  public final com.tencent.mm.storage.n xF()
  {
    GMTrace.i(17958197788672L, 133799);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vG().uQ();
    com.tencent.mm.storage.n localn = this.hkz;
    GMTrace.o(17958197788672L, 133799);
    return localn;
  }
  
  public final com.tencent.mm.storage.l xG()
  {
    GMTrace.i(17958332006400L, 133800);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vG().uQ();
    com.tencent.mm.storage.l locall = this.hkA;
    GMTrace.o(17958332006400L, 133800);
    return locall;
  }
  
  public final void xw()
  {
    GMTrace.i(678336397312L, 5054);
    Object localObject = new StringBuilder("mm");
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vG();
    String str1 = com.tencent.mm.a.g.n(com.tencent.mm.kernel.a.uH().getBytes());
    localObject = w.hgg + str1 + "/";
    str1 = com.tencent.mm.compatible.util.e.hgk + str1 + "/";
    String[] arrayOfString = new File((String)localObject).list(new FilenameFilter()
    {
      public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        GMTrace.i(615656718336L, 4587);
        if ((paramAnonymousString.equals("EnMicroMsg.db")) || (paramAnonymousString.startsWith("EnMicroMsg.dberr")) || (paramAnonymousString.equals("FTS5IndexMicroMsg.db")))
        {
          GMTrace.o(615656718336L, 4587);
          return true;
        }
        GMTrace.o(615656718336L, 4587);
        return false;
      }
    });
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str2 = arrayOfString[i];
      String str3 = str1 + str2 + ".dump";
      FileOp.deleteFile(str3);
      FileOp.p((String)localObject + str2, str3);
      v.i("MicroMsg.AccountStorage", "Exported: " + str3);
      i += 1;
    }
    GMTrace.o(678336397312L, 5054);
  }
  
  public final com.tencent.mm.u.b.c xy()
  {
    GMTrace.i(678739050496L, 5057);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vG().uQ();
    com.tencent.mm.u.b.c localc = this.hkv;
    GMTrace.o(678739050496L, 5057);
    return localc;
  }
  
  public final com.tencent.mm.u.b.d xz()
  {
    GMTrace.i(678873268224L, 5058);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vG().uQ();
    com.tencent.mm.u.b.d locald = this.hkw;
    GMTrace.o(678873268224L, 5058);
    return locald;
  }
  
  public static abstract interface a
  {
    public abstract void a(c paramc, boolean paramBoolean);
    
    public abstract void aN(boolean paramBoolean);
    
    public abstract void xH();
  }
  
  static final class b
    implements Runnable
  {
    String fTc;
    String hkD;
    
    public b(String paramString1, String paramString2)
    {
      GMTrace.i(617938419712L, 4604);
      this.fTc = paramString1;
      this.hkD = paramString2;
      GMTrace.o(617938419712L, 4604);
    }
    
    public final void run()
    {
      GMTrace.i(618072637440L, 4605);
      if ((bf.mA(this.fTc)) || (bf.mA(this.hkD)))
      {
        GMTrace.o(618072637440L, 4605);
        return;
      }
      v.d("MicroMsg.AccountStorage", "MoveDataFiles :" + this.fTc + " to :" + this.hkD);
      if (!com.tencent.mm.compatible.util.f.rZ())
      {
        GMTrace.o(618072637440L, 4605);
        return;
      }
      if (!this.hkD.substring(0, com.tencent.mm.compatible.util.e.hgk.length()).equals(com.tencent.mm.compatible.util.e.hgk))
      {
        GMTrace.o(618072637440L, 4605);
        return;
      }
      com.tencent.mm.sdk.platformtools.j.p(this.fTc + "image/", this.hkD + "image/", true);
      com.tencent.mm.sdk.platformtools.j.p(this.fTc + "image2/", this.hkD + "image2/", true);
      com.tencent.mm.sdk.platformtools.j.p(this.fTc + "video/", this.hkD + "video/", true);
      com.tencent.mm.sdk.platformtools.j.p(this.fTc + "voice/", this.hkD + "voice/", true);
      com.tencent.mm.sdk.platformtools.j.p(this.fTc + "voice2/", this.hkD + "voice2/", true);
      com.tencent.mm.sdk.platformtools.j.p(this.fTc + "package/", this.hkD + "package/", true);
      com.tencent.mm.sdk.platformtools.j.p(this.fTc + "emoji/", this.hkD + "emoji/", true);
      com.tencent.mm.sdk.platformtools.j.p(this.fTc + "mailapp/", this.hkD + "mailapp/", true);
      com.tencent.mm.sdk.platformtools.j.p(this.fTc + "brandicon/", this.hkD + "brandicon/", true);
      GMTrace.o(618072637440L, 4605);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */