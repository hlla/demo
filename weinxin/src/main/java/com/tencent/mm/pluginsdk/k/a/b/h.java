package com.tencent.mm.pluginsdk.k.a.b;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.k.a.d.o;
import com.tencent.mm.pluginsdk.k.a.d.o.a;
import com.tencent.mm.pluginsdk.k.a.d.q;
import com.tencent.mm.pluginsdk.k.a.d.r;
import com.tencent.mm.pluginsdk.k.a.e.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.Set;

final class h
  implements com.tencent.mm.pluginsdk.k.a.d.h
{
  h()
  {
    GMTrace.i(858725023744L, 6398);
    GMTrace.o(858725023744L, 6398);
  }
  
  private static void b(q paramq, boolean paramBoolean)
  {
    GMTrace.i(859127676928L, 6401);
    o.a.sFk.Mv(paramq.field_urlKey);
    a.Mx(paramq.field_filePath);
    a.Mx(paramq.field_filePath + ".decompressed");
    a.Mx(paramq.field_filePath + ".decrypted");
    if ((2 == paramq.field_status) && (!paramBoolean))
    {
      v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "delete completed but invalid file, but forceDL = false, skip this downloading");
      GMTrace.o(859127676928L, 6401);
      return;
    }
    if ((paramq.field_maxRetryTimes > 0) && (paramq.field_retryTimes <= 0))
    {
      v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "record_maxRetryTimes = %d, record_retryTimes = %d, retry times out, skip ", new Object[] { Integer.valueOf(paramq.field_maxRetryTimes), Integer.valueOf(paramq.field_retryTimes) });
      GMTrace.o(859127676928L, 6401);
      return;
    }
    paramq.field_retryTimes -= 1;
    paramq.field_fileUpdated = true;
    o.a.sFk.e(paramq);
    j.u(paramq.field_reportId, 12L);
    v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "post network task");
    paramq = c.b(paramq);
    paramq.rUz = false;
    o.a.sFk.d(paramq);
    GMTrace.o(859127676928L, 6401);
  }
  
  private static boolean c(q paramq)
  {
    GMTrace.i(858993459200L, 6400);
    boolean bool = bf.mz(g.aV(paramq.field_filePath)).equals(paramq.field_md5);
    GMTrace.o(858993459200L, 6400);
    return bool;
  }
  
  private static void d(q paramq)
  {
    GMTrace.i(859261894656L, 6402);
    if (paramq.field_fileUpdated)
    {
      j.u(paramq.field_reportId, 13L);
      j.u(paramq.field_reportId, 44L);
    }
    if ((!paramq.field_fileCompress) && (!paramq.field_fileEncrypt))
    {
      b.c.sDY.b(paramq.field_resType, paramq.field_subType, paramq.field_filePath, bf.getInt(paramq.field_fileVersion, 0));
      GMTrace.o(859261894656L, 6402);
      return;
    }
    v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "send query and decrypt request");
    b.c.sDY.a(paramq);
    GMTrace.o(859261894656L, 6402);
  }
  
  public final void a(q paramq, int paramInt)
  {
    GMTrace.i(858859241472L, 6399);
    Object localObject1;
    Object localObject2;
    if ((paramq.field_expireTime != 0L) && (paramq.field_expireTime <= bf.Nz()))
    {
      v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "urlKey(%s) exceed expire time(%d), delete", new Object[] { paramq.field_urlKey, Long.valueOf(paramq.field_expireTime) });
      localObject1 = o.a.sFk;
      localObject2 = paramq.field_urlKey;
      if (((o)localObject1).rWt) {
        ((o)localObject1).sFh.gR((String)localObject2);
      }
      a.Mx(paramq.field_filePath);
      a.Mx(paramq.field_filePath + ".decompressed");
      a.Mx(paramq.field_filePath + ".decrypted");
      o.a.sFk.Mv(paramq.field_urlKey);
      GMTrace.o(858859241472L, 6399);
      return;
    }
    if (paramInt == 0)
    {
      v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "network unavailable, skip");
      GMTrace.o(858859241472L, 6399);
      return;
    }
    if ((2 == paramInt) && (1 == paramq.field_networkType))
    {
      v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "network type = gprs, record network type = wifi, skip this ");
      GMTrace.o(858859241472L, 6399);
      return;
    }
    if (paramq.field_deleted)
    {
      v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "record(%s), should have been deleted", new Object[] { paramq.field_urlKey });
      a.Mx(paramq.field_filePath);
      a.Mx(paramq.field_filePath + ".decompressed");
      a.Mx(paramq.field_filePath + ".decrypted");
      GMTrace.o(858859241472L, 6399);
      return;
    }
    if (paramq.field_status == 2)
    {
      long l = a.By(paramq.field_filePath);
      if (paramq.field_contentLength > l)
      {
        v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "content-length > fileSize, resume download");
        if (0L == l)
        {
          if (!paramq.field_needRetry)
          {
            v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "no need retry, resType %d, subType %d, version %s", new Object[] { Integer.valueOf(paramq.field_resType), Integer.valueOf(paramq.field_subType), paramq.field_fileVersion });
            GMTrace.o(858859241472L, 6399);
            return;
          }
          if (1 != paramInt)
          {
            v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "fileSize = 0, completed file may be deleted by user, skip this because it's not wifi");
            GMTrace.o(858859241472L, 6399);
            return;
          }
          localObject1 = b.c.sDY.bDi().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (b.b)((Iterator)localObject1).next();
            paramInt = paramq.field_resType;
            paramInt = paramq.field_subType;
            bf.getInt(paramq.field_fileVersion, 0);
            if (((b.b)localObject2).bDj())
            {
              v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "filterNotRetry by %s, resType %d, subType %d, version %s", new Object[] { localObject2.getClass().getName(), Integer.valueOf(paramq.field_resType), Integer.valueOf(paramq.field_subType), paramq.field_fileVersion });
              GMTrace.o(858859241472L, 6399);
              return;
            }
          }
          paramq.field_fileUpdated = true;
          b.c.sDY.f(paramq.field_resType, paramq.field_subType, 0, bf.mz(paramq.field_groupId2).equals("NewXml"));
          o.a.sFk.e(paramq);
        }
        o.a.sFk.d(c.b(paramq));
        GMTrace.o(858859241472L, 6399);
        return;
      }
      if (!c(paramq))
      {
        v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "file invalid, re-download");
        if (1 == paramInt) {}
        for (boolean bool = true;; bool = false)
        {
          b(paramq, bool);
          GMTrace.o(858859241472L, 6399);
          return;
        }
      }
      v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 check ok, file download complete, throw event to do decrypt");
      d(paramq);
      GMTrace.o(858859241472L, 6399);
      return;
    }
    if ((paramq.field_status == 1) || (paramq.field_status == 0))
    {
      v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "db status: downloading or waiting, db content-length %d", new Object[] { Long.valueOf(paramq.field_contentLength) });
      if (!o.a.sFk.Mu(paramq.field_urlKey))
      {
        v.d("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "check md5");
        if (c(paramq))
        {
          v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 match, request complete, throw event to do decrypt");
          paramq.field_status = 2;
          paramq.field_contentLength = a.By(paramq.field_filePath);
          o.a.sFk.e(paramq);
          d(paramq);
          GMTrace.o(858859241472L, 6399);
          return;
        }
        if (0L == a.By(paramq.field_filePath))
        {
          paramq.field_fileUpdated = true;
          o.a.sFk.e(paramq);
          b.c.sDY.f(paramq.field_resType, paramq.field_subType, 0, bf.mz(paramq.field_groupId2).equals("NewXml"));
        }
        v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 not match,  download");
        o.a.sFk.d(c.b(paramq));
        GMTrace.o(858859241472L, 6399);
        return;
      }
      v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "request already in downloading queue");
      GMTrace.o(858859241472L, 6399);
      return;
    }
    if ((paramq.field_status == 4) || (paramq.field_status == 3))
    {
      v.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "file invalid, re-download");
      paramq.field_status = 0;
      b(paramq, true);
    }
    GMTrace.o(858859241472L, 6399);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/k/a/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */