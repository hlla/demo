package com.tencent.mm.pluginsdk.model.app;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.w.a.a;
import com.tencent.mm.plugin.w.a.a.a;
import com.tencent.mm.protocal.c.ayn;
import com.tencent.mm.protocal.c.ayo;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;

public final class aj
  extends w
{
  public int cmdId;
  private String sCv;
  
  public aj(String paramString1, int paramInt, String paramString2)
  {
    GMTrace.i(811748818944L, 6048);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new ayn();
    ((b.a)localObject).hrW = new ayo();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/setappsetting";
    ((b.a)localObject).hrU = 396;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.lbI = ((b.a)localObject).BE();
    localObject = (ayn)this.lbI.hrS.hsa;
    ((ayn)localObject).mqG = paramString1;
    ((ayn)localObject).tYN = paramInt;
    ((ayn)localObject).tYO = paramString2;
    this.cmdId = paramInt;
    this.sCv = paramString2;
    GMTrace.o(811748818944L, 6048);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(811883036672L, 6049);
    v.i("MicroMsg.NetSceneSetAppSetting", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt2 == 0))
    {
      paramString = (ayo)this.lbI.hrT.hsa;
      if (paramString != null)
      {
        paramp = a.a.aRo().aRm();
        paramArrayOfByte = g.aJ(paramString.mqG, false);
        if (paramArrayOfByte != null)
        {
          paramArrayOfByte.field_authFlag = paramString.teN;
          boolean bool = paramp.a(paramArrayOfByte, new String[0]);
          v.d("MicroMsg.NetSceneSetAppSetting", "onGYNetEnd, update ret = " + bool + ", appId = " + paramString.mqG);
        }
      }
    }
    GMTrace.o(811883036672L, 6049);
  }
  
  public final byte[] aBo()
  {
    GMTrace.i(812017254400L, 6050);
    try
    {
      byte[] arrayOfByte = ((b.b)this.lbI.BG()).zh();
      GMTrace.o(812017254400L, 6050);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.NetSceneSetAppSetting", "toProtBuf failed: " + localException.getMessage());
      GMTrace.o(812017254400L, 6050);
    }
    return null;
  }
  
  public final void ar(byte[] paramArrayOfByte)
  {
    GMTrace.i(812151472128L, 6051);
    if (paramArrayOfByte == null)
    {
      v.e("MicroMsg.NetSceneSetAppSetting", "buf is null");
      GMTrace.o(812151472128L, 6051);
      return;
    }
    try
    {
      this.lbI.hrT.y(paramArrayOfByte);
      GMTrace.o(812151472128L, 6051);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      v.e("MicroMsg.NetSceneSetAppSetting", "parse error: " + paramArrayOfByte.getMessage());
      v.printErrStackTrace("MicroMsg.NetSceneSetAppSetting", paramArrayOfByte, "", new Object[0]);
      GMTrace.o(812151472128L, 6051);
    }
  }
  
  public final int getType()
  {
    GMTrace.i(812285689856L, 6052);
    GMTrace.o(812285689856L, 6052);
    return 2;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */