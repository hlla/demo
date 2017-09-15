package com.tencent.mm.pluginsdk.k.a.b;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.g;
import com.tencent.mm.a.q;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.pluginsdk.k.a.e.a;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;

final class l
{
  private final int fEs;
  private final int fEt;
  private final int fEu;
  private final boolean fEv;
  private final boolean fEy;
  final String filePath;
  private final String sDA;
  private final int sDB;
  private final int sDC;
  final String sDr;
  private final String sDu;
  private final int sDv;
  private final byte[] sDw;
  private final String sDx;
  private final long sDz;
  volatile String sEA;
  volatile String sEB;
  final boolean sEa;
  final boolean sEb;
  volatile int state;
  private final String url;
  
  l(int paramInt1, int paramInt2, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, int paramInt3, boolean paramBoolean3, boolean paramBoolean4, byte[] paramArrayOfByte, String paramString3, String paramString4, long paramLong, String paramString5, int paramInt4, int paramInt5, int paramInt6)
  {
    GMTrace.i(855503798272L, 6374);
    this.state = -1;
    this.sEA = null;
    this.sEB = null;
    this.sDr = i.dG(paramInt1, paramInt2);
    this.fEs = paramInt1;
    this.fEt = paramInt2;
    this.filePath = paramString1;
    this.sEb = paramBoolean1;
    this.sEa = paramBoolean2;
    this.sDu = paramString2;
    this.sDv = paramInt3;
    this.sDw = paramArrayOfByte;
    this.sDx = paramString3;
    this.fEy = paramBoolean3;
    this.fEv = paramBoolean4;
    this.sDA = paramString4;
    this.sDz = paramLong;
    this.url = paramString5;
    this.sDB = paramInt4;
    this.sDC = paramInt5;
    this.fEu = paramInt6;
    GMTrace.o(855503798272L, 6374);
  }
  
  final l bDo()
  {
    GMTrace.i(855638016000L, 6375);
    v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), file_state = %s, before do decrypt, inPath = %s, outPath = %s, (key == empty) = %b", new Object[] { this.sDr, bDr(), this.sEA, this.sEB, Boolean.valueOf(bf.mA(this.sDu)) });
    if (1 != this.state)
    {
      GMTrace.o(855638016000L, 6375);
      return this;
    }
    if (bf.mA(this.sDu))
    {
      v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), invalid encrypt key", new Object[] { this.sDr });
      this.sEA = null;
      this.state = 8;
      j.u(this.sDz, 54L);
      j.u(this.sDz, 45L);
      GMTrace.o(855638016000L, 6375);
      return this;
    }
    for (;;)
    {
      try
      {
        localObject2 = this.sEA;
        str = this.sEB;
        localObject1 = this.sDu;
        localFile = new File((String)localObject2);
        if ((!localFile.exists()) || (!localFile.isFile()))
        {
          v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "inFile(%s) not exists", new Object[] { localObject2 });
          bool1 = false;
        }
      }
      catch (Exception localException1)
      {
        Object localObject2;
        String str;
        Object localObject1;
        File localFile;
        boolean bool2;
        boolean bool1 = false;
      }
      try
      {
        v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), decrypt done, ret = %b", new Object[] { this.sDr, Boolean.valueOf(bool1) });
        v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), after try-catch, ret = %b", new Object[] { this.sDr, Boolean.valueOf(bool1) });
        if (bool1) {
          break;
        }
        this.sEA = null;
        this.state = 8;
        GMTrace.o(855638016000L, 6375);
        return this;
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
      localFile = new File(str);
      localFile.getParentFile().mkdirs();
      localFile.delete();
      localObject2 = a.Mw((String)localObject2);
      if (bf.bm((byte[])localObject2))
      {
        v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "read bytes empty");
        j.u(this.sDz, 56L);
        j.u(this.sDz, 45L);
        j.u(this.sDz, 18L);
        bool1 = false;
      }
      else
      {
        localObject1 = MMProtocalJni.aesDecrypt((byte[])localObject2, ((String)localObject1).getBytes());
        if (bf.bm((byte[])localObject1))
        {
          v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypted bytes empty");
          j.u(this.sDz, 55L);
          j.u(this.sDz, 45L);
          j.u(this.sDz, 18L);
          bool1 = false;
        }
        else
        {
          bool2 = a.u(str, (byte[])localObject1);
          bool1 = bool2;
          if (!bool2)
          {
            v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypt write bytes fail");
            j.u(this.sDz, 57L);
            j.u(this.sDz, 45L);
            j.u(this.sDz, 18L);
            bool1 = bool2;
            continue;
            v.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", localException1, "", new Object[0]);
            v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), error = %s", new Object[] { this.sDr, localException1 });
            j.u(this.sDz, 45L);
            j.u(this.sDz, 18L);
          }
        }
      }
    }
    j.u(this.sDz, 17L);
    this.sEA = this.sEB;
    if (this.sEa)
    {
      this.sEB = (this.filePath + ".decompressed");
      this.state = 2;
      GMTrace.o(855638016000L, 6375);
      return this;
    }
    this.state = 4;
    GMTrace.o(855638016000L, 6375);
    return this;
  }
  
  final l bDp()
  {
    GMTrace.i(855772233728L, 6376);
    v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), file_state = %s, before do decompress, inPath = %s, outPath = %s", new Object[] { this.sDr, bDr(), this.sEA, this.sEB });
    if (2 != this.state)
    {
      if ((8 == this.state) && (this.sEb)) {
        j.a(this.fEs, this.fEt, this.sDv, this.fEy, false, false, false, this.sDA);
      }
      GMTrace.o(855772233728L, 6376);
      return this;
    }
    for (;;)
    {
      try
      {
        localObject = this.sEA;
        str1 = this.sEB;
        File localFile = new File((String)localObject);
        if ((!localFile.exists()) || (!localFile.isFile()))
        {
          v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "inFile(%s) not exists", new Object[] { localObject });
          bool = false;
        }
      }
      catch (Exception localException1)
      {
        Object localObject;
        String str1;
        boolean bool = false;
      }
      try
      {
        v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), decompress done, ret = %b", new Object[] { this.sDr, Boolean.valueOf(bool) });
        v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), after try-catch, ret = %b", new Object[] { this.sDr, Boolean.valueOf(bool) });
        if (!bool) {
          break;
        }
        this.sEA = this.sEB;
        this.state = 4;
        j.u(this.sDz, 19L);
        GMTrace.o(855772233728L, 6376);
        return this;
      }
      catch (Exception localException2)
      {
        int j;
        int k;
        String str2;
        int m;
        int i;
        for (;;) {}
      }
      new File(str1).delete();
      localObject = q.q(a.Mw((String)localObject));
      if (bf.bm((byte[])localObject))
      {
        v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "uncompressed bytes empty");
        bool = false;
      }
      else
      {
        bool = a.u(str1, (byte[])localObject);
        continue;
        v.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", localException1, "", new Object[0]);
        v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), error = %s", new Object[] { this.sDr, localException1 });
      }
    }
    this.sEA = null;
    this.state = 8;
    j.u(this.sDz, 20L);
    j.u(this.sDz, 46L);
    if (this.sEb) {
      j.a(this.fEs, this.fEt, this.sDv, this.fEy, true, false, false, this.sDA);
    }
    while ((!this.sEa) || (!this.fEv))
    {
      GMTrace.o(855772233728L, 6376);
      return this;
    }
    j = this.fEs;
    k = this.fEt;
    str2 = this.url;
    m = this.fEu;
    if (this.sDB > this.sDC) {}
    for (i = j.a.sEu;; i = j.a.sEs)
    {
      j.a(j, k, str2, m, i, false, this.fEy, false, this.sDA);
      break;
    }
  }
  
  final String bDq()
  {
    GMTrace.i(855906451456L, 6377);
    v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSum(), state " + bDr(), new Object[] { this.sDr });
    String str1;
    if (16 == this.state)
    {
      str1 = this.sEA;
      GMTrace.o(855906451456L, 6377);
      return str1;
    }
    if ((4 != this.state) && (32 != this.state))
    {
      GMTrace.o(855906451456L, 6377);
      return null;
    }
    if (!bf.mA(this.sEA))
    {
      str2 = this.sDr;
      String str3 = bDr();
      String str4 = this.sDx;
      if (this.sDw == null)
      {
        str1 = "null";
        v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, originalMd5 = %s, eccSig.size = %s", new Object[] { str2, str3, str4, str1 });
        if ((bf.mA(this.sDx)) || (!bf.mz(g.aV(this.sEA)).equals(this.sDx))) {
          break label385;
        }
        v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, md5 ok", new Object[] { this.sDr, bDr() });
        if (this.state == 4) {
          j.u(this.sDz, 23L);
        }
        str1 = this.sEA;
        label252:
        v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl return = %s", new Object[] { this.sDr, str1 });
        if (this.state == 4)
        {
          if ((bf.mA(str1)) && (!this.sEa))
          {
            j.u(this.sDz, 58L);
            j.u(this.sDz, 45L);
          }
          if (!bf.mA(str1)) {
            break label591;
          }
          if (!this.sEb) {
            break label510;
          }
          j.a(this.fEs, this.fEt, this.sDv, this.fEy, true, true, false, this.sDA);
        }
      }
    }
    label385:
    label510:
    label591:
    label627:
    do
    {
      for (;;)
      {
        GMTrace.o(855906451456L, 6377);
        return str1;
        str1 = String.valueOf(this.sDw.length);
        break;
        if (this.state == 4) {
          j.u(this.sDz, 24L);
        }
        if ((!bf.bm(this.sDw)) && (UtilsJni.doEcdsaSHAVerify(i.sEd, a.Mw(this.sEA), this.sDw) > 0))
        {
          v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, ecc check ok", new Object[] { this.sDr, bDr() });
          if (this.state == 4) {
            j.u(this.sDz, 25L);
          }
          str1 = this.sEA;
          break label252;
        }
        if (this.state == 4) {
          j.u(this.sDz, 26L);
        }
        str1 = null;
        break label252;
        if ((this.sEa) && (this.fEv))
        {
          j = this.fEs;
          k = this.fEt;
          str2 = this.url;
          m = this.fEu;
          if (this.sDB > this.sDC) {}
          for (i = j.a.sEu;; i = j.a.sEs)
          {
            j.a(j, k, str2, m, i, false, this.fEy, true, this.sDA);
            break;
          }
          if (!this.sEb) {
            break label627;
          }
          j.a(this.fEs, this.fEt, this.sDv, this.fEy, true, true, true, this.sDA);
        }
      }
    } while ((!this.sEa) || (!this.fEv));
    int j = this.fEs;
    int k = this.fEt;
    String str2 = this.url;
    int m = this.fEu;
    if (this.sDB > this.sDC) {}
    for (int i = j.a.sEu;; i = j.a.sEs)
    {
      j.a(j, k, str2, m, i, true, this.fEy, true, this.sDA);
      break;
    }
  }
  
  final String bDr()
  {
    GMTrace.i(856040669184L, 6378);
    switch (this.state)
    {
    default: 
      String str = this.state;
      GMTrace.o(856040669184L, 6378);
      return str;
    case 1: 
      GMTrace.o(856040669184L, 6378);
      return "state_decrypt";
    case 2: 
      GMTrace.o(856040669184L, 6378);
      return "state_decompress";
    case 4: 
      GMTrace.o(856040669184L, 6378);
      return "state_check_sum";
    case 8: 
      GMTrace.o(856040669184L, 6378);
      return "state_file_invalid";
    case 16: 
      GMTrace.o(856040669184L, 6378);
      return "state_file_valid";
    }
    GMTrace.o(856040669184L, 6378);
    return "state_pre_verify_check_sum";
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/k/a/b/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */