package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.ah.n;
import com.tencent.mm.ah.p;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.cb.b;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.k;
import com.tencent.mm.u.q.b;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

final class bf
  extends ag.b
{
  public static final int vBd;
  public static final int vBe;
  private En_5b8fbb1e.a vAn;
  private int vBh;
  
  static
  {
    GMTrace.i(2189762232320L, 16315);
    vBd = com.tencent.mm.bg.a.dO(com.tencent.mm.sdk.platformtools.aa.getContext()) - (int)(com.tencent.mm.bg.a.getDensity(com.tencent.mm.sdk.platformtools.aa.getContext()) * 60.0F);
    vBe = (int)com.tencent.mm.bg.a.getDensity(com.tencent.mm.sdk.platformtools.aa.getContext()) * 180;
    GMTrace.o(2189762232320L, 16315);
  }
  
  public bf()
  {
    super(65);
    GMTrace.i(2188822708224L, 16308);
    this.vBh = 0;
    GMTrace.o(2188822708224L, 16308);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2188956925952L, 16309);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cXo);
      paramLayoutInflater = new m(this.klJ);
      paramLayoutInflater.kvw = ((TextView)((View)localObject).findViewById(R.h.bBt));
      paramLayoutInflater.qDD = ((View)localObject).findViewById(R.h.bAd);
      paramLayoutInflater.mdQ = ((CheckBox)((View)localObject).findViewById(R.h.bzW));
      paramLayoutInflater.nQv = ((View)localObject).findViewById(R.h.bAQ);
      paramLayoutInflater.oIS = ((ImageView)((View)localObject).findViewById(R.h.bGR));
      paramLayoutInflater.iUi = ((TextView)((View)localObject).findViewById(R.h.title));
      paramLayoutInflater.ljq = ((TextView)((View)localObject).findViewById(R.h.cIf));
      ((View)localObject).setTag(paramLayoutInflater);
    }
    GMTrace.o(2188956925952L, 16309);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2189225361408L, 16311);
    this.vAn = parama1;
    m localm = (m)parama;
    k localk = ((com.tencent.mm.plugin.biz.a.a)h.h(com.tencent.mm.plugin.biz.a.a.class)).rR(paramau.field_content);
    parama = localk.hkc;
    if (parama.size() == 0)
    {
      localm.qDD.setVisibility(8);
      GMTrace.o(2189225361408L, 16311);
      return;
    }
    localm.qDD.setVisibility(0);
    com.tencent.mm.t.l locall = (com.tencent.mm.t.l)parama.get(0);
    if (!u.mA(locall.hki))
    {
      localm.oIS.setVisibility(0);
      paramString = locall.hki;
      ImageView localImageView = localm.oIS;
      int i = paramau.field_type;
      parama = paramString;
      if (p.Hb()) {
        parama = p.jF(paramString);
      }
      paramString = n.GX();
      c.a locala = new c.a();
      locala.hIM = R.e.aUx;
      locala.hIt = true;
      locala = locala.aO(vBd, vBe);
      locala.hIj = new be.b();
      locala.hIv = s.n(parama, i, "@T");
      paramString.b(parama, localImageView, locala.Hh(), new be.a());
      localm.iUi.setText(locall.title);
      parama = parama1.TB(locall.url);
      if (TextUtils.isEmpty(parama)) {
        break label468;
      }
      v.d("MicroMsg.ChattingItemBizVideoFrom", "productId:%s", new Object[] { parama });
      parama = new ds(paramau, false, paramInt, locall.url, 8, false, parama1.bVI(), localk.fUH, localk.fUI, locall.title, parama, null, false, false);
      label328:
      paramInt = locall.hkm;
      if ((paramInt > 0) && (paramInt < 86400L)) {
        break label510;
      }
      paramString = null;
      if (TextUtils.isEmpty(paramString)) {
        break label573;
      }
      localm.ljq.setVisibility(0);
      localm.ljq.setText(paramString);
    }
    for (;;)
    {
      parama.rWf = paramau.field_msgSvrId;
      parama.rWg = 0;
      localm.qDD.setTag(parama);
      localm.qDD.setOnClickListener(parama1.vzN.vDb);
      localm.qDD.setOnLongClickListener(parama1.vzN.vDd);
      localm.qDD.setOnTouchListener(parama1.vzN.vDf);
      GMTrace.o(2189225361408L, 16311);
      return;
      localm.oIS.setVisibility(8);
      break;
      label468:
      parama = new ds(paramau, false, paramInt, locall.url, 6, false, parama1.bVI(), localk.fUH, localk.fUI, locall.title);
      break label328;
      label510:
      if (paramInt < 3600L) {}
      for (paramString = "mm:ss";; paramString = "HH:mm:ss")
      {
        paramString = new SimpleDateFormat(paramString);
        paramString.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        paramString = paramString.format(Long.valueOf(paramInt * 1000L));
        break;
      }
      label573:
      localm.ljq.setVisibility(8);
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2189359579136L, 16312);
    ds localds = (ds)paramView.getTag();
    if (localds == null)
    {
      GMTrace.o(2189359579136L, 16312);
      return false;
    }
    this.vBh = localds.rWg;
    int i = localds.position;
    if ((!this.vAn.bVz()) && (!aa.aj(paramau))) {
      paramContextMenu.add(i, 111, 0, paramView.getContext().getString(R.l.eLz));
    }
    if (d.Jr("favorite")) {
      paramContextMenu.add(i, 125, 0, paramView.getContext().getString(R.l.eFS));
    }
    GMTrace.o(2189359579136L, 16312);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2189493796864L, 16313);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      GMTrace.o(2189493796864L, 16313);
      return false;
      Object localObject1 = be.a(paramau, parama.uRf.uRz, this.vBh);
      if (!u.mA((String)localObject1))
      {
        paramMenuItem = new Intent(parama.uRf.uRz, MsgRetransmitUI.class);
        paramMenuItem.putExtra("Retr_Msg_content", (String)localObject1);
        paramMenuItem.putExtra("Retr_Msg_Type", 2);
        paramMenuItem.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.vBh);
        paramMenuItem.putExtra("Retr_Msg_Id", paramau.field_msgId);
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
        paramMenuItem = be.a(paramau, parama.uRf.uRz, 0);
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
          e.a((cb)localObject1, paramau);
          com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
          if (((cb)localObject1).fFs.ret == 0) {
            com.tencent.mm.modelstat.b.hTV.t(paramau);
          }
        }
      }
    }
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2189628014592L, 16314);
    GMTrace.o(2189628014592L, 16314);
    return false;
  }
  
  protected final boolean bUf()
  {
    GMTrace.i(2189091143680L, 16310);
    GMTrace.o(2189091143680L, 16310);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */