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
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ay;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

final class au
  extends ag.c
{
  private En_5b8fbb1e.a vAn;
  
  public au()
  {
    super(49);
    GMTrace.i(2380754059264L, 17738);
    GMTrace.o(2380754059264L, 17738);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2380888276992L, 17739);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof j)))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cYg);
      ((View)localObject).setTag(new j(this.klJ).dh((View)localObject));
    }
    GMTrace.o(2380888276992L, 17739);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, com.tencent.mm.storage.au paramau, String paramString)
  {
    GMTrace.i(2381022494720L, 17740);
    paramString = (j)parama;
    this.vAn = parama1;
    parama = paramau.field_content;
    if (parama != null) {}
    for (parama = f.a.B(parama, paramau.field_reserved);; parama = null)
    {
      if (parama != null)
      {
        paramau = new ds(paramau, parama1.vvA, paramInt, null, 0, (byte)0);
        paramString.vAj.setTag(paramau);
        paramString.vAj.setOnClickListener(parama1.vzN.vDb);
        if (this.sWq)
        {
          paramString.vAj.setOnLongClickListener(parama1.vzN.vDd);
          paramString.vAj.setOnTouchListener(parama1.vzN.vDf);
        }
        paramString.vwR.setText(parama.title);
      }
      if ((l.a.szS != null) && (l.a.szS.zq(parama1.bTW())))
      {
        paramString.vwR.setTextColor(parama1.bOZ().getResources().getColor(R.e.aVo));
        paramString.vAj.setClickable(true);
        paramString.vAj.setEnabled(true);
        GMTrace.o(2381022494720L, 17740);
        return;
      }
      paramString.vwR.setTextColor(-8750470);
      paramString.vAj.setClickable(false);
      paramString.vAj.setEnabled(false);
      GMTrace.o(2381022494720L, 17740);
      return;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, com.tencent.mm.storage.au paramau)
  {
    GMTrace.i(2381156712448L, 17741);
    int i = ((ds)paramView.getTag()).position;
    com.tencent.mm.pluginsdk.model.app.l.Mf(this.vAn.cQ(paramau.field_content, paramau.field_isSend));
    f.a locala = f.a.ek(this.vAn.cQ(paramau.field_content, paramau.field_isSend));
    f localf = g.aJ(locala.appId, false);
    if ((d.Jr("favorite")) && ((localf == null) || (!localf.bCM()))) {
      switch (locala.type)
      {
      }
    }
    for (;;)
    {
      if ((!paramau.bLN()) && (paramau.bLZ()) && ((paramau.field_status == 2) || (paramau.gxz == 1)) && (ao(paramau)) && (Tm(paramau.field_talker))) {
        paramContextMenu.add(i, 123, 0, paramView.getContext().getString(R.l.dUp));
      }
      if (!this.vAn.bVz()) {
        paramContextMenu.add(i, 100, 0, this.vAn.getString(R.l.dUh));
      }
      GMTrace.o(2381156712448L, 17741);
      return true;
      paramContextMenu.add(i, 116, 0, paramView.getContext().getString(R.l.eFS));
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, com.tencent.mm.storage.au paramau)
  {
    GMTrace.i(2381290930176L, 17742);
    switch (paramMenuItem.getItemId())
    {
    default: 
      GMTrace.o(2381290930176L, 17742);
      return false;
    case 100: 
      Object localObject = paramau.field_content;
      paramMenuItem = null;
      if (localObject != null) {
        paramMenuItem = f.a.ek((String)localObject);
      }
      if (paramMenuItem == null)
      {
        GMTrace.o(2381290930176L, 17742);
        return false;
      }
      com.tencent.mm.pluginsdk.model.app.l.ed(paramau.field_msgId);
      ay.L(paramau.field_msgId);
      localObject = g.aJ(paramMenuItem.appId, false);
      if ((localObject != null) && (((f)localObject).bCM())) {
        a(parama, paramMenuItem, paramau, (f)localObject);
      }
      GMTrace.o(2381290930176L, 17742);
      return false;
    }
    paramMenuItem = new Intent(parama.uRf.uRz, MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", parama.cQ(paramau.field_content, paramau.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", paramau.field_msgId);
    parama.startActivity(paramMenuItem);
    GMTrace.o(2381290930176L, 17742);
    return false;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, com.tencent.mm.storage.au paramau)
  {
    GMTrace.i(2381425147904L, 17743);
    parama.bTW();
    parama.aX("fromMessage", true);
    GMTrace.o(2381425147904L, 17743);
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */