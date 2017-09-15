package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

final class h
  extends ag.a
{
  public static Map<String, WeakReference<h>> vwN;
  ProgressBar oCh;
  RTChattingEmojiView vwH;
  ImageView vwI;
  ImageView vwJ;
  ProgressBar vwK;
  ImageView vwL;
  TextView vwM;
  
  static
  {
    GMTrace.i(2491886338048L, 18566);
    vwN = new HashMap();
    GMTrace.o(2491886338048L, 18566);
  }
  
  public h(int paramInt)
  {
    super(paramInt);
    GMTrace.i(2491483684864L, 18563);
    GMTrace.o(2491483684864L, 18563);
  }
  
  public static void i(String paramString, int paramInt1, int paramInt2)
  {
    GMTrace.i(2491752120320L, 18565);
    if (!vwN.containsKey(paramString))
    {
      v.i("AppMsgEmojiItemHolder", "no contain attchid:%s");
      GMTrace.o(2491752120320L, 18565);
      return;
    }
    paramString = (h)((WeakReference)vwN.get(paramString)).get();
    if (paramString != null) {
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      GMTrace.o(2491752120320L, 18565);
      return;
      paramString.vwK.setVisibility(8);
      paramString.vwM.setVisibility(8);
      paramString.vwL.setVisibility(8);
      GMTrace.o(2491752120320L, 18565);
      return;
      paramString.vwK.setVisibility(8);
      paramString.vwM.setVisibility(8);
      paramString.vwL.setVisibility(0);
      paramString.vwK.setProgress(paramInt1);
      paramString.vwL.setImageResource(R.g.beK);
      GMTrace.o(2491752120320L, 18565);
      return;
      paramString.vwK.setVisibility(0);
      paramString.vwM.setVisibility(8);
      paramString.vwL.setVisibility(8);
      paramString.vwK.setProgress(0);
    }
  }
  
  public final ag.a p(View paramView, boolean paramBoolean)
  {
    GMTrace.i(2491617902592L, 18564);
    super.dl(paramView);
    this.kvw = ((TextView)paramView.findViewById(R.h.bBt));
    this.vwH = ((RTChattingEmojiView)paramView.findViewById(R.h.bAc));
    this.mdQ = ((CheckBox)paramView.findViewById(R.h.bzW));
    this.nQv = paramView.findViewById(R.h.bAQ);
    this.vwK = ((ProgressBar)paramView.findViewById(R.h.bAk));
    this.vwL = ((ImageView)paramView.findViewById(R.h.bBq));
    this.vwM = ((TextView)paramView.findViewById(R.h.bBn));
    if (paramBoolean) {
      this.type = 14;
    }
    for (;;)
    {
      if (this.vwI != null) {
        ((ViewGroup)this.vwI.getParent()).setBackgroundDrawable(null);
      }
      this.phd = ((TextView)paramView.findViewById(R.h.bBz));
      GMTrace.o(2491617902592L, 18564);
      return this;
      this.oCh = ((ProgressBar)paramView.findViewById(R.h.cKO));
      this.vwV = ((ImageView)paramView.findViewById(R.h.bBp));
      this.type = 15;
      this.vwJ = ((ImageView)paramView.findViewById(R.h.bBr));
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */