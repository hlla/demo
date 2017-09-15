package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Configuration;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.booter.s;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class PatchProfile
  extends e
{
  public static final String fvW;
  
  static
  {
    GMTrace.i(12978585862144L, 96698);
    fvW = aa.getPackageName() + ":patch";
    GMTrace.o(12978585862144L, 96698);
  }
  
  public PatchProfile()
  {
    GMTrace.i(12978048991232L, 96694);
    GMTrace.o(12978048991232L, 96694);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    GMTrace.i(12978317426688L, 96696);
    GMTrace.o(12978317426688L, 96696);
  }
  
  public final void onCreate()
  {
    GMTrace.i(12978183208960L, 96695);
    long l = System.currentTimeMillis();
    s locals = new s(com.tencent.mm.booter.c.ao(this.app.getBaseContext()));
    locals.cR("PATCH");
    try
    {
      i = Integer.decode(locals.getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.xR(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException4)
    {
      try
      {
        String str = locals.getString(".com.tencent.mm.debug.log.setapilevel");
        if (!bf.mA(str))
        {
          com.tencent.mm.protocal.d.DEVICE_TYPE = "android-" + str;
          com.tencent.mm.protocal.d.sXc = "android-" + str;
          com.tencent.mm.protocal.d.sXe = str;
          b.Pa(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.DEVICE_TYPE).append(" ").append(b.bIl());
        }
      }
      catch (Exception localException4)
      {
        try
        {
          int i = Integer.decode(locals.getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.sXg).append(" new: ").append(i);
          com.tencent.mm.protocal.d.sXg = i;
        }
        catch (Exception localException4)
        {
          try
          {
            for (;;)
            {
              boolean bool1 = bf.b(locals.cS(".com.tencent.mm.debug.report.debugmodel"), false);
              boolean bool2 = bf.b(locals.cS(".com.tencent.mm.debug.report.kvstat"), false);
              boolean bool3 = bf.b(locals.cS(".com.tencent.mm.debug.report.clientpref"), false);
              boolean bool4 = bf.b(locals.cS(".com.tencent.mm.debug.report.useraction"), false);
              com.tencent.mm.plugin.report.a.c.a(bool1, bool2, bool3, bool4);
              new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
              com.tencent.mm.d.a.b(aa.getContext(), true);
              k.bi(fvW);
              com.tencent.mm.compatible.util.k.setupBrokenLibraryHandler();
              com.tencent.mm.compatible.util.k.b(com.tencent.mm.sdk.a.uqc, PatchProfile.class.getClassLoader());
              m.a(this.app);
              v.i("MicroMsg.PatchProfile", "patchsprofile try to init hotpatch plugin");
              com.tencent.mm.bb.d.a("hp", null, null);
              com.tencent.mm.bb.d.o("hp", null);
              v.i("MicroMsg.PatchProfile", "start time check patchsprofile use time = " + (System.currentTimeMillis() - l));
              GMTrace.o(12978183208960L, 96695);
              return;
              localException2 = localException2;
              v.i("MicroMsg.PatchDebugger", "no debugger was got");
              continue;
              localException3 = localException3;
              v.i("MicroMsg.PatchDebugger", "no debugger was got");
              continue;
              localException4 = localException4;
              v.i("MicroMsg.PatchDebugger", "no debugger was got");
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              v.i("MicroMsg.PatchDebugger", "no debugger was got");
            }
          }
        }
      }
    }
  }
  
  public final String toString()
  {
    GMTrace.i(12978451644416L, 96697);
    String str = fvW;
    GMTrace.o(12978451644416L, 96697);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/app/PatchProfile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */