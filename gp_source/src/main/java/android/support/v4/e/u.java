package android.support.v4.e;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;

public final class u
{
  public final int a;
  public Handler b;
  public final Object c = new Object();
  public HandlerThread d;
  private Handler.Callback e = new v(this);
  private int f;
  private final int g;
  private final String h;
  
  public u(String paramString)
  {
    this.h = paramString;
    this.g = 10;
    this.a = 10000;
    this.f = 0;
  }
  
  /* Error */
  public final Object a(java.util.concurrent.Callable paramCallable, int paramInt)
  {
    // Byte code:
    //   0: new 46	java/util/concurrent/locks/ReentrantLock
    //   3: dup
    //   4: invokespecial 47	java/util/concurrent/locks/ReentrantLock:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: invokevirtual 51	java/util/concurrent/locks/ReentrantLock:newCondition	()Ljava/util/concurrent/locks/Condition;
    //   14: astore 8
    //   16: new 53	java/util/concurrent/atomic/AtomicReference
    //   19: dup
    //   20: invokespecial 54	java/util/concurrent/atomic/AtomicReference:<init>	()V
    //   23: astore 9
    //   25: new 56	java/util/concurrent/atomic/AtomicBoolean
    //   28: dup
    //   29: iconst_1
    //   30: invokespecial 59	java/util/concurrent/atomic/AtomicBoolean:<init>	(Z)V
    //   33: astore 10
    //   35: aload_0
    //   36: new 61	android/support/v4/e/y
    //   39: dup
    //   40: aload 9
    //   42: aload_1
    //   43: aload 7
    //   45: aload 10
    //   47: aload 8
    //   49: invokespecial 64	android/support/v4/e/y:<init>	(Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/Callable;Ljava/util/concurrent/locks/ReentrantLock;Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/util/concurrent/locks/Condition;)V
    //   52: invokevirtual 67	android/support/v4/e/u:a	(Ljava/lang/Runnable;)V
    //   55: aload 7
    //   57: invokevirtual 70	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   60: aload 10
    //   62: invokevirtual 74	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   65: ifeq +71 -> 136
    //   68: getstatic 80	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   71: iload_2
    //   72: i2l
    //   73: invokevirtual 84	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   76: lstore_3
    //   77: aload 8
    //   79: lload_3
    //   80: invokeinterface 89 3 0
    //   85: lstore 5
    //   87: aload 10
    //   89: invokevirtual 74	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   92: ifeq +31 -> 123
    //   95: lload 5
    //   97: lstore_3
    //   98: lload 5
    //   100: lconst_0
    //   101: lcmp
    //   102: ifgt -25 -> 77
    //   105: new 44	java/lang/InterruptedException
    //   108: dup
    //   109: ldc 91
    //   111: invokespecial 93	java/lang/InterruptedException:<init>	(Ljava/lang/String;)V
    //   114: athrow
    //   115: astore_1
    //   116: aload 7
    //   118: invokevirtual 96	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   121: aload_1
    //   122: athrow
    //   123: aload 9
    //   125: invokevirtual 99	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   128: astore_1
    //   129: aload 7
    //   131: invokevirtual 96	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   134: aload_1
    //   135: areturn
    //   136: aload 9
    //   138: invokevirtual 99	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   141: astore_1
    //   142: aload 7
    //   144: invokevirtual 96	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   147: aload_1
    //   148: areturn
    //   149: astore_1
    //   150: lload_3
    //   151: lstore 5
    //   153: goto -66 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	u
    //   0	156	1	paramCallable	java.util.concurrent.Callable
    //   0	156	2	paramInt	int
    //   76	75	3	l1	long
    //   85	67	5	l2	long
    //   7	136	7	localReentrantLock	java.util.concurrent.locks.ReentrantLock
    //   14	64	8	localCondition	java.util.concurrent.locks.Condition
    //   23	114	9	localAtomicReference	java.util.concurrent.atomic.AtomicReference
    //   33	55	10	localAtomicBoolean	java.util.concurrent.atomic.AtomicBoolean
    // Exception table:
    //   from	to	target	type
    //   60	77	115	finally
    //   77	87	115	finally
    //   87	95	115	finally
    //   105	115	115	finally
    //   123	129	115	finally
    //   136	142	115	finally
    //   77	87	149	java/lang/InterruptedException
  }
  
  final void a(Runnable paramRunnable)
  {
    synchronized (this.c)
    {
      if (this.d != null)
      {
        this.b.removeMessages(0);
        Handler localHandler = this.b;
        localHandler.sendMessage(localHandler.obtainMessage(1, paramRunnable));
        return;
      }
      this.d = new HandlerThread(this.h, this.g);
      this.d.start();
      this.b = new Handler(this.d.getLooper(), this.e);
      this.f += 1;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/e/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */