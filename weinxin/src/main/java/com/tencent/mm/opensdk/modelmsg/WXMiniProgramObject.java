package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class WXMiniProgramObject
  implements WXMediaMessage.IMediaObject
{
  private static final String TAG = "MicroMsg.SDK.WXMiniProgramObject";
  public String path;
  public String userName;
  public String webpageUrl;
  public boolean withShareTicket;
  
  public WXMiniProgramObject()
  {
    GMTrace.i(42144366592L, 314);
    GMTrace.o(42144366592L, 314);
  }
  
  public boolean checkArgs()
  {
    GMTrace.i(42681237504L, 318);
    if (d.a(this.webpageUrl))
    {
      Log.e("MicroMsg.SDK.WXMiniProgramObject", "webPageUrl is null");
      GMTrace.o(42681237504L, 318);
      return false;
    }
    if (d.a(this.userName))
    {
      Log.e("MicroMsg.SDK.WXMiniProgramObject", "userName is null");
      GMTrace.o(42681237504L, 318);
      return false;
    }
    GMTrace.o(42681237504L, 318);
    return true;
  }
  
  public void serialize(Bundle paramBundle)
  {
    GMTrace.i(42278584320L, 315);
    paramBundle.putString("_wxminiprogram_webpageurl", this.webpageUrl);
    paramBundle.putString("_wxminiprogram_username", this.userName);
    paramBundle.putString("_wxminiprogram_path", this.path);
    paramBundle.putBoolean("_wxminiprogram_withsharetiket", this.withShareTicket);
    GMTrace.o(42278584320L, 315);
  }
  
  public int type()
  {
    GMTrace.i(42547019776L, 317);
    GMTrace.o(42547019776L, 317);
    return 36;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    GMTrace.i(42412802048L, 316);
    this.webpageUrl = paramBundle.getString("_wxminiprogram_webpageurl");
    this.userName = paramBundle.getString("_wxminiprogram_username");
    this.path = paramBundle.getString("_wxminiprogram_path");
    this.withShareTicket = paramBundle.getBoolean("_wxminiprogram_withsharetiket");
    GMTrace.o(42412802048L, 316);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/opensdk/modelmsg/WXMiniProgramObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */