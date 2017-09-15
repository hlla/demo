package com.tencent.mm.pluginsdk.model.app;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.w.a;
import com.tencent.mm.protocal.c.gm;
import com.tencent.mm.protocal.c.ub;
import com.tencent.mm.protocal.c.uc;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ad
  extends w
{
  private static final String[] sCk;
  
  static
  {
    GMTrace.i(805306368000L, 6000);
    sCk = new String[] { "wxf109da3e26cf89f1", "wxc56bba830743541e", "wx41dd4f6ef137bd0b" };
    GMTrace.o(805306368000L, 6000);
  }
  
  public ad(List<String> paramList)
  {
    GMTrace.i(804501061632L, 5994);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new ub();
    ((b.a)localObject).hrW = new uc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getappinfolist";
    ((b.a)localObject).hrU = 451;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.lbI = ((b.a)localObject).BE();
    localObject = (ub)this.lbI.hrS.hsa;
    LinkedList localLinkedList = new LinkedList();
    if (paramList != null)
    {
      String[] arrayOfString = new String[paramList.size()];
      paramList.toArray(arrayOfString);
      int j = arrayOfString.length;
      while (i < j)
      {
        paramList = arrayOfString[i];
        if (!bf.mA(paramList)) {
          localLinkedList.add(com.tencent.mm.platformtools.n.mw(paramList));
        }
        i += 1;
      }
    }
    ((ub)localObject).tAz = localLinkedList;
    ((ub)localObject).jLr = localLinkedList.size();
    GMTrace.o(804501061632L, 5994);
  }
  
  private static void a(f paramf, gm paramgm)
  {
    int k = 0;
    GMTrace.i(804903714816L, 5997);
    if (paramf == null)
    {
      paramf = new f();
      paramf.field_appId = paramgm.mrA;
    }
    for (int i = 1;; i = 0)
    {
      v.i("MicroMsg.NetSceneGetAppInfoList", "appid:[%s], appinfoflag:[%d] AppSupportContentType:%d", new Object[] { paramgm.mrA, Integer.valueOf(paramgm.mqO), Long.valueOf(paramgm.tiU) });
      v.i("MicroMsg.NetSceneGetAppInfoList", "appId=%s, appName=%s, status=%s, appInfoFlag=%s", new Object[] { paramf.field_appId, paramf.field_appName, Integer.valueOf(paramf.field_status), Integer.valueOf(paramf.field_appInfoFlag) });
      if ((!paramf.bCN()) || (bf.mA(paramf.field_appName))) {
        paramf.field_appName = paramgm.mqI;
      }
      if ((!paramf.bCN()) || (bf.mA(paramf.field_appName_en))) {
        paramf.field_appName_en = paramgm.tiG;
      }
      if ((!paramf.bCN()) || (bf.mA(paramf.field_appName_tw))) {
        paramf.field_appName_tw = paramgm.tiI;
      }
      paramf.field_appDiscription = paramgm.tfn;
      paramf.field_appDiscription_en = paramgm.tiH;
      paramf.field_appDiscription_tw = paramgm.tiJ;
      paramf.field_appWatermarkUrl = paramgm.tiN;
      paramf.field_packageName = paramgm.tcA;
      paramf.field_signature = p.Mh(paramgm.tiO);
      v.i("MicroMsg.NetSceneGetAppInfoList", "get signature, server sig : %s, gen sig: %s ", new Object[] { paramgm.tiO, paramf.field_signature });
      paramf.field_appType = paramgm.tft;
      if ((!bf.mA(paramf.field_appType)) && ((paramf.field_appType.startsWith("1")) || (paramf.field_appType.startsWith("6")))) {
        paramf.field_appType = ("," + paramf.field_appType);
      }
      paramf.field_appInfoFlag = paramgm.mqO;
      paramf.field_appVersion = paramgm.tiP;
      paramf.bC(paramgm.tfv);
      paramf.field_appWatermarkUrl = paramgm.tiN;
      if ((!bf.mA(paramgm.tiS)) && (!bf.mA(paramgm.tiT)))
      {
        v.i("MicroMsg.NetSceneGetAppInfoList", "get app download url and download md5 : [%s], [%s], [%s]", new Object[] { paramf.field_appName, paramgm.tiS, paramgm.tiT });
        paramf.bD(paramgm.tiS);
        paramf.bG(paramgm.tiT);
      }
      paramf.bH(paramgm.tcB);
      paramf.field_svrAppSupportContentType = paramgm.tiU;
      if (paramgm.tiQ > paramf.geT)
      {
        paramf.geU = 1;
        paramf.geo = true;
      }
      paramf.geT = paramgm.tiQ;
      paramf.geo = true;
      Object localObject = paramgm.tcA;
      String str = paramgm.tcA;
      int j;
      if ((localObject == null) || (((String)localObject).length() == 0) || (str == null) || (str.length() == 0))
      {
        j = 1;
        if (j != 0) {
          v.e("MicroMsg.NetSceneGetAppInfoList", "no android app, packageName = " + paramgm.tcA + "appid: " + paramf.field_appId);
        }
        if (paramf.bCM()) {
          com.tencent.mm.pluginsdk.ui.tools.b.Ni(paramf.field_appId);
        }
        localObject = a.aRk();
        if (i == 0) {
          break label765;
        }
        if (j == 0) {
          break label688;
        }
        i = 3;
        label598:
        paramf.field_status = i;
        paramf.field_modifyTime = System.currentTimeMillis();
        paramf.field_appIconUrl = paramgm.tiL;
        if (paramf.field_appId != null) {
          i = k;
        }
      }
      for (;;)
      {
        if (i < sCk.length)
        {
          if (paramf.field_appId.equals(sCk[i])) {
            paramf.field_status = -1;
          }
        }
        else
        {
          if (((i)localObject).l(paramf)) {
            break label700;
          }
          v.e("MicroMsg.NetSceneGetAppInfoList", "onGYNetEnd : insert fail");
          GMTrace.o(804903714816L, 5997);
          return;
          j = 0;
          break;
          label688:
          i = 4;
          break label598;
        }
        i += 1;
      }
      label700:
      a.aRi().cu(paramf.field_appId, 1);
      a.aRi().cu(paramf.field_appId, 2);
      a.aRi().cu(paramf.field_appId, 3);
      a.aRi().cu(paramf.field_appId, 4);
      a.aRi().cu(paramf.field_appId, 5);
      GMTrace.o(804903714816L, 5997);
      return;
      label765:
      if (j != 0)
      {
        i = 3;
        paramf.field_status = i;
        if (paramf.field_appId != null)
        {
          i = 0;
          label785:
          if (i < sCk.length)
          {
            if (!paramf.field_appId.equals(sCk[i])) {
              break label995;
            }
            paramf.field_status = -1;
          }
        }
        if ((paramf != null) && (paramf.field_appIconUrl != null) && (paramf.field_appIconUrl.length() != 0)) {
          break label1002;
        }
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          v.i("MicroMsg.NetSceneGetAppInfoList", "oldIcon = %s, newIcon = %s", new Object[] { paramf.field_appIconUrl, paramgm.tiL });
          paramf.field_appIconUrl = paramgm.tiL;
          a.aRi().cu(paramf.field_appId, 1);
          a.aRi().cu(paramf.field_appId, 2);
          a.aRi().cu(paramf.field_appId, 3);
          a.aRi().cu(paramf.field_appId, 4);
          a.aRi().cu(paramf.field_appId, 5);
        }
        boolean bool = ((i)localObject).a(paramf, new String[0]);
        v.i("MicroMsg.NetSceneGetAppInfoList", "update appinfo " + bool + ", appid = " + paramgm.mrA);
        GMTrace.o(804903714816L, 5997);
        return;
        i = paramf.field_status;
        break;
        label995:
        i += 1;
        break label785;
        label1002:
        if ((paramgm == null) || (paramgm.tiR == null) || (paramgm.tiR.length() == 0)) {
          i = 0;
        } else if (!paramf.field_appIconUrl.equals(paramgm.tiL)) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(804769497088L, 5996);
    v.d("MicroMsg.NetSceneGetAppInfoList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      v.e("MicroMsg.NetSceneGetAppInfoList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
      GMTrace.o(804769497088L, 5996);
      return;
    }
    paramString = ((uc)this.lbI.hrT.hsa).tAA;
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        paramp = (gm)paramString.next();
        if (paramp != null) {
          a(g.aJ(paramp.mrA, false), paramp);
        }
      }
    }
    GMTrace.o(804769497088L, 5996);
  }
  
  public final byte[] aBo()
  {
    GMTrace.i(805037932544L, 5998);
    try
    {
      byte[] arrayOfByte = ((b.b)this.lbI.BG()).zh();
      GMTrace.o(805037932544L, 5998);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.NetSceneGetAppInfoList", "toProtBuf failed: " + localException.getMessage());
      GMTrace.o(805037932544L, 5998);
    }
    return null;
  }
  
  public final void ar(byte[] paramArrayOfByte)
  {
    GMTrace.i(805172150272L, 5999);
    if (paramArrayOfByte == null)
    {
      v.e("MicroMsg.NetSceneGetAppInfoList", "buf is null");
      GMTrace.o(805172150272L, 5999);
      return;
    }
    try
    {
      this.lbI.hrT.y(paramArrayOfByte);
      GMTrace.o(805172150272L, 5999);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      v.e("MicroMsg.NetSceneGetAppInfoList", "parse error: " + paramArrayOfByte.getMessage());
      v.printErrStackTrace("MicroMsg.NetSceneGetAppInfoList", paramArrayOfByte, "", new Object[0]);
      GMTrace.o(805172150272L, 5999);
    }
  }
  
  public final int getType()
  {
    GMTrace.i(804635279360L, 5995);
    GMTrace.o(804635279360L, 5995);
    return 7;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */