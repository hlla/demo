package com.tencent.mm.bl;

import android.os.Debug;
import android.os.Environment;
import android.os.Message;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.e;
import com.tencent.mm.a.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public final class d
  implements EventListener
{
  static ad hgD;
  public static a uLN;
  public static d uLS;
  private static int uLT;
  public static final String uLV;
  private volatile boolean hSG;
  public volatile boolean uLU;
  public LinkedBlockingQueue<a> uLW;
  ExecutorService uLX;
  public WeakReference<b> uLY;
  
  static
  {
    GMTrace.i(13154411085824L, 98008);
    uLT = 5242880;
    uLV = Environment.getExternalStorageDirectory() + "/tencent/MicroMsg/tracedog/";
    uLN = null;
    hgD = new ad()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(13154679521280L, 98010);
        v.i("MicroMsg.TraceDebugManager", "TRACE handle msg :%d ", new Object[] { Integer.valueOf(paramAnonymousMessage.what) });
        if (paramAnonymousMessage.what == 0) {
          d.uLS.b((d.a)paramAnonymousMessage.obj);
        }
        for (;;)
        {
          super.handleMessage(paramAnonymousMessage);
          GMTrace.o(13154679521280L, 98010);
          return;
          if (paramAnonymousMessage.what == 1)
          {
            if (d.uLS.uLY != null)
            {
              d.b localb = (d.b)d.uLS.uLY.get();
              if (localb != null) {
                localb.bOa();
              }
            }
          }
          else {
            d.uLS.a((d.a)paramAnonymousMessage.obj);
          }
        }
      }
    };
    GMTrace.o(13154411085824L, 98008);
  }
  
  private d()
  {
    GMTrace.i(13153068908544L, 97998);
    GMTrace.o(13153068908544L, 97998);
  }
  
  private static void C(File paramFile)
  {
    GMTrace.i(13152666255360L, 97995);
    if (paramFile.isFile())
    {
      paramFile.delete();
      GMTrace.o(13152666255360L, 97995);
      return;
    }
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if ((arrayOfFile == null) || (arrayOfFile.length == 0))
      {
        paramFile.delete();
        GMTrace.o(13152666255360L, 97995);
        return;
      }
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        C(arrayOfFile[i]);
        i += 1;
      }
      paramFile.delete();
    }
    GMTrace.o(13152666255360L, 97995);
  }
  
  public static String D(File paramFile)
  {
    GMTrace.i(16088007966720L, 119865);
    ArrayList localArrayList = new ArrayList();
    int i;
    if (paramFile.isDirectory())
    {
      v.i("MicroMsg.TraceDebugManager", "TRACE currentPath is dir");
      paramFile = paramFile.listFiles();
      if (paramFile == null)
      {
        v.e("MicroMsg.TraceDebugManager", " get file list failed");
        GMTrace.o(16088007966720L, 119865);
        return null;
      }
      i = 0;
      while (i < paramFile.length)
      {
        localArrayList.add(paramFile[i]);
        i += 1;
      }
    }
    localArrayList.add(paramFile);
    paramFile = new File(uLV + bf.NA() + ".zip");
    try
    {
      p.a(localArrayList, paramFile);
      i = 0;
      while (i < localArrayList.size())
      {
        ((File)localArrayList.get(i)).delete();
        i += 1;
      }
      if (paramFile.length() <= 3145728L) {
        break label243;
      }
    }
    catch (Exception paramFile)
    {
      v.e("MicroMsg.TraceDebugManager", "exception:%s", new Object[] { bf.g(paramFile) });
      v.e("MicroMsg.TraceDebugManager", "zip file failed msg:%s ", new Object[] { paramFile.getMessage() });
      GMTrace.o(16088007966720L, 119865);
      return null;
    }
    v.e("MicroMsg.TraceDebugManager", "trace file is too large:%d ", new Object[] { Long.valueOf(paramFile.length()) });
    GMTrace.o(16088007966720L, 119865);
    return null;
    label243:
    paramFile = paramFile.getAbsolutePath();
    GMTrace.o(16088007966720L, 119865);
    return paramFile;
  }
  
  public static d bNY()
  {
    GMTrace.i(13152263602176L, 97992);
    if (uLS == null) {
      uLS = new d();
    }
    d locald = uLS;
    GMTrace.o(13152263602176L, 97992);
    return locald;
  }
  
  private static void bNZ()
  {
    GMTrace.i(13152532037632L, 97994);
    hgD.removeMessages(0);
    hgD.removeMessages(2);
    hgD.removeMessages(1);
    GMTrace.o(13152532037632L, 97994);
  }
  
  public final void Sz(String paramString)
  {
    GMTrace.i(13153337344000L, 98000);
    if (paramString == null)
    {
      GMTrace.o(13153337344000L, 98000);
      return;
    }
    this.hSG = true;
    if (bf.mA(paramString)) {
      v.e("MicroMsg.TraceDebugManager", "TRACE error uploadPath %s ", new Object[] { paramString });
    }
    for (;;)
    {
      this.hSG = false;
      GMTrace.o(13153337344000L, 98000);
      return;
      if (!c.rZ())
      {
        v.e("MicroMsg.TraceDebugManager", "TRACE sdcard invalid.");
      }
      else
      {
        File localFile = new File(paramString);
        if (!localFile.exists())
        {
          v.e("MicroMsg.TraceDebugManager", "TRACE upload file is not exist");
        }
        else
        {
          if (localFile.isDirectory()) {
            paramString = D(localFile);
          }
          if ((paramString != null) && (new File(paramString).length() >= 131072L)) {
            if (uLN == null)
            {
              v.e("MicroMsg.TraceDebugManager", "TRACE upload : no file upload impl set!");
            }
            else
            {
              boolean bool = uLN.Cu(paramString);
              v.i("MicroMsg.TraceDebugManager", "TRACE upload : %b", new Object[] { Boolean.valueOf(bool) });
              if (bool) {
                e.d(new File(uLV));
              }
            }
          }
        }
      }
    }
  }
  
  public final void a(a parama)
  {
    GMTrace.i(13152397819904L, 97993);
    if (this.uLU)
    {
      GMTrace.o(13152397819904L, 97993);
      return;
    }
    if (!c.rZ())
    {
      v.i("MicroMsg.TraceDebugManager", "TRACE sdcard is invalid");
      GMTrace.o(13152397819904L, 97993);
      return;
    }
    bNZ();
    for (;;)
    {
      try
      {
        Object localObject = new File(uLV);
        if ((parama.fXv != 6) && (((File)localObject).exists()))
        {
          v.i("MicroMsg.TraceDebugManager", "TRACE delete all file ");
          C((File)localObject);
        }
        ((File)localObject).mkdirs();
        localObject = parama.savePath;
        if (parama.uMb > 0) {
          continue;
        }
        i = uLT;
        Debug.startMethodTracing((String)localObject, i);
        this.uLU = true;
      }
      catch (IncompatibleClassChangeError parama)
      {
        int i;
        v.printErrStackTrace("MicroMsg.Crash", parama, "May cause dvmFindCatchBlock crash!", new Object[0]);
        throw ((IncompatibleClassChangeError)new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(parama));
      }
      catch (Throwable localThrowable)
      {
        this.uLU = false;
        v.printErrStackTrace("MicroMsg.TraceDebugManager", localThrowable, "TRACE startMethodTracing ERROR", new Object[0]);
        continue;
        if (this.uLU) {
          continue;
        }
        GMTrace.o(13152397819904L, 97993);
        return;
        Message localMessage = Message.obtain();
        localMessage.what = 0;
        localMessage.obj = parama;
        if ((!bf.mA(parama.className)) && (parama.fXv != 5)) {
          continue;
        }
        hgD.sendMessageDelayed(localMessage, 15000L);
        GMTrace.o(13152397819904L, 97993);
        return;
        hgD.sendMessageDelayed(localMessage, 10000L);
        GMTrace.o(13152397819904L, 97993);
      }
      if (parama.fXv != 6) {
        continue;
      }
      v.i("MicroMsg.TraceDebugManager", "TRACE startTrace uploadType is CLIENT ");
      GMTrace.o(13152397819904L, 97993);
      return;
      i = parama.uMb;
      i = i * 1024 * 1024;
    }
  }
  
  public final boolean b(final a parama)
  {
    GMTrace.i(13152800473088L, 97996);
    bNZ();
    if ((!this.uLU) || (this.hSG))
    {
      v.i("MicroMsg.TraceDebugManager", "TRACE stopTrace hasStartTrace : %b ,isUploading :%b  ", new Object[] { Boolean.valueOf(this.uLU), Boolean.valueOf(this.hSG) });
      GMTrace.o(13152800473088L, 97996);
      return false;
    }
    if (!c.rZ())
    {
      v.i("MicroMsg.TraceDebugManager", "TRACE stopTrace sdcard invalid");
      GMTrace.o(13152800473088L, 97996);
      return false;
    }
    this.uLX.execute(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc2_w 45
        //   3: ldc 47
        //   5: invokestatic 33	com/tencent/gmtrace/GMTrace:i	(JI)V
        //   8: invokestatic 52	android/os/Debug:stopMethodTracing	()V
        //   11: aload_0
        //   12: getfield 21	com/tencent/mm/bl/d$1:uLZ	Lcom/tencent/mm/bl/d$a;
        //   15: getfield 58	com/tencent/mm/bl/d$a:savePath	Ljava/lang/String;
        //   18: astore 4
        //   20: aload_0
        //   21: getfield 21	com/tencent/mm/bl/d$1:uLZ	Lcom/tencent/mm/bl/d$a;
        //   24: getfield 62	com/tencent/mm/bl/d$a:uMc	I
        //   27: istore_1
        //   28: aload_0
        //   29: getfield 21	com/tencent/mm/bl/d$1:uLZ	Lcom/tencent/mm/bl/d$a;
        //   32: getfield 58	com/tencent/mm/bl/d$a:savePath	Ljava/lang/String;
        //   35: astore 5
        //   37: aload 5
        //   39: ifnonnull +20 -> 59
        //   42: aload_0
        //   43: getfield 19	com/tencent/mm/bl/d$1:uMa	Lcom/tencent/mm/bl/d;
        //   46: iconst_0
        //   47: putfield 66	com/tencent/mm/bl/d:uLU	Z
        //   50: ldc2_w 45
        //   53: ldc 47
        //   55: invokestatic 36	com/tencent/gmtrace/GMTrace:o	(JI)V
        //   58: return
        //   59: new 68	java/io/File
        //   62: dup
        //   63: aload 4
        //   65: invokespecial 71	java/io/File:<init>	(Ljava/lang/String;)V
        //   68: astore 5
        //   70: new 68	java/io/File
        //   73: dup
        //   74: new 73	java/lang/StringBuilder
        //   77: dup
        //   78: invokespecial 74	java/lang/StringBuilder:<init>	()V
        //   81: aload 4
        //   83: iconst_0
        //   84: aload 4
        //   86: bipush 46
        //   88: invokevirtual 80	java/lang/String:lastIndexOf	(I)I
        //   91: invokevirtual 84	java/lang/String:substring	(II)Ljava/lang/String;
        //   94: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   97: ldc 90
        //   99: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   102: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   105: invokespecial 71	java/io/File:<init>	(Ljava/lang/String;)V
        //   108: astore 4
        //   110: invokestatic 100	java/lang/System:currentTimeMillis	()J
        //   113: lstore_2
        //   114: aload 5
        //   116: aload 4
        //   118: invokevirtual 104	java/io/File:renameTo	(Ljava/io/File;)Z
        //   121: pop
        //   122: aload 5
        //   124: invokevirtual 108	java/io/File:delete	()Z
        //   127: pop
        //   128: ldc 110
        //   130: new 73	java/lang/StringBuilder
        //   133: dup
        //   134: ldc 112
        //   136: invokespecial 113	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   139: invokestatic 100	java/lang/System:currentTimeMillis	()J
        //   142: lload_2
        //   143: lsub
        //   144: invokevirtual 116	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   147: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   150: invokestatic 121	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   153: bipush 10
        //   155: invokestatic 127	android/os/Process:setThreadPriority	(I)V
        //   158: aload_0
        //   159: getfield 21	com/tencent/mm/bl/d$1:uLZ	Lcom/tencent/mm/bl/d$a;
        //   162: getfield 130	com/tencent/mm/bl/d$a:fXv	I
        //   165: bipush 6
        //   167: if_icmpne +141 -> 308
        //   170: new 132	java/util/ArrayList
        //   173: dup
        //   174: invokespecial 133	java/util/ArrayList:<init>	()V
        //   177: astore 5
        //   179: aload 5
        //   181: aload 4
        //   183: invokevirtual 137	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   186: pop
        //   187: new 68	java/io/File
        //   190: dup
        //   191: new 73	java/lang/StringBuilder
        //   194: dup
        //   195: invokespecial 74	java/lang/StringBuilder:<init>	()V
        //   198: aload 4
        //   200: invokevirtual 140	java/io/File:getAbsolutePath	()Ljava/lang/String;
        //   203: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   206: ldc -114
        //   208: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   211: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   214: invokespecial 71	java/io/File:<init>	(Ljava/lang/String;)V
        //   217: astore 4
        //   219: aload 5
        //   221: aload 4
        //   223: invokestatic 148	com/tencent/mm/a/p:a	(Ljava/util/Collection;Ljava/io/File;)V
        //   226: getstatic 152	com/tencent/mm/bl/d:hgD	Lcom/tencent/mm/sdk/platformtools/ad;
        //   229: iconst_1
        //   230: invokevirtual 158	com/tencent/mm/sdk/platformtools/ad:sendEmptyMessage	(I)Z
        //   233: pop
        //   234: aload_0
        //   235: getfield 19	com/tencent/mm/bl/d$1:uMa	Lcom/tencent/mm/bl/d;
        //   238: iconst_0
        //   239: putfield 66	com/tencent/mm/bl/d:uLU	Z
        //   242: ldc2_w 45
        //   245: ldc 47
        //   247: invokestatic 36	com/tencent/gmtrace/GMTrace:o	(JI)V
        //   250: return
        //   251: astore 4
        //   253: ldc 110
        //   255: ldc -96
        //   257: iconst_1
        //   258: anewarray 4	java/lang/Object
        //   261: dup
        //   262: iconst_0
        //   263: aload 4
        //   265: invokestatic 166	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   268: aastore
        //   269: invokestatic 170	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   272: ldc 110
        //   274: ldc -84
        //   276: iconst_1
        //   277: anewarray 4	java/lang/Object
        //   280: dup
        //   281: iconst_0
        //   282: aload 4
        //   284: invokevirtual 175	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   287: aastore
        //   288: invokestatic 170	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   291: aload_0
        //   292: getfield 19	com/tencent/mm/bl/d$1:uMa	Lcom/tencent/mm/bl/d;
        //   295: iconst_0
        //   296: putfield 66	com/tencent/mm/bl/d:uLU	Z
        //   299: ldc2_w 45
        //   302: ldc 47
        //   304: invokestatic 36	com/tencent/gmtrace/GMTrace:o	(JI)V
        //   307: return
        //   308: aload_0
        //   309: getfield 19	com/tencent/mm/bl/d$1:uMa	Lcom/tencent/mm/bl/d;
        //   312: getfield 179	com/tencent/mm/bl/d:uLW	Ljava/util/concurrent/LinkedBlockingQueue;
        //   315: ifnull +16 -> 331
        //   318: aload_0
        //   319: getfield 19	com/tencent/mm/bl/d$1:uMa	Lcom/tencent/mm/bl/d;
        //   322: getfield 179	com/tencent/mm/bl/d:uLW	Ljava/util/concurrent/LinkedBlockingQueue;
        //   325: invokevirtual 185	java/util/concurrent/LinkedBlockingQueue:size	()I
        //   328: ifne +50 -> 378
        //   331: aload 4
        //   333: invokestatic 189	com/tencent/mm/bl/d:D	(Ljava/io/File;)Ljava/lang/String;
        //   336: astore 4
        //   338: aload 4
        //   340: invokestatic 193	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
        //   343: ifne +35 -> 378
        //   346: aload_0
        //   347: getfield 19	com/tencent/mm/bl/d$1:uMa	Lcom/tencent/mm/bl/d;
        //   350: astore 5
        //   352: iload_1
        //   353: iconst_1
        //   354: if_icmpeq +17 -> 371
        //   357: iload_1
        //   358: iconst_3
        //   359: if_icmpne +19 -> 378
        //   362: invokestatic 199	com/tencent/mm/sdk/platformtools/aa:getContext	()Landroid/content/Context;
        //   365: invokestatic 205	com/tencent/mm/sdk/platformtools/al:isWifi	(Landroid/content/Context;)Z
        //   368: ifeq +10 -> 378
        //   371: aload 5
        //   373: aload 4
        //   375: invokevirtual 208	com/tencent/mm/bl/d:Sz	(Ljava/lang/String;)V
        //   378: aload_0
        //   379: getfield 19	com/tencent/mm/bl/d$1:uMa	Lcom/tencent/mm/bl/d;
        //   382: iconst_0
        //   383: putfield 66	com/tencent/mm/bl/d:uLU	Z
        //   386: ldc2_w 45
        //   389: ldc 47
        //   391: invokestatic 36	com/tencent/gmtrace/GMTrace:o	(JI)V
        //   394: return
        //   395: astore 4
        //   397: ldc -46
        //   399: aload 4
        //   401: ldc -44
        //   403: iconst_0
        //   404: anewarray 4	java/lang/Object
        //   407: invokestatic 216	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   410: new 40	java/lang/IncompatibleClassChangeError
        //   413: dup
        //   414: ldc -44
        //   416: invokespecial 217	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
        //   419: aload 4
        //   421: invokevirtual 221	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
        //   424: checkcast 40	java/lang/IncompatibleClassChangeError
        //   427: checkcast 40	java/lang/IncompatibleClassChangeError
        //   430: athrow
        //   431: astore 4
        //   433: aload_0
        //   434: getfield 19	com/tencent/mm/bl/d$1:uMa	Lcom/tencent/mm/bl/d;
        //   437: iconst_0
        //   438: putfield 66	com/tencent/mm/bl/d:uLU	Z
        //   441: aload 4
        //   443: athrow
        //   444: astore 4
        //   446: ldc 110
        //   448: aload 4
        //   450: ldc -33
        //   452: iconst_0
        //   453: anewarray 4	java/lang/Object
        //   456: invokestatic 216	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   459: aload_0
        //   460: getfield 19	com/tencent/mm/bl/d$1:uMa	Lcom/tencent/mm/bl/d;
        //   463: iconst_0
        //   464: putfield 66	com/tencent/mm/bl/d:uLU	Z
        //   467: ldc2_w 45
        //   470: ldc 47
        //   472: invokestatic 36	com/tencent/gmtrace/GMTrace:o	(JI)V
        //   475: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	476	0	this	1
        //   27	333	1	i	int
        //   113	30	2	l	long
        //   18	204	4	localObject1	Object
        //   251	81	4	localException	Exception
        //   336	38	4	str	String
        //   395	25	4	localIncompatibleClassChangeError	IncompatibleClassChangeError
        //   431	11	4	localObject2	Object
        //   444	5	4	localThrowable	Throwable
        //   35	337	5	localObject3	Object
        // Exception table:
        //   from	to	target	type
        //   219	226	251	java/lang/Exception
        //   8	37	395	java/lang/IncompatibleClassChangeError
        //   59	219	395	java/lang/IncompatibleClassChangeError
        //   219	226	395	java/lang/IncompatibleClassChangeError
        //   226	234	395	java/lang/IncompatibleClassChangeError
        //   253	291	395	java/lang/IncompatibleClassChangeError
        //   308	331	395	java/lang/IncompatibleClassChangeError
        //   331	352	395	java/lang/IncompatibleClassChangeError
        //   362	371	395	java/lang/IncompatibleClassChangeError
        //   371	378	395	java/lang/IncompatibleClassChangeError
        //   8	37	431	finally
        //   59	219	431	finally
        //   219	226	431	finally
        //   226	234	431	finally
        //   253	291	431	finally
        //   308	331	431	finally
        //   331	352	431	finally
        //   362	371	431	finally
        //   371	378	431	finally
        //   397	431	431	finally
        //   446	459	431	finally
        //   8	37	444	java/lang/Throwable
        //   59	219	444	java/lang/Throwable
        //   219	226	444	java/lang/Throwable
        //   226	234	444	java/lang/Throwable
        //   253	291	444	java/lang/Throwable
        //   308	331	444	java/lang/Throwable
        //   331	352	444	java/lang/Throwable
        //   362	371	444	java/lang/Throwable
        //   371	378	444	java/lang/Throwable
      }
    });
    GMTrace.o(13152800473088L, 97996);
    return true;
  }
  
  public final void c(a parama)
  {
    GMTrace.i(13153471561728L, 98001);
    if (parama.fXv <= 0)
    {
      GMTrace.o(13153471561728L, 98001);
      return;
    }
    if (this.uLX == null) {
      this.uLX = Executors.newSingleThreadExecutor();
    }
    if ((this.hSG) || (this.uLU))
    {
      v.i("MicroMsg.TraceDebugManager", "TRACE isUloading or hasStartTrace %b %b", new Object[] { Boolean.valueOf(this.hSG), Boolean.valueOf(this.uLU) });
      GMTrace.o(13153471561728L, 98001);
      return;
    }
    hgD.removeMessages(0);
    if ((parama.uMc == 4) || (parama.uMc == 5))
    {
      final int i = parama.uMc;
      this.uLX.execute(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(13149579247616L, 97972);
          d locald = d.this;
          if (i == 4) {}
          for (String str = "/data/anr/";; str = d.uLV)
          {
            locald.Sz(str);
            GMTrace.o(13149579247616L, 97972);
            return;
          }
        }
      });
    }
    for (;;)
    {
      v.i("MicroMsg.TraceDebugManager", "TRACE PUSH : class : %s  code :%s type :%s", new Object[] { parama.className, Integer.valueOf(parama.fXv), Integer.valueOf(parama.uMc) });
      GMTrace.o(13153471561728L, 98001);
      return;
      if ((parama.fXv == 6) || (parama.fXv == 5))
      {
        Message localMessage = Message.obtain();
        localMessage.what = 2;
        localMessage.obj = parama;
        if (parama.fXv == 5) {
          hgD.sendMessage(localMessage);
        } else {
          hgD.sendMessageDelayed(localMessage, 500L);
        }
      }
      else
      {
        if (this.uLW == null) {
          this.uLW = new LinkedBlockingQueue();
        }
        this.uLW.clear();
        this.uLW.add(parama);
      }
    }
  }
  
  public final void cJ(String paramString, int paramInt)
  {
    GMTrace.i(13153203126272L, 97999);
    if ((this.uLW != null) && (this.uLW.size() > 0))
    {
      v.i("MicroMsg.TraceDebugManager", "TRACE gatherData : isUploading : %b  hasStart :%b currentClass : %s currentCode %d ", new Object[] { Boolean.valueOf(this.hSG), Boolean.valueOf(this.uLU), paramString, Integer.valueOf(paramInt) });
      if ((!this.hSG) && (!this.uLU))
      {
        Iterator localIterator = this.uLW.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if (locala.className != null)
          {
            if ((locala.className.equals(paramString)) && (locala.fXv == paramInt))
            {
              a(locala);
              this.uLW.remove(locala);
              GMTrace.o(13153203126272L, 97999);
            }
          }
          else
          {
            a(null);
            this.uLW.remove(locala);
            GMTrace.o(13153203126272L, 97999);
            return;
          }
        }
      }
    }
    GMTrace.o(13153203126272L, 97999);
  }
  
  public static final class a
  {
    String className;
    int fXv;
    String savePath;
    int uMb;
    int uMc;
    
    public a(String paramString, int paramInt1, int paramInt2, int paramInt3)
    {
      GMTrace.i(13149042376704L, 97968);
      this.className = paramString;
      this.fXv = paramInt1;
      this.uMb = paramInt2;
      this.uMc = paramInt3;
      StringBuilder localStringBuilder1 = new StringBuilder();
      if (bf.mA(paramString))
      {
        localStringBuilder1.append(d.uLV).append("WEIXIN_").append(System.currentTimeMillis()).append(".trace");
        v.i("MicroMsg.TraceDebugManager", "TRACE startMethod path %s traceSize : %d", new Object[] { localStringBuilder1.toString(), Integer.valueOf(paramInt2) });
        this.savePath = localStringBuilder1.toString();
        GMTrace.o(13149042376704L, 97968);
        return;
      }
      StringBuilder localStringBuilder2 = localStringBuilder1.append(d.uLV).append(paramString).append("_");
      paramString = "";
      switch (paramInt1)
      {
      }
      for (;;)
      {
        localStringBuilder2.append(paramString).append(".trace");
        break;
        paramString = "onResume";
        continue;
        paramString = "onCreate";
        continue;
        paramString = "onPause";
        continue;
        paramString = "onScrool";
        continue;
        paramString = "all";
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void bOa();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/bl/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */