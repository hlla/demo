package android.support.v4.e;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

final class y
  implements Runnable
{
  y(AtomicReference paramAtomicReference, Callable paramCallable, ReentrantLock paramReentrantLock, AtomicBoolean paramAtomicBoolean, Condition paramCondition) {}
  
  public final void run()
  {
    try
    {
      this.c.set(this.a.call());
      this.d.lock();
      try
      {
        this.e.set(false);
        this.b.signal();
        return;
      }
      finally
      {
        this.d.unlock();
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/e/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */