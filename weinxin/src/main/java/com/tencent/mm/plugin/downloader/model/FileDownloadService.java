package com.tencent.mm.plugin.downloader.model;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.downloader.b.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;

public class FileDownloadService
  extends IntentService
{
  public static final String EXTRA_ID;
  public static final String EXTRA_PACKAGE_NAME;
  private static final String kFm;
  public static final String kFn;
  public static final String kFo;
  public static final String kFp;
  public static final String kFq;
  
  static
  {
    GMTrace.i(18607543156736L, 138637);
    kFm = FileDownloadService.class.getSimpleName() + "_extra_";
    EXTRA_ID = kFm + "id";
    kFn = kFm + "action_type";
    EXTRA_PACKAGE_NAME = kFm + "package_name";
    kFo = kFm + "file_path";
    kFp = kFm + "md5";
    kFq = kFm + "change_url";
    GMTrace.o(18607543156736L, 138637);
  }
  
  public FileDownloadService()
  {
    super("FileDownloadService");
    GMTrace.i(18607140503552L, 138634);
    GMTrace.o(18607140503552L, 138634);
  }
  
  private static boolean bI(String paramString1, String paramString2)
  {
    GMTrace.i(18607408939008L, 138636);
    File localFile = new File(paramString1);
    v.i("MicroMsg.FileDownloadService", "MD5 Check: %s, File Exists: %b", new Object[] { paramString1, Boolean.valueOf(localFile.exists()) });
    long l = System.currentTimeMillis();
    paramString1 = g.f(localFile);
    v.i("MicroMsg.FileDownloadService", "MD5 Check Time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    v.i("MicroMsg.FileDownloadService", "Original MD5: %s, Calculated MD5: %s", new Object[] { paramString2, paramString1 });
    if (bf.mA(paramString2))
    {
      bool = localFile.exists();
      GMTrace.o(18607408939008L, 138636);
      return bool;
    }
    if (bf.mA(paramString1))
    {
      v.i("MicroMsg.FileDownloadService", "check from file failed, may caused by low memory while checking md5");
      bool = localFile.exists();
      GMTrace.o(18607408939008L, 138636);
      return bool;
    }
    boolean bool = paramString2.equalsIgnoreCase(paramString1);
    GMTrace.o(18607408939008L, 138636);
    return bool;
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    GMTrace.i(18607274721280L, 138635);
    if (paramIntent == null)
    {
      GMTrace.o(18607274721280L, 138635);
      return;
    }
    int i = paramIntent.getIntExtra(kFn, 0);
    v.i("MicroMsg.FileDownloadService", "handle intent type : %d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    }
    for (;;)
    {
      GMTrace.o(18607274721280L, 138635);
      return;
      long l = paramIntent.getLongExtra(EXTRA_ID, -1L);
      boolean bool = paramIntent.getBooleanExtra(kFq, false);
      if (l < 0L)
      {
        v.e("MicroMsg.FileDownloadService", "Invalid id");
        GMTrace.o(18607274721280L, 138635);
        return;
      }
      if (h.vG().uV())
      {
        h.vG();
        if (!com.tencent.mm.kernel.a.uP()) {}
      }
      else
      {
        v.d("MicroMsg.FileDownloadService", "no user login");
        GMTrace.o(18607274721280L, 138635);
        return;
      }
      Object localObject2 = d.ba(l);
      if (localObject2 != null)
      {
        if ((bf.mA(((com.tencent.mm.plugin.downloader.b.a)localObject2).field_filePath)) || (!com.tencent.mm.a.e.aO(((com.tencent.mm.plugin.downloader.b.a)localObject2).field_filePath)))
        {
          v.i("MicroMsg.FileDownloadService", "file not exists, appid = " + ((com.tencent.mm.plugin.downloader.b.a)localObject2).field_appId);
          GMTrace.o(18607274721280L, 138635);
          return;
        }
        if (bf.mA(((com.tencent.mm.plugin.downloader.b.a)localObject2).field_md5))
        {
          v.i("MicroMsg.FileDownloadService", "Invalid original md5, abort checking");
          ((com.tencent.mm.plugin.downloader.b.a)localObject2).field_status = 3;
          d.b((com.tencent.mm.plugin.downloader.b.a)localObject2);
          e.akG().g(l, bool);
          GMTrace.o(18607274721280L, 138635);
          return;
        }
        if (bI(((com.tencent.mm.plugin.downloader.b.a)localObject2).field_filePath, ((com.tencent.mm.plugin.downloader.b.a)localObject2).field_md5))
        {
          ((com.tencent.mm.plugin.downloader.b.a)localObject2).field_status = 3;
          d.b((com.tencent.mm.plugin.downloader.b.a)localObject2);
          e.akG().g(l, bool);
          GMTrace.o(18607274721280L, 138635);
          return;
        }
        paramIntent = "";
        try
        {
          String str1 = l.q(new File(((com.tencent.mm.plugin.downloader.b.a)localObject2).field_filePath));
          paramIntent = str1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            v.e("MicroMsg.FileDownloadService", "readChannelId exception : " + localException.getMessage());
          }
          paramIntent = e.akG();
          localObject2 = d.ba(l);
          if (localObject2 == null) {
            break label664;
          }
        }
        v.i("MicroMsg.FileDownloadService", "ChannelId = %s, receivedSize = %d, fileSize = %d", new Object[] { paramIntent, Long.valueOf(((com.tencent.mm.plugin.downloader.b.a)localObject2).field_downloadedSize), Integer.valueOf(com.tencent.mm.a.e.aN(((com.tencent.mm.plugin.downloader.b.a)localObject2).field_filePath)) });
        com.tencent.mm.loader.stub.b.deleteFile(((com.tencent.mm.plugin.downloader.b.a)localObject2).field_filePath);
        ((com.tencent.mm.plugin.downloader.b.a)localObject2).field_status = 4;
        ((com.tencent.mm.plugin.downloader.b.a)localObject2).field_channelId = paramIntent;
        ((com.tencent.mm.plugin.downloader.b.a)localObject2).field_errCode = c.kEJ;
        d.b((com.tencent.mm.plugin.downloader.b.a)localObject2);
        if ((al.isWifi(this)) && (!bool) && (!bf.mA(((com.tencent.mm.plugin.downloader.b.a)localObject2).field_secondaryUrl)))
        {
          paramIntent = new f.a();
          paramIntent.tH(((com.tencent.mm.plugin.downloader.b.a)localObject2).field_secondaryUrl);
          paramIntent.be(((com.tencent.mm.plugin.downloader.b.a)localObject2).field_fileSize);
          paramIntent.tJ(((com.tencent.mm.plugin.downloader.b.a)localObject2).field_fileName);
          paramIntent.setAppId(((com.tencent.mm.plugin.downloader.b.a)localObject2).field_appId);
          paramIntent.tK(((com.tencent.mm.plugin.downloader.b.a)localObject2).field_md5);
          paramIntent.dl(true);
          paramIntent.kW(1);
          paramIntent.bl(((com.tencent.mm.plugin.downloader.b.a)localObject2).field_packageName);
          l = e.akG().a(paramIntent.kFl);
          v.i("MicroMsg.FileDownloadService", "MD5 check failed, restart download, id = " + l);
          GMTrace.o(18607274721280L, 138635);
          return;
        }
        localObject1 = aa.getContext();
        if ((!((com.tencent.mm.plugin.downloader.b.a)localObject2).field_showNotification) || (!bf.mA(((com.tencent.mm.plugin.downloader.b.a)localObject2).field_fileName))) {
          break label673;
        }
        localObject2 = ((com.tencent.mm.plugin.downloader.b.a)localObject2).field_downloadUrl;
        e.a(((Context)localObject1).getString(b.c.kEo), "", null);
      }
      for (;;)
      {
        paramIntent.kEX.c(l, c.kEJ, bool);
        label664:
        GMTrace.o(18607274721280L, 138635);
        return;
        label673:
        if ((((com.tencent.mm.plugin.downloader.b.a)localObject2).field_showNotification) && (!bf.mA(((com.tencent.mm.plugin.downloader.b.a)localObject2).field_fileName)))
        {
          String str2 = ((com.tencent.mm.plugin.downloader.b.a)localObject2).field_downloadUrl;
          e.a(((com.tencent.mm.plugin.downloader.b.a)localObject2).field_fileName, ((Context)localObject1).getString(b.c.kEo), null);
        }
      }
      Object localObject1 = paramIntent.getStringExtra(kFo);
      paramIntent = paramIntent.getStringExtra(kFp);
      if ((bf.mA((String)localObject1)) || (!com.tencent.mm.a.e.aO((String)localObject1)))
      {
        v.i("MicroMsg.FileDownloadService", "Invalid file path, ignored");
        GMTrace.o(18607274721280L, 138635);
        return;
      }
      if ((bf.mA(paramIntent)) || (bI((String)localObject1, paramIntent)))
      {
        paramIntent = Uri.fromFile(new File((String)localObject1));
        localObject1 = new Intent("android.intent.action.VIEW");
        ((Intent)localObject1).setDataAndType(paramIntent, "application/vnd.android.package-archive");
        ((Intent)localObject1).addFlags(268435456);
        startActivity((Intent)localObject1);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/downloader/model/FileDownloadService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */