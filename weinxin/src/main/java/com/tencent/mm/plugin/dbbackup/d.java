package com.tencent.mm.plugin.dbbackup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcel;
import android.os.PowerManager;
import android.os.Process;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.n;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.lc;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.repair.BackupKit;
import com.tencent.wcdb.repair.DBDumpUtil.ExecuteSqlCallback;
import com.tencent.wcdb.repair.RecoverKit;
import com.tencent.wcdb.repair.RepairKit;
import com.tencent.wcdb.repair.RepairKit.MasterInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class d
  implements am
{
  public static final SQLiteCipherSpec kDJ;
  private BroadcastReceiver hLs;
  public boolean hLt;
  public boolean hLu;
  public Runnable hLw;
  public long kDA;
  public long kDB;
  public int kDC;
  private boolean kDD;
  final SimpleDateFormat kDE;
  private String kDF;
  private FLock kDG;
  private j.a kDH;
  private com.tencent.mm.sdk.b.c kDI;
  public volatile BackupKit kDt;
  public volatile RecoverKit kDu;
  public volatile RepairKit kDv;
  public volatile boolean kDw;
  public boolean kDx;
  public boolean kDy;
  public long kDz;
  
  static
  {
    GMTrace.i(5137049321472L, 38274);
    kDJ = new SQLiteCipherSpec().setPageSize(1024).setSQLCipherVersion(1);
    GMTrace.o(5137049321472L, 38274);
  }
  
  public d()
  {
    GMTrace.i(5131277959168L, 38231);
    this.kDw = false;
    this.kDx = false;
    this.kDy = false;
    this.kDz = 0L;
    this.kDA = 600000L;
    this.hLt = false;
    this.hLu = true;
    this.kDB = 0L;
    this.kDC = 10;
    this.kDD = false;
    this.kDE = new SimpleDateFormat("HH:mm:ss.SSS");
    GMTrace.o(5131277959168L, 38231);
  }
  
  /* Error */
  public static boolean a(String paramString, long[] paramArrayOfLong)
  {
    // Byte code:
    //   0: ldc2_w 136
    //   3: ldc -118
    //   5: invokestatic 79	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   8: new 140	java/io/FileWriter
    //   11: dup
    //   12: new 142	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   19: aload_0
    //   20: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc -107
    //   25: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokespecial 154	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   34: astore 7
    //   36: aload 7
    //   38: astore 6
    //   40: aload_1
    //   41: arraylength
    //   42: istore_3
    //   43: iconst_0
    //   44: istore_2
    //   45: iload_2
    //   46: iload_3
    //   47: if_icmpge +47 -> 94
    //   50: aload_1
    //   51: iload_2
    //   52: laload
    //   53: lstore 4
    //   55: aload 7
    //   57: astore 6
    //   59: aload 7
    //   61: new 142	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   68: lload 4
    //   70: invokestatic 159	java/lang/Long:toString	(J)Ljava/lang/String;
    //   73: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: ldc -95
    //   78: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokevirtual 164	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   87: iload_2
    //   88: iconst_1
    //   89: iadd
    //   90: istore_2
    //   91: goto -46 -> 45
    //   94: aload 7
    //   96: invokevirtual 167	java/io/FileWriter:close	()V
    //   99: ldc2_w 136
    //   102: ldc -118
    //   104: invokestatic 96	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   107: iconst_1
    //   108: ireturn
    //   109: astore 8
    //   111: aconst_null
    //   112: astore_1
    //   113: aload_1
    //   114: astore 6
    //   116: ldc -87
    //   118: aload 8
    //   120: ldc -85
    //   122: iconst_1
    //   123: anewarray 4	java/lang/Object
    //   126: dup
    //   127: iconst_0
    //   128: aload_0
    //   129: aastore
    //   130: invokestatic 177	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: aload_1
    //   134: ifnull +7 -> 141
    //   137: aload_1
    //   138: invokevirtual 167	java/io/FileWriter:close	()V
    //   141: ldc2_w 136
    //   144: ldc -118
    //   146: invokestatic 96	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   149: iconst_0
    //   150: ireturn
    //   151: astore_0
    //   152: aconst_null
    //   153: astore 6
    //   155: aload 6
    //   157: ifnull +8 -> 165
    //   160: aload 6
    //   162: invokevirtual 167	java/io/FileWriter:close	()V
    //   165: aload_0
    //   166: athrow
    //   167: astore_0
    //   168: goto -69 -> 99
    //   171: astore_0
    //   172: goto -31 -> 141
    //   175: astore_1
    //   176: goto -11 -> 165
    //   179: astore_0
    //   180: goto -25 -> 155
    //   183: astore 8
    //   185: aload 7
    //   187: astore_1
    //   188: goto -75 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	paramString	String
    //   0	191	1	paramArrayOfLong	long[]
    //   44	47	2	i	int
    //   42	6	3	j	int
    //   53	16	4	l	long
    //   38	123	6	localObject	Object
    //   34	152	7	localFileWriter	FileWriter
    //   109	10	8	localIOException1	IOException
    //   183	1	8	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   8	36	109	java/io/IOException
    //   8	36	151	finally
    //   94	99	167	java/io/IOException
    //   137	141	171	java/io/IOException
    //   160	165	175	java/io/IOException
    //   40	43	179	finally
    //   59	87	179	finally
    //   116	133	179	finally
    //   40	43	183	java/io/IOException
    //   59	87	183	java/io/IOException
  }
  
  public static void akC()
  {
    GMTrace.i(18829002407936L, 140287);
    Object localObject = com.tencent.mm.u.c.c.Az().dX("100274");
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      localObject = ((com.tencent.mm.storage.c)localObject).bKA();
      HashMap localHashMap = new HashMap();
      localHashMap.put("wal", Integer.valueOf(bf.getInt((String)((Map)localObject).get("wal"), 0)));
      localHashMap.put("alter_cursor", Integer.valueOf(bf.getInt((String)((Map)localObject).get("alter_cursor"), 0)));
      com.tencent.mm.bj.e.ah(localHashMap);
    }
    GMTrace.o(18829002407936L, 140287);
  }
  
  static void akD()
  {
    GMTrace.i(18829136625664L, 140288);
    Object localObject = com.tencent.mm.u.c.wT();
    ((com.tencent.mm.plugin.messenger.foundation.a.a.c)localObject).aJT();
    ((com.tencent.mm.plugin.messenger.foundation.a.a.c)localObject).aJV();
    ((com.tencent.mm.plugin.messenger.foundation.a.a.c)localObject).aJU();
    com.tencent.mm.u.c.wW().bLv();
    n.GT().GE();
    localObject = com.tencent.mm.u.c.vr();
    ((t)localObject).a(w.a.uyj, Integer.valueOf(0));
    ((t)localObject).a(w.a.uyk, Integer.valueOf(0));
    ((t)localObject).a(w.a.uyl, Integer.valueOf(0));
    GMTrace.o(18829136625664L, 140288);
  }
  
  /* Error */
  private static long[] tz(String paramString)
  {
    // Byte code:
    //   0: ldc2_w 309
    //   3: ldc_w 311
    //   6: invokestatic 79	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: new 313	java/io/BufferedReader
    //   12: dup
    //   13: new 315	java/io/FileReader
    //   16: dup
    //   17: new 142	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   24: aload_0
    //   25: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc -107
    //   30: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokespecial 316	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   39: invokespecial 319	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   42: astore 10
    //   44: aload 10
    //   46: astore 9
    //   48: aload 10
    //   50: invokevirtual 322	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   53: invokestatic 326	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   56: lstore_1
    //   57: aload 10
    //   59: astore 9
    //   61: aload 10
    //   63: invokevirtual 322	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   66: invokestatic 326	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   69: lstore_3
    //   70: aload 10
    //   72: astore 9
    //   74: aload 10
    //   76: invokevirtual 322	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   79: invokestatic 326	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   82: lstore 5
    //   84: aload 10
    //   86: astore 9
    //   88: aload 10
    //   90: invokevirtual 322	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   93: invokestatic 326	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   96: lstore 7
    //   98: aload 10
    //   100: invokevirtual 327	java/io/BufferedReader:close	()V
    //   103: ldc2_w 309
    //   106: ldc_w 311
    //   109: invokestatic 96	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   112: iconst_4
    //   113: newarray <illegal type>
    //   115: dup
    //   116: iconst_0
    //   117: lload_1
    //   118: lastore
    //   119: dup
    //   120: iconst_1
    //   121: lload_3
    //   122: lastore
    //   123: dup
    //   124: iconst_2
    //   125: lload 5
    //   127: lastore
    //   128: dup
    //   129: iconst_3
    //   130: lload 7
    //   132: lastore
    //   133: areturn
    //   134: astore 11
    //   136: aconst_null
    //   137: astore 10
    //   139: aload 10
    //   141: astore 9
    //   143: ldc -87
    //   145: aload 11
    //   147: ldc_w 329
    //   150: iconst_1
    //   151: anewarray 4	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: aload_0
    //   157: aastore
    //   158: invokestatic 177	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   161: aload 10
    //   163: ifnull +8 -> 171
    //   166: aload 10
    //   168: invokevirtual 327	java/io/BufferedReader:close	()V
    //   171: ldc2_w 309
    //   174: ldc_w 311
    //   177: invokestatic 96	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   180: aconst_null
    //   181: areturn
    //   182: astore_0
    //   183: aconst_null
    //   184: astore 9
    //   186: aload 9
    //   188: ifnull +8 -> 196
    //   191: aload 9
    //   193: invokevirtual 327	java/io/BufferedReader:close	()V
    //   196: aload_0
    //   197: athrow
    //   198: astore_0
    //   199: goto -96 -> 103
    //   202: astore_0
    //   203: goto -32 -> 171
    //   206: astore 9
    //   208: goto -12 -> 196
    //   211: astore_0
    //   212: goto -26 -> 186
    //   215: astore 11
    //   217: goto -78 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	paramString	String
    //   56	62	1	l1	long
    //   69	53	3	l2	long
    //   82	44	5	l3	long
    //   96	35	7	l4	long
    //   46	146	9	localBufferedReader1	BufferedReader
    //   206	1	9	localIOException	IOException
    //   42	125	10	localBufferedReader2	BufferedReader
    //   134	12	11	localException1	Exception
    //   215	1	11	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   9	44	134	java/lang/Exception
    //   9	44	182	finally
    //   98	103	198	java/io/IOException
    //   166	171	202	java/io/IOException
    //   191	196	206	java/io/IOException
    //   48	57	211	finally
    //   61	70	211	finally
    //   74	84	211	finally
    //   88	98	211	finally
    //   143	161	211	finally
    //   48	57	215	java/lang/Exception
    //   61	70	215	java/lang/Exception
    //   74	84	215	java/lang/Exception
    //   88	98	215	java/lang/Exception
  }
  
  public final int a(final b paramb)
  {
    GMTrace.i(5132217483264L, 38238);
    ap.yY();
    final File localFile = new File(com.tencent.mm.u.c.vn());
    if (!localFile.canRead())
    {
      GMTrace.o(5132217483264L, 38238);
      return -3;
    }
    final Object localObject = new StringBuilder().append(p.rA());
    ap.yY();
    localObject = com.tencent.mm.a.g.n(com.tencent.mm.u.c.uH().getBytes()).substring(0, 7);
    long l1 = localFile.length() * 2L;
    long l2 = bf.bJL();
    v.i("MicroMsg.SubCoreDBBackup", "db recover needSize : %d blockSize:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    if (l2 < l1)
    {
      GMTrace.o(5132217483264L, 38238);
      return -2;
    }
    ap.vL().bIY();
    ap.vL().H(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(5142149595136L, 38312);
        try
        {
          Thread.sleep(200L);
          ap.yY();
          final Object localObject2 = com.tencent.mm.u.c.xu();
          Object localObject1 = (String)localObject2 + localFile.getName().replace(".db", "temp.db");
          v.i("MicroMsg.SubCoreDBBackup", "temp db path is %s", new Object[] { localObject1 });
          localFile.renameTo(new File((String)localObject1));
          String str = (String)localObject2 + "sqlTemp.sql";
          List localList = Arrays.asList(new String[] { "getcontactinfo", "contact", "contact_ext", "ContactCmdBuf", "rcontact", "img_flag", "userinfo" });
          localObject2 = new int[1];
          long l = System.currentTimeMillis();
          ap.yY();
          boolean bool = com.tencent.mm.u.c.wO().a((String)localObject1, localObject, str, localList, new DBDumpUtil.ExecuteSqlCallback()
          {
            public final String preExecute(String paramAnonymous2String)
            {
              GMTrace.i(5140270546944L, 38298);
              paramAnonymous2String = localObject2;
              paramAnonymous2String[0] += 1;
              GMTrace.o(5140270546944L, 38298);
              return null;
            }
          });
          if (bool)
          {
            ap.yY();
            com.tencent.mm.u.c.wT().aJT();
            ap.yY();
            com.tencent.mm.u.c.wW().bLv();
            ap.yY();
            com.tencent.mm.u.c.wT().aJV();
            ap.yY();
            com.tencent.mm.u.c.wT().aJU();
            i = 12;
            com.tencent.mm.plugin.report.service.g.oSF.a(181L, i, 1L, true);
            l = System.currentTimeMillis() - l;
            v.i("MicroMsg.SubCoreDBBackup", "execute %d sql and last %d", new Object[] { Integer.valueOf(localObject2[0]), Long.valueOf(l) });
            localObject1 = com.tencent.mm.plugin.report.service.g.oSF;
            if (!bool) {
              break label394;
            }
            i = 1;
            label314:
            ((com.tencent.mm.plugin.report.service.g)localObject1).i(11224, new Object[] { Integer.valueOf(i), localObject2, Long.valueOf(l) });
            ap.vL().bJa();
            if (paramb != null)
            {
              localObject1 = paramb;
              if (!bool) {
                break label399;
              }
            }
          }
          label394:
          label399:
          for (int i = 0;; i = -1)
          {
            ((b)localObject1).kV(i);
            GMTrace.o(5142149595136L, 38312);
            return;
            i = 15;
            break;
            i = 0;
            break label314;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;) {}
        }
      }
    });
    GMTrace.o(5132217483264L, 38238);
    return 0;
  }
  
  public final int a(final String paramString, b paramb)
  {
    try
    {
      GMTrace.i(5131949047808L, 38236);
      paramString = new Runnable()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: ldc2_w 53
          //   3: ldc 55
          //   5: invokestatic 45	com/tencent/gmtrace/GMTrace:i	(JI)V
          //   8: aload_0
          //   9: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
          //   12: aconst_null
          //   13: putfield 59	com/tencent/mm/plugin/dbbackup/d:kDu	Lcom/tencent/wcdb/repair/RecoverKit;
          //   16: invokestatic 65	com/tencent/mm/u/c:wT	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/c;
          //   19: pop
          //   20: invokestatic 69	com/tencent/mm/u/c:wW	()Lcom/tencent/mm/storage/as;
          //   23: pop
          //   24: invokestatic 75	com/tencent/mm/ah/n:GT	()Lcom/tencent/mm/ah/f;
          //   27: pop
          //   28: invokestatic 81	com/tencent/mm/modelvideo/o:KW	()Lcom/tencent/mm/modelvideo/s;
          //   31: pop
          //   32: invokestatic 87	java/lang/System:nanoTime	()J
          //   35: lstore 11
          //   37: new 89	java/lang/StringBuilder
          //   40: dup
          //   41: invokespecial 90	java/lang/StringBuilder:<init>	()V
          //   44: invokestatic 96	com/tencent/mm/compatible/d/p:rA	()Ljava/lang/String;
          //   47: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   50: invokestatic 104	com/tencent/mm/u/c:uH	()I
          //   53: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
          //   56: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   59: invokevirtual 116	java/lang/String:getBytes	()[B
          //   62: astore 14
          //   64: aload 14
          //   66: invokestatic 121	com/tencent/mm/a/g:o	([B)[B
          //   69: astore 17
          //   71: aload 14
          //   73: invokestatic 125	com/tencent/mm/a/g:n	([B)Ljava/lang/String;
          //   76: iconst_0
          //   77: bipush 7
          //   79: invokevirtual 129	java/lang/String:substring	(II)Ljava/lang/String;
          //   82: invokevirtual 116	java/lang/String:getBytes	()[B
          //   85: astore 14
          //   87: ldc -126
          //   89: istore_1
          //   90: invokestatic 136	com/tencent/mm/bj/e:bNC	()Z
          //   93: ifeq +6 -> 99
          //   96: ldc -119
          //   98: istore_1
          //   99: invokestatic 141	com/tencent/mm/u/c:wO	()Lcom/tencent/mm/bj/g;
          //   102: invokevirtual 147	com/tencent/mm/bj/g:bND	()Lcom/tencent/wcdb/database/SQLiteDatabase;
          //   105: invokevirtual 152	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
          //   108: aload 14
          //   110: getstatic 156	com/tencent/mm/plugin/dbbackup/d:kDJ	Lcom/tencent/wcdb/database/SQLiteCipherSpec;
          //   113: aconst_null
          //   114: iload_1
          //   115: aconst_null
          //   116: iconst_0
          //   117: invokestatic 160	com/tencent/wcdb/database/SQLiteDatabase:openDatabase	(Ljava/lang/String;[BLcom/tencent/wcdb/database/SQLiteCipherSpec;Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;ILcom/tencent/wcdb/DatabaseErrorHandler;I)Lcom/tencent/wcdb/database/SQLiteDatabase;
          //   120: astore 15
          //   122: aload 15
          //   124: astore 16
          //   126: aload_0
          //   127: getfield 29	com/tencent/mm/plugin/dbbackup/d$2:kDX	Ljava/lang/String;
          //   130: ifnull +104 -> 234
          //   133: aload 15
          //   135: astore 16
          //   137: aload_0
          //   138: getfield 29	com/tencent/mm/plugin/dbbackup/d$2:kDX	Ljava/lang/String;
          //   141: astore 14
          //   143: iconst_1
          //   144: anewarray 112	java/lang/String
          //   147: dup
          //   148: iconst_0
          //   149: aload 14
          //   151: aastore
          //   152: astore 14
          //   154: bipush -3
          //   156: istore_1
          //   157: aload 15
          //   159: astore 16
          //   161: aload 14
          //   163: arraylength
          //   164: istore_3
          //   165: iconst_0
          //   166: istore_2
          //   167: lconst_0
          //   168: lstore 7
          //   170: bipush -3
          //   172: istore_1
          //   173: lload 7
          //   175: lstore 9
          //   177: iload_2
          //   178: iload_3
          //   179: if_icmpge +408 -> 587
          //   182: aload 14
          //   184: iload_2
          //   185: aaload
          //   186: astore 18
          //   188: lload 7
          //   190: lstore 9
          //   192: aload 15
          //   194: astore 16
          //   196: new 162	java/io/File
          //   199: dup
          //   200: aload 18
          //   202: invokespecial 165	java/io/File:<init>	(Ljava/lang/String;)V
          //   205: astore 19
          //   207: lload 7
          //   209: lstore 9
          //   211: aload 15
          //   213: astore 16
          //   215: aload 19
          //   217: invokevirtual 168	java/io/File:canRead	()Z
          //   220: istore 13
          //   222: iload 13
          //   224: ifne +102 -> 326
          //   227: iload_2
          //   228: iconst_1
          //   229: iadd
          //   230: istore_2
          //   231: goto -58 -> 173
          //   234: aload 15
          //   236: astore 16
          //   238: new 89	java/lang/StringBuilder
          //   241: dup
          //   242: invokespecial 90	java/lang/StringBuilder:<init>	()V
          //   245: invokestatic 171	com/tencent/mm/u/c:vn	()Ljava/lang/String;
          //   248: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   251: ldc -83
          //   253: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   256: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   259: astore 14
          //   261: aload 15
          //   263: astore 16
          //   265: new 89	java/lang/StringBuilder
          //   268: dup
          //   269: invokespecial 90	java/lang/StringBuilder:<init>	()V
          //   272: astore 18
          //   274: aload 15
          //   276: astore 16
          //   278: invokestatic 179	com/tencent/mm/kernel/h:vJ	()Lcom/tencent/mm/kernel/h;
          //   281: pop
          //   282: aload 15
          //   284: astore 16
          //   286: aload 18
          //   288: invokestatic 183	com/tencent/mm/kernel/h:vI	()Lcom/tencent/mm/kernel/e;
          //   291: getfield 188	com/tencent/mm/kernel/e:gXV	Ljava/lang/String;
          //   294: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   297: ldc -66
          //   299: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   302: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   305: astore 18
          //   307: iconst_2
          //   308: anewarray 112	java/lang/String
          //   311: dup
          //   312: iconst_0
          //   313: aload 14
          //   315: aastore
          //   316: dup
          //   317: iconst_1
          //   318: aload 18
          //   320: aastore
          //   321: astore 14
          //   323: goto -169 -> 154
          //   326: lload 7
          //   328: lstore 9
          //   330: aload 15
          //   332: astore 16
          //   334: aload 19
          //   336: invokevirtual 193	java/io/File:length	()J
          //   339: lstore 7
          //   341: lload 7
          //   343: lstore 9
          //   345: aload 15
          //   347: astore 16
          //   349: ldc -61
          //   351: ldc -59
          //   353: iconst_2
          //   354: anewarray 4	java/lang/Object
          //   357: dup
          //   358: iconst_0
          //   359: lload 7
          //   361: invokestatic 203	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   364: aastore
          //   365: dup
          //   366: iconst_1
          //   367: aload_0
          //   368: getfield 31	com/tencent/mm/plugin/dbbackup/d$2:kDY	J
          //   371: invokestatic 203	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   374: aastore
          //   375: invokestatic 208	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   378: lload 7
          //   380: lstore 9
          //   382: aload 15
          //   384: astore 16
          //   386: aload_0
          //   387: getfield 31	com/tencent/mm/plugin/dbbackup/d$2:kDY	J
          //   390: ldc2_w 209
          //   393: lload 7
          //   395: lmul
          //   396: lcmp
          //   397: ifge +98 -> 495
          //   400: lload 7
          //   402: lstore 9
          //   404: aload 15
          //   406: astore 16
          //   408: aload_0
          //   409: getfield 33	com/tencent/mm/plugin/dbbackup/d$2:kDK	Lcom/tencent/mm/plugin/dbbackup/b;
          //   412: ifnull +22 -> 434
          //   415: lload 7
          //   417: lstore 9
          //   419: aload 15
          //   421: astore 16
          //   423: aload_0
          //   424: getfield 33	com/tencent/mm/plugin/dbbackup/d$2:kDK	Lcom/tencent/mm/plugin/dbbackup/b;
          //   427: bipush -2
          //   429: invokeinterface 216 2 0
          //   434: aload_0
          //   435: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
          //   438: getfield 59	com/tencent/mm/plugin/dbbackup/d:kDu	Lcom/tencent/wcdb/repair/RecoverKit;
          //   441: ifnull +21 -> 462
          //   444: aload_0
          //   445: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
          //   448: getfield 59	com/tencent/mm/plugin/dbbackup/d:kDu	Lcom/tencent/wcdb/repair/RecoverKit;
          //   451: invokevirtual 221	com/tencent/wcdb/repair/RecoverKit:release	()V
          //   454: aload_0
          //   455: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
          //   458: aconst_null
          //   459: putfield 59	com/tencent/mm/plugin/dbbackup/d:kDu	Lcom/tencent/wcdb/repair/RecoverKit;
          //   462: aload 15
          //   464: ifnull +8 -> 472
          //   467: aload 15
          //   469: invokevirtual 224	com/tencent/wcdb/database/SQLiteDatabase:close	()V
          //   472: aload_0
          //   473: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
          //   476: iconst_0
          //   477: putfield 228	com/tencent/mm/plugin/dbbackup/d:kDw	Z
          //   480: invokestatic 234	com/tencent/mm/u/ap:vL	()Lcom/tencent/mm/sdk/platformtools/ae;
          //   483: invokevirtual 239	com/tencent/mm/sdk/platformtools/ae:bJa	()V
          //   486: ldc2_w 53
          //   489: ldc 55
          //   491: invokestatic 48	com/tencent/gmtrace/GMTrace:o	(JI)V
          //   494: return
          //   495: lload 7
          //   497: lstore 9
          //   499: aload 15
          //   501: astore 16
          //   503: getstatic 245	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
          //   506: sipush 11098
          //   509: iconst_2
          //   510: anewarray 4	java/lang/Object
          //   513: dup
          //   514: iconst_0
          //   515: sipush 10004
          //   518: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   521: aastore
          //   522: dup
          //   523: iconst_1
          //   524: ldc -4
          //   526: iconst_2
          //   527: anewarray 4	java/lang/Object
          //   530: dup
          //   531: iconst_0
          //   532: lload 7
          //   534: invokestatic 203	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   537: aastore
          //   538: dup
          //   539: iconst_1
          //   540: aload_0
          //   541: getfield 31	com/tencent/mm/plugin/dbbackup/d$2:kDY	J
          //   544: invokestatic 203	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   547: aastore
          //   548: invokestatic 256	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
          //   551: aastore
          //   552: invokevirtual 259	com/tencent/mm/plugin/report/service/g:i	(I[Ljava/lang/Object;)V
          //   555: lload 7
          //   557: lstore 9
          //   559: aload 15
          //   561: astore 16
          //   563: aload_0
          //   564: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
          //   567: new 218	com/tencent/wcdb/repair/RecoverKit
          //   570: dup
          //   571: aload 15
          //   573: aload 18
          //   575: aload 17
          //   577: invokespecial 262	com/tencent/wcdb/repair/RecoverKit:<init>	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;[B)V
          //   580: putfield 59	com/tencent/mm/plugin/dbbackup/d:kDu	Lcom/tencent/wcdb/repair/RecoverKit;
          //   583: lload 7
          //   585: lstore 9
          //   587: aload 15
          //   589: astore 16
          //   591: aload_0
          //   592: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
          //   595: getfield 59	com/tencent/mm/plugin/dbbackup/d:kDu	Lcom/tencent/wcdb/repair/RecoverKit;
          //   598: astore 14
          //   600: aload 14
          //   602: ifnonnull +221 -> 823
          //   605: bipush -3
          //   607: istore_2
          //   608: aload 15
          //   610: astore 14
          //   612: iload_2
          //   613: istore_1
          //   614: aload 15
          //   616: astore 16
          //   618: getstatic 245	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
          //   621: ldc2_w 263
          //   624: ldc2_w 265
          //   627: lconst_1
          //   628: iconst_1
          //   629: invokevirtual 269	com/tencent/mm/plugin/report/service/g:a	(JJJZ)V
          //   632: aload 15
          //   634: astore 14
          //   636: iload_2
          //   637: istore_1
          //   638: aload 15
          //   640: astore 16
          //   642: new 271	java/lang/RuntimeException
          //   645: dup
          //   646: invokespecial 272	java/lang/RuntimeException:<init>	()V
          //   649: athrow
          //   650: astore 16
          //   652: aload 14
          //   654: astore 15
          //   656: aload 16
          //   658: astore 14
          //   660: aload 15
          //   662: astore 16
          //   664: ldc -61
          //   666: aload 14
          //   668: ldc_w 274
          //   671: iconst_0
          //   672: anewarray 4	java/lang/Object
          //   675: invokestatic 278	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   678: aload 15
          //   680: astore 16
          //   682: aload_0
          //   683: getfield 33	com/tencent/mm/plugin/dbbackup/d$2:kDK	Lcom/tencent/mm/plugin/dbbackup/b;
          //   686: ifnull +17 -> 703
          //   689: aload 15
          //   691: astore 16
          //   693: aload_0
          //   694: getfield 33	com/tencent/mm/plugin/dbbackup/d$2:kDK	Lcom/tencent/mm/plugin/dbbackup/b;
          //   697: iload_1
          //   698: invokeinterface 216 2 0
          //   703: aload 15
          //   705: astore 16
          //   707: getstatic 245	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
          //   710: ldc2_w 263
          //   713: ldc2_w 279
          //   716: lconst_1
          //   717: iconst_1
          //   718: invokevirtual 269	com/tencent/mm/plugin/report/service/g:a	(JJJZ)V
          //   721: aload_0
          //   722: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
          //   725: getfield 59	com/tencent/mm/plugin/dbbackup/d:kDu	Lcom/tencent/wcdb/repair/RecoverKit;
          //   728: ifnull +21 -> 749
          //   731: aload_0
          //   732: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
          //   735: getfield 59	com/tencent/mm/plugin/dbbackup/d:kDu	Lcom/tencent/wcdb/repair/RecoverKit;
          //   738: invokevirtual 221	com/tencent/wcdb/repair/RecoverKit:release	()V
          //   741: aload_0
          //   742: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
          //   745: aconst_null
          //   746: putfield 59	com/tencent/mm/plugin/dbbackup/d:kDu	Lcom/tencent/wcdb/repair/RecoverKit;
          //   749: aload 15
          //   751: ifnull +8 -> 759
          //   754: aload 15
          //   756: invokevirtual 224	com/tencent/wcdb/database/SQLiteDatabase:close	()V
          //   759: aload_0
          //   760: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
          //   763: iconst_0
          //   764: putfield 228	com/tencent/mm/plugin/dbbackup/d:kDw	Z
          //   767: invokestatic 234	com/tencent/mm/u/ap:vL	()Lcom/tencent/mm/sdk/platformtools/ae;
          //   770: invokevirtual 239	com/tencent/mm/sdk/platformtools/ae:bJa	()V
          //   773: ldc2_w 53
          //   776: ldc 55
          //   778: invokestatic 48	com/tencent/gmtrace/GMTrace:o	(JI)V
          //   781: return
          //   782: astore 18
          //   784: aload 15
          //   786: astore 16
          //   788: ldc -61
          //   790: new 89	java/lang/StringBuilder
          //   793: dup
          //   794: ldc_w 282
          //   797: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   800: aload 18
          //   802: invokevirtual 286	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   805: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   808: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   811: invokestatic 290	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   814: iconst_m1
          //   815: istore_1
          //   816: lload 9
          //   818: lstore 7
          //   820: goto -593 -> 227
          //   823: aload 15
          //   825: astore 16
          //   827: aload_0
          //   828: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
          //   831: getfield 59	com/tencent/mm/plugin/dbbackup/d:kDu	Lcom/tencent/wcdb/repair/RecoverKit;
          //   834: iconst_0
          //   835: invokevirtual 293	com/tencent/wcdb/repair/RecoverKit:run	(Z)I
          //   838: istore 4
          //   840: aload 15
          //   842: astore 14
          //   844: iload 4
          //   846: istore_1
          //   847: aload 15
          //   849: astore 16
          //   851: invokestatic 296	com/tencent/mm/plugin/dbbackup/d:akD	()V
          //   854: aload 15
          //   856: astore 14
          //   858: iload 4
          //   860: istore_1
          //   861: aload 15
          //   863: astore 16
          //   865: invokestatic 87	java/lang/System:nanoTime	()J
          //   868: lload 11
          //   870: lsub
          //   871: lstore 7
          //   873: aload 15
          //   875: astore 14
          //   877: iload 4
          //   879: istore_1
          //   880: aload 15
          //   882: astore 16
          //   884: aload_0
          //   885: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
          //   888: getfield 59	com/tencent/mm/plugin/dbbackup/d:kDu	Lcom/tencent/wcdb/repair/RecoverKit;
          //   891: invokevirtual 299	com/tencent/wcdb/repair/RecoverKit:successCount	()I
          //   894: istore 5
          //   896: aload 15
          //   898: astore 14
          //   900: iload 4
          //   902: istore_1
          //   903: aload 15
          //   905: astore 16
          //   907: aload_0
          //   908: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
          //   911: getfield 59	com/tencent/mm/plugin/dbbackup/d:kDu	Lcom/tencent/wcdb/repair/RecoverKit;
          //   914: invokevirtual 302	com/tencent/wcdb/repair/RecoverKit:failureCount	()I
          //   917: istore 6
          //   919: aload 15
          //   921: astore 14
          //   923: iload 4
          //   925: istore_1
          //   926: aload 15
          //   928: astore 16
          //   930: aload_0
          //   931: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
          //   934: getfield 59	com/tencent/mm/plugin/dbbackup/d:kDu	Lcom/tencent/wcdb/repair/RecoverKit;
          //   937: invokevirtual 305	com/tencent/wcdb/repair/RecoverKit:lastError	()Ljava/lang/String;
          //   940: astore 19
          //   942: aload 15
          //   944: astore 14
          //   946: iload 4
          //   948: istore_1
          //   949: aload 15
          //   951: astore 16
          //   953: aload_0
          //   954: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
          //   957: getfield 59	com/tencent/mm/plugin/dbbackup/d:kDu	Lcom/tencent/wcdb/repair/RecoverKit;
          //   960: invokevirtual 221	com/tencent/wcdb/repair/RecoverKit:release	()V
          //   963: aload 15
          //   965: astore 14
          //   967: iload 4
          //   969: istore_1
          //   970: aload 15
          //   972: astore 16
          //   974: aload_0
          //   975: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
          //   978: aconst_null
          //   979: putfield 59	com/tencent/mm/plugin/dbbackup/d:kDu	Lcom/tencent/wcdb/repair/RecoverKit;
          //   982: aload 15
          //   984: astore 14
          //   986: iload 4
          //   988: istore_1
          //   989: aload 15
          //   991: astore 16
          //   993: aload 15
          //   995: invokevirtual 224	com/tencent/wcdb/database/SQLiteDatabase:close	()V
          //   998: aconst_null
          //   999: astore 18
          //   1001: aconst_null
          //   1002: astore 17
          //   1004: iload 4
          //   1006: ifne +276 -> 1282
          //   1009: ldc_w 307
          //   1012: astore 15
          //   1014: aload 17
          //   1016: astore 14
          //   1018: iload 4
          //   1020: istore_1
          //   1021: aload 18
          //   1023: astore 16
          //   1025: ldc -61
          //   1027: ldc_w 309
          //   1030: iconst_4
          //   1031: anewarray 4	java/lang/Object
          //   1034: dup
          //   1035: iconst_0
          //   1036: aload 15
          //   1038: aastore
          //   1039: dup
          //   1040: iconst_1
          //   1041: lload 7
          //   1043: l2f
          //   1044: ldc_w 310
          //   1047: fdiv
          //   1048: invokestatic 315	java/lang/Float:valueOf	(F)Ljava/lang/Float;
          //   1051: aastore
          //   1052: dup
          //   1053: iconst_2
          //   1054: iload 5
          //   1056: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1059: aastore
          //   1060: dup
          //   1061: iconst_3
          //   1062: iload 6
          //   1064: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1067: aastore
          //   1068: invokestatic 208	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1071: iload 4
          //   1073: ifne +372 -> 1445
          //   1076: sipush 10005
          //   1079: istore_3
          //   1080: bipush 22
          //   1082: istore_2
          //   1083: aload 17
          //   1085: astore 14
          //   1087: iload 4
          //   1089: istore_1
          //   1090: aload 18
          //   1092: astore 16
          //   1094: getstatic 245	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
          //   1097: sipush 11098
          //   1100: iconst_2
          //   1101: anewarray 4	java/lang/Object
          //   1104: dup
          //   1105: iconst_0
          //   1106: iload_3
          //   1107: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1110: aastore
          //   1111: dup
          //   1112: iconst_1
          //   1113: ldc_w 317
          //   1116: iconst_4
          //   1117: anewarray 4	java/lang/Object
          //   1120: dup
          //   1121: iconst_0
          //   1122: lload 9
          //   1124: invokestatic 203	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   1127: aastore
          //   1128: dup
          //   1129: iconst_1
          //   1130: lload 7
          //   1132: ldc2_w 318
          //   1135: ldiv
          //   1136: invokestatic 203	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   1139: aastore
          //   1140: dup
          //   1141: iconst_2
          //   1142: iload 5
          //   1144: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1147: aastore
          //   1148: dup
          //   1149: iconst_3
          //   1150: iload 6
          //   1152: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1155: aastore
          //   1156: invokestatic 256	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
          //   1159: aastore
          //   1160: invokevirtual 259	com/tencent/mm/plugin/report/service/g:i	(I[Ljava/lang/Object;)V
          //   1163: iload_2
          //   1164: iflt +27 -> 1191
          //   1167: aload 17
          //   1169: astore 14
          //   1171: iload 4
          //   1173: istore_1
          //   1174: aload 18
          //   1176: astore 16
          //   1178: getstatic 245	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
          //   1181: ldc2_w 263
          //   1184: iload_2
          //   1185: i2l
          //   1186: lconst_1
          //   1187: iconst_1
          //   1188: invokevirtual 269	com/tencent/mm/plugin/report/service/g:a	(JJJZ)V
          //   1191: aload 17
          //   1193: astore 14
          //   1195: iload 4
          //   1197: istore_1
          //   1198: aload 18
          //   1200: astore 16
          //   1202: aload_0
          //   1203: getfield 33	com/tencent/mm/plugin/dbbackup/d$2:kDK	Lcom/tencent/mm/plugin/dbbackup/b;
          //   1206: ifnull +25 -> 1231
          //   1209: aload 17
          //   1211: astore 14
          //   1213: iload 4
          //   1215: istore_1
          //   1216: aload 18
          //   1218: astore 16
          //   1220: aload_0
          //   1221: getfield 33	com/tencent/mm/plugin/dbbackup/d$2:kDK	Lcom/tencent/mm/plugin/dbbackup/b;
          //   1224: iload 4
          //   1226: invokeinterface 216 2 0
          //   1231: aload_0
          //   1232: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
          //   1235: getfield 59	com/tencent/mm/plugin/dbbackup/d:kDu	Lcom/tencent/wcdb/repair/RecoverKit;
          //   1238: ifnull +21 -> 1259
          //   1241: aload_0
          //   1242: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
          //   1245: getfield 59	com/tencent/mm/plugin/dbbackup/d:kDu	Lcom/tencent/wcdb/repair/RecoverKit;
          //   1248: invokevirtual 221	com/tencent/wcdb/repair/RecoverKit:release	()V
          //   1251: aload_0
          //   1252: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
          //   1255: aconst_null
          //   1256: putfield 59	com/tencent/mm/plugin/dbbackup/d:kDu	Lcom/tencent/wcdb/repair/RecoverKit;
          //   1259: aload_0
          //   1260: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
          //   1263: iconst_0
          //   1264: putfield 228	com/tencent/mm/plugin/dbbackup/d:kDw	Z
          //   1267: invokestatic 234	com/tencent/mm/u/ap:vL	()Lcom/tencent/mm/sdk/platformtools/ae;
          //   1270: invokevirtual 239	com/tencent/mm/sdk/platformtools/ae:bJa	()V
          //   1273: ldc2_w 53
          //   1276: ldc 55
          //   1278: invokestatic 48	com/tencent/gmtrace/GMTrace:o	(JI)V
          //   1281: return
          //   1282: iload 4
          //   1284: iconst_1
          //   1285: if_icmpne +152 -> 1437
          //   1288: ldc_w 321
          //   1291: astore 15
          //   1293: goto -279 -> 1014
          //   1296: sipush 10007
          //   1299: istore_3
          //   1300: bipush 23
          //   1302: istore_2
          //   1303: aload 17
          //   1305: astore 14
          //   1307: iload 4
          //   1309: istore_1
          //   1310: aload 18
          //   1312: astore 16
          //   1314: getstatic 245	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
          //   1317: ldc_w 323
          //   1320: new 89	java/lang/StringBuilder
          //   1323: dup
          //   1324: ldc_w 325
          //   1327: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   1330: aload 19
          //   1332: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   1335: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   1338: aconst_null
          //   1339: invokevirtual 329	com/tencent/mm/plugin/report/service/g:d	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
          //   1342: goto -259 -> 1083
          //   1345: astore 14
          //   1347: aload_0
          //   1348: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
          //   1351: getfield 59	com/tencent/mm/plugin/dbbackup/d:kDu	Lcom/tencent/wcdb/repair/RecoverKit;
          //   1354: ifnull +21 -> 1375
          //   1357: aload_0
          //   1358: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
          //   1361: getfield 59	com/tencent/mm/plugin/dbbackup/d:kDu	Lcom/tencent/wcdb/repair/RecoverKit;
          //   1364: invokevirtual 221	com/tencent/wcdb/repair/RecoverKit:release	()V
          //   1367: aload_0
          //   1368: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
          //   1371: aconst_null
          //   1372: putfield 59	com/tencent/mm/plugin/dbbackup/d:kDu	Lcom/tencent/wcdb/repair/RecoverKit;
          //   1375: aload 16
          //   1377: ifnull +8 -> 1385
          //   1380: aload 16
          //   1382: invokevirtual 224	com/tencent/wcdb/database/SQLiteDatabase:close	()V
          //   1385: aload_0
          //   1386: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
          //   1389: iconst_0
          //   1390: putfield 228	com/tencent/mm/plugin/dbbackup/d:kDw	Z
          //   1393: invokestatic 234	com/tencent/mm/u/ap:vL	()Lcom/tencent/mm/sdk/platformtools/ae;
          //   1396: invokevirtual 239	com/tencent/mm/sdk/platformtools/ae:bJa	()V
          //   1399: aload 14
          //   1401: athrow
          //   1402: astore 14
          //   1404: aconst_null
          //   1405: astore 16
          //   1407: goto -60 -> 1347
          //   1410: astore 14
          //   1412: aconst_null
          //   1413: astore 15
          //   1415: iconst_m1
          //   1416: istore_1
          //   1417: goto -757 -> 660
          //   1420: astore 14
          //   1422: iconst_m1
          //   1423: istore_1
          //   1424: goto -764 -> 660
          //   1427: astore 14
          //   1429: goto -769 -> 660
          //   1432: astore 14
          //   1434: goto -774 -> 660
          //   1437: ldc_w 331
          //   1440: astore 15
          //   1442: goto -428 -> 1014
          //   1445: iload 4
          //   1447: iconst_1
          //   1448: if_icmpne -152 -> 1296
          //   1451: sipush 10006
          //   1454: istore_3
          //   1455: iconst_m1
          //   1456: istore_2
          //   1457: goto -374 -> 1083
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	1460	0	this	2
          //   89	1335	1	i	int
          //   166	1291	2	j	int
          //   164	1291	3	k	int
          //   838	611	4	m	int
          //   894	249	5	n	int
          //   917	234	6	i1	int
          //   168	963	7	l1	long
          //   175	948	9	l2	long
          //   35	834	11	l3	long
          //   220	3	13	bool	boolean
          //   62	1244	14	localObject1	Object
          //   1345	55	14	localObject2	Object
          //   1402	1	14	localObject3	Object
          //   1410	1	14	localException1	Exception
          //   1420	1	14	localException2	Exception
          //   1427	1	14	localException3	Exception
          //   1432	1	14	localException4	Exception
          //   120	1321	15	localObject4	Object
          //   124	517	16	localObject5	Object
          //   650	7	16	localException5	Exception
          //   662	744	16	localObject6	Object
          //   69	1235	17	arrayOfByte	byte[]
          //   186	388	18	localObject7	Object
          //   782	19	18	localException6	Exception
          //   999	312	18	localObject8	Object
          //   205	1126	19	localObject9	Object
          // Exception table:
          //   from	to	target	type
          //   618	632	650	java/lang/Exception
          //   642	650	650	java/lang/Exception
          //   851	854	650	java/lang/Exception
          //   865	873	650	java/lang/Exception
          //   884	896	650	java/lang/Exception
          //   907	919	650	java/lang/Exception
          //   930	942	650	java/lang/Exception
          //   953	963	650	java/lang/Exception
          //   974	982	650	java/lang/Exception
          //   993	998	650	java/lang/Exception
          //   1025	1071	650	java/lang/Exception
          //   1094	1163	650	java/lang/Exception
          //   1178	1191	650	java/lang/Exception
          //   1202	1209	650	java/lang/Exception
          //   1220	1231	650	java/lang/Exception
          //   1314	1342	650	java/lang/Exception
          //   196	207	782	java/lang/Exception
          //   215	222	782	java/lang/Exception
          //   334	341	782	java/lang/Exception
          //   349	378	782	java/lang/Exception
          //   386	400	782	java/lang/Exception
          //   408	415	782	java/lang/Exception
          //   423	434	782	java/lang/Exception
          //   503	555	782	java/lang/Exception
          //   563	583	782	java/lang/Exception
          //   126	133	1345	finally
          //   137	143	1345	finally
          //   161	165	1345	finally
          //   196	207	1345	finally
          //   215	222	1345	finally
          //   238	261	1345	finally
          //   265	274	1345	finally
          //   278	282	1345	finally
          //   286	307	1345	finally
          //   334	341	1345	finally
          //   349	378	1345	finally
          //   386	400	1345	finally
          //   408	415	1345	finally
          //   423	434	1345	finally
          //   503	555	1345	finally
          //   563	583	1345	finally
          //   591	600	1345	finally
          //   618	632	1345	finally
          //   642	650	1345	finally
          //   664	678	1345	finally
          //   682	689	1345	finally
          //   693	703	1345	finally
          //   707	721	1345	finally
          //   788	814	1345	finally
          //   827	840	1345	finally
          //   851	854	1345	finally
          //   865	873	1345	finally
          //   884	896	1345	finally
          //   907	919	1345	finally
          //   930	942	1345	finally
          //   953	963	1345	finally
          //   974	982	1345	finally
          //   993	998	1345	finally
          //   1025	1071	1345	finally
          //   1094	1163	1345	finally
          //   1178	1191	1345	finally
          //   1202	1209	1345	finally
          //   1220	1231	1345	finally
          //   1314	1342	1345	finally
          //   16	87	1402	finally
          //   90	96	1402	finally
          //   99	122	1402	finally
          //   16	87	1410	java/lang/Exception
          //   90	96	1410	java/lang/Exception
          //   99	122	1410	java/lang/Exception
          //   126	133	1420	java/lang/Exception
          //   137	143	1420	java/lang/Exception
          //   238	261	1420	java/lang/Exception
          //   265	274	1420	java/lang/Exception
          //   278	282	1420	java/lang/Exception
          //   286	307	1420	java/lang/Exception
          //   161	165	1427	java/lang/Exception
          //   591	600	1432	java/lang/Exception
          //   788	814	1432	java/lang/Exception
          //   827	840	1432	java/lang/Exception
        }
      };
      this.kDw = true;
      ap.vL().bIY();
      ap.vL().H(paramString);
      GMTrace.o(5131949047808L, 38236);
      return 0;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final boolean a(final boolean paramBoolean, final b paramb)
  {
    GMTrace.i(5131680612352L, 38234);
    if (this.kDw)
    {
      v.i("MicroMsg.SubCoreDBBackup", "Backup or recover task is in progress, %s canceled", new Object[] { "backup" });
      GMTrace.o(5131680612352L, 38234);
      return false;
    }
    final com.tencent.mm.u.c localc = ap.yY();
    final String str1 = com.tencent.mm.u.c.vp();
    final SQLiteDatabase localSQLiteDatabase = com.tencent.mm.u.c.wO().bND();
    final String str2 = str1 + ".bak";
    final String str3 = str2 + ".tmp";
    final String str4 = str1 + ".sm";
    final String str5 = str4 + ".tmp";
    int j = 8;
    final int i = j;
    boolean bool = paramBoolean;
    long l2;
    long l3;
    long l4;
    final Object localObject;
    if (paramBoolean)
    {
      if (FileOp.aO(str2))
      {
        i = 24;
        FileOp.p(str2, str3);
        bool = paramBoolean;
      }
    }
    else
    {
      l2 = -1L;
      l3 = -1L;
      l4 = -1L;
      localObject = localSQLiteDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(msgId) FROM message;", null, null);
      if (!((Cursor)localObject).moveToFirst()) {
        break label889;
      }
    }
    label415:
    label628:
    label716:
    label883:
    label889:
    for (long l1 = ((Cursor)localObject).getLong(0);; l1 = -1L)
    {
      ((Cursor)localObject).close();
      localObject = localSQLiteDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(id) FROM ImgInfo2;", null, null);
      if (((Cursor)localObject).moveToFirst()) {
        l2 = ((Cursor)localObject).getLong(0);
      }
      ((Cursor)localObject).close();
      localObject = localSQLiteDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(rowid) FROM videoinfo2;", null, null);
      if (((Cursor)localObject).moveToFirst()) {
        l3 = ((Cursor)localObject).getLong(0);
      }
      ((Cursor)localObject).close();
      localObject = localSQLiteDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(rowid) FROM EmojiInfo;", null, null);
      if (((Cursor)localObject).moveToFirst()) {
        l4 = ((Cursor)localObject).getLong(0);
      }
      ((Cursor)localObject).close();
      final long[] arrayOfLong = new long[4];
      arrayOfLong[0] = l1;
      arrayOfLong[1] = l2;
      arrayOfLong[2] = l3;
      arrayOfLong[3] = l4;
      final String[] arrayOfString;
      if (bool)
      {
        localObject = tz(str1);
        if ((localObject == null) || (localObject.length < 4)) {
          break label716;
        }
        arrayOfString = new String[12];
        arrayOfString[0] = "message";
        arrayOfString[1] = String.format("msgId > %d AND msgId <= %d", new Object[] { Long.valueOf(localObject[0]), Long.valueOf(arrayOfLong[0]) });
        arrayOfString[2] = "ImgInfo2";
        arrayOfString[3] = String.format("id > %d AND id <= %d", new Object[] { Long.valueOf(localObject[1]), Long.valueOf(arrayOfLong[1]) });
        arrayOfString[4] = "videoinfo2";
        arrayOfString[5] = String.format("rowid > %d AND rowid <= %d", new Object[] { Long.valueOf(localObject[2]), Long.valueOf(arrayOfLong[2]) });
        arrayOfString[6] = "EmojiInfo";
        arrayOfString[7] = String.format("rowid > %d AND rowid <= %d", new Object[] { Long.valueOf(localObject[3]), Long.valueOf(arrayOfLong[3]) });
        arrayOfString[8] = "conversation";
        arrayOfString[9] = null;
        arrayOfString[10] = "rconversation";
        arrayOfString[11] = null;
        if (localObject != null) {
          break label883;
        }
      }
      for (paramBoolean = false;; paramBoolean = bool)
      {
        if (this.kDD) {
          i |= 0x3;
        }
        for (;;)
        {
          paramb = new Runnable()
          {
            public final void run()
            {
              GMTrace.i(5141075853312L, 38304);
              if (!d.this.kDw)
              {
                if (paramb != null) {
                  paramb.kV(1);
                }
                GMTrace.o(5141075853312L, 38304);
                return;
              }
              d.this.kDt = null;
              for (;;)
              {
                Object localObject3;
                long l1;
                label223:
                label278:
                label293:
                long l2;
                label308:
                int i;
                label351:
                int k;
                int j;
                try
                {
                  long l3 = System.nanoTime();
                  localObject3 = com.tencent.mm.a.g.o((p.rA() + com.tencent.mm.u.c.uH()).getBytes());
                  Object localObject1 = new File(str4);
                  File localFile;
                  if ((!paramBoolean) || (!((File)localObject1).exists()))
                  {
                    boolean bool = RepairKit.MasterInfo.save(localSQLiteDatabase, str5, (byte[])localObject3);
                    localFile = new File(str5);
                    if (bool)
                    {
                      ((File)localObject1).delete();
                      bool = localFile.renameTo((File)localObject1);
                      l1 = System.nanoTime();
                      if (!bool) {
                        break label1156;
                      }
                      localObject1 = "SUCCEEDED";
                      v.i("MicroMsg.SubCoreDBBackup", "Master table backup %s, elapsed %.3f", new Object[] { localObject1, Float.valueOf((float)(l1 - l3) / 1.0E9F) });
                      localObject1 = com.tencent.mm.plugin.report.service.g.oSF;
                      if (!bool) {
                        break label1164;
                      }
                      l1 = 24L;
                      ((com.tencent.mm.plugin.report.service.g)localObject1).a(181L, l1, 1L, false);
                    }
                  }
                  else
                  {
                    long l4 = new File(str1).length();
                    long l5 = new File(str3).length();
                    if (!paramBoolean) {
                      break label1172;
                    }
                    localObject1 = "incremental";
                    if (localObject == null) {
                      break label1180;
                    }
                    l1 = localObject[0];
                    if (arrayOfLong == null) {
                      break label1186;
                    }
                    l2 = arrayOfLong[0];
                    v.i("MicroMsg.SubCoreDBBackup", "Backup started [%s, cursor: %d ~ %d]", new Object[] { localObject1, Long.valueOf(l1), Long.valueOf(l2) });
                    if (!paramBoolean) {
                      break label1192;
                    }
                    i = 10011;
                    com.tencent.mm.plugin.report.service.g.oSF.i(11098, new Object[] { Integer.valueOf(i), String.format("%d|%d|%s", new Object[] { Long.valueOf(l4), Long.valueOf(l5), d.this.kDE.format(new Date()) }) });
                    d.this.kDt = new BackupKit(localSQLiteDatabase, str3, (byte[])localObject3, i, arrayOfString);
                    k = d.this.kDt.run();
                    l1 = System.nanoTime() - l3;
                    localObject1 = new File(str3);
                    l2 = ((File)localObject1).length();
                    if (k != 0) {
                      continue;
                    }
                    d.a(str1, arrayOfLong);
                    localObject3 = new File(str2);
                    ((File)localObject3).delete();
                    ((File)localObject1).renameTo((File)localObject3);
                    if (!paramBoolean) {
                      break label1199;
                    }
                    i = 19;
                    j = 10012;
                    label547:
                    if (!paramBoolean) {
                      break label1229;
                    }
                    localObject3 = "incremental";
                    break label1144;
                    label561:
                    v.i("MicroMsg.SubCoreDBBackup", "Database %s backup %s, elapsed %.2f seconds.", new Object[] { localObject3, localObject1, Float.valueOf((float)l1 / 1.0E9F) });
                    com.tencent.mm.plugin.report.service.g.oSF.a(181L, i, 1L, false);
                    com.tencent.mm.plugin.report.service.g.oSF.i(11098, new Object[] { Integer.valueOf(j), String.format("%d|%d|%d|%d|%d|%s", new Object[] { Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(l2), Integer.valueOf(d.this.kDt.statementCount()), Long.valueOf(l1 / 1000000L), d.this.kDE.format(new Date()) }) });
                    if (paramb != null) {
                      paramb.kV(k);
                    }
                    d.this.kDt.release();
                    d.this.kDt = null;
                    localObject1 = new StringBuilder();
                    h.vJ();
                    FileOp.km(h.vI().gXV + "dbback");
                    localObject1 = str4;
                    localObject3 = new StringBuilder();
                    h.vJ();
                    FileOp.p((String)localObject1, h.vI().gXV + "dbback/EnMicroMsg.db.sm");
                    localObject1 = str2;
                    localObject3 = new StringBuilder();
                    h.vJ();
                    FileOp.p((String)localObject1, h.vI().gXV + "dbback/EnMicroMsg.db.bak");
                    if (d.this.kDt != null)
                    {
                      d.this.kDt.release();
                      d.this.kDt = null;
                    }
                    d.this.kDw = false;
                    GMTrace.o(5141075853312L, 38304);
                    return;
                  }
                  localFile.delete();
                  continue;
                  ((File)localObject1).delete();
                  if (k == 1)
                  {
                    if (paramBoolean)
                    {
                      i = 20;
                      j = 10013;
                    }
                  }
                  else
                  {
                    if (!paramBoolean) {
                      break label1219;
                    }
                    i = 21;
                    j = 10014;
                    continue;
                    localObject1 = "failed";
                    continue;
                    com.tencent.mm.plugin.report.service.g localg;
                    if (k != 0) {
                      break label1237;
                    }
                  }
                }
                catch (Exception localException)
                {
                  v.printErrStackTrace("MicroMsg.SubCoreDBBackup", localException, "Failed to start database backup, path: %s", new Object[] { str1 });
                  if (paramb != null) {
                    paramb.kV(-1);
                  }
                  localg = com.tencent.mm.plugin.report.service.g.oSF;
                  if (paramBoolean)
                  {
                    l1 = 18L;
                    localg.a(181L, l1, 1L, false);
                    if (d.this.kDt != null)
                    {
                      d.this.kDt.release();
                      d.this.kDt = null;
                    }
                    d.this.kDw = false;
                    GMTrace.o(5141075853312L, 38304);
                    return;
                  }
                  l1 = 21L;
                  continue;
                }
                finally
                {
                  if (d.this.kDt != null)
                  {
                    d.this.kDt.release();
                    d.this.kDt = null;
                  }
                  d.this.kDw = false;
                }
                label1144:
                String str;
                for (;;)
                {
                  str = "succeeded";
                  break label561;
                  label1156:
                  str = "FAILED";
                  break;
                  label1164:
                  l1 = 25L;
                  break label223;
                  label1172:
                  str = "new";
                  break label278;
                  label1180:
                  l1 = 0L;
                  break label293;
                  label1186:
                  l2 = 0L;
                  break label308;
                  label1192:
                  i = 10000;
                  break label351;
                  label1199:
                  i = 16;
                  j = 10001;
                  break label547;
                  i = 17;
                  j = 10002;
                  break label547;
                  label1219:
                  i = 18;
                  j = 10003;
                  break label547;
                  label1229:
                  localObject3 = "new";
                }
                label1237:
                if (k == 1) {
                  str = "canceled";
                }
              }
            }
          };
          this.kDw = true;
          com.tencent.mm.sdk.f.e.post(paramb, "DB Backup");
          GMTrace.o(5131680612352L, 38234);
          return true;
          bool = false;
          i = j;
          break;
          localObject = null;
          break label415;
          arrayOfString = new String[12];
          arrayOfString[0] = "message";
          arrayOfString[1] = ("msgId <= " + arrayOfLong[0]);
          arrayOfString[2] = "ImgInfo2";
          arrayOfString[3] = ("id <= " + arrayOfLong[1]);
          arrayOfString[4] = "videoinfo2";
          arrayOfString[5] = ("rowid <= " + arrayOfLong[2]);
          arrayOfString[6] = "EmojiInfo";
          arrayOfString[7] = ("rowid <= " + arrayOfLong[3]);
          arrayOfString[8] = "conversation";
          arrayOfString[9] = null;
          arrayOfString[10] = "rconversation";
          arrayOfString[11] = null;
          break label628;
        }
      }
    }
  }
  
  public final void aM(boolean paramBoolean)
  {
    GMTrace.i(5132754354176L, 38242);
    final Object localObject1 = h.vI().cachePath + "account.lck";
    this.kDF = ((String)localObject1);
    try
    {
      this.kDG = new FLock((String)localObject1);
      int i;
      Object localObject3;
      if (this.kDG.bIt())
      {
        localObject2 = new FileWriter((String)localObject1);
        ((FileWriter)localObject2).write(Integer.toString(Process.myPid()));
        ((FileWriter)localObject2).close();
        v.i("MicroMsg.DuplicateDetect", "No account multiple instances detected.");
        ap.yY();
        localObject1 = com.tencent.mm.u.c.vr();
        SQLiteDatabase localSQLiteDatabase = com.tencent.mm.u.c.wO().bND();
        this.kDB = ((t)localObject1).yw(237569);
        this.kDC = ((t)localObject1).getInt(237570, 10);
        if (((t)localObject1).getInt(237571, 0) != 0)
        {
          paramBoolean = true;
          this.kDD = paramBoolean;
          localObject1 = aa.getContext();
          localObject2 = ((Context)localObject1).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
          if (localObject2 == null) {
            break label1042;
          }
          i = ((Intent)localObject2).getIntExtra("status", -1);
          if ((i != 2) && (i != 5)) {
            break label1037;
          }
          paramBoolean = true;
          this.hLt = paramBoolean;
          this.hLu = ((PowerManager)((Context)localObject1).getSystemService("power")).isScreenOn();
          this.kDH = new j.a()
          {
            public final void a(String paramAnonymousString, l paramAnonymousl)
            {
              GMTrace.i(18829270843392L, 140289);
              if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0) && ("event_updated".equals(paramAnonymousString))) {
                d.akC();
              }
              GMTrace.o(18829270843392L, 140289);
            }
          };
          com.tencent.mm.u.c.c.Az().c(this.kDH);
          akC();
          this.kDI = new com.tencent.mm.sdk.b.c() {};
          a.uql.b(this.kDI);
          this.hLs = new BroadcastReceiver()
          {
            public final void onReceive(final Context paramAnonymousContext, Intent paramAnonymousIntent)
            {
              GMTrace.i(18828465537024L, 140283);
              paramAnonymousContext = paramAnonymousIntent.getAction();
              int i = -1;
              switch (paramAnonymousContext.hashCode())
              {
              default: 
                switch (i)
                {
                }
                break;
              }
              for (;;)
              {
                v.v("MicroMsg.SubCoreDBBackup", "Action received: %s, interactive: %s, charging: %s", new Object[] { paramAnonymousContext, Boolean.valueOf(d.this.hLu), Boolean.valueOf(d.this.hLt) });
                if ((!d.this.kDy) || (d.this.hLw != null) || (!d.this.hLt) || (d.this.hLu)) {
                  break label525;
                }
                if (System.currentTimeMillis() - d.this.kDB >= 86400000L) {
                  break label396;
                }
                v.d("MicroMsg.SubCoreDBBackup", "Last backup time not matched.");
                GMTrace.o(18828465537024L, 140283);
                return;
                if (!paramAnonymousContext.equals("android.intent.action.BATTERY_CHANGED")) {
                  break;
                }
                i = 0;
                break;
                if (!paramAnonymousContext.equals("android.intent.action.SCREEN_ON")) {
                  break;
                }
                i = 1;
                break;
                if (!paramAnonymousContext.equals("android.intent.action.SCREEN_OFF")) {
                  break;
                }
                i = 2;
                break;
                if (!paramAnonymousContext.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                  break;
                }
                i = 3;
                break;
                if (!paramAnonymousContext.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                  break;
                }
                i = 4;
                break;
                paramAnonymousContext = Parcel.obtain();
                paramAnonymousIntent.getExtras().writeToParcel(paramAnonymousContext, 0);
                paramAnonymousIntent = paramAnonymousContext.marshall();
                FileOp.k(aa.getContext().getFilesDir().getAbsolutePath() + "/battery.bin", paramAnonymousIntent);
                paramAnonymousContext.recycle();
                GMTrace.o(18828465537024L, 140283);
                return;
                d.this.hLu = true;
                continue;
                d.this.hLu = false;
                continue;
                d.this.hLt = true;
                continue;
                d.this.hLt = false;
              }
              label396:
              if (d.this.kDC < 10) {}
              for (final boolean bool = true;; bool = false)
              {
                paramAnonymousContext = new b()
                {
                  public final void kV(int paramAnonymous2Int)
                  {
                    GMTrace.i(18828868190208L, 140286);
                    d.this.kDx = false;
                    ap.yY();
                    t localt = com.tencent.mm.u.c.vr();
                    d.this.kDB = System.currentTimeMillis();
                    if (paramAnonymous2Int == 0)
                    {
                      localt.setLong(237569, d.this.kDB);
                      if (bool)
                      {
                        d locald = d.this;
                        locald.kDC += 1;
                        localt.setInt(237570, d.this.kDC);
                      }
                    }
                    for (;;)
                    {
                      localt.jV(false);
                      do
                      {
                        GMTrace.o(18828868190208L, 140286);
                        return;
                        d.this.kDC = 0;
                        break;
                      } while (paramAnonymous2Int == 1);
                      localt.setLong(237569, d.this.kDB);
                      if (bool)
                      {
                        d.this.kDC = 10;
                        localt.setInt(237570, d.this.kDC);
                      }
                    }
                  }
                };
                d.this.hLw = new Runnable()
                {
                  public final void run()
                  {
                    GMTrace.i(18829539278848L, 140291);
                    d.this.hLw = null;
                    ap.yY();
                    long l1 = new File(com.tencent.mm.u.c.vp()).length();
                    long l2 = bf.bJL();
                    if (l1 == 0L)
                    {
                      v.i("MicroMsg.SubCoreDBBackup", "Invalid database size, backup canceled.");
                      GMTrace.o(18829539278848L, 140291);
                      return;
                    }
                    if ((l1 > d.this.kDz) || (l1 > l2))
                    {
                      v.i("MicroMsg.SubCoreDBBackup", "Not enough disk space, backup canceled.");
                      com.tencent.mm.plugin.report.service.g.oSF.i(11098, new Object[] { Integer.valueOf(10008), String.format("%d|%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) }) });
                      GMTrace.o(18829539278848L, 140291);
                      return;
                    }
                    d.this.kDx = d.this.a(bool, paramAnonymousContext);
                    if (d.this.kDx) {
                      v.i("MicroMsg.SubCoreDBBackup", "Auto database backup started.");
                    }
                    GMTrace.o(18829539278848L, 140291);
                  }
                };
                ap.vL().e(d.this.hLw, d.this.kDA);
                v.i("MicroMsg.SubCoreDBBackup", "Auto database backup scheduled.");
                com.tencent.mm.plugin.report.service.g.oSF.i(11098, new Object[] { Integer.valueOf(10009), d.this.kDE.format(new Date()) });
                GMTrace.o(18828465537024L, 140283);
                return;
              }
              label525:
              if (d.this.hLw != null)
              {
                ap.vL().bJb().removeCallbacks(d.this.hLw);
                d.this.hLw = null;
                v.i("MicroMsg.SubCoreDBBackup", "Auto database backup canceled.");
                com.tencent.mm.plugin.report.service.g.oSF.i(11098, new Object[] { Integer.valueOf(10010), d.this.kDE.format(new Date()) });
                GMTrace.o(18828465537024L, 140283);
                return;
              }
              if (d.this.kDx)
              {
                d.this.akB();
                d.this.kDx = false;
              }
              GMTrace.o(18828465537024L, 140283);
            }
          };
          localObject2 = new IntentFilter();
          ((IntentFilter)localObject2).addAction("android.intent.action.SCREEN_ON");
          ((IntentFilter)localObject2).addAction("android.intent.action.SCREEN_OFF");
          ((IntentFilter)localObject2).addAction("android.intent.action.ACTION_POWER_CONNECTED");
          ((IntentFilter)localObject2).addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
          ((IntentFilter)localObject2).addAction("android.intent.action.BATTERY_CHANGED");
          ((Context)localObject1).registerReceiver(this.hLs, (IntentFilter)localObject2);
          com.tencent.mm.pluginsdk.b.b.a(new c(this), new String[] { "//recover", "//post-recover", "//backupdb", "//recoverdb", "//repairdb", "//corruptdb", "//iotracedb" });
          if (!this.kDy) {
            break label1050;
          }
          localObject1 = "enabled";
          if (!this.hLu) {
            break label1058;
          }
          localObject2 = "";
          if (!this.hLt) {
            break label1066;
          }
          localObject3 = "";
          v.i("MicroMsg.SubCoreDBBackup", "Auto database backup %s. Device status:%s interactive,%s charging.", new Object[] { localObject1, localObject2, localObject3 });
          localObject1 = localSQLiteDatabase.getPath();
          localObject2 = (String)localObject1 + ".sm";
          localObject1 = (String)localObject2 + ".tmp";
          localObject2 = new File((String)localObject2);
          if (!((File)localObject2).isFile())
          {
            l1 = System.nanoTime();
            localObject3 = new StringBuilder().append(p.rA());
            ap.yY();
            paramBoolean = RepairKit.MasterInfo.save(localSQLiteDatabase, (String)localObject1, com.tencent.mm.a.g.o(com.tencent.mm.u.c.uH().getBytes()));
            localObject1 = new File((String)localObject1);
            if (!paramBoolean) {
              break label1074;
            }
            ((File)localObject2).delete();
            paramBoolean = ((File)localObject1).renameTo((File)localObject2);
            long l2 = System.nanoTime();
            if (!paramBoolean) {
              break label1083;
            }
            localObject1 = "SUCCEEDED";
            v.i("MicroMsg.SubCoreDBBackup", "Master table backup %s, elapsed %.3f", new Object[] { localObject1, Float.valueOf((float)(l2 - l1) / 1.0E9F) });
            localObject1 = com.tencent.mm.plugin.report.service.g.oSF;
            if (!paramBoolean) {
              break label1091;
            }
            l1 = 24L;
            ((com.tencent.mm.plugin.report.service.g)localObject1).a(181L, l1, 1L, false);
          }
          localObject1 = com.tencent.mm.u.c.xu();
          ap.vL().e(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(5138123063296L, 38282);
              Object localObject = localObject1 + "corrupted/EnMicroMsg.db";
              if (FileOp.aO((String)localObject + ".corrupt"))
              {
                GMTrace.o(5138123063296L, 38282);
                return;
              }
              long l = System.currentTimeMillis();
              localObject = new File(localObject1 + "corrupted");
              if (!((File)localObject).isDirectory())
              {
                GMTrace.o(5138123063296L, 38282);
                return;
              }
              File[] arrayOfFile = ((File)localObject).listFiles();
              int j = arrayOfFile.length;
              int i = 0;
              while (i < j)
              {
                if (l - arrayOfFile[i].lastModified() < 7776000000L)
                {
                  GMTrace.o(5138123063296L, 38282);
                  return;
                }
                i += 1;
              }
              if (FileOp.y(((File)localObject).getPath(), false)) {
                v.i("MicroMsg.SubCoreDBBackup", "Corrupted databases removed.");
              }
              GMTrace.o(5138123063296L, 38282);
            }
          }, 60000L);
          GMTrace.o(5132754354176L, 38242);
        }
      }
      else
      {
        localObject2 = new BufferedReader(new FileReader((String)localObject1));
        i = bf.PX(((BufferedReader)localObject2).readLine());
        ((BufferedReader)localObject2).close();
        if ((i != 0) && (i != Process.myPid()))
        {
          localObject2 = new File("/proc/" + i + "/status");
          if ((((File)localObject2).isFile()) && (((File)localObject2).canRead()))
          {
            localObject2 = new BufferedReader(new FileReader((File)localObject2));
            try
            {
              do
              {
                localObject3 = ((BufferedReader)localObject2).readLine();
                if (localObject3 == null) {
                  break;
                }
              } while (!((String)localObject3).startsWith("State:"));
              localObject3 = ((String)localObject3).split(": \\t");
              if ((localObject3.length > 1) && ((localObject3[1].equals("S")) || (localObject3[1].equals("R")))) {
                throw new a("Multiple instances of WeChat with same account detected. Last PID: " + i);
              }
            }
            finally
            {
              ((BufferedReader)localObject2).close();
            }
          }
        }
      }
    }
    catch (a locala)
    {
      for (;;)
      {
        Object localObject2;
        throw locala;
        ((BufferedReader)localObject2).close();
        v.i("MicroMsg.DuplicateDetect", "Account reentrant within same process detected.");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.DuplicateDetect", localException, "Failed to initialize lock file: " + locala, new Object[0]);
        this.kDG.unlock();
        this.kDG = null;
        new File(this.kDF).delete();
        this.kDF = null;
        continue;
        paramBoolean = false;
        continue;
        label1037:
        paramBoolean = false;
        continue;
        label1042:
        this.hLt = false;
        continue;
        label1050:
        String str1 = "disabled";
        continue;
        label1058:
        String str2 = " not";
        continue;
        label1066:
        String str3 = " not";
        continue;
        label1074:
        str1.delete();
        continue;
        label1083:
        str1 = "FAILED";
        continue;
        label1091:
        long l1 = 25L;
      }
    }
  }
  
  public final void aN(boolean paramBoolean)
  {
    GMTrace.i(5132888571904L, 38243);
    GMTrace.o(5132888571904L, 38243);
  }
  
  /* Error */
  public final boolean akB()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc2_w 798
    //   7: ldc_w 800
    //   10: invokestatic 79	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   13: aload_0
    //   14: iconst_0
    //   15: putfield 103	com/tencent/mm/plugin/dbbackup/d:kDw	Z
    //   18: aload_0
    //   19: getfield 802	com/tencent/mm/plugin/dbbackup/d:kDt	Lcom/tencent/wcdb/repair/BackupKit;
    //   22: ifnonnull +16 -> 38
    //   25: ldc2_w 798
    //   28: ldc_w 800
    //   31: invokestatic 96	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   34: aload_0
    //   35: monitorexit
    //   36: iload_1
    //   37: ireturn
    //   38: aload_0
    //   39: getfield 802	com/tencent/mm/plugin/dbbackup/d:kDt	Lcom/tencent/wcdb/repair/BackupKit;
    //   42: invokevirtual 807	com/tencent/wcdb/repair/BackupKit:cancel	()V
    //   45: iconst_1
    //   46: istore_1
    //   47: ldc2_w 798
    //   50: ldc_w 800
    //   53: invokestatic 96	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   56: goto -22 -> 34
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	d
    //   1	46	1	bool	boolean
    //   59	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	34	59	finally
    //   38	45	59	finally
    //   47	56	59	finally
  }
  
  public final int b(String paramString, final b paramb)
  {
    int i = 0;
    for (;;)
    {
      final com.tencent.mm.u.c localc;
      final String str;
      long l;
      try
      {
        GMTrace.i(5132083265536L, 38237);
        localc = ap.yY();
        str = paramString;
        if (paramString == null) {
          str = com.tencent.mm.u.c.vn();
        }
        l = bf.bJL();
        if (str == null)
        {
          paramString = null;
          if ((paramString == null) || (!paramString.canRead()))
          {
            i = -3;
            GMTrace.o(5132083265536L, 38237);
            return i;
          }
        }
        else
        {
          paramString = new File(str);
          continue;
        }
      }
      finally {}
      tmp96_93[0] = Long.valueOf(paramString.length());
      Object[] tmp106_96 = tmp96_93;
      tmp106_96[1] = Long.valueOf(l);
      v.i("MicroMsg.SubCoreDBBackup", "[Repair] inFileSize: %d, diskFreeSpace: %d", tmp106_96);
      if ((float)l < (float)paramString.length() * 1.5F)
      {
        i = -2;
        GMTrace.o(5132083265536L, 38237);
      }
      else
      {
        paramString = new Runnable()
        {
          final String[] kDZ;
          
          /* Error */
          public final void run()
          {
            // Byte code:
            //   0: ldc2_w 67
            //   3: ldc 69
            //   5: invokestatic 43	com/tencent/gmtrace/GMTrace:i	(JI)V
            //   8: aload_0
            //   9: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
            //   12: aconst_null
            //   13: putfield 73	com/tencent/mm/plugin/dbbackup/d:kDv	Lcom/tencent/wcdb/repair/RepairKit;
            //   16: invokestatic 79	com/tencent/mm/u/c:wT	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/c;
            //   19: pop
            //   20: invokestatic 83	com/tencent/mm/u/c:wW	()Lcom/tencent/mm/storage/as;
            //   23: pop
            //   24: invokestatic 89	com/tencent/mm/ah/n:GT	()Lcom/tencent/mm/ah/f;
            //   27: pop
            //   28: invokestatic 95	com/tencent/mm/modelvideo/o:KW	()Lcom/tencent/mm/modelvideo/s;
            //   31: pop
            //   32: new 97	java/lang/StringBuilder
            //   35: dup
            //   36: invokespecial 98	java/lang/StringBuilder:<init>	()V
            //   39: invokestatic 104	com/tencent/mm/compatible/d/p:rA	()Ljava/lang/String;
            //   42: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   45: invokestatic 112	com/tencent/mm/u/c:uH	()I
            //   48: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
            //   51: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   54: invokevirtual 122	java/lang/String:getBytes	()[B
            //   57: astore 8
            //   59: aload 8
            //   61: invokestatic 127	com/tencent/mm/a/g:o	([B)[B
            //   64: astore 14
            //   66: aload 8
            //   68: invokestatic 131	com/tencent/mm/a/g:n	([B)Ljava/lang/String;
            //   71: iconst_0
            //   72: bipush 7
            //   74: invokevirtual 135	java/lang/String:substring	(II)Ljava/lang/String;
            //   77: invokevirtual 122	java/lang/String:getBytes	()[B
            //   80: astore 13
            //   82: ldc -120
            //   84: istore_1
            //   85: invokestatic 142	com/tencent/mm/bj/e:bNC	()Z
            //   88: ifeq +6 -> 94
            //   91: ldc -113
            //   93: istore_1
            //   94: invokestatic 147	com/tencent/mm/u/c:wO	()Lcom/tencent/mm/bj/g;
            //   97: invokevirtual 153	com/tencent/mm/bj/g:bND	()Lcom/tencent/wcdb/database/SQLiteDatabase;
            //   100: invokevirtual 158	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
            //   103: aload 13
            //   105: getstatic 162	com/tencent/mm/plugin/dbbackup/d:kDJ	Lcom/tencent/wcdb/database/SQLiteCipherSpec;
            //   108: aconst_null
            //   109: iload_1
            //   110: aconst_null
            //   111: iconst_0
            //   112: invokestatic 166	com/tencent/wcdb/database/SQLiteDatabase:openDatabase	(Ljava/lang/String;[BLcom/tencent/wcdb/database/SQLiteCipherSpec;Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;ILcom/tencent/wcdb/DatabaseErrorHandler;I)Lcom/tencent/wcdb/database/SQLiteDatabase;
            //   115: astore 12
            //   117: invokestatic 172	java/lang/System:nanoTime	()J
            //   120: lstore_3
            //   121: new 97	java/lang/StringBuilder
            //   124: dup
            //   125: invokespecial 98	java/lang/StringBuilder:<init>	()V
            //   128: aload_0
            //   129: getfield 29	com/tencent/mm/plugin/dbbackup/d$3:kEa	Ljava/lang/String;
            //   132: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   135: ldc -82
            //   137: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   140: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   143: astore 15
            //   145: new 97	java/lang/StringBuilder
            //   148: dup
            //   149: invokespecial 98	java/lang/StringBuilder:<init>	()V
            //   152: astore 8
            //   154: invokestatic 180	com/tencent/mm/kernel/h:vJ	()Lcom/tencent/mm/kernel/h;
            //   157: pop
            //   158: aload 8
            //   160: invokestatic 184	com/tencent/mm/kernel/h:vI	()Lcom/tencent/mm/kernel/e;
            //   163: getfield 189	com/tencent/mm/kernel/e:gXV	Ljava/lang/String;
            //   166: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   169: ldc -65
            //   171: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   174: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   177: astore 16
            //   179: iconst_0
            //   180: istore_1
            //   181: aconst_null
            //   182: astore 8
            //   184: aload 8
            //   186: astore 11
            //   188: iload_1
            //   189: iconst_2
            //   190: if_icmpge +68 -> 258
            //   193: iconst_2
            //   194: anewarray 45	java/lang/String
            //   197: dup
            //   198: iconst_0
            //   199: aload 15
            //   201: aastore
            //   202: dup
            //   203: iconst_1
            //   204: aload 16
            //   206: aastore
            //   207: iload_1
            //   208: aaload
            //   209: astore 10
            //   211: aload 8
            //   213: astore 9
            //   215: aload 10
            //   217: aload 14
            //   219: aload_0
            //   220: getfield 59	com/tencent/mm/plugin/dbbackup/d$3:kDZ	[Ljava/lang/String;
            //   223: invokestatic 197	com/tencent/wcdb/repair/RepairKit$MasterInfo:load	(Ljava/lang/String;[B[Ljava/lang/String;)Lcom/tencent/wcdb/repair/RepairKit$MasterInfo;
            //   226: astore 11
            //   228: aload 11
            //   230: astore 9
            //   232: aload 11
            //   234: astore 8
            //   236: ldc -57
            //   238: new 97	java/lang/StringBuilder
            //   241: dup
            //   242: ldc -55
            //   244: invokespecial 204	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
            //   247: aload 10
            //   249: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   252: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   255: invokestatic 209	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
            //   258: aload 11
            //   260: ifnonnull +396 -> 656
            //   263: aload 11
            //   265: astore 10
            //   267: aload 11
            //   269: astore 8
            //   271: aload_0
            //   272: getfield 59	com/tencent/mm/plugin/dbbackup/d$3:kDZ	[Ljava/lang/String;
            //   275: invokestatic 213	com/tencent/wcdb/repair/RepairKit$MasterInfo:make	([Ljava/lang/String;)Lcom/tencent/wcdb/repair/RepairKit$MasterInfo;
            //   278: astore 9
            //   280: aload 9
            //   282: astore 10
            //   284: aload 9
            //   286: astore 8
            //   288: ldc -57
            //   290: ldc -41
            //   292: invokestatic 218	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;)V
            //   295: aload 9
            //   297: astore 10
            //   299: aload 9
            //   301: astore 8
            //   303: getstatic 224	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
            //   306: ldc2_w 225
            //   309: ldc2_w 227
            //   312: lconst_1
            //   313: iconst_1
            //   314: invokevirtual 232	com/tencent/mm/plugin/report/service/g:a	(JJJZ)V
            //   317: aload 9
            //   319: astore 10
            //   321: aload 9
            //   323: astore 8
            //   325: aload_0
            //   326: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
            //   329: new 234	com/tencent/wcdb/repair/RepairKit
            //   332: dup
            //   333: aload_0
            //   334: getfield 29	com/tencent/mm/plugin/dbbackup/d$3:kEa	Ljava/lang/String;
            //   337: aload 13
            //   339: getstatic 162	com/tencent/mm/plugin/dbbackup/d:kDJ	Lcom/tencent/wcdb/database/SQLiteCipherSpec;
            //   342: aload 9
            //   344: invokespecial 237	com/tencent/wcdb/repair/RepairKit:<init>	(Ljava/lang/String;[BLcom/tencent/wcdb/database/SQLiteCipherSpec;Lcom/tencent/wcdb/repair/RepairKit$MasterInfo;)V
            //   347: putfield 73	com/tencent/mm/plugin/dbbackup/d:kDv	Lcom/tencent/wcdb/repair/RepairKit;
            //   350: aload 9
            //   352: astore 10
            //   354: aload 9
            //   356: astore 8
            //   358: aload_0
            //   359: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
            //   362: getfield 73	com/tencent/mm/plugin/dbbackup/d:kDv	Lcom/tencent/wcdb/repair/RepairKit;
            //   365: aload 12
            //   367: iconst_1
            //   368: invokevirtual 241	com/tencent/wcdb/repair/RepairKit:output	(Lcom/tencent/wcdb/database/SQLiteDatabase;I)Z
            //   371: istore 7
            //   373: aload 9
            //   375: astore 10
            //   377: aload 9
            //   379: astore 8
            //   381: aload_0
            //   382: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
            //   385: getfield 73	com/tencent/mm/plugin/dbbackup/d:kDv	Lcom/tencent/wcdb/repair/RepairKit;
            //   388: invokevirtual 244	com/tencent/wcdb/repair/RepairKit:isHeaderCorrupted	()Z
            //   391: ifeq +705 -> 1096
            //   394: aload 9
            //   396: astore 10
            //   398: aload 9
            //   400: astore 8
            //   402: aload_0
            //   403: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
            //   406: getfield 73	com/tencent/mm/plugin/dbbackup/d:kDv	Lcom/tencent/wcdb/repair/RepairKit;
            //   409: invokevirtual 247	com/tencent/wcdb/repair/RepairKit:isDataCorrupted	()Z
            //   412: ifne +459 -> 871
            //   415: goto +681 -> 1096
            //   418: iload 7
            //   420: iload_1
            //   421: iand
            //   422: istore_1
            //   423: aload 9
            //   425: astore 10
            //   427: aload 9
            //   429: astore 8
            //   431: aload 12
            //   433: invokevirtual 250	com/tencent/wcdb/database/SQLiteDatabase:close	()V
            //   436: aconst_null
            //   437: astore 10
            //   439: aload 9
            //   441: invokevirtual 253	com/tencent/wcdb/repair/RepairKit$MasterInfo:release	()V
            //   444: aconst_null
            //   445: astore 11
            //   447: aconst_null
            //   448: astore 9
            //   450: aload_0
            //   451: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
            //   454: getfield 73	com/tencent/mm/plugin/dbbackup/d:kDv	Lcom/tencent/wcdb/repair/RepairKit;
            //   457: invokevirtual 254	com/tencent/wcdb/repair/RepairKit:release	()V
            //   460: aload_0
            //   461: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
            //   464: aconst_null
            //   465: putfield 73	com/tencent/mm/plugin/dbbackup/d:kDv	Lcom/tencent/wcdb/repair/RepairKit;
            //   468: invokestatic 257	com/tencent/mm/plugin/dbbackup/d:akD	()V
            //   471: invokestatic 172	java/lang/System:nanoTime	()J
            //   474: lstore 5
            //   476: iload_1
            //   477: ifeq +399 -> 876
            //   480: ldc_w 259
            //   483: astore 8
            //   485: ldc -57
            //   487: ldc_w 261
            //   490: iconst_2
            //   491: anewarray 4	java/lang/Object
            //   494: dup
            //   495: iconst_0
            //   496: aload 8
            //   498: aastore
            //   499: dup
            //   500: iconst_1
            //   501: lload 5
            //   503: lload_3
            //   504: lsub
            //   505: l2f
            //   506: ldc_w 262
            //   509: fdiv
            //   510: invokestatic 268	java/lang/Float:valueOf	(F)Ljava/lang/Float;
            //   513: aastore
            //   514: invokestatic 271	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
            //   517: iload_1
            //   518: ifeq +366 -> 884
            //   521: bipush 26
            //   523: istore_2
            //   524: iload_2
            //   525: istore_1
            //   526: aload_0
            //   527: getfield 31	com/tencent/mm/plugin/dbbackup/d$3:kDK	Lcom/tencent/mm/plugin/dbbackup/b;
            //   530: ifnull +15 -> 545
            //   533: aload_0
            //   534: getfield 31	com/tencent/mm/plugin/dbbackup/d$3:kDK	Lcom/tencent/mm/plugin/dbbackup/b;
            //   537: iconst_0
            //   538: invokeinterface 277 2 0
            //   543: iload_2
            //   544: istore_1
            //   545: getstatic 224	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
            //   548: ldc2_w 225
            //   551: iload_1
            //   552: i2l
            //   553: lconst_1
            //   554: iconst_1
            //   555: invokevirtual 232	com/tencent/mm/plugin/report/service/g:a	(JJJZ)V
            //   558: aload_0
            //   559: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
            //   562: getfield 73	com/tencent/mm/plugin/dbbackup/d:kDv	Lcom/tencent/wcdb/repair/RepairKit;
            //   565: ifnull +21 -> 586
            //   568: aload_0
            //   569: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
            //   572: getfield 73	com/tencent/mm/plugin/dbbackup/d:kDv	Lcom/tencent/wcdb/repair/RepairKit;
            //   575: invokevirtual 254	com/tencent/wcdb/repair/RepairKit:release	()V
            //   578: aload_0
            //   579: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
            //   582: aconst_null
            //   583: putfield 73	com/tencent/mm/plugin/dbbackup/d:kDv	Lcom/tencent/wcdb/repair/RepairKit;
            //   586: aload_0
            //   587: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
            //   590: iconst_0
            //   591: putfield 281	com/tencent/mm/plugin/dbbackup/d:kDw	Z
            //   594: invokestatic 287	com/tencent/mm/u/ap:vL	()Lcom/tencent/mm/sdk/platformtools/ae;
            //   597: invokevirtual 292	com/tencent/mm/sdk/platformtools/ae:bJa	()V
            //   600: ldc2_w 67
            //   603: ldc 69
            //   605: invokestatic 62	com/tencent/gmtrace/GMTrace:o	(JI)V
            //   608: return
            //   609: astore 11
            //   611: aload 9
            //   613: astore 10
            //   615: aload 9
            //   617: astore 8
            //   619: ldc -57
            //   621: new 97	java/lang/StringBuilder
            //   624: dup
            //   625: ldc_w 294
            //   628: invokespecial 204	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
            //   631: aload 11
            //   633: invokevirtual 297	java/lang/Exception:getMessage	()Ljava/lang/String;
            //   636: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   639: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   642: invokestatic 300	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
            //   645: iload_1
            //   646: iconst_1
            //   647: iadd
            //   648: istore_1
            //   649: aload 9
            //   651: astore 8
            //   653: goto -469 -> 184
            //   656: aload 11
            //   658: astore 9
            //   660: iload_1
            //   661: ifle -344 -> 317
            //   664: aload 11
            //   666: astore 10
            //   668: aload 11
            //   670: astore 8
            //   672: ldc -57
            //   674: ldc_w 302
            //   677: invokestatic 209	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
            //   680: aload 11
            //   682: astore 10
            //   684: aload 11
            //   686: astore 8
            //   688: getstatic 224	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
            //   691: ldc2_w 225
            //   694: ldc2_w 303
            //   697: lconst_1
            //   698: iconst_1
            //   699: invokevirtual 232	com/tencent/mm/plugin/report/service/g:a	(JJJZ)V
            //   702: aload 11
            //   704: astore 9
            //   706: goto -389 -> 317
            //   709: astore 8
            //   711: aload 10
            //   713: astore 9
            //   715: aload 12
            //   717: astore 10
            //   719: ldc -57
            //   721: aload 8
            //   723: ldc_w 306
            //   726: iconst_1
            //   727: anewarray 4	java/lang/Object
            //   730: dup
            //   731: iconst_0
            //   732: aload_0
            //   733: getfield 29	com/tencent/mm/plugin/dbbackup/d$3:kEa	Ljava/lang/String;
            //   736: aastore
            //   737: invokestatic 310	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
            //   740: aload_0
            //   741: getfield 31	com/tencent/mm/plugin/dbbackup/d$3:kDK	Lcom/tencent/mm/plugin/dbbackup/b;
            //   744: ifnull +13 -> 757
            //   747: aload_0
            //   748: getfield 31	com/tencent/mm/plugin/dbbackup/d$3:kDK	Lcom/tencent/mm/plugin/dbbackup/b;
            //   751: iconst_m1
            //   752: invokeinterface 277 2 0
            //   757: getstatic 224	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
            //   760: ldc_w 312
            //   763: new 97	java/lang/StringBuilder
            //   766: dup
            //   767: ldc_w 314
            //   770: invokespecial 204	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
            //   773: invokestatic 317	com/tencent/wcdb/repair/RepairKit:lastError	()Ljava/lang/String;
            //   776: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   779: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   782: aconst_null
            //   783: invokevirtual 321	com/tencent/mm/plugin/report/service/g:d	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
            //   786: getstatic 224	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
            //   789: ldc2_w 225
            //   792: ldc2_w 322
            //   795: lconst_1
            //   796: iconst_1
            //   797: invokevirtual 232	com/tencent/mm/plugin/report/service/g:a	(JJJZ)V
            //   800: aload_0
            //   801: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
            //   804: getfield 73	com/tencent/mm/plugin/dbbackup/d:kDv	Lcom/tencent/wcdb/repair/RepairKit;
            //   807: ifnull +21 -> 828
            //   810: aload_0
            //   811: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
            //   814: getfield 73	com/tencent/mm/plugin/dbbackup/d:kDv	Lcom/tencent/wcdb/repair/RepairKit;
            //   817: invokevirtual 254	com/tencent/wcdb/repair/RepairKit:release	()V
            //   820: aload_0
            //   821: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
            //   824: aconst_null
            //   825: putfield 73	com/tencent/mm/plugin/dbbackup/d:kDv	Lcom/tencent/wcdb/repair/RepairKit;
            //   828: aload 10
            //   830: ifnull +8 -> 838
            //   833: aload 10
            //   835: invokevirtual 250	com/tencent/wcdb/database/SQLiteDatabase:close	()V
            //   838: aload 9
            //   840: ifnull +8 -> 848
            //   843: aload 9
            //   845: invokevirtual 253	com/tencent/wcdb/repair/RepairKit$MasterInfo:release	()V
            //   848: aload_0
            //   849: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
            //   852: iconst_0
            //   853: putfield 281	com/tencent/mm/plugin/dbbackup/d:kDw	Z
            //   856: invokestatic 287	com/tencent/mm/u/ap:vL	()Lcom/tencent/mm/sdk/platformtools/ae;
            //   859: invokevirtual 292	com/tencent/mm/sdk/platformtools/ae:bJa	()V
            //   862: ldc2_w 67
            //   865: ldc 69
            //   867: invokestatic 62	com/tencent/gmtrace/GMTrace:o	(JI)V
            //   870: return
            //   871: iconst_0
            //   872: istore_1
            //   873: goto -455 -> 418
            //   876: ldc_w 325
            //   879: astore 8
            //   881: goto -396 -> 485
            //   884: bipush 27
            //   886: istore_1
            //   887: aload_0
            //   888: getfield 31	com/tencent/mm/plugin/dbbackup/d$3:kDK	Lcom/tencent/mm/plugin/dbbackup/b;
            //   891: ifnull +13 -> 904
            //   894: aload_0
            //   895: getfield 31	com/tencent/mm/plugin/dbbackup/d$3:kDK	Lcom/tencent/mm/plugin/dbbackup/b;
            //   898: iconst_m1
            //   899: invokeinterface 277 2 0
            //   904: getstatic 224	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
            //   907: ldc_w 312
            //   910: new 97	java/lang/StringBuilder
            //   913: dup
            //   914: ldc_w 314
            //   917: invokespecial 204	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
            //   920: invokestatic 317	com/tencent/wcdb/repair/RepairKit:lastError	()Ljava/lang/String;
            //   923: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   926: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   929: aconst_null
            //   930: invokevirtual 321	com/tencent/mm/plugin/report/service/g:d	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
            //   933: goto -388 -> 545
            //   936: astore 8
            //   938: goto -219 -> 719
            //   941: astore 8
            //   943: aconst_null
            //   944: astore 10
            //   946: aconst_null
            //   947: astore 9
            //   949: aload_0
            //   950: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
            //   953: getfield 73	com/tencent/mm/plugin/dbbackup/d:kDv	Lcom/tencent/wcdb/repair/RepairKit;
            //   956: ifnull +21 -> 977
            //   959: aload_0
            //   960: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
            //   963: getfield 73	com/tencent/mm/plugin/dbbackup/d:kDv	Lcom/tencent/wcdb/repair/RepairKit;
            //   966: invokevirtual 254	com/tencent/wcdb/repair/RepairKit:release	()V
            //   969: aload_0
            //   970: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
            //   973: aconst_null
            //   974: putfield 73	com/tencent/mm/plugin/dbbackup/d:kDv	Lcom/tencent/wcdb/repair/RepairKit;
            //   977: aload 10
            //   979: ifnull +8 -> 987
            //   982: aload 10
            //   984: invokevirtual 250	com/tencent/wcdb/database/SQLiteDatabase:close	()V
            //   987: aload 9
            //   989: ifnull +8 -> 997
            //   992: aload 9
            //   994: invokevirtual 253	com/tencent/wcdb/repair/RepairKit$MasterInfo:release	()V
            //   997: aload_0
            //   998: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kDW	Lcom/tencent/mm/plugin/dbbackup/d;
            //   1001: iconst_0
            //   1002: putfield 281	com/tencent/mm/plugin/dbbackup/d:kDw	Z
            //   1005: invokestatic 287	com/tencent/mm/u/ap:vL	()Lcom/tencent/mm/sdk/platformtools/ae;
            //   1008: invokevirtual 292	com/tencent/mm/sdk/platformtools/ae:bJa	()V
            //   1011: aload 8
            //   1013: athrow
            //   1014: astore 8
            //   1016: aconst_null
            //   1017: astore 9
            //   1019: aload 12
            //   1021: astore 10
            //   1023: goto -74 -> 949
            //   1026: astore 10
            //   1028: aload 8
            //   1030: astore 9
            //   1032: aload 10
            //   1034: astore 8
            //   1036: aload 12
            //   1038: astore 10
            //   1040: goto -91 -> 949
            //   1043: astore 8
            //   1045: aconst_null
            //   1046: astore 10
            //   1048: goto -99 -> 949
            //   1051: astore 8
            //   1053: aconst_null
            //   1054: astore 10
            //   1056: aload 11
            //   1058: astore 9
            //   1060: goto -111 -> 949
            //   1063: astore 8
            //   1065: goto -116 -> 949
            //   1068: astore 8
            //   1070: aconst_null
            //   1071: astore 10
            //   1073: aconst_null
            //   1074: astore 9
            //   1076: goto -357 -> 719
            //   1079: astore 8
            //   1081: aload 12
            //   1083: astore 10
            //   1085: aconst_null
            //   1086: astore 9
            //   1088: goto -369 -> 719
            //   1091: astore 8
            //   1093: goto -374 -> 719
            //   1096: iconst_1
            //   1097: istore_1
            //   1098: goto -680 -> 418
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	1101	0	this	3
            //   84	1014	1	i	int
            //   523	21	2	j	int
            //   120	384	3	l1	long
            //   474	28	5	l2	long
            //   371	51	7	k	int
            //   57	630	8	localObject1	Object
            //   709	13	8	localException1	Exception
            //   879	1	8	str1	String
            //   936	1	8	localException2	Exception
            //   941	71	8	localObject2	Object
            //   1014	15	8	localObject3	Object
            //   1034	1	8	localObject4	Object
            //   1043	1	8	localObject5	Object
            //   1051	1	8	localObject6	Object
            //   1063	1	8	localObject7	Object
            //   1068	1	8	localException3	Exception
            //   1079	1	8	localException4	Exception
            //   1091	1	8	localException5	Exception
            //   213	874	9	localObject8	Object
            //   209	813	10	localObject9	Object
            //   1026	7	10	localObject10	Object
            //   1038	46	10	localSQLiteDatabase1	SQLiteDatabase
            //   186	260	11	localObject11	Object
            //   609	448	11	localException6	Exception
            //   115	967	12	localSQLiteDatabase2	SQLiteDatabase
            //   80	258	13	arrayOfByte1	byte[]
            //   64	154	14	arrayOfByte2	byte[]
            //   143	57	15	str2	String
            //   177	28	16	str3	String
            // Exception table:
            //   from	to	target	type
            //   215	228	609	java/lang/Exception
            //   236	258	609	java/lang/Exception
            //   271	280	709	java/lang/Exception
            //   288	295	709	java/lang/Exception
            //   303	317	709	java/lang/Exception
            //   325	350	709	java/lang/Exception
            //   358	373	709	java/lang/Exception
            //   381	394	709	java/lang/Exception
            //   402	415	709	java/lang/Exception
            //   431	436	709	java/lang/Exception
            //   619	645	709	java/lang/Exception
            //   672	680	709	java/lang/Exception
            //   688	702	709	java/lang/Exception
            //   450	476	936	java/lang/Exception
            //   485	517	936	java/lang/Exception
            //   526	543	936	java/lang/Exception
            //   545	558	936	java/lang/Exception
            //   887	904	936	java/lang/Exception
            //   904	933	936	java/lang/Exception
            //   16	82	941	finally
            //   85	91	941	finally
            //   94	117	941	finally
            //   117	179	1014	finally
            //   215	228	1026	finally
            //   236	258	1026	finally
            //   271	280	1026	finally
            //   288	295	1026	finally
            //   303	317	1026	finally
            //   325	350	1026	finally
            //   358	373	1026	finally
            //   381	394	1026	finally
            //   402	415	1026	finally
            //   431	436	1026	finally
            //   619	645	1026	finally
            //   672	680	1026	finally
            //   688	702	1026	finally
            //   439	444	1043	finally
            //   450	476	1051	finally
            //   485	517	1051	finally
            //   526	543	1051	finally
            //   545	558	1051	finally
            //   887	904	1051	finally
            //   904	933	1051	finally
            //   719	757	1063	finally
            //   757	800	1063	finally
            //   16	82	1068	java/lang/Exception
            //   85	91	1068	java/lang/Exception
            //   94	117	1068	java/lang/Exception
            //   117	179	1079	java/lang/Exception
            //   439	444	1091	java/lang/Exception
          }
        };
        this.kDw = true;
        ap.vL().bIY();
        ap.vL().H(paramString);
        GMTrace.o(5132083265536L, 38237);
      }
    }
  }
  
  public final void b(final b paramb)
  {
    GMTrace.i(5132351700992L, 38239);
    final File localFile = new File(aa.getContext().getFilesDir(), "DBRecoverStarted");
    final WakerLock localWakerLock = new WakerLock(aa.getContext());
    paramb = new b()
    {
      int kEe;
      
      public final void kV(int paramAnonymousInt)
      {
        GMTrace.i(5130338435072L, 38224);
        int i = paramAnonymousInt;
        if (this.kEe > 0) {
          v.i("MicroMsg.SubCoreDBBackup", "Recovery stage %d result: %d", new Object[] { Integer.valueOf(this.kEe), Integer.valueOf(i) });
        }
        if (i == 0)
        {
          localFile.delete();
          com.tencent.mm.plugin.report.service.g.oSF.a(181L, 29L, 1L, true);
          if (paramb != null) {
            paramb.kV(i);
          }
          localWakerLock.unLock();
          GMTrace.o(5130338435072L, 38224);
          return;
        }
        if (i == -2)
        {
          localFile.delete();
          com.tencent.mm.plugin.report.service.g.oSF.a(181L, 3L, 1L, true);
          if (paramb != null) {
            paramb.kV(i);
          }
          localWakerLock.unLock();
          GMTrace.o(5130338435072L, 38224);
          return;
        }
        paramAnonymousInt = this.kEe + 1;
        this.kEe = paramAnonymousInt;
        switch (paramAnonymousInt)
        {
        default: 
          localFile.delete();
          com.tencent.mm.plugin.report.service.g.oSF.a(181L, 30L, 1L, true);
          if (paramb != null) {
            paramb.kV(i);
          }
          localWakerLock.unLock();
          GMTrace.o(5130338435072L, 38224);
          return;
        case 1: 
          v.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: REPAIR", new Object[] { Integer.valueOf(this.kEe) });
          paramAnonymousInt = d.this.b(null, this);
        }
        for (;;)
        {
          i = paramAnonymousInt;
          if (paramAnonymousInt != 0) {
            break;
          }
          GMTrace.o(5130338435072L, 38224);
          return;
          v.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: BACKUP RECOVER", new Object[] { Integer.valueOf(this.kEe) });
          paramAnonymousInt = d.this.a(null, this);
          continue;
          v.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: DUMP", new Object[] { Integer.valueOf(this.kEe) });
          paramAnonymousInt = d.this.a(this);
        }
      }
    };
    v.i("MicroMsg.SubCoreDBBackup", "Database recover started.");
    localWakerLock.lock();
    com.tencent.mm.plugin.report.service.g.oSF.a(181L, 28L, 1L, true);
    try
    {
      localFile.createNewFile();
      paramb.kV(-1);
      GMTrace.o(5132351700992L, 38239);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  public final void eD(int paramInt)
  {
    GMTrace.i(5132620136448L, 38241);
    GMTrace.o(5132620136448L, 38241);
  }
  
  public final void onAccountRelease()
  {
    GMTrace.i(5133022789632L, 38244);
    akB();
    this.kDx = false;
    if (this.hLw != null)
    {
      ap.vL().bJb().removeCallbacks(this.hLw);
      this.hLw = null;
    }
    if (this.kDI != null)
    {
      a.uql.c(this.kDI);
      this.kDI = null;
    }
    if (this.hLs != null)
    {
      aa.getContext().unregisterReceiver(this.hLs);
      this.hLs = null;
    }
    com.tencent.mm.pluginsdk.b.b.B(new String[] { "//recover", "//post-recover", "//backupdb", "//recoverdb", "//repairdb", "//corruptdb", "//iotracedb" });
    if ((this.kDG != null) && (this.kDF != null) && (this.kDF.length() > 0))
    {
      this.kDG.unlock();
      this.kDG = null;
      new File(this.kDF).delete();
      this.kDF = null;
      v.i("MicroMsg.DuplicateDetect", "Instance exited.");
    }
    GMTrace.o(5133022789632L, 38244);
  }
  
  public final HashMap<Integer, g.c> uh()
  {
    GMTrace.i(5132485918720L, 38240);
    GMTrace.o(5132485918720L, 38240);
    return null;
  }
  
  private static final class a
    extends RuntimeException
  {
    a(String paramString)
    {
      super();
      GMTrace.i(15963453915136L, 118937);
      GMTrace.o(15963453915136L, 118937);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/dbbackup/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */