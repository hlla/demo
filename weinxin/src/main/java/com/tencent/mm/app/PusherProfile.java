package com.tencent.mm.app;

import android.content.Context;
import android.content.res.Configuration;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.mars.sdt.SdtLogic;
import com.tencent.mm.booter.o;
import com.tencent.mm.booter.q;
import com.tencent.mm.booter.t;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.console.Shell;
import com.tencent.mm.e.a.gf;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class PusherProfile
  extends e
{
  public static final String fvW;
  private Shell fwM;
  
  static
  {
    GMTrace.i(13040997105664L, 97163);
    fvW = aa.getPackageName() + ":push";
    GMTrace.o(13040997105664L, 97163);
  }
  
  public PusherProfile()
  {
    GMTrace.i(13040460234752L, 97159);
    this.fwM = new Shell();
    GMTrace.o(13040460234752L, 97159);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    GMTrace.i(13040728670208L, 97161);
    GMTrace.o(13040728670208L, 97161);
  }
  
  public final void onCreate()
  {
    GMTrace.i(13040594452480L, 97160);
    Object localObject = aa.getContext();
    AppLogic.setCallBack(new AppCallBack(aa.getContext()));
    k.b(com.tencent.mm.sdk.a.uqb, PusherProfile.class.getClassLoader());
    SdtLogic.setHttpNetcheckCGI("/mmnetcheck");
    localObject = new t(com.tencent.mm.booter.c.ao((Context)localObject));
    ((t)localObject).cR("PUSH");
    r.ihQ = bf.b(((t)localObject).cS(".com.tencent.mm.debug.test.display_errcode"), false);
    r.ihR = bf.b(((t)localObject).cS(".com.tencent.mm.debug.test.display_msgstate"), false);
    r.ihS = bf.b(((t)localObject).cS(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    r.ihT = bf.b(((t)localObject).cS(".com.tencent.mm.debug.test.network.force_touch"), false);
    r.ihU = bf.b(((t)localObject).cS(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    r.ihV = bf.b(((t)localObject).cS(".com.tencent.mm.debug.test.crashIsExit"), false);
    r.ihZ = bf.b(((t)localObject).cS(".com.tencent.mm.debug.test.album_show_info"), false);
    r.iia = bf.b(((t)localObject).cS(".com.tencent.mm.debug.test.location_help"), false);
    r.iid = bf.b(((t)localObject).cS(".com.tencent.mm.debug.test.force_soso"), false);
    r.iie = bf.b(((t)localObject).cS(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    r.iif = bf.b(((t)localObject).cS(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    r.iig = bf.b(((t)localObject).cS(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    r.iij = bf.b(((t)localObject).cS(".com.tencent.mm.debug.test.filterfpnp"), false);
    r.iik = bf.b(((t)localObject).cS(".com.tencent.mm.debug.test.testForPull"), false);
    int i = bf.a(((t)localObject).getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    r.iih = i;
    if ((i != 4) && (r.iih > 0))
    {
      com.tencent.mm.storage.v.uxs = r.iih;
      v.e("MicroMsg.PushDebugger", "cdn thread num " + r.iih);
    }
    r.iii = bf.b(((t)localObject).cS(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    r.iin = bf.b(((t)localObject).cS(".com.tencent.mm.debug.test.skip_getdns"), false);
    try
    {
      i = Integer.decode(((t)localObject).getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.xR(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException5)
    {
      try
      {
        String str = ((t)localObject).getString(".com.tencent.mm.debug.log.setapilevel");
        if (!bf.mA(str))
        {
          com.tencent.mm.protocal.d.DEVICE_TYPE = "android-" + str;
          com.tencent.mm.protocal.d.sXc = "android-" + str;
          com.tencent.mm.protocal.d.sXe = str;
          b.Pa(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.DEVICE_TYPE).append(" ").append(b.bIl());
        }
      }
      catch (Exception localException5)
      {
        try
        {
          i = Integer.decode(((t)localObject).getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.sXg).append(" new: ").append(i);
          com.tencent.mm.protocal.d.sXg = i;
        }
        catch (Exception localException5)
        {
          try
          {
            i = Integer.decode(((t)localObject).getString(".com.tencent.mm.debug.log.setchannel")).intValue();
            ((q)localObject).gKs.gJB = i;
          }
          catch (Exception localException5)
          {
            try
            {
              for (;;)
              {
                boolean bool1 = bf.b(((t)localObject).cS(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean bool2 = bf.b(((t)localObject).cS(".com.tencent.mm.debug.report.kvstat"), false);
                boolean bool3 = bf.b(((t)localObject).cS(".com.tencent.mm.debug.report.clientpref"), false);
                boolean bool4 = bf.b(((t)localObject).cS(".com.tencent.mm.debug.report.useraction"), false);
                com.tencent.mm.plugin.report.a.c.a(bool1, bool2, bool3, bool4);
                new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
                a.be(fvW);
                o.onCreate(false);
                com.tencent.mm.bb.d.a("gcm", null, null);
                com.tencent.mm.bb.d.o("gcm", null);
                com.tencent.mm.sdk.b.a.uql.b(new com.tencent.mm.sdk.b.c() {});
                bf.et(aa.getContext());
                GMTrace.o(13040594452480L, 97160);
                return;
                localException2 = localException2;
                v.i("MicroMsg.PushDebugger", "no debugger was got");
                continue;
                localException3 = localException3;
                v.i("MicroMsg.PushDebugger", "no debugger was got");
                continue;
                localException4 = localException4;
                v.i("MicroMsg.PushDebugger", "no debugger was got");
                continue;
                localException5 = localException5;
                v.i("MicroMsg.PushDebugger", "no debugger was got");
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                v.i("MicroMsg.PushDebugger", "no debugger was got");
              }
            }
          }
        }
      }
    }
  }
  
  public final String toString()
  {
    GMTrace.i(13040862887936L, 97162);
    String str = fvW;
    GMTrace.o(13040862887936L, 97162);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/app/PusherProfile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */