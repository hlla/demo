package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;

final class j
  extends ag.a
{
  protected TextView vwR;
  
  public j(int paramInt)
  {
    super(paramInt);
    GMTrace.i(2178756378624L, 16233);
    GMTrace.o(2178756378624L, 16233);
  }
  
  public final j dh(View paramView)
  {
    GMTrace.i(2178890596352L, 16234);
    super.dl(paramView);
    this.vwR = ((TextView)paramView.findViewById(R.h.ccf));
    this.phd = ((TextView)paramView.findViewById(R.h.bBz));
    this.mdQ = ((CheckBox)paramView.findViewById(R.h.bzW));
    this.nQv = paramView.findViewById(R.h.bAQ);
    GMTrace.o(2178890596352L, 16234);
    return this;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */