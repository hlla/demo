package com.tencent.recovery.wx.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetUtil
{
  public static String fv(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return "NOT_NETWORK";
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null) {
      return "NOT_NETWORK";
    }
    if (!paramContext.isConnected()) {
      return "NOT_NETWORK";
    }
    if (paramContext.getType() == 1) {
      return "WIFI";
    }
    if (paramContext.getSubtype() >= 13) {
      return "4G";
    }
    if ((paramContext.getSubtype() >= 5) && (paramContext.getSubtype() < 13)) {
      return "3G";
    }
    return "other";
  }
  
  public static boolean isConnected(Context paramContext)
  {
    return !fv(paramContext).equals("NOT_NETWORK");
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/recovery/wx/util/NetUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */