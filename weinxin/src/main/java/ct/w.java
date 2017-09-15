package ct;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class w
  extends SQLiteOpenHelper
  implements v
{
  private static String a = "";
  private static w b;
  
  private w(Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 5);
    try
    {
      paramContext.deleteDatabase("access.db");
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static w a()
  {
    if (b == null)
    {
      a = p.b + "-access.db";
      b = new w(p.a, a);
    }
    return b;
  }
  
  private static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS access_tbl");
      return;
    }
    catch (SQLException paramSQLiteDatabase) {}
  }
  
  private boolean a(String paramString, t.a parama, long paramLong)
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
        if (!localSQLiteDatabase.isDbLockedByOtherThreads())
        {
          boolean bool2 = localSQLiteDatabase.isDbLockedByCurrentThread();
          if (!bool2) {}
        }
        else
        {
          try
          {
            Thread.sleep(10L);
          }
          catch (InterruptedException localInterruptedException) {}
          continue;
        }
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("iplist", parama.a());
        localContentValues.put("schedule_lasttime", Long.valueOf(parama.e));
        localContentValues.put("apn_lasttime", Long.valueOf(paramLong));
        localContentValues.put("rule", parama.b);
        i = localSQLiteDatabase.update("access_tbl", localContentValues, "apn=? and domain=?", new String[] { paramString, parama.a });
        if (i != 0) {
          continue;
        }
        localContentValues.put("apn", paramString);
        localContentValues.put("domain", parama.a);
        localContentValues.put("rule", parama.b);
        paramLong = localSQLiteDatabase.insert("access_tbl", null, localContentValues);
        new StringBuilder("insert record...ret:").append(paramLong).append(",apnName:").append(paramString).append(",domain:").append(parama.a).append(",ip:").append(parama.a());
        bd.b();
        if (-1L == paramLong) {
          break label307;
        }
      }
      catch (Exception paramString)
      {
        int i;
        bool1 = false;
        continue;
      }
      finally {}
      return bool1;
      new StringBuilder("update record...ret:").append(i).append(",apnName:").append(paramString).append(",domain:").append(parama.a).append(",ip:").append(parama.a());
      bool1 = false;
      bd.b();
      continue;
      label307:
      bool1 = false;
    }
  }
  
  private static void b(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS access_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,domain TEXT,rule TEXT,iplist TEXT,last_suc_ip TEXT,apn_lasttime INTEGER,schedule_lasttime INTEGER);");
      bd.b();
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      throw paramSQLiteDatabase;
    }
  }
  
  /* Error */
  public final t a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 173	ct/w:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: astore 5
    //   8: aload 5
    //   10: invokevirtual 80	android/database/sqlite/SQLiteDatabase:isDbLockedByOtherThreads	()Z
    //   13: ifne +13 -> 26
    //   16: aload 5
    //   18: invokevirtual 83	android/database/sqlite/SQLiteDatabase:isDbLockedByCurrentThread	()Z
    //   21: istore_2
    //   22: iload_2
    //   23: ifeq +17 -> 40
    //   26: ldc2_w 84
    //   29: invokestatic 91	java/lang/Thread:sleep	(J)V
    //   32: goto -24 -> 8
    //   35: astore 6
    //   37: goto -29 -> 8
    //   40: aload 5
    //   42: ldc 126
    //   44: aconst_null
    //   45: ldc -81
    //   47: iconst_1
    //   48: anewarray 130	java/lang/String
    //   51: dup
    //   52: iconst_0
    //   53: aload_1
    //   54: aastore
    //   55: aconst_null
    //   56: aconst_null
    //   57: aconst_null
    //   58: invokevirtual 179	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   61: astore 6
    //   63: aload 6
    //   65: ifnull +221 -> 286
    //   68: aload 6
    //   70: invokeinterface 184 1 0
    //   75: ifeq +211 -> 286
    //   78: new 186	ct/t
    //   81: dup
    //   82: aload_1
    //   83: invokespecial 187	ct/t:<init>	(Ljava/lang/String;)V
    //   86: astore_1
    //   87: aload 6
    //   89: aload 6
    //   91: ldc -117
    //   93: invokeinterface 191 2 0
    //   98: invokeinterface 195 2 0
    //   103: astore 5
    //   105: aload 6
    //   107: aload 6
    //   109: ldc 96
    //   111: invokeinterface 191 2 0
    //   116: invokeinterface 195 2 0
    //   121: astore 7
    //   123: aload 6
    //   125: aload 6
    //   127: ldc -59
    //   129: invokeinterface 191 2 0
    //   134: invokeinterface 195 2 0
    //   139: astore 8
    //   141: aload 6
    //   143: aload 6
    //   145: ldc 123
    //   147: invokeinterface 191 2 0
    //   152: invokeinterface 195 2 0
    //   157: astore 9
    //   159: aload 6
    //   161: aload 6
    //   163: ldc 106
    //   165: invokeinterface 191 2 0
    //   170: invokeinterface 201 2 0
    //   175: lstore_3
    //   176: aload 6
    //   178: aload 6
    //   180: ldc 121
    //   182: invokeinterface 191 2 0
    //   187: invokeinterface 201 2 0
    //   192: pop2
    //   193: aload_1
    //   194: new 98	ct/t$a
    //   197: dup
    //   198: aload 5
    //   200: lload_3
    //   201: aload 7
    //   203: aload 9
    //   205: aload 8
    //   207: invokespecial 204	ct/t$a:<init>	(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   210: invokevirtual 207	ct/t:a	(Lct/t$a;)V
    //   213: aload 6
    //   215: invokeinterface 210 1 0
    //   220: istore_2
    //   221: iload_2
    //   222: ifne -135 -> 87
    //   225: aload_1
    //   226: astore 5
    //   228: aload 6
    //   230: ifnull +13 -> 243
    //   233: aload 6
    //   235: invokeinterface 213 1 0
    //   240: aload_1
    //   241: astore 5
    //   243: aload_0
    //   244: monitorexit
    //   245: aload 5
    //   247: areturn
    //   248: astore_1
    //   249: aconst_null
    //   250: astore 5
    //   252: aload 5
    //   254: ifnull +10 -> 264
    //   257: aload 5
    //   259: invokeinterface 213 1 0
    //   264: aload_1
    //   265: athrow
    //   266: astore_1
    //   267: aconst_null
    //   268: astore 5
    //   270: goto -27 -> 243
    //   273: astore_1
    //   274: aload_0
    //   275: monitorexit
    //   276: aload_1
    //   277: athrow
    //   278: astore_1
    //   279: aload 6
    //   281: astore 5
    //   283: goto -31 -> 252
    //   286: aconst_null
    //   287: astore_1
    //   288: goto -63 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	this	w
    //   0	291	1	paramString	String
    //   21	201	2	bool	boolean
    //   175	26	3	l	long
    //   6	276	5	localObject	Object
    //   35	1	6	localInterruptedException	InterruptedException
    //   61	219	6	localCursor	android.database.Cursor
    //   121	81	7	str1	String
    //   139	67	8	str2	String
    //   157	47	9	str3	String
    // Exception table:
    //   from	to	target	type
    //   26	32	35	java/lang/InterruptedException
    //   40	63	248	finally
    //   2	8	266	java/lang/Exception
    //   8	22	266	java/lang/Exception
    //   26	32	266	java/lang/Exception
    //   233	240	266	java/lang/Exception
    //   257	264	266	java/lang/Exception
    //   264	266	266	java/lang/Exception
    //   2	8	273	finally
    //   8	22	273	finally
    //   26	32	273	finally
    //   233	240	273	finally
    //   257	264	273	finally
    //   264	266	273	finally
    //   68	87	278	finally
    //   87	221	278	finally
  }
  
  /* Error */
  public final void a(t paramt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: ifnonnull +6 -> 11
    //   8: aload_0
    //   9: monitorexit
    //   10: return
    //   11: aload_1
    //   12: getfield 217	ct/t:b	Ljava/util/Map;
    //   15: astore 6
    //   17: invokestatic 223	java/lang/System:currentTimeMillis	()J
    //   20: lstore_3
    //   21: aload 6
    //   23: invokeinterface 229 1 0
    //   28: invokeinterface 235 1 0
    //   33: astore 6
    //   35: aload 6
    //   37: invokeinterface 240 1 0
    //   42: ifeq +38 -> 80
    //   45: aload 6
    //   47: invokeinterface 244 1 0
    //   52: checkcast 98	ct/t$a
    //   55: astore 7
    //   57: aload_0
    //   58: aload_1
    //   59: getfield 245	ct/t:a	Ljava/lang/String;
    //   62: aload 7
    //   64: lload_3
    //   65: invokespecial 247	ct/w:a	(Ljava/lang/String;Lct/t$a;J)Z
    //   68: istore 5
    //   70: iload 5
    //   72: ifeq +239 -> 311
    //   75: iconst_1
    //   76: istore_2
    //   77: goto -42 -> 35
    //   80: iload_2
    //   81: ifeq -73 -> 8
    //   84: invokestatic 250	ct/bd:c	()V
    //   87: aload_0
    //   88: invokevirtual 76	ct/w:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   91: astore 7
    //   93: aload 7
    //   95: invokevirtual 80	android/database/sqlite/SQLiteDatabase:isDbLockedByOtherThreads	()Z
    //   98: ifne +15 -> 113
    //   101: aload 7
    //   103: invokevirtual 83	android/database/sqlite/SQLiteDatabase:isDbLockedByCurrentThread	()Z
    //   106: istore 5
    //   108: iload 5
    //   110: ifeq +16 -> 126
    //   113: ldc2_w 84
    //   116: invokestatic 91	java/lang/Thread:sleep	(J)V
    //   119: goto -26 -> 93
    //   122: astore_1
    //   123: goto -30 -> 93
    //   126: aload 7
    //   128: ldc 126
    //   130: iconst_1
    //   131: anewarray 130	java/lang/String
    //   134: dup
    //   135: iconst_0
    //   136: ldc -119
    //   138: aastore
    //   139: aconst_null
    //   140: aconst_null
    //   141: ldc -119
    //   143: aconst_null
    //   144: ldc 121
    //   146: invokevirtual 179	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   149: astore_1
    //   150: aload_1
    //   151: ifnull +153 -> 304
    //   154: aload_1
    //   155: invokeinterface 254 1 0
    //   160: invokestatic 259	ct/b$a:b	()Lct/b$a;
    //   163: getfield 262	ct/b$a:b	Lct/d;
    //   166: getfield 267	ct/d:c	I
    //   169: if_icmple +135 -> 304
    //   172: aload_1
    //   173: invokeinterface 184 1 0
    //   178: ifeq +126 -> 304
    //   181: aload_1
    //   182: aload_1
    //   183: ldc -119
    //   185: invokeinterface 191 2 0
    //   190: invokeinterface 195 2 0
    //   195: astore 6
    //   197: aload 6
    //   199: invokestatic 273	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   202: ifne +102 -> 304
    //   205: invokestatic 250	ct/bd:c	()V
    //   208: aload_1
    //   209: ifnull +9 -> 218
    //   212: aload_1
    //   213: invokeinterface 213 1 0
    //   218: aload 6
    //   220: invokestatic 273	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   223: ifne -215 -> 8
    //   226: aload 7
    //   228: ldc 126
    //   230: ldc -81
    //   232: iconst_1
    //   233: anewarray 130	java/lang/String
    //   236: dup
    //   237: iconst_0
    //   238: aload 6
    //   240: aastore
    //   241: invokevirtual 277	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   244: istore_2
    //   245: new 37	java/lang/StringBuilder
    //   248: dup
    //   249: ldc_w 279
    //   252: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   255: aload 6
    //   257: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: ldc_w 281
    //   263: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: iload_2
    //   267: invokevirtual 167	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: invokestatic 250	ct/bd:c	()V
    //   274: goto -266 -> 8
    //   277: aload_1
    //   278: ifnull +9 -> 287
    //   281: aload_1
    //   282: invokeinterface 213 1 0
    //   287: aload 6
    //   289: athrow
    //   290: astore_1
    //   291: aload_0
    //   292: monitorexit
    //   293: aload_1
    //   294: athrow
    //   295: astore_1
    //   296: goto -288 -> 8
    //   299: astore 6
    //   301: goto -24 -> 277
    //   304: ldc 14
    //   306: astore 6
    //   308: goto -100 -> 208
    //   311: goto -234 -> 77
    //   314: astore_1
    //   315: goto -307 -> 8
    //   318: astore 6
    //   320: aconst_null
    //   321: astore_1
    //   322: goto -45 -> 277
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	325	0	this	w
    //   0	325	1	paramt	t
    //   1	266	2	i	int
    //   20	45	3	l	long
    //   68	41	5	bool	boolean
    //   15	273	6	localObject1	Object
    //   299	1	6	localObject2	Object
    //   306	1	6	str	String
    //   318	1	6	localObject3	Object
    //   55	172	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   113	119	122	java/lang/InterruptedException
    //   11	35	290	finally
    //   35	70	290	finally
    //   84	93	290	finally
    //   93	108	290	finally
    //   113	119	290	finally
    //   212	218	290	finally
    //   218	274	290	finally
    //   281	287	290	finally
    //   287	290	290	finally
    //   11	35	295	java/lang/Exception
    //   35	70	295	java/lang/Exception
    //   154	208	299	finally
    //   84	93	314	java/lang/Exception
    //   93	108	314	java/lang/Exception
    //   113	119	314	java/lang/Exception
    //   212	218	314	java/lang/Exception
    //   218	274	314	java/lang/Exception
    //   281	287	314	java/lang/Exception
    //   287	290	314	java/lang/Exception
    //   126	150	318	finally
  }
  
  /* Error */
  public final void a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 76	ct/w:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: astore 6
    //   8: aload 6
    //   10: invokevirtual 80	android/database/sqlite/SQLiteDatabase:isDbLockedByOtherThreads	()Z
    //   13: ifne +15 -> 28
    //   16: aload 6
    //   18: invokevirtual 83	android/database/sqlite/SQLiteDatabase:isDbLockedByCurrentThread	()Z
    //   21: istore 5
    //   23: iload 5
    //   25: ifeq +17 -> 42
    //   28: ldc2_w 84
    //   31: invokestatic 91	java/lang/Thread:sleep	(J)V
    //   34: goto -26 -> 8
    //   37: astore 7
    //   39: goto -31 -> 8
    //   42: new 93	android/content/ContentValues
    //   45: dup
    //   46: invokespecial 94	android/content/ContentValues:<init>	()V
    //   49: astore 7
    //   51: aload 7
    //   53: ldc -59
    //   55: aload_3
    //   56: invokevirtual 104	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload 6
    //   61: ldc 126
    //   63: aload 7
    //   65: ldc -128
    //   67: iconst_2
    //   68: anewarray 130	java/lang/String
    //   71: dup
    //   72: iconst_0
    //   73: aload_1
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: aload_2
    //   78: aastore
    //   79: invokevirtual 135	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   82: istore 4
    //   84: new 37	java/lang/StringBuilder
    //   87: dup
    //   88: ldc_w 284
    //   91: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   94: aload_1
    //   95: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: ldc_w 286
    //   101: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: iload 4
    //   106: invokevirtual 167	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: invokestatic 160	ct/bd:b	()V
    //   113: aload_0
    //   114: monitorexit
    //   115: return
    //   116: astore_1
    //   117: aload_0
    //   118: monitorexit
    //   119: aload_1
    //   120: athrow
    //   121: astore_1
    //   122: goto -9 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	w
    //   0	125	1	paramString1	String
    //   0	125	2	paramString2	String
    //   0	125	3	paramString3	String
    //   82	23	4	i	int
    //   21	3	5	bool	boolean
    //   6	54	6	localSQLiteDatabase	SQLiteDatabase
    //   37	1	7	localInterruptedException	InterruptedException
    //   49	15	7	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   28	34	37	java/lang/InterruptedException
    //   2	8	116	finally
    //   8	23	116	finally
    //   28	34	116	finally
    //   42	113	116	finally
    //   2	8	121	java/lang/Exception
    //   8	23	121	java/lang/Exception
    //   28	34	121	java/lang/Exception
    //   42	113	121	java/lang/Exception
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS access_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,domain TEXT,rule TEXT,iplist TEXT,last_suc_ip TEXT,apn_lasttime INTEGER,schedule_lasttime INTEGER);");
      bd.b();
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      bd.d();
    }
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS access_tbl");
      try
      {
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS access_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,domain TEXT,rule TEXT,iplist TEXT,last_suc_ip TEXT,apn_lasttime INTEGER,schedule_lasttime INTEGER);");
        bd.b();
        return;
      }
      catch (SQLException paramSQLiteDatabase)
      {
        throw paramSQLiteDatabase;
      }
    }
    catch (Exception paramSQLiteDatabase) {}catch (SQLException localSQLException)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 295	android/database/sqlite/SQLiteOpenHelper:onOpen	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   5: aload_1
    //   6: invokevirtual 298	android/database/sqlite/SQLiteDatabase:getVersion	()I
    //   9: istore_2
    //   10: iload_2
    //   11: ifeq +16 -> 27
    //   14: iload_2
    //   15: iconst_5
    //   16: if_icmpge +12 -> 28
    //   19: aload_1
    //   20: invokestatic 300	ct/w:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   23: aload_1
    //   24: invokestatic 302	ct/w:b	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   27: return
    //   28: iload_2
    //   29: iconst_5
    //   30: if_icmple -3 -> 27
    //   33: aload_1
    //   34: invokestatic 300	ct/w:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   37: aload_1
    //   38: invokestatic 302	ct/w:b	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   41: return
    //   42: astore_1
    //   43: return
    //   44: astore_1
    //   45: return
    //   46: astore_1
    //   47: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	w
    //   0	48	1	paramSQLiteDatabase	SQLiteDatabase
    //   9	22	2	i	int
    // Exception table:
    //   from	to	target	type
    //   33	41	42	java/lang/Exception
    //   5	10	44	java/lang/Exception
    //   19	27	46	java/lang/Exception
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS access_tbl");
      try
      {
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS access_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,domain TEXT,rule TEXT,iplist TEXT,last_suc_ip TEXT,apn_lasttime INTEGER,schedule_lasttime INTEGER);");
        bd.b();
        return;
      }
      catch (SQLException paramSQLiteDatabase)
      {
        throw paramSQLiteDatabase;
      }
    }
    catch (Exception paramSQLiteDatabase) {}catch (SQLException localSQLException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */