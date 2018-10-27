package com.google.android.gms.ads.internal.m;

import android.app.Activity;
import android.support.v4.g.c;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.client.u;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.ads.internal.webview.au;
import com.google.android.gms.ads.internal.webview.i;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public final class d
  extends m
{
  public au a;
  public final i b;
  public boolean c = true;
  public LinearLayout d;
  public final Activity e;
  public String f = "top-right";
  public int g = -1;
  public ImageView h;
  public RelativeLayout i;
  public final Object j = new Object();
  public n k;
  public int l = 0;
  public int m = 0;
  public ViewGroup n;
  public int o = -1;
  public PopupWindow p;
  private int q = 0;
  private int r = 0;
  
  static
  {
    c localc = new c(7);
    Collections.addAll(localc, new String[] { "top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center" });
    Collections.unmodifiableSet(localc);
  }
  
  public d(i parami, n paramn)
  {
    super(parami, "resize");
    this.b = parami;
    this.e = parami.getActivityContext();
    this.k = paramn;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    Object localObject = bt.A.e;
    int i1 = com.google.android.gms.ads.internal.util.n.c(this.e)[0];
    int i2 = this.o;
    int i3 = this.g;
    try
    {
      localObject = new JSONObject().put("x", paramInt1).put("y", paramInt2 - i1).put("width", i2).put("height", i3);
      this.b.a("onSizeChanged", (JSONObject)localObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      e.c("Error occured while dispatching size change.", localJSONException);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    synchronized (this.j)
    {
      this.q = paramInt1;
      this.r = paramInt2;
      if ((this.p != null) && (paramBoolean))
      {
        int[] arrayOfInt = a();
        if (arrayOfInt != null)
        {
          PopupWindow localPopupWindow = this.p;
          com.google.android.gms.ads.internal.util.client.a locala = u.h.a;
          paramInt1 = com.google.android.gms.ads.internal.util.client.a.a(this.e, arrayOfInt[0]);
          locala = u.h.a;
          localPopupWindow.update(paramInt1, com.google.android.gms.ads.internal.util.client.a.a(this.e, arrayOfInt[1]), this.p.getWidth(), this.p.getHeight());
          a(arrayOfInt[0], arrayOfInt[1]);
        }
      }
      else
      {
        return;
      }
      a(true);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    for (;;)
    {
      synchronized (this.j)
      {
        Object localObject2 = this.p;
        if (localObject2 == null) {
          return;
        }
        ((PopupWindow)localObject2).dismiss();
        this.i.removeView(this.b.getView());
        localObject2 = this.n;
        if (localObject2 != null)
        {
          ((ViewGroup)localObject2).removeView(this.h);
          this.n.addView(this.b.getView());
          this.b.setAdSize(this.a);
        }
        if (paramBoolean)
        {
          b("default");
          localObject2 = this.k;
          if (localObject2 != null) {}
        }
        else
        {
          this.p = null;
          this.i = null;
          this.n = null;
          this.d = null;
        }
      }
      ((n)localObject3).W();
    }
  }
  
  public final int[] a()
  {
    Object localObject1 = bt.A.e;
    localObject1 = com.google.android.gms.ads.internal.util.n.b(this.e);
    Object localObject2 = bt.A.e;
    localObject2 = com.google.android.gms.ads.internal.util.n.c(this.e);
    int i3 = localObject1[0];
    int i1 = localObject1[1];
    int i2 = this.o;
    if (i2 < 50) {
      e.e("Width is too small or too large.");
    }
    for (;;)
    {
      return null;
      if (i2 > i3) {
        break;
      }
      int i4 = this.g;
      if (i4 < 50) {}
      while (i4 > i1)
      {
        e.e("Height is too small or too large.");
        break;
      }
      if (i4 != i1) {}
      label180:
      while (i2 != i3)
      {
        boolean bool = this.c;
        if (bool)
        {
          localObject1 = this.f;
          switch (((String)localObject1).hashCode())
          {
          default: 
            i1 = -1;
          }
        }
        for (;;)
        {
          switch (i1)
          {
          default: 
            i2 = this.q + this.l + i2 - 50;
            i1 = this.r + this.m;
          }
          while ((i2 >= 0) && (i2 + 50 <= i3) && (i1 >= localObject2[0]) && (i1 + 50 <= localObject2[1]))
          {
            if (!bool)
            {
              localObject1 = bt.A.e;
              localObject1 = com.google.android.gms.ads.internal.util.n.b(this.e);
              localObject2 = bt.A.e;
              localObject2 = com.google.android.gms.ads.internal.util.n.c(this.e);
              i4 = localObject1[0];
              i2 = this.q + this.l;
              i3 = this.r + this.m;
              int i5;
              if (i2 >= 0)
              {
                i5 = this.o;
                i1 = i2;
                if (i2 + i5 <= i4) {}
              }
              for (i1 = i4 - i5;; i1 = 0)
              {
                i2 = localObject2[0];
                if (i3 >= i2)
                {
                  i4 = this.g;
                  i5 = localObject2[1];
                  i2 = i3;
                  if (i3 + i4 > i5) {
                    i2 = i5 - i4;
                  }
                }
                for (;;)
                {
                  return new int[] { i1, i2 };
                }
              }
            }
            return new int[] { this.q + this.l, this.r + this.m };
            i2 = this.q + this.l + i2 - 50;
            i1 = this.r + this.m + i4 - 50;
            continue;
            i2 = this.q + this.l + i2 / 2 - 25;
            i1 = this.r + this.m + i4 - 50;
            continue;
            i1 = this.q;
            i2 = this.l + i1;
            i1 = this.r + this.m + i4 - 50;
            continue;
            i2 = this.q + this.l + i2 / 2 - 25;
            i1 = this.r + this.m + i4 / 2 - 25;
            continue;
            i2 = this.q + this.l + i2 / 2 - 25;
            i1 = this.r + this.m;
            continue;
            i1 = this.q;
            i2 = this.l + i1;
            i1 = this.r + this.m;
          }
          if (!((String)localObject1).equals("top-center")) {
            break label180;
          }
          i1 = 1;
          continue;
          if (!((String)localObject1).equals("bottom-center")) {
            break label180;
          }
          i1 = 4;
          continue;
          if (!((String)localObject1).equals("bottom-right")) {
            break label180;
          }
          i1 = 5;
          continue;
          if (!((String)localObject1).equals("bottom-left")) {
            break label180;
          }
          i1 = 3;
          continue;
          if (!((String)localObject1).equals("top-left")) {
            break label180;
          }
          i1 = 0;
          continue;
          if (!((String)localObject1).equals("center")) {
            break label180;
          }
          i1 = 2;
        }
      }
      e.e("Cannot resize to a full-screen ad.");
    }
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    this.q = paramInt1;
    this.r = paramInt2;
  }
  
  public final boolean b()
  {
    for (;;)
    {
      synchronized (this.j)
      {
        if (this.p != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/m/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */