package com.google.android.b;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class c
  implements BaseColumns
{
  private static HashMap a = new HashMap();
  
  public static Uri a(Uri paramUri, String paramString)
  {
    return Uri.withAppendedPath(paramUri, paramString);
  }
  
  private static f a(ContentResolver paramContentResolver, Uri paramUri)
  {
    f localf = (f)a.get(paramUri);
    if (localf == null)
    {
      localf = new f();
      a.put(paramUri, localf);
      paramContentResolver.registerContentObserver(paramUri, true, new d(localf));
      paramContentResolver = localf;
    }
    do
    {
      return paramContentResolver;
      paramContentResolver = localf;
    } while (!localf.a.getAndSet(false));
    try
    {
      localf.b.clear();
      localf.c = new Object();
      return localf;
    }
    finally {}
  }
  
  /* Error */
  protected static String a(ContentResolver paramContentResolver, Uri paramUri, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: ldc 2
    //   7: monitorenter
    //   8: aload_0
    //   9: aload_1
    //   10: invokestatic 72	com/google/android/b/c:a	(Landroid/content/ContentResolver;Landroid/net/Uri;)Lcom/google/android/b/f;
    //   13: astore 5
    //   15: ldc 2
    //   17: monitorexit
    //   18: aload 5
    //   20: monitorenter
    //   21: aload 5
    //   23: getfield 67	com/google/android/b/f:c	Ljava/lang/Object;
    //   26: astore 6
    //   28: aload 5
    //   30: getfield 60	com/google/android/b/f:b	Ljava/util/HashMap;
    //   33: aload_2
    //   34: invokevirtual 76	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   37: ifeq +21 -> 58
    //   40: aload 5
    //   42: getfield 60	com/google/android/b/f:b	Ljava/util/HashMap;
    //   45: aload_2
    //   46: invokevirtual 30	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   49: checkcast 78	java/lang/String
    //   52: astore_0
    //   53: aload 5
    //   55: monitorexit
    //   56: aload_0
    //   57: areturn
    //   58: aload 5
    //   60: monitorexit
    //   61: aload_0
    //   62: aload_1
    //   63: iconst_1
    //   64: anewarray 78	java/lang/String
    //   67: dup
    //   68: iconst_0
    //   69: ldc 80
    //   71: aastore
    //   72: ldc 82
    //   74: iconst_1
    //   75: anewarray 78	java/lang/String
    //   78: dup
    //   79: iconst_0
    //   80: aload_2
    //   81: aastore
    //   82: aconst_null
    //   83: invokevirtual 86	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   86: astore_0
    //   87: aload_0
    //   88: ifnull +43 -> 131
    //   91: aload_0
    //   92: invokeinterface 92 1 0
    //   97: ifeq +34 -> 131
    //   100: aload_0
    //   101: iconst_0
    //   102: invokeinterface 96 2 0
    //   107: astore_3
    //   108: aload 5
    //   110: aload 6
    //   112: aload_2
    //   113: aload_3
    //   114: invokestatic 99	com/google/android/b/c:a	(Lcom/google/android/b/f;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   117: aload_3
    //   118: astore_1
    //   119: aload_0
    //   120: ifnull +164 -> 284
    //   123: aload_0
    //   124: invokeinterface 102 1 0
    //   129: aload_3
    //   130: areturn
    //   131: aload 5
    //   133: aload 6
    //   135: aload_2
    //   136: aconst_null
    //   137: invokestatic 99	com/google/android/b/c:a	(Lcom/google/android/b/f;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   140: aload_0
    //   141: ifnull +9 -> 150
    //   144: aload_0
    //   145: invokeinterface 102 1 0
    //   150: aconst_null
    //   151: areturn
    //   152: astore_0
    //   153: ldc 2
    //   155: monitorexit
    //   156: aload_0
    //   157: athrow
    //   158: astore_0
    //   159: aload 5
    //   161: monitorexit
    //   162: aload_0
    //   163: athrow
    //   164: astore 4
    //   166: aconst_null
    //   167: astore_0
    //   168: new 104	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   175: astore 5
    //   177: aload 5
    //   179: ldc 107
    //   181: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload 5
    //   187: aload_2
    //   188: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload 5
    //   194: ldc 113
    //   196: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload 5
    //   202: aload_1
    //   203: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: ldc 118
    //   209: aload 5
    //   211: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: aload 4
    //   216: invokestatic 128	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   219: pop
    //   220: aload_0
    //   221: astore_1
    //   222: aload_3
    //   223: ifnull +61 -> 284
    //   226: aload_3
    //   227: invokeinterface 102 1 0
    //   232: aload_0
    //   233: areturn
    //   234: astore_1
    //   235: aload_0
    //   236: astore_3
    //   237: aload_1
    //   238: astore_0
    //   239: aload_3
    //   240: ifnull +9 -> 249
    //   243: aload_3
    //   244: invokeinterface 102 1 0
    //   249: aload_0
    //   250: athrow
    //   251: astore 4
    //   253: aload_0
    //   254: astore_3
    //   255: aconst_null
    //   256: astore_0
    //   257: goto -89 -> 168
    //   260: astore 4
    //   262: aload_0
    //   263: astore 5
    //   265: aload_3
    //   266: astore_0
    //   267: aload 5
    //   269: astore_3
    //   270: goto -102 -> 168
    //   273: astore_0
    //   274: goto -35 -> 239
    //   277: astore_0
    //   278: aload 4
    //   280: astore_3
    //   281: goto -42 -> 239
    //   284: aload_1
    //   285: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	paramContentResolver	ContentResolver
    //   0	286	1	paramUri	Uri
    //   0	286	2	paramString	String
    //   4	277	3	localObject1	Object
    //   1	1	4	localObject2	Object
    //   164	51	4	localSQLException1	android.database.SQLException
    //   251	1	4	localSQLException2	android.database.SQLException
    //   260	19	4	localSQLException3	android.database.SQLException
    //   13	255	5	localObject3	Object
    //   26	108	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   8	18	152	finally
    //   153	156	152	finally
    //   21	56	158	finally
    //   58	61	158	finally
    //   159	162	158	finally
    //   61	87	164	android/database/SQLException
    //   91	108	234	finally
    //   108	117	234	finally
    //   131	140	234	finally
    //   91	108	251	android/database/SQLException
    //   131	140	251	android/database/SQLException
    //   108	117	260	android/database/SQLException
    //   168	220	273	finally
    //   61	87	277	finally
  }
  
  private static void a(f paramf, Object paramObject, String paramString1, String paramString2)
  {
    try
    {
      if (paramObject == paramf.c) {
        paramf.b.put(paramString1, paramString2);
      }
      return;
    }
    finally {}
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */