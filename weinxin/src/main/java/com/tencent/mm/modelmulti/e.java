package com.tencent.mm.modelmulti;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.afl;
import com.tencent.mm.protocal.c.afn;
import com.tencent.mm.protocal.c.ux;
import com.tencent.mm.protocal.c.uy;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends k
  implements j
{
  private com.tencent.mm.y.e gUt;
  public final b hJX;
  
  public e(List<afl> paramList, long paramLong, afn paramafn)
  {
    GMTrace.i(406411280384L, 3028);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new ux();
    ((b.a)localObject).hrW = new uy();
    ((b.a)localObject).uri = "/cgi-bin/mmo2o-bin/getbeaconspushmessage";
    ((b.a)localObject).hrU = 1708;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.hJX = ((b.a)localObject).BE();
    localObject = (ux)this.hJX.hrS.hsa;
    ((ux)localObject).tAP.addAll(paramList);
    ((ux)localObject).tAS = paramLong;
    ((ux)localObject).tAR = paramafn;
    v.i("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma]getBeaconsPushMessageReq.beacons.size:%d", new Object[] { Integer.valueOf(((ux)localObject).tAP.size()) });
    GMTrace.o(406411280384L, 3028);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(406813933568L, 3031);
    this.gUt = parame1;
    int i = a(parame, this.hJX, this);
    GMTrace.o(406813933568L, 3031);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(406545498112L, 3029);
    v.i("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    Object localObject = (ux)this.hJX.hrS.hsa;
    paramString = ((ux)localObject).tAP;
    paramArrayOfByte = (afl)paramString.get(0);
    localObject = ((ux)localObject).tAR;
    paramp = (uy)((b)paramp).hrT.hsa;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (paramp.result != 0) {
        g.oSF.i(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramString.size()), paramArrayOfByte.mpX, Integer.valueOf(paramArrayOfByte.major), Integer.valueOf(paramArrayOfByte.minor), String.valueOf(((afn)localObject).latitude), String.valueOf(((afn)localObject).longitude), Integer.valueOf(2), Integer.valueOf(paramp.result) });
      }
      v.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end ok");
      GMTrace.o(406545498112L, 3029);
      return;
    }
    g.oSF.i(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramString.size()), paramArrayOfByte.mpX, Integer.valueOf(paramArrayOfByte.major), Integer.valueOf(paramArrayOfByte.minor), String.valueOf(((afn)localObject).latitude), String.valueOf(((afn)localObject).longitude), Integer.valueOf(1), Integer.valueOf(paramp.result) });
    v.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end not ok");
    GMTrace.o(406545498112L, 3029);
  }
  
  public final int getType()
  {
    GMTrace.i(406679715840L, 3030);
    GMTrace.o(406679715840L, 3030);
    return 1708;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelmulti/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */