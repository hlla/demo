package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.j.a;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.bdq;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.bia;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ba;
import com.tencent.mm.u.m;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.a;
import com.tencent.mm.y.k.b;
import java.util.HashMap;
import junit.framework.Assert;

public final class h
  extends k
  implements j
{
  String fyw;
  private com.tencent.mm.y.b gUq;
  private com.tencent.mm.y.e gUt;
  private int hYK;
  private keep_SceneResult hYL;
  private a hYM;
  
  public h(String paramString, int paramInt, keep_SceneResult paramkeep_SceneResult, a parama)
  {
    GMTrace.i(14625303166976L, 108967);
    this.fyw = null;
    this.hYK = 0;
    this.hYL = null;
    this.hYM = null;
    if (paramString != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      bool1 = bool2;
      if (paramkeep_SceneResult != null) {
        bool1 = true;
      }
      Assert.assertTrue(bool1);
      Assert.assertTrue(true);
      this.fyw = paramString;
      this.hYL = paramkeep_SceneResult;
      this.hYM = parama;
      this.hYK = paramInt;
      GMTrace.o(14625303166976L, 108967);
      return;
    }
  }
  
  private String KP()
  {
    GMTrace.i(18680691818496L, 139182);
    String str = this.fyw + "_" + hashCode();
    GMTrace.o(18680691818496L, 139182);
    return str;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(338631327744L, 2523);
    this.gUt = parame1;
    Object localObject = t.lI(this.fyw);
    if (localObject == null)
    {
      v.e("MicroMsg.NetSceneUploadVideoForCdn", "Get info Failed file:" + this.fyw);
      this.hYM.bb(3, -1);
      GMTrace.o(338631327744L, 2523);
      return -1;
    }
    parame1 = new b.a();
    parame1.hrV = new bhz();
    parame1.hrW = new bia();
    parame1.uri = "/cgi-bin/micromsg-bin/uploadvideo";
    parame1.hrU = 149;
    parame1.hrX = 39;
    parame1.hrY = 1000000039;
    this.gUq = parame1.BE();
    bhz localbhz = (bhz)this.gUq.hrS.hsa;
    localbhz.ufO = 0;
    localbhz.ufN = this.hYL.field_fileLength;
    localbhz.ufP = new avt().bb(new byte[0]);
    localbhz.tNh = 0;
    localbhz.tNg = this.hYL.field_thumbimgLength;
    localbhz.tNi = new avt().bb(new byte[0]);
    localbhz.muu = m.xL();
    localbhz.mut = this.hYL.field_toUser;
    localbhz.teo = this.fyw;
    if (((r)localObject).hZZ == 1) {
      localbhz.ufR = 2;
    }
    if (((r)localObject).iac == 3) {
      localbhz.ufR = 3;
    }
    localbhz.ufQ = ((r)localObject).hZV;
    label461:
    label518:
    label638:
    label715:
    label761:
    label820:
    String str;
    if (com.tencent.mm.network.aa.bn(com.tencent.mm.sdk.platformtools.aa.getContext()))
    {
      i = 1;
      localbhz.tss = i;
      localbhz.tNj = 2;
      localbhz.ufF = this.hYL.field_thumbimgLength;
      localbhz.ufS = this.hYL.field_fileId;
      localbhz.tIW = this.hYL.field_fileId;
      localbhz.tlB = 1;
      if (!this.hYL.isUploadBySafeCDNWithMD5()) {
        break label1110;
      }
      v.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", new Object[] { KP(), Boolean.valueOf(this.hYL.field_upload_by_safecdn), Integer.valueOf(this.hYL.field_UploadHitCacheType), Integer.valueOf(this.hYL.field_filecrc), this.hYL.field_aesKey });
      localbhz.tYv = 1;
      localbhz.tlA = "";
      localbhz.tIY = "";
      localbhz.ufU = this.hYL.field_filemd5;
      localbhz.uge = this.hYL.field_mp4identifymd5;
      localbhz.tlC = this.hYL.field_filecrc;
      if ((this.hYK > 0) && (this.hYK <= 1048576)) {
        break label1137;
      }
      parame1 = ba.zz();
      localbhz.tdC = parame1;
      localbhz.ugd = ((r)localObject).fUO;
      parame1 = ((r)localObject).iae;
      if ((parame1 == null) || (bf.mA(parame1.hjt))) {
        break label1204;
      }
      localbhz.ufV = bf.ap(parame1.hjt, "");
      localbhz.ufW = parame1.txr;
      localbhz.ufX = bf.ap(parame1.hjv, "");
      localbhz.ufZ = bf.ap(parame1.hjx, "");
      localbhz.ufY = bf.ap(parame1.hjw, "");
      localbhz.uga = bf.ap(parame1.hjy, "");
      if (parame1 != null)
      {
        localbhz.ugc = bf.ap(parame1.hjz, "");
        localbhz.ugb = bf.ap(parame1.hjA, "");
      }
      o.KW();
      parame1 = s.lx(this.fyw);
      localObject = d.Pd(parame1);
      if (localObject == null) {
        break label1249;
      }
      localbhz.ufH = ((BitmapFactory.Options)localObject).outWidth;
      localbhz.ufG = ((BitmapFactory.Options)localObject).outHeight;
      o.KW();
      parame1 = s.lw(this.fyw);
      localObject = n.KU();
      if (bf.mA(parame1)) {
        break label1268;
      }
      parame1 = (n.a)((n)localObject).hZh.get(parame1);
      if (parame1 == null) {
        break label1268;
      }
      i = parame1.hZy;
      switch (i)
      {
      case 4: 
      case 5: 
      default: 
        localbhz.tlD = 0;
        localbhz.teq = 0;
        parame1 = KP();
        localObject = this.fyw;
        str = this.hYL.field_toUser;
        if (this.hYL.field_aesKey != null) {
          break;
        }
      }
    }
    for (int i = -1;; i = this.hYL.field_aesKey.length())
    {
      v.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn cdntra doscene file:%s touser:%s aes:%d fileid:%s thumb:[%d %d %d], thumbaeskey [%s] funcFlag: %d, md5:%s HitMd5:%d CRC32:%d, VideoNewMd5:%s AESKey:%s stream %s streamtime: %d title %s thumburl %s msgSource[%s] msgForwardType[%d] Source[%d]", new Object[] { parame1, localObject, str, Integer.valueOf(i), this.hYL.field_fileId, Integer.valueOf(this.hYL.field_thumbimgLength), Integer.valueOf(localbhz.ufH), Integer.valueOf(localbhz.ufG), bf.Qi(localbhz.tIY), Integer.valueOf(localbhz.ufR), localbhz.ufU, Integer.valueOf(localbhz.tYv), Integer.valueOf(localbhz.tlC), localbhz.uge, bf.Qi(localbhz.tlA), localbhz.ufV, Integer.valueOf(localbhz.ufW), localbhz.ufX, localbhz.uga, localbhz.tdC, Integer.valueOf(localbhz.tlD), Integer.valueOf(localbhz.teq) });
      i = a(parame, this.gUq, this);
      GMTrace.o(338631327744L, 2523);
      return i;
      i = 2;
      break;
      label1110:
      localbhz.tlA = this.hYL.field_aesKey;
      localbhz.tIY = this.hYL.field_aesKey;
      break label461;
      label1137:
      parame1 = new StringBuilder();
      parame1.append("<msgsource>");
      parame1.append("<videopreloadlen>").append(this.hYK).append("</videopreloadlen>");
      parame1.append("</msgsource>");
      g.oSF.a(354L, 35L, 1L, false);
      parame1 = parame1.toString();
      break label518;
      label1204:
      if ((parame1 == null) || (bf.mA(parame1.hjx)) || (bf.mA(parame1.hjw))) {
        break label638;
      }
      localbhz.ufZ = parame1.hjx;
      localbhz.ufY = parame1.hjw;
      break label638;
      label1249:
      v.w("MicroMsg.NetSceneUploadVideoForCdn", "cdntra getImageOptions for thumb failed path:%s", new Object[] { parame1 });
      break label715;
      label1268:
      i = 0;
      break label761;
      localbhz.tlD = 1;
      localbhz.teq = 2;
      break label820;
      localbhz.tlD = 1;
      localbhz.teq = 1;
      break label820;
      localbhz.tlD = 2;
      localbhz.teq = 3;
      break label820;
      localbhz.tlD = 3;
      localbhz.teq = 4;
      break label820;
      localbhz.tlD = 1;
      localbhz.teq = 5;
      break label820;
    }
  }
  
  protected final int a(p paramp)
  {
    GMTrace.i(338765545472L, 2524);
    int i = k.b.hsC;
    GMTrace.o(338765545472L, 2524);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(339168198656L, 2527);
    v.i("MicroMsg.NetSceneUploadVideoForCdn", "%s cdntra onGYNetEnd errtype[%d %d]", new Object[] { KP(), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramArrayOfByte = (bia)((com.tencent.mm.y.b)paramp).hrT.hsa;
    paramp = t.lI(this.fyw);
    if (paramp == null)
    {
      v.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd Get INFO FAILED :" + this.fyw);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      this.hYM.bb(3, -1);
      GMTrace.o(339168198656L, 2527);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == 102))
    {
      v.e("MicroMsg.NetSceneUploadVideoForCdn", "summersafecdn ERR: MM_ERR_GET_AESKEY_FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fyw + " user:" + paramp.Lf());
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      this.hYM.bb(paramInt2, paramInt3);
      GMTrace.o(339168198656L, 2527);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      v.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd BLACK  errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fyw + " user:" + paramp.Lf());
      t.lC(this.fyw);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      this.hYM.bb(paramInt2, paramInt3);
      GMTrace.o(339168198656L, 2527);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      v.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fyw + " user:" + paramp.Lf());
      t.lB(this.fyw);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      this.hYM.bb(paramInt2, paramInt3);
      GMTrace.o(339168198656L, 2527);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      v.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fyw + " user:" + paramp.Lf());
      t.lB(this.fyw);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      this.hYM.bb(paramInt2, paramInt3);
      GMTrace.o(339168198656L, 2527);
      return;
    }
    paramp.hZT = bf.Nz();
    paramp.fTG = paramArrayOfByte.tdE;
    v.i("MicroMsg.NetSceneUploadVideoForCdn", "%s dkmsgid  set svrmsgid %d -> %d", new Object[] { KP(), Long.valueOf(paramp.fTG), Integer.valueOf(com.tencent.mm.platformtools.r.iiD) });
    if ((10007 == com.tencent.mm.platformtools.r.iiC) && (com.tencent.mm.platformtools.r.iiD != 0) && (paramp.fTG != 0L))
    {
      paramp.fTG = com.tencent.mm.platformtools.r.iiD;
      com.tencent.mm.platformtools.r.iiD = 0;
    }
    paramp.status = 199;
    paramp.fRM = 1284;
    boolean bool;
    if (this.hYL.isUploadBySafeCDNWithMD5())
    {
      v.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], old RecvXml[%s]", new Object[] { KP(), paramArrayOfByte.tlA, paramp.Li() });
      if (bf.mA(paramArrayOfByte.tlA)) {
        break label1320;
      }
      Object localObject = "<msg><videomsg aeskey=\"" + paramArrayOfByte.tlA + "\" cdnthumbaeskey=\"" + paramArrayOfByte.tlA + "\" cdnvideourl=\"" + this.hYL.field_fileId + "\" ";
      localObject = (String)localObject + "cdnthumburl=\"" + this.hYL.field_fileId + "\" ";
      localObject = (String)localObject + "length=\"" + this.hYL.field_fileLength + "\" ";
      localObject = (String)localObject + "cdnthumblength=\"" + this.hYL.field_thumbimgLength + "\"/></msg>";
      v.i("MicroMsg.NetSceneUploadVideoForCdn", "cdn callback new build cdnInfo:%s", new Object[] { localObject });
      paramp.iab = ((String)localObject);
      localObject = o.KW();
      o.KW();
      bool = ((s)localObject).o(s.lw(this.fyw), this.hYL.field_fileId, paramArrayOfByte.tlA);
      localObject = g.oSF;
      if (bool)
      {
        paramInt1 = 1;
        ((g)localObject).i(12696, new Object[] { Integer.valueOf(paramInt1 + 900), Integer.valueOf(paramp.hrb) });
        v.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], new RecvXml[%s], saveret[%b]", new Object[] { KP(), paramArrayOfByte.tlA, paramp.Li(), Boolean.valueOf(bool) });
      }
    }
    else
    {
      label1062:
      t.e(paramp);
      t.c(paramp);
      paramArrayOfByte = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cA(paramp.hZW);
      com.tencent.mm.modelstat.b.hTV.f(paramArrayOfByte);
      paramArrayOfByte = paramp.Lf();
      paramArrayOfByte = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramArrayOfByte);
      if ((paramArrayOfByte != null) && ((int)paramArrayOfByte.gTG > 0)) {
        break label1342;
      }
      bool = false;
      label1155:
      if ((!bool) && (!com.tencent.mm.u.o.fh(paramp.Lf()))) {
        break label1352;
      }
      v.i("MicroMsg.NetSceneUploadVideoForCdn", "%s upload to biz :%s", new Object[] { KP(), paramp.Lf() });
      if (paramp.fTG < 0L)
      {
        v.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + paramp.fTG + " file:" + this.fyw + " toUser:" + paramp.Lf());
        t.lB(this.fyw);
        this.hYM.bb(3, -1);
      }
    }
    for (;;)
    {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      this.hYM.bb(0, 0);
      GMTrace.o(339168198656L, 2527);
      return;
      paramInt1 = 2;
      break;
      label1320:
      v.w("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn need aeskey but ret null", new Object[] { KP() });
      break label1062;
      label1342:
      bool = paramArrayOfByte.bKU();
      break label1155;
      label1352:
      v.i("MicroMsg.NetSceneUploadVideoForCdn", "%s not upload to biz", new Object[] { KP() });
      if (paramp.fTG <= 0L)
      {
        v.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + paramp.fTG + " file:" + this.fyw + " toUser:" + paramp.Lf());
        t.lB(this.fyw);
        this.hYM.bb(3, -1);
      }
    }
  }
  
  protected final void a(k.a parama)
  {
    GMTrace.i(339033980928L, 2526);
    t.lB(this.fyw);
    GMTrace.o(339033980928L, 2526);
  }
  
  public final int getType()
  {
    GMTrace.i(339302416384L, 2528);
    GMTrace.o(339302416384L, 2528);
    return 149;
  }
  
  protected final int ub()
  {
    GMTrace.i(338899763200L, 2525);
    GMTrace.o(338899763200L, 2525);
    return 1;
  }
  
  static abstract interface a
  {
    public abstract void bb(int paramInt1, int paramInt2);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelvideo/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */