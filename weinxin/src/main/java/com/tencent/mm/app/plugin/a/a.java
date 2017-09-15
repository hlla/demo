package com.tencent.mm.app.plugin.a;

import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.cr;
import com.tencent.mm.e.a.dq;
import com.tencent.mm.e.a.io;
import com.tencent.mm.e.a.kl;
import com.tencent.mm.e.a.pq;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo.a;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.q;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  public En_5b8fbb1e.a fyf;
  public b fyg;
  public a fyh;
  private String fyi;
  public Map<String, Boolean> fyj;
  public boolean fyk;
  
  public a(En_5b8fbb1e.a parama)
  {
    GMTrace.i(13033615130624L, 97108);
    v.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now init the event listener");
    this.fyf = parama;
    this.fyk = true;
    if (this.fyg == null) {
      this.fyg = new b();
    }
    com.tencent.mm.sdk.b.a.uql.b(this.fyg);
    if (this.fyh == null) {
      this.fyh = new a();
    }
    com.tencent.mm.sdk.b.a.uql.b(this.fyh);
    GMTrace.o(13033615130624L, 97108);
  }
  
  public static boolean a(BizInfo paramBizInfo)
  {
    GMTrace.i(13034017783808L, 97111);
    if (paramBizInfo == null)
    {
      GMTrace.o(13034017783808L, 97111);
      return false;
    }
    if (paramBizInfo != null)
    {
      paramBizInfo = paramBizInfo.bd(false);
      if ((paramBizInfo != null) && (paramBizInfo.Da() != null) && (paramBizInfo.Da().Dj()))
      {
        GMTrace.o(13034017783808L, 97111);
        return true;
      }
    }
    GMTrace.o(13034017783808L, 97111);
    return false;
  }
  
  public final void a(final int paramInt, BizInfo paramBizInfo)
  {
    GMTrace.i(13033883566080L, 97110);
    if (this.fyf == null)
    {
      v.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "notifySwitchView, context is null, maybe has been released");
      GMTrace.o(13033883566080L, 97110);
      return;
    }
    if ((o.eV(this.fyf.bTW())) && (a(paramBizInfo))) {
      ap.vL().D(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(13032004517888L, 97096);
          if (1 == paramInt)
          {
            localObject = new dq();
            ((dq)localObject).fHq.op = 0;
            ((dq)localObject).fHq.userName = a.this.fyf.bTW();
            ((dq)localObject).fHq.context = a.this.fyf.uRf.uRz;
            com.tencent.mm.sdk.b.a.uql.m((b)localObject);
            if (a.this.fyf.bTW().equals("gh_43f2581f6fd6"))
            {
              localObject = new pq();
              ((pq)localObject).fWq.action = 1;
              com.tencent.mm.sdk.b.a.uql.a((b)localObject, Looper.getMainLooper());
            }
          }
          Object localObject = new io();
          ((io)localObject).fOe.opType = paramInt;
          ((io)localObject).fOe.fOg = 1;
          ((io)localObject).fOe.fOf = a.this.fyf.bTW();
          com.tencent.mm.sdk.b.a.uql.m((b)localObject);
          GMTrace.o(13032004517888L, 97096);
        }
      });
    }
    GMTrace.o(13033883566080L, 97110);
  }
  
  public final void d(int paramInt, String paramString1, String paramString2)
  {
    label123:
    Map localMap;
    for (;;)
    {
      BizInfo localBizInfo;
      try
      {
        GMTrace.i(13033749348352L, 97109);
        v.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connect state : %d", new Object[] { Integer.valueOf(paramInt) });
        if ((this.fyf == null) || (bf.mA(paramString1)))
        {
          v.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null or brandName is null or nil.");
          GMTrace.o(13033749348352L, 97109);
          return;
        }
        localBizInfo = e.hW(paramString1);
        if (!a(localBizInfo))
        {
          v.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "It's not a biz, brandName(%s).", new Object[] { paramString1 });
          GMTrace.o(13033749348352L, 97109);
          continue;
        }
        if (this.fyj != null) {
          break label123;
        }
      }
      finally {}
      this.fyj = new HashMap();
      localMap = this.fyj;
      if (!paramString1.equals(this.fyi))
      {
        this.fyi = paramString1;
        localMap.clear();
      }
      if (localBizInfo.bd(false).Da().huL != 1) {
        break;
      }
      this.fyf.SD(null);
      GMTrace.o(13033749348352L, 97109);
    }
    v.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "connDeviceIds : (%s) , deviceId : (%s)", new Object[] { localMap, paramString2 });
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(13033749348352L, 97109);
      break;
      this.fyf.SD(null);
      GMTrace.o(13033749348352L, 97109);
      break;
      if (localMap.size() == 0)
      {
        this.fyf.ze(R.l.efO);
        GMTrace.o(13033749348352L, 97109);
        break;
        localMap.put(paramString2, Boolean.valueOf(true));
        this.fyf.SD(this.fyf.getString(R.l.efM, new Object[] { Integer.valueOf(localMap.size()) }));
        v.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connected(deviceId : %s), set the tips gone", new Object[] { paramString2 });
        GMTrace.o(13033749348352L, 97109);
        break;
        if (localMap.remove(paramString2) != null) {
          v.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "disconnected(deviceId : %s) successfully.", new Object[] { paramString2 });
        }
        this.fyf.SD(this.fyf.getString(R.l.efM, new Object[] { Integer.valueOf(localMap.size()) }));
        GMTrace.o(13033749348352L, 97109);
        break;
        if (localMap.size() == 0) {
          this.fyf.ze(R.l.efN);
        }
      }
    }
  }
  
  final class a
    extends c<cr>
  {
    a()
    {
      GMTrace.i(13033346695168L, 97106);
      this.uqt = cr.class.getName().hashCode();
      GMTrace.o(13033346695168L, 97106);
    }
  }
  
  final class b
    extends c<kl>
  {
    b()
    {
      GMTrace.i(13033078259712L, 97104);
      this.uqt = kl.class.getName().hashCode();
      GMTrace.o(13033078259712L, 97104);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/app/plugin/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */