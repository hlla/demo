package com.tencent.mm.plugin.ext;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import com.jg.JgMethodChecked;
import com.qq.wx.voice.embed.recognizer.Grammar;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.e.a.em;
import com.tencent.mm.e.a.eu;
import com.tencent.mm.e.a.fa;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.c;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.i.a;
import com.tencent.mm.pluginsdk.model.i.b;
import com.tencent.mm.protocal.c.acd;
import com.tencent.mm.protocal.c.bii;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bn;
import com.tencent.mm.u.o;
import com.tencent.mm.y.b.c;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class b
  implements am
{
  private static HashMap<Integer, g.c> gJh;
  public static boolean lom;
  private String gXV;
  m.b lcJ;
  private final long lnW;
  private com.tencent.mm.storage.t lnX;
  private ax lnY;
  private be lnZ;
  private a loa;
  private b lob;
  public HashMap<String, Integer> loc;
  private c.a lod;
  i.a loe;
  private ad lof;
  public LinkedList<String> log;
  private final long loh;
  public ad loi;
  private j.a loj;
  public boolean lok;
  public boolean lol;
  
  static
  {
    GMTrace.i(5717943648256L, 42602);
    int i = com.tencent.mm.compatible.d.l.rl();
    try
    {
      if (!Build.CPU_ABI.contains("armeabi")) {
        v.e("hakon SilkCodec", "x86 machines not supported.");
      }
      for (;;)
      {
        HashMap localHashMap = new HashMap();
        gJh = localHashMap;
        localHashMap.put(Integer.valueOf("OPENMSGLISTENER_TABLE".hashCode()), new g.c()
        {
          public final String[] pP()
          {
            GMTrace.i(5718212083712L, 42604);
            String[] arrayOfString = ax.gUn;
            GMTrace.o(5718212083712L, 42604);
            return arrayOfString;
          }
        });
        gJh.put(Integer.valueOf("USEROPENIDINAPP_TABLE".hashCode()), new g.c()
        {
          public final String[] pP()
          {
            GMTrace.i(5743176581120L, 42790);
            String[] arrayOfString = be.gUn;
            GMTrace.o(5743176581120L, 42790);
            return arrayOfString;
          }
        });
        lom = false;
        GMTrace.o(5717943648256L, 42602);
        return;
        if ((i & 0x400) == 0) {
          break;
        }
        k.b("wechatvoicesilk_v7a", b.class.getClassLoader());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        v.e("hakon SilkCodec", "load library failed!");
        continue;
        if ((i & 0x200) != 0) {
          k.b("wechatvoicesilk", b.class.getClassLoader());
        } else {
          v.e("hakon SilkCodec", "load library failed! silk don't support armv5!!!!");
        }
      }
    }
  }
  
  public b()
  {
    GMTrace.i(5714722422784L, 42578);
    this.lnW = 1600L;
    this.loc = new HashMap();
    this.lod = new c.a()
    {
      public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.c arg1, c.c paramAnonymousc1)
      {
        GMTrace.i(5711366979584L, 42553);
        if ((??? == null) || (paramAnonymousc1 == null) || (paramAnonymousc1.nxo == null))
        {
          v.e("MicroMsg.SubCoreExt", "onMsgChange, wrong args");
          GMTrace.o(5711366979584L, 42553);
          return;
        }
        for (;;)
        {
          int i;
          synchronized (b.this)
          {
            Object localObject = b.aqF().bME();
            if (localObject == null)
            {
              v.i("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange getValidOpenMsgListener cu == null");
              GMTrace.o(5711366979584L, 42553);
              return;
            }
            v.d("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange listener count = %s", new Object[] { Integer.valueOf(((Cursor)localObject).getCount()) });
            if (((Cursor)localObject).getCount() <= 0)
            {
              ((Cursor)localObject).close();
              v.i("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange cu.getCount() <= 0");
              GMTrace.o(5711366979584L, 42553);
              return;
            }
            ((Cursor)localObject).close();
            i = 0;
            if (i < paramAnonymousc1.nxo.size())
            {
              localObject = (au)paramAnonymousc1.nxo.get(i);
              if ((localObject == null) || (((ce)localObject).field_isSend != 0) || (((ce)localObject).field_status == 4) || (((ce)localObject).field_type == 9999) || (((ce)localObject).field_type == 10000) || (o.fF(((ce)localObject).field_talker))) {
                break label405;
              }
              Integer localInteger = (Integer)b.this.loc.get(((ce)localObject).field_talker);
              if (localInteger == null)
              {
                b.this.loc.put(((ce)localObject).field_talker, Integer.valueOf(1));
                v.d("MicroMsg.SubCoreExt", "onMsgChange %s, %d", new Object[] { ((ce)localObject).field_talker, Integer.valueOf(1) });
              }
              else
              {
                b.this.loc.put(((ce)localObject).field_talker, Integer.valueOf(localInteger.intValue() + 1));
                v.d("MicroMsg.SubCoreExt", "onMsgChange %s, %d", new Object[] { ((ce)localObject).field_talker, Integer.valueOf(localInteger.intValue() + 1) });
              }
            }
          }
          if (b.this.loc.size() > 0) {
            b.this.aqJ();
          }
          for (;;)
          {
            GMTrace.o(5711366979584L, 42553);
            return;
            v.i("MicroMsg.SubCoreExt", "notifyMsgUsers.size < 1");
          }
          label405:
          i += 1;
        }
      }
    };
    this.loe = new i.a()
    {
      public final void a(com.tencent.mm.pluginsdk.model.l paramAnonymousl)
      {
        GMTrace.i(5711635415040L, 42555);
        if (paramAnonymousl == null)
        {
          GMTrace.o(5711635415040L, 42555);
          return;
        }
        Object localObject1;
        int i;
        if (paramAnonymousl.lbI == null)
        {
          localObject1 = null;
          localObject1 = ((acd)localObject1).tGe.iterator();
          i = 0;
        }
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label283;
          }
          Object localObject2 = (bii)((Iterator)localObject1).next();
          v.v("MicroMsg.SubCoreExt", "AppId[%s], UserName[%s], Xml[%s]", new Object[] { paramAnonymousl.sAO, ((bii)localObject2).jLx, ((bii)localObject2).ugE });
          if ((!bf.mA(((bii)localObject2).jLx)) && (!bf.mA(((bii)localObject2).ugE)))
          {
            ap.yY();
            Object localObject3 = com.tencent.mm.u.c.wR().QZ(((bii)localObject2).jLx);
            if ((localObject3 == null) || ((int)((com.tencent.mm.j.a)localObject3).gTG <= 0))
            {
              v.e("MicroMsg.SubCoreExt", "contact is null");
              continue;
              localObject1 = (acd)paramAnonymousl.lbI.hrT.hsa;
              break;
            }
            if (((x)localObject3).bKU())
            {
              v.w("MicroMsg.SubCoreExt", "isBizContact");
            }
            else
            {
              localObject3 = com.tencent.mm.pluginsdk.model.i.LQ(((bii)localObject2).ugE);
              if ((localObject3 != null) && (!bf.mA(((i.b)localObject3).sAI)))
              {
                v.v("MicroMsg.SubCoreExt", "AppId[%s], openId[%s]", new Object[] { paramAnonymousl.sAO, ((i.b)localObject3).sAI });
                localObject2 = new bd(paramAnonymousl.sAO, ((bii)localObject2).jLx, ((i.b)localObject3).sAI);
                b.aqG().a((bd)localObject2);
                i = 1;
              }
            }
          }
        }
        label283:
        if (i != 0) {
          b.this.aqJ();
        }
        GMTrace.o(5711635415040L, 42555);
      }
    };
    this.lof = new ad(Looper.getMainLooper())
    {
      @JgMethodChecked(author=20, fComment="checked", lastDate="20140514", reviewer=20, vComment={com.jg.EType.INTENTCHECK})
      public final void handleMessage(Message arg1)
      {
        GMTrace.i(5742371274752L, 42784);
        if ((aa.getContext() == null) || (!ap.zb()))
        {
          v.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong status");
          GMTrace.o(5742371274752L, 42784);
          return;
        }
        Cursor localCursor = b.aqF().bME();
        if (localCursor == null)
        {
          v.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler getValidOpenMsgListener cu == null");
          GMTrace.o(5742371274752L, 42784);
          return;
        }
        v.d("MicroMsg.SubCoreExt", "notifyMsgChangeHandler listener count = %s", new Object[] { Integer.valueOf(localCursor.getCount()) });
        if (localCursor.getCount() <= 0)
        {
          localCursor.close();
          v.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler cu.getCount() <= 0");
          GMTrace.o(5742371274752L, 42784);
          return;
        }
        LinkedList localLinkedList;
        ArrayList localArrayList;
        try
        {
          if (!localCursor.moveToFirst()) {
            break label326;
          }
          HashMap localHashMap = new HashMap();
          synchronized (b.this)
          {
            localHashMap.putAll(b.this.loc);
            b.this.loc.clear();
            localLinkedList = new LinkedList();
            localArrayList = new ArrayList();
            if (localHashMap.entrySet() == null)
            {
              v.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler waitForNotify.entrySet() == null");
              GMTrace.o(5742371274752L, 42784);
              return;
            }
          }
          localaw = new aw();
        }
        catch (Exception ???)
        {
          v.e("MicroMsg.SubCoreExt", "Exception in handleMessage, %s", new Object[] { ???.getMessage() });
          if (localCursor != null) {
            localCursor.close();
          }
          GMTrace.o(5742371274752L, 42784);
          return;
        }
        aw localaw;
        localaw.b(localCursor);
        if ((bf.mA(localaw.field_appId)) || (bf.mA(localaw.field_packageName)))
        {
          v.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong msgListener, appid = %s, package = %s", new Object[] { localaw.field_appId, localaw.field_packageName });
          label317:
          if (!localCursor.moveToNext())
          {
            label326:
            localCursor.close();
            GMTrace.o(5742371274752L, 42784);
          }
        }
        else
        {
          Object localObject2 = ((HashMap)localObject1).entrySet().iterator();
          Object localObject3;
          Object localObject4;
          while (((Iterator)localObject2).hasNext())
          {
            ??? = (Map.Entry)((Iterator)localObject2).next();
            localObject3 = bf.mz((String)???.getKey());
            localObject4 = (Integer)???.getValue();
            ap.yY();
            ??? = com.tencent.mm.u.c.wW().Rl((String)localObject3);
            if ((??? != null) && (!bf.mA(???.field_username)) && (???.field_unReadCount <= 0))
            {
              v.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler no unread in conversation");
            }
            else if ((!o.fF((String)localObject3)) && (!o.dH((String)localObject3)) && (!o.eV((String)localObject3)))
            {
              Object localObject5 = b.aqG();
              ??? = localaw.field_appId;
              if ((??? == null) || (???.length() <= 0) || (localObject3 == null)) {
                break label1150;
              }
              if (((String)localObject3).length() <= 0)
              {
                break label1150;
                label507:
                if ((??? != null) && (!bf.mA(???.field_openId)) && (!bf.mA(???.field_username))) {
                  break label724;
                }
                v.d("MicroMsg.SubCoreExt", "notifyMsgChangeHandler openId is null, go get it.");
                ??? = (Integer)b.this.loc.get(localObject3);
                if (??? != null) {
                  break label695;
                }
                b.this.loc.put(localObject3, localObject4);
              }
              for (;;)
              {
                localLinkedList.add(localObject3);
                break;
                localObject5 = ((be)localObject5).gUp.a("UserOpenIdInApp", null, "appId=? and username=? ", new String[] { bf.my(???), bf.my((String)localObject3) }, null, null, null, 2);
                if (!((Cursor)localObject5).moveToFirst())
                {
                  v.w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with appId-%s, username-%s:", new Object[] { ???, localObject3 });
                  ((Cursor)localObject5).close();
                  ??? = null;
                  break label507;
                }
                ??? = new bd();
                ???.b((Cursor)localObject5);
                ((Cursor)localObject5).close();
                break label507;
                label695:
                b.this.loc.put(localObject3, Integer.valueOf(???.intValue() + ((Integer)localObject4).intValue()));
              }
              label724:
              v.v("MicroMsg.SubCoreExt", "username[%s], appId[%s], openId[%s]", new Object[] { ???.field_username, ???.field_appId, ???.field_openId });
              localArrayList.add(String.format("%s,%s,%s", new Object[] { ???.field_openId, localObject4, Long.valueOf(System.currentTimeMillis() - 1600L) }));
            }
          }
          if (localLinkedList.size() > 0)
          {
            v.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler doGetGetUserInfoInApp");
            localObject4 = b.this;
            ??? = localaw.field_appId;
            if ((!bf.mA(???)) && (localLinkedList.size() > 0))
            {
              localObject2 = com.tencent.mm.pluginsdk.model.i.bCv();
              localObject3 = aa.getContext();
              localObject4 = ((b)localObject4).loe;
              v.d("MicroMsg.GetUserInfoInAppLogic", "getGetUserInfoInApp");
              if (!com.tencent.mm.pluginsdk.model.i.sAF) {
                ((com.tencent.mm.pluginsdk.model.i)localObject2).bCw();
              }
              if ((ap.zb()) && (localObject3 != null))
              {
                if (localLinkedList.size() != 0) {
                  break label940;
                }
                v.d("MicroMsg.GetUserInfoInAppLogic", "userNameList empty");
              }
            }
          }
          while (localArrayList.size() <= 0)
          {
            localCursor.close();
            v.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler userDataList.size() <= 0");
            GMTrace.o(5742371274752L, 42784);
            return;
            label940:
            ((com.tencent.mm.pluginsdk.model.i)localObject2).sAH = ((i.a)localObject4);
            ??? = new com.tencent.mm.pluginsdk.model.l(???, localLinkedList);
            an.aBz();
            com.tencent.mm.pluginsdk.model.app.d.a(14, ???);
          }
          if (localaw.field_status != 1) {
            break label1155;
          }
        }
        label1150:
        label1155:
        for (int i = 1;; i = 0)
        {
          if (i == 0)
          {
            v.w("MicroMsg.SubCoreExt", "invalid msgListener, appid = %s, package = %s", new Object[] { localaw.field_appId, localaw.field_packageName });
            break label317;
          }
          if ((bf.mA(localaw.field_appId)) || (bf.mA(localaw.field_packageName))) {
            break label317;
          }
          v.i("MicroMsg.SubCoreExt", "notify app, appId = %s, package = %s", new Object[] { localaw.field_appId, localaw.field_packageName });
          ??? = new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_NOTIFY_MSG");
          ???.addCategory("com.tencent.mm.category." + localaw.field_packageName);
          com.tencent.mm.compatible.a.a.a(12, new a.a()
          {
            public final void run()
            {
              GMTrace.i(5744250322944L, 42798);
              paramAnonymousMessage.setFlags(32);
              GMTrace.o(5744250322944L, 42798);
            }
          });
          ???.putExtra("EXTRA_EXT_OPEN_NOTIFY_TYPE", "NEW_MESSAGE");
          ???.putStringArrayListExtra("EXTRA_EXT_OPEN_USER_DATA", localArrayList);
          aa.getContext().sendBroadcast(???);
          break label317;
          break;
          ??? = null;
          break label507;
        }
      }
    };
    this.log = new LinkedList();
    this.loh = 60L;
    this.loi = new ad(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(5744518758400L, 42800);
        Object localObject1;
        Object localObject2;
        label142:
        do
        {
          for (;;)
          {
            try
            {
              i = b.this.log.size();
              if (i <= 0)
              {
                GMTrace.o(5744518758400L, 42800);
                return;
              }
              paramAnonymousMessage = b.this.log.iterator();
              if (!paramAnonymousMessage.hasNext()) {
                break label365;
              }
              localObject1 = (String)paramAnonymousMessage.next();
              if ("*".equals(localObject1)) {
                continue;
              }
              localObject2 = com.tencent.mm.pluginsdk.model.app.g.aJ((String)localObject1, false);
              if (localObject2 == null)
              {
                v.w("MicroMsg.SubCoreExt", "appInfo is null");
                continue;
              }
              if (!bf.mA(((com.tencent.mm.pluginsdk.model.app.f)localObject2).field_appId)) {
                break label142;
              }
            }
            catch (Exception paramAnonymousMessage)
            {
              v.e("MicroMsg.SubCoreExt", "exception in onAppInfoStgChange, %s", new Object[] { paramAnonymousMessage.getMessage() });
              GMTrace.o(5744518758400L, 42800);
              return;
            }
            v.w("MicroMsg.SubCoreExt", "appId is null");
            continue;
            v.d("MicroMsg.SubCoreExt", "onAppInfoStgChange, notify[%s], appFlag[%s], id[%s]", new Object[] { localObject1, Integer.valueOf(((com.tencent.mm.pluginsdk.model.app.f)localObject2).field_appInfoFlag), ((com.tencent.mm.pluginsdk.model.app.f)localObject2).field_appId });
            localObject1 = b.aqF().RO(((com.tencent.mm.pluginsdk.model.app.f)localObject2).field_appId);
            if (localObject1 != null) {
              break;
            }
            v.w("MicroMsg.SubCoreExt", "openMsgListener is null, appId = %s", new Object[] { ((com.tencent.mm.pluginsdk.model.app.f)localObject2).field_appId });
          }
          if (!com.tencent.mm.pluginsdk.model.app.g.i((com.tencent.mm.pluginsdk.model.app.f)localObject2)) {
            break;
          }
        } while (((aw)localObject1).field_status == 1);
        ax localax;
        for (((aw)localObject1).field_status = 1;; ((aw)localObject1).field_status = 0)
        {
          localax = b.aqF();
          localObject2 = ((com.tencent.mm.pluginsdk.model.app.f)localObject2).field_appId;
          if ((!bf.mA((String)localObject2)) && (localObject1 != null) && (!bf.mA(((aw)localObject1).field_appId))) {
            break label294;
          }
          v.w("MicroMsg.OpenMsgListenerStorage", "wrong argument");
          break;
          if (((aw)localObject1).field_status == 0) {
            break;
          }
        }
        label294:
        ContentValues localContentValues = ((aw)localObject1).pv();
        if (localContentValues.size() > 0) {}
        for (int i = localax.gUp.update("OpenMsgListener", localContentValues, "appId=?", new String[] { bf.my((String)localObject2) });; i = 0)
        {
          v.d("MicroMsg.OpenMsgListenerStorage", "update: id=%s, ret=%s ", new Object[] { ((aw)localObject1).field_appId, Integer.valueOf(i) });
          break;
          label365:
          b.this.log.clear();
          GMTrace.o(5744518758400L, 42800);
          return;
        }
      }
    };
    this.loj = new j.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.l paramAnonymousl)
      {
        GMTrace.i(5741834403840L, 42780);
        if (!b.this.log.contains(paramAnonymousString)) {
          b.this.log.add(paramAnonymousString);
        }
        b.this.loi.removeMessages(0);
        b.this.loi.sendEmptyMessageDelayed(0, 60L);
        GMTrace.o(5741834403840L, 42780);
      }
    };
    this.lcJ = new m.b()
    {
      public final void a(int paramAnonymousInt, m paramAnonymousm, Object paramAnonymousObject)
      {
        GMTrace.i(5743445016576L, 42792);
        if ((paramAnonymousObject == null) || (!(paramAnonymousObject instanceof String)))
        {
          v.d("MicroMsg.SubCoreExt", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousm, paramAnonymousObject });
          GMTrace.o(5743445016576L, 42792);
          return;
        }
        if (!ap.zb())
        {
          v.i("MicroMsg.SubCoreExt", "onNotifyChange acc not ready");
          GMTrace.o(5743445016576L, 42792);
          return;
        }
        ap.yY();
        if (paramAnonymousm == com.tencent.mm.u.c.wR()) {
          b.this.dL(false);
        }
        GMTrace.o(5743445016576L, 42792);
      }
    };
    this.lok = true;
    this.lol = false;
    GMTrace.o(5714722422784L, 42578);
  }
  
  public static b aqD()
  {
    GMTrace.i(5714856640512L, 42579);
    b localb2 = (b)ap.yR().gs("plugin.ext");
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      ap.yR().a("plugin.ext", localb1);
    }
    GMTrace.o(5714856640512L, 42579);
    return localb1;
  }
  
  public static com.tencent.mm.storage.t aqE()
  {
    GMTrace.i(5714990858240L, 42580);
    h.vG().uQ();
    if (aqD().lnX == null)
    {
      localObject = aqD();
      ap.yY();
      ((b)localObject).lnX = new com.tencent.mm.storage.t(com.tencent.mm.u.c.wO());
    }
    Object localObject = aqD().lnX;
    GMTrace.o(5714990858240L, 42580);
    return (com.tencent.mm.storage.t)localObject;
  }
  
  public static ax aqF()
  {
    GMTrace.i(5715125075968L, 42581);
    h.vG().uQ();
    if (aqD().lnY == null)
    {
      localObject = aqD();
      ap.yY();
      ((b)localObject).lnY = new ax(com.tencent.mm.u.c.wO());
    }
    Object localObject = aqD().lnY;
    GMTrace.o(5715125075968L, 42581);
    return (ax)localObject;
  }
  
  public static be aqG()
  {
    GMTrace.i(5715259293696L, 42582);
    h.vG().uQ();
    if (aqD().lnZ == null)
    {
      localObject = aqD();
      ap.yY();
      ((b)localObject).lnZ = new be(com.tencent.mm.u.c.wO());
    }
    Object localObject = aqD().lnZ;
    GMTrace.o(5715259293696L, 42582);
    return (be)localObject;
  }
  
  public static String aqH()
  {
    GMTrace.i(5715930382336L, 42587);
    String str = aqD().gXV + "image/ext/pcm";
    GMTrace.o(5715930382336L, 42587);
    return str;
  }
  
  public static void aqI()
  {
    GMTrace.i(5716064600064L, 42588);
    Object localObject = (String)aqE().get(w.a.uCN, null);
    v.i("MicroMsg.SubCoreExt", "sendSportBroadcast pkgNames = " + (String)localObject);
    if (localObject != null)
    {
      localObject = ((String)localObject).split(";");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject[i];
        Intent localIntent = new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_SET_SPORT_STEP");
        localIntent.setPackage(str);
        com.tencent.mm.compatible.a.a.a(12, new a.a()
        {
          public final void run()
          {
            GMTrace.i(5742102839296L, 42782);
            this.val$intent.setFlags(32);
            GMTrace.o(5742102839296L, 42782);
          }
        });
        localIntent.putExtra("EXTRA_EXT_OPEN_NOTIFY_TYPE", "SPORT_MESSAGE");
        aa.getContext().sendBroadcast(localIntent);
        i += 1;
      }
    }
    GMTrace.o(5716064600064L, 42588);
  }
  
  public static x bI(long paramLong)
  {
    GMTrace.i(5716333035520L, 42590);
    if ((ap.zb()) && (paramLong > 0L))
    {
      ap.yY();
      x localx = com.tencent.mm.u.c.wR().ez(paramLong);
      GMTrace.o(5716333035520L, 42590);
      return localx;
    }
    GMTrace.o(5716333035520L, 42590);
    return null;
  }
  
  public static void bJ(long paramLong)
  {
    GMTrace.i(5716467253248L, 42591);
    if (paramLong <= 0L)
    {
      GMTrace.o(5716467253248L, 42591);
      return;
    }
    try
    {
      ap.yY();
      if (com.tencent.mm.u.c.wT().cD(paramLong))
      {
        ap.yY();
        com.tencent.mm.plugin.messenger.foundation.a.a.c localc = com.tencent.mm.u.c.wT();
        ap.yY();
        localc.M(com.tencent.mm.u.c.wT().cA(paramLong));
        GMTrace.o(5716467253248L, 42591);
        return;
      }
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.SubCoreExt", localException.getMessage());
      v.printErrStackTrace("MicroMsg.SubCoreExt", localException, "", new Object[0]);
      GMTrace.o(5716467253248L, 42591);
      return;
    }
    v.e("MicroMsg.SubCoreExt", "msgId is out of range, " + paramLong);
    GMTrace.o(5716467253248L, 42591);
  }
  
  public final void aM(boolean paramBoolean)
  {
    GMTrace.i(5715661946880L, 42585);
    Object localObject = new em();
    ((em)localObject).fIf.op = 1;
    if (!com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject)) {
      v.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountPostReset");
    }
    com.tencent.mm.pluginsdk.model.i.bCv().bCw();
    ap.yY();
    com.tencent.mm.u.c.wT().a(this.lod, null);
    if (this.loa == null) {
      this.loa = new a();
    }
    com.tencent.mm.sdk.b.a.uql.b(this.loa);
    if (this.lob == null) {
      this.lob = new b();
    }
    com.tencent.mm.sdk.b.a.uql.b(this.lob);
    localObject = an.aRk();
    if (localObject != null) {
      ((com.tencent.mm.pluginsdk.model.app.i)localObject).c(this.loj);
    }
    localObject = aa.bIO();
    this.lol = ((SharedPreferences)localObject).getBoolean("hasTryToInitVoiceControlData", false);
    lom = ((SharedPreferences)localObject).getBoolean("hasCallVoiceControlApi", false);
    v.i("MicroMsg.SubCoreExt", "onAccountPostReset,hasTryToInit:%s,hasCallApi:%s", new Object[] { Boolean.valueOf(this.lol), Boolean.valueOf(lom) });
    ap.yY();
    com.tencent.mm.u.c.wR().a(this.lcJ);
    dL(true);
    GMTrace.o(5715661946880L, 42585);
  }
  
  public final void aN(boolean paramBoolean)
  {
    GMTrace.i(5715527729152L, 42584);
    ap.yY();
    this.gXV = com.tencent.mm.u.c.xv();
    File localFile = new File(this.gXV);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File(this.gXV + "image/ext/pcm");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    GMTrace.o(5715527729152L, 42584);
  }
  
  public final void aqJ()
  {
    GMTrace.i(5716601470976L, 42592);
    this.lof.removeMessages(0);
    this.lof.sendEmptyMessageDelayed(0, 1600L);
    GMTrace.o(5716601470976L, 42592);
  }
  
  public final void dL(boolean paramBoolean)
  {
    GMTrace.i(5716735688704L, 42593);
    if (!this.lok)
    {
      GMTrace.o(5716735688704L, 42593);
      return;
    }
    if ((paramBoolean) && (this.lol))
    {
      v.i("MicroMsg.SubCoreExt", "fromStartApp and already try to init");
      GMTrace.o(5716735688704L, 42593);
      return;
    }
    if ((!paramBoolean) && (!lom))
    {
      GMTrace.o(5716735688704L, 42593);
      return;
    }
    v.i("MicroMsg.SubCoreExt", "initLocalVoiceControl,fromStartApp:%s,hasTryToInit:%s,hasCallApi:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.lol), Boolean.valueOf(lom) });
    this.lok = false;
    ap.vL().e(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(5742639710208L, 42786);
        Object localObject2;
        int i;
        int j;
        try
        {
          localObject2 = com.tencent.mm.i.g.sV().getValue("VoiceRecognizeSprSoMD5");
          localObject3 = com.tencent.mm.i.g.sV().getValue("VoiceRecognizeSprDataMD5");
          if ((localObject2 == null) || (localObject3 == null))
          {
            v.i("MicroMsg.SubCoreExt", "error mMd5So:%s,  mMd5Data:%s", new Object[] { localObject2, localObject3 });
            b.this.lok = true;
            GMTrace.o(5742639710208L, 42786);
            return;
          }
          Object localObject1 = "/system/lib/";
          if (Build.VERSION.SDK_INT >= 24) {
            localObject1 = "/vendor/lib/";
          }
          v.i("MicroMsg.SubCoreExt", "mMd5So:%s,  mMd5Data:%s,  mSoPath:%s", new Object[] { localObject2, localObject3, localObject1 });
          l = System.currentTimeMillis();
          Object localObject5 = com.qq.wx.voice.embed.recognizer.b.a.aIN;
          Object localObject4 = aa.getContext();
          localObject5 = ((com.qq.wx.voice.embed.recognizer.b)localObject5).aIM;
          if (((com.qq.wx.voice.embed.recognizer.e)localObject5).d) {
            i = 0;
          }
          for (;;)
          {
            localObject1 = aa.bIO();
            v.i("MicroMsg.SubCoreExt", "checkFiles ret:%s,use time:%s", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
            if (i != 0) {
              break label704;
            }
            l = System.currentTimeMillis();
            localObject3 = new LinkedList();
            ((List)localObject3).add("tmessage");
            ((List)localObject3).add("officialaccounts");
            ((List)localObject3).add("helper_entry");
            ap.yY();
            localObject2 = com.tencent.mm.u.c.wZ().AF("@t.qq.com");
            if (localObject2 != null) {
              ((List)localObject3).add(((ay)localObject2).name);
            }
            localObject2 = new ArrayList();
            ap.yY();
            localObject3 = com.tencent.mm.u.c.wR().a("@all.contact.android", null, (List)localObject3, null, true, true);
            if (localObject3 != null) {
              break;
            }
            v.w("MicroMsg.SubCoreExt", "initLocalVoiceControl cu is null");
            b.this.lok = true;
            GMTrace.o(5742639710208L, 42786);
            return;
            j = ((com.qq.wx.voice.embed.recognizer.e)localObject5).aIT.checkFiles((Context)localObject4, (String)localObject1, (String)localObject2, (String)localObject3);
            i = j;
            if (j >= 0)
            {
              ((com.qq.wx.voice.embed.recognizer.e)localObject5).d = true;
              i = 0;
            }
          }
          if (((Cursor)localObject3).moveToFirst()) {
            while (!((Cursor)localObject3).isAfterLast())
            {
              localObject4 = new com.tencent.mm.storage.f();
              ((com.tencent.mm.storage.f)localObject4).b((Cursor)localObject3);
              ((ArrayList)localObject2).add(new com.qq.wx.voice.embed.recognizer.d(((com.tencent.mm.storage.f)localObject4).field_username, ((com.tencent.mm.storage.f)localObject4).field_nickname, ((com.tencent.mm.storage.f)localObject4).field_conRemark));
              ((Cursor)localObject3).moveToNext();
            }
          }
          ((Cursor)localObject3).close();
        }
        catch (Exception localException)
        {
          v.i("MicroMsg.SubCoreExt", "initLocalVoiceControl Exception:%s", new Object[] { localException.getMessage() });
          GMTrace.o(5742639710208L, 42786);
          return;
        }
        v.i("MicroMsg.SubCoreExt", "init cusor,count:%s,use time:%s", new Object[] { Integer.valueOf(((Cursor)localObject3).getCount()), Long.valueOf(System.currentTimeMillis() - l) });
        long l = System.currentTimeMillis();
        Object localObject3 = com.qq.wx.voice.embed.recognizer.b.a.aIN.aIM;
        if (!((com.qq.wx.voice.embed.recognizer.e)localObject3).d) {
          i = 65232;
        }
        for (;;)
        {
          if (i == 0)
          {
            localException.edit().putBoolean("hasInitVoiceControlData", true).putBoolean("hasTryToInitVoiceControlData", true).commit();
            b.this.lol = true;
            label571:
            v.i("MicroMsg.SubCoreExt", "init ret:%s,use time:%s", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
            b.this.lok = true;
          }
          for (;;)
          {
            b.this.lok = true;
            GMTrace.o(5742639710208L, 42786);
            return;
            if (((com.qq.wx.voice.embed.recognizer.e)localObject3).e)
            {
              j = ((com.qq.wx.voice.embed.recognizer.e)localObject3).aIT.update((ArrayList)localObject2);
              i = j;
              if (j < 0) {
                break;
              }
              break label745;
            }
            j = ((com.qq.wx.voice.embed.recognizer.e)localObject3).aIT.init((ArrayList)localObject2);
            i = j;
            if (j < 0) {
              break;
            }
            ((com.qq.wx.voice.embed.recognizer.e)localObject3).e = true;
            break label745;
            localException.edit().putBoolean("hasInitVoiceControlData", false).commit();
            break label571;
            label704:
            localException.edit().putBoolean("hasInitVoiceControlData", false).putBoolean("hasTryToInitVoiceControlData", true).commit();
            b.this.lol = true;
          }
          label745:
          i = 0;
        }
      }
    }, 10000L);
    GMTrace.o(5716735688704L, 42593);
  }
  
  public final void eD(int paramInt)
  {
    GMTrace.i(5716198817792L, 42589);
    GMTrace.o(5716198817792L, 42589);
  }
  
  public final void onAccountRelease()
  {
    GMTrace.i(5715796164608L, 42586);
    if (this.loa != null) {
      com.tencent.mm.sdk.b.a.uql.c(this.loa);
    }
    if (this.lob != null) {
      com.tencent.mm.sdk.b.a.uql.c(this.lob);
    }
    Object localObject = an.aRk();
    if (localObject != null) {
      ((com.tencent.mm.pluginsdk.model.app.i)localObject).f(this.loj);
    }
    ap.yY();
    com.tencent.mm.u.c.wT().a(this.lod);
    localObject = new em();
    ((em)localObject).fIf.op = 2;
    if (!com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject)) {
      v.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountRelease");
    }
    localObject = com.tencent.mm.pluginsdk.model.i.bCv();
    if (ap.zb())
    {
      com.tencent.mm.pluginsdk.model.i.sAF = false;
      an.aBz().b(14, (com.tencent.mm.pluginsdk.model.app.t)localObject);
    }
    this.gXV = "";
    ap.yY();
    com.tencent.mm.u.c.wR().b(this.lcJ);
    GMTrace.o(5715796164608L, 42586);
  }
  
  public final HashMap<Integer, g.c> uh()
  {
    GMTrace.i(5715393511424L, 42583);
    HashMap localHashMap = gJh;
    GMTrace.o(5715393511424L, 42583);
    return localHashMap;
  }
  
  public static final class a
    extends com.tencent.mm.sdk.b.c<eu>
  {
    public a()
    {
      GMTrace.i(5714453987328L, 42576);
      this.uqt = eu.class.getName().hashCode();
      GMTrace.o(5714453987328L, 42576);
    }
  }
  
  public static final class b
    extends com.tencent.mm.sdk.b.c<fa>
  {
    public b()
    {
      super();
      GMTrace.i(5742773927936L, 42787);
      this.uqt = fa.class.getName().hashCode();
      GMTrace.o(5742773927936L, 42787);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/ext/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */