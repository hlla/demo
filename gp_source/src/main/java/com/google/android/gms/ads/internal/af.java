package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.client.u;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.ads.internal.util.l;
import com.google.android.gms.ads.internal.zxxz.v;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@com.google.android.gms.ads.internal.q.a.a
public final class af
  implements v, Runnable
{
  private Context a;
  private final List b = new Vector();
  private final AtomicReference c = new AtomicReference();
  private CountDownLatch d = new CountDownLatch(1);
  private VersionInfoParcel e;
  
  public af(Context paramContext, VersionInfoParcel paramVersionInfoParcel)
  {
    this.a = paramContext;
    this.e = paramVersionInfoParcel;
    paramContext = u.h.a;
    if (com.google.android.gms.ads.internal.util.client.a.b())
    {
      l.a(this);
      return;
    }
    run();
  }
  
  public af(bu parambu)
  {
    this(parambu.m, parambu.P);
  }
  
  private final boolean a()
  {
    try
    {
      this.d.await();
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      e.e("Interrupted during GADSignals creation.", localInterruptedException);
    }
    return false;
  }
  
  private static Context b(Context paramContext)
  {
    Context localContext = paramContext.getApplicationContext();
    if (localContext == null) {
      return paramContext;
    }
    return localContext;
  }
  
  private final void b()
  {
    if (!this.b.isEmpty())
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        Object[] arrayOfObject = (Object[])localIterator.next();
        int i = arrayOfObject.length;
        if (i == 1) {
          ((v)this.c.get()).a((MotionEvent)arrayOfObject[0]);
        } else if (i == 3) {
          ((v)this.c.get()).a(((Integer)arrayOfObject[0]).intValue(), ((Integer)arrayOfObject[1]).intValue(), ((Integer)arrayOfObject[2]).intValue());
        }
      }
      this.b.clear();
    }
  }
  
  public final String a(Context paramContext)
  {
    if (a())
    {
      v localv = (v)this.c.get();
      if (localv != null)
      {
        b();
        return localv.a(b(paramContext));
      }
    }
    return "";
  }
  
  public final String a(Context paramContext, String paramString, View paramView)
  {
    return a(paramContext, paramString, paramView, null);
  }
  
  public final String a(Context paramContext, String paramString, View paramView, Activity paramActivity)
  {
    if (a())
    {
      v localv = (v)this.c.get();
      if (localv != null)
      {
        b();
        return localv.a(b(paramContext), paramString, paramView, paramActivity);
      }
    }
    return "";
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    v localv = (v)this.c.get();
    if (localv != null)
    {
      b();
      localv.a(paramInt1, paramInt2, paramInt3);
      return;
    }
    this.b.add(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
  }
  
  public final void a(MotionEvent paramMotionEvent)
  {
    v localv = (v)this.c.get();
    if (localv != null)
    {
      b();
      localv.a(paramMotionEvent);
      return;
    }
    this.b.add(new Object[] { paramMotionEvent });
  }
  
  public final void a(View paramView)
  {
    v localv = (v)this.c.get();
    if (localv != null) {
      localv.a(paramView);
    }
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	com/google/android/gms/ads/internal/af:e	Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;
    //   4: getfield 170	com/google/android/gms/ads/internal/util/client/VersionInfoParcel:d	Z
    //   7: istore_1
    //   8: getstatic 176	com/google/android/gms/ads/internal/f/n:Y	Lcom/google/android/gms/ads/internal/f/c;
    //   11: astore_2
    //   12: getstatic 51	com/google/android/gms/ads/internal/client/u:h	Lcom/google/android/gms/ads/internal/client/u;
    //   15: getfield 179	com/google/android/gms/ads/internal/client/u:e	Lcom/google/android/gms/ads/internal/f/k;
    //   18: aload_2
    //   19: invokevirtual 184	com/google/android/gms/ads/internal/f/k:a	(Lcom/google/android/gms/ads/internal/f/c;)Ljava/lang/Object;
    //   22: checkcast 186	java/lang/Boolean
    //   25: invokevirtual 189	java/lang/Boolean:booleanValue	()Z
    //   28: ifeq +50 -> 78
    //   31: iconst_0
    //   32: istore_1
    //   33: aload_0
    //   34: getfield 45	com/google/android/gms/ads/internal/af:e	Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;
    //   37: getfield 192	com/google/android/gms/ads/internal/util/client/VersionInfoParcel:a	Ljava/lang/String;
    //   40: aload_0
    //   41: getfield 43	com/google/android/gms/ads/internal/af:a	Landroid/content/Context;
    //   44: invokestatic 145	com/google/android/gms/ads/internal/af:b	(Landroid/content/Context;)Landroid/content/Context;
    //   47: iload_1
    //   48: invokestatic 197	com/google/android/gms/ads/internal/zxxz/z:a	(Ljava/lang/String;Landroid/content/Context;Z)Lcom/google/android/gms/ads/internal/zxxz/z;
    //   51: astore_2
    //   52: aload_0
    //   53: getfield 34	com/google/android/gms/ads/internal/af:c	Ljava/util/concurrent/atomic/AtomicReference;
    //   56: aload_2
    //   57: invokevirtual 201	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   60: aload_0
    //   61: getfield 41	com/google/android/gms/ads/internal/af:d	Ljava/util/concurrent/CountDownLatch;
    //   64: invokevirtual 204	java/util/concurrent/CountDownLatch:countDown	()V
    //   67: aload_0
    //   68: aconst_null
    //   69: putfield 43	com/google/android/gms/ads/internal/af:a	Landroid/content/Context;
    //   72: aload_0
    //   73: aconst_null
    //   74: putfield 45	com/google/android/gms/ads/internal/af:e	Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;
    //   77: return
    //   78: iload_1
    //   79: ifeq +8 -> 87
    //   82: iconst_1
    //   83: istore_1
    //   84: goto -51 -> 33
    //   87: iconst_0
    //   88: istore_1
    //   89: goto -56 -> 33
    //   92: astore_2
    //   93: aload_0
    //   94: getfield 41	com/google/android/gms/ads/internal/af:d	Ljava/util/concurrent/CountDownLatch;
    //   97: invokevirtual 204	java/util/concurrent/CountDownLatch:countDown	()V
    //   100: aload_0
    //   101: aconst_null
    //   102: putfield 43	com/google/android/gms/ads/internal/af:a	Landroid/content/Context;
    //   105: aload_0
    //   106: aconst_null
    //   107: putfield 45	com/google/android/gms/ads/internal/af:e	Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;
    //   110: aload_2
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	af
    //   7	82	1	bool	boolean
    //   11	46	2	localObject1	Object
    //   92	19	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	31	92	finally
    //   33	60	92	finally
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */