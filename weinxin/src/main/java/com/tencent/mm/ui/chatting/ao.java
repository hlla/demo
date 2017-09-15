package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.hq;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.card.a.h;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ay;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

final class ao
  extends ag.c
{
  private En_5b8fbb1e.a vAn;
  
  public ao()
  {
    super(62);
    GMTrace.i(2373506301952L, 17684);
    GMTrace.o(2373506301952L, 17684);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2373640519680L, 17685);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof g)))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cYl);
      ((View)localObject).setTag(new g(this.klJ).o((View)localObject, false));
    }
    GMTrace.o(2373640519680L, 17685);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2373774737408L, 17686);
    this.vAn = parama1;
    g localg = (g)parama;
    paramString = paramau.field_content;
    if (paramString != null) {}
    for (paramString = f.a.B(paramString, paramau.field_reserved);; paramString = null)
    {
      localg.a(parama1.uRf.uRz, paramString, paramau.field_imgPath, this.sWq);
      paramau = new ds(paramau, parama1.vvA, paramInt, null, 0, (byte)0);
      parama.vAj.setTag(paramau);
      parama.vAj.setOnClickListener(parama1.vzN.vDb);
      if (this.sWq)
      {
        parama.vAj.setOnLongClickListener(parama1.vzN.vDd);
        parama.vAj.setOnTouchListener(parama1.vzN.vDf);
      }
      GMTrace.o(2373774737408L, 17686);
      return;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2373908955136L, 17687);
    int i = ((ds)paramView.getTag()).position;
    paramView = paramau.field_content;
    if (paramView == null)
    {
      GMTrace.o(2373908955136L, 17687);
      return true;
    }
    paramView = f.a.ek(this.vAn.cQ(paramView, paramau.field_isSend));
    if (paramView == null)
    {
      GMTrace.o(2373908955136L, 17687);
      return true;
    }
    switch (paramView.type)
    {
    default: 
    case 16: 
      do
      {
        GMTrace.o(2373908955136L, 17687);
        return true;
      } while ((paramView.hiq != 5) && (paramView.hiq != 6) && (paramView.hiq != 2));
      if (paramView.hiq != 2) {
        paramContextMenu.clear();
      }
      paramContextMenu.add(i, 100, 0, this.vAn.getString(R.l.dUh));
      GMTrace.o(2373908955136L, 17687);
      return false;
    }
    paramContextMenu.clear();
    paramContextMenu.add(i, 100, 0, this.vAn.getString(R.l.dUh));
    GMTrace.o(2373908955136L, 17687);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2374043172864L, 17688);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      GMTrace.o(2374043172864L, 17688);
      return false;
      parama = paramau.field_content;
      paramMenuItem = null;
      if (parama != null) {
        paramMenuItem = f.a.ek(parama);
      }
      if (paramMenuItem != null) {
        com.tencent.mm.pluginsdk.model.app.l.ed(paramau.field_msgId);
      }
      ay.L(paramau.field_msgId);
      GMTrace.o(2374043172864L, 17688);
      return false;
      Object localObject = parama.cQ(paramau.field_content, paramau.field_isSend);
      paramMenuItem = new Intent(parama.uRf.uRz, MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
      localObject = f.a.ek((String)localObject);
      if ((localObject != null) && (16 == ((f.a)localObject).type)) {
        paramMenuItem.putExtra("Retr_Msg_Type", 14);
      }
      for (;;)
      {
        paramMenuItem.putExtra("Retr_Msg_Id", paramau.field_msgId);
        parama.startActivity(paramMenuItem);
        GMTrace.o(2374043172864L, 17688);
        return false;
        paramMenuItem.putExtra("Retr_Msg_Type", 2);
      }
      paramMenuItem = paramau.field_content;
      if (paramMenuItem == null)
      {
        GMTrace.o(2374043172864L, 17688);
        return false;
      }
      paramMenuItem = f.a.ek(paramMenuItem);
      if (paramMenuItem != null) {
        switch (paramMenuItem.type)
        {
        default: 
          break;
        case 16: 
          parama = new hq();
          parama.fMW.fMX = paramMenuItem.fMX;
          parama.fMW.fEL = paramau.field_msgId;
          parama.fMW.fMY = paramau.field_talker;
          a.uql.m(parama);
        }
      }
    }
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2374177390592L, 17689);
    paramView = paramau.field_content;
    if (paramView == null)
    {
      GMTrace.o(2374177390592L, 17689);
      return false;
    }
    Object localObject = f.a.ek(paramView);
    if (localObject == null)
    {
      GMTrace.o(2374177390592L, 17689);
      return false;
    }
    switch (((f.a)localObject).type)
    {
    default: 
      GMTrace.o(2374177390592L, 17689);
      return false;
    case 16: 
      if (bf.mA(((f.a)localObject).fMX))
      {
        GMTrace.o(2374177390592L, 17689);
        return false;
      }
      paramView = new Intent();
      paramView.setFlags(65536);
      paramView.putExtra("key_card_app_msg", ((f.a)localObject).fMX);
      paramView.putExtra("key_from_scene", ((f.a)localObject).hiq);
      d.b(parama.uRf.uRz, "card", ".ui.CardDetailUI", paramView);
      GMTrace.o(2374177390592L, 17689);
      return true;
    }
    paramView = h.b((f.a)localObject);
    PackageInfo localPackageInfo;
    int i;
    if (1 < paramView.ver)
    {
      String str = p.s(((f.a)localObject).hhf, "message");
      localPackageInfo = ay(parama.uRf.uRz, ((f.a)localObject).appId);
      if (localPackageInfo == null)
      {
        paramView = null;
        if (localPackageInfo != null) {
          break label293;
        }
        i = 0;
        label246:
        a(parama, str, str, paramView, i, ((f.a)localObject).appId, true, paramau.field_msgId, paramau.field_msgSvrId, paramau);
      }
    }
    for (;;)
    {
      GMTrace.o(2374177390592L, 17689);
      return true;
      paramView = localPackageInfo.versionName;
      break;
      label293:
      i = localPackageInfo.versionCode;
      break label246;
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_from_user_name", a(parama, paramau));
      ((Intent)localObject).putExtra("key_biz_uin", paramView.his);
      ((Intent)localObject).putExtra("key_order_id", paramView.hit);
      if ((paramau.field_talker != null) && (!paramau.field_talker.equals("")) && (paramau.field_talker.endsWith("@chatroom"))) {
        ((Intent)localObject).putExtra("key_chatroom_name", paramau.field_talker);
      }
      d.b(parama.uRf.uRz, "card", ".ui.CardGiftAcceptUI", (Intent)localObject);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */