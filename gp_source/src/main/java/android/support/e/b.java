package android.support.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

final class b
{
  private static long a(File paramFile)
  {
    long l2 = paramFile.lastModified();
    long l1 = l2;
    if (l2 == -1L) {
      l1 = l2 - 1L;
    }
    return l1;
  }
  
  private static SharedPreferences a(Context paramContext)
  {
    return paramContext.getSharedPreferences("multidex.version", 4);
  }
  
  /* Error */
  static List a(Context paramContext, android.content.pm.ApplicationInfo paramApplicationInfo, File paramFile)
  {
    // Byte code:
    //   0: new 29	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   7: astore 13
    //   9: aload 13
    //   11: ldc 35
    //   13: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 13
    //   19: aload_1
    //   20: getfield 45	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   23: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload 13
    //   29: ldc 47
    //   31: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 13
    //   37: iconst_0
    //   38: invokevirtual 50	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload 13
    //   44: ldc 52
    //   46: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: ldc 54
    //   52: aload 13
    //   54: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 64	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   60: pop
    //   61: new 8	java/io/File
    //   64: dup
    //   65: aload_1
    //   66: getfield 45	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   69: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   72: astore 18
    //   74: aload 18
    //   76: invokestatic 70	android/support/e/b:b	(Ljava/io/File;)J
    //   79: lstore 5
    //   81: new 8	java/io/File
    //   84: dup
    //   85: aload_2
    //   86: ldc 72
    //   88: invokespecial 75	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   91: astore 17
    //   93: new 77	java/io/RandomAccessFile
    //   96: dup
    //   97: aload 17
    //   99: ldc 79
    //   101: invokespecial 80	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   104: astore 16
    //   106: aload 16
    //   108: invokevirtual 84	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   111: astore 13
    //   113: new 29	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   120: astore_1
    //   121: aload_1
    //   122: ldc 86
    //   124: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload_1
    //   129: aload 17
    //   131: invokevirtual 89	java/io/File:getPath	()Ljava/lang/String;
    //   134: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: ldc 54
    //   140: aload_1
    //   141: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 64	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   147: pop
    //   148: aload 13
    //   150: invokevirtual 95	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   153: astore 14
    //   155: new 29	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   162: astore_1
    //   163: aload_1
    //   164: aload 17
    //   166: invokevirtual 89	java/io/File:getPath	()Ljava/lang/String;
    //   169: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload_1
    //   174: ldc 97
    //   176: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: ldc 54
    //   182: aload_1
    //   183: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 64	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   189: pop
    //   190: aload_0
    //   191: invokestatic 99	android/support/e/b:a	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   194: astore_1
    //   195: aload_1
    //   196: ldc 101
    //   198: ldc2_w 13
    //   201: invokeinterface 107 4 0
    //   206: aload 18
    //   208: invokestatic 109	android/support/e/b:a	(Ljava/io/File;)J
    //   211: lcmp
    //   212: ifeq +116 -> 328
    //   215: ldc 54
    //   217: ldc 111
    //   219: invokestatic 64	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   222: pop
    //   223: aload 18
    //   225: aload_2
    //   226: invokestatic 114	android/support/e/b:a	(Ljava/io/File;Ljava/io/File;)Ljava/util/List;
    //   229: astore_1
    //   230: aload_0
    //   231: aload 18
    //   233: invokestatic 109	android/support/e/b:a	(Ljava/io/File;)J
    //   236: lload 5
    //   238: aload_1
    //   239: invokestatic 117	android/support/e/b:a	(Landroid/content/Context;JJLjava/util/List;)V
    //   242: aload 14
    //   244: ifnull +79 -> 323
    //   247: aload 14
    //   249: invokevirtual 122	java/nio/channels/FileLock:release	()V
    //   252: aconst_null
    //   253: astore_0
    //   254: aload 13
    //   256: ifnonnull +59 -> 315
    //   259: aload 16
    //   261: invokestatic 125	android/support/e/b:a	(Ljava/io/Closeable;)V
    //   264: aload_0
    //   265: ifnull +5 -> 270
    //   268: aload_0
    //   269: athrow
    //   270: new 29	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   277: astore_0
    //   278: aload_0
    //   279: ldc 127
    //   281: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload_0
    //   286: aload_1
    //   287: invokeinterface 133 1 0
    //   292: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload_0
    //   297: ldc -118
    //   299: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: ldc 54
    //   305: aload_0
    //   306: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 64	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   312: pop
    //   313: aload_1
    //   314: areturn
    //   315: aload 13
    //   317: invokestatic 125	android/support/e/b:a	(Ljava/io/Closeable;)V
    //   320: goto -61 -> 259
    //   323: aconst_null
    //   324: astore_0
    //   325: goto -71 -> 254
    //   328: aload_1
    //   329: ldc -116
    //   331: ldc2_w 13
    //   334: invokeinterface 107 4 0
    //   339: lstore 7
    //   341: lload 7
    //   343: lload 5
    //   345: lcmp
    //   346: ifne -131 -> 215
    //   349: ldc 54
    //   351: ldc -114
    //   353: invokestatic 64	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   356: pop
    //   357: new 29	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   364: astore_1
    //   365: aload_1
    //   366: aload 18
    //   368: invokevirtual 145	java/io/File:getName	()Ljava/lang/String;
    //   371: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: aload_1
    //   376: ldc -109
    //   378: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: aload_1
    //   383: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: astore 19
    //   388: aload_0
    //   389: invokestatic 99	android/support/e/b:a	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   392: astore 20
    //   394: aload 20
    //   396: ldc -107
    //   398: iconst_1
    //   399: invokeinterface 153 3 0
    //   404: istore 4
    //   406: new 155	java/util/ArrayList
    //   409: dup
    //   410: iload 4
    //   412: iconst_1
    //   413: isub
    //   414: invokespecial 158	java/util/ArrayList:<init>	(I)V
    //   417: astore 15
    //   419: iconst_2
    //   420: istore_3
    //   421: aload 15
    //   423: astore_1
    //   424: iload_3
    //   425: iload 4
    //   427: if_icmpgt -185 -> 242
    //   430: new 29	java/lang/StringBuilder
    //   433: dup
    //   434: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   437: astore_1
    //   438: aload_1
    //   439: aload 19
    //   441: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: aload_1
    //   446: iload_3
    //   447: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   450: pop
    //   451: aload_1
    //   452: ldc -96
    //   454: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: new 162	android/support/e/d
    //   461: dup
    //   462: aload_2
    //   463: aload_1
    //   464: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokespecial 163	android/support/e/d:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   470: astore_1
    //   471: aload_1
    //   472: invokevirtual 167	android/support/e/d:isFile	()Z
    //   475: ifeq +354 -> 829
    //   478: aload_1
    //   479: aload_1
    //   480: invokestatic 70	android/support/e/b:b	(Ljava/io/File;)J
    //   483: putfield 170	android/support/e/d:a	J
    //   486: new 29	java/lang/StringBuilder
    //   489: dup
    //   490: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   493: astore 21
    //   495: aload 21
    //   497: ldc -84
    //   499: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: aload 21
    //   505: iload_3
    //   506: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: aload 20
    //   512: aload 21
    //   514: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   517: ldc2_w 13
    //   520: invokeinterface 107 4 0
    //   525: lstore 7
    //   527: new 29	java/lang/StringBuilder
    //   530: dup
    //   531: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   534: astore 21
    //   536: aload 21
    //   538: ldc -82
    //   540: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: pop
    //   544: aload 21
    //   546: iload_3
    //   547: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload 20
    //   553: aload 21
    //   555: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: ldc2_w 13
    //   561: invokeinterface 107 4 0
    //   566: lstore 9
    //   568: aload_1
    //   569: invokevirtual 175	android/support/e/d:lastModified	()J
    //   572: lstore 11
    //   574: lload 9
    //   576: lload 11
    //   578: lcmp
    //   579: ifne +13 -> 592
    //   582: lload 7
    //   584: aload_1
    //   585: getfield 170	android/support/e/d:a	J
    //   588: lcmp
    //   589: ifeq +168 -> 757
    //   592: new 29	java/lang/StringBuilder
    //   595: dup
    //   596: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   599: astore 15
    //   601: aload 15
    //   603: ldc -79
    //   605: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: pop
    //   609: aload 15
    //   611: aload_1
    //   612: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   615: pop
    //   616: aload 15
    //   618: ldc -74
    //   620: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: pop
    //   624: aload 15
    //   626: lload 9
    //   628: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   631: pop
    //   632: aload 15
    //   634: ldc -69
    //   636: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: pop
    //   640: aload 15
    //   642: lload 11
    //   644: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   647: pop
    //   648: aload 15
    //   650: ldc -67
    //   652: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: pop
    //   656: aload 15
    //   658: lload 7
    //   660: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   663: pop
    //   664: aload 15
    //   666: ldc -65
    //   668: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: pop
    //   672: aload 15
    //   674: aload_1
    //   675: getfield 170	android/support/e/d:a	J
    //   678: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   681: pop
    //   682: new 27	java/io/IOException
    //   685: dup
    //   686: aload 15
    //   688: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   691: invokespecial 192	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   694: athrow
    //   695: astore_1
    //   696: ldc 54
    //   698: ldc -62
    //   700: aload_1
    //   701: invokestatic 198	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   704: pop
    //   705: aload 18
    //   707: aload_2
    //   708: invokestatic 114	android/support/e/b:a	(Ljava/io/File;Ljava/io/File;)Ljava/util/List;
    //   711: astore_1
    //   712: aload_0
    //   713: aload 18
    //   715: invokestatic 109	android/support/e/b:a	(Ljava/io/File;)J
    //   718: lload 5
    //   720: aload_1
    //   721: invokestatic 117	android/support/e/b:a	(Landroid/content/Context;JJLjava/util/List;)V
    //   724: goto -482 -> 242
    //   727: astore_2
    //   728: aload 13
    //   730: astore_0
    //   731: aload 14
    //   733: astore_1
    //   734: aload_1
    //   735: ifnull +7 -> 742
    //   738: aload_1
    //   739: invokevirtual 122	java/nio/channels/FileLock:release	()V
    //   742: aload_0
    //   743: ifnull +7 -> 750
    //   746: aload_0
    //   747: invokestatic 125	android/support/e/b:a	(Ljava/io/Closeable;)V
    //   750: aload 16
    //   752: invokestatic 125	android/support/e/b:a	(Ljava/io/Closeable;)V
    //   755: aload_2
    //   756: athrow
    //   757: aload 15
    //   759: aload_1
    //   760: invokeinterface 202 2 0
    //   765: pop
    //   766: iload_3
    //   767: iconst_1
    //   768: iadd
    //   769: istore_3
    //   770: goto -349 -> 421
    //   773: astore_2
    //   774: aconst_null
    //   775: astore_0
    //   776: aconst_null
    //   777: astore_1
    //   778: goto -44 -> 734
    //   781: astore_2
    //   782: aconst_null
    //   783: astore_1
    //   784: aload 13
    //   786: astore_0
    //   787: goto -53 -> 734
    //   790: astore_0
    //   791: new 29	java/lang/StringBuilder
    //   794: dup
    //   795: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   798: astore_2
    //   799: aload_2
    //   800: ldc -52
    //   802: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: pop
    //   806: aload_2
    //   807: aload 17
    //   809: invokevirtual 89	java/io/File:getPath	()Ljava/lang/String;
    //   812: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: pop
    //   816: ldc 54
    //   818: aload_2
    //   819: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   822: invokestatic 207	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   825: pop
    //   826: goto -572 -> 254
    //   829: new 29	java/lang/StringBuilder
    //   832: dup
    //   833: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   836: astore 15
    //   838: aload 15
    //   840: ldc -47
    //   842: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   845: pop
    //   846: aload 15
    //   848: aload_1
    //   849: invokevirtual 210	android/support/e/d:getPath	()Ljava/lang/String;
    //   852: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: pop
    //   856: aload 15
    //   858: ldc -44
    //   860: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   863: pop
    //   864: new 27	java/io/IOException
    //   867: dup
    //   868: aload 15
    //   870: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   873: invokespecial 192	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   876: athrow
    //   877: astore_1
    //   878: new 29	java/lang/StringBuilder
    //   881: dup
    //   882: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   885: astore_1
    //   886: aload_1
    //   887: ldc -52
    //   889: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   892: pop
    //   893: aload_1
    //   894: aload 17
    //   896: invokevirtual 89	java/io/File:getPath	()Ljava/lang/String;
    //   899: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: pop
    //   903: ldc 54
    //   905: aload_1
    //   906: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   909: invokestatic 207	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   912: pop
    //   913: goto -171 -> 742
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	916	0	paramContext	Context
    //   0	916	1	paramApplicationInfo	android.content.pm.ApplicationInfo
    //   0	916	2	paramFile	File
    //   420	350	3	i	int
    //   404	24	4	j	int
    //   79	640	5	l1	long
    //   339	320	7	l2	long
    //   566	61	9	l3	long
    //   572	71	11	l4	long
    //   7	778	13	localObject1	Object
    //   153	579	14	localFileLock	java.nio.channels.FileLock
    //   417	452	15	localObject2	Object
    //   104	647	16	localRandomAccessFile	java.io.RandomAccessFile
    //   91	804	17	localFile1	File
    //   72	642	18	localFile2	File
    //   386	54	19	str	String
    //   392	160	20	localSharedPreferences	SharedPreferences
    //   493	61	21	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   349	419	695	java/io/IOException
    //   430	574	695	java/io/IOException
    //   582	592	695	java/io/IOException
    //   592	695	695	java/io/IOException
    //   757	766	695	java/io/IOException
    //   829	877	695	java/io/IOException
    //   155	215	727	finally
    //   215	242	727	finally
    //   328	341	727	finally
    //   349	419	727	finally
    //   430	574	727	finally
    //   582	592	727	finally
    //   592	695	727	finally
    //   696	724	727	finally
    //   757	766	727	finally
    //   829	877	727	finally
    //   106	113	773	finally
    //   113	155	781	finally
    //   247	252	790	java/io/IOException
    //   738	742	877	java/io/IOException
  }
  
  /* Error */
  private static List a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: new 29	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: aload_0
    //   12: invokevirtual 145	java/io/File:getName	()Ljava/lang/String;
    //   15: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: pop
    //   19: aload 5
    //   21: ldc -109
    //   23: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload 5
    //   29: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: astore 6
    //   34: aload_1
    //   35: new 214	android/support/e/c
    //   38: dup
    //   39: aload 6
    //   41: invokespecial 215	android/support/e/c:<init>	(Ljava/lang/String;)V
    //   44: invokevirtual 219	java/io/File:listFiles	(Ljava/io/FileFilter;)[Ljava/io/File;
    //   47: astore 5
    //   49: aload 5
    //   51: ifnonnull +825 -> 876
    //   54: new 29	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   61: astore 5
    //   63: aload 5
    //   65: ldc -35
    //   67: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 5
    //   73: aload_1
    //   74: invokevirtual 89	java/io/File:getPath	()Ljava/lang/String;
    //   77: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload 5
    //   83: ldc -33
    //   85: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: ldc 54
    //   91: aload 5
    //   93: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 225	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   99: pop
    //   100: new 155	java/util/ArrayList
    //   103: dup
    //   104: invokespecial 226	java/util/ArrayList:<init>	()V
    //   107: astore 8
    //   109: new 228	java/util/zip/ZipFile
    //   112: dup
    //   113: aload_0
    //   114: invokespecial 231	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   117: astore 7
    //   119: new 29	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   126: astore_0
    //   127: aload_0
    //   128: ldc -23
    //   130: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload_0
    //   135: iconst_2
    //   136: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload_0
    //   141: ldc -21
    //   143: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload 7
    //   149: aload_0
    //   150: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokevirtual 239	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   156: astore_0
    //   157: iconst_2
    //   158: istore 4
    //   160: aload_0
    //   161: ifnull +707 -> 868
    //   164: new 29	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   171: astore 5
    //   173: aload 5
    //   175: aload 6
    //   177: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 5
    //   183: iload 4
    //   185: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 5
    //   191: ldc -96
    //   193: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: new 162	android/support/e/d
    //   200: dup
    //   201: aload_1
    //   202: aload 5
    //   204: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokespecial 163	android/support/e/d:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   210: astore 9
    //   212: aload 8
    //   214: aload 9
    //   216: invokeinterface 202 2 0
    //   221: pop
    //   222: new 29	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   229: astore 5
    //   231: aload 5
    //   233: ldc -15
    //   235: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload 5
    //   241: aload 9
    //   243: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: ldc 54
    //   249: aload 5
    //   251: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 64	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   257: pop
    //   258: iconst_0
    //   259: istore_3
    //   260: iconst_0
    //   261: istore_2
    //   262: goto +998 -> 1260
    //   265: iload_3
    //   266: ifeq +785 -> 1051
    //   269: iload 4
    //   271: iconst_1
    //   272: iadd
    //   273: istore 4
    //   275: new 29	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   282: astore_0
    //   283: aload_0
    //   284: ldc -23
    //   286: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload_0
    //   291: iload 4
    //   293: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload_0
    //   298: ldc -21
    //   300: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload 7
    //   306: aload_0
    //   307: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokevirtual 239	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   313: astore_0
    //   314: goto -154 -> 160
    //   317: iload_3
    //   318: ifne -53 -> 265
    //   321: iload_2
    //   322: iconst_1
    //   323: iadd
    //   324: istore_2
    //   325: aload 7
    //   327: aload_0
    //   328: invokevirtual 245	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   331: astore 5
    //   333: new 29	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   340: astore 10
    //   342: aload 10
    //   344: ldc -9
    //   346: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload 10
    //   352: aload 6
    //   354: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload 10
    //   360: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: ldc -96
    //   365: aload 9
    //   367: invokevirtual 251	java/io/File:getParentFile	()Ljava/io/File;
    //   370: invokestatic 255	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   373: astore 10
    //   375: new 29	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   382: astore 11
    //   384: aload 11
    //   386: ldc_w 257
    //   389: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload 11
    //   395: aload 10
    //   397: invokevirtual 89	java/io/File:getPath	()Ljava/lang/String;
    //   400: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: ldc 54
    //   406: aload 11
    //   408: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   411: invokestatic 64	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   414: pop
    //   415: new 259	java/util/zip/ZipOutputStream
    //   418: dup
    //   419: new 261	java/io/BufferedOutputStream
    //   422: dup
    //   423: new 263	java/io/FileOutputStream
    //   426: dup
    //   427: aload 10
    //   429: invokespecial 264	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   432: invokespecial 267	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   435: invokespecial 268	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   438: astore 11
    //   440: new 270	java/util/zip/ZipEntry
    //   443: dup
    //   444: ldc_w 272
    //   447: invokespecial 273	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   450: astore 12
    //   452: aload 12
    //   454: aload_0
    //   455: invokevirtual 276	java/util/zip/ZipEntry:getTime	()J
    //   458: invokevirtual 280	java/util/zip/ZipEntry:setTime	(J)V
    //   461: aload 11
    //   463: aload 12
    //   465: invokevirtual 284	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   468: sipush 16384
    //   471: newarray <illegal type>
    //   473: astore 12
    //   475: aload 5
    //   477: aload 12
    //   479: invokevirtual 290	java/io/InputStream:read	([B)I
    //   482: istore_3
    //   483: iload_3
    //   484: iconst_m1
    //   485: if_icmpne +363 -> 848
    //   488: aload 11
    //   490: invokevirtual 293	java/util/zip/ZipOutputStream:closeEntry	()V
    //   493: aload 11
    //   495: invokevirtual 296	java/util/zip/ZipOutputStream:close	()V
    //   498: aload 10
    //   500: invokevirtual 299	java/io/File:setReadOnly	()Z
    //   503: ifeq +616 -> 1119
    //   506: new 29	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   513: astore 11
    //   515: aload 11
    //   517: ldc_w 301
    //   520: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload 11
    //   526: aload 9
    //   528: invokevirtual 89	java/io/File:getPath	()Ljava/lang/String;
    //   531: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: pop
    //   535: ldc 54
    //   537: aload 11
    //   539: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: invokestatic 64	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   545: pop
    //   546: aload 10
    //   548: aload 9
    //   550: invokevirtual 305	java/io/File:renameTo	(Ljava/io/File;)Z
    //   553: ifne +89 -> 642
    //   556: new 29	java/lang/StringBuilder
    //   559: dup
    //   560: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   563: astore_0
    //   564: aload_0
    //   565: ldc_w 307
    //   568: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: pop
    //   572: aload_0
    //   573: aload 10
    //   575: invokevirtual 310	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   578: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: aload_0
    //   583: ldc_w 312
    //   586: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: pop
    //   590: aload_0
    //   591: aload 9
    //   593: invokevirtual 310	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   596: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: pop
    //   600: aload_0
    //   601: ldc_w 314
    //   604: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: new 27	java/io/IOException
    //   611: dup
    //   612: aload_0
    //   613: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: invokespecial 192	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   619: athrow
    //   620: astore_0
    //   621: aload 5
    //   623: invokestatic 125	android/support/e/b:a	(Ljava/io/Closeable;)V
    //   626: aload 10
    //   628: invokevirtual 317	java/io/File:delete	()Z
    //   631: pop
    //   632: aload_0
    //   633: athrow
    //   634: astore_0
    //   635: aload 7
    //   637: invokevirtual 318	java/util/zip/ZipFile:close	()V
    //   640: aload_0
    //   641: athrow
    //   642: aload 5
    //   644: invokestatic 125	android/support/e/b:a	(Ljava/io/Closeable;)V
    //   647: aload 10
    //   649: invokevirtual 317	java/io/File:delete	()Z
    //   652: pop
    //   653: aload 9
    //   655: aload 9
    //   657: invokestatic 70	android/support/e/b:b	(Ljava/io/File;)J
    //   660: putfield 170	android/support/e/d:a	J
    //   663: iconst_1
    //   664: istore_3
    //   665: new 29	java/lang/StringBuilder
    //   668: dup
    //   669: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   672: astore 10
    //   674: aload 10
    //   676: ldc_w 320
    //   679: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: pop
    //   683: iload_3
    //   684: ifne +156 -> 840
    //   687: ldc_w 322
    //   690: astore 5
    //   692: aload 10
    //   694: aload 5
    //   696: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: pop
    //   700: aload 10
    //   702: ldc_w 324
    //   705: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: pop
    //   709: aload 10
    //   711: aload 9
    //   713: invokevirtual 325	android/support/e/d:getAbsolutePath	()Ljava/lang/String;
    //   716: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: pop
    //   720: aload 10
    //   722: ldc_w 327
    //   725: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: pop
    //   729: aload 10
    //   731: aload 9
    //   733: invokevirtual 330	android/support/e/d:length	()J
    //   736: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   739: pop
    //   740: aload 10
    //   742: ldc_w 332
    //   745: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: pop
    //   749: aload 10
    //   751: aload 9
    //   753: getfield 170	android/support/e/d:a	J
    //   756: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   759: pop
    //   760: ldc 54
    //   762: aload 10
    //   764: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   767: invokestatic 64	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   770: pop
    //   771: iload_3
    //   772: ifne +499 -> 1271
    //   775: aload 9
    //   777: invokevirtual 333	android/support/e/d:delete	()Z
    //   780: pop
    //   781: aload 9
    //   783: invokevirtual 336	android/support/e/d:exists	()Z
    //   786: ifeq +482 -> 1268
    //   789: new 29	java/lang/StringBuilder
    //   792: dup
    //   793: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   796: astore 5
    //   798: aload 5
    //   800: ldc_w 338
    //   803: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: pop
    //   807: aload 5
    //   809: aload 9
    //   811: invokevirtual 210	android/support/e/d:getPath	()Ljava/lang/String;
    //   814: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: pop
    //   818: aload 5
    //   820: ldc -44
    //   822: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: pop
    //   826: ldc 54
    //   828: aload 5
    //   830: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   833: invokestatic 225	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   836: pop
    //   837: goto +423 -> 1260
    //   840: ldc_w 340
    //   843: astore 5
    //   845: goto -153 -> 692
    //   848: aload 11
    //   850: aload 12
    //   852: iconst_0
    //   853: iload_3
    //   854: invokevirtual 344	java/util/zip/ZipOutputStream:write	([BII)V
    //   857: aload 5
    //   859: aload 12
    //   861: invokevirtual 290	java/io/InputStream:read	([B)I
    //   864: istore_3
    //   865: goto -382 -> 483
    //   868: aload 7
    //   870: invokevirtual 318	java/util/zip/ZipFile:close	()V
    //   873: aload 8
    //   875: areturn
    //   876: aload 5
    //   878: arraylength
    //   879: istore_3
    //   880: iconst_0
    //   881: istore_2
    //   882: iload_2
    //   883: iload_3
    //   884: if_icmpge -784 -> 100
    //   887: aload 5
    //   889: iload_2
    //   890: aaload
    //   891: astore 7
    //   893: new 29	java/lang/StringBuilder
    //   896: dup
    //   897: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   900: astore 8
    //   902: aload 8
    //   904: ldc_w 346
    //   907: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   910: pop
    //   911: aload 8
    //   913: aload 7
    //   915: invokevirtual 89	java/io/File:getPath	()Ljava/lang/String;
    //   918: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: pop
    //   922: aload 8
    //   924: ldc_w 348
    //   927: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: pop
    //   931: aload 8
    //   933: aload 7
    //   935: invokevirtual 349	java/io/File:length	()J
    //   938: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   941: pop
    //   942: ldc 54
    //   944: aload 8
    //   946: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   949: invokestatic 64	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   952: pop
    //   953: aload 7
    //   955: invokevirtual 317	java/io/File:delete	()Z
    //   958: ifne +50 -> 1008
    //   961: new 29	java/lang/StringBuilder
    //   964: dup
    //   965: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   968: astore 8
    //   970: aload 8
    //   972: ldc_w 351
    //   975: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   978: pop
    //   979: aload 8
    //   981: aload 7
    //   983: invokevirtual 89	java/io/File:getPath	()Ljava/lang/String;
    //   986: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   989: pop
    //   990: ldc 54
    //   992: aload 8
    //   994: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   997: invokestatic 225	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   1000: pop
    //   1001: iload_2
    //   1002: iconst_1
    //   1003: iadd
    //   1004: istore_2
    //   1005: goto -123 -> 882
    //   1008: new 29	java/lang/StringBuilder
    //   1011: dup
    //   1012: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1015: astore 8
    //   1017: aload 8
    //   1019: ldc_w 353
    //   1022: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1025: pop
    //   1026: aload 8
    //   1028: aload 7
    //   1030: invokevirtual 89	java/io/File:getPath	()Ljava/lang/String;
    //   1033: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1036: pop
    //   1037: ldc 54
    //   1039: aload 8
    //   1041: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1044: invokestatic 64	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   1047: pop
    //   1048: goto -47 -> 1001
    //   1051: new 29	java/lang/StringBuilder
    //   1054: dup
    //   1055: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1058: astore_0
    //   1059: aload_0
    //   1060: ldc_w 355
    //   1063: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1066: pop
    //   1067: aload_0
    //   1068: aload 9
    //   1070: invokevirtual 325	android/support/e/d:getAbsolutePath	()Ljava/lang/String;
    //   1073: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1076: pop
    //   1077: aload_0
    //   1078: ldc_w 357
    //   1081: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1084: pop
    //   1085: aload_0
    //   1086: iload 4
    //   1088: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1091: pop
    //   1092: aload_0
    //   1093: ldc 52
    //   1095: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1098: pop
    //   1099: new 27	java/io/IOException
    //   1102: dup
    //   1103: aload_0
    //   1104: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1107: invokespecial 192	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1110: athrow
    //   1111: astore_0
    //   1112: aload 11
    //   1114: invokevirtual 296	java/util/zip/ZipOutputStream:close	()V
    //   1117: aload_0
    //   1118: athrow
    //   1119: new 29	java/lang/StringBuilder
    //   1122: dup
    //   1123: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1126: astore_0
    //   1127: aload_0
    //   1128: ldc_w 359
    //   1131: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1134: pop
    //   1135: aload_0
    //   1136: aload 10
    //   1138: invokevirtual 310	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1141: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1144: pop
    //   1145: aload_0
    //   1146: ldc_w 361
    //   1149: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1152: pop
    //   1153: aload_0
    //   1154: aload 9
    //   1156: invokevirtual 310	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1159: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1162: pop
    //   1163: aload_0
    //   1164: ldc_w 363
    //   1167: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1170: pop
    //   1171: new 27	java/io/IOException
    //   1174: dup
    //   1175: aload_0
    //   1176: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1179: invokespecial 192	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1182: athrow
    //   1183: astore 5
    //   1185: new 29	java/lang/StringBuilder
    //   1188: dup
    //   1189: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1192: astore 10
    //   1194: aload 10
    //   1196: ldc_w 365
    //   1199: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1202: pop
    //   1203: aload 10
    //   1205: aload 9
    //   1207: invokevirtual 325	android/support/e/d:getAbsolutePath	()Ljava/lang/String;
    //   1210: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1213: pop
    //   1214: ldc 54
    //   1216: aload 10
    //   1218: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1221: aload 5
    //   1223: invokestatic 198	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   1226: pop
    //   1227: iconst_0
    //   1228: istore_3
    //   1229: goto -564 -> 665
    //   1232: astore_0
    //   1233: ldc 54
    //   1235: ldc_w 367
    //   1238: aload_0
    //   1239: invokestatic 198	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   1242: pop
    //   1243: aload 8
    //   1245: areturn
    //   1246: astore_1
    //   1247: ldc 54
    //   1249: ldc_w 367
    //   1252: aload_1
    //   1253: invokestatic 198	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   1256: pop
    //   1257: goto -617 -> 640
    //   1260: iload_2
    //   1261: iconst_3
    //   1262: if_icmplt -945 -> 317
    //   1265: goto -1000 -> 265
    //   1268: goto -8 -> 1260
    //   1271: goto -11 -> 1260
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1274	0	paramFile1	File
    //   0	1274	1	paramFile2	File
    //   261	1002	2	i	int
    //   259	970	3	j	int
    //   158	929	4	k	int
    //   7	881	5	localObject1	Object
    //   1183	39	5	localIOException	IOException
    //   32	321	6	str	String
    //   117	912	7	localZipFile	java.util.zip.ZipFile
    //   107	1137	8	localObject2	Object
    //   210	996	9	locald	d
    //   340	877	10	localObject3	Object
    //   382	731	11	localObject4	Object
    //   450	410	12	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   415	440	620	finally
    //   493	620	620	finally
    //   1112	1119	620	finally
    //   1119	1183	620	finally
    //   119	157	634	finally
    //   164	258	634	finally
    //   275	314	634	finally
    //   325	415	634	finally
    //   621	634	634	finally
    //   642	653	634	finally
    //   653	663	634	finally
    //   665	683	634	finally
    //   692	771	634	finally
    //   775	837	634	finally
    //   1051	1111	634	finally
    //   1185	1227	634	finally
    //   440	483	1111	finally
    //   488	493	1111	finally
    //   848	865	1111	finally
    //   653	663	1183	java/io/IOException
    //   868	873	1232	java/io/IOException
    //   635	640	1246	java/io/IOException
  }
  
  private static void a(Context paramContext, long paramLong1, long paramLong2, List paramList)
  {
    paramContext = a(paramContext).edit();
    paramContext.putLong("timestamp", paramLong1);
    paramContext.putLong("crc", paramLong2);
    paramContext.putInt("dex.number", paramList.size() + 1);
    paramList = paramList.iterator();
    int i = 2;
    while (paramList.hasNext())
    {
      d locald = (d)paramList.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dex.crc.");
      localStringBuilder.append(i);
      paramContext.putLong(localStringBuilder.toString(), locald.a);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("dex.time.");
      localStringBuilder.append(i);
      paramContext.putLong(localStringBuilder.toString(), locald.lastModified());
      i += 1;
    }
    paramContext.commit();
  }
  
  private static void a(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      Log.w("MultiDex", "Failed to close resource", paramCloseable);
    }
  }
  
  private static long b(File paramFile)
  {
    long l2 = e.a(paramFile);
    long l1 = l2;
    if (l2 == -1L) {
      l1 = l2 - 1L;
    }
    return l1;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */