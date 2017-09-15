package com.tencent.mm.plugin.subapp.b;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.zr;
import com.tencent.mm.protocal.c.zs;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.b;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class a
  extends k
  implements j
{
  private String filePath;
  private com.tencent.mm.y.e gUt;
  private int hrb;
  private RandomAccessFile iaI;
  private int jTt;
  String url;
  
  public a(String paramString)
  {
    GMTrace.i(5847195320320L, 43565);
    this.url = paramString;
    this.jTt = 0;
    this.hrb = 0;
    this.filePath = null;
    this.iaI = null;
    GMTrace.o(5847195320320L, 43565);
  }
  
  private boolean c(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    GMTrace.i(5847866408960L, 43570);
    if (paramInt == 0)
    {
      if ((this.iaI != null) || (this.filePath != null))
      {
        v.e("MicroMsg.NetSceneGetPSMImg", "writeFile param error");
        GMTrace.o(5847866408960L, 43570);
        return false;
      }
      this.filePath = com.tencent.mm.pluginsdk.l.a.a.My(paramString);
      if (this.filePath == null)
      {
        v.e("MicroMsg.NetSceneGetPSMImg", "writeFile getPath From url failed:[" + paramString + "]");
        GMTrace.o(5847866408960L, 43570);
        return false;
      }
    }
    try
    {
      this.iaI = new RandomAccessFile(this.filePath, "rw");
      return false;
    }
    catch (Exception paramString)
    {
      try
      {
        this.iaI.seek(paramInt);
        this.iaI.write(paramArrayOfByte, 0, paramArrayOfByte.length);
        GMTrace.o(5847866408960L, 43570);
        return true;
      }
      catch (IOException paramString)
      {
        v.e("MicroMsg.NetSceneGetPSMImg", "writeFile write file error [" + this.filePath + "]  e:" + paramString.getMessage());
        GMTrace.o(5847866408960L, 43570);
      }
      paramString = paramString;
      v.e("MicroMsg.NetSceneGetPSMImg", "writeFile open file error [" + this.filePath + "] e:" + paramString.getMessage());
      GMTrace.o(5847866408960L, 43570);
      return false;
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(5847329538048L, 43566);
    this.gUt = parame1;
    parame1 = new b.a();
    parame1.hrV = new zr();
    parame1.hrW = new zs();
    parame1.uri = "/cgi-bin/micromsg-bin/getpsmimg";
    parame1.hrU = 141;
    parame1.hrX = 29;
    parame1.hrY = 1000000029;
    parame1 = parame1.BE();
    zr localzr = (zr)parame1.hrS.hsa;
    localzr.URL = this.url;
    localzr.tjF = this.jTt;
    v.v("MicroMsg.NetSceneGetPSMImg", "doscene url:[" + this.url + "] + offset:" + this.jTt + " totallen:" + this.hrb);
    int i = a(parame, parame1, this);
    GMTrace.o(5847329538048L, 43566);
    return i;
  }
  
  protected final int a(p paramp)
  {
    GMTrace.i(5847463755776L, 43567);
    paramp = ((zr)((com.tencent.mm.y.b)paramp).hrS.hsa).URL;
    if (paramp == null) {
      i = 0;
    }
    while (i == 0)
    {
      v.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : url invalid:" + this.url);
      i = k.b.hsD;
      GMTrace.o(5847463755776L, 43567);
      return i;
      if (paramp.indexOf("weixin://") != 0) {
        i = 0;
      } else {
        i = 1;
      }
    }
    if ((this.jTt < 0) || (this.hrb < 0))
    {
      v.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.jTt + " total:" + this.hrb);
      i = k.b.hsD;
      GMTrace.o(5847463755776L, 43567);
      return i;
    }
    if (this.jTt == 0)
    {
      if (this.hrb != 0)
      {
        v.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.jTt + " total:" + this.hrb);
        i = k.b.hsD;
        GMTrace.o(5847463755776L, 43567);
        return i;
      }
    }
    else if (this.jTt >= this.hrb)
    {
      v.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.jTt + " total:" + this.hrb);
      i = k.b.hsD;
      GMTrace.o(5847463755776L, 43567);
      return i;
    }
    int i = k.b.hsC;
    GMTrace.o(5847463755776L, 43567);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(5847732191232L, 43569);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      v.e("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(5847732191232L, 43569);
      return;
    }
    paramp = (zs)((com.tencent.mm.y.b)paramp).hrT.hsa;
    v.d("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd url:[" + this.url + "] + offset:" + this.jTt + " Resp[ totallen:" + paramp.tjE + " bufSize:" + paramp.tqC.tXB + " ]");
    if (paramp.tjE > 0) {
      this.hrb = paramp.tjE;
    }
    if (!c(this.url, paramp.tqC.tXD.sWU, this.jTt))
    {
      this.gUt.a(3, -1, paramString, this);
      GMTrace.o(5847732191232L, 43569);
      return;
    }
    paramInt1 = this.jTt;
    this.jTt = (paramp.tqC.tXB + paramInt1);
    if (this.hrb <= this.jTt)
    {
      v.d("MicroMsg.NetSceneGetPSMImg", "down url:[" + this.url + "] final size: " + this.hrb);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(5847732191232L, 43569);
      return;
    }
    if (a(this.hsm, this.gUt) < 0) {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
    }
    GMTrace.o(5847732191232L, 43569);
  }
  
  public final int getType()
  {
    GMTrace.i(5848000626688L, 43571);
    GMTrace.o(5848000626688L, 43571);
    return 141;
  }
  
  protected final int ub()
  {
    GMTrace.i(5847597973504L, 43568);
    GMTrace.o(5847597973504L, 43568);
    return 10;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/subapp/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */