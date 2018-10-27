package com.google.common.util.concurrent;

import com.google.common.base.x;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

public class c
  extends v
{
  public static final d a;
  public static final boolean b;
  public static final Object c;
  public static final Logger d;
  public volatile g listeners;
  public volatile Object value;
  public volatile n waiters;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 21
    //   4: ldc 23
    //   6: invokestatic 29	java/lang/System:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   9: invokestatic 35	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   12: putstatic 37	com/google/common/util/concurrent/c:b	Z
    //   15: ldc 2
    //   17: invokevirtual 43	java/lang/Class:getName	()Ljava/lang/String;
    //   20: invokestatic 49	java/util/logging/Logger:getLogger	(Ljava/lang/String;)Ljava/util/logging/Logger;
    //   23: putstatic 51	com/google/common/util/concurrent/c:d	Ljava/util/logging/Logger;
    //   26: new 53	com/google/common/util/concurrent/l
    //   29: dup
    //   30: invokespecial 56	com/google/common/util/concurrent/l:<init>	()V
    //   33: astore_0
    //   34: aconst_null
    //   35: astore_1
    //   36: aload_0
    //   37: putstatic 58	com/google/common/util/concurrent/c:a	Lcom/google/common/util/concurrent/d;
    //   40: aload_2
    //   41: ifnull +35 -> 76
    //   44: getstatic 51	com/google/common/util/concurrent/c:d	Ljava/util/logging/Logger;
    //   47: getstatic 64	java/util/logging/Level:SEVERE	Ljava/util/logging/Level;
    //   50: ldc 66
    //   52: ldc 67
    //   54: ldc 69
    //   56: aload_1
    //   57: invokevirtual 73	java/util/logging/Logger:logp	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   60: getstatic 51	com/google/common/util/concurrent/c:d	Ljava/util/logging/Logger;
    //   63: getstatic 64	java/util/logging/Level:SEVERE	Ljava/util/logging/Level;
    //   66: ldc 66
    //   68: ldc 67
    //   70: ldc 75
    //   72: aload_2
    //   73: invokevirtual 73	java/util/logging/Logger:logp	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   76: new 77	java/lang/Object
    //   79: dup
    //   80: invokespecial 78	java/lang/Object:<init>	()V
    //   83: putstatic 80	com/google/common/util/concurrent/c:c	Ljava/lang/Object;
    //   86: return
    //   87: astore_0
    //   88: new 82	com/google/common/util/concurrent/h
    //   91: dup
    //   92: ldc 84
    //   94: ldc 86
    //   96: ldc 88
    //   98: invokestatic 94	java/util/concurrent/atomic/AtomicReferenceFieldUpdater:newUpdater	(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;)Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;
    //   101: ldc 84
    //   103: ldc 84
    //   105: ldc 96
    //   107: invokestatic 94	java/util/concurrent/atomic/AtomicReferenceFieldUpdater:newUpdater	(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;)Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;
    //   110: ldc 2
    //   112: ldc 84
    //   114: ldc 97
    //   116: invokestatic 94	java/util/concurrent/atomic/AtomicReferenceFieldUpdater:newUpdater	(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;)Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;
    //   119: ldc 2
    //   121: ldc 99
    //   123: ldc 100
    //   125: invokestatic 94	java/util/concurrent/atomic/AtomicReferenceFieldUpdater:newUpdater	(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;)Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;
    //   128: ldc 2
    //   130: ldc 77
    //   132: ldc 101
    //   134: invokestatic 94	java/util/concurrent/atomic/AtomicReferenceFieldUpdater:newUpdater	(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;)Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;
    //   137: invokespecial 104	com/google/common/util/concurrent/h:<init>	(Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;)V
    //   140: astore_3
    //   141: aload_0
    //   142: astore_1
    //   143: aload_3
    //   144: astore_0
    //   145: goto -109 -> 36
    //   148: astore_2
    //   149: new 106	com/google/common/util/concurrent/j
    //   152: dup
    //   153: invokespecial 107	com/google/common/util/concurrent/j:<init>	()V
    //   156: astore_3
    //   157: aload_0
    //   158: astore_1
    //   159: aload_3
    //   160: astore_0
    //   161: goto -125 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   33	4	0	locall	l
    //   87	55	0	localObject1	Object
    //   144	17	0	localObject2	Object
    //   35	124	1	localObject3	Object
    //   1	72	2	localThrowable	Throwable
    //   148	1	2	localObject4	Object
    //   140	20	3	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   26	34	87	finally
    //   88	141	148	finally
  }
  
  private static Object a(Object paramObject)
  {
    if ((paramObject instanceof e))
    {
      paramObject = ((e)paramObject).c;
      localObject = new CancellationException("Task was cancelled.");
      ((CancellationException)localObject).initCause((Throwable)paramObject);
      throw ((Throwable)localObject);
    }
    if ((paramObject instanceof f)) {
      throw new ExecutionException(((f)paramObject).b);
    }
    Object localObject = paramObject;
    if (paramObject == c) {
      localObject = null;
    }
    return localObject;
  }
  
  static void a(c paramc)
  {
    Object localObject1 = null;
    c localc = paramc;
    paramc = (c)localObject1;
    do
    {
      localObject1 = localc.waiters;
    } while (!a.a(localc, (n)localObject1, n.a));
    Object localObject2;
    while (localObject1 != null)
    {
      localObject2 = ((n)localObject1).thread;
      if (localObject2 != null)
      {
        ((n)localObject1).thread = null;
        LockSupport.unpark((Thread)localObject2);
      }
      localObject1 = ((n)localObject1).next;
    }
    localc.b();
    do
    {
      localObject1 = localc.listeners;
    } while (!a.a(localc, (g)localObject1, g.a));
    localc = paramc;
    for (paramc = (c)localObject1; paramc != null; paramc = (c)localObject1)
    {
      localObject1 = paramc.next;
      paramc.next = localc;
      localc = paramc;
    }
    for (;;)
    {
      if (localc == null) {
        return;
      }
      paramc = localc.next;
      localObject1 = localc.c;
      if ((localObject1 instanceof i))
      {
        localObject1 = (i)localObject1;
        localc = ((i)localObject1).b;
        if (localc.value == localObject1)
        {
          localObject2 = b(((i)localObject1).a);
          if (a.a(localc, localObject1, localObject2)) {
            break;
          }
          localc = paramc;
          continue;
        }
        localc = paramc;
        continue;
      }
      b((Runnable)localObject1, localc.b);
      localc = paramc;
    }
  }
  
  private final void a(n paramn)
  {
    paramn.thread = null;
    Object localObject = this.waiters;
    if (localObject != n.a)
    {
      paramn = null;
      label19:
      if (localObject != null)
      {
        n localn = ((n)localObject).next;
        if (((n)localObject).thread != null) {
          paramn = (n)localObject;
        }
        for (;;)
        {
          localObject = localn;
          break label19;
          if (paramn == null)
          {
            if (!a.a(this, (n)localObject, localn)) {
              break;
            }
            continue;
          }
          paramn.next = localn;
          if (paramn.thread == null) {
            break;
          }
        }
      }
    }
  }
  
  private final void a(StringBuilder paramStringBuilder)
  {
    try
    {
      Object localObject = ad.a(this);
      paramStringBuilder.append("SUCCESS, result=[");
      paramStringBuilder.append(c(localObject));
      paramStringBuilder.append("]");
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      paramStringBuilder.append("FAILURE, cause=[");
      paramStringBuilder.append(localExecutionException.getCause());
      paramStringBuilder.append("]");
      return;
    }
    catch (CancellationException localCancellationException)
    {
      paramStringBuilder.append("CANCELLED");
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      paramStringBuilder.append("UNKNOWN, cause=[");
      paramStringBuilder.append(localRuntimeException.getClass());
      paramStringBuilder.append(" thrown from get()]");
    }
  }
  
  static Object b(al paramal)
  {
    Object localObject;
    if ((paramal instanceof k))
    {
      localObject = ((c)paramal).value;
      paramal = (al)localObject;
      if ((localObject instanceof e))
      {
        e locale = (e)localObject;
        paramal = (al)localObject;
        if (locale.d)
        {
          paramal = locale.c;
          if (paramal == null) {
            break label59;
          }
          paramal = new e(false, paramal);
        }
      }
      return paramal;
      label59:
      return e.a;
    }
    try
    {
      localObject = ad.a(paramal);
      paramal = (al)localObject;
      if (localObject == null) {
        paramal = c;
      }
    }
    catch (ExecutionException paramal)
    {
      for (;;)
      {
        paramal = new f(paramal.getCause());
      }
    }
    catch (CancellationException paramal)
    {
      for (;;)
      {
        paramal = new e(false, paramal);
      }
    }
    finally
    {
      for (;;)
      {
        paramal = new f(paramal);
      }
    }
    return paramal;
  }
  
  private static void b(Runnable paramRunnable, Executor paramExecutor)
  {
    try
    {
      paramExecutor.execute(paramRunnable);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Logger localLogger = d;
      Level localLevel = Level.SEVERE;
      paramRunnable = String.valueOf(paramRunnable);
      paramExecutor = String.valueOf(paramExecutor);
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramRunnable).length() + 57 + String.valueOf(paramExecutor).length());
      localStringBuilder.append("RuntimeException while executing runnable ");
      localStringBuilder.append(paramRunnable);
      localStringBuilder.append(" with executor ");
      localStringBuilder.append(paramExecutor);
      localLogger.logp(localLevel, "com.google.common.util.concurrent.AbstractFuture", "executeListener", localStringBuilder.toString(), localRuntimeException);
    }
  }
  
  private final String c(Object paramObject)
  {
    if (paramObject != this) {
      return String.valueOf(paramObject);
    }
    return "this future";
  }
  
  public String a()
  {
    Object localObject = this.value;
    if ((localObject instanceof i))
    {
      localObject = c(((i)localObject).a);
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject).length() + 12);
      localStringBuilder.append("setFuture=[");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    if ((this instanceof ScheduledFuture))
    {
      long l = ((ScheduledFuture)this).getDelay(TimeUnit.MILLISECONDS);
      localObject = new StringBuilder(41);
      ((StringBuilder)localObject).append("remaining delay=[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append(" ms]");
      return ((StringBuilder)localObject).toString();
    }
    return null;
  }
  
  public void a(Runnable paramRunnable, Executor paramExecutor)
  {
    x.a(paramRunnable, "Runnable was null.");
    x.a(paramExecutor, "Executor was null.");
    Object localObject = this.listeners;
    if (localObject != g.a)
    {
      g localg2 = new g(paramRunnable, paramExecutor);
      g localg1;
      do
      {
        localg2.next = ((g)localObject);
        if (a.a(this, (g)localObject, localg2)) {
          break;
        }
        localg1 = this.listeners;
        localObject = localg1;
      } while (localg1 != g.a);
    }
    b(paramRunnable, paramExecutor);
  }
  
  final void a(Future paramFuture)
  {
    if (paramFuture != null) {}
    for (int i = 1;; i = 0)
    {
      if ((i & isCancelled()) != 0) {
        paramFuture.cancel(d());
      }
      return;
    }
  }
  
  /* Error */
  protected final boolean a(al paramal)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 321	com/google/common/base/x:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_0
    //   6: getfield 177	com/google/common/util/concurrent/c:value	Ljava/lang/Object;
    //   9: astore_3
    //   10: aload_3
    //   11: astore_2
    //   12: aload_3
    //   13: ifnonnull +64 -> 77
    //   16: aload_1
    //   17: invokeinterface 326 1 0
    //   22: ifeq +28 -> 50
    //   25: aload_1
    //   26: invokestatic 183	com/google/common/util/concurrent/c:b	(Lcom/google/common/util/concurrent/al;)Ljava/lang/Object;
    //   29: astore_1
    //   30: getstatic 58	com/google/common/util/concurrent/c:a	Lcom/google/common/util/concurrent/d;
    //   33: aload_0
    //   34: aconst_null
    //   35: aload_1
    //   36: invokevirtual 186	com/google/common/util/concurrent/d:a	(Lcom/google/common/util/concurrent/c;Ljava/lang/Object;Ljava/lang/Object;)Z
    //   39: ifeq +9 -> 48
    //   42: aload_0
    //   43: invokestatic 328	com/google/common/util/concurrent/c:a	(Lcom/google/common/util/concurrent/c;)V
    //   46: iconst_1
    //   47: ireturn
    //   48: iconst_0
    //   49: ireturn
    //   50: new 172	com/google/common/util/concurrent/i
    //   53: dup
    //   54: aload_0
    //   55: aload_1
    //   56: invokespecial 331	com/google/common/util/concurrent/i:<init>	(Lcom/google/common/util/concurrent/c;Lcom/google/common/util/concurrent/al;)V
    //   59: astore_2
    //   60: getstatic 58	com/google/common/util/concurrent/c:a	Lcom/google/common/util/concurrent/d;
    //   63: aload_0
    //   64: aconst_null
    //   65: aload_2
    //   66: invokevirtual 186	com/google/common/util/concurrent/d:a	(Lcom/google/common/util/concurrent/c;Ljava/lang/Object;Ljava/lang/Object;)Z
    //   69: ifne +31 -> 100
    //   72: aload_0
    //   73: getfield 177	com/google/common/util/concurrent/c:value	Ljava/lang/Object;
    //   76: astore_2
    //   77: aload_2
    //   78: instanceof 112
    //   81: ifeq +17 -> 98
    //   84: aload_1
    //   85: aload_2
    //   86: checkcast 112	com/google/common/util/concurrent/e
    //   89: getfield 237	com/google/common/util/concurrent/e:d	Z
    //   92: invokeinterface 332 2 0
    //   97: pop
    //   98: iconst_0
    //   99: ireturn
    //   100: aload_1
    //   101: aload_2
    //   102: getstatic 337	com/google/common/util/concurrent/at:a	Lcom/google/common/util/concurrent/at;
    //   105: invokeinterface 339 3 0
    //   110: iconst_1
    //   111: ireturn
    //   112: astore_1
    //   113: new 128	com/google/common/util/concurrent/f
    //   116: dup
    //   117: aload_1
    //   118: invokespecial 244	com/google/common/util/concurrent/f:<init>	(Ljava/lang/Throwable;)V
    //   121: astore_1
    //   122: getstatic 58	com/google/common/util/concurrent/c:a	Lcom/google/common/util/concurrent/d;
    //   125: aload_0
    //   126: aload_2
    //   127: aload_1
    //   128: invokevirtual 186	com/google/common/util/concurrent/d:a	(Lcom/google/common/util/concurrent/c;Ljava/lang/Object;Ljava/lang/Object;)Z
    //   131: pop
    //   132: goto -22 -> 110
    //   135: astore_1
    //   136: getstatic 342	com/google/common/util/concurrent/f:a	Lcom/google/common/util/concurrent/f;
    //   139: astore_1
    //   140: goto -18 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	c
    //   0	143	1	paramal	al
    //   11	116	2	localObject1	Object
    //   9	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   100	110	112	finally
    //   113	122	135	finally
  }
  
  public boolean a(Throwable paramThrowable)
  {
    paramThrowable = new f((Throwable)x.a(paramThrowable));
    if (a.a(this, null, paramThrowable))
    {
      a(this);
      return true;
    }
    return false;
  }
  
  protected void b() {}
  
  public boolean b(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject == null) {
      localObject = c;
    }
    if (a.a(this, null, localObject))
    {
      a(this);
      return true;
    }
    return false;
  }
  
  public void c() {}
  
  public boolean cancel(boolean paramBoolean)
  {
    boolean bool2 = true;
    Object localObject1 = this.value;
    if (localObject1 == null) {}
    for (int i = 1;; i = 0)
    {
      if ((i | localObject1 instanceof i) != 0)
      {
        e locale;
        if (b) {
          locale = new e(paramBoolean, new CancellationException("Future.cancel() was called."));
        }
        for (;;)
        {
          boolean bool1 = false;
          c localc = this;
          while (!a.a(localc, localObject1, locale))
          {
            Object localObject2 = localc.value;
            localObject1 = localObject2;
            if (!(localObject2 instanceof i)) {
              label91:
              return bool1;
            }
          }
          if (!paramBoolean) {}
          for (;;)
          {
            a(localc);
            bool1 = bool2;
            if (!(localObject1 instanceof i)) {
              break label91;
            }
            localObject1 = ((i)localObject1).a;
            if ((localObject1 instanceof k))
            {
              localc = (c)localObject1;
              localObject1 = localc.value;
              if (localObject1 == null) {}
              for (i = 1;; i = 0)
              {
                bool1 = bool2;
                if ((i | localObject1 instanceof i) == 0) {
                  break label91;
                }
                bool1 = true;
                break;
              }
            }
            ((al)localObject1).cancel(paramBoolean);
            return true;
            localc.c();
          }
          if (!paramBoolean) {
            locale = e.a;
          } else {
            locale = e.b;
          }
        }
      }
      return false;
    }
  }
  
  protected final boolean d()
  {
    Object localObject = this.value;
    return ((localObject instanceof e)) && (((e)localObject).d);
  }
  
  public Object get()
  {
    if (Thread.interrupted()) {
      throw new InterruptedException();
    }
    Object localObject = this.value;
    if (localObject != null) {}
    for (int i = 1;; i = 0)
    {
      if ((i & (localObject instanceof i ^ true)) != 0) {
        return a(localObject);
      }
      localObject = this.waiters;
      if (localObject != n.a)
      {
        n localn2 = new n((byte)0);
        n localn1;
        do
        {
          localn2.a((n)localObject);
          if (a.a(this, (n)localObject, localn2)) {
            for (;;)
            {
              LockSupport.park(this);
              if (Thread.interrupted())
              {
                a(localn2);
                throw new InterruptedException();
              }
              localObject = this.value;
              if (localObject != null) {}
              for (i = 1; (i & (localObject instanceof i ^ true)) != 0; i = 0) {
                return a(localObject);
              }
            }
          }
          localn1 = this.waiters;
          localObject = localn1;
        } while (localn1 != n.a);
      }
      return a(this.value);
    }
  }
  
  public Object get(long paramLong, TimeUnit paramTimeUnit)
  {
    long l1 = paramTimeUnit.toNanos(paramLong);
    if (Thread.interrupted()) {
      throw new InterruptedException();
    }
    Object localObject1 = this.value;
    if (localObject1 != null) {}
    for (int i = 1;; i = 0)
    {
      if ((i & (localObject1 instanceof i ^ true)) == 0)
      {
        if (l1 > 0L) {}
        for (long l2 = System.nanoTime() + l1;; l2 = 0L)
        {
          if (l1 >= 1000L)
          {
            localObject1 = this.waiters;
            n localn;
            if (localObject1 != n.a)
            {
              localn = new n((byte)0);
              do
              {
                localn.a((n)localObject1);
                if (a.a(this, (n)localObject1, localn)) {
                  break;
                }
                localObject2 = this.waiters;
                localObject1 = localObject2;
              } while (localObject2 != n.a);
            }
            return a(this.value);
            long l3;
            do
            {
              LockSupport.parkNanos(this, l1);
              if (Thread.interrupted())
              {
                a(localn);
                throw new InterruptedException();
              }
              localObject1 = this.value;
              if (localObject1 == null) {
                break;
              }
              i = 1;
              if ((i & (localObject1 instanceof i ^ true)) != 0) {
                return a(localObject1);
              }
              l3 = l2 - System.nanoTime();
              l1 = l3;
            } while (l3 >= 1000L);
            a(localn);
            l1 = l3;
          }
          for (;;)
          {
            if (l1 <= 0L)
            {
              localObject1 = toString();
              if (!isDone()) {
                break label425;
              }
              paramTimeUnit = com.google.common.base.e.a(paramTimeUnit.toString());
              localObject1 = new StringBuilder(String.valueOf(paramTimeUnit).length() + 68);
              ((StringBuilder)localObject1).append("Waited ");
              ((StringBuilder)localObject1).append(paramLong);
              ((StringBuilder)localObject1).append(" ");
              ((StringBuilder)localObject1).append(paramTimeUnit);
              ((StringBuilder)localObject1).append(" but future completed as timeout expired");
              throw new TimeoutException(((StringBuilder)localObject1).toString());
            }
            localObject1 = this.value;
            if (localObject1 != null) {}
            for (i = 1;; i = 0)
            {
              if ((i & (localObject1 instanceof i ^ true)) != 0) {
                return a(localObject1);
              }
              if (Thread.interrupted()) {
                throw new InterruptedException();
              }
              l1 = l2 - System.nanoTime();
              break;
            }
            i = 0;
            break;
          }
        }
      }
      return a(localObject1);
    }
    label425:
    paramTimeUnit = com.google.common.base.e.a(paramTimeUnit.toString());
    Object localObject2 = new StringBuilder(String.valueOf(paramTimeUnit).length() + 33 + String.valueOf(localObject1).length());
    ((StringBuilder)localObject2).append("Waited ");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append(" ");
    ((StringBuilder)localObject2).append(paramTimeUnit);
    ((StringBuilder)localObject2).append(" for ");
    ((StringBuilder)localObject2).append((String)localObject1);
    throw new TimeoutException(((StringBuilder)localObject2).toString());
  }
  
  public boolean isCancelled()
  {
    return this.value instanceof e;
  }
  
  public boolean isDone()
  {
    Object localObject = this.value;
    if (localObject != null) {}
    for (int i = 1;; i = 0) {
      return i & (localObject instanceof i ^ true);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(super.toString());
    localStringBuilder1.append("[status=");
    if (isCancelled()) {
      localStringBuilder1.append("CANCELLED");
    }
    for (;;)
    {
      localStringBuilder1.append("]");
      return localStringBuilder1.toString();
      if (isDone())
      {
        a(localStringBuilder1);
        continue;
      }
      try
      {
        String str1 = a();
        if (!com.google.common.base.v.a(str1))
        {
          localStringBuilder1.append("PENDING, info=[");
          localStringBuilder1.append(str1);
          localStringBuilder1.append("]");
          continue;
        }
        if (!isDone())
        {
          localStringBuilder1.append("PENDING");
          continue;
        }
        a(localStringBuilder1);
      }
      catch (RuntimeException localRuntimeException)
      {
        for (;;)
        {
          String str2 = String.valueOf(localRuntimeException.getClass());
          StringBuilder localStringBuilder2 = new StringBuilder(String.valueOf(str2).length() + 38);
          localStringBuilder2.append("Exception thrown from implementation: ");
          localStringBuilder2.append(str2);
          str2 = localStringBuilder2.toString();
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/common/util/concurrent/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */