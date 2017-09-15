package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.bx;
import com.tencent.mm.modelsimple.ah;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.net.URLDecoder;

public final class e
{
  public static void t(Activity paramActivity)
  {
    GMTrace.i(16084115652608L, 119836);
    Intent localIntent = new Intent();
    localIntent.setFlags(268435456);
    localIntent.setClassName(aa.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
    localIntent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
    localIntent.putExtra("showShare", false);
    aa.getContext().startActivity(localIntent);
    if (paramActivity != null) {
      paramActivity.finish();
    }
    GMTrace.o(16084115652608L, 119836);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/base/stub/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */