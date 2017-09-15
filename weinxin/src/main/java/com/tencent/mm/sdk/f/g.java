package com.tencent.mm.sdk.f;

import android.os.Debug;
import com.tencent.gmtrace.GMTrace;
import junit.framework.Assert;

final class g
  implements Comparable<g>, Runnable
{
  private static final String hWu;
  private static int uwd;
  long hpd;
  final String mih;
  final int priority;
  boolean started;
  final Runnable urM;
  long urP;
  long urR;
  final boolean uwe;
  e.b uwf;
  
  static
  {
    GMTrace.i(13983205556224L, 104183);
    uwd = 1000;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("taskName = %s");
    localStringBuilder.append("|priority = %d");
    localStringBuilder.append("|pooled = %b");
    localStringBuilder.append("|addTime = %d");
    localStringBuilder.append("|usedTime = %d");
    localStringBuilder.append("|cpuTime = %d");
    localStringBuilder.append("|started = %b");
    hWu = localStringBuilder.toString();
    GMTrace.o(13983205556224L, 104183);
  }
  
  g(Runnable paramRunnable, String paramString, int paramInt, boolean paramBoolean, e.b paramb)
  {
    GMTrace.i(13982668685312L, 104179);
    this.started = false;
    Assert.assertNotNull("ThreadTask arg task is null!", paramRunnable);
    Assert.assertNotNull("ThreadTask arg name is null!", paramString);
    this.urM = paramRunnable;
    this.mih = paramString;
    this.priority = paramInt;
    this.uwe = paramBoolean;
    this.urP = System.currentTimeMillis();
    this.uwf = paramb;
    GMTrace.o(13982668685312L, 104179);
  }
  
  public final void run()
  {
    GMTrace.i(13982802903040L, 104180);
    this.hpd = System.currentTimeMillis();
    this.urR = Debug.threadCpuTimeNanos();
    this.started = true;
    this.urM.run();
    this.hpd = (System.currentTimeMillis() - this.hpd);
    this.urR = (Debug.threadCpuTimeNanos() - this.urR);
    GMTrace.o(13982802903040L, 104180);
  }
  
  public final String toString()
  {
    GMTrace.i(13982937120768L, 104181);
    String str = String.format(hWu, new Object[] { this.mih, Integer.valueOf(this.priority), Boolean.valueOf(this.uwe), Long.valueOf(this.urP), Long.valueOf(this.hpd), Long.valueOf(this.urR), Boolean.valueOf(this.started) });
    GMTrace.o(13982937120768L, 104181);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/f/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */