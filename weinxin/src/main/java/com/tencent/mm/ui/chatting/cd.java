package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.a.dd.b;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

final class cd
  extends ag.b
{
  private En_5b8fbb1e.a vAn;
  
  public cd(int paramInt)
  {
    super(paramInt);
    GMTrace.i(2277674844160L, 16970);
    GMTrace.o(2277674844160L, 16970);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2277809061888L, 16971);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cXN);
      ((View)localObject).setTag(new el(this.klJ).p((View)localObject, true));
    }
    GMTrace.o(2277809061888L, 16971);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2277943279616L, 16972);
    this.vAn = parama1;
    parama = (el)parama;
    el.a(parama, paramau, true, paramInt, parama1, R.g.bdG);
    paramau = paramau.gxt;
    if ((paramau == null) || (paramau.length() == 0))
    {
      parama.vwP.setVisibility(8);
      GMTrace.o(2277943279616L, 16972);
      return;
    }
    parama.vwP.setVisibility(0);
    b(parama1, parama.vwP, ds.TE(paramau));
    GMTrace.o(2277943279616L, 16972);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2278077497344L, 16973);
    ap.yY();
    if (c.isSDCardAvailable())
    {
      int i = ((ds)paramView.getTag()).position;
      r localr = o.KW().lt(paramau.field_imgPath);
      paramContextMenu.add(i, 129, 0, paramView.getContext().getString(R.l.dUl));
      paramContextMenu.add(i, 107, 0, paramView.getContext().getString(R.l.eLz));
      if (d.Jr("favorite")) {
        paramContextMenu.add(i, 116, 0, paramView.getContext().getString(R.l.eFS));
      }
      dd localdd = new dd();
      localdd.fGN.fGD = paramau.field_msgId;
      a.uql.m(localdd);
      if (localdd.fGO.fGl) {
        paramContextMenu.add(i, 128, 0, paramView.getContext().getString(R.l.dUm));
      }
      if ((localr != null) && ((localr.status == 199) || (localr.status == 199)) && (e.Dq()) && (!this.vAn.bVz())) {
        paramContextMenu.add(i, 114, 0, paramView.getContext().getString(R.l.dUd));
      }
      if (!this.vAn.bVz()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(R.l.dUi));
      }
    }
    GMTrace.o(2278077497344L, 16973);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2278211715072L, 16974);
    GMTrace.o(2278211715072L, 16974);
    return false;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2278345932800L, 16975);
    GMTrace.o(2278345932800L, 16975);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */