package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

class TbsLinuxToolsJni
{
  private static boolean wTm = false;
  private static boolean wTn = false;
  
  public TbsLinuxToolsJni(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (wTn) {
          return;
        }
        wTn = true;
      }
      finally {}
      try
      {
        if (!t.gu(paramContext)) {
          break label162;
        }
        localFile1 = new File(t.ceE());
        if (localFile1 != null)
        {
          File localFile2 = localFile1;
          if (!new File(localFile1.getAbsolutePath() + File.separator + "liblinuxtoolsfortbssdk_jni.so").exists())
          {
            localFile2 = localFile1;
            if (!t.gu(paramContext))
            {
              p.ceq();
              localFile2 = p.gj(paramContext);
            }
          }
          if (localFile2 != null)
          {
            System.load(localFile2.getAbsolutePath() + File.separator + "liblinuxtoolsfortbssdk_jni.so");
            wTm = true;
          }
        }
        ChmodInner("/checkChmodeExists", "700");
      }
      catch (Throwable paramContext)
      {
        wTm = false;
        continue;
      }
      return;
      label162:
      p.ceq();
      File localFile1 = p.gk(paramContext);
    }
  }
  
  private native int ChmodInner(String paramString1, String paramString2);
  
  public final int ff(String paramString1, String paramString2)
  {
    if (!wTm)
    {
      TbsLog.e("TbsLinuxToolsJni", "jni not loaded!", true);
      return -1;
    }
    return ChmodInner(paramString1, paramString2);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/sdk/TbsLinuxToolsJni.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */