package com.tencent.mm.ah;

import android.graphics.BitmapFactory.Options;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.bhr;
import com.tencent.mm.protocal.c.bhs;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;

public final class l
  extends k
  implements j
{
  private int gUZ;
  private final b gUq;
  private com.tencent.mm.y.e gUt;
  private d hGL;
  private a hGM;
  
  public l(int paramInt, bhr parambhr, d paramd, keep_SceneResult paramkeep_SceneResult, a parama)
  {
    GMTrace.i(3506572361728L, 26126);
    b.a locala = new b.a();
    locala.hrV = new bhr();
    locala.hrW = new bhs();
    locala.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
    locala.hrU = 110;
    locala.hrX = 9;
    locala.hrY = 1000000009;
    this.gUq = locala.BE();
    this.hGM = parama;
    this.gUZ = paramInt;
    this.hGL = paramd;
    parama = (bhr)this.gUq.hrS.hsa;
    parama.tdx = parambhr.tdx;
    parama.tdy = parambhr.tdy;
    parama.ufz = parambhr.ufz;
    parama.mrC = parambhr.mrC;
    parama.tdC = parambhr.tdC;
    parama.tlD = parambhr.tlD;
    paramd = com.tencent.mm.sdk.platformtools.d.Pd(n.GT().m(paramd.hEJ, "", ""));
    if (paramd != null)
    {
      paramInt = paramd.outWidth;
      parama.ufH = paramInt;
      if (paramd == null) {
        break label517;
      }
      paramInt = paramd.outHeight;
      label213:
      parama.ufG = paramInt;
      parama.ufE = paramkeep_SceneResult.field_fileId;
      parama.ufF = paramkeep_SceneResult.field_thumbimgLength;
      parama.tfd = paramkeep_SceneResult.field_thumbimgLength;
      parama.tfe = 0;
      parama.tff = paramkeep_SceneResult.field_thumbimgLength;
      parama.tqC = new avt().bb(new byte[0]);
      parama.tlB = 1;
      if (!paramkeep_SceneResult.isUploadBySafeCDNWithMD5()) {
        break label522;
      }
      v.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", new Object[] { Boolean.valueOf(paramkeep_SceneResult.field_upload_by_safecdn), Integer.valueOf(paramkeep_SceneResult.field_UploadHitCacheType), Integer.valueOf(paramkeep_SceneResult.field_filecrc), paramkeep_SceneResult.field_aesKey });
      parama.tYv = 1;
      parama.tlA = "";
      parama.tIY = "";
      label369:
      parama.tEg = parambhr.tEg;
      if (parambhr.tEg != 1) {
        break label545;
      }
      parama.ufC = paramkeep_SceneResult.field_fileLength;
      parama.ufD = paramkeep_SceneResult.field_midimgLength;
      parama.ufA = paramkeep_SceneResult.field_fileId;
    }
    for (parama.ufB = paramkeep_SceneResult.field_fileId;; parama.ufB = paramkeep_SceneResult.field_fileId)
    {
      parama.tlC = paramkeep_SceneResult.field_filecrc;
      parama.tsH = paramkeep_SceneResult.field_filemd5;
      v.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn NetSceneUploadMsgImgForCdn MsgForwardType[%d], hitmd5[%d], key[%s], crc[%d]", new Object[] { Integer.valueOf(parama.tlD), Integer.valueOf(parama.tYv), bf.Qi(parama.tlA), Integer.valueOf(parama.tlC) });
      GMTrace.o(3506572361728L, 26126);
      return;
      paramInt = 0;
      break;
      label517:
      paramInt = 0;
      break label213;
      label522:
      parama.tlA = paramkeep_SceneResult.field_aesKey;
      parama.tIY = paramkeep_SceneResult.field_aesKey;
      break label369;
      label545:
      parama.ufC = 0;
      parama.ufD = paramkeep_SceneResult.field_fileLength;
      parama.ufA = "";
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(3506706579456L, 26127);
    v.i("MicroMsg.NetSceneUploadMsgImgForCdn", "cdntra req[%s]", new Object[] { ((bhr)(bhr)this.gUq.hrS.hsa).toString() });
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(3506706579456L, 26127);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(3506840797184L, 26128);
    v.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3);
    paramString = (bhs)((b)paramp).hrT.hsa;
    v.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd createtime:%d msgId:%d ", new Object[] { Integer.valueOf(paramString.ofk), Long.valueOf(paramString.tdE) });
    if (this.hGM != null) {
      this.hGM.a(paramString.tdE, paramString.ofk, paramInt2, paramInt3);
    }
    this.gUt.a(0, 0, "", this);
    GMTrace.o(3506840797184L, 26128);
  }
  
  public final int getType()
  {
    GMTrace.i(3506975014912L, 26129);
    GMTrace.o(3506975014912L, 26129);
    return 110;
  }
  
  static abstract interface a
  {
    public abstract void a(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ah/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */