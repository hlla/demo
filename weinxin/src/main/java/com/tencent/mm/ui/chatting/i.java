package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;

final class i
  extends ag.a
{
  protected View lJd;
  protected TextView lLh;
  protected ImageView mdM;
  protected ImageView mdS;
  protected TextView vwO;
  protected TextView vwP;
  protected ImageView vwQ;
  
  public i(int paramInt)
  {
    super(paramInt);
    GMTrace.i(2296465326080L, 17110);
    GMTrace.o(2296465326080L, 17110);
  }
  
  public final i dg(View paramView)
  {
    GMTrace.i(2296599543808L, 17111);
    super.dl(paramView);
    this.mdM = ((ImageView)paramView.findViewById(R.h.bzG));
    this.lLh = ((TextView)paramView.findViewById(R.h.bzD));
    this.vwO = ((TextView)paramView.findViewById(R.h.bzw));
    this.lJd = paramView.findViewById(R.h.bzx);
    this.vwP = ((TextView)paramView.findViewById(R.h.bzr));
    this.phd = ((TextView)paramView.findViewById(R.h.bBz));
    this.vwQ = ((ImageView)paramView.findViewById(R.h.bzy));
    this.mdQ = ((CheckBox)paramView.findViewById(R.h.bzW));
    this.nQv = paramView.findViewById(R.h.bAQ);
    this.mdS = ((ImageView)paramView.findViewById(R.h.bAe));
    GMTrace.o(2296599543808L, 17111);
    return this;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */