package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;

final class dn
  extends ag.a
{
  ProgressBar oCh;
  ViewStub vGl;
  RTChattingEmojiView vwH;
  ImageView vwI;
  ImageView vwJ;
  
  public dn(int paramInt)
  {
    super(paramInt);
    GMTrace.i(2257676402688L, 16821);
    GMTrace.o(2257676402688L, 16821);
  }
  
  public final ag.a p(View paramView, boolean paramBoolean)
  {
    GMTrace.i(2257810620416L, 16822);
    super.dl(paramView);
    this.kvw = ((TextView)paramView.findViewById(R.h.bBt));
    this.vwH = ((RTChattingEmojiView)paramView.findViewById(R.h.bAc));
    this.mdQ = ((CheckBox)paramView.findViewById(R.h.bzW));
    this.nQv = paramView.findViewById(R.h.bAQ);
    if (paramBoolean)
    {
      this.phd = ((TextView)paramView.findViewById(R.h.bBz));
      this.type = 14;
    }
    for (;;)
    {
      if (this.vwI != null) {
        ((ViewGroup)this.vwI.getParent()).setBackgroundDrawable(null);
      }
      this.vGl = ((ViewStub)paramView.findViewById(R.h.bBf));
      GMTrace.o(2257810620416L, 16822);
      return this;
      this.oCh = ((ProgressBar)paramView.findViewById(R.h.cKO));
      this.phd = ((TextView)paramView.findViewById(R.h.bBz));
      this.vwV = ((ImageView)paramView.findViewById(R.h.bBp));
      this.type = 15;
      this.vwJ = ((ImageView)paramView.findViewById(R.h.bBr));
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/dn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */