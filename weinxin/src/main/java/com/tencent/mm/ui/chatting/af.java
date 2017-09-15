package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.media.ToneGenerator;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.j;
import com.tencent.mm.R.l;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.ma;
import com.tencent.mm.e.a.rq;
import com.tencent.mm.e.a.rq.a;
import com.tencent.mm.e.a.rr;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.subapp.c.i;
import com.tencent.mm.pluginsdk.l.a;
import com.tencent.mm.pluginsdk.l.h;
import com.tencent.mm.pluginsdk.l.s;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.j;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.q;
import com.tencent.mm.y.h.a;
import com.tencent.mm.y.h.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class af
  implements com.tencent.mm.pluginsdk.ui.chat.b
{
  public static boolean vzL;
  public ToneGenerator jWO;
  Vibrator jWR;
  public final ai jXi;
  public final ai jXj;
  final h.a jXm;
  public x jht;
  public Object lock;
  public ChatFooter nvG;
  final h.b nvL;
  private AppPanel.a nws;
  private boolean vvA;
  public En_5b8fbb1e.a vxP;
  public ListView vzM;
  public cv vzN;
  public com.tencent.mm.y.h vzO;
  private String vzP;
  String vzQ;
  public boolean vzR;
  private boolean vzS;
  public boolean vzT;
  public volatile boolean vzU;
  public volatile boolean vzV;
  public boolean vzW;
  
  static
  {
    GMTrace.i(2136209358848L, 15916);
    vzL = true;
    GMTrace.o(2136209358848L, 15916);
  }
  
  public af(ListView paramListView, cv paramcv, En_5b8fbb1e.a parama, ChatFooter paramChatFooter, String paramString)
  {
    GMTrace.i(2130303778816L, 15872);
    this.jXm = new h.a()
    {
      public final void onError()
      {
        GMTrace.i(2529333084160L, 18845);
        af.this.vzO.reset();
        af.this.jXi.KI();
        af.this.jXj.KI();
        ac.Pt("keep_app_silent");
        af.this.nvG.auE();
        af.this.vzN.vCX.bTC();
        v.v("MicroMsg.ChattingFooterEventImpl", "record stop on error");
        af.this.vxP.ko(true);
        af.this.vxP.kn(true);
        Toast.makeText(af.this.vxP.uRf.uRz, af.this.vxP.uRf.uRz.getString(R.l.dUZ), 0).show();
        GMTrace.o(2529333084160L, 18845);
      }
    };
    this.nvL = new h.b()
    {
      public final void BF()
      {
        GMTrace.i(2283848859648L, 17016);
        af.this.nvG.bFn();
        GMTrace.o(2283848859648L, 17016);
      }
    };
    this.vzU = false;
    this.vzV = false;
    this.lock = new Object();
    this.jXi = new ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(2375251132416L, 17697);
        af.this.nvG.xy(af.this.vzO.getMaxAmplitude());
        GMTrace.o(2375251132416L, 17697);
        return true;
      }
    }, true);
    this.vzW = false;
    this.jXj = new ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(2263850418176L, 16867);
        long l = af.this.vzO.pn();
        v.d("MicroMsg.ChattingFooterEventImpl", "ms " + l);
        if ((l >= 50000L) && (l <= 60000L))
        {
          if (!af.this.vzW)
          {
            bf.el(af.this.vxP.uRf.uRz);
            af.this.vzW = true;
          }
          int i = (int)((60000L - l) / 1000L);
          af.this.nvG.MX(af.this.vxP.bQb().getQuantityString(R.j.drX, i, new Object[] { Integer.valueOf(i) }));
        }
        if (l >= 60000L)
        {
          v.v("MicroMsg.ChattingFooterEventImpl", "record stop on countdown");
          af.this.bTV();
          af.this.nvG.auE();
          com.tencent.mm.sdk.platformtools.ap.B(af.this.vxP.uRf.uRz, R.l.eXZ);
          GMTrace.o(2263850418176L, 16867);
          return false;
        }
        GMTrace.o(2263850418176L, 16867);
        return true;
      }
    }, true);
    this.nws = new AppPanel.a()
    {
      com.tencent.mm.ui.tools.l ouh;
      
      public final void aJA()
      {
        GMTrace.i(2147349430272L, 15999);
        En_5b8fbb1e.a locala = af.this.vxP;
        Intent localIntent = new Intent(locala.uRf.uRz, SelectContactUI.class);
        localIntent.putExtra("list_attr", s.q(new int[] { s.vWS, 2048 }));
        localIntent.putExtra("list_type", 4);
        localIntent.putExtra("received_card_name", locala.bTW());
        localIntent.putExtra("block_contact", locala.bTW());
        localIntent.putExtra("Add_SendCard", true);
        localIntent.putExtra("titile", locala.zo(R.l.dCK));
        locala.startActivityForResult(localIntent, 223);
        GMTrace.o(2147349430272L, 15999);
      }
      
      public final void aJB()
      {
        GMTrace.i(2147752083456L, 16002);
        d.b(af.this.vxP.uRf.uRz, "subapp", ".ui.openapi.AddAppUI", new Intent());
        GMTrace.o(2147752083456L, 16002);
      }
      
      public final void aJC()
      {
        GMTrace.i(2147886301184L, 16003);
        Intent localIntent = new Intent();
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("3");
        if (com.tencent.mm.modelbiz.e.dr(af.this.jht.field_username))
        {
          localArrayList.add("4");
          localArrayList.add("7");
          localArrayList.add("9");
          localArrayList.add("10");
          localArrayList.add("11");
          localArrayList.add("12");
          localArrayList.add("13");
          localArrayList.add("15");
          localArrayList.add("16");
          localArrayList.add("17");
          localArrayList.add("18");
        }
        localIntent.putExtra("key_to_user", af.this.jht.field_username);
        localIntent.putExtra("key_fav_item_id", TextUtils.join(",", localArrayList));
        d.b(af.this.vxP.uRf.uRz, "favorite", ".ui.FavSelectUI", localIntent);
        com.tencent.mm.plugin.report.service.g.oSF.i(14103, new Object[] { Integer.valueOf(1) });
        GMTrace.o(2147886301184L, 16003);
      }
      
      public final void aJD()
      {
        GMTrace.i(2148020518912L, 16004);
        Intent localIntent = new Intent();
        localIntent.putExtra("service_app_talker_user", af.this.bTW());
        d.a(af.this.vxP, "subapp", ".ui.openapi.ServiceAppUI", localIntent, 222);
        GMTrace.o(2148020518912L, 16004);
      }
      
      public final void aJE()
      {
        GMTrace.i(2148154736640L, 16005);
        Intent localIntent = new Intent();
        localIntent.putExtra("download_entrance_scene", 17);
        localIntent.putExtra("preceding_scence", 13);
        d.b(af.this.vxP.uRf.uRz, "emoji", ".ui.v2.EmojiStoreV2UI", localIntent);
        com.tencent.mm.plugin.report.service.g.oSF.i(12065, new Object[] { Integer.valueOf(4) });
        GMTrace.o(2148154736640L, 16005);
      }
      
      public final void aJF()
      {
        GMTrace.i(2148423172096L, 16007);
        com.tencent.mm.plugin.report.service.g.oSF.i(12097, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        com.tencent.mm.plugin.report.service.g.oSF.i(11850, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
        if (af.this.vzR)
        {
          com.tencent.mm.plugin.report.service.g.oSF.i(11701, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(2) });
          localObject1 = new Intent();
          i = j.eC(af.this.bTW());
          ((Intent)localObject1).putExtra("key_way", 1);
          ((Intent)localObject1).putExtra("key_chatroom_num", i);
          ((Intent)localObject1).putExtra("key_type", 1);
          ((Intent)localObject1).putExtra("key_from", 1);
          ((Intent)localObject1).putExtra("key_username", af.this.bTW());
          ((Intent)localObject1).putExtra("pay_channel", 14);
          d.b(af.this.vxP.uRf.uRz, "luckymoney", ".ui.LuckyMoneyPrepareUI", (Intent)localObject1);
          GMTrace.o(2148423172096L, 16007);
          return;
        }
        com.tencent.mm.u.ap.yY();
        Object localObject1 = (Integer)com.tencent.mm.u.c.vr().get(w.a.uyo, Integer.valueOf(0));
        com.tencent.mm.u.ap.yY();
        Object localObject2 = (Integer)com.tencent.mm.u.c.vr().get(w.a.uyp, Integer.valueOf(0));
        if ((((Integer)localObject1).intValue() == 1) || (((Integer)localObject2).intValue() == 1)) {
          if (m.xS() != 0) {
            break label455;
          }
        }
        label455:
        for (int i = 1; i == 0; i = 0)
        {
          com.tencent.mm.plugin.report.service.g.oSF.i(11701, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1) });
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("key_way", 0);
          ((Intent)localObject1).putExtra("key_type", 0);
          ((Intent)localObject1).putExtra("key_from", 1);
          ((Intent)localObject1).putExtra("key_username", af.this.bTW());
          ((Intent)localObject1).putExtra("pay_channel", 11);
          d.b(af.this.vxP.uRf.uRz, "luckymoney", ".ui.LuckyMoneyPrepareUI", (Intent)localObject1);
          GMTrace.o(2148423172096L, 16007);
          return;
        }
        localObject1 = af.this.vxP.getString(R.l.exL);
        localObject2 = af.this.vxP.getString(R.l.eyo);
        ActionBarActivity localActionBarActivity = af.this.vxP.uRf.uRz;
        g.c local4 = new g.c()
        {
          public final void hp(int paramAnonymous2Int)
          {
            GMTrace.i(2527722471424L, 18833);
            Intent localIntent = new Intent();
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              GMTrace.o(2527722471424L, 18833);
              return;
              com.tencent.mm.plugin.report.service.g.oSF.i(11701, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(3) });
              localIntent.putExtra("key_username", af.this.bTW());
              localIntent.putExtra("key_way", 0);
              localIntent.putExtra("pay_channel", 11);
              d.b(af.this.vxP.uRf.uRz, "luckymoney", ".ui.LuckyMoneyNewYearSendUI", localIntent);
              GMTrace.o(2527722471424L, 18833);
              return;
              com.tencent.mm.plugin.report.service.g.oSF.i(11701, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1) });
              localIntent.putExtra("key_way", 0);
              localIntent.putExtra("key_type", 0);
              localIntent.putExtra("key_from", 1);
              localIntent.putExtra("key_username", af.this.bTW());
              localIntent.putExtra("pay_channel", 11);
              d.b(af.this.vxP.uRf.uRz, "luckymoney", ".ui.LuckyMoneyPrepareUI", localIntent);
            }
          }
        };
        com.tencent.mm.ui.base.g.a(localActionBarActivity, null, new String[] { localObject1, localObject2 }, null, local4);
        GMTrace.o(2148423172096L, 16007);
      }
      
      public final void aJG()
      {
        GMTrace.i(2148557389824L, 16008);
        com.tencent.mm.u.ap.yY();
        com.tencent.mm.u.c.vr().set(81, Boolean.valueOf(false));
        if (!al.isNetworkConnected(af.this.vxP.uRf.uRz))
        {
          com.tencent.mm.al.a.a(af.this.vxP.uRf.uRz, R.l.fcg, null);
          GMTrace.o(2148557389824L, 16008);
          return;
        }
        af.this.bTX();
        GMTrace.o(2148557389824L, 16008);
      }
      
      public final void aJH()
      {
        GMTrace.i(2148691607552L, 16009);
        Intent localIntent = new Intent();
        localIntent.putExtra("enterprise_scene", 4);
        localIntent.putExtra("enterprise_biz_name", af.this.bTW());
        localIntent.putExtra("biz_chat_chat_id", af.this.vxP.bVG());
        d.b(af.this.vxP.uRf.uRz, "brandservice", ".ui.EnterpriseBizContactPlainListUI", localIntent);
        GMTrace.o(2148691607552L, 16009);
      }
      
      public final void aJI()
      {
        GMTrace.i(2148825825280L, 16010);
        if (af.this.vzR)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("enter_scene", 1);
          localIntent.putExtra("chatroom_name", af.this.bTW());
          d.b(af.this.vxP.uRf.uRz, "aa", ".ui.LaunchAAUI", localIntent);
        }
        GMTrace.o(2148825825280L, 16010);
      }
      
      public final void aJw()
      {
        GMTrace.i(2146812559360L, 15995);
        if (com.tencent.mm.n.a.aH(af.this.vxP.uRf.uRz))
        {
          GMTrace.o(2146812559360L, 15995);
          return;
        }
        rq localrq = new rq();
        com.tencent.mm.sdk.b.a.uql.m(localrq);
        if ((!af.this.bTW().equals(localrq.fYu.fJC)) && ((localrq.fYu.fYw) || (localrq.fYu.fYx)))
        {
          if (localrq.fYu.fYv) {}
          for (int i = R.l.dPQ;; i = R.l.dPR)
          {
            Toast.makeText(af.this.vxP.uRf.uRz, i, 0).show();
            v.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
            GMTrace.o(2146812559360L, 15995);
            return;
          }
        }
        if (1 == com.tencent.mm.i.g.sV().getInt("EnableVoiceVoipFromPlugin", 0))
        {
          if (this.ouh == null)
          {
            this.ouh = new com.tencent.mm.ui.tools.l(af.this.vxP.uRf.uRz);
            this.ouh.qHD = new n.c()
            {
              public final void a(com.tencent.mm.ui.base.l paramAnonymous2l)
              {
                GMTrace.i(2242509799424L, 16708);
                paramAnonymous2l.dX(2, R.l.dHc);
                paramAnonymous2l.dX(1, R.l.dHd);
                GMTrace.o(2242509799424L, 16708);
              }
            };
            this.ouh.qHE = new n.d()
            {
              public final void c(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                GMTrace.i(2172716580864L, 16188);
                switch (paramAnonymous2MenuItem.getItemId())
                {
                }
                for (;;)
                {
                  GMTrace.o(2172716580864L, 16188);
                  return;
                  af.this.aTy();
                  GMTrace.o(2172716580864L, 16188);
                  return;
                  af.this.aTz();
                }
              }
            };
          }
          this.ouh.bkT();
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.oSF.i(11033, new Object[] { Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(0) });
          GMTrace.o(2146812559360L, 15995);
          return;
          af.this.bTZ();
        }
      }
      
      public final void aJx()
      {
        GMTrace.i(2146946777088L, 15996);
        if (com.tencent.mm.n.a.aH(af.this.vxP.uRf.uRz))
        {
          GMTrace.o(2146946777088L, 15996);
          return;
        }
        rq localrq = new rq();
        com.tencent.mm.sdk.b.a.uql.m(localrq);
        if ((!af.this.bTW().equals(localrq.fYu.fJC)) && ((localrq.fYu.fYw) || (localrq.fYu.fYx)))
        {
          if (localrq.fYu.fYv) {}
          for (int i = R.l.dPQ;; i = R.l.dPR)
          {
            Toast.makeText(af.this.vxP.uRf.uRz, i, 0).show();
            v.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
            GMTrace.o(2146946777088L, 15996);
            return;
          }
        }
        af.this.bTY();
        GMTrace.o(2146946777088L, 15996);
      }
      
      public final void aJy()
      {
        GMTrace.i(2147080994816L, 15997);
        if ((!com.tencent.mm.n.a.aJ(af.this.vxP.uRf.uRz)) && (!com.tencent.mm.n.a.aH(af.this.vxP.uRf.uRz)))
        {
          boolean bool = com.tencent.mm.pluginsdk.i.a.a(af.this.vxP.bOZ(), "android.permission.RECORD_AUDIO", 81, "", "");
          v.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bf.bJP(), af.this.vxP.bOZ() });
          if (!bool)
          {
            GMTrace.o(2147080994816L, 15997);
            return;
          }
          af.this.bUa();
        }
        GMTrace.o(2147080994816L, 15997);
      }
      
      public final void aJz()
      {
        GMTrace.i(2147215212544L, 15998);
        En_5b8fbb1e.a locala = af.this.vxP;
        String[] arrayOfString;
        if (!locala.bVE())
        {
          arrayOfString = new String[1];
          arrayOfString[0] = locala.zo(R.l.ewt);
        }
        for (;;)
        {
          com.tencent.mm.ui.base.g.a(locala.uRf.uRz, null, arrayOfString, null, new En_5b8fbb1e.a.20(locala));
          GMTrace.o(2147215212544L, 15998);
          return;
          arrayOfString = new String[2];
          arrayOfString[0] = locala.zo(R.l.ewt);
          arrayOfString[1] = locala.zo(R.l.ewu);
        }
      }
      
      public final void b(com.tencent.mm.pluginsdk.model.app.f paramAnonymousf)
      {
        GMTrace.i(2147617865728L, 16001);
        En_5b8fbb1e.a locala = af.this.vxP;
        if (paramAnonymousf == null)
        {
          v.e("MicroMsg.ChattingUI", "onAppSelected, info is null, %s", new Object[] { bf.bJP() });
          GMTrace.o(2147617865728L, 16001);
          return;
        }
        if ((paramAnonymousf != null) && (com.tencent.mm.pluginsdk.model.app.f.sBx.equals(paramAnonymousf.field_appId)) && (locala.oPC != null)) {
          locala.oPC.at(2, En_5b8fbb1e.a.vGp);
        }
        if (paramAnonymousf.bCN())
        {
          locala.m(paramAnonymousf);
          GMTrace.o(2147617865728L, 16001);
          return;
        }
        if (paramAnonymousf.field_status == 3)
        {
          v.e("MicroMsg.ChattingUI", "onAppSeleted fail, app is in blacklist, packageName = " + paramAnonymousf.field_packageName);
          GMTrace.o(2147617865728L, 16001);
          return;
        }
        if ((!locala.vIq.eT(paramAnonymousf.field_packageName, paramAnonymousf.field_openId)) && (paramAnonymousf.field_status == 5))
        {
          v.d("MicroMsg.ChattingUI", "SuggestionApp appSuggestionIntroUrl = %s", new Object[] { paramAnonymousf.gfa });
          if (!bf.mA(paramAnonymousf.gfa))
          {
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", paramAnonymousf.gfa);
            d.b(locala.uRf.uRz, "webview", ".ui.tools.WebViewUI", localIntent);
          }
        }
        GMTrace.o(2147617865728L, 16001);
      }
      
      public final void pd(int paramAnonymousInt)
      {
        GMTrace.i(2147483648000L, 16000);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          GMTrace.o(2147483648000L, 16000);
          return;
          Object localObject = af.this.vxP.SA(aa.bIN()).getString("gallery", "1");
          com.tencent.mm.plugin.report.service.f.rU(19);
          if (((String)localObject).equalsIgnoreCase("0")) {
            k.k(af.this.vxP);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.oSF.i(13822, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
            ae.f(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(2114063433728L, 15751);
                af.this.nvG.bFJ();
                GMTrace.o(2114063433728L, 15751);
              }
            }, 1000L);
            GMTrace.o(2147483648000L, 16000);
            return;
            localObject = af.this.vxP.bVF();
            String str = af.this.vxP.bTW();
            if ((af.this.vzT) && (af.vzL)) {
              k.b(af.this.vxP, 3, (String)localObject, str);
            } else if (x.em(str)) {
              k.a(af.this.vxP, 12, (String)localObject, str);
            } else {
              k.a(af.this.vxP, 3, (String)localObject, str);
            }
          }
          localObject = new File(com.tencent.mm.compatible.util.e.gSp);
          if ((!((File)localObject).exists()) && (!((File)localObject).mkdir()))
          {
            Toast.makeText(af.this.vxP.uRf.uRz, af.this.vxP.getString(R.l.dVA), 1).show();
            GMTrace.o(2147483648000L, 16000);
            return;
          }
          boolean bool = com.tencent.mm.pluginsdk.i.a.a(af.this.vxP.bOZ(), "android.permission.CAMERA", 20, "", "");
          v.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkcamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bf.bJP(), af.this.vxP.bOZ() });
          if (!bool)
          {
            GMTrace.o(2147483648000L, 16000);
            return;
          }
          af.this.bUb();
        }
      }
      
      public final void pe(int paramAnonymousInt)
      {
        GMTrace.i(2148288954368L, 16006);
        if ((!com.tencent.mm.n.a.aI(af.this.vxP.bOZ())) && (!com.tencent.mm.n.a.aJ(af.this.vxP.bOZ())) && (!com.tencent.mm.n.a.aH(af.this.vxP.bOZ()))) {
          af.this.AJ(paramAnonymousInt);
        }
        GMTrace.o(2148288954368L, 16006);
      }
    };
    this.vzM = paramListView;
    this.vzN = paramcv;
    this.vxP = parama;
    this.nvG = paramChatFooter;
    this.vzP = paramString;
    com.tencent.mm.u.ap.yY();
    this.jht = com.tencent.mm.u.c.wR().Rb(paramString);
    this.vzR = parama.bTW().endsWith("@chatroom");
    this.vzS = o.eQ(parama.bTW());
    boolean bool;
    if ((this.vzR) || (this.vzS))
    {
      bool = true;
      this.vvA = bool;
      this.jWR = ((Vibrator)parama.uRf.uRz.getSystemService("vibrator"));
      if (!o.fq(this.vzP)) {
        break label305;
      }
      this.vzO = new i();
      v.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new VoiceRemindRecorder().");
    }
    for (;;)
    {
      this.vzO.a(this.nvL);
      this.vzO.a(this.jXm);
      paramChatFooter.a(this.nws);
      GMTrace.o(2130303778816L, 15872);
      return;
      bool = false;
      break;
      label305:
      paramListView = this.vzP;
      int i;
      if (o.fC(paramListView)) {
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label488;
        }
        this.vzO = new com.tencent.mm.c.b.h(this.vxP.uRf.uRz, true);
        v.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, use Speex");
        break;
        paramListView = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramListView);
        if ((paramListView != null) && (paramListView.bKU()))
        {
          paramcv = com.tencent.mm.modelbiz.e.hW(paramListView.field_username);
          if (paramcv != null)
          {
            paramcv = paramcv.bd(false);
            if (paramcv != null)
            {
              if (paramcv.hug != null) {
                paramcv.huk = "1".equals(paramcv.hug.optString("CanReceiveSpeexVoice"));
              }
              if (paramcv.huk)
              {
                v.i("MicroMsg.BizInfoStorageLogic", "bizinfo name=" + paramListView.field_username + " canReceiveSpeexVoice");
                i = 1;
                continue;
              }
            }
          }
        }
        i = 0;
      }
      label488:
      this.vzO = new com.tencent.mm.c.b.h(this.vxP.uRf.uRz, false);
      v.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, not use Speex");
    }
  }
  
  public static void AI(int paramInt)
  {
    GMTrace.i(2132451262464L, 15888);
    ma localma = new ma();
    localma.fTj.state = paramInt;
    com.tencent.mm.sdk.b.a.uql.m(localma);
    GMTrace.o(2132451262464L, 15888);
  }
  
  private void bTU()
  {
    GMTrace.i(2131377520640L, 15880);
    this.vzM.smoothScrollBy(0, 0);
    GMTrace.o(2131377520640L, 15880);
  }
  
  private void releaseWakeLock()
  {
    GMTrace.i(2131645956096L, 15882);
    this.vzM.setKeepScreenOn(false);
    GMTrace.o(2131645956096L, 15882);
  }
  
  public final void AJ(final int paramInt)
  {
    GMTrace.i(2132719697920L, 15890);
    boolean bool = com.tencent.mm.pluginsdk.i.a.a(this.vxP.bOZ(), "android.permission.CAMERA", 18, "", "");
    v.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bf.bJP(), this.vxP.bOZ() });
    if (!bool)
    {
      GMTrace.o(2132719697920L, 15890);
      return;
    }
    bool = com.tencent.mm.pluginsdk.i.a.a(this.vxP.bOZ(), "android.permission.RECORD_AUDIO", 18, "", "");
    v.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bf.bJP(), this.vxP.bOZ() });
    if (!bool)
    {
      GMTrace.o(2132719697920L, 15890);
      return;
    }
    if ((com.tencent.mm.sdk.a.b.bIk()) || (r.ijx))
    {
      com.tencent.mm.ui.tools.l locall = new com.tencent.mm.ui.tools.l(this.vxP.uRf.uRz);
      locall.qHD = new n.c()
      {
        public final void a(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          GMTrace.i(2188151619584L, 16303);
          paramAnonymousl.e(1, af.this.vxP.getString(R.l.dGS));
          paramAnonymousl.e(5, "拍摄参数设置面板");
          GMTrace.o(2188151619584L, 16303);
        }
      };
      locall.qHE = new n.d()
      {
        public final void c(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          GMTrace.i(2367734939648L, 17641);
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            GMTrace.o(2367734939648L, 17641);
            return;
            new Intent();
            com.tencent.mm.plugin.report.service.g.oSF.i(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
            k.a(af.this.vxP, new Intent(), af.this.bTW(), paramInt);
            GMTrace.o(2367734939648L, 17641);
            return;
            d.b(af.this.vxP.uRf.uRz, "mmsight", ".ui.SightSettingsUI", new Intent());
          }
        }
      };
      locall.bkT();
      GMTrace.o(2132719697920L, 15890);
      return;
    }
    if (!r.ijy)
    {
      com.tencent.mm.plugin.report.service.g.oSF.i(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      k.a(this.vxP, new Intent(), bTW(), paramInt);
    }
    GMTrace.o(2132719697920L, 15890);
  }
  
  public final boolean aJo()
  {
    GMTrace.i(2130437996544L, 15873);
    synchronized (this.lock)
    {
      this.vzU = true;
      if (!this.vzV)
      {
        v.i("MicroMsg.ChattingFooterEventImpl", "jacks in voice rcd stop but not begin.");
        GMTrace.o(2130437996544L, 15873);
        return false;
      }
    }
    this.vzV = false;
    releaseWakeLock();
    if (!bTV())
    {
      this.nvG.bFl();
      v.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request setRcdTooShort");
    }
    for (;;)
    {
      this.vzN.vCX.bTC();
      this.vxP.AV(4);
      this.vxP.stopSignalling();
      AI(1);
      this.vxP.lh(false);
      GMTrace.o(2130437996544L, 15873);
      return true;
      this.nvG.auE();
      v.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request resetRcdStatus");
    }
  }
  
  public final boolean aJq()
  {
    GMTrace.i(2130572214272L, 15874);
    v.v("MicroMsg.ChattingFooterEventImpl", "record cancel on cancel request");
    synchronized (this.lock)
    {
      this.vzU = true;
      if (!this.vzV)
      {
        v.i("MicroMsg.ChattingFooterEventImpl", "jacks in voice rcd stop but not begin.");
        GMTrace.o(2130572214272L, 15874);
        return false;
      }
    }
    this.vzV = false;
    releaseWakeLock();
    this.vxP.ko(true);
    this.vxP.kn(true);
    if (this.vzO != null)
    {
      this.vzO.cancel();
      this.jXi.KI();
      this.jXj.KI();
    }
    this.nvG.auE();
    this.vzN.vCX.bTC();
    this.vxP.AV(4);
    this.vxP.stopSignalling();
    AI(1);
    this.vxP.lh(false);
    GMTrace.o(2130572214272L, 15874);
    return true;
  }
  
  /* Error */
  public final boolean aJr()
  {
    // Byte code:
    //   0: ldc2_w 527
    //   3: sipush 15875
    //   6: invokestatic 87	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: aload_0
    //   10: getfield 135	com/tencent/mm/ui/chatting/af:vxP	Lcom/tencent/mm/ui/chatting/En_5b8fbb1e$a;
    //   13: getfield 190	com/tencent/mm/ui/q:uRf	Lcom/tencent/mm/ui/l;
    //   16: getfield 196	com/tencent/mm/ui/l:uRz	Landroid/support/v7/app/ActionBarActivity;
    //   19: invokestatic 534	com/tencent/mm/n/a:aJ	(Landroid/content/Context;)Z
    //   22: ifne +19 -> 41
    //   25: aload_0
    //   26: getfield 135	com/tencent/mm/ui/chatting/af:vxP	Lcom/tencent/mm/ui/chatting/En_5b8fbb1e$a;
    //   29: getfield 190	com/tencent/mm/ui/q:uRf	Lcom/tencent/mm/ui/l;
    //   32: getfield 196	com/tencent/mm/ui/l:uRz	Landroid/support/v7/app/ActionBarActivity;
    //   35: invokestatic 537	com/tencent/mm/n/a:aH	(Landroid/content/Context;)Z
    //   38: ifeq +22 -> 60
    //   41: ldc -38
    //   43: ldc_w 539
    //   46: invokestatic 542	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: ldc2_w 527
    //   52: sipush 15875
    //   55: invokestatic 92	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   58: iconst_0
    //   59: ireturn
    //   60: invokestatic 145	com/tencent/mm/u/ap:yY	()Lcom/tencent/mm/u/c;
    //   63: pop
    //   64: invokestatic 545	com/tencent/mm/u/c:isSDCardAvailable	()Z
    //   67: ifne +35 -> 102
    //   70: aload_0
    //   71: getfield 135	com/tencent/mm/ui/chatting/af:vxP	Lcom/tencent/mm/ui/chatting/En_5b8fbb1e$a;
    //   74: getfield 190	com/tencent/mm/ui/q:uRf	Lcom/tencent/mm/ui/l;
    //   77: getfield 196	com/tencent/mm/ui/l:uRz	Landroid/support/v7/app/ActionBarActivity;
    //   80: invokestatic 550	com/tencent/mm/ui/base/s:eP	(Landroid/content/Context;)V
    //   83: ldc -38
    //   85: ldc_w 552
    //   88: invokestatic 555	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: ldc2_w 527
    //   94: sipush 15875
    //   97: invokestatic 92	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   100: iconst_0
    //   101: ireturn
    //   102: invokestatic 560	com/tencent/mm/compatible/e/b:rU	()Z
    //   105: ifne +56 -> 161
    //   108: aload_0
    //   109: getfield 135	com/tencent/mm/ui/chatting/af:vxP	Lcom/tencent/mm/ui/chatting/En_5b8fbb1e$a;
    //   112: getfield 190	com/tencent/mm/ui/q:uRf	Lcom/tencent/mm/ui/l;
    //   115: getfield 196	com/tencent/mm/ui/l:uRz	Landroid/support/v7/app/ActionBarActivity;
    //   118: aload_0
    //   119: getfield 135	com/tencent/mm/ui/chatting/af:vxP	Lcom/tencent/mm/ui/chatting/En_5b8fbb1e$a;
    //   122: getstatic 565	com/tencent/mm/R$l:dIE	I
    //   125: invokevirtual 569	com/tencent/mm/ui/chatting/En_5b8fbb1e$a:getString	(I)Ljava/lang/String;
    //   128: aload_0
    //   129: getfield 135	com/tencent/mm/ui/chatting/af:vxP	Lcom/tencent/mm/ui/chatting/En_5b8fbb1e$a;
    //   132: getstatic 572	com/tencent/mm/R$l:dHC	I
    //   135: invokevirtual 569	com/tencent/mm/ui/chatting/En_5b8fbb1e$a:getString	(I)Ljava/lang/String;
    //   138: aload_0
    //   139: getfield 135	com/tencent/mm/ui/chatting/af:vxP	Lcom/tencent/mm/ui/chatting/En_5b8fbb1e$a;
    //   142: getstatic 575	com/tencent/mm/R$l:dHE	I
    //   145: invokevirtual 569	com/tencent/mm/ui/chatting/En_5b8fbb1e$a:getString	(I)Ljava/lang/String;
    //   148: iconst_1
    //   149: new 32	com/tencent/mm/ui/chatting/af$6
    //   152: dup
    //   153: aload_0
    //   154: invokespecial 576	com/tencent/mm/ui/chatting/af$6:<init>	(Lcom/tencent/mm/ui/chatting/af;)V
    //   157: invokestatic 581	com/tencent/mm/ui/base/g:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mm/ui/base/h;
    //   160: pop
    //   161: aload_0
    //   162: getfield 216	com/tencent/mm/ui/chatting/af:vzO	Lcom/tencent/mm/y/h;
    //   165: ifnull +116 -> 281
    //   168: aload_0
    //   169: getfield 583	com/tencent/mm/ui/chatting/af:jWO	Landroid/media/ToneGenerator;
    //   172: ifnonnull +65 -> 237
    //   175: aload_0
    //   176: getfield 135	com/tencent/mm/ui/chatting/af:vxP	Lcom/tencent/mm/ui/chatting/En_5b8fbb1e$a;
    //   179: getfield 190	com/tencent/mm/ui/q:uRf	Lcom/tencent/mm/ui/l;
    //   182: getfield 587	com/tencent/mm/ui/l:iaU	Landroid/media/AudioManager;
    //   185: iconst_3
    //   186: invokevirtual 593	android/media/AudioManager:getStreamMaxVolume	(I)I
    //   189: istore_1
    //   190: aload_0
    //   191: getfield 135	com/tencent/mm/ui/chatting/af:vxP	Lcom/tencent/mm/ui/chatting/En_5b8fbb1e$a;
    //   194: getfield 190	com/tencent/mm/ui/q:uRf	Lcom/tencent/mm/ui/l;
    //   197: getfield 587	com/tencent/mm/ui/l:iaU	Landroid/media/AudioManager;
    //   200: iconst_3
    //   201: invokevirtual 596	android/media/AudioManager:getStreamVolume	(I)I
    //   204: istore_2
    //   205: iload_1
    //   206: i2f
    //   207: iload_2
    //   208: i2f
    //   209: fdiv
    //   210: ldc_w 597
    //   213: fmul
    //   214: f2i
    //   215: istore_1
    //   216: aload_0
    //   217: new 599	android/media/ToneGenerator
    //   220: dup
    //   221: iconst_3
    //   222: iload_1
    //   223: invokespecial 601	android/media/ToneGenerator:<init>	(II)V
    //   226: putfield 583	com/tencent/mm/ui/chatting/af:jWO	Landroid/media/ToneGenerator;
    //   229: ldc -38
    //   231: ldc_w 603
    //   234: invokestatic 225	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: aload_0
    //   238: getfield 583	com/tencent/mm/ui/chatting/af:jWO	Landroid/media/ToneGenerator;
    //   241: ifnull +21 -> 262
    //   244: aload_0
    //   245: getfield 583	com/tencent/mm/ui/chatting/af:jWO	Landroid/media/ToneGenerator;
    //   248: bipush 24
    //   250: invokevirtual 607	android/media/ToneGenerator:startTone	(I)Z
    //   253: pop
    //   254: ldc -38
    //   256: ldc_w 609
    //   259: invokestatic 225	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   262: aload_0
    //   263: getfield 131	com/tencent/mm/ui/chatting/af:vzM	Landroid/widget/ListView;
    //   266: new 36	com/tencent/mm/ui/chatting/af$8
    //   269: dup
    //   270: aload_0
    //   271: invokespecial 610	com/tencent/mm/ui/chatting/af$8:<init>	(Lcom/tencent/mm/ui/chatting/af;)V
    //   274: ldc2_w 611
    //   277: invokevirtual 616	android/widget/ListView:postDelayed	(Ljava/lang/Runnable;J)Z
    //   280: pop
    //   281: aload_0
    //   282: getfield 113	com/tencent/mm/ui/chatting/af:lock	Ljava/lang/Object;
    //   285: astore_3
    //   286: aload_3
    //   287: monitorenter
    //   288: aload_0
    //   289: iconst_0
    //   290: putfield 109	com/tencent/mm/ui/chatting/af:vzU	Z
    //   293: aload_3
    //   294: monitorexit
    //   295: new 618	com/tencent/mm/sdk/platformtools/ad
    //   298: dup
    //   299: invokestatic 624	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   302: invokespecial 627	com/tencent/mm/sdk/platformtools/ad:<init>	(Landroid/os/Looper;)V
    //   305: new 34	com/tencent/mm/ui/chatting/af$7
    //   308: dup
    //   309: aload_0
    //   310: invokespecial 628	com/tencent/mm/ui/chatting/af$7:<init>	(Lcom/tencent/mm/ui/chatting/af;)V
    //   313: ldc2_w 611
    //   316: invokevirtual 629	com/tencent/mm/sdk/platformtools/ad:postDelayed	(Ljava/lang/Runnable;J)Z
    //   319: pop
    //   320: ldc2_w 527
    //   323: sipush 15875
    //   326: invokestatic 92	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   329: iconst_1
    //   330: ireturn
    //   331: astore_3
    //   332: ldc -38
    //   334: ldc_w 631
    //   337: invokestatic 555	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   340: goto -103 -> 237
    //   343: astore 4
    //   345: aload_3
    //   346: monitorexit
    //   347: aload 4
    //   349: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	this	af
    //   189	34	1	i	int
    //   204	4	2	j	int
    //   331	15	3	localException	Exception
    //   343	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   216	237	331	java/lang/Exception
    //   288	295	343	finally
    //   345	347	343	finally
  }
  
  public final void aJs()
  {
    GMTrace.i(2130974867456L, 15877);
    ld(false);
    bTU();
    GMTrace.o(2130974867456L, 15877);
  }
  
  public final void aJt()
  {
    GMTrace.i(2131109085184L, 15878);
    ld(false);
    bTU();
    GMTrace.o(2131109085184L, 15878);
  }
  
  public final void aJu()
  {
    GMTrace.i(2131243302912L, 15879);
    ld(false);
    bTU();
    GMTrace.o(2131243302912L, 15879);
  }
  
  public final void aTy()
  {
    GMTrace.i(2133122351104L, 15893);
    boolean bool = com.tencent.mm.pluginsdk.i.a.a(this.vxP.bOZ(), "android.permission.RECORD_AUDIO", 82, "", "");
    v.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bf.bJP(), this.vxP.bOZ() });
    if (!bool)
    {
      GMTrace.o(2133122351104L, 15893);
      return;
    }
    rr localrr = new rr();
    localrr.fYy.fJB = 5;
    localrr.fYy.fJC = bTW();
    localrr.fYy.context = this.vxP.uRf.uRz;
    localrr.fYy.fYt = 4;
    if (this.nvG.bFH()) {
      this.nvG.bFJ();
    }
    com.tencent.mm.sdk.b.a.uql.m(localrr);
    GMTrace.o(2133122351104L, 15893);
  }
  
  public final void aTz()
  {
    GMTrace.i(2133256568832L, 15894);
    boolean bool = com.tencent.mm.pluginsdk.i.a.a(this.vxP.bOZ(), "android.permission.CAMERA", 19, "", "");
    v.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bf.bJP(), this.vxP.bOZ() });
    if (!bool)
    {
      GMTrace.o(2133256568832L, 15894);
      return;
    }
    bool = com.tencent.mm.pluginsdk.i.a.a(this.vxP.bOZ(), "android.permission.RECORD_AUDIO", 19, "", "");
    v.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bf.bJP(), this.vxP.bOZ() });
    if (!bool)
    {
      GMTrace.o(2133256568832L, 15894);
      return;
    }
    rr localrr = new rr();
    localrr.fYy.fJB = 5;
    localrr.fYy.fJC = bTW();
    localrr.fYy.context = this.vxP.uRf.uRz;
    localrr.fYy.fYt = 2;
    if (this.nvG.bFH()) {
      this.nvG.bFJ();
    }
    com.tencent.mm.sdk.b.a.uql.m(localrr);
    GMTrace.o(2133256568832L, 15894);
  }
  
  public final boolean bTV()
  {
    boolean bool = false;
    GMTrace.i(2131780173824L, 15883);
    this.vxP.ko(true);
    this.vxP.kn(true);
    int i;
    label80:
    long l;
    if (this.vzO != null) {
      if (this.vzO.pm()) {
        if ((this.jht.field_username.equals("medianote")) && ((m.xP() & 0x4000) == 0))
        {
          i = 1;
          if (i == 0) {
            break label258;
          }
          i = 1;
          bool = this.vzO.pd();
          this.jXi.KI();
          this.jXj.KI();
          if (i != 0)
          {
            au localau = new au();
            localau.cH("medianote");
            localau.setType(34);
            localau.dw(1);
            localau.cI(this.vzQ);
            localau.dv(2);
            localau.setContent(com.tencent.mm.modelvoice.n.b(m.xL(), this.vzO.pl(), false));
            localau.z(ay.gk("medianote"));
            if (this.vzO.pp() == 2) {
              localau.cN("SOURCE_SILK_FILE");
            }
            com.tencent.mm.u.ap.yY();
            l = com.tencent.mm.u.c.wT().L(localau);
            if (l > 0L) {
              break label263;
            }
            v.e("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg fail");
          }
          label236:
          ac.Pt("keep_app_silent");
        }
      }
    }
    for (;;)
    {
      GMTrace.o(2131780173824L, 15883);
      return bool;
      i = 0;
      break;
      label258:
      i = 0;
      break label80;
      label263:
      v.i("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg success, msgId = " + l);
      break label236;
      v.i("MicroMsg.ChattingFooterEventImpl", "stopRecording recorder == null");
    }
  }
  
  public final String bTW()
  {
    GMTrace.i(2131914391552L, 15884);
    if ((this.jht != null) && (x.eO(this.jht.field_username)))
    {
      str = this.vzP;
      GMTrace.o(2131914391552L, 15884);
      return str;
    }
    if (this.jht == null)
    {
      GMTrace.o(2131914391552L, 15884);
      return null;
    }
    String str = this.jht.field_username;
    GMTrace.o(2131914391552L, 15884);
    return str;
  }
  
  public final void bTX()
  {
    GMTrace.i(2132585480192L, 15889);
    boolean bool = com.tencent.mm.pluginsdk.i.a.a(this.vxP.bOZ(), "android.permission.CAMERA", 22, "", "");
    v.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bf.bJP(), this.vxP.bOZ() });
    if (!bool)
    {
      GMTrace.o(2132585480192L, 15889);
      return;
    }
    bool = com.tencent.mm.pluginsdk.i.a.a(this.vxP.bOZ(), "android.permission.RECORD_AUDIO", 22, "", "");
    v.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bf.bJP(), this.vxP.bOZ() });
    if (!bool)
    {
      GMTrace.o(2132585480192L, 15889);
      return;
    }
    v.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk");
    Intent localIntent = new Intent();
    if (l.a.szS.zq(bTW()))
    {
      v.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but now is in share location!");
      Toast.makeText(aa.getContext(), R.l.ess, 0).show();
      GMTrace.o(2132585480192L, 15889);
      return;
    }
    List localList;
    if (bTW() != null)
    {
      localList = l.a.szT.AZ(bTW());
      com.tencent.mm.u.ap.yY();
      String str1 = (String)com.tencent.mm.u.c.vr().get(2, null);
      bool = l.a.szT.AX(bTW());
      Iterator localIterator = localList.iterator();
      String str2;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        str2 = (String)localIterator.next();
      } while ((str1 == null) || (!str1.equals(str2)));
    }
    for (int i = 1;; i = 0)
    {
      if ((localList.size() >= 9) && (i == 0))
      {
        v.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but > max 9 members!");
        Toast.makeText(aa.getContext(), aa.getContext().getString(R.l.eBX, new Object[] { Integer.valueOf(9) }), 0).show();
        GMTrace.o(2132585480192L, 15889);
        return;
      }
      if (i != 0)
      {
        if (l.a.szT.aMF())
        {
          v.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in it!");
          Toast.makeText(aa.getContext(), aa.getContext().getString(R.l.eBR), 0).show();
          GMTrace.o(2132585480192L, 15889);
          return;
        }
        v.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, already inlist, but in fact not multitalking now!");
      }
      if (l.a.szT.aMU())
      {
        v.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in VoIP or multitalk!");
        Toast.makeText(aa.getContext(), aa.getContext().getString(R.l.eBR), 0).show();
        GMTrace.o(2132585480192L, 15889);
        return;
      }
      if (bool)
      {
        v.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but this group already in multitalk, alter take in or not tips!");
        com.tencent.mm.ui.base.g.b(this.vxP.uRf.uRz, this.vxP.getString(R.l.eCn), "", this.vxP.getString(R.l.eBB), this.vxP.getString(R.l.eBz), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(2307336962048L, 17191);
            if (!l.a.szT.AX(af.this.bTW()))
            {
              Toast.makeText(aa.getContext(), aa.getContext().getString(R.l.eCj), 0).show();
              GMTrace.o(2307336962048L, 17191);
              return;
            }
            if (!l.a.szT.Be(af.this.bTW())) {
              Toast.makeText(aa.getContext(), aa.getContext().getString(R.l.eBK), 0).show();
            }
            GMTrace.o(2307336962048L, 17191);
          }
        }, null);
        GMTrace.o(2132585480192L, 15889);
        return;
      }
      localIntent.putExtra("chatroomName", bTW());
      localIntent.putExtra("key_need_gallery", true);
      localIntent.putExtra("titile", this.vxP.getString(R.l.eCe));
      d.b(this.vxP.uRf.uRz, "multitalk", ".ui.MultiTalkSelectContactUI", localIntent);
      GMTrace.o(2132585480192L, 15889);
      return;
    }
  }
  
  public final void bTY()
  {
    GMTrace.i(2132853915648L, 15891);
    boolean bool = com.tencent.mm.pluginsdk.i.a.a(this.vxP.bOZ(), "android.permission.RECORD_AUDIO", 83, "", "");
    v.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bf.bJP(), this.vxP.bOZ() });
    if (!bool)
    {
      GMTrace.o(2132853915648L, 15891);
      return;
    }
    if (this.nvG.bFH()) {
      this.nvG.bFJ();
    }
    rr localrr = new rr();
    localrr.fYy.fJB = 5;
    localrr.fYy.fJC = bTW();
    localrr.fYy.context = this.vxP.uRf.uRz;
    localrr.fYy.fYt = 3;
    com.tencent.mm.sdk.b.a.uql.m(localrr);
    com.tencent.mm.plugin.report.service.g.oSF.i(11033, new Object[] { Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(0) });
    GMTrace.o(2132853915648L, 15891);
  }
  
  public final void bTZ()
  {
    GMTrace.i(2132988133376L, 15892);
    boolean bool = com.tencent.mm.pluginsdk.i.a.a(this.vxP.bOZ(), "android.permission.CAMERA", 21, "", "");
    v.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bf.bJP(), this.vxP.bOZ() });
    if (!bool)
    {
      GMTrace.o(2132988133376L, 15892);
      return;
    }
    bool = com.tencent.mm.pluginsdk.i.a.a(this.vxP.bOZ(), "android.permission.RECORD_AUDIO", 21, "", "");
    v.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bf.bJP(), this.vxP.bOZ() });
    if (!bool)
    {
      GMTrace.o(2132988133376L, 15892);
      return;
    }
    if (this.nvG.bFH()) {
      this.nvG.bFJ();
    }
    rr localrr = new rr();
    localrr.fYy.fJB = 5;
    localrr.fYy.fJC = bTW();
    localrr.fYy.context = this.vxP.uRf.uRz;
    localrr.fYy.fYt = 2;
    com.tencent.mm.sdk.b.a.uql.m(localrr);
    GMTrace.o(2132988133376L, 15892);
  }
  
  public final void bUa()
  {
    GMTrace.i(2133390786560L, 15895);
    this.vxP.lm(false);
    this.nvG.bFJ();
    GMTrace.o(2133390786560L, 15895);
  }
  
  public final void bUb()
  {
    GMTrace.i(2133525004288L, 15896);
    if (!k.a(this.vxP, com.tencent.mm.compatible.util.e.gSp, "microMsg." + System.currentTimeMillis() + ".jpg")) {
      Toast.makeText(this.vxP.uRf.uRz, this.vxP.getString(R.l.eQv), 1).show();
    }
    GMTrace.o(2133525004288L, 15896);
  }
  
  public final void fy(boolean paramBoolean)
  {
    GMTrace.i(2132317044736L, 15887);
    if (paramBoolean)
    {
      this.vxP.keepSignalling();
      GMTrace.o(2132317044736L, 15887);
      return;
    }
    this.vxP.stopSignalling();
    GMTrace.o(2132317044736L, 15887);
  }
  
  @Deprecated
  @SuppressLint({"NewApi"})
  void ld(final boolean paramBoolean)
  {
    GMTrace.i(2131511738368L, 15881);
    this.vzM.postDelayed(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(2114600304640L, 15755);
        int j = af.this.vzM.getLastVisiblePosition();
        int i = af.this.vzM.getCount() - 1;
        v.v("MicroMsg.ChattingFooterEventImpl", "last visible/adapter=" + j + "/" + i + " " + this.ioU);
        if ((j >= i - 1) || (this.ioU))
        {
          j = af.this.vzN.getCount();
          if ((j > 1) && (((au)af.this.vzN.getItem(j - 2)).isSystem()))
          {
            En_5b8fbb1e.c.a(af.this.vzM, i - 1, 0, paramBoolean);
            GMTrace.o(2114600304640L, 15755);
            return;
          }
          En_5b8fbb1e.c.a(af.this.vzM, i, paramBoolean);
        }
        GMTrace.o(2114600304640L, 15755);
      }
    }, 10L);
    GMTrace.o(2131511738368L, 15881);
  }
  
  public final void onPause()
  {
    GMTrace.i(2132182827008L, 15886);
    if (this.jWO != null)
    {
      v.i("MicroMsg.ChattingFooterEventImpl", "release");
      this.jWO.release();
      this.jWO = null;
    }
    bTV();
    this.jXi.KI();
    this.jXj.KI();
    GMTrace.o(2132182827008L, 15886);
  }
  
  public final void release()
  {
    GMTrace.i(2132048609280L, 15885);
    if (this.jWO != null)
    {
      v.i("MicroMsg.ChattingFooterEventImpl", "release");
      this.jWO.release();
      this.jWO = null;
    }
    GMTrace.o(2132048609280L, 15885);
  }
  
  public final boolean zT(String paramString)
  {
    GMTrace.i(2130840649728L, 15876);
    ld(false);
    bTU();
    boolean bool = this.vxP.TA(paramString);
    GMTrace.o(2130840649728L, 15876);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */