package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.d;

public final class e
  implements b.f
{
  public static final e hqo;
  
  static
  {
    GMTrace.i(12915906183168L, 96231);
    hqo = new e();
    GMTrace.o(12915906183168L, 96231);
  }
  
  public e()
  {
    GMTrace.i(12915503529984L, 96228);
    GMTrace.o(12915503529984L, 96228);
  }
  
  public final String Bc()
  {
    GMTrace.i(12915771965440L, 96230);
    GMTrace.o(12915771965440L, 96230);
    return "WxaIcon";
  }
  
  public final Bitmap i(Bitmap paramBitmap)
  {
    GMTrace.i(12915637747712L, 96229);
    if ((paramBitmap.getWidth() <= 0) || (paramBitmap.getHeight() <= 0))
    {
      GMTrace.o(12915637747712L, 96229);
      return paramBitmap;
    }
    paramBitmap = d.a(paramBitmap, false, paramBitmap.getWidth() / 2, false);
    GMTrace.o(12915637747712L, 96229);
    return paramBitmap;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelappbrand/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */