package com.tencent.mm.compatible.util;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.d.j;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.sdk.platformtools.bf;

public final class n
{
  public static String dz(String paramString)
  {
    GMTrace.i(13779731480576L, 102667);
    if (paramString == null)
    {
      GMTrace.o(13779731480576L, 102667);
      return paramString;
    }
    if (p.gRb.gPP == 2)
    {
      GMTrace.o(13779731480576L, 102667);
      return paramString;
    }
    if (p.gRb.gQa == 1)
    {
      GMTrace.o(13779731480576L, 102667);
      return paramString;
    }
    if (p.gRb.gPP == 1)
    {
      if (paramString.toString().contains("\n"))
      {
        paramString = paramString.toString().replace("\n", " ");
        GMTrace.o(13779731480576L, 102667);
        return paramString;
      }
      GMTrace.o(13779731480576L, 102667);
      return paramString;
    }
    if (Build.VERSION.SDK_INT == 16)
    {
      if (paramString.toString().contains("\n"))
      {
        if (bf.ap(Build.MANUFACTURER, "").toLowerCase().indexOf("meizu".toLowerCase()) >= 0)
        {
          GMTrace.o(13779731480576L, 102667);
          return paramString;
        }
        paramString = paramString.toString().replace("\n", " ");
        GMTrace.o(13779731480576L, 102667);
        return paramString;
      }
      GMTrace.o(13779731480576L, 102667);
      return paramString;
    }
    GMTrace.o(13779731480576L, 102667);
    return paramString;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/compatible/util/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */