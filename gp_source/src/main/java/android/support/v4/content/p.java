package android.support.v4.content;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class p
  implements ThreadFactory
{
  private final AtomicInteger a = new AtomicInteger(1);
  
  public final Thread newThread(Runnable paramRunnable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ModernAsyncTask #");
    localStringBuilder.append(this.a.getAndIncrement());
    return new Thread(paramRunnable, localStringBuilder.toString());
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/content/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */