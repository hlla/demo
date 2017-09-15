package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.c;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.g;
import com.tencent.smtt.utils.g.a;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l
{
  public static Context aMW;
  private static String wSB;
  private static Handler wSC;
  private static String wSD;
  public static boolean wSE = false;
  private static Object wSF = new byte[0];
  public static h wSG;
  private static HandlerThread wSH;
  static boolean wSI;
  private static boolean wSJ = false;
  private static boolean wSK = false;
  private static boolean wSL = false;
  private static long wSM = -1L;
  
  protected static File CT(int paramInt)
  {
    String[] arrayOfString = t.ceB();
    Object localObject1 = null;
    int i = 0;
    Object localObject2 = localObject1;
    if (i < 4)
    {
      localObject2 = arrayOfString[i];
      if (((String)localObject2).equals(aMW.getApplicationInfo().packageName)) {
        break label128;
      }
      localObject2 = f.a(aMW, (String)localObject2, 4, false);
      if (!fP(aMW)) {
        break label115;
      }
    }
    label115:
    for (localObject1 = "x5.oversea.tbs.org";; localObject1 = "x5.tbs.org")
    {
      localObject1 = new File((String)localObject2, (String)localObject1);
      if (!((File)localObject1).exists()) {
        break label135;
      }
      if (a.c(aMW, (File)localObject1) != paramInt) {
        break;
      }
      TbsLog.i("TbsDownload", "local tbs version fond,path = " + ((File)localObject1).getAbsolutePath());
      localObject2 = localObject1;
      return (File)localObject2;
    }
    TbsLog.i("TbsDownload", "version is not match");
    for (;;)
    {
      label128:
      i += 1;
      break;
      label135:
      TbsLog.i("TbsDownload", "can not find local backup core file");
    }
  }
  
  protected static File CU(int paramInt)
  {
    String[] arrayOfString = t.ceB();
    Object localObject = null;
    int i = 0;
    for (;;)
    {
      String str1;
      String str2;
      if (i < 4)
      {
        str1 = arrayOfString[i];
        str2 = f.a(aMW, str1, 4, false);
        if (!fP(aMW)) {
          break label97;
        }
      }
      label97:
      for (localObject = "x5.oversea.tbs.org";; localObject = "x5.tbs.org")
      {
        localObject = new File(str2, (String)localObject);
        if ((!((File)localObject).exists()) || (a.c(aMW, (File)localObject) != paramInt)) {
          break;
        }
        TbsLog.i("TbsDownload", "local tbs version fond,path = " + ((File)localObject).getAbsolutePath());
        return (File)localObject;
      }
      localObject = new File(f.a(aMW, str1, 4, false), "x5.tbs.decouple");
      if ((((File)localObject).exists()) && (a.c(aMW, (File)localObject) == paramInt))
      {
        TbsLog.i("TbsDownload", "local tbs version fond,path = " + ((File)localObject).getAbsolutePath());
        return (File)localObject;
      }
      i += 1;
    }
  }
  
  private static String Vo(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static boolean a(Context paramContext, boolean paramBoolean, a parama)
  {
    Object localObject = null;
    k localk = k.fM(paramContext);
    if (Build.VERSION.SDK_INT < 8)
    {
      localk.CR(-102);
      return false;
    }
    if (!localk.wSA.contains("is_oversea"))
    {
      boolean bool = paramBoolean;
      if (paramBoolean)
      {
        bool = paramBoolean;
        if (!"com.tencent.mm".equals(paramContext.getApplicationInfo().packageName))
        {
          TbsLog.i("TbsDownload", "needDownload-oversea is true, but not WX");
          bool = false;
        }
      }
      localk.wSz.put("is_oversea", Boolean.valueOf(bool));
      localk.commit();
      wSK = bool;
      TbsLog.i("TbsDownload", "needDownload-first-called--isoversea = " + bool);
    }
    if ((fP(paramContext)) && (Build.VERSION.SDK_INT != 16) && (Build.VERSION.SDK_INT != 17) && (Build.VERSION.SDK_INT != 18))
    {
      TbsLog.i("TbsDownload", "needDownload- return false,  because of  version is " + Build.VERSION.SDK_INT + ", and overea");
      if (parama != null) {
        parama.e(false, 0);
      }
      localk.CR(-103);
      return false;
    }
    paramContext = localk.wSA.getString("device_cpuabi", null);
    wSD = paramContext;
    if (!TextUtils.isEmpty(paramContext)) {}
    try
    {
      paramContext = Pattern.compile("i686|mips|x86_64").matcher(wSD);
      if ((paramContext != null) && (paramContext.find()))
      {
        if (parama != null) {
          parama.e(false, 0);
        }
        localk.CR(-104);
        return false;
      }
      return true;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = (Context)localObject;
      }
    }
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, a parama)
  {
    TbsLog.initIfNeed(paramContext);
    if (p.wTg) {
      if (parama != null) {
        parama.e(false, 0);
      }
    }
    Object localObject;
    do
    {
      return false;
      TbsLog.app_extra("TbsDownload", paramContext);
      localObject = paramContext.getApplicationContext();
      aMW = (Context)localObject;
      localObject = k.fM((Context)localObject);
      ((k)localObject).CR(-100);
    } while (!a(aMW, paramBoolean1, parama));
    ceg();
    if (wSJ)
    {
      if (parama != null) {
        parama.e(false, 0);
      }
      ((k)localObject).CR(-105);
      return false;
    }
    boolean bool = c(aMW, paramBoolean2, false);
    int i;
    if (bool)
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.queryConfig]");
      wSC.removeMessages(100);
      Message localMessage = Message.obtain(wSC, 100);
      if (parama != null) {
        localMessage.obj = parama;
      }
      localMessage.arg1 = 0;
      if (paramBoolean2)
      {
        i = 1;
        localMessage.arg1 = i;
        localMessage.sendToTarget();
        ((k)localObject).CR(-114);
      }
    }
    else
    {
      wSC.removeMessages(102);
      Message.obtain(wSC, 102).sendToTarget();
      if ((!QbSdk.wRb) && (t.gu(paramContext))) {
        break label441;
      }
      paramBoolean1 = ((k)localObject).wSA.contains("tbs_needdownload");
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] hasNeedDownloadKey=" + paramBoolean1);
      if ((paramBoolean1) || (t.gu(paramContext))) {
        break label319;
      }
      paramBoolean1 = true;
    }
    for (;;)
    {
      label260:
      if (paramBoolean1) {
        if (!cem()) {
          paramBoolean1 = false;
        }
      }
      for (;;)
      {
        if ((!bool) && (parama != null)) {
          parama.e(false, 0);
        }
        TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] needDownload=" + paramBoolean1);
        return paramBoolean1;
        i = 0;
        break;
        label319:
        paramBoolean1 = ((k)localObject).wSA.getBoolean("tbs_needdownload", false);
        break label260;
        ((k)localObject).CR(-118);
        continue;
        i = p.ceq().ge(aMW);
        if ((bool) || (i <= 0))
        {
          wSC.removeMessages(103);
          if ((i <= 0) && (!bool)) {
            Message.obtain(wSC, 103, 0, 0, aMW).sendToTarget();
          }
          for (;;)
          {
            ((k)localObject).CR(-121);
            break;
            Message.obtain(wSC, 103, 1, 0, aMW).sendToTarget();
          }
        }
        ((k)localObject).CR(-119);
      }
      label441:
      paramBoolean1 = false;
    }
  }
  
  public static boolean atd()
  {
    try
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.isDownloading] is " + wSI);
      boolean bool = wSI;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static boolean c(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = k.fM(paramContext);
    paramContext = null;
    String str1;
    int i;
    String str2;
    String str3;
    int j;
    String str4;
    long l2;
    long l1;
    if (!paramBoolean1)
    {
      str1 = ((k)localObject).wSA.getString("app_versionname", null);
      i = ((k)localObject).wSA.getInt("app_versioncode", 0);
      str2 = ((k)localObject).wSA.getString("app_metadata", null);
      str3 = c.getAppVersionName(aMW);
      j = c.getAppVersionCode(aMW);
      str4 = c.bC(aMW, "com.tencent.mm.BuildInfo.CLIENT_VERSION");
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendQueryRequest] appVersionName=" + str3 + " oldAppVersionName=" + str1 + " appVersionCode=" + j + " oldAppVersionCode=" + i + " appMetadata=" + str4 + " oldAppVersionMetadata=" + str2);
      l2 = System.currentTimeMillis();
      long l3 = ((k)localObject).wSA.getLong("last_check", 0L);
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendQueryRequest] timeLastCheck=" + l3 + " timeNow=" + l2);
      l1 = l3;
      if (paramBoolean2)
      {
        paramBoolean1 = ((k)localObject).wSA.contains("last_check");
        TbsLog.i("TbsDownload", "[TbsDownloader.needSendQueryRequest] hasLaskCheckKey=" + paramBoolean1);
        l1 = l3;
        if (paramBoolean1)
        {
          l1 = l3;
          if (l3 == 0L) {
            l1 = l2;
          }
        }
      }
      l3 = ((k)localObject).cdX();
      TbsLog.i("TbsDownload", "retryInterval = " + l3 + " s");
      if (l2 - l1 <= l3 * 1000L)
      {
        if ((t.gu(aMW)) && (t.ceH() == 0) && (!ceh()))
        {
          paramBoolean1 = true;
          f.J(aMW.getDir("tbs", 0));
          p.wTd.set(Integer.valueOf(0));
        }
        for (;;)
        {
          if ((!paramBoolean1) && (t.gu(aMW)))
          {
            r.gr(aMW);
            localObject = r.cet();
            ((r.b)localObject).setErrorCode(-119);
            ((r.b)localObject).Vs(paramContext);
            r.gr(aMW).a(r.a.wTs, (r.b)localObject);
          }
          return paramBoolean1;
          if ((str3 == null) || (j == 0) || (str4 == null)) {
            break;
          }
          if ((str3.equals(str1)) && (j == i) && (str4.equals(str2))) {
            break label612;
          }
          paramBoolean1 = true;
        }
        if (!t.gu(aMW)) {
          break label612;
        }
      }
    }
    label612:
    for (paramContext = "timeNow - timeLastCheck is " + (l2 - l1) + " TbsShareManager.findCoreForThirdPartyApp(sAppContext) is " + t.ceH() + " sendRequestWithSameHostCoreVersion() is " + ceh() + " appVersionName is " + str3 + " appVersionCode is " + j + " appMetadata is " + str4 + " oldAppVersionName is " + str1 + " oldAppVersionCode is " + i + " oldAppVersionMetadata is " + str2;; paramContext = null)
    {
      paramBoolean1 = false;
      break;
      paramBoolean1 = true;
      break;
    }
  }
  
  /* Error */
  @TargetApi(11)
  private static boolean c(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc 105
    //   2: new 107	java/lang/StringBuilder
    //   5: dup
    //   6: ldc_w 480
    //   9: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: aload_0
    //   13: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   19: invokestatic 128	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   25: invokestatic 150	com/tencent/smtt/sdk/k:fM	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   28: astore 25
    //   30: aload_0
    //   31: invokestatic 225	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   34: ifeq +27 -> 61
    //   37: iload_2
    //   38: ifeq +12 -> 50
    //   41: aload 25
    //   43: bipush -108
    //   45: invokevirtual 160	com/tencent/smtt/sdk/k:CR	(I)V
    //   48: iconst_0
    //   49: ireturn
    //   50: aload 25
    //   52: sipush 65328
    //   55: invokevirtual 160	com/tencent/smtt/sdk/k:CR	(I)V
    //   58: goto -10 -> 48
    //   61: new 482	org/json/JSONObject
    //   64: dup
    //   65: aload_0
    //   66: invokespecial 483	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   69: astore 26
    //   71: aload 26
    //   73: ldc_w 485
    //   76: invokevirtual 488	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   79: ifeq +27 -> 106
    //   82: iload_2
    //   83: ifeq +12 -> 95
    //   86: aload 25
    //   88: bipush -109
    //   90: invokevirtual 160	com/tencent/smtt/sdk/k:CR	(I)V
    //   93: iconst_0
    //   94: ireturn
    //   95: aload 25
    //   97: sipush 65327
    //   100: invokevirtual 160	com/tencent/smtt/sdk/k:CR	(I)V
    //   103: goto -10 -> 93
    //   106: aload 26
    //   108: ldc_w 490
    //   111: invokevirtual 488	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   114: istore 11
    //   116: aload 26
    //   118: ldc_w 492
    //   121: invokevirtual 494	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   124: astore 27
    //   126: aload 26
    //   128: ldc_w 496
    //   131: ldc -115
    //   133: invokevirtual 499	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   136: astore 28
    //   138: aload 26
    //   140: ldc_w 501
    //   143: invokevirtual 488	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   146: istore 10
    //   148: aload 26
    //   150: ldc_w 503
    //   153: invokevirtual 488	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   156: istore 12
    //   158: aload 26
    //   160: ldc_w 505
    //   163: invokevirtual 488	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   166: istore 13
    //   168: aload 26
    //   170: ldc_w 507
    //   173: invokevirtual 488	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   176: istore 14
    //   178: aload 26
    //   180: ldc_w 509
    //   183: invokevirtual 488	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   186: istore 15
    //   188: aload 26
    //   190: ldc_w 511
    //   193: invokevirtual 514	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   196: lstore 20
    //   198: aload 26
    //   200: ldc_w 516
    //   203: invokevirtual 514	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   206: lstore 22
    //   208: aload 26
    //   210: ldc_w 518
    //   213: lconst_0
    //   214: invokevirtual 521	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   217: lstore 18
    //   219: aload 26
    //   221: ldc_w 523
    //   224: iconst_m1
    //   225: invokevirtual 526	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   228: istore 16
    //   230: iconst_0
    //   231: istore 4
    //   233: aload 26
    //   235: ldc_w 528
    //   238: invokevirtual 488	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   241: istore 5
    //   243: iload 5
    //   245: istore 4
    //   247: aload 25
    //   249: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   252: ldc_w 530
    //   255: iload 4
    //   257: invokestatic 421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   260: invokeinterface 192 3 0
    //   265: pop
    //   266: iload_2
    //   267: ifeq +59 -> 326
    //   270: getstatic 533	com/tencent/smtt/sdk/QbSdk:wRk	Z
    //   273: ifeq +53 -> 326
    //   276: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   279: invokestatic 300	com/tencent/smtt/sdk/t:gu	(Landroid/content/Context;)Z
    //   282: ifeq +44 -> 326
    //   285: aload 26
    //   287: ldc_w 535
    //   290: iconst_0
    //   291: invokevirtual 526	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   294: istore 4
    //   296: invokestatic 541	com/tencent/smtt/sdk/m:ceo	()Lcom/tencent/smtt/sdk/m;
    //   299: astore_0
    //   300: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   303: astore 24
    //   305: iload 4
    //   307: iconst_1
    //   308: if_icmpne +346 -> 654
    //   311: iconst_1
    //   312: istore 17
    //   314: aload_0
    //   315: aload 24
    //   317: ldc_w 543
    //   320: iload 17
    //   322: invokevirtual 547	com/tencent/smtt/sdk/m:n	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   325: pop
    //   326: iload_2
    //   327: ifeq +58 -> 385
    //   330: aload 26
    //   332: ldc_w 549
    //   335: iconst_0
    //   336: invokevirtual 526	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   339: iconst_1
    //   340: iand
    //   341: ifeq +349 -> 690
    //   344: iconst_1
    //   345: istore 17
    //   347: invokestatic 541	com/tencent/smtt/sdk/m:ceo	()Lcom/tencent/smtt/sdk/m;
    //   350: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   353: ldc_w 551
    //   356: iload 17
    //   358: invokevirtual 547	com/tencent/smtt/sdk/m:n	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   361: pop
    //   362: ldc 105
    //   364: new 107	java/lang/StringBuilder
    //   367: dup
    //   368: ldc_w 553
    //   371: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   374: iload 17
    //   376: invokevirtual 200	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   379: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: invokestatic 556	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   385: aconst_null
    //   386: astore 24
    //   388: iconst_0
    //   389: istore 8
    //   391: iconst_0
    //   392: istore 5
    //   394: iconst_0
    //   395: istore 7
    //   397: aload 26
    //   399: ldc_w 558
    //   402: invokevirtual 494	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   405: astore_0
    //   406: aload 26
    //   408: ldc_w 560
    //   411: invokevirtual 488	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   414: istore 4
    //   416: aload 26
    //   418: ldc_w 562
    //   421: invokevirtual 488	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   424: istore 6
    //   426: aload 26
    //   428: ldc_w 564
    //   431: invokevirtual 567	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   434: ifeq +2225 -> 2659
    //   437: aload 26
    //   439: ldc_w 564
    //   442: invokevirtual 488	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   445: istore 5
    //   447: iload 5
    //   449: ifeq +277 -> 726
    //   452: iconst_1
    //   453: istore 5
    //   455: aload 26
    //   457: ldc_w 569
    //   460: invokevirtual 567	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   463: ifeq +2189 -> 2652
    //   466: aload 26
    //   468: ldc_w 569
    //   471: invokevirtual 494	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   474: astore 24
    //   476: iload 6
    //   478: istore 7
    //   480: iload 5
    //   482: istore 8
    //   484: iload 4
    //   486: istore 6
    //   488: iload 7
    //   490: istore 5
    //   492: iload 8
    //   494: istore 4
    //   496: aload 26
    //   498: ldc_w 571
    //   501: invokevirtual 488	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   504: istore 7
    //   506: iconst_0
    //   507: istore 8
    //   509: aload 26
    //   511: ldc_w 573
    //   514: invokevirtual 488	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   517: istore 9
    //   519: iload 9
    //   521: istore 8
    //   523: getstatic 38	com/tencent/smtt/sdk/l:wSF	Ljava/lang/Object;
    //   526: astore 29
    //   528: aload 29
    //   530: monitorenter
    //   531: iload 4
    //   533: ifeq +19 -> 552
    //   536: aload 25
    //   538: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   541: ldc_w 575
    //   544: ldc -115
    //   546: invokeinterface 192 3 0
    //   551: pop
    //   552: aload 24
    //   554: invokestatic 225	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   557: ifne +58 -> 615
    //   560: aload 24
    //   562: invokevirtual 578	java/lang/String:length	()I
    //   565: bipush 96
    //   567: if_icmpne +48 -> 615
    //   570: new 107	java/lang/StringBuilder
    //   573: dup
    //   574: invokespecial 580	java/lang/StringBuilder:<init>	()V
    //   577: aload 24
    //   579: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: ldc_w 582
    //   585: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: invokestatic 587	com/tencent/smtt/utils/j:cff	()Ljava/lang/String;
    //   591: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   597: astore 24
    //   599: aload 25
    //   601: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   604: ldc_w 575
    //   607: aload 24
    //   609: invokeinterface 192 3 0
    //   614: pop
    //   615: aload 29
    //   617: monitorexit
    //   618: iload 6
    //   620: iconst_1
    //   621: if_icmpne +172 -> 793
    //   624: iload_2
    //   625: ifeq +152 -> 777
    //   628: aload 25
    //   630: bipush -110
    //   632: invokevirtual 160	com/tencent/smtt/sdk/k:CR	(I)V
    //   635: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   638: astore_0
    //   639: iload 8
    //   641: iconst_1
    //   642: if_icmpne +146 -> 788
    //   645: iconst_1
    //   646: istore_2
    //   647: aload_0
    //   648: iload_2
    //   649: invokestatic 591	com/tencent/smtt/sdk/QbSdk:reset	(Landroid/content/Context;Z)V
    //   652: iconst_0
    //   653: ireturn
    //   654: iconst_0
    //   655: istore 17
    //   657: goto -343 -> 314
    //   660: astore_0
    //   661: ldc_w 593
    //   664: new 107	java/lang/StringBuilder
    //   667: dup
    //   668: ldc_w 595
    //   671: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   674: aload_0
    //   675: invokevirtual 596	java/lang/Throwable:toString	()Ljava/lang/String;
    //   678: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   684: invokestatic 128	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   687: goto -361 -> 326
    //   690: iconst_0
    //   691: istore 17
    //   693: goto -346 -> 347
    //   696: astore_0
    //   697: ldc_w 593
    //   700: new 107	java/lang/StringBuilder
    //   703: dup
    //   704: ldc_w 595
    //   707: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   710: aload_0
    //   711: invokevirtual 596	java/lang/Throwable:toString	()Ljava/lang/String;
    //   714: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   720: invokestatic 128	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   723: goto -338 -> 385
    //   726: iconst_0
    //   727: istore 5
    //   729: goto -274 -> 455
    //   732: astore_0
    //   733: aload 24
    //   735: astore_0
    //   736: iload 8
    //   738: istore 4
    //   740: iload 7
    //   742: istore 6
    //   744: iload 4
    //   746: istore 7
    //   748: iload 6
    //   750: istore 4
    //   752: ldc -115
    //   754: astore 24
    //   756: iload 7
    //   758: istore 6
    //   760: goto -264 -> 496
    //   763: astore 29
    //   765: iconst_0
    //   766: istore 7
    //   768: goto -262 -> 506
    //   771: astore_0
    //   772: aload 29
    //   774: monitorexit
    //   775: aload_0
    //   776: athrow
    //   777: aload 25
    //   779: sipush 65326
    //   782: invokevirtual 160	com/tencent/smtt/sdk/k:CR	(I)V
    //   785: goto -150 -> 635
    //   788: iconst_0
    //   789: istore_2
    //   790: goto -143 -> 647
    //   793: iload 7
    //   795: iconst_1
    //   796: if_icmpne +9 -> 805
    //   799: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   802: invokestatic 599	com/tencent/smtt/sdk/QbSdk:resetDecoupleCore	(Landroid/content/Context;)V
    //   805: iload 5
    //   807: iconst_1
    //   808: if_icmpne +22 -> 830
    //   811: getstatic 272	com/tencent/smtt/sdk/l:wSC	Landroid/os/Handler;
    //   814: bipush 104
    //   816: invokevirtual 277	android/os/Handler:removeMessages	(I)V
    //   819: getstatic 272	com/tencent/smtt/sdk/l:wSC	Landroid/os/Handler;
    //   822: bipush 104
    //   824: invokestatic 283	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   827: invokevirtual 292	android/os/Message:sendToTarget	()V
    //   830: iload 16
    //   832: iconst_1
    //   833: if_icmpne +1808 -> 2641
    //   836: lload 18
    //   838: ldc2_w 600
    //   841: lcmp
    //   842: ifle +1807 -> 2649
    //   845: ldc2_w 600
    //   848: lstore 18
    //   850: lload 18
    //   852: lconst_0
    //   853: lcmp
    //   854: ifle +1787 -> 2641
    //   857: getstatic 48	com/tencent/smtt/sdk/l:wSM	J
    //   860: lconst_0
    //   861: lcmp
    //   862: iflt +8 -> 870
    //   865: getstatic 48	com/tencent/smtt/sdk/l:wSM	J
    //   868: lstore 18
    //   870: aload 25
    //   872: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   875: ldc_w 603
    //   878: lload 18
    //   880: invokestatic 608	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   883: invokeinterface 192 3 0
    //   888: pop
    //   889: iconst_0
    //   890: istore 4
    //   892: iconst_0
    //   893: istore 5
    //   895: iload_2
    //   896: ifeq +252 -> 1148
    //   899: aload 26
    //   901: ldc_w 610
    //   904: invokevirtual 488	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   907: istore 6
    //   909: iload 6
    //   911: istore 4
    //   913: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   916: invokestatic 150	com/tencent/smtt/sdk/k:fM	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   919: getfield 164	com/tencent/smtt/sdk/k:wSA	Landroid/content/SharedPreferences;
    //   922: ldc_w 612
    //   925: iconst_0
    //   926: invokeinterface 337 3 0
    //   931: istore 6
    //   933: iload 6
    //   935: istore 5
    //   937: iload 4
    //   939: istore 6
    //   941: iload_2
    //   942: ifeq +37 -> 979
    //   945: iload 4
    //   947: istore 6
    //   949: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   952: invokestatic 300	com/tencent/smtt/sdk/t:gu	(Landroid/content/Context;)Z
    //   955: ifne +24 -> 979
    //   958: iload 4
    //   960: istore 6
    //   962: iload 4
    //   964: ifne +15 -> 979
    //   967: invokestatic 317	com/tencent/smtt/sdk/p:ceq	()Lcom/tencent/smtt/sdk/p;
    //   970: pop
    //   971: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   974: invokestatic 615	com/tencent/smtt/sdk/p:gb	(Landroid/content/Context;)I
    //   977: istore 6
    //   979: ldc 105
    //   981: new 107	java/lang/StringBuilder
    //   984: dup
    //   985: ldc_w 617
    //   988: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   991: iload 6
    //   993: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   996: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   999: invokestatic 128	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1002: aload 25
    //   1004: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   1007: ldc_w 619
    //   1010: iload 6
    //   1012: invokestatic 421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1015: invokeinterface 192 3 0
    //   1020: pop
    //   1021: aload 25
    //   1023: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   1026: ldc_w 612
    //   1029: iload 5
    //   1031: invokestatic 421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1034: invokeinterface 192 3 0
    //   1039: pop
    //   1040: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   1043: invokestatic 300	com/tencent/smtt/sdk/t:gu	(Landroid/content/Context;)Z
    //   1046: ifne +47 -> 1093
    //   1049: iload 6
    //   1051: ifle +124 -> 1175
    //   1054: invokestatic 317	com/tencent/smtt/sdk/p:ceq	()Lcom/tencent/smtt/sdk/p;
    //   1057: pop
    //   1058: iload 6
    //   1060: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   1063: invokestatic 615	com/tencent/smtt/sdk/p:gb	(Landroid/content/Context;)I
    //   1066: if_icmpeq +109 -> 1175
    //   1069: iload 6
    //   1071: invokestatic 317	com/tencent/smtt/sdk/p:ceq	()Lcom/tencent/smtt/sdk/p;
    //   1074: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   1077: invokevirtual 622	com/tencent/smtt/sdk/p:gc	(Landroid/content/Context;)I
    //   1080: if_icmpne +95 -> 1175
    //   1083: invokestatic 317	com/tencent/smtt/sdk/p:ceq	()Lcom/tencent/smtt/sdk/p;
    //   1086: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   1089: invokevirtual 625	com/tencent/smtt/sdk/p:gg	(Landroid/content/Context;)Z
    //   1092: pop
    //   1093: aload 27
    //   1095: invokestatic 225	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1098: ifeq +103 -> 1201
    //   1101: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   1104: invokestatic 300	com/tencent/smtt/sdk/t:gu	(Landroid/content/Context;)Z
    //   1107: ifeq +94 -> 1201
    //   1110: aload 25
    //   1112: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   1115: ldc_w 302
    //   1118: iconst_0
    //   1119: invokestatic 186	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1122: invokeinterface 192 3 0
    //   1127: pop
    //   1128: aload 25
    //   1130: invokevirtual 195	com/tencent/smtt/sdk/k:commit	()V
    //   1133: iload_2
    //   1134: ifeq +12 -> 1146
    //   1137: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   1140: iload 10
    //   1142: iconst_0
    //   1143: invokestatic 628	com/tencent/smtt/sdk/t:c	(Landroid/content/Context;IZ)V
    //   1146: iconst_0
    //   1147: ireturn
    //   1148: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   1151: invokestatic 150	com/tencent/smtt/sdk/k:fM	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   1154: getfield 164	com/tencent/smtt/sdk/k:wSA	Landroid/content/SharedPreferences;
    //   1157: ldc_w 619
    //   1160: iconst_0
    //   1161: invokeinterface 337 3 0
    //   1166: istore 6
    //   1168: iload 6
    //   1170: istore 4
    //   1172: goto -259 -> 913
    //   1175: iload 6
    //   1177: ifne -84 -> 1093
    //   1180: invokestatic 317	com/tencent/smtt/sdk/p:ceq	()Lcom/tencent/smtt/sdk/p;
    //   1183: pop
    //   1184: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   1187: invokestatic 632	com/tencent/smtt/sdk/p:gj	(Landroid/content/Context;)Ljava/io/File;
    //   1190: invokestatic 412	com/tencent/smtt/utils/f:J	(Ljava/io/File;)V
    //   1193: goto -100 -> 1093
    //   1196: astore 24
    //   1198: goto -105 -> 1093
    //   1201: ldc 105
    //   1203: new 107	java/lang/StringBuilder
    //   1206: dup
    //   1207: ldc_w 634
    //   1210: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1213: iload 11
    //   1215: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1218: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1221: invokestatic 128	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1224: iload 11
    //   1226: ifne +114 -> 1340
    //   1229: aload 25
    //   1231: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   1234: ldc_w 636
    //   1237: iload 11
    //   1239: invokestatic 421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1242: invokeinterface 192 3 0
    //   1247: pop
    //   1248: aload 25
    //   1250: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   1253: ldc_w 302
    //   1256: iconst_0
    //   1257: invokestatic 186	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1260: invokeinterface 192 3 0
    //   1265: pop
    //   1266: iload_2
    //   1267: ifeq +42 -> 1309
    //   1270: aload 25
    //   1272: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   1275: ldc_w 638
    //   1278: bipush -111
    //   1280: invokestatic 421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1283: invokeinterface 192 3 0
    //   1288: pop
    //   1289: aload 25
    //   1291: invokevirtual 195	com/tencent/smtt/sdk/k:commit	()V
    //   1294: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   1297: invokestatic 300	com/tencent/smtt/sdk/t:gu	(Landroid/content/Context;)Z
    //   1300: ifne +7 -> 1307
    //   1303: invokestatic 641	com/tencent/smtt/sdk/l:cee	()Z
    //   1306: pop
    //   1307: iconst_0
    //   1308: ireturn
    //   1309: aload 25
    //   1311: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   1314: ldc_w 638
    //   1317: sipush 65325
    //   1320: invokestatic 421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1323: invokeinterface 192 3 0
    //   1328: pop
    //   1329: aload 25
    //   1331: sipush 65325
    //   1334: invokevirtual 160	com/tencent/smtt/sdk/k:CR	(I)V
    //   1337: goto -48 -> 1289
    //   1340: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   1343: invokestatic 150	com/tencent/smtt/sdk/k:fM	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   1346: getfield 164	com/tencent/smtt/sdk/k:wSA	Landroid/content/SharedPreferences;
    //   1349: ldc_w 643
    //   1352: iconst_0
    //   1353: invokeinterface 337 3 0
    //   1358: istore 7
    //   1360: iload 7
    //   1362: iload 10
    //   1364: if_icmple +19 -> 1383
    //   1367: getstatic 645	com/tencent/smtt/sdk/l:wSG	Lcom/tencent/smtt/sdk/h;
    //   1370: invokevirtual 650	com/tencent/smtt/sdk/h:clearCache	()V
    //   1373: invokestatic 317	com/tencent/smtt/sdk/p:ceq	()Lcom/tencent/smtt/sdk/p;
    //   1376: pop
    //   1377: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   1380: invokestatic 653	com/tencent/smtt/sdk/p:gi	(Landroid/content/Context;)V
    //   1383: iconst_0
    //   1384: istore 4
    //   1386: iconst_0
    //   1387: istore 6
    //   1389: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   1392: invokestatic 300	com/tencent/smtt/sdk/t:gu	(Landroid/content/Context;)Z
    //   1395: ifne +63 -> 1458
    //   1398: invokestatic 317	com/tencent/smtt/sdk/p:ceq	()Lcom/tencent/smtt/sdk/p;
    //   1401: pop
    //   1402: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   1405: invokestatic 656	com/tencent/smtt/sdk/p:ga	(Landroid/content/Context;)I
    //   1408: istore 8
    //   1410: iload 6
    //   1412: istore 4
    //   1414: iload 8
    //   1416: iload 10
    //   1418: if_icmplt +6 -> 1424
    //   1421: iconst_1
    //   1422: istore 4
    //   1424: ldc 105
    //   1426: new 107	java/lang/StringBuilder
    //   1429: dup
    //   1430: ldc_w 658
    //   1433: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1436: iload 8
    //   1438: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1441: ldc_w 660
    //   1444: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1447: iload 10
    //   1449: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1452: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1455: invokestatic 128	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1458: iload_1
    //   1459: iload 10
    //   1461: if_icmpge +16 -> 1477
    //   1464: aload 27
    //   1466: invokestatic 225	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1469: ifne +8 -> 1477
    //   1472: iload 4
    //   1474: ifeq +271 -> 1745
    //   1477: iload 5
    //   1479: iconst_1
    //   1480: if_icmpeq +265 -> 1745
    //   1483: aload 25
    //   1485: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   1488: ldc_w 302
    //   1491: iconst_0
    //   1492: invokestatic 186	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1495: invokeinterface 192 3 0
    //   1500: pop
    //   1501: iload_2
    //   1502: ifeq +169 -> 1671
    //   1505: aload 27
    //   1507: invokestatic 225	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1510: ifeq +84 -> 1594
    //   1513: aload 25
    //   1515: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   1518: ldc_w 638
    //   1521: bipush -124
    //   1523: invokestatic 421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1526: invokeinterface 192 3 0
    //   1531: pop
    //   1532: aload 25
    //   1534: invokevirtual 195	com/tencent/smtt/sdk/k:commit	()V
    //   1537: ldc 105
    //   1539: new 107	java/lang/StringBuilder
    //   1542: dup
    //   1543: ldc_w 662
    //   1546: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1549: iload_1
    //   1550: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1553: ldc_w 664
    //   1556: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1559: iload 10
    //   1561: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1564: ldc_w 666
    //   1567: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1570: iload 7
    //   1572: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1575: ldc_w 668
    //   1578: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1581: aload 27
    //   1583: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1586: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1589: invokestatic 128	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1592: iconst_0
    //   1593: ireturn
    //   1594: iload 10
    //   1596: ifgt +25 -> 1621
    //   1599: aload 25
    //   1601: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   1604: ldc_w 638
    //   1607: bipush -125
    //   1609: invokestatic 421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1612: invokeinterface 192 3 0
    //   1617: pop
    //   1618: goto -86 -> 1532
    //   1621: iload_1
    //   1622: iload 10
    //   1624: if_icmplt +25 -> 1649
    //   1627: aload 25
    //   1629: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   1632: ldc_w 638
    //   1635: bipush -127
    //   1637: invokestatic 421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1640: invokeinterface 192 3 0
    //   1645: pop
    //   1646: goto -114 -> 1532
    //   1649: aload 25
    //   1651: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   1654: ldc_w 638
    //   1657: bipush -112
    //   1659: invokestatic 421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1662: invokeinterface 192 3 0
    //   1667: pop
    //   1668: goto -136 -> 1532
    //   1671: sipush 65324
    //   1674: istore 4
    //   1676: aload 27
    //   1678: invokestatic 225	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1681: ifeq +37 -> 1718
    //   1684: sipush 65319
    //   1687: istore 4
    //   1689: aload 25
    //   1691: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   1694: ldc_w 638
    //   1697: iload 4
    //   1699: invokestatic 421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1702: invokeinterface 192 3 0
    //   1707: pop
    //   1708: aload 25
    //   1710: iload 4
    //   1712: invokevirtual 160	com/tencent/smtt/sdk/k:CR	(I)V
    //   1715: goto -183 -> 1532
    //   1718: iload 10
    //   1720: ifgt +11 -> 1731
    //   1723: sipush 65318
    //   1726: istore 4
    //   1728: goto -39 -> 1689
    //   1731: iload_1
    //   1732: iload 10
    //   1734: if_icmplt -45 -> 1689
    //   1737: sipush 65317
    //   1740: istore 4
    //   1742: goto -53 -> 1689
    //   1745: aload 27
    //   1747: aload 25
    //   1749: getfield 164	com/tencent/smtt/sdk/k:wSA	Landroid/content/SharedPreferences;
    //   1752: ldc_w 670
    //   1755: aconst_null
    //   1756: invokeinterface 217 3 0
    //   1761: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1764: ifne +45 -> 1809
    //   1767: getstatic 645	com/tencent/smtt/sdk/l:wSG	Lcom/tencent/smtt/sdk/h;
    //   1770: invokevirtual 650	com/tencent/smtt/sdk/h:clearCache	()V
    //   1773: aload 25
    //   1775: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   1778: ldc_w 672
    //   1781: iconst_0
    //   1782: invokestatic 421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1785: invokeinterface 192 3 0
    //   1790: pop
    //   1791: aload 25
    //   1793: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   1796: ldc_w 674
    //   1799: iconst_0
    //   1800: invokestatic 421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1803: invokeinterface 192 3 0
    //   1808: pop
    //   1809: aload 25
    //   1811: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   1814: ldc_w 643
    //   1817: iload 10
    //   1819: invokestatic 421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1822: invokeinterface 192 3 0
    //   1827: pop
    //   1828: ldc 105
    //   1830: new 107	java/lang/StringBuilder
    //   1833: dup
    //   1834: ldc_w 676
    //   1837: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1840: iload 10
    //   1842: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1845: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1848: invokestatic 128	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1851: iload 10
    //   1853: ifle +50 -> 1903
    //   1856: iload 5
    //   1858: iconst_1
    //   1859: if_icmpne +330 -> 2189
    //   1862: aload 25
    //   1864: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   1867: ldc_w 678
    //   1870: iconst_1
    //   1871: invokestatic 421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1874: invokeinterface 192 3 0
    //   1879: pop
    //   1880: ldc 105
    //   1882: new 107	java/lang/StringBuilder
    //   1885: dup
    //   1886: ldc_w 680
    //   1889: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1892: iload 5
    //   1894: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1897: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1900: invokestatic 128	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1903: aload 25
    //   1905: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   1908: ldc_w 670
    //   1911: aload 27
    //   1913: invokeinterface 192 3 0
    //   1918: pop
    //   1919: aload 25
    //   1921: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   1924: ldc_w 682
    //   1927: aload 28
    //   1929: invokeinterface 192 3 0
    //   1934: pop
    //   1935: aload 25
    //   1937: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   1940: ldc_w 636
    //   1943: iload 11
    //   1945: invokestatic 421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1948: invokeinterface 192 3 0
    //   1953: pop
    //   1954: aload 25
    //   1956: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   1959: ldc_w 684
    //   1962: iload 12
    //   1964: invokestatic 421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1967: invokeinterface 192 3 0
    //   1972: pop
    //   1973: aload 25
    //   1975: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   1978: ldc_w 686
    //   1981: iload 13
    //   1983: invokestatic 421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1986: invokeinterface 192 3 0
    //   1991: pop
    //   1992: aload 25
    //   1994: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   1997: ldc_w 688
    //   2000: iload 14
    //   2002: invokestatic 421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2005: invokeinterface 192 3 0
    //   2010: pop
    //   2011: aload 25
    //   2013: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   2016: ldc_w 690
    //   2019: iload 15
    //   2021: invokestatic 421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2024: invokeinterface 192 3 0
    //   2029: pop
    //   2030: aload 25
    //   2032: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   2035: ldc_w 692
    //   2038: lload 20
    //   2040: invokestatic 608	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2043: invokeinterface 192 3 0
    //   2048: pop
    //   2049: aload 25
    //   2051: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   2054: ldc_w 694
    //   2057: lload 22
    //   2059: invokestatic 608	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2062: invokeinterface 192 3 0
    //   2067: pop
    //   2068: aload 25
    //   2070: invokevirtual 195	com/tencent/smtt/sdk/k:commit	()V
    //   2073: aload_0
    //   2074: ifnull +18 -> 2092
    //   2077: aload 25
    //   2079: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   2082: ldc_w 696
    //   2085: aload_0
    //   2086: invokeinterface 192 3 0
    //   2091: pop
    //   2092: iload_3
    //   2093: ifne +148 -> 2241
    //   2096: invokestatic 317	com/tencent/smtt/sdk/p:ceq	()Lcom/tencent/smtt/sdk/p;
    //   2099: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   2102: iload 10
    //   2104: invokevirtual 700	com/tencent/smtt/sdk/p:aj	(Landroid/content/Context;I)Z
    //   2107: ifeq +134 -> 2241
    //   2110: iload_2
    //   2111: ifeq +99 -> 2210
    //   2114: aload 25
    //   2116: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   2119: ldc_w 638
    //   2122: bipush -113
    //   2124: invokestatic 421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2127: invokeinterface 192 3 0
    //   2132: pop
    //   2133: aload 25
    //   2135: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   2138: ldc_w 302
    //   2141: iconst_0
    //   2142: invokestatic 186	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2145: invokeinterface 192 3 0
    //   2150: pop
    //   2151: aload 26
    //   2153: ldc_w 702
    //   2156: iconst_0
    //   2157: invokevirtual 526	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2160: iconst_1
    //   2161: if_icmpne +21 -> 2182
    //   2164: aload 25
    //   2166: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   2169: ldc_w 704
    //   2172: iconst_1
    //   2173: invokestatic 186	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2176: invokeinterface 192 3 0
    //   2181: pop
    //   2182: aload 25
    //   2184: invokevirtual 195	com/tencent/smtt/sdk/k:commit	()V
    //   2187: iconst_1
    //   2188: ireturn
    //   2189: aload 25
    //   2191: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   2194: ldc_w 678
    //   2197: iconst_0
    //   2198: invokestatic 421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2201: invokeinterface 192 3 0
    //   2206: pop
    //   2207: goto -327 -> 1880
    //   2210: aload 25
    //   2212: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   2215: ldc_w 638
    //   2218: sipush 65323
    //   2221: invokestatic 421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2224: invokeinterface 192 3 0
    //   2229: pop
    //   2230: aload 25
    //   2232: sipush 65323
    //   2235: invokevirtual 160	com/tencent/smtt/sdk/k:CR	(I)V
    //   2238: goto -105 -> 2133
    //   2241: iload_3
    //   2242: ifne +149 -> 2391
    //   2245: getstatic 645	com/tencent/smtt/sdk/l:wSG	Lcom/tencent/smtt/sdk/h;
    //   2248: astore_0
    //   2249: iload 11
    //   2251: iconst_1
    //   2252: if_icmpeq +9 -> 2261
    //   2255: iload 11
    //   2257: iconst_2
    //   2258: if_icmpne +112 -> 2370
    //   2261: iconst_1
    //   2262: istore_3
    //   2263: aload_0
    //   2264: iload_3
    //   2265: invokevirtual 708	com/tencent/smtt/sdk/h:lZ	(Z)Z
    //   2268: ifeq +123 -> 2391
    //   2271: aload 25
    //   2273: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   2276: ldc_w 302
    //   2279: iconst_0
    //   2280: invokestatic 186	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2283: invokeinterface 192 3 0
    //   2288: pop
    //   2289: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   2292: invokestatic 433	com/tencent/smtt/sdk/r:gr	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/r;
    //   2295: pop
    //   2296: invokestatic 437	com/tencent/smtt/sdk/r:cet	()Lcom/tencent/smtt/sdk/r$b;
    //   2299: astore_0
    //   2300: aload_0
    //   2301: bipush 100
    //   2303: invokevirtual 442	com/tencent/smtt/sdk/r$b:setErrorCode	(I)V
    //   2306: aload_0
    //   2307: new 107	java/lang/StringBuilder
    //   2310: dup
    //   2311: ldc_w 710
    //   2314: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2317: getstatic 645	com/tencent/smtt/sdk/l:wSG	Lcom/tencent/smtt/sdk/h;
    //   2320: getfield 713	com/tencent/smtt/sdk/h:wSl	Ljava/lang/String;
    //   2323: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2326: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2329: invokevirtual 445	com/tencent/smtt/sdk/r$b:Vs	(Ljava/lang/String;)V
    //   2332: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   2335: invokestatic 150	com/tencent/smtt/sdk/k:fM	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   2338: getfield 164	com/tencent/smtt/sdk/k:wSA	Landroid/content/SharedPreferences;
    //   2341: ldc_w 612
    //   2344: iconst_0
    //   2345: invokeinterface 337 3 0
    //   2350: iconst_1
    //   2351: if_icmpne +24 -> 2375
    //   2354: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   2357: invokestatic 433	com/tencent/smtt/sdk/r:gr	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/r;
    //   2360: getstatic 716	com/tencent/smtt/sdk/r$a:wTv	Lcom/tencent/smtt/sdk/r$a;
    //   2363: aload_0
    //   2364: invokevirtual 454	com/tencent/smtt/sdk/r:a	(Lcom/tencent/smtt/sdk/r$a;Lcom/tencent/smtt/sdk/r$b;)V
    //   2367: goto -216 -> 2151
    //   2370: iconst_0
    //   2371: istore_3
    //   2372: goto -109 -> 2263
    //   2375: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   2378: invokestatic 433	com/tencent/smtt/sdk/r:gr	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/r;
    //   2381: getstatic 451	com/tencent/smtt/sdk/r$a:wTs	Lcom/tencent/smtt/sdk/r$a;
    //   2384: aload_0
    //   2385: invokevirtual 454	com/tencent/smtt/sdk/r:a	(Lcom/tencent/smtt/sdk/r$a;Lcom/tencent/smtt/sdk/r$b;)V
    //   2388: goto -237 -> 2151
    //   2391: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   2394: invokestatic 150	com/tencent/smtt/sdk/k:fM	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   2397: getfield 164	com/tencent/smtt/sdk/k:wSA	Landroid/content/SharedPreferences;
    //   2400: ldc_w 678
    //   2403: iconst_0
    //   2404: invokeinterface 337 3 0
    //   2409: iconst_1
    //   2410: if_icmpne +127 -> 2537
    //   2413: getstatic 645	com/tencent/smtt/sdk/l:wSG	Lcom/tencent/smtt/sdk/h;
    //   2416: invokevirtual 719	com/tencent/smtt/sdk/h:cdN	()Z
    //   2419: ifeq +118 -> 2537
    //   2422: aload 25
    //   2424: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   2427: ldc_w 302
    //   2430: iconst_0
    //   2431: invokestatic 186	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2434: invokeinterface 192 3 0
    //   2439: pop
    //   2440: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   2443: invokestatic 433	com/tencent/smtt/sdk/r:gr	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/r;
    //   2446: pop
    //   2447: invokestatic 437	com/tencent/smtt/sdk/r:cet	()Lcom/tencent/smtt/sdk/r$b;
    //   2450: astore_0
    //   2451: aload_0
    //   2452: bipush 100
    //   2454: invokevirtual 442	com/tencent/smtt/sdk/r$b:setErrorCode	(I)V
    //   2457: aload_0
    //   2458: new 107	java/lang/StringBuilder
    //   2461: dup
    //   2462: ldc_w 721
    //   2465: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2468: getstatic 645	com/tencent/smtt/sdk/l:wSG	Lcom/tencent/smtt/sdk/h;
    //   2471: getfield 713	com/tencent/smtt/sdk/h:wSl	Ljava/lang/String;
    //   2474: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2477: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2480: invokevirtual 445	com/tencent/smtt/sdk/r$b:Vs	(Ljava/lang/String;)V
    //   2483: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   2486: invokestatic 150	com/tencent/smtt/sdk/k:fM	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   2489: getfield 164	com/tencent/smtt/sdk/k:wSA	Landroid/content/SharedPreferences;
    //   2492: ldc_w 612
    //   2495: iconst_0
    //   2496: invokeinterface 337 3 0
    //   2501: iconst_1
    //   2502: if_icmpne +19 -> 2521
    //   2505: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   2508: invokestatic 433	com/tencent/smtt/sdk/r:gr	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/r;
    //   2511: getstatic 716	com/tencent/smtt/sdk/r$a:wTv	Lcom/tencent/smtt/sdk/r$a;
    //   2514: aload_0
    //   2515: invokevirtual 454	com/tencent/smtt/sdk/r:a	(Lcom/tencent/smtt/sdk/r$a;Lcom/tencent/smtt/sdk/r$b;)V
    //   2518: goto -367 -> 2151
    //   2521: getstatic 59	com/tencent/smtt/sdk/l:aMW	Landroid/content/Context;
    //   2524: invokestatic 433	com/tencent/smtt/sdk/r:gr	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/r;
    //   2527: getstatic 451	com/tencent/smtt/sdk/r$a:wTs	Lcom/tencent/smtt/sdk/r$a;
    //   2530: aload_0
    //   2531: invokevirtual 454	com/tencent/smtt/sdk/r:a	(Lcom/tencent/smtt/sdk/r$a;Lcom/tencent/smtt/sdk/r$b;)V
    //   2534: goto -383 -> 2151
    //   2537: iload_2
    //   2538: ifne +11 -> 2549
    //   2541: aload 25
    //   2543: sipush 65320
    //   2546: invokevirtual 160	com/tencent/smtt/sdk/k:CR	(I)V
    //   2549: aload 25
    //   2551: getfield 180	com/tencent/smtt/sdk/k:wSz	Ljava/util/Map;
    //   2554: ldc_w 302
    //   2557: iconst_1
    //   2558: invokestatic 186	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2561: invokeinterface 192 3 0
    //   2566: pop
    //   2567: goto -416 -> 2151
    //   2570: astore 24
    //   2572: goto -1635 -> 937
    //   2575: astore 24
    //   2577: goto -1664 -> 913
    //   2580: astore 29
    //   2582: goto -2059 -> 523
    //   2585: astore 24
    //   2587: iload 7
    //   2589: istore 6
    //   2591: iload 8
    //   2593: istore 4
    //   2595: goto -1851 -> 744
    //   2598: astore 24
    //   2600: iload 7
    //   2602: istore 6
    //   2604: goto -1860 -> 744
    //   2607: astore 24
    //   2609: iload 6
    //   2611: istore 5
    //   2613: iload 7
    //   2615: istore 6
    //   2617: goto -1873 -> 744
    //   2620: astore 24
    //   2622: iload 6
    //   2624: istore 7
    //   2626: iload 5
    //   2628: istore 6
    //   2630: iload 7
    //   2632: istore 5
    //   2634: goto -1890 -> 744
    //   2637: astore_0
    //   2638: goto -2391 -> 247
    //   2641: ldc2_w 722
    //   2644: lstore 18
    //   2646: goto -1789 -> 857
    //   2649: goto -1799 -> 850
    //   2652: ldc -115
    //   2654: astore 24
    //   2656: goto -2180 -> 476
    //   2659: iconst_0
    //   2660: istore 5
    //   2662: goto -2207 -> 455
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2665	0	paramString	String
    //   0	2665	1	paramInt	int
    //   0	2665	2	paramBoolean1	boolean
    //   0	2665	3	paramBoolean2	boolean
    //   231	2363	4	i	int
    //   241	2420	5	j	int
    //   424	2205	6	k	int
    //   395	2236	7	m	int
    //   389	2203	8	n	int
    //   517	3	9	i1	int
    //   146	1957	10	i2	int
    //   114	2145	11	i3	int
    //   156	1807	12	i4	int
    //   166	1816	13	i5	int
    //   176	1825	14	i6	int
    //   186	1834	15	i7	int
    //   228	606	16	i8	int
    //   312	380	17	bool	boolean
    //   217	2428	18	l1	long
    //   196	1843	20	l2	long
    //   206	1852	22	l3	long
    //   303	452	24	localObject1	Object
    //   1196	1	24	localThrowable	Throwable
    //   2570	1	24	localException1	Exception
    //   2575	1	24	localException2	Exception
    //   2585	1	24	localException3	Exception
    //   2598	1	24	localException4	Exception
    //   2607	1	24	localException5	Exception
    //   2620	1	24	localException6	Exception
    //   2654	1	24	str1	String
    //   28	2522	25	localk	k
    //   69	2083	26	localJSONObject	JSONObject
    //   124	1788	27	str2	String
    //   136	1792	28	str3	String
    //   526	90	29	localObject2	Object
    //   763	10	29	localException7	Exception
    //   2580	1	29	localException8	Exception
    // Exception table:
    //   from	to	target	type
    //   285	305	660	java/lang/Throwable
    //   314	326	660	java/lang/Throwable
    //   330	344	696	java/lang/Throwable
    //   347	385	696	java/lang/Throwable
    //   397	406	732	java/lang/Exception
    //   496	506	763	java/lang/Exception
    //   536	552	771	finally
    //   552	615	771	finally
    //   615	618	771	finally
    //   772	775	771	finally
    //   1180	1193	1196	java/lang/Throwable
    //   913	933	2570	java/lang/Exception
    //   899	909	2575	java/lang/Exception
    //   1148	1168	2575	java/lang/Exception
    //   509	519	2580	java/lang/Exception
    //   406	416	2585	java/lang/Exception
    //   416	426	2598	java/lang/Exception
    //   426	447	2607	java/lang/Exception
    //   455	476	2620	java/lang/Exception
    //   233	243	2637	java/lang/Exception
  }
  
  public static int cec()
  {
    p.ceq();
    return p.gb(aMW);
  }
  
  public static boolean ced()
  {
    if (t.gu(aMW)) {}
    int i;
    do
    {
      do
      {
        long l;
        do
        {
          do
          {
            return false;
          } while (k.fM(aMW).wSA.getInt("tbs_downloaddecouplecore", 0) == 1);
          l = k.fM(aMW).wSA.getLong("last_download_decouple_core", 0L);
        } while (System.currentTimeMillis() - l < 1000L * k.fM(aMW).cdX());
        i = k.fM(aMW).wSA.getInt("tbs_decouplecoreversion", 0);
      } while (i <= 0);
      p.ceq();
    } while ((i == p.gb(aMW)) || (k.fM(aMW).wSA.getInt("tbs_download_version", 0) == i));
    return true;
  }
  
  public static boolean cee()
  {
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded ");
    if (t.gu(aMW)) {}
    long l;
    do
    {
      do
      {
        return false;
        TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #1");
      } while (k.fM(aMW).wSA.getInt("tbs_downloaddecouplecore", 0) == 1);
      TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #2");
      l = k.fM(aMW).wSA.getLong("last_download_decouple_core", 0L);
    } while (System.currentTimeMillis() - l < 1000L * k.fM(aMW).cdX());
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #3");
    int i = k.fM(aMW).wSA.getInt("tbs_decouplecoreversion", 0);
    if (i > 0)
    {
      p.ceq();
      if (i != p.gb(aMW))
      {
        if ((k.fM(aMW).wSA.getInt("tbs_download_version", 0) != i) || (k.fM(aMW).wSA.getInt("tbs_download_version_type", 0) == 1))
        {
          TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #4");
          wSI = true;
          wSC.removeMessages(108);
          localObject = Message.obtain(wSC, 108, QbSdk.wRt);
          ((Message)localObject).arg1 = 0;
          ((Message)localObject).sendToTarget();
          k.fM(aMW).wSz.put("last_download_decouple_core", Long.valueOf(System.currentTimeMillis()));
          return true;
        }
        TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded no need, KEY_TBS_DOWNLOAD_V is " + k.fM(aMW).wSA.getInt("tbs_download_version", 0) + " deCoupleCoreVersion is " + i + " KEY_TBS_DOWNLOAD_V_TYPE is " + k.fM(aMW).wSA.getInt("tbs_download_version_type", 0));
        return false;
      }
    }
    Object localObject = new StringBuilder("startDecoupleCoreIfNeeded no need, deCoupleCoreVersion is ").append(i).append(" getTbsCoreShareDecoupleCoreVersion is ");
    p.ceq();
    TbsLog.i("TbsDownload", p.gb(aMW));
    return false;
  }
  
  public static boolean cef()
  {
    if (wSG != null)
    {
      h localh = wSG;
      TbsLog.i("TbsDownload", "[TbsApkDownloader.isDownloadForeground] mIsDownloadForeground=" + localh.wSk);
      if (localh.wSk) {
        return true;
      }
    }
    return false;
  }
  
  private static void ceg()
  {
    try
    {
      if (wSH == null) {
        wSH = n.cep();
      }
      try
      {
        wSG = new h(aMW);
        wSC = new Handler(wSH.getLooper())
        {
          public final void handleMessage(Message paramAnonymousMessage)
          {
            boolean bool3 = true;
            int i;
            boolean bool1;
            Object localObject1;
            switch (paramAnonymousMessage.what)
            {
            case 105: 
            case 106: 
            case 107: 
            default: 
              return;
            case 100: 
              if (paramAnonymousMessage.arg1 == 1) {}
              for (i = 1;; i = 0)
              {
                bool1 = l.cej();
                if ((paramAnonymousMessage.obj != null) && ((paramAnonymousMessage.obj instanceof l.a)))
                {
                  TbsLog.i("TbsDownload", "needDownload-onNeedDownloadFinish needStartDownload=" + bool1);
                  if ((!bool1) || (i != 0)) {
                    ((l.a)paramAnonymousMessage.obj).e(bool1, k.fM(l.aMW).wSA.getInt("tbs_download_version", 0));
                  }
                }
                if ((!t.gu(l.aMW)) || (!bool1)) {
                  break;
                }
                l.fO(l.aMW);
                return;
              }
            case 101: 
            case 108: 
              localObject1 = null;
              Object localObject2 = "tbs_download_lock_file" + k.fM(l.aMW).wSA.getInt("tbs_download_version", 0) + ".txt";
              FileOutputStream localFileOutputStream = f.b(l.aMW, false, (String)localObject2);
              if (localFileOutputStream != null)
              {
                localObject2 = f.a(localFileOutputStream);
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  TbsLog.i("TbsDownload", "file lock locked,wx or qq is downloading");
                  k.fM(l.aMW).CR(65333);
                  TbsLog.i("TbsDownload", "MSG_START_DOWNLOAD_DECOUPLECORE return #1");
                }
              }
              else if (f.gT(l.aMW))
              {
                k.fM(l.aMW).CR(65332);
                TbsLog.i("TbsDownload", "MSG_START_DOWNLOAD_DECOUPLECORE return #2");
                return;
              }
              boolean bool2;
              if (paramAnonymousMessage.arg1 == 1)
              {
                bool1 = true;
                localObject2 = k.fM(l.aMW);
                if (108 != paramAnonymousMessage.what) {
                  break label422;
                }
                bool2 = true;
                if (!l.e(false, bool1, bool2)) {
                  break label505;
                }
                if ((!bool1) || (!p.ceq().aj(l.aMW, k.fM(l.aMW).wSA.getInt("tbs_download_version", 0)))) {
                  break label428;
                }
                QbSdk.wRt.ir(122);
                ((k)localObject2).CR(65323);
              }
              for (;;)
              {
                TbsLog.i("TbsDownload", "------freeFileLock called :");
                f.a((FileLock)localObject1, localFileOutputStream);
                return;
                bool1 = false;
                break;
                bool2 = false;
                break label338;
                if (((k)localObject2).wSA.getBoolean("tbs_needdownload", false))
                {
                  k.fM(l.aMW).CR(65321);
                  localObject2 = l.wSG;
                  if (108 == paramAnonymousMessage.what) {}
                  for (bool2 = bool3;; bool2 = false)
                  {
                    ((h)localObject2).L(bool1, bool2);
                    break;
                  }
                }
                QbSdk.wRt.ir(110);
                continue;
                QbSdk.wRt.ir(110);
              }
            case 102: 
              TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
              if (t.gu(l.aMW)) {}
              for (i = t.ceG();; i = p.ceq().ge(l.aMW))
              {
                TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] localTbsVersion=" + i);
                paramAnonymousMessage = l.wSG;
                try
                {
                  localObject1 = new File(paramAnonymousMessage.wRV, "x5.tbs");
                  int j = a.c(paramAnonymousMessage.mContext, (File)localObject1);
                  if ((-1 == j) || ((i > 0) && (i == j))) {
                    ((File)localObject1).delete();
                  }
                }
                catch (Exception paramAnonymousMessage)
                {
                  for (;;) {}
                }
                r.gr(l.aMW).ceu();
                return;
              }
            case 104: 
              label338:
              label422:
              label428:
              label505:
              TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_UPLOAD_TBSLOG");
              r.gr(l.aMW).cew();
              return;
            }
            TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
            if (paramAnonymousMessage.arg1 == 0)
            {
              p.ceq().u((Context)paramAnonymousMessage.obj, true);
              return;
            }
            p.ceq().u((Context)paramAnonymousMessage.obj, false);
          }
        };
      }
      catch (Exception localException)
      {
        for (;;)
        {
          wSJ = true;
          TbsLog.e("TbsDownload", "TbsApkDownloader init has Exception");
        }
      }
      return;
    }
    finally {}
  }
  
  private static boolean ceh()
  {
    try
    {
      JSONArray localJSONArray = cei();
      boolean bool = k.fM(aMW).wSA.getString("last_thirdapp_sendrequest_coreversion", "").equals(localJSONArray.toString());
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private static JSONArray cei()
  {
    int k = 0;
    if (t.gu(aMW))
    {
      JSONArray localJSONArray = new JSONArray();
      String[] arrayOfString1 = t.ceB();
      String str = aMW.getApplicationContext().getPackageName();
      if (str.equals(t.gw(aMW)))
      {
        String[] arrayOfString2 = new String[5];
        System.arraycopy(arrayOfString1, 0, arrayOfString2, 0, 4);
        arrayOfString2[4] = str;
      }
      if (t.ceA() != null)
      {
        p.ceq();
        int m = p.Vp(t.ceA());
        int i = 0;
        for (;;)
        {
          int j = k;
          if (i < localJSONArray.length())
          {
            if (localJSONArray.optInt(i) == m) {
              j = 1;
            }
          }
          else
          {
            if (j == 0) {
              localJSONArray.put(m);
            }
            return localJSONArray;
          }
          i += 1;
        }
      }
      return localJSONArray;
    }
    return null;
  }
  
  public static boolean cej()
  {
    return e(true, false, false);
  }
  
  public static long cek()
  {
    return wSM;
  }
  
  static String cel()
  {
    if (!TextUtils.isEmpty(wSB)) {
      return wSB;
    }
    Locale localLocale = Locale.getDefault();
    localStringBuffer = new StringBuffer();
    Object localObject = Build.VERSION.RELEASE;
    try
    {
      str = new String(((String)localObject).getBytes("UTF-8"), "ISO8859-1");
      localObject = str;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        String str;
        continue;
        localStringBuffer.append("1.0");
        continue;
        localStringBuffer.append("en");
      }
    }
    if (((String)localObject).length() > 0)
    {
      localStringBuffer.append((String)localObject);
      localStringBuffer.append("; ");
      localObject = localLocale.getLanguage();
      if (localObject == null) {
        break label240;
      }
      localStringBuffer.append(((String)localObject).toLowerCase());
      localObject = localLocale.getCountry();
      if (localObject != null)
      {
        localStringBuffer.append("-");
        localStringBuffer.append(((String)localObject).toLowerCase());
      }
      if ("REL".equals(Build.VERSION.CODENAME)) {
        localObject = Build.MODEL;
      }
    }
    try
    {
      str = new String(((String)localObject).getBytes("UTF-8"), "ISO8859-1");
      localObject = str;
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
    if (((String)localObject).length() > 0)
    {
      localStringBuffer.append("; ");
      localStringBuffer.append((String)localObject);
    }
    localObject = Build.ID.replaceAll("[一-龥]", "");
    if (((String)localObject).length() > 0)
    {
      localStringBuffer.append(" Build/");
      localStringBuffer.append((String)localObject);
    }
    localObject = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", new Object[] { localStringBuffer });
    wSB = (String)localObject;
    return (String)localObject;
  }
  
  private static boolean cem()
  {
    k localk = k.fM(aMW);
    if (localk.wSA.getInt("tbs_download_success_retrytimes", 0) >= localk.cdZ())
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of success retrytimes", true);
      localk.CR(-115);
      return false;
    }
    if (localk.wSA.getInt("tbs_download_failed_retrytimes", 0) >= localk.cea())
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of failed retrytimes", true);
      localk.CR(-116);
      return false;
    }
    if (!f.gU(aMW))
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] local rom freespace limit", true);
      localk.CR(-117);
      return false;
    }
    if (System.currentTimeMillis() - localk.wSA.getLong("tbs_downloadstarttime", 0L) <= 86400000L)
    {
      long l = localk.wSA.getLong("tbs_downloadflow", 0L);
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] downloadFlow=" + l);
      if (l >= localk.cdW())
      {
        TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] failed because you exceeded max flow!", true);
        localk.CR(-120);
        return false;
      }
    }
    return true;
  }
  
  private static JSONArray cen()
  {
    JSONArray localJSONArray = new JSONArray();
    String[] arrayOfString = t.ceB();
    int i = 0;
    Object localObject;
    label52:
    long l;
    if (i < 4)
    {
      localObject = arrayOfString[i];
      String str = f.a(aMW, (String)localObject, 4, false);
      if (fP(aMW))
      {
        localObject = "x5.oversea.tbs.org";
        localObject = new File(str, (String)localObject);
        if (((File)localObject).exists())
        {
          l = a.c(aMW, (File)localObject);
          if (l > 0L)
          {
            j = 0;
            label91:
            if (j >= localJSONArray.length()) {
              break label149;
            }
            if (localJSONArray.optInt(j) != l) {
              break label139;
            }
          }
        }
      }
    }
    label139:
    label149:
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        localJSONArray.put(l);
      }
      i += 1;
      break;
      localObject = "x5.tbs.org";
      break label52;
      j += 1;
      break label91;
      return localJSONArray;
    }
  }
  
  private static JSONObject d(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int k = 0;
    TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData]isQuery: " + paramBoolean1 + " forDecoupleCore is " + paramBoolean3);
    Object localObject4 = k.fM(aMW);
    String str2 = cel();
    String str3 = c.gP(aMW);
    String str4 = c.V(aMW);
    String str5 = c.gR(aMW);
    Object localObject1 = TimeZone.getDefault().getID();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      try
      {
        localObject3 = (TelephonyManager)aMW.getSystemService("phone");
        if (localObject3 == null) {
          break label725;
        }
        localObject3 = ((TelephonyManager)localObject3).getSimCountryIso();
        localObject1 = localObject3;
      }
      catch (Exception localException2)
      {
        Object localObject3;
        label127:
        for (;;) {}
        i = k.fM(aMW).wSA.getInt("tbs_download_version", 0);
      }
      if (localObject1 != null) {
        localObject3 = new JSONObject();
      }
    }
    try
    {
      ((JSONObject)localObject3).put("TIMEZONEID", localObject2);
      ((JSONObject)localObject3).put("COUNTRYISO", localObject1);
      ((JSONObject)localObject3).put("PROTOCOLVERSION", 1);
      if (!t.gu(aMW)) {
        break label750;
      }
      if (!QbSdk.wRb) {
        break label728;
      }
      i = t.ceG();
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        label190:
        label204:
        label269:
        label461:
        label572:
        label647:
        label725:
        label728:
        label750:
        continue;
        int j = 1;
        continue;
        j = 0;
        continue;
        j = 0;
        continue;
        String str1 = "x5.tbs.org";
        continue;
        int i = 1;
      }
    }
    if (paramBoolean1)
    {
      ((JSONObject)localObject3).put("FUNCTION", 2);
      if (t.gu(aMW))
      {
        localObject1 = cei();
        ((JSONObject)localObject3).put("TBSVLARR", localObject1);
        ((k)localObject4).wSz.put("last_thirdapp_sendrequest_coreversion", ((JSONArray)localObject1).toString());
        ((k)localObject4).commit();
        if (QbSdk.wRb) {
          ((JSONObject)localObject3).put("THIRDREQ", 1);
        }
        ((JSONObject)localObject3).put("APPN", aMW.getPackageName());
        ((JSONObject)localObject3).put("APPVN", Vo(((k)localObject4).wSA.getString("app_versionname", null)));
        ((JSONObject)localObject3).put("APPVC", ((k)localObject4).wSA.getInt("app_versioncode", 0));
        ((JSONObject)localObject3).put("APPMETA", Vo(((k)localObject4).wSA.getString("app_metadata", null)));
        ((JSONObject)localObject3).put("TBSSDKV", 43501);
        ((JSONObject)localObject3).put("TBSV", i);
        if (!paramBoolean3) {
          break label1019;
        }
        j = 1;
        ((JSONObject)localObject3).put("DOWNLOADDECOUPLECORE", j);
        localObject1 = ((k)localObject4).wSz;
        if (!paramBoolean3) {
          break label1025;
        }
        j = 1;
        ((Map)localObject1).put("tbs_downloaddecouplecore", Integer.valueOf(j));
        ((k)localObject4).commit();
        if (i != 0)
        {
          localObject1 = wSG;
          localObject2 = h.fI(((h)localObject1).mContext);
          if (localObject2 != null) {
            break label898;
          }
          j = 0;
          ((JSONObject)localObject3).put("TBSBACKUPV", j);
        }
        ((JSONObject)localObject3).put("CPU", wSD);
        ((JSONObject)localObject3).put("UA", str2);
        ((JSONObject)localObject3).put("IMSI", Vo(str3));
        ((JSONObject)localObject3).put("IMEI", Vo(str4));
        ((JSONObject)localObject3).put("ANDROID_ID", Vo(str5));
        if (!t.gu(aMW))
        {
          if (i == 0) {
            break label941;
          }
          if (!QbSdk.ag(aMW, i)) {
            break label1038;
          }
          i = 0;
          ((JSONObject)localObject3).put("STATUS", i);
          p.ceq();
          ((JSONObject)localObject3).put("TBSDV", p.gb(aMW));
        }
        paramBoolean3 = k.fM(aMW).wSA.getBoolean("request_full_package", false);
        localObject1 = QbSdk.c(aMW, "can_unlzma", null);
        if ((localObject1 == null) || (!(localObject1 instanceof Boolean))) {
          break label954;
        }
        paramBoolean1 = ((Boolean)localObject1).booleanValue();
        break label979;
        if (i != 0) {
          ((JSONObject)localObject3).put("REQUEST_LZMA", 1);
        }
        if (fP(aMW)) {
          ((JSONObject)localObject3).put("OVERSEA", 1);
        }
        if (paramBoolean2) {
          ((JSONObject)localObject3).put("DOWNLOAD_FOREGROUND", 1);
        }
        TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] jsonData=" + ((JSONObject)localObject3).toString());
        return (JSONObject)localObject3;
        j = p.ceq().ge(aMW);
        i = j;
        if (j == 0)
        {
          i = j;
          if (p.ceq().gd(aMW)) {
            i = -1;
          }
        }
        TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] tbsLocalVersion=" + i + " isDownloadForeground=" + paramBoolean2);
        if (!paramBoolean2) {
          break label959;
        }
        if (p.ceq().gd(aMW)) {
          break label976;
        }
        i = 0;
        break label976;
      }
    }
    for (;;)
    {
      localException2.put("FUNCTION", j);
      break label204;
      localObject1 = cen();
      if ((b.gN(aMW) == 3) || (((JSONArray)localObject1).length() == 0) || (i != 0) || (!paramBoolean1)) {
        break label269;
      }
      localException2.put("TBSBACKUPARR", localObject1);
      break label269;
      label898:
      localObject4 = ((h)localObject1).mContext;
      if (!fP(((h)localObject1).mContext)) {
        break label1031;
      }
      localObject1 = "x5.oversea.tbs.org";
      j = a.c((Context)localObject4, new File((File)localObject2, (String)localObject1));
      break label461;
      label941:
      localException2.put("STATUS", 0);
      break label572;
      label954:
      paramBoolean1 = false;
      break label979;
      label959:
      break label190;
      localObject1 = "";
      break label127;
      localObject2 = "";
      break;
      label976:
      break label190;
      label979:
      i = k;
      if (!paramBoolean1) {
        break label647;
      }
      i = k;
      if (paramBoolean3) {
        break label647;
      }
      i = 1;
      break label647;
      if (i != 0) {
        break label1013;
      }
      j = 0;
    }
  }
  
  public static boolean e(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest]isQuery: " + paramBoolean1 + " forDecoupleCore is " + paramBoolean3);
    if (p.ceq().fT(aMW))
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] -- isTbsLocalInstalled!");
      return false;
    }
    final k localk = k.fM(aMW);
    Object localObject2 = f.al(aMW, 1);
    Object localObject1;
    label84:
    Object localObject3;
    if (fP(aMW))
    {
      localObject1 = "x5.oversea.tbs.org";
      localObject2 = new File((String)localObject2, (String)localObject1);
      localObject3 = f.al(aMW, 2);
      if (!fP(aMW)) {
        break label591;
      }
      localObject1 = "x5.oversea.tbs.org";
      label119:
      localObject3 = new File((String)localObject3, (String)localObject1);
      Object localObject4 = f.al(aMW, 3);
      if (!fP(aMW)) {
        break label598;
      }
      localObject1 = "x5.oversea.tbs.org";
      label154:
      localObject4 = new File((String)localObject4, (String)localObject1);
      String str = f.al(aMW, 4);
      if (!fP(aMW)) {
        break label605;
      }
      localObject1 = "x5.oversea.tbs.org";
      label189:
      localObject1 = new File(str, (String)localObject1);
      if (!((File)localObject1).exists())
      {
        if (!((File)localObject4).exists()) {
          break label612;
        }
        ((File)localObject4).renameTo((File)localObject1);
      }
      label226:
      if (wSD == null)
      {
        wSD = c.ceW();
        localk.wSz.put("device_cpuabi", wSD);
        localk.commit();
      }
      if (TextUtils.isEmpty(wSD)) {
        break label732;
      }
      localObject1 = null;
    }
    try
    {
      localObject2 = Pattern.compile("i686|mips|x86_64").matcher(wSD);
      localObject1 = localObject2;
    }
    catch (Exception localException2)
    {
      label340:
      label378:
      label591:
      label598:
      label605:
      label612:
      for (;;) {}
    }
    if ((localObject1 != null) && (((Matcher)localObject1).find())) {
      if (t.gu(aMW))
      {
        r.gr(aMW);
        localObject1 = r.cet();
        if (paramBoolean1)
        {
          localk.CR(-104);
          ((r.b)localObject1).setErrorCode(-104);
          ((r.b)localObject1).Vs("mycpu is " + wSD);
          r.gr(aMW).a(r.a.wTs, (r.b)localObject1);
        }
      }
    }
    label732:
    for (int i = 1;; i = 0)
    {
      localObject1 = d(paramBoolean1, paramBoolean2, paramBoolean3);
      try
      {
        j = ((JSONObject)localObject1).getInt("TBSV");
        if ((i != 0) || (j != -1))
        {
          long l = System.currentTimeMillis();
          localk.wSz.put("last_check", Long.valueOf(l));
          localk.wSz.put("app_versionname", c.getAppVersionName(aMW));
          localk.wSz.put("app_versioncode", Integer.valueOf(c.getAppVersionCode(aMW)));
          localk.wSz.put("app_metadata", c.bC(aMW, "com.tencent.mm.BuildInfo.CLIENT_VERSION"));
          localk.commit();
          if (i != 0) {
            break;
          }
        }
        if (j == -1) {
          break;
        }
        try
        {
          localObject2 = com.tencent.smtt.utils.q.gZ(aMW).wWs;
          TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] postUrl=" + (String)localObject2);
          paramBoolean2 = c(g.a((String)localObject2, ((JSONObject)localObject1).toString().getBytes("utf-8"), new g.a()
          {
            public final void CV(int paramAnonymousInt)
            {
              TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] httpResponseCode=" + paramAnonymousInt);
              if (paramAnonymousInt >= 300)
              {
                if (this.wSN) {
                  localk.CR(-107);
                }
              }
              else {
                return;
              }
              localk.CR(65329);
            }
          }, false), j, paramBoolean1, paramBoolean2);
          return paramBoolean2;
        }
        catch (Throwable localThrowable)
        {
          if (!paramBoolean1) {
            continue;
          }
          localk.CR(-106);
          return false;
          localk.CR(65330);
          return false;
        }
        localObject1 = "x5.tbs.org";
        break label84;
        localObject1 = "x5.tbs.org";
        break label119;
        localObject1 = "x5.tbs.org";
        break label154;
        localObject1 = "x5.tbs.org";
        break label189;
        if (((File)localObject3).exists())
        {
          ((File)localObject3).renameTo((File)localObject1);
          break label226;
        }
        if (!((File)localObject2).exists()) {
          break label226;
        }
        ((File)localObject2).renameTo((File)localObject1);
        break label226;
        localk.CR(65331);
        ((r.b)localObject1).setErrorCode(65331);
        break label340;
        if (paramBoolean1)
        {
          localk.CR(-104);
          break label378;
        }
        localk.CR(65331);
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          int j = -1;
        }
      }
    }
  }
  
  public static boolean fN(Context paramContext)
  {
    boolean bool2 = true;
    aMW = paramContext.getApplicationContext();
    TbsLog.initIfNeed(paramContext);
    if (!a(aMW, false, null)) {}
    int i;
    do
    {
      return false;
      i = p.ceq().ge(paramContext);
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] localTbsVersion=" + i);
    } while (i > 0);
    if (c(aMW, false, true)) {
      return true;
    }
    paramContext = k.fM(aMW);
    boolean bool1 = paramContext.wSA.contains("tbs_needdownload");
    TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] hasNeedDownloadKey=" + bool1);
    if (!bool1)
    {
      bool1 = true;
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] needDownload=" + bool1);
      if ((!bool1) || (!cem())) {
        break label196;
      }
    }
    label196:
    for (bool1 = bool2;; bool1 = false)
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] ret=" + bool1);
      return bool1;
      bool1 = paramContext.wSA.getBoolean("tbs_needdownload", false);
      break;
    }
  }
  
  public static void fO(Context paramContext)
  {
    r(paramContext, false);
  }
  
  public static boolean fP(Context paramContext)
  {
    try
    {
      if (!wSL)
      {
        wSL = true;
        paramContext = k.fM(paramContext);
        if (paramContext.wSA.contains("is_oversea"))
        {
          wSK = paramContext.wSA.getBoolean("is_oversea", false);
          TbsLog.i("TbsDownload", "[TbsDownloader.getOverSea]  first called. sOverSea = " + wSK);
        }
        TbsLog.i("TbsDownload", "[TbsDownloader.getOverSea]  sOverSea = " + wSK);
      }
      boolean bool = wSK;
      return bool;
    }
    finally {}
  }
  
  @TargetApi(11)
  static void fQ(Context paramContext)
  {
    Object localObject = k.fM(paramContext);
    try
    {
      ((k)localObject).wSz.clear();
      localObject = ((k)localObject).wSA.edit();
      ((SharedPreferences.Editor)localObject).clear();
      ((SharedPreferences.Editor)localObject).commit();
      localObject = r.gr(paramContext);
      try
      {
        localObject = ((r)localObject).cey().edit();
        ((SharedPreferences.Editor)localObject).clear();
        ((SharedPreferences.Editor)localObject).commit();
        h.fK(paramContext);
        if (Build.VERSION.SDK_INT >= 11)
        {
          localObject = paramContext.getSharedPreferences("tbs_extension_config", 4);
          ((SharedPreferences)localObject).edit().clear().commit();
          if (Build.VERSION.SDK_INT < 11) {
            break label152;
          }
        }
        label152:
        for (paramContext = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);; paramContext = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0))
        {
          paramContext.edit().clear().commit();
          return;
          localObject = paramContext.getSharedPreferences("tbs_extension_config", 0);
          break;
        }
      }
      catch (Exception localException1)
      {
        for (;;) {}
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  public static boolean q(Context paramContext, boolean paramBoolean)
  {
    return a(paramContext, paramBoolean, false, null);
  }
  
  public static void r(Context paramContext, boolean paramBoolean)
  {
    int i = 1;
    for (;;)
    {
      try
      {
        TbsLog.i("TbsDownload", "[TbsDownloader.startDownload] sAppContext=" + aMW);
        boolean bool = p.wTg;
        if (bool) {
          return;
        }
        wSI = true;
        paramContext = paramContext.getApplicationContext();
        aMW = paramContext;
        k.fM(paramContext).CR(65336);
        if (Build.VERSION.SDK_INT < 8)
        {
          QbSdk.wRt.ir(110);
          k.fM(aMW).CR(65335);
          continue;
        }
        ceg();
      }
      finally {}
      if (!wSJ) {
        break;
      }
      QbSdk.wRt.ir(121);
      k.fM(aMW).CR(65334);
    }
    if (paramBoolean) {
      stopDownload();
    }
    wSC.removeMessages(101);
    wSC.removeMessages(100);
    paramContext = Message.obtain(wSC, 101, QbSdk.wRt);
    if (paramBoolean) {}
    for (;;)
    {
      paramContext.arg1 = i;
      paramContext.sendToTarget();
      break;
      i = 0;
    }
  }
  
  public static void stopDownload()
  {
    if (wSJ) {}
    do
    {
      return;
      TbsLog.i("TbsDownload", "[TbsDownloader.stopDownload]");
      if (wSG != null) {
        wSG.stopDownload();
      }
    } while (wSC == null);
    wSC.removeMessages(100);
    wSC.removeMessages(101);
    wSC.removeMessages(108);
  }
  
  public static abstract interface a
  {
    public abstract void e(boolean paramBoolean, int paramInt);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/sdk/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */