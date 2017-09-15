package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
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

final class bt
  extends ag.b
{
  private En_5b8fbb1e.a vAn;
  
  public bt()
  {
    super(16);
    GMTrace.i(2528393560064L, 18838);
    GMTrace.o(2528393560064L, 18838);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2528527777792L, 18839);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cXJ);
      ((View)localObject).setTag(new dv(this.klJ).p((View)localObject, true));
    }
    GMTrace.o(2528527777792L, 18839);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2528661995520L, 18840);
    this.vAn = parama1;
    dv.a((dv)parama, paramau, true, paramInt, parama1);
    GMTrace.o(2528661995520L, 18840);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2528796213248L, 18841);
    if (paramau.field_type == 48)
    {
      int i = ((ds)paramView.getTag()).position;
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
      if (!this.vAn.bVz()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(R.l.dUh));
      }
    }
    GMTrace.o(2528796213248L, 18841);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2528930430976L, 18842);
    GMTrace.o(2528930430976L, 18842);
    return false;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2529064648704L, 18843);
    GMTrace.o(2529064648704L, 18843);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */