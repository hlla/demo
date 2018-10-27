package com.google.android.finsky.dg;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageInstaller.Session;
import android.content.pm.PackageInstaller.SessionInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

import com.google.android.finsky.ds.a.fa;
import com.google.android.finsky.utils.FinskyLog;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@TargetApi(21)
public final class f
  implements d
{
  public final com.google.android.finsky.accounts.a a;
  public final Context b;
  public final com.google.android.finsky.dn.e c;
  public final Handler d;
  public final HashMap e;
  public final PackageInstaller f;
  public final com.google.android.finsky.dh.a g;
  public final HashMap h;
  private final Handler i;
  private final com.google.android.finsky.bo.c j;
  private final com.google.android.finsky.packagemanager.a k;
  
  public f(Context paramContext, com.google.android.finsky.dh.a parama, com.google.android.finsky.packagemanager.a parama1, com.google.android.finsky.bo.c paramc, com.google.android.finsky.dn.e parame, com.google.android.finsky.accounts.a parama2)
  {
    this.b = paramContext;
    this.g = parama;
    this.k = parama1;
    this.f = this.b.getPackageManager().getPackageInstaller();
    this.j = paramc;
    this.c = parame;
    this.a = parama2;
    paramContext = new HandlerThread("PackageInstallerImpl", 10);
    paramContext.start();
    this.i = new Handler(paramContext.getLooper());
    this.d = new Handler(Looper.getMainLooper());
    this.h = new HashMap();
    this.e = new HashMap();
    this.i.post(new g(this));
  }
  
  @TargetApi(27)
  private final boolean b(SessionInfo paramSessionInfo)
  {
    if ((paramSessionInfo == null) || ((!this.j.cY().a(12654495L)) || ((Build.VERSION.SDK_INT < 27) || (paramSessionInfo.getMode() == 1)))) {}
    try
    {
      boolean bool = ((Boolean)SessionInfo.class.getDeclaredMethod("getInstallAsInstantApp", new Class[] { Boolean.TYPE }).invoke(paramSessionInfo, new Object[] { Boolean.valueOf(false) })).booleanValue();
      return bool;
    }
    catch (Exception paramSessionInfo)
    {
      FinskyLog.a(paramSessionInfo, "Exception calling getInstallAsInstantApp method on SessionInfo.", new Object[0]);
    }
    return false;
    return false;
    return false;
    return false;
    return false;
  }
  
  public final int a()
  {
    return ((ActivityManager)this.b.getSystemService("activity")).getLauncherLargeIconSize();
  }
  
  public final c a(String paramString1, String paramString2, long paramLong)
  {
    Object localObject = new Session[1];
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    this.i.post(new v(this, (Session[])localObject, paramString1, localCountDownLatch));
    try
    {
      localCountDownLatch.await();
      localObject = localObject[0];
      if (localObject == null)
      {
        FinskyLog.d("Can't open session for %s", new Object[] { paramString1 });
        throw new IOException(String.format("Can't open session for %s", new Object[] { paramString1 }));
      }
      return new c(new w(((Session)localObject).openWrite(paramString2, 0L, paramLong), (Session)localObject), null);
    }
    catch (InterruptedException paramString1)
    {
      throw new IOException(paramString1);
    }
  }
  
  public final void a(OutputStream paramOutputStream)
  {
    paramOutputStream = (w)paramOutputStream;
    OutputStream localOutputStream = paramOutputStream.b;
    paramOutputStream.a.fsync(localOutputStream);
    localOutputStream.close();
  }
  
  final void a(Runnable paramRunnable)
  {
    this.i.post(new l(this, paramRunnable));
  }
  
  public final void a(String paramString)
  {
    this.i.post(new q(this, paramString));
  }
  
  final void a(String paramString, int paramInt)
  {
    this.i.post(new r(this, paramString, paramInt));
  }
  
  public final void a(String paramString, long paramLong1, long paramLong2)
  {
    this.i.post(new t(this, paramString, paramLong2, paramLong1));
  }
  
  public final void a(String paramString1, long paramLong, String paramString2, int paramInt1, int paramInt2, fa paramfa)
  {
    a(paramString1, paramLong, paramString2, paramInt1, paramInt2, paramfa, 1, false);
  }
  
  public final void a(String paramString1, long paramLong, String paramString2, int paramInt1, int paramInt2, fa paramfa, int paramInt3, boolean paramBoolean)
  {
    this.i.post(new p(this, paramString1, paramLong, paramString2, null, paramInt1, paramInt2, paramfa, paramInt3, paramBoolean));
  }
  
  /* Error */
  final void a(String paramString1, long paramLong, String paramString2, Bitmap paramBitmap, int paramInt1, int paramInt2, fa paramfa, int paramInt3, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 93	com/google/android/finsky/dg/f:h	Ljava/util/HashMap;
    //   6: aload_1
    //   7: invokevirtual 289	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   10: ifeq +20 -> 30
    //   13: ldc_w 291
    //   16: iconst_1
    //   17: anewarray 4	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: aload_1
    //   23: aastore
    //   24: invokestatic 293	com/google/android/finsky/utils/FinskyLog:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: new 295	android/content/pm/PackageInstaller$SessionParams
    //   33: dup
    //   34: iload 9
    //   36: invokespecial 296	android/content/pm/PackageInstaller$SessionParams:<init>	(I)V
    //   39: astore 11
    //   41: iload 10
    //   43: ifeq +489 -> 532
    //   46: invokestatic 300	android/support/v4/os/a:a	()Z
    //   49: ifeq +483 -> 532
    //   52: aload 11
    //   54: iconst_1
    //   55: invokevirtual 304	android/content/pm/PackageInstaller$SessionParams:setDontKillApp	(Z)V
    //   58: goto +474 -> 532
    //   61: aload 4
    //   63: invokestatic 310	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   66: ifne +10 -> 76
    //   69: aload 11
    //   71: aload 4
    //   73: invokevirtual 314	android/content/pm/PackageInstaller$SessionParams:setAppLabel	(Ljava/lang/CharSequence;)V
    //   76: aload 11
    //   78: aload_1
    //   79: invokevirtual 317	android/content/pm/PackageInstaller$SessionParams:setAppPackageName	(Ljava/lang/String;)V
    //   82: aload 11
    //   84: iload 6
    //   86: invokevirtual 320	android/content/pm/PackageInstaller$SessionParams:setInstallLocation	(I)V
    //   89: lload_2
    //   90: lconst_0
    //   91: lcmp
    //   92: ifle +9 -> 101
    //   95: aload 11
    //   97: lload_2
    //   98: invokevirtual 324	android/content/pm/PackageInstaller$SessionParams:setSize	(J)V
    //   101: invokestatic 326	android/support/v4/os/a:b	()Z
    //   104: ifne +337 -> 441
    //   107: goto +433 -> 540
    //   110: invokestatic 326	android/support/v4/os/a:b	()Z
    //   113: ifeq +79 -> 192
    //   116: iload 9
    //   118: iconst_2
    //   119: if_icmpne +148 -> 267
    //   122: aload_0
    //   123: getfield 38	com/google/android/finsky/dg/f:g	Lcom/google/android/finsky/dh/a;
    //   126: aload_1
    //   127: iconst_1
    //   128: invokeinterface 331 3 0
    //   133: astore 4
    //   135: aload 4
    //   137: ifnull +124 -> 261
    //   140: aload 4
    //   142: getfield 336	com/google/android/finsky/dh/b:k	Z
    //   145: istore 10
    //   147: iload 10
    //   149: ifeq +106 -> 255
    //   152: iconst_1
    //   153: istore 10
    //   155: ldc_w 295
    //   158: ldc_w 338
    //   161: iconst_1
    //   162: anewarray 138	java/lang/Class
    //   165: dup
    //   166: iconst_0
    //   167: getstatic 144	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   170: aastore
    //   171: invokevirtual 148	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   174: aload 11
    //   176: iconst_1
    //   177: anewarray 4	java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: iload 10
    //   184: invokestatic 152	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   187: aastore
    //   188: invokevirtual 158	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   191: pop
    //   192: aload_0
    //   193: getfield 54	com/google/android/finsky/dg/f:f	Landroid/content/pm/PackageInstaller;
    //   196: aload 11
    //   198: invokevirtual 344	android/content/pm/PackageInstaller:createSession	(Landroid/content/pm/PackageInstaller$SessionParams;)I
    //   201: istore 6
    //   203: aload_0
    //   204: getfield 54	com/google/android/finsky/dg/f:f	Landroid/content/pm/PackageInstaller;
    //   207: iload 6
    //   209: invokevirtual 348	android/content/pm/PackageInstaller:getSessionInfo	(I)Landroid/content/pm/PackageInstaller$SessionInfo;
    //   212: astore 4
    //   214: aload_0
    //   215: getfield 93	com/google/android/finsky/dg/f:h	Ljava/util/HashMap;
    //   218: aload_1
    //   219: aload 4
    //   221: invokevirtual 352	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   224: pop
    //   225: ldc_w 354
    //   228: iconst_2
    //   229: anewarray 4	java/lang/Object
    //   232: dup
    //   233: iconst_0
    //   234: iload 6
    //   236: invokestatic 359	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   239: aastore
    //   240: dup
    //   241: iconst_1
    //   242: aload_1
    //   243: aastore
    //   244: invokestatic 361	com/google/android/finsky/utils/FinskyLog:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: goto -220 -> 27
    //   250: astore_1
    //   251: aload_0
    //   252: monitorexit
    //   253: aload_1
    //   254: athrow
    //   255: iconst_0
    //   256: istore 10
    //   258: goto -103 -> 155
    //   261: iconst_0
    //   262: istore 10
    //   264: goto -109 -> 155
    //   267: iconst_0
    //   268: istore 10
    //   270: goto -115 -> 155
    //   273: invokestatic 365	com/google/android/finsky/utils/a:e	()Z
    //   276: ifeq -166 -> 110
    //   279: aload 8
    //   281: getfield 369	com/google/android/finsky/ds/a/fa:c	I
    //   284: iconst_4
    //   285: iand
    //   286: ifeq -176 -> 110
    //   289: aload 8
    //   291: getfield 371	com/google/android/finsky/ds/a/fa:k	I
    //   294: bipush 23
    //   296: if_icmplt -186 -> 110
    //   299: aload 8
    //   301: getfield 374	com/google/android/finsky/ds/a/fa:h	[Ljava/lang/String;
    //   304: astore 4
    //   306: aload 4
    //   308: ifnull -198 -> 110
    //   311: aload 4
    //   313: arraylength
    //   314: istore 7
    //   316: iconst_0
    //   317: istore 6
    //   319: iload 6
    //   321: iload 7
    //   323: if_icmpge -213 -> 110
    //   326: ldc_w 376
    //   329: aload 4
    //   331: iload 6
    //   333: aaload
    //   334: invokevirtual 379	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   337: ifeq +211 -> 548
    //   340: aload_0
    //   341: getfield 36	com/google/android/finsky/dg/f:b	Landroid/content/Context;
    //   344: ldc_w 381
    //   347: invokestatic 386	android/os/Process:myPid	()I
    //   350: invokestatic 389	android/os/Process:myUid	()I
    //   353: invokevirtual 393	android/content/Context:checkPermission	(Ljava/lang/String;II)I
    //   356: ifeq +16 -> 372
    //   359: ldc_w 395
    //   362: iconst_0
    //   363: anewarray 4	java/lang/Object
    //   366: invokestatic 204	com/google/android/finsky/utils/FinskyLog:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   369: goto -259 -> 110
    //   372: ldc_w 295
    //   375: ldc_w 397
    //   378: iconst_1
    //   379: anewarray 138	java/lang/Class
    //   382: dup
    //   383: iconst_0
    //   384: ldc_w 398
    //   387: aastore
    //   388: invokevirtual 401	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   391: aload 11
    //   393: iconst_1
    //   394: anewarray 4	java/lang/Object
    //   397: dup
    //   398: iconst_0
    //   399: iconst_1
    //   400: anewarray 208	java/lang/String
    //   403: dup
    //   404: iconst_0
    //   405: ldc_w 376
    //   408: aastore
    //   409: aastore
    //   410: invokevirtual 158	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   413: pop
    //   414: goto -304 -> 110
    //   417: astore 4
    //   419: ldc_w 403
    //   422: iconst_2
    //   423: anewarray 4	java/lang/Object
    //   426: dup
    //   427: iconst_0
    //   428: aload_1
    //   429: aastore
    //   430: dup
    //   431: iconst_1
    //   432: aload 4
    //   434: aastore
    //   435: invokestatic 405	com/google/android/finsky/utils/FinskyLog:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   438: goto -328 -> 110
    //   441: aload 11
    //   443: iload 7
    //   445: invokevirtual 408	android/content/pm/PackageInstaller$SessionParams:setInstallReason	(I)V
    //   448: goto +92 -> 540
    //   451: aload 11
    //   453: aload 5
    //   455: invokevirtual 412	android/content/pm/PackageInstaller$SessionParams:setAppIcon	(Landroid/graphics/Bitmap;)V
    //   458: goto -397 -> 61
    //   461: ldc_w 414
    //   464: iconst_0
    //   465: anewarray 4	java/lang/Object
    //   468: invokestatic 405	com/google/android/finsky/utils/FinskyLog:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   471: goto -279 -> 192
    //   474: astore 4
    //   476: ldc_w 416
    //   479: iconst_2
    //   480: anewarray 4	java/lang/Object
    //   483: dup
    //   484: iconst_0
    //   485: aload_1
    //   486: aastore
    //   487: dup
    //   488: iconst_1
    //   489: aload 4
    //   491: aastore
    //   492: invokestatic 405	com/google/android/finsky/utils/FinskyLog:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   495: goto -385 -> 110
    //   498: astore 4
    //   500: ldc_w 418
    //   503: iconst_2
    //   504: anewarray 4	java/lang/Object
    //   507: dup
    //   508: iconst_0
    //   509: aload_1
    //   510: aastore
    //   511: dup
    //   512: iconst_1
    //   513: aload 4
    //   515: aastore
    //   516: invokestatic 405	com/google/android/finsky/utils/FinskyLog:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   519: goto -409 -> 110
    //   522: astore 4
    //   524: goto -63 -> 461
    //   527: astore 4
    //   529: goto -68 -> 461
    //   532: aload 5
    //   534: ifnonnull -83 -> 451
    //   537: goto -476 -> 61
    //   540: aload 8
    //   542: ifnonnull -269 -> 273
    //   545: goto -435 -> 110
    //   548: iload 6
    //   550: iconst_1
    //   551: iadd
    //   552: istore 6
    //   554: goto -235 -> 319
    //   557: astore 4
    //   559: goto -98 -> 461
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	562	0	this	f
    //   0	562	1	paramString1	String
    //   0	562	2	paramLong	long
    //   0	562	4	paramString2	String
    //   0	562	5	paramBitmap	Bitmap
    //   0	562	6	paramInt1	int
    //   0	562	7	paramInt2	int
    //   0	562	8	paramfa	fa
    //   0	562	9	paramInt3	int
    //   0	562	10	paramBoolean	boolean
    //   39	413	11	localSessionParams	android.content.pm.PackageInstaller.SessionParams
    // Exception table:
    //   from	to	target	type
    //   2	27	250	finally
    //   30	41	250	finally
    //   46	58	250	finally
    //   61	76	250	finally
    //   76	89	250	finally
    //   95	101	250	finally
    //   101	107	250	finally
    //   110	116	250	finally
    //   122	135	250	finally
    //   140	147	250	finally
    //   155	192	250	finally
    //   192	247	250	finally
    //   273	306	250	finally
    //   311	316	250	finally
    //   326	369	250	finally
    //   372	414	250	finally
    //   419	438	250	finally
    //   441	448	250	finally
    //   451	458	250	finally
    //   461	471	250	finally
    //   476	495	250	finally
    //   500	519	250	finally
    //   372	414	417	java/lang/NoSuchMethodException
    //   372	414	474	java/lang/reflect/InvocationTargetException
    //   372	414	498	java/lang/IllegalAccessException
    //   155	192	522	java/lang/NoSuchMethodException
    //   155	192	527	java/lang/reflect/InvocationTargetException
    //   155	192	557	java/lang/IllegalAccessException
  }
  
  public final void a(String paramString, Bitmap paramBitmap)
  {
    this.i.post(new u(this, paramString, paramBitmap));
  }
  
  public final void a(String paramString, Uri paramUri)
  {
    FinskyLog.e("Cannot install %s from uri %s", new Object[] { paramString, paramUri });
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    this.k.a(paramString, paramBoolean, null);
  }
  
  public final void a(String paramString, boolean paramBoolean, e parame)
  {
    this.i.post(new h(this, paramString, parame));
  }
  
  public final void a(List paramList)
  {
    this.i.post(new s(this, paramList));
  }
  
  final boolean a(SessionInfo paramSessionInfo)
  {
    try
    {
      boolean bool = b(paramSessionInfo);
      return bool;
    }
    finally {}
    return false;
  }
  
  public final boolean a(boolean paramBoolean)
  {
    return true;
  }
  
  public final void b(String paramString) {}
  
  final void b(String paramString, int paramInt)
  {
    Session localSession = (Session)this.e.remove(paramString);
    if (localSession != null) {}
    try
    {
      localSession.close();
      this.h.remove(paramString);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          this.f.abandonSession(paramInt);
          FinskyLog.a("Canceling session %d for %s", new Object[] { Integer.valueOf(paramInt), paramString });
          return;
        }
        catch (SecurityException paramString) {}
        localException = localException;
        FinskyLog.d("Unexpected error closing session for %s: %s", new Object[] { paramString, localException.getMessage() });
      }
    }
  }
  
  public final boolean b()
  {
    return false;
  }
  
  final Session c(String paramString)
  {
    Session localSession = (Session)this.e.get(paramString);
    if (localSession != null) {}
    try
    {
      localSession.getNames();
      return localSession;
    }
    catch (IOException localIOException1)
    {
      FinskyLog.d("Stale open session for %s: %s", new Object[] { paramString, localIOException1.getMessage() });
      this.e.remove(paramString);
      Object localObject = (SessionInfo)this.h.get(paramString);
      if (localObject != null) {}
      try
      {
        localObject = this.f.openSession(((SessionInfo)localObject).getSessionId());
        this.e.put(paramString, localObject);
        return (Session)localObject;
      }
      catch (SecurityException localSecurityException2)
      {
        FinskyLog.c("SessionInfo was stale for %s - deleting info", new Object[] { paramString });
        this.h.remove(paramString);
        return null;
      }
      catch (IOException localIOException2)
      {
        FinskyLog.c("IOException opening old session for %s - deleting info", new Object[] { localIOException2.getMessage() });
        this.h.remove(paramString);
      }
      return null;
    }
    catch (SecurityException localSecurityException1)
    {
      for (;;)
      {
        FinskyLog.d("Stale open session for %s: %s", new Object[] { paramString, localSecurityException1.getMessage() });
        this.e.remove(paramString);
      }
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dg/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */