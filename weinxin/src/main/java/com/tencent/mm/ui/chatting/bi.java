package com.tencent.mm.ui.chatting;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.m;
import com.tencent.mm.bg.a;
import com.tencent.mm.sdk.platformtools.v;

public final class bi
  extends RelativeLayout
{
  private LayoutInflater mwN;
  private int vBl;
  
  public bi(LayoutInflater paramLayoutInflater, int paramInt)
  {
    super(paramLayoutInflater.getContext());
    GMTrace.i(2136343576576L, 15917);
    this.mwN = paramLayoutInflater;
    this.vBl = paramInt;
    paramLayoutInflater = this.mwN.inflate(R.i.cXn, null);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    paramLayoutInflater.setId(R.h.bAA);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(R.f.aXG), 0, getResources().getDimensionPixelSize(R.f.aXG));
    paramLayoutInflater.setVisibility(8);
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = new TextView(getContext(), null, R.m.fok);
    paramLayoutInflater.setId(R.h.bBt);
    paramLayoutInflater.setTextSize(0, a.T(getContext(), R.f.aXV));
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(3, R.h.bAA);
    localLayoutParams.addRule(14);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(R.f.aXG), 0, getResources().getDimensionPixelSize(R.f.aXG));
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = (CheckBox)LayoutInflater.from(getContext()).inflate(R.i.dim, this, false);
    paramLayoutInflater.setId(R.h.bzW);
    paramInt = a.fromDPToPix(getContext(), 32);
    localLayoutParams = new RelativeLayout.LayoutParams(paramInt, paramInt);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(R.f.aWz), getResources().getDimensionPixelSize(R.f.aXQ), 0);
    localLayoutParams.addRule(3, R.h.bBt);
    localLayoutParams.addRule(11);
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = this.mwN.inflate(this.vBl, null);
    int i = paramLayoutInflater.getId();
    paramInt = i;
    if (-1 == i)
    {
      v.v("MicroMsg.ChattingItemContainer", "content view has no id, use defaul id");
      paramInt = R.h.bzZ;
      paramLayoutInflater.setId(R.h.bzZ);
    }
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(3, R.h.bBt);
    localLayoutParams.addRule(0, R.h.bzW);
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = new View(getContext());
    paramLayoutInflater.setId(R.h.bAQ);
    paramLayoutInflater.setVisibility(8);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(6, paramInt);
    localLayoutParams.addRule(8, paramInt);
    addView(paramLayoutInflater, localLayoutParams);
    GMTrace.o(2136343576576L, 15917);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */