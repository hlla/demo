package com.google.android.finsky.dn.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.finsky.dn.g;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.play.b.a.c;
import java.io.DataOutputStream;
import java.io.File;

public final class l
{
  public final Context a;
  
  public l(Context paramContext)
  {
    this.a = paramContext;
  }
  
  /* Error */
  private static g a(h paramh, c paramc, File paramFile)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 23	java/io/File:getName	()Ljava/lang/String;
    //   4: astore 13
    //   6: new 25	java/io/DataOutputStream
    //   9: dup
    //   10: new 27	java/io/BufferedOutputStream
    //   13: dup
    //   14: new 29	java/io/FileOutputStream
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 32	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   22: invokespecial 35	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   25: invokespecial 36	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   28: astore_2
    //   29: new 38	java/util/HashMap
    //   32: dup
    //   33: invokespecial 39	java/util/HashMap:<init>	()V
    //   36: astore 14
    //   38: ldc 41
    //   40: iconst_1
    //   41: anewarray 4	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: aload 13
    //   48: invokestatic 46	com/google/android/finsky/utils/FinskyLog:a	(Ljava/lang/String;)Ljava/lang/String;
    //   51: aastore
    //   52: invokestatic 49	com/google/android/finsky/utils/FinskyLog:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   55: aload_2
    //   56: iconst_1
    //   57: invokevirtual 53	java/io/DataOutputStream:writeByte	(I)V
    //   60: aload_2
    //   61: aload_0
    //   62: invokeinterface 58 1 0
    //   67: invokevirtual 62	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   70: aload_2
    //   71: aload_0
    //   72: invokeinterface 64 1 0
    //   77: invokevirtual 62	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   80: aload_2
    //   81: aload_1
    //   82: invokestatic 69	com/google/android/finsky/utils/af:a	(Lcom/google/protobuf/nano/g;)Ljava/lang/String;
    //   85: invokevirtual 62	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   88: aload_0
    //   89: invokeinterface 73 1 0
    //   94: astore 15
    //   96: aload 15
    //   98: arraylength
    //   99: istore 7
    //   101: iconst_0
    //   102: istore 5
    //   104: iload 5
    //   106: iload 7
    //   108: if_icmpge +481 -> 589
    //   111: aload 15
    //   113: iload 5
    //   115: aaload
    //   116: invokeinterface 78 1 0
    //   121: astore 16
    //   123: aload 16
    //   125: arraylength
    //   126: istore 8
    //   128: iconst_0
    //   129: istore 6
    //   131: goto +518 -> 649
    //   134: aload 16
    //   136: iload 6
    //   138: aaload
    //   139: astore 17
    //   141: aload 17
    //   143: invokevirtual 84	com/google/android/finsky/dn/a/n:g	()I
    //   146: tableswitch	default:+519->665, 2:+295->441, 3:+250->396, 4:+208->354, 5:+167->313, 6:+111->257
    //   180: aload 17
    //   182: invokevirtual 84	com/google/android/finsky/dn/a/n:g	()I
    //   185: istore 5
    //   187: new 86	java/lang/StringBuilder
    //   190: dup
    //   191: bipush 45
    //   193: invokespecial 88	java/lang/StringBuilder:<init>	(I)V
    //   196: astore_0
    //   197: aload_0
    //   198: ldc 90
    //   200: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload_0
    //   205: iload 5
    //   207: invokevirtual 97	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: new 99	java/lang/IllegalStateException
    //   214: dup
    //   215: aload_0
    //   216: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokespecial 104	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   222: athrow
    //   223: astore_0
    //   224: aload_0
    //   225: athrow
    //   226: astore_1
    //   227: aload_2
    //   228: invokevirtual 107	java/io/DataOutputStream:close	()V
    //   231: aload_1
    //   232: athrow
    //   233: astore_0
    //   234: ldc 109
    //   236: iconst_2
    //   237: anewarray 4	java/lang/Object
    //   240: dup
    //   241: iconst_0
    //   242: aload 13
    //   244: invokestatic 46	com/google/android/finsky/utils/FinskyLog:a	(Ljava/lang/String;)Ljava/lang/String;
    //   247: aastore
    //   248: dup
    //   249: iconst_1
    //   250: aload_0
    //   251: aastore
    //   252: invokestatic 112	com/google/android/finsky/utils/FinskyLog:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   255: aconst_null
    //   256: areturn
    //   257: aload 17
    //   259: invokevirtual 116	com/google/android/finsky/dn/a/n:f	()[B
    //   262: astore 18
    //   264: aload 14
    //   266: aload 17
    //   268: invokevirtual 117	com/google/android/finsky/dn/a/n:a	()Ljava/lang/String;
    //   271: aload 18
    //   273: invokeinterface 123 3 0
    //   278: pop
    //   279: aload_2
    //   280: bipush 6
    //   282: aload 17
    //   284: invokevirtual 117	com/google/android/finsky/dn/a/n:a	()Ljava/lang/String;
    //   287: invokestatic 126	com/google/android/finsky/dn/a/l:a	(Ljava/io/DataOutputStream;BLjava/lang/String;)V
    //   290: aload 18
    //   292: arraylength
    //   293: istore 9
    //   295: aload_2
    //   296: iload 9
    //   298: invokevirtual 129	java/io/DataOutputStream:writeInt	(I)V
    //   301: aload_2
    //   302: aload 18
    //   304: iconst_0
    //   305: iload 9
    //   307: invokevirtual 133	java/io/DataOutputStream:write	([BII)V
    //   310: goto +358 -> 668
    //   313: aload 17
    //   315: invokevirtual 136	com/google/android/finsky/dn/a/n:e	()Ljava/lang/String;
    //   318: astore 18
    //   320: aload 14
    //   322: aload 17
    //   324: invokevirtual 117	com/google/android/finsky/dn/a/n:a	()Ljava/lang/String;
    //   327: aload 18
    //   329: invokeinterface 123 3 0
    //   334: pop
    //   335: aload_2
    //   336: iconst_5
    //   337: aload 17
    //   339: invokevirtual 117	com/google/android/finsky/dn/a/n:a	()Ljava/lang/String;
    //   342: invokestatic 126	com/google/android/finsky/dn/a/l:a	(Ljava/io/DataOutputStream;BLjava/lang/String;)V
    //   345: aload_2
    //   346: aload 18
    //   348: invokevirtual 62	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   351: goto +317 -> 668
    //   354: aload 17
    //   356: invokevirtual 139	com/google/android/finsky/dn/a/n:d	()D
    //   359: dstore_3
    //   360: aload 14
    //   362: aload 17
    //   364: invokevirtual 117	com/google/android/finsky/dn/a/n:a	()Ljava/lang/String;
    //   367: dload_3
    //   368: invokestatic 145	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   371: invokeinterface 123 3 0
    //   376: pop
    //   377: aload_2
    //   378: bipush 7
    //   380: aload 17
    //   382: invokevirtual 117	com/google/android/finsky/dn/a/n:a	()Ljava/lang/String;
    //   385: invokestatic 126	com/google/android/finsky/dn/a/l:a	(Ljava/io/DataOutputStream;BLjava/lang/String;)V
    //   388: aload_2
    //   389: dload_3
    //   390: invokevirtual 149	java/io/DataOutputStream:writeDouble	(D)V
    //   393: goto +275 -> 668
    //   396: aload 17
    //   398: invokevirtual 152	com/google/android/finsky/dn/a/n:c	()Z
    //   401: istore 10
    //   403: aload 14
    //   405: aload 17
    //   407: invokevirtual 117	com/google/android/finsky/dn/a/n:a	()Ljava/lang/String;
    //   410: iload 10
    //   412: invokestatic 157	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   415: invokeinterface 123 3 0
    //   420: pop
    //   421: aload_2
    //   422: bipush 8
    //   424: aload 17
    //   426: invokevirtual 117	com/google/android/finsky/dn/a/n:a	()Ljava/lang/String;
    //   429: invokestatic 126	com/google/android/finsky/dn/a/l:a	(Ljava/io/DataOutputStream;BLjava/lang/String;)V
    //   432: aload_2
    //   433: iload 10
    //   435: invokevirtual 161	java/io/DataOutputStream:writeBoolean	(Z)V
    //   438: goto +230 -> 668
    //   441: aload 17
    //   443: invokevirtual 164	com/google/android/finsky/dn/a/n:b	()J
    //   446: lstore 11
    //   448: lload 11
    //   450: ldc2_w 165
    //   453: lcmp
    //   454: ifge +101 -> 555
    //   457: goto +220 -> 677
    //   460: aload_2
    //   461: iconst_4
    //   462: aload 17
    //   464: invokevirtual 117	com/google/android/finsky/dn/a/n:a	()Ljava/lang/String;
    //   467: invokestatic 126	com/google/android/finsky/dn/a/l:a	(Ljava/io/DataOutputStream;BLjava/lang/String;)V
    //   470: aload_2
    //   471: lload 11
    //   473: invokevirtual 170	java/io/DataOutputStream:writeLong	(J)V
    //   476: aload 14
    //   478: aload 17
    //   480: invokevirtual 117	com/google/android/finsky/dn/a/n:a	()Ljava/lang/String;
    //   483: lload 11
    //   485: invokestatic 175	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   488: invokeinterface 123 3 0
    //   493: pop
    //   494: goto +174 -> 668
    //   497: lload 11
    //   499: l2i
    //   500: istore 9
    //   502: aload_2
    //   503: iconst_3
    //   504: aload 17
    //   506: invokevirtual 117	com/google/android/finsky/dn/a/n:a	()Ljava/lang/String;
    //   509: invokestatic 126	com/google/android/finsky/dn/a/l:a	(Ljava/io/DataOutputStream;BLjava/lang/String;)V
    //   512: aload_2
    //   513: iload 9
    //   515: invokevirtual 129	java/io/DataOutputStream:writeInt	(I)V
    //   518: goto -42 -> 476
    //   521: lload 11
    //   523: ldc2_w 176
    //   526: lcmp
    //   527: ifgt +159 -> 686
    //   530: lload 11
    //   532: l2i
    //   533: i2s
    //   534: istore 9
    //   536: aload_2
    //   537: iconst_2
    //   538: aload 17
    //   540: invokevirtual 117	com/google/android/finsky/dn/a/n:a	()Ljava/lang/String;
    //   543: invokestatic 126	com/google/android/finsky/dn/a/l:a	(Ljava/io/DataOutputStream;BLjava/lang/String;)V
    //   546: aload_2
    //   547: iload 9
    //   549: invokevirtual 180	java/io/DataOutputStream:writeShort	(I)V
    //   552: goto -76 -> 476
    //   555: lload 11
    //   557: ldc2_w 181
    //   560: lcmp
    //   561: ifgt +116 -> 677
    //   564: lload 11
    //   566: l2i
    //   567: i2b
    //   568: istore 9
    //   570: aload_2
    //   571: iconst_1
    //   572: aload 17
    //   574: invokevirtual 117	com/google/android/finsky/dn/a/n:a	()Ljava/lang/String;
    //   577: invokestatic 126	com/google/android/finsky/dn/a/l:a	(Ljava/io/DataOutputStream;BLjava/lang/String;)V
    //   580: aload_2
    //   581: iload 9
    //   583: invokevirtual 53	java/io/DataOutputStream:writeByte	(I)V
    //   586: goto -110 -> 476
    //   589: aload_2
    //   590: iconst_0
    //   591: invokevirtual 53	java/io/DataOutputStream:writeByte	(I)V
    //   594: ldc -72
    //   596: iconst_1
    //   597: anewarray 4	java/lang/Object
    //   600: dup
    //   601: iconst_0
    //   602: aload 13
    //   604: invokestatic 46	com/google/android/finsky/utils/FinskyLog:a	(Ljava/lang/String;)Ljava/lang/String;
    //   607: aastore
    //   608: invokestatic 49	com/google/android/finsky/utils/FinskyLog:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   611: new 186	com/google/android/finsky/dn/g
    //   614: dup
    //   615: aload 14
    //   617: aload_1
    //   618: aload_0
    //   619: invokeinterface 58 1 0
    //   624: aload_0
    //   625: invokeinterface 64 1 0
    //   630: invokespecial 189	com/google/android/finsky/dn/g:<init>	(Ljava/util/Map;Lcom/google/android/play/b/a/c;Ljava/lang/String;Ljava/lang/String;)V
    //   633: astore_0
    //   634: aload_2
    //   635: invokevirtual 107	java/io/DataOutputStream:close	()V
    //   638: aload_0
    //   639: areturn
    //   640: astore_2
    //   641: aload_0
    //   642: aload_2
    //   643: invokestatic 194	com/google/e/a/a/a/a/a:a	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   646: goto -415 -> 231
    //   649: iload 6
    //   651: iload 8
    //   653: if_icmplt -519 -> 134
    //   656: iload 5
    //   658: iconst_1
    //   659: iadd
    //   660: istore 5
    //   662: goto -558 -> 104
    //   665: goto -485 -> 180
    //   668: iload 6
    //   670: iconst_1
    //   671: iadd
    //   672: istore 6
    //   674: goto -25 -> 649
    //   677: lload 11
    //   679: ldc2_w 195
    //   682: lcmp
    //   683: ifge -162 -> 521
    //   686: lload 11
    //   688: ldc2_w 197
    //   691: lcmp
    //   692: iflt -232 -> 460
    //   695: lload 11
    //   697: ldc2_w 199
    //   700: lcmp
    //   701: ifle -204 -> 497
    //   704: goto -244 -> 460
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	707	0	paramh	h
    //   0	707	1	paramc	c
    //   0	707	2	paramFile	File
    //   359	31	3	d	double
    //   102	559	5	i	int
    //   129	544	6	j	int
    //   99	10	7	k	int
    //   126	528	8	m	int
    //   293	289	9	n	int
    //   401	33	10	bool	boolean
    //   446	250	11	l	long
    //   4	599	13	str	String
    //   36	580	14	localHashMap	java.util.HashMap
    //   94	18	15	arrayOfg	g[]
    //   121	14	16	arrayOfn	n[]
    //   139	434	17	localn	n
    //   262	85	18	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   29	101	223	finally
    //   111	128	223	finally
    //   141	180	223	finally
    //   180	223	223	finally
    //   257	310	223	finally
    //   313	351	223	finally
    //   354	393	223	finally
    //   396	438	223	finally
    //   441	448	223	finally
    //   460	476	223	finally
    //   476	494	223	finally
    //   502	518	223	finally
    //   536	552	223	finally
    //   570	586	223	finally
    //   589	634	223	finally
    //   224	226	226	finally
    //   6	29	233	java/io/IOException
    //   231	233	233	java/io/IOException
    //   634	638	233	java/io/IOException
    //   641	646	233	java/io/IOException
    //   227	231	640	finally
  }
  
  public static g a(h paramh, c paramc, File paramFile, String paramString)
  {
    File localFile = new File(paramFile, paramString);
    String str = String.valueOf("temp-");
    paramString = String.valueOf(paramString);
    if (paramString.length() == 0) {}
    for (paramString = new String(str);; paramString = str.concat(paramString))
    {
      paramFile = new File(paramFile, paramString);
      paramh = a(paramh, paramc, paramFile);
      if ((paramh != null) && (paramFile.renameTo(localFile))) {
        return paramh;
      }
      return null;
    }
  }
  
  private static void a(DataOutputStream paramDataOutputStream, byte paramByte, String paramString)
  {
    paramDataOutputStream.writeByte(paramByte);
    paramDataOutputStream.writeUTF(paramString);
  }
  
  static boolean a(File paramFile, String paramString)
  {
    paramFile = new File(paramFile, paramString);
    if (paramFile.exists())
    {
      boolean bool = paramFile.delete();
      if (bool)
      {
        FinskyLog.b("Successfully deleted experiment flags file %s.", new Object[] { FinskyLog.a(paramString) });
        return bool;
      }
      FinskyLog.d("Failed to delete experiment flags file %s.", new Object[] { FinskyLog.a(paramString) });
      return bool;
    }
    return true;
  }
  
  static String b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      String str = String.valueOf("experiment-flags-regular-");
      paramString = String.valueOf(Uri.encode(paramString));
      if (paramString.length() == 0) {
        return new String(str);
      }
      return str.concat(paramString);
    }
    return "experiment-flags-regular-null-account";
  }
  
  /* Error */
  final g a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 19	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: getfield 13	com/google/android/finsky/dn/a/l:a	Landroid/content/Context;
    //   10: invokevirtual 261	android/content/Context:getFilesDir	()Ljava/io/File;
    //   13: aload_1
    //   14: invokespecial 204	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   17: astore_3
    //   18: new 263	java/io/DataInputStream
    //   21: dup
    //   22: new 265	java/io/BufferedInputStream
    //   25: dup
    //   26: new 267	java/io/FileInputStream
    //   29: dup
    //   30: aload_3
    //   31: invokespecial 268	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   34: invokespecial 271	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   37: invokespecial 272	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   40: astore_3
    //   41: ldc_w 274
    //   44: iconst_1
    //   45: anewarray 4	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: aload_1
    //   51: invokestatic 46	com/google/android/finsky/utils/FinskyLog:a	(Ljava/lang/String;)Ljava/lang/String;
    //   54: aastore
    //   55: invokestatic 49	com/google/android/finsky/utils/FinskyLog:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   58: aload_3
    //   59: invokevirtual 278	java/io/DataInputStream:readByte	()B
    //   62: tableswitch	default:+439->501, 1:+36->98
    //   80: new 17	java/io/IOException
    //   83: dup
    //   84: ldc_w 280
    //   87: invokespecial 281	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   90: athrow
    //   91: astore_1
    //   92: aload_3
    //   93: invokestatic 285	com/google/common/io/i:a	(Ljava/io/InputStream;)V
    //   96: aconst_null
    //   97: areturn
    //   98: new 38	java/util/HashMap
    //   101: dup
    //   102: invokespecial 39	java/util/HashMap:<init>	()V
    //   105: astore 4
    //   107: aload_3
    //   108: invokevirtual 288	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   111: astore 5
    //   113: aload_3
    //   114: invokevirtual 288	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   117: astore 6
    //   119: new 290	com/google/android/play/b/a/c
    //   122: dup
    //   123: invokespecial 291	com/google/android/play/b/a/c:<init>	()V
    //   126: astore 7
    //   128: aload_3
    //   129: invokevirtual 288	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   132: aload 7
    //   134: invokestatic 294	com/google/android/finsky/utils/af:a	(Ljava/lang/String;Lcom/google/protobuf/nano/g;)Z
    //   137: pop
    //   138: iload_2
    //   139: ifeq +44 -> 183
    //   142: ldc_w 296
    //   145: iconst_1
    //   146: anewarray 4	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: aload_1
    //   152: invokestatic 46	com/google/android/finsky/utils/FinskyLog:a	(Ljava/lang/String;)Ljava/lang/String;
    //   155: aastore
    //   156: invokestatic 49	com/google/android/finsky/utils/FinskyLog:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   159: new 186	com/google/android/finsky/dn/g
    //   162: dup
    //   163: aload 4
    //   165: aload 7
    //   167: aload 5
    //   169: aload 6
    //   171: invokespecial 189	com/google/android/finsky/dn/g:<init>	(Ljava/util/Map;Lcom/google/android/play/b/a/c;Ljava/lang/String;Ljava/lang/String;)V
    //   174: astore 4
    //   176: aload_3
    //   177: invokestatic 285	com/google/common/io/i:a	(Ljava/io/InputStream;)V
    //   180: aload 4
    //   182: areturn
    //   183: aload_3
    //   184: invokevirtual 278	java/io/DataInputStream:readByte	()B
    //   187: tableswitch	default:+317->504, 0:+90->277, 1:+268->455, 2:+245->432, 3:+222->409, 4:+200->387, 5:+181->368, 6:+146->333, 7:+124->311, 8:+95->282
    //   236: new 17	java/io/IOException
    //   239: dup
    //   240: ldc_w 298
    //   243: invokespecial 281	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   246: athrow
    //   247: astore 4
    //   249: ldc_w 300
    //   252: iconst_2
    //   253: anewarray 4	java/lang/Object
    //   256: dup
    //   257: iconst_0
    //   258: aload_1
    //   259: invokestatic 46	com/google/android/finsky/utils/FinskyLog:a	(Ljava/lang/String;)Ljava/lang/String;
    //   262: aastore
    //   263: dup
    //   264: iconst_1
    //   265: aload 4
    //   267: aastore
    //   268: invokestatic 112	com/google/android/finsky/utils/FinskyLog:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: aload_3
    //   272: invokestatic 285	com/google/common/io/i:a	(Ljava/io/InputStream;)V
    //   275: aconst_null
    //   276: areturn
    //   277: iconst_1
    //   278: istore_2
    //   279: goto -141 -> 138
    //   282: aload 4
    //   284: aload_3
    //   285: invokevirtual 288	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   288: aload_3
    //   289: invokevirtual 303	java/io/DataInputStream:readBoolean	()Z
    //   292: invokestatic 157	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   295: invokeinterface 123 3 0
    //   300: pop
    //   301: goto -163 -> 138
    //   304: astore_1
    //   305: aload_3
    //   306: invokestatic 285	com/google/common/io/i:a	(Ljava/io/InputStream;)V
    //   309: aload_1
    //   310: athrow
    //   311: aload 4
    //   313: aload_3
    //   314: invokevirtual 288	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   317: aload_3
    //   318: invokevirtual 306	java/io/DataInputStream:readDouble	()D
    //   321: invokestatic 145	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   324: invokeinterface 123 3 0
    //   329: pop
    //   330: goto -192 -> 138
    //   333: aload_3
    //   334: invokevirtual 288	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   337: astore 8
    //   339: aload_3
    //   340: invokevirtual 309	java/io/DataInputStream:readInt	()I
    //   343: newarray <illegal type>
    //   345: astore 9
    //   347: aload_3
    //   348: aload 9
    //   350: invokevirtual 313	java/io/DataInputStream:readFully	([B)V
    //   353: aload 4
    //   355: aload 8
    //   357: aload 9
    //   359: invokeinterface 123 3 0
    //   364: pop
    //   365: goto -227 -> 138
    //   368: aload 4
    //   370: aload_3
    //   371: invokevirtual 288	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   374: aload_3
    //   375: invokevirtual 288	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   378: invokeinterface 123 3 0
    //   383: pop
    //   384: goto -246 -> 138
    //   387: aload 4
    //   389: aload_3
    //   390: invokevirtual 288	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   393: aload_3
    //   394: invokevirtual 316	java/io/DataInputStream:readLong	()J
    //   397: invokestatic 175	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   400: invokeinterface 123 3 0
    //   405: pop
    //   406: goto -268 -> 138
    //   409: aload 4
    //   411: aload_3
    //   412: invokevirtual 288	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   415: aload_3
    //   416: invokevirtual 309	java/io/DataInputStream:readInt	()I
    //   419: i2l
    //   420: invokestatic 175	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   423: invokeinterface 123 3 0
    //   428: pop
    //   429: goto -291 -> 138
    //   432: aload 4
    //   434: aload_3
    //   435: invokevirtual 288	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   438: aload_3
    //   439: invokevirtual 320	java/io/DataInputStream:readShort	()S
    //   442: i2l
    //   443: invokestatic 175	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   446: invokeinterface 123 3 0
    //   451: pop
    //   452: goto -314 -> 138
    //   455: aload 4
    //   457: aload_3
    //   458: invokevirtual 288	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   461: aload_3
    //   462: invokevirtual 278	java/io/DataInputStream:readByte	()B
    //   465: i2l
    //   466: invokestatic 175	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   469: invokeinterface 123 3 0
    //   474: pop
    //   475: goto -337 -> 138
    //   478: astore_1
    //   479: aconst_null
    //   480: astore_3
    //   481: goto -389 -> 92
    //   484: astore 4
    //   486: aconst_null
    //   487: astore_3
    //   488: goto -239 -> 249
    //   491: astore_1
    //   492: aconst_null
    //   493: astore_3
    //   494: goto -189 -> 305
    //   497: astore_1
    //   498: goto -193 -> 305
    //   501: goto -421 -> 80
    //   504: goto -268 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	507	0	this	l
    //   0	507	1	paramString	String
    //   1	278	2	i	int
    //   17	477	3	localObject1	Object
    //   105	76	4	localObject2	Object
    //   247	209	4	localIOException1	java.io.IOException
    //   484	1	4	localIOException2	java.io.IOException
    //   111	57	5	str1	String
    //   117	53	6	str2	String
    //   126	40	7	localc	c
    //   337	19	8	str3	String
    //   345	13	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   41	80	91	java/io/FileNotFoundException
    //   80	91	91	java/io/FileNotFoundException
    //   98	138	91	java/io/FileNotFoundException
    //   142	176	91	java/io/FileNotFoundException
    //   183	236	91	java/io/FileNotFoundException
    //   236	247	91	java/io/FileNotFoundException
    //   282	301	91	java/io/FileNotFoundException
    //   311	330	91	java/io/FileNotFoundException
    //   333	365	91	java/io/FileNotFoundException
    //   368	384	91	java/io/FileNotFoundException
    //   387	406	91	java/io/FileNotFoundException
    //   409	429	91	java/io/FileNotFoundException
    //   432	452	91	java/io/FileNotFoundException
    //   455	475	91	java/io/FileNotFoundException
    //   41	80	247	java/io/IOException
    //   80	91	247	java/io/IOException
    //   98	138	247	java/io/IOException
    //   142	176	247	java/io/IOException
    //   183	236	247	java/io/IOException
    //   236	247	247	java/io/IOException
    //   282	301	247	java/io/IOException
    //   311	330	247	java/io/IOException
    //   333	365	247	java/io/IOException
    //   368	384	247	java/io/IOException
    //   387	406	247	java/io/IOException
    //   409	429	247	java/io/IOException
    //   432	452	247	java/io/IOException
    //   455	475	247	java/io/IOException
    //   41	80	304	finally
    //   80	91	304	finally
    //   98	138	304	finally
    //   142	176	304	finally
    //   183	236	304	finally
    //   236	247	304	finally
    //   282	301	304	finally
    //   311	330	304	finally
    //   333	365	304	finally
    //   368	384	304	finally
    //   387	406	304	finally
    //   409	429	304	finally
    //   432	452	304	finally
    //   455	475	304	finally
    //   18	41	478	java/io/FileNotFoundException
    //   18	41	484	java/io/IOException
    //   18	41	491	finally
    //   249	271	497	finally
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dn/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */