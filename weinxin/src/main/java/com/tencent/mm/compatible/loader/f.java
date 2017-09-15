package com.tencent.mm.compatible.loader;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class f
{
  public f()
  {
    GMTrace.i(13792079511552L, 102759);
    GMTrace.o(13792079511552L, 102759);
  }
  
  public static e a(Application paramApplication, String paramString)
  {
    GMTrace.i(13792213729280L, 102760);
    try
    {
      paramString = (e)aa.getContext().getClassLoader().loadClass(aa.bIM() + paramString).newInstance();
      paramString.app = paramApplication;
      GMTrace.o(13792213729280L, 102760);
      return paramString;
    }
    catch (Exception paramApplication)
    {
      v.printErrStackTrace("MicroMsg.ProfileFactoryImpl", paramApplication, "", new Object[0]);
      GMTrace.o(13792213729280L, 102760);
    }
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/compatible/loader/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */