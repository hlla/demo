package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.smtt.sdk.WebView;

public final class p
{
  private static String wWd = null;
  private static String wWe = "GA";
  private static String wWf = "GE";
  private static String wWg = "9422";
  private static String wWh = "0";
  private static String wWi = "";
  private static boolean wWj = false;
  private static boolean wWk = false;
  private static boolean wWl = false;
  
  private static String a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean)
  {
    localObject2 = null;
    StringBuilder localStringBuilder = new StringBuilder();
    String str = gX(paramContext) + "*" + gY(paramContext);
    for (localObject1 = localObject2;; localObject1 = paramString7)
    {
      try
      {
        ApplicationInfo localApplicationInfo = paramContext.getApplicationContext().getApplicationInfo();
        localObject1 = localObject2;
        localObject3 = paramContext.getPackageManager().getPackageInfo(localApplicationInfo.packageName, 0);
        localObject1 = localObject2;
        localObject2 = localApplicationInfo.packageName;
        localObject1 = localObject2;
        boolean bool = TextUtils.isEmpty(paramString7);
        if (bool) {
          break label416;
        }
        localObject1 = paramString7;
      }
      catch (PackageManager.NameNotFoundException paramString7)
      {
        for (;;)
        {
          Object localObject3;
          label416:
          paramString7 = null;
          localObject2 = localObject1;
          localObject1 = paramString7;
          continue;
          if (((String)localObject2).equals("com.tencent.mobileqq"))
          {
            paramString7 = "QQ";
          }
          else if (((String)localObject2).equals("com.qzone"))
          {
            paramString7 = "QZ";
          }
          else if (((String)localObject2).equals("com.tencent.mtt"))
          {
            paramString7 = "QB";
          }
          else
          {
            paramString7 = "TRD";
            continue;
            if (wWk)
            {
              paramBoolean = wWl;
              if (paramBoolean) {
                paramContext = "PAD";
              }
            }
            else
            {
              j = Math.min(gX(paramContext), gY(paramContext));
              localObject3 = (WindowManager)paramContext.getSystemService("window");
              paramContext = new DisplayMetrics();
              localObject3 = ((WindowManager)localObject3).getDefaultDisplay();
              if (localObject3 != null)
              {
                ((Display)localObject3).getMetrics(paramContext);
                i = paramContext.densityDpi;
                if (j * 160 / i < 700) {
                  break label631;
                }
              }
              for (paramBoolean = true;; paramBoolean = false)
              {
                wWl = paramBoolean;
                wWk = true;
                paramBoolean = wWl;
                break;
                i = 160;
                break label588;
              }
            }
            paramContext = "PHONE";
          }
        }
      }
      if (!((String)localObject2).equals("com.tencent.mm")) {
        break;
      }
      paramString7 = "WX";
      if (!"QB".equals(paramString7)) {
        break label508;
      }
      if (!paramBoolean) {
        break label645;
      }
      paramContext = "PAD";
      localStringBuilder.append("QV=3");
      b(localStringBuilder, "PL", "ADR");
      b(localStringBuilder, "PR", paramString7);
      b(localStringBuilder, "PP", (String)localObject2);
      b(localStringBuilder, "PPVN", (String)localObject1);
      if (!TextUtils.isEmpty(paramString1)) {
        b(localStringBuilder, "TBSVC", paramString1);
      }
      b(localStringBuilder, "CO", "SYS");
      if (!TextUtils.isEmpty(paramString2)) {
        b(localStringBuilder, "COVC", paramString2);
      }
      b(localStringBuilder, "PB", paramString4);
      b(localStringBuilder, "VE", paramString3);
      b(localStringBuilder, "DE", paramContext);
      paramContext = paramString6;
      if (TextUtils.isEmpty(paramString6)) {
        paramContext = "0";
      }
      b(localStringBuilder, "CHID", paramContext);
      b(localStringBuilder, "LCID", paramString5);
      paramContext = " " + Build.MODEL.replaceAll("[ |\\/|\\_|\\&|\\|]", "") + " ";
      try
      {
        paramString1 = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
        paramContext = paramString1;
      }
      catch (Exception paramString1)
      {
        for (;;) {}
      }
      if (!TextUtils.isEmpty(paramContext)) {
        b(localStringBuilder, "MO", paramContext);
      }
      b(localStringBuilder, "RL", str);
      paramContext = Build.VERSION.RELEASE;
      try
      {
        paramString1 = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
        paramContext = paramString1;
      }
      catch (Exception paramString1)
      {
        int j;
        int i;
        for (;;) {}
      }
      if (!TextUtils.isEmpty(paramContext)) {
        b(localStringBuilder, "OS", paramContext);
      }
      b(localStringBuilder, "API", Build.VERSION.SDK_INT);
      return localStringBuilder.toString();
      localObject1 = localObject2;
      paramString7 = ((PackageInfo)localObject3).versionName;
    }
  }
  
  private static void b(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    paramStringBuilder.append("&").append(paramString1).append("=").append(paramString2);
  }
  
  public static String gW(Context paramContext)
  {
    if (!TextUtils.isEmpty(wWd)) {
      return wWd;
    }
    paramContext = a(paramContext, String.valueOf(WebView.getTbsSDKVersion(paramContext)), "0", wWe, wWf, wWg, wWh, wWi, wWj);
    wWd = paramContext;
    return paramContext;
  }
  
  private static int gX(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (paramContext != null) {
      return paramContext.getWidth();
    }
    return -1;
  }
  
  private static int gY(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (paramContext != null) {
      return paramContext.getHeight();
    }
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/utils/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */