package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;

final class dp
  extends ag.a
{
  TextView pjl;
  TextView stp;
  View vKR;
  ImageView vKS;
  ImageView vKT;
  TextView vKU;
  TextView vKV;
  TextView vyr;
  
  public dp(int paramInt)
  {
    super(paramInt);
    GMTrace.i(2212310810624L, 16483);
    GMTrace.o(2212310810624L, 16483);
  }
  
  public final ag.a ds(View paramView)
  {
    GMTrace.i(2212445028352L, 16484);
    super.dl(paramView);
    this.kvw = ((TextView)paramView.findViewById(R.h.bBt));
    this.vyr = ((TextView)paramView.findViewById(R.h.bBx));
    this.pjl = ((TextView)paramView.findViewById(R.h.bBA));
    this.stp = ((TextView)paramView.findViewById(R.h.bAb));
    this.vAj = paramView.findViewById(R.h.bzX);
    this.vKV = ((TextView)paramView.findViewById(R.h.bAR));
    this.vKR = paramView.findViewById(R.h.bAv);
    this.vKS = ((ImageView)paramView.findViewById(R.h.byU));
    this.vKT = ((ImageView)paramView.findViewById(R.h.bAw));
    this.vKU = ((TextView)paramView.findViewById(R.h.byV));
    this.mdQ = ((CheckBox)paramView.findViewById(R.h.bzW));
    this.nQv = paramView.findViewById(R.h.bAQ);
    this.type = 9;
    GMTrace.o(2212445028352L, 16484);
    return this;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/dp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */