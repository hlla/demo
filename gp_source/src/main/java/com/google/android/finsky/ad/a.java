package com.google.android.finsky.ad;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import com.google.android.finsky.e.af;
import com.google.android.finsky.e.ag;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class a
{
  public static final Object c = new Object();
  public final Executor a;
  public final List b = new ArrayList();
  public com.google.android.settings.deletionservice.e d;
  public final List e;
  public ServiceConnection f;
  private final Context g;
  private final af h;
  private final Handler i;
  private int j;
  
  public a(Context paramContext, ag paramag)
  {
    this.h = paramag.cW();
    this.g = paramContext;
    this.a = Executors.newSingleThreadExecutor(b.a);
    this.e = new ArrayList();
    this.i = new Handler(paramContext.getMainLooper());
  }
  
  static int a(Exception paramException)
  {
    if (!(paramException instanceof RuntimeException))
    {
      if (!(paramException instanceof SecurityException))
      {
        if (!(paramException instanceof NullPointerException)) {
          return 3303;
        }
        return 3302;
      }
      return 3301;
    }
    return 3300;
  }
  
  private final void a(n paramn)
  {
    for (;;)
    {
      synchronized (c)
      {
        this.j += 1;
        if (this.d == null)
        {
          if (this.f == null)
          {
            this.e.add(paramn);
            this.f = new i(this);
            paramn = this.f;
            Intent localIntent = new Intent();
            localIntent.setClassName("com.google.android.apps.photos", "com.google.android.apps.photos.devicemanagement.overdrive.DeletionService");
            this.g.bindService(localIntent, paramn, 1);
            return;
          }
          this.e.add(paramn);
        }
      }
      paramn.a();
    }
  }
  
  public final void a()
  {
    a(new c(this));
  }
  
  final void a(int paramInt1, int paramInt2)
  {
    com.google.android.finsky.e.d locald = new com.google.android.finsky.e.d(paramInt1);
    locald.g(paramInt2);
    this.h.a(locald);
  }
  
  public final void a(m paramm)
  {
    this.b.add(paramm);
  }
  
  /* Error */
  final void a(boolean paramBoolean, l arg2, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 75	com/google/android/finsky/ad/a:i	Landroid/os/Handler;
    //   4: new 150	com/google/android/finsky/ad/h
    //   7: dup
    //   8: aload_0
    //   9: aload_2
    //   10: iload_1
    //   11: iload_3
    //   12: invokespecial 153	com/google/android/finsky/ad/h:<init>	(Lcom/google/android/finsky/ad/a;Lcom/google/android/finsky/ad/l;ZI)V
    //   15: invokevirtual 157	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   18: pop
    //   19: getstatic 30	com/google/android/finsky/ad/a:c	Ljava/lang/Object;
    //   22: astore_2
    //   23: aload_2
    //   24: monitorenter
    //   25: aload_0
    //   26: aload_0
    //   27: getfield 93	com/google/android/finsky/ad/a:j	I
    //   30: iconst_1
    //   31: isub
    //   32: putfield 93	com/google/android/finsky/ad/a:j	I
    //   35: aload_0
    //   36: getfield 93	com/google/android/finsky/ad/a:j	I
    //   39: ifgt +33 -> 72
    //   42: aload_0
    //   43: getfield 97	com/google/android/finsky/ad/a:f	Landroid/content/ServiceConnection;
    //   46: astore 4
    //   48: aload 4
    //   50: ifnull +12 -> 62
    //   53: aload_0
    //   54: getfield 47	com/google/android/finsky/ad/a:g	Landroid/content/Context;
    //   57: aload 4
    //   59: invokevirtual 161	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   62: aload_0
    //   63: aconst_null
    //   64: putfield 95	com/google/android/finsky/ad/a:d	Lcom/google/android/settings/deletionservice/e;
    //   67: aload_0
    //   68: aconst_null
    //   69: putfield 97	com/google/android/finsky/ad/a:f	Landroid/content/ServiceConnection;
    //   72: aload_2
    //   73: monitorexit
    //   74: return
    //   75: astore 4
    //   77: getstatic 30	com/google/android/finsky/ad/a:c	Ljava/lang/Object;
    //   80: astore_2
    //   81: aload_2
    //   82: monitorenter
    //   83: aload_0
    //   84: aload_0
    //   85: getfield 93	com/google/android/finsky/ad/a:j	I
    //   88: iconst_1
    //   89: isub
    //   90: putfield 93	com/google/android/finsky/ad/a:j	I
    //   93: aload_0
    //   94: getfield 93	com/google/android/finsky/ad/a:j	I
    //   97: ifgt +33 -> 130
    //   100: aload_0
    //   101: getfield 97	com/google/android/finsky/ad/a:f	Landroid/content/ServiceConnection;
    //   104: astore 5
    //   106: aload 5
    //   108: ifnull +12 -> 120
    //   111: aload_0
    //   112: getfield 47	com/google/android/finsky/ad/a:g	Landroid/content/Context;
    //   115: aload 5
    //   117: invokevirtual 161	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   120: aload_0
    //   121: aconst_null
    //   122: putfield 95	com/google/android/finsky/ad/a:d	Lcom/google/android/settings/deletionservice/e;
    //   125: aload_0
    //   126: aconst_null
    //   127: putfield 97	com/google/android/finsky/ad/a:f	Landroid/content/ServiceConnection;
    //   130: aload_2
    //   131: monitorexit
    //   132: aload 4
    //   134: athrow
    //   135: astore 4
    //   137: aload_2
    //   138: monitorexit
    //   139: aload 4
    //   141: athrow
    //   142: astore 4
    //   144: aload_2
    //   145: monitorexit
    //   146: aload 4
    //   148: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	a
    //   0	149	1	paramBoolean	boolean
    //   0	149	3	paramInt	int
    //   46	12	4	localServiceConnection1	ServiceConnection
    //   75	58	4	localObject1	Object
    //   135	5	4	localObject2	Object
    //   142	5	4	localObject3	Object
    //   104	12	5	localServiceConnection2	ServiceConnection
    // Exception table:
    //   from	to	target	type
    //   0	19	75	finally
    //   25	48	135	finally
    //   53	62	135	finally
    //   62	72	135	finally
    //   72	74	135	finally
    //   137	139	135	finally
    //   83	106	142	finally
    //   111	120	142	finally
    //   120	130	142	finally
    //   130	132	142	finally
    //   144	146	142	finally
  }
  
  public final void b()
  {
    this.i.post(new d(this));
    a(new e(this));
  }
  
  public final void b(m paramm)
  {
    this.b.remove(paramm);
  }
  
  final com.google.android.settings.deletionservice.d c()
  {
    return new j(this);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ad/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */