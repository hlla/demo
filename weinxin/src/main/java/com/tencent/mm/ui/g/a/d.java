package com.tencent.mm.ui.g.a;

import com.tencent.gmtrace.GMTrace;

public final class d
  extends Throwable
{
  public int jTc;
  public String wek;
  
  public d(String paramString)
  {
    super(paramString);
    GMTrace.i(2910511431680L, 21685);
    this.jTc = 0;
    GMTrace.o(2910511431680L, 21685);
  }
  
  public d(String paramString1, String paramString2, int paramInt)
  {
    super(paramString1);
    GMTrace.i(2910645649408L, 21686);
    this.jTc = 0;
    this.wek = paramString2;
    this.jTc = paramInt;
    GMTrace.o(2910645649408L, 21686);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/g/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */