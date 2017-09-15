package com.tencent.c.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Proxy;
import android.os.Build;
import com.tencent.c.e.d;
import com.tencent.c.e.d.a;
import com.tencent.c.e.i;

public final class b
{
  private String mChannelId = null;
  private Context mContext = null;
  private String mVersionName = null;
  private int wOG = -1;
  private int wOH = -1;
  private String wOI = null;
  private com.tencent.c.c.a.c wOJ = null;
  private com.tencent.c.c.a.a wOK = null;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
    paramContext = com.tencent.c.e.a.bt(paramContext, paramContext.getPackageName());
    this.mVersionName = paramContext.versionName;
    this.wOH = paramContext.versionCode;
    this.wOG = 82;
    this.mChannelId = "105901";
    this.wOI = "C5FF2F9C793FB359";
  }
  
  private static String UX(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private com.tencent.c.c.a.c cdv()
  {
    if (this.wOJ == null)
    {
      this.wOJ = new com.tencent.c.c.a.c();
      this.wOJ.wOU = this.wOG;
      this.wOJ.wOZ = this.wOH;
      this.wOJ.wOR = this.mChannelId;
      this.wOJ.wOQ = this.wOI;
    }
    try
    {
      localObject = this.mVersionName.trim().split("[\\.]");
      if ((localObject == null) || (localObject.length < 3)) {
        break label432;
      }
      k = Integer.parseInt(localObject[0]);
      j = Integer.parseInt(localObject[1]);
      i = Integer.parseInt(localObject[2]);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        Context localContext;
        NetworkInfo localNetworkInfo;
        continue;
        int i = 0;
        int j = 0;
        int k = 0;
      }
    }
    this.wOJ.wOV = new com.tencent.c.c.a.b();
    this.wOJ.wOV.wON = k;
    this.wOJ.wOV.wOO = j;
    this.wOJ.wOV.wOP = i;
    this.wOJ.wOW = 0;
    this.wOJ.wOY = d.ccV();
    this.wOJ.imei = UX(d.fz(this.mContext));
    this.wOJ.imsi = UX(d.fA(this.mContext));
    this.wOJ.wOS = UX(Build.MODEL);
    this.wOJ.qcv = UX(d.fB(this.mContext));
    this.wOJ.wPf = UX(d.lX(true));
    this.wOJ.wPg = UX(d.lX(false));
    this.wOJ.guid = null;
    this.wOJ.wOX = 0;
    localObject = this.wOJ;
    localContext = this.mContext;
    localNetworkInfo = ((ConnectivityManager)localContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || ((localNetworkInfo.getState() != NetworkInfo.State.CONNECTING) && (localNetworkInfo.getState() != NetworkInfo.State.CONNECTED)))
    {
      i = d.a.wQo;
      if (i != d.a.wQl) {
        break label422;
      }
    }
    label422:
    for (i = 2;; i = 1)
    {
      ((com.tencent.c.c.a.c)localObject).wOT = i;
      return this.wOJ;
      if (localNetworkInfo.getType() == 1)
      {
        i = d.a.wQl;
        break;
      }
      if (localNetworkInfo.getType() == 0)
      {
        if ((Proxy.getDefaultHost() != null) || (Proxy.getHost(localContext) != null))
        {
          i = d.a.wQm;
          break;
        }
        i = d.a.wQn;
        break;
      }
      i = d.a.wQo;
      break;
    }
  }
  
  public final byte[] a(com.tencent.c.c.b.a parama)
  {
    try
    {
      i locali = new i();
      locali.cdD();
      locali.Vg("viruscheck");
      locali.Vh("RiskCheck");
      locali.Vf("UTF-8");
      if (this.wOK == null)
      {
        this.wOK = new com.tencent.c.c.a.a();
        this.wOK.wOL = 2;
        this.wOK.wOM = 201;
      }
      locali.put("phonetype", this.wOK);
      locali.put("userinfo", cdv());
      locali.put("req", parama);
      parama = com.tencent.c.e.b.l(locali.nW());
      if (parama == null) {
        throw new RuntimeException("compress data fail");
      }
      parama = com.tencent.c.e.c.j(parama, com.tencent.c.e.c.cdB());
      return parama;
    }
    catch (Exception parama) {}
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/c/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */