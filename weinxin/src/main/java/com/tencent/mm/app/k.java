package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import android.content.Intent;
import android.os.ConditionVariable;
import android.os.FileObserver;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.d.x;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.l.v;
import com.tencent.mm.pluginsdk.l.y;
import com.tencent.mm.sdk.a.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.a.c;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.b;
import com.tencent.mm.sdk.platformtools.ah.c;
import com.tencent.mm.sdk.platformtools.ah.d;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.bu;
import com.tencent.recovery.Recovery;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.AssertionFailedError;

public class k
  implements c, ah.d
{
  private static final String fwB;
  private static final String fwC;
  private static String fwD;
  private static final String fwE;
  public static final long fwt;
  ConditionVariable fwA;
  volatile b fwF;
  private ah fwu;
  private a fwv;
  public volatile long fww;
  HashSet<String> fwx;
  String fwy;
  String fwz;
  
  static
  {
    GMTrace.i(12977109467136L, 96687);
    fwt = bf.NA();
    String str = p.rB();
    fwB = str;
    fwC = o.getString(str.hashCode());
    fwD = "";
    fwE = "version:" + com.tencent.mm.protocal.d.sXh;
    GMTrace.o(12977109467136L, 96687);
  }
  
  public k()
  {
    GMTrace.i(12974827765760L, 96670);
    this.fwu = null;
    this.fww = 0L;
    GMTrace.o(12974827765760L, 96670);
  }
  
  /* Error */
  static String a(String paramString, int paramInt, long paramLong, ActivityManager.ProcessErrorStateInfo paramProcessErrorStateInfo)
  {
    // Byte code:
    //   0: ldc2_w 126
    //   3: ldc -128
    //   5: invokestatic 50	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   8: new 86	java/lang/StringBuilder
    //   11: dup
    //   12: sipush 4096
    //   15: invokespecial 131	java/lang/StringBuilder:<init>	(I)V
    //   18: astore 9
    //   20: new 133	java/text/SimpleDateFormat
    //   23: dup
    //   24: ldc -121
    //   26: invokespecial 136	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   29: astore 10
    //   31: new 86	java/lang/StringBuilder
    //   34: dup
    //   35: ldc -118
    //   37: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: iload_1
    //   41: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: ldc -116
    //   46: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: astore 11
    //   54: aload 4
    //   56: ifnull +19 -> 75
    //   59: aload 9
    //   61: aload 4
    //   63: getfield 148	android/app/ActivityManager$ProcessErrorStateInfo:longMsg	Ljava/lang/String;
    //   66: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: bipush 10
    //   71: invokevirtual 151	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: new 153	java/io/BufferedReader
    //   78: dup
    //   79: new 155	java/io/FileReader
    //   82: dup
    //   83: aload_0
    //   84: invokespecial 156	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   87: invokespecial 159	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   90: astore 4
    //   92: iconst_0
    //   93: istore_1
    //   94: aload 4
    //   96: astore_0
    //   97: aload 4
    //   99: invokevirtual 162	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   102: astore 12
    //   104: aload 12
    //   106: ifnull +265 -> 371
    //   109: iload_1
    //   110: tableswitch	default:+317->427, 0:+26->136, 1:+99->209, 2:+165->275
    //   136: aload 4
    //   138: astore_0
    //   139: aload 12
    //   141: aload 11
    //   143: invokevirtual 166	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   146: ifeq -52 -> 94
    //   149: aload 4
    //   151: astore_0
    //   152: aload 11
    //   154: invokevirtual 169	java/lang/String:length	()I
    //   157: istore 5
    //   159: aload 4
    //   161: astore_0
    //   162: aload 10
    //   164: aload 12
    //   166: iload 5
    //   168: iload 5
    //   170: bipush 19
    //   172: iadd
    //   173: invokevirtual 173	java/lang/String:substring	(II)Ljava/lang/String;
    //   176: invokevirtual 177	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   179: invokevirtual 182	java/util/Date:getTime	()J
    //   182: lload_2
    //   183: lsub
    //   184: lstore 6
    //   186: lload 6
    //   188: ldc2_w 183
    //   191: lcmp
    //   192: iflt -98 -> 94
    //   195: lload 6
    //   197: ldc2_w 185
    //   200: lcmp
    //   201: ifgt -107 -> 94
    //   204: iconst_1
    //   205: istore_1
    //   206: goto -112 -> 94
    //   209: aload 4
    //   211: astore_0
    //   212: aload 9
    //   214: aload 12
    //   216: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: bipush 10
    //   221: invokevirtual 151	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload 4
    //   227: astore_0
    //   228: aload 12
    //   230: ldc -68
    //   232: invokevirtual 166	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   235: ifeq +8 -> 243
    //   238: iconst_2
    //   239: istore_1
    //   240: goto -146 -> 94
    //   243: aload 4
    //   245: astore_0
    //   246: aload 12
    //   248: ldc -66
    //   250: invokevirtual 166	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   253: istore 8
    //   255: iload 8
    //   257: ifeq -163 -> 94
    //   260: aload 4
    //   262: invokevirtual 193	java/io/BufferedReader:close	()V
    //   265: ldc2_w 126
    //   268: ldc -128
    //   270: invokestatic 110	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   273: aconst_null
    //   274: areturn
    //   275: aload 4
    //   277: astore_0
    //   278: aload 12
    //   280: ldc -61
    //   282: invokevirtual 166	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   285: ifeq +29 -> 314
    //   288: aload 4
    //   290: astore_0
    //   291: aload 9
    //   293: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: astore 9
    //   298: aload 4
    //   300: invokevirtual 193	java/io/BufferedReader:close	()V
    //   303: ldc2_w 126
    //   306: ldc -128
    //   308: invokestatic 110	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   311: aload 9
    //   313: areturn
    //   314: aload 4
    //   316: astore_0
    //   317: aload 9
    //   319: aload 12
    //   321: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: bipush 10
    //   326: invokevirtual 151	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: goto -236 -> 94
    //   333: astore 9
    //   335: aload 4
    //   337: astore_0
    //   338: ldc -59
    //   340: aload 9
    //   342: ldc -57
    //   344: iconst_0
    //   345: anewarray 4	java/lang/Object
    //   348: invokestatic 205	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   351: aload 4
    //   353: ifnull +8 -> 361
    //   356: aload 4
    //   358: invokevirtual 193	java/io/BufferedReader:close	()V
    //   361: ldc2_w 126
    //   364: ldc -128
    //   366: invokestatic 110	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   369: aconst_null
    //   370: areturn
    //   371: aload 4
    //   373: invokevirtual 193	java/io/BufferedReader:close	()V
    //   376: goto -15 -> 361
    //   379: astore_0
    //   380: goto -19 -> 361
    //   383: astore 4
    //   385: aconst_null
    //   386: astore_0
    //   387: aload_0
    //   388: ifnull +7 -> 395
    //   391: aload_0
    //   392: invokevirtual 193	java/io/BufferedReader:close	()V
    //   395: aload 4
    //   397: athrow
    //   398: astore_0
    //   399: goto -134 -> 265
    //   402: astore_0
    //   403: goto -100 -> 303
    //   406: astore_0
    //   407: goto -46 -> 361
    //   410: astore_0
    //   411: goto -16 -> 395
    //   414: astore 4
    //   416: goto -29 -> 387
    //   419: astore 9
    //   421: aconst_null
    //   422: astore 4
    //   424: goto -89 -> 335
    //   427: goto -333 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	430	0	paramString	String
    //   0	430	1	paramInt	int
    //   0	430	2	paramLong	long
    //   0	430	4	paramProcessErrorStateInfo	ActivityManager.ProcessErrorStateInfo
    //   157	16	5	i	int
    //   184	12	6	l	long
    //   253	3	8	bool	boolean
    //   18	300	9	localObject	Object
    //   333	8	9	localException1	Exception
    //   419	1	9	localException2	Exception
    //   29	134	10	localSimpleDateFormat	java.text.SimpleDateFormat
    //   52	101	11	str1	String
    //   102	218	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   97	104	333	java/lang/Exception
    //   139	149	333	java/lang/Exception
    //   152	159	333	java/lang/Exception
    //   162	186	333	java/lang/Exception
    //   212	225	333	java/lang/Exception
    //   228	238	333	java/lang/Exception
    //   246	255	333	java/lang/Exception
    //   278	288	333	java/lang/Exception
    //   291	298	333	java/lang/Exception
    //   317	330	333	java/lang/Exception
    //   371	376	379	java/io/IOException
    //   75	92	383	finally
    //   260	265	398	java/io/IOException
    //   298	303	402	java/io/IOException
    //   356	361	406	java/io/IOException
    //   391	395	410	java/io/IOException
    //   97	104	414	finally
    //   139	149	414	finally
    //   152	159	414	finally
    //   162	186	414	finally
    //   212	225	414	finally
    //   228	238	414	finally
    //   246	255	414	finally
    //   278	288	414	finally
    //   291	298	414	finally
    //   317	330	414	finally
    //   338	351	414	finally
    //   75	92	419	java/lang/Exception
  }
  
  private static void a(int paramInt, String paramString, boolean paramBoolean)
  {
    GMTrace.i(12976304160768L, 96681);
    StringBuilder localStringBuilder = null;
    Object localObject = localStringBuilder;
    if (paramInt == 6) {}
    try
    {
      String str = oq();
      localObject = localStringBuilder;
      if (str != null) {
        localObject = a(str, Process.myPid(), System.currentTimeMillis(), null);
      }
      localStringBuilder = new StringBuilder(1024);
      localStringBuilder.append("#[jin_crash]sig=").append(paramInt).append('\n');
      localStringBuilder.append("#crash.previous=").append(paramBoolean).append('\n');
      localStringBuilder.append(bk(""));
      localStringBuilder.append(paramString).append('\n');
      if (localObject != null)
      {
        localStringBuilder.append("******* ANR Trace *******\n");
        localStringBuilder.append((String)localObject);
      }
      paramString = localStringBuilder.toString();
      if (paramInt == 6) {}
      for (paramInt = 0;; paramInt = 8192)
      {
        b(paramString, paramInt, true);
        v.e("MicroMsg.MMCrashReporter", "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
        if (!paramBoolean) {
          v.appenderClose();
        }
        GMTrace.o(12976304160768L, 96681);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      v.printErrStackTrace("MicroMsg.MMCrashReporter", paramString, "Failed reporting JNI crash.", new Object[0]);
      GMTrace.o(12976304160768L, 96681);
    }
  }
  
  public static void a(ah.c paramc)
  {
    GMTrace.i(12975230418944L, 96673);
    ah.a(paramc);
    GMTrace.o(12975230418944L, 96673);
  }
  
  private static void b(String paramString, int paramInt, boolean paramBoolean)
  {
    GMTrace.i(12976035725312L, 96679);
    bj(paramString);
    g.oSF.a(11338, true, true, new Object[] { Integer.valueOf(2) });
    g.oSF.a(25L, 0L, 1L, true);
    Object localObject;
    Context localContext;
    String str;
    if (aa.um().endsWith(":push"))
    {
      g.oSF.a(25L, 2L, 1L, true);
      localObject = g.oSF;
      g.aXD();
      localObject = paramString;
      if (e.ae(aa.getContext()) == 1) {
        localObject = paramString.substring(0, e.af(aa.getContext()));
      }
      localContext = aa.getContext();
      str = aa.um();
      if (!paramBoolean) {
        break label325;
      }
    }
    label325:
    for (paramString = "jni";; paramString = "java")
    {
      e.d(localContext, str, paramString);
      paramString = (String)localObject;
      if (paramInt > 0)
      {
        paramString = (String)localObject;
        if (((String)localObject).length() > paramInt) {
          paramString = ((String)localObject).substring(0, paramInt);
        }
      }
      if (l.y.bCk() != null)
      {
        localObject = new Intent();
        ((Intent)localObject).setAction("uncatch_exception");
        ((Intent)localObject).putExtra("exceptionPid", Process.myPid());
        ((Intent)localObject).putExtra("exceptionTime", SystemClock.elapsedRealtime());
        ((Intent)localObject).putExtra("userName", op());
        ((Intent)localObject).putExtra("exceptionMsg", Base64.encodeToString(paramString.getBytes(), 2));
        l.y.bCk().l(aa.getContext(), (Intent)localObject);
      }
      GMTrace.o(12976035725312L, 96679);
      return;
      if (aa.um().endsWith(":tools"))
      {
        g.oSF.a(25L, 3L, 1L, true);
        break;
      }
      if (aa.um().endsWith(":exdevice"))
      {
        g.oSF.a(25L, 4L, 1L, true);
        break;
      }
      if (!aa.bIR()) {
        break;
      }
      g.oSF.a(25L, 1L, 1L, true);
      break;
    }
  }
  
  public static boolean bi(String paramString)
  {
    Object localObject = null;
    GMTrace.i(12975096201216L, 96672);
    fwD = paramString;
    if (l.y.bCk() == null) {}
    try
    {
      paramString = Class.forName("com.tencent.mm.plugin.sandbox.SubCoreSandBox");
    }
    catch (Exception localException)
    {
      try
      {
        Class localClass = Class.forName("com.tencent.mm.plugin.sandbox.SubCoreSandBox", true, aa.getContext().getClassLoader());
        localObject = localClass;
        v.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test1: " + paramString + " thisProcName: " + fwD);
        v.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test2: " + localObject + " thisProcName: " + fwD);
        paramString = com.tencent.mm.bb.d.es("sandbox", ".SubCoreSandBox");
        v.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass clz: " + paramString + " thisProcName: " + fwD);
        if (paramString == null) {}
      }
      catch (Exception localException)
      {
        try
        {
          for (;;)
          {
            paramString = (l.v)paramString.newInstance();
            l.y.a(paramString);
            v.i("MicroMsg.MMCrashReporter", "setup sanbox mgr:" + paramString + " thisProcName: " + fwD);
            try
            {
              paramString = (c)Class.forName("com.tencent.mm.crash.RDMCrashReporter").newInstance();
              paramString.ag(aa.getContext());
              ao.hlE.A("last_login_uin", fwC);
              b.a(paramString);
              new Object() {};
              GMTrace.o(12975096201216L, 96672);
              return true;
            }
            catch (Exception paramString)
            {
              v.w("MicroMsg.MMCrashReporter", "rdm crash reporter load failed");
              paramString = new k();
              paramString.ag(aa.getContext());
              b.a(paramString);
              paramString = x.get("ro.product.cpu.abi");
              if ((paramString != null) && (paramString.length() != 0) && ((paramString.equals("x86")) || (paramString.equals("x86-64")))) {
                break;
              }
              com.tencent.mm.compatible.util.k.b("wechatCrashForJni", k.class.getClassLoader());
              CrashMonitorForJni.setClientVersionMsg(fwE);
              bu.gt(com.tencent.mm.compatible.util.e.hgg);
              GMTrace.o(12975096201216L, 96672);
            }
            paramString = paramString;
            v.printErrStackTrace("MicroMsg.MMCrashReporter", paramString, "setup sanbox Failed printing stack trace1.", new Object[0]);
            paramString = null;
          }
          localException = localException;
          v.printErrStackTrace("MicroMsg.MMCrashReporter", localException, "setup sanbox Failed printing stack trace2.", new Object[0]);
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            v.printErrStackTrace("MicroMsg.MMCrashReporter", paramString, "", new Object[0]);
            v.w("MicroMsg.MMCrashReporter", "setup sanbox e type:%s, e msg:%s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
          }
        }
      }
    }
    return false;
  }
  
  private static void bj(String paramString)
  {
    GMTrace.i(12975364636672L, 96674);
    try
    {
      while (paramString.length() > 896)
      {
        int i = paramString.substring(0, 896).lastIndexOf("\n");
        if (-1 == i) {
          break;
        }
        v.e("MicroMsg.MMCrashReporter", paramString.substring(0, i));
        paramString = paramString.substring(i + 1);
      }
      v.e("MicroMsg.MMCrashReporter", paramString);
      GMTrace.o(12975364636672L, 96674);
      return;
    }
    catch (Exception paramString)
    {
      v.printErrStackTrace("MicroMsg.MMCrashReporter", paramString, "Failed printing stack trace.", new Object[0]);
      GMTrace.o(12975364636672L, 96674);
    }
  }
  
  /* Error */
  private static String bk(String paramString)
  {
    // Byte code:
    //   0: ldc2_w 545
    //   3: ldc_w 547
    //   6: invokestatic 50	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: new 86	java/lang/StringBuilder
    //   12: dup
    //   13: sipush 256
    //   16: invokespecial 131	java/lang/StringBuilder:<init>	(I)V
    //   19: astore 12
    //   21: new 549	android/util/StringBuilderPrinter
    //   24: dup
    //   25: aload 12
    //   27: invokespecial 552	android/util/StringBuilderPrinter:<init>	(Ljava/lang/StringBuilder;)V
    //   30: astore 13
    //   32: invokestatic 304	com/tencent/mm/sdk/platformtools/aa:getContext	()Landroid/content/Context;
    //   35: astore 11
    //   37: aload 13
    //   39: new 86	java/lang/StringBuilder
    //   42: dup
    //   43: ldc_w 554
    //   46: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   49: getstatic 98	com/tencent/mm/protocal/d:sXh	I
    //   52: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokevirtual 557	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   61: aload 13
    //   63: new 86	java/lang/StringBuilder
    //   66: dup
    //   67: ldc_w 559
    //   70: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   73: invokestatic 562	com/tencent/mm/u/bu:Ab	()Ljava/lang/String;
    //   76: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokevirtual 557	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   85: aload 13
    //   87: new 86	java/lang/StringBuilder
    //   90: dup
    //   91: ldc_w 564
    //   94: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   97: invokestatic 567	com/tencent/mm/compatible/d/p:rA	()Ljava/lang/String;
    //   100: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokevirtual 557	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   109: aload 13
    //   111: new 86	java/lang/StringBuilder
    //   114: dup
    //   115: ldc_w 569
    //   118: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   121: getstatic 574	com/tencent/mm/sdk/platformtools/e:REV	Ljava/lang/String;
    //   124: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokevirtual 557	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   133: aload 13
    //   135: new 86	java/lang/StringBuilder
    //   138: dup
    //   139: ldc_w 576
    //   142: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   145: getstatic 455	com/tencent/mm/u/ao:hlE	Lcom/tencent/mm/u/ao;
    //   148: ldc_w 457
    //   151: getstatic 80	com/tencent/mm/app/k:fwC	Ljava/lang/String;
    //   154: invokevirtual 461	com/tencent/mm/u/ao:A	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   157: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokevirtual 557	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   166: aload 13
    //   168: new 86	java/lang/StringBuilder
    //   171: dup
    //   172: ldc_w 578
    //   175: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   178: getstatic 66	com/tencent/mm/app/k:fwB	Ljava/lang/String;
    //   181: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokevirtual 557	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   190: aload 13
    //   192: new 86	java/lang/StringBuilder
    //   195: dup
    //   196: ldc_w 580
    //   199: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   202: invokestatic 56	com/tencent/mm/sdk/platformtools/bf:NA	()J
    //   205: getstatic 58	com/tencent/mm/app/k:fwt	J
    //   208: lsub
    //   209: invokevirtual 583	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   212: ldc_w 585
    //   215: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: getstatic 84	com/tencent/mm/app/k:fwD	Ljava/lang/String;
    //   221: invokestatic 588	com/tencent/mm/sdk/platformtools/bf:mz	(Ljava/lang/String;)Ljava/lang/String;
    //   224: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: ldc_w 590
    //   230: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokevirtual 557	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   239: aload 13
    //   241: new 86	java/lang/StringBuilder
    //   244: dup
    //   245: ldc_w 592
    //   248: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   251: getstatic 595	com/tencent/mm/sdk/platformtools/e:TIME	Ljava/lang/String;
    //   254: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: ldc_w 597
    //   260: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: getstatic 600	com/tencent/mm/sdk/platformtools/e:HOSTNAME	Ljava/lang/String;
    //   266: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: ldc_w 597
    //   272: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: getstatic 605	com/tencent/mm/sdk/platformtools/f:fuN	I
    //   278: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   281: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokevirtual 557	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   287: aload 13
    //   289: new 86	java/lang/StringBuilder
    //   292: dup
    //   293: ldc_w 607
    //   296: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   299: aload 11
    //   301: invokestatic 612	com/tencent/smtt/sdk/WebView:getTbsCoreVersion	(Landroid/content/Context;)I
    //   304: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   307: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokevirtual 557	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   313: aload 13
    //   315: new 86	java/lang/StringBuilder
    //   318: dup
    //   319: ldc_w 614
    //   322: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   325: aload 11
    //   327: invokestatic 617	com/tencent/smtt/sdk/WebView:getTbsSDKVersion	(Landroid/content/Context;)I
    //   330: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   333: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: invokevirtual 557	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   339: aload 13
    //   341: new 86	java/lang/StringBuilder
    //   344: dup
    //   345: ldc_w 619
    //   348: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   351: aload 11
    //   353: invokestatic 625	com/tencent/smtt/sdk/QbSdk:getMiniQBVersion	(Landroid/content/Context;)Ljava/lang/String;
    //   356: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokevirtual 557	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   365: getstatic 84	com/tencent/mm/app/k:fwD	Ljava/lang/String;
    //   368: ldc_w 378
    //   371: invokevirtual 629	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   374: ifne +15 -> 389
    //   377: getstatic 84	com/tencent/mm/app/k:fwD	Ljava/lang/String;
    //   380: ldc_w 631
    //   383: invokevirtual 629	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   386: ifeq +101 -> 487
    //   389: aload 11
    //   391: invokestatic 634	com/tencent/smtt/sdk/WebView:getCrashExtraMessage	(Landroid/content/Context;)Ljava/lang/String;
    //   394: astore 10
    //   396: aload 10
    //   398: ifnull +89 -> 487
    //   401: aload 10
    //   403: invokevirtual 169	java/lang/String:length	()I
    //   406: ifle +81 -> 487
    //   409: aload 10
    //   411: astore 9
    //   413: aload 10
    //   415: invokevirtual 169	java/lang/String:length	()I
    //   418: sipush 8192
    //   421: if_icmple +19 -> 440
    //   424: aload 10
    //   426: aload 10
    //   428: invokevirtual 169	java/lang/String:length	()I
    //   431: sipush 8192
    //   434: isub
    //   435: invokevirtual 542	java/lang/String:substring	(I)Ljava/lang/String;
    //   438: astore 9
    //   440: aload 13
    //   442: new 86	java/lang/StringBuilder
    //   445: dup
    //   446: ldc_w 636
    //   449: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   452: aload 9
    //   454: invokevirtual 364	java/lang/String:getBytes	()[B
    //   457: iconst_2
    //   458: invokestatic 370	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   461: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokevirtual 557	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   470: ldc -59
    //   472: ldc_w 638
    //   475: iconst_1
    //   476: anewarray 4	java/lang/Object
    //   479: dup
    //   480: iconst_0
    //   481: aload 9
    //   483: aastore
    //   484: invokestatic 641	com/tencent/mm/sdk/platformtools/v:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   487: new 86	java/lang/StringBuilder
    //   490: dup
    //   491: ldc_w 643
    //   494: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   497: astore 10
    //   499: getstatic 647	com/tencent/mm/sdk/a/b:foreground	Z
    //   502: ifeq +683 -> 1185
    //   505: ldc_w 649
    //   508: astore 9
    //   510: aload 13
    //   512: aload 10
    //   514: aload 9
    //   516: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: ldc_w 597
    //   522: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: invokestatic 655	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   528: invokevirtual 658	java/lang/Thread:getName	()Ljava/lang/String;
    //   531: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: ldc_w 597
    //   537: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: getstatic 661	com/tencent/mm/sdk/a/b:uqf	Ljava/lang/String;
    //   543: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: invokevirtual 557	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   552: invokestatic 667	android/os/Environment:getDataDirectory	()Ljava/io/File;
    //   555: astore 9
    //   557: new 669	android/os/StatFs
    //   560: dup
    //   561: aload 9
    //   563: invokevirtual 674	java/io/File:getPath	()Ljava/lang/String;
    //   566: invokespecial 675	android/os/StatFs:<init>	(Ljava/lang/String;)V
    //   569: astore 10
    //   571: new 669	android/os/StatFs
    //   574: dup
    //   575: getstatic 678	com/tencent/mm/compatible/util/e:hgi	Ljava/lang/String;
    //   578: invokespecial 675	android/os/StatFs:<init>	(Ljava/lang/String;)V
    //   581: astore 14
    //   583: ldc_w 680
    //   586: bipush 10
    //   588: anewarray 4	java/lang/Object
    //   591: dup
    //   592: iconst_0
    //   593: aload 11
    //   595: ldc_w 682
    //   598: invokevirtual 686	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   601: checkcast 688	android/app/ActivityManager
    //   604: invokevirtual 691	android/app/ActivityManager:getMemoryClass	()I
    //   607: invokestatic 277	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   610: aastore
    //   611: dup
    //   612: iconst_1
    //   613: aload 11
    //   615: ldc_w 682
    //   618: invokevirtual 686	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   621: checkcast 688	android/app/ActivityManager
    //   624: invokevirtual 694	android/app/ActivityManager:getLargeMemoryClass	()I
    //   627: invokestatic 277	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   630: aastore
    //   631: dup
    //   632: iconst_2
    //   633: aload 9
    //   635: invokevirtual 697	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   638: aastore
    //   639: dup
    //   640: iconst_3
    //   641: aload 10
    //   643: invokevirtual 700	android/os/StatFs:getBlockSize	()I
    //   646: invokestatic 277	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   649: aastore
    //   650: dup
    //   651: iconst_4
    //   652: aload 10
    //   654: invokevirtual 703	android/os/StatFs:getBlockCount	()I
    //   657: invokestatic 277	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   660: aastore
    //   661: dup
    //   662: iconst_5
    //   663: aload 10
    //   665: invokevirtual 706	android/os/StatFs:getAvailableBlocks	()I
    //   668: invokestatic 277	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   671: aastore
    //   672: dup
    //   673: bipush 6
    //   675: getstatic 678	com/tencent/mm/compatible/util/e:hgi	Ljava/lang/String;
    //   678: aastore
    //   679: dup
    //   680: bipush 7
    //   682: aload 14
    //   684: invokevirtual 700	android/os/StatFs:getBlockSize	()I
    //   687: invokestatic 277	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   690: aastore
    //   691: dup
    //   692: bipush 8
    //   694: aload 14
    //   696: invokevirtual 703	android/os/StatFs:getBlockCount	()I
    //   699: invokestatic 277	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   702: aastore
    //   703: dup
    //   704: bipush 9
    //   706: aload 14
    //   708: invokevirtual 706	android/os/StatFs:getAvailableBlocks	()I
    //   711: invokestatic 277	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   714: aastore
    //   715: invokestatic 710	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   718: astore 9
    //   720: aload 13
    //   722: new 86	java/lang/StringBuilder
    //   725: dup
    //   726: ldc_w 712
    //   729: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   732: aload 9
    //   734: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   740: invokevirtual 557	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   743: new 179	java/util/Date
    //   746: dup
    //   747: invokespecial 713	java/util/Date:<init>	()V
    //   750: astore 9
    //   752: new 133	java/text/SimpleDateFormat
    //   755: dup
    //   756: ldc_w 715
    //   759: invokestatic 721	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   762: invokespecial 724	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   765: astore 10
    //   767: aload 13
    //   769: new 86	java/lang/StringBuilder
    //   772: dup
    //   773: ldc_w 726
    //   776: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   779: aload 10
    //   781: aload 9
    //   783: invokevirtual 729	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   786: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   792: invokevirtual 557	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   795: invokestatic 304	com/tencent/mm/sdk/platformtools/aa:getContext	()Landroid/content/Context;
    //   798: ldc_w 682
    //   801: invokevirtual 686	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   804: checkcast 688	android/app/ActivityManager
    //   807: astore 14
    //   809: new 731	android/app/ActivityManager$MemoryInfo
    //   812: dup
    //   813: invokespecial 732	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   816: astore 15
    //   818: aload 14
    //   820: aload 15
    //   822: invokevirtual 736	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   825: lconst_0
    //   826: lstore 5
    //   828: bipush 16
    //   830: invokestatic 742	com/tencent/mm/compatible/util/d:eo	(I)Z
    //   833: ifeq +389 -> 1222
    //   836: aload 15
    //   838: getfield 745	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   841: lstore_3
    //   842: new 86	java/lang/StringBuilder
    //   845: dup
    //   846: invokespecial 746	java/lang/StringBuilder:<init>	()V
    //   849: ldc 82
    //   851: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: ldc_w 748
    //   857: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: lload_3
    //   861: invokevirtual 583	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   864: ldc_w 750
    //   867: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: aload 15
    //   872: getfield 753	android/app/ActivityManager$MemoryInfo:availMem	J
    //   875: invokevirtual 583	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   878: ldc_w 750
    //   881: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   884: aload 15
    //   886: getfield 756	android/app/ActivityManager$MemoryInfo:threshold	J
    //   889: invokevirtual 583	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   892: ldc_w 750
    //   895: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: aload 15
    //   900: getfield 759	android/app/ActivityManager$MemoryInfo:lowMemory	Z
    //   903: invokevirtual 231	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   906: ldc_w 761
    //   909: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   915: astore 9
    //   917: new 86	java/lang/StringBuilder
    //   920: dup
    //   921: invokespecial 746	java/lang/StringBuilder:<init>	()V
    //   924: aload 9
    //   926: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   929: ldc_w 763
    //   932: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   935: invokestatic 768	android/os/Debug:getNativeHeapSize	()J
    //   938: invokevirtual 583	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   941: ldc_w 750
    //   944: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: invokestatic 771	android/os/Debug:getNativeHeapAllocatedSize	()J
    //   950: invokevirtual 583	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   953: ldc_w 750
    //   956: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   959: invokestatic 774	android/os/Debug:getNativeHeapFreeSize	()J
    //   962: invokevirtual 583	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   965: ldc_w 761
    //   968: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   971: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   974: astore 9
    //   976: iconst_1
    //   977: newarray <illegal type>
    //   979: astore 10
    //   981: aload 10
    //   983: iconst_0
    //   984: invokestatic 217	android/os/Process:myPid	()I
    //   987: iastore
    //   988: aload 14
    //   990: aload 10
    //   992: invokevirtual 778	android/app/ActivityManager:getProcessMemoryInfo	([I)[Landroid/os/Debug$MemoryInfo;
    //   995: astore 11
    //   997: aload 11
    //   999: ifnull +440 -> 1439
    //   1002: aload 11
    //   1004: arraylength
    //   1005: ifle +434 -> 1439
    //   1008: aload 11
    //   1010: iconst_0
    //   1011: aaload
    //   1012: ifnull +427 -> 1439
    //   1015: aload 11
    //   1017: iconst_0
    //   1018: aaload
    //   1019: astore 11
    //   1021: new 86	java/lang/StringBuilder
    //   1024: dup
    //   1025: invokespecial 746	java/lang/StringBuilder:<init>	()V
    //   1028: aload 9
    //   1030: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1033: ldc_w 780
    //   1036: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: aload 10
    //   1041: iconst_0
    //   1042: iaload
    //   1043: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1046: ldc_w 782
    //   1049: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1052: aload 11
    //   1054: invokevirtual 787	android/os/Debug$MemoryInfo:getTotalPss	()I
    //   1057: bipush 10
    //   1059: ishl
    //   1060: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1063: ldc_w 750
    //   1066: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1069: aload 11
    //   1071: invokevirtual 790	android/os/Debug$MemoryInfo:getTotalPrivateDirty	()I
    //   1074: bipush 10
    //   1076: ishl
    //   1077: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1080: ldc_w 750
    //   1083: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1086: aload 11
    //   1088: invokevirtual 793	android/os/Debug$MemoryInfo:getTotalSharedDirty	()I
    //   1091: bipush 10
    //   1093: ishl
    //   1094: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1097: ldc_w 761
    //   1100: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1103: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1106: astore 9
    //   1108: aload 13
    //   1110: new 86	java/lang/StringBuilder
    //   1113: dup
    //   1114: ldc_w 795
    //   1117: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1120: aload 9
    //   1122: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1125: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1128: invokevirtual 557	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   1131: aload_0
    //   1132: invokestatic 798	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   1135: ifne +25 -> 1160
    //   1138: aload 13
    //   1140: new 86	java/lang/StringBuilder
    //   1143: dup
    //   1144: ldc_w 800
    //   1147: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1150: aload_0
    //   1151: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1157: invokevirtual 557	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   1160: aload 13
    //   1162: ldc_w 802
    //   1165: invokevirtual 557	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
    //   1168: aload 12
    //   1170: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1173: astore_0
    //   1174: ldc2_w 545
    //   1177: ldc_w 547
    //   1180: invokestatic 110	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   1183: aload_0
    //   1184: areturn
    //   1185: ldc_w 803
    //   1188: astore 9
    //   1190: goto -680 -> 510
    //   1193: astore 9
    //   1195: ldc -59
    //   1197: ldc_w 805
    //   1200: iconst_1
    //   1201: anewarray 4	java/lang/Object
    //   1204: dup
    //   1205: iconst_0
    //   1206: aload 9
    //   1208: invokevirtual 483	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1211: aastore
    //   1212: invokestatic 807	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1215: ldc 82
    //   1217: astore 9
    //   1219: goto -499 -> 720
    //   1222: new 809	java/io/RandomAccessFile
    //   1225: dup
    //   1226: ldc_w 811
    //   1229: ldc_w 813
    //   1232: invokespecial 815	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1235: astore 10
    //   1237: aload 10
    //   1239: astore 9
    //   1241: new 817	java/lang/StringBuffer
    //   1244: dup
    //   1245: invokespecial 818	java/lang/StringBuffer:<init>	()V
    //   1248: astore 11
    //   1250: aload 10
    //   1252: astore 9
    //   1254: aload 10
    //   1256: invokevirtual 819	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   1259: invokevirtual 823	java/lang/String:toCharArray	()[C
    //   1262: astore 16
    //   1264: aload 10
    //   1266: astore 9
    //   1268: aload 16
    //   1270: arraylength
    //   1271: istore_2
    //   1272: iconst_0
    //   1273: istore_1
    //   1274: iload_1
    //   1275: iload_2
    //   1276: if_icmpge +38 -> 1314
    //   1279: aload 16
    //   1281: iload_1
    //   1282: caload
    //   1283: bipush 57
    //   1285: if_icmpgt +157 -> 1442
    //   1288: aload 16
    //   1290: iload_1
    //   1291: caload
    //   1292: bipush 48
    //   1294: if_icmplt +148 -> 1442
    //   1297: aload 10
    //   1299: astore 9
    //   1301: aload 11
    //   1303: aload 16
    //   1305: iload_1
    //   1306: caload
    //   1307: invokevirtual 826	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   1310: pop
    //   1311: goto +131 -> 1442
    //   1314: aload 10
    //   1316: astore 9
    //   1318: aload 11
    //   1320: invokevirtual 827	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1323: ldc2_w 828
    //   1326: invokestatic 833	com/tencent/mm/sdk/platformtools/bf:getLong	(Ljava/lang/String;J)J
    //   1329: lstore 7
    //   1331: lload 5
    //   1333: lstore_3
    //   1334: lload 7
    //   1336: lconst_0
    //   1337: lcmp
    //   1338: ifle +9 -> 1347
    //   1341: lload 7
    //   1343: bipush 10
    //   1345: lshl
    //   1346: lstore_3
    //   1347: aload 10
    //   1349: invokevirtual 834	java/io/RandomAccessFile:close	()V
    //   1352: goto -510 -> 842
    //   1355: astore 9
    //   1357: goto -515 -> 842
    //   1360: astore 11
    //   1362: aconst_null
    //   1363: astore 10
    //   1365: aload 10
    //   1367: astore 9
    //   1369: ldc -59
    //   1371: aload 11
    //   1373: ldc 82
    //   1375: iconst_0
    //   1376: anewarray 4	java/lang/Object
    //   1379: invokestatic 205	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1382: lload 5
    //   1384: lstore_3
    //   1385: aload 10
    //   1387: ifnull -545 -> 842
    //   1390: aload 10
    //   1392: invokevirtual 834	java/io/RandomAccessFile:close	()V
    //   1395: lload 5
    //   1397: lstore_3
    //   1398: goto -556 -> 842
    //   1401: astore 9
    //   1403: lload 5
    //   1405: lstore_3
    //   1406: goto -564 -> 842
    //   1409: astore_0
    //   1410: aconst_null
    //   1411: astore 9
    //   1413: aload 9
    //   1415: ifnull +8 -> 1423
    //   1418: aload 9
    //   1420: invokevirtual 834	java/io/RandomAccessFile:close	()V
    //   1423: aload_0
    //   1424: athrow
    //   1425: astore 9
    //   1427: goto -4 -> 1423
    //   1430: astore_0
    //   1431: goto -18 -> 1413
    //   1434: astore 11
    //   1436: goto -71 -> 1365
    //   1439: goto -331 -> 1108
    //   1442: iload_1
    //   1443: iconst_1
    //   1444: iadd
    //   1445: istore_1
    //   1446: goto -172 -> 1274
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1449	0	paramString	String
    //   1273	173	1	i	int
    //   1271	6	2	j	int
    //   841	565	3	l1	long
    //   826	578	5	l2	long
    //   1329	13	7	l3	long
    //   411	778	9	localObject1	Object
    //   1193	14	9	localException1	Exception
    //   1217	100	9	localObject2	Object
    //   1355	1	9	localException2	Exception
    //   1367	1	9	localObject3	Object
    //   1401	1	9	localException3	Exception
    //   1411	8	9	localObject4	Object
    //   1425	1	9	localException4	Exception
    //   394	997	10	localObject5	Object
    //   35	1284	11	localObject6	Object
    //   1360	12	11	localException5	Exception
    //   1434	1	11	localException6	Exception
    //   19	1150	12	localStringBuilder	StringBuilder
    //   30	1131	13	localStringBuilderPrinter	android.util.StringBuilderPrinter
    //   581	408	14	localObject7	Object
    //   816	83	15	localMemoryInfo	android.app.ActivityManager.MemoryInfo
    //   1262	42	16	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   552	720	1193	java/lang/Exception
    //   1347	1352	1355	java/lang/Exception
    //   1222	1237	1360	java/lang/Exception
    //   1390	1395	1401	java/lang/Exception
    //   1222	1237	1409	finally
    //   1418	1423	1425	java/lang/Exception
    //   1241	1250	1430	finally
    //   1254	1264	1430	finally
    //   1268	1272	1430	finally
    //   1301	1311	1430	finally
    //   1318	1331	1430	finally
    //   1369	1382	1430	finally
    //   1241	1250	1434	java/lang/Exception
    //   1254	1264	1434	java/lang/Exception
    //   1268	1272	1434	java/lang/Exception
    //   1301	1311	1434	java/lang/Exception
    //   1318	1331	1434	java/lang/Exception
  }
  
  private static String op()
  {
    GMTrace.i(12974961983488L, 96671);
    String str2 = ao.hlE.A("login_weixin_username", "");
    String str1 = str2;
    if (bf.mA(str2)) {
      str1 = ao.hlE.A("login_user_name", "never_login_crash");
    }
    GMTrace.o(12974961983488L, 96671);
    return str1;
  }
  
  private static String oq()
  {
    GMTrace.i(12976438378496L, 96682);
    try
    {
      localObject2 = x.get("dalvik.vm.stack-trace-file");
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() != 0) {}
      }
      else
      {
        localObject1 = "/data/anr/traces.txt";
      }
    }
    catch (Exception localException)
    {
      String str1;
      for (;;)
      {
        Object localObject2;
        Object localObject1;
        int i;
        String str2;
        v.printErrStackTrace("MicroMsg.MMCrashReporter", localException, "Failed finding out ANR trace file path, using default.", new Object[0]);
        str1 = "/data/anr/traces.txt";
      }
      if (!new File(str1).isFile()) {
        break label174;
      }
      GMTrace.o(12976438378496L, 96682);
      return str1;
      GMTrace.o(12976438378496L, 96682);
    }
    i = ((String)localObject1).lastIndexOf('.');
    if (i != -1)
    {
      str2 = aa.um();
      if (str2 != null)
      {
        localObject2 = str2;
        if (str2.length() != 0) {}
      }
      else
      {
        localObject2 = "com.tencent.mm";
      }
      localObject2 = ((String)localObject1).substring(0, i) + '_' + (String)localObject2 + ((String)localObject1).substring(i);
      if (new File((String)localObject2).isFile())
      {
        GMTrace.o(12976438378496L, 96682);
        return (String)localObject2;
      }
    }
    label174:
    return null;
  }
  
  public final void a(a parama)
  {
    GMTrace.i(12975767289856L, 96677);
    ah.a(parama);
    GMTrace.o(12975767289856L, 96677);
  }
  
  public final void a(ah paramah, String paramString, Throwable paramThrowable)
  {
    GMTrace.i(12975901507584L, 96678);
    if ((paramThrowable instanceof AssertionFailedError))
    {
      String str1 = paramThrowable.getMessage();
      if (!bf.mA(str1))
      {
        paramah = paramah.urF.entrySet().iterator();
        while ((paramah != null) && (paramah.hasNext()))
        {
          Map.Entry localEntry = (Map.Entry)paramah.next();
          String str2 = (String)localEntry.getKey();
          if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && (str1.startsWith(str2)))
          {
            paramah = ((ah.b)localEntry.getValue()).AF();
            if (bf.mA(paramah)) {
              break label176;
            }
          }
        }
      }
    }
    for (;;)
    {
      n.c(paramThrowable);
      b(bk(paramah) + paramString, 0, false);
      GMTrace.o(12975901507584L, 96678);
      return;
      paramah = "";
      break;
      label176:
      paramah = "";
    }
  }
  
  /* Error */
  public final void ag(final Context paramContext)
  {
    // Byte code:
    //   0: ldc2_w 925
    //   3: ldc_w 927
    //   6: invokestatic 50	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: aload_0
    //   10: invokestatic 930	com/tencent/mm/sdk/platformtools/ah:a	(Lcom/tencent/mm/sdk/platformtools/ah$d;)V
    //   13: getstatic 84	com/tencent/mm/app/k:fwD	Ljava/lang/String;
    //   16: ldc_w 292
    //   19: invokevirtual 295	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   22: ifeq +548 -> 570
    //   25: ldc_w 848
    //   28: invokestatic 500	com/tencent/mm/compatible/d/x:get	(Ljava/lang/String;)Ljava/lang/String;
    //   31: astore 7
    //   33: aload 7
    //   35: ifnull +15 -> 50
    //   38: aload 7
    //   40: astore 6
    //   42: aload 7
    //   44: invokevirtual 169	java/lang/String:length	()I
    //   47: ifne +8 -> 55
    //   50: ldc_w 850
    //   53: astore 6
    //   55: new 671	java/io/File
    //   58: dup
    //   59: aload 6
    //   61: invokespecial 856	java/io/File:<init>	(Ljava/lang/String;)V
    //   64: astore 7
    //   66: aload_0
    //   67: aload 7
    //   69: invokevirtual 933	java/io/File:getParent	()Ljava/lang/String;
    //   72: putfield 935	com/tencent/mm/app/k:fwy	Ljava/lang/String;
    //   75: aload_0
    //   76: getfield 935	com/tencent/mm/app/k:fwy	Ljava/lang/String;
    //   79: ifnull +13 -> 92
    //   82: aload_0
    //   83: getfield 935	com/tencent/mm/app/k:fwy	Ljava/lang/String;
    //   86: invokevirtual 169	java/lang/String:length	()I
    //   89: ifne +10 -> 99
    //   92: aload_0
    //   93: ldc_w 937
    //   96: putfield 935	com/tencent/mm/app/k:fwy	Ljava/lang/String;
    //   99: aload_0
    //   100: aload 7
    //   102: invokevirtual 938	java/io/File:getName	()Ljava/lang/String;
    //   105: putfield 940	com/tencent/mm/app/k:fwz	Ljava/lang/String;
    //   108: aload_0
    //   109: new 942	android/os/ConditionVariable
    //   112: dup
    //   113: invokespecial 943	android/os/ConditionVariable:<init>	()V
    //   116: putfield 945	com/tencent/mm/app/k:fwA	Landroid/os/ConditionVariable;
    //   119: ldc -59
    //   121: new 86	java/lang/StringBuilder
    //   124: dup
    //   125: ldc_w 947
    //   128: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   131: aload 6
    //   133: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 420	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload_0
    //   143: new 949	java/util/HashSet
    //   146: dup
    //   147: invokespecial 950	java/util/HashSet:<init>	()V
    //   150: putfield 952	com/tencent/mm/app/k:fwx	Ljava/util/HashSet;
    //   153: aload_0
    //   154: new 14	com/tencent/mm/app/k$a
    //   157: dup
    //   158: aload_0
    //   159: aload_0
    //   160: getfield 935	com/tencent/mm/app/k:fwy	Ljava/lang/String;
    //   163: invokespecial 955	com/tencent/mm/app/k$a:<init>	(Lcom/tencent/mm/app/k;Ljava/lang/String;)V
    //   166: putfield 957	com/tencent/mm/app/k:fwv	Lcom/tencent/mm/app/k$a;
    //   169: aload_0
    //   170: getfield 957	com/tencent/mm/app/k:fwv	Lcom/tencent/mm/app/k$a;
    //   173: invokevirtual 960	com/tencent/mm/app/k$a:startWatching	()V
    //   176: new 671	java/io/File
    //   179: dup
    //   180: aload_1
    //   181: invokevirtual 963	android/content/Context:getFilesDir	()Ljava/io/File;
    //   184: ldc_w 965
    //   187: invokespecial 968	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   190: new 12	com/tencent/mm/app/k$2
    //   193: dup
    //   194: aload_0
    //   195: aload_1
    //   196: invokespecial 971	com/tencent/mm/app/k$2:<init>	(Lcom/tencent/mm/app/k;Landroid/content/Context;)V
    //   199: invokevirtual 975	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   202: astore 8
    //   204: aload 8
    //   206: ifnull +364 -> 570
    //   209: new 86	java/lang/StringBuilder
    //   212: dup
    //   213: sipush 16384
    //   216: invokespecial 131	java/lang/StringBuilder:<init>	(I)V
    //   219: astore 9
    //   221: ldc_w 977
    //   224: invokestatic 983	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   227: astore 10
    //   229: aload 8
    //   231: arraylength
    //   232: istore 5
    //   234: iconst_0
    //   235: istore_2
    //   236: iload_2
    //   237: iload 5
    //   239: if_icmpge +331 -> 570
    //   242: aload 8
    //   244: iload_2
    //   245: aaload
    //   246: astore 11
    //   248: iconst_m1
    //   249: istore_3
    //   250: ldc -59
    //   252: new 86	java/lang/StringBuilder
    //   255: dup
    //   256: ldc_w 985
    //   259: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   262: aload 11
    //   264: invokevirtual 416	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 420	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: new 153	java/io/BufferedReader
    //   276: dup
    //   277: new 155	java/io/FileReader
    //   280: dup
    //   281: aload 11
    //   283: invokespecial 988	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   286: invokespecial 159	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   289: astore 6
    //   291: aload 6
    //   293: astore_1
    //   294: aload 9
    //   296: iconst_0
    //   297: invokevirtual 991	java/lang/StringBuilder:setLength	(I)V
    //   300: aload 6
    //   302: astore_1
    //   303: aload 6
    //   305: invokevirtual 162	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   308: astore 7
    //   310: aload 7
    //   312: ifnull +154 -> 466
    //   315: iload_3
    //   316: istore 4
    //   318: iload_3
    //   319: ifge +44 -> 363
    //   322: aload 6
    //   324: astore_1
    //   325: aload 10
    //   327: aload 7
    //   329: invokevirtual 995	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   332: astore 12
    //   334: iload_3
    //   335: istore 4
    //   337: aload 6
    //   339: astore_1
    //   340: aload 12
    //   342: invokevirtual 1000	java/util/regex/Matcher:matches	()Z
    //   345: ifeq +18 -> 363
    //   348: aload 6
    //   350: astore_1
    //   351: aload 12
    //   353: iconst_1
    //   354: invokevirtual 1003	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   357: iconst_0
    //   358: invokestatic 1007	com/tencent/mm/sdk/platformtools/bf:getInt	(Ljava/lang/String;I)I
    //   361: istore 4
    //   363: aload 6
    //   365: astore_1
    //   366: aload 9
    //   368: aload 7
    //   370: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: bipush 10
    //   375: invokevirtual 151	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: iload 4
    //   381: istore_3
    //   382: goto -82 -> 300
    //   385: astore 7
    //   387: aload 6
    //   389: astore_1
    //   390: ldc -59
    //   392: aload 7
    //   394: new 86	java/lang/StringBuilder
    //   397: dup
    //   398: ldc_w 1009
    //   401: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   404: aload 11
    //   406: invokevirtual 416	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   409: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: iconst_0
    //   413: anewarray 4	java/lang/Object
    //   416: invokestatic 205	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   419: aload 6
    //   421: ifnull +8 -> 429
    //   424: aload 6
    //   426: invokevirtual 193	java/io/BufferedReader:close	()V
    //   429: aload 11
    //   431: invokevirtual 1012	java/io/File:delete	()Z
    //   434: pop
    //   435: iload_2
    //   436: iconst_1
    //   437: iadd
    //   438: istore_2
    //   439: goto -203 -> 236
    //   442: astore 6
    //   444: ldc -59
    //   446: aload 6
    //   448: ldc_w 861
    //   451: iconst_0
    //   452: anewarray 4	java/lang/Object
    //   455: invokestatic 205	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   458: ldc_w 850
    //   461: astore 6
    //   463: goto -408 -> 55
    //   466: aload 6
    //   468: astore_1
    //   469: aload 9
    //   471: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: getstatic 107	com/tencent/mm/app/k:fwE	Ljava/lang/String;
    //   477: invokevirtual 166	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   480: ifeq +63 -> 543
    //   483: aload 6
    //   485: astore_1
    //   486: aload 9
    //   488: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: aload 9
    //   493: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: getstatic 107	com/tencent/mm/app/k:fwE	Ljava/lang/String;
    //   499: invokevirtual 1015	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   502: getstatic 107	com/tencent/mm/app/k:fwE	Ljava/lang/String;
    //   505: invokevirtual 169	java/lang/String:length	()I
    //   508: iadd
    //   509: invokevirtual 542	java/lang/String:substring	(I)Ljava/lang/String;
    //   512: astore 7
    //   514: aload 7
    //   516: ifnull +27 -> 543
    //   519: aload 6
    //   521: astore_1
    //   522: aload 7
    //   524: invokevirtual 1018	java/lang/String:trim	()Ljava/lang/String;
    //   527: invokevirtual 169	java/lang/String:length	()I
    //   530: ifle +13 -> 543
    //   533: aload 6
    //   535: astore_1
    //   536: iload_3
    //   537: aload 7
    //   539: iconst_1
    //   540: invokestatic 1020	com/tencent/mm/app/k:a	(ILjava/lang/String;Z)V
    //   543: aload 6
    //   545: invokevirtual 193	java/io/BufferedReader:close	()V
    //   548: goto -119 -> 429
    //   551: astore_1
    //   552: goto -123 -> 429
    //   555: astore 6
    //   557: aconst_null
    //   558: astore_1
    //   559: aload_1
    //   560: ifnull +7 -> 567
    //   563: aload_1
    //   564: invokevirtual 193	java/io/BufferedReader:close	()V
    //   567: aload 6
    //   569: athrow
    //   570: ldc2_w 925
    //   573: ldc_w 927
    //   576: invokestatic 110	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   579: return
    //   580: astore_1
    //   581: goto -152 -> 429
    //   584: astore_1
    //   585: goto -18 -> 567
    //   588: astore 6
    //   590: goto -31 -> 559
    //   593: astore 7
    //   595: aconst_null
    //   596: astore 6
    //   598: goto -211 -> 387
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	601	0	this	k
    //   0	601	1	paramContext	Context
    //   235	204	2	i	int
    //   249	288	3	j	int
    //   316	64	4	k	int
    //   232	8	5	m	int
    //   40	385	6	localObject1	Object
    //   442	5	6	localException	Exception
    //   461	83	6	str1	String
    //   555	13	6	localObject2	Object
    //   588	1	6	localObject3	Object
    //   596	1	6	localObject4	Object
    //   31	338	7	localObject5	Object
    //   385	8	7	localIOException1	java.io.IOException
    //   512	26	7	str2	String
    //   593	1	7	localIOException2	java.io.IOException
    //   202	41	8	arrayOfFile	File[]
    //   219	273	9	localStringBuilder	StringBuilder
    //   227	99	10	localPattern	java.util.regex.Pattern
    //   246	184	11	localFile	File
    //   332	20	12	localMatcher	java.util.regex.Matcher
    // Exception table:
    //   from	to	target	type
    //   294	300	385	java/io/IOException
    //   303	310	385	java/io/IOException
    //   325	334	385	java/io/IOException
    //   340	348	385	java/io/IOException
    //   351	363	385	java/io/IOException
    //   366	379	385	java/io/IOException
    //   469	483	385	java/io/IOException
    //   486	514	385	java/io/IOException
    //   522	533	385	java/io/IOException
    //   536	543	385	java/io/IOException
    //   25	33	442	java/lang/Exception
    //   42	50	442	java/lang/Exception
    //   543	548	551	java/io/IOException
    //   273	291	555	finally
    //   424	429	580	java/io/IOException
    //   563	567	584	java/io/IOException
    //   294	300	588	finally
    //   303	310	588	finally
    //   325	334	588	finally
    //   340	348	588	finally
    //   351	363	588	finally
    //   366	379	588	finally
    //   390	419	588	finally
    //   469	483	588	finally
    //   486	514	588	finally
    //   522	533	588	finally
    //   536	543	588	finally
    //   273	291	593	java/io/IOException
  }
  
  public final void h(int paramInt, String paramString)
  {
    GMTrace.i(12976169943040L, 96680);
    a(paramInt, paramString, false);
    GMTrace.o(12976169943040L, 96680);
  }
  
  final void h(String paramString, int paramInt)
  {
    GMTrace.i(12976706813952L, 96684);
    Recovery.cdk();
    g.oSF.a(11339, true, true, new Object[] { Integer.valueOf(5000), Integer.valueOf(0) });
    g.oSF.a(26L, 0L, 1L, true);
    bj(paramString);
    Object localObject = g.oSF;
    g.aXD();
    long l = System.currentTimeMillis();
    if (l - this.fww < 120000L)
    {
      GMTrace.o(12976706813952L, 96684);
      return;
    }
    this.fww = l;
    e.d(aa.getContext(), aa.um(), "anr");
    localObject = new StringBuilder(4096);
    ((StringBuilder)localObject).append(bk(""));
    ((StringBuilder)localObject).append("******* ANR Trace *******\n");
    ((StringBuilder)localObject).append(paramString);
    if (l.y.bCk() != null)
    {
      paramString = new Intent();
      paramString.setAction("uncatch_exception");
      paramString.putExtra("tag", "anr");
      paramString.putExtra("exceptionPid", paramInt);
      paramString.putExtra("exceptionTime", SystemClock.elapsedRealtime());
      paramString.putExtra("userName", ao.hlE.A("login_user_name", "never_login_crash"));
      paramString.putExtra("exceptionMsg", Base64.encodeToString(((StringBuilder)localObject).toString().getBytes(), 2));
      l.y.bCk().l(aa.getContext(), paramString);
    }
    GMTrace.o(12976706813952L, 96684);
  }
  
  public final void r(String paramString1, String paramString2)
  {
    GMTrace.i(12975633072128L, 96676);
    if (l.y.bCk() != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("custom_exception");
      localIntent.putExtra("userName", op());
      localIntent.putExtra("tag", paramString2);
      localIntent.putExtra("exceptionMsg", paramString1);
      l.y.bCk().l(aa.getContext(), localIntent);
    }
    GMTrace.o(12975633072128L, 96676);
  }
  
  private final class a
    extends FileObserver
  {
    a(String paramString)
    {
      super(712);
      GMTrace.i(12961674428416L, 96572);
      GMTrace.o(12961674428416L, 96572);
    }
    
    /* Error */
    public final void onEvent(int paramInt, String paramString)
    {
      // Byte code:
      //   0: ldc2_w 32
      //   3: ldc 34
      //   5: invokestatic 25	com/tencent/gmtrace/GMTrace:i	(JI)V
      //   8: invokestatic 40	java/lang/System:currentTimeMillis	()J
      //   11: aload_0
      //   12: getfield 13	com/tencent/mm/app/k$a:fwH	Lcom/tencent/mm/app/k;
      //   15: getfield 44	com/tencent/mm/app/k:fww	J
      //   18: lsub
      //   19: ldc2_w 45
      //   22: lcmp
      //   23: ifge +18 -> 41
      //   26: iconst_1
      //   27: istore_3
      //   28: iload_3
      //   29: ifeq +17 -> 46
      //   32: ldc2_w 32
      //   35: ldc 34
      //   37: invokestatic 28	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   40: return
      //   41: iconst_0
      //   42: istore_3
      //   43: goto -15 -> 28
      //   46: aload_0
      //   47: getfield 13	com/tencent/mm/app/k$a:fwH	Lcom/tencent/mm/app/k;
      //   50: getfield 50	com/tencent/mm/app/k:fwx	Ljava/util/HashSet;
      //   53: astore 4
      //   55: aload 4
      //   57: monitorenter
      //   58: iload_1
      //   59: lookupswitch	default:+41->100, 8:+53->112, 64:+145->204, 128:+124->183, 512:+145->204
      //   100: aload 4
      //   102: monitorexit
      //   103: ldc2_w 32
      //   106: ldc 34
      //   108: invokestatic 28	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   111: return
      //   112: ldc 52
      //   114: new 54	java/lang/StringBuilder
      //   117: dup
      //   118: ldc 56
      //   120: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   123: aload_2
      //   124: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   127: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   130: invokestatic 72	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   133: aload_0
      //   134: getfield 13	com/tencent/mm/app/k$a:fwH	Lcom/tencent/mm/app/k;
      //   137: getfield 76	com/tencent/mm/app/k:fwA	Landroid/os/ConditionVariable;
      //   140: invokevirtual 82	android/os/ConditionVariable:open	()V
      //   143: aload_0
      //   144: getfield 13	com/tencent/mm/app/k$a:fwH	Lcom/tencent/mm/app/k;
      //   147: getfield 86	com/tencent/mm/app/k:fwF	Lcom/tencent/mm/app/k$b;
      //   150: ifnonnull +33 -> 183
      //   153: aload_0
      //   154: getfield 13	com/tencent/mm/app/k$a:fwH	Lcom/tencent/mm/app/k;
      //   157: new 88	com/tencent/mm/app/k$b
      //   160: dup
      //   161: aload_0
      //   162: getfield 13	com/tencent/mm/app/k$a:fwH	Lcom/tencent/mm/app/k;
      //   165: invokespecial 91	com/tencent/mm/app/k$b:<init>	(Lcom/tencent/mm/app/k;)V
      //   168: putfield 86	com/tencent/mm/app/k:fwF	Lcom/tencent/mm/app/k$b;
      //   171: aload_0
      //   172: getfield 13	com/tencent/mm/app/k$a:fwH	Lcom/tencent/mm/app/k;
      //   175: getfield 86	com/tencent/mm/app/k:fwF	Lcom/tencent/mm/app/k$b;
      //   178: ldc 93
      //   180: invokestatic 99	com/tencent/mm/sdk/f/e:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
      //   183: aload_0
      //   184: getfield 13	com/tencent/mm/app/k$a:fwH	Lcom/tencent/mm/app/k;
      //   187: getfield 50	com/tencent/mm/app/k:fwx	Ljava/util/HashSet;
      //   190: aload_2
      //   191: invokevirtual 105	java/util/HashSet:add	(Ljava/lang/Object;)Z
      //   194: pop
      //   195: goto -95 -> 100
      //   198: astore_2
      //   199: aload 4
      //   201: monitorexit
      //   202: aload_2
      //   203: athrow
      //   204: aload_0
      //   205: getfield 13	com/tencent/mm/app/k$a:fwH	Lcom/tencent/mm/app/k;
      //   208: getfield 50	com/tencent/mm/app/k:fwx	Ljava/util/HashSet;
      //   211: aload_2
      //   212: invokevirtual 108	java/util/HashSet:remove	(Ljava/lang/Object;)Z
      //   215: pop
      //   216: goto -116 -> 100
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	219	0	this	a
      //   0	219	1	paramInt	int
      //   0	219	2	paramString	String
      //   27	16	3	i	int
      //   53	147	4	localHashSet	HashSet
      // Exception table:
      //   from	to	target	type
      //   100	103	198	finally
      //   112	183	198	finally
      //   183	195	198	finally
      //   199	202	198	finally
      //   204	216	198	finally
    }
  }
  
  private final class b
    implements Runnable
  {
    public b()
    {
      GMTrace.i(12997644779520L, 96840);
      GMTrace.o(12997644779520L, 96840);
    }
    
    private static ActivityManager.ProcessErrorStateInfo or()
    {
      GMTrace.i(12997778997248L, 96841);
      Object localObject = ((ActivityManager)aa.getContext().getSystemService("activity")).getProcessesInErrorState();
      if (localObject == null)
      {
        GMTrace.o(12997778997248L, 96841);
        return null;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.ProcessErrorStateInfo localProcessErrorStateInfo = (ActivityManager.ProcessErrorStateInfo)((Iterator)localObject).next();
        if ((localProcessErrorStateInfo.uid == Process.myUid()) && (localProcessErrorStateInfo.condition == 2))
        {
          GMTrace.o(12997778997248L, 96841);
          return localProcessErrorStateInfo;
        }
      }
      GMTrace.o(12997778997248L, 96841);
      return null;
    }
    
    public final void run()
    {
      GMTrace.i(12997913214976L, 96842);
      long l = System.currentTimeMillis();
      ??? = null;
      v.i("MicroMsg.MMCrashReporter", "ANR Parser started.");
      for (;;)
      {
        if (k.this.fwA.block(10000L)) {
          k.this.fwA.close();
        }
        try
        {
          Thread.sleep(500L);
          Object localObject2 = or();
          ??? = localObject2;
          if (localObject2 == null) {
            continue;
          }
          ??? = localObject2;
          localObject2 = ???;
          if (??? == null)
          {
            ??? = or();
            localObject2 = ???;
            if (??? == null)
            {
              v.w("MicroMsg.MMCrashReporter", "ANR process not found, exit thread.");
              k.this.fwF = null;
              GMTrace.o(12997913214976L, 96842);
              return;
            }
          }
          v.i("MicroMsg.MMCrashReporter", "Got ANR process: " + ((ActivityManager.ProcessErrorStateInfo)localObject2).processName + " @ " + ((ActivityManager.ProcessErrorStateInfo)localObject2).pid);
          for (;;)
          {
            Object localObject4;
            synchronized (k.this.fwx)
            {
              localObject4 = new ArrayList(k.this.fwx.size());
              int i = k.this.fwz.lastIndexOf('.');
              String str;
              if (i != -1)
              {
                str = ((ActivityManager.ProcessErrorStateInfo)localObject2).processName;
                str = k.this.fwz.substring(0, i) + '_' + str + k.this.fwz.substring(i);
                if (k.this.fwx.remove(str)) {
                  ((ArrayList)localObject4).add(str);
                }
              }
              if (k.this.fwx.remove(k.this.fwz)) {
                ((ArrayList)localObject4).add(k.this.fwz);
              }
              ((ArrayList)localObject4).addAll(k.this.fwx);
              ??? = ((ArrayList)localObject4).iterator();
              if (((Iterator)???).hasNext())
              {
                localObject4 = (String)((Iterator)???).next();
                localObject4 = k.this.fwy + '/' + (String)localObject4;
                str = k.a((String)localObject4, ((ActivityManager.ProcessErrorStateInfo)localObject2).pid, l, (ActivityManager.ProcessErrorStateInfo)localObject2);
                if (str != null)
                {
                  v.i("MicroMsg.MMCrashReporter", "Parse ANR trace '%s': OK.", new Object[] { localObject4 });
                  k.this.h(str, ((ActivityManager.ProcessErrorStateInfo)localObject2).pid);
                }
              }
              else
              {
                v.i("MicroMsg.MMCrashReporter", "ANR Parser ended.");
                k.this.fwF = null;
                GMTrace.o(12997913214976L, 96842);
                return;
              }
            }
            v.i("MicroMsg.MMCrashReporter", "Parse ANR trace '%s': Not found.", new Object[] { localObject4 });
          }
        }
        catch (Exception localException)
        {
          for (;;) {}
        }
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/app/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */