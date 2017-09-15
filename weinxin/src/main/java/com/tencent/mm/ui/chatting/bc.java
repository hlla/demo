package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.a.dd.b;
import com.tencent.mm.e.a.hq;
import com.tencent.mm.e.a.lz;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.e.a.pr.a;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.u.q.b;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

final class bc
  extends ag.c
  implements com.tencent.mm.modelappbrand.f
{
  private com.tencent.mm.modelappbrand.q iIG;
  public En_5b8fbb1e.a vAn;
  
  public bc()
  {
    super(73);
    GMTrace.i(17606413123584L, 131178);
    this.iIG = new r(this);
    GMTrace.o(17606413123584L, 131178);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(17606547341312L, 131179);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cYj);
      paramLayoutInflater = new ep(this.klJ).r((View)localObject, false);
      paramView = ((e)h.h(e.class)).aR(((View)localObject).getContext());
      paramLayoutInflater.vMQ = paramView;
      paramLayoutInflater.vMP.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
      ((View)localObject).setTag(paramLayoutInflater);
    }
    GMTrace.o(17606547341312L, 131179);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(17606681559040L, 131180);
    ep localep = (ep)parama;
    this.vAn = parama1;
    parama1.aI(paramau);
    parama = paramau.field_content;
    parama1.aG(paramau);
    if (parama != null) {}
    for (parama = f.a.B(parama, paramau.field_reserved);; parama = null)
    {
      ds localds = new ds(paramau, parama1.vvA, paramInt, null, 0, (byte)0);
      Object localObject;
      if (parama != null)
      {
        localep.vxd.setVisibility(8);
        localep.vxc.setVisibility(8);
        localep.vxa.setVisibility(8);
        localep.vxy.setVisibility(8);
        localObject = ((com.tencent.mm.plugin.appbrand.i.b)h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(parama.hjC);
        if (localObject == null) {
          break label692;
        }
        paramString = ((WxaAttributes)localObject).field_nickname;
        if (localObject == null) {
          break label701;
        }
        localObject = ((WxaAttributes)localObject).field_brandIconURL;
        label157:
        localep.vxy.setVisibility(0);
        localep.vxu.setVisibility(8);
        localep.vxB.setText(parama.title);
        localep.vxu.setText(parama.description);
        localep.vxw.setText(paramString);
        switch (parama.hjJ)
        {
        default: 
          localep.vxx.setText(R.l.dDQ);
          label247:
          n.GX().a((String)localObject, localep.vxv, ep.vMN);
          if (bUg())
          {
            paramString = parama1.vzN;
            if ((paramau.field_status == 2) && (a(paramString, paramau.field_msgId)))
            {
              if (localep.vwJ != null) {
                localep.vwJ.setVisibility(0);
              }
              label314:
              if (localep.oCh != null) {
                localep.oCh.setVisibility(8);
              }
              label332:
              paramString = (com.tencent.mm.t.a)parama.n(com.tencent.mm.t.a.class);
              localObject = new Bundle();
              ((Bundle)localObject).putString("app_id", parama.hjD);
              ((Bundle)localObject).putString("msg_id", paramau.field_msgId);
              if (paramString == null) {
                break label798;
              }
              paramString = paramString.hgZ;
              label403:
              ((Bundle)localObject).putString("cache_key", paramString);
              ((Bundle)localObject).putString("msg_title", parama.title);
              ((Bundle)localObject).putString("msg_path", parama.hjB);
              ((Bundle)localObject).putInt("msg_pkg_type", parama.hjJ);
              ((Bundle)localObject).putInt("pkg_version", parama.fWv);
              ((Bundle)localObject).putInt("widget_type", 0);
              if (!parama1.vzR) {
                break label804;
              }
            }
          }
          break;
        }
      }
      label692:
      label701:
      label798:
      label804:
      for (int i = 1008;; i = 1007)
      {
        ((Bundle)localObject).putInt("scene", i);
        ((Bundle)localObject).putInt("view_init_width", ep.vML);
        ((Bundle)localObject).putInt("view_init_height", ep.vMM);
        localep.vMQ.setTag(localep);
        ((e)h.h(e.class)).a(com.tencent.mm.plugin.appbrand.k.b.aM(parama1), localep.vMQ, (Bundle)localObject, this.iIG);
        localep.vAj.setTag(localds);
        localep.vAj.setOnClickListener(parama1.vzN.vDb);
        localObject = com.tencent.mm.u.q.yC().n(com.tencent.mm.plugin.appbrand.k.b.aM(parama1), true);
        paramString = (cu)((q.b)localObject).fS("listener");
        parama = paramString;
        if (paramString == null)
        {
          parama = new cu();
          ((q.b)localObject).l("listener", parama);
        }
        parama.b(parama1);
        if (this.sWq) {
          localep.vAj.setOnLongClickListener(parama1.vzN.vDd);
        }
        a(paramInt, localep, paramau, parama1.vzN.hrv, parama1.vvA, parama1.vzN.vDb);
        GMTrace.o(17606681559040L, 131180);
        return;
        paramString = parama.fUI;
        break;
        localObject = parama.hjL;
        break label157;
        localep.vxx.setText(R.l.dFU);
        break label247;
        localep.vxx.setText(R.l.dFT);
        break label247;
        if (localep.vwJ == null) {
          break label314;
        }
        localep.vwJ.setVisibility(8);
        break label314;
        if (localep.oCh == null) {
          break label332;
        }
        localep.oCh.setVisibility(0);
        if (paramau.field_status < 2) {
          break label332;
        }
        localep.oCh.setVisibility(8);
        break label332;
        paramString = null;
        break label403;
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(17606815776768L, 131181);
    int i = ((ds)paramView.getTag()).position;
    Object localObject = paramau.field_content;
    if (localObject == null)
    {
      GMTrace.o(17606815776768L, 131181);
      return true;
    }
    localObject = f.a.ek(this.vAn.cQ((String)localObject, paramau.field_isSend));
    if (localObject == null)
    {
      GMTrace.o(17606815776768L, 131181);
      return true;
    }
    if ((com.tencent.mm.pluginsdk.model.app.g.h(com.tencent.mm.pluginsdk.model.app.g.aJ(((f.a)localObject).appId, false))) && (!aa.ah(paramau))) {
      paramContextMenu.add(i, 111, 0, this.vAn.getString(R.l.eLz));
    }
    if (((paramau.field_status == 2) || (paramau.gxz == 1)) && (ao(paramau)) && (Tm(paramau.field_talker))) {
      paramContextMenu.add(i, 123, 0, paramView.getContext().getString(R.l.dUp));
    }
    dd localdd = new dd();
    localdd.fGN.fGD = paramau.field_msgId;
    com.tencent.mm.sdk.b.a.uql.m(localdd);
    if ((localdd.fGO.fGl) || (d.a(this.vAn.uRf.uRz, (f.a)localObject))) {
      paramContextMenu.add(i, 128, 0, paramView.getContext().getString(R.l.dUm));
    }
    if (!this.vAn.bVz()) {
      paramContextMenu.add(i, 100, 0, this.vAn.getString(R.l.dUh));
    }
    paramView = ((e)h.h(e.class)).AN();
    if ((paramView.AP()) || (paramView.fp(((f.a)localObject).hjJ))) {
      paramContextMenu.add(i, 131, 0, this.vAn.getString(R.l.dUn));
    }
    GMTrace.o(17606815776768L, 131181);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    String str = null;
    Object localObject = null;
    GMTrace.i(17606949994496L, 131182);
    switch (paramMenuItem.getItemId())
    {
    default: 
      GMTrace.o(17606949994496L, 131182);
      return false;
    case 100: 
      str = paramau.field_content;
      paramMenuItem = (MenuItem)localObject;
      if (str != null) {
        paramMenuItem = f.a.ek(str);
      }
      if (paramMenuItem != null)
      {
        if (19 == paramMenuItem.type)
        {
          localObject = new lz();
          ((lz)localObject).fSV.type = 3;
          ((lz)localObject).fSV.fGD = paramau.field_msgId;
          com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
        }
        localObject = com.tencent.mm.pluginsdk.model.app.g.aJ(paramMenuItem.appId, false);
        if ((localObject != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject).bCM())) {
          a(parama, paramMenuItem, paramau, (com.tencent.mm.pluginsdk.model.app.f)localObject);
        }
      }
      ay.L(paramau.field_msgId);
      GMTrace.o(17606949994496L, 131182);
      return false;
    case 111: 
      d.a(parama, paramau, a(parama, paramau));
      GMTrace.o(17606949994496L, 131182);
      return false;
    case 103: 
      paramMenuItem = paramau.field_content;
      if (paramMenuItem == null)
      {
        GMTrace.o(17606949994496L, 131182);
        return false;
      }
      paramMenuItem = f.a.ek(paramMenuItem);
      if (paramMenuItem != null) {
        switch (paramMenuItem.type)
        {
        }
      }
      for (;;)
      {
        GMTrace.o(17606949994496L, 131182);
        return false;
        parama = new hq();
        parama.fMW.fMX = paramMenuItem.fMX;
        parama.fMW.fEL = paramau.field_msgId;
        parama.fMW.fMY = paramau.field_talker;
        com.tencent.mm.sdk.b.a.uql.m(parama);
      }
    }
    localObject = paramau.field_content;
    paramMenuItem = str;
    if (localObject != null) {
      paramMenuItem = f.a.ek((String)localObject);
    }
    if (paramMenuItem == null)
    {
      GMTrace.o(17606949994496L, 131182);
      return false;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("app_id", paramMenuItem.hjD);
    ((Bundle)localObject).putString("msg_id", paramau.field_msgId);
    ((Bundle)localObject).putInt("pkg_type", paramMenuItem.hjJ);
    ((Bundle)localObject).putInt("pkg_version", paramMenuItem.hjG);
    ((e)h.h(e.class)).AN().b(parama.uRf.uRz, (Bundle)localObject);
    GMTrace.o(17606949994496L, 131182);
    return false;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, final au paramau)
  {
    GMTrace.i(17607084212224L, 131183);
    if ((((ds)paramView.getTag()).klJ == 5) && (paramau.field_isSend == 1))
    {
      if (paramau != null) {
        com.tencent.mm.ui.base.g.b(this.vAn.uRf.uRz, this.vAn.getString(R.l.dVd), "", this.vAn.getString(R.l.dIn), this.vAn.getString(R.l.dGk), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(17585206722560L, 131020);
            ed.V(paramau);
            bc.this.vAn.bVv();
            GMTrace.o(17585206722560L, 131020);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(17597420535808L, 131111);
            GMTrace.o(17597420535808L, 131111);
          }
        });
      }
      GMTrace.o(17607084212224L, 131183);
      return true;
    }
    paramView = paramau.field_content;
    if (paramView == null)
    {
      GMTrace.o(17607084212224L, 131183);
      return false;
    }
    paramView = f.a.ek(paramView);
    if (paramView == null)
    {
      GMTrace.o(17607084212224L, 131183);
      return false;
    }
    Object localObject1 = com.tencent.mm.pluginsdk.model.app.g.aJ(paramView.appId, true);
    if ((localObject1 != null) && (!bf.mA(((com.tencent.mm.pluginsdk.model.app.f)localObject1).field_appId)) && (((com.tencent.mm.pluginsdk.model.app.f)localObject1).bCM())) {
      a(parama, paramView, m.xL(), (com.tencent.mm.pluginsdk.model.app.f)localObject1, paramau.field_msgSvrId);
    }
    localObject1 = new pr();
    ((pr)localObject1).fWr.appId = paramView.hjD;
    ((pr)localObject1).fWr.userName = paramView.hjC;
    ((pr)localObject1).fWr.fWt = paramView.hjB;
    ((pr)localObject1).fWr.fWu = paramView.hjJ;
    ((pr)localObject1).fWr.fWw = paramView.hjF;
    ((pr)localObject1).fWr.fWv = paramView.hjK;
    Object localObject2 = ((pr)localObject1).fWr;
    boolean bool;
    StringBuilder localStringBuilder;
    if (paramView.hjJ != 0)
    {
      bool = true;
      ((pr.a)localObject2).fWx = bool;
      localObject2 = paramView.hjH;
      if (!parama.vzR) {
        break label447;
      }
      ((pr)localObject1).fWr.scene = 1008;
      localStringBuilder = new StringBuilder(parama.bTW());
      localStringBuilder.append(":");
      localStringBuilder.append(a(parama, paramau));
      localStringBuilder.append(":");
      localStringBuilder.append((String)localObject2);
    }
    for (((pr)localObject1).fWr.fCE = localStringBuilder.toString();; ((pr)localObject1).fWr.fCE = paramau.toString())
    {
      ((pr)localObject1).fWr.fWz.hpB = parama.bTW();
      ((pr)localObject1).fWr.fWz.hpC = paramView.hjI;
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
      GMTrace.o(17607084212224L, 131183);
      return true;
      bool = false;
      break;
      label447:
      ((pr)localObject1).fWr.scene = 1007;
      paramau = new StringBuilder(a(parama, paramau));
      paramau.append(":");
      paramau.append((String)localObject2);
    }
  }
  
  public final void q(View paramView, int paramInt)
  {
    GMTrace.i(17828677681152L, 132834);
    Object localObject = paramView.getTag();
    if (!(localObject instanceof ep))
    {
      GMTrace.o(17828677681152L, 132834);
      return;
    }
    v.i("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "onWidgetStateChanged(%s, state : %d)", new Object[] { Integer.valueOf(paramView.hashCode()), Integer.valueOf(paramInt) });
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
      GMTrace.o(17828677681152L, 132834);
      return;
    case 0: 
      paramView.jlq.setVisibility(0);
      paramView.jlq.caG();
      paramView.vMQ.setVisibility(4);
      paramView.vMO.setVisibility(4);
      GMTrace.o(17828677681152L, 132834);
      return;
    case 1: 
      paramView.jlq.VW();
      paramView.jlq.setVisibility(4);
      paramView.vMQ.setVisibility(4);
      paramView.vMO.setVisibility(0);
      paramView.vMO.setImageResource(R.k.dwt);
      GMTrace.o(17828677681152L, 132834);
      return;
    }
    paramView.jlq.VW();
    paramView.jlq.setVisibility(4);
    paramView.vMQ.setVisibility(0);
    paramView.vMO.setVisibility(4);
    GMTrace.o(17828677681152L, 132834);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */