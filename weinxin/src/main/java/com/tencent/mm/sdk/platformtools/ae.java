package com.tencent.mm.sdk.platformtools;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.f.e;

public class ae
{
  private static ad urq;
  private ad lEQ;
  public HandlerThread nIe;
  private String urr;
  
  static
  {
    GMTrace.i(13875965591552L, 103384);
    urq = null;
    GMTrace.o(13875965591552L, 103384);
  }
  
  public ae()
  {
    GMTrace.i(13873818107904L, 103368);
    this.nIe = null;
    this.lEQ = null;
    this.urr = null;
    v.i("MicroMsg.MMHandlerThread", "init stack:%s", new Object[] { bf.bJP() });
    Pv(null);
    GMTrace.o(13873818107904L, 103368);
  }
  
  public ae(String paramString)
  {
    GMTrace.i(13873952325632L, 103369);
    this.nIe = null;
    this.lEQ = null;
    this.urr = null;
    Pv(paramString);
    GMTrace.o(13873952325632L, 103369);
  }
  
  public static void I(Runnable paramRunnable)
  {
    GMTrace.i(13875428720640L, 103380);
    if (paramRunnable == null)
    {
      GMTrace.o(13875428720640L, 103380);
      return;
    }
    bJc().removeCallbacks(paramRunnable);
    GMTrace.o(13875428720640L, 103380);
  }
  
  public static void J(Runnable paramRunnable)
  {
    GMTrace.i(16090289668096L, 119882);
    bJc().postAtFrontOfQueueV2(paramRunnable);
    GMTrace.o(16090289668096L, 119882);
  }
  
  private static ad bJc()
  {
    GMTrace.i(13875026067456L, 103377);
    if (urq == null) {
      urq = new ad(Looper.getMainLooper());
    }
    ad localad = urq;
    GMTrace.o(13875026067456L, 103377);
    return localad;
  }
  
  public static void f(Runnable paramRunnable, long paramLong)
  {
    GMTrace.i(13875294502912L, 103379);
    if (paramRunnable == null)
    {
      GMTrace.o(13875294502912L, 103379);
      return;
    }
    bJc().postDelayed(paramRunnable, paramLong);
    GMTrace.o(13875294502912L, 103379);
  }
  
  public static boolean isMainThread()
  {
    GMTrace.i(13874891849728L, 103376);
    if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId())
    {
      GMTrace.o(13874891849728L, 103376);
      return true;
    }
    GMTrace.o(13874891849728L, 103376);
    return false;
  }
  
  public static void v(Runnable paramRunnable)
  {
    GMTrace.i(13875160285184L, 103378);
    if (paramRunnable == null)
    {
      GMTrace.o(13875160285184L, 103378);
      return;
    }
    bJc().post(paramRunnable);
    GMTrace.o(13875160285184L, 103378);
  }
  
  public static void yq(int paramInt)
  {
    GMTrace.i(13873147019264L, 103363);
    try
    {
      Process.setThreadPriority(paramInt);
      v.i("MicroMsg.MMHandlerThread", "setCurrentPriority to %d ok", new Object[] { Integer.valueOf(paramInt) });
      GMTrace.o(13873147019264L, 103363);
      return;
    }
    catch (Exception localException)
    {
      v.i("MicroMsg.MMHandlerThread", "setCurrentPriority to %d fail, %s", new Object[] { Integer.valueOf(paramInt), localException.getMessage() });
      v.printErrStackTrace("MicroMsg.MMHandlerThread", localException, "", new Object[0]);
      GMTrace.o(13873147019264L, 103363);
    }
  }
  
  public int D(Runnable paramRunnable)
  {
    GMTrace.i(13874354978816L, 103372);
    if (paramRunnable == null)
    {
      GMTrace.o(13874354978816L, 103372);
      return -1;
    }
    bJb().post(paramRunnable);
    GMTrace.o(13874354978816L, 103372);
    return 0;
  }
  
  public final int H(Runnable paramRunnable)
  {
    GMTrace.i(13874489196544L, 103373);
    bJb().postAtFrontOfQueueV2(paramRunnable);
    GMTrace.o(13874489196544L, 103373);
    return 0;
  }
  
  public final void Pv(String paramString)
  {
    GMTrace.i(13873012801536L, 103362);
    this.lEQ = null;
    String str = paramString;
    if (bf.mA(paramString)) {
      str = "MMHandlerThread";
    }
    this.urr = str;
    this.nIe = e.cE(this.urr, 0);
    this.nIe.start();
    GMTrace.o(13873012801536L, 103362);
  }
  
  public final int a(final a parama)
  {
    GMTrace.i(13874757632000L, 103375);
    if (new ad(this.nIe.getLooper()).postAtFrontOfQueueV2(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(13867778310144L, 103323);
        parama.Bn();
        ae.J(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(13935424045056L, 103827);
            ae.2.this.urw.Bo();
            GMTrace.o(13935424045056L, 103827);
          }
        });
        GMTrace.o(13867778310144L, 103323);
      }
      
      public final String toString()
      {
        GMTrace.i(13867912527872L, 103324);
        String str = super.toString() + "|" + parama.toString();
        GMTrace.o(13867912527872L, 103324);
        return str;
      }
    }))
    {
      GMTrace.o(13874757632000L, 103375);
      return 0;
    }
    GMTrace.o(13874757632000L, 103375);
    return -2;
  }
  
  /* Error */
  public final int a(final b paramb)
  {
    // Byte code:
    //   0: ldc2_w 218
    //   3: ldc -36
    //   5: invokestatic 34	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   8: ldc 54
    //   10: ldc -34
    //   12: iconst_2
    //   13: anewarray 4	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: invokestatic 128	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   21: invokevirtual 132	java/lang/Thread:getId	()J
    //   24: invokestatic 227	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: invokestatic 62	com/tencent/mm/sdk/platformtools/bf:bJP	()Lcom/tencent/mm/sdk/platformtools/ag;
    //   33: aastore
    //   34: invokestatic 67	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   37: ldc -27
    //   39: invokestatic 231	com/tencent/mm/sdk/platformtools/ae:isMainThread	()Z
    //   42: invokestatic 237	junit/framework/Assert:assertTrue	(Ljava/lang/String;Z)V
    //   45: aload_0
    //   46: getfield 48	com/tencent/mm/sdk/platformtools/ae:nIe	Landroid/os/HandlerThread;
    //   49: invokevirtual 238	android/os/HandlerThread:getId	()J
    //   52: lstore_3
    //   53: iconst_0
    //   54: newarray <illegal type>
    //   56: astore 7
    //   58: new 6	com/tencent/mm/sdk/platformtools/ae$1
    //   61: dup
    //   62: aload_0
    //   63: aload_1
    //   64: aload_0
    //   65: getfield 52	com/tencent/mm/sdk/platformtools/ae:urr	Ljava/lang/String;
    //   68: aload 7
    //   70: invokespecial 241	com/tencent/mm/sdk/platformtools/ae$1:<init>	(Lcom/tencent/mm/sdk/platformtools/ae;Lcom/tencent/mm/sdk/platformtools/ae$b;Ljava/lang/String;Ljava/lang/Object;)V
    //   73: astore_1
    //   74: aload 7
    //   76: monitorenter
    //   77: aload_0
    //   78: aload_1
    //   79: invokevirtual 243	com/tencent/mm/sdk/platformtools/ae:a	(Lcom/tencent/mm/sdk/platformtools/ae$a;)I
    //   82: istore_2
    //   83: aload_0
    //   84: getfield 48	com/tencent/mm/sdk/platformtools/ae:nIe	Landroid/os/HandlerThread;
    //   87: invokevirtual 238	android/os/HandlerThread:getId	()J
    //   90: lstore 5
    //   92: ldc 54
    //   94: ldc -11
    //   96: iconst_3
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: iload_2
    //   103: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   106: aastore
    //   107: dup
    //   108: iconst_1
    //   109: lload_3
    //   110: invokestatic 227	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   113: aastore
    //   114: dup
    //   115: iconst_2
    //   116: lload 5
    //   118: invokestatic 227	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   121: aastore
    //   122: invokestatic 67	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   125: iload_2
    //   126: ifne +15 -> 141
    //   129: lload_3
    //   130: lload 5
    //   132: lcmp
    //   133: ifne +8 -> 141
    //   136: aload 7
    //   138: invokevirtual 248	java/lang/Object:wait	()V
    //   141: aload 7
    //   143: monitorexit
    //   144: ldc2_w 218
    //   147: ldc -36
    //   149: invokestatic 39	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   152: iload_2
    //   153: ireturn
    //   154: astore_1
    //   155: ldc 54
    //   157: ldc -6
    //   159: iconst_1
    //   160: anewarray 4	java/lang/Object
    //   163: dup
    //   164: iconst_0
    //   165: aload_1
    //   166: invokevirtual 168	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   169: aastore
    //   170: invokestatic 253	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   173: goto -32 -> 141
    //   176: astore_1
    //   177: aload 7
    //   179: monitorexit
    //   180: aload_1
    //   181: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	ae
    //   0	182	1	paramb	b
    //   82	71	2	i	int
    //   52	78	3	l1	long
    //   90	41	5	l2	long
    //   56	122	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   136	141	154	java/lang/Exception
    //   77	125	176	finally
    //   136	141	176	finally
    //   141	144	176	finally
    //   155	173	176	finally
    //   177	180	176	finally
  }
  
  public final void bIX()
  {
    GMTrace.i(13873281236992L, 103364);
    if ((this.nIe == null) || (!this.nIe.isAlive()))
    {
      v.e("MicroMsg.MMHandlerThread", "setLowestPriority failed thread is dead");
      GMTrace.o(13873281236992L, 103364);
      return;
    }
    int i = this.nIe.getThreadId();
    try
    {
      if (19 == Process.getThreadPriority(i))
      {
        v.w("MicroMsg.MMHandlerThread", "setLowestPriority No Need.");
        GMTrace.o(13873281236992L, 103364);
        return;
      }
      Process.setThreadPriority(i, 19);
      v.i("MicroMsg.MMHandlerThread", "thread:%d setLowestPriority to %d", new Object[] { Integer.valueOf(i), Integer.valueOf(Process.getThreadPriority(i)) });
      GMTrace.o(13873281236992L, 103364);
      return;
    }
    catch (Exception localException)
    {
      v.w("MicroMsg.MMHandlerThread", "thread:%d setLowestPriority failed", new Object[] { Integer.valueOf(i) });
      v.printErrStackTrace("MicroMsg.MMHandlerThread", localException, "", new Object[0]);
      GMTrace.o(13873281236992L, 103364);
    }
  }
  
  public final void bIY()
  {
    GMTrace.i(13873415454720L, 103365);
    if ((this.nIe == null) || (!this.nIe.isAlive()))
    {
      v.e("MicroMsg.MMHandlerThread", "setHighPriority failed thread is dead");
      GMTrace.o(13873415454720L, 103365);
      return;
    }
    int i = this.nIe.getThreadId();
    try
    {
      if (-8 == Process.getThreadPriority(i))
      {
        v.w("MicroMsg.MMHandlerThread", "setHighPriority No Need.");
        GMTrace.o(13873415454720L, 103365);
        return;
      }
      Process.setThreadPriority(i, -8);
      v.i("MicroMsg.MMHandlerThread", "thread:%d setHighPriority to %d", new Object[] { Integer.valueOf(i), Integer.valueOf(Process.getThreadPriority(i)) });
      GMTrace.o(13873415454720L, 103365);
      return;
    }
    catch (Exception localException)
    {
      v.w("MicroMsg.MMHandlerThread", "thread:%d setHighPriority failed", new Object[] { Integer.valueOf(i) });
      v.printErrStackTrace("MicroMsg.MMHandlerThread", localException, "", new Object[0]);
      GMTrace.o(13873415454720L, 103365);
    }
  }
  
  public final boolean bIZ()
  {
    GMTrace.i(13873549672448L, 103366);
    if ((this.nIe == null) || (!this.nIe.isAlive()))
    {
      v.e("MicroMsg.MMHandlerThread", "check inHighPriority failed thread is dead");
      GMTrace.o(13873549672448L, 103366);
      return false;
    }
    int i = this.nIe.getThreadId();
    try
    {
      int j = Process.getThreadPriority(i);
      if (-8 == j)
      {
        GMTrace.o(13873549672448L, 103366);
        return true;
      }
    }
    catch (Exception localException)
    {
      v.w("MicroMsg.MMHandlerThread", "thread:%d  check inHighPriority failed", new Object[] { Integer.valueOf(i) });
      v.printErrStackTrace("MicroMsg.MMHandlerThread", localException, "", new Object[0]);
      GMTrace.o(13873549672448L, 103366);
    }
    return false;
  }
  
  public final void bJa()
  {
    GMTrace.i(13873683890176L, 103367);
    if ((this.nIe == null) || (!this.nIe.isAlive()))
    {
      v.e("MicroMsg.MMHandlerThread", "setLowPriority failed thread is dead");
      GMTrace.o(13873683890176L, 103367);
      return;
    }
    int i = this.nIe.getThreadId();
    try
    {
      if (Process.getThreadPriority(i) == 0)
      {
        v.w("MicroMsg.MMHandlerThread", "setLowPriority No Need.");
        GMTrace.o(13873683890176L, 103367);
        return;
      }
      Process.setThreadPriority(i, 0);
      v.i("MicroMsg.MMHandlerThread", "thread:%d setLowPriority to %d", new Object[] { Integer.valueOf(i), Integer.valueOf(Process.getThreadPriority(i)) });
      GMTrace.o(13873683890176L, 103367);
      return;
    }
    catch (Exception localException)
    {
      v.w("MicroMsg.MMHandlerThread", "thread:%d setLowPriority failed", new Object[] { Integer.valueOf(i) });
      v.printErrStackTrace("MicroMsg.MMHandlerThread", localException, "", new Object[0]);
      GMTrace.o(13873683890176L, 103367);
    }
  }
  
  public final ad bJb()
  {
    GMTrace.i(13874086543360L, 103370);
    if (this.lEQ == null) {
      this.lEQ = new ad(this.nIe.getLooper());
    }
    ad localad = this.lEQ;
    GMTrace.o(13874086543360L, 103370);
    return localad;
  }
  
  public final int e(Runnable paramRunnable, long paramLong)
  {
    GMTrace.i(13874623414272L, 103374);
    if (paramRunnable == null)
    {
      GMTrace.o(13874623414272L, 103374);
      return -1;
    }
    bJb().postDelayed(paramRunnable, paramLong);
    GMTrace.o(13874623414272L, 103374);
    return 0;
  }
  
  public static abstract interface a
  {
    public abstract boolean Bn();
    
    public abstract boolean Bo();
  }
  
  public static abstract interface b
  {
    public abstract void vM();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/platformtools/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */