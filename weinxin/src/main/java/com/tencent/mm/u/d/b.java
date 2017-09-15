package com.tencent.mm.u.d;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.IPackageStatsObserver.Stub;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.database.Cursor;
import android.os.Process;
import android.os.StatFs;
import android.preference.PreferenceManager;
import android.util.Base64;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.o;
import com.tencent.mm.ap.m;
import com.tencent.mm.ap.n;
import com.tencent.mm.ap.t;
import com.tencent.mm.bj.g;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class b
  implements c.a
{
  private static final String fwB;
  private static final String fwC;
  private static b hpe;
  public static final String hpf;
  public static List<String> hpo;
  private SharedPreferences hgn;
  public long[] hoJ;
  public long hoK;
  public volatile boolean hoL;
  public long hpg;
  public long hph;
  public long hpi;
  public long hpj;
  public long hpk;
  public long hpl;
  public long hpm;
  private long hpn;
  
  static
  {
    GMTrace.i(610288009216L, 4547);
    String str = p.rB();
    fwB = str;
    fwC = o.getString(str.hashCode());
    hpf = com.tencent.mm.compatible.util.e.hgi + "/tencent/MicroMsg/SQLTrace/";
    hpo = Arrays.asList(new String[] { "FTS5IndexMicroMsg.db" });
    GMTrace.o(610288009216L, 4547);
  }
  
  public b()
  {
    GMTrace.i(606261477376L, 4517);
    this.hoL = false;
    this.hoJ = new long[] { 0L, 0L, 0L };
    this.hoK = 0L;
    this.hgn = aa.bIO();
    AH();
    GMTrace.o(606261477376L, 4517);
  }
  
  private String AD()
  {
    GMTrace.i(607066783744L, 4523);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    localPrintStream.println("#client.version=" + d.sXh);
    localPrintStream.println("#accinfo.revision=" + com.tencent.mm.sdk.platformtools.e.REV);
    localPrintStream.println("#accinfo.uin=" + ao.hlE.A("last_login_uin", fwC));
    localPrintStream.println("#accinfo.dev=" + fwB);
    localPrintStream.println("#accinfo.build=" + com.tencent.mm.sdk.platformtools.e.TIME + ":" + com.tencent.mm.sdk.platformtools.e.HOSTNAME + ":" + f.fuN);
    try
    {
      localObject1 = com.tencent.mm.compatible.util.h.getDataDirectory();
      Object localObject2 = new StatFs(((File)localObject1).getPath());
      StatFs localStatFs = new StatFs(com.tencent.mm.compatible.util.e.hgi);
      localObject1 = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[] { Integer.valueOf(((ActivityManager)aa.getContext().getSystemService("activity")).getMemoryClass()), ((File)localObject1).getAbsolutePath(), Integer.valueOf(((StatFs)localObject2).getBlockSize()), Integer.valueOf(((StatFs)localObject2).getBlockCount()), Integer.valueOf(((StatFs)localObject2).getAvailableBlocks()), com.tencent.mm.compatible.util.e.hgi, Integer.valueOf(localStatFs.getBlockSize()), Integer.valueOf(localStatFs.getBlockCount()), Integer.valueOf(localStatFs.getAvailableBlocks()) });
      localPrintStream.println("#accinfo.data=" + (String)localObject1);
      localObject1 = new Date();
      localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
      localPrintStream.println("#accinfo.uploadTime=" + ((SimpleDateFormat)localObject2).format((Date)localObject1));
      long l1 = aQ(aa.getContext());
      if (l1 > 0L) {
        localPrintStream.println("#logfile.autoAdapteTime :" + l1);
      }
      if (aP(aa.getContext()) != 0L)
      {
        long l2 = aP(aa.getContext()) - aO(aa.getContext());
        localPrintStream.println("#logfile.fulllast :" + l2);
        if ((l2 > 0L) && (l2 < 28800000L))
        {
          l1 += 100L;
          PreferenceManager.getDefaultSharedPreferences(aa.getContext()).edit().putLong("sql_trace_log_autoAdaptaTime", l1).commit();
          v.i("MicroMsg.SQLTraceManager", "auto Adapte Time to %d", new Object[] { Long.valueOf(l1) });
          AH();
        }
        localObject1 = t.Id().gl(21);
        if ((localObject1 != null) && (localObject1.length != 0) && (localObject1[0] != null)) {
          break label982;
        }
        localPrintStream.println("#traceconfig hardcode");
        if (this.hoJ[1] != -1L) {
          localPrintStream.println("#wxpackage :cache size=" + this.hoJ[0] + " data size= " + this.hoJ[1] + " code size =" + this.hoJ[2]);
        }
        localObject1 = new StringBuilder("#dbsize : EnMicroMsg.db size=");
        ap.yY();
        localPrintStream.println(new File(c.vp()).length());
        localObject1 = new StringBuilder("#dbsize : SnsMicroMsg.db size=");
        localObject2 = new StringBuilder();
        ap.yY();
        localPrintStream.println(new File(((StringBuilder)localObject2).append(c.xu()).append("SnsMicroMsg.db").toString()).length());
        ap.yY();
        a(c.wP(), localPrintStream, Arrays.asList(new String[] { "message", "rconversation", "rcontact", "ImgInfo2", "BizInfo", "img_flag", "fmessage_conversation", "AppInfo", "AppMessage", "EmojiInfo", "EmojiGroupInfo", "bottleconversation", "bottlemessage", "chatroom", "rbottleconversation", "userinfo" }));
        localPrintStream.println("#sql.content:");
        localObject1 = localByteArrayOutputStream.toString();
      }
    }
    catch (Exception localException1)
    {
      try
      {
        String str;
        for (;;)
        {
          Object localObject1;
          localByteArrayOutputStream.close();
          GMTrace.o(607066783744L, 4523);
          return (String)localObject1;
          localException1 = localException1;
          v.e("MicroMsg.SQLTraceManager", "check data size failed :%s", new Object[] { localException1.getMessage() });
          str = "";
          continue;
          localPrintStream.println("#logfile.fullTimelast :" + (System.currentTimeMillis() - aO(aa.getContext())));
        }
        label982:
        localPrintStream.println("#traceconfig id=" + str[0].id + " version=" + str[0].version);
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
    }
  }
  
  public static b AG()
  {
    GMTrace.i(606127259648L, 4516);
    if (hpe == null) {
      hpe = new b();
    }
    b localb = hpe;
    GMTrace.o(606127259648L, 4516);
    return localb;
  }
  
  private void AH()
  {
    GMTrace.i(606395695104L, 4518);
    this.hpg = this.hgn.getLong("sql_trace_main_thread_select_interval_time", 300L);
    this.hph = this.hgn.getLong("sql_trace_main_thread_update_interval_time", 500L);
    this.hpi = this.hgn.getLong("sql_trace_child_thread_interval_time", 1500L);
    long l = aQ(aa.getContext());
    if (l > 0L)
    {
      this.hpg += l;
      this.hph += l;
      this.hpi += l;
      v.i("MicroMsg.SQLTraceManager", "auto adapte Time %d", new Object[] { Long.valueOf(l) });
    }
    this.hpj = this.hgn.getLong("sql_trace_child_transaction_interval_time", 5000L);
    this.hpn = this.hgn.getLong("sql_trace_file_full_size", 30720L);
    this.hpk = this.hgn.getLong("sql_trace_log_file_max_size", 35840L);
    this.hpl = this.hgn.getLong("sql_trace_upload_file_min_size", 10240L);
    this.hpm = this.hgn.getLong("sql_upload_time_interval", 21600000L);
    i(new File(hpf, "MMSQL.trace"));
    v.i("MicroMsg.SQLTraceManager", "update arg %d %d %d %d %d %d %d %d", new Object[] { Long.valueOf(this.hpg), Long.valueOf(this.hph), Long.valueOf(this.hpi), Long.valueOf(this.hpj), Long.valueOf(this.hpn), Long.valueOf(this.hpk), Long.valueOf(this.hpl), Long.valueOf(this.hpm) });
    GMTrace.o(606395695104L, 4518);
  }
  
  private static long a(String paramString, g paramg)
  {
    GMTrace.i(606932566016L, 4522);
    paramString = paramg.a("select count(*) from " + paramString, null, 2);
    long l = 0L;
    if (paramString.moveToFirst()) {
      l = paramString.getLong(0);
    }
    paramString.close();
    GMTrace.o(606932566016L, 4522);
    return l;
  }
  
  private static void a(g paramg, PrintStream paramPrintStream, List<String> paramList)
  {
    GMTrace.i(607201001472L, 4524);
    if ((paramg == null) || (!paramg.isOpen()))
    {
      v.i("MicroMsg.SQLTraceManager", "db is not open!");
      GMTrace.o(607201001472L, 4524);
      return;
    }
    long l = System.currentTimeMillis();
    if ((paramList != null) && (paramList.size() > 0)) {
      paramList = paramList.iterator();
    }
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      paramPrintStream.println("#table : " + str + " count=" + a(str, paramg));
      continue;
      paramList = paramg.a("select name from sqlite_master where type='table' ", null, 2);
      while (paramList.moveToNext())
      {
        str = paramList.getString(0);
        paramPrintStream.println("#table : " + str + " count=" + a(str, paramg));
      }
      paramList.close();
    }
    v.i("MicroMsg.SQLTraceManager", "dump all table count last %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    GMTrace.o(607201001472L, 4524);
  }
  
  public static void a(String paramString1, String paramString2, StringBuilder paramStringBuilder)
  {
    GMTrace.i(607335219200L, 4525);
    paramStringBuilder.append(paramString1).append(":").append(paramString2).append(" ");
    GMTrace.o(607335219200L, 4525);
  }
  
  public static long aN(Context paramContext)
  {
    GMTrace.i(607872090112L, 4529);
    long l = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("sql_report_lastUploadTime", 0L);
    GMTrace.o(607872090112L, 4529);
    return l;
  }
  
  private static long aO(Context paramContext)
  {
    GMTrace.i(608006307840L, 4530);
    long l = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("sql_trace_log_file_create_time", 0L);
    GMTrace.o(608006307840L, 4530);
    return l;
  }
  
  private static long aP(Context paramContext)
  {
    GMTrace.i(608274743296L, 4532);
    long l = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("sql_trace_log_file_full_time", 0L);
    GMTrace.o(608274743296L, 4532);
    return l;
  }
  
  private static long aQ(Context paramContext)
  {
    GMTrace.i(608408961024L, 4533);
    long l = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("sql_trace_log_autoAdaptaTime", 0L);
    GMTrace.o(608408961024L, 4533);
    return l;
  }
  
  public static void c(Context paramContext, long paramLong)
  {
    GMTrace.i(607737872384L, 4528);
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong("sql_report_lastUploadTime", paramLong).commit();
    GMTrace.o(607737872384L, 4528);
  }
  
  private static void d(Context paramContext, long paramLong)
  {
    GMTrace.i(608140525568L, 4531);
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong("sql_trace_log_file_full_time", paramLong).commit();
    GMTrace.o(608140525568L, 4531);
  }
  
  /* Error */
  public static String gF(String paramString)
  {
    // Byte code:
    //   0: ldc2_w 618
    //   3: sipush 4521
    //   6: invokestatic 47	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: new 202	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 365	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore_0
    //   18: new 621	java/io/FileInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 623	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   26: astore_0
    //   27: aload_0
    //   28: invokevirtual 626	java/io/FileInputStream:available	()I
    //   31: newarray <illegal type>
    //   33: astore_1
    //   34: aload_0
    //   35: aload_1
    //   36: invokevirtual 630	java/io/FileInputStream:read	([B)I
    //   39: pop
    //   40: new 57	java/lang/String
    //   43: dup
    //   44: aload_1
    //   45: invokestatic 636	com/tencent/mm/bl/e:bp	([B)[B
    //   48: invokespecial 639	java/lang/String:<init>	([B)V
    //   51: astore_1
    //   52: aload_0
    //   53: invokevirtual 640	java/io/FileInputStream:close	()V
    //   56: ldc2_w 618
    //   59: sipush 4521
    //   62: invokestatic 103	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   65: aload_1
    //   66: areturn
    //   67: astore_0
    //   68: ldc_w 317
    //   71: aload_0
    //   72: ldc_w 432
    //   75: iconst_0
    //   76: anewarray 4	java/lang/Object
    //   79: invokestatic 644	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   82: goto -26 -> 56
    //   85: astore_0
    //   86: aconst_null
    //   87: astore_0
    //   88: aload_0
    //   89: ifnull +7 -> 96
    //   92: aload_0
    //   93: invokevirtual 640	java/io/FileInputStream:close	()V
    //   96: ldc2_w 618
    //   99: sipush 4521
    //   102: invokestatic 103	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   105: aconst_null
    //   106: areturn
    //   107: astore_0
    //   108: ldc_w 317
    //   111: aload_0
    //   112: ldc_w 432
    //   115: iconst_0
    //   116: anewarray 4	java/lang/Object
    //   119: invokestatic 644	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: goto -26 -> 96
    //   125: astore_1
    //   126: aconst_null
    //   127: astore_0
    //   128: aload_0
    //   129: ifnull +7 -> 136
    //   132: aload_0
    //   133: invokevirtual 640	java/io/FileInputStream:close	()V
    //   136: aload_1
    //   137: athrow
    //   138: astore_0
    //   139: ldc_w 317
    //   142: aload_0
    //   143: ldc_w 432
    //   146: iconst_0
    //   147: anewarray 4	java/lang/Object
    //   150: invokestatic 644	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: goto -17 -> 136
    //   156: astore_1
    //   157: goto -29 -> 128
    //   160: astore_1
    //   161: goto -73 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramString	String
    //   33	33	1	localObject1	Object
    //   125	12	1	localObject2	Object
    //   156	1	1	localObject3	Object
    //   160	1	1	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   52	56	67	java/lang/Exception
    //   18	27	85	java/io/IOException
    //   92	96	107	java/lang/Exception
    //   18	27	125	finally
    //   132	136	138	java/lang/Exception
    //   27	52	156	finally
    //   27	52	160	java/io/IOException
  }
  
  public static void setup()
  {
    GMTrace.i(606529912832L, 4519);
    if (aa.urm)
    {
      boolean bool = com.tencent.mm.loader.stub.b.deleteFile(hpf + "MMSQL.trace");
      v.i("MicroMsg.SQLTraceManager", "trace setup delete old file ret: " + bool);
    }
    GMTrace.o(606529912832L, 4519);
  }
  
  public final void AE()
  {
    GMTrace.i(608543178752L, 4534);
    v.i("MicroMsg.SQLTraceManager", "updateIntervalArg ");
    AH();
    GMTrace.o(608543178752L, 4534);
  }
  
  public final void a(File paramFile, boolean paramBoolean)
  {
    GMTrace.i(607603654656L, 4527);
    v.i("MicroMsg.SQLTraceManager", "build log file ,needRecreate %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramFile.exists())
    {
      if (!paramBoolean) {
        break label91;
      }
      paramFile.delete();
    }
    try
    {
      paramFile.createNewFile();
      Context localContext = aa.getContext();
      long l = System.currentTimeMillis();
      PreferenceManager.getDefaultSharedPreferences(localContext).edit().putLong("sql_trace_log_file_create_time", l).commit();
      d(aa.getContext(), 0L);
      label91:
      i(paramFile);
      GMTrace.o(607603654656L, 4527);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        v.e("MicroMsg.SQLTraceManager", "recreate log file fail");
      }
    }
  }
  
  public final void gG(String paramString)
  {
    GMTrace.i(607469436928L, 4526);
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    Intent localIntent = new Intent();
    localIntent.setClassName(aa.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorService");
    localIntent.setAction("uncatch_exception");
    localIntent.putExtra("exceptionPid", Process.myPid());
    String str2 = ao.hlE.A("login_weixin_username", "");
    paramString = str2;
    if (bf.mA(str2)) {
      paramString = ao.hlE.A("login_user_name", "never_login_crash");
    }
    localIntent.putExtra("userName", paramString);
    localIntent.putExtra("tag", "SqlTrace");
    localIntent.putExtra("exceptionMsg", Base64.encodeToString((AD() + str1).getBytes(), 2));
    aa.getContext().startService(localIntent);
    GMTrace.o(607469436928L, 4526);
  }
  
  void i(File paramFile)
  {
    boolean bool2 = true;
    GMTrace.i(606664130560L, 4520);
    if (paramFile.exists())
    {
      long l;
      if (paramFile.length() > this.hpn)
      {
        bool1 = true;
        this.hoL = bool1;
        if (!this.hoL) {
          break label122;
        }
        l = aP(aa.getContext());
        if (l == 0L) {
          break label112;
        }
      }
      label112:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        v.i("MicroMsg.SQLTraceManager", "has mark lastFullTime %b", new Object[] { Boolean.valueOf(bool1) });
        if (l == 0L) {
          d(aa.getContext(), System.currentTimeMillis());
        }
        GMTrace.o(606664130560L, 4520);
        return;
        bool1 = false;
        break;
      }
    }
    else
    {
      this.hoL = false;
    }
    label122:
    GMTrace.o(606664130560L, 4520);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */