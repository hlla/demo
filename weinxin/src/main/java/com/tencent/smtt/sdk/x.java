package com.tencent.smtt.sdk;

import android.webkit.URLUtil;
import com.tencent.smtt.export.external.DexLoader;

public final class x
{
  public static boolean isHttpsUrl(String paramString)
  {
    ac localac = ac.ceR();
    if ((localac != null) && (localac.ceS()))
    {
      paramString = localac.ceT().wUo.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpsUrl", new Class[] { String.class }, new Object[] { paramString });
      if (paramString == null) {
        return false;
      }
      return ((Boolean)paramString).booleanValue();
    }
    return URLUtil.isHttpsUrl(paramString);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/sdk/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */