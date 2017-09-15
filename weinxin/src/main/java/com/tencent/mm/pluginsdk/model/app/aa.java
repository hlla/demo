package com.tencent.mm.pluginsdk.model.app;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.kq;
import com.tencent.mm.protocal.c.kr;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;

public final class aa
  extends k
  implements j
{
  private b gUq;
  private com.tencent.mm.y.e gUt;
  private a sCb;
  
  public aa(String paramString1, String paramString2, String paramString3, int paramInt, a parama)
  {
    GMTrace.i(828123381760L, 6170);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new kq();
    ((b.a)localObject).hrW = new kr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkmd5";
    ((b.a)localObject).hrU = 939;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    localObject = (kq)this.gUq.hrS.hsa;
    ((kq)localObject).fileid = paramString1;
    ((kq)localObject).fFN = paramString2;
    ((kq)localObject).tpq = paramString3;
    ((kq)localObject).tpr = paramInt;
    this.sCb = parama;
    v.i("MicroMsg.NetSceneCheckMd5", "summersafecdn NetSceneCheckMd5 fileid[%s], md5[%s], newmd5[%s], crc[%d], stack[%s]", new Object[] { ((kq)localObject).fileid, ((kq)localObject).fFN, ((kq)localObject).tpq, Integer.valueOf(((kq)localObject).tpr), bf.bJP() });
    GMTrace.o(828123381760L, 6170);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(828391817216L, 6172);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(828391817216L, 6172);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(828526034944L, 6173);
    v.i("MicroMsg.NetSceneCheckMd5", "summersafecdn onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    if (this.sCb != null)
    {
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label99;
      }
      paramString = this.sCb;
    }
    for (;;)
    {
      for (paramp = "";; paramp = paramp.aeskey)
      {
        paramString.H(paramp, paramInt2, paramInt3);
        GMTrace.o(828526034944L, 6173);
        return;
        label99:
        paramp = (kr)((b)paramp).hrT.hsa;
        paramString = this.sCb;
        if (paramp == null) {
          break;
        }
      }
    }
  }
  
  public final int getType()
  {
    GMTrace.i(828257599488L, 6171);
    GMTrace.o(828257599488L, 6171);
    return 939;
  }
  
  public static abstract interface a
  {
    public abstract void H(String paramString, int paramInt1, int paramInt2);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */