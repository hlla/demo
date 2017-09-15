package com.tencent.mm.modelcontrol;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public final class b
{
  public static long Er()
  {
    GMTrace.i(4105049210880L, 30585);
    long l = (int)(TimeZone.getDefault().getRawOffset() / 60000L) / 60L;
    GMTrace.o(4105049210880L, 30585);
    return l;
  }
  
  public static boolean iU(String paramString)
  {
    GMTrace.i(4104646557696L, 30582);
    if (bf.mA(paramString))
    {
      GMTrace.o(4104646557696L, 30582);
      return false;
    }
    try
    {
      String[] arrayOfString1 = new SimpleDateFormat("HH:mm").format(new Date()).split(":");
      int i = bf.PX(arrayOfString1[0]);
      int j = bf.PX(arrayOfString1[1]) + i * 60 - ((int)Er() - 8) * 60;
      if (j < 0) {
        j += 1440;
      }
      label283:
      label327:
      for (;;)
      {
        paramString = paramString.split(";");
        int k = 0;
        for (;;)
        {
          if (k >= paramString.length) {
            break label327;
          }
          arrayOfString1 = paramString[k].split("-");
          String[] arrayOfString2 = arrayOfString1[0].split(":");
          i = bf.PX(arrayOfString2[0]);
          i = bf.PX(arrayOfString2[1]) + i * 60;
          arrayOfString1 = arrayOfString1[1].split(":");
          int m = bf.PX(arrayOfString1[0]);
          int n = bf.PX(arrayOfString1[1]);
          m = n + m * 60;
          if (i < m) {
            if ((j < m) && (j >= i)) {
              i = 1;
            }
          }
          for (;;)
          {
            if (i == 0) {
              break label283;
            }
            GMTrace.o(4104646557696L, 30582);
            return true;
            if (j < 1440) {
              break label338;
            }
            j -= 1440;
            break;
            i = 0;
            continue;
            if ((j <= 1440) && (j >= i)) {
              i = 1;
            } else if ((j < m) && (j >= 0)) {
              i = 1;
            } else {
              i = 0;
            }
          }
          k += 1;
        }
      }
    }
    catch (Exception paramString)
    {
      v.printErrStackTrace("MicroMsg.BusyTimeControlLogic", paramString, "", new Object[0]);
      v.e("MicroMsg.BusyTimeControlLogic", "checkNeedToControl error : " + paramString.toString());
      GMTrace.o(4104646557696L, 30582);
      return false;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelcontrol/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */