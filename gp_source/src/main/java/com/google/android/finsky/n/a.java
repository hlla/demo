package com.google.android.finsky.n;

import android.content.Context;
import android.os.Handler;
import com.google.android.finsky.packagemanager.h;
import com.google.android.finsky.utils.FinskyLog;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
  implements h
{
  private static final Pattern a = Pattern.compile("^main\\.(\\d+)\\.([\\w\\.]+)$");
  private static final Pattern b = Pattern.compile("^patch\\.(\\d+)\\.([\\w\\.]+)$");
  private final Context c;
  private final c d;
  private final Handler e;
  private final com.google.android.finsky.ba.a f;
  private final com.google.android.finsky.dh.a g;
  
  public a(Context paramContext, com.google.android.finsky.dh.a parama, com.google.android.finsky.ba.a parama1, c paramc, Handler paramHandler)
  {
    this.c = paramContext;
    this.g = parama;
    this.f = parama1;
    this.d = paramc;
    this.e = paramHandler;
  }
  
  private static int a(File paramFile, Pattern paramPattern)
  {
    paramPattern = paramPattern.matcher(paramFile.getName());
    if (paramPattern.matches()) {
      try
      {
        int i = Integer.parseInt(paramPattern.group(1));
        return i;
      }
      catch (NumberFormatException paramPattern) {}
    }
    FinskyLog.d("Unable to parse version code from OBB file %s", new Object[] { paramFile.getName() });
    return -1;
  }
  
  /* Error */
  private final boolean a(File paramFile, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +21 -> 22
    //   4: ldc 102
    //   6: iconst_1
    //   7: anewarray 4	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: aload_1
    //   13: invokevirtual 59	java/io/File:getName	()Ljava/lang/String;
    //   16: aastore
    //   17: invokestatic 104	com/google/android/finsky/utils/FinskyLog:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: iconst_0
    //   21: ireturn
    //   22: aload_0
    //   23: getfield 42	com/google/android/finsky/n/a:c	Landroid/content/Context;
    //   26: invokevirtual 110	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   29: aload_2
    //   30: invokevirtual 116	android/content/ContentResolver:openOutputStream	(Landroid/net/Uri;)Ljava/io/OutputStream;
    //   33: astore_2
    //   34: new 118	java/io/FileInputStream
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 121	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   42: astore 4
    //   44: aload 4
    //   46: aload_2
    //   47: invokestatic 126	com/google/common/io/f:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   50: pop2
    //   51: aload 4
    //   53: invokevirtual 127	java/io/FileInputStream:close	()V
    //   56: aload_2
    //   57: ifnull +8 -> 65
    //   60: aconst_null
    //   61: aload_2
    //   62: invokestatic 129	com/google/android/finsky/n/a:a	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   65: iconst_1
    //   66: ireturn
    //   67: astore_1
    //   68: aload_1
    //   69: ldc -125
    //   71: iconst_0
    //   72: anewarray 4	java/lang/Object
    //   75: invokestatic 134	com/google/android/finsky/utils/FinskyLog:a	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   78: iconst_0
    //   79: ireturn
    //   80: astore_1
    //   81: aload_1
    //   82: athrow
    //   83: astore_3
    //   84: aload_2
    //   85: ifnull +8 -> 93
    //   88: aload_1
    //   89: aload_2
    //   90: invokestatic 129	com/google/android/finsky/n/a:a	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   93: aload_3
    //   94: athrow
    //   95: astore_1
    //   96: aload_1
    //   97: athrow
    //   98: astore_3
    //   99: aload 4
    //   101: invokevirtual 137	java/io/InputStream:close	()V
    //   104: aload_3
    //   105: athrow
    //   106: astore 4
    //   108: aload_1
    //   109: aload 4
    //   111: invokestatic 97	com/google/e/a/a/a/a/a:a	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   114: goto -10 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	a
    //   0	117	1	paramFile	File
    //   0	117	2	paramUri	android.net.Uri
    //   83	11	3	localObject1	Object
    //   98	7	3	localObject2	Object
    //   42	58	4	localFileInputStream	java.io.FileInputStream
    //   106	4	4	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   22	34	67	java/io/IOException
    //   60	65	67	java/io/IOException
    //   88	93	67	java/io/IOException
    //   93	95	67	java/io/IOException
    //   34	44	80	finally
    //   51	56	80	finally
    //   104	106	80	finally
    //   108	114	80	finally
    //   81	83	83	finally
    //   44	51	95	finally
    //   96	98	98	finally
    //   99	104	106	finally
  }
  
  private final void d(String paramString)
  {
    this.e.post(new b(this, paramString));
  }
  
  /* Error */
  final void a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc -103
    //   6: iconst_1
    //   7: anewarray 4	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: aload_1
    //   13: aastore
    //   14: invokestatic 104	com/google/android/finsky/utils/FinskyLog:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   17: aload_0
    //   18: getfield 46	com/google/android/finsky/n/a:f	Lcom/google/android/finsky/ba/a;
    //   21: getfield 158	com/google/android/finsky/ba/a:d	Z
    //   24: ifeq +43 -> 67
    //   27: aload_0
    //   28: getfield 48	com/google/android/finsky/n/a:d	Lcom/google/android/finsky/n/c;
    //   31: invokevirtual 162	com/google/android/finsky/n/c:a	()Z
    //   34: ifeq +33 -> 67
    //   37: aload_0
    //   38: getfield 44	com/google/android/finsky/n/a:g	Lcom/google/android/finsky/dh/a;
    //   41: aload_1
    //   42: invokeinterface 167 2 0
    //   47: astore 5
    //   49: aload 5
    //   51: ifnonnull +19 -> 70
    //   54: ldc -87
    //   56: iconst_1
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: aload_1
    //   63: aastore
    //   64: invokestatic 86	com/google/android/finsky/utils/FinskyLog:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   67: aload_0
    //   68: monitorexit
    //   69: return
    //   70: aload_0
    //   71: getfield 42	com/google/android/finsky/n/a:c	Landroid/content/Context;
    //   74: invokevirtual 173	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   77: astore 4
    //   79: aload 4
    //   81: aload_1
    //   82: iconst_0
    //   83: invokevirtual 179	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   86: astore 6
    //   88: aload 6
    //   90: getfield 185	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   93: astore 4
    //   95: aload 6
    //   97: getfield 188	android/content/pm/ApplicationInfo:publicSourceDir	Ljava/lang/String;
    //   100: astore 6
    //   102: aload 4
    //   104: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   107: ifne +13 -> 120
    //   110: aload 4
    //   112: aload 6
    //   114: invokevirtual 200	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   117: ifne +24 -> 141
    //   120: ldc -54
    //   122: iconst_1
    //   123: anewarray 4	java/lang/Object
    //   126: dup
    //   127: iconst_0
    //   128: aload_1
    //   129: aastore
    //   130: invokestatic 86	com/google/android/finsky/utils/FinskyLog:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: goto -66 -> 67
    //   136: astore_1
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_1
    //   140: athrow
    //   141: new 55	java/io/File
    //   144: dup
    //   145: aload 4
    //   147: invokespecial 204	java/io/File:<init>	(Ljava/lang/String;)V
    //   150: astore 6
    //   152: new 206	android/content/ContentValues
    //   155: dup
    //   156: invokespecial 207	android/content/ContentValues:<init>	()V
    //   159: astore 7
    //   161: aload 7
    //   163: ldc -47
    //   165: aload_1
    //   166: invokevirtual 213	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload_1
    //   170: invokestatic 217	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   173: astore 4
    //   175: ldc -37
    //   177: invokestatic 217	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   180: astore 8
    //   182: aload 8
    //   184: invokevirtual 223	java/lang/String:length	()I
    //   187: ifne +348 -> 535
    //   190: new 196	java/lang/String
    //   193: dup
    //   194: aload 4
    //   196: invokespecial 224	java/lang/String:<init>	(Ljava/lang/String;)V
    //   199: astore 4
    //   201: aload 7
    //   203: ldc -30
    //   205: aload 4
    //   207: invokevirtual 213	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: aload 7
    //   212: ldc -29
    //   214: aload 6
    //   216: invokevirtual 230	java/io/File:length	()J
    //   219: invokestatic 235	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   222: invokevirtual 238	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   225: aload 7
    //   227: ldc -16
    //   229: iconst_0
    //   230: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   233: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   236: aload 7
    //   238: ldc -8
    //   240: aload 5
    //   242: getfield 253	com/google/android/finsky/dh/b:f	I
    //   245: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   248: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   251: aload_0
    //   252: aload 6
    //   254: aload_0
    //   255: getfield 42	com/google/android/finsky/n/a:c	Landroid/content/Context;
    //   258: invokevirtual 110	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   261: getstatic 256	com/google/android/finsky/n/c:a	Landroid/net/Uri;
    //   264: aload 7
    //   266: invokevirtual 260	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   269: invokespecial 262	com/google/android/finsky/n/a:a	(Ljava/io/File;Landroid/net/Uri;)Z
    //   272: ifeq -205 -> 67
    //   275: new 55	java/io/File
    //   278: dup
    //   279: new 55	java/io/File
    //   282: dup
    //   283: new 55	java/io/File
    //   286: dup
    //   287: invokestatic 268	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   290: ldc_w 270
    //   293: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   296: ldc_w 275
    //   299: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   302: aload_1
    //   303: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   306: invokevirtual 279	java/io/File:listFiles	()[Ljava/io/File;
    //   309: astore 4
    //   311: aload 4
    //   313: ifnull -246 -> 67
    //   316: aload 4
    //   318: arraylength
    //   319: istore_3
    //   320: iload_3
    //   321: iconst_2
    //   322: if_icmpgt -255 -> 67
    //   325: iload_2
    //   326: iload_3
    //   327: if_icmpge -260 -> 67
    //   330: aload 4
    //   332: iload_2
    //   333: aaload
    //   334: astore 5
    //   336: new 206	android/content/ContentValues
    //   339: dup
    //   340: invokespecial 207	android/content/ContentValues:<init>	()V
    //   343: astore 6
    //   345: aload 6
    //   347: ldc -30
    //   349: aload 5
    //   351: invokevirtual 59	java/io/File:getName	()Ljava/lang/String;
    //   354: invokevirtual 213	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   357: aload 6
    //   359: ldc -47
    //   361: aload_1
    //   362: invokevirtual 213	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   365: aload 6
    //   367: ldc -29
    //   369: aload 5
    //   371: invokevirtual 230	java/io/File:length	()J
    //   374: invokestatic 235	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   377: invokevirtual 238	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   380: aload 5
    //   382: invokevirtual 59	java/io/File:getName	()Ljava/lang/String;
    //   385: ldc_w 281
    //   388: invokevirtual 285	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   391: ifeq +71 -> 462
    //   394: aload 5
    //   396: invokevirtual 59	java/io/File:getName	()Ljava/lang/String;
    //   399: ldc_w 287
    //   402: invokevirtual 290	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   405: ifeq +57 -> 462
    //   408: aload 6
    //   410: ldc -16
    //   412: iconst_1
    //   413: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   416: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   419: aload 6
    //   421: ldc -8
    //   423: aload 5
    //   425: getstatic 35	com/google/android/finsky/n/a:a	Ljava/util/regex/Pattern;
    //   428: invokestatic 292	com/google/android/finsky/n/a:a	(Ljava/io/File;Ljava/util/regex/Pattern;)I
    //   431: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   434: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   437: aload_0
    //   438: aload 5
    //   440: aload_0
    //   441: getfield 42	com/google/android/finsky/n/a:c	Landroid/content/Context;
    //   444: invokevirtual 110	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   447: getstatic 256	com/google/android/finsky/n/c:a	Landroid/net/Uri;
    //   450: aload 6
    //   452: invokevirtual 260	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   455: invokespecial 262	com/google/android/finsky/n/a:a	(Ljava/io/File;Landroid/net/Uri;)Z
    //   458: pop
    //   459: goto +108 -> 567
    //   462: aload 5
    //   464: invokevirtual 59	java/io/File:getName	()Ljava/lang/String;
    //   467: ldc_w 294
    //   470: invokevirtual 285	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   473: ifeq +49 -> 522
    //   476: aload 5
    //   478: invokevirtual 59	java/io/File:getName	()Ljava/lang/String;
    //   481: ldc_w 287
    //   484: invokevirtual 290	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   487: ifeq +35 -> 522
    //   490: aload 6
    //   492: ldc -16
    //   494: iconst_2
    //   495: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   498: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   501: aload 6
    //   503: ldc -8
    //   505: aload 5
    //   507: getstatic 31	com/google/android/finsky/n/a:b	Ljava/util/regex/Pattern;
    //   510: invokestatic 292	com/google/android/finsky/n/a:a	(Ljava/io/File;Ljava/util/regex/Pattern;)I
    //   513: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   516: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   519: goto -82 -> 437
    //   522: ldc_w 296
    //   525: iconst_0
    //   526: anewarray 4	java/lang/Object
    //   529: invokestatic 86	com/google/android/finsky/utils/FinskyLog:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   532: goto +35 -> 567
    //   535: aload 4
    //   537: aload 8
    //   539: invokevirtual 300	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   542: astore 4
    //   544: goto -343 -> 201
    //   547: astore 4
    //   549: aload 4
    //   551: ldc -87
    //   553: iconst_1
    //   554: anewarray 4	java/lang/Object
    //   557: dup
    //   558: iconst_0
    //   559: aload_1
    //   560: aastore
    //   561: invokestatic 134	com/google/android/finsky/utils/FinskyLog:a	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   564: goto -497 -> 67
    //   567: iload_2
    //   568: iconst_1
    //   569: iadd
    //   570: istore_2
    //   571: goto -246 -> 325
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	574	0	this	a
    //   0	574	1	paramString	String
    //   1	570	2	i	int
    //   319	9	3	j	int
    //   77	466	4	localObject1	Object
    //   547	3	4	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   47	459	5	localb	com.google.android.finsky.dh.b
    //   86	416	6	localObject2	Object
    //   159	106	7	localContentValues	android.content.ContentValues
    //   180	358	8	str	String
    // Exception table:
    //   from	to	target	type
    //   4	49	136	finally
    //   54	67	136	finally
    //   70	79	136	finally
    //   79	88	136	finally
    //   88	120	136	finally
    //   120	133	136	finally
    //   141	201	136	finally
    //   201	311	136	finally
    //   316	320	136	finally
    //   336	437	136	finally
    //   437	459	136	finally
    //   462	519	136	finally
    //   522	532	136	finally
    //   535	544	136	finally
    //   549	564	136	finally
    //   79	88	547	android/content/pm/PackageManager$NameNotFoundException
  }
  
  public final void a(String[] paramArrayOfString) {}
  
  public final void b(String paramString)
  {
    d(paramString);
  }
  
  public final void b(String paramString, boolean paramBoolean)
  {
    d(paramString);
  }
  
  public final void c(String paramString) {}
  
  public final void c(String paramString, boolean paramBoolean) {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/n/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */