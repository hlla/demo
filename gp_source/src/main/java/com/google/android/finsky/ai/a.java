package com.google.android.finsky.ai;

import android.content.Context;
import android.util.Log;
import com.google.android.finsky.accounts.c;
import com.google.android.finsky.ag.d;
import com.google.android.finsky.cg.g;
import com.google.android.finsky.e.aa;
import com.google.android.finsky.scheduler.ap;
import com.google.android.finsky.utils.i;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;

public final class a
  implements Thread.UncaughtExceptionHandler
{
  public c a;
  public final Context b;
  public String c;
  public String d;
  public int e;
  public Boolean f;
  public Thread.UncaughtExceptionHandler g;
  public final ap h;
  public long i;
  public aa j;
  private final com.google.android.finsky.i.a k;
  private final File l;
  private long m;
  private volatile boolean n;
  
  public a(Context paramContext, com.google.android.finsky.i.a parama, g paramg, ap paramap)
  {
    ((b)com.google.android.finsky.dt.b.a(b.class)).a(this);
    this.b = paramContext;
    this.k = parama;
    this.h = paramap;
    this.l = new File(paramContext.getCacheDir(), String.format(Locale.US, "crash%d", new Object[] { Integer.valueOf(81121400) }));
    boolean bool1;
    for (;;)
    {
      try
      {
        if (!this.l.exists()) {
          break label429;
        }
        parama = new DataInputStream(new FileInputStream(this.l));
        try
        {
          this.e = parama.readInt();
          this.m = parama.readLong();
          bool1 = parama.readBoolean();
          this.c = parama.readUTF();
          this.d = parama.readUTF();
          this.i = -1L;
          if (parama.available() <= 0) {
            break;
          }
          paramContext = parama.readUTF();
          switch (paramContext.hashCode())
          {
          case -47067292: 
            a("Unknown key in crash file");
            paramContext = String.valueOf(paramContext);
            if (paramContext.length() != 0) {
              break label436;
            }
            paramContext = new String("No such key: ");
            label212:
            throw new IOException(paramContext);
          }
        }
        finally
        {
          parama.close();
        }
        i1 = this.e;
      }
      catch (Exception paramContext)
      {
        a("Failed to read crash file", paramContext);
        a();
        a(this.l);
      }
      label248:
      if (i1 > 0) {
        a(i1, this.m, true, null, this.f, this.i);
      }
      return;
      this.i = parama.readLong();
      continue;
      this.f = Boolean.valueOf(parama.readBoolean());
      continue;
      if (!paramContext.equals("last_id")) {
        break label475;
      }
      i1 = 1;
      break label449;
      boolean bool2 = paramContext.equals("is_fg");
      if (bool2)
      {
        i1 = 0;
        break label449;
      }
      i1 = -1;
      break label449;
    }
    parama.close();
    a("Read crash info");
    int i1 = this.e;
    int i2 = ((Integer)d.fh.b()).intValue();
    if ((this.m > 0L) && (i.a() - this.m > ((Long)d.aY.b()).longValue())) {}
    for (;;)
    {
      a("Crash info expired");
      a();
      a(this.l);
      break label248;
      label429:
      a();
      break label248;
      label436:
      paramContext = "No such key: ".concat(paramContext);
      break label212;
      label449:
      label475:
      for (i1 = -1;; i1 = -1)
      {
        switch (i1)
        {
        }
        break;
      }
      if (!bool1) {
        if (i1 <= i2) {
          break label248;
        }
      }
    }
  }
  
  private final void a()
  {
    this.e = 0;
    this.m = 0L;
    this.i = -1L;
  }
  
  /* Error */
  private final void a(int paramInt, long paramLong1, boolean paramBoolean, Throwable paramThrowable, Boolean paramBoolean1, long paramLong2)
  {
    // Byte code:
    //   0: new 221	java/io/DataOutputStream
    //   3: dup
    //   4: new 223	java/io/FileOutputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 89	com/google/android/finsky/ai/a:l	Ljava/io/File;
    //   12: invokespecial 224	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   15: invokespecial 227	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore 11
    //   20: aload 11
    //   22: iload_1
    //   23: invokevirtual 231	java/io/DataOutputStream:writeInt	(I)V
    //   26: aload 11
    //   28: lload_2
    //   29: invokevirtual 235	java/io/DataOutputStream:writeLong	(J)V
    //   32: aload 11
    //   34: iload 4
    //   36: invokevirtual 239	java/io/DataOutputStream:writeBoolean	(Z)V
    //   39: ldc -15
    //   41: astore 10
    //   43: ldc -15
    //   45: astore 9
    //   47: aload 5
    //   49: ifnull +70 -> 119
    //   52: aload 5
    //   54: invokevirtual 245	java/lang/Object:getClass	()Ljava/lang/Class;
    //   57: invokevirtual 250	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   60: astore 10
    //   62: new 252	java/io/StringWriter
    //   65: dup
    //   66: invokespecial 253	java/io/StringWriter:<init>	()V
    //   69: astore 9
    //   71: aload 5
    //   73: new 255	java/io/PrintWriter
    //   76: dup
    //   77: aload 9
    //   79: invokespecial 258	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   82: invokestatic 263	com/google/e/a/a/a/a/a:a	(Ljava/lang/Throwable;Ljava/io/PrintWriter;)V
    //   85: aload 9
    //   87: invokevirtual 267	java/io/StringWriter:getBuffer	()Ljava/lang/StringBuffer;
    //   90: iconst_0
    //   91: aload 9
    //   93: invokevirtual 267	java/io/StringWriter:getBuffer	()Ljava/lang/StringBuffer;
    //   96: invokevirtual 270	java/lang/StringBuffer:length	()I
    //   99: getstatic 273	com/google/android/finsky/ag/d:aZ	Lcom/google/android/play/utils/b/a;
    //   102: invokevirtual 197	com/google/android/play/utils/b/a:b	()Ljava/lang/Object;
    //   105: checkcast 74	java/lang/Integer
    //   108: invokevirtual 200	java/lang/Integer:intValue	()I
    //   111: invokestatic 279	java/lang/Math:min	(II)I
    //   114: invokevirtual 283	java/lang/StringBuffer:substring	(II)Ljava/lang/String;
    //   117: astore 9
    //   119: aload 11
    //   121: aload 10
    //   123: invokevirtual 286	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   126: aload 11
    //   128: aload 9
    //   130: invokevirtual 286	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   133: aload 11
    //   135: ldc -78
    //   137: invokevirtual 286	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   140: aload 11
    //   142: lload 7
    //   144: invokevirtual 235	java/io/DataOutputStream:writeLong	(J)V
    //   147: aload 6
    //   149: ifnull +20 -> 169
    //   152: aload 11
    //   154: ldc -72
    //   156: invokevirtual 286	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   159: aload 11
    //   161: aload 6
    //   163: invokevirtual 289	java/lang/Boolean:booleanValue	()Z
    //   166: invokevirtual 239	java/io/DataOutputStream:writeBoolean	(Z)V
    //   169: aload 11
    //   171: invokevirtual 290	java/io/DataOutputStream:close	()V
    //   174: return
    //   175: astore 5
    //   177: aload_0
    //   178: ldc_w 292
    //   181: aload 5
    //   183: invokevirtual 162	com/google/android/finsky/ai/a:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   186: return
    //   187: astore 5
    //   189: aload 5
    //   191: athrow
    //   192: astore 6
    //   194: aload 11
    //   196: invokevirtual 290	java/io/DataOutputStream:close	()V
    //   199: aload 6
    //   201: athrow
    //   202: astore 9
    //   204: aload 5
    //   206: aload 9
    //   208: invokestatic 295	com/google/e/a/a/a/a/a:a	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   211: goto -12 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	a
    //   0	214	1	paramInt	int
    //   0	214	2	paramLong1	long
    //   0	214	4	paramBoolean	boolean
    //   0	214	5	paramThrowable	Throwable
    //   0	214	6	paramBoolean1	Boolean
    //   0	214	7	paramLong2	long
    //   45	84	9	localObject	Object
    //   202	5	9	localThrowable	Throwable
    //   41	81	10	str	String
    //   18	177	11	localDataOutputStream	java.io.DataOutputStream
    // Exception table:
    //   from	to	target	type
    //   0	20	175	java/lang/Exception
    //   169	174	175	java/lang/Exception
    //   199	202	175	java/lang/Exception
    //   204	211	175	java/lang/Exception
    //   20	39	187	finally
    //   52	119	187	finally
    //   119	147	187	finally
    //   152	169	187	finally
    //   189	192	192	finally
    //   194	199	202	finally
  }
  
  public final void a(File paramFile)
  {
    try
    {
      if (!paramFile.isDirectory()) {}
      StringBuilder localStringBuilder;
      while (!paramFile.delete())
      {
        Object localObject = String.valueOf(paramFile);
        localStringBuilder = new StringBuilder(String.valueOf(localObject).length() + 23);
        localStringBuilder.append("Failed to delete file: ");
        localStringBuilder.append((String)localObject);
        a(localStringBuilder.toString());
        return;
        localObject = paramFile.listFiles();
        if (localObject != null)
        {
          int i2 = localObject.length;
          int i1 = 0;
          while (i1 < i2)
          {
            a(localObject[i1]);
            i1 += 1;
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      paramFile = String.valueOf(paramFile);
      localStringBuilder = new StringBuilder(String.valueOf(paramFile).length() + 23);
      localStringBuilder.append("Failed to delete file: ");
      localStringBuilder.append(paramFile);
      a(localStringBuilder.toString(), localException);
    }
  }
  
  public final void a(String paramString)
  {
    try
    {
      Log.w("Finsky.CrashDetector", String.format(Locale.US, "%s %s.", new Object[] { paramString, this }));
      return;
    }
    catch (Exception paramString) {}
  }
  
  public final void a(String paramString, Throwable paramThrowable)
  {
    try
    {
      Log.w("Finsky.CrashDetector", String.format(Locale.US, "%s %s.", new Object[] { paramString, this }), paramThrowable);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public final boolean a(int paramInt)
  {
    return (paramInt > 0) && (this.e >= paramInt);
  }
  
  public final String toString()
  {
    return String.format(Locale.US, "cnt=%d ts=%d cause=%s fg=%b\"", new Object[] { Integer.valueOf(this.e), Long.valueOf(this.m), this.c, this.f });
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if (!this.n)
    {
      boolean bool = this.k.b();
      this.n = true;
      long l1 = this.j.a;
      a(this.e + 1, i.a(), false, paramThrowable, Boolean.valueOf(bool ^ true), l1);
    }
    Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = this.g;
    if (localUncaughtExceptionHandler != null) {
      localUncaughtExceptionHandler.uncaughtException(paramThread, paramThrowable);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ai/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */