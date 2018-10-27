package com.google.android.finsky.ci;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageInstaller.Session;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageInstaller.SessionParams;
import android.content.pm.PackageManager;
import com.google.android.finsky.utils.FinskyLog;
import java.util.concurrent.Executor;

@TargetApi(21)
public class c
{
  public final Context a;
  public final PackageInstaller b;
  public final com.google.android.finsky.dh.a c;
  private final String d;
  
  public c(Context paramContext, com.google.android.finsky.dh.a parama, String paramString)
  {
    this.a = paramContext;
    if (com.google.android.finsky.utils.a.d()) {}
    for (paramContext = this.a.getPackageManager().getPackageInstaller();; paramContext = null)
    {
      this.b = paramContext;
      this.c = parama;
      this.d = paramString;
      return;
    }
  }
  
  static void a(Session paramSession)
  {
    try
    {
      paramSession.close();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          paramSession.abandon();
          return;
        }
        catch (SecurityException paramSession) {}
        localException = localException;
        FinskyLog.d("Error closing session: %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final IntentSender a(String paramString, int paramInt, Session paramSession, Executor paramExecutor, f paramf)
  {
    paramSession = new e(this, paramString, paramSession, paramExecutor, paramf);
    paramExecutor = this.d;
    paramf = new StringBuilder(String.valueOf(paramExecutor).length() + 13 + String.valueOf(paramString).length());
    paramf.append(paramExecutor);
    paramf.append(".");
    paramf.append(paramString);
    paramf.append(".");
    paramf.append(paramInt);
    paramExecutor = paramf.toString();
    paramf = new IntentFilter();
    paramf.addAction(paramExecutor);
    this.a.registerReceiver(paramSession, paramf);
    paramSession = new Intent(paramExecutor);
    return PendingIntent.getBroadcast(this.a, paramString.hashCode(), paramSession, 1207959552).getIntentSender();
  }
  
  public final SessionInfo a(String paramString, int paramInt)
  {
    SessionParams localSessionParams = new SessionParams(paramInt);
    localSessionParams.setAppPackageName(paramString);
    localSessionParams.setInstallLocation(0);
    paramInt = this.b.createSession(localSessionParams);
    return this.b.getSessionInfo(paramInt);
  }
  
  /* Error */
  public final void a(String paramString, java.util.Collection paramCollection, Executor paramExecutor, f paramf, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/google/android/finsky/ci/c:b	Landroid/content/pm/PackageInstaller;
    //   4: ifnull +128 -> 132
    //   7: aload_0
    //   8: aload_1
    //   9: iload 5
    //   11: invokevirtual 164	com/google/android/finsky/ci/c:a	(Ljava/lang/String;I)Landroid/content/pm/PackageInstaller$SessionInfo;
    //   14: astore 6
    //   16: aload_0
    //   17: getfield 41	com/google/android/finsky/ci/c:b	Landroid/content/pm/PackageInstaller;
    //   20: aload 6
    //   22: invokevirtual 169	android/content/pm/PackageInstaller$SessionInfo:getSessionId	()I
    //   25: invokevirtual 173	android/content/pm/PackageInstaller:openSession	(I)Landroid/content/pm/PackageInstaller$Session;
    //   28: astore 7
    //   30: aload_2
    //   31: invokeinterface 179 1 0
    //   36: astore 9
    //   38: aload 9
    //   40: invokeinterface 184 1 0
    //   45: ifeq +67 -> 112
    //   48: aload 9
    //   50: invokeinterface 188 1 0
    //   55: checkcast 190	java/io/File
    //   58: astore 8
    //   60: aload 7
    //   62: aload 8
    //   64: invokevirtual 193	java/io/File:getName	()Ljava/lang/String;
    //   67: lconst_0
    //   68: aload 8
    //   70: invokevirtual 196	java/io/File:length	()J
    //   73: invokevirtual 200	android/content/pm/PackageInstaller$Session:openWrite	(Ljava/lang/String;JJ)Ljava/io/OutputStream;
    //   76: astore_2
    //   77: new 202	java/io/FileInputStream
    //   80: dup
    //   81: aload 8
    //   83: invokespecial 205	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   86: astore 8
    //   88: aload 8
    //   90: aload_2
    //   91: invokestatic 210	com/google/common/io/f:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   94: pop2
    //   95: aload 8
    //   97: invokevirtual 211	java/io/FileInputStream:close	()V
    //   100: aload_2
    //   101: ifnull -63 -> 38
    //   104: aconst_null
    //   105: aload_2
    //   106: invokestatic 213	com/google/android/finsky/ci/c:a	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   109: goto -71 -> 38
    //   112: aload 7
    //   114: aload_0
    //   115: aload_1
    //   116: aload 6
    //   118: invokevirtual 169	android/content/pm/PackageInstaller$SessionInfo:getSessionId	()I
    //   121: aload 7
    //   123: aload_3
    //   124: aload 4
    //   126: invokevirtual 215	com/google/android/finsky/ci/c:a	(Ljava/lang/String;ILandroid/content/pm/PackageInstaller$Session;Ljava/util/concurrent/Executor;Lcom/google/android/finsky/ci/f;)Landroid/content/IntentSender;
    //   129: invokevirtual 219	android/content/pm/PackageInstaller$Session:commit	(Landroid/content/IntentSender;)V
    //   132: return
    //   133: astore_1
    //   134: aload_1
    //   135: athrow
    //   136: astore_3
    //   137: aload_2
    //   138: ifnull +8 -> 146
    //   141: aload_1
    //   142: aload_2
    //   143: invokestatic 213	com/google/android/finsky/ci/c:a	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   146: aload_3
    //   147: athrow
    //   148: astore_1
    //   149: aload_1
    //   150: athrow
    //   151: astore_3
    //   152: aload 8
    //   154: invokevirtual 222	java/io/InputStream:close	()V
    //   157: aload_3
    //   158: athrow
    //   159: astore 4
    //   161: aload_1
    //   162: aload 4
    //   164: invokestatic 79	com/google/e/a/a/a/a/a:a	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   167: goto -10 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	c
    //   0	170	1	paramString	String
    //   0	170	2	paramCollection	java.util.Collection
    //   0	170	3	paramExecutor	Executor
    //   0	170	4	paramf	f
    //   0	170	5	paramInt	int
    //   14	103	6	localSessionInfo	PackageInstaller.SessionInfo
    //   28	94	7	localSession	PackageInstaller.Session
    //   58	95	8	localObject	Object
    //   36	13	9	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   77	88	133	finally
    //   95	100	133	finally
    //   157	159	133	finally
    //   161	167	133	finally
    //   134	136	136	finally
    //   88	95	148	finally
    //   149	151	151	finally
    //   152	157	159	finally
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ci/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */