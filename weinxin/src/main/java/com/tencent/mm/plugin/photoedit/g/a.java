package com.tencent.mm.plugin.photoedit.g;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.aa;

public final class a
{
  public static String Cv(String paramString)
  {
    GMTrace.i(9916005744640L, 73880);
    paramString = e.gSo + String.format("%s%d.%s", new Object[] { "wx_photo_edit_", Long.valueOf(System.currentTimeMillis()), paramString });
    GMTrace.o(9916005744640L, 73880);
    return paramString;
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    GMTrace.i(9916274180096L, 73882);
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    int i = 1;
    int j;
    for (;;)
    {
      j = i;
      if (m / i <= paramInt1) {
        break;
      }
      i += 1;
    }
    while (k / j > paramInt2) {
      j += 1;
    }
    GMTrace.o(9916274180096L, 73882);
    return j;
  }
  
  public static int ad(float paramFloat)
  {
    GMTrace.i(9916139962368L, 73881);
    int i = (int)(aa.getContext().getResources().getDisplayMetrics().density * paramFloat + 0.5F);
    GMTrace.o(9916139962368L, 73881);
    return i;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/photoedit/g/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */