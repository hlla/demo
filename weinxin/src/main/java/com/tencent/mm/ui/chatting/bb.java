package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.a.dd.b;
import com.tencent.mm.e.a.lz;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.e.a.pr.a;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.q.b;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

final class bb
  extends ag.b
  implements com.tencent.mm.modelappbrand.f
{
  private com.tencent.mm.modelappbrand.q iIG;
  private En_5b8fbb1e.a vAn;
  
  public bb()
  {
    super(72);
    GMTrace.i(17602789244928L, 131151);
    this.iIG = new r(this);
    GMTrace.o(17602789244928L, 131151);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(17602923462656L, 131152);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cXE);
      paramLayoutInflater = new ep(this.klJ).r((View)localObject, true);
      paramView = ((e)h.h(e.class)).aR(((View)localObject).getContext());
      paramLayoutInflater.vMQ = paramView;
      paramLayoutInflater.vMP.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
      ((View)localObject).setTag(paramLayoutInflater);
    }
    GMTrace.o(17602923462656L, 131152);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(17603057680384L, 131153);
    this.vAn = parama1;
    ep localep = (ep)parama;
    parama = paramau.field_content;
    parama1.aG(paramau);
    parama1.aH(paramau);
    parama1.aI(paramau);
    v.d("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "filling Wxa dynamic from ChattingItem(%s)", new Object[] { paramString });
    ds localds;
    Object localObject;
    if (parama != null)
    {
      parama = f.a.B(parama, paramau.field_reserved);
      localds = new ds(paramau, parama1.vvA, paramInt, null, 0, (byte)0);
      if (parama != null)
      {
        localep.vxd.setVisibility(8);
        localep.vxc.setVisibility(8);
        localep.vxy.setVisibility(8);
        paramString = (com.tencent.mm.t.d)parama.n(com.tencent.mm.t.d.class);
        localObject = localep.vxf;
        if (paramString != null) {
          break label831;
        }
        paramString = null;
        label152:
        if (!((ChattingItemFooter)localObject).b(paramString, paramau.field_talker, false)) {
          break label841;
        }
        localep.vAj.setBackgroundResource(R.g.bdX);
        label179:
        com.tencent.mm.pluginsdk.model.app.f localf = g.cv(parama.appId, parama.fWv);
        if ((localf != null) && (localf.bCM())) {
          b(parama1, parama, paramau);
        }
        if ((parama.gxt != null) && (parama.gxt.length() != 0)) {
          break label855;
        }
        localep.vwP.setVisibility(8);
        label239:
        localObject = ((com.tencent.mm.plugin.appbrand.i.b)h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(parama.hjC);
        localep.vxh.setVisibility(0);
        localep.vxa.setVisibility(8);
        localep.vxk.setVisibility(0);
        localep.vxi.setVisibility(8);
        if (localObject == null) {
          break label883;
        }
        paramString = ((WxaAttributes)localObject).field_nickname;
        label308:
        if (localObject == null) {
          break label892;
        }
        localObject = ((WxaAttributes)localObject).field_brandIconURL;
        label320:
        localep.vxy.setVisibility(0);
        localep.vxu.setVisibility(8);
        localep.vxB.setText(parama.title);
        localep.vxu.setText(parama.description);
        localep.vxw.setText(paramString);
        switch (parama.hjJ)
        {
        default: 
          localep.vxx.setText(R.l.dDQ);
          label411:
          n.GX().a((String)localObject, localep.vxv, ep.vMN);
          if (!parama1.vvA) {
            if (g.g(localf))
            {
              localep.vxg.setVisibility(0);
              c(parama1, localep.vxg, ds.a(parama, paramau));
              label466:
              localObject = (com.tencent.mm.t.a)parama.n(com.tencent.mm.t.a.class);
              paramString = new Bundle();
              paramString.putString("app_id", parama.hjD);
              paramString.putString("msg_id", paramau.field_msgId);
              if (localObject == null) {
                break label955;
              }
              paramau = ((com.tencent.mm.t.a)localObject).hgZ;
              label537:
              paramString.putString("cache_key", paramau);
              paramString.putString("msg_title", parama.title);
              paramString.putString("msg_path", parama.hjB);
              paramString.putInt("msg_pkg_type", parama.hjJ);
              paramString.putInt("pkg_version", parama.fWv);
              paramString.putInt("widget_type", 0);
              if (!parama1.vzR) {
                break label961;
              }
            }
          }
          break;
        }
      }
    }
    label831:
    label841:
    label855:
    label883:
    label892:
    label955:
    label961:
    for (paramInt = 1008;; paramInt = 1007)
    {
      paramString.putInt("scene", paramInt);
      paramString.putInt("view_init_width", ep.vML);
      paramString.putInt("view_init_height", ep.vMM);
      localep.vMQ.setTag(localep);
      ((e)h.h(e.class)).a(com.tencent.mm.plugin.appbrand.k.b.aM(parama1), localep.vMQ, paramString, this.iIG);
      localep.vAj.setTag(localds);
      localep.vAj.setOnClickListener(parama1.vzN.vDb);
      paramString = com.tencent.mm.u.q.yC().n(com.tencent.mm.plugin.appbrand.k.b.aM(parama1), true);
      paramau = (cu)paramString.fS("listener");
      parama = paramau;
      if (paramau == null)
      {
        parama = new cu();
        paramString.l("listener", parama);
      }
      parama.b(parama1);
      if (this.sWq) {
        localep.vAj.setOnLongClickListener(parama1.vzN.vDd);
      }
      GMTrace.o(17603057680384L, 131153);
      return;
      v.e("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(paramau.field_msgId), paramString });
      parama = null;
      break;
      paramString = paramString.hhc;
      break label152;
      localep.vAj.setBackgroundResource(R.g.bdT);
      break label179;
      localep.vwP.setVisibility(0);
      b(parama1, localep.vwP, ds.TE(parama.gxt));
      break label239;
      paramString = parama.fUI;
      break label308;
      localObject = parama.hjL;
      break label320;
      localep.vxx.setText(R.l.dFU);
      break label411;
      localep.vxx.setText(R.l.dFT);
      break label411;
      localep.vxg.setVisibility(8);
      break label466;
      localep.vxg.setVisibility(8);
      break label466;
      paramau = null;
      break label537;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(17603191898112L, 131154);
    int i = ((ds)paramView.getTag()).position;
    f.a locala = f.a.ek(this.vAn.cQ(paramau.field_content, paramau.field_isSend));
    Object localObject;
    if ((g.h(g.aJ(locala.appId, false))) && (!aa.ah(paramau)))
    {
      if (locala.type != 6) {
        break label314;
      }
      localObject = com.tencent.mm.pluginsdk.model.app.l.Mg(locala.fCN);
      if (((localObject == null) || (!d.c(paramau, ((com.tencent.mm.pluginsdk.model.app.b)localObject).field_fileFullPath))) && (!paramau.bMj())) {
        paramContextMenu.add(i, 111, 0, this.vAn.getString(R.l.eLz));
      }
    }
    for (;;)
    {
      localObject = new dd();
      ((dd)localObject).fGN.fGD = paramau.field_msgId;
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
      if ((((dd)localObject).fGO.fGl) || (d.a(this.vAn.uRf.uRz, locala))) {
        paramContextMenu.add(i, 128, 0, paramView.getContext().getString(R.l.dUm));
      }
      if (!this.vAn.bVz()) {
        paramContextMenu.add(i, 100, 0, this.vAn.getString(R.l.dUh));
      }
      paramView = ((e)h.h(e.class)).AN();
      if ((paramView.AP()) || (paramView.fp(locala.hjJ))) {
        paramContextMenu.add(i, 131, 0, this.vAn.getString(R.l.dUn));
      }
      GMTrace.o(17603191898112L, 131154);
      return true;
      label314:
      paramContextMenu.add(i, 111, 0, this.vAn.getString(R.l.eLz));
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    String str = null;
    Object localObject = null;
    GMTrace.i(17603326115840L, 131155);
    switch (paramMenuItem.getItemId())
    {
    default: 
      GMTrace.o(17603326115840L, 131155);
      return false;
    case 100: 
      str = paramau.field_content;
      paramMenuItem = (MenuItem)localObject;
      if (str != null) {
        paramMenuItem = f.a.ek(str);
      }
      if (paramMenuItem != null)
      {
        com.tencent.mm.pluginsdk.model.app.l.ed(paramau.field_msgId);
        if (19 == paramMenuItem.type)
        {
          localObject = new lz();
          ((lz)localObject).fSV.type = 3;
          ((lz)localObject).fSV.fGD = paramau.field_msgId;
          com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
        }
        localObject = g.aJ(paramMenuItem.appId, false);
        if ((localObject != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject).bCM())) {
          a(parama, paramMenuItem, paramau, (com.tencent.mm.pluginsdk.model.app.f)localObject);
        }
      }
      ay.L(paramau.field_msgId);
      GMTrace.o(17603326115840L, 131155);
      return false;
    case 111: 
      d.a(parama, paramau, a(parama, paramau));
      GMTrace.o(17603326115840L, 131155);
      return false;
    }
    localObject = paramau.field_content;
    paramMenuItem = str;
    if (localObject != null) {
      paramMenuItem = f.a.ek((String)localObject);
    }
    if (paramMenuItem == null)
    {
      GMTrace.o(17603326115840L, 131155);
      return false;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("app_id", paramMenuItem.hjD);
    ((Bundle)localObject).putString("msg_id", paramau.field_msgId);
    ((Bundle)localObject).putInt("pkg_type", paramMenuItem.hjJ);
    ((Bundle)localObject).putInt("pkg_version", paramMenuItem.hjG);
    ((e)h.h(e.class)).AN().b(parama.uRf.uRz, (Bundle)localObject);
    GMTrace.o(17603326115840L, 131155);
    return false;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(17603460333568L, 131156);
    com.tencent.mm.modelstat.a.a(paramau, a.a.hTS);
    paramView = paramau.field_content;
    if (paramView == null)
    {
      GMTrace.o(17603460333568L, 131156);
      return false;
    }
    Object localObject1 = f.a.ek(parama.cQ(paramView, paramau.field_isSend));
    if (localObject1 == null)
    {
      GMTrace.o(17603460333568L, 131156);
      return false;
    }
    paramView = g.aJ(((f.a)localObject1).appId, false);
    if ((paramView != null) && (paramView.bCM())) {
      a(parama, (f.a)localObject1, c(parama, paramau), paramView, paramau.field_msgSvrId);
    }
    v.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { ((f.a)localObject1).hjC, ((f.a)localObject1).hjB, ((f.a)localObject1).hjD, ((f.a)localObject1).url, Integer.valueOf(((f.a)localObject1).hjJ), ((f.a)localObject1).hjF });
    paramView = new pr();
    paramView.fWr.appId = ((f.a)localObject1).hjD;
    paramView.fWr.userName = ((f.a)localObject1).hjC;
    paramView.fWr.fWt = ((f.a)localObject1).hjB;
    paramView.fWr.fWu = ((f.a)localObject1).hjJ;
    paramView.fWr.fWw = ((f.a)localObject1).hjF;
    paramView.fWr.fWv = ((f.a)localObject1).hjK;
    Object localObject2 = paramView.fWr;
    boolean bool;
    if (((f.a)localObject1).hjJ != 0)
    {
      bool = true;
      ((pr.a)localObject2).fWx = bool;
      paramView.fWr.fWz.hpB = parama.bTW();
      paramView.fWr.fWz.hpC = ((f.a)localObject1).hjI;
      localObject1 = ((f.a)localObject1).hjH;
      if (!parama.vzR) {
        break label412;
      }
      paramView.fWr.scene = 1008;
      localObject2 = new StringBuilder(parama.bTW());
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append(a(parama, paramau));
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append((String)localObject1);
    }
    for (paramView.fWr.fCE = ((StringBuilder)localObject2).toString();; paramView.fWr.fCE = parama.toString())
    {
      com.tencent.mm.sdk.b.a.uql.m(paramView);
      GMTrace.o(17603460333568L, 131156);
      return true;
      bool = false;
      break;
      label412:
      paramView.fWr.scene = 1007;
      parama = new StringBuilder(a(parama, paramau));
      parama.append(":");
      parama.append((String)localObject1);
    }
  }
  
  public final void q(View paramView, int paramInt)
  {
    GMTrace.i(17828543463424L, 132833);
    Object localObject = paramView.getTag();
    if (!(localObject instanceof ep))
    {
      GMTrace.o(17828543463424L, 132833);
      return;
    }
    v.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "onWidgetStateChanged(%s, state : %d)", new Object[] { Integer.valueOf(paramView.hashCode()), Integer.valueOf(paramInt) });
    paramView = (ep)localObject;
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      paramView.jlq.VW();
      paramView.jlq.setVisibility(4);
      paramView.vMQ.setVisibility(4);
      paramView.vMO.setVisibility(0);
      paramView.vMO.setImageResource(R.k.dtw);
      GMTrace.o(17828543463424L, 132833);
      return;
    case 0: 
      paramView.jlq.setVisibility(0);
      paramView.jlq.caG();
      paramView.vMO.setVisibility(4);
      paramView.vMQ.setVisibility(4);
      GMTrace.o(17828543463424L, 132833);
      return;
    case 1: 
      paramView.jlq.VW();
      paramView.jlq.setVisibility(4);
      paramView.vMQ.setVisibility(4);
      paramView.vMO.setVisibility(0);
      paramView.vMO.setImageResource(R.k.dwt);
      GMTrace.o(17828543463424L, 132833);
      return;
    }
    paramView.jlq.VW();
    paramView.jlq.setVisibility(4);
    paramView.vMQ.setVisibility(0);
    paramView.vMO.setVisibility(4);
    GMTrace.o(17828543463424L, 132833);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */