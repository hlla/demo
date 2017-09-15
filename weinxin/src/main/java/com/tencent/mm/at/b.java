package com.tencent.mm.at;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Base64;
import com.c.a.a.t.b;
import com.c.a.a.t.d;
import com.tencent.gmtrace.GMTrace;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.mm.a.o;
import com.tencent.mm.ap.k;
import com.tencent.mm.b.f;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.y.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
{
  private static final byte[] hQa;
  private static b hQb;
  public boolean hQc;
  ae hQd;
  int hQe;
  int hQf;
  int hQg;
  private int hQh;
  public c hQi;
  public List<d> hQj;
  public List<d> hQk;
  public com.tencent.mm.sdk.b.c hQl;
  ai hQm;
  public com.tencent.map.a.a.b hQn;
  int hQo;
  public com.tencent.map.a.a.c hQp;
  public long startTime;
  
  static
  {
    GMTrace.i(4408918147072L, 32849);
    hQa = "@wechat*weixin!!".getBytes();
    GMTrace.o(4408918147072L, 32849);
  }
  
  public b()
  {
    GMTrace.i(4404891615232L, 32819);
    this.hQc = false;
    this.startTime = 0L;
    this.hQe = 5000;
    this.hQf = 5000;
    this.hQg = 30000;
    this.hQh = 3600;
    this.hQj = new ArrayList();
    this.hQk = new ArrayList();
    this.hQl = new com.tencent.mm.sdk.b.c() {};
    com.tencent.mm.kernel.h.vJ();
    this.hQm = new ai(com.tencent.mm.kernel.h.vL().nIe.getLooper(), new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(4403817873408L, 32811);
        v.i("MicroMsg.SenseWhereHelper", "time up, stop sense where sdk.");
        b.IH();
        b.this.ID();
        GMTrace.o(4403817873408L, 32811);
        return false;
      }
    }, false);
    this.hQn = new com.tencent.map.a.a.b()
    {
      public final void a(double paramAnonymousDouble1, double paramAnonymousDouble2, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong)
      {
        GMTrace.i(4404623179776L, 32817);
        v.d("MicroMsg.SenseWhereHelper", "onLocationUpdate latitude[%f] longitude[%f] error[%d] floor[%d] buildingId[%d]", new Object[] { Double.valueOf(paramAnonymousDouble1), Double.valueOf(paramAnonymousDouble2), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Long.valueOf(paramAnonymousLong) });
        GMTrace.o(4404623179776L, 32817);
      }
    };
    this.hQo = 0;
    this.hQp = new com.tencent.map.a.a.c()
    {
      public final void g(int paramAnonymousInt, String paramAnonymousString)
      {
        GMTrace.i(4402744131584L, 32803);
        v.d("MicroMsg.SenseWhereHelper", "onMessage code[%d] message[%s]", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        if (paramAnonymousInt != 0)
        {
          paramAnonymousString = b.this;
          paramAnonymousInt = paramAnonymousString.hQo + 1;
          paramAnonymousString.hQo = paramAnonymousInt;
          if (paramAnonymousInt > 3)
          {
            v.i("MicroMsg.SenseWhereHelper", "sense where error time more than %d, stop now.", new Object[] { Integer.valueOf(3) });
            b.II();
            b.this.ID();
          }
        }
        GMTrace.o(4402744131584L, 32803);
      }
    };
    GMTrace.o(4404891615232L, 32819);
  }
  
  public static b IB()
  {
    GMTrace.i(4404757397504L, 32818);
    if (hQb == null) {
      hQb = new b();
    }
    b localb = hQb;
    GMTrace.o(4404757397504L, 32818);
    return localb;
  }
  
  public static String IC()
  {
    GMTrace.i(4405025832960L, 32820);
    String str1 = p.rA();
    com.tencent.mm.kernel.h.vG();
    String str2 = new o(com.tencent.mm.kernel.a.uH()).toString();
    str1 = str1 + "_" + str2;
    try
    {
      str2 = new String(Base64.encode(new s().encrypt(str1.getBytes("UTF-8"), hQa), 0), "UTF-8");
      v.i("MicroMsg.SenseWhereHelper", "create encrypt imei[%s], original imei[%s]", new Object[] { str2, bf.Qi(str1) });
      GMTrace.o(4405025832960L, 32820);
      return str2;
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.SenseWhereHelper", localException, "", new Object[0]);
      v.e("MicroMsg.SenseWhereHelper", "create imei error: " + localException.toString());
      GMTrace.o(4405025832960L, 32820);
    }
    return "";
  }
  
  public static void IF()
  {
    GMTrace.i(4405428486144L, 32823);
    if (bf.az(bf.a((Long)com.tencent.mm.kernel.h.vI().vr().get(w.a.uCP, null), 0L)) * 1000L > 21600000L)
    {
      v.i("MicroMsg.SenseWhereHelper", "update sense where location package list.");
      k localk = new k(36);
      com.tencent.mm.kernel.h.vH().gXs.a(localk, 0);
      com.tencent.mm.kernel.h.vI().vr().a(w.a.uCP, Long.valueOf(bf.Nz()));
    }
    GMTrace.o(4405428486144L, 32823);
  }
  
  public static void IG()
  {
    GMTrace.i(16023449239552L, 119384);
    com.tencent.mm.plugin.report.service.g.oSF.a(345L, 1L, 1L, false);
    GMTrace.o(16023449239552L, 119384);
  }
  
  public static void IH()
  {
    GMTrace.i(16023583457280L, 119385);
    com.tencent.mm.plugin.report.service.g.oSF.a(345L, 2L, 1L, false);
    GMTrace.o(16023583457280L, 119385);
  }
  
  public static void II()
  {
    GMTrace.i(16023717675008L, 119386);
    com.tencent.mm.plugin.report.service.g.oSF.a(345L, 3L, 1L, false);
    GMTrace.o(16023717675008L, 119386);
  }
  
  public static void IJ()
  {
    GMTrace.i(16023851892736L, 119387);
    com.tencent.mm.plugin.report.service.g.oSF.a(345L, 5L, 1L, false);
    GMTrace.o(16023851892736L, 119387);
  }
  
  public final void ID()
  {
    GMTrace.i(4405160050688L, 32821);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(4404354744320L, 32815);
        v.i("MicroMsg.SenseWhereHelper", "it stop sense where sdk.");
        com.tencent.mm.sdk.b.a.uql.c(b.this.hQl);
        com.c.a.a.t.nC();
        com.c.a.a.t.finish();
        if (b.this.hQi != null)
        {
          b.this.hQi.finish();
          b.this.hQi = null;
        }
        b localb = b.this;
        if (localb.hQd != null) {
          localb.hQd.nIe.quit();
        }
        localb.hQd = null;
        b.this.hQm.KI();
        localb = b.this;
        if (localb.startTime > 0L)
        {
          long l = (bf.NB() - localb.startTime) / 1000L;
          int i = bf.f((Integer)com.tencent.mm.plugin.report.service.g.a((int)l, new int[] { 5, 10, 20, 30 }, 10, 14));
          v.d("MicroMsg.SenseWhereHelper", "reportCollectionTime time %d, res %d", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
          com.tencent.mm.plugin.report.service.g.oSF.a(345L, i, 1L, false);
        }
        b.this.hQc = false;
        GMTrace.o(4404354744320L, 32815);
      }
    });
    GMTrace.o(4405160050688L, 32821);
  }
  
  public final boolean IE()
  {
    GMTrace.i(4405294268416L, 32822);
    com.tencent.mm.kernel.h.vG();
    if (new o(com.tencent.mm.kernel.a.uH()).longValue() < 1000000L)
    {
      v.i("MicroMsg.SenseWhereHelper", "it boss uin do not start sense where.");
      GMTrace.o(4405294268416L, 32822);
      return false;
    }
    Object localObject = com.tencent.mm.i.g.sV().getValue("AndroidSenseWhereArgs");
    if (bf.mA((String)localObject))
    {
      v.i("MicroMsg.SenseWhereHelper", "it has no config do not start sense where.");
      GMTrace.o(4405294268416L, 32822);
      return false;
    }
    try
    {
      v.d("MicroMsg.SenseWhereHelper", "sense where config : " + (String)localObject);
      localObject = ((String)localObject).split(";");
      int i = bf.getInt(localObject[0], 0);
      com.tencent.mm.kernel.h.vG();
      int j = com.tencent.mm.a.h.aw(com.tencent.mm.kernel.a.uH() + 5, 100);
      if (j > i)
      {
        v.d("MicroMsg.SenseWhereHelper", "do not start sense where.uinhash %d, percent %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        GMTrace.o(4405294268416L, 32822);
        return false;
      }
      this.hQf = bf.getInt(localObject[1], 5000);
      this.hQe = bf.getInt(localObject[2], 5000);
      this.hQg = bf.getInt(localObject[3], 30000);
      this.hQh = bf.getInt(localObject[4], 3600);
      v.i("MicroMsg.SenseWhereHelper", "check sense where report args[%d, %d, %d, %d]", new Object[] { Integer.valueOf(this.hQf), Integer.valueOf(this.hQe), Integer.valueOf(this.hQg), Integer.valueOf(this.hQh) });
      long l = bf.az(((Long)com.tencent.mm.kernel.h.vI().vr().get(w.a.uCQ, Long.valueOf(0L))).longValue());
      i = this.hQh;
      if (l > i)
      {
        GMTrace.o(4405294268416L, 32822);
        return true;
      }
      v.i("MicroMsg.SenseWhereHelper", "it is not time out. diff[%d], collection interval[%d]", new Object[] { Long.valueOf(l), Integer.valueOf(this.hQh) });
      GMTrace.o(4405294268416L, 32822);
      return false;
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.SenseWhereHelper", localException, "", new Object[0]);
      v.e("MicroMsg.SenseWhereHelper", "check sense where config error: " + localException.toString());
      v.i("MicroMsg.SenseWhereHelper", "it default do not start sense where.");
      GMTrace.o(4405294268416L, 32822);
    }
    return false;
  }
  
  public final boolean a(int paramInt, float paramFloat1, float paramFloat2)
  {
    GMTrace.i(16023180804096L, 119382);
    if (paramInt == 1) {}
    for (Object localObject = this.hQj; (localObject == null) || (((List)localObject).size() <= 0); localObject = this.hQk)
    {
      v.i("MicroMsg.SenseWhereHelper", "it has not report location, do not start sense where.");
      GMTrace.o(16023180804096L, 119382);
      return false;
    }
    long l = bf.NB();
    localObject = ((List)localObject).iterator();
    d locald;
    double d;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      locald = (d)((Iterator)localObject).next();
      d = TencentLocationUtils.distanceBetween(locald.latitude, locald.longitude, paramFloat2, paramFloat1);
      v.d("MicroMsg.SenseWhereHelper", "loc[%f, %f], config[%f, %f], dis[%f, %f]", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1), Double.valueOf(locald.latitude), Double.valueOf(locald.longitude), Double.valueOf(d), Double.valueOf(locald.hQF) });
    } while (d > locald.hQF);
    for (boolean bool = true;; bool = false)
    {
      v.i("MicroMsg.SenseWhereHelper", "check location[%d, %f, %f] finish %b, cost time %d", new Object[] { Integer.valueOf(paramInt), Float.valueOf(paramFloat2), Float.valueOf(paramFloat1), Boolean.valueOf(bool), Long.valueOf(bf.aB(l)) });
      GMTrace.o(16023180804096L, 119382);
      return bool;
    }
  }
  
  public final void gt(int paramInt)
  {
    GMTrace.i(16023315021824L, 119383);
    ai localai = this.hQm;
    long l = paramInt;
    localai.v(l, l);
    GMTrace.o(16023315021824L, 119383);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/at/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */