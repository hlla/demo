package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.a.dd.b;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

final class ce
  extends ag.c
{
  private En_5b8fbb1e.a vAn;
  
  public ce(int paramInt)
  {
    super(paramInt);
    GMTrace.i(2288949133312L, 17054);
    GMTrace.o(2288949133312L, 17054);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2289083351040L, 17055);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cYq);
      ((View)localObject).setTag(new el(this.klJ).p((View)localObject, false));
    }
    GMTrace.o(2289083351040L, 17055);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2289217568768L, 17056);
    this.vAn = parama1;
    parama = (el)parama;
    el.a(parama, paramau, false, paramInt, parama1, R.g.bdI);
    if (bUg())
    {
      paramString = t.lI(paramau.field_imgPath);
      if ((paramString != null) && (paramString.status == 199) && (a(parama1.vzN, paramau.field_msgId)))
      {
        if (parama.vwJ != null)
        {
          parama.vwJ.setVisibility(0);
          GMTrace.o(2289217568768L, 17056);
        }
      }
      else if (parama.vwJ != null) {
        parama.vwJ.setVisibility(8);
      }
    }
    GMTrace.o(2289217568768L, 17056);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2289351786496L, 17057);
    ap.yY();
    if (c.isSDCardAvailable())
    {
      int i = ((ds)paramView.getTag()).position;
      r localr = o.KW().lt(paramau.field_imgPath);
      paramContextMenu.add(i, 129, 0, paramView.getContext().getString(R.l.dUl));
      if (localr != null)
      {
        int j = localr.status;
        if ((104 != j) && (103 != j) && (105 != j) && (106 != j)) {
          paramContextMenu.add(i, 107, 0, paramView.getContext().getString(R.l.eLz));
        }
      }
      if ((localr != null) && ((localr.status == 199) || (localr.status == 199)))
      {
        if (d.Jr("favorite")) {
          paramContextMenu.add(i, 116, 0, paramView.getContext().getString(R.l.eFS));
        }
        dd localdd = new dd();
        localdd.fGN.fGD = paramau.field_msgId;
        a.uql.m(localdd);
        if (localdd.fGO.fGl) {
          paramContextMenu.add(i, 128, 0, paramView.getContext().getString(R.l.dUm));
        }
        if ((!paramau.bLN()) && ((paramau.bMb()) || (paramau.bMc())) && (ao(paramau)) && ((localr.status == 199) || (localr.status == 199) || (paramau.gxz == 1)) && (Tm(paramau.field_talker))) {
          paramContextMenu.add(i, 123, 0, paramView.getContext().getString(R.l.dUp));
        }
        if ((e.Dq()) && (!this.vAn.bVz())) {
          paramContextMenu.add(i, 114, 0, paramView.getContext().getString(R.l.dUd));
        }
      }
      if (!this.vAn.bVz()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(R.l.dUi));
      }
    }
    GMTrace.o(2289351786496L, 17057);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2289486004224L, 17058);
    GMTrace.o(2289486004224L, 17058);
    return false;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2289620221952L, 17059);
    GMTrace.o(2289620221952L, 17059);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */