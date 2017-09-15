package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.bg.a;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.ui.widget.celltextview.CellTextView;

final class ek
  extends ag.a
{
  View llc;
  private int vMD;
  ImageView vwJ;
  ChattingTranslateView vyp;
  CellTextView xoi;
  
  public ek(int paramInt)
  {
    super(paramInt);
    GMTrace.i(2512690085888L, 18721);
    this.vMD = 0;
    GMTrace.o(2512690085888L, 18721);
  }
  
  public final void a(CellTextView paramCellTextView)
  {
    GMTrace.i(18999861575680L, 141560);
    paramCellTextView.setMaxWidth(this.vMD);
    GMTrace.o(18999861575680L, 141560);
  }
  
  public final ag.a p(View paramView, boolean paramBoolean)
  {
    GMTrace.i(2512824303616L, 18722);
    super.dl(paramView);
    this.kvw = ((TextView)paramView.findViewById(R.h.bBt));
    this.phd = ((TextView)paramView.findViewById(R.h.bBz));
    this.xoi = ((CellTextView)paramView.findViewById(R.h.bAb));
    this.mdQ = ((CheckBox)paramView.findViewById(R.h.bzW));
    this.nQv = paramView.findViewById(R.h.bAQ);
    this.llc = paramView.findViewById(R.h.bzZ);
    this.vyp = ((ChattingTranslateView)paramView.findViewById(R.h.bBw));
    if (paramBoolean) {}
    for (this.type = 2;; this.type = 4)
    {
      this.vMD = ag.eT(aa.getContext());
      float f1 = a.dI(this.xoi.getContext());
      float f2 = this.xoi.getTextSize();
      this.xoi.setTextSize(f1 * f2);
      this.xoi.setOnTouchListener(new ev(new k(this.xoi.getContext())));
      GMTrace.o(2512824303616L, 18722);
      return this;
      this.vwJ = ((ImageView)paramView.findViewById(R.h.bBr));
      this.vwV = ((ImageView)paramView.findViewById(R.h.bBp));
      this.oCh = ((ProgressBar)paramView.findViewById(R.h.cKO));
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */