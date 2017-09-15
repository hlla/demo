package com.tencent.mm.ui.widget.celltextview.g;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.gmtrace.GMTrace;

public final class b
{
  public static float f(Context paramContext, float paramFloat)
  {
    GMTrace.i(18756927488000L, 139750);
    if ((paramContext == null) || (paramFloat < 0.0F))
    {
      GMTrace.o(18756927488000L, 139750);
      return 0.0F;
    }
    float f = paramContext.getResources().getDisplayMetrics().density;
    GMTrace.o(18756927488000L, 139750);
    return f * paramFloat;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/widget/celltextview/g/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */