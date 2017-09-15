package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.gmtrace.GMTrace;
import java.util.Map;

public final class f
{
  public static int fuN;
  public static String fuO;
  public static int fuP;
  public static int fuT;
  public static int uqD;
  public static int uqE;
  public static String uqF;
  public static boolean uqG;
  public static boolean uqH;
  public static boolean uqI;
  public static boolean uqJ;
  
  static
  {
    GMTrace.i(13931665948672L, 103799);
    fuP = 0;
    fuN = 0;
    uqD = 0;
    fuT = 0;
    fuO = Build.VERSION.SDK_INT;
    uqE = 0;
    uqF = "market://details?id=" + aa.getPackageName();
    uqG = false;
    uqH = true;
    uqI = false;
    uqJ = false;
    GMTrace.o(13931665948672L, 103799);
  }
  
  public static String Z(Context paramContext, int paramInt)
  {
    GMTrace.i(13931397513216L, 103797);
    paramContext = b(paramContext, paramInt, uqG);
    GMTrace.o(13931397513216L, 103797);
    return paramContext;
  }
  
  public static String b(Context paramContext, int paramInt, boolean paramBoolean)
  {
    GMTrace.i(13931531730944L, 103798);
    int i = paramInt >> 8 & 0xFF;
    if (i == 0) {}
    String str2;
    for (String str1 = (paramInt >> 24 & 0xF) + "." + (paramInt >> 16 & 0xFF);; str1 = (paramInt >> 24 & 0xF) + "." + (paramInt >> 16 & 0xFF) + "." + i)
    {
      v.d("MicroMsg.SDK.ChannelUtil", "minminor " + i);
      i = 0xFFFFFFF & paramInt;
      str2 = str1;
      paramInt = i;
      if (paramContext != null) {
        paramInt = i;
      }
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 128);
        str2 = str1;
        paramInt = i;
        if (paramContext != null)
        {
          paramInt = i;
          i = paramContext.versionCode;
          paramInt = i;
          str2 = paramContext.versionName;
          paramInt = i;
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          v.printErrStackTrace("MicroMsg.SDK.ChannelUtil", paramContext, "", new Object[0]);
          str2 = str1;
        }
        paramContext = str2.split("\\.");
        if ((paramContext != null) && (paramContext.length >= 4)) {
          break label298;
        }
        GMTrace.o(13931531730944L, 103798);
        return str2;
        str1 = paramContext[0] + "." + paramContext[1];
        if (!paramContext[2].trim().equals("0")) {
          break label352;
        }
        GMTrace.o(13931531730944L, 103798);
        return str1;
        paramContext = str1 + "." + paramContext[2];
        GMTrace.o(13931531730944L, 103798);
      }
      if (!paramBoolean) {
        break;
      }
      paramContext = str2 + "_" + paramInt;
      v.d("MicroMsg.SDK.ChannelUtil", "full version: " + paramContext);
      GMTrace.o(13931531730944L, 103798);
      return paramContext;
    }
    label298:
    label352:
    return paramContext;
  }
  
  public static boolean bIq()
  {
    GMTrace.i(14906220871680L, 111060);
    if (fuN == 1001)
    {
      GMTrace.o(14906220871680L, 111060);
      return true;
    }
    GMTrace.o(14906220871680L, 111060);
    return false;
  }
  
  public static void dW(Context paramContext)
  {
    GMTrace.i(13930860642304L, 103793);
    try
    {
      fuN = Integer.parseInt((String)q.Pk(bf.convertStreamToString(paramContext.getAssets().open("channel.ini"))).get("CHANNEL"));
      GMTrace.o(13930860642304L, 103793);
      return;
    }
    catch (Exception paramContext)
    {
      v.e("MicroMsg.SDK.ChannelUtil", "setup channel id from channel.ini failed");
      v.printErrStackTrace("MicroMsg.SDK.ChannelUtil", paramContext, "", new Object[0]);
      GMTrace.o(13930860642304L, 103793);
    }
  }
  
  public static void dX(Context paramContext)
  {
    GMTrace.i(13930994860032L, 103794);
    try
    {
      paramContext = q.Pk(bf.convertStreamToString(paramContext.getAssets().open("profile.ini")));
      String str = bf.mz((String)paramContext.get("PROFILE_DEVICE_TYPE"));
      fuO = str;
      if (str.length() <= 0) {
        fuO = Build.VERSION.SDK_INT;
      }
      fuP = parseInt((String)paramContext.get("UPDATE_MODE"));
      uqE = parseInt((String)paramContext.get("BUILD_REVISION"));
      uqI = parseBoolean((String)paramContext.get("GPRS_ALERT"));
      fuT = parseInt((String)paramContext.get("AUTO_ADD_ACOUNT"));
      uqJ = parseBoolean((String)paramContext.get("NOKIA_AOL"));
      v.w("MicroMsg.SDK.ChannelUtil", "profileDeviceType=" + fuO);
      v.w("MicroMsg.SDK.ChannelUtil", "updateMode=" + fuP);
      v.w("MicroMsg.SDK.ChannelUtil", "shouldShowGprsAlert=" + uqI);
      v.w("MicroMsg.SDK.ChannelUtil", "autoAddAccount=" + fuT);
      v.w("MicroMsg.SDK.ChannelUtil", "isNokiaol=" + uqJ);
      paramContext = (String)paramContext.get("MARKET_URL");
      if ((paramContext != null) && (paramContext.trim().length() != 0) && (Uri.parse(paramContext) != null)) {
        uqF = paramContext;
      }
      v.w("MicroMsg.SDK.ChannelUtil", "marketURL=" + uqF);
      GMTrace.o(13930994860032L, 103794);
      return;
    }
    catch (Exception paramContext)
    {
      v.e("MicroMsg.SDK.ChannelUtil", "setup profile from profile.ini failed");
      v.printErrStackTrace("MicroMsg.SDK.ChannelUtil", paramContext, "", new Object[0]);
      GMTrace.o(13930994860032L, 103794);
    }
  }
  
  private static boolean parseBoolean(String paramString)
  {
    GMTrace.i(13931263295488L, 103796);
    try
    {
      boolean bool = Boolean.parseBoolean(paramString);
      GMTrace.o(13931263295488L, 103796);
      return bool;
    }
    catch (Exception paramString)
    {
      v.printErrStackTrace("MicroMsg.SDK.ChannelUtil", paramString, "", new Object[0]);
      v.w("MicroMsg.SDK.ChannelUtil", paramString.getMessage());
      GMTrace.o(13931263295488L, 103796);
    }
    return false;
  }
  
  private static int parseInt(String paramString)
  {
    GMTrace.i(13931129077760L, 103795);
    try
    {
      int i = Integer.parseInt(paramString);
      GMTrace.o(13931129077760L, 103795);
      return i;
    }
    catch (Exception paramString)
    {
      v.w("MicroMsg.SDK.ChannelUtil", paramString.getMessage());
      GMTrace.o(13931129077760L, 103795);
    }
    return 0;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/platformtools/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */