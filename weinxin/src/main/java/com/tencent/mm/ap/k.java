package com.tencent.mm.ap;

import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.fq;
import com.tencent.mm.e.a.kz;
import com.tencent.mm.e.a.kz.a;
import com.tencent.mm.e.a.rd;
import com.tencent.mm.i.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.protocal.c.aoy;
import com.tencent.mm.protocal.c.zt;
import com.tencent.mm.protocal.c.zu;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k.a;
import com.tencent.mm.y.k.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  extends com.tencent.mm.y.k
  implements com.tencent.mm.network.j, com.tencent.mm.y.m
{
  private int fFq;
  private int flags;
  private com.tencent.mm.y.b gUq;
  private com.tencent.mm.y.e gUt;
  private boolean hNT;
  
  public k(int paramInt)
  {
    GMTrace.i(12949863268352L, 96484);
    this.hNT = false;
    this.flags = -1;
    this.fFq = paramInt;
    this.hNT = false;
    v.d("MicroMsg.NetSceneGetPackageList", "Init dkregcode:" + paramInt);
    GMTrace.o(12949863268352L, 96484);
  }
  
  public k(boolean paramBoolean)
  {
    GMTrace.i(12949729050624L, 96483);
    this.hNT = false;
    this.flags = -1;
    this.fFq = 26;
    this.hNT = false;
    v.d("MicroMsg.NetSceneGetPackageList", "Init dkregcode:26");
    v.d("MicroMsg.NetSceneGetPackageList", "isOnlyCheckInReqList: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      this.flags = 1;
    }
    GMTrace.o(12949729050624L, 96483);
  }
  
  private void K(List<aoy> paramList)
  {
    GMTrace.i(12952144969728L, 96501);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      v.d("MicroMsg.NetSceneGetPackageList", "[oneliang]empty update expose scene list");
      GMTrace.o(12952144969728L, 96501);
      return;
    }
    t.Id();
    String str = n.HZ();
    int i = 0;
    if (i < paramList.size())
    {
      aoy localaoy = (aoy)paramList.get(i);
      Object localObject = t.Id().aQ(localaoy.mus, this.fFq);
      m localm;
      if ((localObject == null) || (((m)localObject).version != localaoy.jMp))
      {
        com.tencent.mm.loader.stub.b.deleteFile(str + t.Id().aS(localaoy.mus, this.fFq));
        localm = a(localaoy);
        localm.fRM = -1;
        if (localObject != null) {
          break label231;
        }
        t.Id().a(localm);
      }
      for (;;)
      {
        localObject = new j(localm.id, 19);
        h.vH().gXs.a((com.tencent.mm.y.k)localObject, 0);
        v.d("MicroMsg.NetSceneGetPackageList", "[oneliang]name:%s,packName:%s", new Object[] { localaoy.mqI, localaoy.ttn });
        i += 1;
        break;
        label231:
        t.Id().b(localm);
      }
    }
    GMTrace.o(12952144969728L, 96501);
  }
  
  private void L(List<aoy> paramList)
  {
    GMTrace.i(12952279187456L, 96502);
    if ((paramList == null) || (paramList.size() == 0))
    {
      v.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, package list is empty");
      GMTrace.o(12952279187456L, 96502);
      return;
    }
    v.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, pkgList.size: %d", new Object[] { Integer.valueOf(paramList.size()) });
    int i = ((Integer)h.vI().vr().get(w.a.uzL, Integer.valueOf(-1))).intValue();
    v.d("MicroMsg.NetSceneGetPackageList", "configPkgId: %d", new Object[] { Integer.valueOf(i) });
    if (i == -1)
    {
      GMTrace.o(12952279187456L, 96502);
      return;
    }
    m localm1 = t.Id().aQ(i, this.fFq);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      m localm2 = a((aoy)paramList.next());
      v.d("MicroMsg.NetSceneGetPackageList", "newInfo.id: %d, version: %d", new Object[] { Integer.valueOf(localm2.id), Integer.valueOf(localm2.version) });
      if ((localm1 != null) && (localm2.id == i))
      {
        v.d("MicroMsg.NetSceneGetPackageList", "find match old pkg, update one");
        t.Id().b(localm2);
        GMTrace.o(12952279187456L, 96502);
        return;
      }
      if ((localm1 == null) && (localm2.id == i))
      {
        v.d("MicroMsg.NetSceneGetPackageList", "insert new pkg");
        t.Id().a(localm2);
        GMTrace.o(12952279187456L, 96502);
        return;
      }
    }
    GMTrace.o(12952279187456L, 96502);
  }
  
  private void M(List<aoy> paramList)
  {
    GMTrace.i(12952413405184L, 96503);
    if ((paramList == null) || (paramList.size() == 0))
    {
      v.d("MicroMsg.NetSceneGetPackageList", "update sense where location but package list is empty.");
      GMTrace.o(12952413405184L, 96503);
      return;
    }
    v.i("MicroMsg.NetSceneGetPackageList", "start update sense where location. package list size " + paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (aoy)paramList.next();
      Object localObject1 = t.Id().aQ(((aoy)localObject2).mus, this.fFq);
      if ((localObject1 == null) || (((m)localObject1).version != ((aoy)localObject2).jMp))
      {
        localObject2 = a((aoy)localObject2);
        ((m)localObject2).fRM = -1;
        if (localObject1 == null) {
          t.Id().a((m)localObject2);
        }
        for (;;)
        {
          localObject1 = new j(((m)localObject2).id, 36);
          h.vH().gXs.a((com.tencent.mm.y.k)localObject1, 0);
          break;
          t.Id().b((m)localObject2);
        }
      }
    }
    GMTrace.o(12952413405184L, 96503);
  }
  
  private m a(aoy paramaoy)
  {
    GMTrace.i(12950668574720L, 96490);
    m localm = new m();
    localm.id = paramaoy.mus;
    localm.version = paramaoy.jMp;
    localm.name = paramaoy.mqI;
    localm.size = paramaoy.jMk;
    localm.hNY = paramaoy.ttn;
    localm.status = 5;
    localm.fKC = this.fFq;
    GMTrace.o(12950668574720L, 96490);
    return localm;
  }
  
  private static void b(aoy paramaoy)
  {
    GMTrace.i(12950937010176L, 96492);
    fq localfq = new fq();
    localfq.fKy.fKz = paramaoy;
    com.tencent.mm.sdk.b.a.uql.m(localfq);
    GMTrace.o(12950937010176L, 96492);
  }
  
  private void g(LinkedList<aoy> paramLinkedList)
  {
    GMTrace.i(12951205445632L, 96494);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      v.d("MicroMsg.NetSceneGetPackageList", "empty upload speex config list");
      GMTrace.o(12951205445632L, 96494);
      return;
    }
    t.Id();
    String str = n.HZ();
    int i = 0;
    if (i < paramLinkedList.size())
    {
      aoy localaoy = (aoy)paramLinkedList.get(i);
      Object localObject = t.Id().aQ(localaoy.mus, this.fFq);
      m localm;
      if ((localObject == null) || (((m)localObject).version != localaoy.jMp))
      {
        com.tencent.mm.loader.stub.b.deleteFile(str + t.Id().aS(localaoy.mus, this.fFq));
        localm = a(localaoy);
        localm.fRM = -1;
        if (localObject != null) {
          break label381;
        }
        t.Id().a(localm);
      }
      for (;;)
      {
        localObject = new j(localm.id, 9);
        h.vH().gXs.a((com.tencent.mm.y.k)localObject, 0);
        if (com.tencent.mm.platformtools.n.a(localaoy.tep) != null)
        {
          localObject = new String(com.tencent.mm.platformtools.n.a(localaoy.tep));
          v.v("MicroMsg.NetSceneGetPackageList", "xml:" + (String)localObject);
        }
        if (com.tencent.mm.platformtools.n.a(localaoy.tSp) != null)
        {
          localObject = new String(com.tencent.mm.platformtools.n.a(localaoy.tSp));
          v.v("MicroMsg.NetSceneGetPackageList", "xml2:" + (String)localObject);
        }
        v.v("MicroMsg.NetSceneGetPackageList", "xml3:" + localaoy.toString());
        v.v("MicroMsg.NetSceneGetPackageList", "xml4:" + localaoy.mqI);
        v.v("MicroMsg.NetSceneGetPackageList", "xml5:" + localaoy.ttn);
        i += 1;
        break;
        label381:
        t.Id().b(localm);
      }
    }
    GMTrace.o(12951205445632L, 96494);
  }
  
  private void h(LinkedList<aoy> paramLinkedList)
  {
    GMTrace.i(12951339663360L, 96495);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      v.d("MicroMsg.NetSceneGetPackageList", "empty background pkg list");
      GMTrace.o(12951339663360L, 96495);
      return;
    }
    t.Id();
    String str = n.HZ();
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject1 = (aoy)paramLinkedList.get(i);
      Object localObject2 = t.Id().aQ(((aoy)localObject1).mus, this.fFq);
      m localm;
      if ((localObject2 == null) || (((m)localObject2).version != ((aoy)localObject1).jMp))
      {
        com.tencent.mm.loader.stub.b.deleteFile(str + t.Id().aS(((aoy)localObject1).mus, this.fFq));
        localm = a((aoy)localObject1);
        localm.fRM = -1;
        if (localObject2 != null) {
          break label243;
        }
        t.Id().a(localm);
      }
      for (;;)
      {
        localObject2 = com.tencent.mm.platformtools.n.a(((aoy)localObject1).tep);
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          t.Id();
          localObject1 = n.aR(((aoy)localObject1).mus, this.fFq);
          com.tencent.mm.loader.stub.b.deleteFile(str + (String)localObject1);
          com.tencent.mm.a.e.a(str, (String)localObject1, (byte[])localObject2);
        }
        i += 1;
        break;
        label243:
        t.Id().b(localm);
      }
    }
    GMTrace.o(12951339663360L, 96495);
  }
  
  @Deprecated
  private void i(LinkedList<aoy> paramLinkedList)
  {
    GMTrace.i(12951473881088L, 96496);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      v.d("MicroMsg.NetSceneGetPackageList", "empty emoji pkg list");
      GMTrace.o(12951473881088L, 96496);
      return;
    }
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject1 = (aoy)paramLinkedList.get(i);
      Object localObject2 = t.Id().aQ(((aoy)localObject1).mus, this.fFq);
      m localm = a((aoy)localObject1);
      localm.fRM = -1;
      if (localObject2 == null) {
        t.Id().a(localm);
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.platformtools.n.a(((aoy)localObject1).tep);
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          localObject2 = new ArrayList();
          ((List)localObject2).add(new String((byte[])localObject1));
          ((List)localObject2).size();
        }
        i += 1;
        break;
        t.Id().b(localm);
      }
    }
    GMTrace.o(12951473881088L, 96496);
  }
  
  private void j(LinkedList<aoy> paramLinkedList)
  {
    GMTrace.i(12951608098816L, 96497);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      v.d("MicroMsg.NetSceneGetPackageList", "empty emoji pkg list");
      GMTrace.o(12951608098816L, 96497);
      return;
    }
    v.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + paramLinkedList.size());
    t.Id();
    String str1 = n.HZ();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      aoy localaoy = (aoy)paramLinkedList.get(i);
      m localm = t.Id().aQ(localaoy.mus, this.fFq);
      byte[] arrayOfByte = com.tencent.mm.platformtools.n.a(localaoy.tep);
      if (localaoy.tep == null)
      {
        v.e("MicroMsg.NetSceneGetPackageList", "error give me a null thumb it should be xml");
        i += 1;
      }
      else
      {
        String str2;
        Object localObject;
        if ((localm == null) || (localm.version != localaoy.jMp))
        {
          str2 = new String(arrayOfByte);
          localObject = "zh_CN";
          if (str2.indexOf("zh_CN") >= 0)
          {
            label186:
            str2 = (String)localObject + "_ARTIST.mm";
            com.tencent.mm.loader.stub.b.deleteFile(str1 + str2);
            com.tencent.mm.loader.stub.b.deleteFile(str1 + (String)localObject + "_ARTISTF.mm");
            com.tencent.mm.a.e.a(str1, str2, arrayOfByte);
          }
        }
        else
        {
          localObject = a(localaoy);
          ((m)localObject).fRM = -1;
          if (localm != null) {
            break label401;
          }
          t.Id().a((m)localObject);
        }
        for (;;)
        {
          v.d("MicroMsg.NetSceneGetPackageList", localaoy.mqI + " - " + localaoy.mus + " - " + localaoy.ttn + " - " + localaoy.jMk);
          break;
          localObject = "en";
          if (str2.indexOf("en") >= 0) {
            break label186;
          }
          localObject = "zh_TW";
          if (str2.indexOf("zh_TW") >= 0) {
            break label186;
          }
          localObject = "en";
          break label186;
          label401:
          t.Id().b((m)localObject);
        }
      }
    }
    GMTrace.o(12951608098816L, 96497);
  }
  
  private void k(LinkedList<aoy> paramLinkedList)
  {
    GMTrace.i(12951742316544L, 96498);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      v.d("MicroMsg.NetSceneGetPackageList", "empty config list");
      GMTrace.o(12951742316544L, 96498);
      return;
    }
    v.d("MicroMsg.NetSceneGetPackageList", "updateConfigList pkgList size " + paramLinkedList.size());
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject1 = (aoy)paramLinkedList.get(i);
      Object localObject2 = t.Id().aQ(((aoy)localObject1).mus, this.fFq);
      Object localObject3 = a((aoy)localObject1);
      ((m)localObject3).fRM = -1;
      if (localObject2 == null) {
        t.Id().a((m)localObject3);
      }
      for (;;)
      {
        v.d("MicroMsg.NetSceneGetPackageList", ((aoy)localObject1).mqI + " - " + ((aoy)localObject1).mus + " - " + ((aoy)localObject1).ttn + " - " + ((aoy)localObject1).jMk);
        localObject2 = com.tencent.mm.platformtools.n.a(((aoy)localObject1).tep);
        localObject3 = new String((byte[])localObject2);
        v.d("MicroMsg.NetSceneGetPackageList", "ConfigList xml : " + (String)localObject3);
        localObject3 = ((com.tencent.mm.plugin.zero.b.a)h.h(com.tencent.mm.plugin.zero.b.a.class)).sW();
        int j = ((aoy)localObject1).mus;
        localObject1 = new File(c.gSY);
        if (!((File)localObject1).exists()) {
          ((File)localObject1).mkdir();
        }
        try
        {
          localObject1 = new File(c.er(j));
          if (!((File)localObject1).exists()) {
            ((File)localObject1).createNewFile();
          }
          com.tencent.mm.a.e.b(c.er(j), (byte[])localObject2, localObject2.length);
          ((c)localObject3).l(j, new String((byte[])localObject2));
        }
        catch (Exception localException)
        {
          for (;;)
          {
            v.e("MicroMsg.ConfigListDecoder", "exception:%s", new Object[] { bf.g(localException) });
          }
        }
        i += 1;
        break;
        t.Id().b((m)localObject3);
      }
    }
    GMTrace.o(12951742316544L, 96498);
  }
  
  private void l(LinkedList<aoy> paramLinkedList)
  {
    GMTrace.i(12951876534272L, 96499);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      v.d("MicroMsg.NetSceneGetPackageList", "empty regioncode pkg list");
      GMTrace.o(12951876534272L, 96499);
      return;
    }
    v.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + paramLinkedList.size());
    paramLinkedList = paramLinkedList.iterator();
    if (paramLinkedList.hasNext())
    {
      aoy localaoy = (aoy)paramLinkedList.next();
      m localm1 = t.Id().aQ(localaoy.mus, this.fFq);
      m localm2 = a(localaoy);
      localm2.fRM = -1;
      if (localm1 == null) {
        t.Id().a(localm2);
      }
      for (;;)
      {
        v.d("MicroMsg.NetSceneGetPackageList", localaoy.mqI + " - " + localaoy.mus + " - " + localaoy.ttn + " - " + localaoy.jMk);
        break;
        t.Id().b(localm2);
      }
    }
    GMTrace.o(12951876534272L, 96499);
  }
  
  private void m(LinkedList<aoy> paramLinkedList)
  {
    GMTrace.i(12952010752000L, 96500);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      v.e("MicroMsg.NetSceneGetPackageList", "empty address pkg list");
      GMTrace.o(12952010752000L, 96500);
      return;
    }
    v.i("MicroMsg.NetSceneGetPackageList", "updateRcptAddress pkgList size " + paramLinkedList.size());
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject2 = (aoy)paramLinkedList.get(i);
      Object localObject1 = t.Id().aQ(((aoy)localObject2).mus, this.fFq);
      localObject2 = a((aoy)localObject2);
      ((m)localObject2).fRM = -1;
      if (localObject1 == null) {
        t.Id().a((m)localObject2);
      }
      for (;;)
      {
        localObject1 = new j(((m)localObject2).id, 12);
        h.vH().gXs.a((com.tencent.mm.y.k)localObject1, 0);
        i += 1;
        break;
        t.Id().b((m)localObject2);
      }
    }
    GMTrace.o(12952010752000L, 96500);
  }
  
  private void n(LinkedList<aoy> paramLinkedList)
  {
    GMTrace.i(12952547622912L, 96504);
    v.d("MicroMsg.NetSceneGetPackageList", "updateLangPkg");
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      v.d("MicroMsg.NetSceneGetPackageList", "empty langage package list");
      GMTrace.o(12952547622912L, 96504);
      return;
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject = (aoy)paramLinkedList.next();
      v.d("MicroMsg.NetSceneGetPackageList", "pkg.toString %s", new Object[] { localObject.toString() });
      m localm = t.Id().aQ(((aoy)localObject).mus, this.fFq);
      localObject = a((aoy)localObject);
      ((m)localObject).fRM = -1;
      if (localm == null) {
        t.Id().a((m)localObject);
      } else {
        t.Id().b((m)localObject);
      }
    }
    GMTrace.o(12952547622912L, 96504);
  }
  
  private void o(LinkedList<aoy> paramLinkedList)
  {
    GMTrace.i(12952681840640L, 96505);
    v.d("MicroMsg.NetSceneGetPackageList", "updateAppleEmojiPackage");
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      v.d("MicroMsg.NetSceneGetPackageList", "update apple emoji but package list is empty.");
      GMTrace.o(12952681840640L, 96505);
      return;
    }
    v.i("MicroMsg.NetSceneGetPackageList", "start update apple emoji. package list size " + paramLinkedList.size());
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject2 = (aoy)paramLinkedList.next();
      Object localObject1 = t.Id().aQ(((aoy)localObject2).mus, this.fFq);
      if ((localObject1 == null) || (((m)localObject1).version != ((aoy)localObject2).jMp))
      {
        localObject2 = a((aoy)localObject2);
        ((m)localObject2).fRM = -1;
        if (localObject1 == null) {
          t.Id().a((m)localObject2);
        }
        for (;;)
        {
          localObject1 = new j(((m)localObject2).id, 37);
          h.vH().gXs.a((com.tencent.mm.y.k)localObject1, 0);
          break;
          t.Id().b((m)localObject2);
        }
      }
    }
    GMTrace.o(12952681840640L, 96505);
  }
  
  public final boolean BI()
  {
    GMTrace.i(12950534356992L, 96489);
    GMTrace.o(12950534356992L, 96489);
    return true;
  }
  
  public final int BQ()
  {
    GMTrace.i(12952950276096L, 96507);
    int i = this.fFq;
    GMTrace.o(12952950276096L, 96507);
    return i;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(12949997486080L, 96485);
    this.gUt = parame1;
    v.d("MicroMsg.NetSceneGetPackageList", "DoScene dkregcode :" + this.fFq);
    parame1 = new b.a();
    parame1.hrV = new zt();
    parame1.hrW = new zu();
    parame1.uri = "/cgi-bin/micromsg-bin/getpackagelist";
    parame1.hrU = 159;
    parame1.hrX = 51;
    parame1.hrY = 1000000051;
    this.gUq = parame1.BE();
    parame1 = (zt)this.gUq.hrS.hsa;
    LinkedList localLinkedList = new LinkedList();
    if (!h.vG().uV())
    {
      GMTrace.o(12949997486080L, 96485);
      return -1;
    }
    m[] arrayOfm = t.Id().gl(this.fFq);
    if ((arrayOfm != null) && (arrayOfm.length > 0))
    {
      i = 0;
      if (i < arrayOfm.length)
      {
        aoy localaoy = new aoy();
        localaoy.mus = arrayOfm[i].id;
        if ((r.iis) && (this.fFq == 7)) {
          v.d("MicroMsg.NetSceneGetPackageList", "isShakeGetConfigList");
        }
        for (localaoy.jMp = 0;; localaoy.jMp = arrayOfm[i].version)
        {
          v.d("MicroMsg.NetSceneGetPackageList", "package, id:%d, ver:%d", new Object[] { Integer.valueOf(localaoy.mus), Integer.valueOf(localaoy.jMp) });
          localLinkedList.add(localaoy);
          i += 1;
          break;
        }
      }
    }
    parame1.jLs = localLinkedList;
    parame1.jLr = localLinkedList.size();
    parame1.jMq = this.fFq;
    if (this.flags != -1) {
      parame1.tdn = this.flags;
    }
    int i = a(parame, this.gUq, this);
    GMTrace.o(12949997486080L, 96485);
    return i;
  }
  
  protected final int a(p paramp)
  {
    GMTrace.i(12950131703808L, 96486);
    int i = k.b.hsC;
    GMTrace.o(12950131703808L, 96486);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(12950802792448L, 96491);
    v.d("MicroMsg.NetSceneGetPackageList", "onGYNetEnd, netid:%d, errType:%d, errCode:%d, pkgType:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.fFq), paramString });
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(12950802792448L, 96491);
      return;
    }
    paramp = (zu)((com.tencent.mm.y.b)paramp).hrT.hsa;
    if (paramp.jMq != this.fFq)
    {
      v.e("MicroMsg.NetSceneGetPackageList", "packageType is not consistent, respType = %d", new Object[] { Integer.valueOf(paramp.jMq) });
      this.gUt.a(3, -1, "", this);
      GMTrace.o(12950802792448L, 96491);
      return;
    }
    paramArrayOfByte = paramp.jLs;
    Object localObject1 = new StringBuilder("summer list size:");
    if (paramArrayOfByte == null)
    {
      paramInt1 = 0;
      v.v("MicroMsg.NetSceneGetPackageList", paramInt1 + " packageType: " + this.fFq + " resp.Type: " + paramp.jMq);
      if (this.fFq != 2) {
        break label344;
      }
      i(paramArrayOfByte);
    }
    for (;;)
    {
      localObject1 = new rd();
      ((rd)localObject1).fXV.fXW = paramArrayOfByte;
      ((rd)localObject1).fXV.fFq = this.fFq;
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
      if (paramp.tkt <= 0) {
        break label1824;
      }
      if (a(this.hsm, this.gUt) != -1) {
        break label1848;
      }
      this.gUt.a(3, -1, "doScene failed", this);
      GMTrace.o(12950802792448L, 96491);
      return;
      paramInt1 = paramArrayOfByte.size();
      break;
      label344:
      if (this.fFq == 1)
      {
        h(paramArrayOfByte);
      }
      else if (this.fFq == 4)
      {
        j(paramArrayOfByte);
      }
      else if (this.fFq == 6)
      {
        v.i("MicroMsg.NetSceneGetPackageList", "change new egg.");
      }
      else if (this.fFq == 7)
      {
        k(paramArrayOfByte);
      }
      else
      {
        Object localObject3;
        m localm;
        if (this.fFq == 8)
        {
          if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
          {
            v.d("MicroMsg.NetSceneGetPackageList", "empty regioncode pkg list");
          }
          else
          {
            v.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + paramArrayOfByte.size());
            localObject1 = (aoy)paramArrayOfByte.get(0);
            localObject3 = t.Id().aQ(((aoy)localObject1).mus, this.fFq);
            localm = a((aoy)localObject1);
            localm.fRM = -1;
            if (localObject3 == null) {
              t.Id().a(localm);
            }
            for (;;)
            {
              v.d("MicroMsg.NetSceneGetPackageList", ((aoy)localObject1).mqI + " - " + ((aoy)localObject1).mus + " - " + ((aoy)localObject1).ttn + " - " + ((aoy)localObject1).jMk);
              break;
              t.Id().b(localm);
            }
          }
        }
        else if (this.fFq == 9) {
          g(paramArrayOfByte);
        } else if (this.fFq == 10)
        {
          if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
          {
            v.e("MicroMsg.NetSceneGetPackageList", "empty mass send top config package");
          }
          else
          {
            v.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + paramArrayOfByte.size());
            localObject3 = (aoy)paramArrayOfByte.get(0);
            localObject1 = t.Id().aQ(((aoy)localObject3).mus, this.fFq);
            localObject3 = a((aoy)localObject3);
            ((m)localObject3).fRM = -1;
            if (localObject1 == null) {
              t.Id().a((m)localObject3);
            } else {
              t.Id().b((m)localObject3);
            }
          }
        }
        else if (this.fFq != 11) {
          if (this.fFq == 12)
          {
            m(paramArrayOfByte);
          }
          else if (this.fFq == 5)
          {
            n(paramArrayOfByte);
          }
          else if (this.fFq == 20)
          {
            l(paramArrayOfByte);
          }
          else if (this.fFq == 17)
          {
            if ((paramArrayOfByte == null) || (paramArrayOfByte.size() == 0))
            {
              v.d("MicroMsg.NetSceneGetPackageList", "poi type is null");
            }
            else
            {
              localObject1 = (aoy)paramArrayOfByte.get(0);
              v.d("MicroMsg.NetSceneGetPackageList", ((aoy)localObject1).mqI + " - " + ((aoy)localObject1).mus + " - " + ((aoy)localObject1).ttn + " - " + ((aoy)localObject1).jMk);
              localObject3 = t.Id().aQ(((aoy)localObject1).mus, this.fFq);
              localm = a((aoy)localObject1);
              localm.fRM = -1;
              if (localObject3 == null) {
                t.Id().a(localm);
              }
              for (;;)
              {
                localObject3 = new kz();
                try
                {
                  ((kz)localObject3).fRw.content = com.tencent.mm.platformtools.n.a(((aoy)localObject1).tep);
                  if (((kz)localObject3).fRw.content == null) {
                    break;
                  }
                  com.tencent.mm.sdk.b.a.uql.a((com.tencent.mm.sdk.b.b)localObject3, Looper.getMainLooper());
                }
                catch (Exception localException)
                {
                  v.e("MicroMsg.NetSceneGetPackageList", localException.getMessage());
                }
                t.Id().b(localm);
              }
            }
          }
          else
          {
            Object localObject2;
            if (this.fFq == 18)
            {
              if ((paramArrayOfByte == null) || (paramArrayOfByte.size() == 0))
              {
                v.d("MicroMsg.NetSceneGetPackageList", "feature list type is null");
              }
              else
              {
                localObject2 = (aoy)paramArrayOfByte.get(0);
                v.d("MicroMsg.NetSceneGetPackageList", ((aoy)localObject2).mqI + " - " + ((aoy)localObject2).mus + " - " + ((aoy)localObject2).ttn + " - " + ((aoy)localObject2).jMk + "-" + ((aoy)localObject2).jMp);
                localObject3 = t.Id().aQ(((aoy)localObject2).mus, this.fFq);
                if (localObject3 != null)
                {
                  if (((m)localObject3).version < ((aoy)localObject2).jMp)
                  {
                    v.i("MicroMsg.NetSceneGetPackageList", "Feature List New Version");
                    localObject3 = a((aoy)localObject2);
                    t.Id().b((m)localObject3);
                    b((aoy)localObject2);
                  }
                  else
                  {
                    v.i("MicroMsg.NetSceneGetPackageList", "Feature List Old Version");
                  }
                }
                else
                {
                  v.i("MicroMsg.NetSceneGetPackageList", "Feature List First Time Update");
                  localObject3 = a((aoy)localObject2);
                  t.Id().a((m)localObject3);
                  b((aoy)localObject2);
                }
              }
            }
            else if (this.fFq == 19) {
              K(paramArrayOfByte);
            } else if (this.fFq == 21)
            {
              if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
              {
                v.d("MicroMsg.NetSceneGetPackageList", "summer trace config empty scene list");
              }
              else
              {
                localObject3 = (aoy)paramArrayOfByte.get(0);
                v.d("MicroMsg.NetSceneGetPackageList", "summer getpackage pkg: " + localObject3 + "|id = " + ((aoy)localObject3).mus + "|Name = " + ((aoy)localObject3).mqI + "|PackName = " + ((aoy)localObject3).ttn + "|Size = " + ((aoy)localObject3).jMk + "|Version = " + ((aoy)localObject3).jMp);
                localObject2 = t.Id().aQ(((aoy)localObject3).mus, this.fFq);
                localObject3 = a((aoy)localObject3);
                ((m)localObject3).fRM = -1;
                if (localObject2 == null) {
                  t.Id().a((m)localObject3);
                } else if (((m)localObject2).version < ((m)localObject3).version) {
                  t.Id().b((m)localObject3);
                } else {
                  v.d("MicroMsg.NetSceneGetPackageList", "summer old version [%d] new version[%d], not need update", new Object[] { Integer.valueOf(((m)localObject2).version), Integer.valueOf(((m)localObject3).version) });
                }
              }
            }
            else if (23 == this.fFq)
            {
              if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
              {
                v.d("MicroMsg.NetSceneGetPackageList", "permission tips config is empty");
              }
              else
              {
                localObject3 = (aoy)paramArrayOfByte.get(0);
                v.d("MicroMsg.NetSceneGetPackageList", "permission getpackage pkg: " + localObject3 + "|id = " + ((aoy)localObject3).mus + "|Name = " + ((aoy)localObject3).mqI + "|PackName = " + ((aoy)localObject3).ttn + "|Size = " + ((aoy)localObject3).jMk + "|Version = " + ((aoy)localObject3).jMp);
                localObject2 = t.Id().aQ(((aoy)localObject3).mus, this.fFq);
                localObject3 = a((aoy)localObject3);
                ((m)localObject3).fRM = -1;
                if (localObject2 == null) {
                  t.Id().a((m)localObject3);
                } else if (((m)localObject2).version < ((m)localObject3).version) {
                  t.Id().b((m)localObject3);
                }
              }
            }
            else if (this.fFq == 26) {
              L(paramArrayOfByte);
            } else if (this.fFq == 36) {
              M(paramArrayOfByte);
            } else if (this.fFq == 37) {
              o(paramArrayOfByte);
            }
          }
        }
      }
    }
    label1824:
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(12950802792448L, 96491);
    return;
    label1848:
    GMTrace.o(12950802792448L, 96491);
  }
  
  protected final void a(k.a parama)
  {
    GMTrace.i(12950400139264L, 96488);
    GMTrace.o(12950400139264L, 96488);
  }
  
  protected final boolean b(com.tencent.mm.y.k paramk)
  {
    GMTrace.i(12951071227904L, 96493);
    if (!(paramk instanceof k))
    {
      GMTrace.o(12951071227904L, 96493);
      return true;
    }
    if (this.fFq != ((k)paramk).fFq)
    {
      GMTrace.o(12951071227904L, 96493);
      return true;
    }
    GMTrace.o(12951071227904L, 96493);
    return false;
  }
  
  public final int getType()
  {
    GMTrace.i(12952816058368L, 96506);
    GMTrace.o(12952816058368L, 96506);
    return 159;
  }
  
  protected final int ub()
  {
    GMTrace.i(12950265921536L, 96487);
    GMTrace.o(12950265921536L, 96487);
    return 20;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ap/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */