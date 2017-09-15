package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.j.a;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

final class bh
  extends ag.c
{
  private En_5b8fbb1e.a vAn;
  private String vBj;
  
  public bh()
  {
    super(13);
    GMTrace.i(2265326813184L, 16878);
    GMTrace.o(2265326813184L, 16878);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2265461030912L, 16879);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cYk);
      ((View)localObject).setTag(new x(this.klJ).p((View)localObject, false));
    }
    GMTrace.o(2265461030912L, 16879);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2265595248640L, 16880);
    this.vAn = parama1;
    x localx = (x)parama;
    ap.yY();
    au.a locala = com.tencent.mm.u.c.wT().At(paramau.field_content);
    if ((locala.rTh == null) || (locala.rTh.length() <= 0)) {
      v.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
    }
    this.vBj = locala.rTh;
    v.d("MicroMsg.ChattingItemCardTo", "dancy is biz: %s, userName: %s ", new Object[] { Boolean.valueOf(o.eV(this.vBj)), this.vBj });
    x.I(localx.vAj, localx.vwx);
    label179:
    int i;
    if (o.eW(locala.rUD))
    {
      localx.vyr.setText(R.l.dSX);
      localx.vys.setVisibility(8);
      if (d.eo(16))
      {
        localx.vyq.setBackground(null);
        p(localx.vyq, this.vBj);
        localx.jUr.setText(h.b(parama1.uRf.uRz, locala.fER, localx.jUr.getTextSize()));
        i = 0;
        paramString = locala.gtH;
        if (u.mA(this.vBj)) {
          break label595;
        }
        ap.yY();
        parama = com.tencent.mm.u.c.wR().Rb(this.vBj);
        if ((parama == null) || (!a.ez(parama.field_type))) {
          break label595;
        }
        com.tencent.mm.storage.x.bKT();
        label265:
        parama = paramString;
        int j = i;
        if (i == 0)
        {
          parama = paramString;
          j = i;
          if (u.mA(paramString))
          {
            parama = this.vBj;
            if ((!u.mA(parama)) && (!com.tencent.mm.storage.x.aO(parama, true)) && (!o.eT(parama))) {
              break label601;
            }
            i = 1;
            label322:
            j = i;
          }
        }
        boolean bool = o.eW(locala.rUD);
        if ((j != 0) || (bool)) {
          parama = "";
        }
        if (u.mA(parama)) {
          break label607;
        }
        localx.vys.setVisibility(0);
        localx.vys.setText(parama);
        label375:
        localx.vAj.setTag(new ds(paramau, parama1.vvA, paramInt, null, 0, (byte)0));
        localx.vAj.setOnClickListener(parama1.vzN.vDb);
        localx.vAj.setOnLongClickListener(parama1.vzN.vDd);
        localx.vAj.setOnTouchListener(parama1.vzN.vDf);
        if (!bUg()) {
          break label641;
        }
        if (localx.oCh != null) {
          localx.oCh.setVisibility(8);
        }
        if ((paramau.field_status != 2) || (!a(parama1.vzN, paramau.field_msgId))) {
          break label620;
        }
        if (localx.vwJ != null) {
          localx.vwJ.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      a(paramInt, localx, paramau, parama1.vzN.hrv, parama1.vvA, parama1.vzN.vDb);
      GMTrace.o(2265595248640L, 16880);
      return;
      localx.vyq.setBackgroundDrawable(null);
      break;
      localx.vyr.setText(R.l.dUK);
      localx.vyq.setBackgroundResource(R.g.ber);
      o(localx.vyq, this.vBj);
      break label179;
      label595:
      i = 1;
      break label265;
      label601:
      i = 0;
      break label322;
      label607:
      localx.vys.setVisibility(8);
      break label375;
      label620:
      if (localx.vwJ != null)
      {
        localx.vwJ.setVisibility(8);
        continue;
        label641:
        if (localx.oCh != null)
        {
          localx.oCh.setVisibility(0);
          if (paramau.field_status >= 2) {
            localx.oCh.setVisibility(8);
          }
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2265729466368L, 16881);
    int i = ((ds)paramView.getTag()).position;
    ap.yY();
    au.a locala = com.tencent.mm.u.c.wT().At(paramau.field_content);
    if ((locala.rTh == null) || (locala.rTh.length() <= 0)) {
      v.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
    }
    this.vBj = locala.rTh;
    if (o.eW(locala.rUD)) {
      paramContextMenu.add(i, 118, 0, paramView.getContext().getString(R.l.eLz));
    }
    if ((!paramau.bLN()) && ((paramau.field_status == 2) || (paramau.gxz == 1)) && (paramau.bLY()) && (ao(paramau)) && (Tm(paramau.field_talker))) {
      paramContextMenu.add(i, 123, 0, paramView.getContext().getString(R.l.dUp));
    }
    if (!this.vAn.bVz()) {
      paramContextMenu.add(i, 100, 0, paramView.getContext().getString(R.l.dUh));
    }
    GMTrace.o(2265729466368L, 16881);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2265863684096L, 16882);
    switch (paramMenuItem.getItemId())
    {
    default: 
      GMTrace.o(2265863684096L, 16882);
      return false;
    }
    paramMenuItem = new Intent(parama.uRf.uRz, MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", parama.cQ(paramau.field_content, paramau.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 8);
    paramMenuItem.putExtra("Retr_Msg_Id", paramau.field_msgId);
    parama.startActivity(paramMenuItem);
    GMTrace.o(2265863684096L, 16882);
    return false;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2265997901824L, 16883);
    GMTrace.o(2265997901824L, 16883);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */