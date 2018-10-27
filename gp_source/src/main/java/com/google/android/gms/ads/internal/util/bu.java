package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.util.Range;
import com.google.android.gms.ads.internal.q.a.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@a
public final class bu
{
  private static Map a = new HashMap();
  private static final Object b = new Object();
  private static List c;
  
  /* Error */
  @TargetApi(16)
  public static List a(String paramString)
  {
    // Byte code:
    //   0: getstatic 23	com/google/android/gms/ads/internal/util/bu:b	Ljava/lang/Object;
    //   3: astore 4
    //   5: aload 4
    //   7: monitorenter
    //   8: getstatic 20	com/google/android/gms/ads/internal/util/bu:a	Ljava/util/Map;
    //   11: aload_0
    //   12: invokeinterface 38 2 0
    //   17: ifeq +21 -> 38
    //   20: getstatic 20	com/google/android/gms/ads/internal/util/bu:a	Ljava/util/Map;
    //   23: aload_0
    //   24: invokeinterface 42 2 0
    //   29: checkcast 44	java/util/List
    //   32: astore_0
    //   33: aload 4
    //   35: monitorexit
    //   36: aload_0
    //   37: areturn
    //   38: getstatic 23	com/google/android/gms/ads/internal/util/bu:b	Ljava/lang/Object;
    //   41: astore_3
    //   42: aload_3
    //   43: monitorenter
    //   44: getstatic 46	com/google/android/gms/ads/internal/util/bu:c	Ljava/util/List;
    //   47: ifnonnull +502 -> 549
    //   50: getstatic 52	android/os/Build$VERSION:SDK_INT	I
    //   53: bipush 21
    //   55: if_icmpge +49 -> 104
    //   58: invokestatic 58	android/media/MediaCodecList:getCodecCount	()I
    //   61: istore_2
    //   62: new 60	java/util/ArrayList
    //   65: dup
    //   66: iload_2
    //   67: invokespecial 63	java/util/ArrayList:<init>	(I)V
    //   70: putstatic 46	com/google/android/gms/ads/internal/util/bu:c	Ljava/util/List;
    //   73: iconst_0
    //   74: istore_1
    //   75: iload_1
    //   76: iload_2
    //   77: if_icmpge +44 -> 121
    //   80: iload_1
    //   81: invokestatic 67	android/media/MediaCodecList:getCodecInfoAt	(I)Landroid/media/MediaCodecInfo;
    //   84: astore 5
    //   86: getstatic 46	com/google/android/gms/ads/internal/util/bu:c	Ljava/util/List;
    //   89: aload 5
    //   91: invokeinterface 70 2 0
    //   96: pop
    //   97: iload_1
    //   98: iconst_1
    //   99: iadd
    //   100: istore_1
    //   101: goto -26 -> 75
    //   104: new 54	android/media/MediaCodecList
    //   107: dup
    //   108: iconst_0
    //   109: invokespecial 71	android/media/MediaCodecList:<init>	(I)V
    //   112: invokevirtual 75	android/media/MediaCodecList:getCodecInfos	()[Landroid/media/MediaCodecInfo;
    //   115: invokestatic 81	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   118: putstatic 46	com/google/android/gms/ads/internal/util/bu:c	Ljava/util/List;
    //   121: aload_3
    //   122: monitorexit
    //   123: new 60	java/util/ArrayList
    //   126: dup
    //   127: invokespecial 82	java/util/ArrayList:<init>	()V
    //   130: astore_3
    //   131: getstatic 46	com/google/android/gms/ads/internal/util/bu:c	Ljava/util/List;
    //   134: invokeinterface 86 1 0
    //   139: astore 5
    //   141: aload 5
    //   143: invokeinterface 92 1 0
    //   148: ifne +19 -> 167
    //   151: getstatic 20	com/google/android/gms/ads/internal/util/bu:a	Ljava/util/Map;
    //   154: aload_0
    //   155: aload_3
    //   156: invokeinterface 96 3 0
    //   161: pop
    //   162: aload 4
    //   164: monitorexit
    //   165: aload_3
    //   166: areturn
    //   167: aload 5
    //   169: invokeinterface 100 1 0
    //   174: checkcast 102	android/media/MediaCodecInfo
    //   177: astore 7
    //   179: aload 7
    //   181: invokevirtual 105	android/media/MediaCodecInfo:isEncoder	()Z
    //   184: ifne -43 -> 141
    //   187: aload 7
    //   189: invokevirtual 109	android/media/MediaCodecInfo:getSupportedTypes	()[Ljava/lang/String;
    //   192: invokestatic 81	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   195: aload_0
    //   196: invokeinterface 112 2 0
    //   201: ifeq -60 -> 141
    //   204: new 15	java/util/HashMap
    //   207: dup
    //   208: invokespecial 18	java/util/HashMap:<init>	()V
    //   211: astore 6
    //   213: aload 6
    //   215: ldc 114
    //   217: aload 7
    //   219: invokevirtual 118	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   222: invokeinterface 96 3 0
    //   227: pop
    //   228: aload 7
    //   230: aload_0
    //   231: invokevirtual 122	android/media/MediaCodecInfo:getCapabilitiesForType	(Ljava/lang/String;)Landroid/media/MediaCodecInfo$CodecCapabilities;
    //   234: astore 7
    //   236: new 60	java/util/ArrayList
    //   239: dup
    //   240: invokespecial 82	java/util/ArrayList:<init>	()V
    //   243: astore 8
    //   245: aload 7
    //   247: getfield 128	android/media/MediaCodecInfo$CodecCapabilities:profileLevels	[Landroid/media/MediaCodecInfo$CodecProfileLevel;
    //   250: astore 9
    //   252: aload 9
    //   254: arraylength
    //   255: istore_2
    //   256: iconst_0
    //   257: istore_1
    //   258: iload_1
    //   259: iload_2
    //   260: if_icmplt +244 -> 504
    //   263: aload 6
    //   265: ldc -127
    //   267: aload 8
    //   269: invokeinterface 96 3 0
    //   274: pop
    //   275: getstatic 52	android/os/Build$VERSION:SDK_INT	I
    //   278: bipush 21
    //   280: if_icmpge +106 -> 386
    //   283: getstatic 52	android/os/Build$VERSION:SDK_INT	I
    //   286: bipush 23
    //   288: if_icmpge +77 -> 365
    //   291: aload_3
    //   292: aload 6
    //   294: invokevirtual 130	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   297: pop
    //   298: goto -157 -> 141
    //   301: astore_3
    //   302: new 15	java/util/HashMap
    //   305: dup
    //   306: invokespecial 18	java/util/HashMap:<init>	()V
    //   309: astore 5
    //   311: aload 5
    //   313: ldc -124
    //   315: aload_3
    //   316: invokevirtual 136	java/lang/Object:getClass	()Ljava/lang/Class;
    //   319: invokevirtual 141	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   322: invokeinterface 96 3 0
    //   327: pop
    //   328: new 60	java/util/ArrayList
    //   331: dup
    //   332: invokespecial 82	java/util/ArrayList:<init>	()V
    //   335: astore_3
    //   336: aload_3
    //   337: aload 5
    //   339: invokevirtual 130	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   342: pop
    //   343: getstatic 20	com/google/android/gms/ads/internal/util/bu:a	Ljava/util/Map;
    //   346: aload_0
    //   347: aload_3
    //   348: invokeinterface 96 3 0
    //   353: pop
    //   354: aload 4
    //   356: monitorexit
    //   357: aload_3
    //   358: areturn
    //   359: astore_0
    //   360: aload 4
    //   362: monitorexit
    //   363: aload_0
    //   364: athrow
    //   365: aload 6
    //   367: ldc -113
    //   369: aload 7
    //   371: invokevirtual 146	android/media/MediaCodecInfo$CodecCapabilities:getMaxSupportedInstances	()I
    //   374: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   377: invokeinterface 96 3 0
    //   382: pop
    //   383: goto -92 -> 291
    //   386: aload 7
    //   388: invokevirtual 156	android/media/MediaCodecInfo$CodecCapabilities:getVideoCapabilities	()Landroid/media/MediaCodecInfo$VideoCapabilities;
    //   391: astore 8
    //   393: aload 6
    //   395: ldc -98
    //   397: aload 8
    //   399: invokevirtual 164	android/media/MediaCodecInfo$VideoCapabilities:getBitrateRange	()Landroid/util/Range;
    //   402: invokestatic 167	com/google/android/gms/ads/internal/util/bu:a	(Landroid/util/Range;)[Ljava/lang/Integer;
    //   405: invokeinterface 96 3 0
    //   410: pop
    //   411: aload 6
    //   413: ldc -87
    //   415: aload 8
    //   417: invokevirtual 172	android/media/MediaCodecInfo$VideoCapabilities:getWidthAlignment	()I
    //   420: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   423: invokeinterface 96 3 0
    //   428: pop
    //   429: aload 6
    //   431: ldc -82
    //   433: aload 8
    //   435: invokevirtual 177	android/media/MediaCodecInfo$VideoCapabilities:getHeightAlignment	()I
    //   438: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   441: invokeinterface 96 3 0
    //   446: pop
    //   447: aload 6
    //   449: ldc -77
    //   451: aload 8
    //   453: invokevirtual 182	android/media/MediaCodecInfo$VideoCapabilities:getSupportedFrameRates	()Landroid/util/Range;
    //   456: invokestatic 167	com/google/android/gms/ads/internal/util/bu:a	(Landroid/util/Range;)[Ljava/lang/Integer;
    //   459: invokeinterface 96 3 0
    //   464: pop
    //   465: aload 6
    //   467: ldc -72
    //   469: aload 8
    //   471: invokevirtual 187	android/media/MediaCodecInfo$VideoCapabilities:getSupportedWidths	()Landroid/util/Range;
    //   474: invokestatic 167	com/google/android/gms/ads/internal/util/bu:a	(Landroid/util/Range;)[Ljava/lang/Integer;
    //   477: invokeinterface 96 3 0
    //   482: pop
    //   483: aload 6
    //   485: ldc -67
    //   487: aload 8
    //   489: invokevirtual 192	android/media/MediaCodecInfo$VideoCapabilities:getSupportedHeights	()Landroid/util/Range;
    //   492: invokestatic 167	com/google/android/gms/ads/internal/util/bu:a	(Landroid/util/Range;)[Ljava/lang/Integer;
    //   495: invokeinterface 96 3 0
    //   500: pop
    //   501: goto -218 -> 283
    //   504: aload 9
    //   506: iload_1
    //   507: aaload
    //   508: astore 10
    //   510: aload 8
    //   512: iconst_2
    //   513: anewarray 148	java/lang/Integer
    //   516: dup
    //   517: iconst_0
    //   518: aload 10
    //   520: getfield 197	android/media/MediaCodecInfo$CodecProfileLevel:profile	I
    //   523: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   526: aastore
    //   527: dup
    //   528: iconst_1
    //   529: aload 10
    //   531: getfield 200	android/media/MediaCodecInfo$CodecProfileLevel:level	I
    //   534: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   537: aastore
    //   538: invokevirtual 130	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   541: pop
    //   542: iload_1
    //   543: iconst_1
    //   544: iadd
    //   545: istore_1
    //   546: goto -288 -> 258
    //   549: aload_3
    //   550: monitorexit
    //   551: goto -428 -> 123
    //   554: astore 5
    //   556: aload_3
    //   557: monitorexit
    //   558: aload 5
    //   560: athrow
    //   561: astore_3
    //   562: goto -260 -> 302
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	565	0	paramString	String
    //   74	472	1	i	int
    //   61	200	2	j	int
    //   301	15	3	localRuntimeException	RuntimeException
    //   335	222	3	localArrayList	java.util.ArrayList
    //   561	1	3	localLinkageError	LinkageError
    //   3	358	4	localObject2	Object
    //   84	254	5	localObject3	Object
    //   554	5	5	localObject4	Object
    //   211	273	6	localHashMap	HashMap
    //   177	210	7	localObject5	Object
    //   243	268	8	localObject6	Object
    //   250	255	9	arrayOfCodecProfileLevel	android.media.MediaCodecInfo.CodecProfileLevel[]
    //   508	22	10	localCodecProfileLevel	android.media.MediaCodecInfo.CodecProfileLevel
    // Exception table:
    //   from	to	target	type
    //   38	44	301	java/lang/RuntimeException
    //   123	141	301	java/lang/RuntimeException
    //   141	162	301	java/lang/RuntimeException
    //   167	256	301	java/lang/RuntimeException
    //   263	283	301	java/lang/RuntimeException
    //   283	291	301	java/lang/RuntimeException
    //   291	298	301	java/lang/RuntimeException
    //   365	383	301	java/lang/RuntimeException
    //   386	501	301	java/lang/RuntimeException
    //   510	542	301	java/lang/RuntimeException
    //   558	561	301	java/lang/RuntimeException
    //   8	36	359	finally
    //   38	44	359	finally
    //   123	141	359	finally
    //   141	162	359	finally
    //   162	165	359	finally
    //   167	256	359	finally
    //   263	283	359	finally
    //   283	291	359	finally
    //   291	298	359	finally
    //   302	357	359	finally
    //   360	363	359	finally
    //   365	383	359	finally
    //   386	501	359	finally
    //   510	542	359	finally
    //   558	561	359	finally
    //   44	73	554	finally
    //   80	97	554	finally
    //   104	121	554	finally
    //   121	123	554	finally
    //   549	551	554	finally
    //   556	558	554	finally
    //   38	44	561	java/lang/LinkageError
    //   123	141	561	java/lang/LinkageError
    //   141	162	561	java/lang/LinkageError
    //   167	256	561	java/lang/LinkageError
    //   263	283	561	java/lang/LinkageError
    //   283	291	561	java/lang/LinkageError
    //   291	298	561	java/lang/LinkageError
    //   365	383	561	java/lang/LinkageError
    //   386	501	561	java/lang/LinkageError
    //   510	542	561	java/lang/LinkageError
    //   558	561	561	java/lang/LinkageError
  }
  
  @TargetApi(21)
  private static Integer[] a(Range paramRange)
  {
    return new Integer[] { (Integer)paramRange.getLower(), (Integer)paramRange.getUpper() };
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */