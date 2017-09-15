package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.axx;
import com.tencent.mm.protocal.c.axy;
import com.tencent.mm.protocal.c.bfe;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class e
  extends k
  implements j
{
  private String clientId;
  private b gUq;
  private com.tencent.mm.y.e gUt;
  private long hYm;
  private r hYn;
  private keep_SceneResult hYo;
  
  public e(long paramLong, r paramr, keep_SceneResult paramkeep_SceneResult, String paramString)
  {
    GMTrace.i(337960239104L, 2518);
    this.hYm = -1L;
    this.hYn = null;
    this.hYo = null;
    this.clientId = "";
    v.i("MicroMsg.NetSceneMassUploadSight", "massSendId %d, clientId %s", new Object[] { Long.valueOf(paramLong), paramString });
    this.hYm = paramLong;
    this.hYn = paramr;
    this.hYo = paramkeep_SceneResult;
    this.clientId = paramString;
    GMTrace.o(337960239104L, 2518);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    int i = 0;
    GMTrace.i(338094456832L, 2519);
    this.gUt = parame1;
    parame1 = new b.a();
    parame1.hrV = new axx();
    parame1.hrW = new axy();
    parame1.uri = "/cgi-bin/micromsg-bin/sendsight";
    parame1.hrU = 245;
    this.gUq = parame1.BE();
    parame1 = (axx)this.gUq.hrS.hsa;
    parame1.hhu = this.hYo.field_aesKey;
    parame1.pZk = this.clientId;
    parame1.fFN = this.hYn.fVs;
    parame1.tYE = this.hYn.hZV;
    o.KW();
    Object localObject = s.lx(this.hYn.getFileName());
    BitmapFactory.Options localOptions = d.Pd((String)localObject);
    if (localOptions != null)
    {
      parame1.hht = localOptions.outWidth;
      parame1.hhs = localOptions.outHeight;
    }
    for (;;)
    {
      parame1.hYE = this.hYn.hZR;
      localObject = bf.ap(this.hYn.iad, "").split(",");
      if ((localObject != null) && (localObject.length > 0)) {
        break;
      }
      v.e("MicroMsg.NetSceneMassUploadSight", "cdn upload video done, massSendId[%d], split username fail", new Object[] { Long.valueOf(this.hYm) });
      GMTrace.o(338094456832L, 2519);
      return -1;
      v.w("MicroMsg.NetSceneMassUploadSight", "sight send getImageOptions for thumb failed path:%s", new Object[] { localObject });
    }
    int j = localObject.length;
    while (i < j)
    {
      localOptions = localObject[i];
      bfe localbfe = new bfe();
      localbfe.username = localOptions;
      parame1.tYD.add(localbfe);
      i += 1;
    }
    parame1.url = this.hYo.field_fileId;
    parame1.hZV = this.hYn.hrb;
    i = a(parame, this.gUq, this);
    GMTrace.o(338094456832L, 2519);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(338228674560L, 2520);
    v.i("MicroMsg.NetSceneMassUploadSight", "cdntra onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " useCdnTransClientId:" + this.clientId + " massSendId " + this.hYm);
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(338228674560L, 2520);
  }
  
  public final int getType()
  {
    GMTrace.i(338362892288L, 2521);
    GMTrace.o(338362892288L, 2521);
    return 245;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelvideo/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */