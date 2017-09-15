package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;

final class f
  extends ag.a
{
  public TextView vwz;
  
  public f(int paramInt)
  {
    super(paramInt);
    GMTrace.i(2236470001664L, 16663);
    GMTrace.o(2236470001664L, 16663);
  }
  
  public final f df(View paramView)
  {
    GMTrace.i(2236604219392L, 16664);
    super.dl(paramView);
    this.kvw = ((TextView)this.mgy.findViewById(R.h.bBt));
    this.mdQ = ((CheckBox)this.mgy.findViewById(R.h.bzW));
    this.nQv = this.mgy.findViewById(R.h.bAQ);
    this.phd = ((TextView)this.mgy.findViewById(R.h.bBz));
    this.vwz = ((TextView)this.mgy.findViewById(R.h.bpS));
    GMTrace.o(2236604219392L, 16664);
    return this;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */