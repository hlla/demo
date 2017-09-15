package com.tencent.mm.plugin.downloader.model;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.downloader.b.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class h
  extends i
{
  public ai irw;
  private DownloadManager kFs;
  public CopyOnWriteArraySet<Long> kFt;
  private Context mContext;
  
  public h(b paramb)
  {
    super(paramb);
    GMTrace.i(18602174447616L, 138597);
    this.irw = new ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(18593047642112L, 138529);
        h localh = h.this;
        com.tencent.mm.kernel.h.vL().D(new h.3(localh));
        localh = h.this;
        if ((localh.kFt == null) || (localh.kFt.size() == 0)) {}
        for (int i = 1; i == 0; i = 0)
        {
          h.this.irw.v(1000L, 1000L);
          GMTrace.o(18593047642112L, 138529);
          return false;
        }
        v.d("MicroMsg.FileDownloaderImpl23", "timer stop");
        GMTrace.o(18593047642112L, 138529);
        return false;
      }
    }, false);
    this.mContext = aa.getContext();
    this.kFs = ((DownloadManager)this.mContext.getSystemService("download"));
    this.kFt = new CopyOnWriteArraySet();
    GMTrace.o(18602174447616L, 138597);
  }
  
  private FileDownloadTaskInfo bf(long paramLong)
  {
    GMTrace.i(18602845536256L, 138602);
    FileDownloadTaskInfo localFileDownloadTaskInfo = new FileDownloadTaskInfo();
    Object localObject = new DownloadManager.Query();
    ((DownloadManager.Query)localObject).setFilterById(new long[] { paramLong });
    try
    {
      localObject = this.kFs.query((DownloadManager.Query)localObject);
      if (localObject == null)
      {
        v.e("MicroMsg.FileDownloaderImpl23", "query download status failed: cursor is null");
        GMTrace.o(18602845536256L, 138602);
        return localFileDownloadTaskInfo;
      }
    }
    catch (Exception localException1)
    {
      v.e("MicroMsg.FileDownloaderImpl23", "query downloadinfo from downloadmanager failed:%s, sysDownloadId:%d", new Object[] { localException1.toString(), Long.valueOf(paramLong) });
      GMTrace.o(18602845536256L, 138602);
      return localFileDownloadTaskInfo;
    }
    int i;
    int j;
    int k;
    int m;
    int n;
    if (localException1.moveToFirst())
    {
      i = localException1.getColumnIndex("status");
      j = localException1.getColumnIndex("uri");
      k = localException1.getColumnIndex("local_uri");
      m = localException1.getColumnIndex("bytes_so_far");
      n = localException1.getColumnIndex("total_size");
      if (i == -1) {}
    }
    try
    {
      switch (localException1.getInt(i))
      {
      case 1: 
      case 2: 
        for (;;)
        {
          if (j != -1) {
            localFileDownloadTaskInfo.url = localException1.getString(j);
          }
          if (k != -1)
          {
            String str = localException1.getString(k);
            if (bf.mA(str)) {
              break;
            }
            v.i("MicroMsg.FileDownloaderImpl23", "get download uri: [%s]", new Object[] { str });
            localFileDownloadTaskInfo.path = Uri.parse(str).getPath();
            v.i("MicroMsg.FileDownloaderImpl23", "get download path: [%s]", new Object[] { localFileDownloadTaskInfo.path });
          }
          if (m != -1) {
            localFileDownloadTaskInfo.fKX = localException1.getLong(m);
          }
          if (n != -1) {
            localFileDownloadTaskInfo.fKY = localException1.getLong(n);
          }
          localException1.close();
          v.i("MicroMsg.FileDownloaderImpl23", "querySysDownloadManager: id: %d, status: %d, url: %s, path: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(localFileDownloadTaskInfo.status), localFileDownloadTaskInfo.url, localFileDownloadTaskInfo.path });
          GMTrace.o(18602845536256L, 138602);
          return localFileDownloadTaskInfo;
          localFileDownloadTaskInfo.status = 1;
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        v.e("MicroMsg.FileDownloaderImpl23", "query download info failed: [%s]", new Object[] { localException2.toString() });
        localFileDownloadTaskInfo.status = 4;
        continue;
        localFileDownloadTaskInfo.status = 4;
        continue;
        localFileDownloadTaskInfo.status = 2;
        continue;
        localFileDownloadTaskInfo.status = 3;
        continue;
        v.e("MicroMsg.FileDownloaderImpl23", "get download uri failed");
      }
    }
  }
  
  public final long a(final f paramf)
  {
    GMTrace.i(18602308665344L, 138598);
    if ((paramf == null) || (bf.mA(paramf.iyE)))
    {
      v.e("MicroMsg.FileDownloaderImpl23", "Invalid Request");
      GMTrace.o(18602308665344L, 138598);
      return -1L;
    }
    if (paramf.kFk)
    {
      v.e("MicroMsg.FileDownloaderImpl23", "autoDownloadTask not use system downloader, appid = %s", new Object[] { paramf.ivn });
      GMTrace.o(18602308665344L, 138598);
      return -1L;
    }
    String str = paramf.iyE;
    final Object localObject1 = "";
    Object localObject2 = d.tD(str);
    if (localObject2 != null)
    {
      localObject1 = bf(((a)localObject2).field_sysDownloadId);
      if (((FileDownloadTaskInfo)localObject1).status == 1)
      {
        l = ((FileDownloadTaskInfo)localObject1).id;
        GMTrace.o(18602308665344L, 138598);
        return l;
      }
      localObject1 = ((a)localObject2).field_filePath;
      this.kFs.remove(new long[] { ((a)localObject2).field_sysDownloadId });
    }
    localObject2 = com.tencent.mm.compatible.util.h.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
    if (!bf.mA((String)localObject2))
    {
      localObject2 = new File((String)localObject2);
      if (!((File)localObject2).exists()) {
        v.i("MicroMsg.FileDownloaderImpl23", "download folder not exist, make new one : [%b]", new Object[] { Boolean.valueOf(((File)localObject2).mkdir()) });
      }
    }
    tM((String)localObject1);
    d.tB(str);
    d.tC(paramf.ivn);
    localObject1 = g.b(paramf);
    ((a)localObject1).field_downloadId = System.currentTimeMillis();
    ((a)localObject1).field_status = 0;
    ((a)localObject1).field_downloaderType = 1;
    str = z.Pp(str);
    ((a)localObject1).field_filePath = (com.tencent.mm.compatible.util.h.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/" + str);
    ((a)localObject1).field_startTime = System.currentTimeMillis();
    d.a((a)localObject1);
    com.tencent.mm.kernel.h.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(18606737850368L, 138631);
        if (paramf.kFj)
        {
          String str = g.tL(localObject1.field_downloadUrl);
          localObject1.field_md5 = str;
        }
        long l = h.this.c(localObject1);
        if (l > 0L)
        {
          localObject1.field_sysDownloadId = l;
          localObject1.field_status = 1;
          d.b(localObject1);
          h.this.kEX.h(localObject1.field_downloadId, localObject1.field_filePath);
          e.akG();
          if (e.bc(localObject1.field_downloadId))
          {
            e.akG();
            e.g(localObject1.field_downloadId, l);
          }
          h.this.kFt.add(Long.valueOf(localObject1.field_downloadId));
          if (h.this.irw.bJg()) {
            h.this.irw.v(100L, 100L);
          }
          v.i("MicroMsg.FileDownloaderImpl23", "addDownloadTask: id: %d, url: %s, path: %s", new Object[] { Long.valueOf(localObject1.field_downloadId), localObject1.field_downloadUrl, localObject1.field_filePath });
          GMTrace.o(18606737850368L, 138631);
          return;
        }
        localObject1.field_status = 4;
        d.b(localObject1);
        h.this.kEX.c(localObject1.field_downloadId, c.kEM, false);
        v.e("MicroMsg.FileDownloaderImpl23", "addDownloadTask Failed: Invalid downloadId");
        GMTrace.o(18606737850368L, 138631);
      }
    });
    long l = ((a)localObject1).field_downloadId;
    GMTrace.o(18602308665344L, 138598);
    return l;
  }
  
  public final int aT(long paramLong)
  {
    GMTrace.i(18602442883072L, 138599);
    e.akG();
    int i;
    if (e.bc(paramLong))
    {
      e.akG();
      paramLong = e.bd(paramLong);
      i = this.kFs.remove(new long[] { paramLong });
      GMTrace.o(18602442883072L, 138599);
      return i;
    }
    a locala = d.ba(paramLong);
    if (locala == null)
    {
      v.e("MicroMsg.FileDownloaderImpl23", "Invalid id");
      GMTrace.o(18602442883072L, 138599);
      return 0;
    }
    for (;;)
    {
      try
      {
        i = this.kFs.remove(new long[] { locala.field_sysDownloadId });
      }
      catch (Exception localException1)
      {
        try
        {
          v.i("MicroMsg.FileDownloaderImpl23", "removeDownloadTask: id: %d", new Object[] { Long.valueOf(paramLong) });
          com.tencent.mm.loader.stub.b.deleteFile(locala.field_filePath);
          v.i("MicroMsg.FileDownloaderImpl23", "removeDownloadTask: path: %s", new Object[] { locala.field_filePath });
          locala.field_status = 5;
          d.b(locala);
          this.kEX.aX(paramLong);
          this.kFt.remove(Long.valueOf(paramLong));
          GMTrace.o(18602442883072L, 138599);
          return i;
        }
        catch (Exception localException2)
        {
          for (;;) {}
        }
        localException1 = localException1;
        i = 0;
      }
      tmp208_205[0] = Long.valueOf(paramLong);
      Object[] tmp215_208 = tmp208_205;
      tmp215_208[1] = localException1.toString();
      v.e("MicroMsg.FileDownloaderImpl23", "remove task error:[%d], [%s]", tmp215_208);
    }
  }
  
  public final FileDownloadTaskInfo aU(long paramLong)
  {
    GMTrace.i(18602577100800L, 138600);
    e.akG();
    if (e.bc(paramLong))
    {
      e.akG();
      localObject = bf(e.bd(paramLong));
      ((FileDownloadTaskInfo)localObject).id = paramLong;
      ((FileDownloadTaskInfo)localObject).fLx = 1;
      GMTrace.o(18602577100800L, 138600);
      return (FileDownloadTaskInfo)localObject;
    }
    Object localObject = d.ba(paramLong);
    if (localObject == null)
    {
      localObject = new FileDownloadTaskInfo();
      GMTrace.o(18602577100800L, 138600);
      return (FileDownloadTaskInfo)localObject;
    }
    if ((((a)localObject).field_status == 4) || (((a)localObject).field_status == 2) || (((a)localObject).field_status == 5) || (((a)localObject).field_status == 3)) {
      this.kFt.remove(Long.valueOf(paramLong));
    }
    FileDownloadTaskInfo localFileDownloadTaskInfo = new FileDownloadTaskInfo();
    localFileDownloadTaskInfo.id = ((a)localObject).field_downloadId;
    localFileDownloadTaskInfo.url = ((a)localObject).field_downloadUrl;
    localFileDownloadTaskInfo.status = ((a)localObject).field_status;
    localFileDownloadTaskInfo.path = ((a)localObject).field_filePath;
    localFileDownloadTaskInfo.fFN = ((a)localObject).field_md5;
    localFileDownloadTaskInfo.kFr = ((a)localObject).field_autoDownload;
    localFileDownloadTaskInfo.fLx = ((a)localObject).field_downloaderType;
    localFileDownloadTaskInfo.fKX = ((a)localObject).field_downloadedSize;
    localFileDownloadTaskInfo.fKY = ((a)localObject).field_totalSize;
    GMTrace.o(18602577100800L, 138600);
    return localFileDownloadTaskInfo;
  }
  
  public final boolean aV(long paramLong)
  {
    GMTrace.i(18602979753984L, 138603);
    FileDownloadTaskInfo localFileDownloadTaskInfo = aU(paramLong);
    if (localFileDownloadTaskInfo == null)
    {
      v.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, record not found", new Object[] { Long.valueOf(paramLong) });
      GMTrace.o(18602979753984L, 138603);
      return false;
    }
    this.kFt.remove(Long.valueOf(paramLong));
    if (localFileDownloadTaskInfo.status != 1)
    {
      v.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, Task is not running", new Object[] { Long.valueOf(paramLong) });
      GMTrace.o(18602979753984L, 138603);
      return true;
    }
    int i = aT(paramLong);
    v.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, Task removed: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i) });
    if (i > 0)
    {
      GMTrace.o(18602979753984L, 138603);
      return true;
    }
    GMTrace.o(18602979753984L, 138603);
    return false;
  }
  
  public final boolean aW(long paramLong)
  {
    GMTrace.i(18603113971712L, 138604);
    a locala = d.ba(paramLong);
    if (locala == null)
    {
      v.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, record not found", new Object[] { Long.valueOf(paramLong) });
      GMTrace.o(18603113971712L, 138604);
      return false;
    }
    if (locala.field_downloaderType != 1)
    {
      v.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, downloader not matched", new Object[] { Long.valueOf(paramLong) });
      com.tencent.mm.loader.stub.b.deleteFile(locala.field_filePath);
      d.bb(paramLong);
      GMTrace.o(18603113971712L, 138604);
      return false;
    }
    if (locala.field_status == 1)
    {
      v.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, not in paused status", new Object[] { Long.valueOf(paramLong) });
      GMTrace.o(18603113971712L, 138604);
      return false;
    }
    this.kFs.remove(new long[] { locala.field_sysDownloadId });
    paramLong = c(locala);
    if (paramLong > 0L)
    {
      this.kFt.add(Long.valueOf(locala.field_downloadId));
      if (this.irw.bJg()) {
        this.irw.v(100L, 100L);
      }
      locala.field_sysDownloadId = paramLong;
      locala.field_status = 1;
      d.b(locala);
      GMTrace.o(18603113971712L, 138604);
      return true;
    }
    v.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, restart failed");
    GMTrace.o(18603113971712L, 138604);
    return false;
  }
  
  public final long c(a parama)
  {
    GMTrace.i(18602711318528L, 138601);
    try
    {
      DownloadManager.Request localRequest = new DownloadManager.Request(Uri.parse(parama.field_downloadUrl));
      localRequest.setAllowedNetworkTypes(3);
      localRequest.setShowRunningNotification(parama.field_showNotification);
      localRequest.setVisibleInDownloadsUi(parama.field_showNotification);
      if (!bf.mA(parama.field_fileName)) {
        localRequest.setTitle(parama.field_fileName);
      }
      localRequest.setDestinationUri(Uri.fromFile(new File(parama.field_filePath)));
      long l = this.kFs.enqueue(localRequest);
      if (l > 0L)
      {
        GMTrace.o(18602711318528L, 138601);
        return l;
      }
      v.e("MicroMsg.FileDownloaderImpl23", "addToSysDownloadManager Failed: Invalid downloadId");
      GMTrace.o(18602711318528L, 138601);
      return -1L;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.FileDownloaderImpl23", "Add download task failed: %s, url: %s", new Object[] { localException.toString(), parama.field_downloadUrl });
      GMTrace.o(18602711318528L, 138601);
    }
    return -1L;
  }
  
  public final void g(Long paramLong)
  {
    GMTrace.i(18603248189440L, 138605);
    v.d("MicroMsg.FileDownloaderImpl23", "updateDownloadStatus");
    locala = d.ba(paramLong.longValue());
    if (locala == null)
    {
      GMTrace.o(18603248189440L, 138605);
      return;
    }
    Object localObject1 = new DownloadManager.Query();
    ((DownloadManager.Query)localObject1).setFilterById(new long[] { locala.field_sysDownloadId });
    try
    {
      localObject1 = this.kFs.query((DownloadManager.Query)localObject1);
      if (localObject1 == null)
      {
        v.e("MicroMsg.FileDownloaderImpl23", "query download status failed: cursor is null");
        this.kFt.remove(paramLong);
        locala.field_status = 4;
        d.b(locala);
        GMTrace.o(18603248189440L, 138605);
        return;
      }
    }
    catch (Exception localException1)
    {
      v.e("MicroMsg.FileDownloaderImpl23", "query downloadinfo from downloadmanager failed:%s, sysDownloadId:%d", new Object[] { localException1.toString(), paramLong });
      this.kFt.remove(paramLong);
      locala.field_status = 4;
      d.b(locala);
      GMTrace.o(18603248189440L, 138605);
      return;
    }
    int m;
    int j;
    int k;
    if (localException1.moveToFirst())
    {
      m = localException1.getColumnIndex("status");
      i = localException1.getColumnIndex("local_uri");
      j = localException1.getColumnIndex("bytes_so_far");
      k = localException1.getColumnIndex("total_size");
      if (m == -1) {}
    }
    for (;;)
    {
      try
      {
        m = localException1.getInt(m);
        v.d("MicroMsg.FileDownloaderImpl23", "status = %d", new Object[] { Integer.valueOf(m) });
        switch (m)
        {
        }
      }
      catch (Exception localException2)
      {
        this.kFt.remove(paramLong);
        locala.field_status = 4;
        d.b(locala);
        v.e("MicroMsg.FileDownloaderImpl23", "query download info failed: [%s]", new Object[] { localException2.toString() });
        continue;
        this.kFt.remove(paramLong);
        i = c.kEM;
        locala.field_status = 4;
        d.b(locala);
        this.kEX.c(paramLong.longValue(), i, false);
        continue;
        this.kFt.remove(paramLong);
        locala.field_status = 2;
        d.b(locala);
        this.kEX.aY(paramLong.longValue());
        continue;
        this.kFt.remove(paramLong);
        if (i == -1) {
          continue;
        }
        if ((!bf.mA(locala.field_filePath)) && (com.tencent.mm.a.e.aO(locala.field_filePath))) {
          continue;
        }
        v.e("MicroMsg.FileDownloaderImpl23", "path not exists, path = %s", new Object[] { locala.field_filePath });
        locala.field_status = 4;
        d.b(locala);
        GMTrace.o(18603248189440L, 138605);
        return;
        Object localObject2 = new Intent();
        ((Intent)localObject2).setClass(aa.getContext(), FileDownloadService.class);
        ((Intent)localObject2).putExtra(FileDownloadService.EXTRA_ID, locala.field_downloadId);
        ((Intent)localObject2).putExtra(FileDownloadService.kFn, 1);
        localObject2 = aa.getContext().startService((Intent)localObject2);
        v.d("MicroMsg.FileDownloaderImpl23", "start download service: " + ((ComponentName)localObject2).getClassName() + ", " + ((ComponentName)localObject2).getPackageName());
        continue;
      }
      localException1.close();
      GMTrace.o(18603248189440L, 138605);
      return;
      if (j != -1) {
        locala.field_downloadedSize = localException1.getLong(j);
      }
      if (k != -1) {
        locala.field_totalSize = localException1.getLong(k);
      }
      locala.field_status = 1;
      d.b(locala);
      this.kEX.aZ(paramLong.longValue());
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/downloader/model/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */