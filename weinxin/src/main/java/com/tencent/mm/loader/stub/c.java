package com.tencent.mm.loader.stub;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.aa;

public class c
{
  public static c hgm;
  public final SharedPreferences hgn;
  
  static
  {
    GMTrace.i(14008170053632L, 104369);
    hgm = new c(null);
    GMTrace.o(14008170053632L, 104369);
  }
  
  public c(SharedPreferences paramSharedPreferences)
  {
    GMTrace.i(14007901618176L, 104367);
    if (paramSharedPreferences == null)
    {
      this.hgn = aa.getContext().getSharedPreferences(aa.bIN(), 0);
      GMTrace.o(14007901618176L, 104367);
      return;
    }
    this.hgn = paramSharedPreferences;
    GMTrace.o(14007901618176L, 104367);
  }
  
  public final String A(String paramString1, String paramString2)
  {
    GMTrace.i(14008035835904L, 104368);
    paramString1 = this.hgn.getString(paramString1, paramString2);
    GMTrace.o(14008035835904L, 104368);
    return paramString1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/loader/stub/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */