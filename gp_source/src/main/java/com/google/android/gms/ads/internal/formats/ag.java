package com.google.android.gms.ads.internal.formats;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.f.n;
import com.google.android.gms.ads.internal.formats.a.j;
import com.google.android.gms.ads.internal.util.g;
import com.google.android.gms.ads.internal.v.f;
import com.google.android.gms.ads.internal.webview.i;
import com.google.android.gms.common.util.h;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@com.google.android.gms.ads.internal.q.a.a
public final class ag
  extends j
  implements View.OnClickListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, al
{
  private static final String[] a = { "2011", "1009", "3010" };
  private View b;
  private Map c = Collections.synchronizedMap(new HashMap());
  private Point d = new Point();
  private t e;
  private View f;
  private final Object g = new Object();
  private final FrameLayout h;
  private FrameLayout i;
  private Point j = new Point();
  
  @TargetApi(21)
  public ag(FrameLayout paramFrameLayout1, FrameLayout paramFrameLayout2)
  {
    new WeakReference(null);
    this.h = paramFrameLayout1;
    this.i = paramFrameLayout2;
    paramFrameLayout1 = bt.A.E;
    com.google.android.gms.ads.internal.util.d.a.a(this.h, this);
    paramFrameLayout1 = bt.A.E;
    com.google.android.gms.ads.internal.util.d.a.a(this.h, this);
    this.h.setOnTouchListener(this);
    this.h.setOnClickListener(this);
    if ((paramFrameLayout2 != null) && (h.c())) {
      paramFrameLayout2.setElevation(Float.MAX_VALUE);
    }
    n.a(this.h.getContext());
  }
  
  private final int a(int paramInt)
  {
    com.google.android.gms.ads.internal.util.client.a locala = com.google.android.gms.ads.internal.client.u.h.a;
    return com.google.android.gms.ads.internal.util.client.a.b(this.e.p(), paramInt);
  }
  
  private final void a(View paramView)
  {
    t localt2 = this.e;
    if (localt2 != null)
    {
      t localt1 = localt2;
      if ((localt2 instanceof s)) {
        localt1 = ((s)localt2).i();
      }
      if (localt1 != null) {
        localt1.d(paramView);
      }
    }
  }
  
  public final com.google.android.gms.ads.internal.j.a a(String paramString)
  {
    for (;;)
    {
      synchronized (this.g)
      {
        Map localMap = this.c;
        if (localMap != null)
        {
          paramString = (WeakReference)localMap.get(paramString);
          if (paramString != null)
          {
            paramString = (View)paramString.get();
            paramString = com.google.android.gms.dynamic.e.a(paramString);
            return paramString;
          }
        }
        else
        {
          return null;
        }
      }
      paramString = null;
    }
  }
  
  public final void a()
  {
    synchronized (this.g)
    {
      FrameLayout localFrameLayout = this.i;
      if (localFrameLayout == null)
      {
        this.i = null;
        this.c = null;
        this.f = null;
        this.e = null;
        this.d = null;
        this.j = null;
        this.b = null;
        return;
      }
      localFrameLayout.removeAllViews();
    }
  }
  
  public final void a(com.google.android.gms.ads.internal.j.a parama)
  {
    boolean bool3 = true;
    boolean bool2 = true;
    int m = 0;
    boolean bool1;
    for (;;)
    {
      x localx;
      int k;
      synchronized (this.g)
      {
        a(null);
        parama = com.google.android.gms.dynamic.e.a(parama);
        if ((parama instanceof x))
        {
          localx = (x)parama;
          parama = this.e;
          if (parama != null) {
            parama.b(this.h);
          }
          parama = this.e;
          if ((parama instanceof x))
          {
            parama = (x)parama;
            if (parama != null) {}
          }
          else
          {
            parama = this.e;
            if (((parama instanceof s)) && (((s)parama).h()))
            {
              ((s)this.e).a(localx);
              parama = this.i;
              if (parama == null) {
                return;
              }
              parama.setClickable(false);
              this.i.removeAllViews();
              bool1 = localx.a();
              if (!bool1) {
                break label1110;
              }
              if (this.c == null) {
                break label1105;
              }
              k = 0;
              if (k >= 2) {
                break label1100;
              }
              parama = new String[] { "1098", "3011" }[k];
              parama = (WeakReference)this.c.get(parama);
              if (parama == null)
              {
                k += 1;
                continue;
              }
              parama = (View)parama.get();
              if (!(parama instanceof ViewGroup)) {
                break label1095;
              }
              parama = (ViewGroup)parama;
              break label1046;
              label230:
              this.f = localx.a(this, bool1);
              ??? = this.f;
              if (??? == null)
              {
                localx.a(this.h, this.c, null, this, this);
                if (this.b != null) {
                  if (this.h != this.b.getParent()) {
                    this.h.addView(this.b);
                  }
                }
              }
            }
          }
        }
      }
      try
      {
        parama = localx.j();
        if (parama != null)
        {
          ??? = this.i;
          if (??? != null) {
            break label791;
          }
        }
        for (;;)
        {
          synchronized (this.g)
          {
            parama = this.c;
            if (localx.a.e() != null) {
              break label571;
            }
            if (this.c == null) {
              break label1062;
            }
            parama = a;
            int n = parama.length;
            k = m;
            if (k >= n) {
              break;
            }
            localObject3 = parama[k];
            localObject3 = (WeakReference)this.c.get(localObject3);
            if (localObject3 == null)
            {
              k += 1;
              continue;
            }
            parama = (View)((WeakReference)localObject3).get();
            label414:
            if ((parama instanceof FrameLayout))
            {
              localObject3 = new ah(this, parama);
              if ((localx instanceof s))
              {
                localx.b(parama, (r)localObject3);
                localx.f = this;
                parama = this.h;
                localx.b.b(parama);
                a(this.h);
                this.e.c(this.h);
                parama = this.e;
                if ((parama instanceof x))
                {
                  parama = (x)parama;
                  if ((parama != null) && (parama.c != null))
                  {
                    parama = bt.A.B;
                    this.h.getContext();
                  }
                }
                return;
                parama = finally;
                throw parama;
              }
              localx.a(parama, (r)localObject3);
            }
          }
          continue;
          label571:
          String str1;
          String str2;
          if ("2".equals(localx.a.b()))
          {
            localObject3 = bt.A.i.f();
            str1 = localx.b.w();
            str2 = localx.a.b();
            if (parama == null) {
              break label1073;
            }
            bool1 = bool2;
            if (!parama.containsKey("2011"))
            {
              if (!parama.containsKey("3010")) {
                break label1067;
              }
              bool1 = bool2;
            }
            label659:
            ((g)localObject3).a(str1, str2, bool1);
          }
          else if ("1".equals(localx.a.b()))
          {
            localObject3 = bt.A.i.f();
            str1 = localx.b.w();
            str2 = localx.a.b();
            if (parama != null)
            {
              bool1 = bool3;
              if (!parama.containsKey("1009"))
              {
                if (!parama.containsKey("3010")) {
                  break label779;
                }
                bool1 = bool3;
              }
            }
            for (;;)
            {
              ((g)localObject3).a(str1, str2, bool1);
              break;
              label779:
              bool1 = false;
              continue;
              bool1 = false;
            }
            label791:
            ((FrameLayout)???).addView(parama.getView());
          }
        }
        this.b = new View(this.h.getContext());
        this.b.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
        continue;
        Object localObject3 = this.c;
        if (localObject3 != null) {
          ((Map)localObject3).put("1007", new WeakReference(???));
        }
        if (!bool1)
        {
          parama = new com.google.android.gms.ads.formats.a(localx.c);
          parama.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
          parama.addView(this.f);
          ??? = this.i;
          if (??? != null) {
            ((FrameLayout)???).addView(parama);
          }
        }
        else
        {
          parama.removeAllViews();
          parama.addView(this.f);
          continue;
          this.e = localx;
          if ((localx instanceof s))
          {
            ((s)localx).a(null);
            continue;
            if (parama.c != null)
            {
              parama = bt.A.B;
              this.h.getContext();
              continue;
              com.google.android.gms.ads.internal.util.e.e("Not an instance of native engine. This is most likely a transient error");
              return;
            }
          }
        }
      }
      catch (Exception parama)
      {
        for (;;)
        {
          ??? = bt.A.g;
          if (!com.google.android.gms.ads.internal.util.v.e())
          {
            com.google.android.gms.ads.internal.util.e.c("Error obtaining overlay.", parama);
            parama = null;
          }
          else
          {
            com.google.android.gms.ads.internal.util.e.e("Privileged processes cannot create HTML overlays.");
            parama = null;
          }
        }
      }
    }
    for (;;)
    {
      label1046:
      if (!bool1)
      {
        bool1 = false;
        break label230;
        parama = null;
        break label414;
        label1062:
        parama = null;
        break label414;
        label1067:
        bool1 = false;
        break label659;
        label1073:
        bool1 = false;
        break label659;
      }
      if (parama != null)
      {
        bool1 = true;
        break label230;
      }
      bool1 = false;
      break label230;
      label1095:
      parama = null;
      continue;
      label1100:
      parama = null;
      break;
      label1105:
      parama = null;
      break;
      label1110:
      parama = null;
    }
  }
  
  public final void a(com.google.android.gms.ads.internal.j.a parama, int paramInt)
  {
    parama = bt.A.B;
    this.h.getContext();
  }
  
  public final void a(String paramString, com.google.android.gms.ads.internal.j.a arg2)
  {
    View localView = (View)com.google.android.gms.dynamic.e.a(???);
    for (;;)
    {
      Map localMap;
      synchronized (this.g)
      {
        localMap = this.c;
        if (localMap == null) {
          return;
        }
        if (localView == null) {
          break label94;
        }
        localMap.put(paramString, new WeakReference(localView));
        if ((!"1098".equals(paramString)) && (!"3011".equals(paramString)))
        {
          localView.setOnTouchListener(this);
          localView.setClickable(true);
          localView.setOnClickListener(this);
          return;
        }
      }
      return;
      label94:
      localMap.remove(paramString);
    }
  }
  
  public final Map b()
  {
    try
    {
      Map localMap = this.c;
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
    this.e.a((View)com.google.android.gms.dynamic.e.a(parama));
  }
  
  public final View c()
  {
    return this.h;
  }
  
  public final void onClick(View paramView)
  {
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      synchronized (this.g)
      {
        localObject2 = this.e;
        if (localObject2 == null) {
          return;
        }
        ((t)localObject2).d();
        localObject2 = new Bundle();
        ((Bundle)localObject2).putFloat("x", a(this.d.x));
        ((Bundle)localObject2).putFloat("y", a(this.d.y));
        ((Bundle)localObject2).putFloat("start_x", a(this.j.x));
        ((Bundle)localObject2).putFloat("start_y", a(this.j.y));
        localObject3 = this.f;
        if (localObject3 == null)
        {
          this.e.a(paramView, this.c, (Bundle)localObject2, this.h);
          return;
        }
      }
      if (localObject3.equals(paramView))
      {
        localObject3 = this.e;
        if (!(localObject3 instanceof s)) {
          ((t)localObject3).a(paramView, "1007", (Bundle)localObject2, this.c, this.h, false);
        } else if (((s)localObject3).i() != null) {
          ((s)this.e).i().a(paramView, "1007", (Bundle)localObject2, this.c, this.h, false);
        }
      }
    }
  }
  
  public final void onGlobalLayout()
  {
    synchronized (this.g)
    {
      t localt = this.e;
      if (localt != null) {
        localt.b(this.h, this.c);
      }
      return;
    }
  }
  
  public final void onScrollChanged()
  {
    synchronized (this.g)
    {
      t localt = this.e;
      if (localt != null) {
        localt.b(this.h, this.c);
      }
      return;
    }
  }
  
  public final boolean onTouch(View arg1, MotionEvent paramMotionEvent)
  {
    synchronized (this.g)
    {
      if (this.e != null)
      {
        Object localObject = new int[2];
        this.h.getLocationOnScreen((int[])localObject);
        float f1 = paramMotionEvent.getRawX();
        int k = localObject[0];
        float f2 = paramMotionEvent.getRawY();
        int m = localObject[1];
        localObject = new Point((int)(f1 - k), (int)(f2 - m));
        this.d = ((Point)localObject);
        if (paramMotionEvent.getAction() != 0)
        {
          paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
          paramMotionEvent.setLocation(((Point)localObject).x, ((Point)localObject).y);
          this.e.a(paramMotionEvent);
          paramMotionEvent.recycle();
          return false;
        }
        this.j = ((Point)localObject);
      }
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/formats/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */