package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.bg.a;
import com.tencent.mm.sdk.platformtools.aa;

final class e
  extends ag.a
{
  public int maxSize;
  public ImageView vwt;
  public TextView vwu;
  public TextView vwv;
  public TextView vww;
  public int vwx;
  public int vwy;
  
  public e(int paramInt)
  {
    super(paramInt);
    GMTrace.i(2505576546304L, 18668);
    this.vwx = 0;
    this.vwy = 0;
    this.maxSize = 0;
    GMTrace.o(2505576546304L, 18668);
  }
  
  public final e de(View paramView)
  {
    GMTrace.i(2505710764032L, 18669);
    super.dl(paramView);
    this.kvw = ((TextView)this.mgy.findViewById(R.h.bBt));
    this.mdQ = ((CheckBox)this.mgy.findViewById(R.h.bzW));
    this.nQv = this.mgy.findViewById(R.h.bAQ);
    this.phd = ((TextView)this.mgy.findViewById(R.h.bBz));
    this.vwt = ((ImageView)this.mgy.findViewById(R.h.bpR));
    this.vwu = ((TextView)this.mgy.findViewById(R.h.bpT));
    this.vwv = ((TextView)this.mgy.findViewById(R.h.bpQ));
    this.vww = ((TextView)this.mgy.findViewById(R.h.bpU));
    this.vAj = ((LinearLayout)this.mgy.findViewById(R.h.bzX));
    this.vwx = ag.eU(aa.getContext());
    this.vwy = a.T(aa.getContext(), R.f.aWI);
    this.maxSize = ((int)(a.U(aa.getContext(), R.f.aWI) * 1.45F));
    GMTrace.o(2505710764032L, 18669);
    return this;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */