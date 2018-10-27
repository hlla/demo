package com.google.android.finsky.dg;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.finsky.ds.a.fa;
import com.google.android.finsky.packagemanager.a;
import com.google.android.finsky.utils.FinskyLog;
import java.io.File;
import java.io.OutputStream;
import java.util.List;

public final class x
  implements d
{
  private Uri a = null;
  private final Context b;
  private String c = null;
  private final Handler d;
  private File e = null;
  private final a f;
  
  public x(Context paramContext, a parama)
  {
    this.b = paramContext;
    this.f = parama;
    this.d = new Handler(Looper.getMainLooper());
  }
  
  public final int a()
  {
    return -1;
  }
  
  /* Error */
  public final c a(String paramString1, String paramString2, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/google/android/finsky/dg/x:e	Ljava/io/File;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +26 -> 34
    //   11: ldc 53
    //   13: iconst_2
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_2
    //   20: invokevirtual 59	java/io/File:getName	()Ljava/lang/String;
    //   23: aastore
    //   24: dup
    //   25: iconst_1
    //   26: aload_0
    //   27: getfield 25	com/google/android/finsky/dg/x:c	Ljava/lang/String;
    //   30: aastore
    //   31: invokestatic 64	com/google/android/finsky/utils/FinskyLog:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: aload_0
    //   35: getfield 29	com/google/android/finsky/dg/x:a	Landroid/net/Uri;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull +28 -> 68
    //   43: ldc 66
    //   45: iconst_2
    //   46: anewarray 4	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: aload_2
    //   52: aastore
    //   53: dup
    //   54: iconst_1
    //   55: aload_0
    //   56: getfield 25	com/google/android/finsky/dg/x:c	Ljava/lang/String;
    //   59: aastore
    //   60: invokestatic 64	com/google/android/finsky/utils/FinskyLog:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   63: aload_0
    //   64: aconst_null
    //   65: putfield 27	com/google/android/finsky/dg/x:e	Ljava/io/File;
    //   68: new 68	com/google/android/finsky/dg/b
    //   71: dup
    //   72: invokespecial 69	com/google/android/finsky/dg/b:<init>	()V
    //   75: pop
    //   76: aload_0
    //   77: getfield 31	com/google/android/finsky/dg/x:b	Landroid/content/Context;
    //   80: aload_1
    //   81: invokestatic 72	com/google/android/finsky/dg/b:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   84: astore_2
    //   85: new 74	java/io/FileOutputStream
    //   88: dup
    //   89: aload_2
    //   90: invokespecial 77	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   93: astore 5
    //   95: aload_0
    //   96: aload_1
    //   97: putfield 25	com/google/android/finsky/dg/x:c	Ljava/lang/String;
    //   100: aload_0
    //   101: aload_2
    //   102: putfield 27	com/google/android/finsky/dg/x:e	Ljava/io/File;
    //   105: new 79	com/google/android/finsky/dg/c
    //   108: dup
    //   109: aload 5
    //   111: aload_2
    //   112: invokespecial 82	com/google/android/finsky/dg/c:<init>	(Ljava/io/OutputStream;Ljava/io/File;)V
    //   115: astore_1
    //   116: aload_0
    //   117: monitorexit
    //   118: aload_1
    //   119: areturn
    //   120: astore_1
    //   121: aload_2
    //   122: invokevirtual 86	java/io/File:delete	()Z
    //   125: pop
    //   126: aload_1
    //   127: athrow
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_1
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	x
    //   0	133	1	paramString1	String
    //   0	133	2	paramString2	String
    //   0	133	3	paramLong	long
    //   93	17	5	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   85	95	120	java/io/IOException
    //   2	7	128	finally
    //   11	34	128	finally
    //   34	39	128	finally
    //   43	68	128	finally
    //   68	85	128	finally
    //   85	95	128	finally
    //   95	116	128	finally
    //   121	128	128	finally
  }
  
  public final void a(OutputStream paramOutputStream)
  {
    paramOutputStream.flush();
    paramOutputStream.close();
  }
  
  public final void a(String paramString)
  {
    try
    {
      c(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void a(String paramString, long paramLong1, long paramLong2) {}
  
  public final void a(String paramString1, long paramLong, String paramString2, int paramInt1, int paramInt2, fa paramfa) {}
  
  public final void a(String paramString1, long paramLong, String paramString2, int paramInt1, int paramInt2, fa paramfa, int paramInt3, boolean paramBoolean) {}
  
  public final void a(String paramString, Bitmap paramBitmap) {}
  
  public final void a(String paramString, Uri paramUri)
  {
    Object localObject = this.e;
    if (localObject != null) {
      FinskyLog.e("Already streaming file %s for %s", new Object[] { ((File)localObject).getName(), this.c });
    }
    localObject = this.a;
    if (localObject != null)
    {
      FinskyLog.e("Already tracking file %s for %s", new Object[] { localObject, this.c });
      this.e = null;
    }
    this.c = paramString;
    this.a = paramUri;
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    this.f.a(paramString, paramBoolean, null);
  }
  
  /* Error */
  public final void a(String paramString, boolean paramBoolean, e parame)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/google/android/finsky/dg/x:e	Ljava/io/File;
    //   6: astore 4
    //   8: aload 4
    //   10: ifnull +42 -> 52
    //   13: aload 4
    //   15: invokestatic 116	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   18: astore 4
    //   20: new 118	com/google/android/finsky/dg/z
    //   23: dup
    //   24: aload_0
    //   25: aload_3
    //   26: aload_1
    //   27: invokespecial 121	com/google/android/finsky/dg/z:<init>	(Lcom/google/android/finsky/dg/x;Lcom/google/android/finsky/dg/e;Ljava/lang/String;)V
    //   30: astore_3
    //   31: aload_0
    //   32: getfield 33	com/google/android/finsky/dg/x:f	Lcom/google/android/finsky/packagemanager/a;
    //   35: aload 4
    //   37: ldc2_w 122
    //   40: aconst_null
    //   41: aload_3
    //   42: iload_2
    //   43: aload_1
    //   44: invokeinterface 126 8 0
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: aload_0
    //   53: getfield 29	com/google/android/finsky/dg/x:a	Landroid/net/Uri;
    //   56: astore 5
    //   58: aload 5
    //   60: astore 4
    //   62: aload 5
    //   64: ifnonnull -44 -> 20
    //   67: aload_0
    //   68: getfield 46	com/google/android/finsky/dg/x:d	Landroid/os/Handler;
    //   71: new 128	com/google/android/finsky/dg/y
    //   74: dup
    //   75: aload_0
    //   76: aload_1
    //   77: aload_3
    //   78: invokespecial 131	com/google/android/finsky/dg/y:<init>	(Lcom/google/android/finsky/dg/x;Ljava/lang/String;Lcom/google/android/finsky/dg/e;)V
    //   81: invokevirtual 135	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   84: pop
    //   85: goto -36 -> 49
    //   88: astore_1
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	x
    //   0	93	1	paramString	String
    //   0	93	2	paramBoolean	boolean
    //   0	93	3	parame	e
    //   6	55	4	localObject	Object
    //   56	7	5	localUri	Uri
    // Exception table:
    //   from	to	target	type
    //   2	8	88	finally
    //   13	20	88	finally
    //   20	49	88	finally
    //   52	58	88	finally
    //   67	85	88	finally
  }
  
  public final void a(List paramList) {}
  
  public final boolean a(boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public final void b(String paramString)
  {
    c(paramString);
  }
  
  public final boolean b()
  {
    return true;
  }
  
  final void c(String paramString)
  {
    if (paramString.equals(this.c))
    {
      paramString = this.e;
      if (paramString != null)
      {
        paramString.delete();
        this.e = null;
      }
      if (this.a != null) {
        this.a = null;
      }
      this.c = null;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dg/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */