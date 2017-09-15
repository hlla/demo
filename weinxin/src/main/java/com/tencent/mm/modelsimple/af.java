package com.tencent.mm.modelsimple;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.azb;
import com.tencent.mm.protocal.c.azc;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;

public final class af
  extends k
  implements j
{
  public final b gUq;
  private com.tencent.mm.y.e gUt;
  
  public af(String paramString1, String paramString2, avt paramavt)
  {
    GMTrace.i(13159914012672L, 98049);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new azb();
    ((b.a)localObject).hrW = new azc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/newsetpasswd";
    ((b.a)localObject).hrU = 383;
    ((b.a)localObject).hrX = 180;
    ((b.a)localObject).hrY = 1000000180;
    this.gUq = ((b.a)localObject).BE();
    localObject = (azb)this.gUq.hrS.hsa;
    ((azb)localObject).lcR = bf.PQ(paramString1);
    ((azb)localObject).tsG = paramString2;
    ((azb)localObject).tfz = paramavt;
    v.d("MicroMsg.NetSceneSetPwd", "summersetpwd md5:%s ticket:%s, authkey:%s", new Object[] { paramString1, paramString2, bf.bl(n.a(paramavt)) });
    GMTrace.o(13159914012672L, 98049);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(13160048230400L, 98050);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(13160048230400L, 98050);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(13160316665856L, 98052);
    v.d("MicroMsg.NetSceneSetPwd", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(13160316665856L, 98052);
  }
  
  public final int getType()
  {
    GMTrace.i(13160182448128L, 98051);
    GMTrace.o(13160182448128L, 98051);
    return 383;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsimple/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */