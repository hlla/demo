package com.google.android.finsky.aq;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

public class a
{
  public final Context a;
  public final com.google.android.finsky.af.c b;
  public final SQLiteOpenHelper c;
  public final e[] d;
  
  public a(Context paramContext, com.google.android.finsky.af.c paramc, String paramString, int paramInt, e[] paramArrayOfe)
  {
    this.a = paramContext;
    this.d = paramArrayOfe;
    this.b = paramc;
    this.c = new d(this, paramContext, paramString, paramInt);
  }
  
  public final com.google.android.finsky.af.e a()
  {
    return this.b.a(new c(this));
  }
  
  /* Error */
  public void a(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 48	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   4: aload_0
    //   5: getfield 21	com/google/android/finsky/aq/a:d	[Lcom/google/android/finsky/aq/e;
    //   8: astore 6
    //   10: aload 6
    //   12: arraylength
    //   13: istore 4
    //   15: iconst_0
    //   16: istore_2
    //   17: iload_2
    //   18: iload 4
    //   20: if_icmpge +406 -> 426
    //   23: aload 6
    //   25: iload_2
    //   26: aaload
    //   27: astore 7
    //   29: aload_1
    //   30: getstatic 54	java/util/Locale:US	Ljava/util/Locale;
    //   33: ldc 56
    //   35: iconst_1
    //   36: anewarray 4	java/lang/Object
    //   39: dup
    //   40: iconst_0
    //   41: aload 7
    //   43: getfield 61	com/google/android/finsky/aq/e:b	Ljava/lang/String;
    //   46: aastore
    //   47: invokestatic 67	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   50: aconst_null
    //   51: invokevirtual 71	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   54: astore 9
    //   56: aload 9
    //   58: ifnull +359 -> 417
    //   61: aload 9
    //   63: invokeinterface 77 1 0
    //   68: ifne +349 -> 417
    //   71: new 79	android/support/v4/g/a
    //   74: dup
    //   75: invokespecial 80	android/support/v4/g/a:<init>	()V
    //   78: astore 8
    //   80: aload 9
    //   82: invokeinterface 83 1 0
    //   87: ifeq +51 -> 138
    //   90: aload 8
    //   92: aload 9
    //   94: iconst_1
    //   95: invokeinterface 87 2 0
    //   100: aload 9
    //   102: iconst_2
    //   103: invokeinterface 87 2 0
    //   108: invokeinterface 93 3 0
    //   113: pop
    //   114: goto -34 -> 80
    //   117: astore 6
    //   119: aload 9
    //   121: invokeinterface 96 1 0
    //   126: aload 6
    //   128: athrow
    //   129: astore 6
    //   131: aload_1
    //   132: invokevirtual 99	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   135: aload 6
    //   137: athrow
    //   138: aload 9
    //   140: invokeinterface 96 1 0
    //   145: new 101	java/util/ArrayList
    //   148: dup
    //   149: invokespecial 102	java/util/ArrayList:<init>	()V
    //   152: astore 9
    //   154: aload 7
    //   156: getfield 105	com/google/android/finsky/aq/e:a	Ljava/util/Map;
    //   159: invokeinterface 109 1 0
    //   164: invokeinterface 115 1 0
    //   169: astore 10
    //   171: aload 10
    //   173: invokeinterface 120 1 0
    //   178: ifne +81 -> 259
    //   181: aload 9
    //   183: invokeinterface 126 1 0
    //   188: istore 5
    //   190: iconst_0
    //   191: istore_3
    //   192: goto +243 -> 435
    //   195: aload 9
    //   197: iload_3
    //   198: invokeinterface 130 2 0
    //   203: checkcast 132	java/util/Map$Entry
    //   206: astore 8
    //   208: aload_1
    //   209: getstatic 54	java/util/Locale:US	Ljava/util/Locale;
    //   212: ldc -122
    //   214: iconst_3
    //   215: anewarray 4	java/lang/Object
    //   218: dup
    //   219: iconst_0
    //   220: aload 7
    //   222: getfield 61	com/google/android/finsky/aq/e:b	Ljava/lang/String;
    //   225: aastore
    //   226: dup
    //   227: iconst_1
    //   228: aload 8
    //   230: invokeinterface 138 1 0
    //   235: aastore
    //   236: dup
    //   237: iconst_2
    //   238: aload 8
    //   240: invokeinterface 141 1 0
    //   245: aastore
    //   246: invokestatic 67	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   249: invokevirtual 145	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   252: iload_3
    //   253: iconst_1
    //   254: iadd
    //   255: istore_3
    //   256: goto +179 -> 435
    //   259: aload 10
    //   261: invokeinterface 148 1 0
    //   266: checkcast 132	java/util/Map$Entry
    //   269: astore 11
    //   271: aload 8
    //   273: aload 11
    //   275: invokeinterface 138 1 0
    //   280: invokeinterface 152 2 0
    //   285: ifeq +82 -> 367
    //   288: aload 11
    //   290: invokeinterface 141 1 0
    //   295: checkcast 63	java/lang/String
    //   298: aload 8
    //   300: aload 11
    //   302: invokeinterface 138 1 0
    //   307: invokeinterface 155 2 0
    //   312: invokevirtual 158	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   315: ifne -144 -> 171
    //   318: ldc -96
    //   320: iconst_3
    //   321: anewarray 4	java/lang/Object
    //   324: dup
    //   325: iconst_0
    //   326: aload 11
    //   328: invokeinterface 138 1 0
    //   333: aastore
    //   334: dup
    //   335: iconst_1
    //   336: aload 8
    //   338: aload 11
    //   340: invokeinterface 138 1 0
    //   345: invokeinterface 155 2 0
    //   350: aastore
    //   351: dup
    //   352: iconst_2
    //   353: aload 11
    //   355: invokeinterface 141 1 0
    //   360: aastore
    //   361: invokestatic 166	com/google/android/finsky/utils/FinskyLog:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   364: goto -193 -> 171
    //   367: ldc -88
    //   369: iconst_3
    //   370: anewarray 4	java/lang/Object
    //   373: dup
    //   374: iconst_0
    //   375: aload 11
    //   377: invokeinterface 138 1 0
    //   382: aastore
    //   383: dup
    //   384: iconst_1
    //   385: aload 11
    //   387: invokeinterface 141 1 0
    //   392: aastore
    //   393: dup
    //   394: iconst_2
    //   395: aload 7
    //   397: getfield 61	com/google/android/finsky/aq/e:b	Ljava/lang/String;
    //   400: aastore
    //   401: invokestatic 170	com/google/android/finsky/utils/FinskyLog:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   404: aload 9
    //   406: aload 11
    //   408: invokeinterface 173 2 0
    //   413: pop
    //   414: goto -243 -> 171
    //   417: aload 7
    //   419: aload_1
    //   420: invokevirtual 176	com/google/android/finsky/aq/e:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   423: goto +18 -> 441
    //   426: aload_1
    //   427: invokevirtual 179	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   430: aload_1
    //   431: invokevirtual 99	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   434: return
    //   435: iload_3
    //   436: iload 5
    //   438: if_icmplt -243 -> 195
    //   441: iload_2
    //   442: iconst_1
    //   443: iadd
    //   444: istore_2
    //   445: goto -428 -> 17
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	448	0	this	a
    //   0	448	1	paramSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   0	448	2	paramInt1	int
    //   0	448	3	paramInt2	int
    //   13	8	4	i	int
    //   188	251	5	j	int
    //   8	16	6	arrayOfe	e[]
    //   117	10	6	localObject1	Object
    //   129	7	6	localObject2	Object
    //   27	391	7	locale	e
    //   78	259	8	localObject3	Object
    //   54	351	9	localObject4	Object
    //   169	91	10	localIterator	java.util.Iterator
    //   269	138	11	localEntry	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   80	114	117	finally
    //   4	15	129	finally
    //   29	56	129	finally
    //   61	80	129	finally
    //   119	129	129	finally
    //   138	171	129	finally
    //   171	190	129	finally
    //   195	252	129	finally
    //   259	364	129	finally
    //   367	414	129	finally
    //   417	423	129	finally
    //   426	430	129	finally
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/aq/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */