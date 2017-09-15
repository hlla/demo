package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ao.e;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

final class ax
  extends ag.b
{
  private En_5b8fbb1e.a vAn;
  
  public ax()
  {
    super(22);
    GMTrace.i(2247610073088L, 16746);
    GMTrace.o(2247610073088L, 16746);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2247744290816L, 16747);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof n)))
    {
      localObject = paramView;
      if (((n)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cXD);
      ((View)localObject).setTag(new l(this.klJ).dj((View)localObject));
    }
    GMTrace.o(2247744290816L, 16747);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2247878508544L, 16748);
    this.vAn = parama1;
    parama1.aI(paramau);
    l locall = (l)parama;
    paramString = paramau.field_content;
    parama = paramString;
    if (parama1.vzR)
    {
      int i = paramau.field_content.indexOf(':');
      parama = paramString;
      if (i != -1) {
        parama = paramau.field_content.substring(i + 1);
      }
    }
    if (parama != null) {}
    for (parama = f.a.B(parama, paramau.field_reserved);; parama = null)
    {
      f localf;
      if ((parama != null) && (parama.type == 1))
      {
        localf = g.aJ(parama.appId, true);
        if ((localf != null) && (localf.field_appName != null) && (localf.field_appName.trim().length() > 0)) {
          break label417;
        }
        paramString = parama.appName;
        if ((parama.appId == null) || (parama.appId.length() <= 0) || (!g.bn(paramString))) {
          break label427;
        }
        locall.lLh.setText(parama1.getString(R.l.dVx, new Object[] { g.a(parama1.uRf.uRz, localf, paramString) }));
        locall.lLh.setVisibility(0);
        a(parama1, locall.lLh, parama.appId);
        a(parama1, locall.lLh, parama.appId);
        label242:
        if ((parama.gxt == null) || (parama.gxt.length() <= 0)) {
          break label440;
        }
        b(parama1, locall.vwP, ds.TE(parama.gxt));
        locall.vwP.setVisibility(0);
      }
      for (;;)
      {
        locall.kvv.setText(parama.title);
        locall.kvv.setClickable(true);
        h.d(locall.kvv, 1);
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
        GMTrace.o(2247878508544L, 16748);
        return;
        label417:
        paramString = localf.field_appName;
        break;
        label427:
        locall.lLh.setVisibility(8);
        break label242;
        label440:
        locall.vwP.setVisibility(8);
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2248012726272L, 16749);
    int i = ((ds)paramView.getTag()).position;
    paramContextMenu.add(i, 111, 0, this.vAn.getString(R.l.eLz));
    if (com.tencent.mm.bb.d.Jr("favorite")) {
      paramContextMenu.add(i, 116, 0, this.vAn.getString(R.l.eFS));
    }
    if (!this.vAn.bVz()) {
      paramContextMenu.add(i, 100, 0, this.vAn.getString(R.l.dUh));
    }
    GMTrace.o(2248012726272L, 16749);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2248146944000L, 16750);
    switch (paramMenuItem.getItemId())
    {
    default: 
      GMTrace.o(2248146944000L, 16750);
      return false;
    case 100: 
      ay.L(paramau.field_msgId);
      ap.yY();
      c.wQ().b(new e(paramau.field_talker, paramau.field_msgSvrId));
      GMTrace.o(2248146944000L, 16750);
      return false;
    case 102: 
      ((ClipboardManager)parama.uRf.uRz.getSystemService("clipboard")).setText(parama.cQ(f.a.ek(parama.cQ(paramau.field_content, paramau.field_isSend)).title, paramau.field_isSend));
      GMTrace.o(2248146944000L, 16750);
      return false;
    }
    paramMenuItem = new Intent(parama.uRf.uRz, MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", parama.cQ(paramau.field_content, paramau.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", paramau.field_msgId);
    parama.startActivity(paramMenuItem);
    GMTrace.o(2248146944000L, 16750);
    return false;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2248281161728L, 16751);
    GMTrace.o(2248281161728L, 16751);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */