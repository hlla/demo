package com.tencent.mm.jni.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.e.a.mp;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public final class a
{
  public static SparseArray<b> gWr;
  private static final byte[] gWs;
  private static ad mHandler;
  
  static
  {
    GMTrace.i(13827378774016L, 103022);
    gWr = new SparseArray();
    mHandler = new ad(Looper.getMainLooper());
    gWs = new byte[0];
    GMTrace.o(13827378774016L, 103022);
  }
  
  public static void a(WakerLock paramWakerLock, String paramString)
  {
    GMTrace.i(13826976120832L, 103019);
    synchronized (gWs)
    {
      b localb2 = (b)gWr.get(paramWakerLock.hashCode());
      b localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b(paramWakerLock);
        gWr.put(paramWakerLock.hashCode(), localb1);
      }
      if (!localb1.gWw.containsKey(paramString)) {
        localb1.gWw.put(paramString, new a.b.a(paramString, SystemClock.elapsedRealtime()));
      }
      c.dY(paramString);
      paramWakerLock = mHandler;
      if (!localb1.gWu)
      {
        localb1.gWu = true;
        paramWakerLock.postDelayed(localb1.gWv, 60000L);
      }
      GMTrace.o(13826976120832L, 103019);
      return;
    }
  }
  
  public static void c(WakerLock paramWakerLock)
  {
    GMTrace.i(13827110338560L, 103020);
    synchronized (gWs)
    {
      paramWakerLock = (b)gWr.get(paramWakerLock.hashCode());
      if (paramWakerLock == null) {
        break label112;
      }
      Object localObject = mHandler;
      if (paramWakerLock.gWu)
      {
        paramWakerLock.gWu = false;
        ((ad)localObject).removeCallbacks(paramWakerLock.gWv);
      }
      localObject = paramWakerLock.gWw.values().iterator();
      if (((Iterator)localObject).hasNext()) {
        c.dZ(((a.b.a)((Iterator)localObject).next()).gWx);
      }
    }
    paramWakerLock.gWw.clear();
    label112:
    GMTrace.o(13827110338560L, 103020);
  }
  
  public static void uy()
  {
    GMTrace.i(13826707685376L, 103017);
    c.uA();
    GMTrace.o(13826707685376L, 103017);
  }
  
  public static void uz()
  {
    GMTrace.i(13826841903104L, 103018);
    c.detach();
    GMTrace.o(13826841903104L, 103018);
  }
  
  private static final class a
    implements Runnable
  {
    private WakerLock gWt;
    
    public a(WakerLock paramWakerLock)
    {
      GMTrace.i(13824828637184L, 103003);
      this.gWt = null;
      this.gWt = paramWakerLock;
      GMTrace.o(13824828637184L, 103003);
    }
    
    public final void run()
    {
      GMTrace.i(13824962854912L, 103004);
      Object localObject1 = (a.b)a.gWr.get(this.gWt.hashCode());
      int k = this.gWt.hashCode();
      int m = this.gWt.innerWakeLockHashCode();
      String str = this.gWt.getCreatePosStackLine();
      Object localObject2 = ((a.b)localObject1).gWw.values();
      localObject1 = new StringBuilder();
      localObject2 = ((Collection)localObject2).iterator();
      int i = 1;
      if (((Iterator)localObject2).hasNext())
      {
        a.b.a locala = (a.b.a)((Iterator)localObject2).next();
        if (i != 0) {}
        for (int j = 0;; j = i)
        {
          i = j;
          if (locala.gWy == 0L) {
            break;
          }
          ((StringBuilder)localObject1).append('{').append(locala.gWx).append(',').append(SystemClock.elapsedRealtime() - locala.gWy).append('}');
          i = j;
          break;
          ((StringBuilder)localObject1).append(',');
        }
      }
      if (((StringBuilder)localObject1).length() == 0) {
        ((StringBuilder)localObject1).append("<empty>");
      }
      v.w("MicroMsg.WakeLockManager", "wakerlock held too long: [%d,%d] @[%s] force to unlock it. state: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(m), str, ((StringBuilder)localObject1).toString() });
      this.gWt.unLock();
      GMTrace.o(13824962854912L, 103004);
    }
  }
  
  private static final class b
  {
    volatile boolean gWu;
    a.a gWv;
    public Map<String, a> gWw;
    
    public b(WakerLock paramWakerLock)
    {
      GMTrace.i(13828318298112L, 103029);
      this.gWu = false;
      this.gWv = null;
      this.gWw = new HashMap();
      this.gWv = new a.a(paramWakerLock);
      GMTrace.o(13828318298112L, 103029);
    }
    
    private static final class a
    {
      public String gWx;
      public long gWy;
      
      public a(String paramString, long paramLong)
      {
        GMTrace.i(13828452515840L, 103030);
        this.gWx = null;
        this.gWy = 0L;
        this.gWx = paramString;
        this.gWy = paramLong;
        GMTrace.o(13828452515840L, 103030);
      }
    }
  }
  
  private static final class c
  {
    private static long fxu;
    private static long gWA;
    private static HashMap<String, a> gWB;
    private static final byte[] gWC;
    private static BroadcastReceiver gWD;
    private static int gWz;
    
    static
    {
      GMTrace.i(13826573467648L, 103016);
      gWz = 0;
      fxu = 0L;
      gWA = 0L;
      gWB = null;
      gWC = new byte[0];
      gWD = null;
      GMTrace.o(13826573467648L, 103016);
    }
    
    public static void a(String paramString1, String paramString2, long paramLong)
    {
      GMTrace.i(13825768161280L, 103010);
      String str = paramString1 + "_" + paramString2;
      synchronized (gWC)
      {
        a locala2 = (a)gWB.get(str);
        a locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = new a();
          locala1.gWE = paramString1;
          locala1.gWx = paramString2;
          locala1.gWJ = 0L;
          locala1.gWH = 0;
          locala1.gWI = 0;
          gWB.put(str, locala1);
        }
        if (locala1.gWL.getAndIncrement() == 0)
        {
          locala1.gWK = paramLong;
          locala1.gWF = al.getNetTypeString(aa.getContext());
          locala1.gWG = com.tencent.mm.sdk.a.b.foreground;
        }
        GMTrace.o(13825768161280L, 103010);
        return;
      }
    }
    
    public static void b(String arg0, String paramString2, long paramLong)
    {
      GMTrace.i(13825902379008L, 103011);
      paramString2 = ??? + "_" + paramString2;
      long l2 = 0L;
      synchronized (gWC)
      {
        paramString2 = (a)gWB.get(paramString2);
        long l1 = l2;
        if (paramString2 != null)
        {
          l1 = l2;
          if (paramString2.gWL.get() > 0)
          {
            paramString2.gWH += 1;
            l1 = l2;
            if (paramString2.gWL.decrementAndGet() == 0)
            {
              l1 = paramLong - paramString2.gWK;
              paramString2.gWJ += l1;
              paramString2.gWI += 1;
            }
          }
        }
        uB();
        paramLong = SystemClock.elapsedRealtime();
        if ((l1 >= 14000L) || (paramLong - gWA >= 3600000L))
        {
          v.d("MicroMsg.WakeLockStatsManager", "saveStatsToStorage triggered.");
          uC();
          gWA = paramLong;
        }
        GMTrace.o(13825902379008L, 103011);
        return;
      }
    }
    
    public static void dY(String paramString)
    {
      GMTrace.i(13825365508096L, 103007);
      j(paramString, true);
      GMTrace.o(13825365508096L, 103007);
    }
    
    public static void dZ(String paramString)
    {
      GMTrace.i(13825499725824L, 103008);
      j(paramString, false);
      GMTrace.o(13825499725824L, 103008);
    }
    
    public static void detach()
    {
      GMTrace.i(13825231290368L, 103006);
      if (gWz > 0)
      {
        aa.getContext().unregisterReceiver(gWD);
        uC();
        gWz = 0;
        v.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is detached from process [%s]", new Object[] { aa.um() });
      }
      GMTrace.o(13825231290368L, 103006);
    }
    
    private static void j(String paramString, boolean paramBoolean)
    {
      GMTrace.i(13825633943552L, 103009);
      int i = Process.myPid();
      String str = aa.um();
      if (i == gWz)
      {
        if (paramBoolean)
        {
          a(str, paramString, SystemClock.elapsedRealtime());
          GMTrace.o(13825633943552L, 103009);
          return;
        }
        b(str, paramString, SystemClock.elapsedRealtime());
        GMTrace.o(13825633943552L, 103009);
        return;
      }
      if (paramBoolean)
      {
        localIntent = new Intent("com.tencent.mm.ACTION.note_tracemsg_lock");
        localIntent.putExtra("pid", i);
        localIntent.putExtra("processName", str);
        localIntent.putExtra("traceMsg", paramString);
        localIntent.putExtra("tick", SystemClock.elapsedRealtime());
        aa.getContext().sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
        GMTrace.o(13825633943552L, 103009);
        return;
      }
      Intent localIntent = new Intent("com.tencent.mm.ACTION.note_tracemsg_unlock");
      localIntent.putExtra("pid", i);
      localIntent.putExtra("processName", str);
      localIntent.putExtra("traceMsg", paramString);
      localIntent.putExtra("tick", SystemClock.elapsedRealtime());
      aa.getContext().sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
      GMTrace.o(13825633943552L, 103009);
    }
    
    /* Error */
    public static void uA()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_1
      //   2: ldc2_w 248
      //   5: ldc -6
      //   7: invokestatic 35	com/tencent/gmtrace/GMTrace:i	(JI)V
      //   10: getstatic 37	com/tencent/mm/jni/a/a$c:gWz	I
      //   13: ifne +131 -> 144
      //   16: invokestatic 208	android/os/Process:myPid	()I
      //   19: putstatic 37	com/tencent/mm/jni/a/a$c:gWz	I
      //   22: new 9	com/tencent/mm/jni/a/a$c$1
      //   25: dup
      //   26: invokespecial 251	com/tencent/mm/jni/a/a$c$1:<init>	()V
      //   29: putstatic 47	com/tencent/mm/jni/a/a$c:gWD	Landroid/content/BroadcastReceiver;
      //   32: getstatic 45	com/tencent/mm/jni/a/a$c:gWC	[B
      //   35: astore_3
      //   36: aload_3
      //   37: monitorenter
      //   38: new 253	java/io/ObjectInputStream
      //   41: dup
      //   42: new 255	java/io/FileInputStream
      //   45: dup
      //   46: new 257	java/io/File
      //   49: dup
      //   50: invokestatic 116	com/tencent/mm/sdk/platformtools/aa:getContext	()Landroid/content/Context;
      //   53: invokevirtual 261	android/content/Context:getCacheDir	()Ljava/io/File;
      //   56: ldc_w 263
      //   59: invokespecial 266	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   62: invokespecial 269	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   65: invokespecial 272	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
      //   68: astore_0
      //   69: aload_0
      //   70: invokevirtual 275	java/io/ObjectInputStream:readLong	()J
      //   73: putstatic 39	com/tencent/mm/jni/a/a$c:fxu	J
      //   76: aload_0
      //   77: invokevirtual 279	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
      //   80: checkcast 72	java/util/HashMap
      //   83: putstatic 43	com/tencent/mm/jni/a/a$c:gWB	Ljava/util/HashMap;
      //   86: aload_0
      //   87: invokevirtual 282	java/io/ObjectInputStream:close	()V
      //   90: aload_3
      //   91: monitorexit
      //   92: new 284	android/content/IntentFilter
      //   95: dup
      //   96: invokespecial 285	android/content/IntentFilter:<init>	()V
      //   99: astore_0
      //   100: aload_0
      //   101: ldc -40
      //   103: invokevirtual 288	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
      //   106: aload_0
      //   107: ldc -12
      //   109: invokevirtual 288	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
      //   112: invokestatic 116	com/tencent/mm/sdk/platformtools/aa:getContext	()Landroid/content/Context;
      //   115: getstatic 47	com/tencent/mm/jni/a/a$c:gWD	Landroid/content/BroadcastReceiver;
      //   118: aload_0
      //   119: ldc -18
      //   121: aconst_null
      //   122: invokevirtual 292	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
      //   125: pop
      //   126: ldc -98
      //   128: ldc_w 294
      //   131: iconst_1
      //   132: anewarray 4	java/lang/Object
      //   135: dup
      //   136: iconst_0
      //   137: invokestatic 197	com/tencent/mm/sdk/platformtools/aa:um	()Ljava/lang/String;
      //   140: aastore
      //   141: invokestatic 200	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   144: ldc2_w 248
      //   147: ldc -6
      //   149: invokestatic 50	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   152: return
      //   153: astore_0
      //   154: aconst_null
      //   155: astore_0
      //   156: ldc -98
      //   158: ldc_w 296
      //   161: invokestatic 299	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   164: invokestatic 152	android/os/SystemClock:elapsedRealtime	()J
      //   167: putstatic 39	com/tencent/mm/jni/a/a$c:fxu	J
      //   170: new 72	java/util/HashMap
      //   173: dup
      //   174: invokespecial 300	java/util/HashMap:<init>	()V
      //   177: putstatic 43	com/tencent/mm/jni/a/a$c:gWB	Ljava/util/HashMap;
      //   180: aload_0
      //   181: ifnull -91 -> 90
      //   184: aload_0
      //   185: invokevirtual 282	java/io/ObjectInputStream:close	()V
      //   188: goto -98 -> 90
      //   191: astore_0
      //   192: goto -102 -> 90
      //   195: astore_0
      //   196: aload_1
      //   197: ifnull +7 -> 204
      //   200: aload_1
      //   201: invokevirtual 282	java/io/ObjectInputStream:close	()V
      //   204: aload_0
      //   205: athrow
      //   206: astore_0
      //   207: aload_3
      //   208: monitorexit
      //   209: aload_0
      //   210: athrow
      //   211: astore_0
      //   212: goto -122 -> 90
      //   215: astore_1
      //   216: goto -12 -> 204
      //   219: astore_2
      //   220: aload_0
      //   221: astore_1
      //   222: aload_2
      //   223: astore_0
      //   224: goto -28 -> 196
      //   227: astore_2
      //   228: aload_0
      //   229: astore_1
      //   230: aload_2
      //   231: astore_0
      //   232: goto -36 -> 196
      //   235: astore_1
      //   236: goto -80 -> 156
      // Local variable table:
      //   start	length	slot	name	signature
      //   68	51	0	localObject1	Object
      //   153	1	0	localException1	Exception
      //   155	30	0	localObject2	Object
      //   191	1	0	localException2	Exception
      //   195	10	0	localObject3	Object
      //   206	4	0	localObject4	Object
      //   211	10	0	localException3	Exception
      //   223	9	0	localObject5	Object
      //   1	200	1	localObject6	Object
      //   215	1	1	localException4	Exception
      //   221	9	1	localObject7	Object
      //   235	1	1	localException5	Exception
      //   219	4	2	localObject8	Object
      //   227	4	2	localObject9	Object
      //   35	173	3	arrayOfByte	byte[]
      // Exception table:
      //   from	to	target	type
      //   38	69	153	java/lang/Exception
      //   184	188	191	java/lang/Exception
      //   38	69	195	finally
      //   86	90	206	finally
      //   90	92	206	finally
      //   184	188	206	finally
      //   200	204	206	finally
      //   204	206	206	finally
      //   207	209	206	finally
      //   86	90	211	java/lang/Exception
      //   200	204	215	java/lang/Exception
      //   69	86	219	finally
      //   156	180	227	finally
      //   69	86	235	java/lang/Exception
    }
    
    private static void uB()
    {
      GMTrace.i(13826036596736L, 103012);
      long l;
      for (;;)
      {
        synchronized (gWC)
        {
          l = SystemClock.elapsedRealtime();
          if (l - fxu < 21600000L) {
            break label294;
          }
          if (gWB.isEmpty()) {
            break label290;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          Iterator localIterator = gWB.entrySet().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Object localObject2 = (a)((Map.Entry)localIterator.next()).getValue();
          if (((a)localObject2).gWI <= 0) {
            continue;
          }
          localStringBuilder.setLength(0);
          Object localObject3 = localStringBuilder.append(((a)localObject2).gWE).append(',').append(((a)localObject2).gWx.replace(",", "##")).append(',').append(((a)localObject2).gWI).append(',').append(((a)localObject2).gWH).append(',').append(((a)localObject2).gWJ).append(',');
          if (((a)localObject2).gWG)
          {
            i = 1;
            ((StringBuilder)localObject3).append(i).append(',').append(((a)localObject2).gWF);
            localObject2 = localStringBuilder.toString();
            localObject3 = new mp();
            ((mp)localObject3).fTK.fTL = ((String)localObject2);
            com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject3);
            v.d("MicroMsg.WakeLockStatsManager", "kvstat-str: %s", new Object[] { localStringBuilder.toString() });
          }
        }
        int i = 0;
      }
      gWB.clear();
      label290:
      fxu = l;
      label294:
      GMTrace.o(13826036596736L, 103012);
    }
    
    /* Error */
    private static void uC()
    {
      // Byte code:
      //   0: ldc2_w 387
      //   3: ldc_w 389
      //   6: invokestatic 35	com/tencent/gmtrace/GMTrace:i	(JI)V
      //   9: getstatic 45	com/tencent/mm/jni/a/a$c:gWC	[B
      //   12: astore_3
      //   13: aload_3
      //   14: monitorenter
      //   15: aconst_null
      //   16: astore_1
      //   17: aconst_null
      //   18: astore_2
      //   19: aload_1
      //   20: astore_0
      //   21: new 257	java/io/File
      //   24: dup
      //   25: invokestatic 116	com/tencent/mm/sdk/platformtools/aa:getContext	()Landroid/content/Context;
      //   28: invokevirtual 261	android/content/Context:getCacheDir	()Ljava/io/File;
      //   31: ldc_w 391
      //   34: invokespecial 266	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   37: astore 4
      //   39: aload_1
      //   40: astore_0
      //   41: aload 4
      //   43: invokevirtual 394	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   46: invokestatic 400	com/tencent/mm/modelsfs/FileOp:km	(Ljava/lang/String;)Z
      //   49: ifne +80 -> 129
      //   52: aload_1
      //   53: astore_0
      //   54: new 386	java/io/IOException
      //   57: dup
      //   58: new 57	java/lang/StringBuilder
      //   61: dup
      //   62: ldc_w 402
      //   65: invokespecial 403	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   68: aload 4
      //   70: invokevirtual 394	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   73: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   76: ldc_w 405
      //   79: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   82: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   85: invokespecial 406	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   88: athrow
      //   89: astore_0
      //   90: aload_2
      //   91: astore_1
      //   92: aload_0
      //   93: astore_2
      //   94: aload_1
      //   95: astore_0
      //   96: ldc -98
      //   98: aload_2
      //   99: ldc_w 408
      //   102: iconst_0
      //   103: anewarray 4	java/lang/Object
      //   106: invokestatic 412	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   109: aload_1
      //   110: ifnull +7 -> 117
      //   113: aload_1
      //   114: invokevirtual 415	java/io/ObjectOutputStream:close	()V
      //   117: aload_3
      //   118: monitorexit
      //   119: ldc2_w 387
      //   122: ldc_w 389
      //   125: invokestatic 50	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   128: return
      //   129: aload_1
      //   130: astore_0
      //   131: new 414	java/io/ObjectOutputStream
      //   134: dup
      //   135: new 417	java/io/FileOutputStream
      //   138: dup
      //   139: new 257	java/io/File
      //   142: dup
      //   143: aload 4
      //   145: ldc_w 419
      //   148: invokespecial 266	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   151: invokespecial 420	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   154: invokespecial 423	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   157: astore_1
      //   158: aload_1
      //   159: getstatic 39	com/tencent/mm/jni/a/a$c:fxu	J
      //   162: invokevirtual 427	java/io/ObjectOutputStream:writeLong	(J)V
      //   165: aload_1
      //   166: getstatic 43	com/tencent/mm/jni/a/a$c:gWB	Ljava/util/HashMap;
      //   169: invokevirtual 431	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
      //   172: aload_1
      //   173: invokevirtual 415	java/io/ObjectOutputStream:close	()V
      //   176: goto -59 -> 117
      //   179: astore_0
      //   180: goto -63 -> 117
      //   183: astore_2
      //   184: aload_0
      //   185: astore_1
      //   186: aload_2
      //   187: astore_0
      //   188: aload_1
      //   189: ifnull +7 -> 196
      //   192: aload_1
      //   193: invokevirtual 415	java/io/ObjectOutputStream:close	()V
      //   196: aload_0
      //   197: athrow
      //   198: astore_0
      //   199: aload_3
      //   200: monitorexit
      //   201: aload_0
      //   202: athrow
      //   203: astore_0
      //   204: goto -87 -> 117
      //   207: astore_1
      //   208: goto -12 -> 196
      //   211: astore_0
      //   212: goto -24 -> 188
      //   215: astore_2
      //   216: goto -122 -> 94
      // Local variable table:
      //   start	length	slot	name	signature
      //   20	34	0	localObject1	Object
      //   89	4	0	localIOException1	java.io.IOException
      //   95	36	0	localObject2	Object
      //   179	6	0	localException1	Exception
      //   187	10	0	localObject3	Object
      //   198	4	0	localObject4	Object
      //   203	1	0	localException2	Exception
      //   211	1	0	localObject5	Object
      //   16	177	1	localObject6	Object
      //   207	1	1	localException3	Exception
      //   18	81	2	localObject7	Object
      //   183	4	2	localObject8	Object
      //   215	1	2	localIOException2	java.io.IOException
      //   12	188	3	arrayOfByte	byte[]
      //   37	107	4	localFile	java.io.File
      // Exception table:
      //   from	to	target	type
      //   21	39	89	java/io/IOException
      //   41	52	89	java/io/IOException
      //   54	89	89	java/io/IOException
      //   131	158	89	java/io/IOException
      //   172	176	179	java/lang/Exception
      //   21	39	183	finally
      //   41	52	183	finally
      //   54	89	183	finally
      //   96	109	183	finally
      //   131	158	183	finally
      //   113	117	198	finally
      //   117	119	198	finally
      //   172	176	198	finally
      //   192	196	198	finally
      //   196	198	198	finally
      //   199	201	198	finally
      //   113	117	203	java/lang/Exception
      //   192	196	207	java/lang/Exception
      //   158	172	211	finally
      //   158	172	215	java/io/IOException
    }
    
    private static final class a
      implements Externalizable
    {
      public String gWE;
      public String gWF;
      public boolean gWG;
      public int gWH;
      public int gWI;
      public long gWJ;
      public long gWK;
      public AtomicInteger gWL;
      public String gWx;
      
      public a()
      {
        GMTrace.i(13827512991744L, 103023);
        this.gWE = "";
        this.gWx = "";
        this.gWF = "";
        this.gWG = false;
        this.gWH = 0;
        this.gWI = 0;
        this.gWJ = 0L;
        this.gWK = 0L;
        this.gWL = new AtomicInteger(0);
        GMTrace.o(13827512991744L, 103023);
      }
      
      public final void readExternal(ObjectInput paramObjectInput)
      {
        GMTrace.i(13827647209472L, 103024);
        this.gWE = paramObjectInput.readUTF();
        this.gWx = paramObjectInput.readUTF();
        this.gWH = paramObjectInput.readInt();
        this.gWI = paramObjectInput.readInt();
        this.gWJ = paramObjectInput.readLong();
        this.gWF = "";
        this.gWG = false;
        this.gWK = 0L;
        this.gWL = new AtomicInteger(0);
        GMTrace.o(13827647209472L, 103024);
      }
      
      public final void writeExternal(ObjectOutput paramObjectOutput)
      {
        GMTrace.i(13827781427200L, 103025);
        paramObjectOutput.writeUTF(this.gWE);
        paramObjectOutput.writeUTF(this.gWx);
        paramObjectOutput.writeInt(this.gWH);
        paramObjectOutput.writeInt(this.gWI);
        paramObjectOutput.writeLong(this.gWJ);
        GMTrace.o(13827781427200L, 103025);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/jni/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */