package ct;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.map.geolocation.TencentDistanceAnalysis;
import com.tencent.map.geolocation.TencentDistanceListener;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManagerOptions;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.tencentmap.lbssdk.service.e;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.eclipse.jdt.annotation.Nullable;
import org.json.JSONException;

public final class by
{
  public static SparseArray<String> a;
  private int A = 0;
  private int B = 0;
  private int C = 0;
  private TencentLocation D;
  public TencentDistanceListener E;
  public boolean F = false;
  public final Object G = new Object();
  public final TencentLocationRequest H = TencentLocationRequest.create();
  public cs I;
  private double J;
  private double K;
  public cs L;
  public int M = 404;
  private final boolean N;
  public boolean O;
  public long P;
  public long Q;
  public String R;
  public int b = 1;
  private a c;
  private final bt d;
  private final b e;
  private final boolean f;
  private final bx g;
  private final ce h;
  private final bv i;
  private final ca j;
  public final cc k;
  private HandlerThread l;
  private int m = 0;
  private cd n;
  public final bm o;
  public cg p;
  public ck q;
  private ch r;
  public final bk s;
  public TencentLocationListener t;
  public TencentLocationListener u;
  public String v = "stop";
  public volatile boolean w = false;
  public volatile boolean x = false;
  public boolean y = false;
  public double z = 0.0D;
  
  static
  {
    SparseArray localSparseArray = new SparseArray();
    a = localSparseArray;
    localSparseArray.put(0, "OK");
    a.put(1, "ERROR_NETWORK");
    a.put(2, "BAD_JSON");
    a.put(4, "DEFLECT_FAILED");
  }
  
  public by(bk parambk)
  {
    this.s = parambk;
    if (parambk.g().t) {
      cv.a(parambk.a);
    }
    this.o = bn.b();
    this.j = new ca(this.s);
    this.k = new cc(this.s);
    this.n = new cd();
    this.i = bv.a(parambk.a);
    this.f = h();
    if (this.f)
    {
      this.d = null;
      this.h = j();
      if (!this.s.d()) {
        b.a.b("TxLocationManagerImpl", "createNewCellProvider: failed");
      }
      for (parambk = localbx;; parambk = new b(this.s))
      {
        this.e = parambk;
        localbx = i();
        this.g = localbx;
        this.N = b.a.a(parambk, new Object[] { localbx });
        return;
      }
    }
    this.e = null;
    this.h = j();
    if (!this.s.d()) {
      b.a.b("TxLocationManagerImpl", "createCellProvider: failed");
    }
    for (parambk = (bk)localObject;; parambk = new bt(this.s))
    {
      this.d = parambk;
      localbx = i();
      this.g = localbx;
      this.N = b.a.a(parambk, new Object[] { localbx });
      return;
    }
  }
  
  private static String a(String paramString)
  {
    int i1 = 1;
    if (paramString.contains(",")) {}
    try
    {
      paramString = paramString.split(",");
      if ((paramString == null) || (paramString.length <= 1) || (paramString[0] == null) || (paramString[1] == null) || (e.w(paramString[0], paramString[1]) <= 0)) {
        break label84;
      }
    }
    catch (UnsatisfiedLinkError paramString)
    {
      return null;
    }
    i1 = e.v(paramString);
    if (i1 >= 0) {
      return Integer.toString(i1);
    }
    return "";
    while (i1 != 0)
    {
      return paramString[0];
      label84:
      i1 = 0;
    }
    return "";
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    String str1 = null;
    switch (paramInt1)
    {
    }
    for (Object localObject3 = null;; localObject3 = ???)
    {
      synchronized (this.G)
      {
        for (;;)
        {
          if (this.t != null) {
            this.t.onStatusUpdate((String)localObject3, paramInt2, str1);
          }
          return;
          localObject3 = "gps";
          switch (paramInt2)
          {
          default: 
            str1 = "unknown";
            break;
          case 1: 
            str1 = "gps enabled";
            break;
          case 0: 
            str1 = "gps disabled";
            continue;
            localObject3 = "gps";
            switch (paramInt2)
            {
            default: 
              str1 = "unknown";
              break;
            case 3: 
              str1 = "gps available";
              break;
            case 4: 
              str1 = "gps unavailable";
            }
            break;
          }
        }
        ??? = "cell";
        if (paramInt2 == 1) {
          str1 = "cell enabled";
        }
        for (;;)
        {
          localObject3 = str1;
          if (!ct.a) {
            break label334;
          }
          str1 = "location permission denied";
          paramInt2 = 2;
          localObject3 = "cell";
          break;
          if (paramInt2 == 0) {
            str1 = "cell disabled";
          } else {
            str1 = "unknown";
          }
        }
        String str2 = "wifi";
        switch (paramInt2)
        {
        case 2: 
        case 3: 
        case 4: 
        default: 
          str1 = "unknown";
        case 0: 
        case 1: 
          for (;;)
          {
            localObject3 = str1;
            ??? = str2;
            if (paramInt2 == 5) {
              break label334;
            }
            localObject3 = str1;
            ??? = str2;
            if (!da.a) {
              break label334;
            }
            str1 = "location permission denied";
            paramInt2 = 2;
            localObject3 = "wifi";
            break;
            str1 = "wifi disabled";
            continue;
            str1 = "wifi enabled";
          }
        }
        str1 = "location service switch is off";
      }
      label334:
      Object localObject2 = localObject3;
    }
  }
  
  private void a(int paramInt, long paramLong)
  {
    if (this.c != null)
    {
      this.c.removeMessages(paramInt);
      this.c.sendEmptyMessageDelayed(paramInt, paramLong);
    }
  }
  
  private void b(int paramInt)
  {
    if (this.c != null)
    {
      this.c.sendEmptyMessage(paramInt);
      return;
    }
    b.a.b("TxLocationManagerImpl", "mHandler is null");
  }
  
  private boolean h()
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      ExecutorService localExecutorService = Executors.newFixedThreadPool(1);
      Callable local1 = new Callable() {};
      try
      {
        boolean bool = ((Boolean)localExecutorService.submit(local1).get(500L, TimeUnit.MILLISECONDS)).booleanValue();
        localExecutorService.shutdown();
        return bool;
      }
      catch (TimeoutException localTimeoutException)
      {
        localTimeoutException = localTimeoutException;
        localExecutorService.shutdown();
        return false;
      }
      catch (Exception localException)
      {
        localException = localException;
        localExecutorService.shutdown();
        return false;
      }
      finally
      {
        localObject = finally;
        localExecutorService.shutdown();
        throw ((Throwable)localObject);
      }
    }
    return false;
  }
  
  @Nullable
  private bx i()
  {
    if (!this.s.f())
    {
      b.a.b("TxLocationManagerImpl", "createGpsProvider: failed");
      return null;
    }
    return new bx(this.s);
  }
  
  @Nullable
  private ce j()
  {
    if (!this.s.e())
    {
      b.a.b("TxLocationManagerImpl", "createWifiProvider: failed");
      return null;
    }
    return new ce(this.s);
  }
  
  private void k()
  {
    boolean bool2 = true;
    this.s.a(this);
    bool3 = this.H.getExtras().getBoolean("use_network", true);
    a locala = this.c;
    this.j.a();
    Object localObject1 = this.k;
    if (!((cc)localObject1).g)
    {
      ((cc)localObject1).g = true;
      ((cc)localObject1).b.h().execute(new cc.1((cc)localObject1, locala));
      ((cc)localObject1).f = SystemClock.elapsedRealtime();
    }
    localObject1 = this.k;
    String str = this.s.i();
    SystemClock.elapsedRealtime();
    for (;;)
    {
      try
      {
        bool1 = TextUtils.isEmpty(str);
        if (!bool1) {
          continue;
        }
      }
      catch (Exception localException)
      {
        Object localObject2;
        b.a.a("TxRequestSender", "", localException);
        continue;
      }
      catch (Error localError)
      {
        b.a.a("TxRequestSender", "", localError);
        continue;
        if ((!bool3) || (!b.a.b(this.d))) {
          continue;
        }
        this.d.a();
        continue;
        boolean bool1 = false;
        continue;
        long l1 = 5000L;
        continue;
        bool1 = false;
        continue;
      }
      if (!this.f) {
        continue;
      }
      if ((bool3) && (b.a.b(this.e))) {
        this.e.a();
      }
      if ((bool3) && (b.a.b(this.h))) {
        this.h.a(locala);
      }
      if (!this.H.getExtras().getBoolean("daemon")) {
        this.O = true;
      }
      if ((b.a.b(this.g)) && (this.H.isAllowGPS()))
      {
        localObject1 = this.g;
        if (this.b != 1) {
          continue;
        }
        bool1 = bool2;
        ((bx)localObject1).a(bool1);
        if (this.H.getInterval() >= 5000L) {
          continue;
        }
        l1 = this.H.getInterval();
        this.g.a(l1, this.H.getExtras().getBoolean("daemon"));
      }
      if (this.H.isAllowDirection()) {
        this.i.a(locala);
      }
      return;
      localObject2 = cc.a(str.getBytes("UTF-8"));
      e.o((byte[])localObject2, 2);
      localObject2 = new cc.a(2, (byte[])localObject2, "http://ue.indoorloc.map.qq.com", null);
      ((cc.a)localObject2).b = str;
      if (((cc.a)localObject2).f == null) {
        continue;
      }
      bool1 = ((cc)localObject1).a.offer(localObject2);
      if (!bool1)
      {
        ((cc)localObject1).a.clear();
        ((cc)localObject1).a.offer(localObject2);
        b.a.b("TxRequestSender", "postLocationRequest: failed to add request,because the queue has full,so we delete the first");
      }
    }
  }
  
  private void l()
  {
    ct.a = false;
    this.j.b();
    cc localcc = this.k;
    if (localcc.g)
    {
      localcc.g = false;
      localcc.a.clear();
      localcc.a.offer(cc.a.d);
      if (localcc.f != 0L)
      {
        long l1 = SystemClock.elapsedRealtime();
        long l2 = localcc.f;
        b.a.a("TxRequestSender", String.format(Locale.ENGLISH, "shutdown: duration=%ds, sent=%dB, recv=%dB, reqCount=%d", new Object[] { Long.valueOf((l1 - l2) / 1000L), Long.valueOf(localcc.d), Long.valueOf(localcc.e), Long.valueOf(localcc.c) }));
      }
      localcc.c = 0L;
      localcc.d = 0L;
      localcc.e = 0L;
      localcc.f = 0L;
    }
    this.n.a();
    if (b.a.b(this.h)) {
      this.h.a();
    }
    if (this.f) {
      if (b.a.b(this.e)) {
        this.e.b();
      }
    }
    for (;;)
    {
      if (b.a.b(this.g)) {
        this.g.a();
      }
      if (this.H.isAllowDirection()) {
        this.i.a();
      }
      return;
      if (b.a.b(this.d)) {
        this.d.b();
      }
    }
  }
  
  private void m()
  {
    this.I = null;
    this.M = 404;
    this.q = null;
    this.p = null;
    this.r = null;
    ci.a = 0;
    this.s.a("cell").a();
  }
  
  public final int a(TencentDistanceListener paramTencentDistanceListener)
  {
    if (this.t == null) {
      return 1;
    }
    if (this.y) {
      return 2;
    }
    this.y = true;
    this.E = paramTencentDistanceListener;
    return 0;
  }
  
  public final int a(TencentLocationListener paramTencentLocationListener, Looper paramLooper)
  {
    b.a.b("TxLocationManagerImpl", "Single click:");
    if (this.w)
    {
      if ((paramTencentLocationListener != null) && (this.M == 0)) {
        paramTencentLocationListener.onLocationChanged(this.I, this.M, (String)a.get(this.M));
      }
      b.a.b("TxLocationManagerImpl", "Single return");
      return 5;
    }
    this.w = true;
    if (paramTencentLocationListener != null)
    {
      this.u = paramTencentLocationListener;
      if ((this.M != 0) || (this.I == null) || (((!this.I.getProvider().equals("gps")) || (System.currentTimeMillis() - this.I.getTime() > 90000L)) && ((!this.I.getProvider().equals("network")) || (System.currentTimeMillis() - this.I.getTime() > 10000L)))) {
        break label246;
      }
    }
    try
    {
      Thread.sleep((int)(Math.random() * 100.0D) + 100);
      if (this.u != null)
      {
        this.u.onLocationChanged(this.I, this.M, (String)a.get(this.M));
        this.u = null;
      }
      b.a.b("TxLocationManagerImpl", "Single cache false");
      this.w = false;
      return 0;
      b.a.b("TxLocationManagerImpl", "Single 4 false");
      this.w = false;
      return 4;
      label246:
      if ((this.v != null) && (this.v.equals("start")))
      {
        this.x = false;
        b.a.b("TxLocationManagerImpl", "Single send");
        b(3997);
      }
      for (int i1 = 0;; i1 = a(TencentLocationRequest.create().setInterval(5000L), new TencentLocationListener()
          {
            public final void onLocationChanged(TencentLocation paramAnonymousTencentLocation, int paramAnonymousInt, String paramAnonymousString) {}
            
            public final void onStatusUpdate(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2) {}
          }, paramLooper))
      {
        return i1;
        this.x = true;
      }
    }
    catch (Exception paramTencentLocationListener)
    {
      for (;;) {}
    }
  }
  
  public final int a(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener, Looper paramLooper)
  {
    int i1 = 1;
    if (this.m == 1)
    {
      c();
      if (this.l != null)
      {
        this.l.quit();
        this.l = null;
      }
      this.m = 0;
    }
    if (TencentLocationManagerOptions.isLoadLibraryEnabled()) {}
    bl localbl;
    do
    {
      try
      {
        System.loadLibrary("tencentloc");
        localbl = this.s.g();
        ??? = b.a.b(localbl.h);
        this.R = a((String)???);
        if (TextUtils.isEmpty(this.R))
        {
          b.a.b("TxLocationManagerImpl", "requestLocationUpdates: illegal key [" + (String)??? + "]");
          i1 = 2;
          return i1;
        }
      }
      catch (Error paramTencentLocationRequest)
      {
        b.a.a("TencentLocationSDK", "load library", paramTencentLocationRequest);
        return 3;
      }
    } while (this.N);
    m();
    for (;;)
    {
      synchronized (this.G)
      {
        this.t = paramTencentLocationListener;
        TencentLocationRequest.copy(this.H, paramTencentLocationRequest);
        localbl.g = paramTencentLocationRequest.getQQ();
        if (TextUtils.isEmpty(b.a.b(localbl.e))) {
          localbl.e = paramTencentLocationRequest.getPhoneNumber();
        }
        if (paramTencentLocationRequest.getInterval() == 0L)
        {
          l1 = 2L;
          localbl.m = Math.max(5000L, l1);
          if (Looper.myLooper() == null) {
            Looper.prepare();
          }
          if (!b.a.a(this.c)) {
            break label297;
          }
          this.c = new a(paramLooper);
          l();
          k();
          this.v = "start";
          return 0;
        }
      }
      long l1 = paramTencentLocationRequest.getInterval();
      continue;
      label297:
      this.c.removeCallbacksAndMessages(null);
      if (this.c.getLooper() != paramLooper) {
        this.c = new a(paramLooper);
      }
    }
  }
  
  public final TencentLocation a()
  {
    if (this.M == 0)
    {
      a(this.I);
      return this.I;
    }
    return null;
  }
  
  public final void a(int paramInt)
  {
    if (this.b == paramInt) {
      return;
    }
    this.b = paramInt;
  }
  
  public final void a(int paramInt, cs paramcs)
  {
    int i2 = 0;
    if (paramcs == null) {
      return;
    }
    if ((paramInt == 0) && (paramcs.getLatitude() != 0.0D) && (paramcs.getLongitude() != 0.0D)) {
      if ((this.b != 1) || (!cu.a(paramcs.getLatitude(), paramcs.getLongitude()))) {
        break label688;
      }
    }
    label682:
    label688:
    for (int i1 = 1;; i1 = 0)
    {
      cs.a(paramcs, i1);
      if (n()) {
        if ((this.M == 0) || (paramInt != 0)) {
          break label682;
        }
      }
      for (i1 = 1;; i1 = 0)
      {
        this.M = paramInt;
        this.I = paramcs;
        if ((paramcs.getAccuracy() < 5000.0F) && (paramcs.getAccuracy() > 0.0F))
        {
          this.n.a(paramcs);
          if (this.y) {
            this.D = paramcs;
          }
        }
        this.J = paramcs.getLatitude();
        this.K = paramcs.getLongitude();
        if ((b.a.b(this.t)) && (this.H.getInterval() > 0L)) {
          a(11999, this.H.getInterval());
        }
        if (i1 != 0) {
          b(11998);
        }
        for (;;)
        {
          i1 = i2;
          if (this.M != 0)
          {
            i1 = i2;
            if (paramInt == 0) {
              i1 = 1;
            }
          }
          i2 = i1;
          if (this.M == 0)
          {
            i2 = i1;
            if (this.I != null)
            {
              i2 = i1;
              if (this.I.getProvider().equals("network"))
              {
                i2 = i1;
                if (paramInt == 0)
                {
                  i2 = i1;
                  if (paramcs != null)
                  {
                    i2 = i1;
                    if (paramcs.getProvider().equals("gps")) {
                      i2 = 1;
                    }
                  }
                }
              }
            }
          }
          this.M = paramInt;
          this.I = paramcs;
          if ((this.H.getInterval() == 0L) && (b.a.b(this.t))) {
            b(11998);
          }
          if ((i2 == 0) || (!b.a.b(this.t))) {
            break;
          }
          b(11998);
          return;
          if ((paramInt == 0) && (paramcs.getLatitude() != 0.0D) && (paramcs.getLongitude() != 0.0D) && (Math.abs(paramcs.getLatitude() - this.J) >= 1.0E-8D) && (Math.abs(paramcs.getLongitude() - this.K) >= 1.0E-8D))
          {
            cd localcd = this.n;
            bk localbk = this.s;
            this.g.c();
            if (!localcd.a(paramcs, localbk))
            {
              b.a.a("TxLocationManagerImpl", "discard " + paramcs);
              return;
            }
            this.J = paramcs.getLatitude();
            this.K = paramcs.getLongitude();
            if ((paramcs.getAccuracy() < 5000.0F) && (paramcs.getAccuracy() > 0.0F))
            {
              this.n.b();
              this.n.a(paramcs);
              if (this.y) {
                if (this.D != null)
                {
                  double d1 = b.a.a(this.D.getLatitude(), this.D.getLongitude(), paramcs.getLatitude(), paramcs.getLongitude());
                  if (((paramcs.getProvider().equalsIgnoreCase("network")) && (d1 > 10.0D)) || ((paramcs.getProvider().equalsIgnoreCase("gps")) && (d1 > 3.0D)))
                  {
                    this.z = (d1 + this.z);
                    if (paramcs.getProvider().equalsIgnoreCase("network")) {
                      this.B += 1;
                    }
                    for (;;)
                    {
                      this.C += 1;
                      this.D = paramcs;
                      break;
                      this.A += 1;
                    }
                  }
                }
                else
                {
                  this.D = paramcs;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void a(cs paramcs)
  {
    if (paramcs != null) {
      if (this.H.isAllowDirection()) {
        paramcs.getExtra().putDouble("direction", this.i.b());
      }
    }
    try
    {
      paramcs.getExtra().putAll(this.H.getExtras());
      return;
    }
    catch (Exception paramcs) {}
  }
  
  public final TencentDistanceAnalysis b()
  {
    this.E = null;
    this.z = 0.0D;
    this.y = false;
    this.D = null;
    cn localcn = new cn();
    localcn.a(b.a.a((this.A + 1) / (this.C + 1), 4) * 100.0D);
    localcn.a(this.A);
    localcn.b(this.B);
    this.A = 0;
    this.B = 0;
    this.C = 0;
    return localcn;
  }
  
  public final void c()
  {
    l();
    this.s.b(this);
    if (b.a.b(this.c)) {
      this.c.a();
    }
    synchronized (this.G)
    {
      this.t = null;
      this.o.a();
      m();
      this.v = "stop";
      if (this.m != 0) {}
    }
    try
    {
      int i1 = this.s.a.getSharedPreferences("LocationSDK", 0).getInt("control", -1);
      b.a.b("TxLocationManagerImpl", "read sp control:" + i1);
      if (i1 != -1)
      {
        if (i1 < 120) {}
        do
        {
          return;
          localObject2 = finally;
          throw ((Throwable)localObject2);
          long l1 = i1 * 1000;
          this.P = l1;
        } while (!da.b(this.s).equalsIgnoreCase("{}"));
        this.l = new HandlerThread("daemonthread");
        this.l.start();
        ??? = TencentLocationRequest.create().setInterval(this.P).setRequestLevel(0);
        ((TencentLocationRequest)???).getExtras().putBoolean("daemon", true);
        a((TencentLocationRequest)???, new TencentLocationListener()
        {
          public final void onLocationChanged(TencentLocation paramAnonymousTencentLocation, int paramAnonymousInt, String paramAnonymousString) {}
          
          public final void onStatusUpdate(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2) {}
        }, this.l.getLooper());
        this.m = 1;
        this.Q = System.currentTimeMillis();
        return;
      }
      b.a.b("TxLocationManagerImpl", "control is -1 ,so we no start");
      return;
    }
    catch (Exception localException)
    {
      b.a.b("TxLocationManagerImpl", "sp ex:" + localException);
    }
  }
  
  public final String d()
  {
    if (this.v.equalsIgnoreCase("pause"))
    {
      k();
      this.v = "start";
      return "success";
    }
    return "warning!!!resume failed.only when the machine has paused, can resume!";
  }
  
  public final String e()
  {
    if (this.v.equalsIgnoreCase("start"))
    {
      l();
      this.v = "pause";
      return "success";
    }
    return "warning!!!pause failed.only when the machine has started, can pause!";
  }
  
  public final int f()
  {
    return this.b;
  }
  
  public final boolean n()
  {
    return this.M == 404;
  }
  
  public final boolean o()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.g != null)
    {
      bool1 = bool2;
      if (this.g.c())
      {
        bool1 = bool2;
        if (this.g.b()) {
          bool1 = true;
        }
      }
    }
    if (!bool1) {
      b.a.b("TxLocationManagerImpl", "isGpsValid: provider=false");
    }
    return bool1;
  }
  
  public final void onCellInfoEvent(cg paramcg)
  {
    int i4 = paramcg.e;
    int i5 = paramcg.f;
    cg localcg = this.p;
    int i1;
    if (localcg != null) {
      i1 = localcg.f;
    }
    for (int i2 = localcg.e;; i2 = 0)
    {
      this.p = paramcg;
      if (this.h != null) {}
      for (int i3 = this.h.b();; i3 = 1)
      {
        if (i3 != 0) {
          this.q = null;
        }
        if ((i3 == 0) && ((this.q == null) || (this.q.a(System.currentTimeMillis(), 30000L))))
        {
          if (this.c != null)
          {
            paramcg = this.c.obtainMessage(3999, "wifi_not_received");
            this.c.sendMessageDelayed(paramcg, 2000L);
          }
          if (i3 != 0) {
            break label205;
          }
        }
        label205:
        for (paramcg = "scan wifi";; paramcg = "prepare json. wifi is not scannable?")
        {
          b.a.a("TxLocationManagerImpl", String.format("onCellChanged: %d(%d)-->%d(%d) (%d)%s", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i3), paramcg }));
          return;
          b(3999);
          break;
        }
      }
      i1 = 0;
    }
  }
  
  public final void onGpsInfoEvent(ch paramch)
  {
    double d1 = 0.0D;
    int i1;
    int i2;
    cs localcs;
    Location localLocation;
    Object localObject;
    double d2;
    if (paramch.a != bu.b)
    {
      this.r = paramch;
      bw.a().a(paramch);
      i1 = this.b;
      i2 = this.H.getRequestLevel();
      localcs = this.L;
      localLocation = new Location(paramch.a);
      localObject = localLocation.getExtras();
      if (localObject == null) {
        break label291;
      }
      d2 = ((Bundle)localObject).getDouble("lat");
      d1 = ((Bundle)localObject).getDouble("lng");
    }
    for (;;)
    {
      if (b.a.a(i1))
      {
        localObject = new cs.a();
        ((cs.a)localObject).b = localcs;
        ((cs.a)localObject).d = "gps";
        ((cs.a)localObject).c = i2;
        paramch = ((cs.a)localObject).a(new Location(paramch.a)).a();
        localLocation.setLatitude(d2);
        localLocation.setLongitude(d1);
        paramch.a(localLocation);
        a(0, paramch);
      }
      for (;;)
      {
        if (this.g != null) {
          this.g.b();
        }
        return;
        if (n()) {
          b(3999);
        }
        localObject = new cs.a();
        ((cs.a)localObject).b = localcs;
        ((cs.a)localObject).d = "gps";
        ((cs.a)localObject).c = i2;
        paramch = ((cs.a)localObject).a(new Location(paramch.a)).a();
        localLocation.setLatitude(d2);
        localLocation.setLongitude(d1);
        paramch.a(localLocation);
        a(0, paramch);
        a(12004, 3);
      }
      label291:
      d2 = 0.0D;
    }
  }
  
  public final void onNetworkEvent(Integer paramInteger)
  {
    String str = b.a.a(this.s.a);
    switch (paramInteger.intValue())
    {
    default: 
      return;
    case -1: 
      b.a.a("TxLocationManagerImpl", "onNetworkEvent: networks not found");
      return;
    case 0: 
      b.a.a("TxLocationManagerImpl", "onNetworkEvent: " + str + " disconnected");
      return;
    }
    b.a.a("TxLocationManagerImpl", "onNetworkEvent: " + str + " connected");
    a(7999, 1000L);
  }
  
  public final void onStatusEvent(Message paramMessage)
  {
    int i1 = paramMessage.what;
    a(paramMessage.arg1, paramMessage.arg2);
  }
  
  public final void onWifiInfoEvent(ck paramck)
  {
    if (this.c != null) {
      this.c.removeMessages(3999, "wifi_not_received");
    }
    if (paramck == ck.a)
    {
      b.a.a("TxLocationManagerImpl", "onWifiChanged --> clear wifi if needed");
      a(555, 1500L);
      return;
    }
    if ((this.q == null) || (!this.F) || (paramck.a().size() < 3) || (!this.q.a(paramck)))
    {
      b.a.a("TxLocationManagerImpl", "onWifiChanged: --> prepare json");
      b(3999);
    }
    this.q = paramck;
  }
  
  final class a
    extends Handler
  {
    private final bz a;
    private int b;
    private long c;
    private boolean d;
    private boolean e;
    
    a(Looper paramLooper)
    {
      super();
      this$1 = by.this.s;
      this.a = bn.c();
      this.c = 0L;
      this.d = false;
      this.e = false;
    }
    
    private void a(int paramInt)
    {
      if ((by.this.w) && (by.this.u != null))
      {
        if (by.this.M != 0) {
          break label106;
        }
        by.this.u.onLocationChanged(by.this.I, by.this.M, (String)by.a.get(by.this.M));
      }
      for (;;)
      {
        by.this.u = null;
        by.this.w = false;
        if (!by.this.x) {
          break;
        }
        by.this.c();
        return;
        label106:
        by.this.u.onLocationChanged(cs.a, paramInt, (String)by.a.get(paramInt));
      }
      b.a.b("TxLocationManagerImpl", "Single timeoutfalse");
    }
    
    public final void a()
    {
      removeCallbacksAndMessages(null);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      Object localObject1;
      int j;
      long l;
      synchronized (by.this.G)
      {
        if (by.this.t == null) {
          return;
        }
        localObject1 = by.this.t;
        ??? = by.this.H;
        j = ((TencentLocationRequest)???).getRequestLevel();
        l = ((TencentLocationRequest)???).getInterval();
        switch (paramMessage.what)
        {
        default: 
          return;
        case 555: 
          by.this.q = null;
          sendEmptyMessage(3999);
          return;
        }
      }
      if ((by.this.I != null) && (((TencentLocationRequest)???).getInterval() > 0L) && (by.this.v != null) && (by.this.v.equalsIgnoreCase("start")))
      {
        by.this.a(by.this.I);
        ((TencentLocationListener)localObject1).onLocationChanged(by.this.I, by.this.M, (String)by.a.get(by.this.M));
        if ((by.this.y) && (by.this.E != null)) {
          by.this.E.onDistanceChanged(by.this.I, b.a.a(by.this.z / 1000.0D, 2), by.this.M, (String)by.a.get(by.this.M));
        }
      }
      if (l > 0L)
      {
        sendEmptyMessageDelayed(11999, l);
        return;
        if (by.this.I != null)
        {
          by.this.a(by.this.I);
          ((TencentLocationListener)localObject1).onLocationChanged(by.this.I, by.this.M, (String)by.a.get(by.this.M));
          if ((by.this.y) && (by.this.E != null))
          {
            by.this.E.onDistanceChanged(by.this.I, b.a.a(by.this.z / 1000.0D, 2), by.this.M, (String)by.a.get(by.this.M));
            return;
            if (!by.this.n())
            {
              b.a.a("TxLocationManagerImpl", "network connected --> prepare json");
              localObject1 = by.l(by.this);
              int i;
              if (localObject1 != null)
              {
                paramMessage = ((ci)localObject1).a(j, by.this.R, by.this.s, false, false, false, false);
                if (!b.a.c(paramMessage)) {
                  i = 1;
                }
              }
              for (;;)
              {
                if ((localObject1 == null) || (i != 0))
                {
                  if (localObject1 == null) {}
                  for (paramMessage = "info3 is null";; paramMessage = "handleMessage: bad json " + paramMessage)
                  {
                    b.a.b("TxLocationManagerImpl", paramMessage);
                    if ((!by.this.w) || (by.this.u == null) || (by.this.M != 0)) {
                      return;
                    }
                    by.this.u.onLocationChanged(by.this.I, by.this.M, (String)by.a.get(by.this.M));
                    by.this.u = null;
                    by.this.w = false;
                    b.a.b("TxLocationManagerImpl", "Single connectfalse");
                    return;
                    i = 0;
                    break;
                  }
                }
                by.this.k.a(paramMessage, (ci)localObject1, by.this.b);
                return;
                if (by.this.H.getExtras().getBoolean("daemon"))
                {
                  if (by.this.P < 120000L) {
                    by.this.P = 120000L;
                  }
                  b.a.b("TxLocationManagerImpl", "the daemonLocation,so we delay long time upload:" + by.this.P + "," + System.currentTimeMillis() + "," + by.this.Q);
                  if (System.currentTimeMillis() - by.this.Q < by.this.P) {
                    break;
                  }
                  by.this.Q = System.currentTimeMillis();
                }
                if (paramMessage.obj != null) {
                  b.a.b("TxLocationManagerImpl", "wifi error." + paramMessage.obj.toString());
                }
                int k = by.this.b;
                Object localObject3 = by.l(by.this);
                if (localObject3 == null)
                {
                  a(2);
                  return;
                }
                if ((((ci)localObject3).b()) && (System.currentTimeMillis() - this.c > 60000L))
                {
                  this.d = true;
                  this.e = false;
                  this.c = System.currentTimeMillis();
                  paramMessage = ((ci)localObject3).a(j, by.this.R, by.this.s, this.d, this.e, by.this.O, by.this.H.getExtras().getBoolean("daemon"));
                  if (b.a.c(paramMessage)) {
                    break label1120;
                  }
                }
                label1120:
                for (i = 1;; i = 0)
                {
                  if (i != 0) {
                    b.a.b("TxLocationManagerImpl", "handleMessage: bad json " + paramMessage);
                  }
                  if (i == 0) {
                    break label1125;
                  }
                  this.b += 1;
                  if ((this.b < 2) || (by.this.o())) {
                    return;
                  }
                  b.a.b("TxLocationManagerImpl", "handleMessage: bad json " + paramMessage);
                  a(2);
                  this.b = 0;
                  return;
                  this.d = false;
                  break;
                }
                label1125:
                this.b = 0;
                if ((!by.this.H.getExtras().getBoolean("daemon")) && (TencentExtraKeys.isRequestRawData((TencentLocationRequest)???)))
                {
                  ??? = new cs.a();
                  ((cs.a)???).b = null;
                  ((cs.a)???).c = j;
                  ??? = ((cs.a)???).a();
                  TencentExtraKeys.setRawData((TencentLocation)???, paramMessage.getBytes());
                  by.this.a((cs)???);
                  ((TencentLocationListener)localObject1).onLocationChanged((TencentLocation)???, 0, (String)by.a.get(0));
                  return;
                }
                if (!TencentExtraKeys.MOCK_LOCATION_FILTER) {
                  break;
                }
                by.this.k.a(paramMessage, (ci)localObject3, k);
                paramMessage = by.this.o;
                System.currentTimeMillis();
                return;
                paramMessage = new ci(null, null, new ch((Location)paramMessage.obj, System.currentTimeMillis(), 3, 3, 0));
                localObject1 = paramMessage.a(j, by.this.R, by.this.s, true, false, false, by.this.H.getExtras().getBoolean("daemon"));
                by.this.k.a((String)localObject1, paramMessage, by.this.b);
                return;
                if (by.this.H.getExtras().getBoolean("daemon"))
                {
                  by.this.F = true;
                  return;
                }
                removeMessages(4998);
                localObject1 = (Pair)paramMessage.obj;
                ??? = ((Pair)localObject1).first.toString();
                localObject3 = (cc.a)((Pair)localObject1).second;
                ci localci = (ci)((cc.a)localObject3).a;
                String str = ((cc.a)localObject3).b;
                if (localci.b()) {}
                for (localObject1 = "gps";; localObject1 = "network") {
                  try
                  {
                    cs.a locala = new cs.a();
                    locala.a = ((String)???);
                    locala.c = j;
                    locala.d = ((String)localObject1);
                    localObject1 = locala.a();
                    ((cs)localObject1).getExtra().putString("resp_json", (String)???);
                    if (((cs)localObject1).isMockGps() == 1) {
                      this.e = true;
                    }
                    cs.a((cs)localObject1);
                    cs.a((cs)localObject1, by.this.p);
                    TencentExtraKeys.setRawQuery((TencentLocation)localObject1, str);
                    i = 0;
                    if (localci.a() != null) {
                      i = localci.a().c;
                    }
                    ((cs)localObject1).getExtra().putInt("sat_num", i);
                    ((cs)localObject1).getExtra().putLong("req_cost", paramMessage.arg1);
                    ((cs)localObject1).getExtra().putLong("req_start", ((cc.a)localObject3).c);
                    by.this.s.a("map").b(((cs)localObject1).getExtra());
                    by.this.F = true;
                    if (!by.this.o()) {
                      by.this.a(0, (cs)localObject1);
                    }
                    if ((!by.this.w) || (by.this.u == null)) {
                      break label1870;
                    }
                    by.this.u.onLocationChanged((TencentLocation)localObject1, 0, (String)by.a.get(0));
                    by.this.u = null;
                    b.a.b("TxLocationManagerImpl", "Single response false");
                    by.this.w = false;
                    if (!by.this.x) {
                      break label1870;
                    }
                    by.this.c();
                    return;
                  }
                  catch (JSONException paramMessage)
                  {
                    b.a.b("TxLocationManagerImpl", "handleMessage: location failed");
                    paramMessage = this.a.d();
                    if (paramMessage == bu.b) {
                      break;
                    }
                    obtainMessage(3998, paramMessage).sendToTarget();
                    if (!by.this.w) {
                      return;
                    }
                  }
                }
                if ((by.this.u == null) || (by.this.M != 0)) {
                  break;
                }
                by.this.u.onLocationChanged(by.this.I, by.this.M, (String)by.a.get(by.this.M));
                by.this.u = null;
                by.this.w = false;
                b.a.b("TxLocationManagerImpl", "Single connectfalse");
                return;
                label1870:
                if (by.this.O) {}
                try
                {
                  paramMessage = ((cs)localObject1).getExtra();
                  if (paramMessage != null)
                  {
                    i = paramMessage.getInt("icontrol", -1);
                    paramMessage = by.this.s.a.getSharedPreferences("LocationSDK", 0);
                    b.a.b("TxLocationManagerImpl", "start icontrol:" + i);
                    paramMessage.edit().putInt("control", i).apply();
                  }
                }
                catch (Exception paramMessage)
                {
                  for (;;)
                  {
                    b.a.b("TxLocationManagerImpl", "sp:" + paramMessage);
                  }
                }
                catch (Error paramMessage)
                {
                  for (;;)
                  {
                    b.a.b("TxLocationManagerImpl", "error:" + paramMessage);
                  }
                }
                by.this.O = false;
                by.this.L = ((cs)localObject1);
                return;
                by.this.F = false;
                b.a.b("TxLocationManagerImpl", "timeout" + by.this.w + by.this.u);
                if (by.this.M != 0) {
                  by.this.a(1, cs.a);
                }
                a(1);
                return;
                paramMessage = null;
                i = 0;
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */