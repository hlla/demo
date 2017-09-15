package com.tencent.mm.ui.tools;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bg.a;
import com.tencent.mm.s.a.f;

public final class s
{
  public static int fg(Context paramContext)
  {
    GMTrace.i(1951794200576L, 14542);
    if (Float.compare(a.dI(paramContext), 1.125F) > 0)
    {
      i = a.f.hbM;
      GMTrace.o(1951794200576L, 14542);
      return i;
    }
    int i = a.f.bkS;
    GMTrace.o(1951794200576L, 14542);
    return i;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/tools/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */