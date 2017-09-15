package com.tencent.mm.plugin.downloader.model;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.y.d;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnTaskStateInfo;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.downloader.b.c;
import com.tencent.mm.plugin.downloader.ui.FileDownloadConfirmUI;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.u.af;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  extends i
{
  private static final String kEt;
  public h.a hGp;
  private byte[] hzT;
  private HashMap<String, Long> kEu;
  public HashMap<String, Long> kEv;
  private ConcurrentHashMap<String, Integer> kEw;
  public Context mContext;
  
  static
  {
    GMTrace.i(18608885334016L, 138647);
    kEt = com.tencent.mm.loader.stub.a.hgk + "BigFile";
    GMTrace.o(18608885334016L, 138647);
  }
  
  public a(b paramb)
  {
    super(paramb);
    GMTrace.i(18607677374464L, 138638);
    this.hzT = new byte[0];
    this.mContext = aa.getContext();
    this.kEu = new HashMap();
    this.kEv = new HashMap();
    this.kEw = new ConcurrentHashMap();
    this.hGp = new a();
    GMTrace.o(18607677374464L, 138638);
  }
  
  public static void a(com.tencent.mm.modelcdntran.h paramh, f paramf)
  {
    GMTrace.i(18607945809920L, 138640);
    paramh.hyU = new HashMap();
    if (paramf.kFe != 0L) {
      paramh.hyU.put("Content-Length", paramf.kFe);
    }
    GMTrace.o(18607945809920L, 138640);
  }
  
  public final long a(final f paramf)
  {
    GMTrace.i(18607811592192L, 138639);
    if ((paramf == null) || (bf.mA(paramf.iyE)))
    {
      v.e("MicroMsg.FileCDNDownloader", "Invalid Request");
      GMTrace.o(18607811592192L, 138639);
      return -1L;
    }
    final String str1 = paramf.iyE;
    Object localObject1 = d.tD(str1);
    if (localObject1 != null)
    {
      localObject2 = aU(((com.tencent.mm.plugin.downloader.b.a)localObject1).field_downloadId);
      if (((FileDownloadTaskInfo)localObject2).status == 1)
      {
        l = ((FileDownloadTaskInfo)localObject2).id;
        GMTrace.o(18607811592192L, 138639);
        return l;
      }
    }
    final Object localObject2 = new File(kEt);
    if (!((File)localObject2).exists()) {
      v.i("MicroMsg.FileCDNDownloader", "Make download dir result: %b", new Object[] { Boolean.valueOf(((File)localObject2).mkdirs()) });
    }
    d.tB(str1);
    d.tC(paramf.ivn);
    localObject2 = g.b(paramf);
    ((com.tencent.mm.plugin.downloader.b.a)localObject2).field_downloadId = System.currentTimeMillis();
    ((com.tencent.mm.plugin.downloader.b.a)localObject2).field_status = 1;
    ((com.tencent.mm.plugin.downloader.b.a)localObject2).field_downloaderType = 3;
    String str2 = z.Pp(str1);
    ((com.tencent.mm.plugin.downloader.b.a)localObject2).field_filePath = (kEt + "/" + str2);
    if (localObject1 != null)
    {
      str2 = ((com.tencent.mm.plugin.downloader.b.a)localObject2).field_filePath;
      localObject1 = ((com.tencent.mm.plugin.downloader.b.a)localObject1).field_filePath;
      if ((str2 != null) && (localObject1 != null) && (!str2.equals(localObject1)))
      {
        localObject1 = new File((String)localObject1);
        if (((File)localObject1).exists()) {
          v.i("MicroMsg.FileCDNDownloader", "Delete previous file result: %b", new Object[] { Boolean.valueOf(((File)localObject1).delete()) });
        }
      }
    }
    ((com.tencent.mm.plugin.downloader.b.a)localObject2).field_startTime = System.currentTimeMillis();
    d.a((com.tencent.mm.plugin.downloader.b.a)localObject2);
    new Thread(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(18607006285824L, 138633);
        v.d("MicroMsg.FileCDNDownloader", "addDownloadTask");
        com.tencent.mm.modelcdntran.h localh = new com.tencent.mm.modelcdntran.h();
        localh.hyS = true;
        localh.field_mediaId = localObject2.field_downloadUrl;
        localh.field_fullpath = localObject2.field_filePath;
        localh.hyO = str1;
        localh.hyT = paramf.kFd;
        localh.hyM = a.this.hGp;
        localh.hyP = 15;
        localh.hyQ = 3600;
        localh.allow_mobile_net_download = true;
        a.a(localh, paramf);
        com.tencent.mm.modelcdntran.g.Em().b(localh, -1);
        a.this.kEX.h(localObject2.field_downloadId, localObject2.field_filePath);
        a.this.b(str1, 1, 0, true);
        GMTrace.o(18607006285824L, 138633);
      }
    }).start();
    long l = ((com.tencent.mm.plugin.downloader.b.a)localObject2).field_downloadId;
    GMTrace.o(18607811592192L, 138639);
    return l;
  }
  
  public final int aT(final long paramLong)
  {
    GMTrace.i(18608080027648L, 138641);
    new Thread(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(18600161181696L, 138582);
        com.tencent.mm.plugin.downloader.b.a locala = d.ba(paramLong);
        if (locala == null)
        {
          GMTrace.o(18600161181696L, 138582);
          return;
        }
        com.tencent.mm.modelcdntran.g.Em().iQ(locala.field_downloadUrl);
        d.j(locala.field_downloadId, 5);
        a.this.kEX.aX(paramLong);
        a.this.cancelNotification(locala.field_downloadUrl);
        GMTrace.o(18600161181696L, 138582);
      }
    }).start();
    GMTrace.o(18608080027648L, 138641);
    return 1;
  }
  
  public final FileDownloadTaskInfo aU(long paramLong)
  {
    GMTrace.i(18608214245376L, 138642);
    FileDownloadTaskInfo localFileDownloadTaskInfo = new FileDownloadTaskInfo();
    com.tencent.mm.plugin.downloader.b.a locala = d.ba(paramLong);
    CdnLogic.CdnTaskStateInfo localCdnTaskStateInfo;
    if (locala != null)
    {
      localCdnTaskStateInfo = CdnLogic.httpMultiSocketDownloadTaskState(locala.field_downloadUrl);
      if (localCdnTaskStateInfo == null)
      {
        localFileDownloadTaskInfo.status = 0;
        localFileDownloadTaskInfo.id = paramLong;
        localFileDownloadTaskInfo.fLx = locala.field_downloaderType;
        localFileDownloadTaskInfo.kFr = locala.field_autoDownload;
        localFileDownloadTaskInfo.path = locala.field_filePath;
        localFileDownloadTaskInfo.url = locala.field_downloadUrl;
        localFileDownloadTaskInfo.fFN = locala.field_md5;
      }
    }
    else
    {
      GMTrace.o(18608214245376L, 138642);
      return localFileDownloadTaskInfo;
    }
    switch (localCdnTaskStateInfo.taskState)
    {
    default: 
      localFileDownloadTaskInfo.status = 0;
    }
    for (;;)
    {
      localFileDownloadTaskInfo.fKX = localCdnTaskStateInfo.completeSize;
      localFileDownloadTaskInfo.fKY = localCdnTaskStateInfo.fileTotalSize;
      break;
      localFileDownloadTaskInfo.status = 1;
      continue;
      localFileDownloadTaskInfo.status = 2;
    }
  }
  
  public final boolean aV(final long paramLong)
  {
    GMTrace.i(18608348463104L, 138643);
    new Thread(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(18593987166208L, 138536);
        v.d("MicroMsg.FileCDNDownloader", "pauseDownloadTask");
        com.tencent.mm.plugin.downloader.b.a locala = d.ba(paramLong);
        if ((locala != null) && (locala.field_status == 1))
        {
          CdnLogic.pauseHttpMultiSocketDownloadTask(locala.field_downloadUrl);
          d.j(locala.field_downloadId, 2);
          a.this.kEX.aY(paramLong);
          a.this.cancelNotification(locala.field_downloadUrl);
        }
        GMTrace.o(18593987166208L, 138536);
      }
    }).start();
    GMTrace.o(18608348463104L, 138643);
    return true;
  }
  
  public final boolean aW(final long paramLong)
  {
    GMTrace.i(18608482680832L, 138644);
    final com.tencent.mm.plugin.downloader.b.a locala = d.ba(paramLong);
    if ((locala != null) && (locala.field_status == 2))
    {
      new Thread(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(18599624310784L, 138578);
          v.d("MicroMsg.FileCDNDownloader", "resumeDownloadTask");
          CdnLogic.resumeHttpMultiSocketDownloadTask(locala.field_downloadUrl);
          locala.field_startTime = System.currentTimeMillis();
          if (locala.field_status == 2) {}
          for (locala.field_startState = c.kEO;; locala.field_startState = c.kEP)
          {
            locala.field_startSize = locala.field_downloadedSize;
            locala.field_status = 1;
            locala.field_errCode = 0;
            d.b(locala);
            a.this.kEX.i(paramLong, locala.field_filePath);
            a.this.b(locala.field_downloadUrl, 1, 0, true);
            GMTrace.o(18599624310784L, 138578);
            return;
          }
        }
      }).start();
      GMTrace.o(18608482680832L, 138644);
      return true;
    }
    GMTrace.o(18608482680832L, 138644);
    return false;
  }
  
  public final void b(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    GMTrace.i(18608616898560L, 138645);
    v.d("MicroMsg.FileCDNDownloader", "state = %d, progress = %d, firstShown = %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) });
    localObject = d.tD(paramString);
    if (localObject == null)
    {
      v.e("MicroMsg.FileCDNDownloader", "updateNotification failed: null task info");
      GMTrace.o(18608616898560L, 138645);
      return;
    }
    if (!((com.tencent.mm.plugin.downloader.b.a)localObject).field_showNotification)
    {
      GMTrace.o(18608616898560L, 138645);
      return;
    }
    y.d locald = new y.d(this.mContext);
    long l;
    if (paramBoolean)
    {
      l = System.currentTimeMillis();
      this.kEu.put(paramString, Long.valueOf(l));
      locald.b(l);
    }
    for (;;)
    {
      locald.a(((com.tencent.mm.plugin.downloader.b.a)localObject).field_fileName);
      switch (paramInt1)
      {
      case 2: 
      case 3: 
      default: 
        cancelNotification(paramString);
        GMTrace.o(18608616898560L, 138645);
        return;
        Long localLong = (Long)this.kEu.get(paramString);
        if (localLong != null) {
          locald.b(localLong.longValue());
        }
        break;
      }
    }
    locald.L(17301633);
    boolean bool;
    if (paramInt2 == 0)
    {
      bool = true;
      locald.b(100, paramInt2, bool);
      locald.b(this.mContext.getString(b.c.ejP));
      locald.j(2, true);
      l = ((com.tencent.mm.plugin.downloader.b.a)localObject).field_downloadId;
      localObject = new Intent(this.mContext, FileDownloadConfirmUI.class);
      ((Intent)localObject).putExtra("extra_download_id", l);
      locald.rR = PendingIntent.getActivity(this.mContext, (int)System.currentTimeMillis(), (Intent)localObject, 268435456);
      label328:
      localObject = this.hzT;
      if (!paramBoolean) {
        break label458;
      }
    }
    for (;;)
    {
      label458:
      try
      {
        paramInt1 = ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.notification.b.a.class)).getNotification().b(locald.build());
        this.kEw.put(paramString, Integer.valueOf(paramInt1));
        GMTrace.o(18608616898560L, 138645);
        return;
      }
      finally {}
      bool = false;
      break;
      locald.L(17301634);
      locald.o(true);
      localObject = new Intent();
      locald.rR = PendingIntent.getActivity(aa.getContext(), 0, (Intent)localObject, 0);
      locald.b(this.mContext.getString(b.c.ejO));
      break label328;
      paramString = (Integer)this.kEw.get(paramString);
      if (paramString != null) {
        ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.notification.b.a.class)).getNotification().notify(paramString.intValue(), locald.build());
      }
    }
  }
  
  public final void cancelNotification(String paramString)
  {
    GMTrace.i(18608751116288L, 138646);
    synchronized (this.hzT)
    {
      Integer localInteger = (Integer)this.kEw.get(paramString);
      if (localInteger == null)
      {
        v.i("MicroMsg.FileCDNDownloader", "No notification id found");
        GMTrace.o(18608751116288L, 138646);
        return;
      }
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(localInteger.intValue());
      v.i("MicroMsg.FileCDNDownloader", "cancelNotification, id = " + localInteger);
      this.kEw.remove(paramString);
      GMTrace.o(18608751116288L, 138646);
      return;
    }
  }
  
  private final class a
    implements h.a
  {
    public a()
    {
      GMTrace.i(18614522478592L, 138689);
      GMTrace.o(18614522478592L, 138689);
    }
    
    public final int a(String paramString, int paramInt, keep_ProgressInfo paramkeep_ProgressInfo, keep_SceneResult paramkeep_SceneResult, boolean paramBoolean)
    {
      GMTrace.i(18614656696320L, 138690);
      Object localObject;
      if (paramkeep_ProgressInfo == null)
      {
        localObject = "null";
        if (paramkeep_SceneResult != null) {
          break label94;
        }
      }
      label94:
      for (String str = "null";; str = paramkeep_SceneResult.toString())
      {
        v.d("MicroMsg.FileCDNDownloader", "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramString, Integer.valueOf(paramInt), localObject, str });
        localObject = d.tD(paramString);
        if (localObject != null) {
          break label104;
        }
        v.i("MicroMsg.FileCDNDownloader", "info is null, return");
        GMTrace.o(18614656696320L, 138690);
        return 0;
        localObject = paramkeep_ProgressInfo.toString();
        break;
      }
      label104:
      if (paramInt == 44530)
      {
        v.i("MicroMsg.FileCDNDownloader", "duplicate request, ignore this request, media id is %s", new Object[] { paramString });
        GMTrace.o(18614656696320L, 138690);
        return 0;
      }
      if (paramInt != 0)
      {
        v.e("MicroMsg.FileCDNDownloader", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
        ((com.tencent.mm.plugin.downloader.b.a)localObject).field_errCode = Math.abs(paramInt);
        ((com.tencent.mm.plugin.downloader.b.a)localObject).field_status = 4;
        d.b((com.tencent.mm.plugin.downloader.b.a)localObject);
        a.this.kEX.c(((com.tencent.mm.plugin.downloader.b.a)localObject).field_downloadId, Math.abs(paramInt), false);
        a.this.b(((com.tencent.mm.plugin.downloader.b.a)localObject).field_downloadUrl, 4, 0, false);
        GMTrace.o(18614656696320L, 138690);
        return 0;
      }
      if (paramkeep_ProgressInfo != null)
      {
        paramString = (Long)a.this.kEv.get(((com.tencent.mm.plugin.downloader.b.a)localObject).field_downloadUrl);
        paramkeep_SceneResult = Long.valueOf(System.currentTimeMillis());
        if ((paramString != null) && (paramkeep_SceneResult.longValue() - paramString.longValue() < 500L))
        {
          GMTrace.o(18614656696320L, 138690);
          return 0;
        }
        a.this.kEv.put(((com.tencent.mm.plugin.downloader.b.a)localObject).field_downloadUrl, paramkeep_SceneResult);
        d.e(((com.tencent.mm.plugin.downloader.b.a)localObject).field_downloadId, paramkeep_ProgressInfo.field_finishedLength, paramkeep_ProgressInfo.field_toltalLength);
        a.this.kEX.aZ(((com.tencent.mm.plugin.downloader.b.a)localObject).field_downloadId);
        paramInt = 0;
        if (paramkeep_ProgressInfo.field_toltalLength > 0) {
          paramInt = (int)(paramkeep_ProgressInfo.field_finishedLength / paramkeep_ProgressInfo.field_toltalLength * 100.0F);
        }
        int i;
        if (paramInt < 0) {
          i = 0;
        }
        for (;;)
        {
          a.this.b(((com.tencent.mm.plugin.downloader.b.a)localObject).field_downloadUrl, 1, i, false);
          GMTrace.o(18614656696320L, 138690);
          return 0;
          i = paramInt;
          if (paramInt > 100) {
            i = 100;
          }
        }
      }
      if (paramkeep_SceneResult != null)
      {
        if (paramkeep_SceneResult.field_retCode == 0) {
          break label534;
        }
        v.e("MicroMsg.FileCDNDownloader", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { paramString, Integer.valueOf(paramkeep_SceneResult.field_retCode), paramkeep_SceneResult });
        ((com.tencent.mm.plugin.downloader.b.a)localObject).field_errCode = Math.abs(paramkeep_SceneResult.field_retCode);
        ((com.tencent.mm.plugin.downloader.b.a)localObject).field_status = 4;
        d.b((com.tencent.mm.plugin.downloader.b.a)localObject);
        a.this.kEX.c(((com.tencent.mm.plugin.downloader.b.a)localObject).field_downloadId, Math.abs(paramkeep_SceneResult.field_retCode), false);
        a.this.b(((com.tencent.mm.plugin.downloader.b.a)localObject).field_downloadUrl, 4, 0, false);
      }
      for (;;)
      {
        GMTrace.o(18614656696320L, 138690);
        return 0;
        label534:
        v.i("MicroMsg.FileCDNDownloader", "cdn trans suceess, media id : %s", new Object[] { paramString });
        paramString = new Intent();
        paramString.putExtra(FileDownloadService.kFn, 1);
        paramString.setClass(a.this.mContext, FileDownloadService.class);
        paramString.putExtra(FileDownloadService.EXTRA_ID, ((com.tencent.mm.plugin.downloader.b.a)localObject).field_downloadId);
        try
        {
          a.this.mContext.startService(paramString);
          a.this.cancelNotification(((com.tencent.mm.plugin.downloader.b.a)localObject).field_downloadUrl);
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            v.e("MicroMsg.FileCDNDownloader", paramString.getMessage());
          }
        }
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      GMTrace.i(18614790914048L, 138691);
      GMTrace.o(18614790914048L, 138691);
    }
    
    public final byte[] i(String paramString, byte[] paramArrayOfByte)
    {
      GMTrace.i(18614925131776L, 138692);
      GMTrace.o(18614925131776L, 138692);
      return new byte[0];
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/downloader/model/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */