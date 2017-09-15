package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;

final class ei
  extends ag.a
{
  TextView ipd;
  
  public ei(int paramInt)
  {
    super(paramInt);
    GMTrace.i(2202110263296L, 16407);
    GMTrace.o(2202110263296L, 16407);
  }
  
  public final ag.a du(View paramView)
  {
    GMTrace.i(2202244481024L, 16408);
    super.dl(paramView);
    this.kvw = ((TextView)paramView.findViewById(R.h.bBt));
    this.phd = ((TextView)paramView.findViewById(R.h.bBz));
    this.ipd = ((TextView)paramView.findViewById(R.h.bAb));
    this.mdQ = ((CheckBox)paramView.findViewById(R.h.bzW));
    this.nQv = paramView.findViewById(R.h.bAQ);
    this.type = 2;
    GMTrace.o(2202244481024L, 16408);
    return this;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */