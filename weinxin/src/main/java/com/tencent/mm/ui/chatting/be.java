package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.cb.b;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.t.k;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.q.b;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.x.i;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class be
  extends ag.b
{
  public static final int vBd;
  public static final int vBe;
  public static final int vBf;
  private int oIN;
  private int oIO;
  private En_5b8fbb1e.a vAn;
  private boolean vBg;
  private int vBh;
  private long vBi;
  
  static
  {
    GMTrace.i(2259287015424L, 16833);
    vBd = com.tencent.mm.bg.a.dO(com.tencent.mm.sdk.platformtools.aa.getContext()) - (int)(com.tencent.mm.bg.a.getDensity(com.tencent.mm.sdk.platformtools.aa.getContext()) * 60.0F);
    vBe = (int)com.tencent.mm.bg.a.getDensity(com.tencent.mm.sdk.platformtools.aa.getContext()) * 167;
    vBf = (int)com.tencent.mm.bg.a.getDensity(com.tencent.mm.sdk.platformtools.aa.getContext()) * 50;
    GMTrace.o(2259287015424L, 16833);
  }
  
  public be()
  {
    super(26);
    GMTrace.i(2257944838144L, 16823);
    this.vBg = false;
    this.oIN = 0;
    this.oIO = 0;
    this.vBh = 0;
    this.vBi = 0L;
    GMTrace.o(2257944838144L, 16823);
  }
  
  protected static String a(au paramau, Context paramContext, int paramInt)
  {
    GMTrace.i(2259018579968L, 16831);
    if (paramContext == null)
    {
      v.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: context is null");
      GMTrace.o(2259018579968L, 16831);
      return null;
    }
    if (paramau == null)
    {
      v.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: msg is null");
      GMTrace.o(2259018579968L, 16831);
      return null;
    }
    ap.yY();
    if (!c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.s.eP(paramContext);
      GMTrace.o(2259018579968L, 16831);
      return null;
    }
    try
    {
      paramContext = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.biz.a.a.class)).rR(paramau.field_content);
      Object localObject = paramContext.hkc;
      if ((localObject != null) && (((List)localObject).size() > 0) && (paramInt < ((List)localObject).size()))
      {
        com.tencent.mm.t.l locall = (com.tencent.mm.t.l)((List)localObject).get(paramInt);
        localObject = new f.a();
        ((f.a)localObject).title = locall.title;
        ((f.a)localObject).description = locall.hkk;
        ((f.a)localObject).action = "view";
        ((f.a)localObject).type = 5;
        ((f.a)localObject).url = locall.url;
        ((f.a)localObject).fUH = paramContext.fUH;
        ((f.a)localObject).fUI = paramContext.fUI;
        ((f.a)localObject).gxt = paramContext.gxt;
        ((f.a)localObject).thumburl = locall.hki;
        if (u.mA(((f.a)localObject).thumburl))
        {
          paramau = com.tencent.mm.x.n.Bm().hs(paramau.field_talker);
          if (paramau != null) {
            ((f.a)localObject).thumburl = paramau.Bs();
          }
        }
        paramau = f.a.a((f.a)localObject, null, null);
        GMTrace.o(2259018579968L, 16831);
        return paramau;
      }
    }
    catch (Exception paramau)
    {
      v.printErrStackTrace("MicroMsg.ChattingItemBizFrom", paramau, "", new Object[0]);
      v.e("MicroMsg.ChattingItemBizFrom", "retransmit app msg error : %s", new Object[] { paramau.getLocalizedMessage() });
      GMTrace.o(2259018579968L, 16831);
    }
    return null;
  }
  
  private void a(ds paramds, com.tencent.mm.t.l paraml, au paramau)
  {
    GMTrace.i(2258750144512L, 16829);
    Bundle localBundle = new Bundle();
    int i;
    switch (com.tencent.mm.u.p.G(a(this.vAn, paramau), this.vAn.bTW()))
    {
    case 3: 
    case 4: 
    case 5: 
    default: 
      i = 0;
    }
    for (;;)
    {
      localBundle.putString("share_report_pre_msg_url", paraml.url);
      localBundle.putString("share_report_pre_msg_title", paraml.title);
      localBundle.putString("share_report_pre_msg_desc", paraml.hkk);
      localBundle.putString("share_report_pre_msg_icon_url", paraml.hki);
      localBundle.putString("share_report_pre_msg_appid", "");
      localBundle.putInt("share_report_from_scene", i);
      if (i == 5) {
        localBundle.putString("share_report_biz_username", this.vAn.bTW());
      }
      paramds.vLi = localBundle;
      GMTrace.o(2258750144512L, 16829);
      return;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 5;
    }
  }
  
  private void eV(Context paramContext)
  {
    GMTrace.i(2258213273600L, 16825);
    this.oIN = paramContext.getResources().getDimensionPixelSize(R.f.aXQ);
    this.oIO = paramContext.getResources().getDimensionPixelSize(R.f.aWY);
    GMTrace.o(2258213273600L, 16825);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2258079055872L, 16824);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cXq);
      paramView = new r(this.klJ);
      paramView.kvw = ((TextView)((View)localObject).findViewById(R.h.bBt));
      paramView.vAi = ((View)localObject).findViewById(R.h.bAA);
      paramView.vyb = ((LinearLayout)((View)localObject).findViewById(R.h.bAd));
      paramView.vyc.oIQ = ((View)localObject).findViewById(R.h.cJf);
      paramView.vyc.iUi = ((TextView)paramView.vyc.oIQ.findViewById(R.h.title));
      paramView.vyc.mxJ = ((TextView)paramView.vyc.oIQ.findViewById(R.h.cId));
      paramView.vyc.oIS = ((ImageView)paramView.vyc.oIQ.findViewById(R.h.bGR));
      paramView.vyc.vyd = paramView.vyc.oIQ.findViewById(R.h.bGU);
      paramView.vyc.vye = ((TextView)paramView.vyc.oIQ.findViewById(R.h.cIW));
      paramView.vyc.oJm = ((TextView)paramView.vyc.oIQ.findViewById(R.h.bJo));
      paramView.vyc.vyf = ((TextView)paramView.vyb.findViewById(R.h.bIm));
      paramView.vyc.lIG = ((ProgressBar)((View)localObject).findViewById(R.h.bZn));
      paramView.vyc.oIU = ((View)localObject).findViewById(R.h.bJY);
      paramView.mdQ = ((CheckBox)((View)localObject).findViewById(R.h.bzW));
      paramView.nQv = ((View)localObject).findViewById(R.h.bAQ);
      paramView.vwP = ((TextView)((View)localObject).findViewById(R.h.bzr));
      paramView.vxf = ((ChattingItemFooter)((View)localObject).findViewById(R.h.aTR));
      ((View)localObject).setTag(paramView);
    }
    eV(paramLayoutInflater.getContext());
    GMTrace.o(2258079055872L, 16824);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2258481709056L, 16827);
    this.vAn = parama1;
    eV(parama1.uRf.uRz);
    r localr = (r)parama;
    parama = localr.oJc.iterator();
    if (parama.hasNext())
    {
      paramString = (q)parama.next();
      if (localr.oJc.indexOf(paramString) != localr.oJc.size() - 1) {
        em.J(paramString.oIQ, 1);
      }
      for (;;)
      {
        localr.vyb.removeView(paramString.oIQ);
        break;
        em.J(paramString.oIQ, 2);
      }
    }
    localr.oJc.clear();
    k localk = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.biz.a.a.class)).rR(paramau.field_content);
    parama = localk.gxt;
    if ((parama == null) || (parama.length() == 0)) {
      localr.vwP.setVisibility(8);
    }
    LinkedList localLinkedList;
    int k;
    for (;;)
    {
      localLinkedList = localk.hkc;
      k = localLinkedList.size();
      if (k != 0) {
        break;
      }
      localr.vyb.setVisibility(8);
      localr.vyc.oIQ.setVisibility(8);
      GMTrace.o(2258481709056L, 16827);
      return;
      localr.vwP.setVisibility(0);
      b(parama1, localr.vwP, ds.TE(parama));
    }
    localr.vyb.setVisibility(0);
    localr.vyc.oIQ.setVisibility(0);
    boolean bool = localr.vxf.b(localk.hhc, paramau.field_talker, true);
    Object localObject1 = parama1.bOZ().getLayoutInflater();
    int i = localr.oJc.size() + 2;
    while (i < k)
    {
      paramString = em.AZ(1);
      parama = paramString;
      if (paramString == null) {
        parama = ((LayoutInflater)localObject1).inflate(R.i.cXr, null);
      }
      localr.dk(parama);
      i += 1;
    }
    if (k > 1)
    {
      if (bool)
      {
        paramString = em.AZ(1);
        parama = paramString;
        if (paramString == null) {
          parama = ((LayoutInflater)localObject1).inflate(R.i.cXr, null);
        }
        localr.dk(parama);
      }
      for (;;)
      {
        localr.vyc.oIQ.setBackgroundResource(R.g.biP);
        localr.vyc.oIQ.setPadding(this.oIO, this.oIO, this.oIO, this.oIN);
        this.vBg = true;
        i = 0;
        while (i < localr.oJc.size())
        {
          ((q)localr.oJc.get(i)).oIQ.setVisibility(8);
          i += 1;
        }
        paramString = em.AZ(2);
        parama = paramString;
        if (paramString == null) {
          parama = ((LayoutInflater)localObject1).inflate(R.i.cXs, null);
        }
        localr.dk(parama);
      }
    }
    if (bool)
    {
      localr.vyc.oIQ.setBackgroundResource(R.g.biP);
      localr.vyc.oIQ.setPadding(this.oIO, this.oIO, this.oIO, this.oIN);
    }
    for (;;)
    {
      this.vBg = false;
      break;
      localr.vyc.oIQ.setBackgroundResource(R.g.biR);
      localr.vyc.oIQ.setPadding(this.oIO, this.oIO, this.oIO, 0);
    }
    int j = 0;
    if (j < k)
    {
      localObject1 = (com.tencent.mm.t.l)localLinkedList.get(j);
      label689:
      label714:
      label739:
      label763:
      Object localObject2;
      Object localObject3;
      if (j == 0)
      {
        parama = localr.vyc.vyf;
        if (k > 1)
        {
          i = 8;
          parama.setVisibility(i);
          parama = localr.vyc.iUi;
          if (k <= 1) {
            break label1326;
          }
          i = 8;
          parama.setVisibility(i);
          parama = localr.vyc.mxJ;
          if (k <= 1) {
            break label1332;
          }
          i = 8;
          parama.setVisibility(i);
          parama = localr.vyc.vye;
          if (k <= 1) {
            break label1338;
          }
          i = 0;
          parama.setVisibility(i);
          localr.vyc.lIG.setVisibility(8);
          localr.vyc.oIU.setVisibility(8);
          if (u.mA(((com.tencent.mm.t.l)localObject1).hki)) {
            break label1351;
          }
          localr.vyc.vyd.setVisibility(0);
          localr.vyc.oIS.setVisibility(0);
          paramString = ((com.tencent.mm.t.l)localObject1).hki;
          localObject2 = localr.vyc.oIS;
          i = paramau.field_type;
          parama = paramString;
          if (com.tencent.mm.ah.p.Hb()) {
            parama = com.tencent.mm.ah.p.jF(paramString);
          }
          paramString = com.tencent.mm.ah.n.GX();
          localObject3 = new c.a();
          ((c.a)localObject3).hIM = R.e.aUx;
          ((c.a)localObject3).hIt = true;
          localObject3 = ((c.a)localObject3).aO(vBd, vBe);
          ((c.a)localObject3).hIj = new b();
          ((c.a)localObject3).hIv = com.tencent.mm.pluginsdk.model.s.n(parama, i, "@T");
          paramString.b(parama, (ImageView)localObject2, ((c.a)localObject3).Hh(), new a());
          parama = localr.vyc.oJm;
          if ((k <= 1) && (!u.mA(((com.tencent.mm.t.l)localObject1).hkk))) {
            break label1345;
          }
          i = 8;
          label986:
          parama.setVisibility(i);
          parama = localr.vyc.oJm;
          i = this.oIO;
          label1007:
          parama.setPadding(0, i, 0, 0);
          localr.vyc.oJm.setText(((com.tencent.mm.t.l)localObject1).hkk);
          localr.vyc.iUi.setText(((com.tencent.mm.t.l)localObject1).title);
          localr.vyc.mxJ.setText(o.Z(parama1.getString(R.l.elh), ((com.tencent.mm.t.l)localObject1).time));
          localr.vyc.vye.setText(((com.tencent.mm.t.l)localObject1).title);
          localr.vyc.vye.setContentDescription(((com.tencent.mm.t.l)localObject1).title);
          if ((((com.tencent.mm.t.l)localObject1).hkl != 0) && (((com.tencent.mm.t.l)localObject1).hkl != 1)) {
            localr.vyc.vye.setVisibility(4);
          }
          parama = parama1.TB(((com.tencent.mm.t.l)localObject1).url);
          if (TextUtils.isEmpty(parama)) {
            break label1468;
          }
          v.d("MicroMsg.ChattingItemBizFrom", "productId:%s", new Object[] { parama });
          parama = new ds(paramau, false, paramInt, ((com.tencent.mm.t.l)localObject1).url, 8, this.vBg, parama1.bVI(), localk.fUH, localk.fUI, ((com.tencent.mm.t.l)localObject1).title, parama, null, false, true);
        }
        for (;;)
        {
          parama.rWf = paramau.field_msgSvrId;
          parama.rWg = 0;
          localr.vyc.oIQ.setTag(parama);
          localr.vyc.oIQ.setOnClickListener(parama1.vzN.vDb);
          localr.vyc.oIQ.setOnLongClickListener(parama1.vzN.vDd);
          localr.vyc.oIQ.setOnTouchListener(parama1.vzN.vDf);
          j += 1;
          break;
          if (u.mA(((com.tencent.mm.t.l)localObject1).url))
          {
            i = 4;
            break label689;
          }
          i = 0;
          break label689;
          label1326:
          i = 0;
          break label714;
          label1332:
          i = 0;
          break label739;
          label1338:
          i = 8;
          break label763;
          label1345:
          i = 0;
          break label986;
          label1351:
          localr.vyc.vyd.setVisibility(8);
          localr.vyc.oIS.setVisibility(8);
          localr.vyc.vye.setVisibility(8);
          localr.vyc.iUi.setVisibility(0);
          parama = localr.vyc.oJm;
          if (u.mA(((com.tencent.mm.t.l)localObject1).hkk)) {}
          for (i = 8;; i = 0)
          {
            parama.setVisibility(i);
            parama = localr.vyc.oJm;
            if (k <= 1) {
              break label1462;
            }
            i = this.oIN;
            break;
          }
          label1462:
          i = 0;
          break label1007;
          label1468:
          parama = new ds(paramau, false, paramInt, ((com.tencent.mm.t.l)localObject1).url, 6, this.vBg, parama1.bVI(), localk.fUH, localk.fUI, ((com.tencent.mm.t.l)localObject1).title);
          a(parama, (com.tencent.mm.t.l)localObject1, paramau);
        }
      }
      paramString = (q)localr.oJc.get(j - 1);
      paramString.iUi.setText(((com.tencent.mm.t.l)localObject1).title);
      paramString.lIG.setVisibility(8);
      paramString.oIU.setVisibility(8);
      paramString.iUi.setTextColor(parama1.getResources().getColor(R.e.black));
      if (!u.mA(((com.tencent.mm.t.l)localObject1).hki))
      {
        paramString.oIS.setVisibility(0);
        parama = ((com.tencent.mm.t.l)localObject1).hki;
        if (com.tencent.mm.ah.p.Hb()) {
          parama = com.tencent.mm.ah.p.jF(((com.tencent.mm.t.l)localObject1).hki);
        }
        localObject2 = com.tencent.mm.ah.n.GX();
        localObject3 = paramString.oIS;
        c.a locala = new c.a();
        locala.hIv = com.tencent.mm.pluginsdk.model.s.n(parama, paramau.field_type, "@S");
        locala.hIt = true;
        locala.hIj = new b();
        locala.hIM = R.e.aUx;
        ((com.tencent.mm.ah.a.a)localObject2).a(parama, (ImageView)localObject3, locala.aO(vBf, vBf).Hh(), new a());
        if ((((com.tencent.mm.t.l)localObject1).hkl == 0) || (((com.tencent.mm.t.l)localObject1).hkl == 1))
        {
          paramString.oIR.setVisibility(0);
          label1752:
          if ((!u.mA(((com.tencent.mm.t.l)localObject1).hkk)) && (((com.tencent.mm.t.l)localObject1).type == 3))
          {
            paramString.vya.setText(((com.tencent.mm.t.l)localObject1).hkk);
            paramString.vya.setVisibility(0);
          }
          paramString.oIQ.setVisibility(0);
          parama = parama1.TB(((com.tencent.mm.t.l)localObject1).url);
          if (TextUtils.isEmpty(parama)) {
            break label1998;
          }
          v.d("MicroMsg.ChattingItemBizFrom", "productId:%s", new Object[] { parama });
          parama = new ds(paramau, false, paramInt, ((com.tencent.mm.t.l)localObject1).url, 8, this.vBg, parama1.bVI(), localk.fUH, localk.fUI, ((com.tencent.mm.t.l)localObject1).title, parama, null, false, true);
        }
      }
      for (;;)
      {
        parama.rWf = paramau.field_msgSvrId;
        parama.rWg = j;
        paramString.oIQ.setTag(parama);
        paramString.oIQ.setOnClickListener(parama1.vzN.vDb);
        paramString.oIQ.setOnLongClickListener(parama1.vzN.vDd);
        paramString.oIQ.setOnTouchListener(parama1.vzN.vDf);
        break;
        paramString.oIR.setVisibility(8);
        paramString.iUi.setTextColor(parama1.getResources().getColor(R.e.aUo));
        break label1752;
        paramString.oIR.setVisibility(8);
        break label1752;
        label1998:
        parama = new ds(paramau, false, paramInt, ((com.tencent.mm.t.l)localObject1).url, 6, this.vBg, parama1.bVI(), localk.fUH, localk.fUI);
        a(parama, (com.tencent.mm.t.l)localObject1, paramau);
      }
    }
    GMTrace.o(2258481709056L, 16827);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2258615926784L, 16828);
    ds localds = (ds)paramView.getTag();
    if (localds == null)
    {
      GMTrace.o(2258615926784L, 16828);
      return false;
    }
    this.vBh = localds.rWg;
    int i = localds.position;
    if ((!this.vAn.bVz()) && (!aa.aj(paramau))) {
      paramContextMenu.add(i, 111, 0, paramView.getContext().getString(R.l.eLz));
    }
    if (com.tencent.mm.bb.d.Jr("favorite")) {
      paramContextMenu.add(i, 125, 0, paramView.getContext().getString(R.l.eFS));
    }
    GMTrace.o(2258615926784L, 16828);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2258884362240L, 16830);
    this.vBi = u.Nz();
    switch (paramMenuItem.getItemId())
    {
    }
    label567:
    label734:
    for (;;)
    {
      GMTrace.o(2258884362240L, 16830);
      return false;
      Object localObject1 = a(paramau, parama.uRf.uRz, this.vBh);
      if (!u.mA((String)localObject1))
      {
        paramMenuItem = new Intent(parama.uRf.uRz, MsgRetransmitUI.class);
        paramMenuItem.putExtra("Retr_Msg_content", (String)localObject1);
        paramMenuItem.putExtra("Retr_Msg_Type", 2);
        paramMenuItem.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.vBh);
        paramMenuItem.putExtra("Retr_Msg_Id", paramau.field_msgId);
        paramMenuItem.putExtra("Retr_MsgFromScene", 1);
        localObject1 = paramau.field_talker;
        Object localObject2 = com.tencent.mm.u.q.fQ(paramau.field_msgSvrId);
        paramMenuItem.putExtra("reportSessionId", (String)localObject2);
        localObject2 = com.tencent.mm.u.q.yC().n((String)localObject2, true);
        ((q.b)localObject2).l("prePublishId", "msg_" + paramau.field_msgSvrId);
        ((q.b)localObject2).l("preUsername", localObject1);
        ((q.b)localObject2).l("preChatName", localObject1);
        ((q.b)localObject2).l("preMsgIndex", Integer.valueOf(this.vBh));
        ((q.b)localObject2).l("sendAppMsgScene", Integer.valueOf(1));
        parama.startActivity(paramMenuItem);
        continue;
        paramMenuItem = a(paramau, parama.uRf.uRz, 0);
        if (!u.mA(paramMenuItem))
        {
          ef.c(paramau, paramMenuItem, parama.uRf.uRz);
          continue;
          localObject1 = paramau.field_talker;
          paramMenuItem = com.tencent.mm.u.q.fQ(paramau.field_msgSvrId);
          localObject2 = com.tencent.mm.u.q.yC().n(paramMenuItem, true);
          ((q.b)localObject2).l("prePublishId", "msg_" + paramau.field_msgSvrId);
          ((q.b)localObject2).l("preUsername", localObject1);
          ((q.b)localObject2).l("preChatName", localObject1);
          ((q.b)localObject2).l("preMsgIndex", Integer.valueOf(this.vBh));
          ((q.b)localObject2).l("sendAppMsgScene", Integer.valueOf(1));
          localObject1 = new cb();
          ((cb)localObject1).fFr.fFv = this.vBh;
          ((cb)localObject1).fFr.fFw = paramMenuItem;
          ((cb)localObject1).fFr.ov = parama;
          ((cb)localObject1).fFr.fFy = 40;
          com.tencent.mm.pluginsdk.model.e.a((cb)localObject1, paramau);
          com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
          if (((cb)localObject1).fFs.ret == 0)
          {
            parama = f.a.ek(a(paramau, parama.uRf.uRz, this.vBh));
            int i;
            if (paramau.axH())
            {
              paramMenuItem = com.tencent.mm.modelstat.b.hTV;
              if (parama != null)
              {
                i = parama.type;
                paramMenuItem.c(paramau, i);
              }
            }
            for (;;)
            {
              if ((parama == null) || (parama.type != 5) || (parama.url == null)) {
                break label734;
              }
              v.d("MicroMsg.ChattingItemBizFrom", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), parama.url, Long.valueOf(this.vBi), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1) });
              paramMenuItem = "";
              try
              {
                parama = URLEncoder.encode(parama.url, "UTF-8");
                paramMenuItem = parama;
              }
              catch (UnsupportedEncodingException parama)
              {
                for (;;)
                {
                  v.printErrStackTrace("MicroMsg.ChattingItemBizFrom", parama, "", new Object[0]);
                }
              }
              com.tencent.mm.plugin.report.service.g.oSF.i(13378, new Object[] { paramMenuItem, Long.valueOf(this.vBi), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1) });
              break;
              i = 0;
              break label567;
              com.tencent.mm.modelstat.b.hTV.t(paramau);
            }
          }
        }
      }
    }
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2259152797696L, 16832);
    GMTrace.o(2259152797696L, 16832);
    return false;
  }
  
  protected final boolean bUf()
  {
    GMTrace.i(2258347491328L, 16826);
    GMTrace.o(2258347491328L, 16826);
    return false;
  }
  
  public static final class a
    implements com.tencent.mm.ah.a.c.g
  {
    public a()
    {
      GMTrace.i(2267340079104L, 16893);
      GMTrace.o(2267340079104L, 16893);
    }
    
    public final void a(String paramString, View paramView, com.tencent.mm.ah.a.d.b paramb)
    {
      GMTrace.i(2267608514560L, 16895);
      if (paramb.fFi != 2)
      {
        GMTrace.o(2267608514560L, 16895);
        return;
      }
      v.d("MicroMsg.ChattingItemBizFrom", "onImageLoadFinish, url:%s, contentType: %s", new Object[] { paramString, paramb.gac });
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (com.tencent.mm.ah.p.Hb())
      {
        bool1 = bool2;
        if (!bf.mA(paramb.gac))
        {
          bool1 = bool2;
          if (com.tencent.mm.ah.p.jG(paramString))
          {
            bool1 = bool2;
            if (paramb.gac.equals("image/webp")) {
              bool1 = true;
            }
          }
        }
      }
      int i = paramb.status;
      v.d("MicroMsg.ChattingItemBizFrom", "onImageLoadFinish, isDownloadWebp: %b, status: %d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i) });
      switch (i)
      {
      }
      for (;;)
      {
        GMTrace.o(2267608514560L, 16895);
        return;
        if (bool1)
        {
          com.tencent.mm.plugin.report.service.g.oSF.a(86L, 13L, 1L, false);
          GMTrace.o(2267608514560L, 16895);
          return;
          com.tencent.mm.plugin.report.service.g.oSF.a(86L, 2L, 1L, false);
          if (bool1)
          {
            com.tencent.mm.plugin.report.service.g.oSF.a(86L, 15L, 1L, false);
            GMTrace.o(2267608514560L, 16895);
            return;
            if (bool1) {
              com.tencent.mm.plugin.report.service.g.oSF.a(86L, 14L, 1L, false);
            }
          }
        }
      }
    }
    
    public final void jL(String paramString)
    {
      GMTrace.i(2267474296832L, 16894);
      v.d("MicroMsg.ChattingItemBizFrom", "onImageLoadStart, url: %s", new Object[] { paramString });
      com.tencent.mm.plugin.report.service.g.oSF.a(86L, 0L, 1L, false);
      GMTrace.o(2267474296832L, 16894);
    }
  }
  
  public static final class b
    implements com.tencent.mm.ah.a.c.b
  {
    public b()
    {
      GMTrace.i(2241570275328L, 16701);
      GMTrace.o(2241570275328L, 16701);
    }
    
    public final com.tencent.mm.ah.a.d.b jJ(String paramString)
    {
      GMTrace.i(2241704493056L, 16702);
      v.d("MicroMsg.ChattingBizImgDownloader", "get image data from url:%s", new Object[] { paramString });
      label318:
      for (;;)
      {
        try
        {
          long l1 = System.currentTimeMillis();
          Object localObject2 = (HttpURLConnection)new URL(paramString).openConnection();
          ((HttpURLConnection)localObject2).setConnectTimeout(15000);
          ((HttpURLConnection)localObject2).setReadTimeout(20000);
          if (com.tencent.mm.ah.p.jG(paramString)) {
            ((HttpURLConnection)localObject2).setRequestProperty("Referer", com.tencent.mm.ah.p.gc(com.tencent.mm.protocal.d.sXh));
          }
          Object localObject1;
          if (((HttpURLConnection)localObject2).getResponseCode() >= 300)
          {
            ((HttpURLConnection)localObject2).disconnect();
            v.w("MicroMsg.ChattingBizImgDownloader.HttpClientFactory", "httpURLConnectionGet 300");
            localObject1 = null;
            if (localObject1 != null)
            {
              long l2 = System.currentTimeMillis();
              if ((!com.tencent.mm.ah.p.Hb()) || (bf.mA(((com.tencent.mm.ah.a.d.b)localObject1).gac)) || (!com.tencent.mm.ah.p.jG(paramString)) || (!((com.tencent.mm.ah.a.d.b)localObject1).gac.equals("image/webp"))) {
                break label318;
              }
              bool = true;
              v.d("MicroMsg.ChattingBizImgDownloader", "getImageData, isDownloadWebp: %b", new Object[] { Boolean.valueOf(bool) });
              l1 = l2 - l1;
              v.d("MicroMsg.ChattingBizImgDownloader", "download used %d ms", new Object[] { Long.valueOf(l1) });
              com.tencent.mm.plugin.report.service.g.oSF.a(86L, 4L, l1, false);
              if (bool) {
                com.tencent.mm.plugin.report.service.g.oSF.a(86L, 17L, l1, false);
              }
            }
            GMTrace.o(2241704493056L, 16702);
            return (com.tencent.mm.ah.a.d.b)localObject1;
          }
          else
          {
            localObject1 = ((HttpURLConnection)localObject2).getInputStream();
            localObject2 = ((HttpURLConnection)localObject2).getContentType();
            localObject1 = new com.tencent.mm.ah.a.d.b(com.tencent.mm.ah.a.b.e.g((InputStream)localObject1), (String)localObject2, (byte)0);
            continue;
          }
          boolean bool = false;
        }
        catch (Exception paramString)
        {
          v.e("MicroMsg.ChattingBizImgDownloader", "get image data failed.:%s", new Object[] { paramString.toString() });
          paramString = new com.tencent.mm.ah.a.d.b(null, null, (byte)0);
          GMTrace.o(2241704493056L, 16702);
          return paramString;
        }
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */