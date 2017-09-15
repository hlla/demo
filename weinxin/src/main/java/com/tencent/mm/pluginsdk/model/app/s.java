package com.tencent.mm.pluginsdk.model.app;

import android.os.Message;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;

final class s
  implements Runnable
{
  private String appId;
  private int hRU;
  private ad handler;
  private String url;
  
  public s(ad paramad, String paramString1, int paramInt, String paramString2)
  {
    GMTrace.i(827586510848L, 6166);
    this.handler = null;
    this.appId = null;
    this.hRU = 0;
    this.url = null;
    this.handler = paramad;
    this.appId = paramString1;
    this.hRU = paramInt;
    this.url = paramString2;
    GMTrace.o(827586510848L, 6166);
  }
  
  public final void run()
  {
    GMTrace.i(827720728576L, 6167);
    if ((this.appId == null) || (this.appId.length() == 0) || (this.url == null) || (this.url.length() == 0))
    {
      GMTrace.o(827720728576L, 6167);
      return;
    }
    Object localObject = bf.Qb(this.url);
    localObject = new u(this.appId, this.hRU, (byte[])localObject);
    Message localMessage = Message.obtain();
    localMessage.obj = localObject;
    this.handler.sendMessage(localMessage);
    GMTrace.o(827720728576L, 6167);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */