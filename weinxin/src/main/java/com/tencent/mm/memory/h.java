package com.tencent.mm.memory;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.b;
import com.tencent.mm.sdk.f.e;
import java.nio.ByteBuffer;

public final class h
  extends b<ByteBuffer>
{
  public static h hgx;
  
  static
  {
    GMTrace.i(1294664204288L, 9646);
    hgx = new h();
    e.post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(1285671616512L, 9579);
        int i = 0;
        while (i < 10)
        {
          h.a(h.hgx, ByteBuffer.allocate(16384));
          i += 1;
        }
        GMTrace.o(1285671616512L, 9579);
      }
    }, "DecodeTempStorage_preload");
    GMTrace.o(1294664204288L, 9646);
  }
  
  private h()
  {
    GMTrace.i(1294395768832L, 9644);
    GMTrace.o(1294395768832L, 9644);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/memory/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */