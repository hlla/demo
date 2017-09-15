package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.sdk.platformtools.aa;

final class x
  extends ag.a
{
  TextView jUr;
  ImageView vwJ;
  public int vwx;
  ImageView vyq;
  TextView vyr;
  TextView vys;
  
  public x(int paramInt)
  {
    super(paramInt);
    GMTrace.i(2297941721088L, 17121);
    GMTrace.o(2297941721088L, 17121);
  }
  
  public final ag.a p(View paramView, boolean paramBoolean)
  {
    GMTrace.i(2298075938816L, 17122);
    super.dl(paramView);
    this.vyq = ((ImageView)paramView.findViewById(R.h.bzN));
    this.kvw = ((TextView)paramView.findViewById(R.h.bBt));
    this.vyr = ((TextView)paramView.findViewById(R.h.bBx));
    this.vys = ((TextView)paramView.findViewById(R.h.bBA));
    this.jUr = ((TextView)paramView.findViewById(R.h.bAV));
    this.phd = ((TextView)paramView.findViewById(R.h.bBz));
    this.vAj = paramView.findViewById(R.h.bzX);
    this.mdQ = ((CheckBox)paramView.findViewById(R.h.bzW));
    this.nQv = paramView.findViewById(R.h.bAQ);
    if (paramBoolean) {}
    for (int i = 12;; i = 13)
    {
      this.type = i;
      if (!paramBoolean)
      {
        this.vwV = ((ImageView)paramView.findViewById(R.h.bBp));
        this.vwJ = ((ImageView)paramView.findViewById(R.h.bBr));
        this.oCh = ((ProgressBar)paramView.findViewById(R.h.cKO));
      }
      this.vwx = ag.eU(aa.getContext());
      GMTrace.o(2298075938816L, 17122);
      return this;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */