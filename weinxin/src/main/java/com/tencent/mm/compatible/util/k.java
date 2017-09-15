package com.tencent.mm.compatible.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.compatible.d.x;
import com.tencent.mm.loader.stub.BaseBuildInfo;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tinker.lib.d.b;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class k
{
  private static String gSN;
  private static boolean gSO;
  private static HashMap<String, String> gSP;
  private static final HashMap<String, WeakReference<ClassLoader>> mLoadedLibs;
  
  static
  {
    GMTrace.i(13782013181952L, 102684);
    mLoadedLibs = new HashMap();
    gSN = null;
    gSO = false;
    gSP = null;
    GMTrace.o(13782013181952L, 102684);
  }
  
  private k()
  {
    GMTrace.i(13780536786944L, 102673);
    GMTrace.o(13780536786944L, 102673);
  }
  
  private static boolean a(String paramString, ClassLoader paramClassLoader)
  {
    GMTrace.i(13780939440128L, 102676);
    if (!BaseBuildInfo.patchEnabled())
    {
      GMTrace.o(13780939440128L, 102676);
      return false;
    }
    Object localObject2;
    if (!gSO)
    {
      localObject2 = MMApplicationLike.getTinkerApplicationLike();
      if (localObject2 == null) {
        throw new RuntimeException("tinker application is null when try to load from patch libs");
      }
      gSO = true;
      if ((localObject2 == null) || (((ApplicationLike)localObject2).getApplication() == null)) {
        throw new TinkerRuntimeException("tinkerApplication is null");
      }
      ??? = ((ApplicationLike)localObject2).getTinkerResultIntent();
      if ((??? != null) && (ShareIntentUtil.an((Intent)???) == 0))
      {
        ??? = ShareIntentUtil.as((Intent)???);
        gSP = (HashMap)???;
        ??? = b.c((ApplicationLike)localObject2);
        if (!ShareTinkerInternals.mA((String)???)) {
          break label179;
        }
        gSN = null;
      }
    }
    else
    {
      label114:
      if (!paramString.startsWith("lib")) {
        break label252;
      }
      label123:
      if (!paramString.endsWith(".so")) {
        break label272;
      }
    }
    for (;;)
    {
      ??? = "lib/armeabi/" + paramString;
      localObject2 = MMApplicationLike.getTinkerApplicationLike();
      if ((localObject2 != null) && (((ApplicationLike)localObject2).getApplication() != null)) {
        break label295;
      }
      throw new TinkerRuntimeException("tinkerApplication is null");
      ??? = null;
      break;
      label179:
      localObject2 = SharePatchFileUtil.hx(((ApplicationLike)localObject2).getApplication());
      ??? = new File(((File)localObject2).getAbsolutePath() + "/" + SharePatchFileUtil.VO((String)???));
      gSN = ((File)???).getAbsolutePath() + "/lib";
      break label114;
      label252:
      paramString = "lib" + paramString;
      break label123;
      label272:
      paramString = paramString + ".so";
    }
    label295:
    if ((ShareTinkerInternals.DQ(((ApplicationLike)localObject2).getTinkerFlags())) && (b.b((ApplicationLike)localObject2)) && (gSP != null))
    {
      Iterator localIterator = gSP.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        if (str1.equals(???))
        {
          String str2 = gSN + "/" + str1;
          File localFile = new File(str2);
          if (localFile.exists()) {
            if ((((ApplicationLike)localObject2).getTinkerLoadVerifyFlag()) && (!SharePatchFileUtil.e(localFile, (String)gSP.get(str1)))) {
              v.e("MicroMsg.LoadLibrary", "loadLibraryFromTinker md5mismatch fail: %s", new Object[] { str2 });
            } else {
              try
              {
                v.w("MicroMsg.LoadLibrary", "succ load from patch path: %s", new Object[] { str2 });
                reflectSystemLoad(str2, paramClassLoader);
                synchronized (mLoadedLibs)
                {
                  mLoadedLibs.put(paramString, new WeakReference(paramClassLoader));
                  GMTrace.o(13780939440128L, 102676);
                  return true;
                }
                GMTrace.o(13780939440128L, 102676);
              }
              catch (InvocationTargetException paramClassLoader)
              {
                throw ((UnsatisfiedLinkError)new UnsatisfiedLinkError("Failed loading library: " + paramString).initCause(paramClassLoader.getCause()));
              }
              catch (Exception paramClassLoader)
              {
                throw ((UnsatisfiedLinkError)new UnsatisfiedLinkError("Failed loading library: " + paramString).initCause(paramClassLoader));
              }
            }
          }
        }
      }
    }
    return false;
  }
  
  /* Error */
  public static void b(String paramString, ClassLoader paramClassLoader)
  {
    // Byte code:
    //   0: ldc2_w 252
    //   3: ldc -2
    //   5: invokestatic 27	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   8: aload_0
    //   9: invokestatic 257	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   12: ifne +7 -> 19
    //   15: aload_1
    //   16: ifnonnull +64 -> 80
    //   19: iconst_1
    //   20: istore_2
    //   21: ldc_w 259
    //   24: iload_2
    //   25: invokestatic 265	junit/framework/Assert:assertFalse	(Ljava/lang/String;Z)V
    //   28: getstatic 34	com/tencent/mm/compatible/util/k:mLoadedLibs	Ljava/util/HashMap;
    //   31: astore 4
    //   33: aload 4
    //   35: monitorenter
    //   36: getstatic 34	com/tencent/mm/compatible/util/k:mLoadedLibs	Ljava/util/HashMap;
    //   39: aload_0
    //   40: invokevirtual 203	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   43: checkcast 227	java/lang/ref/WeakReference
    //   46: astore_3
    //   47: aload_3
    //   48: ifnull +848 -> 896
    //   51: aload_3
    //   52: invokevirtual 267	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   55: checkcast 269	java/lang/ClassLoader
    //   58: astore_3
    //   59: aload_3
    //   60: ifnull +62 -> 122
    //   63: aload_3
    //   64: aload_1
    //   65: if_acmpne +20 -> 85
    //   68: aload 4
    //   70: monitorexit
    //   71: ldc2_w 252
    //   74: ldc -2
    //   76: invokestatic 43	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   79: return
    //   80: iconst_0
    //   81: istore_2
    //   82: goto -61 -> 21
    //   85: new 236	java/lang/UnsatisfiedLinkError
    //   88: dup
    //   89: new 126	java/lang/StringBuilder
    //   92: dup
    //   93: ldc_w 271
    //   96: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: aload_0
    //   100: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc_w 273
    //   106: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokespecial 239	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   115: athrow
    //   116: astore_0
    //   117: aload 4
    //   119: monitorexit
    //   120: aload_0
    //   121: athrow
    //   122: aload 4
    //   124: monitorexit
    //   125: ldc -47
    //   127: new 126	java/lang/StringBuilder
    //   130: dup
    //   131: ldc_w 275
    //   134: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   137: aload_0
    //   138: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 278	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: aload_0
    //   148: aload_1
    //   149: invokestatic 280	com/tencent/mm/compatible/util/k:a	(Ljava/lang/String;Ljava/lang/ClassLoader;)Z
    //   152: ifeq +12 -> 164
    //   155: ldc2_w 252
    //   158: ldc -2
    //   160: invokestatic 43	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   163: return
    //   164: invokestatic 286	com/tencent/mm/sdk/platformtools/aa:getContext	()Landroid/content/Context;
    //   167: astore 5
    //   169: aload 5
    //   171: ifnull +9 -> 180
    //   174: invokestatic 291	com/tencent/mm/sdk/a/b:bIk	()Z
    //   177: ifeq +113 -> 290
    //   180: aload_0
    //   181: aload_1
    //   182: invokestatic 294	com/tencent/mm/compatible/util/k:reflectSystemLoadlibrary	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   185: getstatic 34	com/tencent/mm/compatible/util/k:mLoadedLibs	Ljava/util/HashMap;
    //   188: astore_3
    //   189: aload_3
    //   190: monitorenter
    //   191: getstatic 34	com/tencent/mm/compatible/util/k:mLoadedLibs	Ljava/util/HashMap;
    //   194: aload_0
    //   195: new 227	java/lang/ref/WeakReference
    //   198: dup
    //   199: aload_1
    //   200: invokespecial 230	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   203: invokevirtual 234	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   206: pop
    //   207: aload_3
    //   208: monitorexit
    //   209: ldc2_w 252
    //   212: ldc -2
    //   214: invokestatic 43	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   217: return
    //   218: astore_1
    //   219: new 236	java/lang/UnsatisfiedLinkError
    //   222: dup
    //   223: new 126	java/lang/StringBuilder
    //   226: dup
    //   227: ldc -18
    //   229: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   232: aload_0
    //   233: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokespecial 239	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   242: aload_1
    //   243: invokevirtual 243	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   246: invokevirtual 247	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   249: checkcast 236	java/lang/UnsatisfiedLinkError
    //   252: athrow
    //   253: astore_1
    //   254: aload_3
    //   255: monitorexit
    //   256: aload_1
    //   257: athrow
    //   258: astore_1
    //   259: new 236	java/lang/UnsatisfiedLinkError
    //   262: dup
    //   263: new 126	java/lang/StringBuilder
    //   266: dup
    //   267: ldc -18
    //   269: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   272: aload_0
    //   273: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokespecial 239	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   282: aload_1
    //   283: invokevirtual 247	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   286: checkcast 236	java/lang/UnsatisfiedLinkError
    //   289: athrow
    //   290: new 145	java/io/File
    //   293: dup
    //   294: aload 5
    //   296: ldc_w 296
    //   299: iconst_0
    //   300: invokevirtual 302	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   303: new 126	java/lang/StringBuilder
    //   306: dup
    //   307: ldc 114
    //   309: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   312: aload_0
    //   313: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: ldc 121
    //   318: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokespecial 305	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   327: astore 6
    //   329: aload 6
    //   331: invokevirtual 308	java/io/File:isFile	()Z
    //   334: ifeq +557 -> 891
    //   337: aload 6
    //   339: invokevirtual 149	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   342: aload_1
    //   343: invokestatic 225	com/tencent/mm/compatible/util/k:reflectSystemLoad	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   346: getstatic 34	com/tencent/mm/compatible/util/k:mLoadedLibs	Ljava/util/HashMap;
    //   349: astore_3
    //   350: aload_3
    //   351: monitorenter
    //   352: getstatic 34	com/tencent/mm/compatible/util/k:mLoadedLibs	Ljava/util/HashMap;
    //   355: aload_0
    //   356: new 227	java/lang/ref/WeakReference
    //   359: dup
    //   360: aload_1
    //   361: invokespecial 230	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   364: invokevirtual 234	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   367: pop
    //   368: aload_3
    //   369: monitorexit
    //   370: ldc2_w 252
    //   373: ldc -2
    //   375: invokestatic 43	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   378: return
    //   379: astore_3
    //   380: aload 6
    //   382: invokevirtual 311	java/io/File:delete	()Z
    //   385: pop
    //   386: aload_0
    //   387: aload_1
    //   388: invokestatic 294	com/tencent/mm/compatible/util/k:reflectSystemLoadlibrary	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   391: getstatic 34	com/tencent/mm/compatible/util/k:mLoadedLibs	Ljava/util/HashMap;
    //   394: astore 4
    //   396: aload 4
    //   398: monitorenter
    //   399: getstatic 34	com/tencent/mm/compatible/util/k:mLoadedLibs	Ljava/util/HashMap;
    //   402: aload_0
    //   403: new 227	java/lang/ref/WeakReference
    //   406: dup
    //   407: aload_1
    //   408: invokespecial 230	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   411: invokevirtual 234	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   414: pop
    //   415: aload 4
    //   417: monitorexit
    //   418: ldc2_w 252
    //   421: ldc -2
    //   423: invokestatic 43	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   426: return
    //   427: astore 4
    //   429: aload_3
    //   430: ifnonnull +458 -> 888
    //   433: aload 4
    //   435: astore_3
    //   436: new 313	java/util/zip/ZipFile
    //   439: dup
    //   440: aload 5
    //   442: invokevirtual 317	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   445: getfield 322	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   448: invokespecial 323	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   451: astore 5
    //   453: aload 5
    //   455: astore 4
    //   457: aload 5
    //   459: aload_0
    //   460: invokestatic 327	com/tencent/mm/compatible/util/k:generateAbiList	()Ljava/util/List;
    //   463: aload 6
    //   465: invokestatic 331	com/tencent/mm/compatible/util/k:extractLibrary	(Ljava/util/zip/ZipFile;Ljava/lang/String;Ljava/util/List;Ljava/io/File;)Z
    //   468: ifne +274 -> 742
    //   471: aload 5
    //   473: astore 4
    //   475: new 70	java/lang/RuntimeException
    //   478: dup
    //   479: new 126	java/lang/StringBuilder
    //   482: dup
    //   483: ldc_w 333
    //   486: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   489: aload_0
    //   490: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: invokespecial 75	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   499: athrow
    //   500: astore_0
    //   501: aload 5
    //   503: astore 4
    //   505: new 236	java/lang/UnsatisfiedLinkError
    //   508: dup
    //   509: ldc_w 335
    //   512: invokespecial 239	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   515: aload_0
    //   516: invokevirtual 247	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   519: checkcast 236	java/lang/UnsatisfiedLinkError
    //   522: athrow
    //   523: astore_0
    //   524: aload 4
    //   526: ifnull +8 -> 534
    //   529: aload 4
    //   531: invokevirtual 338	java/util/zip/ZipFile:close	()V
    //   534: aload_0
    //   535: athrow
    //   536: astore 4
    //   538: aload_3
    //   539: monitorexit
    //   540: aload 4
    //   542: athrow
    //   543: astore_3
    //   544: aload_3
    //   545: invokevirtual 243	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   548: instanceof 236
    //   551: ifeq +14 -> 565
    //   554: aload_3
    //   555: invokevirtual 243	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   558: checkcast 236	java/lang/UnsatisfiedLinkError
    //   561: astore_3
    //   562: goto -182 -> 380
    //   565: new 236	java/lang/UnsatisfiedLinkError
    //   568: dup
    //   569: new 126	java/lang/StringBuilder
    //   572: dup
    //   573: ldc_w 340
    //   576: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   579: aload_0
    //   580: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   586: invokespecial 239	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   589: aload_3
    //   590: invokevirtual 243	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   593: invokevirtual 247	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   596: checkcast 236	java/lang/UnsatisfiedLinkError
    //   599: athrow
    //   600: astore_1
    //   601: new 236	java/lang/UnsatisfiedLinkError
    //   604: dup
    //   605: new 126	java/lang/StringBuilder
    //   608: dup
    //   609: ldc_w 340
    //   612: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   615: aload_0
    //   616: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   622: invokespecial 239	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   625: aload_1
    //   626: invokevirtual 247	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   629: checkcast 236	java/lang/UnsatisfiedLinkError
    //   632: athrow
    //   633: astore 7
    //   635: aload 4
    //   637: monitorexit
    //   638: aload 7
    //   640: athrow
    //   641: astore 4
    //   643: aload 4
    //   645: invokevirtual 243	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   648: instanceof 236
    //   651: ifeq +19 -> 670
    //   654: aload_3
    //   655: ifnonnull +51 -> 706
    //   658: aload 4
    //   660: invokevirtual 243	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   663: checkcast 236	java/lang/UnsatisfiedLinkError
    //   666: astore_3
    //   667: goto -231 -> 436
    //   670: new 236	java/lang/UnsatisfiedLinkError
    //   673: dup
    //   674: new 126	java/lang/StringBuilder
    //   677: dup
    //   678: ldc_w 340
    //   681: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   684: aload_0
    //   685: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   691: invokespecial 239	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   694: aload 4
    //   696: invokevirtual 243	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   699: invokevirtual 247	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   702: checkcast 236	java/lang/UnsatisfiedLinkError
    //   705: athrow
    //   706: goto -270 -> 436
    //   709: astore_1
    //   710: new 236	java/lang/UnsatisfiedLinkError
    //   713: dup
    //   714: new 126	java/lang/StringBuilder
    //   717: dup
    //   718: ldc_w 340
    //   721: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   724: aload_0
    //   725: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   731: invokespecial 239	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   734: aload_1
    //   735: invokevirtual 247	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   738: checkcast 236	java/lang/UnsatisfiedLinkError
    //   741: athrow
    //   742: aload 5
    //   744: invokevirtual 338	java/util/zip/ZipFile:close	()V
    //   747: aload 6
    //   749: invokevirtual 149	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   752: aload_1
    //   753: invokestatic 225	com/tencent/mm/compatible/util/k:reflectSystemLoad	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   756: getstatic 34	com/tencent/mm/compatible/util/k:mLoadedLibs	Ljava/util/HashMap;
    //   759: astore 4
    //   761: aload 4
    //   763: monitorenter
    //   764: getstatic 34	com/tencent/mm/compatible/util/k:mLoadedLibs	Ljava/util/HashMap;
    //   767: aload_0
    //   768: new 227	java/lang/ref/WeakReference
    //   771: dup
    //   772: aload_1
    //   773: invokespecial 230	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   776: invokevirtual 234	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   779: pop
    //   780: aload 4
    //   782: monitorexit
    //   783: ldc2_w 252
    //   786: ldc -2
    //   788: invokestatic 43	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   791: return
    //   792: astore_1
    //   793: aload_3
    //   794: ifnonnull +67 -> 861
    //   797: new 236	java/lang/UnsatisfiedLinkError
    //   800: dup
    //   801: new 126	java/lang/StringBuilder
    //   804: dup
    //   805: ldc_w 340
    //   808: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   811: aload_0
    //   812: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   818: invokespecial 239	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   821: aload_1
    //   822: invokevirtual 243	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   825: invokevirtual 247	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   828: checkcast 236	java/lang/UnsatisfiedLinkError
    //   831: athrow
    //   832: astore_1
    //   833: aload 4
    //   835: monitorexit
    //   836: aload_1
    //   837: athrow
    //   838: astore_0
    //   839: aload_3
    //   840: ifnonnull +23 -> 863
    //   843: new 236	java/lang/UnsatisfiedLinkError
    //   846: dup
    //   847: ldc_w 335
    //   850: invokespecial 239	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   853: aload_0
    //   854: invokevirtual 247	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   857: checkcast 236	java/lang/UnsatisfiedLinkError
    //   860: athrow
    //   861: aload_3
    //   862: athrow
    //   863: aload_3
    //   864: athrow
    //   865: astore 4
    //   867: goto -120 -> 747
    //   870: astore_1
    //   871: goto -337 -> 534
    //   874: astore_0
    //   875: aconst_null
    //   876: astore 4
    //   878: goto -354 -> 524
    //   881: astore_0
    //   882: aconst_null
    //   883: astore 4
    //   885: goto -380 -> 505
    //   888: goto -452 -> 436
    //   891: aconst_null
    //   892: astore_3
    //   893: goto -507 -> 386
    //   896: aconst_null
    //   897: astore_3
    //   898: goto -839 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	901	0	paramString	String
    //   0	901	1	paramClassLoader	ClassLoader
    //   20	62	2	bool	boolean
    //   46	323	3	localObject1	Object
    //   379	51	3	localUnsatisfiedLinkError1	UnsatisfiedLinkError
    //   435	104	3	localUnsatisfiedLinkError2	UnsatisfiedLinkError
    //   543	12	3	localInvocationTargetException1	InvocationTargetException
    //   561	337	3	localUnsatisfiedLinkError3	UnsatisfiedLinkError
    //   31	385	4	localHashMap1	HashMap
    //   427	7	4	localUnsatisfiedLinkError4	UnsatisfiedLinkError
    //   455	75	4	localObject2	Object
    //   536	100	4	localObject3	Object
    //   641	54	4	localInvocationTargetException2	InvocationTargetException
    //   865	1	4	localIOException	java.io.IOException
    //   876	8	4	localObject4	Object
    //   167	576	5	localObject5	Object
    //   327	421	6	localFile	File
    //   633	6	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   36	47	116	finally
    //   51	59	116	finally
    //   68	71	116	finally
    //   85	116	116	finally
    //   117	120	116	finally
    //   122	125	116	finally
    //   180	191	218	java/lang/reflect/InvocationTargetException
    //   209	217	218	java/lang/reflect/InvocationTargetException
    //   256	258	218	java/lang/reflect/InvocationTargetException
    //   191	209	253	finally
    //   254	256	253	finally
    //   180	191	258	java/lang/Exception
    //   209	217	258	java/lang/Exception
    //   256	258	258	java/lang/Exception
    //   337	352	379	java/lang/UnsatisfiedLinkError
    //   370	378	379	java/lang/UnsatisfiedLinkError
    //   540	543	379	java/lang/UnsatisfiedLinkError
    //   386	399	427	java/lang/UnsatisfiedLinkError
    //   418	426	427	java/lang/UnsatisfiedLinkError
    //   638	641	427	java/lang/UnsatisfiedLinkError
    //   457	471	500	java/lang/Exception
    //   475	500	500	java/lang/Exception
    //   457	471	523	finally
    //   475	500	523	finally
    //   505	523	523	finally
    //   352	370	536	finally
    //   538	540	536	finally
    //   337	352	543	java/lang/reflect/InvocationTargetException
    //   370	378	543	java/lang/reflect/InvocationTargetException
    //   540	543	543	java/lang/reflect/InvocationTargetException
    //   337	352	600	java/lang/Throwable
    //   370	378	600	java/lang/Throwable
    //   540	543	600	java/lang/Throwable
    //   399	418	633	finally
    //   635	638	633	finally
    //   386	399	641	java/lang/reflect/InvocationTargetException
    //   418	426	641	java/lang/reflect/InvocationTargetException
    //   638	641	641	java/lang/reflect/InvocationTargetException
    //   386	399	709	java/lang/Throwable
    //   418	426	709	java/lang/Throwable
    //   638	641	709	java/lang/Throwable
    //   747	764	792	java/lang/reflect/InvocationTargetException
    //   783	791	792	java/lang/reflect/InvocationTargetException
    //   836	838	792	java/lang/reflect/InvocationTargetException
    //   764	783	832	finally
    //   833	836	832	finally
    //   747	764	838	java/lang/Exception
    //   783	791	838	java/lang/Exception
    //   836	838	838	java/lang/Exception
    //   742	747	865	java/io/IOException
    //   529	534	870	java/io/IOException
    //   436	453	874	finally
    //   436	453	881	java/lang/Exception
  }
  
  public static boolean dx(String paramString)
  {
    GMTrace.i(13780671004672L, 102674);
    synchronized (mLoadedLibs)
    {
      boolean bool = mLoadedLibs.containsKey(paramString);
      GMTrace.o(13780671004672L, 102674);
      return bool;
    }
  }
  
  public static String dy(String paramString)
  {
    GMTrace.i(13780805222400L, 102675);
    try
    {
      Object localObject1 = k.class.getClassLoader();
      Object localObject3 = ClassLoader.class.getDeclaredMethod("findLibrary", new Class[] { String.class });
      ((Method)localObject3).setAccessible(true);
      localObject1 = (String)((Method)localObject3).invoke(localObject1, new Object[] { paramString });
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        paramString = new File(aa.getContext().getDir("recover_lib", 0), "lib" + paramString + ".so");
        localObject3 = localObject1;
        if (paramString.canRead()) {
          localObject3 = paramString.getAbsolutePath();
        }
      }
      GMTrace.o(13780805222400L, 102675);
      return (String)localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
  
  private static boolean extractLibrary(ZipFile paramZipFile, String paramString, List<String> paramList, File paramFile)
  {
    GMTrace.i(13781610528768L, 102681);
    if (paramFile.isFile())
    {
      GMTrace.o(13781610528768L, 102681);
      return true;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      localObject = paramZipFile.getEntry("lib/" + (String)localObject + "/lib" + paramString + ".so");
      if (localObject != null)
      {
        paramZipFile = paramZipFile.getInputStream((ZipEntry)localObject);
        paramString = new FileOutputStream(paramFile);
        paramList = new byte['ࠀ'];
        try
        {
          for (;;)
          {
            int i = paramZipFile.read(paramList, 0, 2048);
            if (i == -1) {
              break;
            }
            paramString.write(paramList, 0, i);
          }
          paramZipFile.close();
        }
        finally
        {
          paramZipFile.close();
          paramString.close();
        }
        paramString.close();
        paramFile.setReadOnly();
        GMTrace.o(13781610528768L, 102681);
        return true;
      }
    }
    GMTrace.o(13781610528768L, 102681);
    return false;
  }
  
  private static List<String> generateAbiList()
  {
    GMTrace.i(13781476311040L, 102680);
    ArrayList localArrayList = new ArrayList(3);
    String str = x.get("ro.product.cpu.abi");
    if ((str != null) && (str.length() > 0)) {
      localArrayList.add(str);
    }
    str = x.get("ro.product.cpu.abi2");
    if ((str != null) && (str.length() > 0)) {
      localArrayList.add(str);
    }
    localArrayList.add("armeabi");
    GMTrace.o(13781476311040L, 102680);
    return localArrayList;
  }
  
  private static void reflectSystemLoad(String paramString, ClassLoader paramClassLoader)
  {
    GMTrace.i(13781207875584L, 102678);
    Runtime localRuntime = Runtime.getRuntime();
    Method localMethod = localRuntime.getClass().getDeclaredMethod("load", new Class[] { String.class, ClassLoader.class });
    localMethod.setAccessible(true);
    localMethod.invoke(localRuntime, new Object[] { paramString, paramClassLoader });
    GMTrace.o(13781207875584L, 102678);
  }
  
  private static void reflectSystemLoadlibrary(String paramString, ClassLoader paramClassLoader)
  {
    GMTrace.i(13781342093312L, 102679);
    Runtime localRuntime = Runtime.getRuntime();
    Method localMethod = localRuntime.getClass().getDeclaredMethod("loadLibrary", new Class[] { String.class, ClassLoader.class });
    localMethod.setAccessible(true);
    localMethod.invoke(localRuntime, new Object[] { paramString, paramClassLoader });
    GMTrace.o(13781342093312L, 102679);
  }
  
  public static void setupBrokenLibraryHandler()
  {
    GMTrace.i(13781744746496L, 102682);
    Thread.setDefaultUncaughtExceptionHandler(new a(Thread.getDefaultUncaughtExceptionHandler()));
    GMTrace.o(13781744746496L, 102682);
  }
  
  public static void si()
  {
    GMTrace.i(16090155450368L, 119881);
    List localList = generateAbiList();
    File localFile = aa.getContext().getDir("recover_lib", 0);
    ZipFile localZipFile = new ZipFile(aa.getContext().getApplicationInfo().sourceDir);
    try
    {
      HashSet localHashSet = new HashSet();
      Pattern localPattern = Pattern.compile("lib/[A-Za-z0-9-_=]+/lib([A-Za-z0-9-_=]+)\\.so");
      Enumeration localEnumeration = localZipFile.entries();
      while (localEnumeration.hasMoreElements())
      {
        Object localObject2 = localPattern.matcher(((ZipEntry)localEnumeration.nextElement()).getName());
        if (((Matcher)localObject2).matches())
        {
          localObject2 = ((Matcher)localObject2).group(1);
          if (!localHashSet.contains(localObject2))
          {
            extractLibrary(localZipFile, (String)localObject2, localList, new File(localFile, "lib" + (String)localObject2 + ".so"));
            localHashSet.add(localObject2);
          }
        }
      }
    }
    finally
    {
      localZipFile.close();
    }
    GMTrace.o(16090155450368L, 119881);
  }
  
  private static final class a
    implements Thread.UncaughtExceptionHandler
  {
    private Thread.UncaughtExceptionHandler mParent;
    
    public a(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
    {
      GMTrace.i(13784429101056L, 102702);
      this.mParent = paramUncaughtExceptionHandler;
      GMTrace.o(13784429101056L, 102702);
    }
    
    public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
    {
      int j = 1;
      GMTrace.i(13784563318784L, 102703);
      int i;
      if (((paramThrowable instanceof UnsatisfiedLinkError)) || (((paramThrowable instanceof NoSuchMethodError)) && (paramThrowable.getMessage().matches(".*sig(nature)?[=:].*"))))
      {
        i = 1;
        if (i == 0) {
          break label99;
        }
      }
      for (;;)
      {
        try
        {
          k.si();
          i = j;
          Throwable localThrowable = paramThrowable;
          if (i != 0) {
            localThrowable = new UnsatisfiedLinkError("Invalid JNI libraries detected and recovered.").initCause(paramThrowable);
          }
          this.mParent.uncaughtException(paramThread, localThrowable);
          GMTrace.o(13784563318784L, 102703);
          return;
        }
        catch (Exception localException) {}
        i = 0;
        break;
        label99:
        i = 0;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/compatible/util/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */