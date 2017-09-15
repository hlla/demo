package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.a.dd.b;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.q;

final class bu
  extends ag.c
{
  private En_5b8fbb1e.a vAn;
  
  public bu()
  {
    super(17);
    GMTrace.i(2252710346752L, 16784);
    GMTrace.o(2252710346752L, 16784);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2252844564480L, 16785);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cYn);
      ((View)localObject).setTag(new dv(this.klJ).p((View)localObject, false));
    }
    GMTrace.o(2252844564480L, 16785);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2252978782208L, 16786);
    this.vAn = parama1;
    dv.a((dv)parama, paramau, false, paramInt, parama1);
    parama = (dv)parama;
    if (bUg())
    {
      if ((paramau.field_status != 2) || (!a(parama1.vzN, paramau.field_msgId))) {
        break label111;
      }
      if (parama.vwJ != null) {
        parama.vwJ.setVisibility(0);
      }
    }
    for (;;)
    {
      a(paramInt, parama, paramau, parama1.vzN.hrv, parama1.vvA, parama1.vzN.vDb);
      GMTrace.o(2252978782208L, 16786);
      return;
      label111:
      if (parama.vwJ != null) {
        parama.vwJ.setVisibility(8);
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2253112999936L, 16787);
    if (paramau.field_type == 48)
    {
      int i = ((ds)paramView.getTag()).position;
      if (paramau.field_status == 5) {
        paramContextMenu.add(i, 103, 0, paramView.getContext().getString(R.l.dVe));
      }
      paramContextMenu.add(i, 126, 0, paramView.getContext().getString(R.l.eLz));
      if ((e.Ds()) && (!this.vAn.bVz())) {
        paramContextMenu.add(i, 114, 0, paramView.getContext().getString(R.l.dUd));
      }
      if (d.Jr("favorite")) {
        paramContextMenu.add(i, 116, 0, paramView.getContext().getString(R.l.eFS));
      }
      dd localdd = new dd();
      localdd.fGN.fGD = paramau.field_msgId;
      a.uql.m(localdd);
      if ((localdd.fGO.fGl) || (g.L(this.vAn.uRf.uRz, paramau.field_type))) {
        paramContextMenu.add(i, 128, 0, paramView.getContext().getString(R.l.dUm));
      }
      if ((!paramau.bLN()) && (paramau.bLZ()) && ((paramau.field_status == 2) || (paramau.gxz == 1)) && (ao(paramau)) && (Tm(paramau.field_talker))) {
        paramContextMenu.add(i, 123, 0, paramView.getContext().getString(R.l.dUp));
      }
      if (!this.vAn.bVz()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(R.l.dUh));
      }
    }
    GMTrace.o(2253112999936L, 16787);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2253247217664L, 16788);
    GMTrace.o(2253247217664L, 16788);
    return false;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2253381435392L, 16789);
    GMTrace.o(2253381435392L, 16789);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */