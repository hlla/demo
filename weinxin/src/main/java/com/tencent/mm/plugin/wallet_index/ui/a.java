package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Context;
import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelpay.PayReq.Options;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class a
{
  public static boolean a(Context paramContext, String paramString, PayResp paramPayResp, PayReq.Options paramOptions)
  {
    GMTrace.i(7585314897920L, 56515);
    v.d("MicroMsg.PayCallbackHelper", "callback, packageName = " + paramString);
    String str;
    if ((paramOptions == null) || (bf.mA(paramOptions.callbackClassName)))
    {
      str = paramString + ".wxapi.WXPayEntryActivity";
      if ((paramOptions != null) && (paramOptions.callbackFlags != -1)) {
        break label206;
      }
    }
    label206:
    for (int i = 268435456;; i = paramOptions.callbackFlags)
    {
      v.d("MicroMsg.PayCallbackHelper", "callback, cbPkg = " + paramString + ", cbCls = " + str + ", cbFlags(hex) = " + Integer.toHexString(i));
      paramOptions = new Bundle();
      paramOptions.putString("wx_token_key", "com.tencent.mm.openapi.token");
      if (paramPayResp != null) {
        paramPayResp.toBundle(paramOptions);
      }
      paramPayResp = new MMessageActV2.Args();
      paramPayResp.targetPkgName = paramString;
      paramPayResp.targetClassName = str;
      paramPayResp.bundle = paramOptions;
      paramPayResp.flags = i;
      boolean bool = MMessageActV2.send(paramContext, paramPayResp);
      GMTrace.o(7585314897920L, 56515);
      return bool;
      str = paramOptions.callbackClassName;
      break;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/wallet_index/ui/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */