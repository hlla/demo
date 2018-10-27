package com.google.android.gms.ads.internal.formats;

import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.a.ax;
import com.google.android.gms.ads.internal.formats.a.f;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.k;
import com.google.android.gms.ads.internal.webview.AdWebViewFactory;
import com.google.android.gms.ads.internal.webview.au;
import com.google.android.gms.ads.internal.webview.i;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public class x
  implements t
{
  public final v a;
  public final u b;
  public final Context c;
  public boolean d;
  public boolean e;
  public al f;
  private boolean g = false;
  private long h = 0L;
  private long i = 0L;
  private final JSONObject j;
  private final b k;
  private WeakReference l = null;
  private final Object m = new Object();
  private final com.google.android.gms.ads.internal.renderer.a.u n;
  private final com.google.android.gms.ads.internal.zxxz.aa o;
  private String p;
  private final VersionInfoParcel q;
  
  public x(Context paramContext, u paramu, com.google.android.gms.ads.internal.renderer.a.u paramu1, com.google.android.gms.ads.internal.zxxz.aa paramaa, JSONObject paramJSONObject, v paramv, VersionInfoParcel paramVersionInfoParcel, String paramString)
  {
    this.c = paramContext;
    this.b = paramu;
    this.n = paramu1;
    this.o = paramaa;
    this.j = paramJSONObject;
    this.a = paramv;
    this.q = paramVersionInfoParcel;
    this.p = paramString;
    this.k = new b(this.n);
  }
  
  private final int a(int paramInt)
  {
    com.google.android.gms.ads.internal.util.client.a locala = com.google.android.gms.ads.internal.client.u.h.a;
    return com.google.android.gms.ads.internal.util.client.a.b(this.c, paramInt);
  }
  
  private final JSONObject a(Rect paramRect)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("width", a(paramRect.right - paramRect.left));
    localJSONObject.put("height", a(paramRect.bottom - paramRect.top));
    localJSONObject.put("x", a(paramRect.left));
    localJSONObject.put("y", a(paramRect.top));
    localJSONObject.put("relative_to", "self");
    return localJSONObject;
  }
  
  private final JSONObject a(Map paramMap, View paramView)
  {
    JSONObject localJSONObject1 = new JSONObject();
    if ((paramMap != null) && (paramView != null))
    {
      int[] arrayOfInt1 = f(paramView);
      for (;;)
      {
        JSONObject localJSONObject2;
        try
        {
          Iterator localIterator = paramMap.entrySet().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          View localView = (View)((WeakReference)localEntry.getValue()).get();
          if (localView == null) {
            continue;
          }
          int[] arrayOfInt2 = f(localView);
          localJSONObject2 = new JSONObject();
          paramView = new JSONObject();
          try
          {
            paramView.put("width", a(localView.getMeasuredWidth()));
            paramView.put("height", a(localView.getMeasuredHeight()));
            paramView.put("x", a(arrayOfInt2[0] - arrayOfInt1[0]));
            paramView.put("y", a(arrayOfInt2[1] - arrayOfInt1[1]));
            paramView.put("relative_to", "ad_view");
            localJSONObject2.put("frame", paramView);
            paramView = new Rect();
            if (localView.getLocalVisibleRect(paramView)) {
              break label383;
            }
            paramView = new JSONObject();
            paramView.put("width", 0);
            paramView.put("height", 0);
            paramView.put("x", a(arrayOfInt2[0] - arrayOfInt1[0]));
            paramView.put("y", a(arrayOfInt2[1] - arrayOfInt1[1]));
            paramView.put("relative_to", "ad_view");
            localJSONObject2.put("visible_bounds", paramView);
            if ((localView instanceof TextView)) {
              break label337;
            }
            localJSONObject1.put((String)localEntry.getKey(), localJSONObject2);
          }
          catch (JSONException paramView)
          {
            com.google.android.gms.ads.internal.util.e.e("Unable to get asset views information");
          }
          continue;
          paramView = (TextView)localView;
        }
        finally {}
        label337:
        localJSONObject2.put("text_color", paramView.getCurrentTextColor());
        localJSONObject2.put("font_size", paramView.getTextSize());
        localJSONObject2.put("text", paramView.getText());
        continue;
        label383:
        paramView = a(paramView);
      }
      return localJSONObject1;
    }
    return localJSONObject1;
  }
  
  private final void a(View paramView, JSONObject paramJSONObject1, JSONObject paramJSONObject2, JSONObject paramJSONObject3, JSONObject paramJSONObject4, String paramString, JSONObject paramJSONObject5, JSONObject paramJSONObject6, boolean paramBoolean)
  {
    com.google.android.gms.common.internal.z.a("Invalid call from a non-UI thread.");
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("ad", this.j);
        if (paramJSONObject2 != null) {
          localJSONObject.put("asset_view_signal", paramJSONObject2);
        }
        if (paramJSONObject1 != null) {
          localJSONObject.put("ad_view_signal", paramJSONObject1);
        }
        if (paramJSONObject5 != null) {
          localJSONObject.put("click_signal", paramJSONObject5);
        }
        if (paramJSONObject3 == null) {
          break label542;
        }
        localJSONObject.put("scroll_view_signal", paramJSONObject3);
      }
      catch (JSONException paramView)
      {
        long l1;
        com.google.android.gms.ads.internal.util.e.c("Unable to create click JSON.", paramView);
        return;
      }
      paramJSONObject1 = new JSONObject();
      l1 = bt.A.l.a();
      paramJSONObject1.put("time_from_last_touch_down", l1 - this.h);
      paramJSONObject1.put("time_from_last_touch", l1 - this.i);
      localJSONObject.put("touch_signal", paramJSONObject1);
      paramJSONObject3 = new JSONObject();
      paramJSONObject3.put("asset_id", paramString);
      paramJSONObject3.put("template", this.a.b());
      paramJSONObject1 = bt.A.g;
      paramJSONObject3.put("is_privileged_process", com.google.android.gms.ads.internal.util.v.e());
      if (!((Boolean)com.google.android.gms.ads.internal.f.n.O.a()).booleanValue())
      {
        paramJSONObject3.put("timestamp", l1);
        if (this.b.c(this.a.c()) != null)
        {
          bool = true;
          paramJSONObject3.put("has_custom_click_handler", bool);
          if ((this.g) && (b())) {
            paramJSONObject3.put("custom_click_gesture_eligible", true);
          }
          if (paramBoolean) {
            paramJSONObject3.put("is_custom_click_gesture", true);
          }
          if (this.b.c(this.a.c()) != null)
          {
            paramBoolean = true;
            localJSONObject.put("has_custom_click_handler", paramBoolean);
          }
        }
      }
      try
      {
        paramJSONObject2 = this.j.optJSONObject("tracking_urls_and_actions");
        paramJSONObject1 = paramJSONObject2;
        if (paramJSONObject2 == null) {
          paramJSONObject1 = new JSONObject();
        }
        paramJSONObject1 = paramJSONObject1.optString("click_string");
        paramJSONObject3.put("click_signals", this.o.e.a(this.c, paramJSONObject1, paramView));
      }
      catch (Exception paramView)
      {
        com.google.android.gms.ads.internal.util.e.c("Exception obtaining click signals", paramView);
        continue;
      }
      localJSONObject.put("click", paramJSONObject3);
      if (paramJSONObject6 == null)
      {
        localJSONObject.put("ads_id", this.p);
        com.google.android.gms.ads.internal.util.a.e.a(this.n.b(localJSONObject), "NativeAdEngineImpl.performClick");
        return;
      }
      localJSONObject.put("provided_signals", paramJSONObject6);
      continue;
      paramBoolean = false;
      continue;
      boolean bool = false;
      continue;
      if ((this.k.e != null) && (this.j.optBoolean("custom_one_point_five_click_enabled", false)))
      {
        paramJSONObject3.put("custom_one_point_five_click_eligible", true);
        continue;
        label542:
        do
        {
          localJSONObject.put("lock_screen_signal", paramJSONObject4);
          break;
        } while (paramJSONObject4 != null);
      }
    }
  }
  
  private final boolean a(String paramString)
  {
    boolean bool = false;
    JSONObject localJSONObject = this.j;
    if (localJSONObject != null) {}
    for (localJSONObject = localJSONObject.optJSONObject("allow_pub_event_reporting");; localJSONObject = null)
    {
      if (localJSONObject != null) {
        bool = localJSONObject.optBoolean(paramString, false);
      }
      return bool;
    }
  }
  
  private final boolean a(JSONObject paramJSONObject1, JSONObject paramJSONObject2, JSONObject paramJSONObject3, JSONObject paramJSONObject4, JSONObject paramJSONObject5)
  {
    com.google.android.gms.common.internal.z.a("Invalid call from a non-UI thread.");
    if (!this.e) {
      this.e = true;
    }
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("ad", this.j);
        localJSONObject.put("ads_id", this.p);
        if (paramJSONObject2 != null) {
          localJSONObject.put("asset_view_signal", paramJSONObject2);
        }
        if (paramJSONObject1 != null) {
          localJSONObject.put("ad_view_signal", paramJSONObject1);
        }
        if (paramJSONObject3 != null) {
          localJSONObject.put("scroll_view_signal", paramJSONObject3);
        }
        if (paramJSONObject4 == null) {
          break label175;
        }
        localJSONObject.put("lock_screen_signal", paramJSONObject4);
      }
      catch (JSONException paramJSONObject1)
      {
        JSONObject localJSONObject;
        com.google.android.gms.ads.internal.util.e.c("Unable to create impression JSON.", paramJSONObject1);
        return false;
      }
      com.google.android.gms.ads.internal.util.a.e.a(this.n.c(localJSONObject), "NativeAdEngineImpl.recordImpression");
      this.b.a(this);
      this.b.v();
      m();
      return true;
      localJSONObject.put("provided_signals", paramJSONObject5);
      continue;
      label175:
      if (paramJSONObject5 != null) {}
    }
  }
  
  private static boolean e(View paramView)
  {
    return (paramView.isShown()) && (paramView.getGlobalVisibleRect(new Rect(), null));
  }
  
  private static int[] f(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt;
  }
  
  private final JSONObject g(View paramView)
  {
    localJSONObject = new JSONObject();
    if (paramView != null) {
      try
      {
        int[] arrayOfInt = f(paramView);
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("width", a(paramView.getMeasuredWidth()));
        ((JSONObject)localObject).put("height", a(paramView.getMeasuredHeight()));
        ((JSONObject)localObject).put("x", a(arrayOfInt[0]));
        ((JSONObject)localObject).put("y", a(arrayOfInt[1]));
        ((JSONObject)localObject).put("relative_to", "window");
        localJSONObject.put("frame", localObject);
        localObject = new Rect();
        if (!paramView.getGlobalVisibleRect((Rect)localObject))
        {
          paramView = new JSONObject();
          paramView.put("width", 0);
          paramView.put("height", 0);
          paramView.put("x", a(arrayOfInt[0]));
          paramView.put("y", a(arrayOfInt[1]));
          paramView.put("relative_to", "window");
        }
        for (;;)
        {
          localJSONObject.put("visible_bounds", paramView);
          return localJSONObject;
          paramView = a((Rect)localObject);
        }
        return localJSONObject;
      }
      catch (Exception paramView)
      {
        com.google.android.gms.ads.internal.util.e.e("Unable to get native ad view bounding box");
      }
    }
  }
  
  private static JSONObject h(View paramView)
  {
    localJSONObject = new JSONObject();
    if (paramView != null) {}
    try
    {
      com.google.android.gms.ads.internal.util.n localn = bt.A.e;
      if (com.google.android.gms.ads.internal.util.n.e(paramView) != -1) {}
      for (boolean bool = true;; bool = false)
      {
        localJSONObject.put("contained_in_scroll_view", bool);
        return localJSONObject;
      }
      return localJSONObject;
    }
    catch (Exception paramView) {}
  }
  
  private final JSONObject i(View paramView)
  {
    boolean bool2 = false;
    JSONObject localJSONObject = new JSONObject();
    if (paramView != null) {}
    try
    {
      com.google.android.gms.ads.internal.util.n localn = bt.A.e;
      localJSONObject.put("can_show_on_lock_screen", com.google.android.gms.ads.internal.util.n.d(paramView));
      paramView = bt.A.e;
      paramView = this.c;
      boolean bool1 = bool2;
      if (paramView != null)
      {
        paramView = com.google.android.gms.ads.internal.util.n.k(paramView);
        bool1 = bool2;
        if (paramView != null)
        {
          bool1 = bool2;
          if (paramView.isKeyguardLocked()) {
            bool1 = true;
          }
        }
      }
      localJSONObject.put("is_keyguard_locked", bool1);
      return localJSONObject;
    }
    catch (JSONException paramView)
    {
      com.google.android.gms.ads.internal.util.e.e("Unable to get lock screen information");
    }
    return localJSONObject;
  }
  
  public View a(View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    Object localObject = this.a.d();
    if (localObject != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      if (!paramBoolean) {
        switch (((a)localObject).d)
        {
        case 1: 
        default: 
          localLayoutParams.addRule(10);
          localLayoutParams.addRule(11);
        }
      }
      for (;;)
      {
        localObject = new d(this.c, (a)localObject, localLayoutParams);
        ((d)localObject).setOnClickListener(paramOnClickListener);
        ((d)localObject).setContentDescription((CharSequence)com.google.android.gms.ads.internal.f.n.c.a());
        return (View)localObject;
        localLayoutParams.addRule(12);
        localLayoutParams.addRule(9);
        continue;
        localLayoutParams.addRule(12);
        localLayoutParams.addRule(11);
        continue;
        localLayoutParams.addRule(10);
        localLayoutParams.addRule(9);
      }
    }
    return null;
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    this.i = bt.A.l.a();
    if (paramMotionEvent.getAction() == 0) {
      this.h = bt.A.l.a();
    }
    this.o.a(paramMotionEvent);
  }
  
  public void a(View paramView)
  {
    if (((Boolean)com.google.android.gms.ads.internal.f.n.O.a()).booleanValue())
    {
      if (this.j.optBoolean("custom_one_point_five_click_enabled", false)) {
        break label36;
      }
      com.google.android.gms.ads.internal.util.e.e("setClickConfirmingView: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
    }
    label36:
    b localb;
    do
    {
      return;
      localb = this.k;
    } while (paramView == null);
    paramView.setOnClickListener(localb);
    paramView.setClickable(true);
    localb.a = new WeakReference(paramView);
  }
  
  public final void a(View paramView, r paramr)
  {
    FrameLayout localFrameLayout;
    if (!b(paramView, paramr))
    {
      paramr = new FrameLayout.LayoutParams(-1, -1);
      localFrameLayout = (FrameLayout)paramView;
      localFrameLayout.removeAllViews();
      paramView = this.a;
      if ((paramView instanceof w))
      {
        paramView = (w)paramView;
        if ((paramView.f() != null) && (paramView.f().size() > 0))
        {
          paramView = paramView.f().get(0);
          if (!(paramView instanceof IBinder)) {
            break label154;
          }
        }
      }
    }
    for (paramView = f.a((IBinder)paramView);; paramView = null)
    {
      if (paramView != null) {}
      try
      {
        paramView = paramView.a();
        if (paramView != null)
        {
          paramView = (Drawable)com.google.android.gms.dynamic.e.a(paramView);
          ImageView localImageView = new ImageView(this.c);
          localImageView.setImageDrawable(paramView);
          localImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          localFrameLayout.addView(localImageView, paramr);
        }
        return;
      }
      catch (RemoteException paramView)
      {
        label154:
        com.google.android.gms.ads.internal.util.e.e("Could not get drawable from image");
      }
    }
  }
  
  public final void a(View paramView1, String paramString, Bundle paramBundle, Map paramMap, View paramView2, boolean paramBoolean)
  {
    JSONObject localJSONObject1 = a(paramMap, paramView2);
    JSONObject localJSONObject2 = g(paramView2);
    JSONObject localJSONObject3 = h(paramView2);
    paramView2 = i(paramView2);
    for (;;)
    {
      try
      {
        paramMap = bt.A.e.a(paramBundle);
        paramBundle = new JSONObject();
        com.google.android.gms.ads.internal.util.e.c("Error occurred while grabbing click signals.", paramMap);
      }
      catch (Exception paramMap)
      {
        try
        {
          paramBundle.put("click_point", paramMap);
          paramBundle.put("asset_id", paramString);
          a(paramView1, localJSONObject2, localJSONObject1, localJSONObject3, paramView2, paramString, paramBundle, null, paramBoolean);
          return;
        }
        catch (Exception paramMap)
        {
          for (;;) {}
        }
        paramMap = paramMap;
        paramBundle = null;
      }
    }
  }
  
  public void a(View paramView, Map paramMap)
  {
    a(g(paramView), a(paramMap, paramView), h(paramView), i(paramView), null);
  }
  
  public void a(View paramView1, Map paramMap, Bundle paramBundle, View paramView2)
  {
    com.google.android.gms.common.internal.z.a("Invalid call from a non-UI thread.");
    if (paramMap != null) {}
    try
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (paramView1.equals((View)((WeakReference)localEntry.getValue()).get()))
        {
          a(paramView1, (String)localEntry.getKey(), paramBundle, paramMap, paramView2, false);
          return;
        }
      }
      if ("6".equals(this.a.b()))
      {
        a(paramView1, "3099", paramBundle, paramMap, paramView2, false);
        return;
      }
      if ("2".equals(this.a.b()))
      {
        a(paramView1, "2099", paramBundle, paramMap, paramView2, false);
        return;
      }
      if ("1".equals(this.a.b()))
      {
        a(paramView1, "1099", paramBundle, paramMap, paramView2, false);
        return;
      }
    }
    finally {}
  }
  
  public void a(View paramView, Map paramMap1, Map paramMap2, View.OnTouchListener paramOnTouchListener, View.OnClickListener paramOnClickListener)
  {
    paramView.setOnTouchListener(paramOnTouchListener);
    paramView.setClickable(true);
    paramView.setOnClickListener(paramOnClickListener);
    if (paramMap1 != null) {
      try
      {
        paramView = paramMap1.entrySet().iterator();
        while (paramView.hasNext())
        {
          View localView = (View)((WeakReference)((Map.Entry)paramView.next()).getValue()).get();
          if (localView != null)
          {
            localView.setOnTouchListener(paramOnTouchListener);
            localView.setClickable(true);
            localView.setOnClickListener(paramOnClickListener);
          }
        }
      }
      finally {}
    }
    if (paramMap2 != null) {
      try
      {
        paramView = paramMap2.entrySet().iterator();
        while (paramView.hasNext())
        {
          paramMap1 = (View)((WeakReference)((Map.Entry)paramView.next()).getValue()).get();
          if (paramMap1 != null) {
            paramMap1.setOnTouchListener(paramOnTouchListener);
          }
        }
      }
      finally {}
    }
  }
  
  public void a(ax paramax)
  {
    if (((Boolean)com.google.android.gms.ads.internal.f.n.O.a()).booleanValue())
    {
      if (!this.j.optBoolean("custom_one_point_five_click_enabled", false)) {
        com.google.android.gms.ads.internal.util.e.e("setUnconfirmedClickListener: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
      }
    }
    else {
      return;
    }
    b localb = this.k;
    localb.e = paramax;
    paramax = localb.c;
    if (paramax != null) {
      localb.b.b("/unconfirmedClick", paramax);
    }
    localb.c = new c(localb);
    localb.b.a("/unconfirmedClick", localb.c);
  }
  
  public boolean a()
  {
    a locala = this.a.d();
    return (locala != null) && (locala.a);
  }
  
  public final boolean a(Bundle paramBundle)
  {
    if (!a("impression_reporting"))
    {
      com.google.android.gms.ads.internal.util.e.c("The ad slot cannot handle external impression events. You must be whitelisted to whitelisted to be able to report your impression events.");
      return false;
    }
    return a(null, null, null, null, bt.A.e.a(paramBundle));
  }
  
  public final void b(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (!a("click_reporting"))
      {
        com.google.android.gms.ads.internal.util.e.c("The ad slot cannot handle external click events. You must be whitelisted to be able to report your click events.");
        return;
      }
      a(null, null, null, null, null, paramBundle.getBundle("click_signal").getString("asset_id"), null, bt.A.e.a(paramBundle), false);
      return;
    }
    com.google.android.gms.ads.internal.util.e.b("Click data is null. No click is reported.");
  }
  
  public void b(View paramView) {}
  
  public final void b(View paramView, Map paramMap)
  {
    for (;;)
    {
      synchronized (this.m)
      {
        if (this.e) {
          break label142;
        }
        if (e(paramView)) {
          break;
        }
        if (!((Boolean)com.google.android.gms.ads.internal.f.n.F.a()).booleanValue()) {
          return;
        }
        if (paramMap == null) {
          continue;
        }
      }
      try
      {
        Iterator localIterator = paramMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          View localView = (View)((WeakReference)((Map.Entry)localIterator.next()).getValue()).get();
          if ((localView != null) && (e(localView)))
          {
            a(paramView, paramMap);
            return;
            paramView = finally;
            throw paramView;
          }
        }
      }
      finally {}
    }
    a(paramView, paramMap);
    return;
    label142:
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    JSONObject localJSONObject = this.j;
    boolean bool1 = bool2;
    if (localJSONObject != null)
    {
      bool1 = bool2;
      if (localJSONObject.optBoolean("allow_custom_click_gesture", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean b(View paramView, r paramr)
  {
    if (((Boolean)com.google.android.gms.ads.internal.f.n.am.a()).booleanValue()) {}
    for (FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1, 17);; localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 17))
    {
      View localView = this.a.e();
      if (localView != null)
      {
        ViewParent localViewParent = localView.getParent();
        if ((localViewParent instanceof ViewGroup)) {
          ((ViewGroup)localViewParent).removeView(localView);
        }
        paramView = (FrameLayout)paramView;
        paramView.removeAllViews();
        paramView.addView(localView, localLayoutParams);
        this.b.a(paramr);
        return true;
      }
      return false;
    }
  }
  
  public final void c(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (!a("touch_reporting"))
      {
        com.google.android.gms.ads.internal.util.e.c("The ad slot cannot handle external touch events. You must be whitelisted to be able to report your touch events.");
        return;
      }
      float f1 = paramBundle.getFloat("x");
      float f2 = paramBundle.getFloat("y");
      int i1 = paramBundle.getInt("duration_ms");
      this.o.e.a((int)f1, (int)f2, i1);
      return;
    }
    com.google.android.gms.ads.internal.util.e.b("Touch event data is null. No touch event is reported.");
  }
  
  public final void c(View paramView)
  {
    if (((Boolean)com.google.android.gms.ads.internal.f.n.bN.a()).booleanValue())
    {
      Object localObject = this.o;
      if (localObject != null)
      {
        localObject = ((com.google.android.gms.ads.internal.zxxz.aa)localObject).e;
        if (localObject != null) {
          ((com.google.android.gms.ads.internal.zxxz.v)localObject).a(paramView);
        }
      }
    }
  }
  
  public boolean c()
  {
    boolean bool2 = false;
    JSONObject localJSONObject = this.j;
    boolean bool1 = bool2;
    if (localJSONObject != null)
    {
      bool1 = bool2;
      if (localJSONObject.optBoolean("allow_pub_owned_ad_view", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void d()
  {
    b localb;
    if ((((Boolean)com.google.android.gms.ads.internal.f.n.O.a()).booleanValue()) && (this.j.optBoolean("custom_one_point_five_click_enabled", false)))
    {
      localb = this.k;
      if ((localb.e != null) && (localb.f != null)) {
        localb.a();
      }
    }
    try
    {
      localb.e.a();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      k.f("#007 Could not call remote method.", localRemoteException);
    }
  }
  
  public final void d(View paramView)
  {
    this.l = new WeakReference(paramView);
  }
  
  public void e()
  {
    com.google.android.gms.common.internal.z.a("Invalid call from a non-UI thread.");
    if (!this.d) {
      this.d = true;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ad", this.j);
      localJSONObject.put("ads_id", this.p);
      com.google.android.gms.ads.internal.util.a.e.a(this.n.d(localJSONObject), "NativeAdEngineImpl.recordDownloadedImpression");
      return;
    }
    catch (JSONException localJSONException)
    {
      k.c("", localJSONException);
    }
  }
  
  public void f()
  {
    this.g = true;
  }
  
  public void g()
  {
    if (this.f == null)
    {
      com.google.android.gms.ads.internal.util.e.b("Ad should be associated with an ad view before calling recordCustomClickGesture()");
      return;
    }
    if (!this.g)
    {
      com.google.android.gms.ads.internal.util.e.b("Custom click reporting failed. enableCustomClickGesture is not set.");
      return;
    }
    if (!b())
    {
      com.google.android.gms.ads.internal.util.e.b("Custom click reporting failed. Ad unit id not whitelisted.");
      return;
    }
    a(this.f.c(), "3099", null, this.f.b(), this.f.c(), true);
  }
  
  public i j()
  {
    Object localObject2 = null;
    Object localObject3 = this.j;
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((JSONObject)localObject3).optJSONObject("overlay") != null)
      {
        localObject1 = bt.A.f;
        localObject1 = this.c;
        localObject2 = AdSizeParcel.a();
        localObject3 = this.o;
        Object localObject4 = this.q;
        localObject2 = AdWebViewFactory.a((Context)localObject1, au.a((AdSizeParcel)localObject2), ((AdSizeParcel)localObject2).a, false, false, (com.google.android.gms.ads.internal.zxxz.aa)localObject3, (VersionInfoParcel)localObject4, null, null, null, com.google.android.gms.ads.internal.d.a.a());
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          ((i)localObject2).getView().setVisibility(8);
          localObject3 = new z((i)localObject2);
          localObject4 = this.n;
          ((com.google.android.gms.ads.internal.renderer.a.u)localObject4).a("/loadHtml", new aa((z)localObject3, (com.google.android.gms.ads.internal.renderer.a.u)localObject4));
          ((com.google.android.gms.ads.internal.renderer.a.u)localObject4).a("/showOverlay", new ac((z)localObject3, (com.google.android.gms.ads.internal.renderer.a.u)localObject4));
          ((com.google.android.gms.ads.internal.renderer.a.u)localObject4).a("/hideOverlay", new ad((z)localObject3, (com.google.android.gms.ads.internal.renderer.a.u)localObject4));
          i locali = (i)((z)localObject3).b.get();
          localObject1 = localObject2;
          if (locali != null)
          {
            locali.a("/sendMessageToSdk", new ae((z)localObject3, (com.google.android.gms.ads.internal.renderer.a.u)localObject4));
            localObject1 = localObject2;
          }
        }
      }
    }
    return (i)localObject1;
  }
  
  public void k()
  {
    this.n.a();
  }
  
  public void l()
  {
    this.b.U();
  }
  
  public void m()
  {
    this.b.S();
  }
  
  public void n()
  {
    this.b.T();
  }
  
  public final View o()
  {
    WeakReference localWeakReference = this.l;
    if (localWeakReference != null) {
      return (View)localWeakReference.get();
    }
    return null;
  }
  
  public final Context p()
  {
    return this.c;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/formats/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */