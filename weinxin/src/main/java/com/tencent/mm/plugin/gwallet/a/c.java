package com.tencent.mm.plugin.gwallet.a;

import com.tencent.gmtrace.GMTrace;

public final class c
{
  public int mJp;
  String mMessage;
  
  public c(int paramInt, String paramString)
  {
    GMTrace.i(8975139471360L, 66870);
    this.mJp = paramInt;
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      this.mMessage = b.nR(paramInt);
      GMTrace.o(8975139471360L, 66870);
      return;
    }
    this.mMessage = (paramString + " (response: " + b.nR(paramInt) + ")");
    GMTrace.o(8975139471360L, 66870);
  }
  
  public final boolean isSuccess()
  {
    GMTrace.i(8975273689088L, 66871);
    if (this.mJp == 0)
    {
      GMTrace.o(8975273689088L, 66871);
      return true;
    }
    GMTrace.o(8975273689088L, 66871);
    return false;
  }
  
  public final String toString()
  {
    GMTrace.i(8975407906816L, 66872);
    String str = "IabResult: " + this.mMessage;
    GMTrace.o(8975407906816L, 66872);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/gwallet/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */