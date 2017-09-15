package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.ad;
import com.tencent.mm.e.a.pq;
import com.tencent.mm.e.a.qe;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.l.a;
import com.tencent.mm.pluginsdk.l.m;
import com.tencent.mm.pluginsdk.l.n;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.al;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.b.b.b;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.AbstractTabChildActivity.a;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.a;
import com.tencent.mm.ui.q;
import com.tencent.mm.x.d.a;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class j
  extends AbstractTabChildActivity.a
  implements i.a
{
  public int[] qBU;
  public g vZM;
  public ListView vZj;
  public a wbW;
  TextView wce;
  private i wcf;
  public c wcg;
  private m wch;
  private k wci;
  
  public j()
  {
    GMTrace.i(3437316014080L, 25610);
    this.wbW = new a();
    this.wcf = new i();
    this.wcg = new c();
    this.wch = new m();
    this.wci = new k();
    this.qBU = new int[2];
    GMTrace.o(3437316014080L, 25610);
  }
  
  public final boolean WV()
  {
    GMTrace.i(3437718667264L, 25613);
    GMTrace.o(3437718667264L, 25613);
    return true;
  }
  
  public final void bOX()
  {
    GMTrace.i(3442282070016L, 25647);
    v.i("MicroMsg.MainUI", "dkinit onTabSwitchIn");
    i locali = this.wcf;
    int i;
    if (locali.isb == null) {
      i = -1;
    }
    for (;;)
    {
      v.i("MicroMsg.InitHelper", "onTabSwitchIn tip:%d initscene:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(locali.bYx()) });
      if (locali.wakeLock != null) {
        locali.bYv();
      }
      if (this.uRf != null) {
        this.uRf.onResume();
      }
      GMTrace.o(3442282070016L, 25647);
      return;
      if (locali.isb.isShowing()) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  protected final void bOb()
  {
    GMTrace.i(3440671457280L, 25635);
    v.i("MicroMsg.MainUI", "onTabCreate, %d", new Object[] { Integer.valueOf(hashCode()) });
    if (this.uRf != null) {
      this.uRf.ag(4, false);
    }
    v.i("MicroMsg.MainUI", "mainUIOnCreate");
    long l = System.currentTimeMillis();
    setMenuVisibility(true);
    ap.vL().bJa();
    v.i("MicroMsg.MainUI", "main ui init view");
    if (this.vZj != null)
    {
      this.vZj.setAdapter(null);
      localObject1 = this.wbW;
      if (((a)localObject1).vZj != null)
      {
        ((a)localObject1).cR(((a)localObject1).vZc);
        ((a)localObject1).cR(((a)localObject1).vZd);
        ((a)localObject1).cR(((a)localObject1).vZe);
        ((a)localObject1).cR(((a)localObject1).vZf);
        localObject2 = ((a)localObject1).vZg.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (com.tencent.mm.pluginsdk.ui.b.b)((Iterator)localObject2).next();
          if ((localObject3 != null) && (((com.tencent.mm.pluginsdk.ui.b.b)localObject3).getView() != null)) {
            ((a)localObject1).vZj.removeFooterView(((com.tencent.mm.pluginsdk.ui.b.b)localObject3).getView());
          }
        }
      }
    }
    this.wce = ((TextView)findViewById(R.h.bLH));
    this.vZj = ((ListView)findViewById(R.h.cgG));
    this.vZj.setDrawingCacheEnabled(false);
    this.vZj.setScrollingCacheEnabled(false);
    this.vZM = new g(this.uRf.uRz, new com.tencent.mm.ui.e.a()
    {
      public final void OI()
      {
        GMTrace.i(14481019109376L, 107892);
        j.this.wcg.bYl();
        g localg;
        if (j.this.vZM != null)
        {
          localg = j.this.vZM;
          if ((localg.vtF != null) && (localg.wbd != null) && (!localg.wbd.isEmpty())) {}
        }
        else
        {
          j.this.vZj.post(new Runnable()
          {
            public final void run()
            {
              int i = 1;
              GMTrace.i(3388058107904L, 25243);
              j localj = j.this;
              int j = j.this.vZM.getCount();
              v.i("MicroMsg.MainUI", "summerinit setShowView count[%d], stack[%s]", new Object[] { Integer.valueOf(j), u.ND() });
              if (j <= 0)
              {
                a locala = localj.wbW;
                if (locala.context == null) {
                  break label219;
                }
                v.i("MicroMsg.BannerHelper", "checkBannerEmpyt %d", new Object[] { Integer.valueOf(locala.hashCode()) });
                if ((locala.j(locala.vZc, false)) || (locala.j(locala.vZd, false)) || (locala.j(locala.vZe, false)) || (locala.j(locala.vZf, false))) {
                  break label219;
                }
              }
              for (;;)
              {
                if (i != 0)
                {
                  localj.wce.setVisibility(0);
                  localj.vZj.setVisibility(8);
                }
                localj.vZj.setVisibility(0);
                localj.wce.setVisibility(8);
                j.this.wbW.bYi();
                com.tencent.mm.plugin.report.service.f.rV(12);
                GMTrace.o(3388058107904L, 25243);
                return;
                label219:
                i = 0;
              }
            }
          });
          GMTrace.o(14481019109376L, 107892);
          return;
        }
        if (localg.wbe)
        {
          localg.vtF.clear();
          localg.wbe = false;
        }
        for (;;)
        {
          localg.wbd.clear();
          break;
          v.d("MicroMsg.ConversationWithCacheAdapter", "dealWithConversationEvents size %d", new Object[] { Integer.valueOf(localg.wbd.size()) });
          Iterator localIterator = localg.wbd.iterator();
          while (localIterator.hasNext()) {
            localg.vtF.remove(localIterator.next());
          }
        }
      }
      
      public final void OJ()
      {
        GMTrace.i(14480884891648L, 107891);
        com.tencent.mm.plugin.report.service.f.rU(12);
        c localc = j.this.wcg;
        localc.vZK = -1;
        localc.vZJ.clear();
        if ((localc.vZM == null) || (localc.vZL < 0) || (!localc.vZM.bNB()))
        {
          localc.vZK = 0;
          GMTrace.o(14480884891648L, 107891);
          return;
        }
        if (localc.vZM.wbe)
        {
          localc.vZK = 0;
          GMTrace.o(14480884891648L, 107891);
          return;
        }
        if (localc.vZM.wbc)
        {
          v.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount has contact change");
          localc.vZK = 0;
          localc.vZM.wbc = false;
          GMTrace.o(14480884891648L, 107891);
          return;
        }
        Object localObject1 = (HashSet)localc.vZM.wbd.clone();
        v.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  events size %d", new Object[] { Integer.valueOf(((HashSet)localObject1).size()) });
        if (((HashSet)localObject1).contains("floatbottle"))
        {
          localc.vZK = 0;
          GMTrace.o(14480884891648L, 107891);
          return;
        }
        ((HashSet)localObject1).remove("officialaccounts");
        if (((HashSet)localObject1).isEmpty())
        {
          localc.vZK = 1;
          GMTrace.o(14480884891648L, 107891);
          return;
        }
        localObject1 = ((HashSet)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          String str = (String)((Iterator)localObject1).next();
          Object localObject2 = localc.vZM;
          boolean bool;
          if (((g)localObject2).TU(str)) {
            bool = false;
          }
          for (;;)
          {
            if (bool) {
              break label369;
            }
            localObject2 = localc.TT(str);
            if (localObject2 != null) {
              break label371;
            }
            localc.vZJ.put(str, Integer.valueOf(0));
            v.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  cov == null username %s, unreadcount %d", new Object[] { str, Integer.valueOf(0) });
            break;
            localObject2 = (g.d)((g)localObject2).vtF.get(str);
            if (localObject2 == null) {
              bool = false;
            } else if (o.dH(str)) {
              bool = ((g.d)localObject2).waz;
            } else {
              bool = ((g.d)localObject2).waw;
            }
          }
          label369:
          continue;
          label371:
          localc.vZJ.put(str, Integer.valueOf(((aj)localObject2).field_unReadCount));
          v.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  cov != null username %s, unreadcount %d", new Object[] { str, Integer.valueOf(((aj)localObject2).field_unReadCount) });
        }
        v.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  preUnReadCount size %d", new Object[] { Integer.valueOf(localc.vZJ.size()) });
        if (localc.vZJ.isEmpty())
        {
          localc.vZK = 1;
          GMTrace.o(14480884891648L, 107891);
          return;
        }
        if (localc.vZJ.size() > 20)
        {
          localc.vZK = 0;
          GMTrace.o(14480884891648L, 107891);
          return;
        }
        localc.vZK = 2;
        GMTrace.o(14480884891648L, 107891);
      }
    });
    this.vZM.a(new MMSlideDelView.c()
    {
      public final int bY(View paramAnonymousView)
      {
        GMTrace.i(14490145914880L, 107960);
        int i = j.this.vZj.getPositionForView(paramAnonymousView);
        GMTrace.o(14490145914880L, 107960);
        return i;
      }
    });
    this.vZM.a(new MMSlideDelView.f()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt)
      {
        GMTrace.i(14481153327104L, 107893);
        j.this.vZj.performItemClick(paramAnonymousView, paramAnonymousInt, 0L);
        GMTrace.o(14481153327104L, 107893);
      }
    });
    Object localObject1 = this.wbW;
    Object localObject2 = this.uRf.uRz;
    Object localObject3 = this.vZj;
    Object localObject4 = this.wce;
    ((a)localObject1).context = ((Context)localObject2);
    ((a)localObject1).vZj = ((ListView)localObject3);
    ((a)localObject1).vZk = ((View)localObject4);
    ((a)localObject1).vZi = new a.1((a)localObject1);
    com.tencent.mm.sdk.b.a.uql.b(((a)localObject1).vZi);
    localObject4 = new ad();
    ((ad)localObject4).fDa.activity = ((Activity)localObject2);
    com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject4);
    localObject4 = new com.tencent.mm.e.a.ae();
    ((com.tencent.mm.e.a.ae)localObject4).fDb.fDd = ((com.tencent.mm.pluginsdk.ui.b.b)com.tencent.mm.ui.conversation.a.e.a(((a)localObject1).context, com.tencent.mm.ui.conversation.a.e.a.wcW, null));
    com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject4);
    localObject4 = (com.tencent.mm.pluginsdk.ui.b.b)com.tencent.mm.ui.conversation.a.e.a(((a)localObject1).context, com.tencent.mm.ui.conversation.a.e.a.wcQ, null);
    com.tencent.mm.e.a.ae localae = new com.tencent.mm.e.a.ae();
    localae.fDb.fDd = ((com.tencent.mm.pluginsdk.ui.b.b)localObject4);
    localae.fDb.fDc = false;
    localae.fDb.level = 1;
    com.tencent.mm.sdk.b.a.uql.m(localae);
    localObject4 = (com.tencent.mm.ui.conversation.a.n)com.tencent.mm.ui.conversation.a.e.a(((a)localObject1).context, com.tencent.mm.ui.conversation.a.e.a.wcV, null);
    localae = new com.tencent.mm.e.a.ae();
    localae.fDb.fDd = ((com.tencent.mm.pluginsdk.ui.b.b)localObject4);
    localae.fDb.fDc = false;
    localae.fDb.level = 2;
    com.tencent.mm.sdk.b.a.uql.m(localae);
    localObject4 = (com.tencent.mm.ui.conversation.a.a)com.tencent.mm.ui.conversation.a.e.a(((a)localObject1).context, com.tencent.mm.ui.conversation.a.e.a.wcS, null);
    localae = new com.tencent.mm.e.a.ae();
    localae.fDb.fDd = ((com.tencent.mm.pluginsdk.ui.b.b)localObject4);
    localae.fDb.fDc = false;
    localae.fDb.level = 3;
    com.tencent.mm.sdk.b.a.uql.m(localae);
    localObject4 = (com.tencent.mm.ui.e.a)com.tencent.mm.ui.conversation.a.e.a(((a)localObject1).context, com.tencent.mm.ui.conversation.a.e.a.wcX, new Object[] { b.b.hos });
    localae = new com.tencent.mm.e.a.ae();
    localae.fDb.fDd = ((com.tencent.mm.pluginsdk.ui.b.b)localObject4);
    localae.fDb.fDc = true;
    com.tencent.mm.sdk.b.a.uql.m(localae);
    com.tencent.mm.sdk.b.a.uql.c(((a)localObject1).vZi);
    localObject4 = new LinkedList();
    ((List)localObject4).addAll(((a)localObject1).vZc);
    ((List)localObject4).addAll(((a)localObject1).vZd);
    ((List)localObject4).addAll(((a)localObject1).vZe);
    ((List)localObject4).addAll(((a)localObject1).vZf);
    Collections.sort((List)localObject4, new a.2((a)localObject1));
    ((a)localObject1).cQ((List)localObject4);
    new LinkedList();
    localObject4 = (com.tencent.mm.pluginsdk.ui.b.b)com.tencent.mm.ui.conversation.a.e.a((Context)localObject2, com.tencent.mm.ui.conversation.a.e.a.wcR, null);
    if ((localObject4 != null) && (((com.tencent.mm.pluginsdk.ui.b.b)localObject4).getView() != null)) {
      ((ListView)localObject3).addFooterView(((com.tencent.mm.pluginsdk.ui.b.b)localObject4).getView());
    }
    ((a)localObject1).vZg.add(localObject4);
    ((ListView)localObject3).addFooterView(new com.tencent.mm.ui.conversation.a.i((Context)localObject2).getView(), null, true);
    ((a)localObject1).vZg.add(localObject4);
    ((a)localObject1).oWA = new a.3((a)localObject1);
    ap.a(((a)localObject1).oWA);
    ((a)localObject1).vZh = new a.4((a)localObject1);
    com.tencent.mm.sdk.b.a.uql.b(((a)localObject1).vZh);
    ap.yY();
    com.tencent.mm.u.c.a((al)localObject1);
    localObject1 = this.wci;
    localObject2 = this.vZj;
    localObject3 = this.vZM;
    ((k)localObject1).vZj = ((ListView)localObject2);
    ((k)localObject1).vZM = ((g)localObject3);
    ((ListView)localObject2).setOnScrollListener(((k)localObject1).krI);
    ((g)localObject3).vZX = ((k)localObject1).krI;
    com.tencent.mm.sdk.platformtools.ae.v(new k.2((k)localObject1));
    this.wcg.ae(aG());
    this.vZj.setAdapter(this.vZM);
    this.vZj.setOnItemClickListener(new e(this.vZM, this.vZj, aG()));
    this.vZj.setOnItemLongClickListener(new f(this.vZM, this.vZj, aG(), this.qBU));
    this.vZj.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(14477529448448L, 107866);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          GMTrace.o(14477529448448L, 107866);
          return false;
          j.this.aqY();
          j.this.qBU[0] = ((int)paramAnonymousMotionEvent.getRawX());
          j.this.qBU[1] = ((int)paramAnonymousMotionEvent.getRawY());
        }
      }
    });
    this.vZj.setSelection(0);
    localObject1 = this.wcf;
    localObject2 = aG();
    localObject3 = this.wbW;
    ((i)localObject1).fOZ = ((Activity)localObject2);
    ((i)localObject1).wbW = ((a)localObject3);
    ((i)localObject1).wbX = this;
    ((i)localObject1).wakeLock = ((PowerManager)((Activity)localObject2).getSystemService("power")).newWakeLock(26, "NetSceneInit Lock");
    ap.vd().a(-1, (com.tencent.mm.y.e)localObject1);
    ((i)localObject1).wbT = false;
    com.tencent.mm.sdk.b.a.uql.b(((i)localObject1).wbY);
    com.tencent.mm.sdk.b.a.uql.b(((i)localObject1).wbZ);
    localObject2 = new File(aa.getContext().getFilesDir(), "DBRecoverStarted");
    if (((File)localObject2).exists())
    {
      com.tencent.mm.plugin.report.c.oRz.d("DBRepair", "Last recovery interrupted.", null);
      ((File)localObject2).delete();
    }
    ((i)localObject1).wca = new FLock(new File(aa.getContext().getFilesDir(), "MMStarted"), true);
    if (((i)localObject1).wca.bIt())
    {
      ((i)localObject1).wca.unlock();
      v.i("MicroMsg.DuplicateDetect", "No data multiple instance detected.");
    }
    for (;;)
    {
      ((i)localObject1).wca.bIs();
      localObject1 = this.wcg;
      localObject2 = this.vZM;
      localObject3 = this.vZj;
      localObject4 = aG();
      ((c)localObject1).vZM = ((g)localObject2);
      ((c)localObject1).vZj = ((ListView)localObject3);
      ((c)localObject1).activity = ((Activity)localObject4);
      com.tencent.mm.sdk.b.a.uql.b(((c)localObject1).vZP);
      com.tencent.mm.sdk.b.a.uql.b(((c)localObject1).vZN);
      com.tencent.mm.sdk.b.a.uql.b(((c)localObject1).vZO);
      localObject1 = this.wch;
      localObject2 = this.vZM;
      localObject3 = this.vZj;
      localObject4 = aG();
      ((m)localObject1).vZM = ((g)localObject2);
      ((m)localObject1).fOZ = ((Activity)localObject4);
      ((m)localObject1).vZj = ((ListView)localObject3);
      if (((m)localObject1).kHQ == null) {
        ((m)localObject1).kHQ = new m.6((m)localObject1, new m.1((m)localObject1));
      }
      if (((m)localObject1).wcv == null) {
        ((m)localObject1).wcv = new m.7((m)localObject1);
      }
      if (((m)localObject1).wcw == null) {
        ((m)localObject1).wcw = new m.8((m)localObject1, (ListView)localObject3);
      }
      com.tencent.mm.sdk.b.a.uql.b(((m)localObject1).kHQ);
      com.tencent.mm.sdk.b.a.uql.b(((m)localObject1).wcv);
      com.tencent.mm.sdk.b.a.uql.b(((m)localObject1).wcw);
      ((m)localObject1).uOM = new m.9((m)localObject1);
      Looper.myQueue().addIdleHandler(((m)localObject1).uOM);
      ((ListView)localObject3).post(new m.10((m)localObject1));
      localObject1 = com.tencent.mm.ah.n.GV();
      int i = R.g.bdG;
      v.d("MicroMsg.AutoGetBigImgLogic", "chattingMaskResId change from " + ((com.tencent.mm.ah.a)localObject1).hEd + " to " + i);
      ((com.tencent.mm.ah.a)localObject1).hEd = i;
      com.tencent.mm.ah.n.GV().start();
      ap.aT(false);
      ap.yY();
      com.tencent.mm.u.c.wW().a(this.vZM);
      ap.yY();
      com.tencent.mm.u.c.wR().a(this.vZM);
      localObject1 = this.vZM;
      if (((g)localObject1).wad == null) {
        ((g)localObject1).wad = new g.1((g)localObject1);
      }
      com.tencent.mm.sdk.b.a.uql.b(((g)localObject1).wad);
      this.vZM.waY = new g.b()
      {
        public final void bYs()
        {
          GMTrace.i(14479542714368L, 107881);
          j.this.vZM.clearCache();
          ap.yY();
          com.tencent.mm.u.c.wW().a(j.this.vZM);
          ap.yY();
          com.tencent.mm.u.c.wR().a(j.this.vZM);
          GMTrace.o(14479542714368L, 107881);
        }
      };
      l = u.aA(l);
      ap.yY();
      v.i("MicroMsg.MainUI", "kevin mainUIOnCreate time:%d uin:%d ver:%x", new Object[] { Long.valueOf(l), Integer.valueOf(com.tencent.mm.u.c.uH()), Integer.valueOf(com.tencent.mm.protocal.d.sXh) });
      this.vZj.postDelayed(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(14482898157568L, 107906);
          if (j.this.bOZ() != null) {
            j.this.bOZ().aQ();
          }
          GMTrace.o(14482898157568L, 107906);
        }
      }, 200L);
      GMTrace.o(3440671457280L, 25635);
      return;
      v.w("MicroMsg.DuplicateDetect", "Data multiple instance detected.");
      com.tencent.mm.plugin.report.c.oRz.a(579L, 0L, 1L, true);
    }
  }
  
  protected final void bOc()
  {
    GMTrace.i(3441074110464L, 25638);
    v.i("MicroMsg.MainUI", "onTabResume");
    long l = u.NA();
    Object localObject1 = this.wcg;
    if (((c)localObject1).vZL < 0)
    {
      v.d("MicroMsg.ConvUnreadHelper", "onTabResume totalUnReadCount %d", new Object[] { Integer.valueOf(((c)localObject1).vZL) });
      if (((c)localObject1).vZM != null) {
        ((c)localObject1).vZM.bYq();
      }
    }
    bYC();
    localObject1 = this.wbW;
    com.tencent.mm.x.n.Bl().d((d.a)localObject1);
    ap.yY();
    com.tencent.mm.u.c.vr().a((m.b)localObject1);
    ((a)localObject1).bYi();
    v.d("MicroMsg.MainUI", "start time check dkinit KEVIN mainui TestTimeLayoutTime onTabResume:%d", new Object[] { Long.valueOf(u.aA(l)) });
    localObject1 = this.wch;
    if (l.a.szL != null) {
      l.a.szL.a((l.m)localObject1);
    }
    com.tencent.mm.sdk.platformtools.ae.v(new m.11((m)localObject1));
    l.eZ(((m)localObject1).fOZ);
    Object localObject2;
    int i;
    boolean bool;
    h.a locala;
    if ((((m)localObject1).fOZ != null) && (!((m)localObject1).fOZ.isFinishing()))
    {
      localObject2 = ((m)localObject1).fOZ;
      i = com.tencent.mm.m.a.tP();
      if (i != 1) {
        break label650;
      }
      l = PreferenceManager.getDefaultSharedPreferences((Context)localObject2).getLong("db_check_tip_time", 0L);
      if ((System.currentTimeMillis() - l > 86400000L) || (l > System.currentTimeMillis()))
      {
        bool = true;
        v.i("MicroMsg.RefreshHelper", "checkDBSize isTimeOut %b ", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          locala = new h.a((Context)localObject2);
          locala.zR(R.l.dVR);
          locala.SW(((Activity)localObject2).getString(R.l.dVQ));
          locala.kH(false);
          locala.zU(R.l.dVN).a(new m.4((m)localObject1));
          locala.WD().show();
        }
        com.tencent.mm.m.a.b((Context)localObject2, System.currentTimeMillis());
      }
    }
    else
    {
      label351:
      if ((((m)localObject1).fOZ != null) && (((m)localObject1).fOZ.getIntent() != null) && (((m)localObject1).fOZ.getIntent().getBooleanExtra("resend_fail_messages", false)))
      {
        com.tencent.mm.sdk.platformtools.ae.f(new m.12((m)localObject1), 500L);
        ((m)localObject1).fOZ.getIntent().putExtra("resend_fail_messages", false);
      }
      localObject2 = (LauncherUI)((m)localObject1).fOZ;
      if (localObject2 != null) {
        ((LauncherUI)localObject2).uPX.Y(((m)localObject1).vTM);
      }
      if ((r.a(((m)localObject1).fOZ.getIntent(), "Main_ListToTop", false)) && (((m)localObject1).vZj != null)) {
        ((m)localObject1).vZj.post(new m.2((m)localObject1));
      }
      r.b(((m)localObject1).fOZ.getIntent(), "Main_ListToTop", false);
      localObject1 = this.wcf;
      if (((i)localObject1).isb != null) {
        break label753;
      }
      i = -1;
    }
    for (;;)
    {
      v.i("MicroMsg.InitHelper", "onTabResume tip:%d initscene:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(((i)localObject1).bYx()) });
      ((i)localObject1).bYv();
      com.tencent.mm.sdk.platformtools.ae.f(new i.6((i)localObject1), 100L);
      if ((ap.zb()) && (!this.wcf.bYy()))
      {
        com.tencent.mm.sdk.b.a.uql.a(new qe(), Looper.getMainLooper());
        localObject1 = new pq();
        ((pq)localObject1).fWq.action = 4;
        com.tencent.mm.sdk.b.a.uql.a((com.tencent.mm.sdk.b.b)localObject1, Looper.getMainLooper());
      }
      GMTrace.o(3441074110464L, 25638);
      return;
      bool = false;
      break;
      label650:
      if (i != 2) {
        break label351;
      }
      ap.hold();
      locala = new h.a((Context)localObject2);
      locala.zR(R.l.dVP);
      locala.SW(((Activity)localObject2).getString(R.l.dVO));
      locala.kH(false);
      locala.zU(R.l.dVM).a(new m.5((m)localObject1));
      locala.WD().show();
      com.tencent.mm.m.a.b((Context)localObject2, System.currentTimeMillis());
      com.tencent.mm.plugin.report.service.g.oSF.a(282L, 2L, 1L, false);
      break label351;
      label753:
      if (((i)localObject1).isb.isShowing()) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  protected final void bOd()
  {
    GMTrace.i(3441342545920L, 25640);
    v.i("MicroMsg.MainUI", "onTabStart");
    GMTrace.o(3441342545920L, 25640);
  }
  
  protected final void bOe()
  {
    GMTrace.i(3441476763648L, 25641);
    v.i("MicroMsg.MainUI", "onTabPause");
    Object localObject1 = this.wbW;
    v.i("MicroMsg.BannerHelper", "releaseBanner");
    a.cT(((a)localObject1).vZc);
    a.cT(((a)localObject1).vZd);
    a.cT(((a)localObject1).vZe);
    a.cT(((a)localObject1).vZf);
    Object localObject2 = ((a)localObject1).vZg.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      com.tencent.mm.pluginsdk.ui.b.b localb = (com.tencent.mm.pluginsdk.ui.b.b)((Iterator)localObject2).next();
      if (localb != null) {
        localb.release();
      }
    }
    if (ap.zb()) {
      com.tencent.mm.x.n.Bl().e((d.a)localObject1);
    }
    if (ap.zb())
    {
      ap.yY();
      com.tencent.mm.u.c.vr().b((m.b)localObject1);
    }
    localObject1 = this.wcf;
    if (((i)localObject1).wakeLock.isHeld())
    {
      v.w("MicroMsg.InitHelper", "onTabPause wakelock.release!");
      ((i)localObject1).wakeLock.release();
    }
    aqY();
    localObject1 = this.wch;
    if (l.a.szL != null) {
      l.a.szL.b((l.m)localObject1);
    }
    l.bYF();
    localObject2 = (LauncherUI)((m)localObject1).fOZ;
    if (localObject2 != null) {
      ((LauncherUI)localObject2).uPX.Z(((m)localObject1).vTM);
    }
    bYD();
    GMTrace.o(3441476763648L, 25641);
  }
  
  protected final void bOf()
  {
    GMTrace.i(3441610981376L, 25642);
    v.i("MicroMsg.MainUI", "onTabStop");
    GMTrace.o(3441610981376L, 25642);
  }
  
  protected final void bOg()
  {
    GMTrace.i(3441745199104L, 25643);
    v.i("MicroMsg.MainUI", "onTabDestroy  acc:%b", new Object[] { Boolean.valueOf(ap.zb()) });
    Object localObject = this.wbW;
    v.i("MicroMsg.BannerHelper", "destroyBanner");
    a.cU(((a)localObject).vZc);
    a.cU(((a)localObject).vZd);
    a.cU(((a)localObject).vZe);
    a.cU(((a)localObject).vZf);
    Iterator localIterator = ((a)localObject).vZg.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.pluginsdk.ui.b.b localb = (com.tencent.mm.pluginsdk.ui.b.b)localIterator.next();
      if (localb != null) {
        localb.destroy();
      }
    }
    ap.b(((a)localObject).oWA);
    com.tencent.mm.sdk.b.a.uql.c(((a)localObject).vZh);
    com.tencent.mm.sdk.b.a.uql.c(((a)localObject).vZi);
    if (ap.zb())
    {
      ap.yY();
      com.tencent.mm.u.c.b((al)localObject);
    }
    ((a)localObject).context = null;
    localObject = this.wcf;
    ((i)localObject).wca.unlock();
    ap.vd().b(-1, (com.tencent.mm.y.e)localObject);
    if (((i)localObject).isb != null)
    {
      ((i)localObject).isb.dismiss();
      ((i)localObject).isb = null;
    }
    com.tencent.mm.sdk.b.a.uql.c(((i)localObject).wbY);
    com.tencent.mm.sdk.b.a.uql.c(((i)localObject).wbZ);
    localObject = this.wch;
    if (((m)localObject).kHQ != null)
    {
      com.tencent.mm.sdk.b.a.uql.c(((m)localObject).kHQ);
      ((m)localObject).kHQ = null;
    }
    com.tencent.mm.sdk.b.a.uql.c(((m)localObject).wcv);
    com.tencent.mm.sdk.b.a.uql.c(((m)localObject).wcw);
    if (l.a.szL != null) {
      l.a.szL.b((l.m)localObject);
    }
    if (ap.zb()) {
      u.NC();
    }
    localObject = this.wcg;
    com.tencent.mm.sdk.b.a.uql.c(((c)localObject).vZP);
    com.tencent.mm.sdk.b.a.uql.c(((c)localObject).vZN);
    com.tencent.mm.sdk.b.a.uql.c(((c)localObject).vZO);
    ((c)localObject).activity = null;
    if ((ap.zb()) && (this.vZM != null))
    {
      ap.yY();
      com.tencent.mm.u.c.wW().b(this.vZM);
      ap.yY();
      com.tencent.mm.u.c.wR().b(this.vZM);
    }
    if (this.vZM != null)
    {
      localObject = this.vZM;
      if (((g)localObject).wad != null)
      {
        com.tencent.mm.sdk.b.a.uql.c(((g)localObject).wad);
        ((g)localObject).wad = null;
      }
      this.vZM.waY = null;
      localObject = this.vZM;
      ((g)localObject).waY = null;
      if (((g)localObject).vtF != null)
      {
        ((g)localObject).vtF.clear();
        ((g)localObject).vtF = null;
      }
      ((com.tencent.mm.ui.e)localObject).ke(true);
      ((g)localObject).bOB();
      ((g)localObject).wbb.clear();
      v.i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap");
    }
    GMTrace.o(3441745199104L, 25643);
  }
  
  public final void bOh()
  {
    GMTrace.i(3442147852288L, 25646);
    BackwardSupportUtil.c.a(this.vZj);
    GMTrace.o(3442147852288L, 25646);
  }
  
  public final void bOi()
  {
    GMTrace.i(3441879416832L, 25644);
    v.i("MicroMsg.MainUI", "turn to bg");
    GMTrace.o(3441879416832L, 25644);
  }
  
  public final void bOj()
  {
    GMTrace.i(3442013634560L, 25645);
    v.i("MicroMsg.MainUI", "turn to fg");
    GMTrace.o(3442013634560L, 25645);
  }
  
  public final void bYA()
  {
    GMTrace.i(14514170888192L, 108139);
    if (this.vZM != null) {
      this.vZM.ndm = true;
    }
    GMTrace.o(14514170888192L, 108139);
  }
  
  public final void bYB()
  {
    GMTrace.i(14514305105920L, 108140);
    if (this.vZM != null)
    {
      this.vZM.ndm = false;
      this.vZM.bYq();
      if (bOZ() != null) {
        this.wcg.ae(aG());
      }
    }
    GMTrace.o(14514305105920L, 108140);
  }
  
  public final void bYC()
  {
    GMTrace.i(3440805675008L, 25636);
    if (this.vZM != null) {
      this.vZM.onResume();
    }
    GMTrace.o(3440805675008L, 25636);
  }
  
  public final void bYD()
  {
    GMTrace.i(3440939892736L, 25637);
    if (this.vZM != null) {
      this.vZM.onPause();
    }
    GMTrace.o(3440939892736L, 25637);
  }
  
  public final boolean bin()
  {
    GMTrace.i(3437584449536L, 25612);
    GMTrace.o(3437584449536L, 25612);
    return false;
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(3437450231808L, 25611);
    int i = R.i.cgF;
    GMTrace.o(3437450231808L, 25611);
    return i;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    GMTrace.i(3438792409088L, 25621);
    super.onConfigurationChanged(paramConfiguration);
    this.wbW.bYi();
    GMTrace.o(3438792409088L, 25621);
  }
  
  public final void onDestroy()
  {
    GMTrace.i(3443490029568L, 25656);
    v.i("MicroMsg.MainUI", "onDestroy");
    this.wci.bYE();
    super.onDestroy();
    GMTrace.o(3443490029568L, 25656);
  }
  
  public final void onPause()
  {
    GMTrace.i(3437987102720L, 25615);
    v.i("MicroMsg.MainUI", "onPause");
    super.onPause();
    GMTrace.o(3437987102720L, 25615);
  }
  
  public final void onResume()
  {
    GMTrace.i(3437852884992L, 25614);
    v.i("MicroMsg.MainUI", "onResume");
    super.onResume();
    GMTrace.o(3437852884992L, 25614);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/conversation/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */