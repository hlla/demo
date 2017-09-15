package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.w.a.a;
import com.tencent.mm.plugin.w.a.a.a;
import com.tencent.mm.protocal.c.abn;
import com.tencent.mm.protocal.c.ajw;
import com.tencent.mm.protocal.c.ajx;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ao
  implements t, com.tencent.mm.y.e
{
  private static ao sCO;
  public String lang;
  public boolean sCP;
  public boolean sCQ;
  private List<String> sCR;
  public long sCS;
  private final int sCT;
  public int sCU;
  public long sCV;
  
  private ao()
  {
    GMTrace.i(833089437696L, 6207);
    this.sCP = false;
    this.sCQ = false;
    this.sCR = new LinkedList();
    this.sCT = 20;
    this.sCU = 0;
    GMTrace.o(833089437696L, 6207);
  }
  
  private static void a(f paramf, ajx paramajx)
  {
    GMTrace.i(834028961792L, 6214);
    paramf.field_appName = paramajx.tof;
    paramf.field_appName_en = paramajx.tLQ;
    paramf.field_appName_tw = paramajx.tLR;
    paramf.field_appName_hk = paramajx.tMc;
    paramf.gfk = paramajx.tLS;
    paramf.geo = true;
    paramf.gfl = paramajx.tLT;
    paramf.geo = true;
    paramf.gfm = paramajx.tLW;
    paramf.geo = true;
    paramf.field_serviceAppInfoFlag = paramajx.tLV;
    paramf.field_serviceAppType = paramajx.tLU;
    paramf.gfn = paramajx.tLX;
    paramf.geo = true;
    paramf.field_serviceShowFlag = paramajx.tLY;
    GMTrace.o(834028961792L, 6214);
  }
  
  private static void a(i parami, List<String> paramList)
  {
    GMTrace.i(833894744064L, 6213);
    if ((parami == null) || (paramList == null) || (paramList.size() <= 0))
    {
      GMTrace.o(833894744064L, 6213);
      return;
    }
    v.d("MicroMsg.SuggestionAppListLogic", "removeExpiredServiceApp");
    Object localObject1 = new ArrayList();
    if (a.a.aRo() == null)
    {
      v.e("MicroMsg.AppInfoLogic", "getAllServices, getISubCorePluginBase() == null");
      v.d("MicroMsg.SuggestionAppListLogic", "oldList %d", new Object[] { Integer.valueOf(((List)localObject1).size()) });
      if (((List)localObject1).size() <= 0) {
        break label302;
      }
      localObject1 = ((List)localObject1).iterator();
    }
    label108:
    label302:
    label315:
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (f)((Iterator)localObject1).next();
        if (((f)localObject2).field_appId != null)
        {
          localObject3 = paramList.iterator();
          String str;
          do
          {
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            str = (String)((Iterator)localObject3).next();
          } while (!((f)localObject2).field_appId.equals(str));
        }
      }
      else
      {
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label315;
          }
          boolean bool = parami.b((f)localObject2, new String[0]);
          v.d("MicroMsg.SuggestionAppListLogic", "delete old service : %s, %s", new Object[] { ((f)localObject2).field_appId, Boolean.valueOf(bool) });
          break label108;
          localObject2 = a.a.aRo().aRn();
          if (localObject2 == null) {
            break;
          }
          while (((Cursor)localObject2).moveToNext())
          {
            localObject3 = new f();
            ((f)localObject3).b((Cursor)localObject2);
            if (!bf.mA(((f)localObject3).field_openId)) {
              ((List)localObject1).add(localObject3);
            }
          }
          ((Cursor)localObject2).close();
          break;
          GMTrace.o(833894744064L, 6213);
          return;
        }
      }
    }
  }
  
  public static ao bDf()
  {
    GMTrace.i(833223655424L, 6208);
    if (sCO == null) {
      sCO = new ao();
    }
    ao localao = sCO;
    GMTrace.o(833223655424L, 6208);
    return localao;
  }
  
  public static void cx(String paramString, int paramInt)
  {
    GMTrace.i(833626308608L, 6211);
    v.i("MicroMsg.SuggestionAppListLogic", "get service app, offset = %d, lang = %s", new Object[] { Integer.valueOf(paramInt), paramString });
    paramString = new af(paramInt, paramString);
    ap.vd().a(paramString, 0);
    GMTrace.o(833626308608L, 6211);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, w paramw)
  {
    GMTrace.i(833357873152L, 6209);
    if (!ap.zb())
    {
      GMTrace.o(833357873152L, 6209);
      return;
    }
    this.sCP = false;
    v.d("MicroMsg.SuggestionAppListLogic", "Suggestion onSceneEnd errType=%s errCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramw == null)
    {
      v.e("MicroMsg.SuggestionAppListLogic", "scene == null");
      GMTrace.o(833357873152L, 6209);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    switch (paramw.getType())
    {
    default: 
      GMTrace.o(833357873152L, 6209);
      return;
    }
    paramString = (ag)paramw;
    v.d("MicroMsg.SuggestionAppListLogic", "get suggestion appList, AppCount = %s", new Object[] { Integer.valueOf(((abn)paramString.lbI.hrT.hsa).tFD) });
    paramString = paramString.sCm;
    if ((paramString == null) || (paramString.size() <= 0))
    {
      v.w("MicroMsg.SuggestionAppListLogic", "empty suggestAppList");
      GMTrace.o(833357873152L, 6209);
      return;
    }
    if ((aa.getContext() == null) || (a.a.aRo() == null))
    {
      v.e("MicroMsg.SuggestionAppListLogic", "wrong environment");
      GMTrace.o(833357873152L, 6209);
      return;
    }
    paramw = new LinkedList();
    Object localObject1 = paramString.iterator();
    f localf;
    Object localObject2;
    Object localObject3;
    if (((Iterator)localObject1).hasNext())
    {
      localf = (f)((Iterator)localObject1).next();
      localObject2 = localf.field_appName;
      localObject3 = localf.field_packageName;
      String str1 = localf.field_signature;
      String str2 = localf.gfa;
      if (localf.geZ != null) {}
      for (boolean bool = true;; bool = false)
      {
        v.d("MicroMsg.SuggestionAppListLogic", "suggestion appName=%s, packageName=%s, signature [%s], introUrl [%s], has iconUrl [%s]", new Object[] { localObject2, localObject3, str1, str2, Boolean.valueOf(bool) });
        paramw.add(localf.field_appId);
        break;
      }
    }
    a.a.aRo().Z(paramw);
    localObject1 = g.dy(aa.getContext());
    if (((List)localObject1).size() > 0)
    {
      paramw = a.a.aRo().aRm();
      localObject1 = ((List)localObject1).iterator();
    }
    label567:
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localf = (f)((Iterator)localObject1).next();
        if (localf.field_appId != null)
        {
          localObject2 = paramString.iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject3 = (f)((Iterator)localObject2).next();
          } while ((((f)localObject3).field_appId == null) || (!localf.field_appId.equals(((f)localObject3).field_appId)));
        }
      }
      else
      {
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 != 0) {
            break label567;
          }
          if (g.a(aa.getContext(), localf)) {}
          for (localf.field_status = 1;; localf.field_status = 4)
          {
            paramw.a(localf, new String[0]);
            break;
          }
          ap.yY();
          c.vr().setLong(352275, System.currentTimeMillis());
          this.sCS = System.currentTimeMillis();
          break;
        }
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(833760526336L, 6212);
    if (!ap.zb())
    {
      v.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd account not ready");
      this.sCU = 0;
      this.sCR.clear();
      GMTrace.o(833760526336L, 6212);
      return;
    }
    this.sCQ = false;
    if (paramk == null)
    {
      v.e("MicroMsg.SuggestionAppListLogic", "scene == null");
      this.sCU = 0;
      this.sCR.clear();
      GMTrace.o(833760526336L, 6212);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      v.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      this.sCU = 0;
      this.sCR.clear();
      GMTrace.o(833760526336L, 6212);
      return;
    }
    v.i("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = (af)paramk;
    if ((paramString.gUq != null) && (paramString.gUq.hrT.hsa != null)) {}
    for (paramString = (ajw)paramString.gUq.hrT.hsa; paramString == null; paramString = null)
    {
      v.e("MicroMsg.SuggestionAppListLogic", "resp == null");
      this.sCU = 0;
      this.sCR.clear();
      GMTrace.o(833760526336L, 6212);
      return;
    }
    if ((paramString.tLP == null) || (paramString.tLP.size() <= 0))
    {
      v.e("MicroMsg.SuggestionAppListLogic", "Service_appinfo empty");
      a(a.a.aRo().aRm(), this.sCR);
      this.sCU = 0;
      this.sCR.clear();
      ap.yY();
      c.vr().setLong(352276, System.currentTimeMillis());
      this.sCV = System.currentTimeMillis();
      GMTrace.o(833760526336L, 6212);
      return;
    }
    v.i("MicroMsg.SuggestionAppListLogic", "offset = %d, count = %s", new Object[] { Integer.valueOf(this.sCU), Integer.valueOf(paramString.tLP.size()) });
    i locali = a.a.aRo().aRm();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramString.tLP.iterator();
    label617:
    label1150:
    while (localIterator.hasNext())
    {
      ajx localajx = (ajx)localIterator.next();
      v.v("MicroMsg.SuggestionAppListLogic", "service info: %s, %s, %s, %s, %s, %s", new Object[] { localajx.tof, Integer.valueOf(localajx.tLU), Integer.valueOf(localajx.tLY), Integer.valueOf(localajx.tLX), Integer.valueOf(localajx.tLV), localajx.fTE });
      if (!bf.mA(localajx.fTE))
      {
        if (f.sBA.equals(localajx.fTE))
        {
          localajx.tLV = (localajx.tLV ^ 0xFD ^ 0xFFFFFFFF);
          v.d("MicroMsg.SuggestionAppListLogic", "aa change: %s", new Object[] { Integer.valueOf(localajx.tLV) });
        }
        this.sCR.add(localajx.fTE);
        f localf = g.aJ(localajx.fTE, true);
        boolean bool;
        if (localf != null) {
          if (localf.field_serviceAppInfoFlag != localajx.tLV)
          {
            paramInt1 = 1;
            paramk = localf;
            if (paramInt1 != 0)
            {
              paramk = localf.gfl;
              String str = localf.gfk;
              a(localf, localajx);
              bool = locali.a(localf, new String[0]);
              if (!bf.mz(paramk).equals(bf.mz(localajx.tLT)))
              {
                v.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_list" + bf.mz(localajx.tLT));
                an.aRi().cu(localf.field_appId, 5);
              }
              if (!bf.mz(str).equals(bf.mz(localajx.tLS)))
              {
                v.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_panel" + bf.mz(localajx.tLS));
                an.aRi().cu(localf.field_appId, 4);
              }
              v.i("MicroMsg.SuggestionAppListLogic", "update app: AppID = %s, ret = %s", new Object[] { localajx.fTE, Boolean.valueOf(bool) });
              paramk = localf;
            }
          }
        }
        for (;;)
        {
          if (!bf.mA(paramk.field_openId)) {
            break label1150;
          }
          localLinkedList.add(localajx.fTE);
          break;
          if (localf.field_serviceAppType != localajx.tLU)
          {
            paramInt1 = 1;
            break label617;
          }
          if (localf.gfn != localajx.tLX)
          {
            paramInt1 = 1;
            break label617;
          }
          if (localf.field_serviceShowFlag != localajx.tLY)
          {
            paramInt1 = 1;
            break label617;
          }
          if (!bf.mz(localf.field_appName).equals(bf.mz(localajx.tof)))
          {
            paramInt1 = 1;
            break label617;
          }
          if (!bf.mz(localf.field_appName_en).equals(bf.mz(localajx.tLQ)))
          {
            paramInt1 = 1;
            break label617;
          }
          if (!bf.mz(localf.field_appName_tw).equals(bf.mz(localajx.tLR)))
          {
            paramInt1 = 1;
            break label617;
          }
          if (!bf.mz(localf.field_appName_hk).equals(bf.mz(localajx.tMc)))
          {
            paramInt1 = 1;
            break label617;
          }
          if (!bf.mz(localf.gfl).equals(bf.mz(localajx.tLT)))
          {
            paramInt1 = 1;
            break label617;
          }
          if (!bf.mz(localf.gfk).equals(bf.mz(localajx.tLS)))
          {
            paramInt1 = 1;
            break label617;
          }
          if (!bf.mz(localf.gfm).equals(bf.mz(localajx.tLW)))
          {
            paramInt1 = 1;
            break label617;
          }
          paramInt1 = 0;
          break label617;
          paramk = new f();
          paramk.field_appId = localajx.fTE;
          a(paramk, localajx);
          bool = locali.l(paramk);
          v.i("MicroMsg.SuggestionAppListLogic", "insert app: AppID = %s, ret = %s", new Object[] { localajx.fTE, Boolean.valueOf(bool) });
        }
      }
    }
    if (localLinkedList.size() > 0)
    {
      v.d("MicroMsg.SuggestionAppListLogic", "needGetOpenIdList %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
      an.aRl().bQ(localLinkedList);
    }
    if (paramString.tLP.size() == 20)
    {
      this.sCU += 20;
      cx(this.lang, this.sCU);
    }
    for (;;)
    {
      ap.yY();
      c.vr().setLong(352276, System.currentTimeMillis());
      this.sCV = System.currentTimeMillis();
      GMTrace.o(833760526336L, 6212);
      return;
      a(locali, this.sCR);
      this.sCU = 0;
      this.sCR.clear();
    }
  }
  
  public final void dA(Context paramContext)
  {
    GMTrace.i(833492090880L, 6210);
    if (!ap.zb())
    {
      GMTrace.o(833492090880L, 6210);
      return;
    }
    if (paramContext == null)
    {
      GMTrace.o(833492090880L, 6210);
      return;
    }
    if (this.sCQ)
    {
      v.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
      GMTrace.o(833492090880L, 6210);
      return;
    }
    this.sCQ = true;
    if (this.lang == null) {
      this.lang = u.d(paramContext.getSharedPreferences(aa.bIN(), 0));
    }
    v.i("MicroMsg.SuggestionAppListLogic", "getServiceAppListImmediately");
    cx(this.lang, this.sCU);
    GMTrace.o(833492090880L, 6210);
  }
  
  public final void reset()
  {
    GMTrace.i(14281571565568L, 106406);
    v.i("MicroMsg.SuggestionAppListLogic", "reset getServiceAppList");
    ap.yY();
    c.vr().setLong(352276, 0L);
    this.sCV = 0L;
    GMTrace.o(14281571565568L, 106406);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */