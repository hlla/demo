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
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.StatFs;
import android.util.Base64;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.o;
import com.tencent.mm.ap.m;
import com.tencent.mm.ap.n;
import com.tencent.mm.ap.t;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ad.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ap;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public class a
  implements c.a
{
  private static final String fwB;
  private static final String fwC;
  public static String fwD;
  private static a hoG;
  static final String hoH;
  public static final String hoI;
  public static final long hoM;
  public static SimpleDateFormat sDateFormat;
  public SharedPreferences hgn;
  public long[] hoJ;
  public long hoK;
  public volatile boolean hoL;
  public long hoN;
  public long hoO;
  private long hoP;
  public long hoQ;
  public long hoR;
  private long hoS;
  public long hoT;
  public int hoU;
  public int hoV;
  public int hoW;
  public Long[] hoX;
  public long hoY;
  private String hoZ;
  public LinkedList<a> hpa;
  
  static
  {
    GMTrace.i(605724606464L, 4513);
    String str = p.rB();
    fwB = str;
    fwC = o.getString(str.hashCode());
    hoH = com.tencent.mm.compatible.util.e.hgi + "/tencent/MicroMsg/Handler/";
    hoI = hoH + "Handler.trace";
    hoM = Looper.getMainLooper().getThread().getId();
    sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
    fwD = "";
    GMTrace.o(605724606464L, 4513);
  }
  
  private a()
  {
    GMTrace.i(601295421440L, 4480);
    this.hoJ = new long[] { 0L, 0L, 0L };
    this.hoK = 0L;
    this.hoL = false;
    this.hoN = 8000L;
    this.hoO = 800L;
    this.hoP = 25600L;
    this.hoQ = 35840L;
    this.hoR = 86400000L;
    this.hoS = 180000L;
    this.hoT = 5000L;
    this.hoU = 120;
    this.hoV = 50;
    this.hoW = 1800000;
    this.hgn = aa.bIO();
    this.hoX = new Long[18];
    this.hoY = 0L;
    this.hoZ = "";
    this.hpa = new LinkedList();
    this.hoN = this.hgn.getLong("handler_debug_log_time", 8000L);
    this.hoO = this.hgn.getLong("handler_debug_log_time_main", 800L);
    this.hoP = this.hgn.getLong("handler_trace_file_full_size", 25600L);
    this.hoQ = this.hgn.getLong("handler_log_file_max_size", 35840L);
    this.hoR = this.hgn.getLong("handler_upload_time_interval", 86400000L);
    Arrays.fill(this.hoX, Long.valueOf(0L));
    GMTrace.o(601295421440L, 4480);
  }
  
  public static a AC()
  {
    GMTrace.i(601429639168L, 4481);
    if (hoG == null) {}
    try
    {
      if (hoG == null) {
        hoG = new a();
      }
      a locala = hoG;
      GMTrace.o(601429639168L, 4481);
      return locala;
    }
    finally {}
  }
  
  /* Error */
  public static String gF(String paramString)
  {
    // Byte code:
    //   0: ldc2_w 253
    //   3: sipush 4484
    //   6: invokestatic 66	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: new 256	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 257	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore_0
    //   18: new 259	java/io/FileInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 262	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   26: astore_0
    //   27: aload_0
    //   28: invokevirtual 265	java/io/FileInputStream:available	()I
    //   31: newarray <illegal type>
    //   33: astore_1
    //   34: aload_0
    //   35: aload_1
    //   36: invokevirtual 269	java/io/FileInputStream:read	([B)I
    //   39: pop
    //   40: new 76	java/lang/String
    //   43: dup
    //   44: aload_1
    //   45: invokestatic 275	com/tencent/mm/bl/e:bp	([B)[B
    //   48: invokespecial 278	java/lang/String:<init>	([B)V
    //   51: astore_1
    //   52: aload_0
    //   53: invokevirtual 281	java/io/FileInputStream:close	()V
    //   56: ldc2_w 253
    //   59: sipush 4484
    //   62: invokestatic 147	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   65: aload_1
    //   66: areturn
    //   67: astore_0
    //   68: aconst_null
    //   69: astore_0
    //   70: aload_0
    //   71: ifnull +7 -> 78
    //   74: aload_0
    //   75: invokevirtual 281	java/io/FileInputStream:close	()V
    //   78: ldc2_w 253
    //   81: sipush 4484
    //   84: invokestatic 147	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   87: aconst_null
    //   88: areturn
    //   89: astore_1
    //   90: aconst_null
    //   91: astore_0
    //   92: aload_0
    //   93: ifnull +7 -> 100
    //   96: aload_0
    //   97: invokevirtual 281	java/io/FileInputStream:close	()V
    //   100: aload_1
    //   101: athrow
    //   102: astore_0
    //   103: goto -47 -> 56
    //   106: astore_0
    //   107: goto -29 -> 78
    //   110: astore_0
    //   111: goto -11 -> 100
    //   114: astore_1
    //   115: goto -23 -> 92
    //   118: astore_1
    //   119: goto -49 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramString	String
    //   33	33	1	localObject1	Object
    //   89	12	1	localObject2	Object
    //   114	1	1	localObject3	Object
    //   118	1	1	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   18	27	67	java/io/IOException
    //   18	27	89	finally
    //   52	56	102	java/lang/Exception
    //   74	78	106	java/lang/Exception
    //   96	100	110	java/lang/Exception
    //   27	52	114	finally
    //   27	52	118	java/io/IOException
  }
  
  final String AD()
  {
    GMTrace.i(601698074624L, 4483);
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
      long l1 = this.hgn.getLong("handler_trace_log_file_full_time", 0L);
      long l2 = this.hgn.getLong("handler_trace_log_file_create_time", 0L);
      localPrintStream.println("#logfile.fulllast :" + (l1 - l2));
      if (this.hoJ[1] != -1L) {
        localPrintStream.println("#wxpackage :cache size=" + this.hoJ[0] + " data size=" + this.hoJ[1] + " code size=" + this.hoJ[2]);
      }
      localObject1 = t.Id().gl(21);
      if ((localObject1 == null) || (localObject1.length == 0) || (localObject1[0] == null))
      {
        localPrintStream.println("#traceconfig hardcode");
        localPrintStream.println("#handler.content:");
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
          GMTrace.o(601698074624L, 4483);
          return (String)localObject1;
          localException1 = localException1;
          v.e("MicroMsg.HandlerTraceManager", "summer check data size failed :%s", new Object[] { localException1.getMessage() });
          str = "";
        }
        localPrintStream.println("#traceconfig id=" + str[0].id + " version=" + str[0].version);
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
    }
  }
  
  public final void AE()
  {
    GMTrace.i(602100727808L, 4486);
    v.i("MicroMsg.HandlerTraceManager", "summerc onUpdateComplete");
    this.hoN = this.hgn.getLong("handler_debug_log_time", 8000L);
    this.hoO = this.hgn.getLong("handler_debug_log_time_main", 800L);
    this.hoP = this.hgn.getLong("handler_trace_file_full_size", 25600L);
    this.hoQ = this.hgn.getLong("handler_log_file_max_size", 35840L);
    this.hoR = this.hgn.getLong("handler_upload_time_interval", 86400000L);
    this.hoS = this.hgn.getLong("handler_worker_assert_time", 180000L);
    this.hoT = this.hgn.getLong("handler_worker_warn_time", 5000L);
    this.hoU = ((int)this.hgn.getLong("handler_worker_warn_task_max_size", 120L));
    this.hoV = ((int)this.hgn.getLong("handler_worker_warn_task_keep_size", 50L));
    this.hoW = ((int)this.hgn.getLong("handler_worker_warn_task_keep_size", 1800000L));
    i(new File(hoI));
    GMTrace.o(602100727808L, 4486);
  }
  
  public final void a(File paramFile, boolean paramBoolean)
  {
    GMTrace.i(601966510080L, 4485);
    v.i("MicroMsg.HandlerTraceManager", "build log file ,needRecreate %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramFile.exists())
    {
      if (!paramBoolean) {
        break label89;
      }
      paramFile.delete();
    }
    try
    {
      paramFile.createNewFile();
      SharedPreferences.Editor localEditor = this.hgn.edit();
      localEditor.putLong("handler_trace_log_file_create_time", System.currentTimeMillis());
      localEditor.putLong("handler_trace_log_file_full_time", 0L).commit();
      label89:
      i(paramFile);
      GMTrace.o(601966510080L, 4485);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        v.e("MicroMsg.HandlerTraceManager", "recreate log file fail");
      }
    }
  }
  
  void i(File paramFile)
  {
    boolean bool2 = true;
    GMTrace.i(601563856896L, 4482);
    if (paramFile.exists())
    {
      long l;
      if (paramFile.length() > this.hoP)
      {
        bool1 = true;
        this.hoL = bool1;
        if (!this.hoL) {
          break label146;
        }
        l = this.hgn.getLong("handler_trace_log_file_full_time", 0L);
        if (l == 0L) {
          break label136;
        }
      }
      label136:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        v.i("MicroMsg.HandlerTraceManager", "has mark lastFullTime %b", new Object[] { Boolean.valueOf(bool1) });
        if (l == 0L) {
          this.hgn.edit().putLong("handler_trace_log_file_full_time", System.currentTimeMillis()).commit();
        }
        GMTrace.o(601563856896L, 4482);
        return;
        bool1 = false;
        break;
      }
    }
    else
    {
      this.hoL = false;
    }
    label146:
    GMTrace.o(601563856896L, 4482);
  }
  
  static final class a
    implements Comparable<a>
  {
    long hpd;
    String info;
    
    a()
    {
      GMTrace.i(613911887872L, 4574);
      GMTrace.o(613911887872L, 4574);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */