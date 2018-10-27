package android.support.e;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
{
  private static final boolean a = a(System.getProperty("java.vm.version"));
  private static final Set b = new HashSet();
  
  private static File a(Context paramContext, ApplicationInfo paramApplicationInfo)
  {
    paramApplicationInfo = new File(paramApplicationInfo.dataDir, "code_cache");
    try
    {
      a(paramApplicationInfo);
      paramContext = paramApplicationInfo;
    }
    catch (IOException paramApplicationInfo)
    {
      for (;;)
      {
        paramContext = new File(paramContext.getFilesDir(), "code_cache");
        a(paramContext);
      }
    }
    paramContext = new File(paramContext, "secondary-dexes");
    a(paramContext);
    return paramContext;
  }
  
  private static Field a(Object paramObject, String paramString)
  {
    Object localObject = paramObject.getClass();
    for (;;)
    {
      if (localObject != null) {}
      try
      {
        Field localField = ((Class)localObject).getDeclaredField(paramString);
        if (!localField.isAccessible()) {
          localField.setAccessible(true);
        }
        return localField;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localObject = ((Class)localObject).getSuperclass();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Field ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" not found in ");
      ((StringBuilder)localObject).append(paramObject.getClass());
      throw new NoSuchFieldException(((StringBuilder)localObject).toString());
    }
  }
  
  private static Method a(Object paramObject, String paramString, Class... paramVarArgs)
  {
    Object localObject = paramObject.getClass();
    for (;;)
    {
      if (localObject != null) {}
      try
      {
        Method localMethod = ((Class)localObject).getDeclaredMethod(paramString, paramVarArgs);
        if (!localMethod.isAccessible()) {
          localMethod.setAccessible(true);
        }
        return localMethod;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        localObject = ((Class)localObject).getSuperclass();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Method ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" with parameters ");
      ((StringBuilder)localObject).append(Arrays.asList(paramVarArgs));
      ((StringBuilder)localObject).append(" not found in ");
      ((StringBuilder)localObject).append(paramObject.getClass());
      throw new NoSuchMethodException(((StringBuilder)localObject).toString());
    }
  }
  
  /* Error */
  public static void a(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc -119
    //   4: ldc -117
    //   6: invokestatic 145	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: getstatic 30	android/support/e/a:a	Z
    //   13: ifeq +12 -> 25
    //   16: ldc -119
    //   18: ldc -109
    //   20: invokestatic 145	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   23: pop
    //   24: return
    //   25: aload_0
    //   26: invokestatic 150	android/support/e/a:b	(Landroid/content/Context;)Landroid/content/pm/ApplicationInfo;
    //   29: astore 6
    //   31: aload 6
    //   33: ifnull -9 -> 24
    //   36: getstatic 17	android/support/e/a:b	Ljava/util/Set;
    //   39: astore 5
    //   41: aload 5
    //   43: monitorenter
    //   44: aload 6
    //   46: getfield 153	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   49: astore 7
    //   51: getstatic 17	android/support/e/a:b	Ljava/util/Set;
    //   54: aload 7
    //   56: invokeinterface 159 2 0
    //   61: ifne +1134 -> 1195
    //   64: getstatic 17	android/support/e/a:b	Ljava/util/Set;
    //   67: aload 7
    //   69: invokeinterface 162 2 0
    //   74: pop
    //   75: getstatic 168	android/os/Build$VERSION:SDK_INT	I
    //   78: istore_1
    //   79: iload_1
    //   80: bipush 20
    //   82: if_icmpgt +1008 -> 1090
    //   85: aload_0
    //   86: invokevirtual 172	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   89: astore 7
    //   91: aload 7
    //   93: ifnonnull +79 -> 172
    //   96: ldc -119
    //   98: ldc -82
    //   100: invokestatic 177	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   103: pop
    //   104: aload 5
    //   106: monitorexit
    //   107: return
    //   108: astore_0
    //   109: aload 5
    //   111: monitorexit
    //   112: aload_0
    //   113: athrow
    //   114: astore_0
    //   115: ldc -119
    //   117: ldc -77
    //   119: aload_0
    //   120: invokestatic 182	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   123: pop
    //   124: new 86	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   131: astore 5
    //   133: aload 5
    //   135: ldc -72
    //   137: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload 5
    //   143: aload_0
    //   144: invokevirtual 187	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   147: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload 5
    //   153: ldc -67
    //   155: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: new 135	java/lang/RuntimeException
    //   162: dup
    //   163: aload 5
    //   165: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokespecial 190	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   171: athrow
    //   172: new 36	java/io/File
    //   175: dup
    //   176: aload_0
    //   177: invokevirtual 61	android/content/Context:getFilesDir	()Ljava/io/File;
    //   180: ldc 52
    //   182: invokespecial 55	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   185: astore 8
    //   187: aload 8
    //   189: invokevirtual 193	java/io/File:isDirectory	()Z
    //   192: istore 4
    //   194: iload 4
    //   196: ifne +502 -> 698
    //   199: aload_0
    //   200: aload 6
    //   202: invokestatic 195	android/support/e/a:a	(Landroid/content/Context;Landroid/content/pm/ApplicationInfo;)Ljava/io/File;
    //   205: astore 8
    //   207: aload_0
    //   208: aload 6
    //   210: aload 8
    //   212: invokestatic 200	android/support/e/b:a	(Landroid/content/Context;Landroid/content/pm/ApplicationInfo;Ljava/io/File;)Ljava/util/List;
    //   215: astore 9
    //   217: aload 9
    //   219: invokeinterface 205 1 0
    //   224: ifne +273 -> 497
    //   227: getstatic 168	android/os/Build$VERSION:SDK_INT	I
    //   230: bipush 19
    //   232: if_icmplt +318 -> 550
    //   235: aload 7
    //   237: ldc -49
    //   239: invokestatic 209	android/support/e/a:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   242: aload 7
    //   244: invokevirtual 213	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   247: astore 6
    //   249: new 215	java/util/ArrayList
    //   252: dup
    //   253: invokespecial 216	java/util/ArrayList:<init>	()V
    //   256: astore 7
    //   258: new 215	java/util/ArrayList
    //   261: dup
    //   262: aload 9
    //   264: invokespecial 219	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   267: astore_0
    //   268: aload 6
    //   270: ldc -35
    //   272: iconst_3
    //   273: anewarray 70	java/lang/Class
    //   276: dup
    //   277: iconst_0
    //   278: ldc -41
    //   280: aastore
    //   281: dup
    //   282: iconst_1
    //   283: ldc 36
    //   285: aastore
    //   286: dup
    //   287: iconst_2
    //   288: ldc -41
    //   290: aastore
    //   291: invokestatic 223	android/support/e/a:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   294: aload 6
    //   296: iconst_3
    //   297: anewarray 4	java/lang/Object
    //   300: dup
    //   301: iconst_0
    //   302: aload_0
    //   303: aastore
    //   304: dup
    //   305: iconst_1
    //   306: aload 8
    //   308: aastore
    //   309: dup
    //   310: iconst_2
    //   311: aload 7
    //   313: aastore
    //   314: invokevirtual 227	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   317: checkcast 229	[Ljava/lang/Object;
    //   320: astore_0
    //   321: aload 6
    //   323: ldc -25
    //   325: invokestatic 209	android/support/e/a:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   328: astore 8
    //   330: aload 8
    //   332: aload 6
    //   334: invokevirtual 213	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   337: checkcast 229	[Ljava/lang/Object;
    //   340: astore 9
    //   342: aload 9
    //   344: invokevirtual 68	java/lang/Object:getClass	()Ljava/lang/Class;
    //   347: invokevirtual 234	java/lang/Class:getComponentType	()Ljava/lang/Class;
    //   350: astore 10
    //   352: aload 9
    //   354: arraylength
    //   355: istore_1
    //   356: aload_0
    //   357: arraylength
    //   358: istore_3
    //   359: aload 10
    //   361: iload_1
    //   362: iload_3
    //   363: iadd
    //   364: invokestatic 240	java/lang/reflect/Array:newInstance	(Ljava/lang/Class;I)Ljava/lang/Object;
    //   367: checkcast 229	[Ljava/lang/Object;
    //   370: astore 10
    //   372: aload 9
    //   374: iconst_0
    //   375: aload 10
    //   377: iconst_0
    //   378: iload_1
    //   379: invokestatic 244	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   382: aload_0
    //   383: iconst_0
    //   384: aload 10
    //   386: iload_1
    //   387: iload_3
    //   388: invokestatic 244	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   391: aload 8
    //   393: aload 6
    //   395: aload 10
    //   397: invokevirtual 248	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   400: aload 7
    //   402: invokevirtual 252	java/util/ArrayList:size	()I
    //   405: ifle +92 -> 497
    //   408: aload 7
    //   410: invokevirtual 252	java/util/ArrayList:size	()I
    //   413: istore_3
    //   414: iload_2
    //   415: istore_1
    //   416: iload_1
    //   417: iload_3
    //   418: if_icmpge +27 -> 445
    //   421: ldc -119
    //   423: ldc -2
    //   425: aload 7
    //   427: iload_1
    //   428: invokevirtual 257	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   431: checkcast 34	java/io/IOException
    //   434: invokestatic 260	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   437: pop
    //   438: iload_1
    //   439: iconst_1
    //   440: iadd
    //   441: istore_1
    //   442: goto -26 -> 416
    //   445: aload 6
    //   447: ldc_w 262
    //   450: invokestatic 209	android/support/e/a:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   453: astore 8
    //   455: aload 8
    //   457: aload 6
    //   459: invokevirtual 213	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   462: checkcast 264	[Ljava/io/IOException;
    //   465: astore 9
    //   467: aload 9
    //   469: ifnonnull +41 -> 510
    //   472: aload 7
    //   474: aload 7
    //   476: invokevirtual 252	java/util/ArrayList:size	()I
    //   479: anewarray 34	java/io/IOException
    //   482: invokevirtual 268	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   485: checkcast 264	[Ljava/io/IOException;
    //   488: astore_0
    //   489: aload 8
    //   491: aload 6
    //   493: aload_0
    //   494: invokevirtual 248	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   497: aload 5
    //   499: monitorexit
    //   500: ldc -119
    //   502: ldc_w 270
    //   505: invokestatic 145	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   508: pop
    //   509: return
    //   510: aload 7
    //   512: invokevirtual 252	java/util/ArrayList:size	()I
    //   515: istore_1
    //   516: aload 9
    //   518: arraylength
    //   519: istore_2
    //   520: iload_1
    //   521: iload_2
    //   522: iadd
    //   523: anewarray 34	java/io/IOException
    //   526: astore_0
    //   527: aload 7
    //   529: aload_0
    //   530: invokevirtual 268	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   533: pop
    //   534: aload 9
    //   536: iconst_0
    //   537: aload_0
    //   538: aload 7
    //   540: invokevirtual 252	java/util/ArrayList:size	()I
    //   543: iload_2
    //   544: invokestatic 244	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   547: goto -58 -> 489
    //   550: aload 7
    //   552: ldc -49
    //   554: invokestatic 209	android/support/e/a:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   557: aload 7
    //   559: invokevirtual 213	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   562: astore_0
    //   563: new 215	java/util/ArrayList
    //   566: dup
    //   567: aload 9
    //   569: invokespecial 219	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   572: astore 6
    //   574: aload_0
    //   575: ldc -35
    //   577: iconst_2
    //   578: anewarray 70	java/lang/Class
    //   581: dup
    //   582: iconst_0
    //   583: ldc -41
    //   585: aastore
    //   586: dup
    //   587: iconst_1
    //   588: ldc 36
    //   590: aastore
    //   591: invokestatic 223	android/support/e/a:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   594: aload_0
    //   595: iconst_2
    //   596: anewarray 4	java/lang/Object
    //   599: dup
    //   600: iconst_0
    //   601: aload 6
    //   603: aastore
    //   604: dup
    //   605: iconst_1
    //   606: aload 8
    //   608: aastore
    //   609: invokevirtual 227	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   612: checkcast 229	[Ljava/lang/Object;
    //   615: astore 6
    //   617: aload_0
    //   618: ldc -25
    //   620: invokestatic 209	android/support/e/a:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   623: astore 7
    //   625: aload 7
    //   627: aload_0
    //   628: invokevirtual 213	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   631: checkcast 229	[Ljava/lang/Object;
    //   634: astore 8
    //   636: aload 8
    //   638: invokevirtual 68	java/lang/Object:getClass	()Ljava/lang/Class;
    //   641: invokevirtual 234	java/lang/Class:getComponentType	()Ljava/lang/Class;
    //   644: astore 9
    //   646: aload 8
    //   648: arraylength
    //   649: istore_1
    //   650: aload 6
    //   652: arraylength
    //   653: istore_2
    //   654: aload 9
    //   656: iload_1
    //   657: iload_2
    //   658: iadd
    //   659: invokestatic 240	java/lang/reflect/Array:newInstance	(Ljava/lang/Class;I)Ljava/lang/Object;
    //   662: checkcast 229	[Ljava/lang/Object;
    //   665: astore 9
    //   667: aload 8
    //   669: iconst_0
    //   670: aload 9
    //   672: iconst_0
    //   673: iload_1
    //   674: invokestatic 244	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   677: aload 6
    //   679: iconst_0
    //   680: aload 9
    //   682: iload_1
    //   683: iload_2
    //   684: invokestatic 244	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   687: aload 7
    //   689: aload_0
    //   690: aload 9
    //   692: invokevirtual 248	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   695: goto -198 -> 497
    //   698: new 86	java/lang/StringBuilder
    //   701: dup
    //   702: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   705: astore 9
    //   707: aload 9
    //   709: ldc_w 272
    //   712: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: pop
    //   716: aload 9
    //   718: aload 8
    //   720: invokevirtual 275	java/io/File:getPath	()Ljava/lang/String;
    //   723: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: pop
    //   727: aload 9
    //   729: ldc -67
    //   731: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: pop
    //   735: ldc -119
    //   737: aload 9
    //   739: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   742: invokestatic 145	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   745: pop
    //   746: aload 8
    //   748: invokevirtual 279	java/io/File:listFiles	()[Ljava/io/File;
    //   751: astore 9
    //   753: aload 9
    //   755: ifnonnull +70 -> 825
    //   758: new 86	java/lang/StringBuilder
    //   761: dup
    //   762: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   765: astore 9
    //   767: aload 9
    //   769: ldc_w 281
    //   772: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: pop
    //   776: aload 9
    //   778: aload 8
    //   780: invokevirtual 275	java/io/File:getPath	()Ljava/lang/String;
    //   783: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: pop
    //   787: aload 9
    //   789: ldc -67
    //   791: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: pop
    //   795: ldc -119
    //   797: aload 9
    //   799: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   802: invokestatic 283	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   805: pop
    //   806: goto -607 -> 199
    //   809: astore 8
    //   811: ldc -119
    //   813: ldc_w 285
    //   816: aload 8
    //   818: invokestatic 260	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   821: pop
    //   822: goto -623 -> 199
    //   825: aload 9
    //   827: arraylength
    //   828: istore_3
    //   829: iconst_0
    //   830: istore_1
    //   831: iload_1
    //   832: iload_3
    //   833: if_icmpge +163 -> 996
    //   836: aload 9
    //   838: iload_1
    //   839: aaload
    //   840: astore 10
    //   842: new 86	java/lang/StringBuilder
    //   845: dup
    //   846: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   849: astore 11
    //   851: aload 11
    //   853: ldc_w 287
    //   856: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: pop
    //   860: aload 11
    //   862: aload 10
    //   864: invokevirtual 275	java/io/File:getPath	()Ljava/lang/String;
    //   867: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: pop
    //   871: aload 11
    //   873: ldc_w 289
    //   876: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: pop
    //   880: aload 11
    //   882: aload 10
    //   884: invokevirtual 293	java/io/File:length	()J
    //   887: invokevirtual 296	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   890: pop
    //   891: ldc -119
    //   893: aload 11
    //   895: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   898: invokestatic 145	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   901: pop
    //   902: aload 10
    //   904: invokevirtual 299	java/io/File:delete	()Z
    //   907: ifne +46 -> 953
    //   910: new 86	java/lang/StringBuilder
    //   913: dup
    //   914: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   917: astore 11
    //   919: aload 11
    //   921: ldc_w 301
    //   924: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: pop
    //   928: aload 11
    //   930: aload 10
    //   932: invokevirtual 275	java/io/File:getPath	()Ljava/lang/String;
    //   935: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: pop
    //   939: ldc -119
    //   941: aload 11
    //   943: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   946: invokestatic 283	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   949: pop
    //   950: goto +264 -> 1214
    //   953: new 86	java/lang/StringBuilder
    //   956: dup
    //   957: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   960: astore 11
    //   962: aload 11
    //   964: ldc_w 303
    //   967: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   970: pop
    //   971: aload 11
    //   973: aload 10
    //   975: invokevirtual 275	java/io/File:getPath	()Ljava/lang/String;
    //   978: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   981: pop
    //   982: ldc -119
    //   984: aload 11
    //   986: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   989: invokestatic 145	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   992: pop
    //   993: goto +221 -> 1214
    //   996: aload 8
    //   998: invokevirtual 299	java/io/File:delete	()Z
    //   1001: ifne +46 -> 1047
    //   1004: new 86	java/lang/StringBuilder
    //   1007: dup
    //   1008: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   1011: astore 9
    //   1013: aload 9
    //   1015: ldc_w 305
    //   1018: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1021: pop
    //   1022: aload 9
    //   1024: aload 8
    //   1026: invokevirtual 275	java/io/File:getPath	()Ljava/lang/String;
    //   1029: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: pop
    //   1033: ldc -119
    //   1035: aload 9
    //   1037: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1040: invokestatic 283	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   1043: pop
    //   1044: goto -845 -> 199
    //   1047: new 86	java/lang/StringBuilder
    //   1050: dup
    //   1051: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   1054: astore 9
    //   1056: aload 9
    //   1058: ldc_w 307
    //   1061: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: pop
    //   1065: aload 9
    //   1067: aload 8
    //   1069: invokevirtual 275	java/io/File:getPath	()Ljava/lang/String;
    //   1072: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1075: pop
    //   1076: ldc -119
    //   1078: aload 9
    //   1080: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1083: invokestatic 145	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   1086: pop
    //   1087: goto -888 -> 199
    //   1090: new 86	java/lang/StringBuilder
    //   1093: dup
    //   1094: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   1097: astore 7
    //   1099: aload 7
    //   1101: ldc_w 309
    //   1104: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1107: pop
    //   1108: aload 7
    //   1110: getstatic 168	android/os/Build$VERSION:SDK_INT	I
    //   1113: invokevirtual 312	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1116: pop
    //   1117: aload 7
    //   1119: ldc_w 314
    //   1122: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1125: pop
    //   1126: aload 7
    //   1128: bipush 20
    //   1130: invokevirtual 312	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1133: pop
    //   1134: aload 7
    //   1136: ldc_w 316
    //   1139: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1142: pop
    //   1143: aload 7
    //   1145: ldc_w 318
    //   1148: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1151: pop
    //   1152: aload 7
    //   1154: ldc_w 320
    //   1157: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1160: pop
    //   1161: aload 7
    //   1163: ldc 19
    //   1165: invokestatic 25	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   1168: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1171: pop
    //   1172: aload 7
    //   1174: ldc_w 322
    //   1177: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1180: pop
    //   1181: ldc -119
    //   1183: aload 7
    //   1185: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1188: invokestatic 283	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   1191: pop
    //   1192: goto -1107 -> 85
    //   1195: aload 5
    //   1197: monitorexit
    //   1198: return
    //   1199: astore_0
    //   1200: ldc -119
    //   1202: ldc_w 324
    //   1205: aload_0
    //   1206: invokestatic 260	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   1209: pop
    //   1210: aload 5
    //   1212: monitorexit
    //   1213: return
    //   1214: iload_1
    //   1215: iconst_1
    //   1216: iadd
    //   1217: istore_1
    //   1218: goto -387 -> 831
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1221	0	paramContext	Context
    //   78	1140	1	i	int
    //   1	683	2	j	int
    //   358	476	3	k	int
    //   192	3	4	bool	boolean
    //   29	649	6	localObject2	Object
    //   49	1135	7	localObject3	Object
    //   185	594	8	localObject4	Object
    //   809	259	8	localThrowable	Throwable
    //   215	864	9	localObject5	Object
    //   350	624	10	localObject6	Object
    //   849	136	11	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   44	79	108	finally
    //   85	91	108	finally
    //   96	107	108	finally
    //   109	112	108	finally
    //   199	414	108	finally
    //   421	438	108	finally
    //   445	467	108	finally
    //   472	489	108	finally
    //   489	497	108	finally
    //   497	500	108	finally
    //   510	547	108	finally
    //   550	695	108	finally
    //   811	822	108	finally
    //   1090	1192	108	finally
    //   1195	1198	108	finally
    //   1200	1213	108	finally
    //   25	31	114	java/lang/Exception
    //   36	44	114	java/lang/Exception
    //   112	114	114	java/lang/Exception
    //   172	194	809	finally
    //   698	753	809	finally
    //   758	806	809	finally
    //   825	829	809	finally
    //   842	950	809	finally
    //   953	993	809	finally
    //   996	1044	809	finally
    //   1047	1087	809	finally
    //   85	91	1199	java/lang/RuntimeException
  }
  
  private static void a(File paramFile)
  {
    paramFile.mkdir();
    if (!paramFile.isDirectory())
    {
      Object localObject = paramFile.getParentFile();
      if (localObject == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Failed to create dir ");
        ((StringBuilder)localObject).append(paramFile.getPath());
        ((StringBuilder)localObject).append(". Parent file is null.");
        Log.e("MultiDex", ((StringBuilder)localObject).toString());
      }
      for (;;)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Failed to create directory ");
        ((StringBuilder)localObject).append(paramFile.getPath());
        throw new IOException(((StringBuilder)localObject).toString());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to create dir ");
        localStringBuilder.append(paramFile.getPath());
        localStringBuilder.append(". parent file is a dir ");
        localStringBuilder.append(((File)localObject).isDirectory());
        localStringBuilder.append(", a file ");
        localStringBuilder.append(((File)localObject).isFile());
        localStringBuilder.append(", exists ");
        localStringBuilder.append(((File)localObject).exists());
        localStringBuilder.append(", readable ");
        localStringBuilder.append(((File)localObject).canRead());
        localStringBuilder.append(", writable ");
        localStringBuilder.append(((File)localObject).canWrite());
        Log.e("MultiDex", localStringBuilder.toString());
      }
    }
  }
  
  private static boolean a(String paramString)
  {
    bool2 = false;
    bool1 = bool2;
    Object localObject;
    if (paramString != null)
    {
      localObject = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(paramString);
      bool1 = bool2;
      if (!((Matcher)localObject).matches()) {}
    }
    for (;;)
    {
      try
      {
        i = Integer.parseInt(((Matcher)localObject).group(1));
        j = Integer.parseInt(((Matcher)localObject).group(2));
        if (i <= 2) {
          continue;
        }
        bool1 = true;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        int i;
        int j;
        bool1 = bool2;
        continue;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("VM with version ");
      ((StringBuilder)localObject).append(paramString);
      if (!bool1)
      {
        paramString = " does not have multidex support";
        ((StringBuilder)localObject).append(paramString);
        Log.i("MultiDex", ((StringBuilder)localObject).toString());
        return bool1;
      }
      paramString = " has multidex support";
      continue;
      bool1 = bool2;
      if (i == 2)
      {
        bool1 = bool2;
        if (j > 0) {
          bool1 = true;
        }
      }
    }
  }
  
  private static ApplicationInfo b(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getApplicationInfo();
      return paramContext;
    }
    catch (RuntimeException paramContext)
    {
      Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", paramContext);
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */