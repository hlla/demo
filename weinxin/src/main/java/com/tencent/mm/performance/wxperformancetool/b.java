package com.tencent.mm.performance.wxperformancetool;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.performance.d.a;
import java.util.HashSet;
import java.util.Iterator;

public final class b
  extends HandlerThread
{
  public static int igD;
  private c igC;
  public boolean igE;
  public Handler mHandler;
  
  static
  {
    GMTrace.i(13134144208896L, 97857);
    igD = 2500;
    GMTrace.o(13134144208896L, 97857);
  }
  
  public b(String paramString, c paramc)
  {
    super(paramString);
    GMTrace.i(13133741555712L, 97854);
    this.igE = false;
    this.igC = paramc;
    GMTrace.o(13133741555712L, 97854);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/performance/wxperformancetool/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */