package com.tencent.mm.plugin.sns.a.a;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ax;
import com.tencent.mm.protocal.c.ay;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;

public final class c
  extends k
  implements j
{
  private b gUq;
  public com.tencent.mm.y.e gUt;
  
  public c(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3)
  {
    this(paramString1, paramInt1, paramInt2, paramString2, paramInt3, 0, 0, "");
    GMTrace.i(8159632556032L, 60794);
    GMTrace.o(8159632556032L, 60794);
  }
  
  public c(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4, int paramInt5, String paramString3)
  {
    GMTrace.i(8159766773760L, 60795);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new ax();
    ((b.a)localObject).hrW = new ay();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/ad/click";
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/ad/click";
    ((b.a)localObject).hrU = 1232;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    v.i("MicroMsg.NetSceneAdClick", "NetSceneAdClick clickPos: " + paramInt1 + " viewId: " + paramString1 + " sceneType: " + paramInt2 + " adtype " + paramInt3 + ", clickAction " + paramInt4 + ",source " + paramInt5 + ", descXml " + paramString2);
    if (!bf.mA(paramString2)) {
      v.i("MicroMsg.NetSceneAdClick", "descXml: " + paramString2);
    }
    localObject = (ax)this.gUq.hrS.hsa;
    ((ax)localObject).hSV = paramInt1;
    ((ax)localObject).hSS = paramString1;
    ((ax)localObject).scene = paramInt2;
    ((ax)localObject).tcE = paramString2;
    paramString1 = (WifiManager)aa.getContext().getSystemService("wifi");
    if (paramString1 != null)
    {
      paramString1 = paramString1.getConnectionInfo();
      if (paramString1 != null)
      {
        ((ax)localObject).bssid = bf.ap(paramString1.getBSSID(), "");
        ((ax)localObject).ssid = bf.ap(paramString1.getSSID(), "");
      }
    }
    ((ax)localObject).tcF = System.currentTimeMillis();
    ((ax)localObject).tcH = paramInt3;
    ((ax)localObject).tcI = paramInt4;
    ((ax)localObject).cFR = paramInt5;
    ((ax)localObject).tcJ = paramString3;
    GMTrace.o(8159766773760L, 60795);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(8159900991488L, 60796);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(8159900991488L, 60796);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(8160169426944L, 60798);
    v.d("MicroMsg.NetSceneAdClick", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(8160169426944L, 60798);
  }
  
  public final int getType()
  {
    GMTrace.i(8160035209216L, 60797);
    GMTrace.o(8160035209216L, 60797);
    return 1232;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/sns/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */