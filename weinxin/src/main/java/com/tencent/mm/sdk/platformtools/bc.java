package com.tencent.mm.sdk.platformtools;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.d;

public final class bc
{
  private final d uuc;
  private x<String, String> uud;
  
  public bc(String paramString)
  {
    GMTrace.i(13872744366080L, 103360);
    this.uud = new x(256);
    this.uuc = new d(paramString);
    GMTrace.o(13872744366080L, 103360);
  }
  
  public final String decryptTag(String paramString)
  {
    GMTrace.i(13872878583808L, 103361);
    String str1 = paramString;
    try
    {
      if (!paramString.startsWith("!")) {
        break label214;
      }
      if (this.uud.aV(paramString))
      {
        str1 = (String)this.uud.get(paramString);
        GMTrace.o(13872878583808L, 103361);
        return str1;
      }
      str1 = paramString.substring(1);
      Object localObject;
      String str2;
      int i;
      v.printErrStackTrace("MicroMsg.TagDecrypter", paramString, "", new Object[0]);
    }
    catch (Exception localException)
    {
      try
      {
        localObject = str1.split("@");
        if (localObject.length <= 1) {
          break label228;
        }
        str2 = localObject[0];
        i = Integer.valueOf(localObject[0]).intValue();
        localObject = str1.substring(str2.length() + 1, str2.length() + 1 + i);
        str2 = str1.substring(i + (str2.length() + 1));
        str2 = this.uuc.aM((String)localObject) + str2;
        this.uud.put(paramString, str2);
        GMTrace.o(13872878583808L, 103361);
        return str2;
      }
      catch (Exception paramString)
      {
        for (;;) {}
      }
      localException = localException;
      str1 = paramString;
      paramString = localException;
    }
    str1 = "[td]" + str1;
    label214:
    GMTrace.o(13872878583808L, 103361);
    return str1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/platformtools/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */