package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.pluginsdk.l.a;
import com.tencent.mm.pluginsdk.l.s;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ay;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

final class at
  extends ag.b
{
  private En_5b8fbb1e.a vAn;
  
  public at()
  {
    super(48);
    GMTrace.i(2177145765888L, 16221);
    GMTrace.o(2177145765888L, 16221);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2177279983616L, 16222);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof j)))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cXB);
      ((View)localObject).setTag(new j(this.klJ).dh((View)localObject));
    }
    GMTrace.o(2177279983616L, 16222);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2177414201344L, 16223);
    j localj = (j)parama;
    this.vAn = parama1;
    com.tencent.mm.t.f localf = an.bDc().ec(paramau.field_msgId);
    parama = paramau.field_content;
    if (parama1.vzR)
    {
      int i = paramau.field_content.indexOf(':');
      if (i != -1) {
        parama = paramau.field_content.substring(i + 1);
      }
    }
    for (;;)
    {
      if ((localf != null) && (parama != null))
      {
        parama = f.a.B(parama, paramau.field_reserved);
        if (parama != null)
        {
          localj.vwR.setText(parama.title);
          parama = new ds(paramau, parama1.vvA, paramInt, null, 0, (byte)0);
          localj.vAj.setTag(parama);
          localj.vAj.setOnClickListener(parama1.vzN.vDb);
          if (this.sWq)
          {
            localj.vAj.setOnLongClickListener(parama1.vzN.vDd);
            localj.vAj.setOnTouchListener(parama1.vzN.vDf);
          }
        }
        if ((l.a.szS != null) && (l.a.szS.zq(parama1.bTW())))
        {
          localj.vwR.setTextColor(parama1.bOZ().getResources().getColor(R.e.aVo));
          localj.vAj.setClickable(true);
          localj.vAj.setEnabled(true);
          GMTrace.o(2177414201344L, 16223);
        }
      }
      else
      {
        if (localf == null) {}
        for (boolean bool = true;; bool = false)
        {
          v.e("MicroMsg.ChattingItemAppMsgLocationShareFrom", "amessage:%b, %s, %s", new Object[] { Boolean.valueOf(bool), parama, Long.valueOf(paramau.field_msgId), paramString });
          parama = null;
          break;
        }
      }
      localj.vwR.setTextColor(-8750470);
      localj.vAj.setClickable(false);
      localj.vAj.setEnabled(false);
      GMTrace.o(2177414201344L, 16223);
      return;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2177548419072L, 16224);
    int i = ((ds)paramView.getTag()).position;
    com.tencent.mm.pluginsdk.model.app.l.Mf(this.vAn.cQ(paramau.field_content, paramau.field_isSend));
    paramau = f.a.ek(this.vAn.cQ(paramau.field_content, paramau.field_isSend));
    com.tencent.mm.pluginsdk.model.app.f localf = g.aJ(paramau.appId, false);
    if ((d.Jr("favorite")) && ((localf == null) || (!localf.bCM()))) {
      switch (paramau.type)
      {
      }
    }
    for (;;)
    {
      if (!this.vAn.bVz()) {
        paramContextMenu.add(i, 100, 0, this.vAn.getString(R.l.dUh));
      }
      GMTrace.o(2177548419072L, 16224);
      return true;
      paramContextMenu.add(i, 116, 0, paramView.getContext().getString(R.l.eFS));
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2177682636800L, 16225);
    switch (paramMenuItem.getItemId())
    {
    default: 
      GMTrace.o(2177682636800L, 16225);
      return false;
    case 100: 
      Object localObject = paramau.field_content;
      paramMenuItem = null;
      if (localObject != null) {
        paramMenuItem = f.a.ek((String)localObject);
      }
      if (paramMenuItem == null)
      {
        GMTrace.o(2177682636800L, 16225);
        return false;
      }
      com.tencent.mm.pluginsdk.model.app.l.ed(paramau.field_msgId);
      ay.L(paramau.field_msgId);
      localObject = g.aJ(paramMenuItem.appId, false);
      if ((localObject != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject).bCM())) {
        a(parama, paramMenuItem, paramau, (com.tencent.mm.pluginsdk.model.app.f)localObject);
      }
      GMTrace.o(2177682636800L, 16225);
      return false;
    }
    paramMenuItem = new Intent(parama.uRf.uRz, MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", parama.cQ(paramau.field_content, paramau.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", paramau.field_msgId);
    parama.startActivity(paramMenuItem);
    GMTrace.o(2177682636800L, 16225);
    return false;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2177816854528L, 16226);
    parama.bTW();
    parama.aX("fromMessage", true);
    GMTrace.o(2177816854528L, 16226);
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */