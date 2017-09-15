package com.tencent.mm.pluginsdk.h;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public final class a
{
  public static Bundle LL(String paramString)
  {
    GMTrace.i(1230373912576L, 9167);
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_scene", 1);
    paramString = paramString.split("&");
    if ((paramString == null) || (paramString.length == 0))
    {
      v.e("MicroMsg.MallManager", "getWapPayBundle arrKeys == null || arrKeys.length == 0");
      GMTrace.o(1230373912576L, 9167);
      return localBundle;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramString.length)
    {
      Object localObject = paramString[i];
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("=");
        if ((localObject != null) && (localObject.length == 2)) {
          localHashMap.put(localObject[0], localObject[1]);
        }
      }
      i += 1;
    }
    localBundle.putString("_wxapi_payreq_appid", c("appid", localHashMap));
    localBundle.putString("_wxapi_payreq_partnerid", c("partnerid", localHashMap));
    localBundle.putString("_wxapi_payreq_prepayid", c("prepayid", localHashMap));
    localBundle.putString("_wxapi_payreq_noncestr", c("noncestr", localHashMap));
    localBundle.putString("_wxapi_payreq_timestamp", c("timestamp", localHashMap));
    localBundle.putString("_wxapi_payreq_packagevalue", c("package", localHashMap));
    localBundle.putString("_wxapi_payreq_sign", c("sign", localHashMap));
    localBundle.putString("_wxapi_payreq_sign_type", c("signtype", localHashMap));
    localBundle.putString("_wxapi_payreq_extdata", c("extdata", localHashMap));
    localBundle.putString("_wxapi_payoptions_callback_classname", "");
    localBundle.putInt("_wxapi_payoptions_callback_flags", -1);
    GMTrace.o(1230373912576L, 9167);
    return localBundle;
  }
  
  private static String c(String paramString, HashMap<String, String> paramHashMap)
  {
    GMTrace.i(1230508130304L, 9168);
    paramHashMap = (String)paramHashMap.get(paramString);
    if (TextUtils.isEmpty(paramHashMap))
    {
      v.e("MicroMsg.MallManager", "getWapPayKey key: " + paramString + " value is empty");
      GMTrace.o(1230508130304L, 9168);
      return "";
    }
    GMTrace.o(1230508130304L, 9168);
    return paramHashMap;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/h/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */