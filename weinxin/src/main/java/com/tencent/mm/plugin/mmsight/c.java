package com.tencent.mm.plugin.mmsight;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import java.util.concurrent.ConcurrentSkipListSet;

public final class c
{
  private static ConcurrentSkipListSet<Integer> nyK;
  
  static
  {
    GMTrace.i(18676396851200L, 139150);
    nyK = new ConcurrentSkipListSet();
    GMTrace.o(18676396851200L, 139150);
  }
  
  public static void ps(int paramInt)
  {
    try
    {
      GMTrace.i(18675994198016L, 139147);
      try
      {
        v.i("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxing: %s", new Object[] { Integer.valueOf(paramInt) });
        nyK.add(Integer.valueOf(paramInt));
        GMTrace.o(18675994198016L, 139147);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          v.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxing error: %s", new Object[] { localException.getMessage() });
          GMTrace.o(18675994198016L, 139147);
        }
      }
      return;
    }
    finally {}
  }
  
  public static void pt(int paramInt)
  {
    try
    {
      GMTrace.i(18676128415744L, 139148);
      try
      {
        v.i("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxingFinish: %s", new Object[] { Integer.valueOf(paramInt) });
        nyK.remove(Integer.valueOf(paramInt));
        GMTrace.o(18676128415744L, 139148);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          v.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxingFinish error: %s", new Object[] { localException.getMessage() });
          GMTrace.o(18676128415744L, 139148);
        }
      }
      return;
    }
    finally {}
  }
  
  public static boolean pu(int paramInt)
  {
    try
    {
      GMTrace.i(18676262633472L, 139149);
      try
      {
        bool = nyK.contains(Integer.valueOf(paramInt));
        v.d("MicroMsg.MMSightCaptureVideoRemuxStatus", "isMsgRemuxing: %s, %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
        GMTrace.o(18676262633472L, 139149);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          v.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "isMsgRemuxing error: %s", new Object[] { localException.getMessage() });
          GMTrace.o(18676262633472L, 139149);
          boolean bool = false;
        }
      }
      return bool;
    }
    finally {}
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/mmsight/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */