package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.rr;
import com.tencent.mm.e.a.rr.b;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.au;

final class er
  extends ag.a
{
  TextView stp;
  View vNn;
  
  public er(int paramInt)
  {
    super(paramInt);
    GMTrace.i(2400081412096L, 17882);
    this.vNn = null;
    GMTrace.o(2400081412096L, 17882);
  }
  
  public static void a(er paramer, au paramau, boolean paramBoolean, int paramInt, En_5b8fbb1e.a parama)
  {
    GMTrace.i(2400349847552L, 17884);
    if (paramer == null)
    {
      GMTrace.o(2400349847552L, 17884);
      return;
    }
    Object localObject;
    int i;
    if (paramer.vwV != null)
    {
      localObject = paramer.vwV;
      if (paramau.field_status == 6)
      {
        i = 8;
        ((ImageView)localObject).setVisibility(i);
      }
    }
    else
    {
      paramer.vAj.setTag(new ds(paramau, parama.vvA, paramInt, null, 0, (byte)0));
      paramer.vAj.setOnClickListener(parama.vzN.vDb);
      paramer.vAj.setOnLongClickListener(parama.vzN.vDd);
      paramer.vAj.setOnTouchListener(parama.vzN.vDf);
      parama = paramau.gxv;
      if (bf.mA(parama)) {
        break label171;
      }
      paramer.stp.setText(parama);
    }
    for (;;)
    {
      if (paramer.vNn != null) {
        break label201;
      }
      GMTrace.o(2400349847552L, 17884);
      return;
      i = 0;
      break;
      label171:
      if (paramBoolean) {
        paramer.stp.setText(R.l.faY);
      } else {
        paramer.stp.setText(R.l.faZ);
      }
    }
    label201:
    if (!paramau.field_content.equals(au.uIb))
    {
      parama = paramau.field_content;
      localObject = new rr();
      ((rr)localObject).fYy.fJB = 1;
      ((rr)localObject).fYy.content = parama;
      a.uql.m((b)localObject);
      if (((rr)localObject).fYz.type != 3) {
        break label299;
      }
      paramInt = 1;
    }
    while (paramInt != 0) {
      if (paramBoolean)
      {
        paramer.vNn.setBackgroundResource(R.k.dAo);
        GMTrace.o(2400349847552L, 17884);
        return;
        label299:
        paramInt = 0;
      }
      else
      {
        paramer.vNn.setBackgroundResource(R.k.dAp);
        GMTrace.o(2400349847552L, 17884);
        return;
      }
    }
    if (!paramau.field_content.equals(au.uIc))
    {
      paramau = paramau.field_content;
      parama = new rr();
      parama.fYy.fJB = 1;
      parama.fYy.content = paramau;
      a.uql.m(parama);
      if (parama.fYz.type != 2) {
        break label420;
      }
      paramInt = 1;
    }
    while (paramInt != 0) {
      if (paramBoolean)
      {
        paramer.vNn.setBackgroundResource(R.k.dAm);
        GMTrace.o(2400349847552L, 17884);
        return;
        label420:
        paramInt = 0;
      }
      else
      {
        paramer.vNn.setBackgroundResource(R.k.dAn);
      }
    }
    GMTrace.o(2400349847552L, 17884);
  }
  
  public final ag.a ds(View paramView)
  {
    GMTrace.i(2400215629824L, 17883);
    super.dl(paramView);
    if ((this.type == 24) || (this.type == 43) || (this.type == 27) || (this.type == 28))
    {
      this.kvw = ((TextView)paramView.findViewById(R.h.bBt));
      this.stp = ((TextView)paramView.findViewById(R.h.bBU));
      this.vAj = paramView.findViewById(R.h.bzX);
      this.vNn = paramView.findViewById(R.h.bBT);
    }
    if (this.type == 24) {
      this.vwV = ((ImageView)paramView.findViewById(R.h.bBp));
    }
    this.mdQ = ((CheckBox)paramView.findViewById(R.h.bzW));
    this.nQv = paramView.findViewById(R.h.bAQ);
    GMTrace.o(2400215629824L, 17883);
    return this;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/er.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */