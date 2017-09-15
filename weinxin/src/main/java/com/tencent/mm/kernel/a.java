package com.tencent.mm.kernel;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteException;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.bv;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.al;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.aq;
import com.tencent.mm.u.bu;
import com.tencent.mm.y.n;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class a
{
  private static boolean gWT;
  private static boolean gWU;
  static b gWW;
  private static String gWX;
  private static String gWY;
  private static int gXd;
  public com.tencent.mm.kernel.api.c gWR;
  public final com.tencent.mm.y.v gWS;
  byte[] gWV;
  public com.tencent.mm.u.a gWZ;
  public int gXa;
  public int gXb;
  public List<al> gXc;
  volatile int gXe;
  public volatile boolean gXf;
  private String gXg;
  private Map<String, Integer> gXh;
  
  static
  {
    GMTrace.i(13531965554688L, 100821);
    gWT = true;
    gWU = false;
    gWW = new b();
    gWX = "NoResetUinStack";
    gWY = null;
    gXd = -1;
    GMTrace.o(13531965554688L, 100821);
  }
  
  public a(com.tencent.mm.kernel.api.c paramc)
  {
    GMTrace.i(13527267934208L, 100786);
    this.gWV = new byte[0];
    this.gXa = 0;
    this.gXc = new LinkedList();
    this.gXe = a.gXl;
    this.gXf = false;
    this.gXg = "";
    this.gXh = new HashMap();
    Assert.assertNotNull(gWW);
    h.vJ();
    if (bf.f((Integer)h.vI().gXM.get(17)) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      gWT = bool;
      this.gWS = new com.tencent.mm.y.v();
      com.tencent.mm.protocal.i.c.a.sXC = new aq(702);
      this.gWR = paramc;
      GMTrace.o(13527267934208L, 100786);
      return;
    }
  }
  
  public static void aQ(boolean paramBoolean)
  {
    GMTrace.i(13529012764672L, 100799);
    gWU = paramBoolean;
    GMTrace.o(13529012764672L, 100799);
  }
  
  static boolean eL(int paramInt)
  {
    GMTrace.i(13528073240576L, 100792);
    if (paramInt != 0)
    {
      GMTrace.o(13528073240576L, 100792);
      return true;
    }
    GMTrace.o(13528073240576L, 100792);
    return false;
  }
  
  public static void eM(int paramInt)
  {
    GMTrace.i(13530086506496L, 100807);
    if ((gXd != -1) && (gXd == paramInt))
    {
      GMTrace.o(13530086506496L, 100807);
      return;
    }
    gXd = paramInt;
    uT().edit().putInt("notification.user.state", paramInt).commit();
    com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreAccount", "[NOTIFICATION SETTINGS]save UserStatus: %d", new Object[] { Integer.valueOf(paramInt) });
    GMTrace.o(13530086506496L, 100807);
  }
  
  public static boolean eN(int paramInt)
  {
    GMTrace.i(13530489159680L, 100810);
    if ((paramInt & 0x1) != 0)
    {
      GMTrace.o(13530489159680L, 100810);
      return true;
    }
    GMTrace.o(13530489159680L, 100810);
    return false;
  }
  
  public static String ea(String paramString)
  {
    GMTrace.i(13527670587392L, 100789);
    gWY = paramString;
    GMTrace.o(13527670587392L, 100789);
    return paramString;
  }
  
  public static void eb(String paramString)
  {
    GMTrace.i(13527939022848L, 100791);
    gWX = paramString;
    GMTrace.o(13527939022848L, 100791);
  }
  
  public static int ec(String paramString)
  {
    GMTrace.i(13531562901504L, 100818);
    h.vJ();
    if (h.vG().gXh.get(paramString) == null) {}
    int j;
    for (int i = 0;; i = ((Integer)h.vG().gXh.get(paramString)).intValue())
    {
      j = (int)bf.Nz();
      if (i != 0) {
        break;
      }
      h.vJ();
      h.vG().gXh.put(paramString, Integer.valueOf(j));
      GMTrace.o(13531562901504L, 100818);
      return i;
      h.vJ();
    }
    i = j - i;
    h.vJ();
    h.vG().gXh.put(paramString, Integer.valueOf(j));
    if (i >= 0)
    {
      GMTrace.o(13531562901504L, 100818);
      return i;
    }
    GMTrace.o(13531562901504L, 100818);
    return 0;
  }
  
  public static void hold()
  {
    GMTrace.i(13529281200128L, 100801);
    h.vJ();
    if (h.vG() != null)
    {
      h.vJ();
      h.vG();
    }
    for (String str = o.getString(gWW.uH());; str = "-1")
    {
      com.tencent.mm.sdk.platformtools.v.w("MMKernel.CoreAccount", " HOLD ACCOUNT! uin:%s stack:%s init:%b", new Object[] { str, bf.bJP(), Boolean.valueOf(h.vG().uV()) });
      gWT = true;
      h.vJ();
      h.vI().gXM.set(17, Integer.valueOf(1));
      GMTrace.o(13529281200128L, 100801);
      return;
    }
  }
  
  public static int uH()
  {
    GMTrace.i(13527402151936L, 100787);
    int i = gWW.uH();
    GMTrace.o(13527402151936L, 100787);
    return i;
  }
  
  public static String uI()
  {
    GMTrace.i(13527536369664L, 100788);
    String str = gWY;
    GMTrace.o(13527536369664L, 100788);
    return str;
  }
  
  public static String uJ()
  {
    GMTrace.i(13527804805120L, 100790);
    String str = gWX;
    GMTrace.o(13527804805120L, 100790);
    return str;
  }
  
  protected static void uK()
  {
    GMTrace.i(13528207458304L, 100793);
    gWW.dj(0);
    GMTrace.o(13528207458304L, 100793);
  }
  
  protected static void uL()
  {
    GMTrace.i(13528341676032L, 100794);
    gWW.dj(0);
    GMTrace.o(13528341676032L, 100794);
  }
  
  private void uM()
  {
    GMTrace.i(13528475893760L, 100795);
    this.gXe = a.gXl;
    this.gXf = false;
    com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreAccount", "mAccountStatus to NotReady");
    aa.getContext().getSharedPreferences(aa.bIN(), 0).edit().putBoolean("isLogin", false).commit();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
    com.tencent.mm.sdk.platformtools.v.w("MMKernel.CoreAccount", "[arthurdan.AccountNR] account storage reset! uin:%d, resetStack is:%s, resetTime:%s", new Object[] { Integer.valueOf(gWW.uH()), gWX, localSimpleDateFormat.format(new Date()) });
    GMTrace.o(13528475893760L, 100795);
  }
  
  public static boolean uO()
  {
    GMTrace.i(13528878546944L, 100798);
    boolean bool = gWU;
    GMTrace.o(13528878546944L, 100798);
    return bool;
  }
  
  public static boolean uP()
  {
    GMTrace.i(13529146982400L, 100800);
    if (gWT)
    {
      h.vJ();
      if (h.vG() == null) {
        break label86;
      }
      h.vJ();
      h.vG();
    }
    label86:
    for (String str = o.getString(gWW.uH());; str = "-1")
    {
      com.tencent.mm.sdk.platformtools.v.w("MMKernel.CoreAccount", "account holded :%s init:%b", new Object[] { str, Boolean.valueOf(h.vG().uV()) });
      boolean bool = gWT;
      GMTrace.o(13529146982400L, 100800);
      return bool;
    }
  }
  
  public static int uS()
  {
    GMTrace.i(13530220724224L, 100808);
    int i = uT().getInt("notification.user.state", 0);
    GMTrace.o(13530220724224L, 100808);
    return i;
  }
  
  public static SharedPreferences uT()
  {
    GMTrace.i(13530354941952L, 100809);
    SharedPreferences localSharedPreferences = aa.getContext().getSharedPreferences("notify_key_pref_settings", 4);
    GMTrace.o(13530354941952L, 100809);
    return localSharedPreferences;
  }
  
  public static boolean uU()
  {
    GMTrace.i(13530891812864L, 100813);
    if (gWW.uH() != 0)
    {
      GMTrace.o(13530891812864L, 100813);
      return true;
    }
    GMTrace.o(13530891812864L, 100813);
    return false;
  }
  
  public static int uX()
  {
    GMTrace.i(13531160248320L, 100815);
    int i = Integer.valueOf(aa.getContext().getSharedPreferences("system_config_prefs", 4).getInt("default_uin", 0)).intValue();
    GMTrace.o(13531160248320L, 100815);
    return i;
  }
  
  public static String uY()
  {
    GMTrace.i(13531294466048L, 100816);
    h.vJ();
    if (bf.mA(h.vG().gXg)) {
      uZ();
    }
    h.vJ();
    String str = h.vG().gXg;
    GMTrace.o(13531294466048L, 100816);
    return str;
  }
  
  public static void uZ()
  {
    GMTrace.i(13531428683776L, 100817);
    h.vJ();
    h.vG().gXg = (p.rB() + "_" + System.currentTimeMillis());
    h.vJ();
    h.vG().gXh.clear();
    GMTrace.o(13531428683776L, 100817);
  }
  
  public static void unhold()
  {
    GMTrace.i(13529415417856L, 100802);
    h.vJ();
    if (h.vG() != null)
    {
      h.vJ();
      h.vG();
    }
    for (String str = o.getString(gWW.uH());; str = "-1")
    {
      com.tencent.mm.sdk.platformtools.v.w("MMKernel.CoreAccount", " UN HOLD ACCOUNT! uin:%s init:%b", new Object[] { str, Boolean.valueOf(h.vG().uV()) });
      gWT = false;
      h.vJ();
      h.vI().gXM.set(17, Integer.valueOf(0));
      GMTrace.o(13529415417856L, 100802);
      return;
    }
  }
  
  public final void aF(int paramInt1, int paramInt2)
  {
    GMTrace.i(13529952288768L, 100806);
    if ((this.gXa != paramInt1) || (this.gXb != paramInt2)) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.sdk.platformtools.v.d("MMKernel.CoreAccount", "online status, %d, %d, %d ,%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.gXb), Integer.valueOf(this.gXa) });
      if (i != 0) {
        break;
      }
      GMTrace.o(13529952288768L, 100806);
      return;
    }
    this.gXa = paramInt1;
    this.gXb = paramInt2;
    new ad(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(13502303436800L, 100600);
        a.this.uR();
        GMTrace.o(13502303436800L, 100600);
      }
    });
    GMTrace.o(13529952288768L, 100806);
  }
  
  final void aP(boolean paramBoolean)
  {
    GMTrace.i(18924296994816L, 140997);
    com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreAccount", "UserStatusChange: clear");
    int k;
    int j;
    for (;;)
    {
      synchronized (this.gXc)
      {
        this.gXc.clear();
        ??? = h.vL();
        if (Thread.currentThread().getId() == ((ae)???).nIe.getId())
        {
          i = 1;
          if ((i == 0) || (h.vL().bIZ())) {
            break label245;
          }
          i = 1;
          if (i != 0) {
            h.vL().bIY();
          }
          long l1 = System.currentTimeMillis();
          k = gWW.uH();
          com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreAccount", "dkacc setAccuin %s hash:%d thread:%d[%s] stack:%s", new Object[] { o.getString(k), Integer.valueOf(com.tencent.mm.a.h.aw(k, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), bf.bJP() });
          if (k == 0) {
            break label250;
          }
          j = 1;
          if (j != 0) {
            break;
          }
          com.tencent.mm.sdk.platformtools.v.w("MMKernel.CoreAccount", "setAccUin, Reset by MMCore.resetAccUin");
          com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreAccount", "start time check setUinImpl end total time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
          if (i != 0) {
            h.vL().bJa();
          }
          com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreAccount", "mAccountStatus to AccountHasReady");
          GMTrace.o(18924296994816L, 140997);
          return;
        }
      }
      int i = 0;
      continue;
      label245:
      i = 0;
      continue;
      label250:
      j = 0;
    }
    if (uV()) {
      uN();
    }
    o.getString(k);
    h.vJ();
    ??? = h.vI();
    final Object localObject3 = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(13534381473792L, 100839);
        a.this.gXe = a.a.gXm;
        GMTrace.o(13534381473792L, 100839);
      }
    };
    aa.getContext().getSharedPreferences(aa.bIN(), 0).edit().putBoolean("isLogin", true).commit();
    String str1 = com.tencent.mm.a.g.n(("mm" + k).getBytes());
    ((e)???).gXV = (((e)???).gXU + str1 + "/");
    ((e)???).cachePath = (w.hgg + str1 + "/");
    Object localObject4 = new File(((e)???).cachePath);
    com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreStorage", "dkacc cachePath:" + ((e)???).cachePath + " accPath:" + ((e)???).gXV);
    final long l2;
    if (!((File)localObject4).exists())
    {
      com.tencent.mm.sdk.platformtools.v.w("MMKernel.CoreStorage", "setUin REBUILD data now ! DO NOT FUCKING TELL ME DB BROKEN !!! uin:%s data:%s sd:%s", new Object[] { o.getString(k), ((e)???).cachePath, ((e)???).gXV });
      ((File)localObject4).mkdirs();
      if (!((e)???).cachePath.equalsIgnoreCase(((e)???).gXV))
      {
        l2 = System.currentTimeMillis();
        localObject4 = new File(((e)???).gXV);
        str1 = str1 + "temp" + System.currentTimeMillis();
        str1 = com.tencent.mm.compatible.util.e.hgk + str1;
        ((File)localObject4).renameTo(new File(str1));
        com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreStorage", "find the old files and rename then %s" + (System.currentTimeMillis() - l2), new Object[] { str1 });
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      ((e)???).gYa = new bu(((e)???).cachePath, bool1);
      ((e)???).vm();
      localObject4 = ((e)???).cachePath + "MicroMsg.db";
      str1 = ((e)???).cachePath + "EnMicroMsg.db";
      String str2 = ((e)???).cachePath + "EnMicroMsg2.db";
      ((e)???).cQ(null);
      ((e)???).gXW = new com.tencent.mm.bj.g(new e.2((e)???));
      if (!((e)???).gXW.a((String)localObject4, str1, str2, k, p.rA(), ((e)???).uh(), true)) {
        throw new SQLiteException("main db init failed");
      }
      String str3 = ((e)???).gXW.uKk;
      if (!bf.mA(str3))
      {
        com.tencent.mm.sdk.platformtools.v.e("MMKernel.CoreStorage", "dbinit failed :" + str3);
        com.tencent.mm.sdk.a.b.r("init db Failed: [ " + str3 + "]", "DBinit");
      }
      ((e)???).gXY = new t(((e)???).gXW);
      ((e)???).gXX = new com.tencent.mm.bj.g(((e)???).gXR);
      if (!((e)???).gXX.a((String)localObject4, str1, str2, k, p.rA(), new HashMap(), true)) {
        throw new com.tencent.mm.u.b((byte)0);
      }
      ((e)???).gXZ = new ba(((e)???).gXY);
      ((e)???).gXZ.c(new e.3((e)???));
      ((e)???).gXZ.bMJ();
      ((Runnable)localObject3).run();
      ((e)???).gXN.onDataBaseOpened(((e)???).gXW, ((e)???).gXX);
      aa.getContext().getSharedPreferences(aa.bIN() + k, 0);
      boolean bool2 = ((e)???).vl();
      com.tencent.mm.sdk.platformtools.v.d("MMKernel.CoreStorage", "edw setAccUin, needTransfer = " + bool2);
      if (bool1)
      {
        l2 = ((Long)((e)???).gXY.get(w.a.uDD, Long.valueOf(0L))).longValue();
        j = ((Integer)((e)???).gXY.get(w.a.uDE, Integer.valueOf(0))).intValue();
        if (l2 > 0L)
        {
          com.tencent.mm.sdk.platformtools.v.w("MMKernel.CoreStorage", "summerinstall new install but firsttime[%d] > 0", new Object[] { Long.valueOf(l2) });
          label1181:
          if (j <= 0) {
            break label1439;
          }
          com.tencent.mm.sdk.platformtools.v.w("MMKernel.CoreStorage", "summerinstall new install but version[%d] > 0", new Object[] { Integer.valueOf(j) });
          label1205:
          com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreStorage", "edw setAccUin, summerinstall time[%d]，version[%d], clientversion[%d]", new Object[] { (Long)((e)???).gXY.get(w.a.uDD, Long.valueOf(0L)), (Integer)((e)???).gXY.get(w.a.uDE, Integer.valueOf(0)), Integer.valueOf(d.sXh) });
        }
      }
      else
      {
        com.tencent.mm.sdk.platformtools.v.d("MMKernel.CoreStorage", "edw postDataTransfer begin");
        if (paramBoolean) {
          break label1464;
        }
        h.vJ();
        ??? = bf.mz((String)h.vI().vr().get(2, null));
        com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreAccount", "summerinit validateUsername username[%s]", new Object[] { ??? });
        if (((String)???).length() > 0) {
          break label1459;
        }
        com.tencent.mm.sdk.platformtools.v.e("MMKernel.CoreAccount", "username of acc stg not set: uin=" + gWW.uH());
        uM();
        gWW.dj(0);
        gWX = bf.bJP().toString();
        ae.v(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(16766881234944L, 124923);
            h.vJ().releaseAll();
            GMTrace.o(16766881234944L, 124923);
          }
        });
      }
      label1439:
      label1459:
      for (j = 0;; j = 1)
      {
        if (j != 0) {
          break label1464;
        }
        com.tencent.mm.plugin.report.c.oRz.a(598L, 21L, 1L, true);
        com.tencent.mm.sdk.platformtools.v.w("MMKernel.CoreAccount", "setAccUin, validateUsername false no need initialize!");
        break;
        ((e)???).gXY.a(w.a.uDD, Long.valueOf(System.currentTimeMillis()));
        break label1181;
        ((e)???).gXY.a(w.a.uDE, Integer.valueOf(d.sXh));
        break label1205;
      }
      label1464:
      h.vJ();
      ??? = h.vI();
      localObject3 = new e.f();
      j = bf.f((Integer)((e)???).gXY.get(14, null));
      int m = d.sXh;
      if (m == j) {
        paramBoolean = false;
      }
      for (;;)
      {
        label1513:
        if (paramBoolean)
        {
          ((e)???).gXY.set(8197, "");
          ((e)???).gXY.set(15, Integer.valueOf(0));
        }
        if (j != m)
        {
          bool1 = true;
          label1553:
          if ((j > 620822536) || (j == m)) {
            break label2286;
          }
          ((e)???).gXY.set(274480, Boolean.valueOf(true));
          com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreStorage", "[initialize] need init emoji");
          label1590:
          if ((j != 0) && (j < 637599744)) {
            ((e)???).gXY.set(348162, Boolean.valueOf(true));
          }
          if (j == m) {
            break label2313;
          }
          bool2 = true;
          label1625:
          if (!bool2) {
            break label2319;
          }
          com.tencent.mm.sdk.platformtools.v.w("MMKernel.CoreStorage", "account storage version changed from " + Integer.toHexString(j) + " to " + Integer.toHexString(m) + ", init=" + paramBoolean);
          if (((Integer)((e)???).gXM.get(37, Integer.valueOf(0))).intValue() == 0) {
            ((e)???).gXM.set(37, Integer.valueOf(j));
          }
          ((e)???).gXY.set(14, Integer.valueOf(m));
          ((e)???).gXY.set(30, Boolean.valueOf(false));
          ((e)???).gXY.set(-2046825377, Boolean.valueOf(false));
          ((e)???).gXY.set(-2046825369, Boolean.valueOf(false));
          ((e)???).gXY.set(54, Boolean.valueOf(false));
          ((e)???).gXY.set(-2046825368, Boolean.valueOf(false));
          ((e)???).gXY.set(-2046825366, Boolean.valueOf(true));
          ((e)???).gXY.set(62, Boolean.valueOf(true));
          aa.getContext().getSharedPreferences("update_config_prefs", 4).edit().clear().commit();
          if ((j & 0xFF00) == (m & 0xFF00)) {
            ac.Ps("show_whatsnew");
          }
          label1881:
          ((e)???).gXO.aR(bool2);
          ((e.f)localObject3).gYp = bool1;
          ((e.f)localObject3).gYq = j;
          com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreAccount", "check is update :%b ", new Object[] { Boolean.valueOf(((e.f)localObject3).gYp) });
          com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized tid:%d, stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), bf.bJP() });
          l2 = System.currentTimeMillis();
          if (!ae.isMainThread()) {
            break label2329;
          }
          com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized main tid[%d] post to worker tid[%d], stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Long.valueOf(h.vL().nIe.getLooper().getThread().getId()), bf.bJP() });
          h.vL().H(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(13496934727680L, 100560);
              com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized run tid[%d]", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
              a.this.gWR.onAccountInitialized(localObject3);
              a.this.uW();
              com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized run tid[%d] take[%d]ms", new Object[] { Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - l2) });
              GMTrace.o(13496934727680L, 100560);
            }
          });
        }
        for (;;)
        {
          ao.hlE.L("last_login_uin", o.getString(k));
          com.tencent.mm.plugin.report.c.oRz.dj(k);
          this.gWZ = new com.tencent.mm.u.a();
          com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreAccount", "setAccUin done :%s", new Object[] { o.getString(k) });
          h.vJ();
          if (h.vH().gXs == null) {
            break;
          }
          h.vJ();
          if (h.vH().gXs.hsI == null) {
            break;
          }
          h.vJ();
          h.vH().gXs.hsI.ba(true);
          h.vJ();
          ??? = h.vH().gXs.hsI.Cc();
          if ((k == 0) || (??? == null) || (k == ((com.tencent.mm.network.c)???).uH())) {
            break;
          }
          com.tencent.mm.sdk.platformtools.v.w("MMKernel.CoreAccount", "summerauth update acc info with acc stg: old acc uin=%d, this uin=%d", new Object[] { Integer.valueOf(((com.tencent.mm.network.c)???).uH()), Integer.valueOf(k) });
          com.tencent.mm.plugin.report.c.oRz.a(148L, 46L, 1L, false);
          ((com.tencent.mm.network.c)???).dj(k);
          break;
          if ((m > 570425344) && (j <= 570425344))
          {
            paramBoolean = true;
            break label1513;
          }
          if ((m <= 570556456) || (j > 570556456)) {
            break label2383;
          }
          paramBoolean = true;
          break label1513;
          bool1 = false;
          break label1553;
          label2286:
          ((e)???).gXY.set(274480, Boolean.valueOf(false));
          com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreStorage", "[initialize] need not init emoji");
          break label1590;
          label2313:
          bool2 = false;
          break label1625;
          label2319:
          ac.Ps("show_whatsnew");
          break label1881;
          label2329:
          this.gWR.onAccountInitialized((e.f)localObject3);
          uW();
          com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized run tid[%d] take[%d]ms", new Object[] { Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - l2) });
        }
        label2383:
        paramBoolean = false;
      }
    }
  }
  
  public final void initialize()
  {
    GMTrace.i(13530757595136L, 100812);
    if (uV())
    {
      GMTrace.o(13530757595136L, 100812);
      return;
    }
    synchronized (this.gWV)
    {
      if (uV())
      {
        GMTrace.o(13530757595136L, 100812);
        return;
      }
      int i = gWW.uH();
      if (i != 0)
      {
        com.tencent.mm.sdk.platformtools.v.w("MMKernel.CoreAccount", "auto set up account storage uin: %d, stack: %s", new Object[] { Integer.valueOf(i), bf.bJP() });
        aP(false);
      }
      GMTrace.o(13530757595136L, 100812);
      return;
    }
  }
  
  public final void release()
  {
    GMTrace.i(13530623377408L, 100811);
    synchronized (this.gWV)
    {
      uN();
      GMTrace.o(13530623377408L, 100811);
      return;
    }
  }
  
  final void uN()
  {
    GMTrace.i(13528610111488L, 100796);
    com.tencent.mm.sdk.platformtools.v.w("MMKernel.CoreAccount", "account storage release  uin:%s thread:%s stack:%s", new Object[] { o.getString(gWW.uH()), Thread.currentThread().getName(), bf.bJP() });
    if (!uV())
    {
      com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreAccount", "Fatal crash error!!! status is not initialized when release(), this callStack is:%s, last reset stack is:%s", new Object[] { bf.bJP().toString(), gWX });
      GMTrace.o(13528610111488L, 100796);
      return;
    }
    this.gWR.onAccountRelease();
    h.vJ();
    h.vI().cQ(null);
    uM();
    h.vJ();
    h.vI().gYb.clear();
    GMTrace.o(13528610111488L, 100796);
  }
  
  public final void uQ()
  {
    GMTrace.i(13529549635584L, 100803);
    if (!uV()) {
      throw new com.tencent.mm.u.b();
    }
    GMTrace.o(13529549635584L, 100803);
  }
  
  public final void uR()
  {
    GMTrace.i(13529818071040L, 100805);
    new ad(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(13524717797376L, 100767);
        al[] arrayOfal = new al[a.this.gXc.size()];
        a.this.gXc.toArray(arrayOfal);
        int j = arrayOfal.length;
        int i = 0;
        while (i < j)
        {
          arrayOfal[i].yP();
          i += 1;
        }
        GMTrace.o(13524717797376L, 100767);
      }
    });
    GMTrace.o(13529818071040L, 100805);
  }
  
  public final boolean uV()
  {
    GMTrace.i(13531026030592L, 100814);
    if (this.gXe == a.gXm)
    {
      GMTrace.o(13531026030592L, 100814);
      return true;
    }
    GMTrace.o(13531026030592L, 100814);
    return false;
  }
  
  public final void uW()
  {
    GMTrace.i(16767015452672L, 124924);
    com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreAccount", "summerasyncinit setInitializedNotifyAllDone[%b] to true stack[%s]", new Object[] { Boolean.valueOf(this.gXf), bf.bJP() });
    this.gXf = true;
    bv localbv = new bv();
    com.tencent.mm.sdk.b.a.uql.m(localbv);
    GMTrace.o(16767015452672L, 124924);
  }
  
  private static enum a
  {
    static
    {
      GMTrace.i(13506195750912L, 100629);
      gXl = 1;
      gXm = 2;
      gXn = new int[] { gXl, gXm };
      GMTrace.o(13506195750912L, 100629);
    }
  }
  
  static final class b
  {
    private static boolean gXq;
    private boolean gXo;
    s gXp;
    private int uin;
    
    static
    {
      GMTrace.i(13526194192384L, 100778);
      gXq = true;
      GMTrace.o(13526194192384L, 100778);
    }
    
    b()
    {
      GMTrace.i(13525254668288L, 100771);
      this.uin = 0;
      this.gXo = false;
      GMTrace.o(13525254668288L, 100771);
    }
    
    private static void a(s params, int paramInt)
    {
      GMTrace.i(13525791539200L, 100775);
      com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreAccount", "setSysUin uin: %d, stack: %s", new Object[] { Integer.valueOf(paramInt), bf.bJP() });
      aa.getContext().getSharedPreferences("system_config_prefs", 4).edit().putInt("default_uin", paramInt).commit();
      params.set(1, Integer.valueOf(paramInt));
      GMTrace.o(13525791539200L, 100775);
    }
    
    /* Error */
    private void va()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_1
      //   2: aload_0
      //   3: monitorenter
      //   4: ldc2_w 107
      //   7: ldc 109
      //   9: invokestatic 25	com/tencent/gmtrace/GMTrace:i	(JI)V
      //   12: aload_0
      //   13: getfield 111	com/tencent/mm/kernel/a$b:gXp	Lcom/tencent/mm/storage/s;
      //   16: invokestatic 117	junit/framework/Assert:assertNotNull	(Ljava/lang/Object;)V
      //   19: aload_0
      //   20: getfield 111	com/tencent/mm/kernel/a$b:gXp	Lcom/tencent/mm/storage/s;
      //   23: astore 5
      //   25: aload 5
      //   27: ifnonnull +26 -> 53
      //   30: ldc 48
      //   32: ldc 119
      //   34: invokestatic 123	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   37: aload_0
      //   38: iload_1
      //   39: putfield 39	com/tencent/mm/kernel/a$b:uin	I
      //   42: ldc2_w 107
      //   45: ldc 109
      //   47: invokestatic 30	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   50: aload_0
      //   51: monitorexit
      //   52: return
      //   53: aload 5
      //   55: iconst_1
      //   56: invokevirtual 127	com/tencent/mm/storage/s:get	(I)Ljava/lang/Object;
      //   59: checkcast 52	java/lang/Integer
      //   62: astore_3
      //   63: aload_3
      //   64: astore_2
      //   65: aload_3
      //   66: ifnonnull +154 -> 220
      //   69: aload 5
      //   71: getfield 130	com/tencent/mm/storage/s:uxm	Z
      //   74: ifeq +17 -> 91
      //   77: getstatic 136	com/tencent/mm/plugin/report/c:oRz	Lcom/tencent/mm/plugin/report/c;
      //   80: ldc2_w 137
      //   83: ldc2_w 139
      //   86: lconst_1
      //   87: iconst_0
      //   88: invokevirtual 143	com/tencent/mm/plugin/report/c:a	(JJJZ)V
      //   91: invokestatic 73	com/tencent/mm/sdk/platformtools/aa:getContext	()Landroid/content/Context;
      //   94: ldc 75
      //   96: iconst_4
      //   97: invokevirtual 81	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
      //   100: ldc 89
      //   102: iconst_0
      //   103: invokeinterface 147 3 0
      //   108: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   111: astore 4
      //   113: aload_3
      //   114: astore_2
      //   115: aload 4
      //   117: ifnull +103 -> 220
      //   120: ldc 48
      //   122: ldc -107
      //   124: iconst_3
      //   125: anewarray 4	java/lang/Object
      //   128: dup
      //   129: iconst_0
      //   130: aload_3
      //   131: aastore
      //   132: dup
      //   133: iconst_1
      //   134: aload 4
      //   136: aastore
      //   137: dup
      //   138: iconst_2
      //   139: aload 5
      //   141: getfield 130	com/tencent/mm/storage/s:uxm	Z
      //   144: invokestatic 154	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   147: aastore
      //   148: invokestatic 67	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   151: getstatic 27	com/tencent/mm/kernel/a$b:gXq	Z
      //   154: ifeq +53 -> 207
      //   157: ldc 48
      //   159: ldc -100
      //   161: iconst_2
      //   162: anewarray 4	java/lang/Object
      //   165: dup
      //   166: iconst_0
      //   167: aload 4
      //   169: aastore
      //   170: dup
      //   171: iconst_1
      //   172: invokestatic 62	com/tencent/mm/sdk/platformtools/bf:bJP	()Lcom/tencent/mm/sdk/platformtools/ag;
      //   175: aastore
      //   176: invokestatic 158	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   179: getstatic 136	com/tencent/mm/plugin/report/c:oRz	Lcom/tencent/mm/plugin/report/c;
      //   182: sipush 11911
      //   185: iconst_1
      //   186: anewarray 4	java/lang/Object
      //   189: dup
      //   190: iconst_0
      //   191: aload 4
      //   193: invokestatic 162	com/tencent/mm/sdk/platformtools/bf:f	(Ljava/lang/Integer;)I
      //   196: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   199: aastore
      //   200: invokevirtual 165	com/tencent/mm/plugin/report/c:i	(I[Ljava/lang/Object;)V
      //   203: iconst_0
      //   204: putstatic 27	com/tencent/mm/kernel/a$b:gXq	Z
      //   207: aload 5
      //   209: aload 4
      //   211: invokevirtual 169	java/lang/Integer:intValue	()I
      //   214: invokestatic 171	com/tencent/mm/kernel/a$b:a	(Lcom/tencent/mm/storage/s;I)V
      //   217: aload 4
      //   219: astore_2
      //   220: ldc 48
      //   222: ldc -83
      //   224: iconst_1
      //   225: anewarray 4	java/lang/Object
      //   228: dup
      //   229: iconst_0
      //   230: aload_2
      //   231: invokestatic 162	com/tencent/mm/sdk/platformtools/bf:f	(Ljava/lang/Integer;)I
      //   234: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   237: aastore
      //   238: invokestatic 67	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   241: aload_2
      //   242: invokestatic 162	com/tencent/mm/sdk/platformtools/bf:f	(Ljava/lang/Integer;)I
      //   245: istore_1
      //   246: goto -209 -> 37
      //   249: astore_2
      //   250: aload_0
      //   251: monitorexit
      //   252: aload_2
      //   253: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	254	0	this	b
      //   1	245	1	i	int
      //   64	178	2	localObject1	Object
      //   249	4	2	localObject2	Object
      //   62	69	3	localInteger1	Integer
      //   111	107	4	localInteger2	Integer
      //   23	185	5	locals	s
      // Exception table:
      //   from	to	target	type
      //   4	25	249	finally
      //   30	37	249	finally
      //   37	50	249	finally
      //   53	63	249	finally
      //   69	91	249	finally
      //   91	113	249	finally
      //   120	207	249	finally
      //   207	217	249	finally
      //   220	246	249	finally
    }
    
    public final void dj(int paramInt)
    {
      try
      {
        GMTrace.i(13525523103744L, 100773);
        com.tencent.mm.sdk.platformtools.v.i("MMKernel.CoreAccount", "Uin From %s To %s hash:%d thread:%d[%s] stack:%s", new Object[] { o.getString(this.uin), o.getString(paramInt), Integer.valueOf(com.tencent.mm.a.h.aw(paramInt, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), bf.bJP() });
        Assert.assertNotNull(this.gXp);
        a(this.gXp, paramInt);
        this.uin = paramInt;
        GMTrace.o(13525523103744L, 100773);
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public final int uH()
    {
      try
      {
        GMTrace.i(13525388886016L, 100772);
        if (!this.gXo)
        {
          va();
          this.gXo = true;
        }
        int i = this.uin;
        GMTrace.o(13525388886016L, 100772);
        return i;
      }
      finally {}
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/kernel/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */