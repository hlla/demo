package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Base64;
import android.util.Pair;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.d.o;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.stub.BaseBuildInfo;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static int fvh;
  public static int fvi;
  public static o fvj;
  private static final b fvk;
  private static final d fvl;
  public static b fvm;
  public static d fvn;
  public static Handler fvo;
  public static int fvp;
  public static int fvq;
  public static String fvr;
  public static boolean fvs;
  public static boolean fvt;
  public static Thread fvu;
  public static String fvv;
  
  static
  {
    GMTrace.i(12968653750272L, 96624);
    fvh = 0;
    fvi = 0;
    fvj = new o(Process.myPid());
    fvk = new b()
    {
      public final void b(a.a paramAnonymousa)
      {
        GMTrace.i(12962077081600L, 96575);
        int i = aa.getContext().getSharedPreferences("system_config_prefs", 4).getInt("main_thread_watch_report", 0);
        if (i > 0) {}
        for (boolean bool = true;; bool = false)
        {
          v.w("MicroMsg.ANRWatchDog.summeranr", "summeranr onAppNotResponding error reportFlag[%b]", new Object[] { Boolean.valueOf(bool) });
          try
          {
            paramAnonymousa = a.a(paramAnonymousa);
            if (i > 0)
            {
              b.r(Base64.encodeToString(paramAnonymousa.getBytes(), 2), "main_thread_watch");
              GMTrace.o(12962077081600L, 96575);
              return;
            }
            g.oSF.a(510L, 14L, 1L, true);
            GMTrace.o(12962077081600L, 96575);
            return;
          }
          catch (OutOfMemoryError paramAnonymousa)
          {
            v.e("MicroMsg.ANRWatchDog.summeranr", "summeranr buildReport OutOfMemory %s", new Object[] { paramAnonymousa.getMessage() });
            System.gc();
            g.oSF.a(510L, 15L, 1L, true);
            GMTrace.o(12962077081600L, 96575);
            return;
          }
        }
      }
    };
    fvl = new d()
    {
      public final void a(InterruptedException paramAnonymousInterruptedException)
      {
        GMTrace.i(13040326017024L, 97158);
        v.w("MicroMsg.ANRWatchDog.summeranr", "summeranr DEFAULT_INTERRUPTION_LISTENER onInterrupted exception.getMessage[%s]", new Object[] { paramAnonymousInterruptedException.getMessage() });
        GMTrace.o(13040326017024L, 97158);
      }
    };
    fvm = fvk;
    fvn = fvl;
    fvp = 4500;
    fvq = 500;
    fvr = "";
    fvs = true;
    fvt = false;
    fvv = "";
    GMTrace.o(12968653750272L, 96624);
  }
  
  public static String a(a parama)
  {
    GMTrace.i(12965835177984L, 96603);
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      JSONObject localJSONObject2;
      JSONObject localJSONObject3;
      try
      {
        Object localObject1 = new JSONObject();
        localJSONObject1.put("head", localObject1);
        ((JSONObject)localObject1).put("protocol_ver", new Integer(1));
        ((JSONObject)localObject1).put("phone", new String(Build.MODEL));
        ((JSONObject)localObject1).put("os_ver", new String("android-" + Build.VERSION.SDK_INT));
        localJSONObject2 = new JSONObject();
        localJSONObject1.put("items", localJSONObject2);
        localJSONObject2.put("tag", "main_thread_watch");
        localObject1 = new JSONArray();
        localJSONObject3 = new JSONObject();
        ((JSONArray)localObject1).put(localJSONObject3);
        localJSONObject2.put("info", localObject1);
        localObject1 = new JSONObject();
        localJSONObject3.put("traces", localObject1);
        parama = parama.fvw;
        Object localObject3;
        Object localObject4;
        Object localObject5;
        int j;
        w.a locala1;
        if (!bf.bV(parama))
        {
          parama = parama.iterator();
          if (parama.hasNext())
          {
            localObject3 = (Pair)parama.next();
            localObject4 = (Thread)((Pair)localObject3).first;
            localObject3 = (StackTraceElement[])((Pair)localObject3).second;
            if ((localObject3 == null) || (localObject3.length <= 0)) {
              continue;
            }
            localObject4 = ((Thread)localObject4).getName() + " (prio:" + ((Thread)localObject4).getPriority() + " tid:" + ((Thread)localObject4).getId() + " state:" + ((Thread)localObject4).getState() + ")";
            localObject5 = new JSONArray();
            j = localObject3.length;
            i = 0;
            if (i < j)
            {
              locala1 = localObject3[i];
              if (locala1 == null) {
                break label1411;
              }
              ((JSONArray)localObject5).put(locala1.toString());
              break label1411;
            }
            ((JSONObject)localObject1).put((String)localObject4, localObject5);
            continue;
          }
        }
        int k;
        long l1;
        w.a locala2;
        w.a locala3;
        w.a locala4;
        StringBuilder localStringBuilder;
        long l2;
      }
      catch (JSONException parama)
      {
        v.printErrStackTrace("MicroMsg.ANRWatchDog.summeranr", parama, "summeranr buildReport JSONException:", new Object[0]);
        g.oSF.a(510L, 10L, 1L, true);
        localObject1 = localJSONObject1.toString();
        i = localJSONObject1.length();
        j = ((String)localObject1).length();
        if (((String)localObject1).length() <= 51200) {
          break label1405;
        }
        parama = ((String)localObject1).substring(0, 51200);
        v.i("MicroMsg.ANRWatchDog.summeranr", "summeranr buildReport packer len[%d][%d][%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), parama });
        GMTrace.o(12965835177984L, 96603);
        return (String)localObject1;
        i = fvj.ry();
        j = fvj.rz();
        k = fvj.rx();
        v.i("MicroMsg.ANRWatchDog.summeranr", "summeranr buildReport CpuUsage [%d, %d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        localJSONObject3.put("cpu_usage_total", i);
        localJSONObject3.put("cpu_usage_pid", j);
        localJSONObject3.put("cpu_count", k);
        localObject1 = (ActivityManager)aa.getContext().getSystemService("activity");
        localObject3 = new ActivityManager.MemoryInfo();
        ((ActivityManager)localObject1).getMemoryInfo((ActivityManager.MemoryInfo)localObject3);
        l1 = 0L;
        if (com.tencent.mm.compatible.util.d.eo(16))
        {
          l1 = ((ActivityManager.MemoryInfo)localObject3).totalMem;
          v.i("MicroMsg.ANRWatchDog.summeranr", "summeranr buildReport MemoryInfo[%d, %d, %d, %b]", new Object[] { Long.valueOf(l1), Long.valueOf(((ActivityManager.MemoryInfo)localObject3).availMem), Long.valueOf(((ActivityManager.MemoryInfo)localObject3).threshold), Boolean.valueOf(((ActivityManager.MemoryInfo)localObject3).lowMemory) });
          localJSONObject3.put("mem_sys_total", l1);
          localJSONObject3.put("mem_sys_avail", ((ActivityManager.MemoryInfo)localObject3).availMem);
          localJSONObject3.put("mem_sys_threshold", ((ActivityManager.MemoryInfo)localObject3).threshold);
          localJSONObject3.put("mem_sys_low", ((ActivityManager.MemoryInfo)localObject3).lowMemory);
          localJSONObject3.put("mem_native_heap_size", Debug.getNativeHeapSize());
          localJSONObject3.put("mem_native_heap_alloc_size", Debug.getNativeHeapAllocatedSize());
          localJSONObject3.put("mem_native_heap_free_size", Debug.getNativeHeapFreeSize());
          parama = ((ActivityManager)localObject1).getProcessMemoryInfo(new int[] { Process.myPid() });
          if ((parama != null) && (parama.length > 0) && (parama[0] != null))
          {
            parama = parama[0];
            localJSONObject3.put("mem_private_dirty", parama.getTotalPrivateDirty() << 10);
            localJSONObject3.put("mem_shared_dirty", parama.getTotalSharedDirty() << 10);
            localJSONObject3.put("mem_pss", parama.getTotalPss() << 10);
          }
          if ((fvh != 1) || (!ap.zb()) || (!h.vG().gXf)) {
            break label1251;
          }
          localObject3 = w.a.uEz;
          localObject4 = w.a.uEA;
          localObject5 = w.a.uEB;
          locala1 = w.a.uEC;
          locala2 = w.a.uED;
          locala3 = w.a.uEE;
          locala4 = w.a.uEF;
          i = 0;
          parama = "";
          if (i >= 7) {}
        }
        else
        {
          try
          {
            localObject1 = new w.a[] { localObject3, localObject4, localObject5, locala1, locala2, locala3, locala4 }[i];
            localStringBuilder = new StringBuilder().append(parama);
            ap.yY();
            localObject1 = c.vr().get((w.a)localObject1, Long.valueOf(0L)) + ":";
            i += 1;
            parama = (a)localObject1;
          }
          catch (Exception localException1)
          {
            v.printErrStackTrace("MicroMsg.ANRWatchDog.summeranr", localException1, "summeranr buildReport storage_usage:", new Object[0]);
            g.oSF.a(510L, 9L, 1L, true);
          }
          parama = new RandomAccessFile("/proc/meminfo", "r");
        }
      }
      catch (Exception parama)
      {
        try
        {
          localObject4 = new StringBuffer();
          localObject5 = parama.readLine().toCharArray();
          j = localObject5.length;
          i = 0;
          if (i < j)
          {
            if ((localObject5[i] > '9') || (localObject5[i] < '0')) {
              break label1418;
            }
            ((StringBuffer)localObject4).append(localObject5[i]);
            break label1418;
          }
          l2 = bf.getLong(((StringBuffer)localObject4).toString(), -1L);
          if (l2 > 0L) {
            l1 = l2 << 10;
          }
          parama.close();
          continue;
          parama = parama;
          v.printErrStackTrace("MicroMsg.ANRWatchDog.summeranr", parama, "summeranr buildReport Exception:", new Object[0]);
          g.oSF.a(510L, 11L, 1L, true);
          continue;
        }
        catch (Exception localException2)
        {
          v.printErrStackTrace("MicroMsg.ANRWatchDog.summeranr", localException2, "summeranr", new Object[0]);
          parama.close();
          continue;
        }
        finally
        {
          parama.close();
        }
      }
      tmp1228_1225[0] = fvv;
      Object[] tmp1234_1228 = tmp1228_1225;
      tmp1234_1228[1] = parama;
      v.i("MicroMsg.ANRWatchDog.summeranr", "summeranr sProcessName[%s] storage_usage[%s]", tmp1234_1228);
      localJSONObject3.put("storage_usage", parama);
      label1251:
      localJSONObject3.put("time", new Integer(fvp));
      int i = 0;
      if (new File(w.hgg).exists()) {
        i = aa.getContext().getSharedPreferences("system_config_prefs", 4).getInt("default_uin", 0);
      }
      localJSONObject2.put("uin", new Long(i));
      localJSONObject2.put("process_name", fvv);
      localJSONObject2.put("time", new Long(System.currentTimeMillis()));
      localJSONObject2.put("cver", new Integer(com.tencent.mm.protocal.d.sXh));
      localJSONObject2.put("revision", BaseBuildInfo.codeRevision());
      g.oSF.a(510L, 8L, 1L, true);
      continue;
      label1405:
      parama = localException1;
      continue;
      label1411:
      i += 1;
      continue;
      label1418:
      i += 1;
    }
  }
  
  public static void be(String paramString)
  {
    GMTrace.i(12965700960256L, 96602);
    SharedPreferences localSharedPreferences = aa.getContext().getSharedPreferences("system_config_prefs", 4);
    int n = localSharedPreferences.getInt("main_thread_watch_enable", 65535);
    int j = localSharedPreferences.getInt("main_thread_watch_timeout", 0);
    int k = localSharedPreferences.getInt("main_thread_watch_log_loop", 0);
    int i1 = localSharedPreferences.getInt("main_thread_watch_report", 0);
    int m = k;
    int i = j;
    if (g(paramString, n))
    {
      i = j;
      if (j <= 0) {
        i = 4500;
      }
      j = k;
      if (k <= 0) {
        j = 500;
      }
      if (fvu != null) {
        fvu.interrupt();
      }
      fvv = paramString;
      if (i > 0) {
        fvp = i;
      }
      if (j > 0) {
        fvq = j;
      }
      fvu = e.b(new c(), paramString + "_ANRWatchDog");
      if (fvo == null) {
        fvo = new Handler(Looper.getMainLooper());
      }
      fvu.start();
      v.i("MicroMsg.ANRWatchDog.summeranr", "summeranr startWatch sProcessName[%s], sTimeoutInterval[%d], logLoop[%d], sWatchThread[%s], stack[%s]", new Object[] { fvv, Integer.valueOf(fvp), Integer.valueOf(fvq), fvu.getName(), bf.bJP() });
      m = j;
    }
    v.i("MicroMsg.ANRWatchDog.summeranr", "summeranr startWatch processName[%s] enable[%d], timeout[%d], loop[%d], report[%d]", new Object[] { paramString, Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(i1) });
    GMTrace.o(12965700960256L, 96602);
  }
  
  public static int cQ(int paramInt)
  {
    int k = 0;
    GMTrace.i(16084920958976L, 119842);
    if (paramInt < 0)
    {
      GMTrace.o(16084920958976L, 119842);
      return -1;
    }
    if (paramInt == 0)
    {
      GMTrace.o(16084920958976L, 119842);
      return 0;
    }
    if ((paramInt == 1) || (paramInt == 2))
    {
      GMTrace.o(16084920958976L, 119842);
      return 1;
    }
    int m = 1;
    int j = 3;
    int i = 1;
    while (j <= paramInt)
    {
      m += i;
      j += 1;
      k = m;
      int n = i;
      i = m;
      m = n;
    }
    GMTrace.o(16084920958976L, 119842);
    return k;
  }
  
  public static boolean g(String paramString, int paramInt)
  {
    GMTrace.i(12965566742528L, 96601);
    if (bf.mA(paramString))
    {
      GMTrace.o(12965566742528L, 96601);
      return false;
    }
    if (paramString.equals(aa.getPackageName()))
    {
      fvh = 1;
      if ((paramInt & 0x1) != 0)
      {
        GMTrace.o(12965566742528L, 96601);
        return true;
      }
      GMTrace.o(12965566742528L, 96601);
      return false;
    }
    if (paramString.endsWith(":push"))
    {
      fvh = 2;
      if ((paramInt & 0x2) != 0)
      {
        GMTrace.o(12965566742528L, 96601);
        return true;
      }
      GMTrace.o(12965566742528L, 96601);
      return false;
    }
    if (paramString.endsWith(":tools"))
    {
      fvh = 4;
      if ((paramInt & 0x4) != 0)
      {
        GMTrace.o(12965566742528L, 96601);
        return true;
      }
      GMTrace.o(12965566742528L, 96601);
      return false;
    }
    if (paramString.endsWith(":sandbox"))
    {
      fvh = 8;
      if ((paramInt & 0x8) != 0)
      {
        GMTrace.o(12965566742528L, 96601);
        return true;
      }
      GMTrace.o(12965566742528L, 96601);
      return false;
    }
    if (paramString.endsWith(":exdevice"))
    {
      fvh = 16;
      if ((paramInt & 0x10) != 0)
      {
        GMTrace.o(12965566742528L, 96601);
        return true;
      }
      GMTrace.o(12965566742528L, 96601);
      return false;
    }
    if (paramString.contains(":appbrand"))
    {
      fvh = 32;
      if ((paramInt & 0x20) != 0)
      {
        GMTrace.o(12965566742528L, 96601);
        return true;
      }
      GMTrace.o(12965566742528L, 96601);
      return false;
    }
    GMTrace.o(12965566742528L, 96601);
    return false;
  }
  
  static final class a
    extends Error
  {
    LinkedList<Pair<Thread, StackTraceElement[]>> fvw;
    
    private a(a.a.a.a parama, LinkedList<Pair<Thread, StackTraceElement[]>> paramLinkedList)
    {
      super(parama);
      GMTrace.i(12977243684864L, 96688);
      this.fvw = paramLinkedList;
      GMTrace.o(12977243684864L, 96688);
    }
    
    private static String a(Thread paramThread)
    {
      GMTrace.i(12977780555776L, 96692);
      paramThread = paramThread.getName() + " (prio:" + paramThread.getPriority() + " tid:" + paramThread.getId() + " state:" + paramThread.getState() + ")";
      GMTrace.o(12977780555776L, 96692);
      return paramThread;
    }
    
    static a g(String paramString, boolean paramBoolean)
    {
      GMTrace.i(12977512120320L, 96690);
      Object localObject1 = Looper.getMainLooper().getThread();
      LinkedList localLinkedList = new LinkedList();
      Object localObject2 = new TreeMap(new Comparator() {});
      Iterator localIterator = Thread.getAllStackTraces().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (((localEntry.getKey() == localObject1) || ((((Thread)localEntry.getKey()).getName().startsWith(paramString)) && ((paramBoolean) || (((StackTraceElement[])localEntry.getValue()).length > 0)))) && (localEntry.getValue() != null) && (((StackTraceElement[])localEntry.getValue()).length > 0))
        {
          ((Map)localObject2).put(localEntry.getKey(), localEntry.getValue());
          if (localEntry.getKey() == localObject1) {
            localLinkedList.addFirst(new Pair(localObject1, localEntry.getValue()));
          } else {
            localLinkedList.addLast(new Pair(localEntry.getKey(), localEntry.getValue()));
          }
        }
      }
      if (!((Map)localObject2).containsKey(localObject1))
      {
        v.i("MicroMsg.ANRError", "summeranr getAllStackTraces not return mainthread[%s, %d] put in now", new Object[] { ((Thread)localObject1).getName(), Long.valueOf(((Thread)localObject1).getId()) });
        ((Map)localObject2).put(localObject1, ((Thread)localObject1).getStackTrace());
        localLinkedList.addFirst(new Pair(localObject1, ((Thread)localObject1).getStackTrace()));
      }
      localObject1 = ((Map)localObject2).entrySet().iterator();
      for (paramString = null; ((Iterator)localObject1).hasNext(); paramString = new a.a.a.a((a)localObject2, paramString, (byte)0))
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localObject2 = new a(a((Thread)((Map.Entry)localObject2).getKey()), (StackTraceElement[])((Map.Entry)localObject2).getValue());
        localObject2.getClass();
      }
      paramString = new a(paramString, localLinkedList);
      GMTrace.o(12977512120320L, 96690);
      return paramString;
    }
    
    static a nY()
    {
      GMTrace.i(12977646338048L, 96691);
      Object localObject2 = Looper.getMainLooper().getThread();
      StackTraceElement[] arrayOfStackTraceElement = ((Thread)localObject2).getStackTrace();
      if (arrayOfStackTraceElement == null) {}
      for (int i = -1;; i = arrayOfStackTraceElement.length)
      {
        v.i("MicroMsg.ANRError", "summeranr NewMainOnly mainStackTrace size[%d]", new Object[] { Integer.valueOf(i) });
        new TreeMap().put(localObject2, arrayOfStackTraceElement);
        Object localObject1 = new LinkedList();
        ((LinkedList)localObject1).addFirst(new Pair(localObject2, arrayOfStackTraceElement));
        localObject2 = new a(a((Thread)localObject2), arrayOfStackTraceElement);
        localObject2.getClass();
        localObject1 = new a(new a.a.a.a((a)localObject2, null, (byte)0), (LinkedList)localObject1);
        GMTrace.o(12977646338048L, 96691);
        return (a)localObject1;
      }
    }
    
    public final Throwable fillInStackTrace()
    {
      GMTrace.i(12977377902592L, 96689);
      super.fillInStackTrace();
      GMTrace.o(12977377902592L, 96689);
      return this;
    }
    
    static final class a
      implements Serializable
    {
      public final StackTraceElement[] fvy;
      public final String name;
      
      public a(String paramString, StackTraceElement[] paramArrayOfStackTraceElement)
      {
        GMTrace.i(12998181650432L, 96844);
        this.name = paramString;
        this.fvy = paramArrayOfStackTraceElement;
        GMTrace.o(12998181650432L, 96844);
      }
      
      final class a
        extends Throwable
      {
        private a(a parama)
        {
          super(parama);
          GMTrace.i(12962882387968L, 96581);
          GMTrace.o(12962882387968L, 96581);
        }
        
        public final Throwable fillInStackTrace()
        {
          GMTrace.i(12963016605696L, 96582);
          setStackTrace(a.a.a.this.fvy);
          GMTrace.o(12963016605696L, 96582);
          return this;
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void b(a.a parama);
  }
  
  static final class c
    implements Runnable
  {
    public volatile int fvA;
    private final Runnable fvB;
    
    c()
    {
      GMTrace.i(12998450085888L, 96846);
      this.fvA = 0;
      this.fvB = new Runnable()
      {
        public final void run()
        {
          GMTrace.i(12973619806208L, 96661);
          a.c.this.fvA = ((a.c.this.fvA + 1) % Integer.MAX_VALUE);
          if (a.c.this.fvA % a.fvq == 0)
          {
            SharedPreferences localSharedPreferences = aa.getContext().getSharedPreferences("system_config_prefs", 4);
            int i = localSharedPreferences.getInt("main_thread_watch_enable", 65535);
            int j = localSharedPreferences.getInt("main_thread_watch_timeout", 0);
            int k = localSharedPreferences.getInt("main_thread_watch_log_loop", 0);
            int m = localSharedPreferences.getInt("main_thread_watch_report", 0);
            v.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ticker tname[%s], tick[%d] enable[%d], timeout[%d], loop[%d], report[%d]", new Object[] { Thread.currentThread().getName(), Integer.valueOf(a.c.this.fvA), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
            if (a.g(a.fvv, i))
            {
              if ((j > 0) && (j != a.fvp))
              {
                v.i("MicroMsg.ANRWatchDog.summeranr", "summeranr reset timeout[%d, %d] by new setting", new Object[] { Integer.valueOf(a.fvp), Integer.valueOf(j) });
                a.fvp = j;
              }
              if ((k > 0) && (k != a.fvq))
              {
                v.i("MicroMsg.ANRWatchDog.summeranr", "summeranr reset loop[%d, %d] by new setting", new Object[] { Integer.valueOf(a.fvq), Integer.valueOf(k) });
                a.fvq = k;
                GMTrace.o(12973619806208L, 96661);
              }
            }
            else
            {
              g.oSF.a(510L, 12L, 1L, true);
              if (a.fvu != null) {
                a.fvu.interrupt();
              }
              v.i("MicroMsg.ANRWatchDog.summeranr", "summeranr disable by new setting and interrupt watch");
            }
          }
          GMTrace.o(12973619806208L, 96661);
        }
      };
      GMTrace.o(12998450085888L, 96846);
    }
    
    public final void run()
    {
      GMTrace.i(12998584303616L, 96847);
      g.oSF.a(510L, 0L, 1L, true);
      Thread localThread = Thread.currentThread();
      v.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread[%s]", new Object[] { localThread });
      int i = -1;
      for (;;)
      {
        if (!localThread.isInterrupted())
        {
          int j = this.fvA;
          a.fvo.post(this.fvB);
          try
          {
            Thread.sleep(a.fvp);
            if (this.fvA != j) {
              continue;
            }
            if ((!a.fvt) && (Debug.isDebuggerConnected()))
            {
              if (this.fvA != i) {
                v.w("MicroMsg.ANRWatchDog.summeranr", "summeranr An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
              }
              i = this.fvA;
            }
          }
          catch (InterruptedException localInterruptedException1)
          {
            a.fvn.a(localInterruptedException1);
            v.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread sleep and interrupted[%b]", new Object[] { Boolean.valueOf(localThread.isInterrupted()) });
            GMTrace.o(12998584303616L, 96847);
            return;
          }
          a.fvo.removeCallbacks(this.fvB);
          v.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread detect anr CpuUsage[%d, %d, %d]", new Object[] { Long.valueOf(a.fvj.ry()), Long.valueOf(a.fvj.rz()), Long.valueOf(a.fvj.rx()) });
          try
          {
            Thread.sleep(1000L);
            v.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread detect anr new sThreadNamePrefix[%s],lastTick tick[%d, %d], current[%d]", new Object[] { a.fvr, Integer.valueOf(j), Integer.valueOf(this.fvA), Long.valueOf(System.currentTimeMillis()) });
            if (a.fvr != null)
            {
              a.a locala1 = a.a.g(a.fvr, a.fvs);
              g.oSF.a(510L, 1L, 1L, true);
              switch (a.fvh)
              {
              default: 
                if (a.fvi > 0) {
                  g.oSF.a(510L, 7L, 1L, true);
                }
                a.fvm.b(locala1);
                j = a.fvi + 1;
                a.fvi = j;
                if (j >= 10) {
                  a.fvi = 1;
                }
                l = a.cQ(a.fvi) * 5 * 60 * 1000;
                this.fvA = 0;
                v.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread set next detect sFibIndex[%d], sleepTime[%d], lastTick, tick[%d, %d]", new Object[] { Integer.valueOf(a.fvi), Long.valueOf(l), Integer.valueOf(0), Integer.valueOf(this.fvA) });
              }
            }
          }
          catch (InterruptedException localInterruptedException2)
          {
            for (;;)
            {
              try
              {
                long l;
                Thread.sleep(l);
                v.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread set next detect sFibIndex[%d], sleepTime[%d], lastTick, tick[%d, %d] wakeup", new Object[] { Integer.valueOf(a.fvi), Long.valueOf(l), Integer.valueOf(0), Integer.valueOf(this.fvA) });
              }
              catch (InterruptedException localInterruptedException3)
              {
                a.a locala2;
                a.fvn.a(localInterruptedException3);
                v.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread sleep and interrupted when wait for next detect[%b]", new Object[] { Boolean.valueOf(localThread.isInterrupted()) });
                GMTrace.o(12998584303616L, 96847);
                return;
              }
              localInterruptedException2 = localInterruptedException2;
              v.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread detect anr wait for GetCpuUsage interrupted[%b]", new Object[] { Boolean.valueOf(localThread.isInterrupted()) });
              continue;
              locala2 = a.a.nY();
              continue;
              g.oSF.a(510L, 2L, 1L, true);
              continue;
              g.oSF.a(510L, 3L, 1L, true);
              continue;
              g.oSF.a(510L, 4L, 1L, true);
              continue;
              g.oSF.a(510L, 5L, 1L, true);
              continue;
              g.oSF.a(510L, 6L, 1L, true);
              continue;
              g.oSF.a(510L, 13L, 1L, true);
            }
          }
        }
      }
      v.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread isInterrupted[%b]", new Object[] { Boolean.valueOf(localThread.isInterrupted()) });
      GMTrace.o(12998584303616L, 96847);
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(InterruptedException paramInterruptedException);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/app/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */