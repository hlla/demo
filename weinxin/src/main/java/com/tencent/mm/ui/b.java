package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bg.a;
import com.tencent.mm.s.a.e;
import com.tencent.mm.s.a.g;

public final class b
{
  public TextView ipc;
  private View sgn;
  private ImageView uMl;
  public TextView uMm;
  private ImageView uMn;
  public ImageView uMo;
  private ImageView uMp;
  public ImageView uMq;
  private View uMr;
  
  public b(View paramView)
  {
    GMTrace.i(1908710309888L, 14221);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (localLayoutParams == null) {
      localLayoutParams = new ViewGroup.LayoutParams(-2, -1);
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      this.ipc = ((TextView)paramView.findViewById(a.g.hdg));
      this.uMm = ((TextView)paramView.findViewById(a.g.hcW));
      this.uMn = ((ImageView)paramView.findViewById(a.g.hcB));
      this.uMo = ((ImageView)paramView.findViewById(a.g.hcD));
      this.uMp = ((ImageView)paramView.findViewById(a.g.hcJ));
      this.sgn = paramView.findViewById(a.g.hbS);
      this.uMl = ((ImageView)paramView.findViewById(a.g.hbT));
      this.uMq = ((ImageView)paramView.findViewById(a.g.hcL));
      this.uMr = paramView;
      GMTrace.o(1908710309888L, 14221);
      return;
      localLayoutParams.width = -2;
      localLayoutParams.height = -1;
    }
  }
  
  public final void h(View.OnClickListener paramOnClickListener)
  {
    GMTrace.i(1909247180800L, 14225);
    this.sgn.setOnClickListener(paramOnClickListener);
    GMTrace.o(1909247180800L, 14225);
  }
  
  public final void jZ(boolean paramBoolean)
  {
    GMTrace.i(1908978745344L, 14223);
    ImageView localImageView = this.uMn;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      GMTrace.o(1908978745344L, 14223);
      return;
    }
  }
  
  public final void ka(boolean paramBoolean)
  {
    GMTrace.i(1909112963072L, 14224);
    ImageView localImageView = this.uMp;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      GMTrace.o(1909112963072L, 14224);
      return;
    }
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    GMTrace.i(1908844527616L, 14222);
    this.ipc.setText(paramCharSequence);
    if (a.dM(this.ipc.getContext())) {
      this.ipc.setTextSize(0, a.U(this.ipc.getContext(), a.e.aWx) * a.dK(this.ipc.getContext()));
    }
    GMTrace.o(1908844527616L, 14222);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */