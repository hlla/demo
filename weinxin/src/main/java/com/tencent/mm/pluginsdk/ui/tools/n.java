package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.d.j;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.d.x;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class n
{
  public static f dG(Context paramContext)
  {
    GMTrace.i(1067567808512L, 7954);
    if (bf.ap(p.gRb.gQt, "").equals("surface"))
    {
      v.i("MicroMsg.VideoViewFactory", "match full type surface");
      paramContext = new VideoSurfaceView(paramContext);
      GMTrace.o(1067567808512L, 7954);
      return paramContext;
    }
    String str = x.get("ro.mediatek.platform");
    if ((str != null) && ((str.startsWith("MT")) || (str.startsWith("mt")))) {}
    for (int i = 1; i != 0; i = 0)
    {
      v.i("MicroMsg.VideoViewFactory", "IS MTK platform");
      paramContext = new VideoSightView(paramContext);
      GMTrace.o(1067567808512L, 7954);
      return paramContext;
    }
    v.i("MicroMsg.VideoViewFactory", "default settings, use sightview");
    paramContext = new VideoSightView(paramContext);
    GMTrace.o(1067567808512L, 7954);
    return paramContext;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/tools/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */