package com.tencent.mm.ui.base;

import android.app.Dialog;
import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;

public class i
  extends Dialog
{
  public i(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    GMTrace.i(3273570385920L, 24390);
    GMTrace.o(3273570385920L, 24390);
  }
  
  public void dismiss()
  {
    GMTrace.i(3273704603648L, 24391);
    try
    {
      super.dismiss();
      GMTrace.o(3273704603648L, 24391);
      return;
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.MMDialog", localException, "", new Object[0]);
      GMTrace.o(3273704603648L, 24391);
    }
  }
  
  public void show()
  {
    GMTrace.i(3273838821376L, 24392);
    try
    {
      super.show();
      GMTrace.o(3273838821376L, 24392);
      return;
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.MMDialog", localException, "", new Object[0]);
      GMTrace.o(3273838821376L, 24392);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */