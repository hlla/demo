package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import android.os.Message;
import com.tencent.gmtrace.GMTrace;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class aq
{
  public boolean fRe;
  public Object lock;
  public String name;
  public int priority;
  public LinkedBlockingQueue<a> utg;
  private int uth;
  public Vector<b> uti;
  public ad utj;
  
  public aq(int paramInt, String paramString)
  {
    this(paramInt, paramString, 1);
    GMTrace.i(13928578940928L, 103776);
    GMTrace.o(13928578940928L, 103776);
  }
  
  public aq(int paramInt1, String paramString, int paramInt2)
  {
    this(paramInt1, paramString, paramInt2, Looper.myLooper());
    GMTrace.i(13928713158656L, 103777);
    GMTrace.o(13928713158656L, 103777);
  }
  
  public aq(int paramInt1, String paramString, int paramInt2, Looper paramLooper)
  {
    GMTrace.i(13928847376384L, 103778);
    this.utg = new LinkedBlockingQueue();
    this.fRe = false;
    this.uth = 1;
    this.priority = 1;
    this.name = "";
    this.lock = new byte[0];
    this.uti = new Vector();
    this.uth = paramInt2;
    this.name = paramString;
    this.priority = paramInt1;
    paramString = paramLooper;
    if (paramLooper == null)
    {
      paramString = paramLooper;
      if (Looper.getMainLooper() != null)
      {
        paramString = Looper.getMainLooper();
        v.i("QueueWorkerThread.QueueWorkerThread", "looper is null use MainLooper!");
      }
    }
    this.utj = new ad(paramString)
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(13880394776576L, 103417);
        if ((paramAnonymousMessage != null) && (paramAnonymousMessage.obj != null)) {
          ((aq.a)paramAnonymousMessage.obj).Bo();
        }
        GMTrace.o(13880394776576L, 103417);
      }
    };
    GMTrace.o(13928847376384L, 103778);
  }
  
  @Deprecated
  public final boolean bJn()
  {
    GMTrace.i(13929115811840L, 103780);
    if ((this.uti == null) || (this.uti.size() == 0))
    {
      GMTrace.o(13929115811840L, 103780);
      return true;
    }
    GMTrace.o(13929115811840L, 103780);
    return false;
  }
  
  public final int c(a parama)
  {
    GMTrace.i(13928981594112L, 103779);
    if (parama == null)
    {
      v.e("QueueWorkerThread.QueueWorkerThread", "add empty thread object");
      GMTrace.o(13928981594112L, 103779);
      return -1;
    }
    try
    {
      if (!this.utg.offer(parama, 1L, TimeUnit.MILLISECONDS))
      {
        v.e("QueueWorkerThread.QueueWorkerThread", "add To Queue failed");
        GMTrace.o(13928981594112L, 103779);
        return -2;
      }
    }
    catch (Exception parama)
    {
      v.e("QueueWorkerThread.QueueWorkerThread", "add To Queue failed :" + parama.getMessage());
      v.printErrStackTrace("QueueWorkerThread.QueueWorkerThread", parama, "", new Object[0]);
      GMTrace.o(13928981594112L, 103779);
      return -3;
    }
    if ((this.uti.size() == 0) || ((this.utg.size() > 0) && (this.uth > this.uti.size()))) {
      new b((byte)0).start();
    }
    GMTrace.o(13928981594112L, 103779);
    return 0;
  }
  
  public final void jR(boolean paramBoolean)
  {
    GMTrace.i(13929250029568L, 103781);
    synchronized (this.lock)
    {
      this.fRe = paramBoolean;
      if (!paramBoolean) {}
      synchronized (this.lock)
      {
        this.lock.notifyAll();
        GMTrace.o(13929250029568L, 103781);
        return;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean Bn();
    
    public abstract boolean Bo();
  }
  
  final class b
    extends Thread
  {
    private int rZe;
    
    private b()
    {
      super();
      GMTrace.i(13869120487424L, 103333);
      this.rZe = 60;
      setPriority(aq.this.priority);
      aq.this.uti.add(this);
      GMTrace.o(13869120487424L, 103333);
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc2_w 65
      //   3: ldc 67
      //   5: invokestatic 31	com/tencent/gmtrace/GMTrace:i	(JI)V
      //   8: aload_0
      //   9: getfield 33	com/tencent/mm/sdk/platformtools/aq$b:rZe	I
      //   12: ifle +152 -> 164
      //   15: aload_0
      //   16: getfield 15	com/tencent/mm/sdk/platformtools/aq$b:utk	Lcom/tencent/mm/sdk/platformtools/aq;
      //   19: getfield 71	com/tencent/mm/sdk/platformtools/aq:lock	Ljava/lang/Object;
      //   22: astore_1
      //   23: aload_1
      //   24: monitorenter
      //   25: aload_0
      //   26: getfield 15	com/tencent/mm/sdk/platformtools/aq$b:utk	Lcom/tencent/mm/sdk/platformtools/aq;
      //   29: getfield 75	com/tencent/mm/sdk/platformtools/aq:fRe	Z
      //   32: ifeq +13 -> 45
      //   35: aload_0
      //   36: getfield 15	com/tencent/mm/sdk/platformtools/aq$b:utk	Lcom/tencent/mm/sdk/platformtools/aq;
      //   39: getfield 71	com/tencent/mm/sdk/platformtools/aq:lock	Ljava/lang/Object;
      //   42: invokevirtual 80	java/lang/Object:wait	()V
      //   45: aload_1
      //   46: monitorexit
      //   47: aload_0
      //   48: getfield 15	com/tencent/mm/sdk/platformtools/aq$b:utk	Lcom/tencent/mm/sdk/platformtools/aq;
      //   51: getfield 84	com/tencent/mm/sdk/platformtools/aq:utg	Ljava/util/concurrent/LinkedBlockingQueue;
      //   54: ldc2_w 85
      //   57: getstatic 92	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
      //   60: invokevirtual 98	java/util/concurrent/LinkedBlockingQueue:poll	(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
      //   63: checkcast 100	com/tencent/mm/sdk/platformtools/aq$a
      //   66: astore_1
      //   67: aload_1
      //   68: ifnonnull +55 -> 123
      //   71: aload_0
      //   72: aload_0
      //   73: getfield 33	com/tencent/mm/sdk/platformtools/aq$b:rZe	I
      //   76: iconst_1
      //   77: isub
      //   78: putfield 33	com/tencent/mm/sdk/platformtools/aq$b:rZe	I
      //   81: goto -73 -> 8
      //   84: astore_2
      //   85: ldc 102
      //   87: aload_2
      //   88: ldc 104
      //   90: iconst_0
      //   91: anewarray 77	java/lang/Object
      //   94: invokestatic 110	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   97: goto -52 -> 45
      //   100: astore_2
      //   101: aload_1
      //   102: monitorexit
      //   103: aload_2
      //   104: athrow
      //   105: astore_1
      //   106: ldc 102
      //   108: aload_1
      //   109: ldc 104
      //   111: iconst_0
      //   112: anewarray 77	java/lang/Object
      //   115: invokestatic 110	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   118: aconst_null
      //   119: astore_1
      //   120: goto -53 -> 67
      //   123: aload_0
      //   124: bipush 60
      //   126: putfield 33	com/tencent/mm/sdk/platformtools/aq$b:rZe	I
      //   129: aload_1
      //   130: invokeinterface 114 1 0
      //   135: ifeq -127 -> 8
      //   138: aload_0
      //   139: getfield 15	com/tencent/mm/sdk/platformtools/aq$b:utk	Lcom/tencent/mm/sdk/platformtools/aq;
      //   142: getfield 118	com/tencent/mm/sdk/platformtools/aq:utj	Lcom/tencent/mm/sdk/platformtools/ad;
      //   145: aload_0
      //   146: getfield 15	com/tencent/mm/sdk/platformtools/aq$b:utk	Lcom/tencent/mm/sdk/platformtools/aq;
      //   149: getfield 118	com/tencent/mm/sdk/platformtools/aq:utj	Lcom/tencent/mm/sdk/platformtools/ad;
      //   152: iconst_0
      //   153: aload_1
      //   154: invokevirtual 124	com/tencent/mm/sdk/platformtools/ad:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
      //   157: invokevirtual 128	com/tencent/mm/sdk/platformtools/ad:sendMessage	(Landroid/os/Message;)Z
      //   160: pop
      //   161: goto -153 -> 8
      //   164: aload_0
      //   165: getfield 15	com/tencent/mm/sdk/platformtools/aq$b:utk	Lcom/tencent/mm/sdk/platformtools/aq;
      //   168: getfield 44	com/tencent/mm/sdk/platformtools/aq:uti	Ljava/util/Vector;
      //   171: aload_0
      //   172: invokevirtual 131	java/util/Vector:remove	(Ljava/lang/Object;)Z
      //   175: pop
      //   176: ldc 102
      //   178: new 133	java/lang/StringBuilder
      //   181: dup
      //   182: ldc -121
      //   184: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   187: aload_0
      //   188: getfield 15	com/tencent/mm/sdk/platformtools/aq$b:utk	Lcom/tencent/mm/sdk/platformtools/aq;
      //   191: getfield 84	com/tencent/mm/sdk/platformtools/aq:utg	Ljava/util/concurrent/LinkedBlockingQueue;
      //   194: invokevirtual 140	java/util/concurrent/LinkedBlockingQueue:size	()I
      //   197: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   200: ldc -110
      //   202: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   205: aload_0
      //   206: getfield 15	com/tencent/mm/sdk/platformtools/aq$b:utk	Lcom/tencent/mm/sdk/platformtools/aq;
      //   209: getfield 44	com/tencent/mm/sdk/platformtools/aq:uti	Ljava/util/Vector;
      //   212: invokevirtual 150	java/util/Vector:size	()I
      //   215: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   218: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   221: invokestatic 158	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   224: ldc2_w 65
      //   227: ldc 67
      //   229: invokestatic 53	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   232: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	233	0	this	b
      //   22	80	1	localObject1	Object
      //   105	4	1	localException1	Exception
      //   119	35	1	localObject2	Object
      //   84	4	2	localException2	Exception
      //   100	4	2	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   25	45	84	java/lang/Exception
      //   25	45	100	finally
      //   45	47	100	finally
      //   85	97	100	finally
      //   101	103	100	finally
      //   47	67	105	java/lang/Exception
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/platformtools/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */