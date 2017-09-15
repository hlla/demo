package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.sdk.platformtools.aa;

final class k
  extends ag.a
{
  public ImageView vwS;
  public TextView vwT;
  public TextView vwU;
  public int vwx;
  
  public k(int paramInt)
  {
    super(paramInt);
    GMTrace.i(2269487562752L, 16909);
    this.vwx = 0;
    GMTrace.o(2269487562752L, 16909);
  }
  
  public final k di(View paramView)
  {
    GMTrace.i(2269621780480L, 16910);
    super.dl(paramView);
    this.kvw = ((TextView)this.mgy.findViewById(R.h.bBt));
    this.mdQ = ((CheckBox)this.mgy.findViewById(R.h.bzW));
    this.nQv = this.mgy.findViewById(R.h.bAQ);
    this.phd = ((TextView)this.mgy.findViewById(R.h.bBz));
    this.vwS = ((ImageView)this.mgy.findViewById(R.h.bqb));
    this.vwT = ((TextView)this.mgy.findViewById(R.h.bqc));
    this.vwU = ((TextView)this.mgy.findViewById(R.h.bqa));
    this.vwx = ag.eU(aa.getContext());
    GMTrace.o(2269621780480L, 16910);
    return this;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */