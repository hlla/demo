package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.z;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class v
{
  public static boolean a(Context paramContext, ArrayList<c> paramArrayList, boolean paramBoolean)
  {
    GMTrace.i(471775313920L, 3515);
    if (paramArrayList.size() == 0)
    {
      GMTrace.o(471775313920L, 3515);
      return false;
    }
    Iterator localIterator = paramArrayList.iterator();
    c localc;
    Object localObject2;
    Object localObject1;
    Object localObject3;
    int i;
    label133:
    label243:
    label262:
    do
    {
      while (!((Iterator)localObject1).hasNext())
      {
        do
        {
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localc = (c)localIterator.next();
          } while (TextUtils.isEmpty(localc.fwG));
          localObject2 = localc.fwG;
          localObject1 = new ArrayList();
          localObject3 = paramContext.getPackageResourcePath();
          if (Build.VERSION.SDK_INT < 21) {
            break label608;
          }
          paramArrayList = ((String)localObject3).split("/");
          if (paramArrayList != null)
          {
            i = 0;
            if (i >= paramArrayList.length) {
              break label835;
            }
            if (!paramArrayList[i].contains(paramContext.getPackageName())) {
              break;
            }
            paramArrayList = paramArrayList[i];
            if (!TextUtils.isEmpty(paramArrayList))
            {
              String str = ((String)localObject3).replace(paramArrayList, (String)localObject2 + "-1");
              if (new File(str).exists()) {
                ((List)localObject1).add(str);
              }
              paramArrayList = ((String)localObject3).replace(paramArrayList, (String)localObject2 + "-2");
              if (new File(paramArrayList).exists()) {
                ((List)localObject1).add(paramArrayList);
              }
            }
          }
        } while (((List)localObject1).size() <= 0);
        localObject1 = ((List)localObject1).iterator();
      }
      localObject2 = new File((String)((Iterator)localObject1).next());
    } while (!((File)localObject2).exists());
    paramArrayList = "";
    for (;;)
    {
      try
      {
        long l = System.currentTimeMillis();
        if (paramBoolean)
        {
          localObject2 = paramContext.getPackageManager().getPackageInfo(localc.fwG, 64);
          if (((PackageInfo)localObject2).signatures.length <= 0) {
            break label841;
          }
          paramArrayList = z.Pp(localObject2.signatures[(localObject2.signatures.length - 1)].toCharsString());
          break label841;
          localObject2 = localc.fwG;
          localObject3 = localc.ijH;
          if ((TextUtils.isEmpty(paramArrayList)) || (!paramArrayList.equalsIgnoreCase(localc.ijH))) {
            break label844;
          }
          bool = true;
          com.tencent.mm.sdk.platformtools.v.i("MicroMsg.YYBMarketVerify", "summertoken containLowerMarket usesSystemApi[%b], infopkg[%s], infoMD5[%s], sigMD5[%s], equal[%b], takes[%d]ms", new Object[] { Boolean.valueOf(paramBoolean), localObject2, localObject3, paramArrayList, Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
          if ((TextUtils.isEmpty(paramArrayList)) || (!paramArrayList.equalsIgnoreCase(localc.ijH))) {
            break label262;
          }
          l = System.currentTimeMillis();
          if (!paramBoolean) {
            continue;
          }
          i = paramContext.getPackageManager().getPackageInfo(localc.fwG, 0).versionCode;
          paramArrayList = localc.fwG;
          int j = localc.ijG;
          if (i > localc.ijG) {
            continue;
          }
          bool = true;
          com.tencent.mm.sdk.platformtools.v.i("MicroMsg.YYBMarketVerify", "summertoken containLowerMarket usesSystemApi[%b], infopkg[%s], infovc[%d], versionCode[%d], less[%b], takes[%d]ms", new Object[] { Boolean.valueOf(paramBoolean), paramArrayList, Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
          j = localc.ijG;
          if (i > j) {
            break label262;
          }
          GMTrace.o(471775313920L, 3515);
          return true;
          i += 1;
          break;
          label608:
          paramArrayList = ((String)localObject3).split("/");
          if (paramArrayList == null) {
            break label243;
          }
          localObject3 = new StringBuilder();
          i = 0;
          if (i < paramArrayList.length)
          {
            if (i != paramArrayList.length - 1)
            {
              ((StringBuilder)localObject3).append(paramArrayList[i]);
              ((StringBuilder)localObject3).append("/");
            }
            i += 1;
            continue;
          }
          paramArrayList = ((StringBuilder)localObject3).toString();
          localObject3 = paramArrayList + (String)localObject2 + "-1.apk";
          if (new File((String)localObject3).exists()) {
            ((List)localObject1).add(localObject3);
          }
          paramArrayList = paramArrayList + (String)localObject2 + "-2.apk";
          if (!new File(paramArrayList).exists()) {
            break label243;
          }
          ((List)localObject1).add(paramArrayList);
          break label243;
        }
        paramArrayList = b.m(((File)localObject2).getAbsoluteFile());
        continue;
        i = a.G(paramContext, localc.fwG);
        continue;
        bool = false;
        continue;
      }
      catch (Exception paramArrayList)
      {
        com.tencent.mm.sdk.platformtools.v.printErrStackTrace("MicroMsg.YYBMarketVerify", paramArrayList, "", new Object[0]);
      }
      GMTrace.o(471775313920L, 3515);
      return false;
      label835:
      paramArrayList = "";
      break label133;
      label841:
      continue;
      label844:
      boolean bool = false;
    }
  }
  
  public static final class a
  {
    /* Error */
    public static int G(Context paramContext, String paramString)
    {
      // Byte code:
      //   0: ldc2_w 16
      //   3: sipush 3505
      //   6: invokestatic 23	com/tencent/gmtrace/GMTrace:i	(JI)V
      //   9: aload_0
      //   10: aload_1
      //   11: iconst_0
      //   12: invokevirtual 29	android/content/Context:createPackageContext	(Ljava/lang/String;I)Landroid/content/Context;
      //   15: astore_1
      //   16: aload_1
      //   17: ifnonnull +32 -> 49
      //   20: ldc2_w 16
      //   23: sipush 3505
      //   26: invokestatic 32	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   29: iconst_0
      //   30: ireturn
      //   31: astore_1
      //   32: ldc 34
      //   34: aload_1
      //   35: ldc 36
      //   37: iconst_0
      //   38: anewarray 4	java/lang/Object
      //   41: invokestatic 42	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   44: aconst_null
      //   45: astore_1
      //   46: goto -30 -> 16
      //   49: aload_1
      //   50: invokevirtual 46	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
      //   53: astore 5
      //   55: new 48	android/content/res/Resources
      //   58: dup
      //   59: aload 5
      //   61: aload_0
      //   62: invokevirtual 52	android/content/Context:getResources	()Landroid/content/res/Resources;
      //   65: invokevirtual 56	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
      //   68: aconst_null
      //   69: invokespecial 60	android/content/res/Resources:<init>	(Landroid/content/res/AssetManager;Landroid/util/DisplayMetrics;Landroid/content/res/Configuration;)V
      //   72: astore 4
      //   74: aload_1
      //   75: aload 5
      //   77: invokestatic 63	com/tencent/mm/platformtools/v$a:a	(Landroid/content/Context;Landroid/content/res/AssetManager;)Landroid/content/res/XmlResourceParser;
      //   80: astore_0
      //   81: aload_0
      //   82: ifnonnull +32 -> 114
      //   85: ldc2_w 16
      //   88: sipush 3505
      //   91: invokestatic 32	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   94: iconst_0
      //   95: ireturn
      //   96: astore_0
      //   97: ldc 34
      //   99: aload_0
      //   100: ldc 36
      //   102: iconst_0
      //   103: anewarray 4	java/lang/Object
      //   106: invokestatic 42	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   109: aconst_null
      //   110: astore_0
      //   111: goto -30 -> 81
      //   114: aload_0
      //   115: invokeinterface 69 1 0
      //   120: istore_2
      //   121: iload_2
      //   122: iconst_1
      //   123: if_icmpeq +157 -> 280
      //   126: iload_2
      //   127: tableswitch	default:+17->144, 2:+47->174
      //   144: aload_0
      //   145: invokeinterface 72 1 0
      //   150: istore_3
      //   151: iload_3
      //   152: istore_2
      //   153: goto -32 -> 121
      //   156: astore_1
      //   157: ldc 34
      //   159: aload_1
      //   160: ldc 36
      //   162: iconst_0
      //   163: anewarray 4	java/lang/Object
      //   166: invokestatic 42	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   169: iconst_0
      //   170: istore_2
      //   171: goto -50 -> 121
      //   174: aload_0
      //   175: invokeinterface 76 1 0
      //   180: astore_1
      //   181: aload_1
      //   182: invokestatic 82	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   185: ifne -41 -> 144
      //   188: aload_1
      //   189: ldc 84
      //   191: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   194: ifeq -50 -> 144
      //   197: aload_0
      //   198: ldc 92
      //   200: ldc 94
      //   202: invokeinterface 98 3 0
      //   207: aload 4
      //   209: invokestatic 101	com/tencent/mm/platformtools/v$a:a	(Ljava/lang/String;Landroid/content/res/Resources;)Ljava/lang/String;
      //   212: astore_0
      //   213: aload_0
      //   214: invokestatic 82	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   217: ifeq +14 -> 231
      //   220: ldc2_w 16
      //   223: sipush 3505
      //   226: invokestatic 32	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   229: iconst_0
      //   230: ireturn
      //   231: aload_0
      //   232: iconst_0
      //   233: invokestatic 107	com/tencent/mm/platformtools/u:getInt	(Ljava/lang/String;I)I
      //   236: istore_2
      //   237: ldc2_w 16
      //   240: sipush 3505
      //   243: invokestatic 32	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   246: iload_2
      //   247: ireturn
      //   248: astore_1
      //   249: ldc 34
      //   251: aload_1
      //   252: ldc 36
      //   254: iconst_0
      //   255: anewarray 4	java/lang/Object
      //   258: invokestatic 42	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   261: goto -140 -> 121
      //   264: astore_1
      //   265: ldc 34
      //   267: aload_1
      //   268: ldc 36
      //   270: iconst_0
      //   271: anewarray 4	java/lang/Object
      //   274: invokestatic 42	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   277: goto -156 -> 121
      //   280: ldc2_w 16
      //   283: sipush 3505
      //   286: invokestatic 32	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   289: iconst_0
      //   290: ireturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	291	0	paramContext	Context
      //   0	291	1	paramString	String
      //   120	127	2	i	int
      //   150	2	3	j	int
      //   72	136	4	localResources	Resources
      //   53	23	5	localAssetManager	AssetManager
      // Exception table:
      //   from	to	target	type
      //   9	16	31	android/content/pm/PackageManager$NameNotFoundException
      //   74	81	96	java/io/IOException
      //   114	121	156	org/xmlpull/v1/XmlPullParserException
      //   144	151	248	org/xmlpull/v1/XmlPullParserException
      //   144	151	264	java/io/IOException
    }
    
    private static XmlResourceParser a(Context paramContext, AssetManager paramAssetManager)
    {
      int j = 1;
      GMTrace.i(470567354368L, 3506);
      try
      {
        String str2 = (String)Context.class.getMethod("getPackageResourcePath", new Class[0]).invoke(paramContext, new Object[0]);
        Method localMethod = AssetManager.class.getMethod("getCookieName", new Class[] { Integer.TYPE });
        String str1 = str2;
        int i = j;
        if (str2 == null)
        {
          str1 = str2;
          i = j;
          if (paramContext.getPackageName().equals("android"))
          {
            str1 = "/system/framework/framework-res.apk";
            i = j;
          }
        }
        while (i < 20)
        {
          if (str1 != null) {
            if (str1.equals(localMethod.invoke(paramAssetManager, new Object[] { Integer.valueOf(i) })))
            {
              paramContext = paramAssetManager.openXmlResourceParser(i, "AndroidManifest.xml");
              GMTrace.o(470567354368L, 3506);
              return paramContext;
            }
          }
          i += 1;
        }
        return paramContext;
      }
      catch (Exception paramContext)
      {
        paramContext = paramAssetManager.openXmlResourceParser("AndroidManifest.xml");
        GMTrace.o(470567354368L, 3506);
      }
    }
    
    private static String a(String paramString, Resources paramResources)
    {
      GMTrace.i(470701572096L, 3507);
      if ((paramString == null) || (!paramString.startsWith("@")))
      {
        GMTrace.o(470701572096L, 3507);
        return paramString;
      }
      try
      {
        paramResources = paramResources.getString(Integer.parseInt(paramString.substring(1)));
        GMTrace.o(470701572096L, 3507);
        return paramResources;
      }
      catch (NumberFormatException paramResources)
      {
        GMTrace.o(470701572096L, 3507);
        return paramString;
      }
      catch (Resources.NotFoundException paramResources)
      {
        GMTrace.o(470701572096L, 3507);
      }
      return paramString;
    }
  }
  
  public static final class b
  {
    private static char[] H(byte[] paramArrayOfByte)
    {
      GMTrace.i(454595444736L, 3387);
      int k = paramArrayOfByte.length;
      char[] arrayOfChar = new char[k * 2];
      int i = 0;
      if (i < k)
      {
        int m = paramArrayOfByte[i];
        int j = m >> 4 & 0xF;
        if (j >= 10)
        {
          j = j + 97 - 10;
          label53:
          arrayOfChar[(i * 2)] = ((char)j);
          j = m & 0xF;
          if (j < 10) {
            break label106;
          }
          j = j + 97 - 10;
        }
        for (;;)
        {
          arrayOfChar[(i * 2 + 1)] = ((char)j);
          i += 1;
          break;
          j += 48;
          break label53;
          label106:
          j += 48;
        }
      }
      GMTrace.o(454595444736L, 3387);
      return arrayOfChar;
    }
    
    /* Error */
    public static String m(File paramFile)
    {
      // Byte code:
      //   0: ldc2_w 28
      //   3: sipush 3386
      //   6: invokestatic 17	com/tencent/gmtrace/GMTrace:i	(JI)V
      //   9: aconst_null
      //   10: astore_3
      //   11: aconst_null
      //   12: astore 6
      //   14: aconst_null
      //   15: astore 5
      //   17: new 31	java/util/jar/JarFile
      //   20: dup
      //   21: aload_0
      //   22: invokespecial 35	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
      //   25: astore 4
      //   27: aload 6
      //   29: astore_3
      //   30: sipush 8192
      //   33: newarray <illegal type>
      //   35: astore 7
      //   37: aload 6
      //   39: astore_3
      //   40: aload 4
      //   42: invokevirtual 39	java/util/jar/JarFile:entries	()Ljava/util/Enumeration;
      //   45: astore 8
      //   47: aconst_null
      //   48: astore_0
      //   49: aconst_null
      //   50: astore_3
      //   51: aload_0
      //   52: astore 6
      //   54: aload_0
      //   55: astore 5
      //   57: aload 8
      //   59: invokeinterface 45 1 0
      //   64: ifeq +619 -> 683
      //   67: aload_0
      //   68: astore 6
      //   70: aload_0
      //   71: astore 5
      //   73: aload 8
      //   75: invokeinterface 49 1 0
      //   80: checkcast 51	java/util/jar/JarEntry
      //   83: astore 9
      //   85: aload_0
      //   86: astore 6
      //   88: aload_0
      //   89: astore 5
      //   91: aload 9
      //   93: invokevirtual 54	java/util/jar/JarEntry:isDirectory	()Z
      //   96: ifne -45 -> 51
      //   99: aload_0
      //   100: astore 6
      //   102: aload_0
      //   103: astore 5
      //   105: aload 9
      //   107: invokevirtual 58	java/util/jar/JarEntry:getName	()Ljava/lang/String;
      //   110: ldc 60
      //   112: invokevirtual 66	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   115: ifne -64 -> 51
      //   118: aload_0
      //   119: astore 6
      //   121: aload_0
      //   122: astore 5
      //   124: aload 9
      //   126: invokevirtual 58	java/util/jar/JarEntry:getName	()Ljava/lang/String;
      //   129: astore 10
      //   131: aload_0
      //   132: astore 6
      //   134: aload_0
      //   135: astore 5
      //   137: ldc 68
      //   139: aload 10
      //   141: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   144: ifne -93 -> 51
      //   147: aload_0
      //   148: astore 6
      //   150: aload_0
      //   151: astore 5
      //   153: ldc 74
      //   155: aload 10
      //   157: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   160: ifne -109 -> 51
      //   163: aload_0
      //   164: astore 6
      //   166: aload_0
      //   167: astore 5
      //   169: aload 9
      //   171: invokevirtual 78	java/util/jar/JarEntry:getSize	()J
      //   174: ldc2_w 79
      //   177: lcmp
      //   178: ifgt -127 -> 51
      //   181: aload_0
      //   182: astore 6
      //   184: aload_0
      //   185: astore 5
      //   187: invokestatic 85	java/lang/System:currentTimeMillis	()J
      //   190: lstore_1
      //   191: aload_0
      //   192: astore 6
      //   194: aload_0
      //   195: astore 5
      //   197: ldc 87
      //   199: new 89	java/lang/StringBuilder
      //   202: dup
      //   203: ldc 91
      //   205: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   208: aload 10
      //   210: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   213: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   216: invokestatic 107	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   219: aload_0
      //   220: astore 6
      //   222: aload_0
      //   223: astore 5
      //   225: aload 4
      //   227: aload 9
      //   229: invokevirtual 111	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
      //   232: astore_0
      //   233: aload_0
      //   234: astore 6
      //   236: aload_0
      //   237: astore 5
      //   239: ldc 87
      //   241: new 89	java/lang/StringBuilder
      //   244: dup
      //   245: ldc 113
      //   247: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   250: invokestatic 85	java/lang/System:currentTimeMillis	()J
      //   253: lload_1
      //   254: lsub
      //   255: invokevirtual 116	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   258: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   261: invokestatic 107	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   264: aload_0
      //   265: ifnull +33 -> 298
      //   268: aload_0
      //   269: astore 6
      //   271: aload_0
      //   272: astore 5
      //   274: aload_0
      //   275: aload 7
      //   277: iconst_0
      //   278: sipush 8192
      //   281: invokevirtual 122	java/io/InputStream:read	([BII)I
      //   284: iconst_m1
      //   285: if_icmpne -17 -> 268
      //   288: aload_0
      //   289: astore 6
      //   291: aload_0
      //   292: astore 5
      //   294: aload_0
      //   295: invokevirtual 126	java/io/InputStream:close	()V
      //   298: aload_0
      //   299: astore 6
      //   301: aload_0
      //   302: astore 5
      //   304: aload 9
      //   306: invokevirtual 130	java/util/jar/JarEntry:getCertificates	()[Ljava/security/cert/Certificate;
      //   309: astore 10
      //   311: aload 10
      //   313: ifnull +15 -> 328
      //   316: aload_0
      //   317: astore 6
      //   319: aload_0
      //   320: astore 5
      //   322: aload 10
      //   324: arraylength
      //   325: ifne +95 -> 420
      //   328: aload_0
      //   329: astore 6
      //   331: aload_0
      //   332: astore 5
      //   334: new 132	java/lang/SecurityException
      //   337: dup
      //   338: new 89	java/lang/StringBuilder
      //   341: dup
      //   342: ldc -122
      //   344: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   347: aload 9
      //   349: invokevirtual 58	java/util/jar/JarEntry:getName	()Ljava/lang/String;
      //   352: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   355: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   358: invokespecial 135	java/lang/SecurityException:<init>	(Ljava/lang/String;)V
      //   361: athrow
      //   362: astore 5
      //   364: aload 6
      //   366: astore_0
      //   367: aload 4
      //   369: astore_3
      //   370: aload 5
      //   372: astore 4
      //   374: ldc -119
      //   376: aload 4
      //   378: ldc -117
      //   380: iconst_0
      //   381: anewarray 4	java/lang/Object
      //   384: invokestatic 143	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   387: aload 4
      //   389: athrow
      //   390: astore 5
      //   392: aload_3
      //   393: astore 4
      //   395: aload_0
      //   396: astore_3
      //   397: aload 5
      //   399: astore_0
      //   400: aload_3
      //   401: ifnull +7 -> 408
      //   404: aload_3
      //   405: invokevirtual 126	java/io/InputStream:close	()V
      //   408: aload 4
      //   410: ifnull +8 -> 418
      //   413: aload 4
      //   415: invokevirtual 144	java/util/jar/JarFile:close	()V
      //   418: aload_0
      //   419: athrow
      //   420: aload_3
      //   421: ifnonnull +259 -> 680
      //   424: aload_0
      //   425: astore 6
      //   427: aload_0
      //   428: astore 5
      //   430: aload 10
      //   432: iconst_0
      //   433: aaload
      //   434: checkcast 146	java/security/cert/X509Certificate
      //   437: astore_3
      //   438: aload_3
      //   439: ifnonnull +6 -> 445
      //   442: goto -391 -> 51
      //   445: aload_3
      //   446: astore 5
      //   448: aload 5
      //   450: ifnull +85 -> 535
      //   453: aload_0
      //   454: astore_3
      //   455: new 62	java/lang/String
      //   458: dup
      //   459: aload 5
      //   461: invokevirtual 150	java/security/cert/X509Certificate:getEncoded	()[B
      //   464: invokestatic 152	com/tencent/mm/platformtools/v$b:H	([B)[C
      //   467: invokespecial 155	java/lang/String:<init>	([C)V
      //   470: invokevirtual 158	java/lang/String:getBytes	()[B
      //   473: invokestatic 164	com/tencent/mm/sdk/platformtools/z:bj	([B)Ljava/lang/String;
      //   476: astore 5
      //   478: aload_0
      //   479: ifnull +7 -> 486
      //   482: aload_0
      //   483: invokevirtual 126	java/io/InputStream:close	()V
      //   486: aload 4
      //   488: invokevirtual 144	java/util/jar/JarFile:close	()V
      //   491: ldc2_w 28
      //   494: sipush 3386
      //   497: invokestatic 20	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   500: aload 5
      //   502: areturn
      //   503: astore_0
      //   504: ldc -119
      //   506: aload_0
      //   507: ldc -117
      //   509: iconst_0
      //   510: anewarray 4	java/lang/Object
      //   513: invokestatic 143	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   516: goto -30 -> 486
      //   519: astore_0
      //   520: ldc -119
      //   522: aload_0
      //   523: ldc -117
      //   525: iconst_0
      //   526: anewarray 4	java/lang/Object
      //   529: invokestatic 143	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   532: goto -41 -> 491
      //   535: aload_0
      //   536: ifnull +7 -> 543
      //   539: aload_0
      //   540: invokevirtual 126	java/io/InputStream:close	()V
      //   543: aload 4
      //   545: invokevirtual 144	java/util/jar/JarFile:close	()V
      //   548: ldc2_w 28
      //   551: sipush 3386
      //   554: invokestatic 20	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   557: ldc -117
      //   559: areturn
      //   560: astore_0
      //   561: ldc -119
      //   563: aload_0
      //   564: ldc -117
      //   566: iconst_0
      //   567: anewarray 4	java/lang/Object
      //   570: invokestatic 143	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   573: goto -30 -> 543
      //   576: astore_0
      //   577: ldc -119
      //   579: aload_0
      //   580: ldc -117
      //   582: iconst_0
      //   583: anewarray 4	java/lang/Object
      //   586: invokestatic 143	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   589: goto -41 -> 548
      //   592: astore_3
      //   593: ldc -119
      //   595: aload_3
      //   596: ldc -117
      //   598: iconst_0
      //   599: anewarray 4	java/lang/Object
      //   602: invokestatic 143	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   605: goto -197 -> 408
      //   608: astore_3
      //   609: ldc -119
      //   611: aload_3
      //   612: ldc -117
      //   614: iconst_0
      //   615: anewarray 4	java/lang/Object
      //   618: invokestatic 143	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   621: goto -203 -> 418
      //   624: astore_0
      //   625: aconst_null
      //   626: astore 4
      //   628: aconst_null
      //   629: astore_3
      //   630: goto -230 -> 400
      //   633: astore_0
      //   634: aconst_null
      //   635: astore_3
      //   636: goto -236 -> 400
      //   639: astore_0
      //   640: aload 5
      //   642: astore_3
      //   643: goto -243 -> 400
      //   646: astore 5
      //   648: aload_0
      //   649: astore_3
      //   650: aload 5
      //   652: astore_0
      //   653: goto -253 -> 400
      //   656: astore 4
      //   658: aload 5
      //   660: astore_0
      //   661: goto -287 -> 374
      //   664: astore_0
      //   665: aload 4
      //   667: astore 5
      //   669: aload_0
      //   670: astore 4
      //   672: aload_3
      //   673: astore_0
      //   674: aload 5
      //   676: astore_3
      //   677: goto -303 -> 374
      //   680: goto -238 -> 442
      //   683: aload_3
      //   684: astore 5
      //   686: goto -238 -> 448
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	689	0	paramFile	File
      //   190	64	1	l	long
      //   10	445	3	localObject1	Object
      //   592	4	3	localIOException1	java.io.IOException
      //   608	4	3	localIOException2	java.io.IOException
      //   629	55	3	localObject2	Object
      //   25	602	4	localObject3	Object
      //   656	10	4	localException1	Exception
      //   670	1	4	localFile1	File
      //   15	318	5	localFile2	File
      //   362	9	5	localException2	Exception
      //   390	8	5	localObject4	Object
      //   428	213	5	localObject5	Object
      //   646	13	5	localObject6	Object
      //   667	18	5	localObject7	Object
      //   12	414	6	localFile3	File
      //   35	241	7	arrayOfByte	byte[]
      //   45	29	8	localEnumeration	java.util.Enumeration
      //   83	265	9	localJarEntry	java.util.jar.JarEntry
      //   129	302	10	localObject8	Object
      // Exception table:
      //   from	to	target	type
      //   57	67	362	java/lang/Exception
      //   73	85	362	java/lang/Exception
      //   91	99	362	java/lang/Exception
      //   105	118	362	java/lang/Exception
      //   124	131	362	java/lang/Exception
      //   137	147	362	java/lang/Exception
      //   153	163	362	java/lang/Exception
      //   169	181	362	java/lang/Exception
      //   187	191	362	java/lang/Exception
      //   197	219	362	java/lang/Exception
      //   225	233	362	java/lang/Exception
      //   239	264	362	java/lang/Exception
      //   274	288	362	java/lang/Exception
      //   294	298	362	java/lang/Exception
      //   304	311	362	java/lang/Exception
      //   322	328	362	java/lang/Exception
      //   334	362	362	java/lang/Exception
      //   430	438	362	java/lang/Exception
      //   374	390	390	finally
      //   482	486	503	java/io/IOException
      //   486	491	519	java/io/IOException
      //   539	543	560	java/io/IOException
      //   543	548	576	java/io/IOException
      //   404	408	592	java/io/IOException
      //   413	418	608	java/io/IOException
      //   17	27	624	finally
      //   30	37	633	finally
      //   40	47	633	finally
      //   57	67	639	finally
      //   73	85	639	finally
      //   91	99	639	finally
      //   105	118	639	finally
      //   124	131	639	finally
      //   137	147	639	finally
      //   153	163	639	finally
      //   169	181	639	finally
      //   187	191	639	finally
      //   197	219	639	finally
      //   225	233	639	finally
      //   239	264	639	finally
      //   274	288	639	finally
      //   294	298	639	finally
      //   304	311	639	finally
      //   322	328	639	finally
      //   334	362	639	finally
      //   430	438	639	finally
      //   455	478	646	finally
      //   17	27	656	java/lang/Exception
      //   30	37	664	java/lang/Exception
      //   40	47	664	java/lang/Exception
      //   455	478	664	java/lang/Exception
    }
  }
  
  public static final class c
  {
    public final String fwG;
    public final int ijG;
    public final String ijH;
    
    public c(String paramString1, int paramInt, String paramString2)
    {
      GMTrace.i(456206057472L, 3399);
      this.fwG = paramString1;
      this.ijG = paramInt;
      this.ijH = paramString2;
      GMTrace.o(456206057472L, 3399);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/platformtools/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */