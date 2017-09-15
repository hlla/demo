package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.o;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"NewApi"})
public class QbSdk
{
  public static final int EXTENSION_INIT_FAILURE = -99999;
  public static final String LOGIN_TYPE_KEY_PARTNER_CALL_POS = "PosID";
  public static final String LOGIN_TYPE_KEY_PARTNER_ID = "ChannelID";
  public static final String PARAM_KEY_FEATUREID = "param_key_featureid";
  public static final String PARAM_KEY_FUNCTIONID = "param_key_functionid";
  public static final String PARAM_KEY_POSITIONID = "param_key_positionid";
  public static final int QBMODE = 2;
  public static final String SVNVERSION = "jnizz";
  public static final int TBSMODE = 1;
  public static final String TID_QQNumber_Prefix = "QQ:";
  public static final int VERSION = 1;
  public static q mTbsListener = null;
  public static q mTbsListenerForInit = null;
  public static boolean sIsVersionPrinted = false;
  static long sWifiConnectedTime;
  private static int wQV = 0;
  private static String wQW = "";
  private static Class<?> wQX;
  private static Object wQY;
  static boolean wQZ = false;
  static boolean wRa = false;
  static boolean wRb = true;
  private static boolean wRc = false;
  private static String[] wRd;
  private static String wRe = "NULL";
  private static String wRf = "UNKNOWN";
  static String wRg;
  static boolean wRh = false;
  static long wRi = 0L;
  static Object wRj;
  static boolean wRk;
  private static int wRl;
  private static int wRm;
  private static String wRn;
  private static String wRo;
  static volatile boolean wRp;
  private static boolean wRq;
  private static boolean wRr = false;
  private static boolean wRs = false;
  static q wRt = new q()
  {
    public final void ir(int paramAnonymousInt)
    {
      if (l.ced())
      {
        TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is true", true);
        l.wSI = true;
      }
      do
      {
        return;
        TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is false", true);
        l.wSI = false;
        if (QbSdk.mTbsListener != null) {
          QbSdk.mTbsListener.ir(paramAnonymousInt);
        }
      } while (QbSdk.mTbsListenerForInit == null);
      QbSdk.mTbsListenerForInit.ir(paramAnonymousInt);
    }
    
    public final void is(int paramAnonymousInt)
    {
      QbSdk.setTBSInstallingStatus(false);
      l.wSI = false;
      if (l.cee()) {}
      for (l.wSI = true;; l.wSI = false)
      {
        if (QbSdk.mTbsListener != null) {
          QbSdk.mTbsListener.is(paramAnonymousInt);
        }
        if (QbSdk.mTbsListenerForInit != null) {
          QbSdk.mTbsListenerForInit.is(paramAnonymousInt);
        }
        return;
      }
    }
    
    public final void it(int paramAnonymousInt)
    {
      if (QbSdk.mTbsListenerForInit != null) {
        QbSdk.mTbsListenerForInit.it(paramAnonymousInt);
      }
      if (QbSdk.mTbsListener != null) {
        QbSdk.mTbsListener.it(paramAnonymousInt);
      }
    }
  };
  static Map<String, Object> wRu = null;
  
  static
  {
    sWifiConnectedTime = 0L;
    wRj = new Object();
    wRk = true;
    wRl = 0;
    wRm = 170;
    wRn = null;
    wRo = null;
    wRp = wQZ;
    wRq = true;
  }
  
  static boolean ag(Context paramContext, int paramInt)
  {
    if (fE(paramContext))
    {
      paramContext = o.a(wQY, "isX5Disabled", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(43501), Integer.valueOf(20000) });
      if (paramContext != null) {
        return ((Boolean)paramContext).booleanValue();
      }
      paramContext = o.a(wQY, "isX5Disabled", new Class[] { Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(43501) });
      if (paramContext != null) {
        return ((Boolean)paramContext).booleanValue();
      }
    }
    return true;
  }
  
  /* Error */
  static void bu(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 105	com/tencent/smtt/sdk/QbSdk:wQZ	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: iconst_1
    //   16: putstatic 105	com/tencent/smtt/sdk/QbSdk:wQZ	Z
    //   19: new 195	java/lang/StringBuilder
    //   22: dup
    //   23: ldc -59
    //   25: invokespecial 200	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   28: aload_1
    //   29: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: putstatic 119	com/tencent/smtt/sdk/QbSdk:wRf	Ljava/lang/String;
    //   38: ldc -46
    //   40: new 195	java/lang/StringBuilder
    //   43: dup
    //   44: ldc -44
    //   46: invokespecial 200	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   49: getstatic 119	com/tencent/smtt/sdk/QbSdk:wRf	Ljava/lang/String;
    //   52: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 218	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: invokestatic 224	com/tencent/smtt/sdk/i:cdS	()Lcom/tencent/smtt/sdk/i;
    //   64: aload_0
    //   65: sipush 401
    //   68: new 226	java/lang/Throwable
    //   71: dup
    //   72: getstatic 119	com/tencent/smtt/sdk/QbSdk:wRf	Ljava/lang/String;
    //   75: invokespecial 227	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   78: invokevirtual 230	com/tencent/smtt/sdk/i:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   81: goto -70 -> 11
    //   84: astore_0
    //   85: ldc 2
    //   87: monitorexit
    //   88: aload_0
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramContext	Context
    //   0	90	1	paramString	String
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	7	84	finally
    //   15	81	84	finally
  }
  
  static Object c(Context paramContext, String paramString, Bundle paramBundle)
  {
    if (!fD(paramContext)) {
      paramContext = Integer.valueOf(-99999);
    }
    do
    {
      return paramContext;
      paramString = o.a(wQY, "miscCall", new Class[] { String.class, Bundle.class }, new Object[] { paramString, paramBundle });
      paramContext = paramString;
    } while (paramString != null);
    return null;
  }
  
  public static boolean canLoadVideo(Context paramContext)
  {
    Object localObject = o.a(wQY, "canLoadVideo", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(0) });
    if (localObject != null) {
      if (!((Boolean)localObject).booleanValue()) {
        i.cdS().ai(paramContext, 313);
      }
    }
    while (localObject == null)
    {
      return false;
      i.cdS().ai(paramContext, 314);
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  public static boolean canLoadX5(Context paramContext)
  {
    return p(paramContext, false);
  }
  
  public static boolean canLoadX5FirstTimeThirdApp(Context paramContext)
  {
    try
    {
      if (wQX == null)
      {
        p.ceq();
        File localFile1 = p.gk(paramContext);
        if (localFile1 == null)
        {
          TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) optDir == null");
          return false;
        }
        File localFile2 = new File(t.ceE(), "tbs_sdk_extension_dex.jar");
        if (!localFile2.exists())
        {
          TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) dexFile.exists()=false", true);
          return false;
        }
        wQX = new DexClassLoader(localFile2.getAbsolutePath(), localFile1.getAbsolutePath(), localFile2.getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
      }
      if (wQY == null)
      {
        if (t.ceA() == null)
        {
          r.gr(paramContext.getApplicationContext()).aM(227, "host context is null!");
          return false;
        }
        wQX.getConstructor(new Class[] { Context.class, Context.class });
        wQY = wQX.getConstructor(new Class[] { Context.class, Context.class, String.class }).newInstance(new Object[] { paramContext, null, t.ceA() });
      }
      paramContext = o.a(wQY, "canLoadX5CoreForThirdApp", new Class[0], new Object[0]);
      if ((paramContext != null) && ((paramContext instanceof Boolean)))
      {
        boolean bool = ((Boolean)paramContext).booleanValue();
        return bool;
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "canLoadX5FirstTimeThirdApp sys WebView: " + Log.getStackTraceString(paramContext));
    }
    return false;
  }
  
  public static void canOpenFile(Context paramContext, final String paramString, final y<Boolean> paramy)
  {
    new Thread()
    {
      public final void run()
      {
        Object localObject = ac.ceR();
        ((ac)localObject).b(this.val$context, null);
        final boolean bool;
        if (((ac)localObject).ceS())
        {
          localObject = ((ac)localObject).ceT();
          Context localContext = this.val$context;
          String str = paramString;
          localObject = ((ad)localObject).wUo.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "canOpenFile", new Class[] { Context.class, String.class }, new Object[] { localContext, str });
          if ((localObject instanceof Boolean)) {
            bool = ((Boolean)localObject).booleanValue();
          }
        }
        for (;;)
        {
          new Handler(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              QbSdk.1.this.wRv.onReceiveValue(Boolean.valueOf(bool));
            }
          });
          return;
          bool = false;
          continue;
          bool = false;
        }
      }
    }.start();
  }
  
  public static boolean canOpenMimeFileType(Context paramContext, String paramString)
  {
    if (!o(paramContext, false)) {}
    return false;
  }
  
  /* Error */
  public static boolean canOpenWebPlus(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 5
    //   6: getstatic 134	com/tencent/smtt/sdk/QbSdk:wRl	I
    //   9: ifne +9 -> 18
    //   12: invokestatic 368	com/tencent/smtt/sdk/a:cdF	()I
    //   15: putstatic 134	com/tencent/smtt/sdk/QbSdk:wRl	I
    //   18: ldc -46
    //   20: new 195	java/lang/StringBuilder
    //   23: dup
    //   24: ldc_w 370
    //   27: invokespecial 200	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   30: getstatic 134	com/tencent/smtt/sdk/QbSdk:wRl	I
    //   33: invokevirtual 373	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 376	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: getstatic 381	android/os/Build$VERSION:SDK_INT	I
    //   45: bipush 7
    //   47: if_icmplt +12 -> 59
    //   50: getstatic 134	com/tencent/smtt/sdk/QbSdk:wRl	I
    //   53: getstatic 136	com/tencent/smtt/sdk/QbSdk:wRm	I
    //   56: if_icmpge +5 -> 61
    //   59: iconst_0
    //   60: ireturn
    //   61: aload_0
    //   62: ifnull -3 -> 59
    //   65: invokestatic 261	com/tencent/smtt/sdk/p:ceq	()Lcom/tencent/smtt/sdk/p;
    //   68: pop
    //   69: new 383	java/io/BufferedInputStream
    //   72: dup
    //   73: new 385	java/io/FileInputStream
    //   76: dup
    //   77: new 269	java/io/File
    //   80: dup
    //   81: aload_0
    //   82: invokestatic 265	com/tencent/smtt/sdk/p:gk	(Landroid/content/Context;)Ljava/io/File;
    //   85: ldc_w 387
    //   88: invokespecial 390	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   91: invokespecial 393	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   94: invokespecial 396	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   97: astore 6
    //   99: aload 6
    //   101: astore 5
    //   103: new 398	java/util/Properties
    //   106: dup
    //   107: invokespecial 399	java/util/Properties:<init>	()V
    //   110: astore 8
    //   112: aload 6
    //   114: astore 5
    //   116: aload 8
    //   118: aload 6
    //   120: invokevirtual 402	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   123: aload 6
    //   125: astore 5
    //   127: aload 8
    //   129: ldc_w 404
    //   132: invokevirtual 408	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   135: astore 9
    //   137: aload 6
    //   139: astore 5
    //   141: aload 8
    //   143: ldc_w 410
    //   146: invokevirtual 408	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   149: astore 10
    //   151: aload 6
    //   153: astore 5
    //   155: aload 9
    //   157: invokestatic 414	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   160: istore_1
    //   161: aload 6
    //   163: astore 5
    //   165: aload 10
    //   167: invokestatic 414	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   170: istore_2
    //   171: aload 6
    //   173: astore 5
    //   175: getstatic 417	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   178: invokestatic 414	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   181: istore_3
    //   182: iload_3
    //   183: iload_1
    //   184: if_icmpgt +8 -> 192
    //   187: iload_3
    //   188: iload_2
    //   189: if_icmpge +39 -> 228
    //   192: aload 6
    //   194: astore 5
    //   196: ldc -46
    //   198: new 195	java/lang/StringBuilder
    //   201: dup
    //   202: ldc_w 419
    //   205: invokespecial 200	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   208: iload_3
    //   209: invokevirtual 373	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   212: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 376	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: aload 6
    //   220: invokevirtual 422	java/io/BufferedInputStream:close	()V
    //   223: iconst_0
    //   224: ireturn
    //   225: astore_0
    //   226: iconst_0
    //   227: ireturn
    //   228: aload 6
    //   230: astore 5
    //   232: aload 8
    //   234: ldc_w 424
    //   237: invokevirtual 408	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   240: invokestatic 414	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   243: istore_1
    //   244: aload 6
    //   246: invokevirtual 422	java/io/BufferedInputStream:close	()V
    //   249: new 385	java/io/FileInputStream
    //   252: dup
    //   253: new 269	java/io/File
    //   256: dup
    //   257: aload_0
    //   258: invokestatic 427	com/tencent/smtt/sdk/p:gm	(Landroid/content/Context;)Ljava/io/File;
    //   261: ldc_w 429
    //   264: invokespecial 390	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   267: invokespecial 393	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   270: astore 5
    //   272: new 398	java/util/Properties
    //   275: dup
    //   276: invokespecial 399	java/util/Properties:<init>	()V
    //   279: astore 6
    //   281: aload 6
    //   283: aload 5
    //   285: invokevirtual 402	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   288: aload 6
    //   290: ldc_w 431
    //   293: invokevirtual 408	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   296: invokestatic 414	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   299: istore_2
    //   300: aload 6
    //   302: ldc_w 433
    //   305: invokevirtual 408	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   308: invokestatic 414	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   311: istore_3
    //   312: iload_1
    //   313: ldc_w 434
    //   316: if_icmpeq +10 -> 326
    //   319: iload_2
    //   320: ldc_w 434
    //   323: if_icmpne +56 -> 379
    //   326: iconst_0
    //   327: istore_1
    //   328: aload 5
    //   330: invokevirtual 437	java/io/InputStream:close	()V
    //   333: iload_1
    //   334: ifne -275 -> 59
    //   337: iconst_1
    //   338: ireturn
    //   339: astore_0
    //   340: aconst_null
    //   341: astore_0
    //   342: aload_0
    //   343: astore 5
    //   345: ldc -46
    //   347: ldc_w 439
    //   350: invokestatic 376	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   353: aload_0
    //   354: ifnull -295 -> 59
    //   357: aload_0
    //   358: invokevirtual 422	java/io/BufferedInputStream:close	()V
    //   361: iconst_0
    //   362: ireturn
    //   363: astore_0
    //   364: iconst_0
    //   365: ireturn
    //   366: astore_0
    //   367: aload 5
    //   369: ifnull +8 -> 377
    //   372: aload 5
    //   374: invokevirtual 422	java/io/BufferedInputStream:close	()V
    //   377: aload_0
    //   378: athrow
    //   379: iload_1
    //   380: iload_2
    //   381: if_icmple +8 -> 389
    //   384: iconst_0
    //   385: istore_1
    //   386: goto -58 -> 328
    //   389: iload_1
    //   390: iload_2
    //   391: if_icmpne +169 -> 560
    //   394: iload_3
    //   395: ifle +16 -> 411
    //   398: iload_3
    //   399: aload_0
    //   400: invokestatic 445	com/tencent/smtt/utils/c:getAppVersionCode	(Landroid/content/Context;)I
    //   403: if_icmpeq +8 -> 411
    //   406: iconst_0
    //   407: istore_1
    //   408: goto -80 -> 328
    //   411: aload 6
    //   413: ldc_w 447
    //   416: invokevirtual 408	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   419: invokestatic 451	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   422: ifeq +34 -> 456
    //   425: aload_0
    //   426: invokevirtual 313	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   429: invokestatic 457	com/tencent/smtt/sdk/k:fM	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   432: getfield 461	com/tencent/smtt/sdk/k:wSA	Landroid/content/SharedPreferences;
    //   435: ldc_w 463
    //   438: iconst_0
    //   439: invokeinterface 469 3 0
    //   444: istore 4
    //   446: iload 4
    //   448: ifne +8 -> 456
    //   451: iconst_1
    //   452: istore_1
    //   453: goto -125 -> 328
    //   456: iconst_0
    //   457: istore_1
    //   458: goto -130 -> 328
    //   461: astore_0
    //   462: aload 7
    //   464: astore_0
    //   465: ldc -46
    //   467: ldc_w 471
    //   470: invokestatic 376	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   473: aload_0
    //   474: ifnull +7 -> 481
    //   477: aload_0
    //   478: invokevirtual 437	java/io/InputStream:close	()V
    //   481: iconst_1
    //   482: istore_1
    //   483: goto -150 -> 333
    //   486: astore_0
    //   487: iconst_1
    //   488: istore_1
    //   489: goto -156 -> 333
    //   492: astore_0
    //   493: aconst_null
    //   494: astore 5
    //   496: aload 5
    //   498: ifnull +8 -> 506
    //   501: aload 5
    //   503: invokevirtual 437	java/io/InputStream:close	()V
    //   506: aload_0
    //   507: athrow
    //   508: astore 5
    //   510: goto -261 -> 249
    //   513: astore 5
    //   515: goto -138 -> 377
    //   518: astore_0
    //   519: goto -186 -> 333
    //   522: astore 5
    //   524: goto -18 -> 506
    //   527: astore_0
    //   528: goto -32 -> 496
    //   531: astore 6
    //   533: aload_0
    //   534: astore 5
    //   536: aload 6
    //   538: astore_0
    //   539: goto -43 -> 496
    //   542: astore_0
    //   543: aload 5
    //   545: astore_0
    //   546: goto -81 -> 465
    //   549: astore_0
    //   550: goto -183 -> 367
    //   553: astore_0
    //   554: aload 6
    //   556: astore_0
    //   557: goto -215 -> 342
    //   560: iconst_0
    //   561: istore_1
    //   562: goto -234 -> 328
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	565	0	paramContext	Context
    //   160	402	1	i	int
    //   170	222	2	j	int
    //   181	223	3	k	int
    //   444	3	4	bool	boolean
    //   4	498	5	localObject1	Object
    //   508	1	5	localException1	Exception
    //   513	1	5	localException2	Exception
    //   522	1	5	localException3	Exception
    //   534	10	5	localContext	Context
    //   97	315	6	localObject2	Object
    //   531	24	6	localObject3	Object
    //   1	462	7	localObject4	Object
    //   110	123	8	localProperties	java.util.Properties
    //   135	21	9	str1	String
    //   149	17	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   218	223	225	java/lang/Exception
    //   65	99	339	java/lang/Throwable
    //   357	361	363	java/lang/Exception
    //   65	99	366	finally
    //   249	272	461	java/lang/Throwable
    //   477	481	486	java/lang/Exception
    //   249	272	492	finally
    //   244	249	508	java/lang/Exception
    //   372	377	513	java/lang/Exception
    //   328	333	518	java/lang/Exception
    //   501	506	522	java/lang/Exception
    //   272	312	527	finally
    //   398	406	527	finally
    //   411	446	527	finally
    //   465	473	531	finally
    //   272	312	542	java/lang/Throwable
    //   398	406	542	java/lang/Throwable
    //   411	446	542	java/lang/Throwable
    //   103	112	549	finally
    //   116	123	549	finally
    //   127	137	549	finally
    //   141	151	549	finally
    //   155	161	549	finally
    //   165	171	549	finally
    //   175	182	549	finally
    //   196	218	549	finally
    //   232	244	549	finally
    //   345	353	549	finally
    //   103	112	553	java/lang/Throwable
    //   116	123	553	java/lang/Throwable
    //   127	137	553	java/lang/Throwable
    //   141	151	553	java/lang/Throwable
    //   155	161	553	java/lang/Throwable
    //   165	171	553	java/lang/Throwable
    //   175	182	553	java/lang/Throwable
    //   196	218	553	java/lang/Throwable
    //   232	244	553	java/lang/Throwable
  }
  
  public static boolean canUseVideoFeatrue(Context paramContext, int paramInt)
  {
    paramContext = o.a(wQY, "canUseVideoFeatrue", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
    if ((paramContext != null) && ((paramContext instanceof Boolean))) {
      return ((Boolean)paramContext).booleanValue();
    }
    return false;
  }
  
  static String cdG()
  {
    return wQW;
  }
  
  protected static String cdH()
  {
    Object localObject = ac.ceR();
    if ((localObject != null) && (((ac)localObject).ceS()))
    {
      localObject = ((ac)localObject).ceT().wUo.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getGUID", new Class[0], new Object[0]);
      if ((localObject != null) && ((localObject instanceof String))) {
        return (String)localObject;
      }
    }
    return null;
  }
  
  public static void clear(Context paramContext) {}
  
  /* Error */
  public static void clearAllWebViewCache(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 510	android/webkit/WebView
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 512	android/webkit/WebView:<init>	(Landroid/content/Context;)V
    //   8: astore_2
    //   9: getstatic 381	android/os/Build$VERSION:SDK_INT	I
    //   12: bipush 11
    //   14: if_icmplt +24 -> 38
    //   17: aload_2
    //   18: ldc_w 514
    //   21: invokevirtual 517	android/webkit/WebView:removeJavascriptInterface	(Ljava/lang/String;)V
    //   24: aload_2
    //   25: ldc_w 519
    //   28: invokevirtual 517	android/webkit/WebView:removeJavascriptInterface	(Ljava/lang/String;)V
    //   31: aload_2
    //   32: ldc_w 521
    //   35: invokevirtual 517	android/webkit/WebView:removeJavascriptInterface	(Ljava/lang/String;)V
    //   38: aload_2
    //   39: iconst_1
    //   40: invokevirtual 525	android/webkit/WebView:clearCache	(Z)V
    //   43: iload_1
    //   44: ifeq +14 -> 58
    //   47: aload_0
    //   48: invokestatic 531	android/webkit/CookieSyncManager:createInstance	(Landroid/content/Context;)Landroid/webkit/CookieSyncManager;
    //   51: pop
    //   52: invokestatic 537	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   55: invokevirtual 540	android/webkit/CookieManager:removeAllCookie	()V
    //   58: aload_0
    //   59: invokestatic 545	android/webkit/WebViewDatabase:getInstance	(Landroid/content/Context;)Landroid/webkit/WebViewDatabase;
    //   62: invokevirtual 548	android/webkit/WebViewDatabase:clearUsernamePassword	()V
    //   65: aload_0
    //   66: invokestatic 545	android/webkit/WebViewDatabase:getInstance	(Landroid/content/Context;)Landroid/webkit/WebViewDatabase;
    //   69: invokevirtual 551	android/webkit/WebViewDatabase:clearHttpAuthUsernamePassword	()V
    //   72: aload_0
    //   73: invokestatic 545	android/webkit/WebViewDatabase:getInstance	(Landroid/content/Context;)Landroid/webkit/WebViewDatabase;
    //   76: invokevirtual 554	android/webkit/WebViewDatabase:clearFormData	()V
    //   79: invokestatic 559	android/webkit/WebStorage:getInstance	()Landroid/webkit/WebStorage;
    //   82: invokevirtual 562	android/webkit/WebStorage:deleteAllData	()V
    //   85: invokestatic 567	android/webkit/WebIconDatabase:getInstance	()Landroid/webkit/WebIconDatabase;
    //   88: invokevirtual 570	android/webkit/WebIconDatabase:removeAllIcons	()V
    //   91: new 572	com/tencent/smtt/sdk/WebView
    //   94: dup
    //   95: aload_0
    //   96: invokespecial 573	com/tencent/smtt/sdk/WebView:<init>	(Landroid/content/Context;)V
    //   99: invokevirtual 577	com/tencent/smtt/sdk/WebView:getWebViewClientExtension	()Lcom/tencent/smtt/export/external/extension/interfaces/IX5WebViewClientExtension;
    //   102: ifnull +68 -> 170
    //   105: invokestatic 481	com/tencent/smtt/sdk/ac:ceR	()Lcom/tencent/smtt/sdk/ac;
    //   108: astore_2
    //   109: aload_2
    //   110: ifnull +60 -> 170
    //   113: aload_2
    //   114: invokevirtual 484	com/tencent/smtt/sdk/ac:ceS	()Z
    //   117: ifeq +53 -> 170
    //   120: aload_2
    //   121: invokevirtual 488	com/tencent/smtt/sdk/ac:ceT	()Lcom/tencent/smtt/sdk/ad;
    //   124: astore_2
    //   125: ldc_w 579
    //   128: ldc_w 581
    //   131: invokestatic 584	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: iload_1
    //   135: ifeq +65 -> 200
    //   138: aload_2
    //   139: getfield 494	com/tencent/smtt/sdk/ad:wUo	Lcom/tencent/smtt/export/external/DexLoader;
    //   142: ldc_w 496
    //   145: ldc_w 586
    //   148: iconst_1
    //   149: anewarray 170	java/lang/Class
    //   152: dup
    //   153: iconst_0
    //   154: ldc_w 309
    //   157: aastore
    //   158: iconst_1
    //   159: anewarray 4	java/lang/Object
    //   162: dup
    //   163: iconst_0
    //   164: aload_0
    //   165: aastore
    //   166: invokevirtual 504	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   169: pop
    //   170: return
    //   171: astore_2
    //   172: ldc -46
    //   174: new 195	java/lang/StringBuilder
    //   177: dup
    //   178: ldc_w 588
    //   181: invokespecial 200	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   184: aload_2
    //   185: invokestatic 345	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   188: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 218	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: goto -106 -> 91
    //   200: aload_2
    //   201: getfield 494	com/tencent/smtt/sdk/ad:wUo	Lcom/tencent/smtt/export/external/DexLoader;
    //   204: ldc_w 496
    //   207: ldc_w 586
    //   210: iconst_2
    //   211: anewarray 170	java/lang/Class
    //   214: dup
    //   215: iconst_0
    //   216: ldc_w 309
    //   219: aastore
    //   220: dup
    //   221: iconst_1
    //   222: getstatic 589	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   225: aastore
    //   226: iconst_2
    //   227: anewarray 4	java/lang/Object
    //   230: dup
    //   231: iconst_0
    //   232: aload_0
    //   233: aastore
    //   234: dup
    //   235: iconst_1
    //   236: iload_1
    //   237: invokestatic 592	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   240: aastore
    //   241: invokevirtual 504	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   244: pop
    //   245: return
    //   246: astore_3
    //   247: aload_2
    //   248: getfield 494	com/tencent/smtt/sdk/ad:wUo	Lcom/tencent/smtt/export/external/DexLoader;
    //   251: ldc_w 496
    //   254: ldc_w 594
    //   257: iconst_1
    //   258: anewarray 170	java/lang/Class
    //   261: dup
    //   262: iconst_0
    //   263: ldc_w 309
    //   266: aastore
    //   267: iconst_1
    //   268: anewarray 4	java/lang/Object
    //   271: dup
    //   272: iconst_0
    //   273: aload_0
    //   274: aastore
    //   275: invokevirtual 504	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   278: pop
    //   279: aload_2
    //   280: getfield 494	com/tencent/smtt/sdk/ad:wUo	Lcom/tencent/smtt/export/external/DexLoader;
    //   283: ldc_w 496
    //   286: ldc_w 596
    //   289: iconst_1
    //   290: anewarray 170	java/lang/Class
    //   293: dup
    //   294: iconst_0
    //   295: ldc_w 309
    //   298: aastore
    //   299: iconst_1
    //   300: anewarray 4	java/lang/Object
    //   303: dup
    //   304: iconst_0
    //   305: aload_0
    //   306: aastore
    //   307: invokevirtual 504	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   310: pop
    //   311: aload_2
    //   312: getfield 494	com/tencent/smtt/sdk/ad:wUo	Lcom/tencent/smtt/export/external/DexLoader;
    //   315: ldc_w 496
    //   318: ldc_w 598
    //   321: iconst_1
    //   322: anewarray 170	java/lang/Class
    //   325: dup
    //   326: iconst_0
    //   327: ldc_w 309
    //   330: aastore
    //   331: iconst_1
    //   332: anewarray 4	java/lang/Object
    //   335: dup
    //   336: iconst_0
    //   337: aload_0
    //   338: aastore
    //   339: invokevirtual 504	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   342: pop
    //   343: aload_2
    //   344: getfield 494	com/tencent/smtt/sdk/ad:wUo	Lcom/tencent/smtt/export/external/DexLoader;
    //   347: ldc_w 600
    //   350: ldc_w 602
    //   353: aconst_null
    //   354: iconst_0
    //   355: anewarray 4	java/lang/Object
    //   358: invokevirtual 504	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   361: pop
    //   362: aload_2
    //   363: getfield 494	com/tencent/smtt/sdk/ad:wUo	Lcom/tencent/smtt/export/external/DexLoader;
    //   366: ldc_w 600
    //   369: ldc_w 604
    //   372: aconst_null
    //   373: iconst_0
    //   374: anewarray 4	java/lang/Object
    //   377: invokevirtual 504	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   380: pop
    //   381: aload_2
    //   382: getfield 494	com/tencent/smtt/sdk/ad:wUo	Lcom/tencent/smtt/export/external/DexLoader;
    //   385: ldc_w 606
    //   388: ldc_w 607
    //   391: aconst_null
    //   392: iconst_0
    //   393: anewarray 4	java/lang/Object
    //   396: invokevirtual 504	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   399: astore_0
    //   400: aload_0
    //   401: ifnull +23 -> 424
    //   404: aload_2
    //   405: getfield 494	com/tencent/smtt/sdk/ad:wUo	Lcom/tencent/smtt/export/external/DexLoader;
    //   408: aload_0
    //   409: ldc_w 606
    //   412: ldc_w 609
    //   415: aconst_null
    //   416: iconst_0
    //   417: anewarray 4	java/lang/Object
    //   420: invokevirtual 613	com/tencent/smtt/export/external/DexLoader:invokeMethod	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   423: pop
    //   424: aload_2
    //   425: getfield 494	com/tencent/smtt/sdk/ad:wUo	Lcom/tencent/smtt/export/external/DexLoader;
    //   428: ldc_w 615
    //   431: ldc_w 607
    //   434: aconst_null
    //   435: iconst_0
    //   436: anewarray 4	java/lang/Object
    //   439: invokevirtual 504	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   442: astore_0
    //   443: aload_0
    //   444: ifnull +23 -> 467
    //   447: aload_2
    //   448: getfield 494	com/tencent/smtt/sdk/ad:wUo	Lcom/tencent/smtt/export/external/DexLoader;
    //   451: aload_0
    //   452: ldc_w 615
    //   455: ldc_w 617
    //   458: aconst_null
    //   459: iconst_0
    //   460: anewarray 4	java/lang/Object
    //   463: invokevirtual 613	com/tencent/smtt/export/external/DexLoader:invokeMethod	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   466: pop
    //   467: aload_2
    //   468: getfield 494	com/tencent/smtt/sdk/ad:wUo	Lcom/tencent/smtt/export/external/DexLoader;
    //   471: ldc_w 496
    //   474: ldc_w 618
    //   477: aconst_null
    //   478: iconst_0
    //   479: anewarray 4	java/lang/Object
    //   482: invokevirtual 504	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   485: pop
    //   486: return
    //   487: astore_0
    //   488: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	489	0	paramContext	Context
    //   0	489	1	paramBoolean	boolean
    //   8	131	2	localObject	Object
    //   171	297	2	localThrowable	Throwable
    //   246	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	38	171	java/lang/Throwable
    //   38	43	171	java/lang/Throwable
    //   47	58	171	java/lang/Throwable
    //   58	91	171	java/lang/Throwable
    //   200	245	246	java/lang/Exception
    //   91	109	487	java/lang/Throwable
    //   113	134	487	java/lang/Throwable
    //   138	170	487	java/lang/Throwable
    //   200	245	487	java/lang/Throwable
    //   247	400	487	java/lang/Throwable
    //   404	424	487	java/lang/Throwable
    //   424	443	487	java/lang/Throwable
    //   447	467	487	java/lang/Throwable
    //   467	486	487	java/lang/Throwable
  }
  
  public static void closeFileReader(Context paramContext)
  {
    ac localac = ac.ceR();
    localac.b(paramContext, null);
    if (localac.ceS()) {
      localac.ceT().wUo.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeFileReader", new Class[0], new Object[0]);
    }
  }
  
  public static boolean createMiniQBShortCut(Context paramContext, String paramString1, String paramString2, Drawable paramDrawable)
  {
    if (paramContext == null) {
      return false;
    }
    if (l.fP(paramContext)) {
      return false;
    }
    if (isMiniQBShortCutExist(paramContext, paramString1, paramString2) == true) {
      return false;
    }
    ac localac = ac.ceR();
    if ((localac != null) && (localac.ceS()))
    {
      Bitmap localBitmap = null;
      if ((paramDrawable instanceof BitmapDrawable)) {
        localBitmap = ((BitmapDrawable)paramDrawable).getBitmap();
      }
      paramDrawable = localac.ceT().wUo;
      TbsLog.e("QbSdk", "qbsdk createMiniQBShortCut");
      paramContext = paramDrawable.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createMiniQBShortCut", new Class[] { Context.class, String.class, String.class, Bitmap.class }, new Object[] { paramContext, paramString1, paramString2, localBitmap });
      TbsLog.e("QbSdk", "qbsdk after createMiniQBShortCut ret: " + paramContext);
      return paramContext != null;
    }
    return false;
  }
  
  public static boolean deleteMiniQBShortCut(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {}
    ac localac;
    do
    {
      do
      {
        do
        {
          return false;
        } while (l.fP(paramContext));
        localac = ac.ceR();
      } while ((localac == null) || (!localac.ceS()));
    } while (localac.ceT().wUo.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "deleteMiniQBShortCut", new Class[] { Context.class, String.class, String.class }, new Object[] { paramContext, paramString1, paramString2 }) == null);
    return true;
  }
  
  public static void disAllowThirdAppDownload()
  {
    wRb = false;
  }
  
  static Bundle e(Context paramContext, Bundle paramBundle)
  {
    if (!fD(paramContext))
    {
      r.gr(paramContext).aL(216, "initForPatch return false!");
      return null;
    }
    paramBundle = o.a(wQY, "incrUpdate", new Class[] { Context.class, Bundle.class }, new Object[] { paramContext, paramBundle });
    if (paramBundle != null) {
      return (Bundle)paramBundle;
    }
    r.gr(paramContext).aL(216, "incrUpdate return null!");
    return null;
  }
  
  private static boolean fD(Context paramContext)
  {
    try
    {
      if (wQX != null) {
        return true;
      }
      p.ceq();
      Object localObject = p.gk(paramContext);
      if (localObject == null)
      {
        TbsLog.e("QbSdk", "QbSdk initExtension (false) optDir == null");
        return false;
      }
      File localFile = new File((File)localObject, "tbs_sdk_extension_dex.jar");
      if (!localFile.exists())
      {
        TbsLog.e("QbSdk", "QbSdk initExtension (false) dexFile.exists()=false", true);
        return false;
      }
      localObject = new DexClassLoader(localFile.getAbsolutePath(), ((File)localObject).getAbsolutePath(), localFile.getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
      wQX = (Class)localObject;
      wQY = ((Class)localObject).getConstructor(new Class[] { Context.class, Context.class }).newInstance(new Object[] { paramContext, paramContext });
      return true;
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "initExtension sys WebView: " + Log.getStackTraceString(paramContext));
    }
    return false;
  }
  
  private static boolean fE(Context paramContext)
  {
    for (;;)
    {
      Object localObject1;
      try
      {
        if (wQX != null) {
          return true;
        }
        p.ceq();
        localObject1 = p.gk(paramContext);
        if (localObject1 == null)
        {
          TbsLog.e("QbSdk", "QbSdk initForX5DisableConfig (false) optDir == null");
          return false;
        }
        if (t.gu(paramContext))
        {
          i.cdS().ai(paramContext, 304);
          return false;
        }
        p.ceq();
        Object localObject2 = new File(p.gk(paramContext), "tbs_sdk_extension_dex.jar");
        if (!((File)localObject2).exists())
        {
          i.cdS().a(paramContext, 406, new Exception("initForX5DisableConfig failure -- tbs_sdk_extension_dex.jar is not exist!"));
          return false;
        }
        localObject1 = new DexClassLoader(((File)localObject2).getAbsolutePath(), ((File)localObject1).getAbsolutePath(), ((File)localObject2).getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
        wQX = (Class)localObject1;
        localObject1 = ((Class)localObject1).getConstructor(new Class[] { Context.class, Context.class });
        if (t.gu(paramContext))
        {
          if (t.ceA() == null)
          {
            r.gr(paramContext.getApplicationContext()).aM(227, "host context is null!");
            return false;
          }
          wQY = wQX.getConstructor(new Class[] { Context.class, Context.class, String.class }).newInstance(new Object[] { paramContext, null, t.ceA() });
          paramContext = wQY;
          localObject1 = com.tencent.smtt.utils.c.aMq;
          localObject2 = com.tencent.smtt.utils.c.wVs;
          String str1 = com.tencent.smtt.utils.c.wVt;
          String str2 = com.tencent.smtt.utils.c.aQl;
          o.a(paramContext, "putInfo", new Class[] { String.class, String.class, String.class, String.class }, new Object[] { localObject1, localObject2, str1, str2 });
          o.a(wQY, "setClientVersion", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) });
          return true;
        }
      }
      catch (Throwable paramContext)
      {
        TbsLog.e("QbSdk", "initForX5DisableConfig sys WebView: " + Log.getStackTraceString(paramContext));
        return false;
      }
      wQY = ((Constructor)localObject1).newInstance(new Object[] { paramContext, paramContext });
    }
  }
  
  public static void fileInfoDetect(Context paramContext, String paramString, ValueCallback<String> paramValueCallback)
  {
    ac localac = ac.ceR();
    if ((localac != null) && (localac.ceS())) {}
    try
    {
      localac.ceT().wUo.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "fileInfoDetect", new Class[] { Context.class, String.class, ValueCallback.class }, new Object[] { paramContext, paramString, paramValueCallback });
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void forceSysWebView()
  {
    wRa = true;
    wRe = "SysWebViewForcedByOuter: " + Log.getStackTraceString(new Throwable());
    TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedByOuter");
  }
  
  public static long getApkFileSize(Context paramContext)
  {
    long l = 0L;
    if (paramContext != null) {
      l = k.fM(paramContext.getApplicationContext()).wSA.getLong("tbs_apkfilesize", 0L);
    }
    return l;
  }
  
  public static String[] getDexLoaderFileList(Context paramContext1, Context paramContext2, String paramString)
  {
    int i = 0;
    if ((wRd instanceof String[]))
    {
      int j = wRd.length;
      paramContext2 = new String[j];
      for (;;)
      {
        paramContext1 = paramContext2;
        if (i >= j) {
          break;
        }
        paramContext2[i] = (paramString + wRd[i]);
        i += 1;
      }
    }
    paramContext1 = o.a(wQY, "getJarFiles", new Class[] { Context.class, Context.class, String.class }, new Object[] { paramContext1, paramContext2, paramString });
    if ((paramContext1 instanceof String[])) {}
    for (;;)
    {
      paramContext1 = (String[])paramContext1;
      return paramContext1;
      paramContext1 = new String[1];
      paramContext1[0] = "";
    }
  }
  
  public static boolean getDownloadWithoutWifi()
  {
    return wRr;
  }
  
  public static boolean getIsSysWebViewForcedByOuter()
  {
    return wRa;
  }
  
  public static String getMiniQBVersion(Context paramContext)
  {
    ac localac = ac.ceR();
    localac.b(paramContext, null);
    if ((localac != null) && (localac.ceS()))
    {
      paramContext = localac.ceT().wUo.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getMiniQBVersion", new Class[0], new Object[0]);
      if (paramContext == null) {
        return null;
      }
      return (String)paramContext;
    }
    return null;
  }
  
  public static String getQQBuildNumber()
  {
    return wRo;
  }
  
  public static boolean getTBSInstalling()
  {
    return wRs;
  }
  
  public static String getTID()
  {
    return wRn;
  }
  
  public static int getTbsVersion(Context paramContext)
  {
    int i;
    if (t.gu(paramContext)) {
      i = t.ceG();
    }
    int j;
    do
    {
      do
      {
        return i;
        j = p.ceq().gc(paramContext);
        i = j;
      } while (j != 0);
      i = j;
    } while (j.fL(paramContext).Vl("install_status") != 3);
    reset(paramContext);
    return j;
  }
  
  public static void initBuglyAsync(boolean paramBoolean)
  {
    wRk = paramBoolean;
  }
  
  public static void initTbsSettings(Map<String, Object> paramMap)
  {
    if (wRu == null)
    {
      wRu = paramMap;
      return;
    }
    try
    {
      wRu.putAll(paramMap);
      return;
    }
    catch (Exception paramMap) {}
  }
  
  public static void initX5Environment(Context paramContext, final a parama)
  {
    if (paramContext == null) {
      return;
    }
    mTbsListenerForInit = new q()
    {
      public final void ir(int paramAnonymousInt) {}
      
      public final void is(int paramAnonymousInt)
      {
        QbSdk.preInit(this.val$context, parama);
      }
      
      public final void it(int paramAnonymousInt) {}
    };
    if (t.gu(paramContext)) {
      p.ceq().v(paramContext, true);
    }
    l.a(paramContext, false, false, new l.a()
    {
      public final void e(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        if ((t.ceH() == 0) && (!t.ceD()))
        {
          t.x(this.val$context, false);
          if ((QbSdk.wRk) && (t.gu(this.val$context))) {
            m.ceo().fR(this.val$context);
          }
          return;
        }
        if ((QbSdk.wRk) && (t.gu(this.val$context))) {
          m.ceo().fR(this.val$context);
        }
        QbSdk.preInit(this.val$context, parama);
      }
    });
  }
  
  public static boolean installLocalQbApk(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    d locald = d.lY(true);
    locald.a(paramContext, null);
    if ((locald != null) && (locald.wRB))
    {
      paramContext = locald.cdI().wUo.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "installLocalQbApk", new Class[] { Context.class, String.class, String.class, Bundle.class }, new Object[] { paramContext, paramString1, paramString2, paramBundle });
      if (paramContext == null) {
        return false;
      }
      return ((Boolean)paramContext).booleanValue();
    }
    return false;
  }
  
  public static boolean intentDispatch(WebView paramWebView, Intent paramIntent, String paramString1, String paramString2)
  {
    if (paramWebView == null) {
      return false;
    }
    Context localContext;
    int i;
    if (paramString1.startsWith("mttbrowser://miniqb/ch=icon?"))
    {
      localContext = paramWebView.getContext();
      i = paramString1.indexOf("url=");
      if (i <= 0) {
        break label178;
      }
    }
    label178:
    for (paramIntent = paramString1.substring(i + 4);; paramIntent = null)
    {
      HashMap localHashMap = new HashMap();
      paramString1 = "unknown";
      try
      {
        String str = localContext.getApplicationInfo().packageName;
        paramString1 = str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          continue;
          paramString1 = paramIntent;
        }
      }
      localHashMap.put("ChannelID", paramString1);
      localHashMap.put("PosID", "14004");
      if ("miniqb://home".equals(paramIntent))
      {
        paramString1 = "qb://navicard/addCard?cardId=168&cardName=168";
        if (com.tencent.smtt.sdk.a.c.a(localContext, paramString1, localHashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0)
        {
          paramString1 = ac.ceR();
          if ((paramString1 != null) && (paramString1.ceS()) && (paramString1.ceT().a(localContext, paramIntent, null, paramString2, null) == 0)) {
            return true;
          }
          paramWebView.loadUrl(paramIntent);
        }
        for (;;)
        {
          return false;
          paramWebView.loadUrl(paramString1);
        }
      }
    }
  }
  
  public static boolean isMiniQBShortCutExist(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return false;
    }
    if (l.fP(paramContext)) {
      return false;
    }
    paramString2 = ac.ceR();
    if ((paramString2 != null) && (paramString2.ceS()))
    {
      paramContext = paramString2.ceT().wUo.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "isMiniQBShortCutExist", new Class[] { Context.class, String.class }, new Object[] { paramContext, paramString1 });
      if (paramContext != null) {
        if (!(paramContext instanceof Boolean)) {
          break label99;
        }
      }
    }
    label99:
    for (paramContext = (Boolean)paramContext;; paramContext = Boolean.valueOf(false))
    {
      return paramContext.booleanValue();
      return false;
      return false;
    }
  }
  
  public static boolean isTbsCoreInited()
  {
    boolean bool2 = false;
    d locald = d.lY(false);
    boolean bool1 = bool2;
    if (locald != null)
    {
      bool1 = bool2;
      if (locald.wRC) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean isX5DisabledSync(Context paramContext)
  {
    if (j.fL(paramContext).Vl("install_status") == 2) {}
    for (int i = 1; i != 0; i = 0) {
      return false;
    }
    if (!fE(paramContext)) {
      return true;
    }
    i = p.ceq().gc(paramContext);
    paramContext = o.a(wQY, "isX5DisabledSync", new Class[] { Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(i), Integer.valueOf(43501) });
    if (paramContext != null) {
      return ((Boolean)paramContext).booleanValue();
    }
    return true;
  }
  
  @SuppressLint({"NewApi"})
  private static boolean o(Context paramContext, boolean paramBoolean)
  {
    int i1 = -1;
    TbsLog.initIfNeed(paramContext);
    if (!sIsVersionPrinted)
    {
      TbsLog.i("QbSdk", "svn revision: jnizz; SDK_VERSION_CODE: 43501; SDK_VERSION_NAME: 3.5.0.1016");
      sIsVersionPrinted = true;
    }
    if ((wQZ) && (!paramBoolean))
    {
      TbsLog.e("QbSdk", "QbSdk init: " + wRf, false);
      i.cdS().a(paramContext, 414, new Throwable(wRf));
      return false;
    }
    if (wRa)
    {
      TbsLog.e("QbSdk", "QbSdk init mIsSysWebViewForcedByOuter = true", true);
      i.cdS().a(paramContext, 402, new Throwable(wRe));
      return false;
    }
    if (!wRq) {
      wRq = true;
    }
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 11) {
          localObject1 = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
        }
      }
      catch (Throwable localThrowable4)
      {
        try
        {
          k = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_recorder", -1);
          if (k < 0) {
            break label1472;
          }
          i = k + 1;
          if (i <= 4) {}
        }
        catch (Throwable localThrowable5)
        {
          for (;;)
          {
            Object localObject1;
            int j;
            int n;
            Object localObject4;
            int m;
            Object localObject2;
            Object localObject5;
            Object localObject3;
            int k = -1;
            int i = -1;
            continue;
            i = -1;
            continue;
            i = 0;
          }
        }
        try
        {
          p.ceq();
          localObject1 = p.gk(paramContext);
          if (localObject1 == null)
          {
            TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
            i.cdS().a(paramContext, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
            return false;
            localObject1 = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
            continue;
            k = i;
          }
        }
        catch (Throwable localThrowable3)
        {
          TbsLog.e("QbSdk", "QbSdk init Throwable: " + Log.getStackTraceString(localThrowable3));
          i.cdS().a(paramContext, 306, localThrowable3);
          return false;
        }
        try
        {
          j = p.ceq().gc(paramContext);
          if (j <= 0) {
            continue;
          }
          if (k > 4) {}
        }
        catch (Throwable localThrowable6)
        {
          j = -1;
          k = i;
          i = j;
          break label495;
        }
        try
        {
          ((SharedPreferences)localObject1).edit().putInt("tbs_preload_x5_recorder", k).commit();
          n = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_counter", -1);
          k = i;
          localObject4 = localObject1;
          m = j;
          if (n < 0) {
            break label528;
          }
          localObject4 = ((SharedPreferences)localObject1).edit();
          n += 1;
          ((SharedPreferences.Editor)localObject4).putInt("tbs_preload_x5_counter", n).commit();
          if (n <= 3) {
            break label579;
          }
          try
          {
            i = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_version", -1);
            localObject1 = ((SharedPreferences)localObject1).edit();
            if (i != j) {
              break label544;
            }
            p.ceq();
            f.c(p.gk(paramContext), false);
            j.fL(paramContext);
            localObject4 = j.cdT();
            if (localObject4 != null) {
              f.c((File)localObject4, false);
            }
            TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + j + " is deleted!");
            ((SharedPreferences.Editor)localObject1).putInt("tbs_precheck_disable_version", i);
            ((SharedPreferences.Editor)localObject1).commit();
          }
          catch (Throwable localThrowable1)
          {
            TbsLog.e("QbSdk", "tbs_preload_x5_counter disable version exception:" + Log.getStackTraceString(localThrowable1));
          }
        }
        catch (Throwable localThrowable7)
        {
          k = i;
          i = j;
          break label495;
        }
        localThrowable4 = localThrowable4;
        localObject2 = null;
        i = -1;
        k = -1;
      }
      label495:
      TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(localThrowable4));
      m = i;
      localObject5 = localObject2;
      label528:
      n = -1;
      i = k;
      localObject2 = localObject5;
      j = m;
      continue;
      label544:
      TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + j + "; value:" + i);
      continue;
      label579:
      j = i1;
      if (i > 0)
      {
        j = i1;
        if (i <= 3)
        {
          TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
          ac.ceR().b(paramContext, null);
          TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
          j = 0;
        }
      }
      try
      {
        i = ((SharedPreferences)localObject2).getInt("tbs_preload_x5_counter", -1);
        if (i > 0) {
          ((SharedPreferences)localObject2).edit().putInt("tbs_preload_x5_counter", i - 1).commit();
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          TbsLog.e("QbSdk", "tbs_preload_x5_counter Dec exception:" + Log.getStackTraceString(localThrowable2));
        }
      }
      TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + j);
    }
    if (!t.gu(paramContext))
    {
      if (wQV != 0)
      {
        j = p.ceq().a(true, paramContext);
        i = j;
        if (wQV != j)
        {
          wQX = null;
          wQY = null;
          TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=" + j, true);
          TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + wQV, true);
          i.cdS().a(paramContext, 303, new Throwable("sTbsVersion: " + wQV + "; tbsCoreInstalledVer: " + j));
          return false;
        }
        wQV = i;
      }
    }
    else
    {
      if (wQX != null) {
        return true;
      }
      if (t.gu(paramContext))
      {
        i.cdS().a(paramContext, 304, new Throwable("isShareTbsCoreAvailable false!"));
        return false;
      }
      p.ceq();
      localObject5 = new File(p.gk(paramContext), "tbs_sdk_extension_dex.jar");
      paramBoolean = ((File)localObject5).exists();
      if (paramBoolean) {}
    }
    try
    {
      TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
      i = p.ceq().gc(paramContext);
      if (new File(((File)localObject5).getParentFile(), "tbs_jars_fusion_dex.jar").exists())
      {
        if (i > 0) {
          i.cdS().a(paramContext, 4131, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
        } else {
          i.cdS().a(paramContext, 4132, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
        }
      }
      else if (i > 0) {
        i.cdS().a(paramContext, 4121, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
      } else {
        i.cdS().a(paramContext, 4122, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
      }
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    localObject3 = new DexClassLoader(((File)localObject5).getAbsolutePath(), localThrowable2.getAbsolutePath(), ((File)localObject5).getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
    wQX = (Class)localObject3;
    localObject3 = ((Class)localObject3).getConstructor(new Class[] { Context.class, Context.class });
    if (t.gu(paramContext)) {
      if (t.ceA() == null)
      {
        r.gr(paramContext.getApplicationContext()).aM(227, "host context is null!");
        return false;
      }
    }
    for (wQY = wQX.getConstructor(new Class[] { Context.class, Context.class, String.class }).newInstance(new Object[] { paramContext, null, t.ceA() });; wQY = ((Constructor)localObject3).newInstance(new Object[] { paramContext, paramContext }))
    {
      localObject3 = wQY;
      localObject5 = com.tencent.smtt.utils.c.aMq;
      String str1 = com.tencent.smtt.utils.c.wVs;
      String str2 = com.tencent.smtt.utils.c.wVt;
      String str3 = com.tencent.smtt.utils.c.aQl;
      o.a(localObject3, "putInfo", new Class[] { String.class, String.class, String.class, String.class }, new Object[] { localObject5, str1, str2, str3 });
      o.a(wQY, "setClientVersion", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) });
      return true;
    }
    label1472:
    return false;
  }
  
  static boolean p(Context paramContext, boolean paramBoolean)
  {
    int k = 1;
    paramBoolean = false;
    boolean bool2 = false;
    boolean bool1 = false;
    if (t.gu(paramContext))
    {
      t.ceJ();
      i.cdS().ai(paramContext, 302);
    }
    for (;;)
    {
      return bool1;
      if (!o(paramContext, false))
      {
        TbsLog.e("QbSdk", "QbSdk.init failure!");
        return false;
      }
      Object localObject2 = o.a(wQY, "canLoadX5Core", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(43501) });
      int i;
      label387:
      label619:
      Class localClass2;
      Object localObject1;
      if (localObject2 != null)
      {
        if (((localObject2 instanceof String)) && (((String)localObject2).equalsIgnoreCase("AuthenticationFail"))) {
          continue;
        }
        if (!(localObject2 instanceof Bundle))
        {
          i.cdS().a(paramContext, 330, new Throwable(String.valueOf(localObject2)));
          TbsLog.e("loaderror", "ret not instance of bundle");
          return false;
        }
        Bundle localBundle = (Bundle)localObject2;
        if (localBundle.isEmpty())
        {
          i.cdS().a(paramContext, 331, new Throwable(String.valueOf(localObject2)));
          TbsLog.e("loaderror", "empty bundle");
          return false;
        }
        try
        {
          i = localBundle.getInt("result_code", -1);
          if (i == 0)
          {
            paramBoolean = true;
            if (!t.gu(paramContext)) {
              break label387;
            }
            d.CO(t.ceF());
            localObject2 = String.valueOf(t.ceF());
            wQW = (String)localObject2;
            if (((String)localObject2).length() == 5) {
              wQW = "0" + wQW;
            }
            if (wQW.length() != 6) {
              wQW = "";
            }
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            try
            {
              wRd = localBundle.getStringArray("tbs_jarfiles");
              if ((wRd instanceof String[])) {
                break label619;
              }
              i.cdS().a(paramContext, 307, new Throwable("sJarFiles not instanceof String[]: " + wRd));
              return false;
            }
            catch (Throwable localThrowable)
            {
              i.cdS().a(paramContext, 329, localThrowable);
              return false;
            }
            localException2 = localException2;
            TbsLog.e("QbSdk", "bundle.getInt(KEY_RESULT_CODE) error : " + localException2.toString());
            i = -1;
            continue;
            paramBoolean = false;
            continue;
            if (Build.VERSION.SDK_INT >= 12) {
              wQW = localBundle.getString("tbs_core_version", "0");
            }
            try
            {
              wQV = Integer.parseInt(wQW);
              d.CO(wQV);
              if (wQV == 0)
              {
                i.cdS().a(paramContext, 307, new Throwable("sTbsVersion is 0"));
                return false;
                String str = localBundle.getString("tbs_core_version");
                wQW = str;
                if (str != null) {
                  continue;
                }
                wQW = "0";
              }
            }
            catch (NumberFormatException localNumberFormatException)
            {
              wQV = 0;
              continue;
              int j;
              if (wQV > 0)
              {
                j = k;
                if (wQV <= 25442) {}
              }
              else
              {
                if (wQV != 25472) {
                  continue;
                }
                j = k;
              }
              if (j != 0)
              {
                TbsLog.e("TbsDownload", "is_obsolete --> delete old core:" + wQV);
                p.ceq();
                f.J(p.gk(paramContext));
                i.cdS().a(paramContext, 307, new Throwable("is_obsolete --> delete old core:" + wQV));
                return false;
                j = 0;
              }
            }
          }
        }
        wRg = localThrowable.getString("tbs_librarypath");
        localClass2 = null;
        localObject1 = localClass2;
        if (i == 0) {}
      }
      try
      {
        localObject1 = o.a(wQY, "getErrorCodeForLogReport", new Class[0], new Object[0]);
        switch (i)
        {
        default: 
          i.cdS().a(paramContext, 415, new Throwable("detail: " + localObject1 + "errcode" + i));
        }
        for (;;)
        {
          bool1 = paramBoolean;
          if (paramBoolean) {
            break;
          }
          TbsLog.e("loaderror", "319");
          return paramBoolean;
          if ((localObject1 instanceof Integer))
          {
            i.cdS().a(paramContext, ((Integer)localObject1).intValue(), new Throwable("detail: " + localObject1));
          }
          else
          {
            i.cdS().a(paramContext, 307, new Throwable("detail: " + localObject1));
            continue;
            if ((localObject1 instanceof Integer))
            {
              i.cdS().a(paramContext, ((Integer)localObject1).intValue(), new Throwable("detail: " + localObject1));
            }
            else
            {
              i.cdS().a(paramContext, 404, new Throwable("detail: " + localObject1));
              continue;
              continue;
              localObject1 = wQY;
              localClass2 = Integer.TYPE;
              i = a.cdF();
              localObject1 = o.a(localObject1, "canLoadX5", new Class[] { localClass2 }, new Object[] { Integer.valueOf(i) });
              if (localObject1 != null)
              {
                if (((localObject1 instanceof String)) && (((String)localObject1).equalsIgnoreCase("AuthenticationFail"))) {
                  break;
                }
                if (!(localObject1 instanceof Boolean)) {
                  continue;
                }
                wQV = d.cdJ();
                boolean bool3 = ag(paramContext, d.cdJ());
                paramBoolean = bool2;
                if (((Boolean)localObject1).booleanValue())
                {
                  paramBoolean = bool2;
                  if (!bool3) {
                    paramBoolean = true;
                  }
                }
                bool1 = paramBoolean;
                if (paramBoolean) {
                  break;
                }
                TbsLog.e("loaderror", "318");
                TbsLog.w("loaderror", "isX5Disable:" + bool3);
                TbsLog.w("loaderror", "(Boolean) ret:" + (Boolean)localObject1);
                return paramBoolean;
              }
              i.cdS().ai(paramContext, 308);
            }
          }
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          Class localClass1 = localClass2;
        }
      }
    }
  }
  
  public static void preInit(Context paramContext)
  {
    try
    {
      preInit(paramContext, null);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void preInit(final Context paramContext, final a parama)
  {
    try
    {
      TbsLog.initIfNeed(paramContext);
      wRp = wQZ;
      if (!wRc)
      {
        paramContext = new Thread()
        {
          public final void handleMessage(Message paramAnonymousMessage)
          {
            switch (paramAnonymousMessage.what)
            {
            }
            do
            {
              return;
              if (parama != null) {
                parama.al(false);
              }
              TbsLog.writeLogToDisk();
              return;
              paramAnonymousMessage = ac.ceR().ceT();
              if (paramAnonymousMessage != null) {
                paramAnonymousMessage.gG(paramContext);
              }
              if (parama != null) {
                parama.al(true);
              }
              TbsLog.writeLogToDisk();
              return;
            } while (parama == null);
            parama.ot();
          }
        }
        {
          public final void run()
          {
            if (p.ceq().a(true, this.val$context) == 0) {
              p.ceq().v(this.val$context, true);
            }
            d.lY(true).a(this.val$context, null);
            ac localac = ac.ceR();
            localac.b(this.val$context, null);
            boolean bool = localac.ceS();
            this.wRy.sendEmptyMessage(3);
            if (!bool)
            {
              this.wRy.sendEmptyMessage(2);
              return;
            }
            this.wRy.sendEmptyMessage(1);
          }
        };
        paramContext.setName("tbs_preinit");
        paramContext.setPriority(10);
        paramContext.start();
        wRc = true;
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void reset(Context paramContext)
  {
    reset(paramContext, false);
  }
  
  public static void reset(Context paramContext, boolean paramBoolean)
  {
    int i = 1;
    TbsLog.e("QbSdk", "QbSdk reset!", true);
    for (;;)
    {
      try
      {
        l.stopDownload();
        if ((paramBoolean) && (!t.gu(paramContext)))
        {
          p.ceq();
          int j = p.gb(paramContext);
          int k = p.ceq().gc(paramContext);
          if ((j > 43300) && (j != k))
          {
            l.fQ(paramContext);
            f.d(paramContext.getDir("tbs", 0), "core_share_decouple");
            TbsLog.i("QbSdk", "delete downloaded apk success", true);
            p.wTd.set(Integer.valueOf(0));
            File localFile = new File(paramContext.getFilesDir(), "bugly_switch.txt");
            if (localFile.exists()) {
              localFile.delete();
            }
            if (i != 0)
            {
              p.ceq();
              localFile = p.gj(paramContext);
              p.ceq();
              f.h(localFile, p.gn(paramContext));
              p.ceq();
              p.w(paramContext, true);
              j.fL(paramContext).eB(p.gb(paramContext), 2);
            }
            return;
          }
        }
      }
      catch (Throwable paramContext)
      {
        TbsLog.e("QbSdk", "QbSdk reset exception:" + Log.getStackTraceString(paramContext));
        return;
      }
      i = 0;
    }
  }
  
  public static void resetDecoupleCore(Context paramContext)
  {
    TbsLog.e("QbSdk", "QbSdk resetDecoupleCore!", true);
    try
    {
      p.ceq();
      f.J(p.gj(paramContext));
      return;
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "QbSdk resetDecoupleCore exception:" + Log.getStackTraceString(paramContext));
    }
  }
  
  public static void setCurrentID(String paramString)
  {
    if (paramString == null) {}
    while (!paramString.startsWith("QQ:")) {
      return;
    }
    paramString = paramString.substring(3);
    wRn = "0000000000000000".substring(paramString.length()) + paramString;
  }
  
  public static void setDeviceInfo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    com.tencent.smtt.utils.c.aMq = paramString1;
    com.tencent.smtt.utils.c.wVs = paramString2;
    com.tencent.smtt.utils.c.wVt = paramString3;
    com.tencent.smtt.utils.c.aQl = paramString4;
  }
  
  public static void setDownloadWithoutWifi(boolean paramBoolean)
  {
    wRr = paramBoolean;
  }
  
  public static void setQQBuildNumber(String paramString)
  {
    wRo = paramString;
  }
  
  public static void setTBSInstallingStatus(boolean paramBoolean)
  {
    wRs = paramBoolean;
  }
  
  public static void setTbsListener(q paramq)
  {
    mTbsListener = paramq;
  }
  
  public static void setTbsLogClient(com.tencent.smtt.utils.t paramt)
  {
    TbsLog.setTbsLogClient(paramt);
  }
  
  public static int startMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback)
  {
    i.cdS().ai(paramContext, 501);
    if (paramContext == null) {
      return -100;
    }
    ac localac = ac.ceR();
    localac.b(paramContext, null);
    if (localac.ceS())
    {
      if ((paramContext != null) && (paramContext.getApplicationInfo().packageName.equals("com.nd.android.pandahome2")) && (getTbsVersion(paramContext) < 25487)) {
        return -101;
      }
      int i = localac.ceT().a(paramContext, paramString, paramHashMap, null, paramValueCallback);
      if (i == 0)
      {
        i.cdS().ai(paramContext, 503);
        return i;
      }
      r.gr(paramContext).aM(504, String.valueOf(i));
      return i;
    }
    i.cdS().ai(paramContext, 502);
    return -102;
  }
  
  public static boolean startQBForDoc(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2, Bundle paramBundle)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationContext().getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt1));
    return com.tencent.smtt.sdk.a.c.a(paramContext, paramString1, paramInt2, paramString2, localHashMap, paramBundle);
  }
  
  public static boolean startQBForVideo(Context paramContext, String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt));
    return com.tencent.smtt.sdk.a.c.a(paramContext, paramString, localHashMap);
  }
  
  public static boolean startQBToLoadurl(Context paramContext, String paramString, int paramInt, WebView paramWebView)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt));
    WebView localWebView1 = paramWebView;
    if (paramWebView == null) {}
    try
    {
      Object localObject = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).packageName;
      if (localObject != "com.tencent.mm")
      {
        localWebView1 = paramWebView;
        if (localObject != "com.tencent.mobileqq") {}
      }
      else
      {
        localObject = ac.ceR();
        localWebView1 = paramWebView;
        if (localObject != null)
        {
          localWebView1 = paramWebView;
          if (((ac)localObject).ceS())
          {
            localObject = ((ac)localObject).ceT().wUo.invokeStaticMethod("com.tencent.smtt.webkit.WebViewList", "getCurrentMainWebviewJustForQQandWechat", new Class[0], new Object[0]);
            localWebView1 = paramWebView;
            if (localObject != null)
            {
              localObject = (IX5WebViewBase)localObject;
              localWebView1 = paramWebView;
              if (localObject != null) {
                localWebView1 = (WebView)((IX5WebViewBase)localObject).getView().getParent();
              }
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        WebView localWebView2 = paramWebView;
      }
    }
    return com.tencent.smtt.sdk.a.c.a(paramContext, paramString, localHashMap, "QbSdk.startQBToLoadurl", localWebView1) == 0;
  }
  
  public static boolean startQbOrMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, y<String> paramy)
  {
    if (paramContext == null) {
      return false;
    }
    ac localac = ac.ceR();
    localac.b(paramContext, null);
    if ((paramHashMap != null) && ("5".equals(paramHashMap.get("PosID"))) && (localac.ceS())) {
      localac.ceT().wUo.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getAdWebViewInfoFromX5Core", new Class[0], new Object[0]);
    }
    if (com.tencent.smtt.sdk.a.c.a(paramContext, paramString, paramHashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0)
    {
      if (localac.ceS())
      {
        if ((paramContext != null) && (paramContext.getApplicationInfo().packageName.equals("com.nd.android.pandahome2")) && (getTbsVersion(paramContext) < 25487)) {
          return false;
        }
        if (localac.ceT().a(paramContext, paramString, paramHashMap, null, paramy) == 0) {
          return true;
        }
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public static void unForceSysWebView()
  {
    wRa = false;
    TbsLog.e("QbSdk", "sys WebView: unForceSysWebView called");
  }
  
  public static boolean useSoftWare()
  {
    if (wQY == null) {
      return false;
    }
    Object localObject2 = o.a(wQY, "useSoftWare", new Class[0], new Object[0]);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = wQY;
      localObject2 = Integer.TYPE;
      int i = a.cdF();
      localObject1 = o.a(localObject1, "useSoftWare", new Class[] { localObject2 }, new Object[] { Integer.valueOf(i) });
    }
    if (localObject1 == null) {
      return false;
    }
    return ((Boolean)localObject1).booleanValue();
  }
  
  public static abstract interface a
  {
    public abstract void al(boolean paramBoolean);
    
    public abstract void ot();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/sdk/QbSdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */