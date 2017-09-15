package com.tencent.mm.ipcinvoker;

import android.content.Context;
import android.os.Process;
import com.tencent.gmtrace.GMTrace;
import junit.framework.Assert;

public final class d
{
  public static Context gVE;
  private static String gVF;
  
  public static boolean dS(String paramString)
  {
    GMTrace.i(18689684406272L, 139249);
    if ((paramString != null) && (paramString.equals(up())))
    {
      GMTrace.o(18689684406272L, 139249);
      return true;
    }
    GMTrace.o(18689684406272L, 139249);
    return false;
  }
  
  public static Context getContext()
  {
    GMTrace.i(18689550188544L, 139248);
    Assert.assertNotNull("IPCInvoker not initialize.", gVE);
    Context localContext = gVE;
    GMTrace.o(18689550188544L, 139248);
    return localContext;
  }
  
  public static String up()
  {
    GMTrace.i(18689818624000L, 139250);
    if ((gVF == null) || (gVF.length() == 0)) {
      gVF = com.tencent.mm.loader.stub.d.q(gVE, Process.myPid());
    }
    String str = gVF;
    GMTrace.o(18689818624000L, 139250);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ipcinvoker/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */