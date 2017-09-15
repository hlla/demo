package com.tencent.mm.modelmulti;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.HandlerThread;
import android.os.PowerManager;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.comm.WakerLock.IAutoUnlockCallback;
import com.tencent.mm.booter.f;
import com.tencent.mm.e.a.ah;
import com.tencent.mm.e.a.pi;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.anq;
import com.tencent.mm.protocal.c.anr;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.lt;
import com.tencent.mm.protocal.c.lu;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.bo;
import com.tencent.mm.y.k;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import junit.framework.Assert;

public final class r
{
  private static Boolean hLV;
  private WakerLock gJJ;
  public Queue<c> hLW;
  public Queue<c> hLX;
  public HashMap<c, Long> hLY;
  public c hLZ;
  public long hMa;
  
  static
  {
    GMTrace.i(13445529337856L, 100177);
    hLV = null;
    GMTrace.o(13445529337856L, 100177);
  }
  
  public r()
  {
    GMTrace.i(13441368588288L, 100146);
    this.hLW = new LinkedList();
    this.hLX = new LinkedList();
    this.hLY = new HashMap();
    this.hLZ = null;
    this.hMa = 0L;
    this.gJJ = null;
    GMTrace.o(13441368588288L, 100146);
  }
  
  public static boolean Hv()
  {
    GMTrace.i(13442710765568L, 100156);
    try
    {
      boolean bool = ((Boolean)PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager)aa.getContext().getSystemService("power"), new Object[0])).booleanValue();
      GMTrace.o(13442710765568L, 100156);
      return bool;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.report.c.oRz.a(99L, 45L, 1L, false);
      v.e("MicroMsg.SyncService", "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", new Object[] { Boolean.valueOf(true), bf.g(localException) });
      GMTrace.o(13442710765568L, 100156);
    }
    return true;
  }
  
  private void a(final c paramc)
  {
    GMTrace.i(13442576547840L, 100155);
    if (m.Hw())
    {
      v.e("MicroMsg.SyncService", "tryStart dkinit never do sync before init done :%s ", new Object[] { paramc });
      GMTrace.o(13442576547840L, 100155);
      return;
    }
    com.tencent.mm.kernel.h.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(13450763829248L, 100216);
        if (paramc != null)
        {
          if (!(paramc instanceof r.f)) {
            break label59;
          }
          r.this.hLX.add(paramc);
        }
        for (;;)
        {
          r.this.b(null);
          GMTrace.o(13450763829248L, 100216);
          return;
          label59:
          r.this.hLW.add(paramc);
        }
      }
    });
    GMTrace.o(13442576547840L, 100155);
  }
  
  public static void a(c paramc, long paramLong)
  {
    GMTrace.i(16089752797184L, 119878);
    if (paramc == null)
    {
      GMTrace.o(16089752797184L, 119878);
      return;
    }
    int i = bf.f((Integer)com.tencent.mm.plugin.report.c.a((int)bf.aA(paramLong), new int[] { 200, 500, 800, 1500, 3000, 5000, 10000, 30000, 60000, 90000 }, new Integer[] { Integer.valueOf(70), Integer.valueOf(71), Integer.valueOf(72), Integer.valueOf(73), Integer.valueOf(74), Integer.valueOf(75), Integer.valueOf(76), Integer.valueOf(77), Integer.valueOf(78), Integer.valueOf(79), Integer.valueOf(80) }));
    com.tencent.mm.plugin.report.c.oRz.a(99L, i, 1L, false);
    GMTrace.o(16089752797184L, 119878);
  }
  
  public static void a(e parame)
  {
    GMTrace.i(16089618579456L, 119877);
    com.tencent.mm.plugin.report.c.oRz.a(99L, parame.scene, 1L, false);
    com.tencent.mm.plugin.report.c.oRz.a(99L, 0L, 1L, false);
    parame = com.tencent.mm.plugin.report.c.oRz;
    if (com.tencent.mm.sdk.a.b.foreground) {}
    for (long l = 241L;; l = 242L)
    {
      parame.a(99L, l, 1L, false);
      GMTrace.o(16089618579456L, 119877);
      return;
    }
  }
  
  public static void a(boolean paramBoolean, anr paramanr, c paramc)
  {
    GMTrace.i(16089484361728L, 119876);
    com.tencent.mm.kernel.h.vJ();
    byte[] arrayOfByte4 = bf.PS(bf.mz((String)com.tencent.mm.kernel.h.vI().vr().get(8195, new byte[0])));
    byte[] arrayOfByte2 = com.tencent.mm.platformtools.n.a(paramanr.tmv);
    v.i("MicroMsg.SyncService", "processResp %s synckey req:%s  shouldMerge:%s", new Object[] { paramc, ad.ba(arrayOfByte4), Boolean.valueOf(paramBoolean) });
    v.i("MicroMsg.SyncService", "processResp %s synckey resp:%s", new Object[] { paramc, ad.ba(arrayOfByte2) });
    if ((paramanr.tmv != null) && (paramanr.tmv.tXB > 0))
    {
      if (paramBoolean)
      {
        byte[] arrayOfByte3 = ad.g(arrayOfByte4, arrayOfByte2);
        v.i("MicroMsg.SyncService", "processResp %s synckey merge:%s", new Object[] { paramc, ad.ba(arrayOfByte3) });
        byte[] arrayOfByte1;
        if (arrayOfByte3 != null)
        {
          arrayOfByte1 = arrayOfByte3;
          if (arrayOfByte3.length > 0) {}
        }
        else
        {
          arrayOfByte1 = arrayOfByte2;
        }
        paramanr.tmv = com.tencent.mm.platformtools.n.G(arrayOfByte1);
      }
      if (!Arrays.equals(arrayOfByte4, com.tencent.mm.platformtools.n.a(paramanr.tmv)))
      {
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vI().vr().set(8195, bf.bo(com.tencent.mm.platformtools.n.a(paramanr.tmv)));
        aa.getContext().getSharedPreferences("notify_sync_pref", 4).edit().putString("notify_sync_key_keybuf", bf.bo(com.tencent.mm.platformtools.n.a(paramanr.tmv))).commit();
        GMTrace.o(16089484361728L, 119876);
        return;
      }
      v.i("MicroMsg.SyncService", "processResp %s  Sync Key Not change, not save", new Object[] { paramc });
      GMTrace.o(16089484361728L, 119876);
      return;
    }
    com.tencent.mm.plugin.report.c.oRz.a(99L, 47L, 1L, false);
    GMTrace.o(16089484361728L, 119876);
  }
  
  public static void assertTrue(String paramString, boolean paramBoolean)
  {
    GMTrace.i(13441637023744L, 100148);
    if (paramBoolean)
    {
      GMTrace.o(13441637023744L, 100148);
      return;
    }
    v.e("MicroMsg.SyncService", "ASSERT now msg:%s", new Object[] { paramString });
    Assert.assertTrue(paramString, paramBoolean);
    GMTrace.o(13441637023744L, 100148);
  }
  
  private static boolean wI()
  {
    GMTrace.i(13441502806016L, 100147);
    if ((com.tencent.mm.kernel.a.uP()) || (!com.tencent.mm.kernel.h.vG().uV()))
    {
      GMTrace.o(13441502806016L, 100147);
      return false;
    }
    if (hLV != null)
    {
      boolean bool = hLV.booleanValue();
      GMTrace.o(13441502806016L, 100147);
      return bool;
    }
    hLV = Boolean.valueOf(true);
    GMTrace.o(13441502806016L, 100147);
    return true;
  }
  
  /* Error */
  public final void HC()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc2_w 371
    //   5: ldc_w 373
    //   8: invokestatic 62	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   11: aload_0
    //   12: getfield 92	com/tencent/mm/modelmulti/r:gJJ	Lcom/tencent/mars/comm/WakerLock;
    //   15: ifnull +13 -> 28
    //   18: aload_0
    //   19: getfield 92	com/tencent/mm/modelmulti/r:gJJ	Lcom/tencent/mars/comm/WakerLock;
    //   22: invokevirtual 378	com/tencent/mars/comm/WakerLock:isLocking	()Z
    //   25: ifne +65 -> 90
    //   28: aload_0
    //   29: getfield 92	com/tencent/mm/modelmulti/r:gJJ	Lcom/tencent/mars/comm/WakerLock;
    //   32: ifnonnull +44 -> 76
    //   35: ldc_w 380
    //   38: astore_1
    //   39: ldc -107
    //   41: ldc_w 382
    //   44: iconst_2
    //   45: anewarray 4	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: aload_1
    //   51: aastore
    //   52: dup
    //   53: iconst_1
    //   54: getstatic 227	com/tencent/mm/sdk/a/b:foreground	Z
    //   57: invokestatic 155	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   60: aastore
    //   61: invokestatic 385	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: ldc2_w 371
    //   67: ldc_w 373
    //   70: invokestatic 67	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   73: aload_0
    //   74: monitorexit
    //   75: return
    //   76: aload_0
    //   77: getfield 92	com/tencent/mm/modelmulti/r:gJJ	Lcom/tencent/mars/comm/WakerLock;
    //   80: invokevirtual 378	com/tencent/mars/comm/WakerLock:isLocking	()Z
    //   83: invokestatic 155	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   86: astore_1
    //   87: goto -48 -> 39
    //   90: aload_0
    //   91: getfield 92	com/tencent/mm/modelmulti/r:gJJ	Lcom/tencent/mars/comm/WakerLock;
    //   94: invokevirtual 388	com/tencent/mars/comm/WakerLock:unLock	()V
    //   97: ldc2_w 371
    //   100: ldc_w 373
    //   103: invokestatic 67	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   106: goto -33 -> 73
    //   109: astore_1
    //   110: aload_0
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	r
    //   38	49	1	localObject1	Object
    //   109	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	28	109	finally
    //   28	35	109	finally
    //   39	73	109	finally
    //   76	87	109	finally
    //   90	106	109	finally
  }
  
  public final int a(long paramLong, int paramInt, String paramString)
  {
    GMTrace.i(13441771241472L, 100149);
    boolean bool = wI();
    v.i("MicroMsg.SyncService", "dealWithSelectoru checkUse:%s selector:%d aiScene:%d xml:%s [%s] ", new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong), Integer.valueOf(paramInt), paramString, bf.bJP() });
    int j = 0;
    Object localObject;
    if ((0x100 & paramLong) != 0L)
    {
      localObject = new pi();
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
    }
    paramLong = 0xFFFFFFFFFFFFFEFF & paramLong & 0x5F;
    int i = j;
    if (paramLong != 0L)
    {
      i = j;
      if (com.tencent.mm.kernel.h.vG().uV())
      {
        com.tencent.mm.kernel.h.vJ();
        i = j;
        if (com.tencent.mm.kernel.h.vI().vr() != null)
        {
          com.tencent.mm.kernel.h.vJ();
          com.tencent.mm.kernel.h.vI().vr().set(8196, Long.valueOf(paramLong));
          if (bool) {
            break label301;
          }
          localObject = new l(paramInt);
          paramInt = localObject.hashCode();
          v.i("MicroMsg.SyncService", "dealWithSelector syncHash: %d", new Object[] { Integer.valueOf(paramInt) });
          com.tencent.mm.kernel.h.vJ();
          i = paramInt;
          if (!com.tencent.mm.kernel.h.vH().gXs.a((k)localObject, 0)) {
            v.w("MicroMsg.SyncService", "dealWithSelector doScene failed, hash: %d, zero hash will be return.", new Object[] { Integer.valueOf(paramInt) });
          }
        }
      }
    }
    label301:
    for (i = 0;; i = e(paramInt, 7, false))
    {
      if (!bf.mA(paramString))
      {
        localObject = new ah();
        ((ah)localObject).fDo.type = 3;
        ((ah)localObject).fDo.fDq = paramString;
        com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
      }
      GMTrace.o(13441771241472L, 100149);
      return i;
    }
  }
  
  public final void a(w.b paramb, int paramInt, long paramLong)
  {
    GMTrace.i(13441905459200L, 100150);
    boolean bool = wI();
    v.i("MicroMsg.SyncService", "triggerNotifyDataSync checkUse:%s resp:%s syncflag:%s recvtime:%s [%s]", new Object[] { Boolean.valueOf(bool), paramb, Integer.valueOf(paramInt), Long.valueOf(paramLong), bf.bJP() });
    if (!bool)
    {
      com.tencent.mm.kernel.h.vJ();
      com.tencent.mm.kernel.h.vH().gXs.a(new l(paramb, paramInt, paramLong), 0);
      GMTrace.o(13441905459200L, 100150);
      return;
    }
    a(new f(paramb, paramInt, paramLong));
    GMTrace.o(13441905459200L, 100150);
  }
  
  public final void b(final c paramc)
  {
    GMTrace.i(16089350144000L, 119875);
    com.tencent.mm.kernel.h.vL().D(new Runnable()
    {
      public final void run()
      {
        boolean bool1 = true;
        boolean bool2 = false;
        GMTrace.i(13446737297408L, 100186);
        if ((com.tencent.mm.kernel.a.uP()) || (!com.tencent.mm.kernel.h.vG().uV()))
        {
          v.w("MicroMsg.SyncService", "begin to doLoop but MMCore account has not ready or MMCore is hold.");
          GMTrace.o(13446737297408L, 100186);
          return;
        }
        if (paramc != null)
        {
          v.i("MicroMsg.SyncService", "finish proc:%s running:%s RunTime:%s ", new Object[] { paramc, r.this.hLZ, Long.valueOf(bf.aA(r.this.hMa)) });
          if (paramc != r.this.hLZ)
          {
            localObject = r.this.hLY.keySet().iterator();
            while (((Iterator)localObject).hasNext())
            {
              r.c localc = (r.c)((Iterator)localObject).next();
              v.w("MicroMsg.SyncService", "check unfinish proc :%s timediff:%s", new Object[] { localc, Long.valueOf(bf.aA(((Long)r.this.hLY.get(localc)).longValue())) });
            }
            l = bf.a((Long)r.this.hLY.remove(paramc), -1L);
            localObject = "oldproc timeout, should in timeoutMap:" + paramc;
            bool1 = bool2;
            if (l != -1L) {
              bool1 = true;
            }
            r.assertTrue((String)localObject, bool1);
            GMTrace.o(13446737297408L, 100186);
            return;
          }
          r.a(paramc, r.this.hMa);
          r.this.hLZ = null;
          r.this.hMa = 0L;
          r.this.HC();
        }
        if (r.this.hLZ != null)
        {
          l = bf.aA(r.this.hMa);
          if (l <= 90000L) {
            break label841;
          }
          v.w("MicroMsg.SyncService", "tryStart last proc:%s TIMEOUT:%s Run Next Now.", new Object[] { r.this.hLZ, Long.valueOf(l) });
          localObject = r.this.hLZ;
          if (!(localObject instanceof r.e)) {
            break label561;
          }
          com.tencent.mm.plugin.report.c.oRz.i(11098, new Object[] { Integer.valueOf(3571), com.tencent.mm.sdk.a.b.foreground + ";" + r.Hv() });
          localObject = com.tencent.mm.plugin.report.c.oRz;
          if (!com.tencent.mm.sdk.a.b.foreground) {
            break label554;
          }
        }
        label554:
        for (long l = 30L;; l = 34L)
        {
          ((com.tencent.mm.plugin.report.c)localObject).a(99L, l, 1L, false);
          r.this.hLY.put(r.this.hLZ, Long.valueOf(r.this.hMa));
          r.this.hLZ = null;
          r.this.hMa = 0L;
          r.this.HC();
          localObject = (com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.b.class);
          if (!((com.tencent.mm.plugin.zero.b.b)localObject).bCa().zX()) {
            break;
          }
          v.w("MicroMsg.SyncService", "Warning: Set SyncService Pause Now.");
          ((com.tencent.mm.plugin.zero.b.b)localObject).bCa().zV();
          GMTrace.o(13446737297408L, 100186);
          return;
        }
        label561:
        if ((localObject instanceof r.f))
        {
          com.tencent.mm.plugin.report.c.oRz.i(11098, new Object[] { Integer.valueOf(3572), com.tencent.mm.sdk.a.b.foreground + ";" + r.Hv() });
          localObject = com.tencent.mm.plugin.report.c.oRz;
          if (com.tencent.mm.sdk.a.b.foreground) {}
          for (l = 31L;; l = 35L)
          {
            ((com.tencent.mm.plugin.report.c)localObject).a(99L, l, 1L, false);
            break;
          }
        }
        if ((localObject instanceof r.d))
        {
          com.tencent.mm.plugin.report.c.oRz.i(11098, new Object[] { Integer.valueOf(3573), com.tencent.mm.sdk.a.b.foreground + ";" + r.Hv() });
          localObject = com.tencent.mm.plugin.report.c.oRz;
          if (com.tencent.mm.sdk.a.b.foreground) {}
          for (l = 32L;; l = 36L)
          {
            ((com.tencent.mm.plugin.report.c)localObject).a(99L, l, 1L, false);
            break;
          }
        }
        com.tencent.mm.plugin.report.c.oRz.i(11098, new Object[] { Integer.valueOf(3574), com.tencent.mm.sdk.a.b.foreground + ";" + r.Hv() });
        Object localObject = com.tencent.mm.plugin.report.c.oRz;
        if (com.tencent.mm.sdk.a.b.foreground) {}
        for (l = 33L;; l = 37L)
        {
          ((com.tencent.mm.plugin.report.c)localObject).a(99L, l, 1L, false);
          break;
        }
        label841:
        v.i("MicroMsg.SyncService", "tryStart last proc:%s running:%s ", new Object[] { r.this.hLZ, Long.valueOf(l) });
        GMTrace.o(13446737297408L, 100186);
        return;
        if (((com.tencent.mm.plugin.zero.b.b)localObject).bCa().zY())
        {
          v.w("MicroMsg.SyncService", "Warning: SyncService is Paused.");
          GMTrace.o(13446737297408L, 100186);
          return;
        }
        localObject = new r.d(r.this);
        if (((r.d)localObject).a(null))
        {
          r.this.jR("LightPush");
          r.this.hLZ = ((r.c)localObject);
          r.this.hMa = bf.NA();
          GMTrace.o(13446737297408L, 100186);
          return;
        }
        while (!r.this.hLX.isEmpty())
        {
          localObject = (r.c)r.this.hLX.poll();
          v.i("MicroMsg.SyncService", "tryStart check NotifyData ListSize:%s proc:%s", new Object[] { Integer.valueOf(r.this.hLX.size()), localObject });
          if ((localObject != null) && (((r.c)localObject).a(null)))
          {
            r.this.jR("NotifyData");
            r.this.hLZ = ((r.c)localObject);
            r.this.hMa = bf.NA();
            GMTrace.o(13446737297408L, 100186);
            return;
          }
        }
        if (!r.this.hLW.isEmpty())
        {
          localObject = (r.c)r.this.hLW.poll();
          v.i("MicroMsg.SyncService", "tryStart check Sync ListSize:%s proc:%s", new Object[] { Integer.valueOf(r.this.hLW.size()), localObject });
          if ((localObject != null) && (((r.c)localObject).a(r.this.hLW)))
          {
            r.this.jR("NetSync");
            r.this.hLZ = ((r.c)localObject);
            r.this.hMa = bf.NA();
            GMTrace.o(13446737297408L, 100186);
            return;
          }
        }
        v.i("MicroMsg.SyncService", "tryStart FINISH Check running:%s sync:%s notify:%s", new Object[] { r.this.hLZ, Integer.valueOf(r.this.hLW.size()), Integer.valueOf(r.this.hLX.size()) });
        if ((r.this.hLZ == null) && (r.this.hLW.isEmpty()) && (r.this.hLX.isEmpty())) {}
        for (;;)
        {
          r.assertTrue("", bool1);
          GMTrace.o(13446737297408L, 100186);
          return;
          bool1 = false;
        }
      }
    });
    GMTrace.o(16089350144000L, 119875);
  }
  
  public final int e(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    GMTrace.i(13442173894656L, 100152);
    e locale = new e(paramInt1, paramInt2, paramBoolean);
    a(locale);
    paramInt1 = locale.hashCode();
    GMTrace.o(13442173894656L, 100152);
    return paramInt1;
  }
  
  public final int gg(int paramInt)
  {
    GMTrace.i(13442039676928L, 100151);
    boolean bool = wI();
    v.i("MicroMsg.SyncService", "triggerSync checkUse:%s scene:%s [%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt), bf.bJP() });
    if (!bool)
    {
      l locall = new l(paramInt);
      com.tencent.mm.kernel.h.vJ();
      com.tencent.mm.kernel.h.vH().gXs.a(locall, 0);
      paramInt = locall.hashCode();
      GMTrace.o(13442039676928L, 100151);
      return paramInt;
    }
    paramInt = e(paramInt, 7, false);
    GMTrace.o(13442039676928L, 100151);
    return paramInt;
  }
  
  /* Error */
  public final void jR(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc2_w 508
    //   7: ldc_w 510
    //   10: invokestatic 62	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   13: ldc -107
    //   15: ldc_w 512
    //   18: iconst_3
    //   19: anewarray 4	java/lang/Object
    //   22: dup
    //   23: iconst_0
    //   24: aload_1
    //   25: aastore
    //   26: dup
    //   27: iconst_1
    //   28: aload_0
    //   29: getfield 92	com/tencent/mm/modelmulti/r:gJJ	Lcom/tencent/mars/comm/WakerLock;
    //   32: aastore
    //   33: dup
    //   34: iconst_2
    //   35: invokestatic 405	com/tencent/mm/sdk/platformtools/bf:bJP	()Lcom/tencent/mm/sdk/platformtools/ag;
    //   38: aastore
    //   39: invokestatic 286	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: aload_0
    //   43: getfield 92	com/tencent/mm/modelmulti/r:gJJ	Lcom/tencent/mars/comm/WakerLock;
    //   46: ifnonnull +25 -> 71
    //   49: aload_0
    //   50: new 375	com/tencent/mars/comm/WakerLock
    //   53: dup
    //   54: invokestatic 115	com/tencent/mm/sdk/platformtools/aa:getContext	()Landroid/content/Context;
    //   57: new 6	com/tencent/mm/modelmulti/r$1
    //   60: dup
    //   61: aload_0
    //   62: invokespecial 515	com/tencent/mm/modelmulti/r$1:<init>	(Lcom/tencent/mm/modelmulti/r;)V
    //   65: invokespecial 518	com/tencent/mars/comm/WakerLock:<init>	(Landroid/content/Context;Lcom/tencent/mars/comm/WakerLock$IAutoUnlockCallback;)V
    //   68: putfield 92	com/tencent/mm/modelmulti/r:gJJ	Lcom/tencent/mars/comm/WakerLock;
    //   71: aload_0
    //   72: getfield 92	com/tencent/mm/modelmulti/r:gJJ	Lcom/tencent/mars/comm/WakerLock;
    //   75: invokevirtual 378	com/tencent/mars/comm/WakerLock:isLocking	()Z
    //   78: ifne +39 -> 117
    //   81: ldc_w 520
    //   84: iload_2
    //   85: invokestatic 521	com/tencent/mm/modelmulti/r:assertTrue	(Ljava/lang/String;Z)V
    //   88: getstatic 227	com/tencent/mm/sdk/a/b:foreground	Z
    //   91: ifne +14 -> 105
    //   94: aload_0
    //   95: getfield 92	com/tencent/mm/modelmulti/r:gJJ	Lcom/tencent/mars/comm/WakerLock;
    //   98: ldc2_w 522
    //   101: aload_1
    //   102: invokevirtual 526	com/tencent/mars/comm/WakerLock:lock	(JLjava/lang/String;)V
    //   105: ldc2_w 508
    //   108: ldc_w 510
    //   111: invokestatic 67	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   114: aload_0
    //   115: monitorexit
    //   116: return
    //   117: iconst_0
    //   118: istore_2
    //   119: goto -38 -> 81
    //   122: astore_1
    //   123: aload_0
    //   124: monitorexit
    //   125: aload_1
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	r
    //   0	127	1	paramString	String
    //   1	118	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	71	122	finally
    //   71	81	122	finally
    //   81	105	122	finally
    //   105	114	122	finally
  }
  
  final class a
  {
    public int hKd;
    public boolean hMe;
    public anr hMf;
    public r.b hMg;
    public r.c hMh;
    ai hMi;
    
    public a(r.c paramc, boolean paramBoolean, anr paramanr, r.b paramb)
    {
      GMTrace.i(13441100152832L, 100144);
      this.hKd = 0;
      this.hMe = false;
      this.hMf = null;
      this.hMg = null;
      this.hMi = new ai(com.tencent.mm.kernel.h.vL().nIe.getLooper(), new ai.a()
      {
        public final boolean oQ()
        {
          GMTrace.i(13440965935104L, 100143);
          if ((com.tencent.mm.kernel.h.vG().uV()) && (!com.tencent.mm.kernel.a.uP()))
          {
            com.tencent.mm.kernel.h.vJ();
            if (com.tencent.mm.kernel.h.vI() != null)
            {
              com.tencent.mm.kernel.h.vJ();
              if (com.tencent.mm.kernel.h.vI().vr() != null) {
                break label130;
              }
            }
          }
          Object localObject = r.a.this.hMh;
          boolean bool1 = com.tencent.mm.kernel.h.vG().uV();
          boolean bool2 = com.tencent.mm.kernel.a.uP();
          com.tencent.mm.kernel.h.vJ();
          v.e("MicroMsg.SyncService", "processResp %s accready:%s hold:%s accstg:%s ", new Object[] { localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2), com.tencent.mm.kernel.h.vI() });
          r.a.this.hMg.gh(0);
          GMTrace.o(13440965935104L, 100143);
          return false;
          label130:
          localObject = r.a.this.hMf.tmy.jLs;
          com.tencent.mm.plugin.zero.c localc = new com.tencent.mm.plugin.zero.c();
          localc.aX(r.a.this.hMh);
          long l1 = bf.NA();
          long l2;
          do
          {
            if (r.a.this.hKd >= ((LinkedList)localObject).size()) {
              break;
            }
            ((LinkedList)localObject).size();
            if (!localc.a((lt)((LinkedList)localObject).get(r.a.this.hKd), false)) {
              com.tencent.mm.plugin.report.c.oRz.a(99L, 46L, 1L, false);
            }
            r.a locala = r.a.this;
            locala.hKd += 1;
            l2 = bf.aA(l1);
            v.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s", new Object[] { r.a.this.hMh, Long.valueOf(l2), Integer.valueOf(((LinkedList)localObject).size()), Integer.valueOf(r.a.this.hKd - 1) });
          } while (l2 < 500L);
          localc.aY(r.a.this.hMh);
          if (r.a.this.hKd < ((LinkedList)localObject).size())
          {
            v.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s Shold Continue.", new Object[] { r.a.this.hMh, Long.valueOf(bf.aA(l1)), Integer.valueOf(((LinkedList)localObject).size()), Integer.valueOf(r.a.this.hKd - 1) });
            GMTrace.o(13440965935104L, 100143);
            return true;
          }
          r.a(r.a.this.hMe, r.a.this.hMf, r.a.this.hMh);
          r.a.this.hMg.gh(((LinkedList)localObject).size());
          GMTrace.o(13440965935104L, 100143);
          return false;
        }
      }, true);
      this.hMg = paramb;
      this.hMh = paramc;
      this.hMe = paramBoolean;
      this.hMf = paramanr;
      this.hKd = 0;
      if ((this.hMg != null) && (this.hMh != null)) {}
      for (boolean bool = true;; bool = false)
      {
        r.assertTrue("", bool);
        if (this.hMf != null) {
          break;
        }
        r.assertTrue("resp Not null", false);
        v.w("MicroMsg.SyncService", "CmdProcHandler %s NewSyncResponse is null", new Object[] { this.hMh });
        this.hMg.gh(0);
        GMTrace.o(13441100152832L, 100144);
        return;
      }
      if ((com.tencent.mm.kernel.h.vG().uV()) && (!com.tencent.mm.kernel.a.uP()))
      {
        com.tencent.mm.kernel.h.vJ();
        if (com.tencent.mm.kernel.h.vI() != null)
        {
          com.tencent.mm.kernel.h.vJ();
          if (com.tencent.mm.kernel.h.vI().vr() != null) {
            break label289;
          }
        }
      }
      this$1 = this.hMh;
      paramBoolean = com.tencent.mm.kernel.h.vG().uV();
      bool = com.tencent.mm.kernel.a.uP();
      com.tencent.mm.kernel.h.vJ();
      v.e("MicroMsg.SyncService", "CmdProcHandler %s accready:%s hold:%s accstg:%s ", new Object[] { r.this, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), com.tencent.mm.kernel.h.vI() });
      this.hMg.gh(0);
      GMTrace.o(13441100152832L, 100144);
      return;
      label289:
      int i;
      if ((paramanr.tmy == null) || (paramanr.tmy.jLs == null) || (paramanr.tmy.jLs.size() <= 0))
      {
        i = 0;
        int j = bf.f((Integer)com.tencent.mm.plugin.report.c.a(i, new int[] { 0, 1, 2, 3, 5, 10 }, new Integer[] { Integer.valueOf(249), Integer.valueOf(248), Integer.valueOf(247), Integer.valueOf(246), Integer.valueOf(245), Integer.valueOf(244), Integer.valueOf(243) }));
        com.tencent.mm.plugin.report.c.oRz.a(99L, j, 1L, false);
        if (r.Hv()) {
          break label749;
        }
        this$1 = com.tencent.mm.plugin.report.c.oRz;
        if (i <= 0) {
          break label741;
        }
      }
      label741:
      for (long l1 = 221L;; l1 = 218L)
      {
        r.this.a(99L, l1, 1L, false);
        long l2 = paramanr.tRj;
        l1 = l2;
        if (String.valueOf(l2).length() == 10) {
          l1 = l2 * 1000L;
        }
        l2 = System.currentTimeMillis();
        long l3 = l2 - l1;
        v.i("MicroMsg.SyncService", "[oneliang] client time is:%s,server time is:%s,diff time is:%s, diff second time is:%s,just save millisecond diff time", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l3 / 1000L) });
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vI().vr().a(com.tencent.mm.storage.w.a.uFA, Long.valueOf(l3));
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vG().aF(this.hMf.jLP, this.hMf.tRi);
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vG();
        com.tencent.mm.kernel.a.eM(this.hMf.jLP);
        if ((this.hMf.tmy != null) && (this.hMf.tmy.jLs != null) && (this.hMf.tmy.jLs.size() > 0)) {
          break label827;
        }
        v.w("MicroMsg.SyncService", "CmdProcHandler %s cmdlist is null.  synckey may be changed, I have to merge it.", new Object[] { this.hMh });
        r.a(paramBoolean, this.hMf, this.hMh);
        this.hMg.gh(0);
        GMTrace.o(13441100152832L, 100144);
        return;
        i = paramanr.tmy.jLs.size();
        break;
      }
      label749:
      if (!com.tencent.mm.sdk.a.b.foreground)
      {
        this$1 = com.tencent.mm.plugin.report.c.oRz;
        if (i > 0) {}
        for (l1 = 220L;; l1 = 217L)
        {
          r.this.a(99L, l1, 1L, false);
          break;
        }
      }
      this$1 = com.tencent.mm.plugin.report.c.oRz;
      if (i > 0) {}
      for (l1 = 219L;; l1 = 216L)
      {
        r.this.a(99L, l1, 1L, false);
        break;
      }
      label827:
      v.i("MicroMsg.SyncService", "CmdProcHandler %s Start docmd:%s respStatus:%s respOnlineVer:%s", new Object[] { this.hMh, Integer.valueOf(this.hMf.tmy.jLs.size()), Integer.valueOf(this.hMf.jLP), Integer.valueOf(this.hMf.tRi) });
      this.hMi.v(50L, 50L);
      GMTrace.o(13441100152832L, 100144);
    }
  }
  
  static abstract interface b
  {
    public abstract boolean gh(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract boolean a(Queue<c> paramQueue);
  }
  
  final class d
    implements r.c
  {
    d()
    {
      GMTrace.i(13445931991040L, 100180);
      GMTrace.o(13445931991040L, 100180);
    }
    
    public final boolean a(Queue<r.c> paramQueue)
    {
      GMTrace.i(13446066208768L, 100181);
      Object localObject = new PInt();
      com.tencent.mm.kernel.h.vJ();
      com.tencent.mm.kernel.h.vG();
      paramQueue = f.a((PInt)localObject, com.tencent.mm.kernel.a.uH());
      int j = ((PInt)localObject).value;
      if (paramQueue != null) {}
      for (final int i = paramQueue.length;; i = -1)
      {
        v.i("MicroMsg.SyncService", "%s index:%d, buf.len:%d ", new Object[] { this, Integer.valueOf(j), Integer.valueOf(i) });
        if ((((PInt)localObject).value != 0) && (!bf.bm(paramQueue))) {
          break;
        }
        GMTrace.o(13446066208768L, 100181);
        return false;
      }
      i = ((PInt)localObject).value;
      try
      {
        localObject = new w.b();
        ((w.b)localObject).y(paramQueue);
        paramQueue = ((w.b)localObject).sYx;
        if (paramQueue == null)
        {
          GMTrace.o(13446066208768L, 100181);
          return false;
        }
      }
      catch (Exception paramQueue)
      {
        for (;;)
        {
          com.tencent.mm.plugin.report.c.oRz.a(99L, 38L, 1L, false);
          v.e("MicroMsg.SyncService", "%s index:%s Resp fromProtoBuf failed ", new Object[] { this, Integer.valueOf(i) });
          com.tencent.mm.kernel.h.vJ();
          com.tencent.mm.kernel.h.vG();
          f.ay(i, com.tencent.mm.kernel.a.uH());
          paramQueue = null;
        }
      }
      catch (Error paramQueue)
      {
        for (;;)
        {
          com.tencent.mm.plugin.report.c.oRz.a(99L, 39L, 1L, false);
          long l1 = Runtime.getRuntime().freeMemory() / 1000L;
          long l2 = Runtime.getRuntime().totalMemory() / 1000L;
          v.i("MicroMsg.SyncService", "%s index:%s memoryInfo avail/total, dalvik[%dk, %dk, user:%dk]", new Object[] { this, Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1) });
          r.assertTrue("LightPush memory error", false);
          paramQueue = null;
        }
        com.tencent.mm.plugin.report.c.oRz.a(99L, 20L, 1L, false);
        new r.a(r.this, this, true, paramQueue, new r.b()
        {
          public final boolean gh(int paramAnonymousInt)
          {
            GMTrace.i(13445797773312L, 100179);
            v.i("MicroMsg.SyncService", "%s onFinishCmd index:%s ", new Object[] { r.d.this, Integer.valueOf(i) });
            paramAnonymousInt = i;
            com.tencent.mm.kernel.h.vJ();
            com.tencent.mm.kernel.h.vG();
            f.ay(paramAnonymousInt, com.tencent.mm.kernel.a.uH());
            r.this.b(r.d.this);
            GMTrace.o(13445797773312L, 100179);
            return true;
          }
        });
        GMTrace.o(13446066208768L, 100181);
      }
      return true;
    }
    
    public final String toString()
    {
      GMTrace.i(13446200426496L, 100182);
      String str = "LightPush[" + hashCode() + "]";
      GMTrace.o(13446200426496L, 100182);
      return str;
    }
  }
  
  final class e
    extends k
    implements r.c, j
  {
    public int cCe;
    public com.tencent.mm.y.e hMm;
    public boolean hMn;
    private boolean hMo;
    private p htc;
    public int scene;
    
    public e(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      GMTrace.i(13432912871424L, 100083);
      this.hMo = false;
      this.scene = paramInt1;
      this.cCe = paramInt2;
      this.hMn = paramBoolean;
      GMTrace.o(13432912871424L, 100083);
    }
    
    public final boolean BL()
    {
      GMTrace.i(13433315524608L, 100086);
      GMTrace.o(13433315524608L, 100086);
      return false;
    }
    
    public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
    {
      GMTrace.i(13433181306880L, 100085);
      this.hMm = parame1;
      int i = a(parame, this.htc, this);
      GMTrace.o(13433181306880L, 100085);
      return i;
    }
    
    public final void a(int paramInt1, int paramInt2, int paramInt3, final String paramString, p paramp, byte[] paramArrayOfByte)
    {
      GMTrace.i(13433449742336L, 100087);
      if ((paramp == null) || (paramp.getType() != 138))
      {
        com.tencent.mm.plugin.report.c.oRz.a(99L, 44L, 1L, false);
        if (paramp == null) {}
        for (paramInt1 = -2;; paramInt1 = paramp.getType())
        {
          v.e("MicroMsg.SyncService", "%s onGYNetEnd error type:%d", new Object[] { this, Integer.valueOf(paramInt1) });
          GMTrace.o(13433449742336L, 100087);
          return;
        }
      }
      if (this.hMo)
      {
        v.e("MicroMsg.SyncService", "%s onGYNetEnd has been callback  , give up  ", new Object[] { this });
        GMTrace.o(13433449742336L, 100087);
        return;
      }
      this.hMo = true;
      if (paramp == this.htc) {}
      for (boolean bool = true;; bool = false)
      {
        r.assertTrue("Check rr failed.", bool);
        bool = true;
        if ((paramInt2 != 0) || (paramInt3 != 0))
        {
          v.e("MicroMsg.SyncService", "%s onGYNetEnd scene error Callback [%s,%s,%s ] rr:%s", new Object[] { this, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramp });
          if ((paramInt2 != 4) || (paramInt3 != 63530)) {
            break;
          }
          v.w("MicroMsg.SyncService", "%s onGYNetEnd MM_ERR_KEYBUF_INVALID , not merge key buf", new Object[] { this });
          com.tencent.mm.plugin.report.c.oRz.a(99L, 42L, 1L, false);
          bool = false;
        }
        paramString = ((w.b)paramp.zg()).sYx;
        new r.a(r.this, this, bool, paramString, new r.b()
        {
          public final boolean gh(int paramAnonymousInt)
          {
            GMTrace.i(13437073620992L, 100114);
            com.tencent.mm.kernel.h.vJ();
            com.tencent.mm.kernel.h.vI().vr().set(8196, Long.valueOf(paramString.tkt));
            boolean bool;
            if ((paramString.tkt & r.e.this.cCe) != 0)
            {
              bool = true;
              v.i("MicroMsg.SyncService", "%s onFinishCmd ContinueFlag:%s canCont:%s SNSSYNCKEY:%s", new Object[] { r.e.this, Integer.valueOf(paramString.tkt), Boolean.valueOf(bool), Integer.valueOf(paramString.tkt & 0x100) });
              if ((!bool) && ((paramString.tkt & 0x100) != 0))
              {
                pi localpi = new pi();
                com.tencent.mm.sdk.b.a.uql.m(localpi);
              }
              if (bool)
              {
                if ((paramAnonymousInt != 0) || (!r.e.this.hMn)) {
                  break label229;
                }
                v.w("MicroMsg.SyncService", "%s onFinishCmd is continue Sync , but no Cmd , I will not continue again.", new Object[] { r.e.this });
              }
            }
            for (;;)
            {
              r.e.this.hMm.a(0, 0, "", r.e.this);
              r.this.b(r.e.this);
              GMTrace.o(13437073620992L, 100114);
              return true;
              bool = false;
              break;
              label229:
              r.this.e(r.e.this.scene, r.e.this.cCe, true);
            }
          }
        });
        GMTrace.o(13433449742336L, 100087);
        return;
      }
      com.tencent.mm.plugin.report.c.oRz.i(11098, new Object[] { Integer.valueOf(3501), this.scene + ";" + paramInt2 + ";" + paramInt3 + ";" + com.tencent.mm.sdk.a.b.foreground + ";" + r.Hv() });
      com.tencent.mm.plugin.report.c.oRz.a(99L, 43L, 1L, false);
      this.hMm.a(paramInt2, paramInt3, paramString, this);
      r.this.b(this);
      GMTrace.o(13433449742336L, 100087);
    }
    
    public final boolean a(Queue<r.c> paramQueue)
    {
      GMTrace.i(13432644435968L, 100081);
      int i = this.scene;
      int j = this.cCe;
      boolean bool1 = this.hMn;
      Object localObject;
      label91:
      boolean bool2;
      label97:
      boolean bool3;
      if (paramQueue == null)
      {
        localObject = "null";
        v.i("MicroMsg.SyncService", "%s begin run scene:%s selector:%s isContinue:%s List:%s", new Object[] { this, Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), localObject });
        if (paramQueue == null) {
          break label482;
        }
        if ((paramQueue != null) && (!paramQueue.isEmpty())) {
          break label251;
        }
        bool1 = false;
        bool2 = false;
        if (paramQueue.isEmpty()) {
          break label472;
        }
        localObject = (e)paramQueue.poll();
        this.cCe |= ((e)localObject).cCe;
        if (((e)localObject).scene != 3) {
          break label450;
        }
        bool3 = true;
      }
      for (;;)
      {
        v.i("MicroMsg.SyncService", "%s pop:%s[%s] scene:%s selector:%s iscontinue:%s hashcont:%s hasBgfg:%s", new Object[] { this, Integer.valueOf(paramQueue.size()), localObject, Integer.valueOf(((e)localObject).scene), Integer.valueOf(((e)localObject).cCe), Boolean.valueOf(((e)localObject).hMn), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        bool1 = bool3;
        break label97;
        localObject = Integer.valueOf(paramQueue.size());
        break;
        label251:
        if (paramQueue.size() >= 5) {
          com.tencent.mm.plugin.report.c.oRz.i(11098, new Object[] { Integer.valueOf(3590), paramQueue.size() + ";" + com.tencent.mm.sdk.a.b.foreground + ";" + r.Hv() });
        }
        i = bf.f((Integer)com.tencent.mm.plugin.report.c.a(paramQueue.size(), new int[] { 1, 2, 3, 4, 5, 10 }, new Integer[] { Integer.valueOf(60), Integer.valueOf(61), Integer.valueOf(62), Integer.valueOf(63), Integer.valueOf(64), Integer.valueOf(65), Integer.valueOf(66) }));
        com.tencent.mm.plugin.report.c.oRz.a(99L, i, 1L, false);
        break label91;
        label450:
        bool3 = bool1;
        if (((e)localObject).hMn)
        {
          bool2 = true;
          bool3 = bool1;
        }
      }
      label472:
      if (bool1) {
        this.scene = 3;
      }
      for (;;)
      {
        label482:
        if ((com.tencent.mm.kernel.h.vG().uV()) && (!com.tencent.mm.kernel.a.uP()))
        {
          com.tencent.mm.kernel.h.vJ();
          if (com.tencent.mm.kernel.h.vI() != null)
          {
            com.tencent.mm.kernel.h.vJ();
            if (com.tencent.mm.kernel.h.vI().vr() != null) {
              break;
            }
          }
        }
        bool1 = com.tencent.mm.kernel.h.vG().uV();
        bool2 = com.tencent.mm.kernel.a.uP();
        com.tencent.mm.kernel.h.vJ();
        v.e("MicroMsg.SyncService", "%s accready:%s hold:%s accstg:%s ", new Object[] { this, Boolean.valueOf(bool1), Boolean.valueOf(bool2), com.tencent.mm.kernel.h.vI() });
        GMTrace.o(13432644435968L, 100081);
        return false;
        if (bool2) {
          this.scene = 6;
        }
      }
      com.tencent.mm.kernel.h.vJ();
      long l = bf.a((Long)com.tencent.mm.kernel.h.vI().vr().get(8196, null), 0L);
      if (l != 0L)
      {
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vI().vr().set(8196, Long.valueOf(0L));
        this.cCe = ((int)(this.cCe | l));
        this.cCe &= 0x5F;
      }
      if (this.scene == 3)
      {
        i = 1;
        if (this.scene != 1010) {
          break label1050;
        }
        this.cCe |= 0x10;
        this.scene = 7;
      }
      for (;;)
      {
        if (this.hMn) {
          this.scene = 6;
        }
        this.htc = new l.a();
        paramQueue = ((com.tencent.mm.protocal.w.a)this.htc.BG()).sYw;
        paramQueue.tRh = i;
        paramQueue.tmu = this.cCe;
        paramQueue.tcg = this.scene;
        com.tencent.mm.kernel.h.vJ();
        localObject = bf.mz((String)com.tencent.mm.kernel.h.vI().vr().get(8195, new byte[0]));
        paramQueue.tmv = com.tencent.mm.platformtools.n.G(bf.PS((String)localObject));
        paramQueue.tRg = new lu();
        paramQueue.tfX = d.DEVICE_TYPE;
        v.i("MicroMsg.SyncService", "%s continueFlag:%s SyncMsgDigest:%s Selector:%d Scene:%d device:%s", new Object[] { this, Long.valueOf(l), Integer.valueOf(paramQueue.tRh), Integer.valueOf(paramQueue.tmu), Integer.valueOf(this.scene), paramQueue.tfX });
        v.i("MicroMsg.SyncService", "%s Req synckey %s", new Object[] { this, ad.ba(bf.PS((String)localObject)) });
        r.a(this);
        com.tencent.mm.kernel.h.vJ();
        if (com.tencent.mm.kernel.h.vH().gXs.a(this, 0)) {
          break label1108;
        }
        com.tencent.mm.plugin.report.c.oRz.i(11098, new Object[] { Integer.valueOf(3500), this.scene + ";" + com.tencent.mm.sdk.a.b.foreground + ";" + r.Hv() });
        v.e("MicroMsg.SyncService", "%s NetSceneQueue doScene failed. ", new Object[] { this });
        com.tencent.mm.plugin.report.c.oRz.a(99L, 41L, 1L, false);
        GMTrace.o(13432644435968L, 100081);
        return false;
        i = 0;
        break;
        label1050:
        if (this.scene == 1011)
        {
          this.cCe |= 0x40;
          this.scene = 7;
        }
        else if (this.scene == 3)
        {
          this.cCe |= 0x40000;
          this.scene = 3;
        }
      }
      label1108:
      GMTrace.o(13432644435968L, 100081);
      return true;
    }
    
    public final int getType()
    {
      GMTrace.i(13433047089152L, 100084);
      GMTrace.o(13433047089152L, 100084);
      return 138;
    }
    
    public final String toString()
    {
      GMTrace.i(13432778653696L, 100082);
      String str = "NetSync[" + hashCode() + "]";
      GMTrace.o(13432778653696L, 100082);
      return str;
    }
  }
  
  final class f
    implements r.c
  {
    int hJN;
    anr hMf;
    long hMr;
    
    public f(w.b paramb, int paramInt, long paramLong)
    {
      GMTrace.i(13438415798272L, 100124);
      if (paramb == null) {}
      for (this$1 = null;; this$1 = paramb.sYx)
      {
        this.hMf = r.this;
        this.hMr = paramLong;
        this.hJN = paramInt;
        GMTrace.o(13438415798272L, 100124);
        return;
      }
    }
    
    public final boolean a(Queue<r.c> paramQueue)
    {
      GMTrace.i(13438550016000L, 100125);
      if (this.hMf == null)
      {
        com.tencent.mm.plugin.report.c.oRz.a(99L, 40L, 1L, false);
        v.e("MicroMsg.SyncService", "%s run resp == null", new Object[] { this });
        GMTrace.o(13438550016000L, 100125);
        return false;
      }
      if (10018 == com.tencent.mm.platformtools.r.iiC)
      {
        v.e("MicroMsg.SyncService", "%s Give up for test", new Object[] { this });
        GMTrace.o(13438550016000L, 100125);
        return false;
      }
      new r.a(r.this, this, true, this.hMf, new r.b()
      {
        public final boolean gh(int paramAnonymousInt)
        {
          GMTrace.i(13440563281920L, 100140);
          v.i("MicroMsg.SyncService", "%s onFinishCmd resp:%s pushSycnFlag:%s recvTime:%s", new Object[] { r.f.this, r.f.this.hMf, Integer.valueOf(r.f.this.hJN), Long.valueOf(r.f.this.hMr) });
          if ((r.f.this.hJN & 0x1) > 0)
          {
            com.tencent.mm.kernel.h.vJ();
            byte[] arrayOfByte = bf.PS(bf.mz((String)com.tencent.mm.kernel.h.vI().vr().get(8195, null)));
            com.tencent.mm.kernel.h.vd().a(new h(r.f.this.hMr, arrayOfByte), 0);
          }
          r.this.b(r.f.this);
          GMTrace.o(13440563281920L, 100140);
          return true;
        }
      });
      com.tencent.mm.plugin.report.c.oRz.a(99L, 21L, 1L, false);
      GMTrace.o(13438550016000L, 100125);
      return true;
    }
    
    public final String toString()
    {
      GMTrace.i(13438684233728L, 100126);
      String str = "NotifyData[" + hashCode() + "]";
      GMTrace.o(13438684233728L, 100126);
      return str;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelmulti/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */