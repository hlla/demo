package com.google.android.gms.ads.internal.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.client.u;
import com.google.android.gms.ads.internal.f.c;
import com.google.android.gms.ads.internal.f.k;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.bm;
import com.google.android.gms.ads.internal.util.bs;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.ads.internal.util.v;
import com.google.android.gms.common.util.b;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

@a
@TargetApi(14)
public final class z
  implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener
{
  private static final long a;
  private ae b;
  private Application c;
  private final Context d;
  private BroadcastReceiver e;
  private final DisplayMetrics f;
  private boolean g = false;
  private final KeyguardManager h;
  private WeakReference i;
  private final HashSet j = new HashSet();
  private final PowerManager k;
  private bm l = new bm(a);
  private final Rect m;
  private WeakReference n;
  private final WindowManager o;
  private int p = -1;
  
  static
  {
    c localc = com.google.android.gms.ads.internal.f.n.cv;
    a = ((Long)u.h.e.a(localc)).longValue();
  }
  
  public z(Context paramContext, View paramView)
  {
    this.d = paramContext.getApplicationContext();
    this.o = ((WindowManager)paramContext.getSystemService("window"));
    this.k = ((PowerManager)this.d.getSystemService("power"));
    this.h = ((KeyguardManager)paramContext.getSystemService("keyguard"));
    Object localObject = this.d;
    if ((localObject instanceof Application))
    {
      localObject = (Application)localObject;
      this.c = ((Application)localObject);
      this.b = new ae((Application)localObject, this);
    }
    this.f = paramContext.getResources().getDisplayMetrics();
    this.m = new Rect();
    this.m.right = this.o.getDefaultDisplay().getWidth();
    this.m.bottom = this.o.getDefaultDisplay().getHeight();
    paramContext = this.n;
    if (paramContext != null) {}
    for (paramContext = (View)paramContext.get();; paramContext = null)
    {
      if (paramContext == null) {}
      for (;;)
      {
        this.n = new WeakReference(paramView);
        if (paramView != null)
        {
          if (bt.A.g.a(paramView)) {
            a(paramView);
          }
          paramView.addOnAttachStateChangeListener(this);
        }
        return;
        paramContext.removeOnAttachStateChangeListener(this);
        b(paramContext);
      }
    }
  }
  
  private final Rect a(Rect paramRect)
  {
    return new Rect(b(paramRect.left), b(paramRect.top), b(paramRect.right), b(paramRect.bottom));
  }
  
  private final void a()
  {
    com.google.android.gms.ads.internal.util.n localn = bt.A.e;
    com.google.android.gms.ads.internal.util.n.a.post(new aa(this));
  }
  
  private final void a(Activity paramActivity, int paramInt)
  {
    if (this.n != null)
    {
      paramActivity = paramActivity.getWindow();
      if (paramActivity != null)
      {
        paramActivity = paramActivity.peekDecorView();
        View localView = (View)this.n.get();
        if ((localView != null) && (paramActivity != null) && (localView.getRootView() == paramActivity.getRootView())) {
          this.p = paramInt;
        }
      }
    }
  }
  
  private final void a(View paramView)
  {
    paramView = paramView.getViewTreeObserver();
    if (paramView.isAlive())
    {
      this.i = new WeakReference(paramView);
      paramView.addOnScrollChangedListener(this);
      paramView.addOnGlobalLayoutListener(this);
    }
    if (this.e == null)
    {
      paramView = new IntentFilter();
      paramView.addAction("android.intent.action.SCREEN_ON");
      paramView.addAction("android.intent.action.SCREEN_OFF");
      paramView.addAction("android.intent.action.USER_PRESENT");
      this.e = new ab(this);
      bt.A.C.a(this.d, this.e, paramView);
    }
    paramView = this.c;
    if (paramView != null) {}
    try
    {
      paramView.registerActivityLifecycleCallbacks(this.b);
      return;
    }
    catch (Exception paramView)
    {
      e.c("Error registering activity lifecycle callbacks.", paramView);
    }
  }
  
  private final int b(int paramInt)
  {
    return (int)(paramInt / this.f.density);
  }
  
  /* Error */
  private final void b(View paramView)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 275	com/google/android/gms/ads/internal/a/z:i	Ljava/lang/ref/WeakReference;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnonnull +88 -> 94
    //   9: aload_1
    //   10: invokevirtual 267	android/view/View:getViewTreeObserver	()Landroid/view/ViewTreeObserver;
    //   13: astore_1
    //   14: aload_1
    //   15: invokevirtual 273	android/view/ViewTreeObserver:isAlive	()Z
    //   18: istore_2
    //   19: iload_2
    //   20: ifne +50 -> 70
    //   23: aload_0
    //   24: getfield 285	com/google/android/gms/ads/internal/a/z:e	Landroid/content/BroadcastReceiver;
    //   27: ifnull +25 -> 52
    //   30: getstatic 193	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   33: getfield 305	com/google/android/gms/ads/internal/bt:C	Lcom/google/android/gms/ads/internal/util/bs;
    //   36: aload_0
    //   37: getfield 105	com/google/android/gms/ads/internal/a/z:d	Landroid/content/Context;
    //   40: aload_0
    //   41: getfield 285	com/google/android/gms/ads/internal/a/z:e	Landroid/content/BroadcastReceiver;
    //   44: invokevirtual 332	com/google/android/gms/ads/internal/util/bs:a	(Landroid/content/Context;Landroid/content/BroadcastReceiver;)V
    //   47: aload_0
    //   48: aconst_null
    //   49: putfield 285	com/google/android/gms/ads/internal/a/z:e	Landroid/content/BroadcastReceiver;
    //   52: aload_0
    //   53: getfield 131	com/google/android/gms/ads/internal/a/z:c	Landroid/app/Application;
    //   56: astore_1
    //   57: aload_1
    //   58: ifnull +11 -> 69
    //   61: aload_1
    //   62: aload_0
    //   63: getfield 138	com/google/android/gms/ads/internal/a/z:b	Lcom/google/android/gms/ads/internal/a/ae;
    //   66: invokevirtual 335	android/app/Application:unregisterActivityLifecycleCallbacks	(Landroid/app/Application$ActivityLifecycleCallbacks;)V
    //   69: return
    //   70: aload_1
    //   71: aload_0
    //   72: invokevirtual 338	android/view/ViewTreeObserver:removeOnScrollChangedListener	(Landroid/view/ViewTreeObserver$OnScrollChangedListener;)V
    //   75: aload_1
    //   76: aload_0
    //   77: invokevirtual 341	android/view/ViewTreeObserver:removeGlobalOnLayoutListener	(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    //   80: goto -57 -> 23
    //   83: astore_1
    //   84: ldc_w 343
    //   87: aload_1
    //   88: invokestatic 321	com/google/android/gms/ads/internal/util/e:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   91: goto -68 -> 23
    //   94: aload_3
    //   95: invokevirtual 182	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   98: checkcast 269	android/view/ViewTreeObserver
    //   101: astore_3
    //   102: aload_3
    //   103: ifnull +10 -> 113
    //   106: aload_3
    //   107: invokevirtual 273	android/view/ViewTreeObserver:isAlive	()Z
    //   110: ifne +22 -> 132
    //   113: aload_0
    //   114: aconst_null
    //   115: putfield 275	com/google/android/gms/ads/internal/a/z:i	Ljava/lang/ref/WeakReference;
    //   118: goto -109 -> 9
    //   121: astore_3
    //   122: ldc_w 345
    //   125: aload_3
    //   126: invokestatic 321	com/google/android/gms/ads/internal/util/e:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   129: goto -120 -> 9
    //   132: aload_3
    //   133: aload_0
    //   134: invokevirtual 338	android/view/ViewTreeObserver:removeOnScrollChangedListener	(Landroid/view/ViewTreeObserver$OnScrollChangedListener;)V
    //   137: aload_3
    //   138: aload_0
    //   139: invokevirtual 341	android/view/ViewTreeObserver:removeGlobalOnLayoutListener	(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    //   142: goto -29 -> 113
    //   145: astore_1
    //   146: ldc_w 347
    //   149: aload_1
    //   150: invokestatic 321	com/google/android/gms/ads/internal/util/e:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   153: goto -106 -> 47
    //   156: astore_1
    //   157: getstatic 193	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   160: getfield 350	com/google/android/gms/ads/internal/bt:i	Lcom/google/android/gms/ads/internal/v/f;
    //   163: aload_1
    //   164: ldc_w 352
    //   167: invokevirtual 357	com/google/android/gms/ads/internal/v/f:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   170: goto -123 -> 47
    //   173: astore_1
    //   174: ldc_w 316
    //   177: aload_1
    //   178: invokestatic 321	com/google/android/gms/ads/internal/util/e:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   181: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	z
    //   0	182	1	paramView	View
    //   18	2	2	bool	boolean
    //   4	103	3	localObject	Object
    //   121	17	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   9	19	83	java/lang/Exception
    //   70	80	83	java/lang/Exception
    //   0	5	121	java/lang/Exception
    //   94	102	121	java/lang/Exception
    //   106	113	121	java/lang/Exception
    //   113	118	121	java/lang/Exception
    //   132	142	121	java/lang/Exception
    //   30	47	145	java/lang/IllegalStateException
    //   30	47	156	java/lang/Exception
    //   61	69	173	java/lang/Exception
  }
  
  public final void a(int paramInt)
  {
    Object localObject1;
    Object localObject3;
    int i2;
    if (this.j.size() != 0)
    {
      localObject1 = this.n;
      if (localObject1 != null)
      {
        localObject3 = (View)((WeakReference)localObject1).get();
        if (paramInt != 1) {
          break label523;
        }
        i2 = 1;
      }
    }
    for (;;)
    {
      Rect localRect2 = new Rect();
      Rect localRect1 = new Rect();
      Object localObject2 = new Rect();
      localObject1 = new Rect();
      Object localObject4 = new int[2];
      int[] arrayOfInt = new int[2];
      boolean bool2;
      boolean bool3;
      if (localObject3 != null)
      {
        bool2 = ((View)localObject3).getGlobalVisibleRect(localRect1);
        bool3 = ((View)localObject3).getLocalVisibleRect((Rect)localObject2);
        ((View)localObject3).getHitRect((Rect)localObject1);
      }
      try
      {
        ((View)localObject3).getLocationOnScreen((int[])localObject4);
        ((View)localObject3).getLocationInWindow(arrayOfInt);
        localRect2.left = localObject4[0];
        localRect2.top = localObject4[1];
        localRect2.right = (localRect2.left + ((View)localObject3).getWidth());
        localRect2.bottom = (localRect2.top + ((View)localObject3).getHeight());
        for (;;)
        {
          if (localObject3 != null) {}
          for (int i1 = ((View)localObject3).getWindowVisibility();; i1 = 8)
          {
            int i3 = this.p;
            if (i3 != -1) {
              i1 = i3;
            }
            boolean bool1;
            if (localObject3 != null)
            {
              localObject4 = bt.A.e;
              if (!com.google.android.gms.ads.internal.util.n.a((View)localObject3, this.k, this.h)) {
                bool1 = false;
              }
            }
            for (;;)
            {
              if ((i2 == 0) || (this.l.a()) || (bool1 != this.g)) {
                if (!bool1) {
                  break label451;
                }
              }
              label451:
              while ((this.g) || (paramInt != 1))
              {
                bt.A.l.b();
                this.k.isScreenOn();
                if (localObject3 != null) {}
                for (boolean bool4 = bt.A.g.a((View)localObject3);; bool4 = false)
                {
                  if (localObject3 != null) {}
                  for (paramInt = ((View)localObject3).getWindowVisibility();; paramInt = 8)
                  {
                    localObject3 = a(this.m);
                    localRect2 = a(localRect2);
                    localRect1 = a(localRect1);
                    localObject2 = a((Rect)localObject2);
                    localObject1 = a((Rect)localObject1);
                    float f1 = this.f.density;
                    localObject1 = new ac(bool4, paramInt, (Rect)localObject3, localRect2, localRect1, bool2, (Rect)localObject2, bool3, (Rect)localObject1, bool1);
                    localObject2 = this.j.iterator();
                    while (((Iterator)localObject2).hasNext()) {
                      ((ad)((Iterator)localObject2).next()).a((ac)localObject1);
                    }
                    this.g = bool1;
                    return;
                  }
                }
              }
              return;
              if (!bool2)
              {
                bool1 = false;
              }
              else if (!bool3)
              {
                bool1 = false;
              }
              else if (i1 == 0)
              {
                bool1 = true;
              }
              else
              {
                bool1 = false;
                continue;
                bool1 = false;
              }
            }
          }
          bool3 = false;
          bool2 = false;
        }
        label523:
        i2 = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          e.c("Failure getting view location.", localException);
        }
      }
    }
  }
  
  public final void a(ad paramad)
  {
    this.j.add(paramad);
    a(3);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    a(paramActivity, 0);
    a(3);
    a();
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    a(3);
    a();
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    a(paramActivity, 4);
    a(3);
    a();
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    a(paramActivity, 0);
    a(3);
    a();
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    a(3);
    a();
  }
  
  public final void onActivityStarted(Activity paramActivity)
  {
    a(paramActivity, 0);
    a(3);
    a();
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    a(3);
    a();
  }
  
  public final void onGlobalLayout()
  {
    a(2);
    a();
  }
  
  public final void onScrollChanged()
  {
    a(1);
  }
  
  public final void onViewAttachedToWindow(View paramView)
  {
    this.p = -1;
    a(paramView);
    a(3);
  }
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    this.p = -1;
    a(3);
    a();
    b(paramView);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/a/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */