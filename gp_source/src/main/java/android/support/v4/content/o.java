package android.support.v4.content;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class o
{
  private static volatile Executor a;
  public static final Executor b;
  private static u h;
  private static final BlockingQueue i;
  private static final ThreadFactory j = new p();
  public final AtomicBoolean c = new AtomicBoolean();
  public final FutureTask d = new r(this, this.g);
  public volatile v e = v.b;
  public final AtomicBoolean f = new AtomicBoolean();
  public final w g = new q(this);
  
  static
  {
    i = new LinkedBlockingQueue(10);
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, i, j);
    b = localThreadPoolExecutor;
    a = localThreadPoolExecutor;
  }
  
  protected static void b() {}
  
  /* Error */
  private static Handler c()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 85	android/support/v4/content/o:h	Landroid/support/v4/content/u;
    //   6: ifnull +12 -> 18
    //   9: getstatic 85	android/support/v4/content/o:h	Landroid/support/v4/content/u;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: new 87	android/support/v4/content/u
    //   21: dup
    //   22: invokespecial 88	android/support/v4/content/u:<init>	()V
    //   25: putstatic 85	android/support/v4/content/o:h	Landroid/support/v4/content/u;
    //   28: goto -19 -> 9
    //   31: astore_0
    //   32: ldc 2
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	5	0	localu	u
    //   31	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	9	31	finally
    //   9	16	31	finally
    //   18	28	31	finally
    //   32	35	31	finally
  }
  
  protected abstract Object a();
  
  protected void a(Object paramObject) {}
  
  protected void b(Object paramObject) {}
  
  final void c(Object paramObject)
  {
    if (!this.f.get()) {
      d(paramObject);
    }
  }
  
  final Object d(Object paramObject)
  {
    c().obtainMessage(1, new t(this, new Object[] { paramObject })).sendToTarget();
    return paramObject;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/content/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */