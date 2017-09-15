package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.ah.a.a.c;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.bg.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

final class ep
  extends ag.a
{
  public static final int vML;
  public static final int vMM;
  static c vMN;
  protected ThreeDotsLoadingView jlq;
  protected ImageView vMO;
  protected ViewGroup vMP;
  protected View vMQ;
  ImageView vwJ;
  protected TextView vwP;
  protected TextView vxB;
  protected ImageView vxa;
  protected ImageView vxc;
  protected ImageView vxd;
  protected ChattingItemFooter vxf;
  protected ImageView vxg;
  protected LinearLayout vxh;
  protected ViewGroup vxi;
  protected TextView vxj;
  protected LinearLayout vxk;
  protected TextView vxu;
  protected ImageView vxv;
  protected TextView vxw;
  protected TextView vxx;
  protected LinearLayout vxy;
  
  static
  {
    GMTrace.i(17608694824960L, 131195);
    vML = a.fromDPToPix(aa.getContext(), 215);
    vMM = a.fromDPToPix(aa.getContext(), 168);
    c.a locala = new c.a();
    locala.hII = R.k.dtp;
    locala.aO(a.fromDPToPix(aa.getContext(), 20), a.fromDPToPix(aa.getContext(), 20)).hIr = true;
    vMN = locala.Hh();
    GMTrace.o(17608694824960L, 131195);
  }
  
  public ep(int paramInt)
  {
    super(paramInt);
    GMTrace.i(17608426389504L, 131193);
    GMTrace.o(17608426389504L, 131193);
  }
  
  public final ep r(View paramView, boolean paramBoolean)
  {
    GMTrace.i(17608560607232L, 131194);
    super.dl(paramView);
    this.vxa = ((ImageView)paramView.findViewById(R.h.bzE));
    this.vxc = ((ImageView)this.mgy.findViewById(R.h.bAg));
    this.vxd = ((ImageView)this.mgy.findViewById(R.h.bBs));
    this.vwP = ((TextView)paramView.findViewById(R.h.bzr));
    this.vxg = ((ImageView)paramView.findViewById(R.h.bzy));
    this.mdQ = ((CheckBox)paramView.findViewById(R.h.bzW));
    this.nQv = paramView.findViewById(R.h.bAQ);
    this.phd = ((TextView)paramView.findViewById(R.h.bBz));
    this.vxf = ((ChattingItemFooter)paramView.findViewById(R.h.aTR));
    this.vxh = ((LinearLayout)paramView.findViewById(R.h.bpB));
    this.vxi = ((ViewGroup)paramView.findViewById(R.h.cch));
    this.vxj = ((TextView)paramView.findViewById(R.h.ccf));
    this.vxk = ((LinearLayout)paramView.findViewById(R.h.bzK));
    this.vAj = paramView.findViewById(R.h.bzX);
    if (!paramBoolean)
    {
      this.vwJ = ((ImageView)this.mgy.findViewById(R.h.bBr));
      this.oCh = ((ProgressBar)this.mgy.findViewById(R.h.cKO));
    }
    this.vxy = ((LinearLayout)paramView.findViewById(R.h.bzk));
    this.jlq = ((ThreeDotsLoadingView)paramView.findViewById(R.h.cbN));
    this.vMO = ((ImageView)paramView.findViewById(R.h.bGV));
    this.vxB = ((TextView)paramView.findViewById(R.h.bzn));
    this.vxu = ((TextView)paramView.findViewById(R.h.bzm));
    this.vxv = ((ImageView)paramView.findViewById(R.h.bzo));
    this.vxw = ((TextView)paramView.findViewById(R.h.bzq));
    this.vxx = ((TextView)paramView.findViewById(R.h.bzp));
    this.vMP = ((ViewGroup)paramView.findViewById(R.h.bGY));
    GMTrace.o(17608560607232L, 131194);
    return this;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */