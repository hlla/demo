package com.tencent.mm.ui.f.a;

import android.widget.ImageView;
import com.tencent.gmtrace.GMTrace;

public final class a
{
  private static b wdO;
  
  static
  {
    GMTrace.i(14614699966464L, 108888);
    wdO = null;
    GMTrace.o(14614699966464L, 108888);
  }
  
  public static void a(ImageView paramImageView, String paramString)
  {
    GMTrace.i(14614565748736L, 108887);
    if (wdO != null) {
      wdO.a(paramImageView, paramString);
    }
    GMTrace.o(14614565748736L, 108887);
  }
  
  public static void a(b paramb)
  {
    GMTrace.i(14614431531008L, 108886);
    wdO = paramb;
    GMTrace.o(14614431531008L, 108886);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/f/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */