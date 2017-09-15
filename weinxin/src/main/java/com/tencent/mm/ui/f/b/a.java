package com.tencent.mm.ui.f.b;

import android.graphics.drawable.Drawable;
import com.tencent.gmtrace.GMTrace;

public final class a
{
  private static c wdP;
  
  static
  {
    GMTrace.i(14614297313280L, 108885);
    wdP = null;
    GMTrace.o(14614297313280L, 108885);
  }
  
  public static void a(c paramc)
  {
    GMTrace.i(14614028877824L, 108883);
    wdP = paramc;
    GMTrace.o(14614028877824L, 108883);
  }
  
  public static Drawable eW(String paramString1, String paramString2)
  {
    GMTrace.i(14614163095552L, 108884);
    if (wdP != null)
    {
      paramString1 = wdP.bK(paramString1, paramString2);
      if ((paramString1 instanceof Drawable))
      {
        paramString1 = (Drawable)paramString1;
        GMTrace.o(14614163095552L, 108884);
        return paramString1;
      }
      GMTrace.o(14614163095552L, 108884);
      return null;
    }
    GMTrace.o(14614163095552L, 108884);
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/f/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */