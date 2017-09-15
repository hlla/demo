package com.tencent.mm.modelsns;

import com.tencent.gmtrace.GMTrace;

public final class d
{
  StringBuffer hTn;
  StringBuffer hTo;
  private int index;
  
  public d()
  {
    GMTrace.i(4458981359616L, 33222);
    this.hTn = new StringBuffer();
    this.hTo = new StringBuffer();
    this.index = 0;
    GMTrace.o(4458981359616L, 33222);
  }
  
  public final String JH()
  {
    GMTrace.i(4459518230528L, 33226);
    this.index = 0;
    this.hTn.append("--end--\n\n");
    String str = this.hTn.toString();
    GMTrace.o(4459518230528L, 33226);
    return str;
  }
  
  public final void m(String paramString, Object paramObject)
  {
    GMTrace.i(4459115577344L, 33223);
    this.hTn.append(this.index + " " + paramString + "->" + paramObject + "\n");
    this.hTo.append(paramObject);
    this.index += 1;
    GMTrace.o(4459115577344L, 33223);
  }
  
  public final void n(String paramString, Object paramObject)
  {
    GMTrace.i(4459249795072L, 33224);
    this.hTn.append(paramString + "->" + paramObject + "\n");
    this.hTo.append(paramObject);
    GMTrace.o(4459249795072L, 33224);
  }
  
  public final String toString()
  {
    GMTrace.i(4459384012800L, 33225);
    String str = this.hTo.toString();
    GMTrace.o(4459384012800L, 33225);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsns/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */