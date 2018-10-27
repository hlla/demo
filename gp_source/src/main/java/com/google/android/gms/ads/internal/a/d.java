package com.google.android.gms.ads.internal.a;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.PowerManager;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.af;
import com.google.android.gms.ads.internal.util.bm;
import com.google.android.gms.ads.internal.util.bs;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.n;
import com.google.android.gms.ads.internal.util.v;
import com.google.android.gms.ads.internal.v.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public final class d
  implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener
{
  public final b a;
  public k b;
  public boolean c = false;
  public boolean d = false;
  public final Object e = new Object();
  private final HashSet f = new HashSet();
  private final Context g;
  private BroadcastReceiver h;
  private boolean i;
  private boolean j;
  private boolean k;
  private final KeyguardManager l;
  private final HashSet m = new HashSet();
  private float n;
  private final DisplayMetrics o;
  private final g p;
  private final PowerManager q;
  private bm r;
  private final Rect s = new Rect();
  private final an t;
  private WeakReference u;
  private final WindowManager v;
  
  public d(Context paramContext, AdSizeParcel paramAdSizeParcel, com.google.android.gms.ads.internal.v.a parama, VersionInfoParcel paramVersionInfoParcel, an paraman)
  {
    new WeakReference(parama);
    this.t = paraman;
    this.u = new WeakReference(null);
    this.j = true;
    this.k = false;
    this.r = new bm(200L);
    this.a = new b(UUID.randomUUID().toString(), paramVersionInfoParcel, paramAdSizeParcel.a, parama.a, parama.a(), paramAdSizeParcel.f);
    this.v = ((WindowManager)paramContext.getSystemService("window"));
    this.q = ((PowerManager)paramContext.getApplicationContext().getSystemService("power"));
    this.l = ((KeyguardManager)paramContext.getSystemService("keyguard"));
    this.g = paramContext;
    this.p = new g(this, new Handler());
    this.g.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.p);
    this.o = paramContext.getResources().getDisplayMetrics();
    paramContext = this.v.getDefaultDisplay();
    this.s.right = paramContext.getWidth();
    this.s.bottom = paramContext.getHeight();
    a();
  }
  
  private static int a(int paramInt, DisplayMetrics paramDisplayMetrics)
  {
    return (int)(paramInt / paramDisplayMetrics.density);
  }
  
  private final JSONObject a(View paramView, Boolean paramBoolean)
  {
    boolean bool1;
    Object localObject2;
    Object localObject1;
    if (paramView != null)
    {
      bool1 = bt.A.g.a(paramView);
      localObject2 = new int[2];
      localObject1 = new int[2];
    }
    try
    {
      paramView.getLocationOnScreen((int[])localObject2);
      paramView.getLocationInWindow((int[])localObject1);
      localObject1 = new Rect();
      ((Rect)localObject1).left = localObject2[0];
      ((Rect)localObject1).top = localObject2[1];
      ((Rect)localObject1).right = (((Rect)localObject1).left + paramView.getWidth());
      ((Rect)localObject1).bottom = (((Rect)localObject1).top + paramView.getHeight());
      Rect localRect1 = new Rect();
      boolean bool2 = paramView.getGlobalVisibleRect(localRect1, null);
      Rect localRect2 = new Rect();
      boolean bool3 = paramView.getLocalVisibleRect(localRect2);
      Rect localRect3 = new Rect();
      paramView.getHitRect(localRect3);
      localObject2 = f();
      ((JSONObject)localObject2).put("windowVisibility", paramView.getWindowVisibility()).put("isAttachedToWindow", bool1).put("viewBox", new JSONObject().put("top", a(this.s.top, this.o)).put("bottom", a(this.s.bottom, this.o)).put("left", a(this.s.left, this.o)).put("right", a(this.s.right, this.o))).put("adBox", new JSONObject().put("top", a(((Rect)localObject1).top, this.o)).put("bottom", a(((Rect)localObject1).bottom, this.o)).put("left", a(((Rect)localObject1).left, this.o)).put("right", a(((Rect)localObject1).right, this.o))).put("globalVisibleBox", new JSONObject().put("top", a(localRect1.top, this.o)).put("bottom", a(localRect1.bottom, this.o)).put("left", a(localRect1.left, this.o)).put("right", a(localRect1.right, this.o))).put("globalVisibleBoxVisible", bool2).put("localVisibleBox", new JSONObject().put("top", a(localRect2.top, this.o)).put("bottom", a(localRect2.bottom, this.o)).put("left", a(localRect2.left, this.o)).put("right", a(localRect2.right, this.o))).put("localVisibleBoxVisible", bool3).put("hitBox", new JSONObject().put("top", a(localRect3.top, this.o)).put("bottom", a(localRect3.bottom, this.o)).put("left", a(localRect3.left, this.o)).put("right", a(localRect3.right, this.o))).put("screenDensity", this.o.density);
      localObject1 = paramBoolean;
      if (paramBoolean == null)
      {
        paramBoolean = bt.A.e;
        localObject1 = Boolean.valueOf(n.a(paramView, this.q, this.l));
      }
      ((JSONObject)localObject2).put("isVisible", ((Boolean)localObject1).booleanValue());
      return (JSONObject)localObject2;
      return f().put("isAttachedToWindow", false).put("isScreenOn", g()).put("isVisible", false);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.e.c("Failure getting view location.", localException);
      }
    }
  }
  
  private static JSONObject a(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    localJSONArray.put(paramJSONObject);
    localJSONObject.put("units", localJSONArray);
    return localJSONObject;
  }
  
  private final void a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    try
    {
      paramJSONObject = a(paramJSONObject);
      ArrayList localArrayList = new ArrayList(this.m);
      int i2 = localArrayList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ((y)localArrayList.get(i1)).a(paramJSONObject, paramBoolean);
        i1 += 1;
      }
      return;
    }
    finally
    {
      com.google.android.gms.ads.internal.util.e.c("Skipping active view message.", paramJSONObject);
    }
  }
  
  private final void d()
  {
    k localk = this.b;
    if (localk != null) {
      localk.a(this);
    }
  }
  
  private final void e()
  {
    ViewTreeObserver localViewTreeObserver = (ViewTreeObserver)this.u.get();
    if ((localViewTreeObserver != null) && (localViewTreeObserver.isAlive()))
    {
      localViewTreeObserver.removeOnScrollChangedListener(this);
      localViewTreeObserver.removeGlobalOnLayoutListener(this);
    }
  }
  
  private final JSONObject f()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("afmaVersion", this.a.c).put("activeViewJSON", this.a.a).put("timestamp", bt.A.l.b()).put("adFormat", this.a.b).put("hashCode", this.a.f).put("isMraid", this.a.d).put("isStopped", this.d).put("isPaused", this.c).put("isNative", this.a.e).put("isScreenOn", g()).put("appMuted", bt.A.j.b()).put("appVolume", bt.A.j.a()).put("deviceVolume", this.n);
    return localJSONObject;
  }
  
  private final boolean g()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return this.q.isInteractive();
    }
    return this.q.isScreenOn();
  }
  
  public final void a()
  {
    this.n = af.a(this.g);
  }
  
  public final void a(int paramInt)
  {
    for (;;)
    {
      Object localObject3;
      boolean bool2;
      boolean bool1;
      synchronized (this.e)
      {
        Object localObject1 = this.m.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label330;
        }
        if (!((y)((Iterator)localObject1).next()).a()) {
          continue;
        }
        if (!this.j) {
          break label330;
        }
        localObject1 = this.t.a();
        if (localObject1 == null) {
          break label375;
        }
        localObject3 = bt.A.e;
        if (!n.a((View)localObject1, this.q, this.l)) {
          break label370;
        }
        bool2 = true;
        break label350;
        if (this.t.b())
        {
          b();
          return;
        }
        if ((paramInt == 1) && (!this.r.a()) && (bool1 == this.k)) {
          return;
        }
      }
      if (bool1) {}
      try
      {
        label157:
        a(a(localView, Boolean.valueOf(bool2)), false);
        this.k = bool1;
        for (;;)
        {
          localObject3 = this.t.c().a();
          ViewTreeObserver localViewTreeObserver;
          if (localObject3 != null)
          {
            localViewTreeObserver = (ViewTreeObserver)this.u.get();
            localObject3 = ((View)localObject3).getViewTreeObserver();
            if (localObject3 != localViewTreeObserver)
            {
              e();
              if (this.i) {
                break label273;
              }
            }
          }
          for (;;)
          {
            this.i = true;
            ((ViewTreeObserver)localObject3).addOnScrollChangedListener(this);
            ((ViewTreeObserver)localObject3).addOnGlobalLayoutListener(this);
            label273:
            do
            {
              this.u = new WeakReference(localObject3);
              d();
              return;
            } while ((localViewTreeObserver == null) || (!localViewTreeObserver.isAlive()));
          }
          if ((this.k) || (paramInt != 1)) {
            break label157;
          }
          return;
          label305:
          if (!bool2) {
            break label365;
          }
          if (!localViewTreeObserver.getGlobalVisibleRect(new Rect(), null)) {
            break label360;
          }
          bool1 = true;
          break;
          label330:
          return;
          com.google.android.gms.ads.internal.util.e.b("Active view update failed.", localViewTreeObserver);
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;) {}
        for (;;)
        {
          if (localJSONException != null) {
            break label305;
          }
          bool1 = false;
          break;
          bool1 = false;
          break;
          bool1 = false;
          break;
          bool2 = false;
          continue;
          bool2 = false;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        label350:
        label360:
        label365:
        label370:
        label375:
        for (;;) {}
      }
    }
  }
  
  final void a(y paramy)
  {
    String str = String.valueOf(this.a.f);
    if (str.length() == 0) {}
    for (str = new String("Received request to untrack: ");; str = "Received request to untrack: ".concat(str))
    {
      com.google.android.gms.ads.internal.util.e.b(str);
      c(paramy);
      return;
    }
  }
  
  final boolean a(Map paramMap)
  {
    if (paramMap != null)
    {
      paramMap = (String)paramMap.get("hashCode");
      return (!TextUtils.isEmpty(paramMap)) && (paramMap.equals(this.a.f));
    }
    return false;
  }
  
  public final void b()
  {
    synchronized (this.e)
    {
      boolean bool = this.j;
      if (!bool) {}
    }
    try
    {
      Object localObject1 = f();
      ((JSONObject)localObject1).put("doneReasonCode", "u");
      a((JSONObject)localObject1, true);
      localObject1 = String.valueOf(this.a.f);
      if (((String)localObject1).length() == 0) {}
      for (localObject1 = new String("Untracking ad unit: ");; localObject1 = "Untracking ad unit: ".concat((String)localObject1))
      {
        com.google.android.gms.ads.internal.util.e.b((String)localObject1);
        return;
      }
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.e.c("JSON failure while processing active view data.", localJSONException);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.e.c("Failure while processing active view data.", localRuntimeException);
      }
    }
  }
  
  public final void b(y paramy)
  {
    if (!this.m.isEmpty()) {}
    for (;;)
    {
      this.m.add(paramy);
      for (;;)
      {
        try
        {
          paramy.a(a(a(this.t.a(), null)), false);
          return;
        }
        catch (JSONException paramy)
        {
          com.google.android.gms.ads.internal.util.e.c("Skipping measurement update for new client.", paramy);
        }
        synchronized (this.e)
        {
          if (this.h == null)
          {
            IntentFilter localIntentFilter = new IntentFilter();
            localIntentFilter.addAction("android.intent.action.SCREEN_ON");
            localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.h = new e(this);
            bt.A.C.a(this.g, this.h, localIntentFilter);
            a(3);
            break;
          }
        }
      }
    }
  }
  
  final void b(Map paramMap)
  {
    if (paramMap.containsKey("isVisible"))
    {
      if (!"1".equals(paramMap.get("isVisible"))) {
        "true".equals(paramMap.get("isVisible"));
      }
      paramMap = this.f.iterator();
      while (paramMap.hasNext()) {
        ((a)paramMap.next()).a();
      }
    }
  }
  
  public final void c(y arg1)
  {
    int i1 = 0;
    this.m.remove(???);
    ???.b();
    if (this.m.isEmpty())
    {
      synchronized (this.e)
      {
        e();
        synchronized (this.e)
        {
          BroadcastReceiver localBroadcastReceiver = this.h;
          if (localBroadcastReceiver == null) {}
        }
      }
      try
      {
        bt.A.C.a(this.g, this.h);
        this.h = null;
        this.g.getContentResolver().unregisterContentObserver(this.p);
        this.j = false;
        d();
        ??? = new ArrayList(this.m);
        int i2 = ((ArrayList)???).size();
        while (i1 < i2)
        {
          c((y)((ArrayList)???).get(i1));
          i1 += 1;
        }
        return;
        localObject2 = finally;
        throw ((Throwable)localObject2);
        localObject3 = finally;
        throw ((Throwable)localObject3);
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          com.google.android.gms.ads.internal.util.e.c("Failed trying to unregister the receiver", localIllegalStateException);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          bt.A.i.a(localException, "ActiveViewUnit.stopScreenStatusMonitoring");
        }
      }
    }
  }
  
  public final boolean c()
  {
    synchronized (this.e)
    {
      boolean bool = this.j;
      return bool;
    }
  }
  
  public final void onGlobalLayout()
  {
    a(2);
  }
  
  public final void onScrollChanged()
  {
    a(1);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */