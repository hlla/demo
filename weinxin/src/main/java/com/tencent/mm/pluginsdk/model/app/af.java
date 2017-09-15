package com.tencent.mm.pluginsdk.model.app;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ajv;
import com.tencent.mm.protocal.c.ajw;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;

public final class af
  extends k
  implements j
{
  public b gUq;
  private com.tencent.mm.y.e gUt;
  
  public af(int paramInt, String paramString)
  {
    GMTrace.i(821680930816L, 6122);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new ajv();
    ((b.a)localObject).hrW = new ajw();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/getserviceapplist";
    ((b.a)localObject).hrU = 1060;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    localObject = (ajv)this.gUq.hrS.hsa;
    ((ajv)localObject).offset = paramInt;
    ((ajv)localObject).aIo = 20;
    ((ajv)localObject).lang = paramString;
    GMTrace.o(821680930816L, 6122);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(822083584000L, 6125);
    this.gUt = parame1;
    v.i("MicroMsg.NetSceneGetServiceAppList", "do scene");
    int i = a(parame, this.gUq, this);
    GMTrace.o(822083584000L, 6125);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(821815148544L, 6123);
    v.d("MicroMsg.NetSceneGetServiceAppList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.gUt != null) {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
    }
    GMTrace.o(821815148544L, 6123);
  }
  
  public final int getType()
  {
    GMTrace.i(821949366272L, 6124);
    GMTrace.o(821949366272L, 6124);
    return 1060;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */