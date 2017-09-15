package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.booter.c;
import com.tencent.mm.booter.u;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class SandBoxProfile
  extends e
{
  public static final String fvW;
  
  static
  {
    GMTrace.i(12999255392256L, 96852);
    fvW = aa.getPackageName() + ":sandbox";
    GMTrace.o(12999255392256L, 96852);
  }
  
  public SandBoxProfile()
  {
    GMTrace.i(12998718521344L, 96848);
    GMTrace.o(12998718521344L, 96848);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    GMTrace.i(12998986956800L, 96850);
    GMTrace.o(12998986956800L, 96850);
  }
  
  public final void onCreate()
  {
    GMTrace.i(12998852739072L, 96849);
    Object localObject = c.ao(aa.getContext());
    k.setupBrokenLibraryHandler();
    k.b(a.uqc, SandBoxProfile.class.getClassLoader());
    k.b("MMProtocalJni", SandBoxProfile.class.getClassLoader());
    MMProtocalJni.setClientPackVersion(d.sXh);
    localObject = new u((c)localObject);
    try
    {
      ((u)localObject).cR("SANDBOX");
      r.iir = bf.b(((u)localObject).cS(".com.tencent.mm.debug.test.network.simulate_down_fault"), false);
      v.i("MicroMsg.SandboxDebugger", "Test.simulateDownFault = " + r.iir);
      m.a(this.app);
      GMTrace.o(12998852739072L, 96849);
      return;
    }
    catch (Error localError)
    {
      for (;;) {}
    }
  }
  
  public final String toString()
  {
    GMTrace.i(12999121174528L, 96851);
    String str = fvW;
    GMTrace.o(12999121174528L, 96851);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/app/SandBoxProfile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */