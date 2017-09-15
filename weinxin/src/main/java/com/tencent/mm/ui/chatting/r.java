package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import java.util.ArrayList;
import java.util.List;

final class r
  extends ag.a
{
  List<q> oJc;
  TextView vwP;
  ChattingItemFooter vxf;
  LinearLayout vyb;
  t vyc;
  
  public r(int paramInt)
  {
    super(paramInt);
    GMTrace.i(2164126646272L, 16124);
    this.vyc = new t();
    this.oJc = new ArrayList();
    GMTrace.o(2164126646272L, 16124);
  }
  
  public final ag.a dk(View paramView)
  {
    GMTrace.i(2164260864000L, 16125);
    ViewGroup localViewGroup = (ViewGroup)this.vyc.oIQ.getParent();
    q localq = new q();
    localq.oIQ = paramView;
    localq.iUi = ((TextView)paramView.findViewById(R.h.title));
    localq.vya = ((TextView)paramView.findViewById(R.h.summary));
    localq.oIR = paramView.findViewById(R.h.bGS);
    localq.oIS = ((ImageView)paramView.findViewById(R.h.bGR));
    localq.lIG = ((ProgressBar)paramView.findViewById(R.h.cbL));
    localq.oIU = paramView.findViewById(R.h.cbC);
    localViewGroup.addView(paramView, localViewGroup.getChildCount() - 1);
    this.oJc.add(localq);
    GMTrace.o(2164260864000L, 16125);
    return this;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */