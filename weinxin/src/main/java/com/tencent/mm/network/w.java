package com.tencent.mm.network;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.ae;

public final class w
  extends n.a
{
  public w()
  {
    GMTrace.i(12960063815680L, 96560);
    GMTrace.o(12960063815680L, 96560);
  }
  
  public final void reportKV(final long paramLong, String paramString, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    GMTrace.i(12960198033408L, 96561);
    h.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(12959795380224L, 96558);
        if (paramBoolean1)
        {
          SmcLogic.writeImportKvData(paramLong, paramBoolean2, this.ieN);
          GMTrace.o(12959795380224L, 96558);
          return;
        }
        SmcLogic.writeKvData(paramLong, paramBoolean2, this.ieN);
        GMTrace.o(12959795380224L, 96558);
      }
      
      public final String toString()
      {
        GMTrace.i(12959929597952L, 96559);
        String str = super.toString() + "|reportKV";
        GMTrace.o(12959929597952L, 96559);
        return str;
      }
    });
    GMTrace.o(12960198033408L, 96561);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/network/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */