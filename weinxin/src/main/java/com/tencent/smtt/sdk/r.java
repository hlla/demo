package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.c;
import com.tencent.smtt.utils.g;
import com.tencent.smtt.utils.g.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;

class r
{
  private static r wTo;
  Context mContext;
  private Handler wTp = null;
  boolean wTq = false;
  
  private r(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    paramContext = new HandlerThread("TbsLogReportThread");
    paramContext.start();
    this.wTp = new Handler(paramContext.getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        if (paramAnonymousMessage.what == 600) {
          if ((paramAnonymousMessage.obj instanceof r.b))
          {
            localObject2 = (r.b)paramAnonymousMessage.obj;
            j = paramAnonymousMessage.arg1;
            localr = r.this;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(r.CW(j));
            localStringBuilder.append(r.Vq(c.V(localr.mContext)));
            localStringBuilder.append(r.Vq(com.tencent.smtt.utils.p.gW(localr.mContext)));
            localStringBuilder.append(r.CW(p.ceq().ge(localr.mContext)));
            paramAnonymousMessage = Build.MODEL;
            try
            {
              localObject1 = new String(paramAnonymousMessage.getBytes("UTF-8"), "ISO8859-1");
              paramAnonymousMessage = (Message)localObject1;
            }
            catch (Exception localException)
            {
              try
              {
                for (;;)
                {
                  ((JSONArray)localObject2).put(((JSONArray)localObject1).get(((JSONArray)localObject2).length() - i));
                  i -= 1;
                  continue;
                  localException = localException;
                }
                localStringBuilder.append(r.CW(c.getAppVersionCode(localr.mContext)));
              }
              catch (Exception paramAnonymousMessage)
              {
                for (;;)
                {
                  TbsLog.e("upload", "JSONArray transform error!");
                }
              }
              paramAnonymousMessage = localException;
              paramAnonymousMessage.put(localStringBuilder.toString());
              localEditor = localSharedPreferences.edit();
              localEditor.putString("tbs_download_upload", paramAnonymousMessage.toString());
              localEditor.commit();
              if ((!localr.wTq) && (j == r.a.wTu.value)) {
                break label667;
              }
              localr.cex();
            }
            localStringBuilder.append(r.Vq(paramAnonymousMessage));
            paramAnonymousMessage = localr.mContext.getPackageName();
            localStringBuilder.append(r.Vq(paramAnonymousMessage));
            if ("com.tencent.mm".equals(paramAnonymousMessage))
            {
              localStringBuilder.append(r.Vq(c.bC(localr.mContext, "com.tencent.mm.BuildInfo.CLIENT_VERSION")));
              localStringBuilder.append(r.Vq(r.aq(((r.b)localObject2).wTz)));
              localStringBuilder.append(r.Vq(((r.b)localObject2).wTA));
              localStringBuilder.append(r.Vq(((r.b)localObject2).wTB));
              localStringBuilder.append(r.CW(((r.b)localObject2).wTC));
              localStringBuilder.append(r.CW(((r.b)localObject2).wTD));
              localStringBuilder.append(r.CW(((r.b)localObject2).wTE));
              localStringBuilder.append(r.CW(((r.b)localObject2).wTF));
              localStringBuilder.append(r.Vq(((r.b)localObject2).wTG));
              localStringBuilder.append(r.CW(((r.b)localObject2).wTH));
              localStringBuilder.append(r.CW(((r.b)localObject2).wTI));
              localStringBuilder.append(r.fa(((r.b)localObject2).wTO));
              localStringBuilder.append(r.fa(((r.b)localObject2).wTJ));
              localStringBuilder.append(r.fa(((r.b)localObject2).wTK));
              localStringBuilder.append(r.CW(((r.b)localObject2).wTL));
              localStringBuilder.append(r.CW(((r.b)localObject2).jTc));
              localStringBuilder.append(r.Vq(((r.b)localObject2).wTM));
              localStringBuilder.append(r.Vq(((r.b)localObject2).wTN));
              localStringBuilder.append(r.CW(k.fM(localr.mContext).wSA.getInt("tbs_download_version", 0)));
              localStringBuilder.append(r.Vq(c.gR(localr.mContext)));
              localStringBuilder.append(r.Vq("3.5.0.1016_43501"));
              localStringBuilder.append(false);
              localSharedPreferences = localr.cey();
              localObject1 = localr.cev();
              localObject2 = new JSONArray();
              if (((JSONArray)localObject2).length() < 5) {
                break label600;
              }
              i = 4;
              paramAnonymousMessage = (Message)localObject2;
              if (i <= 0) {
                break label603;
              }
            }
          }
        }
        label600:
        label603:
        label667:
        while (paramAnonymousMessage.what != 601)
        {
          Object localObject2;
          int j;
          r localr;
          StringBuilder localStringBuilder;
          Object localObject1;
          SharedPreferences localSharedPreferences;
          int i;
          SharedPreferences.Editor localEditor;
          return;
        }
        r.this.cex();
      }
    };
  }
  
  static String CW(int paramInt)
  {
    return paramInt + "|";
  }
  
  static String Vq(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str + "|";
  }
  
  private void a(int paramInt, b paramb, a parama)
  {
    paramb.setErrorCode(paramInt);
    paramb.wTz = System.currentTimeMillis();
    QbSdk.wRt.is(paramInt);
    a(parama, paramb);
  }
  
  static String aq(long paramLong)
  {
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(paramLong));
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static b cet()
  {
    return new b();
  }
  
  static String fa(long paramLong)
  {
    return paramLong + "|";
  }
  
  public static r gr(Context paramContext)
  {
    if (wTo == null) {}
    try
    {
      if (wTo == null) {
        wTo = new r(paramContext);
      }
      return wTo;
    }
    finally {}
  }
  
  public final void a(int paramInt, String paramString, a parama)
  {
    if ((paramInt != 200) && (paramInt != 220) && (paramInt != 221)) {
      TbsLog.i("TbsDownload", "error occured in installation, errorCode:" + paramInt, true);
    }
    b localb = new b();
    localb.Vs(paramString);
    a(paramInt, localb, parama);
  }
  
  public final void a(a parama, b paramb)
  {
    try
    {
      paramb = (b)paramb.clone();
      Message localMessage = this.wTp.obtainMessage();
      localMessage.what = 600;
      localMessage.arg1 = parama.value;
      localMessage.obj = paramb;
      this.wTp.sendMessage(localMessage);
      return;
    }
    catch (Throwable parama)
    {
      TbsLog.w("upload", "[TbsLogReport.eventReport] error, message=" + parama.getMessage());
    }
  }
  
  public final void aL(int paramInt, String paramString)
  {
    a(paramInt, paramString, a.wTt);
  }
  
  public final void aM(int paramInt, String paramString)
  {
    b localb = new b();
    localb.setErrorCode(paramInt);
    localb.wTz = System.currentTimeMillis();
    localb.Vs(paramString);
    a(a.wTu, localb);
  }
  
  public final void c(int paramInt, Throwable paramThrowable)
  {
    b localb = new b();
    localb.k(paramThrowable);
    a(paramInt, localb, a.wTt);
  }
  
  public final void ceu()
  {
    this.wTp.sendEmptyMessage(601);
  }
  
  final JSONArray cev()
  {
    Object localObject = cey().getString("tbs_download_upload", null);
    if (localObject == null) {
      localObject = new JSONArray();
    }
    for (;;)
    {
      return (JSONArray)localObject;
      try
      {
        JSONArray localJSONArray1 = new JSONArray((String)localObject);
        localObject = localJSONArray1;
        if (localJSONArray1.length() > 5)
        {
          JSONArray localJSONArray2 = new JSONArray();
          int i = localJSONArray1.length() - 1;
          localObject = localJSONArray1;
          if (i > localJSONArray1.length() - 5)
          {
            localJSONArray2.put(localJSONArray1.get(i));
            return localJSONArray2;
          }
        }
      }
      catch (Exception localException) {}
    }
    return new JSONArray();
  }
  
  /* Error */
  public final void cew()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: getfield 44	com/tencent/smtt/sdk/r:mContext	Landroid/content/Context;
    //   7: invokestatic 271	com/tencent/smtt/utils/b:gN	(Landroid/content/Context;)I
    //   10: iconst_3
    //   11: if_icmpeq +4 -> 15
    //   14: return
    //   15: invokestatic 274	com/tencent/smtt/utils/TbsLog:getTbsLogFilePath	()Ljava/lang/String;
    //   18: astore 9
    //   20: aload 9
    //   22: ifnull -8 -> 14
    //   25: invokestatic 280	com/tencent/smtt/utils/j:cfd	()Lcom/tencent/smtt/utils/j;
    //   28: pop
    //   29: invokestatic 283	com/tencent/smtt/utils/j:cfe	()Ljava/lang/String;
    //   32: astore 7
    //   34: aload_0
    //   35: getfield 44	com/tencent/smtt/sdk/r:mContext	Landroid/content/Context;
    //   38: invokestatic 289	com/tencent/smtt/utils/c:V	(Landroid/content/Context;)Ljava/lang/String;
    //   41: astore_3
    //   42: aload_0
    //   43: getfield 44	com/tencent/smtt/sdk/r:mContext	Landroid/content/Context;
    //   46: invokestatic 292	com/tencent/smtt/utils/c:gR	(Landroid/content/Context;)Ljava/lang/String;
    //   49: astore_2
    //   50: aload_3
    //   51: invokevirtual 298	java/lang/String:getBytes	()[B
    //   54: astore_3
    //   55: aload_2
    //   56: invokevirtual 298	java/lang/String:getBytes	()[B
    //   59: astore 4
    //   61: aload_3
    //   62: astore_2
    //   63: invokestatic 280	com/tencent/smtt/utils/j:cfd	()Lcom/tencent/smtt/utils/j;
    //   66: aload_3
    //   67: invokevirtual 302	com/tencent/smtt/utils/j:bA	([B)[B
    //   70: astore_3
    //   71: aload_3
    //   72: astore_2
    //   73: invokestatic 280	com/tencent/smtt/utils/j:cfd	()Lcom/tencent/smtt/utils/j;
    //   76: aload 4
    //   78: invokevirtual 302	com/tencent/smtt/utils/j:bA	([B)[B
    //   81: astore 6
    //   83: aload 6
    //   85: astore_2
    //   86: aload_3
    //   87: astore 4
    //   89: aload_2
    //   90: astore_3
    //   91: aload 4
    //   93: invokestatic 306	com/tencent/smtt/utils/j:bytesToHex	([B)Ljava/lang/String;
    //   96: astore_2
    //   97: aload_3
    //   98: invokestatic 306	com/tencent/smtt/utils/j:bytesToHex	([B)Ljava/lang/String;
    //   101: astore_3
    //   102: new 66	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   109: aload_0
    //   110: getfield 44	com/tencent/smtt/sdk/r:mContext	Landroid/content/Context;
    //   113: invokestatic 312	com/tencent/smtt/utils/q:gZ	(Landroid/content/Context;)Lcom/tencent/smtt/utils/q;
    //   116: getfield 316	com/tencent/smtt/utils/q:wWt	Ljava/lang/String;
    //   119: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_2
    //   123: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: ldc_w 318
    //   129: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_3
    //   133: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: astore 8
    //   141: new 320	java/util/HashMap
    //   144: dup
    //   145: invokespecial 321	java/util/HashMap:<init>	()V
    //   148: astore 6
    //   150: aload 6
    //   152: ldc_w 323
    //   155: ldc_w 325
    //   158: invokeinterface 330 3 0
    //   163: pop
    //   164: aload 6
    //   166: ldc_w 332
    //   169: ldc_w 334
    //   172: invokeinterface 330 3 0
    //   177: pop
    //   178: aload 6
    //   180: ldc_w 336
    //   183: aload_0
    //   184: getfield 44	com/tencent/smtt/sdk/r:mContext	Landroid/content/Context;
    //   187: invokestatic 341	com/tencent/smtt/utils/p:gW	(Landroid/content/Context;)Ljava/lang/String;
    //   190: invokeinterface 330 3 0
    //   195: pop
    //   196: new 343	java/io/File
    //   199: dup
    //   200: getstatic 348	com/tencent/smtt/utils/f:wVK	Ljava/lang/String;
    //   203: invokespecial 349	java/io/File:<init>	(Ljava/lang/String;)V
    //   206: pop
    //   207: new 18	com/tencent/smtt/sdk/r$c
    //   210: dup
    //   211: aload 9
    //   213: new 66	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   220: getstatic 348	com/tencent/smtt/utils/f:wVK	Ljava/lang/String;
    //   223: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: ldc_w 351
    //   229: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokespecial 353	com/tencent/smtt/sdk/r$c:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: invokevirtual 356	com/tencent/smtt/sdk/r$c:cez	()V
    //   241: new 343	java/io/File
    //   244: dup
    //   245: getstatic 348	com/tencent/smtt/utils/f:wVK	Ljava/lang/String;
    //   248: ldc_w 358
    //   251: invokespecial 359	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   254: astore_2
    //   255: new 361	java/io/FileInputStream
    //   258: dup
    //   259: aload_2
    //   260: invokespecial 364	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   263: astore 4
    //   265: sipush 8192
    //   268: newarray <illegal type>
    //   270: astore 9
    //   272: new 366	java/io/ByteArrayOutputStream
    //   275: dup
    //   276: invokespecial 367	java/io/ByteArrayOutputStream:<init>	()V
    //   279: astore_3
    //   280: aload 4
    //   282: aload 9
    //   284: invokevirtual 371	java/io/FileInputStream:read	([B)I
    //   287: istore_1
    //   288: iload_1
    //   289: iconst_m1
    //   290: if_icmpeq +123 -> 413
    //   293: aload_3
    //   294: aload 9
    //   296: iconst_0
    //   297: iload_1
    //   298: invokevirtual 375	java/io/ByteArrayOutputStream:write	([BII)V
    //   301: goto -21 -> 280
    //   304: astore 5
    //   306: aload_3
    //   307: astore 5
    //   309: aload_2
    //   310: astore_3
    //   311: aload 5
    //   313: astore_2
    //   314: aload 4
    //   316: ifnull +8 -> 324
    //   319: aload 4
    //   321: invokevirtual 378	java/io/FileInputStream:close	()V
    //   324: aload_2
    //   325: ifnull +7 -> 332
    //   328: aload_2
    //   329: invokevirtual 379	java/io/ByteArrayOutputStream:close	()V
    //   332: aload_3
    //   333: ifnull +251 -> 584
    //   336: aload_3
    //   337: invokevirtual 383	java/io/File:delete	()Z
    //   340: pop
    //   341: aconst_null
    //   342: astore_2
    //   343: new 66	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   350: aload 8
    //   352: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: ldc_w 385
    //   358: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: aload 7
    //   363: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: astore 4
    //   371: new 8	com/tencent/smtt/sdk/r$2
    //   374: dup
    //   375: aload_0
    //   376: invokespecial 388	com/tencent/smtt/sdk/r$2:<init>	(Lcom/tencent/smtt/sdk/r;)V
    //   379: astore_3
    //   380: aload_2
    //   381: ifnull -367 -> 14
    //   384: aload 4
    //   386: aload 6
    //   388: invokestatic 394	com/tencent/smtt/utils/g:p	(Ljava/lang/String;Ljava/util/Map;)Ljava/net/HttpURLConnection;
    //   391: astore 4
    //   393: aload 4
    //   395: ifnull -381 -> 14
    //   398: aload 4
    //   400: aload_2
    //   401: invokestatic 397	com/tencent/smtt/utils/g:a	(Ljava/net/HttpURLConnection;[B)V
    //   404: aload 4
    //   406: aload_3
    //   407: iconst_0
    //   408: invokestatic 400	com/tencent/smtt/utils/g:a	(Ljava/net/HttpURLConnection;Lcom/tencent/smtt/utils/g$a;Z)Ljava/lang/String;
    //   411: pop
    //   412: return
    //   413: aload_3
    //   414: invokevirtual 403	java/io/ByteArrayOutputStream:flush	()V
    //   417: invokestatic 280	com/tencent/smtt/utils/j:cfd	()Lcom/tencent/smtt/utils/j;
    //   420: aload_3
    //   421: invokevirtual 406	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   424: invokevirtual 302	com/tencent/smtt/utils/j:bA	([B)[B
    //   427: astore 5
    //   429: aload 4
    //   431: invokevirtual 378	java/io/FileInputStream:close	()V
    //   434: aload_3
    //   435: invokevirtual 379	java/io/ByteArrayOutputStream:close	()V
    //   438: aload_2
    //   439: invokevirtual 383	java/io/File:delete	()Z
    //   442: pop
    //   443: aload 5
    //   445: astore_2
    //   446: goto -103 -> 343
    //   449: astore_3
    //   450: aconst_null
    //   451: astore_2
    //   452: aconst_null
    //   453: astore 4
    //   455: aload 4
    //   457: ifnull +8 -> 465
    //   460: aload 4
    //   462: invokevirtual 378	java/io/FileInputStream:close	()V
    //   465: aload 5
    //   467: ifnull +8 -> 475
    //   470: aload 5
    //   472: invokevirtual 379	java/io/ByteArrayOutputStream:close	()V
    //   475: aload_2
    //   476: ifnull +8 -> 484
    //   479: aload_2
    //   480: invokevirtual 383	java/io/File:delete	()Z
    //   483: pop
    //   484: aload_3
    //   485: athrow
    //   486: astore 4
    //   488: goto -54 -> 434
    //   491: astore_3
    //   492: goto -54 -> 438
    //   495: astore 4
    //   497: goto -173 -> 324
    //   500: astore_2
    //   501: goto -169 -> 332
    //   504: astore 4
    //   506: goto -41 -> 465
    //   509: astore 4
    //   511: goto -36 -> 475
    //   514: astore_3
    //   515: aconst_null
    //   516: astore 4
    //   518: goto -63 -> 455
    //   521: astore_3
    //   522: goto -67 -> 455
    //   525: astore 6
    //   527: aload_3
    //   528: astore 5
    //   530: aload 6
    //   532: astore_3
    //   533: goto -78 -> 455
    //   536: astore_2
    //   537: aconst_null
    //   538: astore_2
    //   539: aconst_null
    //   540: astore_3
    //   541: aconst_null
    //   542: astore 4
    //   544: goto -230 -> 314
    //   547: astore_3
    //   548: aconst_null
    //   549: astore 5
    //   551: aload_2
    //   552: astore_3
    //   553: aconst_null
    //   554: astore 4
    //   556: aload 5
    //   558: astore_2
    //   559: goto -245 -> 314
    //   562: astore_3
    //   563: aconst_null
    //   564: astore 5
    //   566: aload_2
    //   567: astore_3
    //   568: aload 5
    //   570: astore_2
    //   571: goto -257 -> 314
    //   574: astore_3
    //   575: aload 4
    //   577: astore_3
    //   578: aload_2
    //   579: astore 4
    //   581: goto -490 -> 91
    //   584: aconst_null
    //   585: astore_2
    //   586: goto -243 -> 343
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	589	0	this	r
    //   287	11	1	i	int
    //   49	431	2	localObject1	Object
    //   500	1	2	localException1	Exception
    //   536	1	2	localException2	Exception
    //   538	48	2	localObject2	Object
    //   41	394	3	localObject3	Object
    //   449	36	3	localObject4	Object
    //   491	1	3	localException3	Exception
    //   514	1	3	localObject5	Object
    //   521	7	3	localObject6	Object
    //   532	9	3	localObject7	Object
    //   547	1	3	localException4	Exception
    //   552	1	3	localObject8	Object
    //   562	1	3	localException5	Exception
    //   567	1	3	localObject9	Object
    //   574	1	3	localException6	Exception
    //   577	1	3	localObject10	Object
    //   59	402	4	localObject11	Object
    //   486	1	4	localException7	Exception
    //   495	1	4	localException8	Exception
    //   504	1	4	localException9	Exception
    //   509	1	4	localException10	Exception
    //   516	64	4	localObject12	Object
    //   1	1	5	localObject13	Object
    //   304	1	5	localException11	Exception
    //   307	262	5	localObject14	Object
    //   81	306	6	localObject15	Object
    //   525	6	6	localObject16	Object
    //   32	330	7	str1	String
    //   139	212	8	str2	String
    //   18	277	9	localObject17	Object
    // Exception table:
    //   from	to	target	type
    //   280	288	304	java/lang/Exception
    //   293	301	304	java/lang/Exception
    //   413	429	304	java/lang/Exception
    //   196	255	449	finally
    //   429	434	486	java/lang/Exception
    //   434	438	491	java/lang/Exception
    //   319	324	495	java/lang/Exception
    //   328	332	500	java/lang/Exception
    //   460	465	504	java/lang/Exception
    //   470	475	509	java/lang/Exception
    //   255	265	514	finally
    //   265	280	521	finally
    //   280	288	525	finally
    //   293	301	525	finally
    //   413	429	525	finally
    //   196	255	536	java/lang/Exception
    //   255	265	547	java/lang/Exception
    //   265	280	562	java/lang/Exception
    //   63	71	574	java/lang/Exception
    //   73	83	574	java/lang/Exception
  }
  
  public final void cex()
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat]");
    Object localObject = cev();
    if (((JSONArray)localObject).length() == 0)
    {
      TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] no data");
      return;
    }
    TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] jsonArray:" + localObject);
    try
    {
      localObject = g.a(com.tencent.smtt.utils.q.gZ(this.mContext).wWr, ((JSONArray)localObject).toString().getBytes("utf-8"), new g.a()
      {
        public final void CV(int paramAnonymousInt)
        {
          TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] onHttpResponseCode:" + paramAnonymousInt);
          if (paramAnonymousInt < 300)
          {
            SharedPreferences.Editor localEditor = r.this.cey().edit();
            localEditor.remove("tbs_download_upload");
            localEditor.commit();
          }
        }
      }, true);
      TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] response:" + (String)localObject + " testcase: -1");
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  final SharedPreferences cey()
  {
    return this.mContext.getSharedPreferences("tbs_download_stat", 4);
  }
  
  public static enum a
  {
    int value;
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static final class b
    implements Cloneable
  {
    int jTc;
    public String wTA;
    public String wTB;
    public int wTC;
    public int wTD;
    public int wTE;
    public int wTF;
    public String wTG;
    public int wTH;
    public int wTI;
    public long wTJ;
    public long wTK;
    public int wTL;
    public String wTM;
    public String wTN;
    public long wTO;
    public long wTz;
    
    public b()
    {
      cdM();
    }
    
    public final void Vr(String paramString)
    {
      setErrorCode(108);
      this.wTM = paramString;
    }
    
    public final void Vs(String paramString)
    {
      if (paramString == null) {
        return;
      }
      String str = paramString;
      if (paramString.length() > 1024) {
        str = paramString.substring(0, 1024);
      }
      this.wTN = str;
    }
    
    public final void cdM()
    {
      this.wTz = 0L;
      this.wTA = null;
      this.wTB = null;
      this.wTC = 0;
      this.wTD = 0;
      this.wTE = 0;
      this.wTF = 2;
      this.wTG = "unknown";
      this.wTH = 0;
      this.wTI = 2;
      this.wTJ = 0L;
      this.wTK = 0L;
      this.wTL = 1;
      this.jTc = 0;
      this.wTM = null;
      this.wTN = null;
      this.wTO = 0L;
    }
    
    protected final Object clone()
    {
      try
      {
        Object localObject = super.clone();
        return localObject;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException) {}
      return this;
    }
    
    public final void k(Throwable paramThrowable)
    {
      if (paramThrowable == null)
      {
        this.wTN = "";
        return;
      }
      String str = Log.getStackTraceString(paramThrowable);
      paramThrowable = str;
      if (str.length() > 1024) {
        paramThrowable = str.substring(0, 1024);
      }
      this.wTN = paramThrowable;
    }
    
    public final void setErrorCode(int paramInt)
    {
      if ((paramInt != 100) && (paramInt != 110) && (paramInt != 120) && (paramInt != 111) && (paramInt < 400)) {
        TbsLog.i("TbsDownload", "error occured, errorCode:" + paramInt, true);
      }
      if (paramInt == 111) {
        TbsLog.i("TbsDownload", "you are not in wifi, downloading stoped", true);
      }
      this.jTc = paramInt;
    }
  }
  
  private static final class c
  {
    private final String wTP;
    private final String wTQ;
    
    public c(String paramString1, String paramString2)
    {
      this.wTP = paramString1;
      this.wTQ = paramString2;
    }
    
    /* Error */
    public final void cez()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 4
      //   3: aconst_null
      //   4: astore 7
      //   6: aconst_null
      //   7: astore 8
      //   9: aconst_null
      //   10: astore 9
      //   12: new 27	java/io/FileOutputStream
      //   15: dup
      //   16: aload_0
      //   17: getfield 19	com/tencent/smtt/sdk/r$c:wTQ	Ljava/lang/String;
      //   20: invokespecial 30	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
      //   23: astore_3
      //   24: new 32	java/util/zip/ZipOutputStream
      //   27: dup
      //   28: new 34	java/io/BufferedOutputStream
      //   31: dup
      //   32: aload_3
      //   33: invokespecial 37	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   36: invokespecial 38	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   39: astore 5
      //   41: sipush 2048
      //   44: newarray <illegal type>
      //   46: astore 10
      //   48: aload_0
      //   49: getfield 17	com/tencent/smtt/sdk/r$c:wTP	Ljava/lang/String;
      //   52: astore 11
      //   54: new 40	java/io/FileInputStream
      //   57: dup
      //   58: aload 11
      //   60: invokespecial 41	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
      //   63: astore 6
      //   65: new 43	java/io/BufferedInputStream
      //   68: dup
      //   69: aload 6
      //   71: sipush 2048
      //   74: invokespecial 46	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
      //   77: astore 4
      //   79: aload 5
      //   81: new 48	java/util/zip/ZipEntry
      //   84: dup
      //   85: aload 11
      //   87: aload 11
      //   89: ldc 50
      //   91: invokevirtual 56	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
      //   94: iconst_1
      //   95: iadd
      //   96: invokevirtual 60	java/lang/String:substring	(I)Ljava/lang/String;
      //   99: invokespecial 61	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
      //   102: invokevirtual 65	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
      //   105: aload 4
      //   107: aload 10
      //   109: iconst_0
      //   110: sipush 2048
      //   113: invokevirtual 69	java/io/BufferedInputStream:read	([BII)I
      //   116: istore_1
      //   117: iload_1
      //   118: iconst_m1
      //   119: if_icmpeq +127 -> 246
      //   122: aload 5
      //   124: aload 10
      //   126: iconst_0
      //   127: iload_1
      //   128: invokevirtual 73	java/util/zip/ZipOutputStream:write	([BII)V
      //   131: goto -26 -> 105
      //   134: astore 9
      //   136: aload 4
      //   138: ifnull +8 -> 146
      //   141: aload 4
      //   143: invokevirtual 76	java/io/BufferedInputStream:close	()V
      //   146: aload 6
      //   148: ifnull +8 -> 156
      //   151: aload 6
      //   153: invokevirtual 77	java/io/FileInputStream:close	()V
      //   156: new 79	java/io/File
      //   159: dup
      //   160: aload_0
      //   161: getfield 19	com/tencent/smtt/sdk/r$c:wTQ	Ljava/lang/String;
      //   164: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
      //   167: astore 4
      //   169: new 82	java/io/RandomAccessFile
      //   172: dup
      //   173: aload 4
      //   175: ldc 84
      //   177: invokespecial 87	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   180: astore 4
      //   182: ldc 89
      //   184: iconst_2
      //   185: invokestatic 95	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
      //   188: istore_1
      //   189: aload 4
      //   191: ldc2_w 96
      //   194: invokevirtual 101	java/io/RandomAccessFile:seek	(J)V
      //   197: aload 4
      //   199: invokevirtual 104	java/io/RandomAccessFile:read	()I
      //   202: istore_2
      //   203: iload_2
      //   204: iload_1
      //   205: iand
      //   206: ifle +25 -> 231
      //   209: aload 4
      //   211: ldc2_w 96
      //   214: invokevirtual 101	java/io/RandomAccessFile:seek	(J)V
      //   217: aload 4
      //   219: iload_1
      //   220: iconst_m1
      //   221: ixor
      //   222: sipush 255
      //   225: iand
      //   226: iload_2
      //   227: iand
      //   228: invokevirtual 107	java/io/RandomAccessFile:write	(I)V
      //   231: aload 4
      //   233: invokevirtual 108	java/io/RandomAccessFile:close	()V
      //   236: aload 5
      //   238: invokevirtual 109	java/util/zip/ZipOutputStream:close	()V
      //   241: aload_3
      //   242: invokevirtual 110	java/io/FileOutputStream:close	()V
      //   245: return
      //   246: aload 5
      //   248: invokevirtual 113	java/util/zip/ZipOutputStream:flush	()V
      //   251: aload 5
      //   253: invokevirtual 116	java/util/zip/ZipOutputStream:closeEntry	()V
      //   256: aload 4
      //   258: invokevirtual 76	java/io/BufferedInputStream:close	()V
      //   261: aload 6
      //   263: invokevirtual 77	java/io/FileInputStream:close	()V
      //   266: goto -110 -> 156
      //   269: astore 4
      //   271: goto -115 -> 156
      //   274: astore 4
      //   276: aconst_null
      //   277: astore 6
      //   279: aload 9
      //   281: astore 7
      //   283: aload 7
      //   285: ifnull +8 -> 293
      //   288: aload 7
      //   290: invokevirtual 76	java/io/BufferedInputStream:close	()V
      //   293: aload 6
      //   295: ifnull +8 -> 303
      //   298: aload 6
      //   300: invokevirtual 77	java/io/FileInputStream:close	()V
      //   303: aload 4
      //   305: athrow
      //   306: astore 4
      //   308: aload 5
      //   310: ifnull +8 -> 318
      //   313: aload 5
      //   315: invokevirtual 109	java/util/zip/ZipOutputStream:close	()V
      //   318: aload_3
      //   319: ifnull -74 -> 245
      //   322: aload_3
      //   323: invokevirtual 110	java/io/FileOutputStream:close	()V
      //   326: return
      //   327: astore_3
      //   328: return
      //   329: astore 4
      //   331: aload 7
      //   333: astore 4
      //   335: aload 4
      //   337: ifnull -101 -> 236
      //   340: aload 4
      //   342: invokevirtual 108	java/io/RandomAccessFile:close	()V
      //   345: goto -109 -> 236
      //   348: astore 4
      //   350: goto -114 -> 236
      //   353: astore 4
      //   355: aload 8
      //   357: astore 6
      //   359: aload 6
      //   361: ifnull +8 -> 369
      //   364: aload 6
      //   366: invokevirtual 108	java/io/RandomAccessFile:close	()V
      //   369: aload 4
      //   371: athrow
      //   372: astore 4
      //   374: aload 5
      //   376: ifnull +8 -> 384
      //   379: aload 5
      //   381: invokevirtual 109	java/util/zip/ZipOutputStream:close	()V
      //   384: aload_3
      //   385: ifnull +7 -> 392
      //   388: aload_3
      //   389: invokevirtual 110	java/io/FileOutputStream:close	()V
      //   392: aload 4
      //   394: athrow
      //   395: astore 4
      //   397: goto -136 -> 261
      //   400: astore 4
      //   402: goto -256 -> 146
      //   405: astore 4
      //   407: goto -251 -> 156
      //   410: astore 7
      //   412: goto -119 -> 293
      //   415: astore 6
      //   417: goto -114 -> 303
      //   420: astore 4
      //   422: goto -186 -> 236
      //   425: astore 6
      //   427: goto -58 -> 369
      //   430: astore 4
      //   432: goto -191 -> 241
      //   435: astore_3
      //   436: return
      //   437: astore 4
      //   439: goto -121 -> 318
      //   442: astore 5
      //   444: goto -60 -> 384
      //   447: astore_3
      //   448: goto -56 -> 392
      //   451: astore 4
      //   453: aconst_null
      //   454: astore 5
      //   456: aconst_null
      //   457: astore_3
      //   458: goto -84 -> 374
      //   461: astore 4
      //   463: aconst_null
      //   464: astore 5
      //   466: goto -92 -> 374
      //   469: astore_3
      //   470: aconst_null
      //   471: astore_3
      //   472: aload 4
      //   474: astore 5
      //   476: goto -168 -> 308
      //   479: astore 5
      //   481: aload 4
      //   483: astore 5
      //   485: goto -177 -> 308
      //   488: astore 7
      //   490: aload 4
      //   492: astore 6
      //   494: aload 7
      //   496: astore 4
      //   498: goto -139 -> 359
      //   501: astore 6
      //   503: goto -168 -> 335
      //   506: astore 4
      //   508: aload 9
      //   510: astore 7
      //   512: goto -229 -> 283
      //   515: astore 8
      //   517: aload 4
      //   519: astore 7
      //   521: aload 8
      //   523: astore 4
      //   525: goto -242 -> 283
      //   528: astore 4
      //   530: aconst_null
      //   531: astore 4
      //   533: aconst_null
      //   534: astore 6
      //   536: goto -400 -> 136
      //   539: astore 4
      //   541: aconst_null
      //   542: astore 4
      //   544: goto -408 -> 136
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	547	0	this	c
      //   116	106	1	i	int
      //   202	26	2	j	int
      //   23	300	3	localFileOutputStream	java.io.FileOutputStream
      //   327	62	3	localIOException1	java.io.IOException
      //   435	1	3	localIOException2	java.io.IOException
      //   447	1	3	localIOException3	java.io.IOException
      //   457	1	3	localObject1	Object
      //   469	1	3	localException1	Exception
      //   471	1	3	localObject2	Object
      //   1	256	4	localObject3	Object
      //   269	1	4	localIOException4	java.io.IOException
      //   274	30	4	localObject4	Object
      //   306	1	4	localException2	Exception
      //   329	1	4	localException3	Exception
      //   333	8	4	localObject5	Object
      //   348	1	4	localIOException5	java.io.IOException
      //   353	17	4	localObject6	Object
      //   372	21	4	localObject7	Object
      //   395	1	4	localIOException6	java.io.IOException
      //   400	1	4	localIOException7	java.io.IOException
      //   405	1	4	localIOException8	java.io.IOException
      //   420	1	4	localIOException9	java.io.IOException
      //   430	1	4	localIOException10	java.io.IOException
      //   437	1	4	localIOException11	java.io.IOException
      //   451	1	4	localObject8	Object
      //   461	30	4	localObject9	Object
      //   496	1	4	localObject10	Object
      //   506	12	4	localObject11	Object
      //   523	1	4	localObject12	Object
      //   528	1	4	localException4	Exception
      //   531	1	4	localObject13	Object
      //   539	1	4	localException5	Exception
      //   542	1	4	localObject14	Object
      //   39	341	5	localZipOutputStream	java.util.zip.ZipOutputStream
      //   442	1	5	localIOException12	java.io.IOException
      //   454	21	5	localObject15	Object
      //   479	1	5	localException6	Exception
      //   483	1	5	localObject16	Object
      //   63	302	6	localObject17	Object
      //   415	1	6	localIOException13	java.io.IOException
      //   425	1	6	localIOException14	java.io.IOException
      //   492	1	6	localObject18	Object
      //   501	1	6	localException7	Exception
      //   534	1	6	localObject19	Object
      //   4	328	7	localObject20	Object
      //   410	1	7	localIOException15	java.io.IOException
      //   488	7	7	localObject21	Object
      //   510	10	7	localObject22	Object
      //   7	349	8	localObject23	Object
      //   515	7	8	localObject24	Object
      //   10	1	9	localObject25	Object
      //   134	375	9	localException8	Exception
      //   46	79	10	arrayOfByte	byte[]
      //   52	36	11	str	String
      // Exception table:
      //   from	to	target	type
      //   79	105	134	java/lang/Exception
      //   105	117	134	java/lang/Exception
      //   122	131	134	java/lang/Exception
      //   246	256	134	java/lang/Exception
      //   261	266	269	java/io/IOException
      //   54	65	274	finally
      //   41	54	306	java/lang/Exception
      //   141	146	306	java/lang/Exception
      //   151	156	306	java/lang/Exception
      //   156	169	306	java/lang/Exception
      //   231	236	306	java/lang/Exception
      //   256	261	306	java/lang/Exception
      //   261	266	306	java/lang/Exception
      //   288	293	306	java/lang/Exception
      //   298	303	306	java/lang/Exception
      //   303	306	306	java/lang/Exception
      //   340	345	306	java/lang/Exception
      //   364	369	306	java/lang/Exception
      //   369	372	306	java/lang/Exception
      //   322	326	327	java/io/IOException
      //   169	182	329	java/lang/Exception
      //   340	345	348	java/io/IOException
      //   169	182	353	finally
      //   41	54	372	finally
      //   141	146	372	finally
      //   151	156	372	finally
      //   156	169	372	finally
      //   231	236	372	finally
      //   256	261	372	finally
      //   261	266	372	finally
      //   288	293	372	finally
      //   298	303	372	finally
      //   303	306	372	finally
      //   340	345	372	finally
      //   364	369	372	finally
      //   369	372	372	finally
      //   256	261	395	java/io/IOException
      //   141	146	400	java/io/IOException
      //   151	156	405	java/io/IOException
      //   288	293	410	java/io/IOException
      //   298	303	415	java/io/IOException
      //   231	236	420	java/io/IOException
      //   364	369	425	java/io/IOException
      //   236	241	430	java/io/IOException
      //   241	245	435	java/io/IOException
      //   313	318	437	java/io/IOException
      //   379	384	442	java/io/IOException
      //   388	392	447	java/io/IOException
      //   12	24	451	finally
      //   24	41	461	finally
      //   12	24	469	java/lang/Exception
      //   24	41	479	java/lang/Exception
      //   182	203	488	finally
      //   209	231	488	finally
      //   182	203	501	java/lang/Exception
      //   209	231	501	java/lang/Exception
      //   65	79	506	finally
      //   79	105	515	finally
      //   105	117	515	finally
      //   122	131	515	finally
      //   246	256	515	finally
      //   54	65	528	java/lang/Exception
      //   65	79	539	java/lang/Exception
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/sdk/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */