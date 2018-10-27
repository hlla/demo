package com.google.android.gms.ads.internal.q;

import android.content.Context;
import android.net.Uri.Builder;
import android.os.Looper;
import com.google.android.gms.ads.internal.f.n;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.m;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@com.google.android.gms.ads.internal.q.a.a
public final class a
  implements e
{
  private static e f = null;
  private static e g = null;
  private static final Object h = new Object();
  private final ExecutorService a = Executors.newCachedThreadPool();
  private final Context b;
  private final Object c = new Object();
  private final WeakHashMap d = new WeakHashMap();
  private final VersionInfoParcel e;
  
  private a(Context paramContext)
  {
    this(paramContext, VersionInfoParcel.a());
  }
  
  private a(Context paramContext, VersionInfoParcel paramVersionInfoParcel)
  {
    Context localContext = paramContext;
    if (paramContext.getApplicationContext() != null) {
      localContext = paramContext.getApplicationContext();
    }
    this.b = localContext;
    this.e = paramVersionInfoParcel;
  }
  
  /* Error */
  private final Uri.Builder a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 65	com/google/android/gms/ads/internal/q/a:b	Landroid/content/Context;
    //   4: astore 6
    //   6: getstatic 73	com/google/android/gms/common/b/c:a	Lcom/google/android/gms/common/b/c;
    //   9: aload 6
    //   11: invokevirtual 76	com/google/android/gms/common/b/c:a	(Landroid/content/Context;)Lcom/google/android/gms/common/b/b;
    //   14: invokevirtual 81	com/google/android/gms/common/b/b:a	()Z
    //   17: istore 5
    //   19: aload_0
    //   20: getfield 65	com/google/android/gms/ads/internal/q/a:b	Landroid/content/Context;
    //   23: invokevirtual 85	android/content/Context:getPackageName	()Ljava/lang/String;
    //   26: astore 6
    //   28: new 87	android/net/Uri$Builder
    //   31: dup
    //   32: invokespecial 88	android/net/Uri$Builder:<init>	()V
    //   35: ldc 90
    //   37: invokevirtual 94	android/net/Uri$Builder:scheme	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   40: ldc 96
    //   42: invokevirtual 99	android/net/Uri$Builder:path	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   45: ldc 101
    //   47: iload 5
    //   49: invokestatic 107	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   52: invokevirtual 111	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   55: ldc 113
    //   57: ldc 115
    //   59: invokevirtual 111	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   62: ldc 117
    //   64: getstatic 123	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   67: invokevirtual 111	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   70: ldc 125
    //   72: getstatic 129	android/os/Build$VERSION:SDK_INT	I
    //   75: invokestatic 135	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   78: invokevirtual 111	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   81: astore 9
    //   83: getstatic 140	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   86: astore 10
    //   88: getstatic 143	android/os/Build:MODEL	Ljava/lang/String;
    //   91: astore 8
    //   93: aload 8
    //   95: astore 7
    //   97: aload 8
    //   99: aload 10
    //   101: invokevirtual 147	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   104: ifne +62 -> 166
    //   107: new 149	java/lang/StringBuilder
    //   110: dup
    //   111: aload 10
    //   113: invokestatic 152	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   116: invokevirtual 156	java/lang/String:length	()I
    //   119: iconst_1
    //   120: iadd
    //   121: aload 8
    //   123: invokestatic 152	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   126: invokevirtual 156	java/lang/String:length	()I
    //   129: iadd
    //   130: invokespecial 159	java/lang/StringBuilder:<init>	(I)V
    //   133: astore 7
    //   135: aload 7
    //   137: aload 10
    //   139: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload 7
    //   145: ldc -91
    //   147: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload 7
    //   153: aload 8
    //   155: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload 7
    //   161: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: astore 7
    //   166: aload 9
    //   168: ldc -87
    //   170: aload 7
    //   172: invokevirtual 111	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   175: ldc -85
    //   177: aload_0
    //   178: getfield 67	com/google/android/gms/ads/internal/q/a:e	Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;
    //   181: getfield 173	com/google/android/gms/ads/internal/util/client/VersionInfoParcel:a	Ljava/lang/String;
    //   184: invokevirtual 111	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   187: ldc -81
    //   189: aload 6
    //   191: invokevirtual 111	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   194: ldc -79
    //   196: aload_1
    //   197: invokevirtual 111	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   200: ldc -77
    //   202: aload_2
    //   203: invokevirtual 111	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   206: ldc -75
    //   208: ldc -73
    //   210: invokestatic 188	com/google/android/gms/ads/internal/f/n:a	()Ljava/util/List;
    //   213: invokestatic 194	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   216: invokevirtual 111	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   219: ldc -60
    //   221: aload_3
    //   222: invokevirtual 111	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   225: ldc -58
    //   227: ldc -56
    //   229: invokevirtual 111	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   232: ldc -54
    //   234: ldc -52
    //   236: invokevirtual 111	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   239: ldc -50
    //   241: getstatic 211	com/google/android/gms/ads/internal/client/u:h	Lcom/google/android/gms/ads/internal/client/u;
    //   244: getfield 214	com/google/android/gms/ads/internal/client/u:i	Ljava/lang/String;
    //   247: invokevirtual 111	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   250: ldc -40
    //   252: iload 4
    //   254: invokestatic 220	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   257: invokevirtual 111	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   260: ldc -34
    //   262: getstatic 226	com/google/android/gms/ads/internal/f/n:bm	Lcom/google/android/gms/ads/internal/f/c;
    //   265: invokevirtual 231	com/google/android/gms/ads/internal/f/c:a	()Ljava/lang/Object;
    //   268: invokestatic 152	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   271: invokevirtual 111	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   274: areturn
    //   275: astore 6
    //   277: ldc -23
    //   279: aload 6
    //   281: invokestatic 238	com/google/android/gms/ads/internal/util/client/k:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   284: iconst_0
    //   285: istore 5
    //   287: goto -268 -> 19
    //   290: astore 6
    //   292: ldc -16
    //   294: invokestatic 243	com/google/android/gms/ads/internal/util/client/k:e	(Ljava/lang/String;)V
    //   297: ldc -11
    //   299: astore 6
    //   301: goto -273 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	this	a
    //   0	304	1	paramString1	String
    //   0	304	2	paramString2	String
    //   0	304	3	paramString3	String
    //   0	304	4	paramInt	int
    //   17	269	5	bool	boolean
    //   4	186	6	localObject1	Object
    //   275	5	6	localThrowable	Throwable
    //   290	1	6	localObject2	Object
    //   299	1	6	str1	String
    //   95	76	7	localObject3	Object
    //   91	63	8	str2	String
    //   81	86	9	localBuilder	Uri.Builder
    //   86	52	10	str3	String
    // Exception table:
    //   from	to	target	type
    //   0	19	275	finally
    //   19	28	290	finally
  }
  
  public static e a(Context paramContext)
  {
    synchronized (h)
    {
      if (f == null)
      {
        if (!((Boolean)n.bG.a()).booleanValue()) {
          f = new f();
        }
      }
      else {
        return f;
      }
      f = new a(paramContext);
    }
  }
  
  public static e a(Context arg0, VersionInfoParcel paramVersionInfoParcel)
  {
    for (;;)
    {
      Thread localThread;
      synchronized (h)
      {
        if (g == null)
        {
          if (!((Boolean)n.bG.a()).booleanValue()) {
            g = new f();
          }
        }
        else {
          return g;
        }
        paramVersionInfoParcel = new a(???, paramVersionInfoParcel);
        localThread = Looper.getMainLooper().getThread();
        if (localThread == null) {}
      }
      synchronized (paramVersionInfoParcel.c)
      {
        paramVersionInfoParcel.d.put(localThread, Boolean.valueOf(true));
        localThread.setUncaughtExceptionHandler(new c(paramVersionInfoParcel, localThread.getUncaughtExceptionHandler()));
        Thread.setDefaultUncaughtExceptionHandler(new b(paramVersionInfoParcel, Thread.getDefaultUncaughtExceptionHandler()));
        g = paramVersionInfoParcel;
        continue;
        ??? = finally;
        throw ???;
      }
    }
  }
  
  protected final void a(Throwable paramThrowable)
  {
    if (paramThrowable != null)
    {
      int j = 0;
      int k = 0;
      for (Throwable localThrowable = paramThrowable; localThrowable != null; localThrowable = localThrowable.getCause())
      {
        StackTraceElement[] arrayOfStackTraceElement = localThrowable.getStackTrace();
        int m = arrayOfStackTraceElement.length;
        int i = 0;
        while (i < m)
        {
          StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
          if (com.google.android.gms.ads.internal.util.client.a.b(localStackTraceElement.getClassName())) {
            k = 1;
          }
          if (getClass().getName().equals(localStackTraceElement.getClassName())) {
            j = 1;
          }
          i += 1;
        }
      }
      if ((k != 0) && (j == 0)) {
        a(paramThrowable, "", 1.0F);
      }
    }
  }
  
  public final void a(Throwable paramThrowable, String paramString)
  {
    a(paramThrowable, paramString, 1.0F);
  }
  
  public final void a(Throwable paramThrowable, String paramString, float paramFloat)
  {
    if (com.google.android.gms.ads.internal.util.client.a.a(paramThrowable) != null)
    {
      Object localObject1 = paramThrowable.getClass().getName();
      Object localObject2 = new StringWriter();
      com.google.e.a.a.a.a.a.a(paramThrowable, new PrintWriter((Writer)localObject2));
      localObject2 = ((StringWriter)localObject2).toString();
      double d1 = paramFloat;
      double d2 = Math.random();
      if (paramFloat > 0.0F) {}
      for (int i = (int)(1.0F / paramFloat); d2 < d1; i = 1)
      {
        paramThrowable = new ArrayList();
        paramThrowable.add(a((String)localObject1, (String)localObject2, paramString, i).toString());
        int j = paramThrowable.size();
        i = 0;
        while (i < j)
        {
          paramString = (String)paramThrowable.get(i);
          localObject1 = new m();
          this.a.submit(new d((m)localObject1, paramString));
          i += 1;
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/q/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */