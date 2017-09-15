package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public class ChattingTranslateView
  extends LinearLayout
{
  private String fWe;
  private ImageView sqs;
  private TextView vFH;
  private boolean vFJ;
  private boolean vFP;
  a vFQ;
  
  public ChattingTranslateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(2497657700352L, 18609);
    this.vFP = false;
    this.vFQ = null;
    this.vFJ = false;
    init();
    GMTrace.o(2497657700352L, 18609);
  }
  
  public ChattingTranslateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet);
    GMTrace.i(2497791918080L, 18610);
    init();
    GMTrace.o(2497791918080L, 18610);
  }
  
  private void a(a parama)
  {
    GMTrace.i(2498597224448L, 18616);
    if (this.vFJ)
    {
      super.setVisibility(8);
      GMTrace.o(2498597224448L, 18616);
      return;
    }
    if ((this.vFQ == parama) && (!this.vFP))
    {
      GMTrace.o(2498597224448L, 18616);
      return;
    }
    this.vFP = false;
    v.d("MicroMsg.ChattingTranslateView", "from status %s to status %s", new Object[] { this.vFQ, parama });
    this.vFQ = parama;
    switch (1.vFR[parama.ordinal()])
    {
    }
    for (;;)
    {
      invalidate();
      GMTrace.o(2498597224448L, 18616);
      return;
      super.setVisibility(8);
      continue;
      super.setVisibility(0);
      this.sqs.setImageResource(R.k.dzU);
      this.vFH.setText(R.l.dVE);
      continue;
      super.setVisibility(0);
      this.sqs.setImageResource(R.k.dzT);
      if (bf.mA(this.fWe)) {
        this.vFH.setText(R.l.dVD);
      } else {
        this.vFH.setText(this.fWe);
      }
    }
  }
  
  private void init()
  {
    GMTrace.i(2498060353536L, 18612);
    int i = (int)TypedValue.applyDimension(1, 3.0F, getResources().getDisplayMetrics());
    this.sqs = new ImageView(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 16;
    localLayoutParams.setMargins(i, i, 0, i);
    this.sqs.setLayoutParams(localLayoutParams);
    addView(this.sqs);
    this.vFH = new TextView(getContext());
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(i, i, i, i);
    localLayoutParams.gravity = 16;
    this.vFH.setLayoutParams(localLayoutParams);
    this.vFH.setTextSize(1, 11.0F);
    this.vFH.setTextColor(-1);
    addView(this.vFH);
    setBackgroundResource(R.g.bdP);
    a(a.vFS);
    GMTrace.o(2498060353536L, 18612);
  }
  
  public final void Tw(String paramString)
  {
    GMTrace.i(2498463006720L, 18615);
    if (!bf.mz(this.fWe).equals(bf.mz(paramString))) {
      this.vFP = true;
    }
    this.fWe = paramString;
    a(a.vFU);
    GMTrace.o(2498463006720L, 18615);
  }
  
  public final void bUE()
  {
    GMTrace.i(2498194571264L, 18613);
    a(a.vFS);
    GMTrace.o(2498194571264L, 18613);
  }
  
  public final void bUF()
  {
    GMTrace.i(2498328788992L, 18614);
    a(a.vFT);
    GMTrace.o(2498328788992L, 18614);
  }
  
  public final void lg(boolean paramBoolean)
  {
    GMTrace.i(2497926135808L, 18611);
    this.vFJ = paramBoolean;
    if (paramBoolean) {
      super.setVisibility(8);
    }
    GMTrace.o(2497926135808L, 18611);
  }
  
  public static enum a
  {
    static
    {
      GMTrace.i(2141578067968L, 15956);
      vFS = new a("NoTranslate", 0);
      vFT = new a("Translating", 1);
      vFU = new a("Translated", 2);
      vFV = new a[] { vFS, vFT, vFU };
      GMTrace.o(2141578067968L, 15956);
    }
    
    private a()
    {
      GMTrace.i(2141443850240L, 15955);
      GMTrace.o(2141443850240L, 15955);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ChattingTranslateView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */