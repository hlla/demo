package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.bg.a;
import com.tencent.mm.sdk.platformtools.v;
import java.util.List;

public class ChattingFooterMoreBtnBar
  extends LinearLayout
{
  private ImageButton lHU;
  private LinearLayout.LayoutParams mAi;
  private ImageButton vAa;
  private ImageButton vAb;
  private ImageButton vAc;
  private ImageButton vAd;
  
  public ChattingFooterMoreBtnBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(2275527360512L, 16954);
    setOrientation(0);
    setGravity(16);
    setBackgroundResource(R.g.bcW);
    this.mAi = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.aXP), 1.0F);
    this.mAi.topMargin = a.fromDPToPix(getContext(), 0);
    this.vAa = new ImageButton(getContext());
    this.vAa.setImageResource(R.g.bdO);
    this.vAa.setScaleType(ImageView.ScaleType.CENTER);
    this.vAa.setBackgroundResource(0);
    this.vAa.setContentDescription(paramContext.getString(R.l.dUC));
    this.vAd = new ImageButton(getContext());
    this.vAd.setImageResource(R.g.bdM);
    this.vAd.setScaleType(ImageView.ScaleType.CENTER);
    this.vAd.setBackgroundResource(0);
    this.vAd.setContentDescription(paramContext.getString(R.l.dUB));
    this.lHU = new ImageButton(getContext());
    this.lHU.setImageResource(R.g.bdK);
    this.lHU.setScaleType(ImageView.ScaleType.CENTER);
    this.lHU.setBackgroundResource(0);
    this.lHU.setContentDescription(paramContext.getString(R.l.dUz));
    this.vAc = new ImageButton(getContext());
    this.vAc.setImageResource(R.g.bdN);
    this.vAc.setScaleType(ImageView.ScaleType.CENTER);
    this.vAc.setBackgroundResource(0);
    this.vAc.setContentDescription(paramContext.getString(R.l.dUy));
    this.vAb = new ImageButton(getContext());
    this.vAb.setImageResource(R.g.bdL);
    this.vAb.setScaleType(ImageView.ScaleType.CENTER);
    this.vAb.setBackgroundResource(0);
    this.vAb.setContentDescription(paramContext.getString(R.l.dUA));
    bUc();
    GMTrace.o(2275527360512L, 16954);
  }
  
  public final void AK(int paramInt)
  {
    GMTrace.i(2275795795968L, 16956);
    boolean bool;
    if (paramInt > 0)
    {
      bool = true;
      this.vAa.setClickable(bool);
      this.vAa.setEnabled(bool);
      if (aa.bTP().size() <= 0) {
        break label105;
      }
      this.vAc.setClickable(bool);
      this.vAc.setEnabled(bool);
    }
    for (;;)
    {
      this.lHU.setClickable(bool);
      this.lHU.setEnabled(bool);
      this.vAd.setClickable(bool);
      this.vAd.setEnabled(bool);
      GMTrace.o(2275795795968L, 16956);
      return;
      bool = false;
      break;
      label105:
      this.vAb.setClickable(bool);
      this.vAb.setEnabled(bool);
    }
  }
  
  public final void bUc()
  {
    GMTrace.i(2275661578240L, 16955);
    removeAllViews();
    addView(this.vAa, this.mAi);
    addView(this.vAd, this.mAi);
    addView(this.lHU, this.mAi);
    if (aa.bTP().size() > 0)
    {
      addView(this.vAc, this.mAi);
      GMTrace.o(2275661578240L, 16955);
      return;
    }
    addView(this.vAb, this.mAi);
    GMTrace.o(2275661578240L, 16955);
  }
  
  public final void c(int paramInt, View.OnClickListener paramOnClickListener)
  {
    GMTrace.i(2275930013696L, 16957);
    switch (paramInt)
    {
    default: 
      v.w("Ashu.ChattingFooterMoreBtnBar", "set button listener error button index %d", new Object[] { Integer.valueOf(paramInt) });
      GMTrace.o(2275930013696L, 16957);
      return;
    case 2: 
      this.vAc.setOnClickListener(paramOnClickListener);
      GMTrace.o(2275930013696L, 16957);
      return;
    case 3: 
      this.lHU.setOnClickListener(paramOnClickListener);
      GMTrace.o(2275930013696L, 16957);
      return;
    case 1: 
      this.vAb.setOnClickListener(paramOnClickListener);
      GMTrace.o(2275930013696L, 16957);
      return;
    case 0: 
      this.vAa.setOnClickListener(paramOnClickListener);
      GMTrace.o(2275930013696L, 16957);
      return;
    }
    this.vAd.setOnClickListener(paramOnClickListener);
    GMTrace.o(2275930013696L, 16957);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ChattingFooterMoreBtnBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */