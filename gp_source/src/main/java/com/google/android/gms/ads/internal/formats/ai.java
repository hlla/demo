package com.google.android.gms.ads.internal.formats;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.client.u;
import com.google.android.gms.ads.internal.formats.a.p;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@com.google.android.gms.ads.internal.q.a.a
public final class ai
  extends p
  implements View.OnClickListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, al
{
  public static final String[] a = { "2011", "1009", "3010" };
  public final Map b = new HashMap();
  public final Map c = new HashMap();
  public final Object d = new Object();
  public final Map e = new HashMap();
  private final WeakReference f;
  private Point g = new Point();
  private t h;
  private View i;
  private Point j = new Point();
  
  public ai(View paramView, HashMap paramHashMap1, HashMap paramHashMap2)
  {
    new WeakReference(null);
    Object localObject1 = bt.A.E;
    com.google.android.gms.ads.internal.util.d.a.a(paramView, this);
    localObject1 = bt.A.E;
    com.google.android.gms.ads.internal.util.d.a.a(paramView, this);
    paramView.setOnTouchListener(this);
    paramView.setOnClickListener(this);
    this.f = new WeakReference(paramView);
    paramHashMap1 = paramHashMap1.entrySet().iterator();
    while (paramHashMap1.hasNext())
    {
      Object localObject2 = (Map.Entry)paramHashMap1.next();
      localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (View)((Map.Entry)localObject2).getValue();
      if (localObject2 != null)
      {
        this.c.put(localObject1, new WeakReference(localObject2));
        if ((!"1098".equals(localObject1)) && (!"3011".equals(localObject1)))
        {
          ((View)localObject2).setOnTouchListener(this);
          ((View)localObject2).setClickable(true);
          ((View)localObject2).setOnClickListener(this);
        }
      }
    }
    this.b.putAll(this.c);
    paramHashMap1 = paramHashMap2.entrySet().iterator();
    while (paramHashMap1.hasNext())
    {
      paramHashMap2 = (Map.Entry)paramHashMap1.next();
      localObject1 = (View)paramHashMap2.getValue();
      if (localObject1 != null)
      {
        this.e.put((String)paramHashMap2.getKey(), new WeakReference(localObject1));
        ((View)localObject1).setOnTouchListener(this);
      }
    }
    this.b.putAll(this.e);
    com.google.android.gms.ads.internal.f.n.a(paramView.getContext());
  }
  
  private final int a(int paramInt)
  {
    synchronized (this.d)
    {
      com.google.android.gms.ads.internal.util.client.a locala = u.h.a;
      paramInt = com.google.android.gms.ads.internal.util.client.a.b(this.h.p(), paramInt);
      return paramInt;
    }
  }
  
  private final void a(View paramView)
  {
    for (;;)
    {
      t localt1;
      synchronized (this.d)
      {
        t localt2 = this.h;
        if (localt2 != null)
        {
          localt1 = localt2;
          if ((localt2 instanceof s)) {
            localt1 = ((s)localt2).i();
          }
        }
        else
        {
          return;
          localt1.d(paramView);
        }
      }
      if (localt1 != null) {}
    }
  }
  
  public final void a()
  {
    synchronized (this.d)
    {
      this.i = null;
      this.h = null;
      this.g = null;
      this.j = null;
      return;
    }
  }
  
  public final void a(com.google.android.gms.ads.internal.j.a arg1)
  {
    Object localObject2;
    Object localObject4;
    synchronized (this.d)
    {
      a(null);
      ??? = com.google.android.gms.dynamic.e.a(???);
      if ((??? instanceof x))
      {
        localObject2 = (x)???;
        if (((x)localObject2).c())
        {
          localObject4 = (View)this.f.get();
          ??? = this.h;
          if (??? != null) {}
        }
      }
    }
    for (;;)
    {
      synchronized (this.d)
      {
        Object localObject5 = this.h;
        if ((localObject5 instanceof x))
        {
          Object localObject6 = (x)localObject5;
          localObject5 = (View)this.f.get();
          if ((localObject6 == null) || (((x)localObject6).c == null))
          {
            ??? = this.h;
            if (((??? instanceof s)) && (((s)???).h()))
            {
              ((s)this.h).a((t)localObject2);
              int k = 0;
              if (k >= 2) {
                break label560;
              }
              ??? = new String[] { "1098", "3011" }[k];
              ??? = (WeakReference)this.b.get(???);
              if (??? == null)
              {
                k += 1;
                continue;
              }
              ??? = (View)???.get();
              if (??? == null)
              {
                com.google.android.gms.ads.internal.util.e.e("Ad choices asset view is not provided.");
                ((x)localObject2).a((View)localObject4, this.c, this.e, this, this);
                com.google.android.gms.ads.internal.util.n.a.post(new aj(this, (x)localObject2));
                a((View)localObject4);
                this.h.c((View)localObject4);
                synchronized (this.d)
                {
                  localObject2 = this.h;
                  if (!(localObject2 instanceof x)) {
                    continue;
                  }
                  localObject4 = (x)localObject2;
                  localObject2 = (View)this.f.get();
                  if ((localObject4 == null) || (((x)localObject4).c == null)) {
                    return;
                  }
                  if (localObject2 == null) {
                    continue;
                  }
                  localObject4 = bt.A.B;
                  ((View)localObject2).getContext();
                }
                ??? = finally;
                throw ???;
                continue;
              }
              if (!(??? instanceof ViewGroup)) {
                break label555;
              }
              ??? = (ViewGroup)???;
              if (??? == null) {
                continue;
              }
              this.i = localt.a(this, true);
              localObject5 = this.i;
              if (localObject5 == null) {
                continue;
              }
              this.b.put("1007", new WeakReference(localObject5));
              this.c.put("1007", new WeakReference(this.i));
              ???.removeAllViews();
              ???.addView(this.i);
              continue;
            }
            this.h = localt;
            if (!(localt instanceof s)) {
              continue;
            }
            ((s)localt).a(null);
            continue;
          }
          if (localObject5 == null) {
            continue;
          }
          localObject6 = bt.A.B;
          ((View)localObject5).getContext();
        }
      }
      continue;
      if (localObject4 != null)
      {
        ???.b((View)localObject4);
        continue;
        com.google.android.gms.ads.internal.util.e.c("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
        return;
        com.google.android.gms.ads.internal.util.e.e("Not an instance of native engine. This is most likely a transient error");
        return;
        label555:
        ??? = null;
        continue;
        label560:
        ??? = null;
      }
    }
  }
  
  public final Map b()
  {
    try
    {
      Map localMap = this.b;
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void b(com.google.android.gms.ads.internal.j.a parama)
  {
    synchronized (this.d)
    {
      this.h.a((View)com.google.android.gms.dynamic.e.a(parama));
      return;
    }
  }
  
  public final View c()
  {
    return (View)this.f.get();
  }
  
  public final void onClick(View paramView)
  {
    for (;;)
    {
      View localView;
      Bundle localBundle;
      Object localObject2;
      synchronized (this.d)
      {
        if (this.h == null) {
          break label243;
        }
        localView = (View)this.f.get();
        if (localView == null) {
          break;
        }
        localBundle = new Bundle();
        localBundle.putFloat("x", a(this.g.x));
        localBundle.putFloat("y", a(this.g.y));
        localBundle.putFloat("start_x", a(this.j.x));
        localBundle.putFloat("start_y", a(this.j.y));
        localObject2 = this.i;
        if (localObject2 == null)
        {
          this.h.a(paramView, this.b, localBundle, localView);
          return;
        }
        if (!localObject2.equals(paramView)) {
          continue;
        }
        localObject2 = this.h;
        if (!(localObject2 instanceof s)) {
          ((t)localObject2).a(paramView, "1007", localBundle, this.b, localView, false);
        }
      }
      if (((s)localObject2).i() != null) {
        ((s)this.h).i().a(paramView, "1007", localBundle, this.b, localView, false);
      }
    }
    return;
    label243:
  }
  
  public final void onGlobalLayout()
  {
    synchronized (this.d)
    {
      if (this.h != null)
      {
        View localView = (View)this.f.get();
        if (localView != null) {
          this.h.b(localView, this.b);
        }
      }
      return;
    }
  }
  
  public final void onScrollChanged()
  {
    synchronized (this.d)
    {
      if (this.h != null)
      {
        View localView = (View)this.f.get();
        if (localView != null) {
          this.h.b(localView, this.b);
        }
      }
      return;
    }
  }
  
  public final boolean onTouch(View arg1, MotionEvent paramMotionEvent)
  {
    synchronized (this.d)
    {
      if (this.h == null) {
        break label158;
      }
      Object localObject = (View)this.f.get();
      if (localObject != null)
      {
        int[] arrayOfInt = new int[2];
        ((View)localObject).getLocationOnScreen(arrayOfInt);
        float f1 = paramMotionEvent.getRawX();
        int k = arrayOfInt[0];
        float f2 = paramMotionEvent.getRawY();
        int m = arrayOfInt[1];
        localObject = new Point((int)(f1 - k), (int)(f2 - m));
        this.g = ((Point)localObject);
        if (paramMotionEvent.getAction() != 0)
        {
          paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
          paramMotionEvent.setLocation(((Point)localObject).x, ((Point)localObject).y);
          this.h.a(paramMotionEvent);
          paramMotionEvent.recycle();
          return false;
        }
        this.j = ((Point)localObject);
      }
    }
    return false;
    label158:
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/formats/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */