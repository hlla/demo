package android.support.v4.content;

import android.os.SystemClock;
import android.support.v4.os.OperationCanceledException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

final class b
  extends o
  implements Runnable
{
  public boolean a;
  private final CountDownLatch h = new CountDownLatch(1);
  
  b(a parama) {}
  
  private final Object c()
  {
    try
    {
      Object localObject = this.i.d();
      return localObject;
    }
    catch (OperationCanceledException localOperationCanceledException)
    {
      if (this.c.get()) {
        return null;
      }
      throw localOperationCanceledException;
    }
  }
  
  protected final void a(Object paramObject)
  {
    for (;;)
    {
      try
      {
        a locala = this.i;
        if (locala.b == this)
        {
          if (locala.e)
          {
            locala.a(paramObject);
            return;
          }
          locala.j = false;
          SystemClock.uptimeMillis();
          locala.b = null;
          locala.b(paramObject);
          continue;
        }
        locala.a(this, paramObject);
      }
      finally
      {
        this.h.countDown();
      }
    }
  }
  
  protected final void b(Object paramObject)
  {
    try
    {
      this.i.a(this, paramObject);
      return;
    }
    finally
    {
      this.h.countDown();
    }
  }
  
  public final void run()
  {
    this.a = false;
    this.i.c();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/content/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */