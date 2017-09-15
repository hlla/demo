package com.tencent.mm.plugin.downloader.model;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.y.d;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.b.c;
import com.tencent.mm.e.a.hb;
import com.tencent.mm.e.a.hb.a;
import com.tencent.mm.modelsimple.ak;
import com.tencent.mm.plugin.downloader.b.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.af;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class e
{
  public static Map<Long, Long> kEQ;
  private static int kEW;
  private static e kEY;
  n kER;
  private n kES;
  private n kET;
  private n kEU;
  private n kEV;
  public b kEX;
  
  static
  {
    GMTrace.i(18614388260864L, 138688);
    kEQ = new HashMap();
    kEW = 2;
    GMTrace.o(18614388260864L, 138688);
  }
  
  private e()
  {
    GMTrace.i(18611569688576L, 138667);
    akL();
    if (com.tencent.mm.kernel.h.vG().uV())
    {
      com.tencent.mm.kernel.h.vG();
      if (!com.tencent.mm.kernel.a.uP())
      {
        kEW = bf.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("FileDownloaderType"), 2);
        v.i("MicroMsg.FileDownloadManager", "get downloader type from dynamic config = %d", new Object[] { Integer.valueOf(kEW) });
      }
    }
    for (;;)
    {
      this.kEX = new b();
      GMTrace.o(18611569688576L, 138667);
      return;
      v.i("MicroMsg.FileDownloadManager", "not login, use the default tmassist downloader");
    }
  }
  
  public static void a(String paramString1, String paramString2, PendingIntent paramPendingIntent)
  {
    GMTrace.i(18613582954496L, 138682);
    y.d locald = new y.d(aa.getContext());
    locald.a(paramString1);
    locald.b(paramString2);
    locald.L(17301634);
    locald.o(true);
    if (paramPendingIntent != null) {}
    for (locald.rR = paramPendingIntent;; locald.rR = PendingIntent.getActivity(aa.getContext(), 0, paramString1, 0))
    {
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.notification.b.a.class)).getNotification().b(locald.build());
      v.i("MicroMsg.FileDownloadManager", "show notification");
      GMTrace.o(18613582954496L, 138682);
      return;
      paramString1 = new Intent();
    }
  }
  
  public static e akG()
  {
    GMTrace.i(18611435470848L, 138666);
    if (kEY == null) {
      kEY = new e();
    }
    e locale = kEY;
    GMTrace.o(18611435470848L, 138666);
    return locale;
  }
  
  private n akH()
  {
    GMTrace.i(18611703906304L, 138668);
    v.i("MicroMsg.FileDownloadManager", "mDownloaderType = " + kEW);
    if (this.kER != null)
    {
      localObject = this.kER;
      GMTrace.o(18611703906304L, 138668);
      return (n)localObject;
    }
    Object localObject = new hb();
    com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
    int i = ((hb)localObject).fMn.fLx;
    if (i > 0) {
      kEW = i;
    }
    if (kEW == 1) {}
    for (this.kER = akI();; this.kER = this.kEU)
    {
      localObject = this.kER;
      GMTrace.o(18611703906304L, 138668);
      return (n)localObject;
      if (this.kEU == null) {
        this.kEU = new k(this.kEX);
      }
    }
  }
  
  private static void akL()
  {
    GMTrace.i(18613314519040L, 138680);
    SharedPreferences localSharedPreferences = aa.getContext().getSharedPreferences("off_line_download_ids", 0);
    if (localSharedPreferences == null)
    {
      GMTrace.o(18613314519040L, 138680);
      return;
    }
    Object localObject = localSharedPreferences.getAll();
    if ((localObject == null) || (((Map)localObject).size() == 0))
    {
      GMTrace.o(18613314519040L, 138680);
      return;
    }
    kEQ.clear();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)((Iterator)localObject).next();
      if ((localEntry1 != null) && (!bf.mA((String)localEntry1.getKey()))) {
        try
        {
          long l1 = bf.getLong((String)localEntry1.getKey(), 0L);
          long l2 = ((Long)localEntry1.getValue()).longValue();
          long l3 = System.currentTimeMillis() - l1;
          if ((l3 - l1 > 0L) && (l3 - l1 < 86400000L)) {
            kEQ.put(Long.valueOf(l1), Long.valueOf(l2));
          }
        }
        catch (Exception localException)
        {
          v.e("MicroMsg.FileDownloadManager", "parse download task failed: " + localException.toString());
          v.printErrStackTrace("MicroMsg.FileDownloadManager", localException, "", new Object[0]);
        }
      }
    }
    localSharedPreferences.edit().clear();
    localObject = kEQ.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry2 = (Map.Entry)((Iterator)localObject).next();
      localSharedPreferences.edit().putLong(localEntry2.getKey(), ((Long)localEntry2.getValue()).longValue());
    }
    localSharedPreferences.edit().commit();
    GMTrace.o(18613314519040L, 138680);
  }
  
  public static PendingIntent bH(String paramString1, String paramString2)
  {
    GMTrace.i(18614254043136L, 138687);
    Intent localIntent = new Intent();
    Context localContext = aa.getContext();
    localIntent.setClass(localContext, FileDownloadService.class);
    localIntent.putExtra(FileDownloadService.kFn, 3);
    localIntent.putExtra(FileDownloadService.kFo, paramString1);
    localIntent.putExtra(FileDownloadService.kFp, paramString2);
    paramString1 = PendingIntent.getService(localContext, (int)System.currentTimeMillis(), localIntent, 0);
    GMTrace.o(18614254043136L, 138687);
    return paramString1;
  }
  
  static boolean bc(long paramLong)
  {
    GMTrace.i(18613717172224L, 138683);
    boolean bool = kEQ.containsKey(Long.valueOf(paramLong));
    GMTrace.o(18613717172224L, 138683);
    return bool;
  }
  
  static long bd(long paramLong)
  {
    GMTrace.i(18613985607680L, 138685);
    Long localLong = (Long)kEQ.get(Long.valueOf(paramLong));
    if (localLong == null)
    {
      GMTrace.o(18613985607680L, 138685);
      return -1L;
    }
    paramLong = localLong.longValue();
    GMTrace.o(18613985607680L, 138685);
    return paramLong;
  }
  
  static void g(long paramLong1, long paramLong2)
  {
    GMTrace.i(18613851389952L, 138684);
    kEQ.put(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
    aa.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(paramLong1), paramLong2).commit();
    GMTrace.o(18613851389952L, 138684);
  }
  
  public static ArrayList<FileDownloadTaskInfo> q(ArrayList<String> paramArrayList)
  {
    ArrayList localArrayList = null;
    GMTrace.i(18612911865856L, 138677);
    Object localObject = d.wX();
    label45:
    FileDownloadTaskInfo localFileDownloadTaskInfo;
    if (localObject == null)
    {
      paramArrayList = localArrayList;
      localArrayList = new ArrayList();
      if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
        break label286;
      }
      paramArrayList = paramArrayList.iterator();
      if (!paramArrayList.hasNext()) {
        break label286;
      }
      localObject = (com.tencent.mm.plugin.downloader.b.a)paramArrayList.next();
      localFileDownloadTaskInfo = new FileDownloadTaskInfo();
      if ((((com.tencent.mm.plugin.downloader.b.a)localObject).field_status != 3) || (com.tencent.mm.a.e.aO(((com.tencent.mm.plugin.downloader.b.a)localObject).field_filePath))) {
        break label275;
      }
    }
    label275:
    for (localFileDownloadTaskInfo.status = 0;; localFileDownloadTaskInfo.status = ((com.tencent.mm.plugin.downloader.b.a)localObject).field_status)
    {
      localFileDownloadTaskInfo.appId = ((com.tencent.mm.plugin.downloader.b.a)localObject).field_appId;
      localFileDownloadTaskInfo.id = ((com.tencent.mm.plugin.downloader.b.a)localObject).field_downloadId;
      localFileDownloadTaskInfo.url = ((com.tencent.mm.plugin.downloader.b.a)localObject).field_downloadUrl;
      localFileDownloadTaskInfo.path = ((com.tencent.mm.plugin.downloader.b.a)localObject).field_filePath;
      localFileDownloadTaskInfo.fFN = ((com.tencent.mm.plugin.downloader.b.a)localObject).field_md5;
      localFileDownloadTaskInfo.fKX = ((com.tencent.mm.plugin.downloader.b.a)localObject).field_downloadedSize;
      localFileDownloadTaskInfo.fKY = ((com.tencent.mm.plugin.downloader.b.a)localObject).field_totalSize;
      localFileDownloadTaskInfo.kFr = ((com.tencent.mm.plugin.downloader.b.a)localObject).field_autoDownload;
      localFileDownloadTaskInfo.fLx = ((com.tencent.mm.plugin.downloader.b.a)localObject).field_downloaderType;
      localArrayList.add(localFileDownloadTaskInfo);
      break label45;
      paramArrayList = com.tencent.mm.plugin.downloader.b.b.r(paramArrayList);
      localObject = ((com.tencent.mm.plugin.downloader.b.b)localObject).rawQuery("select * from FileDownloadInfo where " + paramArrayList, new String[0]);
      paramArrayList = localArrayList;
      if (localObject == null) {
        break;
      }
      localArrayList = new ArrayList();
      if (((Cursor)localObject).moveToFirst()) {
        do
        {
          paramArrayList = new com.tencent.mm.plugin.downloader.b.a();
          paramArrayList.b((Cursor)localObject);
          localArrayList.add(paramArrayList);
        } while (((Cursor)localObject).moveToNext());
      }
      paramArrayList = localArrayList;
      if (localObject == null) {
        break;
      }
      ((Cursor)localObject).close();
      paramArrayList = localArrayList;
      break;
    }
    label286:
    GMTrace.o(18612911865856L, 138677);
    return localArrayList;
  }
  
  public static void tG(String paramString)
  {
    GMTrace.i(18613448736768L, 138681);
    v.i("MicroMsg.FileDownloadManager", "APK File Path: %s", new Object[] { paramString });
    if (bf.mA(paramString))
    {
      GMTrace.o(18613448736768L, 138681);
      return;
    }
    paramString = Uri.fromFile(new File(paramString));
    q.e(aa.getContext(), paramString);
    GMTrace.o(18613448736768L, 138681);
  }
  
  public final long a(f paramf)
  {
    GMTrace.i(18612240777216L, 138672);
    if (com.tencent.mm.kernel.h.vG().uV())
    {
      com.tencent.mm.kernel.h.vG();
      if (!com.tencent.mm.kernel.a.uP())
      {
        l = akH().a(paramf);
        GMTrace.o(18612240777216L, 138672);
        return l;
      }
    }
    long l = akI().a(paramf);
    if (l >= 0L)
    {
      kEQ.put(Long.valueOf(l), Long.valueOf(0L));
      aa.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(l), 0L).commit();
      v.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", new Object[] { Long.valueOf(l) });
      GMTrace.o(18612240777216L, 138672);
      return l;
    }
    v.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
    akJ().a(paramf);
    GMTrace.o(18612240777216L, 138672);
    return l;
  }
  
  public final int aT(long paramLong)
  {
    GMTrace.i(18612374994944L, 138673);
    if (bc(paramLong))
    {
      i = akI().aT(paramLong);
      GMTrace.o(18612374994944L, 138673);
      return i;
    }
    com.tencent.mm.plugin.downloader.b.a locala = d.ba(paramLong);
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      i = akK().aT(paramLong);
      GMTrace.o(18612374994944L, 138673);
      return i;
    }
    int i = akH().aT(paramLong);
    GMTrace.o(18612374994944L, 138673);
    return i;
  }
  
  public final FileDownloadTaskInfo aU(long paramLong)
  {
    GMTrace.i(18612509212672L, 138674);
    Object localObject;
    if (bc(paramLong))
    {
      localObject = akI().aU(paramLong);
      GMTrace.o(18612509212672L, 138674);
      return (FileDownloadTaskInfo)localObject;
    }
    com.tencent.mm.plugin.downloader.b.a locala = d.ba(paramLong);
    if ((locala != null) && (locala.field_status == 3) && (com.tencent.mm.a.e.aO(locala.field_filePath)))
    {
      localObject = new FileDownloadTaskInfo();
      ((FileDownloadTaskInfo)localObject).id = paramLong;
      ((FileDownloadTaskInfo)localObject).url = locala.field_downloadUrl;
      ((FileDownloadTaskInfo)localObject).status = 3;
      ((FileDownloadTaskInfo)localObject).path = locala.field_filePath;
      ((FileDownloadTaskInfo)localObject).fFN = locala.field_md5;
      ((FileDownloadTaskInfo)localObject).fKX = locala.field_downloadedSize;
      ((FileDownloadTaskInfo)localObject).fKY = locala.field_totalSize;
      ((FileDownloadTaskInfo)localObject).kFr = locala.field_autoDownload;
      ((FileDownloadTaskInfo)localObject).fLx = locala.field_downloaderType;
    }
    for (;;)
    {
      v.i("MicroMsg.FileDownloadManager", "getDownloadTaskInfo: id: %d, url: %s, status: %d, path: %s, md5: %s, totalsize: %d, autodownload: %b, downloaderType: %d", new Object[] { Long.valueOf(((FileDownloadTaskInfo)localObject).id), ((FileDownloadTaskInfo)localObject).url, Integer.valueOf(((FileDownloadTaskInfo)localObject).status), ((FileDownloadTaskInfo)localObject).path, ((FileDownloadTaskInfo)localObject).fFN, Long.valueOf(((FileDownloadTaskInfo)localObject).fKY), Boolean.valueOf(((FileDownloadTaskInfo)localObject).kFr), Integer.valueOf(((FileDownloadTaskInfo)localObject).fLx) });
      GMTrace.o(18612509212672L, 138674);
      return (FileDownloadTaskInfo)localObject;
      if ((locala != null) && (locala.field_downloaderType == 3))
      {
        localObject = akK().aU(paramLong);
      }
      else
      {
        FileDownloadTaskInfo localFileDownloadTaskInfo = akH().aU(paramLong);
        localObject = localFileDownloadTaskInfo;
        if (locala != null)
        {
          localFileDownloadTaskInfo.kFr = locala.field_autoDownload;
          localFileDownloadTaskInfo.fLx = locala.field_downloaderType;
          localObject = localFileDownloadTaskInfo;
        }
      }
    }
  }
  
  public final boolean aV(long paramLong)
  {
    GMTrace.i(18613046083584L, 138678);
    if (bc(paramLong))
    {
      bool = akI().aV(paramLong);
      GMTrace.o(18613046083584L, 138678);
      return bool;
    }
    com.tencent.mm.plugin.downloader.b.a locala = d.ba(paramLong);
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      bool = akK().aV(paramLong);
      GMTrace.o(18613046083584L, 138678);
      return bool;
    }
    boolean bool = akH().aV(paramLong);
    GMTrace.o(18613046083584L, 138678);
    return bool;
  }
  
  public final boolean aW(long paramLong)
  {
    GMTrace.i(18613180301312L, 138679);
    if (bc(paramLong))
    {
      bool = akI().aW(paramLong);
      GMTrace.o(18613180301312L, 138679);
      return bool;
    }
    com.tencent.mm.plugin.downloader.b.a locala = d.ba(paramLong);
    if ((locala != null) && (locala.field_downloaderType == 3))
    {
      bool = akK().aW(paramLong);
      GMTrace.o(18613180301312L, 138679);
      return bool;
    }
    boolean bool = akH().aW(paramLong);
    GMTrace.o(18613180301312L, 138679);
    return bool;
  }
  
  public final n akI()
  {
    GMTrace.i(18611838124032L, 138669);
    if (this.kET == null) {
      this.kET = new h(this.kEX);
    }
    n localn = this.kET;
    GMTrace.o(18611838124032L, 138669);
    return localn;
  }
  
  public final n akJ()
  {
    GMTrace.i(18611972341760L, 138670);
    if (this.kES == null) {
      this.kES = new j(this.kEX);
    }
    n localn = this.kES;
    GMTrace.o(18611972341760L, 138670);
    return localn;
  }
  
  public final n akK()
  {
    GMTrace.i(18612106559488L, 138671);
    if (this.kEV == null) {
      this.kEV = new a(this.kEX);
    }
    n localn = this.kEV;
    GMTrace.o(18612106559488L, 138671);
    return localn;
  }
  
  final void g(final long paramLong, boolean paramBoolean)
  {
    GMTrace.i(18614119825408L, 138686);
    v.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded id[%d], stack[%s]", new Object[] { Long.valueOf(paramLong), bf.bJP() });
    final Object localObject = aa.getContext();
    if (bc(paramLong))
    {
      localObject = aU(paramLong);
      this.kEX.b(paramLong, ((FileDownloadTaskInfo)localObject).path, paramBoolean);
      GMTrace.o(18614119825408L, 138686);
      return;
    }
    final com.tencent.mm.plugin.downloader.b.a locala = d.ba(paramLong);
    if (locala == null)
    {
      GMTrace.o(18614119825408L, 138686);
      return;
    }
    if (bf.mA(locala.field_packageName))
    {
      String str = q.Mk(locala.field_filePath);
      if (!bf.mA(str))
      {
        locala.field_packageName = str;
        v.i("MicroMsg.FileDownloadManager", "get package name from file : %s, %s", new Object[] { locala.field_filePath, str });
        d.b(locala);
      }
    }
    final int i = q.Ml(locala.field_filePath);
    v.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded field_packageName[%s], field_filePath[%s], versionCode[%d]", new Object[] { locala.field_packageName, locala.field_filePath, Integer.valueOf(i) });
    com.tencent.mm.kernel.h.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(18594255601664L, 138538);
        new ak(locala.field_packageName, i).a(com.tencent.mm.kernel.h.vH().gXs.hsI, new com.tencent.mm.y.e()
        {
          public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.y.k paramAnonymous2k)
          {
            GMTrace.i(18593316077568L, 138531);
            paramAnonymous2k.hss = true;
            if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
            {
              v.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded get pkg sig error");
              g.oSF.a(322L, 28L, 1L, false);
              g.oSF.i(11098, new Object[] { Integer.valueOf(4028), String.format("%s,%s,%d,%d", new Object[] { e.1.this.kEx.field_packageName, e.1.this.kEx.field_filePath, Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) }) });
            }
            for (;;)
            {
              ae.v(new Runnable()
              {
                public final void run()
                {
                  GMTrace.i(18593718730752L, 138534);
                  PendingIntent localPendingIntent = null;
                  if (e.1.this.kEx.field_fileType == 1) {
                    localPendingIntent = e.bH(e.1.this.kEx.field_filePath, e.1.this.kEx.field_md5);
                  }
                  String str;
                  if ((e.1.this.kEx.field_showNotification) && (bf.mA(e.1.this.kEx.field_fileName)))
                  {
                    str = e.1.this.kEx.field_downloadUrl;
                    e.a(e.1.this.val$context.getString(b.c.kEn), "", localPendingIntent);
                  }
                  for (;;)
                  {
                    if ((e.1.this.kEx.field_autoInstall) && (e.1.this.kEx.field_fileType == 1)) {
                      e.tG(e.1.this.kEx.field_filePath);
                    }
                    e.this.kEX.b(e.1.this.kEA, e.1.this.kEx.field_filePath, e.1.this.kEE);
                    GMTrace.o(18593718730752L, 138534);
                    return;
                    if ((e.1.this.kEx.field_showNotification) && (!bf.mA(e.1.this.kEx.field_fileName)))
                    {
                      str = e.1.this.kEx.field_downloadUrl;
                      e.a(e.1.this.kEx.field_fileName, e.1.this.val$context.getString(b.c.kEn), localPendingIntent);
                    }
                  }
                }
              });
              GMTrace.o(18593316077568L, 138531);
              return;
              paramAnonymous2String = MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "yyb_pkg_sig_prefs", 4).getString(e.1.this.kEx.field_packageName, "");
              v.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded sig[%s]", new Object[] { paramAnonymous2String });
              if (!bf.mA(paramAnonymous2String))
              {
                try
                {
                  c.a(new File(e.1.this.kEx.field_filePath), paramAnonymous2String);
                  v.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode done");
                  g.oSF.a(322L, 25L, 1L, false);
                  g.oSF.i(11098, new Object[] { Integer.valueOf(4025), String.format("%s,%s,%s", new Object[] { e.1.this.kEx.field_packageName, e.1.this.kEx.field_filePath, paramAnonymous2String }) });
                }
                catch (Exception paramAnonymous2String)
                {
                  v.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode e: " + paramAnonymous2String.getMessage());
                  g.oSF.a(322L, 27L, 1L, false);
                  g.oSF.i(11098, new Object[] { Integer.valueOf(4027), String.format("%s,%s,%s", new Object[] { e.1.this.kEx.field_packageName, e.1.this.kEx.field_filePath, paramAnonymous2String.getMessage() }) });
                }
              }
              else
              {
                g.oSF.a(322L, 26L, 1L, false);
                g.oSF.i(11098, new Object[] { Integer.valueOf(4026), String.format("%s,%s", new Object[] { e.1.this.kEx.field_packageName, e.1.this.kEx.field_filePath }) });
              }
            }
          }
        });
        GMTrace.o(18594255601664L, 138538);
      }
    });
    GMTrace.o(18614119825408L, 138686);
  }
  
  public final FileDownloadTaskInfo tE(String paramString)
  {
    GMTrace.i(18612643430400L, 138675);
    paramString = d.tA(paramString);
    if (paramString != null)
    {
      paramString = aU(paramString.field_downloadId);
      GMTrace.o(18612643430400L, 138675);
      return paramString;
    }
    paramString = new FileDownloadTaskInfo();
    GMTrace.o(18612643430400L, 138675);
    return paramString;
  }
  
  public final FileDownloadTaskInfo tF(String paramString)
  {
    GMTrace.i(18612777648128L, 138676);
    paramString = d.tD(paramString);
    if (paramString != null)
    {
      paramString = aU(paramString.field_downloadId);
      GMTrace.o(18612777648128L, 138676);
      return paramString;
    }
    paramString = new FileDownloadTaskInfo();
    GMTrace.o(18612777648128L, 138676);
    return paramString;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/downloader/model/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */