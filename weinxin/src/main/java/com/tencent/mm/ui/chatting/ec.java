package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;

final class ec
  extends ag.a
{
  protected TextView ipd;
  protected ImageView vMf;
  
  public ec(int paramInt)
  {
    super(paramInt);
    GMTrace.i(2246267895808L, 16736);
    GMTrace.o(2246267895808L, 16736);
  }
  
  public final ec dt(View paramView)
  {
    GMTrace.i(2246402113536L, 16737);
    super.dl(paramView);
    this.ipd = ((TextView)paramView.findViewById(R.h.bzu));
    this.vMf = ((ImageView)paramView.findViewById(R.h.bzG));
    this.mdQ = ((CheckBox)paramView.findViewById(R.h.bzW));
    this.nQv = paramView.findViewById(R.h.bAQ);
    GMTrace.o(2246402113536L, 16737);
    return this;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */