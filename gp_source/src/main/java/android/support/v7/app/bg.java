package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ac;
import android.support.v4.view.az;
import android.support.v4.view.bc;
import android.support.v4.view.be;
import android.support.v7.view.b;
import android.support.v7.view.l;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.h;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class bg
  extends a
  implements h
{
  private static final Interpolator A = new AccelerateInterpolator();
  private static final Interpolator B = new DecelerateInterpolator();
  public bk a;
  public ActionBarContainer b;
  public boolean c;
  public View d;
  public Context e;
  public ActionBarContextView f;
  public l g;
  public android.support.v7.widget.bj h;
  public b i;
  public android.support.v7.view.c j;
  public boolean k;
  public boolean l;
  public boolean m;
  public ActionBarOverlayLayout n;
  private int o;
  private boolean p;
  private boolean q;
  private final bc r;
  private boolean s;
  private ArrayList t;
  private boolean u;
  private boolean v;
  private final bc w;
  private boolean x;
  private Context y;
  private final be z;
  
  public bg(Activity paramActivity, boolean paramBoolean)
  {
    new ArrayList();
    this.t = new ArrayList();
    this.o = 0;
    this.c = true;
    this.u = true;
    this.r = new bh(this);
    this.w = new bi(this);
    this.z = new bj(this);
    paramActivity = paramActivity.getWindow().getDecorView();
    a(paramActivity);
    if (!paramBoolean) {
      this.d = paramActivity.findViewById(16908290);
    }
  }
  
  public bg(Dialog paramDialog)
  {
    new ArrayList();
    this.t = new ArrayList();
    this.o = 0;
    this.c = true;
    this.u = true;
    this.r = new bh(this);
    this.w = new bi(this);
    this.z = new bj(this);
    a(paramDialog.getWindow().getDecorView());
  }
  
  private final void a(View paramView)
  {
    this.n = ((ActionBarOverlayLayout)paramView.findViewById(2131427843));
    Object localObject = this.n;
    if (localObject != null) {
      ((ActionBarOverlayLayout)localObject).setActionBarVisibilityCallback(this);
    }
    View localView = paramView.findViewById(2131427367);
    if ((localView instanceof android.support.v7.widget.bj)) {}
    for (localObject = (android.support.v7.widget.bj)localView;; localObject = ((Toolbar)localView).getWrapper())
    {
      this.h = ((android.support.v7.widget.bj)localObject);
      this.f = ((ActionBarContextView)paramView.findViewById(2131427377));
      this.b = ((ActionBarContainer)paramView.findViewById(2131427369));
      paramView = this.h;
      if ((paramView == null) || (this.f == null) || (this.b == null))
      {
        paramView = new StringBuilder();
        paramView.append(getClass().getSimpleName());
        paramView.append(" can only be used ");
        paramView.append("with a compatible window decor layout");
        throw new IllegalStateException(paramView.toString());
      }
      this.e = paramView.b();
      if ((this.h.o() & 0x4) != 0) {
        this.p = true;
      }
      paramView = android.support.v7.view.a.a(this.e);
      int i1 = paramView.a.getApplicationInfo().targetSdkVersion;
      e();
      g(paramView.b());
      paramView = this.e.obtainStyledAttributes(null, android.support.v7.a.a.a, 2130968581, 0);
      if (paramView.getBoolean(android.support.v7.a.a.m, false)) {
        g();
      }
      i1 = paramView.getDimensionPixelSize(android.support.v7.a.a.k, 0);
      if (i1 != 0) {
        a(i1);
      }
      paramView.recycle();
      return;
      if (!(localView instanceof Toolbar)) {
        break;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Can't make a decor toolbar out of ");
    if (localView != null) {}
    for (paramView = localView.getClass().getSimpleName();; paramView = "null")
    {
      ((StringBuilder)localObject).append(paramView);
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
  }
  
  static boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return (paramBoolean3) || ((!paramBoolean1) && (!paramBoolean2));
  }
  
  private final void g(boolean paramBoolean)
  {
    this.q = paramBoolean;
    if (!this.q)
    {
      this.h.p();
      this.b.setTabContainer(null);
    }
    for (;;)
    {
      this.h.r();
      this.h.a(false);
      this.n.setHasNonEmbeddedTabs(false);
      return;
      this.b.setTabContainer(null);
      this.h.p();
    }
  }
  
  private final void h(boolean paramBoolean)
  {
    if (a(this.k, this.l, this.x)) {
      if (!this.u)
      {
        this.u = true;
        localObject1 = this.g;
        if (localObject1 != null) {
          ((l)localObject1).b();
        }
        this.b.setVisibility(0);
        if (this.o != 0) {
          break label270;
        }
        if (!this.v) {
          break label266;
        }
      }
    }
    float f2;
    float f1;
    Object localObject2;
    label265:
    label266:
    label270:
    while (!this.u)
    {
      break label265;
      this.b.setTranslationY(0.0F);
      f2 = -this.b.getHeight();
      f1 = f2;
      if (paramBoolean)
      {
        localObject1 = new int[2];
        localObject1[0] = 0;
        localObject1[1] = 0;
        this.b.getLocationInWindow((int[])localObject1);
        f1 = f2 - localObject1[1];
      }
      this.b.setTranslationY(f1);
      localObject1 = new l();
      localObject2 = ac.t(this.b).b(0.0F);
      ((az)localObject2).a(this.z);
      ((l)localObject1).a((az)localObject2);
      if (this.c)
      {
        localObject2 = this.d;
        if (localObject2 != null)
        {
          ((View)localObject2).setTranslationY(f1);
          ((l)localObject1).a(ac.t(this.d).b(0.0F));
        }
      }
      ((l)localObject1).a(B);
      ((l)localObject1).c();
      ((l)localObject1).a(this.w);
      this.g = ((l)localObject1);
      ((l)localObject1).a();
      for (;;)
      {
        localObject1 = this.n;
        if (localObject1 != null) {
          ac.x((View)localObject1);
        }
        return;
        if (paramBoolean) {
          break;
        }
        this.b.setAlpha(1.0F);
        this.b.setTranslationY(0.0F);
        if (this.c)
        {
          localObject1 = this.d;
          if (localObject1 != null) {
            ((View)localObject1).setTranslationY(0.0F);
          }
        }
        this.w.a(null);
      }
    }
    this.u = false;
    Object localObject1 = this.g;
    if (localObject1 != null) {
      ((l)localObject1).b();
    }
    if (this.o == 0)
    {
      if (this.v) {}
      while (paramBoolean)
      {
        this.b.setAlpha(1.0F);
        this.b.setTransitioning(true);
        localObject1 = new l();
        f2 = -this.b.getHeight();
        f1 = f2;
        if (paramBoolean)
        {
          localObject2 = new int[2];
          localObject2[0] = 0;
          localObject2[1] = 0;
          this.b.getLocationInWindow((int[])localObject2);
          f1 = f2 - localObject2[1];
        }
        localObject2 = ac.t(this.b).b(f1);
        ((az)localObject2).a(this.z);
        ((l)localObject1).a((az)localObject2);
        if (this.c)
        {
          localObject2 = this.d;
          if (localObject2 != null) {
            ((l)localObject1).a(ac.t((View)localObject2).b(f1));
          }
        }
        ((l)localObject1).a(A);
        ((l)localObject1).c();
        ((l)localObject1).a(this.r);
        this.g = ((l)localObject1);
        ((l)localObject1).a();
        return;
      }
    }
    this.r.a(null);
  }
  
  public final b a(android.support.v7.view.c paramc)
  {
    bk localbk = this.a;
    if (localbk != null) {
      localbk.c();
    }
    this.n.setHideOnContentScrollEnabled(false);
    this.f.b();
    paramc = new bk(this, this.f.getContext(), paramc);
    if (paramc.e())
    {
      this.a = paramc;
      paramc.d();
      this.f.a(paramc);
      f(true);
      this.f.sendAccessibilityEvent(32);
      return paramc;
    }
    return null;
  }
  
  public final void a()
  {
    a(2, 2);
  }
  
  public final void a(float paramFloat)
  {
    ac.g(this.b, paramFloat);
  }
  
  public final void a(int paramInt)
  {
    this.h.d(paramInt);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    int i1 = this.h.o();
    if ((paramInt2 & 0x4) != 0) {
      this.p = true;
    }
    this.h.c(i1 & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public final void a(Drawable paramDrawable)
  {
    this.h.b(paramDrawable);
  }
  
  public final void a(c paramc)
  {
    this.t.add(paramc);
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    this.h.b(paramCharSequence);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (int i1 = 0;; i1 = 4)
    {
      a(i1, 4);
      return;
    }
  }
  
  public final boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    Object localObject = this.a;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = ((b)localObject).b();
      bool1 = bool2;
      if (localObject != null) {
        if (paramKeyEvent == null) {
          break label87;
        }
      }
    }
    label87:
    for (int i1 = paramKeyEvent.getDeviceId();; i1 = -1)
    {
      if (KeyCharacterMap.load(i1).getKeyboardType() != 1) {}
      for (bool1 = true;; bool1 = false)
      {
        ((Menu)localObject).setQwertyMode(bool1);
        bool1 = ((Menu)localObject).performShortcut(paramInt, paramKeyEvent, 0);
        return bool1;
      }
    }
  }
  
  public final int b()
  {
    return this.h.o();
  }
  
  public final void b(int paramInt)
  {
    this.h.e(paramInt);
  }
  
  public final void b(Drawable paramDrawable)
  {
    this.b.setPrimaryBackground(paramDrawable);
  }
  
  public final void b(CharSequence paramCharSequence)
  {
    this.h.c(paramCharSequence);
  }
  
  public final void b(boolean paramBoolean)
  {
    if (!this.p) {
      a(paramBoolean);
    }
  }
  
  public final int c()
  {
    return this.b.getHeight();
  }
  
  public final void c(int paramInt)
  {
    this.o = paramInt;
  }
  
  public final void c(Drawable paramDrawable)
  {
    this.h.c(paramDrawable);
  }
  
  public final void c(CharSequence paramCharSequence)
  {
    this.h.a(paramCharSequence);
  }
  
  public final void c(boolean paramBoolean)
  {
    this.v = paramBoolean;
    if (!paramBoolean)
    {
      l locall = this.g;
      if (locall != null) {
        locall.b();
      }
    }
  }
  
  public final void d()
  {
    if (!this.k)
    {
      this.k = true;
      h(false);
    }
  }
  
  public final void d(boolean paramBoolean)
  {
    if (paramBoolean != this.s)
    {
      this.s = paramBoolean;
      int i2 = this.t.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ((c)this.t.get(i1)).a(paramBoolean);
        i1 += 1;
      }
    }
  }
  
  public final void e()
  {
    this.h.q();
  }
  
  public final void e(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public final Context f()
  {
    int i1;
    if (this.y == null)
    {
      TypedValue localTypedValue = new TypedValue();
      this.e.getTheme().resolveAttribute(2130968586, localTypedValue, true);
      i1 = localTypedValue.resourceId;
      if (i1 == 0) {
        break label61;
      }
    }
    label61:
    for (this.y = new ContextThemeWrapper(this.e, i1);; this.y = this.e) {
      return this.y;
    }
  }
  
  public final void f(boolean paramBoolean)
  {
    Object localObject1;
    if (!paramBoolean) {
      if (this.x)
      {
        this.x = false;
        localObject1 = this.n;
        if (localObject1 != null) {
          ((ActionBarOverlayLayout)localObject1).setShowingForActionMode(false);
        }
        h(false);
      }
    }
    for (;;)
    {
      if (ac.I(this.b))
      {
        Object localObject2;
        if (!paramBoolean)
        {
          localObject1 = this.h.a(0, 200L);
          localObject2 = this.f.a(8, 100L);
        }
        for (;;)
        {
          l locall = new l();
          locall.a.add(localObject2);
          localObject2 = (View)((az)localObject2).a.get();
          if (localObject2 != null) {}
          for (long l1 = ((View)localObject2).animate().getDuration();; l1 = 0L)
          {
            localObject2 = (View)((az)localObject1).a.get();
            if (localObject2 != null) {
              ((View)localObject2).animate().setStartDelay(l1);
            }
            locall.a.add(localObject1);
            locall.a();
            return;
          }
          localObject2 = this.h.a(4, 100L);
          localObject1 = this.f.a(0, 200L);
        }
      }
      if (!paramBoolean)
      {
        this.h.f(0);
        this.f.setVisibility(8);
        return;
      }
      this.h.f(4);
      this.f.setVisibility(0);
      return;
      if (!this.x)
      {
        this.x = true;
        localObject1 = this.n;
        if (localObject1 != null) {
          ((ActionBarOverlayLayout)localObject1).setShowingForActionMode(true);
        }
        h(false);
      }
    }
  }
  
  public final void g()
  {
    ActionBarOverlayLayout localActionBarOverlayLayout = this.n;
    if (!localActionBarOverlayLayout.d) {
      throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }
    this.m = true;
    localActionBarOverlayLayout.setHideOnContentScrollEnabled(true);
  }
  
  public final void h()
  {
    g(android.support.v7.view.a.a(this.e).b());
  }
  
  public final boolean l()
  {
    android.support.v7.widget.bj localbj = this.h;
    if ((localbj != null) && (localbj.c()))
    {
      this.h.d();
      return true;
    }
    return false;
  }
  
  public final void n()
  {
    if (this.l)
    {
      this.l = false;
      h(true);
    }
  }
  
  public final void o()
  {
    if (!this.l)
    {
      this.l = true;
      h(true);
    }
  }
  
  public final void p()
  {
    l locall = this.g;
    if (locall != null)
    {
      locall.b();
      this.g = null;
    }
  }
  
  public final void q() {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */