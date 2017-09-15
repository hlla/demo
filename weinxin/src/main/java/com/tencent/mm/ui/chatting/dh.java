package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;

final class dh
  extends ag.a
{
  protected TextView ipd;
  protected TextView vFY;
  protected TextView vFZ;
  protected Button vGa;
  protected Button vGb;
  protected ImageView vGc;
  
  public dh(int paramInt)
  {
    super(paramInt);
    GMTrace.i(2176877330432L, 16219);
    GMTrace.o(2176877330432L, 16219);
  }
  
  public final dh dr(View paramView)
  {
    GMTrace.i(2177011548160L, 16220);
    super.dl(paramView);
    this.ipd = ((TextView)paramView.findViewById(R.h.bzu));
    this.vFY = ((TextView)paramView.findViewById(R.h.bzt));
    this.vFZ = ((TextView)paramView.findViewById(R.h.bzH));
    this.vGa = ((Button)paramView.findViewById(R.h.bAH));
    this.vGb = ((Button)paramView.findViewById(R.h.bAG));
    this.vGc = ((ImageView)paramView.findViewById(R.h.bBu));
    this.mdQ = ((CheckBox)paramView.findViewById(R.h.bzW));
    this.nQv = paramView.findViewById(R.h.bAQ);
    GMTrace.o(2177011548160L, 16220);
    return this;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/dh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */