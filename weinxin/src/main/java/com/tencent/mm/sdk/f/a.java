package com.tencent.mm.sdk.f;

import android.os.HandlerThread;
import com.tencent.gmtrace.GMTrace;
import java.util.concurrent.atomic.AtomicInteger;
import junit.framework.Assert;

public final class a
{
  private ThreadGroup hHV;
  private final AtomicInteger uvI;
  private e.b uvJ;
  
  a(e.b paramb)
  {
    GMTrace.i(13982131814400L, 104175);
    this.uvI = new AtomicInteger(1);
    this.uvJ = paramb;
    this.hHV = new ThreadGroup("MM_FREE_THREAD_GROUP");
    GMTrace.o(13982131814400L, 104175);
  }
  
  final HandlerThread cD(String paramString, int paramInt)
  {
    GMTrace.i(13982266032128L, 104176);
    Assert.assertNotNull("newThread arg name is null!", paramString);
    paramString = new a("MM_Thread_Pool_Free_Handler_Thread#" + this.uvI.getAndIncrement() + "#" + paramString, paramInt);
    GMTrace.o(13982266032128L, 104176);
    return paramString;
  }
  
  static final class a
    extends HandlerThread
  {
    a(String paramString, int paramInt)
    {
      super(paramInt);
      GMTrace.i(13981192290304L, 104168);
      GMTrace.o(13981192290304L, 104168);
    }
    
    public final void run()
    {
      GMTrace.i(13981460725760L, 104170);
      super.run();
      GMTrace.o(13981460725760L, 104170);
    }
    
    public final void start()
    {
      GMTrace.i(13981326508032L, 104169);
      super.start();
      GMTrace.o(13981326508032L, 104169);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */