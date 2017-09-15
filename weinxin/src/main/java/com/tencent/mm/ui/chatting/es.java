package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.storage.au;

final class es
  extends ag.a
{
  TextView stp;
  
  public es(int paramInt)
  {
    super(paramInt);
    GMTrace.i(2240362315776L, 16692);
    GMTrace.o(2240362315776L, 16692);
  }
  
  public static void a(es parames, au paramau, int paramInt, En_5b8fbb1e.a parama)
  {
    GMTrace.i(2240630751232L, 16694);
    if (parames == null)
    {
      GMTrace.o(2240630751232L, 16694);
      return;
    }
    parames.vAj.setTag(new ds(paramau, parama.vvA, paramInt, null, 0, (byte)0));
    parames.vAj.setOnClickListener(parama.vzN.vDb);
    parames.vAj.setOnLongClickListener(parama.vzN.vDd);
    parames.vAj.setOnTouchListener(parama.vzN.vDf);
    GMTrace.o(2240630751232L, 16694);
  }
  
  public final ag.a ds(View paramView)
  {
    GMTrace.i(2240496533504L, 16693);
    super.dl(paramView);
    if (this.type == 39)
    {
      this.kvw = ((TextView)paramView.findViewById(R.h.bBt));
      this.stp = ((TextView)paramView.findViewById(R.h.bBU));
      this.vAj = paramView.findViewById(R.h.bzX);
    }
    for (;;)
    {
      if (this.type == 39) {
        this.vwV = ((ImageView)paramView.findViewById(R.h.bBp));
      }
      this.mdQ = ((CheckBox)paramView.findViewById(R.h.bzW));
      this.nQv = paramView.findViewById(R.h.bAQ);
      GMTrace.o(2240496533504L, 16693);
      return this;
      this.kvw = ((TextView)paramView.findViewById(R.h.bBt));
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/es.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */