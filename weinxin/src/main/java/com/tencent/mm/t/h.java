package com.tencent.mm.t;

import android.util.Base64;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;

public final class h
{
  public static boolean em(String paramString)
  {
    GMTrace.i(16382213226496L, 122057);
    if ((paramString != null) && (paramString.endsWith("@app")))
    {
      GMTrace.o(16382213226496L, 122057);
      return true;
    }
    GMTrace.o(16382213226496L, 122057);
    return false;
  }
  
  public static k en(String paramString)
  {
    GMTrace.i(16382615879680L, 122060);
    try
    {
      k localk = (k)new k().aD(Base64.decode(paramString, 0));
      paramString = localk;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          paramString = (k)new k().aD(bf.PS(paramString));
        }
        catch (Exception paramString)
        {
          paramString = new k();
        }
      }
    }
    GMTrace.o(16382615879680L, 122060);
    return paramString;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/t/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */