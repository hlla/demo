package com.tencent.mm.sandbox;

import android.os.Process;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private static c unY;
  private static Map<Integer, Boolean> unZ;
  
  static
  {
    GMTrace.i(3558783057920L, 26515);
    unY = null;
    unZ = new HashMap();
    GMTrace.o(3558783057920L, 26515);
  }
  
  public static void f(int paramInt, Object paramObject)
  {
    GMTrace.i(3558514622464L, 26513);
    v.i("MicroMsg.SandBoxCore", "regLifeCycle, id=" + paramInt + ", class=%s", new Object[] { paramObject.getClass().getName() });
    unZ.put(Integer.valueOf(paramInt), Boolean.valueOf(true));
    v.i("MicroMsg.SandBoxCore", "regLifeCycle, map size=" + unZ.size());
    GMTrace.o(3558514622464L, 26513);
  }
  
  public static void g(int paramInt, Object paramObject)
  {
    GMTrace.i(3558648840192L, 26514);
    v.i("MicroMsg.SandBoxCore", "unregLifeCycle, id=" + paramInt + ", class=%s", new Object[] { paramObject.getClass().getName() });
    unZ.remove(Integer.valueOf(paramInt));
    v.i("MicroMsg.SandBoxCore", "unregLifeCycle, map size=" + unZ.size());
    if (unZ.size() == 0)
    {
      Process.killProcess(Process.myPid());
      v.w("MicroMsg.SandBoxCore", "Sandbox exit Now.");
      v.bIG();
    }
    GMTrace.o(3558648840192L, 26514);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sandbox/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */