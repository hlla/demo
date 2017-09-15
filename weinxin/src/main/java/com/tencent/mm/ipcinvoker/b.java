package com.tencent.mm.ipcinvoker;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.IBinder;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ipcinvoker.a.c;
import com.tencent.mm.ipcinvoker.b.a;
import com.tencent.mm.ipcinvoker.b.a.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class b
  implements c
{
  private static b gVs;
  private Map<String, Class<?>> gVt;
  public Map<String, a> gVu;
  private volatile boolean gVv;
  public ad mHandler;
  
  private b()
  {
    GMTrace.i(18711964549120L, 139415);
    this.gVt = new HashMap();
    this.gVu = new ConcurrentHashMap();
    HandlerThread localHandlerThread = e.Qt("IPCBridgeThread#" + hashCode());
    localHandlerThread.start();
    this.mHandler = new ad(localHandlerThread.getLooper());
    GMTrace.o(18711964549120L, 139415);
  }
  
  public static b un()
  {
    GMTrace.i(18711830331392L, 139414);
    if (gVs == null) {}
    try
    {
      if (gVs == null) {
        gVs = new b();
      }
      b localb = gVs;
      GMTrace.o(18711830331392L, 139414);
      return localb;
    }
    finally {}
  }
  
  public final <T extends BaseIPCService> void a(String paramString, Class<T> paramClass)
  {
    GMTrace.i(18712501420032L, 139419);
    this.gVt.put(paramString, paramClass);
    GMTrace.o(18712501420032L, 139419);
  }
  
  /* Error */
  public final a dQ(final String paramString)
  {
    // Byte code:
    //   0: ldc2_w 121
    //   3: ldc 123
    //   5: invokestatic 39	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   8: aload_0
    //   9: getfield 49	com/tencent/mm/ipcinvoker/b:gVu	Ljava/util/Map;
    //   12: aload_1
    //   13: invokeinterface 127 2 0
    //   18: checkcast 14	com/tencent/mm/ipcinvoker/b$a
    //   21: astore 4
    //   23: aload 4
    //   25: ifnonnull +548 -> 573
    //   28: aload_0
    //   29: getfield 129	com/tencent/mm/ipcinvoker/b:gVv	Z
    //   32: ifeq +28 -> 60
    //   35: ldc -125
    //   37: ldc -123
    //   39: iconst_1
    //   40: anewarray 4	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: aload_1
    //   46: aastore
    //   47: invokestatic 138	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: ldc2_w 121
    //   53: ldc 123
    //   55: invokestatic 93	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   58: aconst_null
    //   59: areturn
    //   60: invokestatic 143	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   63: invokestatic 146	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   66: if_acmpne +20 -> 86
    //   69: ldc -125
    //   71: ldc -108
    //   73: invokestatic 152	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: ldc2_w 121
    //   79: ldc 123
    //   81: invokestatic 93	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   84: aconst_null
    //   85: areturn
    //   86: aload_0
    //   87: getfield 44	com/tencent/mm/ipcinvoker/b:gVt	Ljava/util/Map;
    //   90: aload_1
    //   91: invokeinterface 127 2 0
    //   96: checkcast 154	java/lang/Class
    //   99: astore 5
    //   101: aload 5
    //   103: ifnonnull +28 -> 131
    //   106: ldc -125
    //   108: ldc -100
    //   110: iconst_1
    //   111: anewarray 4	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: aload_1
    //   117: aastore
    //   118: invokestatic 158	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   121: ldc2_w 121
    //   124: ldc 123
    //   126: invokestatic 93	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   129: aconst_null
    //   130: areturn
    //   131: new 14	com/tencent/mm/ipcinvoker/b$a
    //   134: dup
    //   135: invokespecial 159	com/tencent/mm/ipcinvoker/b$a:<init>	()V
    //   138: astore 4
    //   140: aload_0
    //   141: getfield 49	com/tencent/mm/ipcinvoker/b:gVu	Ljava/util/Map;
    //   144: astore 6
    //   146: aload 6
    //   148: monitorenter
    //   149: aload_0
    //   150: getfield 49	com/tencent/mm/ipcinvoker/b:gVu	Ljava/util/Map;
    //   153: aload_1
    //   154: aload 4
    //   156: invokeinterface 112 3 0
    //   161: pop
    //   162: aload 6
    //   164: monitorexit
    //   165: aload 4
    //   167: monitorenter
    //   168: aload 4
    //   170: iconst_1
    //   171: putfield 162	com/tencent/mm/ipcinvoker/b$a:gVC	Z
    //   174: aload 4
    //   176: monitorexit
    //   177: invokestatic 168	com/tencent/mm/ipcinvoker/d:getContext	()Landroid/content/Context;
    //   180: astore 6
    //   182: aload 4
    //   184: new 8	com/tencent/mm/ipcinvoker/b$1
    //   187: dup
    //   188: aload_0
    //   189: aload 4
    //   191: aload 6
    //   193: aload_1
    //   194: invokespecial 171	com/tencent/mm/ipcinvoker/b$1:<init>	(Lcom/tencent/mm/ipcinvoker/b;Lcom/tencent/mm/ipcinvoker/b$a;Landroid/content/Context;Ljava/lang/String;)V
    //   197: putfield 175	com/tencent/mm/ipcinvoker/b$a:gVB	Landroid/content/ServiceConnection;
    //   200: new 177	android/content/Intent
    //   203: dup
    //   204: aload 6
    //   206: aload 5
    //   208: invokespecial 180	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   211: astore 5
    //   213: ldc -125
    //   215: ldc -74
    //   217: iconst_3
    //   218: anewarray 4	java/lang/Object
    //   221: dup
    //   222: iconst_0
    //   223: aload 4
    //   225: invokevirtual 60	java/lang/Object:hashCode	()I
    //   228: invokestatic 188	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   231: aastore
    //   232: dup
    //   233: iconst_1
    //   234: invokestatic 194	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   237: invokevirtual 198	java/lang/Thread:getId	()J
    //   240: invokestatic 203	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   243: aastore
    //   244: dup
    //   245: iconst_2
    //   246: aload 5
    //   248: aastore
    //   249: invokestatic 138	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   252: aload 6
    //   254: aload 5
    //   256: aload 4
    //   258: getfield 175	com/tencent/mm/ipcinvoker/b$a:gVB	Landroid/content/ServiceConnection;
    //   261: iconst_1
    //   262: invokevirtual 209	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   265: pop
    //   266: aload 4
    //   268: new 10	com/tencent/mm/ipcinvoker/b$2
    //   271: dup
    //   272: aload_0
    //   273: aload 4
    //   275: aload_1
    //   276: invokespecial 212	com/tencent/mm/ipcinvoker/b$2:<init>	(Lcom/tencent/mm/ipcinvoker/b;Lcom/tencent/mm/ipcinvoker/b$a;Ljava/lang/String;)V
    //   279: putfield 216	com/tencent/mm/ipcinvoker/b$a:gVD	Ljava/lang/Runnable;
    //   282: aload_0
    //   283: getfield 90	com/tencent/mm/ipcinvoker/b:mHandler	Lcom/tencent/mm/sdk/platformtools/ad;
    //   286: astore 5
    //   288: aload 4
    //   290: getfield 216	com/tencent/mm/ipcinvoker/b$a:gVD	Ljava/lang/Runnable;
    //   293: astore 6
    //   295: invokestatic 146	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   298: invokestatic 143	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   301: if_acmpne +77 -> 378
    //   304: ldc2_w 217
    //   307: lstore_2
    //   308: aload 5
    //   310: aload 6
    //   312: lload_2
    //   313: invokevirtual 222	com/tencent/mm/sdk/platformtools/ad:postDelayed	(Ljava/lang/Runnable;J)Z
    //   316: pop
    //   317: aload 4
    //   319: monitorenter
    //   320: aload 4
    //   322: getfield 162	com/tencent/mm/ipcinvoker/b$a:gVC	Z
    //   325: ifeq +8 -> 333
    //   328: aload 4
    //   330: invokevirtual 225	java/lang/Object:wait	()V
    //   333: aload 4
    //   335: monitorexit
    //   336: aload 4
    //   338: monitorenter
    //   339: aload 4
    //   341: iconst_0
    //   342: putfield 162	com/tencent/mm/ipcinvoker/b$a:gVC	Z
    //   345: aload 4
    //   347: monitorexit
    //   348: aload 4
    //   350: astore_1
    //   351: aload_1
    //   352: getfield 229	com/tencent/mm/ipcinvoker/b$a:gVA	Lcom/tencent/mm/ipcinvoker/b/a;
    //   355: astore_1
    //   356: ldc2_w 121
    //   359: ldc 123
    //   361: invokestatic 93	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   364: aload_1
    //   365: areturn
    //   366: astore_1
    //   367: aload 6
    //   369: monitorexit
    //   370: aload_1
    //   371: athrow
    //   372: astore_1
    //   373: aload 4
    //   375: monitorexit
    //   376: aload_1
    //   377: athrow
    //   378: ldc2_w 230
    //   381: lstore_2
    //   382: goto -74 -> 308
    //   385: astore 5
    //   387: aload 4
    //   389: monitorexit
    //   390: aload 5
    //   392: athrow
    //   393: astore 5
    //   395: ldc -125
    //   397: ldc -23
    //   399: iconst_1
    //   400: anewarray 4	java/lang/Object
    //   403: dup
    //   404: iconst_0
    //   405: aload 5
    //   407: aastore
    //   408: invokestatic 236	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   411: aload_0
    //   412: getfield 49	com/tencent/mm/ipcinvoker/b:gVu	Ljava/util/Map;
    //   415: astore 5
    //   417: aload 5
    //   419: monitorenter
    //   420: aload_0
    //   421: getfield 49	com/tencent/mm/ipcinvoker/b:gVu	Ljava/util/Map;
    //   424: aload_1
    //   425: invokeinterface 239 2 0
    //   430: pop
    //   431: aload 5
    //   433: monitorexit
    //   434: aload 4
    //   436: monitorenter
    //   437: aload 4
    //   439: iconst_0
    //   440: putfield 162	com/tencent/mm/ipcinvoker/b$a:gVC	Z
    //   443: aload 4
    //   445: monitorexit
    //   446: ldc2_w 121
    //   449: ldc 123
    //   451: invokestatic 93	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   454: aconst_null
    //   455: areturn
    //   456: astore_1
    //   457: aload 4
    //   459: monitorexit
    //   460: aload_1
    //   461: athrow
    //   462: astore_1
    //   463: aload 5
    //   465: monitorexit
    //   466: aload_1
    //   467: athrow
    //   468: astore_1
    //   469: aload 4
    //   471: monitorenter
    //   472: aload 4
    //   474: iconst_0
    //   475: putfield 162	com/tencent/mm/ipcinvoker/b$a:gVC	Z
    //   478: aload 4
    //   480: monitorexit
    //   481: aload_1
    //   482: athrow
    //   483: astore_1
    //   484: aload 4
    //   486: monitorexit
    //   487: aload_1
    //   488: athrow
    //   489: astore 5
    //   491: ldc -125
    //   493: ldc -15
    //   495: iconst_1
    //   496: anewarray 4	java/lang/Object
    //   499: dup
    //   500: iconst_0
    //   501: aload 5
    //   503: invokestatic 247	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   506: aastore
    //   507: invokestatic 236	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   510: aload_0
    //   511: getfield 49	com/tencent/mm/ipcinvoker/b:gVu	Ljava/util/Map;
    //   514: astore 5
    //   516: aload 5
    //   518: monitorenter
    //   519: aload_0
    //   520: getfield 49	com/tencent/mm/ipcinvoker/b:gVu	Ljava/util/Map;
    //   523: aload_1
    //   524: invokeinterface 239 2 0
    //   529: pop
    //   530: aload 5
    //   532: monitorexit
    //   533: aload 4
    //   535: monitorenter
    //   536: aload 4
    //   538: iconst_0
    //   539: putfield 162	com/tencent/mm/ipcinvoker/b$a:gVC	Z
    //   542: aload 4
    //   544: monitorexit
    //   545: ldc2_w 121
    //   548: ldc 123
    //   550: invokestatic 93	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   553: aconst_null
    //   554: areturn
    //   555: astore_1
    //   556: aload 5
    //   558: monitorexit
    //   559: aload_1
    //   560: athrow
    //   561: astore_1
    //   562: aload 4
    //   564: monitorexit
    //   565: aload_1
    //   566: athrow
    //   567: astore_1
    //   568: aload 4
    //   570: monitorexit
    //   571: aload_1
    //   572: athrow
    //   573: aload 4
    //   575: astore_1
    //   576: aload 4
    //   578: getfield 162	com/tencent/mm/ipcinvoker/b$a:gVC	Z
    //   581: ifeq -230 -> 351
    //   584: aload 4
    //   586: monitorenter
    //   587: aload 4
    //   589: getfield 162	com/tencent/mm/ipcinvoker/b$a:gVC	Z
    //   592: ifeq +8 -> 600
    //   595: aload 4
    //   597: invokevirtual 225	java/lang/Object:wait	()V
    //   600: aload 4
    //   602: monitorexit
    //   603: aload 4
    //   605: astore_1
    //   606: goto -255 -> 351
    //   609: astore_1
    //   610: aload 4
    //   612: monitorexit
    //   613: aload_1
    //   614: athrow
    //   615: astore_1
    //   616: ldc -125
    //   618: ldc -23
    //   620: iconst_1
    //   621: anewarray 4	java/lang/Object
    //   624: dup
    //   625: iconst_0
    //   626: aload_1
    //   627: aastore
    //   628: invokestatic 236	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   631: aload 4
    //   633: astore_1
    //   634: goto -283 -> 351
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	637	0	this	b
    //   0	637	1	paramString	String
    //   307	75	2	l	long
    //   21	611	4	locala	a
    //   99	210	5	localObject1	Object
    //   385	6	5	localObject2	Object
    //   393	13	5	localInterruptedException	InterruptedException
    //   415	49	5	localMap1	Map
    //   489	13	5	localSecurityException	SecurityException
    //   144	224	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   149	165	366	finally
    //   367	370	366	finally
    //   168	177	372	finally
    //   373	376	372	finally
    //   320	333	385	finally
    //   333	336	385	finally
    //   387	390	385	finally
    //   200	304	393	java/lang/InterruptedException
    //   308	320	393	java/lang/InterruptedException
    //   390	393	393	java/lang/InterruptedException
    //   339	348	456	finally
    //   457	460	456	finally
    //   420	434	462	finally
    //   463	466	462	finally
    //   200	304	468	finally
    //   308	320	468	finally
    //   390	393	468	finally
    //   395	420	468	finally
    //   466	468	468	finally
    //   491	519	468	finally
    //   559	561	468	finally
    //   437	446	483	finally
    //   484	487	483	finally
    //   200	304	489	java/lang/SecurityException
    //   308	320	489	java/lang/SecurityException
    //   390	393	489	java/lang/SecurityException
    //   519	533	555	finally
    //   556	559	555	finally
    //   536	545	561	finally
    //   562	565	561	finally
    //   472	481	567	finally
    //   568	571	567	finally
    //   587	600	609	finally
    //   600	603	609	finally
    //   610	613	609	finally
    //   584	587	615	java/lang/InterruptedException
    //   613	615	615	java/lang/InterruptedException
  }
  
  public final void dR(final String paramString)
  {
    GMTrace.i(18712232984576L, 139417);
    if (d.dS(paramString))
    {
      v.i("IPC.IPCBridgeManager", "the same process(%s), do not need to release IPCBridge.", new Object[] { paramString });
      GMTrace.o(18712232984576L, 139417);
      return;
    }
    final a locala;
    synchronized (this.gVu)
    {
      locala = (a)this.gVu.get(paramString);
      if (locala == null)
      {
        v.i("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, IPCBridgeWrapper is null.", new Object[] { paramString });
        GMTrace.o(18712232984576L, 139417);
        return;
      }
    }
    if (locala.gVC) {}
    try
    {
      locala.gVC = false;
      locala.notifyAll();
      if (locala.gVB == null)
      {
        v.i("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, ServiceConnection is null.", new Object[] { paramString });
        GMTrace.o(18712232984576L, 139417);
        return;
      }
    }
    finally {}
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(18713038290944L, 139423);
        if (locala.gVB == null)
        {
          v.i("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, ServiceConnection is null.", new Object[] { paramString });
          GMTrace.o(18713038290944L, 139423);
          return;
        }
        d.getContext().unbindService(locala.gVB);
        synchronized (b.this.gVu)
        {
          b.this.gVu.remove(paramString);
        }
        synchronized (locala)
        {
          locala.gVA = null;
          locala.gVC = false;
          locala.gVB = null;
          GMTrace.o(18713038290944L, 139423);
          return;
          localObject2 = finally;
          throw ((Throwable)localObject2);
        }
      }
    });
    GMTrace.o(18712232984576L, 139417);
  }
  
  public final void uo()
  {
    try
    {
      GMTrace.i(18712367202304L, 139418);
      this.gVv = true;
      GMTrace.o(18712367202304L, 139418);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static final class a
  {
    a gVA;
    ServiceConnection gVB;
    volatile boolean gVC;
    Runnable gVD;
    
    public a()
    {
      GMTrace.i(18692905631744L, 139273);
      GMTrace.o(18692905631744L, 139273);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ipcinvoker/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */