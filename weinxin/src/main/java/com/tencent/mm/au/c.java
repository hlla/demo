package com.tencent.mm.au;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.c.b.g.a;
import com.tencent.mm.c.c.d;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class c
  implements aq.a
{
  public BlockingQueue<g.a> hTv;
  public String mFileName;
  
  public c()
  {
    GMTrace.i(3498787733504L, 26068);
    this.mFileName = null;
    this.hTv = new ArrayBlockingQueue(1024);
    GMTrace.o(3498787733504L, 26068);
  }
  
  public final boolean Bn()
  {
    GMTrace.i(3498921951232L, 26069);
    v.d("MicroMsg.SpeexEncoderWorker", "doEncode");
    d locald = new d();
    String str = b.JK();
    try
    {
      v.i("MicroMsg.SpeexEncoderWorker", "path " + str);
      Object localObject = new File(str);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdir();
      }
      locald.bz(str + this.mFileName + ".temp");
      while (this.hTv.size() > 0)
      {
        localObject = (g.a)this.hTv.poll();
        if ((((g.a)localObject).buf != null) && (((g.a)localObject).fAB > 0))
        {
          locald.a((g.a)localObject, 0, false);
          continue;
          GMTrace.o(3498921951232L, 26069);
        }
      }
    }
    catch (Exception localException1)
    {
      v.e("MicroMsg.SpeexEncoderWorker", "filename open failed, ", new Object[] { localException1 });
    }
    for (;;)
    {
      return true;
      localException1.ps();
      try
      {
        new File(str + this.mFileName + ".temp").renameTo(new File(str + this.mFileName + ".spx"));
        e.JS().start();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          v.e("MicroMsg.SpeexEncoderWorker", "exception:%s", new Object[] { bf.g(localException2) });
        }
      }
    }
  }
  
  public final boolean Bo()
  {
    GMTrace.i(3499056168960L, 26070);
    GMTrace.o(3499056168960L, 26070);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/au/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */