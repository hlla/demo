package com.tencent.recovery.report;

import android.content.Context;
import java.io.File;

public class RecoveryReporter
{
  /* Error */
  public static <T extends com.tencent.recovery.model.RecoveryPersistentItem> java.util.List<T> a(Context paramContext, String paramString, Class<T> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 19	com/tencent/recovery/report/RecoveryReporter:fr	(Landroid/content/Context;)Ljava/io/File;
    //   4: astore_0
    //   5: new 21	java/util/LinkedList
    //   8: dup
    //   9: invokespecial 22	java/util/LinkedList:<init>	()V
    //   12: astore 5
    //   14: new 24	java/io/File
    //   17: dup
    //   18: aload_0
    //   19: aload_1
    //   20: invokespecial 27	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   23: astore 6
    //   25: aload 6
    //   27: invokevirtual 31	java/io/File:length	()J
    //   30: ldc2_w 32
    //   33: lcmp
    //   34: ifle +23 -> 57
    //   37: ldc 35
    //   39: ldc 37
    //   41: iconst_0
    //   42: anewarray 4	java/lang/Object
    //   45: invokestatic 43	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   48: aload 6
    //   50: invokevirtual 47	java/io/File:delete	()Z
    //   53: pop
    //   54: aload 5
    //   56: areturn
    //   57: aload 6
    //   59: invokevirtual 50	java/io/File:exists	()Z
    //   62: ifne +21 -> 83
    //   65: ldc 35
    //   67: ldc 52
    //   69: iconst_1
    //   70: anewarray 4	java/lang/Object
    //   73: dup
    //   74: iconst_0
    //   75: aload_1
    //   76: aastore
    //   77: invokestatic 43	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: aload 5
    //   82: areturn
    //   83: new 54	java/io/FileInputStream
    //   86: dup
    //   87: aload 6
    //   89: invokespecial 57	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   92: astore_1
    //   93: aload_1
    //   94: astore_0
    //   95: new 59	java/io/ByteArrayOutputStream
    //   98: dup
    //   99: aload 6
    //   101: invokevirtual 31	java/io/File:length	()J
    //   104: l2i
    //   105: invokespecial 62	java/io/ByteArrayOutputStream:<init>	(I)V
    //   108: astore 6
    //   110: aload_1
    //   111: astore_0
    //   112: sipush 4096
    //   115: newarray <illegal type>
    //   117: astore 7
    //   119: aload_1
    //   120: astore_0
    //   121: aload_1
    //   122: aload 7
    //   124: invokevirtual 66	java/io/FileInputStream:read	([B)I
    //   127: istore_3
    //   128: iload_3
    //   129: ifle +43 -> 172
    //   132: aload_1
    //   133: astore_0
    //   134: aload 6
    //   136: aload 7
    //   138: iconst_0
    //   139: iload_3
    //   140: invokevirtual 70	java/io/ByteArrayOutputStream:write	([BII)V
    //   143: goto -24 -> 119
    //   146: astore_2
    //   147: aload_1
    //   148: astore_0
    //   149: ldc 35
    //   151: aload_2
    //   152: ldc 72
    //   154: iconst_0
    //   155: anewarray 4	java/lang/Object
    //   158: invokestatic 76	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   161: aload_1
    //   162: ifnull +7 -> 169
    //   165: aload_1
    //   166: invokevirtual 79	java/io/FileInputStream:close	()V
    //   169: aload 5
    //   171: areturn
    //   172: aload_1
    //   173: astore_0
    //   174: new 81	java/lang/String
    //   177: dup
    //   178: aload 6
    //   180: invokevirtual 85	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   183: invokespecial 88	java/lang/String:<init>	([B)V
    //   186: ldc 90
    //   188: invokevirtual 94	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   191: astore 6
    //   193: aload_1
    //   194: astore_0
    //   195: aload 6
    //   197: arraylength
    //   198: istore 4
    //   200: iconst_0
    //   201: istore_3
    //   202: iload_3
    //   203: iload 4
    //   205: if_icmpge +83 -> 288
    //   208: aload 6
    //   210: iload_3
    //   211: aaload
    //   212: astore 7
    //   214: aload_1
    //   215: astore_0
    //   216: aload_2
    //   217: invokevirtual 100	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   220: checkcast 102	com/tencent/recovery/model/RecoveryPersistentItem
    //   223: astore 8
    //   225: aload_1
    //   226: astore_0
    //   227: aload 8
    //   229: aload 7
    //   231: invokevirtual 106	com/tencent/recovery/model/RecoveryPersistentItem:UU	(Ljava/lang/String;)Z
    //   234: ifeq +18 -> 252
    //   237: aload_1
    //   238: astore_0
    //   239: aload 5
    //   241: aload 8
    //   243: invokeinterface 112 2 0
    //   248: pop
    //   249: goto +70 -> 319
    //   252: aload_1
    //   253: astore_0
    //   254: ldc 35
    //   256: ldc 114
    //   258: iconst_1
    //   259: anewarray 4	java/lang/Object
    //   262: dup
    //   263: iconst_0
    //   264: aload 7
    //   266: aastore
    //   267: invokestatic 117	com/tencent/recovery/log/RecoveryLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   270: goto +49 -> 319
    //   273: astore_2
    //   274: aload_0
    //   275: astore_1
    //   276: aload_2
    //   277: astore_0
    //   278: aload_1
    //   279: ifnull +7 -> 286
    //   282: aload_1
    //   283: invokevirtual 79	java/io/FileInputStream:close	()V
    //   286: aload_0
    //   287: athrow
    //   288: aload_1
    //   289: invokevirtual 79	java/io/FileInputStream:close	()V
    //   292: goto -123 -> 169
    //   295: astore_0
    //   296: goto -127 -> 169
    //   299: astore_0
    //   300: goto -131 -> 169
    //   303: astore_1
    //   304: goto -18 -> 286
    //   307: astore_0
    //   308: aconst_null
    //   309: astore_1
    //   310: goto -32 -> 278
    //   313: astore_2
    //   314: aconst_null
    //   315: astore_1
    //   316: goto -169 -> 147
    //   319: iload_3
    //   320: iconst_1
    //   321: iadd
    //   322: istore_3
    //   323: goto -121 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	paramContext	Context
    //   0	326	1	paramString	String
    //   0	326	2	paramClass	Class<T>
    //   127	196	3	i	int
    //   198	8	4	j	int
    //   12	228	5	localLinkedList	java.util.LinkedList
    //   23	186	6	localObject	Object
    //   117	148	7	arrayOfByte	byte[]
    //   223	19	8	localRecoveryPersistentItem	com.tencent.recovery.model.RecoveryPersistentItem
    // Exception table:
    //   from	to	target	type
    //   95	110	146	java/lang/Exception
    //   112	119	146	java/lang/Exception
    //   121	128	146	java/lang/Exception
    //   134	143	146	java/lang/Exception
    //   174	193	146	java/lang/Exception
    //   195	200	146	java/lang/Exception
    //   216	225	146	java/lang/Exception
    //   227	237	146	java/lang/Exception
    //   239	249	146	java/lang/Exception
    //   254	270	146	java/lang/Exception
    //   95	110	273	finally
    //   112	119	273	finally
    //   121	128	273	finally
    //   134	143	273	finally
    //   149	161	273	finally
    //   174	193	273	finally
    //   195	200	273	finally
    //   216	225	273	finally
    //   227	237	273	finally
    //   239	249	273	finally
    //   254	270	273	finally
    //   288	292	295	java/io/IOException
    //   165	169	299	java/io/IOException
    //   282	286	303	java/io/IOException
    //   83	93	307	finally
    //   83	93	313	java/lang/Exception
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString, com.tencent.recovery.model.RecoveryPersistentItem paramRecoveryPersistentItem)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 19	com/tencent/recovery/report/RecoveryReporter:fr	(Landroid/content/Context;)Ljava/io/File;
    //   4: astore_0
    //   5: aload_2
    //   6: invokevirtual 124	com/tencent/recovery/model/RecoveryPersistentItem:cdp	()Ljava/lang/String;
    //   9: astore_2
    //   10: ldc 35
    //   12: ldc 126
    //   14: iconst_1
    //   15: anewarray 4	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: aload_2
    //   21: aastore
    //   22: invokestatic 43	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: new 24	java/io/File
    //   28: dup
    //   29: aload_0
    //   30: aload_1
    //   31: invokespecial 27	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   34: astore_0
    //   35: aload_0
    //   36: invokevirtual 31	java/io/File:length	()J
    //   39: ldc2_w 32
    //   42: lcmp
    //   43: ifle +19 -> 62
    //   46: ldc 35
    //   48: ldc -128
    //   50: iconst_0
    //   51: anewarray 4	java/lang/Object
    //   54: invokestatic 43	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   57: aload_0
    //   58: invokevirtual 47	java/io/File:delete	()Z
    //   61: pop
    //   62: aload_0
    //   63: invokevirtual 50	java/io/File:exists	()Z
    //   66: ifne +8 -> 74
    //   69: aload_0
    //   70: invokevirtual 131	java/io/File:createNewFile	()Z
    //   73: pop
    //   74: new 133	java/io/FileOutputStream
    //   77: dup
    //   78: aload_0
    //   79: iconst_1
    //   80: invokespecial 136	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   83: astore_1
    //   84: aload_1
    //   85: astore_0
    //   86: aload_1
    //   87: new 138	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   94: aload_2
    //   95: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: ldc 90
    //   100: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokevirtual 149	java/lang/String:getBytes	()[B
    //   109: invokevirtual 151	java/io/FileOutputStream:write	([B)V
    //   112: aload_1
    //   113: astore_0
    //   114: aload_1
    //   115: invokevirtual 154	java/io/FileOutputStream:flush	()V
    //   118: aload_1
    //   119: invokevirtual 155	java/io/FileOutputStream:close	()V
    //   122: iconst_1
    //   123: ireturn
    //   124: astore_2
    //   125: aconst_null
    //   126: astore_1
    //   127: aload_1
    //   128: astore_0
    //   129: ldc 35
    //   131: aload_2
    //   132: ldc -99
    //   134: iconst_0
    //   135: anewarray 4	java/lang/Object
    //   138: invokestatic 76	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   141: aload_1
    //   142: ifnull -20 -> 122
    //   145: aload_1
    //   146: invokevirtual 155	java/io/FileOutputStream:close	()V
    //   149: iconst_1
    //   150: ireturn
    //   151: astore_0
    //   152: iconst_1
    //   153: ireturn
    //   154: astore_1
    //   155: aconst_null
    //   156: astore_0
    //   157: aload_0
    //   158: ifnull +7 -> 165
    //   161: aload_0
    //   162: invokevirtual 155	java/io/FileOutputStream:close	()V
    //   165: aload_1
    //   166: athrow
    //   167: astore_1
    //   168: goto -94 -> 74
    //   171: astore_0
    //   172: iconst_1
    //   173: ireturn
    //   174: astore_0
    //   175: goto -10 -> 165
    //   178: astore_1
    //   179: goto -22 -> 157
    //   182: astore_2
    //   183: goto -56 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	paramContext	Context
    //   0	186	1	paramString	String
    //   0	186	2	paramRecoveryPersistentItem	com.tencent.recovery.model.RecoveryPersistentItem
    // Exception table:
    //   from	to	target	type
    //   74	84	124	java/lang/Exception
    //   145	149	151	java/io/IOException
    //   74	84	154	finally
    //   69	74	167	java/io/IOException
    //   118	122	171	java/io/IOException
    //   161	165	174	java/io/IOException
    //   86	112	178	finally
    //   114	118	178	finally
    //   129	141	178	finally
    //   86	112	182	java/lang/Exception
    //   114	118	182	java/lang/Exception
  }
  
  public static void bq(Context paramContext, String paramString)
  {
    new File(fr(paramContext), paramString).delete();
  }
  
  /* Error */
  public static boolean c(Context paramContext, String paramString, java.util.List<? extends com.tencent.recovery.model.RecoveryPersistentItem> paramList)
  {
    // Byte code:
    //   0: ldc 35
    //   2: ldc -93
    //   4: iconst_2
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: aload_1
    //   11: aastore
    //   12: dup
    //   13: iconst_1
    //   14: aload_2
    //   15: invokeinterface 167 1 0
    //   20: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   23: aastore
    //   24: invokestatic 43	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   27: new 24	java/io/File
    //   30: dup
    //   31: aload_0
    //   32: invokestatic 19	com/tencent/recovery/report/RecoveryReporter:fr	(Landroid/content/Context;)Ljava/io/File;
    //   35: aload_1
    //   36: invokespecial 27	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   39: astore_0
    //   40: aload_0
    //   41: invokevirtual 31	java/io/File:length	()J
    //   44: ldc2_w 32
    //   47: lcmp
    //   48: ifle +19 -> 67
    //   51: ldc 35
    //   53: ldc -128
    //   55: iconst_0
    //   56: anewarray 4	java/lang/Object
    //   59: invokestatic 43	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   62: aload_0
    //   63: invokevirtual 47	java/io/File:delete	()Z
    //   66: pop
    //   67: aload_0
    //   68: invokevirtual 50	java/io/File:exists	()Z
    //   71: ifne +8 -> 79
    //   74: aload_0
    //   75: invokevirtual 131	java/io/File:createNewFile	()Z
    //   78: pop
    //   79: new 133	java/io/FileOutputStream
    //   82: dup
    //   83: aload_0
    //   84: iconst_1
    //   85: invokespecial 136	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   88: astore_3
    //   89: aload_3
    //   90: astore_0
    //   91: aload_2
    //   92: invokeinterface 177 1 0
    //   97: astore_2
    //   98: aload_3
    //   99: astore_0
    //   100: aload_2
    //   101: invokeinterface 182 1 0
    //   106: ifeq +84 -> 190
    //   109: aload_3
    //   110: astore_0
    //   111: aload_2
    //   112: invokeinterface 185 1 0
    //   117: checkcast 102	com/tencent/recovery/model/RecoveryPersistentItem
    //   120: invokevirtual 124	com/tencent/recovery/model/RecoveryPersistentItem:cdp	()Ljava/lang/String;
    //   123: astore 4
    //   125: aload_3
    //   126: astore_0
    //   127: aload_3
    //   128: new 138	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   135: aload 4
    //   137: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc 90
    //   142: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokevirtual 149	java/lang/String:getBytes	()[B
    //   151: invokevirtual 151	java/io/FileOutputStream:write	([B)V
    //   154: goto -56 -> 98
    //   157: astore_0
    //   158: aload_3
    //   159: astore_2
    //   160: aload_0
    //   161: astore_3
    //   162: aload_2
    //   163: astore_0
    //   164: ldc 35
    //   166: aload_3
    //   167: ldc 126
    //   169: iconst_1
    //   170: anewarray 4	java/lang/Object
    //   173: dup
    //   174: iconst_0
    //   175: aload_1
    //   176: aastore
    //   177: invokestatic 76	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   180: aload_2
    //   181: ifnull +7 -> 188
    //   184: aload_2
    //   185: invokevirtual 155	java/io/FileOutputStream:close	()V
    //   188: iconst_1
    //   189: ireturn
    //   190: aload_3
    //   191: astore_0
    //   192: aload_3
    //   193: invokevirtual 154	java/io/FileOutputStream:flush	()V
    //   196: aload_3
    //   197: invokevirtual 155	java/io/FileOutputStream:close	()V
    //   200: iconst_1
    //   201: ireturn
    //   202: astore_0
    //   203: iconst_1
    //   204: ireturn
    //   205: astore_1
    //   206: aconst_null
    //   207: astore_0
    //   208: aload_0
    //   209: ifnull +7 -> 216
    //   212: aload_0
    //   213: invokevirtual 155	java/io/FileOutputStream:close	()V
    //   216: aload_1
    //   217: athrow
    //   218: astore_3
    //   219: goto -140 -> 79
    //   222: astore_0
    //   223: iconst_1
    //   224: ireturn
    //   225: astore_0
    //   226: goto -10 -> 216
    //   229: astore_1
    //   230: goto -22 -> 208
    //   233: astore_3
    //   234: aconst_null
    //   235: astore_2
    //   236: goto -74 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	paramContext	Context
    //   0	239	1	paramString	String
    //   0	239	2	paramList	java.util.List<? extends com.tencent.recovery.model.RecoveryPersistentItem>
    //   88	109	3	localObject	Object
    //   218	1	3	localIOException	java.io.IOException
    //   233	1	3	localException	Exception
    //   123	13	4	str	String
    // Exception table:
    //   from	to	target	type
    //   91	98	157	java/lang/Exception
    //   100	109	157	java/lang/Exception
    //   111	125	157	java/lang/Exception
    //   127	154	157	java/lang/Exception
    //   192	196	157	java/lang/Exception
    //   196	200	202	java/io/IOException
    //   79	89	205	finally
    //   74	79	218	java/io/IOException
    //   184	188	222	java/io/IOException
    //   212	216	225	java/io/IOException
    //   91	98	229	finally
    //   100	109	229	finally
    //   111	125	229	finally
    //   127	154	229	finally
    //   164	180	229	finally
    //   192	196	229	finally
    //   79	89	233	java/lang/Exception
  }
  
  private static File fr(Context paramContext)
  {
    paramContext = new File(paramContext.getFilesDir(), "recovery");
    if (!paramContext.exists()) {
      paramContext.mkdir();
    }
    return paramContext;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/recovery/report/RecoveryReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */