package com.tencent.mm.modelcdntran;

import android.net.wifi.WifiInfo;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnInfoParams;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.ie;
import com.tencent.mm.protocal.c.if;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.protocal.c.vu;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class e
  extends k
  implements j
{
  public static long hyu;
  private final com.tencent.mm.y.b gUq;
  private com.tencent.mm.y.e gUt;
  private Map<String, a> hyv;
  private int scene;
  public long startTime;
  
  static
  {
    GMTrace.i(591229091840L, 4405);
    hyu = 0L;
    GMTrace.o(591229091840L, 4405);
  }
  
  public e()
  {
    this(0);
    GMTrace.i(589886914560L, 4395);
    GMTrace.o(589886914560L, 4395);
  }
  
  public e(int paramInt)
  {
    GMTrace.i(590021132288L, 4396);
    this.hyv = new HashMap();
    this.startTime = 0L;
    this.scene = 0;
    v.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn init Scene:%d  [%s]", new Object[] { Integer.valueOf(paramInt), bf.bJP() });
    b.a locala = new b.a();
    locala.hrV = new vt();
    locala.hrW = new vu();
    locala.uri = "/cgi-bin/micromsg-bin/getcdndns";
    locala.hrU = 379;
    locala.hrX = 0;
    locala.hrY = 0;
    this.gUq = locala.BE();
    this.scene = paramInt;
    ((vt)this.gUq.hrS.hsa).tBp = "";
    GMTrace.o(590021132288L, 4396);
  }
  
  private static String Eh()
  {
    GMTrace.i(590289567744L, 4398);
    if (!al.isConnected(aa.getContext()))
    {
      GMTrace.o(590289567744L, 4398);
      return null;
    }
    if (al.isWifi(aa.getContext()))
    {
      localObject = al.getWifiInfo(aa.getContext());
      if (localObject == null)
      {
        GMTrace.o(590289567744L, 4398);
        return null;
      }
    }
    for (Object localObject = "wifi_" + ((WifiInfo)localObject).getSSID();; localObject = "mobile_" + al.getNetTypeString(aa.getContext()) + "_" + al.getISPCode(aa.getContext()))
    {
      v.d("MicroMsg.NetSceneGetCDNDns", "cdntra getCurCacheFullPath file:%s", new Object[] { localObject });
      if ((localObject != null) && (((String)localObject).length() >= 2)) {
        break;
      }
      GMTrace.o(590289567744L, 4398);
      return null;
    }
    localObject = String.format("%x", new Object[] { Integer.valueOf(((String)localObject).hashCode()) });
    StringBuilder localStringBuilder = new StringBuilder();
    g.Ej();
    localObject = g.Ek() + (String)localObject;
    GMTrace.o(590289567744L, 4398);
    return (String)localObject;
  }
  
  private static CdnLogic.CdnInfoParams a(ie paramie)
  {
    GMTrace.i(15218411307008L, 113386);
    CdnLogic.CdnInfoParams localCdnInfoParams = new CdnLogic.CdnInfoParams();
    localCdnInfoParams.c2CretryIntervalMs = paramie.tkV;
    localCdnInfoParams.c2CrwtimeoutMs = paramie.tkX;
    localCdnInfoParams.c2CshowErrorDelayMs = paramie.tkT;
    localCdnInfoParams.snsretryIntervalMs = paramie.tkW;
    localCdnInfoParams.snsrwtimeoutMs = paramie.tkY;
    localCdnInfoParams.snsshowErrorDelayMs = paramie.tkU;
    GMTrace.o(15218411307008L, 113386);
    return localCdnInfoParams;
  }
  
  private static void e(byte[] paramArrayOfByte, String paramString)
  {
    GMTrace.i(590423785472L, 4399);
    if (bf.bm(paramArrayOfByte))
    {
      v.w("MicroMsg.NetSceneGetCDNDns", "saveToCache failed infoBuf is null");
      GMTrace.o(590423785472L, 4399);
      return;
    }
    paramString = Eh() + paramString;
    if (bf.mA(paramString))
    {
      GMTrace.o(590423785472L, 4399);
      return;
    }
    try
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(paramArrayOfByte.length + 8);
      localByteBuffer.putLong(bf.Nz());
      localByteBuffer.put(paramArrayOfByte);
      com.tencent.mm.a.e.b(paramString, localByteBuffer.array(), localByteBuffer.array().length);
      GMTrace.o(590423785472L, 4399);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      v.e("MicroMsg.NetSceneGetCDNDns", "exception:%s", new Object[] { bf.g(paramArrayOfByte) });
      v.w("MicroMsg.NetSceneGetCDNDns", "saveToCache failed path:%s e:%s", new Object[] { paramString, paramArrayOfByte.getMessage() });
      GMTrace.o(590423785472L, 4399);
    }
  }
  
  private static void f(byte[] paramArrayOfByte, String paramString)
  {
    GMTrace.i(590826438656L, 4402);
    if (bf.bm(paramArrayOfByte))
    {
      v.w("MicroMsg.NetSceneGetCDNDns", "saveToCache failed infoBuf is null");
      GMTrace.o(590826438656L, 4402);
      return;
    }
    paramString = Eh() + paramString;
    if (bf.mA(paramString))
    {
      GMTrace.o(590826438656L, 4402);
      return;
    }
    try
    {
      com.tencent.mm.a.e.b(paramString, paramArrayOfByte, paramArrayOfByte.length);
      GMTrace.o(590826438656L, 4402);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      v.e("MicroMsg.NetSceneGetCDNDns", "exception:%s", new Object[] { bf.g(paramArrayOfByte) });
      v.w("MicroMsg.NetSceneGetCDNDns", "saveRuleToCache failed path:%s e:%s", new Object[] { paramString, paramArrayOfByte.getMessage() });
      GMTrace.o(590826438656L, 4402);
    }
  }
  
  private if iS(String paramString)
  {
    GMTrace.i(590558003200L, 4400);
    Object localObject = bf.ap(Eh(), "");
    if (bf.mA((String)localObject))
    {
      GMTrace.o(590558003200L, 4400);
      return null;
    }
    a locala = (a)this.hyv.get(localObject);
    if (locala == null)
    {
      v.e("MicroMsg.NetSceneGetCDNDns", "cdntra getFromCache  lastGetResult is null path:%s", new Object[] { localObject });
      GMTrace.o(590558003200L, 4400);
      return null;
    }
    paramString = (String)localObject + paramString;
    byte[] arrayOfByte = com.tencent.mm.a.e.d(paramString, 0, -1);
    if (bf.bm(arrayOfByte))
    {
      v.e("MicroMsg.NetSceneGetCDNDns", "cdntra getFromCache  read file failed:%s", new Object[] { paramString });
      locala.hyw = false;
      GMTrace.o(590558003200L, 4400);
      return null;
    }
    try
    {
      localObject = ByteBuffer.wrap(arrayOfByte);
      long l1 = ((ByteBuffer)localObject).getLong();
      long l2 = bf.Nz();
      if ((l2 - l1 > 3600L) || (l1 > l2))
      {
        v.w("MicroMsg.NetSceneGetCDNDns", "cdntra getFromCache  file is timeout remove it :%s, time[%d, %d]", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l2) });
        com.tencent.mm.loader.stub.b.deleteFile(paramString);
        locala.hyw = true;
        localObject = com.tencent.mm.plugin.report.service.g.oSF;
        if (l1 > l2) {}
        for (l1 = 2L;; l1 = 3L)
        {
          ((com.tencent.mm.plugin.report.service.g)localObject).a(546L, l1, 1L, true);
          GMTrace.o(590558003200L, 4400);
          return null;
        }
      }
      arrayOfByte = new byte[arrayOfByte.length - 8];
      ((ByteBuffer)localObject).get(arrayOfByte);
      locala.hyw = false;
      localObject = (if)new if().aD(arrayOfByte);
      GMTrace.o(590558003200L, 4400);
      return (if)localObject;
    }
    catch (Exception localException)
    {
      locala.hyw = false;
      v.e("MicroMsg.NetSceneGetCDNDns", "exception:%s", new Object[] { bf.g(localException) });
      v.w("MicroMsg.NetSceneGetCDNDns", "parse from file failed :%s  e:%s", new Object[] { paramString, localException.getMessage() });
      GMTrace.o(590558003200L, 4400);
    }
    return null;
  }
  
  private static byte[] iT(String paramString)
  {
    GMTrace.i(590692220928L, 4401);
    Object localObject = Eh();
    if (bf.mA((String)localObject))
    {
      GMTrace.o(590692220928L, 4401);
      return null;
    }
    paramString = (String)localObject + paramString;
    localObject = com.tencent.mm.a.e.d(paramString, 0, -1);
    if (bf.bm((byte[])localObject))
    {
      v.e("MicroMsg.NetSceneGetCDNDns", "cdntra getRuleFromCache  read file failed:%s", new Object[] { paramString });
      GMTrace.o(590692220928L, 4401);
      return null;
    }
    GMTrace.o(590692220928L, 4401);
    return (byte[])localObject;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(590155350016L, 4397);
    this.gUt = parame1;
    h.vG();
    int i = a.uH();
    if (i == 0)
    {
      v.e("MicroMsg.NetSceneGetCDNDns", "has not set uin.");
      GMTrace.o(590155350016L, 4397);
      return -1;
    }
    if (hyu != i)
    {
      hyu = i;
      this.hyv.clear();
    }
    long l = bf.Nz();
    Object localObject;
    if (this.scene == 0)
    {
      localObject = bf.ap(Eh(), "");
      parame1 = (a)this.hyv.get(localObject);
      if (parame1 != null) {
        break label710;
      }
      parame1 = new a();
      this.hyv.put(localObject, parame1);
    }
    label704:
    label710:
    for (;;)
    {
      if localif1 = iS("");
      if localif2 = iS("sns");
      if localif3 = iS("app");
      if localif4 = iS("safec2c");
      byte[] arrayOfByte1 = iT("c2crule");
      byte[] arrayOfByte2 = iT("safec2crule");
      v.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn doScene info[%s], safec2cinfo[%s], path[%s], lastGetResult[%s]", new Object[] { localif1, localif4, localObject, parame1 });
      if ((localif1 != null) && (arrayOfByte1 != null))
      {
        boolean bool = g.En().a(localif1, localif2, localif3, arrayOfByte1, arrayOfByte2, localif4);
        v.i("MicroMsg.NetSceneGetCDNDns", "cdntra getfromcache succ , setCDNDnsInfo :%b ", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          GMTrace.o(590155350016L, 4397);
          return -1;
        }
      }
      if (parame1.hyw)
      {
        parame1.hyx = l;
        parame1.hyy = l;
        parame1.hyz = 0L;
      }
      v.d("MicroMsg.NetSceneGetCDNDns", "cdntra doscene Sec:%d Hour[%d,%d]", new Object[] { Long.valueOf(l - parame1.hyx), Long.valueOf(l - parame1.hyy), Long.valueOf(parame1.hyz) });
      if ((l > parame1.hyx) && (l - parame1.hyx < 10L))
      {
        v.w("MicroMsg.NetSceneGetCDNDns", "Last get dns at %d ago . ignore!, lastGetResult[%s]", new Object[] { Long.valueOf(l - parame1.hyx), parame1 });
        GMTrace.o(590155350016L, 4397);
        return -1;
      }
      if ((l > parame1.hyy) && (l - parame1.hyy < 3600L) && (parame1.hyz >= 90L))
      {
        v.w("MicroMsg.NetSceneGetCDNDns", "in 1 hour , get dns more than 90  (%d). ignore!, lastGetResult[%s]", new Object[] { Long.valueOf(l - parame1.hyy), parame1 });
        GMTrace.o(590155350016L, 4397);
        return -1;
      }
      parame1.hyx = l;
      if ((l < parame1.hyy) || (l - parame1.hyz > 3600L))
      {
        parame1.hyy = l;
        parame1.hyz = 0L;
        this.startTime = l;
        parame1 = com.tencent.mm.plugin.report.service.g.oSF;
        if (this.scene != 0) {
          break label704;
        }
      }
      for (l = 0L;; l = 1L)
      {
        parame1.a(546L, l, 1L, true);
        i = a(parame, this.gUq, this);
        GMTrace.o(590155350016L, 4397);
        return i;
        parame1.hyz += 1L;
        break;
        parame1 = this.hyv.values().iterator();
        if (parame1 == null) {
          break;
        }
        while (parame1.hasNext())
        {
          localObject = (a)parame1.next();
          if (localObject != null)
          {
            ((a)localObject).hyx = l;
            if ((l < ((a)localObject).hyy) || (l - ((a)localObject).hyz > 3600L))
            {
              ((a)localObject).hyy = l;
              ((a)localObject).hyz = 0L;
            }
            else
            {
              ((a)localObject).hyz += 1L;
            }
          }
        }
        break;
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(590960656384L, 4403);
    v.d("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3);
    vu localvu = (vu)((com.tencent.mm.y.b)paramp).hrT.hsa;
    if ((paramInt2 != 0) || (paramInt3 != 0) || (localvu.tnv == null))
    {
      com.tencent.mm.plugin.report.service.g.oSF.i(10769, new Object[] { Integer.valueOf(d.hyt), Integer.valueOf(0), Long.valueOf(this.startTime) });
      if (localvu.tnv == null) {}
      for (boolean bool = true;; bool = false)
      {
        v.w("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd: [%d ,%d]  info is null :%b", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(bool) });
        this.gUt.a(paramInt2, paramInt3, paramString, this);
        GMTrace.o(590960656384L, 4403);
        return;
      }
    }
    this.hyv.clear();
    paramArrayOfByte = null;
    paramp = paramArrayOfByte;
    if (localvu.tny != null)
    {
      paramp = paramArrayOfByte;
      if (localvu.tny.tXB > 0)
      {
        v.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd cdnrule:%d", new Object[] { Integer.valueOf(localvu.tny.tXB) });
        paramp = n.a(localvu.tny);
      }
    }
    byte[] arrayOfByte = null;
    paramArrayOfByte = arrayOfByte;
    if (localvu.tnz != null)
    {
      paramArrayOfByte = arrayOfByte;
      if (localvu.tnz.tXB > 0)
      {
        v.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd safecdnrule:%d", new Object[] { Integer.valueOf(localvu.tnz.tXB) });
        paramArrayOfByte = n.a(localvu.tnz);
      }
    }
    v.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo:%s", new Object[] { localvu.tnA });
    if (localvu.tnA != null) {
      v.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo FakeUin:%d NewAuthKey:%s", new Object[] { Integer.valueOf(localvu.tnA.lcP), localvu.tnA.tlf });
    }
    if (!g.En().a(localvu.tnv, localvu.tnw, localvu.tnx, paramp, paramArrayOfByte, localvu.tnA))
    {
      v.e("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd setCDNDnsInfo failed ");
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(590960656384L, 4403);
      return;
    }
    v.i("MicroMsg.NetSceneGetCDNDns", "getcdndns defaultcfg %s, disastercfg %s, getcdninterval %d", new Object[] { localvu.tnC, localvu.tnD, Integer.valueOf(localvu.tnB) });
    if ((localvu.tnC != null) && (localvu.tnD != null)) {
      CdnLogic.setCdnInfoParams(a(localvu.tnC), a(localvu.tnD), localvu.tnB);
    }
    try
    {
      arrayOfByte = localvu.tnv.toByteArray();
      e(arrayOfByte, "");
    }
    catch (Exception localException3)
    {
      try
      {
        arrayOfByte = localvu.tnw.toByteArray();
        e(arrayOfByte, "sns");
      }
      catch (Exception localException3)
      {
        try
        {
          arrayOfByte = localvu.tnx.toByteArray();
          e(arrayOfByte, "app");
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              arrayOfByte = localvu.tnA.toByteArray();
              e(arrayOfByte, "safec2c");
              if (paramp != null) {
                f(paramp, "c2crule");
              }
              if (paramArrayOfByte != null) {
                f(paramArrayOfByte, "safec2crule");
              }
              this.gUt.a(paramInt2, paramInt3, paramString, this);
              GMTrace.o(590960656384L, 4403);
              return;
              localException1 = localException1;
              v.w("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd getDnsInfo toByteArray failed: %s", new Object[] { localException1.getMessage() });
              v.e("MicroMsg.NetSceneGetCDNDns", "exception:%s", new Object[] { bf.g(localException1) });
              Object localObject1 = null;
              continue;
              localException2 = localException2;
              v.w("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd getsnsDnsInfo toByteArray failed: %s", new Object[] { localException2.getMessage() });
              v.e("MicroMsg.NetSceneGetCDNDns", "exception:%s", new Object[] { bf.g(localException2) });
              Object localObject2 = null;
            }
            localException3 = localException3;
            v.w("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd getappDnsInfo toByteArray failed: %s", new Object[] { localException3.getMessage() });
            v.e("MicroMsg.NetSceneGetCDNDns", "exception:%s", new Object[] { bf.g(localException3) });
            Object localObject3 = null;
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              v.w("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd getappDnsInfo toByteArray failed: %s", new Object[] { localException4.getMessage() });
              v.e("MicroMsg.NetSceneGetCDNDns", "exception:%s", new Object[] { bf.g(localException4) });
              Object localObject4 = null;
            }
          }
        }
      }
    }
  }
  
  public final int getType()
  {
    GMTrace.i(591094874112L, 4404);
    GMTrace.o(591094874112L, 4404);
    return 379;
  }
  
  static final class a
  {
    boolean hyw;
    long hyx;
    long hyy;
    long hyz;
    
    a()
    {
      GMTrace.i(581968068608L, 4336);
      this.hyw = false;
      this.hyx = 0L;
      this.hyy = 0L;
      this.hyz = 0L;
      GMTrace.o(581968068608L, 4336);
    }
    
    public final String toString()
    {
      GMTrace.i(582102286336L, 4337);
      String str = String.format("LastGetResult(%x){isTimeOut=%b, lastGetCDNDns_TenSecond=%d, lastTime_Hour=%d, lastCount_Hour=%d}", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.hyw), Long.valueOf(this.hyx), Long.valueOf(this.hyy), Long.valueOf(this.hyz) });
      GMTrace.o(582102286336L, 4337);
      return str;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelcdntran/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */