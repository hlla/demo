package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;

final class eb
  extends ag.a
{
  TextView lLh;
  TextView stp;
  
  public eb(int paramInt)
  {
    super(paramInt);
    GMTrace.i(2144933511168L, 15981);
    GMTrace.o(2144933511168L, 15981);
  }
  
  public final ag.a ds(View paramView)
  {
    GMTrace.i(2145067728896L, 15982);
    super.dl(paramView);
    this.kvw = ((TextView)paramView.findViewById(R.h.bBt));
    this.phd = ((TextView)paramView.findViewById(R.h.bBz));
    this.stp = ((TextView)paramView.findViewById(R.h.bAb));
    this.lLh = ((TextView)paramView.findViewById(R.h.bBe));
    this.mdQ = ((CheckBox)paramView.findViewById(R.h.bzW));
    this.nQv = paramView.findViewById(R.h.bAQ);
    this.type = 2;
    GMTrace.o(2145067728896L, 15982);
    return this;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/eb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */