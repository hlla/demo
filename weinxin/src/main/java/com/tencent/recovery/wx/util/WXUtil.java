package com.tencent.recovery.wx.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.recovery.util.Util;
import java.util.UUID;

public class WXUtil
{
  public static final String CK(int paramInt)
  {
    return "KeyConfigHttpCode[" + paramInt + "]";
  }
  
  public static final String CL(int paramInt)
  {
    return "KeyPatchHttpCode[" + paramInt + "]";
  }
  
  public static final String UW(String paramString)
  {
    if (paramString.contains("?")) {
      return paramString + "uuid=" + UUID.randomUUID().toString();
    }
    return paramString + "?uuid=" + UUID.randomUUID().toString();
  }
  
  public static String fw(Context paramContext)
  {
    return paramContext.getSharedPreferences(paramContext.getPackageName() + "_preferences", 0).getString("last_login_uin", "0");
  }
  
  public static String fx(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(paramContext.getPackageName() + "_preferences", 0);
    Object localObject2 = localSharedPreferences.getString("login_weixin_username", "");
    Object localObject1 = localObject2;
    if (Util.mA((String)localObject2)) {
      localObject1 = localSharedPreferences.getString("login_user_name", "");
    }
    localObject2 = localObject1;
    if (Util.mA((String)localObject1)) {
      localObject2 = String.valueOf(Util.fs(paramContext));
    }
    return (String)localObject2;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/recovery/wx/util/WXUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */