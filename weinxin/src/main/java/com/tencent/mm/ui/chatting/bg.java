package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.x.b;
import java.util.Map;

final class bg
  extends ag.b
{
  private En_5b8fbb1e.a vAn;
  private String vBj;
  private String vBk;
  
  public bg()
  {
    super(12);
    GMTrace.i(2392833654784L, 17828);
    GMTrace.o(2392833654784L, 17828);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2392967872512L, 17829);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cXF);
      ((View)localObject).setTag(new x(this.klJ).p((View)localObject, true));
    }
    GMTrace.o(2392967872512L, 17829);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2393236307968L, 17831);
    this.vAn = parama1;
    x localx = (x)parama;
    au.a locala;
    if (parama1.vvA)
    {
      parama = ay.gj(paramau.field_content);
      ap.yY();
      locala = com.tencent.mm.u.c.wT().At(parama);
      if ((locala.rTh == null) || (locala.rTh.length() <= 0)) {
        v.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
      }
      this.vBj = locala.rTh;
      this.vBk = "";
      if (!u.mA(parama))
      {
        parama = com.tencent.mm.sdk.platformtools.bg.q(parama, "msg");
        if (parama.containsKey(".msg.$wechatid")) {
          this.vBk = ((String)parama.get(".msg.$wechatid"));
        }
      }
      b.u(this.vBj, locala.uIh);
      x.I(localx.vAj, localx.vwx);
      if (!o.eW(locala.rUD)) {
        break label431;
      }
      localx.vyr.setText(R.l.dSX);
      localx.vys.setVisibility(8);
      if (!d.eo(16)) {
        break label419;
      }
      localx.vyq.setBackground(null);
      label207:
      p(localx.vyq, this.vBj);
      label219:
      parama = this.vBk;
      if ((!u.mA(parama)) && (!com.tencent.mm.storage.x.aO(parama, true)) && (!o.eT(parama))) {
        break label484;
      }
    }
    label272:
    label419:
    label431:
    label471:
    label484:
    for (int i = 1;; i = 0)
    {
      boolean bool = o.eW(locala.rUD);
      if ((i != 0) || (bool))
      {
        parama = "";
        if (u.mA(parama)) {
          break label471;
        }
        localx.vys.setVisibility(0);
        localx.vys.setText(parama);
      }
      for (;;)
      {
        localx.jUr.setText(h.c(parama1.uRf.uRz, locala.fER, (int)localx.jUr.getTextSize()));
        localx.vAj.setTag(new ds(paramau, parama1.vvA, paramInt, paramString, 0, (byte)0));
        localx.vAj.setOnClickListener(parama1.vzN.vDb);
        localx.vAj.setOnLongClickListener(parama1.vzN.vDd);
        localx.vAj.setOnTouchListener(parama1.vzN.vDf);
        GMTrace.o(2393236307968L, 17831);
        return;
        parama = paramau.field_content;
        break;
        localx.vyq.setBackgroundDrawable(null);
        break label207;
        localx.vyr.setText(R.l.dUK);
        localx.vyq.setBackgroundResource(R.g.ber);
        o(localx.vyq, this.vBj);
        break label219;
        break label272;
        localx.vys.setVisibility(8);
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2393370525696L, 17832);
    int i = ((ds)paramView.getTag()).position;
    ap.yY();
    paramau = com.tencent.mm.u.c.wT().At(paramau.field_content);
    if ((paramau.rTh == null) || (paramau.rTh.length() <= 0)) {
      v.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
    }
    this.vBj = paramau.rTh;
    if (o.eW(paramau.rUD)) {
      paramContextMenu.add(i, 118, 0, paramView.getContext().getString(R.l.eLz));
    }
    if (!this.vAn.bVz()) {
      paramContextMenu.add(i, 100, 0, paramView.getContext().getString(R.l.dUh));
    }
    GMTrace.o(2393370525696L, 17832);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2393504743424L, 17833);
    switch (paramMenuItem.getItemId())
    {
    default: 
      GMTrace.o(2393504743424L, 17833);
      return false;
    }
    paramMenuItem = new Intent(parama.uRf.uRz, MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", parama.cQ(paramau.field_content, paramau.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 8);
    paramMenuItem.putExtra("Retr_Msg_Id", paramau.field_msgId);
    parama.startActivity(paramMenuItem);
    GMTrace.o(2393504743424L, 17833);
    return false;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2393638961152L, 17834);
    GMTrace.o(2393638961152L, 17834);
    return false;
  }
  
  protected final boolean a(En_5b8fbb1e.a parama)
  {
    GMTrace.i(2393102090240L, 17830);
    boolean bool = parama.vvA;
    GMTrace.o(2393102090240L, 17830);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */