package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.c;
import com.tencent.mm.u.ap;

final class bv
  extends ag.b
{
  private En_5b8fbb1e.a vAn;
  
  public bv()
  {
    super(8);
    GMTrace.i(2205197271040L, 16430);
    GMTrace.o(2205197271040L, 16430);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2205331488768L, 16431);
    View localView;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localView = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localView = paramLayoutInflater.inflate(R.i.cXK, null);
      paramLayoutInflater = new dw(this.klJ);
      paramLayoutInflater.kvw = ((TextView)localView.findViewById(R.h.bBt));
      paramLayoutInflater.phd = ((TextView)localView.findViewById(R.h.bBz));
      paramLayoutInflater.vwI = ((ImageView)localView.findViewById(R.h.bAP));
      paramLayoutInflater.sto = ((TextView)localView.findViewById(R.h.bBv));
      paramLayoutInflater.stp = ((TextView)localView.findViewById(R.h.bAb));
      paramLayoutInflater.vAj = localView.findViewById(R.h.bzX);
      localView.setTag(paramLayoutInflater);
    }
    GMTrace.o(2205331488768L, 16431);
    return localView;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2205465706496L, 16432);
    this.vAn = parama1;
    parama = (dw)parama;
    ap.yY();
    paramString = com.tencent.mm.u.c.wT().Ar(paramau.field_content);
    parama.sto.setText(paramString.title);
    parama.stp.setText(paramString.content);
    a(parama, paramString.hRv);
    ImageView localImageView = parama.vwI;
    if (paramString.lHO) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      parama.vAj.setTag(new ds(paramau, parama1.vvA, paramInt, null, 0, (byte)0));
      parama.vAj.setOnClickListener(parama1.vzN.vDb);
      parama.vAj.setOnLongClickListener(parama1.vzN.vDd);
      parama.vAj.setOnTouchListener(parama1.vzN.vDf);
      GMTrace.o(2205465706496L, 16432);
      return;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2205734141952L, 16434);
    int i = ((ds)paramView.getTag()).position;
    if (!this.vAn.bVz()) {
      paramContextMenu.add(i, 100, 0, paramView.getContext().getString(R.l.dUh));
    }
    GMTrace.o(2205734141952L, 16434);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2205868359680L, 16435);
    GMTrace.o(2205868359680L, 16435);
    return false;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2206002577408L, 16436);
    GMTrace.o(2206002577408L, 16436);
    return false;
  }
  
  protected final boolean bUf()
  {
    GMTrace.i(2205599924224L, 16433);
    GMTrace.o(2205599924224L, 16433);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */