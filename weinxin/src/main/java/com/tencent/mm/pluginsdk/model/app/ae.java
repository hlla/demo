package com.tencent.mm.pluginsdk.model.app;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.w.a;
import com.tencent.mm.protocal.c.cy;
import com.tencent.mm.protocal.c.cz;
import com.tencent.mm.protocal.c.uf;
import com.tencent.mm.protocal.c.ug;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ae
  extends w
{
  List<String> sCl;
  
  public ae(List<String> paramList)
  {
    GMTrace.i(792958337024L, 5908);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new uf();
    ((b.a)localObject).hrW = new ug();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getappsetting";
    ((b.a)localObject).hrU = 395;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.lbI = ((b.a)localObject).BE();
    this.sCl = paramList;
    v.d("MicroMsg.NetSceneGetAppSetting", "<init>, appIdList size = " + paramList.size());
    localObject = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((str != null) && (str.length() > 0))
      {
        cz localcz = new cz();
        localcz.mqG = str;
        ((LinkedList)localObject).add(localcz);
      }
    }
    if (((LinkedList)localObject).size() == 0) {
      v.e("MicroMsg.NetSceneGetAppSetting", "doScene fail, reqList is empty");
    }
    paramList = (uf)this.lbI.hrS.hsa;
    paramList.tAE = ((LinkedList)localObject);
    paramList.tAD = ((LinkedList)localObject).size();
    GMTrace.o(792958337024L, 5908);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(793092554752L, 5909);
    v.d("MicroMsg.NetSceneGetAppSetting", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      v.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, errType = " + paramInt2 + ", errCode = " + paramInt3);
      GMTrace.o(793092554752L, 5909);
      return;
    }
    paramString = (ug)this.lbI.hrT.hsa;
    v.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, resp appCount = " + paramString.tAD);
    paramp = paramString.tAF;
    if ((paramp == null) || (paramp.size() == 0))
    {
      v.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, settingList is empty");
      GMTrace.o(793092554752L, 5909);
      return;
    }
    paramString = a.aRk();
    paramp = paramp.iterator();
    while (paramp.hasNext())
    {
      paramArrayOfByte = (cy)paramp.next();
      f localf = g.aJ(paramArrayOfByte.mqG, false);
      if (localf != null)
      {
        localf.field_authFlag = paramArrayOfByte.teN;
        localf.field_openId = paramArrayOfByte.msg;
        boolean bool = paramString.a(localf, new String[0]);
        v.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, update ret = " + bool + ", appId = " + paramArrayOfByte.mqG);
      }
    }
    GMTrace.o(793092554752L, 5909);
  }
  
  public final byte[] aBo()
  {
    GMTrace.i(793226772480L, 5910);
    try
    {
      byte[] arrayOfByte = ((b.b)this.lbI.BG()).zh();
      GMTrace.o(793226772480L, 5910);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.NetSceneGetAppSetting", "toProtBuf error: " + localException.getMessage());
      v.printErrStackTrace("MicroMsg.NetSceneGetAppSetting", localException, "", new Object[0]);
      GMTrace.o(793226772480L, 5910);
    }
    return null;
  }
  
  public final void ar(byte[] paramArrayOfByte)
  {
    GMTrace.i(793360990208L, 5911);
    if (paramArrayOfByte == null)
    {
      v.e("MicroMsg.NetSceneGetAppSetting", "buf is null");
      GMTrace.o(793360990208L, 5911);
      return;
    }
    try
    {
      this.lbI.hrT.y(paramArrayOfByte);
      GMTrace.o(793360990208L, 5911);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      v.e("MicroMsg.NetSceneGetAppSetting", "bufToResp error: " + paramArrayOfByte.getMessage());
      v.printErrStackTrace("MicroMsg.NetSceneGetAppSetting", paramArrayOfByte, "", new Object[0]);
      GMTrace.o(793360990208L, 5911);
    }
  }
  
  public final int getType()
  {
    GMTrace.i(793495207936L, 5912);
    GMTrace.o(793495207936L, 5912);
    return 1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */