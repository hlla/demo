package com.tencent.mm.sdk.platformtools;

import android.os.Process;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.a.a;
import com.tencent.recovery.crash.DefaultExceptionHandler;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class ah
  implements Thread.UncaughtExceptionHandler
{
  private static ah urB;
  private d urC;
  private a urD;
  public a urE;
  public Map<String, b> urF;
  private Thread.UncaughtExceptionHandler urG;
  private boolean urH;
  private List<c> urI;
  
  static
  {
    GMTrace.i(14004948828160L, 104345);
    urB = null;
    GMTrace.o(14004948828160L, 104345);
  }
  
  private ah()
  {
    GMTrace.i(14004411957248L, 104341);
    this.urC = null;
    this.urD = null;
    this.urE = null;
    this.urF = new HashMap();
    this.urG = null;
    this.urH = false;
    this.urI = new LinkedList();
    this.urG = Thread.getDefaultUncaughtExceptionHandler();
    Thread.setDefaultUncaughtExceptionHandler(new DefaultExceptionHandler(this));
    GMTrace.o(14004411957248L, 104341);
  }
  
  private static String Pw(String paramString)
  {
    GMTrace.i(14004546174976L, 104342);
    if (paramString == null)
    {
      GMTrace.o(14004546174976L, 104342);
      return null;
    }
    char[] arrayOfChar = paramString.toCharArray();
    if (arrayOfChar == null)
    {
      GMTrace.o(14004546174976L, 104342);
      return null;
    }
    int i = 0;
    if (i < arrayOfChar.length) {
      if (arrayOfChar[i] > '') {
        arrayOfChar[i] = '\000';
      }
    }
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        paramString = new String(arrayOfChar, 0, i);
        GMTrace.o(14004546174976L, 104342);
        return paramString;
        i += 1;
        break;
      }
      GMTrace.o(14004546174976L, 104342);
      return paramString;
    }
  }
  
  public static void a(a parama)
  {
    try
    {
      GMTrace.i(14003740868608L, 104336);
      if (urB == null) {
        urB = new ah();
      }
      urB.urD = parama;
      GMTrace.o(14003740868608L, 104336);
      return;
    }
    finally {}
  }
  
  public static void a(a parama)
  {
    try
    {
      GMTrace.i(14003875086336L, 104337);
      if (urB == null) {
        urB = new ah();
      }
      urB.urE = parama;
      GMTrace.o(14003875086336L, 104337);
      return;
    }
    finally {}
  }
  
  /* Error */
  public static void a(c paramc)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc2_w 120
    //   6: ldc 122
    //   8: invokestatic 49	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   11: aload_0
    //   12: ifnonnull +15 -> 27
    //   15: ldc2_w 120
    //   18: ldc 122
    //   20: invokestatic 54	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   23: ldc 2
    //   25: monitorexit
    //   26: return
    //   27: getstatic 51	com/tencent/mm/sdk/platformtools/ah:urB	Lcom/tencent/mm/sdk/platformtools/ah;
    //   30: ifnonnull +13 -> 43
    //   33: new 2	com/tencent/mm/sdk/platformtools/ah
    //   36: dup
    //   37: invokespecial 114	com/tencent/mm/sdk/platformtools/ah:<init>	()V
    //   40: putstatic 51	com/tencent/mm/sdk/platformtools/ah:urB	Lcom/tencent/mm/sdk/platformtools/ah;
    //   43: getstatic 51	com/tencent/mm/sdk/platformtools/ah:urB	Lcom/tencent/mm/sdk/platformtools/ah;
    //   46: getfield 81	com/tencent/mm/sdk/platformtools/ah:urI	Ljava/util/List;
    //   49: aload_0
    //   50: invokeinterface 128 2 0
    //   55: pop
    //   56: ldc2_w 120
    //   59: ldc 122
    //   61: invokestatic 54	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   64: goto -41 -> 23
    //   67: astore_0
    //   68: ldc 2
    //   70: monitorexit
    //   71: aload_0
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	paramc	c
    // Exception table:
    //   from	to	target	type
    //   3	11	67	finally
    //   15	23	67	finally
    //   27	43	67	finally
    //   43	64	67	finally
  }
  
  public static void a(d paramd)
  {
    try
    {
      GMTrace.i(14003606650880L, 104335);
      if (urB == null) {
        urB = new ah();
      }
      urB.urC = paramd;
      GMTrace.o(14003606650880L, 104335);
      return;
    }
    finally {}
  }
  
  public static void a(String paramString, b paramb)
  {
    try
    {
      GMTrace.i(14004009304064L, 104338);
      if (urB == null) {
        urB = new ah();
      }
      urB.urF.put(paramString, paramb);
      GMTrace.o(14004009304064L, 104338);
      return;
    }
    finally {}
  }
  
  /* Error */
  public static String h(Throwable paramThrowable)
  {
    // Byte code:
    //   0: ldc2_w 147
    //   3: ldc -107
    //   5: invokestatic 49	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   8: new 151	java/io/ByteArrayOutputStream
    //   11: dup
    //   12: invokespecial 152	java/io/ByteArrayOutputStream:<init>	()V
    //   15: astore_1
    //   16: new 154	java/io/PrintStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 157	java/io/PrintStream:<init>	(Ljava/io/OutputStream;)V
    //   24: astore_2
    //   25: aload_0
    //   26: invokevirtual 163	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   29: ifnull +11 -> 40
    //   32: aload_0
    //   33: invokevirtual 163	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   36: astore_0
    //   37: goto -12 -> 25
    //   40: aload_0
    //   41: aload_2
    //   42: invokevirtual 167	java/lang/Throwable:printStackTrace	(Ljava/io/PrintStream;)V
    //   45: aload_1
    //   46: invokevirtual 171	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   49: invokestatic 173	com/tencent/mm/sdk/platformtools/ah:Pw	(Ljava/lang/String;)Ljava/lang/String;
    //   52: astore_0
    //   53: aload_1
    //   54: invokevirtual 176	java/io/ByteArrayOutputStream:close	()V
    //   57: ldc2_w 147
    //   60: ldc -107
    //   62: invokestatic 54	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   65: aload_0
    //   66: areturn
    //   67: astore_0
    //   68: aload_1
    //   69: invokevirtual 176	java/io/ByteArrayOutputStream:close	()V
    //   72: aload_0
    //   73: athrow
    //   74: astore_1
    //   75: goto -18 -> 57
    //   78: astore_1
    //   79: goto -7 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramThrowable	Throwable
    //   15	54	1	localByteArrayOutputStream	ByteArrayOutputStream
    //   74	1	1	localIOException1	java.io.IOException
    //   78	1	1	localIOException2	java.io.IOException
    //   24	18	2	localPrintStream	PrintStream
    // Exception table:
    //   from	to	target	type
    //   25	37	67	finally
    //   40	53	67	finally
    //   53	57	74	java/io/IOException
    //   68	72	78	java/io/IOException
  }
  
  public static void q(String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      GMTrace.i(14004143521792L, 104339);
      a(paramString1, new b()
      {
        public final String AF()
        {
          GMTrace.i(13994479845376L, 104267);
          String str = "subinfo=" + this.urJ;
          GMTrace.o(13994479845376L, 104267);
          return str;
        }
      });
      Assert.assertTrue(paramString1, paramBoolean);
      GMTrace.o(14004143521792L, 104339);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    GMTrace.i(14004814610432L, 104344);
    if (this.urH)
    {
      GMTrace.o(14004814610432L, 104344);
      return;
    }
    this.urH = true;
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      Object localObject = new PrintStream(localByteArrayOutputStream);
      for (paramThread = paramThrowable; paramThread.getCause() != null; paramThread = paramThread.getCause()) {}
      paramThread.printStackTrace((PrintStream)localObject);
      paramThread = Pw(localByteArrayOutputStream.toString());
      if ((this.urD != null) && (paramThread != null)) {
        this.urD.ed(paramThread);
      }
      if ((this.urC != null) && (paramThread != null))
      {
        this.urC.a(this, paramThread, paramThrowable);
        this.urE.oi();
      }
      paramThread = this.urI.iterator();
      while (paramThread.hasNext())
      {
        localObject = (c)paramThread.next();
        if (localObject != null) {
          try
          {
            ((c)localObject).b(paramThrowable);
          }
          catch (Exception localException) {}
        }
      }
      localByteArrayOutputStream.close();
      v.appenderClose();
    }
    catch (Exception paramThread)
    {
      for (;;) {}
    }
    Process.killProcess(Process.myPid());
    System.exit(0);
    GMTrace.o(14004814610432L, 104344);
  }
  
  public static abstract interface a
  {
    public abstract void oi();
  }
  
  public static abstract interface b
  {
    public abstract String AF();
  }
  
  public static abstract interface c
  {
    public abstract void b(Throwable paramThrowable);
  }
  
  public static abstract interface d
  {
    public abstract void a(ah paramah, String paramString, Throwable paramThrowable);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/platformtools/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */