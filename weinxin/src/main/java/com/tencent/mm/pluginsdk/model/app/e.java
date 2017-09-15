package com.tencent.mm.pluginsdk.model.app;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.n;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.w.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class e
{
  private ad handler;
  public List<r> pkz;
  public List<r> sBt;
  public Map<String, Integer> sBu;
  private ai sBv;
  
  public e()
  {
    GMTrace.i(792287248384L, 5903);
    this.sBt = null;
    this.pkz = null;
    this.sBu = null;
    this.sBv = new ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(774973161472L, 5774);
        e.this.sBu.clear();
        GMTrace.o(774973161472L, 5774);
        return false;
      }
    }, false);
    this.handler = new ad(h.vL().nIe.getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(829197123584L, 6178);
        paramAnonymousMessage = (u)paramAnonymousMessage.obj;
        r localr = new r(paramAnonymousMessage.appId, paramAnonymousMessage.hRU);
        if (e.this.sBt.contains(localr))
        {
          e.this.sBt.remove(localr);
          if (!a.aRk().d(paramAnonymousMessage.appId, paramAnonymousMessage.data, paramAnonymousMessage.hRU)) {
            v.e("MicroMsg.AppIconService", "handleMessage, saveIcon fail");
          }
        }
        while (e.this.pkz.size() > 0)
        {
          paramAnonymousMessage = (r)e.this.pkz.remove(0);
          if (e.this.a(paramAnonymousMessage))
          {
            e.this.sBt.add(paramAnonymousMessage);
            GMTrace.o(829197123584L, 6178);
            return;
          }
        }
        GMTrace.o(829197123584L, 6178);
      }
    };
    this.sBt = new ArrayList();
    this.pkz = new ArrayList();
    this.sBu = new HashMap();
    this.sBv.v(600000L, 600000L);
    GMTrace.o(792287248384L, 5903);
  }
  
  public final boolean a(r paramr)
  {
    GMTrace.i(792555683840L, 5905);
    if (paramr == null)
    {
      v.e("MicroMsg.AppIconService", "startDownload fail, geticoninfo is null");
      GMTrace.o(792555683840L, 5905);
      return false;
    }
    int i;
    if (paramr == null)
    {
      v.e("MicroMsg.AppIconService", "increaseCounter fail, info is null");
      i = 0;
    }
    while (i == 0)
    {
      v.e("MicroMsg.AppIconService", "increaseCounter fail");
      GMTrace.o(792555683840L, 5905);
      return false;
      localObject = Integer.valueOf(bf.a((Integer)this.sBu.get(paramr.toString()), 0));
      if (((Integer)localObject).intValue() >= 5)
      {
        v.e("MicroMsg.AppIconService", "increaseCounter fail, has reached the max try count");
        i = 0;
      }
      else
      {
        this.sBu.put(paramr.toString(), Integer.valueOf(((Integer)localObject).intValue() + 1));
        i = 1;
      }
    }
    Object localObject = a.aRk().Md(paramr.appId);
    if (localObject == null)
    {
      v.e("MicroMsg.AppIconService", "push, appinfo does not exist, appId = " + paramr.appId);
      GMTrace.o(792555683840L, 5905);
      return false;
    }
    switch (paramr.hRU)
    {
    default: 
      v.e("MicroMsg.AppIconService", "push, unknown iconType = " + paramr.hRU);
      GMTrace.o(792555683840L, 5905);
      return false;
    case 1: 
      if ((((f)localObject).field_appIconUrl == null) || (((f)localObject).field_appIconUrl.length() == 0))
      {
        v.e("MicroMsg.AppIconService", "push, appIconUrl is null, appId = " + paramr.appId);
        GMTrace.o(792555683840L, 5905);
        return false;
      }
      localObject = ((f)localObject).field_appIconUrl;
    }
    for (;;)
    {
      v.i("MicroMsg.AppIconService", "appIconUrl = " + (String)localObject);
      com.tencent.mm.sdk.f.e.post(new s(this.handler, paramr.appId, paramr.hRU, (String)localObject), "AppIconService_getIcon");
      GMTrace.o(792555683840L, 5905);
      return true;
      if ((((f)localObject).field_appWatermarkUrl == null) || (((f)localObject).field_appWatermarkUrl.length() == 0))
      {
        v.e("MicroMsg.AppIconService", "push, appWatermarkUrl is null, appId = " + paramr.appId);
        GMTrace.o(792555683840L, 5905);
        return false;
      }
      localObject = ((f)localObject).field_appWatermarkUrl;
      continue;
      if ((((n)localObject).geZ == null) || (((n)localObject).geZ.length() == 0))
      {
        v.e("MicroMsg.AppIconService", "push, appSuggestionIconUrl is null, appId = " + paramr.appId);
        GMTrace.o(792555683840L, 5905);
        return false;
      }
      localObject = ((n)localObject).geZ;
      continue;
      if ((((n)localObject).gfk == null) || (((n)localObject).gfk.length() == 0))
      {
        v.e("MicroMsg.AppIconService", "push, servicePanelIconUrl is null, appId = " + paramr.appId);
        GMTrace.o(792555683840L, 5905);
        return false;
      }
      localObject = ((n)localObject).gfk;
      continue;
      if ((((n)localObject).gfl == null) || (((n)localObject).gfl.length() == 0))
      {
        v.e("MicroMsg.AppIconService", "push, serviceListIconUrl is null, appId = " + paramr.appId);
        GMTrace.o(792555683840L, 5905);
        return false;
      }
      localObject = ((n)localObject).gfl;
    }
  }
  
  public final void cu(String paramString, int paramInt)
  {
    GMTrace.i(792421466112L, 5904);
    if ((paramString == null) || (paramString.length() == 0))
    {
      v.e("MicroMsg.AppIconService", "push fail, appId is null");
      GMTrace.o(792421466112L, 5904);
      return;
    }
    r localr = new r(paramString, paramInt);
    if (this.sBt.contains(localr))
    {
      v.i("MicroMsg.AppIconService", "push, appId = " + paramString + ", iconType = " + paramInt + " already in running list");
      GMTrace.o(792421466112L, 5904);
      return;
    }
    if (this.sBt.size() >= 5)
    {
      v.i("MicroMsg.AppIconService", "running list has reached the max count");
      if (!this.pkz.contains(localr)) {
        this.pkz.add(localr);
      }
      GMTrace.o(792421466112L, 5904);
      return;
    }
    if (a(localr)) {
      this.sBt.add(localr);
    }
    GMTrace.o(792421466112L, 5904);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */