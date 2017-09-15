package com.tencent.mm.pluginsdk.k.a.b;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.pluginsdk.k.a.d.k;
import com.tencent.mm.pluginsdk.k.a.d.o;
import com.tencent.mm.pluginsdk.k.a.d.o.a;
import com.tencent.mm.pluginsdk.k.a.d.q;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

final class f
{
  private static final class a
  {
    public static void a(q paramq, g paramg)
    {
      GMTrace.i(850671960064L, 6338);
      if (paramq == null) {
        v.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record is null");
      }
      while ((paramq != null) && (paramq.field_deleted) && (paramg.Mn(paramq.field_fileVersion) <= 0))
      {
        v.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "deletedFile.version = %s, cacheReq.version = %s, this file should have been deleted, skip this cache-op", new Object[] { paramq.field_fileVersion, paramg.sEK });
        GMTrace.o(850671960064L, 6338);
        return;
        v.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record: urlKey = %s, url = %s, contentLength = %d, deleted = %b, eccSignature = %s, expireTime = %d, fileCompress = %b, fileEncrypt = %b, filePath = %s, fileUpdated = %b, fileVersion = %s, from = %s, keyVersion = %s, (encryptKey == null) = %b, maxRetryTimes = %d, retriedTimes = %d, sampleId = %s, dlStatus = %d", new Object[] { paramq.field_urlKey, paramq.field_url, Long.valueOf(paramq.field_contentLength), Boolean.valueOf(paramq.field_deleted), paramq.field_eccSignature, Long.valueOf(paramq.field_expireTime), Boolean.valueOf(paramq.field_fileCompress), Boolean.valueOf(paramq.field_fileEncrypt), paramq.field_filePath, Boolean.valueOf(paramq.field_fileUpdated), paramq.field_fileVersion, paramq.field_groupId2, Integer.valueOf(paramq.field_keyVersion), Boolean.valueOf(bf.mA(paramq.field_encryptKey)), Integer.valueOf(paramq.field_maxRetryTimes), Integer.valueOf(paramq.field_retryTimes), paramq.field_sampleId, Integer.valueOf(paramq.field_status) });
        v.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record.encryptKey = %s", new Object[] { paramq.field_encryptKey });
      }
      if (paramq == null)
      {
        paramq = paramg.bDl();
        paramq.field_fileUpdated = true;
        if (bf.mA(paramq.field_encryptKey)) {
          paramq.field_keyVersion = -1;
        }
        v.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new record " + paramq);
        o.a.sFk.e(paramq);
        b.c.sDY.f(paramg.fEs, paramg.fEt, 0, paramg.fEy);
        a(true, true, paramq, paramg);
        GMTrace.o(850671960064L, 6338);
        return;
      }
      v.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record is not null");
      paramq.field_networkType = paramg.networkType;
      if (bf.mA(paramq.field_originalMd5)) {
        paramq.field_originalMd5 = paramg.sDx;
      }
      if (paramg.Mn(paramq.field_fileVersion) > 0)
      {
        v.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new version of file, re-download");
        q localq = paramg.bDl();
        if (paramq.field_keyVersion >= paramg.sDv)
        {
          localq.field_keyVersion = paramq.field_keyVersion;
          localq.field_encryptKey = paramq.field_encryptKey;
        }
        localq.field_fileUpdated = true;
        localq.field_deleted = false;
        o.a.sFk.e(localq);
        b.c.sDY.f(paramg.fEs, paramg.fEt, 0, paramg.fEy);
        o.a.sFk.Mv(paramg.sDr);
        a(false, true, localq, paramg);
        GMTrace.o(850671960064L, 6338);
        return;
      }
      if ((paramg.Mn(paramq.field_fileVersion) == 0) && (!paramq.field_needRetry))
      {
        v.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "no need retry, resType %d, subType %d, version %s", new Object[] { Integer.valueOf(paramq.field_resType), Integer.valueOf(paramq.field_subType), paramq.field_fileVersion });
        GMTrace.o(850671960064L, 6338);
        return;
      }
      if ((paramq.field_status == 2) || (paramq.field_status == 1) || (paramq.field_status == 0))
      {
        long l = com.tencent.mm.pluginsdk.k.a.e.a.By(paramq.field_filePath);
        if (paramq.field_contentLength > l)
        {
          v.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "content-length(%d) > fileSize(%d), resume download", new Object[] { Long.valueOf(paramq.field_contentLength), Long.valueOf(l) });
          if (0L == l)
          {
            b.c.sDY.f(paramg.fEs, paramg.fEt, 0, paramg.fEy);
            a(false, true, paramq, paramg);
            GMTrace.o(850671960064L, 6338);
            return;
          }
          a(true, false, paramq, paramg);
          GMTrace.o(850671960064L, 6338);
          return;
        }
        if (bf.mz(com.tencent.mm.a.g.aV(i.Mo(paramg.sDr))).equals(paramq.field_md5))
        {
          v.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "md5 check ok, file download complete, throw event to do decrypt");
          paramq.field_status = 2;
          paramq.field_contentLength = com.tencent.mm.pluginsdk.k.a.e.a.By(paramq.field_filePath);
          paramq.field_fileUpdated = false;
          o.a.sFk.e(paramq);
          j.u(paramq.field_reportId, 13L);
          j.u(paramq.field_reportId, 44L);
          j.a(paramq.field_resType, paramq.field_subType, paramq.field_url, bf.getInt(paramq.field_fileVersion, 0), j.a.sEv, true, "NewXml".equalsIgnoreCase(paramq.field_groupId2), true, paramq.field_sampleId);
          if ((!paramg.sEa) && (!paramg.sEb))
          {
            b.c.sDY.b(paramg.fEs, paramg.fEt, i.Mo(paramg.sDr), bf.getInt(paramg.sEK, 0));
            GMTrace.o(850671960064L, 6338);
            return;
          }
          v.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "send query and decrypt request");
          f.b.a(paramq, false);
          GMTrace.o(850671960064L, 6338);
        }
      }
      else
      {
        if ((paramq.field_status != 4) && (paramq.field_status != 3)) {
          break label951;
        }
      }
      v.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "file invalid, re-download");
      a(false, true, paramq, paramg);
      label951:
      GMTrace.o(850671960064L, 6338);
    }
    
    private static void a(boolean paramBoolean1, boolean paramBoolean2, q paramq, g paramg)
    {
      GMTrace.i(850806177792L, 6339);
      v.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "sendIORequest, fileAppend = %b, fileUpdate = %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      if ((paramq.field_maxRetryTimes > 0) && (paramq.field_retryTimes <= 0) && (!paramBoolean2))
      {
        v.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record_maxRetryTimes = %d, record_retryTimes = %d, retry times out, skip", new Object[] { Integer.valueOf(paramq.field_maxRetryTimes), Integer.valueOf(paramq.field_retryTimes) });
        GMTrace.o(850806177792L, 6339);
        return;
      }
      paramq.field_status = 0;
      if (paramBoolean2)
      {
        paramq.field_maxRetryTimes = paramg.sDB;
        paramq.field_retryTimes = paramg.sDB;
        paramq.field_fileUpdated = true;
        paramq.field_priority = paramg.priority;
        if (paramg.fileSize > 0L) {
          paramq.field_fileSize = paramg.fileSize;
        }
        o.a.sFk.e(paramq);
      }
      while (o.a.sFk.Mu(paramg.sDr))
      {
        v.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s is already downloading", new Object[] { paramg.sDr });
        if (paramg.fEy)
        {
          j.u(paramg.sDz, 9L);
          j.u(paramg.sDz, 44L);
        }
        GMTrace.o(850806177792L, 6339);
        return;
        paramq.field_retryTimes -= 1;
        paramq.field_priority = paramg.priority;
        o.a.sFk.e(paramq);
        j.u(paramq.field_reportId, 12L);
      }
      v.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s, post network task", new Object[] { paramg.sDr });
      if ((paramBoolean2) && (!paramBoolean1)) {
        b.c.sDY.f(paramq.field_resType, paramq.field_subType, 0, bf.mz(paramq.field_groupId2).equals("NewXml"));
      }
      paramq = c.b(paramq);
      paramq.rUz = paramBoolean1;
      paramq.sDZ = paramg.sDZ;
      if (!paramBoolean1)
      {
        com.tencent.mm.pluginsdk.k.a.e.a.Mx(i.Mo(paramq.sDr));
        com.tencent.mm.pluginsdk.k.a.e.a.Mx(i.Mo(paramq.sDr) + ".decompressed");
        com.tencent.mm.pluginsdk.k.a.e.a.Mx(i.Mo(paramq.sDr) + ".decrypted");
      }
      o.a.sFk.d(paramq);
      GMTrace.o(850806177792L, 6339);
    }
  }
  
  private static final class b
  {
    public static void a(q paramq, boolean paramBoolean)
    {
      GMTrace.i(852282572800L, 6350);
      if (paramq == null)
      {
        v.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "get null record, skip");
        GMTrace.o(852282572800L, 6350);
        return;
      }
      String str1 = paramq.field_urlKey;
      String str2 = paramq.field_filePath;
      String str3 = paramq.field_md5;
      boolean bool1 = paramq.field_fileCompress;
      boolean bool2 = paramq.field_fileEncrypt;
      byte[] arrayOfByte = paramq.field_eccSignature;
      int i = bf.getInt(paramq.field_fileVersion, 0);
      int j = paramq.field_keyVersion;
      String str4 = paramq.field_encryptKey;
      boolean bool3 = paramq.field_deleted;
      v.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "queried info: deleted = " + bool3 + ", filePath = " + str2 + ", md5 = " + str3 + ", originalMd5 = " + paramq.field_originalMd5 + ", fileCompress = " + bool1 + ", fileEncrypt = " + bool2 + ", eccSignature = " + arrayOfByte + ", fileVersion = " + i + ", (encrypt key == empty) = " + bf.mA(str4));
      v.d("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "queried encryptKey = %s", new Object[] { str4 });
      if (!bool2)
      {
        if (paramBoolean)
        {
          j.u(paramq.field_reportId, 53L);
          j.u(paramq.field_reportId, 45L);
        }
        if (!bool1)
        {
          v.e("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "file is not encrypted nor compressed, just return");
          GMTrace.o(852282572800L, 6350);
          return;
        }
      }
      if ((j != i) && (bool2))
      {
        v.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "file version(%d) != key version(%d), skip", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if (j >= 0)
        {
          j.u(paramq.field_reportId, 52L);
          j.u(paramq.field_reportId, 45L);
        }
        GMTrace.o(852282572800L, 6350);
        return;
      }
      if (bool3)
      {
        v.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "this file should have been deleted, skip this decrypt-op");
        j.u(paramq.field_reportId, 51L);
        j.u(paramq.field_reportId, 45L);
        GMTrace.o(852282572800L, 6350);
        return;
      }
      if ((bf.mA(str4)) && (bool2))
      {
        v.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "encryptKey invalid, skip");
        j.u(paramq.field_reportId, 54L);
        j.u(paramq.field_reportId, 45L);
        GMTrace.o(852282572800L, 6350);
        return;
      }
      if ((!bf.mA(str3)) && (!bf.mA(str2)))
      {
        if (o.a.sFk.Mu(str1))
        {
          v.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "request(%s) is downloading or queueing, hold this decrypt-op", new Object[] { str1 });
          GMTrace.o(852282572800L, 6350);
          return;
        }
        if (!bf.mz(com.tencent.mm.a.g.aV(str2)).equals(str3))
        {
          v.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "md5 not match, file spoiled, skip this decrypt-op");
          paramq.field_status = 3;
          o.a.sFk.e(paramq);
          j.u(paramq.field_reportId, 56L);
          j.u(paramq.field_reportId, 45L);
          GMTrace.o(852282572800L, 6350);
          return;
        }
        if (!o.a.sFk.Mu(str1))
        {
          v.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "request supposed to complete, send decrypt request");
          b.c.sDY.f(paramq.field_resType, paramq.field_subType, 1, bf.mz(paramq.field_groupId2).equals("NewXml"));
          b.c.sDY.a(paramq);
          GMTrace.o(852282572800L, 6350);
        }
      }
      else
      {
        v.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "this decrypt-op is invalid, record.md5 = %s, record.filePath = %s", new Object[] { str3, str2 });
      }
      GMTrace.o(852282572800L, 6350);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/k/a/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */