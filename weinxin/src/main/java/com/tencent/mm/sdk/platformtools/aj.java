package com.tencent.mm.sdk.platformtools;

import android.os.Debug;
import android.os.Handler;
import android.os.Process;
import com.tencent.gmtrace.GMTrace;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class aj
  implements Runnable
{
  private static final String urV;
  private static final String urW;
  long endTime;
  final Handler handler;
  long hpd;
  long lOO;
  final String mih;
  int priority;
  boolean started;
  final Thread thread;
  final Runnable urM;
  final Object urN;
  final a urO;
  long urP;
  long urQ;
  long urR;
  long urS;
  long urT;
  float urU;
  String urr;
  
  static
  {
    GMTrace.i(13914217644032L, 103669);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("taskName = %s");
    localStringBuilder.append("|token = %s");
    localStringBuilder.append("|handler = %s");
    localStringBuilder.append("|threadName = %s");
    localStringBuilder.append("|threadId = %d");
    localStringBuilder.append("|priority = %d");
    localStringBuilder.append("|addTime = %d");
    localStringBuilder.append("|delayTime = %d");
    localStringBuilder.append("|usedTime = %d");
    localStringBuilder.append("|cpuTime = %d");
    localStringBuilder.append("|started = %b");
    urV = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("taskName = %s");
    localStringBuilder.append(" | addTime = %s");
    localStringBuilder.append(" | endTime = %s");
    localStringBuilder.append(" | usedTime = %d");
    localStringBuilder.append(" | cpuTime = %d");
    localStringBuilder.append(" | threadCpuTime = %d");
    localStringBuilder.append(" | totalCpuTime = %d");
    localStringBuilder.append(" | threadCpuRate = %.1f");
    urW = localStringBuilder.toString();
    GMTrace.o(13914217644032L, 103669);
  }
  
  aj(Thread paramThread, Handler paramHandler, Runnable paramRunnable, Object paramObject, a parama)
  {
    GMTrace.i(13913814990848L, 103666);
    this.started = false;
    this.urU = -1.0F;
    this.thread = paramThread;
    if (paramThread != null)
    {
      this.urr = paramThread.getName();
      this.lOO = paramThread.getId();
      this.priority = paramThread.getPriority();
    }
    this.handler = paramHandler;
    this.urM = paramRunnable;
    paramHandler = paramRunnable.getClass().getName();
    paramRunnable = paramRunnable.toString();
    paramThread = paramHandler;
    if (!bf.mA(paramRunnable))
    {
      int i = paramRunnable.indexOf('|');
      paramThread = paramHandler;
      if (i > 0) {
        paramThread = paramHandler + "_" + paramRunnable.substring(i + 1);
      }
    }
    this.mih = paramThread;
    this.urN = paramObject;
    this.urO = parama;
    this.urP = System.currentTimeMillis();
    GMTrace.o(13913814990848L, 103666);
  }
  
  public final String dump(boolean paramBoolean)
  {
    GMTrace.i(13914083426304L, 103668);
    if (paramBoolean)
    {
      str = String.format(urV, new Object[] { this.mih, this.urN, this.handler, this.urr, Long.valueOf(this.lOO), Integer.valueOf(this.priority), Long.valueOf(this.urP), Long.valueOf(this.urQ), Long.valueOf(this.hpd), Long.valueOf(this.urR), Boolean.valueOf(this.started) });
      GMTrace.o(13914083426304L, 103668);
      return str;
    }
    String str = String.format(urW, new Object[] { this.mih, new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.urP)), new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.endTime)), Long.valueOf(this.hpd), Long.valueOf(this.urR), Long.valueOf(this.urS), Long.valueOf(this.urT), Float.valueOf(this.urU) });
    GMTrace.o(13914083426304L, 103668);
    return str;
  }
  
  public final void run()
  {
    GMTrace.i(13913949208576L, 103667);
    int i = Process.myTid();
    new StringBuilder("/proc/self/task/").append(i).append("/stat");
    this.hpd = System.currentTimeMillis();
    this.urR = Debug.threadCpuTimeNanos();
    this.urS = -1L;
    this.urT = -1L;
    this.started = true;
    this.urM.run();
    this.urS = (-1L - this.urS);
    this.urT = (-1L - this.urT);
    this.endTime = System.currentTimeMillis();
    this.hpd = (this.endTime - this.hpd);
    this.urR = ((Debug.threadCpuTimeNanos() - this.urR) / 1000000L);
    if (this.urT != 0L) {
      this.urU = ((float)(100L * this.urS) / (float)this.urT);
    }
    if (this.urO != null)
    {
      this.urO.a(this.urM, this);
      this.urO.a(this, this.thread, this.hpd, this.urR, this.urU);
    }
    GMTrace.o(13913949208576L, 103667);
  }
  
  public static abstract interface a
  {
    public abstract void a(Runnable paramRunnable, aj paramaj);
    
    public abstract void a(Runnable paramRunnable, Thread paramThread, long paramLong1, long paramLong2, float paramFloat);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/platformtools/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */