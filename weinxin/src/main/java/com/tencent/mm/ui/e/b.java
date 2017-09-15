package com.tencent.mm.ui.e;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.i;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.b.b.b;

public final class b
  extends a
{
  public b(Context paramContext, b.b paramb)
  {
    super(paramContext, paramb);
    GMTrace.i(17829482987520L, 132840);
    GMTrace.o(17829482987520L, 132840);
  }
  
  protected final void Is(String paramString)
  {
    GMTrace.i(17829751422976L, 132842);
    v.w("MicroMsg.ChattingMonitoredUnClickableBanner", "hy: un clickable. should not navigate here");
    GMTrace.o(17829751422976L, 132842);
  }
  
  public final int getLayoutId()
  {
    GMTrace.i(17829617205248L, 132841);
    int i = R.i.cYB;
    GMTrace.o(17829617205248L, 132841);
    return i;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */