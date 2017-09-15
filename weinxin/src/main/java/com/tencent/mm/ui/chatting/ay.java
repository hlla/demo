package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ao.e;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

final class ay
  extends ag.c
{
  public En_5b8fbb1e.a vAn;
  
  public ay()
  {
    super(23);
    GMTrace.i(2243180888064L, 16713);
    GMTrace.o(2243180888064L, 16713);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2243315105792L, 16714);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof n)))
    {
      localObject = paramView;
      if (((n)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cYi);
      ((View)localObject).setTag(new l(this.klJ).dj((View)localObject));
    }
    GMTrace.o(2243315105792L, 16714);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2243449323520L, 16715);
    l locall = (l)parama;
    this.vAn = parama1;
    parama1.aI(paramau);
    parama = paramau.field_content;
    if (parama != null) {}
    for (parama = f.a.B(parama, paramau.field_reserved);; parama = null)
    {
      f localf;
      if ((parama != null) && (parama.type == 1))
      {
        locall.kvv.setText(parama.title);
        locall.kvv.setClickable(true);
        h.d(locall.kvv, 1);
        localf = com.tencent.mm.pluginsdk.model.app.g.aJ(parama.appId, true);
        if ((localf != null) && (localf.field_appName != null) && (localf.field_appName.trim().length() > 0)) {
          break label384;
        }
        paramString = parama.appName;
        if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.g.bn(paramString))) {
          break label394;
        }
        locall.lLh.setText(parama1.getString(R.l.dVx, new Object[] { com.tencent.mm.pluginsdk.model.app.g.a(parama1.uRf.uRz, localf, paramString) }));
        locall.lLh.setVisibility(0);
        a(parama1, locall.lLh, parama.appId);
        a(parama1, locall.lLh, parama.appId);
        label228:
        if ((paramau.field_status != 2) && (paramau.field_status != 5)) {
          break label407;
        }
        locall.oCh.setVisibility(8);
      }
      for (;;)
      {
        a(paramInt, locall, paramau, parama1.vzN.hrv, parama1.vvA, parama1.vzN.vDb);
        locall.kvv.setTag(new ds(paramau, parama1.vvA, paramInt, null, 0, (byte)0));
        locall.kvv.setOnClickListener(parama1.vzN.vDb);
        ap.yY();
        if (c.isSDCardAvailable())
        {
          locall.kvv.setOnLongClickListener(parama1.vzN.vDd);
          if ((parama != null) && (parama.type != 1)) {
            locall.kvv.setOnTouchListener(parama1.vzN.vDf);
          }
        }
        GMTrace.o(2243449323520L, 16715);
        return;
        label384:
        paramString = localf.field_appName;
        break;
        label394:
        locall.lLh.setVisibility(8);
        break label228;
        label407:
        locall.oCh.setVisibility(0);
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2243583541248L, 16716);
    int i = ((ds)paramView.getTag()).position;
    paramContextMenu.add(i, 111, 0, this.vAn.getString(R.l.eLz));
    if (com.tencent.mm.bb.d.Jr("favorite")) {
      paramContextMenu.add(i, 116, 0, this.vAn.getString(R.l.eFS));
    }
    if ((!paramau.bLN()) && ((paramau.field_status == 2) || (paramau.gxz == 1)) && (ao(paramau)) && (Tm(paramau.field_talker))) {
      paramContextMenu.add(i, 123, 0, paramView.getContext().getString(R.l.dUp));
    }
    if (!this.vAn.bVz()) {
      paramContextMenu.add(i, 100, 0, this.vAn.getString(R.l.dUh));
    }
    GMTrace.o(2243583541248L, 16716);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2243717758976L, 16717);
    switch (paramMenuItem.getItemId())
    {
    default: 
      GMTrace.o(2243717758976L, 16717);
      return false;
    case 100: 
      com.tencent.mm.u.ay.L(paramau.field_msgId);
      ap.yY();
      c.wQ().b(new e(paramau.field_talker, paramau.field_msgSvrId));
      GMTrace.o(2243717758976L, 16717);
      return false;
    case 102: 
      ((ClipboardManager)parama.uRf.uRz.getSystemService("clipboard")).setText(parama.cQ(f.a.ek(paramau.field_content).title, paramau.field_isSend));
      GMTrace.o(2243717758976L, 16717);
      return false;
    }
    paramMenuItem = new Intent(parama.uRf.uRz, MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", paramau.field_content);
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", paramau.field_msgId);
    parama.startActivity(paramMenuItem);
    GMTrace.o(2243717758976L, 16717);
    return false;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, final au paramau)
  {
    GMTrace.i(2243851976704L, 16718);
    if ((((ds)paramView.getTag()).klJ == 5) && (paramau.field_isSend == 1))
    {
      if (paramau != null) {
        com.tencent.mm.ui.base.g.b(this.vAn.uRf.uRz, this.vAn.getString(R.l.dVd), "", this.vAn.getString(R.l.dIn), this.vAn.getString(R.l.dGk), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(2257005314048L, 16816);
            com.tencent.mm.pluginsdk.model.app.l.V(paramau);
            com.tencent.mm.u.ay.L(paramau.field_msgId);
            ay.this.vAn.bVv();
            GMTrace.o(2257005314048L, 16816);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(2266803208192L, 16889);
            GMTrace.o(2266803208192L, 16889);
          }
        });
      }
      GMTrace.o(2243851976704L, 16718);
      return true;
    }
    GMTrace.o(2243851976704L, 16718);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */