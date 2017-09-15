package com.tencent.mm.storage;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import java.io.File;

public final class RegionCodeDecoder
{
  private static RegionCodeDecoder uIQ;
  public static final String uIR;
  public String uIS;
  private String uIT;
  
  static
  {
    GMTrace.i(13302319022080L, 99110);
    uIQ = null;
    uIR = e.hgf + "MicroMsg/regioncode/";
    GMTrace.o(13302319022080L, 99110);
  }
  
  public RegionCodeDecoder()
  {
    GMTrace.i(13300305756160L, 99095);
    this.uIS = "";
    this.uIT = "";
    GMTrace.o(13300305756160L, 99095);
  }
  
  /* Error */
  private void A(File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc2_w 70
    //   7: ldc 72
    //   9: invokestatic 27	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   12: aconst_null
    //   13: astore 4
    //   15: aload_1
    //   16: invokevirtual 78	java/io/File:exists	()Z
    //   19: ifeq +9 -> 28
    //   22: aload_1
    //   23: invokevirtual 82	java/io/File:list	()[Ljava/lang/String;
    //   26: astore 4
    //   28: aload_1
    //   29: invokevirtual 78	java/io/File:exists	()Z
    //   32: ifeq +25 -> 57
    //   35: aload 4
    //   37: ifnull +20 -> 57
    //   40: aload 4
    //   42: arraylength
    //   43: ifeq +14 -> 57
    //   46: ldc2_w 70
    //   49: ldc 72
    //   51: invokestatic 54	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   54: aload_0
    //   55: monitorexit
    //   56: return
    //   57: invokestatic 88	com/tencent/mm/sdk/platformtools/aa:getContext	()Landroid/content/Context;
    //   60: invokevirtual 94	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   63: ldc 96
    //   65: invokevirtual 101	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   68: astore 4
    //   70: aload 4
    //   72: arraylength
    //   73: istore_3
    //   74: iload_2
    //   75: iload_3
    //   76: if_icmpge +145 -> 221
    //   79: aload 4
    //   81: iload_2
    //   82: aaload
    //   83: astore 5
    //   85: ldc 103
    //   87: ldc 105
    //   89: iconst_2
    //   90: anewarray 4	java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: new 31	java/lang/StringBuilder
    //   98: dup
    //   99: ldc 107
    //   101: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   104: aload 5
    //   106: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: aastore
    //   113: dup
    //   114: iconst_1
    //   115: new 31	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   122: aload_1
    //   123: invokevirtual 113	java/io/File:getPath	()Ljava/lang/String;
    //   126: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: ldc 115
    //   131: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload 5
    //   136: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: aastore
    //   143: invokestatic 120	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: new 31	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   153: aload_1
    //   154: invokevirtual 113	java/io/File:getPath	()Ljava/lang/String;
    //   157: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc 115
    //   162: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload 5
    //   167: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: astore 6
    //   175: invokestatic 88	com/tencent/mm/sdk/platformtools/aa:getContext	()Landroid/content/Context;
    //   178: new 31	java/lang/StringBuilder
    //   181: dup
    //   182: ldc 107
    //   184: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   187: aload 5
    //   189: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: aload 6
    //   197: invokestatic 126	com/tencent/mm/sdk/platformtools/j:y	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   200: pop
    //   201: new 74	java/io/File
    //   204: dup
    //   205: aload 6
    //   207: invokespecial 127	java/io/File:<init>	(Ljava/lang/String;)V
    //   210: aload_1
    //   211: invokestatic 131	com/tencent/mm/storage/RegionCodeDecoder:d	(Ljava/io/File;Ljava/io/File;)V
    //   214: iload_2
    //   215: iconst_1
    //   216: iadd
    //   217: istore_2
    //   218: goto -144 -> 74
    //   221: ldc2_w 70
    //   224: ldc 72
    //   226: invokestatic 54	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   229: goto -175 -> 54
    //   232: astore_1
    //   233: aload_0
    //   234: monitorexit
    //   235: aload_1
    //   236: athrow
    //   237: astore_1
    //   238: ldc 103
    //   240: aload_1
    //   241: ldc 61
    //   243: iconst_0
    //   244: anewarray 4	java/lang/Object
    //   247: invokestatic 135	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   250: ldc2_w 70
    //   253: ldc 72
    //   255: invokestatic 54	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   258: goto -204 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	RegionCodeDecoder
    //   0	261	1	paramFile	File
    //   1	217	2	i	int
    //   73	4	3	j	int
    //   13	67	4	arrayOfString	String[]
    //   83	105	5	str1	String
    //   173	33	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   4	12	232	finally
    //   15	28	232	finally
    //   28	35	232	finally
    //   40	54	232	finally
    //   57	74	232	finally
    //   85	214	232	finally
    //   221	229	232	finally
    //   238	258	232	finally
    //   57	74	237	java/lang/Exception
    //   85	214	237	java/lang/Exception
  }
  
  public static String RP(String paramString)
  {
    GMTrace.i(13301111062528L, 99101);
    if ((bf.mA(paramString)) || (!u.Pm(paramString)))
    {
      v.e("MicroMsg.RegionCodeDecoder", "unsupported language:" + paramString);
      GMTrace.o(13301111062528L, 99101);
      return null;
    }
    String str = paramString;
    if (paramString.equalsIgnoreCase("zh_HK")) {
      str = "zh_TW";
    }
    paramString = uIR + "mmregioncode_" + str + ".txt";
    GMTrace.o(13301111062528L, 99101);
    return paramString;
  }
  
  public static final boolean RQ(String paramString)
  {
    GMTrace.i(13301245280256L, 99102);
    if (bf.mA(paramString))
    {
      GMTrace.o(13301245280256L, 99102);
      return false;
    }
    boolean bool = paramString.equalsIgnoreCase("cn");
    GMTrace.o(13301245280256L, 99102);
    return bool;
  }
  
  public static final String ab(String paramString1, String paramString2, String paramString3)
  {
    GMTrace.i(13300976844800L, 99100);
    StringBuffer localStringBuffer = new StringBuffer();
    if (!bf.mA(paramString1))
    {
      localStringBuffer.append(paramString1);
      if (!bf.mA(paramString2))
      {
        localStringBuffer.append('_');
        localStringBuffer.append(paramString2);
        if (!bf.mA(paramString3))
        {
          localStringBuffer.append('_');
          localStringBuffer.append(paramString3);
        }
      }
    }
    paramString1 = localStringBuffer.toString();
    GMTrace.o(13300976844800L, 99100);
    return paramString1;
  }
  
  public static RegionCodeDecoder bMF()
  {
    GMTrace.i(13300439973888L, 99096);
    if (uIQ == null) {
      uIQ = new RegionCodeDecoder();
    }
    RegionCodeDecoder localRegionCodeDecoder = uIQ;
    if (!u.bID().equals(localRegionCodeDecoder.uIS)) {
      localRegionCodeDecoder.bKH();
    }
    localRegionCodeDecoder = uIQ;
    GMTrace.o(13300439973888L, 99096);
    return localRegionCodeDecoder;
  }
  
  /* Error */
  public static void d(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: ldc2_w 210
    //   3: ldc -44
    //   5: invokestatic 27	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   8: ldc 103
    //   10: ldc -42
    //   12: iconst_1
    //   13: anewarray 4	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: aload_0
    //   19: invokevirtual 217	java/io/File:getName	()Ljava/lang/String;
    //   22: aastore
    //   23: invokestatic 120	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   26: new 74	java/io/File
    //   29: dup
    //   30: aload_1
    //   31: new 31	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   38: aload_0
    //   39: invokevirtual 217	java/io/File:getName	()Ljava/lang/String;
    //   42: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc -37
    //   47: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokespecial 222	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   56: astore_1
    //   57: aload_0
    //   58: invokestatic 226	com/tencent/mm/storage/RegionCodeDecoder:z	(Ljava/io/File;)Ljava/lang/String;
    //   61: astore_3
    //   62: aload_3
    //   63: invokestatic 146	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   66: ifne +121 -> 187
    //   69: aload_1
    //   70: invokevirtual 78	java/io/File:exists	()Z
    //   73: ifne +11 -> 84
    //   76: aload_1
    //   77: invokevirtual 230	java/io/File:getParentFile	()Ljava/io/File;
    //   80: invokevirtual 233	java/io/File:mkdirs	()Z
    //   83: pop
    //   84: new 235	java/io/PrintWriter
    //   87: dup
    //   88: aload_1
    //   89: invokespecial 237	java/io/PrintWriter:<init>	(Ljava/io/File;)V
    //   92: astore_2
    //   93: aload_2
    //   94: astore_1
    //   95: aload_2
    //   96: aload_3
    //   97: invokevirtual 240	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   100: aload_2
    //   101: invokevirtual 243	java/io/PrintWriter:close	()V
    //   104: ldc2_w 210
    //   107: ldc -44
    //   109: invokestatic 54	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   112: return
    //   113: astore_0
    //   114: ldc2_w 210
    //   117: ldc -44
    //   119: invokestatic 54	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   122: return
    //   123: astore_3
    //   124: aconst_null
    //   125: astore_2
    //   126: aload_2
    //   127: astore_1
    //   128: ldc 103
    //   130: aload_3
    //   131: ldc -11
    //   133: iconst_1
    //   134: anewarray 4	java/lang/Object
    //   137: dup
    //   138: iconst_0
    //   139: aload_0
    //   140: invokevirtual 217	java/io/File:getName	()Ljava/lang/String;
    //   143: aastore
    //   144: invokestatic 135	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   147: aload_2
    //   148: ifnull +39 -> 187
    //   151: aload_2
    //   152: invokevirtual 243	java/io/PrintWriter:close	()V
    //   155: ldc2_w 210
    //   158: ldc -44
    //   160: invokestatic 54	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   163: return
    //   164: astore_0
    //   165: ldc2_w 210
    //   168: ldc -44
    //   170: invokestatic 54	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   173: return
    //   174: astore_0
    //   175: aconst_null
    //   176: astore_1
    //   177: aload_1
    //   178: ifnull +7 -> 185
    //   181: aload_1
    //   182: invokevirtual 243	java/io/PrintWriter:close	()V
    //   185: aload_0
    //   186: athrow
    //   187: ldc2_w 210
    //   190: ldc -44
    //   192: invokestatic 54	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   195: return
    //   196: astore_1
    //   197: goto -12 -> 185
    //   200: astore_0
    //   201: goto -24 -> 177
    //   204: astore_3
    //   205: goto -79 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	paramFile1	File
    //   0	208	1	paramFile2	File
    //   92	60	2	localPrintWriter	java.io.PrintWriter
    //   61	36	3	str	String
    //   123	8	3	localThrowable1	Throwable
    //   204	1	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   100	104	113	java/lang/Throwable
    //   84	93	123	java/lang/Throwable
    //   151	155	164	java/lang/Throwable
    //   84	93	174	finally
    //   181	185	196	java/lang/Throwable
    //   95	100	200	finally
    //   128	147	200	finally
    //   95	100	204	java/lang/Throwable
  }
  
  public static String getLocName(String paramString)
  {
    GMTrace.i(13301379497984L, 99103);
    if (bf.mA(paramString))
    {
      GMTrace.o(13301379497984L, 99103);
      return null;
    }
    paramString = DecoderJni.getLocName(paramString);
    GMTrace.o(13301379497984L, 99103);
    return paramString;
  }
  
  /* Error */
  private static String y(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc2_w 252
    //   5: ldc -2
    //   7: invokestatic 27	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   10: new 74	java/io/File
    //   13: dup
    //   14: new 31	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   21: aload_0
    //   22: invokevirtual 257	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   25: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc -37
    //   30: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokespecial 127	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore 4
    //   41: aload 4
    //   43: invokevirtual 78	java/io/File:exists	()Z
    //   46: ifeq +103 -> 149
    //   49: new 259	java/io/BufferedReader
    //   52: dup
    //   53: new 261	java/io/FileReader
    //   56: dup
    //   57: aload 4
    //   59: invokespecial 262	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   62: invokespecial 265	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   65: astore_1
    //   66: aload_1
    //   67: astore_0
    //   68: aload_1
    //   69: invokevirtual 268	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   72: astore_2
    //   73: aload_2
    //   74: astore_0
    //   75: aload_1
    //   76: invokevirtual 269	java/io/BufferedReader:close	()V
    //   79: ldc2_w 252
    //   82: ldc -2
    //   84: invokestatic 54	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   87: aload_0
    //   88: areturn
    //   89: astore_2
    //   90: aconst_null
    //   91: astore_1
    //   92: aload_1
    //   93: astore_0
    //   94: ldc 103
    //   96: aload_2
    //   97: ldc_w 271
    //   100: iconst_1
    //   101: anewarray 4	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: aload 4
    //   108: invokevirtual 217	java/io/File:getName	()Ljava/lang/String;
    //   111: aastore
    //   112: invokestatic 135	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   115: aload_3
    //   116: astore_0
    //   117: aload_1
    //   118: ifnull -39 -> 79
    //   121: aload_1
    //   122: invokevirtual 269	java/io/BufferedReader:close	()V
    //   125: aload_3
    //   126: astore_0
    //   127: goto -48 -> 79
    //   130: astore_0
    //   131: aload_3
    //   132: astore_0
    //   133: goto -54 -> 79
    //   136: astore_1
    //   137: aconst_null
    //   138: astore_0
    //   139: aload_0
    //   140: ifnull +7 -> 147
    //   143: aload_0
    //   144: invokevirtual 269	java/io/BufferedReader:close	()V
    //   147: aload_1
    //   148: athrow
    //   149: ldc2_w 252
    //   152: ldc -2
    //   154: invokestatic 54	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   157: aconst_null
    //   158: areturn
    //   159: astore_1
    //   160: goto -81 -> 79
    //   163: astore_0
    //   164: goto -17 -> 147
    //   167: astore_1
    //   168: goto -29 -> 139
    //   171: astore_2
    //   172: goto -80 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	paramFile	File
    //   65	57	1	localBufferedReader	java.io.BufferedReader
    //   136	12	1	localObject1	Object
    //   159	1	1	localThrowable1	Throwable
    //   167	1	1	localObject2	Object
    //   72	2	2	str	String
    //   89	8	2	localThrowable2	Throwable
    //   171	1	2	localThrowable3	Throwable
    //   1	131	3	localObject3	Object
    //   39	68	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   49	66	89	java/lang/Throwable
    //   121	125	130	java/lang/Throwable
    //   49	66	136	finally
    //   75	79	159	java/lang/Throwable
    //   143	147	163	java/lang/Throwable
    //   68	73	167	finally
    //   94	115	167	finally
    //   68	73	171	java/lang/Throwable
  }
  
  private static String z(File paramFile)
  {
    GMTrace.i(17534740856832L, 130644);
    String str = g.f(paramFile);
    if (bf.mA(str))
    {
      v.e("MicroMsg.RegionCodeDecoder", "Failed to calculate hash for file %s", new Object[] { paramFile.getName() });
      GMTrace.o(17534740856832L, 130644);
      return null;
    }
    paramFile = z.Pp(str + "#" + paramFile.lastModified() + "#" + p.rA());
    GMTrace.o(17534740856832L, 130644);
    return paramFile;
  }
  
  public final String RR(String paramString)
  {
    GMTrace.i(13301513715712L, 99104);
    String str = getLocName(paramString);
    if (bf.mA(str))
    {
      paramString = bf.mz(paramString);
      GMTrace.o(13301513715712L, 99104);
      return paramString;
    }
    GMTrace.o(13301513715712L, 99104);
    return str;
  }
  
  public final Region[] RS(String paramString)
  {
    GMTrace.i(13302050586624L, 99108);
    if ((bf.mA(this.uIT)) || (bf.mA(paramString)))
    {
      GMTrace.o(13302050586624L, 99108);
      return null;
    }
    paramString = DecoderJni.getProvinces(this.uIT, paramString);
    GMTrace.o(13302050586624L, 99108);
    return paramString;
  }
  
  public final String ac(String paramString1, String paramString2, String paramString3)
  {
    GMTrace.i(13301782151168L, 99106);
    if ((bf.mA(paramString1)) || (bf.mA(paramString2)) || (bf.mA(paramString3))) {}
    for (paramString1 = null; bf.mA(paramString1); paramString1 = getLocName(ab(paramString1, paramString2, paramString3)))
    {
      paramString1 = bf.mz(paramString3);
      GMTrace.o(13301782151168L, 99106);
      return paramString1;
    }
    GMTrace.o(13301782151168L, 99106);
    return paramString1;
  }
  
  public final void bKH()
  {
    GMTrace.i(13300574191616L, 99097);
    Object localObject1 = new File(uIR);
    if (!((File)localObject1).exists())
    {
      ((File)localObject1).mkdir();
      A((File)localObject1);
    }
    Object localObject2 = ((File)localObject1).list();
    if ((localObject2 == null) || (localObject2.length == 0)) {
      A((File)localObject1);
    }
    this.uIS = u.bID();
    localObject1 = bMG();
    if (bf.mA((String)localObject1))
    {
      v.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found, curLang: " + this.uIS);
      GMTrace.o(13300574191616L, 99097);
      return;
    }
    localObject2 = uIR + (String)localObject1;
    File localFile1 = new File((String)localObject2);
    localObject1 = y(localFile1);
    boolean bool;
    File localFile2;
    if (bf.mA((String)localObject1))
    {
      bool = false;
      if (bool) {
        break label340;
      }
      if (j.y(aa.getContext(), "regioncode/" + localFile1.getName(), (String)localObject2)) {
        break label287;
      }
      localFile2 = new File(localFile1.getParentFile(), "mmregioncode_en.txt");
      localObject1 = localFile2.getAbsolutePath();
      if (j.y(aa.getContext(), "regioncode/mmregioncode_en.txt", localFile2.getAbsolutePath())) {
        break label289;
      }
      localObject1 = null;
    }
    for (;;)
    {
      if (!bf.mA((String)localObject1)) {
        break label345;
      }
      v.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found after verify, curLang: " + this.uIS);
      GMTrace.o(13300574191616L, 99097);
      return;
      bool = ((String)localObject1).equals(z(localFile1));
      break;
      label287:
      localObject1 = localObject2;
      label289:
      localFile2 = new File((String)localObject1);
      d(localFile2, localFile2.getParentFile());
      v.w("MicroMsg.RegionCodeDecoder", "Verifying codeFile: %s failed, after fallback, %s will be used.", new Object[] { localFile1.getName(), localFile2.getName() });
      continue;
      label340:
      localObject1 = localObject2;
    }
    label345:
    if ((!bf.mA(this.uIT)) && (this.uIT.equals(localObject2)) && (((String)localObject2).equals(localObject1)))
    {
      GMTrace.o(13300574191616L, 99097);
      return;
    }
    v.w("MicroMsg.RegionCodeDecoder", "buildMap, after verify, codeFile %s is used. curLang: %s", new Object[] { new File((String)localObject1).getName(), this.uIS });
    this.uIT = ((String)localObject1);
    DecoderJni.buildFromFile(this.uIT);
    GMTrace.o(13300574191616L, 99097);
  }
  
  public final String bMG()
  {
    GMTrace.i(13300842627072L, 99099);
    Object localObject = new StringBuilder("mmregioncode_");
    if (this.uIS.equalsIgnoreCase("zh_HK")) {}
    for (String str1 = "zh_TW";; str1 = this.uIS)
    {
      str1 = str1 + ".txt";
      localObject = new File(uIR);
      if (((File)localObject).exists()) {
        break;
      }
      ((File)localObject).mkdir();
      GMTrace.o(13300842627072L, 99099);
      return null;
    }
    localObject = ((File)localObject).list();
    if ((localObject == null) || (localObject.length == 0))
    {
      GMTrace.o(13300842627072L, 99099);
      return null;
    }
    int m = localObject.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      String str2 = localObject[i];
      if (str2.equals(str1))
      {
        GMTrace.o(13300842627072L, 99099);
        return str2;
      }
      k = j;
      if (j == 0)
      {
        k = j;
        if (str2.equals("mmregioncode_en.txt")) {
          k = 1;
        }
      }
      i += 1;
    }
    if (j != 0)
    {
      GMTrace.o(13300842627072L, 99099);
      return "mmregioncode_en.txt";
    }
    GMTrace.o(13300842627072L, 99099);
    return null;
  }
  
  public final Region[] bMH()
  {
    GMTrace.i(13301916368896L, 99107);
    if (bf.mA(this.uIT))
    {
      GMTrace.o(13301916368896L, 99107);
      return null;
    }
    Region[] arrayOfRegion = DecoderJni.getCountries(this.uIT);
    GMTrace.o(13301916368896L, 99107);
    return arrayOfRegion;
  }
  
  public final String eL(String paramString1, String paramString2)
  {
    Object localObject2 = null;
    GMTrace.i(13301647933440L, 99105);
    Object localObject1 = localObject2;
    if (!bf.mA(paramString1)) {
      if (!bf.mA(paramString2)) {
        break label55;
      }
    }
    label55:
    for (localObject1 = localObject2; bf.mA((String)localObject1); localObject1 = getLocName(ab(paramString1, paramString2, null)))
    {
      paramString1 = bf.mz(paramString2);
      GMTrace.o(13301647933440L, 99105);
      return paramString1;
    }
    GMTrace.o(13301647933440L, 99105);
    return (String)localObject1;
  }
  
  public final Region[] eM(String paramString1, String paramString2)
  {
    GMTrace.i(13302184804352L, 99109);
    if ((bf.mA(this.uIT)) || (bf.mA(paramString1)) || (bf.mA(paramString2)))
    {
      GMTrace.o(13302184804352L, 99109);
      return null;
    }
    paramString1 = DecoderJni.getCities(this.uIT, paramString1, paramString2);
    GMTrace.o(13302184804352L, 99109);
    return paramString1;
  }
  
  private static class DecoderJni
  {
    private DecoderJni()
    {
      GMTrace.i(13305808683008L, 99136);
      GMTrace.o(13305808683008L, 99136);
    }
    
    public static native void buildFromFile(String paramString);
    
    public static native RegionCodeDecoder.Region[] getCities(String paramString1, String paramString2, String paramString3);
    
    public static native RegionCodeDecoder.Region[] getCountries(String paramString);
    
    public static native String getLocName(String paramString);
    
    public static native RegionCodeDecoder.Region[] getProvinces(String paramString1, String paramString2);
    
    public static native void release();
  }
  
  public static class Region
  {
    private String code;
    private String countryCode;
    private boolean hasChildren;
    private boolean isCity;
    private boolean isCountry;
    private boolean isProvince;
    private String name;
    private Region parent;
    
    public Region()
    {
      GMTrace.i(13311445827584L, 99178);
      this.hasChildren = false;
      this.parent = null;
      this.isCountry = false;
      this.isProvince = false;
      this.isCity = false;
      GMTrace.o(13311445827584L, 99178);
    }
    
    public String getCode()
    {
      GMTrace.i(13311848480768L, 99181);
      String str = this.code;
      GMTrace.o(13311848480768L, 99181);
      return str;
    }
    
    public String getCountryCode()
    {
      GMTrace.i(17535680380928L, 130651);
      String str = this.countryCode;
      GMTrace.o(17535680380928L, 130651);
      return str;
    }
    
    public String getName()
    {
      GMTrace.i(13311580045312L, 99179);
      String str = this.name;
      GMTrace.o(13311580045312L, 99179);
      return str;
    }
    
    public Region getParent()
    {
      GMTrace.i(17535411945472L, 130649);
      Region localRegion = this.parent;
      GMTrace.o(17535411945472L, 130649);
      return localRegion;
    }
    
    public boolean hasChildren()
    {
      GMTrace.i(13312116916224L, 99183);
      boolean bool = this.hasChildren;
      GMTrace.o(13312116916224L, 99183);
      return bool;
    }
    
    public boolean isCity()
    {
      GMTrace.i(17803310530560L, 132645);
      boolean bool = this.isCity;
      GMTrace.o(17803310530560L, 132645);
      return bool;
    }
    
    public boolean isCountry()
    {
      GMTrace.i(17802773659648L, 132641);
      boolean bool = this.isCountry;
      GMTrace.o(17802773659648L, 132641);
      return bool;
    }
    
    public boolean isProvince()
    {
      GMTrace.i(17803042095104L, 132643);
      boolean bool = this.isProvince;
      GMTrace.o(17803042095104L, 132643);
      return bool;
    }
    
    public void setCity(boolean paramBoolean)
    {
      GMTrace.i(17803444748288L, 132646);
      this.isCity = paramBoolean;
      GMTrace.o(17803444748288L, 132646);
    }
    
    public void setCode(String paramString)
    {
      GMTrace.i(13311982698496L, 99182);
      this.code = paramString;
      GMTrace.o(13311982698496L, 99182);
    }
    
    public void setCountry(boolean paramBoolean)
    {
      GMTrace.i(17802907877376L, 132642);
      this.isCountry = paramBoolean;
      GMTrace.o(17802907877376L, 132642);
    }
    
    public void setCountryCode(String paramString)
    {
      GMTrace.i(17535546163200L, 130650);
      this.countryCode = paramString;
      GMTrace.o(17535546163200L, 130650);
    }
    
    public void setHasChildren(boolean paramBoolean)
    {
      GMTrace.i(13312251133952L, 99184);
      this.hasChildren = paramBoolean;
      GMTrace.o(13312251133952L, 99184);
    }
    
    public void setName(String paramString)
    {
      GMTrace.i(13311714263040L, 99180);
      this.name = paramString;
      GMTrace.o(13311714263040L, 99180);
    }
    
    public void setParent(Region paramRegion)
    {
      GMTrace.i(17535277727744L, 130648);
      this.parent = paramRegion;
      GMTrace.o(17535277727744L, 130648);
    }
    
    public void setProvince(boolean paramBoolean)
    {
      GMTrace.i(17803176312832L, 132644);
      this.isProvince = paramBoolean;
      GMTrace.o(17803176312832L, 132644);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/RegionCodeDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */