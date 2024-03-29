package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.s.a.l;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.r;

public final class p
  extends q
{
  private View Ih;
  public ProgressBar joQ;
  private Context mContext;
  private int style;
  private TextView vgf;
  
  private p(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext, paramInt1);
    GMTrace.i(3359603949568L, 25031);
    this.mContext = paramContext;
    this.style = paramInt2;
    switch (this.style)
    {
    default: 
      paramInt1 = a.h.het;
    }
    for (;;)
    {
      this.Ih = r.eC(this.mContext).inflate(paramInt1, null);
      this.vgf = ((TextView)this.Ih.findViewById(a.g.cke));
      this.joQ = ((ProgressBar)this.Ih.findViewById(a.g.ckd));
      setCanceledOnTouchOutside(true);
      GMTrace.o(3359603949568L, 25031);
      return;
      paramInt1 = a.h.het;
      continue;
      paramInt1 = a.h.heu;
      continue;
      paramInt1 = a.h.het;
    }
  }
  
  public static p a(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, int paramInt, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    GMTrace.i(3360140820480L, 25035);
    int i;
    switch (paramInt)
    {
    default: 
      i = a.l.hfn;
    }
    for (;;)
    {
      paramContext = new p(paramContext, i, paramInt);
      paramContext.setMessage(paramCharSequence);
      paramContext.setCancelable(paramBoolean);
      paramContext.setOnCancelListener(paramOnCancelListener);
      paramContext.setCanceledOnTouchOutside(false);
      GMTrace.o(3360140820480L, 25035);
      return paramContext;
      i = a.l.foC;
      continue;
      i = a.l.foC;
      continue;
      i = a.l.foC;
    }
  }
  
  public static p b(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, int paramInt, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    GMTrace.i(3360275038208L, 25036);
    paramContext = a(paramContext, paramCharSequence, paramBoolean, paramInt, paramOnCancelListener);
    paramContext.show();
    GMTrace.o(3360275038208L, 25036);
    return paramContext;
  }
  
  public final void dismiss()
  {
    GMTrace.i(3360543473664L, 25038);
    try
    {
      super.dismiss();
      GMTrace.o(3360543473664L, 25038);
      return;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.MMProgressDialog", "dismiss exception, e = " + localException.getMessage());
      GMTrace.o(3360543473664L, 25038);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    GMTrace.i(3359738167296L, 25032);
    super.onCreate(paramBundle);
    setContentView(this.Ih, new LinearLayout.LayoutParams(-1, -1));
    paramBundle = getWindow().getAttributes();
    paramBundle.width = -1;
    paramBundle.height = -2;
    if (this.style == 2)
    {
      getWindow().addFlags(2);
      paramBundle.dimAmount = 0.65F;
    }
    onWindowAttributesChanged(paramBundle);
    GMTrace.o(3359738167296L, 25032);
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    GMTrace.i(3359872385024L, 25033);
    super.setCancelable(paramBoolean);
    setCanceledOnTouchOutside(paramBoolean);
    GMTrace.o(3359872385024L, 25033);
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    GMTrace.i(3360006602752L, 25034);
    this.vgf.setText(paramCharSequence);
    GMTrace.o(3360006602752L, 25034);
  }
  
  public final void show()
  {
    GMTrace.i(3360409255936L, 25037);
    try
    {
      super.show();
      GMTrace.o(3360409255936L, 25037);
      return;
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.MMProgressDialog", localException, "", new Object[0]);
      GMTrace.o(3360409255936L, 25037);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */