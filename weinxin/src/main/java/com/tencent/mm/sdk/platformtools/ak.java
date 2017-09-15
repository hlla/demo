package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.pm.ApplicationInfo;
import android.os.Looper;
import android.util.LruCache;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.f.e;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

public final class ak
  implements SharedPreferences
{
  public static ad urX;
  private static final Object usf;
  private static final LruCache<String, ak> ush;
  private static Class<?> usi;
  private static Method usj;
  private static Method usk;
  private static boolean usl;
  boolean gXo;
  public Map<String, Object> iGr;
  public File iyn;
  public int mMode;
  public FLock urY;
  public File urZ;
  public boolean usa;
  public int usb;
  public long usc;
  public long usd;
  public final Object use;
  public final WeakHashMap<SharedPreferences.OnSharedPreferenceChangeListener, Object> usg;
  
  static
  {
    GMTrace.i(13740808339456L, 102377);
    urX = null;
    usf = new Object();
    ush = new LruCache(5);
    usi = null;
    usj = null;
    usk = null;
    usl = false;
    GMTrace.o(13740808339456L, 102377);
  }
  
  private ak()
  {
    GMTrace.i(13736513372160L, 102345);
    this.urY = null;
    this.iyn = null;
    this.urZ = null;
    this.mMode = 0;
    this.usa = false;
    this.iGr = null;
    this.usb = 0;
    this.gXo = false;
    this.usc = 0L;
    this.usd = 0L;
    this.use = new Object();
    this.usg = new WeakHashMap();
    throw new RuntimeException("Not supported.");
  }
  
  private ak(Context paramContext, String paramString, int paramInt)
  {
    GMTrace.i(13736647589888L, 102346);
    this.urY = null;
    this.iyn = null;
    this.urZ = null;
    this.mMode = 0;
    this.usa = false;
    this.iGr = null;
    this.usb = 0;
    this.gXo = false;
    this.usc = 0L;
    this.usd = 0L;
    this.use = new Object();
    this.usg = new WeakHashMap();
    Context localContext = paramContext.getApplicationContext();
    if (urX == null) {
      urX = new ad(Looper.getMainLooper());
    }
    String str = localContext.getApplicationInfo().dataDir;
    if (str != null)
    {
      paramContext = str;
      if (str.length() != 0) {}
    }
    else
    {
      v.w("MicroMsg.MultiProcSharedPreferences", "Failed to retrive data path by ApplicationInfo.dataDir, use prefix hardcoded version instead.");
      paramContext = "/data/data/" + localContext.getPackageName();
    }
    v.i("MicroMsg.MultiProcSharedPreferences", "Path to store sp data: " + paramContext);
    paramContext = new File(paramContext, "shared_prefs");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    for (;;)
    {
      this.iyn = new File(paramContext, paramString + ".xml");
      paramContext = this.iyn;
      this.urZ = new File(paramContext.getPath() + ".bak");
      this.mMode = 4;
      this.usa = true;
      if (this.usa) {
        this.urY = new FLock(this.iyn.getPath() + ".lock");
      }
      bJh();
      GMTrace.o(13736647589888L, 102346);
      return;
      if ((!paramContext.canRead()) || (!paramContext.canWrite()))
      {
        paramContext.setReadable(true, true);
        paramContext.setWritable(true, true);
      }
    }
  }
  
  public static SharedPreferences aZ(Context paramContext, String paramString)
  {
    int j = 1;
    GMTrace.i(13736379154432L, 102344);
    if (a.bJj())
    {
      v.i("MicroMsg.MultiProcSharedPreferences", "sp: %s, use Flock version MultiProcessSP.", new Object[] { paramString });
      ak localak = (ak)ush.get(paramString);
      if (localak == null)
      {
        paramContext = new ak(paramContext, paramString, 4);
        ush.put(paramString, paramContext);
      }
      for (;;)
      {
        GMTrace.o(13736379154432L, 102344);
        return paramContext;
        for (;;)
        {
          try
          {
            if (localak.usb <= 0)
            {
              i = j;
              if (localak.usc == localak.iyn.lastModified())
              {
                if (localak.usd != localak.iyn.length()) {
                  i = j;
                }
              }
              else
              {
                if (i != 0) {
                  break label152;
                }
                paramContext = localak;
                break;
              }
            }
          }
          finally {}
          int i = 0;
        }
        label152:
        localak.bJh();
        paramContext = localak;
      }
    }
    v.i("MicroMsg.MultiProcSharedPreferences", "sp: %s, use system sp.", new Object[] { paramString });
    paramContext = paramContext.getSharedPreferences(paramString, 4);
    GMTrace.o(13736379154432L, 102344);
    return paramContext;
  }
  
  private void bJh()
  {
    GMTrace.i(13736781807616L, 102347);
    try
    {
      this.gXo = false;
      e.b(new Runnable()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: aconst_null
          //   1: astore_3
          //   2: aconst_null
          //   3: astore 5
          //   5: aconst_null
          //   6: astore 4
          //   8: aconst_null
          //   9: astore_2
          //   10: ldc2_w 42
          //   13: ldc 44
          //   15: invokestatic 28	com/tencent/gmtrace/GMTrace:i	(JI)V
          //   18: aload_0
          //   19: getfield 17	com/tencent/mm/sdk/platformtools/ak$1:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   22: astore 6
          //   24: aload 6
          //   26: monitorenter
          //   27: aload_0
          //   28: getfield 17	com/tencent/mm/sdk/platformtools/ak$1:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   31: astore 7
          //   33: aload 7
          //   35: getfield 48	com/tencent/mm/sdk/platformtools/ak:usa	Z
          //   38: istore_1
          //   39: iload_1
          //   40: ifeq +11 -> 51
          //   43: aload 7
          //   45: getfield 52	com/tencent/mm/sdk/platformtools/ak:urY	Lcom/tencent/mm/sdk/platformtools/FLock;
          //   48: invokevirtual 57	com/tencent/mm/sdk/platformtools/FLock:bIs	()V
          //   51: aload 7
          //   53: getfield 60	com/tencent/mm/sdk/platformtools/ak:gXo	Z
          //   56: istore_1
          //   57: iload_1
          //   58: ifeq +57 -> 115
          //   61: aload 7
          //   63: getfield 48	com/tencent/mm/sdk/platformtools/ak:usa	Z
          //   66: istore_1
          //   67: iload_1
          //   68: ifeq +11 -> 79
          //   71: aload 7
          //   73: getfield 52	com/tencent/mm/sdk/platformtools/ak:urY	Lcom/tencent/mm/sdk/platformtools/FLock;
          //   76: invokevirtual 63	com/tencent/mm/sdk/platformtools/FLock:unlock	()V
          //   79: aload 6
          //   81: monitorexit
          //   82: ldc2_w 42
          //   85: ldc 44
          //   87: invokestatic 31	com/tencent/gmtrace/GMTrace:o	(JI)V
          //   90: return
          //   91: astore 8
          //   93: ldc 65
          //   95: aload 8
          //   97: ldc 67
          //   99: iconst_0
          //   100: anewarray 4	java/lang/Object
          //   103: invokestatic 73	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   106: goto -55 -> 51
          //   109: astore_2
          //   110: aload 6
          //   112: monitorexit
          //   113: aload_2
          //   114: athrow
          //   115: aload 7
          //   117: getfield 77	com/tencent/mm/sdk/platformtools/ak:urZ	Ljava/io/File;
          //   120: invokevirtual 83	java/io/File:exists	()Z
          //   123: ifeq +26 -> 149
          //   126: aload 7
          //   128: getfield 86	com/tencent/mm/sdk/platformtools/ak:iyn	Ljava/io/File;
          //   131: invokevirtual 89	java/io/File:delete	()Z
          //   134: pop
          //   135: aload 7
          //   137: getfield 77	com/tencent/mm/sdk/platformtools/ak:urZ	Ljava/io/File;
          //   140: aload 7
          //   142: getfield 86	com/tencent/mm/sdk/platformtools/ak:iyn	Ljava/io/File;
          //   145: invokevirtual 93	java/io/File:renameTo	(Ljava/io/File;)Z
          //   148: pop
          //   149: aload 7
          //   151: getfield 86	com/tencent/mm/sdk/platformtools/ak:iyn	Ljava/io/File;
          //   154: invokevirtual 83	java/io/File:exists	()Z
          //   157: ifeq +44 -> 201
          //   160: aload 7
          //   162: getfield 86	com/tencent/mm/sdk/platformtools/ak:iyn	Ljava/io/File;
          //   165: invokevirtual 96	java/io/File:canRead	()Z
          //   168: ifne +33 -> 201
          //   171: ldc 65
          //   173: new 98	java/lang/StringBuilder
          //   176: dup
          //   177: ldc 100
          //   179: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   182: aload 7
          //   184: getfield 86	com/tencent/mm/sdk/platformtools/ak:iyn	Ljava/io/File;
          //   187: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
          //   190: ldc 109
          //   192: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   195: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   198: invokestatic 120	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   201: aload 7
          //   203: getfield 86	com/tencent/mm/sdk/platformtools/ak:iyn	Ljava/io/File;
          //   206: invokevirtual 96	java/io/File:canRead	()Z
          //   209: istore_1
          //   210: iload_1
          //   211: ifeq +57 -> 268
          //   214: new 122	java/io/BufferedInputStream
          //   217: dup
          //   218: new 124	java/io/FileInputStream
          //   221: dup
          //   222: aload 7
          //   224: getfield 86	com/tencent/mm/sdk/platformtools/ak:iyn	Ljava/io/File;
          //   227: invokespecial 127	java/io/FileInputStream:<init>	(Ljava/io/File;)V
          //   230: sipush 16384
          //   233: invokespecial 130	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
          //   236: astore 8
          //   238: invokestatic 136	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
          //   241: astore_2
          //   242: aload_2
          //   243: aload 8
          //   245: aconst_null
          //   246: invokeinterface 142 3 0
          //   251: aload_2
          //   252: iconst_1
          //   253: anewarray 144	java/lang/String
          //   256: invokestatic 150	com/tencent/mm/sdk/platformtools/bh:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;)Ljava/lang/Object;
          //   259: checkcast 152	java/util/HashMap
          //   262: astore_2
          //   263: aload 8
          //   265: invokevirtual 155	java/io/BufferedInputStream:close	()V
          //   268: aload 7
          //   270: iconst_1
          //   271: putfield 60	com/tencent/mm/sdk/platformtools/ak:gXo	Z
          //   274: aload_2
          //   275: ifnull +151 -> 426
          //   278: aload 7
          //   280: aload_2
          //   281: putfield 159	com/tencent/mm/sdk/platformtools/ak:iGr	Ljava/util/Map;
          //   284: aload 7
          //   286: aload 7
          //   288: getfield 86	com/tencent/mm/sdk/platformtools/ak:iyn	Ljava/io/File;
          //   291: invokevirtual 163	java/io/File:lastModified	()J
          //   294: putfield 167	com/tencent/mm/sdk/platformtools/ak:usc	J
          //   297: aload 7
          //   299: aload 7
          //   301: getfield 86	com/tencent/mm/sdk/platformtools/ak:iyn	Ljava/io/File;
          //   304: invokevirtual 170	java/io/File:length	()J
          //   307: putfield 173	com/tencent/mm/sdk/platformtools/ak:usd	J
          //   310: aload 7
          //   312: invokevirtual 176	java/lang/Object:notifyAll	()V
          //   315: aload 7
          //   317: getfield 48	com/tencent/mm/sdk/platformtools/ak:usa	Z
          //   320: istore_1
          //   321: iload_1
          //   322: ifeq -243 -> 79
          //   325: aload 7
          //   327: getfield 52	com/tencent/mm/sdk/platformtools/ak:urY	Lcom/tencent/mm/sdk/platformtools/FLock;
          //   330: invokevirtual 63	com/tencent/mm/sdk/platformtools/FLock:unlock	()V
          //   333: goto -254 -> 79
          //   336: astore_2
          //   337: goto -258 -> 79
          //   340: astore 4
          //   342: aload_3
          //   343: astore_2
          //   344: aload 4
          //   346: astore_3
          //   347: ldc 65
          //   349: ldc -78
          //   351: iconst_1
          //   352: anewarray 4	java/lang/Object
          //   355: dup
          //   356: iconst_0
          //   357: aload_3
          //   358: aastore
          //   359: invokestatic 181	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   362: goto -94 -> 268
          //   365: astore_2
          //   366: aload 7
          //   368: getfield 48	com/tencent/mm/sdk/platformtools/ak:usa	Z
          //   371: istore_1
          //   372: iload_1
          //   373: ifeq +11 -> 384
          //   376: aload 7
          //   378: getfield 52	com/tencent/mm/sdk/platformtools/ak:urY	Lcom/tencent/mm/sdk/platformtools/FLock;
          //   381: invokevirtual 63	com/tencent/mm/sdk/platformtools/FLock:unlock	()V
          //   384: aload_2
          //   385: athrow
          //   386: astore_3
          //   387: aload 5
          //   389: astore_2
          //   390: ldc 65
          //   392: ldc -78
          //   394: iconst_1
          //   395: anewarray 4	java/lang/Object
          //   398: dup
          //   399: iconst_0
          //   400: aload_3
          //   401: aastore
          //   402: invokestatic 181	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   405: goto -137 -> 268
          //   408: ldc 65
          //   410: ldc -78
          //   412: iconst_1
          //   413: anewarray 4	java/lang/Object
          //   416: dup
          //   417: iconst_0
          //   418: aload_3
          //   419: aastore
          //   420: invokestatic 181	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   423: goto -155 -> 268
          //   426: aload 7
          //   428: new 152	java/util/HashMap
          //   431: dup
          //   432: invokespecial 182	java/util/HashMap:<init>	()V
          //   435: putfield 159	com/tencent/mm/sdk/platformtools/ak:iGr	Ljava/util/Map;
          //   438: goto -128 -> 310
          //   441: astore_3
          //   442: goto -58 -> 384
          //   445: astore_3
          //   446: goto -38 -> 408
          //   449: astore_3
          //   450: goto -60 -> 390
          //   453: astore_3
          //   454: goto -107 -> 347
          //   457: astore_2
          //   458: goto -379 -> 79
          //   461: astore_3
          //   462: aload 4
          //   464: astore_2
          //   465: goto -57 -> 408
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	468	0	this	1
          //   38	335	1	bool	boolean
          //   9	1	2	localObject1	Object
          //   109	5	2	localObject2	Object
          //   241	40	2	localObject3	Object
          //   336	1	2	localException1	Exception
          //   343	1	2	localObject4	Object
          //   365	20	2	localObject5	Object
          //   389	1	2	localObject6	Object
          //   457	1	2	localException2	Exception
          //   464	1	2	localXmlPullParserException1	org.xmlpull.v1.XmlPullParserException
          //   1	357	3	localObject7	Object
          //   386	33	3	localFileNotFoundException1	FileNotFoundException
          //   441	1	3	localException3	Exception
          //   445	1	3	localIOException1	java.io.IOException
          //   449	1	3	localFileNotFoundException2	FileNotFoundException
          //   453	1	3	localXmlPullParserException2	org.xmlpull.v1.XmlPullParserException
          //   461	1	3	localIOException2	java.io.IOException
          //   6	1	4	localObject8	Object
          //   340	123	4	localXmlPullParserException3	org.xmlpull.v1.XmlPullParserException
          //   3	385	5	localObject9	Object
          //   22	89	6	localak1	ak
          //   31	396	7	localak2	ak
          //   91	5	8	localException4	Exception
          //   236	28	8	localBufferedInputStream	java.io.BufferedInputStream
          // Exception table:
          //   from	to	target	type
          //   43	51	91	java/lang/Exception
          //   27	39	109	finally
          //   43	51	109	finally
          //   61	67	109	finally
          //   71	79	109	finally
          //   79	82	109	finally
          //   93	106	109	finally
          //   110	113	109	finally
          //   315	321	109	finally
          //   325	333	109	finally
          //   366	372	109	finally
          //   376	384	109	finally
          //   384	386	109	finally
          //   325	333	336	java/lang/Exception
          //   214	263	340	org/xmlpull/v1/XmlPullParserException
          //   51	57	365	finally
          //   115	149	365	finally
          //   149	201	365	finally
          //   201	210	365	finally
          //   214	263	365	finally
          //   263	268	365	finally
          //   268	274	365	finally
          //   278	310	365	finally
          //   310	315	365	finally
          //   347	362	365	finally
          //   390	405	365	finally
          //   408	423	365	finally
          //   426	438	365	finally
          //   214	263	386	java/io/FileNotFoundException
          //   376	384	441	java/lang/Exception
          //   263	268	445	java/io/IOException
          //   263	268	449	java/io/FileNotFoundException
          //   263	268	453	org/xmlpull/v1/XmlPullParserException
          //   71	79	457	java/lang/Exception
          //   214	263	461	java/io/IOException
        }
      }, "MultiProcessSP-LoadThread").start();
      GMTrace.o(13736781807616L, 102347);
      return;
    }
    finally {}
  }
  
  private void bJi()
  {
    GMTrace.i(13737184460800L, 102350);
    if ((this.gXo) || (usl) || (usi == null)) {}
    try
    {
      usi = Class.forName("dalvik.system.BlockGuard");
      if (usj != null) {}
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        Object localObject = usi.getDeclaredMethod("getThreadPolicy", new Class[0]);
        usj = (Method)localObject;
        ((Method)localObject).setAccessible(true);
        for (;;)
        {
          try
          {
            if (usj != null)
            {
              localObject = usj.invoke(null, new Object[0]);
              if (usk == null)
              {
                Method localMethod = localObject.getClass().getDeclaredMethod("onReadFromDisk", new Class[0]);
                usk = localMethod;
                localMethod.setAccessible(true);
              }
              usk.invoke(localObject, new Object[0]);
            }
          }
          catch (Throwable localThrowable3)
          {
            usl = true;
            continue;
            GMTrace.o(13737184460800L, 102350);
          }
          if (this.gXo) {
            continue;
          }
          try
          {
            wait();
          }
          catch (InterruptedException localInterruptedException) {}
        }
        localThrowable1 = localThrowable1;
        usl = true;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          usl = true;
        }
      }
    }
  }
  
  public static void e(File paramFile, int paramInt)
  {
    boolean bool2 = false;
    GMTrace.i(16090021232640L, 119880);
    if ((paramInt & 0x1) == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramFile.setReadable(true, bool1);
      bool1 = bool2;
      if ((paramInt & 0x2) == 0) {
        bool1 = true;
      }
      paramFile.setWritable(true, bool1);
      GMTrace.o(16090021232640L, 119880);
      return;
    }
  }
  
  public final boolean contains(String paramString)
  {
    GMTrace.i(13738258202624L, 102358);
    try
    {
      bJi();
      boolean bool = this.iGr.containsKey(paramString);
      GMTrace.o(13738258202624L, 102358);
      return bool;
    }
    finally {}
  }
  
  public final SharedPreferences.Editor edit()
  {
    GMTrace.i(13738392420352L, 102359);
    try
    {
      bJi();
      b localb = new b();
      GMTrace.o(13738392420352L, 102359);
      return localb;
    }
    finally {}
  }
  
  public final Map<String, ?> getAll()
  {
    GMTrace.i(13737318678528L, 102351);
    try
    {
      bJi();
      HashMap localHashMap = new HashMap(this.iGr);
      GMTrace.o(13737318678528L, 102351);
      return localHashMap;
    }
    finally {}
  }
  
  public final boolean getBoolean(String paramString, boolean paramBoolean)
  {
    GMTrace.i(13738123984896L, 102357);
    try
    {
      bJi();
      paramString = (Boolean)this.iGr.get(paramString);
      if (paramString != null) {
        paramBoolean = paramString.booleanValue();
      }
      GMTrace.o(13738123984896L, 102357);
      return paramBoolean;
    }
    finally {}
  }
  
  public final float getFloat(String paramString, float paramFloat)
  {
    GMTrace.i(13737989767168L, 102356);
    try
    {
      bJi();
      paramString = (Float)this.iGr.get(paramString);
      if (paramString != null) {
        paramFloat = paramString.floatValue();
      }
      GMTrace.o(13737989767168L, 102356);
      return paramFloat;
    }
    finally {}
  }
  
  public final int getInt(String paramString, int paramInt)
  {
    GMTrace.i(13737721331712L, 102354);
    try
    {
      bJi();
      paramString = (Integer)this.iGr.get(paramString);
      if (paramString != null) {
        paramInt = paramString.intValue();
      }
      GMTrace.o(13737721331712L, 102354);
      return paramInt;
    }
    finally {}
  }
  
  public final long getLong(String paramString, long paramLong)
  {
    GMTrace.i(13737855549440L, 102355);
    try
    {
      bJi();
      paramString = (Long)this.iGr.get(paramString);
      if (paramString != null) {
        paramLong = paramString.longValue();
      }
      GMTrace.o(13737855549440L, 102355);
      return paramLong;
    }
    finally {}
  }
  
  /* Error */
  public final String getString(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc2_w 422
    //   3: ldc_w 424
    //   6: invokestatic 71	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_0
    //   12: invokespecial 353	com/tencent/mm/sdk/platformtools/ak:bJi	()V
    //   15: aload_0
    //   16: getfield 112	com/tencent/mm/sdk/platformtools/ak:iGr	Ljava/util/Map;
    //   19: aload_1
    //   20: invokeinterface 383 2 0
    //   25: checkcast 167	java/lang/String
    //   28: astore_1
    //   29: aload_1
    //   30: ifnull +16 -> 46
    //   33: aload_0
    //   34: monitorexit
    //   35: ldc2_w 422
    //   38: ldc_w 424
    //   41: invokestatic 96	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   44: aload_1
    //   45: areturn
    //   46: aload_2
    //   47: astore_1
    //   48: goto -15 -> 33
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	ak
    //   0	56	1	paramString1	String
    //   0	56	2	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   11	29	51	finally
    //   33	35	51	finally
    //   52	54	51	finally
  }
  
  /* Error */
  public final Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    // Byte code:
    //   0: ldc2_w 427
    //   3: ldc_w 429
    //   6: invokestatic 71	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_0
    //   12: invokespecial 353	com/tencent/mm/sdk/platformtools/ak:bJi	()V
    //   15: aload_0
    //   16: getfield 112	com/tencent/mm/sdk/platformtools/ak:iGr	Ljava/util/Map;
    //   19: aload_1
    //   20: invokeinterface 383 2 0
    //   25: checkcast 431	java/util/Set
    //   28: astore_1
    //   29: aload_1
    //   30: ifnull +16 -> 46
    //   33: aload_0
    //   34: monitorexit
    //   35: ldc2_w 427
    //   38: ldc_w 429
    //   41: invokestatic 96	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   44: aload_1
    //   45: areturn
    //   46: aload_2
    //   47: astore_1
    //   48: goto -15 -> 33
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	ak
    //   0	56	1	paramString	String
    //   0	56	2	paramSet	Set<String>
    // Exception table:
    //   from	to	target	type
    //   11	29	51	finally
    //   33	35	51	finally
    //   52	54	51	finally
  }
  
  public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    GMTrace.i(13736916025344L, 102348);
    try
    {
      this.usg.put(paramOnSharedPreferenceChangeListener, usf);
      GMTrace.o(13736916025344L, 102348);
      return;
    }
    finally {}
  }
  
  public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    GMTrace.i(13737050243072L, 102349);
    try
    {
      this.usg.remove(paramOnSharedPreferenceChangeListener);
      GMTrace.o(13737050243072L, 102349);
      return;
    }
    finally {}
  }
  
  public static final class a
  {
    private static SharedPreferences mPref;
    public static String usn;
    public static String uso;
    
    static
    {
      GMTrace.i(13746982354944L, 102423);
      mPref = aa.getContext().getSharedPreferences("pref_MultiProcSP_dyncfg", 4);
      usn = "pref_key_is_enable_MultiProcSP";
      uso = "pref_key_is_disabled_MultiProcSP_manually";
      GMTrace.o(13746982354944L, 102423);
    }
    
    private static boolean Px(String paramString)
    {
      GMTrace.i(13746713919488L, 102421);
      SharedPreferences localSharedPreferences = aa.getContext().getSharedPreferences("pref_MultiProcSP_dyncfg", 4);
      mPref = localSharedPreferences;
      if (localSharedPreferences == null)
      {
        v.w("MicroMsg.MultiProcSharedPreferences", "SharedPreferences in DynamicConfigStorage initialize failed.");
        GMTrace.o(13746713919488L, 102421);
        return false;
      }
      boolean bool = mPref.getBoolean(paramString, false);
      v.d("MicroMsg.MultiProcSharedPreferences", "DynamicConfigStorage, getValue:%b", new Object[] { Boolean.valueOf(bool) });
      GMTrace.o(13746713919488L, 102421);
      return bool;
    }
    
    public static boolean bJj()
    {
      GMTrace.i(13746579701760L, 102420);
      if ((!Px(uso)) && (Px(usn)))
      {
        GMTrace.o(13746579701760L, 102420);
        return true;
      }
      GMTrace.o(13746579701760L, 102420);
      return false;
    }
    
    public static void jP(boolean paramBoolean)
    {
      GMTrace.i(13746445484032L, 102419);
      setValue(uso, paramBoolean);
      GMTrace.o(13746445484032L, 102419);
    }
    
    public static void setValue(String paramString, boolean paramBoolean)
    {
      GMTrace.i(13746848137216L, 102422);
      if (mPref == null)
      {
        v.w("MicroMsg.MultiProcSharedPreferences", "SharedPreferences in DynamicConfigStorage initialize failed.");
        GMTrace.o(13746848137216L, 102422);
        return;
      }
      SharedPreferences.Editor localEditor = mPref.edit();
      localEditor.putBoolean(paramString, paramBoolean);
      localEditor.commit();
      GMTrace.o(13746848137216L, 102422);
    }
  }
  
  private final class b
    implements SharedPreferences.Editor
  {
    private final Map<String, Object> usp;
    private boolean usq;
    
    public b()
    {
      GMTrace.i(13773691682816L, 102622);
      this.usp = new HashMap();
      this.usq = false;
      GMTrace.o(13773691682816L, 102622);
    }
    
    private void a(final ak.c paramc, Runnable arg2)
    {
      int j = 1;
      GMTrace.i(13775302295552L, 102634);
      paramc = new Runnable()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: ldc2_w 52
          //   3: ldc 54
          //   5: invokestatic 40	com/tencent/gmtrace/GMTrace:i	(JI)V
          //   8: aload_0
          //   9: getfield 24	com/tencent/mm/sdk/platformtools/ak$b$3:uss	Lcom/tencent/mm/sdk/platformtools/ak$b;
          //   12: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   15: getfield 62	com/tencent/mm/sdk/platformtools/ak:use	Ljava/lang/Object;
          //   18: astore_2
          //   19: aload_2
          //   20: monitorenter
          //   21: aload_0
          //   22: getfield 24	com/tencent/mm/sdk/platformtools/ak$b$3:uss	Lcom/tencent/mm/sdk/platformtools/ak$b;
          //   25: astore_3
          //   26: aload_0
          //   27: getfield 26	com/tencent/mm/sdk/platformtools/ak$b$3:usr	Lcom/tencent/mm/sdk/platformtools/ak$c;
          //   30: astore 4
          //   32: aload_3
          //   33: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   36: getfield 66	com/tencent/mm/sdk/platformtools/ak:usa	Z
          //   39: istore_1
          //   40: iload_1
          //   41: ifeq +13 -> 54
          //   44: aload_3
          //   45: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   48: getfield 70	com/tencent/mm/sdk/platformtools/ak:urY	Lcom/tencent/mm/sdk/platformtools/FLock;
          //   51: invokevirtual 75	com/tencent/mm/sdk/platformtools/FLock:bIu	()V
          //   54: aload_3
          //   55: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   58: getfield 79	com/tencent/mm/sdk/platformtools/ak:iyn	Ljava/io/File;
          //   61: invokevirtual 85	java/io/File:exists	()Z
          //   64: ifeq +240 -> 304
          //   67: aload 4
          //   69: getfield 90	com/tencent/mm/sdk/platformtools/ak$c:usv	Z
          //   72: ifne +111 -> 183
          //   75: aload 4
          //   77: iconst_1
          //   78: invokevirtual 94	com/tencent/mm/sdk/platformtools/ak$c:jQ	(Z)V
          //   81: aload_3
          //   82: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   85: getfield 66	com/tencent/mm/sdk/platformtools/ak:usa	Z
          //   88: istore_1
          //   89: iload_1
          //   90: ifeq +13 -> 103
          //   93: aload_3
          //   94: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   97: getfield 70	com/tencent/mm/sdk/platformtools/ak:urY	Lcom/tencent/mm/sdk/platformtools/FLock;
          //   100: invokevirtual 97	com/tencent/mm/sdk/platformtools/FLock:unlock	()V
          //   103: aload_2
          //   104: monitorexit
          //   105: aload_0
          //   106: getfield 24	com/tencent/mm/sdk/platformtools/ak$b$3:uss	Lcom/tencent/mm/sdk/platformtools/ak$b;
          //   109: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   112: astore_2
          //   113: aload_2
          //   114: monitorenter
          //   115: aload_0
          //   116: getfield 24	com/tencent/mm/sdk/platformtools/ak$b$3:uss	Lcom/tencent/mm/sdk/platformtools/ak$b;
          //   119: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   122: astore_3
          //   123: aload_3
          //   124: aload_3
          //   125: getfield 101	com/tencent/mm/sdk/platformtools/ak:usb	I
          //   128: iconst_1
          //   129: isub
          //   130: putfield 101	com/tencent/mm/sdk/platformtools/ak:usb	I
          //   133: aload_2
          //   134: monitorexit
          //   135: aload_0
          //   136: getfield 28	com/tencent/mm/sdk/platformtools/ak$b$3:usu	Ljava/lang/Runnable;
          //   139: ifnull +12 -> 151
          //   142: aload_0
          //   143: getfield 28	com/tencent/mm/sdk/platformtools/ak$b$3:usu	Ljava/lang/Runnable;
          //   146: invokeinterface 103 1 0
          //   151: ldc2_w 52
          //   154: ldc 54
          //   156: invokestatic 43	com/tencent/gmtrace/GMTrace:o	(JI)V
          //   159: return
          //   160: astore 5
          //   162: ldc 105
          //   164: aload 5
          //   166: ldc 107
          //   168: iconst_0
          //   169: anewarray 4	java/lang/Object
          //   172: invokestatic 113	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   175: goto -121 -> 54
          //   178: astore_3
          //   179: aload_2
          //   180: monitorexit
          //   181: aload_3
          //   182: athrow
          //   183: aload_3
          //   184: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   187: getfield 116	com/tencent/mm/sdk/platformtools/ak:urZ	Ljava/io/File;
          //   190: invokevirtual 85	java/io/File:exists	()Z
          //   193: ifne +100 -> 293
          //   196: aload_3
          //   197: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   200: getfield 79	com/tencent/mm/sdk/platformtools/ak:iyn	Ljava/io/File;
          //   203: aload_3
          //   204: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   207: getfield 116	com/tencent/mm/sdk/platformtools/ak:urZ	Ljava/io/File;
          //   210: invokevirtual 120	java/io/File:renameTo	(Ljava/io/File;)Z
          //   213: ifne +91 -> 304
          //   216: ldc 105
          //   218: new 122	java/lang/StringBuilder
          //   221: dup
          //   222: ldc 124
          //   224: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   227: aload_3
          //   228: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   231: getfield 79	com/tencent/mm/sdk/platformtools/ak:iyn	Ljava/io/File;
          //   234: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
          //   237: ldc -123
          //   239: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   242: aload_3
          //   243: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   246: getfield 116	com/tencent/mm/sdk/platformtools/ak:urZ	Ljava/io/File;
          //   249: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
          //   252: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   255: invokestatic 144	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   258: aload 4
          //   260: iconst_0
          //   261: invokevirtual 94	com/tencent/mm/sdk/platformtools/ak$c:jQ	(Z)V
          //   264: aload_3
          //   265: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   268: getfield 66	com/tencent/mm/sdk/platformtools/ak:usa	Z
          //   271: istore_1
          //   272: iload_1
          //   273: ifeq -170 -> 103
          //   276: aload_3
          //   277: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   280: getfield 70	com/tencent/mm/sdk/platformtools/ak:urY	Lcom/tencent/mm/sdk/platformtools/FLock;
          //   283: invokevirtual 97	com/tencent/mm/sdk/platformtools/FLock:unlock	()V
          //   286: goto -183 -> 103
          //   289: astore_3
          //   290: goto -187 -> 103
          //   293: aload_3
          //   294: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   297: getfield 79	com/tencent/mm/sdk/platformtools/ak:iyn	Ljava/io/File;
          //   300: invokevirtual 147	java/io/File:delete	()Z
          //   303: pop
          //   304: aload_3
          //   305: aload_3
          //   306: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   309: getfield 79	com/tencent/mm/sdk/platformtools/ak:iyn	Ljava/io/File;
          //   312: invokevirtual 151	com/tencent/mm/sdk/platformtools/ak$b:x	(Ljava/io/File;)Ljava/io/FileOutputStream;
          //   315: astore 5
          //   317: aload 5
          //   319: ifnonnull +38 -> 357
          //   322: aload 4
          //   324: iconst_0
          //   325: invokevirtual 94	com/tencent/mm/sdk/platformtools/ak$c:jQ	(Z)V
          //   328: aload_3
          //   329: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   332: getfield 66	com/tencent/mm/sdk/platformtools/ak:usa	Z
          //   335: istore_1
          //   336: iload_1
          //   337: ifeq -234 -> 103
          //   340: aload_3
          //   341: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   344: getfield 70	com/tencent/mm/sdk/platformtools/ak:urY	Lcom/tencent/mm/sdk/platformtools/FLock;
          //   347: invokevirtual 97	com/tencent/mm/sdk/platformtools/FLock:unlock	()V
          //   350: goto -247 -> 103
          //   353: astore_3
          //   354: goto -251 -> 103
          //   357: aload 4
          //   359: getfield 155	com/tencent/mm/sdk/platformtools/ak$c:usx	Ljava/util/Map;
          //   362: astore 6
          //   364: invokestatic 161	android/util/Xml:newSerializer	()Lorg/xmlpull/v1/XmlSerializer;
          //   367: astore 7
          //   369: aload 7
          //   371: aload 5
          //   373: ldc -93
          //   375: invokeinterface 169 3 0
          //   380: aload 7
          //   382: aconst_null
          //   383: iconst_1
          //   384: invokestatic 175	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   387: invokeinterface 179 3 0
          //   392: aload 7
          //   394: ldc -75
          //   396: iconst_1
          //   397: invokeinterface 185 3 0
          //   402: aload 6
          //   404: aconst_null
          //   405: aload 7
          //   407: invokestatic 190	com/tencent/mm/sdk/platformtools/bh:a	(Ljava/util/Map;Ljava/lang/String;Lorg/xmlpull/v1/XmlSerializer;)V
          //   410: aload 7
          //   412: invokeinterface 193 1 0
          //   417: aload 5
          //   419: invokevirtual 199	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
          //   422: invokevirtual 204	java/io/FileDescriptor:sync	()V
          //   425: aload 5
          //   427: invokevirtual 207	java/io/FileOutputStream:close	()V
          //   430: aload_3
          //   431: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   434: getfield 79	com/tencent/mm/sdk/platformtools/ak:iyn	Ljava/io/File;
          //   437: aload_3
          //   438: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   441: getfield 210	com/tencent/mm/sdk/platformtools/ak:mMode	I
          //   444: invokestatic 213	com/tencent/mm/sdk/platformtools/ak:e	(Ljava/io/File;I)V
          //   447: aload_3
          //   448: monitorenter
          //   449: aload_3
          //   450: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   453: aload_3
          //   454: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   457: getfield 79	com/tencent/mm/sdk/platformtools/ak:iyn	Ljava/io/File;
          //   460: invokevirtual 217	java/io/File:lastModified	()J
          //   463: putfield 221	com/tencent/mm/sdk/platformtools/ak:usc	J
          //   466: aload_3
          //   467: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   470: aload_3
          //   471: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   474: getfield 79	com/tencent/mm/sdk/platformtools/ak:iyn	Ljava/io/File;
          //   477: invokevirtual 224	java/io/File:length	()J
          //   480: putfield 227	com/tencent/mm/sdk/platformtools/ak:usd	J
          //   483: aload_3
          //   484: monitorexit
          //   485: aload_3
          //   486: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   489: getfield 116	com/tencent/mm/sdk/platformtools/ak:urZ	Ljava/io/File;
          //   492: invokevirtual 147	java/io/File:delete	()Z
          //   495: pop
          //   496: aload 4
          //   498: iconst_1
          //   499: invokevirtual 94	com/tencent/mm/sdk/platformtools/ak$c:jQ	(Z)V
          //   502: aload_3
          //   503: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   506: getfield 66	com/tencent/mm/sdk/platformtools/ak:usa	Z
          //   509: istore_1
          //   510: iload_1
          //   511: ifeq -408 -> 103
          //   514: aload_3
          //   515: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   518: getfield 70	com/tencent/mm/sdk/platformtools/ak:urY	Lcom/tencent/mm/sdk/platformtools/FLock;
          //   521: invokevirtual 97	com/tencent/mm/sdk/platformtools/FLock:unlock	()V
          //   524: goto -421 -> 103
          //   527: astore_3
          //   528: goto -425 -> 103
          //   531: astore 5
          //   533: aload_3
          //   534: monitorexit
          //   535: aload 5
          //   537: athrow
          //   538: astore 5
          //   540: ldc 105
          //   542: ldc -27
          //   544: iconst_1
          //   545: anewarray 4	java/lang/Object
          //   548: dup
          //   549: iconst_0
          //   550: aload 5
          //   552: aastore
          //   553: invokestatic 233	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   556: aload_3
          //   557: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   560: getfield 79	com/tencent/mm/sdk/platformtools/ak:iyn	Ljava/io/File;
          //   563: invokevirtual 85	java/io/File:exists	()Z
          //   566: ifeq +43 -> 609
          //   569: aload_3
          //   570: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   573: getfield 79	com/tencent/mm/sdk/platformtools/ak:iyn	Ljava/io/File;
          //   576: invokevirtual 147	java/io/File:delete	()Z
          //   579: ifne +30 -> 609
          //   582: ldc 105
          //   584: new 122	java/lang/StringBuilder
          //   587: dup
          //   588: ldc -21
          //   590: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   593: aload_3
          //   594: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   597: getfield 79	com/tencent/mm/sdk/platformtools/ak:iyn	Ljava/io/File;
          //   600: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
          //   603: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   606: invokestatic 144	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   609: aload 4
          //   611: iconst_0
          //   612: invokevirtual 94	com/tencent/mm/sdk/platformtools/ak$c:jQ	(Z)V
          //   615: aload_3
          //   616: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   619: getfield 66	com/tencent/mm/sdk/platformtools/ak:usa	Z
          //   622: istore_1
          //   623: iload_1
          //   624: ifeq -521 -> 103
          //   627: aload_3
          //   628: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   631: getfield 70	com/tencent/mm/sdk/platformtools/ak:urY	Lcom/tencent/mm/sdk/platformtools/FLock;
          //   634: invokevirtual 97	com/tencent/mm/sdk/platformtools/FLock:unlock	()V
          //   637: goto -534 -> 103
          //   640: astore_3
          //   641: goto -538 -> 103
          //   644: astore 5
          //   646: ldc 105
          //   648: ldc -27
          //   650: iconst_1
          //   651: anewarray 4	java/lang/Object
          //   654: dup
          //   655: iconst_0
          //   656: aload 5
          //   658: aastore
          //   659: invokestatic 233	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   662: goto -106 -> 556
          //   665: astore 4
          //   667: aload_3
          //   668: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   671: getfield 66	com/tencent/mm/sdk/platformtools/ak:usa	Z
          //   674: istore_1
          //   675: iload_1
          //   676: ifeq +13 -> 689
          //   679: aload_3
          //   680: getfield 58	com/tencent/mm/sdk/platformtools/ak$b:usm	Lcom/tencent/mm/sdk/platformtools/ak;
          //   683: getfield 70	com/tencent/mm/sdk/platformtools/ak:urY	Lcom/tencent/mm/sdk/platformtools/FLock;
          //   686: invokevirtual 97	com/tencent/mm/sdk/platformtools/FLock:unlock	()V
          //   689: aload 4
          //   691: athrow
          //   692: astore_3
          //   693: aload_2
          //   694: monitorexit
          //   695: aload_3
          //   696: athrow
          //   697: astore_3
          //   698: goto -9 -> 689
          //   701: astore_3
          //   702: goto -599 -> 103
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	705	0	this	3
          //   39	637	1	bool	boolean
          //   25	100	3	localObject2	Object
          //   178	99	3	localObject3	Object
          //   289	52	3	localException1	Exception
          //   353	162	3	localException2	Exception
          //   527	101	3	localException3	Exception
          //   640	40	3	localException4	Exception
          //   692	4	3	localObject4	Object
          //   697	1	3	localException5	Exception
          //   701	1	3	localException6	Exception
          //   30	580	4	localc	ak.c
          //   665	25	4	localObject5	Object
          //   160	5	5	localException7	Exception
          //   315	111	5	localFileOutputStream	FileOutputStream
          //   531	5	5	localObject6	Object
          //   538	13	5	localXmlPullParserException	org.xmlpull.v1.XmlPullParserException
          //   644	13	5	localIOException	java.io.IOException
          //   362	41	6	localMap	Map
          //   367	44	7	localXmlSerializer	org.xmlpull.v1.XmlSerializer
          // Exception table:
          //   from	to	target	type
          //   44	54	160	java/lang/Exception
          //   21	40	178	finally
          //   44	54	178	finally
          //   81	89	178	finally
          //   93	103	178	finally
          //   103	105	178	finally
          //   162	175	178	finally
          //   179	181	178	finally
          //   264	272	178	finally
          //   276	286	178	finally
          //   328	336	178	finally
          //   340	350	178	finally
          //   502	510	178	finally
          //   514	524	178	finally
          //   615	623	178	finally
          //   627	637	178	finally
          //   667	675	178	finally
          //   679	689	178	finally
          //   689	692	178	finally
          //   276	286	289	java/lang/Exception
          //   340	350	353	java/lang/Exception
          //   514	524	527	java/lang/Exception
          //   449	485	531	finally
          //   533	535	531	finally
          //   304	317	538	org/xmlpull/v1/XmlPullParserException
          //   322	328	538	org/xmlpull/v1/XmlPullParserException
          //   357	449	538	org/xmlpull/v1/XmlPullParserException
          //   485	502	538	org/xmlpull/v1/XmlPullParserException
          //   535	538	538	org/xmlpull/v1/XmlPullParserException
          //   627	637	640	java/lang/Exception
          //   304	317	644	java/io/IOException
          //   322	328	644	java/io/IOException
          //   357	449	644	java/io/IOException
          //   485	502	644	java/io/IOException
          //   535	538	644	java/io/IOException
          //   54	81	665	finally
          //   183	264	665	finally
          //   293	304	665	finally
          //   304	317	665	finally
          //   322	328	665	finally
          //   357	449	665	finally
          //   485	502	665	finally
          //   535	538	665	finally
          //   540	556	665	finally
          //   556	609	665	finally
          //   609	615	665	finally
          //   646	662	665	finally
          //   115	135	692	finally
          //   693	695	692	finally
          //   679	689	697	java/lang/Exception
          //   93	103	701	java/lang/Exception
        }
      };
      int i;
      if (??? == null) {
        i = 1;
      }
      while (i != 0) {
        synchronized (ak.this)
        {
          if (ak.this.usb == 1)
          {
            i = j;
            if (i != 0)
            {
              paramc.run();
              GMTrace.o(13775302295552L, 102634);
              return;
              i = 0;
            }
          }
          else
          {
            i = 0;
          }
        }
      }
      ar.bJo().execute(paramc);
      GMTrace.o(13775302295552L, 102634);
    }
    
    private ak.c bJk()
    {
      GMTrace.i(13775168077824L, 102633);
      ak.c localc1 = new ak.c();
      for (;;)
      {
        Object localObject3;
        String str;
        synchronized (ak.this)
        {
          if (ak.this.usb > 0) {
            ak.this.iGr = new HashMap(ak.this.iGr);
          }
          localc1.usx = ak.this.iGr;
          Object localObject2 = ak.this;
          ((ak)localObject2).usb += 1;
          if (ak.this.usg.size() > 0)
          {
            i = 1;
            if (i != 0)
            {
              localc1.usw = new ArrayList();
              localc1.gNn = new HashSet(ak.this.usg.keySet());
            }
            try
            {
              if (this.usq)
              {
                if (!ak.this.iGr.isEmpty())
                {
                  localc1.usv = true;
                  ak.this.iGr.clear();
                }
                this.usq = false;
              }
              localObject2 = this.usp.entrySet().iterator();
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject3 = (Map.Entry)((Iterator)localObject2).next();
              str = (String)((Map.Entry)localObject3).getKey();
              localObject3 = ((Map.Entry)localObject3).getValue();
              if (localObject3 != this) {
                break label316;
              }
              if (!ak.this.iGr.containsKey(str)) {
                continue;
              }
              ak.this.iGr.remove(str);
              localc1.usv = true;
              if (i == 0) {
                continue;
              }
              localc1.usw.add(str);
              continue;
              localc2 = finally;
            }
            finally {}
          }
        }
        int i = 0;
        continue;
        label316:
        if (ak.this.iGr.containsKey(str))
        {
          Object localObject4 = ak.this.iGr.get(str);
          if ((localObject4 != null) && (localObject4.equals(localObject3))) {}
        }
        else
        {
          ak.this.iGr.put(str, localObject3);
        }
      }
      this.usp.clear();
      GMTrace.o(13775168077824L, 102633);
      return localc2;
    }
    
    public final void a(final ak.c paramc)
    {
      GMTrace.i(13775570731008L, 102636);
      if ((paramc.gNn == null) || (paramc.usw == null) || (paramc.usw.size() == 0))
      {
        GMTrace.o(13775570731008L, 102636);
        return;
      }
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        int i = paramc.usw.size() - 1;
        while (i >= 0)
        {
          String str = (String)paramc.usw.get(i);
          Iterator localIterator = paramc.gNn.iterator();
          while (localIterator.hasNext())
          {
            SharedPreferences.OnSharedPreferenceChangeListener localOnSharedPreferenceChangeListener = (SharedPreferences.OnSharedPreferenceChangeListener)localIterator.next();
            if (localOnSharedPreferenceChangeListener != null) {
              localOnSharedPreferenceChangeListener.onSharedPreferenceChanged(ak.this, str);
            }
          }
          i -= 1;
        }
        GMTrace.o(13775570731008L, 102636);
        return;
      }
      ak.urX.post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(13746311266304L, 102418);
          ak.b.this.a(paramc);
          GMTrace.o(13746311266304L, 102418);
        }
      });
      GMTrace.o(13775570731008L, 102636);
    }
    
    public final void apply()
    {
      GMTrace.i(13775033860096L, 102632);
      final ak.c localc = bJk();
      final Runnable local1 = new Runnable()
      {
        public final void run()
        {
          GMTrace.i(13741345210368L, 102381);
          try
          {
            localc.usy.await();
            GMTrace.o(13741345210368L, 102381);
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            GMTrace.o(13741345210368L, 102381);
          }
        }
      };
      ar.K(local1);
      a(localc, new Runnable()
      {
        public final void run()
        {
          GMTrace.i(13768322973696L, 102582);
          local1.run();
          ar.L(local1);
          GMTrace.o(13768322973696L, 102582);
        }
      });
      a(localc);
      GMTrace.o(13775033860096L, 102632);
    }
    
    public final SharedPreferences.Editor clear()
    {
      GMTrace.i(13774765424640L, 102630);
      try
      {
        this.usq = true;
        GMTrace.o(13774765424640L, 102630);
        return this;
      }
      finally {}
    }
    
    public final boolean commit()
    {
      GMTrace.i(13774899642368L, 102631);
      ak.c localc = bJk();
      a(localc, null);
      try
      {
        localc.usy.await();
        a(localc);
        boolean bool = localc.usz;
        GMTrace.o(13774899642368L, 102631);
        return bool;
      }
      catch (InterruptedException localInterruptedException)
      {
        GMTrace.o(13774899642368L, 102631);
      }
      return false;
    }
    
    public final SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
    {
      GMTrace.i(13774496989184L, 102628);
      try
      {
        this.usp.put(paramString, Boolean.valueOf(paramBoolean));
        GMTrace.o(13774496989184L, 102628);
        return this;
      }
      finally {}
    }
    
    public final SharedPreferences.Editor putFloat(String paramString, float paramFloat)
    {
      GMTrace.i(13774362771456L, 102627);
      try
      {
        this.usp.put(paramString, Float.valueOf(paramFloat));
        GMTrace.o(13774362771456L, 102627);
        return this;
      }
      finally {}
    }
    
    public final SharedPreferences.Editor putInt(String paramString, int paramInt)
    {
      GMTrace.i(13774094336000L, 102625);
      try
      {
        this.usp.put(paramString, Integer.valueOf(paramInt));
        GMTrace.o(13774094336000L, 102625);
        return this;
      }
      finally {}
    }
    
    public final SharedPreferences.Editor putLong(String paramString, long paramLong)
    {
      GMTrace.i(13774228553728L, 102626);
      try
      {
        this.usp.put(paramString, Long.valueOf(paramLong));
        GMTrace.o(13774228553728L, 102626);
        return this;
      }
      finally {}
    }
    
    public final SharedPreferences.Editor putString(String paramString1, String paramString2)
    {
      GMTrace.i(13773825900544L, 102623);
      try
      {
        this.usp.put(paramString1, paramString2);
        GMTrace.o(13773825900544L, 102623);
        return this;
      }
      finally {}
    }
    
    public final SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
    {
      GMTrace.i(13773960118272L, 102624);
      try
      {
        this.usp.put(paramString, paramSet);
        GMTrace.o(13773960118272L, 102624);
        return this;
      }
      finally {}
    }
    
    public final SharedPreferences.Editor remove(String paramString)
    {
      GMTrace.i(13774631206912L, 102629);
      try
      {
        this.usp.put(paramString, this);
        GMTrace.o(13774631206912L, 102629);
        return this;
      }
      finally {}
    }
    
    final FileOutputStream x(File paramFile)
    {
      GMTrace.i(13775436513280L, 102635);
      try
      {
        FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
        paramFile = localFileOutputStream;
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        for (;;)
        {
          Object localObject = paramFile.getParentFile();
          if (!((File)localObject).mkdir())
          {
            v.e("MicroMsg.MultiProcSharedPreferences", "Couldn't create directory for SharedPreferences file " + paramFile);
            GMTrace.o(13775436513280L, 102635);
            return null;
          }
          ak.e((File)localObject, ak.this.mMode);
          try
          {
            localObject = new FileOutputStream(paramFile);
            paramFile = (File)localObject;
          }
          catch (FileNotFoundException localFileNotFoundException2)
          {
            v.e("MicroMsg.MultiProcSharedPreferences", "Couldn't create SharedPreferences file " + paramFile, new Object[] { localFileNotFoundException2 });
            paramFile = null;
          }
        }
      }
      GMTrace.o(13775436513280L, 102635);
      return paramFile;
    }
  }
  
  private static final class c
  {
    public Set<SharedPreferences.OnSharedPreferenceChangeListener> gNn;
    public boolean usv;
    public List<String> usw;
    public Map<String, Object> usx;
    public final CountDownLatch usy;
    public volatile boolean usz;
    
    public c()
    {
      GMTrace.i(13745774395392L, 102414);
      this.usv = false;
      this.usw = null;
      this.gNn = null;
      this.usx = null;
      this.usy = new CountDownLatch(1);
      this.usz = false;
      GMTrace.o(13745774395392L, 102414);
    }
    
    public final void jQ(boolean paramBoolean)
    {
      GMTrace.i(13745908613120L, 102415);
      this.usz = paramBoolean;
      this.usy.countDown();
      GMTrace.o(13745908613120L, 102415);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/platformtools/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */