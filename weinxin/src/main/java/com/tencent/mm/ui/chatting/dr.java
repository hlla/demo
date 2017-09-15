package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;

final class dr
  extends ag.a
{
  ProgressBar oCh;
  TextView vKY;
  ImageView vKZ;
  View vLa;
  ImageView vwI;
  ImageView vwJ;
  TextView vwP;
  
  public dr(int paramInt)
  {
    super(paramInt);
    GMTrace.i(2527319818240L, 18830);
    GMTrace.o(2527319818240L, 18830);
  }
  
  public final ag.a p(View paramView, boolean paramBoolean)
  {
    GMTrace.i(2527454035968L, 18831);
    super.dl(paramView);
    this.kvw = ((TextView)paramView.findViewById(R.h.bBt));
    this.vwI = ((ImageView)paramView.findViewById(R.h.bAc));
    this.mdQ = ((CheckBox)paramView.findViewById(R.h.bzW));
    this.nQv = paramView.findViewById(R.h.bAQ);
    this.vLa = paramView.findViewById(R.h.cKQ);
    if (paramBoolean)
    {
      this.phd = ((TextView)paramView.findViewById(R.h.bBz));
      this.oCh = ((ProgressBar)paramView.findViewById(R.h.bKq));
      this.type = 1;
    }
    for (;;)
    {
      this.vwP = ((TextView)paramView.findViewById(R.h.bzr));
      this.vKZ = ((ImageView)paramView.findViewById(R.h.bAe));
      GMTrace.o(2527454035968L, 18831);
      return this;
      this.oCh = ((ProgressBar)paramView.findViewById(R.h.cKO));
      this.vKY = ((TextView)paramView.findViewById(R.h.cKP));
      this.phd = ((TextView)paramView.findViewById(R.h.bBz));
      this.type = 3;
      this.vwJ = ((ImageView)paramView.findViewById(R.h.bBr));
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/dr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */