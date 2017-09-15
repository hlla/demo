package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.widget.MMTextView;

final class w
  extends ag.a
{
  View llc;
  ImageView vwJ;
  MMTextView vyo;
  ChattingTranslateView vyp;
  
  public w(int paramInt)
  {
    super(paramInt);
    GMTrace.i(2187212095488L, 16296);
    GMTrace.o(2187212095488L, 16296);
  }
  
  public final ag.a p(View paramView, boolean paramBoolean)
  {
    GMTrace.i(2187346313216L, 16297);
    super.dl(paramView);
    this.kvw = ((TextView)paramView.findViewById(R.h.bBt));
    this.phd = ((TextView)paramView.findViewById(R.h.bBz));
    this.vyo = ((MMTextView)paramView.findViewById(R.h.bAb));
    this.mdQ = ((CheckBox)paramView.findViewById(R.h.bzW));
    this.nQv = paramView.findViewById(R.h.bAQ);
    this.llc = paramView.findViewById(R.h.bzZ);
    this.vyp = ((ChattingTranslateView)paramView.findViewById(R.h.bBw));
    if (paramBoolean) {}
    for (this.type = 2;; this.type = 4)
    {
      GMTrace.o(2187346313216L, 16297);
      return this;
      this.vwJ = ((ImageView)paramView.findViewById(R.h.bBr));
      this.vwV = ((ImageView)paramView.findViewById(R.h.bBp));
      this.oCh = ((ProgressBar)paramView.findViewById(R.h.cKO));
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */