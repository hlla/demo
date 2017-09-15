package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;

final class l
  extends ag.a
{
  protected TextView kvv;
  protected TextView lLh;
  protected ProgressBar oCh;
  protected TextView vwP;
  protected ImageView vwV;
  
  public l(int paramInt)
  {
    super(paramInt);
    GMTrace.i(2168018960384L, 16153);
    GMTrace.o(2168018960384L, 16153);
  }
  
  public final l dj(View paramView)
  {
    GMTrace.i(2168153178112L, 16154);
    super.dl(paramView);
    this.kvv = ((TextView)paramView.findViewById(R.h.bAb));
    this.oCh = ((ProgressBar)paramView.findViewById(R.h.cKO));
    this.vwV = ((ImageView)paramView.findViewById(R.h.bBp));
    this.lLh = ((TextView)paramView.findViewById(R.h.bzD));
    this.vwP = ((TextView)paramView.findViewById(R.h.bzr));
    this.phd = ((TextView)paramView.findViewById(R.h.bBz));
    this.mdQ = ((CheckBox)paramView.findViewById(R.h.bzW));
    this.nQv = paramView.findViewById(R.h.bAQ);
    GMTrace.o(2168153178112L, 16154);
    return this;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */