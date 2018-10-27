package android.a.a.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class d
  extends e
{
  private ExecutorService a = Executors.newFixedThreadPool(2);
  private final Object b = new Object();
  private volatile Handler c;
  
  public final void a(Runnable paramRunnable)
  {
    this.a.execute(paramRunnable);
  }
  
  public final void b(Runnable paramRunnable)
  {
    if (this.c == null) {}
    synchronized (this.b)
    {
      if (this.c == null) {
        this.c = new Handler(Looper.getMainLooper());
      }
      this.c.post(paramRunnable);
      return;
    }
  }
  
  public final boolean b()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/a/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */