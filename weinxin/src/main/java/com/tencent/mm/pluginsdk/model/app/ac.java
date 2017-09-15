package com.tencent.mm.pluginsdk.model.app;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.n;
import com.tencent.mm.network.j;
import com.tencent.mm.plugin.w.a;
import com.tencent.mm.protocal.c.aon;
import com.tencent.mm.protocal.c.ud;
import com.tencent.mm.protocal.c.ue;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.b;

public final class ac
  extends k
  implements j
{
  private static final String[] sCk;
  final String appId;
  private com.tencent.mm.y.b gUq;
  private com.tencent.mm.y.e gUt;
  private final int hRU;
  
  static
  {
    GMTrace.i(795105820672L, 5924);
    sCk = new String[] { "wxf109da3e26cf89f1", "wxc56bba830743541e", "wx41dd4f6ef137bd0b" };
    GMTrace.o(795105820672L, 5924);
  }
  
  public ac(String paramString)
  {
    GMTrace.i(794434732032L, 5919);
    this.appId = paramString;
    this.hRU = 3;
    paramString = new b.a();
    paramString.hrV = new ud();
    paramString.hrW = new ue();
    paramString.uri = "/cgi-bin/micromsg-bin/getappinfo";
    paramString.hrU = 231;
    paramString.hrX = 0;
    paramString.hrY = 0;
    this.gUq = paramString.BE();
    GMTrace.o(794434732032L, 5919);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(794568949760L, 5920);
    this.gUt = parame1;
    if ((this.appId == null) || (this.appId.length() == 0))
    {
      v.e("MicroMsg.NetSceneGetAppInfo", "doScene fail, appId is null");
      GMTrace.o(794568949760L, 5920);
      return -1;
    }
    parame1 = (ud)this.gUq.hrS.hsa;
    parame1.mqG = this.appId;
    parame1.tuq = this.hRU;
    int i = a(parame, this.gUq, this);
    GMTrace.o(794568949760L, 5920);
    return i;
  }
  
  protected final int a(com.tencent.mm.network.p paramp)
  {
    GMTrace.i(794971602944L, 5923);
    int i = k.b.hsC;
    GMTrace.o(794971602944L, 5923);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(794703167488L, 5921);
    v.d("MicroMsg.NetSceneGetAppInfo", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 4) && (paramInt3 == 64525))
    {
      v.e("MicroMsg.NetSceneGetAppInfo", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", appinfo does not exist");
      a.aRk();
      paramp = i.bCU();
      paramp.field_appId = this.appId;
      a.aRk().a(paramp);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(794703167488L, 5921);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      v.e("MicroMsg.NetSceneGetAppInfo", "errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(794703167488L, 5921);
      return;
    }
    Object localObject1 = (ue)((com.tencent.mm.y.b)paramp).hrT.hsa;
    paramArrayOfByte = ((ue)localObject1).tAB.tcA;
    Object localObject2 = ((ue)localObject1).tAB;
    if (localObject2 == null)
    {
      v.e("MicroMsg.NetSceneGetAppInfo", "convertToAppInfo : openAppInfo is null");
      paramp = null;
    }
    while (paramp == null)
    {
      v.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : info is null");
      this.gUt.a(3, -1, paramString, this);
      GMTrace.o(794703167488L, 5921);
      return;
      paramp = new f();
      paramp.field_appId = ((aon)localObject2).mqG;
      paramp.field_appName = ((aon)localObject2).mtr;
      paramp.field_appDiscription = ((aon)localObject2).tRT;
      paramp.field_appIconUrl = ((aon)localObject2).tcy;
      paramp.field_appStoreUrl = ((aon)localObject2).mrc;
      paramp.field_appVersion = ((aon)localObject2).tiP;
      paramp.field_appWatermarkUrl = ((aon)localObject2).tRU;
      paramp.field_packageName = ((aon)localObject2).tcA;
      paramp.field_signature = p.Mh(((aon)localObject2).tiO);
      paramp.field_appName_en = ((aon)localObject2).tRV;
      paramp.field_appName_tw = ((aon)localObject2).tRX;
      paramp.field_appDiscription_en = ((aon)localObject2).tRW;
      paramp.field_appDiscription_tw = ((aon)localObject2).tRY;
      paramp.field_appInfoFlag = ((aon)localObject2).mqO;
      v.d("MicroMsg.NetSceneGetAppInfo", "appid = %s, appInfoFlag = %s", new Object[] { paramp.field_appId, Integer.valueOf(paramp.field_appInfoFlag) });
    }
    paramp.field_appType = ((ue)localObject1).tft;
    localObject2 = ((ue)localObject1).tAB;
    localObject1 = ((aon)localObject2).tcA;
    localObject2 = ((aon)localObject2).tiO;
    if ((localObject1 == null) || (((String)localObject1).length() == 0) || (localObject2 == null) || (((String)localObject2).length() == 0)) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if ((paramInt1 != 0) || (paramp.bCM()))
      {
        v.e("MicroMsg.NetSceneGetAppInfo", "no android app, packageName = " + paramArrayOfByte);
        com.tencent.mm.pluginsdk.ui.tools.b.Ni(this.appId);
      }
      if (paramp.field_appId != null) {
        break;
      }
      v.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : info.appId is null");
      this.gUt.a(3, -1, paramString, this);
      GMTrace.o(794703167488L, 5921);
      return;
    }
    if (!paramp.field_appId.equals(this.appId))
    {
      v.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : appId is different");
      this.gUt.a(3, -1, paramString, this);
      GMTrace.o(794703167488L, 5921);
      return;
    }
    paramArrayOfByte = a.aRk();
    localObject1 = paramArrayOfByte.Md(this.appId);
    if ((localObject1 == null) || (((f)localObject1).field_appId == null) || (((f)localObject1).field_appId.length() == 0))
    {
      if (paramInt1 != 0)
      {
        paramInt1 = 3;
        paramp.field_status = paramInt1;
        paramp.field_modifyTime = System.currentTimeMillis();
        if (paramp.field_appId != null) {
          paramInt1 = 0;
        }
      }
      for (;;)
      {
        if (paramInt1 < sCk.length)
        {
          if (paramp.field_appId.equals(sCk[paramInt1])) {
            paramp.field_status = -1;
          }
        }
        else
        {
          if (paramArrayOfByte.l(paramp)) {
            break label817;
          }
          v.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : insert fail");
          this.gUt.a(3, -1, paramString, this);
          GMTrace.o(794703167488L, 5921);
          return;
          paramInt1 = 4;
          break;
        }
        paramInt1 += 1;
      }
      label817:
      a.aRi().cu(this.appId, 1);
      a.aRi().cu(this.appId, 2);
      a.aRi().cu(this.appId, 3);
      a.aRi().cu(this.appId, 4);
      a.aRi().cu(this.appId, 5);
    }
    label966:
    label1064:
    label1071:
    label1297:
    label1529:
    for (;;)
    {
      if (bf.mA(paramp.field_openId))
      {
        v.d("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd, openId is null, trigger getAppSetting, appId = " + paramp.field_appId);
        a.aRl().Jj(paramp.field_appId);
      }
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(794703167488L, 5921);
      return;
      if (paramInt1 != 0)
      {
        paramInt1 = 3;
        paramp.field_status = paramInt1;
        if (paramp.field_appId != null)
        {
          paramInt1 = 0;
          if (paramInt1 < sCk.length)
          {
            if (!paramp.field_appId.equals(sCk[paramInt1])) {
              break label1064;
            }
            paramp.field_status = -1;
          }
        }
        if (localObject1 != null) {
          break label1071;
        }
        v.e("MicroMsg.NetSceneGetAppInfo", "merge failed, some appinfo is null");
      }
      for (;;)
      {
        if (paramArrayOfByte.a(paramp, new String[0])) {
          break label1297;
        }
        v.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : update fail");
        this.gUt.a(3, -1, paramString, this);
        GMTrace.o(794703167488L, 5921);
        return;
        paramInt1 = ((f)localObject1).field_status;
        break;
        paramInt1 += 1;
        break label966;
        if (((f)localObject1).bCN())
        {
          if (!bf.mA(((f)localObject1).field_appIconUrl)) {
            paramp.field_appIconUrl = ((f)localObject1).field_appIconUrl;
          }
          if (!bf.mA(((f)localObject1).field_appName)) {
            paramp.field_appName = ((f)localObject1).field_appName;
          }
          if (!bf.mA(((f)localObject1).field_appName_en)) {
            paramp.field_appName_en = ((f)localObject1).field_appName_en;
          }
          if (!bf.mA(((f)localObject1).field_appName_tw)) {
            paramp.field_appName_tw = ((f)localObject1).field_appName_tw;
          }
          if (!bf.mA(((f)localObject1).field_appName_hk)) {
            paramp.field_appName_hk = ((f)localObject1).field_appName_hk;
          }
        }
        if ((bf.mA(paramp.field_appId)) || (bf.mA(((f)localObject1).field_appId)))
        {
          v.e("MicroMsg.NetSceneGetAppInfo", "merge failed, some appid is null");
        }
        else if (!paramp.field_appId.equalsIgnoreCase(((f)localObject1).field_appId))
        {
          v.e("MicroMsg.NetSceneGetAppInfo", "merge failed, appis is different");
        }
        else
        {
          paramp.field_openId = ((f)localObject1).field_openId;
          paramp.field_authFlag = ((f)localObject1).field_authFlag;
          paramp.bB(((n)localObject1).geQ);
          paramp.bC(((n)localObject1).geR);
          paramp.bD(((n)localObject1).geS);
        }
      }
      if ((localObject1 == null) || (((f)localObject1).field_appIconUrl == null) || (((f)localObject1).field_appIconUrl.length() == 0)) {
        paramInt1 = 1;
      }
      for (;;)
      {
        if (paramInt1 == 0) {
          break label1529;
        }
        a.aRi().cu(this.appId, 1);
        a.aRi().cu(this.appId, 2);
        a.aRi().cu(this.appId, 3);
        a.aRi().cu(this.appId, 4);
        a.aRi().cu(this.appId, 5);
        break;
        if (!bf.mA(paramp.gfk))
        {
          if (bf.mA(((n)localObject1).gfk))
          {
            paramInt1 = 1;
            continue;
          }
          if (!((n)localObject1).gfk.equals(((n)localObject1).gfk))
          {
            paramInt1 = 1;
            continue;
          }
        }
        if (!bf.mA(paramp.gfl))
        {
          if (bf.mA(((n)localObject1).gfl))
          {
            paramInt1 = 1;
            continue;
          }
          if (!((n)localObject1).gfl.equals(((n)localObject1).gfl))
          {
            paramInt1 = 1;
            continue;
          }
        }
        if ((paramp.field_appIconUrl == null) || (paramp.field_appIconUrl.length() == 0)) {
          paramInt1 = 0;
        } else if (!((f)localObject1).field_appIconUrl.equals(paramp.field_appIconUrl)) {
          paramInt1 = 1;
        } else {
          paramInt1 = 0;
        }
      }
    }
  }
  
  public final int getType()
  {
    GMTrace.i(794837385216L, 5922);
    GMTrace.o(794837385216L, 5922);
    return 231;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */