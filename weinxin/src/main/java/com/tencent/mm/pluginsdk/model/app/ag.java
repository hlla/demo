package com.tencent.mm.pluginsdk.model.app;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.w.a.a;
import com.tencent.mm.plugin.w.a.a.a;
import com.tencent.mm.protocal.c.abm;
import com.tencent.mm.protocal.c.abn;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.aw;
import com.tencent.mm.protocal.c.bqt;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import java.util.Iterator;
import java.util.LinkedList;

public final class ag
  extends w
{
  private int mnt;
  LinkedList<f> sCm;
  private LinkedList<f> sCn;
  private LinkedList<String> sCo;
  
  public ag(String paramString, LinkedList<String> paramLinkedList)
  {
    GMTrace.i(809198682112L, 6029);
    v.i("MicroMsg.NetSceneGetSuggestionAppList", "offset: 0" + ", limit = 20, lang = " + paramString + "installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      v.i("MicroMsg.NetSceneGetSuggestionAppList", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    this.mnt = 3;
    localObject = new b.a();
    ((b.a)localObject).hrV = new abm();
    ((b.a)localObject).hrW = new abn();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getsuggestionapplist";
    ((b.a)localObject).hrU = 409;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.lbI = ((b.a)localObject).BE();
    localObject = (abm)this.lbI.hrS.hsa;
    ((abm)localObject).mqW = 3;
    ((abm)localObject).msV = 0;
    ((abm)localObject).msW = 20;
    ((abm)localObject).msi = paramString;
    paramString = au(paramLinkedList);
    ((abm)localObject).tFC = paramString.size();
    ((abm)localObject).msD = paramString;
    this.sCm = new LinkedList();
    this.sCn = new LinkedList();
    this.sCo = new LinkedList();
    this.sCo.addAll(paramLinkedList);
    GMTrace.o(809198682112L, 6029);
  }
  
  private static void a(f paramf, ati paramati)
  {
    GMTrace.i(809869770752L, 6034);
    paramf.bD(paramati.tcx);
    paramf.field_appIconUrl = paramati.tcy;
    paramf.bC(paramati.tVE);
    paramf.field_appName = paramati.mtr;
    paramf.bE(paramati.tcz);
    paramf.field_appType = paramati.tft;
    paramf.bG(paramati.mrs);
    paramf.field_packageName = paramati.tcA;
    paramf.bH(paramati.tcB);
    if (!bf.mA(paramati.tcB))
    {
      v.i("MicroMsg.NetSceneGetSuggestionAppList", "google play download url is : %s, download flag is %d", new Object[] { paramati.tcB, Integer.valueOf(paramati.tVO) });
      paramf.da(paramati.tVO);
    }
    paramf.bI(paramati.tVL);
    paramf.bJ(paramati.tVM);
    a(paramf, paramati.tcC);
    if ((!bf.mA(paramf.field_appType)) && ((paramf.field_appType.startsWith("1")) || (paramf.field_appType.startsWith("6"))))
    {
      if (!paramf.field_appType.endsWith(",")) {
        paramf.field_appType += ",";
      }
      paramf.field_appType = ("," + paramf.field_appType);
    }
    GMTrace.o(809869770752L, 6034);
  }
  
  private static void a(f paramf, aw paramaw)
  {
    GMTrace.i(810138206208L, 6036);
    paramf.bD(paramaw.tcx);
    paramf.bG(paramaw.mrs);
    paramf.bE(paramaw.tcz);
    paramf.field_appName = paramaw.mtr;
    paramf.field_appIconUrl = paramaw.tcy;
    paramf.bH(paramaw.tcB);
    paramf.gfi = paramaw.tcD;
    paramf.geo = true;
    a(paramf, paramaw.tcC);
    GMTrace.o(810138206208L, 6036);
  }
  
  private static void a(f paramf, bqt parambqt)
  {
    GMTrace.i(810003988480L, 6035);
    v.v("MicroMsg.NetSceneGetSuggestionAppList", "dealYYBDownloadInfos, appId = %s", new Object[] { paramf.field_appId });
    if (parambqt != null)
    {
      paramf.da(parambqt.uni);
      paramf.bM(parambqt.tiS);
      paramf.bN(parambqt.muw);
      paramf.bK(parambqt.unj);
      paramf.bL(parambqt.muy);
      paramf.gfg = parambqt.muz;
      paramf.geo = true;
      paramf.db(parambqt.muA);
      v.i("MicroMsg.NetSceneGetSuggestionAppList", "get yyb download infos:[%d],[%s],[%s],[%s],[%s],[%s],[%d]", new Object[] { Integer.valueOf(parambqt.uni), parambqt.tiS, parambqt.muw, parambqt.unj, parambqt.muy, parambqt.muz, Integer.valueOf(parambqt.muA) });
    }
    GMTrace.o(810003988480L, 6035);
  }
  
  private void a(i parami, LinkedList<aw> paramLinkedList)
  {
    GMTrace.i(809467117568L, 6031);
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      Iterator localIterator = paramLinkedList.iterator();
      if (localIterator.hasNext())
      {
        aw localaw = (aw)localIterator.next();
        paramLinkedList = g.aJ(localaw.mqG, true);
        if (paramLinkedList != null)
        {
          a(paramLinkedList, localaw);
          parami.a(paramLinkedList, new String[0]);
        }
        for (;;)
        {
          this.sCn.add(paramLinkedList);
          break;
          paramLinkedList = new f();
          paramLinkedList.field_appId = localaw.mqG;
          a(paramLinkedList, localaw);
          parami.l(paramLinkedList);
        }
      }
    }
    GMTrace.o(809467117568L, 6031);
  }
  
  private static LinkedList<avu> au(LinkedList<String> paramLinkedList)
  {
    GMTrace.i(809735553024L, 6033);
    LinkedList localLinkedList = new LinkedList();
    if (paramLinkedList == null)
    {
      GMTrace.o(809735553024L, 6033);
      return localLinkedList;
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      String str = (String)paramLinkedList.next();
      if (!bf.mA(str)) {
        localLinkedList.add(com.tencent.mm.platformtools.n.mw(str));
      }
    }
    GMTrace.o(809735553024L, 6033);
    return localLinkedList;
  }
  
  private void b(i parami, LinkedList<ati> paramLinkedList)
  {
    GMTrace.i(809601335296L, 6032);
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        ati localati = (ati)localIterator.next();
        if (bf.mA(localati.mqG))
        {
          v.e("MicroMsg.NetSceneGetSuggestionAppList", "error appinfo, the appid is null");
        }
        else
        {
          boolean bool1 = true;
          boolean bool3 = false;
          paramLinkedList = g.aJ(localati.mqG, true);
          if (paramLinkedList != null)
          {
            a(paramLinkedList, localati);
            if (this.mnt == 3)
            {
              paramLinkedList.field_status = 5;
              if ((bf.mA(paramLinkedList.gfa)) || (bf.mA(paramLinkedList.geZ))) {
                if (paramLinkedList.gfa != null)
                {
                  bool1 = true;
                  label137:
                  if (paramLinkedList.geZ == null) {
                    break label261;
                  }
                  bool2 = true;
                  label147:
                  v.e("MicroMsg.NetSceneGetSuggestionAppList", "wrong suggestion params1, has IntroUrl %s, has IconUrl %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                  bool1 = false;
                  bool2 = false;
                }
              }
            }
            for (;;)
            {
              v.i("MicroMsg.NetSceneGetSuggestionAppList", "update appinfo: AppID = %s, ret = %s, needAddToList = %s", new Object[] { localati.mqG, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
              label214:
              if ((!bool1) || (this.sCo.contains(localati.mqG)) || (this.sCm.contains(paramLinkedList))) {
                break label427;
              }
              this.sCm.add(paramLinkedList);
              break;
              bool1 = false;
              break label137;
              label261:
              bool2 = false;
              break label147;
              bool2 = parami.a(paramLinkedList, new String[0]);
              bool1 = true;
            }
          }
          paramLinkedList = new f();
          paramLinkedList.field_appId = localati.mqG;
          a(paramLinkedList, localati);
          if (this.mnt == 3)
          {
            paramLinkedList.field_status = 5;
            if ((bf.mA(paramLinkedList.gfa)) || (bf.mA(paramLinkedList.geZ))) {
              if (paramLinkedList.gfa != null)
              {
                bool1 = true;
                label348:
                if (paramLinkedList.geZ == null) {
                  break label434;
                }
                bool2 = true;
                label358:
                v.e("MicroMsg.NetSceneGetSuggestionAppList", "wrong suggestion params2, has IntroUrl %s, has IconUrl %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                bool1 = false;
              }
            }
          }
          for (boolean bool2 = bool3;; bool2 = parami.l(paramLinkedList))
          {
            v.i("MicroMsg.NetSceneGetSuggestionAppList", "insert appinfo: AppID = %s, ret = %s, needAddToList = %s", new Object[] { localati.mqG, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
            break label214;
            label427:
            break;
            bool1 = false;
            break label348;
            label434:
            bool2 = false;
            break label358;
          }
        }
      }
    }
    GMTrace.o(809601335296L, 6032);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(809332899840L, 6030);
    v.i("MicroMsg.NetSceneGetSuggestionAppList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      v.e("MicroMsg.NetSceneGetSuggestionAppList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
      GMTrace.o(809332899840L, 6030);
      return;
    }
    paramString = (abn)this.lbI.hrT.hsa;
    if (paramString == null)
    {
      v.e("MicroMsg.NetSceneGetSuggestionAppList", "resp == null");
      GMTrace.o(809332899840L, 6030);
      return;
    }
    v.v("MicroMsg.NetSceneGetSuggestionAppList", "suggestion app count = %s, appType = %s, ", new Object[] { Integer.valueOf(paramString.tFD), Integer.valueOf(this.mnt) });
    paramp = a.a.aRo().aRm();
    b(paramp, paramString.tFE);
    a(paramp, paramString.mtI);
    GMTrace.o(809332899840L, 6030);
  }
  
  public final byte[] aBo()
  {
    GMTrace.i(810272423936L, 6037);
    try
    {
      byte[] arrayOfByte = ((b.b)this.lbI.BG()).zh();
      GMTrace.o(810272423936L, 6037);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.NetSceneGetSuggestionAppList", localException.getMessage());
      v.printErrStackTrace("MicroMsg.NetSceneGetSuggestionAppList", localException, "", new Object[0]);
      GMTrace.o(810272423936L, 6037);
    }
    return null;
  }
  
  public final void ar(byte[] paramArrayOfByte)
  {
    GMTrace.i(810406641664L, 6038);
    if (paramArrayOfByte == null)
    {
      v.e("MicroMsg.NetSceneGetSuggestionAppList", "buf is null");
      GMTrace.o(810406641664L, 6038);
      return;
    }
    b.c localc = this.lbI.hrT;
    try
    {
      localc.y(paramArrayOfByte);
      GMTrace.o(810406641664L, 6038);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      v.e("MicroMsg.NetSceneGetSuggestionAppList", paramArrayOfByte.getMessage());
      v.printErrStackTrace("MicroMsg.NetSceneGetSuggestionAppList", paramArrayOfByte, "", new Object[0]);
      GMTrace.o(810406641664L, 6038);
    }
  }
  
  public final int getType()
  {
    GMTrace.i(810540859392L, 6039);
    GMTrace.o(810540859392L, 6039);
    return 4;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */