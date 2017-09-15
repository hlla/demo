package com.tencent.mm.ap;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.lm;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aoy;
import com.tencent.mm.protocal.c.og;
import com.tencent.mm.protocal.c.oh;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k.a;
import com.tencent.mm.y.k.b;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public final class j
  extends com.tencent.mm.y.k
  implements com.tencent.mm.network.j, com.tencent.mm.y.m
{
  public int fFq;
  private com.tencent.mm.y.b gUq;
  private com.tencent.mm.y.e gUt;
  public int hNR;
  private int offset;
  
  public j(int paramInt1, int paramInt2)
  {
    GMTrace.i(12945702518784L, 96453);
    this.hNR = paramInt1;
    this.fFq = paramInt2;
    this.offset = 0;
    Object localObject = t.Id().aQ(paramInt1, paramInt2);
    if (localObject == null)
    {
      v.e("MicroMsg.NetSceneDownloadPackage", "doScene get info null, id:" + paramInt1);
      GMTrace.o(12945702518784L, 96453);
      return;
    }
    ((m)localObject).status = 3;
    ((m)localObject).fRM = 64;
    t.Id().b((m)localObject);
    if (paramInt2 == 5)
    {
      localObject = h.vI().cachePath;
      com.tencent.mm.loader.stub.b.deleteFile((String)localObject + "brand_i18n.apk");
      GMTrace.o(12945702518784L, 96453);
      return;
    }
    localObject = t.Id();
    com.tencent.mm.loader.stub.b.deleteFile(n.HZ() + ((n)localObject).aS(paramInt1, paramInt2));
    GMTrace.o(12945702518784L, 96453);
  }
  
  private static boolean ad(String paramString1, String paramString2)
  {
    boolean bool = true;
    GMTrace.i(12946507825152L, 96459);
    if ((bf.mA(paramString1)) || (bf.mA(paramString2)))
    {
      GMTrace.o(12946507825152L, 96459);
      return false;
    }
    try
    {
      paramString1 = paramString1 + paramString2;
      paramString2 = com.tencent.mm.a.e.aT(paramString1);
      if (!bf.mA(paramString2)) {
        h.vI().vr().a(w.a.uCO, paramString2);
      }
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        try
        {
          com.tencent.mm.loader.stub.b.deleteFile(paramString1);
          v.i("MicroMsg.NetSceneDownloadPackage", "update sense where result[%b] filepath[%s] xml[%s] ", new Object[] { Boolean.valueOf(bool), paramString1, bf.Qi(paramString2) });
          GMTrace.o(12946507825152L, 96459);
          return bool;
        }
        catch (IOException paramString1)
        {
          continue;
        }
        paramString1 = paramString1;
        bool = false;
        v.printErrStackTrace("MicroMsg.NetSceneDownloadPackage", paramString1, "", new Object[0]);
        continue;
        bool = false;
      }
    }
  }
  
  /* Error */
  private boolean ae(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc2_w 180
    //   3: ldc -74
    //   5: invokestatic 32	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   8: aload_1
    //   9: invokestatic 132	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   12: ifne +10 -> 22
    //   15: aload_2
    //   16: invokestatic 132	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   19: ifeq +71 -> 90
    //   22: ldc 52
    //   24: new 54	java/lang/StringBuilder
    //   27: dup
    //   28: ldc -72
    //   30: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   33: aload_1
    //   34: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc -70
    //   39: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_2
    //   43: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 73	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: invokestatic 44	com/tencent/mm/ap/t:Id	()Lcom/tencent/mm/ap/n;
    //   55: aload_0
    //   56: getfield 34	com/tencent/mm/ap/j:hNR	I
    //   59: aload_0
    //   60: getfield 36	com/tencent/mm/ap/j:fFq	I
    //   63: invokevirtual 189	com/tencent/mm/ap/n:aU	(II)V
    //   66: aload_0
    //   67: getfield 191	com/tencent/mm/ap/j:gUt	Lcom/tencent/mm/y/e;
    //   70: iconst_3
    //   71: iconst_0
    //   72: ldc -63
    //   74: aload_0
    //   75: invokeinterface 198 5 0
    //   80: ldc2_w 180
    //   83: ldc -74
    //   85: invokestatic 76	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   88: iconst_0
    //   89: ireturn
    //   90: new 200	java/io/File
    //   93: dup
    //   94: new 54	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   101: aload_1
    //   102: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_2
    //   106: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokespecial 201	java/io/File:<init>	(Ljava/lang/String;)V
    //   115: astore 9
    //   117: aload 9
    //   119: invokevirtual 205	java/io/File:exists	()Z
    //   122: ifne +71 -> 193
    //   125: ldc 52
    //   127: new 54	java/lang/StringBuilder
    //   130: dup
    //   131: ldc -49
    //   133: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   136: aload_1
    //   137: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc -70
    //   142: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_2
    //   146: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 73	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: invokestatic 44	com/tencent/mm/ap/t:Id	()Lcom/tencent/mm/ap/n;
    //   158: aload_0
    //   159: getfield 34	com/tencent/mm/ap/j:hNR	I
    //   162: aload_0
    //   163: getfield 36	com/tencent/mm/ap/j:fFq	I
    //   166: invokevirtual 189	com/tencent/mm/ap/n:aU	(II)V
    //   169: aload_0
    //   170: getfield 191	com/tencent/mm/ap/j:gUt	Lcom/tencent/mm/y/e;
    //   173: iconst_3
    //   174: iconst_0
    //   175: ldc -47
    //   177: aload_0
    //   178: invokeinterface 198 5 0
    //   183: ldc2_w 180
    //   186: ldc -74
    //   188: invokestatic 76	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   191: iconst_0
    //   192: ireturn
    //   193: aconst_null
    //   194: astore_2
    //   195: new 211	java/util/HashMap
    //   198: dup
    //   199: invokespecial 212	java/util/HashMap:<init>	()V
    //   202: astore 8
    //   204: new 214	java/io/FileInputStream
    //   207: dup
    //   208: aload 9
    //   210: invokespecial 217	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   213: astore 5
    //   215: aload 5
    //   217: astore_1
    //   218: new 219	java/io/InputStreamReader
    //   221: dup
    //   222: aload 5
    //   224: ldc -35
    //   226: invokespecial 224	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   229: astore 10
    //   231: aload 5
    //   233: astore_1
    //   234: new 226	java/io/BufferedReader
    //   237: dup
    //   238: aload 10
    //   240: invokespecial 229	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   243: astore 11
    //   245: aconst_null
    //   246: astore_2
    //   247: aload 5
    //   249: astore_1
    //   250: aload 11
    //   252: invokevirtual 232	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   255: astore 6
    //   257: aload 6
    //   259: ifnull +525 -> 784
    //   262: aload 5
    //   264: astore_1
    //   265: aload 6
    //   267: invokevirtual 237	java/lang/String:trim	()Ljava/lang/String;
    //   270: ldc -17
    //   272: invokevirtual 243	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   275: astore 12
    //   277: aload 5
    //   279: astore_1
    //   280: aload 12
    //   282: arraylength
    //   283: iconst_2
    //   284: if_icmplt +29 -> 313
    //   287: aload 5
    //   289: astore_1
    //   290: aload 12
    //   292: iconst_0
    //   293: aaload
    //   294: invokestatic 132	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   297: ifne +16 -> 313
    //   300: aload 5
    //   302: astore_1
    //   303: aload 12
    //   305: iconst_1
    //   306: aaload
    //   307: invokestatic 132	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   310: ifeq +174 -> 484
    //   313: aload 5
    //   315: astore_1
    //   316: ldc 52
    //   318: new 54	java/lang/StringBuilder
    //   321: dup
    //   322: ldc -11
    //   324: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   327: aload 6
    //   329: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 73	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   338: goto -91 -> 247
    //   341: astore_1
    //   342: aload 5
    //   344: astore_2
    //   345: aload_1
    //   346: astore 5
    //   348: aload_2
    //   349: astore_1
    //   350: ldc 52
    //   352: ldc -9
    //   354: iconst_1
    //   355: anewarray 158	java/lang/Object
    //   358: dup
    //   359: iconst_0
    //   360: aload 5
    //   362: invokestatic 251	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   365: aastore
    //   366: invokestatic 253	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   369: aload_2
    //   370: astore_1
    //   371: invokestatic 44	com/tencent/mm/ap/t:Id	()Lcom/tencent/mm/ap/n;
    //   374: aload_0
    //   375: getfield 34	com/tencent/mm/ap/j:hNR	I
    //   378: aload_0
    //   379: getfield 36	com/tencent/mm/ap/j:fFq	I
    //   382: invokevirtual 189	com/tencent/mm/ap/n:aU	(II)V
    //   385: aload_2
    //   386: astore_1
    //   387: aload_0
    //   388: getfield 191	com/tencent/mm/ap/j:gUt	Lcom/tencent/mm/y/e;
    //   391: iconst_3
    //   392: iconst_0
    //   393: aload 5
    //   395: invokevirtual 256	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   398: aload_0
    //   399: invokeinterface 198 5 0
    //   404: aload_2
    //   405: ifnull +7 -> 412
    //   408: aload_2
    //   409: invokevirtual 261	java/io/InputStream:close	()V
    //   412: aload 8
    //   414: invokeinterface 267 1 0
    //   419: invokeinterface 273 1 0
    //   424: astore_1
    //   425: aload_1
    //   426: invokeinterface 278 1 0
    //   431: ifeq +43 -> 474
    //   434: aload_1
    //   435: invokeinterface 282 1 0
    //   440: checkcast 284	java/io/BufferedWriter
    //   443: astore_2
    //   444: aload_2
    //   445: ifnull -20 -> 425
    //   448: aload_2
    //   449: invokevirtual 285	java/io/BufferedWriter:close	()V
    //   452: goto -27 -> 425
    //   455: astore_1
    //   456: ldc 52
    //   458: ldc -9
    //   460: iconst_1
    //   461: anewarray 158	java/lang/Object
    //   464: dup
    //   465: iconst_0
    //   466: aload_1
    //   467: invokestatic 251	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   470: aastore
    //   471: invokestatic 253	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   474: ldc2_w 180
    //   477: ldc -74
    //   479: invokestatic 76	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   482: iconst_0
    //   483: ireturn
    //   484: aload 5
    //   486: astore_1
    //   487: aload 8
    //   489: aload 12
    //   491: iconst_0
    //   492: aaload
    //   493: invokeinterface 289 2 0
    //   498: checkcast 284	java/io/BufferedWriter
    //   501: astore 7
    //   503: aload 7
    //   505: astore 6
    //   507: aload 7
    //   509: ifnonnull +199 -> 708
    //   512: aload 5
    //   514: astore_1
    //   515: invokestatic 295	com/tencent/mm/storage/RegionCodeDecoder:bMF	()Lcom/tencent/mm/storage/RegionCodeDecoder;
    //   518: pop
    //   519: aload 5
    //   521: astore_1
    //   522: aload 12
    //   524: iconst_0
    //   525: aaload
    //   526: invokestatic 298	com/tencent/mm/storage/RegionCodeDecoder:RP	(Ljava/lang/String;)Ljava/lang/String;
    //   529: astore_2
    //   530: aload 5
    //   532: astore_1
    //   533: aload_2
    //   534: invokestatic 132	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   537: ifeq +100 -> 637
    //   540: aload 5
    //   542: astore_1
    //   543: ldc 52
    //   545: ldc_w 300
    //   548: invokestatic 73	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   551: goto -304 -> 247
    //   554: astore_2
    //   555: aload_1
    //   556: astore 5
    //   558: aload_2
    //   559: astore_1
    //   560: aload 5
    //   562: ifnull +8 -> 570
    //   565: aload 5
    //   567: invokevirtual 261	java/io/InputStream:close	()V
    //   570: aload 8
    //   572: invokeinterface 267 1 0
    //   577: invokeinterface 273 1 0
    //   582: astore_2
    //   583: aload_2
    //   584: invokeinterface 278 1 0
    //   589: ifeq +46 -> 635
    //   592: aload_2
    //   593: invokeinterface 282 1 0
    //   598: checkcast 284	java/io/BufferedWriter
    //   601: astore 5
    //   603: aload 5
    //   605: ifnull -22 -> 583
    //   608: aload 5
    //   610: invokevirtual 285	java/io/BufferedWriter:close	()V
    //   613: goto -30 -> 583
    //   616: astore_2
    //   617: ldc 52
    //   619: ldc -9
    //   621: iconst_1
    //   622: anewarray 158	java/lang/Object
    //   625: dup
    //   626: iconst_0
    //   627: aload_2
    //   628: invokestatic 251	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   631: aastore
    //   632: invokestatic 253	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   635: aload_1
    //   636: athrow
    //   637: aload 5
    //   639: astore_1
    //   640: new 200	java/io/File
    //   643: dup
    //   644: aload_2
    //   645: invokespecial 201	java/io/File:<init>	(Ljava/lang/String;)V
    //   648: astore 6
    //   650: aload 5
    //   652: astore_1
    //   653: aload 6
    //   655: invokevirtual 205	java/io/File:exists	()Z
    //   658: ifne +12 -> 670
    //   661: aload 5
    //   663: astore_1
    //   664: aload 6
    //   666: invokevirtual 303	java/io/File:createNewFile	()Z
    //   669: pop
    //   670: aload 5
    //   672: astore_1
    //   673: new 284	java/io/BufferedWriter
    //   676: dup
    //   677: new 305	java/io/FileWriter
    //   680: dup
    //   681: aload 6
    //   683: invokespecial 306	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   686: invokespecial 309	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   689: astore 6
    //   691: aload 5
    //   693: astore_1
    //   694: aload 8
    //   696: aload 12
    //   698: iconst_0
    //   699: aaload
    //   700: aload 6
    //   702: invokeinterface 313 3 0
    //   707: pop
    //   708: aload 5
    //   710: astore_1
    //   711: new 315	java/lang/StringBuffer
    //   714: dup
    //   715: invokespecial 316	java/lang/StringBuffer:<init>	()V
    //   718: astore 7
    //   720: aload 5
    //   722: astore_1
    //   723: aload 7
    //   725: aload 12
    //   727: iconst_1
    //   728: aaload
    //   729: invokevirtual 319	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   732: pop
    //   733: aload 5
    //   735: astore_1
    //   736: aload 7
    //   738: bipush 124
    //   740: invokevirtual 322	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   743: pop
    //   744: aload 5
    //   746: astore_1
    //   747: aload 7
    //   749: aload 12
    //   751: iconst_2
    //   752: aaload
    //   753: invokevirtual 319	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   756: pop
    //   757: aload 5
    //   759: astore_1
    //   760: aload 7
    //   762: bipush 10
    //   764: invokevirtual 322	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   767: pop
    //   768: aload 5
    //   770: astore_1
    //   771: aload 6
    //   773: aload 7
    //   775: invokevirtual 323	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   778: invokevirtual 326	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   781: goto -534 -> 247
    //   784: aload 5
    //   786: astore_1
    //   787: aload 8
    //   789: invokeinterface 267 1 0
    //   794: invokeinterface 273 1 0
    //   799: astore 6
    //   801: aload 5
    //   803: astore_1
    //   804: aload 6
    //   806: invokeinterface 278 1 0
    //   811: ifeq +34 -> 845
    //   814: aload 5
    //   816: astore_1
    //   817: aload 6
    //   819: invokeinterface 282 1 0
    //   824: checkcast 284	java/io/BufferedWriter
    //   827: astore 7
    //   829: aload 7
    //   831: ifnull -30 -> 801
    //   834: aload 5
    //   836: astore_1
    //   837: aload 7
    //   839: invokevirtual 329	java/io/BufferedWriter:flush	()V
    //   842: goto -41 -> 801
    //   845: aload 5
    //   847: astore_1
    //   848: aload_2
    //   849: invokestatic 132	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   852: ifne +85 -> 937
    //   855: aload 5
    //   857: astore_1
    //   858: new 200	java/io/File
    //   861: dup
    //   862: aload_2
    //   863: invokespecial 201	java/io/File:<init>	(Ljava/lang/String;)V
    //   866: invokevirtual 333	java/io/File:getParentFile	()Ljava/io/File;
    //   869: new 10	com/tencent/mm/ap/j$1
    //   872: dup
    //   873: aload_0
    //   874: invokespecial 336	com/tencent/mm/ap/j$1:<init>	(Lcom/tencent/mm/ap/j;)V
    //   877: invokevirtual 340	java/io/File:listFiles	(Ljava/io/FileFilter;)[Ljava/io/File;
    //   880: astore_2
    //   881: aload 5
    //   883: astore_1
    //   884: aload_2
    //   885: arraylength
    //   886: istore 4
    //   888: iconst_0
    //   889: istore_3
    //   890: iload_3
    //   891: iload 4
    //   893: if_icmpge +35 -> 928
    //   896: aload_2
    //   897: iload_3
    //   898: aaload
    //   899: astore 6
    //   901: aload 5
    //   903: astore_1
    //   904: invokestatic 295	com/tencent/mm/storage/RegionCodeDecoder:bMF	()Lcom/tencent/mm/storage/RegionCodeDecoder;
    //   907: pop
    //   908: aload 5
    //   910: astore_1
    //   911: aload 6
    //   913: aload 6
    //   915: invokevirtual 333	java/io/File:getParentFile	()Ljava/io/File;
    //   918: invokestatic 344	com/tencent/mm/storage/RegionCodeDecoder:d	(Ljava/io/File;Ljava/io/File;)V
    //   921: iload_3
    //   922: iconst_1
    //   923: iadd
    //   924: istore_3
    //   925: goto -35 -> 890
    //   928: aload 5
    //   930: astore_1
    //   931: invokestatic 295	com/tencent/mm/storage/RegionCodeDecoder:bMF	()Lcom/tencent/mm/storage/RegionCodeDecoder;
    //   934: invokevirtual 347	com/tencent/mm/storage/RegionCodeDecoder:bKH	()V
    //   937: aload 5
    //   939: astore_1
    //   940: aload 11
    //   942: invokevirtual 348	java/io/BufferedReader:close	()V
    //   945: aload 5
    //   947: astore_1
    //   948: aload 10
    //   950: invokevirtual 349	java/io/InputStreamReader:close	()V
    //   953: aload 5
    //   955: astore_1
    //   956: aload 9
    //   958: invokevirtual 352	java/io/File:delete	()Z
    //   961: pop
    //   962: aload 5
    //   964: invokevirtual 261	java/io/InputStream:close	()V
    //   967: aload 8
    //   969: invokeinterface 267 1 0
    //   974: invokeinterface 273 1 0
    //   979: astore_1
    //   980: aload_1
    //   981: invokeinterface 278 1 0
    //   986: ifeq +43 -> 1029
    //   989: aload_1
    //   990: invokeinterface 282 1 0
    //   995: checkcast 284	java/io/BufferedWriter
    //   998: astore_2
    //   999: aload_2
    //   1000: ifnull -20 -> 980
    //   1003: aload_2
    //   1004: invokevirtual 285	java/io/BufferedWriter:close	()V
    //   1007: goto -27 -> 980
    //   1010: astore_1
    //   1011: ldc 52
    //   1013: ldc -9
    //   1015: iconst_1
    //   1016: anewarray 158	java/lang/Object
    //   1019: dup
    //   1020: iconst_0
    //   1021: aload_1
    //   1022: invokestatic 251	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1025: aastore
    //   1026: invokestatic 253	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1029: ldc2_w 180
    //   1032: ldc -74
    //   1034: invokestatic 76	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   1037: iconst_1
    //   1038: ireturn
    //   1039: astore_1
    //   1040: aload_2
    //   1041: astore 5
    //   1043: goto -483 -> 560
    //   1046: astore 5
    //   1048: aconst_null
    //   1049: astore_2
    //   1050: goto -702 -> 348
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1053	0	this	j
    //   0	1053	1	paramString1	String
    //   0	1053	2	paramString2	String
    //   889	36	3	i	int
    //   886	8	4	j	int
    //   213	829	5	localObject1	Object
    //   1046	1	5	localException	Exception
    //   255	659	6	localObject2	Object
    //   501	337	7	localObject3	Object
    //   202	766	8	localHashMap	java.util.HashMap
    //   115	842	9	localFile	File
    //   229	720	10	localInputStreamReader	java.io.InputStreamReader
    //   243	698	11	localBufferedReader	java.io.BufferedReader
    //   275	475	12	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   218	231	341	java/lang/Exception
    //   234	245	341	java/lang/Exception
    //   250	257	341	java/lang/Exception
    //   265	277	341	java/lang/Exception
    //   280	287	341	java/lang/Exception
    //   290	300	341	java/lang/Exception
    //   303	313	341	java/lang/Exception
    //   316	338	341	java/lang/Exception
    //   487	503	341	java/lang/Exception
    //   515	519	341	java/lang/Exception
    //   522	530	341	java/lang/Exception
    //   533	540	341	java/lang/Exception
    //   543	551	341	java/lang/Exception
    //   640	650	341	java/lang/Exception
    //   653	661	341	java/lang/Exception
    //   664	670	341	java/lang/Exception
    //   673	691	341	java/lang/Exception
    //   694	708	341	java/lang/Exception
    //   711	720	341	java/lang/Exception
    //   723	733	341	java/lang/Exception
    //   736	744	341	java/lang/Exception
    //   747	757	341	java/lang/Exception
    //   760	768	341	java/lang/Exception
    //   771	781	341	java/lang/Exception
    //   787	801	341	java/lang/Exception
    //   804	814	341	java/lang/Exception
    //   817	829	341	java/lang/Exception
    //   837	842	341	java/lang/Exception
    //   848	855	341	java/lang/Exception
    //   858	881	341	java/lang/Exception
    //   884	888	341	java/lang/Exception
    //   904	908	341	java/lang/Exception
    //   911	921	341	java/lang/Exception
    //   931	937	341	java/lang/Exception
    //   940	945	341	java/lang/Exception
    //   948	953	341	java/lang/Exception
    //   956	962	341	java/lang/Exception
    //   408	412	455	java/io/IOException
    //   412	425	455	java/io/IOException
    //   425	444	455	java/io/IOException
    //   448	452	455	java/io/IOException
    //   218	231	554	finally
    //   234	245	554	finally
    //   250	257	554	finally
    //   265	277	554	finally
    //   280	287	554	finally
    //   290	300	554	finally
    //   303	313	554	finally
    //   316	338	554	finally
    //   350	369	554	finally
    //   371	385	554	finally
    //   387	404	554	finally
    //   487	503	554	finally
    //   515	519	554	finally
    //   522	530	554	finally
    //   533	540	554	finally
    //   543	551	554	finally
    //   640	650	554	finally
    //   653	661	554	finally
    //   664	670	554	finally
    //   673	691	554	finally
    //   694	708	554	finally
    //   711	720	554	finally
    //   723	733	554	finally
    //   736	744	554	finally
    //   747	757	554	finally
    //   760	768	554	finally
    //   771	781	554	finally
    //   787	801	554	finally
    //   804	814	554	finally
    //   817	829	554	finally
    //   837	842	554	finally
    //   848	855	554	finally
    //   858	881	554	finally
    //   884	888	554	finally
    //   904	908	554	finally
    //   911	921	554	finally
    //   931	937	554	finally
    //   940	945	554	finally
    //   948	953	554	finally
    //   956	962	554	finally
    //   565	570	616	java/io/IOException
    //   570	583	616	java/io/IOException
    //   583	603	616	java/io/IOException
    //   608	613	616	java/io/IOException
    //   962	980	1010	java/io/IOException
    //   980	999	1010	java/io/IOException
    //   1003	1007	1010	java/io/IOException
    //   204	215	1039	finally
    //   204	215	1046	java/lang/Exception
  }
  
  public final int BQ()
  {
    GMTrace.i(12946910478336L, 96462);
    int i = this.fFq;
    GMTrace.o(12946910478336L, 96462);
    return i;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(12945836736512L, 96454);
    this.gUt = parame1;
    v.d("MicroMsg.NetSceneDownloadPackage", "dkregcode doScene pkgId:%d packageType:%d", new Object[] { Integer.valueOf(this.hNR), Integer.valueOf(this.fFq) });
    parame1 = t.Id().aQ(this.hNR, this.fFq);
    if (parame1 == null)
    {
      v.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme failed id:" + this.hNR + " type:" + this.fFq);
      GMTrace.o(12945836736512L, 96454);
      return -1;
    }
    if (parame1.status != 3)
    {
      v.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme stat failed id:" + this.hNR + " stat:" + parame1.status);
      GMTrace.o(12945836736512L, 96454);
      return -1;
    }
    if (parame1.size <= 0)
    {
      v.e("MicroMsg.NetSceneDownloadPackage", "doScene Theme size err id:" + this.hNR + " size:" + parame1.size);
      GMTrace.o(12945836736512L, 96454);
      return -1;
    }
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new og();
    ((b.a)localObject).hrW = new oh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/downloadpackage";
    ((b.a)localObject).hrU = 160;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    localObject = (og)this.gUq.hrS.hsa;
    aoy localaoy = new aoy();
    localaoy.mus = parame1.id;
    localaoy.jMp = parame1.version;
    ((og)localObject).tsk = localaoy;
    ((og)localObject).tjF = this.offset;
    ((og)localObject).tsl = 65536;
    ((og)localObject).jMq = this.fFq;
    int i = a(parame, this.gUq, this);
    GMTrace.o(12945836736512L, 96454);
    return i;
  }
  
  protected final int a(p paramp)
  {
    GMTrace.i(12945970954240L, 96455);
    paramp = (og)((com.tencent.mm.y.b)paramp).hrS.hsa;
    m localm = t.Id().aQ(this.hNR, this.fFq);
    if (localm == null)
    {
      v.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked get Theme failed id:" + this.hNR);
      i = k.b.hsD;
      GMTrace.o(12945970954240L, 96455);
      return i;
    }
    if ((paramp.tsk.mus != this.hNR) || (paramp.tjF != this.offset) || (paramp.tjF >= localm.size) || (paramp.tsl != 65536) || (localm.size <= 0) || (localm.status != 3))
    {
      v.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked Theme failed id:" + this.hNR);
      i = k.b.hsD;
      GMTrace.o(12945970954240L, 96455);
      return i;
    }
    int i = k.b.hsC;
    GMTrace.o(12945970954240L, 96455);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(12946373607424L, 96458);
    v.d("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd id:" + this.hNR + " + id:" + paramInt1 + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      v.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd, errType = " + paramInt2 + ", errCode = " + paramInt3);
      t.Id().aU(this.hNR, this.fFq);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(12946373607424L, 96458);
      return;
    }
    paramp = (oh)((com.tencent.mm.y.b)paramp).hrT.hsa;
    if (paramp.jMq != this.fFq)
    {
      v.e("MicroMsg.NetSceneDownloadPackage", "packageType is not consistent");
      t.Id().aU(this.hNR, this.fFq);
      this.gUt.a(3, -1, "", this);
      GMTrace.o(12946373607424L, 96458);
      return;
    }
    byte[] arrayOfByte = com.tencent.mm.platformtools.n.a(paramp.tsm);
    if ((arrayOfByte == null) || (arrayOfByte.length == 0))
    {
      v.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd get pkgBuf failed id:" + this.hNR);
      t.Id().aU(this.hNR, this.fFq);
      this.gUt.a(3, -1, paramString, this);
      GMTrace.o(12946373607424L, 96458);
      return;
    }
    m localm = t.Id().aQ(this.hNR, this.fFq);
    if (localm == null)
    {
      v.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd info is null, pkgId = " + this.hNR);
      t.Id().aU(this.hNR, this.fFq);
      this.gUt.a(3, -1, paramString, this);
      GMTrace.o(12946373607424L, 96458);
      return;
    }
    if (localm.size != paramp.tsn)
    {
      v.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd totalSize is incorrect");
      t.Id().aU(this.hNR, this.fFq);
      paramp = new k(this.fFq);
      h.vH().gXs.a(paramp, 0);
      this.gUt.a(3, -1, paramString, this);
      GMTrace.o(12946373607424L, 96458);
      return;
    }
    if (this.fFq == 5) {
      paramArrayOfByte = h.vI().cachePath;
    }
    for (paramp = "brand_i18n.apk";; paramp = t.Id().aS(this.hNR, this.fFq))
    {
      v.d("MicroMsg.NetSceneDownloadPackage", "packagePath " + paramArrayOfByte);
      v.d("MicroMsg.NetSceneDownloadPackage", "packageName " + paramp);
      paramInt1 = com.tencent.mm.a.e.a(paramArrayOfByte, paramp, arrayOfByte);
      if (paramInt1 == 0) {
        break;
      }
      t.Id().aU(this.hNR, this.fFq);
      v.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd write file fail, ret = " + paramInt1);
      this.gUt.a(3, -1, paramString, this);
      GMTrace.o(12946373607424L, 96458);
      return;
      t.Id();
      paramArrayOfByte = n.HZ();
    }
    paramInt1 = this.offset;
    this.offset = (arrayOfByte.length + paramInt1);
    if (this.offset >= localm.size)
    {
      boolean bool = false;
      if (this.fFq == 1)
      {
        paramString = t.Id().aT(this.hNR, this.fFq);
        paramInt1 = bf.eA(paramArrayOfByte + paramp, paramString);
        if (paramInt1 < 0)
        {
          v.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + paramInt1 + ", zipFilePath = " + paramArrayOfByte + paramp + ", unzipPath = " + paramString);
          t.Id().aU(this.hNR, this.fFq);
          this.gUt.a(3, 0, "unzip fail", this);
          bool = false;
        }
      }
      else
      {
        if (this.fFq == 8) {
          bool = ae(paramArrayOfByte, paramp);
        }
        if (this.fFq == 23)
        {
          if ((!bf.mA(paramArrayOfByte)) && (!bf.mA(paramp))) {
            break label1300;
          }
          v.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, packagePath: %s, packageName: %s", new Object[] { paramArrayOfByte, paramp });
          t.Id().aU(this.hNR, this.fFq);
          this.gUt.a(3, 0, "open permission pkg failed", this);
          bool = false;
        }
        label899:
        if (this.fFq == 7) {
          bool = true;
        }
        if (this.fFq == 9) {
          bool = true;
        }
        if (this.fFq == 5)
        {
          bool = true;
          v.i("MicroMsg.NetSceneDownloadPackage", "resetResContextImp");
        }
        if (this.fFq == 12)
        {
          paramString = new lm();
          paramString.fSj.fSl = (paramArrayOfByte + paramp);
          a.uql.m(paramString);
          bool = true;
        }
        if (this.fFq == 18)
        {
          paramString = t.Id().aT(this.hNR, this.fFq);
          paramInt1 = bf.eA(paramArrayOfByte + paramp, paramString);
          if (paramInt1 >= 0) {
            break label1495;
          }
          v.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + paramInt1 + ", zipFilePath = " + paramArrayOfByte + paramp + ", unzipPath = " + paramString);
          t.Id().aU(this.hNR, this.fFq);
          this.gUt.a(3, 0, "unzip fail", this);
          bool = false;
        }
        label1136:
        if (this.fFq == 20) {
          bool = true;
        }
        if (this.fFq == 21) {
          bool = true;
        }
        if (this.fFq == 26)
        {
          if ((!bf.mA(paramArrayOfByte)) && (!bf.mA(paramp))) {
            break label1518;
          }
          v.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, packagePath: %s, packageName: %s", new Object[] { paramArrayOfByte, paramp });
          this.gUt.a(3, 0, "open IPCallContryCodeConfigs pkg failed", this);
          bool = false;
        }
      }
      for (;;)
      {
        if (this.fFq == 36) {
          bool = ad(paramArrayOfByte, paramp);
        }
        if (bool)
        {
          localm.status = 2;
          localm.fRM = 64;
          t.Id().b(localm);
          this.gUt.a(0, 0, "", this);
        }
        GMTrace.o(12946373607424L, 96458);
        return;
        bool = true;
        break;
        label1300:
        if (!new File(paramArrayOfByte + paramp).exists())
        {
          v.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, file no exist, path: %s, name: %s", new Object[] { paramArrayOfByte, paramp });
          t.Id().aU(this.hNR, this.fFq);
          this.gUt.a(3, 0, "file not exist", this);
          bool = false;
          break label899;
        }
        paramString = com.tencent.mm.compatible.util.e.hgg + "permissioncfg.cfg";
        if (-1L == com.tencent.mm.a.e.p(paramArrayOfByte + paramp, paramString))
        {
          v.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
          t.Id().aU(this.hNR, this.fFq);
          this.gUt.a(3, 0, "copy file failed", this);
          bool = false;
          break label899;
        }
        bool = true;
        break label899;
        label1495:
        v.i("MicroMsg.NetSceneDownloadPackage", "Unzip Path %s", new Object[] { paramString });
        bool = true;
        break label1136;
        label1518:
        if (!new File(paramArrayOfByte + paramp).exists())
        {
          v.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, file not exist, packagePath: %s, packageName: %s", new Object[] { paramArrayOfByte, paramp });
          t.Id().aU(this.hNR, this.fFq);
          this.gUt.a(3, 0, "file not exist", this);
          bool = false;
        }
        else
        {
          paramString = com.tencent.mm.compatible.util.e.hgg + "ipcallCountryCodeConfig.cfg";
          if (-1L == com.tencent.mm.a.e.p(paramArrayOfByte + paramp, paramString))
          {
            v.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
            t.Id().aU(this.hNR, this.fFq);
            this.gUt.a(3, 0, "copy file failed", this);
            bool = false;
          }
          else
          {
            v.d("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg success");
            bool = true;
          }
        }
      }
    }
    if (a(this.hsm, this.gUt) < 0)
    {
      t.Id().aU(this.hNR, this.fFq);
      this.gUt.a(3, -1, paramString, this);
    }
    GMTrace.o(12946373607424L, 96458);
  }
  
  protected final void a(k.a parama)
  {
    GMTrace.i(12946239389696L, 96457);
    t.Id().aU(this.hNR, this.fFq);
    GMTrace.o(12946239389696L, 96457);
  }
  
  public final int getType()
  {
    GMTrace.i(12946776260608L, 96461);
    GMTrace.o(12946776260608L, 96461);
    return 160;
  }
  
  protected final int ub()
  {
    GMTrace.i(12946105171968L, 96456);
    GMTrace.o(12946105171968L, 96456);
    return 50;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ap/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */